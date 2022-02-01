package com.tencent.mobileqq.activity.aio.audiopanel;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie.SaveInputTypeTask;
import com.tencent.mobileqq.activity.aio.panel.PanelManager;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.VoiceChangeHandler;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.NoC2CExtensionInfo;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.ptt.IPttVoiceChangePreSender;
import com.tencent.mobileqq.pttlogic.api.IPttPreSendService;
import com.tencent.mobileqq.qqaudio.QQAudioUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.RecordParams.RecorderParam;
import com.tencent.mobileqq.vas.VasH5PayUtil;
import com.tencent.mobileqq.vas.updatesystem.VasUpdateUtil;
import com.tencent.mobileqq.vas.updatesystem.api.IVasQuickUpdateService;
import com.tencent.mobileqq.vas.updatesystem.callback.CallBacker;
import com.tencent.mobileqq.voicechange.IVoiceChangeListener;
import com.tencent.mobileqq.voicechange.IVoiceChangeManager;
import com.tencent.mobileqq.voicechange.IVoiceTuneUtil;
import com.tencent.mobileqq.voicechange.VoiceChangeBasicParams;
import com.tencent.mobileqq.voicechange.VoiceChangeData;
import com.tencent.mobileqq.voicechange.VoiceChangeData.IconData;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ListView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class ListenChangeVoicePanel
  extends RelativeLayout
  implements DialogInterface.OnClickListener, View.OnClickListener, AudioPanelCallback, IVoiceChangeListener
{
  public static String[] a = { HardCodeUtil.a(2131904110), HardCodeUtil.a(2131904115), HardCodeUtil.a(2131904093), HardCodeUtil.a(2131904111), HardCodeUtil.a(2131904109), HardCodeUtil.a(2131904085), HardCodeUtil.a(2131904072), HardCodeUtil.a(2131904108), HardCodeUtil.a(2131904092), HardCodeUtil.a(2131904094), HardCodeUtil.a(2131904080), HardCodeUtil.a(2131904067), HardCodeUtil.a(2131904078), HardCodeUtil.a(2131904099), HardCodeUtil.a(2131904069), HardCodeUtil.a(2131904097), HardCodeUtil.a(2131904083) };
  public static String[] b = { HardCodeUtil.a(2131904098), HardCodeUtil.a(2131904077), HardCodeUtil.a(2131904073), HardCodeUtil.a(2131904112), HardCodeUtil.a(2131904079), HardCodeUtil.a(2131904091), HardCodeUtil.a(2131904075), HardCodeUtil.a(2131904113), HardCodeUtil.a(2131904081), HardCodeUtil.a(2131904074), HardCodeUtil.a(2131904100), HardCodeUtil.a(2131904102), HardCodeUtil.a(2131904084), HardCodeUtil.a(2131904071), HardCodeUtil.a(2131904068), HardCodeUtil.a(2131904105), HardCodeUtil.a(2131904104) };
  public static int[] c = { 2130838390, 2130838389, 2130838392, 2130838391, 2130838388, 2130838387, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
  public static volatile IPttVoiceChangePreSender l = null;
  public static boolean n;
  private int A = -1;
  private int[] B = new int[IVoiceTuneUtil.VOICE_TYPES.length];
  private VoiceChangeBasicParams C;
  public WeakReference<BaseChatPie> d;
  ArrayList<VoiceChangeData> e = new ArrayList();
  ArrayList<VoiceChangeData> f = new ArrayList();
  ChangeVoiceView g;
  ChangeVoiceListAdapter h;
  ListView i;
  Handler j = new ListenChangeVoicePanel.1(this, Looper.getMainLooper());
  boolean k;
  CallBacker m = new ListenChangeVoicePanel.3(this);
  boolean o;
  Bundle p;
  protected String q = "mvip.gxh.android.changevoice_";
  QQProgressDialog r;
  private volatile int s = -1;
  private WeakReference<QQAppInterface> t;
  private ViewGroup u;
  private TextView v;
  private TextView w;
  private String x;
  private double y;
  private RecordParams.RecorderParam z;
  
  public ListenChangeVoicePanel(Context paramContext)
  {
    super(paramContext);
  }
  
  public ListenChangeVoicePanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private int getChoosedCount()
  {
    int i1 = 0;
    int i3;
    for (int i2 = 0;; i2 = i3)
    {
      int[] arrayOfInt = this.B;
      if (i1 >= arrayOfInt.length) {
        break;
      }
      i3 = i2;
      if (arrayOfInt[i1] == 1)
      {
        i3 = i2 + 1;
        arrayOfInt[i1] = 0;
      }
      i1 += 1;
    }
    return i2;
  }
  
  public void a()
  {
    if (this.s == -1) {
      ThreadManager.getSubThreadHandler().post(new ListenChangeVoicePanel.4(this));
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i1 = paramInt1;
    Object localObject1 = this.d;
    if ((localObject1 != null) && (((WeakReference)localObject1).get() != null) && (((BaseChatPie)this.d.get()).ah != null))
    {
      localObject1 = this.t;
      if ((localObject1 != null) && (((WeakReference)localObject1).get() != null))
      {
        localObject1 = ((BaseChatPie)this.d.get()).bq();
        paramInt1 = 2;
        int i2;
        if (((AudioPanelProvider)((PanelManager)localObject1).f(2)).b) {
          i2 = 1;
        } else {
          i2 = 2;
        }
        if (((BaseChatPie)this.d.get()).ah.a == 0) {
          paramInt1 = 1;
        } else if (((BaseChatPie)this.d.get()).ah.a != 3000) {
          if (((BaseChatPie)this.d.get()).ah.a == 1) {
            paramInt1 = 3;
          } else {
            paramInt1 = 4;
          }
        }
        localObject1 = (AppRuntime)this.t.get();
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(paramInt3);
        ((StringBuilder)localObject2).append("");
        localObject2 = ((StringBuilder)localObject2).toString();
        Object localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(paramInt1);
        ((StringBuilder)localObject3).append("");
        ReportController.b((AppRuntime)localObject1, "CliOper", "", "", "0X8005474", "0X8005474", i2, 0, (String)localObject2, ((StringBuilder)localObject3).toString(), "", "8.8.17");
        if ((this.d.get() instanceof PublicAccountChatPie)) {
          ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate((AppInterface)this.t.get(), "P_CliOper", "Pb_account_lifeservice", "", "0X8005851", "0X8005851", 0, 0, "", "", "", "", false);
        }
        paramInt1 = Calendar.getInstance().get(11);
        localObject1 = ((FriendsManager)((QQAppInterface)this.t.get()).getManager(QQManagerFactory.FRIENDS_MANAGER)).g(((QQAppInterface)this.t.get()).getCurrentAccountUin());
        localObject2 = StatisticCollector.getInstance(super.getContext());
        localObject3 = new HashMap();
        ((HashMap)localObject3).put("gender", String.valueOf(((Card)localObject1).shGender));
        ((HashMap)localObject3).put("age", String.valueOf(((Card)localObject1).age));
        ((HashMap)localObject3).put("time", String.valueOf(paramInt1));
        ((HashMap)localObject3).put("extra", String.valueOf(paramInt4));
        paramInt1 = i1;
        if (paramInt2 == i1) {
          paramInt1 = i1 + 10;
        }
        ((HashMap)localObject3).put("param_FailCode", String.valueOf(paramInt1));
        ((HashMap)localObject3).put(BaseConstants.RDM_NoChangeFailCode, "");
        ((StatisticCollector)localObject2).collectPerformance("", "VCPttSendEvent", false, 0L, 0L, (HashMap)localObject3, "");
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2, Object paramObject, boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("VoiceChangeObserver type=");
        ((StringBuilder)localObject1).append(paramInt1);
        ((StringBuilder)localObject1).append(", ret=");
        ((StringBuilder)localObject1).append(paramInt2);
        ((StringBuilder)localObject1).append(", fromUiThread-f:");
        ((StringBuilder)localObject1).append(paramBoolean);
        QLog.d("ListenChangeVoicePanel", 2, ((StringBuilder)localObject1).toString());
      }
      localObject1 = this.j;
      ((Handler)localObject1).sendMessage(Message.obtain((Handler)localObject1, 107, paramInt1, paramInt2, paramObject));
      return;
    }
    a(false, 0);
    Object localObject1 = (Bundle)paramObject;
    this.o = false;
    int i2 = ((Bundle)localObject1).getInt("callId", 0);
    paramObject = ((Bundle)localObject1).getString("message");
    String str = ((Bundle)localObject1).getString("svr_url");
    Object localObject2 = ((Bundle)localObject1).getString("svr_actStr");
    int i1 = 4;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("VoiceChangeObserver type=");
      ((StringBuilder)localObject1).append(paramInt1);
      ((StringBuilder)localObject1).append(", ret=");
      ((StringBuilder)localObject1).append(paramInt2);
      ((StringBuilder)localObject1).append(", fromUiThread:");
      ((StringBuilder)localObject1).append(paramBoolean);
      QLog.d("ListenChangeVoicePanel", 2, ((StringBuilder)localObject1).toString());
    }
    if (paramInt2 != 0)
    {
      if (paramInt2 != 2002)
      {
        if (paramInt2 != 3002)
        {
          if (paramInt2 != 4002)
          {
            if (paramInt2 != 5002)
            {
              if (paramInt2 != 6002)
              {
                if (paramInt2 != 7002)
                {
                  if (paramInt2 != 8002)
                  {
                    if (paramInt2 != 21001)
                    {
                      if (paramInt2 != 22001)
                      {
                        localObject1 = paramObject;
                        break label590;
                      }
                      localObject1 = paramObject;
                      if (!TextUtils.isEmpty(paramObject)) {
                        break label590;
                      }
                      paramObject = HardCodeUtil.a(2131904076);
                    }
                    else
                    {
                      localObject1 = paramObject;
                      if (!TextUtils.isEmpty(paramObject)) {
                        break label590;
                      }
                      paramObject = HardCodeUtil.a(2131904101);
                    }
                  }
                  else
                  {
                    localObject1 = paramObject;
                    if (TextUtils.isEmpty(paramObject)) {
                      localObject1 = HardCodeUtil.a(2131904088);
                    }
                    this.o = true;
                    break label590;
                  }
                }
                else
                {
                  localObject1 = paramObject;
                  if (TextUtils.isEmpty(paramObject)) {
                    localObject1 = HardCodeUtil.a(2131904106);
                  }
                  this.o = true;
                  break label590;
                }
              }
              else
              {
                localObject1 = paramObject;
                if (TextUtils.isEmpty(paramObject)) {
                  localObject1 = HardCodeUtil.a(2131904090);
                }
                this.o = true;
                break label590;
              }
            }
            else
            {
              localObject1 = paramObject;
              if (TextUtils.isEmpty(paramObject)) {
                localObject1 = HardCodeUtil.a(2131904096);
              }
              paramObject = localObject2;
              if (TextUtils.isEmpty((CharSequence)localObject2)) {
                paramObject = HardCodeUtil.a(2131904082);
              }
              this.o = true;
              localObject2 = localObject1;
              paramInt1 = 2;
              localObject1 = paramObject;
              paramObject = localObject2;
              break label600;
            }
          }
          else
          {
            localObject1 = paramObject;
            if (TextUtils.isEmpty(paramObject)) {
              localObject1 = HardCodeUtil.a(2131904107);
            }
            paramObject = localObject2;
            if (TextUtils.isEmpty((CharSequence)localObject2)) {
              paramObject = HardCodeUtil.a(2131904089);
            }
            this.o = true;
            localObject2 = localObject1;
            paramInt1 = 1;
            localObject1 = paramObject;
            paramObject = localObject2;
            break label600;
          }
        }
        else
        {
          localObject1 = paramObject;
          if (!TextUtils.isEmpty(paramObject)) {
            break label590;
          }
          paramObject = HardCodeUtil.a(2131904086);
        }
      }
      else
      {
        localObject1 = paramObject;
        if (!TextUtils.isEmpty(paramObject)) {
          break label590;
        }
        paramObject = HardCodeUtil.a(2131904070);
      }
      localObject1 = localObject2;
      paramInt1 = i1;
      break label600;
      label590:
      paramObject = localObject1;
      paramInt1 = i1;
      localObject1 = localObject2;
      label600:
      if (paramInt2 != 0)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("VoiceChangeObserver fail, ret=");
        ((StringBuilder)localObject2).append(paramInt2);
        ((StringBuilder)localObject2).append(", msg=");
        ((StringBuilder)localObject2).append(paramObject);
        QLog.d("ListenChangeVoicePanel", 1, ((StringBuilder)localObject2).toString());
        if ((!TextUtils.isEmpty(str)) && (TextUtils.isEmpty((CharSequence)localObject1))) {
          localObject1 = HardCodeUtil.a(2131904087);
        }
        a(paramInt1, i2, null, paramObject, null, (String)localObject1, str);
        if ((this.o) && (this.t.get() != null))
        {
          paramObject = (AppRuntime)this.t.get();
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("");
          ((StringBuilder)localObject1).append(this.s);
          ReportController.b(paramObject, "CliOper", "", "", "changevoice", "0X8006F45", 0, 0, ((StringBuilder)localObject1).toString(), "", "", "");
        }
      }
      return;
    }
    paramObject = this.j;
    paramObject.sendMessage(Message.obtain(paramObject, 106, null));
  }
  
  public void a(QQAppInterface arg1, BaseChatPie paramBaseChatPie, ViewGroup paramViewGroup)
  {
    this.t = new WeakReference(???);
    this.d = new WeakReference(paramBaseChatPie);
    this.u = paramViewGroup;
    this.v = ((TextView)super.findViewById(2131437322));
    this.w = ((TextView)super.findViewById(2131437325));
    this.v.setOnClickListener(this);
    this.w.setOnClickListener(this);
    if (AppSetting.e)
    {
      ??? = this.v;
      paramBaseChatPie = new StringBuilder();
      paramBaseChatPie.append(this.v.getText());
      paramBaseChatPie.append(super.getContext().getString(2131888061));
      ???.setContentDescription(paramBaseChatPie.toString());
      ??? = this.w;
      paramBaseChatPie = new StringBuilder();
      paramBaseChatPie.append(this.w.getText());
      paramBaseChatPie.append(super.getContext().getString(2131888061));
      ???.setContentDescription(paramBaseChatPie.toString());
    }
    this.i = ((ListView)super.findViewById(2131435253));
    this.h = new ChangeVoiceListAdapter(super.getContext());
    ??? = this.h;
    ???.d = this;
    this.i.setAdapter(???);
    int i2;
    label371:
    synchronized (this.e)
    {
      if (this.e.size() < IVoiceTuneUtil.VOICE_TYPES.length)
      {
        int i1 = 0;
        while (i1 < IVoiceTuneUtil.VOICE_TYPES.length)
        {
          paramBaseChatPie = this.e;
          int i3 = IVoiceTuneUtil.VOICE_TYPES[i1];
          paramViewGroup = a[i1];
          String str = b[i1];
          if (i1 < 6) {
            break label371;
          }
          i2 = 0;
          paramBaseChatPie.add(new VoiceChangeData(i3, paramViewGroup, str, 0, i2, 1, new VoiceChangeData.IconData(c[i1], null, null, null)));
          i1 += 1;
        }
      }
      ThreadManager.post(new ListenChangeVoicePanel.2(this), 8, null, true);
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.t.get() == null) {
      return;
    }
    ??? = VasUpdateUtil.a((AppRuntime)this.t.get(), "changeVoice_json", paramBoolean ^ true, this.m);
    if (??? != null)
    {
      boolean bool = ((IVoiceChangeManager)QRoute.api(IVoiceChangeManager.class)).preCheckData(this.e, (JSONObject)???, (AppRuntime)this.t.get());
      if (QLog.isColorLevel())
      {
        ??? = new StringBuilder();
        ((StringBuilder)???).append("initVoiceDatas startDownload json.isLoaded=");
        ((StringBuilder)???).append(paramBoolean);
        ((StringBuilder)???).append(", isChecked=");
        ((StringBuilder)???).append(bool);
        QLog.d("ListenChangeVoicePanel", 2, ((StringBuilder)???).toString());
      }
    }
    else if ((QLog.isColorLevel()) || (paramBoolean))
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("initVoiceDatas null=xydata startDownload json. isLoaded=");
      ((StringBuilder)???).append(paramBoolean);
      QLog.d("ListenChangeVoicePanel", 2, ((StringBuilder)???).toString());
    }
    int i1;
    synchronized (this.f)
    {
      this.f.clear();
      i1 = this.e.size() - 1;
      if (i1 >= 0)
      {
        VoiceChangeData localVoiceChangeData = (VoiceChangeData)this.e.get(i1);
        if (localVoiceChangeData.d != 0) {
          if (6 > i1) {
            this.f.add(0, localVoiceChangeData);
          } else {
            this.f.add(localVoiceChangeData);
          }
        }
      }
      else
      {
        this.j.sendMessage(Message.obtain(this.j, 101, null));
        return;
      }
    }
  }
  
  void a(boolean paramBoolean, int paramInt)
  {
    QQProgressDialog localQQProgressDialog;
    if (paramBoolean)
    {
      if ((this.r == null) && (this.d.get() != null))
      {
        this.r = new QQProgressDialog(((BaseChatPie)this.d.get()).aX(), AIOUtils.b(50.0F, super.getResources()));
        this.r.setCancelable(true);
      }
      localQQProgressDialog = this.r;
      if (localQQProgressDialog != null)
      {
        localQQProgressDialog.c(paramInt);
        this.r.show();
      }
    }
    else
    {
      localQQProgressDialog = this.r;
      if ((localQQProgressDialog != null) && (localQQProgressDialog.isShowing())) {
        this.r.dismiss();
      }
    }
  }
  
  boolean a(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.p = new Bundle();
    this.p.putInt("funcType", paramInt1);
    this.p.putString("url", paramString5);
    this.p.putInt("fcID", paramInt2);
    paramString5 = paramString1;
    if (TextUtils.isEmpty(paramString1)) {
      paramString5 = HardCodeUtil.a(2131904114);
    }
    paramString1 = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      paramString1 = HardCodeUtil.a(2131904103);
    }
    paramString2 = paramString3;
    if (TextUtils.isEmpty(paramString3)) {
      paramString2 = HardCodeUtil.a(2131898212);
    }
    paramString3 = paramString4;
    if (TextUtils.isEmpty(paramString4)) {
      paramString3 = HardCodeUtil.a(2131899883);
    }
    if (QLog.isColorLevel())
    {
      paramString4 = new StringBuilder();
      paramString4.append("showTips content=");
      paramString4.append(paramString1);
      paramString4.append(", title=");
      paramString4.append(paramString5);
      QLog.d("ListenChangeVoicePanel", 1, paramString4.toString());
    }
    if (this.d.get() != null)
    {
      paramString1 = DialogUtil.a(((BaseChatPie)this.d.get()).aX(), 0, paramString5, paramString1, paramString2, paramString3, this, this);
      if (paramString1 != null)
      {
        paramString1.show();
        return true;
      }
    }
    return false;
  }
  
  public boolean b()
  {
    boolean bool = QLog.isColorLevel();
    int i1 = 2;
    if (bool)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("ListenPanel.onBackEvent() is called,audioPath is:");
      ((StringBuilder)localObject).append(this.x);
      QLog.d("AIOAudioPanel", 2, ((StringBuilder)localObject).toString());
    }
    setVisibility(8);
    Object localObject = (PressToChangeVoicePanel)this.u.findViewById(2131440604);
    ((PressToChangeVoicePanel)localObject).g();
    ((PressToChangeVoicePanel)localObject).setVisibility(0);
    localObject = this.d;
    if ((localObject != null) && (((WeakReference)localObject).get() != null))
    {
      ((AudioPanelAioHelper)((BaseChatPie)this.d.get()).q(128)).a(this.x, null);
      ((IVoiceChangeManager)QRoute.api(IVoiceChangeManager.class)).requestToCancel(this.C);
      if (((AudioPanelProvider)((BaseChatPie)this.d.get()).bq().f(2)).b) {
        i1 = 1;
      }
    }
    else
    {
      i1 = 0;
    }
    localObject = this.t;
    if ((localObject != null) && (((WeakReference)localObject).get() != null))
    {
      ReportController.b((AppRuntime)this.t.get(), "CliOper", "", "", "0X8005475", "0X8005475", i1, 0, "", "", "", "8.8.17");
      if (l != null) {
        l.a((AppRuntime)this.t.get(), -1);
      }
      ((IPttPreSendService)((QQAppInterface)this.t.get()).getRuntimeService(IPttPreSendService.class)).doOnCancelSend();
    }
    return false;
  }
  
  public void c()
  {
    ((IVoiceChangeManager)QRoute.api(IVoiceChangeManager.class)).requestToPause(this.C);
    ChangeVoiceView localChangeVoiceView = this.g;
    if (localChangeVoiceView != null) {
      localChangeVoiceView.a(1);
    }
  }
  
  public void d()
  {
    Object localObject1 = this.t;
    if ((localObject1 != null) && (((WeakReference)localObject1).get() != null)) {
      ((IVasQuickUpdateService)((QQAppInterface)this.t.get()).getRuntimeService(IVasQuickUpdateService.class, "")).removeCallBacker(this.m);
    }
    if (this.x == null) {
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("ListenPanel.onBackEvent() is called,audioPath is:");
      ((StringBuilder)localObject1).append(this.x);
      QLog.d("AIOAudioPanel", 2, ((StringBuilder)localObject1).toString());
    }
    g();
    ((IVoiceChangeManager)QRoute.api(IVoiceChangeManager.class)).requestToCancel(this.C);
    localObject1 = this.d;
    if (localObject1 != null)
    {
      if (((WeakReference)localObject1).get() == null) {
        return;
      }
      ((AudioPanelAioHelper)((BaseChatPie)this.d.get()).q(128)).a(this.x, null);
      localObject1 = this.t;
      if ((localObject1 != null) && (((WeakReference)localObject1).get() != null))
      {
        localObject1 = (FriendsManager)((QQAppInterface)this.t.get()).getManager(QQManagerFactory.FRIENDS_MANAGER);
        boolean bool = ((BaseChatPie)this.d.get()).aJ();
        int i1 = 1;
        Object localObject2;
        if (!bool)
        {
          localObject2 = ((FriendsManager)localObject1).b(((BaseChatPie)this.d.get()).ah.b, ((BaseChatPie)this.d.get()).ah.a, false);
          localObject1 = localObject2;
          if (localObject2 != null)
          {
            localObject1 = localObject2;
            if (((NoC2CExtensionInfo)localObject2).pttChangeVoiceType != this.s)
            {
              ((NoC2CExtensionInfo)localObject2).pttChangeVoiceType = this.s;
              localObject1 = localObject2;
              break label358;
            }
          }
        }
        else
        {
          localObject2 = ((FriendsManager)localObject1).d(((BaseChatPie)this.d.get()).ah.b, false);
          localObject1 = localObject2;
          if (localObject2 != null)
          {
            localObject1 = localObject2;
            if (((ExtensionInfo)localObject2).pttChangeVoiceType != this.s)
            {
              ((ExtensionInfo)localObject2).pttChangeVoiceType = this.s;
              localObject1 = localObject2;
              break label358;
            }
          }
        }
        i1 = 0;
        label358:
        if ((i1 != 0) && (localObject1 != null)) {
          ThreadManager.getFileThreadHandler().post(new BaseChatPie.SaveInputTypeTask((Entity)localObject1, (QQAppInterface)this.t.get()));
        }
      }
      n = false;
    }
  }
  
  public void e()
  {
    this.A = this.s;
    if (this.s == -1) {
      this.s = 0;
    }
    ChangeVoiceView localChangeVoiceView = this.g;
    if (localChangeVoiceView != null) {
      localChangeVoiceView.a(1);
    }
    this.k = false;
  }
  
  public void f()
  {
    this.C.g = this.s;
    if (this.t.get() != null)
    {
      QQAudioUtils.a(BaseApplication.getContext(), true);
      ((IVoiceChangeManager)QRoute.api(IVoiceChangeManager.class)).requestToStart(((QQAppInterface)this.t.get()).getApp(), this.C, PressToChangeVoicePanel.p, this);
    }
  }
  
  public void g()
  {
    setVisibility(8);
    Object localObject = this.u;
    if (localObject != null)
    {
      localObject = (PressToChangeVoicePanel)((ViewGroup)localObject).findViewById(2131440604);
      ((PressToChangeVoicePanel)localObject).g();
      ((PressToChangeVoicePanel)localObject).setVisibility(0);
    }
    int i1 = 0;
    for (;;)
    {
      localObject = this.B;
      if (i1 >= localObject.length) {
        break;
      }
      localObject[i1] = 0;
      i1 += 1;
    }
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
    paramDialogInterface = this.p;
    if (paramDialogInterface == null) {
      return;
    }
    int i3 = paramDialogInterface.getInt("funcType", 4);
    paramDialogInterface = this.p.getString("url");
    Object localObject = this.p;
    int i2 = 0;
    int i4 = ((Bundle)localObject).getInt("fcID", 0);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("DialogInterface funcType=");
      ((StringBuilder)localObject).append(i3);
      ((StringBuilder)localObject).append(", url:");
      ((StringBuilder)localObject).append(paramDialogInterface);
      QLog.d("ListenChangeVoicePanel", 1, ((StringBuilder)localObject).toString());
    }
    int i1;
    if ((1 != i3) && (2 != i3))
    {
      i1 = i2;
      if (paramInt == 1)
      {
        i1 = i2;
        if (!TextUtils.isEmpty(paramDialogInterface))
        {
          i1 = i2;
          if (this.d.get() != null)
          {
            localObject = new Intent(((BaseChatPie)this.d.get()).aX(), QQBrowserActivity.class);
            ((Intent)localObject).putExtra("url", paramDialogInterface);
            ((Intent)localObject).putExtra("isShowAd", false);
            ((BaseChatPie)this.d.get()).aX().startActivity((Intent)localObject);
            i1 = 1;
          }
        }
      }
    }
    else
    {
      i1 = i2;
      if (paramInt == 1)
      {
        i1 = i2;
        if (this.t.get() != null)
        {
          i1 = i2;
          if (this.d.get() != null) {
            if (1 == i3)
            {
              paramDialogInterface = ((BaseChatPie)this.d.get()).aX();
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append(this.q);
              ((StringBuilder)localObject).append(i4);
              VasH5PayUtil.a(paramDialogInterface, ((StringBuilder)localObject).toString(), 3, "1450000515", "LTMCLUB", super.getResources().getString(2131892806), "voiceVip");
              i1 = i2;
            }
            else
            {
              paramDialogInterface = ((BaseChatPie)this.d.get()).aX();
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append(this.q);
              ((StringBuilder)localObject).append(i4);
              VasH5PayUtil.a(paramDialogInterface, ((StringBuilder)localObject).toString(), 3, "1450000516", "CJCLUBT", super.getResources().getString(2131916948), "voiceSvip");
              i1 = i2;
            }
          }
        }
      }
    }
    if ((this.o) && (this.t.get() != null))
    {
      paramDialogInterface = (AppRuntime)this.t.get();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append(paramInt);
      ReportController.b(paramDialogInterface, "CliOper", "", "", "changevoice", "0X8006F46", 0, 0, ((StringBuilder)localObject).toString(), "", "", "");
      if (paramInt == 1)
      {
        paramDialogInterface = (AppRuntime)this.t.get();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("");
        ((StringBuilder)localObject).append(i1);
        ReportController.b(paramDialogInterface, "CliOper", "", "", "changevoice", "0X8006F46", 0, 0, ((StringBuilder)localObject).toString(), "", "", "");
      }
    }
  }
  
  public void onClick(View paramView)
  {
    int i4 = paramView.getId();
    int i1 = -1;
    String str2 = null;
    String str1 = "";
    int i2 = 1;
    int i3 = 2;
    Object localObject1;
    Object localObject2;
    if (i4 == 2131437322)
    {
      localObject1 = this.g;
      if (localObject1 != null) {
        ((ChangeVoiceView)localObject1).a(1);
      }
      if (this.d.get() != null) {
        ((AudioPanelAioHelper)((BaseChatPie)this.d.get()).q(128)).a(this.x, null);
      }
      g();
      ((IVoiceChangeManager)QRoute.api(IVoiceChangeManager.class)).requestToCancel(this.C);
      if (this.d.get() != null)
      {
        if (((AudioPanelProvider)((BaseChatPie)this.d.get()).bq().f(2)).b) {
          i1 = 1;
        } else {
          i1 = 2;
        }
      }
      else {
        i1 = 0;
      }
      if (this.t.get() != null)
      {
        ReportController.b((AppRuntime)this.t.get(), "CliOper", "", "", "0X8005475", "0X8005475", i1, 0, "", "", "", "8.8.17");
        if ((this.d.get() != null) && ((this.d.get() instanceof PublicAccountChatPie))) {
          ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate((AppInterface)this.t.get(), "P_CliOper", "Pb_account_lifeservice", "", "0X8005852", "0X8005852", 0, 0, "", "", "", "", false);
        }
        ((IPttPreSendService)((QQAppInterface)this.t.get()).getRuntimeService(IPttPreSendService.class)).doOnCancelSend();
        if (l != null) {
          l.a((AppRuntime)this.t.get(), -1);
        }
      }
      i1 = 1;
    }
    else if (i4 == 2131437325)
    {
      if (this.s >= 6)
      {
        a(true, 2131896457);
        if (this.t.get() != null) {
          ((VoiceChangeHandler)((QQAppInterface)this.t.get()).getBusinessHandler(BusinessHandlerFactory.CHANGE_VOICE_HANDLER)).a(1, this.s, this);
        }
      }
      else
      {
        localObject1 = this.j;
        ((Handler)localObject1).sendMessage(Message.obtain((Handler)localObject1, 106, null));
      }
      i1 = 2;
    }
    else
    {
      this.k = true;
      if ((paramView instanceof ChangeVoiceView))
      {
        ChangeVoiceView localChangeVoiceView = (ChangeVoiceView)paramView;
        if ((localChangeVoiceView == null) || (localChangeVoiceView.g == null)) {
          break label1204;
        }
        if (2 == localChangeVoiceView.g.d)
        {
          i1 = localChangeVoiceView.d;
          this.h.c = i1;
          if (i1 != this.s)
          {
            if (this.g == null)
            {
              localObject1 = this.i;
              if ((localObject1 != null) && (((ListView)localObject1).getChildCount() > 0) && ((this.i.getChildAt(0) instanceof ViewGroup))) {
                localObject1 = (ViewGroup)this.i.getChildAt(0);
              } else {
                localObject1 = null;
              }
              localObject2 = str2;
              if (localObject1 != null)
              {
                localObject2 = str2;
                if (((ViewGroup)localObject1).getChildCount() > 0)
                {
                  localObject2 = str2;
                  if ((((ViewGroup)localObject1).getChildAt(0) instanceof ChangeVoiceView)) {
                    localObject2 = (ChangeVoiceView)((ViewGroup)localObject1).getChildAt(0);
                  }
                }
              }
              this.g = ((ChangeVoiceView)localObject2);
            }
            localObject1 = this.g;
            if ((localObject1 != null) && (localChangeVoiceView != localObject1)) {
              ((ChangeVoiceView)localObject1).a(0);
            }
            this.g = localChangeVoiceView;
            localChangeVoiceView.a(2);
            this.s = i1;
            f();
            if (this.d.get() != null)
            {
              i1 = i3;
              if (((AudioPanelProvider)((BaseChatPie)this.d.get()).bq().f(2)).b) {
                i1 = 1;
              }
            }
            else
            {
              i1 = 0;
            }
            if (this.t.get() != null)
            {
              localObject1 = (AppRuntime)this.t.get();
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append(this.s);
              ((StringBuilder)localObject2).append("");
              ReportController.b((AppRuntime)localObject1, "CliOper", "", "", "0X8005473", "0X8005473", i1, 0, ((StringBuilder)localObject2).toString(), "", "", "8.8.17");
            }
            this.B[this.s] = 1;
          }
          else if (localChangeVoiceView.getState() == 2)
          {
            localChangeVoiceView.a(1);
            ((IVoiceChangeManager)QRoute.api(IVoiceChangeManager.class)).requestToPause(this.C);
          }
          else if (localChangeVoiceView.getState() == 1)
          {
            f();
            localChangeVoiceView.a(2);
            if (this.d.get() != null)
            {
              if (((AudioPanelProvider)((BaseChatPie)this.d.get()).bq().f(2)).b) {
                i1 = i2;
              } else {
                i1 = 2;
              }
            }
            else {
              i1 = 0;
            }
            if (this.t.get() != null)
            {
              localObject1 = (AppRuntime)this.t.get();
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append(this.s);
              ((StringBuilder)localObject2).append("");
              ReportController.b((AppRuntime)localObject1, "CliOper", "", "", "0X8005473", "0X8005473", i1, 0, ((StringBuilder)localObject2).toString(), "", "", "8.8.17");
            }
          }
          else if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("CLICK EXCEPTION， curtype = ");
            ((StringBuilder)localObject1).append(this.s);
            ((StringBuilder)localObject1).append(" newtype is ");
            ((StringBuilder)localObject1).append(i1);
            ((StringBuilder)localObject1).append(" state is ");
            ((StringBuilder)localObject1).append(localChangeVoiceView.getState());
            QLog.e("changevoice", 2, ((StringBuilder)localObject1).toString());
          }
        }
        else
        {
          a(4, localChangeVoiceView.d, null, HardCodeUtil.a(2131904095), null, null, null);
        }
        i1 = 0;
      }
    }
    if ((i1 >= 0) && (this.t.get() != null))
    {
      localObject2 = (AppRuntime)this.t.get();
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("");
      ((StringBuilder)localObject1).append(i1);
      str2 = ((StringBuilder)localObject1).toString();
      localObject1 = str1;
      if (i1 == 0)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("");
        ((StringBuilder)localObject1).append(this.s);
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      ReportController.b((AppRuntime)localObject2, "CliOper", "", "", "changevoice", "0X8006F50", 0, 0, str2, (String)localObject1, "", "");
    }
    label1204:
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onError()
  {
    Handler localHandler = this.j;
    localHandler.sendMessage(Message.obtain(localHandler, 105, null));
    ((IVoiceChangeManager)QRoute.api(IVoiceChangeManager.class)).requestToPause(this.C);
    QQAudioUtils.a(BaseApplication.getContext(), false);
  }
  
  public void onPlayEnd()
  {
    Handler localHandler = this.j;
    localHandler.sendMessage(Message.obtain(localHandler, 104, null));
  }
  
  public void onPlayStop()
  {
    Handler localHandler = this.j;
    localHandler.sendMessage(Message.obtain(localHandler, 102, null));
    QQAudioUtils.a(BaseApplication.getContext(), false);
  }
  
  public void onSlicePlayed(int paramInt1, int paramInt2, int paramInt3)
  {
    paramInt1 = ((IAudioPanelUtils)QRoute.api(IAudioPanelUtils.class)).getVolumeLevel(paramInt1) / 1250;
    Bundle localBundle = new Bundle();
    localBundle.putInt("progress", paramInt2);
    localBundle.putInt("playTime", paramInt3);
    localBundle.putInt("level", paramInt1);
    Handler localHandler = this.j;
    localHandler.sendMessage(Message.obtain(localHandler, 103, localBundle));
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    super.onTouchEvent(paramMotionEvent);
    return true;
  }
  
  public void setAudioPath(String paramString, double paramDouble, RecordParams.RecorderParam paramRecorderParam)
  {
    this.x = paramString;
    this.y = paramDouble;
    this.z = paramRecorderParam;
    this.C = new VoiceChangeBasicParams(this.x, this.z.a, this.z.b, this.z.c, this.s);
    if (AppSetting.e) {
      AccessibilityUtil.a(this.g);
    }
  }
  
  public void setVisibility(int paramInt)
  {
    boolean bool;
    if (paramInt == 0) {
      bool = true;
    } else {
      bool = false;
    }
    n = bool;
    super.setVisibility(paramInt);
    if ((n) && (this.t.get() != null)) {
      ReportController.b((AppRuntime)this.t.get(), "CliOper", "", "", "changevoice", "0X8006F4F", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.ListenChangeVoicePanel
 * JD-Core Version:    0.7.0.1
 */