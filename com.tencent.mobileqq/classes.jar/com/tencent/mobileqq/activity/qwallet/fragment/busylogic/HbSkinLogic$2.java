package com.tencent.mobileqq.activity.qwallet.fragment.busylogic;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.qwallet.redpacket.IRedPacket.OnGetSkinListener;
import com.tencent.mobileqq.activity.qwallet.redpacket.RedPacketInfoBase;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.QwAdapter;
import java.util.List;

class HbSkinLogic$2
  implements IRedPacket.OnGetSkinListener
{
  HbSkinLogic$2(HbSkinLogic paramHbSkinLogic) {}
  
  public void onGetSkin(RedPacketInfoBase paramRedPacketInfoBase)
  {
    HbSkinInfo localHbSkinInfo = HbSkinInfo.HbSkinFactory.a(HbSkinLogic.a(this.a), paramRedPacketInfoBase.skinId);
    List localList;
    if (localHbSkinInfo != null)
    {
      localList = HbSkinLogic.a(this.a).getList();
      if (QLog.isColorLevel()) {
        QLog.d("HbSkinLogic", 2, "redl iscache = " + HbSkinInfo.jdField_a_of_type_Boolean + " info.iscache = " + paramRedPacketInfoBase.isCache);
      }
      if ((HbSkinInfo.jdField_a_of_type_Boolean == paramRedPacketInfoBase.isCache) && (!localList.contains(localHbSkinInfo))) {
        break label110;
      }
      if (QLog.isColorLevel()) {
        QLog.d("HbSkinLogic", 2, "no add in list...");
      }
    }
    label110:
    while ((paramRedPacketInfoBase.background == null) && (paramRedPacketInfoBase.animInfo == null)) {
      return;
    }
    if (TextUtils.isEmpty(paramRedPacketInfoBase.title)) {
      paramRedPacketInfoBase.title = HbSkinLogic.a();
    }
    localHbSkinInfo.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketRedPacketInfoBase = paramRedPacketInfoBase;
    if (QLog.isColorLevel()) {
      QLog.d("HbSkinLogic", 2, "redl add to list show!");
    }
    localList.add(localHbSkinInfo);
    HbSkinInfo.a(localList);
    HbSkinLogic.a(this.a).notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.fragment.busylogic.HbSkinLogic.2
 * JD-Core Version:    0.7.0.1
 */