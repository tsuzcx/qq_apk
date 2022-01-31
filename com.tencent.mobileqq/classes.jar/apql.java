import android.content.Context;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.widget.QFileSendBottomView;

public class apql
  extends apxh
{
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new apqm(this);
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private TextView b;
  
  public apql(QQAppInterface paramQQAppInterface, Context paramContext, QFileSendBottomView paramQFileSendBottomView)
  {
    super(paramQQAppInterface, paramContext, paramQFileSendBottomView);
    c();
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQFileSendBottomView.a(2131375832));
    this.b = ((TextView)this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQFileSendBottomView.a(2131370887));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
  }
  
  public void a()
  {
    Object localObject = this.jdField_a_of_type_AndroidContentContext.getString(2131692402) + this.jdField_a_of_type_AndroidContentContext.getString(2131692644) + apel.b() + this.jdField_a_of_type_AndroidContentContext.getString(2131692645);
    long l = apel.d();
    String str = "";
    if (l > 0L) {
      str = this.jdField_a_of_type_AndroidContentContext.getString(2131692467) + apvd.a(l);
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
    localObject = this.jdField_a_of_type_AndroidWidgetTextView;
    if (apel.b() > 0L) {}
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
 * Qualified Name:     apql
 * JD-Core Version:    0.7.0.1
 */