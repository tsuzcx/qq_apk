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

public class baca
  extends babo<bacg, babb>
{
  private Context jdField_a_of_type_AndroidContentContext;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  
  public baca(XMediaEditor paramXMediaEditor, Context paramContext)
  {
    super(paramXMediaEditor);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
  }
  
  public bacg a(ViewGroup paramViewGroup)
  {
    paramViewGroup = new bacg(this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561145, paramViewGroup, false));
    QLog.i("xmediaEditor", 1, "onCreateViewHolder. vh hash=" + paramViewGroup.hashCode());
    paramViewGroup.jdField_a_of_type_AndroidWidgetEditText.setOnClickListener(new bacb(this));
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
  
  public void a(View paramView, bacg parambacg) {}
  
  public void a(bacg parambacg)
  {
    super.b(parambacg);
  }
  
  public void a(bacg parambacg, babb parambabb, int paramInt)
  {
    QLog.i("xmediaEditor", 1, "Text onBindViewHolder. vh hash=" + parambacg.hashCode() + ", mData.position:" + parambabb.jdField_c_of_type_Int + ", text:" + parambabb.jdField_a_of_type_JavaLangString);
    if (parambacg.jdField_a_of_type_AndroidTextTextWatcher != null)
    {
      QLog.i("xmediaEditor", 1, "removeTextChangedListener, mData.position:" + parambabb.jdField_c_of_type_Int + ", text:" + parambabb.jdField_a_of_type_JavaLangString + ",Listener:" + parambacg.jdField_a_of_type_AndroidTextTextWatcher.toString());
      parambacg.jdField_a_of_type_AndroidWidgetEditText.removeTextChangedListener(parambacg.jdField_a_of_type_AndroidTextTextWatcher);
      parambacg.jdField_a_of_type_AndroidTextTextWatcher = null;
    }
    switch (paramInt)
    {
    default: 
      parambacg.jdField_a_of_type_AndroidWidgetEditText.setVisibility(8);
      parambacg.jdField_a_of_type_AndroidWidgetTextView.setText(parambabb.jdField_a_of_type_JavaLangString);
      if (TextUtils.isEmpty(parambabb.jdField_a_of_type_JavaLangString))
      {
        parambacg.itemView.setVisibility(8);
        parambacg.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        return;
      }
      break;
    case 0: 
      parambacg.jdField_a_of_type_AndroidWidgetEditText.setVisibility(0);
      parambacg.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      parambacg.jdField_a_of_type_AndroidWidgetEditText.setText(parambabb.jdField_a_of_type_JavaLangString);
      QLog.i("xmediaEditor", 1, "mData.position:" + parambabb.jdField_c_of_type_Int + ", text:" + parambabb.jdField_a_of_type_JavaLangString);
      parambacg.jdField_a_of_type_AndroidWidgetEditText.setOnFocusChangeListener(null);
      parambacg.jdField_a_of_type_AndroidWidgetEditText.setOnKeyListener(new bacc(this, parambacg));
      parambacg.jdField_a_of_type_AndroidWidgetEditText.setOnEditorActionListener(new bacd(this, parambacg));
      parambacg.jdField_a_of_type_AndroidWidgetEditText.setOnFocusChangeListener(new bace(this, parambabb, parambacg));
      parambacg.jdField_a_of_type_AndroidTextTextWatcher = new bacf(this, parambacg, parambabb);
      QLog.i("xmediaEditor", 1, "addTextChangedListener, mData.position:" + parambabb.jdField_c_of_type_Int + ", text:" + parambabb.jdField_a_of_type_JavaLangString + ",Listener:" + parambacg.jdField_a_of_type_AndroidTextTextWatcher.toString());
      parambacg.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(parambacg.jdField_a_of_type_AndroidTextTextWatcher);
      if (parambabb.jdField_a_of_type_Boolean)
      {
        parambacg.jdField_a_of_type_AndroidWidgetEditText.setFocusable(true);
        parambacg.jdField_a_of_type_AndroidWidgetEditText.setFocusableInTouchMode(true);
        ThreadManager.getUIHandler().post(new TextItem.6(this, parambacg, parambabb));
      }
      while (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a()) {
        if ((((babb)parambacg.jdField_a_of_type_Baas).jdField_c_of_type_Int == 1) && (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.getAdapter().getItemCount() == 2))
        {
          parambacg.jdField_a_of_type_AndroidWidgetEditText.setHint(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.b());
          return;
          parambacg.jdField_a_of_type_AndroidWidgetEditText.clearFocus();
          parambacg.jdField_a_of_type_AndroidWidgetEditText.setFocusable(false);
          parambacg.jdField_a_of_type_AndroidWidgetEditText.setFocusableInTouchMode(false);
        }
        else
        {
          parambacg.jdField_a_of_type_AndroidWidgetEditText.setHint("");
          return;
        }
      }
      if ((((babb)parambacg.jdField_a_of_type_Baas).jdField_c_of_type_Int == 0) && (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.getAdapter().getItemCount() == 1))
      {
        parambacg.jdField_a_of_type_AndroidWidgetEditText.setHint(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.b());
        return;
      }
      parambacg.jdField_a_of_type_AndroidWidgetEditText.setHint("");
      return;
    }
    parambacg.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    parambacg.itemView.setVisibility(0);
  }
  
  public void b(bacg parambacg)
  {
    super.a(parambacg);
    babb localbabb = (babb)parambacg.jdField_a_of_type_Baas;
    if (parambacg.jdField_a_of_type_AndroidTextTextWatcher != null)
    {
      parambacg.jdField_a_of_type_AndroidWidgetEditText.removeTextChangedListener(parambacg.jdField_a_of_type_AndroidTextTextWatcher);
      QLog.i("xmediaEditor", 2, "onViewRecycled, position:" + ((babb)parambacg.jdField_a_of_type_Baas).jdField_c_of_type_Int + ", text:" + localbabb.jdField_a_of_type_JavaLangString + ",Listener:" + parambacg.jdField_a_of_type_AndroidTextTextWatcher.toString());
      parambacg.jdField_a_of_type_AndroidTextTextWatcher = null;
    }
    parambacg.jdField_a_of_type_AndroidWidgetEditText.setOnFocusChangeListener(null);
    if (!localbabb.jdField_c_of_type_Boolean) {
      localbabb.jdField_a_of_type_Int = parambacg.jdField_a_of_type_AndroidWidgetEditText.getSelectionStart();
    }
    for (;;)
    {
      parambacg.jdField_a_of_type_AndroidWidgetEditText.clearFocus();
      parambacg.jdField_a_of_type_AndroidWidgetEditText.setFocusable(false);
      parambacg.jdField_a_of_type_AndroidWidgetEditText.setFocusableInTouchMode(false);
      return;
      localbabb.jdField_c_of_type_Boolean = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     baca
 * JD-Core Version:    0.7.0.1
 */