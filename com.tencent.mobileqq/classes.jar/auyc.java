import QC.UniBusiSimpleItemDetail;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.profile.stickynote.publish.ui.StickyNotePublishFragment;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;

class auyc
  implements View.OnClickListener
{
  auyc(auyb paramauyb, UniBusiSimpleItemDetail paramUniBusiSimpleItemDetail) {}
  
  public void onClick(View paramView)
  {
    if ((auyb.a(this.jdField_a_of_type_Auyb) == 5) && (auyb.a(this.jdField_a_of_type_Auyb) != null) && (!((StickyNotePublishFragment)auyb.a(this.jdField_a_of_type_Auyb)).a()))
    {
      bcql.a(auyb.a(this.jdField_a_of_type_Auyb), ajya.a(2131715141), 0).a();
      return;
    }
    auyb.a(this.jdField_a_of_type_Auyb, this.jdField_a_of_type_QCUniBusiSimpleItemDetail.itemId);
    if (9 == auyb.a(this.jdField_a_of_type_Auyb)) {}
    for (paramView = "1";; paramView = "2")
    {
      VasWebviewUtil.reportCommercialDrainage("friend_wall", "item_click", "", 0, "", paramView);
      this.jdField_a_of_type_Auyb.notifyDataSetChanged();
      auyb.a(this.jdField_a_of_type_Auyb, this.jdField_a_of_type_QCUniBusiSimpleItemDetail);
      auyb.a(this.jdField_a_of_type_Auyb, true);
      this.jdField_a_of_type_Auyb.a(auyb.a(this.jdField_a_of_type_Auyb), this.jdField_a_of_type_QCUniBusiSimpleItemDetail.itemId, this.jdField_a_of_type_QCUniBusiSimpleItemDetail.feeType, this.jdField_a_of_type_Auyb.a);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auyc
 * JD-Core Version:    0.7.0.1
 */