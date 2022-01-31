import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.MeasureListView;
import com.tencent.widget.AbsListView.LayoutParams;
import java.util.List;

public class awix
  extends awhg<View>
{
  protected aipd a;
  private Context jdField_a_of_type_AndroidContentContext;
  protected View a;
  protected ImageView a;
  public RelativeLayout a;
  protected TextView a;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  protected MeasureListView a;
  protected int b;
  private TextView b;
  private TextView c;
  private TextView d;
  private TextView e;
  
  public awix(int paramInt)
  {
    super(paramInt);
    this.jdField_b_of_type_Int = paramInt;
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_Aipd != null) {
      this.jdField_a_of_type_Aipd.a();
    }
  }
  
  public View a(Context paramContext, QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559611, null);
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetMeasureListView = ((MeasureListView)this.jdField_a_of_type_AndroidViewView.findViewById(2131367535));
    this.jdField_a_of_type_ComTencentMobileqqWidgetMeasureListView.setDivider(null);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131375713));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131365004));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131365005));
    paramViewGroup = new AbsListView.LayoutParams(-1, bawz.a(this.jdField_a_of_type_AndroidContentContext, 7.0F));
    this.jdField_b_of_type_AndroidWidgetTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_b_of_type_AndroidWidgetTextView.setLayoutParams(paramViewGroup);
    paramViewGroup = (LinearLayout)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131562369, null);
    this.c = ((TextView)paramViewGroup.findViewById(2131363393));
    this.d = ((TextView)paramViewGroup.findViewById(2131363394));
    this.e = ((TextView)paramViewGroup.findViewById(2131363395));
    this.jdField_a_of_type_ComTencentMobileqqWidgetMeasureListView.addHeaderView(this.jdField_b_of_type_AndroidWidgetTextView);
    this.jdField_a_of_type_ComTencentMobileqqWidgetMeasureListView.addFooterView(paramViewGroup);
    boolean bool = ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime());
    this.jdField_b_of_type_AndroidWidgetTextView.setBackgroundResource(2130849133);
    if (bool) {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841808);
    }
    this.jdField_a_of_type_Aipd = new aipd(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidViewView, this.jdField_b_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqWidgetMeasureListView.setOnTouchListener(new awiy(this));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new awiz(this, paramContext, paramQQAppInterface));
    paramContext = ((akgd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(299)).a();
    if (!paramContext.isEmpty())
    {
      paramQQAppInterface = new StringBuilder("");
      int i = 0;
      if (i < paramContext.size())
      {
        if (i != paramContext.size() - 1) {
          paramQQAppInterface.append((String)paramContext.get(i)).append("::");
        }
        for (;;)
        {
          i += 1;
          break;
          paramQQAppInterface.append((String)paramContext.get(i));
        }
      }
      awso.a(null, new ReportModelDC02528().module("all_result").action("exp_search_his").ver2(awso.a(this.jdField_b_of_type_Int)).ver4(paramQQAppInterface.toString()).ver7("{experiment_id:" + awso.b + "}"));
    }
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_ComTencentMobileqqWidgetMeasureListView.setAdapter(this.jdField_a_of_type_Aipd);
    d();
  }
  
  public void b()
  {
    super.b();
    if (this.jdField_a_of_type_Aipd != null) {
      this.jdField_a_of_type_Aipd = null;
    }
  }
  
  public void c()
  {
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awix
 * JD-Core Version:    0.7.0.1
 */