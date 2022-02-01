package com.tencent.mobileqq.activity.recent.parcelUtils.processor;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.recent.parcelUtils.ParcelHelper.FieldChangedException;
import com.tencent.mobileqq.activity.recent.parcelUtils.ParcelHelper.UnsupportedFieldTypeException;
import com.tencent.mobileqq.text.AbsQQText;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.ArrayList<Ljava.lang.reflect.Field;>;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ParcelProcessor
  extends BaseParcelProcessor
{
  private static int a(Field paramField)
  {
    paramField = paramField.getType();
    if (paramField == Byte.TYPE) {
      return 0;
    }
    if (paramField == Integer.TYPE) {
      return 1;
    }
    if (paramField == String.class) {
      return 2;
    }
    if (paramField == CharSequence.class) {
      return 3;
    }
    if (paramField == Boolean.TYPE) {
      return 5;
    }
    if (paramField == Long.TYPE) {
      return 6;
    }
    return -1;
  }
  
  private void a(CharSequence paramCharSequence, Parcel paramParcel)
  {
    boolean bool = paramCharSequence instanceof AbsQQText;
  }
  
  protected Object a(Object paramObject, Field paramField, byte[] paramArrayOfByte)
  {
    return null;
  }
  
  public final void a(Object paramObject, Parcel paramParcel, ArrayList<Field> paramArrayList)
  {
    b(paramObject, paramParcel, paramArrayList);
  }
  
  void a(Object paramObject, ArrayList<Field> paramArrayList, Parcel paramParcel) {}
  
  protected byte[] a(Object paramObject, Field paramField)
  {
    return null;
  }
  
  protected void b(Object paramObject, Parcel paramParcel, ArrayList<Field> paramArrayList)
  {
    Object localObject1 = new HashMap(paramArrayList.size());
    paramArrayList = paramArrayList.iterator();
    Object localObject2;
    int i;
    while (paramArrayList.hasNext())
    {
      localObject2 = (Field)paramArrayList.next();
      ((Field)localObject2).setAccessible(true);
      String str = ((Field)localObject2).getName();
      i = ((Field)localObject2).getModifiers();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append("_");
      localStringBuilder.append(i);
      ((Map)localObject1).put(localStringBuilder.toString(), localObject2);
    }
    boolean bool;
    for (;;)
    {
      if (paramParcel.dataAvail() <= 0) {
        break label573;
      }
      paramArrayList = paramParcel.readString();
      i = paramParcel.readInt();
      int k = paramParcel.readInt();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramArrayList);
      ((StringBuilder)localObject2).append("_");
      ((StringBuilder)localObject2).append(i);
      localObject2 = (Field)((Map)localObject1).remove(((StringBuilder)localObject2).toString());
      if (localObject2 == null) {
        break;
      }
      int j = a((Field)localObject2);
      i = j;
      if (k == 4)
      {
        i = j;
        if (j == -1) {
          i = 4;
        }
      }
      if (i != k)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("Field ");
        ((StringBuilder)localObject1).append(paramArrayList);
        ((StringBuilder)localObject1).append("(");
        paramParcel = paramObject;
        if (paramObject != null) {
          paramParcel = paramObject.getClass().getName();
        }
        ((StringBuilder)localObject1).append(paramParcel);
        ((StringBuilder)localObject1).append(") type changed");
        ((StringBuilder)localObject1).append(k);
        ((StringBuilder)localObject1).append("->");
        ((StringBuilder)localObject1).append(i);
        throw new ParcelHelper.FieldChangedException(((StringBuilder)localObject1).toString());
      }
      switch (k)
      {
      default: 
        break;
      case 6: 
      case 5: 
      case 4: 
      case 3: 
      case 2: 
      case 1: 
      case 0: 
        try
        {
          ((Field)localObject2).set(paramObject, Long.valueOf(paramParcel.readLong()));
        }
        catch (Throwable paramObject)
        {
          throw new RuntimeException(paramObject);
        }
        catch (ParcelHelper.FieldChangedException paramObject)
        {
          throw paramObject;
        }
      }
    }
    if (paramParcel.readInt() == 1) {
      bool = true;
    }
    for (;;)
    {
      ((Field)localObject2).set(paramObject, Boolean.valueOf(bool));
      break;
      paramArrayList = new byte[paramParcel.readInt()];
      paramParcel.readByteArray(paramArrayList);
      ((Field)localObject2).set(paramObject, a(paramObject, (Field)localObject2, paramArrayList));
      break;
      ((Field)localObject2).set(paramObject, TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel));
      break;
      ((Field)localObject2).set(paramObject, paramParcel.readString());
      break;
      ((Field)localObject2).set(paramObject, Integer.valueOf(paramParcel.readInt()));
      break;
      ((Field)localObject2).set(paramObject, Byte.valueOf(paramParcel.readByte()));
      break;
      paramParcel = new StringBuilder();
      paramParcel.append("Field ");
      paramParcel.append(paramArrayList);
      paramParcel.append("(");
      paramParcel.append(paramObject);
      paramParcel.append(") not found");
      throw new ParcelHelper.FieldChangedException(paramParcel.toString());
      label573:
      if (((Map)localObject1).size() <= 0) {
        return;
      }
      paramParcel = new StringBuilder();
      paramParcel.append("object ");
      paramParcel.append(paramObject.getClass());
      paramParcel.append(" field changed");
      paramObject = paramParcel.toString();
      QLog.e("Recent.Parcel", 1, paramObject);
      paramObject = new RuntimeException(paramObject);
      for (;;)
      {
        throw paramObject;
      }
      bool = false;
    }
  }
  
  void b(Object paramObject, ArrayList<Field> paramArrayList, Parcel paramParcel) {}
  
  final boolean b(Object paramObject, ArrayList<Field> paramArrayList, Parcel paramParcel)
  {
    return c(paramObject, paramArrayList, paramParcel);
  }
  
  protected final boolean c(Object paramObject, ArrayList<Field> paramArrayList, Parcel paramParcel)
  {
    Object localObject = null;
    for (;;)
    {
      try
      {
        localIterator = paramArrayList.iterator();
        paramArrayList = (ArrayList<Field>)localObject;
      }
      catch (IllegalAccessException paramObject)
      {
        Iterator localIterator;
        boolean bool;
        int j;
        Field localField;
        throw new RuntimeException(paramObject);
      }
      catch (ParcelHelper.UnsupportedFieldTypeException paramObject)
      {
        int k;
        continue;
        throw paramObject;
        continue;
        continue;
        int i = 0;
        continue;
        if (paramArrayList != null) {
          continue;
        }
        i = k;
        continue;
      }
      bool = localIterator.hasNext();
      j = 1;
      if (!bool) {
        continue;
      }
      localField = (Field)localIterator.next();
      localField.setAccessible(true);
      k = a(localField);
      i = k;
      if (k == -1)
      {
        localObject = a(paramObject, localField);
        paramArrayList = (ArrayList<Field>)localObject;
        i = k;
        if (localObject != null)
        {
          i = 4;
          paramArrayList = (ArrayList<Field>)localObject;
        }
      }
      if (i == -1)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Unsupported type ");
        ((StringBuilder)localObject).append(paramObject.getClass());
        ((StringBuilder)localObject).append("(");
        ((StringBuilder)localObject).append(localField.getName());
        ((StringBuilder)localObject).append(")");
        QLog.d("Recent.Parcel", 2, ((StringBuilder)localObject).toString());
      }
      paramParcel.writeString(localField.getName());
      paramParcel.writeInt(localField.getModifiers());
      paramParcel.writeInt(i);
      k = 0;
      switch (i)
      {
      case 7: 
        a((CharSequence)localField.get(paramObject), paramParcel);
        break;
      case 6: 
        paramParcel.writeLong(localField.getLong(paramObject));
        break;
      case 5: 
        if (!localField.getBoolean(paramObject)) {
          continue;
        }
        i = j;
        paramParcel.writeInt(i);
        continue;
        i = paramArrayList.length;
        paramParcel.writeInt(i);
        paramParcel.writeByteArray(paramArrayList);
        break;
      case 3: 
        TextUtils.writeToParcel((CharSequence)localField.get(paramObject), paramParcel, 0);
        break;
      case 2: 
        paramParcel.writeString((String)localField.get(paramObject));
        break;
      case 1: 
        paramParcel.writeInt(localField.getInt(paramObject));
        break;
      case 0: 
        paramParcel.writeByte(localField.getByte(paramObject));
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.parcelUtils.processor.ParcelProcessor
 * JD-Core Version:    0.7.0.1
 */