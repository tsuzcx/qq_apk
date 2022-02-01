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
  protected HashMap<String, WeakReference<QQStoryBaseActivity>> a;
  public Map<String, WeakReference<QQStoryBaseActivity>> a;
  public boolean a;
  
  public QQStoryActivityManager()
  {
    this.jdField_a_of_type_JavaUtilHashMap = new LinkedHashMap();
  }
  
  public ArrayList<Integer> a(QQStoryBaseActivity paramQQStoryBaseActivity)
  {
    ArrayList localArrayList1 = new ArrayList(this.jdField_a_of_type_JavaUtilHashMap.values());
    ArrayList localArrayList2 = new ArrayList();
    int j = localArrayList1.size();
    int i = 0;
    while (i < j)
    {
      QQStoryBaseActivity localQQStoryBaseActivity = (QQStoryBaseActivity)((WeakReference)localArrayList1.get(i)).get();
      if ((localQQStoryBaseActivity != null) && (!localQQStoryBaseActivity.isFinishing()) && (localQQStoryBaseActivity.getActivityName().equals(paramQQStoryBaseActivity.getActivityName())))
      {
        if (QLog.isColorLevel()) {
          QLog.d("zivonchen", 2, "QQStoryActivityManager getActivityFirstIndex: " + i + ", class = " + paramQQStoryBaseActivity.getActivityName());
        }
        localArrayList2.add(Integer.valueOf(i));
      }
      i += 1;
    }
    return localArrayList2;
  }
  
  public void a() {}
  
  public void a(int paramInt1, int paramInt2)
  {
    ArrayList localArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilHashMap.values());
    paramInt2 -= 1;
    while (paramInt2 >= paramInt1)
    {
      Object localObject = (QQStoryBaseActivity)((WeakReference)localArrayList.get(paramInt2)).get();
      if ((localObject != null) && (!((QQStoryBaseActivity)localObject).isFinishing()))
      {
        ((QQStoryBaseActivity)localObject).finish();
        localObject = ((QQStoryBaseActivity)localObject).getActivityName() + "_" + localObject.hashCode();
        this.jdField_a_of_type_JavaUtilHashMap.remove(localObject);
        if (this.jdField_a_of_type_JavaUtilMap != null) {
          this.jdField_a_of_type_JavaUtilMap.remove(localObject);
        }
      }
      paramInt2 -= 1;
    }
  }
  
  public void a(QQStoryBaseActivity paramQQStoryBaseActivity)
  {
    String str = paramQQStoryBaseActivity.getActivityName() + "_" + paramQQStoryBaseActivity.hashCode();
    paramQQStoryBaseActivity = new WeakReference(paramQQStoryBaseActivity);
    this.jdField_a_of_type_JavaUtilHashMap.put(str, paramQQStoryBaseActivity);
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_JavaUtilMap != null)) {
      this.jdField_a_of_type_JavaUtilMap.put(str, paramQQStoryBaseActivity);
    }
  }
  
  public boolean a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.values().iterator();
    while (localIterator.hasNext())
    {
      QQStoryBaseActivity localQQStoryBaseActivity = (QQStoryBaseActivity)((WeakReference)localIterator.next()).get();
      if ((localQQStoryBaseActivity != null) && (!localQQStoryBaseActivity.isFinishing())) {
        localQQStoryBaseActivity.finish();
      }
    }
    this.jdField_a_of_type_JavaUtilHashMap.clear();
    if (this.jdField_a_of_type_JavaUtilMap != null) {
      this.jdField_a_of_type_JavaUtilMap.clear();
    }
    this.jdField_a_of_type_Boolean = false;
    return true;
  }
  
  public void b()
  {
    this.jdField_a_of_type_JavaUtilHashMap.clear();
    if (this.jdField_a_of_type_JavaUtilMap != null) {
      this.jdField_a_of_type_JavaUtilMap.clear();
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void b(QQStoryBaseActivity paramQQStoryBaseActivity)
  {
    paramQQStoryBaseActivity = paramQQStoryBaseActivity.getActivityName() + "_" + paramQQStoryBaseActivity.hashCode();
    this.jdField_a_of_type_JavaUtilHashMap.remove(paramQQStoryBaseActivity);
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_JavaUtilMap != null))
    {
      this.jdField_a_of_type_JavaUtilMap.remove(paramQQStoryBaseActivity);
      if (this.jdField_a_of_type_JavaUtilMap.isEmpty())
      {
        this.jdField_a_of_type_Boolean = false;
        if (QLog.isColorLevel()) {
          QLog.i("qqstory.QQStoryActivityManager", 2, "player activity stack is empty, disable!");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.QQStoryActivityManager
 * JD-Core Version:    0.7.0.1
 */