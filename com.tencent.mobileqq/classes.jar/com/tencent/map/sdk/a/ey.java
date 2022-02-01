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
    Object localObject1 = paramClass;
    paramClass = paramfd;
    for (paramfd = (fd<?>)localObject1; paramfd != Object.class; paramfd = paramClass.a)
    {
      Field[] arrayOfField = paramfd.getDeclaredFields();
      int j = arrayOfField.length;
      int i = 0;
      for (;;)
      {
        localObject1 = this;
        if (i >= j) {
          break label283;
        }
        Field localField = arrayOfField[i];
        boolean bool1 = ((ey)localObject1).a(localField, true);
        boolean bool2 = ((ey)localObject1).a(localField, false);
        if ((!bool1) && (!bool2)) {
          break label230;
        }
        localField.setAccessible(true);
        Object localObject2 = eh.a(paramClass.b, paramfd, localField.getGenericType());
        SerializedName localSerializedName = (SerializedName)localField.getAnnotation(SerializedName.class);
        if (localSerializedName == null) {
          localObject1 = ((ey)localObject1).b.a(localField);
        } else {
          localObject1 = localSerializedName.value();
        }
        localObject2 = fd.a((Type)localObject2);
        localObject1 = new ey.1(this, (String)localObject1, bool1, bool2, paramdn, (fd)localObject2, localField, eo.a(((fd)localObject2).a));
        localObject1 = (ey.b)localLinkedHashMap.put(((ey.b)localObject1).g, localObject1);
        if (localObject1 != null) {
          break;
        }
        label230:
        i += 1;
      }
      paramdn = new StringBuilder();
      paramdn.append(localType);
      paramdn.append(" declares multiple JSON fields named ");
      paramdn.append(((ey.b)localObject1).g);
      throw new IllegalArgumentException(paramdn.toString());
      label283:
      paramClass = fd.a(eh.a(paramClass.b, paramfd, paramfd.getGenericSuperclass()));
    }
    return localLinkedHashMap;
  }
  
  private boolean a(Field paramField, boolean paramBoolean)
  {
    if (!this.c.a(paramField.getType(), paramBoolean))
    {
      Object localObject = this.c;
      if ((((ej)localObject).c & paramField.getModifiers()) != 0) {}
      for (;;)
      {
        i = 1;
        break label257;
        if (((((ej)localObject).b == -1.0D) || (((ej)localObject).a((Since)paramField.getAnnotation(Since.class), (Until)paramField.getAnnotation(Until.class)))) && (!paramField.isSynthetic()))
        {
          if (((ej)localObject).e)
          {
            Expose localExpose = (Expose)paramField.getAnnotation(Expose.class);
            if (localExpose == null) {
              continue;
            }
            if (paramBoolean) {
              if (localExpose.serialize()) {
                break label144;
              }
            } else {
              if (!localExpose.deserialize()) {
                continue;
              }
            }
          }
          label144:
          if (((((ej)localObject).d) || (!ej.b(paramField.getType()))) && (!ej.a(paramField.getType())))
          {
            if (paramBoolean) {
              localObject = ((ej)localObject).f;
            } else {
              localObject = ((ej)localObject).g;
            }
            if (((List)localObject).isEmpty()) {
              break;
            }
            new dk(paramField);
            paramField = ((List)localObject).iterator();
            do
            {
              if (!paramField.hasNext()) {
                break;
              }
            } while (!((dj)paramField.next()).a());
          }
        }
      }
      int i = 0;
      label257:
      if (i == 0) {
        return true;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.ey
 * JD-Core Version:    0.7.0.1
 */