import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qwallet.plugin.QWalletHelper;

class bckp
  implements View.OnClickListener
{
  bckp(bckm parambckm, Context paramContext) {}
  
  public void onClick(View paramView)
  {
    QWalletHelper.gotoQWalletHome((Activity)this.jdField_a_of_type_AndroidContentContext);
    ajvj.a("public.tailplace.click", "", "", "2", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bckp
 * JD-Core Version:    0.7.0.1
 */