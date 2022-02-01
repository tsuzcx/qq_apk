package com.tencent.biz.pubaccount.readinjoy.readinfo;

import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class UserReadUnReadInfoManager
{
  private List<UserReadUnReadInfoManager.ReadUnRead> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean = false;
  
  public static UserReadUnReadInfoManager a()
  {
    return UserReadUnReadInfoManager.Holder.a();
  }
  
  public UserReadUnReadInfoManager.ReadUnRead a()
  {
    UserReadUnReadInfoManager.ReadUnRead localReadUnRead1 = new UserReadUnReadInfoManager.ReadUnRead();
    long l = NetConnInfoCenter.getServerTime();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      UserReadUnReadInfoManager.ReadUnRead localReadUnRead2 = (UserReadUnReadInfoManager.ReadUnRead)localIterator.next();
      if (localReadUnRead2.jdField_a_of_type_Long + localReadUnRead2.jdField_a_of_type_Int > l)
      {
        localReadUnRead1.jdField_a_of_type_JavaUtilSet.addAll(localReadUnRead2.jdField_a_of_type_JavaUtilSet);
        localReadUnRead1.b.addAll(localReadUnRead2.b);
      }
    }
    localReadUnRead1.b.removeAll(localReadUnRead1.jdField_a_of_type_JavaUtilSet);
    QLog.e("UserReadUnReadInfoManager", 1, "getEffectUserReadInfo:" + localReadUnRead1);
    return localReadUnRead1;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_Boolean = false;
    QLog.e("UserReadUnReadInfoManager", 1, "clearUserReadUnRead");
  }
  
  public void a(JSONObject paramJSONObject)
  {
    int j = 0;
    UserReadUnReadInfoManager.ReadUnRead localReadUnRead = new UserReadUnReadInfoManager.ReadUnRead();
    localReadUnRead.jdField_a_of_type_Long = NetConnInfoCenter.getServerTime();
    try
    {
      localReadUnRead.jdField_a_of_type_Int = (paramJSONObject.getInt("effective_time") * 1000);
      Object localObject = paramJSONObject.optJSONArray("clicked_rowkey");
      JSONArray localJSONArray = paramJSONObject.optJSONArray("expose_rowkey");
      int i;
      if ((localObject != null) && (((JSONArray)localObject).length() > 0))
      {
        i = 0;
        while (i < ((JSONArray)localObject).length())
        {
          String str = ((JSONArray)localObject).getString(i);
          localReadUnRead.jdField_a_of_type_JavaUtilSet.add(str);
          i += 1;
        }
      }
      if ((localJSONArray != null) && (localJSONArray.length() > 0))
      {
        i = j;
        while (i < localJSONArray.length())
        {
          localObject = localJSONArray.getString(i);
          localReadUnRead.b.add(localObject);
          i += 1;
        }
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("UserReadUnReadInfoManager", 1, "", localException);
      QLog.i("UserReadUnReadInfoManager", 1, "addUserReadInfo:" + paramJSONObject);
      this.jdField_a_of_type_JavaUtilList.add(localReadUnRead);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    UserReadUnReadInfoManager.ReadUnRead localReadUnRead = a();
    return (!localReadUnRead.jdField_a_of_type_JavaUtilSet.isEmpty()) || (!localReadUnRead.b.isEmpty());
  }
  
  public void b()
  {
    QLog.e("UserReadUnReadInfoManager", 1, "onStart");
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void c()
  {
    QLog.e("UserReadUnReadInfoManager", 1, "onStop");
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.readinfo.UserReadUnReadInfoManager
 * JD-Core Version:    0.7.0.1
 */