package com.tencent.biz.pubaccount.readinjoy.video.multivideo;

import android.view.ViewGroup;
import bdoo;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyNickNameTextView;
import rna;
import rnm;

public class MultiVideoNormalItemHolder$1
  implements Runnable
{
  public MultiVideoNormalItemHolder$1(rnm paramrnm) {}
  
  public void run()
  {
    if (this.this$0.b != null)
    {
      int i = rna.a(this.this$0.a.p).length();
      int j = bdoo.a(12.0F);
      rnm.a(this.this$0).setMaxWidth(rnm.a(this.this$0).getWidth() - rnm.a(this.this$0).getPaddingLeft() - rnm.a(this.this$0).getPaddingRight() - i * j - bdoo.a(30.0F));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.multivideo.MultiVideoNormalItemHolder.1
 * JD-Core Version:    0.7.0.1
 */