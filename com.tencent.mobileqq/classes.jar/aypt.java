import QC.UniBusiSimpleItemDetail;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.profile.stickynote.publish.ui.StickyNotePublishFragment;
import com.tencent.mobileqq.profile.stickynote.vas.StickyNoteShopLayout;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aypt
  implements View.OnClickListener
{
  aypt(ayps paramayps, UniBusiSimpleItemDetail paramUniBusiSimpleItemDetail) {}
  
  public void onClick(View paramView)
  {
    if ((ayps.a(this.jdField_a_of_type_Ayps) == 5) && (ayps.a(this.jdField_a_of_type_Ayps) != null) && ((ayps.a(this.jdField_a_of_type_Ayps) instanceof StickyNotePublishFragment)) && (!((StickyNotePublishFragment)ayps.a(this.jdField_a_of_type_Ayps)).a()))
    {
      QQToast.a(ayps.a(this.jdField_a_of_type_Ayps), amtj.a(2131714147), 0).a();
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    ayps.a(this.jdField_a_of_type_Ayps, this.jdField_a_of_type_QCUniBusiSimpleItemDetail.itemId);
    int i = ayps.a(this.jdField_a_of_type_Ayps).a;
    ayps.a(this.jdField_a_of_type_Ayps);
    if (i == 2)
    {
      if (9 == ayps.a(this.jdField_a_of_type_Ayps)) {}
      for (str = "1";; str = "2")
      {
        VasWebviewUtil.reportCommercialDrainage("strangers_makefriend", "item_click", "", 0, "", str);
        this.jdField_a_of_type_Ayps.notifyDataSetChanged();
        ayps.a(this.jdField_a_of_type_Ayps, this.jdField_a_of_type_QCUniBusiSimpleItemDetail);
        ayps.a(this.jdField_a_of_type_Ayps, true);
        this.jdField_a_of_type_Ayps.a(ayps.a(this.jdField_a_of_type_Ayps), this.jdField_a_of_type_QCUniBusiSimpleItemDetail.itemId, this.jdField_a_of_type_QCUniBusiSimpleItemDetail.feeType, this.jdField_a_of_type_Ayps.a);
        break;
      }
    }
    if (9 == ayps.a(this.jdField_a_of_type_Ayps)) {}
    for (String str = "1";; str = "2")
    {
      VasWebviewUtil.reportCommercialDrainage("friend_wall", "item_click", "", 0, "", str);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aypt
 * JD-Core Version:    0.7.0.1
 */