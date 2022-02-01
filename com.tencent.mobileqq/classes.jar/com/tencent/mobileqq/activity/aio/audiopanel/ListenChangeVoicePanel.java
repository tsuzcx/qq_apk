package com.tencent.mobileqq.activity.aio.audiopanel;

import afgv;
import afhd;
import afhg;
import afhh;
import ahiu;
import amsw;
import amtj;
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
import anei;
import azcd;
import azcr;
import bcef;
import bfpm;
import bftt;
import bfur;
import bgge;
import bgrj;
import bgrk;
import bgrl;
import bgrm;
import bgrn;
import bhht;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie.SaveInputTypeTask;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.NoC2CExtensionInfo;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.QQRecorder.RecorderParam;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.mobileqq.vas.VasQuickUpdateManager.CallBacker;
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
import odq;
import org.json.JSONObject;

public class ListenChangeVoicePanel
  extends RelativeLayout
  implements afgv, DialogInterface.OnClickListener, View.OnClickListener, bgrj
{
  public static volatile azcd a;
  public static int[] a;
  public static String[] a;
  public static boolean b;
  public static int[] b;
  public static String[] b;
  private double jdField_a_of_type_Double;
  private volatile int jdField_a_of_type_Int = -1;
  public afhd a;
  Bundle jdField_a_of_type_AndroidOsBundle;
  Handler jdField_a_of_type_AndroidOsHandler = new afhg(this, Looper.getMainLooper());
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bgrk jdField_a_of_type_Bgrk;
  bhht jdField_a_of_type_Bhht;
  public ChangeVoiceView a;
  private QQRecorder.RecorderParam jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam;
  public VasQuickUpdateManager.CallBacker a;
  ListView jdField_a_of_type_ComTencentWidgetListView;
  protected String a;
  public WeakReference<BaseChatPie> a;
  ArrayList<bgrl> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  public boolean a;
  private int jdField_b_of_type_Int = -1;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private String jdField_b_of_type_JavaLangString;
  private WeakReference<QQAppInterface> jdField_b_of_type_JavaLangRefWeakReference;
  public ArrayList<bgrl> b;
  boolean jdField_c_of_type_Boolean;
  private int[] jdField_c_of_type_ArrayOfInt = new int[jdField_a_of_type_ArrayOfInt.length];
  
  static
  {
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { amtj.a(2131705299), amtj.a(2131705304), amtj.a(2131705281), amtj.a(2131705300), amtj.a(2131705298), amtj.a(2131705272), amtj.a(2131705259), amtj.a(2131705297), amtj.a(2131705280), amtj.a(2131705282), amtj.a(2131705267), amtj.a(2131705254), amtj.a(2131705265), amtj.a(2131705288), amtj.a(2131705256), amtj.a(2131705285), amtj.a(2131705270) };
    jdField_b_of_type_ArrayOfJavaLangString = new String[] { amtj.a(2131705286), amtj.a(2131705264), amtj.a(2131705260), amtj.a(2131705301), amtj.a(2131705266), amtj.a(2131705279), amtj.a(2131705262), amtj.a(2131705302), amtj.a(2131705268), amtj.a(2131705261), amtj.a(2131705289), amtj.a(2131705291), amtj.a(2131705271), amtj.a(2131705258), amtj.a(2131705255), amtj.a(2131705294), amtj.a(2131705293) };
    jdField_a_of_type_ArrayOfInt = new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16 };
    jdField_b_of_type_ArrayOfInt = new int[] { 2130838411, 2130838410, 2130838413, 2130838412, 2130838409, 2130838408, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
  }
  
  public ListenChangeVoicePanel(Context paramContext)
  {
    super(paramContext);
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker = new afhh(this);
    this.jdField_a_of_type_JavaLangString = "mvip.gxh.android.changevoice_";
  }
  
  public ListenChangeVoicePanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker = new afhh(this);
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
    if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null) && (((BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get()).sessionInfo != null) && (this.jdField_b_of_type_JavaLangRefWeakReference != null) && (this.jdField_b_of_type_JavaLangRefWeakReference.get() != null))
    {
      if (!((BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get()).mIsFromVoiceChangerGuide) {
        break label385;
      }
      j = 1;
      if (((BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get()).sessionInfo.curType != 0) {
        break label391;
      }
      i = 1;
    }
    for (;;)
    {
      bcef.b((QQAppInterface)this.jdField_b_of_type_JavaLangRefWeakReference.get(), "CliOper", "", "", "0X8005474", "0X8005474", j, 0, paramInt3 + "", i + "", "", "8.4.8");
      if ((this.jdField_a_of_type_JavaLangRefWeakReference.get() instanceof ahiu)) {
        odq.a((QQAppInterface)this.jdField_b_of_type_JavaLangRefWeakReference.get(), "P_CliOper", "Pb_account_lifeservice", "", "0X8005851", "0X8005851", 0, 0, "", "", "", "", false);
      }
      paramInt3 = Calendar.getInstance().get(11);
      Card localCard = ((amsw)((QQAppInterface)this.jdField_b_of_type_JavaLangRefWeakReference.get()).getManager(51)).c(((QQAppInterface)this.jdField_b_of_type_JavaLangRefWeakReference.get()).getCurrentAccountUin());
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
      label385:
      j = 2;
      break;
      label391:
      if (((BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get()).sessionInfo.curType == 3000) {
        i = 2;
      } else if (((BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get()).sessionInfo.curType == 1) {
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
          localObject2 = amtj.a(2131705274);
        }
      }
      a(paramInt1, i, null, (String)localObject1, null, (String)localObject2, str);
      if ((!this.jdField_c_of_type_Boolean) || (this.jdField_b_of_type_JavaLangRefWeakReference.get() == null)) {
        break;
      }
      bcef.b((QQAppInterface)this.jdField_b_of_type_JavaLangRefWeakReference.get(), "CliOper", "", "", "changevoice", "0X8006F45", 0, 0, "" + this.jdField_a_of_type_Int, "", "", "");
      return;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 106, null));
      return;
      localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = amtj.a(2131705296);
      }
      localObject1 = paramObject;
      if (TextUtils.isEmpty(paramObject)) {
        localObject1 = amtj.a(2131705277);
      }
      this.jdField_c_of_type_Boolean = true;
      paramObject = localObject1;
      localObject1 = localObject2;
      paramInt1 = 1;
      continue;
      localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = amtj.a(2131705284);
      }
      localObject1 = paramObject;
      if (TextUtils.isEmpty(paramObject)) {
        localObject1 = amtj.a(2131705269);
      }
      this.jdField_c_of_type_Boolean = true;
      paramObject = localObject1;
      localObject1 = localObject2;
      paramInt1 = 2;
      continue;
      localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = amtj.a(2131705278);
      }
      this.jdField_c_of_type_Boolean = true;
      localObject1 = localObject2;
      paramInt1 = 4;
      continue;
      localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = amtj.a(2131705295);
      }
      this.jdField_c_of_type_Boolean = true;
      localObject1 = localObject2;
      paramInt1 = 4;
      continue;
      localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = amtj.a(2131705276);
      }
      this.jdField_c_of_type_Boolean = true;
      localObject1 = localObject2;
      paramInt1 = 4;
      continue;
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        break label276;
      }
      localObject1 = amtj.a(2131705290);
      paramInt1 = 4;
      continue;
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        break label276;
      }
      localObject1 = amtj.a(2131705263);
      paramInt1 = 4;
      continue;
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        break label276;
      }
      localObject1 = amtj.a(2131705257);
      paramInt1 = 4;
      continue;
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        break label276;
      }
      localObject1 = amtj.a(2131705273);
      paramInt1 = 4;
    }
  }
  
  public void a(QQAppInterface arg1, BaseChatPie paramBaseChatPie, ViewGroup paramViewGroup)
  {
    this.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(???);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramBaseChatPie);
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131370054));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131370057));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    if (AppSetting.jdField_c_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_a_of_type_AndroidWidgetTextView.getText() + super.getContext().getString(2131691002));
      this.jdField_b_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_b_of_type_AndroidWidgetTextView.getText() + super.getContext().getString(2131691002));
    }
    this.jdField_a_of_type_ComTencentWidgetListView = ((ListView)super.findViewById(2131368268));
    this.jdField_a_of_type_Afhd = new afhd(super.getContext());
    this.jdField_a_of_type_Afhd.a = this;
    this.jdField_a_of_type_ComTencentWidgetListView.setAdapter(this.jdField_a_of_type_Afhd);
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
            paramBaseChatPie.add(new bgrl(k, paramViewGroup, str, 0, j, 1, new bgrm(jdField_b_of_type_ArrayOfInt[i], null, null, null)));
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
    ??? = VasQuickUpdateManager.getJSONFromLocal((AppRuntime)???, "changeVoice_json", bool, this.jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker);
    if (??? != null)
    {
      bool = ((bgrn)((QQAppInterface)this.jdField_b_of_type_JavaLangRefWeakReference.get()).getManager(176)).a(this.jdField_a_of_type_JavaUtilArrayList, (JSONObject)???);
      if (QLog.isColorLevel()) {
        QLog.d("ListenChangeVoicePanel", 2, "initVoiceDatas startDownload json.isLoaded=" + paramBoolean + ", isChecked=" + bool);
      }
    }
    synchronized (this.jdField_b_of_type_JavaUtilArrayList)
    {
      bgrl localbgrl;
      for (;;)
      {
        this.jdField_b_of_type_JavaUtilArrayList.clear();
        int i = this.jdField_a_of_type_JavaUtilArrayList.size() - 1;
        for (;;)
        {
          if (i < 0) {
            break label258;
          }
          localbgrl = (bgrl)this.jdField_a_of_type_JavaUtilArrayList.get(i);
          if (localbgrl.jdField_b_of_type_Int != 0)
          {
            if (6 <= i) {
              break;
            }
            this.jdField_b_of_type_JavaUtilArrayList.add(0, localbgrl);
          }
          i -= 1;
        }
        if ((QLog.isColorLevel()) || (paramBoolean)) {
          QLog.d("ListenChangeVoicePanel", 2, "initVoiceDatas null=xydata startDownload json. isLoaded=" + paramBoolean);
        }
      }
      this.jdField_b_of_type_JavaUtilArrayList.add(localbgrl);
    }
    label258:
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 101, null));
  }
  
  void a(boolean paramBoolean, int paramInt)
  {
    if (paramBoolean)
    {
      if ((this.jdField_a_of_type_Bhht == null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null))
      {
        this.jdField_a_of_type_Bhht = new bhht(((BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getActivity(), AIOUtils.dp2px(50.0F, super.getResources()));
        this.jdField_a_of_type_Bhht.setCancelable(true);
      }
      this.jdField_a_of_type_Bhht.c(paramInt);
      this.jdField_a_of_type_Bhht.show();
    }
    while ((this.jdField_a_of_type_Bhht == null) || (!this.jdField_a_of_type_Bhht.isShowing())) {
      return;
    }
    this.jdField_a_of_type_Bhht.dismiss();
  }
  
  public boolean a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "ListenPanel.onBackEvent() is called,audioPath is:" + this.jdField_b_of_type_JavaLangString);
    }
    setVisibility(8);
    PressToChangeVoicePanel localPressToChangeVoicePanel = (PressToChangeVoicePanel)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131372911);
    localPressToChangeVoicePanel.g();
    localPressToChangeVoicePanel.setVisibility(0);
    int i;
    if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null))
    {
      ((BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get()).recorderEnd(this.jdField_b_of_type_JavaLangString, null);
      bgrn.a(this.jdField_a_of_type_Bgrk);
      if (((BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get()).mIsFromVoiceChangerGuide) {
        i = 1;
      }
    }
    for (;;)
    {
      if ((this.jdField_b_of_type_JavaLangRefWeakReference != null) && (this.jdField_b_of_type_JavaLangRefWeakReference.get() != null))
      {
        bcef.b((QQAppInterface)this.jdField_b_of_type_JavaLangRefWeakReference.get(), "CliOper", "", "", "0X8005475", "0X8005475", i, 0, "", "", "", "8.4.8");
        if (jdField_a_of_type_Azcd != null) {
          jdField_a_of_type_Azcd.a((QQAppInterface)this.jdField_b_of_type_JavaLangRefWeakReference.get(), -1);
        }
        azcr.a((QQAppInterface)this.jdField_b_of_type_JavaLangRefWeakReference.get()).b();
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
      paramString1 = amtj.a(2131705303);
    }
    for (;;)
    {
      if (TextUtils.isEmpty(paramString2)) {
        paramString2 = amtj.a(2131705292);
      }
      for (;;)
      {
        if (TextUtils.isEmpty(paramString3)) {
          paramString3 = amtj.a(2131705287);
        }
        for (;;)
        {
          if (TextUtils.isEmpty(paramString4)) {
            paramString4 = amtj.a(2131705275);
          }
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.d("ListenChangeVoicePanel", 1, "showTips content=" + paramString2 + ", title=" + paramString1);
            }
            if (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)
            {
              paramString1 = bfur.a(((BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getActivity(), 0, paramString1, paramString2, paramString3, paramString4, this, this);
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
    bgrn.b(this.jdField_a_of_type_Bgrk);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelChangeVoiceView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelChangeVoiceView.a(1);
    }
  }
  
  public void c()
  {
    if ((this.jdField_b_of_type_JavaLangRefWeakReference != null) && (this.jdField_b_of_type_JavaLangRefWeakReference.get() != null)) {
      ((VasQuickUpdateManager)((QQAppInterface)this.jdField_b_of_type_JavaLangRefWeakReference.get()).getManager(184)).removeCallBacker(this.jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker);
    }
    if (this.jdField_b_of_type_JavaLangString == null) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("AIOAudioPanel", 2, "ListenPanel.onBackEvent() is called,audioPath is:" + this.jdField_b_of_type_JavaLangString);
      }
      f();
      bgrn.a(this.jdField_a_of_type_Bgrk);
    } while ((this.jdField_a_of_type_JavaLangRefWeakReference == null) || (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null));
    ((BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get()).recorderEnd(this.jdField_b_of_type_JavaLangString, null);
    Object localObject;
    int i;
    if ((this.jdField_b_of_type_JavaLangRefWeakReference != null) && (this.jdField_b_of_type_JavaLangRefWeakReference.get() != null))
    {
      localObject = (amsw)((QQAppInterface)this.jdField_b_of_type_JavaLangRefWeakReference.get()).getManager(51);
      if (((BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get()).isExtensionInfo()) {
        break label286;
      }
      localObject = ((amsw)localObject).a(((BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get()).sessionInfo.curFriendUin, ((BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get()).sessionInfo.curType, false);
      if ((localObject == null) || (((NoC2CExtensionInfo)localObject).pttChangeVoiceType == this.jdField_a_of_type_Int)) {
        break label341;
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
      label286:
      localObject = ((amsw)localObject).a(((BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get()).sessionInfo.curFriendUin, false);
      if ((localObject != null) && (((ExtensionInfo)localObject).pttChangeVoiceType != this.jdField_a_of_type_Int))
      {
        ((ExtensionInfo)localObject).pttChangeVoiceType = this.jdField_a_of_type_Int;
        i = 1;
      }
      else
      {
        i = 0;
        continue;
        label341:
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
    this.jdField_a_of_type_Bgrk.f = this.jdField_a_of_type_Int;
    if (this.jdField_b_of_type_JavaLangRefWeakReference.get() != null)
    {
      bftt.a(BaseApplication.getContext(), true);
      bgrn.b(((QQAppInterface)this.jdField_b_of_type_JavaLangRefWeakReference.get()).getApp(), this.jdField_a_of_type_Bgrk, PressToChangeVoicePanel.jdField_a_of_type_JavaLangString, this);
    }
  }
  
  public void f()
  {
    setVisibility(8);
    if (this.jdField_a_of_type_AndroidViewViewGroup != null)
    {
      PressToChangeVoicePanel localPressToChangeVoicePanel = (PressToChangeVoicePanel)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131372911);
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
          bgge.a((QQAppInterface)this.jdField_b_of_type_JavaLangRefWeakReference.get(), ((BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getActivity(), this.jdField_a_of_type_JavaLangString + j, 3, "1450000515", "LTMCLUB", super.getResources().getString(2131694649), "voiceVip");
          i = 0;
        }
      }
      for (;;)
      {
        if ((!this.jdField_c_of_type_Boolean) || (this.jdField_b_of_type_JavaLangRefWeakReference.get() == null)) {
          break label500;
        }
        bcef.b((QQAppInterface)this.jdField_b_of_type_JavaLangRefWeakReference.get(), "CliOper", "", "", "changevoice", "0X8006F46", 0, 0, "" + paramInt, "", "", "");
        if (paramInt != 1) {
          break;
        }
        bcef.b((QQAppInterface)this.jdField_b_of_type_JavaLangRefWeakReference.get(), "CliOper", "", "", "changevoice", "0X8006F46", 0, 0, "" + i, "", "", "");
        return;
        bgge.a((QQAppInterface)this.jdField_b_of_type_JavaLangRefWeakReference.get(), ((BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getActivity(), this.jdField_a_of_type_JavaLangString + j, 3, "1450000516", "CJCLUBT", super.getResources().getString(2131718745), "voiceSvip");
        i = 0;
        continue;
        if ((paramInt == 1) && (!TextUtils.isEmpty(paramDialogInterface)) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null))
        {
          Intent localIntent = new Intent(((BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getActivity(), QQBrowserActivity.class);
          localIntent.putExtra("url", paramDialogInterface);
          localIntent.putExtra("isShowAd", false);
          ((BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getActivity().startActivity(localIntent);
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
    if (i == 2131370054)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelChangeVoiceView != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelChangeVoiceView.a(1);
      }
      if (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null) {
        ((BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get()).recorderEnd(this.jdField_b_of_type_JavaLangString, null);
      }
      f();
      bgrn.a(this.jdField_a_of_type_Bgrk);
      i = 0;
      if (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)
      {
        if (((BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get()).mIsFromVoiceChangerGuide) {
          i = 1;
        }
      }
      else
      {
        if (this.jdField_b_of_type_JavaLangRefWeakReference.get() != null)
        {
          bcef.b((QQAppInterface)this.jdField_b_of_type_JavaLangRefWeakReference.get(), "CliOper", "", "", "0X8005475", "0X8005475", i, 0, "", "", "", "8.4.8");
          if ((this.jdField_a_of_type_JavaLangRefWeakReference.get() != null) && ((this.jdField_a_of_type_JavaLangRefWeakReference.get() instanceof ahiu))) {
            odq.a((QQAppInterface)this.jdField_b_of_type_JavaLangRefWeakReference.get(), "P_CliOper", "Pb_account_lifeservice", "", "0X8005852", "0X8005852", 0, 0, "", "", "", "", false);
          }
          azcr.a((QQAppInterface)this.jdField_b_of_type_JavaLangRefWeakReference.get()).b();
          if (jdField_a_of_type_Azcd != null) {
            jdField_a_of_type_Azcd.a((QQAppInterface)this.jdField_b_of_type_JavaLangRefWeakReference.get(), -1);
          }
        }
        i = 1;
      }
    }
    for (;;)
    {
      label241:
      Object localObject2;
      String str;
      if ((i >= 0) && (this.jdField_b_of_type_JavaLangRefWeakReference.get() != null))
      {
        localObject2 = (QQAppInterface)this.jdField_b_of_type_JavaLangRefWeakReference.get();
        str = "" + i;
        if (i != 0) {
          break label1000;
        }
      }
      label558:
      label589:
      label1000:
      for (Object localObject1 = "" + this.jdField_a_of_type_Int;; localObject1 = "")
      {
        bcef.b((QQAppInterface)localObject2, "CliOper", "", "", "changevoice", "0X8006F50", 0, 0, str, (String)localObject1, "", "");
        do
        {
          EventCollector.getInstance().onViewClicked(paramView);
          return;
          i = 2;
          break;
          if (i == 2131370057)
          {
            if (this.jdField_a_of_type_Int >= 6)
            {
              a(true, 2131697890);
              if (this.jdField_b_of_type_JavaLangRefWeakReference.get() == null) {
                break label1011;
              }
              ((anei)((QQAppInterface)this.jdField_b_of_type_JavaLangRefWeakReference.get()).getBusinessHandler(96)).a(1, this.jdField_a_of_type_Int, this);
              i = 2;
              break label241;
            }
            this.jdField_a_of_type_AndroidOsHandler.sendMessage(Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 106, null));
            i = 2;
            break label241;
          }
          this.jdField_a_of_type_Boolean = true;
          if (!(paramView instanceof ChangeVoiceView)) {
            break label1006;
          }
          localObject2 = (ChangeVoiceView)paramView;
        } while ((localObject2 == null) || (((ChangeVoiceView)localObject2).jdField_a_of_type_Bgrl == null));
        if (2 == ((ChangeVoiceView)localObject2).jdField_a_of_type_Bgrl.jdField_b_of_type_Int)
        {
          i = ((ChangeVoiceView)localObject2).jdField_a_of_type_Int;
          this.jdField_a_of_type_Afhd.jdField_b_of_type_Int = i;
          if (i != this.jdField_a_of_type_Int) {
            if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelChangeVoiceView == null)
            {
              if ((this.jdField_a_of_type_ComTencentWidgetListView != null) && (this.jdField_a_of_type_ComTencentWidgetListView.getChildCount() > 0) && ((this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(0) instanceof ViewGroup)))
              {
                localObject1 = (ViewGroup)this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(0);
                if ((localObject1 == null) || (((ViewGroup)localObject1).getChildCount() <= 0) || (!(((ViewGroup)localObject1).getChildAt(0) instanceof ChangeVoiceView))) {
                  break label754;
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
                if (!((BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get()).mIsFromVoiceChangerGuide) {
                  break label759;
                }
                i = 1;
              }
              if (this.jdField_b_of_type_JavaLangRefWeakReference.get() != null) {
                bcef.b((QQAppInterface)this.jdField_b_of_type_JavaLangRefWeakReference.get(), "CliOper", "", "", "0X8005473", "0X8005473", i, 0, this.jdField_a_of_type_Int + "", "", "", "8.4.8");
              }
              this.jdField_c_of_type_ArrayOfInt[this.jdField_a_of_type_Int] = 1;
            }
          }
          for (;;)
          {
            i = 0;
            break;
            localObject1 = null;
            break label558;
            label754:
            localObject1 = null;
            break label589;
            label759:
            i = 2;
            break label669;
            if (((ChangeVoiceView)localObject2).a() == 2)
            {
              ((ChangeVoiceView)localObject2).a(1);
              bgrn.b(this.jdField_a_of_type_Bgrk);
            }
            else if (((ChangeVoiceView)localObject2).a() == 1)
            {
              e();
              ((ChangeVoiceView)localObject2).a(2);
              i = 0;
              if (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null) {
                if (!((BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get()).mIsFromVoiceChangerGuide) {
                  break label906;
                }
              }
              for (i = 1;; i = 2)
              {
                if (this.jdField_b_of_type_JavaLangRefWeakReference.get() == null) {
                  break label909;
                }
                bcef.b((QQAppInterface)this.jdField_b_of_type_JavaLangRefWeakReference.get(), "CliOper", "", "", "0X8005473", "0X8005473", i, 0, this.jdField_a_of_type_Int + "", "", "", "8.4.8");
                break;
              }
            }
            else if (QLog.isColorLevel())
            {
              QLog.e("changevoice", 2, "CLICK EXCEPTION， curtype = " + this.jdField_a_of_type_Int + " newtype is " + i + " state is " + ((ChangeVoiceView)localObject2).a());
            }
          }
        }
        a(4, ((ChangeVoiceView)localObject2).jdField_a_of_type_Int, null, amtj.a(2131705283), null, null, null);
        i = 0;
        break label241;
      }
      label669:
      label1006:
      i = -1;
      label906:
      label909:
      continue;
      label1011:
      i = 2;
    }
  }
  
  public void onError()
  {
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 105, null));
    bgrn.b(this.jdField_a_of_type_Bgrk);
    bftt.a(BaseApplication.getContext(), false);
  }
  
  public void onPlayEnd()
  {
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 104, null));
  }
  
  public void onPlayStop()
  {
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 102, null));
    bftt.a(BaseApplication.getContext(), false);
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
  
  public void setAudioPath(String paramString, double paramDouble, QQRecorder.RecorderParam paramRecorderParam)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Double = paramDouble;
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam = paramRecorderParam;
    this.jdField_a_of_type_Bgrk = new bgrk(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam.c, this.jdField_a_of_type_Int);
    if (AppSetting.jdField_c_of_type_Boolean) {
      bfpm.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelChangeVoiceView);
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
        bcef.b((QQAppInterface)this.jdField_b_of_type_JavaLangRefWeakReference.get(), "CliOper", "", "", "changevoice", "0X8006F4F", 0, 0, "", "", "", "");
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.ListenChangeVoicePanel
 * JD-Core Version:    0.7.0.1
 */