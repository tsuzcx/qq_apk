package com.tencent.biz.pubaccount.Advertisement.adapter;

import com.tencent.biz.pubaccount.Advertisement.view.VideoCoverView;
import java.util.ArrayList;
import nit;

public class VideoCoverAdapter$1
  implements Runnable
{
  VideoCoverAdapter$1(VideoCoverAdapter paramVideoCoverAdapter) {}
  
  public void run()
  {
    if ((VideoCoverAdapter.a(this.this$0) == null) || (VideoCoverAdapter.a(this.this$0).size() == 0)) {}
    nit localnit;
    do
    {
      return;
      localnit = (nit)VideoCoverAdapter.a(this.this$0).get(0);
    } while ((localnit == null) || (localnit.a == null));
    localnit.a.a(VideoCoverAdapter.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.biz.pubaccount.Advertisement.adapter.VideoCoverAdapter.1
 * JD-Core Version:    0.7.0.1
 */