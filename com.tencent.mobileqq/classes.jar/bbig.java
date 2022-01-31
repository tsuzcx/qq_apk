import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity;

public class bbig
  implements View.OnClickListener
{
  public bbig(TroopAvatarWallPreviewActivity paramTroopAvatarWallPreviewActivity) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131365065: 
      paramView = (bhuf)bhus.a(this.a, null);
      paramView.a(2131693484, 3);
      paramView.c(2131690648);
      paramView.a(new bbih(this, paramView));
      paramView.show();
      return;
    case 2131362279: 
      TroopAvatarWallPreviewActivity.c(this.a);
      return;
    }
    TroopAvatarWallPreviewActivity.i(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbig
 * JD-Core Version:    0.7.0.1
 */