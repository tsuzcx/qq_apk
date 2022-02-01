package androidx.lifecycle;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "T", "Lkotlinx/coroutines/flow/FlowCollector;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k=3, mv={1, 1, 15})
@DebugMetadata(c="androidx.lifecycle.FlowLiveDataConversions$asFlow$1", f="FlowLiveData.kt", i={0, 0, 0, 1, 1, 1, 2, 2, 2, 2}, l={91, 95, 96}, m="invokeSuspend", n={"$this$flow", "channel", "observer", "$this$flow", "channel", "observer", "$this$flow", "channel", "observer", "value"}, s={"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3"})
final class FlowLiveDataConversions$asFlow$1
  extends SuspendLambda
  implements Function2<FlowCollector<? super T>, Continuation<? super Unit>, Object>
{
  Object L$0;
  Object L$1;
  Object L$2;
  Object L$3;
  Object L$4;
  int label;
  private FlowCollector p$;
  
  FlowLiveDataConversions$asFlow$1(LiveData paramLiveData, Continuation paramContinuation)
  {
    super(2, paramContinuation);
  }
  
  @NotNull
  public final Continuation<Unit> create(@Nullable Object paramObject, @NotNull Continuation<?> paramContinuation)
  {
    Intrinsics.checkParameterIsNotNull(paramContinuation, "completion");
    paramContinuation = new 1(this.$this_asFlow, paramContinuation);
    paramContinuation.p$ = ((FlowCollector)paramObject);
    return paramContinuation;
  }
  
  public final Object invoke(Object paramObject1, Object paramObject2)
  {
    return ((1)create(paramObject1, (Continuation)paramObject2)).invokeSuspend(Unit.INSTANCE);
  }
  
  /* Error */
  @Nullable
  public final Object invokeSuspend(@NotNull Object paramObject)
  {
    // Byte code:
    //   0: invokestatic 103	kotlin/coroutines/intrinsics/IntrinsicsKt:getCOROUTINE_SUSPENDED	()Ljava/lang/Object;
    //   3: astore 4
    //   5: aload_0
    //   6: getfield 105	androidx/lifecycle/FlowLiveDataConversions$asFlow$1:label	I
    //   9: istore_2
    //   10: iload_2
    //   11: ifeq +189 -> 200
    //   14: iload_2
    //   15: iconst_1
    //   16: if_icmpeq +149 -> 165
    //   19: iload_2
    //   20: iconst_2
    //   21: if_icmpeq +86 -> 107
    //   24: iload_2
    //   25: iconst_3
    //   26: if_icmpne +71 -> 97
    //   29: aload_0
    //   30: getfield 107	androidx/lifecycle/FlowLiveDataConversions$asFlow$1:L$4	Ljava/lang/Object;
    //   33: checkcast 109	kotlinx/coroutines/channels/ChannelIterator
    //   36: astore 7
    //   38: aload_0
    //   39: getfield 111	androidx/lifecycle/FlowLiveDataConversions$asFlow$1:L$3	Ljava/lang/Object;
    //   42: astore_3
    //   43: aload_0
    //   44: getfield 113	androidx/lifecycle/FlowLiveDataConversions$asFlow$1:L$2	Ljava/lang/Object;
    //   47: checkcast 115	androidx/lifecycle/Observer
    //   50: astore 5
    //   52: aload_0
    //   53: getfield 117	androidx/lifecycle/FlowLiveDataConversions$asFlow$1:L$1	Ljava/lang/Object;
    //   56: checkcast 119	kotlinx/coroutines/channels/Channel
    //   59: astore 9
    //   61: aload_0
    //   62: getfield 121	androidx/lifecycle/FlowLiveDataConversions$asFlow$1:L$0	Ljava/lang/Object;
    //   65: checkcast 78	kotlinx/coroutines/flow/FlowCollector
    //   68: astore 8
    //   70: aload 5
    //   72: astore_3
    //   73: aload_1
    //   74: invokestatic 127	kotlin/ResultKt:throwOnFailure	(Ljava/lang/Object;)V
    //   77: aload_0
    //   78: astore_1
    //   79: aload 4
    //   81: astore 6
    //   83: aload 9
    //   85: astore 4
    //   87: aload 5
    //   89: astore_3
    //   90: aload 8
    //   92: astore 5
    //   94: goto +224 -> 318
    //   97: new 129	java/lang/IllegalStateException
    //   100: dup
    //   101: ldc 131
    //   103: invokespecial 134	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   106: athrow
    //   107: aload_0
    //   108: getfield 111	androidx/lifecycle/FlowLiveDataConversions$asFlow$1:L$3	Ljava/lang/Object;
    //   111: checkcast 109	kotlinx/coroutines/channels/ChannelIterator
    //   114: astore 7
    //   116: aload_0
    //   117: getfield 113	androidx/lifecycle/FlowLiveDataConversions$asFlow$1:L$2	Ljava/lang/Object;
    //   120: checkcast 115	androidx/lifecycle/Observer
    //   123: astore 5
    //   125: aload_0
    //   126: getfield 117	androidx/lifecycle/FlowLiveDataConversions$asFlow$1:L$1	Ljava/lang/Object;
    //   129: checkcast 119	kotlinx/coroutines/channels/Channel
    //   132: astore 8
    //   134: aload_0
    //   135: getfield 121	androidx/lifecycle/FlowLiveDataConversions$asFlow$1:L$0	Ljava/lang/Object;
    //   138: checkcast 78	kotlinx/coroutines/flow/FlowCollector
    //   141: astore 6
    //   143: aload 5
    //   145: astore_3
    //   146: aload_1
    //   147: invokestatic 127	kotlin/ResultKt:throwOnFailure	(Ljava/lang/Object;)V
    //   150: aload_0
    //   151: astore_3
    //   152: aload_1
    //   153: astore 9
    //   155: goto +228 -> 383
    //   158: astore 4
    //   160: aload_0
    //   161: astore_1
    //   162: goto +371 -> 533
    //   165: aload_0
    //   166: getfield 113	androidx/lifecycle/FlowLiveDataConversions$asFlow$1:L$2	Ljava/lang/Object;
    //   169: checkcast 115	androidx/lifecycle/Observer
    //   172: astore 7
    //   174: aload_0
    //   175: getfield 117	androidx/lifecycle/FlowLiveDataConversions$asFlow$1:L$1	Ljava/lang/Object;
    //   178: checkcast 119	kotlinx/coroutines/channels/Channel
    //   181: astore_3
    //   182: aload_0
    //   183: getfield 121	androidx/lifecycle/FlowLiveDataConversions$asFlow$1:L$0	Ljava/lang/Object;
    //   186: checkcast 78	kotlinx/coroutines/flow/FlowCollector
    //   189: astore 5
    //   191: aload_1
    //   192: invokestatic 127	kotlin/ResultKt:throwOnFailure	(Ljava/lang/Object;)V
    //   195: aload_3
    //   196: astore_1
    //   197: goto +94 -> 291
    //   200: aload_1
    //   201: invokestatic 127	kotlin/ResultKt:throwOnFailure	(Ljava/lang/Object;)V
    //   204: aload_0
    //   205: getfield 80	androidx/lifecycle/FlowLiveDataConversions$asFlow$1:p$	Lkotlinx/coroutines/flow/FlowCollector;
    //   208: astore 5
    //   210: iconst_m1
    //   211: invokestatic 140	kotlinx/coroutines/channels/ChannelKt:Channel	(I)Lkotlinx/coroutines/channels/Channel;
    //   214: astore_1
    //   215: new 142	androidx/lifecycle/FlowLiveDataConversions$asFlow$1$observer$1
    //   218: dup
    //   219: aload_1
    //   220: invokespecial 145	androidx/lifecycle/FlowLiveDataConversions$asFlow$1$observer$1:<init>	(Lkotlinx/coroutines/channels/Channel;)V
    //   223: checkcast 115	androidx/lifecycle/Observer
    //   226: astore 7
    //   228: invokestatic 151	kotlinx/coroutines/Dispatchers:getMain	()Lkotlinx/coroutines/MainCoroutineDispatcher;
    //   231: invokevirtual 156	kotlinx/coroutines/MainCoroutineDispatcher:getImmediate	()Lkotlinx/coroutines/MainCoroutineDispatcher;
    //   234: checkcast 158	kotlin/coroutines/CoroutineContext
    //   237: astore_3
    //   238: new 160	androidx/lifecycle/FlowLiveDataConversions$asFlow$1$1
    //   241: dup
    //   242: aload_0
    //   243: aload 7
    //   245: aconst_null
    //   246: invokespecial 163	androidx/lifecycle/FlowLiveDataConversions$asFlow$1$1:<init>	(Landroidx/lifecycle/FlowLiveDataConversions$asFlow$1;Landroidx/lifecycle/Observer;Lkotlin/coroutines/Continuation;)V
    //   249: checkcast 7	kotlin/jvm/functions/Function2
    //   252: astore 6
    //   254: aload_0
    //   255: aload 5
    //   257: putfield 121	androidx/lifecycle/FlowLiveDataConversions$asFlow$1:L$0	Ljava/lang/Object;
    //   260: aload_0
    //   261: aload_1
    //   262: putfield 117	androidx/lifecycle/FlowLiveDataConversions$asFlow$1:L$1	Ljava/lang/Object;
    //   265: aload_0
    //   266: aload 7
    //   268: putfield 113	androidx/lifecycle/FlowLiveDataConversions$asFlow$1:L$2	Ljava/lang/Object;
    //   271: aload_0
    //   272: iconst_1
    //   273: putfield 105	androidx/lifecycle/FlowLiveDataConversions$asFlow$1:label	I
    //   276: aload_3
    //   277: aload 6
    //   279: aload_0
    //   280: invokestatic 169	kotlinx/coroutines/BuildersKt:withContext	(Lkotlin/coroutines/CoroutineContext;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    //   283: aload 4
    //   285: if_acmpne +6 -> 291
    //   288: aload 4
    //   290: areturn
    //   291: aload 7
    //   293: astore_3
    //   294: aload_1
    //   295: invokeinterface 173 1 0
    //   300: astore 8
    //   302: aload 4
    //   304: astore 6
    //   306: aload_1
    //   307: astore 4
    //   309: aload_0
    //   310: astore_1
    //   311: aload 7
    //   313: astore_3
    //   314: aload 8
    //   316: astore 7
    //   318: aload_1
    //   319: aload 5
    //   321: putfield 121	androidx/lifecycle/FlowLiveDataConversions$asFlow$1:L$0	Ljava/lang/Object;
    //   324: aload_1
    //   325: aload 4
    //   327: putfield 117	androidx/lifecycle/FlowLiveDataConversions$asFlow$1:L$1	Ljava/lang/Object;
    //   330: aload_1
    //   331: aload_3
    //   332: putfield 113	androidx/lifecycle/FlowLiveDataConversions$asFlow$1:L$2	Ljava/lang/Object;
    //   335: aload_1
    //   336: aload 7
    //   338: putfield 111	androidx/lifecycle/FlowLiveDataConversions$asFlow$1:L$3	Ljava/lang/Object;
    //   341: aload_1
    //   342: iconst_2
    //   343: putfield 105	androidx/lifecycle/FlowLiveDataConversions$asFlow$1:label	I
    //   346: aload 7
    //   348: aload_1
    //   349: invokeinterface 177 2 0
    //   354: astore 9
    //   356: aload 9
    //   358: aload 6
    //   360: if_acmpne +6 -> 366
    //   363: aload 6
    //   365: areturn
    //   366: aload 4
    //   368: astore 8
    //   370: aload 6
    //   372: astore 4
    //   374: aload 5
    //   376: astore 6
    //   378: aload_3
    //   379: astore 5
    //   381: aload_1
    //   382: astore_3
    //   383: aload 9
    //   385: checkcast 179	java/lang/Boolean
    //   388: invokevirtual 183	java/lang/Boolean:booleanValue	()Z
    //   391: ifeq +90 -> 481
    //   394: aload 7
    //   396: invokeinterface 186 1 0
    //   401: astore_1
    //   402: aload_3
    //   403: aload 6
    //   405: putfield 121	androidx/lifecycle/FlowLiveDataConversions$asFlow$1:L$0	Ljava/lang/Object;
    //   408: aload_3
    //   409: aload 8
    //   411: putfield 117	androidx/lifecycle/FlowLiveDataConversions$asFlow$1:L$1	Ljava/lang/Object;
    //   414: aload_3
    //   415: aload 5
    //   417: putfield 113	androidx/lifecycle/FlowLiveDataConversions$asFlow$1:L$2	Ljava/lang/Object;
    //   420: aload_3
    //   421: aload_1
    //   422: putfield 111	androidx/lifecycle/FlowLiveDataConversions$asFlow$1:L$3	Ljava/lang/Object;
    //   425: aload_3
    //   426: aload 7
    //   428: putfield 107	androidx/lifecycle/FlowLiveDataConversions$asFlow$1:L$4	Ljava/lang/Object;
    //   431: aload_3
    //   432: iconst_3
    //   433: putfield 105	androidx/lifecycle/FlowLiveDataConversions$asFlow$1:label	I
    //   436: aload 6
    //   438: aload_1
    //   439: aload_3
    //   440: invokeinterface 190 3 0
    //   445: astore_1
    //   446: aload_1
    //   447: aload 4
    //   449: if_acmpne +6 -> 455
    //   452: aload 4
    //   454: areturn
    //   455: aload_3
    //   456: astore_1
    //   457: aload 8
    //   459: astore_3
    //   460: aload 4
    //   462: astore 8
    //   464: aload_3
    //   465: astore 4
    //   467: aload 5
    //   469: astore_3
    //   470: aload 6
    //   472: astore 5
    //   474: aload 8
    //   476: astore 6
    //   478: goto -160 -> 318
    //   481: getstatic 195	kotlinx/coroutines/GlobalScope:INSTANCE	Lkotlinx/coroutines/GlobalScope;
    //   484: checkcast 197	kotlinx/coroutines/CoroutineScope
    //   487: invokestatic 151	kotlinx/coroutines/Dispatchers:getMain	()Lkotlinx/coroutines/MainCoroutineDispatcher;
    //   490: invokevirtual 156	kotlinx/coroutines/MainCoroutineDispatcher:getImmediate	()Lkotlinx/coroutines/MainCoroutineDispatcher;
    //   493: checkcast 158	kotlin/coroutines/CoroutineContext
    //   496: aconst_null
    //   497: new 199	androidx/lifecycle/FlowLiveDataConversions$asFlow$1$2
    //   500: dup
    //   501: aload_3
    //   502: aload 5
    //   504: aconst_null
    //   505: invokespecial 200	androidx/lifecycle/FlowLiveDataConversions$asFlow$1$2:<init>	(Landroidx/lifecycle/FlowLiveDataConversions$asFlow$1;Landroidx/lifecycle/Observer;Lkotlin/coroutines/Continuation;)V
    //   508: checkcast 7	kotlin/jvm/functions/Function2
    //   511: iconst_2
    //   512: aconst_null
    //   513: invokestatic 204	kotlinx/coroutines/BuildersKt:launch$default	(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/CoroutineStart;Lkotlin/jvm/functions/Function2;ILjava/lang/Object;)Lkotlinx/coroutines/Job;
    //   516: pop
    //   517: getstatic 94	kotlin/Unit:INSTANCE	Lkotlin/Unit;
    //   520: areturn
    //   521: astore 4
    //   523: aload_3
    //   524: astore_1
    //   525: aload 5
    //   527: astore_3
    //   528: goto +5 -> 533
    //   531: astore 4
    //   533: getstatic 195	kotlinx/coroutines/GlobalScope:INSTANCE	Lkotlinx/coroutines/GlobalScope;
    //   536: checkcast 197	kotlinx/coroutines/CoroutineScope
    //   539: invokestatic 151	kotlinx/coroutines/Dispatchers:getMain	()Lkotlinx/coroutines/MainCoroutineDispatcher;
    //   542: invokevirtual 156	kotlinx/coroutines/MainCoroutineDispatcher:getImmediate	()Lkotlinx/coroutines/MainCoroutineDispatcher;
    //   545: checkcast 158	kotlin/coroutines/CoroutineContext
    //   548: aconst_null
    //   549: new 199	androidx/lifecycle/FlowLiveDataConversions$asFlow$1$2
    //   552: dup
    //   553: aload_1
    //   554: aload_3
    //   555: aconst_null
    //   556: invokespecial 200	androidx/lifecycle/FlowLiveDataConversions$asFlow$1$2:<init>	(Landroidx/lifecycle/FlowLiveDataConversions$asFlow$1;Landroidx/lifecycle/Observer;Lkotlin/coroutines/Continuation;)V
    //   559: checkcast 7	kotlin/jvm/functions/Function2
    //   562: iconst_2
    //   563: aconst_null
    //   564: invokestatic 204	kotlinx/coroutines/BuildersKt:launch$default	(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/CoroutineStart;Lkotlin/jvm/functions/Function2;ILjava/lang/Object;)Lkotlinx/coroutines/Job;
    //   567: pop
    //   568: goto +6 -> 574
    //   571: aload 4
    //   573: athrow
    //   574: goto -3 -> 571
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	577	0	this	1
    //   0	577	1	paramObject	Object
    //   9	18	2	i	int
    //   42	513	3	localObject1	Object
    //   3	83	4	localObject2	Object
    //   158	145	4	localObject3	Object
    //   307	159	4	localObject4	Object
    //   521	1	4	localObject5	Object
    //   531	41	4	localObject6	Object
    //   50	476	5	localObject7	Object
    //   81	396	6	localObject8	Object
    //   36	391	7	localObject9	Object
    //   68	407	8	localObject10	Object
    //   59	325	9	localObject11	Object
    // Exception table:
    //   from	to	target	type
    //   73	77	158	finally
    //   146	150	158	finally
    //   294	302	158	finally
    //   383	446	521	finally
    //   318	356	531	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.lifecycle.FlowLiveDataConversions.asFlow.1
 * JD-Core Version:    0.7.0.1
 */