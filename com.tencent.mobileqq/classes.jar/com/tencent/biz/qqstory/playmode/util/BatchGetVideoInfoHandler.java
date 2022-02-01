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
    boolean bool2 = true;
    if (QLog.isColorLevel()) {
      QLog.e("BatchGetVideoInfoHandler", 2, "handleFail, reqType:" + paramInt);
    }
    BatchGetVideoInfoHandler.VideoInfoListEvent localVideoInfoListEvent;
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeUtilBatchGetVideoInfoHandler$IBatchGetVideoInfoCallback != null)
    {
      localVideoInfoListEvent = new BatchGetVideoInfoHandler.VideoInfoListEvent();
      localVideoInfoListEvent.jdField_a_of_type_Int = paramInt;
      if (this.jdField_a_of_type_Int != 0) {
        break label113;
      }
      bool1 = true;
      localVideoInfoListEvent.jdField_a_of_type_Boolean = bool1;
      if (this.jdField_b_of_type_Int != this.jdField_a_of_type_JavaUtilArrayList.size() - 1) {
        break label118;
      }
    }
    label113:
    label118:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localVideoInfoListEvent.jdField_b_of_type_Boolean = bool1;
      localVideoInfoListEvent.c = -100;
      this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeUtilBatchGetVideoInfoHandler$IBatchGetVideoInfoCallback.a(localVideoInfoListEvent);
      return;
      bool1 = false;
      break;
    }
  }
  
  public void a(int paramInt, ArrayList<StoryVideoItem> paramArrayList)
  {
    boolean bool2 = true;
    BatchGetVideoInfoHandler.VideoInfoListEvent localVideoInfoListEvent;
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeUtilBatchGetVideoInfoHandler$IBatchGetVideoInfoCallback != null)
    {
      localVideoInfoListEvent = new BatchGetVideoInfoHandler.VideoInfoListEvent();
      localVideoInfoListEvent.jdField_a_of_type_Int = paramInt;
      if (this.jdField_a_of_type_Int != 0) {
        break label105;
      }
      bool1 = true;
      localVideoInfoListEvent.jdField_a_of_type_Boolean = bool1;
      if (this.jdField_b_of_type_Int != this.jdField_a_of_type_JavaUtilArrayList.size()) {
        break label110;
      }
    }
    label105:
    label110:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localVideoInfoListEvent.jdField_b_of_type_Boolean = bool1;
      localVideoInfoListEvent.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
      localVideoInfoListEvent.c = 0;
      if (paramInt == 0) {
        localVideoInfoListEvent.jdField_b_of_type_Int = (this.c - this.jdField_a_of_type_Int);
      }
      this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeUtilBatchGetVideoInfoHandler$IBatchGetVideoInfoCallback.a(localVideoInfoListEvent);
      return;
      bool1 = false;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.playmode.util.BatchGetVideoInfoHandler
 * JD-Core Version:    0.7.0.1
 */