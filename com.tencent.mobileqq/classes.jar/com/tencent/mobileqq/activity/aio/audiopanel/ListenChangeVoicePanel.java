package com.tencent.mobileqq.activity.aio.audiopanel;

import aepi;
import aexp;
import aexx;
import aeya;
import aeyb;
import agti;
import alto;
import alud;
import amfu;
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
import awge;
import awxy;
import awym;
import azqs;
import azri;
import bczz;
import bdgm;
import bdjz;
import bdun;
import bedj;
import bedk;
import bedl;
import bedm;
import bedn;
import bety;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.BaseChatPie.SaveInputTypeTask;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.NoC2CExtensionInfo;
import com.tencent.mobileqq.utils.QQRecorder.RecorderParam;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.mobileqq.vas.VasQuickUpdateManager.CallBacker;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import nrt;
import org.json.JSONObject;

public class ListenChangeVoicePanel
  extends RelativeLayout
  implements aexp, DialogInterface.OnClickListener, View.OnClickListener, bedj
{
  public static volatile awxy a;
  public static int[] a;
  public static String[] a;
  public static boolean b;
  public static int[] b;
  public static String[] b;
  private double jdField_a_of_type_Double;
  private volatile int jdField_a_of_type_Int = -1;
  public aexx a;
  Bundle jdField_a_of_type_AndroidOsBundle;
  Handler jdField_a_of_type_AndroidOsHandler = new aeya(this, Looper.getMainLooper());
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bedk jdField_a_of_type_Bedk;
  bety jdField_a_of_type_Bety;
  public ChangeVoiceView a;
  private QQRecorder.RecorderParam jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam;
  public VasQuickUpdateManager.CallBacker a;
  ListView jdField_a_of_type_ComTencentWidgetListView;
  protected String a;
  public WeakReference<BaseChatPie> a;
  ArrayList<bedl> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  public boolean a;
  private int jdField_b_of_type_Int = -1;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private String jdField_b_of_type_JavaLangString;
  private WeakReference<QQAppInterface> jdField_b_of_type_JavaLangRefWeakReference;
  public ArrayList<bedl> b;
  boolean jdField_c_of_type_Boolean;
  private int[] jdField_c_of_type_ArrayOfInt = new int[jdField_a_of_type_ArrayOfInt.length];
  
  static
  {
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { alud.a(2131706551), alud.a(2131706556), alud.a(2131706533), alud.a(2131706552), alud.a(2131706550), alud.a(2131706524), alud.a(2131706511), alud.a(2131706549), alud.a(2131706532), alud.a(2131706534), alud.a(2131706519), alud.a(2131706506), alud.a(2131706517), alud.a(2131706540), alud.a(2131706508), alud.a(2131706537), alud.a(2131706522) };
    jdField_b_of_type_ArrayOfJavaLangString = new String[] { alud.a(2131706538), alud.a(2131706516), alud.a(2131706512), alud.a(2131706553), alud.a(2131706518), alud.a(2131706531), alud.a(2131706514), alud.a(2131706554), alud.a(2131706520), alud.a(2131706513), alud.a(2131706541), alud.a(2131706543), alud.a(2131706523), alud.a(2131706510), alud.a(2131706507), alud.a(2131706546), alud.a(2131706545) };
    jdField_a_of_type_ArrayOfInt = new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16 };
    jdField_b_of_type_ArrayOfInt = new int[] { 2130838266, 2130838265, 2130838268, 2130838267, 2130838264, 2130838263, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
  }
  
  public ListenChangeVoicePanel(Context paramContext)
  {
    super(paramContext);
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker = new aeyb(this);
    this.jdField_a_of_type_JavaLangString = "mvip.gxh.android.changevoice_";
  }
  
  public ListenChangeVoicePanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker = new aeyb(this);
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
    if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null) && (((BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a != null) && (this.jdField_b_of_type_JavaLangRefWeakReference != null) && (this.jdField_b_of_type_JavaLangRefWeakReference.get() != null))
    {
      if (!((BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get()).e) {
        break label385;
      }
      j = 1;
      if (((BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a.jdField_a_of_type_Int != 0) {
        break label391;
      }
      i = 1;
    }
    for (;;)
    {
      azqs.b((QQAppInterface)this.jdField_b_of_type_JavaLangRefWeakReference.get(), "CliOper", "", "", "0X8005474", "0X8005474", j, 0, paramInt3 + "", i + "", "", "8.3.5");
      if ((this.jdField_a_of_type_JavaLangRefWeakReference.get() instanceof agti)) {
        nrt.a((QQAppInterface)this.jdField_b_of_type_JavaLangRefWeakReference.get(), "P_CliOper", "Pb_account_lifeservice", "", "0X8005851", "0X8005851", 0, 0, "", "", "", "", false);
      }
      paramInt3 = Calendar.getInstance().get(11);
      Card localCard = ((alto)((QQAppInterface)this.jdField_b_of_type_JavaLangRefWeakReference.get()).getManager(51)).c(((QQAppInterface)this.jdField_b_of_type_JavaLangRefWeakReference.get()).getCurrentAccountUin());
      azri localazri = azri.a(super.getContext());
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
      localazri.a("", "VCPttSendEvent", false, 0L, 0L, localHashMap, "");
      return;
      label385:
      j = 2;
      break;
      label391:
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
          localObject2 = alud.a(2131706526);
        }
      }
      a(paramInt1, i, null, (String)localObject1, null, (String)localObject2, str);
      if ((!this.jdField_c_of_type_Boolean) || (this.jdField_b_of_type_JavaLangRefWeakReference.get() == null)) {
        break;
      }
      azqs.b((QQAppInterface)this.jdField_b_of_type_JavaLangRefWeakReference.get(), "CliOper", "", "", "changevoice", "0X8006F45", 0, 0, "" + this.jdField_a_of_type_Int, "", "", "");
      return;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 106, null));
      return;
      localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = alud.a(2131706548);
      }
      localObject1 = paramObject;
      if (TextUtils.isEmpty(paramObject)) {
        localObject1 = alud.a(2131706529);
      }
      this.jdField_c_of_type_Boolean = true;
      paramObject = localObject1;
      localObject1 = localObject2;
      paramInt1 = 1;
      continue;
      localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = alud.a(2131706536);
      }
      localObject1 = paramObject;
      if (TextUtils.isEmpty(paramObject)) {
        localObject1 = alud.a(2131706521);
      }
      this.jdField_c_of_type_Boolean = true;
      paramObject = localObject1;
      localObject1 = localObject2;
      paramInt1 = 2;
      continue;
      localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = alud.a(2131706530);
      }
      this.jdField_c_of_type_Boolean = true;
      localObject1 = localObject2;
      paramInt1 = 4;
      continue;
      localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = alud.a(2131706547);
      }
      this.jdField_c_of_type_Boolean = true;
      localObject1 = localObject2;
      paramInt1 = 4;
      continue;
      localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = alud.a(2131706528);
      }
      this.jdField_c_of_type_Boolean = true;
      localObject1 = localObject2;
      paramInt1 = 4;
      continue;
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        break label276;
      }
      localObject1 = alud.a(2131706542);
      paramInt1 = 4;
      continue;
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        break label276;
      }
      localObject1 = alud.a(2131706515);
      paramInt1 = 4;
      continue;
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        break label276;
      }
      localObject1 = alud.a(2131706509);
      paramInt1 = 4;
      continue;
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        break label276;
      }
      localObject1 = alud.a(2131706525);
      paramInt1 = 4;
    }
  }
  
  public void a(QQAppInterface arg1, BaseChatPie paramBaseChatPie, ViewGroup paramViewGroup)
  {
    this.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(???);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramBaseChatPie);
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131369564));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131369567));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    if (AppSetting.jdField_c_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_a_of_type_AndroidWidgetTextView.getText() + super.getContext().getString(2131691159));
      this.jdField_b_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_b_of_type_AndroidWidgetTextView.getText() + super.getContext().getString(2131691159));
    }
    this.jdField_a_of_type_ComTencentWidgetListView = ((ListView)super.findViewById(2131367849));
    this.jdField_a_of_type_Aexx = new aexx(super.getContext());
    this.jdField_a_of_type_Aexx.a = this;
    this.jdField_a_of_type_ComTencentWidgetListView.setAdapter(this.jdField_a_of_type_Aexx);
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
            paramBaseChatPie.add(new bedl(k, paramViewGroup, str, 0, j, 1, new bedm(jdField_b_of_type_ArrayOfInt[i], null, null, null)));
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
      bool = ((bedn)((QQAppInterface)this.jdField_b_of_type_JavaLangRefWeakReference.get()).getManager(176)).a(this.jdField_a_of_type_JavaUtilArrayList, (JSONObject)???);
      if (QLog.isColorLevel()) {
        QLog.d("ListenChangeVoicePanel", 2, "initVoiceDatas startDownload json.isLoaded=" + paramBoolean + ", isChecked=" + bool);
      }
    }
    synchronized (this.jdField_b_of_type_JavaUtilArrayList)
    {
      bedl localbedl;
      for (;;)
      {
        this.jdField_b_of_type_JavaUtilArrayList.clear();
        int i = this.jdField_a_of_type_JavaUtilArrayList.size() - 1;
        for (;;)
        {
          if (i < 0) {
            break label258;
          }
          localbedl = (bedl)this.jdField_a_of_type_JavaUtilArrayList.get(i);
          if (localbedl.jdField_b_of_type_Int != 0)
          {
            if (6 <= i) {
              break;
            }
            this.jdField_b_of_type_JavaUtilArrayList.add(0, localbedl);
          }
          i -= 1;
        }
        if ((QLog.isColorLevel()) || (paramBoolean)) {
          QLog.d("ListenChangeVoicePanel", 2, "initVoiceDatas null=xydata startDownload json. isLoaded=" + paramBoolean);
        }
      }
      this.jdField_b_of_type_JavaUtilArrayList.add(localbedl);
    }
    label258:
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 101, null));
  }
  
  void a(boolean paramBoolean, int paramInt)
  {
    if (paramBoolean)
    {
      if ((this.jdField_a_of_type_Bety == null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null))
      {
        this.jdField_a_of_type_Bety = new bety(((BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(), aepi.a(50.0F, super.getResources()));
        this.jdField_a_of_type_Bety.setCancelable(true);
      }
      this.jdField_a_of_type_Bety.c(paramInt);
      this.jdField_a_of_type_Bety.show();
    }
    while ((this.jdField_a_of_type_Bety == null) || (!this.jdField_a_of_type_Bety.isShowing())) {
      return;
    }
    this.jdField_a_of_type_Bety.dismiss();
  }
  
  public boolean a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "ListenPanel.onBackEvent() is called,audioPath is:" + this.jdField_b_of_type_JavaLangString);
    }
    setVisibility(8);
    PressToChangeVoicePanel localPressToChangeVoicePanel = (PressToChangeVoicePanel)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131372239);
    localPressToChangeVoicePanel.g();
    localPressToChangeVoicePanel.setVisibility(0);
    int i;
    if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null))
    {
      ((BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get()).b(this.jdField_b_of_type_JavaLangString, null);
      bedn.a(this.jdField_a_of_type_Bedk);
      if (((BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get()).e) {
        i = 1;
      }
    }
    for (;;)
    {
      if ((this.jdField_b_of_type_JavaLangRefWeakReference != null) && (this.jdField_b_of_type_JavaLangRefWeakReference.get() != null))
      {
        azqs.b((QQAppInterface)this.jdField_b_of_type_JavaLangRefWeakReference.get(), "CliOper", "", "", "0X8005475", "0X8005475", i, 0, "", "", "", "8.3.5");
        if (jdField_a_of_type_Awxy != null) {
          jdField_a_of_type_Awxy.a((QQAppInterface)this.jdField_b_of_type_JavaLangRefWeakReference.get(), -1);
        }
        awym.a((QQAppInterface)this.jdField_b_of_type_JavaLangRefWeakReference.get()).b();
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
      paramString1 = alud.a(2131706555);
    }
    for (;;)
    {
      if (TextUtils.isEmpty(paramString2)) {
        paramString2 = alud.a(2131706544);
      }
      for (;;)
      {
        if (TextUtils.isEmpty(paramString3)) {
          paramString3 = alud.a(2131706539);
        }
        for (;;)
        {
          if (TextUtils.isEmpty(paramString4)) {
            paramString4 = alud.a(2131706527);
          }
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.d("ListenChangeVoicePanel", 1, "showTips content=" + paramString2 + ", title=" + paramString1);
            }
            if (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)
            {
              paramString1 = bdgm.a(((BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(), 0, paramString1, paramString2, paramString3, paramString4, this, this);
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
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 104, null));
  }
  
  public void c()
  {
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 105, null));
    bedn.b(this.jdField_a_of_type_Bedk);
  }
  
  public void d()
  {
    bedn.b(this.jdField_a_of_type_Bedk);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelChangeVoiceView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelChangeVoiceView.a(1);
    }
  }
  
  public void e()
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
      i();
      bedn.a(this.jdField_a_of_type_Bedk);
    } while ((this.jdField_a_of_type_JavaLangRefWeakReference == null) || (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null));
    ((BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get()).b(this.jdField_b_of_type_JavaLangString, null);
    Object localObject;
    int i;
    if ((this.jdField_b_of_type_JavaLangRefWeakReference != null) && (this.jdField_b_of_type_JavaLangRefWeakReference.get() != null))
    {
      localObject = (alto)((QQAppInterface)this.jdField_b_of_type_JavaLangRefWeakReference.get()).getManager(51);
      if (((BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get()).r()) {
        break label286;
      }
      localObject = ((alto)localObject).a(((BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a.jdField_a_of_type_JavaLangString, ((BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a.jdField_a_of_type_Int, false);
      if ((localObject == null) || (((NoC2CExtensionInfo)localObject).pttChangeVoiceType == this.jdField_a_of_type_Int)) {
        break label341;
      }
      ((NoC2CExtensionInfo)localObject).pttChangeVoiceType = this.jdField_a_of_type_Int;
      i = 1;
    }
    for (;;)
    {
      if ((i != 0) && (localObject != null)) {
        ThreadManager.getFileThreadHandler().post(new BaseChatPie.SaveInputTypeTask((awge)localObject, (QQAppInterface)this.jdField_b_of_type_JavaLangRefWeakReference.get()));
      }
      jdField_b_of_type_Boolean = false;
      return;
      label286:
      localObject = ((alto)localObject).a(((BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a.jdField_a_of_type_JavaLangString, false);
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
  
  public void f()
  {
    if (this.jdField_a_of_type_Int == -1) {
      ThreadManager.getSubThreadHandler().post(new ListenChangeVoicePanel.4(this));
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
    this.jdField_a_of_type_Bedk.f = this.jdField_a_of_type_Int;
    if (this.jdField_b_of_type_JavaLangRefWeakReference.get() != null) {
      bedn.b(((QQAppInterface)this.jdField_b_of_type_JavaLangRefWeakReference.get()).getApp(), this.jdField_a_of_type_Bedk, PressToChangeVoicePanel.jdField_a_of_type_JavaLangString, this);
    }
  }
  
  public void i()
  {
    setVisibility(8);
    if (this.jdField_a_of_type_AndroidViewViewGroup != null)
    {
      PressToChangeVoicePanel localPressToChangeVoicePanel = (PressToChangeVoicePanel)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131372239);
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
          bdun.a((QQAppInterface)this.jdField_b_of_type_JavaLangRefWeakReference.get(), ((BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(), this.jdField_a_of_type_JavaLangString + j, 3, "1450000515", "LTMCLUB", super.getResources().getString(2131695593), "voiceVip");
          i = 0;
        }
      }
      for (;;)
      {
        if ((!this.jdField_c_of_type_Boolean) || (this.jdField_b_of_type_JavaLangRefWeakReference.get() == null)) {
          break label500;
        }
        azqs.b((QQAppInterface)this.jdField_b_of_type_JavaLangRefWeakReference.get(), "CliOper", "", "", "changevoice", "0X8006F46", 0, 0, "" + paramInt, "", "", "");
        if (paramInt != 1) {
          break;
        }
        azqs.b((QQAppInterface)this.jdField_b_of_type_JavaLangRefWeakReference.get(), "CliOper", "", "", "changevoice", "0X8006F46", 0, 0, "" + i, "", "", "");
        return;
        bdun.a((QQAppInterface)this.jdField_b_of_type_JavaLangRefWeakReference.get(), ((BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(), this.jdField_a_of_type_JavaLangString + j, 3, "1450000516", "CJCLUBT", super.getResources().getString(2131720522), "voiceSvip");
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
    if (i == 2131369564)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelChangeVoiceView != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelChangeVoiceView.a(1);
      }
      if (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null) {
        ((BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get()).b(this.jdField_b_of_type_JavaLangString, null);
      }
      i();
      bedn.a(this.jdField_a_of_type_Bedk);
      i = 0;
      if (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)
      {
        if (((BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get()).e) {
          i = 1;
        }
      }
      else
      {
        if (this.jdField_b_of_type_JavaLangRefWeakReference.get() != null)
        {
          azqs.b((QQAppInterface)this.jdField_b_of_type_JavaLangRefWeakReference.get(), "CliOper", "", "", "0X8005475", "0X8005475", i, 0, "", "", "", "8.3.5");
          if ((this.jdField_a_of_type_JavaLangRefWeakReference.get() != null) && ((this.jdField_a_of_type_JavaLangRefWeakReference.get() instanceof agti))) {
            nrt.a((QQAppInterface)this.jdField_b_of_type_JavaLangRefWeakReference.get(), "P_CliOper", "Pb_account_lifeservice", "", "0X8005852", "0X8005852", 0, 0, "", "", "", "", false);
          }
          awym.a((QQAppInterface)this.jdField_b_of_type_JavaLangRefWeakReference.get()).b();
          if (jdField_a_of_type_Awxy != null) {
            jdField_a_of_type_Awxy.a((QQAppInterface)this.jdField_b_of_type_JavaLangRefWeakReference.get(), -1);
          }
        }
        i = 1;
      }
    }
    for (;;)
    {
      label241:
      Object localObject;
      String str;
      if ((i >= 0) && (this.jdField_b_of_type_JavaLangRefWeakReference.get() != null))
      {
        localObject = (QQAppInterface)this.jdField_b_of_type_JavaLangRefWeakReference.get();
        str = "" + i;
        if (i != 0) {
          break label977;
        }
      }
      label544:
      label575:
      label977:
      for (paramView = "" + this.jdField_a_of_type_Int;; paramView = "")
      {
        azqs.b((QQAppInterface)localObject, "CliOper", "", "", "changevoice", "0X8006F50", 0, 0, str, paramView, "", "");
        do
        {
          return;
          i = 2;
          break;
          if (i == 2131369567)
          {
            if (this.jdField_a_of_type_Int >= 6)
            {
              a(true, 2131698774);
              if (this.jdField_b_of_type_JavaLangRefWeakReference.get() == null) {
                break label988;
              }
              ((amfu)((QQAppInterface)this.jdField_b_of_type_JavaLangRefWeakReference.get()).a(96)).a(1, this.jdField_a_of_type_Int, this);
              i = 2;
              break label241;
            }
            this.jdField_a_of_type_AndroidOsHandler.sendMessage(Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 106, null));
            i = 2;
            break label241;
          }
          this.jdField_a_of_type_Boolean = true;
          if (!(paramView instanceof ChangeVoiceView)) {
            break label983;
          }
          localObject = (ChangeVoiceView)paramView;
        } while ((localObject == null) || (((ChangeVoiceView)localObject).jdField_a_of_type_Bedl == null));
        if (2 == ((ChangeVoiceView)localObject).jdField_a_of_type_Bedl.jdField_b_of_type_Int)
        {
          i = ((ChangeVoiceView)localObject).jdField_a_of_type_Int;
          this.jdField_a_of_type_Aexx.jdField_b_of_type_Int = i;
          if (i != this.jdField_a_of_type_Int) {
            if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelChangeVoiceView == null)
            {
              if ((this.jdField_a_of_type_ComTencentWidgetListView != null) && (this.jdField_a_of_type_ComTencentWidgetListView.getChildCount() > 0) && ((this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(0) instanceof ViewGroup)))
              {
                paramView = (ViewGroup)this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(0);
                if ((paramView == null) || (paramView.getChildCount() <= 0) || (!(paramView.getChildAt(0) instanceof ChangeVoiceView))) {
                  break label737;
                }
                paramView = (ChangeVoiceView)paramView.getChildAt(0);
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
              i = 0;
              if (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)
              {
                if (!((BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get()).e) {
                  break label742;
                }
                i = 1;
              }
              if (this.jdField_b_of_type_JavaLangRefWeakReference.get() != null) {
                azqs.b((QQAppInterface)this.jdField_b_of_type_JavaLangRefWeakReference.get(), "CliOper", "", "", "0X8005473", "0X8005473", i, 0, this.jdField_a_of_type_Int + "", "", "", "8.3.5");
              }
              this.jdField_c_of_type_ArrayOfInt[this.jdField_a_of_type_Int] = 1;
            }
          }
          for (;;)
          {
            i = 0;
            break;
            paramView = null;
            break label544;
            label737:
            paramView = null;
            break label575;
            label742:
            i = 2;
            break label652;
            if (((ChangeVoiceView)localObject).a() == 2)
            {
              ((ChangeVoiceView)localObject).a(1);
              bedn.b(this.jdField_a_of_type_Bedk);
            }
            else if (((ChangeVoiceView)localObject).a() == 1)
            {
              h();
              ((ChangeVoiceView)localObject).a(2);
              i = 0;
              if (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null) {
                if (!((BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get()).e) {
                  break label885;
                }
              }
              label885:
              for (i = 1;; i = 2)
              {
                if (this.jdField_b_of_type_JavaLangRefWeakReference.get() == null) {
                  break label888;
                }
                azqs.b((QQAppInterface)this.jdField_b_of_type_JavaLangRefWeakReference.get(), "CliOper", "", "", "0X8005473", "0X8005473", i, 0, this.jdField_a_of_type_Int + "", "", "", "8.3.5");
                break;
              }
            }
            else
            {
              label888:
              if (QLog.isColorLevel()) {
                QLog.e("changevoice", 2, "CLICK EXCEPTION， curtype = " + this.jdField_a_of_type_Int + " newtype is " + i + " state is " + ((ChangeVoiceView)localObject).a());
              }
            }
          }
        }
        a(4, ((ChangeVoiceView)localObject).jdField_a_of_type_Int, null, alud.a(2131706535), null, null, null);
        i = 0;
        break label241;
      }
      label652:
      label983:
      i = -1;
      continue;
      label988:
      i = 2;
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
    this.jdField_a_of_type_Bedk = new bedk(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam.c, this.jdField_a_of_type_Int);
    if (AppSetting.jdField_c_of_type_Boolean) {
      bczz.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelChangeVoiceView);
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
        azqs.b((QQAppInterface)this.jdField_b_of_type_JavaLangRefWeakReference.get(), "CliOper", "", "", "changevoice", "0X8006F4F", 0, 0, "", "", "", "");
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.ListenChangeVoicePanel
 * JD-Core Version:    0.7.0.1
 */