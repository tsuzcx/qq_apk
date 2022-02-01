import android.view.View;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallEditActivity;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemLongClickListener;

public class bdpm
  implements AdapterView.OnItemLongClickListener
{
  public bdpm(TroopAvatarWallEditActivity paramTroopAvatarWallEditActivity) {}
  
  public boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    TroopAvatarWallEditActivity.a(this.a);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdpm
 * JD-Core Version:    0.7.0.1
 */