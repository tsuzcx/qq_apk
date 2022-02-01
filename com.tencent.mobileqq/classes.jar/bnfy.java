import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import dov.com.qq.im.ae.view.AEDownLoadingView;

public class bnfy
  extends RecyclerView.ViewHolder
{
  private Context jdField_a_of_type_AndroidContentContext;
  View jdField_a_of_type_AndroidViewView;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  AEDownLoadingView jdField_a_of_type_DovComQqImAeViewAEDownLoadingView;
  public View b;
  ImageView b;
  ImageView c;
  ImageView d;
  ImageView e;
  
  public bnfy(View paramView, Context paramContext)
  {
    super(paramView);
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131378878));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131365833));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131365829));
    this.c = ((ImageView)paramView.findViewById(2131370456));
    this.d = ((ImageView)paramView.findViewById(2131370457));
    this.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView = ((AEDownLoadingView)paramView.findViewById(2131373254));
    this.e = ((ImageView)paramView.findViewById(2131377316));
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131381345);
    this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131381346);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    int i = AIOUtils.dp2px(6.0F, this.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView.getResources());
    int j = AIOUtils.dp2px(2.0F, this.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView.getResources());
    int k = AIOUtils.dp2px(16.0F, this.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView.getResources());
    this.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView.setBgCorner(k / 2);
    this.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView.setMinimumHeight(k);
    this.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView.setMinimumWidth(k);
    this.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView.setProgressSizeAndMode(i, j, false);
    this.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView.setBgColor(0);
    this.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView.setProgressColor(-1);
    this.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView.a(false);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(paramInt);
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(paramInt);
  }
  
  public void a(bnke parambnke)
  {
    if (TextUtils.isEmpty(parambnke.c)) {
      return;
    }
    UIUtils.setViewByURL(this.jdField_a_of_type_ComTencentImageURLImageView, parambnke.c, UIUtils.dip2px(this.jdField_a_of_type_ComTencentImageURLImageView.getContext(), 67.0F), UIUtils.dip2px(this.jdField_a_of_type_ComTencentImageURLImageView.getContext(), 67.0F), this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130837651), null);
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView.setVisibility(paramInt);
    this.c.setVisibility(paramInt);
    this.d.setVisibility(paramInt);
  }
  
  public void b(bnke parambnke)
  {
    if (parambnke.a())
    {
      a(8);
      b(8);
      return;
    }
    if (parambnke.jdField_e_of_type_Boolean)
    {
      a(8);
      b(8);
      return;
    }
    if (!NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_AndroidContentContext))
    {
      bnrh.d("AEMaterialWaterMarkViewHolder", "net work not available");
      a(0);
      b(8);
      return;
    }
    if (parambnke.f)
    {
      a(8);
      b(0);
      this.jdField_a_of_type_DovComQqImAeViewAEDownLoadingView.setProgress(parambnke.jdField_e_of_type_Int);
      return;
    }
    a(0);
    b(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnfy
 * JD-Core Version:    0.7.0.1
 */