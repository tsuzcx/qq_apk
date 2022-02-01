package com.tencent.mobileqq.activity.richmedia.p2veffect.music;

import com.tencent.biz.qqstory.model.AddressDataProvider;
import com.tencent.biz.qqstory.model.AddressDataProvider.AddressInfo;
import com.tencent.biz.qqstory.model.DataProviderManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.takevideo.music.MusicGridAdapter;
import com.tencent.qphone.base.util.QLog;

class P2VEditMusicDialog$4$1
  implements Runnable
{
  P2VEditMusicDialog$4$1(P2VEditMusicDialog.4 param4, AddressDataProvider.AddressInfo paramAddressInfo) {}
  
  public void run()
  {
    SLog.b(P2VEditMusicDialog.a(), "address update, refresh ui.");
    if (((AddressDataProvider)((DataProviderManager)SuperManager.a(20)).a(1)).a(this.jdField_a_of_type_ComTencentBizQqstoryModelAddressDataProvider$AddressInfo))
    {
      QLog.d(P2VEditMusicDialog.a(), 2, "isInternationalUser --------------------2");
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaP2veffectMusicP2VEditMusicDialog$4.a.a.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.p2veffect.music.P2VEditMusicDialog.4.1
 * JD-Core Version:    0.7.0.1
 */