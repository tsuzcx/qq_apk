package com.tencent.aelight.camera.ae.camera.ui.flashshow;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.mobileqq.wink.editor.music.viewmodel.AbsWinkMusicPlayerViewModel;
import com.tencent.mobileqq.wink.editor.music.vo.MusicInfoWrapper;
import com.tencent.mobileqq.wink.editor.music.vo.WinkEditorMusicInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "musicInfoWrapper", "Lcom/tencent/mobileqq/wink/editor/music/vo/MusicInfoWrapper;", "kotlin.jvm.PlatformType", "onChanged"}, k=3, mv={1, 1, 16})
final class AEFlashShowMusicPart$initViewModel$7<T>
  implements Observer<MusicInfoWrapper>
{
  AEFlashShowMusicPart$initViewModel$7(AEFlashShowMusicPart paramAEFlashShowMusicPart) {}
  
  public final void a(MusicInfoWrapper paramMusicInfoWrapper)
  {
    AbsWinkMusicPlayerViewModel localAbsWinkMusicPlayerViewModel = AEFlashShowMusicPart.d(this.a);
    Intrinsics.checkExpressionValueIsNotNull(paramMusicInfoWrapper, "musicInfoWrapper");
    localAbsWinkMusicPlayerViewModel.a(paramMusicInfoWrapper);
    Object localObject = paramMusicInfoWrapper.b();
    localAbsWinkMusicPlayerViewModel = null;
    if (localObject == null)
    {
      AEFlashShowMusicPart.l(this.a).a().postValue(new AEFlashShowMusicState(false, null, 2, null));
      return;
    }
    localObject = AEFlashShowMusicPart.l(this.a).a();
    WinkEditorMusicInfo localWinkEditorMusicInfo = paramMusicInfoWrapper.b();
    paramMusicInfoWrapper = localAbsWinkMusicPlayerViewModel;
    if (localWinkEditorMusicInfo != null) {
      paramMusicInfoWrapper = localWinkEditorMusicInfo.e();
    }
    ((MutableLiveData)localObject).postValue(new AEFlashShowMusicState(true, paramMusicInfoWrapper));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.flashshow.AEFlashShowMusicPart.initViewModel.7
 * JD-Core Version:    0.7.0.1
 */