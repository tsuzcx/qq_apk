package com.tencent.mobileqq.apollo.store;

import com.tencent.mobileqq.apollo.api.res.IApolloResDownloader.OnApolloDownLoadListener;
import com.tencent.qphone.base.util.QLog;

class ApolloGuestsPresenter$2
  implements IApolloResDownloader.OnApolloDownLoadListener
{
  ApolloGuestsPresenter$2(ApolloGuestsPresenter paramApolloGuestsPresenter) {}
  
  public void a(boolean paramBoolean, String paramString, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    if (paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloGuestsPresenter", 2, "res download sucess roleId=" + paramInt1 + "dressIds=" + paramArrayOfInt);
      }
      if (ApolloGuestsPresenter.a(this.a) != null) {
        ApolloGuestsPresenter.a(this.a).onDressChange();
      }
      this.a.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.ApolloGuestsPresenter.2
 * JD-Core Version:    0.7.0.1
 */