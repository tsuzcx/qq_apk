import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class aukl
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, bkzr
{
  private final aukd jdField_a_of_type_Aukd;
  private final auke jdField_a_of_type_Auke;
  private bkzi jdField_a_of_type_Bkzi;
  private final FormSimpleItem jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private final FormSwitchItem jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private final List<String> jdField_a_of_type_JavaUtilList;
  private final boolean jdField_a_of_type_Boolean;
  private final FormSimpleItem jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private final FormSwitchItem jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  
  public aukl(aukd paramaukd, View paramView, boolean paramBoolean)
  {
    this.jdField_a_of_type_Aukd = paramaukd;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Auke = new auke();
    paramaukd = BaseApplicationImpl.sApplication;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilList.add(paramaukd.getString(2131697943));
    this.jdField_a_of_type_JavaUtilList.add(paramaukd.getString(2131697942));
    this.jdField_a_of_type_JavaUtilList.add(paramaukd.getString(2131697944));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)paramView.findViewById(2131377486));
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
    if (this.jdField_a_of_type_Boolean)
    {
      i = 2131697945;
      ((FormSimpleItem)localObject).setLeftText(paramaukd.getString(i));
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText((CharSequence)this.jdField_a_of_type_JavaUtilList.get(a()));
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)paramView.findViewById(2131377485));
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)paramView.findViewById(2131377498));
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(this.jdField_a_of_type_Auke.jdField_a_of_type_Boolean);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
      b(false);
      localObject = (TextView)paramView.findViewById(2131377500);
      if (!this.jdField_a_of_type_Boolean) {
        break label333;
      }
    }
    label333:
    for (int i = 2131697948;; i = 2131697947)
    {
      ((TextView)localObject).setText(paramaukd.getString(i));
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)paramView.findViewById(2131377483));
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(this.jdField_a_of_type_Auke.b);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
      paramView.findViewById(2131377484).setVisibility(8);
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setBgType(0);
      }
      return;
      i = 2131697941;
      break;
    }
  }
  
  private int a()
  {
    int i = 1;
    if (this.jdField_a_of_type_Auke.jdField_a_of_type_Int == 1) {
      i = 0;
    }
    while (this.jdField_a_of_type_Auke.jdField_a_of_type_Int == 2) {
      return i;
    }
    return 2;
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_Bkzi == null)
    {
      this.jdField_a_of_type_Bkzi = ((bkzi)bkzz.b(this.jdField_a_of_type_Aukd.a(), null));
      Object localObject = this.jdField_a_of_type_Bkzi;
      if (this.jdField_a_of_type_Boolean) {}
      for (int i = 2131697945;; i = 2131697941)
      {
        ((bkzi)localObject).a(i);
        localObject = this.jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          this.jdField_a_of_type_Bkzi.a(str, false);
        }
      }
      this.jdField_a_of_type_Bkzi.c(2131690697);
      this.jdField_a_of_type_Bkzi.a(this);
    }
    this.jdField_a_of_type_Bkzi.d();
    this.jdField_a_of_type_Bkzi.d(a());
    if (!this.jdField_a_of_type_Bkzi.isShowing()) {
      this.jdField_a_of_type_Bkzi.show();
    }
  }
  
  private void b(boolean paramBoolean)
  {
    FormSimpleItem localFormSimpleItem = this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem;
    auke localauke = this.jdField_a_of_type_Auke;
    Object localObject;
    if (this.jdField_a_of_type_Auke.jdField_a_of_type_Boolean)
    {
      localObject = aukf.a(6);
      localauke.jdField_a_of_type_JavaLangString = ((String)localObject);
      localFormSimpleItem.setRightText((CharSequence)localObject);
      localObject = this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem;
      if (!this.jdField_a_of_type_Auke.jdField_a_of_type_Boolean) {
        break label104;
      }
      i = 0;
      label57:
      ((FormSimpleItem)localObject).setVisibility(i);
      localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
      if (!this.jdField_a_of_type_Auke.jdField_a_of_type_Boolean) {
        break label110;
      }
    }
    label104:
    label110:
    for (int i = 2;; i = 3)
    {
      ((FormSwitchItem)localObject).setBgType(i);
      if (paramBoolean) {
        this.jdField_a_of_type_Aukd.a();
      }
      return;
      localObject = "";
      break;
      i = 8;
      break label57;
    }
  }
  
  public auke a()
  {
    return this.jdField_a_of_type_Auke;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Bkzi != null)
    {
      this.jdField_a_of_type_Bkzi.e();
      this.jdField_a_of_type_Bkzi = null;
    }
  }
  
  public void a(View paramView, int paramInt, String paramString)
  {
    int i = 1;
    if ((this.jdField_a_of_type_Bkzi != null) && (this.jdField_a_of_type_Bkzi.isShowing())) {
      this.jdField_a_of_type_Bkzi.dismiss();
    }
    if (paramInt == 0)
    {
      paramInt = 1;
      if (paramInt == this.jdField_a_of_type_Auke.jdField_a_of_type_Int) {
        break label90;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Auke.jdField_a_of_type_Int = paramInt;
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(paramString);
      if (i != 0) {
        this.jdField_a_of_type_Aukd.a();
      }
      return;
      if (paramInt == 1)
      {
        paramInt = 2;
        break;
      }
      paramInt = 3;
      break;
      label90:
      i = 0;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setEnabled(paramBoolean);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setEnabled(paramBoolean);
    }
    if (this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem != null) {
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setEnabled(paramBoolean);
    }
    if (this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem != null) {
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setEnabled(paramBoolean);
    }
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    int i = 1;
    boolean bool = true;
    if (paramCompoundButton.equals(this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a())) {
      if (this.jdField_a_of_type_Auke.jdField_a_of_type_Boolean != paramBoolean)
      {
        this.jdField_a_of_type_Auke.jdField_a_of_type_Boolean = paramBoolean;
        b(bool);
      }
    }
    while (!paramCompoundButton.equals(this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.a())) {
      for (;;)
      {
        EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
        return;
        bool = false;
      }
    }
    if (this.jdField_a_of_type_Auke.b != paramBoolean) {}
    for (;;)
    {
      this.jdField_a_of_type_Auke.b = paramBoolean;
      if (i == 0) {
        break;
      }
      this.jdField_a_of_type_Aukd.a();
      break;
      i = 0;
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aukl
 * JD-Core Version:    0.7.0.1
 */