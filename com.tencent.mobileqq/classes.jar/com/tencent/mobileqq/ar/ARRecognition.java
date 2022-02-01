package com.tencent.mobileqq.ar;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.ar.arengine.ARCloudMarkerRecogResult;
import com.tencent.mobileqq.ar.arengine.ARCloudObjectClassifyResult;
import com.tencent.mobileqq.ar.arengine.ARCloudPreOcrResult;
import com.tencent.mobileqq.ar.arengine.ARCloudRecogResult;
import com.tencent.mobileqq.ar.arengine.ARCloudRecogRspFaceResult;
import com.tencent.mobileqq.ar.arengine.ARCloudSceneRecogResult;
import com.tencent.mobileqq.ar.arengine.ARMIGObjectClassifyResult;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ARRecognition
  implements Parcelable
{
  public static final Parcelable.Creator<ARRecognition> CREATOR = new ARRecognition.1();
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
  
  public static ARRecognition.RecognitionResult a(ArrayList<ARRecognition> paramArrayList, ARCloudRecogResult paramARCloudRecogResult)
  {
    ARRecognition.RecognitionResult localRecognitionResult = new ARRecognition.RecognitionResult(0L, false);
    if (paramArrayList != null)
    {
      if (paramArrayList.size() <= 0) {
        return localRecognitionResult;
      }
      boolean bool1 = ARCloudMarkerRecogResult.a(paramARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARCloudMarkerRecogResult);
      boolean bool2 = ARCloudObjectClassifyResult.a(paramARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARCloudObjectClassifyResult);
      boolean bool3 = ARCloudRecogRspFaceResult.a(paramARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARCloudRecogRspFaceResult);
      boolean bool4 = ARMIGObjectClassifyResult.a(paramARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult);
      boolean bool5 = ARCloudSceneRecogResult.a(paramARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARCloudSceneRecogResult);
      if ((!bool1) && (!bool2) && (!bool3) && (!bool4) && (!bool5)) {
        return localRecognitionResult;
      }
      paramARCloudRecogResult = new ArrayList();
      if (bool1) {
        paramARCloudRecogResult.add(new ARRecognition.RecoglistionPriorityStore(1L, a(paramArrayList, 1L)));
      }
      if (bool3) {
        paramARCloudRecogResult.add(new ARRecognition.RecoglistionPriorityStore(4L, a(paramArrayList, 4L)));
      }
      if (bool2) {
        paramARCloudRecogResult.add(new ARRecognition.RecoglistionPriorityStore(2L, a(paramArrayList, 2L)));
      }
      if (bool4) {
        paramARCloudRecogResult.add(new ARRecognition.RecoglistionPriorityStore(128L, a(paramArrayList, 128L)));
      }
      if (bool5) {
        paramARCloudRecogResult.add(new ARRecognition.RecoglistionPriorityStore(2048L, a(paramArrayList, 2048L)));
      }
      paramArrayList = new StringBuilder();
      int i = 0;
      while (i < paramARCloudRecogResult.size())
      {
        paramArrayList.append("(index:");
        paramArrayList.append(i);
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(",prority=");
        localStringBuilder.append(((ARRecognition.RecoglistionPriorityStore)paramARCloudRecogResult.get(i)).jdField_a_of_type_Long);
        localStringBuilder.append(")\n");
        paramArrayList.append(localStringBuilder.toString());
        i += 1;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getCurrentPriorityHighestResult print result ");
      localStringBuilder.append(paramArrayList.toString());
      paramArrayList = localStringBuilder.toString();
      bool1 = true;
      QLog.i("AREngine_CommonConfigInfo", 1, paramArrayList);
      Collections.sort(paramARCloudRecogResult, new ARRecognition.2());
      localRecognitionResult.jdField_a_of_type_Long = ((ARRecognition.RecoglistionPriorityStore)paramARCloudRecogResult.get(0)).jdField_a_of_type_Long;
      if (paramARCloudRecogResult.size() != 1) {
        bool1 = false;
      }
      localRecognitionResult.jdField_a_of_type_Boolean = bool1;
    }
    return localRecognitionResult;
  }
  
  public static boolean a(long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    boolean bool2 = false;
    boolean bool3 = false;
    boolean bool4 = false;
    boolean bool5 = false;
    boolean bool6 = false;
    boolean bool7 = false;
    boolean bool1 = false;
    if (paramInt1 != paramInt2)
    {
      if (paramInt1 < paramInt2) {
        bool1 = true;
      }
      return bool1;
    }
    if ((paramLong1 != 1L) && (paramLong2 != 1L))
    {
      if ((paramLong1 != 2L) && (paramLong2 != 2L))
      {
        if ((paramLong1 != 128L) && (paramLong2 != 128L))
        {
          if ((paramLong1 != 4L) && (paramLong2 != 4L))
          {
            if ((paramLong1 != 64L) && (paramLong2 != 64L))
            {
              if ((paramLong1 != 2048L) && (paramLong2 != 2048L)) {
                return true;
              }
              bool1 = bool2;
              if (paramLong1 == 2048L) {
                bool1 = true;
              }
              return bool1;
            }
            bool1 = bool3;
            if (paramLong1 == 64L) {
              bool1 = true;
            }
            return bool1;
          }
          bool1 = bool4;
          if (paramLong1 == 4L) {
            bool1 = true;
          }
          return bool1;
        }
        bool1 = bool5;
        if (paramLong1 == 128L) {
          bool1 = true;
        }
        return bool1;
      }
      bool1 = bool6;
      if (paramLong1 == 2L) {
        bool1 = true;
      }
      return bool1;
    }
    bool1 = bool7;
    if (paramLong1 == 1L) {
      bool1 = true;
    }
    return bool1;
  }
  
  public static boolean a(ARCloudRecogResult paramARCloudRecogResult, long paramLong)
  {
    if (paramARCloudRecogResult == null) {
      return false;
    }
    if (paramLong == 1L) {
      return ARCloudMarkerRecogResult.a(paramARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARCloudMarkerRecogResult);
    }
    if (paramLong == 2L) {
      return ARCloudObjectClassifyResult.a(paramARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARCloudObjectClassifyResult);
    }
    if (paramLong == 128L) {
      return ARMIGObjectClassifyResult.a(paramARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult);
    }
    if (paramLong == 4L) {
      return ARCloudRecogRspFaceResult.a(paramARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARCloudRecogRspFaceResult);
    }
    if (paramLong == 64L) {
      return ARCloudPreOcrResult.a(paramARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARCloudPreOcrResult);
    }
    if (paramLong == 2048L) {
      return ARCloudSceneRecogResult.a(paramARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARCloudSceneRecogResult);
    }
    return false;
  }
  
  public static boolean a(ARCloudRecogResult paramARCloudRecogResult, ArrayList<ARRecognition> paramArrayList, long paramLong)
  {
    if ((paramARCloudRecogResult != null) && (paramArrayList != null))
    {
      if (!a(paramARCloudRecogResult, paramLong)) {
        return false;
      }
      int j = a(paramArrayList, paramLong);
      int i = 0;
      while (i < paramArrayList.size())
      {
        long l = 1 << (int)((ARRecognition)paramArrayList.get(i)).jdField_a_of_type_Long;
        int k = ((ARRecognition)paramArrayList.get(i)).c;
        if ((paramLong != l) && (a(paramARCloudRecogResult, l)) && (!a(paramLong, l, j, k))) {
          return false;
        }
        i += 1;
      }
      return true;
    }
    return false;
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
    int j = 5;
    int i;
    if (paramArrayList != null)
    {
      int k = 0;
      int m;
      for (i = 5; k < paramArrayList.size(); i = m)
      {
        long l = 1 << (int)((ARRecognition)paramArrayList.get(k)).jdField_a_of_type_Long;
        if (paramLong1 == l)
        {
          m = ((ARRecognition)paramArrayList.get(k)).c;
        }
        else
        {
          m = i;
          if (paramLong2 == l)
          {
            j = ((ARRecognition)paramArrayList.get(k)).c;
            m = i;
          }
        }
        k += 1;
      }
    }
    else
    {
      i = 5;
      j = 5;
    }
    return a(paramLong1, paramLong2, i, j);
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
    localStringBuffer.append("type=");
    localStringBuffer.append(this.jdField_a_of_type_Long);
    localStringBuffer.append("CloudRecogOpen =");
    localStringBuffer.append(this.jdField_a_of_type_Int);
    localStringBuffer.append("LocalRecogOpen =");
    localStringBuffer.append(this.jdField_b_of_type_Int);
    localStringBuffer.append(", priority='");
    localStringBuffer.append(this.c);
    localStringBuffer.append('\'');
    localStringBuffer.append(", wait_ms='");
    localStringBuffer.append(this.jdField_b_of_type_Long);
    localStringBuffer.append('\'');
    localStringBuffer.append("ImagePreprocess_open =");
    localStringBuffer.append(this.d);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRecognition
 * JD-Core Version:    0.7.0.1
 */