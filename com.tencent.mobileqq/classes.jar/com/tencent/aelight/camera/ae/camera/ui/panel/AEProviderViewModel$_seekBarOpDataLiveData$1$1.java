package com.tencent.aelight.camera.ae.camera.ui.panel;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import com.tencent.aelight.camera.aioeditor.capture.data.QIMFilterCategoryItem;
import com.tencent.aelight.camera.log.AEQLog;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/aelight/camera/aioeditor/capture/data/QIMFilterCategoryItem;", "onChanged"}, k=3, mv={1, 1, 16})
final class AEProviderViewModel$_seekBarOpDataLiveData$1$1<T>
  implements Observer<S>
{
  AEProviderViewModel$_seekBarOpDataLiveData$1$1(MediatorLiveData paramMediatorLiveData) {}
  
  public final void a(@Nullable QIMFilterCategoryItem paramQIMFilterCategoryItem)
  {
    AEQLog.b("AEProviderViewModel", "seekBarOpDataChange from selectedFilter");
    this.a.postValue(new SeekBarOpDataWrapper(1, paramQIMFilterCategoryItem, false, 4, null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.panel.AEProviderViewModel._seekBarOpDataLiveData.1.1
 * JD-Core Version:    0.7.0.1
 */