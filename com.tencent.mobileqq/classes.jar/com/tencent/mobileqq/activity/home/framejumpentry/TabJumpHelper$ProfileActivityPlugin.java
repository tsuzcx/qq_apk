package com.tencent.mobileqq.activity.home.framejumpentry;

import android.content.Intent;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.FrameFragment;

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
    if ((paramIntent instanceof ProfileActivity.AllInOne))
    {
      paramIntent = (ProfileActivity.AllInOne)paramIntent;
      paramIntent.g = 100;
      paramIntent.h = 6;
      ProfileActivity.b(paramFrameFragment.getActivity(), paramIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.framejumpentry.TabJumpHelper.ProfileActivityPlugin
 * JD-Core Version:    0.7.0.1
 */