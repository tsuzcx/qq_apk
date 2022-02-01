import android.content.Context;
import android.view.View;
import android.widget.EditText;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiUniversalPanel;

public class ascz
{
  private Context jdField_a_of_type_AndroidContentContext;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private arxd jdField_a_of_type_Arxd;
  private asda jdField_a_of_type_Asda;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  public ascz(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public ascz a(EditText paramEditText)
  {
    this.jdField_a_of_type_AndroidWidgetEditText = paramEditText;
    return this;
  }
  
  public ascz a(arxd paramarxd)
  {
    this.jdField_a_of_type_Arxd = paramarxd;
    return this;
  }
  
  public ascz a(boolean paramBoolean)
  {
    this.b = paramBoolean;
    return this;
  }
  
  public SystemAndEmojiUniversalPanel a()
  {
    SystemAndEmojiUniversalPanel localSystemAndEmojiUniversalPanel = (SystemAndEmojiUniversalPanel)View.inflate(this.jdField_a_of_type_AndroidContentContext, 2131559141, null);
    a(localSystemAndEmojiUniversalPanel);
    return localSystemAndEmojiUniversalPanel;
  }
  
  public void a(SystemAndEmojiUniversalPanel paramSystemAndEmojiUniversalPanel)
  {
    if (paramSystemAndEmojiUniversalPanel == null) {
      return;
    }
    paramSystemAndEmojiUniversalPanel.setEmoticonCallback(this.jdField_a_of_type_Arxd);
    paramSystemAndEmojiUniversalPanel.setDispatchKeyEventListener(this.jdField_a_of_type_Asda);
    paramSystemAndEmojiUniversalPanel.setShowDeleteButton(this.jdField_a_of_type_AndroidWidgetEditText);
    paramSystemAndEmojiUniversalPanel.setShowCommonUsedSystemEmoji(this.jdField_a_of_type_Boolean);
    paramSystemAndEmojiUniversalPanel.setFilterSysFaceBeyond255Enable(this.b);
    paramSystemAndEmojiUniversalPanel.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ascz
 * JD-Core Version:    0.7.0.1
 */