import android.content.Context;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.extendfriend.wiget.ExtendFriendFeedView;

public class apxm
  extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  private Context jdField_a_of_type_AndroidContentContext;
  aqba jdField_a_of_type_Aqba;
  public bkdl a;
  public ExtendFriendFeedView a;
  
  public apxm(View paramView, Context paramContext, aqba paramaqba, bkdl parambkdl)
  {
    super(paramView);
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendFeedView = ((ExtendFriendFeedView)paramView);
    this.jdField_a_of_type_Bkdl = parambkdl;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Aqba = paramaqba;
    if (this.jdField_a_of_type_Bkdl != null) {
      this.jdField_a_of_type_Bkdl.a(this.jdField_a_of_type_Bkdl.a(), new apxn(this));
    }
  }
  
  public void a(apxm paramapxm, apyo paramapyo, int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendFeedView != null) && (paramapyo != null))
    {
      int i = paramapxm.getPosition();
      paramapxm.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendFeedView.setFeedBgParams(i, paramapyo.mVoiceUrl, paramInt, false);
    }
    if ((this.jdField_a_of_type_Bkdl != null) && (paramapyo != null) && (paramapyo.mAlumbasicdata != null)) {
      paramapxm.jdField_a_of_type_Bkdl.a(paramapyo.mAlumbasicdata, paramapxm.getAdapterPosition());
    }
  }
  
  public void onClick(View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apxm
 * JD-Core Version:    0.7.0.1
 */