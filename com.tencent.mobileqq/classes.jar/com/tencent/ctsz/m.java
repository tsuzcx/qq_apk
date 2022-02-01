package com.tencent.ctsz;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.ims.signature.SignatureResult;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mqpsdk.INetTransportProvider.INetTransportCodec;
import com.tencent.mqpsdk.INetTransportProvider.INetTransportEventListener;
import com.tencent.msfmqpsdkbridge.MSFNetTransportProvider;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class m
  implements INetTransportProvider.INetTransportEventListener
{
  private static boolean jdField_a_of_type_Boolean = false;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  private MSFNetTransportProvider jdField_a_of_type_ComTencentMsfmqpsdkbridgeMSFNetTransportProvider = null;
  final String jdField_a_of_type_JavaLangString = a(new byte[] { 126, 92, 81, 90, 95, 86, 98, 98 });
  final String b = a(new byte[] { 96, 86, 80, 97, 86, 64, 118, 93, 71, 65, 74 });
  final String c = a(new byte[] { 96, 86, 80, 96, 71, 82, 94, 67, 118, 93, 71, 65, 74 });
  final String d = a(new byte[] { 96, 86, 80, 126, 87, 6, 118, 93, 71, 65, 74 });
  final String e = a(new byte[] { 96, 86, 80, 96, 90, 84 });
  final String f = a(new byte[] { 96, 86, 80, 112, 82, 80, 91, 86, 103, 90, 94, 86 });
  final String g = a(new byte[] { 64, 90, 84, 108, 80, 91, 86, 80, 88 });
  
  public m(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMsfmqpsdkbridgeMSFNetTransportProvider = ((MSFNetTransportProvider)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.MSF_NET_TRANSPORT_PROVIDER_HANDLER));
    this.jdField_a_of_type_ComTencentMsfmqpsdkbridgeMSFNetTransportProvider.setNetTransportEventListener(this.g, this);
  }
  
  private String a(Context paramContext)
  {
    paramContext = paramContext.getPackageManager().getPackageArchiveInfo(paramContext.getApplicationContext().getApplicationInfo().sourceDir, 1);
    if (paramContext == null) {
      return "";
    }
    return paramContext.versionName;
  }
  
  private static String a(byte[] paramArrayOfByte)
  {
    int j = paramArrayOfByte.length;
    int i = 0;
    while (i < j)
    {
      paramArrayOfByte[i] = ((byte)(paramArrayOfByte[i] ^ 0x33));
      i += 1;
    }
    return new String(paramArrayOfByte);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences(this.e, 0);
    SharedPreferences.Editor localEditor = localSharedPreferences.edit();
    int i = localSharedPreferences.getInt(this.b, -1);
    if ((i == -1) || ((i ^ 0x12) != paramInt1))
    {
      localEditor.putInt(this.b, paramInt1 ^ 0x12);
      localEditor.putLong(this.c, System.currentTimeMillis() ^ 0x12);
      localEditor.putInt(this.f, paramInt2);
      localEditor.commit();
    }
  }
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return;
      }
      String str1 = a(new byte[] { 87, 95, 84, 108, 70, 65, 95 });
      String str2 = a(new byte[] { 87, 95, 84, 108, 65, 81, 70, 71, 71, 92, 93 });
      String str3 = a(new byte[] { 87, 95, 84, 108, 95, 81, 70, 71, 71, 92, 93 });
      String str4 = a(new byte[] { 87, 95, 84, 108, 80, 92, 93, 71, 86, 93, 71 });
      String str5 = a(new byte[] { 87, 95, 84, 108, 71, 90, 71, 95, 86 });
      BaseActivity localBaseActivity = BaseActivity.sTopActivity;
      Intent localIntent = new Intent();
      localIntent.putExtra("type", 9);
      Bundle localBundle = new Bundle();
      localBundle.putString(str5, paramString1);
      localBundle.putString(str4, paramString2);
      localBundle.putString(str3, paramString3);
      localBundle.putString(str2, paramString4);
      localBundle.putString(str1, paramString5);
      localIntent.putExtras(localBundle);
      localIntent.setFlags(872415232);
      RouteUtils.a(localBaseActivity, localIntent, "/base/notification");
    }
  }
  
  private boolean a(Context paramContext)
  {
    try
    {
      paramContext = new JarFile(new File(paramContext.getApplicationContext().getApplicationInfo().sourceDir)).entries();
      HashSet localHashSet = new HashSet();
      while (paramContext.hasMoreElements())
      {
        String str = ((JarEntry)paramContext.nextElement()).getName();
        if (localHashSet.contains(str) == true) {
          return true;
        }
        localHashSet.add(str);
      }
      return false;
    }
    catch (OutOfMemoryError paramContext)
    {
      paramContext.printStackTrace();
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  private void b()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void a()
  {
    if (jdField_a_of_type_Boolean) {
      return;
    }
    jdField_a_of_type_Boolean = true;
    new m.1(this).start();
    jdField_a_of_type_Boolean = false;
  }
  
  public void a(Object paramObject1, Object paramObject2)
  {
    paramObject1 = this.jdField_a_of_type_ComTencentMsfmqpsdkbridgeMSFNetTransportProvider;
    if (paramObject1 == null) {
      return;
    }
    paramObject1 = paramObject1.getCodec("sig_check");
    if (paramObject1 == null) {
      return;
    }
    paramObject1 = (byte[])paramObject1.decode(paramObject2);
    if (paramObject1 == null) {
      return;
    }
    signature.SignatureResult localSignatureResult = new signature.SignatureResult();
    try
    {
      localSignatureResult.mergeFrom(paramObject1);
    }
    catch (Exception paramObject1)
    {
      paramObject1.printStackTrace();
    }
    int i = -1;
    int j = 604800;
    if (localSignatureResult.u32_check_result.has()) {
      i = localSignatureResult.u32_check_result.get();
    }
    boolean bool = localSignatureResult.str_title.has();
    String str3 = "";
    if (bool) {
      paramObject1 = localSignatureResult.str_title.get();
    } else {
      paramObject1 = "";
    }
    if (localSignatureResult.str_content.has()) {
      paramObject2 = localSignatureResult.str_content.get();
    } else {
      paramObject2 = "";
    }
    String str1;
    if (localSignatureResult.str_left_button.has()) {
      str1 = localSignatureResult.str_left_button.get();
    } else {
      str1 = "";
    }
    String str2;
    if (localSignatureResult.str_right_button.has()) {
      str2 = localSignatureResult.str_right_button.get();
    } else {
      str2 = "";
    }
    if (localSignatureResult.str_url.has()) {
      str3 = localSignatureResult.str_url.get();
    }
    if (localSignatureResult.u32_cache_time.has()) {
      j = localSignatureResult.u32_cache_time.get();
    }
    int k = 1;
    if ((i != 0) && (i != 1)) {
      if (i != 2)
      {
        if (i == 3) {}
      }
      else {
        a(paramObject1, paramObject2, str1, str2, str3);
      }
    }
    if (i == 0) {
      i = k;
    } else {
      i = 0;
    }
    a(i, j);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ctsz.m
 * JD-Core Version:    0.7.0.1
 */