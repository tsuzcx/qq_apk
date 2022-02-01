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
    if (FragmentContainerView.class.getName().equals(paramString)) {
      return new FragmentContainerView(paramContext, paramAttributeSet, this.mFragmentManager);
    }
    boolean bool = "fragment".equals(paramString);
    paramString = null;
    if (!bool) {
      return null;
    }
    String str2 = paramAttributeSet.getAttributeValue(null, "class");
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.Fragment);
    String str1 = str2;
    if (str2 == null) {
      str1 = localTypedArray.getString(R.styleable.Fragment_android_name);
    }
    int k = localTypedArray.getResourceId(R.styleable.Fragment_android_id, -1);
    str2 = localTypedArray.getString(R.styleable.Fragment_android_tag);
    localTypedArray.recycle();
    if (str1 != null)
    {
      if (!FragmentFactory.isFragmentClass(paramContext.getClassLoader(), str1)) {
        return null;
      }
      int i;
      if (paramView != null) {
        i = paramView.getId();
      } else {
        i = 0;
      }
      if ((i == -1) && (k == -1) && (str2 == null))
      {
        paramView = new StringBuilder();
        paramView.append(paramAttributeSet.getPositionDescription());
        paramView.append(": Must specify unique android:id, android:tag, or have a parent with an id for ");
        paramView.append(str1);
        throw new IllegalArgumentException(paramView.toString());
      }
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
      if (FragmentManager.isLoggingEnabled(2))
      {
        paramView = new StringBuilder();
        paramView.append("onCreateView: id=0x");
        paramView.append(Integer.toHexString(k));
        paramView.append(" fname=");
        paramView.append(str1);
        paramView.append(" existing=");
        paramView.append(paramString);
        Log.v("FragmentManager", paramView.toString());
      }
      if (paramString == null)
      {
        paramString = this.mFragmentManager.getFragmentFactory().instantiate(paramContext.getClassLoader(), str1);
        paramString.mFromLayout = true;
        int j;
        if (k != 0) {
          j = k;
        } else {
          j = i;
        }
        paramString.mFragmentId = j;
        paramString.mContainerId = i;
        paramString.mTag = str2;
        paramString.mInLayout = true;
        paramView = this.mFragmentManager;
        paramString.mFragmentManager = paramView;
        paramString.mHost = paramView.mHost;
        paramString.onInflate(this.mFragmentManager.mHost.getContext(), paramAttributeSet, paramString.mSavedFragmentState);
        this.mFragmentManager.addFragment(paramString);
        this.mFragmentManager.moveToState(paramString);
      }
      else
      {
        if (paramString.mInLayout) {
          break label634;
        }
        paramString.mInLayout = true;
        paramString.mHost = this.mFragmentManager.mHost;
        paramString.onInflate(this.mFragmentManager.mHost.getContext(), paramAttributeSet, paramString.mSavedFragmentState);
      }
      if ((this.mFragmentManager.mCurState < 1) && (paramString.mFromLayout)) {
        this.mFragmentManager.moveToState(paramString, 1);
      } else {
        this.mFragmentManager.moveToState(paramString);
      }
      if (paramString.mView != null)
      {
        if (k != 0) {
          paramString.mView.setId(k);
        }
        if (paramString.mView.getTag() == null) {
          paramString.mView.setTag(str2);
        }
        return paramString.mView;
      }
      paramView = new StringBuilder();
      paramView.append("Fragment ");
      paramView.append(str1);
      paramView.append(" did not create a view.");
      throw new IllegalStateException(paramView.toString());
      label634:
      paramView = new StringBuilder();
      paramView.append(paramAttributeSet.getPositionDescription());
      paramView.append(": Duplicate id 0x");
      paramView.append(Integer.toHexString(k));
      paramView.append(", tag ");
      paramView.append(str2);
      paramView.append(", or parent id 0x");
      paramView.append(Integer.toHexString(i));
      paramView.append(" with another fragment for ");
      paramView.append(str1);
      throw new IllegalArgumentException(paramView.toString());
    }
    return null;
  }
  
  @Nullable
  public View onCreateView(@NonNull String paramString, @NonNull Context paramContext, @NonNull AttributeSet paramAttributeSet)
  {
    return onCreateView(null, paramString, paramContext, paramAttributeSet);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.fragment.app.FragmentLayoutInflaterFactory
 * JD-Core Version:    0.7.0.1
 */