package com.tencent.biz.pubaccount.readinjoy.viola.so;

import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyWebRenderEngine.LoadLibCallback;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/viola/so/IViolaSoLoader;", "", "isEngineReady", "", "loadLibrary", "", "from", "", "callback", "Lcom/tencent/biz/pubaccount/readinjoy/engine/ReadInJoyWebRenderEngine$LoadLibCallback;", "preLoadViola", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public abstract interface IViolaSoLoader
{
  public abstract void a();
  
  public abstract void a(@Nullable String paramString, @Nullable ReadInJoyWebRenderEngine.LoadLibCallback paramLoadLibCallback);
  
  public abstract boolean a();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.so.IViolaSoLoader
 * JD-Core Version:    0.7.0.1
 */