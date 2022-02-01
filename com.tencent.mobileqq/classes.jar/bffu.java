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

public class bffu
  extends bffi<bfga, bfev>
{
  private Context jdField_a_of_type_AndroidContentContext;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  
  public bffu(XMediaEditor paramXMediaEditor, Context paramContext)
  {
    super(paramXMediaEditor);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
  }
  
  public bfga a(ViewGroup paramViewGroup)
  {
    paramViewGroup = new bfga(this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561583, paramViewGroup, false));
    QLog.i("xmediaEditor", 1, "onCreateViewHolder. vh hash=" + paramViewGroup.hashCode());
    paramViewGroup.jdField_a_of_type_AndroidWidgetEditText.setOnClickListener(new bffv(this));
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
  
  public void a(View paramView, bfga parambfga) {}
  
  public void a(bfga parambfga)
  {
    super.b(parambfga);
  }
  
  public void a(bfga parambfga, bfev parambfev, int paramInt)
  {
    QLog.i("xmediaEditor", 1, "Text onBindViewHolder. vh hash=" + parambfga.hashCode() + ", mData.position:" + parambfev.jdField_c_of_type_Int + ", text:" + parambfev.jdField_a_of_type_JavaLangString);
    if (parambfga.jdField_a_of_type_AndroidTextTextWatcher != null)
    {
      QLog.i("xmediaEditor", 1, "removeTextChangedListener, mData.position:" + parambfev.jdField_c_of_type_Int + ", text:" + parambfev.jdField_a_of_type_JavaLangString + ",Listener:" + parambfga.jdField_a_of_type_AndroidTextTextWatcher.toString());
      parambfga.jdField_a_of_type_AndroidWidgetEditText.removeTextChangedListener(parambfga.jdField_a_of_type_AndroidTextTextWatcher);
      parambfga.jdField_a_of_type_AndroidTextTextWatcher = null;
    }
    switch (paramInt)
    {
    default: 
      parambfga.jdField_a_of_type_AndroidWidgetEditText.setVisibility(8);
      parambfga.jdField_a_of_type_AndroidWidgetTextView.setText(parambfev.jdField_a_of_type_JavaLangString);
      if (TextUtils.isEmpty(parambfev.jdField_a_of_type_JavaLangString))
      {
        parambfga.itemView.setVisibility(8);
        parambfga.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        return;
      }
      break;
    case 0: 
      parambfga.jdField_a_of_type_AndroidWidgetEditText.setVisibility(0);
      parambfga.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      parambfga.jdField_a_of_type_AndroidWidgetEditText.setText(parambfev.jdField_a_of_type_JavaLangString);
      QLog.i("xmediaEditor", 1, "mData.position:" + parambfev.jdField_c_of_type_Int + ", text:" + parambfev.jdField_a_of_type_JavaLangString);
      parambfga.jdField_a_of_type_AndroidWidgetEditText.setOnFocusChangeListener(null);
      parambfga.jdField_a_of_type_AndroidWidgetEditText.setOnKeyListener(new bffw(this, parambfga));
      parambfga.jdField_a_of_type_AndroidWidgetEditText.setOnEditorActionListener(new bffx(this, parambfga));
      parambfga.jdField_a_of_type_AndroidWidgetEditText.setOnFocusChangeListener(new bffy(this, parambfev, parambfga));
      parambfga.jdField_a_of_type_AndroidTextTextWatcher = new bffz(this, parambfga, parambfev);
      QLog.i("xmediaEditor", 1, "addTextChangedListener, mData.position:" + parambfev.jdField_c_of_type_Int + ", text:" + parambfev.jdField_a_of_type_JavaLangString + ",Listener:" + parambfga.jdField_a_of_type_AndroidTextTextWatcher.toString());
      parambfga.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(parambfga.jdField_a_of_type_AndroidTextTextWatcher);
      if (parambfev.jdField_a_of_type_Boolean)
      {
        parambfga.jdField_a_of_type_AndroidWidgetEditText.setFocusable(true);
        parambfga.jdField_a_of_type_AndroidWidgetEditText.setFocusableInTouchMode(true);
        ThreadManager.getUIHandler().post(new TextItem.6(this, parambfga, parambfev));
      }
      while (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a()) {
        if ((((bfev)parambfga.jdField_a_of_type_Bfem).jdField_c_of_type_Int == 1) && (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.getAdapter().getItemCount() == 2))
        {
          parambfga.jdField_a_of_type_AndroidWidgetEditText.setHint(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.b());
          return;
          parambfga.jdField_a_of_type_AndroidWidgetEditText.clearFocus();
          parambfga.jdField_a_of_type_AndroidWidgetEditText.setFocusable(false);
          parambfga.jdField_a_of_type_AndroidWidgetEditText.setFocusableInTouchMode(false);
        }
        else
        {
          parambfga.jdField_a_of_type_AndroidWidgetEditText.setHint("");
          return;
        }
      }
      if ((((bfev)parambfga.jdField_a_of_type_Bfem).jdField_c_of_type_Int == 0) && (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.getAdapter().getItemCount() == 1))
      {
        parambfga.jdField_a_of_type_AndroidWidgetEditText.setHint(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.b());
        return;
      }
      parambfga.jdField_a_of_type_AndroidWidgetEditText.setHint("");
      return;
    }
    parambfga.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    parambfga.itemView.setVisibility(0);
  }
  
  public void b(bfga parambfga)
  {
    super.a(parambfga);
    bfev localbfev = (bfev)parambfga.jdField_a_of_type_Bfem;
    if (parambfga.jdField_a_of_type_AndroidTextTextWatcher != null)
    {
      parambfga.jdField_a_of_type_AndroidWidgetEditText.removeTextChangedListener(parambfga.jdField_a_of_type_AndroidTextTextWatcher);
      QLog.i("xmediaEditor", 2, "onViewRecycled, position:" + ((bfev)parambfga.jdField_a_of_type_Bfem).jdField_c_of_type_Int + ", text:" + localbfev.jdField_a_of_type_JavaLangString + ",Listener:" + parambfga.jdField_a_of_type_AndroidTextTextWatcher.toString());
      parambfga.jdField_a_of_type_AndroidTextTextWatcher = null;
    }
    parambfga.jdField_a_of_type_AndroidWidgetEditText.setOnFocusChangeListener(null);
    if (!localbfev.jdField_c_of_type_Boolean) {
      localbfev.jdField_a_of_type_Int = parambfga.jdField_a_of_type_AndroidWidgetEditText.getSelectionStart();
    }
    for (;;)
    {
      parambfga.jdField_a_of_type_AndroidWidgetEditText.clearFocus();
      parambfga.jdField_a_of_type_AndroidWidgetEditText.setFocusable(false);
      parambfga.jdField_a_of_type_AndroidWidgetEditText.setFocusableInTouchMode(false);
      return;
      localbfev.jdField_c_of_type_Boolean = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bffu
 * JD-Core Version:    0.7.0.1
 */