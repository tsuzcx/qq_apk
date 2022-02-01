package com.tencent.mobileqq.activity.aio.rebuild.basebubblebuilderheadicon;

import com.tencent.mobileqq.activity.aio.coreui.basebubblebuilderheadicon.BaseBubbleBuilderHeadIconController;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.data.ChatMessage;

public class FakeSelfHeadIconController
  extends BaseBubbleBuilderHeadIconController
{
  protected void b()
  {
    b(FaceDrawable.getFaceDrawable(this.b, 1, this.b.getCurrentAccountUin()));
  }
  
  protected void c()
  {
    a(null);
  }
  
  protected void d()
  {
    a(null);
  }
  
  protected void g()
  {
    a(this.a);
  }
  
  public boolean h()
  {
    return this.a.fakeSenderType == 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.basebubblebuilderheadicon.FakeSelfHeadIconController
 * JD-Core Version:    0.7.0.1
 */