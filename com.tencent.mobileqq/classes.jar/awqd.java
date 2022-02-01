import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.nearby.now.model.VideoData;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.pb.now.FeedsProtocol.GetMediaDetailRsp;
import com.tencent.pb.now.FeedsProtocol.LiveAggregateInfo;
import com.tencent.pb.now.FeedsProtocol.MediaInfo;
import com.tencent.pb.now.FeedsProtocol.PicFeedsInfo;
import com.tencent.pb.now.FeedsProtocol.RichTitleElement;
import com.tencent.pb.now.FeedsProtocol.ShortVideoInfo;
import com.tencent.pb.now.FeedsProtocol.TextFeed;
import com.tencent.pb.now.FeedsProtocol.TopicCfg;
import com.tencent.pb.now.FeedsProtocol.UserInfo;
import com.tencent.pb.now.FeedsProtocol.VideoItem;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class awqd
  extends awpy
{
  private String a;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  
  private void a(int paramInt, List<FeedsProtocol.TopicCfg> paramList, FeedsProtocol.VideoItem paramVideoItem, ArrayList<VideoData> paramArrayList)
  {
    if (paramVideoItem == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("paseRecord", 1, "item is null!");
      }
      return;
    }
    VideoData localVideoData = new VideoData();
    localVideoData.jdField_a_of_type_Int = 1;
    localVideoData.jdField_a_of_type_JavaLangString = paramVideoItem.id.get().toStringUtf8();
    localVideoData.jdField_e_of_type_JavaLangString = paramVideoItem.jump_url.get().toStringUtf8();
    localVideoData.jdField_a_of_type_Long = paramVideoItem.user_info.uid.get();
    localVideoData.b = paramVideoItem.user_info.explicit_uid.get();
    localVideoData.jdField_c_of_type_Int = paramVideoItem.user_info.id_type.get();
    localVideoData.jdField_c_of_type_JavaLangString = paramVideoItem.video_cover_url.get().toStringUtf8();
    localVideoData.f = ((FeedsProtocol.UserInfo)paramVideoItem.user_info.get()).head_img_url.get().toStringUtf8();
    localVideoData.g = ((FeedsProtocol.UserInfo)paramVideoItem.user_info.get()).anchor_name.get().toStringUtf8();
    localVideoData.jdField_e_of_type_Long = paramVideoItem.video_start_time.get();
    localVideoData.m = paramInt;
    localVideoData.j = "";
    paramVideoItem = paramVideoItem.rpt_msg_rich_title.get().iterator();
    while (paramVideoItem.hasNext())
    {
      FeedsProtocol.RichTitleElement localRichTitleElement = (FeedsProtocol.RichTitleElement)paramVideoItem.next();
      if (localRichTitleElement.type.get() == 1) {
        localVideoData.j += localRichTitleElement.text.get().toStringUtf8();
      } else if (localRichTitleElement.type.get() == 2) {
        localVideoData.j = (localVideoData.j + "#" + localRichTitleElement.text.get().toStringUtf8() + "#");
      }
    }
    paramArrayList.add(awqo.a(paramList, localVideoData));
    paramArrayList.add(localVideoData);
  }
  
  private void a(FeedsProtocol.GetMediaDetailRsp paramGetMediaDetailRsp)
  {
    paramGetMediaDetailRsp = paramGetMediaDetailRsp.media_list.get();
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    paramGetMediaDetailRsp = paramGetMediaDetailRsp.iterator();
    while (paramGetMediaDetailRsp.hasNext())
    {
      FeedsProtocol.MediaInfo localMediaInfo = (FeedsProtocol.MediaInfo)paramGetMediaDetailRsp.next();
      if (localMediaInfo.type.get() == 1) {
        b(localMediaInfo, this.jdField_a_of_type_JavaUtilArrayList);
      } else if (localMediaInfo.type.get() == 2) {
        a(localMediaInfo, this.jdField_a_of_type_JavaUtilArrayList);
      } else if (localMediaInfo.type.get() == 3) {
        a(localMediaInfo.is_my_feeds.get(), localMediaInfo.topic_cfg.get(), (FeedsProtocol.ShortVideoInfo)localMediaInfo.short_video.get(), this.jdField_a_of_type_JavaUtilArrayList);
      } else if (localMediaInfo.type.get() == 5) {
        a(localMediaInfo.is_my_feeds.get(), localMediaInfo.topic_cfg.get(), (FeedsProtocol.PicFeedsInfo)localMediaInfo.pic_info.get(), this.jdField_a_of_type_JavaUtilArrayList);
      } else if (localMediaInfo.type.get() == 6) {
        a(localMediaInfo.is_my_feeds.get(), localMediaInfo.topic_cfg.get(), (FeedsProtocol.TextFeed)localMediaInfo.text_feed.get(), this.jdField_a_of_type_JavaUtilArrayList);
      }
    }
  }
  
  private void a(FeedsProtocol.MediaInfo paramMediaInfo, ArrayList<VideoData> paramArrayList)
  {
    FeedsProtocol.VideoItem localVideoItem = (FeedsProtocol.VideoItem)paramMediaInfo.video.get();
    a(paramMediaInfo.is_my_feeds.get(), paramMediaInfo.topic_cfg.get(), localVideoItem, paramArrayList);
  }
  
  private void b(FeedsProtocol.MediaInfo paramMediaInfo, ArrayList<VideoData> paramArrayList)
  {
    Object localObject1 = (FeedsProtocol.LiveAggregateInfo)paramMediaInfo.live_aggregate.get();
    FeedsProtocol.VideoItem localVideoItem = (FeedsProtocol.VideoItem)((FeedsProtocol.LiveAggregateInfo)localObject1).video.get();
    if ((((FeedsProtocol.LiveAggregateInfo)localObject1).total_short_size.get() == 0) && (localVideoItem != null) && (!TextUtils.isEmpty(localVideoItem.jump_url.get().toString()))) {
      a(paramMediaInfo.is_my_feeds.get(), paramMediaInfo.topic_cfg.get(), localVideoItem, paramArrayList);
    }
    for (;;)
    {
      return;
      localObject1 = ((FeedsProtocol.LiveAggregateInfo)localObject1).short_video.get().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (FeedsProtocol.ShortVideoInfo)((Iterator)localObject1).next();
        localObject2 = a(paramMediaInfo.is_my_feeds.get(), paramMediaInfo.topic_cfg.get(), (FeedsProtocol.ShortVideoInfo)localObject2, paramArrayList);
        ((VideoData)localObject2).jdField_e_of_type_JavaLangString = localVideoItem.jump_url.get().toStringUtf8();
        ((VideoData)localObject2).jdField_a_of_type_Int = 3;
      }
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    new awqu(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b(this.jdField_a_of_type_JavaLangString + "&num=" + 10, new awqf(this));
  }
  
  public void a(Bundle paramBundle)
  {
    paramBundle = paramBundle.getString("raw_url");
    this.jdField_a_of_type_JavaLangString = Uri.parse(paramBundle).getQuery();
    if (QLog.isColorLevel()) {
      QLog.d("InfinitePlayListDataModel", 2, "InfinitePlayListDataModel, url=" + paramBundle);
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.jdField_b_of_type_JavaLangString = paramString2;
    if (!TextUtils.isEmpty(paramString1)) {
      this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString.replace(paramString1, paramString2);
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void b()
  {
    if (this.jdField_b_of_type_Boolean) {
      return;
    }
    new awqu(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b(this.jdField_a_of_type_JavaLangString + "&num=" + 10, new awqe(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awqd
 * JD-Core Version:    0.7.0.1
 */