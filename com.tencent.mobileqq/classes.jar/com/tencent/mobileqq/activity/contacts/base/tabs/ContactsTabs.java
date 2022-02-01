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
  private boolean b = false;
  
  public ContactsTabs(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Boolean = false;
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
    int i = 0;
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    if (this.b) {
      this.jdField_a_of_type_JavaUtilArrayList.add(new TabInfo(0, 2131365253, HardCodeUtil.a(2131702604)));
    }
    this.jdField_a_of_type_JavaUtilArrayList.add(new TabInfo(6, 2131365250, HardCodeUtil.a(2131702590)));
    this.jdField_a_of_type_JavaUtilArrayList.add(new TabInfo(1, 2131365249, HardCodeUtil.a(2131702560)));
    this.jdField_a_of_type_JavaUtilArrayList.add(new TabInfo(2, 2131365254, HardCodeUtil.a(2131702603)));
    this.jdField_a_of_type_JavaUtilArrayList.add(new TabInfo(3, 2131365247, HardCodeUtil.a(2131702587)));
    this.jdField_a_of_type_JavaUtilArrayList.add(new TabInfo(4, 2131365251, HardCodeUtil.a(2131702582)));
    if (!StudyModeManager.a()) {
      this.jdField_a_of_type_JavaUtilArrayList.add(new TabInfo(5, 2131365252, ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getPublicAccountTitle()));
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
    if (QLog.isColorLevel()) {
      QLog.d("ContactsTabs", 2, "buildData showRecommend:" + this.b + " tabSize:" + j);
    }
  }
  
  public boolean a()
  {
    return this.b;
  }
  
  public boolean a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (!StudyModeManager.a()))
    {
      paramBoolean1 = true;
      if (paramBoolean1 == this.b) {
        break label215;
      }
      this.b = paramBoolean1;
      if (!paramBoolean1) {
        break label160;
      }
      this.jdField_a_of_type_JavaUtilArrayList.add(0, new TabInfo(0, 2131365253, HardCodeUtil.a(2131702557)));
    }
    int j;
    for (;;)
    {
      j = this.jdField_a_of_type_JavaUtilArrayList.size();
      this.jdField_a_of_type_ArrayOfJavaLangString = new String[j];
      this.jdField_a_of_type_ArrayOfInt = new int[j];
      int i = 0;
      while (i < j)
      {
        TabInfo localTabInfo = (TabInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        if (localTabInfo.c == 5) {
          localTabInfo.f = ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getPublicAccountTitle();
        }
        this.jdField_a_of_type_ArrayOfInt[i] = localTabInfo.d;
        this.jdField_a_of_type_ArrayOfJavaLangString[i] = localTabInfo.f;
        i += 1;
      }
      paramBoolean1 = false;
      break;
      label160:
      this.jdField_a_of_type_JavaUtilArrayList.remove(0);
    }
    if (QLog.isColorLevel()) {
      QLog.d("ContactsTabs", 2, "update showRecommend1:" + paramBoolean1 + " tabSize:" + j);
    }
    return true;
    label215:
    if (paramBoolean2 != this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = paramBoolean2;
      a();
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ContactsTabs", 2, "update showRecommend2:" + paramBoolean1 + " tabSize:" + this.jdField_a_of_type_JavaUtilArrayList.size());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.base.tabs.ContactsTabs
 * JD-Core Version:    0.7.0.1
 */