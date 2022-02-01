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
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaEditLocalVideoMusicMixer;
    EditLocalVideoMusicMixer.a((EditLocalVideoMusicMixer)localObject, new QQProgressDialog(EditLocalVideoMusicMixer.a((EditLocalVideoMusicMixer)localObject), EditLocalVideoMusicMixer.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaEditLocalVideoMusicMixer).getResources().getDimensionPixelSize(2131299168)));
    EditLocalVideoMusicMixer.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaEditLocalVideoMusicMixer).c(2131717407);
    EditLocalVideoMusicMixer.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaEditLocalVideoMusicMixer).setCancelable(false);
    EditLocalVideoMusicMixer.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaEditLocalVideoMusicMixer).show();
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaEditLocalVideoMusicMixer$MusicMixCallback;
    if (localObject != null) {
      ((EditLocalVideoMusicMixer.MusicMixCallback)localObject).a();
    }
  }
  
  public void a(String paramString)
  {
    if (EditLocalVideoMusicMixer.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaEditLocalVideoMusicMixer) != null) {
      EditLocalVideoMusicMixer.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaEditLocalVideoMusicMixer).dismiss();
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaEditLocalVideoMusicMixer.a(true);
    EditLocalVideoMusicMixer.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaEditLocalVideoMusicMixer, false);
    EditLocalVideoMusicMixer.MusicMixCallback localMusicMixCallback = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaEditLocalVideoMusicMixer$MusicMixCallback;
    if (localMusicMixCallback != null) {
      localMusicMixCallback.a(paramString);
    }
  }
  
  public void b()
  {
    if (EditLocalVideoMusicMixer.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaEditLocalVideoMusicMixer) != null) {
      EditLocalVideoMusicMixer.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaEditLocalVideoMusicMixer).dismiss();
    }
    EditLocalVideoMusicMixer.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaEditLocalVideoMusicMixer, false);
    EditLocalVideoMusicMixer.MusicMixCallback localMusicMixCallback = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaEditLocalVideoMusicMixer$MusicMixCallback;
    if (localMusicMixCallback != null) {
      localMusicMixCallback.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.EditLocalVideoMusicMixer.3
 * JD-Core Version:    0.7.0.1
 */