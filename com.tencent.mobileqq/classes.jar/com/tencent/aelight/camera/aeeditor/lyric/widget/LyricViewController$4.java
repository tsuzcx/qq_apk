package com.tencent.aelight.camera.aeeditor.lyric.widget;

import android.os.SystemClock;
import android.util.Log;
import com.tencent.weseevideo.editor.sticker.music.lyric.data.Lyric;

class LyricViewController$4
  implements Runnable
{
  LyricViewController$4(LyricViewController paramLyricViewController, int paramInt, boolean paramBoolean) {}
  
  public void run()
  {
    if ((this.this$0.jdField_a_of_type_ComTencentWeseevideoEditorStickerMusicLyricDataLyric != null) && (!this.this$0.jdField_a_of_type_ComTencentWeseevideoEditorStickerMusicLyricDataLyric.isEmpty()))
    {
      this.this$0.jdField_a_of_type_Long = (SystemClock.elapsedRealtime() - this.jdField_a_of_type_Int);
      if ((this.this$0.jdField_a_of_type_Boolean) && (this.this$0.jdField_a_of_type_Int > 0))
      {
        LyricViewController localLyricViewController = this.this$0;
        localLyricViewController.jdField_a_of_type_Long -= this.this$0.jdField_a_of_type_Int;
      }
      LyricViewController.a(this.this$0, this.jdField_a_of_type_Int, this.jdField_a_of_type_Boolean);
      return;
    }
    Log.w("ModuleController", "seek before set lyric");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.lyric.widget.LyricViewController.4
 * JD-Core Version:    0.7.0.1
 */