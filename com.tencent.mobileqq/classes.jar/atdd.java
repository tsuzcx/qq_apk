import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mobileqq/extendfriend/wiget/ColdPalaceTipDialog$init$1$1"}, k=3, mv={1, 1, 16})
final class atdd
  implements View.OnClickListener
{
  atdd(atdb paramatdb, Context paramContext, String paramString, QQAppInterface paramQQAppInterface, int paramInt) {}
  
  public final void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Atdb.isShowing())
    {
      bdll.b(null, "dc00898", "", "", "0X800B2CF", "0X800B2CF", 2, 0, "", "", "", "");
      this.jdField_a_of_type_Atdb.dismiss();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atdd
 * JD-Core Version:    0.7.0.1
 */