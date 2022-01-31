package com.tencent.biz.qqstory.playvideo.lrtbwidget;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import java.io.File;
import mqq.os.MqqHandler;
import uid;
import ujb;
import urr;
import vqr;
import vqt;
import wsv;
import wta;

public class VideoViewVideoHolder$VideoPrepareSegment$2$1
  implements Runnable
{
  public VideoViewVideoHolder$VideoPrepareSegment$2$1(vqt paramvqt, String paramString1, String paramString2, File paramFile) {}
  
  public void run()
  {
    wsv.b(this.jdField_a_of_type_Vqt.jdField_a_of_type_Vqr.a.jdField_a_of_type_JavaLangString, "onSuccess, [vid, url, fileCache] = ");
    uid localuid = (uid)urr.a(28);
    String str = ujb.a(new File(this.jdField_a_of_type_Vqt.jdField_a_of_type_JavaLangString));
    if (!TextUtils.isEmpty(str)) {
      ujb.a(this.jdField_a_of_type_Vqt.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem, str, 0, wta.a(BaseApplicationImpl.getContext()));
    }
    localuid.b(this.jdField_a_of_type_JavaLangString, 0);
    localuid.a(this.jdField_a_of_type_JavaLangString, 0);
    ThreadManager.getUIHandler().post(new VideoViewVideoHolder.VideoPrepareSegment.2.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder.VideoPrepareSegment.2.1
 * JD-Core Version:    0.7.0.1
 */