package com.tencent.mobileqq.activity.phone;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.widget.ListView;

class NewStyleCountryActivity$SearchDialog
  extends ReportDialog
  implements TextWatcher, View.OnClickListener, View.OnTouchListener
{
  EditText a;
  ImageButton b;
  private ListView d;
  private NewStyleCountryActivity.SearchAdapter e;
  private TextView f;
  private View g;
  
  public NewStyleCountryActivity$SearchDialog(NewStyleCountryActivity paramNewStyleCountryActivity, Context paramContext)
  {
    super(paramContext);
    requestWindowFeature(1);
    getWindow().setSoftInputMode(36);
    getWindow().addFlags(1024);
    getWindow().setBackgroundDrawable(new ColorDrawable());
    setContentView(2131628270);
    paramContext = getWindow().getAttributes();
    paramContext.x = 0;
    paramContext.y = 0;
    paramContext.width = -1;
    paramContext.windowAnimations = 16973824;
    paramContext.gravity = 51;
    this.a = ((EditText)findViewById(2131432634));
    this.a.addTextChangedListener(this);
    this.a.setSelection(0);
    this.a.requestFocus();
    this.b = ((ImageButton)findViewById(2131435215));
    this.b.setOnClickListener(this);
    paramContext = (Button)findViewById(2131429816);
    paramContext.setVisibility(0);
    paramContext.setOnClickListener(this);
    this.g = findViewById(2131444724);
    this.f = ((TextView)findViewById(2131439366));
    this.f.setCompoundDrawables(null, null, null, null);
    this.f.setText(2131916105);
    findViewById(2131445429).setVisibility(8);
    this.d = ((ListView)findViewById(2131445451));
    this.e = new NewStyleCountryActivity.SearchAdapter(paramNewStyleCountryActivity, null);
    this.d.setAdapter(this.e);
    this.d.setOnTouchListener(this);
  }
  
  void a(String paramString)
  {
    if ((!paramString.equals("")) && (paramString.trim().length() != 0))
    {
      this.g.setVisibility(0);
      this.e.a(paramString);
      if (this.e.getCount() == 0) {
        this.f.setVisibility(0);
      } else {
        this.f.setVisibility(8);
      }
      this.e.notifyDataSetChanged();
      return;
    }
    this.g.setVisibility(8);
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    paramEditable = this.a.getText().toString().trim();
    a(paramEditable);
    if (paramEditable.equals(""))
    {
      this.b.setVisibility(8);
      return;
    }
    this.b.setVisibility(0);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  /* Error */
  public void dismiss()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 209	android/app/Dialog:dismiss	()V
    //   4: aload_0
    //   5: invokestatic 214	com/tencent/qqperf/monitor/memory/ActivityLeakSolution:a	(Landroid/app/Dialog;)V
    //   8: return
    //   9: astore_1
    //   10: aload_0
    //   11: invokestatic 214	com/tencent/qqperf/monitor/memory/ActivityLeakSolution:a	(Landroid/app/Dialog;)V
    //   14: aload_1
    //   15: athrow
    //   16: astore_1
    //   17: goto -13 -> 4
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	20	0	this	SearchDialog
    //   9	6	1	localObject	Object
    //   16	1	1	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   0	4	9	finally
    //   0	4	16	java/lang/Exception
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == 2131429816) {
      dismiss();
    } else if (i == 2131435215) {
      this.a.setText("");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    ((InputMethodManager)this.c.getSystemService("input_method")).hideSoftInputFromWindow(paramView.getWindowToken(), 0);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.NewStyleCountryActivity.SearchDialog
 * JD-Core Version:    0.7.0.1
 */