package com.tencent.biz.qqstory.msgTabNode.view;

import android.widget.TextView;
import thy;
import veg;
import vzg;

public class MsgTabStoryNodeListManager$5
  implements Runnable
{
  public MsgTabStoryNodeListManager$5(thy paramthy) {}
  
  public void run()
  {
    int i = vzg.a(52);
    String str = this.this$0.a.a.getText().toString();
    veg.a(thy.b(), "redpoint update, update count = %s->%d", str, Integer.valueOf(i));
    this.this$0.a.a(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.view.MsgTabStoryNodeListManager.5
 * JD-Core Version:    0.7.0.1
 */