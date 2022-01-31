import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity;

public class azfm
  implements View.OnClickListener
{
  public azfm(TroopAvatarWallPreviewActivity paramTroopAvatarWallPreviewActivity) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131364978: 
      paramView = (bfpc)bfpp.a(this.a, null);
      paramView.a(2131693381, 3);
      paramView.c(2131690596);
      paramView.a(new azfn(this, paramView));
      paramView.show();
      return;
    case 2131362258: 
      TroopAvatarWallPreviewActivity.d(this.a);
      return;
    }
    TroopAvatarWallPreviewActivity.i(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azfm
 * JD-Core Version:    0.7.0.1
 */