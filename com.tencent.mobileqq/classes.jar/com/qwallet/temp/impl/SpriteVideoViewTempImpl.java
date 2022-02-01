package com.qwallet.temp.impl;

import android.content.Context;
import android.view.View;
import com.qwallet.temp.ISpriteVideoViewTemp;
import com.qwallet.temp.ISpriteVideoViewTemp.OnFrameEndListener;
import com.tencent.mobileqq.surfaceviewaction.gl.SpriteVideoView;

public class SpriteVideoViewTempImpl
  implements ISpriteVideoViewTemp
{
  private final SpriteVideoView mSpriteVideoView;
  
  public SpriteVideoViewTempImpl(Context paramContext, boolean paramBoolean)
  {
    this.mSpriteVideoView = new SpriteVideoView(paramContext, paramBoolean);
  }
  
  public View getView()
  {
    return this.mSpriteVideoView;
  }
  
  public void play(String paramString, int paramInt, ISpriteVideoViewTemp.OnFrameEndListener paramOnFrameEndListener)
  {
    this.mSpriteVideoView.a(paramString, paramInt, new SpriteVideoViewTempImpl.1(this, paramOnFrameEndListener));
  }
  
  public void play(String paramString, ISpriteVideoViewTemp.OnFrameEndListener paramOnFrameEndListener)
  {
    this.mSpriteVideoView.a(paramString, new SpriteVideoViewTempImpl.2(this, paramOnFrameEndListener));
  }
  
  public void setCenterCrop(boolean paramBoolean)
  {
    this.mSpriteVideoView.setCenterCrop(paramBoolean);
  }
  
  public void setFilePath(String paramString)
  {
    this.mSpriteVideoView.setFilePath(paramString);
  }
  
  public void setId(int paramInt)
  {
    this.mSpriteVideoView.setId(paramInt);
  }
  
  public void setLooping(boolean paramBoolean)
  {
    this.mSpriteVideoView.setLooping(paramBoolean);
  }
  
  public void setPivotX(float paramFloat)
  {
    this.mSpriteVideoView.setPivotX(paramFloat);
  }
  
  public void setPivotY(float paramFloat)
  {
    this.mSpriteVideoView.setPivotY(paramFloat);
  }
  
  public void stop()
  {
    this.mSpriteVideoView.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.qwallet.temp.impl.SpriteVideoViewTempImpl
 * JD-Core Version:    0.7.0.1
 */