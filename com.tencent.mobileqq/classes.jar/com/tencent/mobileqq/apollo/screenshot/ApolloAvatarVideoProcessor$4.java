package com.tencent.mobileqq.apollo.screenshot;

import android.text.TextUtils;
import com.tencent.mobileqq.apollo.api.uitls.impl.ApolloAvatarFileManager;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class ApolloAvatarVideoProcessor$4
  implements ApolloVideoEncoder.OnEncodeFinishListener
{
  ApolloAvatarVideoProcessor$4(ApolloAvatarVideoProcessor paramApolloAvatarVideoProcessor) {}
  
  public void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ApolloAvatarVideoProcessor", 2, "onEncodeFinish: " + paramInt + ", " + paramString);
    }
    if (paramInt == 0) {
      if (paramString.endsWith(ApolloAvatarVideoProcessor.a(this.a, 0) + ".mp4"))
      {
        ApolloAvatarVideoProcessor.c(this.a, paramString);
        ApolloAvatarVideoProcessor.a(this.a, ApolloAvatarVideoProcessor.a(this.a, 1));
        if (QLog.isColorLevel()) {
          QLog.i("ApolloAvatarVideoProcessor", 2, "onEncodeFinish paths = " + ApolloAvatarVideoProcessor.b(this.a) + ", " + ApolloAvatarVideoProcessor.c(this.a) + ", " + ApolloAvatarVideoProcessor.d(this.a) + ", " + ApolloAvatarVideoProcessor.a(this.a));
        }
        if ((!TextUtils.isEmpty(ApolloAvatarVideoProcessor.b(this.a))) && (!TextUtils.isEmpty(ApolloAvatarVideoProcessor.c(this.a))) && (!TextUtils.isEmpty(ApolloAvatarVideoProcessor.d(this.a)))) {
          ThreadManager.getSubThreadHandler().postDelayed(new ApolloAvatarVideoProcessor.4.1(this), 0L);
        }
      }
    }
    do
    {
      return;
      if (paramString.endsWith(ApolloAvatarVideoProcessor.a(this.a, 1) + ".mp4"))
      {
        ApolloAvatarVideoProcessor.d(this.a, paramString);
        ApolloAvatarVideoProcessor.a(this.a, ApolloAvatarVideoProcessor.a(this.a, 2));
        break;
      }
      if (!paramString.endsWith(ApolloAvatarVideoProcessor.a(this.a, 2) + ".mp4")) {
        break;
      }
      ApolloAvatarVideoProcessor.e(this.a, paramString);
      break;
      QLog.i("ApolloAvatarVideoProcessor", 2, "onEncodeFinish fail! errno = " + paramInt);
      if (paramInt == 2) {
        ApolloAvatarFileManager.a().a(ApolloAvatarVideoProcessor.a(this.a));
      }
    } while (ApolloAvatarVideoProcessor.a(this.a) == null);
    ApolloAvatarVideoProcessor.a(this.a).a(false, ApolloAvatarVideoProcessor.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.screenshot.ApolloAvatarVideoProcessor.4
 * JD-Core Version:    0.7.0.1
 */