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
  protected ErrorMessage a = new ErrorMessage();
  protected boolean b = false;
  private final IDataProvider.Data c = new IDataProvider.Data();
  private final Producer.StoryProducer<IGroupPageLoader.IVidFullSyncer> d;
  private IGroupPageLoader e;
  private CopyOnWriteArrayList<IDataProvider.ICallBack> f = new CopyOnWriteArrayList();
  private ConcurrentHashMap<IDataProvider.GroupId, ErrorMessage> g = new ConcurrentHashMap();
  private ConcurrentHashMap<IDataProvider.GroupId, Long> h = new ConcurrentHashMap();
  private SimpleDataProvider.StoryVideoDeleteReceiver i;
  private SimpleDataProvider.StoryVideoNoInterestingReceiver j;
  private AtomicInteger k = new AtomicInteger(0);
  private IDataProvider.GroupId l;
  private SimpleDataProvider.VideoPublishUpdateReceiver m;
  
  public SimpleDataProvider(IGroupPageLoader paramIGroupPageLoader)
  {
    SLog.a("Q.qqstory.player.data.SimpleDataProvider", "use loader %s", paramIGroupPageLoader);
    this.e = paramIGroupPageLoader;
    this.d = new Producer.StoryProducer(new SimpleDataProvider.1(this));
  }
  
  private int a(@Nullable IDataProvider.GroupId paramGroupId)
  {
    if (paramGroupId == null) {
      return -1;
    }
    int n = 0;
    Iterator localIterator = this.c.c.iterator();
    while (localIterator.hasNext())
    {
      if (((IDataProvider.GroupInfo)localIterator.next()).b.equals(paramGroupId)) {
        return n;
      }
      n += 1;
    }
    return -1;
  }
  
  private List<IDataProvider.GroupId> a(int paramInt1, int paramInt2)
  {
    ArrayList localArrayList = new ArrayList(paramInt2 * 2);
    localData = this.c;
    int i1 = paramInt1 - paramInt2;
    int n = i1;
    if (i1 < 0) {
      n = 0;
    }
    i1 = paramInt1 + paramInt2;
    paramInt2 = n;
    paramInt1 = i1;
    try
    {
      if (i1 >= this.c.c.size())
      {
        paramInt1 = this.c.c.size();
        paramInt2 = n;
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
      localGroupInfo = (IDataProvider.GroupInfo)this.c.c.get(paramInt2);
      if (!localGroupInfo.e()) {
        localArrayList.add(localGroupInfo.b);
      }
    }
    else
    {
      return localArrayList;
    }
  }
  
  private void a(String paramString1, String paramString2, String paramString3)
  {
    synchronized (this.c)
    {
      Iterator localIterator = this.c.c.iterator();
      while (localIterator.hasNext())
      {
        IDataProvider.GroupInfo localGroupInfo = (IDataProvider.GroupInfo)localIterator.next();
        if (localGroupInfo.c != null)
        {
          int n = localGroupInfo.c.indexOf(paramString1);
          if (n >= 0)
          {
            SLog.d("Q.qqstory.player.data.SimpleDataProvider", "on publish success old group=%s", new Object[] { localGroupInfo });
            localGroupInfo.c.add(n, paramString2);
            localGroupInfo.c.remove(paramString1);
            localGroupInfo.d.put(paramString2, paramString3);
            SLog.d("Q.qqstory.player.data.SimpleDataProvider", "on publish success new group=%s", new Object[] { localGroupInfo });
            d();
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
      IDataProvider.GroupInfo localGroupInfo = b(localGroupId);
      if ((localGroupInfo != null) && (!this.e.a(localGroupInfo)))
      {
        localIterator.remove();
        SLog.b("Q.qqstory.player.data.SimpleDataProvider", "synVid. remove no need sync group=%s", localGroupInfo);
      }
      else
      {
        this.g.remove(localGroupId);
        if (this.h.containsKey(localGroupId))
        {
          SLog.a("Q.qqstory.player.data.SimpleDataProvider", "synVid. ignore same request group info request:%s", localGroupId);
          localIterator.remove();
        }
        else
        {
          this.h.put(localGroupId, Long.valueOf(System.currentTimeMillis()));
        }
      }
    }
    if (paramList.size() > 0)
    {
      SLog.a("Q.qqstory.player.data.SimpleDataProvider", "synVid. start sync group:%s", paramList);
      this.d.a(this.e.a(paramList));
      return;
    }
    d();
  }
  
  private IDataProvider.GroupInfo b(@Nullable IDataProvider.GroupId paramGroupId)
  {
    int n = this.c.c.indexOf(new IDataProvider.GroupInfo(paramGroupId));
    if (n < 0) {
      return null;
    }
    return (IDataProvider.GroupInfo)this.c.c.get(n);
  }
  
  private void b(@Nullable IDataProvider.GroupId paramGroupId, int paramInt1, int paramInt2, String arg4)
  {
    int i1;
    int n;
    synchronized (this.c)
    {
      Object localObject = this.c.c;
      ArrayList localArrayList = new ArrayList();
      i1 = a(paramGroupId);
      n = i1;
      if (i1 == -1) {
        n = 0;
      }
      if (paramInt1 == 2)
      {
        i1 = paramInt2 + n;
        paramInt2 = i1;
        if (i1 >= ((List)localObject).size()) {
          paramInt2 = ((List)localObject).size();
        }
        if (((List)localObject).size() > 0) {
          while (n < paramInt2)
          {
            localArrayList.add(((List)localObject).get(n));
            n += 1;
            continue;
            if (((List)localObject).size() > 0) {
              while (n >= paramInt2)
              {
                localArrayList.add(((List)localObject).get(n));
                n -= 1;
              }
            }
          }
        }
        if (localArrayList.size() == 0)
        {
          if ((paramInt1 == 2) && (!this.b))
          {
            this.l = paramGroupId;
            SLog.b("Q.qqstory.player.data.SimpleDataProvider", "request new group key list");
            this.a = new ErrorMessage();
            this.e.a(20, this);
          }
          else
          {
            d();
          }
        }
        else
        {
          paramGroupId = localArrayList.iterator();
          while (paramGroupId.hasNext())
          {
            localObject = (IDataProvider.GroupInfo)paramGroupId.next();
            if ((((IDataProvider.GroupInfo)localObject).e()) && (((IDataProvider.GroupInfo)localObject).f()))
            {
              SLog.a("Q.qqstory.player.data.SimpleDataProvider", "group data is ok, %s", localObject);
              d();
            }
            else if (!((IDataProvider.GroupInfo)localObject).f())
            {
              SLog.a("Q.qqstory.player.data.SimpleDataProvider.VASH", "not is end so request group vid, %s", ((IDataProvider.GroupInfo)localObject).b);
              localArrayList = new ArrayList(1);
              localArrayList.add(((IDataProvider.GroupInfo)localObject).b);
              a(localArrayList);
            }
            else
            {
              SLog.a("Q.qqstory.player.data.SimpleDataProvider", "request group vid, %s", ((IDataProvider.GroupInfo)localObject).b);
              localArrayList = new ArrayList(1);
              localArrayList.add(((IDataProvider.GroupInfo)localObject).b);
              a(localArrayList);
            }
          }
        }
        return;
      }
    }
  }
  
  private void c(@Nullable IDataProvider.GroupId paramGroupId)
  {
    SLog.a("Q.qqstory.player.data.SimpleDataProvider", "triggerSyncData curGroupId=%s", paramGroupId.toString());
    synchronized (this.c)
    {
      int i1 = a(paramGroupId);
      int n = i1;
      if (i1 < 0) {
        n = 0;
      }
      if ((n + 5 > this.c.c.size()) && (!this.b))
      {
        SLog.b("Q.qqstory.player.data.SimpleDataProvider", "request next group key");
        this.a = new ErrorMessage();
        this.l = paramGroupId;
        this.e.a(20, this);
      }
      a(a(n, 2));
      return;
    }
  }
  
  private void e()
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
    long l1 = System.currentTimeMillis();
    IDataProvider.Data localData2 = new IDataProvider.Data();
    int i3;
    int i1;
    int n;
    int i2;
    label334:
    label608:
    int i4;
    label671:
    label700:
    label709:
    label751:
    synchronized (this.c)
    {
      i3 = this.c.c.size();
      if (i3 == 0)
      {
        if (paramGroupId != null) {
          localData2.c.add(new IDataProvider.FakeGroupInfo(paramGroupId, (ErrorMessage)this.g.get(paramGroupId)));
        }
        if (this.b)
        {
          localData2.b = true;
          localData2.d = true;
          SLog.d("Q.qqstory.player.data.SimpleDataProvider", "get data cur:%s, step:%d, %s", new Object[] { paramGroupId, Integer.valueOf(paramInt), localData2 });
          return localData2;
        }
        localData2.b = true;
        localData2.d = false;
        localData2.e = this.a;
        SLog.d("Q.qqstory.player.data.SimpleDataProvider", "get data cur:%s, step:%d, %s", new Object[] { paramGroupId, Integer.valueOf(paramInt), localData2 });
        return localData2;
      }
      i1 = a(paramGroupId);
      n = i1;
      if (i1 < 0)
      {
        n = 0;
        break label671;
        if (i2 >= i1)
        {
          localGroupInfo = (IDataProvider.GroupInfo)this.c.c.get(i2);
          if (localGroupInfo.e())
          {
            if (localGroupInfo.c.size() > 0) {
              localData2.c.add(0, localGroupInfo.d());
            }
            if (i2 != 0) {
              break label700;
            }
            localData2.b = true;
            break label700;
          }
          localData2.a = ((ErrorMessage)this.g.get(localGroupInfo.b));
          localData2.b = false;
          break label334;
          localData2.b = true;
        }
        IDataProvider.GroupInfo localGroupInfo = (IDataProvider.GroupInfo)this.c.c.get(n);
        if (localGroupInfo.e())
        {
          if (localGroupInfo.c.size() > 0)
          {
            localData2.c.add(localGroupInfo.d());
            break label709;
          }
          localData2.c.add(new IDataProvider.FakeGroupInfo(localGroupInfo.b, new ErrorMessage(97000000, "no data")));
          break label709;
        }
        localData2.c.add(new IDataProvider.FakeGroupInfo(localGroupInfo.b, (ErrorMessage)this.g.get(localGroupInfo.b)));
        break label709;
        if (i1 < n)
        {
          localGroupInfo = (IDataProvider.GroupInfo)this.c.c.get(i1);
          if (localGroupInfo.e())
          {
            if (localGroupInfo.c.size() > 0) {
              localData2.c.add(localGroupInfo.d());
            }
            if (n != i3) {
              break label751;
            }
            localData2.d = this.b;
            localData2.e = this.a;
            break label751;
          }
          localData2.e = ((ErrorMessage)this.g.get(localGroupInfo.b));
          localData2.d = false;
          break label608;
          localData2.d = this.b;
          localData2.e = this.a;
        }
        SLog.d("Q.qqstory.player.data.SimpleDataProvider", "get data step:%d, cur:%s,  %s", new Object[] { Integer.valueOf(paramInt), paramGroupId, localData2 });
        SLog.a("Q.qqstory.player.data.SimpleDataProvider", "get data take time:%dms", Long.valueOf(System.currentTimeMillis() - l1));
        return localData2;
      }
    }
  }
  
  public void a()
  {
    this.m = new SimpleDataProvider.VideoPublishUpdateReceiver(this);
    StoryDispatcher.a().registerSubscriber(this.m);
    this.i = new SimpleDataProvider.StoryVideoDeleteReceiver(this);
    StoryDispatcher.a().registerSubscriber(this.i);
    this.j = new SimpleDataProvider.StoryVideoNoInterestingReceiver(this);
    StoryDispatcher.a().registerSubscriber(this.j);
    this.e.a();
  }
  
  public void a(ErrorMessage paramErrorMessage, List<IDataProvider.GroupId> paramList)
  {
    SLog.a("Q.qqstory.player.data.SimpleDataProvider", "on vid respond fail %s", paramErrorMessage);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      IDataProvider.GroupId localGroupId = (IDataProvider.GroupId)paramList.next();
      Long localLong = (Long)this.h.remove(localGroupId);
      if (localLong != null) {
        SLog.a("Q.qqstory.player.data.SimpleDataProvider", "get group groupId take time：%d, %s", Long.valueOf(System.currentTimeMillis() - localLong.longValue()), localGroupId);
      }
      this.g.put(localGroupId, paramErrorMessage);
    }
    d();
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
      this.b = paramBoolean;
      if (paramList != null)
      {
        localObject = paramList.iterator();
        while (((Iterator)localObject).hasNext())
        {
          IDataProvider.GroupId localGroupId = (IDataProvider.GroupId)((Iterator)localObject).next();
          synchronized (this.c)
          {
            IDataProvider.GroupInfo localGroupInfo = new IDataProvider.GroupInfo(localGroupId);
            if (!this.c.c.contains(localGroupInfo))
            {
              this.c.c.add(localGroupInfo);
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
          localObject = this.l;
          ??? = (ErrorMessage)localObject;
          if (localObject == null) {
            ??? = (IDataProvider.GroupId)paramList.get(0);
          }
          c(???);
        }
      }
    }
    else
    {
      this.a = ???;
      d();
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
    if (!this.f.contains(paramICallBack)) {
      this.f.add(paramICallBack);
    }
  }
  
  void a(String paramString)
  {
    synchronized (this.c)
    {
      Iterator localIterator1 = this.c.c.iterator();
      while (localIterator1.hasNext())
      {
        IDataProvider.GroupInfo localGroupInfo = (IDataProvider.GroupInfo)localIterator1.next();
        if (localGroupInfo.c != null)
        {
          Iterator localIterator2 = localGroupInfo.c.iterator();
          boolean bool = false;
          int n = 0;
          while (localIterator2.hasNext()) {
            if (((String)localIterator2.next()).equals(paramString))
            {
              localIterator2.remove();
              SLog.d("Q.qqstory.player.data.SimpleDataProvider", "delete vid=%s", new Object[] { paramString });
              n = 1;
            }
          }
          if (n != 0)
          {
            if (localGroupInfo.c.size() == 0)
            {
              this.c.c.remove(localGroupInfo);
              SLog.d("Q.qqstory.player.data.SimpleDataProvider", "delete vid=%s and group=%s", new Object[] { paramString, localGroupInfo.b });
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
      localObject2 = (Long)this.h.remove(localGroupInfo.b);
      if (localObject2 != null) {
        SLog.a("Q.qqstory.player.data.SimpleDataProvider", "get group info take time：%d, %s", Long.valueOf(System.currentTimeMillis() - ((Long)localObject2).longValue()), localGroupInfo.b);
      }
    }
    localIterator1 = ???.iterator();
    while (localIterator1.hasNext())
    {
      localGroupInfo = (IDataProvider.GroupInfo)localIterator1.next();
      synchronized (this.c)
      {
        int n = this.c.c.indexOf(localGroupInfo);
        if (n >= 0)
        {
          localObject2 = (IDataProvider.GroupInfo)this.c.c.get(n);
          if (((IDataProvider.GroupInfo)localObject2).c == null) {
            ((IDataProvider.GroupInfo)localObject2).c = new ArrayList();
          }
          if (paramBoolean)
          {
            ((IDataProvider.GroupInfo)localObject2).c = localGroupInfo.c;
            ((IDataProvider.GroupInfo)localObject2).d = localGroupInfo.d;
            ((IDataProvider.GroupInfo)localObject2).f = localGroupInfo.f;
          }
          else
          {
            Iterator localIterator2 = localGroupInfo.c.iterator();
            while (localIterator2.hasNext())
            {
              String str = (String)localIterator2.next();
              if (!((IDataProvider.GroupInfo)localObject2).c.contains(str))
              {
                ((IDataProvider.GroupInfo)localObject2).c.add(str);
              }
              else
              {
                ((IDataProvider.GroupInfo)localObject2).c.add(str);
                SLog.e("Q.qqstory.player.data.SimpleDataProvider", "!!! vid is equal %s", new Object[] { str });
              }
            }
            ((IDataProvider.GroupInfo)localObject2).d.putAll(localGroupInfo.d);
            ((IDataProvider.GroupInfo)localObject2).f = localGroupInfo.f;
          }
          SLog.a("Q.qqstory.player.data.SimpleDataProvider", "add group vid %s", localGroupInfo.b);
        }
        else
        {
          SLog.e("Q.qqstory.player.data.SimpleDataProvider", "should happen with group not exist:%s", new Object[] { localGroupInfo.b });
        }
      }
    }
    d();
  }
  
  public void b()
  {
    StoryDispatcher.a().unRegisterSubscriber(this.m);
    StoryDispatcher.a().unRegisterSubscriber(this.i);
    StoryDispatcher.a().unRegisterSubscriber(this.j);
    this.e.b();
    this.f.clear();
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
      Long localLong = (Long)this.h.remove(localGroupInfo.b);
      if (localLong != null) {
        SLog.a("Q.qqstory.player.data.SimpleDataProvider", "get group info take time：%d, %s", Long.valueOf(System.currentTimeMillis() - localLong.longValue()), localGroupInfo.b);
      }
    }
    if (???.isSuccess())
    {
      paramList = ((List)localObject).iterator();
      while (paramList.hasNext())
      {
        localObject = (IDataProvider.GroupInfo)paramList.next();
        synchronized (this.c)
        {
          if (!this.c.c.contains(localObject))
          {
            this.c.c.add(localObject);
            SLog.a("Q.qqstory.player.data.SimpleDataProvider", "add group %s", ((IDataProvider.GroupInfo)localObject).b);
          }
          else
          {
            SLog.d("Q.qqstory.player.data.SimpleDataProvider", "data repeat group %s", new Object[] { ((IDataProvider.GroupInfo)localObject).b });
          }
        }
      }
      this.b = paramBoolean;
    }
    else
    {
      this.a = ???;
    }
    d();
  }
  
  public void b(IDataProvider.ICallBack paramICallBack)
  {
    this.f.remove(paramICallBack);
  }
  
  public IDataProvider.StartInfo c()
  {
    IDataProvider.StartInfo localStartInfo = this.e.c();
    SLog.a("Q.qqstory.player.data.SimpleDataProvider", "start info:%s", localStartInfo);
    return localStartInfo;
  }
  
  protected void d()
  {
    int n;
    if (this.k.getAndIncrement() == 0) {
      n = 1;
    } else {
      n = 0;
    }
    if (n != 0)
    {
      e();
      return;
    }
    ThreadManager.getSubThreadHandler().postDelayed(new SimpleDataProvider.4(this), 500L);
  }
  
  public boolean isValidate()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.dataprovider.SimpleDataProvider
 * JD-Core Version:    0.7.0.1
 */