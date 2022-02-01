package com.tencent.mobileqq.avatar.dynamicavatar;

import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.util.FaceUtil;
import java.io.File;

final class SelectCoverActivity$4
  implements Runnable
{
  SelectCoverActivity$4(SelectCoverActivity paramSelectCoverActivity, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    String str = this.a.G.c;
    if (new File(str).exists())
    {
      DynamicUtils.a(this.b, str, 38, this.a.y, 100);
      FaceUtil.e(str);
      return;
    }
    SelectCoverActivity.a(this.a, 2, HardCodeUtil.a(2131911164), 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.avatar.dynamicavatar.SelectCoverActivity.4
 * JD-Core Version:    0.7.0.1
 */