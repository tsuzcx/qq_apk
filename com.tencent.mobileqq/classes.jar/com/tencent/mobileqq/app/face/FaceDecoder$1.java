package com.tencent.mobileqq.app.face;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.avatar.api.IQQAvatarHandlerService;

final class FaceDecoder$1
  implements Runnable
{
  FaceDecoder$1(AppInterface paramAppInterface, FaceInfo paramFaceInfo) {}
  
  public void run()
  {
    IQQAvatarHandlerService localIQQAvatarHandlerService = (IQQAvatarHandlerService)this.val$app.getRuntimeService(IQQAvatarHandlerService.class, "");
    if ((this.val$faceInfo.b != 1) && (this.val$faceInfo.b != 101) && (this.val$faceInfo.b != 115))
    {
      if (this.val$faceInfo.b == 11)
      {
        localIQQAvatarHandlerService.getMobileQQHead(this.val$faceInfo.c, this.val$faceInfo.g);
        return;
      }
      if (this.val$faceInfo.b == 4)
      {
        localIQQAvatarHandlerService.getTroopHead(this.val$faceInfo.c, this.val$faceInfo.g);
        return;
      }
      if (this.val$faceInfo.b == 32)
      {
        localIQQAvatarHandlerService.getStrangerHead(this.val$faceInfo.c, this.val$faceInfo.d, this.val$faceInfo.f, this.val$faceInfo.g);
        return;
      }
      if (this.val$faceInfo.b == 16)
      {
        localIQQAvatarHandlerService.getQCallHead(this.val$faceInfo.c, this.val$faceInfo.d, this.val$faceInfo.f, this.val$faceInfo.g);
        return;
      }
      if (this.val$faceInfo.b == 116) {
        localIQQAvatarHandlerService.getApolloHead(this.val$faceInfo.c, this.val$faceInfo.f, this.val$faceInfo.g, this.val$faceInfo.j);
      }
    }
    else
    {
      localIQQAvatarHandlerService.getCustomHead(this.val$faceInfo.c, this.val$faceInfo.f, this.val$faceInfo.g);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.face.FaceDecoder.1
 * JD-Core Version:    0.7.0.1
 */