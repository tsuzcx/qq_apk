package com.tencent.ditto.reflect;

import com.tencent.ditto.utils.DittoLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DittoFieldValue
  extends DittoValue
{
  String fieldName;
  private List<DittoFieldValue.AbsValueProcessor> processors;
  
  private List<String> getFieldTokens(String paramString)
  {
    ArrayList localArrayList = new ArrayList(3);
    Object localObject = new StringBuilder();
    char[] arrayOfChar = paramString.toCharArray();
    int m = arrayOfChar.length;
    int i = 0;
    int j = 0;
    paramString = (String)localObject;
    while (i < m)
    {
      char c = arrayOfChar[i];
      int k;
      if (c == '\'')
      {
        k = j ^ 0x1;
        paramString.append(c);
        localObject = paramString;
      }
      else if ((c == ' ') && (j == 0))
      {
        localObject = paramString;
        k = j;
        if (paramString.length() != 0)
        {
          localArrayList.add(paramString.toString());
          localObject = new StringBuilder();
          k = j;
        }
      }
      else if ((c != '[') && (c != ']') && (c != '.'))
      {
        paramString.append(c);
        localObject = paramString;
        k = j;
      }
      else
      {
        localObject = paramString;
        if (paramString.length() != 0)
        {
          localArrayList.add(paramString.toString());
          localObject = new StringBuilder();
        }
        localArrayList.add(Character.valueOf(c).toString());
        k = j;
      }
      i += 1;
      paramString = (String)localObject;
      j = k;
    }
    if (paramString.length() != 0) {
      localArrayList.add(paramString.toString());
    }
    return localArrayList;
  }
  
  private void loadProcessors()
  {
    if (this.processors == null)
    {
      Object localObject = getFieldTokens(this.fieldName);
      this.processors = new ArrayList();
      localObject = ((List)localObject).iterator();
      int i = 0;
      for (;;)
      {
        for (;;)
        {
          if (!((Iterator)localObject).hasNext()) {
            break label168;
          }
          String str = (String)((Iterator)localObject).next();
          if ("[".equals(str)) {
            i = 1;
          } else {
            if (i == 0) {
              break label125;
            }
          }
          try
          {
            i = Integer.parseInt(str);
            this.processors.add(new DittoFieldValue.ListValueProcessor(this, Integer.valueOf(i)));
          }
          catch (Throwable localThrowable)
          {
            label103:
            label125:
            break label103;
          }
        }
        this.processors.add(new DittoFieldValue.MapValueProcessor(this, str));
        break;
        if ((!"]".equals(str)) && (!".".equals(str))) {
          this.processors.add(new DittoFieldValue.FieldValueProcessor(this, str));
        }
      }
    }
    label168:
  }
  
  private void setValue(Object paramObject1, Object paramObject2)
  {
    loadProcessors();
    Object localObject1 = this.processors;
    Iterator localIterator;
    if (localObject1 != null)
    {
      if (((List)localObject1).size() == 0) {
        return;
      }
      localIterator = this.processors.iterator();
      localObject1 = paramObject1;
    }
    for (;;)
    {
      if (!localIterator.hasNext()) {
        break label115;
      }
      localObject1 = (DittoFieldValue.AbsValueProcessor)localIterator.next();
      try
      {
        Object localObject2 = ((DittoFieldValue.AbsValueProcessor)localObject1).getObjectValue(paramObject1);
        localObject1 = paramObject1;
        paramObject1 = localObject2;
      }
      catch (NullPointerException localNullPointerException)
      {
        label72:
        break label72;
      }
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("current template is accessing field of null value, tpl:");
    ((StringBuilder)localObject1).append(this.fieldName);
    DittoLog.e("DITTO_UI", ((StringBuilder)localObject1).toString(), new RuntimeException());
    break label117;
    label115:
    paramObject1 = localObject1;
    label117:
    localObject1 = this.processors;
    localObject1 = (DittoFieldValue.AbsValueProcessor)((List)localObject1).get(((List)localObject1).size() - 1);
    if ((localObject1 != null) && (paramObject1 != null)) {
      ((DittoFieldValue.AbsValueProcessor)localObject1).setValue(paramObject1, paramObject2);
    }
  }
  
  public Object getValue(Object paramObject)
  {
    loadProcessors();
    Iterator localIterator = this.processors.iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        break label84;
      }
      Object localObject = (DittoFieldValue.AbsValueProcessor)localIterator.next();
      try
      {
        localObject = ((DittoFieldValue.AbsValueProcessor)localObject).getObjectValue(paramObject);
        paramObject = localObject;
      }
      catch (NullPointerException localNullPointerException)
      {
        label44:
        break label44;
      }
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("current template is accessing field of null value, tpl:");
    ((StringBuilder)localObject).append(this.fieldName);
    DittoLog.e("DITTO_UI", ((StringBuilder)localObject).toString(), new RuntimeException());
    label84:
    return paramObject;
  }
  
  public void setValue(Object paramObject, String paramString)
  {
    setValue(paramObject, paramString);
  }
  
  public void setValue(Object paramObject, boolean paramBoolean)
  {
    setValue(paramObject, Boolean.valueOf(paramBoolean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ditto.reflect.DittoFieldValue
 * JD-Core Version:    0.7.0.1
 */