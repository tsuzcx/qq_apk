import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.nearby.profilecard.moment.NearbyMomentManager.10;
import com.tencent.mobileqq.nearby.profilecard.moment.NearbyMomentManager.5;
import com.tencent.mobileqq.nearby.profilecard.moment.NearbyMomentManager.6;
import com.tencent.mobileqq.nearby.profilecard.moment.NearbyMomentManager.7;
import com.tencent.mobileqq.nearby.profilecard.moment.NearbyMomentManager.8;
import com.tencent.mobileqq.nearby.profilecard.moment.NearbyMomentManager.9;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.pb.now.FeedsProtocol.LbsInfo;
import com.tencent.pb.now.NowNearbyVideoCommentProto.Comment;
import com.tencent.pb.now.NowNearbyVideoCommentProto.CommentMsg;
import com.tencent.pb.now.NowNearbyVideoCommentProto.CommentMsgBody;
import com.tencent.pb.now.NowNearbyVideoCommentProto.UserInfo;
import com.tencent.pb.now.ilive_feeds_read.FeedUserInfo;
import com.tencent.pb.now.ilive_feeds_read.FeedsInfo;
import com.tencent.pb.now.ilive_feeds_tmem.Chang;
import com.tencent.pb.now.ilive_feeds_tmem.ChangFeed;
import com.tencent.pb.now.ilive_feeds_tmem.FeedsTmemLike;
import com.tencent.pb.now.ilive_feeds_tmem.LiveFeed;
import com.tencent.pb.now.ilive_feeds_tmem.PicFeed;
import com.tencent.pb.now.ilive_feeds_tmem.PicInfo;
import com.tencent.pb.now.ilive_feeds_tmem.TextFeed;
import com.tencent.pb.now.ilive_feeds_tmem.VideoFeed;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.manager.Manager;
import mqq.os.MqqHandler;

public class ayks
  implements Manager
{
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString;
  protected DecimalFormat a;
  private List<aykz> jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
  
  public ayks(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaTextDecimalFormat = new DecimalFormat("#.##");
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private aylx a(ilive_feeds_read.FeedsInfo paramFeedsInfo)
  {
    if (paramFeedsInfo == null) {
      return null;
    }
    Object localObject1;
    if (paramFeedsInfo.feed_type.get() == 5)
    {
      localObject1 = new aylw();
      ((aylw)localObject1).jdField_a_of_type_JavaLangString = paramFeedsInfo.live_info.pic_url.get().toStringUtf8();
      ((aylw)localObject1).n = paramFeedsInfo.live_info.desc.get().toStringUtf8();
    }
    for (;;)
    {
      if (localObject1 != null)
      {
        ((aylx)localObject1).jdField_d_of_type_Int = paramFeedsInfo.feed_type.get();
        ((aylx)localObject1).e = String.valueOf(paramFeedsInfo.publish_info.uin.get());
        ((aylx)localObject1).c = paramFeedsInfo.feeds_id.get().toStringUtf8();
        ((aylx)localObject1).jdField_d_of_type_JavaLangString = String.valueOf(paramFeedsInfo.publish_info.url.get().toStringUtf8());
        ((aylx)localObject1).m = paramFeedsInfo.jump_url.get().toStringUtf8();
        boolean bool;
        label162:
        double d1;
        if (paramFeedsInfo.like.get() == 1)
        {
          bool = true;
          ((aylx)localObject1).jdField_a_of_type_Boolean = bool;
          ((aylx)localObject1).jdField_f_of_type_Int = paramFeedsInfo.like_info.like_number.get();
          ((aylx)localObject1).jdField_g_of_type_Int = paramFeedsInfo.comment_num.get();
          ((aylx)localObject1).jdField_a_of_type_Long = paramFeedsInfo.create_time.get();
          ((aylx)localObject1).jdField_f_of_type_JavaLangString = ayll.a(paramFeedsInfo.create_time.get() * 1000L);
          ((aylx)localObject1).h = paramFeedsInfo.lbs_info.lng.get().toStringUtf8();
          ((aylx)localObject1).i = paramFeedsInfo.lbs_info.lat.get().toStringUtf8();
          ((aylx)localObject1).j = paramFeedsInfo.lbs_info.city.get().toStringUtf8();
          ((aylx)localObject1).k = paramFeedsInfo.lbs_info.name.get().toStringUtf8();
          if (paramFeedsInfo.distance.has())
          {
            double d2 = paramFeedsInfo.distance.get();
            d1 = d2;
            if (d2 < 0.01D) {
              d1 = 0.01D;
            }
            if (d1 >= 100.0D) {
              break label1093;
            }
            ((aylx)localObject1).l = (this.jdField_a_of_type_JavaTextDecimalFormat.format(d1) + "km");
          }
          label375:
          if (TextUtils.isEmpty(paramFeedsInfo.lbs_info.name.get().toStringUtf8())) {
            break label1141;
          }
        }
        label1093:
        label1141:
        for (((aylx)localObject1).jdField_g_of_type_JavaLangString = paramFeedsInfo.lbs_info.name.get().toStringUtf8();; ((aylx)localObject1).jdField_g_of_type_JavaLangString = paramFeedsInfo.lbs_info.city.get().toStringUtf8())
        {
          Object localObject2 = paramFeedsInfo.comments.get();
          if (((List)localObject2).size() <= 0) {
            break label1168;
          }
          paramFeedsInfo = new ArrayList();
          localObject2 = ((List)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            NowNearbyVideoCommentProto.Comment localComment = (NowNearbyVideoCommentProto.Comment)((Iterator)localObject2).next();
            aylv localaylv = new aylv();
            localaylv.jdField_a_of_type_Long = localComment.comment_id.get();
            localaylv.jdField_a_of_type_JavaLangString = localComment.publish_info.anchor_name.get().toStringUtf8();
            localaylv.jdField_b_of_type_JavaLangString = localComment.reply_info.anchor_name.get().toStringUtf8();
            localaylv.c = ((NowNearbyVideoCommentProto.CommentMsg)((NowNearbyVideoCommentProto.CommentMsgBody)localComment.content.get()).msgs.get().get(0)).msg.get().toStringUtf8();
            paramFeedsInfo.add(localaylv);
          }
          if ((paramFeedsInfo.feed_type.get() == 1) || (paramFeedsInfo.feed_type.get() == 3) || (paramFeedsInfo.feed_type.get() == 2))
          {
            localObject1 = new ayma();
            ((ayma)localObject1).jdField_a_of_type_JavaLangString = paramFeedsInfo.feed_info.pic_url.get().toStringUtf8();
            ((ayma)localObject1).jdField_b_of_type_Long = paramFeedsInfo.feed_info.video_time.get();
            ((ayma)localObject1).jdField_a_of_type_Int = paramFeedsInfo.feed_info.video_width.get();
            ((ayma)localObject1).jdField_b_of_type_Int = paramFeedsInfo.feed_info.video_hight.get();
            ((ayma)localObject1).n = paramFeedsInfo.feed_info.desc.get().toStringUtf8();
            ((ayma)localObject1).e = paramFeedsInfo.view_times.get();
            localObject1 = (ayma)axwq.a(paramFeedsInfo.topic_cfg.get(), (aylx)localObject1);
            break;
          }
          if (paramFeedsInfo.feed_type.get() == 4)
          {
            localObject1 = new ayly();
            localObject2 = paramFeedsInfo.pic_info.infos.get();
            if (((List)localObject2).size() > 0)
            {
              localObject2 = (ilive_feeds_tmem.PicInfo)((List)localObject2).get(0);
              ((ayly)localObject1).jdField_a_of_type_JavaLangString = ((ilive_feeds_tmem.PicInfo)localObject2).url.get().toStringUtf8();
              ((ayly)localObject1).jdField_a_of_type_Int = ((ilive_feeds_tmem.PicInfo)localObject2).width.get();
              ((ayly)localObject1).jdField_b_of_type_Int = ((ilive_feeds_tmem.PicInfo)localObject2).hight.get();
            }
            ((ayly)localObject1).n = paramFeedsInfo.pic_info.desc.get().toStringUtf8();
            localObject1 = (ayly)axwq.a(paramFeedsInfo.topic_cfg.get(), (aylx)localObject1);
            break;
          }
          if (paramFeedsInfo.feed_type.get() == 6)
          {
            localObject1 = new aylu();
            ((aylu)localObject1).jdField_b_of_type_JavaLangString = paramFeedsInfo.chang_info.pic_url.get().toStringUtf8();
            ((aylu)localObject1).jdField_a_of_type_Int = paramFeedsInfo.chang_info.width.get();
            ((aylu)localObject1).jdField_b_of_type_Int = paramFeedsInfo.chang_info.hight.get();
            if (paramFeedsInfo.chang_info.chang.size() > 0) {
              ((aylu)localObject1).jdField_a_of_type_JavaLangString = ((ilive_feeds_tmem.Chang)paramFeedsInfo.chang_info.chang.get(0)).id.get().toStringUtf8();
            }
            ((aylu)localObject1).n = paramFeedsInfo.chang_info.desc.get().toStringUtf8();
            ((aylu)localObject1).e = paramFeedsInfo.view_times.get();
            ((aylu)localObject1).c = paramFeedsInfo.chang_info.chang.size();
            break;
          }
          if (paramFeedsInfo.feed_type.get() != 10) {
            break label1171;
          }
          localObject1 = new aymb();
          ((aymb)localObject1).n = paramFeedsInfo.text_feed.text.get();
          localObject1 = (aymb)axwq.a(paramFeedsInfo.topic_cfg.get(), (aylx)localObject1);
          break;
          bool = false;
          break label162;
          this.jdField_a_of_type_JavaTextDecimalFormat = new DecimalFormat("#");
          ((aylx)localObject1).l = (this.jdField_a_of_type_JavaTextDecimalFormat.format(d1) + "km");
          break label375;
        }
        ((aylx)localObject1).jdField_a_of_type_JavaUtilList = paramFeedsInfo;
      }
      label1168:
      return localObject1;
      label1171:
      localObject1 = null;
    }
  }
  
  private List<aylx> a(List<ilive_feeds_read.FeedsInfo> paramList)
  {
    if (paramList == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      aylx localaylx = a((ilive_feeds_read.FeedsInfo)paramList.next());
      if (localaylx != null)
      {
        a(localaylx);
        localArrayList.add(localaylx);
      }
    }
    return localArrayList;
  }
  
  private void a(aylx paramaylx)
  {
    if ((paramaylx == null) || (TextUtils.isEmpty(paramaylx.n))) {
      return;
    }
    Matcher localMatcher = Pattern.compile("\\[:([^(:\\])]+):\\]").matcher(paramaylx.n);
    StringBuffer localStringBuffer = new StringBuffer();
    while (localMatcher.find()) {
      localMatcher.appendReplacement(localStringBuffer, "");
    }
    localMatcher.appendTail(localStringBuffer);
    paramaylx.n = localStringBuffer.toString();
  }
  
  public void a()
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      c(this.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3, ayky paramayky)
  {
    ayla.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramLong1, paramLong2, paramInt1, paramInt2, paramInt3, new aykw(this, paramayky));
  }
  
  public void a(aykz paramaykz)
  {
    try
    {
      this.jdField_a_of_type_JavaUtilList.add(paramaykz);
      return;
    }
    finally
    {
      paramaykz = finally;
      throw paramaykz;
    }
  }
  
  public void a(String paramString)
  {
    ayla.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, new aykt(this, paramString));
  }
  
  public void a(String paramString, int paramInt)
  {
    try
    {
      ThreadManager.getUIHandler().post(new NearbyMomentManager.8(this, paramString, paramInt));
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void a(String paramString, long paramLong)
  {
    try
    {
      ThreadManager.getUIHandler().post(new NearbyMomentManager.7(this, paramString, paramLong));
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void a(String paramString, long paramLong, int paramInt, aykx paramaykx)
  {
    if (paramInt == 6) {
      paramInt = 10;
    }
    for (;;)
    {
      ayla.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, paramLong, paramInt, new aykv(this, paramaykx));
      return;
    }
  }
  
  public void b(aykz paramaykz)
  {
    try
    {
      this.jdField_a_of_type_JavaUtilList.remove(paramaykz);
      return;
    }
    finally
    {
      paramaykz = finally;
      throw paramaykz;
    }
  }
  
  public void b(String paramString)
  {
    ayla.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, new ayku(this, paramString));
  }
  
  public void b(String paramString, int paramInt)
  {
    try
    {
      ThreadManager.getUIHandler().post(new NearbyMomentManager.9(this, paramString, paramInt));
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void c(String paramString)
  {
    try
    {
      ThreadManager.getUIHandler().post(new NearbyMomentManager.5(this, paramString));
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void d(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void e(String paramString)
  {
    try
    {
      ThreadManager.getUIHandler().post(new NearbyMomentManager.6(this, paramString));
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void f(String paramString)
  {
    try
    {
      ThreadManager.getUIHandler().post(new NearbyMomentManager.10(this, paramString));
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void onDestroy()
  {
    try
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayks
 * JD-Core Version:    0.7.0.1
 */