package com.tencent.luggage.wxa.cx;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"getLaunchPBFromCGI", "", "rt", "Lcom/tencent/luggage/standalone_ext/Runtime;", "isSync", "", "continuation", "Lkotlin/coroutines/Continuation;", "Lcom/tencent/mm/protocal/protobuf/LaunchWxaAppResponse;"}, k=3, mv={1, 1, 16})
@DebugMetadata(c="com.tencent.luggage.launch.SubProcessLaunchWxaApp", f="SubProcessLaunchWxaApp.kt", i={0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, l={166}, m="getLaunchPBFromCGI", n={"this", "rt", "isSync", "username", "appId", "versionType", "sessionId", "scene", "request", "cgi"}, s={"L$0", "L$1", "Z$0", "L$2", "L$3", "I$0", "L$4", "I$1", "L$5", "L$6"})
final class j$d
  extends ContinuationImpl
{
  int b;
  Object d;
  Object e;
  Object f;
  Object g;
  Object h;
  Object i;
  Object j;
  boolean k;
  int l;
  int m;
  
  j$d(j paramj, Continuation paramContinuation)
  {
    super(paramContinuation);
  }
  
  @Nullable
  public final Object invokeSuspend(@NotNull Object paramObject)
  {
    this.a = paramObject;
    this.b |= 0x80000000;
    return this.c.a(null, false, this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.cx.j.d
 * JD-Core Version:    0.7.0.1
 */