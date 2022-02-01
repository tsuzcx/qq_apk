package com.tencent.aelight.camera.ae.gif.giftext.fragment;

import android.support.annotation.Nullable;
import android.widget.TextView;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.aelight.camera.ae.gif.RecognizedEmotionBean;
import com.tencent.aelight.camera.ae.gif.giftext.AEGIFPreviewWrapper;
import com.tencent.aelight.camera.ae.gif.giftext.AEGIFTextMvp;
import com.tencent.aelight.camera.ae.gif.giftext.adapter.AEGIFChunkPreviewAdapter;
import com.tencent.aelight.camera.ae.gif.giftext.viewmodel.AEGIFMaterialViewModel;
import com.tencent.aelight.camera.ae.gif.giftext.viewmodel.AEGIFRecommandTextViewModel;
import com.tencent.aelight.camera.ae.gif.video.MaterialWrapper;
import com.tencent.aelight.camera.ae.gif.video.PngsCreateWorkingQueue;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.List;

class AEGIFChunkPreviewFragment$6
  implements Observer<RecognizedEmotionBean>
{
  AEGIFChunkPreviewFragment$6(AEGIFChunkPreviewFragment paramAEGIFChunkPreviewFragment) {}
  
  public void a(@Nullable RecognizedEmotionBean paramRecognizedEmotionBean)
  {
    AEGIFRecommandTextViewModel.a().removeObservers(AEGIFChunkPreviewFragment.c(this.a));
    if (paramRecognizedEmotionBean != null)
    {
      int i = 0;
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("=====");
      ((StringBuilder)localObject1).append(paramRecognizedEmotionBean);
      QLog.d("AEGIFChunkPreviewFragment", 4, new Object[] { "Obtained recognizedEmotion", ((StringBuilder)localObject1).toString() });
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("emo ===");
      ((StringBuilder)localObject1).append(paramRecognizedEmotionBean.b);
      ((StringBuilder)localObject1).append("text ===");
      ((StringBuilder)localObject1).append(paramRecognizedEmotionBean.c);
      ((StringBuilder)localObject1).append("material ====");
      ((StringBuilder)localObject1).append(paramRecognizedEmotionBean.d);
      QLog.d("AEGIFChunkPreviewFragment", 4, ((StringBuilder)localObject1).toString());
      if (paramRecognizedEmotionBean.b == null)
      {
        paramRecognizedEmotionBean.c = 0;
        paramRecognizedEmotionBean.d = 6;
        paramRecognizedEmotionBean.b = "default";
      }
      if ((paramRecognizedEmotionBean.a != null) && (paramRecognizedEmotionBean.a.size() == 0)) {
        paramRecognizedEmotionBean.a.addAll(AEGIFTextMvp.a);
      }
      Object localObject2;
      if (paramRecognizedEmotionBean.b.equals("default"))
      {
        localObject1 = HardCodeUtil.a(2131898239);
      }
      else
      {
        localObject1 = (String)AEGIFChunkPreviewFragment.f(this.a).get(paramRecognizedEmotionBean.b);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(HardCodeUtil.a(2131898234));
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(HardCodeUtil.a(2131898241));
        localObject1 = ((StringBuilder)localObject2).toString();
      }
      AEGIFChunkPreviewFragment.g(this.a).setText((CharSequence)localObject1);
      while (i < paramRecognizedEmotionBean.c)
      {
        localObject1 = new AEGIFPreviewWrapper();
        ((AEGIFPreviewWrapper)localObject1).c = null;
        ((AEGIFPreviewWrapper)localObject1).d = ((String)paramRecognizedEmotionBean.a.get(i % paramRecognizedEmotionBean.a.size()));
        ((AEGIFPreviewWrapper)localObject1).b = 2;
        if (AEGIFChunkPreviewFragment.a(this.a).size() >= AEGIFChunkPreviewFragment.h(this.a)) {
          break;
        }
        AEGIFChunkPreviewFragment.a(this.a).add(localObject1);
        AEGIFChunkPreviewFragment.b(this.a).notifyItemInserted(AEGIFChunkPreviewFragment.a(this.a).size() - 1);
        localObject2 = new MaterialWrapper();
        ((MaterialWrapper)localObject2).c = ((AEGIFPreviewWrapper)localObject1).d;
        i += 1;
        ((MaterialWrapper)localObject2).a = i;
        AEGIFChunkPreviewFragment.d(this.a).a((MaterialWrapper)localObject2);
      }
      AEGIFChunkPreviewFragment.i(this.a).a().observe(AEGIFChunkPreviewFragment.c(this.a), new AEGIFChunkPreviewFragment.6.1(this, paramRecognizedEmotionBean));
      AEGIFChunkPreviewFragment.a(this.a, paramRecognizedEmotionBean);
      return;
    }
    QLog.d("AEGIFChunkPreviewFragment", 4, "Recognized emotion bean is null");
    paramRecognizedEmotionBean = new AEGIFPreviewWrapper();
    paramRecognizedEmotionBean.e = "";
    paramRecognizedEmotionBean.d = "";
    paramRecognizedEmotionBean.b = 2;
    paramRecognizedEmotionBean.a = 11;
    AEGIFChunkPreviewFragment.a(this.a).add(paramRecognizedEmotionBean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.gif.giftext.fragment.AEGIFChunkPreviewFragment.6
 * JD-Core Version:    0.7.0.1
 */