package com.tencent.mobileqq.activity.contacts.base.tabs;

import com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class ContactsTabs
{
  public ArrayList<TabInfo> a;
  private boolean a;
  public int[] a;
  public String[] a;
  private boolean b;
  
  public ContactsTabs(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    boolean bool2 = false;
    this.jdField_a_of_type_Boolean = false;
    this.b = false;
    boolean bool1 = bool2;
    if (paramBoolean1)
    {
      bool1 = bool2;
      if (!StudyModeManager.a()) {
        bool1 = true;
      }
    }
    this.b = bool1;
    this.jdField_a_of_type_Boolean = paramBoolean2;
    a();
  }
  
  public int a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilArrayList.size())) {
      return ((TabInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).c;
    }
    return 1;
  }
  
  protected void a()
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    boolean bool = this.b;
    int i = 0;
    if (bool) {
      this.jdField_a_of_type_JavaUtilArrayList.add(new TabInfo(0, 2131365130, HardCodeUtil.a(2131702736)));
    }
    this.jdField_a_of_type_JavaUtilArrayList.add(new TabInfo(6, 2131365127, HardCodeUtil.a(2131702722)));
    this.jdField_a_of_type_JavaUtilArrayList.add(new TabInfo(1, 2131365126, HardCodeUtil.a(2131702692)));
    this.jdField_a_of_type_JavaUtilArrayList.add(new TabInfo(2, 2131365131, HardCodeUtil.a(2131702735)));
    this.jdField_a_of_type_JavaUtilArrayList.add(new TabInfo(3, 2131365124, HardCodeUtil.a(2131702719)));
    this.jdField_a_of_type_JavaUtilArrayList.add(new TabInfo(4, 2131365128, HardCodeUtil.a(2131702714)));
    if (!StudyModeManager.a()) {
      this.jdField_a_of_type_JavaUtilArrayList.add(new TabInfo(5, 2131365129, ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getPublicAccountTitle()));
    }
    int j = this.jdField_a_of_type_JavaUtilArrayList.size();
    this.jdField_a_of_type_ArrayOfJavaLangString = new String[j];
    this.jdField_a_of_type_ArrayOfInt = new int[j];
    while (i < j)
    {
      this.jdField_a_of_type_ArrayOfInt[i] = ((TabInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i)).d;
      this.jdField_a_of_type_ArrayOfJavaLangString[i] = ((TabInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i)).f;
      i += 1;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("buildData showRecommend:");
      localStringBuilder.append(this.b);
      localStringBuilder.append(" tabSize:");
      localStringBuilder.append(j);
      QLog.d("ContactsTabs", 2, localStringBuilder.toString());
    }
  }
  
  public boolean a()
  {
    return this.b;
  }
  
  public boolean a(boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = 0;
    if ((paramBoolean1) && (!StudyModeManager.a())) {
      paramBoolean1 = true;
    } else {
      paramBoolean1 = false;
    }
    Object localObject;
    if (paramBoolean1 != this.b)
    {
      this.b = paramBoolean1;
      if (paramBoolean1) {
        this.jdField_a_of_type_JavaUtilArrayList.add(0, new TabInfo(0, 2131365130, HardCodeUtil.a(2131702689)));
      } else {
        this.jdField_a_of_type_JavaUtilArrayList.remove(0);
      }
      int j = this.jdField_a_of_type_JavaUtilArrayList.size();
      this.jdField_a_of_type_ArrayOfJavaLangString = new String[j];
      this.jdField_a_of_type_ArrayOfInt = new int[j];
      while (i < j)
      {
        localObject = (TabInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        if (((TabInfo)localObject).c == 5) {
          ((TabInfo)localObject).f = ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getPublicAccountTitle();
        }
        this.jdField_a_of_type_ArrayOfInt[i] = ((TabInfo)localObject).d;
        this.jdField_a_of_type_ArrayOfJavaLangString[i] = ((TabInfo)localObject).f;
        i += 1;
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("update showRecommend1:");
        ((StringBuilder)localObject).append(paramBoolean1);
        ((StringBuilder)localObject).append(" tabSize:");
        ((StringBuilder)localObject).append(j);
        QLog.d("ContactsTabs", 2, ((StringBuilder)localObject).toString());
      }
      return true;
    }
    if (paramBoolean2 != this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = paramBoolean2;
      a();
      return true;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("update showRecommend2:");
      ((StringBuilder)localObject).append(paramBoolean1);
      ((StringBuilder)localObject).append(" tabSize:");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaUtilArrayList.size());
      QLog.d("ContactsTabs", 2, ((StringBuilder)localObject).toString());
    }
    return false;
  }
  
  public int b(int paramInt)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      if (((TabInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i)).c == paramInt) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.base.tabs.ContactsTabs
 * JD-Core Version:    0.7.0.1
 */