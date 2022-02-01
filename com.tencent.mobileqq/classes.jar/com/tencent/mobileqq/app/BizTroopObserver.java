package com.tencent.mobileqq.app;

import android.os.Bundle;
import com.tencent.mobileqq.troop.data.TroopFileStatusInfo;

public class BizTroopObserver
  implements BusinessObserver
{
  private void a(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 2) {
      return;
    }
    a(paramBoolean, paramObject);
  }
  
  private void a(int paramInt, boolean paramBoolean, Object[] paramArrayOfObject)
  {
    if (paramInt != 31) {
      return;
    }
    if (paramArrayOfObject != null) {
      a(paramBoolean, ((Boolean)paramArrayOfObject[1]).booleanValue());
    }
  }
  
  private void b(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 9) {
      return;
    }
    a(paramObject);
  }
  
  private void b(int paramInt, boolean paramBoolean, Object[] paramArrayOfObject)
  {
    if (paramInt != 41) {
      return;
    }
    if (paramArrayOfObject != null) {
      a((TroopFileStatusInfo)paramArrayOfObject[0], ((Integer)paramArrayOfObject[1]).intValue(), ((Integer)paramArrayOfObject[2]).intValue(), (String)paramArrayOfObject[3], (String)paramArrayOfObject[4], (Bundle)paramArrayOfObject[5]);
    }
  }
  
  private void c(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 13) {
      return;
    }
    b(paramObject);
  }
  
  private void d(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 20) {
      return;
    }
    c(paramObject);
  }
  
  private void e(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 39) {
      return;
    }
    b(paramBoolean, paramObject);
  }
  
  private void f(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 40) {
      return;
    }
    c(paramBoolean, paramObject);
  }
  
  protected void a(TroopFileStatusInfo paramTroopFileStatusInfo, int paramInt1, int paramInt2, String paramString1, String paramString2, Bundle paramBundle) {}
  
  protected void a(Object paramObject) {}
  
  protected void a(boolean paramBoolean, Object paramObject) {}
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void b(Object paramObject) {}
  
  protected void b(boolean paramBoolean, Object paramObject) {}
  
  protected void c(Object paramObject) {}
  
  protected void c(boolean paramBoolean, Object paramObject) {}
  
  public final void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    Object[] arrayOfObject;
    if ((paramObject instanceof Object[])) {
      arrayOfObject = (Object[])paramObject;
    } else {
      arrayOfObject = null;
    }
    a(paramInt, paramBoolean, paramObject);
    b(paramInt, paramBoolean, paramObject);
    c(paramInt, paramBoolean, paramObject);
    d(paramInt, paramBoolean, paramObject);
    a(paramInt, paramBoolean, arrayOfObject);
    e(paramInt, paramBoolean, paramObject);
    f(paramInt, paramBoolean, paramObject);
    b(paramInt, paramBoolean, arrayOfObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.BizTroopObserver
 * JD-Core Version:    0.7.0.1
 */