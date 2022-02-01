package com.tencent.biz.pubaccount.readinjoy.comment;

import android.os.Bundle;
import com.tencent.mobileqq.WebSsoBody.WebSsoResponseBody;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;
import org.json.JSONObject;

final class NativeCommentServlet$3
  implements BusinessObserver
{
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    int m = 0;
    int k = 0;
    j = -1;
    String str = "";
    Object localObject = str;
    i = j;
    paramInt = k;
    if (paramBoolean) {}
    for (paramInt = j;; paramInt = j)
    {
      try
      {
        paramBundle = paramBundle.getByteArray("data");
        localObject = str;
        i = j;
        paramInt = k;
        if (paramBundle != null)
        {
          paramInt = j;
          localObject = new WebSsoBody.WebSsoResponseBody();
          paramInt = j;
          ((WebSsoBody.WebSsoResponseBody)localObject).mergeFrom(paramBundle);
          paramInt = j;
          i = ((WebSsoBody.WebSsoResponseBody)localObject).ret.get();
          paramInt = i;
          paramBundle = ((WebSsoBody.WebSsoResponseBody)localObject).data.get();
          paramInt = i;
          if (QLog.isColorLevel())
          {
            paramInt = i;
            QLog.d("NativeCommentServlet", 2, "commentLike ret=" + paramBundle);
          }
          paramInt = i;
          paramBundle = new JSONObject(paramBundle);
          if (i == 0) {
            break label194;
          }
          paramInt = i;
          localObject = paramBundle.optString("msg");
          paramInt = k;
        }
      }
      catch (Exception paramBundle)
      {
        try
        {
          label194:
          while (this.jdField_a_of_type_Int == 1)
          {
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentNativeCommentServlet$CommentLikeObserver.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_JavaLangString, paramBundle);
            paramInt = 1;
            localObject = str;
          }
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentNativeCommentServlet$CommentLikeObserver.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.b, paramBundle);
          paramInt = 1;
          localObject = str;
        }
        catch (Exception paramBundle)
        {
          for (;;)
          {
            j = 1;
            paramInt = i;
          }
        }
        paramBundle = paramBundle;
        j = m;
      }
      if (paramInt == 0) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentNativeCommentServlet$CommentLikeObserver.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_JavaLangString, i, (String)localObject);
      }
      return;
      localObject = paramBundle.getLocalizedMessage();
      paramBundle.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.d("NativeCommentServlet", 2, "fetchCommentList error info:" + paramBundle.getLocalizedMessage());
      }
      i = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.NativeCommentServlet.3
 * JD-Core Version:    0.7.0.1
 */