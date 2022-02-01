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
    if ((this.val$faceInfo.jdField_a_of_type_Int != 1) && (this.val$faceInfo.jdField_a_of_type_Int != 101) && (this.val$faceInfo.jdField_a_of_type_Int != 115))
    {
      if (this.val$faceInfo.jdField_a_of_type_Int == 11)
      {
        localIQQAvatarHandlerService.getMobileQQHead(this.val$faceInfo.jdField_a_of_type_JavaLangString, this.val$faceInfo.jdField_b_of_type_Byte);
        return;
      }
      if (this.val$faceInfo.jdField_a_of_type_Int == 4)
      {
        localIQQAvatarHandlerService.getTroopHead(this.val$faceInfo.jdField_a_of_type_JavaLangString, this.val$faceInfo.jdField_b_of_type_Byte);
        return;
      }
      if (this.val$faceInfo.jdField_a_of_type_Int == 32)
      {
        localIQQAvatarHandlerService.getStrangerHead(this.val$faceInfo.jdField_a_of_type_JavaLangString, this.val$faceInfo.jdField_b_of_type_Int, this.val$faceInfo.jdField_a_of_type_Byte, this.val$faceInfo.jdField_b_of_type_Byte);
        return;
      }
      if (this.val$faceInfo.jdField_a_of_type_Int == 16)
      {
        localIQQAvatarHandlerService.getQCallHead(this.val$faceInfo.jdField_a_of_type_JavaLangString, this.val$faceInfo.jdField_b_of_type_Int, this.val$faceInfo.jdField_a_of_type_Byte, this.val$faceInfo.jdField_b_of_type_Byte);
        return;
      }
      if (this.val$faceInfo.jdField_a_of_type_Int == 116) {
        localIQQAvatarHandlerService.getApolloHead(this.val$faceInfo.jdField_a_of_type_JavaLangString, this.val$faceInfo.jdField_a_of_type_Byte, this.val$faceInfo.jdField_b_of_type_Byte, this.val$faceInfo.d);
      }
    }
    else
    {
      localIQQAvatarHandlerService.getCustomHead(this.val$faceInfo.jdField_a_of_type_JavaLangString, this.val$faceInfo.jdField_a_of_type_Byte, this.val$faceInfo.jdField_b_of_type_Byte);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.face.FaceDecoder.1
 * JD-Core Version:    0.7.0.1
 */