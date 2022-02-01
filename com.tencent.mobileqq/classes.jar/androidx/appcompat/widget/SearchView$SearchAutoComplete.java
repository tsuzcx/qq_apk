package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.KeyEvent.DispatcherState;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R.attr;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class SearchView$SearchAutoComplete
  extends AppCompatAutoCompleteTextView
{
  private boolean mHasPendingShowSoftInputRequest;
  final Runnable mRunShowSoftInputIfNecessary = new SearchView.SearchAutoComplete.1(this);
  private SearchView mSearchView;
  private int mThreshold = getThreshold();
  
  public SearchView$SearchAutoComplete(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SearchView$SearchAutoComplete(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.autoCompleteTextViewStyle);
  }
  
  public SearchView$SearchAutoComplete(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private int getSearchViewTextMinWidthDp()
  {
    Configuration localConfiguration = getResources().getConfiguration();
    int i = localConfiguration.screenWidthDp;
    int j = localConfiguration.screenHeightDp;
    if ((i >= 960) && (j >= 720) && (localConfiguration.orientation == 2)) {
      return 256;
    }
    if ((i < 600) && ((i < 640) || (j < 480))) {
      return 160;
    }
    return 192;
  }
  
  public boolean enoughToFilter()
  {
    return (this.mThreshold <= 0) || (super.enoughToFilter());
  }
  
  void ensureImeVisible()
  {
    if (Build.VERSION.SDK_INT >= 29)
    {
      setInputMethodMode(1);
      if (enoughToFilter()) {
        showDropDown();
      }
    }
    else
    {
      SearchView.PRE_API_29_HIDDEN_METHOD_INVOKER.ensureImeVisible(this);
    }
  }
  
  boolean isEmpty()
  {
    return TextUtils.getTrimmedLength(getText()) == 0;
  }
  
  public InputConnection onCreateInputConnection(EditorInfo paramEditorInfo)
  {
    paramEditorInfo = super.onCreateInputConnection(paramEditorInfo);
    if (this.mHasPendingShowSoftInputRequest)
    {
      removeCallbacks(this.mRunShowSoftInputIfNecessary);
      post(this.mRunShowSoftInputIfNecessary);
    }
    return paramEditorInfo;
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    setMinWidth((int)TypedValue.applyDimension(1, getSearchViewTextMinWidthDp(), localDisplayMetrics));
  }
  
  protected void onFocusChanged(boolean paramBoolean, int paramInt, Rect paramRect)
  {
    super.onFocusChanged(paramBoolean, paramInt, paramRect);
    this.mSearchView.onTextFocusChanged();
  }
  
  public boolean onKeyPreIme(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      KeyEvent.DispatcherState localDispatcherState;
      if ((paramKeyEvent.getAction() == 0) && (paramKeyEvent.getRepeatCount() == 0))
      {
        localDispatcherState = getKeyDispatcherState();
        if (localDispatcherState != null) {
          localDispatcherState.startTracking(paramKeyEvent, this);
        }
        return true;
      }
      if (paramKeyEvent.getAction() == 1)
      {
        localDispatcherState = getKeyDispatcherState();
        if (localDispatcherState != null) {
          localDispatcherState.handleUpEvent(paramKeyEvent);
        }
        if ((paramKeyEvent.isTracking()) && (!paramKeyEvent.isCanceled()))
        {
          this.mSearchView.clearFocus();
          setImeVisibility(false);
          return true;
        }
      }
    }
    return super.onKeyPreIme(paramInt, paramKeyEvent);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if ((paramBoolean) && (this.mSearchView.hasFocus()) && (getVisibility() == 0))
    {
      this.mHasPendingShowSoftInputRequest = true;
      if (SearchView.isLandscapeMode(getContext())) {
        ensureImeVisible();
      }
    }
  }
  
  public void performCompletion() {}
  
  protected void replaceText(CharSequence paramCharSequence) {}
  
  void setImeVisibility(boolean paramBoolean)
  {
    InputMethodManager localInputMethodManager = (InputMethodManager)getContext().getSystemService("input_method");
    if (!paramBoolean)
    {
      this.mHasPendingShowSoftInputRequest = false;
      removeCallbacks(this.mRunShowSoftInputIfNecessary);
      localInputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
      return;
    }
    if (localInputMethodManager.isActive(this))
    {
      this.mHasPendingShowSoftInputRequest = false;
      removeCallbacks(this.mRunShowSoftInputIfNecessary);
      localInputMethodManager.showSoftInput(this, 0);
      return;
    }
    this.mHasPendingShowSoftInputRequest = true;
  }
  
  void setSearchView(SearchView paramSearchView)
  {
    this.mSearchView = paramSearchView;
  }
  
  public void setThreshold(int paramInt)
  {
    super.setThreshold(paramInt);
    this.mThreshold = paramInt;
  }
  
  void showSoftInputIfNecessary()
  {
    if (this.mHasPendingShowSoftInputRequest)
    {
      ((InputMethodManager)getContext().getSystemService("input_method")).showSoftInput(this, 0);
      this.mHasPendingShowSoftInputRequest = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.appcompat.widget.SearchView.SearchAutoComplete
 * JD-Core Version:    0.7.0.1
 */