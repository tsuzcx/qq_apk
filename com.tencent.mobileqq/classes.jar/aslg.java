import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Handler;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.gamecenter.anim.FullPopAnimWithLOLLIPOP.5;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData;
import com.tencent.mobileqq.gamecenter.data.FullPopData;
import com.tencent.mobileqq.gamecenter.view.FullPopVideoView;
import cooperation.qwallet.plugin.QWalletPicHelper;
import java.io.File;

public class aslg
  extends askx
  implements asnp
{
  private int jdField_a_of_type_Int;
  @SuppressLint({"HandlerLeak"})
  private Handler jdField_a_of_type_AndroidOsHandler = new aslh(this);
  private asmd jdField_a_of_type_Asmd;
  private int b;
  private int c;
  private int d;
  
  public aslg(Context paramContext, FullPopData paramFullPopData, String paramString1, String paramString2, boolean paramBoolean)
  {
    super(paramContext, paramFullPopData, paramString1, paramString2, paramBoolean);
    this.jdField_c_of_type_Int = 200;
    this.jdField_d_of_type_Int = 10;
  }
  
  private void a(FullPopData paramFullPopData, FullPopVideoView paramFullPopVideoView)
  {
    paramFullPopData = asnh.a(paramFullPopData.resPath, "video.mp4");
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
      int i = azkz.e(this.jdField_a_of_type_AndroidContentContext);
      Object localObject1 = asnh.a(this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFullPopData.resPath, "line.png", i, 0);
      Object localObject2 = QWalletPicHelper.getDrawableForWallet(asnh.a(this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFullPopData.resPath, "box.png").getPath(), null);
      this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject1);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject1);
      localObject1 = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidWidgetRelativeLayout, "scaleY", new float[] { 0.0F, 1.0F });
      ((ObjectAnimator)localObject1).setDuration(500L);
      localObject2 = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidWidgetRelativeLayout, "alpha", new float[] { 0.0F, 1.0F });
      ((ObjectAnimator)localObject2).setDuration(500L);
      a(this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFullPopData, this.jdField_a_of_type_ComTencentMobileqqGamecenterViewFullPopVideoView);
      ((ObjectAnimator)localObject2).addListener(new asli(this));
      ((ObjectAnimator)localObject1).start();
      ((ObjectAnimator)localObject2).start();
    }
  }
  
  @SuppressLint({"NewApi"})
  private void f()
  {
    int i = this.jdField_a_of_type_AndroidWidgetRelativeLayout.getTop() + aepi.a(4.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    int j = this.jdField_a_of_type_AndroidWidgetRelativeLayout.getBottom() - aepi.a(4.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    this.jdField_a_of_type_Asmd = new asmd(i, j, this.jdField_a_of_type_AndroidWidgetRelativeLayout.getLeft(), this.jdField_a_of_type_AndroidWidgetRelativeLayout.getRight());
    this.jdField_a_of_type_ComTencentMobileqqGamecenterViewFullPopVideoView.setOutlineProvider(this.jdField_a_of_type_Asmd);
    this.jdField_a_of_type_ComTencentMobileqqGamecenterViewFullPopVideoView.setClipToOutline(true);
    this.jdField_a_of_type_Int = ((int)(i * 1.0F / this.jdField_c_of_type_Int * this.jdField_d_of_type_Int));
    this.jdField_b_of_type_Int = ((int)((this.jdField_a_of_type_AndroidWidgetFrameLayout.getBottom() - j) * 1.0F / this.jdField_c_of_type_Int * this.jdField_d_of_type_Int));
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(6, 1100L);
    this.jdField_a_of_type_ComTencentMobileqqGamecenterViewFullPopVideoView.setListener(this);
    this.jdField_a_of_type_ComTencentMobileqqGamecenterViewFullPopVideoView.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqGamecenterViewFullPopVideoView.b();
    asnm.a(System.currentTimeMillis());
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(7, 4000L);
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_Asmd != null)
    {
      asmd localasmd = this.jdField_a_of_type_Asmd;
      localasmd.jdField_a_of_type_Int -= this.jdField_a_of_type_Int;
      localasmd = this.jdField_a_of_type_Asmd;
      localasmd.jdField_b_of_type_Int += this.jdField_b_of_type_Int;
      if (Build.VERSION.SDK_INT >= 21)
      {
        this.jdField_a_of_type_ComTencentMobileqqGamecenterViewFullPopVideoView.setOutlineProvider(this.jdField_a_of_type_Asmd);
        this.jdField_a_of_type_ComTencentMobileqqGamecenterViewFullPopVideoView.setClipToOutline(true);
      }
      if (this.jdField_a_of_type_Asmd.jdField_a_of_type_Int <= 0) {
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(3);
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(3, 5L);
  }
  
  private void h()
  {
    this.jdField_b_of_type_Boolean = true;
    this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_d_of_type_AndroidWidgetImageView.bringToFront();
    this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(new aslj(this));
  }
  
  @SuppressLint({"NewApi"})
  private void i()
  {
    if (this.jdField_a_of_type_Asmd != null)
    {
      asmd localasmd = this.jdField_a_of_type_Asmd;
      localasmd.jdField_a_of_type_Int += this.jdField_a_of_type_Int;
      localasmd = this.jdField_a_of_type_Asmd;
      localasmd.jdField_b_of_type_Int -= this.jdField_b_of_type_Int;
      this.jdField_a_of_type_ComTencentMobileqqGamecenterViewFullPopVideoView.setOutlineProvider(this.jdField_a_of_type_Asmd);
      this.jdField_a_of_type_ComTencentMobileqqGamecenterViewFullPopVideoView.setClipToOutline(true);
      if (this.jdField_a_of_type_Asmd.jdField_a_of_type_Int > this.jdField_a_of_type_Asmd.jdField_b_of_type_Int)
      {
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(4);
        this.jdField_a_of_type_ComTencentMobileqqGamecenterViewFullPopVideoView.c();
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(4, 5L);
  }
  
  private void j()
  {
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidWidgetRelativeLayout, "alpha", new float[] { 1.0F, 0.0F });
    localObjectAnimator.setDuration(100L);
    localObjectAnimator.start();
    localObjectAnimator.addListener(new aslk(this));
  }
  
  public void a()
  {
    super.a();
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
    ThreadManagerV2.getUIHandlerV2().post(new FullPopAnimWithLOLLIPOP.5(this));
    a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aslg
 * JD-Core Version:    0.7.0.1
 */