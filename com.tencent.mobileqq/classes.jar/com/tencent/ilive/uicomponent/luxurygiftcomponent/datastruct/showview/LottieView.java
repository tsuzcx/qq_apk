package com.tencent.ilive.uicomponent.luxurygiftcomponent.datastruct.showview;

import android.animation.Animator.AnimatorListener;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.falco.base.libapi.lottie.LiveLottieApi.Cancellable;
import com.tencent.falco.base.libapi.lottie.LiveLottieApi.ImageAssetDelegate;
import com.tencent.falco.base.libapi.lottie.LiveLottieApi.OnCompositionLoadedListener;
import com.tencent.falco.base.libapi.lottie.LiveLottieImageAsset;
import com.tencent.falco.base.libapi.lottie.LoadToPlayInter;
import com.tencent.falco.base.libapi.lottie.LottieAnimationViewInterface;
import com.tencent.falco.base.libapi.lottie.LottieCompositionInterface;
import com.tencent.falco.base.libapi.lottie.LottieGiftInfo;
import com.tencent.falco.base.libapi.lottie.LottieViewInterface;
import com.tencent.falco.utils.ThreadCenter;
import com.tencent.falco.utils.UIUtil;
import com.tencent.ilive.uicomponent.luxurygiftcomponent_interface.LuxuryGiftAdapter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;

public class LottieView
  extends FrameLayout
  implements LottieViewInterface
{
  private static final int ORIGINAL_PIC_DENSITY = 160;
  private final int FRAME_PER_SECOND = 30;
  private final int MAX_SINGLE_LINE_NAME_LENGTH = 10;
  private String TAG = "LottieView";
  private final int US_To_SECOND = 1000000;
  private LiveLottieApi.Cancellable compositionLoader;
  private String configFilePath;
  private boolean hasShowAnim = false;
  private Bitmap headBitmap = BitmapFactory.decodeResource(getResources(), 2130841225);
  private boolean isPlaying = false;
  private LottieGiftInfo mCurrentLottieGiftInfo;
  private LottieAnimationViewInterface mLottieAnimationViewInterface;
  private LuxuryGiftAdapter mLuxuryGiftAdapter;
  private final LiveLottieApi.OnCompositionLoadedListener mOnCompositionLoadedListener = new LottieView.5(this);
  private HashMap<String, Integer> mPlayTimeMap = new HashMap();
  private String playConfigFilePath;
  private int startTime = 0;
  
  public LottieView(Context paramContext, AttributeSet paramAttributeSet, int paramInt, LuxuryGiftAdapter paramLuxuryGiftAdapter)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.mLuxuryGiftAdapter = paramLuxuryGiftAdapter;
    init();
  }
  
  public LottieView(Context paramContext, AttributeSet paramAttributeSet, LuxuryGiftAdapter paramLuxuryGiftAdapter)
  {
    this(paramContext, paramAttributeSet, 0, paramLuxuryGiftAdapter);
  }
  
  public LottieView(Context paramContext, LuxuryGiftAdapter paramLuxuryGiftAdapter)
  {
    this(paramContext, null, paramLuxuryGiftAdapter);
  }
  
  private Bitmap createCircleImage(Context paramContext, Bitmap paramBitmap, LiveLottieImageAsset paramLiveLottieImageAsset)
  {
    paramContext = this.mLuxuryGiftAdapter.getLogger();
    Object localObject = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" aw=");
    localStringBuilder.append(paramLiveLottieImageAsset.a());
    localStringBuilder.append(" ah=");
    localStringBuilder.append(paramLiveLottieImageAsset.b());
    paramContext.e((String)localObject, localStringBuilder.toString(), new Object[0]);
    int i = paramLiveLottieImageAsset.a();
    int j = paramLiveLottieImageAsset.b();
    paramContext = zoomImage(paramBitmap, i, j);
    paramBitmap = new Paint();
    paramLiveLottieImageAsset = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
    localObject = new Canvas(paramLiveLottieImageAsset);
    float f = i / 2;
    ((Canvas)localObject).drawCircle(f, f, f, paramBitmap);
    paramBitmap.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    ((Canvas)localObject).drawBitmap(paramContext, 0.0F, 0.0F, paramBitmap);
    return paramLiveLottieImageAsset;
  }
  
  private int dip2px(Context paramContext, float paramFloat)
  {
    double d1 = paramContext.getResources().getDisplayMetrics().density;
    double d2 = paramFloat;
    Double.isNaN(d2);
    Double.isNaN(d1);
    return (int)(d2 * d1 + 0.5D);
  }
  
  private Bitmap drawLinkMicComment(LottieGiftInfo paramLottieGiftInfo, int paramInt1, int paramInt2)
  {
    String str = paramLottieGiftInfo.a;
    int i = str.length();
    Object localObject1 = "..";
    Object localObject2 = str;
    if (i > 3)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(str.substring(0, 3));
      ((StringBuilder)localObject2).append("..");
      localObject2 = ((StringBuilder)localObject2).toString();
    }
    str = paramLottieGiftInfo.g;
    if ((!TextUtils.isEmpty(str)) && (str.length() > 3))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(str.substring(0, 3));
      ((StringBuilder)localObject1).append("..");
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    else if (!TextUtils.isEmpty(str))
    {
      localObject1 = str;
    }
    str = paramLottieGiftInfo.i;
    if (!TextUtils.isEmpty(str))
    {
      i = str.lastIndexOf("_") + 1;
      paramLottieGiftInfo = str.substring(i);
      return drawText(str.substring(0, i).replaceFirst("_", (String)localObject2).replace("_", (CharSequence)localObject1), paramLottieGiftInfo, paramInt1, paramInt2);
    }
    return drawText(paramLottieGiftInfo.a, paramLottieGiftInfo.f, paramInt1, paramInt2);
  }
  
  private Bitmap drawText(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    Paint localPaint = new Paint(1);
    localPaint.setTextSize(32.0F);
    localPaint.setColor(Color.rgb(144, 75, 0));
    Bitmap localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    Paint.FontMetricsInt localFontMetricsInt = localPaint.getFontMetricsInt();
    paramInt2 = (paramInt2 + localFontMetricsInt.top - localFontMetricsInt.bottom) / 2 - localFontMetricsInt.top / 2;
    Rect localRect = new Rect();
    localPaint.getTextBounds(paramString1, 0, paramString1.length(), localRect);
    paramInt1 /= 2;
    int i = localRect.width() / 2;
    localPaint.setFakeBoldText(true);
    localCanvas.drawText(paramString1, paramInt1 - i, paramInt2, localPaint);
    localPaint.setTextSize(28.0F);
    localPaint.getTextBounds(paramString2, 0, paramString2.length(), localRect);
    i = localRect.width() / 2;
    localPaint.setFakeBoldText(false);
    int j = localFontMetricsInt.top;
    localCanvas.drawText(paramString2, paramInt1 - i, paramInt2 - j, localPaint);
    return localBitmap;
  }
  
  private static InputStream getDataJsonInputStream(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = new File(paramString);
      if ((paramString.exists()) && (paramString.isFile())) {
        try
        {
          paramString = new FileInputStream(paramString);
          return paramString;
        }
        catch (FileNotFoundException paramString)
        {
          paramString.printStackTrace();
        }
      }
    }
    return null;
  }
  
  private Bitmap getImageByName(Context paramContext, LiveLottieImageAsset paramLiveLottieImageAsset)
  {
    if ("img_1.png".equals(paramLiveLottieImageAsset.c()))
    {
      if (this.mCurrentLottieGiftInfo.h != this.mCurrentLottieGiftInfo.j) {
        return drawLinkMicComment(this.mCurrentLottieGiftInfo, paramLiveLottieImageAsset.a(), paramLiveLottieImageAsset.b());
      }
      if (this.mCurrentLottieGiftInfo.a == null) {
        paramContext = "";
      } else {
        paramContext = this.mCurrentLottieGiftInfo.a;
      }
      Object localObject = paramContext;
      if (paramContext.length() > 10)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramContext.substring(0, 8));
        ((StringBuilder)localObject).append("...");
        localObject = ((StringBuilder)localObject).toString();
      }
      return drawText((String)localObject, this.mCurrentLottieGiftInfo.f, paramLiveLottieImageAsset.a(), paramLiveLottieImageAsset.b());
    }
    return createCircleImage(paramContext, this.headBitmap, paramLiveLottieImageAsset);
  }
  
  private void init()
  {
    this.mLottieAnimationViewInterface = this.mLuxuryGiftAdapter.createLottieAnimationView(getContext());
    this.mLottieAnimationViewInterface.setImageAssetDelegate(new LottieView.1(this));
    this.mLottieAnimationViewInterface.addAnimatorListener(new LottieView.2(this));
    addView((View)this.mLottieAnimationViewInterface);
  }
  
  private void parseTime(String paramString, LoadToPlayInter paramLoadToPlayInter)
  {
    this.startTime = 0;
    if (this.mPlayTimeMap.containsKey(paramString))
    {
      this.startTime = ((Integer)this.mPlayTimeMap.get(paramString)).intValue();
      if (paramLoadToPlayInter != null) {
        paramLoadToPlayInter.onPrepareStart();
      }
      return;
    }
    ThreadCenter.postLogicTask(new LottieView.3(this, paramString, paramLoadToPlayInter));
  }
  
  public void addAnimatorListener(Animator.AnimatorListener paramAnimatorListener)
  {
    this.mLottieAnimationViewInterface.addAnimatorListener(paramAnimatorListener);
  }
  
  public void cancelAnimation()
  {
    this.mLottieAnimationViewInterface.cancelAnimation();
  }
  
  public void cancelLoaderTask()
  {
    LiveLottieApi.Cancellable localCancellable = this.compositionLoader;
    if (localCancellable != null)
    {
      localCancellable.a();
      this.compositionLoader = null;
    }
  }
  
  public Bitmap getDefaultIcon()
  {
    return BitmapFactory.decodeResource(getResources(), 2130841225);
  }
  
  public View getView()
  {
    return this;
  }
  
  public boolean isAnimating()
  {
    return this.mLottieAnimationViewInterface.isAnimating();
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.mLuxuryGiftAdapter.getLogger().i(this.TAG, "onAttachedToWindow", new Object[0]);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.mLuxuryGiftAdapter.getLogger().i(this.TAG, "onDetachedFromWindow", new Object[0]);
  }
  
  public void onH264End()
  {
    this.hasShowAnim = false;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    setMeasuredDimension(getContext().getResources().getDisplayMetrics().widthPixels, UIUtil.getContentViewHeight(getContext()));
  }
  
  public void onPlayAtTime(long paramLong, boolean paramBoolean)
  {
    LogInterface localLogInterface = this.mLuxuryGiftAdapter.getLogger();
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onPlayAtTime: ");
    localStringBuilder.append(paramLong);
    localStringBuilder.append(" start time = ");
    localStringBuilder.append(this.startTime);
    localStringBuilder.append(" containerShow visibile = ");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(" isAnimating() = ");
    localStringBuilder.append(isAnimating());
    localStringBuilder.append(" isPlaying = ");
    localStringBuilder.append(this.isPlaying);
    localStringBuilder.append("  lottie view shown=");
    localStringBuilder.append(isShown());
    localLogInterface.d(str, localStringBuilder.toString(), new Object[0]);
    if ((isAnimating()) && (!this.hasShowAnim)) {
      this.hasShowAnim = true;
    }
    if ((this.isPlaying) && (this.hasShowAnim))
    {
      int i;
      if ((isAnimating()) && (paramBoolean)) {
        i = 0;
      } else {
        i = 8;
      }
      setVisibility(i);
      if ((!isAnimating()) && (this.hasShowAnim)) {
        this.hasShowAnim = false;
      }
    }
    if (!paramBoolean) {
      return;
    }
    if ((!this.isPlaying) && (paramLong > this.startTime))
    {
      play();
      this.isPlaying = true;
    }
  }
  
  public void play()
  {
    if (!isAnimating()) {
      ThreadCenter.postLogicTask(new LottieView.4(this));
    }
  }
  
  public void playAnimation()
  {
    this.mLottieAnimationViewInterface.playAnimation();
  }
  
  public void setAnimState(boolean paramBoolean)
  {
    this.isPlaying = paramBoolean;
  }
  
  public void setAnimation(String paramString)
  {
    this.mLottieAnimationViewInterface.setAnimation(paramString);
  }
  
  public void setComposition(@NonNull LottieCompositionInterface paramLottieCompositionInterface)
  {
    this.mLottieAnimationViewInterface.setComposition(paramLottieCompositionInterface);
  }
  
  public void setConfig(String paramString1, String paramString2, LottieGiftInfo paramLottieGiftInfo, Bitmap paramBitmap, LoadToPlayInter paramLoadToPlayInter)
  {
    LogInterface localLogInterface = this.mLuxuryGiftAdapter.getLogger();
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("title=");
    localStringBuilder.append(paramLottieGiftInfo.d);
    localStringBuilder.append(" subtitle=");
    localStringBuilder.append(paramLottieGiftInfo.f);
    localLogInterface.i(str, localStringBuilder.toString(), new Object[0]);
    localLogInterface = this.mLuxuryGiftAdapter.getLogger();
    str = this.TAG;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("head bitmap is null ?  ");
    boolean bool;
    if (paramBitmap == null) {
      bool = true;
    } else {
      bool = false;
    }
    localStringBuilder.append(bool);
    localLogInterface.e(str, localStringBuilder.toString(), new Object[0]);
    this.playConfigFilePath = paramString1;
    this.configFilePath = paramString2;
    this.mCurrentLottieGiftInfo = paramLottieGiftInfo;
    this.headBitmap = paramBitmap;
    parseTime(this.playConfigFilePath, paramLoadToPlayInter);
  }
  
  public void setImageAssetDelegate(LiveLottieApi.ImageAssetDelegate paramImageAssetDelegate)
  {
    this.mLottieAnimationViewInterface.setImageAssetDelegate(paramImageAssetDelegate);
  }
  
  public void setRepeatCount(int paramInt)
  {
    this.mLottieAnimationViewInterface.setRepeatCount(paramInt);
  }
  
  public void setRepeatMode(int paramInt)
  {
    this.mLottieAnimationViewInterface.setRepeatMode(paramInt);
  }
  
  public Bitmap zoomImage(Bitmap paramBitmap, double paramDouble1, double paramDouble2)
  {
    Matrix localMatrix = new Matrix();
    Bitmap localBitmap = paramBitmap;
    if (paramBitmap == null) {
      localBitmap = getDefaultIcon();
    }
    float f1 = localBitmap.getWidth();
    float f2 = localBitmap.getHeight();
    float f3 = (float)paramDouble1 / f1;
    float f4 = (float)paramDouble2 / f2;
    paramBitmap = this.mLuxuryGiftAdapter.getLogger();
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" sw=");
    localStringBuilder.append(f3);
    localStringBuilder.append(" sh=");
    localStringBuilder.append(f4);
    paramBitmap.e(str, localStringBuilder.toString(), new Object[0]);
    localMatrix.postScale(f3, f4);
    return Bitmap.createBitmap(localBitmap, 0, 0, (int)f1, (int)f2, localMatrix, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilive.uicomponent.luxurygiftcomponent.datastruct.showview.LottieView
 * JD-Core Version:    0.7.0.1
 */