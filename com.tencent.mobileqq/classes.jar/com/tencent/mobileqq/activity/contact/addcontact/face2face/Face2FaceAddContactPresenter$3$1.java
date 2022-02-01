package com.tencent.mobileqq.activity.contact.addcontact.face2face;

import android.text.TextUtils;
import com.tencent.mobileqq.soso.location.SosoInterfaceOnLocationListener;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.qphone.base.util.QLog;

class Face2FaceAddContactPresenter$3$1
  extends SosoInterfaceOnLocationListener
{
  Face2FaceAddContactPresenter$3$1(Face2FaceAddContactPresenter.3 param3, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong, boolean paramBoolean3, boolean paramBoolean4, String paramString)
  {
    super(paramInt, paramBoolean1, paramBoolean2, paramLong, paramBoolean3, paramBoolean4, paramString);
  }
  
  public void onLocationFinish(int paramInt, SosoLbsInfo paramSosoLbsInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Face2FaceAddContactPresenter", 2, "onLocationFinish errCode = " + paramInt + " info = " + paramSosoLbsInfo);
    }
    if ((paramInt != 0) || (paramSosoLbsInfo == null)) {
      if (Face2FaceAddContactPresenter.a(this.a.this$0) != null) {
        Face2FaceAddContactPresenter.a(this.a.this$0).b();
      }
    }
    while ((TextUtils.isEmpty(this.a.a)) || (this.a.a.length() != 4)) {
      return;
    }
    Face2FaceAddContactPresenter.a(this.a.this$0, paramSosoLbsInfo, this.a.a, this.a.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.face2face.Face2FaceAddContactPresenter.3.1
 * JD-Core Version:    0.7.0.1
 */