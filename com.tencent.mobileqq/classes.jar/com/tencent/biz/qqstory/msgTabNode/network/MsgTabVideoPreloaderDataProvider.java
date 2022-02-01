package com.tencent.biz.qqstory.msgTabNode.network;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeInfo;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodePullVideoBasicInfoSegment;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeVidListPullSegment;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.reactive.Stream;

public class MsgTabVideoPreloaderDataProvider
{
  private boolean a = true;
  private boolean b = true;
  private int c = 1;
  
  public void a(@NonNull MsgTabNodeInfo paramMsgTabNodeInfo, MsgTabVideoPreloaderDataProvider.DataProviderListener paramDataProviderListener)
  {
    if (this.a)
    {
      if (this.b)
      {
        if (QLog.isColorLevel()) {
          QLog.i("MsgTabVideoPreloaderDataProvider", 2, "下载vidList和VideoInfo");
        }
        Stream.of(paramMsgTabNodeInfo).map(new MsgTabNodeVidListPullSegment("MsgTabPreloader")).map(new MsgTabNodePullVideoBasicInfoSegment(null)).subscribe(new MsgTabVideoPreloaderDataProvider.2(this, paramDataProviderListener, paramMsgTabNodeInfo));
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.i("MsgTabVideoPreloaderDataProvider", 2, "只加载vidList");
      }
      Stream.of(paramMsgTabNodeInfo).map(new MsgTabNodeVidListPullSegment("MsgTabPreloader")).subscribe(new MsgTabVideoPreloaderDataProvider.3(this, paramDataProviderListener, paramMsgTabNodeInfo));
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  public void b(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.network.MsgTabVideoPreloaderDataProvider
 * JD-Core Version:    0.7.0.1
 */