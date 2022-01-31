package com.tencent.biz.qqstory.takevideo.doodle.ui.doodle;

import com.tencent.ttpic.openapi.model.VideoMaterial;
import ved;
import vol;

public class PersonalityOperator$1
  implements Runnable
{
  public PersonalityOperator$1(vol paramvol, VideoMaterial paramVideoMaterial) {}
  
  public void run()
  {
    long l1 = System.currentTimeMillis();
    this.this$0.a(this.a.getId());
    this.this$0.a(this.this$0.a, this.this$0.b, 1.0D);
    long l2 = System.currentTimeMillis();
    ved.b("PersonalityOperator", "setVideoFilter " + this.a.getId() + " t:" + (l2 - l1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.PersonalityOperator.1
 * JD-Core Version:    0.7.0.1
 */