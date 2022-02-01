package com.tencent.mobileqq.activity.troop.config;

import com.tencent.av.utils.GVideoGrayConfig.GVideoGrayConfigListener;
import com.tencent.av.utils.GVideoGrayConfig.Record;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQGAudioMsgHandler;
import com.tencent.mobileqq.troop.unreadmsg.TroopUnreadMsgInfo;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class TroopOnlinePushProcessor$WeakGVideoGrayConfigListener
  implements GVideoGrayConfig.GVideoGrayConfigListener
{
  private final TroopUnreadMsgInfo jdField_a_of_type_ComTencentMobileqqTroopUnreadmsgTroopUnreadMsgInfo;
  private final WeakReference<QQAppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  private final long[] jdField_a_of_type_ArrayOfLong;
  
  TroopOnlinePushProcessor$WeakGVideoGrayConfigListener(QQAppInterface paramQQAppInterface, TroopUnreadMsgInfo paramTroopUnreadMsgInfo, long[] paramArrayOfLong)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqTroopUnreadmsgTroopUnreadMsgInfo = paramTroopUnreadMsgInfo;
    this.jdField_a_of_type_ArrayOfLong = paramArrayOfLong;
  }
  
  public void a(int paramInt1, GVideoGrayConfig.Record paramRecord, int paramInt2)
  {
    paramRecord = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (paramRecord != null)
    {
      if (paramInt1 == 0) {
        paramRecord.getGAudioHandler().a(1, this.jdField_a_of_type_ComTencentMobileqqTroopUnreadmsgTroopUnreadMsgInfo.a, this.jdField_a_of_type_ComTencentMobileqqTroopUnreadmsgTroopUnreadMsgInfo.b, this.jdField_a_of_type_ArrayOfLong, 2, 0, 0, -1);
      }
    }
    else {
      QLog.e("TroopOnlinePushProcessor", 1, "WeakGVideoGrayConfigListener#onResult get weakAppReference null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.troop.config.TroopOnlinePushProcessor.WeakGVideoGrayConfigListener
 * JD-Core Version:    0.7.0.1
 */