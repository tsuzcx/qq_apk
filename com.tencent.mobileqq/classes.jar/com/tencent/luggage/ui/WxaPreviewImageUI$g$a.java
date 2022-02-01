package com.tencent.luggage.ui;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "kotlin.jvm.PlatformType", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k=3, mv={1, 1, 16})
@DebugMetadata(c="com.tencent.luggage.ui.WxaPreviewImageUI$requestSaveToDisk$1$toPath$1", f="WxaPreviewImageUI.kt", i={}, l={}, m="invokeSuspend", n={}, s={})
final class WxaPreviewImageUI$g$a
  extends SuspendLambda
  implements Function2<CoroutineScope, Continuation<? super String>, Object>
{
  int a;
  private CoroutineScope c;
  
  WxaPreviewImageUI$g$a(WxaPreviewImageUI.g paramg, Continuation paramContinuation)
  {
    super(2, paramContinuation);
  }
  
  @NotNull
  public final Continuation<Unit> create(@Nullable Object paramObject, @NotNull Continuation<?> paramContinuation)
  {
    Intrinsics.checkParameterIsNotNull(paramContinuation, "completion");
    paramContinuation = new a(this.b, paramContinuation);
    paramContinuation.c = ((CoroutineScope)paramObject);
    return paramContinuation;
  }
  
  public final Object invoke(Object paramObject1, Object paramObject2)
  {
    return ((a)create(paramObject1, (Continuation)paramObject2)).invokeSuspend(Unit.INSTANCE);
  }
  
  /* Error */
  @Nullable
  public final Object invokeSuspend(@NotNull Object paramObject)
  {
    // Byte code:
    //   0: invokestatic 90	kotlin/coroutines/intrinsics/IntrinsicsKt:getCOROUTINE_SUSPENDED	()Ljava/lang/Object;
    //   3: pop
    //   4: aload_0
    //   5: getfield 92	com/tencent/luggage/ui/WxaPreviewImageUI$g$a:a	I
    //   8: ifne +299 -> 307
    //   11: aload_1
    //   12: invokestatic 98	kotlin/ResultKt:throwOnFailure	(Ljava/lang/Object;)V
    //   15: aload_0
    //   16: getfield 65	com/tencent/luggage/ui/WxaPreviewImageUI$g$a:c	Lkotlinx/coroutines/CoroutineScope;
    //   19: astore_1
    //   20: aload_0
    //   21: getfield 43	com/tencent/luggage/ui/WxaPreviewImageUI$g$a:b	Lcom/tencent/luggage/ui/WxaPreviewImageUI$g;
    //   24: getfield 104	com/tencent/luggage/ui/WxaPreviewImageUI$g:d	Landroid/net/Uri;
    //   27: invokevirtual 110	android/net/Uri:toString	()Ljava/lang/String;
    //   30: invokestatic 116	org/apache/commons/io/FilenameUtils:getExtension	(Ljava/lang/String;)Ljava/lang/String;
    //   33: invokestatic 120	com/tencent/luggage/wxa/rc/d:c	(Ljava/lang/String;)Ljava/lang/String;
    //   36: astore 5
    //   38: aload 5
    //   40: checkcast 122	java/lang/CharSequence
    //   43: astore_1
    //   44: iconst_1
    //   45: istore_3
    //   46: aload_1
    //   47: ifnull +20 -> 67
    //   50: aload_1
    //   51: invokeinterface 126 1 0
    //   56: ifne +6 -> 62
    //   59: goto +8 -> 67
    //   62: iconst_0
    //   63: istore_2
    //   64: goto +5 -> 69
    //   67: iconst_1
    //   68: istore_2
    //   69: aload 5
    //   71: astore_1
    //   72: iload_2
    //   73: ifeq +163 -> 236
    //   76: aload_0
    //   77: getfield 43	com/tencent/luggage/ui/WxaPreviewImageUI$g$a:b	Lcom/tencent/luggage/ui/WxaPreviewImageUI$g;
    //   80: getfield 104	com/tencent/luggage/ui/WxaPreviewImageUI$g:d	Landroid/net/Uri;
    //   83: invokestatic 131	com/tencent/luggage/wxa/rt/k:a	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   86: astore_1
    //   87: aconst_null
    //   88: astore 4
    //   90: aload_1
    //   91: ifnull +104 -> 195
    //   94: aload_1
    //   95: checkcast 133	java/io/Closeable
    //   98: astore 7
    //   100: aconst_null
    //   101: checkcast 84	java/lang/Throwable
    //   104: astore 4
    //   106: aload 4
    //   108: astore_1
    //   109: aload 7
    //   111: checkcast 135	java/io/InputStream
    //   114: astore 6
    //   116: aload 4
    //   118: astore_1
    //   119: new 137	android/graphics/BitmapFactory$Options
    //   122: dup
    //   123: invokespecial 140	android/graphics/BitmapFactory$Options:<init>	()V
    //   126: astore 8
    //   128: aload 4
    //   130: astore_1
    //   131: aload 8
    //   133: iconst_1
    //   134: putfield 144	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   137: aload 4
    //   139: astore_1
    //   140: aload 6
    //   142: aconst_null
    //   143: aload 8
    //   145: invokestatic 149	com/tencent/mm/graphics/MMBitmapFactory:a	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   148: pop
    //   149: aload 4
    //   151: astore_1
    //   152: aload 8
    //   154: getfield 153	android/graphics/BitmapFactory$Options:outMimeType	Ljava/lang/String;
    //   157: astore 6
    //   159: aload 7
    //   161: aload 4
    //   163: invokestatic 159	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   166: aload 6
    //   168: astore 4
    //   170: goto +25 -> 195
    //   173: astore 4
    //   175: goto +11 -> 186
    //   178: astore 4
    //   180: aload 4
    //   182: astore_1
    //   183: aload 4
    //   185: athrow
    //   186: aload 7
    //   188: aload_1
    //   189: invokestatic 159	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   192: aload 4
    //   194: athrow
    //   195: aload 4
    //   197: checkcast 122	java/lang/CharSequence
    //   200: astore_1
    //   201: iload_3
    //   202: istore_2
    //   203: aload_1
    //   204: ifnull +19 -> 223
    //   207: aload_1
    //   208: invokeinterface 126 1 0
    //   213: ifne +8 -> 221
    //   216: iload_3
    //   217: istore_2
    //   218: goto +5 -> 223
    //   221: iconst_0
    //   222: istore_2
    //   223: aload 5
    //   225: astore_1
    //   226: iload_2
    //   227: ifne +9 -> 236
    //   230: aload 4
    //   232: invokestatic 161	com/tencent/luggage/wxa/rc/d:d	(Ljava/lang/String;)Ljava/lang/String;
    //   235: astore_1
    //   236: aload_1
    //   237: ifnull +6 -> 243
    //   240: goto +6 -> 246
    //   243: ldc 162
    //   245: astore_1
    //   246: aload_1
    //   247: invokestatic 166	com/tencent/luggage/wxa/rc/b:a	(Ljava/lang/String;)Ljava/lang/String;
    //   250: astore_1
    //   251: new 168	com/tencent/luggage/wxa/rt/i
    //   254: dup
    //   255: aload_1
    //   256: invokespecial 171	com/tencent/luggage/wxa/rt/i:<init>	(Ljava/lang/String;)V
    //   259: invokevirtual 175	com/tencent/luggage/wxa/rt/i:g	()Lcom/tencent/luggage/wxa/rt/i;
    //   262: invokevirtual 179	com/tencent/luggage/wxa/rt/i:u	()Z
    //   265: pop
    //   266: aload_0
    //   267: getfield 43	com/tencent/luggage/ui/WxaPreviewImageUI$g$a:b	Lcom/tencent/luggage/ui/WxaPreviewImageUI$g;
    //   270: getfield 104	com/tencent/luggage/ui/WxaPreviewImageUI$g:d	Landroid/net/Uri;
    //   273: invokevirtual 110	android/net/Uri:toString	()Ljava/lang/String;
    //   276: aload_1
    //   277: invokestatic 182	com/tencent/luggage/wxa/rt/k:b	(Ljava/lang/String;Ljava/lang/String;)J
    //   280: pop2
    //   281: aload_1
    //   282: iconst_0
    //   283: invokestatic 185	com/tencent/luggage/wxa/rt/k:c	(Ljava/lang/String;Z)Ljava/lang/String;
    //   286: aload_0
    //   287: getfield 43	com/tencent/luggage/ui/WxaPreviewImageUI$g$a:b	Lcom/tencent/luggage/ui/WxaPreviewImageUI$g;
    //   290: getfield 188	com/tencent/luggage/ui/WxaPreviewImageUI$g:c	Lcom/tencent/luggage/ui/WxaPreviewImageUI;
    //   293: invokevirtual 194	com/tencent/luggage/ui/WxaPreviewImageUI:getApplicationContext	()Landroid/content/Context;
    //   296: invokestatic 197	com/tencent/luggage/wxa/rc/b:a	(Ljava/lang/String;Landroid/content/Context;)V
    //   299: aload_1
    //   300: ldc 199
    //   302: invokestatic 202	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   305: aload_1
    //   306: areturn
    //   307: new 204	java/lang/IllegalStateException
    //   310: dup
    //   311: ldc 206
    //   313: invokespecial 207	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   316: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	317	0	this	a
    //   0	317	1	paramObject	Object
    //   63	164	2	i	int
    //   45	172	3	j	int
    //   88	81	4	localObject1	Object
    //   173	1	4	localObject2	Object
    //   178	53	4	localThrowable	java.lang.Throwable
    //   36	188	5	str	String
    //   114	53	6	localObject3	Object
    //   98	89	7	localCloseable	java.io.Closeable
    //   126	27	8	localOptions	android.graphics.BitmapFactory.Options
    // Exception table:
    //   from	to	target	type
    //   109	116	173	finally
    //   119	128	173	finally
    //   131	137	173	finally
    //   140	149	173	finally
    //   152	159	173	finally
    //   183	186	173	finally
    //   109	116	178	java/lang/Throwable
    //   119	128	178	java/lang/Throwable
    //   131	137	178	java/lang/Throwable
    //   140	149	178	java/lang/Throwable
    //   152	159	178	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.ui.WxaPreviewImageUI.g.a
 * JD-Core Version:    0.7.0.1
 */