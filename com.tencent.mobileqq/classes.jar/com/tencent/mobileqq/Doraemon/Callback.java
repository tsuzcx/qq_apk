package com.tencent.mobileqq.Doraemon;

import android.os.Bundle;

public abstract class Callback
{
  public void a(Bundle paramBundle)
  {
    paramBundle = paramBundle.getBundle("key_result");
    boolean bool;
    if (paramBundle != null) {
      bool = true;
    } else {
      bool = false;
    }
    a(bool, paramBundle);
  }
  
  protected abstract void a(boolean paramBoolean, Bundle paramBundle);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.Callback
 * JD-Core Version:    0.7.0.1
 */