package com.tencent.mobileqq.activity.richmedia;

import android.app.Activity;
import android.content.res.Resources;
import com.tencent.mobileqq.widget.QQProgressDialog;

class EditLocalVideoMusicMixer$3
  implements EditLocalVideoMusicMixer.MusicMixCallback
{
  EditLocalVideoMusicMixer$3(EditLocalVideoMusicMixer paramEditLocalVideoMusicMixer, EditLocalVideoMusicMixer.MusicMixCallback paramMusicMixCallback) {}
  
  public void a()
  {
    Object localObject = this.b;
    EditLocalVideoMusicMixer.a((EditLocalVideoMusicMixer)localObject, new QQProgressDialog(EditLocalVideoMusicMixer.g((EditLocalVideoMusicMixer)localObject), EditLocalVideoMusicMixer.g(this.b).getResources().getDimensionPixelSize(2131299920)));
    EditLocalVideoMusicMixer.h(this.b).c(2131914880);
    EditLocalVideoMusicMixer.h(this.b).setCancelable(false);
    EditLocalVideoMusicMixer.h(this.b).show();
    localObject = this.a;
    if (localObject != null) {
      ((EditLocalVideoMusicMixer.MusicMixCallback)localObject).a();
    }
  }
  
  public void a(String paramString)
  {
    if (EditLocalVideoMusicMixer.h(this.b) != null) {
      EditLocalVideoMusicMixer.h(this.b).dismiss();
    }
    this.b.a(true);
    EditLocalVideoMusicMixer.a(this.b, false);
    EditLocalVideoMusicMixer.MusicMixCallback localMusicMixCallback = this.a;
    if (localMusicMixCallback != null) {
      localMusicMixCallback.a(paramString);
    }
  }
  
  public void b()
  {
    if (EditLocalVideoMusicMixer.h(this.b) != null) {
      EditLocalVideoMusicMixer.h(this.b).dismiss();
    }
    EditLocalVideoMusicMixer.a(this.b, false);
    EditLocalVideoMusicMixer.MusicMixCallback localMusicMixCallback = this.a;
    if (localMusicMixCallback != null) {
      localMusicMixCallback.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.EditLocalVideoMusicMixer.3
 * JD-Core Version:    0.7.0.1
 */