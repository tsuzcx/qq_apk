package com.tencent.biz.qqstory.troop.model;

import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.DefaultPlayerVideoListSynchronizer.PlayerVideoListEvent;
import com.tencent.biz.qqstory.model.IVidToVideoInfoPuller.OnFinishCallBack;
import com.tencent.biz.qqstory.model.StoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.network.BatchHandlerListPuller;
import com.tencent.biz.qqstory.network.handler.VidToBasicInfoHandler;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatchers;
import com.tribe.async.dispatch.IEventReceiver;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import oob;
import ooc;

public class VidToGroupInfoPuller
  implements IEventReceiver
{
  public int a;
  IVidToVideoInfoPuller.OnFinishCallBack a;
  protected StoryManager a;
  protected BatchHandlerListPuller a;
  protected String a;
  public List a;
  protected AtomicBoolean a;
  
  public VidToGroupInfoPuller(String paramString, List paramList)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentBizQqstoryModelStoryManager = ((StoryManager)SuperManager.a(5));
    paramString = paramList;
    if (paramList == null) {
      paramString = new ArrayList();
    }
    this.jdField_a_of_type_JavaUtilList = paramString;
  }
  
  protected BatchHandlerListPuller a(List paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      if (!StoryVideoItem.isFakeVid(str))
      {
        StoryVideoItem localStoryVideoItem = this.jdField_a_of_type_ComTencentBizQqstoryModelStoryManager.a(str);
        if ((localStoryVideoItem == null) || (localStoryVideoItem.mBasicInfoState != 1) || (TextUtils.isEmpty(localStoryVideoItem.getVideoUrl())) || (TextUtils.isEmpty(localStoryVideoItem.getThumbUrl()))) {
          localArrayList.add(str);
        }
      }
    }
    paramList = new ArrayList();
    int j;
    for (int i = 0;; i = j)
    {
      if (i < localArrayList.size())
      {
        j = Math.min(localArrayList.size(), i + 20);
        if (i < j) {}
      }
      else
      {
        return new BatchHandlerListPuller(paramList);
      }
      paramList.add(new VidToBasicInfoHandler(localArrayList.subList(i, j)));
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.getAndSet(true)) {
      return;
    }
    this.jdField_a_of_type_Int = 1;
    Bosses.get().postJob(new oob(this));
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Int == 2) || (this.jdField_a_of_type_Int == 4);
  }
  
  public boolean a(List paramList, ErrorMessage paramErrorMessage, boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool3 = false;
    ArrayList localArrayList = new ArrayList();
    Object localObject = paramList.iterator();
    StoryVideoItem localStoryVideoItem;
    boolean bool1;
    if (((Iterator)localObject).hasNext())
    {
      paramList = (String)((Iterator)localObject).next();
      localStoryVideoItem = this.jdField_a_of_type_ComTencentBizQqstoryModelStoryManager.a(paramList);
      if (localStoryVideoItem == null)
      {
        localObject = new StoryVideoItem();
        ((StoryVideoItem)localObject).mStoryType = 2;
        ((StoryVideoItem)localObject).mVid = paramList;
        bool1 = true;
      }
    }
    for (;;)
    {
      label80:
      if (bool1) {
        localArrayList.clear();
      }
      paramList = new DefaultPlayerVideoListSynchronizer.PlayerVideoListEvent();
      paramList.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = paramErrorMessage;
      boolean bool2;
      if (!paramBoolean1)
      {
        bool2 = true;
        label112:
        paramList.jdField_a_of_type_Boolean = bool2;
        paramList.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
        bool2 = bool3;
        if (!bool1) {
          bool2 = true;
        }
        paramList.b = bool2;
        paramList.jdField_a_of_type_JavaUtilList = localArrayList;
        paramList.jdField_a_of_type_Int = localArrayList.size();
        Dispatchers.get().dispatch(paramList);
        if (paramBoolean1)
        {
          if (this.jdField_a_of_type_Int != 1) {
            break label241;
          }
          this.jdField_a_of_type_Int = 2;
        }
      }
      label241:
      do
      {
        do
        {
          return bool1;
          if ((!paramBoolean1) && ((TextUtils.isEmpty(localStoryVideoItem.getVideoUrl())) || (TextUtils.isEmpty(localStoryVideoItem.getThumbUrl()))))
          {
            bool1 = true;
            break label80;
          }
          localArrayList.add(localStoryVideoItem);
          break;
          bool2 = false;
          break label112;
        } while (this.jdField_a_of_type_Int != 3);
        this.jdField_a_of_type_Int = 4;
      } while (this.jdField_a_of_type_ComTencentBizQqstoryModelIVidToVideoInfoPuller$OnFinishCallBack == null);
      this.jdField_a_of_type_ComTencentBizQqstoryModelIVidToVideoInfoPuller$OnFinishCallBack.a(localArrayList, paramBoolean2);
      return bool1;
      bool1 = false;
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryNetworkBatchHandlerListPuller = a(this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_ComTencentBizQqstoryNetworkBatchHandlerListPuller.a("Q.qqstory.net:VidToGroupInfoPuller");
    this.jdField_a_of_type_ComTencentBizQqstoryNetworkBatchHandlerListPuller.a(new ooc(this));
    this.jdField_a_of_type_ComTencentBizQqstoryNetworkBatchHandlerListPuller.b();
  }
  
  public boolean b()
  {
    return (this.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_Int == 3);
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryNetworkBatchHandlerListPuller != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryNetworkBatchHandlerListPuller.a();
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryModelIVidToVideoInfoPuller$OnFinishCallBack != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryModelIVidToVideoInfoPuller$OnFinishCallBack = null;
    }
  }
  
  public boolean isValidate()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.troop.model.VidToGroupInfoPuller
 * JD-Core Version:    0.7.0.1
 */