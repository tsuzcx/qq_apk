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
  public int a;
  public long a;
  public StoryVideoItem.InteractPasterLayout a;
  public StoryVideoItem.PollLayout a;
  public String a;
  public boolean a;
  public int b;
  public long b;
  public String b;
  public boolean b;
  public int c;
  public long c;
  public String c;
  public boolean c;
  public int d;
  public String d;
  public boolean d;
  public int e;
  public String e;
  public boolean e;
  public int f;
  public String f;
  public boolean f;
  public int g;
  public String g;
  public boolean g;
  public int h;
  public String h;
  public int i;
  public String i;
  public String j;
  public String k;
  public String l;
  public String m;
  public String n;
  public String o;
  public String p;
  public String q;
  public String r;
  public String s;
  private String t;
  private String u;
  private String v;
  
  public MessageData(qqstory_710_message.StoryMessage paramStoryMessage)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Int = -1;
    this.jdField_d_of_type_Boolean = true;
    Object localObject;
    if (paramStoryMessage.like_info.has())
    {
      localObject = (qqstory_710_message.StoryLikeInfo)paramStoryMessage.like_info.get();
      this.jdField_a_of_type_JavaLangString = ((qqstory_710_message.StoryLikeInfo)localObject).union_id.get().toStringUtf8();
      this.jdField_a_of_type_Long = (((qqstory_710_message.StoryLikeInfo)localObject).like_time.get() * 1000L);
      if (((qqstory_710_message.StoryLikeInfo)localObject).is_bigv.get() == 1) {
        bool1 = true;
      }
      this.jdField_b_of_type_Boolean = bool1;
      this.jdField_a_of_type_Int = 1;
      this.jdField_b_of_type_Int = ((qqstory_710_message.StoryLikeInfo)localObject).type.get();
      this.k = ((qqstory_710_message.StoryLikeInfo)localObject).share_name.get().toStringUtf8();
      this.m = ((qqstory_710_message.StoryLikeInfo)localObject).share_union_id.get().toStringUtf8();
      this.jdField_h_of_type_Int = ((qqstory_710_message.StoryLikeInfo)localObject).share_type.get();
    }
    for (;;)
    {
      if (paramStoryMessage.video_info.has())
      {
        this.u = paramStoryMessage.video_info.cover_url.get().toStringUtf8();
        this.jdField_b_of_type_JavaLangString = paramStoryMessage.video_info.vid.get().toStringUtf8();
        this.jdField_c_of_type_JavaLangString = paramStoryMessage.video_info.union_id.get().toStringUtf8();
        this.jdField_g_of_type_JavaLangString = paramStoryMessage.video_info.vote_attr.get().toStringUtf8();
        if (!TextUtils.isEmpty(this.jdField_g_of_type_JavaLangString)) {
          this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem$PollLayout = StoryVideoItem.PollLayout.a(this.jdField_g_of_type_JavaLangString);
        }
        if (!TextUtils.isEmpty(this.jdField_h_of_type_JavaLangString)) {
          this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem$InteractPasterLayout = StoryVideoItem.InteractPasterLayout.a(this.jdField_h_of_type_JavaLangString);
        }
      }
      this.jdField_f_of_type_JavaLangString = paramStoryMessage.feed_id.get().toStringUtf8();
      this.jdField_d_of_type_Int = paramStoryMessage.message_id.get();
      this.jdField_f_of_type_Int = paramStoryMessage.src_type.get();
      this.jdField_b_of_type_Long = paramStoryMessage.src_uid.get();
      return;
      if (paramStoryMessage.comment_info.has())
      {
        localObject = (qqstory_710_message.StoryCommentInfo)paramStoryMessage.comment_info.get();
        this.jdField_a_of_type_JavaLangString = ((qqstory_710_message.StoryCommentInfo)localObject).union_id.get().toStringUtf8();
        this.jdField_a_of_type_Long = (((qqstory_710_message.StoryCommentInfo)localObject).comment_time.get() * 1000L);
        if (((qqstory_710_message.StoryCommentInfo)localObject).is_bigv.get() == 1)
        {
          bool1 = true;
          label425:
          this.jdField_b_of_type_Boolean = bool1;
          if (((qqstory_710_message.StoryCommentInfo)localObject).comment_del.get() != 1) {
            break label599;
          }
          bool1 = true;
          label444:
          this.jdField_a_of_type_Boolean = bool1;
          this.jdField_e_of_type_JavaLangString = ((qqstory_710_message.StoryCommentInfo)localObject).content.get().toStringUtf8();
          this.jdField_c_of_type_Int = ((qqstory_710_message.StoryCommentInfo)localObject).comment_id.get();
          if ((!((qqstory_710_message.StoryCommentInfo)localObject).reply_uid.has()) && (!((qqstory_710_message.StoryCommentInfo)localObject).reply_union_id.has())) {
            break label609;
          }
          this.jdField_d_of_type_JavaLangString = ((qqstory_710_message.StoryCommentInfo)localObject).reply_union_id.get().toStringUtf8();
          if (((qqstory_710_message.StoryCommentInfo)localObject).reply_is_bigv.get() != 1) {
            break label604;
          }
          bool1 = bool2;
          label527:
          this.jdField_c_of_type_Boolean = bool1;
        }
        label599:
        label604:
        label609:
        for (this.jdField_a_of_type_Int = 3;; this.jdField_a_of_type_Int = 2)
        {
          this.jdField_b_of_type_Int = ((qqstory_710_message.StoryCommentInfo)localObject).type.get();
          this.k = ((qqstory_710_message.StoryCommentInfo)localObject).share_name.get().toStringUtf8();
          this.m = ((qqstory_710_message.StoryCommentInfo)localObject).share_union_id.get().toStringUtf8();
          this.jdField_h_of_type_Int = ((qqstory_710_message.StoryCommentInfo)localObject).share_type.get();
          break;
          bool1 = false;
          break label425;
          bool1 = false;
          break label444;
          bool1 = false;
          break label527;
        }
      }
      if (paramStoryMessage.publish_info.has())
      {
        localObject = (qqstory_710_message.StoryPublishInfo)paramStoryMessage.publish_info.get();
        this.jdField_a_of_type_JavaLangString = ((qqstory_710_message.StoryPublishInfo)localObject).union_id.get().toStringUtf8();
        this.jdField_a_of_type_Long = (((qqstory_710_message.StoryPublishInfo)localObject).publish_time.get() * 1000L);
        if (((qqstory_710_message.StoryPublishInfo)localObject).is_bigv.get() == 1)
        {
          bool1 = true;
          label685:
          this.jdField_b_of_type_Boolean = bool1;
          this.jdField_a_of_type_Int = 4;
          if ((!((qqstory_710_message.StoryPublishInfo)localObject).video_del.has()) || (((qqstory_710_message.StoryPublishInfo)localObject).video_del.get() != 1)) {
            break label776;
          }
        }
        label776:
        for (bool1 = bool6;; bool1 = false)
        {
          this.jdField_a_of_type_Boolean = bool1;
          this.k = ((qqstory_710_message.StoryPublishInfo)localObject).share_name.get().toStringUtf8();
          this.m = ((qqstory_710_message.StoryPublishInfo)localObject).share_union_id.get().toStringUtf8();
          this.jdField_h_of_type_Int = ((qqstory_710_message.StoryPublishInfo)localObject).share_type.get();
          break;
          bool1 = false;
          break label685;
        }
      }
      if (paramStoryMessage.official_info.has())
      {
        localObject = (qqstory_710_message.StoryOfficialInfo)paramStoryMessage.official_info.get();
        this.jdField_c_of_type_Long = ((qqstory_710_message.StoryOfficialInfo)localObject).official_uin.get();
        this.jdField_a_of_type_JavaLangString = ((qqstory_710_message.StoryOfficialInfo)localObject).union_id.get().toStringUtf8();
        this.jdField_i_of_type_JavaLangString = ((qqstory_710_message.StoryOfficialInfo)localObject).jump_url.get().toStringUtf8();
        this.jdField_g_of_type_Int = ((qqstory_710_message.StoryOfficialInfo)localObject).url_type.get();
        this.j = ((qqstory_710_message.StoryOfficialInfo)localObject).content.get().toStringUtf8();
        this.jdField_a_of_type_Long = (((qqstory_710_message.StoryOfficialInfo)localObject).push_time.get() * 1000L);
        if (((qqstory_710_message.StoryOfficialInfo)localObject).is_bigv.get() == 1) {}
        for (bool1 = bool8;; bool1 = false)
        {
          this.jdField_b_of_type_Boolean = bool1;
          this.u = paramStoryMessage.official_info.cover_url.get().toStringUtf8();
          this.jdField_a_of_type_Int = 5;
          break;
        }
      }
      if (paramStoryMessage.share_info.has())
      {
        localObject = (qqstory_710_message.ShareGroupInfo)paramStoryMessage.share_info.get();
        this.jdField_a_of_type_JavaLangString = ((qqstory_710_message.ShareGroupInfo)localObject).union_id.get().toStringUtf8();
        this.k = ((qqstory_710_message.ShareGroupInfo)localObject).share_name.get().toStringUtf8();
        switch (((qqstory_710_message.ShareGroupInfo)localObject).oper_type.get())
        {
        default: 
          label1032:
          this.jdField_a_of_type_Long = (((qqstory_710_message.ShareGroupInfo)localObject).push_time.get() * 1000L);
          if (((qqstory_710_message.ShareGroupInfo)localObject).is_bigv.get() != 1) {
            break;
          }
        }
        for (bool1 = bool9;; bool1 = false)
        {
          this.jdField_b_of_type_Boolean = bool1;
          this.m = ((qqstory_710_message.ShareGroupInfo)localObject).share_union_id.get().toStringUtf8();
          this.jdField_h_of_type_Int = ((qqstory_710_message.ShareGroupInfo)localObject).share_type.get();
          break;
          this.jdField_a_of_type_Int = 6;
          this.jdField_e_of_type_JavaLangString = StoryApi.a(2131699782, new Object[] { this.k });
          break label1032;
          this.jdField_a_of_type_Int = 7;
          this.l = ((qqstory_710_message.ShareGroupInfo)localObject).share_new_name.get().toStringUtf8();
          this.jdField_e_of_type_JavaLangString = StoryApi.a(2131699783, new Object[] { this.l });
          break label1032;
          this.jdField_a_of_type_Int = 8;
          break label1032;
          this.jdField_a_of_type_Int = 9;
          this.jdField_e_of_type_JavaLangString = StoryApi.a(2131699788, new Object[] { this.k });
          break label1032;
          this.jdField_a_of_type_Int = 11;
          this.jdField_e_of_type_JavaLangString = HardCodeUtil.a(2131706574);
          break label1032;
        }
      }
      if (paramStoryMessage.medal_info.has())
      {
        localObject = (qqstory_710_message.StoryMedalInfo)paramStoryMessage.medal_info.get();
        this.jdField_a_of_type_JavaLangString = ((qqstory_710_message.StoryMedalInfo)localObject).union_id.get().toStringUtf8();
        this.jdField_a_of_type_Long = (((qqstory_710_message.StoryMedalInfo)localObject).push_time.get() * 1000L);
        this.jdField_e_of_type_JavaLangString = ((qqstory_710_message.StoryMedalInfo)localObject).content.get().toStringUtf8();
        if (((qqstory_710_message.StoryMedalInfo)localObject).is_bigv.get() == 1) {}
        for (bool1 = bool10;; bool1 = false)
        {
          this.jdField_b_of_type_Boolean = bool1;
          this.u = ((qqstory_710_message.StoryMedalInfo)localObject).cover_url.get().toStringUtf8();
          this.jdField_a_of_type_Int = 10;
          break;
        }
      }
      if (paramStoryMessage.vote_info.has())
      {
        localObject = (qqstory_710_message.StoryVoteInfo)paramStoryMessage.vote_info.get();
        this.jdField_a_of_type_JavaLangString = ((qqstory_710_message.StoryVoteInfo)localObject).union_id.get().toStringUtf8();
        this.jdField_a_of_type_Long = (((qqstory_710_message.StoryVoteInfo)localObject).vote_time.get() * 1000L);
        if (((qqstory_710_message.StoryVoteInfo)localObject).is_bigv.get() == 1) {}
        for (bool1 = true;; bool1 = false)
        {
          this.jdField_b_of_type_Boolean = bool1;
          bool1 = bool4;
          if (((qqstory_710_message.StoryVoteInfo)localObject).video_del.has())
          {
            bool1 = bool4;
            if (((qqstory_710_message.StoryVoteInfo)localObject).video_del.get() == 1) {
              bool1 = true;
            }
          }
          this.jdField_a_of_type_Boolean = bool1;
          this.n = ((qqstory_710_message.StoryVoteInfo)localObject).vote_question.get().toStringUtf8();
          this.o = ((qqstory_710_message.StoryVoteInfo)localObject).vote_answer.get().toStringUtf8();
          this.p = ((qqstory_710_message.StoryVoteInfo)localObject).nick_postfix.get().toStringUtf8();
          if (((qqstory_710_message.StoryVoteInfo)localObject).vote_type.get() != 1) {
            break label1535;
          }
          this.jdField_a_of_type_Int = 12;
          break;
        }
        label1535:
        if (((qqstory_710_message.StoryVoteInfo)localObject).is_my_vote.get() == 1) {
          this.jdField_a_of_type_Int = 13;
        } else {
          this.jdField_a_of_type_Int = 14;
        }
      }
      else if (paramStoryMessage.grade_info.has())
      {
        localObject = (qqstory_710_message.StoryGradeInfo)paramStoryMessage.grade_info.get();
        this.jdField_a_of_type_JavaLangString = ((qqstory_710_message.StoryGradeInfo)localObject).union_id.get().toStringUtf8();
        this.jdField_a_of_type_Long = (((qqstory_710_message.StoryGradeInfo)localObject).grade_time.get() * 1000L);
        if (((qqstory_710_message.StoryGradeInfo)localObject).is_bigv.get() == 1) {}
        for (bool1 = true;; bool1 = false)
        {
          this.jdField_b_of_type_Boolean = bool1;
          bool1 = bool5;
          if (((qqstory_710_message.StoryGradeInfo)localObject).video_del.has())
          {
            bool1 = bool5;
            if (((qqstory_710_message.StoryGradeInfo)localObject).video_del.get() == 1) {
              bool1 = true;
            }
          }
          this.jdField_a_of_type_Boolean = bool1;
          this.q = ((qqstory_710_message.StoryGradeInfo)localObject).grade_question.get().toStringUtf8();
          this.jdField_i_of_type_Int = ((qqstory_710_message.StoryGradeInfo)localObject).grade_option.get();
          this.p = ((qqstory_710_message.StoryGradeInfo)localObject).nick_postfix.get().toStringUtf8();
          if (((qqstory_710_message.StoryGradeInfo)localObject).grade_type.get() != 1) {
            break label1742;
          }
          this.jdField_a_of_type_Int = 15;
          break;
        }
        label1742:
        if (((qqstory_710_message.StoryGradeInfo)localObject).is_my_grade.get() == 1) {
          this.jdField_a_of_type_Int = 16;
        } else {
          this.jdField_a_of_type_Int = 17;
        }
      }
      else
      {
        if (paramStoryMessage.photo_info.has())
        {
          localObject = (qqstory_710_message.StoryPhotoTogetherInfo)paramStoryMessage.photo_info.get();
          this.jdField_a_of_type_JavaLangString = ((qqstory_710_message.StoryPhotoTogetherInfo)localObject).union_id.get().toStringUtf8();
          this.jdField_a_of_type_Long = (((qqstory_710_message.StoryPhotoTogetherInfo)localObject).photo_time.get() * 1000L);
          if (((qqstory_710_message.StoryPhotoTogetherInfo)localObject).is_bigv.get() == 1)
          {
            bool1 = true;
            label1840:
            this.jdField_b_of_type_Boolean = bool1;
            if ((!((qqstory_710_message.StoryPhotoTogetherInfo)localObject).video_del.has()) || (((qqstory_710_message.StoryPhotoTogetherInfo)localObject).video_del.get() != 1)) {
              break label1947;
            }
            bool1 = true;
            label1870:
            this.jdField_a_of_type_Boolean = bool1;
            if ((!((qqstory_710_message.StoryPhotoTogetherInfo)localObject).comment_del.has()) || (((qqstory_710_message.StoryPhotoTogetherInfo)localObject).comment_del.get() != 1)) {
              break label1952;
            }
          }
          label1947:
          label1952:
          for (bool1 = bool3;; bool1 = false)
          {
            this.jdField_e_of_type_Boolean = bool1;
            this.r = ((qqstory_710_message.StoryPhotoTogetherInfo)localObject).photo_feed_id.get().toStringUtf8();
            this.jdField_e_of_type_Int = ((qqstory_710_message.StoryPhotoTogetherInfo)localObject).at_video_ts.get();
            this.jdField_a_of_type_Int = 18;
            break;
            bool1 = false;
            break label1840;
            bool1 = false;
            break label1870;
          }
        }
        if (paramStoryMessage.chall_info.has())
        {
          localObject = (qqstory_710_message.StoryChallengeInfo)paramStoryMessage.chall_info.get();
          this.jdField_c_of_type_Int = ((qqstory_710_message.StoryChallengeInfo)localObject).comment_id.get();
          this.jdField_a_of_type_Long = (((qqstory_710_message.StoryChallengeInfo)localObject).challenge_time.get() * 1000L);
          this.jdField_e_of_type_JavaLangString = ((qqstory_710_message.StoryChallengeInfo)localObject).content.get().toStringUtf8();
          if (((qqstory_710_message.StoryChallengeInfo)localObject).comment_del.get() == 1)
          {
            bool1 = true;
            label2037:
            this.jdField_f_of_type_Boolean = bool1;
            if (((qqstory_710_message.StoryChallengeInfo)localObject).video_del.get() != 1) {
              break label2106;
            }
          }
          label2106:
          for (bool1 = bool7;; bool1 = false)
          {
            this.jdField_g_of_type_Boolean = bool1;
            this.jdField_a_of_type_JavaLangString = ((qqstory_710_message.StoryChallengeInfo)localObject).union_id.get().toStringUtf8();
            this.s = ((qqstory_710_message.StoryChallengeInfo)localObject).challenge_feed_id.get().toStringUtf8();
            this.jdField_a_of_type_Int = 19;
            break;
            bool1 = false;
            break label2037;
          }
        }
        if (QLog.isColorLevel()) {
          QLog.e("MessageData", 2, "Story message item wrong data, no info in response.");
        }
        this.jdField_d_of_type_Boolean = false;
      }
    }
  }
  
  public String a()
  {
    if (this.t == null) {
      this.t = StoryListUtils.a(this.jdField_a_of_type_Long);
    }
    return this.t;
  }
  
  public String b()
  {
    if (this.v == null) {
      this.v = ThumbnailUrlHelper.a(this.u);
    }
    return this.v;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.messagenotify.MessageData
 * JD-Core Version:    0.7.0.1
 */