package com.tencent.biz.qqstory.model;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.network.BatchHandlerListPuller;
import com.tencent.biz.qqstory.network.handler.UidToVidHandler;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.AssertUtils;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.IEventReceiver;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.List<Ljava.lang.String;>;
import java.util.concurrent.atomic.AtomicBoolean;

public class VidToVideoInfoPuller
  implements IVidToVideoInfoPuller, IEventReceiver
{
  protected int a;
  protected long a;
  protected IVidToVideoInfoPuller.OnFinishCallBack a;
  protected VidToVideoInfoPuller.StoryVidListReceiver a;
  protected BatchHandlerListPuller a;
  protected UidToVidHandler a;
  protected String a;
  protected List<String> a;
  protected AtomicBoolean a;
  protected boolean a;
  protected int b;
  protected IVidToVideoInfoPuller.OnFinishCallBack b;
  protected String b;
  public int c;
  protected String c;
  
  public VidToVideoInfoPuller(String paramString1, String paramString2, int paramInt)
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_c_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Int = 1;
    this.jdField_c_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public VidToVideoInfoPuller(String paramString1, String paramString2, String paramString3)
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_c_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Int = 0;
    this.jdField_c_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_JavaLangString = paramString3;
    this.jdField_b_of_type_JavaLangString = paramString2;
  }
  
  protected BatchHandlerListPuller a(@NonNull List<String> paramList)
  {
    BatchHandlerListPuller localBatchHandlerListPuller = BatchHandlerListPuller.a(paramList);
    localBatchHandlerListPuller.a("Q.qqstory.net:VidToVideoInfoPuller");
    localBatchHandlerListPuller.a(new VidToVideoInfoPuller.5(this, paramList));
    return localBatchHandlerListPuller;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.getAndSet(true)) {
      return;
    }
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_c_of_type_Int = 1;
    SLog.d("Q.qqstory.net:VidToVideoInfoPuller", String.format("Start , %s", new Object[] { this }));
    b();
  }
  
  protected void a(@NonNull List<String> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_ComTencentBizQqstoryNetworkBatchHandlerListPuller = a(paramList);
    a(paramList, new ErrorMessage(), false, false);
    this.jdField_a_of_type_ComTencentBizQqstoryNetworkBatchHandlerListPuller.b();
  }
  
  protected void a(List<String> paramList, ErrorMessage paramErrorMessage, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject1 = new ArrayList();
    StoryManager localStoryManager = (StoryManager)SuperManager.a(5);
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localObject2 = localStoryManager.a(str);
      paramList = (List<String>)localObject2;
      if (localObject2 == null)
      {
        paramList = new StoryVideoItem();
        paramList.mVid = str;
      }
      if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
        paramList.mOwnerUid = this.jdField_b_of_type_JavaLangString;
      }
      ((List)localObject1).add(paramList);
    }
    paramList = new DefaultPlayerVideoListSynchronizer.PlayerVideoListEvent();
    paramList.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = paramErrorMessage;
    paramList.jdField_a_of_type_Boolean = (paramBoolean1 ^ true);
    paramList.jdField_a_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
    paramList.jdField_b_of_type_Boolean = paramBoolean1;
    paramList.jdField_a_of_type_JavaUtilList = ((List)localObject1);
    paramList.jdField_a_of_type_Int = ((List)localObject1).size();
    paramList.jdField_b_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
    StoryDispatcher.a().dispatch(paramList);
    if (paramBoolean1)
    {
      i = this.jdField_c_of_type_Int;
      if (i == 1)
      {
        this.jdField_c_of_type_Int = 2;
        localObject2 = this.jdField_a_of_type_ComTencentBizQqstoryModelIVidToVideoInfoPuller$OnFinishCallBack;
        if (localObject2 != null) {
          ((IVidToVideoInfoPuller.OnFinishCallBack)localObject2).a(paramList.jdField_a_of_type_JavaUtilList, paramBoolean2);
        }
      }
      else if (i == 3)
      {
        this.jdField_c_of_type_Int = 4;
        localObject2 = this.jdField_b_of_type_ComTencentBizQqstoryModelIVidToVideoInfoPuller$OnFinishCallBack;
        if (localObject2 != null) {
          ((IVidToVideoInfoPuller.OnFinishCallBack)localObject2).a(paramList.jdField_a_of_type_JavaUtilList, paramBoolean2);
        }
      }
    }
    if (((List)localObject1).size() > 10) {
      paramList = ((List)localObject1).subList(0, 10);
    } else {
      paramList = (List<String>)localObject1;
    }
    Object localObject2 = this.jdField_b_of_type_JavaLangString;
    int i = ((List)localObject1).size();
    if (paramBoolean1) {
      localObject1 = "from net ";
    } else {
      localObject1 = "from local";
    }
    SLog.d("Q.qqstory.net:VidToVideoInfoPuller", "Dispatch event , uin = %s , count = %d , error = %s , %s ,video list = %s ,use total time = %d", new Object[] { localObject2, Integer.valueOf(i), paramErrorMessage, localObject1, paramList, Long.valueOf(System.currentTimeMillis() - this.jdField_a_of_type_Long) });
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  protected void b()
  {
    if (this.jdField_c_of_type_Int == 3)
    {
      List localList = this.jdField_a_of_type_JavaUtilList;
      if ((localList != null) && (localList.size() > 0))
      {
        a(this.jdField_a_of_type_JavaUtilList);
        return;
      }
    }
    int i = this.jdField_a_of_type_Int;
    if (i == 0)
    {
      c();
      return;
    }
    if (i == 1)
    {
      i = this.jdField_b_of_type_Int;
      if (i == 4) {
        d();
      } else if (i == 6) {
        f();
      } else {
        e();
      }
    }
    if (this.jdField_a_of_type_Int == 2) {
      a(this.jdField_a_of_type_JavaUtilList);
    }
  }
  
  protected void c()
  {
    AssertUtils.checkNotNull(this.jdField_a_of_type_JavaLangString);
    Bosses.get().postJob(new VidToVideoInfoPuller.1(this, "Q.qqstory.net:VidToVideoInfoPuller"));
  }
  
  protected void d()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      SLog.d("Q.qqstory.net:VidToVideoInfoPuller", "requestMyVidList() load from local storage");
      Bosses.get().postJob(new VidToVideoInfoPuller.2(this, "Q.qqstory.net:VidToVideoInfoPuller"));
      return;
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryModelVidToVideoInfoPuller$StoryVidListReceiver == null)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryModelVidToVideoInfoPuller$StoryVidListReceiver = new VidToVideoInfoPuller.StoryVidListReceiver(this);
      StoryDispatcher.a().registerSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryModelVidToVideoInfoPuller$StoryVidListReceiver);
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QQStoryContext.a().b());
    this.jdField_a_of_type_ComTencentBizQqstoryNetworkHandlerUidToVidHandler = new UidToVidHandler(localArrayList, this.jdField_b_of_type_Int);
    this.jdField_a_of_type_ComTencentBizQqstoryNetworkHandlerUidToVidHandler.a();
    SLog.d("Q.qqstory.net:VidToVideoInfoPuller", "requestMyVidList() load from network pullType = %d, uinList = %s", new Object[] { Integer.valueOf(this.jdField_b_of_type_Int), localArrayList });
  }
  
  protected void e()
  {
    Bosses.get().postJob(new VidToVideoInfoPuller.3(this, "Q.qqstory.net:VidToVideoInfoPuller"));
  }
  
  protected void f()
  {
    Bosses.get().postJob(new VidToVideoInfoPuller.4(this, "Q.qqstory.net:VidToVideoInfoPuller"));
  }
  
  public boolean isValidate()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("VidToVideoInfoPuller{, mSource=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", mCollectionKey='");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mUin='");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mContext='");
    localStringBuilder.append(this.jdField_c_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.VidToVideoInfoPuller
 * JD-Core Version:    0.7.0.1
 */