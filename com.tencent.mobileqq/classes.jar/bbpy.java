import android.content.Context;
import android.content.Intent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;

class bbpy
  implements View.OnTouchListener
{
  bbpy(bbpw parambbpw, String paramString, bbqf parambbqf) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 1)
    {
      paramView = new Intent(this.jdField_a_of_type_Bbpw.a.getContext(), QQBrowserActivity.class);
      paramMotionEvent = bdox.a("troopEnterEffect");
      paramView.putExtra("url", paramMotionEvent + "&gc=" + this.jdField_a_of_type_Bbpw.b);
      this.jdField_a_of_type_Bbpw.a.getContext().startActivity(paramView);
      bbqh.a("Grp_AIO", "action_clk", new String[] { this.jdField_a_of_type_Bbpw.b });
      VasWebviewUtil.reportCommercialDrainage(this.jdField_a_of_type_JavaLangString, "style", "0X8008E63", "", 1, 0, 0, "", Integer.toString(this.jdField_a_of_type_Bbqf.a), "");
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbpy
 * JD-Core Version:    0.7.0.1
 */