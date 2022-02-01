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
  private static final String m = HardCodeUtil.a(2131901590);
  private View n;
  private RelativeLayout o;
  private TextView p;
  private TextView q;
  private int r = -1;
  private String s;
  private String x = "barindex";
  
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
        str = a;
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
          str = a;
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
    this.r = i;
    StringBuilder localStringBuilder;
    if (i == -1)
    {
      b(m);
      this.s = "";
    }
    else if (paramIntent != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("#");
      localStringBuilder.append(paramIntent);
      b(localStringBuilder.toString());
      this.s = paramIntent;
    }
    if (QLog.isColorLevel())
    {
      paramIntent = a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleSelectedTheme mThemeID = ");
      localStringBuilder.append(this.r);
      localStringBuilder.append(" mThemeName = ");
      localStringBuilder.append(this.s);
      QLog.d(paramIntent, 2, localStringBuilder.toString());
    }
  }
  
  private void a(String paramString)
  {
    int i;
    if ("barindex".equals(this.x)) {
      i = 1;
    } else {
      i = 2;
    }
    ReportController.b(null, "dc00899", "Grp_tribe", "", "video_edit", paramString, i, 0, "", "", "", "");
  }
  
  private void b(String paramString)
  {
    paramString = new SpannableString(paramString);
    int j = this.r;
    int i = -1;
    if (j != -1) {
      i = -18432;
    }
    paramString.setSpan(new VerticalImageSpan(u(), 2130843632), 0, 1, 33);
    this.p.setText(paramString);
    this.p.setTextColor(i);
  }
  
  private void k()
  {
    if ((this.r != -1) && (!TextUtils.isEmpty(this.s)))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("#");
      localStringBuilder.append(this.s);
      b(localStringBuilder.toString());
    }
    else
    {
      b(m);
    }
    this.p.setTextColor(-1);
    this.p.setTextSize(16.0F);
    this.p.setOnClickListener(new DovTribeEditVideoButton.1(this));
  }
  
  public void a()
  {
    super.a();
    this.o = ((RelativeLayout)d(2063990938));
    this.n = ((ImageView)d(2063991499));
    this.q = ((TextView)d(2063990984));
    this.n.setVisibility(8);
    this.q.setText(HardCodeUtil.a(2131901589));
    this.p = new TextView(u());
    this.p.setGravity(17);
    this.p.setMaxWidth(DisplayUtil.a(u(), 192.0F));
    this.p.setEllipsize(TextUtils.TruncateAt.END);
    this.p.setSingleLine(true);
    int i = DisplayUtil.a(u(), 10.0F);
    this.p.setPadding(i, 0, i, 0);
    this.p.setBackgroundResource(2130843633);
    Object localObject = new RelativeLayout.LayoutParams(-2, DisplayUtil.a(u(), 28.0F));
    ((RelativeLayout.LayoutParams)localObject).addRule(11);
    ((RelativeLayout.LayoutParams)localObject).addRule(15);
    ((RelativeLayout.LayoutParams)localObject).rightMargin = DisplayUtil.a(u(), 10.0F);
    this.o.addView(this.p, (ViewGroup.LayoutParams)localObject);
    localObject = a(((EditVideoParams)((Activity)u()).getIntent().getParcelableExtra(EditVideoParams.class.getName())).d);
    if (localObject != null)
    {
      boolean bool = ((JSONObject)localObject).optBoolean("needTheme", false);
      this.x = ((JSONObject)localObject).optString("from", "");
      this.r = ((JSONObject)localObject).optInt("theme_id", -1);
      this.s = ((JSONObject)localObject).optString("theme_name", "");
      if (QLog.isColorLevel())
      {
        localObject = a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onCreate mThemeID = ");
        localStringBuilder.append(this.r);
        localStringBuilder.append(" mThemeName = ");
        localStringBuilder.append(this.s);
        QLog.d((String)localObject, 2, localStringBuilder.toString());
      }
      k();
      if (!bool) {
        this.p.setVisibility(8);
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
  
  public int c()
  {
    return this.r;
  }
  
  public String d()
  {
    return this.s;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.DovTribeEditVideoButton
 * JD-Core Version:    0.7.0.1
 */