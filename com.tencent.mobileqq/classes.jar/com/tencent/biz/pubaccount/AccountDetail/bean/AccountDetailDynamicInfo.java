package com.tencent.biz.pubaccount.accountdetail.bean;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class AccountDetailDynamicInfo
{
  public long a;
  public long b;
  public long c;
  public boolean d;
  private ArrayList<DynamicInfo> e = new ArrayList();
  private ArrayList<DynamicInfo> f = new ArrayList();
  
  public ArrayList<DynamicInfo> a()
  {
    return this.e;
  }
  
  public void a(ArrayList<DynamicInfo> paramArrayList)
  {
    if (paramArrayList != null) {
      this.e.addAll(paramArrayList);
    }
    if (QLog.isColorLevel())
    {
      paramArrayList = new StringBuilder();
      paramArrayList.append("mDynamicInfoList.size():");
      paramArrayList.append(this.e.size());
      QLog.d("addOldDynamicInfoItemList", 2, paramArrayList.toString());
    }
  }
  
  public ArrayList<DynamicInfo> b()
  {
    return this.f;
  }
  
  public void b(ArrayList<String> paramArrayList)
  {
    this.f.clear();
    int j = 0;
    int i;
    if (paramArrayList == null) {
      i = 0;
    } else {
      i = paramArrayList.size();
    }
    while (j < i)
    {
      String str = (String)paramArrayList.get(j);
      if (!TextUtils.isEmpty(str))
      {
        DynamicInfo localDynamicInfo = new DynamicInfo();
        localDynamicInfo.a(str);
        this.f.add(localDynamicInfo);
      }
      j += 1;
    }
    this.e.addAll(this.f);
    if (QLog.isColorLevel())
    {
      paramArrayList = new StringBuilder();
      paramArrayList.append("mDynamicInfoList.size():");
      paramArrayList.append(this.f.size());
      QLog.d("parceJson2DynamicInfoItemList", 2, paramArrayList.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.accountdetail.bean.AccountDetailDynamicInfo
 * JD-Core Version:    0.7.0.1
 */