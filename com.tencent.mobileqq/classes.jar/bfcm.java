import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.mobileqq.troop.associations.AssociatedTroopItem;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class bfcm
  implements View.OnClickListener
{
  protected long a;
  protected Context a;
  protected View a;
  protected LinearLayout a;
  protected TextView a;
  protected aofu a;
  protected bfcg a;
  protected bfco a;
  protected QQAppInterface a;
  protected FormSimpleItem a;
  protected XListView a;
  protected String a;
  protected ArrayList<AssociatedTroopItem> a;
  protected boolean a;
  protected long b;
  protected View b;
  protected String b;
  
  public bfcm(QQAppInterface paramQQAppInterface, Context paramContext, bfco parambfco, XListView paramXListView, LinearLayout paramLinearLayout, String paramString, long paramLong)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Bfco = parambfco;
    this.jdField_a_of_type_ComTencentWidgetXListView = paramXListView;
    this.jdField_a_of_type_AndroidWidgetLinearLayout = paramLinearLayout;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_a_of_type_Aofu = new bfcn(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Aofu);
    this.jdField_b_of_type_Long = 0L;
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView == null)
    {
      this.jdField_a_of_type_AndroidWidgetTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(BaseApplicationImpl.getContext().getResources().getString(2131699000));
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166996));
      this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(2, 16.0F);
      this.jdField_a_of_type_AndroidWidgetTextView.setPadding(AIOUtils.dp2px(16.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.dp2px(13.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0, AIOUtils.dp2px(5.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      this.jdField_a_of_type_AndroidWidgetTextView.setClickable(false);
    }
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      this.jdField_a_of_type_AndroidViewView = View.inflate(this.jdField_a_of_type_AndroidContentContext, 2131561603, null);
      this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130850739);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_AndroidViewView);
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
    if (this.jdField_b_of_type_AndroidViewView == null)
    {
      this.jdField_b_of_type_AndroidViewView = View.inflate(this.jdField_a_of_type_AndroidContentContext, 2131561587, null);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)this.jdField_b_of_type_AndroidViewView.findViewById(2131369195));
      a(0, 0, this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem, BaseApplicationImpl.getContext().getResources().getString(2131699008), BaseApplicationImpl.getContext().getResources().getString(2131699005), true);
      TextView localTextView = (TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131368875);
      localTextView.setBackgroundResource(2130839498);
      localTextView.setText(BaseApplicationImpl.getContext().getResources().getString(2131699002));
      localTextView.setTextColor(BaseApplicationImpl.getContext().getResources().getColor(2131167106));
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_b_of_type_AndroidViewView);
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  public void a()
  {
    if (a()) {}
    aoep localaoep;
    do
    {
      return;
      localaoep = (aoep)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER);
    } while ((localaoep == null) || (this.jdField_a_of_type_Boolean));
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Long = localaoep.a(this.jdField_a_of_type_JavaLangString, 2, this.jdField_b_of_type_JavaLangString);
  }
  
  protected void a(int paramInt)
  {
    if ((paramInt == 1) || (paramInt == 2))
    {
      if (this.jdField_a_of_type_AndroidWidgetTextView != null)
      {
        this.jdField_a_of_type_ComTencentWidgetXListView.removeHeaderView(this.jdField_a_of_type_AndroidWidgetTextView);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      boolean bool = TroopUtils.isTroopOwner(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
      if (this.jdField_a_of_type_AndroidViewView != null)
      {
        if ((bool) && (paramInt == 1))
        {
          this.jdField_a_of_type_AndroidViewView.setVisibility(0);
          bdla.b(null, "dc00898", "", this.jdField_a_of_type_JavaLangString, "0X800B4AF", "0X800B4AF", 0, 0, String.valueOf(this.jdField_a_of_type_Long), "0", "", "");
        }
      }
      else if (this.jdField_b_of_type_AndroidViewView != null)
      {
        if ((!bool) || (paramInt != 1)) {
          break label149;
        }
        this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      }
    }
    label149:
    do
    {
      return;
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      break;
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      return;
      if (this.jdField_a_of_type_AndroidWidgetTextView != null)
      {
        if (this.jdField_a_of_type_ComTencentWidgetXListView.findHeaderViewPosition(this.jdField_a_of_type_AndroidWidgetTextView) < 0) {
          this.jdField_a_of_type_ComTencentWidgetXListView.addHeaderView(this.jdField_a_of_type_AndroidWidgetTextView);
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      }
      if (this.jdField_a_of_type_Bfcg == null)
      {
        this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(null);
        this.jdField_a_of_type_Bfcg = new bfcg(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Long);
        this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Bfcg);
      }
      if (this.jdField_a_of_type_AndroidViewView != null) {
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      }
    } while (this.jdField_b_of_type_AndroidViewView == null);
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
  }
  
  protected void a(int paramInt1, int paramInt2, FormSimpleItem paramFormSimpleItem, String paramString, CharSequence paramCharSequence, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramFormSimpleItem.setTag(Integer.valueOf(paramInt1));
      paramFormSimpleItem.setOnClickListener(this);
      paramFormSimpleItem.a(true);
      switch (paramInt2)
      {
      default: 
        label60:
        paramFormSimpleItem.setRightTextColor(2);
        paramFormSimpleItem.setLeftTextColor(0);
        paramFormSimpleItem.getBackground().setAlpha(255);
        String str = paramString;
        if (paramString == null) {
          str = "";
        }
        paramFormSimpleItem.setLeftText(str);
        paramFormSimpleItem.a().setEditableFactory(QQTextBuilder.EMOCTATION_FACORY);
        if (paramCharSequence != null) {
          break;
        }
      }
    }
    for (paramString = "";; paramString = new QQText(paramCharSequence, 3))
    {
      paramFormSimpleItem.setRightText(paramString);
      return;
      paramFormSimpleItem.setTag(null);
      paramFormSimpleItem.setOnClickListener(null);
      paramFormSimpleItem.a(false);
      break;
      paramFormSimpleItem.setBgType(0);
      break label60;
      paramFormSimpleItem.setBgType(1);
      break label60;
      paramFormSimpleItem.setBgType(2);
      break label60;
      paramFormSimpleItem.setBgType(3);
      break label60;
      paramFormSimpleItem.setBackgroundColor(Color.parseColor("#00000000"));
      break label60;
    }
  }
  
  protected void a(String paramString, List<AssociatedTroopItem> paramList)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramList == null)) {}
    AssociatedTroopItem localAssociatedTroopItem;
    do
    {
      return;
      Iterator localIterator;
      while (!localIterator.hasNext()) {
        localIterator = paramList.iterator();
      }
      localAssociatedTroopItem = (AssociatedTroopItem)localIterator.next();
    } while ((TextUtils.isEmpty(localAssociatedTroopItem.uin)) || (!localAssociatedTroopItem.uin.equals(paramString)));
    paramList.remove(localAssociatedTroopItem);
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      c();
      aoep localaoep = (aoep)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER);
      if (localaoep != null)
      {
        this.jdField_a_of_type_JavaUtilArrayList.clear();
        this.jdField_b_of_type_JavaLangString = "";
        this.jdField_a_of_type_Boolean = true;
        this.jdField_b_of_type_Long = localaoep.a(this.jdField_a_of_type_JavaLangString, 2, "");
      }
    }
    do
    {
      return;
      if (TroopUtils.isTroopOwner(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin()))
      {
        c();
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
        this.jdField_b_of_type_AndroidViewView.setVisibility(0);
        bdla.b(null, "dc00898", "", this.jdField_a_of_type_JavaLangString, "0X800B4AF", "0X800B4AF", 0, 0, String.valueOf(this.jdField_a_of_type_Long), "0", "", "");
      }
      if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      this.jdField_a_of_type_JavaUtilArrayList.clear();
    } while (this.jdField_a_of_type_Bfcg == null);
    this.jdField_a_of_type_Bfcg.a(this.jdField_a_of_type_JavaUtilArrayList);
  }
  
  protected void a(boolean paramBoolean, String paramString1, int paramInt1, String paramString2, int paramInt2, List<AssociatedTroopItem> paramList, long paramLong)
  {
    this.jdField_a_of_type_Boolean = false;
    if ((TextUtils.isEmpty(paramString1)) || (!paramString1.equals(this.jdField_a_of_type_JavaLangString)) || (paramInt1 != 2) || (this.jdField_b_of_type_Long != paramLong)) {
      return;
    }
    paramInt2 = this.jdField_a_of_type_JavaUtilArrayList.size();
    this.jdField_b_of_type_JavaLangString = paramString2;
    if (paramList != null)
    {
      this.jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
      a(paramString1, this.jdField_a_of_type_JavaUtilArrayList);
    }
    if (this.jdField_a_of_type_JavaUtilArrayList.size() == 0)
    {
      if ((paramList == null) || (paramList.size() != 1)) {
        break label205;
      }
      paramInt1 = 2;
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_JavaUtilArrayList.size() > 0) && (paramInt2 == 0)) {
        bdla.b(null, "dc00898", "", this.jdField_a_of_type_JavaLangString, "0X800B4AF", "0X800B4AF", 0, 0, String.valueOf(this.jdField_a_of_type_Long), "1", "", "");
      }
      a(paramInt1);
      if (this.jdField_a_of_type_Bfcg != null) {
        this.jdField_a_of_type_Bfcg.a(this.jdField_a_of_type_JavaUtilArrayList);
      }
      if (this.jdField_a_of_type_Bfco == null) {
        break;
      }
      this.jdField_a_of_type_Bfco.a(this.jdField_a_of_type_JavaUtilArrayList.size());
      return;
      paramInt1 = 3;
      continue;
      label205:
      paramInt1 = 1;
    }
  }
  
  protected boolean a()
  {
    return TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString);
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_a_of_type_Aofu != null)) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Aofu);
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem)
    {
      bfcp.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString);
      bdla.b(null, "dc00898", "", this.jdField_a_of_type_JavaLangString, "0X800B4B0", "0X800B4B0", 0, 0, String.valueOf(this.jdField_a_of_type_Long), "", "", "");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfcm
 * JD-Core Version:    0.7.0.1
 */