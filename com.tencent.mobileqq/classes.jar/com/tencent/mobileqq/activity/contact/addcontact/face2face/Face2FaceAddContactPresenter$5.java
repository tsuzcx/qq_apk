package com.tencent.mobileqq.activity.contact.addcontact.face2face;

import com.tencent.mobileqq.app.FriendListObserver;

class Face2FaceAddContactPresenter$5
  extends FriendListObserver
{
  Face2FaceAddContactPresenter$5(Face2FaceAddContactPresenter paramFace2FaceAddContactPresenter) {}
  
  protected void onUpdateDelFriend(boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && (Face2FaceAddContactPresenter.a(this.a) != null)) {
      Face2FaceAddContactPresenter.a(this.a).a(String.valueOf(paramObject));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.face2face.Face2FaceAddContactPresenter.5
 * JD-Core Version:    0.7.0.1
 */