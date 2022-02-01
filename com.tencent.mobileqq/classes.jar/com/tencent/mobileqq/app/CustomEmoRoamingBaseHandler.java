package com.tencent.mobileqq.app;

import com.tencent.mobileqq.data.CustomEmotionBase;

public abstract class CustomEmoRoamingBaseHandler<T extends CustomEmotionBase>
  extends BusinessHandler
{
  public QQAppInterface a;
  
  protected CustomEmoRoamingBaseHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.a = paramQQAppInterface;
  }
  
  public abstract void a();
  
  protected abstract void a(Object paramObject, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.CustomEmoRoamingBaseHandler
 * JD-Core Version:    0.7.0.1
 */