package com.tencent.biz.pubaccount.readinjoy.ugc.selectvideo;

import com.tencent.biz.pubaccount.readinjoy.ugc.AlbumUtils.LocalMediaInfo;

class SelectVideoPresenter$2
  implements ConditionChecker.ConditionCallback<AlbumUtils.LocalMediaInfo>
{
  SelectVideoPresenter$2(SelectVideoPresenter paramSelectVideoPresenter) {}
  
  public boolean a(AlbumUtils.LocalMediaInfo paramLocalMediaInfo)
  {
    return paramLocalMediaInfo.d >= 5000L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.selectvideo.SelectVideoPresenter.2
 * JD-Core Version:    0.7.0.1
 */