package com.tencent.biz.pubaccount.readinjoy.comment;

import android.os.Bundle;
import com.tencent.mobileqq.WebSsoBody.WebSsoResponseBody;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;
import org.json.JSONException;
import org.json.JSONObject;

final class NativeCommentServlet$4
  implements BusinessObserver
{
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    m = 0;
    k = 0;
    j = -1;
    str = "";
    localObject = str;
    paramInt = j;
    i = k;
    if (paramBoolean)
    {
      paramInt = j;
      i = m;
    }
    for (;;)
    {
      try
      {
        paramBundle = paramBundle.getByteArray("data");
        localObject = str;
        paramInt = j;
        i = k;
        if (paramBundle != null)
        {
          paramInt = j;
          i = m;
          localObject = new WebSsoBody.WebSsoResponseBody();
          paramInt = j;
          i = m;
        }
      }
      catch (Exception paramBundle)
      {
        paramBundle.printStackTrace();
        localObject = str;
        continue;
        i = 1;
        k = 1;
        paramInt = j;
        this.a.a();
        localObject = str;
        paramInt = j;
        i = k;
        continue;
      }
      try
      {
        ((WebSsoBody.WebSsoResponseBody)localObject).mergeFrom(paramBundle);
        paramInt = j;
        i = m;
        j = ((WebSsoBody.WebSsoResponseBody)localObject).ret.get();
        paramInt = j;
        i = m;
        if (QLog.isColorLevel())
        {
          paramInt = j;
          i = m;
          QLog.d("NativeCommentServlet", 2, "commentReport ret=" + ((WebSsoBody.WebSsoResponseBody)localObject).data.get());
        }
        if (j != 0)
        {
          paramInt = j;
          i = m;
          try
          {
            localObject = new JSONObject(((WebSsoBody.WebSsoResponseBody)localObject).data.get()).optString("msg");
            i = k;
            paramInt = j;
          }
          catch (JSONException paramBundle)
          {
            paramInt = j;
            i = m;
            paramBundle.printStackTrace();
            localObject = str;
            paramInt = j;
            i = k;
            continue;
          }
          if (i == 0) {
            this.a.a(paramInt, (String)localObject);
          }
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramBundle)
      {
        paramInt = j;
        i = m;
        paramBundle.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.NativeCommentServlet.4
 * JD-Core Version:    0.7.0.1
 */