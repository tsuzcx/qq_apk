package com.tencent.mobileqq.activity;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.ims.QQProtectRisks.QQProtectRisksResponse;
import com.tencent.ims.QQProtectRisks.RiskInfo;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;

class RiskInfoActivity$1
  extends ProtoUtils.TroopProtocolObserver
{
  RiskInfoActivity$1(RiskInfoActivity paramRiskInfoActivity) {}
  
  public void onResult(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if ((paramInt == 0) && (paramArrayOfByte != null))
    {
      bool1 = true;
    }
    else
    {
      if (QLog.isColorLevel())
      {
        paramBundle = new StringBuilder();
        paramBundle.append("request risks info,onResult error=");
        paramBundle.append(paramInt);
        paramBundle.append(" data=");
        paramBundle.append(paramArrayOfByte);
        QLog.i("RiskInfoDetails", 2, paramBundle.toString());
      }
      bool1 = false;
    }
    paramBundle = new HashMap();
    bool2 = bool1;
    if (bool1) {}
    try
    {
      localQQProtectRisksResponse = new QQProtectRisks.QQProtectRisksResponse();
      localQQProtectRisksResponse.mergeFrom(paramArrayOfByte);
      if (!localQQProtectRisksResponse.uint32_sec_cmd.has()) {
        break label535;
      }
      paramInt = localQQProtectRisksResponse.uint32_sec_cmd.get();
    }
    catch (Throwable paramArrayOfByte)
    {
      QQProtectRisks.QQProtectRisksResponse localQQProtectRisksResponse;
      paramArrayOfByte.printStackTrace();
      bool2 = bool1;
      break label520;
      QLog.d("RiskInfoDetails", 1, "error protobuf content");
      bool2 = false;
      RiskInfoActivity.a(this.a, paramBundle, bool2);
      return;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      for (;;)
      {
        continue;
        paramInt = 0;
      }
    }
    bool2 = bool1;
    if (paramInt == 1)
    {
      bool2 = bool1;
      if (localQQProtectRisksResponse.risk_info_list.has())
      {
        bool2 = bool1;
        if (!localQQProtectRisksResponse.risk_info_list.isEmpty())
        {
          paramInt = 0;
          for (;;)
          {
            bool2 = bool1;
            if (paramInt >= localQQProtectRisksResponse.risk_info_list.size()) {
              break;
            }
            new QQProtectRisks.RiskInfo();
            paramArrayOfByte = (QQProtectRisks.RiskInfo)localQQProtectRisksResponse.risk_info_list.get(paramInt);
            if ((!paramArrayOfByte.uint32_item_type.has()) || (paramArrayOfByte.uint32_item_type.get() != 1))
            {
              RiskInfoItem localRiskInfoItem = new RiskInfoItem();
              localRiskInfoItem.jdField_a_of_type_JavaLangString = paramArrayOfByte.str_left_text.get();
              localRiskInfoItem.d = paramArrayOfByte.str_jump_target.get();
              if ((!TextUtils.isEmpty(localRiskInfoItem.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(localRiskInfoItem.d)))
              {
                localRiskInfoItem.jdField_b_of_type_JavaLangString = paramArrayOfByte.str_right_text.get();
                localRiskInfoItem.c = paramArrayOfByte.str_desc_text.get();
                localRiskInfoItem.jdField_a_of_type_Int = paramArrayOfByte.uint32_click_report_id.get();
                if (paramArrayOfByte.uint32_item_id.has()) {
                  localRiskInfoItem.jdField_b_of_type_Int = paramArrayOfByte.uint32_item_id.get();
                }
                if (paramArrayOfByte.str_right_text_open.has()) {
                  localRiskInfoItem.e = paramArrayOfByte.str_right_text_open.get();
                }
                paramArrayOfByte = String.format("%d", new Object[] { Integer.valueOf(localRiskInfoItem.jdField_b_of_type_Int) });
                if (localRiskInfoItem.jdField_b_of_type_Int == 0) {
                  paramArrayOfByte = localRiskInfoItem.d;
                }
                paramBundle.put(paramArrayOfByte, localRiskInfoItem);
                QLog.d("RiskInfoDetails", 1, String.format("%s, %s, %s, %s, %d, %d, %s", new Object[] { localRiskInfoItem.jdField_a_of_type_JavaLangString, localRiskInfoItem.jdField_b_of_type_JavaLangString, localRiskInfoItem.c, localRiskInfoItem.d, Integer.valueOf(localRiskInfoItem.jdField_a_of_type_Int), Integer.valueOf(localRiskInfoItem.jdField_b_of_type_Int), localRiskInfoItem.e }));
              }
            }
            paramInt += 1;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.RiskInfoActivity.1
 * JD-Core Version:    0.7.0.1
 */