package com.tencent.biz.troop;

class VideoCombineHelper$SendingTask
  extends VideoCombineHelper.Task
{
  public VideoCombineHelper$SendingTask(VideoCombineHelper paramVideoCombineHelper, VideoCombineHelper.TaskListener paramTaskListener, String paramString)
  {
    super(paramVideoCombineHelper, paramTaskListener, paramString);
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper.a.a();
    VideoCombineHelper.CombineParams localCombineParams = a();
    this.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper.a.a(localCombineParams.e, localCombineParams.jdField_a_of_type_JavaLangString, localCombineParams.jdField_a_of_type_Int, new VideoCombineHelper.SendingTask.1(this));
    this.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$TaskListener.b(this);
    this.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$Task = new VideoCombineHelper.ClearTask(this.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper, this.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$TaskListener, this.c);
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.troop.VideoCombineHelper.SendingTask
 * JD-Core Version:    0.7.0.1
 */