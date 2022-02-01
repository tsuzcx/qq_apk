package com.tencent.biz.qqstory.troop.model;

import android.text.TextUtils;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.biz.qqstory.model.DefaultPlayerVideoListSynchronizer;
import com.tencent.biz.qqstory.model.DefaultPlayerVideoListSynchronizer.PlayerVideoListEvent;
import com.tencent.biz.qqstory.model.DefaultPlayerVideoListSynchronizer.RetryableSynchronizer;
import com.tencent.biz.qqstory.model.IVidToVideoInfoPuller.OnFinishCallBack;
import com.tencent.biz.qqstory.model.StoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.UserManager;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.network.BatchHandlerListPuller;
import com.tencent.biz.qqstory.troop.TroopStoryManager;
import com.tencent.biz.qqstory.troop.TroopStoryUtil;
import com.tencent.imcore.message.BaseMsgProxy;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageForTroopStory;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.Dispatcher;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class TroopStoryAIOVideoListSynchronizer
  extends DefaultPlayerVideoListSynchronizer
  implements DefaultPlayerVideoListSynchronizer.RetryableSynchronizer
{
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  IVidToVideoInfoPuller.OnFinishCallBack jdField_a_of_type_ComTencentBizQqstoryModelIVidToVideoInfoPuller$OnFinishCallBack;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  String jdField_a_of_type_JavaLangString;
  HashSet<String> jdField_a_of_type_JavaUtilHashSet;
  List<StoryVideoItem> jdField_a_of_type_JavaUtilList;
  AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean;
  long jdField_b_of_type_Long;
  String jdField_b_of_type_JavaLangString;
  List<String> jdField_b_of_type_JavaUtilList;
  boolean jdField_b_of_type_Boolean;
  boolean c;
  
  private void a(List<MessageRecord> paramList, List<StoryVideoItem> paramList1, List<StoryVideoItem> paramList2, List<String> paramList3)
  {
    TroopStoryManager localTroopStoryManager = (TroopStoryManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_STORY_MANAGER);
    UserManager localUserManager = (UserManager)SuperManager.a(2);
    StoryManager localStoryManager = (StoryManager)SuperManager.a(5);
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
      if (((localMessageRecord instanceof MessageForShortVideo)) && (((MessageForShortVideo)localMessageRecord).busiType == 1))
      {
        paramList = (MessageForShortVideo)localMessageRecord;
        localObject = TroopStoryUtil.a(paramList);
        localTroopStoryManager.a((String)localObject, paramList.shmsgseq);
        localStoryVideoItem = new StoryVideoItem();
        localStoryVideoItem.mStoryType = 2;
        localStoryVideoItem.mVid = ((String)localObject);
        localStoryVideoItem.mVideoMd5 = paramList.getMd5();
        localStoryVideoItem.mLocalVideoPath = ShortVideoUtils.getShortVideoSavePath(paramList, "mp4");
        localStoryVideoItem.mVideoLocalThumbnailPath = ShortVideoUtils.getShortVideoThumbPicPath(paramList.thumbMD5, "jpg");
        localStoryVideoItem.mLocalMaskPath = "";
        localStoryVideoItem.mOwnerUid = localUserManager.b(paramList.senderuin, true);
        localStoryVideoItem.mCreateTime = (paramList.time * 1000L);
        localStoryVideoItem.mVideoWidth = paramList.thumbWidth;
        localStoryVideoItem.mVideoHeight = paramList.thumbHeight;
        localStoryVideoItem.mVideoDuration = (paramList.videoFileTime * 1000L);
        paramList1.add(localStoryVideoItem);
        paramList3.add(localStoryVideoItem.mVid);
      }
      while (!(localMessageRecord instanceof MessageForTroopStory))
      {
        StoryVideoItem localStoryVideoItem;
        if (localMessageRecord.shmsgseq < this.jdField_b_of_type_Long) {
          this.jdField_b_of_type_Long = localMessageRecord.shmsgseq;
        }
        long l = localMessageRecord.getId();
        if ((l > 0L) && (l < this.jdField_a_of_type_Long)) {
          this.jdField_a_of_type_Long = l;
        }
        if (localMessageRecord.versionCode >= this.jdField_a_of_type_Int) {
          break;
        }
        this.jdField_a_of_type_Int = localMessageRecord.versionCode;
        break;
      }
      Object localObject = (MessageForTroopStory)localMessageRecord;
      if (!TextUtils.isEmpty(((MessageForTroopStory)localObject).storyId))
      {
        paramList = localStoryManager.a(((MessageForTroopStory)localObject).storyId);
        localTroopStoryManager.a(((MessageForTroopStory)localObject).storyId, ((MessageForTroopStory)localObject).shmsgseq);
        if (paramList != null) {
          break label498;
        }
        paramList = new StoryVideoItem();
        paramList.mStoryType = 2;
        paramList.mVid = ((MessageForTroopStory)localObject).storyId;
        paramList.mVideoMd5 = ((MessageForTroopStory)localObject).md5;
        paramList.mVideoThumbnailUrl = ((MessageForTroopStory)localObject).thumbUrl;
        paramList.mOriginalMaskPicUrl = ((MessageForTroopStory)localObject).doodleUrl;
        paramList.mOwnerUid = localUserManager.b(((MessageForTroopStory)localObject).senderuin, true);
        paramList.mCreateTime = (((MessageForTroopStory)localObject).time * 1000L);
        paramList.mVideoWidth = ((MessageForTroopStory)localObject).videoWidth;
        paramList.mVideoHeight = ((MessageForTroopStory)localObject).videoHeight;
      }
    }
    label498:
    for (;;)
    {
      paramList1.add(paramList);
      paramList2.add(paramList);
      break;
      return;
    }
  }
  
  void a()
  {
    DefaultPlayerVideoListSynchronizer.PlayerVideoListEvent localPlayerVideoListEvent = new DefaultPlayerVideoListSynchronizer.PlayerVideoListEvent();
    localPlayerVideoListEvent.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    localPlayerVideoListEvent.jdField_a_of_type_Boolean = false;
    localPlayerVideoListEvent.jdField_b_of_type_Boolean = this.c;
    localPlayerVideoListEvent.jdField_a_of_type_JavaUtilList.addAll(this.jdField_a_of_type_JavaUtilList);
    localPlayerVideoListEvent.jdField_a_of_type_Int = this.jdField_a_of_type_JavaUtilList.size();
    localPlayerVideoListEvent.jdField_b_of_type_JavaUtilList = this.jdField_b_of_type_JavaUtilList;
    StoryDispatcher.a().dispatch(localPlayerVideoListEvent);
  }
  
  public void a(int paramInt)
  {
    if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true)) {}
    do
    {
      return;
      if ((!this.c) && ((!this.jdField_b_of_type_Boolean) || (paramInt <= 0))) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.qqstory.troopstory.aioSynchronizer", 2, "no need request");
    return;
    int[] arrayOfInt = new int[2];
    int[] tmp55_53 = arrayOfInt;
    tmp55_53[0] = -2022;
    int[] tmp61_55 = tmp55_53;
    tmp61_55[1] = -2057;
    tmp61_55;
    ArrayList localArrayList = new ArrayList();
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_b_of_type_JavaUtilList.clear();
    List localList1;
    if (!this.jdField_b_of_type_Boolean)
    {
      List localList2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(1).a(this.jdField_b_of_type_JavaLangString, 1, arrayOfInt);
      localList1 = localList2;
      if (localList2.size() < 50) {
        localList1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(this.jdField_b_of_type_JavaLangString, 1, arrayOfInt, 50);
      }
      a(localList1, this.jdField_a_of_type_JavaUtilList, localArrayList, this.jdField_b_of_type_JavaUtilList);
      this.jdField_b_of_type_Boolean = true;
    }
    while (localArrayList.size() <= 25)
    {
      this.jdField_b_of_type_Long -= 1L;
      localList1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(this.jdField_b_of_type_JavaLangString, 1, this.jdField_a_of_type_Long, this.jdField_a_of_type_Int, this.jdField_b_of_type_Long, arrayOfInt, 50);
      a(localList1, this.jdField_a_of_type_JavaUtilList, localArrayList, this.jdField_b_of_type_JavaUtilList);
      if (localList1.size() < 50) {
        this.c = true;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.troopstory.aioSynchronizer", 2, "requestVideo, currentPosition=" + paramInt + ", result size=" + localArrayList.size());
    }
    a(((StoryManager)SuperManager.a(5)).a(localArrayList));
  }
  
  protected void a(List<StoryVideoItem> paramList)
  {
    Object localObject1 = null;
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      StoryVideoItem localStoryVideoItem = (StoryVideoItem)localIterator.next();
      if (((TextUtils.isEmpty(localStoryVideoItem.mVideoUrl)) || (TextUtils.isEmpty(localStoryVideoItem.mVideoThumbnailUrl))) && ((TextUtils.isEmpty(localStoryVideoItem.mLocalVideoPath)) || (!new File(localStoryVideoItem.mLocalVideoPath).exists()) || (TextUtils.isEmpty(localStoryVideoItem.mVideoLocalThumbnailPath)) || (!new File(localStoryVideoItem.mVideoLocalThumbnailPath).exists())))
      {
        Object localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = new ArrayList();
        }
        ((ArrayList)localObject2).add(localStoryVideoItem.mVid);
        localObject1 = localObject2;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.troopstory.aioSynchronizer", 2, "req total=" + paramList.size() + ", needSend=" + 0);
    }
    if ((localObject1 != null) && (localObject1.size() > 0))
    {
      paramList = BatchHandlerListPuller.a(localObject1);
      paramList.a("Q.qqstory.troopstory.aioSynchronizer");
      paramList.a(new TroopStoryAIOVideoListSynchronizer.1(this, paramList));
      paramList.b();
      return;
    }
    a();
  }
  
  void a(List<StoryVideoItem> paramList, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryModelIVidToVideoInfoPuller$OnFinishCallBack != null)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryModelIVidToVideoInfoPuller$OnFinishCallBack.a(paramList, paramBoolean);
      this.jdField_a_of_type_ComTencentBizQqstoryModelIVidToVideoInfoPuller$OnFinishCallBack = null;
    }
  }
  
  public boolean isValidate()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.troop.model.TroopStoryAIOVideoListSynchronizer
 * JD-Core Version:    0.7.0.1
 */