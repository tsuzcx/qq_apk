package com.tencent.biz.pubaccount.api.impl;

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
    int m = 0;
    int k = 0;
    int j = -1;
    String str = "";
    paramInt = j;
    Object localObject = str;
    if (paramBoolean)
    {
      int i = j;
      try
      {
        paramBundle = paramBundle.getByteArray("data");
        paramInt = j;
        localObject = str;
        if (paramBundle == null) {
          break label333;
        }
        i = j;
        localObject = new WebSsoBody.WebSsoResponseBody();
        i = j;
        ((WebSsoBody.WebSsoResponseBody)localObject).mergeFrom(paramBundle);
        i = j;
        paramInt = ((WebSsoBody.WebSsoResponseBody)localObject).ret.get();
        i = paramInt;
        paramBundle = ((WebSsoBody.WebSsoResponseBody)localObject).data.get();
        i = paramInt;
        if (QLog.isColorLevel())
        {
          i = paramInt;
          localObject = new StringBuilder();
          i = paramInt;
          ((StringBuilder)localObject).append("commentLike ret=");
          i = paramInt;
          ((StringBuilder)localObject).append(paramBundle);
          i = paramInt;
          QLog.d("NativeCommentServlet", 2, ((StringBuilder)localObject).toString());
        }
        i = paramInt;
        paramBundle = new JSONObject(paramBundle);
        if (paramInt != 0)
        {
          i = paramInt;
          localObject = paramBundle.optString("msg");
          break label333;
        }
        try
        {
          if (this.a == 1) {
            this.b.a(this.c, this.d, paramBundle);
          } else {
            this.b.a(this.c, this.e, paramBundle);
          }
          paramBundle = "";
          j = 1;
          k = paramInt;
        }
        catch (Exception localException1)
        {
          i = 1;
        }
        str = localException2.getLocalizedMessage();
      }
      catch (Exception localException2)
      {
        paramInt = i;
        i = k;
      }
      localException2.printStackTrace();
      paramBundle = str;
      j = i;
      k = paramInt;
      if (!QLog.isColorLevel()) {
        break label343;
      }
      paramBundle = new StringBuilder();
      paramBundle.append("fetchCommentList error info:");
      paramBundle.append(localException2.getLocalizedMessage());
      QLog.d("NativeCommentServlet", 2, paramBundle.toString());
      paramBundle = str;
      j = i;
      k = paramInt;
      break label343;
    }
    label333:
    paramBundle = localException2;
    k = paramInt;
    j = m;
    label343:
    if (j == 0) {
      this.b.a(this.c, this.d, k, paramBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.api.impl.NativeCommentServlet.2
 * JD-Core Version:    0.7.0.1
 */