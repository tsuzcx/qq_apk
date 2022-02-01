import android.content.Context;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.extendfriend.wiget.ExtendFriendFeedView;

public class asgp
  extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  private Context jdField_a_of_type_AndroidContentContext;
  aski jdField_a_of_type_Aski;
  public bmwm a;
  public ExtendFriendFeedView a;
  
  public asgp(View paramView, Context paramContext, aski paramaski, bmwm parambmwm)
  {
    super(paramView);
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendFeedView = ((ExtendFriendFeedView)paramView);
    this.jdField_a_of_type_Bmwm = parambmwm;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Aski = paramaski;
    if (this.jdField_a_of_type_Bmwm != null) {
      this.jdField_a_of_type_Bmwm.a(this.jdField_a_of_type_Bmwm.a(), new asgq(this));
    }
  }
  
  public void a(asgp paramasgp, asht paramasht, int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendFeedView != null) && (paramasht != null))
    {
      int i = paramasgp.getPosition();
      paramasgp.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendFeedView.setFeedBgParams(i, paramasht.mVoiceUrl, paramInt, false);
    }
    if ((this.jdField_a_of_type_Bmwm != null) && (paramasht != null) && (paramasht.mAlumbasicdata != null)) {
      paramasgp.jdField_a_of_type_Bmwm.a(paramasht.mAlumbasicdata, paramasgp.getAdapterPosition());
    }
  }
  
  public void onClick(View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asgp
 * JD-Core Version:    0.7.0.1
 */