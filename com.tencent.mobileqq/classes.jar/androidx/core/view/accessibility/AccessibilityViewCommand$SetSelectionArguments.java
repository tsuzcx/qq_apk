package androidx.core.view.accessibility;

import android.os.Bundle;

public final class AccessibilityViewCommand$SetSelectionArguments
  extends AccessibilityViewCommand.CommandArguments
{
  public int getEnd()
  {
    return this.mBundle.getInt("ACTION_ARGUMENT_SELECTION_END_INT");
  }
  
  public int getStart()
  {
    return this.mBundle.getInt("ACTION_ARGUMENT_SELECTION_START_INT");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.core.view.accessibility.AccessibilityViewCommand.SetSelectionArguments
 * JD-Core Version:    0.7.0.1
 */