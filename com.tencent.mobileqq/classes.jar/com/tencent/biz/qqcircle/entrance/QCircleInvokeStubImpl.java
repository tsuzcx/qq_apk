package com.tencent.biz.qqcircle.entrance;

import android.util.SparseArray;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.proxy.QCircleInvokeModule;
import cooperation.qqcircle.proxy.QCircleInvokeParam;
import cooperation.qqcircle.proxy.QCircleInvokeStub;

public class QCircleInvokeStubImpl
  implements QCircleInvokeStub
{
  private static SparseArray<QCircleInvokeModule> a = new SparseArray();
  
  static
  {
    a.append(1, new QCircleInvokeInitImpl());
    a.append(2, new QCircleInvokeReleaseImpl());
  }
  
  private void a(int paramInt1, int paramInt2, Object paramObject, Object[] paramArrayOfObject) {}
  
  private void a(int paramInt1, int paramInt2, Object[] paramArrayOfObject)
  {
    Object localObject = a;
    if (localObject != null)
    {
      localObject = (QCircleInvokeModule)((SparseArray)localObject).get(paramInt1);
      if (localObject != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("handleInvoke action:");
        localStringBuilder.append(paramInt1);
        localStringBuilder.append(" method:");
        localStringBuilder.append(paramInt2);
        QLog.d("QCircleInvokeStubImpl", 1, localStringBuilder.toString());
        ((QCircleInvokeModule)localObject).invoke(paramInt1, paramInt2, paramArrayOfObject);
      }
    }
    else
    {
      QLog.d("QCircleInvokeStubImpl", 1, "handleInvoke error, sInvokeModuleImpl is null");
    }
  }
  
  private Object b(int paramInt1, int paramInt2, Object[] paramArrayOfObject)
  {
    return null;
  }
  
  public void invoke(int paramInt, Object... paramVarArgs)
  {
    a(QCircleInvokeParam.getAction(paramInt), QCircleInvokeParam.getMethod(paramInt), paramVarArgs);
  }
  
  public void invokeWithCallBack(int paramInt, Object paramObject, Object... paramVarArgs)
  {
    a(QCircleInvokeParam.getAction(paramInt), QCircleInvokeParam.getMethod(paramInt), paramObject, paramVarArgs);
  }
  
  public Object invokeWithReturnValue(int paramInt, Object... paramVarArgs)
  {
    return b(QCircleInvokeParam.getAction(paramInt), QCircleInvokeParam.getMethod(paramInt), paramVarArgs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.entrance.QCircleInvokeStubImpl
 * JD-Core Version:    0.7.0.1
 */