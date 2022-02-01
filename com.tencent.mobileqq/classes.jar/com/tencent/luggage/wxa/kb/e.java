package com.tencent.luggage.wxa.kb;

import android.content.Context;
import android.content.res.Resources;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.URLSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.luggage.wxa.jx.a;
import com.tencent.luggage.wxa.ob.b;
import com.tencent.luggage.wxa.qw.p;
import com.tencent.luggage.wxa.qz.t;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.widget.dialog.l;
import com.tencent.mm.ui.widget.dialog.MMAlertDialog;
import com.tencent.mm.ui.widget.dialog.MMAlertDialog.Builder;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

public class e
  extends a<u>
{
  public static final int CTRL_INDEX = 208;
  public static final String NAME = "requestAuthUserAutoFillData";
  private g a;
  
  private void a(TextView paramTextView)
  {
    SpannableString localSpannableString = new SpannableString(paramTextView.getText());
    URLSpan[] arrayOfURLSpan = (URLSpan[])localSpannableString.getSpans(0, localSpannableString.length(), URLSpan.class);
    int j = arrayOfURLSpan.length;
    int i = 0;
    while (i < j)
    {
      URLSpan localURLSpan = arrayOfURLSpan[i];
      int k = localSpannableString.getSpanStart(localURLSpan);
      int m = localSpannableString.getSpanEnd(localURLSpan);
      localSpannableString.removeSpan(localURLSpan);
      localSpannableString.setSpan(new i(localURLSpan.getURL()), k, m, 0);
      i += 1;
    }
    paramTextView.setText(localSpannableString);
  }
  
  private void a(u paramu, int paramInt1, com.tencent.luggage.wxa.qw.o paramo, int paramInt2, String paramString, LinkedList<String> paramLinkedList)
  {
    String str1;
    if (paramInt2 == 2) {
      str1 = paramu.getContext().getString(2131886765);
    } else {
      str1 = paramu.getContext().getString(2131886766);
    }
    String str2 = paramu.getContext().getString(2131886767);
    String str3 = paramu.getContext().getString(2131886764);
    String str4 = paramu.getContext().getString(2131886763);
    LayoutInflater localLayoutInflater = (LayoutInflater)paramu.getContext().getSystemService("layout_inflater");
    View localView = localLayoutInflater.inflate(2131624207, null);
    TextView localTextView = (TextView)localView.findViewById(2131428522);
    Object localObject = (TextView)localView.findViewById(2131428523);
    LinearLayout localLinearLayout = (LinearLayout)localView.findViewById(2131428524);
    localTextView.setText(paramString);
    ((TextView)localObject).setText(str4);
    ((TextView)localObject).setOnClickListener(new e.6(this, paramu));
    localLinearLayout.removeAllViews();
    if ((paramLinkedList != null) && (paramLinkedList.size() > 0))
    {
      localLinearLayout.setVisibility(0);
      paramString = paramLinkedList.iterator();
    }
    while (paramString.hasNext())
    {
      localObject = (String)paramString.next();
      paramLinkedList = (TextView)localLayoutInflater.inflate(2131624202, null);
      paramLinkedList.setText((CharSequence)localObject);
      localObject = new LinearLayout.LayoutParams(-1, -2);
      ((LinearLayout.LayoutParams)localObject).bottomMargin = paramu.getContentView().getResources().getDimensionPixelOffset(2131296760);
      paramLinkedList.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localLinearLayout.addView(paramLinkedList);
      continue;
      paramString = (LinearLayout.LayoutParams)((TextView)localObject).getLayoutParams();
      paramString.leftMargin = 0;
      ((TextView)localObject).setLayoutParams(paramString);
      localLinearLayout.setVisibility(8);
    }
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.JsApiRequestAuthUserAutoFillData", "show the auto fill data protocol dialog!");
    new MMAlertDialog.Builder(paramu.getContext()).setTitle(str1).setView(localView).setCanBack(false).setCancelable(false).setPositiveBtnText(str2).setPositiveBtnListener(new e.8(this, paramo, paramu, paramInt1)).setNegativeBtnText(str3).setNegativeBtnListener(new e.7(this, paramo, paramu, paramInt1)).create().show();
  }
  
  private void a(u paramu, int paramInt, com.tencent.luggage.wxa.qw.o paramo, String paramString)
  {
    View localView = ((LayoutInflater)paramu.getContext().getSystemService("layout_inflater")).inflate(2131624204, null);
    TextView localTextView = (TextView)localView.findViewById(2131428936);
    Button localButton1 = (Button)localView.findViewById(2131428935);
    Button localButton2 = (Button)localView.findViewById(2131428937);
    localTextView.setText(Html.fromHtml(paramString));
    a(localTextView);
    localTextView.setMovementMethod(new e.3(this, paramu));
    localButton1.setOnClickListener(new e.4(this, paramo, paramu, paramInt));
    localButton2.setOnClickListener(new e.5(this, paramo, paramu, paramInt));
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.JsApiRequestAuthUserAutoFillData", "showAlertImplNew, show the new bottom dialog!");
    this.a = new g(paramu.getContext());
    this.a.setContentView(localView);
    this.a.setCancelable(false);
    this.a.setCanceledOnTouchOutside(false);
    paramu = paramu.q().ap();
    if (paramu != null) {
      paramu.a(this.a);
    }
  }
  
  private void a(u paramu, com.tencent.luggage.wxa.qw.o paramo)
  {
    ((b)paramu.a(b.class)).b("/cgi-bin/mmbiz-bin/wxaapp/autofill/authinfo", paramu.getAppId(), paramo, p.class).a(new e.9(this));
  }
  
  private void c()
  {
    g localg = this.a;
    if (localg != null)
    {
      localg.dismiss();
      this.a = null;
    }
  }
  
  public void a(u paramu, JSONObject paramJSONObject, int paramInt)
  {
    if (paramJSONObject == null)
    {
      com.tencent.luggage.wxa.qz.o.b("MicroMsg.JsApiRequestAuthUserAutoFillData", "requestAuthUserAutoFillData data is invalid");
      paramu.a(paramInt, b("fail:data is invalid"));
      return;
    }
    LinkedList localLinkedList = new LinkedList();
    Object localObject1 = paramJSONObject.optJSONArray("fields");
    if ((localObject1 != null) && (((JSONArray)localObject1).length() > 0))
    {
      i = 0;
      while (i < ((JSONArray)localObject1).length())
      {
        localLinkedList.add(((JSONArray)localObject1).optString(i));
        i += 1;
      }
    }
    String str = paramJSONObject.optString("wording");
    int j = paramJSONObject.optInt("authStatus", 2);
    int i = paramJSONObject.optInt("clientVersion", 0);
    Object localObject2 = paramu.getAppId();
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.JsApiRequestAuthUserAutoFillData", "requestAuthUserAutoFillData appId:%s, clientVersion:%s", new Object[] { localObject2, Integer.valueOf(i) });
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.JsApiRequestAuthUserAutoFillData", "requestAuthUserAutoFillData wording:%s, authStatus:%d, fieldIds:%s", new Object[] { str, Integer.valueOf(j), localObject1 });
    localObject1 = new com.tencent.luggage.wxa.qw.o();
    ((com.tencent.luggage.wxa.qw.o)localObject1).b = localLinkedList;
    ((com.tencent.luggage.wxa.qw.o)localObject1).a = ((String)localObject2);
    ((com.tencent.luggage.wxa.qw.o)localObject1).d = j;
    ((com.tencent.luggage.wxa.qw.o)localObject1).f = i;
    if (i == 1)
    {
      t.a(new e.1(this, paramu, paramInt, (com.tencent.luggage.wxa.qw.o)localObject1, str));
      return;
    }
    localObject2 = new LinkedList();
    JSONArray localJSONArray = paramJSONObject.optJSONArray("authGroupList");
    if ((localJSONArray != null) && (localJSONArray.length() > 0))
    {
      i = 0;
      while (i < localJSONArray.length())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("  ");
        localStringBuilder.append(localJSONArray.optString(i));
        ((LinkedList)localObject2).add(localStringBuilder.toString());
        i += 1;
      }
    }
    if (localLinkedList.size() == 0)
    {
      com.tencent.luggage.wxa.qz.o.b("MicroMsg.JsApiRequestAuthUserAutoFillData", "requestAuthUserAutoFillData fields is empty");
      paramu.a(paramInt, b("fail:fields is empty"));
      return;
    }
    if (TextUtils.isEmpty(str))
    {
      com.tencent.luggage.wxa.qz.o.b("MicroMsg.JsApiRequestAuthUserAutoFillData", "requestAuthUserAutoFillData wording is empty");
      paramu.a(paramInt, b("fail:wording is empty"));
      return;
    }
    if (paramJSONObject.optJSONArray("authGroupList") != null) {
      com.tencent.luggage.wxa.qz.o.d("MicroMsg.JsApiRequestAuthUserAutoFillData", "authGroupList:%s", new Object[] { paramJSONObject.optJSONArray("authGroupList").toString() });
    }
    t.a(new e.2(this, paramu, paramInt, (com.tencent.luggage.wxa.qw.o)localObject1, j, str, (LinkedList)localObject2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kb.e
 * JD-Core Version:    0.7.0.1
 */