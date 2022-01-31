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

public class asmb
  extends asly
{
  public LinearLayout a;
  public ImageView[] a;
  public LinearLayout[] a;
  public TextView[] a;
  public TextView d;
  
  public asmb(Context paramContext, View paramView, ViewGroup paramViewGroup)
  {
    super(paramContext, paramView, paramViewGroup);
    paramContext = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559123, paramViewGroup, false);
    if (paramContext != null) {
      this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(paramContext);
    }
    this.d = ((TextView)paramContext.findViewById(2131378822));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramContext.findViewById(2131369210));
    this.jdField_a_of_type_ArrayOfAndroidWidgetImageView = new ImageView[4];
    this.jdField_a_of_type_ArrayOfAndroidWidgetTextView = new TextView[4];
    this.jdField_a_of_type_ArrayOfAndroidWidgetLinearLayout = new LinearLayout[4];
    this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[0] = ((ImageView)paramContext.findViewById(2131368114));
    this.jdField_a_of_type_ArrayOfAndroidWidgetTextView[0] = ((TextView)paramContext.findViewById(2131378816));
    this.jdField_a_of_type_ArrayOfAndroidWidgetLinearLayout[0] = ((LinearLayout)paramContext.findViewById(2131369206));
    this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[1] = ((ImageView)paramContext.findViewById(2131368115));
    this.jdField_a_of_type_ArrayOfAndroidWidgetTextView[1] = ((TextView)paramContext.findViewById(2131378817));
    this.jdField_a_of_type_ArrayOfAndroidWidgetLinearLayout[1] = ((LinearLayout)paramContext.findViewById(2131369207));
    this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[2] = ((ImageView)paramContext.findViewById(2131368116));
    this.jdField_a_of_type_ArrayOfAndroidWidgetTextView[2] = ((TextView)paramContext.findViewById(2131378818));
    this.jdField_a_of_type_ArrayOfAndroidWidgetLinearLayout[2] = ((LinearLayout)paramContext.findViewById(2131369208));
    this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[3] = ((ImageView)paramContext.findViewById(2131368117));
    this.jdField_a_of_type_ArrayOfAndroidWidgetTextView[3] = ((TextView)paramContext.findViewById(2131378819));
    this.jdField_a_of_type_ArrayOfAndroidWidgetLinearLayout[3] = ((LinearLayout)paramContext.findViewById(2131369209));
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
      localURLDrawableOptions.mLoadingDrawable = this.itemView.getResources().getDrawable(2130839372);
      localURLDrawableOptions.mFailedDrawable = this.itemView.getResources().getDrawable(2130839372);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asmb
 * JD-Core Version:    0.7.0.1
 */