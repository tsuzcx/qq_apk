package com.tencent.biz.pubaccount.readinjoy.video.multivideo;

import android.view.ViewGroup;
import bbll;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyNickNameTextView;
import qxl;
import qxx;

public class MultiVideoNormalItemHolder$3
  implements Runnable
{
  public MultiVideoNormalItemHolder$3(qxx paramqxx) {}
  
  public void run()
  {
    if (this.this$0.b != null)
    {
      int i = qxl.a(this.this$0.a.s).length();
      int j = bbll.a(12.0F);
      qxx.a(this.this$0).setMaxWidth(qxx.a(this.this$0).getWidth() - qxx.a(this.this$0).getPaddingLeft() - qxx.a(this.this$0).getPaddingRight() - i * j - bbll.a(30.0F));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.multivideo.MultiVideoNormalItemHolder.3
 * JD-Core Version:    0.7.0.1
 */