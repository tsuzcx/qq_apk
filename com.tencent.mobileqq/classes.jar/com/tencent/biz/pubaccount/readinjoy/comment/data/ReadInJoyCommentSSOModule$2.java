package com.tencent.biz.pubaccount.readinjoy.comment.data;

import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentObserver;
import com.tencent.mobileqq.WebSsoBody.WebSsoResponseBody;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

class ReadInJoyCommentSSOModule$2
  implements BusinessObserver
{
  ReadInJoyCommentSSOModule$2(ReadInJoyCommentSSOModule paramReadInJoyCommentSSOModule, BaseCommentData paramBaseCommentData, int paramInt1, int paramInt2) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    int i = 1;
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        paramBundle = paramBundle.getByteArray("data");
        if (paramBundle == null) {
          break label228;
        }
        WebSsoBody.WebSsoResponseBody localWebSsoResponseBody = new WebSsoBody.WebSsoResponseBody();
        localWebSsoResponseBody.mergeFrom(paramBundle);
        paramInt = localWebSsoResponseBody.ret.get();
        paramBundle = localWebSsoResponseBody.data.get();
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyCommentSSOModule", 2, "commentLike ret=" + paramBundle);
        }
        if (paramInt != 0) {
          break label228;
        }
        paramInt = i;
        paramBundle.printStackTrace();
      }
      catch (Exception paramBundle)
      {
        try
        {
          if (ReadInJoyCommentSSOModule.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentSSOModule) != null)
          {
            ReadInJoyCommentSSOModule.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentSSOModule).a(true, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData, this.jdField_a_of_type_Int, this.b);
            paramInt = i;
          }
          i = paramInt;
          if ((i == 0) && (ReadInJoyCommentSSOModule.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentSSOModule) != null)) {
            ReadInJoyCommentSSOModule.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentSSOModule).a(false, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData, this.jdField_a_of_type_Int, this.b);
          }
          return;
        }
        catch (Exception paramBundle)
        {
          for (;;)
          {
            paramInt = 1;
          }
        }
        paramBundle = paramBundle;
        paramInt = 0;
      }
      i = paramInt;
      if (QLog.isColorLevel())
      {
        QLog.d("ReadInJoyCommentSSOModule", 2, "fetchCommentList error info:" + paramBundle.getLocalizedMessage());
        i = paramInt;
        continue;
        label228:
        paramInt = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.data.ReadInJoyCommentSSOModule.2
 * JD-Core Version:    0.7.0.1
 */