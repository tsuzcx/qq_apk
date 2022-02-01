package com.tencent.mobileqq.apollo.api.res.impl;

import com.tencent.mobileqq.apollo.api.res.IApolloResDownloader.OnApolloDownLoadListener;

class ApolloResManagerImpl$6$1
  implements IApolloResDownloader.OnApolloDownLoadListener
{
  ApolloResManagerImpl$6$1(ApolloResManagerImpl.6 param6) {}
  
  public void a(boolean paramBoolean, String paramString, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    ApolloResManagerImpl.ApolloRoleInfoListener localApolloRoleInfoListener;
    if (this.a.a != null)
    {
      localApolloRoleInfoListener = this.a.a;
      if (!paramBoolean) {
        break label69;
      }
      paramString = "/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/role/" + paramInt1;
      if (!paramBoolean) {
        break label74;
      }
      paramArrayOfInt = "success";
      label51:
      if (!paramBoolean) {
        break label81;
      }
    }
    label69:
    label74:
    label81:
    for (paramInt1 = 0;; paramInt1 = -5003)
    {
      localApolloRoleInfoListener.a(paramString, paramArrayOfInt, paramInt1);
      return;
      paramString = null;
      break;
      paramArrayOfInt = "download error";
      break label51;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.res.impl.ApolloResManagerImpl.6.1
 * JD-Core Version:    0.7.0.1
 */