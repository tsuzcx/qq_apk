package com.tencent.kwstudio.office.base;

import android.content.Context;
import java.io.InputStream;
import java.util.concurrent.Executor;

public abstract interface IGlobal
{
  public abstract Context getApplicationContext();
  
  public abstract Executor getExecutor();
  
  public abstract String getFileDir();
  
  public abstract InputStream getResourceAsStream(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.kwstudio.office.base.IGlobal
 * JD-Core Version:    0.7.0.1
 */