package com.tencent.mobileqq.activity.richmedia.p2veffect.music;

import android.os.Handler;
import com.tencent.biz.qqstory.model.AddressDataProvider.AddressInfo;
import com.tencent.biz.qqstory.model.DataProvider.DataUpdateListener;
import com.tencent.biz.qqstory.support.logging.SLog;

class P2VEditMusicDialog$4
  implements DataProvider.DataUpdateListener<AddressDataProvider.AddressInfo>
{
  P2VEditMusicDialog$4(P2VEditMusicDialog paramP2VEditMusicDialog) {}
  
  public void a(boolean paramBoolean, AddressDataProvider.AddressInfo paramAddressInfo)
  {
    SLog.b(P2VEditMusicDialog.h(), "onAddressUpdate.");
    if ((paramBoolean) && (paramAddressInfo != null))
    {
      SLog.a(P2VEditMusicDialog.h(), "onAddressUpdate success, address=%s", paramAddressInfo);
      this.a.B.post(new P2VEditMusicDialog.4.1(this, paramAddressInfo));
      return;
    }
    SLog.e(P2VEditMusicDialog.h(), "onAddressUpdate failed.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.p2veffect.music.P2VEditMusicDialog.4
 * JD-Core Version:    0.7.0.1
 */