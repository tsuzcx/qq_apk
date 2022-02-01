package androidx.core.view.accessibility;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public abstract interface AccessibilityViewCommand
{
  public abstract boolean perform(@NonNull View paramView, @Nullable AccessibilityViewCommand.CommandArguments paramCommandArguments);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.core.view.accessibility.AccessibilityViewCommand
 * JD-Core Version:    0.7.0.1
 */