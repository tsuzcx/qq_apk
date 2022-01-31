import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.gamecenter.anim.FullPopAnimLowVersion.6;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData;
import com.tencent.mobileqq.gamecenter.data.FullPopData;
import com.tencent.mobileqq.gamecenter.view.FullPopVideoView;
import cooperation.qwallet.plugin.QWalletPicHelper;
import java.io.File;

public class aqqw
  extends aqqu
  implements aqsw
{
  @SuppressLint({"HandlerLeak"})
  private Handler a;
  
  public aqqw(Context paramContext, FullPopData paramFullPopData, String paramString1, String paramString2, boolean paramBoolean)
  {
    super(paramContext, paramFullPopData, paramString1, paramString2, paramBoolean);
    this.jdField_a_of_type_AndroidOsHandler = new aqqx(this);
  }
  
  private void a(FullPopData paramFullPopData, FullPopVideoView paramFullPopVideoView)
  {
    paramFullPopData = aqsp.a(paramFullPopData.resPath, "video.mp4");
    FeedsItemData localFeedsItemData = new FeedsItemData();
    localFeedsItemData.videoUrl = Uri.parse(paramFullPopData.getPath()).toString();
    this.jdField_a_of_type_ComTencentMobileqqGamecenterViewFullPopVideoView.a();
    paramFullPopVideoView.a(this.jdField_a_of_type_AndroidContentContext, localFeedsItemData.videoUrl);
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFullPopData != null)
    {
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.bringToFront();
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      int i = axli.e(this.jdField_a_of_type_AndroidContentContext);
      Object localObject1 = aqsp.a(this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFullPopData.resPath, "line.png", i, 0);
      Object localObject2 = QWalletPicHelper.getDrawableForWallet(aqsp.a(this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFullPopData.resPath, "box.png").getPath(), null);
      this.c.setImageDrawable((Drawable)localObject2);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject1);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject1);
      localObject1 = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidWidgetRelativeLayout, "scaleY", new float[] { 0.0F, 1.0F });
      ((ObjectAnimator)localObject1).setDuration(500L);
      localObject2 = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidWidgetRelativeLayout, "alpha", new float[] { 0.0F, 1.0F });
      ((ObjectAnimator)localObject2).setDuration(500L);
      a(this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFullPopData, this.jdField_a_of_type_ComTencentMobileqqGamecenterViewFullPopVideoView);
      ((ObjectAnimator)localObject2).addListener(new aqqy(this));
      ((ObjectAnimator)localObject1).start();
      ((ObjectAnimator)localObject2).start();
    }
  }
  
  private void f()
  {
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidWidgetRelativeLayout, "alpha", new float[] { 1.0F, 0.0F });
    localObjectAnimator.setDuration(100L);
    localObjectAnimator.start();
    localObjectAnimator.addListener(new aqqz(this));
  }
  
  @SuppressLint({"NewApi"})
  private void g()
  {
    ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, 1.0F, 0.0F, 1.0F, 1, 0.0F, 1, 0.3F);
    localScaleAnimation.setDuration(500L);
    localScaleAnimation.setAnimationListener(new aqra(this));
    this.jdField_a_of_type_ComTencentMobileqqGamecenterViewFullPopVideoView.startAnimation(localScaleAnimation);
    this.jdField_a_of_type_ComTencentMobileqqGamecenterViewFullPopVideoView.setListener(this);
    this.jdField_a_of_type_ComTencentMobileqqGamecenterViewFullPopVideoView.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqGamecenterViewFullPopVideoView.b();
    aqsu.a(System.currentTimeMillis());
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(7, 4000L);
  }
  
  private void h()
  {
    this.jdField_b_of_type_Boolean = true;
    this.d.setVisibility(0);
    this.d.bringToFront();
    this.d.setOnClickListener(new aqrb(this));
  }
  
  private void i()
  {
    this.d.setVisibility(8);
    ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, 1.0F, 1.0F, 0.0F, 1, 0.0F, 1, 0.3F);
    localScaleAnimation.setDuration(300L);
    localScaleAnimation.setAnimationListener(new aqrc(this));
    this.jdField_a_of_type_AndroidWidgetFrameLayout.startAnimation(localScaleAnimation);
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Boolean) {
      a();
    }
  }
  
  public void c() {}
  
  public void d()
  {
    ThreadManagerV2.getUIHandlerV2().post(new FullPopAnimLowVersion.6(this));
    a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqqw
 * JD-Core Version:    0.7.0.1
 */