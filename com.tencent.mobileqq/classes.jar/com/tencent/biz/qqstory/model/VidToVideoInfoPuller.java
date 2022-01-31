package com.tencent.biz.qqstory.model;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.network.BatchHandlerListPuller;
import com.tencent.biz.qqstory.network.handler.UidToVidHandler;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.AssertUtils;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatchers;
import com.tribe.async.dispatch.IEventReceiver;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import nca;
import ncb;
import ncd;
import nce;
import ncf;

public class VidToVideoInfoPuller
  implements IVidToVideoInfoPuller, IEventReceiver
{
  protected int a;
  protected long a;
  protected IVidToVideoInfoPuller.OnFinishCallBack a;
  public VidToVideoInfoPuller.StoryVidListReceiver a;
  protected BatchHandlerListPuller a;
  public UidToVidHandler a;
  public String a;
  protected List a;
  protected AtomicBoolean a;
  public boolean a;
  public int b;
  protected IVidToVideoInfoPuller.OnFinishCallBack b;
  public String b;
  public int c;
  protected String c;
  
  public VidToVideoInfoPuller(String paramString1, String paramString2, int paramInt)
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
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
    this.jdField_c_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Int = 0;
    this.jdField_c_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_JavaLangString = paramString3;
    this.jdField_b_of_type_JavaLangString = paramString2;
  }
  
  protected BatchHandlerListPuller a(@NonNull List paramList)
  {
    BatchHandlerListPuller localBatchHandlerListPuller = BatchHandlerListPuller.a(paramList);
    localBatchHandlerListPuller.a("Q.qqstory.net:VidToVideoInfoPuller");
    localBatchHandlerListPuller.a(new ncf(this, paramList));
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
    c();
  }
  
  public void a(@NonNull List paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_ComTencentBizQqstoryNetworkBatchHandlerListPuller = a(paramList);
    a(paramList, new ErrorMessage(), false, false);
    this.jdField_a_of_type_ComTencentBizQqstoryNetworkBatchHandlerListPuller.b();
  }
  
  public void a(List paramList, ErrorMessage paramErrorMessage, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject1 = new ArrayList();
    Object localObject2 = (StoryManager)SuperManager.a(5);
    Iterator localIterator = paramList.iterator();
    if (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      paramList = ((StoryManager)localObject2).a(str);
      if (paramList != null) {
        break label372;
      }
      paramList = new StoryVideoItem();
      paramList.mVid = str;
    }
    label216:
    label239:
    label372:
    for (;;)
    {
      if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
        paramList.mOwnerUid = this.jdField_b_of_type_JavaLangString;
      }
      ((List)localObject1).add(paramList);
      break;
      paramList = new DefaultPlayerVideoListSynchronizer.PlayerVideoListEvent();
      paramList.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = paramErrorMessage;
      boolean bool;
      int i;
      if (!paramBoolean1)
      {
        bool = true;
        paramList.jdField_a_of_type_Boolean = bool;
        paramList.jdField_a_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
        paramList.jdField_b_of_type_Boolean = paramBoolean1;
        paramList.jdField_a_of_type_JavaUtilList = ((List)localObject1);
        paramList.jdField_a_of_type_Int = ((List)localObject1).size();
        paramList.jdField_b_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
        Dispatchers.get().dispatch(paramList);
        if (paramBoolean1)
        {
          if (this.jdField_c_of_type_Int != 1) {
            break label321;
          }
          this.jdField_c_of_type_Int = 2;
          if (this.jdField_a_of_type_ComTencentBizQqstoryModelIVidToVideoInfoPuller$OnFinishCallBack != null) {
            this.jdField_a_of_type_ComTencentBizQqstoryModelIVidToVideoInfoPuller$OnFinishCallBack.a(paramList.jdField_a_of_type_JavaUtilList, paramBoolean2);
          }
        }
        if (((List)localObject1).size() <= 10) {
          break label359;
        }
        paramList = ((List)localObject1).subList(0, 10);
        localObject2 = this.jdField_b_of_type_JavaLangString;
        i = ((List)localObject1).size();
        if (!paramBoolean1) {
          break label365;
        }
      }
      for (localObject1 = "from net ";; localObject1 = "from local")
      {
        SLog.d("Q.qqstory.net:VidToVideoInfoPuller", "Dispatch event , uin = %s , count = %d , error = %s , %s ,video list = %s ,use total time = %d", new Object[] { localObject2, Integer.valueOf(i), paramErrorMessage, localObject1, paramList, Long.valueOf(System.currentTimeMillis() - this.jdField_a_of_type_Long) });
        return;
        bool = false;
        break;
        if (this.jdField_c_of_type_Int != 3) {
          break label216;
        }
        this.jdField_c_of_type_Int = 4;
        if (this.jdField_b_of_type_ComTencentBizQqstoryModelIVidToVideoInfoPuller$OnFinishCallBack == null) {
          break label216;
        }
        this.jdField_b_of_type_ComTencentBizQqstoryModelIVidToVideoInfoPuller$OnFinishCallBack.a(paramList.jdField_a_of_type_JavaUtilList, paramBoolean2);
        break label216;
        paramList = (List)localObject1;
        break label239;
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return (this.jdField_c_of_type_Int == 2) || (this.jdField_c_of_type_Int == 4);
  }
  
  public boolean a(IVidToVideoInfoPuller.OnFinishCallBack paramOnFinishCallBack)
  {
    if (a())
    {
      this.jdField_b_of_type_ComTencentBizQqstoryModelIVidToVideoInfoPuller$OnFinishCallBack = paramOnFinishCallBack;
      this.jdField_c_of_type_Int = 3;
      SLog.d("Q.qqstory.net:VidToVideoInfoPuller", "Retry , %s", new Object[] { this });
      c();
      return true;
    }
    SLog.d("Q.qqstory.net:VidToVideoInfoPuller", "Cannot retry , current state = %d", new Object[] { Integer.valueOf(this.jdField_c_of_type_Int) });
    return false;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryNetworkBatchHandlerListPuller != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryNetworkBatchHandlerListPuller.a();
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryModelVidToVideoInfoPuller$StoryVidListReceiver != null) {
      Dispatchers.get().unRegisterSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryModelVidToVideoInfoPuller$StoryVidListReceiver);
    }
  }
  
  protected void c()
  {
    if ((this.jdField_c_of_type_Int == 3) && (this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0)) {
      a(this.jdField_a_of_type_JavaUtilList);
    }
    for (;;)
    {
      return;
      if (this.jdField_a_of_type_Int == 0)
      {
        d();
        return;
      }
      if (this.jdField_a_of_type_Int == 1)
      {
        if (this.jdField_b_of_type_Int != 4) {
          break label85;
        }
        e();
      }
      while (this.jdField_a_of_type_Int == 2)
      {
        a(this.jdField_a_of_type_JavaUtilList);
        return;
        label85:
        if (this.jdField_b_of_type_Int == 6) {
          g();
        } else {
          f();
        }
      }
    }
  }
  
  protected void d()
  {
    AssertUtils.a(this.jdField_a_of_type_JavaLangString);
    Bosses.get().postJob(new nca(this));
  }
  
  protected void e()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      SLog.d("Q.qqstory.net:VidToVideoInfoPuller", "requestMyVidList() load from local storage");
      Bosses.get().postJob(new ncb(this));
      return;
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryModelVidToVideoInfoPuller$StoryVidListReceiver == null)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryModelVidToVideoInfoPuller$StoryVidListReceiver = new VidToVideoInfoPuller.StoryVidListReceiver(this);
      Dispatchers.get().registerSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryModelVidToVideoInfoPuller$StoryVidListReceiver);
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QQStoryContext.a().b());
    this.jdField_a_of_type_ComTencentBizQqstoryNetworkHandlerUidToVidHandler = new UidToVidHandler(localArrayList, this.jdField_b_of_type_Int);
    this.jdField_a_of_type_ComTencentBizQqstoryNetworkHandlerUidToVidHandler.a();
    SLog.d("Q.qqstory.net:VidToVideoInfoPuller", "requestMyVidList() load from network pullType = %d, uinList = %s", new Object[] { Integer.valueOf(this.jdField_b_of_type_Int), localArrayList });
  }
  
  protected void f()
  {
    Bosses.get().postJob(new ncd(this));
  }
  
  protected void g()
  {
    Bosses.get().postJob(new nce(this));
  }
  
  public boolean isValidate()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
  }
  
  public String toString()
  {
    return "VidToVideoInfoPuller{, mSource=" + this.jdField_a_of_type_Int + ", mCollectionKey='" + this.jdField_a_of_type_JavaLangString + '\'' + ", mUin='" + this.jdField_b_of_type_JavaLangString + '\'' + ", mContext='" + this.jdField_c_of_type_JavaLangString + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.VidToVideoInfoPuller
 * JD-Core Version:    0.7.0.1
 */