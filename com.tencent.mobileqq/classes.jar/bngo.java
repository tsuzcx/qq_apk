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

public class bngo
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
  
  public bngo(View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131378878));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131377299));
    this.b = ((ImageView)paramView.findViewById(2131365859));
    this.c = ((ImageView)paramView.findViewById(2131379296));
    this.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView = ((AEDownLoadingView)paramView.findViewById(2131373254));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131381345));
  }
  
  private static int a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return 0;
    }
    return 8;
  }
  
  private void a(bnke parambnke)
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.b.setVisibility(8);
    this.c.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
  }
  
  private void b(bnke parambnke)
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    c(parambnke);
    e(parambnke);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(a(parambnke.a));
  }
  
  private void c(bnke parambnke)
  {
    if (parambnke.a())
    {
      this.b.setVisibility(8);
      this.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView.setVisibility(8);
      return;
    }
    if (parambnke.jdField_e_of_type_Boolean)
    {
      this.b.setVisibility(8);
      this.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView.setVisibility(8);
      return;
    }
    if (parambnke.f)
    {
      this.b.setVisibility(8);
      this.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView.setVisibility(0);
      this.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView.setProgress(parambnke.jdField_e_of_type_Int);
      return;
    }
    this.b.setVisibility(0);
    this.b.setImageResource(2130844541);
    this.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView.setVisibility(8);
  }
  
  private void d(bnke parambnke)
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130844603);
    c(parambnke);
    e(parambnke);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(a(parambnke.a));
  }
  
  private void e(bnke parambnke)
  {
    if (parambnke.a())
    {
      this.c.setVisibility(0);
      this.c.setImageResource(2130845942);
      return;
    }
    if (parambnke.b())
    {
      this.c.setVisibility(0);
      this.c.setImageResource(parambnke.a());
      return;
    }
    this.c.setVisibility(8);
  }
  
  private void f(bnke parambnke)
  {
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      a(parambnke);
      return;
    case 0: 
      a(parambnke);
      return;
    case 1: 
      b(parambnke);
      g(parambnke);
      return;
    }
    d(parambnke);
    g(parambnke);
  }
  
  private void g(bnke parambnke)
  {
    if (TextUtils.isEmpty(parambnke.c)) {
      return;
    }
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    int i = AIOUtils.dp2px(60.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    Drawable localDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130844540);
    localURLDrawableOptions.mRequestWidth = i;
    localURLDrawableOptions.mRequestHeight = i;
    localURLDrawableOptions.mFailedDrawable = localDrawable;
    localURLDrawableOptions.mLoadingDrawable = localDrawable;
    localURLDrawableOptions.mRetryCount = 3;
    parambnke = URLDrawable.getDrawable(parambnke.c, localURLDrawableOptions);
    if (parambnke.getStatus() == 2) {
      parambnke.restartDownload();
    }
    this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(parambnke);
  }
  
  public void a(int paramInt, bnke parambnke)
  {
    this.jdField_a_of_type_Int = paramInt;
    f(parambnke);
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
 * Qualified Name:     bngo
 * JD-Core Version:    0.7.0.1
 */