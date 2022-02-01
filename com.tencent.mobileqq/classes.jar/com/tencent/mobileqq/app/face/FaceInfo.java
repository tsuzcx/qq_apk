package com.tencent.mobileqq.app.face;

import AvatarInfo.QQHeadInfo;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

public class FaceInfo
  implements Parcelable
{
  public static final Parcelable.Creator<FaceInfo> CREATOR = new FaceInfo.1();
  public static int f = 0;
  public static int g = 1;
  public static int h = 2;
  public static int i = 3;
  public static int j = 0;
  public static int k = j + 1;
  public static int l = k + 1;
  public static int m = l + 1;
  public static int n = m + 1;
  public static int o = n + 1;
  public static int p = o + 1;
  public static int q = p + 1;
  public static int r = q + 1;
  public static int s = r + 1;
  public byte a;
  public int a;
  public long a;
  public QQHeadInfo a;
  public String a;
  public boolean a;
  public long[] a;
  public byte b;
  public int b;
  public String b;
  public boolean b;
  public int c;
  public String c;
  public boolean c;
  public int d;
  public String d;
  public int e;
  private String e;
  
  public FaceInfo()
  {
    this.jdField_a_of_type_ArrayOfLong = null;
    int i2 = 0;
    this.jdField_e_of_type_Int = 0;
    int i1 = i2;
    if (this.jdField_a_of_type_ArrayOfLong == null)
    {
      this.jdField_a_of_type_ArrayOfLong = new long[s];
      i1 = i2;
    }
    while (i1 < s)
    {
      this.jdField_a_of_type_ArrayOfLong[i1] = 0L;
      i1 += 1;
    }
  }
  
  public FaceInfo(int paramInt1, String paramString, boolean paramBoolean1, byte paramByte, int paramInt2, boolean paramBoolean2, int paramInt3, int paramInt4)
  {
    this.jdField_a_of_type_ArrayOfLong = null;
    this.jdField_e_of_type_Int = 0;
    a(paramInt1, paramString, paramBoolean1, paramByte, paramInt2, paramBoolean2, paramInt3, paramInt4, false, 100);
  }
  
  public FaceInfo(int paramInt1, String paramString, boolean paramBoolean1, byte paramByte, int paramInt2, boolean paramBoolean2, int paramInt3, boolean paramBoolean3, int paramInt4)
  {
    this.jdField_a_of_type_ArrayOfLong = null;
    this.jdField_e_of_type_Int = 0;
    a(paramInt1, paramString, paramBoolean1, paramByte, paramInt2, paramBoolean2, paramInt3, 0, paramBoolean3, paramInt4);
  }
  
  private String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 8: 
      return "TIME_REQ_END";
    case 7: 
      return "TIME_END_DECODE";
    case 6: 
      return "TIME_BEGIN_DECODE";
    case 5: 
      return "TIME_END_DOWNLOAD";
    case 4: 
      return "TIME_BEGIN_DOWNLOAD";
    case 3: 
      return "TIME_END_DOWNLOADINFO";
    case 2: 
      return "TIME_BEGIN_DOWNLOADINFO";
    case 1: 
      return "TIME_REQ_READY";
    }
    return "TIME_BEGINE";
  }
  
  public static String a(int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    StringBuilder localStringBuilder = new StringBuilder(100);
    if (paramInt1 == 32)
    {
      localStringBuilder.append(paramInt1);
      localStringBuilder.append("_");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append("_");
      localStringBuilder.append(paramString);
    }
    else if (paramInt1 == 16)
    {
      localStringBuilder.append(paramInt1);
      localStringBuilder.append("_");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append("_");
      localStringBuilder.append(paramString);
    }
    else if (paramInt1 == 116)
    {
      localStringBuilder.append(paramInt1);
      localStringBuilder.append("_");
      localStringBuilder.append(paramInt3);
      localStringBuilder.append("_");
      localStringBuilder.append(paramString);
    }
    else
    {
      localStringBuilder.append(paramInt1);
      localStringBuilder.append("_");
      localStringBuilder.append(paramString);
    }
    return localStringBuilder.toString();
  }
  
  public static String a(int paramInt1, String paramString, int paramInt2, int paramInt3, int paramInt4)
  {
    StringBuilder localStringBuilder = new StringBuilder(16);
    if (paramInt1 != 4)
    {
      if (paramInt1 != 16)
      {
        if (paramInt1 != 32)
        {
          if (paramInt1 != 101)
          {
            if (paramInt1 != 103)
            {
              if (paramInt1 == 116)
              {
                localStringBuilder.append("apollo_");
                localStringBuilder.append(Integer.toString(paramInt4));
                localStringBuilder.append("_");
              }
            }
            else {
              localStringBuilder.append("sub_");
            }
          }
          else {
            localStringBuilder.append("dis_g_");
          }
        }
        else
        {
          localStringBuilder.append("stranger_");
          localStringBuilder.append(Integer.toString(paramInt2));
          localStringBuilder.append("_");
        }
      }
      else
      {
        localStringBuilder.append("qcall_");
        localStringBuilder.append(Integer.toString(paramInt2));
        localStringBuilder.append("_");
      }
    }
    else {
      localStringBuilder.append("troop_");
    }
    localStringBuilder.append(paramString);
    if (paramInt3 > 0)
    {
      localStringBuilder.append("_");
      localStringBuilder.append(paramInt3);
    }
    return localStringBuilder.toString();
  }
  
  public static String a(QQHeadInfo paramQQHeadInfo, int paramInt)
  {
    if ((paramQQHeadInfo != null) && (!TextUtils.isEmpty(paramQQHeadInfo.downLoadUrl)))
    {
      if (paramQQHeadInfo.dstUsrType == 116)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramQQHeadInfo.downLoadUrl);
        localStringBuilder.append("_");
        localStringBuilder.append(paramQQHeadInfo.sizeType);
        localStringBuilder.append("_");
        localStringBuilder.append(paramQQHeadInfo.uin);
        return localStringBuilder.toString();
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramQQHeadInfo.downLoadUrl);
      localStringBuilder.append("_");
      localStringBuilder.append(paramInt);
      return localStringBuilder.toString();
    }
    return "";
  }
  
  public byte a()
  {
    if (this.jdField_a_of_type_Byte != 1) {
      return 1;
    }
    return 0;
  }
  
  public String a()
  {
    if (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
      this.jdField_c_of_type_JavaLangString = a(this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_Int, this.jdField_c_of_type_Int, this.jdField_d_of_type_Int);
    }
    return this.jdField_c_of_type_JavaLangString;
  }
  
  public void a(int paramInt)
  {
    a(paramInt, 0);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    Object localObject = this.jdField_a_of_type_ArrayOfLong;
    if (localObject == null) {
      return;
    }
    if ((paramInt1 >= 0) && (paramInt1 < s))
    {
      localObject[paramInt1] = System.currentTimeMillis();
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("markTime tag= ");
        ((StringBuilder)localObject).append(paramInt1);
        ((StringBuilder)localObject).append("mTimes[tag] = ");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_ArrayOfLong[paramInt1]);
        ((StringBuilder)localObject).append("this=");
        ((StringBuilder)localObject).append(this);
        QLog.i("FaceInfo", 2, ((StringBuilder)localObject).toString());
      }
      if ((paramInt1 == r) && (QLog.isColorLevel()))
      {
        localObject = new StringBuilder(260);
        ((StringBuilder)localObject).append("id=");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
        ((StringBuilder)localObject).append(",");
        ((StringBuilder)localObject).append("idType=");
        ((StringBuilder)localObject).append(this.jdField_b_of_type_Int);
        ((StringBuilder)localObject).append(",");
        ((StringBuilder)localObject).append("headType=");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
        ((StringBuilder)localObject).append(",");
        ((StringBuilder)localObject).append("shape=");
        ((StringBuilder)localObject).append(this.jdField_c_of_type_Int);
        ((StringBuilder)localObject).append(" ,Times={");
        paramInt1 = 0;
        long l2 = 0L;
        long l1 = 0L;
        long[] arrayOfLong;
        for (;;)
        {
          arrayOfLong = this.jdField_a_of_type_ArrayOfLong;
          if (paramInt1 >= arrayOfLong.length) {
            break;
          }
          ((StringBuilder)localObject).append("[");
          ((StringBuilder)localObject).append(a(paramInt1));
          ((StringBuilder)localObject).append(",");
          ((StringBuilder)localObject).append(this.jdField_a_of_type_ArrayOfLong[paramInt1]);
          ((StringBuilder)localObject).append(",");
          arrayOfLong = this.jdField_a_of_type_ArrayOfLong;
          if (arrayOfLong[paramInt1] > 0L)
          {
            ((StringBuilder)localObject).append(Math.abs(l1 - arrayOfLong[paramInt1]));
            ((StringBuilder)localObject).append("]");
          }
          else
          {
            ((StringBuilder)localObject).append("0");
            ((StringBuilder)localObject).append("]");
          }
          arrayOfLong = this.jdField_a_of_type_ArrayOfLong;
          if (arrayOfLong[paramInt1] > 0L) {
            l1 = arrayOfLong[paramInt1];
          }
          paramInt1 += 1;
        }
        paramInt1 = r;
        l1 = l2;
        if (arrayOfLong[paramInt1] > 0L)
        {
          int i1 = j;
          l1 = l2;
          if (arrayOfLong[i1] > 0L) {
            l1 = Math.abs(arrayOfLong[paramInt1] - arrayOfLong[i1]);
          }
        }
        ((StringBuilder)localObject).append("}, cost = ");
        ((StringBuilder)localObject).append(l1);
        ((StringBuilder)localObject).append(", result = ");
        ((StringBuilder)localObject).append(paramInt2);
        QLog.i("FaceCost", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  public void a(int paramInt1, String paramString, boolean paramBoolean1, byte paramByte, int paramInt2, boolean paramBoolean2, int paramInt3, int paramInt4, boolean paramBoolean3, int paramInt5)
  {
    this.jdField_a_of_type_Boolean = paramBoolean3;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_b_of_type_Boolean = paramBoolean1;
    this.jdField_a_of_type_Byte = paramByte;
    this.jdField_c_of_type_Int = paramInt2;
    this.jdField_c_of_type_Boolean = paramBoolean2;
    this.jdField_b_of_type_Int = paramInt3;
    this.jdField_c_of_type_JavaLangString = null;
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_d_of_type_JavaLangString = null;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_e_of_type_Int = paramInt4;
    this.jdField_d_of_type_Int = paramInt5;
    if (this.jdField_a_of_type_ArrayOfLong == null) {
      this.jdField_a_of_type_ArrayOfLong = new long[s];
    }
    paramInt1 = 0;
    while (paramInt1 < s)
    {
      this.jdField_a_of_type_ArrayOfLong[paramInt1] = 0L;
      paramInt1 += 1;
    }
  }
  
  public void a(QQHeadInfo paramQQHeadInfo)
  {
    if (paramQQHeadInfo == null) {
      return;
    }
    this.jdField_a_of_type_AvatarInfoQQHeadInfo = paramQQHeadInfo;
  }
  
  public void a(Parcel paramParcel)
  {
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_b_of_type_Int = paramParcel.readInt();
    this.jdField_c_of_type_Int = paramParcel.readInt();
    this.jdField_d_of_type_Int = paramParcel.readInt();
    this.jdField_a_of_type_Byte = paramParcel.readByte();
    int i1 = paramParcel.readByte();
    boolean bool = true;
    if (i1 != 1) {
      bool = false;
    }
    this.jdField_c_of_type_Boolean = bool;
    this.jdField_d_of_type_JavaLangString = paramParcel.readString();
    this.jdField_a_of_type_Long = paramParcel.readLong();
    this.jdField_a_of_type_AvatarInfoQQHeadInfo = ((QQHeadInfo)paramParcel.readParcelable(getClass().getClassLoader()));
  }
  
  public boolean a(int paramInt, long paramLong)
  {
    long[] arrayOfLong = this.jdField_a_of_type_ArrayOfLong;
    boolean bool2 = false;
    if (arrayOfLong == null) {
      return false;
    }
    boolean bool1 = bool2;
    if (paramInt >= 0)
    {
      bool1 = bool2;
      if (paramInt < s) {
        if (arrayOfLong[paramInt] == 0L)
        {
          bool1 = bool2;
          if (QLog.isDevelopLevel())
          {
            QLog.i("FaceInfo", 2, "isTimeOut");
            return false;
          }
        }
        else
        {
          bool1 = bool2;
          if (Math.abs(System.currentTimeMillis() - this.jdField_a_of_type_ArrayOfLong[paramInt]) >= paramLong) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public String b()
  {
    if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
      this.jdField_b_of_type_JavaLangString = a(this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_Int, this.jdField_d_of_type_Int);
    }
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public String c()
  {
    if (TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) {
      this.jdField_e_of_type_JavaLangString = a(this.jdField_a_of_type_AvatarInfoQQHeadInfo, this.jdField_b_of_type_Int);
    }
    return this.jdField_e_of_type_JavaLangString;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    paramObject = (FaceInfo)paramObject;
    return (this.jdField_a_of_type_Int == paramObject.jdField_a_of_type_Int) && (TextUtils.equals(this.jdField_a_of_type_JavaLangString, paramObject.jdField_a_of_type_JavaLangString)) && (this.jdField_b_of_type_Int == paramObject.jdField_b_of_type_Int) && (this.jdField_c_of_type_Int == paramObject.jdField_c_of_type_Int);
  }
  
  public int hashCode()
  {
    int i2 = this.jdField_a_of_type_Int;
    int i1;
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      i1 = 0;
    } else {
      i1 = this.jdField_a_of_type_JavaLangString.hashCode();
    }
    return i2 | i1;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(100);
    localStringBuilder.append("[");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(",");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append(",");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(",");
    localStringBuilder.append(this.jdField_c_of_type_Int);
    localStringBuilder.append(",");
    localStringBuilder.append(this.jdField_d_of_type_Int);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.face.FaceInfo
 * JD-Core Version:    0.7.0.1
 */