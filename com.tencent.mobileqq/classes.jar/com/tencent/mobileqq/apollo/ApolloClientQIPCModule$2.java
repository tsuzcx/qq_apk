package com.tencent.mobileqq.apollo;

import android.content.Intent;
import com.tencent.mobileqq.apollo.api.uitls.impl.ApolloAvatarFileManager.OnGetFramePathListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import java.util.List;

class ApolloClientQIPCModule$2
  implements ApolloAvatarFileManager.OnGetFramePathListener
{
  ApolloClientQIPCModule$2(ApolloClientQIPCModule paramApolloClientQIPCModule, QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2) {}
  
  public void a(boolean paramBoolean, List<String> paramList, int paramInt)
  {
    paramInt = 0;
    Intent localIntent;
    if ((paramBoolean) && (paramList != null) && (paramList.size() > 0)) {
      localIntent = new Intent();
    }
    for (paramBoolean = ProfileCardUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)paramList.get(0), localIntent);; paramBoolean = false)
    {
      if (QLog.isColorLevel()) {
        QLog.i("cm_res", 1, "handleSetAvatar isDynamic: " + this.jdField_a_of_type_Int + " isSuccess:" + paramBoolean);
      }
      paramList = new EIPCResult();
      if (paramBoolean) {}
      for (;;)
      {
        paramList.code = paramInt;
        this.jdField_a_of_type_ComTencentMobileqqApolloApolloClientQIPCModule.callbackResult(this.b, paramList);
        return;
        paramInt = 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloClientQIPCModule.2
 * JD-Core Version:    0.7.0.1
 */