package com.tencent.mobileqq.ark.config;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

class ArkJSONPath
{
  private String a;
  private ArrayList<ArkJSONPathElement> b;
  
  public ArkJSONPath(String paramString)
  {
    this.a = paramString;
    this.b = a(paramString);
  }
  
  public Object a(Map<String, Object> paramMap)
  {
    if (paramMap == null) {
      return null;
    }
    if (this.b.size() == 0) {
      return null;
    }
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      paramMap = ((ArkJSONPathElement)localIterator.next()).a(paramMap);
    }
    return paramMap;
  }
  
  public ArrayList<ArkJSONPathElement> a(String paramString)
  {
    ArrayList localArrayList = b(paramString);
    if (localArrayList != null)
    {
      if (localArrayList.size() == 0) {
        return null;
      }
      if (!((String)localArrayList.get(0)).equals("$")) {
        return null;
      }
      paramString = new ArrayList();
      int i = 1;
      try
      {
        while (i < localArrayList.size())
        {
          localObject = (String)localArrayList.get(i);
          if (TextUtils.isEmpty((CharSequence)localObject)) {
            return null;
          }
          if (((String)localObject).charAt(0) == '.')
          {
            paramString.add(new ArkJSONPathObject(((String)localObject).substring(1)));
          }
          else
          {
            String str = ArkJSONPathUtil.a().b((String)localObject);
            if (!TextUtils.isEmpty(str))
            {
              paramString.add(new ArkJSONPathObject(str));
            }
            else
            {
              localObject = ArkJSONPathUtil.a().a((String)localObject);
              if (TextUtils.isEmpty((CharSequence)localObject)) {
                break label184;
              }
              paramString.add(new ArkJSONPathArray(Integer.parseInt((String)localObject)));
            }
          }
          i += 1;
          continue;
          label184:
          return null;
        }
      }
      catch (Exception localException)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("parsePattern error:");
        ((StringBuilder)localObject).append(localException.getMessage());
        QLog.e("ArkMsgReplyConfigMgr", 1, ((StringBuilder)localObject).toString());
      }
      return paramString;
    }
    return null;
  }
  
  public ArrayList<String> b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = new StringBuilder();
    int j = 0;
    int i = 0;
    while (j < paramString.length())
    {
      char c = paramString.charAt(j);
      if (i == 0)
      {
        if (c != '.')
        {
          localObject2 = localObject1;
          if (c != '[') {
            break label129;
          }
        }
        if (((StringBuilder)localObject1).length() == 0) {
          return null;
        }
        localArrayList.add(((StringBuilder)localObject1).toString());
        localObject2 = new StringBuilder();
        localObject1 = localObject2;
        if (c == '[')
        {
          i = 1;
          break label129;
        }
      }
      else
      {
        localObject2 = localObject1;
        if (c != ']') {
          break label129;
        }
      }
      i = 0;
      Object localObject2 = localObject1;
      label129:
      ((StringBuilder)localObject2).append(c);
      j += 1;
      localObject1 = localObject2;
    }
    if (((StringBuilder)localObject1).length() == 0) {
      return null;
    }
    localArrayList.add(((StringBuilder)localObject1).toString());
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.config.ArkJSONPath
 * JD-Core Version:    0.7.0.1
 */