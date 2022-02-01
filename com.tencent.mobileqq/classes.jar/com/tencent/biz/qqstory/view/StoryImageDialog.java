package com.tencent.biz.qqstory.view;

import android.app.Dialog;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

public class StoryImageDialog
  extends ReportDialog
{
  private ImageView a;
  private TextView b;
  private Button c;
  private Button d;
  private ImageView e;
  private Drawable f;
  private String g;
  private String h;
  private String i;
  private View.OnClickListener j;
  private View.OnClickListener k;
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131628006);
    this.a = ((ImageView)findViewById(2131442657));
    this.b = ((TextView)findViewById(2131442699));
    this.e = ((ImageView)findViewById(2131442698));
    this.d = ((Button)findViewById(2131442703));
    this.c = ((Button)findViewById(2131442704));
    ((RelativeLayout)findViewById(2131442656)).setOnClickListener(new StoryImageDialog.1(this));
    if (this.f != null)
    {
      this.a.setVisibility(0);
      this.a.setImageDrawable(this.f);
    }
    else
    {
      this.a.setVisibility(8);
    }
    if (TextUtils.isEmpty(this.g))
    {
      this.b.setVisibility(8);
    }
    else
    {
      this.b.setVisibility(0);
      if (this.b.getPaint().measureText(this.g) > UIUtils.a(getContext(), 280.0F)) {
        this.b.setGravity(3);
      } else {
        this.b.setGravity(17);
      }
      this.b.setText(this.g);
    }
    if (TextUtils.isEmpty(this.i))
    {
      this.c.setVisibility(8);
    }
    else
    {
      this.c.setVisibility(0);
      this.c.setText(this.i);
      paramBundle = this.j;
      if (paramBundle != null) {
        this.c.setOnClickListener(paramBundle);
      } else {
        this.c.setOnClickListener(new StoryImageDialog.2(this));
      }
    }
    if (TextUtils.isEmpty(this.h))
    {
      this.d.setVisibility(8);
    }
    else
    {
      this.d.setVisibility(0);
      this.d.setTag(this.h);
      paramBundle = this.k;
      if (paramBundle != null) {
        this.d.setOnClickListener(paramBundle);
      } else {
        this.d.setOnClickListener(new StoryImageDialog.3(this));
      }
    }
    this.e.setOnClickListener(new StoryImageDialog.4(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.StoryImageDialog
 * JD-Core Version:    0.7.0.1
 */