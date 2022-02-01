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
import com.tencent.mobileqq.activity.contacts.base.tabs.SimpleSlidingIndicator;
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
      AEGIFStickerListPart.b(this.a);
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
        AEGIFStickerListPart.a(this.a, ((AEGifCategoryWrapper)paramBoolean.get(i)).fontId);
        if (AEGIFStickerListPart.b(this.a))
        {
          if ((i == 0) && (j == 0) && (!AEGIFStickerListPart.c(this.a))) {
            Toast.makeText(AEGIFStickerListPart.a(this.a).a(), 2064515088, 1).show();
          }
          AEGIFStickerListPart.a(this.a, true);
        }
        AEGIFStickerListPart.b(this.a).clear();
        AEGIFStickerListPart.b(this.a).addAll(paramBoolean);
        localObject = this.a;
        AEGIFStickerListPart.a((AEGIFStickerListPart)localObject, AEGIFStickerListPart.b((AEGIFStickerListPart)localObject, paramBoolean));
        AEGIFStickerListPart.a(this.a).setTabData((String[])AEGIFStickerListPart.a(this.a).first, (int[])AEGIFStickerListPart.a(this.a).second);
        AEGIFStickerListPart.a(this.a).post(new AEGIFStickerListPart.7.1(this, i));
        AEGIFStickerListPart.a(this.a).clear();
        AEGIFStickerListPart.a(this.a).addAll(((AEGifCategoryWrapper)AEGIFStickerListPart.b(this.a).get(i)).materialWrapperList);
        AEGIFStickerListPart.a(this.a).notifyDataSetChanged();
        AEGIFStickerListPart.a(this.a).post(new AEGIFStickerListPart.7.2(this, j));
        paramBoolean = (AEMaterialWrapper)((AEGifCategoryWrapper)AEGIFStickerListPart.b(this.a).get(i)).materialWrapperList.get(j);
        if (paramBoolean.b == 1) {
          AEGIFStickerListPart.a(this.a, null);
        } else {
          AEGIFStickerListPart.a(this.a, paramBoolean);
        }
        if ((TextUtils.isEmpty(AEGIFStickerListPart.a(this.a))) && (i == 0))
        {
          paramBoolean = this.a;
          AEGIFStickerListPart.c(paramBoolean, ((AEGifCategoryWrapper)AEGIFStickerListPart.b(paramBoolean).get(i)).categoryId);
          if ((AEGIFStickerListPart.a(this.a) != null) && (AEGIFStickerListPart.a(this.a).a()))
          {
            AEBaseReportParam.a().s(AEGIFStickerListPart.a(this.a));
            AEBaseDataReporter.a().am();
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.gif.AEGIFStickerListPart.7
 * JD-Core Version:    0.7.0.1
 */