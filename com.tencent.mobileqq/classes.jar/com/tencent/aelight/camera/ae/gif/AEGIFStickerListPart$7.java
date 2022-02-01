package com.tencent.aelight.camera.ae.gif;

import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Pair;
import android.widget.Toast;
import androidx.lifecycle.Observer;
import com.tencent.aelight.camera.ae.AEPituCameraUnit;
import com.tencent.aelight.camera.ae.data.AEGifCategoryWrapper;
import com.tencent.aelight.camera.ae.data.AEGifMaterialManager;
import com.tencent.aelight.camera.ae.data.AEMaterialWrapper;
import com.tencent.aelight.camera.ae.gif.giftext.adapter.AEGIFStickerAdapter;
import com.tencent.aelight.camera.ae.mode.AEVideoStoryCaptureModeViewModel;
import com.tencent.aelight.camera.ae.report.AEBaseDataReporter;
import com.tencent.aelight.camera.ae.report.AEBaseReportParam;
import com.tencent.mobileqq.widget.SimpleSlidingIndicator;
import java.util.List;

class AEGIFStickerListPart$7
  implements Observer<Boolean>
{
  AEGIFStickerListPart$7(AEGIFStickerListPart paramAEGIFStickerListPart) {}
  
  public void a(@Nullable Boolean paramBoolean)
  {
    if (paramBoolean != null)
    {
      if (!paramBoolean.booleanValue()) {
        return;
      }
      AEGIFStickerListPart.m(this.a);
      paramBoolean = AEGifMaterialManager.a().a(2);
      if (paramBoolean.size() > 0)
      {
        Object localObject = AEGIFStickerListPart.a(this.a, paramBoolean);
        int k = 0;
        int i;
        if ((localObject != null) && (((Pair)localObject).first != null)) {
          i = ((Integer)((Pair)localObject).first).intValue();
        } else {
          i = 0;
        }
        int j = k;
        if (localObject != null) {
          if (((Pair)localObject).second == null) {
            j = k;
          } else {
            j = ((Integer)((Pair)localObject).second).intValue();
          }
        }
        AEGIFStickerListPart.b(this.a, ((AEGifCategoryWrapper)paramBoolean.get(i)).categoryId);
        AEGIFStickerListPart.c(this.a, ((AEGifCategoryWrapper)paramBoolean.get(i)).fontId);
        if (AEGIFStickerListPart.n(this.a))
        {
          if ((i == 0) && (j == 0) && (!AEGIFStickerListPart.o(this.a))) {
            Toast.makeText(AEGIFStickerListPart.e(this.a).s(), 2064187418, 1).show();
          }
          AEGIFStickerListPart.a(this.a, true);
        }
        AEGIFStickerListPart.l(this.a).clear();
        AEGIFStickerListPart.l(this.a).addAll(paramBoolean);
        localObject = this.a;
        AEGIFStickerListPart.a((AEGIFStickerListPart)localObject, AEGIFStickerListPart.b((AEGIFStickerListPart)localObject, paramBoolean));
        AEGIFStickerListPart.a(this.a).setTabData((String[])AEGIFStickerListPart.p(this.a).first, (int[])AEGIFStickerListPart.p(this.a).second);
        AEGIFStickerListPart.a(this.a).post(new AEGIFStickerListPart.7.1(this, i));
        AEGIFStickerListPart.h(this.a).clear();
        AEGIFStickerListPart.h(this.a).addAll(((AEGifCategoryWrapper)AEGIFStickerListPart.l(this.a).get(i)).materialWrapperList);
        AEGIFStickerListPart.i(this.a).notifyDataSetChanged();
        AEGIFStickerListPart.b(this.a).post(new AEGIFStickerListPart.7.2(this, j));
        paramBoolean = (AEMaterialWrapper)((AEGifCategoryWrapper)AEGIFStickerListPart.l(this.a).get(i)).materialWrapperList.get(j);
        if (paramBoolean.g == 1) {
          AEGIFStickerListPart.a(this.a, null);
        } else {
          AEGIFStickerListPart.a(this.a, paramBoolean);
        }
        if ((TextUtils.isEmpty(AEGIFStickerListPart.d(this.a))) && (i == 0))
        {
          paramBoolean = this.a;
          AEGIFStickerListPart.d(paramBoolean, ((AEGifCategoryWrapper)AEGIFStickerListPart.l(paramBoolean).get(i)).categoryId);
          if ((AEGIFStickerListPart.f(this.a) != null) && (AEGIFStickerListPart.f(this.a).a()))
          {
            AEBaseReportParam.a().D(AEGIFStickerListPart.d(this.a));
            AEBaseDataReporter.a().ar();
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.gif.AEGIFStickerListPart.7
 * JD-Core Version:    0.7.0.1
 */