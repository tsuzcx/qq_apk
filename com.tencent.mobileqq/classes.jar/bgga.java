import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.homework.recite.ui.ReciteFragment;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.recite.HWReciteItem;
import java.util.List;
import org.json.JSONObject;

public class bgga
  extends bggf
{
  private TextView a;
  private TextView b;
  
  protected bgga(View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380031));
    this.b = ((TextView)paramView.findViewById(2131379882));
  }
  
  public void a(View paramView, HWReciteItem paramHWReciteItem, bggd parambggd)
  {
    paramHWReciteItem = (bgei)parambggd.a;
    switch (paramView.getId())
    {
    }
    do
    {
      return;
      ReciteFragment.a(paramView.getContext(), paramHWReciteItem.a().toString(), paramHWReciteItem.jdField_c_of_type_Int);
      paramView = BaseApplicationImpl.getApplication().getRuntime();
    } while (!(paramView instanceof QQAppInterface));
    bhju.a((QQAppInterface)paramView, paramHWReciteItem.f, "Grp_recite", "Recite_Clk", 0, 0, new String[] { paramHWReciteItem.f, "", paramHWReciteItem.b, "" });
  }
  
  public void a(HWReciteItem paramHWReciteItem, bggd parambggd, bgei parambgei, int paramInt)
  {
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    if (TextUtils.isEmpty(parambgei.jdField_c_of_type_JavaLangString))
    {
      StringBuilder localStringBuilder = new StringBuilder(anzj.a(2131704198)).append(parambgei.b);
      if ((parambgei.a != null) && (!parambgei.a.isEmpty())) {
        localStringBuilder.append(bgdm.a(parambgei.a));
      }
      parambgei.jdField_c_of_type_JavaLangString = localStringBuilder.toString();
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(parambgei.jdField_c_of_type_JavaLangString);
    paramHWReciteItem.b(this.jdField_a_of_type_AndroidViewView, parambggd);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgga
 * JD-Core Version:    0.7.0.1
 */