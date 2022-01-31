package com.tencent.biz.qqstory.model;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.network.BatchHandlerListPuller;
import com.tencent.biz.qqstory.network.handler.TroopUidToVidListHandler;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatchers;
import com.tribe.async.dispatch.IEventReceiver;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import nhc;
import nhd;

public class TroopVidToVideoInfoPuller
  implements IEventReceiver
{
  public int a;
  protected long a;
  protected IVidToVideoInfoPuller.OnFinishCallBack a;
  public TroopVidToVideoInfoPuller.StoryVidListReceiver a;
  protected BatchHandlerListPuller a;
  public TroopUidToVidListHandler a;
  public String a;
  protected List a;
  protected AtomicBoolean a;
  public boolean a;
  public int b;
  protected IVidToVideoInfoPuller.OnFinishCallBack b;
  protected String b;
  
  public TroopVidToVideoInfoPuller(String paramString1, String paramString2, int paramInt)
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  protected BatchHandlerListPuller a(@NonNull List paramList)
  {
    BatchHandlerListPuller localBatchHandlerListPuller = BatchHandlerListPuller.a(paramList);
    localBatchHandlerListPuller.a("Q.qqstory.net:TroopVidToVideoInfoPuller");
    localBatchHandlerListPuller.a(new nhd(this, paramList));
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
    c();
  }
  
  public void a(@NonNull List paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_ComTencentBizQqstoryNetworkBatchHandlerListPuller = a(paramList);
    this.jdField_a_of_type_ComTencentBizQqstoryNetworkBatchHandlerListPuller.b();
  }
  
  public void a(List paramList, ErrorMessage paramErrorMessage, boolean paramBoolean1, boolean paramBoolean2)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = (StoryManager)SuperManager.a(5);
    Iterator localIterator = paramList.iterator();
    if (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      paramList = ((StoryManager)localObject).a(str);
      if (paramList != null) {
        break label323;
      }
      paramList = new StoryVideoItem();
      paramList.mVid = str;
    }
    label279:
    label317:
    label323:
    for (;;)
    {
      localArrayList.add(paramList);
      break;
      paramList = new DefaultPlayerVideoListSynchronizer.PlayerVideoListEvent();
      paramList.errorInfo = paramErrorMessage;
      boolean bool;
      label198:
      int i;
      if (!paramBoolean1)
      {
        bool = true;
        paramList.jdField_a_of_type_Boolean = bool;
        paramList.jdField_a_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
        paramList.jdField_b_of_type_Boolean = paramBoolean1;
        paramList.jdField_a_of_type_JavaUtilList = localArrayList;
        paramList.jdField_a_of_type_Int = localArrayList.size();
        paramList.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
        Dispatchers.get().dispatch(paramList);
        if (paramBoolean1)
        {
          if (this.jdField_b_of_type_Int != 1) {
            break label279;
          }
          this.jdField_b_of_type_Int = 2;
          if (this.jdField_a_of_type_ComTencentBizQqstoryModelIVidToVideoInfoPuller$OnFinishCallBack != null) {
            this.jdField_a_of_type_ComTencentBizQqstoryModelIVidToVideoInfoPuller$OnFinishCallBack.a(paramList.jdField_a_of_type_JavaUtilList, paramBoolean2);
          }
        }
        localObject = this.jdField_a_of_type_JavaLangString;
        i = localArrayList.size();
        if (!paramBoolean1) {
          break label317;
        }
      }
      for (paramList = "from net ";; paramList = "from local")
      {
        SLog.d("Q.qqstory.net:TroopVidToVideoInfoPuller", "Dispatch event , uin = %s , count = %d , error = %s , %s ,video list = %s ,use total time = %d", new Object[] { localObject, Integer.valueOf(i), paramErrorMessage, paramList, localArrayList, Long.valueOf(System.currentTimeMillis() - this.jdField_a_of_type_Long) });
        return;
        bool = false;
        break;
        if (this.jdField_b_of_type_Int != 3) {
          break label198;
        }
        this.jdField_b_of_type_Int = 4;
        if (this.jdField_b_of_type_ComTencentBizQqstoryModelIVidToVideoInfoPuller$OnFinishCallBack == null) {
          break label198;
        }
        this.jdField_b_of_type_ComTencentBizQqstoryModelIVidToVideoInfoPuller$OnFinishCallBack.a(paramList.jdField_a_of_type_JavaUtilList, paramBoolean2);
        break label198;
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return (this.jdField_b_of_type_Int == 2) || (this.jdField_b_of_type_Int == 4);
  }
  
  public boolean a(IVidToVideoInfoPuller.OnFinishCallBack paramOnFinishCallBack)
  {
    if (a())
    {
      this.jdField_b_of_type_ComTencentBizQqstoryModelIVidToVideoInfoPuller$OnFinishCallBack = paramOnFinishCallBack;
      this.jdField_b_of_type_Int = 3;
      SLog.d("Q.qqstory.net:TroopVidToVideoInfoPuller", "Retry , %s", new Object[] { this });
      c();
      return true;
    }
    SLog.d("Q.qqstory.net:TroopVidToVideoInfoPuller", "Cannot retry , current state = %d", new Object[] { Integer.valueOf(this.jdField_b_of_type_Int) });
    return false;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryNetworkBatchHandlerListPuller != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryNetworkBatchHandlerListPuller.a();
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryModelTroopVidToVideoInfoPuller$StoryVidListReceiver != null) {
      Dispatchers.get().unRegisterSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryModelTroopVidToVideoInfoPuller$StoryVidListReceiver);
    }
  }
  
  protected void c()
  {
    if ((this.jdField_b_of_type_Int == 3) && (this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0)) {
      a(this.jdField_a_of_type_JavaUtilList);
    }
    while (this.jdField_a_of_type_Int != 3) {
      return;
    }
    d();
  }
  
  protected void d()
  {
    Bosses.get().postJob(new nhc(this));
  }
  
  public boolean isValidate()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
  }
  
  public String toString()
  {
    return "VidToVideoInfoPuller{, mUin='" + this.jdField_a_of_type_JavaLangString + '\'' + ", mContext='" + this.jdField_b_of_type_JavaLangString + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.TroopVidToVideoInfoPuller
 * JD-Core Version:    0.7.0.1
 */