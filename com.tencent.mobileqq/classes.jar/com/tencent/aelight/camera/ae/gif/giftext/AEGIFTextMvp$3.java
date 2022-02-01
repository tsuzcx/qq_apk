package com.tencent.aelight.camera.ae.gif.giftext;

import android.support.annotation.Nullable;
import android.widget.TextView;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.aelight.camera.ae.gif.RecognizedEmotionBean;
import com.tencent.aelight.camera.ae.gif.giftext.viewmodel.AEGIFRecommandTextViewModel;
import com.tencent.mobileqq.app.HardCodeUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class AEGIFTextMvp$3
  implements Observer<RecognizedEmotionBean>
{
  AEGIFTextMvp$3(AEGIFTextMvp paramAEGIFTextMvp) {}
  
  public void a(@Nullable RecognizedEmotionBean paramRecognizedEmotionBean)
  {
    AEGIFRecommandTextViewModel.a().removeObservers(AEGIFTextMvp.b(this.a));
    RecognizedEmotionBean localRecognizedEmotionBean;
    if (paramRecognizedEmotionBean != null)
    {
      localRecognizedEmotionBean = paramRecognizedEmotionBean;
      if (paramRecognizedEmotionBean.b != null) {}
    }
    else
    {
      localRecognizedEmotionBean = new RecognizedEmotionBean();
      localRecognizedEmotionBean.b = "default";
    }
    paramRecognizedEmotionBean = (String)AEGIFTextMvp.c(this.a).get(localRecognizedEmotionBean.b);
    if (!localRecognizedEmotionBean.b.equals("default"))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(HardCodeUtil.a(2131898262));
      localStringBuilder.append(paramRecognizedEmotionBean);
      localStringBuilder.append(HardCodeUtil.a(2131898255));
      paramRecognizedEmotionBean = localStringBuilder.toString();
    }
    else
    {
      paramRecognizedEmotionBean = HardCodeUtil.a(2131898251);
      localRecognizedEmotionBean.a.addAll(AEGIFTextMvp.a);
    }
    AEGIFTextMvp.d(this.a).setText(paramRecognizedEmotionBean);
    if ((AEGIFTextMvp.e(this.a).size() == 0) && (!AEGIFTextMvp.f(this.a)))
    {
      AEGIFTextMvp.e(this.a).addAll(localRecognizedEmotionBean.a);
      this.a.b();
      AEGIFTextMvp.a(this.a, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.gif.giftext.AEGIFTextMvp.3
 * JD-Core Version:    0.7.0.1
 */