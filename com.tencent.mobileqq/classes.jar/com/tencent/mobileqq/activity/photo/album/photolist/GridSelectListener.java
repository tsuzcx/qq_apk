package com.tencent.mobileqq.activity.photo.album.photolist;

import android.os.Handler;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.OtherCommonData;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.PhotoGridView.OnSelectListener;

public class GridSelectListener
  implements PhotoGridView.OnSelectListener
{
  int jdField_a_of_type_Int;
  Handler jdField_a_of_type_AndroidOsHandler = new Handler();
  PhotoListSceneBase jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListSceneBase;
  boolean jdField_a_of_type_Boolean;
  int b;
  
  public GridSelectListener(PhotoListSceneBase paramPhotoListSceneBase)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListSceneBase = paramPhotoListSceneBase;
  }
  
  private boolean a(int paramInt1, int paramInt2)
  {
    if (paramInt2 < paramInt1)
    {
      paramInt1 = this.b;
      this.b = Math.min(paramInt2, paramInt1);
      if (paramInt2 < paramInt1)
      {
        if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListSceneBase.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListBaseData.p)) {
          return true;
        }
        paramInt1 -= 1;
        while (paramInt1 >= paramInt2)
        {
          a().a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListSceneBase.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListAdapter.a(paramInt1), this.jdField_a_of_type_Boolean);
          if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListSceneBase.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListBaseData.p))
          {
            a().a();
            this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListSceneBase.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListAdapter.notifyDataSetChanged();
            return true;
          }
          paramInt1 -= 1;
        }
      }
    }
    else
    {
      paramInt1 = this.jdField_a_of_type_Int;
      this.jdField_a_of_type_Int = Math.max(paramInt2, paramInt1);
      if (paramInt2 > paramInt1)
      {
        if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListSceneBase.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListBaseData.p)) {
          return true;
        }
        paramInt1 += 1;
        while (paramInt1 <= paramInt2)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListSceneBase.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListCustomization.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListSceneBase.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListAdapter.a(paramInt1), this.jdField_a_of_type_Boolean);
          if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListSceneBase.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListBaseData.p))
          {
            this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListSceneBase.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListCustomization.a();
            this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListSceneBase.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListAdapter.notifyDataSetChanged();
            return true;
          }
          paramInt1 += 1;
        }
      }
    }
    return false;
  }
  
  PhotoListCustomization<? extends OtherCommonData> a()
  {
    PhotoListSceneBase localPhotoListSceneBase = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListSceneBase;
    if (localPhotoListSceneBase != null) {
      return localPhotoListSceneBase.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListCustomization;
    }
    return null;
  }
  
  public void onSelectBegin(int paramInt)
  {
    if (a().a.isSingleMode) {
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onSelectBegin beginIndex:");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("QQAlbum", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListSceneBase.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListBaseData;
    boolean bool = false;
    ((PhotoListBaseData)localObject).p = false;
    this.jdField_a_of_type_Boolean = false;
    this.b = paramInt;
    this.jdField_a_of_type_Int = paramInt;
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListSceneBase.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListAdapter.a(paramInt);
    if (((LocalMediaInfo)localObject).selectStatus == 2) {
      bool = true;
    }
    this.jdField_a_of_type_Boolean = bool;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListSceneBase.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListCustomization.a((LocalMediaInfo)localObject, this.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListSceneBase.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListCustomization.a();
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListSceneBase.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListAdapter.notifyItemChanged(paramInt);
    }
  }
  
  public void onSelectChanged(int paramInt1, int paramInt2)
  {
    if (a().a.isSingleMode) {
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onSelectChanged beginIndex:");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(" selectIndex:");
      localStringBuilder.append(paramInt2);
      QLog.d("QQAlbum", 2, localStringBuilder.toString());
    }
    int m = Math.min(paramInt1, paramInt2);
    int k = Math.max(paramInt1, paramInt2);
    if (a(paramInt1, paramInt2)) {
      return;
    }
    int i = this.b;
    int j;
    for (;;)
    {
      j = k;
      if (i >= m) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListSceneBase.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListCustomization.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListSceneBase.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListAdapter.a(i), this.jdField_a_of_type_Boolean ^ true);
      i += 1;
    }
    for (;;)
    {
      j += 1;
      i = this.jdField_a_of_type_Int;
      if (j > i) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListSceneBase.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListCustomization.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListSceneBase.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListAdapter.a(j), this.jdField_a_of_type_Boolean ^ true);
    }
    if (paramInt2 < paramInt1)
    {
      this.b = paramInt2;
      if (i > paramInt1) {
        this.jdField_a_of_type_Int = paramInt1;
      }
    }
    else
    {
      this.jdField_a_of_type_Int = paramInt2;
      if (this.b < paramInt1) {
        this.b = paramInt1;
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListSceneBase.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListCustomization.a();
    this.jdField_a_of_type_AndroidOsHandler.post(new GridSelectListener.1(this));
  }
  
  public void onSelectEnd()
  {
    a().a(this.jdField_a_of_type_Boolean, this.jdField_a_of_type_Int, this.b);
    if (QLog.isColorLevel()) {
      QLog.d("QQAlbum", 2, "onSelectEnd");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.photolist.GridSelectListener
 * JD-Core Version:    0.7.0.1
 */