import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.open.agent.FriendChooser;
import com.tencent.open.agent.datamodel.Friend;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

public class bilk
  extends bioy
{
  public bilk(FriendChooser paramFriendChooser) {}
  
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
      localObject = new bilq();
      paramView = this.a.getLayoutInflater().inflate(2131559281, null);
      ((bilq)localObject).a = ((ImageView)paramView.findViewById(2131366164));
      paramView.setTag(localObject);
      if ((localFriend.d == null) || ("".equals(localFriend.d))) {
        localFriend.d = biph.a(this.a.a(), localFriend.a);
      }
      localBitmap = bipe.a().a(localFriend.d);
      if (localBitmap != null) {
        break label182;
      }
      ((bilq)localObject).a.setImageResource(2130840264);
      localObject = ((bilq)localObject).a;
      bipe.a().a(localFriend.d, new bill(this, (ImageView)localObject));
    }
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
      localObject = (bilq)paramView.getTag();
      break;
      label182:
      ((bilq)localObject).a.setImageBitmap(localBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bilk
 * JD-Core Version:    0.7.0.1
 */