package com.tencent.biz.qqstory.playvideo.dataprovider;

import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.Producer.StoryProducer;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.AssertUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.IEventReceiver;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.os.MqqHandler;

public class SimpleDataProvider
  implements IDataProvider, IGroupPageLoader.CallBack, IGroupPageLoader.IVidFullSyncer.CallBack, IEventReceiver
{
  protected ErrorMessage a;
  private final Producer.StoryProducer<IGroupPageLoader.IVidFullSyncer> jdField_a_of_type_ComTencentBizQqstoryBaseProducer$StoryProducer;
  private final IDataProvider.Data jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$Data = new IDataProvider.Data();
  private IDataProvider.GroupId jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId;
  private IGroupPageLoader jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIGroupPageLoader;
  private SimpleDataProvider.StoryVideoDeleteReceiver jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderSimpleDataProvider$StoryVideoDeleteReceiver;
  private SimpleDataProvider.StoryVideoNoInterestingReceiver jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderSimpleDataProvider$StoryVideoNoInterestingReceiver;
  private SimpleDataProvider.VideoPublishUpdateReceiver jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderSimpleDataProvider$VideoPublishUpdateReceiver;
  private ConcurrentHashMap<IDataProvider.GroupId, ErrorMessage> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private CopyOnWriteArrayList<IDataProvider.ICallBack> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  protected boolean a;
  private ConcurrentHashMap<IDataProvider.GroupId, Long> b = new ConcurrentHashMap();
  
  public SimpleDataProvider(IGroupPageLoader paramIGroupPageLoader)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = new ErrorMessage();
    this.jdField_a_of_type_Boolean = false;
    SLog.a("Q.qqstory.player.data.SimpleDataProvider", "use loader %s", paramIGroupPageLoader);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIGroupPageLoader = paramIGroupPageLoader;
    this.jdField_a_of_type_ComTencentBizQqstoryBaseProducer$StoryProducer = new Producer.StoryProducer(new SimpleDataProvider.1(this));
  }
  
  private int a(@Nullable IDataProvider.GroupId paramGroupId)
  {
    if (paramGroupId == null) {
      return -1;
    }
    int i = 0;
    Iterator localIterator = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$Data.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      if (((IDataProvider.GroupInfo)localIterator.next()).jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId.equals(paramGroupId)) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  private IDataProvider.GroupInfo a(@Nullable IDataProvider.GroupId paramGroupId)
  {
    int i = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$Data.jdField_a_of_type_JavaUtilList.indexOf(new IDataProvider.GroupInfo(paramGroupId));
    if (i < 0) {
      return null;
    }
    return (IDataProvider.GroupInfo)this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$Data.jdField_a_of_type_JavaUtilList.get(i);
  }
  
  private List<IDataProvider.GroupId> a(int paramInt1, int paramInt2)
  {
    ArrayList localArrayList = new ArrayList(paramInt2 * 2);
    localData = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$Data;
    int j = paramInt1 - paramInt2;
    int i = j;
    if (j < 0) {
      i = 0;
    }
    j = paramInt1 + paramInt2;
    paramInt2 = i;
    paramInt1 = j;
    try
    {
      if (j >= this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$Data.jdField_a_of_type_JavaUtilList.size())
      {
        paramInt1 = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$Data.jdField_a_of_type_JavaUtilList.size();
        paramInt2 = i;
      }
    }
    finally
    {
      for (;;)
      {
        IDataProvider.GroupInfo localGroupInfo;
        for (;;)
        {
          throw localObject;
        }
        paramInt2 += 1;
      }
    }
    if (paramInt2 < paramInt1)
    {
      localGroupInfo = (IDataProvider.GroupInfo)this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$Data.jdField_a_of_type_JavaUtilList.get(paramInt2);
      if (!localGroupInfo.d()) {
        localArrayList.add(localGroupInfo.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId);
      }
    }
    else
    {
      return localArrayList;
    }
  }
  
  private void a(@Nullable IDataProvider.GroupId paramGroupId)
  {
    SLog.a("Q.qqstory.player.data.SimpleDataProvider", "triggerSyncData curGroupId=%s", paramGroupId.toString());
    synchronized (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$Data)
    {
      int j = a(paramGroupId);
      int i = j;
      if (j < 0) {
        i = 0;
      }
      if ((i + 5 > this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$Data.jdField_a_of_type_JavaUtilList.size()) && (!this.jdField_a_of_type_Boolean))
      {
        SLog.b("Q.qqstory.player.data.SimpleDataProvider", "request next group key");
        this.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = new ErrorMessage();
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId = paramGroupId;
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIGroupPageLoader.a(20, this);
      }
      a(a(i, 2));
      return;
    }
  }
  
  private void a(String paramString1, String paramString2, String paramString3)
  {
    synchronized (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$Data)
    {
      Iterator localIterator = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$Data.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        IDataProvider.GroupInfo localGroupInfo = (IDataProvider.GroupInfo)localIterator.next();
        if (localGroupInfo.jdField_a_of_type_JavaUtilList != null)
        {
          int i = localGroupInfo.jdField_a_of_type_JavaUtilList.indexOf(paramString1);
          if (i >= 0)
          {
            SLog.d("Q.qqstory.player.data.SimpleDataProvider", "on publish success old group=%s", new Object[] { localGroupInfo });
            localGroupInfo.jdField_a_of_type_JavaUtilList.add(i, paramString2);
            localGroupInfo.jdField_a_of_type_JavaUtilList.remove(paramString1);
            localGroupInfo.jdField_a_of_type_JavaUtilMap.put(paramString2, paramString3);
            SLog.d("Q.qqstory.player.data.SimpleDataProvider", "on publish success new group=%s", new Object[] { localGroupInfo });
            c();
            return;
          }
        }
      }
      return;
    }
    for (;;)
    {
      throw paramString1;
    }
  }
  
  private void a(List<IDataProvider.GroupId> paramList)
  {
    if (paramList.size() == 0) {
      return;
    }
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      IDataProvider.GroupId localGroupId = (IDataProvider.GroupId)localIterator.next();
      IDataProvider.GroupInfo localGroupInfo = a(localGroupId);
      if ((localGroupInfo != null) && (!this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIGroupPageLoader.a(localGroupInfo)))
      {
        localIterator.remove();
        SLog.b("Q.qqstory.player.data.SimpleDataProvider", "synVid. remove no need sync group=%s", localGroupInfo);
      }
      else
      {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(localGroupId);
        if (this.b.containsKey(localGroupId))
        {
          SLog.a("Q.qqstory.player.data.SimpleDataProvider", "synVid. ignore same request group info request:%s", localGroupId);
          localIterator.remove();
        }
        else
        {
          this.b.put(localGroupId, Long.valueOf(System.currentTimeMillis()));
        }
      }
    }
    if (paramList.size() > 0)
    {
      SLog.a("Q.qqstory.player.data.SimpleDataProvider", "synVid. start sync group:%s", paramList);
      this.jdField_a_of_type_ComTencentBizQqstoryBaseProducer$StoryProducer.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIGroupPageLoader.a(paramList));
      return;
    }
    c();
  }
  
  private void b(@Nullable IDataProvider.GroupId paramGroupId, int paramInt1, int paramInt2, String arg4)
  {
    int j;
    int i;
    synchronized (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$Data)
    {
      Object localObject = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$Data.jdField_a_of_type_JavaUtilList;
      ArrayList localArrayList = new ArrayList();
      j = a(paramGroupId);
      i = j;
      if (j == -1) {
        i = 0;
      }
      if (paramInt1 == 2)
      {
        j = paramInt2 + i;
        paramInt2 = j;
        if (j >= ((List)localObject).size()) {
          paramInt2 = ((List)localObject).size();
        }
        if (((List)localObject).size() > 0) {
          while (i < paramInt2)
          {
            localArrayList.add(((List)localObject).get(i));
            i += 1;
            continue;
            if (((List)localObject).size() > 0) {
              while (i >= paramInt2)
              {
                localArrayList.add(((List)localObject).get(i));
                i -= 1;
              }
            }
          }
        }
        if (localArrayList.size() == 0)
        {
          if ((paramInt1 == 2) && (!this.jdField_a_of_type_Boolean))
          {
            this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId = paramGroupId;
            SLog.b("Q.qqstory.player.data.SimpleDataProvider", "request new group key list");
            this.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = new ErrorMessage();
            this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIGroupPageLoader.a(20, this);
          }
          else
          {
            c();
          }
        }
        else
        {
          paramGroupId = localArrayList.iterator();
          while (paramGroupId.hasNext())
          {
            localObject = (IDataProvider.GroupInfo)paramGroupId.next();
            if ((((IDataProvider.GroupInfo)localObject).d()) && (((IDataProvider.GroupInfo)localObject).e()))
            {
              SLog.a("Q.qqstory.player.data.SimpleDataProvider", "group data is ok, %s", localObject);
              c();
            }
            else if (!((IDataProvider.GroupInfo)localObject).e())
            {
              SLog.a("Q.qqstory.player.data.SimpleDataProvider.VASH", "not is end so request group vid, %s", ((IDataProvider.GroupInfo)localObject).jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId);
              localArrayList = new ArrayList(1);
              localArrayList.add(((IDataProvider.GroupInfo)localObject).jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId);
              a(localArrayList);
            }
            else
            {
              SLog.a("Q.qqstory.player.data.SimpleDataProvider", "request group vid, %s", ((IDataProvider.GroupInfo)localObject).jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId);
              localArrayList = new ArrayList(1);
              localArrayList.add(((IDataProvider.GroupInfo)localObject).jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId);
              a(localArrayList);
            }
          }
        }
        return;
      }
    }
  }
  
  private void d()
  {
    ThreadManager.getUIHandler().post(new SimpleDataProvider.5(this));
  }
  
  public IDataProvider.Data a(@Nullable IDataProvider.GroupId paramGroupId, int paramInt)
  {
    boolean bool;
    if (paramInt >= 0) {
      bool = true;
    } else {
      bool = false;
    }
    AssertUtils.assertTrue(bool);
    long l = System.currentTimeMillis();
    IDataProvider.Data localData2 = new IDataProvider.Data();
    int m;
    int j;
    int i;
    int k;
    label334:
    label608:
    int n;
    label671:
    label700:
    label709:
    label751:
    synchronized (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$Data)
    {
      m = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$Data.jdField_a_of_type_JavaUtilList.size();
      if (m == 0)
      {
        if (paramGroupId != null) {
          localData2.jdField_a_of_type_JavaUtilList.add(new IDataProvider.FakeGroupInfo(paramGroupId, (ErrorMessage)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramGroupId)));
        }
        if (this.jdField_a_of_type_Boolean)
        {
          localData2.jdField_a_of_type_Boolean = true;
          localData2.jdField_b_of_type_Boolean = true;
          SLog.d("Q.qqstory.player.data.SimpleDataProvider", "get data cur:%s, step:%d, %s", new Object[] { paramGroupId, Integer.valueOf(paramInt), localData2 });
          return localData2;
        }
        localData2.jdField_a_of_type_Boolean = true;
        localData2.jdField_b_of_type_Boolean = false;
        localData2.jdField_b_of_type_ComTencentBizQqstoryBaseErrorMessage = this.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage;
        SLog.d("Q.qqstory.player.data.SimpleDataProvider", "get data cur:%s, step:%d, %s", new Object[] { paramGroupId, Integer.valueOf(paramInt), localData2 });
        return localData2;
      }
      j = a(paramGroupId);
      i = j;
      if (j < 0)
      {
        i = 0;
        break label671;
        if (k >= j)
        {
          localGroupInfo = (IDataProvider.GroupInfo)this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$Data.jdField_a_of_type_JavaUtilList.get(k);
          if (localGroupInfo.d())
          {
            if (localGroupInfo.jdField_a_of_type_JavaUtilList.size() > 0) {
              localData2.jdField_a_of_type_JavaUtilList.add(0, localGroupInfo.a());
            }
            if (k != 0) {
              break label700;
            }
            localData2.jdField_a_of_type_Boolean = true;
            break label700;
          }
          localData2.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = ((ErrorMessage)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localGroupInfo.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId));
          localData2.jdField_a_of_type_Boolean = false;
          break label334;
          localData2.jdField_a_of_type_Boolean = true;
        }
        IDataProvider.GroupInfo localGroupInfo = (IDataProvider.GroupInfo)this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$Data.jdField_a_of_type_JavaUtilList.get(i);
        if (localGroupInfo.d())
        {
          if (localGroupInfo.jdField_a_of_type_JavaUtilList.size() > 0)
          {
            localData2.jdField_a_of_type_JavaUtilList.add(localGroupInfo.a());
            break label709;
          }
          localData2.jdField_a_of_type_JavaUtilList.add(new IDataProvider.FakeGroupInfo(localGroupInfo.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId, new ErrorMessage(97000000, "no data")));
          break label709;
        }
        localData2.jdField_a_of_type_JavaUtilList.add(new IDataProvider.FakeGroupInfo(localGroupInfo.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId, (ErrorMessage)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localGroupInfo.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId)));
        break label709;
        if (j < i)
        {
          localGroupInfo = (IDataProvider.GroupInfo)this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$Data.jdField_a_of_type_JavaUtilList.get(j);
          if (localGroupInfo.d())
          {
            if (localGroupInfo.jdField_a_of_type_JavaUtilList.size() > 0) {
              localData2.jdField_a_of_type_JavaUtilList.add(localGroupInfo.a());
            }
            if (i != m) {
              break label751;
            }
            localData2.jdField_b_of_type_Boolean = this.jdField_a_of_type_Boolean;
            localData2.jdField_b_of_type_ComTencentBizQqstoryBaseErrorMessage = this.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage;
            break label751;
          }
          localData2.jdField_b_of_type_ComTencentBizQqstoryBaseErrorMessage = ((ErrorMessage)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localGroupInfo.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId));
          localData2.jdField_b_of_type_Boolean = false;
          break label608;
          localData2.jdField_b_of_type_Boolean = this.jdField_a_of_type_Boolean;
          localData2.jdField_b_of_type_ComTencentBizQqstoryBaseErrorMessage = this.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage;
        }
        SLog.d("Q.qqstory.player.data.SimpleDataProvider", "get data step:%d, cur:%s,  %s", new Object[] { Integer.valueOf(paramInt), paramGroupId, localData2 });
        SLog.a("Q.qqstory.player.data.SimpleDataProvider", "get data take time:%dms", Long.valueOf(System.currentTimeMillis() - l));
        return localData2;
      }
    }
  }
  
  public IDataProvider.StartInfo a()
  {
    IDataProvider.StartInfo localStartInfo = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIGroupPageLoader.a();
    SLog.a("Q.qqstory.player.data.SimpleDataProvider", "start info:%s", localStartInfo);
    return localStartInfo;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderSimpleDataProvider$VideoPublishUpdateReceiver = new SimpleDataProvider.VideoPublishUpdateReceiver(this);
    StoryDispatcher.a().registerSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderSimpleDataProvider$VideoPublishUpdateReceiver);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderSimpleDataProvider$StoryVideoDeleteReceiver = new SimpleDataProvider.StoryVideoDeleteReceiver(this);
    StoryDispatcher.a().registerSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderSimpleDataProvider$StoryVideoDeleteReceiver);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderSimpleDataProvider$StoryVideoNoInterestingReceiver = new SimpleDataProvider.StoryVideoNoInterestingReceiver(this);
    StoryDispatcher.a().registerSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderSimpleDataProvider$StoryVideoNoInterestingReceiver);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIGroupPageLoader.a();
  }
  
  public void a(ErrorMessage paramErrorMessage, List<IDataProvider.GroupId> paramList)
  {
    SLog.a("Q.qqstory.player.data.SimpleDataProvider", "on vid respond fail %s", paramErrorMessage);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      IDataProvider.GroupId localGroupId = (IDataProvider.GroupId)paramList.next();
      Long localLong = (Long)this.b.remove(localGroupId);
      if (localLong != null) {
        SLog.a("Q.qqstory.player.data.SimpleDataProvider", "get group groupId take time：%d, %s", Long.valueOf(System.currentTimeMillis() - localLong.longValue()), localGroupId);
      }
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localGroupId, paramErrorMessage);
    }
    c();
  }
  
  public void a(ErrorMessage arg1, List<IDataProvider.GroupId> paramList, boolean paramBoolean)
  {
    Object localObject;
    if (paramList == null) {
      localObject = "";
    } else {
      localObject = paramList;
    }
    SLog.a("Q.qqstory.player.data.SimpleDataProvider", "onGroupKeyFinish respond %s, is end:%b %s", localObject, Boolean.valueOf(paramBoolean), ???.toString());
    if (???.isSuccess())
    {
      this.jdField_a_of_type_Boolean = paramBoolean;
      if (paramList != null)
      {
        localObject = paramList.iterator();
        while (((Iterator)localObject).hasNext())
        {
          IDataProvider.GroupId localGroupId = (IDataProvider.GroupId)((Iterator)localObject).next();
          synchronized (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$Data)
          {
            IDataProvider.GroupInfo localGroupInfo = new IDataProvider.GroupInfo(localGroupId);
            if (!this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$Data.jdField_a_of_type_JavaUtilList.contains(localGroupInfo))
            {
              this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$Data.jdField_a_of_type_JavaUtilList.add(localGroupInfo);
              SLog.a("Q.qqstory.player.data.SimpleDataProvider", "add group %s", localGroupId);
            }
            else
            {
              SLog.d("Q.qqstory.player.data.SimpleDataProvider", "data repeat group %s", new Object[] { localGroupId });
            }
          }
        }
        if (paramList.size() > 0)
        {
          localObject = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId;
          ??? = (ErrorMessage)localObject;
          if (localObject == null) {
            ??? = (IDataProvider.GroupId)paramList.get(0);
          }
          a(???);
        }
      }
    }
    else
    {
      this.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = ???;
      c();
    }
  }
  
  public void a(@Nullable IDataProvider.GroupId paramGroupId, int paramInt1, int paramInt2, String paramString)
  {
    SLog.a("Q.qqstory.player.data.SimpleDataProvider", "requestGroupData %s direction=%d, stepSize=%d, curGroupVid=%s", paramGroupId, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString);
    Bosses.get().postLightWeightJob(new SimpleDataProvider.2(this, paramGroupId, paramInt1, paramInt2, paramString), 0);
  }
  
  public void a(@Nullable IDataProvider.GroupId paramGroupId, String paramString)
  {
    Object localObject;
    if (paramGroupId == null) {
      localObject = "";
    } else {
      localObject = paramGroupId;
    }
    SLog.a("Q.qqstory.player.data.SimpleDataProvider", "markCurrentGroup %s, curGroupVid=%s", localObject, paramString);
    Bosses.get().postLightWeightJob(new SimpleDataProvider.3(this, paramGroupId), 0);
  }
  
  public void a(IDataProvider.ICallBack paramICallBack)
  {
    if (!this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.contains(paramICallBack)) {
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(paramICallBack);
    }
  }
  
  void a(String paramString)
  {
    synchronized (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$Data)
    {
      Iterator localIterator1 = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$Data.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator1.hasNext())
      {
        IDataProvider.GroupInfo localGroupInfo = (IDataProvider.GroupInfo)localIterator1.next();
        if (localGroupInfo.jdField_a_of_type_JavaUtilList != null)
        {
          Iterator localIterator2 = localGroupInfo.jdField_a_of_type_JavaUtilList.iterator();
          boolean bool = false;
          int i = 0;
          while (localIterator2.hasNext()) {
            if (((String)localIterator2.next()).equals(paramString))
            {
              localIterator2.remove();
              SLog.d("Q.qqstory.player.data.SimpleDataProvider", "delete vid=%s", new Object[] { paramString });
              i = 1;
            }
          }
          if (i != 0)
          {
            if (localGroupInfo.jdField_a_of_type_JavaUtilList.size() == 0)
            {
              this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$Data.jdField_a_of_type_JavaUtilList.remove(localGroupInfo);
              SLog.d("Q.qqstory.player.data.SimpleDataProvider", "delete vid=%s and group=%s", new Object[] { paramString, localGroupInfo.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId });
              bool = true;
            }
            ThreadManager.getUIHandler().post(new SimpleDataProvider.6(this, localGroupInfo, paramString, bool));
            return;
          }
        }
      }
      return;
    }
    for (;;)
    {
      throw paramString;
    }
  }
  
  public void a(List<IDataProvider.GroupInfo> arg1, boolean paramBoolean)
  {
    SLog.b("Q.qqstory.player.data.SimpleDataProvider", "on vid respond suc");
    Iterator localIterator1 = ???.iterator();
    IDataProvider.GroupInfo localGroupInfo;
    Object localObject2;
    while (localIterator1.hasNext())
    {
      localGroupInfo = (IDataProvider.GroupInfo)localIterator1.next();
      localObject2 = (Long)this.b.remove(localGroupInfo.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId);
      if (localObject2 != null) {
        SLog.a("Q.qqstory.player.data.SimpleDataProvider", "get group info take time：%d, %s", Long.valueOf(System.currentTimeMillis() - ((Long)localObject2).longValue()), localGroupInfo.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId);
      }
    }
    localIterator1 = ???.iterator();
    while (localIterator1.hasNext())
    {
      localGroupInfo = (IDataProvider.GroupInfo)localIterator1.next();
      synchronized (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$Data)
      {
        int i = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$Data.jdField_a_of_type_JavaUtilList.indexOf(localGroupInfo);
        if (i >= 0)
        {
          localObject2 = (IDataProvider.GroupInfo)this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$Data.jdField_a_of_type_JavaUtilList.get(i);
          if (((IDataProvider.GroupInfo)localObject2).jdField_a_of_type_JavaUtilList == null) {
            ((IDataProvider.GroupInfo)localObject2).jdField_a_of_type_JavaUtilList = new ArrayList();
          }
          if (paramBoolean)
          {
            ((IDataProvider.GroupInfo)localObject2).jdField_a_of_type_JavaUtilList = localGroupInfo.jdField_a_of_type_JavaUtilList;
            ((IDataProvider.GroupInfo)localObject2).jdField_a_of_type_JavaUtilMap = localGroupInfo.jdField_a_of_type_JavaUtilMap;
            ((IDataProvider.GroupInfo)localObject2).jdField_a_of_type_JavaLangString = localGroupInfo.jdField_a_of_type_JavaLangString;
          }
          else
          {
            Iterator localIterator2 = localGroupInfo.jdField_a_of_type_JavaUtilList.iterator();
            while (localIterator2.hasNext())
            {
              String str = (String)localIterator2.next();
              if (!((IDataProvider.GroupInfo)localObject2).jdField_a_of_type_JavaUtilList.contains(str))
              {
                ((IDataProvider.GroupInfo)localObject2).jdField_a_of_type_JavaUtilList.add(str);
              }
              else
              {
                ((IDataProvider.GroupInfo)localObject2).jdField_a_of_type_JavaUtilList.add(str);
                SLog.e("Q.qqstory.player.data.SimpleDataProvider", "!!! vid is equal %s", new Object[] { str });
              }
            }
            ((IDataProvider.GroupInfo)localObject2).jdField_a_of_type_JavaUtilMap.putAll(localGroupInfo.jdField_a_of_type_JavaUtilMap);
            ((IDataProvider.GroupInfo)localObject2).jdField_a_of_type_JavaLangString = localGroupInfo.jdField_a_of_type_JavaLangString;
          }
          SLog.a("Q.qqstory.player.data.SimpleDataProvider", "add group vid %s", localGroupInfo.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId);
        }
        else
        {
          SLog.e("Q.qqstory.player.data.SimpleDataProvider", "should happen with group not exist:%s", new Object[] { localGroupInfo.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId });
        }
      }
    }
    c();
  }
  
  public void b()
  {
    StoryDispatcher.a().unRegisterSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderSimpleDataProvider$VideoPublishUpdateReceiver);
    StoryDispatcher.a().unRegisterSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderSimpleDataProvider$StoryVideoDeleteReceiver);
    StoryDispatcher.a().unRegisterSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderSimpleDataProvider$StoryVideoNoInterestingReceiver);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIGroupPageLoader.b();
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
  }
  
  public void b(ErrorMessage arg1, List<IDataProvider.GroupInfo> paramList, boolean paramBoolean)
  {
    if (paramList == null) {
      localObject = "";
    } else {
      localObject = paramList;
    }
    SLog.a("Q.qqstory.player.data.SimpleDataProvider", "on group info respond  %s, is end:%b %s", localObject, Boolean.valueOf(paramBoolean), ???.toString());
    Object localObject = paramList;
    if (paramList == null) {
      localObject = new ArrayList(0);
    }
    paramList = ((List)localObject).iterator();
    while (paramList.hasNext())
    {
      IDataProvider.GroupInfo localGroupInfo = (IDataProvider.GroupInfo)paramList.next();
      Long localLong = (Long)this.b.remove(localGroupInfo.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId);
      if (localLong != null) {
        SLog.a("Q.qqstory.player.data.SimpleDataProvider", "get group info take time：%d, %s", Long.valueOf(System.currentTimeMillis() - localLong.longValue()), localGroupInfo.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId);
      }
    }
    if (???.isSuccess())
    {
      paramList = ((List)localObject).iterator();
      while (paramList.hasNext())
      {
        localObject = (IDataProvider.GroupInfo)paramList.next();
        synchronized (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$Data)
        {
          if (!this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$Data.jdField_a_of_type_JavaUtilList.contains(localObject))
          {
            this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$Data.jdField_a_of_type_JavaUtilList.add(localObject);
            SLog.a("Q.qqstory.player.data.SimpleDataProvider", "add group %s", ((IDataProvider.GroupInfo)localObject).jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId);
          }
          else
          {
            SLog.d("Q.qqstory.player.data.SimpleDataProvider", "data repeat group %s", new Object[] { ((IDataProvider.GroupInfo)localObject).jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId });
          }
        }
      }
      this.jdField_a_of_type_Boolean = paramBoolean;
    }
    else
    {
      this.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = ???;
    }
    c();
  }
  
  public void b(IDataProvider.ICallBack paramICallBack)
  {
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(paramICallBack);
  }
  
  protected void c()
  {
    int i;
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndIncrement() == 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      d();
      return;
    }
    ThreadManager.getSubThreadHandler().postDelayed(new SimpleDataProvider.4(this), 500L);
  }
  
  public boolean isValidate()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.dataprovider.SimpleDataProvider
 * JD-Core Version:    0.7.0.1
 */