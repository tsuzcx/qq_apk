import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.forward.ForwardFileOption;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;

public class auyy
  implements View.OnClickListener
{
  public auyy(ForwardFileOption paramForwardFileOption, EditText paramEditText, String paramString1, String paramString2, String paramString3, ForwardFileInfo paramForwardFileInfo) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqForwardForwardFileOption.l = true;
    Object localObject1 = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString().trim();
    this.jdField_a_of_type_AndroidWidgetEditText.setText((CharSequence)localObject1);
    this.jdField_a_of_type_AndroidWidgetEditText.setSelection(((String)localObject1).length());
    if ((localObject1 == null) || (((String)localObject1).length() <= 0)) {
      ForwardFileOption.a(this.jdField_a_of_type_ComTencentMobileqqForwardForwardFileOption, -6);
    }
    String str;
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (!((String)localObject1).matches("[^/\\\\\\\\<>*:?|\\\"]+"))
      {
        ForwardFileOption.a(this.jdField_a_of_type_ComTencentMobileqqForwardForwardFileOption, -7);
      }
      else
      {
        str = (String)localObject1 + this.jdField_a_of_type_JavaLangString;
        if (!str.equals(this.b)) {
          break;
        }
        bdll.b(null, "dc00898", "", "", "0X800AEEB", "0X800AEEB", 0, 0, "", "", "", "");
        ForwardFileOption.a(this.jdField_a_of_type_ComTencentMobileqqForwardForwardFileOption).dismiss();
      }
    }
    int i;
    if (!str.equals(this.c)) {
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo != null)
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo.a();
        i = ((String)localObject1).lastIndexOf('/');
        if ((i <= -1) || (i >= ((String)localObject1).length())) {
          break label387;
        }
      }
    }
    label387:
    for (localObject1 = ((String)localObject1).substring(0, i + 1);; localObject1 = "")
    {
      localObject1 = new File((String)localObject1).listFiles();
      if ((localObject1 != null) && (localObject1.length > 0))
      {
        int j = localObject1.length;
        i = 0;
        label261:
        if (i < j)
        {
          Object localObject2 = localObject1[i];
          if (localObject2.isDirectory()) {}
          while (!localObject2.getName().toLowerCase().equals(str.toLowerCase()))
          {
            i += 1;
            break label261;
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqForwardForwardFileOption.i;
            break;
          }
          ForwardFileOption.a(this.jdField_a_of_type_ComTencentMobileqqForwardForwardFileOption, -3);
          break;
        }
      }
      ForwardFileOption.a(this.jdField_a_of_type_ComTencentMobileqqForwardForwardFileOption).setText(str);
      ForwardFileOption.a(this.jdField_a_of_type_ComTencentMobileqqForwardForwardFileOption, 1);
      bdll.b(null, "dc00898", "", "", "0X800AEEB", "0X800AEEB", 0, 0, "", "", "", "");
      ForwardFileOption.a(this.jdField_a_of_type_ComTencentMobileqqForwardForwardFileOption).dismiss();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auyy
 * JD-Core Version:    0.7.0.1
 */