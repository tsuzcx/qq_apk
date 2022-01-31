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

public class bcax
  extends bcal<bcbd, bbzy>
{
  private Context jdField_a_of_type_AndroidContentContext;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  
  public bcax(XMediaEditor paramXMediaEditor, Context paramContext)
  {
    super(paramXMediaEditor);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
  }
  
  public bcbd a(ViewGroup paramViewGroup)
  {
    paramViewGroup = new bcbd(this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561332, paramViewGroup, false));
    QLog.i("xmediaEditor", 1, "onCreateViewHolder. vh hash=" + paramViewGroup.hashCode());
    paramViewGroup.jdField_a_of_type_AndroidWidgetEditText.setOnClickListener(new bcay(this));
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
  
  public void a(View paramView, bcbd parambcbd) {}
  
  public void a(bcbd parambcbd)
  {
    super.b(parambcbd);
  }
  
  public void a(bcbd parambcbd, bbzy parambbzy, int paramInt)
  {
    QLog.i("xmediaEditor", 1, "Text onBindViewHolder. vh hash=" + parambcbd.hashCode() + ", mData.position:" + parambbzy.jdField_c_of_type_Int + ", text:" + parambbzy.jdField_a_of_type_JavaLangString);
    if (parambcbd.jdField_a_of_type_AndroidTextTextWatcher != null)
    {
      QLog.i("xmediaEditor", 1, "removeTextChangedListener, mData.position:" + parambbzy.jdField_c_of_type_Int + ", text:" + parambbzy.jdField_a_of_type_JavaLangString + ",Listener:" + parambcbd.jdField_a_of_type_AndroidTextTextWatcher.toString());
      parambcbd.jdField_a_of_type_AndroidWidgetEditText.removeTextChangedListener(parambcbd.jdField_a_of_type_AndroidTextTextWatcher);
      parambcbd.jdField_a_of_type_AndroidTextTextWatcher = null;
    }
    switch (paramInt)
    {
    default: 
      parambcbd.jdField_a_of_type_AndroidWidgetEditText.setVisibility(8);
      parambcbd.jdField_a_of_type_AndroidWidgetTextView.setText(parambbzy.jdField_a_of_type_JavaLangString);
      if (TextUtils.isEmpty(parambbzy.jdField_a_of_type_JavaLangString))
      {
        parambcbd.itemView.setVisibility(8);
        parambcbd.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        return;
      }
      break;
    case 0: 
      parambcbd.jdField_a_of_type_AndroidWidgetEditText.setVisibility(0);
      parambcbd.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      parambcbd.jdField_a_of_type_AndroidWidgetEditText.setText(parambbzy.jdField_a_of_type_JavaLangString);
      QLog.i("xmediaEditor", 1, "mData.position:" + parambbzy.jdField_c_of_type_Int + ", text:" + parambbzy.jdField_a_of_type_JavaLangString);
      parambcbd.jdField_a_of_type_AndroidWidgetEditText.setOnFocusChangeListener(null);
      parambcbd.jdField_a_of_type_AndroidWidgetEditText.setOnKeyListener(new bcaz(this, parambcbd));
      parambcbd.jdField_a_of_type_AndroidWidgetEditText.setOnEditorActionListener(new bcba(this, parambcbd));
      parambcbd.jdField_a_of_type_AndroidWidgetEditText.setOnFocusChangeListener(new bcbb(this, parambbzy, parambcbd));
      parambcbd.jdField_a_of_type_AndroidTextTextWatcher = new bcbc(this, parambcbd, parambbzy);
      QLog.i("xmediaEditor", 1, "addTextChangedListener, mData.position:" + parambbzy.jdField_c_of_type_Int + ", text:" + parambbzy.jdField_a_of_type_JavaLangString + ",Listener:" + parambcbd.jdField_a_of_type_AndroidTextTextWatcher.toString());
      parambcbd.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(parambcbd.jdField_a_of_type_AndroidTextTextWatcher);
      if (parambbzy.jdField_a_of_type_Boolean)
      {
        parambcbd.jdField_a_of_type_AndroidWidgetEditText.setFocusable(true);
        parambcbd.jdField_a_of_type_AndroidWidgetEditText.setFocusableInTouchMode(true);
        ThreadManager.getUIHandler().post(new TextItem.6(this, parambcbd, parambbzy));
      }
      while (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a()) {
        if ((((bbzy)parambcbd.jdField_a_of_type_Bbzp).jdField_c_of_type_Int == 1) && (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.getAdapter().getItemCount() == 2))
        {
          parambcbd.jdField_a_of_type_AndroidWidgetEditText.setHint(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.b());
          return;
          parambcbd.jdField_a_of_type_AndroidWidgetEditText.clearFocus();
          parambcbd.jdField_a_of_type_AndroidWidgetEditText.setFocusable(false);
          parambcbd.jdField_a_of_type_AndroidWidgetEditText.setFocusableInTouchMode(false);
        }
        else
        {
          parambcbd.jdField_a_of_type_AndroidWidgetEditText.setHint("");
          return;
        }
      }
      if ((((bbzy)parambcbd.jdField_a_of_type_Bbzp).jdField_c_of_type_Int == 0) && (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.getAdapter().getItemCount() == 1))
      {
        parambcbd.jdField_a_of_type_AndroidWidgetEditText.setHint(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.b());
        return;
      }
      parambcbd.jdField_a_of_type_AndroidWidgetEditText.setHint("");
      return;
    }
    parambcbd.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    parambcbd.itemView.setVisibility(0);
  }
  
  public void b(bcbd parambcbd)
  {
    super.a(parambcbd);
    bbzy localbbzy = (bbzy)parambcbd.jdField_a_of_type_Bbzp;
    if (parambcbd.jdField_a_of_type_AndroidTextTextWatcher != null)
    {
      parambcbd.jdField_a_of_type_AndroidWidgetEditText.removeTextChangedListener(parambcbd.jdField_a_of_type_AndroidTextTextWatcher);
      QLog.i("xmediaEditor", 2, "onViewRecycled, position:" + ((bbzy)parambcbd.jdField_a_of_type_Bbzp).jdField_c_of_type_Int + ", text:" + localbbzy.jdField_a_of_type_JavaLangString + ",Listener:" + parambcbd.jdField_a_of_type_AndroidTextTextWatcher.toString());
      parambcbd.jdField_a_of_type_AndroidTextTextWatcher = null;
    }
    parambcbd.jdField_a_of_type_AndroidWidgetEditText.setOnFocusChangeListener(null);
    if (!localbbzy.jdField_c_of_type_Boolean) {
      localbbzy.jdField_a_of_type_Int = parambcbd.jdField_a_of_type_AndroidWidgetEditText.getSelectionStart();
    }
    for (;;)
    {
      parambcbd.jdField_a_of_type_AndroidWidgetEditText.clearFocus();
      parambcbd.jdField_a_of_type_AndroidWidgetEditText.setFocusable(false);
      parambcbd.jdField_a_of_type_AndroidWidgetEditText.setFocusableInTouchMode(false);
      return;
      localbbzy.jdField_c_of_type_Boolean = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcax
 * JD-Core Version:    0.7.0.1
 */