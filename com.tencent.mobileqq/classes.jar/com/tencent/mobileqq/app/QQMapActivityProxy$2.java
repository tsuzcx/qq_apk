package com.tencent.mobileqq.app;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;

class QQMapActivityProxy$2
  extends LBSObserver
{
  QQMapActivityProxy$2(QQMapActivityProxy paramQQMapActivityProxy) {}
  
  protected void a(boolean paramBoolean, byte[] paramArrayOfByte)
  {
    if ((paramBoolean) && (paramArrayOfByte != null))
    {
      paramArrayOfByte = new String(paramArrayOfByte);
      QQMapActivityProxy.d(this.a).sendBroadcast(new Intent().setAction("com.tencent.mobileqq.onGetStreetViewUrl").putExtra("streetViewUrl", paramArrayOfByte));
    }
    else
    {
      paramArrayOfByte = "";
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("mLbsObserver, onGetStreetViewUrl: isSuccess=");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(", hashCode=");
      localStringBuilder.append(hashCode());
      localStringBuilder.append(",url=");
      localStringBuilder.append(paramArrayOfByte);
      QLog.d("QQMapActivityProxy", 2, localStringBuilder.toString());
    }
  }
  
  protected void a(boolean paramBoolean, Object[] paramArrayOfObject)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("mLbsObserver, onGetLbsShareSearch: isSuccess=");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append(", isDataNull=");
      if (paramArrayOfObject == null) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      }
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append(", hashCode=");
      ((StringBuilder)localObject).append(hashCode());
      QLog.d("QQMapActivityProxy", 2, ((StringBuilder)localObject).toString());
    }
    if (paramArrayOfObject == null) {
      return;
    }
    Object localObject = (ToServiceMsg)paramArrayOfObject[0];
    paramArrayOfObject = (byte[])paramArrayOfObject[1];
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.mobileqq.onGetLbsShareSearch");
    localIntent.putExtra("data", paramArrayOfObject);
    localIntent.putExtra("req", ((ToServiceMsg)localObject).extraData.getBundle("req"));
    QQMapActivityProxy.d(this.a).sendBroadcast(localIntent);
  }
  
  protected void b(boolean paramBoolean, Object[] paramArrayOfObject)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("mLbsObserver, onGetLbsShareShop: isSuccess=");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append(", isDataNull=");
      if (paramArrayOfObject == null) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      }
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append(", hashCode=");
      ((StringBuilder)localObject).append(hashCode());
      QLog.d("QQMapActivityProxy", 2, ((StringBuilder)localObject).toString());
    }
    if (paramArrayOfObject == null) {
      return;
    }
    Object localObject = new Intent();
    ((Intent)localObject).setAction("com.tencent.mobileqq.onGetLbsShareShop");
    ((Intent)localObject).putExtra("data", (byte[])paramArrayOfObject[1]);
    ((Intent)localObject).putExtra("req", ((ToServiceMsg)paramArrayOfObject[0]).extraData.getBundle("req"));
    QQMapActivityProxy.d(this.a).sendBroadcast((Intent)localObject);
  }
  
  protected void c(boolean paramBoolean, Object[] paramArrayOfObject)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("mLbsObserver, onGetShareShopDetail: isSuccess=");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append(", isDataNull=");
      if (paramArrayOfObject == null) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      }
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append(", hashCode=");
      ((StringBuilder)localObject).append(hashCode());
      QLog.d("QQMapActivityProxy", 2, ((StringBuilder)localObject).toString());
    }
    if (paramArrayOfObject == null) {
      return;
    }
    Object localObject = new Intent();
    ((Intent)localObject).setAction("com.tencent.mobileqq.onGetShareShopDetail");
    ((Intent)localObject).putExtra("data", (byte[])paramArrayOfObject[1]);
    ((Intent)localObject).putExtra("req", ((ToServiceMsg)paramArrayOfObject[0]).extraData.getBundle("req"));
    QQMapActivityProxy.d(this.a).sendBroadcast((Intent)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.QQMapActivityProxy.2
 * JD-Core Version:    0.7.0.1
 */