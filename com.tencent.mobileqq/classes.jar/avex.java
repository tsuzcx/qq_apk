import android.view.View;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.OverScrollCallbackHorizontalListView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class avex
{
  private aiah jdField_a_of_type_Aiah;
  private avaz jdField_a_of_type_Avaz;
  private OverScrollCallbackHorizontalListView jdField_a_of_type_ComTencentMobileqqWidgetOverScrollCallbackHorizontalListView;
  
  public avex(aiah paramaiah)
  {
    this.jdField_a_of_type_Aiah = paramaiah;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollCallbackHorizontalListView != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollCallbackHorizontalListView.getParent() != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("GameMsgQuickReplyView", 2, "[onDestroy], remove shortcutContainer");
      }
      this.jdField_a_of_type_Aiah.getContent().removeView(this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollCallbackHorizontalListView);
    }
  }
  
  public void a(ArrayList<avbx> paramArrayList)
  {
    if ((this.jdField_a_of_type_Aiah == null) || (this.jdField_a_of_type_Aiah.mContext == null) || (this.jdField_a_of_type_Aiah.getContent() == null)) {}
    do
    {
      return;
      View localView = this.jdField_a_of_type_Aiah.getContent().findViewById(2131377140);
      if (localView != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("GameMsgQuickReplyView", 2, "init remove shortcutContainer");
        }
        this.jdField_a_of_type_Aiah.getContent().removeView(localView);
      }
      this.jdField_a_of_type_Avaz = new avaz(this.jdField_a_of_type_Aiah.mContext, paramArrayList);
      this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollCallbackHorizontalListView = new OverScrollCallbackHorizontalListView(this.jdField_a_of_type_Aiah.mContext);
      this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollCallbackHorizontalListView.setId(2131377140);
      this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollCallbackHorizontalListView.setAdapter(this.jdField_a_of_type_Avaz);
      this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollCallbackHorizontalListView.setOnItemClickListener(new avey(this));
      this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollCallbackHorizontalListView.setOverScrollMode(0);
      this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollCallbackHorizontalListView.setDividerWidth(ViewUtils.dip2px(8.0F));
      this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollCallbackHorizontalListView.setPadding(ViewUtils.dip2px(14.0F), ViewUtils.dip2px(10.0F), 0, 0);
      this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollCallbackHorizontalListView.setClipToPadding(false);
    } while (this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollCallbackHorizontalListView.getParent() != null);
    paramArrayList = new RelativeLayout.LayoutParams(-1, ViewUtils.dip2px(39.0F));
    paramArrayList.addRule(2, 2131368910);
    this.jdField_a_of_type_Aiah.getContent().addView(this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollCallbackHorizontalListView, paramArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avex
 * JD-Core Version:    0.7.0.1
 */