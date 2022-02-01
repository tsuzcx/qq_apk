package androidx.constraintlayout.motion.widget;

import android.os.Bundle;

class MotionLayout$StateCache
{
  final String KeyEndState = "motion.EndState";
  final String KeyProgress = "motion.progress";
  final String KeyStartState = "motion.StartState";
  final String KeyVelocity = "motion.velocity";
  int endState = -1;
  float mProgress = (0.0F / 0.0F);
  float mVelocity = (0.0F / 0.0F);
  int startState = -1;
  
  MotionLayout$StateCache(MotionLayout paramMotionLayout) {}
  
  void apply()
  {
    if ((this.startState != -1) || (this.endState != -1))
    {
      int i = this.startState;
      if (i == -1)
      {
        this.this$0.transitionToState(this.endState);
      }
      else
      {
        int j = this.endState;
        if (j == -1) {
          this.this$0.setState(i, -1, -1);
        } else {
          this.this$0.setTransition(i, j);
        }
      }
      this.this$0.setState(MotionLayout.TransitionState.SETUP);
    }
    if (Float.isNaN(this.mVelocity))
    {
      if (Float.isNaN(this.mProgress)) {
        return;
      }
      this.this$0.setProgress(this.mProgress);
      return;
    }
    this.this$0.setProgress(this.mProgress, this.mVelocity);
    this.mProgress = (0.0F / 0.0F);
    this.mVelocity = (0.0F / 0.0F);
    this.startState = -1;
    this.endState = -1;
  }
  
  public Bundle getTransitionState()
  {
    Bundle localBundle = new Bundle();
    localBundle.putFloat("motion.progress", this.mProgress);
    localBundle.putFloat("motion.velocity", this.mVelocity);
    localBundle.putInt("motion.StartState", this.startState);
    localBundle.putInt("motion.EndState", this.endState);
    return localBundle;
  }
  
  public void recordState()
  {
    this.endState = MotionLayout.access$000(this.this$0);
    this.startState = MotionLayout.access$100(this.this$0);
    this.mVelocity = this.this$0.getVelocity();
    this.mProgress = this.this$0.getProgress();
  }
  
  public void setEndState(int paramInt)
  {
    this.endState = paramInt;
  }
  
  public void setProgress(float paramFloat)
  {
    this.mProgress = paramFloat;
  }
  
  public void setStartState(int paramInt)
  {
    this.startState = paramInt;
  }
  
  public void setTransitionState(Bundle paramBundle)
  {
    this.mProgress = paramBundle.getFloat("motion.progress");
    this.mVelocity = paramBundle.getFloat("motion.velocity");
    this.startState = paramBundle.getInt("motion.StartState");
    this.endState = paramBundle.getInt("motion.EndState");
  }
  
  public void setVelocity(float paramFloat)
  {
    this.mVelocity = paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     androidx.constraintlayout.motion.widget.MotionLayout.StateCache
 * JD-Core Version:    0.7.0.1
 */