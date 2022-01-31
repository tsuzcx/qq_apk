import QC.UniBusiSimpleItemDetail;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.profile.stickynote.publish.ui.StickyNotePublishFragment;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.QQToast;

class awpo
  implements View.OnClickListener
{
  awpo(awpn paramawpn, UniBusiSimpleItemDetail paramUniBusiSimpleItemDetail) {}
  
  public void onClick(View paramView)
  {
    if ((awpn.a(this.jdField_a_of_type_Awpn) == 5) && (awpn.a(this.jdField_a_of_type_Awpn) != null) && ((awpn.a(this.jdField_a_of_type_Awpn) instanceof StickyNotePublishFragment)) && (!((StickyNotePublishFragment)awpn.a(this.jdField_a_of_type_Awpn)).a()))
    {
      QQToast.a(awpn.a(this.jdField_a_of_type_Awpn), alpo.a(2131715513), 0).a();
      return;
    }
    awpn.a(this.jdField_a_of_type_Awpn, this.jdField_a_of_type_QCUniBusiSimpleItemDetail.itemId);
    if (9 == awpn.a(this.jdField_a_of_type_Awpn)) {}
    for (paramView = "1";; paramView = "2")
    {
      VasWebviewUtil.reportCommercialDrainage("friend_wall", "item_click", "", 0, "", paramView);
      this.jdField_a_of_type_Awpn.notifyDataSetChanged();
      awpn.a(this.jdField_a_of_type_Awpn, this.jdField_a_of_type_QCUniBusiSimpleItemDetail);
      awpn.a(this.jdField_a_of_type_Awpn, true);
      this.jdField_a_of_type_Awpn.a(awpn.a(this.jdField_a_of_type_Awpn), this.jdField_a_of_type_QCUniBusiSimpleItemDetail.itemId, this.jdField_a_of_type_QCUniBusiSimpleItemDetail.feeType, this.jdField_a_of_type_Awpn.a);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awpo
 * JD-Core Version:    0.7.0.1
 */