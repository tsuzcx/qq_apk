package com.tencent.av.wtogether.data;

import com.tencent.qphone.base.util.QLog;

public class WTogetherPlayInfo
{
  public float a;
  public int a;
  public long a;
  public final WTFileInfo a;
  public WTVideoInfo a;
  public boolean[] a;
  public int b;
  public long b;
  public long c;
  
  public WTogetherPlayInfo(WTFileInfo paramWTFileInfo)
  {
    this.jdField_a_of_type_ArrayOfBoolean = new boolean[3];
    this.jdField_a_of_type_ComTencentAvWtogetherDataWTFileInfo = paramWTFileInfo;
    int i = paramWTFileInfo.jdField_a_of_type_Int;
    if (i == 0)
    {
      this.jdField_a_of_type_ComTencentAvWtogetherDataWTVideoInfo = null;
      return;
    }
    this.jdField_a_of_type_ComTencentAvWtogetherDataWTVideoInfo = new WTVideoInfo(i, paramWTFileInfo.jdField_a_of_type_JavaLangString, paramWTFileInfo.d, paramWTFileInfo.e, paramWTFileInfo.f, paramWTFileInfo.h, paramWTFileInfo.i, paramWTFileInfo.jdField_b_of_type_Int, paramWTFileInfo.j, paramWTFileInfo.jdField_a_of_type_Long);
  }
  
  public float a()
  {
    return this.jdField_a_of_type_Float;
  }
  
  public long a()
  {
    long l4 = System.currentTimeMillis();
    long l2 = this.jdField_a_of_type_Long;
    long l3 = l2;
    if (this.jdField_a_of_type_Int == 0)
    {
      l3 = l2;
      if (l2 != 0L)
      {
        l3 = this.jdField_b_of_type_Long;
        long l1 = l2;
        if (l3 != 0L)
        {
          l1 = l2;
          if (l4 - l3 > 0L) {
            l1 = l2 + ((float)(l4 - l3) * this.jdField_a_of_type_Float);
          }
        }
        l2 = this.jdField_a_of_type_Long;
        if (l1 < l2) {
          return l2;
        }
        l2 = this.c;
        l3 = l1;
        if (l2 > 0L)
        {
          l3 = l1;
          if (l1 > l2) {
            return l2;
          }
        }
      }
    }
    return l3;
  }
  
  public void a(int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_Int != paramInt)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("updatePlayState, [");
        localStringBuilder.append(this.jdField_a_of_type_Int);
        localStringBuilder.append("-->");
        localStringBuilder.append(paramInt);
        localStringBuilder.append("], from[");
        localStringBuilder.append(paramString);
        localStringBuilder.append("]");
        QLog.i("WTogetherPlayInfo", 2, localStringBuilder.toString());
      }
      this.jdField_a_of_type_Int = paramInt;
    }
  }
  
  public boolean a()
  {
    WTVideoInfo localWTVideoInfo = this.jdField_a_of_type_ComTencentAvWtogetherDataWTVideoInfo;
    return (localWTVideoInfo != null) && (localWTVideoInfo.jdField_b_of_type_Int == 1) && (this.jdField_b_of_type_Int <= 0);
  }
  
  public boolean a(WTVideoInfo paramWTVideoInfo)
  {
    WTVideoInfo localWTVideoInfo = this.jdField_a_of_type_ComTencentAvWtogetherDataWTVideoInfo;
    return (localWTVideoInfo != null) && (localWTVideoInfo.a(paramWTVideoInfo));
  }
  
  public boolean b()
  {
    WTVideoInfo localWTVideoInfo = this.jdField_a_of_type_ComTencentAvWtogetherDataWTVideoInfo;
    return (localWTVideoInfo != null) && (localWTVideoInfo.c());
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_ComTencentAvWtogetherDataWTFileInfo.a();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PlayInfo{playState: ");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", playTimeMills: ");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append(", playRate: ");
    localStringBuilder.append(this.jdField_a_of_type_Float);
    localStringBuilder.append(", leftTime: ");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append(", lastSyncTimeMills: ");
    localStringBuilder.append(this.jdField_b_of_type_Long);
    localStringBuilder.append(", durationTimeMills: ");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", fileInfo: ");
    Object localObject1 = this.jdField_a_of_type_ComTencentAvWtogetherDataWTFileInfo;
    Object localObject2 = null;
    if (localObject1 != null) {
      localObject1 = ((WTFileInfo)localObject1).toString();
    } else {
      localObject1 = null;
    }
    localStringBuilder.append((String)localObject1);
    localStringBuilder.append(", videoInfo: ");
    WTVideoInfo localWTVideoInfo = this.jdField_a_of_type_ComTencentAvWtogetherDataWTVideoInfo;
    localObject1 = localObject2;
    if (localWTVideoInfo != null) {
      localObject1 = localWTVideoInfo.toString();
    }
    localStringBuilder.append((String)localObject1);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.wtogether.data.WTogetherPlayInfo
 * JD-Core Version:    0.7.0.1
 */