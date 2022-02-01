package com.tencent.biz.pubaccount.readinjoy.ktextension;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/ktextension/IPbParser;", "P", "R", "", "parse", "input", "(Ljava/lang/Object;)Ljava/lang/Object;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public abstract interface IPbParser<P, R>
{
  @Nullable
  public abstract R a(P paramP);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ktextension.IPbParser
 * JD-Core Version:    0.7.0.1
 */