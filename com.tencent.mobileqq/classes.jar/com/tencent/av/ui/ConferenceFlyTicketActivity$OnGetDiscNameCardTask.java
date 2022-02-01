package com.tencent.av.ui;

import android.text.TextUtils;
import com.tencent.av.utils.download.BaseDownloadAsyncTask;
import com.tencent.av.utils.download.DownloadParams;
import com.tencent.av.utils.download.DownloadResult;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.json.JSONException;
import org.json.JSONObject;

class ConferenceFlyTicketActivity$OnGetDiscNameCardTask
  extends BaseDownloadAsyncTask
{
  String jdField_a_of_type_JavaLangString;
  
  public ConferenceFlyTicketActivity$OnGetDiscNameCardTask(ConferenceFlyTicketActivity paramConferenceFlyTicketActivity, String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    SSLSocketFactory.getSocketFactory().setHostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
  }
  
  public void a(DownloadParams paramDownloadParams)
  {
    boolean bool = paramDownloadParams.a.jdField_a_of_type_Boolean;
    Object localObject4 = null;
    Object localObject2 = null;
    Object localObject6 = null;
    String str1 = null;
    Object localObject5 = "";
    if (bool)
    {
      try
      {
        paramDownloadParams = new String(paramDownloadParams.a.jdField_a_of_type_ArrayOfByte, "UTF-8");
      }
      catch (Exception paramDownloadParams)
      {
        if (QLog.isColorLevel())
        {
          localObject1 = this.jdField_a_of_type_ComTencentAvUiConferenceFlyTicketActivity.jdField_a_of_type_JavaLangString;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("OnGetDiscNameCardTask.onPostDownloadComplete e = ");
          localStringBuilder.append(paramDownloadParams.toString());
          QLog.d((String)localObject1, 2, localStringBuilder.toString());
        }
        paramDownloadParams = null;
      }
      if (paramDownloadParams != null)
      {
        localObject1 = localObject2;
        try
        {
          paramDownloadParams = new JSONObject(paramDownloadParams);
          localObject1 = localObject2;
          i = paramDownloadParams.getInt("retcode");
          localObject1 = localObject2;
          if (paramDownloadParams.has("result"))
          {
            localObject1 = localObject2;
            localObject4 = paramDownloadParams.getJSONObject("result");
            paramDownloadParams = str1;
            localObject1 = localObject2;
            if (((JSONObject)localObject4).has("result_code"))
            {
              localObject1 = localObject2;
              paramDownloadParams = ((JSONObject)localObject4).getString("result_code");
            }
            localObject1 = paramDownloadParams;
            if (((JSONObject)localObject4).has("disc_name_card"))
            {
              localObject1 = paramDownloadParams;
              localObject2 = ((JSONObject)localObject4).getString("disc_name_card");
              localObject1 = localObject2;
            }
            else
            {
              localObject1 = "";
            }
            try
            {
              if (((JSONObject)localObject4).has("name_card_sender_uin")) {
                localObject2 = ((JSONObject)localObject4).getString("name_card_sender_uin");
              } else {
                localObject2 = "";
              }
              try
              {
                if (((JSONObject)localObject4).has("name_card_sender_name")) {
                  str1 = ((JSONObject)localObject4).getString("name_card_sender_name");
                } else {
                  str1 = "";
                }
              }
              catch (JSONException localJSONException1)
              {
                break label326;
              }
              str2 = "";
            }
            catch (JSONException localJSONException2)
            {
              localObject2 = "";
            }
          }
          else
          {
            String str2;
            localObject2 = str2;
            localObject1 = localObject5;
            paramDownloadParams = (DownloadParams)localObject4;
          }
        }
        catch (JSONException localJSONException3)
        {
          localObject2 = "";
          localObject4 = localObject2;
          paramDownloadParams = (DownloadParams)localObject1;
          localObject1 = localObject4;
          label326:
          i = -2;
          if (QLog.isColorLevel())
          {
            localObject4 = this.jdField_a_of_type_ComTencentAvUiConferenceFlyTicketActivity.jdField_a_of_type_JavaLangString;
            localObject5 = new StringBuilder();
            ((StringBuilder)localObject5).append("OnGetDiscNameCardTask.onPostDownloadComplete e = ");
            ((StringBuilder)localObject5).append(localJSONException3.toString());
            QLog.d((String)localObject4, 2, ((StringBuilder)localObject5).toString());
          }
          localObject3 = "";
        }
      }
    }
    int i = -1;
    Object localObject1 = "";
    localObject2 = localObject1;
    Object localObject3 = localObject2;
    paramDownloadParams = localObject6;
    localObject4 = this.jdField_a_of_type_ComTencentAvUiConferenceFlyTicketActivity.jdField_a_of_type_JavaLangString;
    localObject5 = new StringBuilder();
    ((StringBuilder)localObject5).append("OnGetDiscNameCardTask.onPostDownloadComplete, result_code[");
    ((StringBuilder)localObject5).append(paramDownloadParams);
    ((StringBuilder)localObject5).append("], disc_name_card[");
    ((StringBuilder)localObject5).append((String)localObject1);
    ((StringBuilder)localObject5).append("], name_card_sender_uin[");
    ((StringBuilder)localObject5).append((String)localObject2);
    ((StringBuilder)localObject5).append("], name_card_sender_name[");
    ((StringBuilder)localObject5).append((String)localObject3);
    ((StringBuilder)localObject5).append("], retcode[");
    ((StringBuilder)localObject5).append(i);
    ((StringBuilder)localObject5).append("], mDiscID[");
    ((StringBuilder)localObject5).append(this.jdField_a_of_type_JavaLangString);
    ((StringBuilder)localObject5).append("]");
    QLog.w((String)localObject4, 1, ((StringBuilder)localObject5).toString());
    localObject4 = this.jdField_a_of_type_ComTencentAvUiConferenceFlyTicketActivity;
    ConferenceFlyTicketActivity.a((ConferenceFlyTicketActivity)localObject4, this.jdField_a_of_type_JavaLangString, ((ConferenceFlyTicketActivity)localObject4).app.getCurrentUin(), (String)localObject2, (String)localObject3);
    if ((i == 0) && (TextUtils.equals(paramDownloadParams, "0")) && (!TextUtils.isEmpty((CharSequence)localObject1)) && (!((String)localObject1).equals("null")))
    {
      paramDownloadParams = this.jdField_a_of_type_ComTencentAvUiConferenceFlyTicketActivity;
      paramDownloadParams.a((String)localObject1, this.jdField_a_of_type_JavaLangString, paramDownloadParams.app.getCurrentUin(), (String)localObject2, (String)localObject3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.ConferenceFlyTicketActivity.OnGetDiscNameCardTask
 * JD-Core Version:    0.7.0.1
 */