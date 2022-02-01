package com.tencent.mobileqq.apollo.process.ui.framework;

import com.tencent.mobileqq.apollo.view.FrameGifView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.widget.ActionSheet;

class CmGameFloatView$2
  implements Runnable
{
  CmGameFloatView$2(CmGameFloatView paramCmGameFloatView, boolean paramBoolean) {}
  
  public void run()
  {
    if (CmGameFloatView.a(this.this$0)) {
      if (this.a) {
        if (CmGameFloatView.a(this.this$0).b() == 3) {
          CmGameFloatView.a(this.this$0).b();
        }
      }
    }
    while (CmGameFloatView.b(this.this$0) == -1)
    {
      return;
      CmGameFloatView.a(this.this$0).setImageResource(2130839345);
      return;
      CmGameFloatView.a(this.this$0).c();
      CmGameFloatView.a(this.this$0).setImageResource(2130839343);
      return;
    }
    if (this.a)
    {
      CmGameFloatView.a(this.this$0).updateButton(CmGameFloatView.b(this.this$0), HardCodeUtil.a(2131702125));
      return;
    }
    CmGameFloatView.a(this.this$0).updateButton(CmGameFloatView.b(this.this$0), HardCodeUtil.a(2131702123));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.ui.framework.CmGameFloatView.2
 * JD-Core Version:    0.7.0.1
 */