package com.tencent.mobileqq.activity.qwallet.fragment.busylogic;

import Wallet.SkinInfo;
import com.tencent.mobileqq.app.HardCodeUtil;
import java.util.Iterator;
import java.util.List;

public class HbSkinInfo$HbSkinFactory
{
  public static HbSkinInfo a(String paramString)
  {
    HbSkinInfo localHbSkinInfo = new HbSkinInfo(HardCodeUtil.a(2131705454));
    localHbSkinInfo.jdField_b_of_type_Int = -2;
    localHbSkinInfo.jdField_a_of_type_WalletSkinInfo.skin_id = -2;
    localHbSkinInfo.jdField_a_of_type_WalletSkinInfo.skin_permission_state = 1L;
    localHbSkinInfo.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketRedPacketInfoBase.title = paramString;
    localHbSkinInfo.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketRedPacketInfoBase.icon = null;
    localHbSkinInfo.jdField_a_of_type_Int = 0;
    return localHbSkinInfo;
  }
  
  public static HbSkinInfo a(List<HbSkinInfo> paramList, int paramInt)
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
  
  public static HbSkinInfo b(String paramString)
  {
    HbSkinInfo localHbSkinInfo = new HbSkinInfo(HardCodeUtil.a(2131705456));
    localHbSkinInfo.jdField_b_of_type_Int = -1;
    localHbSkinInfo.jdField_a_of_type_WalletSkinInfo.skin_id = 0;
    localHbSkinInfo.jdField_a_of_type_WalletSkinInfo.skin_permission_state = 1L;
    localHbSkinInfo.jdField_a_of_type_WalletSkinInfo.is_hide_title = 0;
    localHbSkinInfo.jdField_a_of_type_WalletSkinInfo.blessing = HardCodeUtil.a(2131696794);
    localHbSkinInfo.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketRedPacketInfoBase.title = paramString;
    localHbSkinInfo.jdField_a_of_type_Int = -1;
    return localHbSkinInfo;
  }
  
  public static HbSkinInfo c(String paramString)
  {
    HbSkinInfo localHbSkinInfo = new HbSkinInfo(HardCodeUtil.a(2131705455));
    localHbSkinInfo.jdField_b_of_type_JavaLangString = paramString;
    localHbSkinInfo.jdField_b_of_type_Int = 1;
    localHbSkinInfo.jdField_a_of_type_Int = 1000;
    localHbSkinInfo.jdField_a_of_type_WalletSkinInfo.skin_id = -1;
    localHbSkinInfo.jdField_a_of_type_WalletSkinInfo.skin_permission_state = 1L;
    return localHbSkinInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.fragment.busylogic.HbSkinInfo.HbSkinFactory
 * JD-Core Version:    0.7.0.1
 */