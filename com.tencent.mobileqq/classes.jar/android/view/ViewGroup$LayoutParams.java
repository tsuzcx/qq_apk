package android.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.animation.LayoutAnimationController.AnimationParameters;

public class ViewGroup$LayoutParams
{
  @Deprecated
  public static final int FILL_PARENT = -1;
  public static final int MATCH_PARENT = -1;
  public static final int WRAP_CONTENT = -2;
  @ViewDebug.ExportedProperty(category="layout", mapping={@ViewDebug.IntToString(from=-1, to="MATCH_PARENT"), @ViewDebug.IntToString(from=-2, to="WRAP_CONTENT")})
  public int height;
  public LayoutAnimationController.AnimationParameters layoutAnimationParameters;
  @ViewDebug.ExportedProperty(category="layout", mapping={@ViewDebug.IntToString(from=-1, to="MATCH_PARENT"), @ViewDebug.IntToString(from=-2, to="WRAP_CONTENT")})
  public int width;
  
  public ViewGroup$LayoutParams(int paramInt1, int paramInt2)
  {
    throw new RuntimeException("Stub!");
  }
  
  public ViewGroup$LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
  {
    throw new RuntimeException("Stub!");
  }
  
  public ViewGroup$LayoutParams(LayoutParams paramLayoutParams)
  {
    throw new RuntimeException("Stub!");
  }
  
  protected void setBaseAttributes(TypedArray paramTypedArray, int paramInt1, int paramInt2)
  {
    throw new RuntimeException("Stub!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     android.view.ViewGroup.LayoutParams
 * JD-Core Version:    0.7.0.1
 */