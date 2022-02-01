import QC.UniBusiSimpleItemDetail;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.profile.stickynote.publish.ui.StickyNotePublishFragment;
import com.tencent.mobileqq.profile.stickynote.vas.StickyNoteShopLayout;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class babe
  implements View.OnClickListener
{
  babe(babd parambabd, UniBusiSimpleItemDetail paramUniBusiSimpleItemDetail) {}
  
  public void onClick(View paramView)
  {
    if ((babd.a(this.jdField_a_of_type_Babd) == 5) && (babd.a(this.jdField_a_of_type_Babd) != null) && ((babd.a(this.jdField_a_of_type_Babd) instanceof StickyNotePublishFragment)) && (!((StickyNotePublishFragment)babd.a(this.jdField_a_of_type_Babd)).a()))
    {
      QQToast.a(babd.a(this.jdField_a_of_type_Babd), anzj.a(2131713915), 0).a();
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    babd.a(this.jdField_a_of_type_Babd, this.jdField_a_of_type_QCUniBusiSimpleItemDetail.itemId);
    int i = babd.a(this.jdField_a_of_type_Babd).a;
    babd.a(this.jdField_a_of_type_Babd);
    if (i == 2)
    {
      if (9 == babd.a(this.jdField_a_of_type_Babd)) {}
      for (str = "1";; str = "2")
      {
        VasWebviewUtil.reportCommercialDrainage("strangers_makefriend", "item_click", "", 0, "", str);
        this.jdField_a_of_type_Babd.notifyDataSetChanged();
        babd.a(this.jdField_a_of_type_Babd, this.jdField_a_of_type_QCUniBusiSimpleItemDetail);
        babd.a(this.jdField_a_of_type_Babd, true);
        this.jdField_a_of_type_Babd.a(babd.a(this.jdField_a_of_type_Babd), this.jdField_a_of_type_QCUniBusiSimpleItemDetail.itemId, this.jdField_a_of_type_QCUniBusiSimpleItemDetail.feeType, this.jdField_a_of_type_Babd.a);
        break;
      }
    }
    if (9 == babd.a(this.jdField_a_of_type_Babd)) {}
    for (String str = "1";; str = "2")
    {
      VasWebviewUtil.reportCommercialDrainage("friend_wall", "item_click", "", 0, "", str);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     babe
 * JD-Core Version:    0.7.0.1
 */