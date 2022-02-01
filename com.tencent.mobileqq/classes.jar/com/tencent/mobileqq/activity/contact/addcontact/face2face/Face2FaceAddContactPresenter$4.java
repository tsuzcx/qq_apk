package com.tencent.mobileqq.activity.contact.addcontact.face2face;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class Face2FaceAddContactPresenter$4
  extends Face2FaceAddContactObserver
{
  Face2FaceAddContactPresenter$4(Face2FaceAddContactPresenter paramFace2FaceAddContactPresenter) {}
  
  public void a(String paramString1, String paramString2, List<Face2FaceFriendInfo> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Face2FaceAddContactPresenter", 2, "onFace2FaceAddContactPush mSessionId:" + Face2FaceAddContactPresenter.a(this.a) + " sessionId:" + paramString2 + " faceFriends:" + paramList + " currentUin:" + paramString1);
    }
    if ((TextUtils.equals(paramString2, Face2FaceAddContactPresenter.a(this.a))) && (Face2FaceAddContactPresenter.a(this.a) != null) && (TextUtils.equals(paramString1, Face2FaceAddContactPresenter.a(this.a).getCurrentAccountUin())) && (paramList != null) && (paramList.size() > 0))
    {
      Face2FaceAddContactPresenter.a(this.a);
      if (Face2FaceAddContactPresenter.a(this.a) != null) {
        Face2FaceAddContactPresenter.a(this.a).a(paramString1, paramList);
      }
    }
  }
  
  public void a(boolean paramBoolean, String paramString1, int paramInt, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Face2FaceAddContactPresenter", 2, "onExitFace2FaceAddContact isSuccess:" + paramBoolean + " mSessionId:" + Face2FaceAddContactPresenter.a(this.a) + " sessionId:" + paramString1 + " errorCode:" + paramInt + " errorMsg:" + paramString2);
    }
    Face2FaceAddContactPresenter.a(this.a);
    if (Face2FaceAddContactPresenter.a(this.a) != null) {
      Face2FaceAddContactPresenter.a(this.a).a();
    }
  }
  
  public void a(boolean paramBoolean1, String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3, int paramInt3, int paramInt4, boolean paramBoolean2)
  {
    if (QLog.isDebugVersion()) {
      QLog.d("Face2FaceAddContactPresenter", 2, "onEnterFace2FaceAddContact isSuccess:" + paramBoolean1 + " mSessionId:" + Face2FaceAddContactPresenter.a(this.a) + " sessionId:" + paramString1 + " errorCode:" + paramInt1 + " errorMsg:" + paramString2 + " securityLevel:" + paramInt2 + " verifyUrl:" + paramString3 + " heartbeatTime:" + paramInt3 + " expireTime:" + paramInt4 + " isEnterAfterVerify:" + paramBoolean2);
    }
    Face2FaceAddContactPresenter.a(this.a, paramBoolean1, paramString1, paramInt1, paramString2, paramInt2, paramString3, paramInt3, paramInt4, paramBoolean2);
  }
  
  public void a(boolean paramBoolean, String paramString1, int paramInt, String paramString2, List<String> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Face2FaceAddContactPresenter", 2, "onFace2FaceAddContactHeartBeat isSuccess:" + paramBoolean + " mSessionId:" + Face2FaceAddContactPresenter.a(this.a) + " sessionId:" + paramString1 + " errorCode:" + paramInt + " errorMsg:" + paramString2 + " missingList:" + paramList);
    }
    Face2FaceAddContactPresenter.a(this.a, paramBoolean, paramString1, paramInt, paramString2, paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.face2face.Face2FaceAddContactPresenter.4
 * JD-Core Version:    0.7.0.1
 */