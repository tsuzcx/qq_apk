import android.content.Context;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.extendfriend.wiget.ExtendFriendFeedView;

public class aofe
  extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  private Context jdField_a_of_type_AndroidContentContext;
  aoiw jdField_a_of_type_Aoiw;
  public biay a;
  public ExtendFriendFeedView a;
  
  public aofe(View paramView, Context paramContext, aoiw paramaoiw, biay parambiay)
  {
    super(paramView);
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendFeedView = ((ExtendFriendFeedView)paramView);
    this.jdField_a_of_type_Biay = parambiay;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Aoiw = paramaoiw;
    if (this.jdField_a_of_type_Biay != null) {
      this.jdField_a_of_type_Biay.a(this.jdField_a_of_type_Biay.a(), new aoff(this));
    }
  }
  
  public void a(aofe paramaofe, aogh paramaogh, int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendFeedView != null) && (paramaogh != null))
    {
      int i = paramaofe.getPosition();
      paramaofe.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendFeedView.setFeedBgParams(i, paramaogh.mVoiceUrl, paramInt, false);
    }
    if ((this.jdField_a_of_type_Biay != null) && (paramaogh != null) && (paramaogh.mAlumbasicdata != null)) {
      paramaofe.jdField_a_of_type_Biay.a(paramaogh.mAlumbasicdata, paramaofe.getAdapterPosition());
    }
  }
  
  public void onClick(View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aofe
 * JD-Core Version:    0.7.0.1
 */