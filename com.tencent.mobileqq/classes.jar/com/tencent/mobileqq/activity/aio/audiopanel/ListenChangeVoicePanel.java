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
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie.SaveInputTypeTask;
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
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.ptt.PttVoiceChangePreSender;
import com.tencent.mobileqq.ptt.preop.PttPreSendManager;
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
import com.tencent.mobileqq.voicechange.VoiceChangeBasicParams;
import com.tencent.mobileqq.voicechange.VoiceChangeData;
import com.tencent.mobileqq.voicechange.VoiceChangeData.IconData;
import com.tencent.mobileqq.voicechange.VoiceChangeManager;
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
  public static volatile PttVoiceChangePreSender a;
  public static int[] a;
  public static String[] a;
  public static boolean b;
  public static int[] b;
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
  boolean jdField_c_of_type_Boolean;
  private int[] jdField_c_of_type_ArrayOfInt = new int[jdField_a_of_type_ArrayOfInt.length];
  
  static
  {
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { HardCodeUtil.a(2131706193), HardCodeUtil.a(2131706198), HardCodeUtil.a(2131706175), HardCodeUtil.a(2131706194), HardCodeUtil.a(2131706192), HardCodeUtil.a(2131706166), HardCodeUtil.a(2131706153), HardCodeUtil.a(2131706191), HardCodeUtil.a(2131706174), HardCodeUtil.a(2131706176), HardCodeUtil.a(2131706161), HardCodeUtil.a(2131706148), HardCodeUtil.a(2131706159), HardCodeUtil.a(2131706182), HardCodeUtil.a(2131706150), HardCodeUtil.a(2131706179), HardCodeUtil.a(2131706164) };
    jdField_b_of_type_ArrayOfJavaLangString = new String[] { HardCodeUtil.a(2131706180), HardCodeUtil.a(2131706158), HardCodeUtil.a(2131706154), HardCodeUtil.a(2131706195), HardCodeUtil.a(2131706160), HardCodeUtil.a(2131706173), HardCodeUtil.a(2131706156), HardCodeUtil.a(2131706196), HardCodeUtil.a(2131706162), HardCodeUtil.a(2131706155), HardCodeUtil.a(2131706183), HardCodeUtil.a(2131706185), HardCodeUtil.a(2131706165), HardCodeUtil.a(2131706152), HardCodeUtil.a(2131706149), HardCodeUtil.a(2131706188), HardCodeUtil.a(2131706187) };
    jdField_a_of_type_ArrayOfInt = new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16 };
    jdField_b_of_type_ArrayOfInt = new int[] { 2130838493, 2130838492, 2130838495, 2130838494, 2130838491, 2130838490, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
    jdField_a_of_type_ComTencentMobileqqPttPttVoiceChangePreSender = null;
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
    for (int j = 0; i < this.jdField_c_of_type_ArrayOfInt.length; j = k)
    {
      k = j;
      if (this.jdField_c_of_type_ArrayOfInt[i] == 1)
      {
        k = j + 1;
        this.jdField_c_of_type_ArrayOfInt[i] = 0;
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
    int j;
    int i;
    if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null) && (((BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a != null) && (this.jdField_b_of_type_JavaLangRefWeakReference != null) && (this.jdField_b_of_type_JavaLangRefWeakReference.get() != null))
    {
      if (!((BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get()).f) {
        break label396;
      }
      j = 1;
      if (((BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a.jdField_a_of_type_Int != 0) {
        break label402;
      }
      i = 1;
    }
    for (;;)
    {
      ReportController.b((AppRuntime)this.jdField_b_of_type_JavaLangRefWeakReference.get(), "CliOper", "", "", "0X8005474", "0X8005474", j, 0, paramInt3 + "", i + "", "", "8.5.5");
      if ((this.jdField_a_of_type_JavaLangRefWeakReference.get() instanceof PublicAccountChatPie)) {
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate((AppInterface)this.jdField_b_of_type_JavaLangRefWeakReference.get(), "P_CliOper", "Pb_account_lifeservice", "", "0X8005851", "0X8005851", 0, 0, "", "", "", "", false);
      }
      paramInt3 = Calendar.getInstance().get(11);
      Card localCard = ((FriendsManager)((QQAppInterface)this.jdField_b_of_type_JavaLangRefWeakReference.get()).getManager(QQManagerFactory.FRIENDS_MANAGER)).b(((QQAppInterface)this.jdField_b_of_type_JavaLangRefWeakReference.get()).getCurrentAccountUin());
      StatisticCollector localStatisticCollector = StatisticCollector.getInstance(super.getContext());
      HashMap localHashMap = new HashMap();
      localHashMap.put("gender", String.valueOf(localCard.shGender));
      localHashMap.put("age", String.valueOf(localCard.age));
      localHashMap.put("time", String.valueOf(paramInt3));
      localHashMap.put("extra", String.valueOf(paramInt4));
      paramInt3 = paramInt1;
      if (paramInt2 == paramInt1) {
        paramInt3 = paramInt1 + 10;
      }
      localHashMap.put("param_FailCode", String.valueOf(paramInt3));
      localHashMap.put(BaseConstants.RDM_NoChangeFailCode, "");
      localStatisticCollector.collectPerformance("", "VCPttSendEvent", false, 0L, 0L, localHashMap, "");
      return;
      label396:
      j = 2;
      break;
      label402:
      if (((BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a.jdField_a_of_type_Int == 3000) {
        i = 2;
      } else if (((BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a.jdField_a_of_type_Int == 1) {
        i = 3;
      } else {
        i = 4;
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2, Object paramObject, boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ListenChangeVoicePanel", 2, "VoiceChangeObserver type=" + paramInt1 + ", ret=" + paramInt2 + ", fromUiThread-f:" + paramBoolean);
      }
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 107, paramInt1, paramInt2, paramObject));
      return;
    }
    a(false, 0);
    paramObject = (Bundle)paramObject;
    this.jdField_c_of_type_Boolean = false;
    int i = paramObject.getInt("callId", 0);
    Object localObject1 = paramObject.getString("message");
    String str = paramObject.getString("svr_url");
    paramObject = paramObject.getString("svr_actStr");
    if (QLog.isColorLevel()) {
      QLog.d("ListenChangeVoicePanel", 2, "VoiceChangeObserver type=" + paramInt1 + ", ret=" + paramInt2 + ", fromUiThread:" + paramBoolean);
    }
    switch (paramInt2)
    {
    default: 
      label276:
      paramInt1 = 4;
    }
    while (paramInt2 != 0)
    {
      QLog.d("ListenChangeVoicePanel", 1, "VoiceChangeObserver fail, ret=" + paramInt2 + ", msg=" + (String)localObject1);
      Object localObject2 = paramObject;
      if (!TextUtils.isEmpty(str))
      {
        localObject2 = paramObject;
        if (TextUtils.isEmpty(paramObject)) {
          localObject2 = HardCodeUtil.a(2131706168);
        }
      }
      a(paramInt1, i, null, (String)localObject1, null, (String)localObject2, str);
      if ((!this.jdField_c_of_type_Boolean) || (this.jdField_b_of_type_JavaLangRefWeakReference.get() == null)) {
        break;
      }
      ReportController.b((AppRuntime)this.jdField_b_of_type_JavaLangRefWeakReference.get(), "CliOper", "", "", "changevoice", "0X8006F45", 0, 0, "" + this.jdField_a_of_type_Int, "", "", "");
      return;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 106, null));
      return;
      localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = HardCodeUtil.a(2131706190);
      }
      localObject1 = paramObject;
      if (TextUtils.isEmpty(paramObject)) {
        localObject1 = HardCodeUtil.a(2131706171);
      }
      this.jdField_c_of_type_Boolean = true;
      paramObject = localObject1;
      localObject1 = localObject2;
      paramInt1 = 1;
      continue;
      localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = HardCodeUtil.a(2131706178);
      }
      localObject1 = paramObject;
      if (TextUtils.isEmpty(paramObject)) {
        localObject1 = HardCodeUtil.a(2131706163);
      }
      this.jdField_c_of_type_Boolean = true;
      paramObject = localObject1;
      localObject1 = localObject2;
      paramInt1 = 2;
      continue;
      localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = HardCodeUtil.a(2131706172);
      }
      this.jdField_c_of_type_Boolean = true;
      localObject1 = localObject2;
      paramInt1 = 4;
      continue;
      localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = HardCodeUtil.a(2131706189);
      }
      this.jdField_c_of_type_Boolean = true;
      localObject1 = localObject2;
      paramInt1 = 4;
      continue;
      localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = HardCodeUtil.a(2131706170);
      }
      this.jdField_c_of_type_Boolean = true;
      localObject1 = localObject2;
      paramInt1 = 4;
      continue;
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        break label276;
      }
      localObject1 = HardCodeUtil.a(2131706184);
      paramInt1 = 4;
      continue;
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        break label276;
      }
      localObject1 = HardCodeUtil.a(2131706157);
      paramInt1 = 4;
      continue;
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        break label276;
      }
      localObject1 = HardCodeUtil.a(2131706151);
      paramInt1 = 4;
      continue;
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        break label276;
      }
      localObject1 = HardCodeUtil.a(2131706167);
      paramInt1 = 4;
    }
  }
  
  public void a(QQAppInterface arg1, BaseChatPie paramBaseChatPie, ViewGroup paramViewGroup)
  {
    this.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(???);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramBaseChatPie);
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131370498));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131370501));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    if (AppSetting.d)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_a_of_type_AndroidWidgetTextView.getText() + super.getContext().getString(2131691194));
      this.jdField_b_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_b_of_type_AndroidWidgetTextView.getText() + super.getContext().getString(2131691194));
    }
    this.jdField_a_of_type_ComTencentWidgetListView = ((ListView)super.findViewById(2131368636));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelChangeVoiceListAdapter = new ChangeVoiceListAdapter(super.getContext());
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelChangeVoiceListAdapter.a = this;
    this.jdField_a_of_type_ComTencentWidgetListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelChangeVoiceListAdapter);
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilArrayList)
      {
        if (this.jdField_a_of_type_JavaUtilArrayList.size() < jdField_a_of_type_ArrayOfInt.length)
        {
          int i = 0;
          if (i < jdField_a_of_type_ArrayOfInt.length)
          {
            paramBaseChatPie = this.jdField_a_of_type_JavaUtilArrayList;
            int k = jdField_a_of_type_ArrayOfInt[i];
            paramViewGroup = jdField_a_of_type_ArrayOfJavaLangString[i];
            String str = jdField_b_of_type_ArrayOfJavaLangString[i];
            if (i < 6) {
              break label347;
            }
            j = 0;
            paramBaseChatPie.add(new VoiceChangeData(k, paramViewGroup, str, 0, j, 1, new VoiceChangeData.IconData(jdField_b_of_type_ArrayOfInt[i], null, null, null)));
            i += 1;
            continue;
          }
        }
        ThreadManager.post(new ListenChangeVoicePanel.2(this), 8, null, true);
        return;
      }
      label347:
      int j = 2;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    boolean bool = false;
    if (this.jdField_b_of_type_JavaLangRefWeakReference.get() == null) {
      return;
    }
    ??? = (AppRuntime)this.jdField_b_of_type_JavaLangRefWeakReference.get();
    if (!paramBoolean) {
      bool = true;
    }
    ??? = VasUpdateUtil.a((AppRuntime)???, "changeVoice_json", bool, this.jdField_a_of_type_ComTencentMobileqqVasUpdatesystemCallbackCallBacker);
    if (??? != null)
    {
      bool = ((VoiceChangeManager)((QQAppInterface)this.jdField_b_of_type_JavaLangRefWeakReference.get()).getManager(QQManagerFactory.VOICE_CHANGE_MANAGER)).a(this.jdField_a_of_type_JavaUtilArrayList, (JSONObject)???);
      if (QLog.isColorLevel()) {
        QLog.d("ListenChangeVoicePanel", 2, "initVoiceDatas startDownload json.isLoaded=" + paramBoolean + ", isChecked=" + bool);
      }
    }
    synchronized (this.jdField_b_of_type_JavaUtilArrayList)
    {
      VoiceChangeData localVoiceChangeData;
      for (;;)
      {
        this.jdField_b_of_type_JavaUtilArrayList.clear();
        int i = this.jdField_a_of_type_JavaUtilArrayList.size() - 1;
        for (;;)
        {
          if (i < 0) {
            break label258;
          }
          localVoiceChangeData = (VoiceChangeData)this.jdField_a_of_type_JavaUtilArrayList.get(i);
          if (localVoiceChangeData.jdField_b_of_type_Int != 0)
          {
            if (6 <= i) {
              break;
            }
            this.jdField_b_of_type_JavaUtilArrayList.add(0, localVoiceChangeData);
          }
          i -= 1;
        }
        if ((QLog.isColorLevel()) || (paramBoolean)) {
          QLog.d("ListenChangeVoicePanel", 2, "initVoiceDatas null=xydata startDownload json. isLoaded=" + paramBoolean);
        }
      }
      this.jdField_b_of_type_JavaUtilArrayList.add(localVoiceChangeData);
    }
    label258:
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 101, null));
  }
  
  void a(boolean paramBoolean, int paramInt)
  {
    if (paramBoolean)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null))
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(((BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(), AIOUtils.a(50.0F, super.getResources()));
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setCancelable(true);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(paramInt);
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
      }
    }
    while ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) || (!this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
  }
  
  public boolean a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "ListenPanel.onBackEvent() is called,audioPath is:" + this.jdField_b_of_type_JavaLangString);
    }
    setVisibility(8);
    PressToChangeVoicePanel localPressToChangeVoicePanel = (PressToChangeVoicePanel)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131373447);
    localPressToChangeVoicePanel.f();
    localPressToChangeVoicePanel.setVisibility(0);
    int i;
    if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null))
    {
      ((BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get()).b(this.jdField_b_of_type_JavaLangString, null);
      VoiceChangeManager.a(this.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeBasicParams);
      if (((BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get()).f) {
        i = 1;
      }
    }
    for (;;)
    {
      if ((this.jdField_b_of_type_JavaLangRefWeakReference != null) && (this.jdField_b_of_type_JavaLangRefWeakReference.get() != null))
      {
        ReportController.b((AppRuntime)this.jdField_b_of_type_JavaLangRefWeakReference.get(), "CliOper", "", "", "0X8005475", "0X8005475", i, 0, "", "", "", "8.5.5");
        if (jdField_a_of_type_ComTencentMobileqqPttPttVoiceChangePreSender != null) {
          jdField_a_of_type_ComTencentMobileqqPttPttVoiceChangePreSender.a((QQAppInterface)this.jdField_b_of_type_JavaLangRefWeakReference.get(), -1);
        }
        PttPreSendManager.a((QQAppInterface)this.jdField_b_of_type_JavaLangRefWeakReference.get()).b();
      }
      return false;
      i = 2;
      continue;
      i = 0;
    }
  }
  
  boolean a(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.jdField_a_of_type_AndroidOsBundle = new Bundle();
    this.jdField_a_of_type_AndroidOsBundle.putInt("funcType", paramInt1);
    this.jdField_a_of_type_AndroidOsBundle.putString("url", paramString5);
    this.jdField_a_of_type_AndroidOsBundle.putInt("fcID", paramInt2);
    if (TextUtils.isEmpty(paramString1)) {
      paramString1 = HardCodeUtil.a(2131706197);
    }
    for (;;)
    {
      if (TextUtils.isEmpty(paramString2)) {
        paramString2 = HardCodeUtil.a(2131706186);
      }
      for (;;)
      {
        if (TextUtils.isEmpty(paramString3)) {
          paramString3 = HardCodeUtil.a(2131706181);
        }
        for (;;)
        {
          if (TextUtils.isEmpty(paramString4)) {
            paramString4 = HardCodeUtil.a(2131706169);
          }
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.d("ListenChangeVoicePanel", 1, "showTips content=" + paramString2 + ", title=" + paramString1);
            }
            if (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)
            {
              paramString1 = DialogUtil.a(((BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(), 0, paramString1, paramString2, paramString3, paramString4, this, this);
              if (paramString1 != null)
              {
                paramString1.show();
                return true;
              }
            }
            return false;
          }
        }
      }
    }
  }
  
  public void b()
  {
    VoiceChangeManager.b(this.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeBasicParams);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelChangeVoiceView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelChangeVoiceView.a(1);
    }
  }
  
  public void c()
  {
    if ((this.jdField_b_of_type_JavaLangRefWeakReference != null) && (this.jdField_b_of_type_JavaLangRefWeakReference.get() != null)) {
      ((IVasQuickUpdateService)((QQAppInterface)this.jdField_b_of_type_JavaLangRefWeakReference.get()).getRuntimeService(IVasQuickUpdateService.class, "")).removeCallBacker(this.jdField_a_of_type_ComTencentMobileqqVasUpdatesystemCallbackCallBacker);
    }
    if (this.jdField_b_of_type_JavaLangString == null) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("AIOAudioPanel", 2, "ListenPanel.onBackEvent() is called,audioPath is:" + this.jdField_b_of_type_JavaLangString);
      }
      f();
      VoiceChangeManager.a(this.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeBasicParams);
    } while ((this.jdField_a_of_type_JavaLangRefWeakReference == null) || (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null));
    ((BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get()).b(this.jdField_b_of_type_JavaLangString, null);
    Object localObject;
    int i;
    if ((this.jdField_b_of_type_JavaLangRefWeakReference != null) && (this.jdField_b_of_type_JavaLangRefWeakReference.get() != null))
    {
      localObject = (FriendsManager)((QQAppInterface)this.jdField_b_of_type_JavaLangRefWeakReference.get()).getManager(QQManagerFactory.FRIENDS_MANAGER);
      if (((BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get()).p()) {
        break label291;
      }
      localObject = ((FriendsManager)localObject).a(((BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a.jdField_a_of_type_JavaLangString, ((BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a.jdField_a_of_type_Int, false);
      if ((localObject == null) || (((NoC2CExtensionInfo)localObject).pttChangeVoiceType == this.jdField_a_of_type_Int)) {
        break label346;
      }
      ((NoC2CExtensionInfo)localObject).pttChangeVoiceType = this.jdField_a_of_type_Int;
      i = 1;
    }
    for (;;)
    {
      if ((i != 0) && (localObject != null)) {
        ThreadManager.getFileThreadHandler().post(new BaseChatPie.SaveInputTypeTask((Entity)localObject, (QQAppInterface)this.jdField_b_of_type_JavaLangRefWeakReference.get()));
      }
      jdField_b_of_type_Boolean = false;
      return;
      label291:
      localObject = ((FriendsManager)localObject).a(((BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a.jdField_a_of_type_JavaLangString, false);
      if ((localObject != null) && (((ExtensionInfo)localObject).pttChangeVoiceType != this.jdField_a_of_type_Int))
      {
        ((ExtensionInfo)localObject).pttChangeVoiceType = this.jdField_a_of_type_Int;
        i = 1;
      }
      else
      {
        i = 0;
        continue;
        label346:
        i = 0;
      }
    }
  }
  
  public void d()
  {
    this.jdField_b_of_type_Int = this.jdField_a_of_type_Int;
    if (this.jdField_a_of_type_Int == -1) {
      this.jdField_a_of_type_Int = 0;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelChangeVoiceView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelChangeVoiceView.a(1);
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeBasicParams.f = this.jdField_a_of_type_Int;
    if (this.jdField_b_of_type_JavaLangRefWeakReference.get() != null)
    {
      QQAudioUtils.a(BaseApplication.getContext(), true);
      VoiceChangeManager.b(((QQAppInterface)this.jdField_b_of_type_JavaLangRefWeakReference.get()).getApp(), this.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeBasicParams, PressToChangeVoicePanel.jdField_a_of_type_JavaLangString, this);
    }
  }
  
  public void f()
  {
    setVisibility(8);
    if (this.jdField_a_of_type_AndroidViewViewGroup != null)
    {
      PressToChangeVoicePanel localPressToChangeVoicePanel = (PressToChangeVoicePanel)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131373447);
      localPressToChangeVoicePanel.f();
      localPressToChangeVoicePanel.setVisibility(0);
    }
    int i = 0;
    while (i < this.jdField_c_of_type_ArrayOfInt.length)
    {
      this.jdField_c_of_type_ArrayOfInt[i] = 0;
      i += 1;
    }
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
    if (this.jdField_a_of_type_AndroidOsBundle == null) {}
    label497:
    label500:
    for (;;)
    {
      return;
      int i = this.jdField_a_of_type_AndroidOsBundle.getInt("funcType", 4);
      paramDialogInterface = this.jdField_a_of_type_AndroidOsBundle.getString("url");
      int j = this.jdField_a_of_type_AndroidOsBundle.getInt("fcID", 0);
      if (QLog.isColorLevel()) {
        QLog.d("ListenChangeVoicePanel", 1, "DialogInterface funcType=" + i + ", url:" + paramDialogInterface);
      }
      if ((1 == i) || (2 == i))
      {
        if ((paramInt != 1) || (this.jdField_b_of_type_JavaLangRefWeakReference.get() == null) || (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null)) {
          break label497;
        }
        if (1 == i)
        {
          VasH5PayUtil.a((QQAppInterface)this.jdField_b_of_type_JavaLangRefWeakReference.get(), ((BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(), this.jdField_a_of_type_JavaLangString + j, 3, "1450000515", "LTMCLUB", super.getResources().getString(2131695088), "voiceVip");
          i = 0;
        }
      }
      for (;;)
      {
        if ((!this.jdField_c_of_type_Boolean) || (this.jdField_b_of_type_JavaLangRefWeakReference.get() == null)) {
          break label500;
        }
        ReportController.b((AppRuntime)this.jdField_b_of_type_JavaLangRefWeakReference.get(), "CliOper", "", "", "changevoice", "0X8006F46", 0, 0, "" + paramInt, "", "", "");
        if (paramInt != 1) {
          break;
        }
        ReportController.b((AppRuntime)this.jdField_b_of_type_JavaLangRefWeakReference.get(), "CliOper", "", "", "changevoice", "0X8006F46", 0, 0, "" + i, "", "", "");
        return;
        VasH5PayUtil.a((QQAppInterface)this.jdField_b_of_type_JavaLangRefWeakReference.get(), ((BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(), this.jdField_a_of_type_JavaLangString + j, 3, "1450000516", "CJCLUBT", super.getResources().getString(2131719674), "voiceSvip");
        i = 0;
        continue;
        if ((paramInt == 1) && (!TextUtils.isEmpty(paramDialogInterface)) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null))
        {
          Intent localIntent = new Intent(((BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(), QQBrowserActivity.class);
          localIntent.putExtra("url", paramDialogInterface);
          localIntent.putExtra("isShowAd", false);
          ((BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a().startActivity(localIntent);
          i = 1;
        }
        else
        {
          i = 0;
        }
      }
    }
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == 2131370498)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelChangeVoiceView != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelChangeVoiceView.a(1);
      }
      if (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null) {
        ((BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get()).b(this.jdField_b_of_type_JavaLangString, null);
      }
      f();
      VoiceChangeManager.a(this.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeBasicParams);
      i = 0;
      if (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)
      {
        if (((BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get()).f) {
          i = 1;
        }
      }
      else
      {
        if (this.jdField_b_of_type_JavaLangRefWeakReference.get() != null)
        {
          ReportController.b((AppRuntime)this.jdField_b_of_type_JavaLangRefWeakReference.get(), "CliOper", "", "", "0X8005475", "0X8005475", i, 0, "", "", "", "8.5.5");
          if ((this.jdField_a_of_type_JavaLangRefWeakReference.get() != null) && ((this.jdField_a_of_type_JavaLangRefWeakReference.get() instanceof PublicAccountChatPie))) {
            ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate((AppInterface)this.jdField_b_of_type_JavaLangRefWeakReference.get(), "P_CliOper", "Pb_account_lifeservice", "", "0X8005852", "0X8005852", 0, 0, "", "", "", "", false);
          }
          PttPreSendManager.a((QQAppInterface)this.jdField_b_of_type_JavaLangRefWeakReference.get()).b();
          if (jdField_a_of_type_ComTencentMobileqqPttPttVoiceChangePreSender != null) {
            jdField_a_of_type_ComTencentMobileqqPttPttVoiceChangePreSender.a((QQAppInterface)this.jdField_b_of_type_JavaLangRefWeakReference.get(), -1);
          }
        }
        i = 1;
      }
    }
    for (;;)
    {
      label251:
      Object localObject2;
      String str;
      if ((i >= 0) && (this.jdField_b_of_type_JavaLangRefWeakReference.get() != null))
      {
        localObject2 = (AppRuntime)this.jdField_b_of_type_JavaLangRefWeakReference.get();
        str = "" + i;
        if (i != 0) {
          break label1011;
        }
      }
      label569:
      label600:
      label1011:
      for (Object localObject1 = "" + this.jdField_a_of_type_Int;; localObject1 = "")
      {
        ReportController.b((AppRuntime)localObject2, "CliOper", "", "", "changevoice", "0X8006F50", 0, 0, str, (String)localObject1, "", "");
        do
        {
          EventCollector.getInstance().onViewClicked(paramView);
          return;
          i = 2;
          break;
          if (i == 2131370501)
          {
            if (this.jdField_a_of_type_Int >= 6)
            {
              a(true, 2131698449);
              if (this.jdField_b_of_type_JavaLangRefWeakReference.get() == null) {
                break label1022;
              }
              ((VoiceChangeHandler)((QQAppInterface)this.jdField_b_of_type_JavaLangRefWeakReference.get()).getBusinessHandler(BusinessHandlerFactory.CHANGE_VOICE_HANDLER)).a(1, this.jdField_a_of_type_Int, this);
              i = 2;
              break label251;
            }
            this.jdField_a_of_type_AndroidOsHandler.sendMessage(Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 106, null));
            i = 2;
            break label251;
          }
          this.jdField_a_of_type_Boolean = true;
          if (!(paramView instanceof ChangeVoiceView)) {
            break label1017;
          }
          localObject2 = (ChangeVoiceView)paramView;
        } while ((localObject2 == null) || (((ChangeVoiceView)localObject2).jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeData == null));
        if (2 == ((ChangeVoiceView)localObject2).jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeData.jdField_b_of_type_Int)
        {
          i = ((ChangeVoiceView)localObject2).jdField_a_of_type_Int;
          this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelChangeVoiceListAdapter.jdField_b_of_type_Int = i;
          if (i != this.jdField_a_of_type_Int) {
            if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelChangeVoiceView == null)
            {
              if ((this.jdField_a_of_type_ComTencentWidgetListView != null) && (this.jdField_a_of_type_ComTencentWidgetListView.getChildCount() > 0) && ((this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(0) instanceof ViewGroup)))
              {
                localObject1 = (ViewGroup)this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(0);
                if ((localObject1 == null) || (((ViewGroup)localObject1).getChildCount() <= 0) || (!(((ViewGroup)localObject1).getChildAt(0) instanceof ChangeVoiceView))) {
                  break label765;
                }
                localObject1 = (ChangeVoiceView)((ViewGroup)localObject1).getChildAt(0);
                this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelChangeVoiceView = ((ChangeVoiceView)localObject1);
              }
            }
            else
            {
              if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelChangeVoiceView != null) && (localObject2 != this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelChangeVoiceView)) {
                this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelChangeVoiceView.a(0);
              }
              this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelChangeVoiceView = ((ChangeVoiceView)localObject2);
              ((ChangeVoiceView)localObject2).a(2);
              this.jdField_a_of_type_Int = i;
              e();
              i = 0;
              if (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)
              {
                if (!((BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get()).f) {
                  break label770;
                }
                i = 1;
              }
              if (this.jdField_b_of_type_JavaLangRefWeakReference.get() != null) {
                ReportController.b((AppRuntime)this.jdField_b_of_type_JavaLangRefWeakReference.get(), "CliOper", "", "", "0X8005473", "0X8005473", i, 0, this.jdField_a_of_type_Int + "", "", "", "8.5.5");
              }
              this.jdField_c_of_type_ArrayOfInt[this.jdField_a_of_type_Int] = 1;
            }
          }
          for (;;)
          {
            i = 0;
            break;
            localObject1 = null;
            break label569;
            label765:
            localObject1 = null;
            break label600;
            i = 2;
            break label680;
            if (((ChangeVoiceView)localObject2).a() == 2)
            {
              ((ChangeVoiceView)localObject2).a(1);
              VoiceChangeManager.b(this.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeBasicParams);
            }
            else if (((ChangeVoiceView)localObject2).a() == 1)
            {
              e();
              ((ChangeVoiceView)localObject2).a(2);
              i = 0;
              if (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null) {
                if (!((BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get()).f) {
                  break label917;
                }
              }
              for (i = 1;; i = 2)
              {
                if (this.jdField_b_of_type_JavaLangRefWeakReference.get() == null) {
                  break label920;
                }
                ReportController.b((AppRuntime)this.jdField_b_of_type_JavaLangRefWeakReference.get(), "CliOper", "", "", "0X8005473", "0X8005473", i, 0, this.jdField_a_of_type_Int + "", "", "", "8.5.5");
                break;
              }
            }
            else if (QLog.isColorLevel())
            {
              QLog.e("changevoice", 2, "CLICK EXCEPTION， curtype = " + this.jdField_a_of_type_Int + " newtype is " + i + " state is " + ((ChangeVoiceView)localObject2).a());
            }
          }
        }
        a(4, ((ChangeVoiceView)localObject2).jdField_a_of_type_Int, null, HardCodeUtil.a(2131706177), null, null, null);
        i = 0;
        break label251;
      }
      label680:
      label1017:
      i = -1;
      label770:
      label917:
      label920:
      continue;
      label1022:
      i = 2;
    }
  }
  
  public void onError()
  {
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 105, null));
    VoiceChangeManager.b(this.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeBasicParams);
    QQAudioUtils.a(BaseApplication.getContext(), false);
  }
  
  public void onPlayEnd()
  {
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 104, null));
  }
  
  public void onPlayStop()
  {
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 102, null));
    QQAudioUtils.a(BaseApplication.getContext(), false);
  }
  
  public void onSlicePlayed(int paramInt1, int paramInt2, int paramInt3)
  {
    paramInt1 = AudioPanel.a(paramInt1) / 1250;
    Bundle localBundle = new Bundle();
    localBundle.putInt("progress", paramInt2);
    localBundle.putInt("playTime", paramInt3);
    localBundle.putInt("level", paramInt1);
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 103, localBundle));
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
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      jdField_b_of_type_Boolean = bool;
      super.setVisibility(paramInt);
      if ((jdField_b_of_type_Boolean) && (this.jdField_b_of_type_JavaLangRefWeakReference.get() != null)) {
        ReportController.b((AppRuntime)this.jdField_b_of_type_JavaLangRefWeakReference.get(), "CliOper", "", "", "changevoice", "0X8006F4F", 0, 0, "", "", "", "");
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.ListenChangeVoicePanel
 * JD-Core Version:    0.7.0.1
 */