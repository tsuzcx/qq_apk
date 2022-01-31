package com.tencent.biz.pubaccount.readinjoy.engine;

import android.content.IntentFilter;
import android.os.Handler;
import android.support.v4.app.FragmentManager;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.Kandian210Msg0xeeInfo.NotifyInfo;
import com.tencent.biz.pubaccount.readinjoy.view.appinpush.AppInPushNotification;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.biz.pubaccount.util.ReadinjoyReportUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.mp.mobileqq_mp.ButtonInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.AbsStructMsgItem;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import lml;
import lmm;
import lmn;
import lmo;
import lmp;
import lmq;
import lmr;
import lms;
import lmt;
import lmu;
import lmv;
import lmw;
import lmx;
import lmy;
import lmz;
import mqq.app.AppRuntime;
import tencent.im.oidb.cmd0x80a.oidb_cmd0x80a.AttributeList;

public class ReadinjoySPEventReport
{
  private static int jdField_a_of_type_Int;
  private static volatile ReadinjoySPEventReport jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadinjoySPEventReport;
  private static lmz jdField_a_of_type_Lmz = new lmz(null);
  private static int jdField_b_of_type_Int;
  private static long jdField_b_of_type_Long;
  private static boolean jdField_b_of_type_Boolean;
  private static long jdField_c_of_type_Long;
  private static boolean jdField_c_of_type_Boolean;
  private static long jdField_d_of_type_Long;
  private static volatile boolean jdField_d_of_type_Boolean;
  private static long jdField_e_of_type_Long;
  private static long jdField_f_of_type_Long;
  private static long g;
  long jdField_a_of_type_Long = -1L;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper());
  private Pair jdField_a_of_type_AndroidUtilPair;
  private ReadinjoySPEventReport.ExitAIOAttributes jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadinjoySPEventReport$ExitAIOAttributes;
  private Runnable jdField_a_of_type_JavaLangRunnable = new lmx(this);
  String jdField_a_of_type_JavaLangString = "";
  private StringBuilder jdField_a_of_type_JavaLangStringBuilder = new StringBuilder(1024);
  private HashMap jdField_a_of_type_JavaUtilHashMap = (HashMap)ReadInJoyUtils.a(ReadInJoyUtils.a(), "kandian_aio_sp_word", true);
  private List jdField_a_of_type_JavaUtilList = new LinkedList();
  boolean jdField_a_of_type_Boolean = false;
  private Pair jdField_b_of_type_AndroidUtilPair;
  private List jdField_b_of_type_JavaUtilList = Collections.synchronizedList(new ArrayList());
  private List jdField_c_of_type_JavaUtilList = Collections.synchronizedList(new ArrayList());
  private List jdField_d_of_type_JavaUtilList = Collections.synchronizedList(new ArrayList());
  private boolean jdField_e_of_type_Boolean;
  private boolean jdField_f_of_type_Boolean;
  
  private ReadinjoySPEventReport()
  {
    n();
  }
  
  public static long a()
  {
    return jdField_d_of_type_Long;
  }
  
  private ReadinjoySPEventReport.ExitAIOAttributes a(List paramList)
  {
    ReadinjoySPEventReport.ExitAIOAttributes localExitAIOAttributes = new ReadinjoySPEventReport.ExitAIOAttributes(this);
    int i = 0;
    int j = 0;
    Object localObject1 = ReadInJoyHelper.a();
    long l5 = ((Integer)((Pair)localObject1).first).intValue();
    long l6 = ((Integer)((Pair)localObject1).second).intValue();
    long l1 = NetConnInfoCenter.getServerTime();
    int k = paramList.size() - 1;
    long l2;
    StringBuilder localStringBuilder;
    Object localObject2;
    Object localObject4;
    Object localObject3;
    long l4;
    long l3;
    String str1;
    if (k >= 0)
    {
      localObject1 = (ChatMessage)paramList.get(k);
      l2 = l1 - ((ChatMessage)localObject1).time;
      if ((l2 <= l5) || (l2 <= l6)) {}
    }
    else
    {
      localStringBuilder = new StringBuilder(1024);
      l1 = 0L;
      l2 = 0L;
      localObject1 = "0";
      localObject2 = "0";
      localObject4 = localObject2;
      localObject3 = localObject1;
      l4 = l2;
      l3 = l1;
      if (this.jdField_a_of_type_JavaUtilHashMap == null) {
        break label629;
      }
      localObject4 = localObject2;
      localObject3 = localObject1;
      l4 = l2;
      l3 = l1;
      if (this.jdField_a_of_type_JavaUtilHashMap.size() <= 0) {
        break label629;
      }
      k = paramList.size() - 1;
      for (;;)
      {
        localObject4 = localObject2;
        localObject3 = localObject1;
        l4 = l2;
        l3 = l1;
        if (paramList.size() - k >= 7) {
          break label629;
        }
        localObject4 = localObject2;
        localObject3 = localObject1;
        l4 = l2;
        l3 = l1;
        if (k < 0) {
          break label629;
        }
        localObject4 = (ChatMessage)paramList.get(k);
        str1 = ((ChatMessage)localObject4).msg;
        if (str1 != null) {
          break;
        }
        l4 = l1;
        l3 = l2;
        localObject4 = localObject1;
        localObject3 = localObject2;
        k -= 1;
        l1 = l4;
        l2 = l3;
        localObject1 = localObject4;
        localObject2 = localObject3;
      }
    }
    int m;
    if ((!((ChatMessage)localObject1).isSendFromLocal()) && (l2 <= l5))
    {
      m = j + 1;
      j = i;
      i = m;
    }
    for (;;)
    {
      m = k - 1;
      k = j;
      j = i;
      i = k;
      k = m;
      break;
      if ((((ChatMessage)localObject1).isSendFromLocal()) && (l2 <= l6))
      {
        m = i + 1;
        i = j;
        j = m;
        continue;
        Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
        localObject3 = "";
        label402:
        String str2;
        if (localIterator.hasNext())
        {
          str2 = (String)localIterator.next();
          if (!str1.contains(str2)) {
            break label1014;
          }
          if ("".equals(localObject3)) {
            localObject3 = (String)localObject3 + (String)this.jdField_a_of_type_JavaUtilHashMap.get(str2);
          }
        }
        label629:
        label1014:
        for (;;)
        {
          break label402;
          localObject3 = (String)localObject3 + "_" + (String)this.jdField_a_of_type_JavaUtilHashMap.get(str2);
          continue;
          if (((ChatMessage)localObject4).isSendFromLocal())
          {
            if ((l1 != 0L) || ("".equals(localObject3))) {
              break label987;
            }
            l3 = ((ChatMessage)localObject4).time;
            localObject1 = localObject2;
            localObject2 = localObject3;
            l1 = l2;
            l2 = l3;
          }
          for (;;)
          {
            localObject3 = localObject1;
            localObject4 = localObject2;
            l3 = l1;
            l4 = l2;
            if (l1 == 0L) {
              break;
            }
            localObject3 = localObject1;
            localObject4 = localObject2;
            l3 = l1;
            l4 = l2;
            if (l2 == 0L) {
              break;
            }
            l3 = l2;
            l4 = l1;
            localObject3 = localObject2;
            localObject4 = localObject1;
            localStringBuilder.append(l4).append(":").append((String)localObject4).append("`");
            localStringBuilder.append(l3).append(":").append((String)localObject3);
            paramList = ReadInJoyUtils.a();
            if ((paramList != null) && ((paramList instanceof QQAppInterface))) {}
            for (k = ((QQAppInterface)paramList).a().b();; k = 0)
            {
              paramList = new oidb_cmd0x80a.AttributeList();
              paramList.att_id.set(1);
              paramList.att_name.set("Time");
              paramList.att_value.set(String.valueOf(System.currentTimeMillis() / 1000L));
              localObject1 = new oidb_cmd0x80a.AttributeList();
              ((oidb_cmd0x80a.AttributeList)localObject1).att_id.set(2);
              ((oidb_cmd0x80a.AttributeList)localObject1).att_name.set("MsgPulse");
              ((oidb_cmd0x80a.AttributeList)localObject1).att_value.set(l5 + ":" + j + "`" + l6 + ":" + i);
              localObject2 = new oidb_cmd0x80a.AttributeList();
              ((oidb_cmd0x80a.AttributeList)localObject2).att_id.set(3);
              ((oidb_cmd0x80a.AttributeList)localObject2).att_name.set("Keyword");
              ((oidb_cmd0x80a.AttributeList)localObject2).att_value.set(localStringBuilder.toString());
              localObject3 = new oidb_cmd0x80a.AttributeList();
              ((oidb_cmd0x80a.AttributeList)localObject3).att_id.set(4);
              ((oidb_cmd0x80a.AttributeList)localObject3).att_name.set("LeftBtmRedCnt");
              ((oidb_cmd0x80a.AttributeList)localObject3).att_value.set(String.valueOf(k));
              localExitAIOAttributes.a = paramList;
              localExitAIOAttributes.b = ((oidb_cmd0x80a.AttributeList)localObject1);
              localExitAIOAttributes.c = ((oidb_cmd0x80a.AttributeList)localObject2);
              localExitAIOAttributes.d = ((oidb_cmd0x80a.AttributeList)localObject3);
              return localExitAIOAttributes;
              if ((l2 != 0L) || ("".equals(localObject3))) {
                break label987;
              }
              l2 = ((ChatMessage)localObject4).time;
              localObject2 = localObject1;
              l3 = l1;
              localObject1 = localObject3;
              l1 = l2;
              l2 = l3;
              break;
            }
            localObject3 = localObject1;
            l3 = l1;
            localObject1 = localObject2;
            localObject2 = localObject3;
            l1 = l2;
            l2 = l3;
          }
        }
      }
      else
      {
        label987:
        m = i;
        i = j;
        j = m;
      }
    }
  }
  
  public static ReadinjoySPEventReport a()
  {
    if (jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadinjoySPEventReport == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadinjoySPEventReport == null) {
        jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadinjoySPEventReport = new ReadinjoySPEventReport();
      }
      return jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadinjoySPEventReport;
    }
    finally {}
  }
  
  public static String a(long paramLong)
  {
    switch ((int)paramLong)
    {
    default: 
      return null;
    case 0: 
      return "KongJian";
    case 769: 
      return "YueDu";
    case 826: 
      return "BuLuo";
    case 1113: 
      return "DongMan";
    case 886: 
      return "FujinQun";
    case 871: 
      return "XinWen";
    case 879: 
      return "Now";
    case 3050: 
      return "RiJi";
    case 489: 
      return "YouXi";
    case 1047: 
      return "YinYue";
    case 763: 
      return "ChiHe";
    case 1041: 
      return "KeTang";
    case 858: 
      return "YunDong";
    case 3053: 
      return "GouWu";
    case 10000: 
      return "KongJian";
    case 10001: 
      return "FuJin";
    }
    return "XiaoYuan";
  }
  
  private String a(AbsStructMsgItem paramAbsStructMsgItem)
  {
    paramAbsStructMsgItem = paramAbsStructMsgItem.a.iterator();
    while (paramAbsStructMsgItem.hasNext())
    {
      AbsStructMsgElement localAbsStructMsgElement = (AbsStructMsgElement)paramAbsStructMsgItem.next();
      if ((localAbsStructMsgElement instanceof StructMsgItemTitle)) {
        return ((StructMsgItemTitle)localAbsStructMsgElement).b();
      }
    }
    return "";
  }
  
  private String a(List paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder(1024);
    if ((paramList == null) || (paramList.isEmpty())) {
      return "";
    }
    paramList = (ChatMessage)paramList.get(paramList.size() - 1);
    if (MessageForStructing.class.isInstance(paramList))
    {
      paramList = ((MessageForStructing)paramList).structingMsg;
      if (StructMsgForGeneralShare.class.isInstance(paramList))
      {
        paramList = ((StructMsgForGeneralShare)paramList).mStructMsgItemLists.iterator();
        while (paramList.hasNext())
        {
          Object localObject = (AbsStructMsgElement)paramList.next();
          if ((localObject instanceof AbsStructMsgItem))
          {
            localObject = a((AbsStructMsgItem)localObject);
            if (!TextUtils.isEmpty((CharSequence)localObject))
            {
              if (localStringBuilder.length() > 0) {
                localStringBuilder.append("`");
              }
              localStringBuilder.append((String)localObject);
            }
          }
        }
      }
    }
    return localStringBuilder.toString();
  }
  
  public static boolean a()
  {
    return jdField_b_of_type_Boolean;
  }
  
  public static long b()
  {
    return jdField_e_of_type_Long;
  }
  
  public static long c()
  {
    return jdField_f_of_type_Long;
  }
  
  public static void c(int paramInt)
  {
    int j = 1;
    int i = 1;
    boolean bool1 = false;
    Object localObject = BaseActivity.sTopActivity;
    if ((localObject != null) && ((localObject instanceof SplashActivity)))
    {
      localObject = (MainFragment)((SplashActivity)localObject).getSupportFragmentManager().findFragmentByTag(MainFragment.class.getName());
      if (localObject == null) {}
    }
    for (;;)
    {
      try
      {
        int k = MainFragment.jdField_a_of_type_Int;
        if (paramInt == k) {
          paramInt = j;
        }
      }
      catch (Exception localException1)
      {
        boolean bool2;
        paramInt = 0;
        AIOUtils.a("onMainFragmentTabClick", "onMainFragmentTabClick", localException1);
        continue;
      }
      try
      {
        j = ((View)((MainFragment)localObject).a().get("消息_num")).getVisibility();
        if (j != 0) {
          continue;
        }
        bool1 = true;
        paramInt = i;
      }
      catch (Exception localException2)
      {
        continue;
        bool1 = false;
        paramInt = 0;
        continue;
      }
      if (paramInt != 0) {
        c(paramInt, bool1);
      }
      return;
      bool1 = false;
      paramInt = i;
      continue;
      i = MainFragment.c;
      if (paramInt == i)
      {
        i = 2;
        paramInt = i;
        bool2 = ((MainFragment)localObject).a("联系人").a();
        bool1 = bool2;
        paramInt = i;
      }
      else
      {
        i = MainFragment.g;
        if (paramInt == i)
        {
          i = 3;
          paramInt = i;
          bool2 = ((MainFragment)localObject).a("看点").a();
          bool1 = bool2;
          paramInt = i;
        }
        else
        {
          i = MainFragment.d;
          if (paramInt == i)
          {
            i = 4;
            paramInt = i;
            bool2 = ((MainFragment)localObject).a("动态").a();
            bool1 = bool2;
            paramInt = i;
          }
          else
          {
            paramInt = 0;
          }
        }
      }
    }
  }
  
  public static void c(int paramInt, boolean paramBoolean)
  {
    ThreadManager.executeOnSubThread(new lmp(paramInt, paramBoolean));
  }
  
  private static void c(boolean paramBoolean)
  {
    ThreadManager.executeOnSubThread(new lmt(paramBoolean));
  }
  
  private static boolean c(int paramInt)
  {
    long l1 = System.currentTimeMillis();
    switch (paramInt)
    {
    }
    for (;;)
    {
      return false;
      long l2 = jdField_b_of_type_Long;
      if (((SPEventReportSwitch.a()) && (l1 - l2 >= SPEventReportSwitch.b() * 1000)) || (SPEventReportSwitch.a(paramInt)))
      {
        return true;
        if (SPEventReportSwitch.a(paramInt))
        {
          return true;
          if (SPEventReportSwitch.a(paramInt))
          {
            return true;
            if (SPEventReportSwitch.a(paramInt))
            {
              return true;
              if (((SPEventReportSwitch.a()) && (l1 - jdField_c_of_type_Long >= SPEventReportSwitch.c() * 1000) && (jdField_a_of_type_Int <= 1)) || (SPEventReportSwitch.a(paramInt)))
              {
                return true;
                int i;
                if (Calendar.getInstance().get(5) != jdField_b_of_type_Int)
                {
                  i = 1;
                  if ((i == 0) && ((!SPEventReportSwitch.a()) || (!SPEventReportSwitch.a(paramInt)))) {
                    break label239;
                  }
                }
                label239:
                for (boolean bool = true;; bool = false)
                {
                  return bool;
                  i = 0;
                  break;
                }
                return true;
                try
                {
                  Pair localPair = ReadInJoyHelper.b();
                  paramInt = (int)(Long.valueOf(ReadInJoyUtils.a()).longValue() % 100L);
                  if ((localPair != null) && (paramInt >= ((Integer)localPair.first).intValue()))
                  {
                    i = ((Integer)localPair.second).intValue();
                    if (paramInt <= i) {
                      return true;
                    }
                  }
                }
                catch (Exception localException)
                {
                  localException.printStackTrace();
                }
              }
            }
          }
        }
      }
    }
    return false;
  }
  
  public static void d()
  {
    jdField_d_of_type_Long = System.currentTimeMillis();
  }
  
  private void d(int paramInt)
  {
    if (c(12))
    {
      ArrayList localArrayList = new ArrayList();
      oidb_cmd0x80a.AttributeList localAttributeList = new oidb_cmd0x80a.AttributeList();
      localAttributeList.att_id.set(1);
      localAttributeList.att_name.set("Type");
      localAttributeList.att_value.set(String.valueOf(paramInt));
      localArrayList.add(localAttributeList);
      PublicAccountUtil.a(12, "MsgReadingPulse", localArrayList);
    }
  }
  
  public static void e()
  {
    jdField_e_of_type_Long = System.currentTimeMillis();
  }
  
  public static void f()
  {
    jdField_f_of_type_Long = System.currentTimeMillis();
  }
  
  public static void g()
  {
    d();
    ThreadManager.executeOnSubThread(new lmr());
  }
  
  public static void h()
  {
    if (c(11))
    {
      AppRuntime localAppRuntime = ReadInJoyUtils.a();
      if ((localAppRuntime != null) && ((localAppRuntime instanceof QQAppInterface)) && (!((QQAppInterface)localAppRuntime).a.b()))
      {
        PublicAccountUtil.a(11, "MsgTabExposure", new ArrayList());
        jdField_b_of_type_Int = Calendar.getInstance().get(5);
      }
    }
    else
    {
      return;
    }
    jdField_c_of_type_Boolean = true;
  }
  
  public static void i()
  {
    if (jdField_c_of_type_Boolean)
    {
      ThreadManager.executeOnSubThread(new lms());
      jdField_c_of_type_Boolean = false;
    }
  }
  
  public static void j()
  {
    if (jdField_d_of_type_Boolean) {
      return;
    }
    jdField_d_of_type_Boolean = true;
    try
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
      localIntentFilter.addAction("android.intent.action.SCREEN_ON");
      BaseApplicationImpl.getContext().registerReceiver(jdField_a_of_type_Lmz, localIntentFilter);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public static void l()
  {
    ThreadManager.executeOnSubThread(new lmo(System.currentTimeMillis() - a()));
  }
  
  public static void m()
  {
    ThreadManager.executeOnSubThread(new lmq());
  }
  
  private void n() {}
  
  private void o()
  {
    if (c(14))
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadinjoySPEventReport$ExitAIOAttributes.a);
      localArrayList.add(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadinjoySPEventReport$ExitAIOAttributes.c);
      localArrayList.add(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadinjoySPEventReport$ExitAIOAttributes.d);
      PublicAccountUtil.a(14, "ExitAIOWithNoMsgUnread", localArrayList);
    }
  }
  
  public ReadinjoySPEventReport.ExitAIOAttributes a()
  {
    ReadinjoySPEventReport.ExitAIOAttributes localExitAIOAttributes = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadinjoySPEventReport$ExitAIOAttributes;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadinjoySPEventReport$ExitAIOAttributes = null;
    return localExitAIOAttributes;
  }
  
  public ArrayList a()
  {
    int j = 0;
    ArrayList localArrayList = new ArrayList();
    StringBuilder localStringBuilder = new StringBuilder(1024);
    int i;
    Pair localPair;
    if (this.jdField_b_of_type_JavaUtilList.size() > 0)
    {
      localObject = new ArrayList(this.jdField_b_of_type_JavaUtilList);
      i = 0;
      while (i < ((ArrayList)localObject).size())
      {
        localPair = (Pair)((ArrayList)localObject).get(i);
        if (i != 0) {
          localStringBuilder.append("`");
        }
        localStringBuilder.append(String.valueOf(localPair.first));
        if (i != 0) {
          localStringBuilder.append(":").append(String.valueOf(localPair.second));
        }
        i += 1;
      }
      this.jdField_b_of_type_JavaUtilList.clear();
    }
    Object localObject = new oidb_cmd0x80a.AttributeList();
    ((oidb_cmd0x80a.AttributeList)localObject).att_id.set(103);
    ((oidb_cmd0x80a.AttributeList)localObject).att_name.set("LeftBtmRedPntPulse");
    ((oidb_cmd0x80a.AttributeList)localObject).att_value.set(localStringBuilder.toString());
    localArrayList.add(localObject);
    localStringBuilder.setLength(0);
    localStringBuilder.trimToSize();
    if (this.jdField_c_of_type_JavaUtilList.size() > 0)
    {
      localObject = new ArrayList(this.jdField_c_of_type_JavaUtilList);
      i = 0;
      while (i < ((ArrayList)localObject).size())
      {
        localPair = (Pair)((ArrayList)localObject).get(i);
        if (i != 0) {
          localStringBuilder.append("`");
        }
        localStringBuilder.append(String.valueOf(localPair.first));
        if (i != 0) {
          localStringBuilder.append(":").append(String.valueOf(localPair.second));
        }
        i += 1;
      }
      this.jdField_c_of_type_JavaUtilList.clear();
    }
    localObject = new oidb_cmd0x80a.AttributeList();
    ((oidb_cmd0x80a.AttributeList)localObject).att_id.set(104);
    ((oidb_cmd0x80a.AttributeList)localObject).att_name.set("FirstScnRedPntPulse");
    ((oidb_cmd0x80a.AttributeList)localObject).att_value.set(localStringBuilder.toString());
    localArrayList.add(localObject);
    localStringBuilder.setLength(0);
    localStringBuilder.trimToSize();
    if (this.jdField_d_of_type_JavaUtilList.size() > 0)
    {
      localObject = new ArrayList(this.jdField_d_of_type_JavaUtilList);
      i = j;
      while (i < ((ArrayList)localObject).size())
      {
        localPair = (Pair)((ArrayList)localObject).get(i);
        if (i != 0) {
          localStringBuilder.append("`");
        }
        localStringBuilder.append(String.valueOf(localPair.first));
        if (i != 0) {
          localStringBuilder.append(":").append(String.valueOf(localPair.second));
        }
        i += 1;
      }
      this.jdField_d_of_type_JavaUtilList.clear();
    }
    localObject = new oidb_cmd0x80a.AttributeList();
    ((oidb_cmd0x80a.AttributeList)localObject).att_id.set(105);
    ((oidb_cmd0x80a.AttributeList)localObject).att_name.set("AIOPulse");
    ((oidb_cmd0x80a.AttributeList)localObject).att_value.set(localStringBuilder.toString());
    localArrayList.add(localObject);
    return localArrayList;
  }
  
  public void a()
  {
    ThreadManager.post(new lml(this), 8, null, true);
  }
  
  public void a(int paramInt)
  {
    ThreadManager.executeOnSubThread(new lmu(this, paramInt));
  }
  
  public void a(int paramInt, long paramLong)
  {
    ThreadManager.executeOnSubThread(new lmm(this, paramInt, paramLong));
  }
  
  public void a(int paramInt, Kandian210Msg0xeeInfo.NotifyInfo paramNotifyInfo)
  {
    ThreadManager.executeOnSubThread(new lmy(this, paramNotifyInfo, paramInt));
  }
  
  public void a(int paramInt1, List paramList, String paramString, int paramInt2)
  {
    AppInPushNotification.a(2);
    if ((paramInt2 == 0) || (paramInt2 == 1) || (paramInt2 == 3000) || (a(paramInt2)))
    {
      if (paramInt1 == 1) {
        e();
      }
      ThreadManager.executeOnSubThread(new lmv(this, paramInt1, paramList));
      return;
    }
    if (paramInt1 == 1)
    {
      f();
      return;
    }
    long l1 = System.currentTimeMillis();
    long l2 = c();
    a().a(paramString, l1 - l2);
  }
  
  public void a(int paramInt, boolean paramBoolean) {}
  
  public void a(String paramString)
  {
    try
    {
      oidb_cmd0x80a.AttributeList localAttributeList = new oidb_cmd0x80a.AttributeList();
      localAttributeList.att_id.set(1);
      localAttributeList.att_name.set("ActType");
      localAttributeList.att_value.set(paramString);
      ArrayList localArrayList = new ArrayList(1);
      localArrayList.add(localAttributeList);
      PublicAccountUtil.a(3, "ActInNews", localArrayList);
      if (QLog.isColorLevel()) {
        QLog.d("ReadinjoySPEventReport", 2, "reportQQNewsAction actType:" + paramString);
      }
      return;
    }
    catch (Exception paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("ReadinjoySPEventReport", 2, "reportQQNewsAction", paramString);
    }
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, mobileqq_mp.ButtonInfo paramButtonInfo)
  {
    try
    {
      if ("2909288299".equals(paramString)) {
        a("GetNextMsg");
      }
      return;
    }
    catch (Exception paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("ReadinjoySPEventReport", 2, "reportPubAioMenuAction", paramString);
    }
  }
  
  public void a(String paramString, long paramLong)
  {
    ThreadManager.executeOnSubThread(new lmn(this, paramString, paramLong));
  }
  
  public void a(String paramString1, long paramLong, boolean paramBoolean, String paramString2, String paramString3)
  {
    try
    {
      oidb_cmd0x80a.AttributeList localAttributeList1 = new oidb_cmd0x80a.AttributeList();
      localAttributeList1.att_id.set(1);
      localAttributeList1.att_name.set("ActType");
      localAttributeList1.att_value.set(paramString1);
      oidb_cmd0x80a.AttributeList localAttributeList2 = new oidb_cmd0x80a.AttributeList();
      localAttributeList2.att_id.set(2);
      localAttributeList2.att_name.set("HasRedPnt");
      Object localObject2 = localAttributeList2.att_value;
      if (paramBoolean) {}
      for (Object localObject1 = "1";; localObject1 = "0")
      {
        ((PBStringField)localObject2).set((String)localObject1);
        localObject1 = new oidb_cmd0x80a.AttributeList();
        ((oidb_cmd0x80a.AttributeList)localObject1).att_id.set(3);
        ((oidb_cmd0x80a.AttributeList)localObject1).att_name.set("Time");
        ((oidb_cmd0x80a.AttributeList)localObject1).att_value.set(String.valueOf(paramLong));
        localObject2 = new oidb_cmd0x80a.AttributeList();
        ((oidb_cmd0x80a.AttributeList)localObject2).att_id.set(4);
        ((oidb_cmd0x80a.AttributeList)localObject2).att_name.set("Exposures");
        ((oidb_cmd0x80a.AttributeList)localObject2).att_value.set(paramString2);
        paramString2 = new oidb_cmd0x80a.AttributeList();
        paramString2.att_id.set(5);
        paramString2.att_name.set("Clicks");
        paramString2.att_value.set(paramString3);
        paramString3 = new ArrayList(3);
        paramString3.add(localAttributeList1);
        paramString3.add(localAttributeList2);
        paramString3.add(localObject1);
        paramString3.add(localObject2);
        paramString3.add(paramString2);
        PublicAccountUtil.a(3, "ActInNews", paramString3);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("ReadinjoySPEventReport", 2, "reportQQNewsAction actType:" + paramString1);
        return;
      }
      return;
    }
    catch (Exception paramString1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadinjoySPEventReport", 2, "reportQQNewsAction", paramString1);
      }
    }
  }
  
  public void a(String paramString, long paramLong, boolean paramBoolean, List paramList)
  {
    if ("2909288299".equals(paramString))
    {
      a("Enter", paramLong, paramBoolean, a(paramList), this.jdField_a_of_type_JavaLangStringBuilder.toString());
      this.jdField_a_of_type_JavaLangStringBuilder.setLength(0);
    }
  }
  
  public void a(String paramString, AbsStructMsgElement paramAbsStructMsgElement)
  {
    if ("2909288299".equals(paramString))
    {
      a("ClickMsg");
      if ((paramAbsStructMsgElement != null) && ((paramAbsStructMsgElement instanceof AbsStructMsgItem)))
      {
        paramString = a((AbsStructMsgItem)paramAbsStructMsgElement);
        if (!TextUtils.isEmpty(paramString))
        {
          if (this.jdField_a_of_type_JavaLangStringBuilder.length() > 0) {
            this.jdField_a_of_type_JavaLangStringBuilder.append("`");
          }
          this.jdField_a_of_type_JavaLangStringBuilder.append(paramString);
        }
      }
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  public void a(boolean paramBoolean)
  {
    jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public boolean a(int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    switch (paramInt)
    {
    default: 
      bool1 = bool2;
      if (paramInt >= 1000)
      {
        bool1 = bool2;
        if (paramInt <= 1034) {
          bool1 = true;
        }
      }
      break;
    }
    return bool1;
  }
  
  public void b()
  {
    try
    {
      Object localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      int i = ((QQAppInterface)localObject1).a().b();
      boolean bool = ReadInJoyUtils.c((QQAppInterface)localObject1);
      oidb_cmd0x80a.AttributeList localAttributeList1 = new oidb_cmd0x80a.AttributeList();
      localAttributeList1.att_id.set(1);
      localAttributeList1.att_name.set("UnreadMsg");
      localAttributeList1.att_value.set(String.valueOf(i));
      oidb_cmd0x80a.AttributeList localAttributeList2 = new oidb_cmd0x80a.AttributeList();
      localAttributeList2.att_id.set(2);
      localAttributeList2.att_name.set("KDInScreen");
      Object localObject2 = localAttributeList2.att_value;
      if (bool) {}
      for (localObject1 = "1";; localObject1 = "0")
      {
        ((PBStringField)localObject2).set((String)localObject1);
        localObject1 = new oidb_cmd0x80a.AttributeList();
        ((oidb_cmd0x80a.AttributeList)localObject1).att_id.set(3);
        ((oidb_cmd0x80a.AttributeList)localObject1).att_name.set("FoldStatus");
        ((oidb_cmd0x80a.AttributeList)localObject1).att_value.set(ReadInJoyUtils.d + "");
        localObject2 = new ArrayList(3);
        ((List)localObject2).add(localAttributeList1);
        ((List)localObject2).add(localAttributeList2);
        ((List)localObject2).add(localObject1);
        PublicAccountUtil.a(1, "RefreshTab", (List)localObject2);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("ReadinjoySPEventReport", 2, "reportManualRefresMsg unRead:" + i + " isFirst:" + bool);
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadinjoySPEventReport", 2, "reportManualRefresMsg", localException);
      }
    }
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, paramInt * 1000);
  }
  
  public void b(int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaLangString = a(paramInt);
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  public void c()
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      ReadinjoyReportUtils.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Boolean, System.currentTimeMillis() - this.jdField_a_of_type_Long);
      this.jdField_a_of_type_JavaLangString = "";
    }
  }
  
  public void k()
  {
    ThreadManager.executeOnSubThread(new lmw(this));
    this.jdField_f_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.ReadinjoySPEventReport
 * JD-Core Version:    0.7.0.1
 */