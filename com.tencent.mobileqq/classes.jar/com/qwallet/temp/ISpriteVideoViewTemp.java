package com.qwallet.temp;

import android.view.View;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;

@QAPI(process={"all"})
@QRouteFactory(singleton=false)
public abstract interface ISpriteVideoViewTemp
  extends QRouteApi
{
  public abstract View getView();
  
  public abstract void play(String paramString, int paramInt, ISpriteVideoViewTemp.OnFrameEndListener paramOnFrameEndListener);
  
  public abstract void play(String paramString, ISpriteVideoViewTemp.OnFrameEndListener paramOnFrameEndListener);
  
  public abstract void setCenterCrop(boolean paramBoolean);
  
  public abstract void setFilePath(String paramString);
  
  public abstract void setId(int paramInt);
  
  public abstract void setLooping(boolean paramBoolean);
  
  public abstract void setPivotX(float paramFloat);
  
  public abstract void setPivotY(float paramFloat);
  
  public abstract void stop();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.qwallet.temp.ISpriteVideoViewTemp
 * JD-Core Version:    0.7.0.1
 */