package com.tencent.common.galleryactivity;

import android.content.Context;
import android.graphics.drawable.Drawable.ConstantState;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;
import java.net.URL;

@Deprecated
public class UrlGalleryAdapter
  extends AbstractImageAdapter
{
  public URLDrawable a(URL paramURL, ViewGroup paramViewGroup)
  {
    if (paramURL == null) {
      return null;
    }
    paramURL = paramURL.toString();
    int i = 0;
    while (i < paramViewGroup.getChildCount())
    {
      Object localObject = ((URLImageView)paramViewGroup.getChildAt(i)).getDrawable();
      if ((localObject != null) && ((localObject instanceof URLDrawable)))
      {
        localObject = (URLDrawable)localObject;
        if ((((URLDrawable)localObject).getURL() != null) && (((URLDrawable)localObject).getURL().toString().equals(paramURL)))
        {
          localObject = ((URLDrawable)localObject).getConstantState();
          if (localObject != null) {
            return (URLDrawable)((Drawable.ConstantState)localObject).newDrawable(paramViewGroup.getContext().getResources());
          }
        }
      }
      i += 1;
    }
    return null;
  }
  
  public void a(View paramView, int paramInt)
  {
    paramView = (URLImageView)paramView;
    URLDrawable localURLDrawable = (URLDrawable)paramView.getDrawable();
    int i = localURLDrawable.getStatus();
    boolean bool = true;
    if ((i != 1) && (localURLDrawable.getStatus() != 2))
    {
      i = localURLDrawable.getProgress();
      if (i == 0) {
        return;
      }
      a(paramInt, i / 100);
    }
    else
    {
      if (localURLDrawable.getStatus() != 1) {
        bool = false;
      }
      a(paramInt, bool);
    }
    paramView.setMinimumHeight(10);
    paramView.setMinimumWidth(10);
  }
  
  protected void a(View paramView, URLDrawable paramURLDrawable)
  {
    paramView.setTag(2131296390, Boolean.valueOf(paramURLDrawable.isAnim() ^ true));
    String str = paramURLDrawable.getURL().toString();
    if ((paramURLDrawable.getStatus() == 1) && (AbsDownloader.hasFile(str)))
    {
      paramURLDrawable = AbsDownloader.getFile(str);
      if ((paramURLDrawable != null) && (paramURLDrawable.exists())) {
        paramView.setTag(2131296389, Integer.valueOf(ImageUtil.j(paramURLDrawable.getAbsolutePath())));
      }
    }
  }
  
  public View b(URL paramURL, ViewGroup paramViewGroup)
  {
    int i = 0;
    while (i < paramViewGroup.getChildCount())
    {
      URLImageView localURLImageView = (URLImageView)paramViewGroup.getChildAt(i);
      Object localObject = localURLImageView.getDrawable();
      if ((localObject != null) && ((localObject instanceof URLDrawable)))
      {
        localObject = (URLDrawable)localObject;
        if ((((URLDrawable)localObject).getURL() != null) && (((URLDrawable)localObject).getURL().equals(paramURL))) {
          return localURLImageView;
        }
      }
      i += 1;
    }
    return null;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
    }
    else
    {
      URLImageView localURLImageView = new URLImageView(paramViewGroup.getContext());
      boolean bool = true;
      localURLImageView.setAdjustViewBounds(true);
      URLGalleryImage localURLGalleryImage = (URLGalleryImage)getItem(paramInt);
      localObject = localURLImageView;
      if (localURLGalleryImage != null)
      {
        localObject = a(localURLGalleryImage.b(), paramViewGroup);
        paramView = (View)localObject;
        if (localObject == null) {
          paramView = (URLDrawable)localURLGalleryImage.e();
        }
        localURLImageView.setImageDrawable(paramView);
        if ((paramView != null) && (paramView.getStatus() != 1) && (paramView.getStatus() != 4) && (paramView.getStatus() != 2))
        {
          int i = paramView.getProgress();
          localURLImageView.setURLDrawableDownListener(new UrlGalleryAdapter.1(this, paramInt, paramViewGroup));
          a(paramInt, i / 100);
          localObject = localURLImageView;
        }
        else
        {
          localObject = localURLImageView;
          if (paramView != null)
          {
            if (paramView.getStatus() != 1) {
              bool = false;
            }
            a(paramInt, bool);
            a(localURLImageView, paramView);
            localObject = localURLImageView;
          }
        }
      }
    }
    EventCollector.getInstance().onListGetView(paramInt, (View)localObject, paramViewGroup, getItemId(paramInt));
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.common.galleryactivity.UrlGalleryAdapter
 * JD-Core Version:    0.7.0.1
 */