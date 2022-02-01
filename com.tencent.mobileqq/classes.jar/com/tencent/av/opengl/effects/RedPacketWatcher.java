package com.tencent.av.opengl.effects;

import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.redpacket.AVRedPacketManager;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class RedPacketWatcher
  implements FilterProcessRender.FaceDataWatcher
{
  protected final AVRedPacketManager a;
  protected final String a;
  
  public RedPacketWatcher(VideoAppInterface paramVideoAppInterface)
  {
    this.jdField_a_of_type_JavaLangString = "RedPacketWatcher";
    this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager = ((AVRedPacketManager)paramVideoAppInterface.a(6));
  }
  
  public void a(FaceData paramFaceData, int paramInt1, int paramInt2, int paramInt3)
  {
    String str;
    if ((QLog.isDevelopLevel()) && (a()))
    {
      str = "";
      if (paramFaceData == null)
      {
        str = "onDetectFace, face data is null.";
        QLog.i("RedPacketWatcher", 4, str);
      }
    }
    else
    {
      if (paramFaceData != null) {
        break label100;
      }
    }
    label100:
    while ((paramFaceData.jdField_a_of_type_Int <= 0) || (!a()))
    {
      return;
      if (paramFaceData.jdField_a_of_type_Int <= 0)
      {
        str = "onDetectFace, face count is 0.";
        break;
      }
      if ((paramFaceData.jdField_a_of_type_JavaUtilList == null) || (paramFaceData.jdField_a_of_type_JavaUtilList.size() == 0))
      {
        str = "onDetectFace, face feature is null or size is 0.";
        break;
      }
      if ((paramFaceData.jdField_a_of_type_ArrayOfFloat != null) && (paramFaceData.jdField_a_of_type_ArrayOfFloat.length != 0)) {
        break;
      }
      str = "onDetectFace, face angles is null or size is 0.";
      break;
    }
    if ((paramFaceData.jdField_a_of_type_JavaUtilList != null) && (paramFaceData.jdField_a_of_type_JavaUtilList.size() > 0) && (paramFaceData.jdField_a_of_type_ArrayOfFloat != null) && (paramFaceData.jdField_a_of_type_ArrayOfFloat.length > 0)) {
      this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager.a(paramFaceData.jdField_a_of_type_JavaUtilList, paramFaceData.jdField_a_of_type_ArrayOfFloat);
    }
    this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager.a(paramInt1, paramInt2, paramInt3);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.opengl.effects.RedPacketWatcher
 * JD-Core Version:    0.7.0.1
 */