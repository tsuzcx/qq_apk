package com.tencent.biz.videostory.widget.view.smartmusicview;

import com.tencent.biz.common.util.ZipUtils;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;

class EditVideoSmartMusicPart$1$1
  implements INetEngineListener
{
  EditVideoSmartMusicPart$1$1(EditVideoSmartMusicPart.1 param1) {}
  
  public void onResp(NetResp paramNetResp)
  {
    QLog.i("EditVideoSmartMusicPart", 1, "download smart anim onResp url:  resultcode: " + paramNetResp.mHttpCode);
    if (EditVideoSmartMusicPart.a(this.a.this$0) == null) {
      return;
    }
    try
    {
      QLog.i("EditVideoSmartMusicPart", 1, "start unzip smart anim");
      ZipUtils.unZipFile(EditVideoSmartMusicPart.a(this.a.this$0), "/storage/emulated/0/Tencent/MobileQQ/video_story/");
      return;
    }
    catch (IOException paramNetResp)
    {
      QLog.i("EditVideoSmartMusicPart", 1, "unzip smart anim failed" + paramNetResp);
    }
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.videostory.widget.view.smartmusicview.EditVideoSmartMusicPart.1.1
 * JD-Core Version:    0.7.0.1
 */