import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.open.agent.FriendChooser;
import com.tencent.open.agent.datamodel.Friend;
import java.util.ArrayList;

public class bdaz
  extends bdei
{
  public bdaz(FriendChooser paramFriendChooser) {}
  
  public int getCount()
  {
    return this.a.b.size();
  }
  
  public Object getItem(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.a.b.size())) {
      return this.a.b.get(paramInt);
    }
    return null;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Friend localFriend = (Friend)getItem(paramInt);
    if (paramView == null)
    {
      paramViewGroup = new bdbf();
      paramView = this.a.getLayoutInflater().inflate(2131559159, null);
      paramViewGroup.a = ((ImageView)paramView.findViewById(2131365824));
      paramView.setTag(paramViewGroup);
    }
    Bitmap localBitmap;
    for (;;)
    {
      if ((localFriend.d == null) || ("".equals(localFriend.d))) {
        localFriend.d = bder.a(this.a.a(), localFriend.a);
      }
      localBitmap = bdeo.a().a(localFriend.d);
      if (localBitmap != null) {
        break;
      }
      paramViewGroup.a.setImageResource(2130839736);
      paramViewGroup = paramViewGroup.a;
      bdeo.a().a(localFriend.d, new bdba(this, paramViewGroup));
      return paramView;
      paramViewGroup = (bdbf)paramView.getTag();
    }
    paramViewGroup.a.setImageBitmap(localBitmap);
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bdaz
 * JD-Core Version:    0.7.0.1
 */