import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData.GameInfo;
import com.tencent.mobileqq.profile.PersonalityLabel.CornerImageView;
import com.tencent.qphone.base.util.QLog;

public class avbi
  extends RecyclerView.ViewHolder
{
  private int jdField_a_of_type_Int;
  public ImageView a;
  public TextView a;
  private avbb jdField_a_of_type_Avbb;
  private FeedsItemData jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData;
  public CornerImageView a;
  public TextView b;
  public TextView c;
  public TextView d;
  
  public avbi(View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379001));
    this.b = ((TextView)paramView.findViewById(2131363087));
    this.c = ((TextView)paramView.findViewById(2131372158));
    this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView = ((CornerImageView)paramView.findViewById(2131368633));
    this.d = ((TextView)paramView.findViewById(2131367540));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131365759));
  }
  
  public void a(avbb paramavbb, FeedsItemData paramFeedsItemData, int paramInt)
  {
    this.jdField_a_of_type_Avbb = paramavbb;
    this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData = paramFeedsItemData;
    this.jdField_a_of_type_Int = paramInt;
    if (this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.miniType == 1)
    {
      this.itemView.setBackgroundDrawable(aver.a(this.itemView.getContext(), 8.0F, 8.0F, 8.0F, 8.0F));
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.title);
      this.b.setText(this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.authorName);
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setImageURL(this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.coverImgUrl);
        this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setRadius(AIOUtils.dp2px(4.0F, this.itemView.getResources()));
        this.d.setText(this.jdField_a_of_type_Avbb.a().gameName);
        if ((!TextUtils.isEmpty(this.jdField_a_of_type_Avbb.a().gameName)) && (this.jdField_a_of_type_Avbb.a().gameName.length() > 8))
        {
          this.c.setVisibility(4);
          this.itemView.setOnClickListener(new avbj(this));
          return;
          if (this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.miniType == 2)
          {
            this.itemView.setBackgroundDrawable(aver.a(this.itemView.getContext(), 0.0F, 0.0F, 8.0F, 8.0F));
            this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
            continue;
          }
          this.itemView.setBackgroundDrawable(aver.a(this.itemView.getContext(), 8.0F, 8.0F, 0.0F, 0.0F));
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        }
      }
      catch (Exception paramavbb)
      {
        for (;;)
        {
          QLog.e("QQGamePubFeedsAdapter", 1, paramavbb, new Object[0]);
        }
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.viewersNum > 10000) {}
    for (paramavbb = Math.round(this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.viewersNum / 10000.0F * 10.0F) / 10.0F + anvx.a(2131709780);; paramavbb = this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.viewersNum + anvx.a(2131709768))
    {
      this.c.setText(paramavbb);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avbi
 * JD-Core Version:    0.7.0.1
 */