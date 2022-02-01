package com.google.android.material.textview;

import android.content.Context;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleableRes;
import androidx.appcompat.widget.AppCompatTextView;
import com.google.android.material.R.attr;
import com.google.android.material.R.styleable;
import com.google.android.material.resources.MaterialAttributes;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;

public class MaterialTextView
  extends AppCompatTextView
{
  public MaterialTextView(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public MaterialTextView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 16842884);
  }
  
  public MaterialTextView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, 0);
  }
  
  public MaterialTextView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(MaterialThemeOverlay.a(paramContext, paramAttributeSet, paramInt1, paramInt2), paramAttributeSet, paramInt1);
    paramContext = getContext();
    if (a(paramContext))
    {
      Resources.Theme localTheme = paramContext.getTheme();
      if (!a(paramContext, localTheme, paramAttributeSet, paramInt1, paramInt2))
      {
        paramInt1 = a(localTheme, paramAttributeSet, paramInt1, paramInt2);
        if (paramInt1 != -1) {
          a(localTheme, paramInt1);
        }
      }
    }
  }
  
  private static int a(@NonNull Context paramContext, @NonNull TypedArray paramTypedArray, @NonNull @StyleableRes int... paramVarArgs)
  {
    int i = 0;
    int j = -1;
    while ((i < paramVarArgs.length) && (j < 0))
    {
      j = MaterialResources.a(paramContext, paramTypedArray, paramVarArgs[i], -1);
      i += 1;
    }
    return j;
  }
  
  private static int a(@NonNull Resources.Theme paramTheme, @Nullable AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    paramTheme = paramTheme.obtainStyledAttributes(paramAttributeSet, R.styleable.eS, paramInt1, paramInt2);
    paramInt1 = paramTheme.getResourceId(R.styleable.eT, -1);
    paramTheme.recycle();
    return paramInt1;
  }
  
  private void a(@NonNull Resources.Theme paramTheme, int paramInt)
  {
    paramTheme = paramTheme.obtainStyledAttributes(paramInt, R.styleable.eO);
    paramInt = a(getContext(), paramTheme, new int[] { R.styleable.eQ, R.styleable.eR });
    paramTheme.recycle();
    if (paramInt >= 0) {
      setLineHeight(paramInt);
    }
  }
  
  private static boolean a(Context paramContext)
  {
    return MaterialAttributes.a(paramContext, R.attr.aa, true);
  }
  
  private static boolean a(@NonNull Context paramContext, @NonNull Resources.Theme paramTheme, @Nullable AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    paramTheme = paramTheme.obtainStyledAttributes(paramAttributeSet, R.styleable.eS, paramInt1, paramInt2);
    paramInt1 = R.styleable.eU;
    boolean bool = false;
    paramInt1 = a(paramContext, paramTheme, new int[] { paramInt1, R.styleable.eV });
    paramTheme.recycle();
    if (paramInt1 != -1) {
      bool = true;
    }
    return bool;
  }
  
  public void setTextAppearance(@NonNull Context paramContext, int paramInt)
  {
    super.setTextAppearance(paramContext, paramInt);
    if (a(paramContext)) {
      a(paramContext.getTheme(), paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.textview.MaterialTextView
 * JD-Core Version:    0.7.0.1
 */