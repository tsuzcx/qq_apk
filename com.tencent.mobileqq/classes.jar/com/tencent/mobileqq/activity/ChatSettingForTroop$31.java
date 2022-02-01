package com.tencent.mobileqq.activity;

import KQQ.BatchResponse;
import KQQ.RespBatchProcess;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopBusinessObserver;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberCardInfo;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.troop.associations.AllianceItem;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.trooponline.data.TroopOnlineMemberManager;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.DBUtils;
import com.tencent.mobileqq.widget.QQProgressNotifier;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import tencent.im.oidb.cmd0x899.oidb_0x899.memberlist;
import tencent.im.oidb.cmd0xe83.oidb_0xe83.RspBody;

class ChatSettingForTroop$31
  extends TroopBusinessObserver
{
  ChatSettingForTroop$31(ChatSettingForTroop paramChatSettingForTroop) {}
  
  public void onBatchGetTroopInfoResp(boolean paramBoolean, long paramLong, RespBatchProcess paramRespBatchProcess, Bundle paramBundle)
  {
    int i = 0;
    if ((this.a.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) && (this.a.jdField_a_of_type_AndroidWidgetTextView != null)) {
      this.a.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("onBatchGetTroopInfoResp, isSucc=").append(paramBoolean).append(", mTroopInfoData IsNull=");
      if (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null)
      {
        paramBoolean = true;
        localStringBuilder = localStringBuilder.append(paramBoolean).append(", resp IsNull=");
        if (paramRespBatchProcess != null) {
          break label167;
        }
        paramBoolean = true;
        label98:
        QLog.d("Q.chatopttroop", 2, paramBoolean);
      }
    }
    else
    {
      if ((paramRespBatchProcess != null) && (paramRespBatchProcess.batch_response_list != null) && (paramRespBatchProcess.batch_response_list.size() != 0) && (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null)) {
        break label172;
      }
      if (QLog.isColorLevel()) {
        QLog.w("Q.chatopttroop", 2, "onBatchGetTroopInfoResp, return");
      }
    }
    label167:
    label172:
    label242:
    int j;
    do
    {
      do
      {
        do
        {
          return;
          paramBoolean = false;
          break;
          paramBoolean = false;
          break label98;
          if (String.valueOf(paramLong).equals(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin)) {
            break label242;
          }
        } while (!QLog.isColorLevel());
        QLog.d("Q.chatopttroop", 2, "onBatchGetTroopInfoResp  fiter resp, curTroopUin = " + this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin + ",respUin = " + paramLong);
        return;
      } while ((paramBundle == null) || (paramBundle.getInt("from", 0) != 1));
      j = paramRespBatchProcess.batch_response_list.size();
      if (i < j)
      {
        paramBundle = (BatchResponse)paramRespBatchProcess.batch_response_list.get(i);
        if ((paramBundle == null) || (paramBundle.result != 0)) {}
        for (;;)
        {
          i += 1;
          break;
          if (paramBundle.type == 1) {
            this.a.a(paramBundle);
          }
        }
      }
    } while (j <= 0);
    TroopUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo, this.a.app, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember);
    this.a.b(true);
  }
  
  public void onBatchTroopCardDefaultNick(boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && (this.a.e != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.chatopttroop", 2, "onBatchTroopCardDefaultNick,memberListForCard.size = " + this.a.e.size());
      }
      this.a.a(this.a.e);
    }
  }
  
  public void onGenNewTroopName(String paramString1, String paramString2)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo != null)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.newTroopName = this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.getNewTroopNameOrTroopName();
      this.a.e();
    }
  }
  
  public void onGetNewTroopAppList(oidb_0xe83.RspBody paramRspBody, int paramInt)
  {
    if (paramRspBody.group_id.has())
    {
      str = String.valueOf(paramRspBody.group_id.get());
      if ((this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null) && (!TextUtils.equals(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, str))) {
        if (QLog.isColorLevel()) {
          QLog.e("Q.chatopttroop", 2, "onGetNewTroopAppList troopUin not match. rsp uin=" + str + ", current uin=" + this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
        }
      }
    }
    while (!QLog.isColorLevel())
    {
      String str;
      do
      {
        return;
      } while (paramInt != 1);
      if (QLog.isColorLevel()) {
        QLog.d("raymondguo", 2, "game feed service type 1 refresh");
      }
      this.a.a(paramRspBody);
      return;
    }
    QLog.e("Q.chatopttroop", 2, "onGetNewTroopAppList group_id lost. current uin=" + this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
  }
  
  public void onGetRelatedTroopList(boolean paramBoolean, String paramString, int paramInt, long paramLong, AllianceItem paramAllianceItem)
  {
    if ((!paramBoolean) || (!TextUtils.equals(paramString, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin)) || (paramAllianceItem == null))
    {
      ChatSettingForTroop.d(this.a, 0);
      return;
    }
    ChatSettingForTroop.d(this.a, paramAllianceItem.associatedTroopCount);
  }
  
  public void onGetTroopAuthSubmitTime(boolean paramBoolean, String paramString, int paramInt)
  {
    if ((paramBoolean) && (paramString.equals(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin))) {
      this.a.i = paramInt;
    }
  }
  
  public void onGetTroopLatestMemo(boolean paramBoolean, String paramString1, String paramString2)
  {
    if ((paramBoolean) && (this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo != null) && (TextUtils.equals(paramString1, this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin)))
    {
      String str = paramString2;
      if (TextUtils.isEmpty(paramString2)) {
        str = this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.getLatestMemo();
      }
      if (QLog.isColorLevel()) {
        QLog.i("Q.chatopttroop", 2, String.format("get last memo [%s, %s]", new Object[] { paramString1, str }));
      }
      if (!TextUtils.isEmpty(str))
      {
        paramString1 = this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage();
        paramString1.what = 20;
        paramString1.obj = str;
        this.a.jdField_a_of_type_AndroidOsHandler.sendMessage(paramString1);
      }
      ChatSettingForTroop.a(this.a, str);
    }
  }
  
  public void onGetTroopTagResult(boolean paramBoolean, String paramString1, String paramString2) {}
  
  public void onModifyMemberGameCardSwitch(boolean paramBoolean, long paramLong1, long paramLong2, String paramString)
  {
    if ((this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin == null) || (!this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin.equals(String.valueOf(paramLong1))))
    {
      if (" onModifyMemberGameCardSwitch. uin doesn't match. errCode = " + paramLong2 + ", errInfo = " + paramString == null) {}
      for (paramString = "";; paramString = paramString + ", isSuccess = " + paramBoolean)
      {
        QLog.e("Q.chatopttroop", 2, paramString);
        return;
      }
    }
    if (!paramBoolean)
    {
      String str = paramString;
      if (" onModifyMemberGameCardSwitch fail. errCode = " + paramLong2 + ", errInfo = " + paramString == null) {
        str = "";
      }
      QLog.e("Q.chatopttroop", 2, str);
      QQToast.a(this.a, 1, HardCodeUtil.a(2131697402), 0).b(this.a.getTitleBarHeight());
    }
    ChatSettingForTroop.o(this.a);
  }
  
  public void onModifyTroopGameCardSwitch(boolean paramBoolean, long paramLong1, long paramLong2, String paramString)
  {
    if ((this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin == null) || (!this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin.equals(String.valueOf(paramLong1)))) {
      return;
    }
    if (!paramBoolean)
    {
      String str = paramString;
      if (" onModifyTroopGameCardSwitch fail. errCode = " + paramLong2 + ", errInfo = " + paramString == null) {
        str = "";
      }
      QLog.e("Q.chatopttroop", 2, str);
      QQToast.a(this.a, 1, HardCodeUtil.a(2131697402), 0).b(this.a.getTitleBarHeight());
    }
    ChatSettingForTroop.n(this.a);
  }
  
  public void onModifyTroopInfo(boolean paramBoolean, long paramLong, int paramInt, TroopInfo paramTroopInfo)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null) {}
    do
    {
      do
      {
        do
        {
          return;
        } while (!Utils.a(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, String.valueOf(paramLong)));
        if (QLog.isColorLevel()) {
          QLog.d("Q.chatopttroop", 2, "onModifyTroopInfo isSuccess = " + paramBoolean + ",mModifyList = " + this.a.jdField_a_of_type_JavaUtilList);
        }
        if ((this.a.jdField_a_of_type_JavaUtilList != null) && (this.a.jdField_a_of_type_JavaUtilList.contains(Integer.valueOf(paramInt))))
        {
          this.a.jdField_a_of_type_JavaUtilList.remove(Integer.valueOf(paramInt));
          if (paramTroopInfo != null) {
            this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo = paramTroopInfo;
          }
          if (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier == null) {
            this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier = new QQProgressNotifier(this.a);
          }
          if (paramBoolean)
          {
            this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a(1, this.a.getString(2131693436), 1000);
            return;
          }
          this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a(2, this.a.getString(2131693435), 1000);
          ChatSettingForTroop.b(this.a, paramInt);
          return;
        }
      } while ((!paramBoolean) || (paramTroopInfo == null));
      this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo = paramTroopInfo;
    } while ((this.a.jdField_a_of_type_JavaUtilList != null) && (this.a.jdField_a_of_type_JavaUtilList.size() != 0));
    this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.updateForTroopInfo(paramTroopInfo, this.a.app.getCurrentAccountUin());
    if (QLog.isColorLevel()) {
      QLog.d("Q.chatopttroop", 2, "onModifyTroopInfo send MSG_UPDATE_INFO msg");
    }
    this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(5);
  }
  
  public void onModifyTroopInfoPushResult(boolean paramBoolean, ArrayList<TroopMemberCardInfo> paramArrayList)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null) {}
    while ((!paramBoolean) || (paramArrayList == null)) {
      return;
    }
    this.a.a(paramArrayList);
  }
  
  public void onOIDB0X88D_1_Ret(boolean paramBoolean, long paramLong, int paramInt1, TroopInfo paramTroopInfo, int paramInt2, String paramString)
  {
    this.a.p();
    if (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null) {}
    do
    {
      do
      {
        return;
      } while (paramLong != Long.parseLong(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin));
      if (!paramBoolean) {
        break label197;
      }
      if ((paramTroopInfo.cGroupOption == 4) || (paramTroopInfo.cGroupOption == 5))
      {
        this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mStrJoinQuestion = paramTroopInfo.joinTroopQuestion;
        this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mStrJoinAnswer = paramTroopInfo.joinTroopAnswer;
      }
      if (paramTroopInfo.isOnlyTroopMemberInviteOption())
      {
        this.a.a(2131720191, 0);
        return;
      }
      this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption = ((short)(byte)paramTroopInfo.cGroupOption);
      if (this.a.isResume()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("qqBaseActivity", 2, "ChatSettingForTroop onOIDB0X88D_1_Ret return----------------");
    return;
    if ((this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isHomeworkTroop()) && (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption != 3))
    {
      ChatSettingForTroop.c(this.a, 2);
      return;
    }
    ChatSettingForTroop.a(this.a, null);
    return;
    label197:
    this.a.a(2131719023, 1);
  }
  
  public void onOIDB0X899_0_Ret(boolean paramBoolean, long paramLong1, int paramInt1, List<oidb_0x899.memberlist> paramList, long paramLong2, int paramInt2, String paramString)
  {
    super.onOIDB0X899_0_Ret(paramBoolean, paramLong1, paramInt1, paramList, paramLong2, paramInt2, paramString);
    if ((!TextUtils.equals(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, String.valueOf(paramLong1))) || (paramInt1 != 5)) {}
    do
    {
      return;
      if (paramBoolean)
      {
        ChatSettingForTroop.a(this.a, paramList);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.e("Q.chatopttroop", 2, "onOIDB0X899_0_Ret, result = " + paramInt2 + "strErrorMsg = " + paramString);
  }
  
  public void onSetTroopShowExternalStatus(boolean paramBoolean, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    if (!paramBoolean)
    {
      QQToast.a(this.a, this.a.getString(2131696175), 0).b(this.a.getTitleBarHeight());
      ChatSettingForTroop.l(this.a);
    }
  }
  
  public void onTroopFileRedDotForTimShow(boolean paramBoolean, String paramString)
  {
    if (paramBoolean)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.nNewFileMsgNum = DBUtils.a(this.a.app.getCurrentAccountUin(), "troop_file_new", this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.nUnreadFileMsgnum = 0;
      this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(8);
    }
  }
  
  public void onUpdateGameOnlineSwitchStatus(boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    if (paramBoolean1) {
      if ((paramBoolean2) && (this.a.app != null)) {
        ((TroopOnlineMemberManager)this.a.app.getManager(QQManagerFactory.TROOP_ONLINE_MEMBER_MANAGER)).a(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      }
    }
    for (;;)
    {
      ChatSettingForTroop.m(this.a);
      return;
      QQToast.a(BaseApplication.getContext(), 2131696097, 0).b(this.a.getTitleBarHeight());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatSettingForTroop.31
 * JD-Core Version:    0.7.0.1
 */