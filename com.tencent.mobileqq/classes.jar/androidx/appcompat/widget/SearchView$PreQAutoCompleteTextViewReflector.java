package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.os.Build.VERSION;
import android.widget.AutoCompleteTextView;
import java.lang.reflect.Method;

class SearchView$PreQAutoCompleteTextViewReflector
{
  private Method mDoAfterTextChanged = null;
  private Method mDoBeforeTextChanged = null;
  private Method mEnsureImeVisible = null;
  
  @SuppressLint({"DiscouragedPrivateApi", "SoonBlockedPrivateApi"})
  SearchView$PreQAutoCompleteTextViewReflector()
  {
    preApi29Check();
    try
    {
      this.mDoBeforeTextChanged = AutoCompleteTextView.class.getDeclaredMethod("doBeforeTextChanged", new Class[0]);
      this.mDoBeforeTextChanged.setAccessible(true);
    }
    catch (NoSuchMethodException localNoSuchMethodException1)
    {
      try
      {
        for (;;)
        {
          this.mDoAfterTextChanged = AutoCompleteTextView.class.getDeclaredMethod("doAfterTextChanged", new Class[0]);
          this.mDoAfterTextChanged.setAccessible(true);
          try
          {
            label68:
            this.mEnsureImeVisible = AutoCompleteTextView.class.getMethod("ensureImeVisible", new Class[] { Boolean.TYPE });
            this.mEnsureImeVisible.setAccessible(true);
            return;
          }
          catch (NoSuchMethodException localNoSuchMethodException3) {}
          localNoSuchMethodException1 = localNoSuchMethodException1;
        }
      }
      catch (NoSuchMethodException localNoSuchMethodException2)
      {
        break label68;
      }
    }
  }
  
  private static void preApi29Check()
  {
    if (Build.VERSION.SDK_INT < 29) {
      return;
    }
    throw new UnsupportedClassVersionError("This function can only be used for API Level < 29.");
  }
  
  void doAfterTextChanged(AutoCompleteTextView paramAutoCompleteTextView)
  {
    preApi29Check();
    Method localMethod = this.mDoAfterTextChanged;
    if (localMethod != null) {}
    try
    {
      localMethod.invoke(paramAutoCompleteTextView, new Object[0]);
      return;
    }
    catch (Exception paramAutoCompleteTextView) {}
  }
  
  void doBeforeTextChanged(AutoCompleteTextView paramAutoCompleteTextView)
  {
    preApi29Check();
    Method localMethod = this.mDoBeforeTextChanged;
    if (localMethod != null) {}
    try
    {
      localMethod.invoke(paramAutoCompleteTextView, new Object[0]);
      return;
    }
    catch (Exception paramAutoCompleteTextView) {}
  }
  
  void ensureImeVisible(AutoCompleteTextView paramAutoCompleteTextView)
  {
    preApi29Check();
    Method localMethod = this.mEnsureImeVisible;
    if (localMethod != null) {}
    try
    {
      localMethod.invoke(paramAutoCompleteTextView, new Object[] { Boolean.valueOf(true) });
      return;
    }
    catch (Exception paramAutoCompleteTextView) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.appcompat.widget.SearchView.PreQAutoCompleteTextViewReflector
 * JD-Core Version:    0.7.0.1
 */