import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.troop.activity.TroopBarReplyActivity;
import com.tencent.mobileqq.troop.widget.PublishItemContainer;

public class bbkm
  implements View.OnClickListener
{
  public bbkm(TroopBarReplyActivity paramTroopBarReplyActivity) {}
  
  public void onClick(View paramView)
  {
    switch (((aett)paramView.getTag()).a)
    {
    }
    do
    {
      do
      {
        return;
        TroopBarReplyActivity.b(this.a);
        return;
        TroopBarReplyActivity.c(this.a);
        return;
        TroopBarReplyActivity.d(this.a);
        return;
        if (this.a.k)
        {
          bcmc.a(this.a.m, this.a.n, "Clk_music", this.a.o, "", "", "");
          bcmc.b("reply_page_new", "Clk_music", this.a.o, "", "", "");
        }
      } while (this.a.a(4));
      if ((this.a.a.a() != 0) && (this.a.a.a() != 3))
      {
        this.a.a(3);
        return;
      }
      this.a.b(4);
      return;
      if (this.a.k)
      {
        bcmc.a(this.a.m, this.a.n, "Clk_video", this.a.o, "", "", "");
        bcmc.b("reply_page_new", "Clk_video", this.a.o, "", "", "");
      }
    } while (this.a.a(8));
    if ((this.a.a.a() != 0) && (this.a.a.a() != 4))
    {
      this.a.a(7);
      return;
    }
    this.a.b(3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbkm
 * JD-Core Version:    0.7.0.1
 */