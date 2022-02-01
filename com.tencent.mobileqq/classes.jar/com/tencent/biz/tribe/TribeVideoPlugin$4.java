package com.tencent.biz.tribe;

import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.ISuperPlayer.OnErrorListener;

class TribeVideoPlugin$4
  implements ISuperPlayer.OnErrorListener
{
  TribeVideoPlugin$4(TribeVideoPlugin paramTribeVideoPlugin, TribeVideoPlugin.VideoWrapper paramVideoWrapper) {}
  
  public boolean onError(ISuperPlayer paramISuperPlayer, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    QLog.e("TribeVideoPlugin", 2, "ISuperPlayer.OnErrorListener module = " + paramInt1 + " errorType = " + paramInt2 + " errorCode = " + paramInt3 + " extraInfo = " + paramString);
    if (TribeVideoPlugin.a(this.jdField_a_of_type_ComTencentBizTribeTribeVideoPlugin) != null)
    {
      TribeVideoPlugin.a(this.jdField_a_of_type_ComTencentBizTribeTribeVideoPlugin).removeMessages(7, TribeVideoPlugin.VideoWrapper.a(this.jdField_a_of_type_ComTencentBizTribeTribeVideoPlugin$VideoWrapper));
      paramISuperPlayer = TribeVideoPlugin.a(this.jdField_a_of_type_ComTencentBizTribeTribeVideoPlugin).obtainMessage();
      paramISuperPlayer.obj = TribeVideoPlugin.VideoWrapper.a(this.jdField_a_of_type_ComTencentBizTribeTribeVideoPlugin$VideoWrapper);
      paramISuperPlayer.what = 7;
      TribeVideoPlugin.a(this.jdField_a_of_type_ComTencentBizTribeTribeVideoPlugin).sendMessage(paramISuperPlayer);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.tribe.TribeVideoPlugin.4
 * JD-Core Version:    0.7.0.1
 */