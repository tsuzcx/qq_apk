package com.tencent.mobileqq.activity.messagesearch;

import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.history.tendoc.TenDocMessageResultAdapter;
import com.tencent.mobileqq.activity.history.tendoc.TencentDocItem;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TenDocMessageSearchDialog
  extends BaseMessageSearchDialog
{
  private EditText m;
  private View n;
  private LinearLayout o;
  private ImageButton p;
  private TenDocMessageResultAdapter q;
  private String r = "";
  private long s;
  private int t;
  
  public TenDocMessageSearchDialog(Context paramContext, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, int paramInt)
  {
    super(paramContext, paramQQAppInterface, paramSessionInfo);
    this.t = paramInt;
    g();
    h();
    i();
  }
  
  private void a(View paramView)
  {
    if (paramView == null) {
      return;
    }
    InputMethodManager localInputMethodManager = (InputMethodManager)this.c.getSystemService("input_method");
    if (localInputMethodManager == null) {
      return;
    }
    localInputMethodManager.hideSoftInputFromWindow(paramView.getWindowToken(), 0);
  }
  
  private void g()
  {
    this.b = ((XListView)findViewById(2131445451));
    View localView = getLayoutInflater().inflate(2131625299, this.b, false);
    this.n = getLayoutInflater().inflate(2131628284, this.b, false);
    this.o = ((LinearLayout)localView.findViewById(2131439372));
    this.o.setClickable(false);
    this.n.setVisibility(8);
    this.n.setClickable(false);
    this.n.findViewById(2131444560).setVisibility(0);
    this.n.findViewById(2131440727).setVisibility(8);
    ((TextView)this.n.findViewById(2131438894)).setText(this.c.getString(2131916117));
    this.b.setVisibility(0);
    this.b.addHeaderView(localView, null, false);
    this.b.addFooterView(this.n, null, false);
    this.q = new TenDocMessageResultAdapter(this.c, this.a, this.g, this.f);
    this.b.setAdapter(this.q);
    this.p = ((ImageButton)findViewById(2131435215));
    this.b.setOnTouchListener(new TenDocMessageSearchDialog.1(this));
    this.b.setOnItemClickListener(new TenDocMessageSearchDialog.2(this));
  }
  
  private void h()
  {
    this.m = ((EditText)findViewById(2131432634));
    this.m.setFilters(new InputFilter[] { new InputFilter.LengthFilter(15) });
    this.m.addTextChangedListener(new TenDocMessageSearchDialog.3(this));
    this.m.setImeOptions(3);
    BaseMessageSearchDialog.EnterForSearch localEnterForSearch = new BaseMessageSearchDialog.EnterForSearch(this);
    this.m.setOnEditorActionListener(localEnterForSearch);
    this.m.setOnKeyListener(localEnterForSearch);
    this.m.setHint(this.c.getString(2131887746));
    this.m.setSelection(0);
    this.m.requestFocus();
  }
  
  private void i()
  {
    this.p.setOnClickListener(new TenDocMessageSearchDialog.4(this));
    Button localButton = (Button)findViewById(2131429816);
    localButton.setVisibility(0);
    localButton.setOnClickListener(new TenDocMessageSearchDialog.5(this));
  }
  
  protected void a()
  {
    Object localObject = this.m.getText().toString().trim();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("searchMessage, keyword = ");
      localStringBuilder.append((String)localObject);
      QLog.i("TenDocMessageSearchDialog", 2, localStringBuilder.toString());
    }
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return;
    }
    this.o.setVisibility(8);
    this.n.setVisibility(8);
    this.r = ((String)localObject);
    this.s = System.currentTimeMillis();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("searchMessage, keyword: ");
      ((StringBuilder)localObject).append(this.r);
      ((StringBuilder)localObject).append(", netState: ");
      ((StringBuilder)localObject).append(AppNetConnInfo.isNetSupport());
      QLog.i("TenDocMessageSearchDialog", 2, ((StringBuilder)localObject).toString());
    }
    this.q.a(this.r);
    this.q.a(this.s, this.r, 1);
    ReportController.b(this.f, "dc00898", "", "", "0X800A174", "0X800A174", this.t, 0, "", "", "s_qq_history_tab", "");
  }
  
  public void a(List<Object> paramList)
  {
    if (paramList == null) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = paramList.next();
      if ((localObject instanceof TencentDocItem)) {
        localArrayList.add((TencentDocItem)localObject);
      }
    }
    this.q.a(localArrayList);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 2)
    {
      if (QLog.isColorLevel()) {
        QLog.i("TenDocMessageSearchDialog", 2, "handleMessage, catch show message");
      }
      Object localObject = paramMessage.getData();
      long l = ((Bundle)localObject).getLong("searchSequence", 0L);
      localObject = ((Bundle)localObject).getString("searchKeyword");
      if (((paramMessage.obj instanceof List)) && (l == this.s) && (TextUtils.equals(this.r, (CharSequence)localObject)))
      {
        List localList = (List)paramMessage.obj;
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("handleMessage : ACTION_SHOW_MESSAGE searchSequence: ");
          localStringBuilder.append(l);
          localStringBuilder.append(", keyword: ");
          localStringBuilder.append((String)localObject);
          localStringBuilder.append(", mCurrentKeyword: ");
          localStringBuilder.append(this.r);
          localStringBuilder.append(", searchSequence: ");
          localStringBuilder.append(l);
          localStringBuilder.append(", mCurrentSearchSequence: ");
          localStringBuilder.append(this.s);
          localStringBuilder.append(", loadType: ");
          localStringBuilder.append(paramMessage.arg1);
          localStringBuilder.append(", size: ");
          int i;
          if (localList == null) {
            i = 0;
          } else {
            i = localList.size();
          }
          localStringBuilder.append(i);
          QLog.d("TenDocMessageSearchDialog", 2, localStringBuilder.toString());
        }
        this.q.a(localList, paramMessage.arg1);
        if (this.q.getCount() == 0)
        {
          this.o.setVisibility(0);
          this.n.setVisibility(8);
          return true;
        }
        this.o.setVisibility(8);
        this.n.setVisibility(0);
        return true;
      }
      if (QLog.isColorLevel()) {
        QLog.d("TenDocMessageSearchDialog", 2, "handleMessage : ACTION_SHOW_MESSAGE sequence or keyword not equal, no load");
      }
      return true;
    }
    return super.handleMessage(paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.messagesearch.TenDocMessageSearchDialog
 * JD-Core Version:    0.7.0.1
 */