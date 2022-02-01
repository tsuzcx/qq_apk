package com.tencent.biz.qqstory.model.item;

import android.text.TextUtils;
import com.tencent.biz.qqstory.base.Copyable;
import com.tencent.biz.qqstory.database.LiveVideoEntry;
import com.tencent.biz.qqstory.database.StoryEntry;
import com.tencent.biz.qqstory.model.BaseUIItem;
import com.tencent.biz.qqstory.model.StoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.UserManager;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.LiveVideoDes;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.StoryDes;
import com.tencent.biz.qqstory.storyHome.qqstorylist.common.StoryListUtils;
import com.tencent.biz.qqstory.storyHome.qqstorylist.common.StringAppendTool;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public class StoryItem
  extends BaseUIItem
  implements Copyable
{
  public static final int TYPE_EXPIRE = 2;
  public static final int TYPE_NORMAL = 0;
  public static final int TYPE_RECENT = 1;
  public static final int TYPE_RECOMMEND_BIG_V = 3;
  public static final String UNION_ID_TROOP = "4_10000";
  public String cover;
  public String key;
  public LiveVideoEntry liveVideo;
  public String mDoodleText;
  public int seq;
  public String storyLabel;
  public long totalTime;
  public int type;
  public int unReadCount;
  public String unionId;
  public long updateTime;
  public QQUserUIItem user;
  public int videoCount;
  
  public StoryItem() {}
  
  public StoryItem(StoryEntry paramStoryEntry)
  {
    this.key = paramStoryEntry.key;
    this.type = paramStoryEntry.type;
    this.unionId = paramStoryEntry.unionId;
    this.user = ((UserManager)SuperManager.a(2)).b(this.unionId);
    if (this.user == null)
    {
      this.user = new QQUserUIItem();
      QQUserUIItem localQQUserUIItem = this.user;
      localQQUserUIItem.uid = this.unionId;
      localQQUserUIItem.nickName = "user";
    }
    this.updateTime = paramStoryEntry.updateTime;
    this.cover = paramStoryEntry.coverUrl;
    this.unReadCount = paramStoryEntry.hasUnWatchVideo;
    this.videoCount = paramStoryEntry.videoCount;
    this.storyLabel = paramStoryEntry.storyTitle;
    this.mDoodleText = paramStoryEntry.mDoodleText;
    this.seq = paramStoryEntry.seq;
  }
  
  public static String dump(List<StoryItem> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      localStringBuilder.append(((StoryItem)paramList.next()).key);
      localStringBuilder.append(",");
    }
    return localStringBuilder.toString();
  }
  
  public static String makeFriendKey(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("fri.");
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  public static String makeRecentKey(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("recent.");
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  public void convertFrom(int paramInt, qqstory_struct.StoryDes paramStoryDes)
  {
    Object localObject = (UserManager)SuperManager.a(2);
    QQUserUIItem localQQUserUIItem = new QQUserUIItem();
    localQQUserUIItem.convertFrom(paramStoryDes.user);
    this.user = ((UserManager)localObject).a(localQQUserUIItem);
    localObject = ((StoryManager)SuperManager.a(5)).a(this.user.uid, paramInt);
    if (paramStoryDes.new_story_time.has())
    {
      this.updateTime = (paramStoryDes.new_story_time.get() * 1000L);
      if (this.updateTime == 0L) {
        this.updateTime = System.currentTimeMillis();
      }
    }
    else if (localObject != null)
    {
      this.updateTime = ((StoryItem)localObject).updateTime;
    }
    else
    {
      this.updateTime = System.currentTimeMillis();
    }
    if (paramStoryDes.storyCover.has()) {
      this.cover = paramStoryDes.storyCover.get().toStringUtf8();
    } else if (localObject != null) {
      this.cover = ((StoryItem)localObject).cover;
    }
    if (paramStoryDes.has_unwatched_video.has()) {
      this.unReadCount = paramStoryDes.has_unwatched_video.get();
    } else if (localObject != null) {
      this.unReadCount = ((StoryItem)localObject).unReadCount;
    }
    if (paramStoryDes.video_count.has()) {
      this.videoCount = paramStoryDes.video_count.get();
    } else if (localObject != null) {
      this.videoCount = ((StoryItem)localObject).videoCount;
    }
    if (paramStoryDes.live_video.has()) {
      this.liveVideo = LiveVideoEntry.convertFrom(this.user.uid, paramStoryDes.live_video);
    } else if (localObject != null) {
      this.liveVideo = ((StoryItem)localObject).liveVideo;
    }
    if (paramInt == 1) {
      this.key = makeRecentKey(this.user.uid);
    } else if (paramInt == 0) {
      this.key = makeFriendKey(this.user.uid);
    }
    this.type = paramInt;
    if (localObject != null) {
      this.totalTime = ((StoryItem)localObject).totalTime;
    }
    if (paramStoryDes.story_title.has()) {
      this.storyLabel = paramStoryDes.story_title.get().toStringUtf8();
    } else if (localObject != null) {
      this.storyLabel = ((StoryItem)localObject).storyLabel;
    }
    if (paramStoryDes.story_video_attr.has())
    {
      paramStoryDes = paramStoryDes.story_video_attr.get().toStringUtf8();
      if (TextUtils.isEmpty(paramStoryDes)) {
        return;
      }
      try
      {
        this.mDoodleText = new JSONObject(paramStoryDes).optString("video_doodle_text");
        return;
      }
      catch (Exception paramStoryDes)
      {
        SLog.b("Q.qqstory.home.StoryItem", "decode json fail", paramStoryDes);
        return;
      }
    }
    if (localObject != null) {
      this.mDoodleText = ((StoryItem)localObject).mDoodleText;
    }
  }
  
  public void copy(Object paramObject)
  {
    if ((paramObject instanceof StoryItem))
    {
      paramObject = (StoryItem)paramObject;
      this.key = paramObject.key;
      this.type = paramObject.type;
      this.user = paramObject.user;
      this.updateTime = paramObject.updateTime;
      this.cover = paramObject.cover;
      this.totalTime = paramObject.totalTime;
      this.unReadCount = paramObject.unReadCount;
      this.videoCount = paramObject.videoCount;
      this.liveVideo = paramObject.liveVideo;
      this.mDoodleText = paramObject.mDoodleText;
      this.unionId = paramObject.unionId;
      this.seq = paramObject.seq;
    }
  }
  
  public StoryEntry cover2StoryEntry()
  {
    StoryEntry localStoryEntry = new StoryEntry();
    localStoryEntry.key = this.key;
    localStoryEntry.type = this.type;
    localStoryEntry.coverUrl = this.cover;
    localStoryEntry.updateTime = this.updateTime;
    localStoryEntry.unionId = this.user.uid;
    localStoryEntry.totalTime = this.totalTime;
    localStoryEntry.hasUnWatchVideo = this.unReadCount;
    localStoryEntry.videoCount = this.videoCount;
    localStoryEntry.storyTitle = this.storyLabel;
    localStoryEntry.mDoodleText = this.mDoodleText;
    localStoryEntry.seq = this.seq;
    return localStoryEntry;
  }
  
  public float getCountDown()
  {
    return StoryListUtils.a(this.updateTime);
  }
  
  public String getCoverUrl()
  {
    return this.cover;
  }
  
  public String getTime()
  {
    return StoryListUtils.a(this.updateTime);
  }
  
  public String getTitle()
  {
    QQUserUIItem localQQUserUIItem = this.user;
    if (localQQUserUIItem == null) {
      return "";
    }
    if (!TextUtils.isEmpty(localQQUserUIItem.remark)) {
      return this.user.remark;
    }
    if (!TextUtils.isEmpty(this.user.nickName)) {
      return this.user.nickName;
    }
    return String.valueOf(this.user.uid);
  }
  
  public String toString()
  {
    return StringAppendTool.a(new Object[] { "StoryItem{ key=", this.key, ", type=", Integer.valueOf(this.type), ", user=", this.user, ", updateTime=", Long.valueOf(this.updateTime), ", cover= ", this.cover, ", totalTime=", Long.valueOf(this.totalTime), ", videoCount=", Integer.valueOf(this.videoCount), ", unReadCount=", Integer.valueOf(this.unReadCount), ", liveVideo=", this.liveVideo, ", storyLabel=", this.storyLabel, ", mDoodleText=", this.mDoodleText });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.item.StoryItem
 * JD-Core Version:    0.7.0.1
 */