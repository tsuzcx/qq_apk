import android.content.Context;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.extendfriend.wiget.ExtendFriendFeedView;

public class aqbv
  extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  private Context jdField_a_of_type_AndroidContentContext;
  aqfj jdField_a_of_type_Aqfj;
  public bkhs a;
  public ExtendFriendFeedView a;
  
  public aqbv(View paramView, Context paramContext, aqfj paramaqfj, bkhs parambkhs)
  {
    super(paramView);
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendFeedView = ((ExtendFriendFeedView)paramView);
    this.jdField_a_of_type_Bkhs = parambkhs;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Aqfj = paramaqfj;
    if (this.jdField_a_of_type_Bkhs != null) {
      this.jdField_a_of_type_Bkhs.a(this.jdField_a_of_type_Bkhs.a(), new aqbw(this));
    }
  }
  
  public void a(aqbv paramaqbv, aqcx paramaqcx, int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendFeedView != null) && (paramaqcx != null))
    {
      int i = paramaqbv.getPosition();
      paramaqbv.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendFeedView.setFeedBgParams(i, paramaqcx.mVoiceUrl, paramInt, false);
    }
    if ((this.jdField_a_of_type_Bkhs != null) && (paramaqcx != null) && (paramaqcx.mAlumbasicdata != null)) {
      paramaqbv.jdField_a_of_type_Bkhs.a(paramaqcx.mAlumbasicdata, paramaqbv.getAdapterPosition());
    }
  }
  
  public void onClick(View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqbv
 * JD-Core Version:    0.7.0.1
 */