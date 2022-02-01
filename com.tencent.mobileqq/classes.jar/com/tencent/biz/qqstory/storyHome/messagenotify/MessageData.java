package com.tencent.biz.qqstory.storyHome.messagenotify;

import android.text.TextUtils;
import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.model.item.StoryVideoItem.InteractPasterLayout;
import com.tencent.biz.qqstory.model.item.StoryVideoItem.PollLayout;
import com.tencent.biz.qqstory.network.pb.qqstory_710_message.ShareGroupInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_710_message.StoryChallengeInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_710_message.StoryCommentInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_710_message.StoryGradeInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_710_message.StoryLikeInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_710_message.StoryMedalInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_710_message.StoryMessage;
import com.tencent.biz.qqstory.network.pb.qqstory_710_message.StoryOfficialInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_710_message.StoryPhotoTogetherInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_710_message.StoryPublishInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_710_message.StoryVideoInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_710_message.StoryVoteInfo;
import com.tencent.biz.qqstory.storyHome.qqstorylist.common.StoryListUtils;
import com.tencent.biz.qqstory.utils.ThumbnailUrlHelper;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;

public class MessageData
{
  public String A;
  public String B;
  public String C;
  public int D;
  public String E;
  public String F;
  public String G;
  public String H;
  public int I;
  public boolean J;
  public String K;
  public String L;
  public boolean M;
  public boolean N;
  private String O;
  private String P;
  private String Q;
  public StoryVideoItem.PollLayout a;
  public StoryVideoItem.InteractPasterLayout b;
  public String c;
  public int d;
  public boolean e;
  public String f;
  public long g;
  public int h;
  public String i;
  public int j;
  public boolean k;
  public String l;
  public boolean m;
  public String n;
  public String o;
  public int p;
  public String q;
  public String r;
  public int s;
  public int t;
  public long u;
  public boolean v;
  public long w;
  public String x;
  public int y;
  public String z;
  
  public MessageData(qqstory_710_message.StoryMessage paramStoryMessage)
  {
    boolean bool3 = false;
    boolean bool4 = false;
    boolean bool8 = false;
    boolean bool9 = false;
    boolean bool10 = false;
    boolean bool5 = false;
    boolean bool6 = false;
    boolean bool2 = false;
    boolean bool7 = false;
    boolean bool1 = false;
    this.d = 0;
    this.e = false;
    this.h = 0;
    this.j = -1;
    this.v = true;
    Object localObject;
    if (paramStoryMessage.like_info.has())
    {
      localObject = (qqstory_710_message.StoryLikeInfo)paramStoryMessage.like_info.get();
      this.c = ((qqstory_710_message.StoryLikeInfo)localObject).union_id.get().toStringUtf8();
      this.g = (((qqstory_710_message.StoryLikeInfo)localObject).like_time.get() * 1000L);
      if (((qqstory_710_message.StoryLikeInfo)localObject).is_bigv.get() == 1) {
        bool1 = true;
      }
      this.k = bool1;
      this.d = 1;
      this.h = ((qqstory_710_message.StoryLikeInfo)localObject).type.get();
      this.A = ((qqstory_710_message.StoryLikeInfo)localObject).share_name.get().toStringUtf8();
      this.C = ((qqstory_710_message.StoryLikeInfo)localObject).share_union_id.get().toStringUtf8();
      this.D = ((qqstory_710_message.StoryLikeInfo)localObject).share_type.get();
    }
    else if (paramStoryMessage.comment_info.has())
    {
      localObject = (qqstory_710_message.StoryCommentInfo)paramStoryMessage.comment_info.get();
      this.c = ((qqstory_710_message.StoryCommentInfo)localObject).union_id.get().toStringUtf8();
      this.g = (((qqstory_710_message.StoryCommentInfo)localObject).comment_time.get() * 1000L);
      if (((qqstory_710_message.StoryCommentInfo)localObject).is_bigv.get() == 1) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      this.k = bool1;
      if (((qqstory_710_message.StoryCommentInfo)localObject).comment_del.get() == 1) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      this.e = bool1;
      this.n = ((qqstory_710_message.StoryCommentInfo)localObject).content.get().toStringUtf8();
      this.j = ((qqstory_710_message.StoryCommentInfo)localObject).comment_id.get();
      if ((!((qqstory_710_message.StoryCommentInfo)localObject).reply_uid.has()) && (!((qqstory_710_message.StoryCommentInfo)localObject).reply_union_id.has()))
      {
        this.d = 2;
      }
      else
      {
        this.l = ((qqstory_710_message.StoryCommentInfo)localObject).reply_union_id.get().toStringUtf8();
        bool1 = bool3;
        if (((qqstory_710_message.StoryCommentInfo)localObject).reply_is_bigv.get() == 1) {
          bool1 = true;
        }
        this.m = bool1;
        this.d = 3;
      }
      this.h = ((qqstory_710_message.StoryCommentInfo)localObject).type.get();
      this.A = ((qqstory_710_message.StoryCommentInfo)localObject).share_name.get().toStringUtf8();
      this.C = ((qqstory_710_message.StoryCommentInfo)localObject).share_union_id.get().toStringUtf8();
      this.D = ((qqstory_710_message.StoryCommentInfo)localObject).share_type.get();
    }
    else if (paramStoryMessage.publish_info.has())
    {
      localObject = (qqstory_710_message.StoryPublishInfo)paramStoryMessage.publish_info.get();
      this.c = ((qqstory_710_message.StoryPublishInfo)localObject).union_id.get().toStringUtf8();
      this.g = (((qqstory_710_message.StoryPublishInfo)localObject).publish_time.get() * 1000L);
      if (((qqstory_710_message.StoryPublishInfo)localObject).is_bigv.get() == 1) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      this.k = bool1;
      this.d = 4;
      bool1 = bool4;
      if (((qqstory_710_message.StoryPublishInfo)localObject).video_del.has())
      {
        bool1 = bool4;
        if (((qqstory_710_message.StoryPublishInfo)localObject).video_del.get() == 1) {
          bool1 = true;
        }
      }
      this.e = bool1;
      this.A = ((qqstory_710_message.StoryPublishInfo)localObject).share_name.get().toStringUtf8();
      this.C = ((qqstory_710_message.StoryPublishInfo)localObject).share_union_id.get().toStringUtf8();
      this.D = ((qqstory_710_message.StoryPublishInfo)localObject).share_type.get();
    }
    else if (paramStoryMessage.official_info.has())
    {
      localObject = (qqstory_710_message.StoryOfficialInfo)paramStoryMessage.official_info.get();
      this.w = ((qqstory_710_message.StoryOfficialInfo)localObject).official_uin.get();
      this.c = ((qqstory_710_message.StoryOfficialInfo)localObject).union_id.get().toStringUtf8();
      this.x = ((qqstory_710_message.StoryOfficialInfo)localObject).jump_url.get().toStringUtf8();
      this.y = ((qqstory_710_message.StoryOfficialInfo)localObject).url_type.get();
      this.z = ((qqstory_710_message.StoryOfficialInfo)localObject).content.get().toStringUtf8();
      this.g = (((qqstory_710_message.StoryOfficialInfo)localObject).push_time.get() * 1000L);
      bool1 = bool8;
      if (((qqstory_710_message.StoryOfficialInfo)localObject).is_bigv.get() == 1) {
        bool1 = true;
      }
      this.k = bool1;
      this.P = paramStoryMessage.official_info.cover_url.get().toStringUtf8();
      this.d = 5;
    }
    else if (paramStoryMessage.share_info.has())
    {
      localObject = (qqstory_710_message.ShareGroupInfo)paramStoryMessage.share_info.get();
      this.c = ((qqstory_710_message.ShareGroupInfo)localObject).union_id.get().toStringUtf8();
      this.A = ((qqstory_710_message.ShareGroupInfo)localObject).share_name.get().toStringUtf8();
      int i1 = ((qqstory_710_message.ShareGroupInfo)localObject).oper_type.get();
      if (i1 != 1)
      {
        if (i1 != 2)
        {
          if (i1 != 3)
          {
            if (i1 != 4)
            {
              if (i1 == 5)
              {
                this.d = 11;
                this.n = HardCodeUtil.a(2131904448);
              }
            }
            else
            {
              this.d = 9;
              this.n = StoryApi.a(2131897982, new Object[] { this.A });
            }
          }
          else {
            this.d = 8;
          }
        }
        else
        {
          this.d = 7;
          this.B = ((qqstory_710_message.ShareGroupInfo)localObject).share_new_name.get().toStringUtf8();
          this.n = StoryApi.a(2131897977, new Object[] { this.B });
        }
      }
      else
      {
        this.d = 6;
        this.n = StoryApi.a(2131897976, new Object[] { this.A });
      }
      this.g = (((qqstory_710_message.ShareGroupInfo)localObject).push_time.get() * 1000L);
      bool1 = bool9;
      if (((qqstory_710_message.ShareGroupInfo)localObject).is_bigv.get() == 1) {
        bool1 = true;
      }
      this.k = bool1;
      this.C = ((qqstory_710_message.ShareGroupInfo)localObject).share_union_id.get().toStringUtf8();
      this.D = ((qqstory_710_message.ShareGroupInfo)localObject).share_type.get();
    }
    else if (paramStoryMessage.medal_info.has())
    {
      localObject = (qqstory_710_message.StoryMedalInfo)paramStoryMessage.medal_info.get();
      this.c = ((qqstory_710_message.StoryMedalInfo)localObject).union_id.get().toStringUtf8();
      this.g = (((qqstory_710_message.StoryMedalInfo)localObject).push_time.get() * 1000L);
      this.n = ((qqstory_710_message.StoryMedalInfo)localObject).content.get().toStringUtf8();
      bool1 = bool10;
      if (((qqstory_710_message.StoryMedalInfo)localObject).is_bigv.get() == 1) {
        bool1 = true;
      }
      this.k = bool1;
      this.P = ((qqstory_710_message.StoryMedalInfo)localObject).cover_url.get().toStringUtf8();
      this.d = 10;
    }
    else if (paramStoryMessage.vote_info.has())
    {
      localObject = (qqstory_710_message.StoryVoteInfo)paramStoryMessage.vote_info.get();
      this.c = ((qqstory_710_message.StoryVoteInfo)localObject).union_id.get().toStringUtf8();
      this.g = (((qqstory_710_message.StoryVoteInfo)localObject).vote_time.get() * 1000L);
      if (((qqstory_710_message.StoryVoteInfo)localObject).is_bigv.get() == 1) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      this.k = bool1;
      bool1 = bool5;
      if (((qqstory_710_message.StoryVoteInfo)localObject).video_del.has())
      {
        bool1 = bool5;
        if (((qqstory_710_message.StoryVoteInfo)localObject).video_del.get() == 1) {
          bool1 = true;
        }
      }
      this.e = bool1;
      this.E = ((qqstory_710_message.StoryVoteInfo)localObject).vote_question.get().toStringUtf8();
      this.F = ((qqstory_710_message.StoryVoteInfo)localObject).vote_answer.get().toStringUtf8();
      this.G = ((qqstory_710_message.StoryVoteInfo)localObject).nick_postfix.get().toStringUtf8();
      if (((qqstory_710_message.StoryVoteInfo)localObject).vote_type.get() == 1) {
        this.d = 12;
      } else if (((qqstory_710_message.StoryVoteInfo)localObject).is_my_vote.get() == 1) {
        this.d = 13;
      } else {
        this.d = 14;
      }
    }
    else if (paramStoryMessage.grade_info.has())
    {
      localObject = (qqstory_710_message.StoryGradeInfo)paramStoryMessage.grade_info.get();
      this.c = ((qqstory_710_message.StoryGradeInfo)localObject).union_id.get().toStringUtf8();
      this.g = (((qqstory_710_message.StoryGradeInfo)localObject).grade_time.get() * 1000L);
      if (((qqstory_710_message.StoryGradeInfo)localObject).is_bigv.get() == 1) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      this.k = bool1;
      bool1 = bool6;
      if (((qqstory_710_message.StoryGradeInfo)localObject).video_del.has())
      {
        bool1 = bool6;
        if (((qqstory_710_message.StoryGradeInfo)localObject).video_del.get() == 1) {
          bool1 = true;
        }
      }
      this.e = bool1;
      this.H = ((qqstory_710_message.StoryGradeInfo)localObject).grade_question.get().toStringUtf8();
      this.I = ((qqstory_710_message.StoryGradeInfo)localObject).grade_option.get();
      this.G = ((qqstory_710_message.StoryGradeInfo)localObject).nick_postfix.get().toStringUtf8();
      if (((qqstory_710_message.StoryGradeInfo)localObject).grade_type.get() == 1) {
        this.d = 15;
      } else if (((qqstory_710_message.StoryGradeInfo)localObject).is_my_grade.get() == 1) {
        this.d = 16;
      } else {
        this.d = 17;
      }
    }
    else if (paramStoryMessage.photo_info.has())
    {
      localObject = (qqstory_710_message.StoryPhotoTogetherInfo)paramStoryMessage.photo_info.get();
      this.c = ((qqstory_710_message.StoryPhotoTogetherInfo)localObject).union_id.get().toStringUtf8();
      this.g = (((qqstory_710_message.StoryPhotoTogetherInfo)localObject).photo_time.get() * 1000L);
      if (((qqstory_710_message.StoryPhotoTogetherInfo)localObject).is_bigv.get() == 1) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      this.k = bool1;
      if ((((qqstory_710_message.StoryPhotoTogetherInfo)localObject).video_del.has()) && (((qqstory_710_message.StoryPhotoTogetherInfo)localObject).video_del.get() == 1)) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      this.e = bool1;
      bool1 = bool2;
      if (((qqstory_710_message.StoryPhotoTogetherInfo)localObject).comment_del.has())
      {
        bool1 = bool2;
        if (((qqstory_710_message.StoryPhotoTogetherInfo)localObject).comment_del.get() == 1) {
          bool1 = true;
        }
      }
      this.J = bool1;
      this.K = ((qqstory_710_message.StoryPhotoTogetherInfo)localObject).photo_feed_id.get().toStringUtf8();
      this.s = ((qqstory_710_message.StoryPhotoTogetherInfo)localObject).at_video_ts.get();
      this.d = 18;
    }
    else if (paramStoryMessage.chall_info.has())
    {
      localObject = (qqstory_710_message.StoryChallengeInfo)paramStoryMessage.chall_info.get();
      this.j = ((qqstory_710_message.StoryChallengeInfo)localObject).comment_id.get();
      this.g = (((qqstory_710_message.StoryChallengeInfo)localObject).challenge_time.get() * 1000L);
      this.n = ((qqstory_710_message.StoryChallengeInfo)localObject).content.get().toStringUtf8();
      if (((qqstory_710_message.StoryChallengeInfo)localObject).comment_del.get() == 1) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      this.M = bool1;
      bool1 = bool7;
      if (((qqstory_710_message.StoryChallengeInfo)localObject).video_del.get() == 1) {
        bool1 = true;
      }
      this.N = bool1;
      this.c = ((qqstory_710_message.StoryChallengeInfo)localObject).union_id.get().toStringUtf8();
      this.L = ((qqstory_710_message.StoryChallengeInfo)localObject).challenge_feed_id.get().toStringUtf8();
      this.d = 19;
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.e("MessageData", 2, "Story message item wrong data, no info in response.");
      }
      this.v = false;
    }
    if (paramStoryMessage.video_info.has())
    {
      this.P = paramStoryMessage.video_info.cover_url.get().toStringUtf8();
      this.f = paramStoryMessage.video_info.vid.get().toStringUtf8();
      this.i = paramStoryMessage.video_info.union_id.get().toStringUtf8();
      this.q = paramStoryMessage.video_info.vote_attr.get().toStringUtf8();
      if (!TextUtils.isEmpty(this.q)) {
        this.a = StoryVideoItem.PollLayout.a(this.q);
      }
      if (!TextUtils.isEmpty(this.r)) {
        this.b = StoryVideoItem.InteractPasterLayout.a(this.r);
      }
    }
    this.o = paramStoryMessage.feed_id.get().toStringUtf8();
    this.p = paramStoryMessage.message_id.get();
    this.t = paramStoryMessage.src_type.get();
    this.u = paramStoryMessage.src_uid.get();
  }
  
  public String a()
  {
    if (this.O == null) {
      this.O = StoryListUtils.a(this.g);
    }
    return this.O;
  }
  
  public String b()
  {
    if (this.Q == null) {
      this.Q = ThumbnailUrlHelper.a(this.P);
    }
    return this.Q;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.messagenotify.MessageData
 * JD-Core Version:    0.7.0.1
 */