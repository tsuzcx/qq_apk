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
    StringBuilder localStringBuilder = new StringBuilder();
    char[] arrayOfChar = paramString.toCharArray();
    int k = arrayOfChar.length;
    int j = 0;
    int i = 0;
    paramString = localStringBuilder;
    char c;
    if (j < k)
    {
      c = arrayOfChar[j];
      if (c == '\'') {
        if (i == 0)
        {
          i = 1;
          label63:
          paramString.append(c);
        }
      }
      for (;;)
      {
        j += 1;
        break;
        i = 0;
        break label63;
        if ((c != ' ') || (i != 0)) {
          break label123;
        }
        if (paramString.length() == 0) {
          break label192;
        }
        localArrayList.add(paramString.toString());
        paramString = new StringBuilder();
      }
      label123:
      if ((c == '[') || (c == ']') || (c == '.'))
      {
        if (paramString.length() == 0) {
          break label217;
        }
        localArrayList.add(paramString.toString());
        paramString = new StringBuilder();
      }
    }
    label192:
    label217:
    for (;;)
    {
      localArrayList.add(Character.valueOf(c).toString());
      break;
      paramString.append(c);
      break;
      if (paramString.length() != 0) {
        localArrayList.add(paramString.toString());
      }
      return localArrayList;
    }
  }
  
  private void loadProcessors()
  {
    if (this.processors == null)
    {
      Object localObject = getFieldTokens(this.fieldName);
      this.processors = new ArrayList();
      localObject = ((List)localObject).iterator();
      int i = 0;
      if (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        if ("[".equals(str)) {
          i = 1;
        }
        for (;;)
        {
          for (;;)
          {
            break;
            if (i == 0) {
              break label131;
            }
            try
            {
              i = Integer.parseInt(str);
              this.processors.add(new DittoFieldValue.ListValueProcessor(this, Integer.valueOf(i)));
              i = 0;
            }
            catch (Throwable localThrowable)
            {
              this.processors.add(new DittoFieldValue.MapValueProcessor(this, str));
              i = 0;
            }
          }
          continue;
          label131:
          if (("]".equals(str)) || (".".equals(str))) {
            break;
          }
          this.processors.add(new DittoFieldValue.FieldValueProcessor(this, str));
        }
      }
    }
  }
  
  private void setValue(Object paramObject1, Object paramObject2)
  {
    loadProcessors();
    if ((this.processors == null) || (this.processors.size() == 0)) {
      return;
    }
    Iterator localIterator = this.processors.iterator();
    Object localObject2 = paramObject1;
    Object localObject1 = paramObject1;
    paramObject1 = localObject2;
    for (;;)
    {
      if (localIterator.hasNext())
      {
        localObject1 = (DittoFieldValue.AbsValueProcessor)localIterator.next();
        try
        {
          localObject1 = ((DittoFieldValue.AbsValueProcessor)localObject1).getObjectValue(paramObject1);
          localObject2 = paramObject1;
          paramObject1 = localObject1;
          localObject1 = localObject2;
        }
        catch (NullPointerException localNullPointerException)
        {
          DittoLog.e("DITTO_UI", "current template is accessing field of null value, tpl:" + this.fieldName, new RuntimeException());
        }
      }
    }
    for (;;)
    {
      DittoFieldValue.AbsValueProcessor localAbsValueProcessor = (DittoFieldValue.AbsValueProcessor)this.processors.get(this.processors.size() - 1);
      if ((localAbsValueProcessor == null) || (paramObject1 == null)) {
        break;
      }
      localAbsValueProcessor.setValue(paramObject1, paramObject2);
      return;
      paramObject1 = localAbsValueProcessor;
    }
  }
  
  public Object getValue(Object paramObject)
  {
    loadProcessors();
    Iterator localIterator = this.processors.iterator();
    for (;;)
    {
      if (localIterator.hasNext())
      {
        Object localObject = (DittoFieldValue.AbsValueProcessor)localIterator.next();
        try
        {
          localObject = ((DittoFieldValue.AbsValueProcessor)localObject).getObjectValue(paramObject);
          paramObject = localObject;
        }
        catch (NullPointerException localNullPointerException)
        {
          DittoLog.e("DITTO_UI", "current template is accessing field of null value, tpl:" + this.fieldName, new RuntimeException());
        }
      }
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ditto.reflect.DittoFieldValue
 * JD-Core Version:    0.7.0.1
 */