import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class bgps
{
  private static bgps jdField_a_of_type_Bgps;
  private ArrayList<bgpt> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  public boolean a;
  
  public static bgps a()
  {
    if (jdField_a_of_type_Bgps == null) {}
    try
    {
      if (jdField_a_of_type_Bgps == null) {
        jdField_a_of_type_Bgps = new bgps();
      }
      return jdField_a_of_type_Bgps;
    }
    finally {}
  }
  
  public bgpt a(long paramLong)
  {
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      if (this.jdField_a_of_type_JavaUtilArrayList.size() == 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QfavRequestQueue", 2, "pop, request list is empty");
        }
        return null;
      }
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        bgpt localbgpt = (bgpt)localIterator.next();
        if (localbgpt.jdField_a_of_type_Long == paramLong)
        {
          this.jdField_a_of_type_JavaUtilArrayList.remove(localbgpt);
          if (QLog.isColorLevel()) {
            QLog.d("QfavRequestQueue", 2, "pop, id: " + paramLong + "pendingsize:" + this.jdField_a_of_type_JavaUtilArrayList.size());
          }
          return localbgpt;
        }
      }
    }
    return null;
  }
  
  public List<Bundle> a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      return null;
    }
    Parcel localParcel = Parcel.obtain();
    localParcel.unmarshall(paramArrayOfByte, 0, paramArrayOfByte.length);
    localParcel.setDataPosition(0);
    paramArrayOfByte = (Bundle)Bundle.CREATOR.createFromParcel(localParcel);
    localParcel.recycle();
    return paramArrayOfByte.getParcelableArrayList("pendingData");
  }
  
  public boolean a()
  {
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      boolean bool = this.jdField_a_of_type_JavaUtilArrayList.isEmpty();
      return bool;
    }
  }
  
  public byte[] a()
  {
    ArrayList localArrayList1 = new ArrayList();
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      if (this.jdField_a_of_type_JavaUtilArrayList.isEmpty()) {
        return null;
      }
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      if (localIterator.hasNext()) {
        localArrayList1.add(((bgpt)localIterator.next()).jdField_a_of_type_AndroidContentIntent.getExtras());
      }
    }
    if (localArrayList2.isEmpty()) {
      return null;
    }
    ??? = new Bundle();
    ((Bundle)???).putParcelableArrayList("pendingData", localArrayList2);
    Parcel localParcel = Parcel.obtain();
    ((Bundle)???).writeToParcel(localParcel, 0);
    ??? = localParcel.marshall();
    localParcel.recycle();
    return ???;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bgps
 * JD-Core Version:    0.7.0.1
 */