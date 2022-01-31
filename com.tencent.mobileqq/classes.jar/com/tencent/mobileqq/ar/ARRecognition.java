package com.tencent.mobileqq.ar;

import akkq;
import akkr;
import akks;
import akkt;
import akrn;
import akrs;
import akru;
import aksc;
import akse;
import aksk;
import aktj;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ARRecognition
  implements Parcelable
{
  public static final Parcelable.Creator<ARRecognition> CREATOR = new akkq();
  public int a;
  public long a;
  public int b;
  public long b;
  public int c;
  public int d;
  
  public ARRecognition() {}
  
  public ARRecognition(Parcel paramParcel)
  {
    this.jdField_a_of_type_Long = paramParcel.readLong();
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.jdField_b_of_type_Int = paramParcel.readInt();
    this.c = paramParcel.readInt();
    this.jdField_b_of_type_Long = paramParcel.readLong();
    this.d = paramParcel.readInt();
  }
  
  public static int a(ArrayList<ARRecognition> paramArrayList, long paramLong)
  {
    if (paramArrayList != null)
    {
      int i = 0;
      while (i < paramArrayList.size())
      {
        if (paramLong == 1 << (int)((ARRecognition)paramArrayList.get(i)).jdField_a_of_type_Long) {
          return ((ARRecognition)paramArrayList.get(i)).c;
        }
        i += 1;
      }
    }
    return 5;
  }
  
  public static long a(ArrayList<ARRecognition> paramArrayList)
  {
    long l1 = 0L;
    long l2 = l1;
    if (paramArrayList != null)
    {
      int i = 0;
      for (;;)
      {
        l2 = l1;
        if (i >= paramArrayList.size()) {
          break;
        }
        l2 = l1;
        if (((ARRecognition)paramArrayList.get(i)).jdField_a_of_type_Int != 0) {
          l2 = l1 | 1 << (int)((ARRecognition)paramArrayList.get(i)).jdField_a_of_type_Long;
        }
        i += 1;
        l1 = l2;
      }
    }
    return l2;
  }
  
  public static akkt a(ArrayList<ARRecognition> paramArrayList, aksc paramaksc)
  {
    akkt localakkt = new akkt(0L, false);
    if ((paramArrayList == null) || (paramArrayList.size() <= 0)) {
      return localakkt;
    }
    boolean bool1 = akrn.a(paramaksc.jdField_a_of_type_Akrn);
    boolean bool2 = akrs.a(paramaksc.jdField_a_of_type_Akrs);
    boolean bool3 = akse.a(paramaksc.jdField_a_of_type_Akse);
    boolean bool4 = aktj.a(paramaksc.jdField_a_of_type_Aktj);
    boolean bool5 = aksk.a(paramaksc.jdField_a_of_type_Aksk);
    if ((!bool1) && (!bool2) && (!bool3) && (!bool4) && (!bool5)) {
      return localakkt;
    }
    paramaksc = new ArrayList();
    if (bool1) {
      paramaksc.add(new akks(1L, a(paramArrayList, 1L)));
    }
    if (bool3) {
      paramaksc.add(new akks(4L, a(paramArrayList, 4L)));
    }
    if (bool2) {
      paramaksc.add(new akks(2L, a(paramArrayList, 2L)));
    }
    if (bool4) {
      paramaksc.add(new akks(128L, a(paramArrayList, 128L)));
    }
    if (bool5) {
      paramaksc.add(new akks(2048L, a(paramArrayList, 2048L)));
    }
    paramArrayList = new StringBuilder();
    int i = 0;
    while (i < paramaksc.size())
    {
      paramArrayList.append("(index:").append(i).append(",prority=" + ((akks)paramaksc.get(i)).jdField_a_of_type_Long + ")\n");
      i += 1;
    }
    QLog.i("AREngine_CommonConfigInfo", 1, "getCurrentPriorityHighestResult print result " + paramArrayList.toString());
    Collections.sort(paramaksc, new akkr());
    localakkt.jdField_a_of_type_Long = ((akks)paramaksc.get(0)).jdField_a_of_type_Long;
    if (paramaksc.size() == 1) {}
    for (bool1 = true;; bool1 = false)
    {
      localakkt.jdField_a_of_type_Boolean = bool1;
      return localakkt;
    }
  }
  
  public static boolean a(long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    if (paramInt1 != paramInt2) {
      if (paramInt1 >= paramInt2) {}
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return true;
                return false;
                if ((paramLong1 != 1L) && (paramLong2 != 1L)) {
                  break;
                }
              } while (paramLong1 == 1L);
              return false;
              if ((paramLong1 != 2L) && (paramLong2 != 2L)) {
                break;
              }
            } while (paramLong1 == 2L);
            return false;
            if ((paramLong1 != 128L) && (paramLong2 != 128L)) {
              break;
            }
          } while (paramLong1 == 128L);
          return false;
          if ((paramLong1 != 4L) && (paramLong2 != 4L)) {
            break;
          }
        } while (paramLong1 == 4L);
        return false;
        if ((paramLong1 != 64L) && (paramLong2 != 64L)) {
          break;
        }
      } while (paramLong1 == 64L);
      return false;
    } while (((paramLong1 != 2048L) && (paramLong2 != 2048L)) || (paramLong1 == 2048L));
    return false;
  }
  
  public static boolean a(aksc paramaksc, long paramLong)
  {
    if (paramaksc == null) {}
    do
    {
      return false;
      if (paramLong == 1L) {
        return akrn.a(paramaksc.jdField_a_of_type_Akrn);
      }
      if (paramLong == 2L) {
        return akrs.a(paramaksc.jdField_a_of_type_Akrs);
      }
      if (paramLong == 128L) {
        return aktj.a(paramaksc.jdField_a_of_type_Aktj);
      }
      if (paramLong == 4L) {
        return akse.a(paramaksc.jdField_a_of_type_Akse);
      }
      if (paramLong == 64L) {
        return akru.a(paramaksc.jdField_a_of_type_Akru);
      }
    } while (paramLong != 2048L);
    return aksk.a(paramaksc.jdField_a_of_type_Aksk);
  }
  
  public static boolean a(aksc paramaksc, ArrayList<ARRecognition> paramArrayList, long paramLong)
  {
    if ((paramaksc == null) || (paramArrayList == null) || (!a(paramaksc, paramLong))) {
      return false;
    }
    int j = a(paramArrayList, paramLong);
    int i = 0;
    for (;;)
    {
      if (i >= paramArrayList.size()) {
        break label107;
      }
      long l = 1 << (int)((ARRecognition)paramArrayList.get(i)).jdField_a_of_type_Long;
      int k = ((ARRecognition)paramArrayList.get(i)).c;
      if ((paramLong != l) && (a(paramaksc, l)) && (!a(paramLong, l, j, k))) {
        break;
      }
      i += 1;
    }
    label107:
    return true;
  }
  
  public static boolean a(ArrayList<ARRecognition> paramArrayList, long paramLong)
  {
    int j = a(paramArrayList, paramLong);
    if (paramArrayList != null)
    {
      int i = 0;
      while (i < paramArrayList.size())
      {
        if (!a(paramLong, 1 << (int)((ARRecognition)paramArrayList.get(i)).jdField_a_of_type_Long, j, ((ARRecognition)paramArrayList.get(i)).c)) {
          return false;
        }
        i += 1;
      }
    }
    return true;
  }
  
  public static boolean a(ArrayList<ARRecognition> paramArrayList, long paramLong1, long paramLong2)
  {
    int j;
    int i;
    if (paramArrayList != null)
    {
      j = 5;
      i = 5;
      int k = 0;
      if (k < paramArrayList.size())
      {
        long l = 1 << (int)((ARRecognition)paramArrayList.get(k)).jdField_a_of_type_Long;
        int m;
        if (paramLong1 == l) {
          m = ((ARRecognition)paramArrayList.get(k)).c;
        }
        for (;;)
        {
          k += 1;
          i = m;
          break;
          m = i;
          if (paramLong2 == l)
          {
            j = ((ARRecognition)paramArrayList.get(k)).c;
            m = i;
          }
        }
      }
    }
    for (;;)
    {
      return a(paramLong1, paramLong2, i, j);
      j = 5;
      i = 5;
    }
  }
  
  public static long b(ArrayList<ARRecognition> paramArrayList)
  {
    long l1 = 0L;
    long l2 = l1;
    if (paramArrayList != null)
    {
      int i = 0;
      for (;;)
      {
        l2 = l1;
        if (i >= paramArrayList.size()) {
          break;
        }
        l2 = l1;
        if (((ARRecognition)paramArrayList.get(i)).jdField_b_of_type_Int != 0) {
          l2 = l1 | 1 << (int)((ARRecognition)paramArrayList.get(i)).jdField_a_of_type_Long;
        }
        i += 1;
        l1 = l2;
      }
    }
    return l2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("Recognition{");
    localStringBuffer.append("type=").append(this.jdField_a_of_type_Long);
    localStringBuffer.append("CloudRecogOpen =").append(this.jdField_a_of_type_Int);
    localStringBuffer.append("LocalRecogOpen =").append(this.jdField_b_of_type_Int);
    localStringBuffer.append(", priority='").append(this.c).append('\'');
    localStringBuffer.append(", wait_ms='").append(this.jdField_b_of_type_Long).append('\'');
    localStringBuffer.append("ImagePreprocess_open =").append(this.d);
    localStringBuffer.append('}');
    return localStringBuffer.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.jdField_a_of_type_Long);
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeInt(this.jdField_b_of_type_Int);
    paramParcel.writeInt(this.c);
    paramParcel.writeLong(this.jdField_b_of_type_Long);
    paramParcel.writeInt(this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRecognition
 * JD-Core Version:    0.7.0.1
 */