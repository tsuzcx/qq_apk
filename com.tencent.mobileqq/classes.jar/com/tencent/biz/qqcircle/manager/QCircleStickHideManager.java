package com.tencent.biz.qqcircle.manager;

import java.util.Iterator;
import java.util.Set;

public class QCircleStickHideManager
{
  private static volatile QCircleStickHideManager a;
  private Set<QCircleStickHideManager.OnStickHideListener> b = null;
  private boolean c = false;
  
  public static QCircleStickHideManager a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new QCircleStickHideManager();
        }
      }
      finally {}
    }
    return a;
  }
  
  private void c()
  {
    Object localObject = this.b;
    if (localObject == null) {
      return;
    }
    localObject = ((Set)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((QCircleStickHideManager.OnStickHideListener)((Iterator)localObject).next()).a();
    }
  }
  
  public void a(QCircleStickHideManager.OnStickHideListener paramOnStickHideListener)
  {
    Set localSet = this.b;
    if ((localSet != null) && (paramOnStickHideListener != null)) {
      localSet.add(paramOnStickHideListener);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public void b()
  {
    if (!this.c) {
      return;
    }
    c();
    this.c = false;
  }
  
  public void b(QCircleStickHideManager.OnStickHideListener paramOnStickHideListener)
  {
    Set localSet = this.b;
    if ((localSet != null) && (paramOnStickHideListener != null)) {
      localSet.remove(paramOnStickHideListener);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.manager.QCircleStickHideManager
 * JD-Core Version:    0.7.0.1
 */