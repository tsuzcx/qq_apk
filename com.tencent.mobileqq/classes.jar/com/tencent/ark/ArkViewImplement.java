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
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnLayoutChangeListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewParent;
import android.view.inputmethod.BaseInputConnection;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import java.util.Locale;

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
  protected ArkViewModel mArkViewModel;
  public int mBorderType = 1;
  public float mClipRadius = 6.0F;
  public float mClipRadiusTop = 6.0F;
  protected int mHolderHeight = 0;
  protected int mHolderWidth = 0;
  protected InputMethodManager mImm = null;
  protected InputCallback mInputCallback = null;
  protected boolean mInputFocus = false;
  protected boolean mInputReadOnly = false;
  protected Rect mInputRect = new Rect();
  protected int mInputType = 0;
  protected boolean mIpnutNeedHide = false;
  LoadCallback mLoadCallback = null;
  protected int mLoadState = 0;
  private boolean mLongClickTriggered = false;
  public boolean mOpaque = false;
  public Rect mRectView = new Rect();
  public boolean mRound = false;
  public float mScale = 1.0F;
  protected ArkViewInterface mViewInterface;
  
  static
  {
    sPaintCanvas = new Paint();
    sPaintOpaque.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
    sPaintCanvas.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
    sPaintPath.setColor(0);
    sPaintPath.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
  }
  
  ArkViewImplement(View paramView, ArkViewInterface paramArkViewInterface)
  {
    this.mArkView = paramView;
    this.mViewInterface = paramArkViewInterface;
    this.mArkView.setOnFocusChangeListener(new View.OnFocusChangeListener()
    {
      public void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        if ((ArkViewImplement.this.mArkView == paramAnonymousView) && (ArkViewImplement.this.mImm != null) && (!paramAnonymousBoolean)) {}
      }
    });
    this.mArkView.addOnLayoutChangeListener(new View.OnLayoutChangeListener()
    {
      public void onLayoutChange(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8)
      {
        if ((paramAnonymousView != ArkViewImplement.this.mArkView) || ((paramAnonymousInt1 == paramAnonymousInt5) && (paramAnonymousInt3 == paramAnonymousInt7) && (paramAnonymousInt2 == paramAnonymousInt6) && (paramAnonymousInt4 == paramAnonymousInt8))) {
          return;
        }
        if (ArkViewImplement.this.mInputCallback != null)
        {
          ArkViewImplement.this.mInputCallback.onHideMenu(ArkViewImplement.this.mArkView);
          ArkViewImplement.this.mInputCallback.onSelectChanged(0, 0, 0, 0);
        }
        ArkViewImplement.this.mIpnutNeedHide = true;
        ArkDispatchTask.getInstance().postToMainThreadDelayed(new Runnable()
        {
          public void run()
          {
            ArkViewImplement.this.mIpnutNeedHide = false;
          }
        }, 800L);
      }
    });
  }
  
  private static int dp2px(float paramFloat, Resources paramResources)
  {
    return (int)(paramResources.getDisplayMetrics().density * paramFloat + 0.5F);
  }
  
  protected void deleteInputText()
  {
    ArkDispatchTask.getInstance().post(new Runnable()
    {
      public void run()
      {
        ArkViewImplement.this.mArkViewModel.InputDeleteBackward();
      }
    });
  }
  
  void destroyBitmapBuffer()
  {
    if (this.mViewInterface != null) {
      this.mViewInterface.destroyBitmapBuffer();
    }
  }
  
  void doDetach(ArkViewModelBase paramArkViewModelBase)
  {
    if (paramArkViewModelBase == this.mArkViewModel) {
      this.mArkViewModel = null;
    }
    resetInputState();
  }
  
  public void doInputCommand(final int paramInt)
  {
    if (paramInt == 3)
    {
      localObject = (ClipboardManager)this.mArkView.getContext().getSystemService("clipboard");
      if (((ClipboardManager)localObject).getText() == null) {}
    }
    for (Object localObject = ((ClipboardManager)localObject).getText().toString();; localObject = "")
    {
      ArkDispatchTask.getInstance().post(new Runnable()
      {
        public void run()
        {
          switch (paramInt)
          {
          default: 
            return;
          case 1: 
            ArkViewImplement.this.mArkViewModel.InputSelect();
            return;
          case 2: 
            ArkViewImplement.this.mArkViewModel.InputSelectAll();
            return;
          case 3: 
            ArkViewImplement.this.mArkViewModel.InputInsertText(this.val$arkPasteData);
            return;
          case 4: 
            str = ArkViewImplement.this.mArkViewModel.InputGetSelectText();
            ArkDispatchTask.getInstance().postToMainThread(new Runnable()
            {
              public void run()
              {
                ((ClipboardManager)ArkViewImplement.this.mArkView.getContext().getSystemService("clipboard")).setText(str);
              }
            });
            return;
          }
          final String str = ArkViewImplement.this.mArkViewModel.InputGetSelectText();
          ArkDispatchTask.getInstance().postToMainThread(new Runnable()
          {
            public void run()
            {
              ((ClipboardManager)ArkViewImplement.this.mArkView.getContext().getSystemService("clipboard")).setText(str);
            }
          });
          ArkViewImplement.this.mArkViewModel.InputDeleteBackward();
        }
      });
      return;
    }
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
  
  Bitmap getBitmapBuffer()
  {
    if (this.mViewInterface == null) {
      return null;
    }
    return this.mViewInterface.getBitmapBuffer();
  }
  
  public Rect getInputRect()
  {
    if (this.mArkViewModel != null) {
      return this.mArkViewModel.scaleRect(this.mInputRect);
    }
    return new Rect();
  }
  
  public View getView()
  {
    return this.mArkView;
  }
  
  public ArkViewModel getViewModel()
  {
    return this.mArkViewModel;
  }
  
  void initArkView(ArkViewModel paramArkViewModel)
  {
    if (paramArkViewModel == null) {}
    do
    {
      return;
      if (ENV.mIsDebug) {
        ENV.logI("ArkApp.ArkViewImplement", String.format("initArkView.viewModel.%h", new Object[] { paramArkViewModel }));
      }
      if (this.mArkViewModel == paramArkViewModel)
      {
        paramArkViewModel.activateView(true);
        paramArkViewModel.postInvalid();
        if (this.mLoadCallback != null) {
          this.mLoadCallback.onLoadFinish(this.mLoadState);
        }
        ENV.logI("ArkApp.ArkViewImplement", String.format("initArkView.1.same wrapper: %s, wrapper: %h view: %h", new Object[] { this.mRectView.toString(), paramArkViewModel, this }));
        return;
      }
      this.mArkView.setVisibility(4);
      if (this.mArkViewModel != null) {
        this.mArkViewModel.detachView();
      }
      this.mScale = paramArkViewModel.getScale();
      this.mRound = paramArkViewModel.mRoundCorner;
      this.mArkViewModel = paramArkViewModel;
      paramArkViewModel.attachView(this);
      Rect localRect = paramArkViewModel.getContainerRect();
      if (localRect.isEmpty()) {
        localRect.set(0, 0, paramArkViewModel.getWidth(), paramArkViewModel.getHeight());
      }
      this.mRectView = paramArkViewModel.scaleRect(localRect);
    } while (this.mRectView.isEmpty());
    if (ENV.mIsDebug) {
      ENV.logI("ArkApp.ArkViewImplement", String.format(Locale.CHINA, "initArkView.vm.%h.measure.(%d, %d)", new Object[] { paramArkViewModel, Integer.valueOf(this.mRectView.width()), Integer.valueOf(this.mRectView.height()) }));
    }
    paramArkViewModel = this.mArkView.getLayoutParams();
    paramArkViewModel.width = this.mRectView.width();
    paramArkViewModel.height = this.mRectView.height();
  }
  
  public void makePath(RectF paramRectF, Path paramPath)
  {
    switch (this.mBorderType)
    {
    default: 
      return;
    case 2: 
      localObject = this.mArkView.getResources();
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
      for (;;)
      {
        paramPath.close();
        return;
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
    case 1: 
      paramPath.addRoundRect(paramRectF, this.mClipRadius * this.mScale, this.mClipRadius * this.mScale, Path.Direction.CCW);
      return;
    case 0: 
      paramPath.addRect(paramRectF, Path.Direction.CCW);
      return;
    }
    float f1 = this.mClipRadiusTop * this.mScale * 2.0F;
    float f2 = this.mClipRadius * this.mScale * 2.0F;
    Object localObject = new RectF();
    ((RectF)localObject).right = (paramRectF.left + f1);
    ((RectF)localObject).bottom = (paramRectF.top + f1);
    ((RectF)localObject).left = paramRectF.left;
    ((RectF)localObject).top = paramRectF.top;
    paramPath.arcTo((RectF)localObject, 270.0F, -90.0F);
    ((RectF)localObject).right = (paramRectF.left + f2);
    ((RectF)localObject).bottom = paramRectF.bottom;
    ((RectF)localObject).top = (paramRectF.bottom - f2);
    paramPath.arcTo((RectF)localObject, 180.0F, -90.0F);
    ((RectF)localObject).right = paramRectF.right;
    ((RectF)localObject).left = (paramRectF.right - f2);
    ((RectF)localObject).top = (paramRectF.bottom - f2);
    paramPath.arcTo((RectF)localObject, 90.0F, -90.0F);
    ((RectF)localObject).bottom = (paramRectF.top + f1);
    ((RectF)localObject).left = (paramRectF.right - f1);
    ((RectF)localObject).top = paramRectF.top;
    paramPath.arcTo((RectF)localObject, 0.0F, -90.0F);
    paramPath.close();
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
    if (this.mInputType == 0) {
      paramEditorInfo.inputType = 1;
    }
    for (;;)
    {
      paramEditorInfo.imeOptions = 1;
      return new ArkInputConnection(this.mArkView, this, true);
      if (this.mInputType == 1) {
        paramEditorInfo.inputType = 128;
      } else if (this.mInputType == 2) {
        paramEditorInfo.inputType = 4098;
      } else if (this.mInputType == 3) {
        paramEditorInfo.inputType = 32;
      } else if (this.mInputType == 4) {
        paramEditorInfo.inputType = 8194;
      } else if (this.mInputType == 5) {
        paramEditorInfo.inputType = 3;
      }
    }
  }
  
  void onDestroy()
  {
    if (this.mInputCallback != null) {
      this.mInputCallback.onHideMenu(this.mArkView);
    }
    if ((this.mInputFocus) && (this.mImm != null)) {
      this.mImm.hideSoftInputFromWindow(this.mArkView.getWindowToken(), 0);
    }
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
      ENV.logI("ArkApp.ArkViewImplement", String.format("onInputFocusChanged showSoftInput. view: %h", new Object[] { this }));
    }
    for (;;)
    {
      if (this.mInputCallback != null) {
        this.mInputCallback.onFocusChanged(paramBoolean1);
      }
      return;
      this.mImm.hideSoftInputFromWindow(this.mArkView.getWindowToken(), 0);
    }
  }
  
  void onInputMenuChanged(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.mInputCallback == null) {}
    int[] arrayOfInt;
    do
    {
      return;
      arrayOfInt = new int[2];
      this.mArkView.getLocationInWindow(arrayOfInt);
      if (!paramBoolean) {
        break;
      }
    } while (this.mIpnutNeedHide);
    this.mInputCallback.onShowMenu(this.mArkView, arrayOfInt[0] + paramInt1, arrayOfInt[1] + paramInt2, paramInt3, paramInt4);
    this.mArkView.requestFocus();
    return;
    this.mInputCallback.onHideMenu(this.mArkView);
  }
  
  void onInputSelectChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4, Rect paramRect)
  {
    this.mInputRect = paramRect;
    if ((this.mInputCallback == null) || (this.mIpnutNeedHide)) {
      return;
    }
    this.mInputCallback.onSelectChanged(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  boolean onInvalidate(Rect paramRect)
  {
    if ((this.mArkViewModel == null) || (this.mViewInterface == null))
    {
      ENV.logE("ArkApp.ArkViewImplement", String.format("onInvalidate.return.1.wrapper: null uiview: %h", new Object[] { this }));
      return false;
    }
    this.mViewInterface.onInvalidate(paramRect);
    return true;
  }
  
  public void onLoadFailed(String paramString, int paramInt, boolean paramBoolean)
  {
    this.mViewInterface.onLoadFailed(paramString, paramInt, paramBoolean);
    this.mLoadState = -1;
    if (this.mLoadCallback != null) {
      this.mLoadCallback.onLoadFinish(this.mLoadState);
    }
  }
  
  public void onLoadSuccess()
  {
    this.mViewInterface.onLoadSuccess();
    this.mArkView.setVisibility(0);
    this.mArkView.requestLayout();
    this.mLoadState = 1;
    if (this.mLoadCallback != null) {
      this.mLoadCallback.onLoadFinish(this.mLoadState);
    }
  }
  
  public void onLoading()
  {
    this.mViewInterface.onLoading();
    this.mLoadState = 0;
    if (this.mLoadCallback != null) {
      this.mLoadCallback.onLoadFinish(this.mLoadState);
    }
  }
  
  void onStartTemporaryDetach()
  {
    if (this.mArkViewModel != null)
    {
      if (ENV.mIsDebug) {
        ENV.logE("ArkApp.ArkViewImplement", String.format("onStartTemporaryDetach.wrapper: %h uiview: %h", new Object[] { this.mArkViewModel, this }));
      }
      this.mArkViewModel.activateView(false);
    }
  }
  
  void onSyncRect(Rect paramRect)
  {
    if (this.mArkViewModel == null) {
      return;
    }
    paramRect = this.mArkViewModel.scaleRect(paramRect);
    if (!paramRect.equals(this.mRectView))
    {
      this.mRectView.set(paramRect);
      if (ENV.mIsDebug) {
        ENV.logI("ArkApp.ArkViewImplement", String.format(Locale.CHINA, "onSyncRect.vm.%h.measure.(%d, %d)", new Object[] { this.mArkViewModel, Integer.valueOf(this.mRectView.width()), Integer.valueOf(this.mRectView.height()) }));
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
    if ((paramRect.isEmpty()) || (this.mViewInterface == null))
    {
      ENV.logE("ArkApp.ArkViewImplement", String.format("recreateBitmapBuffer.return.null uiview: %h", new Object[] { this }));
      return null;
    }
    return this.mViewInterface.recreateBitmapBuffer(paramRect);
  }
  
  void refreshDrawPath(Rect paramRect, Path paramPath)
  {
    paramPath.reset();
    RectF localRectF;
    if (this.mBorderType != 0)
    {
      localRectF = new RectF(0.0F, 0.0F, paramRect.width(), paramRect.height());
      if ((this.mBorderType != 2) || (this.mAlignLeft)) {
        break label63;
      }
    }
    label63:
    for (paramRect = Path.Direction.CCW;; paramRect = Path.Direction.CW)
    {
      paramPath.addRect(localRectF, paramRect);
      makePath(localRectF, paramPath);
      return;
    }
  }
  
  public void resetInputState()
  {
    if (this.mInputCallback != null)
    {
      this.mInputCallback.onHideMenu(this.mArkView);
      this.mInputCallback.onSelectChanged(0, 0, 0, 0);
    }
  }
  
  public void setInputSetCaretHolderSize(final int paramInt1, final int paramInt2)
  {
    if (this.mArkViewModel == null) {
      return;
    }
    ArkDispatchTask.getInstance().post(new Runnable()
    {
      public void run()
      {
        ArkViewImplement.this.mArkViewModel.InputSetCaretHolderSize(paramInt1, paramInt2);
      }
    });
  }
  
  public void setInputSetSelectHolderSize(final int paramInt1, final int paramInt2)
  {
    this.mHolderWidth = paramInt1;
    this.mHolderHeight = paramInt2;
    if (this.mArkViewModel == null) {
      return;
    }
    ArkDispatchTask.getInstance().post(new Runnable()
    {
      public void run()
      {
        ArkViewImplement.this.mArkViewModel.InputSetSelectHolderSize(paramInt1, paramInt2);
      }
    });
  }
  
  protected void setInputText(final CharSequence paramCharSequence)
  {
    paramCharSequence = paramCharSequence.toString();
    ArkDispatchTask.getInstance().post(new Runnable()
    {
      public void run()
      {
        ArkViewImplement.this.mArkViewModel.InputInsertText(paramCharSequence);
      }
    });
  }
  
  class ArkInputConnection
    extends BaseInputConnection
  {
    ArkViewImplement mHolder;
    
    public ArkInputConnection(View paramView, ArkViewImplement paramArkViewImplement, boolean paramBoolean)
    {
      super(paramBoolean);
      this.mHolder = paramArkViewImplement;
    }
    
    public boolean commitText(CharSequence paramCharSequence, int paramInt)
    {
      this.mHolder.setInputText(paramCharSequence);
      return true;
    }
    
    public boolean deleteSurroundingText(int paramInt1, int paramInt2)
    {
      int i = paramInt1;
      if (paramInt2 == 0) {
        for (;;)
        {
          int j = paramInt1 - 1;
          i = j;
          if (paramInt1 <= 0) {
            break;
          }
          this.mHolder.deleteInputText();
          paramInt1 = j;
        }
      }
      return super.deleteSurroundingText(i, paramInt2);
    }
    
    public boolean sendKeyEvent(KeyEvent paramKeyEvent)
    {
      int i;
      if (paramKeyEvent.getAction() == 0)
      {
        i = paramKeyEvent.getKeyCode();
        if (i != 67) {
          break label31;
        }
        this.mHolder.deleteInputText();
      }
      for (;;)
      {
        return super.sendKeyEvent(paramKeyEvent);
        label31:
        if (i == 66)
        {
          this.mHolder.setInputText("\n");
        }
        else if (((i >= 7) && (i <= 18)) || ((i >= 55) && (i <= 56)))
        {
          char c = (char)paramKeyEvent.getUnicodeChar();
          this.mHolder.setInputText(Character.toString(c));
        }
      }
    }
  }
  
  public static abstract interface ArkViewInterface
  {
    public abstract void destroyBitmapBuffer();
    
    public abstract void doDetach(ArkViewModel paramArkViewModel);
    
    public abstract void doInputCommand(int paramInt);
    
    public abstract Bitmap getBitmapBuffer();
    
    public abstract Rect getInputRect();
    
    public abstract void initArkView(ArkViewModel paramArkViewModel);
    
    public abstract boolean onInvalidate(Rect paramRect);
    
    public abstract void onLoadFailed(String paramString, int paramInt, boolean paramBoolean);
    
    public abstract void onLoadSuccess();
    
    public abstract void onLoading();
    
    public abstract boolean onLongClick(View paramView);
    
    public abstract boolean onTouch(View paramView, MotionEvent paramMotionEvent);
    
    public abstract Bitmap recreateBitmapBuffer(Rect paramRect);
    
    public abstract void setAlignLeft(boolean paramBoolean);
    
    public abstract void setBorderType(int paramInt);
    
    public abstract void setClipRadius(float paramFloat);
    
    public abstract void setClipRadiusTop(float paramFloat);
    
    public abstract void setContentDescription(CharSequence paramCharSequence);
    
    public abstract void setInputCallback(ArkViewImplement.InputCallback paramInputCallback);
    
    public abstract void setInputSetCaretHolderSize(int paramInt1, int paramInt2);
    
    public abstract void setInputSetSelectHolderSize(int paramInt1, int paramInt2);
    
    public abstract void setLoadCallback(ArkViewImplement.LoadCallback paramLoadCallback);
    
    public abstract void setOnLongClickListener(View.OnLongClickListener paramOnLongClickListener);
    
    public abstract void setOnTouchListener(View.OnTouchListener paramOnTouchListener);
  }
  
  public static abstract interface InputCallback
  {
    public abstract void onFocusChanged(boolean paramBoolean);
    
    public abstract void onHideMenu(View paramView);
    
    public abstract void onSelectChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
    
    public abstract void onShowMenu(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  }
  
  public static abstract interface LoadCallback
  {
    public abstract void onLoadFinish(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ark.ArkViewImplement
 * JD-Core Version:    0.7.0.1
 */