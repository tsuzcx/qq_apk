package androidx.fragment.app;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXFragment;

public class ListFragment
  extends ReportAndroidXFragment
{
  static final int INTERNAL_EMPTY_ID = 16711681;
  static final int INTERNAL_LIST_CONTAINER_ID = 16711683;
  static final int INTERNAL_PROGRESS_CONTAINER_ID = 16711682;
  ListAdapter mAdapter;
  CharSequence mEmptyText;
  View mEmptyView;
  private final Handler mHandler = new Handler();
  ListView mList;
  View mListContainer;
  boolean mListShown;
  private final AdapterView.OnItemClickListener mOnClickListener = new ListFragment.2(this);
  View mProgressContainer;
  private final Runnable mRequestFocus = new ListFragment.1(this);
  TextView mStandardEmptyView;
  
  private void ensureList()
  {
    if (this.mList != null) {
      return;
    }
    Object localObject = getView();
    if (localObject != null)
    {
      if ((localObject instanceof ListView))
      {
        this.mList = ((ListView)localObject);
      }
      else
      {
        this.mStandardEmptyView = ((TextView)((View)localObject).findViewById(16711681));
        TextView localTextView = this.mStandardEmptyView;
        if (localTextView == null) {
          this.mEmptyView = ((View)localObject).findViewById(16908292);
        } else {
          localTextView.setVisibility(8);
        }
        this.mProgressContainer = ((View)localObject).findViewById(16711682);
        this.mListContainer = ((View)localObject).findViewById(16711683);
        localObject = ((View)localObject).findViewById(16908298);
        if (!(localObject instanceof ListView))
        {
          if (localObject == null) {
            throw new RuntimeException("Your content must have a ListView whose id attribute is 'android.R.id.list'");
          }
          throw new RuntimeException("Content has view with id attribute 'android.R.id.list' that is not a ListView class");
        }
        this.mList = ((ListView)localObject);
        localObject = this.mEmptyView;
        if (localObject != null)
        {
          this.mList.setEmptyView((View)localObject);
        }
        else
        {
          localObject = this.mEmptyText;
          if (localObject != null)
          {
            this.mStandardEmptyView.setText((CharSequence)localObject);
            this.mList.setEmptyView(this.mStandardEmptyView);
          }
        }
      }
      this.mListShown = true;
      this.mList.setOnItemClickListener(this.mOnClickListener);
      localObject = this.mAdapter;
      if (localObject != null)
      {
        this.mAdapter = null;
        setListAdapter((ListAdapter)localObject);
      }
      else if (this.mProgressContainer != null)
      {
        setListShown(false, false);
      }
      this.mHandler.post(this.mRequestFocus);
      return;
    }
    throw new IllegalStateException("Content view not yet created");
  }
  
  private void setListShown(boolean paramBoolean1, boolean paramBoolean2)
  {
    ensureList();
    View localView = this.mProgressContainer;
    if (localView != null)
    {
      if (this.mListShown == paramBoolean1) {
        return;
      }
      this.mListShown = paramBoolean1;
      if (paramBoolean1)
      {
        if (paramBoolean2)
        {
          localView.startAnimation(AnimationUtils.loadAnimation(getContext(), 17432577));
          this.mListContainer.startAnimation(AnimationUtils.loadAnimation(getContext(), 17432576));
        }
        else
        {
          localView.clearAnimation();
          this.mListContainer.clearAnimation();
        }
        this.mProgressContainer.setVisibility(8);
        this.mListContainer.setVisibility(0);
        return;
      }
      if (paramBoolean2)
      {
        localView.startAnimation(AnimationUtils.loadAnimation(getContext(), 17432576));
        this.mListContainer.startAnimation(AnimationUtils.loadAnimation(getContext(), 17432577));
      }
      else
      {
        localView.clearAnimation();
        this.mListContainer.clearAnimation();
      }
      this.mProgressContainer.setVisibility(0);
      this.mListContainer.setVisibility(8);
      return;
    }
    throw new IllegalStateException("Can't be used with a custom content view");
  }
  
  @Nullable
  public ListAdapter getListAdapter()
  {
    return this.mAdapter;
  }
  
  @NonNull
  public ListView getListView()
  {
    ensureList();
    return this.mList;
  }
  
  public long getSelectedItemId()
  {
    ensureList();
    return this.mList.getSelectedItemId();
  }
  
  public int getSelectedItemPosition()
  {
    ensureList();
    return this.mList.getSelectedItemPosition();
  }
  
  @Nullable
  public View onCreateView(@NonNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    paramViewGroup = requireContext();
    paramLayoutInflater = new FrameLayout(paramViewGroup);
    paramBundle = new LinearLayout(paramViewGroup);
    paramBundle.setId(16711682);
    paramBundle.setOrientation(1);
    paramBundle.setVisibility(8);
    paramBundle.setGravity(17);
    paramBundle.addView(new ProgressBar(paramViewGroup, null, 16842874), new FrameLayout.LayoutParams(-2, -2));
    paramLayoutInflater.addView(paramBundle, new FrameLayout.LayoutParams(-1, -1));
    paramBundle = new FrameLayout(paramViewGroup);
    paramBundle.setId(16711683);
    TextView localTextView = new TextView(paramViewGroup);
    localTextView.setId(16711681);
    localTextView.setGravity(17);
    paramBundle.addView(localTextView, new FrameLayout.LayoutParams(-1, -1));
    paramViewGroup = new ListView(paramViewGroup);
    paramViewGroup.setId(16908298);
    paramViewGroup.setDrawSelectorOnTop(false);
    paramBundle.addView(paramViewGroup, new FrameLayout.LayoutParams(-1, -1));
    paramLayoutInflater.addView(paramBundle, new FrameLayout.LayoutParams(-1, -1));
    paramLayoutInflater.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroyView()
  {
    this.mHandler.removeCallbacks(this.mRequestFocus);
    this.mList = null;
    this.mListShown = false;
    this.mListContainer = null;
    this.mProgressContainer = null;
    this.mEmptyView = null;
    this.mStandardEmptyView = null;
    super.onDestroyView();
  }
  
  public void onListItemClick(@NonNull ListView paramListView, @NonNull View paramView, int paramInt, long paramLong) {}
  
  public void onViewCreated(@NonNull View paramView, @Nullable Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    ensureList();
  }
  
  @NonNull
  public final ListAdapter requireListAdapter()
  {
    Object localObject = getListAdapter();
    if (localObject != null) {
      return localObject;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("ListFragment ");
    ((StringBuilder)localObject).append(this);
    ((StringBuilder)localObject).append(" does not have a ListAdapter.");
    throw new IllegalStateException(((StringBuilder)localObject).toString());
  }
  
  public void setEmptyText(@Nullable CharSequence paramCharSequence)
  {
    ensureList();
    TextView localTextView = this.mStandardEmptyView;
    if (localTextView != null)
    {
      localTextView.setText(paramCharSequence);
      if (this.mEmptyText == null) {
        this.mList.setEmptyView(this.mStandardEmptyView);
      }
      this.mEmptyText = paramCharSequence;
      return;
    }
    throw new IllegalStateException("Can't be used with a custom content view");
  }
  
  public void setListAdapter(@Nullable ListAdapter paramListAdapter)
  {
    Object localObject = this.mAdapter;
    boolean bool = false;
    int i;
    if (localObject != null) {
      i = 1;
    } else {
      i = 0;
    }
    this.mAdapter = paramListAdapter;
    localObject = this.mList;
    if (localObject != null)
    {
      ((ListView)localObject).setAdapter(paramListAdapter);
      if ((!this.mListShown) && (i == 0))
      {
        if (requireView().getWindowToken() != null) {
          bool = true;
        }
        setListShown(true, bool);
      }
    }
  }
  
  public void setListShown(boolean paramBoolean)
  {
    setListShown(paramBoolean, true);
  }
  
  public void setListShownNoAnimation(boolean paramBoolean)
  {
    setListShown(paramBoolean, false);
  }
  
  public void setSelection(int paramInt)
  {
    ensureList();
    this.mList.setSelection(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.fragment.app.ListFragment
 * JD-Core Version:    0.7.0.1
 */