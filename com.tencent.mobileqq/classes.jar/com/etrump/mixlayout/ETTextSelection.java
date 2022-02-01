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
    SparseArray localSparseArray = this.jdField_a_of_type_AndroidUtilSparseArray;
    if (localSparseArray != null) {
      localSparseArray.clear();
    }
    this.jdField_a_of_type_ComTencentMobileqqVasFontApiIETextView.invalidate();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 >= 0)
    {
      if (paramInt2 < 0) {
        return;
      }
      Object localObject = this.jdField_a_of_type_ComEtrumpMixlayoutETLayout.a(paramInt1);
      ETTextRange localETTextRange = this.jdField_a_of_type_ComEtrumpMixlayoutETLayout.a(paramInt2);
      if ((localObject != null) && (localETTextRange != null))
      {
        this.jdField_a_of_type_AndroidUtilSparseArray.clear();
        Rect localRect1;
        if (((ETTextRange)localObject).jdField_a_of_type_Int == localETTextRange.jdField_a_of_type_Int)
        {
          localRect1 = new Rect();
          if (localETTextRange.jdField_a_of_type_AndroidGraphicsRect.left >= ((ETTextRange)localObject).jdField_a_of_type_AndroidGraphicsRect.left) {
            localRect1.set(((ETTextRange)localObject).jdField_a_of_type_AndroidGraphicsRect.left, ((ETTextRange)localObject).jdField_a_of_type_AndroidGraphicsRect.top, localETTextRange.jdField_a_of_type_AndroidGraphicsRect.right, localETTextRange.jdField_a_of_type_AndroidGraphicsRect.bottom);
          } else {
            localRect1.set(localETTextRange.jdField_a_of_type_AndroidGraphicsRect.left, localETTextRange.jdField_a_of_type_AndroidGraphicsRect.top, ((ETTextRange)localObject).jdField_a_of_type_AndroidGraphicsRect.left, ((ETTextRange)localObject).jdField_a_of_type_AndroidGraphicsRect.bottom);
          }
          localRect1.offset(this.jdField_a_of_type_ComTencentMobileqqVasFontApiIETextView.getPaddingLeft(), this.jdField_a_of_type_ComTencentMobileqqVasFontApiIETextView.getPaddingTop());
          this.jdField_a_of_type_AndroidUtilSparseArray.append(localETTextRange.jdField_a_of_type_Int, localRect1);
        }
        else
        {
          int i = ((ETTextRange)localObject).jdField_a_of_type_Int;
          int j = localETTextRange.jdField_a_of_type_Int;
          paramInt1 = i;
          paramInt2 = j;
          if (i > j)
          {
            paramInt1 = localETTextRange.jdField_a_of_type_Int;
            paramInt2 = ((ETTextRange)localObject).jdField_a_of_type_Int;
          }
          i = paramInt1;
          while (i <= paramInt2)
          {
            localRect1 = new Rect();
            Rect localRect2 = this.jdField_a_of_type_ComEtrumpMixlayoutETLayout.a(i);
            if (localRect2 == null)
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("no lineBound: ");
              ((StringBuilder)localObject).append(i);
              ((StringBuilder)localObject).append(" ");
              ((StringBuilder)localObject).append(this.jdField_a_of_type_ComEtrumpMixlayoutETLayout.a());
              ((StringBuilder)localObject).append(" ");
              ((StringBuilder)localObject).append(paramInt1);
              ((StringBuilder)localObject).append(" ");
              ((StringBuilder)localObject).append(paramInt2);
              QLog.e("ETTextSelection", 1, ((StringBuilder)localObject).toString());
              return;
            }
            if (localETTextRange.jdField_a_of_type_Int > ((ETTextRange)localObject).jdField_a_of_type_Int)
            {
              if (i == paramInt1) {
                localRect1.set(((ETTextRange)localObject).jdField_a_of_type_AndroidGraphicsRect.left, ((ETTextRange)localObject).jdField_a_of_type_AndroidGraphicsRect.top, localRect2.right, localRect2.bottom);
              } else if (i == paramInt2) {
                localRect1.set(localRect2.left, localRect2.top, localETTextRange.jdField_a_of_type_AndroidGraphicsRect.right, localETTextRange.jdField_a_of_type_AndroidGraphicsRect.bottom);
              } else {
                localRect1.set(localRect2.left, localRect2.top, localRect2.right, localRect2.bottom);
              }
            }
            else if (i == paramInt1) {
              localRect1.set(localETTextRange.jdField_a_of_type_AndroidGraphicsRect.left, localETTextRange.jdField_a_of_type_AndroidGraphicsRect.top, localRect2.right, localRect2.bottom);
            } else if (i == paramInt2) {
              localRect1.set(localRect2.left, localRect2.top, ((ETTextRange)localObject).jdField_a_of_type_AndroidGraphicsRect.left, ((ETTextRange)localObject).jdField_a_of_type_AndroidGraphicsRect.bottom);
            } else {
              localRect1.set(localRect2.left, localRect2.top, localRect2.right, localRect2.bottom);
            }
            localRect1.offset(this.jdField_a_of_type_ComTencentMobileqqVasFontApiIETextView.getPaddingLeft(), this.jdField_a_of_type_ComTencentMobileqqVasFontApiIETextView.getPaddingTop());
            this.jdField_a_of_type_AndroidUtilSparseArray.append(i, localRect1);
            i += 1;
          }
        }
        this.jdField_a_of_type_ComTencentMobileqqVasFontApiIETextView.invalidate();
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
    if (localETTextRange == null) {
      return;
    }
    if (paramArrayOfInt != null)
    {
      if (paramArrayOfInt.length < 2) {
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqVasFontApiIETextView.getLocationInWindow(paramArrayOfInt);
      if (paramBoolean)
      {
        paramArrayOfInt[0] += this.jdField_a_of_type_ComTencentMobileqqVasFontApiIETextView.getPaddingLeft() + localETTextRange.jdField_a_of_type_AndroidGraphicsRect.left;
        paramArrayOfInt[1] += this.jdField_a_of_type_ComTencentMobileqqVasFontApiIETextView.getPaddingTop() + localETTextRange.jdField_a_of_type_AndroidGraphicsRect.bottom;
        return;
      }
      paramArrayOfInt[0] += this.jdField_a_of_type_ComTencentMobileqqVasFontApiIETextView.getPaddingLeft() + localETTextRange.jdField_a_of_type_AndroidGraphicsRect.right;
      paramArrayOfInt[1] += this.jdField_a_of_type_ComTencentMobileqqVasFontApiIETextView.getPaddingTop() + localETTextRange.jdField_a_of_type_AndroidGraphicsRect.bottom;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.etrump.mixlayout.ETTextSelection
 * JD-Core Version:    0.7.0.1
 */