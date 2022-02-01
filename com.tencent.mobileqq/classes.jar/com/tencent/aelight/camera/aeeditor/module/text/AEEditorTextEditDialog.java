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
import com.tencent.qcircle.tavcut.bean.TextEditorData;
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
  private final View a;
  private final AEEditorTextEditDialog.AEEditorTextEditListener b;
  private SoftKeyboardStateHelper c;
  private String d;
  private String e;
  private TextEditorData f;
  private EditText g;
  private PAGView h;
  private boolean i;
  
  public AEEditorTextEditDialog(@NonNull Context paramContext, int paramInt, AEEditorTextEditDialog.AEEditorTextEditListener paramAEEditorTextEditListener)
  {
    super(paramContext, paramInt);
    this.b = paramAEEditorTextEditListener;
    this.a = LayoutInflater.from(paramContext).inflate(2064056457, null);
    this.a.setOnClickListener(new AEEditorTextEditDialog.1(this));
    f();
    setContentView(this.a);
    AEBaseDataReporter.a().B();
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
    localPAGText.fillColor = this.f.getTextColor();
    ThreadManager.getUIHandler().post(new AEEditorTextEditDialog.5(this, localPAGFile, paramTextEditorData, localPAGText));
  }
  
  private PAGFont b(TextEditorData paramTextEditorData)
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
  
  private void b()
  {
    this.d = getContext().getResources().getString(2064187668);
    this.e = getContext().getResources().getString(2064187655);
    this.g = ((EditText)this.a.findViewById(2063991057));
    this.h = ((PAGView)this.a.findViewById(2063991471));
    this.h.play();
    this.h.setRepeatCount(0);
    this.a.findViewById(2063991177).setOnClickListener(new AEEditorTextEditDialog.3(this));
    this.a.findViewById(2063991537).setOnClickListener(new AEEditorTextEditDialog.4(this));
    e();
    TextEditorData localTextEditorData = this.f;
    if ((localTextEditorData != null) && (!TextUtils.isEmpty(localTextEditorData.getContent())) && (!this.e.equals(this.f.getContent())))
    {
      this.g.setText(this.f.getContent());
      this.g.setSelection(this.f.getContent().length());
    }
    if (this.f == null) {
      this.f = new TextEditorData();
    }
    this.g.setHint(this.e);
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
      int k = localPAGComposition.numLayers();
      int j = 0;
      while (j < k)
      {
        PAGLayer localPAGLayer = localPAGComposition.getLayerAt(j);
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
        j += 1;
      }
    }
  }
  
  private void c()
  {
    Object localObject = this.f;
    if (localObject == null)
    {
      AEQLog.d("AEEditorTextEditDialog", "originTextData is null.");
      return;
    }
    if (TextUtils.isEmpty(((TextEditorData)localObject).getContent().trim())) {
      localObject = this.e;
    } else {
      localObject = this.f.getContent();
    }
    this.f.setContent((String)localObject);
    a(this.f);
  }
  
  private void d()
  {
    if (this.i) {
      return;
    }
    this.i = true;
    TextEditorData localTextEditorData = this.f;
    if (localTextEditorData == null)
    {
      AEQLog.d("AEEditorTextEditDialog", "originTextData is null.");
      return;
    }
    AEEditorTextEditDialog.AEEditorTextEditListener localAEEditorTextEditListener = this.b;
    if (localAEEditorTextEditListener != null) {
      localAEEditorTextEditListener.a(localTextEditorData);
    }
  }
  
  private void e()
  {
    this.g.addTextChangedListener(new AEEditorTextEditDialog.6(this));
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
    this.f = paramTextEditorData;
    try
    {
      paramTextEditorData = String.format("%06X", new Object[] { Integer.valueOf(paramInt & 0xFFFFFF) });
      if ((paramTextEditorData.substring(0, 2).compareTo("37") < 0) && (paramTextEditorData.substring(2, 4).compareTo("37") < 0) && (paramTextEditorData.substring(4, 6).compareTo("37") < 0))
      {
        this.a.setBackgroundColor(Color.parseColor("#CCFFFFFF"));
        return;
      }
      this.a.setBackgroundColor(Color.parseColor("#CC000000"));
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
    SoftKeyboardStateHelper localSoftKeyboardStateHelper = this.c;
    if (localSoftKeyboardStateHelper != null)
    {
      localSoftKeyboardStateHelper.a();
      this.c = null;
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
    this.i = false;
    this.c = new SoftKeyboardStateHelper(this.a);
    this.c.a(new AEEditorTextEditDialog.2(this));
    ObjectAnimator.ofFloat(this.a, "alpha", new float[] { 0.0F, 1.0F }).setDuration(300L).start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.text.AEEditorTextEditDialog
 * JD-Core Version:    0.7.0.1
 */