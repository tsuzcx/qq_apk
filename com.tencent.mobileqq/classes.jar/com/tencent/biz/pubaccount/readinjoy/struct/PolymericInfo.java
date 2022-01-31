package com.tencent.biz.pubaccount.readinjoy.struct;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.PackInfo;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.SpecialTopicInfo;

public class PolymericInfo
{
  public int a;
  public long a;
  public String a;
  public oidb_cmd0x68b.PackInfo a;
  public int b;
  public long b;
  public String b;
  public int c;
  public long c;
  public String c;
  public int d;
  public long d;
  public String d;
  public long e;
  public long f;
  
  public PolymericInfo()
  {
    this.jdField_a_of_type_Int = 6;
  }
  
  public static PolymericInfo a(oidb_cmd0x68b.PackInfo paramPackInfo)
  {
    try
    {
      PolymericInfo localPolymericInfo = new PolymericInfo();
      localPolymericInfo.jdField_a_of_type_TencentImOidbCmd0x68bOidb_cmd0x68b$PackInfo = paramPackInfo;
      localPolymericInfo.jdField_a_of_type_JavaLangString = ((oidb_cmd0x68b.SpecialTopicInfo)paramPackInfo.msg_special_topic_info.get()).str_header_title.get();
      localPolymericInfo.jdField_b_of_type_JavaLangString = ((oidb_cmd0x68b.SpecialTopicInfo)paramPackInfo.msg_special_topic_info.get()).bytes_recommend_reason.get().toStringUtf8();
      localPolymericInfo.jdField_b_of_type_Long = ((oidb_cmd0x68b.SpecialTopicInfo)paramPackInfo.msg_special_topic_info.get()).uint64_puin.get();
      localPolymericInfo.jdField_c_of_type_JavaLangString = ((oidb_cmd0x68b.SpecialTopicInfo)paramPackInfo.msg_special_topic_info.get()).str_header_icon_url.get();
      localPolymericInfo.jdField_a_of_type_Int = paramPackInfo.pack_type.get();
      localPolymericInfo.jdField_c_of_type_Long = paramPackInfo.uint64_pack_id.get();
      localPolymericInfo.jdField_d_of_type_JavaLangString = ((oidb_cmd0x68b.SpecialTopicInfo)paramPackInfo.msg_special_topic_info.get()).str_header_jump_url.get();
      localPolymericInfo.jdField_b_of_type_Int = ((oidb_cmd0x68b.SpecialTopicInfo)paramPackInfo.msg_special_topic_info.get()).uint32_icon_shape.get();
      localPolymericInfo.e = ((oidb_cmd0x68b.SpecialTopicInfo)paramPackInfo.msg_special_topic_info.get()).uint64_algorithm_id.get();
      localPolymericInfo.jdField_d_of_type_Long = ((oidb_cmd0x68b.SpecialTopicInfo)paramPackInfo.msg_special_topic_info.get()).uint32_strategy_id.get();
      localPolymericInfo.f = ((oidb_cmd0x68b.SpecialTopicInfo)paramPackInfo.msg_special_topic_info.get()).uint64_topic_id.get();
      localPolymericInfo.jdField_a_of_type_Long = ((oidb_cmd0x68b.SpecialTopicInfo)paramPackInfo.msg_special_topic_info.get()).uint32_posttime.get();
      localPolymericInfo.jdField_c_of_type_Int = ((oidb_cmd0x68b.SpecialTopicInfo)paramPackInfo.msg_special_topic_info.get()).uint32_topic_number_count.get();
      localPolymericInfo.jdField_d_of_type_Int = ((oidb_cmd0x68b.SpecialTopicInfo)paramPackInfo.msg_special_topic_info.get()).uint32_video_count.get();
      return localPolymericInfo;
    }
    catch (Exception paramPackInfo) {}
    return null;
  }
  
  public String toString()
  {
    return "PolymericInfo【 packID : " + this.jdField_c_of_type_Long + "\n polymericType : " + this.jdField_a_of_type_Int + "\n algorithmID : " + this.e + "\n strategyID : " + this.jdField_d_of_type_Long + "\n title : " + this.jdField_a_of_type_JavaLangString + "\n desc : " + this.jdField_b_of_type_JavaLangString + "\n publicTime : " + this.jdField_a_of_type_Long + "\n iconUrl : " + this.jdField_c_of_type_JavaLangString + "\n uin : " + this.jdField_b_of_type_Long + "\n topicID : " + this.f + "\n topicMemberCount : " + this.jdField_c_of_type_Int + "\n jumpUrl : " + this.jdField_d_of_type_JavaLangString + "\n videoCount : " + this.jdField_d_of_type_Int + "】";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.struct.PolymericInfo
 * JD-Core Version:    0.7.0.1
 */