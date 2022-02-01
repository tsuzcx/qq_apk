import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.widget.QFileSendBottomView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

public class auas
  extends auft
{
  private int jdField_a_of_type_Int;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new auat(this);
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private String jdField_a_of_type_JavaLangString;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private boolean jdField_b_of_type_Boolean;
  
  public auas(QQAppInterface paramQQAppInterface, Context paramContext, QFileSendBottomView paramQFileSendBottomView)
  {
    super(paramQQAppInterface, paramContext, paramQFileSendBottomView);
    c();
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQFileSendBottomView.a(2131377339));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQFileSendBottomView.a(2131372043));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
  }
  
  private void d()
  {
    if ((this.jdField_a_of_type_AndroidOsBundle == null) || (!this.jdField_a_of_type_AndroidOsBundle.containsKey("qfile_search_param_exparams_qlink_state")))
    {
      a(null);
      return;
    }
    Object localObject1 = this.jdField_a_of_type_JavaLangString;
    Object localObject2 = atpm.a();
    ArrayList localArrayList = new ArrayList();
    localObject2 = ((Set)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      localArrayList.add(((FileInfo)((Iterator)localObject2).next()).c());
    }
    int i = this.jdField_a_of_type_AndroidOsBundle.getInt("qfile_search_param_exparams_qlink_state");
    localObject2 = new Intent();
    if (222 == i)
    {
      ((Intent)localObject2).putExtra("string_filepaths", localArrayList);
      i = -1;
    }
    for (;;)
    {
      a(i, (Intent)localObject2);
      return;
      if ((333 == i) || (666 == i) || (3333 == i) || (6666 == i))
      {
        ((Intent)localObject2).putExtra("string_filepaths", localArrayList);
      }
      else
      {
        if ((444 == i) || (555 == i))
        {
          if (444 == i) {}
          for (boolean bool = true;; bool = false)
          {
            ((Intent)localObject2).putExtra("_INIT_SEND_IOS_", bool);
            ((Intent)localObject2).putExtra("string_filepaths", localArrayList);
            break;
          }
        }
        if ((777 == i) || (888 == i))
        {
          localObject1 = new Bundle();
          ((Bundle)localObject1).putStringArrayList("string_filepaths", localArrayList);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getQQProxyForQlink();
          blyb.a(this.jdField_a_of_type_AndroidContentContext, 16, (Bundle)localObject1);
          i = -1;
        }
        else
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getQQProxyForQlink().a((String)localObject1, localArrayList);
          ((Intent)localObject2).putExtra("_UIN_", (String)localObject1);
          ((Intent)localObject2).putExtra("_SEND_QLINK_FILE_", true);
          i = -1;
        }
      }
    }
  }
  
  public void a()
  {
    this.jdField_b_of_type_AndroidWidgetTextView.setText(2131698063);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(anvx.a(2131713242));
    TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
    if (atpm.b() > 0L) {}
    for (boolean bool = true;; bool = false)
    {
      localTextView.setEnabled(bool);
      return;
    }
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("qfile_search_param_ex_params_target_uin");
      this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidOsBundle.getInt("qfile_search_param_exparams_qlink_state");
      this.jdField_b_of_type_Boolean = this.jdField_a_of_type_AndroidOsBundle.getBoolean("qfile_search_param_exparams_qlink_ap_created");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auas
 * JD-Core Version:    0.7.0.1
 */