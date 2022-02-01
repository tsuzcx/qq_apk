package com.tencent.luggage.wxa.em;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.cx.s.a;
import com.tencent.luggage.wxa.cx.t;
import com.tencent.luggage.wxa.cx.t.c;
import com.tencent.luggage.wxa.eo.a;
import com.tencent.luggage.wxa.iu.d.b;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import java.util.concurrent.atomic.AtomicBoolean;

class d$3$1
  implements s.a
{
  private final AtomicBoolean c = new AtomicBoolean(false);
  
  d$3$1(d.3 param3, d.b paramb) {}
  
  private void a(String paramString)
  {
    if ((!this.c.getAndSet(true)) && (!d.3.a(this.b).get()))
    {
      o.d("Luggage.STANDALONE.Runtime", "|runProfiled| WxaLaunchPrepareProcess.invokeProcessReady(%s), appId:%s, ts:%d, hash:%d", new Object[] { paramString, this.b.a.aa(), Long.valueOf(af.d()), Integer.valueOf(this.a.hashCode()) });
      this.a.g();
    }
  }
  
  /* Error */
  public void a(com.tencent.luggage.wxa.do.d paramd)
  {
    // Byte code:
    //   0: ldc 48
    //   2: ldc 95
    //   4: iconst_2
    //   5: anewarray 4	java/lang/Object
    //   8: dup
    //   9: iconst_0
    //   10: aload_0
    //   11: getfield 16	com/tencent/luggage/wxa/em/d$3$1:b	Lcom/tencent/luggage/wxa/em/d$3;
    //   14: getfield 53	com/tencent/luggage/wxa/em/d$3:a	Lcom/tencent/luggage/wxa/em/d;
    //   17: invokevirtual 59	com/tencent/luggage/wxa/em/d:aa	()Ljava/lang/String;
    //   20: aastore
    //   21: dup
    //   22: iconst_1
    //   23: invokestatic 65	com/tencent/luggage/wxa/qz/af:d	()J
    //   26: invokestatic 71	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   29: aastore
    //   30: invokestatic 85	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   33: aload_1
    //   34: ifnull +545 -> 579
    //   37: aload_0
    //   38: getfield 16	com/tencent/luggage/wxa/em/d$3$1:b	Lcom/tencent/luggage/wxa/em/d$3;
    //   41: invokestatic 42	com/tencent/luggage/wxa/em/d$3:a	(Lcom/tencent/luggage/wxa/em/d$3;)Ljava/util/concurrent/atomic/AtomicBoolean;
    //   44: invokevirtual 46	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   47: ifne +532 -> 579
    //   50: aload_0
    //   51: getfield 16	com/tencent/luggage/wxa/em/d$3$1:b	Lcom/tencent/luggage/wxa/em/d$3;
    //   54: getfield 53	com/tencent/luggage/wxa/em/d$3:a	Lcom/tencent/luggage/wxa/em/d;
    //   57: invokevirtual 59	com/tencent/luggage/wxa/em/d:aa	()Ljava/lang/String;
    //   60: getstatic 101	com/tencent/luggage/wxa/oy/a:m	Lcom/tencent/luggage/wxa/nk/b;
    //   63: invokestatic 106	com/tencent/mm/plugin/appbrand/keylogger/d:b	(Ljava/lang/String;Lcom/tencent/luggage/wxa/nk/b;)V
    //   66: aload_0
    //   67: getfield 16	com/tencent/luggage/wxa/em/d$3$1:b	Lcom/tencent/luggage/wxa/em/d$3;
    //   70: getfield 53	com/tencent/luggage/wxa/em/d$3:a	Lcom/tencent/luggage/wxa/em/d;
    //   73: invokevirtual 59	com/tencent/luggage/wxa/em/d:aa	()Ljava/lang/String;
    //   76: getstatic 109	com/tencent/luggage/wxa/oy/a:k	Lcom/tencent/luggage/wxa/nk/b;
    //   79: invokestatic 106	com/tencent/mm/plugin/appbrand/keylogger/d:b	(Ljava/lang/String;Lcom/tencent/luggage/wxa/nk/b;)V
    //   82: aload_0
    //   83: getfield 16	com/tencent/luggage/wxa/em/d$3$1:b	Lcom/tencent/luggage/wxa/em/d$3;
    //   86: getfield 53	com/tencent/luggage/wxa/em/d$3:a	Lcom/tencent/luggage/wxa/em/d;
    //   89: invokevirtual 59	com/tencent/luggage/wxa/em/d:aa	()Ljava/lang/String;
    //   92: getstatic 112	com/tencent/luggage/wxa/oy/a:s	Lcom/tencent/luggage/wxa/nk/b;
    //   95: invokestatic 114	com/tencent/mm/plugin/appbrand/keylogger/d:a	(Ljava/lang/String;Lcom/tencent/luggage/wxa/nk/b;)V
    //   98: aload_0
    //   99: getfield 16	com/tencent/luggage/wxa/em/d$3$1:b	Lcom/tencent/luggage/wxa/em/d$3;
    //   102: getfield 53	com/tencent/luggage/wxa/em/d$3:a	Lcom/tencent/luggage/wxa/em/d;
    //   105: invokevirtual 118	com/tencent/luggage/wxa/em/d:at	()Ljava/util/Collection;
    //   108: aload_1
    //   109: invokeinterface 124 2 0
    //   114: pop
    //   115: aload_0
    //   116: getfield 16	com/tencent/luggage/wxa/em/d$3$1:b	Lcom/tencent/luggage/wxa/em/d$3;
    //   119: getfield 53	com/tencent/luggage/wxa/em/d$3:a	Lcom/tencent/luggage/wxa/em/d;
    //   122: invokevirtual 118	com/tencent/luggage/wxa/em/d:at	()Ljava/util/Collection;
    //   125: aload_1
    //   126: getfield 129	com/tencent/luggage/wxa/do/d:g	Lcom/tencent/luggage/wxa/on/b;
    //   129: invokeinterface 124 2 0
    //   134: pop
    //   135: aload_0
    //   136: getfield 16	com/tencent/luggage/wxa/em/d$3$1:b	Lcom/tencent/luggage/wxa/em/d$3;
    //   139: getfield 53	com/tencent/luggage/wxa/em/d$3:a	Lcom/tencent/luggage/wxa/em/d;
    //   142: invokevirtual 118	com/tencent/luggage/wxa/em/d:at	()Ljava/util/Collection;
    //   145: new 131	com/tencent/luggage/wxa/on/d
    //   148: dup
    //   149: aload_1
    //   150: getfield 135	com/tencent/luggage/wxa/do/d:h	Ljava/util/HashMap;
    //   153: invokespecial 138	com/tencent/luggage/wxa/on/d:<init>	(Ljava/util/HashMap;)V
    //   156: invokeinterface 124 2 0
    //   161: pop
    //   162: getstatic 144	java/util/Locale:ENGLISH	Ljava/util/Locale;
    //   165: ldc 146
    //   167: iconst_1
    //   168: anewarray 4	java/lang/Object
    //   171: dup
    //   172: iconst_0
    //   173: aload_0
    //   174: getfield 16	com/tencent/luggage/wxa/em/d$3$1:b	Lcom/tencent/luggage/wxa/em/d$3;
    //   177: getfield 53	com/tencent/luggage/wxa/em/d$3:a	Lcom/tencent/luggage/wxa/em/d;
    //   180: invokevirtual 59	com/tencent/luggage/wxa/em/d:aa	()Ljava/lang/String;
    //   183: aastore
    //   184: invokestatic 152	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   187: new 154	com/tencent/luggage/wxa/em/d$3$1$1
    //   190: dup
    //   191: aload_0
    //   192: invokespecial 157	com/tencent/luggage/wxa/em/d$3$1$1:<init>	(Lcom/tencent/luggage/wxa/em/d$3$1;)V
    //   195: invokestatic 162	com/tencent/luggage/wxa/ef/d:a	(Ljava/lang/String;Ljava/lang/Runnable;)Ljava/lang/String;
    //   198: pop
    //   199: aload_0
    //   200: getfield 16	com/tencent/luggage/wxa/em/d$3$1:b	Lcom/tencent/luggage/wxa/em/d$3;
    //   203: getfield 53	com/tencent/luggage/wxa/em/d$3:a	Lcom/tencent/luggage/wxa/em/d;
    //   206: new 164	com/tencent/luggage/wxa/on/c
    //   209: dup
    //   210: aload_0
    //   211: getfield 16	com/tencent/luggage/wxa/em/d$3$1:b	Lcom/tencent/luggage/wxa/em/d$3;
    //   214: getfield 53	com/tencent/luggage/wxa/em/d$3:a	Lcom/tencent/luggage/wxa/em/d;
    //   217: iconst_0
    //   218: iconst_0
    //   219: invokespecial 167	com/tencent/luggage/wxa/on/c:<init>	(Lcom/tencent/luggage/wxa/iu/d;IZ)V
    //   222: invokestatic 170	com/tencent/luggage/wxa/em/d:a	(Lcom/tencent/luggage/wxa/em/d;Lcom/tencent/luggage/wxa/on/c;)V
    //   225: aload_0
    //   226: getfield 16	com/tencent/luggage/wxa/em/d$3$1:b	Lcom/tencent/luggage/wxa/em/d$3;
    //   229: getfield 53	com/tencent/luggage/wxa/em/d$3:a	Lcom/tencent/luggage/wxa/em/d;
    //   232: invokestatic 173	com/tencent/luggage/wxa/em/d:a	(Lcom/tencent/luggage/wxa/em/d;)V
    //   235: getstatic 144	java/util/Locale:ENGLISH	Ljava/util/Locale;
    //   238: ldc 175
    //   240: iconst_1
    //   241: anewarray 4	java/lang/Object
    //   244: dup
    //   245: iconst_0
    //   246: aload_0
    //   247: getfield 16	com/tencent/luggage/wxa/em/d$3$1:b	Lcom/tencent/luggage/wxa/em/d$3;
    //   250: getfield 53	com/tencent/luggage/wxa/em/d$3:a	Lcom/tencent/luggage/wxa/em/d;
    //   253: invokevirtual 59	com/tencent/luggage/wxa/em/d:aa	()Ljava/lang/String;
    //   256: aastore
    //   257: invokestatic 152	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   260: new 177	com/tencent/luggage/wxa/em/d$3$1$2
    //   263: dup
    //   264: aload_0
    //   265: invokespecial 178	com/tencent/luggage/wxa/em/d$3$1$2:<init>	(Lcom/tencent/luggage/wxa/em/d$3$1;)V
    //   268: invokestatic 162	com/tencent/luggage/wxa/ef/d:a	(Ljava/lang/String;Ljava/lang/Runnable;)Ljava/lang/String;
    //   271: pop
    //   272: aload_0
    //   273: getfield 16	com/tencent/luggage/wxa/em/d$3$1:b	Lcom/tencent/luggage/wxa/em/d$3;
    //   276: getfield 53	com/tencent/luggage/wxa/em/d$3:a	Lcom/tencent/luggage/wxa/em/d;
    //   279: invokevirtual 59	com/tencent/luggage/wxa/em/d:aa	()Ljava/lang/String;
    //   282: getstatic 112	com/tencent/luggage/wxa/oy/a:s	Lcom/tencent/luggage/wxa/nk/b;
    //   285: invokestatic 106	com/tencent/mm/plugin/appbrand/keylogger/d:b	(Ljava/lang/String;Lcom/tencent/luggage/wxa/nk/b;)V
    //   288: aload_0
    //   289: getfield 16	com/tencent/luggage/wxa/em/d$3$1:b	Lcom/tencent/luggage/wxa/em/d$3;
    //   292: getfield 53	com/tencent/luggage/wxa/em/d$3:a	Lcom/tencent/luggage/wxa/em/d;
    //   295: invokevirtual 181	com/tencent/luggage/wxa/em/d:O	()V
    //   298: ldc 48
    //   300: ldc 183
    //   302: iconst_2
    //   303: anewarray 4	java/lang/Object
    //   306: dup
    //   307: iconst_0
    //   308: aload_0
    //   309: getfield 16	com/tencent/luggage/wxa/em/d$3$1:b	Lcom/tencent/luggage/wxa/em/d$3;
    //   312: getfield 53	com/tencent/luggage/wxa/em/d$3:a	Lcom/tencent/luggage/wxa/em/d;
    //   315: invokevirtual 59	com/tencent/luggage/wxa/em/d:aa	()Ljava/lang/String;
    //   318: aastore
    //   319: dup
    //   320: iconst_1
    //   321: invokestatic 65	com/tencent/luggage/wxa/qz/af:d	()J
    //   324: invokestatic 71	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   327: aastore
    //   328: invokestatic 85	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   331: aload_0
    //   332: getfield 16	com/tencent/luggage/wxa/em/d$3$1:b	Lcom/tencent/luggage/wxa/em/d$3;
    //   335: getfield 53	com/tencent/luggage/wxa/em/d$3:a	Lcom/tencent/luggage/wxa/em/d;
    //   338: new 185	com/tencent/luggage/wxa/em/d$3$1$3
    //   341: dup
    //   342: aload_0
    //   343: invokespecial 186	com/tencent/luggage/wxa/em/d$3$1$3:<init>	(Lcom/tencent/luggage/wxa/em/d$3$1;)V
    //   346: invokevirtual 189	com/tencent/luggage/wxa/em/d:d	(Ljava/lang/Runnable;)V
    //   349: ldc 48
    //   351: ldc 191
    //   353: iconst_2
    //   354: anewarray 4	java/lang/Object
    //   357: dup
    //   358: iconst_0
    //   359: aload_0
    //   360: getfield 16	com/tencent/luggage/wxa/em/d$3$1:b	Lcom/tencent/luggage/wxa/em/d$3;
    //   363: getfield 53	com/tencent/luggage/wxa/em/d$3:a	Lcom/tencent/luggage/wxa/em/d;
    //   366: invokevirtual 59	com/tencent/luggage/wxa/em/d:aa	()Ljava/lang/String;
    //   369: aastore
    //   370: dup
    //   371: iconst_1
    //   372: invokestatic 65	com/tencent/luggage/wxa/qz/af:d	()J
    //   375: invokestatic 71	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   378: aastore
    //   379: invokestatic 85	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   382: getstatic 196	com/tencent/luggage/wxa/cx/t:a	Lcom/tencent/luggage/wxa/cx/t;
    //   385: aload_0
    //   386: getfield 16	com/tencent/luggage/wxa/em/d$3$1:b	Lcom/tencent/luggage/wxa/em/d$3;
    //   389: getfield 53	com/tencent/luggage/wxa/em/d$3:a	Lcom/tencent/luggage/wxa/em/d;
    //   392: invokevirtual 200	com/tencent/luggage/wxa/em/d:G	()Lcom/tencent/luggage/wxa/eo/a;
    //   395: invokevirtual 205	com/tencent/luggage/wxa/eo/a:i	()Ljava/lang/String;
    //   398: getstatic 210	com/tencent/luggage/wxa/cx/t$c:c	Lcom/tencent/luggage/wxa/cx/t$c;
    //   401: invokevirtual 213	com/tencent/luggage/wxa/cx/t:a	(Ljava/lang/String;Lcom/tencent/luggage/wxa/cx/t$c;)V
    //   404: return
    //   405: astore_1
    //   406: goto +116 -> 522
    //   409: astore_1
    //   410: aload_0
    //   411: getfield 16	com/tencent/luggage/wxa/em/d$3$1:b	Lcom/tencent/luggage/wxa/em/d$3;
    //   414: getfield 53	com/tencent/luggage/wxa/em/d$3:a	Lcom/tencent/luggage/wxa/em/d;
    //   417: invokevirtual 216	com/tencent/luggage/wxa/em/d:au	()Z
    //   420: ifne +34 -> 454
    //   423: aload_0
    //   424: getfield 16	com/tencent/luggage/wxa/em/d$3$1:b	Lcom/tencent/luggage/wxa/em/d$3;
    //   427: getfield 53	com/tencent/luggage/wxa/em/d$3:a	Lcom/tencent/luggage/wxa/em/d;
    //   430: invokevirtual 219	com/tencent/luggage/wxa/em/d:av	()Z
    //   433: ifne +21 -> 454
    //   436: aload_0
    //   437: getfield 16	com/tencent/luggage/wxa/em/d$3$1:b	Lcom/tencent/luggage/wxa/em/d$3;
    //   440: invokestatic 42	com/tencent/luggage/wxa/em/d$3:a	(Lcom/tencent/luggage/wxa/em/d$3;)Ljava/util/concurrent/atomic/AtomicBoolean;
    //   443: invokevirtual 46	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   446: ifeq +6 -> 452
    //   449: goto +5 -> 454
    //   452: aload_1
    //   453: athrow
    //   454: ldc 48
    //   456: aload_1
    //   457: ldc 221
    //   459: iconst_0
    //   460: anewarray 4	java/lang/Object
    //   463: invokestatic 224	com/tencent/luggage/wxa/qz/o:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   466: ldc 48
    //   468: ldc 191
    //   470: iconst_2
    //   471: anewarray 4	java/lang/Object
    //   474: dup
    //   475: iconst_0
    //   476: aload_0
    //   477: getfield 16	com/tencent/luggage/wxa/em/d$3$1:b	Lcom/tencent/luggage/wxa/em/d$3;
    //   480: getfield 53	com/tencent/luggage/wxa/em/d$3:a	Lcom/tencent/luggage/wxa/em/d;
    //   483: invokevirtual 59	com/tencent/luggage/wxa/em/d:aa	()Ljava/lang/String;
    //   486: aastore
    //   487: dup
    //   488: iconst_1
    //   489: invokestatic 65	com/tencent/luggage/wxa/qz/af:d	()J
    //   492: invokestatic 71	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   495: aastore
    //   496: invokestatic 85	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   499: getstatic 196	com/tencent/luggage/wxa/cx/t:a	Lcom/tencent/luggage/wxa/cx/t;
    //   502: aload_0
    //   503: getfield 16	com/tencent/luggage/wxa/em/d$3$1:b	Lcom/tencent/luggage/wxa/em/d$3;
    //   506: getfield 53	com/tencent/luggage/wxa/em/d$3:a	Lcom/tencent/luggage/wxa/em/d;
    //   509: invokevirtual 200	com/tencent/luggage/wxa/em/d:G	()Lcom/tencent/luggage/wxa/eo/a;
    //   512: invokevirtual 205	com/tencent/luggage/wxa/eo/a:i	()Ljava/lang/String;
    //   515: getstatic 210	com/tencent/luggage/wxa/cx/t$c:c	Lcom/tencent/luggage/wxa/cx/t$c;
    //   518: invokevirtual 213	com/tencent/luggage/wxa/cx/t:a	(Ljava/lang/String;Lcom/tencent/luggage/wxa/cx/t$c;)V
    //   521: return
    //   522: ldc 48
    //   524: ldc 191
    //   526: iconst_2
    //   527: anewarray 4	java/lang/Object
    //   530: dup
    //   531: iconst_0
    //   532: aload_0
    //   533: getfield 16	com/tencent/luggage/wxa/em/d$3$1:b	Lcom/tencent/luggage/wxa/em/d$3;
    //   536: getfield 53	com/tencent/luggage/wxa/em/d$3:a	Lcom/tencent/luggage/wxa/em/d;
    //   539: invokevirtual 59	com/tencent/luggage/wxa/em/d:aa	()Ljava/lang/String;
    //   542: aastore
    //   543: dup
    //   544: iconst_1
    //   545: invokestatic 65	com/tencent/luggage/wxa/qz/af:d	()J
    //   548: invokestatic 71	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   551: aastore
    //   552: invokestatic 85	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   555: getstatic 196	com/tencent/luggage/wxa/cx/t:a	Lcom/tencent/luggage/wxa/cx/t;
    //   558: aload_0
    //   559: getfield 16	com/tencent/luggage/wxa/em/d$3$1:b	Lcom/tencent/luggage/wxa/em/d$3;
    //   562: getfield 53	com/tencent/luggage/wxa/em/d$3:a	Lcom/tencent/luggage/wxa/em/d;
    //   565: invokevirtual 200	com/tencent/luggage/wxa/em/d:G	()Lcom/tencent/luggage/wxa/eo/a;
    //   568: invokevirtual 205	com/tencent/luggage/wxa/eo/a:i	()Ljava/lang/String;
    //   571: getstatic 210	com/tencent/luggage/wxa/cx/t$c:c	Lcom/tencent/luggage/wxa/cx/t$c;
    //   574: invokevirtual 213	com/tencent/luggage/wxa/cx/t:a	(Ljava/lang/String;Lcom/tencent/luggage/wxa/cx/t$c;)V
    //   577: aload_1
    //   578: athrow
    //   579: aload_0
    //   580: getfield 16	com/tencent/luggage/wxa/em/d$3$1:b	Lcom/tencent/luggage/wxa/em/d$3;
    //   583: invokestatic 42	com/tencent/luggage/wxa/em/d$3:a	(Lcom/tencent/luggage/wxa/em/d$3;)Ljava/util/concurrent/atomic/AtomicBoolean;
    //   586: invokevirtual 46	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   589: ifne +59 -> 648
    //   592: ldc 48
    //   594: ldc 226
    //   596: iconst_3
    //   597: anewarray 4	java/lang/Object
    //   600: dup
    //   601: iconst_0
    //   602: aload_0
    //   603: getfield 16	com/tencent/luggage/wxa/em/d$3$1:b	Lcom/tencent/luggage/wxa/em/d$3;
    //   606: getfield 53	com/tencent/luggage/wxa/em/d$3:a	Lcom/tencent/luggage/wxa/em/d;
    //   609: invokevirtual 59	com/tencent/luggage/wxa/em/d:aa	()Ljava/lang/String;
    //   612: aastore
    //   613: dup
    //   614: iconst_1
    //   615: invokestatic 65	com/tencent/luggage/wxa/qz/af:d	()J
    //   618: invokestatic 71	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   621: aastore
    //   622: dup
    //   623: iconst_2
    //   624: aload_0
    //   625: getfield 18	com/tencent/luggage/wxa/em/d$3$1:a	Lcom/tencent/luggage/wxa/iu/d$b;
    //   628: invokevirtual 75	java/lang/Object:hashCode	()I
    //   631: invokestatic 80	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   634: aastore
    //   635: invokestatic 228	com/tencent/luggage/wxa/qz/o:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   638: aload_0
    //   639: getfield 16	com/tencent/luggage/wxa/em/d$3$1:b	Lcom/tencent/luggage/wxa/em/d$3;
    //   642: getfield 53	com/tencent/luggage/wxa/em/d$3:a	Lcom/tencent/luggage/wxa/em/d;
    //   645: invokevirtual 231	com/tencent/luggage/wxa/em/d:E	()V
    //   648: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	649	0	this	1
    //   0	649	1	paramd	com.tencent.luggage.wxa.do.d
    // Exception table:
    //   from	to	target	type
    //   98	349	405	finally
    //   410	449	405	finally
    //   452	454	405	finally
    //   454	466	405	finally
    //   98	349	409	java/lang/NullPointerException
  }
  
  public void a(@NonNull Throwable paramThrowable)
  {
    if (!d.3.a(this.b).get())
    {
      t.a.a(this.b.a.G().i(), t.c.d);
      this.b.a.E();
      if (!TextUtils.isEmpty(paramThrowable.getMessage())) {
        this.b.a.d(new d.3.1.4(this, paramThrowable));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.em.d.3.1
 * JD-Core Version:    0.7.0.1
 */