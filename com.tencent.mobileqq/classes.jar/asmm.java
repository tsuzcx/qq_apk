import android.content.Context;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.extendfriend.wiget.ExtendFriendFeedView;

public class asmm
  extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  private Context jdField_a_of_type_AndroidContentContext;
  asqm jdField_a_of_type_Asqm;
  public bmpr a;
  public ExtendFriendFeedView a;
  
  public asmm(View paramView, Context paramContext, asqm paramasqm, bmpr parambmpr)
  {
    super(paramView);
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendFeedView = ((ExtendFriendFeedView)paramView);
    this.jdField_a_of_type_Bmpr = parambmpr;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Asqm = paramasqm;
    if (this.jdField_a_of_type_Bmpr != null) {
      this.jdField_a_of_type_Bmpr.a(this.jdField_a_of_type_Bmpr.a(), new asmn(this));
    }
  }
  
  public void a(asmm paramasmm, asnq paramasnq, int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendFeedView != null) && (paramasnq != null))
    {
      int i = paramasmm.getPosition();
      paramasmm.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendFeedView.setFeedBgParams(i, paramasnq.mVoiceUrl, paramInt, false);
    }
    if ((this.jdField_a_of_type_Bmpr != null) && (paramasnq != null) && (paramasnq.mAlumbasicdata != null)) {
      paramasmm.jdField_a_of_type_Bmpr.a(paramasnq.mAlumbasicdata, paramasmm.getAdapterPosition());
    }
  }
  
  public void onClick(View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asmm
 * JD-Core Version:    0.7.0.1
 */