package com.tencent.biz.qqcircle.report;

import java.io.Serializable;

public class QCircleTaskReportInfo
  implements Serializable
{
  public long author_uin;
  public String city_name;
  public String country_name;
  public String feed_tag;
  public String feedid;
  public int height;
  public int is_video;
  public String lloc;
  public int orig_height;
  public long orig_photocubage;
  public int orig_width;
  public long photocubage;
  public String picture_format;
  public String place;
  public String place_name;
  public String prov_name;
  public String shoot_model;
  public String shoot_place;
  public String shoot_product;
  public String shooting_time;
  public int total_upload_num;
  public String txtinfo;
  public String up_place;
  public int up_source;
  public int up_type;
  public String vid;
  public int width;
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("QCircleTaskReportInfo{\n");
    localStringBuffer.append("up_source=").append(this.up_source).append('\n');
    localStringBuffer.append(", up_type=").append(this.up_type).append('\n');
    localStringBuffer.append(", is_video=").append(this.is_video).append('\n');
    localStringBuffer.append(", txtinfo='").append(this.txtinfo).append('\'').append('\n');
    localStringBuffer.append(", lloc='").append(this.lloc).append('\'').append('\n');
    localStringBuffer.append(", vid='").append(this.vid).append('\'').append('\n');
    localStringBuffer.append(", photocubage=").append(this.photocubage).append('\n');
    localStringBuffer.append(", feedid='").append(this.feedid).append('\'').append('\n');
    localStringBuffer.append(", total_upload_num=").append(this.total_upload_num).append('\n');
    localStringBuffer.append(", shooting_time='").append(this.shooting_time).append('\'').append('\n');
    localStringBuffer.append(", orig_photocubage=").append(this.orig_photocubage).append('\n');
    localStringBuffer.append(", place='").append(this.place).append('\'').append('\n');
    localStringBuffer.append(", up_place='").append(this.up_place).append('\'').append('\n');
    localStringBuffer.append(", shoot_product='").append(this.shoot_product).append('\'').append('\n');
    localStringBuffer.append(", shoot_model='").append(this.shoot_model).append('\'').append('\n');
    localStringBuffer.append(", width=").append(this.width).append('\n');
    localStringBuffer.append(", height=").append(this.height).append('\n');
    localStringBuffer.append(", orig_width=").append(this.orig_width).append('\n');
    localStringBuffer.append(", orig_height=").append(this.orig_height).append('\n');
    localStringBuffer.append(", picture_format='").append(this.picture_format).append('\'').append('\n');
    localStringBuffer.append(", country_name='").append(this.country_name).append('\'').append('\n');
    localStringBuffer.append(", prov_name='").append(this.prov_name).append('\'').append('\n');
    localStringBuffer.append(", city_name='").append(this.city_name).append('\'').append('\n');
    localStringBuffer.append(", place_name='").append(this.place_name).append('\'').append('\n');
    localStringBuffer.append(", feed_tag='").append(this.feed_tag).append('\'').append('\n');
    localStringBuffer.append(", author_uin=").append(this.author_uin).append('\n');
    localStringBuffer.append(", shoot_place=").append(this.shoot_place).append('\n');
    localStringBuffer.append('}');
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.report.QCircleTaskReportInfo
 * JD-Core Version:    0.7.0.1
 */