package com.tencent.aelight.camera.ae.view;

import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import java.util.List;

class TabLayout$2
  implements Runnable
{
  TabLayout$2(TabLayout paramTabLayout, int paramInt) {}
  
  public void run()
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)TabLayout.a(this.this$0).getLayoutParams();
    if (TabLayout.b(this.this$0).size() > this.a) {
      localLayoutParams.setMargins((int)(((TabLayout.TabView)TabLayout.b(this.this$0).get(this.a)).getX() + ((TabLayout.TabView)TabLayout.b(this.this$0).get(this.a)).getWidth() / 2.0F - TabLayout.a(this.this$0).getWidth() / 2.0F), 0, 0, 0);
    } else {
      localLayoutParams.setMargins(((TabLayout.TabView)TabLayout.b(this.this$0).get(0)).getRight() / 2 - TabLayout.a(this.this$0).getWidth() / 2, 0, 0, 0);
    }
    TabLayout.a(this.this$0).setLayoutParams(localLayoutParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.view.TabLayout.2
 * JD-Core Version:    0.7.0.1
 */