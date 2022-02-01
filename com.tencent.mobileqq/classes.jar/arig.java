import android.content.Context;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.extendfriend.wiget.ExtendFriendFeedView;

public class arig
  extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  private Context jdField_a_of_type_AndroidContentContext;
  armg jdField_a_of_type_Armg;
  public blda a;
  public ExtendFriendFeedView a;
  
  public arig(View paramView, Context paramContext, armg paramarmg, blda paramblda)
  {
    super(paramView);
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendFeedView = ((ExtendFriendFeedView)paramView);
    this.jdField_a_of_type_Blda = paramblda;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Armg = paramarmg;
    if (this.jdField_a_of_type_Blda != null) {
      this.jdField_a_of_type_Blda.a(this.jdField_a_of_type_Blda.a(), new arih(this));
    }
  }
  
  public void a(arig paramarig, arjk paramarjk, int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendFeedView != null) && (paramarjk != null))
    {
      int i = paramarig.getPosition();
      paramarig.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendFeedView.setFeedBgParams(i, paramarjk.mVoiceUrl, paramInt, false);
    }
    if ((this.jdField_a_of_type_Blda != null) && (paramarjk != null) && (paramarjk.mAlumbasicdata != null)) {
      paramarig.jdField_a_of_type_Blda.a(paramarjk.mAlumbasicdata, paramarig.getAdapterPosition());
    }
  }
  
  public void onClick(View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arig
 * JD-Core Version:    0.7.0.1
 */