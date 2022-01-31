package com.tencent.av.business.manager;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import baub;
import bavg;
import bdcs;
import bdhb;
import bdin;
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
import lek;
import len;
import lew;
import lex;
import lid;
import ljg;
import ljk;
import ljm;
import ljn;
import ljo;
import ljp;
import mww;
import org.json.JSONArray;
import org.json.JSONObject;

public abstract class EffectConfigBase<T extends ljo>
  extends ljg
{
  public static String b;
  public static String c;
  private static String d;
  private static String e;
  public int a;
  public Handler a;
  public List<T> a;
  protected final ljk a;
  public T a;
  protected List<T> b;
  protected List<T> c;
  protected List<WeakReference<ljn<T>>> d;
  
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
    this.jdField_a_of_type_Ljk = new ljk();
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_AndroidOsHandler = new ljp(this.jdField_a_of_type_JavaLangString, this);
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
  
  private WeakReference<ljn<T>> a(ljn<T> paramljn)
  {
    int j = this.jdField_d_of_type_JavaUtilList.size();
    int i = 0;
    while (i < j)
    {
      WeakReference localWeakReference = (WeakReference)this.jdField_d_of_type_JavaUtilList.get(i);
      if ((localWeakReference != null) && (localWeakReference.get() != null) && (((ljn)localWeakReference.get()).equals(paramljn))) {
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
        ((ljo)localObject).setUsable(true);
      }
    }
    int j = this.jdField_d_of_type_JavaUtilList.size();
    int i = 0;
    while (i < j)
    {
      localObject = (WeakReference)this.jdField_d_of_type_JavaUtilList.get(i);
      if ((localObject != null) && (((WeakReference)localObject).get() != null)) {
        ((ljn)((WeakReference)localObject).get()).onDownloadFinish(paramLong, paramT, paramBoolean);
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
        ((ljn)localWeakReference.get()).onProgressUpdate(paramT, paramInt);
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
        ((ljn)localWeakReference.get()).onItemSelectedChanged(paramLong, paramT);
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
  
  protected abstract Class<?> a();
  
  protected String a()
  {
    String str = null;
    lew locallew = lex.b(a());
    if (locallew != null) {
      str = locallew.jdField_a_of_type_JavaLangString;
    }
    return str;
  }
  
  public String a(T paramT)
  {
    return len.a() + paramT.cid + File.separator + "temp" + File.separator + paramT.getId() + ".zip";
  }
  
  protected List<T> a(int paramInt, String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    int k;
    int i;
    int j;
    label68:
    ljo localljo;
    int m;
    boolean bool1;
    if (!TextUtils.isEmpty(paramString))
    {
      try
      {
        localObject = new JSONObject(paramString);
        k = mww.b();
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
          localljo = (ljo)bdcs.a((JSONObject)paramString.get(j), (Class)localObject);
          if ((localljo == null) || (TextUtils.isEmpty(localljo.getId()))) {
            break label423;
          }
          localljo.cid = paramInt;
          m = localljo.getPlatform();
          lek.c(this.jdField_a_of_type_JavaLangString, "cid = " + localljo.cid + ", item: " + localljo.toString() + "|" + k + "|" + m);
          bool2 = a(localljo);
          bool1 = bool2;
          if (bool2)
          {
            str1 = a(localljo);
            str2 = b(localljo);
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
        bdhb.a(str1, str2, false);
        bool1 = localFile.exists();
        if (i == 0) {
          break label382;
        }
        localljo.setUsable(bool1);
        localArrayList.add(localljo);
        break label423;
        paramString = b();
      }
      catch (Throwable localThrowable)
      {
        QLog.i(this.jdField_a_of_type_JavaLangString, 1, "parse item fail, item[" + localljo + "]", localThrowable);
        continue;
      }
      return localArrayList;
      label382:
      if ((m == 0) || (k >= m))
      {
        localljo.setUsable(bool1);
        localArrayList.add(localljo);
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
  
  public T a()
  {
    return this.jdField_a_of_type_Ljo;
  }
  
  public T a(String paramString)
  {
    b();
    Iterator localIterator;
    ljo localljo;
    if ((this.jdField_a_of_type_JavaUtilList != null) && (!TextUtils.isEmpty(paramString)))
    {
      localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        localljo = (ljo)localIterator.next();
        if (paramString.equals(localljo.getId())) {
          return localljo;
        }
      }
    }
    if ((this.jdField_b_of_type_JavaUtilList != null) && (!TextUtils.isEmpty(paramString)))
    {
      localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        localljo = (ljo)localIterator.next();
        if (paramString.equals(localljo.getId())) {
          return localljo;
        }
      }
    }
    if ((this.jdField_c_of_type_JavaUtilList != null) && (!TextUtils.isEmpty(paramString)))
    {
      localIterator = this.jdField_c_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        localljo = (ljo)localIterator.next();
        if (paramString.equals(localljo.getId())) {
          return localljo;
        }
      }
    }
    return null;
  }
  
  public void a() {}
  
  public void a(long paramLong, ljn<T> paramljn)
  {
    if (paramljn != null)
    {
      if (a(paramljn) == null)
      {
        WeakReference localWeakReference = new WeakReference(paramljn);
        this.jdField_d_of_type_JavaUtilList.add(localWeakReference);
      }
      if (QLog.isColorLevel()) {
        QLog.w(this.jdField_a_of_type_JavaLangString, 1, "addCallback, callback[" + paramljn.getClass().getSimpleName() + "], callback[" + paramljn + "], seq[" + paramLong + "]");
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
    baub localbaub = new baub();
    localbaub.jdField_a_of_type_Baug = new ljm(this, paramLong, paramT);
    localbaub.jdField_a_of_type_JavaLangString = paramT.getResurl();
    localbaub.jdField_a_of_type_Int = 0;
    localbaub.jdField_c_of_type_JavaLangString = a(paramT);
    localbaub.jdField_c_of_type_Int = bdin.a(bavg.a().a());
    localbaub.a(paramT);
    QLog.w(this.jdField_a_of_type_JavaLangString, 1, "startDownload, item[" + paramT + "], seq[" + paramLong + "]");
    paramT.isDownloading = true;
    ThreadManager.post(new EffectConfigBase.NetReqRunnable(this, localbaub), 5, null, true);
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
    ljo localljo = null;
    Object localObject = null;
    if (!a(this.jdField_a_of_type_Ljo, paramT))
    {
      localljo = this.jdField_a_of_type_Ljo;
      this.jdField_a_of_type_Ljo = paramT;
      if (AudioHelper.e())
      {
        if (QLog.isDevelopLevel()) {
          localObject = new Throwable("打印调用栈");
        }
        QLog.w(this.jdField_a_of_type_JavaLangString, 1, "setCurrentItem, notify MSG_ON_ITEM_SELECT_CHANGED, seq[" + paramLong + "], count_MSG[" + this.jdField_a_of_type_Int + "], \nlast[" + localljo + "], \nnew[" + this.jdField_a_of_type_Ljo + "]", (Throwable)localObject);
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
      localObject = localljo;
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
        lek.e(str, paramT + "|");
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
    lek.c(this.jdField_a_of_type_JavaLangString, "isTemplateUsable :" + str + "|" + paramT + "|" + (l2 - l1));
    return paramT.equalsIgnoreCase(str);
  }
  
  public int b(int paramInt, String paramString)
  {
    lek.c(this.jdField_a_of_type_JavaLangString, "onSendMessageToPeer :" + paramInt + "|" + paramString);
    return this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a(paramInt, paramString);
  }
  
  protected String b()
  {
    return "content";
  }
  
  public String b(T paramT)
  {
    return len.a() + paramT.cid + File.separator + paramT.getId() + File.separator;
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
        this.jdField_b_of_type_JavaUtilList = a(370, lex.b(370).jdField_a_of_type_JavaLangString);
      }
      if ((this.jdField_c_of_type_JavaUtilList == null) || (this.jdField_c_of_type_JavaUtilList.size() == 0)) {
        this.jdField_c_of_type_JavaUtilList = a(543, lex.b(543).jdField_a_of_type_JavaLangString);
      }
    }
  }
  
  public void b(long paramLong, ljn<T> paramljn)
  {
    if (paramljn != null)
    {
      if (a(paramljn) != null) {
        this.jdField_d_of_type_JavaUtilList.remove(paramljn);
      }
      if (QLog.isColorLevel()) {
        QLog.w(this.jdField_a_of_type_JavaLangString, 1, "removeCallback, callback[" + paramljn.getClass().getSimpleName() + "], callback[" + paramljn + "], seq[" + paramLong + "]");
      }
    }
  }
  
  public String c(T paramT)
  {
    return len.a() + paramT.cid + File.separator + paramT.getId();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.business.manager.EffectConfigBase
 * JD-Core Version:    0.7.0.1
 */