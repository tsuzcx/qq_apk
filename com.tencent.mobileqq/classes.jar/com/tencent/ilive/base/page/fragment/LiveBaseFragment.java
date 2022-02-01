package com.tencent.ilive.base.page.fragment;

import android.content.Intent;
import com.tencent.ilive.base.page.PageFactory;
import com.tencent.ilive.base.page.config.ActivityConfig;
import com.tencent.ilive.interfaces.LiveFragmentAction;
import java.util.Map;

public class LiveBaseFragment
  extends BaseFragment
{
  public static final int ACTION_FRAGMENT = 2020;
  protected LiveBaseFragment.FragmentActionCallback actionCallback;
  protected int pageType;
  
  public void callFragmentAction(LiveFragmentAction paramLiveFragmentAction, Intent paramIntent)
  {
    LiveBaseFragment.FragmentActionCallback localFragmentActionCallback = this.actionCallback;
    if (localFragmentActionCallback != null) {
      localFragmentActionCallback.sendAction(paramLiveFragmentAction, paramIntent);
    }
  }
  
  public void finish()
  {
    if (isConfigActivity(this.pageType)) {
      callFragmentAction(LiveFragmentAction.CLOSE_ACTIVITY, null);
    }
  }
  
  public void init(int paramInt, LiveBaseFragment.FragmentActionCallback paramFragmentActionCallback)
  {
    this.pageType = paramInt;
    this.actionCallback = paramFragmentActionCallback;
  }
  
  protected boolean isConfigActivity(int paramInt)
  {
    return (getActivity() != null) && (PageFactory.getActivityConfig().contains(paramInt));
  }
  
  public boolean onBackPressed()
  {
    return true;
  }
  
  public void startActivity(Intent paramIntent, int paramInt)
  {
    if (isConfigActivity(paramInt)) {
      paramIntent.setClass(getActivity(), (Class)PageFactory.getActivityConfig().get().get(Integer.valueOf(paramInt)));
    }
    super.startActivity(paramIntent);
  }
  
  public void terminate() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilive.base.page.fragment.LiveBaseFragment
 * JD-Core Version:    0.7.0.1
 */