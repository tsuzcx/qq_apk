package com.tencent.ilive.base.page;

import android.content.Intent;
import com.tencent.ilive.base.page.fragment.LiveBaseFragment.FragmentActionCallback;
import com.tencent.ilive.interfaces.LiveFragmentAction;

final class PageFactory$1
  implements LiveBaseFragment.FragmentActionCallback
{
  PageFactory$1(PageFactory.FragmentActionCallback paramFragmentActionCallback) {}
  
  public void sendAction(LiveFragmentAction paramLiveFragmentAction, Intent paramIntent)
  {
    if (this.val$callback != null) {
      this.val$callback.onFragmentAction(paramLiveFragmentAction, paramIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilive.base.page.PageFactory.1
 * JD-Core Version:    0.7.0.1
 */