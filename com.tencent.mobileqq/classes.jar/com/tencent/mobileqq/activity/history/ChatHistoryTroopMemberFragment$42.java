package com.tencent.mobileqq.activity.history;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.history.helper.TroopMemberAddFrdHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopBusinessObserver;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
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

class ChatHistoryTroopMemberFragment$42
  extends TroopBusinessObserver
{
  ChatHistoryTroopMemberFragment$42(ChatHistoryTroopMemberFragment paramChatHistoryTroopMemberFragment) {}
  
  public void onDelRobotByWeb(String paramString1, String paramString2, String paramString3)
  {
    if ((paramString1 == null) || (this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin == null) || (!paramString1.equals(this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin))) {
      return;
    }
    this.a.a(paramString2);
    this.a.jdField_b_of_type_AndroidOsHandler.sendMessage(this.a.jdField_b_of_type_AndroidOsHandler.obtainMessage(9));
  }
  
  public void onDeleteTroopMember(boolean paramBoolean, int paramInt, ArrayList<String> paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.history.BaseFragment", 2, "onDeleteTroopMember, isSuccess:" + paramBoolean + " errorCode:" + paramInt);
    }
    if (paramBoolean)
    {
      if ((paramArrayList != null) && (paramArrayList.size() > 0))
      {
        this.a.jdField_o_of_type_Boolean = true;
        Iterator localIterator = paramArrayList.iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          this.a.a(str);
        }
        if (this.a.jdField_d_of_type_Int == 15) {
          ChatHistoryTroopMemberFragment.a(this.a, paramArrayList);
        }
        this.a.jdField_b_of_type_AndroidOsHandler.sendMessage(this.a.jdField_b_of_type_AndroidOsHandler.obtainMessage(6));
      }
      return;
    }
    if (paramInt == 2)
    {
      this.a.jdField_b_of_type_AndroidOsHandler.sendMessage(this.a.jdField_b_of_type_AndroidOsHandler.obtainMessage(15));
      return;
    }
    this.a.jdField_b_of_type_AndroidOsHandler.sendMessage(this.a.jdField_b_of_type_AndroidOsHandler.obtainMessage(7));
  }
  
  public void onGetAllOnlineMemberList(boolean paramBoolean, String paramString, List<String> paramList)
  {
    if ((paramBoolean) && (TextUtils.equals(paramString, this.a.jdField_c_of_type_JavaLangString)) && (this.a.m == 1) && (paramList != null)) {
      ThreadManager.getUIHandler().post(new ChatHistoryTroopMemberFragment.42.5(this, paramList));
    }
  }
  
  public void onGetAllStarLeagueMembers(boolean paramBoolean, String paramString, List<oidb_0xa2a.UserInfo> paramList)
  {
    if ((paramBoolean) && (TextUtils.equals(paramString, this.a.jdField_c_of_type_JavaLangString)) && (this.a.m == 8) && (paramList != null)) {
      ThreadManager.getUIHandler().post(new ChatHistoryTroopMemberFragment.42.6(this, paramList));
    }
  }
  
  public void onGetAtAllRemianCountInfo(boolean paramBoolean1, String paramString1, boolean paramBoolean2, String paramString2, String paramString3, boolean paramBoolean3)
  {
    this.a.getActivity().runOnUiThread(new ChatHistoryTroopMemberFragment.42.1(this, paramBoolean1, paramString1, paramBoolean2, paramString2, paramString3, paramBoolean3));
  }
  
  public void onGetTroopFeeMemberList(boolean paramBoolean, List<cmd0x406.GroupFeeMember> paramList)
  {
    if (!paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.history.BaseFragment.troop.troop_fee", 2, "onGetTroopFeeMemberList : isSuccess=" + paramBoolean);
      }
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      cmd0x406.GroupFeeMember localGroupFeeMember = (cmd0x406.GroupFeeMember)localIterator.next();
      ChatHistoryTroopMemberFragment.ATroopMember localATroopMember = new ChatHistoryTroopMemberFragment.ATroopMember();
      localATroopMember.a = (localGroupFeeMember.uint64_uin.get() + "");
      localATroopMember.b = localGroupFeeMember.string_nick_name.get();
      if (this.a.jdField_a_of_type_ComTencentMobileqqActivityHistoryHelperTroopMemberAddFrdHelper != null) {
        this.a.jdField_a_of_type_ComTencentMobileqqActivityHistoryHelperTroopMemberAddFrdHelper.a(localATroopMember);
      }
      localArrayList.add(localATroopMember);
    }
    this.a.jdField_c_of_type_Int = paramList.size();
    this.a.jdField_b_of_type_AndroidOsHandler.sendMessage(this.a.jdField_b_of_type_AndroidOsHandler.obtainMessage(1, new Object[] { localArrayList }));
  }
  
  public void onOIDB0X899_0_Ret(boolean paramBoolean, long paramLong1, int paramInt1, List<oidb_0x899.memberlist> paramList, long paramLong2, int paramInt2, String paramString)
  {
    if (!Utils.a(String.valueOf(paramLong1), this.a.jdField_c_of_type_JavaLangString)) {}
    do
    {
      return;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder(150);
        localStringBuilder.append("onOIDB0X899_0_Ret").append("| isSuccess = ").append(paramBoolean).append("| troopuin = ").append(paramLong1).append("| nFlag = ").append(paramInt1).append("| strErorMsg = ").append(paramString);
        QLog.i("Q.history.BaseFragment", 2, localStringBuilder.toString());
      }
      if ((paramInt1 == 1) && (paramBoolean)) {
        ThreadManager.post(new ChatHistoryTroopMemberFragment.42.3(this, paramList), 5, null, true);
      }
    } while ((paramInt1 != 2) || (!paramBoolean));
    ThreadManager.post(new ChatHistoryTroopMemberFragment.42.4(this, paramList), 8, null, true);
  }
  
  public void onOIDB0X899_1_Ret(boolean paramBoolean, long paramLong1, int paramInt1, List<oidb_0x899.memberlist> paramList, long paramLong2, int paramInt2, String paramString)
  {
    super.onOIDB0X899_1_Ret(paramBoolean, paramLong1, paramInt1, paramList, paramLong2, paramInt2, paramString);
    if (QLog.isColorLevel()) {
      QLog.d("Q.history.BaseFragment", 2, "onOIDB0X899_1_Ret, isSuccess:" + paramBoolean + " returnUin:" + paramLong1 + " mTroopUin:" + this.a.jdField_c_of_type_JavaLangString + " time:" + (System.currentTimeMillis() - this.a.jdField_b_of_type_Long) / 1000L + "s");
    }
    if ((!paramBoolean) || (!this.a.jdField_c_of_type_JavaLangString.equals(Long.toString(paramLong1)))) {}
    do
    {
      return;
      this.a.getActivity().getSharedPreferences("last_update_time" + this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 4).edit().putLong("key_troop_info_last_update" + this.a.jdField_c_of_type_JavaLangString, System.currentTimeMillis()).commit();
    } while (this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo == null);
    paramString = this.a;
    if ((this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo != null) && (this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.isHomeworkTroop()))
    {
      paramBoolean = true;
      paramString.e = paramBoolean;
      if (this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopowneruin != null) {
        this.a.f = this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopowneruin;
      }
      this.a.g = TroopUtils.a(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo, paramList, false);
      paramList = this.a;
      if ((!this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopowneruin)) && ((this.a.g == null) || (!this.a.g.contains(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())))) {
        break label460;
      }
      paramBoolean = true;
      label382:
      paramList.jdField_d_of_type_Boolean = paramBoolean;
      if ((this.a.f == null) || (!this.a.f.equals(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))) {
        break label465;
      }
    }
    for (this.a.jdField_o_of_type_JavaLangString = "0";; this.a.jdField_o_of_type_JavaLangString = "1") {
      label460:
      label465:
      do
      {
        this.a.jdField_b_of_type_AndroidOsHandler.sendMessage(this.a.jdField_b_of_type_AndroidOsHandler.obtainMessage(9));
        return;
        paramBoolean = false;
        break;
        paramBoolean = false;
        break label382;
      } while ((this.a.g == null) || (!this.a.g.contains(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())));
    }
  }
  
  public void onUniqueTitleChanged(String paramString1, String paramString2, String paramString3)
  {
    if (!this.a.jdField_c_of_type_JavaLangString.equals(paramString1)) {
      return;
    }
    ThreadManager.post(new ChatHistoryTroopMemberFragment.42.2(this, paramString2), 8, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment.42
 * JD-Core Version:    0.7.0.1
 */