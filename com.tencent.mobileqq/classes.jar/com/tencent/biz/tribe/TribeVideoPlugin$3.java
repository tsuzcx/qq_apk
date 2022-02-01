package com.tencent.biz.tribe;

import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.ISuperPlayer.OnCompletionListener;

class TribeVideoPlugin$3
  implements ISuperPlayer.OnCompletionListener
{
  TribeVideoPlugin$3(TribeVideoPlugin paramTribeVideoPlugin, TribeVideoPlugin.VideoWrapper paramVideoWrapper) {}
  
  public void onCompletion(ISuperPlayer paramISuperPlayer)
  {
    if (TribeVideoPlugin.a(this.jdField_a_of_type_ComTencentBizTribeTribeVideoPlugin) != null)
    {
      TribeVideoPlugin.a(this.jdField_a_of_type_ComTencentBizTribeTribeVideoPlugin).removeMessages(6, TribeVideoPlugin.VideoWrapper.a(this.jdField_a_of_type_ComTencentBizTribeTribeVideoPlugin$VideoWrapper));
      paramISuperPlayer = TribeVideoPlugin.a(this.jdField_a_of_type_ComTencentBizTribeTribeVideoPlugin).obtainMessage();
      paramISuperPlayer.obj = TribeVideoPlugin.VideoWrapper.a(this.jdField_a_of_type_ComTencentBizTribeTribeVideoPlugin$VideoWrapper);
      paramISuperPlayer.what = 6;
      TribeVideoPlugin.a(this.jdField_a_of_type_ComTencentBizTribeTribeVideoPlugin).sendMessage(paramISuperPlayer);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.tribe.TribeVideoPlugin.3
 * JD-Core Version:    0.7.0.1
 */