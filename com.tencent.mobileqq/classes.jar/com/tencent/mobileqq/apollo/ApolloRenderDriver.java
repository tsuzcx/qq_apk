package com.tencent.mobileqq.apollo;

import airz;
import aitl;
import aivd;
import ajkk;
import ajkl;
import ajks;
import ajyc;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import bfnk;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ApolloRenderDriver
  implements Handler.Callback
{
  int jdField_a_of_type_Int = 20;
  aivd jdField_a_of_type_Aivd;
  bfnk jdField_a_of_type_Bfnk;
  public ApolloEngine a;
  private ApolloRenderDriver.RenderRunnable jdField_a_of_type_ComTencentMobileqqApolloApolloRenderDriver$RenderRunnable;
  private WeakReference<aitl> jdField_a_of_type_JavaLangRefWeakReference;
  public AtomicBoolean a;
  public AtomicInteger a;
  ReentrantLock jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock;
  public int b;
  private AtomicBoolean b;
  
  public ApolloRenderDriver(aivd paramaivd, ApolloEngine paramApolloEngine)
  {
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(1);
    if (QLog.isColorLevel()) {
      QLog.d("ApolloRenderDriver", 2, "[ApolloRenderDriver] constructor.");
    }
    if (paramApolloEngine == null) {
      throw new NullPointerException();
    }
    this.jdField_a_of_type_Aivd = paramaivd;
    this.jdField_a_of_type_ComTencentMobileqqApolloApolloEngine = paramApolloEngine;
    this.jdField_a_of_type_Bfnk = new bfnk(ThreadManager.getSubThreadLooper(), this);
    this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock = ajkl.a().a();
    this.jdField_a_of_type_ComTencentMobileqqApolloApolloRenderDriver$RenderRunnable = new ApolloRenderDriver.RenderRunnable(this);
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
  }
  
  public int a(int paramInt1, int paramInt2, String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloRenderDriver", 2, "[onSetActions], actionId:" + paramInt1);
    }
    if ((paramArrayOfString1 != null) && (paramArrayOfString1.length != 2)) {
      return 1;
    }
    a(new ApolloRenderDriver.1(this, paramInt1, paramInt2, paramArrayOfString1, paramArrayOfString2));
    return 0;
  }
  
  public int a(int paramInt1, String paramString, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloRenderDriver", 2, new Object[] { "[onLoadRole] apolloId=", paramString, ", roleType=", Integer.valueOf(paramInt1), ", roleId:" + paramInt2 });
    }
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = ApolloUtil.f(paramInt1);
    }
    paramString = ajkk.a(str, paramInt2, paramFloat1, paramFloat2, paramFloat3);
    if (TextUtils.isEmpty(paramString)) {
      return 1;
    }
    a(new ApolloRenderDriver.RenderThreadRunnable(this, paramString, this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock, this.jdField_a_of_type_ComTencentMobileqqApolloApolloEngine));
    return 0;
  }
  
  public int a(int paramInt1, String paramString1, int paramInt2, int paramInt3, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloRenderDriver", 2, new Object[] { "[onExecAction] apolloId=", paramString1, ", actionId=", Integer.valueOf(paramInt2) });
    }
    String str = paramString1;
    if (TextUtils.isEmpty(paramString1)) {
      str = ApolloUtil.f(paramInt1);
    }
    paramString1 = ajkk.a(str, paramInt2, paramInt3, paramString2, paramString3);
    if (paramString1 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloRenderDriver", 2, "errInfo->luaParam is null.");
      }
      return 1;
    }
    a(new ApolloRenderDriver.4(this, paramString1));
    return 0;
  }
  
  public int a(int paramInt, String paramString, int[] paramArrayOfInt, ajks paramajks)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloRenderDriver", 2, "[onChangeDress], roleType:" + paramInt);
    }
    if (paramArrayOfInt == null) {}
    do
    {
      return 1;
      String str = paramString;
      if (TextUtils.isEmpty(paramString)) {
        str = ApolloUtil.f(paramInt);
      }
      paramString = ajkk.a(str, paramArrayOfInt);
    } while (paramString == null);
    a(new ApolloRenderDriver.5(this, paramString, paramajks));
    return 0;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloRenderDriver", 2, "[startLoop]. mIsLoopStart:" + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
    }
    if ((this.jdField_a_of_type_Bfnk != null) && (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()))
    {
      this.jdField_a_of_type_Bfnk.removeMessages(15);
      if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
      {
        QLog.d("ApolloRenderDriver", 2, "[startLoop]. ticker Loop: gameId=" + this.jdField_b_of_type_Int + " view=" + this.jdField_a_of_type_Aivd);
        a(new ApolloRenderDriver.2(this));
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      }
    }
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloRenderDriver", 2, "[onRemoveBubble], roleType" + paramInt + ",bubbleName:" + paramString2);
    }
    String str = paramString1;
    if (TextUtils.isEmpty(paramString1)) {
      str = ApolloUtil.f(paramInt);
    }
    a(new ApolloRenderDriver.RenderThreadRunnable(this, ajkk.a(str, paramString2), this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock, this.jdField_a_of_type_ComTencentMobileqqApolloApolloEngine));
  }
  
  public void a(long paramLong)
  {
    if (this.jdField_a_of_type_Bfnk != null)
    {
      this.jdField_a_of_type_Bfnk.removeMessages(15);
      this.jdField_a_of_type_Bfnk.sendEmptyMessageDelayed(15, paramLong);
    }
  }
  
  public void a(aitl paramaitl)
  {
    if (paramaitl == null) {
      return;
    }
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramaitl);
  }
  
  public void a(IApolloRunnableTask paramIApolloRunnableTask)
  {
    if ((paramIApolloRunnableTask == null) || (this.jdField_a_of_type_Aivd == null)) {}
    do
    {
      return;
      if ((this.jdField_a_of_type_Aivd instanceof ApolloSurfaceView))
      {
        ((ApolloSurfaceView)this.jdField_a_of_type_Aivd).runRenderTask(paramIApolloRunnableTask);
        return;
      }
    } while (!(this.jdField_a_of_type_Aivd instanceof ApolloTextureView));
    ((ApolloTextureView)this.jdField_a_of_type_Aivd).queueEvent(paramIApolloRunnableTask);
  }
  
  public void a(String paramString)
  {
    a(new ApolloRenderDriver.RenderThreadRunnable(this, String.format("if(%s){%s.removeFromParent();%s.dispose();}", new Object[] { paramString, paramString, paramString }), this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock, this.jdField_a_of_type_ComTencentMobileqqApolloApolloEngine));
  }
  
  public int b(int paramInt1, String paramString1, int paramInt2, int paramInt3, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloRenderDriver", 2, new Object[] { "[onAddBubble] bubbleType=", Integer.valueOf(paramInt1), ", apolloId=", paramString1, ", roleType=", Integer.valueOf(paramInt2), ", text=", paramString2, ", roleId=", Integer.valueOf(paramInt3), ", uin=", paramString3 });
    }
    if (TextUtils.isEmpty(paramString2)) {
      return 1;
    }
    paramString2 = paramString2.replace("\\", "").replace("'", "");
    if (TextUtils.isEmpty(paramString2)) {
      return 1;
    }
    Object localObject1 = Pattern.compile("\t|\r|\n").matcher(paramString2);
    if (localObject1 != null) {
      paramString2 = ((Matcher)localObject1).replaceAll("");
    }
    for (;;)
    {
      int i = paramString2.length();
      localObject1 = null;
      Object localObject2 = BaseApplicationImpl.getApplication().getRuntime();
      if ((localObject2 instanceof QQAppInterface)) {
        localObject1 = (QQAppInterface)localObject2;
      }
      if ((1 == paramInt1) && (localObject1 != null))
      {
        localObject2 = (airz)((QQAppInterface)localObject1).getManager(153);
        if (paramString3.equals(((QQAppInterface)localObject1).getCurrentAccountUin()))
        {
          paramString2 = ajyc.a(2131700507);
          if ((localObject2 != null) && (((airz)localObject2).a(paramString3))) {
            if ((1 == paramInt2) && ((ApolloUtil.e(0, 28)) || (ApolloUtil.e(paramInt3, 28)))) {
              paramInt1 = 28;
            }
          }
        }
      }
      for (;;)
      {
        if ((!ApolloUtil.e(paramInt3, paramInt1)) && (!ApolloUtil.e(0, paramInt1)))
        {
          return 2;
          paramString3 = paramString2;
          if (2 == paramInt2) {
            if (!ApolloUtil.e(0, 27))
            {
              paramString3 = paramString2;
              if (!ApolloUtil.e(paramInt3, 27)) {}
            }
            else
            {
              paramInt1 = 27;
              continue;
              paramInt1 = 25;
              continue;
              if ((localObject2 != null) && (((airz)localObject2).a(paramString3)))
              {
                if ((1 == paramInt2) && ((ApolloUtil.e(0, 30)) || (ApolloUtil.e(paramInt3, 30))))
                {
                  paramInt1 = 30;
                  continue;
                }
                paramString3 = paramString2;
                if (2 == paramInt2) {
                  if (!ApolloUtil.e(0, 29))
                  {
                    paramString3 = paramString2;
                    if (!ApolloUtil.e(paramInt3, 29)) {}
                  }
                  else
                  {
                    paramInt1 = 29;
                  }
                }
              }
              else
              {
                paramInt1 = 26;
                continue;
                if ((paramInt1 == 0) || (8 == paramInt1))
                {
                  paramInt1 = ApolloUtil.b(208.0F, paramString2, 1);
                  continue;
                }
                if (2 == paramInt1)
                {
                  paramString3 = paramString2;
                  if (i > 8) {
                    paramString3 = paramString2.substring(0, 7) + "…";
                  }
                  paramInt1 = 16;
                  paramString2 = paramString3;
                  continue;
                }
                if (3 == paramInt1)
                {
                  paramInt1 = 32;
                  continue;
                }
                if (4 == paramInt1)
                {
                  paramInt1 = ApolloUtil.a(157.0F, paramString2);
                  continue;
                }
                if (5 == paramInt1)
                {
                  paramInt1 = 40;
                  continue;
                }
                if (6 == paramInt1)
                {
                  paramInt1 = 33;
                  continue;
                }
                if (7 == paramInt1)
                {
                  paramInt1 = 32;
                  continue;
                }
                if (QLog.isColorLevel()) {
                  QLog.d("ApolloRenderDriver", 2, "Other bubble type, NOT Handle.");
                }
                return 1;
              }
            }
          }
        }
        else
        {
          paramString3 = paramString1;
          if (TextUtils.isEmpty(paramString1)) {
            paramString3 = ApolloUtil.f(paramInt2);
          }
          paramString1 = ajkk.a(paramString3, paramInt1, paramInt3, paramString2);
          if (TextUtils.isEmpty(paramString1))
          {
            if (QLog.isColorLevel()) {
              QLog.d("ApolloRenderDriver", 2, "errInfo->luaParam is NULL.");
            }
            return 1;
          }
          a(new ApolloRenderDriver.RenderThreadRunnable(this, paramString1, this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock, this.jdField_a_of_type_ComTencentMobileqqApolloApolloEngine));
          return 0;
        }
        paramInt1 = 0;
        paramString2 = paramString3;
      }
    }
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloRenderDriver", 2, "[stopLoop].");
    }
    if ((this.jdField_a_of_type_Bfnk != null) && (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()))
    {
      this.jdField_a_of_type_Bfnk.removeMessages(15);
      a(new ApolloRenderDriver.3(this));
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    }
  }
  
  public void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloRenderDriver", 2, "[onEnterGame], luaFilePath:" + paramString);
    }
    a(new ApolloRenderDriver.9(this, paramString));
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloRenderDriver", 2, "[onDestroy]");
    }
    b();
    if (this.jdField_a_of_type_Bfnk != null)
    {
      this.jdField_a_of_type_Bfnk.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_Bfnk = null;
      if (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean != null) {
        this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
      }
    }
  }
  
  public void c(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloRenderDriver", 2, "[exejsOnEngine jsStr]");
      }
      a(new ApolloRenderDriver.11(this, paramString));
    }
  }
  
  public void d()
  {
    a(new ApolloRenderDriver.RenderThreadRunnable(this, "dispose();", this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock, this.jdField_a_of_type_ComTencentMobileqqApolloApolloEngine));
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 15) {
      b();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloRenderDriver
 * JD-Core Version:    0.7.0.1
 */