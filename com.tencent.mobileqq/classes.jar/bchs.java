import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.activity.contacts.view.IndexBar;
import com.tencent.mobileqq.activity.contacts.view.IndexBarTipsLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;

public class bchs
  implements ahve
{
  public Context a;
  private final View jdField_a_of_type_AndroidViewView;
  public bchv a;
  public IndexBar a;
  public IndexBarTipsLayout a;
  public QQAppInterface a;
  public XListView a;
  private String jdField_a_of_type_JavaLangString = "";
  
  public bchs(QQAppInterface paramQQAppInterface, Context paramContext, TroopChatPie paramTroopChatPie, View paramView, XListView paramXListView)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_ComTencentWidgetXListView = paramXListView;
    this.jdField_a_of_type_Bchv = new bchv(this, paramTroopChatPie);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Bchv);
    a();
  }
  
  private void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewIndexBarTipsLayout = ((IndexBarTipsLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131368224));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewIndexBar = ((IndexBar)this.jdField_a_of_type_AndroidViewView.findViewById(2131368223));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewIndexBar.setOnIndexBarTouchListener(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewIndexBarTipsLayout.setVisibility(8);
  }
  
  public void a(String paramString, int paramInt, float paramFloat)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewIndexBarTipsLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewIndexBarTipsLayout.setText(paramString, paramFloat);
    }
    if (!this.jdField_a_of_type_JavaLangString.equals(paramString))
    {
      this.jdField_a_of_type_JavaLangString = paramString;
      if (!"★".equals(paramString)) {
        break label50;
      }
      this.jdField_a_of_type_ComTencentWidgetXListView.setSelection(0);
    }
    label50:
    do
    {
      return;
      paramInt = this.jdField_a_of_type_Bchv.a(paramString);
    } while (paramInt == -1);
    this.jdField_a_of_type_ComTencentWidgetXListView.setSelection(paramInt + this.jdField_a_of_type_ComTencentWidgetXListView.getHeaderViewsCount());
  }
  
  public void c(boolean paramBoolean)
  {
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.d("ListViewWrapper", 2, new Object[] { "onLetterTouching: invoked. ", " touching: ", Boolean.valueOf(paramBoolean) });
    }
    if (!paramBoolean) {
      this.jdField_a_of_type_JavaLangString = "";
    }
    IndexBarTipsLayout localIndexBarTipsLayout;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewIndexBarTipsLayout != null)
    {
      localIndexBarTipsLayout = this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewIndexBarTipsLayout;
      if (!paramBoolean) {
        break label67;
      }
    }
    for (;;)
    {
      localIndexBarTipsLayout.setVisibility(i);
      return;
      label67:
      i = 8;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bchs
 * JD-Core Version:    0.7.0.1
 */