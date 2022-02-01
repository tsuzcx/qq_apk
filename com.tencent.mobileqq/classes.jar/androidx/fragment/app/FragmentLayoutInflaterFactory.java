package androidx.fragment.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater.Factory2;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.R.styleable;

class FragmentLayoutInflaterFactory
  implements LayoutInflater.Factory2
{
  private static final String TAG = "FragmentManager";
  private final FragmentManager mFragmentManager;
  
  FragmentLayoutInflaterFactory(FragmentManager paramFragmentManager)
  {
    this.mFragmentManager = paramFragmentManager;
  }
  
  @Nullable
  public View onCreateView(@Nullable View paramView, @NonNull String paramString, @NonNull Context paramContext, @NonNull AttributeSet paramAttributeSet)
  {
    Object localObject = null;
    if (FragmentContainerView.class.getName().equals(paramString)) {
      return new FragmentContainerView(paramContext, paramAttributeSet, this.mFragmentManager);
    }
    if (!"fragment".equals(paramString)) {
      return null;
    }
    paramString = paramAttributeSet.getAttributeValue(null, "class");
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.d);
    String str1 = paramString;
    if (paramString == null) {
      str1 = localTypedArray.getString(R.styleable.a);
    }
    int k = localTypedArray.getResourceId(R.styleable.b, -1);
    String str2 = localTypedArray.getString(R.styleable.c);
    localTypedArray.recycle();
    if ((str1 == null) || (!FragmentFactory.isFragmentClass(paramContext.getClassLoader(), str1))) {
      return null;
    }
    if (paramView != null) {}
    for (int i = paramView.getId(); (i == -1) && (k == -1) && (str2 == null); i = 0) {
      throw new IllegalArgumentException(paramAttributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + str1);
    }
    paramString = localObject;
    if (k != -1) {
      paramString = this.mFragmentManager.findFragmentById(k);
    }
    paramView = paramString;
    if (paramString == null)
    {
      paramView = paramString;
      if (str2 != null) {
        paramView = this.mFragmentManager.findFragmentByTag(str2);
      }
    }
    paramString = paramView;
    if (paramView == null)
    {
      paramString = paramView;
      if (i != -1) {
        paramString = this.mFragmentManager.findFragmentById(i);
      }
    }
    if (FragmentManager.isLoggingEnabled(2)) {
      Log.v("FragmentManager", "onCreateView: id=0x" + Integer.toHexString(k) + " fname=" + str1 + " existing=" + paramString);
    }
    int j;
    if (paramString == null)
    {
      paramView = this.mFragmentManager.getFragmentFactory().instantiate(paramContext.getClassLoader(), str1);
      paramView.mFromLayout = true;
      if (k != 0)
      {
        j = k;
        paramView.mFragmentId = j;
        paramView.mContainerId = i;
        paramView.mTag = str2;
        paramView.mInLayout = true;
        paramView.mFragmentManager = this.mFragmentManager;
        paramView.mHost = this.mFragmentManager.mHost;
        paramView.onInflate(this.mFragmentManager.mHost.getContext(), paramAttributeSet, paramView.mSavedFragmentState);
        this.mFragmentManager.addFragment(paramView);
        this.mFragmentManager.moveToState(paramView);
        label430:
        if ((this.mFragmentManager.mCurState >= 1) || (!paramView.mFromLayout)) {
          break label626;
        }
        this.mFragmentManager.moveToState(paramView, 1);
      }
    }
    for (;;)
    {
      if (paramView.mView != null) {
        break label637;
      }
      throw new IllegalStateException("Fragment " + str1 + " did not create a view.");
      j = i;
      break;
      if (paramString.mInLayout) {
        throw new IllegalArgumentException(paramAttributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(k) + ", tag " + str2 + ", or parent id 0x" + Integer.toHexString(i) + " with another fragment for " + str1);
      }
      paramString.mInLayout = true;
      paramString.mHost = this.mFragmentManager.mHost;
      paramString.onInflate(this.mFragmentManager.mHost.getContext(), paramAttributeSet, paramString.mSavedFragmentState);
      paramView = paramString;
      break label430;
      label626:
      this.mFragmentManager.moveToState(paramView);
    }
    label637:
    if (k != 0) {
      paramView.mView.setId(k);
    }
    if (paramView.mView.getTag() == null) {
      paramView.mView.setTag(str2);
    }
    return paramView.mView;
  }
  
  @Nullable
  public View onCreateView(@NonNull String paramString, @NonNull Context paramContext, @NonNull AttributeSet paramAttributeSet)
  {
    return onCreateView(null, paramString, paramContext, paramAttributeSet);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.fragment.app.FragmentLayoutInflaterFactory
 * JD-Core Version:    0.7.0.1
 */