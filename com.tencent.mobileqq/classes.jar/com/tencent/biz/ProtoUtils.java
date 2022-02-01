package com.tencent.biz;

import android.os.Bundle;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import com.tencent.qphone.base.util.BaseApplication;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class ProtoUtils
{
  @ConfigInject(configPath="Foundation/QQCommon/src/main/resources/Inject_ProtoUtils.yml", version=1)
  public static ArrayList<Class<? extends IProtoUtils>> a = new ArrayList();
  
  static
  {
    a.add(ProtoUtilsImpl.class);
  }
  
  public static void a(AppRuntime paramAppRuntime, ProtoUtils.AppProtocolObserver paramAppProtocolObserver, byte[] paramArrayOfByte, String paramString, int paramInt1, int paramInt2, Bundle paramBundle, long paramLong)
  {
    if (paramAppRuntime == null) {
      return;
    }
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(paramInt1);
    localOIDBSSOPkg.uint32_service_type.set(paramInt2);
    localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(paramArrayOfByte));
    localOIDBSSOPkg.str_client_version.set(AppSetting.f());
    paramArrayOfByte = new NewIntent(paramAppRuntime.getApplicationContext(), ProtoServlet.class);
    if (paramBundle != null) {
      paramArrayOfByte.putExtras(paramBundle);
    }
    if (paramAppProtocolObserver != null)
    {
      paramAppProtocolObserver.a = new WeakReference(paramAppRuntime);
      paramAppProtocolObserver.mType = 1;
      paramArrayOfByte.setObserver(paramAppProtocolObserver);
    }
    paramArrayOfByte.putExtra("cmd", paramString);
    paramArrayOfByte.putExtra("data", localOIDBSSOPkg.toByteArray());
    if (paramLong > 0L) {
      paramArrayOfByte.putExtra("timeout", paramLong);
    }
    paramAppRuntime.startServlet(paramArrayOfByte);
  }
  
  public static void a(AppRuntime paramAppRuntime, ProtoUtils.StoryProtocolObserver paramStoryProtocolObserver, byte[] paramArrayOfByte, String paramString)
  {
    a(paramAppRuntime, paramStoryProtocolObserver, paramArrayOfByte, paramString, null);
  }
  
  public static void a(AppRuntime paramAppRuntime, ProtoUtils.StoryProtocolObserver paramStoryProtocolObserver, byte[] paramArrayOfByte, String paramString, Bundle paramBundle)
  {
    if (paramAppRuntime == null) {
      return;
    }
    NewIntent localNewIntent = new NewIntent(paramAppRuntime.getApplicationContext(), ProtoServlet.class);
    if (paramBundle != null) {
      localNewIntent.putExtras(paramBundle);
    }
    paramStoryProtocolObserver.a = new WeakReference(paramAppRuntime);
    localNewIntent.putExtra("cmd", paramString);
    localNewIntent.putExtra("data", paramArrayOfByte);
    localNewIntent.putExtra("isResend", false);
    localNewIntent.setObserver(paramStoryProtocolObserver);
    paramAppRuntime.startServlet(localNewIntent);
  }
  
  public static void a(AppRuntime paramAppRuntime, ProtoUtils.TroopProtocolObserver paramTroopProtocolObserver, byte[] paramArrayOfByte, String paramString)
  {
    a(paramAppRuntime, paramTroopProtocolObserver, paramArrayOfByte, paramString, null, false);
  }
  
  public static void a(AppRuntime paramAppRuntime, ProtoUtils.TroopProtocolObserver paramTroopProtocolObserver, byte[] paramArrayOfByte, String paramString, int paramInt1, int paramInt2)
  {
    a(paramAppRuntime, paramTroopProtocolObserver, paramArrayOfByte, paramString, paramInt1, paramInt2, null, 0L);
  }
  
  public static void a(AppRuntime paramAppRuntime, ProtoUtils.TroopProtocolObserver paramTroopProtocolObserver, byte[] paramArrayOfByte, String paramString, int paramInt1, int paramInt2, Bundle paramBundle)
  {
    a(paramAppRuntime, paramTroopProtocolObserver, paramArrayOfByte, paramString, paramInt1, paramInt2, paramBundle, 0L);
  }
  
  public static void a(AppRuntime paramAppRuntime, ProtoUtils.TroopProtocolObserver paramTroopProtocolObserver, byte[] paramArrayOfByte, String paramString, int paramInt1, int paramInt2, Bundle paramBundle, long paramLong)
  {
    if (paramAppRuntime == null) {
      return;
    }
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(paramInt1);
    localOIDBSSOPkg.uint32_service_type.set(paramInt2);
    localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(paramArrayOfByte));
    localOIDBSSOPkg.str_client_version.set(AppSetting.f());
    paramArrayOfByte = new NewIntent(BaseApplication.getContext(), ProtoServlet.class);
    if (paramBundle != null) {
      paramArrayOfByte.putExtras(paramBundle);
    }
    if (paramTroopProtocolObserver != null)
    {
      paramTroopProtocolObserver.mType = 1;
      paramArrayOfByte.setObserver(paramTroopProtocolObserver);
    }
    paramArrayOfByte.putExtra("cmd", paramString);
    paramArrayOfByte.putExtra("data", localOIDBSSOPkg.toByteArray());
    if (paramLong > 0L) {
      paramArrayOfByte.putExtra("timeout", paramLong);
    }
    paramAppRuntime.startServlet(paramArrayOfByte);
  }
  
  public static void a(AppRuntime paramAppRuntime, ProtoUtils.TroopProtocolObserver paramTroopProtocolObserver, byte[] paramArrayOfByte, String paramString, Bundle paramBundle)
  {
    a(paramAppRuntime, paramTroopProtocolObserver, paramArrayOfByte, paramString, paramBundle, false);
  }
  
  public static void a(AppRuntime paramAppRuntime, ProtoUtils.TroopProtocolObserver paramTroopProtocolObserver, byte[] paramArrayOfByte, String paramString, Bundle paramBundle, boolean paramBoolean)
  {
    if (paramAppRuntime == null) {
      return;
    }
    NewIntent localNewIntent = new NewIntent(paramAppRuntime.getApplicationContext(), ProtoServlet.class);
    if (paramBundle != null) {
      localNewIntent.putExtras(paramBundle);
    }
    paramTroopProtocolObserver.mApp = new WeakReference(paramAppRuntime);
    paramTroopProtocolObserver.mType = 2;
    localNewIntent.putExtra("cmd", paramString);
    localNewIntent.putExtra("data", paramArrayOfByte);
    localNewIntent.putExtra("isResend", paramBoolean);
    localNewIntent.setObserver(paramTroopProtocolObserver);
    paramAppRuntime.startServlet(localNewIntent);
  }
  
  public static void a(AppRuntime paramAppRuntime, byte[] paramArrayOfByte, String paramString)
  {
    a(paramAppRuntime, paramArrayOfByte, paramString, null, false);
  }
  
  public static void a(AppRuntime paramAppRuntime, byte[] paramArrayOfByte, String paramString, Bundle paramBundle, boolean paramBoolean)
  {
    if (paramAppRuntime == null) {
      return;
    }
    NewIntent localNewIntent = new NewIntent(paramAppRuntime.getApplicationContext(), ProtoServlet.class);
    if (paramBundle != null) {
      localNewIntent.putExtras(paramBundle);
    }
    localNewIntent.putExtra("cmd", paramString);
    localNewIntent.putExtra("data", paramArrayOfByte);
    localNewIntent.putExtra("isResend", paramBoolean);
    localNewIntent.putExtra("DataType", 2);
    paramAppRuntime.startServlet(localNewIntent);
  }
  
  public static void b(AppRuntime paramAppRuntime, ProtoUtils.TroopProtocolObserver paramTroopProtocolObserver, byte[] paramArrayOfByte, String paramString, int paramInt1, int paramInt2)
  {
    b(paramAppRuntime, paramTroopProtocolObserver, paramArrayOfByte, paramString, paramInt1, paramInt2, null, 0L);
  }
  
  public static void b(AppRuntime paramAppRuntime, ProtoUtils.TroopProtocolObserver paramTroopProtocolObserver, byte[] paramArrayOfByte, String paramString, int paramInt1, int paramInt2, Bundle paramBundle)
  {
    b(paramAppRuntime, paramTroopProtocolObserver, paramArrayOfByte, paramString, paramInt1, paramInt2, paramBundle, 0L);
  }
  
  private static void b(AppRuntime paramAppRuntime, ProtoUtils.TroopProtocolObserver paramTroopProtocolObserver, byte[] paramArrayOfByte, String paramString, int paramInt1, int paramInt2, Bundle paramBundle, long paramLong)
  {
    if (paramAppRuntime == null) {
      return;
    }
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(paramInt1);
    localOIDBSSOPkg.uint32_service_type.set(paramInt2);
    localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(paramArrayOfByte));
    localOIDBSSOPkg.str_client_version.set(AppSetting.f());
    paramArrayOfByte = new NewIntent(paramAppRuntime.getApplicationContext(), ProtoServlet.class);
    if (paramBundle != null) {
      paramArrayOfByte.putExtras(paramBundle);
    }
    if (paramTroopProtocolObserver != null)
    {
      paramTroopProtocolObserver.mApp = new WeakReference(paramAppRuntime);
      paramTroopProtocolObserver.mType = 1;
      paramArrayOfByte.setObserver(paramTroopProtocolObserver);
    }
    paramArrayOfByte.putExtra("cmd", paramString);
    paramArrayOfByte.putExtra("data", localOIDBSSOPkg.toByteArray());
    if (paramLong > 0L) {
      paramArrayOfByte.putExtra("timeout", paramLong);
    }
    paramAppRuntime.startServlet(paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.ProtoUtils
 * JD-Core Version:    0.7.0.1
 */