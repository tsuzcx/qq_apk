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

public class beow
  extends beok<bepc, benx>
{
  private Context jdField_a_of_type_AndroidContentContext;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  
  public beow(XMediaEditor paramXMediaEditor, Context paramContext)
  {
    super(paramXMediaEditor);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
  }
  
  public bepc a(ViewGroup paramViewGroup)
  {
    paramViewGroup = new bepc(this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561503, paramViewGroup, false));
    QLog.i("xmediaEditor", 1, "onCreateViewHolder. vh hash=" + paramViewGroup.hashCode());
    paramViewGroup.jdField_a_of_type_AndroidWidgetEditText.setOnClickListener(new beox(this));
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
  
  public void a(View paramView, bepc parambepc) {}
  
  public void a(bepc parambepc)
  {
    super.b(parambepc);
  }
  
  public void a(bepc parambepc, benx parambenx, int paramInt)
  {
    QLog.i("xmediaEditor", 1, "Text onBindViewHolder. vh hash=" + parambepc.hashCode() + ", mData.position:" + parambenx.jdField_c_of_type_Int + ", text:" + parambenx.jdField_a_of_type_JavaLangString);
    if (parambepc.jdField_a_of_type_AndroidTextTextWatcher != null)
    {
      QLog.i("xmediaEditor", 1, "removeTextChangedListener, mData.position:" + parambenx.jdField_c_of_type_Int + ", text:" + parambenx.jdField_a_of_type_JavaLangString + ",Listener:" + parambepc.jdField_a_of_type_AndroidTextTextWatcher.toString());
      parambepc.jdField_a_of_type_AndroidWidgetEditText.removeTextChangedListener(parambepc.jdField_a_of_type_AndroidTextTextWatcher);
      parambepc.jdField_a_of_type_AndroidTextTextWatcher = null;
    }
    switch (paramInt)
    {
    default: 
      parambepc.jdField_a_of_type_AndroidWidgetEditText.setVisibility(8);
      parambepc.jdField_a_of_type_AndroidWidgetTextView.setText(parambenx.jdField_a_of_type_JavaLangString);
      if (TextUtils.isEmpty(parambenx.jdField_a_of_type_JavaLangString))
      {
        parambepc.itemView.setVisibility(8);
        parambepc.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        return;
      }
      break;
    case 0: 
      parambepc.jdField_a_of_type_AndroidWidgetEditText.setVisibility(0);
      parambepc.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      parambepc.jdField_a_of_type_AndroidWidgetEditText.setText(parambenx.jdField_a_of_type_JavaLangString);
      QLog.i("xmediaEditor", 1, "mData.position:" + parambenx.jdField_c_of_type_Int + ", text:" + parambenx.jdField_a_of_type_JavaLangString);
      parambepc.jdField_a_of_type_AndroidWidgetEditText.setOnFocusChangeListener(null);
      parambepc.jdField_a_of_type_AndroidWidgetEditText.setOnKeyListener(new beoy(this, parambepc));
      parambepc.jdField_a_of_type_AndroidWidgetEditText.setOnEditorActionListener(new beoz(this, parambepc));
      parambepc.jdField_a_of_type_AndroidWidgetEditText.setOnFocusChangeListener(new bepa(this, parambenx, parambepc));
      parambepc.jdField_a_of_type_AndroidTextTextWatcher = new bepb(this, parambepc, parambenx);
      QLog.i("xmediaEditor", 1, "addTextChangedListener, mData.position:" + parambenx.jdField_c_of_type_Int + ", text:" + parambenx.jdField_a_of_type_JavaLangString + ",Listener:" + parambepc.jdField_a_of_type_AndroidTextTextWatcher.toString());
      parambepc.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(parambepc.jdField_a_of_type_AndroidTextTextWatcher);
      if (parambenx.jdField_a_of_type_Boolean)
      {
        parambepc.jdField_a_of_type_AndroidWidgetEditText.setFocusable(true);
        parambepc.jdField_a_of_type_AndroidWidgetEditText.setFocusableInTouchMode(true);
        ThreadManager.getUIHandler().post(new TextItem.6(this, parambepc, parambenx));
      }
      while (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a()) {
        if ((((benx)parambepc.jdField_a_of_type_Beno).jdField_c_of_type_Int == 1) && (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.getAdapter().getItemCount() == 2))
        {
          parambepc.jdField_a_of_type_AndroidWidgetEditText.setHint(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.b());
          return;
          parambepc.jdField_a_of_type_AndroidWidgetEditText.clearFocus();
          parambepc.jdField_a_of_type_AndroidWidgetEditText.setFocusable(false);
          parambepc.jdField_a_of_type_AndroidWidgetEditText.setFocusableInTouchMode(false);
        }
        else
        {
          parambepc.jdField_a_of_type_AndroidWidgetEditText.setHint("");
          return;
        }
      }
      if ((((benx)parambepc.jdField_a_of_type_Beno).jdField_c_of_type_Int == 0) && (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.getAdapter().getItemCount() == 1))
      {
        parambepc.jdField_a_of_type_AndroidWidgetEditText.setHint(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.b());
        return;
      }
      parambepc.jdField_a_of_type_AndroidWidgetEditText.setHint("");
      return;
    }
    parambepc.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    parambepc.itemView.setVisibility(0);
  }
  
  public void b(bepc parambepc)
  {
    super.a(parambepc);
    benx localbenx = (benx)parambepc.jdField_a_of_type_Beno;
    if (parambepc.jdField_a_of_type_AndroidTextTextWatcher != null)
    {
      parambepc.jdField_a_of_type_AndroidWidgetEditText.removeTextChangedListener(parambepc.jdField_a_of_type_AndroidTextTextWatcher);
      QLog.i("xmediaEditor", 2, "onViewRecycled, position:" + ((benx)parambepc.jdField_a_of_type_Beno).jdField_c_of_type_Int + ", text:" + localbenx.jdField_a_of_type_JavaLangString + ",Listener:" + parambepc.jdField_a_of_type_AndroidTextTextWatcher.toString());
      parambepc.jdField_a_of_type_AndroidTextTextWatcher = null;
    }
    parambepc.jdField_a_of_type_AndroidWidgetEditText.setOnFocusChangeListener(null);
    if (!localbenx.jdField_c_of_type_Boolean) {
      localbenx.jdField_a_of_type_Int = parambepc.jdField_a_of_type_AndroidWidgetEditText.getSelectionStart();
    }
    for (;;)
    {
      parambepc.jdField_a_of_type_AndroidWidgetEditText.clearFocus();
      parambepc.jdField_a_of_type_AndroidWidgetEditText.setFocusable(false);
      parambepc.jdField_a_of_type_AndroidWidgetEditText.setFocusableInTouchMode(false);
      return;
      localbenx.jdField_c_of_type_Boolean = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beow
 * JD-Core Version:    0.7.0.1
 */