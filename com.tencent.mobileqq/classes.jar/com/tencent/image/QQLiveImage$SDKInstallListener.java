package com.tencent.image;

import com.tencent.image.api.ILog;
import com.tencent.image.api.URLDrawableDepWrap;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr.InstallListener;
import java.util.concurrent.atomic.AtomicBoolean;

class QQLiveImage$SDKInstallListener
  implements TVK_SDKMgr.InstallListener
{
  public void onInstallProgress(float paramFloat)
  {
    QQLiveImage.access$400().set(false);
    if (URLDrawable.depImp.mLog.isColorLevel())
    {
      ILog localILog = URLDrawable.depImp.mLog;
      String str = QQLiveImage.TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[SDKInstallListener] onInstallProgress(): v= ");
      localStringBuilder.append(paramFloat);
      localILog.d(str, 4, localStringBuilder.toString());
    }
  }
  
  public void onInstalledFailed(int paramInt)
  {
    QQLiveImage.access$400().set(false);
    if (URLDrawable.depImp.mLog.isColorLevel()) {
      URLDrawable.depImp.mLog.e(QQLiveImage.TAG, 2, "[SDKInstallListener] onInstalledFailed():");
    }
  }
  
  /* Error */
  public void onInstalledSuccessed()
  {
    // Byte code:
    //   0: getstatic 33	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   3: getfield 39	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   6: invokeinterface 45 1 0
    //   11: ifeq +20 -> 31
    //   14: getstatic 33	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   17: getfield 39	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   20: getstatic 49	com/tencent/image/QQLiveImage:TAG	Ljava/lang/String;
    //   23: iconst_2
    //   24: ldc 81
    //   26: invokeinterface 69 4 0
    //   31: invokestatic 21	com/tencent/image/QQLiveImage:access$400	()Ljava/util/concurrent/atomic/AtomicBoolean;
    //   34: astore_2
    //   35: iconst_0
    //   36: istore_1
    //   37: aload_2
    //   38: iconst_0
    //   39: invokevirtual 27	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   42: getstatic 85	com/tencent/image/QQLiveImage:mLockForImageList	Ljava/util/concurrent/locks/ReentrantLock;
    //   45: invokevirtual 90	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   48: invokestatic 94	com/tencent/image/QQLiveImage:access$000	()Ljava/util/ArrayList;
    //   51: ifnull +53 -> 104
    //   54: iload_1
    //   55: invokestatic 94	com/tencent/image/QQLiveImage:access$000	()Ljava/util/ArrayList;
    //   58: invokevirtual 100	java/util/ArrayList:size	()I
    //   61: if_icmpge +43 -> 104
    //   64: invokestatic 94	com/tencent/image/QQLiveImage:access$000	()Ljava/util/ArrayList;
    //   67: iload_1
    //   68: invokevirtual 104	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   71: checkcast 17	com/tencent/image/QQLiveImage
    //   74: astore_2
    //   75: aload_2
    //   76: ifnull +21 -> 97
    //   79: aload_2
    //   80: getfield 108	com/tencent/image/QQLiveImage:mParams	Lcom/tencent/image/QQLiveDrawable$QQLiveDrawableParams;
    //   83: ifnull +14 -> 97
    //   86: aload_2
    //   87: aload_2
    //   88: getfield 108	com/tencent/image/QQLiveImage:mParams	Lcom/tencent/image/QQLiveDrawable$QQLiveDrawableParams;
    //   91: getfield 114	com/tencent/image/QQLiveDrawable$QQLiveDrawableParams:mStartPosi	I
    //   94: invokevirtual 117	com/tencent/image/QQLiveImage:initAndStartPlayer	(I)V
    //   97: iload_1
    //   98: iconst_1
    //   99: iadd
    //   100: istore_1
    //   101: goto -47 -> 54
    //   104: getstatic 85	com/tencent/image/QQLiveImage:mLockForImageList	Ljava/util/concurrent/locks/ReentrantLock;
    //   107: invokevirtual 120	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   110: return
    //   111: astore_2
    //   112: goto +39 -> 151
    //   115: astore_2
    //   116: getstatic 33	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   119: getfield 39	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   122: invokeinterface 45 1 0
    //   127: ifeq -23 -> 104
    //   130: getstatic 33	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   133: getfield 39	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   136: getstatic 49	com/tencent/image/QQLiveImage:TAG	Ljava/lang/String;
    //   139: iconst_2
    //   140: ldc 122
    //   142: aload_2
    //   143: invokeinterface 125 5 0
    //   148: goto -44 -> 104
    //   151: getstatic 85	com/tencent/image/QQLiveImage:mLockForImageList	Ljava/util/concurrent/locks/ReentrantLock;
    //   154: invokevirtual 120	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   157: goto +5 -> 162
    //   160: aload_2
    //   161: athrow
    //   162: goto -2 -> 160
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	165	0	this	SDKInstallListener
    //   36	65	1	i	int
    //   34	54	2	localObject1	Object
    //   111	1	2	localObject2	Object
    //   115	46	2	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   42	54	111	finally
    //   54	75	111	finally
    //   79	97	111	finally
    //   116	148	111	finally
    //   42	54	115	java/lang/Exception
    //   54	75	115	java/lang/Exception
    //   79	97	115	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.image.QQLiveImage.SDKInstallListener
 * JD-Core Version:    0.7.0.1
 */