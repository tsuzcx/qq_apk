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
    AEGIFChunkPreviewFragment.a(this.a).a().removeObservers(AEGIFChunkPreviewFragment.a(this.a));
    if (paramRecognizedEmotionBean != null)
    {
      int i = 0;
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("=====");
      ((StringBuilder)localObject1).append(paramRecognizedEmotionBean);
      QLog.d("AEGIFChunkPreviewFragment", 4, new Object[] { "Obtained recognizedEmotion", ((StringBuilder)localObject1).toString() });
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("emo ===");
      ((StringBuilder)localObject1).append(paramRecognizedEmotionBean.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject1).append("text ===");
      ((StringBuilder)localObject1).append(paramRecognizedEmotionBean.jdField_a_of_type_Int);
      ((StringBuilder)localObject1).append("material ====");
      ((StringBuilder)localObject1).append(paramRecognizedEmotionBean.jdField_b_of_type_Int);
      QLog.d("AEGIFChunkPreviewFragment", 4, ((StringBuilder)localObject1).toString());
      if (paramRecognizedEmotionBean.jdField_a_of_type_JavaLangString == null)
      {
        paramRecognizedEmotionBean.jdField_a_of_type_Int = 0;
        paramRecognizedEmotionBean.jdField_b_of_type_Int = 6;
        paramRecognizedEmotionBean.jdField_a_of_type_JavaLangString = "default";
      }
      if ((paramRecognizedEmotionBean.jdField_a_of_type_JavaUtilList != null) && (paramRecognizedEmotionBean.jdField_a_of_type_JavaUtilList.size() == 0)) {
        paramRecognizedEmotionBean.jdField_a_of_type_JavaUtilList.addAll(AEGIFTextMvp.jdField_a_of_type_JavaUtilList);
      }
      Object localObject2;
      if (paramRecognizedEmotionBean.jdField_a_of_type_JavaLangString.equals("default"))
      {
        localObject1 = HardCodeUtil.a(2131700195);
      }
      else
      {
        localObject1 = (String)AEGIFChunkPreviewFragment.a(this.a).get(paramRecognizedEmotionBean.jdField_a_of_type_JavaLangString);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(HardCodeUtil.a(2131700190));
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(HardCodeUtil.a(2131700197));
        localObject1 = ((StringBuilder)localObject2).toString();
      }
      AEGIFChunkPreviewFragment.a(this.a).setText((CharSequence)localObject1);
      while (i < paramRecognizedEmotionBean.jdField_a_of_type_Int)
      {
        localObject1 = new AEGIFPreviewWrapper();
        ((AEGIFPreviewWrapper)localObject1).jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial = null;
        ((AEGIFPreviewWrapper)localObject1).jdField_a_of_type_JavaLangString = ((String)paramRecognizedEmotionBean.jdField_a_of_type_JavaUtilList.get(i % paramRecognizedEmotionBean.jdField_a_of_type_JavaUtilList.size()));
        ((AEGIFPreviewWrapper)localObject1).jdField_b_of_type_Int = 2;
        if (AEGIFChunkPreviewFragment.a(this.a).size() >= AEGIFChunkPreviewFragment.a(this.a)) {
          break;
        }
        AEGIFChunkPreviewFragment.a(this.a).add(localObject1);
        AEGIFChunkPreviewFragment.a(this.a).notifyItemInserted(AEGIFChunkPreviewFragment.a(this.a).size() - 1);
        localObject2 = new MaterialWrapper();
        ((MaterialWrapper)localObject2).jdField_b_of_type_JavaLangString = ((AEGIFPreviewWrapper)localObject1).jdField_a_of_type_JavaLangString;
        i += 1;
        ((MaterialWrapper)localObject2).jdField_a_of_type_Int = i;
        AEGIFChunkPreviewFragment.a(this.a).a((MaterialWrapper)localObject2);
      }
      AEGIFChunkPreviewFragment.a(this.a).a().observe(AEGIFChunkPreviewFragment.a(this.a), new AEGIFChunkPreviewFragment.6.1(this, paramRecognizedEmotionBean));
      AEGIFChunkPreviewFragment.a(this.a, paramRecognizedEmotionBean);
      return;
    }
    QLog.d("AEGIFChunkPreviewFragment", 4, "Recognized emotion bean is null");
    paramRecognizedEmotionBean = new AEGIFPreviewWrapper();
    paramRecognizedEmotionBean.jdField_b_of_type_JavaLangString = "";
    paramRecognizedEmotionBean.jdField_a_of_type_JavaLangString = "";
    paramRecognizedEmotionBean.jdField_b_of_type_Int = 2;
    paramRecognizedEmotionBean.jdField_a_of_type_Int = 11;
    AEGIFChunkPreviewFragment.a(this.a).add(paramRecognizedEmotionBean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.gif.giftext.fragment.AEGIFChunkPreviewFragment.6
 * JD-Core Version:    0.7.0.1
 */