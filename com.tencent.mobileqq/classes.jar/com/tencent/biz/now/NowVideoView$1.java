package com.tencent.biz.now;

import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.data.MessageRecord;

class NowVideoView$1
  extends Handler
{
  NowVideoView$1(NowVideoView paramNowVideoView) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        return;
      } while ((this.a.jdField_a_of_type_ComTencentBizNowNowLiveManager == null) || (this.a.jdField_a_of_type_ComTencentMobileqqDataMessageRecord == null));
      this.a.jdField_a_of_type_ComTencentBizNowNowLiveManager.a(this.a.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin, this.a.jdField_a_of_type_JavaLangString, this.a.b, this.a.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.msgseq, true);
      return;
    } while ((this.a.jdField_a_of_type_ComTencentBizNowNowLiveManager == null) || (this.a.jdField_a_of_type_ComTencentMobileqqDataMessageRecord == null) || (this.a.jdField_a_of_type_Boolean) || (this.a.d != 2));
    this.a.jdField_a_of_type_ComTencentBizNowNowLiveManager.a(this.a.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin, this.a.jdField_a_of_type_JavaLangString, this.a.b, this.a.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.msgseq, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.now.NowVideoView.1
 * JD-Core Version:    0.7.0.1
 */