package com.tencent.component.network.downloader.impl;

import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.utils.thread.Future;
import com.tencent.component.network.utils.thread.FutureListener;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class DownloaderImpl$1
  implements FutureListener<DownloadResult>
{
  DownloaderImpl$1(DownloaderImpl paramDownloaderImpl, DownloadTask paramDownloadTask) {}
  
  public void onFutureBegin(Future<DownloadResult> arg1)
  {
    if (this.val$task.mOriginalIsHttp2) {
      DownloaderImpl.access$108();
    } else {
      DownloaderImpl.access$208();
    }
    synchronized (DownloaderImpl.access$300(this.this$0).obtaionLock(this.val$task.getUrl()))
    {
      synchronized (DownloaderImpl.access$400(this.this$0))
      {
        WeakReference localWeakReference1 = new WeakReference(this.val$task);
        Object localObject4 = (List)DownloaderImpl.access$500(this.this$0).get(this.val$task.getUrl());
        if (localObject4 == null)
        {
          localObject4 = new ArrayList();
          ((List)localObject4).add(localWeakReference1);
          DownloaderImpl.access$500(this.this$0).put(this.val$task.getUrl(), localObject4);
        }
        else
        {
          int j = 1;
          Iterator localIterator = ((List)localObject4).iterator();
          WeakReference localWeakReference2;
          do
          {
            i = j;
            if (!localIterator.hasNext()) {
              break;
            }
            localWeakReference2 = (WeakReference)localIterator.next();
          } while ((localWeakReference2 == null) || ((DownloadTask)localWeakReference2.get() != this.val$task));
          int i = 0;
          if (i != 0) {
            ((List)localObject4).add(localWeakReference1);
          }
        }
        return;
      }
    }
    for (;;)
    {
      throw localObject2;
    }
  }
  
  /* Error */
  public void onFutureDone(Future<DownloadResult> paramFuture)
  {
    // Byte code:
    //   0: invokestatic 110	com/tencent/component/network/module/base/QDLog:isDebugEnable	()Z
    //   3: ifeq +43 -> 46
    //   6: new 112	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 113	java/lang/StringBuilder:<init>	()V
    //   13: astore 12
    //   15: aload 12
    //   17: ldc 115
    //   19: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: pop
    //   23: aload 12
    //   25: aload_0
    //   26: getfield 17	com/tencent/component/network/downloader/impl/DownloaderImpl$1:val$task	Lcom/tencent/component/network/downloader/impl/DownloadTask;
    //   29: invokevirtual 46	com/tencent/component/network/downloader/impl/DownloadTask:getUrl	()Ljava/lang/String;
    //   32: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: pop
    //   36: ldc 121
    //   38: aload 12
    //   40: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   43: invokestatic 128	com/tencent/component/network/module/base/QDLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   46: aload_0
    //   47: getfield 17	com/tencent/component/network/downloader/impl/DownloaderImpl$1:val$task	Lcom/tencent/component/network/downloader/impl/DownloadTask;
    //   50: getfield 29	com/tencent/component/network/downloader/impl/DownloadTask:mOriginalIsHttp2	Z
    //   53: ifeq +10 -> 63
    //   56: invokestatic 131	com/tencent/component/network/downloader/impl/DownloaderImpl:access$110	()I
    //   59: pop
    //   60: goto +7 -> 67
    //   63: invokestatic 134	com/tencent/component/network/downloader/impl/DownloaderImpl:access$210	()I
    //   66: pop
    //   67: aload_0
    //   68: getfield 17	com/tencent/component/network/downloader/impl/DownloaderImpl$1:val$task	Lcom/tencent/component/network/downloader/impl/DownloadTask;
    //   71: invokevirtual 137	com/tencent/component/network/downloader/impl/DownloadTask:getUrlKey	()Ljava/lang/String;
    //   74: astore 19
    //   76: aload_0
    //   77: getfield 15	com/tencent/component/network/downloader/impl/DownloaderImpl$1:this$0	Lcom/tencent/component/network/downloader/impl/DownloaderImpl;
    //   80: invokestatic 141	com/tencent/component/network/downloader/impl/DownloaderImpl:access$600	(Lcom/tencent/component/network/downloader/impl/DownloaderImpl;)Ljava/util/HashMap;
    //   83: astore 12
    //   85: aload 12
    //   87: monitorenter
    //   88: aload_0
    //   89: getfield 15	com/tencent/component/network/downloader/impl/DownloaderImpl$1:this$0	Lcom/tencent/component/network/downloader/impl/DownloaderImpl;
    //   92: invokestatic 141	com/tencent/component/network/downloader/impl/DownloaderImpl:access$600	(Lcom/tencent/component/network/downloader/impl/DownloaderImpl;)Ljava/util/HashMap;
    //   95: aload 19
    //   97: invokevirtual 146	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   100: pop
    //   101: aload 12
    //   103: monitorexit
    //   104: aload_1
    //   105: invokeinterface 149 1 0
    //   110: checkcast 151	com/tencent/component/network/downloader/DownloadResult
    //   113: astore 13
    //   115: invokestatic 110	com/tencent/component/network/module/base/QDLog:isDebugEnable	()Z
    //   118: ifeq +124 -> 242
    //   121: aload 13
    //   123: ifnull +112 -> 235
    //   126: ldc2_w 152
    //   129: lstore 7
    //   131: aload 13
    //   133: invokevirtual 156	com/tencent/component/network/downloader/DownloadResult:getPath	()Ljava/lang/String;
    //   136: ifnull +20 -> 156
    //   139: new 158	java/io/File
    //   142: dup
    //   143: aload 13
    //   145: invokevirtual 156	com/tencent/component/network/downloader/DownloadResult:getPath	()Ljava/lang/String;
    //   148: invokespecial 161	java/io/File:<init>	(Ljava/lang/String;)V
    //   151: invokevirtual 165	java/io/File:length	()J
    //   154: lstore 7
    //   156: new 112	java/lang/StringBuilder
    //   159: dup
    //   160: invokespecial 113	java/lang/StringBuilder:<init>	()V
    //   163: astore 12
    //   165: aload 12
    //   167: ldc 167
    //   169: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: pop
    //   173: aload 12
    //   175: aload 13
    //   177: invokevirtual 171	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   180: invokevirtual 176	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   183: invokevirtual 179	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   186: pop
    //   187: aload 12
    //   189: ldc 181
    //   191: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: pop
    //   195: aload 12
    //   197: aload 13
    //   199: invokevirtual 156	com/tencent/component/network/downloader/DownloadResult:getPath	()Ljava/lang/String;
    //   202: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: pop
    //   206: aload 12
    //   208: ldc 183
    //   210: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: pop
    //   214: aload 12
    //   216: lload 7
    //   218: invokevirtual 186	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   221: pop
    //   222: ldc 121
    //   224: aload 12
    //   226: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   229: invokestatic 128	com/tencent/component/network/module/base/QDLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   232: goto +10 -> 242
    //   235: ldc 121
    //   237: ldc 188
    //   239: invokestatic 128	com/tencent/component/network/module/base/QDLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   242: aload 13
    //   244: ifnull +41 -> 285
    //   247: aload 13
    //   249: invokevirtual 192	com/tencent/component/network/downloader/DownloadResult:getReport	()Lcom/tencent/component/network/downloader/DownloadReport;
    //   252: astore 12
    //   254: aload 13
    //   256: invokevirtual 171	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   259: astore 14
    //   261: aload 12
    //   263: ifnull +22 -> 285
    //   266: aload 14
    //   268: ifnull +17 -> 285
    //   271: aload 12
    //   273: aload 14
    //   275: aload_0
    //   276: getfield 17	com/tencent/component/network/downloader/impl/DownloaderImpl$1:val$task	Lcom/tencent/component/network/downloader/impl/DownloadTask;
    //   279: getfield 29	com/tencent/component/network/downloader/impl/DownloadTask:mOriginalIsHttp2	Z
    //   282: invokestatic 196	com/tencent/component/network/downloader/impl/DownloaderImpl:access$700	(Lcom/tencent/component/network/downloader/DownloadReport;Lcom/tencent/component/network/downloader/DownloadResult$Status;Z)V
    //   285: invokestatic 201	java/lang/System:currentTimeMillis	()J
    //   288: pop2
    //   289: aload_0
    //   290: getfield 15	com/tencent/component/network/downloader/impl/DownloaderImpl$1:this$0	Lcom/tencent/component/network/downloader/impl/DownloaderImpl;
    //   293: invokestatic 42	com/tencent/component/network/downloader/impl/DownloaderImpl:access$300	(Lcom/tencent/component/network/downloader/impl/DownloaderImpl;)Lcom/tencent/component/network/downloader/impl/DownloaderImpl$LockManager;
    //   296: aload_0
    //   297: getfield 17	com/tencent/component/network/downloader/impl/DownloaderImpl$1:val$task	Lcom/tencent/component/network/downloader/impl/DownloadTask;
    //   300: invokevirtual 46	com/tencent/component/network/downloader/impl/DownloadTask:getUrl	()Ljava/lang/String;
    //   303: invokevirtual 52	com/tencent/component/network/downloader/impl/DownloaderImpl$LockManager:obtaionLock	(Ljava/lang/String;)Ljava/lang/Object;
    //   306: astore 12
    //   308: aload 12
    //   310: monitorenter
    //   311: aload 13
    //   313: astore 15
    //   315: aload 12
    //   317: astore 18
    //   319: aload_0
    //   320: getfield 15	com/tencent/component/network/downloader/impl/DownloaderImpl$1:this$0	Lcom/tencent/component/network/downloader/impl/DownloaderImpl;
    //   323: invokestatic 56	com/tencent/component/network/downloader/impl/DownloaderImpl:access$400	(Lcom/tencent/component/network/downloader/impl/DownloaderImpl;)Ljava/lang/Object;
    //   326: astore 17
    //   328: aload 13
    //   330: astore 15
    //   332: aload 12
    //   334: astore 18
    //   336: aload 17
    //   338: monitorenter
    //   339: aload_0
    //   340: getfield 15	com/tencent/component/network/downloader/impl/DownloaderImpl$1:this$0	Lcom/tencent/component/network/downloader/impl/DownloaderImpl;
    //   343: invokestatic 65	com/tencent/component/network/downloader/impl/DownloaderImpl:access$500	(Lcom/tencent/component/network/downloader/impl/DownloaderImpl;)Ljava/util/Map;
    //   346: aload_0
    //   347: getfield 17	com/tencent/component/network/downloader/impl/DownloaderImpl$1:val$task	Lcom/tencent/component/network/downloader/impl/DownloadTask;
    //   350: invokevirtual 46	com/tencent/component/network/downloader/impl/DownloadTask:getUrl	()Ljava/lang/String;
    //   353: invokeinterface 204 2 0
    //   358: istore 11
    //   360: aconst_null
    //   361: astore 16
    //   363: iload 11
    //   365: ifeq +131 -> 496
    //   368: aload_0
    //   369: getfield 15	com/tencent/component/network/downloader/impl/DownloaderImpl$1:this$0	Lcom/tencent/component/network/downloader/impl/DownloaderImpl;
    //   372: invokestatic 65	com/tencent/component/network/downloader/impl/DownloaderImpl:access$500	(Lcom/tencent/component/network/downloader/impl/DownloaderImpl;)Ljava/util/Map;
    //   375: aload_0
    //   376: getfield 17	com/tencent/component/network/downloader/impl/DownloaderImpl$1:val$task	Lcom/tencent/component/network/downloader/impl/DownloadTask;
    //   379: invokevirtual 46	com/tencent/component/network/downloader/impl/DownloadTask:getUrl	()Ljava/lang/String;
    //   382: invokeinterface 71 2 0
    //   387: checkcast 73	java/util/List
    //   390: astore 15
    //   392: aload 15
    //   394: ifnull +102 -> 496
    //   397: aload 15
    //   399: invokeinterface 88 1 0
    //   404: astore 18
    //   406: aload 18
    //   408: invokeinterface 94 1 0
    //   413: ifeq +2576 -> 2989
    //   416: aload 18
    //   418: invokeinterface 98 1 0
    //   423: checkcast 58	java/lang/ref/WeakReference
    //   426: astore 14
    //   428: aload 14
    //   430: ifnull -24 -> 406
    //   433: aload 14
    //   435: invokevirtual 100	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   438: checkcast 25	com/tencent/component/network/downloader/impl/DownloadTask
    //   441: aload_0
    //   442: getfield 17	com/tencent/component/network/downloader/impl/DownloaderImpl$1:val$task	Lcom/tencent/component/network/downloader/impl/DownloadTask;
    //   445: if_acmpne -39 -> 406
    //   448: goto +3 -> 451
    //   451: aload 14
    //   453: ifnull +43 -> 496
    //   456: aload 15
    //   458: aload 14
    //   460: invokeinterface 206 2 0
    //   465: pop
    //   466: aload 15
    //   468: invokeinterface 209 1 0
    //   473: ifgt +23 -> 496
    //   476: aload_0
    //   477: getfield 15	com/tencent/component/network/downloader/impl/DownloaderImpl$1:this$0	Lcom/tencent/component/network/downloader/impl/DownloaderImpl;
    //   480: invokestatic 65	com/tencent/component/network/downloader/impl/DownloaderImpl:access$500	(Lcom/tencent/component/network/downloader/impl/DownloaderImpl;)Ljava/util/Map;
    //   483: aload_0
    //   484: getfield 17	com/tencent/component/network/downloader/impl/DownloaderImpl$1:val$task	Lcom/tencent/component/network/downloader/impl/DownloadTask;
    //   487: invokevirtual 46	com/tencent/component/network/downloader/impl/DownloadTask:getUrl	()Ljava/lang/String;
    //   490: invokeinterface 210 2 0
    //   495: pop
    //   496: aload 17
    //   498: monitorexit
    //   499: aload 13
    //   501: ifnull +308 -> 809
    //   504: aload 13
    //   506: astore 15
    //   508: aload 12
    //   510: astore 18
    //   512: aload 13
    //   514: invokevirtual 171	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   517: invokevirtual 213	com/tencent/component/network/downloader/DownloadResult$Status:isRetrying	()Z
    //   520: ifeq +289 -> 809
    //   523: aload 13
    //   525: astore 15
    //   527: aload 12
    //   529: astore 18
    //   531: invokestatic 110	com/tencent/component/network/module/base/QDLog:isDebugEnable	()Z
    //   534: ifeq +91 -> 625
    //   537: aload 13
    //   539: astore 15
    //   541: aload 12
    //   543: astore 18
    //   545: new 112	java/lang/StringBuilder
    //   548: dup
    //   549: invokespecial 113	java/lang/StringBuilder:<init>	()V
    //   552: astore 14
    //   554: aload 13
    //   556: astore 15
    //   558: aload 12
    //   560: astore 18
    //   562: aload 14
    //   564: ldc 167
    //   566: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   569: pop
    //   570: aload 13
    //   572: astore 15
    //   574: aload 12
    //   576: astore 18
    //   578: aload 14
    //   580: aload_0
    //   581: getfield 17	com/tencent/component/network/downloader/impl/DownloaderImpl$1:val$task	Lcom/tencent/component/network/downloader/impl/DownloadTask;
    //   584: invokevirtual 46	com/tencent/component/network/downloader/impl/DownloadTask:getUrl	()Ljava/lang/String;
    //   587: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   590: pop
    //   591: aload 13
    //   593: astore 15
    //   595: aload 12
    //   597: astore 18
    //   599: aload 14
    //   601: ldc 215
    //   603: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   606: pop
    //   607: aload 13
    //   609: astore 15
    //   611: aload 12
    //   613: astore 18
    //   615: ldc 121
    //   617: aload 14
    //   619: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   622: invokestatic 128	com/tencent/component/network/module/base/QDLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   625: aload 13
    //   627: ifnull +143 -> 770
    //   630: aload_1
    //   631: invokeinterface 218 1 0
    //   636: ifne +134 -> 770
    //   639: aload_0
    //   640: getfield 15	com/tencent/component/network/downloader/impl/DownloaderImpl$1:this$0	Lcom/tencent/component/network/downloader/impl/DownloaderImpl;
    //   643: invokestatic 222	com/tencent/component/network/downloader/impl/DownloaderImpl:access$1300	(Lcom/tencent/component/network/downloader/impl/DownloaderImpl;)Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   646: ifnull +28 -> 674
    //   649: aload_0
    //   650: getfield 15	com/tencent/component/network/downloader/impl/DownloaderImpl$1:this$0	Lcom/tencent/component/network/downloader/impl/DownloaderImpl;
    //   653: invokestatic 225	com/tencent/component/network/downloader/impl/DownloaderImpl:access$1400	(Lcom/tencent/component/network/downloader/impl/DownloaderImpl;)Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   656: aload 13
    //   658: invokevirtual 226	com/tencent/component/network/downloader/DownloadResult:getUrl	()Ljava/lang/String;
    //   661: aload 13
    //   663: invokevirtual 171	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   666: invokevirtual 176	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   669: invokeinterface 232 3 0
    //   674: aload 13
    //   676: invokevirtual 171	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   679: invokevirtual 176	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   682: ifne +13 -> 695
    //   685: aload_0
    //   686: getfield 15	com/tencent/component/network/downloader/impl/DownloaderImpl$1:this$0	Lcom/tencent/component/network/downloader/impl/DownloaderImpl;
    //   689: invokestatic 235	com/tencent/component/network/downloader/impl/DownloaderImpl:access$1500	(Lcom/tencent/component/network/downloader/impl/DownloaderImpl;)Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   692: ifnonnull +78 -> 770
    //   695: aload 13
    //   697: invokevirtual 156	com/tencent/component/network/downloader/DownloadResult:getPath	()Ljava/lang/String;
    //   700: invokestatic 241	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   703: ifne +67 -> 770
    //   706: new 158	java/io/File
    //   709: dup
    //   710: aload 13
    //   712: invokevirtual 156	com/tencent/component/network/downloader/DownloadResult:getPath	()Ljava/lang/String;
    //   715: invokespecial 161	java/io/File:<init>	(Ljava/lang/String;)V
    //   718: invokestatic 247	com/tencent/component/network/utils/FileUtils:delete	(Ljava/io/File;)V
    //   721: goto +49 -> 770
    //   724: astore_1
    //   725: aload_0
    //   726: getfield 15	com/tencent/component/network/downloader/impl/DownloaderImpl$1:this$0	Lcom/tencent/component/network/downloader/impl/DownloaderImpl;
    //   729: invokestatic 42	com/tencent/component/network/downloader/impl/DownloaderImpl:access$300	(Lcom/tencent/component/network/downloader/impl/DownloaderImpl;)Lcom/tencent/component/network/downloader/impl/DownloaderImpl$LockManager;
    //   732: aload_0
    //   733: getfield 17	com/tencent/component/network/downloader/impl/DownloaderImpl$1:val$task	Lcom/tencent/component/network/downloader/impl/DownloadTask;
    //   736: invokevirtual 46	com/tencent/component/network/downloader/impl/DownloadTask:getUrl	()Ljava/lang/String;
    //   739: invokevirtual 250	com/tencent/component/network/downloader/impl/DownloaderImpl$LockManager:releaseLock	(Ljava/lang/String;)V
    //   742: aload_1
    //   743: athrow
    //   744: aload_0
    //   745: getfield 15	com/tencent/component/network/downloader/impl/DownloaderImpl$1:this$0	Lcom/tencent/component/network/downloader/impl/DownloaderImpl;
    //   748: invokestatic 42	com/tencent/component/network/downloader/impl/DownloaderImpl:access$300	(Lcom/tencent/component/network/downloader/impl/DownloaderImpl;)Lcom/tencent/component/network/downloader/impl/DownloaderImpl$LockManager;
    //   751: astore_1
    //   752: aload_0
    //   753: getfield 17	com/tencent/component/network/downloader/impl/DownloaderImpl$1:val$task	Lcom/tencent/component/network/downloader/impl/DownloadTask;
    //   756: invokevirtual 46	com/tencent/component/network/downloader/impl/DownloadTask:getUrl	()Ljava/lang/String;
    //   759: astore 13
    //   761: aload_1
    //   762: aload 13
    //   764: invokevirtual 250	com/tencent/component/network/downloader/impl/DownloaderImpl$LockManager:releaseLock	(Ljava/lang/String;)V
    //   767: goto +23 -> 790
    //   770: aload_0
    //   771: getfield 15	com/tencent/component/network/downloader/impl/DownloaderImpl$1:this$0	Lcom/tencent/component/network/downloader/impl/DownloaderImpl;
    //   774: invokestatic 42	com/tencent/component/network/downloader/impl/DownloaderImpl:access$300	(Lcom/tencent/component/network/downloader/impl/DownloaderImpl;)Lcom/tencent/component/network/downloader/impl/DownloaderImpl$LockManager;
    //   777: astore_1
    //   778: aload_0
    //   779: getfield 17	com/tencent/component/network/downloader/impl/DownloaderImpl$1:val$task	Lcom/tencent/component/network/downloader/impl/DownloadTask;
    //   782: invokevirtual 46	com/tencent/component/network/downloader/impl/DownloadTask:getUrl	()Ljava/lang/String;
    //   785: astore 13
    //   787: goto -26 -> 761
    //   790: aload 12
    //   792: monitorexit
    //   793: return
    //   794: astore 13
    //   796: aload 12
    //   798: astore_1
    //   799: aload 13
    //   801: astore 12
    //   803: aload_1
    //   804: astore 13
    //   806: goto +2150 -> 2956
    //   809: aload 13
    //   811: astore 15
    //   813: aload 12
    //   815: astore 18
    //   817: aload_0
    //   818: getfield 15	com/tencent/component/network/downloader/impl/DownloaderImpl$1:this$0	Lcom/tencent/component/network/downloader/impl/DownloaderImpl;
    //   821: aload 19
    //   823: iconst_1
    //   824: aconst_null
    //   825: invokestatic 254	com/tencent/component/network/downloader/impl/DownloaderImpl:access$800	(Lcom/tencent/component/network/downloader/impl/DownloaderImpl;Ljava/lang/String;ZLjava/util/Collection;)Ljava/util/Collection;
    //   828: astore 20
    //   830: aload 13
    //   832: ifnull +1636 -> 2468
    //   835: aload 13
    //   837: astore 15
    //   839: aload 12
    //   841: astore 18
    //   843: aload 13
    //   845: invokevirtual 171	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   848: invokevirtual 176	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   851: ifne +6 -> 857
    //   854: goto +1614 -> 2468
    //   857: aload 20
    //   859: ifnull +2410 -> 3269
    //   862: aload 13
    //   864: astore 15
    //   866: aload 12
    //   868: astore 18
    //   870: new 75	java/util/ArrayList
    //   873: dup
    //   874: invokespecial 76	java/util/ArrayList:<init>	()V
    //   877: astore 28
    //   879: aload 13
    //   881: astore 15
    //   883: aload 12
    //   885: astore 18
    //   887: new 158	java/io/File
    //   890: dup
    //   891: aload 13
    //   893: invokevirtual 156	com/tencent/component/network/downloader/DownloadResult:getPath	()Ljava/lang/String;
    //   896: invokespecial 161	java/io/File:<init>	(Ljava/lang/String;)V
    //   899: astore 19
    //   901: aload 13
    //   903: astore 15
    //   905: aload 12
    //   907: astore 18
    //   909: aload 19
    //   911: invokevirtual 165	java/io/File:length	()J
    //   914: lstore 7
    //   916: aload 13
    //   918: astore 15
    //   920: aload 12
    //   922: astore 18
    //   924: aload 20
    //   926: invokeinterface 257 1 0
    //   931: astore 17
    //   933: iconst_0
    //   934: istore_2
    //   935: aload 20
    //   937: astore 14
    //   939: aload 13
    //   941: astore 15
    //   943: aload 12
    //   945: astore 18
    //   947: aload 17
    //   949: invokeinterface 94 1 0
    //   954: ifeq +2308 -> 3262
    //   957: aload 13
    //   959: astore 15
    //   961: aload 12
    //   963: astore 18
    //   965: aload 17
    //   967: invokeinterface 98 1 0
    //   972: checkcast 259	com/tencent/component/network/downloader/DownloadRequest
    //   975: astore 26
    //   977: aload 26
    //   979: ifnull +2236 -> 3215
    //   982: aload 13
    //   984: astore 15
    //   986: aload 12
    //   988: astore 18
    //   990: aload 26
    //   992: invokevirtual 262	com/tencent/component/network/downloader/DownloadRequest:isCanceled	()Z
    //   995: ifeq +6 -> 1001
    //   998: goto +2217 -> 3215
    //   1001: aload 13
    //   1003: astore 15
    //   1005: aload 12
    //   1007: astore 18
    //   1009: aload 26
    //   1011: invokevirtual 265	com/tencent/component/network/downloader/DownloadRequest:shouldCacheEntry	()Z
    //   1014: ifeq +1981 -> 2995
    //   1017: iconst_1
    //   1018: istore_2
    //   1019: goto +3 -> 1022
    //   1022: aload 13
    //   1024: astore 15
    //   1026: aload 12
    //   1028: astore 18
    //   1030: aload 26
    //   1032: invokevirtual 269	com/tencent/component/network/downloader/DownloadRequest:getPaths	()[Ljava/lang/String;
    //   1035: astore 21
    //   1037: aload 21
    //   1039: ifnull +1232 -> 2271
    //   1042: aload 13
    //   1044: astore 15
    //   1046: aload 12
    //   1048: astore 18
    //   1050: aload 21
    //   1052: arraylength
    //   1053: istore 4
    //   1055: iconst_0
    //   1056: istore_3
    //   1057: iload_3
    //   1058: iload 4
    //   1060: if_icmpge +1945 -> 3005
    //   1063: aload 13
    //   1065: astore 15
    //   1067: aload 12
    //   1069: astore 18
    //   1071: aload 28
    //   1073: aload 21
    //   1075: iload_3
    //   1076: aaload
    //   1077: invokeinterface 272 2 0
    //   1082: ifeq +1916 -> 2998
    //   1085: iconst_1
    //   1086: istore_3
    //   1087: goto +1920 -> 3007
    //   1090: aload 13
    //   1092: astore 15
    //   1094: aload 12
    //   1096: astore 18
    //   1098: aload 21
    //   1100: arraylength
    //   1101: istore 4
    //   1103: iconst_0
    //   1104: istore 5
    //   1106: aload 26
    //   1108: astore 20
    //   1110: iload 5
    //   1112: iload 4
    //   1114: if_icmpge +2062 -> 3176
    //   1117: aload 21
    //   1119: iload 5
    //   1121: aaload
    //   1122: astore 29
    //   1124: aload 13
    //   1126: astore 15
    //   1128: aload 12
    //   1130: astore 18
    //   1132: aload 29
    //   1134: invokestatic 241	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1137: ifeq +6 -> 1143
    //   1140: goto +1882 -> 3022
    //   1143: aload 13
    //   1145: astore 15
    //   1147: aload 12
    //   1149: astore 18
    //   1151: aload_0
    //   1152: getfield 15	com/tencent/component/network/downloader/impl/DownloaderImpl$1:this$0	Lcom/tencent/component/network/downloader/impl/DownloaderImpl;
    //   1155: aload 13
    //   1157: aload 20
    //   1159: invokestatic 276	com/tencent/component/network/downloader/impl/DownloaderImpl:access$1100	(Lcom/tencent/component/network/downloader/impl/DownloaderImpl;Lcom/tencent/component/network/downloader/DownloadResult;Lcom/tencent/component/network/downloader/DownloadRequest;)Z
    //   1162: ifne +1860 -> 3022
    //   1165: aload 13
    //   1167: astore 15
    //   1169: aload 12
    //   1171: astore 18
    //   1173: aload 13
    //   1175: invokevirtual 156	com/tencent/component/network/downloader/DownloadResult:getPath	()Ljava/lang/String;
    //   1178: ifnull +1844 -> 3022
    //   1181: aload 13
    //   1183: astore 15
    //   1185: aload 12
    //   1187: astore 18
    //   1189: aload 28
    //   1191: aload 29
    //   1193: invokeinterface 272 2 0
    //   1198: istore 11
    //   1200: iload 11
    //   1202: ifne +1820 -> 3022
    //   1205: iconst_1
    //   1206: istore 6
    //   1208: iconst_0
    //   1209: istore_3
    //   1210: aload 21
    //   1212: astore 22
    //   1214: aload 20
    //   1216: astore 21
    //   1218: aload 17
    //   1220: astore 20
    //   1222: aload 19
    //   1224: astore 17
    //   1226: aload 14
    //   1228: astore 19
    //   1230: iload 6
    //   1232: iflt +810 -> 2042
    //   1235: iload_3
    //   1236: ifne +806 -> 2042
    //   1239: iload 6
    //   1241: iconst_1
    //   1242: isub
    //   1243: istore 6
    //   1245: aload 13
    //   1247: astore 15
    //   1249: aload 12
    //   1251: astore 18
    //   1253: new 158	java/io/File
    //   1256: dup
    //   1257: aload 29
    //   1259: invokespecial 161	java/io/File:<init>	(Ljava/lang/String;)V
    //   1262: astore 26
    //   1264: aload 16
    //   1266: ifnull +29 -> 1295
    //   1269: aload 13
    //   1271: astore 15
    //   1273: aload 12
    //   1275: astore 18
    //   1277: aload 16
    //   1279: invokevirtual 279	java/io/File:exists	()Z
    //   1282: istore 11
    //   1284: iload 11
    //   1286: ifne +6 -> 1292
    //   1289: goto +6 -> 1295
    //   1292: goto +294 -> 1586
    //   1295: aload 13
    //   1297: astore 15
    //   1299: aload 12
    //   1301: astore 18
    //   1303: aload 17
    //   1305: aload 26
    //   1307: invokestatic 283	com/tencent/component/network/utils/FileUtils:rename	(Ljava/io/File;Ljava/io/File;)Z
    //   1310: istore 11
    //   1312: iload 11
    //   1314: ifeq +12 -> 1326
    //   1317: aload 26
    //   1319: astore 16
    //   1321: iconst_1
    //   1322: istore_3
    //   1323: goto +3 -> 1326
    //   1326: aload 13
    //   1328: astore 15
    //   1330: aload 12
    //   1332: astore 18
    //   1334: new 112	java/lang/StringBuilder
    //   1337: dup
    //   1338: invokespecial 113	java/lang/StringBuilder:<init>	()V
    //   1341: astore 25
    //   1343: aload 13
    //   1345: astore 15
    //   1347: aload 12
    //   1349: astore 18
    //   1351: aload 25
    //   1353: ldc_w 285
    //   1356: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1359: pop
    //   1360: aload 13
    //   1362: astore 15
    //   1364: aload 12
    //   1366: astore 18
    //   1368: aload 25
    //   1370: aload 17
    //   1372: invokevirtual 286	java/io/File:getPath	()Ljava/lang/String;
    //   1375: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1378: pop
    //   1379: aload 13
    //   1381: astore 15
    //   1383: aload 12
    //   1385: astore 18
    //   1387: aload 25
    //   1389: ldc_w 288
    //   1392: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1395: pop
    //   1396: aload 13
    //   1398: astore 15
    //   1400: aload 12
    //   1402: astore 18
    //   1404: aload 25
    //   1406: aload 29
    //   1408: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1411: pop
    //   1412: aload 13
    //   1414: astore 15
    //   1416: aload 12
    //   1418: astore 18
    //   1420: aload 25
    //   1422: ldc_w 290
    //   1425: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1428: pop
    //   1429: aload 13
    //   1431: astore 15
    //   1433: aload 12
    //   1435: astore 18
    //   1437: aload 25
    //   1439: aload_0
    //   1440: getfield 17	com/tencent/component/network/downloader/impl/DownloaderImpl$1:val$task	Lcom/tencent/component/network/downloader/impl/DownloadTask;
    //   1443: invokevirtual 46	com/tencent/component/network/downloader/impl/DownloadTask:getUrl	()Ljava/lang/String;
    //   1446: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1449: pop
    //   1450: aload 13
    //   1452: astore 15
    //   1454: aload 12
    //   1456: astore 18
    //   1458: aload 25
    //   1460: ldc_w 292
    //   1463: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1466: pop
    //   1467: aload 13
    //   1469: astore 15
    //   1471: aload 12
    //   1473: astore 18
    //   1475: aload 25
    //   1477: iload 11
    //   1479: invokevirtual 179	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1482: pop
    //   1483: aload 13
    //   1485: astore 15
    //   1487: aload 12
    //   1489: astore 18
    //   1491: aload 25
    //   1493: ldc_w 294
    //   1496: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1499: pop
    //   1500: aload 13
    //   1502: astore 15
    //   1504: aload 12
    //   1506: astore 18
    //   1508: aload 25
    //   1510: lload 7
    //   1512: invokevirtual 186	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1515: pop
    //   1516: aload 13
    //   1518: astore 15
    //   1520: aload 12
    //   1522: astore 18
    //   1524: aload 25
    //   1526: ldc_w 296
    //   1529: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1532: pop
    //   1533: aload 13
    //   1535: astore 18
    //   1537: aload 12
    //   1539: astore 24
    //   1541: aload 16
    //   1543: astore 23
    //   1545: aload 24
    //   1547: astore 14
    //   1549: aload 18
    //   1551: astore 15
    //   1553: aload 25
    //   1555: aload 26
    //   1557: invokevirtual 165	java/io/File:length	()J
    //   1560: invokevirtual 186	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1563: pop
    //   1564: aload 16
    //   1566: astore 23
    //   1568: aload 24
    //   1570: astore 14
    //   1572: aload 18
    //   1574: astore 15
    //   1576: ldc 121
    //   1578: aload 25
    //   1580: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1583: invokestatic 299	com/tencent/component/network/module/base/QDLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1586: aload 13
    //   1588: astore 18
    //   1590: aload 12
    //   1592: astore 24
    //   1594: iload_3
    //   1595: ifne +1482 -> 3077
    //   1598: aload 16
    //   1600: ifnull +1456 -> 3056
    //   1603: aload 16
    //   1605: astore 23
    //   1607: aload 24
    //   1609: astore 14
    //   1611: aload 18
    //   1613: astore 15
    //   1615: aload 16
    //   1617: invokevirtual 279	java/io/File:exists	()Z
    //   1620: ifeq +1436 -> 3056
    //   1623: aload 16
    //   1625: astore 25
    //   1627: goto +3 -> 1630
    //   1630: aload 16
    //   1632: astore 23
    //   1634: aload 24
    //   1636: astore 14
    //   1638: aload 18
    //   1640: astore 15
    //   1642: aload 25
    //   1644: aload 26
    //   1646: invokestatic 302	com/tencent/component/network/utils/FileUtils:copyFiles	(Ljava/io/File;Ljava/io/File;)Z
    //   1649: istore 11
    //   1651: aload 16
    //   1653: astore 23
    //   1655: aload 24
    //   1657: astore 14
    //   1659: aload 18
    //   1661: astore 15
    //   1663: aload 26
    //   1665: invokevirtual 165	java/io/File:length	()J
    //   1668: lstore 9
    //   1670: aload 24
    //   1672: astore 14
    //   1674: aload 18
    //   1676: astore 15
    //   1678: new 112	java/lang/StringBuilder
    //   1681: dup
    //   1682: invokespecial 113	java/lang/StringBuilder:<init>	()V
    //   1685: astore 27
    //   1687: aload 16
    //   1689: astore 23
    //   1691: aload 24
    //   1693: astore 14
    //   1695: aload 18
    //   1697: astore 15
    //   1699: aload 27
    //   1701: ldc_w 304
    //   1704: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1707: pop
    //   1708: aload 16
    //   1710: astore 23
    //   1712: aload 24
    //   1714: astore 14
    //   1716: aload 18
    //   1718: astore 15
    //   1720: aload 27
    //   1722: aload 25
    //   1724: invokevirtual 286	java/io/File:getPath	()Ljava/lang/String;
    //   1727: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1730: pop
    //   1731: aload 16
    //   1733: astore 23
    //   1735: aload 24
    //   1737: astore 14
    //   1739: aload 18
    //   1741: astore 15
    //   1743: aload 27
    //   1745: ldc_w 288
    //   1748: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1751: pop
    //   1752: aload 16
    //   1754: astore 23
    //   1756: aload 24
    //   1758: astore 14
    //   1760: aload 18
    //   1762: astore 15
    //   1764: aload 27
    //   1766: aload 29
    //   1768: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1771: pop
    //   1772: aload 16
    //   1774: astore 23
    //   1776: aload 24
    //   1778: astore 14
    //   1780: aload 18
    //   1782: astore 15
    //   1784: aload 27
    //   1786: ldc_w 290
    //   1789: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1792: pop
    //   1793: aload 16
    //   1795: astore 23
    //   1797: aload 24
    //   1799: astore 14
    //   1801: aload 18
    //   1803: astore 15
    //   1805: aload 27
    //   1807: aload_0
    //   1808: getfield 17	com/tencent/component/network/downloader/impl/DownloaderImpl$1:val$task	Lcom/tencent/component/network/downloader/impl/DownloadTask;
    //   1811: invokevirtual 46	com/tencent/component/network/downloader/impl/DownloadTask:getUrl	()Ljava/lang/String;
    //   1814: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1817: pop
    //   1818: aload 16
    //   1820: astore 23
    //   1822: aload 24
    //   1824: astore 14
    //   1826: aload 18
    //   1828: astore 15
    //   1830: aload 27
    //   1832: ldc_w 292
    //   1835: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1838: pop
    //   1839: aload 16
    //   1841: astore 23
    //   1843: aload 24
    //   1845: astore 14
    //   1847: aload 18
    //   1849: astore 15
    //   1851: aload 27
    //   1853: iload 11
    //   1855: invokevirtual 179	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1858: pop
    //   1859: aload 16
    //   1861: astore 23
    //   1863: aload 24
    //   1865: astore 14
    //   1867: aload 18
    //   1869: astore 15
    //   1871: aload 27
    //   1873: ldc_w 294
    //   1876: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1879: pop
    //   1880: aload 16
    //   1882: astore 23
    //   1884: aload 24
    //   1886: astore 14
    //   1888: aload 18
    //   1890: astore 15
    //   1892: aload 27
    //   1894: lload 7
    //   1896: invokevirtual 186	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1899: pop
    //   1900: aload 16
    //   1902: astore 23
    //   1904: aload 24
    //   1906: astore 14
    //   1908: aload 18
    //   1910: astore 15
    //   1912: aload 27
    //   1914: ldc_w 296
    //   1917: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1920: pop
    //   1921: aload 16
    //   1923: astore 23
    //   1925: aload 24
    //   1927: astore 14
    //   1929: aload 18
    //   1931: astore 15
    //   1933: aload 27
    //   1935: lload 9
    //   1937: invokevirtual 186	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1940: pop
    //   1941: aload 16
    //   1943: astore 23
    //   1945: aload 24
    //   1947: astore 14
    //   1949: aload 18
    //   1951: astore 15
    //   1953: aload 27
    //   1955: ldc_w 306
    //   1958: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1961: pop
    //   1962: aload 16
    //   1964: astore 23
    //   1966: aload 24
    //   1968: astore 14
    //   1970: aload 18
    //   1972: astore 15
    //   1974: aload 27
    //   1976: iload 6
    //   1978: invokevirtual 309	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1981: pop
    //   1982: aload 16
    //   1984: astore 23
    //   1986: aload 24
    //   1988: astore 14
    //   1990: aload 18
    //   1992: astore 15
    //   1994: ldc 121
    //   1996: aload 27
    //   1998: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2001: invokestatic 299	com/tencent/component/network/module/base/QDLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2004: iload 11
    //   2006: ifeq +16 -> 2022
    //   2009: lload 7
    //   2011: lload 9
    //   2013: lcmp
    //   2014: ifne +8 -> 2022
    //   2017: iconst_1
    //   2018: istore_3
    //   2019: goto +1058 -> 3077
    //   2022: aload 16
    //   2024: astore 23
    //   2026: aload 24
    //   2028: astore 14
    //   2030: aload 18
    //   2032: astore 15
    //   2034: aload 26
    //   2036: invokestatic 247	com/tencent/component/network/utils/FileUtils:delete	(Ljava/io/File;)V
    //   2039: goto +1038 -> 3077
    //   2042: aload 13
    //   2044: astore 18
    //   2046: aload 19
    //   2048: astore 26
    //   2050: aload 17
    //   2052: astore 25
    //   2054: aload 20
    //   2056: astore 27
    //   2058: iload_2
    //   2059: istore 6
    //   2061: aload 12
    //   2063: astore 24
    //   2065: iload_3
    //   2066: ifeq +51 -> 2117
    //   2069: aload 16
    //   2071: astore 23
    //   2073: aload 24
    //   2075: astore 14
    //   2077: aload 18
    //   2079: astore 15
    //   2081: aload 28
    //   2083: aload 29
    //   2085: invokeinterface 80 2 0
    //   2090: pop
    //   2091: aload 16
    //   2093: astore 14
    //   2095: aload 27
    //   2097: astore 20
    //   2099: iload 6
    //   2101: istore_2
    //   2102: aload 26
    //   2104: astore 17
    //   2106: aload 18
    //   2108: astore 13
    //   2110: aload 25
    //   2112: astore 12
    //   2114: goto +1082 -> 3196
    //   2117: aload 16
    //   2119: astore 23
    //   2121: aload 24
    //   2123: astore 14
    //   2125: aload 18
    //   2127: astore 15
    //   2129: new 158	java/io/File
    //   2132: dup
    //   2133: aload 29
    //   2135: invokespecial 161	java/io/File:<init>	(Ljava/lang/String;)V
    //   2138: invokestatic 247	com/tencent/component/network/utils/FileUtils:delete	(Ljava/io/File;)V
    //   2141: aload 17
    //   2143: astore 23
    //   2145: aload 19
    //   2147: astore 15
    //   2149: aload 22
    //   2151: astore 17
    //   2153: aload 20
    //   2155: astore 18
    //   2157: aload 12
    //   2159: astore 19
    //   2161: aload 21
    //   2163: astore 12
    //   2165: iload 4
    //   2167: istore_3
    //   2168: aload 13
    //   2170: astore 14
    //   2172: aload 23
    //   2174: astore 13
    //   2176: goto +956 -> 3132
    //   2179: astore 18
    //   2181: aload 23
    //   2183: astore 16
    //   2185: aload 13
    //   2187: astore 24
    //   2189: aload 12
    //   2191: astore 23
    //   2193: aload 23
    //   2195: astore 14
    //   2197: aload 24
    //   2199: astore 15
    //   2201: new 112	java/lang/StringBuilder
    //   2204: dup
    //   2205: invokespecial 113	java/lang/StringBuilder:<init>	()V
    //   2208: astore 25
    //   2210: aload 23
    //   2212: astore 14
    //   2214: aload 24
    //   2216: astore 15
    //   2218: aload 25
    //   2220: ldc_w 311
    //   2223: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2226: pop
    //   2227: aload 23
    //   2229: astore 14
    //   2231: aload 24
    //   2233: astore 15
    //   2235: aload 25
    //   2237: aload_0
    //   2238: getfield 17	com/tencent/component/network/downloader/impl/DownloaderImpl$1:val$task	Lcom/tencent/component/network/downloader/impl/DownloadTask;
    //   2241: invokevirtual 46	com/tencent/component/network/downloader/impl/DownloadTask:getUrl	()Ljava/lang/String;
    //   2244: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2247: pop
    //   2248: aload 23
    //   2250: astore 14
    //   2252: aload 24
    //   2254: astore 15
    //   2256: ldc 121
    //   2258: aload 25
    //   2260: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2263: aload 18
    //   2265: invokestatic 315	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   2268: goto -127 -> 2141
    //   2271: aload 13
    //   2273: astore 18
    //   2275: aload 14
    //   2277: astore 22
    //   2279: aload 19
    //   2281: astore 23
    //   2283: aload 17
    //   2285: astore 25
    //   2287: iload_2
    //   2288: istore_3
    //   2289: aload 12
    //   2291: astore 21
    //   2293: aload 16
    //   2295: astore 19
    //   2297: aload 21
    //   2299: astore 24
    //   2301: aload 25
    //   2303: astore 20
    //   2305: iload_3
    //   2306: istore_2
    //   2307: aload 22
    //   2309: astore 17
    //   2311: aload 18
    //   2313: astore 13
    //   2315: aload 23
    //   2317: astore 12
    //   2319: aload 21
    //   2321: astore 14
    //   2323: aload 18
    //   2325: astore 15
    //   2327: aload 26
    //   2329: getfield 319	com/tencent/component/network/downloader/DownloadRequest:outputStream	Ljava/io/OutputStream;
    //   2332: ifnull +868 -> 3200
    //   2335: aload 21
    //   2337: astore 14
    //   2339: aload 18
    //   2341: astore 15
    //   2343: aload 18
    //   2345: invokevirtual 156	com/tencent/component/network/downloader/DownloadResult:getPath	()Ljava/lang/String;
    //   2348: aload 26
    //   2350: getfield 319	com/tencent/component/network/downloader/DownloadRequest:outputStream	Ljava/io/OutputStream;
    //   2353: invokestatic 323	com/tencent/component/network/utils/FileUtils:copyFile	(Ljava/lang/String;Ljava/io/OutputStream;)Z
    //   2356: pop
    //   2357: aload 16
    //   2359: astore 19
    //   2361: aload 21
    //   2363: astore 24
    //   2365: aload 25
    //   2367: astore 20
    //   2369: iload_3
    //   2370: istore_2
    //   2371: aload 22
    //   2373: astore 17
    //   2375: aload 18
    //   2377: astore 13
    //   2379: aload 23
    //   2381: astore 12
    //   2383: goto +817 -> 3200
    //   2386: aload 12
    //   2388: astore 14
    //   2390: aload 13
    //   2392: astore 15
    //   2394: aload_0
    //   2395: getfield 15	com/tencent/component/network/downloader/impl/DownloaderImpl$1:this$0	Lcom/tencent/component/network/downloader/impl/DownloaderImpl;
    //   2398: astore 18
    //   2400: aload 13
    //   2402: astore 16
    //   2404: aload 16
    //   2406: astore 13
    //   2408: aload 12
    //   2410: astore 14
    //   2412: aload 18
    //   2414: aload 17
    //   2416: aload 16
    //   2418: invokestatic 327	com/tencent/component/network/downloader/impl/DownloaderImpl:access$1200	(Lcom/tencent/component/network/downloader/impl/DownloaderImpl;Ljava/util/Collection;Lcom/tencent/component/network/downloader/DownloadResult;)V
    //   2421: aload 16
    //   2423: astore 17
    //   2425: aload 12
    //   2427: astore 15
    //   2429: iload_2
    //   2430: ifeq +99 -> 2529
    //   2433: aload 16
    //   2435: astore 13
    //   2437: aload 12
    //   2439: astore 14
    //   2441: aload_0
    //   2442: getfield 15	com/tencent/component/network/downloader/impl/DownloaderImpl$1:this$0	Lcom/tencent/component/network/downloader/impl/DownloaderImpl;
    //   2445: aload_0
    //   2446: getfield 17	com/tencent/component/network/downloader/impl/DownloaderImpl$1:val$task	Lcom/tencent/component/network/downloader/impl/DownloadTask;
    //   2449: invokevirtual 46	com/tencent/component/network/downloader/impl/DownloadTask:getUrl	()Ljava/lang/String;
    //   2452: aload 16
    //   2454: invokevirtual 331	com/tencent/component/network/downloader/impl/DownloaderImpl:addCacheEntry	(Ljava/lang/String;Lcom/tencent/component/network/downloader/DownloadResult;)V
    //   2457: aload 16
    //   2459: astore 17
    //   2461: aload 12
    //   2463: astore 15
    //   2465: goto +64 -> 2529
    //   2468: aload 13
    //   2470: astore 16
    //   2472: aload 16
    //   2474: astore 17
    //   2476: aload 12
    //   2478: astore 15
    //   2480: aload 16
    //   2482: astore 13
    //   2484: aload 12
    //   2486: astore 14
    //   2488: aload_0
    //   2489: getfield 15	com/tencent/component/network/downloader/impl/DownloaderImpl$1:this$0	Lcom/tencent/component/network/downloader/impl/DownloaderImpl;
    //   2492: aload_0
    //   2493: getfield 17	com/tencent/component/network/downloader/impl/DownloaderImpl$1:val$task	Lcom/tencent/component/network/downloader/impl/DownloadTask;
    //   2496: invokestatic 335	com/tencent/component/network/downloader/impl/DownloaderImpl:access$900	(Lcom/tencent/component/network/downloader/impl/DownloaderImpl;Lcom/tencent/component/network/downloader/impl/DownloadTask;)Z
    //   2499: ifne +30 -> 2529
    //   2502: aload 16
    //   2504: astore 13
    //   2506: aload 12
    //   2508: astore 14
    //   2510: aload_0
    //   2511: getfield 15	com/tencent/component/network/downloader/impl/DownloaderImpl$1:this$0	Lcom/tencent/component/network/downloader/impl/DownloaderImpl;
    //   2514: aload 20
    //   2516: aload 16
    //   2518: invokestatic 338	com/tencent/component/network/downloader/impl/DownloaderImpl:access$1000	(Lcom/tencent/component/network/downloader/impl/DownloaderImpl;Ljava/util/Collection;Lcom/tencent/component/network/downloader/DownloadResult;)V
    //   2521: aload 12
    //   2523: astore 15
    //   2525: aload 16
    //   2527: astore 17
    //   2529: aload 17
    //   2531: ifnull +162 -> 2693
    //   2534: aload_1
    //   2535: invokeinterface 218 1 0
    //   2540: ifne +153 -> 2693
    //   2543: aload_0
    //   2544: getfield 15	com/tencent/component/network/downloader/impl/DownloaderImpl$1:this$0	Lcom/tencent/component/network/downloader/impl/DownloaderImpl;
    //   2547: invokestatic 222	com/tencent/component/network/downloader/impl/DownloaderImpl:access$1300	(Lcom/tencent/component/network/downloader/impl/DownloaderImpl;)Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   2550: ifnull +28 -> 2578
    //   2553: aload_0
    //   2554: getfield 15	com/tencent/component/network/downloader/impl/DownloaderImpl$1:this$0	Lcom/tencent/component/network/downloader/impl/DownloaderImpl;
    //   2557: invokestatic 225	com/tencent/component/network/downloader/impl/DownloaderImpl:access$1400	(Lcom/tencent/component/network/downloader/impl/DownloaderImpl;)Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   2560: aload 17
    //   2562: invokevirtual 226	com/tencent/component/network/downloader/DownloadResult:getUrl	()Ljava/lang/String;
    //   2565: aload 17
    //   2567: invokevirtual 171	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   2570: invokevirtual 176	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   2573: invokeinterface 232 3 0
    //   2578: aload 17
    //   2580: invokevirtual 171	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   2583: invokevirtual 176	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   2586: ifne +13 -> 2599
    //   2589: aload_0
    //   2590: getfield 15	com/tencent/component/network/downloader/impl/DownloaderImpl$1:this$0	Lcom/tencent/component/network/downloader/impl/DownloaderImpl;
    //   2593: invokestatic 235	com/tencent/component/network/downloader/impl/DownloaderImpl:access$1500	(Lcom/tencent/component/network/downloader/impl/DownloaderImpl;)Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   2596: ifnonnull +97 -> 2693
    //   2599: aload 17
    //   2601: invokevirtual 156	com/tencent/component/network/downloader/DownloadResult:getPath	()Ljava/lang/String;
    //   2604: invokestatic 241	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2607: ifne +86 -> 2693
    //   2610: new 158	java/io/File
    //   2613: dup
    //   2614: aload 17
    //   2616: invokevirtual 156	com/tencent/component/network/downloader/DownloadResult:getPath	()Ljava/lang/String;
    //   2619: invokespecial 161	java/io/File:<init>	(Ljava/lang/String;)V
    //   2622: invokestatic 247	com/tencent/component/network/utils/FileUtils:delete	(Ljava/io/File;)V
    //   2625: goto +68 -> 2693
    //   2628: astore 12
    //   2630: aload 15
    //   2632: astore_1
    //   2633: aload_0
    //   2634: getfield 15	com/tencent/component/network/downloader/impl/DownloaderImpl$1:this$0	Lcom/tencent/component/network/downloader/impl/DownloaderImpl;
    //   2637: invokestatic 42	com/tencent/component/network/downloader/impl/DownloaderImpl:access$300	(Lcom/tencent/component/network/downloader/impl/DownloaderImpl;)Lcom/tencent/component/network/downloader/impl/DownloaderImpl$LockManager;
    //   2640: aload_0
    //   2641: getfield 17	com/tencent/component/network/downloader/impl/DownloaderImpl$1:val$task	Lcom/tencent/component/network/downloader/impl/DownloadTask;
    //   2644: invokevirtual 46	com/tencent/component/network/downloader/impl/DownloadTask:getUrl	()Ljava/lang/String;
    //   2647: invokevirtual 250	com/tencent/component/network/downloader/impl/DownloaderImpl$LockManager:releaseLock	(Ljava/lang/String;)V
    //   2650: aload 15
    //   2652: astore_1
    //   2653: aload 12
    //   2655: athrow
    //   2656: aload 15
    //   2658: astore_1
    //   2659: aload_0
    //   2660: getfield 15	com/tencent/component/network/downloader/impl/DownloaderImpl$1:this$0	Lcom/tencent/component/network/downloader/impl/DownloaderImpl;
    //   2663: invokestatic 42	com/tencent/component/network/downloader/impl/DownloaderImpl:access$300	(Lcom/tencent/component/network/downloader/impl/DownloaderImpl;)Lcom/tencent/component/network/downloader/impl/DownloaderImpl$LockManager;
    //   2666: astore 12
    //   2668: aload 15
    //   2670: astore_1
    //   2671: aload_0
    //   2672: getfield 17	com/tencent/component/network/downloader/impl/DownloaderImpl$1:val$task	Lcom/tencent/component/network/downloader/impl/DownloadTask;
    //   2675: invokevirtual 46	com/tencent/component/network/downloader/impl/DownloadTask:getUrl	()Ljava/lang/String;
    //   2678: astore 13
    //   2680: aload 15
    //   2682: astore_1
    //   2683: aload 12
    //   2685: aload 13
    //   2687: invokevirtual 250	com/tencent/component/network/downloader/impl/DownloaderImpl$LockManager:releaseLock	(Ljava/lang/String;)V
    //   2690: goto +30 -> 2720
    //   2693: aload 15
    //   2695: astore_1
    //   2696: aload_0
    //   2697: getfield 15	com/tencent/component/network/downloader/impl/DownloaderImpl$1:this$0	Lcom/tencent/component/network/downloader/impl/DownloaderImpl;
    //   2700: invokestatic 42	com/tencent/component/network/downloader/impl/DownloaderImpl:access$300	(Lcom/tencent/component/network/downloader/impl/DownloaderImpl;)Lcom/tencent/component/network/downloader/impl/DownloaderImpl$LockManager;
    //   2703: astore 12
    //   2705: aload 15
    //   2707: astore_1
    //   2708: aload_0
    //   2709: getfield 17	com/tencent/component/network/downloader/impl/DownloaderImpl$1:val$task	Lcom/tencent/component/network/downloader/impl/DownloadTask;
    //   2712: invokevirtual 46	com/tencent/component/network/downloader/impl/DownloadTask:getUrl	()Ljava/lang/String;
    //   2715: astore 13
    //   2717: goto -37 -> 2680
    //   2720: aload 15
    //   2722: astore_1
    //   2723: aload 15
    //   2725: monitorexit
    //   2726: return
    //   2727: astore 15
    //   2729: aload 17
    //   2731: monitorexit
    //   2732: aload 12
    //   2734: astore 14
    //   2736: aload 15
    //   2738: athrow
    //   2739: astore 12
    //   2741: goto +18 -> 2759
    //   2744: astore 15
    //   2746: goto -17 -> 2729
    //   2749: astore 12
    //   2751: aload 18
    //   2753: astore 14
    //   2755: aload 15
    //   2757: astore 13
    //   2759: aload 13
    //   2761: ifnull +162 -> 2923
    //   2764: aload_1
    //   2765: invokeinterface 218 1 0
    //   2770: ifne +153 -> 2923
    //   2773: aload_0
    //   2774: getfield 15	com/tencent/component/network/downloader/impl/DownloaderImpl$1:this$0	Lcom/tencent/component/network/downloader/impl/DownloaderImpl;
    //   2777: invokestatic 222	com/tencent/component/network/downloader/impl/DownloaderImpl:access$1300	(Lcom/tencent/component/network/downloader/impl/DownloaderImpl;)Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   2780: ifnull +28 -> 2808
    //   2783: aload_0
    //   2784: getfield 15	com/tencent/component/network/downloader/impl/DownloaderImpl$1:this$0	Lcom/tencent/component/network/downloader/impl/DownloaderImpl;
    //   2787: invokestatic 225	com/tencent/component/network/downloader/impl/DownloaderImpl:access$1400	(Lcom/tencent/component/network/downloader/impl/DownloaderImpl;)Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   2790: aload 13
    //   2792: invokevirtual 226	com/tencent/component/network/downloader/DownloadResult:getUrl	()Ljava/lang/String;
    //   2795: aload 13
    //   2797: invokevirtual 171	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   2800: invokevirtual 176	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   2803: invokeinterface 232 3 0
    //   2808: aload 13
    //   2810: invokevirtual 171	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   2813: invokevirtual 176	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   2816: ifne +13 -> 2829
    //   2819: aload_0
    //   2820: getfield 15	com/tencent/component/network/downloader/impl/DownloaderImpl$1:this$0	Lcom/tencent/component/network/downloader/impl/DownloaderImpl;
    //   2823: invokestatic 235	com/tencent/component/network/downloader/impl/DownloaderImpl:access$1500	(Lcom/tencent/component/network/downloader/impl/DownloaderImpl;)Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   2826: ifnonnull +97 -> 2923
    //   2829: aload 13
    //   2831: invokevirtual 156	com/tencent/component/network/downloader/DownloadResult:getPath	()Ljava/lang/String;
    //   2834: invokestatic 241	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2837: ifne +86 -> 2923
    //   2840: new 158	java/io/File
    //   2843: dup
    //   2844: aload 13
    //   2846: invokevirtual 156	com/tencent/component/network/downloader/DownloadResult:getPath	()Ljava/lang/String;
    //   2849: invokespecial 161	java/io/File:<init>	(Ljava/lang/String;)V
    //   2852: invokestatic 247	com/tencent/component/network/utils/FileUtils:delete	(Ljava/io/File;)V
    //   2855: goto +68 -> 2923
    //   2858: astore 12
    //   2860: aload 14
    //   2862: astore_1
    //   2863: aload_0
    //   2864: getfield 15	com/tencent/component/network/downloader/impl/DownloaderImpl$1:this$0	Lcom/tencent/component/network/downloader/impl/DownloaderImpl;
    //   2867: invokestatic 42	com/tencent/component/network/downloader/impl/DownloaderImpl:access$300	(Lcom/tencent/component/network/downloader/impl/DownloaderImpl;)Lcom/tencent/component/network/downloader/impl/DownloaderImpl$LockManager;
    //   2870: aload_0
    //   2871: getfield 17	com/tencent/component/network/downloader/impl/DownloaderImpl$1:val$task	Lcom/tencent/component/network/downloader/impl/DownloadTask;
    //   2874: invokevirtual 46	com/tencent/component/network/downloader/impl/DownloadTask:getUrl	()Ljava/lang/String;
    //   2877: invokevirtual 250	com/tencent/component/network/downloader/impl/DownloaderImpl$LockManager:releaseLock	(Ljava/lang/String;)V
    //   2880: aload 14
    //   2882: astore_1
    //   2883: aload 12
    //   2885: athrow
    //   2886: aload 14
    //   2888: astore_1
    //   2889: aload_0
    //   2890: getfield 15	com/tencent/component/network/downloader/impl/DownloaderImpl$1:this$0	Lcom/tencent/component/network/downloader/impl/DownloaderImpl;
    //   2893: invokestatic 42	com/tencent/component/network/downloader/impl/DownloaderImpl:access$300	(Lcom/tencent/component/network/downloader/impl/DownloaderImpl;)Lcom/tencent/component/network/downloader/impl/DownloaderImpl$LockManager;
    //   2896: astore 13
    //   2898: aload 14
    //   2900: astore_1
    //   2901: aload_0
    //   2902: getfield 17	com/tencent/component/network/downloader/impl/DownloaderImpl$1:val$task	Lcom/tencent/component/network/downloader/impl/DownloadTask;
    //   2905: invokevirtual 46	com/tencent/component/network/downloader/impl/DownloadTask:getUrl	()Ljava/lang/String;
    //   2908: astore 15
    //   2910: aload 14
    //   2912: astore_1
    //   2913: aload 13
    //   2915: aload 15
    //   2917: invokevirtual 250	com/tencent/component/network/downloader/impl/DownloaderImpl$LockManager:releaseLock	(Ljava/lang/String;)V
    //   2920: goto +30 -> 2950
    //   2923: aload 14
    //   2925: astore_1
    //   2926: aload_0
    //   2927: getfield 15	com/tencent/component/network/downloader/impl/DownloaderImpl$1:this$0	Lcom/tencent/component/network/downloader/impl/DownloaderImpl;
    //   2930: invokestatic 42	com/tencent/component/network/downloader/impl/DownloaderImpl:access$300	(Lcom/tencent/component/network/downloader/impl/DownloaderImpl;)Lcom/tencent/component/network/downloader/impl/DownloaderImpl$LockManager;
    //   2933: astore 13
    //   2935: aload 14
    //   2937: astore_1
    //   2938: aload_0
    //   2939: getfield 17	com/tencent/component/network/downloader/impl/DownloaderImpl$1:val$task	Lcom/tencent/component/network/downloader/impl/DownloadTask;
    //   2942: invokevirtual 46	com/tencent/component/network/downloader/impl/DownloadTask:getUrl	()Ljava/lang/String;
    //   2945: astore 15
    //   2947: goto -37 -> 2910
    //   2950: aload 14
    //   2952: astore_1
    //   2953: aload 12
    //   2955: athrow
    //   2956: aload 13
    //   2958: astore_1
    //   2959: aload 13
    //   2961: monitorexit
    //   2962: aload 12
    //   2964: athrow
    //   2965: astore_1
    //   2966: aload 12
    //   2968: monitorexit
    //   2969: goto +5 -> 2974
    //   2972: aload_1
    //   2973: athrow
    //   2974: goto -2 -> 2972
    //   2977: astore_1
    //   2978: goto -2234 -> 744
    //   2981: astore_1
    //   2982: goto -326 -> 2656
    //   2985: astore_1
    //   2986: goto -100 -> 2886
    //   2989: aconst_null
    //   2990: astore 14
    //   2992: goto -2541 -> 451
    //   2995: goto -1973 -> 1022
    //   2998: iload_3
    //   2999: iconst_1
    //   3000: iadd
    //   3001: istore_3
    //   3002: goto -1945 -> 1057
    //   3005: iconst_0
    //   3006: istore_3
    //   3007: iload_3
    //   3008: ifeq -1918 -> 1090
    //   3011: aload 14
    //   3013: astore 18
    //   3015: aload 17
    //   3017: astore 15
    //   3019: goto +232 -> 3251
    //   3022: aload 13
    //   3024: astore 15
    //   3026: aload 14
    //   3028: astore 18
    //   3030: iload 4
    //   3032: istore_3
    //   3033: aload 19
    //   3035: astore 13
    //   3037: aload 17
    //   3039: astore 19
    //   3041: aload 20
    //   3043: astore 14
    //   3045: aload 21
    //   3047: astore 17
    //   3049: aload 12
    //   3051: astore 20
    //   3053: goto +59 -> 3112
    //   3056: aload 17
    //   3058: astore 25
    //   3060: goto -1430 -> 1630
    //   3063: astore 14
    //   3065: goto +30 -> 3095
    //   3068: astore 14
    //   3070: aload 23
    //   3072: astore 16
    //   3074: goto +21 -> 3095
    //   3077: aload 24
    //   3079: astore 12
    //   3081: aload 18
    //   3083: astore 13
    //   3085: goto -1855 -> 1230
    //   3088: astore 14
    //   3090: goto +5 -> 3095
    //   3093: astore 14
    //   3095: aload 14
    //   3097: astore 18
    //   3099: goto -914 -> 2185
    //   3102: astore 18
    //   3104: goto -919 -> 2185
    //   3107: astore 18
    //   3109: goto -924 -> 2185
    //   3112: aload 14
    //   3114: astore 12
    //   3116: aload 15
    //   3118: astore 14
    //   3120: aload 18
    //   3122: astore 15
    //   3124: aload 19
    //   3126: astore 18
    //   3128: aload 20
    //   3130: astore 19
    //   3132: iload 5
    //   3134: iconst_1
    //   3135: iadd
    //   3136: istore 5
    //   3138: aload 17
    //   3140: astore 21
    //   3142: aload 13
    //   3144: astore 17
    //   3146: aload 12
    //   3148: astore 20
    //   3150: aload 14
    //   3152: astore 13
    //   3154: aload 19
    //   3156: astore 12
    //   3158: aload 15
    //   3160: astore 14
    //   3162: iload_3
    //   3163: istore 4
    //   3165: aload 17
    //   3167: astore 19
    //   3169: aload 18
    //   3171: astore 17
    //   3173: goto -2063 -> 1110
    //   3176: aload 17
    //   3178: astore 20
    //   3180: aload 12
    //   3182: astore 24
    //   3184: aload 19
    //   3186: astore 12
    //   3188: aload 14
    //   3190: astore 17
    //   3192: aload 16
    //   3194: astore 14
    //   3196: aload 14
    //   3198: astore 19
    //   3200: aload 24
    //   3202: astore 14
    //   3204: aload 20
    //   3206: astore 15
    //   3208: aload 19
    //   3210: astore 16
    //   3212: goto +27 -> 3239
    //   3215: aload 14
    //   3217: astore 15
    //   3219: aload 12
    //   3221: astore 14
    //   3223: aload 17
    //   3225: astore 18
    //   3227: aload 19
    //   3229: astore 12
    //   3231: aload 15
    //   3233: astore 17
    //   3235: aload 18
    //   3237: astore 15
    //   3239: aload 12
    //   3241: astore 19
    //   3243: aload 17
    //   3245: astore 18
    //   3247: aload 14
    //   3249: astore 12
    //   3251: aload 18
    //   3253: astore 14
    //   3255: aload 15
    //   3257: astore 17
    //   3259: goto -2320 -> 939
    //   3262: aload 14
    //   3264: astore 17
    //   3266: goto -880 -> 2386
    //   3269: aload 20
    //   3271: astore 17
    //   3273: iconst_0
    //   3274: istore_2
    //   3275: goto -889 -> 2386
    //   3278: astore 12
    //   3280: aload 15
    //   3282: astore 13
    //   3284: goto -525 -> 2759
    //   3287: astore 12
    //   3289: aload_1
    //   3290: astore 13
    //   3292: goto -336 -> 2956
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	3295	0	this	1
    //   0	3295	1	paramFuture	Future<DownloadResult>
    //   934	2341	2	i	int
    //   1056	2107	3	j	int
    //   1053	2111	4	k	int
    //   1104	2033	5	m	int
    //   1206	894	6	n	int
    //   129	1881	7	l1	long
    //   1668	344	9	l2	long
    //   358	1647	11	bool	boolean
    //   13	2509	12	localObject1	Object
    //   2628	26	12	localObject2	Object
    //   2666	67	12	localLockManager	DownloaderImpl.LockManager
    //   2739	1	12	localObject3	Object
    //   2749	1	12	localObject4	Object
    //   2858	192	12	localObject5	Object
    //   3079	171	12	localObject6	Object
    //   3278	1	12	localObject7	Object
    //   3287	1	12	localObject8	Object
    //   113	673	13	localObject9	Object
    //   794	6	13	localObject10	Object
    //   804	2487	13	localObject11	Object
    //   259	2785	14	localObject12	Object
    //   3063	1	14	localThrowable1	java.lang.Throwable
    //   3068	1	14	localThrowable2	java.lang.Throwable
    //   3088	1	14	localThrowable3	java.lang.Throwable
    //   3093	20	14	localThrowable4	java.lang.Throwable
    //   3118	145	14	localObject13	Object
    //   313	2411	15	localObject14	Object
    //   2727	10	15	localObject15	Object
    //   2744	12	15	localObject16	Object
    //   2908	373	15	localObject17	Object
    //   361	2850	16	localObject18	Object
    //   326	2946	17	localObject19	Object
    //   317	1839	18	localObject20	Object
    //   2179	85	18	localThrowable5	java.lang.Throwable
    //   2273	825	18	localObject21	Object
    //   3102	1	18	localThrowable6	java.lang.Throwable
    //   3107	14	18	localThrowable7	java.lang.Throwable
    //   3126	126	18	localObject22	Object
    //   74	3168	19	localObject23	Object
    //   828	2442	20	localObject24	Object
    //   1035	2106	21	localObject25	Object
    //   1212	1160	22	localObject26	Object
    //   1543	1528	23	localObject27	Object
    //   1539	1662	24	localObject28	Object
    //   1341	1718	25	localObject29	Object
    //   975	1374	26	localObject30	Object
    //   1685	411	27	localObject31	Object
    //   877	1205	28	localArrayList	ArrayList
    //   1122	1012	29	localCharSequence	java.lang.CharSequence
    // Exception table:
    //   from	to	target	type
    //   630	674	724	finally
    //   674	695	724	finally
    //   695	721	724	finally
    //   725	744	794	finally
    //   744	761	794	finally
    //   761	767	794	finally
    //   770	787	794	finally
    //   790	793	794	finally
    //   1699	1708	2179	java/lang/Throwable
    //   1720	1731	2179	java/lang/Throwable
    //   1743	1752	2179	java/lang/Throwable
    //   1764	1772	2179	java/lang/Throwable
    //   1784	1793	2179	java/lang/Throwable
    //   1805	1818	2179	java/lang/Throwable
    //   1830	1839	2179	java/lang/Throwable
    //   1851	1859	2179	java/lang/Throwable
    //   1871	1880	2179	java/lang/Throwable
    //   1892	1900	2179	java/lang/Throwable
    //   1912	1921	2179	java/lang/Throwable
    //   1933	1941	2179	java/lang/Throwable
    //   1953	1962	2179	java/lang/Throwable
    //   1974	1982	2179	java/lang/Throwable
    //   1994	2004	2179	java/lang/Throwable
    //   2034	2039	2179	java/lang/Throwable
    //   2081	2091	2179	java/lang/Throwable
    //   2129	2141	2179	java/lang/Throwable
    //   2534	2578	2628	finally
    //   2578	2599	2628	finally
    //   2599	2625	2628	finally
    //   339	360	2727	finally
    //   368	392	2727	finally
    //   397	406	2727	finally
    //   406	428	2727	finally
    //   433	448	2727	finally
    //   456	496	2727	finally
    //   496	499	2727	finally
    //   2412	2421	2739	finally
    //   2441	2457	2739	finally
    //   2488	2502	2739	finally
    //   2510	2521	2739	finally
    //   2736	2739	2739	finally
    //   2729	2732	2744	finally
    //   319	328	2749	finally
    //   336	339	2749	finally
    //   512	523	2749	finally
    //   531	537	2749	finally
    //   545	554	2749	finally
    //   562	570	2749	finally
    //   578	591	2749	finally
    //   599	607	2749	finally
    //   615	625	2749	finally
    //   817	830	2749	finally
    //   843	854	2749	finally
    //   870	879	2749	finally
    //   887	901	2749	finally
    //   909	916	2749	finally
    //   924	933	2749	finally
    //   947	957	2749	finally
    //   965	977	2749	finally
    //   990	998	2749	finally
    //   1009	1017	2749	finally
    //   1030	1037	2749	finally
    //   1050	1055	2749	finally
    //   1071	1085	2749	finally
    //   1098	1103	2749	finally
    //   1132	1140	2749	finally
    //   1151	1165	2749	finally
    //   1173	1181	2749	finally
    //   1189	1200	2749	finally
    //   1253	1264	2749	finally
    //   1277	1284	2749	finally
    //   1303	1312	2749	finally
    //   1334	1343	2749	finally
    //   1351	1360	2749	finally
    //   1368	1379	2749	finally
    //   1387	1396	2749	finally
    //   1404	1412	2749	finally
    //   1420	1429	2749	finally
    //   1437	1450	2749	finally
    //   1458	1467	2749	finally
    //   1475	1483	2749	finally
    //   1491	1500	2749	finally
    //   1508	1516	2749	finally
    //   1524	1533	2749	finally
    //   2764	2808	2858	finally
    //   2808	2829	2858	finally
    //   2829	2855	2858	finally
    //   88	104	2965	finally
    //   2966	2969	2965	finally
    //   630	674	2977	java/lang/Throwable
    //   674	695	2977	java/lang/Throwable
    //   695	721	2977	java/lang/Throwable
    //   2534	2578	2981	java/lang/Throwable
    //   2578	2599	2981	java/lang/Throwable
    //   2599	2625	2981	java/lang/Throwable
    //   2764	2808	2985	java/lang/Throwable
    //   2808	2829	2985	java/lang/Throwable
    //   2829	2855	2985	java/lang/Throwable
    //   1678	1687	3063	java/lang/Throwable
    //   1553	1564	3068	java/lang/Throwable
    //   1576	1586	3068	java/lang/Throwable
    //   1615	1623	3068	java/lang/Throwable
    //   1642	1651	3068	java/lang/Throwable
    //   1663	1670	3068	java/lang/Throwable
    //   1351	1360	3088	java/lang/Throwable
    //   1368	1379	3088	java/lang/Throwable
    //   1387	1396	3088	java/lang/Throwable
    //   1404	1412	3088	java/lang/Throwable
    //   1420	1429	3088	java/lang/Throwable
    //   1437	1450	3088	java/lang/Throwable
    //   1458	1467	3088	java/lang/Throwable
    //   1475	1483	3088	java/lang/Throwable
    //   1491	1500	3088	java/lang/Throwable
    //   1508	1516	3088	java/lang/Throwable
    //   1524	1533	3088	java/lang/Throwable
    //   1334	1343	3093	java/lang/Throwable
    //   1303	1312	3102	java/lang/Throwable
    //   1253	1264	3107	java/lang/Throwable
    //   1277	1284	3107	java/lang/Throwable
    //   1553	1564	3278	finally
    //   1576	1586	3278	finally
    //   1615	1623	3278	finally
    //   1642	1651	3278	finally
    //   1663	1670	3278	finally
    //   1678	1687	3278	finally
    //   1699	1708	3278	finally
    //   1720	1731	3278	finally
    //   1743	1752	3278	finally
    //   1764	1772	3278	finally
    //   1784	1793	3278	finally
    //   1805	1818	3278	finally
    //   1830	1839	3278	finally
    //   1851	1859	3278	finally
    //   1871	1880	3278	finally
    //   1892	1900	3278	finally
    //   1912	1921	3278	finally
    //   1933	1941	3278	finally
    //   1953	1962	3278	finally
    //   1974	1982	3278	finally
    //   1994	2004	3278	finally
    //   2034	2039	3278	finally
    //   2081	2091	3278	finally
    //   2129	2141	3278	finally
    //   2201	2210	3278	finally
    //   2218	2227	3278	finally
    //   2235	2248	3278	finally
    //   2256	2268	3278	finally
    //   2327	2335	3278	finally
    //   2343	2357	3278	finally
    //   2394	2400	3278	finally
    //   2633	2650	3287	finally
    //   2653	2656	3287	finally
    //   2659	2668	3287	finally
    //   2671	2680	3287	finally
    //   2683	2690	3287	finally
    //   2696	2705	3287	finally
    //   2708	2717	3287	finally
    //   2723	2726	3287	finally
    //   2863	2880	3287	finally
    //   2883	2886	3287	finally
    //   2889	2898	3287	finally
    //   2901	2910	3287	finally
    //   2913	2920	3287	finally
    //   2926	2935	3287	finally
    //   2938	2947	3287	finally
    //   2953	2956	3287	finally
    //   2959	2962	3287	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.component.network.downloader.impl.DownloaderImpl.1
 * JD-Core Version:    0.7.0.1
 */