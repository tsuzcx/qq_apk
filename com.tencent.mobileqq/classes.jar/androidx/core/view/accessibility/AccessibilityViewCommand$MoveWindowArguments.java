package androidx.core.view.accessibility;

import android.os.Bundle;

public final class AccessibilityViewCommand$MoveWindowArguments
  extends AccessibilityViewCommand.CommandArguments
{
  public int getX()
  {
    return this.mBundle.getInt("ACTION_ARGUMENT_MOVE_WINDOW_X");
  }
  
  public int getY()
  {
    return this.mBundle.getInt("ACTION_ARGUMENT_MOVE_WINDOW_Y");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.core.view.accessibility.AccessibilityViewCommand.MoveWindowArguments
 * JD-Core Version:    0.7.0.1
 */