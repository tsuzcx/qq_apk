package com.tencent.mobileqq.activity.richmedia;

import android.os.Handler;
import com.tencent.biz.qqstory.takevideo.music.QQStoryMusicInfo;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.QZLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class EditLocalVideoMusicMixRunnable
  implements Runnable
{
  private long jdField_a_of_type_Long;
  private QQStoryMusicInfo jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo;
  private EditLocalVideoMusicMixer.MusicMixCallback jdField_a_of_type_ComTencentMobileqqActivityRichmediaEditLocalVideoMusicMixer$MusicMixCallback;
  private String jdField_a_of_type_JavaLangString;
  private long b;
  private long c;
  
  public EditLocalVideoMusicMixRunnable(long paramLong1, long paramLong2, long paramLong3, String paramString, QQStoryMusicInfo paramQQStoryMusicInfo, EditLocalVideoMusicMixer.MusicMixCallback paramMusicMixCallback)
  {
    this.jdField_a_of_type_Long = paramLong1;
    this.b = paramLong2;
    this.c = paramLong3;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo = paramQQStoryMusicInfo;
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaEditLocalVideoMusicMixer$MusicMixCallback = paramMusicMixCallback;
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaEditLocalVideoMusicMixer$MusicMixCallback != null) {
      QzoneHandlerThreadFactory.getMainHandler().post(new EditLocalVideoMusicMixRunnable.3(this));
    }
  }
  
  private void a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaEditLocalVideoMusicMixer$MusicMixCallback != null) {
      QzoneHandlerThreadFactory.getMainHandler().post(new EditLocalVideoMusicMixRunnable.2(this, paramString));
    }
  }
  
  private boolean a(String paramString)
  {
    if (paramString == null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaEditLocalVideoMusicMixer$MusicMixCallback != null) {
        QzoneHandlerThreadFactory.getMainHandler().post(new EditLocalVideoMusicMixRunnable.1(this));
      }
      return true;
    }
    return false;
  }
  
  public void run()
  {
    a();
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo.b == 0)
    {
      a(EditLocalVideoMusicMixHelper.a(this.jdField_a_of_type_JavaLangString));
      return;
    }
    Object localObject3 = new ArrayList();
    Object localObject1 = EditLocalVideoMusicMixHelper.c(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo.g);
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("step 1, run() returned: ");
    ((StringBuilder)localObject2).append((String)localObject1);
    QZLog.d("EditLocalVideoMusicMixR", 2, ((StringBuilder)localObject2).toString());
    ((List)localObject3).add(localObject1);
    if (a((String)localObject1)) {
      return;
    }
    String str = EditLocalVideoMusicMixHelper.b((String)localObject1);
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("step 2, run() returned: ");
    ((StringBuilder)localObject1).append(str);
    QZLog.d("EditLocalVideoMusicMixR", 2, ((StringBuilder)localObject1).toString());
    ((List)localObject3).add(str);
    if (a(str)) {
      return;
    }
    localObject1 = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo;
    ((QQStoryMusicInfo)localObject1).d -= 1000;
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo.d > 0) {
      localObject2 = EditLocalVideoMusicMixHelper.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo.d, this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo.e - this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo.d, str);
    } else {
      localObject2 = str;
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("step 3, run() returned: ");
    ((StringBuilder)localObject1).append((String)localObject2);
    QZLog.d("EditLocalVideoMusicMixR", 2, ((StringBuilder)localObject1).toString());
    ((List)localObject3).add(localObject2);
    if (a((String)localObject2)) {
      return;
    }
    localObject1 = localObject2;
    if (this.b - this.jdField_a_of_type_Long > this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo.f) {
      localObject1 = EditLocalVideoMusicMixHelper.a((String)localObject2, (int)((this.b - this.jdField_a_of_type_Long) / this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo.f + 1L));
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("step 4, run() returned: ");
    ((StringBuilder)localObject2).append((String)localObject1);
    QZLog.d("EditLocalVideoMusicMixR", 2, ((StringBuilder)localObject2).toString());
    ((List)localObject3).add(localObject1);
    if (a((String)localObject1)) {
      return;
    }
    long l = this.jdField_a_of_type_Long;
    localObject2 = localObject1;
    if (l > 0L)
    {
      str = EditLocalVideoMusicMixHelper.a(l, str, this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo.f);
      localObject2 = EditLocalVideoMusicMixHelper.a(Arrays.asList(new String[] { str, localObject1 }));
      ((List)localObject3).add(str);
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("step 5, run() returned: ");
    ((StringBuilder)localObject1).append((String)localObject2);
    QZLog.d("EditLocalVideoMusicMixR", 2, ((StringBuilder)localObject1).toString());
    ((List)localObject3).add(localObject2);
    if (a((String)localObject2)) {
      return;
    }
    localObject1 = EditLocalVideoMusicMixHelper.a(this.jdField_a_of_type_JavaLangString, (String)localObject2, this.c);
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("step 6, run() returned: ");
    ((StringBuilder)localObject2).append((String)localObject1);
    QZLog.d("EditLocalVideoMusicMixR", 2, ((StringBuilder)localObject2).toString());
    if (a((String)localObject1)) {
      return;
    }
    localObject2 = ((List)localObject3).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      str = (String)((Iterator)localObject2).next();
      if ((str != null) && (new File(str).delete()))
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("step 7, run() clear: ");
        ((StringBuilder)localObject3).append(str);
        QZLog.d("EditLocalVideoMusicMixR", 2, ((StringBuilder)localObject3).toString());
      }
    }
    a((String)localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.EditLocalVideoMusicMixRunnable
 * JD-Core Version:    0.7.0.1
 */