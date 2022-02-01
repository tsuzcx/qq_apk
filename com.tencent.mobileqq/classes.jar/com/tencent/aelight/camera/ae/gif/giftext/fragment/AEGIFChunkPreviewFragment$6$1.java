package com.tencent.aelight.camera.ae.gif.giftext.fragment;

import android.support.annotation.Nullable;
import androidx.lifecycle.Observer;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.aelight.camera.ae.data.AEGifMaterialManager;
import com.tencent.aelight.camera.ae.download.AEDownloadStateWrapper;
import com.tencent.aelight.camera.ae.gif.RecognizedEmotionBean;
import com.tencent.aelight.camera.ae.gif.giftext.AEGIFPreviewWrapper;
import com.tencent.aelight.camera.ae.gif.giftext.adapter.AEGIFChunkPreviewAdapter;
import com.tencent.aelight.camera.ae.gif.video.MaterialWrapper;
import com.tencent.aelight.camera.ae.gif.video.PngsCreateWorkingQueue;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Map;

class AEGIFChunkPreviewFragment$6$1
  implements Observer<AEDownloadStateWrapper>
{
  AEGIFChunkPreviewFragment$6$1(AEGIFChunkPreviewFragment.6 param6, RecognizedEmotionBean paramRecognizedEmotionBean) {}
  
  public void a(@Nullable AEDownloadStateWrapper paramAEDownloadStateWrapper)
  {
    QLog.d("AEGIFChunkPreviewFragment", 4, "On observe material download state");
    if (paramAEDownloadStateWrapper != null)
    {
      if (AEGIFChunkPreviewFragment.a(this.b.a) == null) {
        return;
      }
      int i = this.a.c + 1;
      while (i < AEGIFChunkPreviewFragment.a(this.b.a).size())
      {
        AEGIFPreviewWrapper localAEGIFPreviewWrapper = (AEGIFPreviewWrapper)AEGIFChunkPreviewFragment.a(this.b.a).get(i);
        if ((localAEGIFPreviewWrapper != null) && (localAEGIFPreviewWrapper.c != null) && (localAEGIFPreviewWrapper.c.id.equals(paramAEDownloadStateWrapper.a.id)))
        {
          if (localAEGIFPreviewWrapper.b != paramAEDownloadStateWrapper.b) {
            localAEGIFPreviewWrapper.b = paramAEDownloadStateWrapper.b;
          }
          if (localAEGIFPreviewWrapper.b != 2) {
            break;
          }
          localAEGIFPreviewWrapper.e = AEGifMaterialManager.a().a(localAEGIFPreviewWrapper.c);
          paramAEDownloadStateWrapper = new StringBuilder();
          paramAEDownloadStateWrapper.append("path===");
          paramAEDownloadStateWrapper.append(localAEGIFPreviewWrapper.e);
          QLog.d("AEGIFChunkPreviewFragment", 4, new Object[] { "Downloaded material", paramAEDownloadStateWrapper.toString() });
          paramAEDownloadStateWrapper = new MaterialWrapper();
          paramAEDownloadStateWrapper.a = i;
          paramAEDownloadStateWrapper.b = localAEGIFPreviewWrapper.e;
          if ((localAEGIFPreviewWrapper.c != null) && ((localAEGIFPreviewWrapper.d == null) || (localAEGIFPreviewWrapper.d.equals(""))))
          {
            if (localAEGIFPreviewWrapper.c.additionalFields.get("savename") != null)
            {
              paramAEDownloadStateWrapper.c = "";
              paramAEDownloadStateWrapper.d = ((String)localAEGIFPreviewWrapper.c.additionalFields.get("savename"));
            }
            else
            {
              paramAEDownloadStateWrapper.c = "";
              paramAEDownloadStateWrapper.d = "";
            }
          }
          else if (localAEGIFPreviewWrapper.d == null) {
            paramAEDownloadStateWrapper.c = "";
          } else {
            paramAEDownloadStateWrapper.c = localAEGIFPreviewWrapper.d;
          }
          AEGIFChunkPreviewFragment.d(this.b.a).a(paramAEDownloadStateWrapper);
          localAEGIFPreviewWrapper.a = 12;
          AEGIFChunkPreviewFragment.b(this.b.a).notifyItemChanged(i);
          return;
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.gif.giftext.fragment.AEGIFChunkPreviewFragment.6.1
 * JD-Core Version:    0.7.0.1
 */