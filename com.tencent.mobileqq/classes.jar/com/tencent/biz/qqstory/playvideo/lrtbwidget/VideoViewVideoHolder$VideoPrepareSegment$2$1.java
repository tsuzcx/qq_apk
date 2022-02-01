package com.tencent.biz.qqstory.playvideo.lrtbwidget;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import java.io.File;
import mqq.os.MqqHandler;
import wfy;
import wgw;
import wpm;
import xol;
import xon;
import yqp;
import yqu;

public class VideoViewVideoHolder$VideoPrepareSegment$2$1
  implements Runnable
{
  public VideoViewVideoHolder$VideoPrepareSegment$2$1(xon paramxon, String paramString1, String paramString2, File paramFile) {}
  
  public void run()
  {
    yqp.b(this.jdField_a_of_type_Xon.jdField_a_of_type_Xol.a.jdField_a_of_type_JavaLangString, "onSuccess, [vid, url, fileCache] = ");
    wfy localwfy = (wfy)wpm.a(28);
    String str = wgw.a(new File(this.jdField_a_of_type_Xon.jdField_a_of_type_JavaLangString));
    if (!TextUtils.isEmpty(str)) {
      wgw.a(this.jdField_a_of_type_Xon.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem, str, 0, yqu.a(BaseApplicationImpl.getContext()));
    }
    localwfy.b(this.jdField_a_of_type_JavaLangString, 0);
    localwfy.a(this.jdField_a_of_type_JavaLangString, 0);
    ThreadManager.getUIHandler().post(new VideoViewVideoHolder.VideoPrepareSegment.2.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder.VideoPrepareSegment.2.1
 * JD-Core Version:    0.7.0.1
 */