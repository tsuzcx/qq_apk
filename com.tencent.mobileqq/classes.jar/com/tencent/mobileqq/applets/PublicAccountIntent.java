package com.tencent.mobileqq.applets;

import android.content.Context;
import anui;
import mqq.app.NewIntent;
import mqq.app.Servlet;

public class PublicAccountIntent
  extends NewIntent
{
  private anui a;
  
  public PublicAccountIntent(Context paramContext, Class<? extends Servlet> paramClass)
  {
    super(paramContext, paramClass);
  }
  
  public anui a()
  {
    return this.a;
  }
  
  public void a(anui paramanui)
  {
    this.a = paramanui;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.applets.PublicAccountIntent
 * JD-Core Version:    0.7.0.1
 */