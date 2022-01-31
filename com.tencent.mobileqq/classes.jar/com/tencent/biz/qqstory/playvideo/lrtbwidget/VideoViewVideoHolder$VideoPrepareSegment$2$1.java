package com.tencent.biz.qqstory.playvideo.lrtbwidget;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import java.io.File;
import mqq.os.MqqHandler;
import sgs;
import shq;
import sqg;
import tpg;
import tpi;
import urk;
import urp;

public class VideoViewVideoHolder$VideoPrepareSegment$2$1
  implements Runnable
{
  public VideoViewVideoHolder$VideoPrepareSegment$2$1(tpi paramtpi, String paramString1, String paramString2, File paramFile) {}
  
  public void run()
  {
    urk.b(this.jdField_a_of_type_Tpi.jdField_a_of_type_Tpg.a.jdField_a_of_type_JavaLangString, "onSuccess, [vid, url, fileCache] = ");
    sgs localsgs = (sgs)sqg.a(28);
    String str = shq.a(new File(this.jdField_a_of_type_Tpi.jdField_a_of_type_JavaLangString));
    if (!TextUtils.isEmpty(str)) {
      shq.a(this.jdField_a_of_type_Tpi.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem, str, 0, urp.a(BaseApplicationImpl.getContext()));
    }
    localsgs.b(this.jdField_a_of_type_JavaLangString, 0);
    localsgs.a(this.jdField_a_of_type_JavaLangString, 0);
    ThreadManager.getUIHandler().post(new VideoViewVideoHolder.VideoPrepareSegment.2.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder.VideoPrepareSegment.2.1
 * JD-Core Version:    0.7.0.1
 */