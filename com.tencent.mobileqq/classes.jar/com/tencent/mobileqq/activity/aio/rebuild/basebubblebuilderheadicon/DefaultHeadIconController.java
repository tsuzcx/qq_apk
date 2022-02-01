package com.tencent.mobileqq.activity.aio.rebuild.basebubblebuilderheadicon;

import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilderUtil;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.vas.avatar.VasAvatarLoader;
import com.tencent.qphone.base.util.QLog;

public class DefaultHeadIconController
  extends BaseDefaultHeadIconController
{
  protected void b()
  {
    int i = this.a.istroop;
    String str = BaseBubbleBuilderUtil.a(this.b, this.a);
    if (i == 1006) {
      i = 11;
    } else {
      i = 1;
    }
    Object localObject = a(i, str);
    VasAvatarLoader localVasAvatarLoader = new VasAvatarLoader(str, -1, "small", this.a.uniseq);
    localVasAvatarLoader.g = ((Drawable)localObject);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("QQ head, uin = ");
      ((StringBuilder)localObject).append(str);
      QLog.d("BaseBubbleBuilder", 2, ((StringBuilder)localObject).toString());
    }
    b(localVasAvatarLoader);
  }
  
  public boolean h()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.basebubblebuilderheadicon.DefaultHeadIconController
 * JD-Core Version:    0.7.0.1
 */