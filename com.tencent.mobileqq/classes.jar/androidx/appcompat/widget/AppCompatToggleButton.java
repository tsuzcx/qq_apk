package androidx.appcompat.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ToggleButton;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class AppCompatToggleButton
  extends ToggleButton
{
  private final AppCompatTextHelper mTextHelper;
  
  public AppCompatToggleButton(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AppCompatToggleButton(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 16842827);
  }
  
  public AppCompatToggleButton(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    ThemeUtils.checkAppCompatTheme(this, getContext());
    this.mTextHelper = new AppCompatTextHelper(this);
    this.mTextHelper.loadFromAttributes(paramAttributeSet, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.appcompat.widget.AppCompatToggleButton
 * JD-Core Version:    0.7.0.1
 */