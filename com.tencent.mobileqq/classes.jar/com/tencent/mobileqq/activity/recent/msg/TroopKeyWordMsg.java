package com.tencent.mobileqq.activity.recent.msg;

import android.content.Context;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.troop.data.MessageInfo;
import com.tencent.mobileqq.troop.data.MessageNavInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class TroopKeyWordMsg
  extends AbstructRecentUserMsg
{
  public TroopKeyWordMsg(Context paramContext)
  {
    this.jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131699386);
    this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
  }
  
  public Object a(int paramInt, MessageInfo paramMessageInfo, Object paramObject, MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface)
  {
    if ((paramObject instanceof TroopKeyWordMsg))
    {
      paramMessageRecord = (TroopKeyWordMsg)paramObject;
      paramObject = paramMessageRecord;
    }
    for (;;)
    {
      paramMessageRecord.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo.a(paramMessageInfo.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo);
      return paramObject;
      paramMessageRecord = new TroopKeyWordMsg(BaseApplication.getContext());
      if (!(paramObject instanceof TroopSpecialAttentionMsg))
      {
        paramQQAppInterface = paramMessageRecord;
        paramObject = paramMessageRecord;
        paramMessageRecord = paramQQAppInterface;
      }
    }
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    QLog.d("TroopKeyWordMsg", 2, "deSerialize");
    paramArrayOfByte = new String(paramArrayOfByte);
    try
    {
      paramArrayOfByte = new JSONObject(paramArrayOfByte);
      this.jdField_a_of_type_JavaLangString = paramArrayOfByte.getString("content");
      this.jdField_a_of_type_Int = paramArrayOfByte.getInt("time");
      this.jdField_b_of_type_Int = paramArrayOfByte.getInt("color");
      this.c = paramArrayOfByte.getString("messageNavInfo");
      if ((this.c != null) && (this.c.length() != 0)) {
        this.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo.a(this.c);
      }
      return;
    }
    catch (JSONException paramArrayOfByte)
    {
      QLog.e("TroopKeyWordMsg", 1, "deSerialize: ", paramArrayOfByte);
    }
  }
  
  public byte[] a()
  {
    return b();
  }
  
  public byte[] b()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("content", this.jdField_a_of_type_JavaLangString);
      localJSONObject.put("time", this.jdField_a_of_type_Int);
      localJSONObject.put("color", this.jdField_b_of_type_Int);
      this.c = this.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo.a();
      localJSONObject.put("messageNavInfo", this.c);
      return localJSONObject.toString().getBytes();
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QLog.e("TroopKeyWordMsg", 1, "deSerialize: ", localJSONException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.msg.TroopKeyWordMsg
 * JD-Core Version:    0.7.0.1
 */