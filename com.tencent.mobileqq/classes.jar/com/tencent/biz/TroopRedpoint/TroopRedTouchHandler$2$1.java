package com.tencent.biz.TroopRedpoint;

import android.os.Bundle;
import becr;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import ntj;
import ntk;
import ntq;
import tencent.im.oidb.cmd0x791.oidb_0x791.RedDotInfo;

public class TroopRedTouchHandler$2$1
  implements Runnable
{
  public TroopRedTouchHandler$2$1(ntk paramntk, boolean paramBoolean, Bundle paramBundle) {}
  
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
      if ((!this.jdField_a_of_type_Ntk.jdField_a_of_type_JavaUtilList.contains(Integer.valueOf(46))) || (!becr.a(this.jdField_a_of_type_Ntk.jdField_a_of_type_Ntj.app))) {
        break label311;
      }
      j = 1;
      if (j == 0) {
        break label347;
      }
      oidb_0x791.RedDotInfo localRedDotInfo = ((ntq)this.jdField_a_of_type_Ntk.jdField_a_of_type_Ntj.app.getManager(QQManagerFactory.MGR_RED_TOUCH_EX)).a(46, false);
      if ((localRedDotInfo == null) || (!localRedDotInfo.uint32_last_time.has())) {
        break label316;
      }
      i = localRedDotInfo.uint32_last_time.get();
    }
    for (;;)
    {
      label152:
      if ((localObject != null) && (ntj.a(this.jdField_a_of_type_Ntk.jdField_a_of_type_Ntj.app, new ArrayList(this.jdField_a_of_type_Ntk.jdField_a_of_type_JavaUtilList), (byte[])localObject)))
      {
        this.jdField_a_of_type_Ntk.jdField_a_of_type_Ntj.a = 1;
        if (QLog.isColorLevel()) {
          QLog.i("storyRedDotDebug", 2, "getRedPointAsync");
        }
        this.jdField_a_of_type_Ntk.jdField_a_of_type_Ntj.notifyUI(105, true, null);
        if (j != 0)
        {
          localObject = ((ntq)this.jdField_a_of_type_Ntk.jdField_a_of_type_Ntj.app.getManager(QQManagerFactory.MGR_RED_TOUCH_EX)).a(46, false);
          if ((localObject != null) && (QLog.isColorLevel())) {
            QLog.d("TroopRedTouchHandlerQ.qqstory.redPoint", 2, "getRedPointInfoAsync enableTencentDocsAssistant:" + ntq.a((oidb_0x791.RedDotInfo)localObject));
          }
          ntj.a(this.jdField_a_of_type_Ntk.jdField_a_of_type_Ntj.app, (oidb_0x791.RedDotInfo)localObject, i, false);
        }
      }
      label311:
      label316:
      do
      {
        return;
        j = 0;
        break;
        i = 0;
        break label152;
        this.jdField_a_of_type_Ntk.jdField_a_of_type_Ntj.a = 2;
      } while (!QLog.isColorLevel());
      QLog.e("TroopRedTouchHandler", 2, "getRedPointInfo success data is null");
      return;
      label347:
      i = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.TroopRedpoint.TroopRedTouchHandler.2.1
 * JD-Core Version:    0.7.0.1
 */