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
import com.tencent.mobileqq.activity.aio.AIOUtils;
import dov.com.qq.im.ae.view.AEDownLoadingView;

public class blsv
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
  
  public blsv(View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131378584));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131377026));
    this.b = ((ImageView)paramView.findViewById(2131365761));
    this.c = ((ImageView)paramView.findViewById(2131379002));
    this.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView = ((AEDownLoadingView)paramView.findViewById(2131373044));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131380990));
  }
  
  private static int a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return 0;
    }
    return 8;
  }
  
  private void a(blvb paramblvb)
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.b.setVisibility(8);
    this.c.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
  }
  
  private void b(blvb paramblvb)
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    c(paramblvb);
    e(paramblvb);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(a(paramblvb.a));
  }
  
  private void c(blvb paramblvb)
  {
    if (paramblvb.a())
    {
      this.b.setVisibility(8);
      this.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView.setVisibility(8);
      return;
    }
    if (paramblvb.jdField_e_of_type_Boolean)
    {
      this.b.setVisibility(8);
      this.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView.setVisibility(8);
      return;
    }
    if (paramblvb.f)
    {
      this.b.setVisibility(8);
      this.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView.setVisibility(0);
      this.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView.setProgress(paramblvb.jdField_e_of_type_Int);
      return;
    }
    this.b.setVisibility(0);
    this.b.setImageResource(2130844474);
    this.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView.setVisibility(8);
  }
  
  private void d(blvb paramblvb)
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130844537);
    c(paramblvb);
    e(paramblvb);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(a(paramblvb.a));
  }
  
  private void e(blvb paramblvb)
  {
    if (paramblvb.a())
    {
      this.c.setVisibility(0);
      this.c.setImageResource(2130845854);
      return;
    }
    if (paramblvb.b())
    {
      this.c.setVisibility(0);
      this.c.setImageResource(paramblvb.a());
      return;
    }
    this.c.setVisibility(8);
  }
  
  private void f(blvb paramblvb)
  {
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      a(paramblvb);
      return;
    case 0: 
      a(paramblvb);
      return;
    case 1: 
      b(paramblvb);
      g(paramblvb);
      return;
    }
    d(paramblvb);
    g(paramblvb);
  }
  
  private void g(blvb paramblvb)
  {
    if (TextUtils.isEmpty(paramblvb.c)) {
      return;
    }
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    int i = AIOUtils.dp2px(60.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    Drawable localDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130844473);
    localURLDrawableOptions.mRequestWidth = i;
    localURLDrawableOptions.mRequestHeight = i;
    localURLDrawableOptions.mFailedDrawable = localDrawable;
    localURLDrawableOptions.mLoadingDrawable = localDrawable;
    localURLDrawableOptions.mRetryCount = 3;
    paramblvb = URLDrawable.getDrawable(paramblvb.c, localURLDrawableOptions);
    if (paramblvb.getStatus() == 2) {
      paramblvb.restartDownload();
    }
    this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(paramblvb);
  }
  
  public void a(int paramInt, blvb paramblvb)
  {
    this.jdField_a_of_type_Int = paramInt;
    f(paramblvb);
  }
  
  public void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    int i = AIOUtils.dp2px(6.0F, paramContext.getResources());
    int j = AIOUtils.dp2px(2.0F, paramContext.getResources());
    int k = AIOUtils.dp2px(16.0F, paramContext.getResources());
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
 * Qualified Name:     blsv
 * JD-Core Version:    0.7.0.1
 */