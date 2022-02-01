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

public class booo
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
  
  public booo(View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131378821));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131377276));
    this.b = ((ImageView)paramView.findViewById(2131365729));
    this.c = ((ImageView)paramView.findViewById(2131379233));
    this.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView = ((AEDownLoadingView)paramView.findViewById(2131373074));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131381272));
  }
  
  private static int a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return 0;
    }
    return 8;
  }
  
  private void a(boqu paramboqu)
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.b.setVisibility(8);
    this.c.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
  }
  
  private void b(boqu paramboqu)
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    c(paramboqu);
    e(paramboqu);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(a(paramboqu.a));
  }
  
  private void c(boqu paramboqu)
  {
    if (paramboqu.a())
    {
      this.b.setVisibility(8);
      this.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView.setVisibility(8);
      return;
    }
    if (paramboqu.jdField_e_of_type_Boolean)
    {
      this.b.setVisibility(8);
      this.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView.setVisibility(8);
      return;
    }
    if (paramboqu.f)
    {
      this.b.setVisibility(8);
      this.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView.setVisibility(0);
      this.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView.setProgress(paramboqu.jdField_e_of_type_Int);
      return;
    }
    this.b.setVisibility(0);
    this.b.setImageResource(2130844598);
    this.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView.setVisibility(8);
  }
  
  private void d(boqu paramboqu)
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130844661);
    c(paramboqu);
    e(paramboqu);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(a(paramboqu.a));
  }
  
  private void e(boqu paramboqu)
  {
    if (paramboqu.a())
    {
      this.c.setVisibility(0);
      this.c.setImageResource(2130845954);
      return;
    }
    if (paramboqu.b())
    {
      this.c.setVisibility(0);
      this.c.setImageResource(paramboqu.a());
      return;
    }
    this.c.setVisibility(8);
  }
  
  private void f(boqu paramboqu)
  {
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      a(paramboqu);
      return;
    case 0: 
      a(paramboqu);
      return;
    case 1: 
      b(paramboqu);
      g(paramboqu);
      return;
    }
    d(paramboqu);
    g(paramboqu);
  }
  
  private void g(boqu paramboqu)
  {
    if (TextUtils.isEmpty(paramboqu.c)) {
      return;
    }
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    int i = agej.a(60.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    Drawable localDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130844597);
    localURLDrawableOptions.mRequestWidth = i;
    localURLDrawableOptions.mRequestHeight = i;
    localURLDrawableOptions.mFailedDrawable = localDrawable;
    localURLDrawableOptions.mLoadingDrawable = localDrawable;
    localURLDrawableOptions.mRetryCount = 3;
    paramboqu = URLDrawable.getDrawable(paramboqu.c, localURLDrawableOptions);
    if (paramboqu.getStatus() == 2) {
      paramboqu.restartDownload();
    }
    this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(paramboqu);
  }
  
  public void a(int paramInt, boqu paramboqu)
  {
    this.jdField_a_of_type_Int = paramInt;
    f(paramboqu);
  }
  
  public void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    int i = agej.a(6.0F, paramContext.getResources());
    int j = agej.a(2.0F, paramContext.getResources());
    int k = agej.a(16.0F, paramContext.getResources());
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
 * Qualified Name:     booo
 * JD-Core Version:    0.7.0.1
 */