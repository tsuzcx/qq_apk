package com.tencent.mobileqq.activity.photo.album.preview;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import beyq;
import com.tencent.common.galleryactivity.AbstractImageAdapter.URLImageView2;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class PicPreviewPresent
  extends BasePreviewPresent
{
  public static final String TAG = "PicPreviewPresent";
  private static Map<String, URLDrawable> activeDrawable = new HashMap();
  
  public PicPreviewPresent(PreviewBean paramPreviewBean)
  {
    super(paramPreviewBean);
  }
  
  private String listActiviteDrawables()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("(preview) Actives: ");
    Iterator localIterator = activeDrawable.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localStringBuilder.append(str + " ");
    }
    return localStringBuilder.toString();
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    String str = this.mBean.getPath();
    paramView = new File(str);
    Object localObject = (URLDrawable)activeDrawable.get(str);
    AbstractImageAdapter.URLImageView2 localURLImageView2 = new AbstractImageAdapter.URLImageView2(paramViewGroup.getContext());
    URL localURL = getFileUrl(new File(str));
    if ((localObject != null) && (((URLDrawable)localObject).getStatus() == 1) && (((URLDrawable)localObject).getURL().equals(localURL))) {
      localURLImageView2.setImageDrawable((Drawable)localObject);
    }
    for (;;)
    {
      return localURLImageView2;
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = paramViewGroup.getWidth();
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = paramViewGroup.getHeight();
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = beyq.a;
      ((URLDrawable.URLDrawableOptions)localObject).mPlayGifImage = true;
      paramView = getFileUrl(paramView);
      if (paramView != null)
      {
        paramViewGroup = URLDrawable.getDrawable(paramView, (URLDrawable.URLDrawableOptions)localObject);
        paramView = paramViewGroup;
        if (paramViewGroup != null)
        {
          paramView = paramViewGroup;
          switch (paramViewGroup.getStatus())
          {
          default: 
            paramViewGroup.setTag(Integer.valueOf(1));
            paramViewGroup.startDownload();
          }
        }
      }
      for (paramView = paramViewGroup; paramView != null; paramView = null)
      {
        localURLImageView2.setImageDrawable(paramView);
        activeDrawable.put(str, paramView);
        return localURLImageView2;
      }
    }
  }
  
  public View onCreateView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramView = this.mBean.getPath();
    Object localObject = (URLDrawable)activeDrawable.get(paramView);
    if (localObject != null) {
      if (((URLDrawable)localObject).getStatus() == 3) {
        ((URLDrawable)localObject).restartDownload();
      }
    }
    do
    {
      return null;
      File localFile = new File(paramView);
      if (localFile.exists())
      {
        localObject = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = paramViewGroup.getWidth();
        ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = paramViewGroup.getHeight();
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = beyq.a;
        ((URLDrawable.URLDrawableOptions)localObject).mPlayGifImage = true;
        paramViewGroup = getFileUrl(localFile);
        if (paramViewGroup != null)
        {
          paramViewGroup = URLDrawable.getDrawable(paramViewGroup, (URLDrawable.URLDrawableOptions)localObject);
          paramViewGroup.setTag(Integer.valueOf(1));
          paramViewGroup.startDownload();
          activeDrawable.put(paramView, paramViewGroup);
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("PicPreviewPresent", 2, "onCreateView:" + listActiviteDrawables());
    return null;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    activeDrawable.clear();
  }
  
  public void onDestroyView()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PicPreviewPresent", 2, "onDestroyView:" + listActiviteDrawables());
    }
    String str = this.mBean.getPath();
    URLDrawable localURLDrawable = (URLDrawable)activeDrawable.get(str);
    if (localURLDrawable != null)
    {
      if (localURLDrawable.getStatus() == 0) {
        localURLDrawable.cancelDownload(true);
      }
      activeDrawable.remove(str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.preview.PicPreviewPresent
 * JD-Core Version:    0.7.0.1
 */