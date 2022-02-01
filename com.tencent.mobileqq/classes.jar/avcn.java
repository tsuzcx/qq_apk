import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData.Gift;
import java.util.List;

public class avcn
  extends avck
{
  public LinearLayout a;
  public ImageView[] a;
  public LinearLayout[] a;
  public TextView[] a;
  public TextView d;
  
  public avcn(Context paramContext, View paramView, ViewGroup paramViewGroup)
  {
    super(paramContext, paramView, paramViewGroup);
    paramContext = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559234, paramViewGroup, false);
    if (paramContext != null) {
      this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(paramContext);
    }
    this.d = ((TextView)paramContext.findViewById(2131379960));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramContext.findViewById(2131369852));
    this.jdField_a_of_type_ArrayOfAndroidWidgetImageView = new ImageView[4];
    this.jdField_a_of_type_ArrayOfAndroidWidgetTextView = new TextView[4];
    this.jdField_a_of_type_ArrayOfAndroidWidgetLinearLayout = new LinearLayout[4];
    this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[0] = ((ImageView)paramContext.findViewById(2131368696));
    this.jdField_a_of_type_ArrayOfAndroidWidgetTextView[0] = ((TextView)paramContext.findViewById(2131379953));
    this.jdField_a_of_type_ArrayOfAndroidWidgetLinearLayout[0] = ((LinearLayout)paramContext.findViewById(2131369848));
    this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[1] = ((ImageView)paramContext.findViewById(2131368697));
    this.jdField_a_of_type_ArrayOfAndroidWidgetTextView[1] = ((TextView)paramContext.findViewById(2131379954));
    this.jdField_a_of_type_ArrayOfAndroidWidgetLinearLayout[1] = ((LinearLayout)paramContext.findViewById(2131369849));
    this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[2] = ((ImageView)paramContext.findViewById(2131368698));
    this.jdField_a_of_type_ArrayOfAndroidWidgetTextView[2] = ((TextView)paramContext.findViewById(2131379955));
    this.jdField_a_of_type_ArrayOfAndroidWidgetLinearLayout[2] = ((LinearLayout)paramContext.findViewById(2131369850));
    this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[3] = ((ImageView)paramContext.findViewById(2131368699));
    this.jdField_a_of_type_ArrayOfAndroidWidgetTextView[3] = ((TextView)paramContext.findViewById(2131379956));
    this.jdField_a_of_type_ArrayOfAndroidWidgetLinearLayout[3] = ((LinearLayout)paramContext.findViewById(2131369851));
  }
  
  public void a(FeedsItemData paramFeedsItemData)
  {
    super.a(paramFeedsItemData);
    this.d.setText(paramFeedsItemData.title);
    int i;
    if ((paramFeedsItemData.giftList != null) && (paramFeedsItemData.giftList.size() > 0))
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      i = 0;
      label45:
      if (i >= 4) {
        return;
      }
      if (i >= paramFeedsItemData.giftList.size()) {
        break label176;
      }
      this.jdField_a_of_type_ArrayOfAndroidWidgetLinearLayout[i].setVisibility(0);
      FeedsItemData.Gift localGift = (FeedsItemData.Gift)paramFeedsItemData.giftList.get(i);
      this.jdField_a_of_type_ArrayOfAndroidWidgetTextView[i].setText(localGift.text);
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mLoadingDrawable = this.itemView.getResources().getDrawable(2130839616);
      localURLDrawableOptions.mFailedDrawable = this.itemView.getResources().getDrawable(2130839616);
      this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[i].setImageDrawable(URLDrawable.getDrawable(localGift.picture, localURLDrawableOptions));
    }
    for (;;)
    {
      i += 1;
      break label45;
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      break;
      label176:
      this.jdField_a_of_type_ArrayOfAndroidWidgetLinearLayout[i].setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avcn
 * JD-Core Version:    0.7.0.1
 */