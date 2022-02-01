package com.tencent.biz.widgets;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ChatActivityConstants;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

public class ShareAioResultDialog
  extends ReportDialog
{
  private TextView a;
  private TextView b;
  private TextView c;
  private ImageView d;
  
  public ShareAioResultDialog(Context paramContext)
  {
    super(paramContext, 2131953338);
    super.setContentView(2131626510);
    super.getWindow().setWindowAnimations(2131951986);
    a();
  }
  
  public void a()
  {
    this.a = ((TextView)super.findViewById(2131431864));
    this.b = ((TextView)super.findViewById(2131431870));
    this.c = ((TextView)super.findViewById(2131447473));
    this.d = ((ImageView)super.findViewById(2131447474));
    this.d.setColorFilter(-7745469, PorterDuff.Mode.MULTIPLY);
  }
  
  public void a(DialogInterface.OnClickListener paramOnClickListener)
  {
    if (ChatActivityConstants.b)
    {
      Resources localResources = getContext().getResources();
      this.b.setContentDescription(localResources.getString(2131887624, new Object[] { localResources.getString(2131916400) }));
    }
    this.b.setOnClickListener(new ShareAioResultDialog.2(this, paramOnClickListener));
  }
  
  public void a(String paramString)
  {
    TextView localTextView = this.c;
    if (localTextView != null) {
      localTextView.setText(paramString);
    }
  }
  
  public void a(String paramString, DialogInterface.OnClickListener paramOnClickListener)
  {
    this.a.setText(paramString);
    if (ChatActivityConstants.b)
    {
      Resources localResources = getContext().getResources();
      TextView localTextView = this.a;
      String str = paramString;
      if (paramString == null) {
        str = "";
      }
      localTextView.setContentDescription(localResources.getString(2131887624, new Object[] { str }));
    }
    this.a.setOnClickListener(new ShareAioResultDialog.1(this, paramOnClickListener));
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.d.setVisibility(0);
      return;
    }
    this.d.setVisibility(8);
  }
  
  public void dismiss()
  {
    try
    {
      super.dismiss();
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.widgets.ShareAioResultDialog
 * JD-Core Version:    0.7.0.1
 */