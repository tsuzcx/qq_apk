package com.tencent.biz.qqstory.network.request;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.channel.NetworkRequest;
import com.tencent.biz.qqstory.model.item.AddressItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem.InteractPasterLayout;
import com.tencent.biz.qqstory.model.item.StoryVideoItem.PollLayout;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqPublishVideo;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspPublishVideo;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.Address;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.InteractPasterInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.TagInfoBase;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.VideoReaderConf;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.VideoSpreadGroupList;
import com.tencent.biz.qqstory.network.response.PublishStoryVideoRespond;
import com.tencent.biz.qqstory.storyHome.model.FeedManager;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.PBUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PublishStoryVideoRequest
  extends NetworkRequest
{
  public static final String a;
  public static final String b;
  public static final String u = String.valueOf(1);
  public static final String v = String.valueOf(2);
  public static final String w = String.valueOf(3);
  public static final String x = String.valueOf(4);
  public static final String y = String.valueOf(5);
  public long a;
  public AddressItem a;
  public boolean a;
  public byte[] a;
  public long b;
  public boolean b;
  public byte[] b;
  public int c;
  public long c;
  public String c;
  public boolean c;
  public byte[] c;
  public int d;
  public long d;
  public String d;
  public int e;
  public long e;
  public String e;
  public int f;
  public String f;
  public int g;
  public String g;
  public int h;
  public String h;
  public int i;
  public String i;
  public int j;
  @Nullable
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
  public String t;
  
  static
  {
    jdField_a_of_type_JavaLangString = StoryApi.a("StorySvc.video_show_publish");
    jdField_b_of_type_JavaLangString = StoryApi.a("StoryGroupSvc.do_video_publish");
  }
  
  public PublishStoryVideoRequest(boolean paramBoolean)
  {
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Int = 5;
  }
  
  public BaseResponse a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspPublishVideo localRspPublishVideo = new qqstory_service.RspPublishVideo();
    try
    {
      localRspPublishVideo.mergeFrom(paramArrayOfByte);
      return new PublishStoryVideoRespond(localRspPublishVideo);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte) {}
    return null;
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_Boolean) {
      return jdField_b_of_type_JavaLangString;
    }
    return jdField_a_of_type_JavaLangString;
  }
  
  protected byte[] a()
  {
    int i2 = 1;
    if (TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) {
      throw new IllegalArgumentException("vid is null");
    }
    if (this.jdField_b_of_type_Long <= 0L) {
      throw new IllegalArgumentException("video duration is " + this.jdField_b_of_type_Long);
    }
    if (TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString)) {
      throw new IllegalArgumentException("video url is " + this.jdField_f_of_type_JavaLangString);
    }
    if ((this.jdField_b_of_type_Boolean) && ((this.jdField_b_of_type_ArrayOfByte == null) || (this.jdField_b_of_type_ArrayOfByte.length <= 0))) {
      throw new IllegalArgumentException("you must need to choose one target to send story!!");
    }
    qqstory_service.ReqPublishVideo localReqPublishVideo = new qqstory_service.ReqPublishVideo();
    localReqPublishVideo.title.set(ByteStringMicro.copyFromUtf8(this.jdField_c_of_type_JavaLangString));
    localReqPublishVideo.vid.set(ByteStringMicro.copyFromUtf8(this.jdField_d_of_type_JavaLangString));
    localReqPublishVideo.video_url.set(ByteStringMicro.copyFromUtf8(this.jdField_f_of_type_JavaLangString));
    localReqPublishVideo.total_time.set(this.jdField_b_of_type_Long);
    if (TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) {
      this.jdField_e_of_type_JavaLangString = FeedManager.a().format(new Date(this.jdField_c_of_type_Long));
    }
    try
    {
      localReqPublishVideo.date.set(Integer.valueOf(this.jdField_e_of_type_JavaLangString).intValue());
      localReqPublishVideo.source.set(this.jdField_g_of_type_Int);
      localObject1 = localReqPublishVideo.sync_to_qzone;
      if (this.jdField_c_of_type_Boolean)
      {
        i1 = 1;
        ((PBUInt32Field)localObject1).set(i1);
        SLog.a("Q.qqstory.publish.PublishStoryVideoRequest", "publish video and StorySyncToQzone is %s", Boolean.valueOf(this.jdField_c_of_type_Boolean));
      }
    }
    catch (NumberFormatException localException)
    {
      try
      {
        localObject1 = new JSONObject();
        ((JSONObject)localObject1).put("video_width", this.jdField_c_of_type_Int);
        ((JSONObject)localObject1).put("video_height", this.jdField_d_of_type_Int);
        ((JSONObject)localObject1).put("video_bytes", this.jdField_d_of_type_Long);
        ((JSONObject)localObject1).put("is_pic", this.jdField_e_of_type_Int);
        if (!TextUtils.isEmpty(this.jdField_h_of_type_JavaLangString)) {
          ((JSONObject)localObject1).put("video_doodle_text", this.jdField_h_of_type_JavaLangString);
        }
        if (!TextUtils.isEmpty(this.l)) {
          ((JSONObject)localObject1).put("video_location", this.l);
        }
        if (!TextUtils.isEmpty(this.m)) {
          ((JSONObject)localObject1).put("video_gps_filter", this.m);
        }
        if (!TextUtils.isEmpty(this.n)) {
          ((JSONObject)localObject1).put("ml", new JSONArray(this.n));
        }
        ((JSONObject)localObject1).put("tz", this.jdField_a_of_type_Long / 1000L);
        if (this.jdField_e_of_type_Int == 0) {
          if (this.jdField_f_of_type_Int == 0)
          {
            localReqPublishVideo.content_type.set(1);
            if (this.jdField_e_of_type_Long == 0L) {
              break label811;
            }
            ((JSONObject)localObject1).put("ct", this.jdField_e_of_type_Long);
            ((JSONObject)localObject1).put("il", true);
            localReqPublishVideo.content_origin.set(1);
            if (!TextUtils.isEmpty(this.o)) {
              ((JSONObject)localObject1).put("loc", this.o);
            }
            if (this.jdField_i_of_type_Int != 0) {
              ((JSONObject)localObject1).put("lon", this.jdField_i_of_type_Int);
            }
            if (this.jdField_h_of_type_Int != 0) {
              ((JSONObject)localObject1).put("lat", this.jdField_h_of_type_Int);
            }
            if (this.q != null)
            {
              ((JSONObject)localObject1).putOpt("pl", new JSONObject(this.q));
              ((JSONObject)localObject1).putOpt("pl_pic", this.r);
            }
            if (this.s != null)
            {
              ((JSONObject)localObject1).putOpt("i_l", new JSONObject(this.s));
              ((JSONObject)localObject1).putOpt("il_pic", this.t);
            }
            localReqPublishVideo.video_attr.set(ByteStringMicro.copyFromUtf8(((JSONObject)localObject1).toString()));
            if (TextUtils.isEmpty(this.n)) {
              break label833;
            }
          }
        }
      }
      catch (Exception localException)
      {
        try
        {
          for (;;)
          {
            Object localObject1 = new JSONArray(this.n);
            if ((localObject1 == null) || (((JSONArray)localObject1).length() <= 0)) {
              break label833;
            }
            localArrayList = new ArrayList();
            i1 = 0;
            while (i1 < ((JSONArray)localObject1).length())
            {
              localArrayList.add(Long.valueOf(((JSONArray)localObject1).optJSONObject(i1).getString("u")));
              i1 += 1;
            }
            localNumberFormatException = localNumberFormatException;
            SLog.b("Q.qqstory.publish.PublishStoryVideoRequest", "format date ", localNumberFormatException);
            continue;
            i1 = 0;
            continue;
            localReqPublishVideo.content_type.set(this.jdField_f_of_type_Int);
            continue;
            localException = localException;
            SLog.b("Q.qqstory.publish.PublishStoryVideoRequest", "encode json fail", localException);
            continue;
            localReqPublishVideo.content_type.set(0);
            continue;
            label811:
            localReqPublishVideo.content_origin.set(0);
          }
          localReqPublishVideo.mention_list.addAll(localArrayList);
        }
        catch (JSONException localInvalidProtocolBufferMicroException2)
        {
          try
          {
            label833:
            ((qqstory_struct.VideoReaderConf)localObject2).mergeFrom(this.jdField_a_of_type_ArrayOfByte);
            localReqPublishVideo.reader_conf.set((MessageMicro)localObject2);
            if ((this.jdField_b_of_type_ArrayOfByte == null) || (this.jdField_b_of_type_ArrayOfByte.length <= 0)) {
              break label1084;
            }
            localObject2 = new qqstory_struct.VideoSpreadGroupList();
          }
          catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException2)
          {
            try
            {
              ((qqstory_struct.VideoSpreadGroupList)localObject2).mergeFrom(this.jdField_b_of_type_ArrayOfByte);
              localReqPublishVideo.group_list = ((qqstory_struct.VideoSpreadGroupList)localObject2);
              localObject2 = localReqPublishVideo.ignore_personal_publish;
              if (!this.jdField_b_of_type_Boolean) {
                break label1332;
              }
              i1 = 1;
              ((PBUInt32Field)localObject2).set(i1);
              localReqPublishVideo.group_source.set(this.jdField_j_of_type_Int);
              if ((this.jdField_c_of_type_ArrayOfByte == null) || (this.jdField_c_of_type_ArrayOfByte.length <= 0)) {
                break label1196;
              }
              localObject2 = new qqstory_struct.TagInfoBase();
            }
            catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException2)
            {
              try
              {
                for (;;)
                {
                  ((qqstory_struct.TagInfoBase)localObject2).mergeFrom(this.jdField_c_of_type_ArrayOfByte);
                  localReqPublishVideo.video_label_id.set(((qqstory_struct.TagInfoBase)localObject2).tag_id.get());
                  localReqPublishVideo.video_label_type.set(((qqstory_struct.TagInfoBase)localObject2).tag_type.get());
                  localReqPublishVideo.video_label_title.set(ByteStringMicro.copyFromUtf8(((qqstory_struct.TagInfoBase)localObject2).tag_name.get()));
                  localReqPublishVideo.client_version.set(5);
                  if (this.q == null) {
                    break label1357;
                  }
                  Object localObject2 = StoryVideoItem.PollLayout.a(this.q);
                  if ((localObject2 == null) || (((StoryVideoItem.PollLayout)localObject2).jdField_a_of_type_ArrayOfJavaLangString == null) || (((StoryVideoItem.PollLayout)localObject2).jdField_a_of_type_ArrayOfJavaLangString.length <= 2)) {
                    break label1357;
                  }
                  localReqPublishVideo.poll_text.set(localObject2.jdField_a_of_type_ArrayOfJavaLangString[0]);
                  ArrayList localArrayList = new ArrayList(((StoryVideoItem.PollLayout)localObject2).jdField_a_of_type_ArrayOfJavaLangString.length);
                  i1 = i2;
                  while (i1 < ((StoryVideoItem.PollLayout)localObject2).jdField_a_of_type_ArrayOfJavaLangString.length)
                  {
                    localArrayList.add(localObject2.jdField_a_of_type_ArrayOfJavaLangString[i1]);
                    i1 += 1;
                  }
                  localJSONException = localJSONException;
                  localJSONException.printStackTrace();
                  continue;
                  String str = this.jdField_i_of_type_JavaLangString;
                  continue;
                  localInvalidProtocolBufferMicroException1 = localInvalidProtocolBufferMicroException1;
                  localInvalidProtocolBufferMicroException1.printStackTrace();
                  continue;
                  localInvalidProtocolBufferMicroException2 = localInvalidProtocolBufferMicroException2;
                  localInvalidProtocolBufferMicroException2.printStackTrace();
                }
                int i1 = 0;
              }
              catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException3)
              {
                for (;;)
                {
                  localInvalidProtocolBufferMicroException3.printStackTrace();
                }
                localReqPublishVideo.poll_options.set(localInvalidProtocolBufferMicroException3);
                if (this.s == null) {
                  break label1437;
                }
                StoryVideoItem.InteractPasterLayout localInteractPasterLayout = StoryVideoItem.InteractPasterLayout.a(this.s);
                if ((localInteractPasterLayout == null) || (localInteractPasterLayout.jdField_a_of_type_ArrayOfJavaLangString == null) || (localInteractPasterLayout.jdField_a_of_type_ArrayOfJavaLangString.length <= 0)) {
                  break label1437;
                }
                qqstory_struct.InteractPasterInfo localInteractPasterInfo = new qqstory_struct.InteractPasterInfo();
                localInteractPasterInfo.paster_type.set(localInteractPasterLayout.jdField_a_of_type_Int);
                localInteractPasterInfo.paster_contents.set(Arrays.asList(localInteractPasterLayout.jdField_a_of_type_ArrayOfJavaLangString));
                localReqPublishVideo.interact_paster_info.set(localInteractPasterInfo);
                SLog.b("Q.qqstory.publish.PublishStoryVideoRequest", "PublishStoryVideoRequest: " + PBUtils.a(localReqPublishVideo));
              }
            }
          }
        }
        if (!TextUtils.isEmpty(this.jdField_g_of_type_JavaLangString)) {
          localReqPublishVideo.label.set(ByteStringMicro.copyFromUtf8(this.jdField_g_of_type_JavaLangString));
        }
        if (TextUtils.isEmpty(this.jdField_i_of_type_JavaLangString))
        {
          localObject2 = this.jdField_h_of_type_JavaLangString;
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {
            localReqPublishVideo.doodle_text.set(ByteStringMicro.copyFromUtf8((String)localObject2));
          }
          if (!TextUtils.isEmpty(this.jdField_j_of_type_JavaLangString)) {
            localReqPublishVideo.video_cover.set(ByteStringMicro.copyFromUtf8(this.jdField_j_of_type_JavaLangString));
          }
          if (!TextUtils.isEmpty(this.k)) {
            localReqPublishVideo.doodle_url.set(ByteStringMicro.copyFromUtf8(this.k));
          }
          if (this.jdField_a_of_type_ComTencentBizQqstoryModelItemAddressItem != null) {
            localReqPublishVideo.address.set(this.jdField_a_of_type_ComTencentBizQqstoryModelItemAddressItem.convertToProtoObject());
          }
          localReqPublishVideo.create_time.set(this.jdField_c_of_type_Long / 1000L);
          if (!TextUtils.isEmpty(this.p)) {
            localReqPublishVideo.multi_shoot_group_id.set(ByteStringMicro.copyFromUtf8(this.p));
          }
          if ((this.jdField_a_of_type_ArrayOfByte != null) && (this.jdField_a_of_type_ArrayOfByte.length > 0)) {
            localObject2 = new qqstory_struct.VideoReaderConf();
          }
        }
      }
    }
    label1084:
    label1357:
    return localReqPublishVideo.toByteArray();
  }
  
  public String toString()
  {
    return "PublishStoryVideoRequest{title='" + this.jdField_c_of_type_JavaLangString + '\'' + ", vid='" + this.jdField_d_of_type_JavaLangString + '\'' + ", videoThumbnailUrl='" + this.jdField_j_of_type_JavaLangString + '\'' + ", mOriginalMaskPicUrl='" + this.k + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.request.PublishStoryVideoRequest
 * JD-Core Version:    0.7.0.1
 */