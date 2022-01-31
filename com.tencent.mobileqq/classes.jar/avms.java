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

public class avms
  implements Manager
{
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString;
  protected DecimalFormat a;
  private List<avmz> jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
  
  public avms(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaTextDecimalFormat = new DecimalFormat("#.##");
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private avnx a(ilive_feeds_read.FeedsInfo paramFeedsInfo)
  {
    if (paramFeedsInfo == null) {
      return null;
    }
    Object localObject1;
    if (paramFeedsInfo.feed_type.get() == 5)
    {
      localObject1 = new avnw();
      ((avnw)localObject1).jdField_a_of_type_JavaLangString = paramFeedsInfo.live_info.pic_url.get().toStringUtf8();
      ((avnw)localObject1).n = paramFeedsInfo.live_info.desc.get().toStringUtf8();
    }
    for (;;)
    {
      if (localObject1 != null)
      {
        ((avnx)localObject1).jdField_d_of_type_Int = paramFeedsInfo.feed_type.get();
        ((avnx)localObject1).e = String.valueOf(paramFeedsInfo.publish_info.uin.get());
        ((avnx)localObject1).c = paramFeedsInfo.feeds_id.get().toStringUtf8();
        ((avnx)localObject1).jdField_d_of_type_JavaLangString = String.valueOf(paramFeedsInfo.publish_info.url.get().toStringUtf8());
        ((avnx)localObject1).m = paramFeedsInfo.jump_url.get().toStringUtf8();
        boolean bool;
        label162:
        double d1;
        if (paramFeedsInfo.like.get() == 1)
        {
          bool = true;
          ((avnx)localObject1).jdField_a_of_type_Boolean = bool;
          ((avnx)localObject1).jdField_f_of_type_Int = paramFeedsInfo.like_info.like_number.get();
          ((avnx)localObject1).jdField_g_of_type_Int = paramFeedsInfo.comment_num.get();
          ((avnx)localObject1).jdField_a_of_type_Long = paramFeedsInfo.create_time.get();
          ((avnx)localObject1).jdField_f_of_type_JavaLangString = avnl.a(paramFeedsInfo.create_time.get() * 1000L);
          ((avnx)localObject1).h = paramFeedsInfo.lbs_info.lng.get().toStringUtf8();
          ((avnx)localObject1).i = paramFeedsInfo.lbs_info.lat.get().toStringUtf8();
          ((avnx)localObject1).j = paramFeedsInfo.lbs_info.city.get().toStringUtf8();
          ((avnx)localObject1).k = paramFeedsInfo.lbs_info.name.get().toStringUtf8();
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
            ((avnx)localObject1).l = (this.jdField_a_of_type_JavaTextDecimalFormat.format(d1) + "km");
          }
          label375:
          if (TextUtils.isEmpty(paramFeedsInfo.lbs_info.name.get().toStringUtf8())) {
            break label1141;
          }
        }
        label1093:
        label1141:
        for (((avnx)localObject1).jdField_g_of_type_JavaLangString = paramFeedsInfo.lbs_info.name.get().toStringUtf8();; ((avnx)localObject1).jdField_g_of_type_JavaLangString = paramFeedsInfo.lbs_info.city.get().toStringUtf8())
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
            avnv localavnv = new avnv();
            localavnv.jdField_a_of_type_Long = localComment.comment_id.get();
            localavnv.jdField_a_of_type_JavaLangString = localComment.publish_info.anchor_name.get().toStringUtf8();
            localavnv.jdField_b_of_type_JavaLangString = localComment.reply_info.anchor_name.get().toStringUtf8();
            localavnv.c = ((NowNearbyVideoCommentProto.CommentMsg)((NowNearbyVideoCommentProto.CommentMsgBody)localComment.content.get()).msgs.get().get(0)).msg.get().toStringUtf8();
            paramFeedsInfo.add(localavnv);
          }
          if ((paramFeedsInfo.feed_type.get() == 1) || (paramFeedsInfo.feed_type.get() == 3) || (paramFeedsInfo.feed_type.get() == 2))
          {
            localObject1 = new avoa();
            ((avoa)localObject1).jdField_a_of_type_JavaLangString = paramFeedsInfo.feed_info.pic_url.get().toStringUtf8();
            ((avoa)localObject1).jdField_b_of_type_Long = paramFeedsInfo.feed_info.video_time.get();
            ((avoa)localObject1).jdField_a_of_type_Int = paramFeedsInfo.feed_info.video_width.get();
            ((avoa)localObject1).jdField_b_of_type_Int = paramFeedsInfo.feed_info.video_hight.get();
            ((avoa)localObject1).n = paramFeedsInfo.feed_info.desc.get().toStringUtf8();
            ((avoa)localObject1).e = paramFeedsInfo.view_times.get();
            localObject1 = (avoa)auyu.a(paramFeedsInfo.topic_cfg.get(), (avnx)localObject1);
            break;
          }
          if (paramFeedsInfo.feed_type.get() == 4)
          {
            localObject1 = new avny();
            localObject2 = paramFeedsInfo.pic_info.infos.get();
            if (((List)localObject2).size() > 0)
            {
              localObject2 = (ilive_feeds_tmem.PicInfo)((List)localObject2).get(0);
              ((avny)localObject1).jdField_a_of_type_JavaLangString = ((ilive_feeds_tmem.PicInfo)localObject2).url.get().toStringUtf8();
              ((avny)localObject1).jdField_a_of_type_Int = ((ilive_feeds_tmem.PicInfo)localObject2).width.get();
              ((avny)localObject1).jdField_b_of_type_Int = ((ilive_feeds_tmem.PicInfo)localObject2).hight.get();
            }
            ((avny)localObject1).n = paramFeedsInfo.pic_info.desc.get().toStringUtf8();
            localObject1 = (avny)auyu.a(paramFeedsInfo.topic_cfg.get(), (avnx)localObject1);
            break;
          }
          if (paramFeedsInfo.feed_type.get() == 6)
          {
            localObject1 = new avnu();
            ((avnu)localObject1).jdField_b_of_type_JavaLangString = paramFeedsInfo.chang_info.pic_url.get().toStringUtf8();
            ((avnu)localObject1).jdField_a_of_type_Int = paramFeedsInfo.chang_info.width.get();
            ((avnu)localObject1).jdField_b_of_type_Int = paramFeedsInfo.chang_info.hight.get();
            if (paramFeedsInfo.chang_info.chang.size() > 0) {
              ((avnu)localObject1).jdField_a_of_type_JavaLangString = ((ilive_feeds_tmem.Chang)paramFeedsInfo.chang_info.chang.get(0)).id.get().toStringUtf8();
            }
            ((avnu)localObject1).n = paramFeedsInfo.chang_info.desc.get().toStringUtf8();
            ((avnu)localObject1).e = paramFeedsInfo.view_times.get();
            ((avnu)localObject1).c = paramFeedsInfo.chang_info.chang.size();
            break;
          }
          if (paramFeedsInfo.feed_type.get() != 10) {
            break label1171;
          }
          localObject1 = new avob();
          ((avob)localObject1).n = paramFeedsInfo.text_feed.text.get();
          localObject1 = (avob)auyu.a(paramFeedsInfo.topic_cfg.get(), (avnx)localObject1);
          break;
          bool = false;
          break label162;
          this.jdField_a_of_type_JavaTextDecimalFormat = new DecimalFormat("#");
          ((avnx)localObject1).l = (this.jdField_a_of_type_JavaTextDecimalFormat.format(d1) + "km");
          break label375;
        }
        ((avnx)localObject1).jdField_a_of_type_JavaUtilList = paramFeedsInfo;
      }
      label1168:
      return localObject1;
      label1171:
      localObject1 = null;
    }
  }
  
  private List<avnx> a(List<ilive_feeds_read.FeedsInfo> paramList)
  {
    if (paramList == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      avnx localavnx = a((ilive_feeds_read.FeedsInfo)paramList.next());
      if (localavnx != null)
      {
        a(localavnx);
        localArrayList.add(localavnx);
      }
    }
    return localArrayList;
  }
  
  private void a(avnx paramavnx)
  {
    if ((paramavnx == null) || (TextUtils.isEmpty(paramavnx.n))) {
      return;
    }
    Matcher localMatcher = Pattern.compile("\\[:([^(:\\])]+):\\]").matcher(paramavnx.n);
    StringBuffer localStringBuffer = new StringBuffer();
    while (localMatcher.find()) {
      localMatcher.appendReplacement(localStringBuffer, "");
    }
    localMatcher.appendTail(localStringBuffer);
    paramavnx.n = localStringBuffer.toString();
  }
  
  public void a()
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      c(this.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void a(avmz paramavmz)
  {
    try
    {
      this.jdField_a_of_type_JavaUtilList.add(paramavmz);
      return;
    }
    finally
    {
      paramavmz = finally;
      throw paramavmz;
    }
  }
  
  public void a(String paramString)
  {
    avna.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, new avmt(this, paramString));
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
  
  public void a(String paramString, long paramLong, int paramInt1, int paramInt2, int paramInt3, avmy paramavmy)
  {
    avna.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, paramLong, paramInt1, paramInt2, paramInt3, new avmw(this, paramavmy));
  }
  
  public void a(String paramString, long paramLong, int paramInt, avmx paramavmx)
  {
    if (paramInt == 6) {
      paramInt = 10;
    }
    for (;;)
    {
      avna.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, paramLong, paramInt, new avmv(this, paramavmx));
      return;
    }
  }
  
  public void b(avmz paramavmz)
  {
    try
    {
      this.jdField_a_of_type_JavaUtilList.remove(paramavmz);
      return;
    }
    finally
    {
      paramavmz = finally;
      throw paramavmz;
    }
  }
  
  public void b(String paramString)
  {
    avna.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, new avmu(this, paramString));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avms
 * JD-Core Version:    0.7.0.1
 */