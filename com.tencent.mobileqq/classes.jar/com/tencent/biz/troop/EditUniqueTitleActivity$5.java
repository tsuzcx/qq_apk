package com.tencent.biz.troop;

import android.os.Bundle;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

class EditUniqueTitleActivity$5
  implements BusinessObserver
{
  EditUniqueTitleActivity$5(EditUniqueTitleActivity paramEditUniqueTitleActivity) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setUniqueTitle, onReceive. type=");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(", isSuccess=");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("EditUniqueTitleActivity", 2, ((StringBuilder)localObject).toString());
    }
    if (!paramBoolean)
    {
      EditUniqueTitleActivity.a(this.a, -1);
      return;
    }
    paramBundle = paramBundle.getByteArray("data");
    Object localObject = new oidb_sso.OIDBSSOPkg();
    try
    {
      ((oidb_sso.OIDBSSOPkg)localObject).mergeFrom(paramBundle);
      paramInt = ((oidb_sso.OIDBSSOPkg)localObject).uint32_result.get();
      EditUniqueTitleActivity.a(this.a, paramInt);
      return;
    }
    catch (InvalidProtocolBufferMicroException paramBundle)
    {
      label110:
      break label110;
    }
    EditUniqueTitleActivity.a(this.a, -1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.troop.EditUniqueTitleActivity.5
 * JD-Core Version:    0.7.0.1
 */