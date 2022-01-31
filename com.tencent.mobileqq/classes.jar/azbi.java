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

public class azbi
  extends azaw<azbo, azaj>
{
  private Context jdField_a_of_type_AndroidContentContext;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  
  public azbi(XMediaEditor paramXMediaEditor, Context paramContext)
  {
    super(paramXMediaEditor);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
  }
  
  public azbo a(ViewGroup paramViewGroup)
  {
    paramViewGroup = new azbo(this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131495556, paramViewGroup, false));
    QLog.i("xmediaEditor", 1, "onCreateViewHolder. vh hash=" + paramViewGroup.hashCode());
    paramViewGroup.jdField_a_of_type_AndroidWidgetEditText.setOnClickListener(new azbj(this));
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
  
  public void a(View paramView, azbo paramazbo) {}
  
  public void a(azbo paramazbo)
  {
    super.b(paramazbo);
  }
  
  public void a(azbo paramazbo, azaj paramazaj, int paramInt)
  {
    QLog.i("xmediaEditor", 1, "Text onBindViewHolder. vh hash=" + paramazbo.hashCode() + ", mData.position:" + paramazaj.c + ", text:" + paramazaj.jdField_a_of_type_JavaLangString);
    if (paramazbo.jdField_a_of_type_AndroidTextTextWatcher != null)
    {
      QLog.i("xmediaEditor", 1, "removeTextChangedListener, mData.position:" + paramazaj.c + ", text:" + paramazaj.jdField_a_of_type_JavaLangString + ",Listener:" + paramazbo.jdField_a_of_type_AndroidTextTextWatcher.toString());
      paramazbo.jdField_a_of_type_AndroidWidgetEditText.removeTextChangedListener(paramazbo.jdField_a_of_type_AndroidTextTextWatcher);
      paramazbo.jdField_a_of_type_AndroidTextTextWatcher = null;
    }
    switch (paramInt)
    {
    default: 
      paramazbo.jdField_a_of_type_AndroidWidgetEditText.setVisibility(8);
      paramazbo.jdField_a_of_type_AndroidWidgetTextView.setText(paramazaj.jdField_a_of_type_JavaLangString);
      if (TextUtils.isEmpty(paramazaj.jdField_a_of_type_JavaLangString))
      {
        paramazbo.itemView.setVisibility(8);
        paramazbo.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        return;
      }
      break;
    case 0: 
      paramazbo.jdField_a_of_type_AndroidWidgetEditText.setVisibility(0);
      paramazbo.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      paramazbo.jdField_a_of_type_AndroidWidgetEditText.setText(paramazaj.jdField_a_of_type_JavaLangString);
      QLog.i("xmediaEditor", 1, "mData.position:" + paramazaj.c + ", text:" + paramazaj.jdField_a_of_type_JavaLangString);
      paramazbo.jdField_a_of_type_AndroidWidgetEditText.setOnFocusChangeListener(null);
      paramazbo.jdField_a_of_type_AndroidWidgetEditText.setOnKeyListener(new azbk(this, paramazbo));
      paramazbo.jdField_a_of_type_AndroidWidgetEditText.setOnEditorActionListener(new azbl(this, paramazbo));
      paramazbo.jdField_a_of_type_AndroidWidgetEditText.setOnFocusChangeListener(new azbm(this, paramazaj, paramazbo));
      paramazbo.jdField_a_of_type_AndroidTextTextWatcher = new azbn(this, paramazbo, paramazaj);
      QLog.i("xmediaEditor", 1, "addTextChangedListener, mData.position:" + paramazaj.c + ", text:" + paramazaj.jdField_a_of_type_JavaLangString + ",Listener:" + paramazbo.jdField_a_of_type_AndroidTextTextWatcher.toString());
      paramazbo.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(paramazbo.jdField_a_of_type_AndroidTextTextWatcher);
      if (paramazaj.jdField_a_of_type_Boolean)
      {
        paramazbo.jdField_a_of_type_AndroidWidgetEditText.setFocusable(true);
        paramazbo.jdField_a_of_type_AndroidWidgetEditText.setFocusableInTouchMode(true);
        ThreadManager.getUIHandler().post(new TextItem.6(this, paramazbo, paramazaj));
      }
      while (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a()) {
        if ((((azaj)paramazbo.jdField_a_of_type_Azaa).c == 1) && (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.getAdapter().getItemCount() == 2))
        {
          paramazbo.jdField_a_of_type_AndroidWidgetEditText.setHint(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.b());
          return;
          paramazbo.jdField_a_of_type_AndroidWidgetEditText.clearFocus();
          paramazbo.jdField_a_of_type_AndroidWidgetEditText.setFocusable(false);
          paramazbo.jdField_a_of_type_AndroidWidgetEditText.setFocusableInTouchMode(false);
        }
        else
        {
          paramazbo.jdField_a_of_type_AndroidWidgetEditText.setHint("");
          return;
        }
      }
      if ((((azaj)paramazbo.jdField_a_of_type_Azaa).c == 0) && (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.getAdapter().getItemCount() == 1))
      {
        paramazbo.jdField_a_of_type_AndroidWidgetEditText.setHint(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.b());
        return;
      }
      paramazbo.jdField_a_of_type_AndroidWidgetEditText.setHint("");
      return;
    }
    paramazbo.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    paramazbo.itemView.setVisibility(0);
  }
  
  public void b(azbo paramazbo)
  {
    super.a(paramazbo);
    azaj localazaj = (azaj)paramazbo.jdField_a_of_type_Azaa;
    if (paramazbo.jdField_a_of_type_AndroidTextTextWatcher != null)
    {
      paramazbo.jdField_a_of_type_AndroidWidgetEditText.removeTextChangedListener(paramazbo.jdField_a_of_type_AndroidTextTextWatcher);
      QLog.i("xmediaEditor", 2, "onViewRecycled, position:" + ((azaj)paramazbo.jdField_a_of_type_Azaa).c + ", text:" + localazaj.jdField_a_of_type_JavaLangString + ",Listener:" + paramazbo.jdField_a_of_type_AndroidTextTextWatcher.toString());
      paramazbo.jdField_a_of_type_AndroidTextTextWatcher = null;
    }
    paramazbo.jdField_a_of_type_AndroidWidgetEditText.setOnFocusChangeListener(null);
    localazaj.jdField_a_of_type_Int = paramazbo.jdField_a_of_type_AndroidWidgetEditText.getSelectionStart();
    paramazbo.jdField_a_of_type_AndroidWidgetEditText.clearFocus();
    paramazbo.jdField_a_of_type_AndroidWidgetEditText.setFocusable(false);
    paramazbo.jdField_a_of_type_AndroidWidgetEditText.setFocusableInTouchMode(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azbi
 * JD-Core Version:    0.7.0.1
 */