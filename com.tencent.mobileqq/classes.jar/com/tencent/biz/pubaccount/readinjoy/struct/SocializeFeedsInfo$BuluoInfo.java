package com.tencent.biz.pubaccount.readinjoy.struct;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.oidb.articlesummary.articlesummary.BuluoInfo;

public class SocializeFeedsInfo$BuluoInfo
{
  public long a;
  public String a;
  public String b;
  public String c;
  public String d;
  
  public static BuluoInfo a(articlesummary.BuluoInfo paramBuluoInfo)
  {
    BuluoInfo localBuluoInfo = new BuluoInfo();
    String str;
    if (paramBuluoInfo.bytes_wording.has())
    {
      str = paramBuluoInfo.bytes_wording.get().toStringUtf8();
      localBuluoInfo.jdField_a_of_type_JavaLangString = str;
      if (!paramBuluoInfo.bytes_head_url.has()) {
        break label131;
      }
      str = paramBuluoInfo.bytes_head_url.get().toStringUtf8();
      label55:
      localBuluoInfo.d = str;
      localBuluoInfo.jdField_a_of_type_Long = paramBuluoInfo.uint64_buluo_id.get();
      if (!paramBuluoInfo.bytes_jump_url.has()) {
        break label137;
      }
      str = paramBuluoInfo.bytes_jump_url.get().toStringUtf8();
      label92:
      localBuluoInfo.b = str;
      if (!paramBuluoInfo.bytes_name.has()) {
        break label143;
      }
    }
    label131:
    label137:
    label143:
    for (paramBuluoInfo = paramBuluoInfo.bytes_name.get().toStringUtf8();; paramBuluoInfo = "")
    {
      localBuluoInfo.c = paramBuluoInfo;
      return localBuluoInfo;
      str = "";
      break;
      str = "";
      break label55;
      str = "";
      break label92;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.BuluoInfo
 * JD-Core Version:    0.7.0.1
 */