package com.tencent.biz.pubaccount.readinjoy.video.multivideo;

import android.view.ViewGroup;
import bajq;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyNickNameTextView;
import qlj;
import qlv;

public class MultiVideoNormalItemHolder$3
  implements Runnable
{
  public MultiVideoNormalItemHolder$3(qlv paramqlv) {}
  
  public void run()
  {
    if (this.this$0.b != null)
    {
      int i = qlj.a(this.this$0.a.s).length();
      int j = bajq.a(12.0F);
      qlv.a(this.this$0).setMaxWidth(qlv.a(this.this$0).getWidth() - qlv.a(this.this$0).getPaddingLeft() - qlv.a(this.this$0).getPaddingRight() - i * j - bajq.a(30.0F));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.multivideo.MultiVideoNormalItemHolder.3
 * JD-Core Version:    0.7.0.1
 */