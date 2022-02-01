package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle;

import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.ttpic.openapi.model.VideoMaterial;

class PersonalityOperator$1
  implements Runnable
{
  PersonalityOperator$1(PersonalityOperator paramPersonalityOperator, VideoMaterial paramVideoMaterial) {}
  
  public void run()
  {
    long l1 = System.currentTimeMillis();
    this.this$0.a(this.a.getId());
    Object localObject = this.this$0;
    ((PersonalityOperator)localObject).a(((PersonalityOperator)localObject).a, this.this$0.b, 1.0D);
    long l2 = System.currentTimeMillis();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setVideoFilter ");
    ((StringBuilder)localObject).append(this.a.getId());
    ((StringBuilder)localObject).append(" t:");
    ((StringBuilder)localObject).append(l2 - l1);
    SLog.b("PersonalityOperator", ((StringBuilder)localObject).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.PersonalityOperator.1
 * JD-Core Version:    0.7.0.1
 */