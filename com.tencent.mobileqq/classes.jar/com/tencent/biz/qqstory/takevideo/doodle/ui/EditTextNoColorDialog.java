package com.tencent.biz.qqstory.takevideo.doodle.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import com.tencent.biz.qqstory.takevideo.doodle.layer.TextLayer;
import com.tencent.biz.qqstory.takevideo.doodle.layer.model.TextInfo;
import com.tencent.biz.qqstory.takevideo.doodle.ui.widget.ClipboardEditText;
import com.tencent.biz.qqstory.takevideo.doodle.util.DisplayUtil;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

public class EditTextNoColorDialog
  extends ReportDialog
  implements View.OnClickListener
{
  public int a;
  public ViewGroup a;
  public ViewTreeObserver.OnGlobalLayoutListener a;
  public TextInfo a;
  public EditTextNoColorDialog.EditTextDialogEventListener a;
  public ClipboardEditText a;
  public int b;
  public int c;
  
  private void a()
  {
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)LayoutInflater.from(getContext()).inflate(2131561943, null));
    this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener = new EditTextNoColorDialog.LayoutChangeListener(this, null);
    this.jdField_a_of_type_AndroidViewViewGroup.getViewTreeObserver().addOnGlobalLayoutListener(new EditTextNoColorDialog.InitialLayoutListener(this, null));
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiWidgetClipboardEditText = ((ClipboardEditText)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131379182));
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiWidgetClipboardEditText.setBackgroundColor(super.getContext().getResources().getColor(2131166489));
    if (TextLayer.jdField_a_of_type_Int > DisplayUtil.b(getContext(), 14.0F)) {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiWidgetClipboardEditText.setPadding(TextLayer.jdField_a_of_type_Int, DisplayUtil.b(getContext(), 5.0F), TextLayer.jdField_a_of_type_Int, DisplayUtil.b(getContext(), 5.0F));
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiWidgetClipboardEditText.requestFocus();
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiWidgetClipboardEditText.setCursorVisible(false);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiWidgetClipboardEditText.addTextChangedListener(new EditTextNoColorDialog.1(this));
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiWidgetClipboardEditText.setOnTouchListener(new EditTextNoColorDialog.2(this));
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiWidgetClipboardEditText.setOnFocusChangeListener(new EditTextNoColorDialog.3(this));
      return;
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiWidgetClipboardEditText.setPadding(DisplayUtil.b(getContext(), 14.0F), DisplayUtil.b(getContext(), 5.0F), DisplayUtil.b(getContext(), 14.0F), DisplayUtil.b(getContext(), 5.0F));
    }
  }
  
  private void b()
  {
    Window localWindow = super.getWindow();
    if (localWindow != null)
    {
      WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
      localLayoutParams.width = -1;
      localLayoutParams.flags |= 0x20;
      localLayoutParams.gravity = 80;
      localWindow.setAttributes(localLayoutParams);
    }
  }
  
  protected int a()
  {
    int i = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiWidgetClipboardEditText.getTop();
    int j = b();
    TextPaint localTextPaint = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiWidgetClipboardEditText.getPaint();
    return (int)(i + j + this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiWidgetClipboardEditText.getBaseline() + localTextPaint.ascent());
  }
  
  public int a(String paramString)
  {
    int i = 0;
    int k = 0;
    if (TextUtils.isEmpty(paramString)) {}
    int m;
    int j;
    do
    {
      return k;
      paramString = paramString.toCharArray();
      m = paramString.length;
      j = 0;
      k = i;
    } while (j >= m);
    if (StringUtil.c(paramString[j])) {
      i += 3;
    }
    for (;;)
    {
      j += 1;
      break;
      i += 1;
    }
  }
  
  protected int b()
  {
    return this.c;
  }
  
  public void onClick(View paramView)
  {
    InputMethodManager localInputMethodManager = (InputMethodManager)getContext().getSystemService("input_method");
    if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiWidgetClipboardEditText != null) && (localInputMethodManager.isActive())) {
      localInputMethodManager.toggleSoftInput(1, 2);
    }
    super.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiEditTextNoColorDialog$EditTextDialogEventListener == null) {
      return;
    }
    String str2 = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiWidgetClipboardEditText.getText().toString();
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = "";
    }
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerModelTextInfo.a = str1;
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiEditTextNoColorDialog$EditTextDialogEventListener.a(false, this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerModelTextInfo);
  }
  
  public void setContentView(int paramInt)
  {
    this.jdField_a_of_type_Int = AIOUtils.a(100.0F, getContext().getResources());
    b();
    a();
    super.setContentView(this.jdField_a_of_type_AndroidViewViewGroup);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.doodle.ui.EditTextNoColorDialog
 * JD-Core Version:    0.7.0.1
 */