import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.TextItem.6;
import com.tencent.qphone.base.util.QLog;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.os.MqqHandler;

public class bcfg
  extends bceu<bcfm, bceh>
{
  private Context jdField_a_of_type_AndroidContentContext;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  
  public bcfg(XMediaEditor paramXMediaEditor, Context paramContext)
  {
    super(paramXMediaEditor);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
  }
  
  public bcfm a(ViewGroup paramViewGroup)
  {
    paramViewGroup = new bcfm(this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561350, paramViewGroup, false));
    QLog.i("xmediaEditor", 1, "onCreateViewHolder. vh hash=" + paramViewGroup.hashCode());
    paramViewGroup.jdField_a_of_type_AndroidWidgetEditText.setOnClickListener(new bcfh(this));
    if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a() != 0) {
      paramViewGroup.itemView.setPadding(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a(), 0, this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a(), 0);
    }
    return paramViewGroup;
  }
  
  public String a(String paramString)
  {
    paramString = (paramString + "a").split("\n");
    if (paramString.length > 0)
    {
      paramString = paramString[(paramString.length - 1)];
      if (Pattern.compile("^[1-9]\\d*[、,，.)）]\\d+").matcher(paramString).find()) {
        return "";
      }
      paramString = Pattern.compile("^[1-9]\\d*[、,，.)）]").matcher(paramString);
      if (paramString.find())
      {
        String str = paramString.group();
        paramString = str.substring(0, str.length() - 1);
        str = str.substring(str.length() - 1);
        int i = Integer.parseInt(paramString);
        return i + 1 + str;
      }
    }
    return "";
  }
  
  public void a(View paramView, bcfm parambcfm) {}
  
  public void a(bcfm parambcfm)
  {
    super.b(parambcfm);
  }
  
  public void a(bcfm parambcfm, bceh parambceh, int paramInt)
  {
    QLog.i("xmediaEditor", 1, "Text onBindViewHolder. vh hash=" + parambcfm.hashCode() + ", mData.position:" + parambceh.jdField_c_of_type_Int + ", text:" + parambceh.jdField_a_of_type_JavaLangString);
    if (parambcfm.jdField_a_of_type_AndroidTextTextWatcher != null)
    {
      QLog.i("xmediaEditor", 1, "removeTextChangedListener, mData.position:" + parambceh.jdField_c_of_type_Int + ", text:" + parambceh.jdField_a_of_type_JavaLangString + ",Listener:" + parambcfm.jdField_a_of_type_AndroidTextTextWatcher.toString());
      parambcfm.jdField_a_of_type_AndroidWidgetEditText.removeTextChangedListener(parambcfm.jdField_a_of_type_AndroidTextTextWatcher);
      parambcfm.jdField_a_of_type_AndroidTextTextWatcher = null;
    }
    switch (paramInt)
    {
    default: 
      parambcfm.jdField_a_of_type_AndroidWidgetEditText.setVisibility(8);
      parambcfm.jdField_a_of_type_AndroidWidgetTextView.setText(parambceh.jdField_a_of_type_JavaLangString);
      if (TextUtils.isEmpty(parambceh.jdField_a_of_type_JavaLangString))
      {
        parambcfm.itemView.setVisibility(8);
        parambcfm.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        return;
      }
      break;
    case 0: 
      parambcfm.jdField_a_of_type_AndroidWidgetEditText.setVisibility(0);
      parambcfm.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      parambcfm.jdField_a_of_type_AndroidWidgetEditText.setText(parambceh.jdField_a_of_type_JavaLangString);
      QLog.i("xmediaEditor", 1, "mData.position:" + parambceh.jdField_c_of_type_Int + ", text:" + parambceh.jdField_a_of_type_JavaLangString);
      parambcfm.jdField_a_of_type_AndroidWidgetEditText.setOnFocusChangeListener(null);
      parambcfm.jdField_a_of_type_AndroidWidgetEditText.setOnKeyListener(new bcfi(this, parambcfm));
      parambcfm.jdField_a_of_type_AndroidWidgetEditText.setOnEditorActionListener(new bcfj(this, parambcfm));
      parambcfm.jdField_a_of_type_AndroidWidgetEditText.setOnFocusChangeListener(new bcfk(this, parambceh, parambcfm));
      parambcfm.jdField_a_of_type_AndroidTextTextWatcher = new bcfl(this, parambcfm, parambceh);
      QLog.i("xmediaEditor", 1, "addTextChangedListener, mData.position:" + parambceh.jdField_c_of_type_Int + ", text:" + parambceh.jdField_a_of_type_JavaLangString + ",Listener:" + parambcfm.jdField_a_of_type_AndroidTextTextWatcher.toString());
      parambcfm.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(parambcfm.jdField_a_of_type_AndroidTextTextWatcher);
      if (parambceh.jdField_a_of_type_Boolean)
      {
        parambcfm.jdField_a_of_type_AndroidWidgetEditText.setFocusable(true);
        parambcfm.jdField_a_of_type_AndroidWidgetEditText.setFocusableInTouchMode(true);
        ThreadManager.getUIHandler().post(new TextItem.6(this, parambcfm, parambceh));
      }
      while (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a()) {
        if ((((bceh)parambcfm.jdField_a_of_type_Bcdy).jdField_c_of_type_Int == 1) && (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.getAdapter().getItemCount() == 2))
        {
          parambcfm.jdField_a_of_type_AndroidWidgetEditText.setHint(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.b());
          return;
          parambcfm.jdField_a_of_type_AndroidWidgetEditText.clearFocus();
          parambcfm.jdField_a_of_type_AndroidWidgetEditText.setFocusable(false);
          parambcfm.jdField_a_of_type_AndroidWidgetEditText.setFocusableInTouchMode(false);
        }
        else
        {
          parambcfm.jdField_a_of_type_AndroidWidgetEditText.setHint("");
          return;
        }
      }
      if ((((bceh)parambcfm.jdField_a_of_type_Bcdy).jdField_c_of_type_Int == 0) && (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.getAdapter().getItemCount() == 1))
      {
        parambcfm.jdField_a_of_type_AndroidWidgetEditText.setHint(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.b());
        return;
      }
      parambcfm.jdField_a_of_type_AndroidWidgetEditText.setHint("");
      return;
    }
    parambcfm.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    parambcfm.itemView.setVisibility(0);
  }
  
  public void b(bcfm parambcfm)
  {
    super.a(parambcfm);
    bceh localbceh = (bceh)parambcfm.jdField_a_of_type_Bcdy;
    if (parambcfm.jdField_a_of_type_AndroidTextTextWatcher != null)
    {
      parambcfm.jdField_a_of_type_AndroidWidgetEditText.removeTextChangedListener(parambcfm.jdField_a_of_type_AndroidTextTextWatcher);
      QLog.i("xmediaEditor", 2, "onViewRecycled, position:" + ((bceh)parambcfm.jdField_a_of_type_Bcdy).jdField_c_of_type_Int + ", text:" + localbceh.jdField_a_of_type_JavaLangString + ",Listener:" + parambcfm.jdField_a_of_type_AndroidTextTextWatcher.toString());
      parambcfm.jdField_a_of_type_AndroidTextTextWatcher = null;
    }
    parambcfm.jdField_a_of_type_AndroidWidgetEditText.setOnFocusChangeListener(null);
    if (!localbceh.jdField_c_of_type_Boolean) {
      localbceh.jdField_a_of_type_Int = parambcfm.jdField_a_of_type_AndroidWidgetEditText.getSelectionStart();
    }
    for (;;)
    {
      parambcfm.jdField_a_of_type_AndroidWidgetEditText.clearFocus();
      parambcfm.jdField_a_of_type_AndroidWidgetEditText.setFocusable(false);
      parambcfm.jdField_a_of_type_AndroidWidgetEditText.setFocusableInTouchMode(false);
      return;
      localbceh.jdField_c_of_type_Boolean = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcfg
 * JD-Core Version:    0.7.0.1
 */