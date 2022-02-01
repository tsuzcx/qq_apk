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

public class bhrx
  extends bhvm
{
  public bhrx(FriendChooser paramFriendChooser) {}
  
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
      localObject = new bhsd();
      paramView = this.a.getLayoutInflater().inflate(2131559287, null);
      ((bhsd)localObject).a = ((ImageView)paramView.findViewById(2131366241));
      paramView.setTag(localObject);
    }
    while (localFriend == null)
    {
      QLog.e("qqBaseActivity", 1, new Object[] { "FriendChooser rr == nul pos=", Integer.valueOf(paramInt) });
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
      localObject = (bhsd)paramView.getTag();
    }
    if ((localFriend.d == null) || ("".equals(localFriend.d))) {
      localFriend.d = bhvv.a(this.a.a(), localFriend.a);
    }
    Bitmap localBitmap = bhvs.a().a(localFriend.d);
    if (localBitmap == null)
    {
      ((bhsd)localObject).a.setImageResource(2130840312);
      localObject = ((bhsd)localObject).a;
      bhvs.a().a(localFriend.d, new bhry(this, (ImageView)localObject));
    }
    for (;;)
    {
      break;
      ((bhsd)localObject).a.setImageBitmap(localBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhrx
 * JD-Core Version:    0.7.0.1
 */