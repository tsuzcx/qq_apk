import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.gameroom.GameRoomInviteActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class axgf
  extends BaseAdapter
{
  private axgf(GameRoomInviteActivity paramGameRoomInviteActivity) {}
  
  public int getCount()
  {
    if (this.a.jdField_a_of_type_JavaUtilList == null) {}
    for (int i = 0;; i = this.a.jdField_a_of_type_JavaUtilList.size()) {
      return Math.min(i, this.a.jdField_a_of_type_Int);
    }
  }
  
  public Object getItem(int paramInt)
  {
    if (this.a.jdField_a_of_type_JavaUtilList != null) {
      return (axge)this.a.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    axgh localaxgh;
    String str;
    aoch localaoch;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.a).inflate(2131559497, paramViewGroup, false);
      localaxgh = new axgh(this.a, null);
      localaxgh.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367333));
      localaxgh.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131367334));
      localaxgh.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)paramView.findViewById(2131367332));
      localaxgh.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131367904);
      paramView.setTag(localaxgh);
      bhte localbhte = (bhte)this.a.app.a(107);
      axge localaxge = (axge)this.a.jdField_a_of_type_JavaUtilList.get(paramInt);
      str = localaxge.jdField_a_of_type_JavaLangString;
      if ((!((anmw)this.a.app.getManager(51)).b(((axge)this.a.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_JavaLangString)) && (!this.a.app.getCurrentAccountUin().equals(str))) {
        break label341;
      }
      localaoch = aoch.a(this.a.app, 1, str);
      label207:
      localaxgh.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localaoch);
      localbhte.a(localaxgh.jdField_a_of_type_AndroidWidgetTextView, str, "%s");
      if (!localaxge.jdField_a_of_type_Boolean) {
        break label362;
      }
      localaxgh.jdField_a_of_type_AndroidViewView.setVisibility(0);
      label248:
      if ((!this.a.jdField_a_of_type_Boolean) || (localaxge.jdField_a_of_type_JavaLangString.equals(this.a.app.getCurrentAccountUin()))) {
        break label374;
      }
      localaxgh.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
      localaxgh.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(new axgg(this, paramInt, localbhte));
    }
    for (;;)
    {
      localaxgh.jdField_a_of_type_Int = 1;
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
      localaxgh = (axgh)paramView.getTag();
      break;
      label341:
      localaoch = aoch.b(this.a.app, 200, str, 3);
      break label207;
      label362:
      localaxgh.jdField_a_of_type_AndroidViewView.setVisibility(4);
      break label248;
      label374:
      localaxgh.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axgf
 * JD-Core Version:    0.7.0.1
 */