import android.content.Context;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.extendfriend.wiget.ExtendFriendFeedView;

public class aswd
  extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  private Context jdField_a_of_type_AndroidContentContext;
  aszz jdField_a_of_type_Aszz;
  public bnxu a;
  public ExtendFriendFeedView a;
  
  public aswd(View paramView, Context paramContext, aszz paramaszz, bnxu parambnxu)
  {
    super(paramView);
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendFeedView = ((ExtendFriendFeedView)paramView);
    this.jdField_a_of_type_Bnxu = parambnxu;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Aszz = paramaszz;
    if (this.jdField_a_of_type_Bnxu != null) {
      this.jdField_a_of_type_Bnxu.a(this.jdField_a_of_type_Bnxu.a(), new aswe(this));
    }
  }
  
  public void a(aswd paramaswd, asxh paramasxh, int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendFeedView != null) && (paramasxh != null))
    {
      int i = paramaswd.getPosition();
      paramaswd.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendFeedView.setFeedBgParams(i, paramasxh.mVoiceUrl, paramInt, false);
    }
    if ((this.jdField_a_of_type_Bnxu != null) && (paramasxh != null) && (paramasxh.mAlumbasicdata != null)) {
      paramaswd.jdField_a_of_type_Bnxu.a(paramasxh.mAlumbasicdata, paramaswd.getAdapterPosition());
    }
  }
  
  public void onClick(View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aswd
 * JD-Core Version:    0.7.0.1
 */