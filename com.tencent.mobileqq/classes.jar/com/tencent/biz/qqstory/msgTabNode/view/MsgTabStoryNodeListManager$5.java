package com.tencent.biz.qqstory.msgTabNode.view;

import android.widget.TextView;
import wyd;
import yuk;
import zpk;

public class MsgTabStoryNodeListManager$5
  implements Runnable
{
  public MsgTabStoryNodeListManager$5(wyd paramwyd) {}
  
  public void run()
  {
    int i = zpk.a(52);
    String str = this.this$0.a.a.getText().toString();
    yuk.a(wyd.b(), "redpoint update, update count = %s->%d", str, Integer.valueOf(i));
    this.this$0.a.a(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.view.MsgTabStoryNodeListManager.5
 * JD-Core Version:    0.7.0.1
 */