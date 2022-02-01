package com.tencent.mobileqq.activity;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopBusinessObserver;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.relationx.addFrd.AddFrdHelper;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import tencent.im.oidb.cmd0x406.cmd0x406.GroupFeeMember;
import tencent.im.oidb.cmd0x899.oidb_0x899.memberlist;
import tencent.im.oidb.cmd0xa2a.oidb_0xa2a.UserInfo;

class TroopMemberListActivity$41
  extends TroopBusinessObserver
{
  TroopMemberListActivity$41(TroopMemberListActivity paramTroopMemberListActivity) {}
  
  public void onDelRobotByWeb(String paramString1, String paramString2, String paramString3)
  {
    if ((paramString1 == null) || (this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin == null) || (!paramString1.equals(this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin))) {
      return;
    }
    this.a.a(paramString2);
    this.a.jdField_a_of_type_AndroidOsHandler.sendMessage(this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage(9));
  }
  
  public void onDeleteTroopMember(boolean paramBoolean, int paramInt, ArrayList<String> paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopMemberListActivityget_troop_member", 2, "onDeleteTroopMember, isSuccess:" + paramBoolean + " errorCode:" + paramInt);
    }
    if (paramBoolean)
    {
      if ((paramArrayList != null) && (paramArrayList.size() > 0))
      {
        this.a.l = true;
        Iterator localIterator = paramArrayList.iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          this.a.a(str);
        }
        if (this.a.d == 15) {
          TroopMemberListActivity.a(this.a, paramArrayList);
        }
        this.a.jdField_a_of_type_AndroidOsHandler.sendMessage(this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage(6));
      }
      return;
    }
    if (paramInt == 2)
    {
      this.a.jdField_a_of_type_AndroidOsHandler.sendMessage(this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage(15));
      return;
    }
    this.a.jdField_a_of_type_AndroidOsHandler.sendMessage(this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage(7));
  }
  
  public void onGetAllGameOnlineMemberList(boolean paramBoolean, String paramString, List<String> paramList)
  {
    if ((paramBoolean) && (TextUtils.equals(paramString, this.a.jdField_b_of_type_JavaLangString)) && (this.a.m == 5) && (paramList != null)) {
      ThreadManager.getUIHandler().post(new TroopMemberListActivity.41.6(this, paramList));
    }
  }
  
  public void onGetAllOnlineMemberList(boolean paramBoolean, String paramString, List<String> paramList)
  {
    if ((paramBoolean) && (TextUtils.equals(paramString, this.a.jdField_b_of_type_JavaLangString)) && (this.a.m == 1) && (paramList != null)) {
      ThreadManager.getUIHandler().post(new TroopMemberListActivity.41.5(this, paramList));
    }
  }
  
  public void onGetAllStarLeagueMembers(boolean paramBoolean, String paramString, List<oidb_0xa2a.UserInfo> paramList)
  {
    if ((paramBoolean) && (TextUtils.equals(paramString, this.a.jdField_b_of_type_JavaLangString)) && (this.a.m == 8) && (paramList != null)) {
      ThreadManager.getUIHandler().post(new TroopMemberListActivity.41.7(this, paramList));
    }
  }
  
  public void onGetAtAllRemianCountInfo(boolean paramBoolean1, String paramString1, boolean paramBoolean2, String paramString2, String paramString3, boolean paramBoolean3)
  {
    this.a.runOnUiThread(new TroopMemberListActivity.41.1(this, paramBoolean1, paramString1, paramBoolean2, paramString2, paramString3, paramBoolean3));
  }
  
  public void onGetTroopFeeMemberList(boolean paramBoolean, List<cmd0x406.GroupFeeMember> paramList)
  {
    if (!paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopMemberListActivityget_troop_member.troop.troop_fee", 2, "onGetTroopFeeMemberList : isSuccess=" + paramBoolean);
      }
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      cmd0x406.GroupFeeMember localGroupFeeMember = (cmd0x406.GroupFeeMember)localIterator.next();
      TroopMemberListActivity.ATroopMember localATroopMember = new TroopMemberListActivity.ATroopMember();
      localATroopMember.a = (localGroupFeeMember.uint64_uin.get() + "");
      localATroopMember.jdField_b_of_type_JavaLangString = localGroupFeeMember.string_nick_name.get();
      if (this.a.jdField_a_of_type_ComTencentMobileqqRelationxAddFrdAddFrdHelper != null) {
        this.a.jdField_a_of_type_ComTencentMobileqqRelationxAddFrdAddFrdHelper.a(localATroopMember);
      }
      localArrayList.add(localATroopMember);
    }
    this.a.c = paramList.size();
    this.a.jdField_a_of_type_AndroidOsHandler.sendMessage(this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage(1, new Object[] { localArrayList }));
  }
  
  public void onOIDB0X899_0_Ret(boolean paramBoolean, long paramLong1, int paramInt1, List<oidb_0x899.memberlist> paramList, long paramLong2, int paramInt2, String paramString)
  {
    if (!Utils.a(String.valueOf(paramLong1), this.a.jdField_b_of_type_JavaLangString)) {}
    do
    {
      return;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder(150);
        localStringBuilder.append("onOIDB0X899_0_Ret").append("| isSuccess = ").append(paramBoolean).append("| troopuin = ").append(paramLong1).append("| nFlag = ").append(paramInt1).append("| strErorMsg = ").append(paramString);
        QLog.i("TroopMemberListActivityget_troop_member", 2, localStringBuilder.toString());
      }
      if ((paramInt1 == 1) && (paramBoolean)) {
        ThreadManager.post(new TroopMemberListActivity.41.3(this, paramList), 5, null, true);
      }
    } while ((paramInt1 != 2) || (!paramBoolean));
    ThreadManager.post(new TroopMemberListActivity.41.4(this, paramList), 8, null, true);
  }
  
  public void onOIDB0X899_1_Ret(boolean paramBoolean, long paramLong1, int paramInt1, List<oidb_0x899.memberlist> paramList, long paramLong2, int paramInt2, String paramString)
  {
    super.onOIDB0X899_1_Ret(paramBoolean, paramLong1, paramInt1, paramList, paramLong2, paramInt2, paramString);
    if (QLog.isColorLevel()) {
      QLog.d("TroopMemberListActivityget_troop_member", 2, "onOIDB0X899_1_Ret, isSuccess:" + paramBoolean + " returnUin:" + paramLong1 + " mTroopUin:" + this.a.jdField_b_of_type_JavaLangString + " time:" + (System.currentTimeMillis() - this.a.jdField_b_of_type_Long) / 1000L + "s");
    }
    if ((!paramBoolean) || (!this.a.jdField_b_of_type_JavaLangString.equals(Long.toString(paramLong1)))) {}
    do
    {
      return;
      this.a.getSharedPreferences("last_update_time" + this.a.app.getCurrentAccountUin(), 4).edit().putLong("key_troop_info_last_update" + this.a.jdField_b_of_type_JavaLangString, System.currentTimeMillis()).commit();
    } while (this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo == null);
    paramString = this.a;
    if ((this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo != null) && (this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.isHomeworkTroop()))
    {
      paramBoolean = true;
      paramString.jdField_b_of_type_Boolean = paramBoolean;
      if (this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopowneruin != null) {
        this.a.e = this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopowneruin;
      }
      this.a.f = TroopUtils.a(this.a.app, this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo, paramList, false);
      paramList = this.a;
      if ((!this.a.app.getCurrentAccountUin().equals(this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopowneruin)) && ((this.a.f == null) || (!this.a.f.contains(this.a.app.getCurrentAccountUin())))) {
        break label457;
      }
      paramBoolean = true;
      label379:
      paramList.jdField_a_of_type_Boolean = paramBoolean;
      if ((this.a.e == null) || (!this.a.e.equals(this.a.app.getCurrentAccountUin()))) {
        break label462;
      }
    }
    for (this.a.n = "0";; this.a.n = "1") {
      label457:
      label462:
      do
      {
        this.a.jdField_a_of_type_AndroidOsHandler.sendMessage(this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage(9));
        return;
        paramBoolean = false;
        break;
        paramBoolean = false;
        break label379;
      } while ((this.a.f == null) || (!this.a.f.contains(this.a.app.getCurrentAccountUin())));
    }
  }
  
  public void onUniqueTitleChanged(String paramString1, String paramString2, String paramString3)
  {
    if (!this.a.jdField_b_of_type_JavaLangString.equals(paramString1)) {
      return;
    }
    ThreadManager.post(new TroopMemberListActivity.41.2(this, paramString2), 8, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopMemberListActivity.41
 * JD-Core Version:    0.7.0.1
 */