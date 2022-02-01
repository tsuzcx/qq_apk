package com.tencent.biz.pubaccount.readinjoy.ugc.selectvideo;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.ugc.AlbumUtils.LocalMediaInfo;

class SelectVideoPresenter$1
  implements ConditionChecker.ConditionCallback<AlbumUtils.LocalMediaInfo>
{
  SelectVideoPresenter$1(SelectVideoPresenter paramSelectVideoPresenter) {}
  
  public boolean a(AlbumUtils.LocalMediaInfo paramLocalMediaInfo)
  {
    return TextUtils.equals("video/mp4", paramLocalMediaInfo.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.selectvideo.SelectVideoPresenter.1
 * JD-Core Version:    0.7.0.1
 */