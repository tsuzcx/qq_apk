import android.app.Dialog;
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
import com.tencent.ttpic.baseutils.string.StringUtils;
import com.tencent.ttpic.openapi.model.TextWMElement;

public class blhn
  extends Dialog
{
  private int jdField_a_of_type_Int = 12;
  private transient TextPaint jdField_a_of_type_AndroidTextTextPaint;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private blhs jdField_a_of_type_Blhs;
  private TextView b;
  
  public blhn(@NonNull Context paramContext)
  {
    super(paramContext, 2131755351);
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
    paramContext = LayoutInflater.from(paramContext).inflate(2131558487, null);
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)paramContext.findViewById(2131365551));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramContext.findViewById(2131365553));
    this.b = ((TextView)paramContext.findViewById(2131363909));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramContext.findViewById(2131364689));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramContext.findViewById(2131363741));
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new blho(this));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new blhp(this));
    this.b.setOnClickListener(new blhq(this));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new blhr(this));
    setContentView(paramContext);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(blhs paramblhs)
  {
    this.jdField_a_of_type_Blhs = paramblhs;
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
 * Qualified Name:     blhn
 * JD-Core Version:    0.7.0.1
 */