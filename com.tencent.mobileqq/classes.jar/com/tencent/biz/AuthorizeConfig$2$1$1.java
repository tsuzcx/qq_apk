package com.tencent.biz;

import android.text.TextUtils;
import com.tencent.mobileqq.mp.mobileqq_mp.WebviewWhiteListResponse;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;

class AuthorizeConfig$2$1$1
  implements Runnable
{
  AuthorizeConfig$2$1$1(AuthorizeConfig.2.1 param1, mobileqq_mp.WebviewWhiteListResponse paramWebviewWhiteListResponse) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$WebviewWhiteListResponse.version != null)
    {
      Object localObject2 = null;
      Object localObject1 = localObject2;
      if (this.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$WebviewWhiteListResponse.gziped_data != null)
      {
        localObject1 = localObject2;
        if (this.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$WebviewWhiteListResponse.gziped_data.get().size() != 0)
        {
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$WebviewWhiteListResponse.gziped_data.get().toByteArray();
          localObject1 = localObject2;
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("now read compress data, size: ");
            ((StringBuilder)localObject1).append(localObject2.length);
            QLog.i("AuthorizeConfig", 2, ((StringBuilder)localObject1).toString());
            localObject1 = localObject2;
          }
        }
      }
      if (localObject1 != null) {}
      try
      {
        localObject2 = AuthorizeConfig.a((byte[])localObject1);
        localObject1 = localObject2;
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          localObject1 = localObject2;
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("use zip data to json: ");
            ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$WebviewWhiteListResponse.data.get());
            QLog.i("AuthorizeConfig", 2, ((StringBuilder)localObject1).toString());
            localObject1 = localObject2;
            break label230;
            localObject2 = this.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$WebviewWhiteListResponse.data.get();
            localObject1 = localObject2;
            if (QLog.isColorLevel())
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("not use zip data to json: ");
              ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$WebviewWhiteListResponse.data.get());
              QLog.i("AuthorizeConfig", 2, ((StringBuilder)localObject1).toString());
              localObject1 = localObject2;
            }
          }
        }
        label230:
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          this.jdField_a_of_type_ComTencentBizAuthorizeConfig$2$1.a.this$0.a((String)localObject1, this.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$WebviewWhiteListResponse.version.get(), "lastVersion");
          return;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        QLog.e("AuthorizeConfig", 2, "", localException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.AuthorizeConfig.2.1.1
 * JD-Core Version:    0.7.0.1
 */