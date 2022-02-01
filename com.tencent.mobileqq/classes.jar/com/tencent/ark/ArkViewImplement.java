package com.tencent.ark;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.ClipboardManager;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;

public class ArkViewImplement
{
  protected static final ArkEnvironmentManager ENV = ;
  public static final int INPUTCOMMAD_COPY = 4;
  public static final int INPUTCOMMAD_CUT = 5;
  public static final int INPUTCOMMAD_PASTE = 3;
  public static final int INPUTCOMMAD_SELECT = 1;
  public static final int INPUTCOMMAD_SELECTALL = 2;
  public static final int STATE_LOADING = 0;
  public static final int STATE_LOAD_FAILED = -1;
  public static final int STATE_LOAD_SUCCESS = 1;
  protected static final String TAG = "ArkApp.ArkViewImplement";
  public static final float TRIANGLE_WIDTH = 10.0F;
  static final Paint sPaint = new Paint(3);
  static final Paint sPaintCanvas;
  static final Paint sPaintOpaque = new Paint(3);
  static final Paint sPaintPath = new Paint(1);
  public boolean mAlignLeft = false;
  protected View mArkView;
  private ArkViewModel mArkViewModel;
  public int mBorderType = 1;
  public float mClipRadius = 6.0F;
  public float mClipRadiusTop = 6.0F;
  protected int mHolderHeight = 0;
  protected int mHolderWidth = 0;
  protected InputMethodManager mImm = null;
  protected ArkViewImplement.InputCallback mInputCallback = null;
  protected boolean mInputFocus = false;
  protected boolean mInputReadOnly = false;
  protected Rect mInputRect = new Rect();
  protected int mInputType = 0;
  protected boolean mIpnutNeedHide = false;
  ArkViewImplement.LoadCallback mLoadCallback = null;
  protected int mLoadState = 0;
  private boolean mLongClickTriggered = false;
  public boolean mOpaque = false;
  public Rect mRectView = new Rect();
  public boolean mRound = false;
  public float mScale = 1.0F;
  protected ArkViewImplement.ArkViewInterface mViewInterface;
  
  static
  {
    sPaintCanvas = new Paint();
    sPaintOpaque.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
    sPaintCanvas.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
    sPaintPath.setColor(0);
    sPaintPath.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
  }
  
  ArkViewImplement(View paramView, ArkViewImplement.ArkViewInterface paramArkViewInterface)
  {
    this.mArkView = paramView;
    this.mViewInterface = paramArkViewInterface;
    this.mArkView.setOnFocusChangeListener(new ArkViewImplement.1(this));
    this.mArkView.addOnLayoutChangeListener(new ArkViewImplement.2(this));
  }
  
  private static int dp2px(float paramFloat, Resources paramResources)
  {
    return (int)(paramFloat * paramResources.getDisplayMetrics().density + 0.5F);
  }
  
  public void checkSurfaceAvailable()
  {
    this.mViewInterface.checkSurfaceAvailable();
  }
  
  protected void deleteInputText()
  {
    ArkViewModel localArkViewModel = this.mArkViewModel;
    if (localArkViewModel == null) {
      return;
    }
    localArkViewModel.SafeAsyncRun(new ArkViewImplement.6(this));
  }
  
  void destroyBitmapBuffer()
  {
    ArkViewImplement.ArkViewInterface localArkViewInterface = this.mViewInterface;
    if (localArkViewInterface != null) {
      localArkViewInterface.destroyBitmapBuffer();
    }
  }
  
  void doDetach(ArkViewModelBase paramArkViewModelBase)
  {
    Logger.logI("ArkApp.ArkViewImplement", String.format("doDetach.this.%h.model.%h", new Object[] { this, paramArkViewModelBase }));
    this.mViewInterface.releaseViewContext();
    if (paramArkViewModelBase == this.mArkViewModel) {
      this.mArkViewModel = null;
    }
    resetInputState();
  }
  
  public void doInputCommand(int paramInt)
  {
    if (paramInt == 3)
    {
      localObject = (ClipboardManager)this.mArkView.getContext().getSystemService("clipboard");
      if (((ClipboardManager)localObject).getText() != null)
      {
        localObject = ((ClipboardManager)localObject).getText().toString();
        break label45;
      }
    }
    Object localObject = "";
    label45:
    ArkViewModel localArkViewModel = this.mArkViewModel;
    if (localArkViewModel == null) {
      return;
    }
    localArkViewModel.SafeAsyncRun(new ArkViewImplement.7(this, paramInt, (String)localObject));
  }
  
  boolean doOnLongClick(View paramView)
  {
    if (this.mArkViewModel == null) {
      return false;
    }
    this.mLongClickTriggered = true;
    resetInputState();
    return true;
  }
  
  boolean doOnTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (this.mArkViewModel == null) {
      return false;
    }
    int i = paramMotionEvent.getActionMasked();
    if ((this.mLongClickTriggered) && (i == 1))
    {
      this.mLongClickTriggered = false;
      return false;
    }
    i = (int)(paramMotionEvent.getX() / this.mScale);
    int j = (int)(paramMotionEvent.getY() / this.mScale);
    if ((this.mInputFocus) && (this.mArkView.getParent() != null) && (ptInInputArea(i, j)))
    {
      this.mArkView.getParent().requestDisallowInterceptTouchEvent(true);
      if ((this.mImm != null) && (!this.mInputReadOnly))
      {
        this.mArkView.requestFocus();
        this.mImm.showSoftInput(this.mArkView, 0);
      }
    }
    return this.mArkViewModel.onTouch(paramView, paramMotionEvent);
  }
  
  boolean doOnViewEvent(String paramString1, String paramString2)
  {
    ArkViewModel localArkViewModel = this.mArkViewModel;
    if (localArkViewModel == null)
    {
      Logger.logE("ArkApp.ArkViewImplement", "doOnViewEvent mArkViewModel is null");
      return false;
    }
    return localArkViewModel.onViewEvent(paramString1, paramString2);
  }
  
  Bitmap getBitmapBuffer()
  {
    ArkViewImplement.ArkViewInterface localArkViewInterface = this.mViewInterface;
    if (localArkViewInterface == null) {
      return null;
    }
    return localArkViewInterface.getBitmapBuffer();
  }
  
  public Rect getInputRect()
  {
    ArkViewModel localArkViewModel = this.mArkViewModel;
    if (localArkViewModel != null) {
      return localArkViewModel.scaleRect(this.mInputRect);
    }
    return new Rect();
  }
  
  public View getView()
  {
    return this.mViewInterface.getView();
  }
  
  public ArkViewModel getViewModel()
  {
    return this.mArkViewModel;
  }
  
  void initArkView(ArkViewModel paramArkViewModel)
  {
    initArkView(paramArkViewModel, true);
  }
  
  void initArkView(ArkViewModel paramArkViewModel, boolean paramBoolean)
  {
    if (paramArkViewModel == null)
    {
      Logger.logE("ArkApp.ArkViewImplement", String.format("initArkView,viewModel this=%h", new Object[] { this }));
      return;
    }
    if (ENV.mIsDebug) {
      Logger.logI("ArkApp.ArkViewImplement", String.format("initArkView.viewModel.%h", new Object[] { paramArkViewModel }));
    }
    if (this.mArkViewModel == paramArkViewModel)
    {
      paramArkViewModel.activateView(true);
      paramArkViewModel.postInvalid();
      localObject = this.mLoadCallback;
      if (localObject != null) {
        ((ArkViewImplement.LoadCallback)localObject).onLoadState(this.mLoadState);
      }
      Logger.logI("ArkApp.ArkViewImplement", String.format("initArkView.1.same wrapper: %s, wrapper: %h view: %h", new Object[] { this.mRectView.toString(), paramArkViewModel, this }));
      return;
    }
    if ((paramBoolean) && (this.mArkView.getVisibility() != 8)) {
      this.mArkView.setVisibility(4);
    }
    Object localObject = this.mArkViewModel;
    if (localObject != null) {
      ((ArkViewModel)localObject).detachView();
    }
    this.mScale = paramArkViewModel.getScale();
    this.mRound = paramArkViewModel.mRoundCorner;
    this.mArkViewModel = paramArkViewModel;
    paramArkViewModel.attachView(this);
    localObject = paramArkViewModel.getContainerRect();
    if (((Rect)localObject).isEmpty()) {
      ((Rect)localObject).set(0, 0, paramArkViewModel.getWidth(), paramArkViewModel.getHeight());
    }
    this.mRectView = paramArkViewModel.scaleRect((Rect)localObject);
    if (!this.mRectView.isEmpty())
    {
      if (ENV.mIsDebug) {
        Logger.logI("ArkApp.ArkViewImplement", StringUtil.format("initArkView.vm.%h.measure.(%d, %d)", new Object[] { paramArkViewModel, Integer.valueOf(this.mRectView.width()), Integer.valueOf(this.mRectView.height()) }));
      }
      paramArkViewModel = this.mArkView.getLayoutParams();
      paramArkViewModel.width = this.mRectView.width();
      paramArkViewModel.height = this.mRectView.height();
    }
  }
  
  public void makePath(RectF paramRectF, Path paramPath)
  {
    int i = this.mBorderType;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3) {
            return;
          }
          f2 = this.mClipRadiusTop;
          f1 = this.mScale;
          f2 = f2 * f1 * 2.0F;
          f1 = this.mClipRadius * f1 * 2.0F;
          localObject = new RectF();
          ((RectF)localObject).right = (paramRectF.left + f2);
          ((RectF)localObject).bottom = (paramRectF.top + f2);
          ((RectF)localObject).left = paramRectF.left;
          ((RectF)localObject).top = paramRectF.top;
          paramPath.arcTo((RectF)localObject, 270.0F, -90.0F);
          ((RectF)localObject).right = (paramRectF.left + f1);
          ((RectF)localObject).bottom = paramRectF.bottom;
          ((RectF)localObject).top = (paramRectF.bottom - f1);
          paramPath.arcTo((RectF)localObject, 180.0F, -90.0F);
          ((RectF)localObject).right = paramRectF.right;
          ((RectF)localObject).left = (paramRectF.right - f1);
          ((RectF)localObject).top = (paramRectF.bottom - f1);
          paramPath.arcTo((RectF)localObject, 90.0F, -90.0F);
          ((RectF)localObject).bottom = (paramRectF.top + f2);
          ((RectF)localObject).left = (paramRectF.right - f2);
          ((RectF)localObject).top = paramRectF.top;
          paramPath.arcTo((RectF)localObject, 0.0F, -90.0F);
          paramPath.close();
          return;
        }
        Object localObject = this.mArkView.getResources();
        float f4 = dp2px(10.0F, (Resources)localObject);
        f1 = this.mClipRadius * this.mScale * 2.0F;
        f2 = dp2px(5.0F, (Resources)localObject);
        float f3;
        float f5;
        float f6;
        float f7;
        float f8;
        float f9;
        float f10;
        if (this.mAlignLeft)
        {
          paramRectF.left += f4;
          paramRectF.right -= f4;
          f3 = dp2px(12.0F, (Resources)localObject);
          f4 = dp2px(8.0F, (Resources)localObject);
          f5 = dp2px(4.0F, (Resources)localObject);
          f6 = dp2px(10.0F, (Resources)localObject);
          f7 = dp2px(10.0F, (Resources)localObject);
          f8 = dp2px(16.0F, (Resources)localObject);
          f9 = dp2px(1.0F, (Resources)localObject);
          f10 = dp2px(14.0F, (Resources)localObject);
          localObject = new RectF();
          paramPath.moveTo(f3, f4);
          paramPath.quadTo(f5, f6, 0.0F, f2);
          paramPath.quadTo(f9, f10, f7, f8);
          ((RectF)localObject).right = (paramRectF.left + f1);
          ((RectF)localObject).bottom = paramRectF.bottom;
          ((RectF)localObject).left = paramRectF.left;
          ((RectF)localObject).top = (paramRectF.bottom - f1);
          paramPath.arcTo((RectF)localObject, 180.0F, -90.0F);
          ((RectF)localObject).right = paramRectF.right;
          ((RectF)localObject).left = (paramRectF.right - f1);
          paramPath.arcTo((RectF)localObject, 90.0F, -90.0F);
          ((RectF)localObject).bottom = (paramRectF.top + f1);
          ((RectF)localObject).top = paramRectF.top;
          paramPath.arcTo((RectF)localObject, 0.0F, -90.0F);
          ((RectF)localObject).right = (paramRectF.left + f1);
          ((RectF)localObject).left = paramRectF.left;
          paramPath.arcTo((RectF)localObject, 270.0F, -62.0F);
        }
        else
        {
          f3 = paramRectF.width();
          paramRectF.left += f4;
          paramRectF.right -= f4;
          f4 = dp2px(12.0F, (Resources)localObject);
          f5 = dp2px(8.0F, (Resources)localObject);
          f6 = dp2px(4.0F, (Resources)localObject);
          f7 = dp2px(10.0F, (Resources)localObject);
          f8 = dp2px(10.0F, (Resources)localObject);
          f9 = dp2px(16.0F, (Resources)localObject);
          f10 = dp2px(1.0F, (Resources)localObject);
          float f11 = dp2px(14.0F, (Resources)localObject);
          localObject = new RectF();
          paramPath.moveTo(f3 - f4, f5);
          paramPath.quadTo(f3 - f6, f7, f3, f2);
          paramPath.quadTo(f3 - f10, f11, f3 - f8, f9);
          ((RectF)localObject).right = paramRectF.right;
          ((RectF)localObject).bottom = paramRectF.bottom;
          ((RectF)localObject).left = (paramRectF.right - f1);
          ((RectF)localObject).top = (paramRectF.bottom - f1);
          paramPath.arcTo((RectF)localObject, 0.0F, 90.0F);
          ((RectF)localObject).right = (paramRectF.left + f1);
          ((RectF)localObject).left = paramRectF.left;
          paramPath.arcTo((RectF)localObject, 90.0F, 90.0F);
          ((RectF)localObject).bottom = (paramRectF.top + f1);
          ((RectF)localObject).top = paramRectF.top;
          paramPath.arcTo((RectF)localObject, 180.0F, 90.0F);
          ((RectF)localObject).right = paramRectF.right;
          ((RectF)localObject).left = (paramRectF.right - f1);
          paramPath.arcTo((RectF)localObject, 270.0F, 62.0F);
        }
        paramPath.close();
        return;
      }
      float f1 = this.mClipRadius;
      float f2 = this.mScale;
      paramPath.addRoundRect(paramRectF, f1 * f2, f1 * f2, Path.Direction.CCW);
      return;
    }
    paramPath.addRect(paramRectF, Path.Direction.CCW);
  }
  
  public boolean onCheckIsTextEditor()
  {
    return true;
  }
  
  public InputConnection onCreateInputConnection(EditorInfo paramEditorInfo)
  {
    paramEditorInfo.actionLabel = null;
    paramEditorInfo.label = "TEXT";
    paramEditorInfo.inputType = 1;
    int i = this.mInputType;
    if (i == 0) {
      paramEditorInfo.inputType = 1;
    } else if (i == 1) {
      paramEditorInfo.inputType = 128;
    } else if (i == 2) {
      paramEditorInfo.inputType = 4098;
    } else if (i == 3) {
      paramEditorInfo.inputType = 32;
    } else if (i == 4) {
      paramEditorInfo.inputType = 8194;
    } else if (i == 5) {
      paramEditorInfo.inputType = 3;
    }
    paramEditorInfo.imeOptions = 1;
    return new ArkViewImplement.ArkInputConnection(this, this.mArkView, this, true);
  }
  
  void onDestroy()
  {
    Object localObject = this.mInputCallback;
    if (localObject != null) {
      ((ArkViewImplement.InputCallback)localObject).onHideMenu(this.mArkView);
    }
    if (this.mInputFocus)
    {
      localObject = this.mImm;
      if (localObject != null) {
        ((InputMethodManager)localObject).hideSoftInputFromWindow(this.mArkView.getWindowToken(), 0);
      }
    }
  }
  
  public void onFirstPaint()
  {
    this.mViewInterface.onFirstPaint();
  }
  
  void onInputFocusChanged(boolean paramBoolean1, boolean paramBoolean2, int paramInt, Rect paramRect)
  {
    this.mInputFocus = paramBoolean1;
    this.mInputReadOnly = paramBoolean2;
    this.mInputType = paramInt;
    this.mInputRect = paramRect;
    if (this.mImm == null) {
      this.mImm = ((InputMethodManager)this.mArkView.getContext().getSystemService("input_method"));
    }
    if ((paramBoolean1) && (!this.mInputReadOnly))
    {
      this.mArkView.setFocusableInTouchMode(true);
      this.mArkView.setFocusable(true);
      this.mArkView.requestFocus();
      this.mImm.restartInput(this.mArkView);
      this.mImm.showSoftInput(this.mArkView, 0);
      Logger.logI("ArkApp.ArkViewImplement", String.format("onInputFocusChanged showSoftInput. view: %h", new Object[] { this }));
    }
    else
    {
      this.mImm.hideSoftInputFromWindow(this.mArkView.getWindowToken(), 0);
    }
    paramRect = this.mInputCallback;
    if (paramRect != null) {
      paramRect.onFocusChanged(this.mArkView, paramBoolean1);
    }
  }
  
  void onInputMenuChanged(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.mInputCallback == null) {
      return;
    }
    int[] arrayOfInt = new int[2];
    this.mArkView.getLocationInWindow(arrayOfInt);
    if (paramBoolean)
    {
      if (!this.mIpnutNeedHide)
      {
        this.mInputCallback.onShowMenu(this.mArkView, paramInt1 + arrayOfInt[0], paramInt2 + arrayOfInt[1], paramInt3, paramInt4);
        this.mArkView.requestFocus();
      }
    }
    else {
      this.mInputCallback.onHideMenu(this.mArkView);
    }
  }
  
  void onInputSelectChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4, Rect paramRect)
  {
    this.mInputRect = paramRect;
    paramRect = this.mInputCallback;
    if (paramRect != null)
    {
      if (this.mIpnutNeedHide) {
        return;
      }
      paramRect.onSelectChanged(this.mArkView, paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  boolean onInvalidate(Rect paramRect)
  {
    if (this.mArkViewModel != null)
    {
      ArkViewImplement.ArkViewInterface localArkViewInterface = this.mViewInterface;
      if (localArkViewInterface != null)
      {
        localArkViewInterface.onInvalidate(paramRect);
        return true;
      }
    }
    Logger.logE("ArkApp.ArkViewImplement", String.format("onInvalidate.return.1.wrapper: null uiview: %h", new Object[] { this }));
    return false;
  }
  
  public void onLoadFailed(String paramString, int paramInt, boolean paramBoolean)
  {
    Logger.logI("ArkApp.ArkViewImplement", String.format("onLoadFailed, this=%h,mLoadCallback=%h", new Object[] { this, this.mLoadCallback }));
    this.mViewInterface.onLoadFailed(paramString, paramInt, paramBoolean);
    this.mLoadState = -1;
    ArkViewImplement.LoadCallback localLoadCallback = this.mLoadCallback;
    if (localLoadCallback != null) {
      localLoadCallback.onLoadFailed(this.mLoadState, paramInt, paramString, paramBoolean);
    }
  }
  
  public void onLoadSuccess()
  {
    this.mViewInterface.onLoadSuccess();
    Logger.logI("ArkApp.ArkViewImplement", String.format("onLoadSuccess, this=%h,mLoadCallback=%h", new Object[] { this, this.mLoadCallback }));
    if (this.mArkView.getVisibility() != 0) {
      this.mArkView.setVisibility(0);
    }
    this.mViewInterface.checkSurfaceAvailable();
    this.mArkView.requestLayout();
    this.mLoadState = 1;
    ArkViewImplement.LoadCallback localLoadCallback = this.mLoadCallback;
    if (localLoadCallback != null) {
      localLoadCallback.onLoadState(this.mLoadState);
    }
  }
  
  public void onLoading()
  {
    this.mViewInterface.onLoading();
    this.mLoadState = 0;
    ArkViewImplement.LoadCallback localLoadCallback = this.mLoadCallback;
    if (localLoadCallback != null) {
      localLoadCallback.onLoadState(this.mLoadState);
    }
  }
  
  void onStartTemporaryDetach()
  {
    if (this.mArkViewModel != null)
    {
      if (ENV.mIsDebug) {
        Logger.logE("ArkApp.ArkViewImplement", String.format("onStartTemporaryDetach.wrapper: %h uiview: %h", new Object[] { this.mArkViewModel, this }));
      }
      this.mArkViewModel.activateView(false);
    }
  }
  
  void onSyncRect(Rect paramRect)
  {
    ArkViewModel localArkViewModel = this.mArkViewModel;
    if (localArkViewModel == null)
    {
      Logger.logE("ArkApp.ArkViewImplement", String.format("onSyncRect.return.mArkViewModel: null uiview: %h", new Object[] { this }));
      return;
    }
    paramRect = localArkViewModel.scaleRect(paramRect);
    if (!paramRect.equals(this.mRectView))
    {
      this.mRectView.set(paramRect);
      if (ENV.mIsDebug) {
        Logger.logI("ArkApp.ArkViewImplement", StringUtil.format("onSyncRect.vm.%h.measure.(%d, %d)", new Object[] { this.mArkViewModel, Integer.valueOf(this.mRectView.width()), Integer.valueOf(this.mRectView.height()) }));
      }
      paramRect = this.mArkView.getLayoutParams();
      paramRect.width = this.mRectView.width();
      paramRect.height = this.mRectView.height();
    }
    onLoadSuccess();
  }
  
  boolean ptInInputArea(int paramInt1, int paramInt2)
  {
    return new Rect(this.mInputRect.left - this.mHolderWidth - 10, this.mInputRect.top - this.mHolderHeight - 10, this.mInputRect.right + this.mHolderWidth + 10, this.mInputRect.bottom + 10).contains(paramInt1, paramInt2);
  }
  
  Bitmap recreateBitmapBuffer(Rect paramRect)
  {
    if (!paramRect.isEmpty())
    {
      ArkViewImplement.ArkViewInterface localArkViewInterface = this.mViewInterface;
      if (localArkViewInterface != null) {
        return localArkViewInterface.recreateBitmapBuffer(paramRect);
      }
    }
    Logger.logE("ArkApp.ArkViewImplement", String.format("recreateBitmapBuffer.return.null uiview: %h", new Object[] { this }));
    return null;
  }
  
  void refreshDrawPath(Rect paramRect, Path paramPath)
  {
    paramPath.reset();
    if (this.mBorderType != 0)
    {
      RectF localRectF = new RectF(0.0F, 0.0F, paramRect.width(), paramRect.height());
      if ((this.mBorderType == 2) && (!this.mAlignLeft)) {
        paramRect = Path.Direction.CCW;
      } else {
        paramRect = Path.Direction.CW;
      }
      paramPath.addRect(localRectF, paramRect);
      makePath(localRectF, paramPath);
    }
  }
  
  public void resetInputState()
  {
    ArkViewImplement.InputCallback localInputCallback = this.mInputCallback;
    if (localInputCallback != null)
    {
      localInputCallback.onHideMenu(this.mArkView);
      this.mInputCallback.onSelectChanged(this.mArkView, 0, 0, 0, 0);
    }
  }
  
  public void setFixSize(int paramInt1, int paramInt2)
  {
    ArkViewModel localArkViewModel = this.mArkViewModel;
    if (localArkViewModel != null) {
      localArkViewModel.setFixSize(paramInt1, paramInt2);
    }
  }
  
  public void setInputSetCaretHolderSize(int paramInt1, int paramInt2)
  {
    ArkViewModel localArkViewModel = this.mArkViewModel;
    if (localArkViewModel == null) {
      return;
    }
    localArkViewModel.SafeAsyncRun(new ArkViewImplement.4(this, paramInt1, paramInt2));
  }
  
  public void setInputSetSelectHolderSize(int paramInt1, int paramInt2)
  {
    this.mHolderWidth = paramInt1;
    this.mHolderHeight = paramInt2;
    ArkViewModel localArkViewModel = this.mArkViewModel;
    if (localArkViewModel == null) {
      return;
    }
    localArkViewModel.SafeAsyncRun(new ArkViewImplement.3(this, paramInt1, paramInt2));
  }
  
  protected void setInputText(CharSequence paramCharSequence)
  {
    if (this.mArkViewModel == null) {
      return;
    }
    paramCharSequence = paramCharSequence.toString();
    this.mArkViewModel.SafeAsyncRun(new ArkViewImplement.5(this, paramCharSequence));
  }
  
  public void setMaxSize(int paramInt1, int paramInt2)
  {
    ArkViewModel localArkViewModel = this.mArkViewModel;
    if (localArkViewModel != null) {
      localArkViewModel.setMaxSize(paramInt1, paramInt2);
    }
  }
  
  public void setMinSize(int paramInt1, int paramInt2)
  {
    ArkViewModel localArkViewModel = this.mArkViewModel;
    if (localArkViewModel != null) {
      localArkViewModel.setMinSize(paramInt1, paramInt2);
    }
  }
  
  public void setViewRect(int paramInt1, int paramInt2)
  {
    Object localObject = this.mArkViewModel;
    if (localObject != null)
    {
      float f = ((ArkViewModel)localObject).getScale();
      localObject = new Rect(0, 0, (int)(paramInt1 / f), (int)(paramInt2 / f));
      this.mArkViewModel.setViewRect((Rect)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ark.ArkViewImplement
 * JD-Core Version:    0.7.0.1
 */