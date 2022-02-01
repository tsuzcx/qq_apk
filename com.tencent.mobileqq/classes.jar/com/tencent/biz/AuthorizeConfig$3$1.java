package com.tencent.biz;

import android.text.TextUtils;
import com.tencent.mobileqq.mp.mobileqq_mp.WebviewWhiteListResponse;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;

class AuthorizeConfig$3$1
  implements Runnable
{
  AuthorizeConfig$3$1(AuthorizeConfig.3 param3, mobileqq_mp.WebviewWhiteListResponse paramWebviewWhiteListResponse) {}
  
  public void run()
  {
    if (this.a.version != null)
    {
      Object localObject2 = null;
      Object localObject1 = localObject2;
      if (this.a.gziped_data != null)
      {
        localObject1 = localObject2;
        if (this.a.gziped_data.get().size() != 0)
        {
          localObject2 = this.a.gziped_data.get().toByteArray();
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
            ((StringBuilder)localObject1).append(this.a.data.get());
            QLog.i("AuthorizeConfig", 2, ((StringBuilder)localObject1).toString());
            localObject1 = localObject2;
            break label230;
            localObject2 = this.a.data.get();
            localObject1 = localObject2;
            if (QLog.isColorLevel())
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("not use zip data to json: ");
              ((StringBuilder)localObject1).append(this.a.data.get());
              QLog.i("AuthorizeConfig", 2, ((StringBuilder)localObject1).toString());
              localObject1 = localObject2;
            }
          }
        }
        label230:
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          this.b.a.a((String)localObject1, this.a.version.get(), "lastVersion");
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
 * Qualified Name:     com.tencent.biz.AuthorizeConfig.3.1
 * JD-Core Version:    0.7.0.1
 */