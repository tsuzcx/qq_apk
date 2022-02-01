package com.tencent.aelight.camera.ae.camera.ui.flashshow;

import androidx.lifecycle.Observer;
import com.tencent.mobileqq.wink.editor.music.TimeUtils;
import com.tencent.mobileqq.wink.editor.music.adapter.MusicMenuPagerAdapter;
import com.tencent.mobileqq.wink.editor.music.fragments.MusicSelectFragment;
import com.tencent.mobileqq.wink.editor.music.lyric.WinkLyricProgressCalculator;
import com.tencent.mobileqq.wink.editor.music.viewmodel.MusicSourceViewModel;
import com.tencent.mobileqq.wink.editor.music.vo.WinkEditorMusicInfo;
import kotlin.Metadata;
import kotlin.TypeCastException;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Integer;)V"}, k=3, mv={1, 1, 16})
final class AEFlashShowMusicPart$initViewModel$6<T>
  implements Observer<Integer>
{
  AEFlashShowMusicPart$initViewModel$6(AEFlashShowMusicPart paramAEFlashShowMusicPart) {}
  
  public final void a(Integer paramInteger)
  {
    if ((AEFlashShowMusicPart.k(this.a).getItem(0) instanceof MusicSelectFragment))
    {
      long l1 = paramInteger.intValue();
      paramInteger = AEFlashShowMusicPart.a(this.a).i();
      if (paramInteger == null)
      {
        paramInteger = AEFlashShowMusicPart.a(this.a).h();
        if (paramInteger != null) {
          paramInteger = Integer.valueOf(paramInteger.g());
        } else {
          paramInteger = null;
        }
      }
      int i;
      if (paramInteger != null) {
        i = paramInteger.intValue();
      } else {
        i = 0;
      }
      l1 -= i;
      long l2 = TimeUtils.b(l1);
      if (AEFlashShowMusicPart.a(this.a).h() != null) {
        WinkLyricProgressCalculator.a().a(l2, AEFlashShowMusicPart.a(this.a).g());
      }
      paramInteger = AEFlashShowMusicPart.k(this.a).getItem(0);
      if (paramInteger != null)
      {
        ((MusicSelectFragment)paramInteger).a(l1 * 1000);
        return;
      }
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.wink.editor.music.fragments.MusicSelectFragment");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.flashshow.AEFlashShowMusicPart.initViewModel.6
 * JD-Core Version:    0.7.0.1
 */