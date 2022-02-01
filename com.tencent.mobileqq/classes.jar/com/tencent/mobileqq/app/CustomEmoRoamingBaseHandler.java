package com.tencent.mobileqq.app;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.CustomEmotionBase;

public abstract class CustomEmoRoamingBaseHandler<T extends CustomEmotionBase>
  extends BusinessHandler
{
  public AppInterface b;
  
  protected CustomEmoRoamingBaseHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
    this.b = paramAppInterface;
  }
  
  public abstract void a();
  
  protected abstract void a(Object paramObject, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.CustomEmoRoamingBaseHandler
 * JD-Core Version:    0.7.0.1
 */