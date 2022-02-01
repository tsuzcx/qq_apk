package com.tencent.mobileqq.activity;

import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopBusinessObserver;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.hiddenchat.TroopStatusUtil;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.troop.redpoint.RedPointUtils;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.utils.DBUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0x899.oidb_0x899.memberlist;

class ChatSettingForTroop$1
  extends TroopBusinessObserver
{
  ChatSettingForTroop$1(ChatSettingForTroop paramChatSettingForTroop) {}
  
  public void onAddRobot(boolean paramBoolean, int paramInt, long paramLong1, long paramLong2)
  {
    if (!paramBoolean) {}
    String str;
    do
    {
      return;
      str = paramLong1 + "";
    } while ((this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin == null) || (!str.equals(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin)));
    ChatSettingForTroop.a(this.a, true);
  }
  
  public void onDelRobotByWeb(String paramString1, String paramString2, String paramString3)
  {
    if ((paramString1 == null) || (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin == null) || (!paramString1.equals(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin))) {
      return;
    }
    ChatSettingForTroop.a(this.a, true);
  }
  
  public void onDeleteRobot(boolean paramBoolean, int paramInt, long paramLong1, long paramLong2)
  {
    if (!paramBoolean) {}
    String str;
    do
    {
      return;
      str = paramLong1 + "";
    } while ((this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin == null) || (!str.equals(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin)));
    ChatSettingForTroop.a(this.a, true);
  }
  
  public void onDeleteTroopMember(boolean paramBoolean, int paramInt, ArrayList<String> paramArrayList, String paramString)
  {
    super.onDeleteTroopMember(paramBoolean, paramInt, paramArrayList, paramString);
    if (!paramBoolean) {
      if (paramInt == 2) {
        QQToast.a(this.a, 1, HardCodeUtil.a(2131701825), 0).b(this.a.getTitleBarHeight());
      }
    }
    Object localObject1;
    do
    {
      return;
      localObject2 = "";
      localObject1 = localObject2;
      if (this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo != null)
      {
        localObject1 = localObject2;
        if (this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin != null) {
          localObject1 = this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin;
        }
      }
    } while (this.a.e == null);
    Object localObject2 = new HashSet();
    if ((paramString != null) && (paramString.equals(localObject1)))
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        paramString = (String)paramArrayList.next();
        localObject1 = this.a.e.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          oidb_0x899.memberlist localmemberlist = (oidb_0x899.memberlist)((Iterator)localObject1).next();
          if (paramString.equals(localmemberlist.uint64_member_uin.get() + "")) {
            ((Collection)localObject2).add(localmemberlist);
          }
        }
      }
      paramArrayList = ((Collection)localObject2).iterator();
      while (paramArrayList.hasNext())
      {
        paramString = (oidb_0x899.memberlist)paramArrayList.next();
        this.a.e.remove(paramString);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.chatopttroop", 2, "onDeleteTroopMember,memberListForCard.size = " + this.a.e.size());
    }
    this.a.a(this.a.e);
  }
  
  public void onOIDB0XA80_0_Ret(boolean paramBoolean, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    if ((paramString1 == null) || (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin == null) || (!paramString1.equals(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin))) {}
    while (paramInt2 != 512) {
      return;
    }
    if (paramBoolean)
    {
      TroopStatusUtil.a(this.a.app, this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo);
      return;
    }
    ChatSettingForTroop.b(this.a);
  }
  
  public void onTroopFileRedDotForTimShow(boolean paramBoolean, String paramString)
  {
    super.onTroopFileRedDotForTimShow(paramBoolean, paramString);
    ChatSettingForTroop.a(this.a);
  }
  
  public void onTroopFlagExt4Changed(boolean paramBoolean, String paramString, int paramInt)
  {
    paramInt = 0;
    if ((this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null) || (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin == null) || (!this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin.equals(paramString))) {}
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            paramString = ((TroopManager)this.a.app.getManager(QQManagerFactory.TROOP_MANAGER)).b(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
          } while (paramString == null);
          DBUtils.a(this.a.app.getCurrentUin(), this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, paramString.isTroopGameCardEnabled());
        } while (this.a.jdField_a_of_type_ArrayOfAndroidViewView == null);
        paramString = this.a.jdField_a_of_type_ArrayOfAndroidViewView[23];
      } while (paramString == null);
      paramString = (TextView)paramString.findViewById(2131377063);
    } while (paramString == null);
    paramBoolean = DBUtils.a(this.a.app.getCurrentUin(), this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, false);
    QQAppInterface localQQAppInterface = this.a.app;
    String str = this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
    if (paramBoolean) {
      paramInt = 1;
    }
    RedPointUtils.a(localQQAppInterface, str, "troop", 3, paramInt);
    TroopUtils.a(paramBoolean, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatSettingForTroop.1
 * JD-Core Version:    0.7.0.1
 */