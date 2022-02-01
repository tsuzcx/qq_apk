package com.tencent.biz.qqstory.msgTabNode.network;

import android.content.Context;
import com.tencent.biz.common.util.NetworkUtil;
import com.tencent.biz.qqstory.base.preload.IVideoPreloader;
import com.tencent.biz.qqstory.base.preload.PreloadDownloaderManager;
import com.tencent.biz.qqstory.base.preload.VideoPreloader;
import com.tencent.biz.qqstory.model.StoryConfigManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeInfo;
import com.tencent.biz.qqstory.msgTabNode.util.MsgTabStoryUtil;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;

public class MsgTabStoryVideoPreloader
{
  protected int a;
  public IVideoPreloader a;
  protected MsgTabStoryVideoPreloader.OnDownloadListener a;
  private MsgTabVideoPreloaderDataProvider.DataProviderListener jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeNetworkMsgTabVideoPreloaderDataProvider$DataProviderListener;
  protected MsgTabVideoPreloaderDataProvider a;
  private WeakReference<MsgTabStoryVideoPreloader.OnPreloaderListener> jdField_a_of_type_JavaLangRefWeakReference;
  protected final Queue<MsgTabNodeInfo> a;
  protected final Set<String> a;
  protected AtomicBoolean a;
  protected boolean a;
  protected final Set<String> b = new CopyOnWriteArraySet();
  
  public MsgTabStoryVideoPreloader()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadIVideoPreloader = new VideoPreloader();
    this.jdField_a_of_type_JavaUtilSet = new CopyOnWriteArraySet();
    this.jdField_a_of_type_JavaUtilQueue = new LinkedList();
    boolean bool = false;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeNetworkMsgTabVideoPreloaderDataProvider$DataProviderListener = new MsgTabStoryVideoPreloader.3(this);
    this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeNetworkMsgTabVideoPreloaderDataProvider = new MsgTabVideoPreloaderDataProvider();
    this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadIVideoPreloader.a(2);
    Object localObject = (StoryConfigManager)SuperManager.a(10);
    this.jdField_a_of_type_Int = ((Integer)((StoryConfigManager)localObject).b("key_story_msg_tab_node_preload", Integer.valueOf(0))).intValue();
    this.jdField_a_of_type_Boolean = ((Boolean)((StoryConfigManager)localObject).b("key_story_msg_tab_node_preload_4g", Boolean.valueOf(false))).booleanValue();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("消息TAB日迹预加载器wifi开关状态：");
      if (this.jdField_a_of_type_Int > 0) {
        bool = true;
      }
      ((StringBuilder)localObject).append(bool);
      QLog.i("MsgTabStoryVideoPreloader", 2, ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("消息TAB日迹预加载器4G开关状态：");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Boolean);
      QLog.i("MsgTabStoryVideoPreloader", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  private Queue<MsgTabNodeInfo> a(List<MsgTabNodeInfo> paramList)
  {
    try
    {
      LinkedList localLinkedList = new LinkedList();
      if ((paramList != null) && (!paramList.isEmpty()))
      {
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          MsgTabNodeInfo localMsgTabNodeInfo = (MsgTabNodeInfo)paramList.next();
          if ((localMsgTabNodeInfo != null) && (MsgTabStoryUtil.a(localMsgTabNodeInfo))) {
            if (localMsgTabNodeInfo.b > 0) {
              localLinkedList.add(localMsgTabNodeInfo);
            } else {
              this.jdField_a_of_type_JavaUtilSet.remove(localMsgTabNodeInfo.a);
            }
          }
        }
      }
      return localLinkedList;
    }
    finally {}
    for (;;)
    {
      throw paramList;
    }
  }
  
  private void a(List<StoryVideoItem> paramList)
  {
    try
    {
      Bosses.get().postJob(new MsgTabStoryVideoPreloader.2(this, "MsgTabStoryVideoPreloader", paramList));
      return;
    }
    finally
    {
      paramList = finally;
      throw paramList;
    }
  }
  
  private void a(Queue<MsgTabNodeInfo> paramQueue)
  {
    try
    {
      if (QLog.isColorLevel())
      {
        ??? = new StringBuilder();
        ((StringBuilder)???).append("添加一波要预加载的节点队列=");
        ((StringBuilder)???).append(paramQueue.size());
        ((StringBuilder)???).append("\n");
        ((StringBuilder)???).append(paramQueue);
        QLog.i("MsgTabStoryVideoPreloader", 2, ((StringBuilder)???).toString());
      }
      if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.getAndSet(true))
      {
        ??? = a();
        if (??? != null) {
          ((MsgTabStoryVideoPreloader.OnPreloaderListener)???).a();
        }
      }
      if (QLog.isColorLevel()) {
        QLog.i("MsgTabStoryVideoPreloader", 2, "预加载正式开始");
      }
      synchronized (this.jdField_a_of_type_JavaUtilQueue)
      {
        paramQueue = paramQueue.iterator();
        while (paramQueue.hasNext())
        {
          MsgTabNodeInfo localMsgTabNodeInfo = (MsgTabNodeInfo)paramQueue.next();
          if (!this.jdField_a_of_type_JavaUtilQueue.contains(localMsgTabNodeInfo)) {
            this.jdField_a_of_type_JavaUtilQueue.add(localMsgTabNodeInfo);
          }
        }
        return;
      }
      throw paramQueue;
    }
    finally {}
    for (;;) {}
  }
  
  private boolean a(Context paramContext)
  {
    int i = NetworkUtil.a(paramContext);
    boolean bool1 = false;
    boolean bool2 = false;
    if (i != 1)
    {
      if (i != 4)
      {
        if (QLog.isColorLevel()) {
          QLog.i("MsgTabStoryVideoPreloader", 2, "checkNetState() 非4g非wifi，不进行预下载");
        }
        return false;
      }
      if (QLog.isColorLevel()) {
        QLog.i("MsgTabStoryVideoPreloader", 2, "checkNetState() 4g");
      }
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeNetworkMsgTabVideoPreloaderDataProvider.a(this.jdField_a_of_type_Boolean);
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeNetworkMsgTabVideoPreloaderDataProvider.b(false);
      bool1 = bool2;
      if (this.jdField_a_of_type_Boolean)
      {
        bool1 = bool2;
        if (this.jdField_a_of_type_Int != 0) {
          bool1 = true;
        }
      }
      return bool1;
    }
    if (QLog.isColorLevel()) {
      QLog.i("MsgTabStoryVideoPreloader", 2, "checkNetState() wifi");
    }
    this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeNetworkMsgTabVideoPreloaderDataProvider.a(true);
    this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeNetworkMsgTabVideoPreloaderDataProvider.b(true);
    if (this.jdField_a_of_type_Int != 0) {
      bool1 = true;
    }
    return bool1;
  }
  
  private void c()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeNetworkMsgTabStoryVideoPreloader$OnDownloadListener == null)
      {
        this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeNetworkMsgTabStoryVideoPreloader$OnDownloadListener = new MsgTabStoryVideoPreloader.OnDownloadListener(this);
        this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadIVideoPreloader.a(this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeNetworkMsgTabStoryVideoPreloader$OnDownloadListener);
      }
      PreloadDownloaderManager localPreloadDownloaderManager = (PreloadDownloaderManager)SuperManager.a(6);
      if (!localPreloadDownloaderManager.a()) {
        localPreloadDownloaderManager.c();
      }
      return;
    }
    finally {}
  }
  
  public MsgTabStoryVideoPreloader.OnPreloaderListener a()
  {
    WeakReference localWeakReference = this.jdField_a_of_type_JavaLangRefWeakReference;
    if (localWeakReference != null) {
      return (MsgTabStoryVideoPreloader.OnPreloaderListener)localWeakReference.get();
    }
    return null;
  }
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 47	com/tencent/biz/qqstory/msgTabNode/network/MsgTabStoryVideoPreloader:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   6: iconst_0
    //   7: invokevirtual 279	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   10: aload_0
    //   11: aconst_null
    //   12: putfield 259	com/tencent/biz/qqstory/msgTabNode/network/MsgTabStoryVideoPreloader:jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeNetworkMsgTabStoryVideoPreloader$OnDownloadListener	Lcom/tencent/biz/qqstory/msgTabNode/network/MsgTabStoryVideoPreloader$OnDownloadListener;
    //   15: aload_0
    //   16: getfield 28	com/tencent/biz/qqstory/msgTabNode/network/MsgTabStoryVideoPreloader:jdField_a_of_type_ComTencentBizQqstoryBasePreloadIVideoPreloader	Lcom/tencent/biz/qqstory/base/preload/IVideoPreloader;
    //   19: ifnull +12 -> 31
    //   22: aload_0
    //   23: getfield 28	com/tencent/biz/qqstory/msgTabNode/network/MsgTabStoryVideoPreloader:jdField_a_of_type_ComTencentBizQqstoryBasePreloadIVideoPreloader	Lcom/tencent/biz/qqstory/base/preload/IVideoPreloader;
    //   26: invokeinterface 280 1 0
    //   31: aload_0
    //   32: getfield 38	com/tencent/biz/qqstory/msgTabNode/network/MsgTabStoryVideoPreloader:jdField_a_of_type_JavaUtilQueue	Ljava/util/Queue;
    //   35: astore_1
    //   36: aload_1
    //   37: monitorenter
    //   38: aload_0
    //   39: getfield 40	com/tencent/biz/qqstory/msgTabNode/network/MsgTabStoryVideoPreloader:b	Ljava/util/Set;
    //   42: invokeinterface 283 1 0
    //   47: aload_0
    //   48: getfield 38	com/tencent/biz/qqstory/msgTabNode/network/MsgTabStoryVideoPreloader:jdField_a_of_type_JavaUtilQueue	Ljava/util/Queue;
    //   51: invokeinterface 284 1 0
    //   56: aload_0
    //   57: getfield 33	com/tencent/biz/qqstory/msgTabNode/network/MsgTabStoryVideoPreloader:jdField_a_of_type_JavaUtilSet	Ljava/util/Set;
    //   60: invokeinterface 283 1 0
    //   65: aload_1
    //   66: monitorexit
    //   67: aload_0
    //   68: monitorexit
    //   69: return
    //   70: astore_2
    //   71: aload_1
    //   72: monitorexit
    //   73: aload_2
    //   74: athrow
    //   75: astore_1
    //   76: aload_0
    //   77: monitorexit
    //   78: aload_1
    //   79: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	80	0	this	MsgTabStoryVideoPreloader
    //   75	4	1	localObject1	Object
    //   70	4	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   38	67	70	finally
    //   71	73	70	finally
    //   2	31	75	finally
    //   31	38	75	finally
    //   73	75	75	finally
  }
  
  public void a(Context paramContext, List<MsgTabNodeInfo> paramList)
  {
    if (paramContext == null) {
      return;
    }
    paramList = new ArrayList(paramList);
    Bosses.get().postJob(new MsgTabStoryVideoPreloader.1(this, "MsgTabStoryVideoPreloader", paramContext, paramList));
  }
  
  public void a(MsgTabStoryVideoPreloader.OnPreloaderListener paramOnPreloaderListener)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramOnPreloaderListener);
  }
  
  public void a(String arg1, boolean paramBoolean)
  {
    try
    {
      this.b.remove(???);
      if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
        synchronized (this.jdField_a_of_type_JavaUtilQueue)
        {
          if ((this.jdField_a_of_type_JavaUtilQueue.isEmpty()) && (this.b.isEmpty()))
          {
            if (QLog.isColorLevel()) {
              QLog.i("MsgTabStoryVideoPreloader", 2, "预加载正式结束");
            }
            this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
            this.jdField_a_of_type_JavaUtilSet.clear();
            MsgTabStoryVideoPreloader.OnPreloaderListener localOnPreloaderListener = a();
            if (localOnPreloaderListener != null) {
              localOnPreloaderListener.b();
            }
          }
          else if (paramBoolean)
          {
            b();
          }
        }
      }
      return;
    }
    finally {}
  }
  
  public boolean a()
  {
    try
    {
      int i = this.jdField_a_of_type_JavaUtilSet.size();
      int j = this.jdField_a_of_type_Int;
      boolean bool;
      if (i < j) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  protected void b()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 38	com/tencent/biz/qqstory/msgTabNode/network/MsgTabStoryVideoPreloader:jdField_a_of_type_JavaUtilQueue	Ljava/util/Queue;
    //   6: astore_1
    //   7: aload_1
    //   8: monitorenter
    //   9: aload_0
    //   10: getfield 38	com/tencent/biz/qqstory/msgTabNode/network/MsgTabStoryVideoPreloader:jdField_a_of_type_JavaUtilQueue	Ljava/util/Queue;
    //   13: invokeinterface 304 1 0
    //   18: ifeq +23 -> 41
    //   21: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   24: ifeq +12 -> 36
    //   27: ldc 120
    //   29: iconst_2
    //   30: ldc_w 313
    //   33: invokestatic 128	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   36: aload_1
    //   37: monitorexit
    //   38: aload_0
    //   39: monitorexit
    //   40: return
    //   41: aload_0
    //   42: getfield 38	com/tencent/biz/qqstory/msgTabNode/network/MsgTabStoryVideoPreloader:jdField_a_of_type_JavaUtilQueue	Ljava/util/Queue;
    //   45: invokeinterface 316 1 0
    //   50: checkcast 155	com/tencent/biz/qqstory/msgTabNode/model/MsgTabNodeInfo
    //   53: astore_2
    //   54: aload_2
    //   55: ifnull +155 -> 210
    //   58: aload_2
    //   59: getfield 171	com/tencent/biz/qqstory/msgTabNode/model/MsgTabNodeInfo:a	Ljava/lang/String;
    //   62: invokestatic 321	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   65: ifeq +6 -> 71
    //   68: goto +142 -> 210
    //   71: aload_0
    //   72: invokevirtual 322	com/tencent/biz/qqstory/msgTabNode/network/MsgTabStoryVideoPreloader:a	()Z
    //   75: ifne +66 -> 141
    //   78: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   81: ifeq +46 -> 127
    //   84: new 108	java/lang/StringBuilder
    //   87: dup
    //   88: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   91: astore_2
    //   92: aload_2
    //   93: ldc_w 324
    //   96: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: pop
    //   100: aload_2
    //   101: aload_0
    //   102: getfield 49	com/tencent/biz/qqstory/msgTabNode/network/MsgTabStoryVideoPreloader:jdField_a_of_type_Int	I
    //   105: invokevirtual 215	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   108: pop
    //   109: aload_2
    //   110: ldc_w 326
    //   113: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: pop
    //   117: ldc 120
    //   119: iconst_2
    //   120: aload_2
    //   121: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   124: invokestatic 329	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   127: aload_0
    //   128: getfield 38	com/tencent/biz/qqstory/msgTabNode/network/MsgTabStoryVideoPreloader:jdField_a_of_type_JavaUtilQueue	Ljava/util/Queue;
    //   131: invokeinterface 284 1 0
    //   136: aload_1
    //   137: monitorexit
    //   138: aload_0
    //   139: monitorexit
    //   140: return
    //   141: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   144: ifeq +35 -> 179
    //   147: new 108	java/lang/StringBuilder
    //   150: dup
    //   151: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   154: astore_3
    //   155: aload_3
    //   156: ldc_w 331
    //   159: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: pop
    //   163: aload_3
    //   164: aload_2
    //   165: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   168: pop
    //   169: ldc 120
    //   171: iconst_2
    //   172: aload_3
    //   173: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   176: invokestatic 128	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   179: aload_0
    //   180: getfield 33	com/tencent/biz/qqstory/msgTabNode/network/MsgTabStoryVideoPreloader:jdField_a_of_type_JavaUtilSet	Ljava/util/Set;
    //   183: aload_2
    //   184: getfield 171	com/tencent/biz/qqstory/msgTabNode/model/MsgTabNodeInfo:a	Ljava/lang/String;
    //   187: invokeinterface 332 2 0
    //   192: pop
    //   193: aload_0
    //   194: getfield 63	com/tencent/biz/qqstory/msgTabNode/network/MsgTabStoryVideoPreloader:jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeNetworkMsgTabVideoPreloaderDataProvider	Lcom/tencent/biz/qqstory/msgTabNode/network/MsgTabVideoPreloaderDataProvider;
    //   197: aload_2
    //   198: aload_0
    //   199: getfield 58	com/tencent/biz/qqstory/msgTabNode/network/MsgTabStoryVideoPreloader:jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeNetworkMsgTabVideoPreloaderDataProvider$DataProviderListener	Lcom/tencent/biz/qqstory/msgTabNode/network/MsgTabVideoPreloaderDataProvider$DataProviderListener;
    //   202: invokevirtual 335	com/tencent/biz/qqstory/msgTabNode/network/MsgTabVideoPreloaderDataProvider:a	(Lcom/tencent/biz/qqstory/msgTabNode/model/MsgTabNodeInfo;Lcom/tencent/biz/qqstory/msgTabNode/network/MsgTabVideoPreloaderDataProvider$DataProviderListener;)V
    //   205: aload_1
    //   206: monitorexit
    //   207: aload_0
    //   208: monitorexit
    //   209: return
    //   210: aload_1
    //   211: monitorexit
    //   212: aload_0
    //   213: monitorexit
    //   214: return
    //   215: astore_2
    //   216: aload_1
    //   217: monitorexit
    //   218: aload_2
    //   219: athrow
    //   220: astore_1
    //   221: aload_0
    //   222: monitorexit
    //   223: aload_1
    //   224: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	225	0	this	MsgTabStoryVideoPreloader
    //   220	4	1	localObject1	Object
    //   53	145	2	localObject2	Object
    //   215	4	2	localObject3	Object
    //   154	19	3	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   9	36	215	finally
    //   36	38	215	finally
    //   41	54	215	finally
    //   58	68	215	finally
    //   71	127	215	finally
    //   127	138	215	finally
    //   141	179	215	finally
    //   179	207	215	finally
    //   210	212	215	finally
    //   216	218	215	finally
    //   2	9	220	finally
    //   218	220	220	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.network.MsgTabStoryVideoPreloader
 * JD-Core Version:    0.7.0.1
 */