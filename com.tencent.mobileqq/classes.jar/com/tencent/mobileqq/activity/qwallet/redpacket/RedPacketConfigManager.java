package com.tencent.mobileqq.activity.qwallet.redpacket;

import com.tencent.mobileqq.activity.qwallet.config.QWalletConfigManager;
import com.tencent.mobileqq.activity.qwallet.utils.QWalletTools;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;

public class RedPacketConfigManager
{
  private static volatile RedPacketConfigManager jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketRedPacketConfigManager;
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { HardCodeUtil.a(2131713276), HardCodeUtil.a(2131713266), HardCodeUtil.a(2131713247) };
  private static final String[] b = { HardCodeUtil.a(2131713272), HardCodeUtil.a(2131713267), HardCodeUtil.a(2131713252) };
  
  public static RedPacketConfigManager a()
  {
    if (jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketRedPacketConfigManager == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketRedPacketConfigManager == null) {
        jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketRedPacketConfigManager = new RedPacketConfigManager();
      }
      return jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketRedPacketConfigManager;
    }
    finally {}
  }
  
  public int a()
  {
    Object localObject = QWalletTools.a();
    if (localObject != null)
    {
      localObject = (QWalletConfigManager)((QQAppInterface)localObject).getManager(QQManagerFactory.QWALLET_CONFIG_MANAGER);
      if (localObject != null) {
        return ((QWalletConfigManager)localObject).a("hb_exclusive", 1, new String[] { "ani_queue_max" });
      }
    }
    return 1;
  }
  
  public boolean a()
  {
    Object localObject = QWalletTools.a();
    if (localObject != null)
    {
      localObject = (QWalletConfigManager)((QQAppInterface)localObject).getManager(QQManagerFactory.QWALLET_CONFIG_MANAGER);
      if (localObject != null) {
        return ((QWalletConfigManager)localObject).a("hb_exclusive", 1, new String[] { "is_display_all" }) == 1;
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.redpacket.RedPacketConfigManager
 * JD-Core Version:    0.7.0.1
 */