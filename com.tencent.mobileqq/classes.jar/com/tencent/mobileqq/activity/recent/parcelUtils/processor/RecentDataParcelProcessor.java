package com.tencent.mobileqq.activity.recent.parcelUtils.processor;

import android.os.Parcel;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.parcelUtils.ParcelHelper;
import com.tencent.mobileqq.activity.recent.parcelUtils.ParcelHelper.UnsupportedFieldTypeException;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.util.ArrayList;

public class RecentDataParcelProcessor
  extends ParcelProcessor
{
  private static final byte[] a = { 1, 2, 3, 0 };
  private static final byte[] b = { 2, 3, 4, 1 };
  
  private static final boolean a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if (paramArrayOfByte1 != null)
    {
      if (paramArrayOfByte2 == null) {
        return true;
      }
      if (paramArrayOfByte1 != null)
      {
        if (paramArrayOfByte2 == null) {
          return false;
        }
        if (paramArrayOfByte1.length != paramArrayOfByte2.length) {
          return false;
        }
        int i = 0;
        while (i < paramArrayOfByte1.length)
        {
          if (paramArrayOfByte1[i] != paramArrayOfByte2[i]) {
            return false;
          }
          i += 1;
        }
        return true;
      }
      return false;
    }
    return true;
  }
  
  protected Object a(Object paramObject, Field paramField, byte[] paramArrayOfByte)
  {
    if ((paramObject instanceof RecentBaseData))
    {
      if (paramField.getType() == MsgSummary.class)
      {
        paramField = Parcel.obtain();
        try
        {
          paramField.unmarshall(paramArrayOfByte, 0, paramArrayOfByte.length);
          paramField.setDataPosition(0);
          paramObject = new byte[4];
          paramField.readByteArray(paramObject);
          boolean bool = a(paramObject, a);
          if (bool)
          {
            paramField.recycle();
            return null;
          }
          if (a(paramObject, b))
          {
            paramObject = new MsgSummary();
            paramArrayOfByte = ParcelHelper.a(paramObject);
          }
          try
          {
            b(paramObject, paramField, paramArrayOfByte);
            paramField.recycle();
            return paramObject;
          }
          finally
          {
            break label113;
          }
          throw new RuntimeException("Bad MsgSummary header");
        }
        finally {}
        label113:
        paramField.recycle();
        throw paramObject;
      }
      QLog.e("Recent.Processor", 1, new Object[] { "unparcel unrecognize type ", paramField.getType(), "(", paramObject.getClass(), ")" });
      return null;
    }
    QLog.e("Recent.Processor", 1, new Object[] { "unparcel unrecognize type ", paramField.getType(), "(", paramObject.getClass(), ")" });
    return null;
  }
  
  void a(Object paramObject, ArrayList<Field> paramArrayList, Parcel paramParcel)
  {
    super.a(paramObject, paramArrayList, paramParcel);
  }
  
  protected byte[] a(Object paramObject, Field paramField)
  {
    if ((paramObject instanceof RecentBaseData))
    {
      if ((paramField != null) && (paramField.getType() == MsgSummary.class))
      {
        Parcel localParcel = Parcel.obtain();
        localParcel.setDataPosition(0);
        try
        {
          localObject = (MsgSummary)paramField.get(paramObject);
          if (localObject == null)
          {
            localParcel.writeByteArray(a);
          }
          else
          {
            localParcel.writeByteArray(b);
            c(localObject, ParcelHelper.a(localObject), localParcel);
          }
          paramObject = localParcel.marshall();
          localParcel.recycle();
          return paramObject;
        }
        catch (IllegalAccessException localIllegalAccessException)
        {
          Object localObject = new StringBuilder();
          ((StringBuilder)localObject).append("get MsgSummary error. object=");
          ((StringBuilder)localObject).append(paramObject.getClass());
          ((StringBuilder)localObject).append(", field=");
          ((StringBuilder)localObject).append(paramField.getName());
          throw new RuntimeException(((StringBuilder)localObject).toString(), localIllegalAccessException);
        }
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("unrecognize type ");
      if (paramField != null) {
        paramField = paramField.getType();
      } else {
        paramField = "NullField";
      }
      localStringBuilder.append(paramField);
      localStringBuilder.append("(");
      localStringBuilder.append(paramObject.getClass());
      localStringBuilder.append(")");
      throw new ParcelHelper.UnsupportedFieldTypeException(localStringBuilder.toString());
    }
    QLog.e("Recent.Processor", 1, new Object[] { "parcel unrecognize type ", paramField.getType(), "(", paramObject.getClass(), ")" });
    return null;
  }
  
  void b(Object paramObject, ArrayList<Field> paramArrayList, Parcel paramParcel)
  {
    super.b(paramObject, paramArrayList, paramParcel);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.parcelUtils.processor.RecentDataParcelProcessor
 * JD-Core Version:    0.7.0.1
 */