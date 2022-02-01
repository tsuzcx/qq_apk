package com.tencent.mobileqq.app.message.messageclean;

import com.tencent.mobileqq.persistence.Entity;
import java.util.List;

public abstract interface IMessageDataListener
{
  public abstract void a(String paramString, Entity paramEntity);
  
  public abstract void a(String paramString, List<? extends Entity> paramList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.messageclean.IMessageDataListener
 * JD-Core Version:    0.7.0.1
 */