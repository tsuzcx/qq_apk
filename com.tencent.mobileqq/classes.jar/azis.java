import QC.UniBusiSimpleItemDetail;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.profile.stickynote.publish.ui.StickyNotePublishFragment;
import com.tencent.mobileqq.profile.stickynote.vas.StickyNoteShopLayout;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class azis
  implements View.OnClickListener
{
  azis(azir paramazir, UniBusiSimpleItemDetail paramUniBusiSimpleItemDetail) {}
  
  public void onClick(View paramView)
  {
    if ((azir.a(this.jdField_a_of_type_Azir) == 5) && (azir.a(this.jdField_a_of_type_Azir) != null) && ((azir.a(this.jdField_a_of_type_Azir) instanceof StickyNotePublishFragment)) && (!((StickyNotePublishFragment)azir.a(this.jdField_a_of_type_Azir)).a()))
    {
      QQToast.a(azir.a(this.jdField_a_of_type_Azir), anni.a(2131713806), 0).a();
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    azir.a(this.jdField_a_of_type_Azir, this.jdField_a_of_type_QCUniBusiSimpleItemDetail.itemId);
    int i = azir.a(this.jdField_a_of_type_Azir).a;
    azir.a(this.jdField_a_of_type_Azir);
    if (i == 2)
    {
      if (9 == azir.a(this.jdField_a_of_type_Azir)) {}
      for (str = "1";; str = "2")
      {
        VasWebviewUtil.reportCommercialDrainage("strangers_makefriend", "item_click", "", 0, "", str);
        this.jdField_a_of_type_Azir.notifyDataSetChanged();
        azir.a(this.jdField_a_of_type_Azir, this.jdField_a_of_type_QCUniBusiSimpleItemDetail);
        azir.a(this.jdField_a_of_type_Azir, true);
        this.jdField_a_of_type_Azir.a(azir.a(this.jdField_a_of_type_Azir), this.jdField_a_of_type_QCUniBusiSimpleItemDetail.itemId, this.jdField_a_of_type_QCUniBusiSimpleItemDetail.feeType, this.jdField_a_of_type_Azir.a);
        break;
      }
    }
    if (9 == azir.a(this.jdField_a_of_type_Azir)) {}
    for (String str = "1";; str = "2")
    {
      VasWebviewUtil.reportCommercialDrainage("friend_wall", "item_click", "", 0, "", str);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azis
 * JD-Core Version:    0.7.0.1
 */