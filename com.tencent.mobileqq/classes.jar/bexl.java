import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class bexl
  implements View.OnClickListener
{
  public bexl(TroopAvatarWallPreviewActivity paramTroopAvatarWallPreviewActivity) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      bkzi localbkzi = (bkzi)bkzz.a(this.a, null);
      localbkzi.a(2131693150, 3);
      localbkzi.c(2131690697);
      localbkzi.a(new bexm(this, localbkzi));
      localbkzi.show();
      continue;
      TroopAvatarWallPreviewActivity.c(this.a);
      continue;
      TroopAvatarWallPreviewActivity.i(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bexl
 * JD-Core Version:    0.7.0.1
 */