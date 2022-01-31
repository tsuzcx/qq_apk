package com.tencent.ark;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;

public abstract interface ArkViewImplement$ArkViewInterface
{
  public abstract void checkSurfaceAvailable();
  
  public abstract void createViewContext();
  
  public abstract void destroyBitmapBuffer();
  
  public abstract void doDetach(ArkViewModel paramArkViewModel);
  
  public abstract void doInputCommand(int paramInt);
  
  public abstract Bitmap getBitmapBuffer();
  
  public abstract Rect getInputRect();
  
  public abstract View getView();
  
  public abstract void initArkView(ArkViewModel paramArkViewModel);
  
  public abstract void initArkView(ArkViewModel paramArkViewModel, boolean paramBoolean);
  
  public abstract void onFirstPaint();
  
  public abstract boolean onInvalidate(Rect paramRect);
  
  public abstract void onLoadFailed(String paramString, int paramInt, boolean paramBoolean);
  
  public abstract void onLoadSuccess();
  
  public abstract void onLoading();
  
  public abstract boolean onLongClick(View paramView);
  
  public abstract boolean onTouch(View paramView, MotionEvent paramMotionEvent);
  
  public abstract Bitmap recreateBitmapBuffer(Rect paramRect);
  
  public abstract void releaseViewContext();
  
  public abstract void setAlignLeft(boolean paramBoolean);
  
  public abstract void setBorderType(int paramInt);
  
  public abstract void setClipRadius(float paramFloat);
  
  public abstract void setClipRadiusTop(float paramFloat);
  
  public abstract void setContentDescription(CharSequence paramCharSequence);
  
  public abstract void setFixSize(int paramInt1, int paramInt2);
  
  public abstract void setInputCallback(ArkViewImplement.InputCallback paramInputCallback);
  
  public abstract void setInputSetCaretHolderSize(int paramInt1, int paramInt2);
  
  public abstract void setInputSetSelectHolderSize(int paramInt1, int paramInt2);
  
  public abstract void setLoadCallback(ArkViewImplement.LoadCallback paramLoadCallback);
  
  public abstract void setMaxSize(int paramInt1, int paramInt2);
  
  public abstract void setMinSize(int paramInt1, int paramInt2);
  
  public abstract void setOnLongClickListener(View.OnLongClickListener paramOnLongClickListener);
  
  public abstract void setOnTouchListener(View.OnTouchListener paramOnTouchListener);
  
  public abstract void setViewRect(int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ark.ArkViewImplement.ArkViewInterface
 * JD-Core Version:    0.7.0.1
 */