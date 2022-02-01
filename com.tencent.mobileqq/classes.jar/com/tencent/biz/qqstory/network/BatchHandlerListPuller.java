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
  protected BatchHandlerListPuller.IPullResultCallback a;
  protected String a;
  protected List<BatchNetHandler> a;
  protected AtomicBoolean a;
  protected boolean a;
  protected List<BatchNetHandler> b;
  protected AtomicBoolean b;
  protected List<BatchNetHandler> c = new ArrayList();
  protected List<BatchNetHandler> d = new ArrayList();
  
  public BatchHandlerListPuller(List<BatchNetHandler> paramList)
  {
    this.jdField_a_of_type_JavaLangString = "Q.qqstory.net:BatchHandlerListPuller";
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_a_of_type_Boolean = false;
    if ((paramList != null) && (paramList.size() != 0))
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext()) {
        ((BatchNetHandler)localIterator.next()).a(this);
      }
      this.jdField_a_of_type_JavaUtilList = new ArrayList(paramList);
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
  }
  
  public static BatchHandlerListPuller a(ArrayList<String> paramArrayList)
  {
    ArrayList localArrayList1 = new ArrayList();
    int j;
    for (int i = 0; i < paramArrayList.size(); i = j)
    {
      j = Math.min(paramArrayList.size(), i + 20);
      if (i >= j) {
        break;
      }
      List localList = paramArrayList.subList(i, j);
      ArrayList localArrayList2 = new ArrayList();
      i = 0;
      while (i < localList.size())
      {
        localArrayList2.add(new QQUserUIItem.UserID("", (String)localList.get(i)));
        i += 1;
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
    int j;
    for (int i = 0; i < localArrayList.size(); i = j)
    {
      j = Math.min(localArrayList.size(), i + 20);
      if (i >= j) {
        break;
      }
      paramList.add(new VidToBasicInfoHandler(localArrayList.subList(i, j)));
    }
    return new BatchHandlerListPuller(paramList);
  }
  
  public void a()
  {
    try
    {
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
      this.jdField_a_of_type_ComTencentBizQqstoryNetworkBatchHandlerListPuller$IPullResultCallback = null;
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
    this.jdField_a_of_type_ComTencentBizQqstoryNetworkBatchHandlerListPuller$IPullResultCallback = paramIPullResultCallback;
  }
  
  public void a(BatchNetHandler paramBatchNetHandler)
  {
    for (;;)
    {
      try
      {
        this.jdField_b_of_type_JavaUtilList.remove(paramBatchNetHandler);
        this.c.add(paramBatchNetHandler);
        paramBatchNetHandler = this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean;
        if ((this.jdField_b_of_type_JavaUtilList.size() == 0) && (this.d.size() == 0))
        {
          bool = true;
          paramBatchNetHandler.set(bool);
          if (this.jdField_b_of_type_JavaUtilList.size() == 0)
          {
            if (this.jdField_a_of_type_ComTencentBizQqstoryNetworkBatchHandlerListPuller$IPullResultCallback != null) {
              this.jdField_a_of_type_ComTencentBizQqstoryNetworkBatchHandlerListPuller$IPullResultCallback.a(this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
            }
            String str = this.jdField_a_of_type_JavaLangString;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("All finish !");
            if (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
            {
              paramBatchNetHandler = "Every task succeed !";
            }
            else
            {
              paramBatchNetHandler = new StringBuilder();
              paramBatchNetHandler.append(this.d.size());
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
    this.jdField_a_of_type_JavaLangString = localStringBuilder.toString();
  }
  
  public boolean a()
  {
    try
    {
      int i = this.jdField_b_of_type_JavaUtilList.size();
      boolean bool;
      if (i > 0) {
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
  
  public void b()
  {
    try
    {
      boolean bool = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
      if (bool) {
        return;
      }
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      if (this.jdField_a_of_type_Boolean)
      {
        SLog.d(this.jdField_a_of_type_JavaLangString, "Task list is empty , return result now");
        if (this.jdField_a_of_type_ComTencentBizQqstoryNetworkBatchHandlerListPuller$IPullResultCallback != null) {
          this.jdField_a_of_type_ComTencentBizQqstoryNetworkBatchHandlerListPuller$IPullResultCallback.a(this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
        }
        return;
      }
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      int i = 0;
      while (localIterator.hasNext())
      {
        BatchNetHandler localBatchNetHandler = (BatchNetHandler)localIterator.next();
        this.jdField_b_of_type_JavaUtilList.add(localBatchNetHandler);
        localBatchNetHandler.a();
        i += 1;
      }
      this.jdField_a_of_type_JavaUtilList.clear();
      SLog.d(this.jdField_a_of_type_JavaLangString, "Run! Request count = %d", new Object[] { Integer.valueOf(i) });
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
        if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
        {
          bool = paramBatchNetHandler.a();
          if (!bool)
          {
            this.jdField_b_of_type_JavaUtilList.remove(paramBatchNetHandler);
            this.d.add(paramBatchNetHandler);
            this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
            if (this.jdField_b_of_type_JavaUtilList.size() == 0)
            {
              if (this.jdField_a_of_type_ComTencentBizQqstoryNetworkBatchHandlerListPuller$IPullResultCallback != null) {
                this.jdField_a_of_type_ComTencentBizQqstoryNetworkBatchHandlerListPuller$IPullResultCallback.a(this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
              }
              String str = this.jdField_a_of_type_JavaLangString;
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("All finish !");
              Object localObject;
              if (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
              {
                localObject = "Every task succeed !";
              }
              else
              {
                localObject = new StringBuilder();
                ((StringBuilder)localObject).append(this.d.size());
                ((StringBuilder)localObject).append(" task fail");
                localObject = ((StringBuilder)localObject).toString();
              }
              localStringBuilder.append((String)localObject);
              SLog.d(str, localStringBuilder.toString());
            }
            SLog.d(this.jdField_a_of_type_JavaLangString, String.format("Fail ! Handler = %s", new Object[] { paramBatchNetHandler }));
          }
          return;
        }
      }
      finally {}
      boolean bool = false;
    }
  }
  
  public boolean b()
  {
    return this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.BatchHandlerListPuller
 * JD-Core Version:    0.7.0.1
 */