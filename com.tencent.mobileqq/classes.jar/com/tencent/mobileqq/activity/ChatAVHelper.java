package com.tencent.mobileqq.activity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.av.VideoController;
import com.tencent.av.core.VcSystemInfo;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.VideoInviteActivity;
import com.tencent.av.utils.DataReport;
import com.tencent.av.utils.PopupDialog;
import com.tencent.av.utils.UITools;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.intervideo.groupvideo.IGroupVideoManager;
import com.tencent.mobileqq.nearby.NearbyManagerHelper;
import com.tencent.mobileqq.nearby.api.INearbyProxy;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import cooperation.groupvideo.api.IGroupVideoHelper;
import java.util.Map;

public final class ChatAVHelper
{
  public static Boolean a(long paramLong, QQAppInterface paramQQAppInterface, Context paramContext, ChatActivityUtils.StartVideoListener paramStartVideoListener, ChatActivityUtils.VideoCheckFlag paramVideoCheckFlag)
  {
    DataReport.e(true, true);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("startVideoCheck, isPhoneCalling, seq[");
    ((StringBuilder)localObject).append(paramLong);
    ((StringBuilder)localObject).append("]");
    QLog.w("ChatActivityUtils", 1, ((StringBuilder)localObject).toString());
    localObject = paramContext.getString(2131893471);
    PopupDialog.a(paramContext, 230, paramContext.getString(2131893450), (String)localObject, 2131887648, 2131892267, new ChatAVHelper.1(paramStartVideoListener, paramVideoCheckFlag), null);
    DataReport.a(paramVideoCheckFlag.e);
    if (paramVideoCheckFlag.a == 1024) {
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X80049DF", "Judge_phone_calling_false", 0, 0, "", "", "", "");
    }
    return Boolean.valueOf(false);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt, BaseActivity paramBaseActivity)
  {
    Intent localIntent = new Intent(paramBaseActivity.getApplicationContext(), AVActivity.class);
    if (paramQQAppInterface.getAVNotifyCenter().u() == 1011) {
      return;
    }
    boolean bool2 = paramQQAppInterface.isVideoChatting();
    boolean bool1 = true;
    if ((bool2) && (paramQQAppInterface.getAVNotifyCenter().u() != 1) && (paramQQAppInterface.getAVNotifyCenter().u() != 3000) && (paramQQAppInterface.getAVNotifyCenter().q()) && (paramQQAppInterface.getAVNotifyCenter().p()) && (paramQQAppInterface.getAVNotifyCenter().u() != 1011) && (paramQQAppInterface.getAVNotifyCenter().u() != 21))
    {
      localIntent = new Intent(paramBaseActivity, VideoInviteActivity.class);
      localIntent.addFlags(268435456);
      localIntent.putExtra("uinType", paramQQAppInterface.getAVNotifyCenter().u());
      localIntent.putExtra("peerUin", paramQQAppInterface.getAVNotifyCenter().v());
      localIntent.putExtra("extraUin", paramQQAppInterface.getAVNotifyCenter().w());
      if (paramInt != 1) {
        bool1 = false;
      }
      localIntent.putExtra("isAudioMode", bool1);
      paramBaseActivity.startActivity(localIntent);
      paramBaseActivity.overridePendingTransition(2130772255, 0);
      return;
    }
    localIntent.addFlags(262144);
    localIntent.addFlags(268435456);
    if (paramQQAppInterface.getAVNotifyCenter().b(paramQQAppInterface.getAVNotifyCenter().v()))
    {
      localIntent.putExtra("sessionType", 3);
      localIntent.putExtra("GroupId", paramQQAppInterface.getAVNotifyCenter().v());
      localIntent.putExtra("isDoubleVideoMeeting", true);
      paramBaseActivity.startActivity(localIntent);
      paramBaseActivity.overridePendingTransition(2130772255, 0);
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X800520A", "0X800520A", 0, 0, "", "", "", "");
      return;
    }
    localIntent.putExtra("sessionType", paramInt);
    localIntent.putExtra("uin", paramQQAppInterface.getAVNotifyCenter().v());
    paramBaseActivity.startActivity(localIntent);
    paramBaseActivity.overridePendingTransition(2130772255, 0);
    ReportController.b(paramQQAppInterface, "CliOper", "", "", "Two_call", "Two_call_full", 0, 0, "1", "", "", "");
  }
  
  public static Boolean b(long paramLong, QQAppInterface paramQQAppInterface, Context paramContext, ChatActivityUtils.StartVideoListener paramStartVideoListener, ChatActivityUtils.VideoCheckFlag paramVideoCheckFlag)
  {
    new VcSystemInfo();
    VcSystemInfo.getCpuInfo();
    int i = VcSystemInfo.getCpuArchitecture();
    paramLong = VcSystemInfo.getMaxCpuFreq();
    int j = Build.VERSION.SDK_INT;
    if ((i >= 3) && (paramLong / 1000L >= 800L) && (j >= 9)) {
      return null;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ChatActivityUtils", 2, "startVideo old engine!");
    }
    String str;
    if (paramVideoCheckFlag.j != null) {
      str = (String)paramVideoCheckFlag.j.get("chat_type");
    } else {
      str = "";
    }
    if (paramVideoCheckFlag.a == 1011)
    {
      paramVideoCheckFlag = paramContext.getString(2131893654);
      PopupDialog.a(paramContext, 230, paramContext.getString(2131893450), paramVideoCheckFlag, 2131887648, 2131893377, new ChatAVHelper.2(paramStartVideoListener), null);
      if (str.equals("randomc2c")) {
        ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X80053B1", "0X80053B1", 0, 0, "", "", "", "");
      } else {
        ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X80053BD", "0X80053BD", 0, 0, "", "", "", "");
      }
      return Boolean.valueOf(false);
    }
    QQToast.makeText(paramContext, 2131893179, 1).show(paramContext.getResources().getDimensionPixelSize(2131299920));
    if (paramVideoCheckFlag.e)
    {
      ReportController.b(null, "CliOper", "", "", "Two_call", "Judge_tmp_address_false", 0, 0, "", "", "", "");
      if (paramVideoCheckFlag.a == 1024) {
        ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X80049DF", "Judge_tmp_address_false", 0, 0, "", "", "", "");
      }
    }
    return Boolean.valueOf(true);
  }
  
  public static void b(QQAppInterface paramQQAppInterface, int paramInt, BaseActivity paramBaseActivity)
  {
    long l = paramBaseActivity.app.getAVNotifyCenter().g();
    int j = paramBaseActivity.app.getAVNotifyCenter().h();
    if ((l == 0L) && (paramBaseActivity.app.getAVNotifyCenter().j() <= 0))
    {
      if (QLog.isColorLevel()) {
        QLog.e("MultiVideoBar", 2, "status error");
      }
    }
    else
    {
      int k = paramQQAppInterface.getAVNotifyCenter().e(l);
      if (paramBaseActivity.app.getAVNotifyCenter().j() > 0)
      {
        if (paramQQAppInterface.getAVNotifyCenter().k() == 1) {
          return;
        }
        if (paramQQAppInterface.getAVNotifyCenter().k() == 3) {
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.e("MultiVideoBar", 2, "status error");
        }
        return;
      }
      Intent localIntent;
      if (k == 2) {
        localIntent = new Intent();
      } else {
        localIntent = new Intent(paramBaseActivity.getApplicationContext(), AVActivity.class);
      }
      int i;
      if (paramQQAppInterface.getAVNotifyCenter().c(j, l) > 0L)
      {
        if (paramQQAppInterface.getAVNotifyCenter().a(j, l)) {
          i = 2;
        } else {
          i = 1;
        }
      }
      else {
        i = 0;
      }
      localIntent.addFlags(262144);
      localIntent.addFlags(268435456);
      localIntent.putExtra("GroupId", String.valueOf(l));
      localIntent.putExtra("Type", i);
      localIntent.putExtra("sessionType", paramInt);
      localIntent.putExtra("uinType", UITools.c(j));
      localIntent.putExtra("MultiAVType", k);
      if (k == 2)
      {
        if (paramQQAppInterface.getAVNotifyCenter().m(String.valueOf(l)) == 14)
        {
          ((IGroupVideoManager)paramQQAppInterface.getManager(QQManagerFactory.GROUP_VIDEO_PLUGIN_MANAGER)).a(paramBaseActivity, paramQQAppInterface.getCurrentAccountUin(), String.valueOf(l), "2", "openRoom");
        }
        else
        {
          TroopManager localTroopManager = (TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
          if (localTroopManager != null)
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append(l);
            localStringBuilder.append("");
            if (localTroopManager.f(localStringBuilder.toString()) == null)
            {
              bool = false;
              break label397;
            }
          }
          boolean bool = true;
          label397:
          localIntent.putExtra("troopmember", bool);
          localIntent.putExtra("Fromwhere", "SmallScreen");
          ((IGroupVideoHelper)QRoute.api(IGroupVideoHelper.class)).enterTroopVideoByPlugin(paramQQAppInterface, paramBaseActivity, localIntent, 1);
        }
      }
      else {
        paramBaseActivity.startActivity(localIntent);
      }
      paramBaseActivity.overridePendingTransition(2130772255, 0);
      if (j == 2)
      {
        ReportController.b(paramQQAppInterface, "CliOper", "", "", "Multi_call", "Msgtab_back", 0, 0, "", "", "", "");
        return;
      }
      if (j == 1)
      {
        if (paramQQAppInterface.getAVNotifyCenter().e(l) == 10)
        {
          ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X8005931", "0X8005931", 0, 0, "", "", "", "");
          return;
        }
        ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X80046D8", "0X80046D8", 0, 0, "", "", "", "");
      }
    }
  }
  
  public static Boolean c(long paramLong, QQAppInterface paramQQAppInterface, Context paramContext, ChatActivityUtils.StartVideoListener paramStartVideoListener, ChatActivityUtils.VideoCheckFlag paramVideoCheckFlag)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("startVideoCheck, !isDAudioEnable, seq[");
    ((StringBuilder)localObject).append(paramLong);
    ((StringBuilder)localObject).append("]");
    QLog.w("ChatActivityUtils", 1, ((StringBuilder)localObject).toString());
    localObject = paramContext.getString(2131893109);
    PopupDialog.a(paramContext, 230, paramContext.getString(2131893450), (String)localObject, 2131887648, 2131893377, new ChatAVHelper.3(paramStartVideoListener), null);
    if (paramVideoCheckFlag.e)
    {
      ReportController.b(null, "CliOper", "", "", "Two_call", "Judge_language_false", 0, 0, "", "", "", "");
      if (paramVideoCheckFlag.a == 1024) {
        ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X80049DF", "Judge_language_false", 0, 0, "", "", "", "");
      }
    }
    return Boolean.valueOf(false);
  }
  
  public static Boolean d(long paramLong, QQAppInterface paramQQAppInterface, Context paramContext, ChatActivityUtils.StartVideoListener paramStartVideoListener, ChatActivityUtils.VideoCheckFlag paramVideoCheckFlag)
  {
    if (!NearbyManagerHelper.a(paramQQAppInterface).f())
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatActivityUtils", 2, "startVideo don't allow date session!");
      }
      paramQQAppInterface = PopupDialog.a(paramContext, 230, null, paramContext.getString(2131893619), 2131893167, 2131893181, new ChatAVHelper.4(paramQQAppInterface, paramVideoCheckFlag, paramLong, paramContext, paramStartVideoListener), new ChatAVHelper.5(paramVideoCheckFlag, paramStartVideoListener));
      if (paramQQAppInterface != null) {
        paramQQAppInterface.setOnCancelListener(new ChatAVHelper.6(paramVideoCheckFlag, paramStartVideoListener));
      }
      return Boolean.valueOf(false);
    }
    return null;
  }
  
  public static Boolean e(long paramLong, QQAppInterface paramQQAppInterface, Context paramContext, ChatActivityUtils.StartVideoListener paramStartVideoListener, ChatActivityUtils.VideoCheckFlag paramVideoCheckFlag)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("startVideoCheck, isMsgShielded, seq[");
    ((StringBuilder)localObject).append(paramLong);
    ((StringBuilder)localObject).append("]");
    QLog.w("ChatActivityUtils", 1, ((StringBuilder)localObject).toString());
    if (paramVideoCheckFlag.e) {
      ReportController.b(null, "CliOper", "", "", "Two_call", "Shield_btn_appear", 0, 0, "", "", "", "");
    }
    localObject = paramContext.getString(2131893620);
    paramQQAppInterface = PopupDialog.a(paramContext, 230, paramContext.getString(2131893450), (String)localObject, 2131893167, 2131893181, new ChatAVHelper.7(paramQQAppInterface, paramVideoCheckFlag, paramLong, paramContext, paramStartVideoListener), new ChatAVHelper.8(paramVideoCheckFlag, paramStartVideoListener));
    if (paramQQAppInterface != null) {
      paramQQAppInterface.setOnCancelListener(new ChatAVHelper.9(paramVideoCheckFlag, paramStartVideoListener));
    }
    return Boolean.valueOf(false);
  }
  
  public static Boolean f(long paramLong, QQAppInterface paramQQAppInterface, Context paramContext, ChatActivityUtils.StartVideoListener paramStartVideoListener, ChatActivityUtils.VideoCheckFlag paramVideoCheckFlag)
  {
    paramStartVideoListener = new StringBuilder();
    paramStartVideoListener.append("startVideoCheck, !isNetSupport, seq[");
    paramStartVideoListener.append(paramLong);
    paramStartVideoListener.append("]");
    QLog.w("ChatActivityUtils", 1, paramStartVideoListener.toString());
    QQToast.makeText(paramContext, 2131892074, 0).show(paramContext.getResources().getDimensionPixelSize(2131299920));
    if (paramVideoCheckFlag.e)
    {
      ReportController.b(null, "CliOper", "", "", "Two_call", "Judge_network_false", 0, 0, "1", "", "", "");
      if (paramVideoCheckFlag.a == 1024) {
        ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X80049DF", "Judge_network_false", 0, 0, "", "", "", "");
      }
    }
    return Boolean.valueOf(true);
  }
  
  public static Boolean g(long paramLong, QQAppInterface paramQQAppInterface, Context paramContext, ChatActivityUtils.StartVideoListener paramStartVideoListener, ChatActivityUtils.VideoCheckFlag paramVideoCheckFlag)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("startVideoCheck, !isWifiConnected, seq[");
    ((StringBuilder)localObject1).append(paramLong);
    ((StringBuilder)localObject1).append("]");
    localObject1 = ((StringBuilder)localObject1).toString();
    Boolean localBoolean = Boolean.valueOf(true);
    QLog.w("ChatActivityUtils", 1, (String)localObject1);
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(VideoController.aj);
    ((StringBuilder)localObject1).append(paramQQAppInterface.getCurrentAccountUin());
    Object localObject2 = ((StringBuilder)localObject1).toString();
    localObject1 = localObject2;
    Object localObject3;
    if (paramVideoCheckFlag.j != null)
    {
      localObject3 = (String)paramVideoCheckFlag.j.get("chat_type");
      localObject1 = localObject2;
      if (localObject3 != null) {
        if (!((String)localObject3).equals("randomc2c"))
        {
          localObject1 = localObject2;
          if (!((String)localObject3).equals("randomgroup")) {}
        }
        else
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(VideoController.ak);
          ((StringBuilder)localObject1).append(paramQQAppInterface.getCurrentAccountUin());
          localObject1 = ((StringBuilder)localObject1).toString();
        }
      }
    }
    if (VideoController.n((String)localObject1) > 0)
    {
      paramVideoCheckFlag.g = false;
      paramVideoCheckFlag.h = false;
      paramVideoCheckFlag.l = false;
      ChatActivityUtils.a(paramLong, paramQQAppInterface, paramContext, paramStartVideoListener, paramVideoCheckFlag);
      return localBoolean;
    }
    int i = NetworkUtil.getSystemNetwork(paramContext);
    localObject1 = null;
    if (i == 2)
    {
      localObject3 = paramContext.getString(2131893450);
      String str = paramContext.getString(2131893445);
      localObject2 = localObject3;
      localObject1 = str;
      if (paramVideoCheckFlag.e)
      {
        ReportController.b(null, "CliOper", "", "", "Two_call", "Out_of_wifi_tips", 0, 0, "1", "", "", "");
        localObject1 = str;
        localObject2 = localObject3;
      }
    }
    for (;;)
    {
      localObject3 = localObject1;
      localObject1 = localObject2;
      break;
      if ((i != 3) && (i != 4))
      {
        localObject3 = null;
        break;
      }
      localObject2 = paramContext.getString(2131893450);
      if (paramVideoCheckFlag.e)
      {
        localObject1 = paramContext.getString(2131893447);
        ReportController.b(null, "CliOper", "", "", "Two_call", "Out_of_wifi_tips", 0, 0, "2", "", "", "");
      }
      else
      {
        localObject1 = paramContext.getString(2131893446);
      }
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("startVideoCheck, netType[");
    ((StringBuilder)localObject2).append(i);
    ((StringBuilder)localObject2).append("], seq[");
    ((StringBuilder)localObject2).append(paramLong);
    ((StringBuilder)localObject2).append("]");
    QLog.w("ChatActivityUtils", 1, ((StringBuilder)localObject2).toString());
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      if (TextUtils.isEmpty((CharSequence)localObject3)) {
        return localBoolean;
      }
      paramQQAppInterface = ChatActivityUtils.a(paramQQAppInterface, paramContext, 230, (String)localObject1, (String)localObject3, 2131893167, 2131893180, new ChatAVHelper.10(paramVideoCheckFlag, i, paramLong, paramQQAppInterface, paramContext, paramStartVideoListener), new ChatAVHelper.11(paramVideoCheckFlag, i, paramStartVideoListener));
      if (paramQQAppInterface != null) {
        paramQQAppInterface.setOnCancelListener(new ChatAVHelper.12(paramVideoCheckFlag, i, paramStartVideoListener));
      }
      return Boolean.valueOf(false);
    }
    return localBoolean;
  }
  
  public static Boolean h(long paramLong, QQAppInterface paramQQAppInterface, Context paramContext, ChatActivityUtils.StartVideoListener paramStartVideoListener, ChatActivityUtils.VideoCheckFlag paramVideoCheckFlag)
  {
    int j = paramQQAppInterface.getAVNotifyCenter().t();
    int k = paramQQAppInterface.getAVNotifyCenter().j();
    int m = paramQQAppInterface.getAVNotifyCenter().k();
    Object localObject1;
    if (paramVideoCheckFlag.j != null)
    {
      localObject2 = (String)paramVideoCheckFlag.j.get("chat_type");
      localObject1 = localObject2;
      if (localObject2 != null) {
        if (!((String)localObject2).equals("randomgroup"))
        {
          localObject1 = localObject2;
          if (!((String)localObject2).equals("randomc2c")) {}
        }
        else
        {
          String str = (String)paramVideoCheckFlag.j.get("session_name");
          localObject1 = localObject2;
          localObject2 = str;
          break label121;
        }
      }
    }
    else
    {
      localObject1 = null;
    }
    Object localObject2 = null;
    label121:
    int i = 1;
    if (((m == 1) || (m == 2)) && (k >= 1) && (k <= 5))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatActivityUtils", 2, "startVideo is in Double Random Call!");
      }
      if ((localObject2 == null) || (!((String)localObject1).equals("randomc2c")) || (!((String)localObject2).equals(paramQQAppInterface.getAVNotifyCenter().i())))
      {
        QQToast.makeText(paramContext, 2131893650, 1).show(paramContext.getResources().getDimensionPixelSize(2131299920));
        ChatActivityUtils.a(paramQQAppInterface, paramVideoCheckFlag.j);
        return Boolean.valueOf(true);
      }
    }
    else if ((paramVideoCheckFlag.k) && ((m == 3) || (m == 4)) && (k >= 1) && (k <= 5))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatActivityUtils", 2, "startVideo is Multi Random calling!");
      }
      if ((TextUtils.isEmpty((CharSequence)localObject2)) || (!TextUtils.equals((CharSequence)localObject2, paramQQAppInterface.getAVNotifyCenter().i()))) {
        i = 0;
      }
      if (i == 0)
      {
        PopupDialog.a(paramContext, 230, null, paramContext.getString(2131893276), 2131893167, 2131893180, new ChatAVHelper.13(paramVideoCheckFlag, paramLong, paramQQAppInterface, paramContext, paramStartVideoListener), new ChatAVHelper.14(paramStartVideoListener));
        ChatActivityUtils.a(paramQQAppInterface, paramVideoCheckFlag.j);
        return Boolean.valueOf(false);
      }
    }
    else
    {
      if (j == 1)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("startVideoCheck, TYPE_SESSION_AUDIO, seq[");
        ((StringBuilder)localObject1).append(paramLong);
        ((StringBuilder)localObject1).append("]");
        QLog.w("ChatActivityUtils", 1, ((StringBuilder)localObject1).toString());
        if ((paramVideoCheckFlag.e) && (((paramVideoCheckFlag.b != null) && (paramVideoCheckFlag.b.equals(paramQQAppInterface.getAVNotifyCenter().v()))) || ((paramVideoCheckFlag.d != null) && (paramVideoCheckFlag.d.equals(paramQQAppInterface.getAVNotifyCenter().v()))) || ((paramVideoCheckFlag.a == 1006) && (((paramVideoCheckFlag.b != null) && (paramVideoCheckFlag.b.equals(paramQQAppInterface.getAVNotifyCenter().w()))) || ((paramVideoCheckFlag.d != null) && (paramVideoCheckFlag.d.equals(paramQQAppInterface.getAVNotifyCenter().w())))))))
        {
          if (paramStartVideoListener != null) {
            paramStartVideoListener.b();
          }
          if (paramQQAppInterface.getAVNotifyCenter().b(paramQQAppInterface.getAVNotifyCenter().v()))
          {
            paramVideoCheckFlag = new Intent(paramContext, AVActivity.class);
            paramVideoCheckFlag.addFlags(262144);
            paramVideoCheckFlag.addFlags(268435456);
            paramVideoCheckFlag.putExtra("sessionType", 3);
            paramVideoCheckFlag.putExtra("GroupId", paramQQAppInterface.getAVNotifyCenter().v());
            paramVideoCheckFlag.putExtra("isDoubleVideoMeeting", true);
            paramContext.startActivity(paramVideoCheckFlag);
          }
          else
          {
            ChatActivityUtils.a(paramQQAppInterface, paramContext, paramVideoCheckFlag.a, paramVideoCheckFlag.b, paramVideoCheckFlag.c, paramVideoCheckFlag.d, paramVideoCheckFlag.e, paramVideoCheckFlag.f, paramVideoCheckFlag.i, paramVideoCheckFlag.j, false);
          }
          if (paramStartVideoListener != null) {
            paramStartVideoListener.c();
          }
        }
        else
        {
          QQToast.makeText(paramContext, 2131893650, 1).show(paramContext.getResources().getDimensionPixelSize(2131299920));
          ChatActivityUtils.a(paramQQAppInterface, paramVideoCheckFlag.j);
        }
        return Boolean.valueOf(true);
      }
      if (j == 2)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("startVideoCheck, TYPE_SESSION_VIDEO, seq[");
        ((StringBuilder)localObject1).append(paramLong);
        ((StringBuilder)localObject1).append("]");
        QLog.w("ChatActivityUtils", 1, ((StringBuilder)localObject1).toString());
        if ((!paramVideoCheckFlag.e) && (((paramVideoCheckFlag.b != null) && (paramVideoCheckFlag.b.equals(paramQQAppInterface.getAVNotifyCenter().v()))) || ((paramVideoCheckFlag.d != null) && (paramVideoCheckFlag.d.equals(paramQQAppInterface.getAVNotifyCenter().v()))) || ((paramVideoCheckFlag.a == 1006) && (((paramVideoCheckFlag.b != null) && (paramVideoCheckFlag.b.equals(paramQQAppInterface.getAVNotifyCenter().w()))) || ((paramVideoCheckFlag.d != null) && (paramVideoCheckFlag.d.equals(paramQQAppInterface.getAVNotifyCenter().w())))))))
        {
          if (paramStartVideoListener != null) {
            paramStartVideoListener.b();
          }
          if (paramQQAppInterface.getAVNotifyCenter().b(paramQQAppInterface.getAVNotifyCenter().v()))
          {
            paramVideoCheckFlag = new Intent(paramContext, AVActivity.class);
            paramVideoCheckFlag.addFlags(262144);
            paramVideoCheckFlag.addFlags(268435456);
            paramVideoCheckFlag.putExtra("sessionType", 3);
            paramVideoCheckFlag.putExtra("GroupId", paramQQAppInterface.getAVNotifyCenter().v());
            paramVideoCheckFlag.putExtra("isDoubleVideoMeeting", true);
            paramContext.startActivity(paramVideoCheckFlag);
          }
          else
          {
            ChatActivityUtils.a(paramQQAppInterface, paramContext, paramVideoCheckFlag.a, paramVideoCheckFlag.b, paramVideoCheckFlag.c, paramVideoCheckFlag.d, paramVideoCheckFlag.e, paramVideoCheckFlag.f, paramVideoCheckFlag.i, paramVideoCheckFlag.j, false);
          }
          if (paramStartVideoListener != null) {
            paramStartVideoListener.c();
          }
        }
        else
        {
          QQToast.makeText(paramContext, 2131893650, 1).show(paramContext.getResources().getDimensionPixelSize(2131299920));
          ChatActivityUtils.a(paramQQAppInterface, paramVideoCheckFlag.j);
        }
        return Boolean.valueOf(true);
      }
      if ((paramVideoCheckFlag.k) && ((j == 3) || (j == 4)) && (paramQQAppInterface.getAVNotifyCenter().g() > 0L))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("startVideoCheck, 存在多人通话, RelationId[");
        ((StringBuilder)localObject1).append(paramQQAppInterface.getAVNotifyCenter().g());
        ((StringBuilder)localObject1).append("], sessionType[");
        ((StringBuilder)localObject1).append(j);
        ((StringBuilder)localObject1).append("], seq[");
        ((StringBuilder)localObject1).append(paramLong);
        ((StringBuilder)localObject1).append("]");
        QLog.w("ChatActivityUtils", 1, ((StringBuilder)localObject1).toString());
        PopupDialog.a(paramContext, 230, null, paramContext.getString(2131893276), 2131893167, 2131893180, new ChatAVHelper.15(paramVideoCheckFlag, paramLong, paramQQAppInterface, paramContext, paramStartVideoListener), new ChatAVHelper.16(paramStartVideoListener));
        ChatActivityUtils.a(paramQQAppInterface, paramVideoCheckFlag.j);
        return Boolean.valueOf(false);
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatAVHelper
 * JD-Core Version:    0.7.0.1
 */