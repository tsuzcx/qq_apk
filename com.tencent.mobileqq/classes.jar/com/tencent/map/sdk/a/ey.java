package com.tencent.map.sdk.a;

import com.tencent.lbssearch.common.gson.annotations.Expose;
import com.tencent.lbssearch.common.gson.annotations.SerializedName;
import com.tencent.lbssearch.common.gson.annotations.Since;
import com.tencent.lbssearch.common.gson.annotations.Until;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class ey
  implements ef
{
  private final ei a;
  private final dm b;
  private final ej c;
  
  public ey(ei paramei, dm paramdm, ej paramej)
  {
    this.a = paramei;
    this.b = paramdm;
    this.c = paramej;
  }
  
  private Map<String, ey.b> a(dn paramdn, fd<?> paramfd, Class<?> paramClass)
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    if (paramClass.isInterface()) {
      return localLinkedHashMap;
    }
    Type localType = paramfd.b;
    while (paramClass != Object.class)
    {
      Field[] arrayOfField = paramClass.getDeclaredFields();
      int j = arrayOfField.length;
      int i = 0;
      while (i < j)
      {
        Field localField = arrayOfField[i];
        boolean bool1 = a(localField, true);
        boolean bool2 = a(localField, false);
        if ((bool1) || (bool2))
        {
          localField.setAccessible(true);
          Object localObject2 = eh.a(paramfd.b, paramClass, localField.getGenericType());
          Object localObject1 = (SerializedName)localField.getAnnotation(SerializedName.class);
          if (localObject1 == null) {}
          for (localObject1 = this.b.a(localField);; localObject1 = ((SerializedName)localObject1).value())
          {
            localObject2 = fd.a((Type)localObject2);
            localObject1 = new ey.1(this, (String)localObject1, bool1, bool2, paramdn, (fd)localObject2, localField, eo.a(((fd)localObject2).a));
            localObject1 = (ey.b)localLinkedHashMap.put(((ey.b)localObject1).g, localObject1);
            if (localObject1 == null) {
              break;
            }
            throw new IllegalArgumentException(localType + " declares multiple JSON fields named " + ((ey.b)localObject1).g);
          }
        }
        i += 1;
      }
      paramfd = fd.a(eh.a(paramfd.b, paramClass, paramClass.getGenericSuperclass()));
      paramClass = paramfd.a;
    }
    return localLinkedHashMap;
  }
  
  private boolean a(Field paramField, boolean paramBoolean)
  {
    if (!this.c.a(paramField.getType(), paramBoolean))
    {
      Object localObject = this.c;
      int i;
      if ((((ej)localObject).c & paramField.getModifiers()) != 0) {
        i = 1;
      }
      while (i == 0)
      {
        return true;
        if ((((ej)localObject).b != -1.0D) && (!((ej)localObject).a((Since)paramField.getAnnotation(Since.class), (Until)paramField.getAnnotation(Until.class)))) {
          i = 1;
        } else {
          label267:
          if (paramField.isSynthetic())
          {
            i = 1;
          }
          else
          {
            if (((ej)localObject).e)
            {
              Expose localExpose = (Expose)paramField.getAnnotation(Expose.class);
              if (localExpose != null)
              {
                if (!paramBoolean) {
                  break label140;
                }
                if (localExpose.serialize()) {
                  break label150;
                }
              }
              label140:
              while (!localExpose.deserialize())
              {
                i = 1;
                break;
              }
            }
            label150:
            if ((!((ej)localObject).d) && (ej.b(paramField.getType())))
            {
              i = 1;
            }
            else if (ej.a(paramField.getType()))
            {
              i = 1;
            }
            else
            {
              if (paramBoolean) {}
              for (localObject = ((ej)localObject).f;; localObject = ((ej)localObject).g)
              {
                if (((List)localObject).isEmpty()) {
                  break label267;
                }
                new dk(paramField);
                paramField = ((List)localObject).iterator();
                do
                {
                  if (!paramField.hasNext()) {
                    break;
                  }
                } while (!((dj)paramField.next()).a());
                i = 1;
                break;
              }
              i = 0;
            }
          }
        }
      }
    }
    return false;
  }
  
  public final <T> ee<T> a(dn paramdn, fd<T> paramfd)
  {
    Class localClass = paramfd.a;
    if (!Object.class.isAssignableFrom(localClass)) {
      return null;
    }
    return new ey.a(this, this.a.a(paramfd), a(paramdn, paramfd, localClass), (byte)0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.map.sdk.a.ey
 * JD-Core Version:    0.7.0.1
 */