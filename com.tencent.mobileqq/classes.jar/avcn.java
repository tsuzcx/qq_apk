import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.now.model.LocationInfo;
import com.tencent.mobileqq.nearby.now.model.VideoData;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.pb.now.FeedsProtocol.LbsInfo;
import com.tencent.pb.now.FeedsProtocol.PicFeedsInfo;
import com.tencent.pb.now.FeedsProtocol.PicInfo;
import com.tencent.pb.now.FeedsProtocol.RichTitleElement;
import com.tencent.pb.now.FeedsProtocol.ShortVideoInfo;
import com.tencent.pb.now.FeedsProtocol.TextFeed;
import com.tencent.pb.now.FeedsProtocol.TopicCfg;
import com.tencent.pb.now.FeedsProtocol.UserInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class avcn
{
  protected int a;
  protected avco a;
  public QQAppInterface a;
  protected ArrayList<VideoData> a;
  protected boolean a;
  
  public avcn()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  protected static VideoData a(int paramInt, List<FeedsProtocol.TopicCfg> paramList, FeedsProtocol.PicFeedsInfo paramPicFeedsInfo, ArrayList<VideoData> paramArrayList)
  {
    boolean bool2 = false;
    VideoData localVideoData = new VideoData();
    localVideoData.jdField_a_of_type_JavaLangString = paramPicFeedsInfo.feeds_id.get().toStringUtf8();
    localVideoData.jdField_e_of_type_Long = paramPicFeedsInfo.create_time.get();
    localVideoData.jdField_k_of_type_JavaLangString = paramPicFeedsInfo.share_url.get().toStringUtf8();
    localVideoData.jdField_g_of_type_JavaLangString = paramPicFeedsInfo.user_info.anchor_name.get().toStringUtf8();
    localVideoData.jdField_a_of_type_Long = paramPicFeedsInfo.user_info.uid.get();
    localVideoData.jdField_b_of_type_Long = paramPicFeedsInfo.user_info.explicit_uid.get();
    localVideoData.jdField_c_of_type_Int = paramPicFeedsInfo.user_info.id_type.get();
    localVideoData.jdField_h_of_type_JavaLangString = paramPicFeedsInfo.user_info.anchor_name.get().toStringUtf8();
    localVideoData.jdField_c_of_type_Long = paramPicFeedsInfo.user_info.uid.get();
    localVideoData.jdField_d_of_type_Long = paramPicFeedsInfo.user_info.explicit_uid.get();
    localVideoData.jdField_g_of_type_Int = paramPicFeedsInfo.user_info.id_type.get();
    localVideoData.i = paramPicFeedsInfo.user_info.head_img_url.get().toStringUtf8();
    if (paramPicFeedsInfo.is_listen.get() != 0) {}
    Object localObject;
    for (boolean bool1 = true;; bool1 = false)
    {
      localVideoData.jdField_a_of_type_Boolean = bool1;
      bool1 = bool2;
      if (paramPicFeedsInfo.is_like.get() != 0) {
        bool1 = true;
      }
      localVideoData.jdField_b_of_type_Boolean = bool1;
      localVideoData.jdField_b_of_type_Int = paramPicFeedsInfo.like_num.get();
      localVideoData.jdField_f_of_type_JavaLangString = paramPicFeedsInfo.user_info.head_img_url.get().toStringUtf8();
      localVideoData.jdField_d_of_type_Int = paramPicFeedsInfo.view_times.get();
      localVideoData.jdField_e_of_type_Int = paramPicFeedsInfo.user_info.age.get();
      localVideoData.jdField_f_of_type_Int = paramPicFeedsInfo.user_info.user_gender.get();
      localVideoData.jdField_g_of_type_Long = paramPicFeedsInfo.user_info.uid.get();
      localVideoData.jdField_h_of_type_Long = paramPicFeedsInfo.user_info.explicit_uid.get();
      localVideoData.jdField_h_of_type_Int = paramPicFeedsInfo.user_info.id_type.get();
      localVideoData.jdField_j_of_type_JavaLangString = "";
      localVideoData.jdField_j_of_type_Int = paramPicFeedsInfo.feed_type.get();
      localVideoData.m = paramInt;
      localIterator = paramPicFeedsInfo.pic_infos.get().iterator();
      while (localIterator.hasNext())
      {
        localObject = (FeedsProtocol.PicInfo)localIterator.next();
        localVideoData.jdField_a_of_type_JavaUtilArrayList.add(new avcr(((FeedsProtocol.PicInfo)localObject).url.get().toStringUtf8(), ((FeedsProtocol.PicInfo)localObject).width.get(), ((FeedsProtocol.PicInfo)localObject).hight.get()));
      }
    }
    Iterator localIterator = paramPicFeedsInfo.rpt_msg_rich_title.get().iterator();
    while (localIterator.hasNext())
    {
      localObject = (FeedsProtocol.RichTitleElement)localIterator.next();
      if (((FeedsProtocol.RichTitleElement)localObject).type.get() == 1) {
        localVideoData.jdField_j_of_type_JavaLangString += ((FeedsProtocol.RichTitleElement)localObject).text.get().toStringUtf8();
      } else if (((FeedsProtocol.RichTitleElement)localObject).type.get() == 2) {
        localVideoData.jdField_j_of_type_JavaLangString = (localVideoData.jdField_j_of_type_JavaLangString + "#" + ((FeedsProtocol.RichTitleElement)localObject).text.get().toStringUtf8() + "#");
      }
    }
    if (paramPicFeedsInfo.lbs_info != null)
    {
      paramPicFeedsInfo = (FeedsProtocol.LbsInfo)paramPicFeedsInfo.lbs_info.get();
      localVideoData.jdField_a_of_type_ComTencentMobileqqNearbyNowModelLocationInfo = new LocationInfo();
      localVideoData.jdField_a_of_type_ComTencentMobileqqNearbyNowModelLocationInfo.init(paramPicFeedsInfo.lng.get().toStringUtf8(), paramPicFeedsInfo.lat.get().toStringUtf8(), paramPicFeedsInfo.city.get().toStringUtf8(), paramPicFeedsInfo.name.get().toStringUtf8());
    }
    for (;;)
    {
      paramArrayList.add(avdd.a(paramList, localVideoData));
      return localVideoData;
      localVideoData.jdField_a_of_type_ComTencentMobileqqNearbyNowModelLocationInfo = new LocationInfo();
    }
  }
  
  protected static VideoData a(int paramInt, List<FeedsProtocol.TopicCfg> paramList, FeedsProtocol.ShortVideoInfo paramShortVideoInfo, ArrayList<VideoData> paramArrayList)
  {
    boolean bool2 = false;
    VideoData localVideoData = new VideoData();
    localVideoData.jdField_a_of_type_JavaLangString = paramShortVideoInfo.feeds_id.get().toStringUtf8();
    localVideoData.jdField_a_of_type_Int = 2;
    localVideoData.jdField_e_of_type_Long = paramShortVideoInfo.create_time.get();
    localVideoData.jdField_d_of_type_JavaLangString = paramShortVideoInfo.doodle_pic_url.get().toStringUtf8();
    localVideoData.jdField_k_of_type_JavaLangString = paramShortVideoInfo.share_url.get().toStringUtf8();
    localVideoData.jdField_c_of_type_JavaLangString = paramShortVideoInfo.pic_url.get().toStringUtf8();
    localVideoData.jdField_b_of_type_JavaLangString = paramShortVideoInfo.video_url.get().toStringUtf8();
    localVideoData.jdField_g_of_type_JavaLangString = ((FeedsProtocol.UserInfo)paramShortVideoInfo.anchor_info.get()).anchor_name.get().toStringUtf8();
    localVideoData.jdField_a_of_type_Long = ((FeedsProtocol.UserInfo)paramShortVideoInfo.anchor_info.get()).uid.get();
    localVideoData.jdField_b_of_type_Long = paramShortVideoInfo.anchor_info.explicit_uid.get();
    localVideoData.jdField_c_of_type_Int = paramShortVideoInfo.anchor_info.id_type.get();
    localVideoData.jdField_h_of_type_JavaLangString = paramShortVideoInfo.user_info.anchor_name.get().toStringUtf8();
    localVideoData.jdField_c_of_type_Long = paramShortVideoInfo.user_info.uid.get();
    localVideoData.jdField_d_of_type_Long = paramShortVideoInfo.user_info.explicit_uid.get();
    localVideoData.jdField_g_of_type_Int = paramShortVideoInfo.user_info.id_type.get();
    localVideoData.i = paramShortVideoInfo.user_info.head_img_url.get().toStringUtf8();
    boolean bool1;
    Iterator localIterator;
    if (paramShortVideoInfo.is_listen.get() != 0)
    {
      bool1 = true;
      localVideoData.jdField_a_of_type_Boolean = bool1;
      bool1 = bool2;
      if (paramShortVideoInfo.is_like.get() != 0) {
        bool1 = true;
      }
      localVideoData.jdField_b_of_type_Boolean = bool1;
      localVideoData.jdField_b_of_type_Int = paramShortVideoInfo.like_num.get();
      localVideoData.jdField_f_of_type_JavaLangString = ((FeedsProtocol.UserInfo)paramShortVideoInfo.anchor_info.get()).head_img_url.get().toStringUtf8();
      localVideoData.jdField_d_of_type_Int = paramShortVideoInfo.view_times.get();
      localVideoData.jdField_e_of_type_Int = paramShortVideoInfo.user_info.age.get();
      localVideoData.jdField_f_of_type_Int = paramShortVideoInfo.user_info.user_gender.get();
      localVideoData.jdField_g_of_type_Long = paramShortVideoInfo.user_info.uid.get();
      localVideoData.jdField_h_of_type_Long = paramShortVideoInfo.user_info.explicit_uid.get();
      localVideoData.jdField_h_of_type_Int = paramShortVideoInfo.user_info.id_type.get();
      localVideoData.jdField_j_of_type_JavaLangString = "";
      localVideoData.jdField_j_of_type_Int = paramShortVideoInfo.feed_type.get();
      localVideoData.jdField_k_of_type_Int = paramShortVideoInfo.video_hight.get();
      localVideoData.l = paramShortVideoInfo.video_width.get();
      localVideoData.jdField_f_of_type_Long = paramShortVideoInfo.video_time.get();
      localVideoData.m = paramInt;
      localIterator = paramShortVideoInfo.rpt_msg_rich_title.get().iterator();
    }
    for (;;)
    {
      if (!localIterator.hasNext()) {
        break label646;
      }
      FeedsProtocol.RichTitleElement localRichTitleElement = (FeedsProtocol.RichTitleElement)localIterator.next();
      if (localRichTitleElement.type.get() == 1)
      {
        localVideoData.jdField_j_of_type_JavaLangString += localRichTitleElement.text.get().toStringUtf8();
        continue;
        bool1 = false;
        break;
      }
      if (localRichTitleElement.type.get() == 2) {
        localVideoData.jdField_j_of_type_JavaLangString = (localVideoData.jdField_j_of_type_JavaLangString + "#" + localRichTitleElement.text.get().toStringUtf8() + "#");
      }
    }
    label646:
    if (paramShortVideoInfo.lbs_info.get() != null)
    {
      paramShortVideoInfo = (FeedsProtocol.LbsInfo)paramShortVideoInfo.lbs_info.get();
      localVideoData.jdField_a_of_type_ComTencentMobileqqNearbyNowModelLocationInfo = new LocationInfo();
      localVideoData.jdField_a_of_type_ComTencentMobileqqNearbyNowModelLocationInfo.init(paramShortVideoInfo.lng.get().toStringUtf8(), paramShortVideoInfo.lat.get().toStringUtf8(), paramShortVideoInfo.city.get().toStringUtf8(), paramShortVideoInfo.name.get().toStringUtf8());
    }
    for (;;)
    {
      paramArrayList.add(avdd.a(paramList, localVideoData));
      return localVideoData;
      localVideoData.jdField_a_of_type_ComTencentMobileqqNearbyNowModelLocationInfo = new LocationInfo();
    }
  }
  
  public static void a(int paramInt, List<FeedsProtocol.TopicCfg> paramList, FeedsProtocol.TextFeed paramTextFeed, ArrayList<VideoData> paramArrayList)
  {
    boolean bool2 = false;
    VideoData localVideoData = new VideoData();
    localVideoData.jdField_a_of_type_JavaLangString = paramTextFeed.feeds_id.get();
    localVideoData.jdField_e_of_type_Long = paramTextFeed.create_time.get();
    localVideoData.jdField_k_of_type_JavaLangString = paramTextFeed.share_url.get();
    localVideoData.jdField_a_of_type_Int = 6;
    localVideoData.jdField_g_of_type_JavaLangString = paramTextFeed.user_info.anchor_name.get().toStringUtf8();
    localVideoData.jdField_a_of_type_Long = paramTextFeed.user_info.uid.get();
    localVideoData.jdField_b_of_type_Long = paramTextFeed.user_info.explicit_uid.get();
    localVideoData.jdField_c_of_type_Int = paramTextFeed.user_info.id_type.get();
    localVideoData.jdField_h_of_type_JavaLangString = paramTextFeed.user_info.anchor_name.get().toStringUtf8();
    localVideoData.jdField_c_of_type_Long = paramTextFeed.user_info.uid.get();
    localVideoData.jdField_d_of_type_Long = paramTextFeed.user_info.explicit_uid.get();
    localVideoData.jdField_g_of_type_Int = paramTextFeed.user_info.id_type.get();
    localVideoData.i = paramTextFeed.user_info.head_img_url.get().toStringUtf8();
    localVideoData.jdField_f_of_type_JavaLangString = paramTextFeed.user_info.head_img_url.get().toStringUtf8();
    localVideoData.jdField_e_of_type_Int = paramTextFeed.user_info.age.get();
    localVideoData.jdField_f_of_type_Int = paramTextFeed.user_info.user_gender.get();
    localVideoData.jdField_g_of_type_Long = paramTextFeed.user_info.uid.get();
    localVideoData.jdField_h_of_type_Long = paramTextFeed.user_info.explicit_uid.get();
    localVideoData.jdField_h_of_type_Int = paramTextFeed.user_info.id_type.get();
    boolean bool1;
    Iterator localIterator;
    if (paramTextFeed.is_listen.get() != 0)
    {
      bool1 = true;
      localVideoData.jdField_a_of_type_Boolean = bool1;
      bool1 = bool2;
      if (paramTextFeed.is_like.get() != 0) {
        bool1 = true;
      }
      localVideoData.jdField_b_of_type_Boolean = bool1;
      localVideoData.jdField_b_of_type_Int = paramTextFeed.like_num.get();
      localVideoData.jdField_f_of_type_JavaLangString = paramTextFeed.user_info.head_img_url.get().toStringUtf8();
      localVideoData.jdField_d_of_type_Int = paramTextFeed.view_times.get();
      localVideoData.jdField_j_of_type_Int = 6;
      localVideoData.m = paramInt;
      localVideoData.jdField_j_of_type_JavaLangString = "";
      localIterator = paramTextFeed.rpt_msg_rich_title.get().iterator();
    }
    for (;;)
    {
      if (!localIterator.hasNext()) {
        break label543;
      }
      FeedsProtocol.RichTitleElement localRichTitleElement = (FeedsProtocol.RichTitleElement)localIterator.next();
      if (localRichTitleElement.type.get() == 1)
      {
        localVideoData.jdField_j_of_type_JavaLangString += localRichTitleElement.text.get().toStringUtf8();
        continue;
        bool1 = false;
        break;
      }
      if (localRichTitleElement.type.get() == 2) {
        new StringBuilder().append("#").append(localRichTitleElement.text.get().toStringUtf8()).append("#").toString();
      }
    }
    label543:
    if (paramTextFeed.lbs_info != null)
    {
      paramTextFeed = (FeedsProtocol.LbsInfo)paramTextFeed.lbs_info.get();
      localVideoData.jdField_a_of_type_ComTencentMobileqqNearbyNowModelLocationInfo = new LocationInfo();
      localVideoData.jdField_a_of_type_ComTencentMobileqqNearbyNowModelLocationInfo.init(paramTextFeed.lng.get().toStringUtf8(), paramTextFeed.lat.get().toStringUtf8(), paramTextFeed.city.get().toStringUtf8(), paramTextFeed.name.get().toStringUtf8());
    }
    for (;;)
    {
      paramArrayList.add(avdd.a(paramList, localVideoData));
      return;
      localVideoData.jdField_a_of_type_ComTencentMobileqqNearbyNowModelLocationInfo = new LocationInfo();
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public ArrayList<VideoData> a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean) {}
  }
  
  public abstract void a(Bundle paramBundle);
  
  public void a(avco paramavco)
  {
    this.jdField_a_of_type_Avco = paramavco;
  }
  
  public void a(String paramString1, String paramString2) {}
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avcn
 * JD-Core Version:    0.7.0.1
 */