package com.tencent.biz.pubaccount.readinjoy.video;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadinjoyAdVideoReportData;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadinjoyVideoReportData;

public class VideoFeedsPlayManager$VideoPlayParam
{
  public int a;
  public long a;
  public Bundle a;
  public View a;
  public ViewGroup a;
  public VideoInfo a;
  public ReadinjoyAdVideoReportData a;
  public ReadinjoyVideoReportData a;
  public IVideoUIDelegate a;
  public VideoPlayerWrapper a;
  public String a;
  public boolean a;
  public int b;
  public boolean b;
  public boolean c;
  
  public VideoFeedsPlayManager$VideoPlayParam()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_AndroidOsBundle = new Bundle();
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    try
    {
      this.jdField_a_of_type_AndroidOsBundle.putBoolean(paramString, paramBoolean);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public boolean a(String paramString, boolean paramBoolean)
  {
    try
    {
      paramBoolean = this.jdField_a_of_type_AndroidOsBundle.getBoolean(paramString, paramBoolean);
      return paramBoolean;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager.VideoPlayParam
 * JD-Core Version:    0.7.0.1
 */