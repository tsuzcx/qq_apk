package androidx.appcompat.widget;

import android.content.res.Resources.Theme;
import android.widget.SpinnerAdapter;
import androidx.annotation.Nullable;

public abstract interface ThemedSpinnerAdapter
  extends SpinnerAdapter
{
  @Nullable
  public abstract Resources.Theme getDropDownViewTheme();
  
  public abstract void setDropDownViewTheme(@Nullable Resources.Theme paramTheme);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.appcompat.widget.ThemedSpinnerAdapter
 * JD-Core Version:    0.7.0.1
 */