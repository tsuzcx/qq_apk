package com.tencent.mobileqq.app.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Looper;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.UniteGrayTipParam;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.TroopBatchAddFriendMgr;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import tencent.im.oidb.cmd0x777.cmd0x777.AddFrdInfo;
import tencent.im.oidb.cmd0x777.cmd0x777.ReqBody;
import tencent.im.oidb.cmd0x777.cmd0x777.RspBody;
import zwu;
import zwv;

public class BatchAddFriendData
{
  private int jdField_a_of_type_Int = 0;
  private String jdField_a_of_type_JavaLangString = null;
  private final ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private final long[] jdField_a_of_type_ArrayOfLong = new long[30];
  private int jdField_b_of_type_Int = 0;
  private String jdField_b_of_type_JavaLangString;
  private final ArrayList jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  private int jdField_c_of_type_Int = 0;
  private String jdField_c_of_type_JavaLangString = null;
  
  public static void a(Context paramContext, QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    if ((paramContext == null) || (paramQQAppInterface == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {}
    do
    {
      return;
      if (!TextUtils.isEmpty(paramString2))
      {
        Intent localIntent = new Intent(paramContext, SelectMemberActivity.class);
        localIntent.putExtra("param_from", 30);
        localIntent.putExtra("group_uin", paramString1);
        localIntent.putExtra("param_groupcode", paramString2);
        localIntent.putExtra("param_from", 30);
        localIntent.putExtra("param_subtype", 4);
        localIntent.putExtra("param_entrance", 30);
        localIntent.putExtra("param_max", 30);
        localIntent.putExtra("param_exit_animation", 1);
        paramContext.startActivity(localIntent);
        ((Activity)paramContext).overridePendingTransition(2131034132, 2131034133);
      }
      ThreadManager.post(new zwu(paramQQAppInterface, paramString1), 8, null, true);
    } while (!QLog.isDevelopLevel());
    QLog.d("BatchAddFriendData", 4, String.format(Locale.getDefault(), "onBAFTipClick troopUin: %s", new Object[] { paramString1 }));
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, String paramString, List paramList)
  {
    if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
      if (QLog.isDevelopLevel()) {
        QLog.d("BatchAddFriendData", 4, "showResult not in ui thread !");
      }
    }
    do
    {
      return;
      if ((paramActivity != null) && (paramList != null) && (paramList.size() != 0)) {
        break;
      }
    } while (!QLog.isDevelopLevel());
    if (paramActivity == null) {}
    for (paramQQAppInterface = "showResult context is null !";; paramQQAppInterface = "showResult list is null or size is zero !")
    {
      QLog.d("BatchAddFriendData", 4, paramQQAppInterface);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    int k = 0;
    int m = 0;
    int n = 0;
    Object localObject1 = paramList.iterator();
    int j = 0;
    int i = 0;
    label103:
    Object localObject2;
    for (;;)
    {
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (cmd0x777.AddFrdInfo)((Iterator)localObject1).next();
        if (localObject2 != null) {
          if (((cmd0x777.AddFrdInfo)localObject2).uint32_send_req_flag.get() == 1) {
            if (((cmd0x777.AddFrdInfo)localObject2).uint32_send_req_result.get() == 0) {
              k += 1;
            }
          }
        }
      }
    }
    for (;;)
    {
      break label103;
      m += 1;
      continue;
      if (((cmd0x777.AddFrdInfo)localObject2).uint32_send_req_flag.get() == 2)
      {
        j += 1;
        if (((cmd0x777.AddFrdInfo)localObject2).uint32_allow_type.get() == 1) {
          i += 1;
        } else if (((cmd0x777.AddFrdInfo)localObject2).uint32_allow_type.get() == 2) {
          localArrayList.add(localObject2);
        }
      }
      else
      {
        n += 1;
        continue;
        if (QLog.isDevelopLevel()) {
          QLog.d("BatchAddFriendData", 4, String.format(Locale.getDefault(), "showResult total: %s, sendOk: %s, sendFail: %s, notSend: %s, clientFail: %s, refuseAdd: %s, answerQuestion: %s", new Object[] { Integer.valueOf(paramList.size()), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(j), Integer.valueOf(n), Integer.valueOf(i), Integer.valueOf(localArrayList.size()) }));
        }
        label350:
        label371:
        cmd0x777.AddFrdInfo localAddFrdInfo;
        if (k > 0)
        {
          QQToast.a(BaseApplication.getContext(), 0, "已发送请求", 0).a();
          if (localArrayList.size() <= 0) {
            break label459;
          }
          localObject1 = null;
          localObject2 = null;
          Iterator localIterator = localArrayList.iterator();
          if (!localIterator.hasNext()) {
            break label509;
          }
          localAddFrdInfo = (cmd0x777.AddFrdInfo)localIterator.next();
          if ((localObject1 != null) && (localAddFrdInfo.uint32_send_req_result.get() <= ((cmd0x777.AddFrdInfo)localObject1).uint32_send_req_result.get())) {
            break label461;
          }
          localObject3 = localAddFrdInfo;
          paramList = (List)localObject1;
        }
        for (;;)
        {
          localObject2 = paramList;
          localObject1 = localObject3;
          break label371;
          if ((m <= 0) && (n <= 0)) {
            break label350;
          }
          QQToast.a(BaseApplication.getContext(), 0, "请求失败", 0).a();
          break label350;
          label459:
          break;
          label461:
          paramList = localAddFrdInfo;
          localObject3 = localObject1;
          if (localObject2 != null)
          {
            paramList = localAddFrdInfo;
            localObject3 = localObject1;
            if (localAddFrdInfo.uint32_send_req_result.get() <= ((cmd0x777.AddFrdInfo)localObject2).uint32_send_req_result.get())
            {
              paramList = (List)localObject2;
              localObject3 = localObject1;
            }
          }
        }
        label509:
        Object localObject3 = null;
        if ((localArrayList.size() == 1) && (localObject1 != null)) {
          paramList = ((cmd0x777.AddFrdInfo)localObject1).bytes_remark.get();
        }
        for (;;)
        {
          paramList = DialogUtil.a(paramActivity, String.format(Locale.getDefault(), "%s需要通过回答问题进行验证，请单独添加。", new Object[] { paramList }), 0, 0, null, null);
          paramList.setPositiveButton(2131433016, new zwv());
          if ((paramActivity != null) && (!paramActivity.isFinishing())) {
            paramList.show();
          }
          ReportController.b(paramQQAppInterface, "dc00899", "Grp_addFrd", "", "frd_select", "notAdd_exp", 0, 0, paramString, String.valueOf(j), "", "");
          return;
          if ((localArrayList.size() == 2) && (localObject1 != null) && (localObject2 != null))
          {
            paramList = String.format(Locale.getDefault(), "%s、%s", new Object[] { ((cmd0x777.AddFrdInfo)localObject1).bytes_remark.get(), ((cmd0x777.AddFrdInfo)localObject2).bytes_remark.get() });
          }
          else
          {
            paramList = (List)localObject3;
            if (localObject1 != null)
            {
              paramList = (List)localObject3;
              if (localObject2 != null) {
                paramList = String.format(Locale.getDefault(), "%s、%s等%s位好友", new Object[] { ((cmd0x777.AddFrdInfo)localObject1).bytes_remark.get(), ((cmd0x777.AddFrdInfo)localObject2).bytes_remark.get(), Integer.valueOf(localArrayList.size()) });
              }
            }
          }
        }
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString))) {
      if (QLog.isDevelopLevel()) {
        QLog.d("BatchAddFriendData", 4, "checkAddBAFGrayTip invalidate params!");
      }
    }
    TroopInfo localTroopInfo;
    do
    {
      return;
      localObject2 = (TroopManager)paramQQAppInterface.getManager(51);
      localTroopInfo = ((TroopManager)localObject2).a(paramString);
    } while (localTroopInfo == null);
    Object localObject1;
    if (localTroopInfo.dwLastBAFTipMsgUniSeq != 0L)
    {
      localObject1 = PreferenceManager.getDefaultSharedPreferences(paramQQAppInterface.getApp());
      l = ((SharedPreferences)localObject1).getLong(String.format(Locale.getDefault(), "%s_%s_%s", new Object[] { "sp_baf_data_check_flag", paramQQAppInterface.getCurrentAccountUin(), paramString }), 0L);
      if ((l <= 0L) || (l - System.currentTimeMillis() <= 86400000L)) {
        break label341;
      }
      paramQQAppInterface.a().b(paramString, 1, localTroopInfo.dwLastBAFTipMsgUniSeq);
      localTroopInfo.dwLastBAFTipMsgUniSeq = 0L;
      ((TroopManager)localObject2).b(localTroopInfo);
      localObject2 = String.format(Locale.getDefault(), "%s_%s_%s", new Object[] { "sp_baf_security_check_flag", paramQQAppInterface.getCurrentAccountUin(), paramString });
      ((SharedPreferences)localObject1).edit().putInt((String)localObject2, 0).apply();
    }
    label206:
    label341:
    Locale localLocale;
    for (;;)
    {
      if (a(paramQQAppInterface, paramString))
      {
        localObject1 = PreferenceManager.getDefaultSharedPreferences(paramQQAppInterface.getApp());
        int i = ((SharedPreferences)localObject1).getInt(String.format(Locale.getDefault(), "%s_%s_%s", new Object[] { "sp_baf_security_check_flag", paramQQAppInterface.getCurrentAccountUin(), paramString }), 0);
        if (i == 0)
        {
          if (QLog.isDevelopLevel()) {
            QLog.d("BatchAddFriendData", 4, "checkAddBAFGrayTip need execute security check!");
          }
          ((TroopHandler)paramQQAppInterface.a(20)).c(localTroopInfo.troopuin, localTroopInfo.troopcode);
        }
        if (i == 1) {
          break label477;
        }
        if (!QLog.isDevelopLevel()) {
          break;
        }
        QLog.d("BatchAddFriendData", 4, String.format(Locale.getDefault(), "checkAddBAFGrayTip security check fail value: %s", new Object[] { Integer.valueOf(i) }));
        return;
        localObject2 = paramQQAppInterface.a().a(localTroopInfo.troopuin, 1, localTroopInfo.dwLastBAFTipMsgUniSeq);
        if (((localObject2 == null) || (((MessageRecord)localObject2).shmsgseq == 0L)) && (QLog.isColorLevel()))
        {
          localLocale = Locale.getDefault();
          l = localTroopInfo.dwLastBAFTipMsgUniSeq;
          if (localObject2 != null) {
            break label451;
          }
          localObject1 = "null";
          label403:
          if (localObject2 != null) {
            break label464;
          }
        }
      }
    }
    label451:
    label464:
    for (Object localObject2 = "null";; localObject2 = Long.valueOf(((MessageRecord)localObject2).time))
    {
      QLog.d("BatchAddFriendData", 2, String.format(localLocale, "checkAddBAFGrayTip gray tip msg [uniseq:%s, shmsgseq: %s, time: %s]", new Object[] { Long.valueOf(l), localObject1, localObject2 }));
      break label206;
      break;
      localObject1 = Long.valueOf(((MessageRecord)localObject2).shmsgseq);
      break label403;
    }
    label477:
    long l = ((SharedPreferences)localObject1).getLong(String.format(Locale.getDefault(), "%s_%s_%s", new Object[] { "sp_baf_data_check_flag", paramQQAppInterface.getCurrentAccountUin(), paramString }), 0L);
    if ((l == 0L) || (System.currentTimeMillis() - l > 86400000L))
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("BatchAddFriendData", 4, "checkAddBAFGrayTip need execute data check!");
      }
      ((TroopHandler)paramQQAppInterface.a(20)).t(paramString);
      return;
    }
    l = ((SharedPreferences)localObject1).getLong(String.format(Locale.getDefault(), "%s_%s_%s", new Object[] { "sp_baf_data_check_flag_remark", paramQQAppInterface.getCurrentAccountUin(), paramString }), 0L);
    if ((l == 0L) || (System.currentTimeMillis() - l > 86400000L))
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("BatchAddFriendData", 4, "checkAddBAFGrayTip need execute data check! (Remark)");
      }
      new TroopBatchAddFriendMgr(paramQQAppInterface).b(paramString);
      return;
    }
    b(paramQQAppInterface, paramString);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, int paramInt, String paramString2)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString1))) {
      if (QLog.isDevelopLevel()) {
        QLog.d("BatchAddFriendData", 4, "doAddBAFGrayTip invalidate params!");
      }
    }
    TroopManager localTroopManager;
    TroopInfo localTroopInfo;
    do
    {
      return;
      localTroopManager = (TroopManager)paramQQAppInterface.getManager(51);
      localTroopInfo = localTroopManager.a(paramString1);
    } while (localTroopInfo == null);
    if ((localTroopInfo.wInsertBAFTipCount > 0) || (localTroopInfo.dwLastInsertBAFTipTime > 0L) || (localTroopInfo.dwLastBAFTipMsgUniSeq != 0L)) {
      paramQQAppInterface.a().b(paramString1, 1, localTroopInfo.dwLastBAFTipMsgUniSeq);
    }
    Object localObject = paramQQAppInterface.a().a(paramString1, 1);
    long l1;
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      l1 = ((ChatMessage)((List)localObject).get(((List)localObject).size() - 1)).shmsgseq;
      label143:
      long l2 = MessageCache.a();
      if (TextUtils.isEmpty(paramString2)) {
        break label494;
      }
      paramString2 = String.format(Locale.getDefault(), "你和群里%s等%d人还不是好友，点击添加好友。", new Object[] { paramString2, Integer.valueOf(paramInt) });
      label180:
      paramInt = paramString2.indexOf("点击添加好友");
      int i = "点击添加好友".length();
      UniteGrayTipParam localUniteGrayTipParam = new UniteGrayTipParam(paramString1, paramString1, paramString2, 1, -5020, 135178, l2);
      localUniteGrayTipParam.jdField_c_of_type_JavaLangString = paramString2;
      paramString2 = new Bundle();
      paramString2.putInt("key_action", 24);
      paramString2.putString("key_action_DATA", paramString1);
      paramString2.putString("key_a_action_DATA", localTroopInfo.troopcode);
      localUniteGrayTipParam.a(paramInt, paramInt + i, paramString2);
      localObject = new MessageForUniteGrayTip();
      ((MessageForUniteGrayTip)localObject).initGrayTipMsg(paramQQAppInterface, localUniteGrayTipParam);
      ((MessageForUniteGrayTip)localObject).isread = true;
      ((MessageForUniteGrayTip)localObject).shmsgseq = l1;
      ((MessageForUniteGrayTip)localObject).mNeedTimeStamp = true;
      ((MessageForUniteGrayTip)localObject).updateUniteGrayTipMsgData(paramQQAppInterface);
      paramQQAppInterface.a().a((MessageRecord)localObject, paramQQAppInterface.getCurrentAccountUin());
      localTroopInfo.dwLastInsertBAFTipTime = NetConnInfoCenter.getServerTime();
      localTroopInfo.wInsertBAFTipCount += 1;
      localTroopInfo.dwLastBAFTipMsgUniSeq = ((MessageForUniteGrayTip)localObject).uniseq;
      localTroopManager.b(localTroopInfo);
      if (localTroopInfo.wInsertBAFTipCount != 1) {
        break label518;
      }
    }
    label518:
    for (paramString2 = "0";; paramString2 = "1")
    {
      ReportController.b(paramQQAppInterface, "dc00899", "Grp_addFrd", "", "Grp_AIO", "greyTips_exp", 0, 0, paramString1, paramString2, "", "");
      if (!QLog.isDevelopLevel()) {
        break;
      }
      QLog.d("BatchAddFriendData", 4, String.format("doAddBAFGrayTip time: %s count: %s uniseq: %s, msgSeq: %s, shmsgseq: %s", new Object[] { Long.valueOf(localTroopInfo.dwLastInsertBAFTipTime), Integer.valueOf(localTroopInfo.wInsertBAFTipCount), Long.valueOf(localTroopInfo.dwLastBAFTipMsgUniSeq), Long.valueOf(l1), Long.valueOf(((MessageForUniteGrayTip)localObject).shmsgseq) }));
      return;
      l1 = Math.abs(new Random().nextInt());
      break label143;
      label494:
      paramString2 = String.format(Locale.getDefault(), "你和群里%d人还不是好友，点击添加好友。", new Object[] { Integer.valueOf(paramInt) });
      break label180;
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString))) {
      return false;
    }
    Object localObject = (TroopManager)paramQQAppInterface.getManager(51);
    BatchAddFriendForTroopConfig localBatchAddFriendForTroopConfig = ((TroopManager)localObject).a();
    if (localBatchAddFriendForTroopConfig.jdField_a_of_type_Int != 1) {
      return false;
    }
    localObject = ((TroopManager)localObject).a(paramString);
    if (localObject == null) {
      return false;
    }
    if (!localBatchAddFriendForTroopConfig.a((TroopInfo)localObject)) {
      return false;
    }
    if (((TroopInfo)localObject).dwCmdUinJoinTime < localBatchAddFriendForTroopConfig.jdField_a_of_type_Long)
    {
      if ((QLog.isDevelopLevel()) && (((TroopInfo)localObject).dwCmdUinJoinTime == 0L)) {
        QLog.d("BatchAddFriendData", 4, String.format(Locale.getDefault(), "checkNeedAddBAFGrayTip troop[%s] dwCmdUinJoinTime is 0!", new Object[] { paramString }));
      }
      return false;
    }
    if (TextUtils.equals(((TroopInfo)localObject).troopowneruin, paramQQAppInterface.getCurrentAccountUin())) {
      return false;
    }
    long l1 = localBatchAddFriendForTroopConfig.jdField_c_of_type_Int;
    long l2 = NetConnInfoCenter.getServerTime();
    long l3 = l2 - ((TroopInfo)localObject).dwCmdUinJoinTime;
    if ((l3 > l1 * 86400L) || (l3 < 0L))
    {
      ReportController.b(paramQQAppInterface, "dc00899", "Grp_addFrd", "", "nonGreyTip", "joinDate", 0, 0, paramString, "", String.valueOf(l3 / 86400L), "");
      return false;
    }
    if (((TroopInfo)localObject).wMemberNum > localBatchAddFriendForTroopConfig.jdField_b_of_type_Int)
    {
      ReportController.b(paramQQAppInterface, "dc00899", "Grp_addFrd", "", "nonGreyTip", "mberNum", 0, 0, paramString, "", String.valueOf(((TroopInfo)localObject).wMemberNum), "");
      return false;
    }
    if (((TroopInfo)localObject).wClickBAFTipCount != 0) {
      return false;
    }
    if (((TroopInfo)localObject).wInsertBAFTipCount >= localBatchAddFriendForTroopConfig.d) {
      return false;
    }
    if ((((TroopInfo)localObject).wInsertBAFTipCount == 0) || (((TroopInfo)localObject).dwLastInsertBAFTipTime == 0L)) {
      return true;
    }
    if (l2 - ((TroopInfo)localObject).dwLastInsertBAFTipTime > 86400L) {
      return true;
    }
    paramQQAppInterface = Calendar.getInstance();
    paramQQAppInterface.setTimeInMillis(1000L * l2);
    int i = paramQQAppInterface.get(6);
    int j = paramQQAppInterface.get(1);
    paramQQAppInterface = Calendar.getInstance();
    paramQQAppInterface.setTimeInMillis(((TroopInfo)localObject).dwLastInsertBAFTipTime * 1000L);
    int k = paramQQAppInterface.get(6);
    int m = paramQQAppInterface.get(1);
    return ((j == m) && (i > k)) || (j > m);
  }
  
  private void b(FriendListHandler paramFriendListHandler)
  {
    if (paramFriendListHandler == null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("BatchAddFriendData", 4, "sendResult friendListHandler is null ");
      }
      return;
    }
    TroopManager localTroopManager = (TroopManager)paramFriendListHandler.b.getManager(51);
    FriendsManager localFriendsManager = (FriendsManager)paramFriendListHandler.b.getManager(50);
    ArrayList localArrayList = (ArrayList)this.jdField_b_of_type_JavaUtilArrayList.clone();
    boolean bool1 = false;
    int i = 0;
    cmd0x777.AddFrdInfo localAddFrdInfo;
    label90:
    TroopMemberInfo localTroopMemberInfo;
    label160:
    int j;
    for (;;)
    {
      if (i < localArrayList.size())
      {
        localAddFrdInfo = (cmd0x777.AddFrdInfo)localArrayList.get(i);
        if (localAddFrdInfo == null)
        {
          i += 1;
        }
        else if (localAddFrdInfo.uint32_send_req_flag.get() == 2)
        {
          localTroopMemberInfo = localTroopManager.c(this.jdField_a_of_type_JavaLangString, String.valueOf(localAddFrdInfo.uint64_uin.get()));
          if (localTroopMemberInfo == null) {
            break label317;
          }
          if (!TextUtils.isEmpty(localTroopMemberInfo.troopremark))
          {
            localAddFrdInfo.bytes_remark.set(localTroopMemberInfo.troopremark);
            PBUInt32Field localPBUInt32Field = localAddFrdInfo.uint32_send_req_result;
            if (localTroopMemberInfo.commonFrdCnt != -2147483648) {
              break label308;
            }
            j = 0;
            label180:
            localPBUInt32Field.set(j);
          }
        }
        else
        {
          label186:
          if (localAddFrdInfo.uint32_send_req_flag.get() == -2147483648) {
            break label473;
          }
        }
      }
    }
    label308:
    label317:
    label473:
    for (boolean bool2 = true;; bool2 = bool1)
    {
      if (localAddFrdInfo.uint32_send_req_flag.get() == 1)
      {
        bool1 = bool2;
        if (localAddFrdInfo.uint32_send_req_result.get() == 0) {
          break label90;
        }
        localFriendsManager.a(Long.toString(localAddFrdInfo.uint64_uin.get()), false);
        bool1 = bool2;
        break label90;
        if (!TextUtils.isEmpty(localTroopMemberInfo.troopnick))
        {
          localAddFrdInfo.bytes_remark.set(localTroopMemberInfo.troopnick);
          break label160;
        }
        if (TextUtils.isEmpty(localTroopMemberInfo.friendnick)) {
          break label160;
        }
        localAddFrdInfo.bytes_remark.set(localTroopMemberInfo.friendnick);
        break label160;
        j = localTroopMemberInfo.commonFrdCnt;
        break label180;
        if (!QLog.isDevelopLevel()) {
          break label186;
        }
        QLog.d("BatchAddFriendData", 4, String.format(Locale.getDefault(), "sendResult TroopMemberInfo is null [troopUin: %s, memberUin: %s] ", new Object[] { this.jdField_a_of_type_JavaLangString, Long.valueOf(localAddFrdInfo.uint64_uin.get()) }));
        break label186;
      }
      localFriendsManager.a(Long.toString(localAddFrdInfo.uint64_uin.get()), false);
      bool1 = bool2;
      break label90;
      this.jdField_b_of_type_JavaUtilArrayList.clear();
      paramFriendListHandler.a(112, bool1, new Object[] { this.jdField_a_of_type_JavaLangString, localArrayList });
      if (!QLog.isDevelopLevel()) {
        break;
      }
      QLog.d("BatchAddFriendData", 4, String.format(Locale.getDefault(), "sendResult isSuc: %s, troop: %s, size: %s", new Object[] { Boolean.valueOf(bool1), this.jdField_a_of_type_JavaLangString, Integer.valueOf(localArrayList.size()) }));
      return;
    }
  }
  
  /* Error */
  public static void b(QQAppInterface paramQQAppInterface, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +10 -> 11
    //   4: aload_1
    //   5: invokestatic 42	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   8: ifeq +19 -> 27
    //   11: invokestatic 101	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   14: ifeq +12 -> 26
    //   17: ldc 103
    //   19: iconst_4
    //   20: ldc_w 652
    //   23: invokestatic 121	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   26: return
    //   27: aload_0
    //   28: bipush 51
    //   30: invokevirtual 273	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   33: checkcast 275	com/tencent/mobileqq/app/TroopManager
    //   36: astore 14
    //   38: aload 14
    //   40: aload_1
    //   41: invokevirtual 278	com/tencent/mobileqq/app/TroopManager:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/TroopInfo;
    //   44: astore 16
    //   46: aload 16
    //   48: ifnonnull +33 -> 81
    //   51: invokestatic 101	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   54: ifeq -28 -> 26
    //   57: ldc 103
    //   59: iconst_4
    //   60: invokestatic 109	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   63: ldc_w 654
    //   66: iconst_1
    //   67: anewarray 4	java/lang/Object
    //   70: dup
    //   71: iconst_0
    //   72: aload_1
    //   73: aastore
    //   74: invokestatic 117	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   77: invokestatic 121	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   80: return
    //   81: new 17	java/util/ArrayList
    //   84: dup
    //   85: invokespecial 18	java/util/ArrayList:<init>	()V
    //   88: astore 17
    //   90: invokestatic 659	android/os/SystemClock:elapsedRealtime	()J
    //   93: lstore 8
    //   95: aload_0
    //   96: invokevirtual 663	com/tencent/mobileqq/app/QQAppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   99: invokevirtual 669	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   102: astore 15
    //   104: aload 15
    //   106: iconst_1
    //   107: ldc_w 608
    //   110: invokevirtual 674	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   113: iconst_5
    //   114: anewarray 113	java/lang/String
    //   117: dup
    //   118: iconst_0
    //   119: ldc_w 676
    //   122: aastore
    //   123: dup
    //   124: iconst_1
    //   125: ldc_w 677
    //   128: aastore
    //   129: dup
    //   130: iconst_2
    //   131: ldc_w 679
    //   134: aastore
    //   135: dup
    //   136: iconst_3
    //   137: ldc_w 680
    //   140: aastore
    //   141: dup
    //   142: iconst_4
    //   143: ldc_w 681
    //   146: aastore
    //   147: ldc_w 683
    //   150: iconst_1
    //   151: anewarray 113	java/lang/String
    //   154: dup
    //   155: iconst_0
    //   156: aload_1
    //   157: aastore
    //   158: aconst_null
    //   159: aconst_null
    //   160: aconst_null
    //   161: aconst_null
    //   162: invokevirtual 688	com/tencent/mobileqq/persistence/EntityManager:a	(ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   165: astore 11
    //   167: aload 11
    //   169: astore 12
    //   171: aload 11
    //   173: ifnull +201 -> 374
    //   176: aload 11
    //   178: astore 12
    //   180: aload 11
    //   182: astore 10
    //   184: aload 11
    //   186: astore 13
    //   188: aload 11
    //   190: invokeinterface 693 1 0
    //   195: ifeq +179 -> 374
    //   198: aload 11
    //   200: astore 10
    //   202: aload 11
    //   204: astore 13
    //   206: new 608	com/tencent/mobileqq/data/TroopMemberInfo
    //   209: dup
    //   210: invokespecial 694	com/tencent/mobileqq/data/TroopMemberInfo:<init>	()V
    //   213: astore 12
    //   215: aload 11
    //   217: astore 10
    //   219: aload 11
    //   221: astore 13
    //   223: aload 12
    //   225: aload 11
    //   227: iconst_0
    //   228: invokeinterface 697 2 0
    //   233: putfield 699	com/tencent/mobileqq/data/TroopMemberInfo:memberuin	Ljava/lang/String;
    //   236: aload 11
    //   238: astore 10
    //   240: aload 11
    //   242: astore 13
    //   244: aload 12
    //   246: aload 11
    //   248: iconst_1
    //   249: invokeinterface 701 2 0
    //   254: putfield 617	com/tencent/mobileqq/data/TroopMemberInfo:commonFrdCnt	I
    //   257: aload 11
    //   259: astore 10
    //   261: aload 11
    //   263: astore 13
    //   265: aload 12
    //   267: aload 11
    //   269: iconst_2
    //   270: invokeinterface 697 2 0
    //   275: putfield 703	com/tencent/mobileqq/data/TroopMemberInfo:recommendRemark	Ljava/lang/String;
    //   278: aload 11
    //   280: astore 10
    //   282: aload 11
    //   284: astore 13
    //   286: aload 12
    //   288: aload 11
    //   290: iconst_3
    //   291: invokeinterface 697 2 0
    //   296: putfield 630	com/tencent/mobileqq/data/TroopMemberInfo:troopnick	Ljava/lang/String;
    //   299: aload 11
    //   301: astore 10
    //   303: aload 11
    //   305: astore 13
    //   307: aload 12
    //   309: aload 11
    //   311: iconst_4
    //   312: invokeinterface 697 2 0
    //   317: putfield 633	com/tencent/mobileqq/data/TroopMemberInfo:friendnick	Ljava/lang/String;
    //   320: aload 11
    //   322: astore 10
    //   324: aload 11
    //   326: astore 13
    //   328: aload 17
    //   330: aload 12
    //   332: invokeinterface 704 2 0
    //   337: pop
    //   338: aload 11
    //   340: astore 10
    //   342: aload 11
    //   344: astore 13
    //   346: aload 11
    //   348: invokeinterface 707 1 0
    //   353: ifne -155 -> 198
    //   356: aload 11
    //   358: astore 10
    //   360: aload 11
    //   362: astore 13
    //   364: aload 11
    //   366: invokeinterface 710 1 0
    //   371: aconst_null
    //   372: astore 12
    //   374: aload 12
    //   376: astore 10
    //   378: aload 12
    //   380: astore 13
    //   382: aload 15
    //   384: invokevirtual 712	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   387: aload 12
    //   389: astore 10
    //   391: aload 12
    //   393: astore 13
    //   395: invokestatic 101	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   398: ifeq +42 -> 440
    //   401: aload 12
    //   403: astore 10
    //   405: aload 12
    //   407: astore 13
    //   409: ldc 103
    //   411: iconst_4
    //   412: invokestatic 109	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   415: ldc_w 714
    //   418: iconst_1
    //   419: anewarray 4	java/lang/Object
    //   422: dup
    //   423: iconst_0
    //   424: invokestatic 659	android/os/SystemClock:elapsedRealtime	()J
    //   427: lload 8
    //   429: lsub
    //   430: invokestatic 385	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   433: aastore
    //   434: invokestatic 117	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   437: invokestatic 717	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   440: aload 12
    //   442: ifnull +10 -> 452
    //   445: aload 12
    //   447: invokeinterface 710 1 0
    //   452: aload_0
    //   453: invokevirtual 720	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   456: astore 19
    //   458: aload_0
    //   459: bipush 50
    //   461: invokevirtual 273	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   464: checkcast 591	com/tencent/mobileqq/app/FriendsManager
    //   467: astore 20
    //   469: aload 14
    //   471: invokevirtual 526	com/tencent/mobileqq/app/TroopManager:a	()Lcom/tencent/mobileqq/app/utils/BatchAddFriendForTroopConfig;
    //   474: astore 18
    //   476: iconst_0
    //   477: istore_2
    //   478: aconst_null
    //   479: astore 10
    //   481: aconst_null
    //   482: astore 13
    //   484: aconst_null
    //   485: astore 11
    //   487: aconst_null
    //   488: astore 12
    //   490: aload 17
    //   492: invokeinterface 145 1 0
    //   497: ifle +1151 -> 1648
    //   500: aload 17
    //   502: invokeinterface 153 1 0
    //   507: astore 21
    //   509: iconst_0
    //   510: istore 4
    //   512: iconst_0
    //   513: istore_3
    //   514: aload 21
    //   516: invokeinterface 158 1 0
    //   521: ifeq +454 -> 975
    //   524: aload 21
    //   526: invokeinterface 162 1 0
    //   531: checkcast 608	com/tencent/mobileqq/data/TroopMemberInfo
    //   534: astore 14
    //   536: aload 14
    //   538: ifnull -24 -> 514
    //   541: aload 14
    //   543: getfield 699	com/tencent/mobileqq/data/TroopMemberInfo:memberuin	Ljava/lang/String;
    //   546: invokestatic 725	com/tencent/mobileqq/util/Utils:d	(Ljava/lang/String;)Z
    //   549: ifne +137 -> 686
    //   552: iload_3
    //   553: iconst_1
    //   554: iadd
    //   555: istore_3
    //   556: goto -42 -> 514
    //   559: astore 10
    //   561: invokestatic 101	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   564: ifeq -112 -> 452
    //   567: ldc 103
    //   569: iconst_4
    //   570: ldc_w 727
    //   573: aload 10
    //   575: invokestatic 730	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   578: goto -126 -> 452
    //   581: astore 11
    //   583: aconst_null
    //   584: astore 13
    //   586: aload 13
    //   588: astore 10
    //   590: invokestatic 101	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   593: ifeq +18 -> 611
    //   596: aload 13
    //   598: astore 10
    //   600: ldc 103
    //   602: iconst_4
    //   603: ldc_w 727
    //   606: aload 11
    //   608: invokestatic 730	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   611: aload 13
    //   613: ifnull -161 -> 452
    //   616: aload 13
    //   618: invokeinterface 710 1 0
    //   623: goto -171 -> 452
    //   626: astore 10
    //   628: invokestatic 101	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   631: ifeq -179 -> 452
    //   634: ldc 103
    //   636: iconst_4
    //   637: ldc_w 727
    //   640: aload 10
    //   642: invokestatic 730	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   645: goto -193 -> 452
    //   648: astore_0
    //   649: aconst_null
    //   650: astore 10
    //   652: aload 10
    //   654: ifnull +10 -> 664
    //   657: aload 10
    //   659: invokeinterface 710 1 0
    //   664: aload_0
    //   665: athrow
    //   666: astore_1
    //   667: invokestatic 101	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   670: ifeq -6 -> 664
    //   673: ldc 103
    //   675: iconst_4
    //   676: ldc_w 727
    //   679: aload_1
    //   680: invokestatic 730	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   683: goto -19 -> 664
    //   686: iload 4
    //   688: istore 5
    //   690: aload 14
    //   692: getfield 617	com/tencent/mobileqq/data/TroopMemberInfo:commonFrdCnt	I
    //   695: ifle +9 -> 704
    //   698: iload 4
    //   700: iconst_1
    //   701: iadd
    //   702: istore 5
    //   704: iload_2
    //   705: istore 4
    //   707: aload 20
    //   709: aload 14
    //   711: getfield 699	com/tencent/mobileqq/data/TroopMemberInfo:memberuin	Ljava/lang/String;
    //   714: invokevirtual 732	com/tencent/mobileqq/app/FriendsManager:b	(Ljava/lang/String;)Z
    //   717: ifne +909 -> 1626
    //   720: iload_2
    //   721: istore 4
    //   723: aload 14
    //   725: getfield 699	com/tencent/mobileqq/data/TroopMemberInfo:memberuin	Ljava/lang/String;
    //   728: aload 19
    //   730: invokestatic 546	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   733: ifne +893 -> 1626
    //   736: iload_2
    //   737: iconst_1
    //   738: iadd
    //   739: istore_2
    //   740: aload 14
    //   742: getfield 703	com/tencent/mobileqq/data/TroopMemberInfo:recommendRemark	Ljava/lang/String;
    //   745: invokestatic 42	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   748: ifne +125 -> 873
    //   751: aload 14
    //   753: getfield 633	com/tencent/mobileqq/data/TroopMemberInfo:friendnick	Ljava/lang/String;
    //   756: aload 14
    //   758: getfield 735	com/tencent/mobileqq/data/TroopMemberInfo:autoremark	Ljava/lang/String;
    //   761: invokestatic 546	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   764: ifne +109 -> 873
    //   767: aload 14
    //   769: getfield 617	com/tencent/mobileqq/data/TroopMemberInfo:commonFrdCnt	I
    //   772: ifle +78 -> 850
    //   775: aload 12
    //   777: ifnull +58 -> 835
    //   780: aload 12
    //   782: getfield 617	com/tencent/mobileqq/data/TroopMemberInfo:commonFrdCnt	I
    //   785: aload 14
    //   787: getfield 617	com/tencent/mobileqq/data/TroopMemberInfo:commonFrdCnt	I
    //   790: if_icmpge +38 -> 828
    //   793: aload 13
    //   795: astore 12
    //   797: aload 10
    //   799: astore 13
    //   801: aload 14
    //   803: astore 10
    //   805: aload 13
    //   807: astore 14
    //   809: aload 12
    //   811: astore 13
    //   813: aload 10
    //   815: astore 12
    //   817: aload 14
    //   819: astore 10
    //   821: iload 5
    //   823: istore 4
    //   825: goto -311 -> 514
    //   828: aload 12
    //   830: astore 14
    //   832: goto -39 -> 793
    //   835: aload 13
    //   837: astore 12
    //   839: aload 10
    //   841: astore 13
    //   843: aload 14
    //   845: astore 10
    //   847: goto -42 -> 805
    //   850: iload_2
    //   851: istore 4
    //   853: aload 13
    //   855: ifnonnull +771 -> 1626
    //   858: aload 10
    //   860: astore 13
    //   862: aload 12
    //   864: astore 10
    //   866: aload 14
    //   868: astore 12
    //   870: goto -65 -> 805
    //   873: aload 14
    //   875: getfield 617	com/tencent/mobileqq/data/TroopMemberInfo:commonFrdCnt	I
    //   878: ifle +74 -> 952
    //   881: aload 11
    //   883: ifnull +46 -> 929
    //   886: aload 11
    //   888: getfield 617	com/tencent/mobileqq/data/TroopMemberInfo:commonFrdCnt	I
    //   891: aload 14
    //   893: getfield 617	com/tencent/mobileqq/data/TroopMemberInfo:commonFrdCnt	I
    //   896: if_icmpge +26 -> 922
    //   899: aload 10
    //   901: astore 15
    //   903: aload 12
    //   905: astore 10
    //   907: aload 14
    //   909: astore 11
    //   911: aload 13
    //   913: astore 12
    //   915: aload 15
    //   917: astore 13
    //   919: goto -114 -> 805
    //   922: aload 11
    //   924: astore 14
    //   926: goto -27 -> 899
    //   929: aload 10
    //   931: astore 15
    //   933: aload 12
    //   935: astore 10
    //   937: aload 14
    //   939: astore 11
    //   941: aload 13
    //   943: astore 12
    //   945: aload 15
    //   947: astore 13
    //   949: goto -144 -> 805
    //   952: iload_2
    //   953: istore 4
    //   955: aload 10
    //   957: ifnonnull +669 -> 1626
    //   960: aload 12
    //   962: astore 10
    //   964: aload 13
    //   966: astore 12
    //   968: aload 14
    //   970: astore 13
    //   972: goto -167 -> 805
    //   975: aload 12
    //   977: ifnull +193 -> 1170
    //   980: invokestatic 376	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   983: ifeq +33 -> 1016
    //   986: ldc 103
    //   988: iconst_2
    //   989: new 737	java/lang/StringBuilder
    //   992: dup
    //   993: invokespecial 738	java/lang/StringBuilder:<init>	()V
    //   996: ldc_w 740
    //   999: invokevirtual 744	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1002: aload 12
    //   1004: getfield 703	com/tencent/mobileqq/data/TroopMemberInfo:recommendRemark	Ljava/lang/String;
    //   1007: invokevirtual 744	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1010: invokevirtual 746	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1013: invokestatic 717	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1016: aload 12
    //   1018: getfield 703	com/tencent/mobileqq/data/TroopMemberInfo:recommendRemark	Ljava/lang/String;
    //   1021: astore 10
    //   1023: aload 16
    //   1025: getfield 559	com/tencent/mobileqq/data/TroopInfo:wMemberNum	I
    //   1028: aload 17
    //   1030: invokeinterface 145 1 0
    //   1035: iload_3
    //   1036: isub
    //   1037: invokestatic 750	java/lang/Math:max	(II)I
    //   1040: istore 5
    //   1042: aload 18
    //   1044: getfield 753	com/tencent/mobileqq/app/utils/BatchAddFriendForTroopConfig:jdField_a_of_type_Float	F
    //   1047: iload 5
    //   1049: i2f
    //   1050: fmul
    //   1051: f2i
    //   1052: istore 6
    //   1054: aload 18
    //   1056: getfield 755	com/tencent/mobileqq/app/utils/BatchAddFriendForTroopConfig:jdField_b_of_type_Float	F
    //   1059: iload 5
    //   1061: i2f
    //   1062: fmul
    //   1063: f2i
    //   1064: istore 7
    //   1066: invokestatic 101	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1069: ifeq +75 -> 1144
    //   1072: ldc 103
    //   1074: iconst_4
    //   1075: invokestatic 109	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   1078: ldc_w 757
    //   1081: bipush 7
    //   1083: anewarray 4	java/lang/Object
    //   1086: dup
    //   1087: iconst_0
    //   1088: iload 5
    //   1090: invokestatic 191	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1093: aastore
    //   1094: dup
    //   1095: iconst_1
    //   1096: iload 6
    //   1098: invokestatic 191	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1101: aastore
    //   1102: dup
    //   1103: iconst_2
    //   1104: iload 4
    //   1106: invokestatic 191	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1109: aastore
    //   1110: dup
    //   1111: iconst_3
    //   1112: iload 7
    //   1114: invokestatic 191	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1117: aastore
    //   1118: dup
    //   1119: iconst_4
    //   1120: iload_2
    //   1121: invokestatic 191	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1124: aastore
    //   1125: dup
    //   1126: iconst_5
    //   1127: iload_3
    //   1128: invokestatic 191	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1131: aastore
    //   1132: dup
    //   1133: bipush 6
    //   1135: aload 10
    //   1137: aastore
    //   1138: invokestatic 117	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1141: invokestatic 717	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1144: iload 4
    //   1146: iload 6
    //   1148: if_icmplt +311 -> 1459
    //   1151: iload_2
    //   1152: iload 7
    //   1154: if_icmplt +305 -> 1459
    //   1157: iload_2
    //   1158: ifle +301 -> 1459
    //   1161: aload_0
    //   1162: aload_1
    //   1163: iload_2
    //   1164: aload 10
    //   1166: invokestatic 759	com/tencent/mobileqq/app/utils/BatchAddFriendData:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;ILjava/lang/String;)V
    //   1169: return
    //   1170: aload 13
    //   1172: ifnull +49 -> 1221
    //   1175: invokestatic 376	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1178: ifeq +33 -> 1211
    //   1181: ldc 103
    //   1183: iconst_2
    //   1184: new 737	java/lang/StringBuilder
    //   1187: dup
    //   1188: invokespecial 738	java/lang/StringBuilder:<init>	()V
    //   1191: ldc_w 761
    //   1194: invokevirtual 744	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1197: aload 13
    //   1199: getfield 703	com/tencent/mobileqq/data/TroopMemberInfo:recommendRemark	Ljava/lang/String;
    //   1202: invokevirtual 744	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1205: invokevirtual 746	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1208: invokestatic 717	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1211: aload 13
    //   1213: getfield 703	com/tencent/mobileqq/data/TroopMemberInfo:recommendRemark	Ljava/lang/String;
    //   1216: astore 10
    //   1218: goto -195 -> 1023
    //   1221: aload 11
    //   1223: ifnull +113 -> 1336
    //   1226: aload 11
    //   1228: getfield 630	com/tencent/mobileqq/data/TroopMemberInfo:troopnick	Ljava/lang/String;
    //   1231: invokestatic 42	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1234: ifeq +92 -> 1326
    //   1237: aload 11
    //   1239: getfield 633	com/tencent/mobileqq/data/TroopMemberInfo:friendnick	Ljava/lang/String;
    //   1242: astore 10
    //   1244: aload 10
    //   1246: astore 12
    //   1248: invokestatic 376	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1251: ifeq +191 -> 1442
    //   1254: ldc 103
    //   1256: iconst_2
    //   1257: new 737	java/lang/StringBuilder
    //   1260: dup
    //   1261: invokespecial 738	java/lang/StringBuilder:<init>	()V
    //   1264: ldc_w 761
    //   1267: invokevirtual 744	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1270: aload 11
    //   1272: getfield 703	com/tencent/mobileqq/data/TroopMemberInfo:recommendRemark	Ljava/lang/String;
    //   1275: invokevirtual 744	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1278: ldc_w 763
    //   1281: invokevirtual 744	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1284: aload 11
    //   1286: getfield 633	com/tencent/mobileqq/data/TroopMemberInfo:friendnick	Ljava/lang/String;
    //   1289: invokevirtual 744	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1292: ldc_w 765
    //   1295: invokevirtual 744	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1298: aload 11
    //   1300: getfield 630	com/tencent/mobileqq/data/TroopMemberInfo:troopnick	Ljava/lang/String;
    //   1303: invokevirtual 744	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1306: ldc_w 767
    //   1309: invokevirtual 744	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1312: aload 10
    //   1314: invokevirtual 744	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1317: invokevirtual 746	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1320: invokestatic 717	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1323: goto -300 -> 1023
    //   1326: aload 11
    //   1328: getfield 630	com/tencent/mobileqq/data/TroopMemberInfo:troopnick	Ljava/lang/String;
    //   1331: astore 10
    //   1333: goto -89 -> 1244
    //   1336: aload 10
    //   1338: ifnull +281 -> 1619
    //   1341: aload 10
    //   1343: getfield 630	com/tencent/mobileqq/data/TroopMemberInfo:troopnick	Ljava/lang/String;
    //   1346: invokestatic 42	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1349: ifeq +100 -> 1449
    //   1352: aload 10
    //   1354: getfield 633	com/tencent/mobileqq/data/TroopMemberInfo:friendnick	Ljava/lang/String;
    //   1357: astore 11
    //   1359: aload 11
    //   1361: astore 12
    //   1363: invokestatic 376	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1366: ifeq +76 -> 1442
    //   1369: ldc 103
    //   1371: iconst_2
    //   1372: new 737	java/lang/StringBuilder
    //   1375: dup
    //   1376: invokespecial 738	java/lang/StringBuilder:<init>	()V
    //   1379: ldc_w 761
    //   1382: invokevirtual 744	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1385: aload 10
    //   1387: getfield 703	com/tencent/mobileqq/data/TroopMemberInfo:recommendRemark	Ljava/lang/String;
    //   1390: invokevirtual 744	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1393: ldc_w 763
    //   1396: invokevirtual 744	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1399: aload 10
    //   1401: getfield 633	com/tencent/mobileqq/data/TroopMemberInfo:friendnick	Ljava/lang/String;
    //   1404: invokevirtual 744	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1407: ldc_w 765
    //   1410: invokevirtual 744	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1413: aload 10
    //   1415: getfield 630	com/tencent/mobileqq/data/TroopMemberInfo:troopnick	Ljava/lang/String;
    //   1418: invokevirtual 744	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1421: ldc_w 767
    //   1424: invokevirtual 744	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1427: aload 11
    //   1429: invokevirtual 744	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1432: invokevirtual 746	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1435: invokestatic 717	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1438: aload 11
    //   1440: astore 12
    //   1442: aload 12
    //   1444: astore 10
    //   1446: goto -423 -> 1023
    //   1449: aload 10
    //   1451: getfield 630	com/tencent/mobileqq/data/TroopMemberInfo:troopnick	Ljava/lang/String;
    //   1454: astore 11
    //   1456: goto -97 -> 1359
    //   1459: iload 4
    //   1461: iload 6
    //   1463: if_icmpge +72 -> 1535
    //   1466: iload 5
    //   1468: ifeq +67 -> 1535
    //   1471: invokestatic 109	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   1474: ldc_w 769
    //   1477: iconst_1
    //   1478: anewarray 4	java/lang/Object
    //   1481: dup
    //   1482: iconst_0
    //   1483: iload 4
    //   1485: i2f
    //   1486: iload 5
    //   1488: i2f
    //   1489: fdiv
    //   1490: invokestatic 774	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   1493: aastore
    //   1494: invokestatic 117	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1497: astore 10
    //   1499: aload_0
    //   1500: ldc 245
    //   1502: ldc 247
    //   1504: ldc 249
    //   1506: ldc_w 551
    //   1509: ldc_w 776
    //   1512: iconst_0
    //   1513: iconst_0
    //   1514: aload_1
    //   1515: ldc 249
    //   1517: aload 10
    //   1519: iconst_0
    //   1520: aload 10
    //   1522: invokevirtual 442	java/lang/String:length	()I
    //   1525: iconst_1
    //   1526: isub
    //   1527: invokevirtual 780	java/lang/String:substring	(II)Ljava/lang/String;
    //   1530: ldc 249
    //   1532: invokestatic 261	com/tencent/mobileqq/statistics/ReportController:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1535: iload_2
    //   1536: iload 7
    //   1538: if_icmpge -1512 -> 26
    //   1541: iload 5
    //   1543: ifeq -1517 -> 26
    //   1546: invokestatic 109	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   1549: ldc_w 782
    //   1552: iconst_1
    //   1553: anewarray 4	java/lang/Object
    //   1556: dup
    //   1557: iconst_0
    //   1558: iload_2
    //   1559: i2f
    //   1560: iload 5
    //   1562: i2f
    //   1563: fdiv
    //   1564: invokestatic 774	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   1567: aastore
    //   1568: invokestatic 117	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1571: astore 10
    //   1573: aload_0
    //   1574: ldc 245
    //   1576: ldc 247
    //   1578: ldc 249
    //   1580: ldc_w 551
    //   1583: ldc_w 784
    //   1586: iconst_0
    //   1587: iconst_0
    //   1588: aload_1
    //   1589: ldc 249
    //   1591: aload 10
    //   1593: iconst_0
    //   1594: aload 10
    //   1596: invokevirtual 442	java/lang/String:length	()I
    //   1599: iconst_1
    //   1600: isub
    //   1601: invokevirtual 780	java/lang/String:substring	(II)Ljava/lang/String;
    //   1604: ldc 249
    //   1606: invokestatic 261	com/tencent/mobileqq/statistics/ReportController:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1609: return
    //   1610: astore_0
    //   1611: goto -959 -> 652
    //   1614: astore 11
    //   1616: goto -1030 -> 586
    //   1619: ldc 249
    //   1621: astore 10
    //   1623: goto -600 -> 1023
    //   1626: aload 10
    //   1628: astore 14
    //   1630: iload 4
    //   1632: istore_2
    //   1633: aload 12
    //   1635: astore 10
    //   1637: aload 13
    //   1639: astore 12
    //   1641: aload 14
    //   1643: astore 13
    //   1645: goto -840 -> 805
    //   1648: ldc 249
    //   1650: astore 10
    //   1652: iconst_0
    //   1653: istore_2
    //   1654: iconst_0
    //   1655: istore 4
    //   1657: iconst_0
    //   1658: istore_3
    //   1659: goto -636 -> 1023
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1662	0	paramQQAppInterface	QQAppInterface
    //   0	1662	1	paramString	String
    //   477	1177	2	i	int
    //   513	1146	3	j	int
    //   510	1146	4	k	int
    //   688	873	5	m	int
    //   1052	412	6	n	int
    //   1064	475	7	i1	int
    //   93	335	8	l	long
    //   182	298	10	localObject1	Object
    //   559	15	10	localThrowable1	Throwable
    //   588	11	10	localObject2	Object
    //   626	15	10	localThrowable2	Throwable
    //   650	1001	10	localObject3	Object
    //   165	321	11	localCursor	android.database.Cursor
    //   581	306	11	localThrowable3	Throwable
    //   909	546	11	localObject4	Object
    //   1614	1	11	localThrowable4	Throwable
    //   169	1471	12	localObject5	Object
    //   186	1458	13	localObject6	Object
    //   36	1606	14	localObject7	Object
    //   102	844	15	localObject8	Object
    //   44	980	16	localTroopInfo	TroopInfo
    //   88	941	17	localArrayList	ArrayList
    //   474	581	18	localBatchAddFriendForTroopConfig	BatchAddFriendForTroopConfig
    //   456	273	19	str	String
    //   467	241	20	localFriendsManager	FriendsManager
    //   507	18	21	localIterator	Iterator
    // Exception table:
    //   from	to	target	type
    //   445	452	559	java/lang/Throwable
    //   90	167	581	java/lang/Throwable
    //   616	623	626	java/lang/Throwable
    //   90	167	648	finally
    //   657	664	666	java/lang/Throwable
    //   188	198	1610	finally
    //   206	215	1610	finally
    //   223	236	1610	finally
    //   244	257	1610	finally
    //   265	278	1610	finally
    //   286	299	1610	finally
    //   307	320	1610	finally
    //   328	338	1610	finally
    //   346	356	1610	finally
    //   364	371	1610	finally
    //   382	387	1610	finally
    //   395	401	1610	finally
    //   409	440	1610	finally
    //   590	596	1610	finally
    //   600	611	1610	finally
    //   188	198	1614	java/lang/Throwable
    //   206	215	1614	java/lang/Throwable
    //   223	236	1614	java/lang/Throwable
    //   244	257	1614	java/lang/Throwable
    //   265	278	1614	java/lang/Throwable
    //   286	299	1614	java/lang/Throwable
    //   307	320	1614	java/lang/Throwable
    //   328	338	1614	java/lang/Throwable
    //   346	356	1614	java/lang/Throwable
    //   364	371	1614	java/lang/Throwable
    //   382	387	1614	java/lang/Throwable
    //   395	401	1614	java/lang/Throwable
    //   409	440	1614	java/lang/Throwable
  }
  
  public void a(FriendListHandler paramFriendListHandler)
  {
    if (paramFriendListHandler == null) {}
    for (;;)
    {
      try
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("BatchAddFriendData", 4, "doSendBatchAddFriendForTroopMember friendListHandler is null ");
        }
        return;
      }
      finally {}
      Object localObject = (FriendsManager)paramFriendListHandler.b.getManager(50);
      this.jdField_a_of_type_Int = Math.min(this.jdField_a_of_type_JavaUtilArrayList.size(), this.jdField_a_of_type_ArrayOfLong.length);
      int i = this.jdField_a_of_type_Int;
      if (i > 0)
      {
        long l1 = 0L;
        try
        {
          long l2 = Long.parseLong(this.jdField_b_of_type_JavaLangString);
          l1 = l2;
        }
        catch (Throwable localThrowable)
        {
          cmd0x777.ReqBody localReqBody;
          localThrowable.printStackTrace();
          continue;
        }
        localReqBody = new cmd0x777.ReqBody();
        localReqBody.uint64_group_uin.set(l1);
        localReqBody.bytes_msg.set(this.jdField_c_of_type_JavaLangString);
        localReqBody.uint32_source_id.set(this.jdField_b_of_type_Int);
        localReqBody.uint32_sub_source_id.set(this.jdField_c_of_type_Int);
        i = this.jdField_a_of_type_Int - 1;
        if (i >= 0)
        {
          l1 = ((Long)this.jdField_a_of_type_JavaUtilArrayList.remove(i)).longValue();
          this.jdField_a_of_type_ArrayOfLong[i] = l1;
          localReqBody.rpt_uint64_uin.add(Long.valueOf(l1));
          ((FriendsManager)localObject).a(Long.toString(l1), true);
          i -= 1;
        }
        else
        {
          localObject = paramFriendListHandler.a("OidbSvc.0x777", 1911, 1, localThrowable.toByteArray());
          ((ToServiceMsg)localObject).extraData.putLongArray("send_uin_array", this.jdField_a_of_type_ArrayOfLong);
          paramFriendListHandler.b((ToServiceMsg)localObject);
          if (QLog.isDevelopLevel()) {
            QLog.d("BatchAddFriendData", 4, String.format(Locale.getDefault(), "doSendBatchAddFriendForTroopMember sending: %s pending: %s", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(this.jdField_a_of_type_JavaUtilArrayList.size()) }));
          }
        }
      }
      else
      {
        b(paramFriendListHandler);
      }
    }
  }
  
  public void a(FriendListHandler paramFriendListHandler, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int j = 0;
    if (paramFriendListHandler == null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("BatchAddFriendData", 4, "handleAddBatchTroopMembers friendListHandler is null ");
      }
      return;
    }
    paramToServiceMsg = paramToServiceMsg.extraData.getLongArray("send_uin_array");
    int i;
    if (this.jdField_a_of_type_Int <= 0) {
      i = 0;
    }
    for (;;)
    {
      if (i == 0)
      {
        if (!QLog.isDevelopLevel()) {
          break;
        }
        QLog.d("BatchAddFriendData", 4, "handleAddBatchTroopMembers is not cur sending resp!");
        return;
        if ((paramToServiceMsg == null) || (paramToServiceMsg.length < this.jdField_a_of_type_Int))
        {
          i = 0;
          continue;
        }
        i = 0;
        for (;;)
        {
          if (i >= this.jdField_a_of_type_Int) {
            break label376;
          }
          if (paramToServiceMsg[i] != this.jdField_a_of_type_ArrayOfLong[i])
          {
            i = 0;
            break;
          }
          i += 1;
        }
      }
      int k = this.jdField_a_of_type_Int;
      paramToServiceMsg = new cmd0x777.RspBody();
      int m = FriendListHandler.a(paramFromServiceMsg, paramObject, paramToServiceMsg);
      if (m == 0)
      {
        paramToServiceMsg = paramToServiceMsg.rpt_add_frd_info.get();
        this.jdField_a_of_type_Int = 0;
        if ((paramToServiceMsg != null) && (paramToServiceMsg.size() > 0)) {
          this.jdField_b_of_type_JavaUtilArrayList.addAll(paramToServiceMsg);
        }
        if (QLog.isDevelopLevel())
        {
          paramFromServiceMsg = Locale.getDefault();
          if (paramToServiceMsg != null) {
            break label359;
          }
        }
      }
      label359:
      for (i = j;; i = paramToServiceMsg.size())
      {
        QLog.d("BatchAddFriendData", 4, String.format(paramFromServiceMsg, "handleAddBatchTroopMembers result: %s sending: %s, cur:%s  total: %s pending: %s", new Object[] { Integer.valueOf(m), Integer.valueOf(k), Integer.valueOf(i), Integer.valueOf(this.jdField_b_of_type_JavaUtilArrayList.size()), Integer.valueOf(this.jdField_a_of_type_JavaUtilArrayList.size()) }));
        if (this.jdField_a_of_type_JavaUtilArrayList.size() <= 0) {
          break label370;
        }
        a(paramFriendListHandler);
        return;
        paramFromServiceMsg = new ArrayList();
        i = 0;
        for (;;)
        {
          paramToServiceMsg = paramFromServiceMsg;
          if (i >= k) {
            break;
          }
          paramToServiceMsg = new cmd0x777.AddFrdInfo();
          paramToServiceMsg.uint64_uin.set(this.jdField_a_of_type_ArrayOfLong[i]);
          paramToServiceMsg.uint32_send_req_flag.set(-2147483648);
          paramFromServiceMsg.add(paramToServiceMsg);
          i += 1;
        }
      }
      label370:
      b(paramFriendListHandler);
      return;
      label376:
      i = 1;
    }
  }
  
  public boolean a(String paramString1, String paramString2, String paramString3, List paramList, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if ((paramList == null) || (paramList.isEmpty()))
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("BatchAddFriendData", 4, "init uinList is null or empty!");
      }
      return false;
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_b_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_Int = 0;
    }
    if ((this.jdField_a_of_type_JavaUtilArrayList.size() > 0) || (this.jdField_b_of_type_JavaUtilArrayList.size() > 0) || (this.jdField_a_of_type_Int > 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("BatchAddFriendData", 4, String.format(Locale.getDefault(), "init isSending pending: %s result: %s curSending: ", new Object[] { Integer.valueOf(this.jdField_a_of_type_JavaUtilArrayList.size()), Integer.valueOf(this.jdField_b_of_type_JavaUtilArrayList.size()), Integer.valueOf(this.jdField_a_of_type_Int) }));
      }
      return false;
    }
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_c_of_type_JavaLangString = paramString3;
    this.jdField_b_of_type_Int = paramInt1;
    this.jdField_c_of_type_Int = paramInt2;
    paramString1 = paramList.iterator();
    while (paramString1.hasNext())
    {
      paramString2 = (String)paramString1.next();
      if ((paramString2 != null) && (!paramString2.isEmpty())) {
        try
        {
          long l = Long.parseLong(paramString2);
          this.jdField_a_of_type_JavaUtilArrayList.add(Long.valueOf(l));
        }
        catch (Throwable paramString2)
        {
          paramString2.printStackTrace();
        }
      }
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("BatchAddFriendData", 4, String.format(Locale.getDefault(), "init pending: %s, troopuin: %s, troopcode: %s, sourceId: %s, subSourceId: %s, msg: %s", new Object[] { Integer.valueOf(this.jdField_a_of_type_JavaUtilArrayList.size()), this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, Integer.valueOf(this.jdField_b_of_type_Int), Integer.valueOf(this.jdField_c_of_type_Int), this.jdField_c_of_type_JavaLangString }));
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.utils.BatchAddFriendData
 * JD-Core Version:    0.7.0.1
 */