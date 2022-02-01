package com.tencent.luggage.ui;

import com.tencent.luggage.wxa.ig.a;
import com.tencent.mm.plugin.appbrand.widget.music.MusicSeekBar;
import com.tencent.mm.plugin.appbrand.widget.music.MusicSeekBar.a;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "seekPosition", "", "onSeekBarChange"}, k=3, mv={1, 1, 16})
final class WxaMusicActivity$b$a
  implements MusicSeekBar.a
{
  WxaMusicActivity$b$a(WxaMusicActivity.b paramb) {}
  
  public final void a(int paramInt)
  {
    a.a(paramInt);
    WxaMusicActivity.b.a(this.a).setProgress(paramInt);
    WxaMusicActivity.b.a(this.a).a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.ui.WxaMusicActivity.b.a
 * JD-Core Version:    0.7.0.1
 */