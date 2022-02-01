package com.tencent.ark;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import org.json.JSONException;
import org.json.JSONObject;

public class ArkTextureView
  extends FrameLayout
  implements View.OnLongClickListener, View.OnTouchListener, ArkViewImplement.ArkViewInterface
{
  private static final ArkEnvironmentManager ENV = ;
  protected static String TAG = "ArkApp.ArkTextureView";
  private View mArkView;
  private Context mContext;
  private boolean mIsGpuRendering;
  protected boolean mOnStartTemporaryDetach = true;
  private ArkTextureView.ArkTextureViewInterface mTextureViewInterface;
  public ArkViewImplement mViewImpl;
  
  public ArkTextureView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mContext = paramContext;
    this.mViewImpl = new ArkViewImplement(this, this);
  }
  
  private void prepareForRendering(ArkViewModel paramArkViewModel)
  {
    boolean bool = paramArkViewModel.isGpuRenderingEnabled();
    if (bool != this.mIsGpuRendering) {
      this.mIsGpuRendering = bool;
    } else if (this.mArkView != null) {
      return;
    }
    if (this.mArkView != null)
    {
      removeAllViews();
      this.mArkView = null;
    }
    if (this.mIsGpuRendering) {
      paramArkViewModel = new ArkTextureViewImpl(this.mContext, this.mViewImpl);
    } else {
      paramArkViewModel = new ArkSoftwareView(this.mContext, this.mViewImpl);
    }
    this.mArkView = paramArkViewModel;
    paramArkViewModel = new FrameLayout.LayoutParams(-1, -1);
    addView(this.mArkView, paramArkViewModel);
    this.mTextureViewInterface = ((ArkTextureView.ArkTextureViewInterface)this.mArkView);
  }
  
  public void checkSurfaceAvailable()
  {
    this.mTextureViewInterface.checkSurfaceAvailable();
  }
  
  public void createViewContext()
  {
    this.mTextureViewInterface.createContext();
  }
  
  public void destroyBitmapBuffer()
  {
    this.mTextureViewInterface.destroyBitmapBuffer();
  }
  
  public void doDetach(ArkViewModel paramArkViewModel)
  {
    this.mViewImpl.doDetach(paramArkViewModel);
  }
  
  public void doInputCommand(int paramInt)
  {
    this.mViewImpl.doInputCommand(paramInt);
  }
  
  public Bitmap getBitmapBuffer()
  {
    return this.mTextureViewInterface.getBitmapBuffer();
  }
  
  public Rect getInputRect()
  {
    return this.mViewImpl.getInputRect();
  }
  
  public View getView()
  {
    return this.mArkView;
  }
  
  public void initArkView(ArkViewModel paramArkViewModel)
  {
    initArkView(paramArkViewModel, true);
  }
  
  public void initArkView(ArkViewModel paramArkViewModel, boolean paramBoolean)
  {
    prepareForRendering(paramArkViewModel);
    this.mTextureViewInterface.initArkView(paramArkViewModel);
    this.mViewImpl.initArkView(paramArkViewModel, paramBoolean);
  }
  
  public boolean onCheckIsTextEditor()
  {
    return this.mViewImpl.onCheckIsTextEditor();
  }
  
  public InputConnection onCreateInputConnection(EditorInfo paramEditorInfo)
  {
    return this.mViewImpl.onCreateInputConnection(paramEditorInfo);
  }
  
  public void onFirstPaint() {}
  
  public boolean onInvalidate(Rect paramRect)
  {
    return this.mTextureViewInterface.onInvalidate(paramRect);
  }
  
  public void onLoadFailed(String paramString, int paramInt, boolean paramBoolean) {}
  
  public void onLoadSuccess() {}
  
  public void onLoading() {}
  
  public boolean onLongClick(View paramView)
  {
    if (paramView == this) {
      return this.mViewImpl.doOnLongClick(paramView);
    }
    return false;
  }
  
  public void onStartTemporaryDetach()
  {
    super.onStartTemporaryDetach();
    if (this.mOnStartTemporaryDetach) {
      this.mViewImpl.onStartTemporaryDetach();
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramView == this) {
      return this.mViewImpl.doOnTouch(paramView, paramMotionEvent);
    }
    return false;
  }
  
  public Bitmap recreateBitmapBuffer(Rect paramRect)
  {
    return this.mTextureViewInterface.recreateBitmapBuffer(paramRect);
  }
  
  public void releaseViewContext()
  {
    this.mTextureViewInterface.releaseContext();
  }
  
  public void setAlignLeft(boolean paramBoolean)
  {
    this.mViewImpl.mAlignLeft = paramBoolean;
  }
  
  public void setBorderType(int paramInt)
  {
    this.mViewImpl.mBorderType = paramInt;
  }
  
  public void setClipRadius(float paramFloat)
  {
    this.mViewImpl.mClipRadius = paramFloat;
  }
  
  public void setClipRadiusTop(float paramFloat)
  {
    this.mViewImpl.mClipRadiusTop = paramFloat;
  }
  
  public void setFixSize(int paramInt1, int paramInt2)
  {
    this.mViewImpl.setFixSize(paramInt1, paramInt2);
  }
  
  public void setInputCallback(ArkViewImplement.InputCallback paramInputCallback)
  {
    this.mViewImpl.mInputCallback = paramInputCallback;
  }
  
  public void setInputSetCaretHolderSize(int paramInt1, int paramInt2)
  {
    this.mViewImpl.setInputSetCaretHolderSize(paramInt1, paramInt2);
  }
  
  public void setInputSetSelectHolderSize(int paramInt1, int paramInt2)
  {
    this.mViewImpl.setInputSetSelectHolderSize(paramInt1, paramInt2);
  }
  
  public void setLoadCallback(ArkViewImplement.LoadCallback paramLoadCallback)
  {
    this.mViewImpl.mLoadCallback = paramLoadCallback;
  }
  
  public void setMaxSize(int paramInt1, int paramInt2)
  {
    this.mViewImpl.setMaxSize(paramInt1, paramInt2);
  }
  
  public void setMinSize(int paramInt1, int paramInt2)
  {
    this.mViewImpl.setMinSize(paramInt1, paramInt2);
  }
  
  public void setViewPressed(boolean paramBoolean)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("pressed", paramBoolean);
    }
    catch (JSONException localJSONException)
    {
      String str = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setViewPressed JSONException e:");
      localStringBuilder.append(localJSONException.toString());
      Logger.logE(str, localStringBuilder.toString());
    }
    this.mViewImpl.doOnViewEvent("ViewPressed", localJSONObject.toString());
  }
  
  public void setViewRect(int paramInt1, int paramInt2)
  {
    this.mViewImpl.setViewRect(paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ark.ArkTextureView
 * JD-Core Version:    0.7.0.1
 */