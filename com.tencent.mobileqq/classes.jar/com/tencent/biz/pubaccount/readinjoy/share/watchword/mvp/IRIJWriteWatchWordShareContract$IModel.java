package com.tencent.biz.pubaccount.readinjoy.share.watchword.mvp;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/share/watchword/mvp/IRIJWriteWatchWordShareContract$IModel;", "", "failedToast", "", "getFailedToast", "()Ljava/lang/String;", "successToast", "getSuccessToast", "copyToClipboard", "", "watchWord", "url", "title", "isOpen", "", "type", "", "fetchTopicWatchWord", "topicId", "callback", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "fetchVideoWatchWord", "rowkey", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public abstract interface IRIJWriteWatchWordShareContract$IModel
{
  @NotNull
  public abstract String a();
  
  public abstract void a(@NotNull String paramString1, @NotNull String paramString2, @Nullable String paramString3, @NotNull String paramString4, @Nullable Function3<? super String, ? super String, ? super Boolean, Unit> paramFunction3);
  
  public abstract void a(@NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3, @Nullable Function3<? super String, ? super String, ? super Boolean, Unit> paramFunction3);
  
  public abstract void a(@NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3, boolean paramBoolean, int paramInt);
  
  @NotNull
  public abstract String b();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.share.watchword.mvp.IRIJWriteWatchWordShareContract.IModel
 * JD-Core Version:    0.7.0.1
 */