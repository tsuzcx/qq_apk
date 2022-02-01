package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources.Theme;
import android.view.LayoutInflater;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.view.ContextThemeWrapper;

public final class ThemedSpinnerAdapter$Helper
{
  private final Context mContext;
  private LayoutInflater mDropDownInflater;
  private final LayoutInflater mInflater;
  
  public ThemedSpinnerAdapter$Helper(@NonNull Context paramContext)
  {
    this.mContext = paramContext;
    this.mInflater = LayoutInflater.from(paramContext);
  }
  
  @NonNull
  public LayoutInflater getDropDownViewInflater()
  {
    LayoutInflater localLayoutInflater = this.mDropDownInflater;
    if (localLayoutInflater != null) {
      return localLayoutInflater;
    }
    return this.mInflater;
  }
  
  @Nullable
  public Resources.Theme getDropDownViewTheme()
  {
    LayoutInflater localLayoutInflater = this.mDropDownInflater;
    if (localLayoutInflater == null) {
      return null;
    }
    return localLayoutInflater.getContext().getTheme();
  }
  
  public void setDropDownViewTheme(@Nullable Resources.Theme paramTheme)
  {
    if (paramTheme == null)
    {
      this.mDropDownInflater = null;
      return;
    }
    if (paramTheme == this.mContext.getTheme())
    {
      this.mDropDownInflater = this.mInflater;
      return;
    }
    this.mDropDownInflater = LayoutInflater.from(new ContextThemeWrapper(this.mContext, paramTheme));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.appcompat.widget.ThemedSpinnerAdapter.Helper
 * JD-Core Version:    0.7.0.1
 */