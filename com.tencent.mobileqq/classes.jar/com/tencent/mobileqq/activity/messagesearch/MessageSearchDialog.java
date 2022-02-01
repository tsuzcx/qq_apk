package com.tencent.mobileqq.activity.messagesearch;

import android.content.Context;
import android.os.Message;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MqqWeakReferenceHandler;
import com.tencent.widget.XListView;
import java.util.List;

public class MessageSearchDialog
  extends BaseMessageSearchDialog
{
  protected static final String m = "MessageSearchDialog";
  MessageResultAdapter n;
  SearchHistoryAdapter o;
  protected TextView p;
  boolean q = true;
  private View.OnClickListener r = new MessageSearchDialog.4(this);
  
  public MessageSearchDialog(Context paramContext, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    super(paramContext, paramQQAppInterface, paramSessionInfo);
    m();
    i();
    j();
    k();
  }
  
  private void i()
  {
    this.d = ((EditText)findViewById(2131432634));
    this.d.setFilters(new InputFilter[] { new InputFilter.LengthFilter(15) });
    this.d.addTextChangedListener(new MessageSearchDialog.1(this));
    this.d.setImeOptions(3);
    BaseMessageSearchDialog.EnterForSearch localEnterForSearch = new BaseMessageSearchDialog.EnterForSearch(this);
    this.d.setOnEditorActionListener(localEnterForSearch);
    this.d.setOnKeyListener(localEnterForSearch);
    this.d.setSelection(0);
    this.d.requestFocus();
    this.o.a("");
  }
  
  private void j()
  {
    ((ImageButton)findViewById(2131435215)).setOnClickListener(new MessageSearchDialog.2(this));
  }
  
  private void k()
  {
    Button localButton = (Button)findViewById(2131429816);
    localButton.setVisibility(0);
    localButton.setOnClickListener(new MessageSearchDialog.3(this));
  }
  
  private void l()
  {
    String str1 = this.d.getText().toString().trim();
    if (QLog.isColorLevel())
    {
      String str2 = m;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("loadMessageMore, currentKeyword = ");
      localStringBuilder.append(str1);
      QLog.i(str2, 2, localStringBuilder.toString());
    }
    this.n.a(System.currentTimeMillis(), str1, 2);
  }
  
  private void m()
  {
    this.b = ((XListView)findViewById(2131445451));
    this.n = new MessageResultAdapter(this.c, this.a, this.g, this.f);
    this.o = new SearchHistoryAdapter(this.c, this.a, this.f);
    this.b.setAdapter(this.o);
    this.b.setOnScrollListener(new MessageSearchDialog.5(this));
    this.b.setOnTouchListener(new MessageSearchDialog.6(this));
    this.b.setOnItemClickListener(new MessageSearchDialog.7(this));
    this.b.setOnItemLongClickListener(new MessageSearchDialog.8(this));
    this.p = ((TextView)findViewById(2131439366));
    this.p.setCompoundDrawables(null, null, null, null);
    this.p.setText(2131916105);
  }
  
  protected void a()
  {
    String str1 = this.d.getText().toString().trim();
    Object localObject;
    if (QLog.isColorLevel())
    {
      str2 = m;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("searchMessage, currentKeyword = ");
      ((StringBuilder)localObject).append(str1);
      QLog.i(str2, 2, ((StringBuilder)localObject).toString());
    }
    if (str1.length() == 0) {
      return;
    }
    String str2 = this.n.b();
    if ((this.b.getAdapter() == this.n) && (str1.equalsIgnoreCase(str2)))
    {
      if (QLog.isColorLevel())
      {
        localObject = m;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("searchMessage, skip, currentKeyword = ");
        localStringBuilder.append(str1);
        localStringBuilder.append(", mLastKeyword = ");
        localStringBuilder.append(str2);
        QLog.i((String)localObject, 2, localStringBuilder.toString());
      }
      return;
    }
    this.n.a(System.currentTimeMillis(), str1, 1);
    a(2131887734);
  }
  
  public void dismiss()
  {
    ((InputMethodManager)this.c.getSystemService("input_method")).hideSoftInputFromWindow(this.d.getWindowToken(), 0);
    this.a.removeMessages(0);
    this.a.removeMessages(1);
    try
    {
      super.dismiss();
      return;
    }
    catch (Exception localException) {}
  }
  
  void g()
  {
    this.p.setVisibility(8);
    this.b.setVisibility(0);
  }
  
  void h()
  {
    this.p.setVisibility(0);
    this.b.setVisibility(8);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (QLog.isColorLevel())
    {
      String str = m;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleMessage, msg.what = ");
      localStringBuilder.append(paramMessage.what);
      QLog.i(str, 2, localStringBuilder.toString());
    }
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3) {
            return true;
          }
          if (this.b.getAdapter() != this.o) {
            this.b.setAdapter(this.o);
          }
          this.o.notifyDataSetChanged();
          g();
          return true;
        }
        b();
        if (this.b.getAdapter() != this.n) {
          this.b.setAdapter(this.n);
        }
        if ((paramMessage.obj instanceof List))
        {
          this.n.a((List)paramMessage.obj, paramMessage.arg1);
          this.n.notifyDataSetChanged();
        }
        if (this.n.getCount() == 0)
        {
          h();
          return true;
        }
        g();
        return true;
      }
      e();
      return true;
    }
    d();
    return true;
  }
  
  public void show()
  {
    super.show();
    this.a.removeMessages(0);
    this.a.removeMessages(1);
    this.a.sendEmptyMessage(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.messagesearch.MessageSearchDialog
 * JD-Core Version:    0.7.0.1
 */