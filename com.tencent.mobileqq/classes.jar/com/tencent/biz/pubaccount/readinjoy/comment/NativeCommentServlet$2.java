package com.tencent.biz.pubaccount.readinjoy.comment;

import android.os.Bundle;
import com.tencent.mobileqq.WebSsoBody.WebSsoResponseBody;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;
import org.json.JSONObject;

final class NativeCommentServlet$2
  implements BusinessObserver
{
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    int i = 0;
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        paramBundle = paramBundle.getByteArray("data");
        if (paramBundle == null) {
          break label256;
        }
        localObject = new WebSsoBody.WebSsoResponseBody();
        ((WebSsoBody.WebSsoResponseBody)localObject).mergeFrom(paramBundle);
        paramInt = ((WebSsoBody.WebSsoResponseBody)localObject).ret.get();
      }
      catch (Exception paramBundle)
      {
        try
        {
          int j;
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentArticleCommentModule$DeleteCommentObserver.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, this.b, 0);
          paramBundle = "";
          i = 1;
        }
        catch (Exception paramBundle)
        {
          Object localObject;
          i = 1;
          continue;
        }
        paramBundle = paramBundle;
        paramInt = -1;
        localObject = paramBundle.getLocalizedMessage();
        paramBundle.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.d("NativeCommentServlet", 2, "fetchCommentList error info:" + paramBundle.getLocalizedMessage());
        }
        paramBundle = (Bundle)localObject;
        continue;
      }
      try
      {
        paramBundle = ((WebSsoBody.WebSsoResponseBody)localObject).data.get();
        if (QLog.isColorLevel()) {
          QLog.d("NativeCommentServlet", 2, "deleteComment ret=" + paramBundle);
        }
        paramBundle = new JSONObject(paramBundle);
        if (paramInt == 0) {
          continue;
        }
        paramBundle = paramBundle.optString("msg");
        i = 0;
      }
      catch (Exception paramBundle)
      {
        continue;
        paramBundle = "";
        i = 0;
        continue;
      }
      if (i == 0) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentArticleCommentModule$DeleteCommentObserver.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_JavaLangString, this.b, paramInt, paramBundle);
      }
      return;
      j = paramBundle.optInt("ret");
      if (j == 0) {}
      label256:
      i = 0;
      paramInt = -1;
      paramBundle = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.NativeCommentServlet.2
 * JD-Core Version:    0.7.0.1
 */