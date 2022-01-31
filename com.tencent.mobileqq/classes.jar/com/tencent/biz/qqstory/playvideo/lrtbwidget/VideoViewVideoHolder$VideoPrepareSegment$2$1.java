package com.tencent.biz.qqstory.playvideo.lrtbwidget;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import java.io.File;
import mqq.os.MqqHandler;
import sto;
import sum;
import tdc;
import ucc;
import uce;
import veg;
import vel;

public class VideoViewVideoHolder$VideoPrepareSegment$2$1
  implements Runnable
{
  public VideoViewVideoHolder$VideoPrepareSegment$2$1(uce paramuce, String paramString1, String paramString2, File paramFile) {}
  
  public void run()
  {
    veg.b(this.jdField_a_of_type_Uce.jdField_a_of_type_Ucc.a.jdField_a_of_type_JavaLangString, "onSuccess, [vid, url, fileCache] = ");
    sto localsto = (sto)tdc.a(28);
    String str = sum.a(new File(this.jdField_a_of_type_Uce.jdField_a_of_type_JavaLangString));
    if (!TextUtils.isEmpty(str)) {
      sum.a(this.jdField_a_of_type_Uce.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem, str, 0, vel.a(BaseApplicationImpl.getContext()));
    }
    localsto.b(this.jdField_a_of_type_JavaLangString, 0);
    localsto.a(this.jdField_a_of_type_JavaLangString, 0);
    ThreadManager.getUIHandler().post(new VideoViewVideoHolder.VideoPrepareSegment.2.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder.VideoPrepareSegment.2.1
 * JD-Core Version:    0.7.0.1
 */