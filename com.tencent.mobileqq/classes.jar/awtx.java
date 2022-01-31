import QC.UniBusiSimpleItemDetail;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.profile.stickynote.publish.ui.StickyNotePublishFragment;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.QQToast;

class awtx
  implements View.OnClickListener
{
  awtx(awtw paramawtw, UniBusiSimpleItemDetail paramUniBusiSimpleItemDetail) {}
  
  public void onClick(View paramView)
  {
    if ((awtw.a(this.jdField_a_of_type_Awtw) == 5) && (awtw.a(this.jdField_a_of_type_Awtw) != null) && ((awtw.a(this.jdField_a_of_type_Awtw) instanceof StickyNotePublishFragment)) && (!((StickyNotePublishFragment)awtw.a(this.jdField_a_of_type_Awtw)).a()))
    {
      QQToast.a(awtw.a(this.jdField_a_of_type_Awtw), alud.a(2131715525), 0).a();
      return;
    }
    awtw.a(this.jdField_a_of_type_Awtw, this.jdField_a_of_type_QCUniBusiSimpleItemDetail.itemId);
    if (9 == awtw.a(this.jdField_a_of_type_Awtw)) {}
    for (paramView = "1";; paramView = "2")
    {
      VasWebviewUtil.reportCommercialDrainage("friend_wall", "item_click", "", 0, "", paramView);
      this.jdField_a_of_type_Awtw.notifyDataSetChanged();
      awtw.a(this.jdField_a_of_type_Awtw, this.jdField_a_of_type_QCUniBusiSimpleItemDetail);
      awtw.a(this.jdField_a_of_type_Awtw, true);
      this.jdField_a_of_type_Awtw.a(awtw.a(this.jdField_a_of_type_Awtw), this.jdField_a_of_type_QCUniBusiSimpleItemDetail.itemId, this.jdField_a_of_type_QCUniBusiSimpleItemDetail.feeType, this.jdField_a_of_type_Awtw.a);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awtx
 * JD-Core Version:    0.7.0.1
 */