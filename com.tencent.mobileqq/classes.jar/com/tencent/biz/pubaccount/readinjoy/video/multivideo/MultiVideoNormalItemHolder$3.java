package com.tencent.biz.pubaccount.readinjoy.video.multivideo;

import android.view.ViewGroup;
import bbkx;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyNickNameTextView;
import qxo;
import qya;

public class MultiVideoNormalItemHolder$3
  implements Runnable
{
  public MultiVideoNormalItemHolder$3(qya paramqya) {}
  
  public void run()
  {
    if (this.this$0.b != null)
    {
      int i = qxo.a(this.this$0.a.s).length();
      int j = bbkx.a(12.0F);
      qya.a(this.this$0).setMaxWidth(qya.a(this.this$0).getWidth() - qya.a(this.this$0).getPaddingLeft() - qya.a(this.this$0).getPaddingRight() - i * j - bbkx.a(30.0F));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.multivideo.MultiVideoNormalItemHolder.3
 * JD-Core Version:    0.7.0.1
 */