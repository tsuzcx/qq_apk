package com.tencent.biz.pubaccount;

import android.os.Bundle;
import android.widget.Toast;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

class PublicAccountStQWebServletWrapper$CommonObserver<T extends MessageMicro<?>>
  implements BusinessObserver
{
  private PublicAccountStQWebServletWrapper.PublicAccountStQCallback<T> jdField_a_of_type_ComTencentBizPubaccountPublicAccountStQWebServletWrapper$PublicAccountStQCallback;
  private Class<T> jdField_a_of_type_JavaLangClass;
  
  public PublicAccountStQWebServletWrapper$CommonObserver(PublicAccountStQWebServletWrapper.PublicAccountStQCallback<T> paramPublicAccountStQCallback, Class<T> paramClass)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountStQWebServletWrapper$PublicAccountStQCallback = paramPublicAccountStQCallback;
    this.jdField_a_of_type_JavaLangClass = paramClass;
  }
  
  private T a(byte[] paramArrayOfByte, Class<T> paramClass)
  {
    try
    {
      paramClass = (MessageMicro)paramClass.newInstance();
      if (paramArrayOfByte == null) {
        return null;
      }
      paramClass.mergeFrom(paramArrayOfByte);
      return paramClass;
    }
    catch (Throwable paramArrayOfByte)
    {
      Toast.makeText(BaseApplicationImpl.getContext(), 2131695217, 0).show();
      paramClass = new StringBuilder();
      paramClass.append("decode pb err:");
      paramClass.append(paramArrayOfByte.getMessage());
      QLog.w("PublicAccountStQWebServlet", 4, paramClass.toString(), paramArrayOfByte);
    }
    return null;
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountStQWebServletWrapper$PublicAccountStQCallback;
    if (localObject == null) {
      return;
    }
    if (!paramBoolean) {
      ((PublicAccountStQWebServletWrapper.PublicAccountStQCallback)localObject).a(paramInt, paramBoolean, null, paramBundle);
    }
    localObject = paramBundle.getByteArray("data");
    if (a((byte[])localObject, this.jdField_a_of_type_JavaLangClass) == null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountStQWebServletWrapper$PublicAccountStQCallback.a(paramInt, false, null, paramBundle);
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountStQWebServletWrapper$PublicAccountStQCallback.a(paramInt, paramBoolean, a((byte[])localObject, this.jdField_a_of_type_JavaLangClass), paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.PublicAccountStQWebServletWrapper.CommonObserver
 * JD-Core Version:    0.7.0.1
 */