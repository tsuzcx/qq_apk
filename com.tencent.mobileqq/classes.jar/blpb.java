import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.EditText;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.tavsticker.core.TAVPAGFileManager;
import dov.com.qq.im.aeeditor.module.text.AEEditorColorSelectorView;
import dov.com.qq.im.aeeditor.module.text.AEEditorTextEditDialog.4;
import mqq.os.MqqHandler;
import org.libpag.PAGFile;
import org.libpag.PAGText;
import org.libpag.PAGView;

public class blpb
  extends Dialog
{
  private View jdField_a_of_type_AndroidViewView;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private blpg jdField_a_of_type_Blpg;
  private blph jdField_a_of_type_Blph;
  private AEEditorColorSelectorView jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorColorSelectorView;
  private String jdField_a_of_type_JavaLangString;
  private PAGView jdField_a_of_type_OrgLibpagPAGView;
  private View jdField_b_of_type_AndroidViewView;
  private String jdField_b_of_type_JavaLangString;
  private View jdField_c_of_type_AndroidViewView;
  private String jdField_c_of_type_JavaLangString;
  
  public blpb(@NonNull Context paramContext, int paramInt, blpg paramblpg)
  {
    super(paramContext, paramInt);
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(paramContext).inflate(2131558537, null);
    this.jdField_a_of_type_Blpg = paramblpg;
    e();
    setContentView(this.jdField_a_of_type_AndroidViewView);
  }
  
  private void a()
  {
    this.jdField_a_of_type_JavaLangString = getContext().getResources().getString(2131694202);
    this.jdField_b_of_type_JavaLangString = getContext().getResources().getString(2131691530);
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131368742);
    this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131378795);
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_a_of_type_AndroidViewView.findViewById(2131365841));
    this.jdField_a_of_type_OrgLibpagPAGView = ((PAGView)this.jdField_a_of_type_AndroidViewView.findViewById(2131377470));
    this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorColorSelectorView = ((AEEditorColorSelectorView)this.jdField_a_of_type_AndroidViewView.findViewById(2131364483));
    this.jdField_a_of_type_OrgLibpagPAGView.play();
    this.jdField_a_of_type_OrgLibpagPAGView.setRepeatCount(0);
    this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorColorSelectorView.setColorSelectedListener(new blpc(this));
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(new blpd(this));
    this.jdField_c_of_type_AndroidViewView.setOnClickListener(new blpe(this));
    d();
    if (this.jdField_a_of_type_Blph != null)
    {
      this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorColorSelectorView.setSelectedColor(this.jdField_a_of_type_Blph.a());
      this.jdField_a_of_type_AndroidWidgetEditText.setText(this.jdField_a_of_type_Blph.a());
      if (this.jdField_a_of_type_Blph.a() != null) {
        this.jdField_a_of_type_AndroidWidgetEditText.setSelection(this.jdField_a_of_type_Blph.a().length());
      }
    }
    if (this.jdField_a_of_type_Blph == null)
    {
      this.jdField_a_of_type_Blph = new blph();
      this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorColorSelectorView.setSelectedColor(-1);
    }
    this.jdField_a_of_type_AndroidWidgetEditText.setHint(this.jdField_b_of_type_JavaLangString);
    b();
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_Blph == null)
    {
      bljn.d("AEEditorTextEditDialog", "originTextData is null.");
      return;
    }
    Object localObject = this.jdField_a_of_type_Blph.a().trim();
    if (TextUtils.isEmpty((CharSequence)localObject)) {}
    PAGText localPAGText;
    for (String str = this.jdField_b_of_type_JavaLangString;; str = this.jdField_a_of_type_Blph.a())
    {
      float f = 1.0F;
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        f = 0.5F;
      }
      this.jdField_a_of_type_OrgLibpagPAGView.setAlpha(f);
      localObject = TAVPAGFileManager.getInstance().getPAGFileFromAsset(getContext(), "ae_editor_text_main.pag");
      if (localObject == null) {
        break;
      }
      localPAGText = ((PAGFile)localObject).getTextData(0);
      if (localPAGText != null) {
        break label106;
      }
      bljn.d("AEEditorTextEditDialog", "pagText is null.");
      return;
    }
    label106:
    localPAGText.text = str;
    localPAGText.fillColor = this.jdField_a_of_type_Blph.a();
    ThreadManager.getUIHandler().post(new AEEditorTextEditDialog.4(this, (PAGFile)localObject, localPAGText));
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_Blph == null) {
      bljn.d("AEEditorTextEditDialog", "originTextData is null.");
    }
    for (;;)
    {
      return;
      String str = this.jdField_a_of_type_Blph.a();
      Object localObject = str;
      if (TextUtils.isEmpty(str.trim())) {
        localObject = this.jdField_b_of_type_JavaLangString;
      }
      int i = this.jdField_a_of_type_Blph.a();
      if (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {}
      for (localObject = new bloy((String)localObject, "default_font", "", "default_style_1", i, ""); this.jdField_a_of_type_Blpg != null; localObject = new blpn(this.jdField_c_of_type_JavaLangString, (String)localObject, "default_font", "", "default_style_1", i, ""))
      {
        this.jdField_a_of_type_Blpg.a((blpo)localObject);
        return;
      }
    }
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new blpf(this));
  }
  
  private void e()
  {
    Window localWindow = getWindow();
    if (localWindow == null) {
      return;
    }
    requestWindowFeature(1);
    localWindow.setBackgroundDrawableResource(17170445);
    WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
    localLayoutParams.alpha = 1.0F;
    localLayoutParams.dimAmount = 1.0F;
    localWindow.setAttributes(localLayoutParams);
  }
  
  public void a(String paramString, blph paramblph)
  {
    this.jdField_c_of_type_JavaLangString = paramString;
    if (paramblph != null) {
      this.jdField_a_of_type_Blph = paramblph;
    }
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blpb
 * JD-Core Version:    0.7.0.1
 */