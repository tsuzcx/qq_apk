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

public class auun
  extends BaseAdapter
{
  private auun(GameRoomInviteActivity paramGameRoomInviteActivity) {}
  
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
      return (auum)this.a.jdField_a_of_type_JavaUtilList.get(paramInt);
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
    bcxb localbcxb;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.a).inflate(2131559382, paramViewGroup, false);
      paramViewGroup = new auup(this.a, null);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367048));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131367049));
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)paramView.findViewById(2131367047));
      paramViewGroup.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131367586);
      paramView.setTag(paramViewGroup);
      behr localbehr = (behr)this.a.app.a(107);
      auum localauum = (auum)this.a.jdField_a_of_type_JavaUtilList.get(paramInt);
      str = localauum.jdField_a_of_type_JavaLangString;
      if ((!((aloz)this.a.app.getManager(51)).b(((auum)this.a.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_JavaLangString)) && (!this.a.app.getCurrentAccountUin().equals(str))) {
        break label314;
      }
      localbcxb = bcxb.a(this.a.app, 1, str);
      label201:
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localbcxb);
      localbehr.a(paramViewGroup.jdField_a_of_type_AndroidWidgetTextView, str, "%s");
      if (!localauum.jdField_a_of_type_Boolean) {
        break label335;
      }
      paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(0);
      label239:
      if ((!this.a.jdField_a_of_type_Boolean) || (localauum.jdField_a_of_type_JavaLangString.equals(this.a.app.getCurrentAccountUin()))) {
        break label346;
      }
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(new auuo(this, paramInt, localbehr));
    }
    for (;;)
    {
      paramViewGroup.jdField_a_of_type_Int = 1;
      return paramView;
      paramViewGroup = (auup)paramView.getTag();
      break;
      label314:
      localbcxb = bcxb.b(this.a.app, 200, str, 3);
      break label201;
      label335:
      paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(4);
      break label239;
      label346:
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     auun
 * JD-Core Version:    0.7.0.1
 */