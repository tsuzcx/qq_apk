package com.tencent.aelight.camera.aeeditor.module.text;

import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.EditText;
import com.tencent.aelight.camera.ae.report.AEBaseDataReporter;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.biz.subscribe.comment.SoftKeyboardStateHelper;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.tavcut.bean.TextEditorData;
import com.tencent.tavsticker.core.TAVFontManager;
import com.tencent.tavsticker.core.TAVPAGFileManager;
import com.tencent.tavsticker.utils.CollectionUtil;
import java.util.Map;
import mqq.os.MqqHandler;
import org.libpag.PAGComposition;
import org.libpag.PAGFile;
import org.libpag.PAGFont;
import org.libpag.PAGLayer;
import org.libpag.PAGSolidLayer;
import org.libpag.PAGText;
import org.libpag.PAGView;

public class AEEditorTextEditDialog
  extends Dialog
{
  private final View jdField_a_of_type_AndroidViewView;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private final AEEditorTextEditDialog.AEEditorTextEditListener jdField_a_of_type_ComTencentAelightCameraAeeditorModuleTextAEEditorTextEditDialog$AEEditorTextEditListener;
  private SoftKeyboardStateHelper jdField_a_of_type_ComTencentBizSubscribeCommentSoftKeyboardStateHelper;
  private TextEditorData jdField_a_of_type_ComTencentTavcutBeanTextEditorData;
  private String jdField_a_of_type_JavaLangString;
  private PAGView jdField_a_of_type_OrgLibpagPAGView;
  private boolean jdField_a_of_type_Boolean;
  private String b;
  
  public AEEditorTextEditDialog(@NonNull Context paramContext, int paramInt, AEEditorTextEditDialog.AEEditorTextEditListener paramAEEditorTextEditListener)
  {
    super(paramContext, paramInt);
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleTextAEEditorTextEditDialog$AEEditorTextEditListener = paramAEEditorTextEditListener;
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(paramContext).inflate(2064318585, null);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(new AEEditorTextEditDialog.1(this));
    f();
    setContentView(this.jdField_a_of_type_AndroidViewView);
    AEBaseDataReporter.a().A();
  }
  
  private PAGFont a(TextEditorData paramTextEditorData)
  {
    PAGFont localPAGFont = null;
    if (paramTextEditorData == null) {
      return null;
    }
    if (!TextUtils.isEmpty(paramTextEditorData.getFontPath())) {
      localPAGFont = TAVFontManager.getInstance().fontWithPath(paramTextEditorData.getFontPath());
    }
    return localPAGFont;
  }
  
  private void a(TextEditorData paramTextEditorData)
  {
    if (paramTextEditorData == null)
    {
      AEQLog.d("AEEditorTextEditDialog", "render PAV data null.");
      return;
    }
    PAGFile localPAGFile = TAVPAGFileManager.getInstance().getPAGFileFromPath(paramTextEditorData.getPagFilePath());
    if (localPAGFile == null)
    {
      AEQLog.d("AEEditorTextEditDialog", "render PAGFile null.");
      return;
    }
    PAGText localPAGText = localPAGFile.getTextData(0);
    if (localPAGText == null)
    {
      AEQLog.d("AEEditorTextEditDialog", "pagText is null.");
      return;
    }
    localPAGText.text = paramTextEditorData.getContent();
    localPAGText.fillColor = this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData.getTextColor();
    ThreadManager.getUIHandler().post(new AEEditorTextEditDialog.5(this, localPAGFile, paramTextEditorData, localPAGText));
  }
  
  private void b()
  {
    this.jdField_a_of_type_JavaLangString = getContext().getResources().getString(2064515347);
    this.b = getContext().getResources().getString(2064515312);
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_a_of_type_AndroidViewView.findViewById(2064122172));
    this.jdField_a_of_type_OrgLibpagPAGView = ((PAGView)this.jdField_a_of_type_AndroidViewView.findViewById(2064122673));
    this.jdField_a_of_type_OrgLibpagPAGView.play();
    this.jdField_a_of_type_OrgLibpagPAGView.setRepeatCount(0);
    this.jdField_a_of_type_AndroidViewView.findViewById(2064122298).setOnClickListener(new AEEditorTextEditDialog.3(this));
    this.jdField_a_of_type_AndroidViewView.findViewById(2064122762).setOnClickListener(new AEEditorTextEditDialog.4(this));
    e();
    TextEditorData localTextEditorData = this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData;
    if ((localTextEditorData != null) && (localTextEditorData.getContent() != null) && (!this.b.equals(this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData.getContent()))) {
      try
      {
        this.jdField_a_of_type_AndroidWidgetEditText.setText(this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData.getContent());
        this.jdField_a_of_type_AndroidWidgetEditText.setSelection(this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData.getContent().length());
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    if (this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData == null) {
      this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData = new TextEditorData();
    }
    this.jdField_a_of_type_AndroidWidgetEditText.setHint(this.b);
    c();
  }
  
  private static void b(Map<String, Integer> paramMap, PAGView paramPAGView)
  {
    if (paramPAGView != null)
    {
      PAGComposition localPAGComposition = paramPAGView.getComposition();
      if (localPAGComposition == null)
      {
        AEQLog.d("AEEditorTextEditDialog", "pagComposition null.");
        return;
      }
      int j = localPAGComposition.numLayers();
      int i = 0;
      while (i < j)
      {
        PAGLayer localPAGLayer = localPAGComposition.getLayerAt(i);
        if ((localPAGLayer != null) && (localPAGLayer.layerType() == 2) && ((localPAGLayer instanceof PAGSolidLayer)))
        {
          paramPAGView = null;
          if (!CollectionUtil.isEmptyMap(paramMap)) {
            paramPAGView = (Integer)paramMap.get(localPAGLayer.layerName());
          }
          if (paramPAGView != null) {
            ((PAGSolidLayer)localPAGLayer).setSolidColor(paramPAGView.intValue());
          }
        }
        i += 1;
      }
    }
  }
  
  private void c()
  {
    Object localObject = this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData;
    if (localObject == null)
    {
      AEQLog.d("AEEditorTextEditDialog", "originTextData is null.");
      return;
    }
    if (TextUtils.isEmpty(((TextEditorData)localObject).getContent().trim())) {
      localObject = this.b;
    } else {
      localObject = this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData.getContent();
    }
    this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData.setContent((String)localObject);
    a(this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData);
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    TextEditorData localTextEditorData = this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData;
    if (localTextEditorData == null)
    {
      AEQLog.d("AEEditorTextEditDialog", "originTextData is null.");
      return;
    }
    AEEditorTextEditDialog.AEEditorTextEditListener localAEEditorTextEditListener = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleTextAEEditorTextEditDialog$AEEditorTextEditListener;
    if (localAEEditorTextEditListener != null) {
      localAEEditorTextEditListener.a(localTextEditorData);
    }
  }
  
  private void e()
  {
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new AEEditorTextEditDialog.6(this));
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
  
  public void a(TextEditorData paramTextEditorData, int paramInt)
  {
    this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData = paramTextEditorData;
    try
    {
      paramTextEditorData = String.format("%06X", new Object[] { Integer.valueOf(paramInt & 0xFFFFFF) });
      if ((paramTextEditorData.substring(0, 2).compareTo("37") < 0) && (paramTextEditorData.substring(2, 4).compareTo("37") < 0) && (paramTextEditorData.substring(4, 6).compareTo("37") < 0))
      {
        this.jdField_a_of_type_AndroidViewView.setBackgroundColor(Color.parseColor("#CCFFFFFF"));
        return;
      }
      this.jdField_a_of_type_AndroidViewView.setBackgroundColor(Color.parseColor("#CC000000"));
      return;
    }
    catch (Exception paramTextEditorData)
    {
      AEQLog.a("AEEditorTextEditDialog", "setTextStickerData", paramTextEditorData);
    }
  }
  
  public void dismiss()
  {
    super.dismiss();
    SoftKeyboardStateHelper localSoftKeyboardStateHelper = this.jdField_a_of_type_ComTencentBizSubscribeCommentSoftKeyboardStateHelper;
    if (localSoftKeyboardStateHelper != null)
    {
      localSoftKeyboardStateHelper.a();
      this.jdField_a_of_type_ComTencentBizSubscribeCommentSoftKeyboardStateHelper = null;
    }
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    b();
  }
  
  public void show()
  {
    super.show();
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentBizSubscribeCommentSoftKeyboardStateHelper = new SoftKeyboardStateHelper(this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_ComTencentBizSubscribeCommentSoftKeyboardStateHelper.a(new AEEditorTextEditDialog.2(this));
    ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidViewView, "alpha", new float[] { 0.0F, 1.0F }).setDuration(300L).start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.text.AEEditorTextEditDialog
 * JD-Core Version:    0.7.0.1
 */