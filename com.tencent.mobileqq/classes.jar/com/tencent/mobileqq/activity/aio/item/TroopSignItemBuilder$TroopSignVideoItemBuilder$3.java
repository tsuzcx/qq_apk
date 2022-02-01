package com.tencent.mobileqq.activity.aio.item;

import android.view.View;
import com.tencent.mobileqq.troop.widget.TroopSignVideoView;
import java.io.File;

class TroopSignItemBuilder$TroopSignVideoItemBuilder$3
  implements TroopSignItemBuilder.TroopSignVideoItemBuilder.IOnOfflineResCallback
{
  TroopSignItemBuilder$TroopSignVideoItemBuilder$3(TroopSignItemBuilder.TroopSignVideoItemBuilder paramTroopSignVideoItemBuilder, String paramString, TroopSignItemBuilder.TroopSignVideoItemBuilder.SignVideoItemHolder paramSignVideoItemHolder) {}
  
  public void a(int paramInt)
  {
    if (new File(this.a).exists())
    {
      this.b.v.a(this.a);
      this.b.x.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.TroopSignItemBuilder.TroopSignVideoItemBuilder.3
 * JD-Core Version:    0.7.0.1
 */