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
import dov.com.qq.im.ae.view.AEDownLoadingView;

public class bktv
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
  
  public bktv(View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131377765));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131376294));
    this.b = ((ImageView)paramView.findViewById(2131365446));
    this.c = ((ImageView)paramView.findViewById(2131378160));
    this.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView = ((AEDownLoadingView)paramView.findViewById(2131372347));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131380077));
  }
  
  private static int a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return 0;
    }
    return 8;
  }
  
  private void a(bkvu parambkvu)
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.b.setVisibility(8);
    this.c.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
  }
  
  private void b(bkvu parambkvu)
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    c(parambkvu);
    e(parambkvu);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(a(parambkvu.a));
  }
  
  private void c(bkvu parambkvu)
  {
    if (parambkvu.a())
    {
      this.b.setVisibility(8);
      this.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView.setVisibility(8);
      return;
    }
    if (parambkvu.d)
    {
      this.b.setVisibility(8);
      this.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView.setVisibility(8);
      return;
    }
    if (parambkvu.jdField_e_of_type_Boolean)
    {
      this.b.setVisibility(8);
      this.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView.setVisibility(0);
      this.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView.setProgress(parambkvu.jdField_e_of_type_Int);
      return;
    }
    this.b.setVisibility(0);
    this.b.setImageResource(2130844116);
    this.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView.setVisibility(8);
  }
  
  private void d(bkvu parambkvu)
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130844182);
    c(parambkvu);
    e(parambkvu);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(a(parambkvu.a));
  }
  
  private void e(bkvu parambkvu)
  {
    if (parambkvu.a())
    {
      this.c.setVisibility(0);
      this.c.setImageResource(2130845469);
      return;
    }
    if (parambkvu.b())
    {
      this.c.setVisibility(0);
      this.c.setImageResource(parambkvu.a());
      return;
    }
    this.c.setVisibility(8);
  }
  
  private void f(bkvu parambkvu)
  {
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      a(parambkvu);
      return;
    case 0: 
      a(parambkvu);
      return;
    case 1: 
      b(parambkvu);
      g(parambkvu);
      return;
    }
    d(parambkvu);
    g(parambkvu);
  }
  
  private void g(bkvu parambkvu)
  {
    if (TextUtils.isEmpty(parambkvu.c)) {
      return;
    }
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    int i = aekt.a(60.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    Drawable localDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130844115);
    localURLDrawableOptions.mRequestWidth = i;
    localURLDrawableOptions.mRequestHeight = i;
    localURLDrawableOptions.mFailedDrawable = localDrawable;
    localURLDrawableOptions.mLoadingDrawable = localDrawable;
    localURLDrawableOptions.mRetryCount = 3;
    parambkvu = URLDrawable.getDrawable(parambkvu.c, localURLDrawableOptions);
    if (parambkvu.getStatus() == 2) {
      parambkvu.restartDownload();
    }
    this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(parambkvu);
  }
  
  public void a(int paramInt, bkvu parambkvu)
  {
    this.jdField_a_of_type_Int = paramInt;
    f(parambkvu);
  }
  
  public void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    int i = aekt.a(6.0F, paramContext.getResources());
    int j = aekt.a(2.0F, paramContext.getResources());
    int k = aekt.a(16.0F, paramContext.getResources());
    this.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView.setBgCorner(k / 2);
    this.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView.setMinimumHeight(k);
    this.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView.setMinimumWidth(k);
    this.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView.setProgressSizeAndMode(i, j, false);
    this.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView.setBgColor(-1);
    this.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView.setProgressColor(-16725252);
    this.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bktv
 * JD-Core Version:    0.7.0.1
 */