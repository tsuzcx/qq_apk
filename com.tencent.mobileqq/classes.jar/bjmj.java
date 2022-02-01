import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.open.agent.FriendChooser;
import com.tencent.open.agent.datamodel.Friend;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

public class bjmj
  extends bjpx
{
  public bjmj(FriendChooser paramFriendChooser) {}
  
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
    Object localObject;
    Bitmap localBitmap;
    if (paramView == null)
    {
      localObject = new bjmp();
      paramView = this.a.getLayoutInflater().inflate(2131559281, null);
      ((bjmp)localObject).a = ((ImageView)paramView.findViewById(2131366213));
      paramView.setTag(localObject);
      if ((localFriend.d == null) || ("".equals(localFriend.d))) {
        localFriend.d = bjqg.a(this.a.a(), localFriend.a);
      }
      localBitmap = bjqd.a().a(localFriend.d);
      if (localBitmap != null) {
        break label182;
      }
      ((bjmp)localObject).a.setImageResource(2130840274);
      localObject = ((bjmp)localObject).a;
      bjqd.a().a(localFriend.d, new bjmk(this, (ImageView)localObject));
    }
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
      localObject = (bjmp)paramView.getTag();
      break;
      label182:
      ((bjmp)localObject).a.setImageBitmap(localBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjmj
 * JD-Core Version:    0.7.0.1
 */