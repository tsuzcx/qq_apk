import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.homework.recite.ui.ReciteFragment;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.recite.HWReciteItem;
import java.util.List;
import org.json.JSONObject;

public class bcbj
  extends bcbo
{
  private TextView a;
  private TextView b;
  
  protected bcbj(View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378900));
    this.b = ((TextView)paramView.findViewById(2131378773));
  }
  
  public void a(View paramView, HWReciteItem paramHWReciteItem, bcbm parambcbm)
  {
    paramHWReciteItem = (bbzr)parambcbm.a;
    switch (paramView.getId())
    {
    }
    do
    {
      return;
      ReciteFragment.a(paramView.getContext(), paramHWReciteItem.a().toString(), paramHWReciteItem.jdField_c_of_type_Int);
      paramView = BaseApplicationImpl.getApplication().getRuntime();
    } while (!(paramView instanceof QQAppInterface));
    bdaj.a((QQAppInterface)paramView, paramHWReciteItem.f, "Grp_recite", "Recite_Clk", 0, 0, new String[] { paramHWReciteItem.f, "", paramHWReciteItem.b, "" });
  }
  
  public void a(HWReciteItem paramHWReciteItem, bcbm parambcbm, bbzr parambbzr, int paramInt)
  {
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    if (TextUtils.isEmpty(parambbzr.jdField_c_of_type_JavaLangString))
    {
      StringBuilder localStringBuilder = new StringBuilder(alpo.a(2131705687)).append(parambbzr.b);
      if ((parambbzr.a != null) && (!parambbzr.a.isEmpty())) {
        localStringBuilder.append(bbyv.a(parambbzr.a));
      }
      parambbzr.jdField_c_of_type_JavaLangString = localStringBuilder.toString();
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(parambbzr.jdField_c_of_type_JavaLangString);
    paramHWReciteItem.b(this.jdField_a_of_type_AndroidViewView, parambcbm);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcbj
 * JD-Core Version:    0.7.0.1
 */