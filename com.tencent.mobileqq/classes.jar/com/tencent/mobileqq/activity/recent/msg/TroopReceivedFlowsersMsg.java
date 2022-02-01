package com.tencent.mobileqq.activity.recent.msg;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForDeliverGiftTips;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.nearby.api.INearbyFlowerUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.data.MessageInfo;
import com.tencent.mobileqq.troop.data.MessageNavInfo;
import com.tencent.qphone.base.util.BaseApplication;
import org.json.JSONException;
import org.json.JSONObject;

public class TroopReceivedFlowsersMsg
  extends AbstructRecentUserMsg
{
  public boolean a;
  
  public TroopReceivedFlowsersMsg(Context paramContext)
  {
    this(paramContext, false);
  }
  
  public TroopReceivedFlowsersMsg(Context paramContext, boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131697687);
    this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public Object a(int paramInt, MessageInfo paramMessageInfo, Object paramObject, MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface)
  {
    if (paramMessageRecord == null) {
      return null;
    }
    boolean bool = ((INearbyFlowerUtil)QRoute.api(INearbyFlowerUtil.class)).isNearbyFlowerMsg(paramMessageRecord);
    if ((paramMessageRecord.msgtype != -2035) && (paramMessageRecord.msgtype != -2038) && (!bool)) {
      return null;
    }
    if (bool)
    {
      if ((paramObject instanceof TroopReceivedFlowsersMsg))
      {
        paramObject = (TroopReceivedFlowsersMsg)paramObject;
        paramObject.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo.a(paramMessageInfo.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo);
        return paramObject;
      }
      paramObject = new TroopReceivedFlowsersMsg(BaseApplication.getContext());
      paramObject.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo = new MessageNavInfo(paramMessageInfo.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo);
      return paramObject;
    }
    if ((paramMessageRecord instanceof MessageForDeliverGiftTips))
    {
      paramQQAppInterface = (MessageForDeliverGiftTips)paramMessageRecord;
      paramInt = 1;
      int i = 1;
      if ((paramObject instanceof TroopReceivedFlowsersMsg))
      {
        paramMessageRecord = (TroopReceivedFlowsersMsg)paramObject;
        paramInt = i;
        if (paramMessageRecord.jdField_a_of_type_Boolean)
        {
          paramInt = i;
          if (!paramQQAppInterface.isToAll()) {
            paramInt = 0;
          }
        }
        paramObject = paramMessageRecord;
        i = paramInt;
        if (!paramMessageRecord.jdField_a_of_type_Boolean)
        {
          paramMessageRecord.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo.a(paramMessageInfo.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo);
          paramObject = paramMessageRecord;
          i = paramInt;
        }
      }
      else
      {
        paramObject = new TroopReceivedFlowsersMsg(BaseApplication.getContext(), paramQQAppInterface.isToAll());
        paramObject.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo = new MessageNavInfo(paramMessageInfo.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo);
        i = paramInt;
      }
      if ((i != 0) && (!TextUtils.isEmpty(paramQQAppInterface.remindBrief)))
      {
        paramMessageInfo = paramQQAppInterface.remindBrief.split("#");
        paramMessageRecord = new StringBuffer("[");
        paramMessageRecord.append(paramMessageInfo[0]);
        paramMessageRecord.append("]");
        paramObject.jdField_a_of_type_JavaLangString = paramMessageRecord.toString();
      }
      return paramObject;
    }
    ReportController.b(paramQQAppInterface, "P_CliOper", "BizTechReport", "", "Troop_gift", "MsgBizType.TYPE_TROOP_RECEIVED_FLOWSER_MSG, MessageRecord cast to GiftTips", 0, -1, paramMessageRecord.getClass().getName(), "", "", "");
    return null;
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    paramArrayOfByte = new String(paramArrayOfByte);
    try
    {
      paramArrayOfByte = new JSONObject(paramArrayOfByte);
      this.jdField_a_of_type_Long = paramArrayOfByte.optLong("uniseq");
      this.jdField_b_of_type_Long = paramArrayOfByte.optLong("shmsgseq");
      this.jdField_a_of_type_JavaLangString = paramArrayOfByte.optString("content");
      this.jdField_b_of_type_Int = paramArrayOfByte.optInt("color");
      this.jdField_a_of_type_Boolean = paramArrayOfByte.optBoolean("isToAll");
      if (this.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo == null) {
        this.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo = new MessageNavInfo();
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo.a(paramArrayOfByte.getString("messageNavInfo"));
      return;
    }
    catch (JSONException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
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
      localJSONObject.put("uniseq", this.jdField_a_of_type_Long);
      localJSONObject.put("shmsgseq", this.jdField_b_of_type_Long);
      localJSONObject.put("content", this.jdField_a_of_type_JavaLangString);
      localJSONObject.put("color", this.jdField_b_of_type_Int);
      localJSONObject.put("isToAll", this.jdField_a_of_type_Boolean);
      if (this.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo != null) {
        localJSONObject.put("messageNavInfo", this.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo.a());
      }
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return localJSONObject.toString().getBytes();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.msg.TroopReceivedFlowsersMsg
 * JD-Core Version:    0.7.0.1
 */