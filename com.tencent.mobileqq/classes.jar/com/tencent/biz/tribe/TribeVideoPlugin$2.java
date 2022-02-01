package com.tencent.biz.tribe;

import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.ISuperPlayer.OnVideoPreparedListener;

class TribeVideoPlugin$2
  implements ISuperPlayer.OnVideoPreparedListener
{
  TribeVideoPlugin$2(TribeVideoPlugin paramTribeVideoPlugin, TribeVideoPlugin.VideoWrapper paramVideoWrapper) {}
  
  public void onVideoPrepared(ISuperPlayer paramISuperPlayer)
  {
    if (paramISuperPlayer.getCurrentPositionMs() == 0L) {
      ReportController.b(null, "dc00899", "BizTechReport", ((BaseActivity)TribeVideoPlugin.a(this.jdField_a_of_type_ComTencentBizTribeTribeVideoPlugin)).getCurrentAccountUin(), "tribe_video", "video_prepared_time", 0, 0, Long.toString(System.currentTimeMillis() - TribeVideoPlugin.VideoWrapper.a(this.jdField_a_of_type_ComTencentBizTribeTribeVideoPlugin$VideoWrapper)), Integer.toString(NetworkUtil.b(TribeVideoPlugin.a(this.jdField_a_of_type_ComTencentBizTribeTribeVideoPlugin))), "", "");
    }
    if (TribeVideoPlugin.a(this.jdField_a_of_type_ComTencentBizTribeTribeVideoPlugin) != null)
    {
      TribeVideoPlugin.a(this.jdField_a_of_type_ComTencentBizTribeTribeVideoPlugin).removeMessages(5, TribeVideoPlugin.VideoWrapper.a(this.jdField_a_of_type_ComTencentBizTribeTribeVideoPlugin$VideoWrapper));
      paramISuperPlayer = TribeVideoPlugin.a(this.jdField_a_of_type_ComTencentBizTribeTribeVideoPlugin).obtainMessage();
      paramISuperPlayer.obj = TribeVideoPlugin.VideoWrapper.a(this.jdField_a_of_type_ComTencentBizTribeTribeVideoPlugin$VideoWrapper);
      paramISuperPlayer.what = 5;
      TribeVideoPlugin.a(this.jdField_a_of_type_ComTencentBizTribeTribeVideoPlugin).sendMessage(paramISuperPlayer);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.tribe.TribeVideoPlugin.2
 * JD-Core Version:    0.7.0.1
 */