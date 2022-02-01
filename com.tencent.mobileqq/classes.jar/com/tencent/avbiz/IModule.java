package com.tencent.avbiz;

import java.util.HashMap;
import java.util.HashSet;

public abstract interface IModule
{
  public abstract void abandonAVFocus();
  
  public abstract String checkAVFocus();
  
  public abstract HashMap<Long, String> getFocusBusiness();
  
  public abstract HashSet<String> getInQueueBusiness();
  
  public abstract String requestAVFocus();
  
  public abstract void setListener(IModule.FocusChangeListener paramFocusChangeListener);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avbiz.IModule
 * JD-Core Version:    0.7.0.1
 */