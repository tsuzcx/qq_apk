package com.tencent.biz.eqq;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.av.core.VcSystemInfo;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.biz.ProtoServlet;
import com.tencent.biz.bmqq.util.BmqqSegmentUtil;
import com.tencent.biz.pubaccount.accountdetail.api.IEqqAccountDetailActivity;
import com.tencent.biz.pubaccount.api.IPublicAccountDataManager;
import com.tencent.biz.pubaccount.api.IPublicAccountHandler;
import com.tencent.biz.pubaccount.api.IPublicAccountProxy;
import com.tencent.biz.pubaccount.api.IPublicAccountServlet;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.PlusPanelUtils;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.EqqDetailDataManager;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.EqqDetail;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.FollowRequest;
import com.tencent.mobileqq.mp.mobileqq_mp.GetEqqDetailInfoRequest;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToastNotifier;
import com.tencent.qidian.QidianManager;
import com.tencent.qidian.QidianProfileCardActivity;
import com.tencent.qidian.controller.QidianHandler;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.regex.Pattern;
import mqq.app.NewIntent;
import mqq.manager.TicketManager;
import mqq.observer.BusinessObserver;
import mqq.os.MqqHandler;

public class CrmUtils
{
  public static final Pattern a = Pattern.compile("QQ语音");
  public static final boolean b = a();
  
  public static int a(String paramString)
  {
    int j = 0;
    int i;
    try
    {
      paramString = paramString.split("\\.");
      i = 0;
      for (;;)
      {
        k = i;
        try
        {
          if (j >= paramString.length) {
            return k;
          }
          long l1 = i;
          long l2 = 3 - j;
          long l3 = Long.parseLong(paramString[j]);
          i = (int)(l1 + (0xA ^ l2 * l3));
          j += 1;
        }
        catch (Exception paramString) {}
      }
      paramString.printStackTrace();
    }
    catch (Exception paramString)
    {
      i = 0;
    }
    int k = i;
    return k;
  }
  
  public static Intent a(Context paramContext, Intent paramIntent, String paramString, boolean paramBoolean1, int paramInt1, boolean paramBoolean2, int paramInt2)
  {
    int i = 0;
    try
    {
      boolean bool = ((QidianManager)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(QQManagerFactory.QIDIAN_MANAGER)).d(paramString, false);
      i = bool;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    if (i != 0)
    {
      if (paramIntent == null) {
        paramIntent = new Intent(paramContext, QidianProfileCardActivity.class);
      } else {
        paramIntent.setClassName(paramContext, QidianProfileCardActivity.class.getName());
      }
    }
    else if (paramIntent == null) {
      paramIntent = new Intent(paramContext, ((IPublicAccountProxy)QRoute.api(IPublicAccountProxy.class)).getImplClass(IEqqAccountDetailActivity.class));
    } else {
      paramIntent.setClassName(paramContext, ((IPublicAccountProxy)QRoute.api(IPublicAccountProxy.class)).getImplName(IEqqAccountDetailActivity.class));
    }
    if (!TextUtils.isEmpty(paramString)) {
      paramIntent.putExtra("uin", paramString);
    }
    paramIntent.putExtra("AllInOne", new AllInOne(paramString, 104));
    paramIntent.putExtra("need_finish", paramBoolean1);
    paramIntent.putExtra("uintype", 1024);
    paramIntent.addFlags(67108864);
    if (paramInt1 != -1)
    {
      paramIntent.putExtra("source", paramInt1);
      try
      {
        AppInterface localAppInterface = (AppInterface)BaseApplicationImpl.getApplication().getRuntime();
        if (paramInt1 == 1) {
          ((IPublicAccountHandler)QRoute.api(IPublicAccountHandler.class)).reportClickPublicAccountEvent(localAppInterface, paramString, "Pb_account_lifeservice", "mp_msg_sys_2", "detail");
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
    }
    if (paramBoolean2)
    {
      if (paramInt2 == -1) {
        paramContext.startActivity(paramIntent);
      } else if ((paramContext instanceof Activity)) {
        ((Activity)paramContext).startActivityForResult(paramIntent, paramInt2);
      }
      if ((paramContext instanceof Activity)) {
        ((Activity)paramContext).overridePendingTransition(2130772009, 2130772010);
      }
    }
    return paramIntent;
  }
  
  public static InputStream a(Bitmap paramBitmap)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    paramBitmap.compress(Bitmap.CompressFormat.PNG, 100, localByteArrayOutputStream);
    return new ByteArrayInputStream(localByteArrayOutputStream.toByteArray());
  }
  
  private static void a(int paramInt, QQProgressDialog paramQQProgressDialog)
  {
    b(paramInt, paramQQProgressDialog);
  }
  
  public static void a(Context paramContext, int paramInt)
  {
    Toast.makeText(paramContext, paramInt, 0).show();
  }
  
  public static void a(Context paramContext, String paramString)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("_customer_transfer_sharepreference");
      paramContext = paramContext.getSharedPreferences(localStringBuilder.toString(), 0).edit();
      paramContext.clear();
      paramContext.commit();
      return;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo)
  {
    if (!b)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("IVR_TS_CrmUtils", 4, "Don't support sharp");
      }
      return;
    }
    if (VcSystemInfo.isSupportSharpAudio())
    {
      ActionSheet localActionSheet = ActionSheet.create(paramContext);
      localActionSheet.addButton(2131917335);
      localActionSheet.addCancelButton(2131887648);
      localActionSheet.setOnButtonClickListener(new CrmUtils.4(localActionSheet, paramQQAppInterface, paramContext, paramSessionInfo));
      localActionSheet.show();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("CrmUtils", 2, String.format("We needn't show video action sheet, because Sharp Audio is not supported", new Object[0]));
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, String paramString)
  {
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(">>>ivrAudio2(), ts=");
      ((StringBuilder)localObject).append(System.currentTimeMillis());
      QLog.d("IVR_TS_CrmUtils", 4, ((StringBuilder)localObject).toString());
    }
    if (QidianManager.a(paramQQAppInterface, paramSessionInfo.b))
    {
      c(paramQQAppInterface, paramContext, paramSessionInfo, paramString);
      return;
    }
    Object localObject = (IPublicAccountDataManager)paramQQAppInterface.getRuntimeService(IPublicAccountDataManager.class, "all");
    NewIntent localNewIntent;
    mobileqq_mp.GetEqqDetailInfoRequest localGetEqqDetailInfoRequest;
    if (localObject != null)
    {
      localObject = (PublicAccountInfo)((IPublicAccountDataManager)localObject).findPublicAccountInfoCache(paramSessionInfo.b);
      if (localObject == null)
      {
        localObject = (EqqDetailDataManager)paramQQAppInterface.getManager(QQManagerFactory.EQQ_DETAIL_DATA_MANAGER);
        if (localObject != null)
        {
          localObject = ((EqqDetailDataManager)localObject).a(paramSessionInfo.b);
          if (localObject == null)
          {
            if (QLog.isDevelopLevel())
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append(">>>begin getDetail, ts=");
              ((StringBuilder)localObject).append(System.currentTimeMillis());
              QLog.d("IVR_TS_CrmUtils", 4, ((StringBuilder)localObject).toString());
            }
            localObject = null;
            if ((paramContext instanceof Activity)) {
              localObject = new QQProgressDialog(paramContext, paramContext.getResources().getDimensionPixelSize(2131299920));
            }
            if (localObject != null) {
              ((QQProgressDialog)localObject).setCanceledOnTouchOutside(true);
            }
            if (QLog.isColorLevel()) {
              QLog.d("CrmUtils", 2, "sendDetailInfoRequest");
            }
            localNewIntent = new NewIntent(paramContext.getApplicationContext(), ProtoServlet.class);
            localNewIntent.putExtra("cmd", "EqqAccountSvc.get_eqq_detail");
            localGetEqqDetailInfoRequest = new mobileqq_mp.GetEqqDetailInfoRequest();
            localGetEqqDetailInfoRequest.version.set(2);
            localGetEqqDetailInfoRequest.seqno.set(0);
          }
        }
      }
    }
    try
    {
      localGetEqqDetailInfoRequest.eqq_id.set((int)Long.parseLong(paramSessionInfo.b));
      localNewIntent.putExtra("data", localGetEqqDetailInfoRequest.toByteArray());
      localNewIntent.setObserver(new CrmUtils.2(paramContext, paramQQAppInterface, (QQProgressDialog)localObject, paramSessionInfo, paramString));
      paramQQAppInterface.startServlet(localNewIntent);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        try
        {
          if (((paramContext instanceof Activity)) && (!((Activity)paramContext).isFinishing()))
          {
            a(2131893010, (QQProgressDialog)localObject);
            return;
            b(paramQQAppInterface, paramContext, paramSessionInfo, null, (EqqDetail)localObject, paramString);
            return;
            a(paramContext, 2131892951);
            ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X80049DF", "GetDetailFalse", 0, 0, "", "", "", "");
            return;
            b(paramQQAppInterface, paramContext, paramSessionInfo, (PublicAccountInfo)localObject, null, paramString);
            return;
            a(paramContext, 2131892951);
            ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X80049DF", "GetDetailFalse", 0, 0, "", "", "", "");
          }
          return;
        }
        catch (Exception paramQQAppInterface) {}
        localException = localException;
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, int paramInt, BusinessObserver paramBusinessObserver)
  {
    mobileqq_mp.GetEqqDetailInfoRequest localGetEqqDetailInfoRequest;
    if (!b(paramQQAppInterface, paramString, paramInt))
    {
      paramContext = new NewIntent(paramContext.getApplicationContext(), ProtoServlet.class);
      paramContext.putExtra("cmd", "EqqAccountSvc.get_eqq_detail");
      localGetEqqDetailInfoRequest = new mobileqq_mp.GetEqqDetailInfoRequest();
      localGetEqqDetailInfoRequest.version.set(2);
      localGetEqqDetailInfoRequest.seqno.set(0);
    }
    try
    {
      localGetEqqDetailInfoRequest.eqq_id.set((int)Long.parseLong(paramString));
      label75:
      paramContext.putExtra("data", localGetEqqDetailInfoRequest.toByteArray());
      paramContext.setObserver(paramBusinessObserver);
      paramQQAppInterface.startServlet(paramContext);
      return;
    }
    catch (Exception paramString)
    {
      break label75;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString1, String paramString2)
  {
    if (!b)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("IVR_TS_CrmUtils", 4, "Don't support sharp");
      }
      return;
    }
    SessionInfo localSessionInfo = new SessionInfo();
    localSessionInfo.a = 1024;
    localSessionInfo.e = paramString2;
    localSessionInfo.b = paramString1;
    a(paramQQAppInterface, paramContext, localSessionInfo);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(">>>ivrAudio1(), ts=");
      ((StringBuilder)localObject).append(System.currentTimeMillis());
      QLog.d("IVR_TS_CrmUtils", 4, ((StringBuilder)localObject).toString());
    }
    Object localObject = new SessionInfo();
    ((SessionInfo)localObject).a = 1024;
    ((SessionInfo)localObject).e = paramString1;
    ((SessionInfo)localObject).b = paramString2;
    a(paramQQAppInterface, paramContext, (SessionInfo)localObject, paramString3);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, EqqDetail paramEqqDetail)
  {
    ThreadManager.getFileThreadHandler().post(new CrmUtils.1(paramQQAppInterface, paramEqqDetail));
  }
  
  public static boolean a()
  {
    new VcSystemInfo();
    VcSystemInfo.getCpuInfo();
    int i = VcSystemInfo.getCpuArchitecture();
    long l = VcSystemInfo.getMaxCpuFreq();
    int j = Build.VERSION.SDK_INT;
    if ((i >= 3) && (l / 1000L >= 800L) && (j >= 9)) {
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("CrmUtils", 2, "User don't support sharp!");
    }
    return false;
  }
  
  public static boolean a(int paramInt)
  {
    boolean bool = false;
    if (paramInt < 0)
    {
      QLog.i("CrmUtils", 1, "isCrmMaster meet error!!");
      return false;
    }
    if ((paramInt & 0x1) != 0) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean a(BaseQQAppInterface paramBaseQQAppInterface, String paramString)
  {
    boolean bool1 = BmqqSegmentUtil.a(paramString);
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    paramBaseQQAppInterface = ((FriendsManager)paramBaseQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).c(paramString);
    bool1 = bool2;
    if (paramBaseQQAppInterface != null)
    {
      bool1 = bool2;
      if (a(paramBaseQQAppInterface.cSpecialFlag)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static boolean a(BaseQQAppInterface paramBaseQQAppInterface, String paramString, int paramInt)
  {
    boolean bool2 = false;
    if ((paramInt != 0) && (paramInt != 1024))
    {
      if (QLog.isColorLevel()) {
        QLog.d("CrmUtils", 2, "isQiye not friend and not crm tmp");
      }
      return false;
    }
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty(paramString))
    {
      Object localObject;
      if (paramBaseQQAppInterface != null)
      {
        localObject = (IPublicAccountDataManager)paramBaseQQAppInterface.getRuntimeService(IPublicAccountDataManager.class, "all");
        if (localObject != null)
        {
          localObject = (PublicAccountInfo)((IPublicAccountDataManager)localObject).findPublicAccountInfoCache(paramString);
          if (localObject != null)
          {
            if (((PublicAccountInfo)localObject).extendType != 2) {
              break label159;
            }
            if (QLog.isColorLevel()) {
              QLog.d("CrmUtils", 2, "isQiye PublicAccountInfo is eqq");
            }
          }
          for (;;)
          {
            bool1 = true;
            break label161;
            localObject = paramBaseQQAppInterface.getManager(QQManagerFactory.EQQ_DETAIL_DATA_MANAGER);
            if ((localObject == null) || (((EqqDetailDataManager)localObject).a(paramString) == null)) {
              break;
            }
            if (QLog.isColorLevel()) {
              QLog.d("CrmUtils", 2, "isQiye EqqDetail has data");
            }
          }
        }
      }
      label159:
      bool1 = false;
      label161:
      if ((!bool1) && (paramInt == 0))
      {
        bool1 = a(paramBaseQQAppInterface, paramString);
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("isQiye after getSimpleInfo value is ");
          ((StringBuilder)localObject).append(bool1);
          QLog.d("CrmUtils", 2, ((StringBuilder)localObject).toString());
        }
        if (QidianManager.a(paramBaseQQAppInterface, paramString))
        {
          bool1 = bool2;
          if (QLog.isColorLevel())
          {
            QLog.d("CrmUtils", 2, "isQiye uin is qidianmaster");
            bool1 = bool2;
          }
        }
        else {}
      }
    }
    if (bool1) {
      QLog.i("CrmUtils", 1, "isQiye is true finally");
    }
    return bool1;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (paramQQAppInterface != null)
    {
      if (paramString == null) {
        return false;
      }
      paramQQAppInterface = (IPublicAccountDataManager)paramQQAppInterface.getRuntimeService(IPublicAccountDataManager.class, "all");
      if (paramQQAppInterface != null)
      {
        paramQQAppInterface = (PublicAccountInfo)paramQQAppInterface.findPublicAccountInfoCache(paramString);
        if ((paramQQAppInterface != null) && (paramQQAppInterface.extendType == 2)) {
          return true;
        }
      }
    }
    return false;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    long l1 = System.currentTimeMillis();
    Object localObject;
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(">>>hasIvrAbility(), ts=");
      ((StringBuilder)localObject).append(l1);
      QLog.d("IVR_TS_CrmUtils", 4, ((StringBuilder)localObject).toString());
    }
    if ((paramQQAppInterface != null) && (!TextUtils.isEmpty(paramString)))
    {
      if (paramInt == 1024)
      {
        localObject = (IPublicAccountDataManager)paramQQAppInterface.getRuntimeService(IPublicAccountDataManager.class, "all");
        if (localObject != null)
        {
          localObject = (PublicAccountInfo)((IPublicAccountDataManager)localObject).findPublicAccountInfoCache(paramString);
          if (localObject != null)
          {
            bool = ((PublicAccountInfo)localObject).hasIvrAbility();
            break label275;
          }
          if (QLog.isColorLevel()) {
            QLog.d("CrmUtils", 2, String.format("We cant find %s in public account cache", new Object[] { paramString }));
          }
          paramQQAppInterface = paramQQAppInterface.getManager(QQManagerFactory.EQQ_DETAIL_DATA_MANAGER);
          if (paramQQAppInterface != null)
          {
            paramQQAppInterface = ((EqqDetailDataManager)paramQQAppInterface).a(paramString);
            if (paramQQAppInterface != null)
            {
              bool = paramQQAppInterface.hasIvrAbility();
              break label275;
            }
            if (QLog.isColorLevel()) {
              QLog.d("CrmUtils", 2, String.format("We can't find %s from EqqCache", new Object[] { paramString }));
            }
          }
          else if (QLog.isColorLevel())
          {
            QLog.e("CrmUtils", 2, "Get EqqDetailDataManager error");
          }
        }
        else if (QLog.isColorLevel())
        {
          QLog.e("CrmUtils", 2, "Get PublicAccountDataManager error");
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("CrmUtils", 2, String.format("uin %s isn't crmqq or now session type isn't crm", new Object[] { paramString }));
      }
      boolean bool = false;
      label275:
      if (QLog.isColorLevel()) {
        QLog.d("CrmUtils", 2, String.format("Check %s hasIvrAbility end, the result is %b", new Object[] { paramString, Boolean.valueOf(bool) }));
      }
      long l2 = System.currentTimeMillis();
      if (QLog.isDevelopLevel())
      {
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append("<<<hasIvrAbility(), ts=");
        paramQQAppInterface.append(l2);
        QLog.d("IVR_TS_CrmUtils", 4, paramQQAppInterface.toString());
        QLog.d("IVR_TS_CrmUtils", 4, String.format("hasIvrAbility(), cost=%dms", new Object[] { Long.valueOf(l2 - l1) }));
      }
      return bool;
    }
    if (QLog.isColorLevel()) {
      QLog.d("CrmUtils", 2, "app is null or uin is empty");
    }
    return false;
  }
  
  private static void b(int paramInt, QQProgressDialog paramQQProgressDialog)
  {
    if (paramQQProgressDialog != null)
    {
      paramQQProgressDialog.c(paramInt);
      paramQQProgressDialog.show();
    }
  }
  
  private static void b(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, PublicAccountInfo paramPublicAccountInfo, EqqDetail paramEqqDetail, String paramString)
  {
    Object localObject;
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(">>>ivrAudio3(), ts=");
      ((StringBuilder)localObject).append(System.currentTimeMillis());
      QLog.d("IVR_TS_CrmUtils", 4, ((StringBuilder)localObject).toString());
    }
    boolean bool;
    if (paramPublicAccountInfo != null) {
      bool = paramPublicAccountInfo.hasIvrAbility();
    }
    do
    {
      i = 1;
      break;
      if (paramEqqDetail == null) {
        break label339;
      }
      bool = paramEqqDetail.hasIvrAbility();
    } while (paramEqqDetail.followType != 0);
    int i = 0;
    if (bool) {
      if (i == 0)
      {
        if (QLog.isDevelopLevel())
        {
          paramPublicAccountInfo = new StringBuilder();
          paramPublicAccountInfo.append(">>>begin follow, ts=");
          paramPublicAccountInfo.append(System.currentTimeMillis());
          QLog.d("IVR_TS_CrmUtils", 4, paramPublicAccountInfo.toString());
        }
        paramPublicAccountInfo = null;
        if ((paramContext instanceof Activity)) {
          paramPublicAccountInfo = new QQProgressDialog(paramContext, paramContext.getResources().getDimensionPixelSize(2131299920));
        }
        if (paramPublicAccountInfo != null) {
          paramPublicAccountInfo.setCanceledOnTouchOutside(true);
        }
        localObject = new NewIntent(paramContext.getApplicationContext(), ((IPublicAccountServlet)QRoute.api(IPublicAccountServlet.class)).getServletClass());
        ((NewIntent)localObject).putExtra("cmd", "follow");
        mobileqq_mp.FollowRequest localFollowRequest = new mobileqq_mp.FollowRequest();
        localFollowRequest.uin.set((int)Long.parseLong(paramEqqDetail.uin));
        localFollowRequest.account_type.set(2);
        ((NewIntent)localObject).putExtra("data", localFollowRequest.toByteArray());
        ((NewIntent)localObject).setObserver(new CrmUtils.3(paramContext, paramQQAppInterface, paramPublicAccountInfo, paramEqqDetail, paramSessionInfo, paramString));
        paramQQAppInterface.startServlet((NewIntent)localObject);
      }
    }
    try
    {
      if (((paramContext instanceof Activity)) && (!((Activity)paramContext).isFinishing())) {
        a(2131893010, paramPublicAccountInfo);
      }
      label313:
      if (QLog.isColorLevel())
      {
        QLog.d("CrmUtils", 2, "follow exit");
        return;
        c(paramQQAppInterface, paramContext, paramSessionInfo, paramString);
      }
      return;
      label339:
      if (QLog.isColorLevel()) {
        QLog.w("CrmUtils", 2, "Both PublicAccountInfo and EqqDetail is NULL!");
      }
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      break label313;
    }
  }
  
  public static void b(QQAppInterface paramQQAppInterface, Context paramContext, String paramString1, String paramString2)
  {
    Object localObject = (TicketManager)paramQQAppInterface.getManager(2);
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = ((TicketManager)localObject).getStweb(paramQQAppInterface.getCurrentAccountUin());
    }
    if ((localObject != null) && (((String)localObject).length() != 0))
    {
      paramString1 = String.format("https://ptlogin2.qq.com/qidian_client?pt_clientver=5428&pt_src=1&clientuin=%s&clientkey=%s&keyindex=19&jump=30&kfuin=%s&kfext=%s&buildver=1.0.0.0&inter=1&_wv=1027", new Object[] { paramQQAppInterface.getCurrentAccountUin(), localObject, paramString1, paramString2 });
      if (QLog.isColorLevel())
      {
        paramString2 = new StringBuilder();
        paramString2.append("enterLightTalk() url = ");
        paramString2.append(paramString1);
        QLog.d("CrmUtils", 2, paramString2.toString());
      }
      paramString2 = new Intent(paramContext, QQBrowserActivity.class);
      paramString2.putExtra("uin", paramQQAppInterface.getCurrentAccountUin());
      paramString2.putExtra("url", paramString1);
      paramString2.putExtra("hide_more_button", true);
      paramContext.startActivity(paramString2);
      return;
    }
    new QQToastNotifier(paramContext).notifyUser(2131890882, paramContext.getResources().getDimensionPixelSize(2131299920), 0, 1);
  }
  
  public static void b(QQAppInterface paramQQAppInterface, EqqDetail paramEqqDetail)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CrmUtils", 2, "saveCache");
    }
    EqqDetailDataManager localEqqDetailDataManager = (EqqDetailDataManager)paramQQAppInterface.getManager(QQManagerFactory.EQQ_DETAIL_DATA_MANAGER);
    if (localEqqDetailDataManager != null) {
      localEqqDetailDataManager.a(paramEqqDetail);
    }
    if ((paramEqqDetail != null) && (paramEqqDetail.followType == 1))
    {
      paramQQAppInterface = (IPublicAccountDataManager)paramQQAppInterface.getRuntimeService(IPublicAccountDataManager.class, "all");
      if (paramQQAppInterface != null) {
        paramQQAppInterface.savePublicAccountInfo(PublicAccountInfo.createPublicAccount(paramEqqDetail, 0L));
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("CrmUtils", 2, "saveCache exit");
    }
  }
  
  private static void b(QQProgressDialog paramQQProgressDialog)
  {
    if ((paramQQProgressDialog != null) && (paramQQProgressDialog.isShowing())) {
      paramQQProgressDialog.dismiss();
    }
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (paramQQAppInterface != null)
    {
      if (paramString == null) {
        return false;
      }
      Object localObject = (IPublicAccountDataManager)paramQQAppInterface.getRuntimeService(IPublicAccountDataManager.class, "all");
      if (localObject != null)
      {
        localObject = (PublicAccountInfo)((IPublicAccountDataManager)localObject).findPublicAccountInfoCache(paramString);
        if ((localObject != null) && (((PublicAccountInfo)localObject).extendType == 2)) {
          return true;
        }
      }
      paramQQAppInterface = (EqqDetailDataManager)paramQQAppInterface.getManager(QQManagerFactory.EQQ_DETAIL_DATA_MANAGER);
      if ((paramQQAppInterface != null) && (paramQQAppInterface.a(paramString) != null)) {
        return true;
      }
    }
    return false;
  }
  
  private static boolean b(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    if ((paramQQAppInterface != null) && (!TextUtils.isEmpty(paramString)))
    {
      if (paramInt == 1024)
      {
        IPublicAccountDataManager localIPublicAccountDataManager = (IPublicAccountDataManager)paramQQAppInterface.getRuntimeService(IPublicAccountDataManager.class, "all");
        if (localIPublicAccountDataManager != null)
        {
          if ((PublicAccountInfo)localIPublicAccountDataManager.findPublicAccountInfoCache(paramString) == null)
          {
            if (QLog.isColorLevel()) {
              QLog.d("CrmUtils", 2, String.format("We cant find %s in public account cache", new Object[] { paramString }));
            }
            paramQQAppInterface = paramQQAppInterface.getManager(QQManagerFactory.EQQ_DETAIL_DATA_MANAGER);
            if (paramQQAppInterface == null) {
              break label143;
            }
            if (((EqqDetailDataManager)paramQQAppInterface).a(paramString) == null) {}
          }
          else
          {
            bool = true;
            break label210;
          }
          if (QLog.isColorLevel())
          {
            QLog.d("CrmUtils", 2, String.format("We can't find %s from EqqCache", new Object[] { paramString }));
            break label208;
            label143:
            if (QLog.isColorLevel()) {
              QLog.e("CrmUtils", 2, "Get EqqDetailDataManager error");
            }
          }
        }
        else if (QLog.isColorLevel())
        {
          QLog.e("CrmUtils", 2, "Get PublicAccountDataManager error");
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("CrmUtils", 2, String.format("uin %s isn't crmqq or now session type isn't crm", new Object[] { paramString }));
      }
      label208:
      boolean bool = false;
      label210:
      if (QLog.isColorLevel()) {
        QLog.d("CrmUtils", 2, String.format("Check %s isContainUinInfo end, the result is %b", new Object[] { paramString, Boolean.valueOf(bool) }));
      }
      return bool;
    }
    if (QLog.isColorLevel()) {
      QLog.d("CrmUtils", 2, "app is null or uin is empty");
    }
    return false;
  }
  
  public static String c(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (QidianManager.a(paramQQAppInterface, paramString))
      {
        paramQQAppInterface = ((FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).c(paramString);
        if (paramQQAppInterface != null) {
          return paramQQAppInterface.getFriendName();
        }
      }
      else
      {
        Object localObject = (IPublicAccountDataManager)paramQQAppInterface.getRuntimeService(IPublicAccountDataManager.class, "all");
        if (localObject != null)
        {
          localObject = (PublicAccountInfo)((IPublicAccountDataManager)localObject).findPublicAccountInfoCache(paramString);
          if (localObject != null) {
            return ((PublicAccountInfo)localObject).name;
          }
          paramQQAppInterface = paramQQAppInterface.getManager(QQManagerFactory.EQQ_DETAIL_DATA_MANAGER);
          if (paramQQAppInterface != null)
          {
            paramQQAppInterface = ((EqqDetailDataManager)paramQQAppInterface).a(paramString);
            if (paramQQAppInterface != null) {
              return paramQQAppInterface.name;
            }
            if (QLog.isColorLevel())
            {
              QLog.d("CrmUtils", 2, String.format("We can't find %s from EqqCache", new Object[] { paramString }));
              return "";
            }
          }
          else if (QLog.isColorLevel())
          {
            QLog.e("CrmUtils", 2, "Get EqqDetailDataManager error");
            return "";
          }
        }
        else if (QLog.isColorLevel())
        {
          QLog.e("CrmUtils", 2, "Get PublicAccountDataManager error");
          return "";
        }
      }
    }
    else if (QLog.isColorLevel()) {
      QLog.d("CrmUtils", 2, "We can't get name, because uin is null");
    }
    return "";
  }
  
  private static void c(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, String paramString)
  {
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(">>>startVideo(), ts=");
      ((StringBuilder)localObject).append(System.currentTimeMillis());
      QLog.d("IVR_TS_CrmUtils", 4, ((StringBuilder)localObject).toString());
    }
    Object localObject = paramSessionInfo.b;
    int i;
    if ((paramQQAppInterface.isVideoChatting()) && (localObject != null) && (((String)localObject).equals(paramQQAppInterface.getAVNotifyCenter().v()))) {
      i = 1;
    } else {
      i = 0;
    }
    if (i == 0) {
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X8004628", "0X8004628", 0, 0, "", "", "", "");
    }
    if (paramSessionInfo.a != 1008) {
      paramSessionInfo.a = 1024;
    }
    PlusPanelUtils.a(paramQQAppInterface, paramContext, paramSessionInfo, true, paramString, null);
  }
  
  public static void c(QQAppInterface paramQQAppInterface, Context paramContext, String paramString1, String paramString2)
  {
    if (!((FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).n(paramString2)) {
      return;
    }
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString1);
      localStringBuilder.append("_customer_transfer_sharepreference");
      paramContext = paramContext.getSharedPreferences(localStringBuilder.toString(), 0);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString1);
      localStringBuilder.append("_");
      localStringBuilder.append(paramString2);
      if (!paramContext.getBoolean(localStringBuilder.toString(), false))
      {
        ((QidianHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.QIDIAN_HANDLER)).a(Long.valueOf(paramString1).longValue(), Long.valueOf(paramString2).longValue());
        return;
      }
    }
    catch (Exception paramQQAppInterface)
    {
      paramQQAppInterface.printStackTrace();
    }
  }
  
  public static int d(QQAppInterface paramQQAppInterface, String paramString)
  {
    Object localObject = (IPublicAccountDataManager)paramQQAppInterface.getRuntimeService(IPublicAccountDataManager.class, "all");
    if (localObject != null)
    {
      localObject = (PublicAccountInfo)((IPublicAccountDataManager)localObject).findPublicAccountInfoCache(paramString);
      if (localObject == null)
      {
        paramQQAppInterface = (EqqDetailDataManager)paramQQAppInterface.getManager(QQManagerFactory.EQQ_DETAIL_DATA_MANAGER);
        if (paramQQAppInterface != null)
        {
          paramQQAppInterface = paramQQAppInterface.a(paramString);
          if ((paramQQAppInterface != null) && (paramQQAppInterface.certifiedGrade > 0)) {
            return 2130842755;
          }
        }
      }
      else if (((PublicAccountInfo)localObject).certifiedGrade > 0L)
      {
        return 2130842755;
      }
    }
    return 0;
  }
  
  public static String e(QQAppInterface paramQQAppInterface, String paramString)
  {
    String str = paramString;
    if (!TextUtils.isEmpty(paramString))
    {
      if (QidianManager.a(paramQQAppInterface, paramString)) {
        return QidianManager.c(paramQQAppInterface, paramString);
      }
      Object localObject = (IPublicAccountDataManager)paramQQAppInterface.getRuntimeService(IPublicAccountDataManager.class, "all");
      str = paramString;
      if (localObject != null)
      {
        localObject = (PublicAccountInfo)((IPublicAccountDataManager)localObject).findPublicAccountInfoCache(paramString);
        if (localObject != null)
        {
          str = paramString;
          if (((PublicAccountInfo)localObject).extendType == 2) {
            return ((PublicAccountInfo)localObject).name;
          }
        }
        else
        {
          paramQQAppInterface = paramQQAppInterface.getManager(QQManagerFactory.EQQ_DETAIL_DATA_MANAGER);
          str = paramString;
          if (paramQQAppInterface != null)
          {
            paramQQAppInterface = ((EqqDetailDataManager)paramQQAppInterface).a(paramString);
            str = paramString;
            if (paramQQAppInterface != null) {
              str = paramQQAppInterface.name;
            }
          }
        }
      }
    }
    return str;
  }
  
  public static int f(QQAppInterface paramQQAppInterface, String paramString)
  {
    if ((paramQQAppInterface != null) && (BmqqSegmentUtil.a(paramString)) && (BmqqSegmentUtil.c(paramString)))
    {
      paramQQAppInterface = (FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
      if ((paramQQAppInterface != null) && (paramQQAppInterface.n(paramString))) {
        return 0;
      }
      return 1025;
    }
    return 1024;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.eqq.CrmUtils
 * JD-Core Version:    0.7.0.1
 */