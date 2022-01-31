package com.tencent.mobileqq.app;

import akaa;
import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

public class MayknowRecommendManager$5
  implements Runnable
{
  public MayknowRecommendManager$5(akaa paramakaa, int paramInt1, int paramInt2, Bundle paramBundle) {}
  
  public void run()
  {
    akaa.b(this.this$0, this.jdField_a_of_type_Int);
    byte[] arrayOfByte = (byte[])akaa.a(this.this$0).get(Integer.valueOf(this.jdField_a_of_type_Int));
    if ((arrayOfByte != null) && (arrayOfByte.length > 0))
    {
      localBoolean = (Boolean)akaa.b(this.this$0).get(Integer.valueOf(this.jdField_a_of_type_Int));
      if ((localBoolean != null) && (localBoolean.booleanValue() == true)) {
        if (QLog.isColorLevel()) {
          QLog.d("MayknowRecommendManager", 2, "getConnectionsPersonRemoteNextPage requesting " + this.jdField_a_of_type_Int);
        }
      }
    }
    while (!QLog.isColorLevel())
    {
      Boolean localBoolean;
      return;
      akaa.b(this.this$0).put(Integer.valueOf(this.jdField_a_of_type_Int), Boolean.valueOf(true));
      ((FriendListHandler)akaa.a(this.this$0).a(1)).a(this.b, this.jdField_a_of_type_Int, arrayOfByte, false, this.jdField_a_of_type_AndroidOsBundle);
      return;
    }
    QLog.d("MayknowRecommendManager", 2, "getConnectionsPersonRemoteNextPage no cookie! no need to request");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.MayknowRecommendManager.5
 * JD-Core Version:    0.7.0.1
 */