import android.content.Context;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.widget.QFileSendBottomView;

public class arjo
  extends arqj
{
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new arjp(this);
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private TextView b;
  
  public arjo(QQAppInterface paramQQAppInterface, Context paramContext, QFileSendBottomView paramQFileSendBottomView)
  {
    super(paramQQAppInterface, paramContext, paramQFileSendBottomView);
    c();
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQFileSendBottomView.a(2131376331));
    this.b = ((TextView)this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQFileSendBottomView.a(2131371197));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
  }
  
  public void a()
  {
    Object localObject = this.jdField_a_of_type_AndroidContentContext.getString(2131692478) + this.jdField_a_of_type_AndroidContentContext.getString(2131692723) + aqxj.b() + this.jdField_a_of_type_AndroidContentContext.getString(2131692724);
    long l = aqxj.d();
    String str = "";
    if (l > 0L) {
      str = this.jdField_a_of_type_AndroidContentContext.getString(2131692543) + arof.a(l);
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
    localObject = this.jdField_a_of_type_AndroidWidgetTextView;
    if (aqxj.b() > 0L) {}
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arjo
 * JD-Core Version:    0.7.0.1
 */