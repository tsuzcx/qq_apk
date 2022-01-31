import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.gameroom.GameRoomInviteActivity;
import java.util.List;

public class ashi
  extends BaseAdapter
{
  private ashi(GameRoomInviteActivity paramGameRoomInviteActivity) {}
  
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
      return (ashh)this.a.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    String str;
    azwp localazwp;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.a).inflate(2131493760, paramViewGroup, false);
      paramViewGroup = new ashk(this.a, null);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131301320));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131301321));
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)paramView.findViewById(2131301319));
      paramViewGroup.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131301846);
      paramView.setTag(paramViewGroup);
      bbfc localbbfc = (bbfc)this.a.app.a(107);
      ashh localashh = (ashh)this.a.jdField_a_of_type_JavaUtilList.get(paramInt);
      str = localashh.jdField_a_of_type_JavaLangString;
      if ((!((ajjj)this.a.app.getManager(51)).b(((ashh)this.a.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_JavaLangString)) && (!this.a.app.getCurrentAccountUin().equals(str))) {
        break label314;
      }
      localazwp = azwp.a(this.a.app, 1, str);
      label201:
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localazwp);
      localbbfc.a(paramViewGroup.jdField_a_of_type_AndroidWidgetTextView, str, "%s");
      if (!localashh.jdField_a_of_type_Boolean) {
        break label335;
      }
      paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(0);
      label239:
      if ((!this.a.jdField_a_of_type_Boolean) || (localashh.jdField_a_of_type_JavaLangString.equals(this.a.app.getCurrentAccountUin()))) {
        break label346;
      }
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(new ashj(this, paramInt, localbbfc));
    }
    for (;;)
    {
      paramViewGroup.jdField_a_of_type_Int = 1;
      return paramView;
      paramViewGroup = (ashk)paramView.getTag();
      break;
      label314:
      localazwp = azwp.b(this.a.app, 200, str, 3);
      break label201;
      label335:
      paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(4);
      break label239;
      label346:
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ashi
 * JD-Core Version:    0.7.0.1
 */