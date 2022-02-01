package com.tencent.av.wtogether;

import com.tencent.av.app.SessionInfo;
import com.tencent.av.wtogether.callback.RealNameAuthCallback;
import com.tencent.av.wtogether.data.WatchTogetherInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;

class WTogetherMng$1
  implements RealNameAuthCallback
{
  WTogetherMng$1(WTogetherMng paramWTogetherMng, SessionInfo paramSessionInfo, WatchTogetherInfo paramWatchTogetherInfo, WTogetherRealNameVideoProcessHelper paramWTogetherRealNameVideoProcessHelper) {}
  
  public void a()
  {
    WTogetherMng.a(this.jdField_a_of_type_ComTencentAvWtogetherWTogetherMng, this.jdField_a_of_type_ComTencentAvWtogetherDataWatchTogetherInfo);
    this.jdField_a_of_type_ComTencentAvWtogetherWTogetherRealNameVideoProcessHelper.a(null);
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      WTogetherMng.a(this.jdField_a_of_type_ComTencentAvWtogetherWTogetherMng, this.jdField_a_of_type_ComTencentAvAppSessionInfo, this.jdField_a_of_type_ComTencentAvWtogetherDataWatchTogetherInfo.a, this.jdField_a_of_type_ComTencentAvWtogetherDataWatchTogetherInfo.a());
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvWtogetherWTogetherRealNameVideoProcessHelper.a(null);
      return;
      WTogetherMng.a(this.jdField_a_of_type_ComTencentAvWtogetherWTogetherMng, this.jdField_a_of_type_ComTencentAvWtogetherDataWatchTogetherInfo);
      WTogetherMng.a(this.jdField_a_of_type_ComTencentAvWtogetherWTogetherMng, BaseApplicationImpl.getContext().getString(2131695996), 0L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.wtogether.WTogetherMng.1
 * JD-Core Version:    0.7.0.1
 */