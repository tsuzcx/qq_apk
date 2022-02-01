package com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.msgbox;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyConstants;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.util.RIJQQAppInterfaceUtil;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJJumpUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.struct.KandianMsgBoxRedPntInfo;
import com.tencent.biz.pubaccount.readinjoy.viola.ViolaAccessHelper;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;
import mqq.app.AppRuntime;

public class RIJMsgBoxUtils
{
  private static Integer a = null;
  
  public static int a()
  {
    a = null;
    return b();
  }
  
  public static void a(Context paramContext, int paramInt)
  {
    a(paramContext, paramInt, false);
  }
  
  public static void a(Context paramContext, int paramInt, boolean paramBoolean)
  {
    a(paramContext, paramInt, paramBoolean, "");
  }
  
  public static void a(Context paramContext, int paramInt, boolean paramBoolean, String paramString)
  {
    int i = 2;
    Object localObject1 = (KandianMergeManager)RIJQQAppInterfaceUtil.a().getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER);
    int j = ((KandianMergeManager)localObject1).c();
    localObject1 = ((KandianMergeManager)localObject1).a();
    String str;
    if ((localObject1 == null) || (TextUtils.isEmpty(((KandianMsgBoxRedPntInfo)localObject1).mJumpUrl)))
    {
      str = ReadInJoyConstants.h + j + "&message_entry=" + paramInt;
      localObject1 = ViolaAccessHelper.a(RIJQQAppInterfaceUtil.a()) + "&adtag=1&privateLetters=" + j + "&message_entry=" + paramInt;
      Object localObject2 = localObject1;
      if (paramBoolean)
      {
        j = DisplayUtil.b(paramContext, (float)DeviceInfoUtil.l()) / 3;
        localObject2 = (String)localObject1 + "&v_present_radius=10&v_present=2&v_rij_floating=1&v_present_bar=0&v_nav_immer=1&hideNav=1&v_present_auto_top=0&v_present_top=" + j;
      }
      localObject1 = localObject2;
      if (!TextUtils.isEmpty(paramString)) {
        localObject1 = (String)localObject2 + "&msgId=" + paramString;
      }
      if (QLog.isColorLevel()) {
        QLog.d("RIJMsgBoxUtils", 2, "person message box url: " + str);
      }
      if (!Boolean.valueOf(ReadInJoyHelper.v(RIJQQAppInterfaceUtil.a())).booleanValue()) {
        break label393;
      }
      paramString = new Bundle();
      if (paramInt != 6) {
        break label383;
      }
      paramInt = i;
    }
    label393:
    for (;;)
    {
      if (paramInt != -1) {
        paramString.putInt("floating_window_scene", paramInt);
      }
      paramString.putInt("requestCode", 20001);
      ViolaAccessHelper.a(paramContext, HardCodeUtil.a(2131713067), (String)localObject1, paramString);
      return;
      str = ((KandianMsgBoxRedPntInfo)localObject1).mJumpUrl + "&privateLetters=" + j + "&message_entry=" + paramInt;
      localObject1 = ViolaAccessHelper.a(RIJQQAppInterfaceUtil.a()) + "&adtag=2&privateLetters=" + j + "&message_entry=" + paramInt;
      break;
      label383:
      if (paramInt == 5)
      {
        paramInt = 3;
        continue;
        paramString = new Bundle();
        paramString.putInt("requestCode", 20001);
        RIJJumpUtils.a(paramContext, str, paramString);
      }
      else
      {
        paramInt = -1;
      }
    }
  }
  
  public static int b()
  {
    if (a == null)
    {
      a = Integer.valueOf(Aladdin.getConfig(215).getIntegerFromString("message_reddot_style", 1));
      if ((!ReadInJoyHelper.m()) && (a.intValue() == 0)) {
        a = Integer.valueOf(1);
      }
      if ((a.intValue() == 2) && (RIJQQAppInterfaceUtil.a() != null))
      {
        KandianMsgBoxRedPntInfo localKandianMsgBoxRedPntInfo = ((KandianMergeManager)RIJQQAppInterfaceUtil.a().getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER)).a();
        if ((localKandianMsgBoxRedPntInfo == null) || (localKandianMsgBoxRedPntInfo.dataType == 1)) {
          break label142;
        }
        a = Integer.valueOf(1);
      }
    }
    label142:
    for (int i = 2;; i = 1)
    {
      QLog.d("RIJMsgBoxUtils", 1, "init msgboxUIMode : " + a + ", rule : " + i);
      return a.intValue();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.msgbox.RIJMsgBoxUtils
 * JD-Core Version:    0.7.0.1
 */