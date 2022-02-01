import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.richstatus.NoScrollGridView;
import com.tencent.mobileqq.theme.ThemeUtil;
import java.util.ArrayList;
import java.util.List;

public class bgnz
  extends bgny
{
  protected List<bgop> a;
  protected int b = (((WindowManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("window")).getDefaultDisplay().getWidth() - agej.a(16.0F, this.jdField_a_of_type_AndroidContentContext.getResources()) - agej.a(16.0F, this.jdField_a_of_type_AndroidContentContext.getResources()) - agej.a(13.0F, this.jdField_a_of_type_AndroidContentContext.getResources()) * 3) / 4;
  protected boolean c = ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null);
  
  public bgnz(Context paramContext, QQAppInterface paramQQAppInterface, FragmentActivity paramFragmentActivity, Bundle paramBundle)
  {
    super(paramContext, paramQQAppInterface, paramFragmentActivity, null, paramBundle);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public int a()
  {
    return 1;
  }
  
  public View a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramViewGroup = new bgoc();
      paramView = new NoScrollGridView(this.jdField_a_of_type_AndroidContentContext);
      paramView.setNumColumns(4);
      paramView.setVerticalSpacing(agej.a(10.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      paramView.setHorizontalSpacing(agej.a(13.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      paramView.setPadding(agej.a(16.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), agej.a(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), agej.a(16.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), agej.a(20.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      paramView.setColumnWidth(this.b);
      paramView.setSelector(new ColorDrawable(0));
      paramView.setVerticalScrollBarEnabled(false);
      paramView.setStretchMode(0);
      paramViewGroup.a = new bgoa(this, this.b);
      paramViewGroup.a.a(this.jdField_a_of_type_JavaUtilList);
      paramView.setAdapter(paramViewGroup.a);
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      paramView.setClickable(false);
      return paramView;
      ((bgoc)paramView.getTag()).a.a(this.jdField_a_of_type_JavaUtilList);
    }
  }
  
  public Object a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a(Object paramObject)
  {
    if ((paramObject instanceof ArrayList)) {
      this.jdField_a_of_type_JavaUtilList = ((List)paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgnz
 * JD-Core Version:    0.7.0.1
 */