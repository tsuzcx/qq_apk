package com.tencent.biz.qqstory.playmode.util;

import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class BatchGetVideoInfoHandler
{
  public int a;
  public BatchGetVideoInfoHandler.IBatchGetVideoInfoCallback a;
  public ArrayList<String> a;
  public int b;
  public int c;
  public int d;
  
  public void a(int paramInt)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleFail, reqType:");
      ((StringBuilder)localObject).append(paramInt);
      QLog.e("BatchGetVideoInfoHandler", 2, ((StringBuilder)localObject).toString());
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeUtilBatchGetVideoInfoHandler$IBatchGetVideoInfoCallback != null)
    {
      localObject = new BatchGetVideoInfoHandler.VideoInfoListEvent();
      ((BatchGetVideoInfoHandler.VideoInfoListEvent)localObject).jdField_a_of_type_Int = paramInt;
      paramInt = this.jdField_a_of_type_Int;
      boolean bool2 = false;
      if (paramInt == 0) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      ((BatchGetVideoInfoHandler.VideoInfoListEvent)localObject).jdField_a_of_type_Boolean = bool1;
      boolean bool1 = bool2;
      if (this.jdField_b_of_type_Int == this.jdField_a_of_type_JavaUtilArrayList.size() - 1) {
        bool1 = true;
      }
      ((BatchGetVideoInfoHandler.VideoInfoListEvent)localObject).jdField_b_of_type_Boolean = bool1;
      ((BatchGetVideoInfoHandler.VideoInfoListEvent)localObject).c = -100;
      this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeUtilBatchGetVideoInfoHandler$IBatchGetVideoInfoCallback.a((BatchGetVideoInfoHandler.VideoInfoListEvent)localObject);
    }
  }
  
  public void a(int paramInt, ArrayList<StoryVideoItem> paramArrayList)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeUtilBatchGetVideoInfoHandler$IBatchGetVideoInfoCallback != null)
    {
      BatchGetVideoInfoHandler.VideoInfoListEvent localVideoInfoListEvent = new BatchGetVideoInfoHandler.VideoInfoListEvent();
      localVideoInfoListEvent.jdField_a_of_type_Int = paramInt;
      int i = this.jdField_a_of_type_Int;
      boolean bool2 = true;
      boolean bool1;
      if (i == 0) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      localVideoInfoListEvent.jdField_a_of_type_Boolean = bool1;
      if (this.jdField_b_of_type_Int == this.jdField_a_of_type_JavaUtilArrayList.size()) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
      localVideoInfoListEvent.jdField_b_of_type_Boolean = bool1;
      localVideoInfoListEvent.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
      localVideoInfoListEvent.c = 0;
      if (paramInt == 0) {
        localVideoInfoListEvent.jdField_b_of_type_Int = (this.c - this.jdField_a_of_type_Int);
      }
      this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeUtilBatchGetVideoInfoHandler$IBatchGetVideoInfoCallback.a(localVideoInfoListEvent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.playmode.util.BatchGetVideoInfoHandler
 * JD-Core Version:    0.7.0.1
 */