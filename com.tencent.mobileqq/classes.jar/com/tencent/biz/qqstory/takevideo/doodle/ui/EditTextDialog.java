package com.tencent.biz.qqstory.takevideo.doodle.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
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
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.takevideo.EditVideoParams;
import com.tencent.biz.qqstory.takevideo.doodle.layer.TextLayer;
import com.tencent.biz.qqstory.takevideo.doodle.layer.model.TextInfo;
import com.tencent.biz.qqstory.takevideo.doodle.util.DisplayUtil;
import com.tencent.biz.qqstory.takevideo.view.widget.colorbar.HorizontalSelectColorLayout;
import com.tencent.biz.qqstory.takevideo.view.widget.colorbar.strategy.EditDialogStrokeStrategy;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.utils.StringUtil;
import ohm;
import ohn;
import oho;
import ohp;
import ohq;
import ohr;
import ohs;
import oht;

public class EditTextDialog
  extends Dialog
  implements View.OnClickListener
{
  public final int a;
  public ViewGroup a;
  public ViewTreeObserver.OnGlobalLayoutListener a;
  public EditText a;
  public TextView a;
  public EditVideoParams a;
  public TextInfo a;
  public EditTextDialog.EditTextDialogEventListener a;
  public HorizontalSelectColorLayout a;
  public String a;
  public int b;
  public TextView b;
  public int c = -1;
  public int d;
  public int e;
  public int f;
  
  public EditTextDialog(Context paramContext)
  {
    super(paramContext, 2131624201);
    this.jdField_a_of_type_Int = 420;
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerModelTextInfo = new TextInfo();
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)LayoutInflater.from(getContext()).inflate(2130970667, null));
    this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener = new oht(this, null);
    this.jdField_a_of_type_AndroidViewViewGroup.getViewTreeObserver().addOnGlobalLayoutListener(new ohs(this, null));
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131364358));
    this.jdField_a_of_type_AndroidWidgetEditText.setBackgroundColor(super.getContext().getResources().getColor(2131493770));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131371547));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131371548));
    if (TextLayer.jdField_a_of_type_Int > DisplayUtil.a(getContext(), 14.0F)) {
      this.jdField_a_of_type_AndroidWidgetEditText.setPadding(TextLayer.jdField_a_of_type_Int, DisplayUtil.a(getContext(), 5.0F), TextLayer.jdField_a_of_type_Int, DisplayUtil.a(getContext(), 5.0F));
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
      this.jdField_a_of_type_AndroidWidgetEditText.setCursorVisible(false);
      this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new ohm(this));
      this.jdField_a_of_type_AndroidWidgetEditText.setOnTouchListener(new ohn(this));
      this.jdField_a_of_type_AndroidWidgetEditText.setOnFocusChangeListener(new oho(this));
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout = ((HorizontalSelectColorLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131364351));
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout.setStrokeStrategy(new EditDialogStrokeStrategy(), false, 0);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout.setSelectedStrokeWithColor(com.tencent.biz.qqstory.takevideo.view.widget.colorbar.stroke.HorizontalStroke.a[7]);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout.setOnStrokeSelectedListener(new ohp(this));
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new ohq(this));
      this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(new ohr(this));
      return;
      this.jdField_a_of_type_AndroidWidgetEditText.setPadding(DisplayUtil.a(getContext(), 14.0F), DisplayUtil.a(getContext(), 5.0F), DisplayUtil.a(getContext(), 14.0F), DisplayUtil.a(getContext(), 5.0F));
    }
  }
  
  private void b()
  {
    Window localWindow = super.getWindow();
    WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
    localLayoutParams.width = -1;
    localLayoutParams.height = (DisplayUtil.b(getContext()) - b());
    localLayoutParams.flags |= 0x20;
    localLayoutParams.gravity = 80;
    localWindow.setAttributes(localLayoutParams);
  }
  
  public int a()
  {
    int i = this.jdField_a_of_type_AndroidWidgetEditText.getTop();
    int j = b();
    TextPaint localTextPaint = this.jdField_a_of_type_AndroidWidgetEditText.getPaint();
    return (int)(i + j + this.jdField_a_of_type_AndroidWidgetEditText.getBaseline() + localTextPaint.ascent());
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
  
  public void a(int paramInt)
  {
    this.f = paramInt;
  }
  
  public void a(EditVideoParams paramEditVideoParams)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams = paramEditVideoParams;
  }
  
  public void a(TextInfo paramTextInfo)
  {
    String str = paramTextInfo.jdField_a_of_type_JavaLangString;
    if (TextUtils.isEmpty(str))
    {
      str = "";
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#bbbbbb"));
      this.jdField_b_of_type_AndroidWidgetTextView.setEnabled(false);
    }
    for (;;)
    {
      paramTextInfo.jdField_a_of_type_JavaLangString = str;
      this.jdField_a_of_type_JavaLangString = str;
      this.d = paramTextInfo.jdField_a_of_type_Int;
      this.e = paramTextInfo.d;
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerModelTextInfo.a(paramTextInfo);
      SLog.b("EditTextDialog", "setTextInfo:" + this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerModelTextInfo.toString());
      this.jdField_a_of_type_AndroidWidgetEditText.setTextSize(DisplayUtil.b(getContext(), this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerModelTextInfo.jdField_b_of_type_Int));
      this.jdField_a_of_type_AndroidWidgetEditText.setTextColor(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerModelTextInfo.jdField_a_of_type_Int);
      this.jdField_a_of_type_AndroidWidgetEditText.setText(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerModelTextInfo.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_AndroidWidgetEditText.setSelection(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerModelTextInfo.jdField_a_of_type_JavaLangString.length());
      this.jdField_a_of_type_AndroidWidgetEditText.setCursorVisible(true);
      if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerModelTextInfo.c == 2)
      {
        this.jdField_a_of_type_AndroidWidgetEditText.setBackgroundColor(super.getContext().getResources().getColor(2131493770));
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout.setVisibility(0);
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout.setSelectedStrokeWithColor(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerModelTextInfo.jdField_a_of_type_Int);
      }
      this.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(this);
      return;
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#12b7f5"));
      this.jdField_b_of_type_AndroidWidgetTextView.setEnabled(true);
    }
  }
  
  public void a(EditTextDialog.EditTextDialogEventListener paramEditTextDialogEventListener)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiEditTextDialog$EditTextDialogEventListener = paramEditTextDialogEventListener;
  }
  
  protected int b()
  {
    return this.f;
  }
  
  public void onClick(View paramView)
  {
    super.dismiss();
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiEditTextDialog$EditTextDialogEventListener == null) {
      return;
    }
    String str2 = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = "";
    }
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerModelTextInfo.jdField_a_of_type_JavaLangString = str1;
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiEditTextDialog$EditTextDialogEventListener.a(false, this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerModelTextInfo);
  }
  
  public void setContentView(int paramInt)
  {
    this.jdField_b_of_type_Int = AIOUtils.a(100.0F, getContext().getResources());
    b();
    a();
    super.setContentView(this.jdField_a_of_type_AndroidViewViewGroup);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.doodle.ui.EditTextDialog
 * JD-Core Version:    0.7.0.1
 */