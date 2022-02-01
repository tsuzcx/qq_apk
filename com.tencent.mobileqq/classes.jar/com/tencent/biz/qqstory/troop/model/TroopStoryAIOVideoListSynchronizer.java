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
  String b;
  boolean c;
  boolean d;
  QQAppInterface e;
  String f;
  long g;
  long h;
  int i;
  List<StoryVideoItem> j;
  List<String> k;
  AtomicBoolean l;
  HashSet<String> m;
  IVidToVideoInfoPuller.OnFinishCallBack n;
  
  private void a(List<MessageRecord> paramList, List<StoryVideoItem> paramList1, List<StoryVideoItem> paramList2, List<String> paramList3)
  {
    TroopStoryManager localTroopStoryManager = (TroopStoryManager)this.e.getManager(QQManagerFactory.TROOP_STORY_MANAGER);
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
      if (localMessageRecord.shmsgseq < this.h) {
        this.h = localMessageRecord.shmsgseq;
      }
      long l1 = localMessageRecord.getId();
      if ((l1 > 0L) && (l1 < this.g)) {
        this.g = l1;
      }
      if (localMessageRecord.versionCode < this.i) {
        this.i = localMessageRecord.versionCode;
      }
    }
  }
  
  void a()
  {
    DefaultPlayerVideoListSynchronizer.PlayerVideoListEvent localPlayerVideoListEvent = new DefaultPlayerVideoListSynchronizer.PlayerVideoListEvent();
    localPlayerVideoListEvent.a = this.b;
    localPlayerVideoListEvent.i = false;
    localPlayerVideoListEvent.j = this.d;
    localPlayerVideoListEvent.e.addAll(this.j);
    localPlayerVideoListEvent.h = this.j.size();
    localPlayerVideoListEvent.m = this.k;
    StoryDispatcher.a().dispatch(localPlayerVideoListEvent);
  }
  
  protected void a(int paramInt)
  {
    if (!this.l.compareAndSet(false, true)) {
      return;
    }
    if ((!this.d) && ((!this.c) || (paramInt <= 0)))
    {
      int[] arrayOfInt = new int[2];
      int[] tmp41_39 = arrayOfInt;
      tmp41_39[0] = -2022;
      int[] tmp47_41 = tmp41_39;
      tmp47_41[1] = -2057;
      tmp47_41;
      Object localObject2 = new ArrayList();
      this.j.clear();
      this.k.clear();
      Object localObject1 = localObject2;
      Object localObject3;
      if (!this.c)
      {
        localObject3 = this.e.getMessageProxy(1).a(this.f, 1, tmp41_39);
        localObject1 = localObject3;
        if (((List)localObject3).size() < 50) {
          localObject1 = this.e.getMessageFacade().a(this.f, 1, tmp41_39, 50);
        }
        a((List)localObject1, this.j, (List)localObject2, this.k);
        this.c = true;
      }
      for (localObject1 = localObject2; ((List)localObject1).size() <= 25; localObject1 = localObject2)
      {
        this.h -= 1L;
        localObject3 = this.e.getMessageFacade();
        String str = this.f;
        long l1 = this.g;
        int i1 = this.i;
        long l2 = this.h;
        localObject2 = localObject1;
        localObject3 = ((QQMessageFacade)localObject3).a(str, 1, l1, i1, l2, tmp41_39, 50);
        a((List)localObject3, this.j, (List)localObject2, this.k);
        if (((List)localObject3).size() < 50)
        {
          this.d = true;
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
    IVidToVideoInfoPuller.OnFinishCallBack localOnFinishCallBack = this.n;
    if (localOnFinishCallBack != null)
    {
      localOnFinishCallBack.a(paramList, paramBoolean);
      this.n = null;
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