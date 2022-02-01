import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.widget.ClickableColorSpanTextView;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportProgressDialog;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.HashMap;

public class bhlq
{
  public static final HashMap<String, String> a = new HashMap();
  
  static
  {
    a.put("android.permission.READ_EXTERNAL_STORAGE", anzj.a(2131702173));
    a.put("android.permission.WRITE_EXTERNAL_STORAGE", anzj.a(2131702188));
    a.put("android.permission.READ_PHONE_STATE", "QQ使用电话权限确定本机号码和设备ID，以保证帐号登录的安全性。QQ不会拨打其他号码或终止通话。\n" + anzj.a(2131702159));
    a.put("android.permission.CAMERA", anzj.a(2131702200));
    a.put("android.permission.RECORD_AUDIO", anzj.a(2131702171));
    a.put("android.permission.ACCESS_COARSE_LOCATION", anzj.a(2131702166));
    a.put("android.permission.ACCESS_FINE_LOCATION", anzj.a(2131702172));
    a.put("android.permission.READ_CALENDAR", anzj.a(2131702216));
    a.put("android.permission.WRITE_CALENDAR", anzj.a(2131702214));
    a.put("android.permission.SEND_SMS", anzj.a(2131702202));
    a.put("android.permission.READ_CONTACTS", anzj.a(2131702191));
    a.put("android.permission.WRITE_CONTACTS", anzj.a(2131702209));
  }
  
  public static Dialog a(Activity paramActivity, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2)
  {
    paramActivity = bhgq.a(paramActivity, 2131697642, 2131697640, 2131697639, 2131697641, paramOnClickListener1, paramOnClickListener2);
    paramActivity.setCancelable(false);
    return paramActivity;
  }
  
  public static Dialog a(Context paramContext, int paramInt1, bhmf parambhmf, Object paramObject, int paramInt2, int paramInt3, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject1 = paramContext.getResources();
    String str2 = ((Resources)localObject1).getString(paramInt2);
    String str1 = ((Resources)localObject1).getString(paramInt3);
    paramContext = new ReportDialog(paramContext, 2131755824);
    paramContext.setContentView(2131559014);
    Object localObject2 = (TextView)paramContext.findViewById(2131365523);
    FrameLayout localFrameLayout = (FrameLayout)paramContext.findViewById(2131365524);
    if (paramInt1 <= 0)
    {
      ((ViewGroup.MarginLayoutParams)((TextView)localObject2).getLayoutParams()).topMargin = 0;
      ((TextView)localObject2).setVisibility(8);
      ((TextView)localObject2).requestLayout();
      localObject2 = (ViewGroup.MarginLayoutParams)localFrameLayout.getLayoutParams();
      paramInt1 = (int)((Resources)localObject1).getDisplayMetrics().density;
      ((ViewGroup.MarginLayoutParams)localObject2).topMargin = (paramInt1 * 18);
      ((ViewGroup.MarginLayoutParams)localObject2).bottomMargin = (paramInt1 * 18);
      localFrameLayout.requestLayout();
    }
    for (;;)
    {
      localObject1 = (TextView)paramContext.findViewById(2131365508);
      if (localObject1 != null)
      {
        ((TextView)localObject1).setText(str2);
        ((TextView)localObject1).setContentDescription(str2);
        ((TextView)localObject1).setOnClickListener(paramOnClickListener1);
        if (paramBoolean1) {
          ((TextView)localObject1).getPaint().setFakeBoldText(true);
        }
      }
      paramOnClickListener1 = (TextView)paramContext.findViewById(2131365514);
      if (paramOnClickListener1 != null)
      {
        paramOnClickListener1.setText(str1);
        paramOnClickListener1.setContentDescription(str1);
        paramOnClickListener1.setOnClickListener(paramOnClickListener2);
        if (paramBoolean2) {
          paramOnClickListener1.getPaint().setFakeBoldText(true);
        }
      }
      localFrameLayout.addView(parambhmf.a(localFrameLayout.getContext(), paramObject));
      return paramContext;
      localObject1 = ((Resources)localObject1).getString(paramInt1);
      if (localObject2 != null)
      {
        ((TextView)localObject2).setText((CharSequence)localObject1);
        ((TextView)localObject2).setContentDescription((CharSequence)localObject1);
      }
    }
  }
  
  public static Dialog a(Context paramContext, int paramInt1, String paramString, int paramInt2, int paramInt3, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2)
  {
    return a(paramContext, paramInt1, paramString, paramInt2, paramInt3, paramOnClickListener1, paramOnClickListener2, false, false);
  }
  
  public static Dialog a(Context paramContext, int paramInt1, String paramString, int paramInt2, int paramInt3, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject1 = paramContext.getResources();
    String str2 = ((Resources)localObject1).getString(paramInt2);
    String str1 = ((Resources)localObject1).getString(paramInt3);
    paramContext = new ReportDialog(paramContext, 2131755824);
    paramContext.setContentView(2131558984);
    Object localObject2 = (TextView)paramContext.findViewById(2131365523);
    TextView localTextView = (TextView)paramContext.findViewById(2131365519);
    if (paramInt1 <= 0)
    {
      ((ViewGroup.MarginLayoutParams)((TextView)localObject2).getLayoutParams()).topMargin = 0;
      ((TextView)localObject2).setVisibility(8);
      ((TextView)localObject2).requestLayout();
      localObject2 = (ViewGroup.MarginLayoutParams)localTextView.getLayoutParams();
      paramInt1 = (int)((Resources)localObject1).getDisplayMetrics().density;
      ((ViewGroup.MarginLayoutParams)localObject2).topMargin = (paramInt1 * 18);
      ((ViewGroup.MarginLayoutParams)localObject2).bottomMargin = (paramInt1 * 18);
      localTextView.requestLayout();
    }
    for (;;)
    {
      if (localTextView != null)
      {
        localTextView.setText(paramString);
        localTextView.setContentDescription(paramString);
      }
      paramString = (TextView)paramContext.findViewById(2131365508);
      if (paramString != null)
      {
        paramString.setText(str2);
        paramString.setContentDescription(str2);
        paramString.setOnClickListener(paramOnClickListener1);
        if (paramBoolean1) {
          paramString.getPaint().setFakeBoldText(true);
        }
      }
      paramString = (TextView)paramContext.findViewById(2131365514);
      if (paramString != null)
      {
        paramString.setText(str1);
        paramString.setContentDescription(str1);
        paramString.setOnClickListener(paramOnClickListener2);
        if (paramBoolean2) {
          paramString.getPaint().setFakeBoldText(true);
        }
      }
      return paramContext;
      localObject1 = ((Resources)localObject1).getString(paramInt1);
      if (localObject2 != null)
      {
        ((TextView)localObject2).setText((CharSequence)localObject1);
        ((TextView)localObject2).setContentDescription((CharSequence)localObject1);
      }
    }
  }
  
  public static Dialog a(Context paramContext, Bitmap paramBitmap, String paramString1, String paramString2, String paramString3, String paramString4, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2)
  {
    paramContext = new ReportDialog(paramContext, 2131755824);
    paramContext.setContentView(2131559020);
    ImageView localImageView = (ImageView)paramContext.findViewById(2131368212);
    TextView localTextView1 = (TextView)paramContext.findViewById(2131378936);
    TextView localTextView2 = (TextView)paramContext.findViewById(2131365046);
    TextView localTextView3 = (TextView)paramContext.findViewById(2131364153);
    TextView localTextView4 = (TextView)paramContext.findViewById(2131364956);
    if (paramBitmap == null)
    {
      localImageView.setVisibility(8);
      if (paramString2 != null) {
        break label140;
      }
      localTextView2.setVisibility(8);
      label94:
      localTextView1.setText(paramString1);
      if (paramOnClickListener1 != null) {
        break label149;
      }
      localTextView3.setVisibility(8);
      label112:
      if (paramOnClickListener2 != null) {
        break label166;
      }
      localTextView4.setVisibility(8);
    }
    for (;;)
    {
      paramContext.setCanceledOnTouchOutside(false);
      return paramContext;
      localImageView.setImageBitmap(paramBitmap);
      break;
      label140:
      localTextView2.setText(paramString2);
      break label94;
      label149:
      localTextView3.setOnClickListener(paramOnClickListener1);
      localTextView3.setText(paramString3);
      break label112;
      label166:
      localTextView4.setOnClickListener(paramOnClickListener2);
      localTextView4.setText(paramString4);
    }
  }
  
  public static Dialog a(Context paramContext, Drawable paramDrawable, String paramString1, String paramString2, String paramString3, String paramString4, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2)
  {
    paramContext = new ReportDialog(paramContext, 2131755824);
    paramContext.setContentView(2131560925);
    ImageView localImageView = (ImageView)paramContext.findViewById(2131380409);
    TextView localTextView1 = (TextView)paramContext.findViewById(2131380410);
    TextView localTextView2 = (TextView)paramContext.findViewById(2131380411);
    TextView localTextView3 = (TextView)paramContext.findViewById(2131380405);
    TextView localTextView4 = (TextView)paramContext.findViewById(2131380406);
    if (paramDrawable == null)
    {
      localImageView.setVisibility(8);
      if (paramString2 != null) {
        break label140;
      }
      localTextView2.setVisibility(8);
      label94:
      localTextView1.setText(paramString1);
      if (paramOnClickListener1 != null) {
        break label149;
      }
      localTextView3.setVisibility(8);
      label112:
      if (paramOnClickListener2 != null) {
        break label166;
      }
      localTextView4.setVisibility(8);
    }
    for (;;)
    {
      paramContext.setCanceledOnTouchOutside(false);
      return paramContext;
      localImageView.setImageDrawable(paramDrawable);
      break;
      label140:
      localTextView2.setText(paramString2);
      break label94;
      label149:
      localTextView3.setOnClickListener(paramOnClickListener1);
      localTextView3.setText(paramString3);
      break label112;
      label166:
      localTextView4.setOnClickListener(paramOnClickListener2);
      localTextView4.setText(paramString4);
    }
  }
  
  public static Dialog a(Context paramContext, Drawable paramDrawable, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2)
  {
    paramContext = new ReportDialog(paramContext, 2131755824);
    paramContext.setContentView(2131559028);
    ImageView localImageView = (ImageView)paramContext.findViewById(2131380409);
    TextView localTextView1 = (TextView)paramContext.findViewById(2131365523);
    TextView localTextView2 = (TextView)paramContext.findViewById(2131380410);
    TextView localTextView3 = (TextView)paramContext.findViewById(2131380411);
    TextView localTextView4 = (TextView)paramContext.findViewById(2131380405);
    TextView localTextView5 = (TextView)paramContext.findViewById(2131380406);
    if (paramDrawable == null)
    {
      localImageView.setVisibility(8);
      if (paramString1 != null) {
        break label163;
      }
      localTextView1.setVisibility(8);
      label105:
      if (paramString3 != null) {
        break label172;
      }
      localTextView3.setVisibility(8);
      label117:
      localTextView2.setText(paramString2);
      if (paramOnClickListener1 != null) {
        break label182;
      }
      localTextView4.setVisibility(8);
      label135:
      if (paramOnClickListener2 != null) {
        break label199;
      }
      localTextView5.setVisibility(8);
    }
    for (;;)
    {
      paramContext.setCanceledOnTouchOutside(false);
      return paramContext;
      localImageView.setImageDrawable(paramDrawable);
      break;
      label163:
      localTextView1.setText(paramString1);
      break label105;
      label172:
      localTextView3.setText(paramString3);
      break label117;
      label182:
      localTextView4.setOnClickListener(paramOnClickListener1);
      localTextView4.setText(paramString4);
      break label135;
      label199:
      localTextView5.setOnClickListener(paramOnClickListener2);
      localTextView5.setText(paramString5);
    }
  }
  
  public static Dialog a(Context paramContext, String paramString, int paramInt1, int paramInt2, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2)
  {
    paramContext = new ReportDialog(paramContext, 2131755824);
    paramContext.getWindow().setWindowAnimations(2131755130);
    paramContext.setContentView(2131561147);
    ((TextView)paramContext.findViewById(2131365556)).setVisibility(8);
    TextView localTextView1 = (TextView)paramContext.findViewById(2131365544);
    TextView localTextView2 = (TextView)paramContext.findViewById(2131365542);
    TextView localTextView3 = (TextView)paramContext.findViewById(2131365548);
    localTextView1.setText(paramString);
    localTextView1.setGravity(3);
    if (paramInt1 == 0) {
      localTextView2.setVisibility(8);
    }
    for (;;)
    {
      localTextView3.setText(paramInt2);
      localTextView2.setOnClickListener(paramOnClickListener1);
      localTextView3.setOnClickListener(paramOnClickListener2);
      return paramContext;
      localTextView2.setText(paramInt1);
    }
  }
  
  public static Dialog a(Context paramContext, String paramString, CharSequence paramCharSequence, int paramInt1, int paramInt2, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, bivv parambivv)
  {
    paramContext = new ReportDialog(paramContext, 2131755824);
    paramContext.setContentView(2131561147);
    TextView localTextView3 = (TextView)paramContext.findViewById(2131365556);
    ClickableColorSpanTextView localClickableColorSpanTextView = (ClickableColorSpanTextView)paramContext.findViewById(2131365544);
    TextView localTextView1 = (TextView)paramContext.findViewById(2131365542);
    TextView localTextView2 = (TextView)paramContext.findViewById(2131365548);
    if (paramString == null)
    {
      localTextView3.setVisibility(8);
      localClickableColorSpanTextView.setText(paramCharSequence);
      if (paramInt1 != 0) {
        break label144;
      }
      localTextView1.setVisibility(8);
      label89:
      if (paramInt2 != 0) {
        break label153;
      }
      localTextView2.setVisibility(8);
    }
    for (;;)
    {
      paramString = new bhmb(paramOnClickListener1, paramContext, paramOnClickListener2);
      localTextView1.setOnClickListener(paramString);
      localTextView2.setOnClickListener(paramString);
      localClickableColorSpanTextView.setSpanClickListener(parambivv);
      return paramContext;
      localTextView3.setText(paramString);
      break;
      label144:
      localTextView1.setText(paramInt1);
      break label89;
      label153:
      localTextView2.setText(paramInt2);
    }
  }
  
  public static ProgressDialog a(Context paramContext, int paramInt)
  {
    return a(paramContext, paramContext.getResources().getDrawable(2130849606), paramInt);
  }
  
  public static ProgressDialog a(Context paramContext, Drawable paramDrawable, int paramInt)
  {
    return a(paramContext, paramDrawable, paramInt, 0);
  }
  
  public static ProgressDialog a(Context paramContext, Drawable paramDrawable, int paramInt1, int paramInt2)
  {
    int i = paramInt2;
    if (paramInt2 <= 0) {
      i = 2131755824;
    }
    paramContext = new ReportProgressDialog(paramContext, i);
    try
    {
      paramContext.show();
      label26:
      paramContext.getWindow().setContentView(2131558434);
      paramContext.setContentView(2131558434);
      ((TextView)paramContext.findViewById(2131365519)).setText(paramInt1);
      ((ProgressBar)paramContext.findViewById(2131367008)).setIndeterminateDrawable(paramDrawable);
      return paramContext;
    }
    catch (Exception localException)
    {
      break label26;
    }
  }
  
  public static bhdm a(Activity paramActivity, String paramString1, long paramLong, String paramString2, CharSequence paramCharSequence)
  {
    paramActivity = new bhdm(paramActivity);
    paramActivity.a(new begp(a(paramString1), 3)).b(new begp(a(paramString2), 3)).a(paramLong).c(paramCharSequence);
    paramActivity.setCanceledOnTouchOutside(false);
    paramActivity.setCancelable(true);
    return paramActivity;
  }
  
  public static bhot a(Context paramContext, String paramString, Bundle paramBundle)
  {
    bhot localbhot = new bhot(paramContext, 2131755824);
    localbhot.a(paramContext, paramBundle);
    localbhot.setTitle(paramString);
    localbhot.setCanceledOnTouchOutside(false);
    localbhot.setCancelable(true);
    return localbhot;
  }
  
  public static bhot a(Context paramContext, String paramString, Bundle paramBundle, int paramInt)
  {
    bhot localbhot = new bhot(paramContext, 2131755824);
    localbhot.a(paramContext, paramBundle);
    localbhot.setTitle(paramString);
    localbhot.setCanceledOnTouchOutside(false);
    localbhot.setCancelable(true);
    if (paramInt > 0) {
      localbhot.c(paramInt);
    }
    return localbhot;
  }
  
  public static bhox a(Context paramContext, String paramString, Bundle paramBundle)
  {
    bhox localbhox = new bhox(paramContext, 2131755824);
    localbhox.a(paramContext, paramBundle);
    localbhox.setTitle(paramString);
    localbhox.setCanceledOnTouchOutside(true);
    localbhox.setCancelable(true);
    return localbhox;
  }
  
  public static bhpb a(Context paramContext, bhuk parambhuk, DialogInterface.OnClickListener paramOnClickListener)
  {
    if ((parambhuk == null) || (parambhuk.a() <= 0)) {
      return null;
    }
    paramContext = new bhpb(paramContext, 2131755824);
    paramContext.setCanceledOnTouchOutside(true);
    paramContext.setContentView(2131559008);
    paramContext.a(parambhuk, paramOnClickListener);
    paramContext.a(2131558998);
    ((LinearLayout)paramContext.findViewById(2131363705)).setLayoutParams(new RelativeLayout.LayoutParams(-1, 0));
    parambhuk = (ListView)paramContext.findViewById(2131370012);
    paramOnClickListener = new RelativeLayout.LayoutParams(-1, -2);
    paramOnClickListener.addRule(3, 2131365523);
    parambhuk.setLayoutParams(paramOnClickListener);
    return paramContext;
  }
  
  public static bhpc a(Activity paramActivity)
  {
    bhpc localbhpc = a(paramActivity, 230);
    localbhpc.setTitle(anzj.a(2131702161));
    localbhpc.setMessage(2131693428);
    localbhpc.setNegativeButton(anzj.a(2131702192), new bhlu(localbhpc));
    localbhpc.setPositiveButton(anzj.a(2131713729), new bhlv(paramActivity));
    localbhpc.setOnCancelListener(null);
    localbhpc.show();
    return localbhpc;
  }
  
  public static bhpc a(Activity paramActivity, int paramInt)
  {
    return a(paramActivity, paramActivity.getString(paramInt), 2131690580, 2131694098, null, null);
  }
  
  public static bhpc a(Activity paramActivity, int paramInt1, int paramInt2)
  {
    bhpc localbhpc = a(paramActivity, 230);
    localbhpc.setTitle(paramActivity.getString(paramInt2));
    localbhpc.setMessage(paramInt1);
    localbhpc.setNegativeButton(paramActivity.getString(2131690580), new bhlw(localbhpc));
    localbhpc.setPositiveButton(paramActivity.getString(2131717964), new bhlx(paramActivity));
    localbhpc.setOnCancelListener(null);
    localbhpc.show();
    return localbhpc;
  }
  
  public static bhpc a(Activity paramActivity, bdhy parambdhy)
  {
    parambdhy = new bhma(paramActivity, parambdhy);
    paramActivity = a(paramActivity, 230);
    paramActivity.setTitle(anzj.a(2131709083));
    paramActivity.setMessage(anzj.a(2131706820));
    paramActivity.setNegativeButton(anzj.a(2131702192), parambdhy);
    paramActivity.setPositiveButton(anzj.a(2131702176), parambdhy);
    paramActivity.show();
    return paramActivity;
  }
  
  public static bhpc a(Activity paramActivity, String paramString)
  {
    return a(paramActivity, paramString, 2131690580, 2131694098, null, null);
  }
  
  public static bhpc a(Activity paramActivity, String paramString, int paramInt1, int paramInt2, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramString = a(paramActivity, 230, null, paramString, paramInt1, paramInt2, paramOnClickListener1, paramOnClickListener2);
    if (paramString != null)
    {
      ((TextView)paramString.findViewById(2131365497)).setVisibility(8);
      ((TextView)paramString.findViewById(2131365519)).setMinHeight(bhgr.a(paramActivity, 35.0F));
    }
    return paramString;
  }
  
  public static bhpc a(Activity paramActivity, String paramString1, long paramLong, String paramString2, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    bhpc localbhpc = new bhpc(paramActivity, 2131755824);
    localbhpc.setContentView(2131559008);
    localbhpc.setTitle(paramString1);
    paramActivity = paramActivity.getLayoutInflater().inflate(2131558891, null);
    paramString1 = (TextView)paramActivity.findViewById(2131380316);
    String str = bhdm.a((float)paramLong, true, 2);
    if (!TextUtils.isEmpty(str)) {
      paramString1.setText(anzj.a(2131702180) + str);
    }
    ((TextView)paramActivity.findViewById(2131365519)).setText(paramString2);
    localbhpc.addView(paramActivity);
    localbhpc.setNegativeButton(anzj.a(2131702156), paramOnClickListener1);
    localbhpc.setPositiveButton(anzj.a(2131702205), paramOnClickListener2);
    localbhpc.setCanceledOnTouchOutside(false);
    return localbhpc;
  }
  
  public static bhpc a(Activity paramActivity, String paramString1, String paramString2)
  {
    bhls localbhls = new bhls(paramActivity);
    bhpc localbhpc = a(paramActivity, 230);
    if (paramString1 != null)
    {
      paramActivity = paramString1;
      if (!paramString1.equals("")) {}
    }
    else
    {
      paramActivity = anzj.a(2131702165);
    }
    localbhpc.setTitle(paramActivity);
    if (paramString2 != null)
    {
      paramActivity = paramString2;
      if (!paramString2.equals("")) {}
    }
    else
    {
      paramActivity = anzj.a(2131702217);
    }
    localbhpc.setMessage(paramActivity);
    localbhpc.setPositiveButton(anzj.a(2131702220), localbhls);
    localbhpc.show();
    return localbhpc;
  }
  
  public static bhpc a(Activity paramActivity, String paramString1, String paramString2, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    bhpc localbhpc = a(paramActivity, 230);
    if (paramString1 != null)
    {
      paramActivity = paramString1;
      if (!paramString1.equals("")) {}
    }
    else
    {
      paramActivity = anzj.a(2131702161);
    }
    localbhpc.setTitle(paramActivity);
    if (paramString2 != null)
    {
      paramActivity = paramString2;
      if (!paramString2.equals("")) {}
    }
    else
    {
      paramActivity = anzj.a(2131702199);
    }
    localbhpc.setMessage(paramActivity);
    localbhpc.setNegativeButton(anzj.a(2131702192), paramOnClickListener1);
    localbhpc.setPositiveButton(anzj.a(2131702176), paramOnClickListener2);
    localbhpc.setOnCancelListener(paramOnCancelListener);
    localbhpc.show();
    return localbhpc;
  }
  
  public static bhpc a(Activity paramActivity, String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener)
  {
    paramActivity = a(paramActivity, 0, paramString1, paramString2, null, null);
    if (paramActivity.getTitleTextView() != null) {
      paramActivity.getTitleTextView().getPaint().setFakeBoldText(true);
    }
    if (paramActivity.getBtnight() != null) {
      paramActivity.getBtnight().getPaint().setFakeBoldText(true);
    }
    paramActivity.setPositiveButton(paramString3, paramOnClickListener);
    paramActivity.setCancelable(true);
    paramActivity.setCanceledOnTouchOutside(true);
    return paramActivity;
  }
  
  public static bhpc a(Activity paramActivity, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if (paramArrayOfString == null) {
      return null;
    }
    int i;
    Object localObject2;
    Object localObject1;
    for (;;)
    {
      try
      {
        if (paramArrayOfString.length != 1) {
          break label114;
        }
        paramArrayOfString = a(new String[] { paramArrayOfString[0] });
        return b(paramActivity, null, paramArrayOfString);
      }
      catch (Exception paramActivity)
      {
        return null;
      }
      if (i < paramArrayOfInt.length)
      {
        localObject1 = localObject2;
        if (paramArrayOfInt[i] == 0) {
          break;
        }
        if (localObject2 == null) {
          break label133;
        }
        localObject1 = (String)localObject2 + "#" + paramArrayOfString[i];
        break;
      }
      if (localObject2 != null)
      {
        paramArrayOfString = a(((String)localObject2).split("#"));
      }
      else
      {
        paramArrayOfString = null;
        continue;
        label114:
        i = 0;
        localObject2 = null;
      }
    }
    for (;;)
    {
      i += 1;
      localObject2 = localObject1;
      break;
      label133:
      localObject1 = paramArrayOfString[i];
    }
  }
  
  public static bhpc a(Context paramContext, int paramInt)
  {
    return a(paramContext, paramInt, null, null, 2131690580, 2131694098, null, null);
  }
  
  public static bhpc a(Context paramContext, int paramInt1, int paramInt2, String paramString, CharSequence paramCharSequence, int paramInt3, int paramInt4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new bhpc(paramContext, 2131755824);
    paramContext.setContentView(paramInt2);
    paramContext.setTitle(paramString);
    paramContext.setMessageWithoutAutoLink(paramCharSequence);
    paramContext.setNegativeButton(paramInt3, paramOnClickListener2);
    paramContext.setPositiveButton(paramInt4, paramOnClickListener1);
    paramContext.setCanceledOnTouchOutside(true);
    return paramContext;
  }
  
  public static bhpc a(Context paramContext, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new bhpc(paramContext, 2131755824);
    paramContext.setContentView(paramInt2);
    paramContext.setTitle(paramString1);
    paramContext.setMessage(paramString2);
    paramContext.setNegativeButton(paramString3, paramOnClickListener2);
    paramContext.setPositiveButton(paramString4, paramOnClickListener1);
    paramContext.setCanceledOnTouchOutside(false);
    return paramContext;
  }
  
  public static bhpc a(Context paramContext, int paramInt1, String paramString, CharSequence paramCharSequence, int paramInt2, int paramInt3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    return a(paramContext, paramInt1, 2131559008, paramString, paramCharSequence, paramInt2, paramInt3, paramOnClickListener1, paramOnClickListener2);
  }
  
  public static bhpc a(Context paramContext, int paramInt, String paramString1, CharSequence paramCharSequence, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new bhpc(paramContext, 2131755824);
    paramContext.setContentView(2131559008);
    paramContext.setTitle(paramString1);
    paramContext.setMessage(paramCharSequence);
    paramContext.setNegativeButton(paramString2, paramOnClickListener2);
    paramContext.setPositiveButton(paramString3, paramOnClickListener1);
    paramContext.setCanceledOnTouchOutside(false);
    return paramContext;
  }
  
  public static bhpc a(Context paramContext, int paramInt, String paramString1, CharSequence paramCharSequence, String paramString2, String paramString3, String paramString4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    return a(paramContext, paramInt, paramString1, paramCharSequence, paramString2, paramString3, paramString4, paramOnClickListener1, paramOnClickListener2, null);
  }
  
  public static bhpc a(Context paramContext, int paramInt, String paramString1, CharSequence paramCharSequence, String paramString2, String paramString3, String paramString4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnClickListener paramOnClickListener3)
  {
    bhpc localbhpc = new bhpc(paramContext, 2131755824);
    localbhpc.setContentView(2131559013);
    if (paramInt != 0) {
      localbhpc.setOperateImage(paramContext.getResources().getDrawable(paramInt));
    }
    for (;;)
    {
      localbhpc.setMessage(paramCharSequence);
      localbhpc.setNegativeButton(paramString2, paramOnClickListener1);
      localbhpc.setPositiveButton(paramString3, paramOnClickListener2);
      localbhpc.setCanceledOnTouchOutside(false);
      paramString1 = (TextView)localbhpc.findViewById(2131365499);
      paramContext = paramString4;
      if (paramString4 == null) {
        paramContext = anzj.a(2131702196);
      }
      paramString1.setText(paramContext);
      if (paramOnClickListener3 == null) {
        break;
      }
      paramString1.setOnClickListener(new bhmc(paramOnClickListener3, localbhpc));
      return localbhpc;
      localbhpc.setTitle(paramString1);
    }
    paramString1.setOnClickListener(new bhmd(localbhpc));
    return localbhpc;
  }
  
  public static bhpc a(Context paramContext, int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new bhpc(paramContext, 2131755824);
    paramContext.setContentView(2131559008);
    paramContext.setTitle(paramString1);
    paramContext.setMessage(paramString2);
    paramContext.setNegativeButton(paramInt2, paramOnClickListener2);
    paramContext.setPositiveButton(paramInt3, paramOnClickListener1);
    paramContext.setCanceledOnTouchOutside(false);
    return paramContext;
  }
  
  public static bhpc a(Context paramContext, int paramInt, String paramString1, String paramString2, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    return a(paramContext, paramInt, paramString1, paramString2, 2131690580, 2131694098, paramOnClickListener1, paramOnClickListener2);
  }
  
  public static bhpc a(Context paramContext, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt2, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new bhpc(paramContext, 2131755824);
    paramContext.setContentView(2131559008);
    paramContext.setTitle(paramString1);
    paramContext.setMessage(paramString2);
    paramContext.setNegativeButton(paramString3, paramOnClickListener2);
    paramContext.setPositiveButton(paramString4, paramInt2, paramOnClickListener1);
    paramContext.setCanceledOnTouchOutside(false);
    return paramContext;
  }
  
  public static bhpc a(Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new bhpc(paramContext, 2131755824);
    paramContext.setContentView(2131559008);
    paramContext.setTitle(paramString1);
    paramContext.setMessage(paramString2);
    paramContext.setNegativeButton(paramString3, paramOnClickListener2);
    paramContext.setPositiveButton(paramString4, paramOnClickListener1);
    paramContext.setCanceledOnTouchOutside(false);
    paramString1 = (TextView)paramContext.findViewById(2131365497);
    paramString1 = (TextView)paramContext.findViewById(2131365519);
    paramString2 = new LinearLayout.LayoutParams(-2, -2);
    paramString2.gravity = 17;
    paramString1.setLayoutParams(paramString2);
    return paramContext;
  }
  
  public static bhpc a(Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnClickListener paramOnClickListener3)
  {
    paramContext = new bhpc(paramContext, 2131755824);
    paramContext.setContentView(2131558992);
    paramContext.setTitle(paramString1);
    paramContext.setMessage(paramString2);
    paramContext.setNegativeButton(paramString4, paramOnClickListener3);
    paramContext.setPositiveButton(paramString5, paramOnClickListener2);
    paramContext.setCanceledOnTouchOutside(false);
    paramContext.setCheckBox(paramString3, paramOnClickListener1);
    return paramContext;
  }
  
  public static bhpc a(Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3, boolean paramBoolean, String paramString4, String paramString5, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnClickListener paramOnClickListener3)
  {
    paramContext = a(paramContext, paramInt, paramString1, paramString2, paramString4, paramString5, paramOnClickListener2, paramOnClickListener3);
    paramContext.setCheckBox(paramString3, paramBoolean, paramOnClickListener1);
    return paramContext;
  }
  
  public static bhpc a(Context paramContext, String paramString1, CharSequence paramCharSequence, String paramString2, String paramString3, boolean paramBoolean, int paramInt, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2)
  {
    bhlr localbhlr = new bhlr(paramContext, 2131755824, paramInt, paramBoolean, paramString2);
    localbhlr.setContentView(2131559008);
    localbhlr.setCanceledOnTouchOutside(false);
    localbhlr.setTitle(paramString1);
    localbhlr.setMessage(paramCharSequence);
    localbhlr.title.setTypeface(Typeface.DEFAULT_BOLD);
    localbhlr.rBtn.setTypeface(Typeface.DEFAULT_BOLD);
    localbhlr.lBtn.setTypeface(Typeface.DEFAULT_BOLD);
    localbhlr.lBtn.setTextColor(paramContext.getResources().getColorStateList(2131165566));
    localbhlr.lBtn.setText(paramString2);
    localbhlr.lBtn.setVisibility(0);
    localbhlr.lBtn.setOnClickListener(paramOnClickListener1);
    localbhlr.rBtn.setVisibility(0);
    localbhlr.rBtn.setText(paramString3);
    localbhlr.rBtn.setOnClickListener(paramOnClickListener2);
    return localbhlr;
  }
  
  public static bhpc a(Context paramContext, String paramString1, String paramString2, DialogInterface.OnClickListener paramOnClickListener)
  {
    paramContext = new bhpc(paramContext, 2131755824);
    paramContext.setContentView(2131559005);
    paramContext.setTitle(paramString1);
    paramContext.setNegativeButton(paramString2, paramOnClickListener);
    paramContext.setCanceledOnTouchOutside(false);
    return paramContext;
  }
  
  public static bhpc a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = a(paramContext, 230, paramString1, paramString2, paramInt1, paramInt2, paramOnClickListener1, paramOnClickListener2);
    paramContext.setEditLint(paramString3);
    return paramContext;
  }
  
  public static bhpc a(Context paramContext, String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener1, String paramString4, DialogInterface.OnClickListener paramOnClickListener2, View.OnClickListener paramOnClickListener)
  {
    paramContext = new bhpc(paramContext, 2131755824);
    paramContext.setContentView(2131558986);
    TextView localTextView1 = (TextView)paramContext.findViewById(2131365523);
    TextView localTextView2 = (TextView)paramContext.findViewById(2131365519);
    ImageView localImageView = (ImageView)paramContext.findViewById(2131364584);
    localTextView1.setText(paramString1);
    localTextView2.setText(paramString2);
    paramContext.setNegativeButton(paramString3, paramOnClickListener1);
    paramContext.setPositiveButton(paramString4, paramOnClickListener2);
    localImageView.setOnClickListener(paramOnClickListener);
    paramContext.setCanceledOnTouchOutside(false);
    paramContext.setCancelable(false);
    return paramContext;
  }
  
  public static bhpc a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new bhpc(paramContext, 2131755824);
    paramContext.setContentView(2131558995);
    paramContext.setTitleWithEmo(new begp(a(paramString1), 3));
    paramContext.setMessage(new begp(a(paramString2), 3));
    paramContext.setNegativeButton(paramString3, paramOnClickListener2);
    paramContext.setPositiveButton(paramString4, paramOnClickListener1);
    if ((paramString5 != null) && (!"".equals(paramString5))) {
      paramContext.setCheckBox(paramString5, null);
    }
    paramContext.setCanceledOnTouchOutside(false);
    return paramContext;
  }
  
  public static bhpr a(Context paramContext, int paramInt)
  {
    return a(paramContext, paramInt, null, null, "", "", "", null, null, null);
  }
  
  public static bhpr a(Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnClickListener paramOnClickListener3)
  {
    paramContext = new bhpr(paramContext, 2131755824);
    paramContext.setContentView(2131559011);
    paramContext.a(paramString1);
    paramContext.b(paramString2);
    paramContext.a(paramString4, paramOnClickListener1);
    paramContext.b(paramString5, paramOnClickListener2);
    paramContext.b(paramString4, paramOnClickListener3);
    paramContext.setCanceledOnTouchOutside(true);
    return paramContext;
  }
  
  public static bhpy a(Context paramContext, String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new bhpy(paramContext, 2131755824);
    paramContext.setContentView(2131559019);
    paramContext.setTitle(paramString1);
    paramContext.setMessage(paramString2);
    paramContext.setCanceledOnTouchOutside(false);
    paramContext.setCancelable(true);
    paramContext.b(paramString3);
    paramContext.setNegativeButton(2131690580, paramOnClickListener2);
    paramContext.setPositiveButton(2131690669, paramOnClickListener1);
    paramContext.show();
    return paramContext;
  }
  
  public static bhpy a(Context paramContext, String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, int paramInt)
  {
    return a(paramContext, paramString1, paramString2, paramString3, paramOnClickListener1, paramOnClickListener2, paramInt, false);
  }
  
  public static bhpy a(Context paramContext, String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, int paramInt, boolean paramBoolean)
  {
    paramContext = new bhpy(paramContext, 2131755824);
    paramContext.b(7);
    paramContext.a(paramBoolean);
    paramContext.setContentView(2131559019);
    paramContext.setTitle(paramString1);
    if (paramInt != 0) {
      paramContext.c(paramInt);
    }
    paramContext.setMessage(paramString2);
    paramContext.setCanceledOnTouchOutside(false);
    paramContext.setCancelable(true);
    paramContext.b(paramString3);
    paramContext.setNegativeButton(2131690580, paramOnClickListener2);
    paramContext.setPositiveButton(2131690669, paramOnClickListener1);
    paramContext.show();
    return paramContext;
  }
  
  public static bhqn a(Context paramContext, int paramInt1, int paramInt2, String paramString, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new bhqn(paramContext, 2131755824);
    paramContext.setContentView(2131559022);
    paramContext.setTitle(paramInt1);
    paramContext.setMessage(paramInt2);
    paramContext.setCanceledOnTouchOutside(false);
    paramContext.setCancelable(true);
    paramContext.a(paramString);
    paramContext.setNegativeButton(2131690580, paramOnClickListener2);
    paramContext.setPositiveButton(2131694098, paramOnClickListener1);
    paramContext.show();
    return paramContext;
  }
  
  public static bhqn a(Context paramContext, int paramInt1, int paramInt2, String paramString, TextWatcher paramTextWatcher, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new bhqn(paramContext, 2131755824);
    paramContext.setContentView(2131559022);
    paramContext.setTitle(paramInt1);
    paramContext.setMessage(paramInt2);
    paramContext.setCanceledOnTouchOutside(false);
    paramContext.setCancelable(true);
    paramContext.a(paramTextWatcher);
    paramContext.a(paramString);
    paramContext.setNegativeButton(2131690580, paramOnClickListener2);
    paramContext.setPositiveButton(2131694098, paramOnClickListener1);
    paramContext.show();
    return paramContext;
  }
  
  public static bhqp a(Context paramContext, String paramString1, String paramString2, String paramString3, ArrayList<String> paramArrayList, String paramString4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, int paramInt, boolean paramBoolean)
  {
    paramContext = new bhqp(paramContext, 2131755824);
    paramContext.a(paramBoolean);
    paramContext.setContentView(2131559024);
    paramContext.setTitle(paramString1);
    if (paramInt != 0) {
      paramContext.a(paramInt);
    }
    paramContext.setMessage(paramString2);
    paramContext.setMessageCount(paramString3);
    paramContext.a(paramArrayList);
    paramContext.setCanceledOnTouchOutside(false);
    paramContext.setCancelable(true);
    paramContext.a(paramString4);
    paramContext.setNegativeButton(2131690580, paramOnClickListener2);
    paramContext.setPositiveButton(2131690669, paramOnClickListener1);
    paramContext.show();
    return paramContext;
  }
  
  public static bhqw a(Context paramContext, String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener1, String paramString4, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new bhqw(paramContext, 2131755824);
    paramContext.setContentView(2131559010);
    paramContext.a(paramString1.replace(anzj.a(2131702211), behh.b(21)).replace(anzj.a(2131702155), behh.b(18)).replace(anzj.a(2131702194), behh.b(86)).replace(anzj.a(2131702213), behh.b(55)).replace("\\U0001f60f", String.valueOf(Character.toChars(128527))).replace("\\U0001f60c", String.valueOf(Character.toChars(128524))));
    paramContext.a(paramString2.replace(anzj.a(2131702193), behh.b(21)).replace(anzj.a(2131702182), behh.b(18)).replace(anzj.a(2131702201), behh.b(86)).replace(anzj.a(2131702208), behh.b(55)).replace("\\U0001f60f", String.valueOf(Character.toChars(128527))).replace("\\U0001f60c", String.valueOf(Character.toChars(128524))), 2.0F);
    paramContext.a(2130839579, 2131690580, paramOnClickListener2);
    paramContext.a(paramString3.replace(anzj.a(2131702160), behh.b(21)).replace(anzj.a(2131702212), behh.b(18)).replace(anzj.a(2131702215), behh.b(86)).replace(anzj.a(2131702157), behh.b(55)).replace("\\U0001f60f", String.valueOf(Character.toChars(128527))).replace("\\U0001f60c", String.valueOf(Character.toChars(128524))), paramOnClickListener1);
    paramContext.setCanceledOnTouchOutside(false);
    return paramContext;
  }
  
  protected static String a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      return paramString.replace(anzj.a(2131702218), behh.b(21)).replace(anzj.a(2131702177), behh.b(18)).replace(anzj.a(2131702158), behh.b(86)).replace(anzj.a(2131702187), behh.b(55)).replace("\\U0001f60f", String.valueOf(Character.toChars(128527))).replace("\\U0001f60c", String.valueOf(Character.toChars(128524)));
    }
    return null;
  }
  
  public static String a(String... paramVarArgs)
  {
    String str2 = anzj.a(2131702197);
    String str1 = null;
    if (paramVarArgs != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      int j = paramVarArgs.length;
      str1 = null;
      int i = 0;
      if (i < j)
      {
        String str3 = paramVarArgs[i];
        if ("android.permission.CAMERA".equals(str3)) {
          str1 = anzj.a(2131702164);
        }
        for (;;)
        {
          if ((str1 != null) && (localStringBuilder.indexOf(str1) < 0))
          {
            if (localStringBuilder.length() > 0) {
              localStringBuilder.append("和");
            }
            localStringBuilder.append(str1);
          }
          i += 1;
          break;
          if ("android.permission.RECORD_AUDIO".equals(str3)) {
            str1 = anzj.a(2131702179);
          } else if ("android.permission.ACCESS_COARSE_LOCATION".equals(str3)) {
            str1 = anzj.a(2131702168);
          } else if ("android.permission.ACCESS_FINE_LOCATION".equals(str3)) {
            str1 = anzj.a(2131702186);
          } else if ("android.permission.READ_CALENDAR".equals(str3)) {
            str1 = anzj.a(2131702198);
          } else if ("android.permission.WRITE_CALENDAR".equals(str3)) {
            str1 = anzj.a(2131702204);
          } else if ("android.permission.SEND_SMS".equals(str3)) {
            str1 = anzj.a(2131702162);
          } else if ("android.permission.READ_CONTACTS".equals(str3)) {
            str1 = anzj.a(2131702169);
          } else if ("android.permission.WRITE_CONTACTS".equals(str3)) {
            str1 = anzj.a(2131702207);
          } else if ("android.permission.WRITE_EXTERNAL_STORAGE".equals(str3)) {
            str1 = anzj.a(2131706821);
          } else if ("android.permission.READ_EXTERNAL_STORAGE".equals(str3)) {
            str1 = anzj.a(2131706819);
          }
        }
      }
      str1 = localStringBuilder.toString();
    }
    return String.format(str2, new Object[] { str1 });
  }
  
  public static bhpc b(Activity paramActivity)
  {
    bhly localbhly = new bhly(paramActivity);
    paramActivity = a(paramActivity, 230);
    paramActivity.setTitle(anzj.a(2131709083));
    paramActivity.setMessage(anzj.a(2131706820));
    paramActivity.setNegativeButton(anzj.a(2131702192), localbhly);
    paramActivity.setPositiveButton(anzj.a(2131702176), localbhly);
    paramActivity.show();
    return paramActivity;
  }
  
  public static bhpc b(Activity paramActivity, String paramString)
  {
    bhlz localbhlz = new bhlz(paramActivity);
    paramActivity = a(paramActivity, 230);
    paramActivity.setTitle(anzj.a(2131709083));
    paramActivity.setMessage(paramString);
    paramActivity.setNegativeButton(anzj.a(2131702192), localbhlz);
    paramActivity.setPositiveButton(anzj.a(2131702176), localbhlz);
    paramActivity.show();
    return paramActivity;
  }
  
  public static bhpc b(Activity paramActivity, String paramString1, String paramString2)
  {
    bhlt localbhlt = new bhlt(paramActivity);
    return a(paramActivity, paramString1, paramString2, localbhlt, localbhlt, null);
  }
  
  public static bhpc b(Activity paramActivity, String paramString1, String paramString2, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    bhpc localbhpc = a(paramActivity, 230);
    String str;
    if (paramString1 != null)
    {
      str = paramString1;
      if (!paramString1.equals("")) {}
    }
    else
    {
      str = paramActivity.getResources().getString(2131694840);
    }
    localbhpc.setTitle(str);
    if (paramString2 != null)
    {
      paramString1 = paramString2;
      if (!paramString2.equals("")) {}
    }
    else
    {
      paramString1 = paramActivity.getResources().getString(2131694837);
    }
    localbhpc.setMessage(paramString1);
    localbhpc.setNegativeButton(paramActivity.getResources().getString(2131690580), paramOnClickListener1);
    localbhpc.setPositiveButton(paramActivity.getResources().getString(2131694098), paramOnClickListener2);
    localbhpc.setOnCancelListener(paramOnCancelListener);
    localbhpc.show();
    return localbhpc;
  }
  
  public static bhpc b(Context paramContext, int paramInt)
  {
    return b(paramContext, paramInt, null, null, 2131690580, 2131694098, null, null);
  }
  
  public static bhpc b(Context paramContext, int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new bhpc(paramContext, 2131755824);
    paramContext.setContentView(2131559008);
    paramContext.setTitle(paramString1);
    paramContext.setMessageWithUrl(paramString2);
    paramContext.setNegativeButton(paramInt2, paramOnClickListener2);
    paramContext.setPositiveButton(paramInt3, paramOnClickListener1);
    paramContext.setCanceledOnTouchOutside(true);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bhlq
 * JD-Core Version:    0.7.0.1
 */