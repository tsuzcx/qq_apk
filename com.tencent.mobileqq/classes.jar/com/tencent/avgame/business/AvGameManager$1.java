package com.tencent.avgame.business;

import com.tencent.avgame.business.observer.AvGameRoomListObserver;
import com.tencent.avgame.business.observer.AvGameRoomListObserver.BatchGetGroupGameRoomListResult;
import java.util.List;

class AvGameManager$1
  extends AvGameRoomListObserver
{
  AvGameManager$1(AvGameManager paramAvGameManager) {}
  
  public void a(int paramInt, String paramString, AvGameRoomListObserver.BatchGetGroupGameRoomListResult paramBatchGetGroupGameRoomListResult)
  {
    if ((paramInt != 0) || (paramBatchGetGroupGameRoomListResult == null) || (paramBatchGetGroupGameRoomListResult.jdField_a_of_type_JavaUtilList == null) || (paramBatchGetGroupGameRoomListResult.jdField_a_of_type_JavaLangString == null)) {}
    while (paramBatchGetGroupGameRoomListResult.jdField_a_of_type_JavaUtilList.size() != 0) {
      return;
    }
    AvGameManager.a(this.a, paramBatchGetGroupGameRoomListResult.jdField_a_of_type_JavaLangString, false);
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    if (paramString1 == null) {}
    do
    {
      do
      {
        return;
        if (paramInt != 1) {
          break;
        }
      } while (this.a.b(paramString1));
      AvGameManager.a(this.a, paramString1, true);
      return;
    } while ((paramInt != 5) || (!this.a.b(paramString1)));
    AvGameManager.a(this.a, paramString1, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.business.AvGameManager.1
 * JD-Core Version:    0.7.0.1
 */