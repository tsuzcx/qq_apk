package com.tencent.mobileqq.activity.messagesearch;

import android.content.Context;
import android.content.res.Resources;
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
import com.tencent.mobileqq.activity.history.link.TroopLinkElement;
import com.tencent.mobileqq.activity.history.link.search.LinkMessageResultAdapter;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MqqWeakReferenceHandler;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LinkMessageSearchDialog
  extends BaseMessageSearchDialog
{
  String A = "";
  long B;
  private LinearLayout C;
  private List<MessageItem> D = new ArrayList();
  private Set<Long> E = new HashSet();
  private View.OnClickListener F = new LinkMessageSearchDialog.4(this);
  boolean m = false;
  int n = 0;
  LinkMessageResultAdapter o;
  View p;
  LinearLayout q;
  TextView r;
  LinearLayout s;
  TextView t;
  View u;
  LinearLayout v;
  TextView w;
  boolean x = false;
  boolean y = false;
  String z = "";
  
  public LinkMessageSearchDialog(Context paramContext, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, boolean paramBoolean)
  {
    super(paramContext, paramQQAppInterface, paramSessionInfo);
    this.m = paramBoolean;
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
              this.q.setVisibility(8);
              this.r.setVisibility(8);
              this.t.setVisibility(8);
              return;
            }
            this.p.setVisibility(0);
            this.C.setVisibility(0);
            return;
          }
          this.p.setVisibility(0);
          this.s.setVisibility(8);
          this.q.setVisibility(0);
          this.r.setVisibility(8);
          this.t.setVisibility(0);
          this.t.setClickable(false);
          this.t.setTextColor(this.c.getResources().getColor(2131168118));
          this.t.setText(paramString);
          return;
        }
        this.p.setVisibility(0);
        this.s.setVisibility(8);
        this.q.setVisibility(0);
        this.r.setVisibility(8);
        this.t.setVisibility(0);
        this.t.setClickable(true);
        this.t.setTextColor(this.c.getResources().getColor(2131167468));
        this.t.setText(paramString);
        return;
      }
      this.p.setVisibility(0);
      this.s.setVisibility(8);
      this.q.setVisibility(0);
      this.r.setVisibility(0);
      this.t.setVisibility(8);
      return;
    }
    this.p.setVisibility(8);
    this.s.setVisibility(8);
    this.q.setVisibility(8);
    this.r.setVisibility(8);
    this.t.setVisibility(8);
    this.C.setVisibility(8);
  }
  
  private void g()
  {
    this.d = ((EditText)findViewById(2131432634));
    this.d.setFilters(new InputFilter[] { new InputFilter.LengthFilter(15) });
    this.d.addTextChangedListener(new LinkMessageSearchDialog.1(this));
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
    this.x = false;
    this.n = 0;
    this.D.clear();
    this.E.clear();
    this.y = false;
  }
  
  private void i()
  {
    ((ImageButton)findViewById(2131435215)).setOnClickListener(new LinkMessageSearchDialog.2(this));
    Button localButton = (Button)findViewById(2131429816);
    localButton.setVisibility(0);
    localButton.setOnClickListener(new LinkMessageSearchDialog.3(this));
  }
  
  private void j()
  {
    this.b = ((XListView)findViewById(2131445451));
    this.b.setVisibility(0);
    this.p = getLayoutInflater().inflate(2131625299, null);
    this.b.addHeaderView(this.p, null, false);
    this.s = ((LinearLayout)this.p.findViewById(2131444560));
    this.s.setClickable(false);
    this.t = ((TextView)this.p.findViewById(2131445413));
    this.t.setOnClickListener(this.F);
    this.q = ((LinearLayout)this.p.findViewById(2131445435));
    this.r = ((TextView)this.p.findViewById(2131445437));
    this.r.setOnClickListener(this.F);
    this.C = ((LinearLayout)this.p.findViewById(2131439372));
    this.C.setClickable(false);
    this.u = getLayoutInflater().inflate(2131628284, null);
    this.b.addFooterView(this.u, null, false);
    this.u.setClickable(false);
    this.v = ((LinearLayout)this.u.findViewById(2131444560));
    this.w = ((TextView)this.u.findViewById(2131438894));
    this.w.setText(this.c.getString(2131916114));
    this.u.setVisibility(8);
    this.o = new LinkMessageResultAdapter(this.c, this.a, this.g, this.f);
    this.b.setAdapter(this.o);
    this.b.setOnScrollListener(new LinkMessageSearchDialog.5(this));
    this.b.setOnTouchListener(new LinkMessageSearchDialog.6(this));
    this.b.setOnItemClickListener(new LinkMessageSearchDialog.7(this));
    this.b.setOnItemLongClickListener(new LinkMessageSearchDialog.8(this));
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
    this.z = ((String)localObject);
    this.o.a(this.z);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("searchMessage, keyword: ");
      ((StringBuilder)localObject).append(this.z);
      ((StringBuilder)localObject).append(", needSearchInCloud: ");
      ((StringBuilder)localObject).append(this.m);
      ((StringBuilder)localObject).append(", netState: ");
      ((StringBuilder)localObject).append(AppNetConnInfo.isNetSupport());
      QLog.i("LinkMessageSearchDialog", 2, ((StringBuilder)localObject).toString());
    }
    this.B = System.currentTimeMillis();
    this.n = 0;
    this.o.a(this.B, this.z, 1);
  }
  
  public void a(List<TroopLinkElement> paramList)
  {
    this.o.a(paramList);
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
      ((StringBuilder)localObject1).append(this.n);
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
            ((StringBuilder)localObject1).append(this.z);
            ((StringBuilder)localObject1).append(",searchSequence = ");
            ((StringBuilder)localObject1).append(l);
            ((StringBuilder)localObject1).append(",mCurrentSequence = ");
            ((StringBuilder)localObject1).append(this.B);
            ((StringBuilder)localObject1).append(",mIsComplete: ");
            ((StringBuilder)localObject1).append(this.y);
            QLog.i("LinkMessageSearchDialog", 2, ((StringBuilder)localObject1).toString());
          }
          if ((this.m) && (this.B == l) && (!TextUtils.isEmpty(paramMessage)) && (paramMessage.equals(this.z)))
          {
            if ((l == this.B) && (this.z.equals(paramMessage)))
            {
              this.x = false;
              this.u.setVisibility(8);
              this.v.setVisibility(8);
              this.o.a(this.D, this.y);
              if ((this.y) && (this.o.getCount() < 20))
              {
                this.w.setText(HardCodeUtil.a(2131904063));
                this.v.findViewById(2131440727).setVisibility(8);
                this.v.setVisibility(0);
                this.u.setVisibility(0);
              }
              this.o.notifyDataSetChanged();
              this.b.setAdapter(this.o);
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
              ((StringBuilder)localObject2).append(this.z);
              ((StringBuilder)localObject2).append(",searchSequence = ");
              ((StringBuilder)localObject2).append(l);
              ((StringBuilder)localObject2).append(",mCurrentSequence = ");
              ((StringBuilder)localObject2).append(this.B);
              ((StringBuilder)localObject2).append(",mIsComplete: ");
              ((StringBuilder)localObject2).append(this.y);
              QLog.i("LinkMessageSearchDialog", 2, ((StringBuilder)localObject2).toString());
            }
            if ((!TextUtils.isEmpty(paramMessage)) && (this.m) && (this.B == l) && (this.z.equals(paramMessage)))
            {
              if ((l == this.B) && (this.z.equals(paramMessage)))
              {
                this.x = false;
                this.u.setVisibility(8);
                this.v.setVisibility(8);
                this.o.a((List)localObject1, this.y);
                this.o.notifyDataSetChanged();
                this.b.setAdapter(this.o);
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
                localStringBuilder.append(this.z);
                localStringBuilder.append(", searchSequence: ");
                localStringBuilder.append(l);
                localStringBuilder.append(", mSearchSequence: ");
                localStringBuilder.append(this.B);
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
              if ((localObject2 == null) || (l != this.B) || ((localObject1 != null) && (!((String)localObject1).equals(this.z)))) {
                break;
              }
              if (((1 == paramMessage.arg1) && (((List)localObject2).size() > 0) && (((List)localObject2).size() != 20)) || ((2 == paramMessage.arg1) && (((List)localObject2).size() == 0)))
              {
                this.w.setText(HardCodeUtil.a(2131904062));
                this.v.findViewById(2131440727).setVisibility(8);
                this.v.setVisibility(0);
                this.u.setVisibility(0);
                if (2 == paramMessage.arg1)
                {
                  this.x = false;
                  continue;
                }
              }
              if ((paramMessage.obj instanceof List))
              {
                this.o.a((List)paramMessage.obj, paramMessage.arg1, this.y, 0);
                this.o.notifyDataSetChanged();
              }
              if (this.o.getCount() == 0)
              {
                a(4, null);
              }
              else
              {
                this.C.setVisibility(8);
                this.b.setVisibility(0);
              }
              this.x = false;
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
 * Qualified Name:     com.tencent.mobileqq.activity.messagesearch.LinkMessageSearchDialog
 * JD-Core Version:    0.7.0.1
 */