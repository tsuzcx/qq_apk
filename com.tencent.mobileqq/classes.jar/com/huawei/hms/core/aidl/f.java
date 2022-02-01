package com.huawei.hms.core.aidl;

import android.os.Bundle;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class f
  extends e
{
  protected List<Object> a(Type paramType, Bundle paramBundle)
  {
    int j = paramBundle.getInt("_list_size_");
    ArrayList localArrayList = new ArrayList(j);
    int i = 0;
    while (i < j)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("_list_item_");
      ((StringBuilder)localObject).append(i);
      localObject = paramBundle.get(((StringBuilder)localObject).toString());
      if ((!localObject.getClass().isPrimitive()) && (!(localObject instanceof String)) && (!(localObject instanceof Serializable)))
      {
        if ((localObject instanceof Bundle))
        {
          localObject = (Bundle)localObject;
          int k = ((Bundle)localObject).getInt("_val_type_", -1);
          if (k != 1)
          {
            if (k == 0) {
              localArrayList.add(a((Bundle)localObject, (IMessageEntity)((Class)((java.lang.reflect.ParameterizedType)paramType).getActualTypeArguments()[0]).newInstance()));
            } else {
              throw new InstantiationException("Unknown type can not be supported");
            }
          }
          else {
            throw new InstantiationException("Nested List can not be supported");
          }
        }
      }
      else {
        localArrayList.add(localObject);
      }
      i += 1;
    }
    return localArrayList;
  }
  
  protected void a(String paramString, List paramList, Bundle paramBundle)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("_val_type_", 1);
    localBundle.putInt("_list_size_", paramList.size());
    int i = 0;
    while (i < paramList.size())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("_list_item_");
      localStringBuilder.append(i);
      a(localStringBuilder.toString(), paramList.get(i), localBundle);
      i += 1;
    }
    paramBundle.putBundle(paramString, localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.core.aidl.f
 * JD-Core Version:    0.7.0.1
 */