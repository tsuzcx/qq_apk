import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.nearby.gameroom.GameRoomInviteActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class axsi
  extends BaseAdapter
{
  private axsi(GameRoomInviteActivity paramGameRoomInviteActivity) {}
  
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
      return (axsh)this.a.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    axsk localaxsk;
    String str;
    FaceDrawable localFaceDrawable;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.a).inflate(2131559537, paramViewGroup, false);
      localaxsk = new axsk(this.a, null);
      localaxsk.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367551));
      localaxsk.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131367552));
      localaxsk.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)paramView.findViewById(2131367550));
      localaxsk.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131368142);
      paramView.setTag(localaxsk);
      bikt localbikt = (bikt)this.a.app.getBusinessHandler(BusinessHandlerFactory.WEREWOLVES_HANDLER);
      axsh localaxsh = (axsh)this.a.jdField_a_of_type_JavaUtilList.get(paramInt);
      str = localaxsh.jdField_a_of_type_JavaLangString;
      if ((!((anvk)this.a.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(((axsh)this.a.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_JavaLangString)) && (!this.a.app.getCurrentAccountUin().equals(str))) {
        break label343;
      }
      localFaceDrawable = FaceDrawable.getFaceDrawable(this.a.app, 1, str);
      label209:
      localaxsk.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localFaceDrawable);
      localbikt.a(localaxsk.jdField_a_of_type_AndroidWidgetTextView, str, "%s");
      if (!localaxsh.jdField_a_of_type_Boolean) {
        break label364;
      }
      localaxsk.jdField_a_of_type_AndroidViewView.setVisibility(0);
      label250:
      if ((!this.a.jdField_a_of_type_Boolean) || (localaxsh.jdField_a_of_type_JavaLangString.equals(this.a.app.getCurrentAccountUin()))) {
        break label376;
      }
      localaxsk.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
      localaxsk.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(new axsj(this, paramInt, localbikt));
    }
    for (;;)
    {
      localaxsk.jdField_a_of_type_Int = 1;
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
      localaxsk = (axsk)paramView.getTag();
      break;
      label343:
      localFaceDrawable = FaceDrawable.getStrangerFaceDrawable(this.a.app, 200, str, 3);
      break label209;
      label364:
      localaxsk.jdField_a_of_type_AndroidViewView.setVisibility(4);
      break label250;
      label376:
      localaxsk.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axsi
 * JD-Core Version:    0.7.0.1
 */