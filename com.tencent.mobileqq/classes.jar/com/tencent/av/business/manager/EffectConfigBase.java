package com.tencent.av.business.manager;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.av.AVLog;
import com.tencent.av.AVPathUtil;
import com.tencent.av.ManageConfig.QAVConfItem;
import com.tencent.av.ManageConfig.QAVConfig;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.utils.UITools;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.util.JSONUtils;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.SecUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public abstract class EffectConfigBase<T extends EffectConfigBase.ItemBase>
  extends BusinessManager
{
  public static String b;
  public static String c;
  private static String d;
  private static String e;
  int a;
  protected Handler a;
  protected final Checker a;
  protected T a;
  protected List<T> a;
  protected List<T> b;
  protected List<T> c;
  protected List<WeakReference<EffectConfigBase.IEffectConfigCallback<T>>> d;
  
  static
  {
    jdField_d_of_type_JavaLangString = "qav_config_";
    e = "text";
    jdField_b_of_type_JavaLangString = "ver";
    jdField_c_of_type_JavaLangString = "0";
  }
  
  public EffectConfigBase(VideoAppInterface paramVideoAppInterface)
  {
    super(paramVideoAppInterface);
    this.jdField_a_of_type_ComTencentAvBusinessManagerChecker = new Checker();
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_AndroidOsHandler = new EffectConfigBase.MyHander(this.jdField_a_of_type_JavaLangString, this);
    this.jdField_d_of_type_JavaUtilList = new ArrayList();
  }
  
  public static SharedPreferences a(int paramInt, String paramString)
  {
    paramString = a(paramInt, paramString);
    return BaseApplicationImpl.getContext().getSharedPreferences(paramString, 4);
  }
  
  public static String a(int paramInt, String paramString)
  {
    if ((AudioHelper.d()) && (TextUtils.isEmpty(paramString))) {
      throw new IllegalArgumentException("getConfigSPName uin不能为空, configId:" + paramInt);
    }
    return jdField_d_of_type_JavaLangString + paramInt + "_" + paramString;
  }
  
  private WeakReference<EffectConfigBase.IEffectConfigCallback<T>> a(EffectConfigBase.IEffectConfigCallback<T> paramIEffectConfigCallback)
  {
    int j = this.jdField_d_of_type_JavaUtilList.size();
    int i = 0;
    while (i < j)
    {
      WeakReference localWeakReference = (WeakReference)this.jdField_d_of_type_JavaUtilList.get(i);
      if ((localWeakReference != null) && (localWeakReference.get() != null) && (((EffectConfigBase.IEffectConfigCallback)localWeakReference.get()).equals(paramIEffectConfigCallback))) {
        return localWeakReference;
      }
      i += 1;
    }
    return null;
  }
  
  public static void a(int paramInt1, String paramString1, int paramInt2, String paramString2)
  {
    SharedPreferences.Editor localEditor = a(paramInt1, paramString1).edit();
    if (paramString2 == null)
    {
      localEditor.remove(e);
      localEditor.putInt(jdField_b_of_type_JavaLangString, paramInt2);
      localEditor.commit();
      if (!QLog.isDevelopLevel()) {
        break label143;
      }
    }
    for (;;)
    {
      QLog.w("EffectConfigBase_" + paramInt1, 1, "saveConfig, configId[" + paramInt1 + "], uin[" + paramString1 + "], version[" + paramInt2 + "],\n" + paramString2 + "");
      return;
      localEditor.putString(e, paramString2);
      break;
      label143:
      if (paramString2 == null) {
        paramString2 = "null";
      } else {
        paramString2 = paramString2.length() + "";
      }
    }
  }
  
  private void a(long paramLong, T paramT, boolean paramBoolean)
  {
    if (AudioHelper.e()) {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "triggleonResourceDownloadFinished, id[" + paramT.getId() + "], isSuccess[" + paramBoolean + "], seq[" + paramLong + "]");
    }
    Object localObject;
    if (paramBoolean)
    {
      localObject = a(paramT.getId());
      if (localObject != null) {
        ((EffectConfigBase.ItemBase)localObject).setUsable(true);
      }
    }
    int j = this.jdField_d_of_type_JavaUtilList.size();
    int i = 0;
    while (i < j)
    {
      localObject = (WeakReference)this.jdField_d_of_type_JavaUtilList.get(i);
      if ((localObject != null) && (((WeakReference)localObject).get() != null)) {
        ((EffectConfigBase.IEffectConfigCallback)((WeakReference)localObject).get()).onDownloadFinish(paramLong, paramT, paramBoolean);
      }
      i += 1;
    }
  }
  
  private void a(T paramT, int paramInt)
  {
    int j = this.jdField_d_of_type_JavaUtilList.size();
    int i = 0;
    while (i < j)
    {
      WeakReference localWeakReference = (WeakReference)this.jdField_d_of_type_JavaUtilList.get(i);
      if ((localWeakReference != null) && (localWeakReference.get() != null)) {
        ((EffectConfigBase.IEffectConfigCallback)localWeakReference.get()).onProgressUpdate(paramT, paramInt);
      }
      i += 1;
    }
  }
  
  private boolean a(T paramT1, T paramT2)
  {
    if (paramT1 == null) {
      if (paramT2 != null) {}
    }
    while ((paramT2 != null) && (paramT1.getId().equals(paramT2.getId())))
    {
      return true;
      return false;
    }
    return false;
  }
  
  public static String b(int paramInt, String paramString)
  {
    return a(paramInt, paramString).getString(e, null);
  }
  
  private void b(long paramLong, T paramT)
  {
    int j = this.jdField_d_of_type_JavaUtilList.size();
    if (QLog.isDevelopLevel()) {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "triggleonItemSelectedChanged, size[" + j + "], seq[" + paramLong + "]");
    }
    int i = 0;
    while (i < j)
    {
      WeakReference localWeakReference = (WeakReference)this.jdField_d_of_type_JavaUtilList.get(i);
      if ((localWeakReference != null) && (localWeakReference.get() != null)) {
        ((EffectConfigBase.IEffectConfigCallback)localWeakReference.get()).onItemSelectedChanged(paramLong, paramT);
      }
      i += 1;
    }
  }
  
  public static int c(int paramInt, String paramString)
  {
    return a(paramInt, paramString).getInt(jdField_b_of_type_JavaLangString, 0);
  }
  
  public abstract int a();
  
  public int a(int paramInt, String paramString)
  {
    return 0;
  }
  
  public T a()
  {
    return this.jdField_a_of_type_ComTencentAvBusinessManagerEffectConfigBase$ItemBase;
  }
  
  public T a(String paramString)
  {
    b();
    Iterator localIterator;
    EffectConfigBase.ItemBase localItemBase;
    if ((this.jdField_a_of_type_JavaUtilList != null) && (!TextUtils.isEmpty(paramString)))
    {
      localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        localItemBase = (EffectConfigBase.ItemBase)localIterator.next();
        if (paramString.equals(localItemBase.getId())) {
          return localItemBase;
        }
      }
    }
    if ((this.jdField_b_of_type_JavaUtilList != null) && (!TextUtils.isEmpty(paramString)))
    {
      localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        localItemBase = (EffectConfigBase.ItemBase)localIterator.next();
        if (paramString.equals(localItemBase.getId())) {
          return localItemBase;
        }
      }
    }
    if ((this.jdField_c_of_type_JavaUtilList != null) && (!TextUtils.isEmpty(paramString)))
    {
      localIterator = this.jdField_c_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        localItemBase = (EffectConfigBase.ItemBase)localIterator.next();
        if (paramString.equals(localItemBase.getId())) {
          return localItemBase;
        }
      }
    }
    return null;
  }
  
  protected abstract Class<?> a();
  
  protected String a()
  {
    String str = null;
    QAVConfItem localQAVConfItem = QAVConfig.b(a());
    if (localQAVConfItem != null) {
      str = localQAVConfItem.jdField_a_of_type_JavaLangString;
    }
    return str;
  }
  
  public String a(T paramT)
  {
    return AVPathUtil.a() + paramT.cid + File.separator + "temp" + File.separator + paramT.getId() + ".zip";
  }
  
  protected List<T> a(int paramInt, String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    int k;
    int i;
    int j;
    label68:
    EffectConfigBase.ItemBase localItemBase;
    int m;
    boolean bool1;
    if (!TextUtils.isEmpty(paramString))
    {
      try
      {
        localObject = new JSONObject(paramString);
        k = UITools.getQQVersion();
        if (paramInt != 543) {
          break label432;
        }
        i = 1;
      }
      catch (Exception paramString)
      {
        Object localObject;
        boolean bool2;
        String str1;
        String str2;
        File localFile;
        QLog.w(this.jdField_a_of_type_JavaLangString, 1, "parse, cid[" + paramInt + "], Exception", paramString);
        a(paramInt, jdField_c_of_type_JavaLangString, 0, null);
      }
      if (((JSONObject)localObject).has(paramString))
      {
        paramString = ((JSONObject)localObject).getJSONArray(paramString);
        localObject = a();
        j = 0;
        if (j < paramString.length())
        {
          localItemBase = (EffectConfigBase.ItemBase)JSONUtils.a((JSONObject)paramString.get(j), (Class)localObject);
          if ((localItemBase == null) || (TextUtils.isEmpty(localItemBase.getId()))) {
            break label423;
          }
          localItemBase.cid = paramInt;
          m = localItemBase.getPlatform();
          AVLog.printColorLog(this.jdField_a_of_type_JavaLangString, "cid = " + localItemBase.cid + ", item: " + localItemBase.toString() + "|" + k + "|" + m);
          bool2 = a(localItemBase);
          bool1 = bool2;
          if (bool2)
          {
            str1 = a(localItemBase);
            str2 = b(localItemBase);
            localFile = new File(str2);
            bool1 = localFile.exists();
            if (bool1) {}
          }
        }
      }
    }
    label423:
    label432:
    label435:
    for (;;)
    {
      try
      {
        FileUtils.a(str1, str2, false);
        bool1 = localFile.exists();
        if (i == 0) {
          break label382;
        }
        localItemBase.setUsable(bool1);
        localArrayList.add(localItemBase);
        break label423;
        paramString = b();
      }
      catch (Throwable localThrowable)
      {
        QLog.i(this.jdField_a_of_type_JavaLangString, 1, "parse item fail, item[" + localItemBase + "]", localThrowable);
        continue;
      }
      return localArrayList;
      label382:
      if ((m == 0) || (k >= m))
      {
        localItemBase.setUsable(bool1);
        localArrayList.add(localItemBase);
      }
      for (;;)
      {
        if (i == 0) {
          break label435;
        }
        paramString = "content";
        break;
        j += 1;
        break label68;
        i = 0;
      }
    }
  }
  
  public List<T> a(String paramString)
  {
    b();
    if (TextUtils.equals("voicesticker", paramString)) {
      return this.jdField_b_of_type_JavaUtilList;
    }
    if (TextUtils.equals("creativecop", paramString)) {
      return this.jdField_c_of_type_JavaUtilList;
    }
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  protected void a() {}
  
  public void a(long paramLong, EffectConfigBase.IEffectConfigCallback<T> paramIEffectConfigCallback)
  {
    if (paramIEffectConfigCallback != null)
    {
      if (a(paramIEffectConfigCallback) == null)
      {
        WeakReference localWeakReference = new WeakReference(paramIEffectConfigCallback);
        this.jdField_d_of_type_JavaUtilList.add(localWeakReference);
      }
      if (QLog.isColorLevel()) {
        QLog.w(this.jdField_a_of_type_JavaLangString, 1, "addCallback, callback[" + paramIEffectConfigCallback.getClass().getSimpleName() + "], callback[" + paramIEffectConfigCallback + "], seq[" + paramLong + "]");
      }
    }
  }
  
  public void a(long paramLong, T paramT)
  {
    if ((paramT.isUsable()) || (TextUtils.isEmpty(paramT.getResurl())))
    {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "startDownload, 不下载, item[" + paramT + "], seq[" + paramLong + "]");
      paramT.isDownloading = false;
      this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1, 1, (int)paramLong, paramT).sendToTarget();
      return;
    }
    HttpNetReq localHttpNetReq = new HttpNetReq();
    localHttpNetReq.mCallback = new EffectConfigBase.1(this, paramLong, paramT);
    localHttpNetReq.mReqUrl = paramT.getResurl();
    localHttpNetReq.mHttpMethod = 0;
    localHttpNetReq.mOutPath = a(paramT);
    localHttpNetReq.mContinuErrorLimit = NetworkUtil.a(NetworkCenter.getInstance().getNetType());
    localHttpNetReq.setUserData(paramT);
    QLog.w(this.jdField_a_of_type_JavaLangString, 1, "startDownload, item[" + paramT + "], seq[" + paramLong + "]");
    paramT.isDownloading = true;
    ThreadManager.post(new EffectConfigBase.NetReqRunnable(this, localHttpNetReq), 5, null, true);
  }
  
  protected void a(Message paramMessage) {}
  
  protected void a(T paramT) {}
  
  protected void a(String paramString, boolean paramBoolean)
  {
    if ((paramBoolean) && ((paramString.equals(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a().jdField_d_of_type_JavaLangString)) || (paramString.equals(String.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a().g))))) {
      a(AudioHelper.b(), null);
    }
  }
  
  public boolean a(long paramLong, T paramT)
  {
    EffectConfigBase.ItemBase localItemBase = null;
    Object localObject = null;
    if (!a(this.jdField_a_of_type_ComTencentAvBusinessManagerEffectConfigBase$ItemBase, paramT))
    {
      localItemBase = this.jdField_a_of_type_ComTencentAvBusinessManagerEffectConfigBase$ItemBase;
      this.jdField_a_of_type_ComTencentAvBusinessManagerEffectConfigBase$ItemBase = paramT;
      if (AudioHelper.e())
      {
        if (QLog.isDevelopLevel()) {
          localObject = new Throwable("打印调用栈");
        }
        QLog.w(this.jdField_a_of_type_JavaLangString, 1, "setCurrentItem, notify MSG_ON_ITEM_SELECT_CHANGED, seq[" + paramLong + "], count_MSG[" + this.jdField_a_of_type_Int + "], \nlast[" + localItemBase + "], \nnew[" + this.jdField_a_of_type_ComTencentAvBusinessManagerEffectConfigBase$ItemBase + "]", (Throwable)localObject);
      }
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
      this.jdField_a_of_type_Int = 1;
      paramT = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(0, paramT);
      paramT.arg1 = ((int)paramLong);
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramT);
      return true;
    }
    if (QLog.isDevelopLevel())
    {
      localObject = localItemBase;
      if (QLog.isDevelopLevel()) {
        localObject = new Throwable("打印调用栈");
      }
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "setCurrentItem, 重复, seq[" + paramLong + "], count_MSG_ON_ITEM_SELECT_CHANGED[" + this.jdField_a_of_type_Int + "], item[" + paramT + "]", (Throwable)localObject);
    }
    return false;
  }
  
  public boolean a(long paramLong, String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "setCurrentItemById, id[" + paramString + "], seq[" + paramLong + "]");
    }
    if (TextUtils.isEmpty(paramString))
    {
      a(paramLong, null);
      return true;
    }
    a(paramLong, a(paramString));
    return true;
  }
  
  protected boolean a(T paramT)
  {
    if ((paramT == null) || (paramT.cid <= 0) || (TextUtils.isEmpty(paramT.getId())))
    {
      str = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder().append("isTemplateUsable:");
      if (paramT != null) {}
      for (paramT = Integer.valueOf(paramT.cid);; paramT = "item == null")
      {
        AVLog.printErrorLog(str, paramT + "|");
        return false;
      }
    }
    if (TextUtils.isEmpty(paramT.getResurl())) {
      return true;
    }
    String str = a(paramT);
    if (!new File(str).exists()) {
      return false;
    }
    long l1 = SystemClock.elapsedRealtime();
    str = SecUtil.getFileMd5(str);
    long l2 = SystemClock.elapsedRealtime();
    paramT = paramT.getMd5();
    AVLog.printColorLog(this.jdField_a_of_type_JavaLangString, "isTemplateUsable :" + str + "|" + paramT + "|" + (l2 - l1));
    return paramT.equalsIgnoreCase(str);
  }
  
  public int b(int paramInt, String paramString)
  {
    AVLog.printColorLog(this.jdField_a_of_type_JavaLangString, "onSendMessageToPeer :" + paramInt + "|" + paramString);
    return this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a(paramInt, paramString);
  }
  
  protected String b()
  {
    return "content";
  }
  
  public String b(T paramT)
  {
    return AVPathUtil.a() + paramT.cid + File.separator + paramT.getId() + File.separator;
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0))
    {
      String str = a();
      this.jdField_a_of_type_JavaUtilList = a(a(), str);
    }
    if (a() == 176)
    {
      if ((this.jdField_b_of_type_JavaUtilList == null) || (this.jdField_b_of_type_JavaUtilList.size() == 0)) {
        this.jdField_b_of_type_JavaUtilList = a(370, QAVConfig.b(370).jdField_a_of_type_JavaLangString);
      }
      if ((this.jdField_c_of_type_JavaUtilList == null) || (this.jdField_c_of_type_JavaUtilList.size() == 0)) {
        this.jdField_c_of_type_JavaUtilList = a(543, QAVConfig.b(543).jdField_a_of_type_JavaLangString);
      }
    }
  }
  
  public void b(long paramLong, EffectConfigBase.IEffectConfigCallback<T> paramIEffectConfigCallback)
  {
    if (paramIEffectConfigCallback != null)
    {
      if (a(paramIEffectConfigCallback) != null) {
        this.jdField_d_of_type_JavaUtilList.remove(paramIEffectConfigCallback);
      }
      if (QLog.isColorLevel()) {
        QLog.w(this.jdField_a_of_type_JavaLangString, 1, "removeCallback, callback[" + paramIEffectConfigCallback.getClass().getSimpleName() + "], callback[" + paramIEffectConfigCallback + "], seq[" + paramLong + "]");
      }
    }
  }
  
  public String c(T paramT)
  {
    return AVPathUtil.a() + paramT.cid + File.separator + paramT.getId();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.business.manager.EffectConfigBase
 * JD-Core Version:    0.7.0.1
 */