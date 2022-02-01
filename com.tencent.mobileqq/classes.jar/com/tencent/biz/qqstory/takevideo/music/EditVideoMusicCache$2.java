package com.tencent.biz.qqstory.takevideo.music;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.mobileqq.data.FlowMusic;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.control.GetSingleFullMusicInfoTask.GetMusicInfoCallback;

class EditVideoMusicCache$2
  implements GetSingleFullMusicInfoTask.GetMusicInfoCallback
{
  EditVideoMusicCache$2(EditVideoMusicCache paramEditVideoMusicCache) {}
  
  public void a(boolean paramBoolean, Object paramObject)
  {
    String str = EditVideoMusicCache.a(this.a).getResources().getString(2131698304);
    Object localObject = str;
    if (paramBoolean)
    {
      paramObject = (FlowMusic)paramObject;
      if (QLog.isColorLevel()) {
        QLog.d("MusicCache", 2, "onGetSingleMusicInfo flowMusic:" + paramObject.toString());
      }
      if ((paramObject.playable == 1) && (!TextUtils.isEmpty(paramObject.url)))
      {
        localObject = new QQStoryMusicInfo();
        ((QQStoryMusicInfo)localObject).jdField_b_of_type_JavaLangString = paramObject.songName;
        ((QQStoryMusicInfo)localObject).d = paramObject.url;
        ((QQStoryMusicInfo)localObject).jdField_b_of_type_Int = 2;
        ((QQStoryMusicInfo)localObject).a = String.valueOf(paramObject.songId);
        this.a.a(12, localObject);
        return;
      }
      localObject = str;
      if (paramObject.playable != 1) {
        localObject = EditVideoMusicCache.a(this.a).getResources().getString(2131698305);
      }
    }
    this.a.a(7, localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.music.EditVideoMusicCache.2
 * JD-Core Version:    0.7.0.1
 */