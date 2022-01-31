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

public class baco
  extends bacc<bacu, babp>
{
  private Context jdField_a_of_type_AndroidContentContext;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  
  public baco(XMediaEditor paramXMediaEditor, Context paramContext)
  {
    super(paramXMediaEditor);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
  }
  
  public bacu a(ViewGroup paramViewGroup)
  {
    paramViewGroup = new bacu(this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561144, paramViewGroup, false));
    QLog.i("xmediaEditor", 1, "onCreateViewHolder. vh hash=" + paramViewGroup.hashCode());
    paramViewGroup.jdField_a_of_type_AndroidWidgetEditText.setOnClickListener(new bacp(this));
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
  
  public void a(View paramView, bacu parambacu) {}
  
  public void a(bacu parambacu)
  {
    super.b(parambacu);
  }
  
  public void a(bacu parambacu, babp parambabp, int paramInt)
  {
    QLog.i("xmediaEditor", 1, "Text onBindViewHolder. vh hash=" + parambacu.hashCode() + ", mData.position:" + parambabp.jdField_c_of_type_Int + ", text:" + parambabp.jdField_a_of_type_JavaLangString);
    if (parambacu.jdField_a_of_type_AndroidTextTextWatcher != null)
    {
      QLog.i("xmediaEditor", 1, "removeTextChangedListener, mData.position:" + parambabp.jdField_c_of_type_Int + ", text:" + parambabp.jdField_a_of_type_JavaLangString + ",Listener:" + parambacu.jdField_a_of_type_AndroidTextTextWatcher.toString());
      parambacu.jdField_a_of_type_AndroidWidgetEditText.removeTextChangedListener(parambacu.jdField_a_of_type_AndroidTextTextWatcher);
      parambacu.jdField_a_of_type_AndroidTextTextWatcher = null;
    }
    switch (paramInt)
    {
    default: 
      parambacu.jdField_a_of_type_AndroidWidgetEditText.setVisibility(8);
      parambacu.jdField_a_of_type_AndroidWidgetTextView.setText(parambabp.jdField_a_of_type_JavaLangString);
      if (TextUtils.isEmpty(parambabp.jdField_a_of_type_JavaLangString))
      {
        parambacu.itemView.setVisibility(8);
        parambacu.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        return;
      }
      break;
    case 0: 
      parambacu.jdField_a_of_type_AndroidWidgetEditText.setVisibility(0);
      parambacu.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      parambacu.jdField_a_of_type_AndroidWidgetEditText.setText(parambabp.jdField_a_of_type_JavaLangString);
      QLog.i("xmediaEditor", 1, "mData.position:" + parambabp.jdField_c_of_type_Int + ", text:" + parambabp.jdField_a_of_type_JavaLangString);
      parambacu.jdField_a_of_type_AndroidWidgetEditText.setOnFocusChangeListener(null);
      parambacu.jdField_a_of_type_AndroidWidgetEditText.setOnKeyListener(new bacq(this, parambacu));
      parambacu.jdField_a_of_type_AndroidWidgetEditText.setOnEditorActionListener(new bacr(this, parambacu));
      parambacu.jdField_a_of_type_AndroidWidgetEditText.setOnFocusChangeListener(new bacs(this, parambabp, parambacu));
      parambacu.jdField_a_of_type_AndroidTextTextWatcher = new bact(this, parambacu, parambabp);
      QLog.i("xmediaEditor", 1, "addTextChangedListener, mData.position:" + parambabp.jdField_c_of_type_Int + ", text:" + parambabp.jdField_a_of_type_JavaLangString + ",Listener:" + parambacu.jdField_a_of_type_AndroidTextTextWatcher.toString());
      parambacu.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(parambacu.jdField_a_of_type_AndroidTextTextWatcher);
      if (parambabp.jdField_a_of_type_Boolean)
      {
        parambacu.jdField_a_of_type_AndroidWidgetEditText.setFocusable(true);
        parambacu.jdField_a_of_type_AndroidWidgetEditText.setFocusableInTouchMode(true);
        ThreadManager.getUIHandler().post(new TextItem.6(this, parambacu, parambabp));
      }
      while (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a()) {
        if ((((babp)parambacu.jdField_a_of_type_Babg).jdField_c_of_type_Int == 1) && (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.getAdapter().getItemCount() == 2))
        {
          parambacu.jdField_a_of_type_AndroidWidgetEditText.setHint(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.b());
          return;
          parambacu.jdField_a_of_type_AndroidWidgetEditText.clearFocus();
          parambacu.jdField_a_of_type_AndroidWidgetEditText.setFocusable(false);
          parambacu.jdField_a_of_type_AndroidWidgetEditText.setFocusableInTouchMode(false);
        }
        else
        {
          parambacu.jdField_a_of_type_AndroidWidgetEditText.setHint("");
          return;
        }
      }
      if ((((babp)parambacu.jdField_a_of_type_Babg).jdField_c_of_type_Int == 0) && (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.getAdapter().getItemCount() == 1))
      {
        parambacu.jdField_a_of_type_AndroidWidgetEditText.setHint(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.b());
        return;
      }
      parambacu.jdField_a_of_type_AndroidWidgetEditText.setHint("");
      return;
    }
    parambacu.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    parambacu.itemView.setVisibility(0);
  }
  
  public void b(bacu parambacu)
  {
    super.a(parambacu);
    babp localbabp = (babp)parambacu.jdField_a_of_type_Babg;
    if (parambacu.jdField_a_of_type_AndroidTextTextWatcher != null)
    {
      parambacu.jdField_a_of_type_AndroidWidgetEditText.removeTextChangedListener(parambacu.jdField_a_of_type_AndroidTextTextWatcher);
      QLog.i("xmediaEditor", 2, "onViewRecycled, position:" + ((babp)parambacu.jdField_a_of_type_Babg).jdField_c_of_type_Int + ", text:" + localbabp.jdField_a_of_type_JavaLangString + ",Listener:" + parambacu.jdField_a_of_type_AndroidTextTextWatcher.toString());
      parambacu.jdField_a_of_type_AndroidTextTextWatcher = null;
    }
    parambacu.jdField_a_of_type_AndroidWidgetEditText.setOnFocusChangeListener(null);
    if (!localbabp.jdField_c_of_type_Boolean) {
      localbabp.jdField_a_of_type_Int = parambacu.jdField_a_of_type_AndroidWidgetEditText.getSelectionStart();
    }
    for (;;)
    {
      parambacu.jdField_a_of_type_AndroidWidgetEditText.clearFocus();
      parambacu.jdField_a_of_type_AndroidWidgetEditText.setFocusable(false);
      parambacu.jdField_a_of_type_AndroidWidgetEditText.setFocusableInTouchMode(false);
      return;
      localbabp.jdField_c_of_type_Boolean = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     baco
 * JD-Core Version:    0.7.0.1
 */