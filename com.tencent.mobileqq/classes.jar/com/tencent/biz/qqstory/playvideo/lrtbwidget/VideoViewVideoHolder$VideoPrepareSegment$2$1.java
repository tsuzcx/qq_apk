package com.tencent.biz.qqstory.playvideo.lrtbwidget;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import java.io.File;
import mqq.os.MqqHandler;
import wan;
import wbl;
import wjs;
import xim;
import xio;
import ykq;
import ykv;

public class VideoViewVideoHolder$VideoPrepareSegment$2$1
  implements Runnable
{
  public VideoViewVideoHolder$VideoPrepareSegment$2$1(xio paramxio, String paramString1, String paramString2, File paramFile) {}
  
  public void run()
  {
    ykq.b(this.jdField_a_of_type_Xio.jdField_a_of_type_Xim.a.jdField_a_of_type_JavaLangString, "onSuccess, [vid, url, fileCache] = ");
    wan localwan = (wan)wjs.a(28);
    String str = wbl.a(new File(this.jdField_a_of_type_Xio.jdField_a_of_type_JavaLangString));
    if (!TextUtils.isEmpty(str)) {
      wbl.a(this.jdField_a_of_type_Xio.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem, str, 0, ykv.a(BaseApplicationImpl.getContext()));
    }
    localwan.b(this.jdField_a_of_type_JavaLangString, 0);
    localwan.a(this.jdField_a_of_type_JavaLangString, 0);
    ThreadManager.getUIHandler().post(new VideoViewVideoHolder.VideoPrepareSegment.2.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder.VideoPrepareSegment.2.1
 * JD-Core Version:    0.7.0.1
 */