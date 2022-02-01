package com.tencent.aelight.camera.aioeditor.shortvideo;

import com.tencent.aelight.camera.aioeditor.capture.data.TemplateGroupItem;
import com.tencent.aelight.camera.struct.editor.PtvTemplateInfo;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

class QIMPtvTemplateManager$6
  implements INetEngineListener
{
  QIMPtvTemplateManager$6(QIMPtvTemplateManager paramQIMPtvTemplateManager, PtvTemplateInfo paramPtvTemplateInfo, PtvTemplateManager.IPtvTemplateDownloadListener paramIPtvTemplateDownloadListener) {}
  
  public void onResp(NetResp arg1)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onResp url: ");
      ((StringBuilder)localObject1).append(this.a.c);
      ((StringBuilder)localObject1).append(" resultcode: ");
      ((StringBuilder)localObject1).append(???.mHttpCode);
      QLog.i("QIMPtvTemplateManager", 2, ((StringBuilder)localObject1).toString());
    }
    ??? = this.a;
    ???.g = this.c.a(???);
    synchronized (this.c.g)
    {
      localObject1 = this.c.f.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject3 = (TemplateGroupItem)((Iterator)localObject1).next();
        if (((TemplateGroupItem)localObject3).a != null)
        {
          localObject3 = ((TemplateGroupItem)localObject3).a.iterator();
          while (((Iterator)localObject3).hasNext())
          {
            PtvTemplateInfo localPtvTemplateInfo = (PtvTemplateInfo)((Iterator)localObject3).next();
            if (localPtvTemplateInfo.e.equals(this.a.e)) {
              localPtvTemplateInfo.g = this.c.a(localPtvTemplateInfo);
            }
          }
        }
      }
      ??? = this.b;
      if (??? != null)
      {
        localObject1 = this.a;
        ???.a((PtvTemplateInfo)localObject1, ((PtvTemplateInfo)localObject1).g);
      }
      return;
    }
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2)
  {
    paramNetReq = this.a;
    paramNetReq.X = paramLong2;
    PtvTemplateManager.IPtvTemplateDownloadListener localIPtvTemplateDownloadListener = this.b;
    if (localIPtvTemplateDownloadListener != null) {
      localIPtvTemplateDownloadListener.a(paramNetReq, (int)(paramLong1 * 100L / paramLong2));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.shortvideo.QIMPtvTemplateManager.6
 * JD-Core Version:    0.7.0.1
 */