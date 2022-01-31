import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData.GameInfo;
import com.tencent.mobileqq.profile.PersonalityLabel.CornerImageView;
import com.tencent.qphone.base.util.QLog;

public class apwf
  extends RecyclerView.ViewHolder
{
  private int jdField_a_of_type_Int;
  public ImageView a;
  public TextView a;
  private apvy jdField_a_of_type_Apvy;
  private FeedsItemData jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData;
  public CornerImageView a;
  public TextView b;
  public TextView c;
  public TextView d;
  
  public apwf(View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131311534));
    this.b = ((TextView)paramView.findViewById(2131297345));
    this.c = ((TextView)paramView.findViewById(2131305317));
    this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView = ((CornerImageView)paramView.findViewById(2131302286));
    this.d = ((TextView)paramView.findViewById(2131301313));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131299701));
  }
  
  public void a(apvy paramapvy, FeedsItemData paramFeedsItemData, int paramInt)
  {
    this.jdField_a_of_type_Apvy = paramapvy;
    this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData = paramFeedsItemData;
    this.jdField_a_of_type_Int = paramInt;
    if (this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.miniType == 1)
    {
      this.itemView.setBackgroundDrawable(apyr.a(this.itemView.getContext(), 8.0F, 8.0F, 8.0F, 8.0F));
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.title);
      this.b.setText(this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.authorName);
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setImageURL(this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.coverImgUrl);
        this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setRadius(aciy.a(4.0F, this.itemView.getResources()));
        this.d.setText(this.jdField_a_of_type_Apvy.a().gameName);
        if ((!TextUtils.isEmpty(this.jdField_a_of_type_Apvy.a().gameName)) && (this.jdField_a_of_type_Apvy.a().gameName.length() > 8))
        {
          this.c.setVisibility(4);
          this.itemView.setOnClickListener(new apwg(this));
          return;
          if (this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.miniType == 2)
          {
            this.itemView.setBackgroundDrawable(apyr.a(this.itemView.getContext(), 0.0F, 0.0F, 8.0F, 8.0F));
            this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
            continue;
          }
          this.itemView.setBackgroundDrawable(apyr.a(this.itemView.getContext(), 8.0F, 8.0F, 0.0F, 0.0F));
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        }
      }
      catch (Exception paramapvy)
      {
        for (;;)
        {
          QLog.e("QQGamePubFeedsAdapter", 1, paramapvy, new Object[0]);
        }
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.viewersNum > 10000) {}
    for (paramapvy = Math.round(this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.viewersNum / 10000.0F * 10.0F) / 10.0F + ajjy.a(2131644536);; paramapvy = this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.viewersNum + ajjy.a(2131644524))
    {
      this.c.setText(paramapvy);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     apwf
 * JD-Core Version:    0.7.0.1
 */