package androidx.appcompat.widget;

import android.widget.AutoCompleteTextView;
import java.lang.reflect.Method;

class SearchView$AutoCompleteTextViewReflector
{
  private Method doAfterTextChanged;
  private Method doBeforeTextChanged;
  private Method ensureImeVisible;
  
  SearchView$AutoCompleteTextViewReflector()
  {
    try
    {
      this.doBeforeTextChanged = AutoCompleteTextView.class.getDeclaredMethod("doBeforeTextChanged", new Class[0]);
      this.doBeforeTextChanged.setAccessible(true);
    }
    catch (NoSuchMethodException localNoSuchMethodException1)
    {
      try
      {
        for (;;)
        {
          this.doAfterTextChanged = AutoCompleteTextView.class.getDeclaredMethod("doAfterTextChanged", new Class[0]);
          this.doAfterTextChanged.setAccessible(true);
          try
          {
            label50:
            this.ensureImeVisible = AutoCompleteTextView.class.getMethod("ensureImeVisible", new Class[] { Boolean.TYPE });
            this.ensureImeVisible.setAccessible(true);
            return;
          }
          catch (NoSuchMethodException localNoSuchMethodException3) {}
          localNoSuchMethodException1 = localNoSuchMethodException1;
        }
      }
      catch (NoSuchMethodException localNoSuchMethodException2)
      {
        break label50;
      }
    }
  }
  
  void doAfterTextChanged(AutoCompleteTextView paramAutoCompleteTextView)
  {
    Method localMethod = this.doAfterTextChanged;
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
    Method localMethod = this.doBeforeTextChanged;
    if (localMethod != null) {}
    try
    {
      localMethod.invoke(paramAutoCompleteTextView, new Object[0]);
      return;
    }
    catch (Exception paramAutoCompleteTextView) {}
  }
  
  void ensureImeVisible(AutoCompleteTextView paramAutoCompleteTextView, boolean paramBoolean)
  {
    Method localMethod = this.ensureImeVisible;
    if (localMethod != null) {}
    try
    {
      localMethod.invoke(paramAutoCompleteTextView, new Object[] { Boolean.valueOf(paramBoolean) });
      return;
    }
    catch (Exception paramAutoCompleteTextView) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.appcompat.widget.SearchView.AutoCompleteTextViewReflector
 * JD-Core Version:    0.7.0.1
 */