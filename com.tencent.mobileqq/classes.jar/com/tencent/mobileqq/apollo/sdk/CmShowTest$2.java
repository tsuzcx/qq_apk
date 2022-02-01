package com.tencent.mobileqq.apollo.sdk;

import android.os.Bundle;
import com.tencent.mobileqq.apollo.api.sdk.IRenderViewListener;
import com.tencent.qphone.base.util.QLog;

final class CmShowTest$2
  implements IRenderViewListener
{
  CmShowTest$2(CmShowRenderView paramCmShowRenderView) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    QLog.i("CmShowTest", 1, "onViewReady w:" + paramInt1);
    this.a.a("1669140032", "1174992642", 1.0F, 0, null);
    CmShowTest.a(this.a);
  }
  
  public void a(int paramInt, String paramString)
  {
    QLog.i("CmShowTest", 1, "onClick apolloId:" + paramString);
  }
  
  public void a(String paramString)
  {
    QLog.i("CmShowTest", 1, "onLongTouch name:" + paramString);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    QLog.i("CmShowTest", 1, "onActionStart actionId:" + paramInt1);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, int paramInt3, Bundle paramBundle)
  {
    QLog.i("CmShowTest", 1, "onActionComplete actionId:" + paramInt1 + " actionSeqId:" + paramInt2 + " playFragment:" + paramInt3);
    if (paramInt2 == 100)
    {
      CmShowTest.b(this.a);
      return;
    }
    if (paramInt2 == 101)
    {
      if (CmShowTest.a() < 3)
      {
        CmShowTest.b();
        CmShowTest.b(this.a);
        return;
      }
      CmShowTest.c(this.a);
      return;
    }
    CmShowTest.a(0);
  }
  
  public void a(boolean paramBoolean, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.sdk.CmShowTest.2
 * JD-Core Version:    0.7.0.1
 */