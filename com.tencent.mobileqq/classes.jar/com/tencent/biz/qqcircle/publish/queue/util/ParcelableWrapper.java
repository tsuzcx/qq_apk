package com.tencent.biz.qqcircle.publish.queue.util;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class ParcelableWrapper
  implements Parcelable
{
  public static final Parcelable.Creator<ParcelableWrapper> CREATOR = new ParcelableWrapper.1();
  private static ConcurrentHashMap<String, ParcelableWrapper.ParcableInfo> b = new ConcurrentHashMap(32, 0.75F, 4);
  private static ParcelableWrapper[] c = new ParcelableWrapper[6];
  private static ClassLoader d;
  private static final Set<ClassLoader> e = Collections.newSetFromMap(new ConcurrentHashMap());
  private SmartParcelable a;
  
  private ParcelableWrapper() {}
  
  protected ParcelableWrapper(SmartParcelable paramSmartParcelable)
  {
    this.a = paramSmartParcelable;
  }
  
  private static ParcelableWrapper.ParcableInfo a(Class paramClass)
  {
    Object localObject1 = paramClass.getDeclaredFields();
    ParcelableWrapper.ParcableInfo localParcableInfo = new ParcelableWrapper.ParcableInfo();
    ParcelableWrapper.ParcableInfo.a(localParcableInfo, paramClass);
    List localList1 = ParcelableWrapper.ParcableInfo.a(localParcableInfo);
    List localList2 = ParcelableWrapper.ParcableInfo.b(localParcableInfo);
    Object localObject2 = paramClass.getSuperclass();
    if (SmartParcelable.class.isAssignableFrom((Class)localObject2))
    {
      localObject2 = b(((Class)localObject2).getName(), (Class)localObject2);
      localList1.addAll(ParcelableWrapper.ParcableInfo.a((ParcelableWrapper.ParcableInfo)localObject2));
      localList2.addAll(ParcelableWrapper.ParcableInfo.b((ParcelableWrapper.ParcableInfo)localObject2));
    }
    if (((localObject1 == null) || (localObject1.length <= 0)) && (localList2.size() <= 0))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("SmartParcelable must have filed to Parcel:");
      ((StringBuilder)localObject1).append(paramClass);
      QLog.e("ParcelableWrapper", 1, ((StringBuilder)localObject1).toString());
      return localParcableInfo;
    }
    int j = localObject1.length;
    int i = 0;
    while (i < j)
    {
      paramClass = localObject1[i];
      if (paramClass.getAnnotation(NeedParcel.class) != null)
      {
        paramClass.setAccessible(true);
        localList1.add(paramClass);
        paramClass = paramClass.getType();
        if (paramClass == Integer.TYPE) {
          localList2.add(Integer.valueOf(1));
        } else if (paramClass == String.class) {
          localList2.add(Integer.valueOf(5));
        } else if (paramClass == Long.TYPE) {
          localList2.add(Integer.valueOf(2));
        } else if (paramClass == Double.TYPE) {
          localList2.add(Integer.valueOf(7));
        } else if (paramClass == Float.TYPE) {
          localList2.add(Integer.valueOf(8));
        } else if (paramClass == Boolean.TYPE) {
          localList2.add(Integer.valueOf(3));
        } else if (paramClass == Byte.TYPE) {
          localList2.add(Integer.valueOf(9));
        } else if (SmartParcelable.class.isAssignableFrom(paramClass)) {
          localList2.add(Integer.valueOf(6));
        } else if (Parcelable.class.isAssignableFrom(paramClass)) {
          localList2.add(Integer.valueOf(4));
        } else if (List.class.isAssignableFrom(paramClass)) {
          localList2.add(Integer.valueOf(10));
        } else if (Map.class.isAssignableFrom(paramClass)) {
          localList2.add(Integer.valueOf(11));
        } else if (Serializable.class.isAssignableFrom(paramClass)) {
          localList2.add(Integer.valueOf(12));
        } else if ([Ljava.lang.String.class.isAssignableFrom(paramClass)) {
          localList2.add(Integer.valueOf(13));
        } else if ([B.class.isAssignableFrom(paramClass)) {
          localList2.add(Integer.valueOf(14));
        } else {
          localList2.add(Integer.valueOf(0));
        }
      }
      i += 1;
    }
    return localParcableInfo;
  }
  
  public static ParcelableWrapper a(SmartParcelable paramSmartParcelable)
  {
    ParcelableWrapper[] arrayOfParcelableWrapper = c;
    int i = 0;
    for (;;)
    {
      ParcelableWrapper localParcelableWrapper;
      if (i < 6)
      {
        localParcelableWrapper = arrayOfParcelableWrapper[i];
        if (localParcelableWrapper != null) {
          arrayOfParcelableWrapper[i] = null;
        }
      }
      else
      {
        try
        {
          localParcelableWrapper.a = paramSmartParcelable;
          return localParcelableWrapper;
        }
        finally
        {
          break label54;
        }
        return new ParcelableWrapper(paramSmartParcelable);
        label54:
        for (;;)
        {
          throw paramSmartParcelable;
        }
      }
      i += 1;
    }
  }
  
  public static <T extends SmartParcelable> T a(Parcel paramParcel)
  {
    return ((ParcelableWrapper)CREATOR.createFromParcel(paramParcel)).a();
  }
  
  public static Class<?> a(ClassLoader paramClassLoader, String paramString)
  {
    try
    {
      paramClassLoader = paramClassLoader.loadClass(paramString);
    }
    catch (ClassNotFoundException paramClassLoader)
    {
      if (e.isEmpty()) {
        break label80;
      }
    }
    paramClassLoader = null;
    if (paramClassLoader != null) {
      return paramClassLoader;
    }
    Iterator localIterator = e.iterator();
    while (localIterator.hasNext())
    {
      try
      {
        Class localClass = ((ClassLoader)localIterator.next()).loadClass(paramString);
        return localClass;
      }
      catch (ClassNotFoundException localClassNotFoundException) {}
      if (!localIterator.hasNext()) {
        throw localClassNotFoundException;
      }
    }
    return paramClassLoader;
    for (;;)
    {
      label80:
      throw paramClassLoader;
    }
  }
  
  protected static ArrayList a(Parcel paramParcel, ClassLoader paramClassLoader)
  {
    int i = paramParcel.readInt();
    if (i < 0) {
      return null;
    }
    ArrayList localArrayList = new ArrayList(i);
    a(paramParcel, localArrayList, i, paramClassLoader);
    return localArrayList;
  }
  
  public static void a(Parcel paramParcel, int paramInt, SmartParcelable paramSmartParcelable)
  {
    if (paramSmartParcelable == null)
    {
      paramParcel.writeString(null);
      return;
    }
    paramSmartParcelable = a(paramSmartParcelable);
    paramSmartParcelable.writeToParcel(paramParcel, paramInt);
    a(paramSmartParcelable);
  }
  
  public static void a(Parcel paramParcel, List paramList)
  {
    if (paramList == null)
    {
      paramParcel.writeInt(-1);
      return;
    }
    int j = paramList.size();
    int i = 0;
    paramParcel.writeInt(j);
    while (i < j)
    {
      Object localObject = paramList.get(i);
      if ((localObject instanceof SmartParcelable))
      {
        localObject = a((SmartParcelable)localObject);
        paramParcel.writeValue(localObject);
        a((ParcelableWrapper)localObject);
      }
      else
      {
        paramParcel.writeValue(localObject);
      }
      i += 1;
    }
  }
  
  private static void a(Parcel paramParcel, List paramList, int paramInt, ClassLoader paramClassLoader)
  {
    while (paramInt > 0)
    {
      Object localObject = paramParcel.readValue(paramClassLoader);
      if ((localObject instanceof ParcelableWrapper)) {
        paramList.add(((ParcelableWrapper)localObject).a());
      } else {
        paramList.add(localObject);
      }
      paramInt -= 1;
    }
  }
  
  public static void a(Parcel paramParcel, Map<String, Object> paramMap)
  {
    if (paramMap == null)
    {
      paramParcel.writeInt(-1);
      return;
    }
    paramMap = paramMap.entrySet();
    paramParcel.writeInt(paramMap.size());
    paramMap = paramMap.iterator();
    while (paramMap.hasNext())
    {
      Object localObject = (Map.Entry)paramMap.next();
      paramParcel.writeValue(((Map.Entry)localObject).getKey());
      localObject = ((Map.Entry)localObject).getValue();
      if ((localObject instanceof SmartParcelable))
      {
        localObject = a((SmartParcelable)localObject);
        paramParcel.writeValue(localObject);
        a((ParcelableWrapper)localObject);
      }
      else
      {
        paramParcel.writeValue(localObject);
      }
    }
  }
  
  static void a(Parcel paramParcel, Map paramMap, int paramInt, ClassLoader paramClassLoader)
  {
    while (paramInt > 0)
    {
      Object localObject1 = paramParcel.readValue(paramClassLoader);
      Object localObject2 = paramParcel.readValue(paramClassLoader);
      if ((localObject2 instanceof ParcelableWrapper)) {
        paramMap.put(localObject1, ((ParcelableWrapper)localObject2).a());
      } else {
        paramMap.put(localObject1, localObject2);
      }
      paramInt -= 1;
    }
  }
  
  /* Error */
  public static void a(ParcelableWrapper paramParcelableWrapper)
  {
    // Byte code:
    //   0: getstatic 40	com/tencent/biz/qqcircle/publish/queue/util/ParcelableWrapper:c	[Lcom/tencent/biz/qqcircle/publish/queue/util/ParcelableWrapper;
    //   3: astore_2
    //   4: aload_2
    //   5: monitorenter
    //   6: iconst_0
    //   7: istore_1
    //   8: iload_1
    //   9: bipush 6
    //   11: if_icmpge +16 -> 27
    //   14: aload_2
    //   15: iload_1
    //   16: aaload
    //   17: ifnonnull +24 -> 41
    //   20: aload_2
    //   21: iload_1
    //   22: aload_0
    //   23: aastore
    //   24: aload_2
    //   25: monitorexit
    //   26: return
    //   27: aload_2
    //   28: monitorexit
    //   29: return
    //   30: astore_0
    //   31: aload_2
    //   32: monitorexit
    //   33: goto +5 -> 38
    //   36: aload_0
    //   37: athrow
    //   38: goto -2 -> 36
    //   41: iload_1
    //   42: iconst_1
    //   43: iadd
    //   44: istore_1
    //   45: goto -37 -> 8
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	48	0	paramParcelableWrapper	ParcelableWrapper
    //   7	38	1	i	int
    //   3	29	2	arrayOfParcelableWrapper	ParcelableWrapper[]
    // Exception table:
    //   from	to	target	type
    //   24	26	30	finally
    //   27	29	30	finally
    //   31	33	30	finally
  }
  
  private static ParcelableWrapper.ParcableInfo b(String paramString, Class paramClass)
  {
    if (paramString != null)
    {
      Object localObject = (ParcelableWrapper.ParcableInfo)b.get(paramString);
      if (localObject == null)
      {
        localObject = paramClass;
        if (paramClass == null) {
          try
          {
            localObject = a(c(), paramString);
          }
          catch (ClassNotFoundException paramClass)
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("getParcableInfo.forName:");
            ((StringBuilder)localObject).append(paramString);
            QLog.e("ParcelableWrapper", 1, ((StringBuilder)localObject).toString(), paramClass);
            paramClass = new StringBuilder();
            paramClass.append("class forname:");
            paramClass.append(paramString);
            throw new RuntimeException(paramClass.toString());
          }
        }
        try
        {
          ParcelableWrapper.ParcableInfo localParcableInfo = (ParcelableWrapper.ParcableInfo)b.get(paramString);
          paramClass = localParcableInfo;
          if (localParcableInfo == null)
          {
            paramClass = a((Class)localObject);
            b.put(paramString, paramClass);
          }
          return paramClass;
        }
        finally {}
      }
      return localObject;
    }
    throw new NullPointerException("getParcableInfo.clsName can not be null!");
  }
  
  public static HashMap b(Parcel paramParcel, ClassLoader paramClassLoader)
  {
    int i = paramParcel.readInt();
    if (i < 0) {
      return null;
    }
    HashMap localHashMap = new HashMap(i);
    a(paramParcel, localHashMap, i, paramClassLoader);
    return localHashMap;
  }
  
  private static ClassLoader c()
  {
    ClassLoader localClassLoader = d;
    if (localClassLoader != null) {
      return localClassLoader;
    }
    if (localClassLoader == null) {
      d = ParcelableWrapper.class.getClassLoader();
    }
    return d;
  }
  
  public SmartParcelable a()
  {
    return this.a;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    Object localObject1 = this.a;
    if (localObject1 == null)
    {
      paramParcel.writeString(null);
      return;
    }
    Object localObject2 = localObject1.getClass();
    localObject1 = b(((Class)localObject2).getName(), (Class)localObject2);
    Object localObject3 = ParcelableWrapper.ParcableInfo.a((ParcelableWrapper.ParcableInfo)localObject1);
    localObject1 = ParcelableWrapper.ParcableInfo.b((ParcelableWrapper.ParcableInfo)localObject1);
    for (;;)
    {
      try
      {
        paramParcel.writeString(((Class)localObject2).getName());
        localObject2 = ((List)localObject3).iterator();
        int i = 0;
        if (((Iterator)localObject2).hasNext()) {
          localObject3 = (Field)((Iterator)localObject2).next();
        }
        switch (((Integer)((List)localObject1).get(i)).intValue())
        {
        case 14: 
          paramParcel.writeByteArray((byte[])((Field)localObject3).get(this.a));
          break;
        case 13: 
          paramParcel.writeStringArray((String[])((Field)localObject3).get(this.a));
          break;
        case 12: 
          paramParcel.writeSerializable((Serializable)((Field)localObject3).get(this.a));
          break;
        case 11: 
          a(paramParcel, (Map)((Field)localObject3).get(this.a));
          break;
        case 10: 
          a(paramParcel, (List)((Field)localObject3).get(this.a));
          break;
        case 9: 
          paramParcel.writeByte(((Field)localObject3).getByte(this.a));
          break;
        case 8: 
          paramParcel.writeFloat(((Field)localObject3).getFloat(this.a));
          break;
        case 7: 
          paramParcel.writeDouble(((Field)localObject3).getDouble(this.a));
          break;
        case 6: 
          localObject3 = a((SmartParcelable)((Field)localObject3).get(this.a));
          paramParcel.writeParcelable((Parcelable)localObject3, paramInt);
          a((ParcelableWrapper)localObject3);
          break;
        case 5: 
          paramParcel.writeString((String)((Field)localObject3).get(this.a));
          break;
        case 4: 
          paramParcel.writeParcelable((Parcelable)((Field)localObject3).get(this.a), paramInt);
          break;
        case 3: 
          if (!((Field)localObject3).getBoolean(this.a)) {
            break label501;
          }
          b1 = 1;
          paramParcel.writeByte(b1);
          break;
        case 2: 
          paramParcel.writeLong(((Field)localObject3).getLong(this.a));
          break;
        case 1: 
          paramParcel.writeInt(((Field)localObject3).getInt(this.a));
          break;
        case 0: 
          paramParcel.writeValue(((Field)localObject3).get(this.a));
          i += 1;
          continue;
          return;
        }
      }
      catch (Throwable paramParcel)
      {
        QLog.e("ParcelableWrapper", 1, "ParcelableWrapper.writeToParcel:", paramParcel);
      }
      continue;
      label501:
      byte b1 = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.queue.util.ParcelableWrapper
 * JD-Core Version:    0.7.0.1
 */