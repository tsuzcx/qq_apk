package com.tencent.biz.qrcode.activity;

import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import com.tencent.qbar.QBarResult;
import java.util.ArrayList;
import java.util.Iterator;
import zmj;

public class ScannerResult
  implements Parcelable
{
  public static final Parcelable.Creator<ScannerResult> CREATOR = new zmj();
  public ArrayList<QBarResult> a;
  public boolean a;
  public ArrayList<QMiniResult> b;
  public boolean b;
  
  public ScannerResult() {}
  
  public ScannerResult(Parcel paramParcel)
  {
    this.jdField_a_of_type_JavaUtilArrayList = paramParcel.createTypedArrayList(QBarResult.CREATOR);
    this.jdField_b_of_type_JavaUtilArrayList = paramParcel.createTypedArrayList(QMiniResult.CREATOR);
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.jdField_a_of_type_Boolean = bool1;
      if (paramParcel.readByte() == 0) {
        break label62;
      }
    }
    label62:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.jdField_b_of_type_Boolean = bool1;
      return;
      bool1 = false;
      break;
    }
  }
  
  public int a()
  {
    int i = 0;
    if (d()) {
      i = 1;
    }
    int j = i;
    if (c()) {
      j = i | 0x2;
    }
    return j;
  }
  
  public Pair<StringBuilder, StringBuilder> a()
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty()))
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder1.append(((QBarResult)this.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_JavaLangString);
      localStringBuilder2.append(((QBarResult)this.jdField_a_of_type_JavaUtilArrayList.get(0)).b);
      return new Pair(localStringBuilder2, localStringBuilder1);
    }
    return null;
  }
  
  public String a()
  {
    if ((this.jdField_b_of_type_JavaUtilArrayList != null) && (!this.jdField_b_of_type_JavaUtilArrayList.isEmpty())) {
      return ((QMiniResult)this.jdField_b_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_JavaLangString;
    }
    return null;
  }
  
  public void a()
  {
    if (!b()) {}
    do
    {
      return;
      if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 1))
      {
        localObject = (QBarResult)this.jdField_a_of_type_JavaUtilArrayList.get(0);
        this.jdField_a_of_type_JavaUtilArrayList.clear();
        this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
      }
      if ((d()) && (c())) {
        this.jdField_b_of_type_JavaUtilArrayList.clear();
      }
    } while ((this.jdField_b_of_type_JavaUtilArrayList == null) || (this.jdField_b_of_type_JavaUtilArrayList.size() <= 1));
    Object localObject = (QMiniResult)this.jdField_b_of_type_JavaUtilArrayList.get(0);
    this.jdField_b_of_type_JavaUtilArrayList.clear();
    this.jdField_b_of_type_JavaUtilArrayList.add(localObject);
  }
  
  public void a(SparseArray<Object> paramSparseArray)
  {
    Object localObject = a();
    if (localObject != null) {
      paramSparseArray.put(1, localObject);
    }
    localObject = a();
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      paramSparseArray.put(2, localObject);
    }
  }
  
  public void a(String paramString)
  {
    a(paramString, new Rect(), 0.0F, 0, 0);
  }
  
  public void a(String paramString, Rect paramRect, float paramFloat, int paramInt1, int paramInt2)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    QMiniResult localQMiniResult = new QMiniResult();
    localQMiniResult.jdField_a_of_type_JavaLangString = paramString;
    if ((paramInt1 > 0) && (paramInt2 > 0)) {}
    for (localQMiniResult.jdField_a_of_type_AndroidGraphicsRectF = new RectF(paramRect.left * 1.0F / paramInt1, paramRect.top * 1.0F / paramInt2, paramRect.right * 1.0F / paramInt1, paramRect.bottom * 1.0F / paramInt2);; localQMiniResult.jdField_a_of_type_AndroidGraphicsRectF = new RectF())
    {
      localQMiniResult.jdField_a_of_type_Float = paramFloat;
      if (this.jdField_b_of_type_JavaUtilArrayList == null) {
        this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
      }
      this.jdField_b_of_type_JavaUtilArrayList.add(localQMiniResult);
      return;
    }
  }
  
  public boolean a()
  {
    Iterator localIterator;
    int j;
    Object localObject;
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty()))
    {
      localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      j = 0;
      i = j;
      if (!localIterator.hasNext()) {
        break label79;
      }
      localObject = (QBarResult)localIterator.next();
      if ((((QBarResult)localObject).jdField_a_of_type_AndroidGraphicsRectF == null) || (((QBarResult)localObject).jdField_a_of_type_AndroidGraphicsRectF.isEmpty())) {
        break label172;
      }
    }
    label172:
    for (int i = j + 1;; i = j)
    {
      j = i;
      break;
      i = 0;
      label79:
      j = i;
      if (this.jdField_b_of_type_JavaUtilArrayList != null)
      {
        j = i;
        if (!this.jdField_b_of_type_JavaUtilArrayList.isEmpty()) {
          if (this.jdField_a_of_type_Boolean) {}
        }
      }
      while (j <= 1)
      {
        return false;
        localIterator = this.jdField_b_of_type_JavaUtilArrayList.iterator();
        for (;;)
        {
          j = i;
          if (!localIterator.hasNext()) {
            break;
          }
          localObject = (QMiniResult)localIterator.next();
          if ((((QMiniResult)localObject).jdField_a_of_type_AndroidGraphicsRectF != null) && (!((QMiniResult)localObject).jdField_a_of_type_AndroidGraphicsRectF.isEmpty())) {
            i += 1;
          }
        }
      }
      return true;
    }
  }
  
  public boolean b()
  {
    return (c()) || (d());
  }
  
  public boolean c()
  {
    return (this.jdField_b_of_type_JavaUtilArrayList != null) && (!this.jdField_b_of_type_JavaUtilArrayList.isEmpty());
  }
  
  public boolean d()
  {
    return (this.jdField_a_of_type_JavaUtilArrayList != null) && (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty());
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "ScannerResult{hasQrCode:" + d() + " hasMiniCode:" + c() + " maybeMulti:" + this.jdField_b_of_type_Boolean + " hasMultiResult:" + a() + " qMiniUseAIDetect:" + this.jdField_a_of_type_Boolean + "\nqBarResults=" + this.jdField_a_of_type_JavaUtilArrayList + "\nqMiniResults=" + this.jdField_b_of_type_JavaUtilArrayList + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    paramParcel.writeTypedList(this.jdField_a_of_type_JavaUtilArrayList);
    paramParcel.writeTypedList(this.jdField_b_of_type_JavaUtilArrayList);
    if (this.jdField_a_of_type_Boolean)
    {
      paramInt = 1;
      paramParcel.writeByte((byte)paramInt);
      if (!this.jdField_b_of_type_Boolean) {
        break label54;
      }
    }
    label54:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      return;
      paramInt = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.ScannerResult
 * JD-Core Version:    0.7.0.1
 */