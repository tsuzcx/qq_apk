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
  public static volatile IPttVoiceChangePreSender a;
  public static int[] a;
  public static String[] a;
  public static boolean b;
  public static String[] b;
  private double jdField_a_of_type_Double;
  private volatile int jdField_a_of_type_Int = -1;
  Bundle jdField_a_of_type_AndroidOsBundle;
  Handler jdField_a_of_type_AndroidOsHandler = new ListenChangeVoicePanel.1(this, Looper.getMainLooper());
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  ChangeVoiceListAdapter jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelChangeVoiceListAdapter;
  ChangeVoiceView jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelChangeVoiceView;
  private RecordParams.RecorderParam jdField_a_of_type_ComTencentMobileqqUtilsRecordParams$RecorderParam;
  CallBacker jdField_a_of_type_ComTencentMobileqqVasUpdatesystemCallbackCallBacker = new ListenChangeVoicePanel.3(this);
  private VoiceChangeBasicParams jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeBasicParams;
  QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  ListView jdField_a_of_type_ComTencentWidgetListView;
  protected String a;
  public WeakReference<BaseChatPie> a;
  ArrayList<VoiceChangeData> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = -1;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private String jdField_b_of_type_JavaLangString;
  private WeakReference<QQAppInterface> jdField_b_of_type_JavaLangRefWeakReference;
  ArrayList<VoiceChangeData> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  private int[] jdField_b_of_type_ArrayOfInt = new int[IVoiceTuneUtil.VOICE_TYPES.length];
  boolean c;
  
  static
  {
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { HardCodeUtil.a(2131706244), HardCodeUtil.a(2131706249), HardCodeUtil.a(2131706226), HardCodeUtil.a(2131706245), HardCodeUtil.a(2131706243), HardCodeUtil.a(2131706217), HardCodeUtil.a(2131706204), HardCodeUtil.a(2131706242), HardCodeUtil.a(2131706225), HardCodeUtil.a(2131706227), HardCodeUtil.a(2131706212), HardCodeUtil.a(2131706199), HardCodeUtil.a(2131706210), HardCodeUtil.a(2131706233), HardCodeUtil.a(2131706201), HardCodeUtil.a(2131706230), HardCodeUtil.a(2131706215) };
    jdField_b_of_type_ArrayOfJavaLangString = new String[] { HardCodeUtil.a(2131706231), HardCodeUtil.a(2131706209), HardCodeUtil.a(2131706205), HardCodeUtil.a(2131706246), HardCodeUtil.a(2131706211), HardCodeUtil.a(2131706224), HardCodeUtil.a(2131706207), HardCodeUtil.a(2131706247), HardCodeUtil.a(2131706213), HardCodeUtil.a(2131706206), HardCodeUtil.a(2131706234), HardCodeUtil.a(2131706236), HardCodeUtil.a(2131706216), HardCodeUtil.a(2131706203), HardCodeUtil.a(2131706200), HardCodeUtil.a(2131706239), HardCodeUtil.a(2131706238) };
    jdField_a_of_type_ArrayOfInt = new int[] { 2130838341, 2130838340, 2130838343, 2130838342, 2130838339, 2130838338, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
    jdField_a_of_type_ComTencentMobileqqPttIPttVoiceChangePreSender = null;
  }
  
  public ListenChangeVoicePanel(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_JavaLangString = "mvip.gxh.android.changevoice_";
  }
  
  public ListenChangeVoicePanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_JavaLangString = "mvip.gxh.android.changevoice_";
  }
  
  private int a()
  {
    int i = 0;
    int k;
    for (int j = 0;; j = k)
    {
      int[] arrayOfInt = this.jdField_b_of_type_ArrayOfInt;
      if (i >= arrayOfInt.length) {
        break;
      }
      k = j;
      if (arrayOfInt[i] == 1)
      {
        k = j + 1;
        arrayOfInt[i] = 0;
      }
      i += 1;
    }
    return j;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Int == -1) {
      ThreadManager.getSubThreadHandler().post(new ListenChangeVoicePanel.4(this));
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = paramInt1;
    Object localObject1 = this.jdField_a_of_type_JavaLangRefWeakReference;
    if ((localObject1 != null) && (((WeakReference)localObject1).get() != null) && (((BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a != null))
    {
      localObject1 = this.jdField_b_of_type_JavaLangRefWeakReference;
      if ((localObject1 != null) && (((WeakReference)localObject1).get() != null))
      {
        localObject1 = ((BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a();
        paramInt1 = 2;
        int j;
        if (((AudioPanelProvider)((PanelManager)localObject1).a(2)).jdField_a_of_type_Boolean) {
          j = 1;
        } else {
          j = 2;
        }
        if (((BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a.jdField_a_of_type_Int == 0) {
          paramInt1 = 1;
        } else if (((BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a.jdField_a_of_type_Int != 3000) {
          if (((BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a.jdField_a_of_type_Int == 1) {
            paramInt1 = 3;
          } else {
            paramInt1 = 4;
          }
        }
        localObject1 = (AppRuntime)this.jdField_b_of_type_JavaLangRefWeakReference.get();
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(paramInt3);
        ((StringBuilder)localObject2).append("");
        localObject2 = ((StringBuilder)localObject2).toString();
        Object localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(paramInt1);
        ((StringBuilder)localObject3).append("");
        ReportController.b((AppRuntime)localObject1, "CliOper", "", "", "0X8005474", "0X8005474", j, 0, (String)localObject2, ((StringBuilder)localObject3).toString(), "", "8.7.0");
        if ((this.jdField_a_of_type_JavaLangRefWeakReference.get() instanceof PublicAccountChatPie)) {
          ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate((AppInterface)this.jdField_b_of_type_JavaLangRefWeakReference.get(), "P_CliOper", "Pb_account_lifeservice", "", "0X8005851", "0X8005851", 0, 0, "", "", "", "", false);
        }
        paramInt1 = Calendar.getInstance().get(11);
        localObject1 = ((FriendsManager)((QQAppInterface)this.jdField_b_of_type_JavaLangRefWeakReference.get()).getManager(QQManagerFactory.FRIENDS_MANAGER)).b(((QQAppInterface)this.jdField_b_of_type_JavaLangRefWeakReference.get()).getCurrentAccountUin());
        localObject2 = StatisticCollector.getInstance(super.getContext());
        localObject3 = new HashMap();
        ((HashMap)localObject3).put("gender", String.valueOf(((Card)localObject1).shGender));
        ((HashMap)localObject3).put("age", String.valueOf(((Card)localObject1).age));
        ((HashMap)localObject3).put("time", String.valueOf(paramInt1));
        ((HashMap)localObject3).put("extra", String.valueOf(paramInt4));
        paramInt1 = i;
        if (paramInt2 == i) {
          paramInt1 = i + 10;
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
      localObject1 = this.jdField_a_of_type_AndroidOsHandler;
      ((Handler)localObject1).sendMessage(Message.obtain((Handler)localObject1, 107, paramInt1, paramInt2, paramObject));
      return;
    }
    a(false, 0);
    Object localObject1 = (Bundle)paramObject;
    this.c = false;
    int j = ((Bundle)localObject1).getInt("callId", 0);
    paramObject = ((Bundle)localObject1).getString("message");
    String str = ((Bundle)localObject1).getString("svr_url");
    Object localObject2 = ((Bundle)localObject1).getString("svr_actStr");
    int i = 4;
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
                      paramObject = HardCodeUtil.a(2131706208);
                    }
                    else
                    {
                      localObject1 = paramObject;
                      if (!TextUtils.isEmpty(paramObject)) {
                        break label590;
                      }
                      paramObject = HardCodeUtil.a(2131706235);
                    }
                  }
                  else
                  {
                    localObject1 = paramObject;
                    if (TextUtils.isEmpty(paramObject)) {
                      localObject1 = HardCodeUtil.a(2131706221);
                    }
                    this.c = true;
                    break label590;
                  }
                }
                else
                {
                  localObject1 = paramObject;
                  if (TextUtils.isEmpty(paramObject)) {
                    localObject1 = HardCodeUtil.a(2131706240);
                  }
                  this.c = true;
                  break label590;
                }
              }
              else
              {
                localObject1 = paramObject;
                if (TextUtils.isEmpty(paramObject)) {
                  localObject1 = HardCodeUtil.a(2131706223);
                }
                this.c = true;
                break label590;
              }
            }
            else
            {
              localObject1 = paramObject;
              if (TextUtils.isEmpty(paramObject)) {
                localObject1 = HardCodeUtil.a(2131706229);
              }
              paramObject = localObject2;
              if (TextUtils.isEmpty((CharSequence)localObject2)) {
                paramObject = HardCodeUtil.a(2131706214);
              }
              this.c = true;
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
              localObject1 = HardCodeUtil.a(2131706241);
            }
            paramObject = localObject2;
            if (TextUtils.isEmpty((CharSequence)localObject2)) {
              paramObject = HardCodeUtil.a(2131706222);
            }
            this.c = true;
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
          paramObject = HardCodeUtil.a(2131706218);
        }
      }
      else
      {
        localObject1 = paramObject;
        if (!TextUtils.isEmpty(paramObject)) {
          break label590;
        }
        paramObject = HardCodeUtil.a(2131706202);
      }
      localObject1 = localObject2;
      paramInt1 = i;
      break label600;
      label590:
      paramObject = localObject1;
      paramInt1 = i;
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
          localObject1 = HardCodeUtil.a(2131706219);
        }
        a(paramInt1, j, null, paramObject, null, (String)localObject1, str);
        if ((this.c) && (this.jdField_b_of_type_JavaLangRefWeakReference.get() != null))
        {
          paramObject = (AppRuntime)this.jdField_b_of_type_JavaLangRefWeakReference.get();
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("");
          ((StringBuilder)localObject1).append(this.jdField_a_of_type_Int);
          ReportController.b(paramObject, "CliOper", "", "", "changevoice", "0X8006F45", 0, 0, ((StringBuilder)localObject1).toString(), "", "", "");
        }
      }
      return;
    }
    paramObject = this.jdField_a_of_type_AndroidOsHandler;
    paramObject.sendMessage(Message.obtain(paramObject, 106, null));
  }
  
  public void a(QQAppInterface arg1, BaseChatPie paramBaseChatPie, ViewGroup paramViewGroup)
  {
    this.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(???);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramBaseChatPie);
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131370158));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131370161));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    if (AppSetting.d)
    {
      ??? = this.jdField_a_of_type_AndroidWidgetTextView;
      paramBaseChatPie = new StringBuilder();
      paramBaseChatPie.append(this.jdField_a_of_type_AndroidWidgetTextView.getText());
      paramBaseChatPie.append(super.getContext().getString(2131691115));
      ???.setContentDescription(paramBaseChatPie.toString());
      ??? = this.jdField_b_of_type_AndroidWidgetTextView;
      paramBaseChatPie = new StringBuilder();
      paramBaseChatPie.append(this.jdField_b_of_type_AndroidWidgetTextView.getText());
      paramBaseChatPie.append(super.getContext().getString(2131691115));
      ???.setContentDescription(paramBaseChatPie.toString());
    }
    this.jdField_a_of_type_ComTencentWidgetListView = ((ListView)super.findViewById(2131368373));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelChangeVoiceListAdapter = new ChangeVoiceListAdapter(super.getContext());
    ??? = this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelChangeVoiceListAdapter;
    ???.a = this;
    this.jdField_a_of_type_ComTencentWidgetListView.setAdapter(???);
    int j;
    label371:
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      if (this.jdField_a_of_type_JavaUtilArrayList.size() < IVoiceTuneUtil.VOICE_TYPES.length)
      {
        int i = 0;
        while (i < IVoiceTuneUtil.VOICE_TYPES.length)
        {
          paramBaseChatPie = this.jdField_a_of_type_JavaUtilArrayList;
          int k = IVoiceTuneUtil.VOICE_TYPES[i];
          paramViewGroup = jdField_a_of_type_ArrayOfJavaLangString[i];
          String str = jdField_b_of_type_ArrayOfJavaLangString[i];
          if (i < 6) {
            break label371;
          }
          j = 0;
          paramBaseChatPie.add(new VoiceChangeData(k, paramViewGroup, str, 0, j, 1, new VoiceChangeData.IconData(jdField_a_of_type_ArrayOfInt[i], null, null, null)));
          i += 1;
        }
      }
      ThreadManager.post(new ListenChangeVoicePanel.2(this), 8, null, true);
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_b_of_type_JavaLangRefWeakReference.get() == null) {
      return;
    }
    ??? = VasUpdateUtil.a((AppRuntime)this.jdField_b_of_type_JavaLangRefWeakReference.get(), "changeVoice_json", paramBoolean ^ true, this.jdField_a_of_type_ComTencentMobileqqVasUpdatesystemCallbackCallBacker);
    if (??? != null)
    {
      boolean bool = ((IVoiceChangeManager)QRoute.api(IVoiceChangeManager.class)).preCheckData(this.jdField_a_of_type_JavaUtilArrayList, (JSONObject)???, (AppRuntime)this.jdField_b_of_type_JavaLangRefWeakReference.get());
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
    int i;
    synchronized (this.jdField_b_of_type_JavaUtilArrayList)
    {
      this.jdField_b_of_type_JavaUtilArrayList.clear();
      i = this.jdField_a_of_type_JavaUtilArrayList.size() - 1;
      if (i >= 0)
      {
        VoiceChangeData localVoiceChangeData = (VoiceChangeData)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        if (localVoiceChangeData.jdField_b_of_type_Int != 0) {
          if (6 > i) {
            this.jdField_b_of_type_JavaUtilArrayList.add(0, localVoiceChangeData);
          } else {
            this.jdField_b_of_type_JavaUtilArrayList.add(localVoiceChangeData);
          }
        }
      }
      else
      {
        this.jdField_a_of_type_AndroidOsHandler.sendMessage(Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 101, null));
        return;
      }
    }
  }
  
  void a(boolean paramBoolean, int paramInt)
  {
    QQProgressDialog localQQProgressDialog;
    if (paramBoolean)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null))
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(((BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(), AIOUtils.b(50.0F, super.getResources()));
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setCancelable(true);
      }
      localQQProgressDialog = this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
      if (localQQProgressDialog != null)
      {
        localQQProgressDialog.c(paramInt);
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
      }
    }
    else
    {
      localQQProgressDialog = this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
      if ((localQQProgressDialog != null) && (localQQProgressDialog.isShowing())) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      }
    }
  }
  
  public boolean a()
  {
    boolean bool = QLog.isColorLevel();
    int i = 2;
    if (bool)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("ListenPanel.onBackEvent() is called,audioPath is:");
      ((StringBuilder)localObject).append(this.jdField_b_of_type_JavaLangString);
      QLog.d("AIOAudioPanel", 2, ((StringBuilder)localObject).toString());
    }
    setVisibility(8);
    Object localObject = (PressToChangeVoicePanel)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131373025);
    ((PressToChangeVoicePanel)localObject).f();
    ((PressToChangeVoicePanel)localObject).setVisibility(0);
    localObject = this.jdField_a_of_type_JavaLangRefWeakReference;
    if ((localObject != null) && (((WeakReference)localObject).get() != null))
    {
      ((AudioPanelAioHelper)((BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(128)).a(this.jdField_b_of_type_JavaLangString, null);
      ((IVoiceChangeManager)QRoute.api(IVoiceChangeManager.class)).requestToCancel(this.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeBasicParams);
      if (((AudioPanelProvider)((BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a().a(2)).jdField_a_of_type_Boolean) {
        i = 1;
      }
    }
    else
    {
      i = 0;
    }
    localObject = this.jdField_b_of_type_JavaLangRefWeakReference;
    if ((localObject != null) && (((WeakReference)localObject).get() != null))
    {
      ReportController.b((AppRuntime)this.jdField_b_of_type_JavaLangRefWeakReference.get(), "CliOper", "", "", "0X8005475", "0X8005475", i, 0, "", "", "", "8.7.0");
      if (jdField_a_of_type_ComTencentMobileqqPttIPttVoiceChangePreSender != null) {
        jdField_a_of_type_ComTencentMobileqqPttIPttVoiceChangePreSender.a((AppRuntime)this.jdField_b_of_type_JavaLangRefWeakReference.get(), -1);
      }
      ((IPttPreSendService)((QQAppInterface)this.jdField_b_of_type_JavaLangRefWeakReference.get()).getRuntimeService(IPttPreSendService.class)).doOnCancelSend();
    }
    return false;
  }
  
  boolean a(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.jdField_a_of_type_AndroidOsBundle = new Bundle();
    this.jdField_a_of_type_AndroidOsBundle.putInt("funcType", paramInt1);
    this.jdField_a_of_type_AndroidOsBundle.putString("url", paramString5);
    this.jdField_a_of_type_AndroidOsBundle.putInt("fcID", paramInt2);
    paramString5 = paramString1;
    if (TextUtils.isEmpty(paramString1)) {
      paramString5 = HardCodeUtil.a(2131706248);
    }
    paramString1 = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      paramString1 = HardCodeUtil.a(2131706237);
    }
    paramString2 = paramString3;
    if (TextUtils.isEmpty(paramString3)) {
      paramString2 = HardCodeUtil.a(2131706232);
    }
    paramString3 = paramString4;
    if (TextUtils.isEmpty(paramString4)) {
      paramString3 = HardCodeUtil.a(2131706220);
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
    if (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)
    {
      paramString1 = DialogUtil.a(((BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(), 0, paramString5, paramString1, paramString2, paramString3, this, this);
      if (paramString1 != null)
      {
        paramString1.show();
        return true;
      }
    }
    return false;
  }
  
  public void b()
  {
    ((IVoiceChangeManager)QRoute.api(IVoiceChangeManager.class)).requestToPause(this.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeBasicParams);
    ChangeVoiceView localChangeVoiceView = this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelChangeVoiceView;
    if (localChangeVoiceView != null) {
      localChangeVoiceView.a(1);
    }
  }
  
  public void c()
  {
    Object localObject1 = this.jdField_b_of_type_JavaLangRefWeakReference;
    if ((localObject1 != null) && (((WeakReference)localObject1).get() != null)) {
      ((IVasQuickUpdateService)((QQAppInterface)this.jdField_b_of_type_JavaLangRefWeakReference.get()).getRuntimeService(IVasQuickUpdateService.class, "")).removeCallBacker(this.jdField_a_of_type_ComTencentMobileqqVasUpdatesystemCallbackCallBacker);
    }
    if (this.jdField_b_of_type_JavaLangString == null) {
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("ListenPanel.onBackEvent() is called,audioPath is:");
      ((StringBuilder)localObject1).append(this.jdField_b_of_type_JavaLangString);
      QLog.d("AIOAudioPanel", 2, ((StringBuilder)localObject1).toString());
    }
    f();
    ((IVoiceChangeManager)QRoute.api(IVoiceChangeManager.class)).requestToCancel(this.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeBasicParams);
    localObject1 = this.jdField_a_of_type_JavaLangRefWeakReference;
    if (localObject1 != null)
    {
      if (((WeakReference)localObject1).get() == null) {
        return;
      }
      ((AudioPanelAioHelper)((BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(128)).a(this.jdField_b_of_type_JavaLangString, null);
      localObject1 = this.jdField_b_of_type_JavaLangRefWeakReference;
      if ((localObject1 != null) && (((WeakReference)localObject1).get() != null))
      {
        localObject1 = (FriendsManager)((QQAppInterface)this.jdField_b_of_type_JavaLangRefWeakReference.get()).getManager(QQManagerFactory.FRIENDS_MANAGER);
        boolean bool = ((BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get()).h();
        int i = 1;
        Object localObject2;
        if (!bool)
        {
          localObject2 = ((FriendsManager)localObject1).a(((BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a.jdField_a_of_type_JavaLangString, ((BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a.jdField_a_of_type_Int, false);
          localObject1 = localObject2;
          if (localObject2 != null)
          {
            localObject1 = localObject2;
            if (((NoC2CExtensionInfo)localObject2).pttChangeVoiceType != this.jdField_a_of_type_Int)
            {
              ((NoC2CExtensionInfo)localObject2).pttChangeVoiceType = this.jdField_a_of_type_Int;
              localObject1 = localObject2;
              break label358;
            }
          }
        }
        else
        {
          localObject2 = ((FriendsManager)localObject1).a(((BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a.jdField_a_of_type_JavaLangString, false);
          localObject1 = localObject2;
          if (localObject2 != null)
          {
            localObject1 = localObject2;
            if (((ExtensionInfo)localObject2).pttChangeVoiceType != this.jdField_a_of_type_Int)
            {
              ((ExtensionInfo)localObject2).pttChangeVoiceType = this.jdField_a_of_type_Int;
              localObject1 = localObject2;
              break label358;
            }
          }
        }
        i = 0;
        label358:
        if ((i != 0) && (localObject1 != null)) {
          ThreadManager.getFileThreadHandler().post(new BaseChatPie.SaveInputTypeTask((Entity)localObject1, (QQAppInterface)this.jdField_b_of_type_JavaLangRefWeakReference.get()));
        }
      }
      jdField_b_of_type_Boolean = false;
    }
  }
  
  public void d()
  {
    this.jdField_b_of_type_Int = this.jdField_a_of_type_Int;
    if (this.jdField_a_of_type_Int == -1) {
      this.jdField_a_of_type_Int = 0;
    }
    ChangeVoiceView localChangeVoiceView = this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelChangeVoiceView;
    if (localChangeVoiceView != null) {
      localChangeVoiceView.a(1);
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeBasicParams.f = this.jdField_a_of_type_Int;
    if (this.jdField_b_of_type_JavaLangRefWeakReference.get() != null)
    {
      QQAudioUtils.a(BaseApplication.getContext(), true);
      ((IVoiceChangeManager)QRoute.api(IVoiceChangeManager.class)).requestToStart(((QQAppInterface)this.jdField_b_of_type_JavaLangRefWeakReference.get()).getApp(), this.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeBasicParams, PressToChangeVoicePanel.jdField_a_of_type_JavaLangString, this);
    }
  }
  
  public void f()
  {
    setVisibility(8);
    Object localObject = this.jdField_a_of_type_AndroidViewViewGroup;
    if (localObject != null)
    {
      localObject = (PressToChangeVoicePanel)((ViewGroup)localObject).findViewById(2131373025);
      ((PressToChangeVoicePanel)localObject).f();
      ((PressToChangeVoicePanel)localObject).setVisibility(0);
    }
    int i = 0;
    for (;;)
    {
      localObject = this.jdField_b_of_type_ArrayOfInt;
      if (i >= localObject.length) {
        break;
      }
      localObject[i] = 0;
      i += 1;
    }
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
    paramDialogInterface = this.jdField_a_of_type_AndroidOsBundle;
    if (paramDialogInterface == null) {
      return;
    }
    int k = paramDialogInterface.getInt("funcType", 4);
    paramDialogInterface = this.jdField_a_of_type_AndroidOsBundle.getString("url");
    Object localObject = this.jdField_a_of_type_AndroidOsBundle;
    int j = 0;
    int m = ((Bundle)localObject).getInt("fcID", 0);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("DialogInterface funcType=");
      ((StringBuilder)localObject).append(k);
      ((StringBuilder)localObject).append(", url:");
      ((StringBuilder)localObject).append(paramDialogInterface);
      QLog.d("ListenChangeVoicePanel", 1, ((StringBuilder)localObject).toString());
    }
    int i;
    if ((1 != k) && (2 != k))
    {
      i = j;
      if (paramInt == 1)
      {
        i = j;
        if (!TextUtils.isEmpty(paramDialogInterface))
        {
          i = j;
          if (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)
          {
            localObject = new Intent(((BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(), QQBrowserActivity.class);
            ((Intent)localObject).putExtra("url", paramDialogInterface);
            ((Intent)localObject).putExtra("isShowAd", false);
            ((BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a().startActivity((Intent)localObject);
            i = 1;
          }
        }
      }
    }
    else
    {
      i = j;
      if (paramInt == 1)
      {
        i = j;
        if (this.jdField_b_of_type_JavaLangRefWeakReference.get() != null)
        {
          i = j;
          if (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null) {
            if (1 == k)
            {
              paramDialogInterface = ((BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a();
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
              ((StringBuilder)localObject).append(m);
              VasH5PayUtil.a(paramDialogInterface, ((StringBuilder)localObject).toString(), 3, "1450000515", "LTMCLUB", super.getResources().getString(2131695078), "voiceVip");
              i = j;
            }
            else
            {
              paramDialogInterface = ((BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a();
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
              ((StringBuilder)localObject).append(m);
              VasH5PayUtil.a(paramDialogInterface, ((StringBuilder)localObject).toString(), 3, "1450000516", "CJCLUBT", super.getResources().getString(2131719393), "voiceSvip");
              i = j;
            }
          }
        }
      }
    }
    if ((this.c) && (this.jdField_b_of_type_JavaLangRefWeakReference.get() != null))
    {
      paramDialogInterface = (AppRuntime)this.jdField_b_of_type_JavaLangRefWeakReference.get();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append(paramInt);
      ReportController.b(paramDialogInterface, "CliOper", "", "", "changevoice", "0X8006F46", 0, 0, ((StringBuilder)localObject).toString(), "", "", "");
      if (paramInt == 1)
      {
        paramDialogInterface = (AppRuntime)this.jdField_b_of_type_JavaLangRefWeakReference.get();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("");
        ((StringBuilder)localObject).append(i);
        ReportController.b(paramDialogInterface, "CliOper", "", "", "changevoice", "0X8006F46", 0, 0, ((StringBuilder)localObject).toString(), "", "", "");
      }
    }
  }
  
  public void onClick(View paramView)
  {
    int m = paramView.getId();
    int i = -1;
    String str2 = null;
    String str1 = "";
    int j = 1;
    int k = 2;
    Object localObject1;
    Object localObject2;
    if (m == 2131370158)
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelChangeVoiceView;
      if (localObject1 != null) {
        ((ChangeVoiceView)localObject1).a(1);
      }
      if (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null) {
        ((AudioPanelAioHelper)((BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(128)).a(this.jdField_b_of_type_JavaLangString, null);
      }
      f();
      ((IVoiceChangeManager)QRoute.api(IVoiceChangeManager.class)).requestToCancel(this.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeBasicParams);
      if (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)
      {
        if (((AudioPanelProvider)((BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a().a(2)).jdField_a_of_type_Boolean) {
          i = 1;
        } else {
          i = 2;
        }
      }
      else {
        i = 0;
      }
      if (this.jdField_b_of_type_JavaLangRefWeakReference.get() != null)
      {
        ReportController.b((AppRuntime)this.jdField_b_of_type_JavaLangRefWeakReference.get(), "CliOper", "", "", "0X8005475", "0X8005475", i, 0, "", "", "", "8.7.0");
        if ((this.jdField_a_of_type_JavaLangRefWeakReference.get() != null) && ((this.jdField_a_of_type_JavaLangRefWeakReference.get() instanceof PublicAccountChatPie))) {
          ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate((AppInterface)this.jdField_b_of_type_JavaLangRefWeakReference.get(), "P_CliOper", "Pb_account_lifeservice", "", "0X8005852", "0X8005852", 0, 0, "", "", "", "", false);
        }
        ((IPttPreSendService)((QQAppInterface)this.jdField_b_of_type_JavaLangRefWeakReference.get()).getRuntimeService(IPttPreSendService.class)).doOnCancelSend();
        if (jdField_a_of_type_ComTencentMobileqqPttIPttVoiceChangePreSender != null) {
          jdField_a_of_type_ComTencentMobileqqPttIPttVoiceChangePreSender.a((AppRuntime)this.jdField_b_of_type_JavaLangRefWeakReference.get(), -1);
        }
      }
      i = 1;
    }
    else if (m == 2131370161)
    {
      if (this.jdField_a_of_type_Int >= 6)
      {
        a(true, 2131698515);
        if (this.jdField_b_of_type_JavaLangRefWeakReference.get() != null) {
          ((VoiceChangeHandler)((QQAppInterface)this.jdField_b_of_type_JavaLangRefWeakReference.get()).getBusinessHandler(BusinessHandlerFactory.CHANGE_VOICE_HANDLER)).a(1, this.jdField_a_of_type_Int, this);
        }
      }
      else
      {
        localObject1 = this.jdField_a_of_type_AndroidOsHandler;
        ((Handler)localObject1).sendMessage(Message.obtain((Handler)localObject1, 106, null));
      }
      i = 2;
    }
    else
    {
      this.jdField_a_of_type_Boolean = true;
      if ((paramView instanceof ChangeVoiceView))
      {
        ChangeVoiceView localChangeVoiceView = (ChangeVoiceView)paramView;
        if ((localChangeVoiceView == null) || (localChangeVoiceView.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeData == null)) {
          break label1195;
        }
        if (2 == localChangeVoiceView.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeData.jdField_b_of_type_Int)
        {
          i = localChangeVoiceView.jdField_a_of_type_Int;
          this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelChangeVoiceListAdapter.jdField_b_of_type_Int = i;
          if (i != this.jdField_a_of_type_Int)
          {
            if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelChangeVoiceView == null)
            {
              localObject1 = this.jdField_a_of_type_ComTencentWidgetListView;
              if ((localObject1 != null) && (((ListView)localObject1).getChildCount() > 0) && ((this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(0) instanceof ViewGroup))) {
                localObject1 = (ViewGroup)this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(0);
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
              this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelChangeVoiceView = ((ChangeVoiceView)localObject2);
            }
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelChangeVoiceView;
            if ((localObject1 != null) && (localChangeVoiceView != localObject1)) {
              ((ChangeVoiceView)localObject1).a(0);
            }
            this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelChangeVoiceView = localChangeVoiceView;
            localChangeVoiceView.a(2);
            this.jdField_a_of_type_Int = i;
            e();
            if (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)
            {
              i = k;
              if (((AudioPanelProvider)((BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a().a(2)).jdField_a_of_type_Boolean) {
                i = 1;
              }
            }
            else
            {
              i = 0;
            }
            if (this.jdField_b_of_type_JavaLangRefWeakReference.get() != null)
            {
              localObject1 = (AppRuntime)this.jdField_b_of_type_JavaLangRefWeakReference.get();
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append(this.jdField_a_of_type_Int);
              ((StringBuilder)localObject2).append("");
              ReportController.b((AppRuntime)localObject1, "CliOper", "", "", "0X8005473", "0X8005473", i, 0, ((StringBuilder)localObject2).toString(), "", "", "8.7.0");
            }
            this.jdField_b_of_type_ArrayOfInt[this.jdField_a_of_type_Int] = 1;
          }
          else if (localChangeVoiceView.a() == 2)
          {
            localChangeVoiceView.a(1);
            ((IVoiceChangeManager)QRoute.api(IVoiceChangeManager.class)).requestToPause(this.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeBasicParams);
          }
          else if (localChangeVoiceView.a() == 1)
          {
            e();
            localChangeVoiceView.a(2);
            if (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)
            {
              if (((AudioPanelProvider)((BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a().a(2)).jdField_a_of_type_Boolean) {
                i = j;
              } else {
                i = 2;
              }
            }
            else {
              i = 0;
            }
            if (this.jdField_b_of_type_JavaLangRefWeakReference.get() != null)
            {
              localObject1 = (AppRuntime)this.jdField_b_of_type_JavaLangRefWeakReference.get();
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append(this.jdField_a_of_type_Int);
              ((StringBuilder)localObject2).append("");
              ReportController.b((AppRuntime)localObject1, "CliOper", "", "", "0X8005473", "0X8005473", i, 0, ((StringBuilder)localObject2).toString(), "", "", "8.7.0");
            }
          }
          else if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("CLICK EXCEPTION， curtype = ");
            ((StringBuilder)localObject1).append(this.jdField_a_of_type_Int);
            ((StringBuilder)localObject1).append(" newtype is ");
            ((StringBuilder)localObject1).append(i);
            ((StringBuilder)localObject1).append(" state is ");
            ((StringBuilder)localObject1).append(localChangeVoiceView.a());
            QLog.e("changevoice", 2, ((StringBuilder)localObject1).toString());
          }
        }
        else
        {
          a(4, localChangeVoiceView.jdField_a_of_type_Int, null, HardCodeUtil.a(2131706228), null, null, null);
        }
        i = 0;
      }
    }
    if ((i >= 0) && (this.jdField_b_of_type_JavaLangRefWeakReference.get() != null))
    {
      localObject2 = (AppRuntime)this.jdField_b_of_type_JavaLangRefWeakReference.get();
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("");
      ((StringBuilder)localObject1).append(i);
      str2 = ((StringBuilder)localObject1).toString();
      localObject1 = str1;
      if (i == 0)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("");
        ((StringBuilder)localObject1).append(this.jdField_a_of_type_Int);
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      ReportController.b((AppRuntime)localObject2, "CliOper", "", "", "changevoice", "0X8006F50", 0, 0, str2, (String)localObject1, "", "");
    }
    label1195:
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onError()
  {
    Handler localHandler = this.jdField_a_of_type_AndroidOsHandler;
    localHandler.sendMessage(Message.obtain(localHandler, 105, null));
    ((IVoiceChangeManager)QRoute.api(IVoiceChangeManager.class)).requestToPause(this.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeBasicParams);
    QQAudioUtils.a(BaseApplication.getContext(), false);
  }
  
  public void onPlayEnd()
  {
    Handler localHandler = this.jdField_a_of_type_AndroidOsHandler;
    localHandler.sendMessage(Message.obtain(localHandler, 104, null));
  }
  
  public void onPlayStop()
  {
    Handler localHandler = this.jdField_a_of_type_AndroidOsHandler;
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
    Handler localHandler = this.jdField_a_of_type_AndroidOsHandler;
    localHandler.sendMessage(Message.obtain(localHandler, 103, localBundle));
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    super.onTouchEvent(paramMotionEvent);
    return true;
  }
  
  public void setAudioPath(String paramString, double paramDouble, RecordParams.RecorderParam paramRecorderParam)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Double = paramDouble;
    this.jdField_a_of_type_ComTencentMobileqqUtilsRecordParams$RecorderParam = paramRecorderParam;
    this.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeBasicParams = new VoiceChangeBasicParams(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqUtilsRecordParams$RecorderParam.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqUtilsRecordParams$RecorderParam.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqUtilsRecordParams$RecorderParam.c, this.jdField_a_of_type_Int);
    if (AppSetting.d) {
      AccessibilityUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelChangeVoiceView);
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
    jdField_b_of_type_Boolean = bool;
    super.setVisibility(paramInt);
    if ((jdField_b_of_type_Boolean) && (this.jdField_b_of_type_JavaLangRefWeakReference.get() != null)) {
      ReportController.b((AppRuntime)this.jdField_b_of_type_JavaLangRefWeakReference.get(), "CliOper", "", "", "changevoice", "0X8006F4F", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.ListenChangeVoicePanel
 * JD-Core Version:    0.7.0.1
 */