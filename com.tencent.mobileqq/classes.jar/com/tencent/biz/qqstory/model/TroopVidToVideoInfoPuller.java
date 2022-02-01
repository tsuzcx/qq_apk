package com.tencent.biz.qqstory.model;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.network.BatchHandlerListPuller;
import com.tencent.biz.qqstory.network.handler.TroopUidToVidListHandler;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.IEventReceiver;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.List<Ljava.lang.String;>;
import java.util.concurrent.atomic.AtomicBoolean;

public class TroopVidToVideoInfoPuller
  implements IEventReceiver
{
  protected int a;
  protected long a;
  protected IVidToVideoInfoPuller.OnFinishCallBack a;
  protected TroopVidToVideoInfoPuller.StoryVidListReceiver a;
  protected BatchHandlerListPuller a;
  protected TroopUidToVidListHandler a;
  protected String a;
  protected List<String> a;
  protected AtomicBoolean a;
  protected boolean a;
  public int b;
  protected IVidToVideoInfoPuller.OnFinishCallBack b;
  protected String b;
  
  public TroopVidToVideoInfoPuller(String paramString1, String paramString2, int paramInt)
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  protected BatchHandlerListPuller a(@NonNull List<String> paramList)
  {
    BatchHandlerListPuller localBatchHandlerListPuller = BatchHandlerListPuller.a(paramList);
    localBatchHandlerListPuller.a("Q.qqstory.net:TroopVidToVideoInfoPuller");
    localBatchHandlerListPuller.a(new TroopVidToVideoInfoPuller.2(this, paramList));
    return localBatchHandlerListPuller;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.getAndSet(true)) {
      return;
    }
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_b_of_type_Int = 1;
    SLog.d("Q.qqstory.net:TroopVidToVideoInfoPuller", String.format("Start , %s", new Object[] { this }));
    b();
  }
  
  protected void a(@NonNull List<String> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_ComTencentBizQqstoryNetworkBatchHandlerListPuller = a(paramList);
    this.jdField_a_of_type_ComTencentBizQqstoryNetworkBatchHandlerListPuller.b();
  }
  
  protected void a(List<String> paramList, ErrorMessage paramErrorMessage, boolean paramBoolean1, boolean paramBoolean2)
  {
    ArrayList localArrayList = new ArrayList();
    StoryManager localStoryManager = (StoryManager)SuperManager.a(5);
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localObject = localStoryManager.a(str);
      paramList = (List<String>)localObject;
      if (localObject == null)
      {
        paramList = new StoryVideoItem();
        paramList.mVid = str;
      }
      localArrayList.add(paramList);
    }
    paramList = new DefaultPlayerVideoListSynchronizer.PlayerVideoListEvent();
    paramList.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = paramErrorMessage;
    paramList.jdField_a_of_type_Boolean = (paramBoolean1 ^ true);
    paramList.jdField_a_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
    paramList.jdField_b_of_type_Boolean = paramBoolean1;
    paramList.jdField_a_of_type_JavaUtilList = localArrayList;
    paramList.jdField_a_of_type_Int = localArrayList.size();
    paramList.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    StoryDispatcher.a().dispatch(paramList);
    if (paramBoolean1)
    {
      i = this.jdField_b_of_type_Int;
      if (i == 1)
      {
        this.jdField_b_of_type_Int = 2;
        localObject = this.jdField_a_of_type_ComTencentBizQqstoryModelIVidToVideoInfoPuller$OnFinishCallBack;
        if (localObject != null) {
          ((IVidToVideoInfoPuller.OnFinishCallBack)localObject).a(paramList.jdField_a_of_type_JavaUtilList, paramBoolean2);
        }
      }
      else if (i == 3)
      {
        this.jdField_b_of_type_Int = 4;
        localObject = this.jdField_b_of_type_ComTencentBizQqstoryModelIVidToVideoInfoPuller$OnFinishCallBack;
        if (localObject != null) {
          ((IVidToVideoInfoPuller.OnFinishCallBack)localObject).a(paramList.jdField_a_of_type_JavaUtilList, paramBoolean2);
        }
      }
    }
    Object localObject = this.jdField_a_of_type_JavaLangString;
    int i = localArrayList.size();
    if (paramBoolean1) {
      paramList = "from net ";
    } else {
      paramList = "from local";
    }
    SLog.d("Q.qqstory.net:TroopVidToVideoInfoPuller", "Dispatch event , uin = %s , count = %d , error = %s , %s ,video list = %s ,use total time = %d", new Object[] { localObject, Integer.valueOf(i), paramErrorMessage, paramList, localArrayList, Long.valueOf(System.currentTimeMillis() - this.jdField_a_of_type_Long) });
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  protected void b()
  {
    if (this.jdField_b_of_type_Int == 3)
    {
      List localList = this.jdField_a_of_type_JavaUtilList;
      if ((localList != null) && (localList.size() > 0))
      {
        a(this.jdField_a_of_type_JavaUtilList);
        return;
      }
    }
    if (this.jdField_a_of_type_Int == 3) {
      c();
    }
  }
  
  protected void c()
  {
    Bosses.get().postJob(new TroopVidToVideoInfoPuller.1(this, "Q.qqstory.net:TroopVidToVideoInfoPuller"));
  }
  
  public boolean isValidate()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("VidToVideoInfoPuller{, mUin='");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mContext='");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.TroopVidToVideoInfoPuller
 * JD-Core Version:    0.7.0.1
 */