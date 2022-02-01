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
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo.b == 0) {
      a(EditLocalVideoMusicMixHelper.a(this.jdField_a_of_type_JavaLangString));
    }
    ArrayList localArrayList;
    String str;
    do
    {
      do
      {
        return;
        localArrayList = new ArrayList();
        localObject1 = EditLocalVideoMusicMixHelper.c(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo.g);
        QZLog.d("EditLocalVideoMusicMixR", 2, "step 1, run() returned: " + (String)localObject1);
        localArrayList.add(localObject1);
      } while (a((String)localObject1));
      str = EditLocalVideoMusicMixHelper.b((String)localObject1);
      QZLog.d("EditLocalVideoMusicMixR", 2, "step 2, run() returned: " + str);
      localArrayList.add(str);
    } while (a(str));
    Object localObject1 = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo;
    ((QQStoryMusicInfo)localObject1).d -= 1000;
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo.d > 0) {}
    for (Object localObject2 = EditLocalVideoMusicMixHelper.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo.d, this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo.e - this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo.d, str);; localObject2 = str)
    {
      QZLog.d("EditLocalVideoMusicMixR", 2, "step 3, run() returned: " + (String)localObject2);
      localArrayList.add(localObject2);
      if (a((String)localObject2)) {
        break;
      }
      localObject1 = localObject2;
      if (this.b - this.jdField_a_of_type_Long > this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo.f) {
        localObject1 = EditLocalVideoMusicMixHelper.a((String)localObject2, (int)((this.b - this.jdField_a_of_type_Long) / this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo.f + 1L));
      }
      QZLog.d("EditLocalVideoMusicMixR", 2, "step 4, run() returned: " + (String)localObject1);
      localArrayList.add(localObject1);
      if (a((String)localObject1)) {
        break;
      }
      localObject2 = localObject1;
      if (this.jdField_a_of_type_Long > 0L)
      {
        str = EditLocalVideoMusicMixHelper.a(this.jdField_a_of_type_Long, str, this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo.f);
        localObject2 = EditLocalVideoMusicMixHelper.a(Arrays.asList(new String[] { str, localObject1 }));
        localArrayList.add(str);
      }
      QZLog.d("EditLocalVideoMusicMixR", 2, "step 5, run() returned: " + (String)localObject2);
      localArrayList.add(localObject2);
      if (a((String)localObject2)) {
        break;
      }
      localObject1 = EditLocalVideoMusicMixHelper.a(this.jdField_a_of_type_JavaLangString, (String)localObject2, this.c);
      QZLog.d("EditLocalVideoMusicMixR", 2, "step 6, run() returned: " + (String)localObject1);
      if (a((String)localObject1)) {
        break;
      }
      localObject2 = localArrayList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        str = (String)((Iterator)localObject2).next();
        if ((str != null) && (new File(str).delete())) {
          QZLog.d("EditLocalVideoMusicMixR", 2, "step 7, run() clear: " + str);
        }
      }
      a((String)localObject1);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.EditLocalVideoMusicMixRunnable
 * JD-Core Version:    0.7.0.1
 */