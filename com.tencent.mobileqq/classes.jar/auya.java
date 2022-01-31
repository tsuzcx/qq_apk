import QC.UniBusiSimpleItemDetail;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.profile.stickynote.publish.ui.StickyNotePublishFragment;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;

class auya
  implements View.OnClickListener
{
  auya(auxz paramauxz, UniBusiSimpleItemDetail paramUniBusiSimpleItemDetail) {}
  
  public void onClick(View paramView)
  {
    if ((auxz.a(this.jdField_a_of_type_Auxz) == 5) && (auxz.a(this.jdField_a_of_type_Auxz) != null) && (!((StickyNotePublishFragment)auxz.a(this.jdField_a_of_type_Auxz)).a()))
    {
      bcpw.a(auxz.a(this.jdField_a_of_type_Auxz), ajyc.a(2131715130), 0).a();
      return;
    }
    auxz.a(this.jdField_a_of_type_Auxz, this.jdField_a_of_type_QCUniBusiSimpleItemDetail.itemId);
    if (9 == auxz.a(this.jdField_a_of_type_Auxz)) {}
    for (paramView = "1";; paramView = "2")
    {
      VasWebviewUtil.reportCommercialDrainage("friend_wall", "item_click", "", 0, "", paramView);
      this.jdField_a_of_type_Auxz.notifyDataSetChanged();
      auxz.a(this.jdField_a_of_type_Auxz, this.jdField_a_of_type_QCUniBusiSimpleItemDetail);
      auxz.a(this.jdField_a_of_type_Auxz, true);
      this.jdField_a_of_type_Auxz.a(auxz.a(this.jdField_a_of_type_Auxz), this.jdField_a_of_type_QCUniBusiSimpleItemDetail.itemId, this.jdField_a_of_type_QCUniBusiSimpleItemDetail.feeType, this.jdField_a_of_type_Auxz.a);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auya
 * JD-Core Version:    0.7.0.1
 */