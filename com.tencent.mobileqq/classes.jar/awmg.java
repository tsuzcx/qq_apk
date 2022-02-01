import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.nearby.gameroom.GameRoomInviteActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class awmg
  extends BaseAdapter
{
  private awmg(GameRoomInviteActivity paramGameRoomInviteActivity) {}
  
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
      return (awmf)this.a.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    awmi localawmi;
    String str;
    FaceDrawable localFaceDrawable;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.a).inflate(2131559504, paramViewGroup, false);
      localawmi = new awmi(this.a, null);
      localawmi.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367420));
      localawmi.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131367421));
      localawmi.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)paramView.findViewById(2131367419));
      localawmi.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131368007);
      paramView.setTag(localawmi);
      bhab localbhab = (bhab)this.a.app.getBusinessHandler(107);
      awmf localawmf = (awmf)this.a.jdField_a_of_type_JavaUtilList.get(paramInt);
      str = localawmf.jdField_a_of_type_JavaLangString;
      if ((!((amsw)this.a.app.getManager(51)).b(((awmf)this.a.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_JavaLangString)) && (!this.a.app.getCurrentAccountUin().equals(str))) {
        break label341;
      }
      localFaceDrawable = FaceDrawable.getFaceDrawable(this.a.app, 1, str);
      label207:
      localawmi.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localFaceDrawable);
      localbhab.a(localawmi.jdField_a_of_type_AndroidWidgetTextView, str, "%s");
      if (!localawmf.jdField_a_of_type_Boolean) {
        break label362;
      }
      localawmi.jdField_a_of_type_AndroidViewView.setVisibility(0);
      label248:
      if ((!this.a.jdField_a_of_type_Boolean) || (localawmf.jdField_a_of_type_JavaLangString.equals(this.a.app.getCurrentAccountUin()))) {
        break label374;
      }
      localawmi.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
      localawmi.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(new awmh(this, paramInt, localbhab));
    }
    for (;;)
    {
      localawmi.jdField_a_of_type_Int = 1;
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
      localawmi = (awmi)paramView.getTag();
      break;
      label341:
      localFaceDrawable = FaceDrawable.getStrangerFaceDrawable(this.a.app, 200, str, 3);
      break label207;
      label362:
      localawmi.jdField_a_of_type_AndroidViewView.setVisibility(4);
      break label248;
      label374:
      localawmi.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awmg
 * JD-Core Version:    0.7.0.1
 */