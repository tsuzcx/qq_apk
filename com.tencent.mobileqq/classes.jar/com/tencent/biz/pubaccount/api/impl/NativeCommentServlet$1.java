package com.tencent.biz.pubaccount.api.impl;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.WebSsoBody.WebSsoResponseBody;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;
import org.json.JSONObject;

final class NativeCommentServlet$1
  implements BusinessObserver
{
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    int i1 = 0;
    int n = 0;
    int m = -1;
    String str = "";
    int j = i1;
    int k = m;
    Object localObject = str;
    if (paramBoolean)
    {
      paramInt = n;
      int i = m;
      try
      {
        paramBundle = paramBundle.getByteArray("data");
        j = i1;
        k = m;
        localObject = str;
        if (paramBundle != null)
        {
          paramInt = n;
          i = m;
          localObject = new WebSsoBody.WebSsoResponseBody();
          paramInt = n;
          i = m;
          ((WebSsoBody.WebSsoResponseBody)localObject).mergeFrom(paramBundle);
          paramInt = n;
          i = m;
          k = ((WebSsoBody.WebSsoResponseBody)localObject).ret.get();
          paramInt = n;
          i = k;
          localObject = ((WebSsoBody.WebSsoResponseBody)localObject).data.get();
          paramInt = n;
          i = k;
          if (QLog.isColorLevel())
          {
            paramInt = n;
            i = k;
            paramBundle = new StringBuilder();
            paramInt = n;
            i = k;
            paramBundle.append("fetch cmd=");
            paramInt = n;
            i = k;
            paramBundle.append(this.jdField_a_of_type_JavaLangString);
            paramInt = n;
            i = k;
            paramBundle.append(" str=");
            paramInt = n;
            i = k;
            paramBundle.append((String)localObject);
            paramInt = n;
            i = k;
            QLog.d("NativeCommentServlet", 2, paramBundle.toString());
          }
          paramBundle = null;
          paramInt = n;
          i = k;
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            paramInt = n;
            i = k;
            paramBundle = new JSONObject((String)localObject);
          }
          if (k != 0)
          {
            if (paramBundle == null) {
              break label424;
            }
            paramInt = n;
            i = k;
            localObject = paramBundle.optString("msg");
            j = i1;
          }
          else
          {
            j = 1;
            paramInt = 1;
            i = k;
            this.jdField_a_of_type_ComTencentBizPubaccountApiImplNativeCommentServlet$CommentObserver.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo, paramBundle, (String)localObject);
            localObject = str;
          }
        }
      }
      catch (Exception localException)
      {
        paramBundle = localException.getLocalizedMessage();
        localException.printStackTrace();
        j = paramInt;
        k = i;
        localObject = paramBundle;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("fetchCommentList error info:");
          ((StringBuilder)localObject).append(localException.getLocalizedMessage());
          QLog.d("NativeCommentServlet", 2, ((StringBuilder)localObject).toString());
          localObject = paramBundle;
          k = i;
          j = paramInt;
        }
      }
    }
    for (;;)
    {
      if (j == 0) {
        this.jdField_a_of_type_ComTencentBizPubaccountApiImplNativeCommentServlet$CommentObserver.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo, k, (String)localObject);
      }
      return;
      label424:
      j = i1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.api.impl.NativeCommentServlet.1
 * JD-Core Version:    0.7.0.1
 */