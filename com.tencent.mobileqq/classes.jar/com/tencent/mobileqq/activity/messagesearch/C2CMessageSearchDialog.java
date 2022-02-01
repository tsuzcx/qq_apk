package com.tencent.mobileqq.activity.messagesearch;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Message;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextUtils;
import android.util.Pair;
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
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageRoamManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MqqWeakReferenceHandler;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import tencent.im.oidb.searcher.oidb_c2c_searcher.Iterator;

public class C2CMessageSearchDialog
  extends BaseMessageSearchDialog
{
  String A = "";
  long B;
  boolean C = false;
  private LinearLayout D;
  private List<MessageItem> E = new ArrayList();
  private List<MessageItem> F = new ArrayList();
  private Set<Long> G = new HashSet();
  private HashMap<String, oidb_c2c_searcher.Iterator> H = new HashMap();
  private int I = 0;
  private View.OnClickListener J = new C2CMessageSearchDialog.4(this);
  boolean m = false;
  int n = 0;
  public C2CMessageResultAdapter o;
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
  
  public C2CMessageSearchDialog(Context paramContext, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, boolean paramBoolean)
  {
    super(paramContext, paramQQAppInterface, paramSessionInfo);
    this.m = paramBoolean;
    paramContext = paramQQAppInterface.getCurrentAccountUin();
    if ((!TextUtils.isEmpty(paramContext)) && ("1".equals(paramContext.substring(paramContext.length() - 1, paramContext.length())))) {
      this.C = true;
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
      QLog.i("C2CMessageSearchDialog", 2, localStringBuilder.toString());
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
            this.D.setVisibility(0);
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
    this.D.setVisibility(8);
  }
  
  private void g()
  {
    this.d = ((EditText)findViewById(2131432634));
    this.d.setFilters(new InputFilter[] { new InputFilter.LengthFilter(15) });
    this.d.addTextChangedListener(new C2CMessageSearchDialog.1(this));
    this.d.setImeOptions(3);
    BaseMessageSearchDialog.EnterForSearch localEnterForSearch = new BaseMessageSearchDialog.EnterForSearch(this);
    this.d.setOnEditorActionListener(localEnterForSearch);
    this.d.setOnKeyListener(localEnterForSearch);
    this.d.setSelection(0);
    this.d.requestFocus();
  }
  
  private void h()
  {
    this.x = false;
    this.n = 0;
    this.E.clear();
    this.G.clear();
    this.I = 0;
    this.y = false;
  }
  
  private void i()
  {
    ((ImageButton)findViewById(2131435215)).setOnClickListener(new C2CMessageSearchDialog.2(this));
    Button localButton = (Button)findViewById(2131429816);
    localButton.setVisibility(0);
    localButton.setOnClickListener(new C2CMessageSearchDialog.3(this));
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
    this.t.setOnClickListener(this.J);
    this.q = ((LinearLayout)this.p.findViewById(2131445435));
    this.r = ((TextView)this.p.findViewById(2131445437));
    this.r.setOnClickListener(this.J);
    this.D = ((LinearLayout)this.p.findViewById(2131439372));
    this.D.setClickable(false);
    this.u = getLayoutInflater().inflate(2131628284, null);
    this.b.addFooterView(this.u, null, false);
    this.u.setClickable(false);
    this.v = ((LinearLayout)this.u.findViewById(2131444560));
    this.w = ((TextView)this.u.findViewById(2131438894));
    this.w.setText(this.c.getString(2131916114));
    this.u.setVisibility(8);
    this.o = new C2CMessageResultAdapter(this.c, this.a, this.g, this.f);
    this.b.setAdapter(this.o);
    this.b.setOnScrollListener(new C2CMessageSearchDialog.5(this));
    this.b.setOnTouchListener(new C2CMessageSearchDialog.6(this));
    this.b.setOnItemClickListener(new C2CMessageSearchDialog.7(this));
    this.b.setOnItemLongClickListener(new C2CMessageSearchDialog.8(this));
  }
  
  protected void a()
  {
    Object localObject = this.d.getText().toString().trim();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("searchMessage, keyword = ");
      localStringBuilder.append((String)localObject);
      QLog.i("C2CMessageSearchDialog", 2, localStringBuilder.toString());
    }
    if (((String)localObject).length() == 0) {
      return;
    }
    this.H.clear();
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
      QLog.i("C2CMessageSearchDialog", 2, ((StringBuilder)localObject).toString());
    }
    this.B = System.currentTimeMillis();
    if ((this.m) && (AppNetConnInfo.isNetSupport()))
    {
      this.n = 1;
      a(5, null);
      b(1);
      ReportController.b(this.f, "CliOper", "", "", "0X8005FCB", "0X8005FCB", 0, 0, "", "", "", "");
    }
    else
    {
      this.n = 0;
      this.o.a(this.B, this.z, 1);
      if (this.m) {
        a(3, this.c.getString(2131916122));
      } else {
        a(0, null);
      }
    }
    ReportController.b(this.f, "CliOper", "", "", "0X8005FCA", "0X8005FCA", 0, 0, "", "", "", "");
  }
  
  public void b(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(this.g.b);
    oidb_c2c_searcher.Iterator localIterator = (oidb_c2c_searcher.Iterator)this.H.get(this.z);
    long l1 = NetConnInfoCenter.getServerTime();
    Object localObject2 = (MessageRoamManager)this.f.getManager(QQManagerFactory.MESSAGE_ROAM_MANAGER);
    Object localObject1 = ((MessageRoamManager)localObject2).g();
    if (localObject1 != null)
    {
      long l2 = ((Long)((MessageRoamManager)localObject2).f((Calendar)localObject1).second).longValue();
      localObject2 = new StringBuilder();
      int i = ((Calendar)localObject1).get(1);
      int j = ((Calendar)localObject1).get(2) + 1;
      int k = ((Calendar)localObject1).get(5);
      ((StringBuilder)localObject2).append(i);
      ((StringBuilder)localObject2).append("-");
      if (j > 9)
      {
        localObject1 = Integer.valueOf(j);
      }
      else
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("0");
        ((StringBuilder)localObject1).append(j);
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      ((StringBuilder)localObject2).append(localObject1);
      ((StringBuilder)localObject2).append("-");
      if (k > 9)
      {
        localObject1 = Integer.valueOf(k);
      }
      else
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("0");
        ((StringBuilder)localObject1).append(k);
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      ((StringBuilder)localObject2).append(localObject1);
      l1 = l2;
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("showSearchDialog--> lastDay:");
        ((StringBuilder)localObject1).append(((StringBuilder)localObject2).toString());
        QLog.i("C2CMessageSearchDialog", 2, ((StringBuilder)localObject1).toString());
        l1 = l2;
      }
    }
    if (localIterator != null)
    {
      localObject1 = new ArrayList();
      ((List)localObject1).add(localIterator);
      this.f.getMsgHandler().a(paramInt, localArrayList, this.z, this.B, (List)localObject1, 0, l1);
      return;
    }
    this.f.getMsgHandler().a(paramInt, localArrayList, this.z, this.B, null, 0, l1);
  }
  
  public void dismiss()
  {
    this.d.setText("");
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
      QLog.i("C2CMessageSearchDialog", 2, ((StringBuilder)localObject1).toString());
    }
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2) {
          if (i != 4) {
            if (i != 5) {
              if (i != 6) {
                if (i == 8) {}
              }
            }
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
            QLog.i("C2CMessageSearchDialog", 2, ((StringBuilder)localObject1).toString());
          }
          if ((this.m) && (this.B == l) && (!TextUtils.isEmpty(paramMessage)))
          {
            if (!paramMessage.equals(this.z)) {
              return true;
            }
            if ((l == this.B) && (this.z.equals(paramMessage)))
            {
              ReportController.b(this.f, "CliOper", "", "", "0X8005FC6", "0X8005FC6", 0, (int)(System.currentTimeMillis() - this.B), "", "", "", "");
              this.x = false;
              this.u.setVisibility(8);
              this.v.setVisibility(8);
              this.o.a(this.E, this.y);
              if ((this.y) && (this.o.getCount() < 20))
              {
                this.w.setText(HardCodeUtil.a(2131899527));
                this.v.findViewById(2131440727).setVisibility(8);
                this.v.setVisibility(0);
                this.u.setVisibility(0);
              }
              this.o.notifyDataSetChanged();
              this.b.setAdapter(this.o);
              this.b.setSelection(0);
              this.E.clear();
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
              QLog.i("C2CMessageSearchDialog", 2, ((StringBuilder)localObject2).toString());
            }
            if ((!TextUtils.isEmpty(paramMessage)) && (this.m) && (this.B == l))
            {
              if (!this.z.equals(paramMessage)) {
                return true;
              }
              if ((l == this.B) && (this.z.equals(paramMessage)))
              {
                this.x = false;
                this.u.setVisibility(8);
                this.v.setVisibility(8);
                this.o.a((List)localObject1, this.y);
                this.o.notifyDataSetChanged();
                this.b.setAdapter(this.o);
                this.b.setSelection(0);
                this.E.clear();
              }
            }
            else
            {
              return true;
              localObject2 = (HashMap)paramMessage.obj;
              localObject1 = (String)((HashMap)localObject2).get("KEYWORD");
              l = ((Long)((HashMap)localObject2).get("SEARCHSEQUENCE")).longValue();
              int j = ((Integer)((HashMap)localObject2).get("LOADTYPE")).intValue();
              paramMessage = (List)((HashMap)localObject2).get("SEARCHRESULT");
              boolean bool = ((Boolean)((HashMap)localObject2).get("SEARCHCOMPLETE")).booleanValue();
              if (((HashMap)localObject2).get("SEARCHINFO") != null)
              {
                localObject2 = (List)((HashMap)localObject2).get("SEARCHINFO");
                this.H.put(localObject1, ((List)localObject2).get(0));
              }
              if (QLog.isColorLevel())
              {
                localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append("handleMessage : RSP_SEARCH_MORE_MESSAGE_IN_CLOUD reqKeyWord: ");
                ((StringBuilder)localObject2).append((String)localObject1);
                ((StringBuilder)localObject2).append(", mCurrentKeyword: ");
                ((StringBuilder)localObject2).append(this.z);
                ((StringBuilder)localObject2).append(", searchSequence: ");
                ((StringBuilder)localObject2).append(l);
                ((StringBuilder)localObject2).append(", mCurrentSequence:");
                ((StringBuilder)localObject2).append(this.B);
                ((StringBuilder)localObject2).append(", searchresult size: ");
                ((StringBuilder)localObject2).append(paramMessage.size());
                ((StringBuilder)localObject2).append(", total cache size: ");
                ((StringBuilder)localObject2).append(this.E.size());
                ((StringBuilder)localObject2).append(", IsComplete: ");
                ((StringBuilder)localObject2).append(bool);
                ((StringBuilder)localObject2).append(", loadType: ");
                ((StringBuilder)localObject2).append(j);
                ((StringBuilder)localObject2).append(", needSearchInCloud: ");
                ((StringBuilder)localObject2).append(this.m);
                ((StringBuilder)localObject2).append(", retryGetMore: ");
                ((StringBuilder)localObject2).append(this.I);
                QLog.i("C2CMessageSearchDialog", 2, ((StringBuilder)localObject2).toString());
              }
              if ((this.m) && (this.B == l) && (!TextUtils.isEmpty((CharSequence)localObject1)) && (((String)localObject1).equals(this.z)))
              {
                if ((this.B == l) && (this.z.equals(localObject1)))
                {
                  this.x = false;
                  this.u.setVisibility(8);
                  this.v.setVisibility(8);
                  this.y = bool;
                  if (this.I == 0) {
                    this.E.clear();
                  }
                  i = 0;
                  while (i < paramMessage.size())
                  {
                    localObject1 = new MessageItem(this.f, (MessageRecord)paramMessage.get(i));
                    this.E.add(localObject1);
                    this.G.add(Long.valueOf(((MessageItem)localObject1).b.shmsgseq));
                    i += 1;
                  }
                  if ((this.E.size() < 15) && (!this.y))
                  {
                    i = this.I;
                    if (i < 4)
                    {
                      this.I = (i + 1);
                      this.B = System.currentTimeMillis();
                      if (QLog.isColorLevel())
                      {
                        paramMessage = new StringBuilder();
                        paramMessage.append("handleMessage, retry to accumulate more messages for one-screen-display,retryGetMore = ");
                        paramMessage.append(this.I);
                        paramMessage.append(",loadType: ");
                        paramMessage.append(j);
                        QLog.i("C2CMessageSearchDialog", 2, paramMessage.toString());
                      }
                      b(j);
                      return true;
                    }
                  }
                  bool = this.y;
                  if (!bool)
                  {
                    if (this.I >= 4) {
                      bool = true;
                    }
                    this.y = bool;
                  }
                  this.I = 0;
                  if (j == 1)
                  {
                    a(0, null);
                    if (this.E.size() == 0)
                    {
                      if (QLog.isColorLevel())
                      {
                        paramMessage = new StringBuilder();
                        paramMessage.append("LOAD_REFRESH, no result at cloud, load local msg, mIsComplete: ");
                        paramMessage.append(this.y);
                        QLog.d("C2CMessageSearchDialog", 2, paramMessage.toString());
                      }
                      this.n = 0;
                      this.B = System.currentTimeMillis();
                      this.o.a(this.B, this.z, 1);
                    }
                    else
                    {
                      if (QLog.isColorLevel())
                      {
                        paramMessage = new StringBuilder();
                        paramMessage.append("LOAD_REFRESH, has result at cloud size: ");
                        paramMessage.append(this.E.size());
                        paramMessage.append(", start merge local msg, mIsComplete: ");
                        paramMessage.append(this.y);
                        QLog.d("C2CMessageSearchDialog", 2, paramMessage.toString());
                      }
                      this.o.a(this.z, this.B);
                      ReportController.b(this.f, "CliOper", "", "", "0X8005FC2", "0X8005FC2", 0, 0, "", "", "", "");
                    }
                  }
                  else
                  {
                    if (QLog.isColorLevel())
                    {
                      paramMessage = new StringBuilder();
                      paramMessage.append(" LOAD_MORE&LOAD_MSG_IN_CLOUD, has rsult at cloud size: ");
                      paramMessage.append(this.E.size());
                      paramMessage.append(", mIsComplete: ");
                      paramMessage.append(this.y);
                      QLog.d("C2CMessageSearchDialog", 2, paramMessage.toString());
                    }
                    if (this.C) {
                      ReportController.b(this.f, "CliOper", "", "", "0X8005FCC", "0X8005FCC", 0, (int)(System.currentTimeMillis() - this.B), "", "", "", "");
                    }
                    this.o.a(this.E, 4, this.y, 1);
                    this.o.notifyDataSetChanged();
                    this.E.clear();
                  }
                }
              }
              else
              {
                return true;
                localObject1 = (HashMap)paramMessage.obj;
                paramMessage = (String)((HashMap)localObject1).get("KEYWORD");
                l = ((Long)((HashMap)localObject1).get("SEARCHSEQUENCE")).longValue();
                i = ((Integer)((HashMap)localObject1).get("LOADTYPE")).intValue();
                if (QLog.isColorLevel())
                {
                  localObject1 = new StringBuilder();
                  ((StringBuilder)localObject1).append("handleMessage : RSP_SEARCH_TIMEOUT_OR_ERROR_IN_CLOUD ReqkeyWord = ");
                  ((StringBuilder)localObject1).append(paramMessage);
                  ((StringBuilder)localObject1).append(",currentKeyword: ");
                  ((StringBuilder)localObject1).append(this.z);
                  ((StringBuilder)localObject1).append(", searchSequence: ");
                  ((StringBuilder)localObject1).append(l);
                  ((StringBuilder)localObject1).append(",mCurrentSequence: ");
                  ((StringBuilder)localObject1).append(this.B);
                  ((StringBuilder)localObject1).append(", needSearchInCloud: ");
                  ((StringBuilder)localObject1).append(this.m);
                  QLog.i("C2CMessageSearchDialog", 2, ((StringBuilder)localObject1).toString());
                }
                if ((this.m) && (l == this.B) && (!TextUtils.isEmpty(paramMessage)) && (paramMessage.equals(this.z)))
                {
                  if ((l == this.B) && (this.z.equals(paramMessage)))
                  {
                    this.u.setVisibility(8);
                    this.v.setVisibility(8);
                    this.y = true;
                    this.I = 0;
                    if (i == 1)
                    {
                      if (QLog.isColorLevel()) {
                        QLog.d("C2CMessageSearchDialog", 2, "LOAD_REFRESH query cloud failed --->>> switch local mode");
                      }
                      a(0, null);
                      this.n = 0;
                      this.B = System.currentTimeMillis();
                      this.o.a(this.B, this.z, 1);
                    }
                    else
                    {
                      if (QLog.isColorLevel()) {
                        QLog.d("C2CMessageSearchDialog", 2, "LOAD_MSG_IN_CLOUD query cloud failed --->>> merge local data");
                      }
                      this.o.a(this.E, 4, this.y, 0);
                      this.o.notifyDataSetChanged();
                    }
                    this.x = false;
                    this.E.clear();
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
                    QLog.d("C2CMessageSearchDialog", 2, localStringBuilder.toString());
                  }
                  if ((localObject2 == null) || (l != this.B) || ((localObject1 != null) && (!((String)localObject1).equals(this.z)))) {
                    break;
                  }
                  if (((1 == paramMessage.arg1) && (((List)localObject2).size() > 0) && (((List)localObject2).size() != 20)) || ((2 == paramMessage.arg1) && (((List)localObject2).size() == 0)))
                  {
                    this.w.setText(HardCodeUtil.a(2131899525));
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
                    this.D.setVisibility(8);
                    this.b.setVisibility(0);
                  }
                  this.x = false;
                }
              }
            }
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("C2CMessageSearchDialog", 2, "handleMessage : ACTION_SHOW_MESSAGE sequence or keyword not equal, no load");
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
    this.a.sendEmptyMessage(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.messagesearch.C2CMessageSearchDialog
 * JD-Core Version:    0.7.0.1
 */