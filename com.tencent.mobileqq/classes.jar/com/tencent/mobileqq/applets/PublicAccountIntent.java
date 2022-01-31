package com.tencent.mobileqq.applets;

import alkr;
import android.content.Context;
import mqq.app.NewIntent;
import mqq.app.Servlet;

public class PublicAccountIntent
  extends NewIntent
{
  private alkr a;
  
  public PublicAccountIntent(Context paramContext, Class<? extends Servlet> paramClass)
  {
    super(paramContext, paramClass);
  }
  
  public alkr a()
  {
    return this.a;
  }
  
  public void a(alkr paramalkr)
  {
    this.a = paramalkr;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.applets.PublicAccountIntent
 * JD-Core Version:    0.7.0.1
 */