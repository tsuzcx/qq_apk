import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.open.agent.FriendChooser;
import com.tencent.open.agent.datamodel.Friend;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

public class bjcu
  extends bjgn
{
  public bjcu(FriendChooser paramFriendChooser) {}
  
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
    if (paramView == null)
    {
      localObject = new bjda();
      paramView = this.a.getLayoutInflater().inflate(2131559337, null);
      ((bjda)localObject).a = ((ImageView)paramView.findViewById(2131366345));
      paramView.setTag(localObject);
    }
    while (localFriend == null)
    {
      QLog.e("qqBaseActivity", 1, new Object[] { "FriendChooser rr == nul pos=", Integer.valueOf(paramInt) });
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
      localObject = (bjda)paramView.getTag();
    }
    if ((localFriend.d == null) || ("".equals(localFriend.d))) {
      localFriend.d = bjgw.a(this.a.a(), localFriend.a);
    }
    Bitmap localBitmap = bjgt.a().a(localFriend.d);
    if (localBitmap == null)
    {
      ((bjda)localObject).a.setImageResource(2130840348);
      localObject = ((bjda)localObject).a;
      bjgt.a().a(localFriend.d, new bjcv(this, (ImageView)localObject));
    }
    for (;;)
    {
      break;
      ((bjda)localObject).a.setImageBitmap(localBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjcu
 * JD-Core Version:    0.7.0.1
 */