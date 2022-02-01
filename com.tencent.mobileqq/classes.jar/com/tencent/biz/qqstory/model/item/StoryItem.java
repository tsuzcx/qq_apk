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
      this.user.uid = this.unionId;
      this.user.nickName = "user";
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
    while (paramList.hasNext()) {
      localStringBuilder.append(((StoryItem)paramList.next()).key).append(",");
    }
    return localStringBuilder.toString();
  }
  
  public static String makeFriendKey(String paramString)
  {
    return "fri." + paramString;
  }
  
  public static String makeRecentKey(String paramString)
  {
    return "recent." + paramString;
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
      if (!paramStoryDes.storyCover.has()) {
        break label321;
      }
      this.cover = paramStoryDes.storyCover.get().toStringUtf8();
      label120:
      if (!paramStoryDes.has_unwatched_video.has()) {
        break label336;
      }
      this.unReadCount = paramStoryDes.has_unwatched_video.get();
      label141:
      if (!paramStoryDes.video_count.has()) {
        break label351;
      }
      this.videoCount = paramStoryDes.video_count.get();
      label162:
      if (!paramStoryDes.live_video.has()) {
        break label366;
      }
      this.liveVideo = LiveVideoEntry.convertFrom(this.user.uid, paramStoryDes.live_video);
      label190:
      if (paramInt != 1) {
        break label381;
      }
      this.key = makeRecentKey(this.user.uid);
      label209:
      this.type = paramInt;
      if (localObject != null) {
        this.totalTime = ((StoryItem)localObject).totalTime;
      }
      if (!paramStoryDes.story_title.has()) {
        break label402;
      }
      this.storyLabel = paramStoryDes.story_title.get().toStringUtf8();
      label250:
      if (!paramStoryDes.story_video_attr.has()) {
        break label428;
      }
      paramStoryDes = paramStoryDes.story_video_attr.get().toStringUtf8();
      if (TextUtils.isEmpty(paramStoryDes)) {}
    }
    label321:
    label336:
    label351:
    label366:
    label381:
    while (localObject == null)
    {
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
      if (localObject != null)
      {
        this.updateTime = ((StoryItem)localObject).updateTime;
        break;
      }
      this.updateTime = System.currentTimeMillis();
      break;
      if (localObject == null) {
        break label120;
      }
      this.cover = ((StoryItem)localObject).cover;
      break label120;
      if (localObject == null) {
        break label141;
      }
      this.unReadCount = ((StoryItem)localObject).unReadCount;
      break label141;
      if (localObject == null) {
        break label162;
      }
      this.videoCount = ((StoryItem)localObject).videoCount;
      break label162;
      if (localObject == null) {
        break label190;
      }
      this.liveVideo = ((StoryItem)localObject).liveVideo;
      break label190;
      if (paramInt != 0) {
        break label209;
      }
      this.key = makeFriendKey(this.user.uid);
      break label209;
      if (localObject == null) {
        break label250;
      }
      this.storyLabel = ((StoryItem)localObject).storyLabel;
      break label250;
    }
    label402:
    label428:
    this.mDoodleText = ((StoryItem)localObject).mDoodleText;
  }
  
  public void copy(Object paramObject)
  {
    if ((paramObject instanceof StoryItem))
    {
      this.key = ((StoryItem)paramObject).key;
      this.type = ((StoryItem)paramObject).type;
      this.user = ((StoryItem)paramObject).user;
      this.updateTime = ((StoryItem)paramObject).updateTime;
      this.cover = ((StoryItem)paramObject).cover;
      this.totalTime = ((StoryItem)paramObject).totalTime;
      this.unReadCount = ((StoryItem)paramObject).unReadCount;
      this.videoCount = ((StoryItem)paramObject).videoCount;
      this.liveVideo = ((StoryItem)paramObject).liveVideo;
      this.mDoodleText = ((StoryItem)paramObject).mDoodleText;
      this.unionId = ((StoryItem)paramObject).unionId;
      this.seq = ((StoryItem)paramObject).seq;
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
    if (this.user == null) {
      return "";
    }
    if (!TextUtils.isEmpty(this.user.remark)) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.item.StoryItem
 * JD-Core Version:    0.7.0.1
 */