package com.tencent.biz.qqstory.model;

import com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class QQStoryActivityManager
  implements IManager
{
  protected HashMap<String, WeakReference<QQStoryBaseActivity>> a = new LinkedHashMap();
  public Map<String, WeakReference<QQStoryBaseActivity>> b;
  public boolean c;
  
  public void a() {}
  
  public void a(int paramInt1, int paramInt2)
  {
    ArrayList localArrayList = new ArrayList(this.a.values());
    paramInt2 -= 1;
    while (paramInt2 >= paramInt1)
    {
      Object localObject1 = (QQStoryBaseActivity)((WeakReference)localArrayList.get(paramInt2)).get();
      if ((localObject1 != null) && (!((QQStoryBaseActivity)localObject1).isFinishing()))
      {
        ((QQStoryBaseActivity)localObject1).finish();
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(((QQStoryBaseActivity)localObject1).getActivityName());
        ((StringBuilder)localObject2).append("_");
        ((StringBuilder)localObject2).append(localObject1.hashCode());
        localObject1 = ((StringBuilder)localObject2).toString();
        this.a.remove(localObject1);
        localObject2 = this.b;
        if (localObject2 != null) {
          ((Map)localObject2).remove(localObject1);
        }
      }
      paramInt2 -= 1;
    }
  }
  
  public void a(QQStoryBaseActivity paramQQStoryBaseActivity)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramQQStoryBaseActivity.getActivityName());
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append(paramQQStoryBaseActivity.hashCode());
    localObject = ((StringBuilder)localObject).toString();
    paramQQStoryBaseActivity = new WeakReference(paramQQStoryBaseActivity);
    this.a.put(localObject, paramQQStoryBaseActivity);
    if (this.c)
    {
      Map localMap = this.b;
      if (localMap != null) {
        localMap.put(localObject, paramQQStoryBaseActivity);
      }
    }
  }
  
  public void b()
  {
    this.a.clear();
    Map localMap = this.b;
    if (localMap != null) {
      localMap.clear();
    }
    this.c = false;
  }
  
  public void b(QQStoryBaseActivity paramQQStoryBaseActivity)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramQQStoryBaseActivity.getActivityName());
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append(paramQQStoryBaseActivity.hashCode());
    paramQQStoryBaseActivity = ((StringBuilder)localObject).toString();
    this.a.remove(paramQQStoryBaseActivity);
    if (this.c)
    {
      localObject = this.b;
      if (localObject != null)
      {
        ((Map)localObject).remove(paramQQStoryBaseActivity);
        if (this.b.isEmpty())
        {
          this.c = false;
          if (QLog.isColorLevel()) {
            QLog.i("qqstory.QQStoryActivityManager", 2, "player activity stack is empty, disable!");
          }
        }
      }
    }
  }
  
  public ArrayList<Integer> c(QQStoryBaseActivity paramQQStoryBaseActivity)
  {
    ArrayList localArrayList1 = new ArrayList(this.a.values());
    ArrayList localArrayList2 = new ArrayList();
    int j = localArrayList1.size();
    int i = 0;
    while (i < j)
    {
      Object localObject = (QQStoryBaseActivity)((WeakReference)localArrayList1.get(i)).get();
      if ((localObject != null) && (!((QQStoryBaseActivity)localObject).isFinishing()) && (((QQStoryBaseActivity)localObject).getActivityName().equals(paramQQStoryBaseActivity.getActivityName())))
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("QQStoryActivityManager getActivityFirstIndex: ");
          ((StringBuilder)localObject).append(i);
          ((StringBuilder)localObject).append(", class = ");
          ((StringBuilder)localObject).append(paramQQStoryBaseActivity.getActivityName());
          QLog.d("zivonchen", 2, ((StringBuilder)localObject).toString());
        }
        localArrayList2.add(Integer.valueOf(i));
      }
      i += 1;
    }
    return localArrayList2;
  }
  
  public boolean c()
  {
    Object localObject = this.a.values().iterator();
    while (((Iterator)localObject).hasNext())
    {
      QQStoryBaseActivity localQQStoryBaseActivity = (QQStoryBaseActivity)((WeakReference)((Iterator)localObject).next()).get();
      if ((localQQStoryBaseActivity != null) && (!localQQStoryBaseActivity.isFinishing())) {
        localQQStoryBaseActivity.finish();
      }
    }
    this.a.clear();
    localObject = this.b;
    if (localObject != null) {
      ((Map)localObject).clear();
    }
    this.c = false;
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.QQStoryActivityManager
 * JD-Core Version:    0.7.0.1
 */