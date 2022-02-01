package com.tencent.biz.qqcircle.immersive.aggregation.widget;

import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.utils.HardCodeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.ISuperPlayer.OnErrorListener;

class QFSAggregationHeadWidget$2
  implements ISuperPlayer.OnErrorListener
{
  QFSAggregationHeadWidget$2(QFSAggregationHeadWidget paramQFSAggregationHeadWidget) {}
  
  public boolean onError(ISuperPlayer paramISuperPlayer, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    QCircleToast.a(QCircleToast.c, HardCodeUtil.a(2131896230), 0);
    paramISuperPlayer = new StringBuilder();
    paramISuperPlayer.append("mAudioView onError  | module = ");
    paramISuperPlayer.append(paramInt1);
    paramISuperPlayer.append(" | errorType = ");
    paramISuperPlayer.append(paramInt2);
    paramISuperPlayer.append(" | errorCode = ");
    paramISuperPlayer.append(paramInt3);
    paramISuperPlayer.append(" | extraInfo = ");
    paramISuperPlayer.append(paramString);
    QLog.e("QFSAggregationHeadWidget", 1, paramISuperPlayer.toString());
    QFSAggregationHeadWidget.a(this.a, true);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.aggregation.widget.QFSAggregationHeadWidget.2
 * JD-Core Version:    0.7.0.1
 */