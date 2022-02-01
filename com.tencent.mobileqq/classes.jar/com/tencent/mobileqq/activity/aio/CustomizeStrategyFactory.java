package com.tencent.mobileqq.activity.aio;

import aghg;
import aghh;
import aghi;
import aghj;
import aghk;
import aghm;
import aghq;
import aghs;
import aghu;
import aigs;
import aigt;
import aigu;
import aigv;
import aigw;
import aigx;
import aigy;
import aigz;
import alam;
import alao;
import alas;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import aoar;
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
  implements alas, Handler.Callback
{
  public static float a;
  private static volatile CustomizeStrategyFactory jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory;
  public static byte[] a;
  public alao a;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private SparseArray<aghi> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray(5);
  private QQLruCache<String, aigs> jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache = new aghg(this, 1020, 30, 10000);
  private HashMap<Object, aghj> jdField_a_of_type_JavaUtilHashMap;
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
  
  private aghi a(int paramInt, QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CustomizeStrategyFactory", 2, "getCustomizeStrategy type =" + paramInt);
    }
    aghi localaghi = (aghi)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localaghi != null) {
      return localaghi;
    }
    if (2 == paramInt) {
      paramQQAppInterface = new aoar(paramQQAppInterface);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidUtilSparseArray.append(paramInt, paramQQAppInterface);
      return paramQQAppInterface;
      if (1 == paramInt) {
        paramQQAppInterface = new aghs(paramQQAppInterface);
      } else if (4 == paramInt) {
        paramQQAppInterface = new aghq(paramQQAppInterface);
      } else if (5 == paramInt) {
        paramQQAppInterface = new aghm(paramQQAppInterface);
      } else if (6 == paramInt) {
        paramQQAppInterface = new aghu(paramQQAppInterface);
      } else if (7 == paramInt) {
        paramQQAppInterface = new aghk(paramQQAppInterface);
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
    if ((paramRedPacketInfo == null) || (!paramRedPacketInfo.jdField_b_of_type_Boolean) || (paramRedPacketInfo.jdField_a_of_type_Aghh == null) || (TextUtils.isEmpty(paramRedPacketInfo.jdField_a_of_type_Aghh.jdField_a_of_type_JavaLangString))) {
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
  
  public CustomizeStrategyFactory.RedPacketInfo a(QQAppInterface paramQQAppInterface, CustomizeStrategyFactory.RedPacketInfo paramRedPacketInfo, aghj paramaghj)
  {
    if ((paramRedPacketInfo == null) || (paramaghj == null))
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
      paramQQAppInterface = (aigs)this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache.get(paramRedPacketInfo.jdField_b_of_type_JavaLangString);
      if (paramQQAppInterface != null) {
        break label195;
      }
      this.jdField_a_of_type_JavaUtilHashMap.put(paramRedPacketInfo, paramaghj);
      ((aghi)localObject).a(paramRedPacketInfo);
      return paramRedPacketInfo;
      ((StringBuilder)localObject).append("_").append(paramRedPacketInfo.templateId);
      if ((paramRedPacketInfo.type == 2) && (!TextUtils.isEmpty(paramRedPacketInfo.jdField_a_of_type_JavaLangString))) {
        ((StringBuilder)localObject).append("_").append(paramRedPacketInfo.jdField_a_of_type_JavaLangString);
      }
    }
    label195:
    ((aghi)localObject).a(paramRedPacketInfo, paramQQAppInterface);
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
  
  public void a(String paramString1, String paramString2, alam paramalam)
  {
    if (this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache == null) {
      return;
    }
    paramString1 = this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache.snapshot().entrySet().iterator();
    while (paramString1.hasNext())
    {
      paramString2 = (aigs)((Map.Entry)paramString1.next()).getValue();
      if (((paramString2 instanceof aigw)) || ((paramString2 instanceof aigt))) {
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
        ((aghi)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(i)).a();
        i += 1;
      }
      this.jdField_a_of_type_AndroidUtilSparseArray.clear();
    }
    synchronized (this.jdField_b_of_type_ArrayOfByte)
    {
      if (this.jdField_a_of_type_Alao != null) {
        this.jdField_a_of_type_Alao.d("redPack", this);
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
    aghj localaghj;
    if (paramMessage.what == 1)
    {
      localRedPacketInfo = (CustomizeStrategyFactory.RedPacketInfo)paramMessage.obj;
      localaghj = (aghj)this.jdField_a_of_type_JavaUtilHashMap.remove(localRedPacketInfo);
      if (QLog.isColorLevel()) {
        QLog.d("CustomizeStrategyFactory", 2, "handleMessage info type=" + localRedPacketInfo.type + "| listener=" + localaghj + "| templateId=" + localRedPacketInfo.templateId + "| content=" + localRedPacketInfo.jdField_a_of_type_JavaLangString + "| info=" + localRedPacketInfo + "|" + System.currentTimeMillis());
      }
      if (!this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache.containsKey(localRedPacketInfo.jdField_b_of_type_JavaLangString))
      {
        paramMessage = null;
        if (localRedPacketInfo.type != 2) {
          break label203;
        }
        paramMessage = new aigy(localRedPacketInfo.jdField_b_of_type_JavaLangString);
        paramMessage.a(localRedPacketInfo);
      }
    }
    for (;;)
    {
      if ((paramMessage != null) && (paramMessage.a())) {
        this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache.put(localRedPacketInfo.jdField_b_of_type_JavaLangString, paramMessage);
      }
      if (localaghj != null) {
        localaghj.onSucc(localRedPacketInfo.type, localRedPacketInfo);
      }
      return false;
      label203:
      if ((localRedPacketInfo.type == 1) || (localRedPacketInfo.type == 4))
      {
        paramMessage = new aigx(localRedPacketInfo.jdField_b_of_type_JavaLangString);
        paramMessage.a(localRedPacketInfo);
      }
      else if (localRedPacketInfo.type == 5)
      {
        if (localRedPacketInfo.skinType == 1)
        {
          paramMessage = new aigw(localRedPacketInfo.jdField_b_of_type_JavaLangString);
          paramMessage.a(localRedPacketInfo);
          localRedPacketInfo.icon = paramMessage.a(localRedPacketInfo);
        }
        else if ((localRedPacketInfo.skinType == 2) || (localRedPacketInfo.skinType == 4))
        {
          paramMessage = new aigv(localRedPacketInfo.jdField_b_of_type_JavaLangString);
          paramMessage.a(localRedPacketInfo);
        }
        else if (localRedPacketInfo.skinType == 3)
        {
          paramMessage = new aigt(localRedPacketInfo.jdField_b_of_type_JavaLangString);
          paramMessage.a(localRedPacketInfo);
        }
      }
      else if (localRedPacketInfo.type == 6)
      {
        paramMessage = new aigz(localRedPacketInfo.jdField_b_of_type_JavaLangString);
        paramMessage.a(localRedPacketInfo);
      }
      else if (localRedPacketInfo.type == 7)
      {
        paramMessage = new aigu(localRedPacketInfo.jdField_b_of_type_JavaLangString);
        paramMessage.a(localRedPacketInfo);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory
 * JD-Core Version:    0.7.0.1
 */