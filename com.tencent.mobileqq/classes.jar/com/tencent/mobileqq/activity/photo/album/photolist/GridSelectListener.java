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
  PhotoListSceneBase a;
  boolean b;
  int c;
  int d;
  Handler e = new Handler();
  
  public GridSelectListener(PhotoListSceneBase paramPhotoListSceneBase)
  {
    this.a = paramPhotoListSceneBase;
  }
  
  private boolean a(int paramInt1, int paramInt2)
  {
    if (paramInt2 < paramInt1)
    {
      paramInt1 = this.d;
      this.d = Math.min(paramInt2, paramInt1);
      if (paramInt2 < paramInt1)
      {
        if ((this.b) && (this.a.e.I)) {
          return true;
        }
        paramInt1 -= 1;
        while (paramInt1 >= paramInt2)
        {
          a().a(this.a.t.a(paramInt1), this.b);
          if ((this.b) && (this.a.e.I))
          {
            a().a();
            this.a.t.notifyDataSetChanged();
            return true;
          }
          paramInt1 -= 1;
        }
      }
    }
    else
    {
      paramInt1 = this.c;
      this.c = Math.max(paramInt2, paramInt1);
      if (paramInt2 > paramInt1)
      {
        if ((this.b) && (this.a.e.I)) {
          return true;
        }
        paramInt1 += 1;
        while (paramInt1 <= paramInt2)
        {
          this.a.d.a(this.a.t.a(paramInt1), this.b);
          if ((this.b) && (this.a.e.I))
          {
            this.a.d.a();
            this.a.t.notifyDataSetChanged();
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
    PhotoListSceneBase localPhotoListSceneBase = this.a;
    if (localPhotoListSceneBase != null) {
      return localPhotoListSceneBase.d;
    }
    return null;
  }
  
  public void onSelectBegin(int paramInt)
  {
    if (a().e.isSingleMode) {
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onSelectBegin beginIndex:");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("QQAlbum", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.a.e;
    boolean bool = false;
    ((PhotoListBaseData)localObject).I = false;
    this.b = false;
    this.d = paramInt;
    this.c = paramInt;
    localObject = this.a.t.a(paramInt);
    if (((LocalMediaInfo)localObject).selectStatus == 2) {
      bool = true;
    }
    this.b = bool;
    if (this.a.d.a((LocalMediaInfo)localObject, this.b))
    {
      this.a.d.a();
      this.a.t.notifyItemChanged(paramInt);
    }
  }
  
  public void onSelectChanged(int paramInt1, int paramInt2)
  {
    if (a().e.isSingleMode) {
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
    int i = this.d;
    int j;
    for (;;)
    {
      j = k;
      if (i >= m) {
        break;
      }
      this.a.d.a(this.a.t.a(i), this.b ^ true);
      i += 1;
    }
    for (;;)
    {
      j += 1;
      i = this.c;
      if (j > i) {
        break;
      }
      this.a.d.a(this.a.t.a(j), this.b ^ true);
    }
    if (paramInt2 < paramInt1)
    {
      this.d = paramInt2;
      if (i > paramInt1) {
        this.c = paramInt1;
      }
    }
    else
    {
      this.c = paramInt2;
      if (this.d < paramInt1) {
        this.d = paramInt1;
      }
    }
    this.a.d.a();
    this.e.post(new GridSelectListener.1(this));
  }
  
  public void onSelectEnd()
  {
    a().a(this.b, this.c, this.d);
    if (QLog.isColorLevel()) {
      QLog.d("QQAlbum", 2, "onSelectEnd");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.photolist.GridSelectListener
 * JD-Core Version:    0.7.0.1
 */