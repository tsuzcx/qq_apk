package com.tencent.mobileqq.activity.contact.addcontact.publicaccount;

import com.tencent.mobileqq.soso.location.SosoInterfaceOnLocationListener;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.qphone.base.util.QLog;

class PublicView$2
  extends SosoInterfaceOnLocationListener
{
  PublicView$2(PublicView paramPublicView, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong, boolean paramBoolean3, boolean paramBoolean4, String paramString)
  {
    super(paramInt, paramBoolean1, paramBoolean2, paramLong, paramBoolean3, paramBoolean4, paramString);
  }
  
  public void onLocationFinish(int paramInt, SosoLbsInfo paramSosoLbsInfo)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onLocationFinish() errCode=");
      localStringBuilder.append(paramInt);
      QLog.d("PublicView", 2, localStringBuilder.toString());
    }
    PublicView.a(this.a, true);
    PublicView.a(this.a, paramSosoLbsInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.publicaccount.PublicView.2
 * JD-Core Version:    0.7.0.1
 */