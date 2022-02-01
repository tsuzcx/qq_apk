import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.ttpic.baseutils.string.StringUtils;
import com.tencent.ttpic.openapi.model.TextWMElement;

public class bnxa
  extends ReportDialog
{
  private int jdField_a_of_type_Int = 12;
  private transient TextPaint jdField_a_of_type_AndroidTextTextPaint;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bnxf jdField_a_of_type_Bnxf;
  private TextView b;
  
  public bnxa(@NonNull Context paramContext)
  {
    super(paramContext, 2131755357);
    a(paramContext);
    paramContext = getWindow();
    if (paramContext != null) {
      paramContext.setSoftInputMode(21);
    }
    setCanceledOnTouchOutside(true);
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidTextTextPaint = new TextPaint(1);
    this.jdField_a_of_type_AndroidTextTextPaint.setTypeface(Typeface.DEFAULT_BOLD);
    this.jdField_a_of_type_AndroidTextTextPaint.setAntiAlias(true);
  }
  
  private void a(Context paramContext)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(2131558499, null);
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)paramContext.findViewById(2131365786));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramContext.findViewById(2131365788));
    this.b = ((TextView)paramContext.findViewById(2131364112));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramContext.findViewById(2131364909));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramContext.findViewById(2131363947));
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new bnxb(this));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new bnxc(this));
    this.b.setOnClickListener(new bnxd(this));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new bnxe(this));
    setContentView(paramContext);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(bnxf parambnxf)
  {
    this.jdField_a_of_type_Bnxf = parambnxf;
  }
  
  public void a(TextWMElement paramTextWMElement, boolean paramBoolean)
  {
    String str1 = paramTextWMElement.userValue;
    String str2 = paramTextWMElement.color;
    a();
    if ((TextUtils.isEmpty(str1)) && (paramBoolean)) {
      if (!TextUtils.isEmpty(paramTextWMElement.fmtstr))
      {
        this.jdField_a_of_type_AndroidWidgetEditText.setText(paramTextWMElement.fmtstr);
        this.jdField_a_of_type_AndroidWidgetEditText.setSelection(paramTextWMElement.fmtstr.length());
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetEditText.selectAll();
      return;
      paramTextWMElement = StringUtils.removeUTF8Emoji(str1);
      this.jdField_a_of_type_AndroidWidgetEditText.setText(paramTextWMElement);
      this.jdField_a_of_type_AndroidWidgetEditText.setSelection(paramTextWMElement.length());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnxa
 * JD-Core Version:    0.7.0.1
 */