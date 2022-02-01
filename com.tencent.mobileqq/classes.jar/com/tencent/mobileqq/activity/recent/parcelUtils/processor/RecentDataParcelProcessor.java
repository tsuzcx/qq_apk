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
    boolean bool2 = false;
    boolean bool1;
    if ((paramArrayOfByte1 == null) || (paramArrayOfByte2 == null)) {
      bool1 = true;
    }
    do
    {
      do
      {
        do
        {
          return bool1;
          bool1 = bool2;
        } while (paramArrayOfByte1 == null);
        bool1 = bool2;
      } while (paramArrayOfByte2 == null);
      bool1 = bool2;
    } while (paramArrayOfByte1.length != paramArrayOfByte2.length);
    int i = 0;
    for (;;)
    {
      if (i >= paramArrayOfByte1.length) {
        break label66;
      }
      bool1 = bool2;
      if (paramArrayOfByte1[i] != paramArrayOfByte2[i]) {
        break;
      }
      i += 1;
    }
    label66:
    return true;
  }
  
  protected Object a(Object paramObject, Field paramField, byte[] paramArrayOfByte)
  {
    if ((paramObject instanceof RecentBaseData))
    {
      if (paramField.getType() == MsgSummary.class)
      {
        paramObject = Parcel.obtain();
        try
        {
          paramObject.unmarshall(paramArrayOfByte, 0, paramArrayOfByte.length);
          paramObject.setDataPosition(0);
          paramField = new byte[4];
          paramObject.readByteArray(paramField);
          boolean bool = a(paramField, a);
          if (bool) {
            return null;
          }
          if (!a(paramField, b)) {
            throw new RuntimeException("Bad MsgSummary header");
          }
        }
        finally
        {
          paramObject.recycle();
        }
        paramField = new MsgSummary();
        b(paramField, paramObject, ParcelHelper.a(paramField));
        paramObject.recycle();
        return paramField;
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
          MsgSummary localMsgSummary = (MsgSummary)paramField.get(paramObject);
          if (localMsgSummary == null) {
            localParcel.writeByteArray(a);
          }
          for (;;)
          {
            paramObject = localParcel.marshall();
            localParcel.recycle();
            return paramObject;
            localParcel.writeByteArray(b);
            c(localMsgSummary, ParcelHelper.a(localMsgSummary), localParcel);
          }
          localStringBuilder = new StringBuilder().append("unrecognize type ");
        }
        catch (IllegalAccessException localIllegalAccessException)
        {
          throw new RuntimeException("get MsgSummary error. object=" + paramObject.getClass() + ", field=" + paramField.getName(), localIllegalAccessException);
        }
      }
      StringBuilder localStringBuilder;
      if (paramField != null) {}
      for (paramField = paramField.getType();; paramField = "NullField") {
        throw new ParcelHelper.UnsupportedFieldTypeException(paramField + "(" + paramObject.getClass() + ")");
      }
    }
    QLog.e("Recent.Processor", 1, new Object[] { "parcel unrecognize type ", paramField.getType(), "(", paramObject.getClass(), ")" });
    return null;
  }
  
  void b(Object paramObject, ArrayList<Field> paramArrayList, Parcel paramParcel)
  {
    super.b(paramObject, paramArrayList, paramParcel);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.parcelUtils.processor.RecentDataParcelProcessor
 * JD-Core Version:    0.7.0.1
 */