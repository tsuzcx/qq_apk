import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.troop.activity.TroopBarPublishActivity;

public class bbjo
  extends ClickableSpan
{
  public bbjo(TroopBarPublishActivity paramTroopBarPublishActivity) {}
  
  public void onClick(View paramView)
  {
    if (this.a.a != null)
    {
      if (!this.a.a.a()) {
        break label42;
      }
      this.a.a.b();
    }
    for (;;)
    {
      this.a.e(true);
      return;
      label42:
      this.a.a.a();
      azqs.b(null, "dc00899", "Grp_tribe", "", "pub_page", "clk_prefixchoose", 0, 0, this.a.q, "", "", "");
    }
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(-16777216);
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbjo
 * JD-Core Version:    0.7.0.1
 */