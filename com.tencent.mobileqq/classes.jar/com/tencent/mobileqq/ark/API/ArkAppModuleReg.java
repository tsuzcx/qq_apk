package com.tencent.mobileqq.ark.API;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.ark.ark.ModuleCallbackWrapper;
import com.tencent.ark.ark.ModuleRegister;
import com.tencent.ark.ark.VariantWrapper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.ArkAiAppCenter;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.ark.ArkAppDataReport;
import com.tencent.mobileqq.ark.ArkLocalAppMgr;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ArkAppModuleReg
{
  private static HashMap a = new HashMap();
  
  protected static Intent a(Context paramContext, String paramString, boolean paramBoolean, long paramLong, MessageForArkApp paramMessageForArkApp)
  {
    Intent localIntent = new Intent();
    localIntent.setClassName("com.tencent.mobileqq", "com.tencent.mobileqq.activity.QQBrowserDelegationActivity");
    localIntent.putExtra("param_force_internal_browser", paramBoolean);
    localIntent.putExtra("url", paramString);
    localIntent.putExtra("injectrecommend", false);
    if (paramMessageForArkApp != null)
    {
      paramString = paramMessageForArkApp.ark_app_message;
      localIntent.putExtra("forward_ark_app_direct", false);
      localIntent.putExtra("forward_ark_app_name", paramString.appName);
      localIntent.putExtra("forward_ark_app_view", paramString.appView);
      localIntent.putExtra("forward_ark_app_desc", paramString.appDesc);
      localIntent.putExtra("forward_ark_app_ver", paramString.appMinVersion);
      localIntent.putExtra("forward_ark_app_meta", paramString.metaList);
      localIntent.putExtra("forward_ark_app_prompt", paramString.promptText);
      localIntent.putExtra("forward_ark_app_config", paramString.config);
      localIntent.putExtra("forward_ark_from_h5", true);
      if (TextUtils.isEmpty(paramString.appId)) {
        break label333;
      }
      ArkAppDataReport.a(a(), paramString.appName, "AIOArkSdkCardClick", 1, 0, 0L, 0L, 0L, paramString.appView, "");
    }
    for (;;)
    {
      if (paramMessageForArkApp.istroop == 0) {
        localIntent.putExtra("friend_uin", paramMessageForArkApp.frienduin);
      }
      if (paramMessageForArkApp.istroop == 1) {
        localIntent.putExtra("groupUin", paramMessageForArkApp.frienduin);
      }
      if (paramMessageForArkApp.istroop == 3000) {
        localIntent.putExtra("dicussgroup_uin", paramMessageForArkApp.frienduin);
      }
      localIntent.putExtra("friendUin", paramMessageForArkApp.senderuin);
      localIntent.putExtra("uinType", paramMessageForArkApp.istroop);
      localIntent.putExtra("fromAio", true);
      localIntent.putExtra("appShareID", paramLong);
      localIntent.addFlags(603979776);
      localIntent.putExtra("forward_ark_app_direct", true);
      if (paramContext != null) {
        paramContext.startActivity(localIntent);
      }
      return localIntent;
      label333:
      if (paramString.from == 1) {
        ArkAppDataReport.a(a(), paramString.appName, "AIOArkMapCardClick ", 1, 0, 0L, 0L, 0L, paramString.appView, "");
      }
    }
  }
  
  public static QQAppInterface a()
  {
    return (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
  }
  
  public static void a(ark.ModuleRegister paramModuleRegister, String paramString)
  {
    Object localObject2 = null;
    long l;
    Object localObject3;
    Object localObject1;
    if ((paramString != null) && (paramString.indexOf("com.tencent.", 0) == -1))
    {
      l = 1L;
      localObject3 = a();
      localObject1 = localObject2;
      if (!TextUtils.isEmpty(paramString))
      {
        localObject1 = localObject2;
        if (localObject3 != null)
        {
          localObject3 = (ArkAppCenter)((QQAppInterface)localObject3).getManager(120);
          localObject1 = localObject2;
          if (localObject3 != null)
          {
            localObject1 = ((ArkAppCenter)localObject3).a();
            localObject2 = ((ArkAppCenter)localObject3).a().a(paramString, null);
            if (TextUtils.isEmpty((CharSequence)localObject2)) {
              break label465;
            }
            localObject2 = ArkAppCenter.e((String)localObject2);
            if (TextUtils.isEmpty((CharSequence)localObject2)) {
              break label465;
            }
          }
        }
      }
    }
    for (;;)
    {
      int i;
      try
      {
        localObject2 = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(((String)localObject2).getBytes()));
        if (localObject2 != null)
        {
          localObject2 = ((Document)localObject2).getElementsByTagName("Permissions");
          if ((localObject2 != null) && (((NodeList)localObject2).getLength() > 0))
          {
            localObject2 = ((NodeList)localObject2).item(0);
            if ((localObject2 != null) && (((Node)localObject2).getNodeType() == 1))
            {
              localObject2 = ((Element)localObject2).getElementsByTagName("Permission");
              if (localObject2 != null)
              {
                localObject3 = new HashSet();
                i = 0;
                if (i < ((NodeList)localObject2).getLength())
                {
                  Object localObject4 = ((NodeList)localObject2).item(i);
                  if ((localObject4 == null) || (((Node)localObject4).getNodeType() != 1)) {
                    break label474;
                  }
                  localObject4 = ((Element)localObject4).getAttribute("value");
                  if (TextUtils.isEmpty((CharSequence)localObject4)) {
                    break label474;
                  }
                  ((HashSet)localObject3).add(localObject4);
                  break label474;
                }
                a.put(paramString, localObject3);
              }
            }
          }
        }
        localObject2 = new ArrayList();
        ((List)localObject2).add(new ArkAppModuleReg.ModuleQQ());
        ((List)localObject2).add(new ArkAppDeviceModule());
        if (l == 0L) {
          ((List)localObject2).add(new ArkAppMusicModule());
        }
        localObject2 = ((List)localObject2).iterator();
        if (((Iterator)localObject2).hasNext())
        {
          localObject3 = (ArkAppModuleReg.ModuleBase)((Iterator)localObject2).next();
          ((ArkAppModuleReg.ModuleBase)localObject3).a(l);
          ((ArkAppModuleReg.ModuleBase)localObject3).a(paramString);
          if (localObject1 != null) {
            ((ArkAppModuleReg.ModuleBase)localObject3).a((List)ArkAiAppCenter.a.get(((ArkAppModuleReg.ModuleBase)localObject3).GetTypeName()));
          }
          paramModuleRegister.RegCallbackWrapper((ark.ModuleCallbackWrapper)localObject3);
          continue;
          continue;
        }
      }
      catch (Exception localException)
      {
        ArkAppCenter.b("ArkApp", String.format("RegisterModules, exception, msg=%s", new Object[] { localException.getMessage() }));
      }
      label465:
      return;
      l = 0L;
      break;
      label474:
      i += 1;
    }
  }
  
  public static boolean a(String paramString1, long paramLong, String paramString2)
  {
    boolean bool;
    if (paramLong == 0L) {
      bool = true;
    }
    for (;;)
    {
      if (!bool) {
        QLog.i("ArkApp", 2, String.format("ModuleCheckPermission.denied:Name:%s,Permission:%s.", new Object[] { paramString1, paramString2 }));
      }
      return bool;
      if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
      {
        HashSet localHashSet = (HashSet)a.get(paramString1);
        if (localHashSet == null) {
          bool = true;
        } else {
          bool = localHashSet.contains(paramString2);
        }
      }
      else
      {
        bool = false;
      }
    }
  }
  
  private static int b(ark.VariantWrapper[] paramArrayOfVariantWrapper, long paramLong)
  {
    int i = 2;
    int k = 0;
    if (paramLong >= 2L)
    {
      paramArrayOfVariantWrapper = paramArrayOfVariantWrapper[1];
      String[] arrayOfString;
      int j;
      if ((paramArrayOfVariantWrapper != null) && (paramArrayOfVariantWrapper.GetType() == 5) && (paramArrayOfVariantWrapper.GetString() != null))
      {
        paramArrayOfVariantWrapper = paramArrayOfVariantWrapper.GetString().toLowerCase();
        arrayOfString = new String[8];
        arrayOfString[0] = "d";
        arrayOfString[1] = "debug";
        arrayOfString[2] = "i";
        arrayOfString[3] = "info";
        arrayOfString[4] = "e";
        arrayOfString[5] = "error";
        arrayOfString[6] = "w";
        arrayOfString[7] = "warning";
        if (!arrayOfString[0].equals(paramArrayOfVariantWrapper))
        {
          j = i;
          if (!arrayOfString[1].equals(paramArrayOfVariantWrapper)) {}
        }
        else
        {
          if (!QLog.isColorLevel()) {
            break label212;
          }
          j = 0;
          k = 1;
        }
      }
      for (;;)
      {
        int m = i;
        if (k == 0)
        {
          m = i;
          if (j == 0) {
            m = 1;
          }
        }
        return m;
        do
        {
          j += 1;
          if (j >= arrayOfString.length) {
            break;
          }
        } while (!arrayOfString[j].equals(paramArrayOfVariantWrapper));
        j = 1;
        i = 1;
        continue;
        return 1;
        i = 4;
        j = 0;
        continue;
        label212:
        i = 4;
        j = 0;
        k = 1;
      }
    }
    return 4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppModuleReg
 * JD-Core Version:    0.7.0.1
 */