package com.tencent.common.galleryactivity;

import android.view.View;
import android.widget.BaseAdapter;
import com.tencent.image.URLDrawable;

public abstract class AbstractImageAdapter
  extends BaseAdapter
{
  private AbstractProgressView a;
  AbstractImageListModel h;
  
  private AbstractProgressView a(int paramInt)
  {
    AbstractImageListModel localAbstractImageListModel = this.h;
    if ((localAbstractImageListModel != null) && (paramInt == localAbstractImageListModel.b())) {
      return this.a;
    }
    return null;
  }
  
  public static void a(View paramView, URLDrawable paramURLDrawable, int paramInt)
  {
    if (paramInt != 3)
    {
      if (paramInt != 6)
      {
        if (paramInt != 8) {
          paramInt = 0;
        } else {
          paramInt = 3;
        }
      }
      else {
        paramInt = 1;
      }
    }
    else {
      paramInt = 2;
    }
    boolean bool = paramURLDrawable.isAnim() ^ true;
    paramView.setTag(2131296390, Boolean.valueOf(bool));
    if (bool) {
      paramView.setTag(2131296389, Integer.valueOf(paramInt));
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    AbstractProgressView localAbstractProgressView = a(paramInt1);
    if (localAbstractProgressView != null) {
      localAbstractProgressView.a(paramInt2);
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    AbstractProgressView localAbstractProgressView = a(paramInt);
    if (localAbstractProgressView != null) {
      localAbstractProgressView.c();
    }
  }
  
  public abstract void a(View paramView, int paramInt);
  
  public void a(AbstractImageListModel paramAbstractImageListModel)
  {
    this.h = paramAbstractImageListModel;
  }
  
  public void a(AbstractProgressView paramAbstractProgressView)
  {
    this.a = paramAbstractProgressView;
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    AbstractProgressView localAbstractProgressView = a(paramInt1);
    if ((localAbstractProgressView != null) && (localAbstractProgressView.d())) {
      localAbstractProgressView.a(paramInt2);
    }
  }
  
  public AbstractImageListModel d()
  {
    return this.h;
  }
  
  public int getCount()
  {
    AbstractImageListModel localAbstractImageListModel = this.h;
    if (localAbstractImageListModel == null) {
      return 0;
    }
    return localAbstractImageListModel.a();
  }
  
  public Object getItem(int paramInt)
  {
    AbstractImageListModel localAbstractImageListModel = this.h;
    if (localAbstractImageListModel == null) {
      return null;
    }
    return localAbstractImageListModel.c(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.common.galleryactivity.AbstractImageAdapter
 * JD-Core Version:    0.7.0.1
 */