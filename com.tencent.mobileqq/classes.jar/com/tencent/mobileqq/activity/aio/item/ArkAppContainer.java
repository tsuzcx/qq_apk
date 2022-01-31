package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import com.tencent.ark.ArkDispatchTask;
import com.tencent.ark.ArkViewImplement;
import com.tencent.ark.ArkViewModel;
import com.tencent.ark.ArkViewModelBase.AppInfo;
import com.tencent.ark.ArkViewModelBase.ErrorInfo;
import com.tencent.ark.ArkViewModelBase.Size;
import com.tencent.ark.ark;
import com.tencent.ark.ark.ApplicationCallback;
import com.tencent.ark.ark.Container;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ark.ArkAiAppCenter;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.ark.ArkAppInfo.TimeRecord;
import com.tencent.mobileqq.ark.ArkLocalAppMgr;
import com.tencent.mobileqq.ark.ArkMediaPlayer;
import com.tencent.mobileqq.ark.ArkMsgJsonParseUtils;
import com.tencent.mobileqq.data.ArkAppMessage.Config;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import uuh;
import uui;
import uuj;

public class ArkAppContainer
  extends ArkViewModel
{
  public static int a;
  protected static final ark.ApplicationCallback a;
  public static String a;
  protected static ArrayList a;
  protected ArkViewModelBase.Size a;
  public ArkAppInfo.TimeRecord a;
  public ArkAppMessage.Config a;
  public int b;
  protected boolean b;
  protected WeakReference c;
  boolean c;
  protected WeakReference d = new WeakReference(null);
  public boolean d;
  
  static
  {
    jdField_a_of_type_Int = 1000;
    jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    jdField_a_of_type_ComTencentArkArk$ApplicationCallback = new uuh();
  }
  
  public ArkAppContainer()
  {
    super(jdField_a_of_type_ComTencentArkArk$ApplicationCallback);
    this.jdField_a_of_type_ComTencentMobileqqArkArkAppInfo$TimeRecord = new ArkAppInfo.TimeRecord(this.mTimeRecord);
    this.jdField_c_of_type_Boolean = false;
    this.jdField_b_of_type_Int = -1;
    this.jdField_b_of_type_Boolean = false;
    ArkAppCenter.a(true);
    this.jdField_c_of_type_JavaLangRefWeakReference = new WeakReference(this);
    jdField_a_of_type_JavaUtilArrayList.add(this.jdField_c_of_type_JavaLangRefWeakReference);
  }
  
  public static QQAppInterface a()
  {
    return (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
  }
  
  public static WeakReference a(ark.Container paramContainer)
  {
    int i = 0;
    while (i < jdField_a_of_type_JavaUtilArrayList.size())
    {
      WeakReference localWeakReference = (WeakReference)jdField_a_of_type_JavaUtilArrayList.get(i);
      ArkAppContainer localArkAppContainer = (ArkAppContainer)localWeakReference.get();
      if ((localArkAppContainer != null) && (localArkAppContainer.getContainer() == paramContainer)) {
        return localWeakReference;
      }
      i += 1;
    }
    return new WeakReference(null);
  }
  
  private static void a(String paramString)
  {
    paramString = new File(paramString);
    if (!paramString.exists()) {
      paramString.mkdirs();
    }
  }
  
  public ArkViewModelBase.Size a()
  {
    return this.jdField_a_of_type_ComTencentArkArkViewModelBase$Size;
  }
  
  public String a()
  {
    return "";
  }
  
  public String a(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentArkArkViewModelBase$Size = new ArkViewModelBase.Size(paramInt1, paramInt2);
  }
  
  public void a(ArkAppContainer.ArkAppModuleCallback paramArkAppModuleCallback)
  {
    this.d = new WeakReference(paramArkAppModuleCallback);
  }
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    boolean bool2 = true;
    boolean bool1;
    if (paramInt != 0)
    {
      bool1 = true;
      if (paramInt != -2) {
        break label58;
      }
    }
    for (;;)
    {
      String str1 = ArkAppCenter.c();
      String str2 = ArkAppCenter.b();
      a(str1);
      a(str2);
      doLoadArkApp(paramString1, str1, str2, bool1, bool2, paramInt, paramString2);
      return;
      bool1 = false;
      break;
      label58:
      bool2 = false;
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    ArkAppContainer.ArkAppModuleCallback localArkAppModuleCallback = (ArkAppContainer.ArkAppModuleCallback)this.d.get();
    if (localArkAppModuleCallback != null) {
      localArkAppModuleCallback.a(this, paramString1, paramString2);
    }
  }
  
  public boolean a(String paramString)
  {
    boolean bool2 = false;
    boolean bool1;
    if (((ArkAiAppCenter.a == null) || (ArkAiAppCenter.a.size() == 0)) && ((ArkAiAppCenter.b == null) || (ArkAiAppCenter.b.size() == 0)))
    {
      if (QLog.isColorLevel()) {
        Log.d("ArkApp.Cntnr.chkUrl", "checkMetaData configlist is null");
      }
      bool1 = this.jdField_c_of_type_Boolean;
    }
    do
    {
      return bool1;
      if (!TextUtils.isEmpty(paramString)) {
        break;
      }
      bool1 = bool2;
    } while (!QLog.isColorLevel());
    Log.d("ArkApp.Cntnr.chkUrl", "checkMetaUrl  is null");
    return false;
    if (ArkAiAppCenter.a != null) {}
    for (int i = ArkAiAppCenter.a.size();; i = 0)
    {
      if (ArkAiAppCenter.b != null) {}
      for (int j = ArkAiAppCenter.b.size();; j = 0)
      {
        if (i + j > jdField_a_of_type_Int)
        {
          if (QLog.isColorLevel()) {
            Log.d("ArkApp.Cntnr.chkUrl", "checkMetaData configlist is too large");
          }
          return this.jdField_c_of_type_Boolean;
        }
        if (this.jdField_b_of_type_Boolean)
        {
          if (QLog.isColorLevel()) {
            Log.d("ArkApp.Cntnr.chkUrl", "checkMetaData lastParseResult=" + this.jdField_c_of_type_Boolean);
          }
          return this.jdField_c_of_type_Boolean;
        }
        ArkMsgJsonParseUtils.a(paramString);
        paramString = ArkMsgJsonParseUtils.a();
        if (QLog.isColorLevel()) {
          Log.d("ArkApp.Cntnr.chkUrl", "checkMetaData mMetaUrlList=" + paramString);
        }
        if ((paramString == null) || (paramString.size() == 0))
        {
          if (QLog.isColorLevel()) {
            Log.d("ArkApp.Cntnr.chkUrl", "checkMetaUrl  medaData don't has urls");
          }
          this.jdField_b_of_type_Boolean = true;
          this.jdField_c_of_type_Boolean = false;
          return this.jdField_c_of_type_Boolean;
        }
        Iterator localIterator = paramString.iterator();
        String str;
        do
        {
          bool1 = bool2;
          if (!localIterator.hasNext()) {
            break;
          }
          List localList = ArkMsgJsonParseUtils.a((String)localIterator.next());
          paramString = "";
          str = "";
          if (localList.size() == 1) {
            paramString = (String)localList.get(0);
          }
          while (!b(paramString, str))
          {
            if (QLog.isColorLevel()) {
              Log.d("ArkApp.Cntnr.chkUrl", "checkMetaUrl url is not in white urlHost=" + paramString + "\n urlPath=" + str + "\n ArkAiAppCenter.sArkUrlWhiteList=" + ArkAiAppCenter.a);
            }
            this.jdField_b_of_type_Boolean = true;
            this.jdField_c_of_type_Boolean = true;
            return this.jdField_c_of_type_Boolean;
            if (localList.size() == 2)
            {
              paramString = (String)localList.get(0);
              str = (String)localList.get(1);
            }
          }
        } while (!a(paramString, str));
        if (QLog.isColorLevel()) {
          Log.d("ArkApp.Cntnr.chkUrl", "checkMetaUrl url is  in black urlHost=" + paramString + "urlPath=" + str + "sArkUrlBlackList" + ArkAiAppCenter.b);
        }
        this.jdField_b_of_type_Boolean = true;
        this.jdField_c_of_type_Boolean = true;
        return this.jdField_c_of_type_Boolean;
      }
    }
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    Iterator localIterator = ArkAiAppCenter.b.iterator();
    String str1;
    int j;
    int i;
    String str2;
    for (;;)
    {
      if (localIterator.hasNext())
      {
        str1 = (String)localIterator.next();
        if (!TextUtils.isEmpty(str1))
        {
          j = str1.indexOf("/");
          i = j;
          if (j == -1) {
            i = str1.indexOf("?");
          }
          if (i != -1)
          {
            str2 = str1.substring(0, i);
            str1 = str1.substring(i, str1.length());
            if (!str2.startsWith(".")) {
              break label287;
            }
            if (!paramString1.endsWith(str2)) {
              break label408;
            }
            if (!QLog.isColorLevel()) {
              break label413;
            }
            Log.d("ArkApp.Cntnr.chkUrl", "checkUrBlack sHost is  in black sHost=" + paramString1 + "\n sPath=" + paramString2 + "\n config_host_black=" + str2 + "\n config_path_black=" + str1);
            i = 1;
          }
        }
      }
    }
    for (;;)
    {
      label179:
      if (str1.endsWith("/"))
      {
        if (!paramString2.startsWith(str1)) {
          break label402;
        }
        if (!QLog.isColorLevel()) {
          break label394;
        }
        Log.d("ArkApp.Cntnr.chkUrl", "checkUrBlack sPath  is  in black sHost=" + paramString1 + "\n sPath=" + paramString2 + "\n config_host_black=" + str2 + "\n config_path_black=" + str1);
        j = 1;
      }
      for (;;)
      {
        if ((i == 0) || (j == 0)) {
          break label406;
        }
        return true;
        str2 = str1;
        str1 = "";
        break;
        label287:
        if ((!paramString1.equals(str2)) && (!str2.equals(""))) {
          break label408;
        }
        i = 1;
        break label179;
        if ((paramString2.equals(str1)) || (str1.equals("")))
        {
          if (QLog.isColorLevel()) {
            Log.d("ArkApp.Cntnr.chkUrl", "checkUrBlack sPath  is  in black sHost=" + paramString1 + "\n sPath=" + paramString2 + "\n config_host_black=" + str2 + "\n config_path_black=" + str1);
          }
          label394:
          j = 1;
          continue;
          return false;
        }
        else
        {
          label402:
          j = 0;
        }
      }
      label406:
      break;
      label408:
      i = 0;
      continue;
      label413:
      i = 1;
    }
  }
  
  public boolean a(String paramString1, String paramString2, String paramString3, String paramString4, float paramFloat, SessionInfo paramSessionInfo)
  {
    boolean bool2 = true;
    jdField_a_of_type_JavaLangString = null;
    if (paramSessionInfo.jdField_a_of_type_Int == 1) {
      jdField_a_of_type_JavaLangString = paramSessionInfo.jdField_a_of_type_JavaLangString;
    }
    this.jdField_b_of_type_Int = paramSessionInfo.jdField_a_of_type_Int;
    this.jdField_a_of_type_ComTencentMobileqqDataArkAppMessage$Config = new ArkAppMessage.Config();
    this.jdField_a_of_type_ComTencentMobileqqDataArkAppMessage$Config.fromString(a());
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_ComTencentMobileqqDataArkAppMessage$Config.round != null) {
      if (this.jdField_a_of_type_ComTencentMobileqqDataArkAppMessage$Config.round.intValue() == 0) {
        break label105;
      }
    }
    label105:
    for (bool1 = bool2;; bool1 = false)
    {
      this.mRoundCorner = bool1;
      return super.init(paramString1, paramString2, paramString3, paramString4, paramFloat);
    }
  }
  
  public boolean b(String paramString1, String paramString2)
  {
    Iterator localIterator = ArkAiAppCenter.a.iterator();
    String str1;
    int j;
    int i;
    String str2;
    for (;;)
    {
      if (localIterator.hasNext())
      {
        str1 = (String)localIterator.next();
        if (!TextUtils.isEmpty(str1))
        {
          j = str1.indexOf("/");
          i = j;
          if (j == -1) {
            i = str1.indexOf("?");
          }
          if (i != -1)
          {
            str2 = str1.substring(0, i);
            str1 = str1.substring(i, str1.length());
            label93:
            if (!str2.startsWith(".")) {
              break label268;
            }
            if (!paramString1.endsWith(str2)) {
              break label305;
            }
            i = 1;
          }
        }
      }
    }
    for (;;)
    {
      label115:
      if (str1.endsWith("/"))
      {
        if (!paramString2.startsWith(str1)) {
          break label299;
        }
        j = 1;
      }
      for (;;)
      {
        if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(str2)))
        {
          Log.d("ArkApp.Cntnr.chkUrl", "checkUrlWhite sHost or config white host is null?? sHost=" + paramString1 + " config_host_white=" + str2);
          i = 1;
        }
        if ((TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(str1)))
        {
          Log.d("ArkApp.Cntnr.chkUrl", "checkUrlWhite sPath or config white host is null?? sHost=" + paramString2 + " config_host_white=" + str1);
          j = 1;
        }
        if ((i == 0) || (j == 0)) {
          break;
        }
        return true;
        str2 = str1;
        str1 = "";
        break label93;
        label268:
        if (!paramString1.equals(str2)) {
          break label305;
        }
        i = 1;
        break label115;
        if (paramString2.equals(str1))
        {
          j = 1;
          continue;
          return false;
        }
        else
        {
          label299:
          j = 0;
        }
      }
      label305:
      i = 0;
    }
  }
  
  public void c()
  {
    ArkAppContainer.ArkAppModuleCallback localArkAppModuleCallback = (ArkAppContainer.ArkAppModuleCallback)this.d.get();
    if (localArkAppModuleCallback != null) {
      localArkAppModuleCallback.a(this);
    }
  }
  
  public void d()
  {
    if (this.mViewImpl != null)
    {
      this.mViewImpl.resetInputState();
      if (QLog.isColorLevel()) {
        QLog.d("ArkApp.ArkAppContainer", 2, String.format("resetInputState done.in.wrapper: %h", new Object[] { this }));
      }
    }
  }
  
  protected void destroy()
  {
    jdField_a_of_type_JavaUtilArrayList.remove(this.jdField_c_of_type_JavaLangRefWeakReference);
    super.destroy();
  }
  
  public ark.Container getContainer()
  {
    return this.mContainer;
  }
  
  protected void initLibrary()
  {
    ark.MediaSetStub(ArkMediaPlayer.a);
  }
  
  protected void onFirstDrawEnd()
  {
    super.onFirstDrawEnd();
    ThreadManager.executeOnSubThread(new uuj(this));
  }
  
  public boolean onLoadApp(ArkViewModelBase.AppInfo paramAppInfo)
  {
    Object localObject2 = a();
    if (localObject2 == null)
    {
      this.mInit = false;
      this.mLoadFailed = true;
      paramAppInfo = this.mViewImpl;
      if (paramAppInfo != null) {
        paramAppInfo.onLoadFailed(null, this.mErrorInfo.retCode, true);
      }
      return true;
    }
    Object localObject1 = paramAppInfo.meta;
    this.jdField_a_of_type_ComTencentMobileqqArkArkAppInfo$TimeRecord.a = System.currentTimeMillis();
    localObject2 = ((ArkAppCenter)((QQAppInterface)localObject2).getManager(120)).a();
    String str = ((ArkLocalAppMgr)localObject2).a(this.mAppInfo.name, this.mAppInfo.appMinVersion);
    if (!TextUtils.isEmpty(str))
    {
      ArkDispatchTask.getInstance().post(new uui(this, str, (String)localObject1));
      return true;
    }
    localObject1 = this.mViewImpl;
    if (localObject1 != null) {
      ((ArkViewImplement)localObject1).onLoading();
    }
    ((ArkLocalAppMgr)localObject2).a(paramAppInfo.name, paramAppInfo.appMinVersion, null, new ArkAppContainer.AppPathCallback(this.jdField_c_of_type_JavaLangRefWeakReference));
    return false;
  }
  
  protected void onRunAppFailed()
  {
    Object localObject = this.mViewImpl;
    if (localObject != null)
    {
      localObject = ((ArkViewImplement)localObject).getView().getContext().getString(2131436176);
      this.mErrorInfo.msg = a((String)localObject);
      this.mErrorInfo.canRetry = false;
    }
    super.onRunAppFailed();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ArkAppContainer
 * JD-Core Version:    0.7.0.1
 */