package com.tencent.biz.qqstory.msgTabNode.view;

import android.widget.TextView;
import vzt;
import xvv;
import yqg;

public class MsgTabStoryNodeListManager$5
  implements Runnable
{
  public MsgTabStoryNodeListManager$5(vzt paramvzt) {}
  
  public void run()
  {
    int i = yqg.a(52);
    String str = this.this$0.a.a.getText().toString();
    xvv.a(vzt.b(), "redpoint update, update count = %s->%d", str, Integer.valueOf(i));
    this.this$0.a.a(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.view.MsgTabStoryNodeListManager.5
 * JD-Core Version:    0.7.0.1
 */