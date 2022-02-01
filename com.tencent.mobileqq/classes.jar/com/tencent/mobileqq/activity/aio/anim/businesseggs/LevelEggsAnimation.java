package com.tencent.mobileqq.activity.aio.anim.businesseggs;

import com.tencent.mobileqq.activity.aio.anim.AioAnimationRule;
import com.tencent.mobileqq.activity.aio.anim.AioAnimationRule.JumpImage;
import com.tencent.mobileqq.activity.aio.anim.egg.QueuedEggsAnimation;

public class LevelEggsAnimation
  extends QueuedEggsAnimation<LevelEggsElement>
{
  protected void a(LevelEggsElement paramLevelEggsElement)
  {
    paramLevelEggsElement.a(new LevelEggsAnimation.1(this));
  }
  
  protected boolean a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return super.a(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  protected LevelEggsElement b(Object... paramVarArgs)
  {
    AioAnimationRule.JumpImage localJumpImage = (AioAnimationRule.JumpImage)paramVarArgs[0];
    paramVarArgs = (AioAnimationRule)paramVarArgs[1];
    return new LevelEggsElement(this.a, this.b, paramVarArgs, localJumpImage);
  }
  
  protected void b(LevelEggsElement paramLevelEggsElement) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.businesseggs.LevelEggsAnimation
 * JD-Core Version:    0.7.0.1
 */