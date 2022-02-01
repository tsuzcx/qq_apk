import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.data.RecommendTroopItem;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import java.util.ArrayList;

public class betm
  extends aiid
{
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  View jdField_a_of_type_AndroidViewView;
  ArrayList<RecommendTroopItem> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  boolean jdField_a_of_type_Boolean = false;
  TextView b;
  
  public betm(QQAppInterface paramQQAppInterface, Context paramContext, XListView paramXListView, aiig paramaiig, String paramString, boolean paramBoolean, TextView paramTextView, View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentWidgetXListView = paramXListView;
    this.jdField_a_of_type_Aiig = paramaiig;
    this.e = false;
    this.c = paramBoolean;
    this.b = paramTextView;
    this.jdField_a_of_type_AndroidViewView = paramView;
    try
    {
      this.jdField_a_of_type_Long = Long.parseLong(paramString);
      d();
      return;
    }
    catch (NumberFormatException paramQQAppInterface)
    {
      for (;;)
      {
        QLog.d("TroopDataCardRecomTroopListWrapper", 1, "TroopDataCardRecomTroopListWrapper NumberFormatException ", paramQQAppInterface);
      }
    }
  }
  
  protected aihx a()
  {
    return new betl(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true);
  }
  
  public void a()
  {
    if (this.c)
    {
      this.c = false;
      b();
    }
  }
  
  protected void a(boolean paramBoolean1, long paramLong, int paramInt, boolean paramBoolean2, ArrayList<RecommendTroopItem> paramArrayList)
  {
    int i = this.jdField_a_of_type_JavaUtilArrayList.size();
    int j = paramArrayList.size();
    if (QLog.isColorLevel()) {
      QLog.d("TroopDataCardRecomTroopListWrapper", 2, "onGetTroopDataCardRecommendTroopList isSuccess = " + paramBoolean1 + ",troopUIN = " + paramLong + ",serverPageID = " + paramInt + ",dataListSize = " + i + ",newDataListSize = " + j);
    }
    this.jdField_a_of_type_Boolean = paramBoolean2;
    if ((paramBoolean1) && (this.jdField_a_of_type_Long == paramLong))
    {
      if (j + i < 50) {
        break label221;
      }
      this.jdField_a_of_type_JavaUtilArrayList.addAll(paramArrayList.subList(0, 50 - i));
      this.jdField_a_of_type_Boolean = true;
      if (QLog.isColorLevel()) {
        QLog.d("TroopDataCardRecomTroopListWrapper", 2, "onGetTroopDataCardRecommendTroopList reach limit,this.dataList.size() = " + this.jdField_a_of_type_JavaUtilArrayList.size());
      }
    }
    for (;;)
    {
      b();
      if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        if (this.jdField_a_of_type_Boolean) {
          this.jdField_a_of_type_AndroidWidgetTextView.setText("没有更多内容了");
        }
      }
      this.jdField_a_of_type_Int = paramInt;
      return;
      label221:
      this.jdField_a_of_type_JavaUtilArrayList.addAll(paramArrayList);
    }
  }
  
  protected boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  protected void b()
  {
    if (!this.c) {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
    }
    this.jdField_a_of_type_Aihx.a(this.jdField_a_of_type_JavaUtilArrayList);
    this.jdField_a_of_type_Aihx.notifyDataSetChanged();
    if (QLog.isColorLevel()) {
      QLog.d("TroopDataCardRecomTroopListWrapper", 2, "refreshListView,this.dataList.size() = " + this.jdField_a_of_type_JavaUtilArrayList.size());
    }
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
    {
      this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(0);
      this.b.setVisibility(0);
      return;
    }
    this.b.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  protected void b(boolean paramBoolean)
  {
    ((anca)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(20)).a(this.jdField_a_of_type_Long, this.jdField_a_of_type_Int, 25);
  }
  
  protected void d()
  {
    super.d();
    if (this.c)
    {
      this.jdField_a_of_type_ComTencentWidgetXListView.addHeaderView(this.b);
      this.b.setVisibility(8);
    }
    this.jdField_a_of_type_ComTencentWidgetXListView.addFooterView(this.jdField_a_of_type_AndroidViewView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     betm
 * JD-Core Version:    0.7.0.1
 */