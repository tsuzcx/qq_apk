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
  private SparseArray<IAIOShortcutBarApi> jdField_a_of_type_AndroidUtilSparseArray;
  private AIOShortcutBarContext jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputShortcutbarAIOShortcutBarContext;
  private AIOShortcutBarHelper jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputShortcutbarAIOShortcutBarHelper;
  private Map<Integer, List<AIOShortcutBarHelper.OnVisibilityChangedListener>> jdField_a_of_type_JavaUtilMap;
  private boolean jdField_a_of_type_Boolean = false;
  
  public AIOShortcutBarLogic(AIOShortcutBarHelper paramAIOShortcutBarHelper)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputShortcutbarAIOShortcutBarHelper = paramAIOShortcutBarHelper;
  }
  
  private IAIOShortcutBarApi a(int paramInt)
  {
    SparseArray localSparseArray = this.jdField_a_of_type_AndroidUtilSparseArray;
    if (localSparseArray == null) {
      return null;
    }
    return (IAIOShortcutBarApi)localSparseArray.get(paramInt);
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidUtilSparseArray.append(1, new TroopRobotShortcutBarService());
  }
  
  private void a(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidUtilSparseArray == null) {
      this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
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
              a();
            }
          }
          else {
            c();
          }
        }
        else {
          e();
        }
      }
      else {
        b();
      }
    }
    else {
      d();
    }
    paramInt = 0;
    while (paramInt < this.jdField_a_of_type_AndroidUtilSparseArray.size())
    {
      ((IAIOShortcutBarApi)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(paramInt)).a(this);
      paramInt += 1;
    }
  }
  
  private IAIOShortcutBarApi b(int paramInt)
  {
    int i = 0;
    Object localObject1 = null;
    int k;
    for (int j = 0; i < this.jdField_a_of_type_AndroidUtilSparseArray.size(); j = k)
    {
      int m = this.jdField_a_of_type_AndroidUtilSparseArray.keyAt(i);
      Object localObject2;
      if (m == paramInt)
      {
        localObject2 = localObject1;
        k = j;
      }
      else
      {
        IAIOShortcutBarApi localIAIOShortcutBarApi = (IAIOShortcutBarApi)this.jdField_a_of_type_AndroidUtilSparseArray.get(m);
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
  
  private void b()
  {
    this.jdField_a_of_type_AndroidUtilSparseArray.append(1, new TroopRobotShortcutBarService());
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidUtilSparseArray.append(1, new C2CAppShortcutBarService());
  }
  
  private boolean c(int paramInt)
  {
    if (paramInt == 0) {
      return false;
    }
    IAIOShortcutBarApi localIAIOShortcutBarApi = a(paramInt);
    if (localIAIOShortcutBarApi == null) {
      return false;
    }
    return localIAIOShortcutBarApi.a() != null;
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidUtilSparseArray.append(1, new C2CAppShortcutBarService());
  }
  
  private void e()
  {
    this.jdField_a_of_type_AndroidUtilSparseArray.append(1, new TroopRobotShortcutBarService());
    this.jdField_a_of_type_AndroidUtilSparseArray.append(2, new TroopAppShortCutBarService());
  }
  
  private void f()
  {
    Object localObject = this.jdField_a_of_type_JavaUtilMap;
    if (localObject != null) {
      ((Map)localObject).clear();
    }
    localObject = this.jdField_a_of_type_AndroidUtilSparseArray;
    if (localObject != null) {
      ((SparseArray)localObject).clear();
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputShortcutbarAIOShortcutBarHelper.d();
  }
  
  public int a(int paramInt)
  {
    if (!c(paramInt)) {
      return 0;
    }
    return a(paramInt).b();
  }
  
  public AIOShortcutBarContext a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputShortcutbarAIOShortcutBarContext == null)
    {
      AIOShortcutBarHelper localAIOShortcutBarHelper = this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputShortcutbarAIOShortcutBarHelper;
      if (localAIOShortcutBarHelper != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputShortcutbarAIOShortcutBarContext = new AIOShortcutBarContext(localAIOShortcutBarHelper);
      }
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputShortcutbarAIOShortcutBarContext;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    Object localObject = this.jdField_a_of_type_JavaUtilMap;
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
    Object localObject = this.jdField_a_of_type_AndroidUtilSparseArray;
    if ((localObject == null) || (((SparseArray)localObject).size() == 0)) {
      a(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputShortcutbarAIOShortcutBarHelper.a());
    }
    int i = 0;
    while (i < this.jdField_a_of_type_AndroidUtilSparseArray.size())
    {
      localObject = (IAIOShortcutBarApi)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(i);
      if (localObject != null) {
        ((IAIOShortcutBarApi)localObject).a(paramInt, paramBundle);
      }
      i += 1;
    }
    if (paramInt == 4) {
      f();
    }
  }
  
  public void a(int paramInt, AIOShortcutBarHelper.OnVisibilityChangedListener paramOnVisibilityChangedListener)
  {
    if (paramOnVisibilityChangedListener == null) {
      return;
    }
    if (this.jdField_a_of_type_JavaUtilMap == null) {
      this.jdField_a_of_type_JavaUtilMap = new HashMap();
    }
    List localList = (List)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt));
    Object localObject = localList;
    if (localList == null)
    {
      localObject = new ArrayList();
      this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(paramInt), localObject);
    }
    ((List)localObject).add(paramOnVisibilityChangedListener);
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_AndroidUtilSparseArray == null) {
      return false;
    }
    IAIOShortcutBarApi localIAIOShortcutBarApi;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputShortcutbarAIOShortcutBarHelper.a() == 3)
    {
      localIAIOShortcutBarApi = (IAIOShortcutBarApi)this.jdField_a_of_type_AndroidUtilSparseArray.get(2);
      if (localIAIOShortcutBarApi != null) {
        return ((TroopAppShortCutBarService)localIAIOShortcutBarApi).a();
      }
    }
    else if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputShortcutbarAIOShortcutBarHelper.a() == 5) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputShortcutbarAIOShortcutBarHelper.a() == 1))
    {
      localIAIOShortcutBarApi = (IAIOShortcutBarApi)this.jdField_a_of_type_AndroidUtilSparseArray.get(1);
      if (localIAIOShortcutBarApi != null) {
        return ((C2CAppShortcutBarService)localIAIOShortcutBarApi).a();
      }
    }
    return false;
  }
  
  public boolean a(int paramInt)
  {
    if (!c(paramInt)) {
      return false;
    }
    Object localObject1 = a(paramInt).a();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputShortcutbarAIOShortcutBarHelper.d() != paramInt)
    {
      ((View)localObject1).setVisibility(8);
      return false;
    }
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_Boolean = false;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputShortcutbarAIOShortcutBarHelper.b(8);
    a(paramInt, 8);
    Object localObject2 = b(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputShortcutbarAIOShortcutBarHelper.d());
    if (localObject2 != null)
    {
      paramInt = ((IAIOShortcutBarApi)localObject2).a();
      localObject1 = ((IAIOShortcutBarApi)localObject2).a();
      localObject2 = ((IAIOShortcutBarApi)localObject2).a();
    }
    else
    {
      localObject2 = null;
      localObject1 = localObject2;
      paramInt = 0;
    }
    if ((paramInt != 0) && (localObject1 != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputShortcutbarAIOShortcutBarHelper.a(paramInt, (View)localObject1, (ViewGroup.LayoutParams)localObject2);
      a(paramInt, 0);
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputShortcutbarAIOShortcutBarHelper.d();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputShortcutbarAIOShortcutBarHelper.b();
    }
    return true;
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    if (!c(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputShortcutbarAIOShortcutBarHelper.d())) {
      return false;
    }
    return a(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputShortcutbarAIOShortcutBarHelper.d()).a(paramMotionEvent);
  }
  
  public void b(int paramInt, AIOShortcutBarHelper.OnVisibilityChangedListener paramOnVisibilityChangedListener)
  {
    if (paramOnVisibilityChangedListener == null) {
      return;
    }
    Object localObject = this.jdField_a_of_type_JavaUtilMap;
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
    if (!c(paramInt)) {
      return false;
    }
    IAIOShortcutBarApi localIAIOShortcutBarApi = a(paramInt);
    if ((this.jdField_a_of_type_Boolean) && (paramInt != this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputShortcutbarAIOShortcutBarHelper.d()))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputShortcutbarAIOShortcutBarHelper.a(localIAIOShortcutBarApi.a());
      localIAIOShortcutBarApi.a().setVisibility(0);
      return false;
    }
    int i = this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputShortcutbarAIOShortcutBarHelper.d();
    if ((i <= paramInt) && (i != 0))
    {
      if ((i == paramInt) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputShortcutbarAIOShortcutBarHelper.c() != 0))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputShortcutbarAIOShortcutBarHelper.b(0);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputShortcutbarAIOShortcutBarHelper.c();
        this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputShortcutbarAIOShortcutBarHelper.a();
        a(paramInt, 0);
        return true;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputShortcutbarAIOShortcutBarHelper.c() != 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputShortcutbarAIOShortcutBarHelper.a(paramInt, localIAIOShortcutBarApi.a(), localIAIOShortcutBarApi.a());
        this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputShortcutbarAIOShortcutBarHelper.b(0);
        a(paramInt, 0);
        return true;
      }
      localIAIOShortcutBarApi.a().setVisibility(0);
      return false;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputShortcutbarAIOShortcutBarHelper.a(paramInt, localIAIOShortcutBarApi.a(), localIAIOShortcutBarApi.a());
    this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputShortcutbarAIOShortcutBarHelper.b(0);
    a(paramInt, 0);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.AIOShortcutBarLogic
 * JD-Core Version:    0.7.0.1
 */