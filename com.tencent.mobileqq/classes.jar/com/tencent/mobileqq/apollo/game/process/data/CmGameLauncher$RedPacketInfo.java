package com.tencent.mobileqq.apollo.game.process.data;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class CmGameLauncher$RedPacketInfo
{
  public int a;
  public long a;
  public String a;
  public volatile boolean a;
  public volatile int b;
  public String b;
  public int c;
  public String c;
  public int d;
  public String d;
  public String e;
  public String f = "-1";
  public String g;
  
  public CmGameLauncher$RedPacketInfo()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_Boolean = false;
    this.jdField_d_of_type_JavaLangString = "0";
  }
  
  public String a()
  {
    Object localObject1 = new JSONObject();
    if (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
      try
      {
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(this.jdField_c_of_type_JavaLangString);
        ((StringBuilder)localObject2).append("?amount=");
        ((StringBuilder)localObject2).append(this.jdField_d_of_type_JavaLangString);
        ((StringBuilder)localObject2).append("&state=");
        ((StringBuilder)localObject2).append(this.f);
        ((StringBuilder)localObject2).append("&goalScore=");
        ((StringBuilder)localObject2).append(this.jdField_a_of_type_Int);
        ((StringBuilder)localObject2).append("&curScore=");
        ((StringBuilder)localObject2).append(this.jdField_d_of_type_Int);
        ((StringBuilder)localObject2).append("&nickName=");
        ((StringBuilder)localObject2).append(this.e);
        localObject2 = ((StringBuilder)localObject2).toString();
        ((JSONObject)localObject1).put("url", localObject2);
        ((JSONObject)localObject1).put("ret", this.f);
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("url:");
          localStringBuilder.append((String)localObject2);
          localStringBuilder.append(",state:");
          localStringBuilder.append(this.f);
          QLog.d("cmgame_process.CmGameLauncher", 2, localStringBuilder.toString());
        }
        localObject1 = ((JSONObject)localObject1).toString();
        return localObject1;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
    } else {
      QLog.e("cmgame_process.CmGameLauncher", 1, "[getResult] baseUrl is null");
    }
    return null;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("RedPacketInfo{");
    localStringBuffer.append("targetScore=");
    localStringBuffer.append(this.jdField_a_of_type_Int);
    localStringBuffer.append(", grabState=");
    localStringBuffer.append(this.jdField_b_of_type_Int);
    localStringBuffer.append(", res='");
    localStringBuffer.append(this.jdField_a_of_type_JavaLangString);
    localStringBuffer.append('\'');
    localStringBuffer.append(", needNotifyResult=");
    localStringBuffer.append(this.jdField_a_of_type_Boolean);
    localStringBuffer.append(", listId='");
    localStringBuffer.append(this.jdField_b_of_type_JavaLangString);
    localStringBuffer.append('\'');
    localStringBuffer.append(", url='");
    localStringBuffer.append(this.jdField_c_of_type_JavaLangString);
    localStringBuffer.append('\'');
    localStringBuffer.append(", gameId=");
    localStringBuffer.append(this.jdField_c_of_type_Int);
    localStringBuffer.append(", amount='");
    localStringBuffer.append(this.jdField_d_of_type_JavaLangString);
    localStringBuffer.append('\'');
    localStringBuffer.append(", nickname='");
    localStringBuffer.append(this.e);
    localStringBuffer.append('\'');
    localStringBuffer.append(", endScore=");
    localStringBuffer.append(this.jdField_d_of_type_Int);
    localStringBuffer.append(", state='");
    localStringBuffer.append(this.f);
    localStringBuffer.append('\'');
    localStringBuffer.append(", payParam='");
    localStringBuffer.append(this.g);
    localStringBuffer.append('\'');
    localStringBuffer.append(", uin=");
    localStringBuffer.append(this.jdField_a_of_type_Long);
    localStringBuffer.append('}');
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.process.data.CmGameLauncher.RedPacketInfo
 * JD-Core Version:    0.7.0.1
 */