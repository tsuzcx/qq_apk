package com.tencent.avgame.business.api.impl;

import com.tencent.avgame.business.observer.AvGameRoomListObserver;
import com.tencent.avgame.business.observer.AvGameRoomListObserver.BatchGetGroupGameRoomListResult;
import java.util.List;

class AvGameManagerImpl$1
  extends AvGameRoomListObserver
{
  AvGameManagerImpl$1(AvGameManagerImpl paramAvGameManagerImpl) {}
  
  public void a(int paramInt, String paramString, AvGameRoomListObserver.BatchGetGroupGameRoomListResult paramBatchGetGroupGameRoomListResult)
  {
    if ((paramInt == 0) && (paramBatchGetGroupGameRoomListResult != null) && (paramBatchGetGroupGameRoomListResult.jdField_a_of_type_JavaUtilList != null))
    {
      if (paramBatchGetGroupGameRoomListResult.jdField_a_of_type_JavaLangString == null) {
        return;
      }
      if (paramBatchGetGroupGameRoomListResult.jdField_a_of_type_JavaUtilList.size() == 0) {
        AvGameManagerImpl.access$000(this.a, paramBatchGetGroupGameRoomListResult.jdField_a_of_type_JavaLangString, false);
      }
    }
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      return;
    }
    if (paramInt == 1)
    {
      if (!this.a.isAVGameOpen(paramString1)) {
        AvGameManagerImpl.access$000(this.a, paramString1, true);
      }
    }
    else if ((paramInt == 5) && (this.a.isAVGameOpen(paramString1))) {
      AvGameManagerImpl.access$000(this.a, paramString1, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.business.api.impl.AvGameManagerImpl.1
 * JD-Core Version:    0.7.0.1
 */