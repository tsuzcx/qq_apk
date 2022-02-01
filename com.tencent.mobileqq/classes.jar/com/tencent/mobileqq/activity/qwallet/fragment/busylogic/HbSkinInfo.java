package com.tencent.mobileqq.activity.qwallet.fragment.busylogic;

import Wallet.SkinInfo;
import com.tencent.mobileqq.activity.qwallet.redpacket.RedPacketInfoBase;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class HbSkinInfo
{
  public static boolean a;
  public static int c = 0;
  public int a;
  public SkinInfo a;
  public RedPacketInfoBase a;
  public String a;
  public int b;
  public String b;
  
  static
  {
    jdField_a_of_type_Boolean = false;
  }
  
  public HbSkinInfo(SkinInfo paramSkinInfo)
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = 0;
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
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_WalletSkinInfo = new SkinInfo();
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketRedPacketInfoBase = new RedPacketInfoBase();
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public static int a(List<HbSkinInfo> paramList)
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
  
  public static void a(List<HbSkinInfo> paramList)
  {
    Collections.sort(paramList, new HbSkinInfo.1());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.fragment.busylogic.HbSkinInfo
 * JD-Core Version:    0.7.0.1
 */