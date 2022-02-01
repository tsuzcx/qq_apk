package com.tencent.biz.pubaccount.readinjoy.common;

import com.tencent.biz.pubaccount.readinjoy.video.CodecReuseHelper;
import com.tencent.biz.pubaccount.readinjoy.video.CodecReuseHelper.Companion;
import com.tencent.biz.pubaccount.readinjoy.viola.so.ViolaSoLoaderManager;
import com.tencent.biz.pubaccount.readinjoy.viola.so.ViolaSoLoaderManager.Companion;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class RIJTabFrameBase$PreloadTaskManager$loadWebRenderSo$1
  implements Runnable
{
  public static final 1 a = new 1();
  
  public final void run()
  {
    ViolaSoLoaderManager.a.a().a();
    CodecReuseHelper.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.common.RIJTabFrameBase.PreloadTaskManager.loadWebRenderSo.1
 * JD-Core Version:    0.7.0.1
 */