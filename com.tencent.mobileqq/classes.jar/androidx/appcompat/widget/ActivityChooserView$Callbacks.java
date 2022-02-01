package androidx.appcompat.widget;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.PopupWindow.OnDismissListener;
import androidx.core.view.ActionProvider;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ActivityChooserView$Callbacks
  implements View.OnClickListener, View.OnLongClickListener, AdapterView.OnItemClickListener, PopupWindow.OnDismissListener
{
  ActivityChooserView$Callbacks(ActivityChooserView paramActivityChooserView) {}
  
  private void notifyOnDismissListener()
  {
    if (this.this$0.mOnDismissListener != null) {
      this.this$0.mOnDismissListener.onDismiss();
    }
  }
  
  public void onClick(View paramView)
  {
    Object localObject;
    if (paramView == this.this$0.mDefaultActivityButton)
    {
      this.this$0.dismissPopup();
      localObject = this.this$0.mAdapter.getDefaultActivity();
      int i = this.this$0.mAdapter.getDataModel().getActivityIndex((ResolveInfo)localObject);
      localObject = this.this$0.mAdapter.getDataModel().chooseActivity(i);
      if (localObject != null)
      {
        ((Intent)localObject).addFlags(524288);
        this.this$0.getContext().startActivity((Intent)localObject);
      }
    }
    else
    {
      if (paramView != this.this$0.mExpandActivityOverflowButton) {
        break label122;
      }
      localObject = this.this$0;
      ((ActivityChooserView)localObject).mIsSelectingDefaultActivity = false;
      ((ActivityChooserView)localObject).showPopupUnchecked(((ActivityChooserView)localObject).mInitialActivityCount);
    }
    EventCollector.getInstance().onViewClicked(paramView);
    return;
    label122:
    throw new IllegalArgumentException();
  }
  
  public void onDismiss()
  {
    notifyOnDismissListener();
    if (this.this$0.mProvider != null) {
      this.this$0.mProvider.subUiVisibilityChanged(false);
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    int i = ((ActivityChooserView.ActivityChooserViewAdapter)paramAdapterView.getAdapter()).getItemViewType(paramInt);
    if (i != 0)
    {
      if (i == 1)
      {
        this.this$0.showPopupUnchecked(2147483647);
        i = paramInt;
      }
      else
      {
        throw new IllegalArgumentException();
      }
    }
    else
    {
      this.this$0.dismissPopup();
      if (!this.this$0.mIsSelectingDefaultActivity) {
        break label92;
      }
      i = paramInt;
      if (paramInt > 0)
      {
        this.this$0.mAdapter.getDataModel().setDefaultActivity(paramInt);
        i = paramInt;
      }
    }
    for (;;)
    {
      break;
      label92:
      if (!this.this$0.mAdapter.getShowDefaultActivity()) {
        paramInt += 1;
      }
      Intent localIntent = this.this$0.mAdapter.getDataModel().chooseActivity(paramInt);
      i = paramInt;
      if (localIntent != null)
      {
        localIntent.addFlags(524288);
        this.this$0.getContext().startActivity(localIntent);
        i = paramInt;
      }
    }
    EventCollector.getInstance().onItemClick(paramAdapterView, paramView, i, paramLong);
  }
  
  public boolean onLongClick(View paramView)
  {
    if (paramView == this.this$0.mDefaultActivityButton)
    {
      if (this.this$0.mAdapter.getCount() > 0)
      {
        paramView = this.this$0;
        paramView.mIsSelectingDefaultActivity = true;
        paramView.showPopupUnchecked(paramView.mInitialActivityCount);
      }
      return true;
    }
    throw new IllegalArgumentException();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.appcompat.widget.ActivityChooserView.Callbacks
 * JD-Core Version:    0.7.0.1
 */