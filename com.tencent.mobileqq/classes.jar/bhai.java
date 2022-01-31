import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import dov.com.qq.im.AECamera.View.AEDownLoadingView;

public class bhai
  extends RecyclerView.ViewHolder
{
  private int jdField_a_of_type_Int = 0;
  private Context jdField_a_of_type_AndroidContentContext;
  public ImageView a;
  public RelativeLayout a;
  public URLImageView a;
  public AEDownLoadingView a;
  public ImageView b;
  public ImageView c;
  
  public bhai(View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131311427));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131310031));
    this.b = ((ImageView)paramView.findViewById(2131299795));
    this.c = ((ImageView)paramView.findViewById(2131311803));
    this.jdField_a_of_type_DovComQqImAECameraViewAEDownLoadingView = ((AEDownLoadingView)paramView.findViewById(2131306333));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131313523));
  }
  
  private static int a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return 0;
    }
    return 8;
  }
  
  private void a(bgya parambgya)
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.b.setVisibility(8);
    this.c.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
  }
  
  private void b(bgya parambgya)
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    c(parambgya);
    e(parambgya);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(a(parambgya.a));
  }
  
  private void c(bgya parambgya)
  {
    if (parambgya.a())
    {
      this.b.setVisibility(8);
      this.jdField_a_of_type_DovComQqImAECameraViewAEDownLoadingView.setVisibility(8);
      return;
    }
    if (parambgya.jdField_d_of_type_Boolean)
    {
      this.b.setVisibility(8);
      this.jdField_a_of_type_DovComQqImAECameraViewAEDownLoadingView.setVisibility(8);
      return;
    }
    if (parambgya.e)
    {
      this.b.setVisibility(8);
      this.jdField_a_of_type_DovComQqImAECameraViewAEDownLoadingView.setVisibility(0);
      this.jdField_a_of_type_DovComQqImAECameraViewAEDownLoadingView.setProgress(parambgya.jdField_d_of_type_Int);
      return;
    }
    this.b.setVisibility(0);
    this.b.setImageResource(2130843691);
    this.jdField_a_of_type_DovComQqImAECameraViewAEDownLoadingView.setVisibility(8);
  }
  
  private void d(bgya parambgya)
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843759);
    c(parambgya);
    e(parambgya);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(a(parambgya.a));
  }
  
  private void e(bgya parambgya)
  {
    if (parambgya.a())
    {
      this.c.setVisibility(0);
      this.c.setImageResource(2130845019);
      return;
    }
    if (parambgya.b())
    {
      this.c.setVisibility(0);
      this.c.setImageResource(parambgya.a());
      return;
    }
    this.c.setVisibility(8);
  }
  
  private void f(bgya parambgya)
  {
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      a(parambgya);
      return;
    case 0: 
      a(parambgya);
      return;
    case 1: 
      b(parambgya);
      g(parambgya);
      return;
    }
    d(parambgya);
    g(parambgya);
  }
  
  private void g(bgya parambgya)
  {
    if (TextUtils.isEmpty(parambgya.b)) {
      return;
    }
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    int i = aciy.a(60.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    Drawable localDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130843690);
    localURLDrawableOptions.mRequestWidth = i;
    localURLDrawableOptions.mRequestHeight = i;
    localURLDrawableOptions.mFailedDrawable = localDrawable;
    localURLDrawableOptions.mLoadingDrawable = localDrawable;
    localURLDrawableOptions.mRetryCount = 3;
    parambgya = URLDrawable.getDrawable(parambgya.b, localURLDrawableOptions);
    if (parambgya.getStatus() == 2) {
      parambgya.restartDownload();
    }
    this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(parambgya);
  }
  
  public void a(int paramInt, bgya parambgya)
  {
    this.jdField_a_of_type_Int = paramInt;
    f(parambgya);
  }
  
  public void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    int i = aciy.a(6.0F, paramContext.getResources());
    int j = aciy.a(2.0F, paramContext.getResources());
    int k = aciy.a(16.0F, paramContext.getResources());
    this.jdField_a_of_type_DovComQqImAECameraViewAEDownLoadingView.setBgCorner(k / 2);
    this.jdField_a_of_type_DovComQqImAECameraViewAEDownLoadingView.setMinimumHeight(k);
    this.jdField_a_of_type_DovComQqImAECameraViewAEDownLoadingView.setMinimumWidth(k);
    this.jdField_a_of_type_DovComQqImAECameraViewAEDownLoadingView.setProgressSizeAndMode(i, j, false);
    this.jdField_a_of_type_DovComQqImAECameraViewAEDownLoadingView.setBgColor(-1);
    this.jdField_a_of_type_DovComQqImAECameraViewAEDownLoadingView.setProgressColor(-16725252);
    this.jdField_a_of_type_DovComQqImAECameraViewAEDownLoadingView.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bhai
 * JD-Core Version:    0.7.0.1
 */