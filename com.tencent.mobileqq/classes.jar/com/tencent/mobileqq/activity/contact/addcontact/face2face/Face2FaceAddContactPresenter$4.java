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
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onFace2FaceAddContactPush mSessionId:");
      localStringBuilder.append(Face2FaceAddContactPresenter.a(this.a));
      localStringBuilder.append(" sessionId:");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(" faceFriends:");
      localStringBuilder.append(paramList);
      localStringBuilder.append(" currentUin:");
      localStringBuilder.append(paramString1);
      QLog.d("Face2FaceAddContactPresenter", 2, localStringBuilder.toString());
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
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onExitFace2FaceAddContact isSuccess:");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(" mSessionId:");
      localStringBuilder.append(Face2FaceAddContactPresenter.a(this.a));
      localStringBuilder.append(" sessionId:");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(" errorCode:");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" errorMsg:");
      localStringBuilder.append(paramString2);
      QLog.d("Face2FaceAddContactPresenter", 2, localStringBuilder.toString());
    }
    Face2FaceAddContactPresenter.a(this.a);
    if (Face2FaceAddContactPresenter.a(this.a) != null) {
      Face2FaceAddContactPresenter.a(this.a).a();
    }
  }
  
  public void a(boolean paramBoolean1, String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3, int paramInt3, int paramInt4, boolean paramBoolean2)
  {
    if (QLog.isDebugVersion())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onEnterFace2FaceAddContact isSuccess:");
      localStringBuilder.append(paramBoolean1);
      localStringBuilder.append(" mSessionId:");
      localStringBuilder.append(Face2FaceAddContactPresenter.a(this.a));
      localStringBuilder.append(" sessionId:");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(" errorCode:");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(" errorMsg:");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(" securityLevel:");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(" verifyUrl:");
      localStringBuilder.append(paramString3);
      localStringBuilder.append(" heartbeatTime:");
      localStringBuilder.append(paramInt3);
      localStringBuilder.append(" expireTime:");
      localStringBuilder.append(paramInt4);
      localStringBuilder.append(" isEnterAfterVerify:");
      localStringBuilder.append(paramBoolean2);
      QLog.d("Face2FaceAddContactPresenter", 2, localStringBuilder.toString());
    }
    Face2FaceAddContactPresenter.a(this.a, paramBoolean1, paramString1, paramInt1, paramString2, paramInt2, paramString3, paramInt3, paramInt4, paramBoolean2);
  }
  
  public void a(boolean paramBoolean, String paramString1, int paramInt, String paramString2, List<String> paramList)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onFace2FaceAddContactHeartBeat isSuccess:");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(" mSessionId:");
      localStringBuilder.append(Face2FaceAddContactPresenter.a(this.a));
      localStringBuilder.append(" sessionId:");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(" errorCode:");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" errorMsg:");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(" missingList:");
      localStringBuilder.append(paramList);
      QLog.d("Face2FaceAddContactPresenter", 2, localStringBuilder.toString());
    }
    Face2FaceAddContactPresenter.a(this.a, paramBoolean, paramString1, paramInt, paramString2, paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.face2face.Face2FaceAddContactPresenter.4
 * JD-Core Version:    0.7.0.1
 */