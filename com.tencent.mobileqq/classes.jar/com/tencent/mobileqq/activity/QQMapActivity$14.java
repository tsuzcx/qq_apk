package com.tencent.mobileqq.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.proto.lbsshare.LBSShare.GetShopsByIdsResp;
import com.tencent.proto.lbsshare.LBSShare.LocationResp;
import com.tencent.proto.lbsshare.LBSShare.NearByShopsResp;
import com.tencent.qphone.base.util.QLog;

class QQMapActivity$14
  extends BroadcastReceiver
{
  QQMapActivity$14(QQMapActivity paramQQMapActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("activiy.receiver.onReceive:");
      ((StringBuilder)localObject).append(paramContext);
      QLog.d("Q.qqmap", 2, ((StringBuilder)localObject).toString());
    }
    if (paramContext.equals("com.tencent.mobileqq.onGetStreetViewUrl"))
    {
      this.a.mStreetViewUrl = paramIntent.getStringExtra("streetViewUrl");
      this.a.refreshStreetViewIcon();
      return;
    }
    if (paramContext.equals("com.tencent.mobileqq.onGetLbsShareSearch"))
    {
      localObject = paramIntent.getByteArrayExtra("data");
      paramContext = new LBSShare.LocationResp();
      if (localObject != null) {
        try
        {
          paramContext = (LBSShare.LocationResp)paramContext.mergeFrom((byte[])localObject);
        }
        catch (InvalidProtocolBufferMicroException paramContext)
        {
          if (QLog.isColorLevel()) {
            paramContext.printStackTrace();
          }
          paramContext = null;
        }
      }
      paramIntent = paramIntent.getExtras().getBundle("req");
      this.a.onGetLbsShareSearch(paramContext, paramIntent);
      return;
    }
    if (paramContext.equals("com.tencent.mobileqq.onGetLbsShareShop"))
    {
      paramContext = paramIntent.getByteArrayExtra("data");
      if (paramContext == null) {
        return;
      }
      localObject = new LBSShare.NearByShopsResp();
      try
      {
        paramContext = (LBSShare.NearByShopsResp)((LBSShare.NearByShopsResp)localObject).mergeFrom(paramContext);
        paramIntent = paramIntent.getExtras().getBundle("req");
        this.a.onGetLbsShareShop(paramContext, paramIntent);
        return;
      }
      catch (InvalidProtocolBufferMicroException paramContext)
      {
        if (QLog.isColorLevel()) {
          paramContext.printStackTrace();
        }
        this.a.onGetLbsShareShop(null, null);
        return;
      }
    }
    if (paramContext.equals("com.tencent.mobileqq.onGetShareShopDetail"))
    {
      paramContext = paramIntent.getByteArrayExtra("data");
      if (paramContext != null)
      {
        paramIntent = new LBSShare.GetShopsByIdsResp();
        try
        {
          paramContext = (LBSShare.GetShopsByIdsResp)paramIntent.mergeFrom(paramContext);
          this.a.onGetShareShopDetail(paramContext);
          return;
        }
        catch (InvalidProtocolBufferMicroException paramContext)
        {
          if (QLog.isColorLevel()) {
            paramContext.printStackTrace();
          }
          this.a.onGetShareShopDetail(null);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQMapActivity.14
 * JD-Core Version:    0.7.0.1
 */