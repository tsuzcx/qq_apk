package androidx.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater.Factory2;
import android.view.View;
import androidx.annotation.NonNull;

class LayoutInflaterCompat$Factory2Wrapper
  implements LayoutInflater.Factory2
{
  final LayoutInflaterFactory mDelegateFactory;
  
  LayoutInflaterCompat$Factory2Wrapper(LayoutInflaterFactory paramLayoutInflaterFactory)
  {
    this.mDelegateFactory = paramLayoutInflaterFactory;
  }
  
  public View onCreateView(View paramView, String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    return this.mDelegateFactory.onCreateView(paramView, paramString, paramContext, paramAttributeSet);
  }
  
  public View onCreateView(String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    return this.mDelegateFactory.onCreateView(null, paramString, paramContext, paramAttributeSet);
  }
  
  @NonNull
  public String toString()
  {
    return getClass().getName() + "{" + this.mDelegateFactory + "}";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.core.view.LayoutInflaterCompat.Factory2Wrapper
 * JD-Core Version:    0.7.0.1
 */