package com.tencent.biz.qqstory.msgTabNode.network;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.common.util.NetworkUtil;
import com.tencent.biz.qqstory.base.preload.DownloadTask;
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
import nin;
import nio;
import nip;

public class MsgTabStoryVideoPreloader
{
  protected int a;
  public IVideoPreloader a;
  private MsgTabVideoPreloaderDataProvider.DataProviderListener jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeNetworkMsgTabVideoPreloaderDataProvider$DataProviderListener = new nio(this);
  protected MsgTabVideoPreloaderDataProvider a;
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  protected final Queue a;
  protected final Set a;
  protected AtomicBoolean a;
  protected nip a;
  protected boolean a;
  protected final Set b = new CopyOnWriteArraySet();
  
  public MsgTabStoryVideoPreloader()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadIVideoPreloader = new VideoPreloader();
    this.jdField_a_of_type_JavaUtilSet = new CopyOnWriteArraySet();
    this.jdField_a_of_type_JavaUtilQueue = new LinkedList();
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeNetworkMsgTabVideoPreloaderDataProvider = new MsgTabVideoPreloaderDataProvider();
    this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadIVideoPreloader.a(2);
    Object localObject = (StoryConfigManager)SuperManager.a(10);
    this.jdField_a_of_type_Int = ((Integer)((StoryConfigManager)localObject).b("key_story_msg_tab_node_preload", Integer.valueOf(0))).intValue();
    this.jdField_a_of_type_Boolean = ((Boolean)((StoryConfigManager)localObject).b("key_story_msg_tab_node_preload_4g", Boolean.valueOf(false))).booleanValue();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("消息TAB日迹预加载器wifi开关状态：");
      if (this.jdField_a_of_type_Int <= 0) {
        break label213;
      }
    }
    label213:
    for (boolean bool = true;; bool = false)
    {
      QLog.i("MsgTabStoryVideoPreloader", 2, bool);
      QLog.i("MsgTabStoryVideoPreloader", 2, "消息TAB日迹预加载器4G开关状态：" + this.jdField_a_of_type_Boolean);
      return;
    }
  }
  
  private Queue a(List paramList)
  {
    LinkedList localLinkedList;
    for (;;)
    {
      try
      {
        localLinkedList = new LinkedList();
        if ((paramList == null) || (paramList.isEmpty())) {
          break;
        }
        paramList = paramList.iterator();
        if (!paramList.hasNext()) {
          break;
        }
        MsgTabNodeInfo localMsgTabNodeInfo = (MsgTabNodeInfo)paramList.next();
        if ((localMsgTabNodeInfo != null) && (MsgTabStoryUtil.a(localMsgTabNodeInfo))) {
          if (localMsgTabNodeInfo.b > 0) {
            localLinkedList.add(localMsgTabNodeInfo);
          } else {
            this.jdField_a_of_type_JavaUtilSet.remove(localMsgTabNodeInfo.a);
          }
        }
      }
      finally {}
    }
    return localLinkedList;
  }
  
  private void a(List paramList)
  {
    try
    {
      ArrayList localArrayList = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject = (StoryVideoItem)paramList.next();
        DownloadTask localDownloadTask = DownloadTask.a(((StoryVideoItem)localObject).mVid, 2);
        if (!TextUtils.isEmpty(localDownloadTask.c))
        {
          if (QLog.isColorLevel()) {
            QLog.i("MsgTabStoryVideoPreloader", 2, "download thumb url=" + localDownloadTask.c);
          }
          this.b.add(localDownloadTask.c);
          localArrayList.add(localDownloadTask);
        }
        localObject = DownloadTask.a(((StoryVideoItem)localObject).mVid, 1);
        if (!TextUtils.isEmpty(((DownloadTask)localObject).c))
        {
          if (QLog.isColorLevel()) {
            QLog.i("MsgTabStoryVideoPreloader", 2, "download mask url=" + ((DownloadTask)localObject).c);
          }
          this.b.add(((DownloadTask)localObject).c);
          localArrayList.add(localObject);
        }
        this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadIVideoPreloader.a(localArrayList, 2, false);
      }
    }
    finally {}
  }
  
  private void a(Queue paramQueue)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.i("MsgTabStoryVideoPreloader", 2, "添加一波要预加载的节点队列=" + paramQueue.size() + "\n" + paramQueue);
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
      }
    }
    finally {}
  }
  
  private boolean a(Context paramContext)
  {
    boolean bool = true;
    switch (NetworkUtil.a(paramContext))
    {
    case 2: 
    case 3: 
    default: 
      if (QLog.isColorLevel()) {
        QLog.i("MsgTabStoryVideoPreloader", 2, "非4g非wifi，不进行预下载");
      }
      bool = false;
    }
    do
    {
      do
      {
        return bool;
        if (QLog.isColorLevel()) {
          QLog.i("MsgTabStoryVideoPreloader", 2, "wifi");
        }
        this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeNetworkMsgTabVideoPreloaderDataProvider.a(true);
        this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeNetworkMsgTabVideoPreloaderDataProvider.b(true);
      } while (this.jdField_a_of_type_Int != 0);
      return false;
      if (QLog.isColorLevel()) {
        QLog.i("MsgTabStoryVideoPreloader", 2, "4g");
      }
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeNetworkMsgTabVideoPreloaderDataProvider.a(this.jdField_a_of_type_Boolean);
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeNetworkMsgTabVideoPreloaderDataProvider.b(false);
    } while ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Int != 0));
    return false;
  }
  
  private void c()
  {
    try
    {
      if (this.jdField_a_of_type_Nip == null)
      {
        this.jdField_a_of_type_Nip = new nip(this);
        this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadIVideoPreloader.a(this.jdField_a_of_type_Nip);
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
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
      return (MsgTabStoryVideoPreloader.OnPreloaderListener)this.jdField_a_of_type_JavaLangRefWeakReference.get();
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
    //   3: getfield 44	com/tencent/biz/qqstory/msgTabNode/network/MsgTabStoryVideoPreloader:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   6: iconst_0
    //   7: invokevirtual 282	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   10: aload_0
    //   11: aconst_null
    //   12: putfield 261	com/tencent/biz/qqstory/msgTabNode/network/MsgTabStoryVideoPreloader:jdField_a_of_type_Nip	Lnip;
    //   15: aload_0
    //   16: getfield 25	com/tencent/biz/qqstory/msgTabNode/network/MsgTabStoryVideoPreloader:jdField_a_of_type_ComTencentBizQqstoryBasePreloadIVideoPreloader	Lcom/tencent/biz/qqstory/base/preload/IVideoPreloader;
    //   19: ifnull +12 -> 31
    //   22: aload_0
    //   23: getfield 25	com/tencent/biz/qqstory/msgTabNode/network/MsgTabStoryVideoPreloader:jdField_a_of_type_ComTencentBizQqstoryBasePreloadIVideoPreloader	Lcom/tencent/biz/qqstory/base/preload/IVideoPreloader;
    //   26: invokeinterface 283 1 0
    //   31: aload_0
    //   32: getfield 35	com/tencent/biz/qqstory/msgTabNode/network/MsgTabStoryVideoPreloader:jdField_a_of_type_JavaUtilQueue	Ljava/util/Queue;
    //   35: astore_1
    //   36: aload_1
    //   37: monitorenter
    //   38: aload_0
    //   39: getfield 37	com/tencent/biz/qqstory/msgTabNode/network/MsgTabStoryVideoPreloader:b	Ljava/util/Set;
    //   42: invokeinterface 286 1 0
    //   47: aload_0
    //   48: getfield 35	com/tencent/biz/qqstory/msgTabNode/network/MsgTabStoryVideoPreloader:jdField_a_of_type_JavaUtilQueue	Ljava/util/Queue;
    //   51: invokeinterface 287 1 0
    //   56: aload_0
    //   57: getfield 30	com/tencent/biz/qqstory/msgTabNode/network/MsgTabStoryVideoPreloader:jdField_a_of_type_JavaUtilSet	Ljava/util/Set;
    //   60: invokeinterface 286 1 0
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
  
  public void a(Context paramContext, List paramList)
  {
    if (paramContext == null) {}
    while (!a(paramContext)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("MsgTabStoryVideoPreloader", 2, "启动消息TAB节点预加载器");
    }
    paramContext = new ArrayList(paramList);
    Bosses.get().postJob(new nin(this, paramContext));
  }
  
  public void a(MsgTabStoryVideoPreloader.OnPreloaderListener paramOnPreloaderListener)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramOnPreloaderListener);
  }
  
  /* Error */
  public void a(java.lang.String arg1, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 37	com/tencent/biz/qqstory/msgTabNode/network/MsgTabStoryVideoPreloader:b	Ljava/util/Set;
    //   6: aload_1
    //   7: invokeinterface 173 2 0
    //   12: pop
    //   13: aload_0
    //   14: getfield 44	com/tencent/biz/qqstory/msgTabNode/network/MsgTabStoryVideoPreloader:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   17: invokevirtual 317	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   20: ifeq +83 -> 103
    //   23: aload_0
    //   24: getfield 35	com/tencent/biz/qqstory/msgTabNode/network/MsgTabStoryVideoPreloader:jdField_a_of_type_JavaUtilQueue	Ljava/util/Queue;
    //   27: astore_1
    //   28: aload_1
    //   29: monitorenter
    //   30: aload_0
    //   31: getfield 35	com/tencent/biz/qqstory/msgTabNode/network/MsgTabStoryVideoPreloader:jdField_a_of_type_JavaUtilQueue	Ljava/util/Queue;
    //   34: invokeinterface 318 1 0
    //   39: ifeq +67 -> 106
    //   42: aload_0
    //   43: getfield 37	com/tencent/biz/qqstory/msgTabNode/network/MsgTabStoryVideoPreloader:b	Ljava/util/Set;
    //   46: invokeinterface 319 1 0
    //   51: ifeq +55 -> 106
    //   54: invokestatic 103	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   57: ifeq +12 -> 69
    //   60: ldc 114
    //   62: iconst_2
    //   63: ldc_w 321
    //   66: invokestatic 125	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   69: aload_0
    //   70: getfield 44	com/tencent/biz/qqstory/msgTabNode/network/MsgTabStoryVideoPreloader:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   73: iconst_0
    //   74: invokevirtual 282	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   77: aload_0
    //   78: getfield 30	com/tencent/biz/qqstory/msgTabNode/network/MsgTabStoryVideoPreloader:jdField_a_of_type_JavaUtilSet	Ljava/util/Set;
    //   81: invokeinterface 286 1 0
    //   86: aload_0
    //   87: invokevirtual 233	com/tencent/biz/qqstory/msgTabNode/network/MsgTabStoryVideoPreloader:a	()Lcom/tencent/biz/qqstory/msgTabNode/network/MsgTabStoryVideoPreloader$OnPreloaderListener;
    //   90: astore_3
    //   91: aload_3
    //   92: ifnull +9 -> 101
    //   95: aload_3
    //   96: invokeinterface 323 1 0
    //   101: aload_1
    //   102: monitorexit
    //   103: aload_0
    //   104: monitorexit
    //   105: return
    //   106: iload_2
    //   107: ifeq -6 -> 101
    //   110: aload_0
    //   111: invokevirtual 324	com/tencent/biz/qqstory/msgTabNode/network/MsgTabStoryVideoPreloader:b	()V
    //   114: goto -13 -> 101
    //   117: astore_3
    //   118: aload_1
    //   119: monitorexit
    //   120: aload_3
    //   121: athrow
    //   122: astore_1
    //   123: aload_0
    //   124: monitorexit
    //   125: aload_1
    //   126: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	127	0	this	MsgTabStoryVideoPreloader
    //   0	127	2	paramBoolean	boolean
    //   90	6	3	localOnPreloaderListener	MsgTabStoryVideoPreloader.OnPreloaderListener
    //   117	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   30	69	117	finally
    //   69	91	117	finally
    //   95	101	117	finally
    //   101	103	117	finally
    //   110	114	117	finally
    //   118	120	117	finally
    //   2	30	122	finally
    //   120	122	122	finally
  }
  
  /* Error */
  public boolean a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 30	com/tencent/biz/qqstory/msgTabNode/network/MsgTabStoryVideoPreloader:jdField_a_of_type_JavaUtilSet	Ljava/util/Set;
    //   6: invokeinterface 325 1 0
    //   11: istore_1
    //   12: aload_0
    //   13: getfield 85	com/tencent/biz/qqstory/msgTabNode/network/MsgTabStoryVideoPreloader:jdField_a_of_type_Int	I
    //   16: istore_2
    //   17: iload_1
    //   18: iload_2
    //   19: if_icmpge +9 -> 28
    //   22: iconst_1
    //   23: istore_3
    //   24: aload_0
    //   25: monitorexit
    //   26: iload_3
    //   27: ireturn
    //   28: iconst_0
    //   29: istore_3
    //   30: goto -6 -> 24
    //   33: astore 4
    //   35: aload_0
    //   36: monitorexit
    //   37: aload 4
    //   39: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	40	0	this	MsgTabStoryVideoPreloader
    //   11	9	1	i	int
    //   16	4	2	j	int
    //   23	7	3	bool	boolean
    //   33	5	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	17	33	finally
  }
  
  public void b()
  {
    for (;;)
    {
      try
      {
        synchronized (this.jdField_a_of_type_JavaUtilQueue)
        {
          if (this.jdField_a_of_type_JavaUtilQueue.isEmpty())
          {
            if (QLog.isColorLevel()) {
              QLog.i("MsgTabStoryVideoPreloader", 2, "节点信息都加载成功了");
            }
            return;
          }
          MsgTabNodeInfo localMsgTabNodeInfo = (MsgTabNodeInfo)this.jdField_a_of_type_JavaUtilQueue.poll();
          if (localMsgTabNodeInfo != null) {
            if (!TextUtils.isEmpty(localMsgTabNodeInfo.a)) {
              break label83;
            }
          }
        }
        if (a()) {
          break label145;
        }
      }
      finally {}
      label83:
      if (QLog.isColorLevel()) {
        QLog.w("MsgTabStoryVideoPreloader", 2, "预加载节点数到了指定阈值:" + this.jdField_a_of_type_Int + "，不继续加载");
      }
      this.jdField_a_of_type_JavaUtilQueue.clear();
      continue;
      label145:
      if (QLog.isColorLevel()) {
        QLog.i("MsgTabStoryVideoPreloader", 2, "pull video info from node \n" + localObject2);
      }
      this.jdField_a_of_type_JavaUtilSet.add(localObject2.a);
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeNetworkMsgTabVideoPreloaderDataProvider.a(localObject2, this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeNetworkMsgTabVideoPreloaderDataProvider$DataProviderListener);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.network.MsgTabStoryVideoPreloader
 * JD-Core Version:    0.7.0.1
 */