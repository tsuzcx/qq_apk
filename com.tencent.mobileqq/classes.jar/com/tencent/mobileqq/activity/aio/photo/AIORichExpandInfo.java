package com.tencent.mobileqq.activity.aio.photo;

import android.os.Looper;
import android.support.v4.util.ArrayMap;
import com.tencent.mobileqq.emotionintegrate.ChatHistoryEmotionAdapter;
import com.tencent.mobileqq.emotionintegrate.EmotionPreviewData;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class AIORichExpandInfo
{
  private ArrayMap<String, List<Object>> a = new ArrayMap();
  private ArrayMap<String, Boolean> b = new ArrayMap();
  private int c = 0;
  
  private void a(int paramInt, String paramString, List<Object> paramList)
  {
    b();
    if ((paramString != null) && (paramInt >= 0))
    {
      if (paramList == null) {
        return;
      }
      paramString = (List)this.a.get(paramString);
      if (paramString == null) {
        return;
      }
      int i = paramString.size();
      while ((i > 0) && (paramInt < paramList.size()))
      {
        paramList.remove(paramInt);
        i -= 1;
      }
      this.c += paramString.size();
    }
  }
  
  private int b(String paramString, int paramInt, List<Object> paramList)
  {
    b();
    if ((paramString != null) && (paramInt > 0))
    {
      if (paramList == null) {
        return -1;
      }
      int i = 0;
      while (i < paramList.size())
      {
        Object localObject = paramList.get(i);
        if (((localObject instanceof String)) && (((String)localObject).equals(paramString))) {
          return i + paramInt;
        }
        i += 1;
      }
    }
    return -1;
  }
  
  private void b(int paramInt, String paramString, List<Object> paramList)
  {
    b();
    if ((paramString != null) && (paramInt >= 0))
    {
      if (paramList == null) {
        return;
      }
      paramString = (List)this.a.get(paramString);
      if (paramString == null) {
        return;
      }
      paramList.addAll(paramInt, paramString);
      this.c -= paramString.size();
    }
  }
  
  public int a()
  {
    b();
    return this.c;
  }
  
  public void a(boolean paramBoolean, int paramInt, List<Object> paramList)
  {
    b();
    if (paramList != null)
    {
      if (paramInt <= 0) {
        return;
      }
      this.a.clear();
      Object localObject2 = null;
      int i = 0;
      Object localObject3;
      Object localObject1;
      while (i < paramList.size())
      {
        localObject3 = paramList.get(i);
        if ((localObject3 instanceof String))
        {
          localObject2 = (List)this.a.get(localObject3);
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            localObject1 = new ArrayList();
            this.a.put((String)localObject3, localObject1);
          }
        }
        else
        {
          localObject1 = localObject2;
          if (localObject2 != null) {
            if ((!(localObject3 instanceof AIORichMediaInfo)) && (localObject3 != AIOImageListModel.k) && (!(localObject3 instanceof EmotionPreviewData)))
            {
              localObject1 = localObject2;
              if (localObject3 != ChatHistoryEmotionAdapter.c) {}
            }
            else
            {
              ((List)localObject2).add(localObject3);
              localObject1 = localObject2;
            }
          }
        }
        i += 1;
        localObject2 = localObject1;
      }
      this.c = 0;
      if (paramBoolean)
      {
        localObject1 = this.b.entrySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject3 = (Map.Entry)((Iterator)localObject1).next();
          localObject2 = (String)((Map.Entry)localObject3).getKey();
          localObject3 = (Boolean)((Map.Entry)localObject3).getValue();
          if ((localObject3 != null) && (!((Boolean)localObject3).booleanValue())) {
            a(b((String)localObject2, paramInt, paramList), (String)localObject2, paramList);
          }
        }
      }
      this.b.clear();
    }
  }
  
  public boolean a(String paramString)
  {
    b();
    paramString = (Boolean)this.b.get(paramString);
    if (paramString != null) {
      return paramString.booleanValue();
    }
    return true;
  }
  
  public boolean a(String paramString, int paramInt, List<Object> paramList)
  {
    b();
    Object localObject = this.a.get(paramString);
    boolean bool2 = false;
    if (localObject == null) {
      return false;
    }
    boolean bool1;
    if (this.b.get(paramString) != null) {
      bool1 = ((Boolean)this.b.get(paramString)).booleanValue();
    } else {
      bool1 = true;
    }
    localObject = this.b;
    if (!bool1) {
      bool2 = true;
    }
    ((ArrayMap)localObject).put(paramString, Boolean.valueOf(bool2));
    paramInt = b(paramString, paramInt, paramList);
    if (!bool1)
    {
      b(paramInt, paramString, paramList);
      return bool1;
    }
    a(paramInt, paramString, paramList);
    return bool1;
  }
  
  public boolean a(List<Object> paramList, int paramInt)
  {
    b();
    boolean bool1 = this.b.isEmpty();
    int i = 0;
    if (!bool1)
    {
      if (paramList == null) {
        return false;
      }
      boolean bool2;
      for (bool1 = false; i < paramList.size(); bool1 = bool2)
      {
        Object localObject = paramList.get(i);
        bool2 = bool1;
        if ((localObject instanceof String))
        {
          ArrayMap localArrayMap = this.b;
          String str = (String)localObject;
          bool2 = bool1;
          if (localArrayMap.get(str) != null)
          {
            bool2 = bool1;
            if (!((Boolean)this.b.get(str)).booleanValue())
            {
              bool2 = bool1;
              if (this.a.get(localObject) != null)
              {
                paramList.addAll(i + paramInt, (Collection)this.a.get(localObject));
                bool2 = true;
              }
            }
          }
        }
        i += 1;
      }
      if (bool1) {
        this.b.clear();
      }
      return bool1;
    }
    return false;
  }
  
  public List<Object> b(String paramString)
  {
    b();
    return (List)this.a.get(paramString);
  }
  
  public void b()
  {
    if (Looper.myLooper() == Looper.getMainLooper()) {
      return;
    }
    throw new RuntimeException("This method must be called on UI thread");
  }
  
  public void b(List<Object> paramList, int paramInt)
  {
    b();
    if (paramList != null)
    {
      if (paramInt <= 0) {
        return;
      }
      int i = 0;
      while (i < paramList.size())
      {
        Object localObject = paramList.get(i);
        if ((localObject instanceof String))
        {
          ArrayMap localArrayMap = this.b;
          String str = (String)localObject;
          if ((localArrayMap.get(str) != null) && (!((Boolean)this.b.get(str)).booleanValue()) && (this.a.get(localObject) != null)) {
            paramList.addAll(i + paramInt, (Collection)this.a.get(localObject));
          }
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIORichExpandInfo
 * JD-Core Version:    0.7.0.1
 */