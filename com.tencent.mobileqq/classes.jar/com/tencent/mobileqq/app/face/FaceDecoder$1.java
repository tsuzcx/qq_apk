package com.tencent.mobileqq.app.face;

import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;

final class FaceDecoder$1
  implements Runnable
{
  FaceDecoder$1(FaceInfo paramFaceInfo, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    if ((this.val$faceInfo.jdField_a_of_type_Int == 1) || (this.val$faceInfo.jdField_a_of_type_Int == 101) || (this.val$faceInfo.jdField_a_of_type_Int == 115)) {
      ((FriendListHandler)this.val$app.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getCustomHead(this.val$faceInfo.jdField_a_of_type_JavaLangString, this.val$faceInfo.jdField_a_of_type_Byte, this.val$faceInfo.jdField_b_of_type_Byte);
    }
    do
    {
      return;
      if (this.val$faceInfo.jdField_a_of_type_Int == 11)
      {
        ((FriendListHandler)this.val$app.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getMobileQQHead(this.val$faceInfo.jdField_a_of_type_JavaLangString, this.val$faceInfo.jdField_b_of_type_Byte);
        return;
      }
      if (this.val$faceInfo.jdField_a_of_type_Int == 4)
      {
        ((FriendListHandler)this.val$app.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getTroopHead(this.val$faceInfo.jdField_a_of_type_JavaLangString, this.val$faceInfo.jdField_b_of_type_Byte);
        return;
      }
      if (this.val$faceInfo.jdField_a_of_type_Int == 32)
      {
        ((FriendListHandler)this.val$app.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getStrangerHead(this.val$faceInfo.jdField_a_of_type_JavaLangString, this.val$faceInfo.jdField_b_of_type_Int, this.val$faceInfo.jdField_a_of_type_Byte, this.val$faceInfo.jdField_b_of_type_Byte);
        return;
      }
      if (this.val$faceInfo.jdField_a_of_type_Int == 16)
      {
        ((FriendListHandler)this.val$app.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getQCallHead(this.val$faceInfo.jdField_a_of_type_JavaLangString, this.val$faceInfo.jdField_b_of_type_Int, this.val$faceInfo.jdField_a_of_type_Byte, this.val$faceInfo.jdField_b_of_type_Byte);
        return;
      }
    } while (this.val$faceInfo.jdField_a_of_type_Int != 116);
    ((FriendListHandler)this.val$app.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getApolloHead(this.val$faceInfo.jdField_a_of_type_JavaLangString, this.val$faceInfo.jdField_a_of_type_Byte, this.val$faceInfo.jdField_b_of_type_Byte, this.val$faceInfo.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.face.FaceDecoder.1
 * JD-Core Version:    0.7.0.1
 */