package com.tencent.mobileqq.app;

import android.os.Bundle;
import aobl;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

public class MayknowRecommendManager$5
  implements Runnable
{
  public MayknowRecommendManager$5(aobl paramaobl, int paramInt1, int paramInt2, Bundle paramBundle) {}
  
  public void run()
  {
    aobl.b(this.this$0, this.jdField_a_of_type_Int);
    byte[] arrayOfByte = (byte[])aobl.a(this.this$0).get(Integer.valueOf(this.jdField_a_of_type_Int));
    if ((arrayOfByte != null) && (arrayOfByte.length > 0))
    {
      localBoolean = (Boolean)aobl.b(this.this$0).get(Integer.valueOf(this.jdField_a_of_type_Int));
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
      aobl.b(this.this$0).put(Integer.valueOf(this.jdField_a_of_type_Int), Boolean.valueOf(true));
      ((FriendListHandler)aobl.a(this.this$0).a(1)).a(this.b, this.jdField_a_of_type_Int, arrayOfByte, false, this.jdField_a_of_type_AndroidOsBundle);
      return;
    }
    QLog.d("MayknowRecommendManager", 2, "getConnectionsPersonRemoteNextPage no cookie! no need to request");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.MayknowRecommendManager.5
 * JD-Core Version:    0.7.0.1
 */