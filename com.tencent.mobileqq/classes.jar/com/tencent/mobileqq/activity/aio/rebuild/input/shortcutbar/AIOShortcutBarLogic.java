package com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar;

import android.os.Bundle;
import android.os.Handler;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mobileqq.activity.aio.helper.C2CAppShortcutBarService;
import com.tencent.mobileqq.activity.aio.helper.TroopAppShortCutBarService;
import com.tencent.mobileqq.activity.aio.helper.TroopRobotShortcutBarService;
import com.tencent.qav.thread.ThreadManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AIOShortcutBarLogic
  implements IAIOShortcutBarLogic
{
  private boolean a = false;
  private AIOShortcutBarHelper b;
  private SparseArray<IAIOShortcutBarApi> c;
  private AIOShortcutBarContext d;
  private Map<Integer, List<AIOShortcutBarHelper.OnVisibilityChangedListener>> e;
  
  public AIOShortcutBarLogic(AIOShortcutBarHelper paramAIOShortcutBarHelper)
  {
    this.b = paramAIOShortcutBarHelper;
  }
  
  private void d()
  {
    this.c.append(1, new TroopRobotShortcutBarService());
  }
  
  private void d(int paramInt)
  {
    if (this.c == null) {
      this.c = new SparseArray();
    }
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt != 5)
          {
            if (paramInt == 6) {
              d();
            }
          }
          else {
            f();
          }
        }
        else {
          h();
        }
      }
      else {
        e();
      }
    }
    else {
      g();
    }
    paramInt = 0;
    while (paramInt < this.c.size())
    {
      ((IAIOShortcutBarApi)this.c.valueAt(paramInt)).a(this);
      paramInt += 1;
    }
  }
  
  private IAIOShortcutBarApi e(int paramInt)
  {
    SparseArray localSparseArray = this.c;
    if (localSparseArray == null) {
      return null;
    }
    return (IAIOShortcutBarApi)localSparseArray.get(paramInt);
  }
  
  private void e()
  {
    this.c.append(1, new TroopRobotShortcutBarService());
  }
  
  private IAIOShortcutBarApi f(int paramInt)
  {
    int i = 0;
    Object localObject1 = null;
    int k;
    for (int j = 0; i < this.c.size(); j = k)
    {
      int m = this.c.keyAt(i);
      Object localObject2;
      if (m == paramInt)
      {
        localObject2 = localObject1;
        k = j;
      }
      else
      {
        IAIOShortcutBarApi localIAIOShortcutBarApi = (IAIOShortcutBarApi)this.c.get(m);
        localObject2 = localObject1;
        k = j;
        if (localIAIOShortcutBarApi != null)
        {
          View localView = localIAIOShortcutBarApi.a();
          localObject2 = localObject1;
          k = j;
          if (localView != null)
          {
            localObject2 = localObject1;
            k = j;
            if (localView.getVisibility() == 0) {
              if (j != 0)
              {
                localObject2 = localObject1;
                k = j;
                if (j <= m) {}
              }
              else
              {
                k = m;
                localObject2 = localIAIOShortcutBarApi;
              }
            }
          }
        }
      }
      i += 1;
      localObject1 = localObject2;
    }
    return localObject1;
  }
  
  private void f()
  {
    this.c.append(1, new C2CAppShortcutBarService());
  }
  
  private void g()
  {
    this.c.append(1, new C2CAppShortcutBarService());
  }
  
  private boolean g(int paramInt)
  {
    if (paramInt == 0) {
      return false;
    }
    IAIOShortcutBarApi localIAIOShortcutBarApi = e(paramInt);
    if (localIAIOShortcutBarApi == null) {
      return false;
    }
    return localIAIOShortcutBarApi.a() != null;
  }
  
  private void h()
  {
    this.c.append(1, new TroopRobotShortcutBarService());
    this.c.append(2, new TroopAppShortCutBarService());
  }
  
  private void i()
  {
    Object localObject = this.e;
    if (localObject != null) {
      ((Map)localObject).clear();
    }
    localObject = this.c;
    if (localObject != null) {
      ((SparseArray)localObject).clear();
    }
  }
  
  public AIOShortcutBarContext a()
  {
    if (this.d == null)
    {
      AIOShortcutBarHelper localAIOShortcutBarHelper = this.b;
      if (localAIOShortcutBarHelper != null) {
        this.d = new AIOShortcutBarContext(localAIOShortcutBarHelper);
      }
    }
    return this.d;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    Object localObject = this.e;
    if (localObject == null) {
      return;
    }
    localObject = (List)((Map)localObject).get(Integer.valueOf(paramInt1));
    if (localObject == null) {
      return;
    }
    ThreadManager.a().postDelayed(new AIOShortcutBarLogic.1(this, (List)localObject, paramInt2), 50L);
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    Object localObject = this.c;
    if ((localObject == null) || (((SparseArray)localObject).size() == 0)) {
      d(this.b.a());
    }
    int i = 0;
    while (i < this.c.size())
    {
      localObject = (IAIOShortcutBarApi)this.c.valueAt(i);
      if (localObject != null) {
        ((IAIOShortcutBarApi)localObject).a(paramInt, paramBundle);
      }
      i += 1;
    }
    if (paramInt == 4) {
      i();
    }
  }
  
  public void a(int paramInt, AIOShortcutBarHelper.OnVisibilityChangedListener paramOnVisibilityChangedListener)
  {
    if (paramOnVisibilityChangedListener == null) {
      return;
    }
    if (this.e == null) {
      this.e = new HashMap();
    }
    List localList = (List)this.e.get(Integer.valueOf(paramInt));
    Object localObject = localList;
    if (localList == null)
    {
      localObject = new ArrayList();
      this.e.put(Integer.valueOf(paramInt), localObject);
    }
    ((List)localObject).add(paramOnVisibilityChangedListener);
  }
  
  public boolean a(int paramInt)
  {
    if (!g(paramInt)) {
      return false;
    }
    Object localObject1 = e(paramInt).a();
    if (this.b.x() != paramInt)
    {
      ((View)localObject1).setVisibility(8);
      return false;
    }
    if (this.a) {
      this.a = false;
    }
    this.b.c(8);
    a(paramInt, 8);
    Object localObject2 = f(this.b.x());
    if (localObject2 != null)
    {
      paramInt = ((IAIOShortcutBarApi)localObject2).c();
      localObject1 = ((IAIOShortcutBarApi)localObject2).a();
      localObject2 = ((IAIOShortcutBarApi)localObject2).b();
    }
    else
    {
      localObject2 = null;
      localObject1 = localObject2;
      paramInt = 0;
    }
    if ((paramInt != 0) && (localObject1 != null))
    {
      this.b.a(paramInt, (View)localObject1, (ViewGroup.LayoutParams)localObject2);
      a(paramInt, 0);
    }
    else
    {
      this.b.g();
      this.b.e();
    }
    return true;
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    if (!g(this.b.x())) {
      return false;
    }
    return e(this.b.x()).a(paramMotionEvent);
  }
  
  public int b()
  {
    return this.b.x();
  }
  
  public void b(int paramInt, AIOShortcutBarHelper.OnVisibilityChangedListener paramOnVisibilityChangedListener)
  {
    if (paramOnVisibilityChangedListener == null) {
      return;
    }
    Object localObject = this.e;
    if (localObject == null) {
      return;
    }
    localObject = (List)((Map)localObject).get(Integer.valueOf(paramInt));
    if (localObject == null) {
      return;
    }
    ((List)localObject).remove(paramOnVisibilityChangedListener);
  }
  
  public boolean b(int paramInt)
  {
    if (!g(paramInt)) {
      return false;
    }
    IAIOShortcutBarApi localIAIOShortcutBarApi = e(paramInt);
    if ((this.a) && (paramInt != this.b.x()))
    {
      this.b.a(localIAIOShortcutBarApi.a());
      localIAIOShortcutBarApi.a().setVisibility(0);
      return false;
    }
    int i = this.b.x();
    if ((i <= paramInt) && (i != 0))
    {
      if ((i == paramInt) && (this.b.v() != 0))
      {
        this.b.c(0);
        this.b.f();
        this.b.d();
        a(paramInt, 0);
        return true;
      }
      if (this.b.v() != 0)
      {
        this.b.a(paramInt, localIAIOShortcutBarApi.a(), localIAIOShortcutBarApi.b());
        this.b.c(0);
        a(paramInt, 0);
        return true;
      }
      localIAIOShortcutBarApi.a().setVisibility(0);
      return false;
    }
    this.b.a(paramInt, localIAIOShortcutBarApi.a(), localIAIOShortcutBarApi.b());
    this.b.c(0);
    a(paramInt, 0);
    return true;
  }
  
  public int c(int paramInt)
  {
    if (!g(paramInt)) {
      return 0;
    }
    return e(paramInt).d();
  }
  
  public boolean c()
  {
    if (this.c == null) {
      return false;
    }
    IAIOShortcutBarApi localIAIOShortcutBarApi;
    if (this.b.a() == 3)
    {
      localIAIOShortcutBarApi = (IAIOShortcutBarApi)this.c.get(2);
      if (localIAIOShortcutBarApi != null) {
        return ((TroopAppShortCutBarService)localIAIOShortcutBarApi).e();
      }
    }
    else if ((this.b.a() == 5) || (this.b.a() == 1))
    {
      localIAIOShortcutBarApi = (IAIOShortcutBarApi)this.c.get(1);
      if (localIAIOShortcutBarApi != null) {
        return ((C2CAppShortcutBarService)localIAIOShortcutBarApi).e();
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.AIOShortcutBarLogic
 * JD-Core Version:    0.7.0.1
 */