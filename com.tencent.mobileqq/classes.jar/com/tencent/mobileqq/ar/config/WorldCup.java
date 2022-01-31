package com.tencent.mobileqq.ar.config;

import android.app.Activity;
import android.os.Build.VERSION;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import com.tencent.av.opengl.effects.EffectsRenderController;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.DeviceProfileManager.SimpleStringParser;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.PopupMenuDialog;

public class WorldCup
{
  public static int a(AppInterface paramAppInterface, View paramView, PopupMenuDialog paramPopupMenuDialog, int paramInt)
  {
    return WorldCupMgr.a(paramAppInterface).a(paramAppInterface, paramView, paramPopupMenuDialog, paramInt);
  }
  
  public static WorldCupConfigInfo a(AppInterface paramAppInterface)
  {
    return WorldCupMgr.a(paramAppInterface).a();
  }
  
  public static void a(AppInterface paramAppInterface)
  {
    WorldCupMgr.a(paramAppInterface).a(paramAppInterface);
  }
  
  public static void a(AppInterface paramAppInterface, int paramInt)
  {
    WorldCupMgr.a(paramAppInterface).a(paramAppInterface, paramInt);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, View paramView)
  {
    WorldCupMgr.a(paramQQAppInterface).a(paramQQAppInterface, paramActivity, paramView);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, FragmentActivity paramFragmentActivity, View paramView, String paramString)
  {
    WorldCupMgr.a(paramQQAppInterface).a(paramQQAppInterface, paramFragmentActivity, paramView, paramString);
  }
  
  public static boolean a()
  {
    return (b()) && (c());
  }
  
  public static boolean b()
  {
    if (WorldCupStaticInstance.a().a == -1L) {
      if (Build.VERSION.SDK_INT <= 20) {
        break label133;
      }
    }
    label131:
    label133:
    for (int i = 1;; i = 0)
    {
      int j;
      WorldCupStaticInstance localWorldCupStaticInstance;
      if ((EffectsRenderController.a(8, 1400000L, 2800000000L)) || (EffectsRenderController.a(4, 2150000L, 2800000000L)))
      {
        j = 1;
        localWorldCupStaticInstance = WorldCupStaticInstance.a();
        if ((j == 0) || (i == 0)) {
          break label126;
        }
      }
      label126:
      for (long l = 1L;; l = 0L)
      {
        localWorldCupStaticInstance.a = l;
        QLog.w("WorldCupMgr", 1, "isDevicesSupport, DeviceSupportFromLocal[" + WorldCupStaticInstance.a().a + "]");
        if (WorldCupStaticInstance.a().a != 1L) {
          break label131;
        }
        return true;
        j = 0;
        break;
      }
      return false;
    }
  }
  
  public static boolean c()
  {
    String str;
    Object localObject;
    int i;
    CharSequence localCharSequence;
    boolean bool;
    if (WorldCupStaticInstance.a().b == -1L)
    {
      str = DeviceProfileManager.b().a(DeviceProfileManager.DpcNames.ARCfg.name());
      if (TextUtils.isEmpty(str)) {
        break label186;
      }
      localObject = new String[13];
      i = DeviceProfileManager.a(str, (Object[])localObject, new DeviceProfileManager.SimpleStringParser());
      localCharSequence = null;
      if (localObject.length <= 12) {
        break label199;
      }
      localCharSequence = localObject[12];
      if (TextUtils.equals(localCharSequence, "1")) {
        break label176;
      }
      bool = true;
    }
    for (;;)
    {
      localObject = WorldCupStaticInstance.a();
      long l;
      if (bool)
      {
        l = 1L;
        label98:
        ((WorldCupStaticInstance)localObject).b = l;
        QLog.w("WorldCupMgr", 1, "isEnableInDPC, isEnable[" + bool + "], arCfg[" + str + "], size[" + i + "], params[" + localCharSequence + "]");
      }
      for (;;)
      {
        if (WorldCupStaticInstance.a().b != 1L) {
          break label197;
        }
        return true;
        label176:
        bool = false;
        break;
        l = 0L;
        break label98;
        label186:
        QLog.w("WorldCupMgr", 1, "isEnableInDPC, 没拉到dpc配置");
      }
      label197:
      return false;
      label199:
      bool = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ar.config.WorldCup
 * JD-Core Version:    0.7.0.1
 */