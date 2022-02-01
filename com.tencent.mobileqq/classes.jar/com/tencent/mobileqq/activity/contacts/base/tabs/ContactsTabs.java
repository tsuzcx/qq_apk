package com.tencent.mobileqq.activity.contacts.base.tabs;

import com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class ContactsTabs
{
  public String[] a;
  public int[] b;
  public ArrayList<TabInfo> c = new ArrayList();
  private boolean d;
  private boolean e;
  
  public ContactsTabs(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool2 = false;
    this.d = false;
    this.e = false;
    boolean bool1 = bool2;
    if (paramBoolean1)
    {
      bool1 = bool2;
      if (!StudyModeManager.h()) {
        bool1 = true;
      }
    }
    this.e = bool1;
    this.d = paramBoolean2;
    a();
  }
  
  public int a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.c.size())) {
      return ((TabInfo)this.c.get(paramInt)).j;
    }
    return 1;
  }
  
  protected void a()
  {
    this.c.clear();
    boolean bool = this.e;
    int i = 0;
    if (bool) {
      this.c.add(new TabInfo(0, 2131431278, HardCodeUtil.a(2131900726)));
    }
    this.c.add(new TabInfo(6, 2131431274, HardCodeUtil.a(2131900712)));
    this.c.add(new TabInfo(1, 2131431273, HardCodeUtil.a(2131900682)));
    this.c.add(new TabInfo(2, 2131431279, HardCodeUtil.a(2131900725)));
    this.c.add(new TabInfo(3, 2131431271, HardCodeUtil.a(2131900709)));
    this.c.add(new TabInfo(4, 2131431276, HardCodeUtil.a(2131900704)));
    if (!StudyModeManager.h()) {
      this.c.add(new TabInfo(5, 2131431277, ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getPublicAccountTitle()));
    }
    int j = this.c.size();
    this.a = new String[j];
    this.b = new int[j];
    while (i < j)
    {
      this.b[i] = ((TabInfo)this.c.get(i)).k;
      this.a[i] = ((TabInfo)this.c.get(i)).l;
      i += 1;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("buildData showRecommend:");
      localStringBuilder.append(this.e);
      localStringBuilder.append(" tabSize:");
      localStringBuilder.append(j);
      QLog.d("ContactsTabs", 2, localStringBuilder.toString());
    }
  }
  
  public boolean a(boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = 0;
    if ((paramBoolean1) && (!StudyModeManager.h())) {
      paramBoolean1 = true;
    } else {
      paramBoolean1 = false;
    }
    Object localObject;
    if (paramBoolean1 != this.e)
    {
      this.e = paramBoolean1;
      if (paramBoolean1) {
        this.c.add(0, new TabInfo(0, 2131431278, HardCodeUtil.a(2131900679)));
      } else {
        this.c.remove(0);
      }
      int j = this.c.size();
      this.a = new String[j];
      this.b = new int[j];
      while (i < j)
      {
        localObject = (TabInfo)this.c.get(i);
        if (((TabInfo)localObject).j == 5) {
          ((TabInfo)localObject).l = ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getPublicAccountTitle();
        }
        this.b[i] = ((TabInfo)localObject).k;
        this.a[i] = ((TabInfo)localObject).l;
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
    if (paramBoolean2 != this.d)
    {
      this.d = paramBoolean2;
      a();
      return true;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("update showRecommend2:");
      ((StringBuilder)localObject).append(paramBoolean1);
      ((StringBuilder)localObject).append(" tabSize:");
      ((StringBuilder)localObject).append(this.c.size());
      QLog.d("ContactsTabs", 2, ((StringBuilder)localObject).toString());
    }
    return false;
  }
  
  public int b(int paramInt)
  {
    int i = 0;
    while (i < this.c.size())
    {
      if (((TabInfo)this.c.get(i)).j == paramInt) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  public boolean b()
  {
    return this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.base.tabs.ContactsTabs
 * JD-Core Version:    0.7.0.1
 */