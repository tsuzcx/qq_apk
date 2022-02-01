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
    if (i < j)
    {
      Object localObject = paramBundle.get("_list_item_" + i);
      if ((localObject.getClass().isPrimitive()) || ((localObject instanceof String)) || ((localObject instanceof Serializable))) {
        localArrayList.add(localObject);
      }
      for (;;)
      {
        i += 1;
        break;
        if ((localObject instanceof Bundle))
        {
          localObject = (Bundle)localObject;
          int k = ((Bundle)localObject).getInt("_val_type_", -1);
          if (k == 1) {
            throw new InstantiationException("Nested List can not be supported");
          }
          if (k != 0) {
            break label179;
          }
          localArrayList.add(a((Bundle)localObject, (IMessageEntity)((Class)((java.lang.reflect.ParameterizedType)paramType).getActualTypeArguments()[0]).newInstance()));
        }
      }
      label179:
      throw new InstantiationException("Unknown type can not be supported");
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
      a("_list_item_" + i, paramList.get(i), localBundle);
      i += 1;
    }
    paramBundle.putBundle(paramString, localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.hms.core.aidl.f
 * JD-Core Version:    0.7.0.1
 */