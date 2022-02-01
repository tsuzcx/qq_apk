package com.tencent.aelight.camera.ae.gif.giftext.adapter;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.aelight.camera.ae.data.AEMaterialWrapper;
import com.tencent.aelight.camera.ae.report.AEBaseDataReporter;
import com.tencent.aelight.camera.ae.report.AEBaseReportParam;
import com.tencent.aelight.camera.log.AEQLog;

class AEGIFStickerAdapter$1
  implements View.OnClickListener
{
  AEGIFStickerAdapter$1(AEGIFStickerAdapter paramAEGIFStickerAdapter, int paramInt, AEMaterialWrapper paramAEMaterialWrapper) {}
  
  public void onClick(View paramView)
  {
    paramView = new StringBuilder();
    paramView.append("[ItemView.onClick] position=");
    paramView.append(this.a);
    paramView.append(", mClickedPos=");
    paramView.append(AEGIFStickerAdapter.a(this.c));
    paramView.append(", mActivatedPos=");
    paramView.append(AEGIFStickerAdapter.b(this.c));
    AEQLog.a("AEGIFStickerAdapter", paramView.toString());
    AEGIFStickerAdapter.a(this.c, this.a);
    int i = this.b.f;
    AEGIFStickerAdapter.OnMaterialClickCallback localOnMaterialClickCallback1 = null;
    paramView = null;
    if ((i != 2) && (this.b.g != 1))
    {
      if (this.b.f == 0)
      {
        AEQLog.a("AEGIFStickerAdapter", "[ItemView.onClick] data.state == STATE_NOT_DOWNLOAD");
        if (AEGIFStickerAdapter.c(this.c) != null)
        {
          localOnMaterialClickCallback1 = AEGIFStickerAdapter.c(this.c);
          if (this.b.g != 1) {
            paramView = this.b;
          }
          localOnMaterialClickCallback1.a(paramView);
        }
      }
      else
      {
        AEQLog.a("AEGIFStickerAdapter", "[ItemView.onClick] data.state == STATE_DOWNLOADING");
      }
    }
    else
    {
      AEQLog.a("AEGIFStickerAdapter", "[ItemView.onClick] data.state == STATE_DOWNLOADED");
      AEGIFStickerAdapter.b(this.c, this.a);
      if (this.a != AEGIFStickerAdapter.b(this.c))
      {
        AEQLog.a("AEGIFStickerAdapter", "[ItemView.onClick] position != mActivatedPos");
        i = AEGIFStickerAdapter.b(this.c);
        AEGIFStickerAdapter.c(this.c, this.a);
        this.c.notifyItemChanged(this.a);
        this.c.notifyItemChanged(i);
        if (AEGIFStickerAdapter.c(this.c) != null)
        {
          AEGIFStickerAdapter.OnMaterialClickCallback localOnMaterialClickCallback2 = AEGIFStickerAdapter.c(this.c);
          if (this.b.g == 1) {
            paramView = localOnMaterialClickCallback1;
          } else {
            paramView = this.b;
          }
          localOnMaterialClickCallback2.a(paramView);
        }
        AEBaseReportParam.a().C(this.b.a);
        AEBaseDataReporter.a().aq();
        paramView = new StringBuilder();
        paramView.append("[ItemView.onClick] gifMaterialClick, id=");
        paramView.append(this.b.a);
        AEQLog.b("AEGIFStickerAdapter", paramView.toString());
        return;
      }
      AEQLog.a("AEGIFStickerAdapter", "[ItemView.onClick] position == mActivatedPos");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.gif.giftext.adapter.AEGIFStickerAdapter.1
 * JD-Core Version:    0.7.0.1
 */