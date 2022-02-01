package com.tencent.biz.qqstory.base.videoupload;

import android.os.Handler;

class StoryVideoUploadProgressManager$ProgressStatus
{
  public int a;
  private Runnable jdField_a_of_type_JavaLangRunnable = new StoryVideoUploadProgressManager.ProgressStatus.1(this);
  public String a;
  public boolean a;
  public int b;
  public String b;
  private boolean b;
  
  private StoryVideoUploadProgressManager$ProgressStatus(StoryVideoUploadProgressManager paramStoryVideoUploadProgressManager) {}
  
  private void c()
  {
    int i = this.jdField_a_of_type_Int;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            if ((i != 4) && (i != 5)) {
              return;
            }
            this.jdField_b_of_type_Int = 100;
            return;
          }
          this.jdField_b_of_type_Int += 1;
          if (this.jdField_b_of_type_Int >= 100) {
            this.jdField_b_of_type_Int = 99;
          }
        }
        else
        {
          this.jdField_b_of_type_Int += 1;
          if (this.jdField_b_of_type_Int >= 95) {
            this.jdField_b_of_type_Int = 94;
          }
        }
      }
      else
      {
        this.jdField_b_of_type_Int += 1;
        if (this.jdField_b_of_type_Int >= 60) {
          this.jdField_b_of_type_Int = 59;
        }
      }
    }
    else {
      this.jdField_b_of_type_Int = 0;
    }
  }
  
  public void a()
  {
    this.jdField_b_of_type_Boolean = false;
    StoryVideoUploadProgressManager.a(this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadStoryVideoUploadProgressManager).postDelayed(this.jdField_a_of_type_JavaLangRunnable, 200L);
  }
  
  public void b()
  {
    this.jdField_b_of_type_Boolean = true;
    StoryVideoUploadProgressManager.a(this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadStoryVideoUploadProgressManager).removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.videoupload.StoryVideoUploadProgressManager.ProgressStatus
 * JD-Core Version:    0.7.0.1
 */