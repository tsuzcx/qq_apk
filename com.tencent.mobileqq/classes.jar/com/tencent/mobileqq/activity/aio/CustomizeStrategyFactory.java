package com.tencent.mobileqq.activity.aio;

import ackn;
import acko;
import ackp;
import ackq;
import ackr;
import ackt;
import ackx;
import ackz;
import aclb;
import aeav;
import aeaw;
import aeax;
import aeay;
import aeaz;
import aeba;
import aebb;
import aebc;
import agmo;
import agmq;
import agmu;
import ajld;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.cache.QQLruCache;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.qwallet.redpacket.IRedPacket;
import com.tencent.mobileqq.activity.qwallet.redpacket.RedPacketManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import mqq.os.MqqHandler;

public class CustomizeStrategyFactory
  implements agmu, Handler.Callback
{
  public static float a;
  private static volatile CustomizeStrategyFactory jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory;
  public static byte[] a;
  public agmq a;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private SparseArray<ackp> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray(5);
  private QQLruCache<String, aeav> jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache = new ackn(this, 1020, 30, 10000);
  private HashMap<Object, ackq> jdField_a_of_type_JavaUtilHashMap;
  public boolean a;
  public boolean b;
  private byte[] b;
  private boolean c;
  private boolean d;
  
  static
  {
    jdField_a_of_type_ArrayOfByte = new byte[0];
    jdField_a_of_type_Float = 1.0F;
  }
  
  private CustomizeStrategyFactory()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_ArrayOfByte = new byte[0];
    c();
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap(8);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    jdField_a_of_type_Float = BaseApplicationImpl.getContext().getResources().getDisplayMetrics().density;
  }
  
  private ackp a(int paramInt, QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CustomizeStrategyFactory", 2, "getCustomizeStrategy type =" + paramInt);
    }
    ackp localackp = (ackp)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localackp != null) {
      return localackp;
    }
    if (2 == paramInt) {
      paramQQAppInterface = new ajld(paramQQAppInterface);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidUtilSparseArray.append(paramInt, paramQQAppInterface);
      return paramQQAppInterface;
      if (1 == paramInt) {
        paramQQAppInterface = new ackz(paramQQAppInterface);
      } else if (4 == paramInt) {
        paramQQAppInterface = new ackx(paramQQAppInterface);
      } else if (5 == paramInt) {
        paramQQAppInterface = new ackt(paramQQAppInterface);
      } else if (6 == paramInt) {
        paramQQAppInterface = new aclb(paramQQAppInterface);
      } else if (7 == paramInt) {
        paramQQAppInterface = new ackr(paramQQAppInterface);
      } else {
        paramQQAppInterface = null;
      }
    }
  }
  
  public static CustomizeStrategyFactory a()
  {
    if (jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory == null) {
        jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory = new CustomizeStrategyFactory();
      }
      return jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory;
    }
    finally {}
  }
  
  private void b(CustomizeStrategyFactory.RedPacketInfo paramRedPacketInfo)
  {
    if ((paramRedPacketInfo == null) || (!paramRedPacketInfo.jdField_b_of_type_Boolean) || (paramRedPacketInfo.jdField_a_of_type_Acko == null) || (TextUtils.isEmpty(paramRedPacketInfo.jdField_a_of_type_Acko.jdField_a_of_type_JavaLangString))) {
      return;
    }
    paramRedPacketInfo = new CustomizeStrategyFactory.3(this, paramRedPacketInfo);
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      ThreadManager.post(paramRedPacketInfo, 5, null, true);
      return;
    }
    paramRedPacketInfo.run();
  }
  
  private void c()
  {
    ThreadManager.post(new CustomizeStrategyFactory.2(this), 5, null, true);
  }
  
  public CustomizeStrategyFactory.RedPacketInfo a(QQAppInterface paramQQAppInterface, CustomizeStrategyFactory.RedPacketInfo paramRedPacketInfo, ackq paramackq)
  {
    if ((paramRedPacketInfo == null) || (paramackq == null))
    {
      paramQQAppInterface = null;
      return paramQQAppInterface;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramRedPacketInfo.type);
    if (paramRedPacketInfo.type == 5) {
      ((StringBuilder)localObject).append("_").append(paramRedPacketInfo.skinType).append("_").append(paramRedPacketInfo.skinId).append("_").append(paramRedPacketInfo.bigAnimId);
    }
    for (;;)
    {
      paramRedPacketInfo.jdField_b_of_type_JavaLangString = ((StringBuilder)localObject).toString();
      localObject = a(paramRedPacketInfo.type, paramQQAppInterface);
      paramQQAppInterface = paramRedPacketInfo;
      if (localObject == null) {
        break;
      }
      paramQQAppInterface = (aeav)this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache.get(paramRedPacketInfo.jdField_b_of_type_JavaLangString);
      if (paramQQAppInterface != null) {
        break label195;
      }
      this.jdField_a_of_type_JavaUtilHashMap.put(paramRedPacketInfo, paramackq);
      ((ackp)localObject).a(paramRedPacketInfo);
      return paramRedPacketInfo;
      ((StringBuilder)localObject).append("_").append(paramRedPacketInfo.templateId);
      if ((paramRedPacketInfo.type == 2) && (!TextUtils.isEmpty(paramRedPacketInfo.jdField_a_of_type_JavaLangString))) {
        ((StringBuilder)localObject).append("_").append(paramRedPacketInfo.jdField_a_of_type_JavaLangString);
      }
    }
    label195:
    ((ackp)localObject).a(paramRedPacketInfo, paramQQAppInterface);
    return paramRedPacketInfo;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilHashMap != null) {
      this.jdField_a_of_type_JavaUtilHashMap.clear();
    }
  }
  
  public void a(CustomizeStrategyFactory.RedPacketInfo paramRedPacketInfo)
  {
    if ((this.jdField_a_of_type_AndroidOsHandler != null) && (paramRedPacketInfo != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("CustomizeStrategyFactory", 2, "notifyCustomizeFinish-type:" + paramRedPacketInfo.type + " isAnimation:" + paramRedPacketInfo.jdField_b_of_type_Boolean);
      }
      if ((paramRedPacketInfo.type == 2) && (paramRedPacketInfo.jdField_b_of_type_Boolean) && (!paramRedPacketInfo.c)) {
        b(paramRedPacketInfo);
      }
    }
    else
    {
      return;
    }
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage();
    localMessage.what = 1;
    localMessage.obj = paramRedPacketInfo;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  public void a(String paramString1, String paramString2, agmo paramagmo)
  {
    if (this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache == null) {
      return;
    }
    paramString1 = this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache.snapshot().entrySet().iterator();
    while (paramString1.hasNext())
    {
      paramString2 = (aeav)((Map.Entry)paramString1.next()).getValue();
      if (((paramString2 instanceof aeaz)) || ((paramString2 instanceof aeaw))) {
        paramString1.remove();
      }
    }
    RedPacketManager.getInstance().onUpdate(1);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    if (QLog.isColorLevel()) {
      QLog.d("CustomizeStrategyFactory", 2, "setInAIO isInAIO=" + paramBoolean + ",refreshListView=" + this.c);
    }
    if (paramBoolean) {
      this.jdField_a_of_type_Boolean = false;
    }
    synchronized (jdField_a_of_type_ArrayOfByte)
    {
      jdField_a_of_type_ArrayOfByte.notifyAll();
      if (QLog.isColorLevel()) {
        QLog.d("CustomizeStrategyFactory", 2, "setLockFlag lockFlag" + this.jdField_a_of_type_Boolean);
      }
      if (this.c)
      {
        this.c = false;
        ??? = BaseApplicationImpl.sApplication.getRuntime();
        if ((??? instanceof QQAppInterface))
        {
          ??? = ((QQAppInterface)???).getHandler(ChatActivity.class);
          if (??? != null) {
            ((MqqHandler)???).sendEmptyMessage(12);
          }
        }
      }
      return;
    }
  }
  
  public boolean a()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public void b()
  {
    a();
    if (this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache != null) {
      this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache.evictAll();
    }
    if (this.jdField_a_of_type_AndroidUtilSparseArray != null)
    {
      int j = this.jdField_a_of_type_AndroidUtilSparseArray.size();
      int i = 0;
      while (i < j)
      {
        ((ackp)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(i)).a();
        i += 1;
      }
      this.jdField_a_of_type_AndroidUtilSparseArray.clear();
    }
    synchronized (this.jdField_b_of_type_ArrayOfByte)
    {
      if (this.jdField_a_of_type_Agmq != null) {
        this.jdField_a_of_type_Agmq.d("redPack", this);
      }
      this.d = true;
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_AndroidOsHandler = null;
      jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory = null;
      this.jdField_b_of_type_Boolean = false;
      this.c = false;
      return;
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CustomizeStrategyFactory", 2, "setRefreshListView refreshListView=" + paramBoolean);
    }
    this.c = paramBoolean;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    CustomizeStrategyFactory.RedPacketInfo localRedPacketInfo;
    ackq localackq;
    if (paramMessage.what == 1)
    {
      localRedPacketInfo = (CustomizeStrategyFactory.RedPacketInfo)paramMessage.obj;
      localackq = (ackq)this.jdField_a_of_type_JavaUtilHashMap.remove(localRedPacketInfo);
      if (QLog.isColorLevel()) {
        QLog.d("CustomizeStrategyFactory", 2, "handleMessage info type=" + localRedPacketInfo.type + "| listener=" + localackq + "| templateId=" + localRedPacketInfo.templateId + "| content=" + localRedPacketInfo.jdField_a_of_type_JavaLangString + "| info=" + localRedPacketInfo + "|" + System.currentTimeMillis());
      }
      if (!this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache.containsKey(localRedPacketInfo.jdField_b_of_type_JavaLangString))
      {
        paramMessage = null;
        if (localRedPacketInfo.type != 2) {
          break label203;
        }
        paramMessage = new aebb(localRedPacketInfo.jdField_b_of_type_JavaLangString);
        paramMessage.a(localRedPacketInfo);
      }
    }
    for (;;)
    {
      if ((paramMessage != null) && (paramMessage.a())) {
        this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache.put(localRedPacketInfo.jdField_b_of_type_JavaLangString, paramMessage);
      }
      if (localackq != null) {
        localackq.onSucc(localRedPacketInfo.type, localRedPacketInfo);
      }
      return false;
      label203:
      if ((localRedPacketInfo.type == 1) || (localRedPacketInfo.type == 4))
      {
        paramMessage = new aeba(localRedPacketInfo.jdField_b_of_type_JavaLangString);
        paramMessage.a(localRedPacketInfo);
      }
      else if (localRedPacketInfo.type == 5)
      {
        if (localRedPacketInfo.skinType == 1)
        {
          paramMessage = new aeaz(localRedPacketInfo.jdField_b_of_type_JavaLangString);
          paramMessage.a(localRedPacketInfo);
          localRedPacketInfo.icon = paramMessage.a(localRedPacketInfo);
        }
        else if ((localRedPacketInfo.skinType == 2) || (localRedPacketInfo.skinType == 4))
        {
          paramMessage = new aeay(localRedPacketInfo.jdField_b_of_type_JavaLangString);
          paramMessage.a(localRedPacketInfo);
        }
        else if (localRedPacketInfo.skinType == 3)
        {
          paramMessage = new aeaw(localRedPacketInfo.jdField_b_of_type_JavaLangString);
          paramMessage.a(localRedPacketInfo);
        }
      }
      else if (localRedPacketInfo.type == 6)
      {
        paramMessage = new aebc(localRedPacketInfo.jdField_b_of_type_JavaLangString);
        paramMessage.a(localRedPacketInfo);
      }
      else if (localRedPacketInfo.type == 7)
      {
        paramMessage = new aeax(localRedPacketInfo.jdField_b_of_type_JavaLangString);
        paramMessage.a(localRedPacketInfo);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory
 * JD-Core Version:    0.7.0.1
 */