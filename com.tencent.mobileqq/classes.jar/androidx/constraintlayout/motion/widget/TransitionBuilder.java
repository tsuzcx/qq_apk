package androidx.constraintlayout.motion.widget;

import androidx.constraintlayout.widget.ConstraintSet;
import java.util.ArrayList;

public class TransitionBuilder
{
  private static final String TAG = "TransitionBuilder";
  
  public static MotionScene.Transition buildTransition(MotionScene paramMotionScene, int paramInt1, int paramInt2, ConstraintSet paramConstraintSet1, int paramInt3, ConstraintSet paramConstraintSet2)
  {
    MotionScene.Transition localTransition = new MotionScene.Transition(paramInt1, paramMotionScene, paramInt2, paramInt3);
    updateConstraintSetInMotionScene(paramMotionScene, localTransition, paramConstraintSet1, paramConstraintSet2);
    return localTransition;
  }
  
  private static void updateConstraintSetInMotionScene(MotionScene paramMotionScene, MotionScene.Transition paramTransition, ConstraintSet paramConstraintSet1, ConstraintSet paramConstraintSet2)
  {
    int i = paramTransition.getStartConstraintSetId();
    int j = paramTransition.getEndConstraintSetId();
    paramMotionScene.setConstraintSet(i, paramConstraintSet1);
    paramMotionScene.setConstraintSet(j, paramConstraintSet2);
  }
  
  public static void validate(MotionLayout paramMotionLayout)
  {
    if (paramMotionLayout.mScene != null)
    {
      MotionScene localMotionScene = paramMotionLayout.mScene;
      if (localMotionScene.validateLayout(paramMotionLayout))
      {
        if ((localMotionScene.mCurrentTransition != null) && (!localMotionScene.getDefinedTransitions().isEmpty())) {
          return;
        }
        throw new RuntimeException("Invalid motion layout. Motion Scene doesn't have any transition.");
      }
      throw new RuntimeException("MotionLayout doesn't have the right motion scene.");
    }
    throw new RuntimeException("Invalid motion layout. Layout missing Motion Scene.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.constraintlayout.motion.widget.TransitionBuilder
 * JD-Core Version:    0.7.0.1
 */