package com.tencent.mobileqq.app;

import amos;
import aqzw;
import arad;
import avsq;
import com.tencent.mobileqq.utils.FileUtils;
import java.util.List;

public class CameraEmoRoamingHandler$2
  implements Runnable
{
  public CameraEmoRoamingHandler$2(amos paramamos, String paramString, List paramList1, List paramList2) {}
  
  public void run()
  {
    FileUtils.createFileIfNotExits(AppConstants.SDCARD_IMG_CAMERA_EMO + ".nomedia");
    ((aqzw)this.this$0.app.getManager(334)).a(this.jdField_a_of_type_JavaLangString);
    ((arad)this.this$0.app.getManager(333)).a(this.jdField_a_of_type_JavaUtilList, this.b, null);
    this.this$0.a(2, true, 0);
    avsq.e("0", 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.CameraEmoRoamingHandler.2
 * JD-Core Version:    0.7.0.1
 */