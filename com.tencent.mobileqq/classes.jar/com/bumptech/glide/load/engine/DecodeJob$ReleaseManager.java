package com.bumptech.glide.load.engine;

class DecodeJob$ReleaseManager
{
  private boolean a;
  private boolean b;
  private boolean c;
  
  private boolean b(boolean paramBoolean)
  {
    return ((this.c) || (paramBoolean) || (this.b)) && (this.a);
  }
  
  boolean a()
  {
    try
    {
      this.b = true;
      boolean bool = b(false);
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  boolean a(boolean paramBoolean)
  {
    try
    {
      this.a = true;
      paramBoolean = b(paramBoolean);
      return paramBoolean;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  boolean b()
  {
    try
    {
      this.c = true;
      boolean bool = b(false);
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  void c()
  {
    try
    {
      this.b = false;
      this.a = false;
      this.c = false;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.engine.DecodeJob.ReleaseManager
 * JD-Core Version:    0.7.0.1
 */