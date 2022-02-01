import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class bdqi
  implements View.OnClickListener
{
  public bdqi(TroopAvatarWallPreviewActivity paramTroopAvatarWallPreviewActivity) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      bjnw localbjnw = (bjnw)bjon.a(this.a, null);
      localbjnw.a(2131693014, 3);
      localbjnw.c(2131690620);
      localbjnw.a(new bdqj(this, localbjnw));
      localbjnw.show();
      continue;
      TroopAvatarWallPreviewActivity.c(this.a);
      continue;
      TroopAvatarWallPreviewActivity.i(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdqi
 * JD-Core Version:    0.7.0.1
 */