package com.tencent.mobileqq.activity.photo.album.preview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.AdapterView;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

public class BasePreviewPresent
{
  PreviewBean mBean;
  
  public BasePreviewPresent(PreviewBean paramPreviewBean)
  {
    this.mBean = paramPreviewBean;
  }
  
  Context getContext()
  {
    return BaseApplication.getContext();
  }
  
  protected URL getFileUrl(File paramFile)
  {
    if (paramFile == null) {
      return null;
    }
    try
    {
      paramFile = paramFile.toURI().toURL();
      return paramFile;
    }
    catch (MalformedURLException paramFile)
    {
      paramFile.printStackTrace();
    }
    return null;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramViewGroup != null) {
      return new ImageView(paramViewGroup.getContext());
    }
    return new ImageView(getContext());
  }
  
  public View onCreateView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    return null;
  }
  
  public void onDestroy() {}
  
  public void onDestroyView() {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {}
  
  public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {}
  
  public void onPause() {}
  
  public void onResume() {}
  
  public void onViewDetached() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.preview.BasePreviewPresent
 * JD-Core Version:    0.7.0.1
 */