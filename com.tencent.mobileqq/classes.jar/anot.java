import android.content.Context;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.extendfriend.wiget.ExtendFriendFeedView;

public class anot
  extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  private Context jdField_a_of_type_AndroidContentContext;
  ansk jdField_a_of_type_Ansk;
  public bgrz a;
  public ExtendFriendFeedView a;
  
  public anot(View paramView, Context paramContext, ansk paramansk, bgrz parambgrz)
  {
    super(paramView);
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendFeedView = ((ExtendFriendFeedView)paramView);
    this.jdField_a_of_type_Bgrz = parambgrz;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Ansk = paramansk;
    if (this.jdField_a_of_type_Bgrz != null) {
      this.jdField_a_of_type_Bgrz.a(this.jdField_a_of_type_Bgrz.a(), new anou(this));
    }
  }
  
  public void a(anot paramanot, anpv paramanpv, int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendFeedView != null) && (paramanpv != null))
    {
      int i = paramanot.getPosition();
      paramanot.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendFeedView.setFeedBgParams(i, paramanpv.mVoiceUrl, paramInt, false);
    }
    if ((this.jdField_a_of_type_Bgrz != null) && (paramanpv != null) && (paramanpv.mAlumbasicdata != null)) {
      paramanot.jdField_a_of_type_Bgrz.a(paramanpv.mAlumbasicdata, paramanot.getAdapterPosition());
    }
  }
  
  public void onClick(View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     anot
 * JD-Core Version:    0.7.0.1
 */