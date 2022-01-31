package com.tencent.biz.qqstory.database;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import awbv;
import awdg;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.StoryVideoCommentInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import nbp;
import org.json.JSONException;
import org.json.JSONObject;
import uha;
import wsv;

public class CommentEntry
  extends awbv
  implements uha
{
  public static final int COMMENT_TYPE_CAPTURE_TOGETHER = 5;
  public static final int COMMENT_TYPE_COMMON = 0;
  public static final int COMMENT_TYPE_GAME_PK = 4;
  public static final int COMMENT_TYPE_RATE = 2;
  public static final int COMMENT_TYPE_VOTE = 1;
  public static final int ROLE_NORMAL = 0;
  public static final int ROLE_QQ = 1001;
  public static final int ROLE_VIP = 2;
  public static final int ROLE_WEIBO = 1003;
  public static final int ROLE_WEIXIN = 1002;
  public static final int STATUS_END = 0;
  public static final int STATUS_ERROE = 2;
  public static final int STATUS_SENDING = 1;
  public static final int TYPE_COMMENT = 0;
  public static final int TYPE_FEED_COMMENT = 3;
  public static final int TYPE_FEED_OPEN_COMMENT = 4;
  public static final int TYPE_MORE_ITEM = 1;
  public int atVideoShootTime;
  public String authorName;
  public int authorRole;
  public String authorUin;
  public String authorUnionId;
  public int commentId = (int)(this.fakeId / 1000L - 1400000000.0D);
  public int commentType = 0;
  public String content;
  @awdg
  private JSONObject extraJson;
  public String extras;
  public long fakeId = System.currentTimeMillis();
  public String feedId;
  public int pbType = -1;
  public String replierName;
  public int replierRole;
  public String replierUnionId;
  public long replyTime;
  public String replyUin;
  public int status = 0;
  public String togetherFeedId;
  public String togetherVid;
  public int type = 3;
  public String vid;
  
  public static CommentEntry convertFrom(qqstory_struct.StoryVideoCommentInfo paramStoryVideoCommentInfo)
  {
    if (paramStoryVideoCommentInfo == null) {
      return null;
    }
    CommentEntry localCommentEntry = new CommentEntry();
    localCommentEntry.commentId = paramStoryVideoCommentInfo.comment_id.get();
    localCommentEntry.replyUin = String.valueOf(paramStoryVideoCommentInfo.reply_uid.get());
    localCommentEntry.authorUin = String.valueOf(paramStoryVideoCommentInfo.author_uid.get());
    localCommentEntry.replyTime = paramStoryVideoCommentInfo.reply_time.get();
    localCommentEntry.content = paramStoryVideoCommentInfo.content.get().toStringUtf8();
    localCommentEntry.fakeId = paramStoryVideoCommentInfo.fake_id.get();
    localCommentEntry.authorRole = paramStoryVideoCommentInfo.author_role.get();
    localCommentEntry.authorUnionId = paramStoryVideoCommentInfo.author_union_id.get();
    localCommentEntry.replierRole = paramStoryVideoCommentInfo.reply_role.get();
    localCommentEntry.replierUnionId = paramStoryVideoCommentInfo.reply_union_id.get();
    localCommentEntry.commentType = paramStoryVideoCommentInfo.type.get();
    localCommentEntry.extras = paramStoryVideoCommentInfo.extras.get().toStringUtf8();
    localCommentEntry.togetherVid = paramStoryVideoCommentInfo.vid.get().toStringUtf8();
    localCommentEntry.togetherFeedId = paramStoryVideoCommentInfo.feed_id.get().toStringUtf8();
    localCommentEntry.atVideoShootTime = paramStoryVideoCommentInfo.at_video_shoot_time.get();
    return localCommentEntry;
  }
  
  public void copy(Object paramObject)
  {
    paramObject = (CommentEntry)paramObject;
    this.commentId = paramObject.commentId;
    this.replyUin = paramObject.replyUin;
    this.authorUin = paramObject.authorUin;
    this.replyTime = paramObject.replyTime;
    this.content = paramObject.content;
    this.fakeId = paramObject.fakeId;
    this.authorRole = paramObject.authorRole;
    this.authorUnionId = paramObject.authorUnionId;
    this.replierRole = paramObject.replierRole;
    this.replierUnionId = paramObject.replierUnionId;
    this.vid = paramObject.vid;
    this.feedId = paramObject.feedId;
    this.authorName = paramObject.authorName;
    this.replierName = paramObject.replierName;
    this.status = paramObject.status;
    this.type = paramObject.type;
    this.commentType = paramObject.commentType;
    this.pbType = paramObject.pbType;
    this.extras = paramObject.extras;
    this.extraJson = paramObject.extraJson;
    this.togetherVid = paramObject.togetherVid;
    this.togetherFeedId = paramObject.togetherFeedId;
    this.atVideoShootTime = paramObject.atVideoShootTime;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (CommentEntry)paramObject;
    } while (this.fakeId == paramObject.fakeId);
    return false;
  }
  
  @NonNull
  public JSONObject getExtraJson()
  {
    try
    {
      if (this.extraJson == null) {
        if (TextUtils.isEmpty(this.extras)) {
          break label43;
        }
      }
      label43:
      for (this.extraJson = new JSONObject(this.extras);; this.extraJson = new JSONObject())
      {
        JSONObject localJSONObject = this.extraJson;
        return localJSONObject;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        wsv.c("CommentEntry", "getExtraJson error", localException);
        this.extraJson = new JSONObject();
      }
    }
    finally {}
  }
  
  public int hashCode()
  {
    return (int)(this.fakeId ^ this.fakeId >>> 32);
  }
  
  public boolean isReply()
  {
    return ((!TextUtils.isEmpty(this.replierUnionId)) && (!this.replierUnionId.equals("0"))) || (nbp.a(this.replyUin));
  }
  
  public boolean putExtra(String paramString, Object paramObject)
  {
    try
    {
      JSONObject localJSONObject = getExtraJson();
      localJSONObject.putOpt(paramString, paramObject);
      this.extras = localJSONObject.toString();
      return true;
    }
    catch (JSONException paramString)
    {
      wsv.c("PublishVideoEntry", "putStringExtra error", paramString);
    }
    return false;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CommentEntry {commentId=").append(this.commentId);
    localStringBuilder.append(", replyUin=").append(this.replyUin);
    localStringBuilder.append(", authorUin=").append(this.authorUin);
    localStringBuilder.append(", replyTime=").append(this.replyTime);
    localStringBuilder.append(", content=").append(this.content);
    localStringBuilder.append(", replyTime=").append(this.replyTime);
    localStringBuilder.append(", authorName=").append(this.authorName);
    localStringBuilder.append(", replierName=").append(this.replierName);
    localStringBuilder.append(", fakeId=").append(this.fakeId);
    localStringBuilder.append(", vid=").append(this.vid);
    localStringBuilder.append(", status=").append(this.status);
    localStringBuilder.append(", authorRole=").append(this.authorRole);
    localStringBuilder.append(", authorUnionId=").append(this.authorUnionId);
    localStringBuilder.append(", replierRole=").append(this.replierRole);
    localStringBuilder.append(", replierUnionId=").append(this.replierUnionId);
    localStringBuilder.append(", type=").append(this.type);
    localStringBuilder.append(", commentType=").append(this.commentType);
    localStringBuilder.append(", pbType=").append(this.pbType);
    localStringBuilder.append(", togetherVid=").append(this.togetherVid);
    localStringBuilder.append(", togetherFeedId=").append(this.togetherFeedId);
    localStringBuilder.append(", atShootTime=").append(this.atVideoShootTime);
    localStringBuilder.append(", extras=").append(this.extras).append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.database.CommentEntry
 * JD-Core Version:    0.7.0.1
 */