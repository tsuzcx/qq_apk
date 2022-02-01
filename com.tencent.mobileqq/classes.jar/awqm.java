import android.net.Uri;
import android.os.Bundle;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.pb.now.FeedsProtocol.GetMediaDetailRsp;
import com.tencent.pb.now.FeedsProtocol.MediaInfo;
import com.tencent.pb.now.FeedsProtocol.PicFeedsInfo;
import com.tencent.pb.now.FeedsProtocol.ShortVideoInfo;
import com.tencent.pb.now.FeedsProtocol.TextFeed;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class awqm
  extends awpy
{
  private String a;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  
  public awqm()
  {
    this.jdField_a_of_type_JavaLangString = "PlayListDataModel";
  }
  
  private void a(FeedsProtocol.GetMediaDetailRsp paramGetMediaDetailRsp)
  {
    paramGetMediaDetailRsp = paramGetMediaDetailRsp.media_list.get().iterator();
    while (paramGetMediaDetailRsp.hasNext())
    {
      FeedsProtocol.MediaInfo localMediaInfo = (FeedsProtocol.MediaInfo)paramGetMediaDetailRsp.next();
      if ((localMediaInfo.type.get() != 1) && (localMediaInfo.type.get() != 2)) {
        if (localMediaInfo.type.get() == 3) {
          a(localMediaInfo.is_my_feeds.get(), localMediaInfo.topic_cfg.get(), (FeedsProtocol.ShortVideoInfo)localMediaInfo.short_video.get(), this.jdField_a_of_type_JavaUtilArrayList);
        } else if (localMediaInfo.type.get() == 5) {
          a(localMediaInfo.is_my_feeds.get(), localMediaInfo.topic_cfg.get(), (FeedsProtocol.PicFeedsInfo)localMediaInfo.pic_info.get(), this.jdField_a_of_type_JavaUtilArrayList);
        } else if (localMediaInfo.type.get() == 6) {
          a(localMediaInfo.is_my_feeds.get(), localMediaInfo.topic_cfg.get(), (FeedsProtocol.TextFeed)localMediaInfo.text_feed.get(), this.jdField_a_of_type_JavaUtilArrayList);
        }
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
    new awqu(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b(this.jdField_b_of_type_JavaLangString + "&start=" + this.jdField_b_of_type_Int + "&num=" + 10, new awqn(this));
  }
  
  public void a(Bundle paramBundle)
  {
    if ("1".equals(paramBundle.getString("isLocal"))) {}
    do
    {
      return;
      paramBundle = paramBundle.getString("raw_url");
      this.jdField_b_of_type_JavaLangString = Uri.parse(paramBundle).getQuery();
    } while (!QLog.isColorLevel());
    QLog.d(this.jdField_a_of_type_JavaLangString, 2, "PlayListDataModel, url=" + paramBundle);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awqm
 * JD-Core Version:    0.7.0.1
 */