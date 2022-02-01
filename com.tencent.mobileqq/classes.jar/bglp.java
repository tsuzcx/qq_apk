import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.graphics.Bitmap;
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

public class bglp
{
  public static final HashMap<String, String> a = new HashMap();
  
  static
  {
    a.put("android.permission.READ_EXTERNAL_STORAGE", anni.a(2131702066));
    a.put("android.permission.WRITE_EXTERNAL_STORAGE", anni.a(2131702081));
    a.put("android.permission.READ_PHONE_STATE", "QQ使用电话权限确定本机号码和设备ID，以保证帐号登录的安全性。QQ不会拨打其他号码或终止通话。\n" + anni.a(2131702052));
    a.put("android.permission.CAMERA", anni.a(2131702093));
    a.put("android.permission.RECORD_AUDIO", anni.a(2131702064));
    a.put("android.permission.ACCESS_COARSE_LOCATION", anni.a(2131702059));
    a.put("android.permission.ACCESS_FINE_LOCATION", anni.a(2131702065));
    a.put("android.permission.READ_CALENDAR", anni.a(2131702109));
    a.put("android.permission.WRITE_CALENDAR", anni.a(2131702107));
    a.put("android.permission.SEND_SMS", anni.a(2131702095));
    a.put("android.permission.READ_CONTACTS", anni.a(2131702084));
    a.put("android.permission.WRITE_CONTACTS", anni.a(2131702102));
  }
  
  public static Dialog a(Activity paramActivity, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2)
  {
    paramActivity = bggp.a(paramActivity, 2131697558, 2131697556, 2131697555, 2131697557, paramOnClickListener1, paramOnClickListener2);
    paramActivity.setCancelable(false);
    return paramActivity;
  }
  
  public static Dialog a(Context paramContext, int paramInt1, bgmd parambgmd, Object paramObject, int paramInt2, int paramInt3, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject1 = paramContext.getResources();
    String str2 = ((Resources)localObject1).getString(paramInt2);
    String str1 = ((Resources)localObject1).getString(paramInt3);
    paramContext = new ReportDialog(paramContext, 2131755823);
    paramContext.setContentView(2131559015);
    Object localObject2 = (TextView)paramContext.findViewById(2131365479);
    FrameLayout localFrameLayout = (FrameLayout)paramContext.findViewById(2131365480);
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
      localObject1 = (TextView)paramContext.findViewById(2131365464);
      if (localObject1 != null)
      {
        ((TextView)localObject1).setText(str2);
        ((TextView)localObject1).setContentDescription(str2);
        ((TextView)localObject1).setOnClickListener(paramOnClickListener1);
        if (paramBoolean1) {
          ((TextView)localObject1).getPaint().setFakeBoldText(true);
        }
      }
      paramOnClickListener1 = (TextView)paramContext.findViewById(2131365470);
      if (paramOnClickListener1 != null)
      {
        paramOnClickListener1.setText(str1);
        paramOnClickListener1.setContentDescription(str1);
        paramOnClickListener1.setOnClickListener(paramOnClickListener2);
        if (paramBoolean2) {
          paramOnClickListener1.getPaint().setFakeBoldText(true);
        }
      }
      localFrameLayout.addView(parambgmd.a(localFrameLayout.getContext(), paramObject));
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
    paramContext = new ReportDialog(paramContext, 2131755823);
    paramContext.setContentView(2131558985);
    Object localObject2 = (TextView)paramContext.findViewById(2131365479);
    TextView localTextView = (TextView)paramContext.findViewById(2131365475);
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
      paramString = (TextView)paramContext.findViewById(2131365464);
      if (paramString != null)
      {
        paramString.setText(str2);
        paramString.setContentDescription(str2);
        paramString.setOnClickListener(paramOnClickListener1);
        if (paramBoolean1) {
          paramString.getPaint().setFakeBoldText(true);
        }
      }
      paramString = (TextView)paramContext.findViewById(2131365470);
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
    paramContext = new ReportDialog(paramContext, 2131755823);
    paramContext.setContentView(2131559021);
    ImageView localImageView = (ImageView)paramContext.findViewById(2131368138);
    TextView localTextView1 = (TextView)paramContext.findViewById(2131378776);
    TextView localTextView2 = (TextView)paramContext.findViewById(2131364999);
    TextView localTextView3 = (TextView)paramContext.findViewById(2131364112);
    TextView localTextView4 = (TextView)paramContext.findViewById(2131364909);
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
    paramContext = new ReportDialog(paramContext, 2131755823);
    paramContext.setContentView(2131560894);
    ImageView localImageView = (ImageView)paramContext.findViewById(2131380223);
    TextView localTextView1 = (TextView)paramContext.findViewById(2131380224);
    TextView localTextView2 = (TextView)paramContext.findViewById(2131380225);
    TextView localTextView3 = (TextView)paramContext.findViewById(2131380219);
    TextView localTextView4 = (TextView)paramContext.findViewById(2131380220);
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
    paramContext = new ReportDialog(paramContext, 2131755823);
    paramContext.setContentView(2131559029);
    ImageView localImageView = (ImageView)paramContext.findViewById(2131380223);
    TextView localTextView1 = (TextView)paramContext.findViewById(2131365479);
    TextView localTextView2 = (TextView)paramContext.findViewById(2131380224);
    TextView localTextView3 = (TextView)paramContext.findViewById(2131380225);
    TextView localTextView4 = (TextView)paramContext.findViewById(2131380219);
    TextView localTextView5 = (TextView)paramContext.findViewById(2131380220);
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
    paramContext = new ReportDialog(paramContext, 2131755823);
    paramContext.getWindow().setWindowAnimations(2131755129);
    paramContext.setContentView(2131561111);
    ((TextView)paramContext.findViewById(2131365514)).setVisibility(8);
    TextView localTextView1 = (TextView)paramContext.findViewById(2131365502);
    TextView localTextView2 = (TextView)paramContext.findViewById(2131365500);
    TextView localTextView3 = (TextView)paramContext.findViewById(2131365506);
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
  
  public static Dialog a(Context paramContext, String paramString, CharSequence paramCharSequence, int paramInt1, int paramInt2, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, bhva parambhva)
  {
    paramContext = new ReportDialog(paramContext, 2131755823);
    paramContext.setContentView(2131561111);
    TextView localTextView3 = (TextView)paramContext.findViewById(2131365514);
    ClickableColorSpanTextView localClickableColorSpanTextView = (ClickableColorSpanTextView)paramContext.findViewById(2131365502);
    TextView localTextView1 = (TextView)paramContext.findViewById(2131365500);
    TextView localTextView2 = (TextView)paramContext.findViewById(2131365506);
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
      paramString = new bglq(paramOnClickListener1, paramContext, paramOnClickListener2);
      localTextView1.setOnClickListener(paramString);
      localTextView2.setOnClickListener(paramString);
      localClickableColorSpanTextView.setSpanClickListener(parambhva);
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
    return a(paramContext, paramContext.getResources().getDrawable(2130849596), paramInt);
  }
  
  public static ProgressDialog a(Context paramContext, Drawable paramDrawable, int paramInt)
  {
    return a(paramContext, paramDrawable, paramInt, 0);
  }
  
  public static ProgressDialog a(Context paramContext, Drawable paramDrawable, int paramInt1, int paramInt2)
  {
    int i = paramInt2;
    if (paramInt2 <= 0) {
      i = 2131755823;
    }
    paramContext = new ReportProgressDialog(paramContext, i);
    try
    {
      paramContext.show();
      label26:
      paramContext.getWindow().setContentView(2131558434);
      paramContext.setContentView(2131558434);
      ((TextView)paramContext.findViewById(2131365475)).setText(paramInt1);
      ((ProgressBar)paramContext.findViewById(2131366957)).setIndeterminateDrawable(paramDrawable);
      return paramContext;
    }
    catch (Exception localException)
    {
      break label26;
    }
  }
  
  public static bgdl a(Activity paramActivity, String paramString1, long paramLong, String paramString2, CharSequence paramCharSequence)
  {
    paramActivity = new bgdl(paramActivity);
    paramActivity.a(new bdnt(a(paramString1), 3)).b(new bdnt(a(paramString2), 3)).a(paramLong).c(paramCharSequence);
    paramActivity.setCanceledOnTouchOutside(false);
    paramActivity.setCancelable(true);
    return paramActivity;
  }
  
  public static bgor a(Context paramContext, String paramString, Bundle paramBundle)
  {
    bgor localbgor = new bgor(paramContext, 2131755823);
    localbgor.a(paramContext, paramBundle);
    localbgor.setTitle(paramString);
    localbgor.setCanceledOnTouchOutside(false);
    localbgor.setCancelable(true);
    return localbgor;
  }
  
  public static bgor a(Context paramContext, String paramString, Bundle paramBundle, int paramInt)
  {
    bgor localbgor = new bgor(paramContext, 2131755823);
    localbgor.a(paramContext, paramBundle);
    localbgor.setTitle(paramString);
    localbgor.setCanceledOnTouchOutside(false);
    localbgor.setCancelable(true);
    if (paramInt > 0) {
      localbgor.c(paramInt);
    }
    return localbgor;
  }
  
  public static bgov a(Context paramContext, String paramString, Bundle paramBundle)
  {
    bgov localbgov = new bgov(paramContext, 2131755823);
    localbgov.a(paramContext, paramBundle);
    localbgov.setTitle(paramString);
    localbgov.setCanceledOnTouchOutside(true);
    localbgov.setCancelable(true);
    return localbgov;
  }
  
  public static bgoz a(Context paramContext, bguh parambguh, DialogInterface.OnClickListener paramOnClickListener)
  {
    if ((parambguh == null) || (parambguh.a() <= 0)) {
      return null;
    }
    paramContext = new bgoz(paramContext, 2131755823);
    paramContext.setCanceledOnTouchOutside(true);
    paramContext.setContentView(2131559009);
    paramContext.a(parambguh, paramOnClickListener);
    paramContext.a(2131558999);
    ((LinearLayout)paramContext.findViewById(2131363680)).setLayoutParams(new RelativeLayout.LayoutParams(-1, 0));
    parambguh = (ListView)paramContext.findViewById(2131369914);
    paramOnClickListener = new RelativeLayout.LayoutParams(-1, -2);
    paramOnClickListener.addRule(3, 2131365479);
    parambguh.setLayoutParams(paramOnClickListener);
    return paramContext;
  }
  
  public static bgpa a(Activity paramActivity)
  {
    bgpa localbgpa = a(paramActivity, 230);
    localbgpa.setTitle(anni.a(2131702054));
    localbgpa.setMessage(2131693416);
    localbgpa.setNegativeButton(anni.a(2131702085), new bgls(localbgpa));
    localbgpa.setPositiveButton(anni.a(2131713620), new bglt(paramActivity));
    localbgpa.setOnCancelListener(null);
    localbgpa.show();
    return localbgpa;
  }
  
  public static bgpa a(Activity paramActivity, int paramInt)
  {
    return a(paramActivity, paramActivity.getString(paramInt), 2131690582, 2131694081, null, null);
  }
  
  public static bgpa a(Activity paramActivity, int paramInt1, int paramInt2)
  {
    bgpa localbgpa = a(paramActivity, 230);
    localbgpa.setTitle(paramActivity.getString(paramInt2));
    localbgpa.setMessage(paramInt1);
    localbgpa.setNegativeButton(paramActivity.getString(2131690582), new bglu(localbgpa));
    localbgpa.setPositiveButton(paramActivity.getString(2131717832), new bglv(paramActivity));
    localbgpa.setOnCancelListener(null);
    localbgpa.show();
    return localbgpa;
  }
  
  public static bgpa a(Activity paramActivity, bcpg parambcpg)
  {
    parambcpg = new bgly(paramActivity, parambcpg);
    paramActivity = a(paramActivity, 230);
    paramActivity.setTitle(anni.a(2131708974));
    paramActivity.setMessage(anni.a(2131706711));
    paramActivity.setNegativeButton(anni.a(2131702085), parambcpg);
    paramActivity.setPositiveButton(anni.a(2131702069), parambcpg);
    paramActivity.show();
    return paramActivity;
  }
  
  public static bgpa a(Activity paramActivity, String paramString)
  {
    return a(paramActivity, paramString, 2131690582, 2131694081, null, null);
  }
  
  public static bgpa a(Activity paramActivity, String paramString, int paramInt1, int paramInt2, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramString = a(paramActivity, 230, null, paramString, paramInt1, paramInt2, paramOnClickListener1, paramOnClickListener2);
    if (paramString != null)
    {
      ((TextView)paramString.findViewById(2131365453)).setVisibility(8);
      ((TextView)paramString.findViewById(2131365475)).setMinHeight(bggq.a(paramActivity, 35.0F));
    }
    return paramString;
  }
  
  public static bgpa a(Activity paramActivity, String paramString1, long paramLong, String paramString2, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    bgpa localbgpa = new bgpa(paramActivity, 2131755823);
    localbgpa.setContentView(2131559009);
    localbgpa.setTitle(paramString1);
    paramActivity = paramActivity.getLayoutInflater().inflate(2131558893, null);
    paramString1 = (TextView)paramActivity.findViewById(2131380131);
    String str = bgdl.a((float)paramLong, true, 2);
    if (!TextUtils.isEmpty(str)) {
      paramString1.setText(anni.a(2131702073) + str);
    }
    ((TextView)paramActivity.findViewById(2131365475)).setText(paramString2);
    localbgpa.addView(paramActivity);
    localbgpa.setNegativeButton(anni.a(2131702049), paramOnClickListener1);
    localbgpa.setPositiveButton(anni.a(2131702098), paramOnClickListener2);
    localbgpa.setCanceledOnTouchOutside(false);
    return localbgpa;
  }
  
  public static bgpa a(Activity paramActivity, String paramString1, String paramString2)
  {
    bgmb localbgmb = new bgmb(paramActivity);
    bgpa localbgpa = a(paramActivity, 230);
    if (paramString1 != null)
    {
      paramActivity = paramString1;
      if (!paramString1.equals("")) {}
    }
    else
    {
      paramActivity = anni.a(2131702058);
    }
    localbgpa.setTitle(paramActivity);
    if (paramString2 != null)
    {
      paramActivity = paramString2;
      if (!paramString2.equals("")) {}
    }
    else
    {
      paramActivity = anni.a(2131702110);
    }
    localbgpa.setMessage(paramActivity);
    localbgpa.setPositiveButton(anni.a(2131702113), localbgmb);
    localbgpa.show();
    return localbgpa;
  }
  
  public static bgpa a(Activity paramActivity, String paramString1, String paramString2, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    bgpa localbgpa = a(paramActivity, 230);
    if (paramString1 != null)
    {
      paramActivity = paramString1;
      if (!paramString1.equals("")) {}
    }
    else
    {
      paramActivity = anni.a(2131702054);
    }
    localbgpa.setTitle(paramActivity);
    if (paramString2 != null)
    {
      paramActivity = paramString2;
      if (!paramString2.equals("")) {}
    }
    else
    {
      paramActivity = anni.a(2131702092);
    }
    localbgpa.setMessage(paramActivity);
    localbgpa.setNegativeButton(anni.a(2131702085), paramOnClickListener1);
    localbgpa.setPositiveButton(anni.a(2131702069), paramOnClickListener2);
    localbgpa.setOnCancelListener(paramOnCancelListener);
    localbgpa.show();
    return localbgpa;
  }
  
  public static bgpa a(Activity paramActivity, String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener)
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
  
  public static bgpa a(Activity paramActivity, String[] paramArrayOfString, int[] paramArrayOfInt)
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
  
  public static bgpa a(Context paramContext, int paramInt)
  {
    return a(paramContext, paramInt, null, null, 2131690582, 2131694081, null, null);
  }
  
  public static bgpa a(Context paramContext, int paramInt1, int paramInt2, String paramString, CharSequence paramCharSequence, int paramInt3, int paramInt4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new bgpa(paramContext, 2131755823);
    paramContext.setContentView(paramInt2);
    paramContext.setTitle(paramString);
    paramContext.setMessageWithoutAutoLink(paramCharSequence);
    paramContext.setNegativeButton(paramInt3, paramOnClickListener2);
    paramContext.setPositiveButton(paramInt4, paramOnClickListener1);
    paramContext.setCanceledOnTouchOutside(true);
    return paramContext;
  }
  
  public static bgpa a(Context paramContext, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new bgpa(paramContext, 2131755823);
    paramContext.setContentView(paramInt2);
    paramContext.setTitle(paramString1);
    paramContext.setMessage(paramString2);
    paramContext.setNegativeButton(paramString3, paramOnClickListener2);
    paramContext.setPositiveButton(paramString4, paramOnClickListener1);
    paramContext.setCanceledOnTouchOutside(false);
    return paramContext;
  }
  
  public static bgpa a(Context paramContext, int paramInt1, String paramString, CharSequence paramCharSequence, int paramInt2, int paramInt3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    return a(paramContext, paramInt1, 2131559009, paramString, paramCharSequence, paramInt2, paramInt3, paramOnClickListener1, paramOnClickListener2);
  }
  
  public static bgpa a(Context paramContext, int paramInt, String paramString1, CharSequence paramCharSequence, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new bgpa(paramContext, 2131755823);
    paramContext.setContentView(2131559009);
    paramContext.setTitle(paramString1);
    paramContext.setMessage(paramCharSequence);
    paramContext.setNegativeButton(paramString2, paramOnClickListener2);
    paramContext.setPositiveButton(paramString3, paramOnClickListener1);
    paramContext.setCanceledOnTouchOutside(false);
    return paramContext;
  }
  
  public static bgpa a(Context paramContext, int paramInt, String paramString1, CharSequence paramCharSequence, String paramString2, String paramString3, String paramString4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    return a(paramContext, paramInt, paramString1, paramCharSequence, paramString2, paramString3, paramString4, paramOnClickListener1, paramOnClickListener2, null);
  }
  
  public static bgpa a(Context paramContext, int paramInt, String paramString1, CharSequence paramCharSequence, String paramString2, String paramString3, String paramString4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnClickListener paramOnClickListener3)
  {
    bgpa localbgpa = new bgpa(paramContext, 2131755823);
    localbgpa.setContentView(2131559014);
    if (paramInt != 0) {
      localbgpa.setOperateImage(paramContext.getResources().getDrawable(paramInt));
    }
    for (;;)
    {
      localbgpa.setMessage(paramCharSequence);
      localbgpa.setNegativeButton(paramString2, paramOnClickListener1);
      localbgpa.setPositiveButton(paramString3, paramOnClickListener2);
      localbgpa.setCanceledOnTouchOutside(false);
      paramString1 = (TextView)localbgpa.findViewById(2131365455);
      paramContext = paramString4;
      if (paramString4 == null) {
        paramContext = anni.a(2131702089);
      }
      paramString1.setText(paramContext);
      if (paramOnClickListener3 == null) {
        break;
      }
      paramString1.setOnClickListener(new bglz(paramOnClickListener3, localbgpa));
      return localbgpa;
      localbgpa.setTitle(paramString1);
    }
    paramString1.setOnClickListener(new bgma(localbgpa));
    return localbgpa;
  }
  
  public static bgpa a(Context paramContext, int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new bgpa(paramContext, 2131755823);
    paramContext.setContentView(2131559009);
    paramContext.setTitle(paramString1);
    paramContext.setMessage(paramString2);
    paramContext.setNegativeButton(paramInt2, paramOnClickListener2);
    paramContext.setPositiveButton(paramInt3, paramOnClickListener1);
    paramContext.setCanceledOnTouchOutside(false);
    return paramContext;
  }
  
  public static bgpa a(Context paramContext, int paramInt, String paramString1, String paramString2, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    return a(paramContext, paramInt, paramString1, paramString2, 2131690582, 2131694081, paramOnClickListener1, paramOnClickListener2);
  }
  
  public static bgpa a(Context paramContext, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt2, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new bgpa(paramContext, 2131755823);
    paramContext.setContentView(2131559009);
    paramContext.setTitle(paramString1);
    paramContext.setMessage(paramString2);
    paramContext.setNegativeButton(paramString3, paramOnClickListener2);
    paramContext.setPositiveButton(paramString4, paramInt2, paramOnClickListener1);
    paramContext.setCanceledOnTouchOutside(false);
    return paramContext;
  }
  
  public static bgpa a(Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new bgpa(paramContext, 2131755823);
    paramContext.setContentView(2131559009);
    paramContext.setTitle(paramString1);
    paramContext.setMessage(paramString2);
    paramContext.setNegativeButton(paramString3, paramOnClickListener2);
    paramContext.setPositiveButton(paramString4, paramOnClickListener1);
    paramContext.setCanceledOnTouchOutside(false);
    paramString1 = (TextView)paramContext.findViewById(2131365453);
    paramString1 = (TextView)paramContext.findViewById(2131365475);
    paramString2 = new LinearLayout.LayoutParams(-2, -2);
    paramString2.gravity = 17;
    paramString1.setLayoutParams(paramString2);
    return paramContext;
  }
  
  public static bgpa a(Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnClickListener paramOnClickListener3)
  {
    paramContext = new bgpa(paramContext, 2131755823);
    paramContext.setContentView(2131558993);
    paramContext.setTitle(paramString1);
    paramContext.setMessage(paramString2);
    paramContext.setNegativeButton(paramString4, paramOnClickListener3);
    paramContext.setPositiveButton(paramString5, paramOnClickListener2);
    paramContext.setCanceledOnTouchOutside(false);
    paramContext.setCheckBox(paramString3, paramOnClickListener1);
    return paramContext;
  }
  
  public static bgpa a(Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3, boolean paramBoolean, String paramString4, String paramString5, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnClickListener paramOnClickListener3)
  {
    paramContext = a(paramContext, paramInt, paramString1, paramString2, paramString4, paramString5, paramOnClickListener2, paramOnClickListener3);
    paramContext.setCheckBox(paramString3, paramBoolean, paramOnClickListener1);
    return paramContext;
  }
  
  public static bgpa a(Context paramContext, String paramString1, String paramString2, DialogInterface.OnClickListener paramOnClickListener)
  {
    paramContext = new bgpa(paramContext, 2131755823);
    paramContext.setContentView(2131559006);
    paramContext.setTitle(paramString1);
    paramContext.setNegativeButton(paramString2, paramOnClickListener);
    paramContext.setCanceledOnTouchOutside(false);
    return paramContext;
  }
  
  public static bgpa a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = a(paramContext, 230, paramString1, paramString2, paramInt1, paramInt2, paramOnClickListener1, paramOnClickListener2);
    paramContext.setEditLint(paramString3);
    return paramContext;
  }
  
  public static bgpa a(Context paramContext, String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener1, String paramString4, DialogInterface.OnClickListener paramOnClickListener2, View.OnClickListener paramOnClickListener)
  {
    paramContext = new bgpa(paramContext, 2131755823);
    paramContext.setContentView(2131558987);
    TextView localTextView1 = (TextView)paramContext.findViewById(2131365479);
    TextView localTextView2 = (TextView)paramContext.findViewById(2131365475);
    ImageView localImageView = (ImageView)paramContext.findViewById(2131364539);
    localTextView1.setText(paramString1);
    localTextView2.setText(paramString2);
    paramContext.setNegativeButton(paramString3, paramOnClickListener1);
    paramContext.setPositiveButton(paramString4, paramOnClickListener2);
    localImageView.setOnClickListener(paramOnClickListener);
    paramContext.setCanceledOnTouchOutside(false);
    paramContext.setCancelable(false);
    return paramContext;
  }
  
  public static bgpa a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new bgpa(paramContext, 2131755823);
    paramContext.setContentView(2131558996);
    paramContext.setTitleWithEmo(new bdnt(a(paramString1), 3));
    paramContext.setMessage(new bdnt(a(paramString2), 3));
    paramContext.setNegativeButton(paramString3, paramOnClickListener2);
    paramContext.setPositiveButton(paramString4, paramOnClickListener1);
    if ((paramString5 != null) && (!"".equals(paramString5))) {
      paramContext.setCheckBox(paramString5, null);
    }
    paramContext.setCanceledOnTouchOutside(false);
    return paramContext;
  }
  
  public static bgpp a(Context paramContext, int paramInt)
  {
    return a(paramContext, paramInt, null, null, "", "", "", null, null, null);
  }
  
  public static bgpp a(Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnClickListener paramOnClickListener3)
  {
    paramContext = new bgpp(paramContext, 2131755823);
    paramContext.setContentView(2131559012);
    paramContext.a(paramString1);
    paramContext.b(paramString2);
    paramContext.a(paramString4, paramOnClickListener1);
    paramContext.b(paramString5, paramOnClickListener2);
    paramContext.b(paramString4, paramOnClickListener3);
    paramContext.setCanceledOnTouchOutside(true);
    return paramContext;
  }
  
  public static bgpw a(Context paramContext, String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new bgpw(paramContext, 2131755823);
    paramContext.setContentView(2131559020);
    paramContext.setTitle(paramString1);
    paramContext.setMessage(paramString2);
    paramContext.setCanceledOnTouchOutside(false);
    paramContext.setCancelable(true);
    paramContext.b(paramString3);
    paramContext.setNegativeButton(2131690582, paramOnClickListener2);
    paramContext.setPositiveButton(2131690671, paramOnClickListener1);
    paramContext.show();
    return paramContext;
  }
  
  public static bgpw a(Context paramContext, String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, int paramInt)
  {
    return a(paramContext, paramString1, paramString2, paramString3, paramOnClickListener1, paramOnClickListener2, paramInt, false);
  }
  
  public static bgpw a(Context paramContext, String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, int paramInt, boolean paramBoolean)
  {
    paramContext = new bgpw(paramContext, 2131755823);
    paramContext.b(7);
    paramContext.a(paramBoolean);
    paramContext.setContentView(2131559020);
    paramContext.setTitle(paramString1);
    if (paramInt != 0) {
      paramContext.c(paramInt);
    }
    paramContext.setMessage(paramString2);
    paramContext.setCanceledOnTouchOutside(false);
    paramContext.setCancelable(true);
    paramContext.b(paramString3);
    paramContext.setNegativeButton(2131690582, paramOnClickListener2);
    paramContext.setPositiveButton(2131690671, paramOnClickListener1);
    paramContext.show();
    return paramContext;
  }
  
  public static bgql a(Context paramContext, int paramInt1, int paramInt2, String paramString, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new bgql(paramContext, 2131755823);
    paramContext.setContentView(2131559023);
    paramContext.setTitle(paramInt1);
    paramContext.setMessage(paramInt2);
    paramContext.setCanceledOnTouchOutside(false);
    paramContext.setCancelable(true);
    paramContext.a(paramString);
    paramContext.setNegativeButton(2131690582, paramOnClickListener2);
    paramContext.setPositiveButton(2131694081, paramOnClickListener1);
    paramContext.show();
    return paramContext;
  }
  
  public static bgql a(Context paramContext, int paramInt1, int paramInt2, String paramString, TextWatcher paramTextWatcher, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new bgql(paramContext, 2131755823);
    paramContext.setContentView(2131559023);
    paramContext.setTitle(paramInt1);
    paramContext.setMessage(paramInt2);
    paramContext.setCanceledOnTouchOutside(false);
    paramContext.setCancelable(true);
    paramContext.a(paramTextWatcher);
    paramContext.a(paramString);
    paramContext.setNegativeButton(2131690582, paramOnClickListener2);
    paramContext.setPositiveButton(2131694081, paramOnClickListener1);
    paramContext.show();
    return paramContext;
  }
  
  public static bgqn a(Context paramContext, String paramString1, String paramString2, String paramString3, ArrayList<String> paramArrayList, String paramString4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, int paramInt, boolean paramBoolean)
  {
    paramContext = new bgqn(paramContext, 2131755823);
    paramContext.a(paramBoolean);
    paramContext.setContentView(2131559025);
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
    paramContext.setNegativeButton(2131690582, paramOnClickListener2);
    paramContext.setPositiveButton(2131690671, paramOnClickListener1);
    paramContext.show();
    return paramContext;
  }
  
  public static bgqu a(Context paramContext, String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener1, String paramString4, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new bgqu(paramContext, 2131755823);
    paramContext.setContentView(2131559011);
    paramContext.a(paramString1.replace(anni.a(2131702104), bdol.b(21)).replace(anni.a(2131702048), bdol.b(18)).replace(anni.a(2131702087), bdol.b(86)).replace(anni.a(2131702106), bdol.b(55)).replace("\\U0001f60f", String.valueOf(Character.toChars(128527))).replace("\\U0001f60c", String.valueOf(Character.toChars(128524))));
    paramContext.a(paramString2.replace(anni.a(2131702086), bdol.b(21)).replace(anni.a(2131702075), bdol.b(18)).replace(anni.a(2131702094), bdol.b(86)).replace(anni.a(2131702101), bdol.b(55)).replace("\\U0001f60f", String.valueOf(Character.toChars(128527))).replace("\\U0001f60c", String.valueOf(Character.toChars(128524))), 2.0F);
    paramContext.a(2130839570, 2131690582, paramOnClickListener2);
    paramContext.a(paramString3.replace(anni.a(2131702053), bdol.b(21)).replace(anni.a(2131702105), bdol.b(18)).replace(anni.a(2131702108), bdol.b(86)).replace(anni.a(2131702050), bdol.b(55)).replace("\\U0001f60f", String.valueOf(Character.toChars(128527))).replace("\\U0001f60c", String.valueOf(Character.toChars(128524))), paramOnClickListener1);
    paramContext.setCanceledOnTouchOutside(false);
    return paramContext;
  }
  
  protected static String a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      return paramString.replace(anni.a(2131702111), bdol.b(21)).replace(anni.a(2131702070), bdol.b(18)).replace(anni.a(2131702051), bdol.b(86)).replace(anni.a(2131702080), bdol.b(55)).replace("\\U0001f60f", String.valueOf(Character.toChars(128527))).replace("\\U0001f60c", String.valueOf(Character.toChars(128524)));
    }
    return null;
  }
  
  public static String a(String... paramVarArgs)
  {
    String str2 = anni.a(2131702090);
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
          str1 = anni.a(2131702057);
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
            str1 = anni.a(2131702072);
          } else if ("android.permission.ACCESS_COARSE_LOCATION".equals(str3)) {
            str1 = anni.a(2131702061);
          } else if ("android.permission.ACCESS_FINE_LOCATION".equals(str3)) {
            str1 = anni.a(2131702079);
          } else if ("android.permission.READ_CALENDAR".equals(str3)) {
            str1 = anni.a(2131702091);
          } else if ("android.permission.WRITE_CALENDAR".equals(str3)) {
            str1 = anni.a(2131702097);
          } else if ("android.permission.SEND_SMS".equals(str3)) {
            str1 = anni.a(2131702055);
          } else if ("android.permission.READ_CONTACTS".equals(str3)) {
            str1 = anni.a(2131702062);
          } else if ("android.permission.WRITE_CONTACTS".equals(str3)) {
            str1 = anni.a(2131702100);
          } else if ("android.permission.WRITE_EXTERNAL_STORAGE".equals(str3)) {
            str1 = anni.a(2131706712);
          } else if ("android.permission.READ_EXTERNAL_STORAGE".equals(str3)) {
            str1 = anni.a(2131706710);
          }
        }
      }
      str1 = localStringBuilder.toString();
    }
    return String.format(str2, new Object[] { str1 });
  }
  
  public static bgpa b(Activity paramActivity)
  {
    bglw localbglw = new bglw(paramActivity);
    paramActivity = a(paramActivity, 230);
    paramActivity.setTitle(anni.a(2131708974));
    paramActivity.setMessage(anni.a(2131706711));
    paramActivity.setNegativeButton(anni.a(2131702085), localbglw);
    paramActivity.setPositiveButton(anni.a(2131702069), localbglw);
    paramActivity.show();
    return paramActivity;
  }
  
  public static bgpa b(Activity paramActivity, String paramString)
  {
    bglx localbglx = new bglx(paramActivity);
    paramActivity = a(paramActivity, 230);
    paramActivity.setTitle(anni.a(2131708974));
    paramActivity.setMessage(paramString);
    paramActivity.setNegativeButton(anni.a(2131702085), localbglx);
    paramActivity.setPositiveButton(anni.a(2131702069), localbglx);
    paramActivity.show();
    return paramActivity;
  }
  
  public static bgpa b(Activity paramActivity, String paramString1, String paramString2)
  {
    bglr localbglr = new bglr(paramActivity);
    return a(paramActivity, paramString1, paramString2, localbglr, localbglr, null);
  }
  
  public static bgpa b(Activity paramActivity, String paramString1, String paramString2, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    bgpa localbgpa = a(paramActivity, 230);
    String str;
    if (paramString1 != null)
    {
      str = paramString1;
      if (!paramString1.equals("")) {}
    }
    else
    {
      str = paramActivity.getResources().getString(2131694798);
    }
    localbgpa.setTitle(str);
    if (paramString2 != null)
    {
      paramString1 = paramString2;
      if (!paramString2.equals("")) {}
    }
    else
    {
      paramString1 = paramActivity.getResources().getString(2131694795);
    }
    localbgpa.setMessage(paramString1);
    localbgpa.setNegativeButton(paramActivity.getResources().getString(2131690582), paramOnClickListener1);
    localbgpa.setPositiveButton(paramActivity.getResources().getString(2131694081), paramOnClickListener2);
    localbgpa.setOnCancelListener(paramOnCancelListener);
    localbgpa.show();
    return localbgpa;
  }
  
  public static bgpa b(Context paramContext, int paramInt)
  {
    return b(paramContext, paramInt, null, null, 2131690582, 2131694081, null, null);
  }
  
  public static bgpa b(Context paramContext, int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new bgpa(paramContext, 2131755823);
    paramContext.setContentView(2131559009);
    paramContext.setTitle(paramString1);
    paramContext.setMessageWithUrl(paramString2);
    paramContext.setNegativeButton(paramInt2, paramOnClickListener2);
    paramContext.setPositiveButton(paramInt3, paramOnClickListener1);
    paramContext.setCanceledOnTouchOutside(true);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bglp
 * JD-Core Version:    0.7.0.1
 */