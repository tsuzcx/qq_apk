package com.tencent.ilive.audiencepages.room.bizmodule;

import com.tencent.falco.base.libapi.network.OnNetworkListener;
import com.tencent.ilive.interfaces.IAudienceRoomPager;
import com.tencent.ilive.pages.room.RoomBizContext;
import com.tencent.ilivesdk.roomservice_interface.model.EnterRoomInfo;

class FloatWindowModule$1
  implements OnNetworkListener
{
  FloatWindowModule$1(FloatWindowModule paramFloatWindowModule) {}
  
  public void onNetWorkChange(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.this$0.floatWindowComponent == null) {
      return;
    }
    if (!FloatWindowModule.access$000(this.this$0)) {
      return;
    }
    if (FloatWindowModule.access$100(this.this$0).getEnterRoomInfo().bootModulesIndex != this.this$0.getAudienceRoomPager().getCurrentIndex()) {
      return;
    }
    if (paramBoolean1)
    {
      FloatWindowModule.access$200(this.this$0, "网络异常");
      FloatWindowModule.access$300(this.this$0, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilive.audiencepages.room.bizmodule.FloatWindowModule.1
 * JD-Core Version:    0.7.0.1
 */