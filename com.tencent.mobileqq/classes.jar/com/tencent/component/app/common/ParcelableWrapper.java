package com.tencent.component.app.common;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.mobileqq.pluginsdk.PluginUtils;
import com.tencent.qphone.base.util.BaseApplication;
import cooperation.qzone.QzonePluginProxyActivity;
import cooperation.qzone.util.QZLog;
import java.io.File;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
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
  private static final int ARRAY_LIST_TYPE = 10;
  private static final int BOOL_TYPE = 3;
  private static final int BYTEARRAY_TYPE = 14;
  private static final int BYTE_TYPE = 9;
  public static final Parcelable.Creator<ParcelableWrapper> CREATOR = new ParcelableWrapper.1();
  private static final int DOUBLE_TYPE = 7;
  private static final int FLOAT_TYPE = 8;
  private static final int INT_TYPE = 1;
  private static final int LONG_TYPE = 2;
  private static final int MAP_TYPE = 11;
  private static final int PARCABLE_TYPE = 4;
  public static final int POOL_SIZE = 6;
  private static final int SERIALIZABLE_TYPE = 12;
  private static final int SMART_PARCEL_TYPE = 6;
  private static final int STRINGARRAY_TYPE = 13;
  private static final int STRING_TYPE = 5;
  private static final int TYPE_UNDEFINE = 0;
  private static ClassLoader sClassLoader;
  private static ParcelableWrapper[] sOwnedPool = new ParcelableWrapper[6];
  private static ConcurrentHashMap<String, ParcelableWrapper.ParcableInfo> sParcableCache = new ConcurrentHashMap(32, 0.75F, 4);
  private SmartParcelable obj;
  
  private ParcelableWrapper() {}
  
  protected ParcelableWrapper(SmartParcelable paramSmartParcelable)
  {
    this.obj = paramSmartParcelable;
  }
  
  public static <T extends SmartParcelable> ArrayList<T> createArrayListFromParcel(Parcel paramParcel)
  {
    paramParcel = (ParcelableListWrapper)ParcelableListWrapper.CREATOR.createFromParcel(paramParcel);
    if (paramParcel == null) {
      return null;
    }
    return paramParcel.getParcelableList();
  }
  
  public static <T extends SmartParcelable> T createDataFromParcel(Parcel paramParcel)
  {
    return ((ParcelableWrapper)CREATOR.createFromParcel(paramParcel)).getData();
  }
  
  public static <T extends SmartParcelable> ArrayList<T> getArrayListFromBundle(Bundle paramBundle, String paramString)
  {
    paramBundle = (ParcelableListWrapper)paramBundle.getParcelable(paramString);
    if (paramBundle != null) {
      return paramBundle.getParcelableList();
    }
    return null;
  }
  
  public static <T extends SmartParcelable> ArrayList<T> getArrayListFromIntent(Intent paramIntent, String paramString)
  {
    if (paramIntent == null) {
      return null;
    }
    paramIntent = (ParcelableListWrapper)paramIntent.getParcelableExtra(paramString);
    if (paramIntent == null) {}
    for (paramIntent = null;; paramIntent = paramIntent.getParcelableList()) {
      return paramIntent;
    }
  }
  
  private static ClassLoader getClassLoader()
  {
    if (sClassLoader != null) {
      return sClassLoader;
    }
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    if (PluginUtils.getInstalledPluginPath(localBaseApplication, "qzone_plugin.apk").exists()) {}
    try
    {
      sClassLoader = QzonePluginProxyActivity.getQZonePluginClassLoader(localBaseApplication);
      if (sClassLoader == null) {
        sClassLoader = ParcelableWrapper.class.getClassLoader();
      }
      return sClassLoader;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QZLog.w("ParcelableWrapper", "failed to get class loader:", localException);
      }
    }
  }
  
  public static <T extends SmartParcelable> T getDataFromBudle(Bundle paramBundle, String paramString)
  {
    paramBundle = (ParcelableWrapper)paramBundle.getParcelable(paramString);
    if (paramBundle == null) {
      return null;
    }
    return paramBundle.getData();
  }
  
  public static <T extends SmartParcelable> T getDataFromeIntent(Intent paramIntent, String paramString)
  {
    if (paramIntent == null) {
      return null;
    }
    paramIntent = (ParcelableWrapper)paramIntent.getParcelableExtra(paramString);
    if (paramIntent == null) {}
    for (paramIntent = null;; paramIntent = paramIntent.getData()) {
      return paramIntent;
    }
  }
  
  /* Error */
  private static ParcelableWrapper.ParcableInfo getParcableInfo(String paramString, Class paramClass)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +13 -> 14
    //   4: new 184	java/lang/NullPointerException
    //   7: dup
    //   8: ldc 186
    //   10: invokespecial 189	java/lang/NullPointerException:<init>	(Ljava/lang/String;)V
    //   13: athrow
    //   14: getstatic 61	com/tencent/component/app/common/ParcelableWrapper:sParcableCache	Ljava/util/concurrent/ConcurrentHashMap;
    //   17: aload_0
    //   18: invokevirtual 193	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   21: checkcast 195	com/tencent/component/app/common/ParcelableWrapper$ParcableInfo
    //   24: astore_3
    //   25: aload_3
    //   26: astore_2
    //   27: aload_3
    //   28: ifnonnull +54 -> 82
    //   31: aload_1
    //   32: astore_2
    //   33: aload_1
    //   34: ifnonnull +11 -> 45
    //   37: invokestatic 90	com/tencent/component/app/common/ParcelableWrapper:getClassLoader	()Ljava/lang/ClassLoader;
    //   40: aload_0
    //   41: invokestatic 201	com/tencent/ditto/utils/ClassLoadUtils:load	(Ljava/lang/ClassLoader;Ljava/lang/String;)Ljava/lang/Class;
    //   44: astore_2
    //   45: aload_2
    //   46: monitorenter
    //   47: getstatic 61	com/tencent/component/app/common/ParcelableWrapper:sParcableCache	Ljava/util/concurrent/ConcurrentHashMap;
    //   50: aload_0
    //   51: invokevirtual 193	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   54: checkcast 195	com/tencent/component/app/common/ParcelableWrapper$ParcableInfo
    //   57: astore_3
    //   58: aload_3
    //   59: astore_1
    //   60: aload_3
    //   61: ifnonnull +17 -> 78
    //   64: aload_2
    //   65: invokestatic 205	com/tencent/component/app/common/ParcelableWrapper:parseParcableInfo	(Ljava/lang/Class;)Lcom/tencent/component/app/common/ParcelableWrapper$ParcableInfo;
    //   68: astore_1
    //   69: getstatic 61	com/tencent/component/app/common/ParcelableWrapper:sParcableCache	Ljava/util/concurrent/ConcurrentHashMap;
    //   72: aload_0
    //   73: aload_1
    //   74: invokevirtual 209	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   77: pop
    //   78: aload_2
    //   79: monitorexit
    //   80: aload_1
    //   81: astore_2
    //   82: aload_2
    //   83: areturn
    //   84: astore_1
    //   85: ldc 166
    //   87: new 211	java/lang/StringBuilder
    //   90: dup
    //   91: invokespecial 212	java/lang/StringBuilder:<init>	()V
    //   94: ldc 214
    //   96: invokevirtual 218	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: aload_0
    //   100: invokevirtual 218	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: invokevirtual 222	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   106: aload_1
    //   107: invokestatic 225	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   110: new 227	java/lang/RuntimeException
    //   113: dup
    //   114: new 211	java/lang/StringBuilder
    //   117: dup
    //   118: invokespecial 212	java/lang/StringBuilder:<init>	()V
    //   121: ldc 229
    //   123: invokevirtual 218	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: aload_0
    //   127: invokevirtual 218	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: invokevirtual 222	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   133: invokespecial 230	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   136: athrow
    //   137: astore_0
    //   138: aload_2
    //   139: monitorexit
    //   140: aload_0
    //   141: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	142	0	paramString	String
    //   0	142	1	paramClass	Class
    //   24	37	3	localParcableInfo	ParcelableWrapper.ParcableInfo
    // Exception table:
    //   from	to	target	type
    //   37	45	84	java/lang/ClassNotFoundException
    //   47	58	137	finally
    //   64	78	137	finally
    //   78	80	137	finally
    //   138	140	137	finally
  }
  
  public static ParcelableWrapper obtain(SmartParcelable paramSmartParcelable)
  {
    ParcelableWrapper[] arrayOfParcelableWrapper = sOwnedPool;
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
          localParcelableWrapper.obj = paramSmartParcelable;
          return localParcelableWrapper;
        }
        finally {}
        return new ParcelableWrapper(paramSmartParcelable);
      }
      i += 1;
    }
  }
  
  private static ParcelableWrapper.ParcableInfo parseParcableInfo(Class paramClass)
  {
    Field[] arrayOfField = paramClass.getDeclaredFields();
    ParcelableWrapper.ParcableInfo localParcableInfo = new ParcelableWrapper.ParcableInfo();
    ParcelableWrapper.ParcableInfo.access$002(localParcableInfo, paramClass);
    List localList1 = ParcelableWrapper.ParcableInfo.access$100(localParcableInfo);
    List localList2 = ParcelableWrapper.ParcableInfo.access$200(localParcableInfo);
    Object localObject = paramClass.getSuperclass();
    if (SmartParcelable.class.isAssignableFrom((Class)localObject))
    {
      localObject = getParcableInfo(((Class)localObject).getName(), (Class)localObject);
      localList1.addAll(ParcelableWrapper.ParcableInfo.access$100((ParcelableWrapper.ParcableInfo)localObject));
      localList2.addAll(ParcelableWrapper.ParcableInfo.access$200((ParcelableWrapper.ParcableInfo)localObject));
    }
    if (((arrayOfField == null) || (arrayOfField.length <= 0)) && (localList2.size() <= 0))
    {
      QZLog.e("ParcelableWrapper", "SmartParcelable must have filed to Parcel:" + paramClass);
      return localParcableInfo;
    }
    int j = arrayOfField.length;
    int i = 0;
    label142:
    if (i < j)
    {
      paramClass = arrayOfField[i];
      if (paramClass.getAnnotation(NeedParcel.class) != null)
      {
        paramClass.setAccessible(true);
        localList1.add(paramClass);
        paramClass = paramClass.getType();
        if (paramClass != Integer.TYPE) {
          break label206;
        }
        localList2.add(Integer.valueOf(1));
      }
    }
    for (;;)
    {
      i += 1;
      break label142;
      break;
      label206:
      if (paramClass == String.class) {
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
  }
  
  public static void putArrayListToBundle(Bundle paramBundle, String paramString, ArrayList<? extends SmartParcelable> paramArrayList)
  {
    if (paramArrayList == null)
    {
      paramBundle.putParcelable(paramString, null);
      return;
    }
    paramBundle.putParcelable(paramString, new ParcelableListWrapper(paramArrayList));
  }
  
  public static Intent putArrayListToIntent(Intent paramIntent, String paramString, ArrayList<? extends SmartParcelable> paramArrayList)
  {
    if (paramIntent == null) {
      return null;
    }
    if (paramArrayList == null) {
      paramIntent.putExtra(paramString, (Parcelable)null);
    }
    for (;;)
    {
      return paramIntent;
      paramIntent.putExtra(paramString, new ParcelableListWrapper(paramArrayList));
    }
  }
  
  public static void putDataToBundle(Bundle paramBundle, String paramString, SmartParcelable paramSmartParcelable)
  {
    paramBundle.putParcelable(paramString, new ParcelableWrapper(paramSmartParcelable));
  }
  
  public static void putDataToIntent(Intent paramIntent, String paramString, SmartParcelable paramSmartParcelable)
  {
    paramIntent.putExtra(paramString, new ParcelableWrapper(paramSmartParcelable));
  }
  
  protected static ArrayList readArrayList(Parcel paramParcel, ClassLoader paramClassLoader)
  {
    int i = paramParcel.readInt();
    if (i < 0) {
      return null;
    }
    ArrayList localArrayList = new ArrayList(i);
    readListInternal(paramParcel, localArrayList, i, paramClassLoader);
    return localArrayList;
  }
  
  public static HashMap readHashMap(Parcel paramParcel, ClassLoader paramClassLoader)
  {
    int i = paramParcel.readInt();
    if (i < 0) {
      return null;
    }
    HashMap localHashMap = new HashMap(i);
    readMapInternal(paramParcel, localHashMap, i, paramClassLoader);
    return localHashMap;
  }
  
  private static void readListInternal(Parcel paramParcel, List paramList, int paramInt, ClassLoader paramClassLoader)
  {
    if (paramInt > 0)
    {
      Object localObject = paramParcel.readValue(paramClassLoader);
      if ((localObject instanceof ParcelableWrapper)) {
        paramList.add(((ParcelableWrapper)localObject).getData());
      }
      for (;;)
      {
        paramInt -= 1;
        break;
        paramList.add(localObject);
      }
    }
  }
  
  static void readMapInternal(Parcel paramParcel, Map paramMap, int paramInt, ClassLoader paramClassLoader)
  {
    if (paramInt > 0)
    {
      Object localObject1 = paramParcel.readValue(paramClassLoader);
      Object localObject2 = paramParcel.readValue(paramClassLoader);
      if ((localObject2 instanceof ParcelableWrapper)) {
        paramMap.put(localObject1, ((ParcelableWrapper)localObject2).getData());
      }
      for (;;)
      {
        paramInt -= 1;
        break;
        paramMap.put(localObject1, localObject2);
      }
    }
  }
  
  /* Error */
  public static void recycle(ParcelableWrapper paramParcelableWrapper)
  {
    // Byte code:
    //   0: getstatic 69	com/tencent/component/app/common/ParcelableWrapper:sOwnedPool	[Lcom/tencent/component/app/common/ParcelableWrapper;
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
    //   17: ifnonnull +18 -> 35
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
    //   33: aload_0
    //   34: athrow
    //   35: iload_1
    //   36: iconst_1
    //   37: iadd
    //   38: istore_1
    //   39: goto -31 -> 8
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	42	0	paramParcelableWrapper	ParcelableWrapper
    //   7	32	1	i	int
    //   3	29	2	arrayOfParcelableWrapper	ParcelableWrapper[]
    // Exception table:
    //   from	to	target	type
    //   24	26	30	finally
    //   27	29	30	finally
    //   31	33	30	finally
  }
  
  public static void writeArrayListToParcel(Parcel paramParcel, int paramInt, ArrayList<? extends SmartParcelable> paramArrayList)
  {
    if (paramArrayList == null)
    {
      paramParcel.writeString(null);
      return;
    }
    paramArrayList = ParcelableListWrapper.obtain(paramArrayList);
    paramArrayList.writeToParcel(paramParcel, paramInt);
    ParcelableListWrapper.recycle(paramArrayList);
  }
  
  public static void writeDataToParcel(Parcel paramParcel, int paramInt, SmartParcelable paramSmartParcelable)
  {
    if (paramSmartParcelable == null)
    {
      paramParcel.writeString(null);
      return;
    }
    paramSmartParcelable = obtain(paramSmartParcelable);
    paramSmartParcelable.writeToParcel(paramParcel, paramInt);
    recycle(paramSmartParcelable);
  }
  
  public static void writeList(Parcel paramParcel, List paramList)
  {
    if (paramList == null)
    {
      paramParcel.writeInt(-1);
      return;
    }
    int j = paramList.size();
    paramParcel.writeInt(j);
    int i = 0;
    label24:
    Object localObject;
    if (i < j)
    {
      localObject = paramList.get(i);
      if (!(localObject instanceof SmartParcelable)) {
        break label74;
      }
      localObject = obtain((SmartParcelable)localObject);
      paramParcel.writeValue(localObject);
      recycle((ParcelableWrapper)localObject);
    }
    for (;;)
    {
      i += 1;
      break label24;
      break;
      label74:
      paramParcel.writeValue(localObject);
    }
  }
  
  public static void writeMap(Parcel paramParcel, Map<String, Object> paramMap)
  {
    if (paramMap == null) {
      paramParcel.writeInt(-1);
    }
    for (;;)
    {
      return;
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
          localObject = obtain((SmartParcelable)localObject);
          paramParcel.writeValue(localObject);
          recycle((ParcelableWrapper)localObject);
        }
        else
        {
          paramParcel.writeValue(localObject);
        }
      }
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public SmartParcelable getData()
  {
    return this.obj;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (this.obj == null) {
      paramParcel.writeString(null);
    }
    int i;
    for (;;)
    {
      return;
      Object localObject2 = this.obj.getClass();
      Object localObject1 = getParcableInfo(((Class)localObject2).getName(), (Class)localObject2);
      localObject3 = ParcelableWrapper.ParcableInfo.access$100((ParcelableWrapper.ParcableInfo)localObject1);
      localObject1 = ParcelableWrapper.ParcableInfo.access$200((ParcelableWrapper.ParcableInfo)localObject1);
      try
      {
        paramParcel.writeString(((Class)localObject2).getName());
        localObject2 = ((List)localObject3).iterator();
        i = 0;
        if (((Iterator)localObject2).hasNext())
        {
          localObject3 = (Field)((Iterator)localObject2).next();
          switch (((Integer)((List)localObject1).get(i)).intValue())
          {
          case 5: 
            paramParcel.writeString((String)((Field)localObject3).get(this.obj));
          }
        }
      }
      catch (Throwable paramParcel)
      {
        QZLog.e("ParcelableWrapper", "ParcelableWrapper.writeToParcel:", paramParcel);
        return;
      }
    }
    Object localObject3 = obtain((SmartParcelable)((Field)localObject3).get(this.obj));
    paramParcel.writeParcelable((Parcelable)localObject3, paramInt);
    recycle((ParcelableWrapper)localObject3);
    break label484;
    paramParcel.writeInt(((Field)localObject3).getInt(this.obj));
    break label484;
    paramParcel.writeParcelable((Parcelable)((Field)localObject3).get(this.obj), paramInt);
    break label484;
    if (((Field)localObject3).getBoolean(this.obj)) {}
    for (byte b = 1;; b = 0)
    {
      paramParcel.writeByte(b);
      break label484;
      paramParcel.writeLong(((Field)localObject3).getLong(this.obj));
      break label484;
      paramParcel.writeByte(((Field)localObject3).getByte(this.obj));
      break label484;
      paramParcel.writeDouble(((Field)localObject3).getDouble(this.obj));
      break label484;
      paramParcel.writeFloat(((Field)localObject3).getFloat(this.obj));
      break label484;
      writeList(paramParcel, (List)((Field)localObject3).get(this.obj));
      break label484;
      writeMap(paramParcel, (Map)((Field)localObject3).get(this.obj));
      break label484;
      paramParcel.writeSerializable((Serializable)((Field)localObject3).get(this.obj));
      break label484;
      paramParcel.writeStringArray((String[])((Field)localObject3).get(this.obj));
      break label484;
      paramParcel.writeByteArray((byte[])((Field)localObject3).get(this.obj));
      break label484;
      paramParcel.writeValue(((Field)localObject3).get(this.obj));
      label484:
      i += 1;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.component.app.common.ParcelableWrapper
 * JD-Core Version:    0.7.0.1
 */