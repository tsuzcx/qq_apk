import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.Switch;
import java.util.ArrayList;

public class auay
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener
{
  private int jdField_a_of_type_Int = 0;
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private auaz jdField_a_of_type_Auaz;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private Switch jdField_a_of_type_ComTencentWidgetSwitch;
  private ArrayList<Button> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_a_of_type_Boolean = true;
  private Button b;
  private Button c;
  private Button d;
  private Button e;
  
  public auay(Context paramContext, QQAppInterface paramQQAppInterface, auaz paramauaz)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Auaz = paramauaz;
    d();
  }
  
  private void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      int i = 0;
      if (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        Button localButton = (Button)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        if (localButton != null)
        {
          if ((localButton.getTag() == null) || (!(localButton.getTag() instanceof Integer)) || (paramInt != ((Integer)localButton.getTag()).intValue())) {
            break label85;
          }
          a(true, localButton);
        }
        for (;;)
        {
          i += 1;
          break;
          label85:
          a(false, localButton);
        }
      }
    }
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidViewView = View.inflate(this.jdField_a_of_type_AndroidContentContext, 2131560948, null);
    View localView;
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131366353));
      localView = this.jdField_a_of_type_AndroidViewView.findViewById(2131365356);
      if (!ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null)) {
        break label313;
      }
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130844736);
      localView.setBackgroundColor(-14540254);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131364020));
      this.jdField_a_of_type_AndroidWidgetButton.setTag(Integer.valueOf(0));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_AndroidWidgetButton);
      this.c = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131363443));
      this.c.setTag(Integer.valueOf(1));
      this.c.setOnClickListener(this);
      this.jdField_a_of_type_JavaUtilArrayList.add(this.c);
      this.b = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131367235));
      this.b.setTag(Integer.valueOf(2));
      this.b.setOnClickListener(this);
      this.jdField_a_of_type_JavaUtilArrayList.add(this.b);
      this.jdField_a_of_type_ComTencentWidgetSwitch = ((Switch)this.jdField_a_of_type_AndroidViewView.findViewById(2131377316));
      this.jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(this);
      this.d = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131363909));
      this.d.setOnClickListener(this);
      this.e = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131377283));
      this.e.setOnClickListener(this);
      this.jdField_a_of_type_AndroidViewView.findViewById(2131368566).setOnClickListener(this);
      a();
      return;
      label313:
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130844735);
      localView.setBackgroundColor(-1315339);
    }
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)
    {
      QLog.e("MatchChatFilterFragment", 2, "Save Seting but bull mApp");
      return;
    }
    aqfk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Int);
    boolean bool = aqfk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).booleanValue();
    if (this.jdField_a_of_type_Boolean != bool) {
      if (this.jdField_a_of_type_Boolean) {
        break label142;
      }
    }
    label142:
    for (int i = 1;; i = 0)
    {
      azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A690", "0X800A690", i, 0, "", "", "", "");
      aqbe localaqbe = (aqbe)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(127);
      if (localaqbe == null) {
        break;
      }
      localaqbe.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), this.jdField_a_of_type_Boolean);
      return;
      QLog.i("MatchChatFilterFragment", 2, "saveSetting getMatchSwitchOpenFromSp unchanged " + bool);
      return;
    }
  }
  
  public View a()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void a()
  {
    boolean bool = aqfk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).booleanValue();
    int i = aqfk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    a(bool);
    a(i);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (this.jdField_a_of_type_ComTencentWidgetSwitch != null) {
      this.jdField_a_of_type_ComTencentWidgetSwitch.setChecked(paramBoolean);
    }
  }
  
  public void a(boolean paramBoolean, Button paramButton)
  {
    if (paramBoolean)
    {
      paramButton.setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130837724));
      paramButton.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167194));
      return;
    }
    paramButton.setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130839142));
    paramButton.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166936));
  }
  
  public boolean a(int paramInt)
  {
    if ((paramInt == 0) || (paramInt == 2) || (paramInt == 1))
    {
      a(paramInt);
      return true;
    }
    QLog.e("MatchChatFilterFragment", 2, "unknown sextype" + paramInt);
    return false;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Auaz != null) {
      this.jdField_a_of_type_Auaz.g();
    }
  }
  
  public void c()
  {
    QLog.d("TAG", 2, "filterContentView onDestroy");
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_AndroidContentContext = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131363443: 
    case 2131364020: 
    case 2131367235: 
      Object localObject = paramView.getTag();
      if ((localObject != null) && ((localObject instanceof Integer)))
      {
        a(((Integer)localObject).intValue());
        return;
      }
      QLog.e("MatchChatFilterFragment", 2, "click unknown sex type tag button :" + paramView.getId());
      return;
    case 2131377283: 
      e();
      b();
      return;
    case 2131363909: 
    case 2131368566: 
      QLog.d("MatchChatFilterFragment", 2, "cancel filter");
      b();
      return;
    }
    QLog.d("MatchChatFilterFragment", 2, "filter_content click");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     auay
 * JD-Core Version:    0.7.0.1
 */