import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.now.model.VideoData;
import com.tencent.mobileqq.nearby.now.view.MagazinePlayerView.1;
import com.tencent.qphone.base.util.QLog;

public class atje
  extends atkm
{
  public atgg a;
  public VideoData a;
  private String b = "MagazinePlayerView";
  private long d;
  
  public atje(Context paramContext, atgg paramatgg, QQAppInterface paramQQAppInterface)
  {
    super(paramContext, paramQQAppInterface);
    this.jdField_a_of_type_Atgg = paramatgg;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData == null)
    {
      QLog.w(this.b, 2, "pasue mShortVideoInfo is null!!");
      return;
    }
    super.a();
  }
  
  public void a(RelativeLayout paramRelativeLayout, VideoData paramVideoData, atjf paramatjf)
  {
    if (QLog.isColorLevel()) {
      QLog.i(this.b, 2, "play() called with: rootView = [" + paramRelativeLayout + "], videoData = [" + paramVideoData + "]");
    }
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData = paramVideoData;
    this.jdField_a_of_type_Atjf = paramatjf;
    if (paramVideoData.a == 1)
    {
      a(paramRelativeLayout);
      this.d = 0L;
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      d();
      atiu.a().a(this.jdField_a_of_type_AndroidWidgetImageView, paramVideoData.c, new ColorDrawable(0), new ColorDrawable(0), null);
      this.jdField_a_of_type_AndroidOsHandler.post(new MagazinePlayerView.1(this));
      return;
    }
    super.a(paramRelativeLayout, paramVideoData, paramatjf);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData == null) {}
    while (this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.a == 1) {
      return;
    }
    if (this.jdField_a_of_type_Atgg != null) {
      this.jdField_a_of_type_Atgg.a();
    }
    super.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atje
 * JD-Core Version:    0.7.0.1
 */