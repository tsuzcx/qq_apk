package com.tencent.av.business.manager;

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
import com.tencent.av.business.manager.pendant.ItemBase;
import com.tencent.av.utils.AudioHelper;
import com.tencent.av.utils.QAVConfigUtils;
import com.tencent.av.utils.UITools;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.util.JSONUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.SecUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public abstract class EffectConfigBase<T extends ItemBase>
  extends BusinessManager
{
  int a;
  protected Handler a;
  protected final Checker a;
  protected T a;
  protected List<T> a;
  protected List<T> b;
  protected List<WeakReference<EffectConfigBase.IEffectConfigCallback<T>>> c = new ArrayList();
  
  public EffectConfigBase(VideoAppInterface paramVideoAppInterface)
  {
    super(paramVideoAppInterface);
    this.jdField_a_of_type_ComTencentAvBusinessManagerChecker = new Checker();
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_AndroidOsHandler = new EffectConfigBase.MyHander(this.jdField_a_of_type_JavaLangString, this);
  }
  
  private WeakReference<EffectConfigBase.IEffectConfigCallback<T>> a(EffectConfigBase.IEffectConfigCallback<T> paramIEffectConfigCallback)
  {
    int j = this.c.size();
    int i = 0;
    while (i < j)
    {
      WeakReference localWeakReference = (WeakReference)this.c.get(i);
      if ((localWeakReference != null) && (localWeakReference.get() != null) && (((EffectConfigBase.IEffectConfigCallback)localWeakReference.get()).equals(paramIEffectConfigCallback))) {
        return localWeakReference;
      }
      i += 1;
    }
    return null;
  }
  
  private void a(long paramLong, T paramT, boolean paramBoolean)
  {
    Object localObject;
    if (AudioHelper.b())
    {
      localObject = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("triggleonResourceDownloadFinished, id[");
      localStringBuilder.append(paramT.getId());
      localStringBuilder.append("], isSuccess[");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("]");
      QLog.w((String)localObject, 1, localStringBuilder.toString());
    }
    if (paramBoolean)
    {
      localObject = a(paramT.getId());
      if (localObject != null) {
        ((ItemBase)localObject).setUsable(true);
      }
    }
    int j = this.c.size();
    int i = 0;
    while (i < j)
    {
      localObject = (WeakReference)this.c.get(i);
      if ((localObject != null) && (((WeakReference)localObject).get() != null)) {
        ((EffectConfigBase.IEffectConfigCallback)((WeakReference)localObject).get()).onDownloadFinish(paramLong, paramT, paramBoolean);
      }
      i += 1;
    }
  }
  
  private void a(T paramT, int paramInt)
  {
    int j = this.c.size();
    int i = 0;
    while (i < j)
    {
      WeakReference localWeakReference = (WeakReference)this.c.get(i);
      if ((localWeakReference != null) && (localWeakReference.get() != null)) {
        ((EffectConfigBase.IEffectConfigCallback)localWeakReference.get()).onProgressUpdate(paramT, paramInt);
      }
      i += 1;
    }
  }
  
  private boolean a(T paramT1, T paramT2)
  {
    if (paramT1 == null)
    {
      if (paramT2 == null) {
        return true;
      }
    }
    else if ((paramT2 != null) && (paramT1.getId().equals(paramT2.getId()))) {
      return true;
    }
    return false;
  }
  
  private void b(long paramLong, T paramT)
  {
    int j = this.c.size();
    Object localObject;
    if (QLog.isDevelopLevel())
    {
      localObject = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("triggleonItemSelectedChanged, size[");
      localStringBuilder.append(j);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("]");
      QLog.w((String)localObject, 1, localStringBuilder.toString());
    }
    int i = 0;
    while (i < j)
    {
      localObject = (WeakReference)this.c.get(i);
      if ((localObject != null) && (((WeakReference)localObject).get() != null)) {
        ((EffectConfigBase.IEffectConfigCallback)((WeakReference)localObject).get()).onItemSelectedChanged(paramLong, paramT);
      }
      i += 1;
    }
  }
  
  public abstract int a();
  
  public int a(int paramInt, String paramString)
  {
    return 0;
  }
  
  public T a()
  {
    return this.jdField_a_of_type_ComTencentAvBusinessManagerPendantItemBase;
  }
  
  public T a(String paramString)
  {
    c();
    Iterator localIterator;
    ItemBase localItemBase;
    if ((this.jdField_a_of_type_JavaUtilList != null) && (!TextUtils.isEmpty(paramString)))
    {
      localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        localItemBase = (ItemBase)localIterator.next();
        if (paramString.equals(localItemBase.getId())) {
          return localItemBase;
        }
      }
    }
    if ((this.b != null) && (!TextUtils.isEmpty(paramString)))
    {
      localIterator = this.b.iterator();
      while (localIterator.hasNext())
      {
        localItemBase = (ItemBase)localIterator.next();
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
    QAVConfItem localQAVConfItem = QAVConfig.b(a());
    if (localQAVConfItem != null) {
      return localQAVConfItem.jdField_a_of_type_JavaLangString;
    }
    return null;
  }
  
  public String a(T paramT)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AVPathUtil.a());
    localStringBuilder.append(paramT.cid);
    localStringBuilder.append(File.separator);
    localStringBuilder.append("temp");
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramT.getId());
    localStringBuilder.append(".zip");
    return localStringBuilder.toString();
  }
  
  protected List<T> a(int paramInt, String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    if (!TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      int j;
      int k;
      try
      {
        paramString = new JSONObject(paramString);
        j = UITools.getQQVersion();
        Object localObject1 = b();
        Object localObject2;
        if (paramString.has((String)localObject1))
        {
          paramString = paramString.getJSONArray((String)localObject1);
          localObject1 = a();
          int i = 0;
          if (i < paramString.length())
          {
            localObject2 = (ItemBase)JSONUtils.a((JSONObject)paramString.get(i), (Class)localObject1);
            if ((localObject2 != null) && (!TextUtils.isEmpty(((ItemBase)localObject2).getId())))
            {
              ((ItemBase)localObject2).cid = paramInt;
              k = ((ItemBase)localObject2).getPlatform();
              Object localObject3 = this.jdField_a_of_type_JavaLangString;
              Object localObject4 = new StringBuilder();
              ((StringBuilder)localObject4).append("cid = ");
              ((StringBuilder)localObject4).append(((ItemBase)localObject2).cid);
              ((StringBuilder)localObject4).append(", item: ");
              ((StringBuilder)localObject4).append(localObject2.toString());
              ((StringBuilder)localObject4).append("|");
              ((StringBuilder)localObject4).append(j);
              ((StringBuilder)localObject4).append("|");
              ((StringBuilder)localObject4).append(k);
              AVLog.printColorLog((String)localObject3, ((StringBuilder)localObject4).toString());
              boolean bool2 = a((ItemBase)localObject2);
              boolean bool1 = bool2;
              if (!bool2) {
                break label433;
              }
              localObject4 = a((ItemBase)localObject2);
              String str = b((ItemBase)localObject2);
              localObject3 = new File(str);
              bool1 = ((File)localObject3).exists();
              if (!bool1) {
                try
                {
                  FileUtils.uncompressZip((String)localObject4, str, false);
                }
                catch (Throwable localThrowable)
                {
                  str = this.jdField_a_of_type_JavaLangString;
                  StringBuilder localStringBuilder = new StringBuilder();
                  localStringBuilder.append("parse item fail, item[");
                  localStringBuilder.append(localObject2);
                  localStringBuilder.append("]");
                  QLog.i(str, 1, localStringBuilder.toString(), localThrowable);
                }
              }
              bool1 = ((File)localObject3).exists();
              break label433;
              ((ItemBase)localObject2).setUsable(bool1);
              localArrayList.add(localObject2);
            }
            i += 1;
            continue;
          }
        }
        return localArrayList;
      }
      catch (Exception paramString)
      {
        localObject1 = this.jdField_a_of_type_JavaLangString;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("parse, cid[");
        ((StringBuilder)localObject2).append(paramInt);
        ((StringBuilder)localObject2).append("], Exception");
        QLog.w((String)localObject1, 1, ((StringBuilder)localObject2).toString(), paramString);
        QAVConfigUtils.a(paramInt, QAVConfigUtils.b, 0, null);
      }
      label433:
      if (k != 0) {
        if (j < k) {}
      }
    }
  }
  
  public List<T> a(String paramString)
  {
    c();
    if (TextUtils.equals("voicesticker", paramString)) {
      return this.b;
    }
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  protected void a() {}
  
  public void a(long paramLong, EffectConfigBase.IEffectConfigCallback<T> paramIEffectConfigCallback)
  {
    if (paramIEffectConfigCallback != null)
    {
      Object localObject;
      if (a(paramIEffectConfigCallback) == null)
      {
        localObject = new WeakReference(paramIEffectConfigCallback);
        this.c.add(localObject);
      }
      if (QLog.isColorLevel())
      {
        localObject = this.jdField_a_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("addCallback, callback[");
        localStringBuilder.append(paramIEffectConfigCallback.getClass().getSimpleName());
        localStringBuilder.append("], callback[");
        localStringBuilder.append(paramIEffectConfigCallback);
        localStringBuilder.append("], seq[");
        localStringBuilder.append(paramLong);
        localStringBuilder.append("]");
        QLog.w((String)localObject, 1, localStringBuilder.toString());
      }
    }
  }
  
  public void a(long paramLong, T paramT)
  {
    if ((!paramT.isUsable()) && (!TextUtils.isEmpty(paramT.getResUrl())))
    {
      localObject1 = new HttpNetReq();
      ((HttpNetReq)localObject1).mCallback = new EffectConfigBase.1(this, paramLong, paramT);
      ((HttpNetReq)localObject1).mReqUrl = paramT.getResUrl();
      ((HttpNetReq)localObject1).mHttpMethod = 0;
      ((HttpNetReq)localObject1).mOutPath = a(paramT);
      ((HttpNetReq)localObject1).mContinuErrorLimit = NetworkUtil.getConnRetryTimes(NetworkCenter.getInstance().getNetType());
      ((HttpNetReq)localObject1).setUserData(paramT);
      localObject2 = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("startDownload, item[");
      localStringBuilder.append(paramT);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("]");
      QLog.w((String)localObject2, 1, localStringBuilder.toString());
      paramT.isDownloading = true;
      ThreadManager.post(new EffectConfigBase.NetReqRunnable(this, (HttpNetReq)localObject1), 5, null, true);
      return;
    }
    Object localObject1 = this.jdField_a_of_type_JavaLangString;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("startDownload, 不下载, item[");
    ((StringBuilder)localObject2).append(paramT);
    ((StringBuilder)localObject2).append("], seq[");
    ((StringBuilder)localObject2).append(paramLong);
    ((StringBuilder)localObject2).append("]");
    QLog.w((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    paramT.isDownloading = false;
    this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1, 1, (int)paramLong, paramT).sendToTarget();
  }
  
  protected void a(Message paramMessage) {}
  
  protected void a(T paramT) {}
  
  protected void a(String paramString, boolean paramBoolean)
  {
    if ((paramBoolean) && ((paramString.equals(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a().c)) || (paramString.equals(String.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a().f))))) {
      a(AudioHelper.b(), null);
    }
  }
  
  protected void a(List<T> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      ItemBase localItemBase = (ItemBase)localIterator.next();
      if ((localItemBase != null) && (!TextUtils.isEmpty(localItemBase.getId())))
      {
        localItemBase.cid = a();
        String str1 = localItemBase.getVersion();
        Object localObject1 = this.jdField_a_of_type_JavaLangString;
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("cid = ");
        ((StringBuilder)localObject2).append(localItemBase.cid);
        ((StringBuilder)localObject2).append(", item: ");
        ((StringBuilder)localObject2).append(localItemBase.toString());
        ((StringBuilder)localObject2).append("|");
        ((StringBuilder)localObject2).append("8.7.0");
        ((StringBuilder)localObject2).append("|");
        ((StringBuilder)localObject2).append(str1);
        AVLog.printColorLog((String)localObject1, ((StringBuilder)localObject2).toString());
        boolean bool2 = a(localItemBase);
        boolean bool1 = bool2;
        if (bool2)
        {
          localObject2 = a(localItemBase);
          String str2 = b(localItemBase);
          localObject1 = new File(str2);
          if (!((File)localObject1).exists()) {
            try
            {
              FileUtils.uncompressZip((String)localObject2, str2, false);
            }
            catch (Throwable localThrowable)
            {
              str2 = this.jdField_a_of_type_JavaLangString;
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("parse item fail, item[");
              localStringBuilder.append(localItemBase);
              localStringBuilder.append("]");
              QLog.i(str2, 1, localStringBuilder.toString(), localThrowable);
            }
          }
          bool1 = ((File)localObject1).exists();
        }
        if ((!TextUtils.isEmpty(str1)) && (AppSetting.a(str1) < 0)) {
          localArrayList.add(localItemBase);
        } else {
          localItemBase.setUsable(bool1);
        }
      }
    }
    paramList.removeAll(localArrayList);
  }
  
  protected boolean a()
  {
    return false;
  }
  
  public boolean a(long paramLong, T paramT)
  {
    boolean bool = a(this.jdField_a_of_type_ComTencentAvBusinessManagerPendantItemBase, paramT);
    Object localObject2 = null;
    Object localObject1 = null;
    Object localObject3;
    if (!bool)
    {
      localObject2 = this.jdField_a_of_type_ComTencentAvBusinessManagerPendantItemBase;
      this.jdField_a_of_type_ComTencentAvBusinessManagerPendantItemBase = paramT;
      if (AudioHelper.b())
      {
        if (QLog.isDevelopLevel()) {
          localObject1 = new Throwable("打印调用栈");
        }
        localObject3 = this.jdField_a_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("setCurrentItem, notify MSG_ON_ITEM_SELECT_CHANGED, seq[");
        localStringBuilder.append(paramLong);
        localStringBuilder.append("], count_MSG[");
        localStringBuilder.append(this.jdField_a_of_type_Int);
        localStringBuilder.append("], \nlast[");
        localStringBuilder.append(localObject2);
        localStringBuilder.append("], \nnew[");
        localStringBuilder.append(this.jdField_a_of_type_ComTencentAvBusinessManagerPendantItemBase);
        localStringBuilder.append("]");
        QLog.w((String)localObject3, 1, localStringBuilder.toString(), (Throwable)localObject1);
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
      localObject1 = localObject2;
      if (QLog.isDevelopLevel()) {
        localObject1 = new Throwable("打印调用栈");
      }
      localObject2 = this.jdField_a_of_type_JavaLangString;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("setCurrentItem, 重复, seq[");
      ((StringBuilder)localObject3).append(paramLong);
      ((StringBuilder)localObject3).append("], count_MSG_ON_ITEM_SELECT_CHANGED[");
      ((StringBuilder)localObject3).append(this.jdField_a_of_type_Int);
      ((StringBuilder)localObject3).append("], item[");
      ((StringBuilder)localObject3).append(paramT);
      ((StringBuilder)localObject3).append("]");
      QLog.w((String)localObject2, 1, ((StringBuilder)localObject3).toString(), (Throwable)localObject1);
    }
    return false;
  }
  
  public boolean a(long paramLong, String paramString)
  {
    if (QLog.isDevelopLevel())
    {
      String str = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setCurrentItemById, id[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
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
    if ((paramT != null) && (paramT.cid > 0) && (!TextUtils.isEmpty(paramT.getId())))
    {
      if (TextUtils.isEmpty(paramT.getResUrl())) {
        return true;
      }
      str = a(paramT);
      if (!new File(str).exists()) {
        return false;
      }
      long l1 = SystemClock.elapsedRealtime();
      str = SecUtil.getFileMd5(str);
      long l2 = SystemClock.elapsedRealtime();
      paramT = paramT.getMd5();
      localObject = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isTemplateUsable :");
      localStringBuilder.append(str);
      localStringBuilder.append("|");
      localStringBuilder.append(paramT);
      localStringBuilder.append("|");
      localStringBuilder.append(l2 - l1);
      AVLog.printColorLog((String)localObject, localStringBuilder.toString());
      return paramT.equalsIgnoreCase(str);
    }
    String str = this.jdField_a_of_type_JavaLangString;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("isTemplateUsable:");
    if (paramT != null) {
      paramT = Integer.valueOf(paramT.cid);
    } else {
      paramT = "item == null";
    }
    ((StringBuilder)localObject).append(paramT);
    ((StringBuilder)localObject).append("|");
    AVLog.printErrorLog(str, ((StringBuilder)localObject).toString());
    return false;
  }
  
  public int b(int paramInt, String paramString)
  {
    String str = this.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onSendMessageToPeer :");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("|");
    localStringBuilder.append(paramString);
    AVLog.printColorLog(str, localStringBuilder.toString());
    return this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a(paramInt, paramString);
  }
  
  protected String b()
  {
    return "content";
  }
  
  public String b(T paramT)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AVPathUtil.a());
    localStringBuilder.append(paramT.cid);
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramT.getId());
    localStringBuilder.append(File.separator);
    return localStringBuilder.toString();
  }
  
  protected void b() {}
  
  public void b(long paramLong, EffectConfigBase.IEffectConfigCallback<T> paramIEffectConfigCallback)
  {
    if (paramIEffectConfigCallback != null)
    {
      if (a(paramIEffectConfigCallback) != null) {
        this.c.remove(paramIEffectConfigCallback);
      }
      if (QLog.isColorLevel())
      {
        String str = this.jdField_a_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("removeCallback, callback[");
        localStringBuilder.append(paramIEffectConfigCallback.getClass().getSimpleName());
        localStringBuilder.append("], callback[");
        localStringBuilder.append(paramIEffectConfigCallback);
        localStringBuilder.append("], seq[");
        localStringBuilder.append(paramLong);
        localStringBuilder.append("]");
        QLog.w(str, 1, localStringBuilder.toString());
      }
    }
  }
  
  protected void c()
  {
    if (a())
    {
      if (QLog.isColorLevel()) {
        QLog.i(this.jdField_a_of_type_JavaLangString, 2, "config pull from middle platform");
      }
      b();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i(this.jdField_a_of_type_JavaLangString, 2, "config pull from manager");
    }
    Object localObject = this.jdField_a_of_type_JavaUtilList;
    if ((localObject == null) || (((List)localObject).size() == 0))
    {
      localObject = a();
      this.jdField_a_of_type_JavaUtilList = a(a(), (String)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.business.manager.EffectConfigBase
 * JD-Core Version:    0.7.0.1
 */