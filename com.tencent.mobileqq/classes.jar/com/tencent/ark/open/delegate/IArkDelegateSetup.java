package com.tencent.ark.open.delegate;

import java.util.ArrayList;

public abstract interface IArkDelegateSetup
{
  public abstract ArrayList<String> getPredownloadApp();
  
  public abstract void setupArkEnvironment(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ark.open.delegate.IArkDelegateSetup
 * JD-Core Version:    0.7.0.1
 */