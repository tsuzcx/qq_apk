package com.tencent.biz.qqcircle.list.bizblocks;

import android.os.Handler;
import android.util.Pair;
import com.tencent.biz.qcircleshadow.lib.variation.HostDataTransUtils;
import com.tencent.biz.richframework.delegate.impl.RFThreadManager;
import com.tencent.richframework.data.idata.IDataCallBack;
import java.util.ArrayList;

class QCircleChatListBlock$3
  implements Runnable
{
  QCircleChatListBlock$3(QCircleChatListBlock paramQCircleChatListBlock, IDataCallBack paramIDataCallBack) {}
  
  public void run()
  {
    ArrayList localArrayList = HostDataTransUtils.makeRecentBaseDataList();
    Pair localPair = HostDataTransUtils.getQCircleChatRedPointInfoFromMessageList();
    RFThreadManager.getUIHandler().post(new QCircleChatListBlock.3.1(this, localPair));
    this.a.a(true, 0L, localArrayList, "", true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.list.bizblocks.QCircleChatListBlock.3
 * JD-Core Version:    0.7.0.1
 */