package androidx.core.view.accessibility;

import android.os.Bundle;

public final class AccessibilityViewCommand$MoveAtGranularityArguments
  extends AccessibilityViewCommand.CommandArguments
{
  public boolean getExtendSelection()
  {
    return this.mBundle.getBoolean("ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN");
  }
  
  public int getGranularity()
  {
    return this.mBundle.getInt("ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     androidx.core.view.accessibility.AccessibilityViewCommand.MoveAtGranularityArguments
 * JD-Core Version:    0.7.0.1
 */