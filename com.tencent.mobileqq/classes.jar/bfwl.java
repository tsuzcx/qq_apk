import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.homework.recite.ui.ReciteFragment;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.recite.HWReciteItem;
import java.util.List;
import org.json.JSONObject;

public class bfwl
  extends bfwq
{
  private TextView a;
  private TextView b;
  
  protected bfwl(View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380111));
    this.b = ((TextView)paramView.findViewById(2131379965));
  }
  
  public void a(View paramView, HWReciteItem paramHWReciteItem, bfwo parambfwo)
  {
    paramHWReciteItem = (bfut)parambfwo.a;
    switch (paramView.getId())
    {
    }
    do
    {
      return;
      ReciteFragment.a(paramView.getContext(), paramHWReciteItem.a().toString(), paramHWReciteItem.jdField_c_of_type_Int);
      paramView = BaseApplicationImpl.getApplication().getRuntime();
    } while (!(paramView instanceof QQAppInterface));
    bhbu.a((QQAppInterface)paramView, paramHWReciteItem.f, "Grp_recite", "Recite_Clk", 0, 0, new String[] { paramHWReciteItem.f, "", paramHWReciteItem.b, "" });
  }
  
  public void a(HWReciteItem paramHWReciteItem, bfwo parambfwo, bfut parambfut, int paramInt)
  {
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    if (TextUtils.isEmpty(parambfut.jdField_c_of_type_JavaLangString))
    {
      StringBuilder localStringBuilder = new StringBuilder(anvx.a(2131704778)).append(parambfut.b);
      if ((parambfut.a != null) && (!parambfut.a.isEmpty())) {
        localStringBuilder.append(bftx.a(parambfut.a));
      }
      parambfut.jdField_c_of_type_JavaLangString = localStringBuilder.toString();
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(parambfut.jdField_c_of_type_JavaLangString);
    paramHWReciteItem.b(this.jdField_a_of_type_AndroidViewView, parambfwo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfwl
 * JD-Core Version:    0.7.0.1
 */