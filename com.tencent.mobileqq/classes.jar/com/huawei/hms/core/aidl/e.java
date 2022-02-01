package com.huawei.hms.core.aidl;

import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import com.huawei.hms.core.aidl.annotation.Packed;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class e
{
  private Bundle a(String paramString, Bundle paramBundle, Object paramObject)
  {
    Bundle localBundle = new Bundle();
    a(paramString, paramObject, localBundle);
    paramBundle.putBundle("_next_item_", localBundle);
    return localBundle;
  }
  
  private Object a(Field paramField, Bundle paramBundle)
  {
    String str = paramField.getName();
    paramBundle = paramBundle.get(str);
    if ((paramBundle instanceof Bundle)) {}
    try
    {
      Bundle localBundle = (Bundle)paramBundle;
      int i = localBundle.getInt("_val_type_", -1);
      if (i == 1) {
        return a(paramField.getGenericType(), localBundle);
      }
      if (i != 0) {
        break label112;
      }
      paramField = (IMessageEntity)paramField.getType().newInstance();
      paramField = a((Bundle)paramBundle, paramField);
      return paramField;
    }
    catch (Exception paramField)
    {
      label78:
      break label78;
    }
    paramField = new StringBuilder();
    paramField.append("decode, read value of the field exception, field name: ");
    paramField.append(str);
    Log.e("MessageCodec", paramField.toString());
    return null;
    label112:
    return paramBundle;
  }
  
  private void a(IMessageEntity paramIMessageEntity, Field paramField, Bundle paramBundle)
  {
    paramBundle = a(paramField, paramBundle);
    if (paramBundle != null)
    {
      boolean bool = paramField.isAccessible();
      paramField.setAccessible(true);
      paramField.set(paramIMessageEntity, paramBundle);
      paramField.setAccessible(bool);
    }
  }
  
  private void b(IMessageEntity paramIMessageEntity, Field paramField, Bundle paramBundle)
  {
    boolean bool = paramField.isAccessible();
    paramField.setAccessible(true);
    a(paramField.getName(), paramField.get(paramIMessageEntity), paramBundle);
    paramField.setAccessible(bool);
  }
  
  private boolean b(String paramString, Object paramObject, Bundle paramBundle)
  {
    if ((paramObject instanceof String))
    {
      paramBundle.putString(paramString, (String)paramObject);
    }
    else if ((paramObject instanceof Integer))
    {
      paramBundle.putInt(paramString, ((Integer)paramObject).intValue());
    }
    else if ((paramObject instanceof Short))
    {
      paramBundle.putShort(paramString, ((Short)paramObject).shortValue());
    }
    else if ((paramObject instanceof Long))
    {
      paramBundle.putLong(paramString, ((Long)paramObject).longValue());
    }
    else if ((paramObject instanceof Float))
    {
      paramBundle.putFloat(paramString, ((Float)paramObject).floatValue());
    }
    else if ((paramObject instanceof Double))
    {
      paramBundle.putDouble(paramString, ((Double)paramObject).doubleValue());
    }
    else
    {
      if (!(paramObject instanceof Boolean)) {
        break label150;
      }
      paramBundle.putBoolean(paramString, ((Boolean)paramObject).booleanValue());
    }
    return true;
    label150:
    return false;
  }
  
  public Bundle a(IMessageEntity paramIMessageEntity, Bundle paramBundle)
  {
    for (Class localClass = paramIMessageEntity.getClass(); localClass != null; localClass = localClass.getSuperclass())
    {
      Field[] arrayOfField = localClass.getDeclaredFields();
      int j = arrayOfField.length;
      int i = 0;
      while (i < j)
      {
        Field localField = arrayOfField[i];
        if (localField.isAnnotationPresent(Packed.class)) {}
        try
        {
          b(paramIMessageEntity, localField, paramBundle);
        }
        catch (IllegalAccessException|IllegalArgumentException localIllegalAccessException)
        {
          label58:
          StringBuilder localStringBuilder;
          break label58;
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("encode, get value of the field exception, field name: ");
        localStringBuilder.append(localField.getName());
        Log.e("MessageCodec", localStringBuilder.toString());
        i += 1;
      }
    }
    return paramBundle;
  }
  
  public IMessageEntity a(Bundle paramBundle, IMessageEntity paramIMessageEntity)
  {
    if (paramBundle == null) {
      return paramIMessageEntity;
    }
    paramBundle.setClassLoader(getClass().getClassLoader());
    for (Class localClass = paramIMessageEntity.getClass(); localClass != null; localClass = localClass.getSuperclass())
    {
      Field[] arrayOfField = localClass.getDeclaredFields();
      int j = arrayOfField.length;
      int i = 0;
      while (i < j)
      {
        Field localField = arrayOfField[i];
        if (localField.isAnnotationPresent(Packed.class)) {}
        try
        {
          a(paramIMessageEntity, localField, paramBundle);
        }
        catch (IllegalAccessException|IllegalArgumentException localIllegalAccessException)
        {
          label75:
          StringBuilder localStringBuilder;
          break label75;
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("decode, set value of the field exception, field name:");
        localStringBuilder.append(localField.getName());
        Log.e("MessageCodec", localStringBuilder.toString());
        i += 1;
      }
    }
    return paramIMessageEntity;
  }
  
  protected List<Object> a(Type paramType, Bundle paramBundle)
  {
    ArrayList localArrayList = new ArrayList();
    for (paramBundle = paramBundle.getBundle("_next_item_"); paramBundle != null; paramBundle = paramBundle.getBundle("_next_item_"))
    {
      Object localObject = paramBundle.get("_value_");
      if ((!localObject.getClass().isPrimitive()) && (!(localObject instanceof String)) && (!(localObject instanceof Serializable)))
      {
        if ((localObject instanceof Bundle))
        {
          localObject = (Bundle)localObject;
          int i = ((Bundle)localObject).getInt("_val_type_", -1);
          if (i != 1)
          {
            if (i == 0) {
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
    }
    return localArrayList;
  }
  
  protected void a(String paramString, Object paramObject, Bundle paramBundle)
  {
    if (paramObject == null) {
      return;
    }
    if (b(paramString, paramObject, paramBundle)) {
      return;
    }
    if ((paramObject instanceof CharSequence))
    {
      paramBundle.putCharSequence(paramString, (CharSequence)paramObject);
      return;
    }
    if ((paramObject instanceof Parcelable))
    {
      paramBundle.putParcelable(paramString, (Parcelable)paramObject);
      return;
    }
    if ((paramObject instanceof byte[]))
    {
      paramBundle.putByteArray(paramString, (byte[])paramObject);
      return;
    }
    if ((paramObject instanceof List))
    {
      a(paramString, (List)paramObject, paramBundle);
      return;
    }
    if ((paramObject instanceof Serializable))
    {
      paramBundle.putSerializable(paramString, (Serializable)paramObject);
      return;
    }
    if ((paramObject instanceof IMessageEntity))
    {
      paramObject = a((IMessageEntity)paramObject, new Bundle());
      paramObject.putInt("_val_type_", 0);
      paramBundle.putBundle(paramString, paramObject);
      return;
    }
    paramObject = new StringBuilder();
    paramObject.append("cannot support type, ");
    paramObject.append(paramString);
    Log.e("MessageCodec", paramObject.toString());
  }
  
  protected void a(String paramString, List paramList, Bundle paramBundle)
  {
    Iterator localIterator = paramList.iterator();
    Object localObject2;
    Object localObject1;
    for (paramList = null; localIterator.hasNext(); paramList = a("_value_", (Bundle)localObject1, localObject2))
    {
      localObject2 = localIterator.next();
      localObject1 = paramList;
      if (paramList == null)
      {
        localObject1 = new Bundle();
        paramBundle.putBundle(paramString, (Bundle)localObject1);
        ((Bundle)localObject1).putInt("_val_type_", 1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.core.aidl.e
 * JD-Core Version:    0.7.0.1
 */