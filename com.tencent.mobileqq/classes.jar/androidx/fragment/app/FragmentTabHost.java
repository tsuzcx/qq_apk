package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TabHost.TabSpec;
import android.widget.TabWidget;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;

@Deprecated
public class FragmentTabHost
  extends TabHost
  implements TabHost.OnTabChangeListener
{
  private boolean mAttached;
  private int mContainerId;
  private Context mContext;
  private FragmentManager mFragmentManager;
  private FragmentTabHost.TabInfo mLastTab;
  private TabHost.OnTabChangeListener mOnTabChangeListener;
  private FrameLayout mRealTabContent;
  private final ArrayList<FragmentTabHost.TabInfo> mTabs = new ArrayList();
  
  @Deprecated
  public FragmentTabHost(@NonNull Context paramContext)
  {
    super(paramContext, null);
    initFragmentTabHost(paramContext, null);
  }
  
  @Deprecated
  public FragmentTabHost(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initFragmentTabHost(paramContext, paramAttributeSet);
  }
  
  @Nullable
  private FragmentTransaction doTabChanged(@Nullable String paramString, @Nullable FragmentTransaction paramFragmentTransaction)
  {
    FragmentTabHost.TabInfo localTabInfo = getTabInfoForTag(paramString);
    paramString = paramFragmentTransaction;
    if (this.mLastTab != localTabInfo)
    {
      paramString = paramFragmentTransaction;
      if (paramFragmentTransaction == null) {
        paramString = this.mFragmentManager.beginTransaction();
      }
      if ((this.mLastTab != null) && (this.mLastTab.fragment != null)) {
        paramString.detach(this.mLastTab.fragment);
      }
      if (localTabInfo != null)
      {
        if (localTabInfo.fragment != null) {
          break label133;
        }
        localTabInfo.fragment = this.mFragmentManager.getFragmentFactory().instantiate(this.mContext.getClassLoader(), localTabInfo.clss.getName());
        localTabInfo.fragment.setArguments(localTabInfo.args);
        paramString.add(this.mContainerId, localTabInfo.fragment, localTabInfo.tag);
      }
    }
    for (;;)
    {
      this.mLastTab = localTabInfo;
      return paramString;
      label133:
      paramString.attach(localTabInfo.fragment);
    }
  }
  
  private void ensureContent()
  {
    if (this.mRealTabContent == null)
    {
      this.mRealTabContent = ((FrameLayout)findViewById(this.mContainerId));
      if (this.mRealTabContent == null) {
        throw new IllegalStateException("No tab content FrameLayout found for id " + this.mContainerId);
      }
    }
  }
  
  private void ensureHierarchy(Context paramContext)
  {
    if (findViewById(16908307) == null)
    {
      LinearLayout localLinearLayout = new LinearLayout(paramContext);
      localLinearLayout.setOrientation(1);
      addView(localLinearLayout, new FrameLayout.LayoutParams(-1, -1));
      Object localObject = new TabWidget(paramContext);
      ((TabWidget)localObject).setId(16908307);
      ((TabWidget)localObject).setOrientation(0);
      localLinearLayout.addView((View)localObject, new LinearLayout.LayoutParams(-1, -2, 0.0F));
      localObject = new FrameLayout(paramContext);
      ((FrameLayout)localObject).setId(16908305);
      localLinearLayout.addView((View)localObject, new LinearLayout.LayoutParams(0, 0, 0.0F));
      paramContext = new FrameLayout(paramContext);
      this.mRealTabContent = paramContext;
      this.mRealTabContent.setId(this.mContainerId);
      localLinearLayout.addView(paramContext, new LinearLayout.LayoutParams(-1, 0, 1.0F));
    }
  }
  
  @Nullable
  private FragmentTabHost.TabInfo getTabInfoForTag(String paramString)
  {
    int j = this.mTabs.size();
    int i = 0;
    while (i < j)
    {
      FragmentTabHost.TabInfo localTabInfo = (FragmentTabHost.TabInfo)this.mTabs.get(i);
      if (localTabInfo.tag.equals(paramString)) {
        return localTabInfo;
      }
      i += 1;
    }
    return null;
  }
  
  private void initFragmentTabHost(Context paramContext, AttributeSet paramAttributeSet)
  {
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, new int[] { 16842995 }, 0, 0);
    this.mContainerId = paramContext.getResourceId(0, 0);
    paramContext.recycle();
    super.setOnTabChangedListener(this);
  }
  
  @Deprecated
  public void addTab(@NonNull TabHost.TabSpec paramTabSpec, @NonNull Class<?> paramClass, @Nullable Bundle paramBundle)
  {
    paramTabSpec.setContent(new FragmentTabHost.DummyTabFactory(this.mContext));
    String str = paramTabSpec.getTag();
    paramClass = new FragmentTabHost.TabInfo(str, paramClass, paramBundle);
    if (this.mAttached)
    {
      paramClass.fragment = this.mFragmentManager.findFragmentByTag(str);
      if ((paramClass.fragment != null) && (!paramClass.fragment.isDetached()))
      {
        paramBundle = this.mFragmentManager.beginTransaction();
        paramBundle.detach(paramClass.fragment);
        paramBundle.commit();
      }
    }
    this.mTabs.add(paramClass);
    addTab(paramTabSpec);
  }
  
  @Deprecated
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    String str = getCurrentTabTag();
    Object localObject1 = null;
    int j = this.mTabs.size();
    int i = 0;
    if (i < j)
    {
      FragmentTabHost.TabInfo localTabInfo = (FragmentTabHost.TabInfo)this.mTabs.get(i);
      localTabInfo.fragment = this.mFragmentManager.findFragmentByTag(localTabInfo.tag);
      Object localObject2 = localObject1;
      if (localTabInfo.fragment != null)
      {
        localObject2 = localObject1;
        if (!localTabInfo.fragment.isDetached())
        {
          if (!localTabInfo.tag.equals(str)) {
            break label114;
          }
          this.mLastTab = localTabInfo;
          localObject2 = localObject1;
        }
      }
      for (;;)
      {
        i += 1;
        localObject1 = localObject2;
        break;
        label114:
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = this.mFragmentManager.beginTransaction();
        }
        ((FragmentTransaction)localObject2).detach(localTabInfo.fragment);
      }
    }
    this.mAttached = true;
    localObject1 = doTabChanged(str, (FragmentTransaction)localObject1);
    if (localObject1 != null)
    {
      ((FragmentTransaction)localObject1).commit();
      this.mFragmentManager.executePendingTransactions();
    }
  }
  
  @Deprecated
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.mAttached = false;
  }
  
  @Deprecated
  public void onRestoreInstanceState(@SuppressLint({"UnknownNullness"}) Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof FragmentTabHost.SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    paramParcelable = (FragmentTabHost.SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    setCurrentTabByTag(paramParcelable.curTab);
  }
  
  @Deprecated
  @NonNull
  public Parcelable onSaveInstanceState()
  {
    FragmentTabHost.SavedState localSavedState = new FragmentTabHost.SavedState(super.onSaveInstanceState());
    localSavedState.curTab = getCurrentTabTag();
    return localSavedState;
  }
  
  @Deprecated
  public void onTabChanged(@Nullable String paramString)
  {
    if (this.mAttached)
    {
      FragmentTransaction localFragmentTransaction = doTabChanged(paramString, null);
      if (localFragmentTransaction != null) {
        localFragmentTransaction.commit();
      }
    }
    if (this.mOnTabChangeListener != null) {
      this.mOnTabChangeListener.onTabChanged(paramString);
    }
  }
  
  @Deprecated
  public void setOnTabChangedListener(@Nullable TabHost.OnTabChangeListener paramOnTabChangeListener)
  {
    this.mOnTabChangeListener = paramOnTabChangeListener;
  }
  
  @Deprecated
  public void setup()
  {
    throw new IllegalStateException("Must call setup() that takes a Context and FragmentManager");
  }
  
  @Deprecated
  public void setup(@NonNull Context paramContext, @NonNull FragmentManager paramFragmentManager)
  {
    ensureHierarchy(paramContext);
    super.setup();
    this.mContext = paramContext;
    this.mFragmentManager = paramFragmentManager;
    ensureContent();
  }
  
  @Deprecated
  public void setup(@NonNull Context paramContext, @NonNull FragmentManager paramFragmentManager, int paramInt)
  {
    ensureHierarchy(paramContext);
    super.setup();
    this.mContext = paramContext;
    this.mFragmentManager = paramFragmentManager;
    this.mContainerId = paramInt;
    ensureContent();
    this.mRealTabContent.setId(paramInt);
    if (getId() == -1) {
      setId(16908306);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.fragment.app.FragmentTabHost
 * JD-Core Version:    0.7.0.1
 */