package com.tencent.mobileqq.apollo.store;

import com.tencent.mobileqq.apollo.res.api.IApolloResDownloader.OnApolloDownLoadListener;
import com.tencent.qphone.base.util.QLog;

class ApolloGuestsPresenter$2
  implements IApolloResDownloader.OnApolloDownLoadListener
{
  ApolloGuestsPresenter$2(ApolloGuestsPresenter paramApolloGuestsPresenter) {}
  
  public void a(boolean paramBoolean, String paramString, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    if (!paramBoolean)
    {
      QLog.e("[cmshow]ApolloGuestsPresenter", 1, "res download fail ");
      return;
    }
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("res download sucess roleId=");
      paramString.append(paramInt1);
      paramString.append("dressIds=");
      paramString.append(paramArrayOfInt);
      QLog.d("[cmshow]ApolloGuestsPresenter", 2, paramString.toString());
    }
    if (ApolloGuestsPresenter.a(this.a) != null) {
      ApolloGuestsPresenter.a(this.a).onDressChange();
    }
    this.a.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.ApolloGuestsPresenter.2
 * JD-Core Version:    0.7.0.1
 */