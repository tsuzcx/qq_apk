import android.content.Context;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.widget.QFileSendBottomView;

public class aujy
  extends aupe
{
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new aujz(this);
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private TextView b;
  
  public aujy(QQAppInterface paramQQAppInterface, Context paramContext, QFileSendBottomView paramQFileSendBottomView)
  {
    super(paramQQAppInterface, paramContext, paramQFileSendBottomView);
    c();
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQFileSendBottomView.a(2131377314));
    this.b = ((TextView)this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQFileSendBottomView.a(2131371887));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
  }
  
  public void a()
  {
    Object localObject = this.jdField_a_of_type_AndroidContentContext.getString(2131692068) + this.jdField_a_of_type_AndroidContentContext.getString(2131692296) + atyw.b() + this.jdField_a_of_type_AndroidContentContext.getString(2131692297);
    long l = atyw.d();
    String str = "";
    if (l > 0L) {
      str = this.jdField_a_of_type_AndroidContentContext.getString(2131692135) + auog.a(l);
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
    localObject = this.jdField_a_of_type_AndroidWidgetTextView;
    if (atyw.b() > 0L) {}
    for (boolean bool = true;; bool = false)
    {
      ((TextView)localObject).setEnabled(bool);
      this.b.setText(str);
      return;
    }
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    if (this.jdField_a_of_type_Boolean) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aujy
 * JD-Core Version:    0.7.0.1
 */