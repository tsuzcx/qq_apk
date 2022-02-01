package com.tencent.mobileqq.apollo;

import android.text.TextUtils;
import com.tencent.mobileqq.apollo.api.uitls.impl.ApolloUtilImpl;
import com.tencent.mobileqq.apollo.task.OnDressDoneListener;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.concurrent.atomic.AtomicInteger;

public class ApolloRenderInterfaceImpl
  implements IRenderCommInterface, ISetActionInterface
{
  public static String a;
  private ApolloRender jdField_a_of_type_ComTencentMobileqqApolloApolloRender;
  private ApolloRenderDriver jdField_a_of_type_ComTencentMobileqqApolloApolloRenderDriver;
  
  static
  {
    jdField_a_of_type_JavaLangString = "ApolloRenderInterfaceImpl";
  }
  
  public ApolloRenderInterfaceImpl(ApolloRenderDriver paramApolloRenderDriver, ApolloRender paramApolloRender)
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloApolloRenderDriver = paramApolloRenderDriver;
    this.jdField_a_of_type_ComTencentMobileqqApolloApolloRender = paramApolloRender;
  }
  
  public int a(int paramInt1, int paramInt2, String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "[onSetActions], actionId:" + paramInt1);
    }
    if ((paramArrayOfString1 == null) || (paramArrayOfString1.length != 2) || (this.jdField_a_of_type_ComTencentMobileqqApolloApolloRenderDriver == null)) {
      i = 1;
    }
    do
    {
      return i;
      File localFile = new File(ApolloRender.getRscStaticPath(paramArrayOfString1[0], "json"));
      if (!localFile.exists())
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "errInfo->rsc NOT exist. rscFile:" + localFile);
        }
        return 2;
      }
      if ((paramArrayOfString2 != null) && (paramArrayOfString2.length == 2))
      {
        localFile = new File(ApolloRender.getRscStaticPath(paramArrayOfString2[0], "json"));
        if (!localFile.exists())
        {
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "errInfo->rsc NOT exist. rscFile:" + localFile);
          }
          return 2;
        }
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqApolloApolloRenderDriver == null);
    return this.jdField_a_of_type_ComTencentMobileqqApolloApolloRenderDriver.a(paramInt1, paramInt2, paramArrayOfString1, paramArrayOfString2);
  }
  
  public int a(int paramInt1, String paramString, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, new Object[] { "[onLoadRole] roleType=", Integer.valueOf(paramInt1), ", apolloId=", paramString, ", roleId=", Integer.valueOf(paramInt2), ", roleScale=", Float.valueOf(paramFloat1), ", xPos=", Float.valueOf(paramFloat2), ", yPos=", Float.valueOf(paramFloat3) });
    }
    if (!ApolloUtilImpl.checkRoleRes(paramInt2))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "errInfo->role rsc NOT exist.");
      }
      i = 2;
    }
    while (this.jdField_a_of_type_ComTencentMobileqqApolloApolloRenderDriver == null) {
      return i;
    }
    paramInt1 = this.jdField_a_of_type_ComTencentMobileqqApolloApolloRenderDriver.a(paramInt1, paramString, paramInt2, paramFloat1, paramFloat2, paramFloat3);
    this.jdField_a_of_type_ComTencentMobileqqApolloApolloRenderDriver.a();
    return paramInt1;
  }
  
  public int a(int paramInt1, String paramString1, int paramInt2, int paramInt3, String paramString2, String paramString3)
  {
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, new Object[] { "[onExecAction] apolloId=", paramString1, ", actionId=", Integer.valueOf(paramInt2), ", roleType=", Integer.valueOf(paramInt1), ", actionId=", Integer.valueOf(paramInt2), ", taskId=", Integer.valueOf(paramInt3), ", actionRscName=", paramString2, ", animName=", paramString3 });
    }
    if ((TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3)) || (this.jdField_a_of_type_ComTencentMobileqqApolloApolloRenderDriver == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "errInfo->null param.");
      }
      i = 1;
    }
    do
    {
      do
      {
        do
        {
          return i;
          File localFile = new File(ApolloRender.getRscStaticPath(paramString2, "json"));
          if (!localFile.exists())
          {
            if (QLog.isColorLevel()) {
              QLog.d(jdField_a_of_type_JavaLangString, 2, "errInfo->rsc NOT exist. rscFile:" + localFile);
            }
            return 2;
          }
        } while (this.jdField_a_of_type_ComTencentMobileqqApolloApolloRenderDriver == null);
        if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloRender != null) {
          this.jdField_a_of_type_ComTencentMobileqqApolloApolloRender.mIsFrameMode = false;
        }
        this.jdField_a_of_type_ComTencentMobileqqApolloApolloRenderDriver.a();
        paramInt1 = this.jdField_a_of_type_ComTencentMobileqqApolloApolloRenderDriver.a(paramInt1, paramString1, paramInt2, paramInt3, paramString2, paramString3);
        i = paramInt1;
      } while (paramInt1 != 0);
      i = paramInt1;
    } while (paramInt3 >= 1000000);
    this.jdField_a_of_type_ComTencentMobileqqApolloApolloRenderDriver.a.set(8);
    return paramInt1;
  }
  
  public int a(int paramInt, String paramString, int[] paramArrayOfInt, OnDressDoneListener paramOnDressDoneListener)
  {
    int j = 0;
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, new Object[] { "[onChangeDress] apolloId=", paramString, ", roleType=", Integer.valueOf(paramInt), ", dressId=", paramArrayOfInt, ", callback=", paramOnDressDoneListener });
    }
    int i;
    if (paramArrayOfInt == null) {
      i = 1;
    }
    do
    {
      return i;
      i = 0;
      while (i < paramArrayOfInt.length)
      {
        if (!ApolloUtilImpl.checkDressRes(paramArrayOfInt[i]))
        {
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "errInfo->dress rsc NOT exist, id:" + paramArrayOfInt[i]);
          }
          return 2;
        }
        i += 1;
      }
      i = j;
    } while (this.jdField_a_of_type_ComTencentMobileqqApolloApolloRenderDriver == null);
    paramInt = this.jdField_a_of_type_ComTencentMobileqqApolloApolloRenderDriver.a(paramInt, paramString, paramArrayOfInt, paramOnDressDoneListener);
    this.jdField_a_of_type_ComTencentMobileqqApolloApolloRenderDriver.a();
    return paramInt;
  }
  
  public ApolloRender a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqApolloApolloRender;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloRenderDriver != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloRenderDriver.d();
    }
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloRenderDriver != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloRenderDriver.a(paramInt, paramString1, paramString2);
    }
  }
  
  public void a(long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloRenderDriver != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloRenderDriver.a(paramLong);
    }
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, new Object[] { "[onExecDispose] apolloId=", paramString });
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloApolloRenderDriver != null) && (!TextUtils.isEmpty(paramString))) {
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloRenderDriver.a(paramString);
    }
  }
  
  public int b(int paramInt1, String paramString1, int paramInt2, int paramInt3, String paramString2, String paramString3)
  {
    int i = 1;
    if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloRenderDriver != null) {
      i = this.jdField_a_of_type_ComTencentMobileqqApolloApolloRenderDriver.b(paramInt1, paramString1, paramInt2, paramInt3, paramString2, paramString3);
    }
    return i;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloRenderDriver != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloRenderDriver.a();
    }
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "[onDestroy]");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloRenderDriver != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloRenderDriver.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloRenderInterfaceImpl
 * JD-Core Version:    0.7.0.1
 */