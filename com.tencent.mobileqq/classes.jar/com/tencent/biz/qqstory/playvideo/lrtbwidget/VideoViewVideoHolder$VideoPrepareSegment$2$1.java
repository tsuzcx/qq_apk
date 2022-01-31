package com.tencent.biz.qqstory.playvideo.lrtbwidget;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import java.io.File;
import mqq.os.MqqHandler;
import stl;
import suj;
import tcz;
import ubz;
import ucb;
import ved;
import vei;

public class VideoViewVideoHolder$VideoPrepareSegment$2$1
  implements Runnable
{
  public VideoViewVideoHolder$VideoPrepareSegment$2$1(ucb paramucb, String paramString1, String paramString2, File paramFile) {}
  
  public void run()
  {
    ved.b(this.jdField_a_of_type_Ucb.jdField_a_of_type_Ubz.a.jdField_a_of_type_JavaLangString, "onSuccess, [vid, url, fileCache] = ");
    stl localstl = (stl)tcz.a(28);
    String str = suj.a(new File(this.jdField_a_of_type_Ucb.jdField_a_of_type_JavaLangString));
    if (!TextUtils.isEmpty(str)) {
      suj.a(this.jdField_a_of_type_Ucb.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem, str, 0, vei.a(BaseApplicationImpl.getContext()));
    }
    localstl.b(this.jdField_a_of_type_JavaLangString, 0);
    localstl.a(this.jdField_a_of_type_JavaLangString, 0);
    ThreadManager.getUIHandler().post(new VideoViewVideoHolder.VideoPrepareSegment.2.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder.VideoPrepareSegment.2.1
 * JD-Core Version:    0.7.0.1
 */