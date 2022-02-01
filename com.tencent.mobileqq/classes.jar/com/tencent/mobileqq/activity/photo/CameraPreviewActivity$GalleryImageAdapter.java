package com.tencent.mobileqq.activity.photo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;
import java.net.MalformedURLException;
import java.util.ArrayList;

class CameraPreviewActivity$GalleryImageAdapter
  extends BaseAdapter
{
  public CameraPreviewActivity$GalleryImageAdapter(CameraPreviewActivity paramCameraPreviewActivity) {}
  
  public String a(int paramInt)
  {
    if ((CameraPreviewActivity.a(this.a) != null) && (paramInt < CameraPreviewActivity.a(this.a).size()) && (paramInt >= 0)) {
      return (String)CameraPreviewActivity.a(this.a).get(paramInt);
    }
    return null;
  }
  
  public int getCount()
  {
    if (CameraPreviewActivity.a(this.a) != null) {
      return CameraPreviewActivity.a(this.a).size();
    }
    return 0;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    CameraPreviewActivity.ImagePhotoHolder localImagePhotoHolder;
    if (paramView == null)
    {
      paramView = this.a.getLayoutInflater().inflate(2131559558, null);
      localImagePhotoHolder = new CameraPreviewActivity.ImagePhotoHolder();
      localImagePhotoHolder.a = ((URLImageView)paramView.findViewById(2131373039));
      paramView.setTag(localImagePhotoHolder);
    }
    else
    {
      localImagePhotoHolder = (CameraPreviewActivity.ImagePhotoHolder)paramView.getTag();
    }
    Object localObject = a(paramInt);
    if (localObject != null)
    {
      localObject = new File((String)localObject);
      if (((File)localObject).exists()) {
        try
        {
          localImagePhotoHolder.a.setImageDrawable(URLDrawable.getDrawable(((File)localObject).toURL(), CameraPreviewActivity.a(this.a), CameraPreviewActivity.b(this.a), CameraPreviewActivity.a(this.a), null, true));
        }
        catch (MalformedURLException localMalformedURLException)
        {
          localMalformedURLException.printStackTrace();
        }
      }
    }
    else
    {
      localMalformedURLException.a.setImageDrawable(null);
    }
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.CameraPreviewActivity.GalleryImageAdapter
 * JD-Core Version:    0.7.0.1
 */