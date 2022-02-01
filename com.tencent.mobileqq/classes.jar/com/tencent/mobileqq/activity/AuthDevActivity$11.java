package com.tencent.mobileqq.activity;

import QQService.DeviceItemDes;
import QQService.SvcDevLoginInfo;
import android.os.Bundle;
import android.os.Message;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SecSvcObserver;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import java.util.Arrays;
import java.util.List;
import mqq.os.MqqHandler;

class AuthDevActivity$11
  extends SecSvcObserver
{
  AuthDevActivity$11(AuthDevActivity paramAuthDevActivity) {}
  
  public void a(int paramInt, Bundle paramBundle)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    if (paramBundle == null) {
      return;
    }
    paramInt = paramBundle.getInt("cmd", 1);
    int i = paramBundle.getInt("opt", 2);
    int j = paramBundle.getInt("ret", -1);
    paramBundle = (String)paramBundle.get("wording");
    FormSwitchItem localFormSwitchItem;
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      if (j == 0)
      {
        AuthDevActivity.access$000(this.a).setVisibility(0);
        AuthDevActivity.access$000(this.a).setOnCheckedChangeListener(null);
        localFormSwitchItem = AuthDevActivity.access$000(this.a);
        if (i == 1) {}
        for (;;)
        {
          localFormSwitchItem.setChecked(bool1);
          AuthDevActivity.access$000(this.a).setOnCheckedChangeListener(AuthDevActivity.access$100(this.a));
          AuthDevActivity.access$2200(this.a).setVisibility(0);
          AuthDevActivity.access$2200(this.a).setText(paramBundle);
          return;
          bool1 = false;
        }
      }
      AuthDevActivity.access$000(this.a).setVisibility(8);
      AuthDevActivity.access$2200(this.a).setVisibility(8);
      return;
    }
    if (j == 0)
    {
      AuthDevActivity.access$000(this.a).setOnCheckedChangeListener(null);
      localFormSwitchItem = AuthDevActivity.access$000(this.a);
      if (i == 1) {}
      for (bool1 = bool2;; bool1 = false)
      {
        localFormSwitchItem.setChecked(bool1);
        AuthDevActivity.access$000(this.a).setOnCheckedChangeListener(AuthDevActivity.access$100(this.a));
        AuthDevActivity.access$2200(this.a).setText(paramBundle);
        return;
      }
    }
    AuthDevActivity.access$000(this.a).setVisibility(8);
    AuthDevActivity.access$2200(this.a).setVisibility(8);
    QQToast.a(this.a, paramBundle, 0).b(this.a.getTitleBarHeight());
  }
  
  public void a(boolean paramBoolean, int paramInt, byte[] paramArrayOfByte, String paramString)
  {
    if ((paramBoolean) && (AuthDevActivity.access$800(this.a) != null) && (paramInt >= 0) && (paramInt < AuthDevActivity.access$800(this.a).size()))
    {
      Object localObject = (SvcDevLoginInfo)AuthDevActivity.access$800(this.a).get(paramInt);
      if (Arrays.equals(((SvcDevLoginInfo)localObject).stDeviceItemDes.vecItemDes, paramArrayOfByte))
      {
        ((SvcDevLoginInfo)localObject).strDeviceName = paramString;
        AuthDevActivity.access$1600(this.a, AuthDevActivity.access$800(this.a));
      }
      localObject = this.a.app.getHandler(LoginInfoActivity.class);
      if (localObject != null)
      {
        localObject = ((MqqHandler)localObject).obtainMessage(1);
        Bundle localBundle = new Bundle();
        localBundle.putString(AuthDevRenameActivity.f, paramString);
        localBundle.putByteArray(AuthDevRenameActivity.h, paramArrayOfByte);
        ((Message)localObject).setData(localBundle);
        ((Message)localObject).sendToTarget();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AuthDevActivity.11
 * JD-Core Version:    0.7.0.1
 */