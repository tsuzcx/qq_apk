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

public class bgfo
  extends bgfc<bgfu, bgep>
{
  private Context jdField_a_of_type_AndroidContentContext;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  
  public bgfo(XMediaEditor paramXMediaEditor, Context paramContext)
  {
    super(paramXMediaEditor);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
  }
  
  public bgfu a(ViewGroup paramViewGroup)
  {
    paramViewGroup = new bgfu(this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561624, paramViewGroup, false));
    QLog.i("xmediaEditor", 1, "onCreateViewHolder. vh hash=" + paramViewGroup.hashCode());
    paramViewGroup.jdField_a_of_type_AndroidWidgetEditText.setOnClickListener(new bgfp(this));
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
  
  public void a(View paramView, bgfu parambgfu) {}
  
  public void a(bgfu parambgfu)
  {
    super.b(parambgfu);
  }
  
  public void a(bgfu parambgfu, bgep parambgep, int paramInt)
  {
    QLog.i("xmediaEditor", 1, "Text onBindViewHolder. vh hash=" + parambgfu.hashCode() + ", mData.position:" + parambgep.jdField_c_of_type_Int + ", text:" + parambgep.jdField_a_of_type_JavaLangString);
    if (parambgfu.jdField_a_of_type_AndroidTextTextWatcher != null)
    {
      QLog.i("xmediaEditor", 1, "removeTextChangedListener, mData.position:" + parambgep.jdField_c_of_type_Int + ", text:" + parambgep.jdField_a_of_type_JavaLangString + ",Listener:" + parambgfu.jdField_a_of_type_AndroidTextTextWatcher.toString());
      parambgfu.jdField_a_of_type_AndroidWidgetEditText.removeTextChangedListener(parambgfu.jdField_a_of_type_AndroidTextTextWatcher);
      parambgfu.jdField_a_of_type_AndroidTextTextWatcher = null;
    }
    switch (paramInt)
    {
    default: 
      parambgfu.jdField_a_of_type_AndroidWidgetEditText.setVisibility(8);
      parambgfu.jdField_a_of_type_AndroidWidgetTextView.setText(parambgep.jdField_a_of_type_JavaLangString);
      if (TextUtils.isEmpty(parambgep.jdField_a_of_type_JavaLangString))
      {
        parambgfu.itemView.setVisibility(8);
        parambgfu.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        return;
      }
      break;
    case 0: 
      parambgfu.jdField_a_of_type_AndroidWidgetEditText.setVisibility(0);
      parambgfu.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      parambgfu.jdField_a_of_type_AndroidWidgetEditText.setText(parambgep.jdField_a_of_type_JavaLangString);
      QLog.i("xmediaEditor", 1, "mData.position:" + parambgep.jdField_c_of_type_Int + ", text:" + parambgep.jdField_a_of_type_JavaLangString);
      parambgfu.jdField_a_of_type_AndroidWidgetEditText.setOnFocusChangeListener(null);
      parambgfu.jdField_a_of_type_AndroidWidgetEditText.setOnKeyListener(new bgfq(this, parambgfu));
      parambgfu.jdField_a_of_type_AndroidWidgetEditText.setOnEditorActionListener(new bgfr(this, parambgfu));
      parambgfu.jdField_a_of_type_AndroidWidgetEditText.setOnFocusChangeListener(new bgfs(this, parambgep, parambgfu));
      parambgfu.jdField_a_of_type_AndroidTextTextWatcher = new bgft(this, parambgfu, parambgep);
      QLog.i("xmediaEditor", 1, "addTextChangedListener, mData.position:" + parambgep.jdField_c_of_type_Int + ", text:" + parambgep.jdField_a_of_type_JavaLangString + ",Listener:" + parambgfu.jdField_a_of_type_AndroidTextTextWatcher.toString());
      parambgfu.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(parambgfu.jdField_a_of_type_AndroidTextTextWatcher);
      if (parambgep.jdField_a_of_type_Boolean)
      {
        parambgfu.jdField_a_of_type_AndroidWidgetEditText.setFocusable(true);
        parambgfu.jdField_a_of_type_AndroidWidgetEditText.setFocusableInTouchMode(true);
        ThreadManager.getUIHandler().post(new TextItem.6(this, parambgfu, parambgep));
      }
      while (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a()) {
        if ((((bgep)parambgfu.jdField_a_of_type_Bgeg).jdField_c_of_type_Int == 1) && (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.getAdapter().getItemCount() == 2))
        {
          parambgfu.jdField_a_of_type_AndroidWidgetEditText.setHint(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.b());
          return;
          parambgfu.jdField_a_of_type_AndroidWidgetEditText.clearFocus();
          parambgfu.jdField_a_of_type_AndroidWidgetEditText.setFocusable(false);
          parambgfu.jdField_a_of_type_AndroidWidgetEditText.setFocusableInTouchMode(false);
        }
        else
        {
          parambgfu.jdField_a_of_type_AndroidWidgetEditText.setHint("");
          return;
        }
      }
      if ((((bgep)parambgfu.jdField_a_of_type_Bgeg).jdField_c_of_type_Int == 0) && (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.getAdapter().getItemCount() == 1))
      {
        parambgfu.jdField_a_of_type_AndroidWidgetEditText.setHint(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.b());
        return;
      }
      parambgfu.jdField_a_of_type_AndroidWidgetEditText.setHint("");
      return;
    }
    parambgfu.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    parambgfu.itemView.setVisibility(0);
  }
  
  public void b(bgfu parambgfu)
  {
    super.a(parambgfu);
    bgep localbgep = (bgep)parambgfu.jdField_a_of_type_Bgeg;
    if (parambgfu.jdField_a_of_type_AndroidTextTextWatcher != null)
    {
      parambgfu.jdField_a_of_type_AndroidWidgetEditText.removeTextChangedListener(parambgfu.jdField_a_of_type_AndroidTextTextWatcher);
      QLog.i("xmediaEditor", 2, "onViewRecycled, position:" + ((bgep)parambgfu.jdField_a_of_type_Bgeg).jdField_c_of_type_Int + ", text:" + localbgep.jdField_a_of_type_JavaLangString + ",Listener:" + parambgfu.jdField_a_of_type_AndroidTextTextWatcher.toString());
      parambgfu.jdField_a_of_type_AndroidTextTextWatcher = null;
    }
    parambgfu.jdField_a_of_type_AndroidWidgetEditText.setOnFocusChangeListener(null);
    if (!localbgep.jdField_c_of_type_Boolean) {
      localbgep.jdField_a_of_type_Int = parambgfu.jdField_a_of_type_AndroidWidgetEditText.getSelectionStart();
    }
    for (;;)
    {
      parambgfu.jdField_a_of_type_AndroidWidgetEditText.clearFocus();
      parambgfu.jdField_a_of_type_AndroidWidgetEditText.setFocusable(false);
      parambgfu.jdField_a_of_type_AndroidWidgetEditText.setFocusableInTouchMode(false);
      return;
      localbgep.jdField_c_of_type_Boolean = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgfo
 * JD-Core Version:    0.7.0.1
 */