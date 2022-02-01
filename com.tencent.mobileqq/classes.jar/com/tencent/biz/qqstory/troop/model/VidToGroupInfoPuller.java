package com.tencent.biz.qqstory.troop.model;

import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.StoryDispatcher;
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
import com.tribe.async.dispatch.IEventReceiver;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class VidToGroupInfoPuller
  implements IEventReceiver
{
  public int a;
  IVidToVideoInfoPuller.OnFinishCallBack a;
  protected StoryManager a;
  protected BatchHandlerListPuller a;
  protected String a;
  protected List<String> a;
  protected AtomicBoolean a;
  
  public VidToGroupInfoPuller(String paramString, List<String> paramList)
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
  
  protected BatchHandlerListPuller a(List<String> paramList)
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
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.getAndSet(true)) {
      return;
    }
    this.jdField_a_of_type_Int = 1;
    Bosses.get().postJob(new VidToGroupInfoPuller.1(this, "Q.qqstory.net:VidToGroupInfoPuller"));
  }
  
  public boolean a()
  {
    int i = this.jdField_a_of_type_Int;
    boolean bool = true;
    if (i != 1)
    {
      if (i == 3) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  protected boolean a(List<String> paramList, ErrorMessage paramErrorMessage, boolean paramBoolean1, boolean paramBoolean2)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = paramList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      paramList = (String)((Iterator)localObject).next();
      StoryVideoItem localStoryVideoItem = this.jdField_a_of_type_ComTencentBizQqstoryModelStoryManager.a(paramList);
      if (localStoryVideoItem == null)
      {
        localObject = new StoryVideoItem();
        ((StoryVideoItem)localObject).mStoryType = 2;
        ((StoryVideoItem)localObject).mVid = paramList;
      }
      while ((!paramBoolean1) && ((TextUtils.isEmpty(localStoryVideoItem.getVideoUrl())) || (TextUtils.isEmpty(localStoryVideoItem.getThumbUrl()))))
      {
        bool = true;
        break;
      }
      localArrayList.add(localStoryVideoItem);
    }
    boolean bool = false;
    if (bool) {
      localArrayList.clear();
    }
    paramList = new DefaultPlayerVideoListSynchronizer.PlayerVideoListEvent();
    paramList.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = paramErrorMessage;
    paramList.jdField_a_of_type_Boolean = (paramBoolean1 ^ true);
    paramList.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    paramList.b = (bool ^ true);
    paramList.jdField_a_of_type_JavaUtilList = localArrayList;
    paramList.jdField_a_of_type_Int = localArrayList.size();
    StoryDispatcher.a().dispatch(paramList);
    if (paramBoolean1)
    {
      int i = this.jdField_a_of_type_Int;
      if (i == 1)
      {
        this.jdField_a_of_type_Int = 2;
        return bool;
      }
      if (i == 3)
      {
        this.jdField_a_of_type_Int = 4;
        paramList = this.jdField_a_of_type_ComTencentBizQqstoryModelIVidToVideoInfoPuller$OnFinishCallBack;
        if (paramList != null) {
          paramList.a(localArrayList, paramBoolean2);
        }
      }
    }
    return bool;
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryNetworkBatchHandlerListPuller = a(this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_ComTencentBizQqstoryNetworkBatchHandlerListPuller.a("Q.qqstory.net:VidToGroupInfoPuller");
    this.jdField_a_of_type_ComTencentBizQqstoryNetworkBatchHandlerListPuller.a(new VidToGroupInfoPuller.2(this));
    this.jdField_a_of_type_ComTencentBizQqstoryNetworkBatchHandlerListPuller.b();
  }
  
  public boolean isValidate()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.troop.model.VidToGroupInfoPuller
 * JD-Core Version:    0.7.0.1
 */