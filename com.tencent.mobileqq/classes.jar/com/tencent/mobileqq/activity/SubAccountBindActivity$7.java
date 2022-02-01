package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.app.face.FaceDrawable;

class SubAccountBindActivity$7
  implements Runnable
{
  SubAccountBindActivity$7(SubAccountBindActivity paramSubAccountBindActivity, String paramString, int paramInt) {}
  
  public void run()
  {
    FaceDrawable localFaceDrawable = FaceDrawable.getFaceDrawable(this.this$0.app, 1, this.jdField_a_of_type_JavaLangString);
    this.this$0.runOnUiThread(new SubAccountBindActivity.7.1(this, localFaceDrawable));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SubAccountBindActivity.7
 * JD-Core Version:    0.7.0.1
 */