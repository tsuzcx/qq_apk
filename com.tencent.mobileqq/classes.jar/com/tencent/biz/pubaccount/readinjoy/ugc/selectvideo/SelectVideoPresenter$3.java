package com.tencent.biz.pubaccount.readinjoy.ugc.selectvideo;

import com.tencent.biz.pubaccount.readinjoy.ugc.AlbumUtils.LocalMediaInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class SelectVideoPresenter$3
  implements ConditionChecker.ConditionCallback<AlbumUtils.LocalMediaInfo>
{
  SelectVideoPresenter$3(SelectVideoPresenter paramSelectVideoPresenter) {}
  
  public boolean a(AlbumUtils.LocalMediaInfo paramLocalMediaInfo)
  {
    try
    {
      paramLocalMediaInfo = new File(paramLocalMediaInfo.b);
      if (paramLocalMediaInfo.isFile())
      {
        boolean bool = paramLocalMediaInfo.exists();
        if (bool) {
          return true;
        }
      }
      return false;
    }
    catch (Throwable paramLocalMediaInfo)
    {
      QLog.e("RIJUGC.SelectVideoPresenter", 1, "SelectVideoPresenter check error, file not found", paramLocalMediaInfo);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.selectvideo.SelectVideoPresenter.3
 * JD-Core Version:    0.7.0.1
 */