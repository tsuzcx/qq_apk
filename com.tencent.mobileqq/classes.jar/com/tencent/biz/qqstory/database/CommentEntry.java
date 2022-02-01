package com.tencent.biz.qqstory.database;

import android.text.TextUtils;
import com.tencent.biz.bmqq.util.BmqqSegmentUtil;
import com.tencent.biz.qqstory.base.Copyable;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.StoryVideoCommentInfo;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import org.json.JSONException;
import org.json.JSONObject;

public class CommentEntry
  extends Entity
  implements Copyable
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
  public int commentId;
  public int commentType = 0;
  public String content;
  @notColumn
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
  
  public CommentEntry()
  {
    double d = this.fakeId / 1000L;
    Double.isNaN(d);
    this.commentId = ((int)(d - 1400000000.0D));
  }
  
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
    if (this == paramObject) {
      return true;
    }
    if (paramObject != null)
    {
      if (getClass() != paramObject.getClass()) {
        return false;
      }
      paramObject = (CommentEntry)paramObject;
      return this.fakeId == paramObject.fakeId;
    }
    return false;
  }
  
  /* Error */
  @android.support.annotation.NonNull
  public JSONObject getExtraJson()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 210	com/tencent/biz/qqstory/database/CommentEntry:extraJson	Lorg/json/JSONObject;
    //   6: ifnonnull +69 -> 75
    //   9: aload_0
    //   10: getfield 184	com/tencent/biz/qqstory/database/CommentEntry:extras	Ljava/lang/String;
    //   13: invokestatic 229	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   16: ifne +21 -> 37
    //   19: aload_0
    //   20: new 231	org/json/JSONObject
    //   23: dup
    //   24: aload_0
    //   25: getfield 184	com/tencent/biz/qqstory/database/CommentEntry:extras	Ljava/lang/String;
    //   28: invokespecial 234	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   31: putfield 210	com/tencent/biz/qqstory/database/CommentEntry:extraJson	Lorg/json/JSONObject;
    //   34: goto +41 -> 75
    //   37: aload_0
    //   38: new 231	org/json/JSONObject
    //   41: dup
    //   42: invokespecial 235	org/json/JSONObject:<init>	()V
    //   45: putfield 210	com/tencent/biz/qqstory/database/CommentEntry:extraJson	Lorg/json/JSONObject;
    //   48: goto +27 -> 75
    //   51: astore_1
    //   52: goto +32 -> 84
    //   55: astore_1
    //   56: ldc 237
    //   58: ldc 239
    //   60: aload_1
    //   61: invokestatic 245	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   64: aload_0
    //   65: new 231	org/json/JSONObject
    //   68: dup
    //   69: invokespecial 235	org/json/JSONObject:<init>	()V
    //   72: putfield 210	com/tencent/biz/qqstory/database/CommentEntry:extraJson	Lorg/json/JSONObject;
    //   75: aload_0
    //   76: getfield 210	com/tencent/biz/qqstory/database/CommentEntry:extraJson	Lorg/json/JSONObject;
    //   79: astore_1
    //   80: aload_0
    //   81: monitorexit
    //   82: aload_1
    //   83: areturn
    //   84: aload_0
    //   85: monitorexit
    //   86: aload_1
    //   87: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	88	0	this	CommentEntry
    //   51	1	1	localObject	Object
    //   55	6	1	localException	java.lang.Exception
    //   79	8	1	localJSONObject	JSONObject
    // Exception table:
    //   from	to	target	type
    //   2	34	51	finally
    //   37	48	51	finally
    //   56	75	51	finally
    //   75	80	51	finally
    //   2	34	55	java/lang/Exception
    //   37	48	55	java/lang/Exception
  }
  
  public int hashCode()
  {
    long l = this.fakeId;
    return (int)(l ^ l >>> 32);
  }
  
  public boolean isReply()
  {
    return ((!TextUtils.isEmpty(this.replierUnionId)) && (!this.replierUnionId.equals("0"))) || (BmqqSegmentUtil.a(this.replyUin));
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
      SLog.c("PublishVideoEntry", "putStringExtra error", paramString);
    }
    return false;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CommentEntry {commentId=");
    localStringBuilder.append(this.commentId);
    localStringBuilder.append(", replyUin=");
    localStringBuilder.append(this.replyUin);
    localStringBuilder.append(", authorUin=");
    localStringBuilder.append(this.authorUin);
    localStringBuilder.append(", replyTime=");
    localStringBuilder.append(this.replyTime);
    localStringBuilder.append(", content=");
    localStringBuilder.append(this.content);
    localStringBuilder.append(", replyTime=");
    localStringBuilder.append(this.replyTime);
    localStringBuilder.append(", authorName=");
    localStringBuilder.append(this.authorName);
    localStringBuilder.append(", replierName=");
    localStringBuilder.append(this.replierName);
    localStringBuilder.append(", fakeId=");
    localStringBuilder.append(this.fakeId);
    localStringBuilder.append(", vid=");
    localStringBuilder.append(this.vid);
    localStringBuilder.append(", status=");
    localStringBuilder.append(this.status);
    localStringBuilder.append(", authorRole=");
    localStringBuilder.append(this.authorRole);
    localStringBuilder.append(", authorUnionId=");
    localStringBuilder.append(this.authorUnionId);
    localStringBuilder.append(", replierRole=");
    localStringBuilder.append(this.replierRole);
    localStringBuilder.append(", replierUnionId=");
    localStringBuilder.append(this.replierUnionId);
    localStringBuilder.append(", type=");
    localStringBuilder.append(this.type);
    localStringBuilder.append(", commentType=");
    localStringBuilder.append(this.commentType);
    localStringBuilder.append(", pbType=");
    localStringBuilder.append(this.pbType);
    localStringBuilder.append(", togetherVid=");
    localStringBuilder.append(this.togetherVid);
    localStringBuilder.append(", togetherFeedId=");
    localStringBuilder.append(this.togetherFeedId);
    localStringBuilder.append(", atShootTime=");
    localStringBuilder.append(this.atVideoShootTime);
    localStringBuilder.append(", extras=");
    localStringBuilder.append(this.extras);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.database.CommentEntry
 * JD-Core Version:    0.7.0.1
 */