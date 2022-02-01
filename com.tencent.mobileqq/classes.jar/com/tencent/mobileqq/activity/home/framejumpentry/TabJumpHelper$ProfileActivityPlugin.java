package com.tencent.mobileqq.activity.home.framejumpentry;

import android.content.Intent;
import com.tencent.mobileqq.app.FrameFragment;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;

public class TabJumpHelper$ProfileActivityPlugin
  extends TabJumpHelper.BaseJumpActivityPlugin
{
  public TabJumpHelper$ProfileActivityPlugin(TabJumpHelper paramTabJumpHelper)
  {
    super(paramTabJumpHelper);
  }
  
  public void a(FrameFragment paramFrameFragment, Intent paramIntent)
  {
    paramIntent = paramIntent.getParcelableExtra("AllInOne");
    if ((paramIntent instanceof AllInOne))
    {
      paramIntent = (AllInOne)paramIntent;
      paramIntent.lastActivity = 100;
      paramIntent.profileEntryType = 6;
      ProfileUtils.openProfileCard(paramFrameFragment.getActivity(), paramIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.framejumpentry.TabJumpHelper.ProfileActivityPlugin
 * JD-Core Version:    0.7.0.1
 */