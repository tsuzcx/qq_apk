package com.tencent.mobileqq.armap;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.oidb.cmd0x7bb.oidb_0x7bb.ItemInfo;
import tencent.im.oidb.cmd0x7bb.oidb_0x7bb.PoiInfo;
import tencent.im.oidb.cmd0x98b.oidb_0x98b.ItemInfo;

public class ItemInfo
{
  public int a;
  public long a;
  public POIInfo a;
  public String a;
  public int b;
  public long b;
  public String b;
  public int c;
  public String c;
  public int d;
  public String d;
  public int e;
  public String e;
  public int f;
  public String f;
  public int g;
  public String g;
  public String h;
  
  public static ItemInfo a(oidb_0x7bb.ItemInfo paramItemInfo)
  {
    long l2 = 0L;
    int j = 0;
    if (paramItemInfo == null) {
      return new ItemInfo();
    }
    ItemInfo localItemInfo = new ItemInfo();
    int i;
    label68:
    Object localObject;
    label96:
    label125:
    long l1;
    if (paramItemInfo.item_id.has())
    {
      i = paramItemInfo.item_id.get();
      localItemInfo.jdField_a_of_type_Int = i;
      if (!paramItemInfo.type.has()) {
        break label488;
      }
      i = paramItemInfo.type.get();
      localItemInfo.jdField_b_of_type_Int = i;
      if (!paramItemInfo.name.has()) {
        break label493;
      }
      localObject = paramItemInfo.name.get().toStringUtf8();
      localItemInfo.jdField_a_of_type_JavaLangString = ((String)localObject);
      if (!paramItemInfo.icon.has()) {
        break label500;
      }
      localObject = paramItemInfo.icon.get().toStringUtf8();
      localItemInfo.jdField_b_of_type_JavaLangString = ((String)localObject);
      if (!paramItemInfo.url.has()) {
        break label507;
      }
      localObject = paramItemInfo.url.get().toStringUtf8();
      label154:
      localItemInfo.jdField_c_of_type_JavaLangString = ((String)localObject);
      if (!paramItemInfo.unlock.has()) {
        break label514;
      }
      i = paramItemInfo.unlock.get();
      label179:
      localItemInfo.jdField_c_of_type_Int = i;
      if (!paramItemInfo.level.has()) {
        break label519;
      }
      i = paramItemInfo.level.get();
      label203:
      localItemInfo.jdField_d_of_type_Int = i;
      if (!paramItemInfo.count.has()) {
        break label524;
      }
      i = paramItemInfo.count.get();
      label227:
      localItemInfo.jdField_e_of_type_Int = i;
      if (!paramItemInfo.ctime.has()) {
        break label529;
      }
      l1 = paramItemInfo.ctime.get();
      label251:
      localItemInfo.jdField_a_of_type_Long = l1;
      l1 = l2;
      if (paramItemInfo.expire.has()) {
        l1 = paramItemInfo.expire.get();
      }
      localItemInfo.jdField_b_of_type_Long = l1;
      if (!paramItemInfo.info.has()) {
        break label534;
      }
      localObject = (oidb_0x7bb.PoiInfo)paramItemInfo.info.get();
      label306:
      localItemInfo.jdField_a_of_type_ComTencentMobileqqArmapPOIInfo = POIInfo.a((oidb_0x7bb.PoiInfo)localObject);
      if (!paramItemInfo.icon.has()) {
        break label540;
      }
      localObject = paramItemInfo.icon.get().toStringUtf8();
      label338:
      localItemInfo.jdField_d_of_type_JavaLangString = ((String)localObject);
      if (!paramItemInfo.belong.has()) {
        break label547;
      }
      i = paramItemInfo.belong.get();
      label363:
      localItemInfo.jdField_f_of_type_Int = i;
      i = j;
      if (paramItemInfo.cooldown.has()) {
        i = paramItemInfo.cooldown.get();
      }
      localItemInfo.jdField_g_of_type_Int = i;
      if (!paramItemInfo.extra.has()) {
        break label552;
      }
      localObject = paramItemInfo.extra.get().toStringUtf8();
      label417:
      localItemInfo.jdField_e_of_type_JavaLangString = ((String)localObject);
      if (!paramItemInfo.sig.has()) {
        break label559;
      }
      localObject = paramItemInfo.sig.get().toStringUtf8();
      label446:
      localItemInfo.jdField_f_of_type_JavaLangString = ((String)localObject);
      if (!paramItemInfo.billno.has()) {
        break label566;
      }
    }
    label514:
    label519:
    label524:
    label529:
    label534:
    label540:
    label547:
    label552:
    label559:
    label566:
    for (paramItemInfo = paramItemInfo.billno.get().toStringUtf8();; paramItemInfo = "")
    {
      localItemInfo.jdField_g_of_type_JavaLangString = paramItemInfo;
      return localItemInfo;
      i = 0;
      break;
      label488:
      i = 0;
      break label68;
      label493:
      localObject = "";
      break label96;
      label500:
      localObject = "";
      break label125;
      label507:
      localObject = "";
      break label154;
      i = 0;
      break label179;
      i = 0;
      break label203;
      i = 0;
      break label227;
      l1 = 0L;
      break label251;
      localObject = null;
      break label306;
      localObject = "";
      break label338;
      i = 0;
      break label363;
      localObject = "";
      break label417;
      localObject = "";
      break label446;
    }
  }
  
  public static ItemInfo a(oidb_0x98b.ItemInfo paramItemInfo)
  {
    int j = 0;
    if (paramItemInfo == null) {
      return new ItemInfo();
    }
    ItemInfo localItemInfo = new ItemInfo();
    int i;
    label65:
    String str;
    if (paramItemInfo.item_id.has())
    {
      i = paramItemInfo.item_id.get();
      localItemInfo.jdField_a_of_type_Int = i;
      if (!paramItemInfo.type.has()) {
        break label240;
      }
      i = paramItemInfo.type.get();
      localItemInfo.jdField_b_of_type_Int = i;
      if (!paramItemInfo.name.has()) {
        break label245;
      }
      str = paramItemInfo.name.get().toStringUtf8();
      label92:
      localItemInfo.jdField_a_of_type_JavaLangString = str;
      if (!paramItemInfo.icon.has()) {
        break label251;
      }
      str = paramItemInfo.icon.get().toStringUtf8();
      label119:
      localItemInfo.jdField_b_of_type_JavaLangString = str;
      if (!paramItemInfo.url.has()) {
        break label257;
      }
      str = paramItemInfo.url.get().toStringUtf8();
      label146:
      localItemInfo.jdField_c_of_type_JavaLangString = str;
      i = j;
      if (paramItemInfo.count.has()) {
        i = paramItemInfo.count.get();
      }
      localItemInfo.jdField_e_of_type_Int = i;
      if (!paramItemInfo.icon.has()) {
        break label263;
      }
      str = paramItemInfo.icon.get().toStringUtf8();
      label199:
      localItemInfo.jdField_d_of_type_JavaLangString = str;
      if (!paramItemInfo.billno.has()) {
        break label269;
      }
    }
    label257:
    label263:
    label269:
    for (paramItemInfo = paramItemInfo.billno.get().toStringUtf8();; paramItemInfo = "")
    {
      localItemInfo.jdField_g_of_type_JavaLangString = paramItemInfo;
      return localItemInfo;
      i = 0;
      break;
      label240:
      i = 0;
      break label65;
      label245:
      str = "";
      break label92;
      label251:
      str = "";
      break label119;
      str = "";
      break label146;
      str = "";
      break label199;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("ItemInfo{");
    localStringBuilder.append("itemId:").append(this.jdField_a_of_type_Int).append(", type:").append(this.jdField_b_of_type_Int).append(", name:").append(this.jdField_a_of_type_JavaLangString).append(", iconUrl:").append(this.jdField_b_of_type_JavaLangString).append(", jumpUrl:").append(this.jdField_c_of_type_JavaLangString).append(", unlock:").append(this.jdField_c_of_type_Int).append(", level:").append(this.jdField_d_of_type_Int).append(", count:").append(this.jdField_e_of_type_Int).append(", ctime:").append(this.jdField_a_of_type_Long).append(", expire:").append(this.jdField_b_of_type_Long).append(", icon3dUrl:").append(this.jdField_d_of_type_JavaLangString).append(", belong:").append(this.jdField_f_of_type_Int).append(", cooldown:").append(this.jdField_g_of_type_Int).append(", extraJson:").append(this.jdField_e_of_type_JavaLangString).append(", sig:").append(this.jdField_f_of_type_JavaLangString).append(", billno:").append(this.jdField_g_of_type_JavaLangString).append(", businessName:").append(this.h).append(", poiInfo:{").append(this.jdField_a_of_type_ComTencentMobileqqArmapPOIInfo).append("}").append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.armap.ItemInfo
 * JD-Core Version:    0.7.0.1
 */