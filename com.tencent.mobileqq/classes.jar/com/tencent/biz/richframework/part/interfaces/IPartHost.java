package com.tencent.biz.richframework.part.interfaces;

import android.app.Activity;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.biz.richframework.part.BaseViewModel;

public abstract interface IPartHost
  extends ViewModelStoreOwner
{
  public abstract Activity getHostActivity();
  
  public abstract <T extends BaseViewModel> T getViewModel(IPartHost paramIPartHost, String paramString, Class<T> paramClass);
  
  public abstract Object getViewTagData();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.richframework.part.interfaces.IPartHost
 * JD-Core Version:    0.7.0.1
 */