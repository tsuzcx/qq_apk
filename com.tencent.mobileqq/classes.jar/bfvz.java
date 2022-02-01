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

public class bfvz
  extends bfvn<bfwf, bfva>
{
  private Context jdField_a_of_type_AndroidContentContext;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  
  public bfvz(XMediaEditor paramXMediaEditor, Context paramContext)
  {
    super(paramXMediaEditor);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
  }
  
  public bfwf a(ViewGroup paramViewGroup)
  {
    paramViewGroup = new bfwf(this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561565, paramViewGroup, false));
    QLog.i("xmediaEditor", 1, "onCreateViewHolder. vh hash=" + paramViewGroup.hashCode());
    paramViewGroup.jdField_a_of_type_AndroidWidgetEditText.setOnClickListener(new bfwa(this));
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
  
  public void a(View paramView, bfwf parambfwf) {}
  
  public void a(bfwf parambfwf)
  {
    super.b(parambfwf);
  }
  
  public void a(bfwf parambfwf, bfva parambfva, int paramInt)
  {
    QLog.i("xmediaEditor", 1, "Text onBindViewHolder. vh hash=" + parambfwf.hashCode() + ", mData.position:" + parambfva.jdField_c_of_type_Int + ", text:" + parambfva.jdField_a_of_type_JavaLangString);
    if (parambfwf.jdField_a_of_type_AndroidTextTextWatcher != null)
    {
      QLog.i("xmediaEditor", 1, "removeTextChangedListener, mData.position:" + parambfva.jdField_c_of_type_Int + ", text:" + parambfva.jdField_a_of_type_JavaLangString + ",Listener:" + parambfwf.jdField_a_of_type_AndroidTextTextWatcher.toString());
      parambfwf.jdField_a_of_type_AndroidWidgetEditText.removeTextChangedListener(parambfwf.jdField_a_of_type_AndroidTextTextWatcher);
      parambfwf.jdField_a_of_type_AndroidTextTextWatcher = null;
    }
    switch (paramInt)
    {
    default: 
      parambfwf.jdField_a_of_type_AndroidWidgetEditText.setVisibility(8);
      parambfwf.jdField_a_of_type_AndroidWidgetTextView.setText(parambfva.jdField_a_of_type_JavaLangString);
      if (TextUtils.isEmpty(parambfva.jdField_a_of_type_JavaLangString))
      {
        parambfwf.itemView.setVisibility(8);
        parambfwf.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        return;
      }
      break;
    case 0: 
      parambfwf.jdField_a_of_type_AndroidWidgetEditText.setVisibility(0);
      parambfwf.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      parambfwf.jdField_a_of_type_AndroidWidgetEditText.setText(parambfva.jdField_a_of_type_JavaLangString);
      QLog.i("xmediaEditor", 1, "mData.position:" + parambfva.jdField_c_of_type_Int + ", text:" + parambfva.jdField_a_of_type_JavaLangString);
      parambfwf.jdField_a_of_type_AndroidWidgetEditText.setOnFocusChangeListener(null);
      parambfwf.jdField_a_of_type_AndroidWidgetEditText.setOnKeyListener(new bfwb(this, parambfwf));
      parambfwf.jdField_a_of_type_AndroidWidgetEditText.setOnEditorActionListener(new bfwc(this, parambfwf));
      parambfwf.jdField_a_of_type_AndroidWidgetEditText.setOnFocusChangeListener(new bfwd(this, parambfva, parambfwf));
      parambfwf.jdField_a_of_type_AndroidTextTextWatcher = new bfwe(this, parambfwf, parambfva);
      QLog.i("xmediaEditor", 1, "addTextChangedListener, mData.position:" + parambfva.jdField_c_of_type_Int + ", text:" + parambfva.jdField_a_of_type_JavaLangString + ",Listener:" + parambfwf.jdField_a_of_type_AndroidTextTextWatcher.toString());
      parambfwf.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(parambfwf.jdField_a_of_type_AndroidTextTextWatcher);
      if (parambfva.jdField_a_of_type_Boolean)
      {
        parambfwf.jdField_a_of_type_AndroidWidgetEditText.setFocusable(true);
        parambfwf.jdField_a_of_type_AndroidWidgetEditText.setFocusableInTouchMode(true);
        ThreadManager.getUIHandler().post(new TextItem.6(this, parambfwf, parambfva));
      }
      while (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a()) {
        if ((((bfva)parambfwf.jdField_a_of_type_Bfur).jdField_c_of_type_Int == 1) && (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.getAdapter().getItemCount() == 2))
        {
          parambfwf.jdField_a_of_type_AndroidWidgetEditText.setHint(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.b());
          return;
          parambfwf.jdField_a_of_type_AndroidWidgetEditText.clearFocus();
          parambfwf.jdField_a_of_type_AndroidWidgetEditText.setFocusable(false);
          parambfwf.jdField_a_of_type_AndroidWidgetEditText.setFocusableInTouchMode(false);
        }
        else
        {
          parambfwf.jdField_a_of_type_AndroidWidgetEditText.setHint("");
          return;
        }
      }
      if ((((bfva)parambfwf.jdField_a_of_type_Bfur).jdField_c_of_type_Int == 0) && (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.getAdapter().getItemCount() == 1))
      {
        parambfwf.jdField_a_of_type_AndroidWidgetEditText.setHint(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.b());
        return;
      }
      parambfwf.jdField_a_of_type_AndroidWidgetEditText.setHint("");
      return;
    }
    parambfwf.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    parambfwf.itemView.setVisibility(0);
  }
  
  public void b(bfwf parambfwf)
  {
    super.a(parambfwf);
    bfva localbfva = (bfva)parambfwf.jdField_a_of_type_Bfur;
    if (parambfwf.jdField_a_of_type_AndroidTextTextWatcher != null)
    {
      parambfwf.jdField_a_of_type_AndroidWidgetEditText.removeTextChangedListener(parambfwf.jdField_a_of_type_AndroidTextTextWatcher);
      QLog.i("xmediaEditor", 2, "onViewRecycled, position:" + ((bfva)parambfwf.jdField_a_of_type_Bfur).jdField_c_of_type_Int + ", text:" + localbfva.jdField_a_of_type_JavaLangString + ",Listener:" + parambfwf.jdField_a_of_type_AndroidTextTextWatcher.toString());
      parambfwf.jdField_a_of_type_AndroidTextTextWatcher = null;
    }
    parambfwf.jdField_a_of_type_AndroidWidgetEditText.setOnFocusChangeListener(null);
    if (!localbfva.jdField_c_of_type_Boolean) {
      localbfva.jdField_a_of_type_Int = parambfwf.jdField_a_of_type_AndroidWidgetEditText.getSelectionStart();
    }
    for (;;)
    {
      parambfwf.jdField_a_of_type_AndroidWidgetEditText.clearFocus();
      parambfwf.jdField_a_of_type_AndroidWidgetEditText.setFocusable(false);
      parambfwf.jdField_a_of_type_AndroidWidgetEditText.setFocusableInTouchMode(false);
      return;
      localbfva.jdField_c_of_type_Boolean = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfvz
 * JD-Core Version:    0.7.0.1
 */