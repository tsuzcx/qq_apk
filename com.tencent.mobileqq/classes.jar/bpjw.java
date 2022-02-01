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
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.tavcut.bean.TextEditorData;
import com.tencent.tavsticker.core.TAVFontManager;
import com.tencent.tavsticker.core.TAVPAGFileManager;
import com.tencent.tavsticker.utils.CollectionUtil;
import dov.com.qq.im.aeeditor.module.text.AEEditorTextEditDialog.3;
import java.util.Map;
import mqq.os.MqqHandler;
import org.libpag.PAGComposition;
import org.libpag.PAGFile;
import org.libpag.PAGFont;
import org.libpag.PAGLayer;
import org.libpag.PAGSolidLayer;
import org.libpag.PAGText;
import org.libpag.PAGView;

public class bpjw
  extends ReportDialog
{
  private View jdField_a_of_type_AndroidViewView;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private bpka jdField_a_of_type_Bpka;
  private TextEditorData jdField_a_of_type_ComTencentTavcutBeanTextEditorData;
  private String jdField_a_of_type_JavaLangString;
  private PAGView jdField_a_of_type_OrgLibpagPAGView;
  private View jdField_b_of_type_AndroidViewView;
  private String jdField_b_of_type_JavaLangString;
  private View c;
  
  public bpjw(@NonNull Context paramContext, int paramInt, bpka parambpka)
  {
    super(paramContext, paramInt);
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(paramContext).inflate(2131558562, null);
    this.jdField_a_of_type_Bpka = parambpka;
    f();
    setContentView(this.jdField_a_of_type_AndroidViewView);
    bozr.a().y();
  }
  
  private PAGFont a(TextEditorData paramTextEditorData)
  {
    if (paramTextEditorData == null) {}
    while (TextUtils.isEmpty(paramTextEditorData.getFontPath())) {
      return null;
    }
    return TAVFontManager.getInstance().fontWithPath(paramTextEditorData.getFontPath());
  }
  
  private void b()
  {
    this.jdField_a_of_type_JavaLangString = getContext().getResources().getString(2131693480);
    this.jdField_b_of_type_JavaLangString = getContext().getResources().getString(2131691302);
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131369171);
    this.c = this.jdField_a_of_type_AndroidViewView.findViewById(2131379838);
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_a_of_type_AndroidViewView.findViewById(2131366140));
    this.jdField_a_of_type_OrgLibpagPAGView = ((PAGView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378462));
    this.jdField_a_of_type_OrgLibpagPAGView.play();
    this.jdField_a_of_type_OrgLibpagPAGView.setRepeatCount(0);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(new bpjx(this));
    this.c.setOnClickListener(new bpjy(this));
    e();
    if (this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData != null)
    {
      this.jdField_a_of_type_AndroidWidgetEditText.setText(this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData.getContent());
      if (this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData.getContent() != null) {
        this.jdField_a_of_type_AndroidWidgetEditText.setSelection(this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData.getContent().length());
      }
    }
    if (this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData == null) {
      this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData = new TextEditorData();
    }
    this.jdField_a_of_type_AndroidWidgetEditText.setHint(this.jdField_b_of_type_JavaLangString);
    c();
  }
  
  private void b(TextEditorData paramTextEditorData)
  {
    if (paramTextEditorData == null)
    {
      bpam.d("AEEditorTextEditDialog", "render PAV data null.");
      return;
    }
    PAGFile localPAGFile = TAVPAGFileManager.getInstance().getPAGFileFromPath(paramTextEditorData.getPagFilePath());
    if (localPAGFile == null)
    {
      bpam.d("AEEditorTextEditDialog", "render PAGFile null.");
      return;
    }
    PAGText localPAGText = localPAGFile.getTextData(0);
    if (localPAGText == null)
    {
      bpam.d("AEEditorTextEditDialog", "pagText is null.");
      return;
    }
    localPAGText.text = paramTextEditorData.getContent();
    localPAGText.fillColor = this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData.getTextColor();
    ThreadManager.getUIHandler().post(new AEEditorTextEditDialog.3(this, localPAGFile, paramTextEditorData, localPAGText));
  }
  
  private static void b(Map<String, Integer> paramMap, PAGView paramPAGView)
  {
    PAGComposition localPAGComposition;
    if (paramPAGView != null)
    {
      localPAGComposition = paramPAGView.getComposition();
      if (localPAGComposition == null) {
        bpam.d("AEEditorTextEditDialog", "pagComposition null.");
      }
    }
    else
    {
      return;
    }
    int j = localPAGComposition.numLayers();
    int i = 0;
    label31:
    PAGLayer localPAGLayer;
    if (i < j)
    {
      localPAGLayer = localPAGComposition.getLayerAt(i);
      if (localPAGLayer != null) {
        break label56;
      }
    }
    label56:
    label117:
    for (;;)
    {
      i += 1;
      break label31;
      break;
      if ((localPAGLayer.layerType() == 2) && ((localPAGLayer instanceof PAGSolidLayer)))
      {
        if (!CollectionUtil.isEmptyMap(paramMap)) {}
        for (paramPAGView = (Integer)paramMap.get(localPAGLayer.layerName());; paramPAGView = null)
        {
          if (paramPAGView == null) {
            break label117;
          }
          ((PAGSolidLayer)localPAGLayer).setSolidColor(paramPAGView.intValue());
          break;
        }
      }
    }
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData == null)
    {
      bpam.d("AEEditorTextEditDialog", "originTextData is null.");
      return;
    }
    String str2 = this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData.getContent().trim();
    if (TextUtils.isEmpty(str2)) {}
    for (String str1 = this.jdField_b_of_type_JavaLangString;; str1 = this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData.getContent())
    {
      this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData.setContent(str1);
      float f = 1.0F;
      if (TextUtils.isEmpty(str2)) {
        f = 0.5F;
      }
      this.jdField_a_of_type_OrgLibpagPAGView.setAlpha(f);
      b(this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData);
      return;
    }
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData == null) {
      bpam.d("AEEditorTextEditDialog", "originTextData is null.");
    }
    while (this.jdField_a_of_type_Bpka == null) {
      return;
    }
    this.jdField_a_of_type_Bpka.a(this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData);
  }
  
  private void e()
  {
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new bpjz(this));
  }
  
  private void f()
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
  
  public void a()
  {
    c();
  }
  
  public void a(TextEditorData paramTextEditorData)
  {
    this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData = paramTextEditorData;
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpjw
 * JD-Core Version:    0.7.0.1
 */