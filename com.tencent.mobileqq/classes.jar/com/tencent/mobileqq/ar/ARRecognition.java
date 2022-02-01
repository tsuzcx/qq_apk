package com.tencent.mobileqq.ar;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import apdb;
import apdc;
import apdd;
import apde;
import apjt;
import apjy;
import apka;
import apki;
import apkk;
import apkq;
import aplp;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ARRecognition
  implements Parcelable
{
  public static final Parcelable.Creator<ARRecognition> CREATOR = new apdb();
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
  
  public static apde a(ArrayList<ARRecognition> paramArrayList, apki paramapki)
  {
    apde localapde = new apde(0L, false);
    if ((paramArrayList == null) || (paramArrayList.size() <= 0)) {
      return localapde;
    }
    boolean bool1 = apjt.a(paramapki.jdField_a_of_type_Apjt);
    boolean bool2 = apjy.a(paramapki.jdField_a_of_type_Apjy);
    boolean bool3 = apkk.a(paramapki.jdField_a_of_type_Apkk);
    boolean bool4 = aplp.a(paramapki.jdField_a_of_type_Aplp);
    boolean bool5 = apkq.a(paramapki.jdField_a_of_type_Apkq);
    if ((!bool1) && (!bool2) && (!bool3) && (!bool4) && (!bool5)) {
      return localapde;
    }
    paramapki = new ArrayList();
    if (bool1) {
      paramapki.add(new apdd(1L, a(paramArrayList, 1L)));
    }
    if (bool3) {
      paramapki.add(new apdd(4L, a(paramArrayList, 4L)));
    }
    if (bool2) {
      paramapki.add(new apdd(2L, a(paramArrayList, 2L)));
    }
    if (bool4) {
      paramapki.add(new apdd(128L, a(paramArrayList, 128L)));
    }
    if (bool5) {
      paramapki.add(new apdd(2048L, a(paramArrayList, 2048L)));
    }
    paramArrayList = new StringBuilder();
    int i = 0;
    while (i < paramapki.size())
    {
      paramArrayList.append("(index:").append(i).append(",prority=" + ((apdd)paramapki.get(i)).jdField_a_of_type_Long + ")\n");
      i += 1;
    }
    QLog.i("AREngine_CommonConfigInfo", 1, "getCurrentPriorityHighestResult print result " + paramArrayList.toString());
    Collections.sort(paramapki, new apdc());
    localapde.jdField_a_of_type_Long = ((apdd)paramapki.get(0)).jdField_a_of_type_Long;
    if (paramapki.size() == 1) {}
    for (bool1 = true;; bool1 = false)
    {
      localapde.jdField_a_of_type_Boolean = bool1;
      return localapde;
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
  
  public static boolean a(apki paramapki, long paramLong)
  {
    if (paramapki == null) {}
    do
    {
      return false;
      if (paramLong == 1L) {
        return apjt.a(paramapki.jdField_a_of_type_Apjt);
      }
      if (paramLong == 2L) {
        return apjy.a(paramapki.jdField_a_of_type_Apjy);
      }
      if (paramLong == 128L) {
        return aplp.a(paramapki.jdField_a_of_type_Aplp);
      }
      if (paramLong == 4L) {
        return apkk.a(paramapki.jdField_a_of_type_Apkk);
      }
      if (paramLong == 64L) {
        return apka.a(paramapki.jdField_a_of_type_Apka);
      }
    } while (paramLong != 2048L);
    return apkq.a(paramapki.jdField_a_of_type_Apkq);
  }
  
  public static boolean a(apki paramapki, ArrayList<ARRecognition> paramArrayList, long paramLong)
  {
    if ((paramapki == null) || (paramArrayList == null) || (!a(paramapki, paramLong))) {
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
      if ((paramLong != l) && (a(paramapki, l)) && (!a(paramLong, l, j, k))) {
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