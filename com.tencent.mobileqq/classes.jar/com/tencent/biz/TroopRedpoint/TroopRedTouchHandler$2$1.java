package com.tencent.biz.TroopRedpoint;

import android.os.Bundle;
import baic;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import nag;
import nah;
import nan;
import tencent.im.oidb.cmd0x791.oidb_0x791.RedDotInfo;

public class TroopRedTouchHandler$2$1
  implements Runnable
{
  public TroopRedTouchHandler$2$1(nah paramnah, boolean paramBoolean, Bundle paramBundle) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopRedTouchHandler", 2, "getRedPointInfo onReceive :" + this.jdField_a_of_type_Boolean);
    }
    Object localObject;
    int j;
    int i;
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_AndroidOsBundle != null))
    {
      localObject = this.jdField_a_of_type_AndroidOsBundle.getByteArray("data");
      if ((!this.jdField_a_of_type_Nah.jdField_a_of_type_JavaUtilList.contains(Integer.valueOf(46))) || (!baic.a(this.jdField_a_of_type_Nah.jdField_a_of_type_Nag.app))) {
        break label309;
      }
      j = 1;
      if (j == 0) {
        break label345;
      }
      oidb_0x791.RedDotInfo localRedDotInfo = ((nan)this.jdField_a_of_type_Nah.jdField_a_of_type_Nag.app.getManager(70)).a(46, false);
      if ((localRedDotInfo == null) || (!localRedDotInfo.uint32_last_time.has())) {
        break label314;
      }
      i = localRedDotInfo.uint32_last_time.get();
    }
    for (;;)
    {
      label151:
      if ((localObject != null) && (nag.a(this.jdField_a_of_type_Nah.jdField_a_of_type_Nag.app, new ArrayList(this.jdField_a_of_type_Nah.jdField_a_of_type_JavaUtilList), (byte[])localObject)))
      {
        this.jdField_a_of_type_Nah.jdField_a_of_type_Nag.a = 1;
        if (QLog.isColorLevel()) {
          QLog.i("storyRedDotDebug", 2, "getRedPointAsync");
        }
        this.jdField_a_of_type_Nah.jdField_a_of_type_Nag.notifyUI(105, true, null);
        if (j != 0)
        {
          localObject = ((nan)this.jdField_a_of_type_Nah.jdField_a_of_type_Nag.app.getManager(70)).a(46, false);
          if ((localObject != null) && (QLog.isColorLevel())) {
            QLog.d("TroopRedTouchHandlerQ.qqstory.redPoint", 2, "getRedPointInfoAsync enableTencentDocsAssistant:" + nan.a((oidb_0x791.RedDotInfo)localObject));
          }
          nag.a(this.jdField_a_of_type_Nah.jdField_a_of_type_Nag.app, (oidb_0x791.RedDotInfo)localObject, i, false);
        }
      }
      label309:
      label314:
      do
      {
        return;
        j = 0;
        break;
        i = 0;
        break label151;
        this.jdField_a_of_type_Nah.jdField_a_of_type_Nag.a = 2;
      } while (!QLog.isColorLevel());
      QLog.e("TroopRedTouchHandler", 2, "getRedPointInfo success data is null");
      return;
      label345:
      i = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.TroopRedpoint.TroopRedTouchHandler.2.1
 * JD-Core Version:    0.7.0.1
 */