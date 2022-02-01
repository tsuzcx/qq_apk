package com.tencent.mobileqq.activity.aio.helper;

import com.tencent.avgame.business.observer.AvGameRoomListObserver.BatchGetGroupGameRoomListResult;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.tips.AVGameStatusTipsBar;
import java.util.List;

class AVGameHelper$1$1
  implements Runnable
{
  AVGameHelper$1$1(AVGameHelper.1 param1, AvGameRoomListObserver.BatchGetGroupGameRoomListResult paramBatchGetGroupGameRoomListResult) {}
  
  public void run()
  {
    AvGameRoomListObserver.BatchGetGroupGameRoomListResult localBatchGetGroupGameRoomListResult = this.jdField_a_of_type_ComTencentAvgameBusinessObserverAvGameRoomListObserver$BatchGetGroupGameRoomListResult;
    if ((localBatchGetGroupGameRoomListResult != null) && (localBatchGetGroupGameRoomListResult.jdField_a_of_type_JavaLangString != null) && (AVGameHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperAVGameHelper$1.a).jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentAvgameBusinessObserverAvGameRoomListObserver$BatchGetGroupGameRoomListResult.jdField_a_of_type_JavaLangString)))
    {
      if (AVGameHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperAVGameHelper$1.a) == null) {
        return;
      }
      if ((this.jdField_a_of_type_ComTencentAvgameBusinessObserverAvGameRoomListObserver$BatchGetGroupGameRoomListResult.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_ComTencentAvgameBusinessObserverAvGameRoomListObserver$BatchGetGroupGameRoomListResult.jdField_a_of_type_JavaUtilList.size() > 0))
      {
        AVGameHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperAVGameHelper$1.a).a(this.jdField_a_of_type_ComTencentAvgameBusinessObserverAvGameRoomListObserver$BatchGetGroupGameRoomListResult.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_ComTencentAvgameBusinessObserverAvGameRoomListObserver$BatchGetGroupGameRoomListResult.jdField_a_of_type_Int);
        return;
      }
      AVGameHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperAVGameHelper$1.a).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.AVGameHelper.1.1
 * JD-Core Version:    0.7.0.1
 */