package com.tencent.biz.qqstory.playvideo.lrtbwidget;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import java.io.File;
import mqq.os.MqqHandler;
import vls;
import vmq;
import vux;
import wtr;
import wtt;
import xvv;
import xwa;

public class VideoViewVideoHolder$VideoPrepareSegment$2$1
  implements Runnable
{
  public VideoViewVideoHolder$VideoPrepareSegment$2$1(wtt paramwtt, String paramString1, String paramString2, File paramFile) {}
  
  public void run()
  {
    xvv.b(this.jdField_a_of_type_Wtt.jdField_a_of_type_Wtr.a.jdField_a_of_type_JavaLangString, "onSuccess, [vid, url, fileCache] = ");
    vls localvls = (vls)vux.a(28);
    String str = vmq.a(new File(this.jdField_a_of_type_Wtt.jdField_a_of_type_JavaLangString));
    if (!TextUtils.isEmpty(str)) {
      vmq.a(this.jdField_a_of_type_Wtt.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem, str, 0, xwa.a(BaseApplicationImpl.getContext()));
    }
    localvls.b(this.jdField_a_of_type_JavaLangString, 0);
    localvls.a(this.jdField_a_of_type_JavaLangString, 0);
    ThreadManager.getUIHandler().post(new VideoViewVideoHolder.VideoPrepareSegment.2.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder.VideoPrepareSegment.2.1
 * JD-Core Version:    0.7.0.1
 */