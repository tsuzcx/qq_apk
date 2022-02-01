package com.tencent.mobileqq.activity.aio.stickerrecommended.mvvm;

import android.text.Editable;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.stickerrecommended.mvvm.data.LayoutStatusLiveData;

public abstract interface IStickerRecViewModel
{
  public abstract void a(AppInterface paramAppInterface);
  
  public abstract void a(BaseSessionInfo paramBaseSessionInfo);
  
  public abstract void a(LayoutStatusLiveData paramLayoutStatusLiveData);
  
  public abstract void a(boolean paramBoolean);
  
  public abstract boolean a();
  
  public abstract boolean a(Editable paramEditable, String paramString);
  
  public abstract void b(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerrecommended.mvvm.IStickerRecViewModel
 * JD-Core Version:    0.7.0.1
 */