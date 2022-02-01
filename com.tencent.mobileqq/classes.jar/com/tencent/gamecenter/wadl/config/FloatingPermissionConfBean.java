package com.tencent.gamecenter.wadl.config;

import android.text.TextUtils;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class FloatingPermissionConfBean
{
  public int a;
  public List<String> a;
  public int b = 0;
  
  public FloatingPermissionConfBean()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public static FloatingPermissionConfBean a(QConfItem[] paramArrayOfQConfItem)
  {
    localFloatingPermissionConfBean = new FloatingPermissionConfBean();
    int i = 0;
    try
    {
      Object localObject1;
      while (i < paramArrayOfQConfItem.length)
      {
        localObject1 = new JSONObject(paramArrayOfQConfItem[i].a);
        Object localObject2;
        if (((JSONObject)localObject1).has("isNeedfloatingPermission"))
        {
          localFloatingPermissionConfBean.jdField_a_of_type_Int = ((JSONObject)localObject1).optInt("isNeedfloatingPermission");
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("onParsed isNeedfloatingPermission=");
            ((StringBuilder)localObject2).append(localFloatingPermissionConfBean.jdField_a_of_type_Int);
            QLog.d("Wadl_FloatingPermissionConfBean", 1, ((StringBuilder)localObject2).toString());
          }
        }
        if (((JSONObject)localObject1).has("isNeedInstallPermission"))
        {
          localFloatingPermissionConfBean.b = ((JSONObject)localObject1).optInt("isNeedInstallPermission");
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("onParsed isNeedInstallPermission=");
            ((StringBuilder)localObject2).append(localFloatingPermissionConfBean.b);
            QLog.d("Wadl_FloatingPermissionConfBean", 1, ((StringBuilder)localObject2).toString());
          }
        }
        if (((JSONObject)localObject1).has("needPermissionAppids"))
        {
          localObject1 = ((JSONObject)localObject1).optJSONArray("needPermissionAppids");
          if (localObject1 != null)
          {
            int j = 0;
            while (j < ((JSONArray)localObject1).length())
            {
              localObject2 = ((JSONArray)localObject1).getString(j);
              if (!TextUtils.isEmpty((CharSequence)localObject2)) {
                localFloatingPermissionConfBean.jdField_a_of_type_JavaUtilList.add(localObject2);
              }
              j += 1;
            }
          }
        }
        i += 1;
      }
      return localFloatingPermissionConfBean;
    }
    catch (Throwable paramArrayOfQConfItem)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("FloatingPermissionConfBean parse error e=");
      ((StringBuilder)localObject1).append(paramArrayOfQConfItem.toString());
      QLog.e("Wadl_FloatingPermissionConfBean", 1, ((StringBuilder)localObject1).toString());
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("FloatingPermissionConfBean{isNeedfloatingPermission=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", isNeedInstallPermission=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", needPermissionAddids=");
    localStringBuilder.append(this.jdField_a_of_type_JavaUtilList);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gamecenter.wadl.config.FloatingPermissionConfBean
 * JD-Core Version:    0.7.0.1
 */