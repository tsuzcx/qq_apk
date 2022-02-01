package com.tencent.biz.qrcode.activity;

import Override;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import bglp;
import bgpa;
import bkho;
import bkif;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import zrx;
import zry;
import zrz;
import zsa;
import zsb;
import zsc;
import zsd;
import zvb;

public class QRCardActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  protected static String o = "((?:(?i)https?://|www\\.|[a-zA-Z0-9]+\\.)[a-zA-Z0-9\\-.]+(?::(\\d+))?(?:(?:/[a-zA-Z0-9\\-._?,'+\\\\&%$=~*!;#():@\\\\]*)+)?)";
  protected float a;
  protected int a;
  protected Resources a;
  protected Handler a;
  private View.OnLongClickListener a;
  protected Button a;
  public ImageView a;
  protected LinearLayout a;
  protected TextView a;
  public bkho a;
  protected String a;
  protected Thread a;
  public zvb a;
  public boolean a;
  protected TextView b;
  protected String b;
  protected boolean b;
  protected TextView c;
  protected String c;
  public boolean c;
  protected String d;
  protected String e;
  protected String f;
  protected String g;
  public String h;
  protected String i;
  protected String j;
  public String k;
  protected String l;
  protected String m;
  protected String n;
  
  public QRCardActivity()
  {
    this.jdField_a_of_type_AndroidOsHandler = new zrx(this);
    this.jdField_a_of_type_AndroidViewView$OnLongClickListener = new zsd(this);
  }
  
  private ViewGroup a()
  {
    LinearLayout localLinearLayout = new LinearLayout(this);
    localLinearLayout.setOrientation(1);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    int i1 = (int)(this.jdField_a_of_type_Float * 5.0F);
    localLayoutParams.setMargins(0, i1, 0, i1 << 1);
    localLinearLayout.setLayoutParams(localLayoutParams);
    return localLinearLayout;
  }
  
  private void a(Context paramContext, int paramInt, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_Bkho = ((bkho)bkif.a(this, null));
    boolean[] arrayOfBoolean = new boolean[4];
    boolean[] tmp19_17 = arrayOfBoolean;
    tmp19_17[0] = 0;
    boolean[] tmp24_19 = tmp19_17;
    tmp24_19[1] = 0;
    boolean[] tmp29_24 = tmp24_19;
    tmp29_24[2] = 0;
    boolean[] tmp34_29 = tmp29_24;
    tmp34_29[3] = 0;
    tmp34_29;
    if (paramInt == 2)
    {
      arrayOfBoolean[0] = true;
      String str = this.jdField_a_of_type_AndroidContentResResources.getString(2131718985);
      this.jdField_a_of_type_Bkho.a(str, 0);
      str = this.jdField_a_of_type_AndroidContentResResources.getString(2131718983);
      this.jdField_a_of_type_Bkho.a(str, 0);
    }
    if (paramInt == 0)
    {
      arrayOfBoolean[1] = true;
      this.jdField_a_of_type_Bkho.a(this.jdField_a_of_type_AndroidContentResResources.getString(2131691437), 1);
    }
    if (paramInt == 4)
    {
      arrayOfBoolean[2] = true;
      this.jdField_a_of_type_Bkho.a(this.jdField_a_of_type_AndroidContentResResources.getString(2131689664), 1);
      this.jdField_a_of_type_Bkho.a(this.jdField_a_of_type_AndroidContentResResources.getString(2131689660), 1);
    }
    if (paramInt == 3)
    {
      arrayOfBoolean[3] = true;
      this.jdField_a_of_type_Bkho.a(2131691437, 1);
      this.jdField_a_of_type_Bkho.a(2131691140, 1);
      this.jdField_a_of_type_Bkho.a(2131689569, 1);
      this.jdField_a_of_type_Bkho.a(2131693155, 1);
      this.jdField_a_of_type_Bkho.a(String.format(paramContext.getString(2131694052), new Object[] { paramString1 }));
    }
    this.jdField_a_of_type_Bkho.a(new zry(this, arrayOfBoolean, paramString2, paramContext, paramString1));
    this.jdField_a_of_type_Bkho.c(2131690582);
    this.jdField_a_of_type_Bkho.setOnDismissListener(new zrz(this));
    if (!this.jdField_a_of_type_Bkho.isShowing())
    {
      this.jdField_c_of_type_Boolean = false;
      this.jdField_a_of_type_Bkho.show();
    }
  }
  
  private void a(ViewGroup paramViewGroup, int paramInt)
  {
    Object localObject1 = super.getLayoutInflater();
    int i2 = 0;
    int i3 = 0;
    int i4 = 0;
    int i1 = 0;
    Object localObject2;
    Object localObject3;
    Object localObject5;
    Object localObject4;
    int i5;
    Object localObject6;
    TextView localTextView;
    if (paramInt == 0)
    {
      i1 = this.jdField_a_of_type_Zvb.c.size();
      i1 = this.jdField_a_of_type_Zvb.b.size() + i1;
      if (paramInt != 0) {
        break label683;
      }
      i3 = i1;
      if (!this.jdField_a_of_type_Zvb.c.isEmpty())
      {
        localObject2 = this.jdField_a_of_type_Zvb.c.keySet().iterator();
        paramInt = i4;
      }
    }
    else
    {
      for (;;)
      {
        i2 = paramInt;
        i3 = i1;
        if (!((Iterator)localObject2).hasNext()) {
          break label413;
        }
        localObject3 = (String)((Iterator)localObject2).next();
        localObject5 = (String)this.jdField_a_of_type_Zvb.c.get(localObject3);
        localObject4 = ((String)localObject5).split(";");
        if ((localObject4 != null) && (localObject4.length > 0))
        {
          i4 = i1 + (localObject4.length - 1);
          if (localObject4.length > 1)
          {
            i5 = localObject4.length;
            i3 = 0;
            i2 = paramInt;
            for (;;)
            {
              paramInt = i2;
              i1 = i4;
              if (i3 >= i5) {
                break;
              }
              localObject5 = localObject4[i3];
              localObject6 = ((LayoutInflater)localObject1).inflate(2131560386, null);
              ((View)localObject6).setTag(Integer.valueOf(0));
              localTextView = (TextView)((View)localObject6).findViewById(2131364999);
              ((TextView)((View)localObject6).findViewById(2131378776)).setText((CharSequence)localObject3);
              localTextView.setText((CharSequence)localObject5);
              a(i2, i4, (View)localObject6, paramViewGroup, 1);
              i2 += 1;
              i3 += 1;
            }
            if (paramInt != 1) {
              break;
            }
            i1 = this.jdField_a_of_type_Zvb.e.size();
            i5 = this.jdField_a_of_type_Zvb.f.size();
            int i6 = this.jdField_a_of_type_Zvb.d.size();
            i1 = this.jdField_a_of_type_Zvb.a.size() + (i1 + i5 + i6);
            break;
          }
          localObject4 = ((LayoutInflater)localObject1).inflate(2131560386, null);
          ((View)localObject4).setTag(Integer.valueOf(0));
          localObject6 = (TextView)((View)localObject4).findViewById(2131364999);
          ((TextView)((View)localObject4).findViewById(2131378776)).setText((CharSequence)localObject3);
          ((TextView)localObject6).setText((CharSequence)localObject5);
          a(paramInt, i4, (View)localObject4, paramViewGroup, 1);
          paramInt += 1;
          i1 = i4;
        }
      }
    }
    label413:
    label1182:
    if (!this.jdField_a_of_type_Zvb.b.isEmpty())
    {
      localObject2 = this.jdField_a_of_type_Zvb.b.keySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (String)((Iterator)localObject2).next();
        localObject5 = (String)this.jdField_a_of_type_Zvb.b.get(localObject3);
        localObject4 = ((String)localObject5).split(";");
        if ((localObject4 != null) && (localObject4.length > 0))
        {
          i4 = i3 + (localObject4.length - 1);
          if (localObject4.length > 1)
          {
            i5 = localObject4.length;
            i1 = 0;
            paramInt = i2;
            for (;;)
            {
              i2 = paramInt;
              i3 = i4;
              if (i1 >= i5) {
                break;
              }
              localObject5 = localObject4[i1];
              localObject6 = ((LayoutInflater)localObject1).inflate(2131560385, null);
              localTextView = (TextView)((View)localObject6).findViewById(2131364999);
              ((TextView)((View)localObject6).findViewById(2131378776)).setText((CharSequence)localObject3);
              localTextView.setText((CharSequence)localObject5);
              a(paramInt, i4, (View)localObject6, paramViewGroup, 0);
              paramInt += 1;
              i1 += 1;
            }
          }
          localObject4 = ((LayoutInflater)localObject1).inflate(2131560385, null);
          localObject6 = (TextView)((View)localObject4).findViewById(2131364999);
          ((TextView)((View)localObject4).findViewById(2131378776)).setText((CharSequence)localObject3);
          ((TextView)localObject6).setText((CharSequence)localObject5);
          a(i2, i4, (View)localObject4, paramViewGroup, 0);
          i2 += 1;
          i3 = i4;
        }
      }
      label683:
      if (paramInt == 1)
      {
        paramInt = i3;
        if (!this.jdField_a_of_type_Zvb.f.isEmpty())
        {
          localObject2 = this.k;
          localObject3 = (String)this.jdField_a_of_type_Zvb.f.get(this.k);
          localObject4 = ((LayoutInflater)localObject1).inflate(2131560386, null);
          ((View)localObject4).setTag(Integer.valueOf(2));
          localObject5 = (TextView)((View)localObject4).findViewById(2131364999);
          ((TextView)((View)localObject4).findViewById(2131378776)).setText((CharSequence)localObject2);
          ((TextView)localObject5).setText((CharSequence)localObject3);
          a(0, i1, (View)localObject4, paramViewGroup, 1);
          paramInt = 1;
        }
        i2 = paramInt;
        if (!this.jdField_a_of_type_Zvb.e.isEmpty())
        {
          localObject2 = this.j;
          localObject3 = (String)this.jdField_a_of_type_Zvb.e.get(this.j);
          localObject4 = ((LayoutInflater)localObject1).inflate(2131560385, null);
          localObject5 = (TextView)((View)localObject4).findViewById(2131364999);
          ((TextView)((View)localObject4).findViewById(2131378776)).setText((CharSequence)localObject2);
          ((TextView)localObject5).setText((CharSequence)localObject3);
          a(paramInt, i1, (View)localObject4, paramViewGroup, 0);
          i2 = paramInt + 1;
        }
        if (!this.jdField_a_of_type_Zvb.d.isEmpty())
        {
          localObject2 = this.h;
          localObject3 = (String)this.jdField_a_of_type_Zvb.d.get(this.h);
          if (!Pattern.compile(o).matcher((CharSequence)localObject3).matches()) {
            break label1182;
          }
          localObject4 = ((LayoutInflater)localObject1).inflate(2131560386, null);
          ((View)localObject4).setTag(Integer.valueOf(1));
          localObject5 = (TextView)((View)localObject4).findViewById(2131364999);
          ((TextView)((View)localObject4).findViewById(2131378776)).setText((CharSequence)localObject2);
          ((TextView)localObject5).setText((CharSequence)localObject3);
          a(i2, i1, (View)localObject4, paramViewGroup, 1);
        }
        while (!this.jdField_a_of_type_Zvb.a.isEmpty())
        {
          localObject1 = ((LayoutInflater)localObject1).inflate(2131560385, null);
          localObject2 = (TextView)((View)localObject1).findViewById(2131364999);
          localObject3 = (TextView)((View)localObject1).findViewById(2131378776);
          ((TextView)localObject2).setMovementMethod(LinkMovementMethod.getInstance());
          ((TextView)localObject3).setText(this.i);
          localObject3 = (String)this.jdField_a_of_type_Zvb.a.get(this.i);
          localObject4 = new SpannableString((CharSequence)localObject3);
          localObject5 = Pattern.compile("\\d{5,}").matcher((CharSequence)localObject3);
          for (;;)
          {
            if (((Matcher)localObject5).find())
            {
              paramInt = ((Matcher)localObject5).start();
              i2 = ((Matcher)localObject5).end();
              if (i2 - paramInt <= 16)
              {
                ((SpannableString)localObject4).setSpan(new QRCardActivity.NumberSpan(this, ((String)localObject3).toString().substring(paramInt, i2)), paramInt, i2, 33);
                continue;
                localObject4 = ((LayoutInflater)localObject1).inflate(2131560385, null);
                localObject5 = (TextView)((View)localObject4).findViewById(2131364999);
                ((TextView)((View)localObject4).findViewById(2131378776)).setText((CharSequence)localObject2);
                ((TextView)localObject5).setText((CharSequence)localObject3);
                a(i2, i1, (View)localObject4, paramViewGroup, 0);
                break;
              }
            }
          }
          localObject5 = Pattern.compile(o).matcher((CharSequence)localObject3);
          while (((Matcher)localObject5).find())
          {
            paramInt = ((Matcher)localObject5).start();
            i2 = ((Matcher)localObject5).end();
            ((SpannableString)localObject4).setSpan(new QRCardActivity.NumberSpan(this, ((String)localObject3).toString().substring(paramInt, i2)), paramInt, i2, 33);
          }
          ((TextView)localObject2).setText((CharSequence)localObject4);
          if (i1 != 1) {
            break label1333;
          }
          ((View)localObject1).setBackgroundResource(2130839432);
        }
      }
    }
    for (;;)
    {
      paramViewGroup.addView((View)localObject1);
      return;
      label1333:
      ((View)localObject1).setBackgroundResource(2130839439);
    }
  }
  
  private void b()
  {
    super.setTitle(2131694588);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131368138));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131378445));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131380195));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131366895));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131371720));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)super.findViewById(2131368790));
    if (!TextUtils.isEmpty(this.m)) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.m);
    }
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      if (!TextUtils.isEmpty(this.n)) {
        this.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentResResources.getString(2131718577) + ": " + this.n);
      }
    }
    for (;;)
    {
      boolean bool = AppNetConnInfo.isWifiConn();
      if ((this.jdField_b_of_type_Boolean) && (bool))
      {
        this.jdField_a_of_type_JavaLangThread = new Thread(new QRCardActivity.2(this));
        this.jdField_a_of_type_JavaLangThread.start();
      }
      c();
      return;
      this.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentResResources.getString(2131693975) + ": " + this.jdField_a_of_type_JavaLangString);
      if (!TextUtils.isEmpty(this.n)) {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentResResources.getString(2131718577) + ": " + this.n);
      }
    }
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViewsInLayout();
    ViewGroup localViewGroup1 = a();
    a(localViewGroup1, 0);
    ViewGroup localViewGroup2 = a();
    a(localViewGroup2, 1);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localViewGroup1);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localViewGroup2);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.requestLayout();
    this.jdField_a_of_type_AndroidWidgetLinearLayout.invalidate();
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidContentResResources = super.getResources();
    this.jdField_a_of_type_Float = this.jdField_a_of_type_AndroidContentResResources.getDisplayMetrics().density;
    this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentResResources.getString(2131718518);
    this.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentResResources.getString(2131692871);
    this.d = this.jdField_a_of_type_AndroidContentResResources.getString(2131719165);
    this.e = this.jdField_a_of_type_AndroidContentResResources.getString(2131689665);
    this.f = this.jdField_a_of_type_AndroidContentResResources.getString(2131692870);
    this.g = this.jdField_a_of_type_AndroidContentResResources.getString(2131719164);
    this.h = this.jdField_a_of_type_AndroidContentResResources.getString(2131718981);
    this.i = this.jdField_a_of_type_AndroidContentResResources.getString(2131694012);
    this.j = this.jdField_a_of_type_AndroidContentResResources.getString(2131694159);
    this.k = this.jdField_a_of_type_AndroidContentResResources.getString(2131691699);
    this.jdField_a_of_type_Int = super.getResources().getColor(2131165765);
    this.jdField_a_of_type_Zvb = new zvb();
  }
  
  public void a(int paramInt1, int paramInt2, View paramView, ViewGroup paramViewGroup, int paramInt3)
  {
    if (paramInt1 == 0) {
      paramView.setBackgroundResource(2130839448);
    }
    for (;;)
    {
      if (paramInt2 == 1) {
        paramView.setBackgroundResource(2130839432);
      }
      if (paramInt3 == 1)
      {
        paramView.setOnClickListener(new zsc(this));
        paramView.setOnLongClickListener(this.jdField_a_of_type_AndroidViewView$OnLongClickListener);
      }
      paramViewGroup.addView(paramView);
      return;
      if (paramInt1 == paramInt2 - 1) {
        paramView.setBackgroundResource(2130839439);
      } else {
        paramView.setBackgroundResource(2130839442);
      }
    }
  }
  
  protected void a(int paramInt, String paramString)
  {
    Object localObject1 = null;
    Object localObject2;
    label54:
    label74:
    label81:
    Object localObject3;
    label183:
    int i1;
    if (paramInt == 0)
    {
      if (paramString.length() <= "MECARD:".length()) {}
      do
      {
        do
        {
          return;
          paramString = paramString.substring("MECARD:".length());
        } while (TextUtils.isEmpty(paramString));
        localObject2 = paramString.split(";");
      } while (localObject2 == null);
      paramInt = 0;
      if (paramInt < localObject2.length) {
        if (localObject2[paramInt].contains(":")) {
          break label81;
        }
      }
      for (;;)
      {
        paramInt += 1;
        break label54;
        break;
        localObject1 = localObject2[paramInt].split(":");
        if ((localObject1 != null) && (localObject1.length > 1) && (!TextUtils.isEmpty(localObject1[0])) && (!TextUtils.isEmpty(localObject1[1])))
        {
          localObject3 = localObject1[0].toLowerCase().trim();
          paramString = localObject1[1].trim();
          if (((String)localObject3).equalsIgnoreCase("n"))
          {
            this.m = paramString;
          }
          else
          {
            if (!((String)localObject3).equalsIgnoreCase("til")) {
              break label183;
            }
            this.n = paramString;
          }
        }
      }
      if (((String)localObject3).startsWith("photo"))
      {
        if (localObject1.length <= 2) {
          break label2423;
        }
        paramString = new StringBuilder();
        i1 = 1;
        while (i1 < localObject1.length)
        {
          paramString.append(localObject1[i1]);
          if (i1 != localObject1.length - 1) {
            paramString.append(":");
          }
          i1 += 1;
        }
        paramString = paramString.toString();
      }
    }
    label749:
    label2420:
    label2423:
    for (;;)
    {
      this.l = paramString;
      this.jdField_b_of_type_Boolean = true;
      break label74;
      if (((String)localObject3).equals("tel"))
      {
        localObject1 = paramString;
        if (this.jdField_a_of_type_Zvb.c.containsKey(this.jdField_b_of_type_JavaLangString)) {
          localObject1 = (String)this.jdField_a_of_type_Zvb.c.get(this.jdField_b_of_type_JavaLangString) + ";" + paramString;
        }
        this.jdField_a_of_type_Zvb.c.put(this.jdField_b_of_type_JavaLangString, localObject1);
        break label74;
      }
      if (((String)localObject3).equals("adr"))
      {
        localObject1 = paramString;
        if (this.jdField_a_of_type_Zvb.b.containsKey(this.e)) {
          localObject1 = (String)this.jdField_a_of_type_Zvb.b.get(this.e) + ";" + paramString;
        }
        this.jdField_a_of_type_Zvb.b.put(this.e, localObject1);
        break label74;
      }
      if (((String)localObject3).equals("email"))
      {
        this.jdField_a_of_type_Zvb.f.put(this.k, paramString);
        break label74;
      }
      if (((String)localObject3).equals("org"))
      {
        this.jdField_a_of_type_Zvb.e.put(this.j, paramString);
        break label74;
      }
      if (((String)localObject3).equals("url"))
      {
        if (localObject1.length > 2)
        {
          paramString = new StringBuilder();
          i1 = 1;
          while (i1 < localObject1.length)
          {
            paramString.append(localObject1[i1]);
            if (i1 != localObject1.length - 1) {
              paramString.append(":");
            }
            i1 += 1;
          }
          paramString = paramString.toString();
        }
        this.jdField_a_of_type_Zvb.d.put(this.h, paramString);
        break label74;
      }
      if (((String)localObject3).equals("note"))
      {
        if (localObject1.length > 2)
        {
          paramString = new StringBuilder();
          i1 = 1;
          while (i1 < localObject1.length)
          {
            paramString.append(localObject1[i1]);
            if (i1 != localObject1.length - 1) {
              paramString.append(":");
            }
            i1 += 1;
          }
          paramString = paramString.toString();
        }
        this.jdField_a_of_type_Zvb.a.put(this.i, paramString);
        break label74;
      }
      if (!((String)localObject3).equals("nickname")) {
        break label74;
      }
      this.jdField_a_of_type_JavaLangString = paramString;
      break label74;
      String[] arrayOfString;
      if (paramInt == 1)
      {
        if (paramString.length() <= "BEGIN:VCARD\nEND:VCARD".length()) {
          break;
        }
        if (paramString.contains("\n"))
        {
          localObject1 = "\n";
          paramString = paramString.substring("BEGIN:VCARD".length(), paramString.length() - "END:VCARD".length());
          if (TextUtils.isEmpty(paramString)) {
            break;
          }
          arrayOfString = paramString.split((String)localObject1);
          if (arrayOfString == null) {
            break;
          }
          paramInt = 0;
          if (paramInt < arrayOfString.length) {
            if (arrayOfString[paramInt].contains(":")) {
              break label856;
            }
          }
        }
        for (;;)
        {
          paramInt += 1;
          break label793;
          break;
          if (paramString.contains("\r"))
          {
            localObject1 = "\r";
            break label749;
          }
          if (!paramString.contains("\r\n")) {
            break;
          }
          localObject1 = "\r\n";
          break label749;
          localObject3 = arrayOfString[paramInt].split(":");
          if ((localObject3 != null) && (localObject3.length > 1) && (!TextUtils.isEmpty(localObject3[0])) && (!TextUtils.isEmpty(localObject3[1])))
          {
            localObject2 = localObject3[0].toLowerCase().trim();
            paramString = localObject3[1].trim();
            if (((((String)localObject2).equals("n")) || (((String)localObject2).equals("fn"))) && (TextUtils.isEmpty(this.m)))
            {
              localObject2 = paramString;
              if (paramString.contains(";"))
              {
                localObject3 = paramString.split(";");
                if ((localObject3 != null) && (localObject3.length > 0))
                {
                  int i2 = localObject3.length;
                  i1 = 0;
                  for (;;)
                  {
                    localObject2 = paramString;
                    if (i1 >= i2) {
                      break;
                    }
                    localObject2 = localObject3[i1];
                    paramString = paramString + " " + (String)localObject2;
                    i1 += 1;
                  }
                }
                localObject2 = "";
              }
              this.m = ((String)localObject2);
            }
            else if (((String)localObject2).equals("title"))
            {
              this.n = paramString;
            }
            else if (((String)localObject2).startsWith("photo"))
            {
              if (localObject3.length > 2)
              {
                paramString = new StringBuilder();
                i1 = 1;
                while (i1 < localObject3.length)
                {
                  paramString.append(localObject3[i1]);
                  if (i1 != localObject3.length - 1) {
                    paramString.append(":");
                  }
                  i1 += 1;
                }
                paramString = paramString.toString();
              }
              this.l = paramString;
              this.jdField_b_of_type_Boolean = true;
            }
            else
            {
              if (!((String)localObject2).equals("nickname")) {
                break label1176;
              }
              this.jdField_a_of_type_JavaLangString = paramString;
            }
          }
        }
        if (((String)localObject2).startsWith("tel")) {
          if (((String)localObject2).contains("home"))
          {
            localObject2 = this.jdField_c_of_type_JavaLangString;
            if ((!"tel".equals(paramString)) || (localObject3.length <= 2)) {
              break label2420;
            }
            paramString = localObject3[2];
          }
        }
      }
      for (;;)
      {
        localObject3 = paramString;
        if (this.jdField_a_of_type_Zvb.c.containsKey(localObject2)) {
          localObject3 = (String)this.jdField_a_of_type_Zvb.c.get(localObject2) + ";" + paramString;
        }
        this.jdField_a_of_type_Zvb.c.put(localObject2, localObject3);
        break label813;
        if (((String)localObject2).contains("work"))
        {
          localObject2 = this.d;
          break label1204;
        }
        localObject2 = this.jdField_b_of_type_JavaLangString;
        break label1204;
        if (((String)localObject2).contains("adr"))
        {
          if (((String)localObject2).contains("home")) {
            localObject2 = this.f;
          }
          for (;;)
          {
            if (paramString.contains(";;"))
            {
              localObject3 = new StringBuilder();
              paramString = paramString.substring(2);
              if (TextUtils.isEmpty(paramString)) {
                break;
              }
              paramString = paramString.split(";");
              if (paramString == null) {
                break;
              }
              i1 = 0;
              for (;;)
              {
                if (i1 < paramString.length)
                {
                  if (!TextUtils.isEmpty(paramString[i1]))
                  {
                    ((StringBuilder)localObject3).append(paramString[i1]);
                    if (i1 != paramString.length - 1) {
                      ((StringBuilder)localObject3).append((String)localObject1);
                    }
                  }
                  i1 += 1;
                  continue;
                  if (((String)localObject2).contains("work"))
                  {
                    localObject2 = this.g;
                    break;
                  }
                  localObject2 = this.e;
                  break;
                }
              }
              paramString = ((StringBuilder)localObject3).toString();
            }
          }
        }
        for (;;)
        {
          localObject3 = paramString;
          if (this.jdField_a_of_type_Zvb.b.containsKey(localObject2)) {
            localObject3 = (String)this.jdField_a_of_type_Zvb.b.get(localObject2) + ";" + paramString;
          }
          this.jdField_a_of_type_Zvb.b.put(localObject2, localObject3);
          break label813;
          if (((String)localObject2).equals("email"))
          {
            this.jdField_a_of_type_Zvb.f.put(this.k, paramString);
            break label813;
          }
          if (((String)localObject2).equals("org"))
          {
            this.jdField_a_of_type_Zvb.e.put(this.j, paramString);
            break label813;
          }
          if (((String)localObject2).equals("url"))
          {
            if (localObject3.length > 2)
            {
              paramString = new StringBuilder();
              i1 = 1;
              while (i1 < localObject3.length)
              {
                paramString.append(localObject3[i1]);
                if (i1 != localObject3.length - 1) {
                  paramString.append(":");
                }
                i1 += 1;
              }
              paramString = paramString.toString();
            }
            this.jdField_a_of_type_Zvb.d.put(this.h, paramString);
            break label813;
          }
          if (!((String)localObject2).equals("note")) {
            break label813;
          }
          if (localObject3.length > 2)
          {
            paramString = new StringBuilder();
            i1 = 1;
            while (i1 < localObject3.length)
            {
              paramString.append(localObject3[i1]);
              if (i1 != localObject3.length - 1) {
                paramString.append(":");
              }
              i1 += 1;
            }
            paramString = paramString.toString();
          }
          this.jdField_a_of_type_Zvb.a.put(this.i, paramString);
          break label813;
          if (paramString.length() <= "BIZCARD:;;".length()) {
            break;
          }
          localObject2 = paramString.substring("BIZCARD:".length(), paramString.length() - ";;".length());
          if (TextUtils.isEmpty(paramString)) {
            break;
          }
          arrayOfString = ((String)localObject2).split(";");
          if (arrayOfString == null) {
            break;
          }
          paramInt = 0;
          paramString = null;
          if (paramInt < arrayOfString.length)
          {
            if (!arrayOfString[paramInt].contains(":"))
            {
              localObject2 = localObject1;
              localObject1 = paramString;
              paramString = (String)localObject2;
            }
            for (;;)
            {
              paramInt += 1;
              localObject2 = localObject1;
              localObject1 = paramString;
              paramString = (String)localObject2;
              break;
              localObject2 = arrayOfString[paramInt].split(":");
              if ((localObject2 != null) && (localObject2.length > 1) && (!TextUtils.isEmpty(localObject2[0])))
              {
                if (TextUtils.isEmpty(localObject2[1]))
                {
                  localObject2 = paramString;
                  paramString = (String)localObject1;
                  localObject1 = localObject2;
                  continue;
                }
                localObject3 = localObject2[0].toLowerCase().trim();
                localObject2 = localObject2[1].trim();
                if (((String)localObject3).equals("x"))
                {
                  paramString = (String)localObject1;
                  localObject1 = localObject2;
                  continue;
                }
                if (((String)localObject3).equals("n"))
                {
                  localObject1 = paramString;
                  paramString = (String)localObject2;
                  continue;
                }
                if (((String)localObject3).equals("t"))
                {
                  this.n = ((String)localObject2);
                  localObject2 = paramString;
                  paramString = (String)localObject1;
                  localObject1 = localObject2;
                  continue;
                }
                if (((String)localObject3).equals("b"))
                {
                  localObject3 = localObject2;
                  if (this.jdField_a_of_type_Zvb.c.containsKey(this.jdField_b_of_type_JavaLangString)) {
                    localObject3 = (String)this.jdField_a_of_type_Zvb.c.get(this.jdField_b_of_type_JavaLangString) + ";" + (String)localObject2;
                  }
                  this.jdField_a_of_type_Zvb.c.put(this.jdField_b_of_type_JavaLangString, localObject3);
                  localObject2 = paramString;
                  paramString = (String)localObject1;
                  localObject1 = localObject2;
                  continue;
                }
                if (((String)localObject3).equals("a"))
                {
                  localObject3 = localObject2;
                  if (this.jdField_a_of_type_Zvb.b.containsKey(this.e)) {
                    localObject3 = (String)this.jdField_a_of_type_Zvb.b.get(this.e) + ";" + (String)localObject2;
                  }
                  this.jdField_a_of_type_Zvb.b.put(this.e, localObject3);
                  localObject2 = paramString;
                  paramString = (String)localObject1;
                  localObject1 = localObject2;
                  continue;
                }
                if (((String)localObject3).equals("e"))
                {
                  this.jdField_a_of_type_Zvb.f.put(this.k, localObject2);
                  localObject2 = paramString;
                  paramString = (String)localObject1;
                  localObject1 = localObject2;
                  continue;
                }
                if (((String)localObject3).equals("c")) {
                  this.jdField_a_of_type_Zvb.e.put(this.j, localObject2);
                }
              }
              localObject2 = paramString;
              paramString = (String)localObject1;
              localObject1 = localObject2;
            }
          }
          if (!TextUtils.isEmpty(paramString))
          {
            if (!TextUtils.isEmpty((CharSequence)localObject1))
            {
              this.m = (paramString + " " + (String)localObject1);
              return;
            }
            this.m = paramString;
            return;
          }
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            break;
          }
          this.m = ((String)localObject1);
          return;
        }
      }
    }
  }
  
  public void a(Intent paramIntent, HashMap<String, String> paramHashMap)
  {
    paramIntent.putExtra("job_title", this.n);
    paramIntent.putExtra("name", this.jdField_a_of_type_AndroidWidgetTextView.getText().toString());
    Iterator localIterator = paramHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      String str2 = (String)paramHashMap.get(str1);
      String[] arrayOfString = str2.split(";");
      if ((arrayOfString != null) && (arrayOfString.length > 0)) {
        if (str1.equals(this.j))
        {
          paramIntent.putExtra("company", str2);
        }
        else if (str1.equals(this.k))
        {
          paramIntent.putExtra("email", str2);
        }
        else if (str1.contains(this.jdField_b_of_type_JavaLangString))
        {
          paramIntent.putExtra("phone", arrayOfString[0]);
          if (str1.contains(this.jdField_c_of_type_JavaLangString)) {
            paramIntent.putExtra("phone_type", 1);
          }
          for (;;)
          {
            if (arrayOfString.length <= 1) {
              break label266;
            }
            paramIntent.putExtra("secondary_phone", arrayOfString[1]);
            if (!str1.contains(this.jdField_c_of_type_JavaLangString)) {
              break label268;
            }
            paramIntent.putExtra("phone_type", 1);
            break;
            if (str1.contains(this.d)) {
              paramIntent.putExtra("phone_type", 3);
            } else {
              paramIntent.putExtra("phone_type", 7);
            }
          }
          label266:
          continue;
          label268:
          if (str1.contains(this.d)) {
            paramIntent.putExtra("phone_type", 3);
          } else {
            paramIntent.putExtra("phone_type", 7);
          }
        }
      }
    }
    try
    {
      startActivity(paramIntent);
      return;
    }
    catch (ActivityNotFoundException paramIntent)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("QrcodeScannerCard", 2, "Intent.ACTION_INSERT or ACTION_INSERT_OR_EDIT do not exist");
    }
  }
  
  public void a(String paramString)
  {
    bgpa localbgpa = bglp.a(this, 230);
    localbgpa.setTitle(2131715853);
    localbgpa.setMessage(paramString);
    zsa localzsa = new zsa(this);
    localbgpa.setPositiveButton(2131694081, new zsb(this, paramString));
    localbgpa.setNegativeButton(2131690582, localzsa);
    localbgpa.show();
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool);
    return bool;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      a(null, 4, null, null);
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    super.setContentView(2131560392);
    paramBundle = super.getIntent();
    a();
    String str = paramBundle.getStringExtra("QRCARDSTR");
    a(paramBundle.getIntExtra("CARDMODE", 3), str);
    b();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_JavaLangThread != null)
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
    }
    if (this.jdField_a_of_type_Bkho != null) {
      this.jdField_a_of_type_Bkho.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.QRCardActivity
 * JD-Core Version:    0.7.0.1
 */