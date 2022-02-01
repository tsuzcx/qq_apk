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

public class bnnd
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
  
  public bnnd(View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131378660));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131377136));
    this.b = ((ImageView)paramView.findViewById(2131365686));
    this.c = ((ImageView)paramView.findViewById(2131379069));
    this.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView = ((AEDownLoadingView)paramView.findViewById(2131372961));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131381100));
  }
  
  private static int a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return 0;
    }
    return 8;
  }
  
  private void a(bnpf parambnpf)
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.b.setVisibility(8);
    this.c.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
  }
  
  private void b(bnpf parambnpf)
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    c(parambnpf);
    e(parambnpf);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(a(parambnpf.a));
  }
  
  private void c(bnpf parambnpf)
  {
    if (parambnpf.a())
    {
      this.b.setVisibility(8);
      this.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView.setVisibility(8);
      return;
    }
    if (parambnpf.jdField_e_of_type_Boolean)
    {
      this.b.setVisibility(8);
      this.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView.setVisibility(8);
      return;
    }
    if (parambnpf.f)
    {
      this.b.setVisibility(8);
      this.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView.setVisibility(0);
      this.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView.setProgress(parambnpf.jdField_e_of_type_Int);
      return;
    }
    this.b.setVisibility(0);
    this.b.setImageResource(2130844584);
    this.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView.setVisibility(8);
  }
  
  private void d(bnpf parambnpf)
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130844647);
    c(parambnpf);
    e(parambnpf);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(a(parambnpf.a));
  }
  
  private void e(bnpf parambnpf)
  {
    if (parambnpf.a())
    {
      this.c.setVisibility(0);
      this.c.setImageResource(2130845939);
      return;
    }
    if (parambnpf.b())
    {
      this.c.setVisibility(0);
      this.c.setImageResource(parambnpf.a());
      return;
    }
    this.c.setVisibility(8);
  }
  
  private void f(bnpf parambnpf)
  {
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      a(parambnpf);
      return;
    case 0: 
      a(parambnpf);
      return;
    case 1: 
      b(parambnpf);
      g(parambnpf);
      return;
    }
    d(parambnpf);
    g(parambnpf);
  }
  
  private void g(bnpf parambnpf)
  {
    if (TextUtils.isEmpty(parambnpf.c)) {
      return;
    }
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    int i = afur.a(60.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    Drawable localDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130844583);
    localURLDrawableOptions.mRequestWidth = i;
    localURLDrawableOptions.mRequestHeight = i;
    localURLDrawableOptions.mFailedDrawable = localDrawable;
    localURLDrawableOptions.mLoadingDrawable = localDrawable;
    localURLDrawableOptions.mRetryCount = 3;
    parambnpf = URLDrawable.getDrawable(parambnpf.c, localURLDrawableOptions);
    if (parambnpf.getStatus() == 2) {
      parambnpf.restartDownload();
    }
    this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(parambnpf);
  }
  
  public void a(int paramInt, bnpf parambnpf)
  {
    this.jdField_a_of_type_Int = paramInt;
    f(parambnpf);
  }
  
  public void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    int i = afur.a(6.0F, paramContext.getResources());
    int j = afur.a(2.0F, paramContext.getResources());
    int k = afur.a(16.0F, paramContext.getResources());
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
 * Qualified Name:     bnnd
 * JD-Core Version:    0.7.0.1
 */