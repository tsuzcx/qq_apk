package com.tencent.biz.pubaccount.readinjoy.ugc.selectvideo;

import com.tencent.biz.pubaccount.readinjoy.ugc.AlbumUtils.LocalMediaInfo;
import com.tencent.biz.pubaccount.readinjoy.video.videoconverter.VideoConvertUtil;

class SelectVideoPresenter$4
  implements ConditionChecker.ConditionCallback<AlbumUtils.LocalMediaInfo>
{
  SelectVideoPresenter$4(SelectVideoPresenter paramSelectVideoPresenter) {}
  
  public boolean a(AlbumUtils.LocalMediaInfo paramLocalMediaInfo)
  {
    return paramLocalMediaInfo.b <= VideoConvertUtil.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.selectvideo.SelectVideoPresenter.4
 * JD-Core Version:    0.7.0.1
 */