package com.tencent.mobileqq.activity.qwallet.fragment;

import Wallet.SkinInfo;
import com.tencent.mobileqq.activity.qwallet.redpacket.RedPacketInfoBase;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import xak;

public class HbSkinInfo
{
  public static boolean a;
  public static int c = -1;
  public int a;
  public SkinInfo a;
  public RedPacketInfoBase a;
  public String a;
  public int b;
  public String b;
  
  public HbSkinInfo(SkinInfo paramSkinInfo)
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_WalletSkinInfo = new SkinInfo();
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketRedPacketInfoBase = new RedPacketInfoBase();
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaLangString = paramSkinInfo.skin_name;
    this.jdField_a_of_type_WalletSkinInfo = paramSkinInfo;
  }
  
  public HbSkinInfo(String paramString)
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_WalletSkinInfo = new SkinInfo();
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketRedPacketInfoBase = new RedPacketInfoBase();
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public static int a(List paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      HbSkinInfo localHbSkinInfo = (HbSkinInfo)paramList.next();
      if (c == localHbSkinInfo.jdField_a_of_type_WalletSkinInfo.skin_id) {
        return localHbSkinInfo.jdField_a_of_type_WalletSkinInfo.skin_id;
      }
    }
    return -1;
  }
  
  public static HbSkinInfo a(String paramString)
  {
    HbSkinInfo localHbSkinInfo = new HbSkinInfo("默认封皮");
    localHbSkinInfo.jdField_b_of_type_Int = -1;
    localHbSkinInfo.jdField_a_of_type_WalletSkinInfo.skin_id = 0;
    localHbSkinInfo.jdField_a_of_type_WalletSkinInfo.skin_permission_state = 1L;
    localHbSkinInfo.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketRedPacketInfoBase.title = paramString;
    return localHbSkinInfo;
  }
  
  public static HbSkinInfo a(List paramList, int paramInt)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      HbSkinInfo localHbSkinInfo = (HbSkinInfo)paramList.next();
      if (localHbSkinInfo.jdField_a_of_type_WalletSkinInfo.skin_id == paramInt) {
        return localHbSkinInfo;
      }
    }
    return null;
  }
  
  public static void a(List paramList)
  {
    Collections.sort(paramList, new xak());
  }
  
  public static HbSkinInfo b(String paramString)
  {
    HbSkinInfo localHbSkinInfo = new HbSkinInfo("更多皮肤");
    localHbSkinInfo.jdField_b_of_type_JavaLangString = paramString;
    localHbSkinInfo.jdField_b_of_type_Int = 1;
    localHbSkinInfo.jdField_a_of_type_Int = 1000;
    localHbSkinInfo.jdField_a_of_type_WalletSkinInfo.skin_id = -1;
    localHbSkinInfo.jdField_a_of_type_WalletSkinInfo.skin_permission_state = 1L;
    return localHbSkinInfo;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof HbSkinInfo)) {
        break;
      }
    } while (this.jdField_a_of_type_WalletSkinInfo.skin_id == ((HbSkinInfo)paramObject).jdField_a_of_type_WalletSkinInfo.skin_id);
    return false;
    return super.equals(paramObject);
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("");
    localStringBuffer.append("background : " + this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketRedPacketInfoBase.background + " | ");
    localStringBuffer.append("icon : " + this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketRedPacketInfoBase.icon + " | ");
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.fragment.HbSkinInfo
 * JD-Core Version:    0.7.0.1
 */