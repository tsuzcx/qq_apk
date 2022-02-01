package com.tencent.mobileqq.activity.aio.helper;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.Html;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.qwallet.temp.IQWalletAIOLifeCycleHelper;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.BaseMsgProxy;
import com.tencent.imcore.message.MsgPool;
import com.tencent.imcore.message.MsgProxyUtils;
import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.mobileqq.activity.ChatActivityFacade.SendMsgParams;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.copyprompt.CopyPromptHelper;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.UniteGrayTipMsgUtil;
import com.tencent.mobileqq.graytip.UniteGrayTipParam;
import com.tencent.mobileqq.managers.PasswdRedBagFoldManager;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingWindowBroadcast;
import com.tencent.mobileqq.qqgamepub.api.IGameShareUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.IQWalletGdtAdApi;
import com.tencent.mobileqq.qwallet.hb.aio.passwd.IPasswdRedBagService;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.WupUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.os.MqqHandler;
import tencent.im.qqwallet.GdtAdServlet;
import tencent.im.qqwallet.birthday_hb_reminder_srv.ListQueryRequest;

public class QWalletAIOLifeCycleHelper
  implements IQWalletAIOLifeCycleHelper
{
  public boolean a = false;
  MessageObserver b = new QWalletAIOLifeCycleHelper.1(this);
  private IPasswdRedBagService c;
  private QQAppInterface d;
  private Context e;
  private Activity f;
  private BaseChatPie g;
  private SessionInfo h;
  private LinearLayout i;
  private TextView j;
  private TextView k;
  private TextView l;
  private View m;
  private int n;
  private String o;
  private String p;
  
  public QWalletAIOLifeCycleHelper(BaseChatPie paramBaseChatPie)
  {
    this.g = paramBaseChatPie;
    this.d = paramBaseChatPie.d;
    this.e = paramBaseChatPie.e;
    this.f = paramBaseChatPie.f;
    this.h = paramBaseChatPie.ah;
    this.c = ((IPasswdRedBagService)this.d.getRuntimeService(IPasswdRedBagService.class));
  }
  
  private void a(String paramString1, String paramString2, int paramInt, View.OnClickListener paramOnClickListener)
  {
    this.o = paramString1;
    this.p = paramString2;
    paramString1 = this.g;
    if ((paramString1 != null) && (paramString1.U != null)) {
      this.n = this.g.U.getFirstVisiblePosition();
    }
    paramString1 = this.m;
    if (paramString1 != null) {
      paramString1.setVisibility(8);
    }
    paramString1 = this.j;
    if (paramString1 != null) {
      paramString1.setText(paramString2);
    }
    if (this.k != null)
    {
      paramString1 = b(paramInt);
      this.k.setText(paramString1);
      this.k.setTextColor(this.f.getResources().getColor(2131165564));
    }
    paramString1 = this.l;
    if (paramString1 != null)
    {
      paramString1.setVisibility(0);
      if (paramInt == 0) {
        this.l.setText(HardCodeUtil.a(2131918073));
      } else if (paramInt == 1) {
        this.l.setText(HardCodeUtil.a(2131918067));
      } else if (paramInt == 2) {
        this.l.setText(HardCodeUtil.a(2131918069));
      }
    }
    paramString1 = this.i;
    if (paramString1 != null)
    {
      paramString1.removeView(this.j);
      this.i.removeView(this.k);
      this.i.addView(this.k, 0);
      this.i.addView(this.j, 2);
      this.i.setOrientation(0);
      this.i.setVisibility(0);
      this.i.bringToFront();
      this.i.setOnClickListener(paramOnClickListener);
    }
    paramString1 = this.g;
    if (paramString1 != null) {
      ((CopyPromptHelper)paramString1.q(19)).a();
    }
  }
  
  private void a(String paramString1, String paramString2, String paramString3, View.OnClickListener paramOnClickListener, boolean paramBoolean)
  {
    this.n = this.g.U.getFirstVisiblePosition();
    this.o = paramString1;
    this.p = paramString2;
    paramString1 = this.m;
    if (paramString1 != null) {
      paramString1.setVisibility(0);
    }
    paramString1 = this.j;
    if (paramString1 != null)
    {
      paramString1.setText(paramString2);
      this.j.setTextColor(Color.parseColor("#ff4222"));
    }
    paramString1 = this.k;
    if (paramString1 != null)
    {
      paramString1.setText(paramString3);
      this.k.setTextColor(this.f.getResources().getColor(2131165564));
    }
    paramString1 = this.l;
    if (paramString1 != null) {
      paramString1.setVisibility(8);
    }
    paramString1 = this.j;
    if ((paramString1 != null) && (this.k != null))
    {
      paramString2 = this.i;
      if (paramString2 != null)
      {
        paramString2.removeView(paramString1);
        this.i.removeView(this.k);
        if (paramBoolean)
        {
          this.i.addView(this.j, 0);
          this.i.addView(this.k, 2);
        }
        else
        {
          this.i.addView(this.k, 0);
          this.i.addView(this.j, 2);
        }
        this.i.setOrientation(1);
        this.i.setVisibility(0);
        this.i.bringToFront();
        this.i.setOnClickListener(paramOnClickListener);
      }
    }
    ((CopyPromptHelper)this.g.q(19)).a();
  }
  
  private Object[] a(String paramString, int paramInt)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    Object[] arrayOfObject = null;
    if (bool) {
      return null;
    }
    Object localObject;
    if (!AnonymousChatHelper.a().a(this.h.b))
    {
      if (!TextUtils.isEmpty(this.o)) {
        arrayOfObject = this.c.openPasswdRedBagById(paramString, this.h, this.o, paramInt);
      } else {
        arrayOfObject = this.c.openPasswdRedBagByPassword(this.h, paramString, paramInt);
      }
      localObject = arrayOfObject;
      if (arrayOfObject != null)
      {
        localObject = arrayOfObject;
        if (((Integer)arrayOfObject[0]).intValue() == 1)
        {
          this.o = "";
          this.p = "";
          this.g.j().sendEmptyMessage(12);
          localObject = arrayOfObject;
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(paramString.charAt(0));
            ((StringBuilder)localObject).append("|");
            ((StringBuilder)localObject).append(paramString.length());
            paramString = new StringBuilder();
            paramString.append("passwdredbags result[0]=");
            paramString.append(arrayOfObject[0]);
            paramString.append(",result[1]=");
            paramString.append(arrayOfObject[1]);
            paramString.append(",send str=");
            paramString.append(((StringBuilder)localObject).toString());
            QLog.d("PasswdRedBagSgervice", 2, paramString.toString());
            return arrayOfObject;
          }
        }
      }
    }
    else
    {
      localObject = arrayOfObject;
      if (QLog.isColorLevel())
      {
        QLog.d("PasswdRedBagSgervice", 2, "current is in Anonymous, dont search passwdredbags");
        localObject = arrayOfObject;
      }
    }
    return localObject;
  }
  
  private static String b(int paramInt)
  {
    if (paramInt == 0) {
      return HardCodeUtil.a(2131908778);
    }
    if (paramInt == 1) {
      return HardCodeUtil.a(2131918068);
    }
    if (paramInt == 2) {
      return HardCodeUtil.a(2131918070);
    }
    return "";
  }
  
  public void a()
  {
    Object localObject = this.j;
    if (localObject != null) {
      ((TextView)localObject).setText("");
    }
    localObject = this.k;
    if (localObject != null) {
      ((TextView)localObject).setText("");
    }
    localObject = this.i;
    if (localObject != null) {
      ((LinearLayout)localObject).setVisibility(8);
    }
  }
  
  public void a(int paramInt)
  {
    if (this.n == 0) {
      this.n = paramInt;
    }
    if ((!TextUtils.isEmpty(this.p)) && (this.n - paramInt > 5)) {
      a();
    }
  }
  
  public void a(Editable paramEditable)
  {
    if ((paramEditable != null) && (paramEditable.toString().equals(this.p))) {
      a();
    }
  }
  
  public void a(BusinessObserver paramBusinessObserver)
  {
    QQAppInterface localQQAppInterface = this.d;
    if (localQQAppInterface != null)
    {
      localQQAppInterface.addObserver(paramBusinessObserver);
      if (QLog.isColorLevel()) {
        QLog.d("addQQWalletTips", 2, "addObserver");
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    try
    {
      NewIntent localNewIntent = new NewIntent(MobileQQ.sMobileQQ, GdtAdServlet.class);
      localNewIntent.putExtra("cmd", "trpc.qqhb.birthday_hb_srv.BirthdayHbSrv.ListQuerySSO");
      birthday_hb_reminder_srv.ListQueryRequest localListQueryRequest = new birthday_hb_reminder_srv.ListQueryRequest();
      localListQueryRequest.uin.set(paramQQAppInterface.getCurrentUin());
      localNewIntent.putExtra("data", WupUtil.a(localListQueryRequest.toByteArray()));
      localNewIntent.setObserver(new QWalletAIOLifeCycleHelper.6(this, paramQQAppInterface));
      paramQQAppInterface.startServlet(localNewIntent);
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      paramQQAppInterface.printStackTrace();
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, String paramString)
  {
    if (paramMessageRecord == null) {
      return;
    }
    long l1 = paramMessageRecord.time + 1L;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("mr.time:");
      ((StringBuilder)localObject).append(paramMessageRecord.time);
      ((StringBuilder)localObject).append(",time:");
      ((StringBuilder)localObject).append(l1);
      QLog.d("addQQWalletTips", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("   ");
    ((StringBuilder)localObject).append(paramString);
    paramString = ((StringBuilder)localObject).toString();
    localObject = new UniteGrayTipParam(paramMessageRecord.frienduin, paramQQAppInterface.getCurrentAccountUin(), paramString, paramMessageRecord.istroop, -5020, 4194305, l1);
    ((UniteGrayTipParam)localObject).m = true;
    paramString = new Bundle();
    paramString.putString("image_resource", "qqwallet_shengpizi_graytip_icon");
    ((UniteGrayTipParam)localObject).a(0, 2, paramString);
    paramString = new MessageForUniteGrayTip();
    paramString.initGrayTipMsg(paramQQAppInterface, (UniteGrayTipParam)localObject);
    paramString.shmsgseq = paramMessageRecord.shmsgseq;
    localObject = (List)paramQQAppInterface.getMessageProxy(this.h.a).a().c().get(UinTypeUtil.a(this.h.b, this.h.a));
    if (localObject != null)
    {
      if (((List)localObject).isEmpty()) {
        return;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("msgGray.shmsgseq:");
        localStringBuilder.append(paramString.shmsgseq);
        localStringBuilder.append(",mr.shmsgseq:");
        localStringBuilder.append(paramMessageRecord.shmsgseq);
        QLog.d("addQQWalletTips", 2, localStringBuilder.toString());
      }
      paramMessageRecord = paramQQAppInterface.getMessageProxy(this.h.a).a().a(this.h.b, this.h.a);
      paramMessageRecord.lock();
      try
      {
        MsgProxyUtils.a((List)localObject, paramString, true);
        paramMessageRecord.unlock();
        UniteGrayTipMsgUtil.a(paramQQAppInterface, paramString);
        return;
      }
      finally
      {
        paramMessageRecord.unlock();
      }
    }
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    String str = this.c.hanleShengpiziGrayTips(paramMessageRecord.msg, this.h.a, this.h.b);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("s :");
      localStringBuilder.append(str);
      QLog.d("addQQWalletTips", 2, localStringBuilder.toString());
    }
    if (!TextUtils.isEmpty(str)) {
      ThreadManager.getUIHandler().post(new QWalletAIOLifeCycleHelper.5(this, paramMessageRecord, str));
    }
  }
  
  public void a(String paramString)
  {
    LinearLayout localLinearLayout = this.i;
    if ((localLinearLayout != null) && (localLinearLayout.getVisibility() == 0) && (!StringUtil.isEmpty(this.o)) && (this.o.equals(paramString))) {
      a();
    }
  }
  
  public void a(String paramString, ChatActivityFacade.SendMsgParams paramSendMsgParams, int paramInt)
  {
    paramString = a(paramString, paramInt);
    if ((paramString != null) && (paramString.length == 4))
    {
      paramSendMsgParams.q = ((Integer)paramString[0]).intValue();
      paramSendMsgParams.p = ((Long)paramString[1]).longValue();
      if ((paramString[2] != null) && (PasswdRedBagFoldManager.a(this.d, this.h.a, this.h.b)))
      {
        paramSendMsgParams.r = ((String)paramString[2]);
        paramSendMsgParams.s = ((String)paramString[3]);
        paramSendMsgParams.t = ((PasswdRedBagFoldManager)this.d.getManager(QQManagerFactory.PASSWD_RED_BAG_FOLD_MANAGER)).a(this.h.b, this.h.a, paramSendMsgParams.r, paramSendMsgParams.s).booleanValue();
      }
      if (QLog.isColorLevel()) {
        QLog.d("msgFold", 2, String.format("Send, get RedBagId, friendUin: %s, senderUin: %d, redBagFlag: %d, foldFlag: %s, redBagId: %s, redBagIndex: %s", new Object[] { this.h.b, Long.valueOf(paramSendMsgParams.p), Integer.valueOf(paramSendMsgParams.q), Boolean.valueOf(paramSendMsgParams.t), paramSendMsgParams.r, paramSendMsgParams.s }));
      }
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    LinearLayout localLinearLayout = this.i;
    if ((localLinearLayout != null) && (this.j != null) && (localLinearLayout.getVisibility() == 0) && (!StringUtil.isEmpty(this.o)) && (this.o.equals(paramString1)))
    {
      this.o = paramString1;
      this.p = paramString2;
      this.j.setText(paramString2);
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    QWalletAIOLifeCycleHelper.3 local3 = new QWalletAIOLifeCycleHelper.3(this);
    if (paramInt == 3)
    {
      a(paramString1, this.c.getLastIdiom(paramString2), "回复下一句参与接龙", local3, true);
      return;
    }
    a(paramString1, this.c.getLastIdiomPinyin(paramString2), paramInt, local3);
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    a(paramString1, paramString2, paramString3, new QWalletAIOLifeCycleHelper.2(this, paramString1, paramString2), false);
  }
  
  public void b()
  {
    String str = this.o;
    if ((str != null) && (str.equals("0"))) {
      a();
    }
  }
  
  public void b(String paramString1, String paramString2, String paramString3)
  {
    QWalletAIOLifeCycleHelper.4 local4 = new QWalletAIOLifeCycleHelper.4(this);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<font color=\"#C0976A\">回复“</font><font color=\"#FF2954\">");
    localStringBuilder.append(paramString2);
    localStringBuilder.append("</font><font color=\"#C0976A\">”的拼音</font>");
    paramString2 = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("<font color=\"#C0976A\">提示：</font><font color=\"#FF2954\">");
    localStringBuilder.append(paramString3);
    localStringBuilder.append("</font>");
    paramString3 = localStringBuilder.toString();
    this.n = this.g.U.getFirstVisiblePosition();
    this.o = paramString1;
    this.p = paramString3;
    paramString1 = this.m;
    if (paramString1 != null) {
      paramString1.setVisibility(0);
    }
    paramString1 = this.j;
    if (paramString1 != null)
    {
      paramString1.setTextSize(1, 12.0F);
      this.j.setText(Html.fromHtml(paramString3));
    }
    paramString1 = this.k;
    if (paramString1 != null)
    {
      paramString1.setTextSize(1, 12.0F);
      this.k.setText(Html.fromHtml(paramString2));
    }
    paramString1 = this.l;
    if (paramString1 != null) {
      paramString1.setVisibility(8);
    }
    paramString1 = this.j;
    if ((paramString1 != null) && (this.k != null))
    {
      paramString2 = this.i;
      if (paramString2 != null)
      {
        paramString2.removeView(paramString1);
        this.i.removeView(this.k);
        this.i.addView(this.k, 0);
        this.i.addView(this.j, 2);
        this.i.setOrientation(1);
        this.i.setVisibility(0);
        this.i.bringToFront();
        this.i.setOnClickListener(local4);
      }
    }
    ((CopyPromptHelper)this.g.q(19)).a();
  }
  
  public boolean c()
  {
    LinearLayout localLinearLayout = this.i;
    return (localLinearLayout != null) && (localLinearLayout.getVisibility() == 0);
  }
  
  public String getTag()
  {
    return "QWalletAIOLifeCycleHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 4, 9, 15, 7, 11 };
  }
  
  public void onMoveToState(int paramInt)
  {
    if (paramInt == 4)
    {
      a(this.b);
      return;
    }
    if (paramInt == 9)
    {
      StringBuilder localStringBuilder;
      try
      {
        if ((this.c != null) && (this.c.isFirstInAio()) && ((this.h.a == 1) || (this.h.a == 1004))) {
          this.c.fetchNewestIdomRedbagWordWhenFirstEnterAIO(this.h);
        }
      }
      catch (Throwable localThrowable1)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("fetchNewestIdomRedbagWordWhenFirstEnterAIO throw an exception: ");
        localStringBuilder.append(localThrowable1);
        QLog.e("QWalletAIOLifeCycleHelper", 1, localStringBuilder.toString());
      }
      try
      {
        this.j = ((TextView)this.g.aZ.findViewById(2131430643));
        this.l = new TextView(this.e);
        this.l.setTextColor(-16777216);
        this.l.setTextSize(1, 12.0F);
        this.k = ((TextView)this.g.aZ.findViewById(2131430645));
        float f1 = this.j.getPaint().measureText(HardCodeUtil.a(2131909024));
        this.j.setMaxWidth((int)(f1 * 9.0F + 0.5F));
        this.m = this.g.aZ.findViewById(2131430526);
        this.i = ((LinearLayout)this.g.aZ.findViewById(2131430644));
        this.i.addView(this.l);
        this.l.getLayoutParams().width = -2;
        this.l.getLayoutParams().height = -2;
      }
      catch (Throwable localThrowable2)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("init ui throw an exception: ");
        localStringBuilder.append(localThrowable2);
        QLog.e("QWalletAIOLifeCycleHelper", 1, localStringBuilder.toString());
      }
      try
      {
        if (!(this.g instanceof PublicAccountChatPie)) {
          return;
        }
        if ("3046055438".equals(this.g.ah.b))
        {
          ((IQQFloatingWindowBroadcast)QRoute.api(IQQFloatingWindowBroadcast.class)).sendWindowVisibleBroadcast(BaseApplicationImpl.getContext(), false, 54);
          return;
        }
        if (!"2711679534".equals(this.g.ah.b)) {
          return;
        }
        ((IQWalletGdtAdApi)QRoute.api(IQWalletGdtAdApi.class)).checkReportTailAdShow();
        ReportController.b(this.d, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "public.aio.click", 0, 0, "", "", "", "");
        a(this.d);
        return;
      }
      catch (Throwable localThrowable3)
      {
        QLog.e("QWalletAIOLifeCycleHelper", 1, localThrowable3, new Object[0]);
        return;
      }
    }
    else if (paramInt == 15)
    {
      ((IGameShareUtil)QRoute.api(IGameShareUtil.class)).releaseCache();
      try
      {
        if ((this.g instanceof PublicAccountChatPie)) {
          if ("3046055438".equals(this.g.ah.b)) {
            ((IQQFloatingWindowBroadcast)QRoute.api(IQQFloatingWindowBroadcast.class)).sendWindowVisibleBroadcast(BaseApplicationImpl.getContext(), true, 54);
          } else if (((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).isQWalletPubAccount(this.g.ah)) {
            ((IQWalletGdtAdApi)QRoute.api(IQWalletGdtAdApi.class)).handleWhenPubQuit(this.f);
          }
        }
      }
      catch (Throwable localThrowable4)
      {
        QLog.e("QWalletAIOLifeCycleHelper", 1, localThrowable4, new Object[0]);
      }
      try
      {
        if ((this.i != null) && (this.l != null))
        {
          this.i.removeView(this.l);
          this.l = null;
        }
      }
      catch (Throwable localThrowable5)
      {
        QLog.e("QWalletAIOLifeCycleHelper", 1, QLog.getStackTraceString(localThrowable5));
      }
      QQAppInterface localQQAppInterface = this.d;
      if (localQQAppInterface != null) {
        localQQAppInterface.removeObserver(this.b);
      }
    }
    else if (paramInt == 7)
    {
      if (((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).isQWalletPubAccount(this.g.ah)) {
        ((IQWalletGdtAdApi)QRoute.api(IQWalletGdtAdApi.class)).handleWhenPubResume();
      }
    }
    else if (paramInt == 11)
    {
      if (((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).isQWalletPubAccount(this.g.ah)) {
        ((IQWalletGdtAdApi)QRoute.api(IQWalletGdtAdApi.class)).handleWhenPubPause();
      }
    }
    else if (paramInt == 13)
    {
      a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.QWalletAIOLifeCycleHelper
 * JD-Core Version:    0.7.0.1
 */