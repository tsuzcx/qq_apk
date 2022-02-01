package com.tencent.falco.base.libapi.web;

import com.tencent.falco.base.libapi.ServiceBaseInterface;

public abstract interface WebInterface
  extends ServiceBaseInterface
{
  public abstract void init(WebInterface.WebComponentAdapter paramWebComponentAdapter);
  
  public abstract void rePlantCookie();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.falco.base.libapi.web.WebInterface
 * JD-Core Version:    0.7.0.1
 */