package com.tencent.biz.qqstory.playvideo.lrtbwidget;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import java.io.File;
import mqq.os.MqqHandler;
import wjt;
import wkr;
import wth;
import xsg;
import xsi;
import yuk;
import yup;

public class VideoViewVideoHolder$VideoPrepareSegment$2$1
  implements Runnable
{
  public VideoViewVideoHolder$VideoPrepareSegment$2$1(xsi paramxsi, String paramString1, String paramString2, File paramFile) {}
  
  public void run()
  {
    yuk.b(this.jdField_a_of_type_Xsi.jdField_a_of_type_Xsg.a.jdField_a_of_type_JavaLangString, "onSuccess, [vid, url, fileCache] = ");
    wjt localwjt = (wjt)wth.a(28);
    String str = wkr.a(new File(this.jdField_a_of_type_Xsi.jdField_a_of_type_JavaLangString));
    if (!TextUtils.isEmpty(str)) {
      wkr.a(this.jdField_a_of_type_Xsi.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem, str, 0, yup.a(BaseApplicationImpl.getContext()));
    }
    localwjt.b(this.jdField_a_of_type_JavaLangString, 0);
    localwjt.a(this.jdField_a_of_type_JavaLangString, 0);
    ThreadManager.getUIHandler().post(new VideoViewVideoHolder.VideoPrepareSegment.2.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder.VideoPrepareSegment.2.1
 * JD-Core Version:    0.7.0.1
 */