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

public class aqsa
  extends aqrw
{
  private ImageView b;
  private TextView d;
  private TextView e;
  
  public aqsa(Context paramContext, View paramView, ViewGroup paramViewGroup)
  {
    super(paramContext, paramView, paramViewGroup);
    paramContext = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559085, paramViewGroup, false);
    if (paramContext != null) {
      this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(paramContext);
    }
    this.b = ((ImageView)paramContext.findViewById(2131367992));
    this.d = ((TextView)paramContext.findViewById(2131378364));
    this.e = ((TextView)paramContext.findViewById(2131378262));
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
      localURLDrawableOptions.mLoadingDrawable = this.itemView.getResources().getDrawable(2130846170);
      localURLDrawableOptions.mFailedDrawable = this.itemView.getResources().getDrawable(2130846170);
      paramFeedsItemData = URLDrawable.getDrawable(paramFeedsItemData.coverImgUrl, localURLDrawableOptions);
      this.b.setImageDrawable(paramFeedsItemData);
      return;
      this.d.setVisibility(0);
      this.d.setText(paramFeedsItemData.subTitle + "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqsa
 * JD-Core Version:    0.7.0.1
 */