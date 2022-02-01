import QC.UniBusiSimpleItemDetail;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.profile.stickynote.publish.ui.StickyNotePublishFragment;
import com.tencent.mobileqq.profile.stickynote.vas.StickyNoteShopLayout;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class azuo
  implements View.OnClickListener
{
  azuo(azun paramazun, UniBusiSimpleItemDetail paramUniBusiSimpleItemDetail) {}
  
  public void onClick(View paramView)
  {
    if ((azun.a(this.jdField_a_of_type_Azun) == 5) && (azun.a(this.jdField_a_of_type_Azun) != null) && ((azun.a(this.jdField_a_of_type_Azun) instanceof StickyNotePublishFragment)) && (!((StickyNotePublishFragment)azun.a(this.jdField_a_of_type_Azun)).a()))
    {
      QQToast.a(azun.a(this.jdField_a_of_type_Azun), anvx.a(2131714494), 0).a();
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    azun.a(this.jdField_a_of_type_Azun, this.jdField_a_of_type_QCUniBusiSimpleItemDetail.itemId);
    int i = azun.a(this.jdField_a_of_type_Azun).a;
    azun.a(this.jdField_a_of_type_Azun);
    if (i == 2)
    {
      if (9 == azun.a(this.jdField_a_of_type_Azun)) {}
      for (str = "1";; str = "2")
      {
        VasWebviewUtil.reportCommercialDrainage("strangers_makefriend", "item_click", "", 0, "", str);
        this.jdField_a_of_type_Azun.notifyDataSetChanged();
        azun.a(this.jdField_a_of_type_Azun, this.jdField_a_of_type_QCUniBusiSimpleItemDetail);
        azun.a(this.jdField_a_of_type_Azun, true);
        this.jdField_a_of_type_Azun.a(azun.a(this.jdField_a_of_type_Azun), this.jdField_a_of_type_QCUniBusiSimpleItemDetail.itemId, this.jdField_a_of_type_QCUniBusiSimpleItemDetail.feeType, this.jdField_a_of_type_Azun.a);
        break;
      }
    }
    if (9 == azun.a(this.jdField_a_of_type_Azun)) {}
    for (String str = "1";; str = "2")
    {
      VasWebviewUtil.reportCommercialDrainage("friend_wall", "item_click", "", 0, "", str);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azuo
 * JD-Core Version:    0.7.0.1
 */