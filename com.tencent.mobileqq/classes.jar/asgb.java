import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData.GameInfo;
import com.tencent.mobileqq.profile.PersonalityLabel.CornerImageView;
import com.tencent.qphone.base.util.QLog;

public class asgb
  extends RecyclerView.ViewHolder
{
  private int jdField_a_of_type_Int;
  public ImageView a;
  public TextView a;
  private asfu jdField_a_of_type_Asfu;
  private FeedsItemData jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData;
  public CornerImageView a;
  public TextView b;
  public TextView c;
  public TextView d;
  
  public asgb(View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131377884));
    this.b = ((TextView)paramView.findViewById(2131362919));
    this.c = ((TextView)paramView.findViewById(2131371304));
    this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView = ((CornerImageView)paramView.findViewById(2131368042));
    this.d = ((TextView)paramView.findViewById(2131367041));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131365353));
  }
  
  public void a(asfu paramasfu, FeedsItemData paramFeedsItemData, int paramInt)
  {
    this.jdField_a_of_type_Asfu = paramasfu;
    this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData = paramFeedsItemData;
    this.jdField_a_of_type_Int = paramInt;
    if (this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.miniType == 1)
    {
      this.itemView.setBackgroundDrawable(asjc.a(this.itemView.getContext(), 8.0F, 8.0F, 8.0F, 8.0F));
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.title);
      this.b.setText(this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.authorName);
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setImageURL(this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.coverImgUrl);
        this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setRadius(aekt.a(4.0F, this.itemView.getResources()));
        this.d.setText(this.jdField_a_of_type_Asfu.a().gameName);
        if ((!TextUtils.isEmpty(this.jdField_a_of_type_Asfu.a().gameName)) && (this.jdField_a_of_type_Asfu.a().gameName.length() > 8))
        {
          this.c.setVisibility(4);
          this.itemView.setOnClickListener(new asgc(this));
          return;
          if (this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.miniType == 2)
          {
            this.itemView.setBackgroundDrawable(asjc.a(this.itemView.getContext(), 0.0F, 0.0F, 8.0F, 8.0F));
            this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
            continue;
          }
          this.itemView.setBackgroundDrawable(asjc.a(this.itemView.getContext(), 8.0F, 8.0F, 0.0F, 0.0F));
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        }
      }
      catch (Exception paramasfu)
      {
        for (;;)
        {
          QLog.e("QQGamePubFeedsAdapter", 1, paramasfu, new Object[0]);
        }
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.viewersNum > 10000) {}
    for (paramasfu = Math.round(this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.viewersNum / 10000.0F * 10.0F) / 10.0F + alpo.a(2131710704);; paramasfu = this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFeedsItemData.viewersNum + alpo.a(2131710692))
    {
      this.c.setText(paramasfu);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asgb
 * JD-Core Version:    0.7.0.1
 */