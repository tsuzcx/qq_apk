package com.tencent.mobileqq.avatar.dynamicavatar;

import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.util.FaceUtil;
import java.io.File;

final class SelectCoverActivity$5
  implements Runnable
{
  SelectCoverActivity$5(SelectCoverActivity paramSelectCoverActivity, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    String str = this.a.G.b;
    if (new File(str).exists())
    {
      DynamicUtils.a(this.b, str, 37, this.a.y, 200);
      FaceUtil.e(str);
      return;
    }
    SelectCoverActivity.a(this.a, 2, HardCodeUtil.a(2131911171), 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.avatar.dynamicavatar.SelectCoverActivity.5
 * JD-Core Version:    0.7.0.1
 */