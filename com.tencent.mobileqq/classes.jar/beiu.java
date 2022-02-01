import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class beiu
  implements View.OnClickListener
{
  public beiu(TroopAvatarWallPreviewActivity paramTroopAvatarWallPreviewActivity) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      bkho localbkho = (bkho)bkif.a(this.a, null);
      localbkho.a(2131692950, 3);
      localbkho.c(2131690582);
      localbkho.a(new beiv(this, localbkho));
      localbkho.show();
      continue;
      TroopAvatarWallPreviewActivity.c(this.a);
      continue;
      TroopAvatarWallPreviewActivity.i(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beiu
 * JD-Core Version:    0.7.0.1
 */