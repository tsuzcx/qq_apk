import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData;

public class asmc
  extends asly
{
  private ImageView b;
  private TextView d;
  private TextView e;
  
  public asmc(Context paramContext, View paramView, ViewGroup paramViewGroup)
  {
    super(paramContext, paramView, paramViewGroup);
    paramContext = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559125, paramViewGroup, false);
    if (paramContext != null) {
      this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(paramContext);
    }
    this.b = ((ImageView)paramContext.findViewById(2131368140));
    this.d = ((TextView)paramContext.findViewById(2131379017));
    this.e = ((TextView)paramContext.findViewById(2131378892));
  }
  
  public void a(FeedsItemData paramFeedsItemData)
  {
    super.a(paramFeedsItemData);
    this.e.setText(paramFeedsItemData.title + "");
    if (TextUtils.isEmpty(paramFeedsItemData.subTitle)) {
      this.d.setVisibility(8);
    }
    for (;;)
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mLoadingDrawable = this.itemView.getResources().getDrawable(2130846622);
      localURLDrawableOptions.mFailedDrawable = this.itemView.getResources().getDrawable(2130846622);
      paramFeedsItemData = URLDrawable.getDrawable(paramFeedsItemData.coverImgUrl, localURLDrawableOptions);
      this.b.setImageDrawable(paramFeedsItemData);
      return;
      this.d.setVisibility(0);
      this.d.setText(paramFeedsItemData.subTitle + "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asmc
 * JD-Core Version:    0.7.0.1
 */