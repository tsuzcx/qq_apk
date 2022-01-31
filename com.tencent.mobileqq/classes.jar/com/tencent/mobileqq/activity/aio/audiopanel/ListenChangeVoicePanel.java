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
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.BaseChatPie.SaveInputTypeTask;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.VoiceChangeHandler;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.NoC2CExtensionInfo;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.ptt.PttVoiceChangePreSender;
import com.tencent.mobileqq.ptt.preop.PttPreSendManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.QQRecorder.RecorderParam;
import com.tencent.mobileqq.vas.VasH5PayUtil;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.mobileqq.vas.VasQuickUpdateManager.CallBacker;
import com.tencent.mobileqq.voicechange.IVoiceChangeListener;
import com.tencent.mobileqq.voicechange.VoiceChangeBasicParams;
import com.tencent.mobileqq.voicechange.VoiceChangeData;
import com.tencent.mobileqq.voicechange.VoiceChangeData.IconData;
import com.tencent.mobileqq.voicechange.VoiceChangeManager;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import org.json.JSONObject;
import upu;
import upv;
import upw;
import upx;

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
  Handler jdField_a_of_type_AndroidOsHandler = new upu(this, Looper.getMainLooper());
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  public BaseChatPie a;
  public ChangeVoiceListAdapter a;
  public ChangeVoiceView a;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private QQRecorder.RecorderParam jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam;
  public VasQuickUpdateManager.CallBacker a;
  private VoiceChangeBasicParams jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeBasicParams;
  QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  ListView jdField_a_of_type_ComTencentWidgetListView;
  protected String a;
  ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  public boolean a;
  private int jdField_b_of_type_Int = -1;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private String jdField_b_of_type_JavaLangString;
  public ArrayList b;
  boolean jdField_c_of_type_Boolean;
  private int[] jdField_c_of_type_ArrayOfInt = new int[jdField_a_of_type_ArrayOfInt.length];
  
  static
  {
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "原声", "萝莉", "大叔", "惊悚", "搞怪", "空灵", "幼稚园", "重机械", "擎天柱", "疯狂动物城闪电", "口吃", "网红", "困兽", "感冒", "土掉渣/歪果仁/方言", "金属机器人", "死肥仔" };
    jdField_b_of_type_ArrayOfJavaLangString = new String[] { "原声音效", "萝莉音效", "大叔音效", "惊悚音效", "搞怪音效", "空灵音效", "幼稚园", "重机械", "擎天柱", "疯狂动物城闪电", "口吃", "网红", "困兽", "感冒", "土掉渣/歪果仁/方言", "金属机器人", "死肥仔" };
    jdField_a_of_type_ArrayOfInt = new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16 };
    jdField_b_of_type_ArrayOfInt = new int[] { 2130837965, 2130837964, 2130837967, 2130837966, 2130837963, 2130837962, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
  }
  
  public ListenChangeVoicePanel(Context paramContext)
  {
    super(paramContext);
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker = new upw(this);
    this.jdField_a_of_type_JavaLangString = "mvip.gxh.android.changevoice_";
  }
  
  public ListenChangeVoicePanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker = new upw(this);
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
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 102, null));
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    paramInt1 = AudioPanel.a(paramInt1) / 1250;
    Bundle localBundle = new Bundle();
    localBundle.putInt("progress", paramInt2);
    localBundle.putInt("playTime", paramInt3);
    localBundle.putInt("level", paramInt1);
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 103, localBundle));
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int j;
    int i;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.d) {
        break label320;
      }
      j = 1;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.jdField_a_of_type_Int != 0) {
        break label326;
      }
      i = 1;
    }
    for (;;)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005474", "0X8005474", j, 0, paramInt3 + "", i + "", "", "7.6.3");
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof PublicAccountChatPie)) {
        PublicAccountReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X8005851", "0X8005851", 0, 0, "", "", "", "", false);
      }
      paramInt3 = Calendar.getInstance().get(11);
      Card localCard = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50)).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      StatisticCollector localStatisticCollector = StatisticCollector.a(super.getContext());
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
      localStatisticCollector.a("", "VCPttSendEvent", false, 0L, 0L, localHashMap, "");
      return;
      label320:
      j = 2;
      break;
      label326:
      if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.jdField_a_of_type_Int == 3000) {
        i = 2;
      } else if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.jdField_a_of_type_Int == 1) {
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
          localObject2 = "了解详情";
        }
      }
      a(paramInt1, i, null, (String)localObject1, null, (String)localObject2, str);
      if (!this.jdField_c_of_type_Boolean) {
        break;
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "changevoice", "0X8006F45", 0, 0, "" + this.jdField_a_of_type_Int, "", "", "");
      return;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 106, null));
      return;
      localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = "你选择的变声效果为会员专享，开通即可使用此变声效果";
      }
      localObject1 = paramObject;
      if (TextUtils.isEmpty(paramObject)) {
        localObject1 = "立即开通";
      }
      this.jdField_c_of_type_Boolean = true;
      paramObject = localObject1;
      localObject1 = localObject2;
      paramInt1 = 1;
      continue;
      localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = "你选择的变声效果为超级会员专享，开通即可使用此变声效果";
      }
      localObject1 = paramObject;
      if (TextUtils.isEmpty(paramObject)) {
        localObject1 = "立即开通";
      }
      this.jdField_c_of_type_Boolean = true;
      paramObject = localObject1;
      localObject1 = localObject2;
      paramInt1 = 2;
      continue;
      localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = "你选择的变声效果为需要参加活动才能使用";
      }
      this.jdField_c_of_type_Boolean = true;
      localObject1 = localObject2;
      paramInt1 = 4;
      continue;
      localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = "你选择的变声效果为需要开通星影会员才能使用";
      }
      this.jdField_c_of_type_Boolean = true;
      localObject1 = localObject2;
      paramInt1 = 4;
      continue;
      localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = "你选择的变声效果为需要开通专区会员才能使用";
      }
      this.jdField_c_of_type_Boolean = true;
      localObject1 = localObject2;
      paramInt1 = 4;
      continue;
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        break label276;
      }
      localObject1 = "你选择的变声效果已下架，不能使用";
      paramInt1 = 4;
      continue;
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        break label276;
      }
      localObject1 = "你选择的变声效果任选资格鉴权失败";
      paramInt1 = 4;
      continue;
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        break label276;
      }
      localObject1 = "你选择的变声效果未付费";
      paramInt1 = 4;
      continue;
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        break label276;
      }
      localObject1 = "你选择的变声效果已过试用期";
      paramInt1 = 4;
    }
  }
  
  public void a(QQAppInterface arg1, BaseChatPie paramBaseChatPie, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ???;
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131366441));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131366442));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    if (AppSetting.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_a_of_type_AndroidWidgetTextView.getText() + super.getContext().getString(2131427457));
      this.jdField_b_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_b_of_type_AndroidWidgetTextView.getText() + super.getContext().getString(2131427457));
    }
    this.jdField_a_of_type_ComTencentWidgetListView = ((ListView)super.findViewById(2131363038));
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
              break label333;
            }
            j = 0;
            paramBaseChatPie.add(new VoiceChangeData(k, paramViewGroup, str, 0, j, 1, new VoiceChangeData.IconData(jdField_b_of_type_ArrayOfInt[i], null, null, null)));
            i += 1;
            continue;
          }
        }
        ThreadManager.post(new upv(this), 8, null, true);
        return;
      }
      label333:
      int j = 2;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    boolean bool = false;
    ??? = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (!paramBoolean) {
      bool = true;
    }
    ??? = VasQuickUpdateManager.a((AppRuntime)???, "changeVoice_json", bool, this.jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker);
    if (??? != null)
    {
      bool = ((VoiceChangeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(175)).a(this.jdField_a_of_type_JavaUtilArrayList, (JSONObject)???);
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
            break label235;
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
    label235:
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 101, null));
  }
  
  void a(boolean paramBoolean, int paramInt)
  {
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), AIOUtils.a(50.0F, super.getResources()));
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setCancelable(true);
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(paramInt);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
    }
    while ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) || (!this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
  }
  
  public boolean a()
  {
    int i = 2;
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "ListenPanel.onBackEvent() is called,audioPath is:" + this.jdField_b_of_type_JavaLangString);
    }
    setVisibility(8);
    PressToChangeVoicePanel localPressToChangeVoicePanel = (PressToChangeVoicePanel)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131369457);
    localPressToChangeVoicePanel.g();
    localPressToChangeVoicePanel.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.b(this.jdField_b_of_type_JavaLangString, null);
    VoiceChangeManager.a(this.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeBasicParams);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.d) {
      i = 1;
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005475", "0X8005475", i, 0, "", "", "", "7.6.3");
    if (jdField_a_of_type_ComTencentMobileqqPttPttVoiceChangePreSender != null) {
      jdField_a_of_type_ComTencentMobileqqPttPttVoiceChangePreSender.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, -1);
    }
    PttPreSendManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b();
    return false;
  }
  
  boolean a(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.jdField_a_of_type_AndroidOsBundle = new Bundle();
    this.jdField_a_of_type_AndroidOsBundle.putInt("funcType", paramInt1);
    this.jdField_a_of_type_AndroidOsBundle.putString("url", paramString5);
    this.jdField_a_of_type_AndroidOsBundle.putInt("fcID", paramInt2);
    if (TextUtils.isEmpty(paramString1)) {
      paramString1 = "温馨提示";
    }
    for (;;)
    {
      if (TextUtils.isEmpty(paramString2)) {
        paramString2 = "发送失败，网速不给力哦，请重试";
      }
      for (;;)
      {
        if (TextUtils.isEmpty(paramString3)) {
          paramString3 = "取消";
        }
        for (;;)
        {
          if (TextUtils.isEmpty(paramString4)) {
            paramString4 = "确定";
          }
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.d("ListenChangeVoicePanel", 1, "showTips content=" + paramString2 + ", title=" + paramString1);
            }
            paramString1 = DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), 0, paramString1, paramString2, paramString3, paramString4, this, this);
            if (paramString1 != null)
            {
              paramString1.show();
              return true;
            }
            return false;
          }
        }
      }
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 104, null));
  }
  
  public void c()
  {
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 105, null));
    VoiceChangeManager.b(this.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeBasicParams);
  }
  
  public void d()
  {
    VoiceChangeManager.b(this.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeBasicParams);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelChangeVoiceView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelChangeVoiceView.a(1);
    }
  }
  
  public void e()
  {
    int i = 1;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      ((VasQuickUpdateManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(183)).b(this.jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker);
    }
    if (this.jdField_b_of_type_JavaLangString == null) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("AIOAudioPanel", 2, "ListenPanel.onBackEvent() is called,audioPath is:" + this.jdField_b_of_type_JavaLangString);
      }
      i();
      VoiceChangeManager.a(this.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeBasicParams);
    } while (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null);
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.b(this.jdField_b_of_type_JavaLangString, null);
    Object localObject = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
    if (!this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.m())
    {
      localObject = ((FriendsManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.jdField_a_of_type_Int, false);
      if ((localObject == null) || (((NoC2CExtensionInfo)localObject).pttChangeVoiceType == this.jdField_a_of_type_Int)) {
        break label256;
      }
      ((NoC2CExtensionInfo)localObject).pttChangeVoiceType = this.jdField_a_of_type_Int;
      i = 1;
    }
    for (;;)
    {
      if ((i != 0) && (localObject != null)) {
        ThreadManager.getFileThreadHandler().post(new BaseChatPie.SaveInputTypeTask((Entity)localObject, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
      }
      jdField_b_of_type_Boolean = false;
      return;
      localObject = ((FriendsManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.jdField_a_of_type_JavaLangString, false);
      if ((localObject != null) && (((ExtensionInfo)localObject).pttChangeVoiceType != this.jdField_a_of_type_Int))
      {
        ((ExtensionInfo)localObject).pttChangeVoiceType = this.jdField_a_of_type_Int;
      }
      else
      {
        i = 0;
        continue;
        label256:
        i = 0;
      }
    }
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_Int == -1) {
      ThreadManager.getSubThreadHandler().post(new upx(this));
    }
  }
  
  public void g()
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
  
  public void h()
  {
    this.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeBasicParams.f = this.jdField_a_of_type_Int;
    VoiceChangeManager.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeBasicParams, PressToChangeVoicePanel.jdField_a_of_type_JavaLangString, this);
  }
  
  public void i()
  {
    setVisibility(8);
    if (this.jdField_a_of_type_AndroidViewViewGroup != null)
    {
      PressToChangeVoicePanel localPressToChangeVoicePanel = (PressToChangeVoicePanel)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131369457);
      localPressToChangeVoicePanel.g();
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
    label409:
    label412:
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
        if (paramInt != 1) {
          break label409;
        }
        if (1 == i)
        {
          VasH5PayUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), this.jdField_a_of_type_JavaLangString + j, 3, "1450000515", "LTMCLUB", super.getResources().getString(2131436740), "voiceVip");
          i = 0;
        }
      }
      for (;;)
      {
        if (!this.jdField_c_of_type_Boolean) {
          break label412;
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "changevoice", "0X8006F46", 0, 0, "" + paramInt, "", "", "");
        if (paramInt != 1) {
          break;
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "changevoice", "0X8006F46", 0, 0, "" + i, "", "", "");
        return;
        VasH5PayUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), this.jdField_a_of_type_JavaLangString + j, 3, "1450000516", "CJCLUBT", super.getResources().getString(2131436943), "voiceSvip");
        i = 0;
        continue;
        if ((paramInt == 1) && (!TextUtils.isEmpty(paramDialogInterface)))
        {
          Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), QQBrowserActivity.class);
          localIntent.putExtra("url", paramDialogInterface);
          localIntent.putExtra("isShowAd", false);
          this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().startActivity(localIntent);
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
    if (i == 2131366441)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelChangeVoiceView != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelChangeVoiceView.a(1);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.b(this.jdField_b_of_type_JavaLangString, null);
      i();
      VoiceChangeManager.a(this.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeBasicParams);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.d)
      {
        i = 1;
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005475", "0X8005475", i, 0, "", "", "", "7.6.3");
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof PublicAccountChatPie)) {
          PublicAccountReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X8005852", "0X8005852", 0, 0, "", "", "", "", false);
        }
        PttPreSendManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b();
        if (jdField_a_of_type_ComTencentMobileqqPttPttVoiceChangePreSender != null) {
          jdField_a_of_type_ComTencentMobileqqPttPttVoiceChangePreSender.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, -1);
        }
        i = 1;
      }
    }
    for (;;)
    {
      label160:
      Object localObject;
      String str;
      if (i >= 0)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        str = "" + i;
        if (i != 0) {
          break label793;
        }
      }
      label521:
      label793:
      for (paramView = "" + this.jdField_a_of_type_Int;; paramView = "")
      {
        ReportController.b((QQAppInterface)localObject, "CliOper", "", "", "changevoice", "0X8006F50", 0, 0, str, paramView, "", "");
        do
        {
          return;
          i = 2;
          break;
          if (i == 2131366442)
          {
            if (this.jdField_a_of_type_Int >= 6)
            {
              a(true, 2131438013);
              ((VoiceChangeHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(96)).a(1, this.jdField_a_of_type_Int, this);
              i = 2;
              break label160;
            }
            this.jdField_a_of_type_AndroidOsHandler.sendMessage(Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 106, null));
            i = 2;
            break label160;
          }
          this.jdField_a_of_type_Boolean = true;
          if (!(paramView instanceof ChangeVoiceView)) {
            break label799;
          }
          localObject = (ChangeVoiceView)paramView;
        } while ((localObject == null) || (((ChangeVoiceView)localObject).jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeData == null));
        if (2 == ((ChangeVoiceView)localObject).jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeData.jdField_b_of_type_Int)
        {
          i = ((ChangeVoiceView)localObject).jdField_a_of_type_Int;
          this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelChangeVoiceListAdapter.jdField_b_of_type_Int = i;
          if (i != this.jdField_a_of_type_Int) {
            if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelChangeVoiceView == null)
            {
              if ((this.jdField_a_of_type_ComTencentWidgetListView != null) && (this.jdField_a_of_type_ComTencentWidgetListView.getChildCount() > 0) && ((this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(0) instanceof ViewGroup)))
              {
                paramView = (ViewGroup)this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(0);
                label431:
                if ((paramView == null) || (paramView.getChildCount() <= 0) || (!(paramView.getChildAt(0) instanceof ChangeVoiceView))) {
                  break label590;
                }
                paramView = (ChangeVoiceView)paramView.getChildAt(0);
                label462:
                this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelChangeVoiceView = paramView;
              }
            }
            else
            {
              if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelChangeVoiceView != null) && (localObject != this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelChangeVoiceView)) {
                this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelChangeVoiceView.a(0);
              }
              this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelChangeVoiceView = ((ChangeVoiceView)localObject);
              ((ChangeVoiceView)localObject).a(2);
              this.jdField_a_of_type_Int = i;
              h();
              if (!this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.d) {
                break label595;
              }
              i = 1;
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005473", "0X8005473", i, 0, this.jdField_a_of_type_Int + "", "", "", "7.6.3");
              this.jdField_c_of_type_ArrayOfInt[this.jdField_a_of_type_Int] = 1;
            }
          }
          for (;;)
          {
            i = 0;
            break;
            paramView = null;
            break label431;
            label590:
            paramView = null;
            break label462;
            label595:
            i = 2;
            break label521;
            if (((ChangeVoiceView)localObject).a() == 2)
            {
              ((ChangeVoiceView)localObject).a(1);
              VoiceChangeManager.b(this.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeBasicParams);
            }
            else
            {
              if (((ChangeVoiceView)localObject).a() == 1)
              {
                h();
                ((ChangeVoiceView)localObject).a(2);
                if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.d) {}
                for (i = 1;; i = 2)
                {
                  ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005473", "0X8005473", i, 0, this.jdField_a_of_type_Int + "", "", "", "7.6.3");
                  break;
                }
              }
              if (QLog.isColorLevel()) {
                QLog.e("changevoice", 2, "CLICK EXCEPTION， curtype = " + this.jdField_a_of_type_Int + " newtype is " + i + " state is " + ((ChangeVoiceView)localObject).a());
              }
            }
          }
        }
        a(4, ((ChangeVoiceView)localObject).jdField_a_of_type_Int, null, "该道具已下架", null, null, null);
        i = 0;
        break label160;
      }
      label799:
      i = -1;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    super.onTouchEvent(paramMotionEvent);
    return true;
  }
  
  public void setAudioPath(String paramString, double paramDouble, QQRecorder.RecorderParam paramRecorderParam)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Double = paramDouble;
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam = paramRecorderParam;
    this.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeBasicParams = new VoiceChangeBasicParams(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam.c, this.jdField_a_of_type_Int);
    if (AppSetting.jdField_b_of_type_Boolean) {
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
      if (jdField_b_of_type_Boolean) {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "changevoice", "0X8006F4F", 0, 0, "", "", "", "");
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.ListenChangeVoicePanel
 * JD-Core Version:    0.7.0.1
 */