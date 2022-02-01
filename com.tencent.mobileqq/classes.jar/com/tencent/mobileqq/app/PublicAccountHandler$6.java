package com.tencent.mobileqq.app;

import com.tencent.mobileqq.soso.location.LbsManagerServiceOnLocationChangeListener;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.qphone.base.util.QLog;

class PublicAccountHandler$6
  extends LbsManagerServiceOnLocationChangeListener
{
  PublicAccountHandler$6(PublicAccountHandler paramPublicAccountHandler, String paramString, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super(paramString, paramBoolean);
  }
  
  public void onLocationFinish(int paramInt, SosoLbsInfo paramSosoLbsInfo)
  {
    Object localObject;
    boolean bool;
    int i;
    int j;
    int k;
    int m;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("errCode ：").append(paramInt).append(" info is null ---> ");
      if (paramSosoLbsInfo == null)
      {
        bool = true;
        QLog.d("PublicAccountHandler", 2, bool);
      }
    }
    else
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountHandler;
      i = this.jdField_a_of_type_Int;
      j = this.b;
      k = this.c;
      m = this.d;
      if (paramInt != 0) {
        break label105;
      }
    }
    for (;;)
    {
      PublicAccountHandler.a((PublicAccountHandler)localObject, i, j, k, m, paramSosoLbsInfo);
      return;
      bool = false;
      break;
      label105:
      paramSosoLbsInfo = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.PublicAccountHandler.6
 * JD-Core Version:    0.7.0.1
 */