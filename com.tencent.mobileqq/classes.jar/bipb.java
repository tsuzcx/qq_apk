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

public class bipb
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
  
  public bipb(View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131377242));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131375797));
    this.b = ((ImageView)paramView.findViewById(2131365361));
    this.c = ((ImageView)paramView.findViewById(2131377618));
    this.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView = ((AEDownLoadingView)paramView.findViewById(2131372030));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131379363));
  }
  
  private static int a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return 0;
    }
    return 8;
  }
  
  private void a(bire parambire)
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.b.setVisibility(8);
    this.c.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
  }
  
  private void b(bire parambire)
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    c(parambire);
    e(parambire);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(a(parambire.a));
  }
  
  private void c(bire parambire)
  {
    if (parambire.a())
    {
      this.b.setVisibility(8);
      this.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView.setVisibility(8);
      return;
    }
    if (parambire.d)
    {
      this.b.setVisibility(8);
      this.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView.setVisibility(8);
      return;
    }
    if (parambire.jdField_e_of_type_Boolean)
    {
      this.b.setVisibility(8);
      this.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView.setVisibility(0);
      this.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView.setProgress(parambire.jdField_e_of_type_Int);
      return;
    }
    this.b.setVisibility(0);
    this.b.setImageResource(2130843773);
    this.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView.setVisibility(8);
  }
  
  private void d(bire parambire)
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843839);
    c(parambire);
    e(parambire);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(a(parambire.a));
  }
  
  private void e(bire parambire)
  {
    if (parambire.a())
    {
      this.c.setVisibility(0);
      this.c.setImageResource(2130845104);
      return;
    }
    if (parambire.b())
    {
      this.c.setVisibility(0);
      this.c.setImageResource(parambire.a());
      return;
    }
    this.c.setVisibility(8);
  }
  
  private void f(bire parambire)
  {
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      a(parambire);
      return;
    case 0: 
      a(parambire);
      return;
    case 1: 
      b(parambire);
      g(parambire);
      return;
    }
    d(parambire);
    g(parambire);
  }
  
  private void g(bire parambire)
  {
    if (TextUtils.isEmpty(parambire.c)) {
      return;
    }
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    int i = actj.a(60.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    Drawable localDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130843772);
    localURLDrawableOptions.mRequestWidth = i;
    localURLDrawableOptions.mRequestHeight = i;
    localURLDrawableOptions.mFailedDrawable = localDrawable;
    localURLDrawableOptions.mLoadingDrawable = localDrawable;
    localURLDrawableOptions.mRetryCount = 3;
    parambire = URLDrawable.getDrawable(parambire.c, localURLDrawableOptions);
    if (parambire.getStatus() == 2) {
      parambire.restartDownload();
    }
    this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(parambire);
  }
  
  public void a(int paramInt, bire parambire)
  {
    this.jdField_a_of_type_Int = paramInt;
    f(parambire);
  }
  
  public void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    int i = actj.a(6.0F, paramContext.getResources());
    int j = actj.a(2.0F, paramContext.getResources());
    int k = actj.a(16.0F, paramContext.getResources());
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
 * Qualified Name:     bipb
 * JD-Core Version:    0.7.0.1
 */