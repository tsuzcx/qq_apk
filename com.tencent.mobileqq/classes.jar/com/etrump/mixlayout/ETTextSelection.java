package com.etrump.mixlayout;

import android.graphics.Rect;
import android.util.SparseArray;
import com.tencent.mobileqq.vas.font.api.IETextView;
import com.tencent.qphone.base.util.QLog;

class ETTextSelection
{
  private SparseArray<Rect> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private ETLayout jdField_a_of_type_ComEtrumpMixlayoutETLayout;
  private IETextView jdField_a_of_type_ComTencentMobileqqVasFontApiIETextView;
  private int[] jdField_a_of_type_ArrayOfInt = new int[2];
  
  public ETTextSelection(IETextView paramIETextView, ETLayout paramETLayout)
  {
    this.jdField_a_of_type_ComTencentMobileqqVasFontApiIETextView = paramIETextView;
    this.jdField_a_of_type_ComEtrumpMixlayoutETLayout = paramETLayout;
  }
  
  public int a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentMobileqqVasFontApiIETextView.getLocationInWindow(this.jdField_a_of_type_ArrayOfInt);
    return this.jdField_a_of_type_ComEtrumpMixlayoutETLayout.a(paramInt1 - this.jdField_a_of_type_ArrayOfInt[0] - this.jdField_a_of_type_ComTencentMobileqqVasFontApiIETextView.getPaddingLeft(), paramInt2 - this.jdField_a_of_type_ArrayOfInt[1] - this.jdField_a_of_type_ComTencentMobileqqVasFontApiIETextView.getPaddingTop());
  }
  
  SparseArray<Rect> a()
  {
    return this.jdField_a_of_type_AndroidUtilSparseArray;
  }
  
  void a()
  {
    if (this.jdField_a_of_type_AndroidUtilSparseArray != null) {
      this.jdField_a_of_type_AndroidUtilSparseArray.clear();
    }
    this.jdField_a_of_type_ComTencentMobileqqVasFontApiIETextView.invalidate();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 < 0) || (paramInt2 < 0)) {}
    ETTextRange localETTextRange1;
    ETTextRange localETTextRange2;
    do
    {
      return;
      localETTextRange1 = this.jdField_a_of_type_ComEtrumpMixlayoutETLayout.a(paramInt1);
      localETTextRange2 = this.jdField_a_of_type_ComEtrumpMixlayoutETLayout.a(paramInt2);
    } while ((localETTextRange1 == null) || (localETTextRange2 == null));
    this.jdField_a_of_type_AndroidUtilSparseArray.clear();
    Rect localRect1;
    if (localETTextRange1.jdField_a_of_type_Int == localETTextRange2.jdField_a_of_type_Int)
    {
      localRect1 = new Rect();
      if (localETTextRange2.jdField_a_of_type_AndroidGraphicsRect.left >= localETTextRange1.jdField_a_of_type_AndroidGraphicsRect.left) {
        localRect1.set(localETTextRange1.jdField_a_of_type_AndroidGraphicsRect.left, localETTextRange1.jdField_a_of_type_AndroidGraphicsRect.top, localETTextRange2.jdField_a_of_type_AndroidGraphicsRect.right, localETTextRange2.jdField_a_of_type_AndroidGraphicsRect.bottom);
      }
      for (;;)
      {
        localRect1.offset(this.jdField_a_of_type_ComTencentMobileqqVasFontApiIETextView.getPaddingLeft(), this.jdField_a_of_type_ComTencentMobileqqVasFontApiIETextView.getPaddingTop());
        this.jdField_a_of_type_AndroidUtilSparseArray.append(localETTextRange2.jdField_a_of_type_Int, localRect1);
        this.jdField_a_of_type_ComTencentMobileqqVasFontApiIETextView.invalidate();
        return;
        localRect1.set(localETTextRange2.jdField_a_of_type_AndroidGraphicsRect.left, localETTextRange2.jdField_a_of_type_AndroidGraphicsRect.top, localETTextRange1.jdField_a_of_type_AndroidGraphicsRect.left, localETTextRange1.jdField_a_of_type_AndroidGraphicsRect.bottom);
      }
    }
    int i = localETTextRange1.jdField_a_of_type_Int;
    int j = localETTextRange2.jdField_a_of_type_Int;
    paramInt2 = j;
    paramInt1 = i;
    if (i > j)
    {
      paramInt1 = localETTextRange2.jdField_a_of_type_Int;
      paramInt2 = localETTextRange1.jdField_a_of_type_Int;
    }
    i = paramInt1;
    label249:
    Rect localRect2;
    if (i <= paramInt2)
    {
      localRect1 = new Rect();
      localRect2 = this.jdField_a_of_type_ComEtrumpMixlayoutETLayout.a(i);
      if (localRect2 == null)
      {
        QLog.e("ETTextSelection", 1, "no lineBound: " + i + " " + this.jdField_a_of_type_ComEtrumpMixlayoutETLayout.a() + " " + paramInt1 + " " + paramInt2);
        return;
      }
      if (localETTextRange2.jdField_a_of_type_Int <= localETTextRange1.jdField_a_of_type_Int) {
        break label493;
      }
      if (i != paramInt1) {
        break label426;
      }
      localRect1.set(localETTextRange1.jdField_a_of_type_AndroidGraphicsRect.left, localETTextRange1.jdField_a_of_type_AndroidGraphicsRect.top, localRect2.right, localRect2.bottom);
    }
    for (;;)
    {
      localRect1.offset(this.jdField_a_of_type_ComTencentMobileqqVasFontApiIETextView.getPaddingLeft(), this.jdField_a_of_type_ComTencentMobileqqVasFontApiIETextView.getPaddingTop());
      this.jdField_a_of_type_AndroidUtilSparseArray.append(i, localRect1);
      i += 1;
      break label249;
      break;
      label426:
      if (i == paramInt2)
      {
        localRect1.set(localRect2.left, localRect2.top, localETTextRange2.jdField_a_of_type_AndroidGraphicsRect.right, localETTextRange2.jdField_a_of_type_AndroidGraphicsRect.bottom);
      }
      else
      {
        localRect1.set(localRect2.left, localRect2.top, localRect2.right, localRect2.bottom);
        continue;
        label493:
        if (i == paramInt1) {
          localRect1.set(localETTextRange2.jdField_a_of_type_AndroidGraphicsRect.left, localETTextRange2.jdField_a_of_type_AndroidGraphicsRect.top, localRect2.right, localRect2.bottom);
        } else if (i == paramInt2) {
          localRect1.set(localRect2.left, localRect2.top, localETTextRange1.jdField_a_of_type_AndroidGraphicsRect.left, localETTextRange1.jdField_a_of_type_AndroidGraphicsRect.bottom);
        } else {
          localRect1.set(localRect2.left, localRect2.top, localRect2.right, localRect2.bottom);
        }
      }
    }
  }
  
  public void a(int paramInt, int[] paramArrayOfInt, boolean paramBoolean)
  {
    int i = paramInt;
    if (!paramBoolean) {
      i = paramInt - 1;
    }
    ETTextRange localETTextRange = this.jdField_a_of_type_ComEtrumpMixlayoutETLayout.a(i);
    if (localETTextRange == null) {}
    while ((paramArrayOfInt == null) || (paramArrayOfInt.length < 2)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqVasFontApiIETextView.getLocationInWindow(paramArrayOfInt);
    if (paramBoolean)
    {
      paramArrayOfInt[0] += this.jdField_a_of_type_ComTencentMobileqqVasFontApiIETextView.getPaddingLeft() + localETTextRange.jdField_a_of_type_AndroidGraphicsRect.left;
      paramInt = paramArrayOfInt[1];
      i = this.jdField_a_of_type_ComTencentMobileqqVasFontApiIETextView.getPaddingTop();
      paramArrayOfInt[1] = (localETTextRange.jdField_a_of_type_AndroidGraphicsRect.bottom + i + paramInt);
      return;
    }
    paramArrayOfInt[0] += this.jdField_a_of_type_ComTencentMobileqqVasFontApiIETextView.getPaddingLeft() + localETTextRange.jdField_a_of_type_AndroidGraphicsRect.right;
    paramInt = paramArrayOfInt[1];
    i = this.jdField_a_of_type_ComTencentMobileqqVasFontApiIETextView.getPaddingTop();
    paramArrayOfInt[1] = (localETTextRange.jdField_a_of_type_AndroidGraphicsRect.bottom + i + paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.etrump.mixlayout.ETTextSelection
 * JD-Core Version:    0.7.0.1
 */