import android.content.Context;
import android.content.Intent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;

class bedk
  implements View.OnTouchListener
{
  bedk(bedi parambedi, String paramString, bedr parambedr) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 1)
    {
      paramView = new Intent(this.jdField_a_of_type_Bedi.a.getContext(), QQBrowserActivity.class);
      paramMotionEvent = bgev.a("troopEnterEffect");
      paramView.putExtra("url", paramMotionEvent + "&gc=" + this.jdField_a_of_type_Bedi.b);
      this.jdField_a_of_type_Bedi.a.getContext().startActivity(paramView);
      bedt.a("Grp_AIO", "action_clk", new String[] { this.jdField_a_of_type_Bedi.b });
      VasWebviewUtil.reportCommercialDrainage(this.jdField_a_of_type_JavaLangString, "style", "0X8008E63", "", 1, 0, 0, "", Integer.toString(this.jdField_a_of_type_Bedr.a), "");
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bedk
 * JD-Core Version:    0.7.0.1
 */