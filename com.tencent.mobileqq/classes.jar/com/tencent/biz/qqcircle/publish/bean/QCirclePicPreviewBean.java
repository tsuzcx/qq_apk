package com.tencent.biz.qqcircle.publish.bean;

import com.tencent.mobileqq.activity.photo.LocalMediaInfo;

public class QCirclePicPreviewBean
{
  private String a;
  private LocalMediaInfo b;
  
  public QCirclePicPreviewBean(String paramString, LocalMediaInfo paramLocalMediaInfo)
  {
    this.a = paramString;
    this.b = paramLocalMediaInfo;
  }
  
  public String a()
  {
    return this.a;
  }
  
  public LocalMediaInfo b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.bean.QCirclePicPreviewBean
 * JD-Core Version:    0.7.0.1
 */