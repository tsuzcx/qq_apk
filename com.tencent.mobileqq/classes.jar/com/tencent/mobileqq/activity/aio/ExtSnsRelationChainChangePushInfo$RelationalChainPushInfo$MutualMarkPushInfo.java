package com.tencent.mobileqq.activity.aio;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.mutualmark.MutualMarkUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import tencent.im.s2c.msgtype0x210.submsgtype0xc7.bussinfo.mutualmark.mutualmark.MutualmarkInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0xc7.bussinfo.mutualmark.mutualmark.ResourceInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0xc7.bussinfo.mutualmark.mutualmark.ResourceInfo_17;

public class ExtSnsRelationChainChangePushInfo$RelationalChainPushInfo$MutualMarkPushInfo
{
  public int a;
  public long a;
  public String a;
  public boolean a;
  public int b;
  public long b;
  public String b;
  public boolean b;
  public long c;
  public String c;
  public long d;
  public String d;
  public long e;
  public String e;
  public long f;
  public String f;
  public long g;
  public String g;
  public long h;
  
  public ExtSnsRelationChainChangePushInfo$RelationalChainPushInfo$MutualMarkPushInfo()
  {
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_e_of_type_JavaLangString = "";
    this.jdField_f_of_type_JavaLangString = "";
    this.jdField_g_of_type_JavaLangString = "";
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
  }
  
  public static MutualMarkPushInfo a(long paramLong, byte[] paramArrayOfByte)
  {
    Object localObject2 = new mutualmark.MutualmarkInfo();
    try
    {
      ((mutualmark.MutualmarkInfo)localObject2).mergeFrom(paramArrayOfByte);
      localObject1 = new MutualMarkPushInfo();
      ((MutualMarkPushInfo)localObject1).jdField_a_of_type_Long = paramLong;
      if (((mutualmark.MutualmarkInfo)localObject2).uint32_level.has()) {
        ((MutualMarkPushInfo)localObject1).jdField_b_of_type_Long = ((mutualmark.MutualmarkInfo)localObject2).uint32_level.get();
      }
      if (((mutualmark.MutualmarkInfo)localObject2).uint64_last_action_time.has()) {
        ((MutualMarkPushInfo)localObject1).jdField_c_of_type_Long = ((mutualmark.MutualmarkInfo)localObject2).uint64_last_action_time.get();
      }
      if (((mutualmark.MutualmarkInfo)localObject2).uint64_last_change_time.has()) {
        ((MutualMarkPushInfo)localObject1).jdField_d_of_type_Long = ((mutualmark.MutualmarkInfo)localObject2).uint64_last_change_time.get();
      }
      if (((mutualmark.MutualmarkInfo)localObject2).uint32_continue_days.has()) {
        ((MutualMarkPushInfo)localObject1).jdField_a_of_type_Int = ((mutualmark.MutualmarkInfo)localObject2).uint32_continue_days.get();
      }
      if (((mutualmark.MutualmarkInfo)localObject2).bytes_wildcard_wording.has()) {
        ((MutualMarkPushInfo)localObject1).jdField_a_of_type_JavaLangString = ((mutualmark.MutualmarkInfo)localObject2).bytes_wildcard_wording.get().toStringUtf8();
      }
      if (((mutualmark.MutualmarkInfo)localObject2).bytes_duplicate_removal_key.has()) {
        ((MutualMarkPushInfo)localObject1).jdField_b_of_type_JavaLangString = ((mutualmark.MutualmarkInfo)localObject2).bytes_duplicate_removal_key.get().toStringUtf8();
      }
      if (((mutualmark.MutualmarkInfo)localObject2).uint64_notify_time.has()) {
        ((MutualMarkPushInfo)localObject1).jdField_e_of_type_Long = ((mutualmark.MutualmarkInfo)localObject2).uint64_notify_time.get();
      }
      if (((mutualmark.MutualmarkInfo)localObject2).uint64_icon_status.has()) {
        ((MutualMarkPushInfo)localObject1).jdField_f_of_type_Long = ((mutualmark.MutualmarkInfo)localObject2).uint64_icon_status.get();
      }
      if (((mutualmark.MutualmarkInfo)localObject2).uint64_icon_status_end_time.has()) {
        ((MutualMarkPushInfo)localObject1).jdField_g_of_type_Long = ((mutualmark.MutualmarkInfo)localObject2).uint64_icon_status_end_time.get();
      }
      if (((mutualmark.MutualmarkInfo)localObject2).uint64_sub_level.has()) {
        ((MutualMarkPushInfo)localObject1).h = ((mutualmark.MutualmarkInfo)localObject2).uint64_sub_level.get();
      }
      if (((mutualmark.MutualmarkInfo)localObject2).uint32_graytip_type.has()) {
        ((MutualMarkPushInfo)localObject1).jdField_b_of_type_Int = ((mutualmark.MutualmarkInfo)localObject2).uint32_graytip_type.get();
      }
      if (((mutualmark.MutualmarkInfo)localObject2).uint32_close_flag.has())
      {
        boolean bool;
        if (((mutualmark.MutualmarkInfo)localObject2).uint32_close_flag.get() != 0) {
          bool = true;
        } else {
          bool = false;
        }
        ((MutualMarkPushInfo)localObject1).jdField_a_of_type_Boolean = bool;
      }
      if (((mutualmark.MutualmarkInfo)localObject2).bytes_resource_info.has())
      {
        paramArrayOfByte = new mutualmark.ResourceInfo_17();
        try
        {
          paramArrayOfByte.mergeFrom(((mutualmark.MutualmarkInfo)localObject2).bytes_resource_info.get().toByteArray());
        }
        catch (Throwable paramArrayOfByte)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("ResourceInfo_17 parseFrom error:");
          localStringBuilder.append(paramArrayOfByte.getMessage());
          QLog.i("MutualMarkInfo", 1, localStringBuilder.toString());
          paramArrayOfByte = null;
        }
        a((MutualMarkPushInfo)localObject1, paramArrayOfByte);
      }
      if (((mutualmark.MutualmarkInfo)localObject2).bytes_grade_resource_info.has())
      {
        paramArrayOfByte = new mutualmark.ResourceInfo();
        try
        {
          paramArrayOfByte.mergeFrom(((mutualmark.MutualmarkInfo)localObject2).bytes_grade_resource_info.get().toByteArray());
        }
        catch (Throwable paramArrayOfByte)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("ResourceInfo parseFrom error:");
          ((StringBuilder)localObject2).append(paramArrayOfByte.getMessage());
          QLog.i("MutualMarkInfo", 1, ((StringBuilder)localObject2).toString());
          paramArrayOfByte = null;
        }
        a((MutualMarkPushInfo)localObject1, paramArrayOfByte);
      }
      if (QLog.isColorLevel())
      {
        paramArrayOfByte = new StringBuilder();
        paramArrayOfByte.append("parseFrom retInfo:");
        paramArrayOfByte.append(localObject1);
        QLog.i("MutualMarkInfo", 1, paramArrayOfByte.toString());
      }
      return localObject1;
    }
    catch (Throwable paramArrayOfByte)
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("MutualMarkPushInfo parseFrom error:");
      ((StringBuilder)localObject1).append(paramArrayOfByte.getMessage());
      QLog.i("MutualMarkInfo", 1, ((StringBuilder)localObject1).toString());
    }
    return null;
  }
  
  private static void a(MutualMarkPushInfo paramMutualMarkPushInfo, mutualmark.ResourceInfo paramResourceInfo)
  {
    if (paramResourceInfo != null)
    {
      if (paramResourceInfo.bytes_static_url.has())
      {
        paramMutualMarkPushInfo.jdField_c_of_type_JavaLangString = paramResourceInfo.bytes_static_url.get().toStringUtf8();
        paramMutualMarkPushInfo.jdField_c_of_type_JavaLangString = MutualMarkUtils.b(paramMutualMarkPushInfo.jdField_c_of_type_JavaLangString);
      }
      if (paramResourceInfo.bytes_dynamic_url.has())
      {
        paramMutualMarkPushInfo.jdField_d_of_type_JavaLangString = paramResourceInfo.bytes_dynamic_url.get().toStringUtf8();
        paramMutualMarkPushInfo.jdField_d_of_type_JavaLangString = MutualMarkUtils.b(paramMutualMarkPushInfo.jdField_d_of_type_JavaLangString);
      }
      if (paramResourceInfo.bytes_cartoon_url.has())
      {
        paramMutualMarkPushInfo.jdField_e_of_type_JavaLangString = paramResourceInfo.bytes_cartoon_url.get().toStringUtf8();
        paramMutualMarkPushInfo.jdField_e_of_type_JavaLangString = MutualMarkUtils.b(paramMutualMarkPushInfo.jdField_e_of_type_JavaLangString);
      }
      if (paramResourceInfo.bytes_cartoon_md5.has()) {
        paramMutualMarkPushInfo.jdField_f_of_type_JavaLangString = paramResourceInfo.bytes_cartoon_md5.get().toStringUtf8();
      }
      if (paramResourceInfo.bytes_word.has()) {
        paramMutualMarkPushInfo.jdField_g_of_type_JavaLangString = paramResourceInfo.bytes_word.get().toStringUtf8();
      }
      if (paramResourceInfo.uint32_play_cartoon.has())
      {
        int i = paramResourceInfo.uint32_play_cartoon.get();
        boolean bool = true;
        if (i != 1) {
          bool = false;
        }
        paramMutualMarkPushInfo.jdField_b_of_type_Boolean = bool;
      }
    }
  }
  
  private static void a(MutualMarkPushInfo paramMutualMarkPushInfo, mutualmark.ResourceInfo_17 paramResourceInfo_17)
  {
    if (paramResourceInfo_17 != null)
    {
      if (paramResourceInfo_17.bytes_static_url.has())
      {
        paramMutualMarkPushInfo.jdField_c_of_type_JavaLangString = paramResourceInfo_17.bytes_static_url.get().toStringUtf8();
        paramMutualMarkPushInfo.jdField_c_of_type_JavaLangString = MutualMarkUtils.b(paramMutualMarkPushInfo.jdField_c_of_type_JavaLangString);
      }
      if (paramResourceInfo_17.bytes_dynamic_url.has())
      {
        paramMutualMarkPushInfo.jdField_d_of_type_JavaLangString = paramResourceInfo_17.bytes_dynamic_url.get().toStringUtf8();
        paramMutualMarkPushInfo.jdField_d_of_type_JavaLangString = MutualMarkUtils.b(paramMutualMarkPushInfo.jdField_d_of_type_JavaLangString);
      }
      if (paramResourceInfo_17.bytes_cartoon_url.has())
      {
        paramMutualMarkPushInfo.jdField_e_of_type_JavaLangString = paramResourceInfo_17.bytes_cartoon_url.get().toStringUtf8();
        paramMutualMarkPushInfo.jdField_e_of_type_JavaLangString = MutualMarkUtils.b(paramMutualMarkPushInfo.jdField_e_of_type_JavaLangString);
      }
      if (paramResourceInfo_17.bytes_cartoon_md5.has()) {
        paramMutualMarkPushInfo.jdField_f_of_type_JavaLangString = paramResourceInfo_17.bytes_cartoon_md5.get().toStringUtf8();
      }
      if (paramResourceInfo_17.bytes_word.has()) {
        paramMutualMarkPushInfo.jdField_g_of_type_JavaLangString = paramResourceInfo_17.bytes_word.get().toStringUtf8();
      }
      if (paramResourceInfo_17.uint32_play_cartoon.has())
      {
        int i = paramResourceInfo_17.uint32_play_cartoon.get();
        boolean bool = true;
        if (i != 1) {
          bool = false;
        }
        paramMutualMarkPushInfo.jdField_b_of_type_Boolean = bool;
      }
    }
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ExtSnsMutualMarkPushInfo{");
    localStringBuilder.append("relation_type:");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append(", ");
    localStringBuilder.append("relation_level:");
    localStringBuilder.append(this.jdField_b_of_type_Long);
    localStringBuilder.append(", ");
    localStringBuilder.append("last_action_time:");
    localStringBuilder.append(this.jdField_c_of_type_Long);
    localStringBuilder.append(", ");
    localStringBuilder.append("last_change_time:");
    localStringBuilder.append(this.jdField_d_of_type_Long);
    localStringBuilder.append(", ");
    localStringBuilder.append("continue_days:");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", ");
    localStringBuilder.append("notify_time:");
    localStringBuilder.append(this.jdField_e_of_type_Long);
    localStringBuilder.append(", ");
    localStringBuilder.append("icon_status:");
    localStringBuilder.append(this.jdField_f_of_type_Long);
    localStringBuilder.append(", ");
    localStringBuilder.append("icon_status_end_time:");
    localStringBuilder.append(this.jdField_g_of_type_Long);
    localStringBuilder.append(", ");
    localStringBuilder.append("sub_level:");
    localStringBuilder.append(this.h);
    localStringBuilder.append(", ");
    localStringBuilder.append("grayTipType:");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append(", ");
    localStringBuilder.append("wildcard_wording:");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(", ");
    localStringBuilder.append("gray_tip_duplicate_key:");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append(", ");
    localStringBuilder.append("icon_static_url:");
    localStringBuilder.append(this.jdField_c_of_type_JavaLangString);
    localStringBuilder.append(", ");
    localStringBuilder.append("icon_dynamic_url:");
    localStringBuilder.append(this.jdField_d_of_type_JavaLangString);
    localStringBuilder.append(", ");
    localStringBuilder.append("icon_cartoon_url:");
    localStringBuilder.append(this.jdField_e_of_type_JavaLangString);
    localStringBuilder.append(", ");
    localStringBuilder.append("icon_cartoon_md5:");
    localStringBuilder.append(this.jdField_f_of_type_JavaLangString);
    localStringBuilder.append(", ");
    localStringBuilder.append("icon_name:");
    localStringBuilder.append(this.jdField_g_of_type_JavaLangString);
    localStringBuilder.append(", ");
    localStringBuilder.append("user_close_flag:");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append(", ");
    localStringBuilder.append("play_cartoon:");
    localStringBuilder.append(this.jdField_b_of_type_Boolean);
    localStringBuilder.append(", ");
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.ExtSnsRelationChainChangePushInfo.RelationalChainPushInfo.MutualMarkPushInfo
 * JD-Core Version:    0.7.0.1
 */