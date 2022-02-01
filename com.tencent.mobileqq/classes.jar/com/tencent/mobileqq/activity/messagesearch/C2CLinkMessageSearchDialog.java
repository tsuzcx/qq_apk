package com.tencent.mobileqq.activity.messagesearch;

import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MqqWeakReferenceHandler;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class C2CLinkMessageSearchDialog
  extends BaseMessageSearchDialog
{
  ArrayList<Object> A = new ArrayList();
  MessageForStructing B;
  private LinearLayout C;
  private List<MessageItem> D = new ArrayList();
  private Set<Long> E = new HashSet();
  private View.OnClickListener F = new C2CLinkMessageSearchDialog.4(this);
  int m = 0;
  C2CLinkMessageResultAdapter n;
  View o;
  LinearLayout p;
  TextView q;
  LinearLayout r;
  View s;
  LinearLayout t;
  TextView u;
  boolean v = false;
  boolean w = false;
  String x = "";
  String y = "";
  long z;
  
  public C2CLinkMessageSearchDialog(Context paramContext, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    super(paramContext, paramQQAppInterface, paramSessionInfo);
    paramContext = paramQQAppInterface.getCurrentAccountUin();
    if (!TextUtils.isEmpty(paramContext)) {
      "1".equals(paramContext.substring(paramContext.length() - 1, paramContext.length()));
    }
    j();
    g();
    i();
  }
  
  private void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("showHeaderViewByType, needShowType = ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(",tips: ");
      localStringBuilder.append(paramString);
      QLog.i("LinkMessageSearchDialog", 2, localStringBuilder.toString());
    }
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if (paramInt != 4)
            {
              if (paramInt != 5) {
                return;
              }
              this.p.setVisibility(8);
              this.q.setVisibility(8);
              return;
            }
            this.o.setVisibility(0);
            this.C.setVisibility(0);
            return;
          }
          this.o.setVisibility(0);
          this.r.setVisibility(8);
          this.p.setVisibility(0);
          this.q.setVisibility(8);
          return;
        }
        this.o.setVisibility(0);
        this.r.setVisibility(8);
        this.p.setVisibility(0);
        this.q.setVisibility(8);
        return;
      }
      this.o.setVisibility(0);
      this.r.setVisibility(8);
      this.p.setVisibility(0);
      this.q.setVisibility(0);
      return;
    }
    this.o.setVisibility(8);
    this.r.setVisibility(8);
    this.p.setVisibility(8);
    this.q.setVisibility(8);
    this.C.setVisibility(8);
  }
  
  private void g()
  {
    this.d = ((EditText)findViewById(2131432634));
    this.d.setFilters(new InputFilter[] { new InputFilter.LengthFilter(15) });
    this.d.addTextChangedListener(new C2CLinkMessageSearchDialog.1(this));
    this.d.setImeOptions(3);
    BaseMessageSearchDialog.EnterForSearch localEnterForSearch = new BaseMessageSearchDialog.EnterForSearch(this);
    this.d.setOnEditorActionListener(localEnterForSearch);
    this.d.setOnKeyListener(localEnterForSearch);
    this.d.setHint(this.c.getString(2131887731));
    this.d.setSelection(0);
    this.d.requestFocus();
  }
  
  private void h()
  {
    this.v = false;
    this.m = 0;
    this.D.clear();
    this.E.clear();
    this.w = false;
  }
  
  private void i()
  {
    ((ImageButton)findViewById(2131435215)).setOnClickListener(new C2CLinkMessageSearchDialog.2(this));
    Button localButton = (Button)findViewById(2131429816);
    localButton.setVisibility(0);
    localButton.setOnClickListener(new C2CLinkMessageSearchDialog.3(this));
  }
  
  private void j()
  {
    this.b = ((XListView)findViewById(2131445451));
    this.b.setVisibility(0);
    this.o = getLayoutInflater().inflate(2131625299, null);
    this.b.addHeaderView(this.o, null, false);
    this.r = ((LinearLayout)this.o.findViewById(2131444560));
    this.r.setClickable(false);
    this.p = ((LinearLayout)this.o.findViewById(2131445435));
    this.q = ((TextView)this.o.findViewById(2131445437));
    this.q.setOnClickListener(this.F);
    this.C = ((LinearLayout)this.o.findViewById(2131439372));
    this.C.setClickable(false);
    this.s = getLayoutInflater().inflate(2131628284, null);
    this.b.addFooterView(this.s, null, false);
    this.s.setClickable(false);
    this.t = ((LinearLayout)this.s.findViewById(2131444560));
    this.u = ((TextView)this.s.findViewById(2131438894));
    this.u.setText(this.c.getString(2131916114));
    this.s.setVisibility(8);
    this.n = new C2CLinkMessageResultAdapter(this.c, this.a, this.g, this.f);
    this.b.setAdapter(this.n);
    this.b.setOnScrollListener(new C2CLinkMessageSearchDialog.5(this));
    this.b.setOnTouchListener(new C2CLinkMessageSearchDialog.6(this));
    this.b.setOnItemClickListener(new C2CLinkMessageSearchDialog.7(this));
  }
  
  protected void a()
  {
    Object localObject = this.d.getText().toString().trim();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("searchMessage, keyword = ");
      localStringBuilder.append((String)localObject);
      QLog.i("LinkMessageSearchDialog", 2, localStringBuilder.toString());
    }
    if (((String)localObject).length() == 0) {
      return;
    }
    h();
    this.x = ((String)localObject);
    this.n.a(this.x);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("searchMessage, keyword: ");
      ((StringBuilder)localObject).append(this.x);
      ((StringBuilder)localObject).append(", netState: ");
      ((StringBuilder)localObject).append(AppNetConnInfo.isNetSupport());
      QLog.i("LinkMessageSearchDialog", 2, ((StringBuilder)localObject).toString());
    }
    this.z = System.currentTimeMillis();
    this.m = 0;
    this.n.a(this.z, this.x, 1);
    a(0, null);
  }
  
  public void a(List<Object> paramList)
  {
    this.n.a(paramList);
    this.A.clear();
    this.A.addAll(paramList);
  }
  
  public void dismiss()
  {
    ((InputMethodManager)this.c.getSystemService("input_method")).hideSoftInputFromWindow(this.d.getWindowToken(), 0);
    this.a.removeMessages(0);
    this.a.removeMessages(1);
    this.f.removeHandler(getClass());
    try
    {
      super.dismiss();
      return;
    }
    catch (Exception localException) {}
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("handleMessage, msg.what = ");
      ((StringBuilder)localObject1).append(paramMessage.what);
      ((StringBuilder)localObject1).append(",mSearchMode = ");
      ((StringBuilder)localObject1).append(this.m);
      QLog.i("LinkMessageSearchDialog", 2, ((StringBuilder)localObject1).toString());
    }
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2) {
          if (i != 6) {
            if (i == 8) {}
          }
        }
        for (;;)
        {
          return true;
          localObject1 = (HashMap)paramMessage.obj;
          paramMessage = (String)((HashMap)localObject1).get("keyword");
          long l = ((Long)((HashMap)localObject1).get("sequence")).longValue();
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("handleMessage : MSG_TYPE_QUERY_LOCAL_DONE lastRequestKeyWord = ");
            ((StringBuilder)localObject1).append(paramMessage);
            ((StringBuilder)localObject1).append(",currentKeyword = ");
            ((StringBuilder)localObject1).append(this.x);
            ((StringBuilder)localObject1).append(",searchSequence = ");
            ((StringBuilder)localObject1).append(l);
            ((StringBuilder)localObject1).append(",mCurrentSequence = ");
            ((StringBuilder)localObject1).append(this.z);
            ((StringBuilder)localObject1).append(",mIsComplete: ");
            ((StringBuilder)localObject1).append(this.w);
            QLog.i("LinkMessageSearchDialog", 2, ((StringBuilder)localObject1).toString());
          }
          if ((this.z == l) && (!TextUtils.isEmpty(paramMessage)) && (paramMessage.equals(this.x)))
          {
            if ((l == this.z) && (this.x.equals(paramMessage)))
            {
              this.v = false;
              this.s.setVisibility(8);
              this.t.setVisibility(8);
              this.n.a(this.D, this.w);
              if ((this.w) && (this.n.getCount() < 20))
              {
                this.u.setText(HardCodeUtil.a(2131899518));
                this.t.findViewById(2131440727).setVisibility(8);
                this.t.setVisibility(0);
                this.s.setVisibility(0);
              }
              this.n.notifyDataSetChanged();
              this.b.setAdapter(this.n);
              this.b.setSelection(0);
              this.D.clear();
            }
          }
          else
          {
            return true;
            localObject1 = (HashMap)paramMessage.obj;
            paramMessage = (String)((HashMap)localObject1).get("keyword");
            l = ((Long)((HashMap)localObject1).get("sequence")).longValue();
            localObject1 = (List)((HashMap)localObject1).get("data");
            Object localObject2;
            if (QLog.isColorLevel())
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("handleMessage: MERGE_LOCAL_MESSAGES_AND_CLOUD_MESSAGES reqKeyWord = ");
              ((StringBuilder)localObject2).append(paramMessage);
              ((StringBuilder)localObject2).append(",currentKeyword = ");
              ((StringBuilder)localObject2).append(this.x);
              ((StringBuilder)localObject2).append(",searchSequence = ");
              ((StringBuilder)localObject2).append(l);
              ((StringBuilder)localObject2).append(",mCurrentSequence = ");
              ((StringBuilder)localObject2).append(this.z);
              ((StringBuilder)localObject2).append(",mIsComplete: ");
              ((StringBuilder)localObject2).append(this.w);
              QLog.i("LinkMessageSearchDialog", 2, ((StringBuilder)localObject2).toString());
            }
            if ((!TextUtils.isEmpty(paramMessage)) && (this.z == l) && (this.x.equals(paramMessage)))
            {
              if ((l == this.z) && (this.x.equals(paramMessage)))
              {
                this.v = false;
                this.s.setVisibility(8);
                this.t.setVisibility(8);
                this.n.a((List)localObject1, this.w);
                this.n.notifyDataSetChanged();
                this.b.setAdapter(this.n);
                this.b.setSelection(0);
                this.D.clear();
              }
            }
            else
            {
              return true;
              localObject1 = paramMessage.getData();
              l = ((Bundle)localObject1).getLong("searchSequence", 0L);
              localObject1 = ((Bundle)localObject1).getString("searchKeyword");
              localObject2 = (List)paramMessage.obj;
              if (QLog.isColorLevel())
              {
                StringBuilder localStringBuilder = new StringBuilder();
                localStringBuilder.append("handleMessage : ACTION_SHOW_MESSAGE searchSequence: ");
                localStringBuilder.append(l);
                localStringBuilder.append(", keyword: ");
                localStringBuilder.append((String)localObject1);
                localStringBuilder.append(", mCurrentKeyword: ");
                localStringBuilder.append(this.x);
                localStringBuilder.append(", searchSequence: ");
                localStringBuilder.append(l);
                localStringBuilder.append(", mSearchSequence: ");
                localStringBuilder.append(this.z);
                localStringBuilder.append(", loadType: ");
                localStringBuilder.append(paramMessage.arg1);
                localStringBuilder.append(", size: ");
                if (localObject2 == null) {
                  i = 0;
                } else {
                  i = ((List)localObject2).size();
                }
                localStringBuilder.append(i);
                QLog.d("LinkMessageSearchDialog", 2, localStringBuilder.toString());
              }
              if ((localObject2 == null) || (l != this.z) || ((localObject1 != null) && (!((String)localObject1).equals(this.x)))) {
                break;
              }
              if (((1 == paramMessage.arg1) && (((List)localObject2).size() > 0) && (((List)localObject2).size() != 20)) || ((2 == paramMessage.arg1) && (((List)localObject2).size() == 0)))
              {
                this.u.setText(HardCodeUtil.a(2131899515));
                this.t.findViewById(2131440727).setVisibility(8);
                this.t.setVisibility(0);
                this.s.setVisibility(0);
                if (2 == paramMessage.arg1)
                {
                  this.v = false;
                  continue;
                }
              }
              if ((paramMessage.obj instanceof List))
              {
                this.n.a((List)paramMessage.obj, paramMessage.arg1, this.w, 0);
                this.n.notifyDataSetChanged();
              }
              if (this.n.getCount() == 0)
              {
                a(4, null);
              }
              else
              {
                this.C.setVisibility(8);
                this.b.setVisibility(0);
              }
              this.v = false;
            }
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("LinkMessageSearchDialog", 2, "handleMessage : ACTION_SHOW_MESSAGE sequence or keyword not equal, no load");
        }
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
    this.f.setHandler(getClass(), this.a);
    this.a.removeMessages(0);
    this.a.removeMessages(1);
    this.a.sendEmptyMessage(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.messagesearch.C2CLinkMessageSearchDialog
 * JD-Core Version:    0.7.0.1
 */