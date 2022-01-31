package com.tencent.biz.pubaccount.AccountDetail.bean;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class AccountDetailDynamicInfo
{
  public long a;
  private ArrayList a = new ArrayList();
  public boolean a;
  public long b;
  private ArrayList b = new ArrayList();
  public long c;
  
  public ArrayList a()
  {
    return this.a;
  }
  
  public void a(ArrayList paramArrayList)
  {
    if (paramArrayList != null) {
      this.a.addAll(paramArrayList);
    }
    if (QLog.isColorLevel()) {
      QLog.d("addOldDynamicInfoItemList", 2, "mDynamicInfoList.size():" + this.a.size());
    }
  }
  
  public ArrayList b()
  {
    return this.b;
  }
  
  public void b(ArrayList paramArrayList)
  {
    this.b.clear();
    if (paramArrayList == null) {}
    for (int i = 0;; i = paramArrayList.size())
    {
      int j = 0;
      while (j < i)
      {
        String str = (String)paramArrayList.get(j);
        if (!TextUtils.isEmpty(str))
        {
          DynamicInfo localDynamicInfo = new DynamicInfo();
          localDynamicInfo.a(str);
          this.b.add(localDynamicInfo);
        }
        j += 1;
      }
    }
    this.a.addAll(this.b);
    if (QLog.isColorLevel()) {
      QLog.d("parceJson2DynamicInfoItemList", 2, "mDynamicInfoList.size():" + this.b.size());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.AccountDetail.bean.AccountDetailDynamicInfo
 * JD-Core Version:    0.7.0.1
 */