import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.homework.recite.ui.ReciteFragment;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.recite.HWReciteItem;
import java.util.List;
import org.json.JSONObject;

public class bada
  extends badf
{
  private TextView a;
  private TextView b;
  
  protected bada(View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378315));
    this.b = ((TextView)paramView.findViewById(2131378206));
  }
  
  public void a(View paramView, HWReciteItem paramHWReciteItem, badd parambadd)
  {
    paramHWReciteItem = (babi)parambadd.a;
    switch (paramView.getId())
    {
    }
    do
    {
      return;
      ReciteFragment.a(paramView.getContext(), paramHWReciteItem.a().toString(), paramHWReciteItem.jdField_c_of_type_Int);
      paramView = BaseApplicationImpl.getApplication().getRuntime();
    } while (!(paramView instanceof QQAppInterface));
    bbbp.a((QQAppInterface)paramView, paramHWReciteItem.f, "Grp_recite", "Recite_Clk", 0, 0, new String[] { paramHWReciteItem.f, "", paramHWReciteItem.b, "" });
  }
  
  public void a(HWReciteItem paramHWReciteItem, badd parambadd, babi parambabi, int paramInt)
  {
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    if (TextUtils.isEmpty(parambabi.jdField_c_of_type_JavaLangString))
    {
      StringBuilder localStringBuilder = new StringBuilder(ajya.a(2131705315)).append(parambabi.b);
      if ((parambabi.a != null) && (!parambabi.a.isEmpty())) {
        localStringBuilder.append(baam.a(parambabi.a));
      }
      parambabi.jdField_c_of_type_JavaLangString = localStringBuilder.toString();
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(parambabi.jdField_c_of_type_JavaLangString);
    paramHWReciteItem.b(this.jdField_a_of_type_AndroidViewView, parambadd);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bada
 * JD-Core Version:    0.7.0.1
 */