package com.tencent.biz.qqstory.takevideo.music;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.aelight.camera.qqstory.api.GetMusicInfoCallback;
import com.tencent.aelight.camera.struct.editor.FlowMusic;
import com.tencent.qphone.base.util.QLog;

class EditVideoMusicCache$2
  implements GetMusicInfoCallback
{
  EditVideoMusicCache$2(EditVideoMusicCache paramEditVideoMusicCache) {}
  
  public void a(boolean paramBoolean, Object paramObject)
  {
    String str = EditVideoMusicCache.a(this.a).getResources().getString(2131698369);
    Object localObject = str;
    if (paramBoolean)
    {
      paramObject = (FlowMusic)paramObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onGetSingleMusicInfo flowMusic:");
        ((StringBuilder)localObject).append(paramObject.toString());
        QLog.d("MusicCache", 2, ((StringBuilder)localObject).toString());
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
        localObject = EditVideoMusicCache.a(this.a).getResources().getString(2131698370);
      }
    }
    this.a.a(7, localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.music.EditVideoMusicCache.2
 * JD-Core Version:    0.7.0.1
 */