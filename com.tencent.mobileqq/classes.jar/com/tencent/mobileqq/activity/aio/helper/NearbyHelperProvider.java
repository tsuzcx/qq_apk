package com.tencent.mobileqq.activity.aio.helper;

import android.app.Activity;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.NearbyChatPie;
import com.tencent.mobileqq.pushdialog.AIOPushDialogHelper;

public class NearbyHelperProvider
  extends HelperProvider
{
  public NearbyHelperProvider(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  private void a(NearbyChatPie paramNearbyChatPie)
  {
    a(42, new AIOPushDialogHelper(paramNearbyChatPie));
    a(109, new NearbyTipsHelper(paramNearbyChatPie.bv()));
    NearbyAddFriendHelper localNearbyAddFriendHelper = new NearbyAddFriendHelper(paramNearbyChatPie.bv());
    a(113, localNearbyAddFriendHelper);
    a(localNearbyAddFriendHelper);
    a(136, new NearByGiftPanelHelper(paramNearbyChatPie));
  }
  
  public void a(BaseChatPie paramBaseChatPie)
  {
    super.a(paramBaseChatPie);
    a((NearbyChatPie)paramBaseChatPie);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.NearbyHelperProvider
 * JD-Core Version:    0.7.0.1
 */