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

public class axyy
  extends BaseAdapter
{
  private axyy(GameRoomInviteActivity paramGameRoomInviteActivity) {}
  
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
      return (axyx)this.a.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    axza localaxza;
    String str;
    aoot localaoot;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.a).inflate(2131559502, paramViewGroup, false);
      localaxza = new axza(this.a, null);
      localaxza.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367392));
      localaxza.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131367393));
      localaxza.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)paramView.findViewById(2131367391));
      localaxza.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131367974);
      paramView.setTag(localaxza);
      bitz localbitz = (bitz)this.a.app.a(107);
      axyx localaxyx = (axyx)this.a.jdField_a_of_type_JavaUtilList.get(paramInt);
      str = localaxyx.jdField_a_of_type_JavaLangString;
      if ((!((anyw)this.a.app.getManager(51)).b(((axyx)this.a.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_JavaLangString)) && (!this.a.app.getCurrentAccountUin().equals(str))) {
        break label341;
      }
      localaoot = aoot.a(this.a.app, 1, str);
      label207:
      localaxza.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localaoot);
      localbitz.a(localaxza.jdField_a_of_type_AndroidWidgetTextView, str, "%s");
      if (!localaxyx.jdField_a_of_type_Boolean) {
        break label362;
      }
      localaxza.jdField_a_of_type_AndroidViewView.setVisibility(0);
      label248:
      if ((!this.a.jdField_a_of_type_Boolean) || (localaxyx.jdField_a_of_type_JavaLangString.equals(this.a.app.getCurrentAccountUin()))) {
        break label374;
      }
      localaxza.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
      localaxza.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(new axyz(this, paramInt, localbitz));
    }
    for (;;)
    {
      localaxza.jdField_a_of_type_Int = 1;
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
      localaxza = (axza)paramView.getTag();
      break;
      label341:
      localaoot = aoot.b(this.a.app, 200, str, 3);
      break label207;
      label362:
      localaxza.jdField_a_of_type_AndroidViewView.setVisibility(4);
      break label248;
      label374:
      localaxza.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axyy
 * JD-Core Version:    0.7.0.1
 */