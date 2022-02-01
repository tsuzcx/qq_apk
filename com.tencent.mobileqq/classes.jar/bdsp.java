import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.troop.activity.TroopBarReplyActivity;
import com.tencent.mobileqq.troop.widget.PublishItemContainer;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class bdsp
  implements View.OnClickListener
{
  public bdsp(TroopBarReplyActivity paramTroopBarReplyActivity) {}
  
  public void onClick(View paramView)
  {
    switch (((afcl)paramView.getTag()).a)
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      TroopBarReplyActivity.b(this.a);
      continue;
      TroopBarReplyActivity.c(this.a);
      continue;
      TroopBarReplyActivity.d(this.a);
      continue;
      if (this.a.k)
      {
        bfaj.a(this.a.m, this.a.n, "Clk_music", this.a.o, "", "", "");
        bfaj.b("reply_page_new", "Clk_music", this.a.o, "", "", "");
      }
      if (!this.a.a(4)) {
        if ((this.a.a.a() != 0) && (this.a.a.a() != 3))
        {
          this.a.a(3);
        }
        else
        {
          this.a.b(4);
          continue;
          if (this.a.k)
          {
            bfaj.a(this.a.m, this.a.n, "Clk_video", this.a.o, "", "", "");
            bfaj.b("reply_page_new", "Clk_video", this.a.o, "", "", "");
          }
          if (!this.a.a(8)) {
            if ((this.a.a.a() != 0) && (this.a.a.a() != 4)) {
              this.a.a(7);
            } else {
              this.a.b(3);
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdsp
 * JD-Core Version:    0.7.0.1
 */