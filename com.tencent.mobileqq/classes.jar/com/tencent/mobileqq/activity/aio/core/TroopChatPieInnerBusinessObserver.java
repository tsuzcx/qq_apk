package com.tencent.mobileqq.activity.aio.core;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.biz.troopgift.AIOGiftPanelContainer;
import com.tencent.biz.troopgift.TroopGiftPanel;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.coreui.pluspanel.PlusPanel;
import com.tencent.mobileqq.activity.aio.helper.AVGameHelper;
import com.tencent.mobileqq.activity.aio.helper.ChatPieTipsBarHelper;
import com.tencent.mobileqq.activity.aio.helper.MultiFavoriteHelper;
import com.tencent.mobileqq.activity.aio.helper.MultiForwardHelper;
import com.tencent.mobileqq.activity.aio.helper.TroopAddFriendTipsHelper;
import com.tencent.mobileqq.activity.aio.helper.TroopBlockDialogHelper;
import com.tencent.mobileqq.activity.aio.panel.PanelManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopBusinessObserver;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.TroopAIONotifyItem;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.studyroom.StudyRoomManager;
import com.tencent.mobileqq.troop.data.TroopAioTips;
import com.tencent.mobileqq.troop.enterEffect.TroopEnterEffectController;
import com.tencent.mobileqq.troop.enterEffect.TroopEnterEffectController.TroopEnterEffectData;
import com.tencent.mobileqq.troop.groupclass.TroopClassControllerManager;
import com.tencent.mobileqq.troop.homework.recite.utils.SoLibraryChecker;
import com.tencent.mobileqq.troop.logic.HomeworkTroopController;
import com.tencent.mobileqq.troop.utils.HWTroopUtils;
import com.tencent.mobileqq.troop.utils.TroopAioNotifyManager;
import com.tencent.mobileqq.troop.utils.TroopBatchAddFriendMgr;
import com.tencent.mobileqq.troop.utils.TroopRewardMgr;
import com.tencent.mobileqq.troopAddFrd.Scene;
import com.tencent.mobileqq.troopinfo.TroopUnreadMsgInfo;
import com.tencent.mobileqq.trooponline.TroopOnlineMemberBar;
import com.tencent.mobileqq.trooponline.data.TroopOnlineMemberManager;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.os.MqqHandler;
import tencent.im.oidb.cmd0x899.oidb_0x899.memberlist;
import tencent.im.oidb.inner.cmd0xca05.cmd0xca05.Result;

public class TroopChatPieInnerBusinessObserver
  extends TroopBusinessObserver
{
  private FragmentActivity jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private TroopChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  TroopChatPieInnerBusinessObserver(TroopChatPie paramTroopChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie = paramTroopChatPie;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramTroopChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramTroopChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = paramTroopChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
  }
  
  private void a(TroopInfo paramTroopInfo)
  {
    if ((paramTroopInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(paramTroopInfo.troopuin)))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d = paramTroopInfo.getTroopDisplayName();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.e.setText(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
      if (AppSetting.d)
      {
        paramTroopInfo = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.e.getText().toString();
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.e.setContentDescription(paramTroopInfo);
        this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.setTitle(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.e.getText());
      }
    }
  }
  
  public void onAddTroopSuccess(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramString.equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.B();
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopChatPieInnerBusinessObserver", 2, String.format("onAddTroopSuccess, troopUin: %s", new Object[] { paramString }));
    }
  }
  
  public void onBatchTroopCardDefaultNick(boolean paramBoolean, Object paramObject)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_MqqOsMqqHandler.removeMessages(24);
    HashMap localHashMap;
    int i;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.c == null) || (!this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.c.isShowing()))
    {
      localHashMap = new HashMap();
      if ((!paramBoolean) && ((paramObject instanceof Integer))) {
        i = ((Integer)paramObject).intValue();
      }
    }
    for (;;)
    {
      localHashMap.put("result", i + "");
      localHashMap.put("netType", NetworkUtil.a(BaseApplication.getContext()) + "");
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "multiMsgNickTimeoutR", false, 30000L, 0L, localHashMap, "");
      do
      {
        return;
        if (paramBoolean) {
          break label379;
        }
        i = 1;
        break;
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.c != null) && (MultiMsgManager.a().jdField_a_of_type_Int != 2)) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.c.dismiss();
        }
        MultiMsgManager.a().b.clear();
        if ((paramBoolean) && (paramObject != null))
        {
          MultiMsgManager.a().b.putAll((Map)paramObject);
          if (QLog.isDevelopLevel()) {
            QLog.d("MultiMsg_TAG", 4, "onBatchTroopCardDefaultNick = " + paramObject);
          }
        }
        while (MultiMsgManager.a().b.size() == 0)
        {
          QQToast.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 2131698460, 0).b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
          return;
          if (QLog.isDevelopLevel()) {
            QLog.d("MultiMsg_TAG", 4, "onBatchTroopCardDefaultNick failed");
          }
        }
      } while (paramObject == null);
      if (MultiMsgManager.a().jdField_a_of_type_Int == 6)
      {
        ((MultiFavoriteHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.a(11)).a((Map)paramObject, MultiMsgManager.a().jdField_a_of_type_JavaUtilArrayList, MultiMsgManager.a().jdField_a_of_type_Int);
        return;
      }
      ((MultiForwardHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.a(1)).a((Map)paramObject, MultiMsgManager.a().jdField_a_of_type_JavaUtilArrayList, MultiMsgManager.a().jdField_a_of_type_Int);
      return;
      label379:
      i = 0;
    }
  }
  
  public void onBeKickOutTroop(String paramString)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(paramString)) && (!this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.I)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.b(1);
    }
  }
  
  public void onChangeGroupClassExt(boolean paramBoolean, String paramString, long paramLong1, long paramLong2)
  {
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.d("TroopChatPieInnerBusinessObserver", 2, new Object[] { "onChangeGroupClassExt. oldClassExt=", Long.valueOf(paramLong1), ", newClassExt=", Long.valueOf(paramLong2) });
    }
    if (paramLong2 == 32L) {
      i = 1;
    }
    if (i != 0) {
      new SoLibraryChecker(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_AndroidContentContext, "3171", "libWXVoice.so", "WXVoice").a();
    }
    if ((TextUtils.equals(paramString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (paramBoolean) && (paramLong1 != paramLong2) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_ComTencentMobileqqTroopGroupclassTroopClassControllerManager != null)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_ComTencentMobileqqTroopGroupclassTroopClassControllerManager.a(paramLong2, true, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie, paramString);
    }
  }
  
  public void onChangeTroopAIORedPoint(boolean paramBoolean1, String paramString1, String paramString2, boolean paramBoolean2)
  {
    String str;
    if (QLog.isColorLevel())
    {
      if (paramString1 == null)
      {
        str = "";
        QLog.d("TroopChatPieInnerBusinessObserver", 2, new Object[] { "onChangeTroopAIORedPoint. isSuc=", Boolean.valueOf(paramBoolean1), ", troopUin=", str, ", type = ", paramString2, ", from0x8c2=", Boolean.valueOf(paramBoolean2) });
      }
    }
    else {
      if ((paramBoolean1) && (!paramBoolean2)) {
        break label91;
      }
    }
    label91:
    while ((!TextUtils.equals(paramString1, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) || (!((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).o(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) || (!String.valueOf(1104445552).equals(paramString2)) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_ComTencentMobileqqTroopGroupclassTroopClassControllerManager == null) || (!(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_ComTencentMobileqqTroopGroupclassTroopClassControllerManager.a instanceof HomeworkTroopController)))
    {
      return;
      str = paramString1;
      break;
    }
    ((HomeworkTroopController)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_ComTencentMobileqqTroopGroupclassTroopClassControllerManager.a).a(false, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie);
  }
  
  public void onCleanOnlineMemberList(boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (paramBoolean2)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.by();
    }
  }
  
  public void onClearTroopAppRedPoint(Boolean paramBoolean, ArrayList<Integer> paramArrayList, List<cmd0xca05.Result> paramList)
  {
    paramArrayList = (PlusPanel)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelManager.b(8);
    if ((paramArrayList != null) && (paramBoolean.booleanValue())) {
      paramArrayList.a();
    }
  }
  
  public void onGenNewTroopName(String paramString1, String paramString2)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(paramString1)))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d = paramString2;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.e.setText(paramString2);
      if (AppSetting.d)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.e.setContentDescription(paramString2);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.a().setTitle(paramString2);
      }
    }
  }
  
  public void onGetAnonyChatNick(boolean paramBoolean, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString3, String paramString4)
  {
    if (paramBoolean)
    {
      if (paramInt4 == 0)
      {
        AnonymousChatHelper.a().a(paramString1, paramInt2, paramInt1, paramString2, paramInt3, null, paramString4);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_MqqOsMqqHandler.postDelayed(new TroopChatPieInnerBusinessObserver.1(this), 500L);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.a(3, paramString3);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.a(1, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131690096));
  }
  
  public void onGetHomeworkSurvey(boolean paramBoolean, String paramString)
  {
    if (TextUtils.equals(paramString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.bA();
    }
  }
  
  public void onGetHomeworkTab(String paramString)
  {
    int i = 0;
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getContext().getSharedPreferences("mobileQQ", 0);
    boolean bool = localSharedPreferences.getBoolean("HomeworkIcon_" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, false);
    if (!TextUtils.isEmpty(paramString)) {
      i = 1;
    }
    if (((bool) && (i == 0)) || ((!bool) && (i != 0)))
    {
      if (i != 0) {
        break label147;
      }
      localSharedPreferences.edit().remove("HomeworkIcon_" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).commit();
    }
    for (;;)
    {
      paramString = (PlusPanel)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelManager.b(8);
      if (paramString != null) {
        paramString.a();
      }
      return;
      label147:
      localSharedPreferences.edit().putBoolean("HomeworkIcon_" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true).commit();
    }
  }
  
  public void onGetHomeworkTroopIdentity(boolean paramBoolean, String paramString1, String paramString2, int paramInt, String paramString3, String paramString4)
  {
    paramString3 = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    if ((paramBoolean) && (TextUtils.equals(paramString1, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (TextUtils.equals(paramString2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) && (paramString3.o(paramString1)))
    {
      if ((!HWTroopUtils.a(paramInt)) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_ComTencentMobileqqTroopGroupclassTroopClassControllerManager != null) && ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_ComTencentMobileqqTroopGroupclassTroopClassControllerManager.a instanceof HomeworkTroopController))) {
        ((HomeworkTroopController)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_ComTencentMobileqqTroopGroupclassTroopClassControllerManager.a).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_ComTencentMobileqqTroopGroupclassTroopClassControllerManager != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_ComTencentMobileqqTroopGroupclassTroopClassControllerManager.a(paramInt);
      }
    }
  }
  
  public void onGetTroopAioNotifyFeeds(boolean paramBoolean, String paramString, List<TroopAIONotifyItem> paramList)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty(paramString))) {
      break label27;
    }
    label27:
    while ((!this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(paramString)) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips == null)) {
      return;
    }
    boolean bool1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.a();
    boolean bool2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.d();
    if ((paramList != null) && (paramList.size() > 0))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.a(paramList);
      if ((!bool2) && (!bool1)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.f();
      }
    }
    for (int i = 1;; i = 0)
    {
      boolean bool3 = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).n(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      if ((!bool1) && (!bool2) && (i == 0) && (!bool3)) {
        ThreadManager.getUIHandler().postDelayed(new TroopChatPieInnerBusinessObserver.2(this), 500L);
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      StringBuilder localStringBuilder = new StringBuilder().append("onGetTroopAioNotifyFeeds, isSucc=").append(paramBoolean).append(", troopUin=").append(paramString).append(", size=");
      if (paramList == null) {}
      for (paramString = " ";; paramString = Integer.valueOf(paramList.size()))
      {
        QLog.d(".troop.notify_feeds.aio", 2, paramString + ", isMsgBarNeedShow=" + bool1 + ", hasMsgBar=" + bool2 + ", isQidianPrivateTroop=" + bool3);
        return;
      }
    }
  }
  
  public void onGetTroopAppList(Boolean paramBoolean)
  {
    if (((PlusPanel)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelManager.b(8) != null) && (paramBoolean.booleanValue())) {}
  }
  
  public void onModifyTroopInfo(boolean paramBoolean, long paramLong, int paramInt, TroopInfo paramTroopInfo)
  {
    if (paramBoolean) {
      a(paramTroopInfo);
    }
  }
  
  public void onNotifyUpdateTitleBtnCall(boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && (paramObject != null))
    {
      long l = ((Long)((Object[])(Object[])paramObject)[0]).longValue();
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(String.valueOf(l)))) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.v();
      }
    }
  }
  
  public void onOIDB0X899_0_Ret(boolean paramBoolean, long paramLong1, int paramInt1, List<oidb_0x899.memberlist> paramList, long paramLong2, int paramInt2, String paramString)
  {
    if (!Utils.a(String.valueOf(paramLong1), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {}
    do
    {
      return;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder(150);
        localStringBuilder.append("onOIDB0X899_0_Ret").append("| isSuccess = ").append(paramBoolean).append("| troopuin = ").append(paramLong1).append("| nFlag = ").append(paramInt1).append("| strErorMsg = ").append(paramString);
        QLog.i("TroopChatPieInnerBusinessObserver", 2, localStringBuilder.toString());
      }
    } while ((paramInt1 != 2) || (!paramBoolean));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.b(paramList);
  }
  
  public void onOIDB0XA80_0_Ret(boolean paramBoolean, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(paramString1)) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(paramString2)) && (paramInt1 == 1) && (paramInt2 == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d(".troop.closeRcvMsgTmp", 2, "onOIDB0XA80_0_Ret: cmd==1," + paramBoolean + "," + paramString1 + "," + paramString2 + "," + this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.l);
      }
      if (!paramBoolean) {
        break label177;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "AIOchat", "Get_history", 0, 0, paramString1, "", "", "");
      if (QLog.isColorLevel()) {
        QLog.d(".troop.closeRcvMsgTmp", 2, "onOIDB0XA80_0_Ret: pullRecentGroupMsg");
      }
    }
    label177:
    while (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.l <= 0) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.x(1);
    paramString1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie;
    paramString1.l -= 1;
  }
  
  public void onPassiveExit(String paramString, int paramInt)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramString.equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.B();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.v();
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopChatPieInnerBusinessObserver", 2, String.format("onPassiveExit, troopUin: %s, reason: %s", new Object[] { paramString, Integer.valueOf(paramInt) }));
    }
    paramString = (AVGameHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.a(71);
    if (paramString != null) {
      paramString.a();
    }
  }
  
  public void onPushTroopEnterEffect(TroopEnterEffectController.TroopEnterEffectData paramTroopEnterEffectData)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopChatPieInnerBusinessObserver", 2, "onPushTroopEnterEffect: troopUin = " + paramTroopEnterEffectData.b + ", data.id = " + paramTroopEnterEffectData.jdField_a_of_type_Int);
    }
    if (AnonymousChatHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopChatPieInnerBusinessObserver", 2, "onPushTroopEnterEffect: troopUin = " + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString + " isAnonymous");
      }
      return;
    }
    paramTroopEnterEffectData = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.a();
    paramTroopEnterEffectData.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    paramTroopEnterEffectData.a();
  }
  
  public void onSortedTroopAppList(Boolean paramBoolean)
  {
    PlusPanel localPlusPanel = (PlusPanel)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelManager.b(8);
    if ((localPlusPanel != null) && (paramBoolean.booleanValue())) {
      localPlusPanel.a();
    }
  }
  
  public void onTroopBatchAddFrdsReadyForTip(boolean paramBoolean, String paramString, int paramInt, List<String> paramList)
  {
    Object localObject = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getStringExtra("uin");
    QLog.i("TroopChatPieInnerBusinessObserver", 1, String.format("troopBatchAddFrd.onTroopBatchAddFrdsReadyForTip suc_troopUin_type_intentUIn=%b_%s_%d_%s", new Object[] { Boolean.valueOf(paramBoolean), paramString, Integer.valueOf(paramInt), localObject }));
    if ((paramBoolean) && (Scene.a(paramInt)) && (paramString.equalsIgnoreCase((String)localObject)))
    {
      if ((paramInt != 2) && (paramInt != 3) && (paramInt != 1) && (paramInt != 5)) {
        break label121;
      }
      paramList = (TroopAddFriendTipsHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.a(28);
      if (paramList != null) {
        paramList.a(true, paramString);
      }
    }
    for (;;)
    {
      return;
      label121:
      if ((paramInt == 4) && (paramList != null) && (paramList.size() > 0))
      {
        if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.ah)
        {
          localObject = (String)paramList.get(0);
          paramBoolean = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.a((String)localObject);
          localObject = (TroopAddFriendTipsHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.a(28);
          if (localObject != null) {
            ((TroopAddFriendTipsHelper)localObject).a(paramBoolean, paramString);
          }
        }
        while (QLog.isColorLevel())
        {
          QLog.d("TroopChatPieInnerBusinessObserver", 2, "onTroopBatchAddFrdsReadyForTip  isScrolling = " + this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.ah + ",visible = " + paramBoolean + ",targetUins = " + paramList);
          return;
          this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.h = ((String)paramList.get(0));
          paramBoolean = false;
        }
      }
    }
  }
  
  public void onTroopBlockStatusChanged(String paramString)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {}
    do
    {
      do
      {
        return;
      } while (!this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(paramString));
      if (QLog.isColorLevel()) {
        QLog.d("TroopChatPieInnerBusinessObserver", 2, String.format("onTroopBlockStatusChanged, troopUin: %s", new Object[] { this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString }));
      }
      paramString = (TroopBlockDialogHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.a(76);
    } while (paramString == null);
    paramString.b();
  }
  
  public void onTroopInfoUpdate(String paramString)
  {
    if ((paramString != null) && (paramString.equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))
    {
      paramString = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).c(paramString);
      if (paramString != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d = paramString.getTroopDisplayName();
        Intent localIntent = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent();
        localIntent.putExtra("uinname", paramString.getTroopDisplayName());
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.b(localIntent);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.bz();
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_ComTencentMobileqqTroopGroupclassTroopClassControllerManager != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_ComTencentMobileqqTroopGroupclassTroopClassControllerManager.a(paramString.dwGroupClassExt, true, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.bA();
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.bo();
        ((StudyRoomManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.STUDY_ROOM_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      }
    }
  }
  
  public void onTroopManagerFailed(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 9) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.aa)) {
      QQToast.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 1, HardCodeUtil.a(2131715124), 0).a();
    }
  }
  
  public void onTroopManagerSuccess(int paramInt1, int paramInt2, String paramString)
  {
    if ((paramInt1 == 2) || (paramInt1 == 9))
    {
      if (paramInt2 == 0)
      {
        if (QLog.isColorLevel()) {
          QLog.i("troop.credit.act", 2, "onTroopManagerSuccess, isTroopOwner =" + this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.aa);
        }
        String str = HardCodeUtil.a(2131715129);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.aa) {
          str = HardCodeUtil.a(2131715127);
        }
        QQToast.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 2, str, 0).a();
        str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin();
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.a(paramString, str);
        ((TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER)).a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      }
    }
    else {
      return;
    }
    QQToast.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 1, HardCodeUtil.a(2131715122), 0).a();
  }
  
  public void onTroopMemberUpdate()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.bz();
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer.a() != null)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer.a().b();
    }
  }
  
  public void onTroopNewFeedsAutoPullDown(boolean paramBoolean, String paramString1, String paramString2, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopChatPieInnerBusinessObserver.troop.notification_center.auto_pull_down", 2, "onTroopNewFeedsAutoPullDown, isSuc:" + paramBoolean + "troopUin" + paramString1 + ",feedsId:" + paramString2 + ",flag:" + paramInt);
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(paramString1)) {}
  }
  
  public void onTroopNewFeedsComing(boolean paramBoolean1, String paramString, boolean paramBoolean2, boolean paramBoolean3)
  {
    if ((!paramBoolean1) || (!TextUtils.equals(paramString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
      return;
    }
    Integer localInteger = ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    if ((localInteger != null) && (-1 == localInteger.intValue())) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d(".troop.notify_feeds.aio", 2, "onTroopNewFeedsComing, isSuc:" + paramBoolean1 + ", troopUin=" + paramString + ",bDeleted:" + paramBoolean2 + ", isFromPush=" + paramBoolean3 + ", hasNewNotify=" + bool);
      }
      if (paramBoolean3) {
        break;
      }
      TroopAioNotifyManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      return;
    }
  }
  
  public void onTroopRewardChangeNotify(String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(paramString1))
    {
      List localList = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a();
      int i = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getFirstVisiblePosition();
      int j = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getLastVisiblePosition();
      paramString1 = ((TroopRewardMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_REWARD_MGR)).a(paramString1, paramString2);
      if (paramString1 != null)
      {
        int k = localList.indexOf(paramString1);
        if ((k >= i) && (k <= j)) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.g(131077);
        }
      }
    }
  }
  
  public void onUpdateGameOnlineSwitchStatus(boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (paramBoolean2)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.by();
    }
  }
  
  public void onUpdateOnlineMemberList(boolean paramBoolean, String paramString1, String paramString2)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.I) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_ComTencentMobileqqTrooponlineTroopOnlineMemberBar == null)) {}
    while ((!TextUtils.equals(paramString1, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.a().jdField_a_of_type_JavaLangString)) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.P) || (ChatPieTipsBarHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie))) {
      return;
    }
    if (!paramBoolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_ComTencentMobileqqTrooponlineTroopOnlineMemberBar.a(2);
      return;
    }
    paramString2 = ((TroopOnlineMemberManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_ONLINE_MEMBER_MANAGER)).a(paramString1);
    if (!TextUtils.isEmpty(paramString2))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.b(true);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.f.setText(paramString2);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_ComTencentMobileqqTrooponlineTroopOnlineMemberBar != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_ComTencentMobileqqTrooponlineTroopOnlineMemberBar.a(paramString1);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_ComTencentMobileqqTrooponlineTroopOnlineMemberBar.a())
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_ComTencentMobileqqTrooponlineTroopOnlineMemberBar.d();
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.t(true);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_ComTencentMobileqqTrooponlineTroopOnlineMemberBar.a(0);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.t(false);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.t(false);
  }
  
  public void onUpdateOnlineMemberTips(boolean paramBoolean, String paramString1, String paramString2)
  {
    if (TextUtils.equals(paramString1, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.a().jdField_a_of_type_JavaLangString))
    {
      paramString2 = (TroopOnlineMemberManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_ONLINE_MEMBER_MANAGER);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.a(paramString1, true);
      if ((paramBoolean) && (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity != null) && (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isResume()))
      {
        long l = (paramString2.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.a().jdField_a_of_type_JavaLangString) - NetConnInfoCenter.getServerTime()) * 1000L;
        if (QLog.isColorLevel()) {
          QLog.i("TroopChatPieInnerBusinessObserver", 2, "mGetOnlineMemberTipsRunnable, delay = " + l);
        }
        ThreadManager.getSubThreadHandler().removeCallbacks(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.d);
        ThreadManager.getUIHandler().post(new TroopChatPieInnerBusinessObserver.3(this, l));
      }
    }
  }
  
  public void onUpdateTroopMiniAppEntranceRedPoint(String paramString, boolean paramBoolean) {}
  
  public void onUpdateTroopRemark(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      a(((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).b(paramString));
    }
  }
  
  public void onUpdateTroopUnreadMsg(boolean paramBoolean1, boolean paramBoolean2, List<TroopUnreadMsgInfo> paramList, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopChatPieInnerBusinessObserver", 2, new Object[] { "onUpdateTroopUnreadMsg. isSuc=", Boolean.valueOf(paramBoolean1), ", isPush=", Boolean.valueOf(paramBoolean2) });
    }
    if ((!paramBoolean1) || (paramList == null) || (paramList.isEmpty())) {}
    for (;;)
    {
      return;
      TroopManager localTroopManager = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject = (TroopUnreadMsgInfo)paramList.next();
        if (TextUtils.equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, ((TroopUnreadMsgInfo)localObject).jdField_a_of_type_JavaLangString))
        {
          if (((TroopUnreadMsgInfo)localObject).jdField_a_of_type_Long == 1104445552L)
          {
            if (QLog.isColorLevel()) {
              QLog.d("TroopChatPieInnerBusinessObserver", 2, new Object[] { "onUpdateTroopUnreadMsg homework. num=", Integer.valueOf(((TroopUnreadMsgInfo)localObject).b) });
            }
            if ((localTroopManager.o(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_ComTencentMobileqqTroopGroupclassTroopClassControllerManager != null) && ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_ComTencentMobileqqTroopGroupclassTroopClassControllerManager.a instanceof HomeworkTroopController))) {
              ((HomeworkTroopController)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_ComTencentMobileqqTroopGroupclassTroopClassControllerManager.a).a(false, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie);
            }
          }
          if (((TroopUnreadMsgInfo)localObject).jdField_a_of_type_Long == 2L)
          {
            if (QLog.isColorLevel()) {
              QLog.d("TroopChatPieInnerBusinessObserver", 2, "receive troop album  red dot, push=" + paramBoolean2 + ", num=" + ((TroopUnreadMsgInfo)localObject).b);
            }
            localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_MqqOsMqqHandler;
            TroopChatPie localTroopChatPie = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie;
            ((MqqHandler)localObject).obtainMessage(85).sendToTarget();
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.TroopChatPieInnerBusinessObserver
 * JD-Core Version:    0.7.0.1
 */