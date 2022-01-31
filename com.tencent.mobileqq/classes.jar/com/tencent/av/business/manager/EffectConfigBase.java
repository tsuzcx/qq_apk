package com.tencent.av.business.manager;

import ajed;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import axro;
import axsr;
import azxx;
import bace;
import badq;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.SecUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import krx;
import ksi;
import ksj;
import kvq;
import kwt;
import kwx;
import kwz;
import kxa;
import kxb;
import kxc;
import mjg;
import org.json.JSONArray;
import org.json.JSONObject;

public abstract class EffectConfigBase<T extends kxb>
  extends kwt
{
  public static final String b;
  public static String c;
  public static String d;
  private static String e;
  private static String f;
  public int a;
  public Handler a;
  protected List<T> a;
  protected final kwx a;
  public T a;
  protected List<T> b;
  protected List<T> c;
  protected List<WeakReference<kxa<T>>> d;
  
  static
  {
    jdField_b_of_type_JavaLangString = ajed.aU + "qav" + File.separator;
    e = "qav_config_";
    f = "text";
    jdField_c_of_type_JavaLangString = "ver";
    jdField_d_of_type_JavaLangString = "0";
  }
  
  public EffectConfigBase(VideoAppInterface paramVideoAppInterface)
  {
    super(paramVideoAppInterface);
    this.jdField_a_of_type_Kwx = new kwx();
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_AndroidOsHandler = new kxc(this.jdField_a_of_type_JavaLangString, this);
    this.jdField_d_of_type_JavaUtilList = new ArrayList();
  }
  
  public static SharedPreferences a(int paramInt, String paramString)
  {
    paramString = a(paramInt, paramString);
    return BaseApplicationImpl.getContext().getSharedPreferences(paramString, 4);
  }
  
  public static String a(int paramInt)
  {
    return jdField_b_of_type_JavaLangString + paramInt + File.separator;
  }
  
  public static String a(int paramInt, String paramString)
  {
    if ((AudioHelper.d()) && (TextUtils.isEmpty(paramString))) {
      throw new IllegalArgumentException("getConfigSPName uin不能为空, configId:" + paramInt);
    }
    return e + paramInt + "_" + paramString;
  }
  
  private WeakReference<kxa<T>> a(kxa<T> paramkxa)
  {
    int j = this.jdField_d_of_type_JavaUtilList.size();
    int i = 0;
    while (i < j)
    {
      WeakReference localWeakReference = (WeakReference)this.jdField_d_of_type_JavaUtilList.get(i);
      if ((localWeakReference != null) && (localWeakReference.get() != null) && (((kxa)localWeakReference.get()).equals(paramkxa))) {
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
      localEditor.remove(f);
      localEditor.putInt(jdField_c_of_type_JavaLangString, paramInt2);
      localEditor.commit();
      if (!QLog.isDevelopLevel()) {
        break label143;
      }
    }
    for (;;)
    {
      QLog.w("EffectConfigBase_" + paramInt1, 1, "saveConfig, configId[" + paramInt1 + "], uin[" + paramString1 + "], version[" + paramInt2 + "],\n" + paramString2 + "");
      return;
      localEditor.putString(f, paramString2);
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
        ((kxb)localObject).setUsable(true);
      }
    }
    int j = this.jdField_d_of_type_JavaUtilList.size();
    int i = 0;
    while (i < j)
    {
      localObject = (WeakReference)this.jdField_d_of_type_JavaUtilList.get(i);
      if ((localObject != null) && (((WeakReference)localObject).get() != null)) {
        ((kxa)((WeakReference)localObject).get()).onDownloadFinish(paramLong, paramT, paramBoolean);
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
        ((kxa)localWeakReference.get()).onProgressUpdate(paramT, paramInt);
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
    return a(paramInt, paramString).getString(f, null);
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
        ((kxa)localWeakReference.get()).onItemSelectedChanged(paramLong, paramT);
      }
      i += 1;
    }
  }
  
  public static int c(int paramInt, String paramString)
  {
    return a(paramInt, paramString).getInt(jdField_c_of_type_JavaLangString, 0);
  }
  
  public abstract int a();
  
  public int a(int paramInt, String paramString)
  {
    return 0;
  }
  
  protected abstract Class<?> a();
  
  protected String a()
  {
    return ksj.b(a()).jdField_a_of_type_JavaLangString;
  }
  
  public String a(T paramT)
  {
    return jdField_b_of_type_JavaLangString + paramT.cid + File.separator + "temp" + File.separator + paramT.getId() + ".zip";
  }
  
  protected List<T> a(int paramInt, String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    int k;
    int i;
    int j;
    label68:
    kxb localkxb;
    int m;
    boolean bool1;
    if (!TextUtils.isEmpty(paramString))
    {
      try
      {
        localObject = new JSONObject(paramString);
        k = mjg.b();
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
        a(paramInt, jdField_d_of_type_JavaLangString, 0, null);
      }
      if (((JSONObject)localObject).has(paramString))
      {
        paramString = ((JSONObject)localObject).getJSONArray(paramString);
        localObject = a();
        j = 0;
        if (j < paramString.length())
        {
          localkxb = (kxb)azxx.a((JSONObject)paramString.get(j), (Class)localObject);
          if ((localkxb == null) || (TextUtils.isEmpty(localkxb.getId()))) {
            break label423;
          }
          localkxb.cid = paramInt;
          m = localkxb.getPlatform();
          krx.c(this.jdField_a_of_type_JavaLangString, "cid = " + localkxb.cid + ", item: " + localkxb.toString() + "|" + k + "|" + m);
          bool2 = a(localkxb);
          bool1 = bool2;
          if (bool2)
          {
            str1 = a(localkxb);
            str2 = b(localkxb);
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
        bace.a(str1, str2, false);
        bool1 = localFile.exists();
        if (i == 0) {
          break label382;
        }
        localkxb.setUsable(bool1);
        localArrayList.add(localkxb);
        break label423;
        paramString = b();
      }
      catch (Throwable localThrowable)
      {
        QLog.i(this.jdField_a_of_type_JavaLangString, 1, "parse item fail, item[" + localkxb + "]", localThrowable);
        continue;
      }
      return localArrayList;
      label382:
      if ((m == 0) || (k >= m))
      {
        localkxb.setUsable(bool1);
        localArrayList.add(localkxb);
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
    t_();
    if (TextUtils.equals("voicesticker", paramString)) {
      return this.jdField_b_of_type_JavaUtilList;
    }
    if (TextUtils.equals("creativecop", paramString)) {
      return this.jdField_c_of_type_JavaUtilList;
    }
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public T a()
  {
    return this.jdField_a_of_type_Kxb;
  }
  
  public T a(String paramString)
  {
    t_();
    Iterator localIterator;
    kxb localkxb;
    if ((this.jdField_a_of_type_JavaUtilList != null) && (!TextUtils.isEmpty(paramString)))
    {
      localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        localkxb = (kxb)localIterator.next();
        if (paramString.equals(localkxb.getId())) {
          return localkxb;
        }
      }
    }
    if ((this.jdField_b_of_type_JavaUtilList != null) && (!TextUtils.isEmpty(paramString)))
    {
      localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        localkxb = (kxb)localIterator.next();
        if (paramString.equals(localkxb.getId())) {
          return localkxb;
        }
      }
    }
    if ((this.jdField_c_of_type_JavaUtilList != null) && (!TextUtils.isEmpty(paramString)))
    {
      localIterator = this.jdField_c_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        localkxb = (kxb)localIterator.next();
        if (paramString.equals(localkxb.getId())) {
          return localkxb;
        }
      }
    }
    return null;
  }
  
  public void a() {}
  
  public void a(long paramLong, kxa<T> paramkxa)
  {
    if (paramkxa != null)
    {
      if (a(paramkxa) == null)
      {
        WeakReference localWeakReference = new WeakReference(paramkxa);
        this.jdField_d_of_type_JavaUtilList.add(localWeakReference);
      }
      if (QLog.isColorLevel()) {
        QLog.w(this.jdField_a_of_type_JavaLangString, 1, "addCallback, callback[" + paramkxa.getClass().getSimpleName() + "], callback[" + paramkxa + "], seq[" + paramLong + "]");
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
    axro localaxro = new axro();
    localaxro.jdField_a_of_type_Axrt = new kwz(this, paramLong, paramT);
    localaxro.jdField_a_of_type_JavaLangString = paramT.getResurl();
    localaxro.jdField_a_of_type_Int = 0;
    localaxro.jdField_c_of_type_JavaLangString = a(paramT);
    localaxro.jdField_c_of_type_Int = badq.a(axsr.a().a());
    localaxro.a(paramT);
    QLog.w(this.jdField_a_of_type_JavaLangString, 1, "startDownload, item[" + paramT + "], seq[" + paramLong + "]");
    paramT.isDownloading = true;
    ThreadManager.post(new EffectConfigBase.NetReqRunnable(this, localaxro), 5, null, true);
  }
  
  public void a(Message paramMessage) {}
  
  public void a(String paramString, boolean paramBoolean)
  {
    if ((paramBoolean) && ((paramString.equals(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a().jdField_d_of_type_JavaLangString)) || (paramString.equals(String.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a().g))))) {
      a(AudioHelper.b(), null);
    }
  }
  
  public void a(T paramT) {}
  
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
  
  public boolean a(long paramLong, T paramT)
  {
    kxb localkxb = null;
    Object localObject = null;
    if (!a(this.jdField_a_of_type_Kxb, paramT))
    {
      localkxb = this.jdField_a_of_type_Kxb;
      this.jdField_a_of_type_Kxb = paramT;
      if (AudioHelper.e())
      {
        if (QLog.isDevelopLevel()) {
          localObject = new Throwable("打印调用栈");
        }
        QLog.w(this.jdField_a_of_type_JavaLangString, 1, "setCurrentItem, notify MSG_ON_ITEM_SELECT_CHANGED, seq[" + paramLong + "], count_MSG[" + this.jdField_a_of_type_Int + "], \nlast[" + localkxb + "], \nnew[" + this.jdField_a_of_type_Kxb + "]", (Throwable)localObject);
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
      localObject = localkxb;
      if (QLog.isDevelopLevel()) {
        localObject = new Throwable("打印调用栈");
      }
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "setCurrentItem, 重复, seq[" + paramLong + "], count_MSG_ON_ITEM_SELECT_CHANGED[" + this.jdField_a_of_type_Int + "], item[" + paramT + "]", (Throwable)localObject);
    }
    return false;
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
        krx.e(str, paramT + "|");
        return false;
      }
    }
    if (TextUtils.isEmpty(paramT.getResurl())) {
      return true;
    }
    if (!new File(a(paramT)).exists()) {
      return false;
    }
    long l1 = System.currentTimeMillis();
    String str = SecUtil.getFileMd5(a(paramT));
    long l2 = System.currentTimeMillis();
    paramT = paramT.getMd5();
    krx.c(this.jdField_a_of_type_JavaLangString, "isTemplateUsable :" + str + "|" + paramT + "|" + (l2 - l1));
    return paramT.equalsIgnoreCase(str);
  }
  
  public int b(int paramInt, String paramString)
  {
    krx.c(this.jdField_a_of_type_JavaLangString, "onSendMessageToPeer :" + paramInt + "|" + paramString);
    return this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a(paramInt, paramString);
  }
  
  protected String b()
  {
    return "content";
  }
  
  public String b(T paramT)
  {
    return jdField_b_of_type_JavaLangString + paramT.cid + File.separator + paramT.getId() + File.separator;
  }
  
  public void b(long paramLong, kxa<T> paramkxa)
  {
    if (paramkxa != null)
    {
      if (a(paramkxa) != null) {
        this.jdField_d_of_type_JavaUtilList.remove(paramkxa);
      }
      if (QLog.isColorLevel()) {
        QLog.w(this.jdField_a_of_type_JavaLangString, 1, "removeCallback, callback[" + paramkxa.getClass().getSimpleName() + "], callback[" + paramkxa + "], seq[" + paramLong + "]");
      }
    }
  }
  
  public String c(T paramT)
  {
    return jdField_b_of_type_JavaLangString + paramT.cid + File.separator + paramT.getId();
  }
  
  public void t_()
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0))
    {
      String str = a();
      this.jdField_a_of_type_JavaUtilList = a(a(), str);
    }
    if (a() == 176)
    {
      if ((this.jdField_b_of_type_JavaUtilList == null) || (this.jdField_b_of_type_JavaUtilList.size() == 0)) {
        this.jdField_b_of_type_JavaUtilList = a(370, ksj.b(370).jdField_a_of_type_JavaLangString);
      }
      if ((this.jdField_c_of_type_JavaUtilList == null) || (this.jdField_c_of_type_JavaUtilList.size() == 0)) {
        this.jdField_c_of_type_JavaUtilList = a(543, ksj.b(543).jdField_a_of_type_JavaLangString);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.business.manager.EffectConfigBase
 * JD-Core Version:    0.7.0.1
 */