package com.tencent.image;

import android.os.Handler;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.util.Vector;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;

class URLState$DownloadRunnable
  implements URLDrawableHandler, Runnable
{
  public int flag;
  private final AtomicBoolean mCancelled = new AtomicBoolean();
  public JobQueue mQueue;
  URL mUrl;
  public long postTime;
  
  URLState$DownloadRunnable(URLState paramURLState, URL paramURL)
  {
    this.mUrl = paramURL;
    if (paramURLState.mProtocolDownloader == null) {
      paramURLState = null;
    } else {
      paramURLState = paramURLState.mProtocolDownloader.getQueue(paramURL);
    }
    this.mQueue = paramURLState;
  }
  
  public void cancel()
  {
    this.mCancelled.set(true);
  }
  
  public void doCancel()
  {
    throw new CancellationException();
  }
  
  public boolean isCancelled()
  {
    return this.mCancelled.get();
  }
  
  public void onFileDownloadFailed(int paramInt)
  {
    Vector localVector = URLState.access$400(this.this$0);
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < URLState.access$400(this.this$0).size())
        {
          Object localObject1 = (WeakReference)URLState.access$400(this.this$0).get(i);
          int j;
          if (localObject1 != null)
          {
            localObject1 = (URLState.Callback)((WeakReference)localObject1).get();
            if (localObject1 != null)
            {
              ((URLState.Callback)localObject1).onFileDownloadFailed(paramInt);
            }
            else
            {
              localObject1 = URLState.access$400(this.this$0);
              j = i - 1;
              ((Vector)localObject1).remove(i);
              i = j;
            }
          }
          else
          {
            localObject1 = URLState.access$400(this.this$0);
            j = i - 1;
            ((Vector)localObject1).remove(i);
            i = j;
          }
        }
        else
        {
          return;
        }
      }
      finally
      {
        continue;
        throw localObject2;
        continue;
        i += 1;
      }
    }
  }
  
  public void onFileDownloadStarted()
  {
    Vector localVector = URLState.access$400(this.this$0);
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < URLState.access$400(this.this$0).size())
        {
          Object localObject1 = (WeakReference)URLState.access$400(this.this$0).get(i);
          int j;
          if (localObject1 != null)
          {
            localObject1 = (URLState.Callback)((WeakReference)localObject1).get();
            if (localObject1 != null)
            {
              ((URLState.Callback)localObject1).onFileDownloadStarted();
            }
            else
            {
              localObject1 = URLState.access$400(this.this$0);
              j = i - 1;
              ((Vector)localObject1).remove(i);
              i = j;
            }
          }
          else
          {
            localObject1 = URLState.access$400(this.this$0);
            j = i - 1;
            ((Vector)localObject1).remove(i);
            i = j;
          }
        }
        else
        {
          return;
        }
      }
      finally
      {
        continue;
        throw localObject2;
        continue;
        i += 1;
      }
    }
  }
  
  public void onFileDownloadSucceed(long paramLong)
  {
    Vector localVector = URLState.access$400(this.this$0);
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < URLState.access$400(this.this$0).size())
        {
          Object localObject1 = (WeakReference)URLState.access$400(this.this$0).get(i);
          int j;
          if (localObject1 != null)
          {
            localObject1 = (URLState.Callback)((WeakReference)localObject1).get();
            if (localObject1 != null)
            {
              ((URLState.Callback)localObject1).onFileDownloadSucceed(paramLong);
            }
            else
            {
              localObject1 = URLState.access$400(this.this$0);
              j = i - 1;
              ((Vector)localObject1).remove(i);
              i = j;
            }
          }
          else
          {
            localObject1 = URLState.access$400(this.this$0);
            j = i - 1;
            ((Vector)localObject1).remove(i);
            i = j;
          }
        }
        else
        {
          return;
        }
      }
      finally
      {
        continue;
        throw localObject2;
        continue;
        i += 1;
      }
    }
  }
  
  protected void onProgressUpdate(int paramInt)
  {
    this.this$0.mProgress = paramInt;
    if ((!URLDrawable.sPause) || (this.this$0.mIgnorePause))
    {
      Vector localVector = URLState.access$400(this.this$0);
      int i = 0;
      for (;;)
      {
        try
        {
          if (i < URLState.access$400(this.this$0).size())
          {
            Object localObject1 = (WeakReference)URLState.access$400(this.this$0).get(i);
            int j;
            if (localObject1 != null)
            {
              localObject1 = (URLState.Callback)((WeakReference)localObject1).get();
              if (localObject1 != null)
              {
                ((URLState.Callback)localObject1).onUpdateProgress(paramInt);
              }
              else
              {
                localObject1 = URLState.access$400(this.this$0);
                j = i - 1;
                ((Vector)localObject1).remove(i);
                i = j;
              }
            }
            else
            {
              localObject1 = URLState.access$400(this.this$0);
              j = i - 1;
              ((Vector)localObject1).remove(i);
              i = j;
            }
          }
          else
          {
            return;
          }
        }
        finally
        {
          continue;
          throw localObject2;
          continue;
          i += 1;
        }
      }
    }
  }
  
  public void publishProgress(int paramInt)
  {
    if (paramInt == this.this$0.mProgress) {
      return;
    }
    URLState.access$100().post(new URLState.DownloadRunnable.1(this, paramInt));
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: invokestatic 138	java/lang/System:currentTimeMillis	()J
    //   3: lstore_1
    //   4: new 140	com/tencent/image/URLState$ThreadReportParam
    //   7: dup
    //   8: invokespecial 141	com/tencent/image/URLState$ThreadReportParam:<init>	()V
    //   11: astore 5
    //   13: aload 5
    //   15: lload_1
    //   16: putfield 144	com/tencent/image/URLState$ThreadReportParam:startTime	J
    //   19: aload 5
    //   21: lload_1
    //   22: aload_0
    //   23: getfield 146	com/tencent/image/URLState$DownloadRunnable:postTime	J
    //   26: lsub
    //   27: putfield 147	com/tencent/image/URLState$ThreadReportParam:postTime	J
    //   30: aload 5
    //   32: aload_0
    //   33: getfield 149	com/tencent/image/URLState$DownloadRunnable:flag	I
    //   36: putfield 152	com/tencent/image/URLState$ThreadReportParam:type	I
    //   39: aload 5
    //   41: invokestatic 158	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   44: putfield 162	com/tencent/image/URLState$ThreadReportParam:mThread	Ljava/lang/Thread;
    //   47: getstatic 166	com/tencent/image/URLState:sThreadReportCache	Ljava/util/concurrent/ConcurrentHashMap;
    //   50: aload_0
    //   51: getfield 24	com/tencent/image/URLState$DownloadRunnable:this$0	Lcom/tencent/image/URLState;
    //   54: getfield 170	com/tencent/image/URLState:mUrlStr	Ljava/lang/String;
    //   57: aload 5
    //   59: invokevirtual 176	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   62: pop
    //   63: getstatic 180	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   66: getfield 186	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   69: invokeinterface 191 1 0
    //   74: ifeq +114 -> 188
    //   77: aload_0
    //   78: getfield 146	com/tencent/image/URLState$DownloadRunnable:postTime	J
    //   81: lstore_3
    //   82: getstatic 180	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   85: getfield 186	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   88: astore 5
    //   90: new 193	java/lang/StringBuilder
    //   93: dup
    //   94: invokespecial 194	java/lang/StringBuilder:<init>	()V
    //   97: astore 6
    //   99: aload 6
    //   101: ldc 196
    //   103: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: pop
    //   107: aload 6
    //   109: lload_1
    //   110: lload_3
    //   111: lsub
    //   112: invokevirtual 203	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   115: pop
    //   116: aload 6
    //   118: ldc 205
    //   120: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: pop
    //   124: aload 6
    //   126: aload_0
    //   127: getfield 24	com/tencent/image/URLState$DownloadRunnable:this$0	Lcom/tencent/image/URLState;
    //   130: getfield 170	com/tencent/image/URLState:mUrlStr	Ljava/lang/String;
    //   133: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: pop
    //   137: aload 6
    //   139: ldc 207
    //   141: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: pop
    //   145: aload 6
    //   147: aload_0
    //   148: invokevirtual 209	com/tencent/image/URLState$DownloadRunnable:isCancelled	()Z
    //   151: invokevirtual 212	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   154: pop
    //   155: aload 6
    //   157: ldc 214
    //   159: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: pop
    //   163: aload 6
    //   165: aload_0
    //   166: getfield 149	com/tencent/image/URLState$DownloadRunnable:flag	I
    //   169: invokevirtual 217	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   172: pop
    //   173: aload 5
    //   175: ldc 219
    //   177: iconst_2
    //   178: aload 6
    //   180: invokevirtual 223	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   183: invokeinterface 227 4 0
    //   188: aload_0
    //   189: invokevirtual 209	com/tencent/image/URLState$DownloadRunnable:isCancelled	()Z
    //   192: ifeq +10 -> 202
    //   195: aload_0
    //   196: getfield 24	com/tencent/image/URLState$DownloadRunnable:this$0	Lcom/tencent/image/URLState;
    //   199: invokevirtual 230	com/tencent/image/URLState:onLoadCancelled	()V
    //   202: aload_0
    //   203: getfield 24	com/tencent/image/URLState$DownloadRunnable:this$0	Lcom/tencent/image/URLState;
    //   206: aload_0
    //   207: getfield 34	com/tencent/image/URLState$DownloadRunnable:mUrl	Ljava/net/URL;
    //   210: aload_0
    //   211: invokevirtual 234	com/tencent/image/URLState:loadImage	(Ljava/net/URL;Lcom/tencent/image/URLDrawableHandler;)Ljava/lang/Object;
    //   214: astore 5
    //   216: aload 5
    //   218: getstatic 238	com/tencent/image/URLState:DOWNLOAD_ASYNC	Ljava/lang/Object;
    //   221: if_acmpeq +12 -> 233
    //   224: aload_0
    //   225: getfield 24	com/tencent/image/URLState$DownloadRunnable:this$0	Lcom/tencent/image/URLState;
    //   228: aload 5
    //   230: invokestatic 242	com/tencent/image/URLState:access$000	(Lcom/tencent/image/URLState;Ljava/lang/Object;)V
    //   233: invokestatic 138	java/lang/System:currentTimeMillis	()J
    //   236: lload_1
    //   237: lsub
    //   238: lstore_1
    //   239: lload_1
    //   240: ldc2_w 243
    //   243: lcmp
    //   244: ifle +103 -> 347
    //   247: getstatic 180	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   250: getfield 186	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   253: invokeinterface 191 1 0
    //   258: ifeq +89 -> 347
    //   261: getstatic 180	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   264: getfield 186	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   267: astore 5
    //   269: new 193	java/lang/StringBuilder
    //   272: dup
    //   273: invokespecial 194	java/lang/StringBuilder:<init>	()V
    //   276: astore 6
    //   278: aload 6
    //   280: ldc 246
    //   282: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   285: pop
    //   286: aload 6
    //   288: lload_1
    //   289: invokevirtual 203	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   292: pop
    //   293: aload 6
    //   295: ldc 248
    //   297: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   300: pop
    //   301: aload 6
    //   303: aload_0
    //   304: getfield 24	com/tencent/image/URLState$DownloadRunnable:this$0	Lcom/tencent/image/URLState;
    //   307: getfield 170	com/tencent/image/URLState:mUrlStr	Ljava/lang/String;
    //   310: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   313: pop
    //   314: aload 6
    //   316: ldc 250
    //   318: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   321: pop
    //   322: aload 6
    //   324: aload_0
    //   325: getfield 149	com/tencent/image/URLState$DownloadRunnable:flag	I
    //   328: invokevirtual 217	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   331: pop
    //   332: aload 5
    //   334: ldc 219
    //   336: iconst_2
    //   337: aload 6
    //   339: invokevirtual 223	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   342: invokeinterface 253 4 0
    //   347: getstatic 166	com/tencent/image/URLState:sThreadReportCache	Ljava/util/concurrent/ConcurrentHashMap;
    //   350: aload_0
    //   351: getfield 24	com/tencent/image/URLState$DownloadRunnable:this$0	Lcom/tencent/image/URLState;
    //   354: getfield 170	com/tencent/image/URLState:mUrlStr	Ljava/lang/String;
    //   357: invokevirtual 256	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   360: pop
    //   361: getstatic 180	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   364: getfield 186	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   367: invokeinterface 191 1 0
    //   372: ifeq +269 -> 641
    //   375: getstatic 180	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   378: getfield 186	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   381: astore 5
    //   383: new 193	java/lang/StringBuilder
    //   386: dup
    //   387: invokespecial 194	java/lang/StringBuilder:<init>	()V
    //   390: astore 6
    //   392: aload 6
    //   394: ldc_w 258
    //   397: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   400: pop
    //   401: aload 6
    //   403: lload_1
    //   404: invokevirtual 203	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   407: pop
    //   408: aload 6
    //   410: ldc 248
    //   412: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   415: pop
    //   416: aload 6
    //   418: aload_0
    //   419: getfield 24	com/tencent/image/URLState$DownloadRunnable:this$0	Lcom/tencent/image/URLState;
    //   422: getfield 170	com/tencent/image/URLState:mUrlStr	Ljava/lang/String;
    //   425: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   428: pop
    //   429: aload 6
    //   431: ldc 250
    //   433: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   436: pop
    //   437: aload 6
    //   439: aload_0
    //   440: getfield 149	com/tencent/image/URLState$DownloadRunnable:flag	I
    //   443: invokevirtual 217	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   446: pop
    //   447: aload 5
    //   449: ldc 219
    //   451: iconst_2
    //   452: aload 6
    //   454: invokevirtual 223	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   457: invokeinterface 227 4 0
    //   462: return
    //   463: astore 5
    //   465: goto +177 -> 642
    //   468: astore 5
    //   470: aload_0
    //   471: getfield 24	com/tencent/image/URLState$DownloadRunnable:this$0	Lcom/tencent/image/URLState;
    //   474: aload 5
    //   476: invokestatic 242	com/tencent/image/URLState:access$000	(Lcom/tencent/image/URLState;Ljava/lang/Object;)V
    //   479: invokestatic 138	java/lang/System:currentTimeMillis	()J
    //   482: lload_1
    //   483: lsub
    //   484: lstore_1
    //   485: lload_1
    //   486: ldc2_w 243
    //   489: lcmp
    //   490: ifle +103 -> 593
    //   493: getstatic 180	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   496: getfield 186	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   499: invokeinterface 191 1 0
    //   504: ifeq +89 -> 593
    //   507: getstatic 180	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   510: getfield 186	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   513: astore 5
    //   515: new 193	java/lang/StringBuilder
    //   518: dup
    //   519: invokespecial 194	java/lang/StringBuilder:<init>	()V
    //   522: astore 6
    //   524: aload 6
    //   526: ldc 246
    //   528: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   531: pop
    //   532: aload 6
    //   534: lload_1
    //   535: invokevirtual 203	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   538: pop
    //   539: aload 6
    //   541: ldc 248
    //   543: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   546: pop
    //   547: aload 6
    //   549: aload_0
    //   550: getfield 24	com/tencent/image/URLState$DownloadRunnable:this$0	Lcom/tencent/image/URLState;
    //   553: getfield 170	com/tencent/image/URLState:mUrlStr	Ljava/lang/String;
    //   556: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   559: pop
    //   560: aload 6
    //   562: ldc 250
    //   564: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   567: pop
    //   568: aload 6
    //   570: aload_0
    //   571: getfield 149	com/tencent/image/URLState$DownloadRunnable:flag	I
    //   574: invokevirtual 217	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   577: pop
    //   578: aload 5
    //   580: ldc 219
    //   582: iconst_2
    //   583: aload 6
    //   585: invokevirtual 223	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   588: invokeinterface 253 4 0
    //   593: getstatic 166	com/tencent/image/URLState:sThreadReportCache	Ljava/util/concurrent/ConcurrentHashMap;
    //   596: aload_0
    //   597: getfield 24	com/tencent/image/URLState$DownloadRunnable:this$0	Lcom/tencent/image/URLState;
    //   600: getfield 170	com/tencent/image/URLState:mUrlStr	Ljava/lang/String;
    //   603: invokevirtual 256	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   606: pop
    //   607: getstatic 180	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   610: getfield 186	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   613: invokeinterface 191 1 0
    //   618: ifeq +23 -> 641
    //   621: getstatic 180	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   624: getfield 186	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   627: astore 5
    //   629: new 193	java/lang/StringBuilder
    //   632: dup
    //   633: invokespecial 194	java/lang/StringBuilder:<init>	()V
    //   636: astore 6
    //   638: goto -246 -> 392
    //   641: return
    //   642: invokestatic 138	java/lang/System:currentTimeMillis	()J
    //   645: lload_1
    //   646: lsub
    //   647: lstore_1
    //   648: lload_1
    //   649: ldc2_w 243
    //   652: lcmp
    //   653: ifle +103 -> 756
    //   656: getstatic 180	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   659: getfield 186	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   662: invokeinterface 191 1 0
    //   667: ifeq +89 -> 756
    //   670: getstatic 180	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   673: getfield 186	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   676: astore 6
    //   678: new 193	java/lang/StringBuilder
    //   681: dup
    //   682: invokespecial 194	java/lang/StringBuilder:<init>	()V
    //   685: astore 7
    //   687: aload 7
    //   689: ldc 246
    //   691: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   694: pop
    //   695: aload 7
    //   697: lload_1
    //   698: invokevirtual 203	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   701: pop
    //   702: aload 7
    //   704: ldc 248
    //   706: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   709: pop
    //   710: aload 7
    //   712: aload_0
    //   713: getfield 24	com/tencent/image/URLState$DownloadRunnable:this$0	Lcom/tencent/image/URLState;
    //   716: getfield 170	com/tencent/image/URLState:mUrlStr	Ljava/lang/String;
    //   719: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   722: pop
    //   723: aload 7
    //   725: ldc 250
    //   727: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   730: pop
    //   731: aload 7
    //   733: aload_0
    //   734: getfield 149	com/tencent/image/URLState$DownloadRunnable:flag	I
    //   737: invokevirtual 217	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   740: pop
    //   741: aload 6
    //   743: ldc 219
    //   745: iconst_2
    //   746: aload 7
    //   748: invokevirtual 223	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   751: invokeinterface 253 4 0
    //   756: getstatic 166	com/tencent/image/URLState:sThreadReportCache	Ljava/util/concurrent/ConcurrentHashMap;
    //   759: aload_0
    //   760: getfield 24	com/tencent/image/URLState$DownloadRunnable:this$0	Lcom/tencent/image/URLState;
    //   763: getfield 170	com/tencent/image/URLState:mUrlStr	Ljava/lang/String;
    //   766: invokevirtual 256	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   769: pop
    //   770: getstatic 180	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   773: getfield 186	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   776: invokeinterface 191 1 0
    //   781: ifeq +90 -> 871
    //   784: getstatic 180	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   787: getfield 186	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   790: astore 6
    //   792: new 193	java/lang/StringBuilder
    //   795: dup
    //   796: invokespecial 194	java/lang/StringBuilder:<init>	()V
    //   799: astore 7
    //   801: aload 7
    //   803: ldc_w 258
    //   806: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   809: pop
    //   810: aload 7
    //   812: lload_1
    //   813: invokevirtual 203	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   816: pop
    //   817: aload 7
    //   819: ldc 248
    //   821: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   824: pop
    //   825: aload 7
    //   827: aload_0
    //   828: getfield 24	com/tencent/image/URLState$DownloadRunnable:this$0	Lcom/tencent/image/URLState;
    //   831: getfield 170	com/tencent/image/URLState:mUrlStr	Ljava/lang/String;
    //   834: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   837: pop
    //   838: aload 7
    //   840: ldc 250
    //   842: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   845: pop
    //   846: aload 7
    //   848: aload_0
    //   849: getfield 149	com/tencent/image/URLState$DownloadRunnable:flag	I
    //   852: invokevirtual 217	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   855: pop
    //   856: aload 6
    //   858: ldc 219
    //   860: iconst_2
    //   861: aload 7
    //   863: invokevirtual 223	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   866: invokeinterface 227 4 0
    //   871: goto +6 -> 877
    //   874: aload 5
    //   876: athrow
    //   877: goto -3 -> 874
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	880	0	this	DownloadRunnable
    //   3	810	1	l1	long
    //   81	30	3	l2	long
    //   11	437	5	localObject1	Object
    //   463	1	5	localObject2	Object
    //   468	7	5	localThrowable	java.lang.Throwable
    //   513	362	5	localILog	com.tencent.image.api.ILog
    //   97	760	6	localObject3	Object
    //   685	177	7	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   63	188	463	finally
    //   188	202	463	finally
    //   202	233	463	finally
    //   470	479	463	finally
    //   63	188	468	java/lang/Throwable
    //   188	202	468	java/lang/Throwable
    //   202	233	468	java/lang/Throwable
  }
  
  public String toString()
  {
    String str = this.mUrl.toString();
    int j = str.length();
    int i = 60;
    if (60 >= j) {
      i = str.length();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("URLD_");
    localStringBuilder.append(str.substring(0, i));
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.image.URLState.DownloadRunnable
 * JD-Core Version:    0.7.0.1
 */