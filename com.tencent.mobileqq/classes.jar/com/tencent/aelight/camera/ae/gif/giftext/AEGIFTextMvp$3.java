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
    AEGIFTextMvp.a(this.a).a().removeObservers(AEGIFTextMvp.a(this.a));
    RecognizedEmotionBean localRecognizedEmotionBean;
    if (paramRecognizedEmotionBean != null)
    {
      localRecognizedEmotionBean = paramRecognizedEmotionBean;
      if (paramRecognizedEmotionBean.jdField_a_of_type_JavaLangString != null) {}
    }
    else
    {
      localRecognizedEmotionBean = new RecognizedEmotionBean();
      localRecognizedEmotionBean.jdField_a_of_type_JavaLangString = "default";
    }
    paramRecognizedEmotionBean = (String)AEGIFTextMvp.a(this.a).get(localRecognizedEmotionBean.jdField_a_of_type_JavaLangString);
    if (!localRecognizedEmotionBean.jdField_a_of_type_JavaLangString.equals("default"))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(HardCodeUtil.a(2131700218));
      localStringBuilder.append(paramRecognizedEmotionBean);
      localStringBuilder.append(HardCodeUtil.a(2131700211));
      paramRecognizedEmotionBean = localStringBuilder.toString();
    }
    else
    {
      paramRecognizedEmotionBean = HardCodeUtil.a(2131700207);
      localRecognizedEmotionBean.jdField_a_of_type_JavaUtilList.addAll(AEGIFTextMvp.jdField_a_of_type_JavaUtilList);
    }
    AEGIFTextMvp.a(this.a).setText(paramRecognizedEmotionBean);
    if ((AEGIFTextMvp.a(this.a).size() == 0) && (!AEGIFTextMvp.a(this.a)))
    {
      AEGIFTextMvp.a(this.a).addAll(localRecognizedEmotionBean.jdField_a_of_type_JavaUtilList);
      this.a.b();
      AEGIFTextMvp.a(this.a, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.gif.giftext.AEGIFTextMvp.3
 * JD-Core Version:    0.7.0.1
 */