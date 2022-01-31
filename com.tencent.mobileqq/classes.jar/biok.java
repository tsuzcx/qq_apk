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

public class biok
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
  
  public biok(View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131377240));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131375795));
    this.b = ((ImageView)paramView.findViewById(2131365362));
    this.c = ((ImageView)paramView.findViewById(2131377618));
    this.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView = ((AEDownLoadingView)paramView.findViewById(2131372030));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131379358));
  }
  
  private static int a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return 0;
    }
    return 8;
  }
  
  private void a(biqn parambiqn)
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.b.setVisibility(8);
    this.c.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
  }
  
  private void b(biqn parambiqn)
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    c(parambiqn);
    e(parambiqn);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(a(parambiqn.a));
  }
  
  private void c(biqn parambiqn)
  {
    if (parambiqn.a())
    {
      this.b.setVisibility(8);
      this.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView.setVisibility(8);
      return;
    }
    if (parambiqn.d)
    {
      this.b.setVisibility(8);
      this.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView.setVisibility(8);
      return;
    }
    if (parambiqn.jdField_e_of_type_Boolean)
    {
      this.b.setVisibility(8);
      this.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView.setVisibility(0);
      this.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView.setProgress(parambiqn.jdField_e_of_type_Int);
      return;
    }
    this.b.setVisibility(0);
    this.b.setImageResource(2130843772);
    this.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView.setVisibility(8);
  }
  
  private void d(biqn parambiqn)
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843838);
    c(parambiqn);
    e(parambiqn);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(a(parambiqn.a));
  }
  
  private void e(biqn parambiqn)
  {
    if (parambiqn.a())
    {
      this.c.setVisibility(0);
      this.c.setImageResource(2130845103);
      return;
    }
    if (parambiqn.b())
    {
      this.c.setVisibility(0);
      this.c.setImageResource(parambiqn.a());
      return;
    }
    this.c.setVisibility(8);
  }
  
  private void f(biqn parambiqn)
  {
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      a(parambiqn);
      return;
    case 0: 
      a(parambiqn);
      return;
    case 1: 
      b(parambiqn);
      g(parambiqn);
      return;
    }
    d(parambiqn);
    g(parambiqn);
  }
  
  private void g(biqn parambiqn)
  {
    if (TextUtils.isEmpty(parambiqn.c)) {
      return;
    }
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    int i = actn.a(60.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    Drawable localDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130843771);
    localURLDrawableOptions.mRequestWidth = i;
    localURLDrawableOptions.mRequestHeight = i;
    localURLDrawableOptions.mFailedDrawable = localDrawable;
    localURLDrawableOptions.mLoadingDrawable = localDrawable;
    localURLDrawableOptions.mRetryCount = 3;
    parambiqn = URLDrawable.getDrawable(parambiqn.c, localURLDrawableOptions);
    if (parambiqn.getStatus() == 2) {
      parambiqn.restartDownload();
    }
    this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(parambiqn);
  }
  
  public void a(int paramInt, biqn parambiqn)
  {
    this.jdField_a_of_type_Int = paramInt;
    f(parambiqn);
  }
  
  public void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    int i = actn.a(6.0F, paramContext.getResources());
    int j = actn.a(2.0F, paramContext.getResources());
    int k = actn.a(16.0F, paramContext.getResources());
    this.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView.setBgCorner(k / 2);
    this.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView.setMinimumHeight(k);
    this.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView.setMinimumWidth(k);
    this.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView.setProgressSizeAndMode(i, j, false);
    this.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView.setBgColor(-1);
    this.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView.setProgressColor(-16725252);
    this.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     biok
 * JD-Core Version:    0.7.0.1
 */