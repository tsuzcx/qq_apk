package com.tencent.biz.pubaccount.readinjoy.pts.nativemodule;

import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.pts.nativemodule.IPTSAllInOneJump;
import com.tencent.qphone.base.util.QLog;

public class PTSAllInOneJumpModule
  implements IPTSAllInOneJump
{
  public void allInOneJump(String paramString)
  {
    QLog.i("PTSAllInOneJumpModule", 1, "[allInOneJump], url = " + paramString);
    if (BaseActivity.sTopActivity != null) {
      ReadInJoyUtils.a(BaseActivity.sTopActivity, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.pts.nativemodule.PTSAllInOneJumpModule
 * JD-Core Version:    0.7.0.1
 */