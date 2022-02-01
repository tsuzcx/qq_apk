package com.tencent.biz.qqstory.playvideo.playerwidget;

import android.app.Activity;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaScanner.OnMediaInfoScannerListener;

class BottomVideoInfoWidget$8
  implements MediaScanner.OnMediaInfoScannerListener
{
  BottomVideoInfoWidget$8(BottomVideoInfoWidget paramBottomVideoInfoWidget, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, LocalMediaInfo paramLocalMediaInfo) {}
  
  public void onMediaInfoChanged(LocalMediaInfo paramLocalMediaInfo, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetBottomVideoInfoWidget.b().runOnUiThread(new BottomVideoInfoWidget.8.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.playerwidget.BottomVideoInfoWidget.8
 * JD-Core Version:    0.7.0.1
 */