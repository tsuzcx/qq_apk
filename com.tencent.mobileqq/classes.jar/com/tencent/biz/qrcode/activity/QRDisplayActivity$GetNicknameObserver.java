package com.tencent.biz.qrcode.activity;

import android.os.Bundle;
import java.util.List;
import mqq.observer.BusinessObserver;

public class QRDisplayActivity$GetNicknameObserver
  implements BusinessObserver
{
  public QRDisplayActivity$GetNicknameObserver(QRDisplayActivity paramQRDisplayActivity) {}
  
  protected void a(boolean paramBoolean, List<String> paramList1, List<String> paramList2) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    if (paramBoolean)
    {
      a(paramBoolean, paramBundle.getStringArrayList("nickname_list"), paramBundle.getStringArrayList("uin_list"));
      return;
    }
    this.b.i();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.QRDisplayActivity.GetNicknameObserver
 * JD-Core Version:    0.7.0.1
 */