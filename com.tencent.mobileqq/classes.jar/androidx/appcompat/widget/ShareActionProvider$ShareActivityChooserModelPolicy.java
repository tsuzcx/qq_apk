package androidx.appcompat.widget;

import android.content.Intent;

class ShareActionProvider$ShareActivityChooserModelPolicy
  implements ActivityChooserModel.OnChooseActivityListener
{
  ShareActionProvider$ShareActivityChooserModelPolicy(ShareActionProvider paramShareActionProvider) {}
  
  public boolean onChooseActivity(ActivityChooserModel paramActivityChooserModel, Intent paramIntent)
  {
    if (this.this$0.mOnShareTargetSelectedListener != null) {
      this.this$0.mOnShareTargetSelectedListener.onShareTargetSelected(this.this$0, paramIntent);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.appcompat.widget.ShareActionProvider.ShareActivityChooserModelPolicy
 * JD-Core Version:    0.7.0.1
 */