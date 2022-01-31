package com.tencent.mobileqq.activity.photo.album;

import bhte;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.GestureSelectGridView;
import java.util.HashSet;

class AbstractPhotoListActivity$1
  implements bhte
{
  boolean mIsSelected;
  int mMaxIndex;
  int mMinIndex;
  
  AbstractPhotoListActivity$1(AbstractPhotoListActivity paramAbstractPhotoListActivity) {}
  
  public void onSelectBegin(int paramInt)
  {
    boolean bool = false;
    if (this.this$0.mPhotoListData.isSingleMode) {}
    LocalMediaInfo localLocalMediaInfo;
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("OnSelectListener", 2, "onSelectBegin beginIndex:" + paramInt);
      }
      this.this$0.mPhotoListData.presendPathSet.clear();
      this.this$0.mPhotoListData.cancelPresendPathSet.clear();
      this.this$0.mPhotoListData.hasShownMaxSelectToast = false;
      this.mIsSelected = false;
      this.mMinIndex = paramInt;
      this.mMaxIndex = paramInt;
      localLocalMediaInfo = this.this$0.photoListAdapter.getItem(paramInt);
      if (localLocalMediaInfo.selectStatus == 2) {
        bool = true;
      }
      this.mIsSelected = bool;
    } while (!this.this$0.mPhotoListLogic.addAndRemovePhotoByGesture(localLocalMediaInfo, this.mIsSelected));
    this.this$0.mPhotoListLogic.updateButton();
    this.this$0.mGridView.invalidateViews();
  }
  
  public void onSelectChanged(int paramInt1, int paramInt2)
  {
    if (this.this$0.mPhotoListData.isSingleMode) {}
    int j;
    int k;
    do
    {
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d("OnSelectListener", 2, "onSelectChanged beginIndex:" + paramInt1 + " selectIndex:" + paramInt2);
        }
        j = Math.min(paramInt1, paramInt2);
        k = Math.max(paramInt1, paramInt2);
        if (paramInt2 >= paramInt1) {
          break;
        }
        i = this.mMinIndex;
        this.mMinIndex = Math.min(paramInt2, this.mMinIndex);
        if (paramInt2 >= i) {
          break label323;
        }
      } while ((this.mIsSelected) && (this.this$0.mPhotoListData.hasShownMaxSelectToast));
      i -= 1;
      while (i >= paramInt2)
      {
        this.this$0.mPhotoListLogic.addAndRemovePhotoByGesture(this.this$0.photoListAdapter.getItem(i), this.mIsSelected);
        if ((this.mIsSelected) && (this.this$0.mPhotoListData.hasShownMaxSelectToast))
        {
          this.this$0.mPhotoListLogic.updateButton();
          this.this$0.mGridView.invalidateViews();
          return;
        }
        i -= 1;
      }
      i = this.mMaxIndex;
      this.mMaxIndex = Math.max(paramInt2, this.mMaxIndex);
      if (paramInt2 <= i) {
        break;
      }
    } while ((this.mIsSelected) && (this.this$0.mPhotoListData.hasShownMaxSelectToast));
    i += 1;
    while (i <= paramInt2)
    {
      this.this$0.mPhotoListLogic.addAndRemovePhotoByGesture(this.this$0.photoListAdapter.getItem(i), this.mIsSelected);
      if ((this.mIsSelected) && (this.this$0.mPhotoListData.hasShownMaxSelectToast))
      {
        this.this$0.mPhotoListLogic.updateButton();
        this.this$0.mGridView.invalidateViews();
        return;
      }
      i += 1;
    }
    label323:
    int i = this.mMinIndex;
    PhotoListLogicBase localPhotoListLogicBase;
    LocalMediaInfo localLocalMediaInfo;
    boolean bool;
    if (i < j)
    {
      localPhotoListLogicBase = this.this$0.mPhotoListLogic;
      localLocalMediaInfo = this.this$0.photoListAdapter.getItem(i);
      if (!this.mIsSelected) {}
      for (bool = true;; bool = false)
      {
        localPhotoListLogicBase.addAndRemovePhotoByGesture(localLocalMediaInfo, bool);
        i += 1;
        break;
      }
    }
    i = k + 1;
    if (i <= this.mMaxIndex)
    {
      localPhotoListLogicBase = this.this$0.mPhotoListLogic;
      localLocalMediaInfo = this.this$0.photoListAdapter.getItem(i);
      if (!this.mIsSelected) {}
      for (bool = true;; bool = false)
      {
        localPhotoListLogicBase.addAndRemovePhotoByGesture(localLocalMediaInfo, bool);
        i += 1;
        break;
      }
    }
    if (paramInt2 < paramInt1)
    {
      this.mMinIndex = paramInt2;
      if (this.mMaxIndex > paramInt1) {
        this.mMaxIndex = paramInt1;
      }
    }
    for (;;)
    {
      this.this$0.mPhotoListLogic.updateButton();
      this.this$0.mGridView.invalidateViews();
      return;
      this.mMaxIndex = paramInt2;
      if (this.mMinIndex < paramInt1) {
        this.mMinIndex = paramInt1;
      }
    }
  }
  
  public void onSelectEnd()
  {
    this.this$0.mPhotoListLogic.onGestureSelectEnd(this.mIsSelected, this.mMaxIndex, this.mMinIndex);
    if (QLog.isColorLevel()) {
      QLog.d("OnSelectListener", 2, "onSelectEnd");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.AbstractPhotoListActivity.1
 * JD-Core Version:    0.7.0.1
 */