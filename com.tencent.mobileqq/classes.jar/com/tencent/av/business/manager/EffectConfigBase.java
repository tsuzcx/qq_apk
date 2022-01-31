package com.tencent.av.business.manager;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Message;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.av.AVLog;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.utils.UITools;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.util.JSONUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.SecUtil;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import jhf;
import jhg;
import jhh;
import jhi;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONObject;

public abstract class EffectConfigBase
  extends BusinessManager
{
  public static final String a;
  protected static final String b;
  public Handler a;
  public EffectConfigBase.ItemBase a;
  public List a;
  protected List b;
  
  static
  {
    jdField_a_of_type_JavaLangString = AppConstants.aK + "qav" + File.separator;
    jdField_b_of_type_JavaLangString = jdField_a_of_type_JavaLangString + "effect" + File.separator;
  }
  
  public EffectConfigBase(VideoAppInterface paramVideoAppInterface)
  {
    super(paramVideoAppInterface);
    this.jdField_a_of_type_AndroidOsHandler = new jhh(this);
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
  }
  
  private static int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return -1;
    case 216: 
      return 0;
    }
    return 1;
  }
  
  public static int a(Context paramContext, int paramInt)
  {
    long l1 = System.currentTimeMillis();
    if (!a(paramInt)) {
      return 0;
    }
    int i = PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("qav_effect_config_version" + String.valueOf(paramInt), 0);
    long l2 = System.currentTimeMillis();
    AVLog.c("EffectConfigBase", "getVideoConfigVersion:" + paramInt + "|" + i + "|" + (l2 - l1));
    return i;
  }
  
  public static String a(int paramInt)
  {
    return jdField_a_of_type_JavaLangString + String.valueOf(paramInt) + File.separator;
  }
  
  public static String a(Context paramContext, int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    try
    {
      File localFile = new File(a(paramInt) + "config.xml");
      localObject1 = localObject2;
      AVLog.c("EffectConfigBase", "getVideoConfig:" + localFile.getPath() + "|" + localFile.exists());
      localObject1 = localObject2;
      if (localFile.exists())
      {
        localObject1 = localObject2;
        paramContext = FileUtils.b(localFile);
        localObject1 = paramContext;
        AVLog.c("EffectConfigBase", "getVideoConfig:" + paramContext);
        return paramContext;
      }
      localObject1 = localObject2;
      a(paramContext, 0, paramInt);
      return null;
    }
    catch (IOException paramContext)
    {
      paramContext.printStackTrace();
      AVLog.c("EffectConfigBase", "getVideoConfig exception:" + paramContext.toString());
    }
    return localObject1;
  }
  
  private WeakReference a(EffectConfigBase.IEffectConfigCallback paramIEffectConfigCallback)
  {
    int j = this.jdField_b_of_type_JavaUtilList.size();
    int i = 0;
    while (i < j)
    {
      WeakReference localWeakReference = (WeakReference)this.jdField_b_of_type_JavaUtilList.get(i);
      if ((localWeakReference != null) && (localWeakReference.get() != null) && (((EffectConfigBase.IEffectConfigCallback)localWeakReference.get()).equals(paramIEffectConfigCallback))) {
        return localWeakReference;
      }
      i += 1;
    }
    return null;
  }
  
  public static void a(Context paramContext, int paramInt1, int paramInt2)
  {
    AVLog.c("EffectConfigBase", "setVideoConfigVersion:" + paramInt2 + "|" + paramInt1);
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("qav_effect_config_version" + String.valueOf(paramInt2), paramInt1);
    paramContext.commit();
  }
  
  public static void a(Context paramContext, String paramString, int paramInt1, int paramInt2)
  {
    if (paramString == null)
    {
      AVLog.c("EffectConfigBase", "updateVideoConfig error ");
      return;
    }
    String str = a(paramInt2);
    File localFile = new File(str);
    if ((localFile.exists()) && (localFile.isFile())) {
      FileUtils.d(str);
    }
    a(paramString, str, "config.xml");
    a(paramContext, paramInt1, paramInt2);
    BusinessManager.a(paramContext, a(paramInt2), false);
  }
  
  private void a(EffectConfigBase.ItemBase paramItemBase, int paramInt)
  {
    int j = this.jdField_b_of_type_JavaUtilList.size();
    int i = 0;
    while (i < j)
    {
      WeakReference localWeakReference = (WeakReference)this.jdField_b_of_type_JavaUtilList.get(i);
      if ((localWeakReference != null) && (localWeakReference.get() != null)) {
        ((EffectConfigBase.IEffectConfigCallback)localWeakReference.get()).onProgressUpdate(paramItemBase, paramInt);
      }
      i += 1;
    }
  }
  
  private void a(EffectConfigBase.ItemBase paramItemBase, boolean paramBoolean)
  {
    AVLog.c("EffectConfigBase", "triggleonResourceDownloadFinished zzzzz: " + paramItemBase.getId() + "|" + paramBoolean);
    Object localObject;
    if (paramBoolean)
    {
      localObject = a(paramItemBase.getId());
      if (localObject != null) {
        ((EffectConfigBase.ItemBase)localObject).setUsable(true);
      }
    }
    int j = this.jdField_b_of_type_JavaUtilList.size();
    int i = 0;
    while (i < j)
    {
      localObject = (WeakReference)this.jdField_b_of_type_JavaUtilList.get(i);
      if ((localObject != null) && (((WeakReference)localObject).get() != null)) {
        ((EffectConfigBase.IEffectConfigCallback)((WeakReference)localObject).get()).onDownloadFinish(paramItemBase, paramBoolean);
      }
      i += 1;
    }
  }
  
  static void a(String paramString1, String paramString2, String paramString3)
  {
    ThreadManager.getFileThreadHandler().post(new jhg(paramString2, paramString3, paramString1));
  }
  
  static boolean a(int paramInt)
  {
    return new File(a(paramInt) + "config.xml").exists();
  }
  
  private boolean a(EffectConfigBase.ItemBase paramItemBase1, EffectConfigBase.ItemBase paramItemBase2)
  {
    boolean bool = false;
    if (paramItemBase1 == null) {
      if (paramItemBase2 == null) {
        bool = true;
      }
    }
    while (paramItemBase2 == null) {
      return bool;
    }
    return paramItemBase1.getId().equals(paramItemBase2.getId());
  }
  
  private void c(EffectConfigBase.ItemBase paramItemBase)
  {
    int j = this.jdField_b_of_type_JavaUtilList.size();
    int i = 0;
    while (i < j)
    {
      WeakReference localWeakReference = (WeakReference)this.jdField_b_of_type_JavaUtilList.get(i);
      if ((localWeakReference != null) && (localWeakReference.get() != null)) {
        ((EffectConfigBase.IEffectConfigCallback)localWeakReference.get()).onItemSelectedChanged(paramItemBase);
      }
      i += 1;
    }
  }
  
  public abstract int a();
  
  public int a(int paramInt, String paramString)
  {
    return 0;
  }
  
  public EffectConfigBase.ItemBase a()
  {
    return this.jdField_a_of_type_ComTencentAvBusinessManagerEffectConfigBase$ItemBase;
  }
  
  public EffectConfigBase.ItemBase a(String paramString)
  {
    b();
    if ((this.jdField_a_of_type_JavaUtilList != null) && (!TextUtils.isEmpty(paramString)))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        EffectConfigBase.ItemBase localItemBase = (EffectConfigBase.ItemBase)localIterator.next();
        if (paramString.equals(localItemBase.getId())) {
          return localItemBase;
        }
      }
    }
    return null;
  }
  
  public abstract Class a();
  
  public String a()
  {
    int i = a();
    return a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp(), i);
  }
  
  public String a(EffectConfigBase.ItemBase paramItemBase)
  {
    return jdField_a_of_type_JavaLangString + a() + File.separator + "temp" + File.separator + paramItemBase.getId() + ".zip";
  }
  
  public String a(String paramString)
  {
    return jdField_a_of_type_JavaLangString + a() + File.separator + paramString + File.separator;
  }
  
  public List a(String paramString)
  {
    b();
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  protected void a() {}
  
  public void a(Message paramMessage) {}
  
  public void a(EffectConfigBase.IEffectConfigCallback paramIEffectConfigCallback)
  {
    if ((paramIEffectConfigCallback != null) && (a(paramIEffectConfigCallback) == null))
    {
      paramIEffectConfigCallback = new WeakReference(paramIEffectConfigCallback);
      this.jdField_b_of_type_JavaUtilList.add(paramIEffectConfigCallback);
    }
  }
  
  public void a(EffectConfigBase.ItemBase paramItemBase)
  {
    if ((paramItemBase.isUsable()) || (TextUtils.isEmpty(paramItemBase.getResurl())))
    {
      this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1, 1, 0, paramItemBase).sendToTarget();
      return;
    }
    HttpNetReq localHttpNetReq = new HttpNetReq();
    localHttpNetReq.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$INetEngineListener = new jhf(this, paramItemBase);
    localHttpNetReq.jdField_a_of_type_JavaLangString = paramItemBase.getResurl();
    localHttpNetReq.jdField_a_of_type_Int = 0;
    localHttpNetReq.jdField_c_of_type_JavaLangString = a(paramItemBase);
    localHttpNetReq.jdField_c_of_type_Int = NetworkUtil.a(NetworkCenter.a().a());
    localHttpNetReq.a(paramItemBase);
    ThreadManager.post(new jhi(this, localHttpNetReq), 5, null, true);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if ((paramBoolean) && ((paramString.equals(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a().jdField_c_of_type_JavaLangString)) || (paramString.equals(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a().q)))) {
      a(null);
    }
  }
  
  public boolean a(EffectConfigBase.ItemBase paramItemBase)
  {
    boolean bool = false;
    if (!a(this.jdField_a_of_type_ComTencentAvBusinessManagerEffectConfigBase$ItemBase, paramItemBase))
    {
      this.jdField_a_of_type_ComTencentAvBusinessManagerEffectConfigBase$ItemBase = paramItemBase;
      paramItemBase = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(0, paramItemBase);
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramItemBase);
      bool = true;
    }
    return bool;
  }
  
  public int b(int paramInt, String paramString)
  {
    AVLog.c("EffectConfigBase", "onSendMessageToPeer :" + paramInt + "|" + paramString);
    return this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a(paramInt, paramString);
  }
  
  public String b()
  {
    return "content";
  }
  
  public String b(EffectConfigBase.ItemBase paramItemBase)
  {
    return a(paramItemBase.getId());
  }
  
  public List b(String paramString)
  {
    localArrayList = new ArrayList();
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        paramString = new JSONObject(paramString);
        int j = UITools.a();
        Object localObject = b();
        if (paramString.has((String)localObject))
        {
          paramString = paramString.getJSONArray((String)localObject);
          localObject = a();
          int i = 0;
          while (i < paramString.length())
          {
            EffectConfigBase.ItemBase localItemBase = (EffectConfigBase.ItemBase)JSONUtils.a((JSONObject)paramString.get(i), (Class)localObject);
            if ((localItemBase != null) && (!TextUtils.isEmpty(localItemBase.getId())))
            {
              int k = localItemBase.getPlatform();
              AVLog.c("EffectConfigBase", "item: " + localItemBase.toString() + "|" + j + "|" + k);
              if ((k == 0) || (j >= k))
              {
                localItemBase.setUsable(b(localItemBase));
                localArrayList.add(localItemBase);
              }
            }
            i += 1;
          }
        }
        return localArrayList;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0)) {
      this.jdField_a_of_type_JavaUtilList = b(a());
    }
  }
  
  public void b(EffectConfigBase.IEffectConfigCallback paramIEffectConfigCallback)
  {
    if ((paramIEffectConfigCallback != null) && (a(paramIEffectConfigCallback) != null)) {
      this.jdField_b_of_type_JavaUtilList.remove(paramIEffectConfigCallback);
    }
  }
  
  public void b(EffectConfigBase.ItemBase paramItemBase) {}
  
  public boolean b(EffectConfigBase.ItemBase paramItemBase)
  {
    if ((a() <= 0) || (paramItemBase == null) || (TextUtils.isEmpty(paramItemBase.getId()))) {
      AVLog.e("EffectConfigBase", "isTemplateUsable:" + a() + "|");
    }
    do
    {
      return false;
      if (TextUtils.isEmpty(paramItemBase.getResurl())) {
        return true;
      }
    } while (!new File(a(paramItemBase)).exists());
    long l1 = System.currentTimeMillis();
    String str = SecUtil.getFileMd5(a(paramItemBase));
    long l2 = System.currentTimeMillis();
    paramItemBase = paramItemBase.getMd5();
    AVLog.c("EffectConfigBase", "isTemplateUsable :" + str + "|" + paramItemBase + "|" + (l2 - l1));
    return paramItemBase.equalsIgnoreCase(str);
  }
  
  public boolean b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      a(null);
    }
    for (;;)
    {
      return true;
      a(a(paramString));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.av.business.manager.EffectConfigBase
 * JD-Core Version:    0.7.0.1
 */