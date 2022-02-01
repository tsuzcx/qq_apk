package com.tencent.aelight.camera.aioeditor.takevideo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.qqstory.view.widget.VerticalImageSpan;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.editor.params.EditVideoParams;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class DovTribeEditVideoButton
  extends EditVideoButton
{
  public static final String a = "DovTribeEditVideoButton";
  private static final String jdField_b_of_type_JavaLangString = HardCodeUtil.a(2131703641);
  private View jdField_a_of_type_AndroidViewView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private int jdField_b_of_type_Int = -1;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private String jdField_c_of_type_JavaLangString;
  private String d = "barindex";
  
  public DovTribeEditVideoButton(EditVideoPartManager paramEditVideoPartManager, int paramInt)
  {
    super(paramEditVideoPartManager, paramInt);
  }
  
  public static JSONObject a(Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      paramBundle = paramBundle.getString("options");
      String str;
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        str = jdField_a_of_type_JavaLangString;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("getTribeJsonExtra option: ");
        localStringBuilder.append(paramBundle);
        QLog.d(str, 2, localStringBuilder.toString());
      }
      try
      {
        paramBundle = new JSONObject(paramBundle);
        return paramBundle;
      }
      catch (Exception paramBundle)
      {
        if (QLog.isColorLevel())
        {
          str = jdField_a_of_type_JavaLangString;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("getTribeJsonExtra: ");
          localStringBuilder.append(paramBundle);
          QLog.e(str, 2, localStringBuilder.toString());
        }
      }
    }
    return null;
  }
  
  private void a(Intent paramIntent)
  {
    if (paramIntent == null) {
      return;
    }
    int i = paramIntent.getIntExtra("theme_id", -1);
    paramIntent = paramIntent.getStringExtra("theme_name");
    this.jdField_b_of_type_Int = i;
    StringBuilder localStringBuilder;
    if (i == -1)
    {
      b(jdField_b_of_type_JavaLangString);
      this.jdField_c_of_type_JavaLangString = "";
    }
    else if (paramIntent != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("#");
      localStringBuilder.append(paramIntent);
      b(localStringBuilder.toString());
      this.jdField_c_of_type_JavaLangString = paramIntent;
    }
    if (QLog.isColorLevel())
    {
      paramIntent = jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleSelectedTheme mThemeID = ");
      localStringBuilder.append(this.jdField_b_of_type_Int);
      localStringBuilder.append(" mThemeName = ");
      localStringBuilder.append(this.jdField_c_of_type_JavaLangString);
      QLog.d(paramIntent, 2, localStringBuilder.toString());
    }
  }
  
  private void a(String paramString)
  {
    int i;
    if ("barindex".equals(this.d)) {
      i = 1;
    } else {
      i = 2;
    }
    ReportController.b(null, "dc00899", "Grp_tribe", "", "video_edit", paramString, i, 0, "", "", "", "");
  }
  
  private void b(String paramString)
  {
    paramString = new SpannableString(paramString);
    int j = this.jdField_b_of_type_Int;
    int i = -1;
    if (j != -1) {
      i = -18432;
    }
    paramString.setSpan(new VerticalImageSpan(a(), 2130842679), 0, 1, 33);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(paramString);
    this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(i);
  }
  
  private void g()
  {
    if ((this.jdField_b_of_type_Int != -1) && (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("#");
      localStringBuilder.append(this.jdField_c_of_type_JavaLangString);
      b(localStringBuilder.toString());
    }
    else
    {
      b(jdField_b_of_type_JavaLangString);
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-1);
    this.jdField_b_of_type_AndroidWidgetTextView.setTextSize(16.0F);
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(new DovTribeEditVideoButton.1(this));
  }
  
  public int a()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public String a()
  {
    return this.jdField_c_of_type_JavaLangString;
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)a(2064122007));
    this.jdField_a_of_type_AndroidViewView = ((ImageView)a(2064122719));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)a(2064122067));
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_c_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131703640));
    this.jdField_b_of_type_AndroidWidgetTextView = new TextView(a());
    this.jdField_b_of_type_AndroidWidgetTextView.setGravity(17);
    this.jdField_b_of_type_AndroidWidgetTextView.setMaxWidth(DisplayUtil.a(a(), 192.0F));
    this.jdField_b_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.END);
    this.jdField_b_of_type_AndroidWidgetTextView.setSingleLine(true);
    int i = DisplayUtil.a(a(), 10.0F);
    this.jdField_b_of_type_AndroidWidgetTextView.setPadding(i, 0, i, 0);
    this.jdField_b_of_type_AndroidWidgetTextView.setBackgroundResource(2130842680);
    Object localObject = new RelativeLayout.LayoutParams(-2, DisplayUtil.a(a(), 28.0F));
    ((RelativeLayout.LayoutParams)localObject).addRule(11);
    ((RelativeLayout.LayoutParams)localObject).addRule(15);
    ((RelativeLayout.LayoutParams)localObject).rightMargin = DisplayUtil.a(a(), 10.0F);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_b_of_type_AndroidWidgetTextView, (ViewGroup.LayoutParams)localObject);
    localObject = a(((EditVideoParams)((Activity)a()).getIntent().getParcelableExtra(EditVideoParams.class.getName())).a);
    if (localObject != null)
    {
      boolean bool = ((JSONObject)localObject).optBoolean("needTheme", false);
      this.d = ((JSONObject)localObject).optString("from", "");
      this.jdField_b_of_type_Int = ((JSONObject)localObject).optInt("theme_id", -1);
      this.jdField_c_of_type_JavaLangString = ((JSONObject)localObject).optString("theme_name", "");
      if (QLog.isColorLevel())
      {
        localObject = jdField_a_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onCreate mThemeID = ");
        localStringBuilder.append(this.jdField_b_of_type_Int);
        localStringBuilder.append(" mThemeName = ");
        localStringBuilder.append(this.jdField_c_of_type_JavaLangString);
        QLog.d((String)localObject, 2, localStringBuilder.toString());
      }
      g();
      if (!bool) {
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == 0) {
      return;
    }
    if (paramInt1 != 1001) {
      return;
    }
    a(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.DovTribeEditVideoButton
 * JD-Core Version:    0.7.0.1
 */