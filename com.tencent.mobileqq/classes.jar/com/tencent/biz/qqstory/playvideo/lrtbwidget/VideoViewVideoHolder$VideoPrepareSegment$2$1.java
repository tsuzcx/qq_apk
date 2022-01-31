package com.tencent.biz.qqstory.playvideo.lrtbwidget;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import java.io.File;
import mqq.os.MqqHandler;
import umm;
import unk;
import uwa;
import vva;
import vvc;
import wxe;
import wxj;

public class VideoViewVideoHolder$VideoPrepareSegment$2$1
  implements Runnable
{
  public VideoViewVideoHolder$VideoPrepareSegment$2$1(vvc paramvvc, String paramString1, String paramString2, File paramFile) {}
  
  public void run()
  {
    wxe.b(this.jdField_a_of_type_Vvc.jdField_a_of_type_Vva.a.jdField_a_of_type_JavaLangString, "onSuccess, [vid, url, fileCache] = ");
    umm localumm = (umm)uwa.a(28);
    String str = unk.a(new File(this.jdField_a_of_type_Vvc.jdField_a_of_type_JavaLangString));
    if (!TextUtils.isEmpty(str)) {
      unk.a(this.jdField_a_of_type_Vvc.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem, str, 0, wxj.a(BaseApplicationImpl.getContext()));
    }
    localumm.b(this.jdField_a_of_type_JavaLangString, 0);
    localumm.a(this.jdField_a_of_type_JavaLangString, 0);
    ThreadManager.getUIHandler().post(new VideoViewVideoHolder.VideoPrepareSegment.2.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder.VideoPrepareSegment.2.1
 * JD-Core Version:    0.7.0.1
 */