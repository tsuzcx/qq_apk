package com.tencent.mobileqq.activity.photo.album;

import com.tencent.biz.qqstory.takevideo.slideshow.SlideShowViewController;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.PhotoSendParams;
import java.util.HashMap;

public class PhotoListData
  extends PhotoListBaseData
{
  public int a;
  public long a;
  public SlideShowViewController a;
  public SessionInfo a;
  public String a;
  public HashMap<String, PhotoSendParams> a;
  public boolean a;
  public String b;
  public HashMap<String, byte[]> b;
  public boolean b;
  public String c;
  public HashMap<LocalMediaInfo, LocalMediaInfo> c;
  public boolean c;
  public String d;
  public boolean d = true;
  public boolean e = false;
  public boolean f = false;
  public boolean g = false;
  public boolean h = false;
  public boolean i;
  public boolean j = false;
  public boolean k = false;
  
  public PhotoListData()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_Long = -1L;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = null;
    this.jdField_c_of_type_JavaUtilHashMap = new HashMap();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.PhotoListData
 * JD-Core Version:    0.7.0.1
 */