package com.tencent.biz.pubaccount.readinjoy.ugc;

import android.app.Service;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import bbmy;
import beez;
import bgmq;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import mqq.os.MqqHandler;
import obz;
import psj;
import psk;
import psm;
import psn;
import pwl;
import pws;
import pwu;

public class KandianVideoUploadService
  extends Service
  implements Handler.Callback, psm
{
  private static Map<String, WeakReference<psk>> jdField_a_of_type_JavaUtilMap = new HashMap();
  private static psn jdField_a_of_type_Psn;
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "com.tencent.biz.pubaccount.readinjoy" };
  private static final String[] b = { "kandian", "readinjoy", "post.mp.qq.com " };
  private final MqqHandler jdField_a_of_type_MqqOsMqqHandler = new beez(Looper.getMainLooper(), this, true);
  private boolean jdField_a_of_type_Boolean;
  
  public static int a()
  {
    return psj.a().size();
  }
  
  private String a()
  {
    return bgmq.a(obz.a(), false, true).getString("mLoadingUrl", "");
  }
  
  public static void a(Bundle paramBundle, psn parampsn)
  {
    Object localObject = paramBundle.getString("mTaskID");
    localObject = (WeakReference)jdField_a_of_type_JavaUtilMap.get(localObject);
    if (localObject != null) {}
    for (localObject = (psk)((WeakReference)localObject).get();; localObject = null)
    {
      if (localObject != null)
      {
        parampsn.a(paramBundle, 200, ((psk)localObject).a);
        return;
      }
      if (jdField_a_of_type_JavaUtilMap.size() < 2)
      {
        parampsn.a(paramBundle, 202, 0.0F);
        return;
      }
      parampsn.a(paramBundle, 201, 0.0F);
      return;
    }
  }
  
  private void a(String paramString)
  {
    QLog.d("KandianVideoUploadService", 1, "removeTask!");
    psk localpsk = (psk)((WeakReference)jdField_a_of_type_JavaUtilMap.get(paramString)).get();
    if (localpsk != null) {
      localpsk.b();
    }
    jdField_a_of_type_JavaUtilMap.remove(paramString);
    if (jdField_a_of_type_JavaUtilMap.size() == 0) {
      stopSelf();
    }
  }
  
  private void a(String paramString, int paramInt)
  {
    a(paramString, paramInt, 0.0F);
  }
  
  private void a(String paramString, int paramInt, float paramFloat)
  {
    Message localMessage = Message.obtain();
    Bundle localBundle = new Bundle();
    localBundle.putString("mTaskID", paramString);
    localMessage.what = paramInt;
    localMessage.obj = Float.valueOf(paramFloat);
    localMessage.setData(localBundle);
    this.jdField_a_of_type_MqqOsMqqHandler.sendMessage(localMessage);
  }
  
  public static void a(psn parampsn)
  {
    jdField_a_of_type_Psn = parampsn;
  }
  
  private boolean a()
  {
    Object localObject = BaseActivity.sTopActivity;
    boolean bool;
    if (ReadinjoyTabFrame.jdField_a_of_type_Boolean) {
      bool = true;
    }
    for (;;)
    {
      QLog.d("KandianVideoUploadService", 1, "isInkandian:" + bool);
      return bool;
      if (localObject == null)
      {
        bool = a(b, a());
      }
      else
      {
        localObject = localObject.toString();
        bool = a(jdField_a_of_type_ArrayOfJavaLangString, (String)localObject);
      }
    }
  }
  
  private boolean a(String[] paramArrayOfString, String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    int i;
    if (!TextUtils.isEmpty(paramString)) {
      i = 0;
    }
    for (;;)
    {
      bool1 = bool2;
      if (i < paramArrayOfString.length)
      {
        if (paramString.contains(paramArrayOfString[i])) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  protected void a(int paramInt, CharSequence paramCharSequence)
  {
    if (a()) {
      bbmy.a(getBaseContext(), paramInt, paramCharSequence, 0).b(getResources().getDimensionPixelSize(2131167766));
    }
  }
  
  protected void a(Intent paramIntent, String paramString)
  {
    boolean bool1 = false;
    if (jdField_a_of_type_JavaUtilMap.size() >= 2)
    {
      paramIntent = jdField_a_of_type_JavaUtilMap.values().iterator();
      while (paramIntent.hasNext())
      {
        paramString = (psk)((WeakReference)paramIntent.next()).get();
        QLog.d("KandianVideoUploadService", 1, "startTask");
      }
    }
    String str1 = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str1 = String.valueOf(System.currentTimeMillis() + (Math.random() * 10000.0D));
    }
    paramString = paramIntent.getStringExtra("arg_video_path");
    boolean bool2 = paramIntent.getBooleanExtra("arg_is_from_wang_zhe", false);
    String str2 = paramIntent.getStringExtra("arg_video_cover");
    if ((TextUtils.isEmpty(str2)) || (!new File(str2).exists())) {
      QLog.d("KandianVideoUploadService", 1, "coverParh not exist!");
    }
    do
    {
      do
      {
        return;
        if ((bool2) || ((!TextUtils.isEmpty(paramString)) && (new File(paramString).exists()))) {
          break;
        }
        QLog.d("KandianVideoUploadService", 1, "onDeliver video not exist!");
      } while (jdField_a_of_type_Psn == null);
      paramIntent = paramIntent.getExtras();
    } while (paramIntent == null);
    jdField_a_of_type_Psn.a(paramIntent, getString(2131653686));
    return;
    paramIntent.putExtra("mTaskID", str1);
    paramString = jdField_a_of_type_JavaUtilMap.keySet().iterator();
    while (paramString.hasNext()) {
      bool1 = ((String)paramString.next()).equalsIgnoreCase(str1);
    }
    if (bool1)
    {
      QLog.d("KandianVideoUploadService", 1, "has same task!");
      return;
    }
    if (bool2) {}
    for (paramIntent = new pws(this, this, paramIntent);; paramIntent = new pwu(this, this, paramIntent))
    {
      paramString = new WeakReference(paramIntent);
      jdField_a_of_type_JavaUtilMap.put(str1, paramString);
      paramIntent.a();
      return;
    }
  }
  
  public void a(String paramString, float paramFloat)
  {
    a(paramString, 108, paramFloat);
  }
  
  public void a(String paramString1, int paramInt1, long paramLong, String paramString2, int paramInt2, String paramString3, String paramString4)
  {
    paramString2 = (psk)((WeakReference)jdField_a_of_type_JavaUtilMap.get(paramString1)).get();
    if ((paramString2 instanceof pwu)) {}
    for (paramString2 = ((pwu)paramString2).a;; paramString2 = null)
    {
      switch (paramInt1)
      {
      default: 
        if ((jdField_a_of_type_Psn != null) && (paramString2 != null)) {
          jdField_a_of_type_Psn.a(paramString2, paramString4);
        }
        a(1, paramString4);
      }
      for (;;)
      {
        a(paramString1);
        return;
        if (jdField_a_of_type_Psn != null) {
          jdField_a_of_type_Psn.a(paramString1);
        }
        a(2, getString(2131652776));
      }
    }
  }
  
  public void a(String paramString, int paramInt, pwl parampwl)
  {
    int i = 1004;
    switch (paramInt)
    {
    default: 
      i = 0;
    }
    for (;;)
    {
      QLog.d("KandianVideoUploadService", 1, "deliver over!" + paramInt);
      if (paramInt != 0)
      {
        paramString = (psk)((WeakReference)jdField_a_of_type_JavaUtilMap.get(paramString)).get();
        if (paramString != null) {
          paramString.a(i);
        }
      }
      return;
      a(paramString, 106);
      i = 1001;
      continue;
      a(paramString, 107);
      i = 1001;
      continue;
      a(paramString, 100);
      i = 1001;
      continue;
      a(paramString, 102);
      i = 1001;
      continue;
      a(paramString, 105);
      continue;
      a(paramString, 105);
      continue;
      a(paramString, 104);
      continue;
      a(paramString, 100);
      i = 1002;
      continue;
      a(paramString, 105);
      i = 1003;
      continue;
      a(paramString, 105);
      i = 1003;
      continue;
      a(paramString, 104);
      i = 1003;
      continue;
      a(paramString, 105);
      i = 0;
      continue;
      i = 0;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = 100;
    String str = String.valueOf(paramMessage.getData().get("mTaskID"));
    float f = 0.0F;
    Object localObject = "";
    int j;
    if (paramMessage.what == 100)
    {
      paramMessage = getString(2131652762);
      j = 0;
    }
    for (;;)
    {
      localObject = (psk)((WeakReference)jdField_a_of_type_JavaUtilMap.get(str)).get();
      if (localObject != null)
      {
        if (!(localObject instanceof pwu)) {
          break label358;
        }
        localObject = ((pwu)localObject).a;
      }
      for (;;)
      {
        label87:
        if (j == 0) {
          a(str);
        }
        switch (j)
        {
        }
        label358:
        do
        {
          return true;
          if (paramMessage.what == 101)
          {
            paramMessage = getString(2131653686);
            i = 101;
            j = 0;
            break;
          }
          if (paramMessage.what == 102)
          {
            paramMessage = getString(2131652764);
            i = 102;
            j = 0;
            break;
          }
          if (paramMessage.what == 103)
          {
            i = 103;
            j = 0;
            paramMessage = (Message)localObject;
            break;
          }
          if (paramMessage.what == 104)
          {
            paramMessage = getString(2131652769);
            i = 104;
            j = 0;
            break;
          }
          if (paramMessage.what == 105)
          {
            paramMessage = getString(2131652763);
            i = 105;
            j = 0;
            break;
          }
          if (paramMessage.what == 106)
          {
            paramMessage = getString(2131652770);
            i = 106;
            j = 0;
            break;
          }
          if (paramMessage.what == 107)
          {
            if (this.jdField_a_of_type_Boolean)
            {
              paramMessage = getString(2131652775);
              i = 107;
              j = 0;
              break;
            }
            paramMessage = getString(2131652774);
            i = 107;
            j = 0;
            break;
          }
          if (paramMessage.what != 108) {
            break label447;
          }
          f = ((Float)paramMessage.obj).floatValue();
          i = -1;
          j = 1;
          paramMessage = (Message)localObject;
          break;
          if (!(localObject instanceof pws)) {
            break label441;
          }
          localObject = ((pws)localObject).a;
          break label87;
          a(1, paramMessage);
          if ((jdField_a_of_type_Psn != null) && (localObject != null)) {
            jdField_a_of_type_Psn.a((Bundle)localObject, paramMessage);
          }
          this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(i);
          return true;
        } while ((jdField_a_of_type_Psn == null) || (localObject == null));
        jdField_a_of_type_Psn.a((Bundle)localObject, f);
        return true;
        label441:
        localObject = null;
      }
      label447:
      i = -1;
      j = 0;
      paramMessage = (Message)localObject;
    }
  }
  
  @Nullable
  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }
  
  public void onCreate()
  {
    super.onCreate();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    Object localObject2;
    if (paramIntent != null)
    {
      localObject2 = paramIntent.getStringExtra("mTaskID");
      QLog.d("KandianVideoUploadService", 1, "receive task  taskID :" + (String)localObject2 + " now taskMap:" + jdField_a_of_type_JavaUtilMap.size());
      localObject1 = (WeakReference)jdField_a_of_type_JavaUtilMap.get(localObject2);
      if (localObject1 == null) {
        break label141;
      }
    }
    label141:
    for (Object localObject1 = (psk)((WeakReference)localObject1).get();; localObject1 = null)
    {
      if (localObject1 != null) {
        if (jdField_a_of_type_Psn != null)
        {
          localObject2 = paramIntent.getExtras();
          if (localObject2 != null) {
            jdField_a_of_type_Psn.a((Bundle)localObject2, ((psk)localObject1).a);
          }
        }
      }
      for (;;)
      {
        return super.onStartCommand(paramIntent, paramInt1, paramInt2);
        a(paramIntent, (String)localObject2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.KandianVideoUploadService
 * JD-Core Version:    0.7.0.1
 */