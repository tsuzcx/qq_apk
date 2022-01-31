package com.tencent.biz.qqstory.playmode.util;

import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import nqr;
import nqs;
import nqt;
import nqu;

public class BatchGetVideoInfoHandler
{
  public int a;
  public BatchGetVideoInfoHandler.IBatchGetVideoInfoCallback a;
  public ArrayList a;
  public AppRuntime a;
  public int b;
  public int c;
  public int d;
  public int e;
  public int f;
  public int g;
  
  public BatchGetVideoInfoHandler(AppRuntime paramAppRuntime, ArrayList paramArrayList, int paramInt)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_MqqAppAppRuntime = paramAppRuntime;
    this.jdField_a_of_type_JavaUtilArrayList.addAll(paramArrayList);
    this.g = paramInt;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Int == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.e("BatchGetVideoInfoHandler", 2, "getPreviousInfoList, mStartIndex is already 0");
      }
      return;
    }
    this.f = 1;
    if (this.jdField_a_of_type_Int - 10 >= 0) {}
    for (int i = this.jdField_a_of_type_Int - 10;; i = 0)
    {
      this.d = i;
      this.e = this.jdField_a_of_type_Int;
      this.jdField_a_of_type_Int = this.d;
      BatchGetVideoInfo localBatchGetVideoInfo = new BatchGetVideoInfo(this.jdField_a_of_type_JavaUtilArrayList.subList(this.d, this.e));
      localBatchGetVideoInfo.a(new nqs(this, localBatchGetVideoInfo));
      localBatchGetVideoInfo.b();
      return;
    }
  }
  
  public void a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_JavaUtilArrayList.size()))
    {
      if (QLog.isColorLevel()) {
        QLog.e("BatchGetVideoInfoHandler", 2, "getFirstInfoList, index is wrong:" + paramInt + ", mVidList.size():" + this.jdField_a_of_type_JavaUtilArrayList.size());
      }
      return;
    }
    this.f = 0;
    this.c = paramInt;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_b_of_type_Int = (paramInt + 1);
    this.d = this.jdField_a_of_type_Int;
    this.e = this.jdField_b_of_type_Int;
    BatchGetVideoInfo localBatchGetVideoInfo = new BatchGetVideoInfo(this.jdField_a_of_type_JavaUtilArrayList.subList(this.d, this.e));
    localBatchGetVideoInfo.a(new nqr(this, localBatchGetVideoInfo));
    localBatchGetVideoInfo.b();
  }
  
  public void a(int paramInt, ArrayList paramArrayList)
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
  
  public void a(BatchGetVideoInfoHandler.IBatchGetVideoInfoCallback paramIBatchGetVideoInfoCallback)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeUtilBatchGetVideoInfoHandler$IBatchGetVideoInfoCallback = paramIBatchGetVideoInfoCallback;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.i("BatchGetVideoInfoHandler", 2, "retryLastRequest, mReqType:" + this.f + ", start:" + this.d + ",end:" + this.e);
    }
    BatchGetVideoInfo localBatchGetVideoInfo = new BatchGetVideoInfo(this.jdField_a_of_type_JavaUtilArrayList.subList(this.d, this.e));
    localBatchGetVideoInfo.a(new nqt(this, localBatchGetVideoInfo));
    localBatchGetVideoInfo.b();
  }
  
  public void b(int paramInt)
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
  
  public void c()
  {
    if (this.jdField_b_of_type_Int == this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      if (QLog.isColorLevel()) {
        QLog.e("BatchGetVideoInfoHandler", 2, "getNextInfoList, mEndIndex is already last");
      }
      return;
    }
    this.f = 2;
    this.d = this.jdField_b_of_type_Int;
    if (this.jdField_b_of_type_Int + 10 <= this.jdField_a_of_type_JavaUtilArrayList.size()) {}
    for (int i = this.jdField_b_of_type_Int + 10;; i = this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      this.e = i;
      this.jdField_b_of_type_Int = this.e;
      BatchGetVideoInfo localBatchGetVideoInfo = new BatchGetVideoInfo(this.jdField_a_of_type_JavaUtilArrayList.subList(this.d, this.e));
      localBatchGetVideoInfo.a(new nqu(this, localBatchGetVideoInfo));
      localBatchGetVideoInfo.b();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.playmode.util.BatchGetVideoInfoHandler
 * JD-Core Version:    0.7.0.1
 */