import android.content.Context;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.extendfriend.wiget.ExtendFriendFeedView;

public class aofj
  extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  private Context jdField_a_of_type_AndroidContentContext;
  aojb jdField_a_of_type_Aojb;
  public bibp a;
  public ExtendFriendFeedView a;
  
  public aofj(View paramView, Context paramContext, aojb paramaojb, bibp parambibp)
  {
    super(paramView);
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendFeedView = ((ExtendFriendFeedView)paramView);
    this.jdField_a_of_type_Bibp = parambibp;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Aojb = paramaojb;
    if (this.jdField_a_of_type_Bibp != null) {
      this.jdField_a_of_type_Bibp.a(this.jdField_a_of_type_Bibp.a(), new aofk(this));
    }
  }
  
  public void a(aofj paramaofj, aogm paramaogm, int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendFeedView != null) && (paramaogm != null))
    {
      int i = paramaofj.getPosition();
      paramaofj.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendFeedView.setFeedBgParams(i, paramaogm.mVoiceUrl, paramInt, false);
    }
    if ((this.jdField_a_of_type_Bibp != null) && (paramaogm != null) && (paramaogm.mAlumbasicdata != null)) {
      paramaofj.jdField_a_of_type_Bibp.a(paramaogm.mAlumbasicdata, paramaofj.getAdapterPosition());
    }
  }
  
  public void onClick(View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aofj
 * JD-Core Version:    0.7.0.1
 */