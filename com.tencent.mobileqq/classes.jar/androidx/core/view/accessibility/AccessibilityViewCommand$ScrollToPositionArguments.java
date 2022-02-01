package androidx.core.view.accessibility;

import android.os.Bundle;

public final class AccessibilityViewCommand$ScrollToPositionArguments
  extends AccessibilityViewCommand.CommandArguments
{
  public int getColumn()
  {
    return this.mBundle.getInt("android.view.accessibility.action.ARGUMENT_COLUMN_INT");
  }
  
  public int getRow()
  {
    return this.mBundle.getInt("android.view.accessibility.action.ARGUMENT_ROW_INT");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.core.view.accessibility.AccessibilityViewCommand.ScrollToPositionArguments
 * JD-Core Version:    0.7.0.1
 */