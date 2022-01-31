package com.tencent.mobileqq.activity.recent.data;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.TroopRedpoint.TroopRedTouchManager;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.recent.TimeManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x791.oidb_0x791.RedDotInfo;

public class RecentItemTencentDocsAssistantData
  extends RecentUserBaseData
{
  public RecentItemTencentDocsAssistantData(RecentUser paramRecentUser)
  {
    super(paramRecentUser);
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecentItemTencentDocsAssistantData", 2, "RecentItemTencentDocsAssistantData update");
    }
    super.a(paramQQAppInterface, paramContext);
    this.b = paramContext.getString(2131439227);
    this.jdField_d_of_type_JavaLangCharSequence = "";
    paramQQAppInterface = ((TroopRedTouchManager)paramQQAppInterface.getManager(69)).a(46, false);
    label117:
    int i;
    label199:
    long l;
    if (paramQQAppInterface == null)
    {
      this.jdField_c_of_type_Int = 0;
      this.a = 0L;
      this.jdField_c_of_type_JavaLangString = "";
      this.jdField_c_of_type_JavaLangCharSequence = paramContext.getString(2131439228);
      if (AppSetting.b)
      {
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append(this.b).append(",");
        if (this.jdField_c_of_type_Int != 0) {
          break label368;
        }
        if (this.jdField_d_of_type_JavaLangCharSequence != null) {
          paramQQAppInterface.append(this.jdField_d_of_type_JavaLangCharSequence + ",");
        }
        paramQQAppInterface.append(this.jdField_c_of_type_JavaLangCharSequence).append(",").append(this.jdField_c_of_type_JavaLangString);
        this.jdField_d_of_type_JavaLangString = paramQQAppInterface.toString();
      }
    }
    else if (paramQQAppInterface.uint32_number.has())
    {
      i = paramQQAppInterface.uint32_number.get();
      this.jdField_c_of_type_Int = i;
      if (!paramQQAppInterface.uint32_last_time.has()) {
        break label338;
      }
      l = paramQQAppInterface.uint32_last_time.get();
      label224:
      this.a = l;
      if ((this.a > 0L) && (this.a != 9223372036854775806L)) {
        this.jdField_c_of_type_JavaLangString = TimeManager.a().a(a(), this.a);
      }
    }
    for (;;)
    {
      try
      {
        if (!paramQQAppInterface.str_custom_buffer.has()) {
          continue;
        }
        paramQQAppInterface = paramQQAppInterface.str_custom_buffer.get().toStringUtf8();
        if (paramQQAppInterface == null) {
          break label433;
        }
        paramQQAppInterface = new JSONObject(paramQQAppInterface);
        if (!paramQQAppInterface.has("msg")) {
          break label433;
        }
        paramQQAppInterface = paramQQAppInterface.getString("msg");
      }
      catch (Exception paramQQAppInterface)
      {
        label338:
        paramQQAppInterface = null;
        continue;
        this.jdField_c_of_type_JavaLangCharSequence = paramContext.getString(2131439228);
      }
      if (!TextUtils.isEmpty(paramQQAppInterface))
      {
        this.jdField_c_of_type_JavaLangCharSequence = paramQQAppInterface;
        break;
        i = 0;
        break label199;
        l = 0L;
        break label224;
        paramQQAppInterface = null;
        continue;
      }
      break;
      label368:
      if (this.jdField_c_of_type_Int == 1)
      {
        paramQQAppInterface.append("有一条未读");
        break label117;
      }
      if (this.jdField_c_of_type_Int == 2)
      {
        paramQQAppInterface.append("有两条未读");
        break label117;
      }
      if (this.jdField_c_of_type_Int <= 0) {
        break label117;
      }
      paramQQAppInterface.append("有").append(this.jdField_c_of_type_Int).append("条未读,");
      break label117;
      label433:
      paramQQAppInterface = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentItemTencentDocsAssistantData
 * JD-Core Version:    0.7.0.1
 */