package com.tencent.mobileqq.activity.aio.anim;

import android.view.View;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richstatus.RichStatusEditText;
import com.tencent.mobileqq.vas.SignatureTemplateConfig;
import com.tencent.mobileqq.vas.SignatureTemplateInfo.DynamicItem;
import com.tencent.mobileqq.vas.ui.VipPngPlayAnimationDrawable;
import com.tencent.widget.ListView;
import mqq.os.MqqHandler;

class SigTlpAnimation$2
  implements Runnable
{
  SigTlpAnimation$2(SigTlpAnimation paramSigTlpAnimation, String paramString1, String paramString2) {}
  
  public void run()
  {
    if (!this.a.equals(this.this$0.d))
    {
      Object localObject = this.this$0;
      ((SigTlpAnimation)localObject).d = this.a;
      localObject = SignatureTemplateConfig.a(((SigTlpAnimation)localObject).g, this.b);
      if (!this.this$0.a((String)localObject)) {
        return;
      }
      localObject = this.this$0.p;
      String[] arrayOfString = this.this$0.e;
      int i;
      if (this.this$0.i.h != 0) {
        i = this.this$0.i.h;
      } else {
        i = 50;
      }
      ((VipPngPlayAnimationDrawable)localObject).a(arrayOfString, i);
      this.this$0.p.b(103);
      if ((this.this$0.h == null) || (!(this.this$0.h instanceof RichStatusEditText)))
      {
        localObject = this.this$0.p;
        if (this.this$0.i.g != 0) {
          i = this.this$0.i.g;
        } else {
          i = 3;
        }
        ((VipPngPlayAnimationDrawable)localObject).A = i;
      }
      localObject = this.this$0;
      ((SigTlpAnimation)localObject).o = new View(((SigTlpAnimation)localObject).b.getContext());
      ThreadManager.getUIHandler().post(new SigTlpAnimation.2.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.SigTlpAnimation.2
 * JD-Core Version:    0.7.0.1
 */