package androidx.appcompat.widget;

import android.content.res.Resources.Theme;
import android.database.DataSetObserver;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.SpinnerAdapter;
import androidx.annotation.Nullable;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AppCompatSpinner$DropDownAdapter
  implements ListAdapter, SpinnerAdapter
{
  private SpinnerAdapter mAdapter;
  private ListAdapter mListAdapter;
  
  public AppCompatSpinner$DropDownAdapter(@Nullable SpinnerAdapter paramSpinnerAdapter, @Nullable Resources.Theme paramTheme)
  {
    this.mAdapter = paramSpinnerAdapter;
    if ((paramSpinnerAdapter instanceof ListAdapter)) {
      this.mListAdapter = ((ListAdapter)paramSpinnerAdapter);
    }
    if (paramTheme != null) {
      if ((Build.VERSION.SDK_INT >= 23) && ((paramSpinnerAdapter instanceof android.widget.ThemedSpinnerAdapter)))
      {
        paramSpinnerAdapter = (android.widget.ThemedSpinnerAdapter)paramSpinnerAdapter;
        if (paramSpinnerAdapter.getDropDownViewTheme() != paramTheme) {
          paramSpinnerAdapter.setDropDownViewTheme(paramTheme);
        }
      }
      else if ((paramSpinnerAdapter instanceof ThemedSpinnerAdapter))
      {
        paramSpinnerAdapter = (ThemedSpinnerAdapter)paramSpinnerAdapter;
        if (paramSpinnerAdapter.getDropDownViewTheme() == null) {
          paramSpinnerAdapter.setDropDownViewTheme(paramTheme);
        }
      }
    }
  }
  
  public boolean areAllItemsEnabled()
  {
    ListAdapter localListAdapter = this.mListAdapter;
    if (localListAdapter != null) {
      return localListAdapter.areAllItemsEnabled();
    }
    return true;
  }
  
  public int getCount()
  {
    SpinnerAdapter localSpinnerAdapter = this.mAdapter;
    if (localSpinnerAdapter == null) {
      return 0;
    }
    return localSpinnerAdapter.getCount();
  }
  
  public View getDropDownView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    SpinnerAdapter localSpinnerAdapter = this.mAdapter;
    if (localSpinnerAdapter == null) {
      return null;
    }
    return localSpinnerAdapter.getDropDownView(paramInt, paramView, paramViewGroup);
  }
  
  public Object getItem(int paramInt)
  {
    SpinnerAdapter localSpinnerAdapter = this.mAdapter;
    if (localSpinnerAdapter == null) {
      return null;
    }
    return localSpinnerAdapter.getItem(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    SpinnerAdapter localSpinnerAdapter = this.mAdapter;
    if (localSpinnerAdapter == null) {
      return -1L;
    }
    return localSpinnerAdapter.getItemId(paramInt);
  }
  
  public int getItemViewType(int paramInt)
  {
    return 0;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = getDropDownView(paramInt, paramView, paramViewGroup);
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
  
  public int getViewTypeCount()
  {
    return 1;
  }
  
  public boolean hasStableIds()
  {
    SpinnerAdapter localSpinnerAdapter = this.mAdapter;
    return (localSpinnerAdapter != null) && (localSpinnerAdapter.hasStableIds());
  }
  
  public boolean isEmpty()
  {
    return getCount() == 0;
  }
  
  public boolean isEnabled(int paramInt)
  {
    ListAdapter localListAdapter = this.mListAdapter;
    if (localListAdapter != null) {
      return localListAdapter.isEnabled(paramInt);
    }
    return true;
  }
  
  public void registerDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    SpinnerAdapter localSpinnerAdapter = this.mAdapter;
    if (localSpinnerAdapter != null) {
      localSpinnerAdapter.registerDataSetObserver(paramDataSetObserver);
    }
  }
  
  public void unregisterDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    SpinnerAdapter localSpinnerAdapter = this.mAdapter;
    if (localSpinnerAdapter != null) {
      localSpinnerAdapter.unregisterDataSetObserver(paramDataSetObserver);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.appcompat.widget.AppCompatSpinner.DropDownAdapter
 * JD-Core Version:    0.7.0.1
 */