package com.tencent.biz.qqstory.network;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.model.StoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.item.QQUserUIItem.UserID;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.network.handler.GetUserInfoHandler;
import com.tencent.biz.qqstory.network.handler.VidToBasicInfoHandler;
import com.tencent.biz.qqstory.support.logging.SLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class BatchHandlerListPuller
{
  protected String a = "Q.qqstory.net:BatchHandlerListPuller";
  protected List<BatchNetHandler> b = new ArrayList();
  protected List<BatchNetHandler> c = new ArrayList();
  protected List<BatchNetHandler> d = new ArrayList();
  protected List<BatchNetHandler> e = new ArrayList();
  protected AtomicBoolean f = new AtomicBoolean(false);
  protected AtomicBoolean g = new AtomicBoolean(false);
  protected boolean h = false;
  protected BatchHandlerListPuller.IPullResultCallback i;
  
  public BatchHandlerListPuller(List<BatchNetHandler> paramList)
  {
    if ((paramList != null) && (paramList.size() != 0))
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext()) {
        ((BatchNetHandler)localIterator.next()).a(this);
      }
      this.b = new ArrayList(paramList);
      return;
    }
    this.h = true;
    this.g.set(true);
  }
  
  public static BatchHandlerListPuller a(ArrayList<String> paramArrayList)
  {
    ArrayList localArrayList1 = new ArrayList();
    int k;
    for (int j = 0; j < paramArrayList.size(); j = k)
    {
      k = Math.min(paramArrayList.size(), j + 20);
      if (j >= k) {
        break;
      }
      List localList = paramArrayList.subList(j, k);
      ArrayList localArrayList2 = new ArrayList();
      j = 0;
      while (j < localList.size())
      {
        localArrayList2.add(new QQUserUIItem.UserID("", (String)localList.get(j)));
        j += 1;
      }
      localArrayList1.add(new GetUserInfoHandler(1, localArrayList2));
    }
    return new BatchHandlerListPuller(localArrayList1);
  }
  
  public static BatchHandlerListPuller a(@NonNull List<String> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    StoryManager localStoryManager = (StoryManager)SuperManager.a(5);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      if (!StoryVideoItem.isFakeVid(str))
      {
        StoryVideoItem localStoryVideoItem = localStoryManager.a(str);
        if ((localStoryVideoItem == null) || (localStoryVideoItem.mBasicInfoState != 1) || (localStoryVideoItem.mVideoIndex == 0L)) {
          localArrayList.add(str);
        }
      }
    }
    paramList = new ArrayList();
    int k;
    for (int j = 0; j < localArrayList.size(); j = k)
    {
      k = Math.min(localArrayList.size(), j + 20);
      if (j >= k) {
        break;
      }
      paramList.add(new VidToBasicInfoHandler(localArrayList.subList(j, k)));
    }
    return new BatchHandlerListPuller(paramList);
  }
  
  public void a()
  {
    try
    {
      this.f.set(false);
      this.i = null;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(BatchHandlerListPuller.IPullResultCallback paramIPullResultCallback)
  {
    this.i = paramIPullResultCallback;
  }
  
  public void a(BatchNetHandler paramBatchNetHandler)
  {
    for (;;)
    {
      try
      {
        this.c.remove(paramBatchNetHandler);
        this.d.add(paramBatchNetHandler);
        paramBatchNetHandler = this.g;
        if ((this.c.size() == 0) && (this.e.size() == 0))
        {
          bool = true;
          paramBatchNetHandler.set(bool);
          if (this.c.size() == 0)
          {
            if (this.i != null) {
              this.i.a(this.g.get());
            }
            String str = this.a;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("All finish !");
            if (this.g.get())
            {
              paramBatchNetHandler = "Every task succeed !";
            }
            else
            {
              paramBatchNetHandler = new StringBuilder();
              paramBatchNetHandler.append(this.e.size());
              paramBatchNetHandler.append(" task fail");
              paramBatchNetHandler = paramBatchNetHandler.toString();
            }
            localStringBuilder.append(paramBatchNetHandler);
            SLog.d(str, localStringBuilder.toString());
          }
          return;
        }
      }
      finally {}
      boolean bool = false;
    }
  }
  
  public void a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(":BatchHandlerListPuller");
    this.a = localStringBuilder.toString();
  }
  
  public void b()
  {
    try
    {
      boolean bool = this.f.get();
      if (bool) {
        return;
      }
      this.f.set(true);
      if (this.h)
      {
        SLog.d(this.a, "Task list is empty , return result now");
        if (this.i != null) {
          this.i.a(this.g.get());
        }
        return;
      }
      Iterator localIterator = this.b.iterator();
      int j = 0;
      while (localIterator.hasNext())
      {
        BatchNetHandler localBatchNetHandler = (BatchNetHandler)localIterator.next();
        this.c.add(localBatchNetHandler);
        localBatchNetHandler.a();
        j += 1;
      }
      this.b.clear();
      SLog.d(this.a, "Run! Request count = %d", new Object[] { Integer.valueOf(j) });
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  public void b(BatchNetHandler paramBatchNetHandler)
  {
    for (;;)
    {
      try
      {
        if (this.f.get())
        {
          bool = paramBatchNetHandler.b();
          if (!bool)
          {
            this.c.remove(paramBatchNetHandler);
            this.e.add(paramBatchNetHandler);
            this.g.set(false);
            if (this.c.size() == 0)
            {
              if (this.i != null) {
                this.i.a(this.g.get());
              }
              String str = this.a;
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("All finish !");
              Object localObject;
              if (this.g.get())
              {
                localObject = "Every task succeed !";
              }
              else
              {
                localObject = new StringBuilder();
                ((StringBuilder)localObject).append(this.e.size());
                ((StringBuilder)localObject).append(" task fail");
                localObject = ((StringBuilder)localObject).toString();
              }
              localStringBuilder.append((String)localObject);
              SLog.d(str, localStringBuilder.toString());
            }
            SLog.d(this.a, String.format("Fail ! Handler = %s", new Object[] { paramBatchNetHandler }));
          }
          return;
        }
      }
      finally {}
      boolean bool = false;
    }
  }
  
  public boolean c()
  {
    try
    {
      int j = this.c.size();
      boolean bool;
      if (j > 0) {
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
  
  public boolean d()
  {
    return this.g.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.BatchHandlerListPuller
 * JD-Core Version:    0.7.0.1
 */