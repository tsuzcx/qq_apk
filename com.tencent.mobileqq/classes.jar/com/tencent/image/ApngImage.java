package com.tencent.image;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.tencent.image.api.ILog;
import com.tencent.image.api.URLDrawableDepWrap;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.RejectedExecutionException;

public class ApngImage
  implements Runnable
{
  public static final int CAN_PLAY_TAG_AIO = 0;
  private static final boolean DEBUG = false;
  public static int DECRYPTTYPE_DECRYPT = 0;
  public static final int DENSITY_NONE = 0;
  public static final int ERROR_CODE_SUCCESS = 0;
  private static final int IMAGE_INFO_INDEX_CURRENTFRAM = 3;
  private static final int IMAGE_INFO_INDEX_ERRORCODE = 5;
  private static final int IMAGE_INFO_INDEX_FRAMECOUNT = 2;
  private static final int IMAGE_INFO_INDEX_FRAMEDELAY = 4;
  private static final int IMAGE_INFO_INDEX_HEIGHT = 1;
  private static final int IMAGE_INFO_INDEX_PLAYCOUNT = 6;
  private static final int IMAGE_INFO_INDEX_WIDTH = 0;
  private static int IMAGE_SIZE_DISABLE_DOUBLE_BUFFER = 262144;
  public static final String KEY_DECRYPTTYPE = "key_decryptType";
  public static final String KEY_DENSITY = "key_density";
  public static final String KEY_DOUBLE_BITMAP = "key_double_bitmap";
  public static final String KEY_DRAW_ROUND = "key_draw_round";
  public static final String KEY_GET_RESET_LOOP = "key_get_reset_loop";
  public static final String KEY_LOOP = "key_loop";
  public static final String KEY_ONCE_CLEAR = "key_once_clear";
  public static final String KEY_STOP_ON_FIRST = "key_stop_on_first";
  public static final String KEY_TAGID_ARR = "key_tagId_arr";
  public static final String KEY_TAGNAME = "key_name";
  public static final String KEY_USE_FILE_LOOP = "key_use_file_loop";
  public static final String KEY_USE_RECT = "key_use_rect";
  private static final int PENDING_ACTION_CAPACITY = 100;
  private static final String TAG = "ApngImage";
  public static ArrayList<Integer> canDecodeIDs;
  private static ArgumentsRunnable<WeakReference<ApngImage>> sAccumulativeRunnable;
  private static Handler sHandler;
  protected static boolean sPaused;
  protected static final ArrayList<WeakReference<ApngImage>> sPendingActions = new ApngImage.1(105);
  public int apngLoop;
  private boolean cacheFirstFrame;
  private CopyOnWriteArrayList<WeakReference<AnimationCallback>> callbacks;
  protected long contentIndex;
  private Bitmap curFrame;
  public int currentApngLoop;
  protected int currentFrameDelay;
  int decryptType;
  protected File file;
  public Bitmap firstFrame;
  public int height = 0;
  private boolean mDecodeNextFrameEnd;
  protected int mDensity;
  public boolean mDoubleBitmap;
  public boolean mDrawRoundCorner;
  public int mFrameCount = 0;
  public boolean mGetResetLoop;
  int[] mImageInfo;
  boolean mIsInPendingAction;
  protected ArrayList<WeakReference<ApngDrawable.OnPlayRepeatListener>> mListener;
  String mName;
  private long mNextFrameTime;
  public boolean mOnceAndClear;
  protected boolean mPaused;
  public boolean mStopOnFirstFrame;
  private boolean mSupportGlobalPasued;
  int[] mTagIDArr;
  public boolean mUseFileLoop;
  long nativeFrameInfoInstance;
  long nativeImageInstance;
  private Bitmap nextFrame;
  private boolean onlyOneFrame;
  private Paint paint;
  private Paint paintTransparentBlack;
  public int width = 0;
  
  static
  {
    canDecodeIDs = new ArrayList();
    DECRYPTTYPE_DECRYPT = 1;
    sPaused = false;
  }
  
  public ApngImage(File paramFile, boolean paramBoolean)
  {
    this.mGetResetLoop = true;
    this.mPaused = false;
    this.mDensity = 160;
    this.mListener = new ArrayList();
    this.mIsInPendingAction = false;
    this.mImageInfo = new int[7];
    this.paint = new Paint();
    this.paintTransparentBlack = new Paint();
    this.mSupportGlobalPasued = true;
    this.onlyOneFrame = false;
    this.callbacks = new CopyOnWriteArrayList();
    this.mDecodeNextFrameEnd = true;
    this.file = paramFile;
    init(paramBoolean);
  }
  
  public ApngImage(File paramFile, boolean paramBoolean, Bundle paramBundle)
  {
    boolean bool2 = true;
    this.mGetResetLoop = true;
    this.mPaused = false;
    this.mDensity = 160;
    this.mListener = new ArrayList();
    this.mIsInPendingAction = false;
    this.mImageInfo = new int[7];
    this.paint = new Paint();
    this.paintTransparentBlack = new Paint();
    this.mSupportGlobalPasued = true;
    this.onlyOneFrame = false;
    this.callbacks = new CopyOnWriteArrayList();
    this.mDecodeNextFrameEnd = true;
    if (paramBundle != null)
    {
      this.apngLoop = paramBundle.getInt("key_loop", 0);
      this.decryptType = paramBundle.getInt("key_decryptType", this.decryptType);
      this.mName = paramBundle.getString("key_name");
      this.mOnceAndClear = paramBundle.getBoolean("key_once_clear", false);
      this.mDrawRoundCorner = paramBundle.getBoolean("key_draw_round", false);
      this.mGetResetLoop = paramBundle.getBoolean("key_get_reset_loop", true);
      boolean bool1 = bool2;
      if (!this.mDrawRoundCorner) {
        if (paramBundle.getBoolean("key_double_bitmap", false)) {
          bool1 = bool2;
        } else {
          bool1 = false;
        }
      }
      this.mDoubleBitmap = bool1;
      this.mStopOnFirstFrame = paramBundle.getBoolean("key_stop_on_first", false);
      this.mUseFileLoop = paramBundle.getBoolean("key_use_file_loop", false);
      setDensity(paramBundle.getInt("key_density", this.mDensity));
      int[] arrayOfInt = paramBundle.getIntArray("key_tagId_arr");
      if ((arrayOfInt != null) && (arrayOfInt.length > 0)) {
        this.mTagIDArr = paramBundle.getIntArray("key_tagId_arr");
      }
    }
    this.file = paramFile;
    init(paramBoolean);
  }
  
  private void getImageInfo(File paramFile)
  {
    this.nativeImageInstance = nativeStartDecode(paramFile.getAbsolutePath(), this.mImageInfo, this.decryptType);
    paramFile = this.mImageInfo;
    if (paramFile[5] == 0)
    {
      this.width = paramFile[0];
      this.height = paramFile[1];
      this.mFrameCount = paramFile[2];
      if (this.mUseFileLoop) {
        this.apngLoop = paramFile[6];
      }
      if (URLDrawable.depImp.mLog.isColorLevel())
      {
        paramFile = URLDrawable.depImp.mLog;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("start decode success width = ");
        localStringBuilder.append(this.width);
        localStringBuilder.append(" height = ");
        localStringBuilder.append(this.height);
        localStringBuilder.append(" frameCount = ");
        localStringBuilder.append(this.mFrameCount);
        paramFile.d("ApngImage", 2, localStringBuilder.toString());
      }
      if ((this.width > 0) && (this.height > 0) && (this.mFrameCount > 0)) {
        return;
      }
      paramFile = new StringBuilder();
      paramFile.append("bad apng, w=");
      paramFile.append(this.width);
      paramFile.append(" h=");
      paramFile.append(this.height);
      paramFile.append(" frames=");
      paramFile.append(this.mFrameCount);
      throw new RuntimeException(paramFile.toString());
    }
    paramFile = new StringBuilder();
    paramFile.append("start decode error: ");
    paramFile.append(this.mImageInfo[5]);
    throw new RuntimeException(paramFile.toString());
  }
  
  private void init(boolean paramBoolean)
  {
    this.paint.setAntiAlias(true);
    this.paintTransparentBlack.setAntiAlias(true);
    this.paintTransparentBlack.setColor(0);
    this.cacheFirstFrame = paramBoolean;
    getImageInfo(this.file);
    initBitmap();
    if ((!getNextFrame()) || (this.mFrameCount == 1)) {
      this.onlyOneFrame = true;
    }
    applyNextFrame();
    if (paramBoolean) {
      this.firstFrame = this.curFrame;
    }
    if (this.onlyOneFrame)
    {
      this.firstFrame = this.curFrame;
      this.nextFrame = null;
    }
  }
  
  private void initBitmap()
  {
    int i = this.width;
    int j;
    if (i > 0)
    {
      j = this.height;
      if (j <= 0) {}
    }
    try
    {
      this.curFrame = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
      if (!URLDrawable.depImp.mLog.isColorLevel()) {
        break label162;
      }
      localILog = URLDrawable.depImp.mLog;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("init curFrame success width = ");
      localStringBuilder.append(this.curFrame.getWidth());
      localStringBuilder.append(" height = ");
      localStringBuilder.append(this.curFrame.getHeight());
      localILog.d("ApngImage", 2, localStringBuilder.toString());
    }
    catch (OutOfMemoryError localOutOfMemoryError1)
    {
      ILog localILog;
      StringBuilder localStringBuilder;
      label121:
      break label121;
    }
    URLDrawable.clearMemoryCache();
    try
    {
      this.curFrame = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.ARGB_8888);
    }
    catch (OutOfMemoryError localOutOfMemoryError2)
    {
      label145:
      label162:
      label303:
      label320:
      break label145;
    }
    URLDrawable.depImp.mLog.e("ApngImage", 1, "APNG create Bitmap OOM");
    i = this.width;
    if (i > 0)
    {
      j = this.height;
      if ((j <= 0) || ((!this.mDoubleBitmap) && (i * j > IMAGE_SIZE_DISABLE_DOUBLE_BUFFER))) {}
    }
    try
    {
      this.nextFrame = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.ARGB_8888);
      if (!URLDrawable.depImp.mLog.isColorLevel()) {
        break label320;
      }
      localILog = URLDrawable.depImp.mLog;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("init nextFrame success width = ");
      localStringBuilder.append(this.nextFrame.getWidth());
      localStringBuilder.append(" height = ");
      localStringBuilder.append(this.nextFrame.getHeight());
      localILog.d("ApngImage", 2, localStringBuilder.toString());
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError3)
    {
      break label303;
    }
    URLDrawable.depImp.mLog.e("ApngImage", 1, "APNG buffer create OOM");
  }
  
  private void invalidateSelf()
  {
    CopyOnWriteArrayList localCopyOnWriteArrayList = this.callbacks;
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < this.callbacks.size())
        {
          WeakReference localWeakReference = (WeakReference)this.callbacks.get(i);
          if ((localWeakReference != null) && (localWeakReference.get() != null)) {
            ((AnimationCallback)localWeakReference.get()).invalidateSelf();
          }
        }
        else
        {
          return;
        }
      }
      finally
      {
        continue;
        throw localObject;
        continue;
        i += 1;
      }
    }
  }
  
  public static native void nativeFreeFrame(long paramLong);
  
  public static native void nativeFreeImage(long paramLong);
  
  public static native long nativeGetNextFrame(long paramLong1, long paramLong2, Bitmap paramBitmap, int[] paramArrayOfInt);
  
  public static native long nativeStartDecode(String paramString, int[] paramArrayOfInt, int paramInt);
  
  public static final void pauseAll()
  {
    sPaused = true;
    synchronized (canDecodeIDs)
    {
      canDecodeIDs.clear();
      return;
    }
  }
  
  public static final void pauseByTag(int paramInt)
  {
    if (URLDrawable.depImp.mLog.isColorLevel())
    {
      ??? = URLDrawable.depImp.mLog;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("pauseByTag , conplayids:");
      localStringBuilder.append(canDecodeIDs);
      localStringBuilder.append(", tag:");
      localStringBuilder.append(paramInt);
      ((ILog)???).d("ApngImage", 2, localStringBuilder.toString());
    }
    synchronized (canDecodeIDs)
    {
      paramInt = canDecodeIDs.indexOf(Integer.valueOf(paramInt));
      if (paramInt >= 0) {
        canDecodeIDs.remove(paramInt);
      }
      return;
    }
  }
  
  public static final void playByTag(int paramInt)
  {
    if (URLDrawable.depImp.mLog.isColorLevel())
    {
      ILog localILog = URLDrawable.depImp.mLog;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("playByTag , conplayids:");
      localStringBuilder.append(canDecodeIDs);
      localStringBuilder.append(", tag:");
      localStringBuilder.append(paramInt);
      localILog.d("ApngImage", 2, localStringBuilder.toString());
    }
    if (sPaused) {
      pauseAll();
    }
    if (!canDecodeIDs.contains(Integer.valueOf(paramInt))) {
      canDecodeIDs.add(Integer.valueOf(paramInt));
    }
    resumeAll();
  }
  
  public static final void resumeAll()
  {
    try
    {
      sPaused = false;
      int i = sPendingActions.size() - 1;
      while (i >= 0)
      {
        ApngImage localApngImage = (ApngImage)((WeakReference)sPendingActions.get(i)).get();
        if (localApngImage == null)
        {
          sPendingActions.remove(i);
        }
        else if (localApngImage.getIsEnable())
        {
          sPendingActions.remove(i);
          localApngImage.reDraw();
        }
        i -= 1;
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  public static int scaleFromDensity(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = paramInt1;
    if (paramInt2 != 0)
    {
      if (paramInt2 == paramInt3) {
        return paramInt1;
      }
      i = (paramInt1 * paramInt3 + (paramInt2 >> 1)) / paramInt2;
    }
    return i;
  }
  
  private void scheduleSelf(Runnable paramRunnable, long paramLong)
  {
    CopyOnWriteArrayList localCopyOnWriteArrayList = this.callbacks;
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < this.callbacks.size())
        {
          WeakReference localWeakReference = (WeakReference)this.callbacks.get(i);
          if ((localWeakReference != null) && (localWeakReference.get() != null))
          {
            ((AnimationCallback)localWeakReference.get()).scheduleSelf(paramRunnable, paramLong);
          }
          else
          {
            this.callbacks.remove(i);
            i -= 1;
          }
        }
        else
        {
          return;
        }
      }
      finally
      {
        continue;
        throw paramRunnable;
        continue;
        i += 1;
      }
    }
  }
  
  public void addCallBack(AnimationCallback paramAnimationCallback)
  {
    if (paramAnimationCallback != null) {
      synchronized (this.callbacks)
      {
        this.callbacks.add(new WeakReference(paramAnimationCallback));
        return;
      }
    }
  }
  
  void addToPendingActions(ApngImage paramApngImage)
  {
    if (paramApngImage == null) {
      return;
    }
    if (!paramApngImage.mIsInPendingAction)
    {
      int i = sPendingActions.size() - 1;
      while (i >= 0)
      {
        if ((ApngImage)((WeakReference)sPendingActions.get(i)).get() == paramApngImage) {
          return;
        }
        i -= 1;
      }
      sPendingActions.add(new WeakReference(paramApngImage));
      paramApngImage.mIsInPendingAction = true;
    }
  }
  
  public void applyNextFrame()
  {
    try
    {
      if (this.nextFrame != null)
      {
        Paint localPaint = new Paint();
        localPaint.setAntiAlias(true);
        Canvas localCanvas = new Canvas(this.curFrame);
        this.curFrame.eraseColor(0);
        if (this.mDrawRoundCorner)
        {
          localPaint.setFilterBitmap(true);
          localCanvas.drawRoundRect(new RectF(0.0F, 0.0F, this.width, this.height), this.width, this.height, localPaint);
          localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        }
        localCanvas.drawBitmap(this.nextFrame, 0.0F, 0.0F, localPaint);
      }
      return;
    }
    finally {}
  }
  
  protected void doApplyNextFrame()
  {
    applyNextFrame();
    this.mDecodeNextFrameEnd = true;
    if (getIsEnable())
    {
      invalidateSelf();
      return;
    }
    addToPendingActions(this);
  }
  
  public void draw(Canvas paramCanvas, Rect paramRect1, Rect paramRect2, Paint paramPaint, boolean paramBoolean)
  {
    if (paramCanvas != null)
    {
      if (paramRect2 == null) {
        return;
      }
      int i = this.apngLoop;
      if ((i > 0) && (i <= this.currentApngLoop) && (this.mOnceAndClear))
      {
        paramCanvas.drawColor(16777215);
        return;
      }
      initHandlerAndRunnable();
      if ((!this.onlyOneFrame) && (paramBoolean))
      {
        localBitmap = this.curFrame;
        if (localBitmap != null) {
          paramCanvas.drawBitmap(localBitmap, paramRect1, paramRect2, paramPaint);
        }
        if (getIsEnable())
        {
          i = this.apngLoop;
          if ((i > 0) && (i <= this.currentApngLoop))
          {
            if ((this.mStopOnFirstFrame) && (this.mImageInfo[3] == this.mFrameCount - 1)) {
              executeNewTask();
            }
          }
          else {
            executeNewTask();
          }
        }
        else
        {
          addToPendingActions(this);
        }
        return;
      }
      Bitmap localBitmap = this.firstFrame;
      if (localBitmap != null) {
        paramCanvas.drawBitmap(localBitmap, paramRect1, paramRect2, paramPaint);
      }
    }
  }
  
  public void drawFrame(Canvas paramCanvas) {}
  
  protected void executeNewTask()
  {
    if (this.mDecodeNextFrameEnd)
    {
      this.mDecodeNextFrameEnd = false;
      int i = getDelay();
      long l1 = SystemClock.uptimeMillis();
      long l2 = this.mNextFrameTime;
      if (l2 == 0L)
      {
        this.mNextFrameTime = l1;
      }
      else if (l2 + i * 2 <= l1)
      {
        if (URLDrawable.depImp.mLog.isColorLevel())
        {
          ILog localILog = URLDrawable.depImp.mLog;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("executeNewTask reset ");
          localStringBuilder.append(this.mName);
          localStringBuilder.append(":");
          localStringBuilder.append(this.mNextFrameTime);
          localStringBuilder.append(",");
          localStringBuilder.append(i);
          localStringBuilder.append(",");
          localStringBuilder.append(l1);
          localILog.d("URLDrawable_", 2, localStringBuilder.toString());
        }
        this.mNextFrameTime = l1;
      }
      this.mNextFrameTime += i;
      try
      {
        Utils.executeAsyncTaskOnSerialExcuter(new ApngImage.DecodeNextFrameAsyncTask(this, this.mNextFrameTime), new Void[] { (Void)null });
        return;
      }
      catch (RejectedExecutionException localRejectedExecutionException)
      {
        if (URLDrawable.depImp.mLog.isColorLevel()) {
          URLDrawable.depImp.mLog.e("URLDrawable_", 2, "executeNewTask()", localRejectedExecutionException);
        }
      }
    }
  }
  
  protected void finalize()
  {
    try
    {
      try
      {
        if (this.nativeFrameInfoInstance != 0L) {
          nativeFreeFrame(this.nativeFrameInfoInstance);
        }
        if (this.nativeImageInstance != 0L) {
          nativeFreeImage(this.nativeImageInstance);
        }
      }
      finally
      {
        super.finalize();
      }
    }
    catch (Throwable localThrowable)
    {
      label42:
      break label42;
    }
    super.finalize();
  }
  
  public int getByteSize()
  {
    if (this.onlyOneFrame) {
      return Utils.getBitmapSize(this.firstFrame);
    }
    int j = 0;
    Bitmap localBitmap = this.curFrame;
    if (localBitmap != null) {
      j = 0 + Utils.getBitmapSize(localBitmap);
    }
    localBitmap = this.nextFrame;
    int i = j;
    if (localBitmap != null) {
      i = j + Utils.getBitmapSize(localBitmap);
    }
    j = i;
    if (this.nativeFrameInfoInstance != 0L) {
      j = i + this.width * this.height * 4;
    }
    return j;
  }
  
  public Bitmap getCurrentFrame()
  {
    return this.curFrame;
  }
  
  public int getDelay()
  {
    return this.currentFrameDelay;
  }
  
  public int getHeight()
  {
    return this.height;
  }
  
  final boolean getIsEnable()
  {
    if (this.mPaused) {
      return false;
    }
    if ((this.mSupportGlobalPasued) && (sPaused)) {
      return false;
    }
    if (this.mTagIDArr != null)
    {
      int i = 0;
      for (;;)
      {
        int[] arrayOfInt = this.mTagIDArr;
        if (i >= arrayOfInt.length) {
          break;
        }
        if (canDecodeIDs.contains(Integer.valueOf(arrayOfInt[i]))) {
          return true;
        }
        i += 1;
      }
      return false;
    }
    return true;
  }
  
  public int getLoopCount()
  {
    return this.mImageInfo[6];
  }
  
  protected boolean getNextFrame()
  {
    try
    {
      if (this.nativeImageInstance != 0L)
      {
        if (this.nextFrame != null) {
          this.nativeFrameInfoInstance = nativeGetNextFrame(this.nativeImageInstance, this.nativeFrameInfoInstance, this.nextFrame, this.mImageInfo);
        } else {
          this.nativeFrameInfoInstance = nativeGetNextFrame(this.nativeImageInstance, this.nativeFrameInfoInstance, this.curFrame, this.mImageInfo);
        }
        if (this.mImageInfo[5] == 0)
        {
          this.currentFrameDelay = this.mImageInfo[4];
          return true;
        }
        if (URLDrawable.depImp.mLog.isColorLevel())
        {
          ILog localILog = URLDrawable.depImp.mLog;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("getNextFrame fail: ");
          localStringBuilder.append(this.mImageInfo[5]);
          localILog.d("ApngImage", 2, localStringBuilder.toString());
        }
      }
      return false;
    }
    finally {}
  }
  
  public int getScaledHeight(int paramInt)
  {
    return scaleFromDensity(this.height, this.mDensity, paramInt);
  }
  
  public int getScaledWidth(int paramInt)
  {
    return scaleFromDensity(this.width, this.mDensity, paramInt);
  }
  
  public int getWidth()
  {
    return this.width;
  }
  
  protected void initHandlerAndRunnable()
  {
    if (sHandler == null)
    {
      sHandler = new Handler(Looper.getMainLooper());
      sAccumulativeRunnable = new ApngImage.DoAccumulativeRunnable(null);
    }
  }
  
  void onDecodeNextFrameCanceled()
  {
    if (URLDrawable.depImp.mLog.isColorLevel())
    {
      ILog localILog = URLDrawable.depImp.mLog;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("apng decode canceled. ");
      localStringBuilder.append(this.file);
      localILog.e("URLDrawable_", 2, localStringBuilder.toString());
    }
    this.mDecodeNextFrameEnd = true;
  }
  
  void onDecodeNextFrameFailed(Throwable paramThrowable)
  {
    if (URLDrawable.depImp.mLog.isColorLevel())
    {
      ILog localILog = URLDrawable.depImp.mLog;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("apng decode error. ");
      localStringBuilder.append(this.file);
      localILog.e("URLDrawable_", 2, localStringBuilder.toString(), paramThrowable);
    }
    this.mDecodeNextFrameEnd = true;
  }
  
  void onDecodeNextFrameSuccessed(boolean paramBoolean, long paramLong)
  {
    Object localObject2;
    if (paramBoolean)
    {
      long l = SystemClock.uptimeMillis();
      if (l < paramLong)
      {
        sHandler.postDelayed(this, paramLong - l);
      }
      else
      {
        if (URLDrawable.depImp.mLog.isColorLevel())
        {
          ??? = URLDrawable.depImp.mLog;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("post task overtime: ");
          ((StringBuilder)localObject2).append(l - paramLong);
          ((ILog)???).d("ApngImage", 2, ((StringBuilder)localObject2).toString());
        }
        sHandler.post(this);
      }
      if ((this.apngLoop > 0) && (this.mFrameCount == this.mImageInfo[3] + 1))
      {
        if (URLDrawable.depImp.mLog.isColorLevel())
        {
          ??? = URLDrawable.depImp.mLog;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("apng mFrameCount:");
          ((StringBuilder)localObject2).append(this.mFrameCount);
          ((StringBuilder)localObject2).append(", current:");
          ((StringBuilder)localObject2).append(this.mImageInfo[3]);
          ((ILog)???).d("ApngImage", 2, ((StringBuilder)localObject2).toString());
        }
        this.currentApngLoop += 1;
      }
    }
    for (;;)
    {
      int i;
      synchronized (this.mListener)
      {
        i = this.mListener.size() - 1;
        if (i >= 0)
        {
          localObject2 = (ApngDrawable.OnPlayRepeatListener)((WeakReference)this.mListener.get(i)).get();
          if (localObject2 != null)
          {
            ((ApngDrawable.OnPlayRepeatListener)localObject2).onPlayRepeat(this.currentApngLoop);
            break label312;
          }
          this.mListener.remove(i);
          break label312;
        }
        return;
      }
      return;
      label312:
      i -= 1;
    }
  }
  
  public void pause()
  {
    this.mPaused = true;
  }
  
  public void reDraw()
  {
    invalidateSelf();
    this.mIsInPendingAction = false;
  }
  
  public void removeCallBack(AnimationCallback paramAnimationCallback)
  {
    CopyOnWriteArrayList localCopyOnWriteArrayList = this.callbacks;
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < this.callbacks.size())
        {
          WeakReference localWeakReference = (WeakReference)this.callbacks.get(i);
          if ((localWeakReference != null) && (localWeakReference.get() != null))
          {
            j = i;
            if (localWeakReference.get() == paramAnimationCallback) {
              this.callbacks.remove(i);
            }
          }
          else
          {
            this.callbacks.remove(i);
            j = i - 1;
          }
        }
        else
        {
          return;
        }
      }
      finally
      {
        int j;
        continue;
        throw paramAnimationCallback;
        continue;
        i = j + 1;
      }
    }
  }
  
  public void removeOnPlayRepeatListener(ApngDrawable.OnPlayRepeatListener paramOnPlayRepeatListener)
  {
    if (paramOnPlayRepeatListener != null) {}
    for (;;)
    {
      int i;
      synchronized (this.mListener)
      {
        i = this.mListener.size() - 1;
        if (i >= 0)
        {
          if (((WeakReference)this.mListener.get(i)).get() != paramOnPlayRepeatListener) {
            break label64;
          }
          this.mListener.remove(i);
          break label64;
        }
        return;
      }
      return;
      label64:
      i -= 1;
    }
  }
  
  public void replay()
  {
    this.currentApngLoop = 0;
    reDraw();
  }
  
  public void resume()
  {
    this.mPaused = false;
    int i = sPendingActions.size() - 1;
    while (i >= 0)
    {
      ApngImage localApngImage = (ApngImage)((WeakReference)sPendingActions.get(i)).get();
      if ((localApngImage == this) && (localApngImage.getIsEnable()))
      {
        sPendingActions.remove(i);
        localApngImage.reDraw();
      }
      i -= 1;
    }
  }
  
  public void run()
  {
    sAccumulativeRunnable.add(new WeakReference[] { new WeakReference(this) });
  }
  
  public void setDensity(int paramInt)
  {
    this.mDensity = paramInt;
  }
  
  public void setOnPlayRepeatListener(ApngDrawable.OnPlayRepeatListener paramOnPlayRepeatListener)
  {
    ArrayList localArrayList;
    int k;
    int i;
    if (paramOnPlayRepeatListener != null)
    {
      localArrayList = this.mListener;
      k = 0;
      i = 0;
    }
    for (;;)
    {
      int j = k;
      try
      {
        if (i < this.mListener.size())
        {
          if (((WeakReference)this.mListener.get(i)).get() != paramOnPlayRepeatListener) {
            break label86;
          }
          j = 1;
        }
        if (j == 0) {
          this.mListener.add(new WeakReference(paramOnPlayRepeatListener));
        }
        return;
      }
      finally {}
      return;
      label86:
      i += 1;
    }
  }
  
  public void setSupportGlobalPasued(boolean paramBoolean)
  {
    this.mSupportGlobalPasued = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.image.ApngImage
 * JD-Core Version:    0.7.0.1
 */