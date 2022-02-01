package com.tencent.mobileqq.ark.browser;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.open.appcommon.OpensdkBusinessObserver;
import com.tencent.protofile.getappinfo.GetAppInfoProto.AndroidInfo;
import com.tencent.protofile.getappinfo.GetAppInfoProto.GetAppinfoResponse;
import com.tencent.qphone.base.util.QLog;

class ArkWebModule$1
  implements OpensdkBusinessObserver
{
  ArkWebModule$1(ArkWebModule paramArkWebModule, Activity paramActivity) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    String str = this.jdField_a_of_type_AndroidAppActivity.getString(2131690158);
    Object localObject1 = str;
    if (paramBoolean)
    {
      Object localObject2 = str;
      try
      {
        paramBundle = paramBundle.getByteArray("data");
        localObject1 = str;
        if (paramBundle != null)
        {
          localObject2 = str;
          GetAppInfoProto.GetAppinfoResponse localGetAppinfoResponse = new GetAppInfoProto.GetAppinfoResponse();
          localObject2 = str;
          localGetAppinfoResponse.mergeFrom(paramBundle);
          localObject2 = str;
          localObject1 = str;
          if (localGetAppinfoResponse.has())
          {
            localObject2 = str;
            localObject1 = str;
            if (localGetAppinfoResponse.ret.get() == 0)
            {
              localObject2 = str;
              localObject1 = str;
              if (localGetAppinfoResponse.androidInfo != null)
              {
                localObject2 = str;
                paramBundle = localGetAppinfoResponse.androidInfo;
                localObject2 = str;
                if (paramBundle.messagetail == null)
                {
                  localObject1 = "";
                }
                else
                {
                  localObject2 = str;
                  localObject1 = paramBundle.messagetail.get();
                }
                localObject2 = localObject1;
                ((String)localObject1).trim();
              }
            }
          }
        }
      }
      catch (Exception paramBundle)
      {
        localObject1 = localObject2;
        if (QLog.isColorLevel())
        {
          QLog.d("ArkWebModule", 2, paramBundle.getMessage());
          localObject1 = localObject2;
        }
      }
    }
    paramBundle = (Bundle)localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      paramBundle = this.jdField_a_of_type_AndroidAppActivity.getString(2131690158);
    }
    localObject1 = this.jdField_a_of_type_AndroidAppActivity.getString(2131690159);
    this.jdField_a_of_type_ComTencentMobileqqArkBrowserArkWebModule.a(String.format((String)localObject1, new Object[] { paramBundle }));
    ArkWebModule.a(this.jdField_a_of_type_ComTencentMobileqqArkBrowserArkWebModule).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.browser.ArkWebModule.1
 * JD-Core Version:    0.7.0.1
 */