package com.tencent.biz.pubaccount.api.impl;

import android.os.Bundle;
import com.tencent.mobileqq.WebSsoBody.WebSsoResponseBody;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;
import org.json.JSONException;
import org.json.JSONObject;

final class NativeCommentServlet$3
  implements BusinessObserver
{
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    int m = 0;
    int k = 0;
    int j = -1;
    String str2 = "";
    paramInt = j;
    String str1 = str2;
    int i = m;
    Object localObject;
    if (paramBoolean)
    {
      paramInt = j;
      i = k;
      try
      {
        byte[] arrayOfByte = paramBundle.getByteArray("data");
        paramInt = j;
        str1 = str2;
        i = m;
        if (arrayOfByte != null)
        {
          paramInt = j;
          i = k;
          paramBundle = new WebSsoBody.WebSsoResponseBody();
          paramInt = j;
          i = k;
          try
          {
            paramBundle.mergeFrom(arrayOfByte);
          }
          catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
          {
            paramInt = j;
            i = k;
            localInvalidProtocolBufferMicroException.printStackTrace();
          }
          paramInt = j;
          i = k;
          j = paramBundle.ret.get();
          paramInt = j;
          i = k;
          if (QLog.isColorLevel())
          {
            paramInt = j;
            i = k;
            localObject = new StringBuilder();
            paramInt = j;
            i = k;
            ((StringBuilder)localObject).append("commentReport ret=");
            paramInt = j;
            i = k;
            ((StringBuilder)localObject).append(paramBundle.data.get());
            paramInt = j;
            i = k;
            QLog.d("NativeCommentServlet", 2, ((StringBuilder)localObject).toString());
          }
          if (j != 0)
          {
            paramInt = j;
            i = k;
            try
            {
              localObject = new JSONObject(paramBundle.data.get()).optString("msg");
              paramInt = j;
              i = m;
            }
            catch (JSONException paramBundle)
            {
              paramInt = j;
              i = k;
              paramBundle.printStackTrace();
              paramInt = j;
              localObject = str2;
              i = m;
            }
          }
          else
          {
            k = 1;
            i = 1;
            paramInt = j;
            this.a.a();
            paramInt = j;
            localObject = str2;
            i = k;
          }
        }
      }
      catch (Exception paramBundle)
      {
        paramBundle.printStackTrace();
        localObject = str2;
      }
    }
    if (i == 0) {
      this.a.a(paramInt, (String)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.api.impl.NativeCommentServlet.3
 * JD-Core Version:    0.7.0.1
 */