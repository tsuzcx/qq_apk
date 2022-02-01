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
import com.tencent.mobileqq.shortvideo.SVUtils;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.Dispatcher;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.List<Lcom.tencent.mobileqq.data.MessageRecord;>;
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
      Object localObject1;
      Object localObject2;
      if ((localMessageRecord instanceof MessageForShortVideo))
      {
        paramList = (MessageForShortVideo)localMessageRecord;
        if (paramList.busiType == 1)
        {
          localObject1 = TroopStoryUtil.a(paramList);
          localTroopStoryManager.a((String)localObject1, paramList.shmsgseq);
          localObject2 = new StoryVideoItem();
          ((StoryVideoItem)localObject2).mStoryType = 2;
          ((StoryVideoItem)localObject2).mVid = ((String)localObject1);
          ((StoryVideoItem)localObject2).mVideoMd5 = paramList.getMd5();
          ((StoryVideoItem)localObject2).mLocalVideoPath = SVUtils.a(paramList, "mp4");
          ((StoryVideoItem)localObject2).mVideoLocalThumbnailPath = SVUtils.a(paramList.thumbMD5, "jpg");
          ((StoryVideoItem)localObject2).mLocalMaskPath = "";
          ((StoryVideoItem)localObject2).mOwnerUid = localUserManager.b(paramList.senderuin, true);
          ((StoryVideoItem)localObject2).mCreateTime = (paramList.time * 1000L);
          ((StoryVideoItem)localObject2).mVideoWidth = paramList.thumbWidth;
          ((StoryVideoItem)localObject2).mVideoHeight = paramList.thumbHeight;
          ((StoryVideoItem)localObject2).mVideoDuration = (paramList.videoFileTime * 1000L);
          paramList1.add(localObject2);
          paramList3.add(((StoryVideoItem)localObject2).mVid);
          break label428;
        }
      }
      if ((localMessageRecord instanceof MessageForTroopStory))
      {
        localObject2 = (MessageForTroopStory)localMessageRecord;
        if (TextUtils.isEmpty(((MessageForTroopStory)localObject2).storyId)) {
          continue;
        }
        localObject1 = localStoryManager.a(((MessageForTroopStory)localObject2).storyId);
        localTroopStoryManager.a(((MessageForTroopStory)localObject2).storyId, ((MessageForTroopStory)localObject2).shmsgseq);
        paramList = (List<MessageRecord>)localObject1;
        if (localObject1 == null)
        {
          paramList = new StoryVideoItem();
          paramList.mStoryType = 2;
          paramList.mVid = ((MessageForTroopStory)localObject2).storyId;
          paramList.mVideoMd5 = ((MessageForTroopStory)localObject2).md5;
          paramList.mVideoThumbnailUrl = ((MessageForTroopStory)localObject2).thumbUrl;
          paramList.mOriginalMaskPicUrl = ((MessageForTroopStory)localObject2).doodleUrl;
          paramList.mOwnerUid = localUserManager.b(((MessageForTroopStory)localObject2).senderuin, true);
          paramList.mCreateTime = (((MessageForTroopStory)localObject2).time * 1000L);
          paramList.mVideoWidth = ((MessageForTroopStory)localObject2).videoWidth;
          paramList.mVideoHeight = ((MessageForTroopStory)localObject2).videoHeight;
        }
        paramList1.add(paramList);
        paramList2.add(paramList);
      }
      label428:
      if (localMessageRecord.shmsgseq < this.jdField_b_of_type_Long) {
        this.jdField_b_of_type_Long = localMessageRecord.shmsgseq;
      }
      long l = localMessageRecord.getId();
      if ((l > 0L) && (l < this.jdField_a_of_type_Long)) {
        this.jdField_a_of_type_Long = l;
      }
      if (localMessageRecord.versionCode < this.jdField_a_of_type_Int) {
        this.jdField_a_of_type_Int = localMessageRecord.versionCode;
      }
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
  
  protected void a(int paramInt)
  {
    if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true)) {
      return;
    }
    if ((!this.c) && ((!this.jdField_b_of_type_Boolean) || (paramInt <= 0)))
    {
      int[] arrayOfInt = new int[2];
      int[] tmp41_39 = arrayOfInt;
      tmp41_39[0] = -2022;
      int[] tmp47_41 = tmp41_39;
      tmp47_41[1] = -2057;
      tmp47_41;
      Object localObject2 = new ArrayList();
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_b_of_type_JavaUtilList.clear();
      Object localObject1 = localObject2;
      Object localObject3;
      if (!this.jdField_b_of_type_Boolean)
      {
        localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(1).a(this.jdField_b_of_type_JavaLangString, 1, tmp41_39);
        localObject1 = localObject3;
        if (((List)localObject3).size() < 50) {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(this.jdField_b_of_type_JavaLangString, 1, tmp41_39, 50);
        }
        a((List)localObject1, this.jdField_a_of_type_JavaUtilList, (List)localObject2, this.jdField_b_of_type_JavaUtilList);
        this.jdField_b_of_type_Boolean = true;
      }
      for (localObject1 = localObject2; ((List)localObject1).size() <= 25; localObject1 = localObject2)
      {
        this.jdField_b_of_type_Long -= 1L;
        localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade();
        String str = this.jdField_b_of_type_JavaLangString;
        long l1 = this.jdField_a_of_type_Long;
        int i = this.jdField_a_of_type_Int;
        long l2 = this.jdField_b_of_type_Long;
        localObject2 = localObject1;
        localObject3 = ((QQMessageFacade)localObject3).a(str, 1, l1, i, l2, tmp41_39, 50);
        a((List)localObject3, this.jdField_a_of_type_JavaUtilList, (List)localObject2, this.jdField_b_of_type_JavaUtilList);
        if (((List)localObject3).size() < 50)
        {
          this.c = true;
          break;
        }
      }
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("requestVideo, currentPosition=");
        ((StringBuilder)localObject2).append(paramInt);
        ((StringBuilder)localObject2).append(", result size=");
        ((StringBuilder)localObject2).append(((List)localObject1).size());
        QLog.d("Q.qqstory.troopstory.aioSynchronizer", 2, ((StringBuilder)localObject2).toString());
      }
      a(((StoryManager)SuperManager.a(5)).a((List)localObject1));
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.troopstory.aioSynchronizer", 2, "no need request");
    }
  }
  
  protected void a(List<StoryVideoItem> paramList)
  {
    Iterator localIterator = paramList.iterator();
    label10:
    Object localObject2;
    for (Object localObject1 = null; localIterator.hasNext(); localObject1 = localObject2)
    {
      StoryVideoItem localStoryVideoItem = (StoryVideoItem)localIterator.next();
      if (((!TextUtils.isEmpty(localStoryVideoItem.mVideoUrl)) && (!TextUtils.isEmpty(localStoryVideoItem.mVideoThumbnailUrl))) || ((!TextUtils.isEmpty(localStoryVideoItem.mLocalVideoPath)) && (new File(localStoryVideoItem.mLocalVideoPath).exists()) && (!TextUtils.isEmpty(localStoryVideoItem.mVideoLocalThumbnailPath)) && (new File(localStoryVideoItem.mVideoLocalThumbnailPath).exists()))) {
        break label10;
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = new ArrayList();
      }
      ((ArrayList)localObject2).add(localStoryVideoItem.mVid);
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("req total=");
      ((StringBuilder)localObject2).append(paramList.size());
      ((StringBuilder)localObject2).append(", needSend=");
      ((StringBuilder)localObject2).append(0);
      QLog.d("Q.qqstory.troopstory.aioSynchronizer", 2, ((StringBuilder)localObject2).toString());
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
    IVidToVideoInfoPuller.OnFinishCallBack localOnFinishCallBack = this.jdField_a_of_type_ComTencentBizQqstoryModelIVidToVideoInfoPuller$OnFinishCallBack;
    if (localOnFinishCallBack != null)
    {
      localOnFinishCallBack.a(paramList, paramBoolean);
      this.jdField_a_of_type_ComTencentBizQqstoryModelIVidToVideoInfoPuller$OnFinishCallBack = null;
    }
  }
  
  public boolean isValidate()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.troop.model.TroopStoryAIOVideoListSynchronizer
 * JD-Core Version:    0.7.0.1
 */