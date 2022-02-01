import android.view.View;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallEditActivity;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemLongClickListener;

public class bewp
  implements AdapterView.OnItemLongClickListener
{
  public bewp(TroopAvatarWallEditActivity paramTroopAvatarWallEditActivity) {}
  
  public boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    TroopAvatarWallEditActivity.a(this.a);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bewp
 * JD-Core Version:    0.7.0.1
 */