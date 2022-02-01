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
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.QQCustomArkDialog;
import com.tencent.mobileqq.utils.QQCustomArkDialogForAio;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.QQCustomDialogThreeBtns;
import com.tencent.mobileqq.utils.QQCustomDialogWtihEmoticonInput;
import com.tencent.mobileqq.utils.QQCustomDialogWtihInput;
import com.tencent.mobileqq.utils.QQCustomDialogWtihInputAndChoose;
import com.tencent.mobileqq.widget.ClickableColorSpanTextView;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportProgressDialog;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.HashMap;

public class bhdj
{
  public static final HashMap<String, String> a = new HashMap();
  
  static
  {
    a.put("android.permission.READ_EXTERNAL_STORAGE", anvx.a(2131702759));
    a.put("android.permission.WRITE_EXTERNAL_STORAGE", anvx.a(2131702774));
    a.put("android.permission.READ_PHONE_STATE", "QQ使用电话权限确定本机号码和设备ID，以保证帐号登录的安全性。QQ不会拨打其他号码或终止通话。\n" + anvx.a(2131702745));
    a.put("android.permission.CAMERA", anvx.a(2131702786));
    a.put("android.permission.RECORD_AUDIO", anvx.a(2131702757));
    a.put("android.permission.ACCESS_COARSE_LOCATION", anvx.a(2131702752));
    a.put("android.permission.ACCESS_FINE_LOCATION", anvx.a(2131702758));
    a.put("android.permission.READ_CALENDAR", anvx.a(2131702802));
    a.put("android.permission.WRITE_CALENDAR", anvx.a(2131702800));
    a.put("android.permission.SEND_SMS", anvx.a(2131702788));
    a.put("android.permission.READ_CONTACTS", anvx.a(2131702777));
    a.put("android.permission.WRITE_CONTACTS", anvx.a(2131702795));
  }
  
  public static Dialog a(Activity paramActivity, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2)
  {
    paramActivity = bgys.a(paramActivity, 2131698071, 2131698069, 2131698068, 2131698070, paramOnClickListener1, paramOnClickListener2);
    paramActivity.setCancelable(false);
    return paramActivity;
  }
  
  public static Dialog a(Context paramContext, int paramInt1, bhdy parambhdy, Object paramObject, int paramInt2, int paramInt3, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject1 = paramContext.getResources();
    String str2 = ((Resources)localObject1).getString(paramInt2);
    String str1 = ((Resources)localObject1).getString(paramInt3);
    paramContext = new ReportDialog(paramContext, 2131755829);
    paramContext.setContentView(2131559050);
    Object localObject2 = (TextView)paramContext.findViewById(2131365648);
    FrameLayout localFrameLayout = (FrameLayout)paramContext.findViewById(2131365649);
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
      localObject1 = (TextView)paramContext.findViewById(2131365633);
      if (localObject1 != null)
      {
        ((TextView)localObject1).setText(str2);
        ((TextView)localObject1).setContentDescription(str2);
        ((TextView)localObject1).setOnClickListener(paramOnClickListener1);
        if (paramBoolean1) {
          ((TextView)localObject1).getPaint().setFakeBoldText(true);
        }
      }
      paramOnClickListener1 = (TextView)paramContext.findViewById(2131365639);
      if (paramOnClickListener1 != null)
      {
        paramOnClickListener1.setText(str1);
        paramOnClickListener1.setContentDescription(str1);
        paramOnClickListener1.setOnClickListener(paramOnClickListener2);
        if (paramBoolean2) {
          paramOnClickListener1.getPaint().setFakeBoldText(true);
        }
      }
      localFrameLayout.addView(parambhdy.a(localFrameLayout.getContext(), paramObject));
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
    paramContext = new ReportDialog(paramContext, 2131755829);
    paramContext.setContentView(2131559019);
    Object localObject2 = (TextView)paramContext.findViewById(2131365648);
    TextView localTextView = (TextView)paramContext.findViewById(2131365644);
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
      paramString = (TextView)paramContext.findViewById(2131365633);
      if (paramString != null)
      {
        paramString.setText(str2);
        paramString.setContentDescription(str2);
        paramString.setOnClickListener(paramOnClickListener1);
        if (paramBoolean1) {
          paramString.getPaint().setFakeBoldText(true);
        }
      }
      paramString = (TextView)paramContext.findViewById(2131365639);
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
    paramContext = new ReportDialog(paramContext, 2131755829);
    paramContext.setContentView(2131559056);
    ImageView localImageView = (ImageView)paramContext.findViewById(2131368381);
    TextView localTextView1 = (TextView)paramContext.findViewById(2131379001);
    TextView localTextView2 = (TextView)paramContext.findViewById(2131365157);
    TextView localTextView3 = (TextView)paramContext.findViewById(2131364250);
    TextView localTextView4 = (TextView)paramContext.findViewById(2131365067);
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
    paramContext = new ReportDialog(paramContext, 2131755829);
    paramContext.setContentView(2131560865);
    ImageView localImageView = (ImageView)paramContext.findViewById(2131380468);
    TextView localTextView1 = (TextView)paramContext.findViewById(2131380469);
    TextView localTextView2 = (TextView)paramContext.findViewById(2131380470);
    TextView localTextView3 = (TextView)paramContext.findViewById(2131380464);
    TextView localTextView4 = (TextView)paramContext.findViewById(2131380465);
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
    paramContext = new ReportDialog(paramContext, 2131755829);
    paramContext.setContentView(2131559064);
    ImageView localImageView = (ImageView)paramContext.findViewById(2131380468);
    TextView localTextView1 = (TextView)paramContext.findViewById(2131365648);
    TextView localTextView2 = (TextView)paramContext.findViewById(2131380469);
    TextView localTextView3 = (TextView)paramContext.findViewById(2131380470);
    TextView localTextView4 = (TextView)paramContext.findViewById(2131380464);
    TextView localTextView5 = (TextView)paramContext.findViewById(2131380465);
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
    paramContext = new ReportDialog(paramContext, 2131755829);
    paramContext.getWindow().setWindowAnimations(2131755130);
    paramContext.setContentView(2131561082);
    ((TextView)paramContext.findViewById(2131365682)).setVisibility(8);
    TextView localTextView1 = (TextView)paramContext.findViewById(2131365669);
    TextView localTextView2 = (TextView)paramContext.findViewById(2131365667);
    TextView localTextView3 = (TextView)paramContext.findViewById(2131365673);
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
  
  public static Dialog a(Context paramContext, String paramString, CharSequence paramCharSequence, int paramInt1, int paramInt2, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, bimp parambimp)
  {
    paramContext = new ReportDialog(paramContext, 2131755829);
    paramContext.setContentView(2131561082);
    TextView localTextView3 = (TextView)paramContext.findViewById(2131365682);
    ClickableColorSpanTextView localClickableColorSpanTextView = (ClickableColorSpanTextView)paramContext.findViewById(2131365669);
    TextView localTextView1 = (TextView)paramContext.findViewById(2131365667);
    TextView localTextView2 = (TextView)paramContext.findViewById(2131365673);
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
      paramString = new bhdu(paramOnClickListener1, paramContext, paramOnClickListener2);
      localTextView1.setOnClickListener(paramString);
      localTextView2.setOnClickListener(paramString);
      localClickableColorSpanTextView.setSpanClickListener(parambimp);
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
    return a(paramContext, paramContext.getResources().getDrawable(2130849611), paramInt);
  }
  
  public static ProgressDialog a(Context paramContext, Drawable paramDrawable, int paramInt)
  {
    return a(paramContext, paramDrawable, paramInt, 0);
  }
  
  public static ProgressDialog a(Context paramContext, Drawable paramDrawable, int paramInt1, int paramInt2)
  {
    int i = paramInt2;
    if (paramInt2 <= 0) {
      i = 2131755829;
    }
    paramContext = new ReportProgressDialog(paramContext, i);
    try
    {
      paramContext.show();
      label26:
      paramContext.getWindow().setContentView(2131558435);
      paramContext.setContentView(2131558435);
      ((TextView)paramContext.findViewById(2131365644)).setText(paramInt1);
      ((ProgressBar)paramContext.findViewById(2131367140)).setIndeterminateDrawable(paramDrawable);
      return paramContext;
    }
    catch (Exception localException)
    {
      break label26;
    }
  }
  
  public static bgvp a(Activity paramActivity, String paramString1, long paramLong, String paramString2, CharSequence paramCharSequence)
  {
    paramActivity = new bgvp(paramActivity);
    paramActivity.a(new QQText(a(paramString1), 3)).b(new QQText(a(paramString2), 3)).a(paramLong).c(paramCharSequence);
    paramActivity.setCanceledOnTouchOutside(false);
    paramActivity.setCancelable(true);
    return paramActivity;
  }
  
  public static bhgi a(Context paramContext, bhjq parambhjq, DialogInterface.OnClickListener paramOnClickListener)
  {
    if ((parambhjq == null) || (parambhjq.a() <= 0)) {
      return null;
    }
    paramContext = new bhgi(paramContext, 2131755829);
    paramContext.setCanceledOnTouchOutside(true);
    paramContext.setContentView(2131559043);
    paramContext.a(parambhjq, paramOnClickListener);
    paramContext.a(2131559033);
    ((LinearLayout)paramContext.findViewById(2131363805)).setLayoutParams(new RelativeLayout.LayoutParams(-1, 0));
    parambhjq = (ListView)paramContext.findViewById(2131370180);
    paramOnClickListener = new RelativeLayout.LayoutParams(-1, -2);
    paramOnClickListener.addRule(3, 2131365648);
    parambhjq.setLayoutParams(paramOnClickListener);
    return paramContext;
  }
  
  public static bhgj a(Context paramContext, String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener1, String paramString4, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new bhgj(paramContext, 2131755829);
    paramContext.setContentView(2131559045);
    paramContext.a(paramString1.replace(anvx.a(2131702797), com.tencent.mobileqq.text.TextUtils.getSysEmotcationString(21)).replace(anvx.a(2131702741), com.tencent.mobileqq.text.TextUtils.getSysEmotcationString(18)).replace(anvx.a(2131702780), com.tencent.mobileqq.text.TextUtils.getSysEmotcationString(86)).replace(anvx.a(2131702799), com.tencent.mobileqq.text.TextUtils.getSysEmotcationString(55)).replace("\\U0001f60f", String.valueOf(Character.toChars(128527))).replace("\\U0001f60c", String.valueOf(Character.toChars(128524))));
    paramContext.a(paramString2.replace(anvx.a(2131702779), com.tencent.mobileqq.text.TextUtils.getSysEmotcationString(21)).replace(anvx.a(2131702768), com.tencent.mobileqq.text.TextUtils.getSysEmotcationString(18)).replace(anvx.a(2131702787), com.tencent.mobileqq.text.TextUtils.getSysEmotcationString(86)).replace(anvx.a(2131702794), com.tencent.mobileqq.text.TextUtils.getSysEmotcationString(55)).replace("\\U0001f60f", String.valueOf(Character.toChars(128527))).replace("\\U0001f60c", String.valueOf(Character.toChars(128524))), 2.0F);
    paramContext.a(2130839635, 2131690697, paramOnClickListener2);
    paramContext.a(paramString3.replace(anvx.a(2131702746), com.tencent.mobileqq.text.TextUtils.getSysEmotcationString(21)).replace(anvx.a(2131702798), com.tencent.mobileqq.text.TextUtils.getSysEmotcationString(18)).replace(anvx.a(2131702801), com.tencent.mobileqq.text.TextUtils.getSysEmotcationString(86)).replace(anvx.a(2131702743), com.tencent.mobileqq.text.TextUtils.getSysEmotcationString(55)).replace("\\U0001f60f", String.valueOf(Character.toChars(128527))).replace("\\U0001f60c", String.valueOf(Character.toChars(128524))), paramOnClickListener1);
    paramContext.setCanceledOnTouchOutside(false);
    return paramContext;
  }
  
  public static QQCustomArkDialog a(Context paramContext, String paramString, Bundle paramBundle)
  {
    QQCustomArkDialog localQQCustomArkDialog = new QQCustomArkDialog(paramContext, 2131755829);
    localQQCustomArkDialog.initArkView(paramContext, paramBundle);
    localQQCustomArkDialog.setTitle(paramString);
    localQQCustomArkDialog.setCanceledOnTouchOutside(false);
    localQQCustomArkDialog.setCancelable(true);
    return localQQCustomArkDialog;
  }
  
  public static QQCustomArkDialog a(Context paramContext, String paramString, Bundle paramBundle, int paramInt)
  {
    QQCustomArkDialog localQQCustomArkDialog = new QQCustomArkDialog(paramContext, 2131755829);
    localQQCustomArkDialog.initArkView(paramContext, paramBundle);
    localQQCustomArkDialog.setTitle(paramString);
    localQQCustomArkDialog.setCanceledOnTouchOutside(false);
    localQQCustomArkDialog.setCancelable(true);
    if (paramInt > 0) {
      localQQCustomArkDialog.setMaxLength(paramInt);
    }
    return localQQCustomArkDialog;
  }
  
  public static QQCustomArkDialogForAio a(Context paramContext, String paramString, Bundle paramBundle)
  {
    QQCustomArkDialogForAio localQQCustomArkDialogForAio = new QQCustomArkDialogForAio(paramContext, 2131755829);
    localQQCustomArkDialogForAio.initArkView(paramContext, paramBundle);
    localQQCustomArkDialogForAio.setTitle(paramString);
    localQQCustomArkDialogForAio.setCanceledOnTouchOutside(true);
    localQQCustomArkDialogForAio.setCancelable(true);
    return localQQCustomArkDialogForAio;
  }
  
  public static QQCustomDialog a(Activity paramActivity)
  {
    QQCustomDialog localQQCustomDialog = a(paramActivity, 230);
    localQQCustomDialog.setTitle(anvx.a(2131702747));
    localQQCustomDialog.setMessage(2131693704);
    localQQCustomDialog.setNegativeButton(anvx.a(2131702778), new bhdn(localQQCustomDialog));
    localQQCustomDialog.setPositiveButton(anvx.a(2131714308), new bhdo(paramActivity));
    localQQCustomDialog.setOnCancelListener(null);
    localQQCustomDialog.show();
    return localQQCustomDialog;
  }
  
  public static QQCustomDialog a(Activity paramActivity, int paramInt)
  {
    return a(paramActivity, paramActivity.getString(paramInt), 2131690697, 2131694399, null, null);
  }
  
  public static QQCustomDialog a(Activity paramActivity, int paramInt1, int paramInt2)
  {
    QQCustomDialog localQQCustomDialog = a(paramActivity, 230);
    localQQCustomDialog.setTitle(paramActivity.getString(paramInt2));
    localQQCustomDialog.setMessage(paramInt1);
    localQQCustomDialog.setNegativeButton(paramActivity.getString(2131690697), new bhdp(localQQCustomDialog));
    localQQCustomDialog.setPositiveButton(paramActivity.getString(2131718591), new bhdq(paramActivity));
    localQQCustomDialog.setOnCancelListener(null);
    localQQCustomDialog.show();
    return localQQCustomDialog;
  }
  
  public static QQCustomDialog a(Activity paramActivity, bdhi parambdhi)
  {
    parambdhi = new bhdt(paramActivity, parambdhi);
    paramActivity = a(paramActivity, 230);
    paramActivity.setTitle(anvx.a(2131709662));
    paramActivity.setMessage(anvx.a(2131707399));
    paramActivity.setNegativeButton(anvx.a(2131702778), parambdhi);
    paramActivity.setPositiveButton(anvx.a(2131702762), parambdhi);
    paramActivity.show();
    return paramActivity;
  }
  
  public static QQCustomDialog a(Activity paramActivity, String paramString)
  {
    return a(paramActivity, paramString, 2131690697, 2131694399, null, null);
  }
  
  public static QQCustomDialog a(Activity paramActivity, String paramString, int paramInt1, int paramInt2, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramString = a(paramActivity, 230, null, paramString, paramInt1, paramInt2, paramOnClickListener1, paramOnClickListener2);
    if (paramString != null)
    {
      ((TextView)paramString.findViewById(2131365621)).setVisibility(8);
      ((TextView)paramString.findViewById(2131365644)).setMinHeight(DisplayUtil.dip2px(paramActivity, 35.0F));
    }
    return paramString;
  }
  
  public static QQCustomDialog a(Activity paramActivity, String paramString1, long paramLong, String paramString2, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    QQCustomDialog localQQCustomDialog = new QQCustomDialog(paramActivity, 2131755829);
    localQQCustomDialog.setContentView(2131559043);
    localQQCustomDialog.setTitle(paramString1);
    paramActivity = paramActivity.getLayoutInflater().inflate(2131558926, null);
    paramString1 = (TextView)paramActivity.findViewById(2131380377);
    String str = bgvp.a((float)paramLong, true, 2);
    if (!android.text.TextUtils.isEmpty(str)) {
      paramString1.setText(anvx.a(2131702766) + str);
    }
    ((TextView)paramActivity.findViewById(2131365644)).setText(paramString2);
    localQQCustomDialog.addView(paramActivity);
    localQQCustomDialog.setNegativeButton(anvx.a(2131702742), paramOnClickListener1);
    localQQCustomDialog.setPositiveButton(anvx.a(2131702791), paramOnClickListener2);
    localQQCustomDialog.setCanceledOnTouchOutside(false);
    return localQQCustomDialog;
  }
  
  public static QQCustomDialog a(Activity paramActivity, String paramString1, String paramString2)
  {
    bhdl localbhdl = new bhdl(paramActivity);
    QQCustomDialog localQQCustomDialog = a(paramActivity, 230);
    if (paramString1 != null)
    {
      paramActivity = paramString1;
      if (!paramString1.equals("")) {}
    }
    else
    {
      paramActivity = anvx.a(2131702751);
    }
    localQQCustomDialog.setTitle(paramActivity);
    if (paramString2 != null)
    {
      paramActivity = paramString2;
      if (!paramString2.equals("")) {}
    }
    else
    {
      paramActivity = anvx.a(2131702803);
    }
    localQQCustomDialog.setMessage(paramActivity);
    localQQCustomDialog.setPositiveButton(anvx.a(2131702806), localbhdl);
    localQQCustomDialog.show();
    return localQQCustomDialog;
  }
  
  public static QQCustomDialog a(Activity paramActivity, String paramString1, String paramString2, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    QQCustomDialog localQQCustomDialog = a(paramActivity, 230);
    if (paramString1 != null)
    {
      paramActivity = paramString1;
      if (!paramString1.equals("")) {}
    }
    else
    {
      paramActivity = anvx.a(2131702747);
    }
    localQQCustomDialog.setTitle(paramActivity);
    if (paramString2 != null)
    {
      paramActivity = paramString2;
      if (!paramString2.equals("")) {}
    }
    else
    {
      paramActivity = anvx.a(2131702785);
    }
    localQQCustomDialog.setMessage(paramActivity);
    localQQCustomDialog.setNegativeButton(anvx.a(2131702778), paramOnClickListener1);
    localQQCustomDialog.setPositiveButton(anvx.a(2131702762), paramOnClickListener2);
    localQQCustomDialog.setOnCancelListener(paramOnCancelListener);
    localQQCustomDialog.show();
    return localQQCustomDialog;
  }
  
  public static QQCustomDialog a(Activity paramActivity, String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener)
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
  
  public static QQCustomDialog a(Activity paramActivity, String[] paramArrayOfString, int[] paramArrayOfInt)
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
  
  public static QQCustomDialog a(Context paramContext)
  {
    bhdr localbhdr = new bhdr(paramContext);
    paramContext = a(paramContext, 230);
    paramContext.setTitle(anvx.a(2131709662));
    paramContext.setMessage(anvx.a(2131707399));
    paramContext.setNegativeButton(anvx.a(2131702778), localbhdr);
    paramContext.setPositiveButton(anvx.a(2131702762), localbhdr);
    paramContext.show();
    return paramContext;
  }
  
  public static QQCustomDialog a(Context paramContext, int paramInt)
  {
    return a(paramContext, paramInt, null, null, 2131690697, 2131694399, null, null);
  }
  
  public static QQCustomDialog a(Context paramContext, int paramInt1, int paramInt2, String paramString, CharSequence paramCharSequence, int paramInt3, int paramInt4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new QQCustomDialog(paramContext, 2131755829);
    paramContext.setContentView(paramInt2);
    paramContext.setTitle(paramString);
    paramContext.setMessageWithoutAutoLink(paramCharSequence);
    paramContext.setNegativeButton(paramInt3, paramOnClickListener2);
    paramContext.setPositiveButton(paramInt4, paramOnClickListener1);
    paramContext.setCanceledOnTouchOutside(true);
    return paramContext;
  }
  
  public static QQCustomDialog a(Context paramContext, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new QQCustomDialog(paramContext, 2131755829);
    paramContext.setContentView(paramInt2);
    paramContext.setTitle(paramString1);
    paramContext.setMessage(paramString2);
    paramContext.setNegativeButton(paramString3, paramOnClickListener2);
    paramContext.setPositiveButton(paramString4, paramOnClickListener1);
    paramContext.setCanceledOnTouchOutside(false);
    return paramContext;
  }
  
  public static QQCustomDialog a(Context paramContext, int paramInt1, String paramString, CharSequence paramCharSequence, int paramInt2, int paramInt3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    return a(paramContext, paramInt1, 2131559043, paramString, paramCharSequence, paramInt2, paramInt3, paramOnClickListener1, paramOnClickListener2);
  }
  
  public static QQCustomDialog a(Context paramContext, int paramInt, String paramString1, CharSequence paramCharSequence, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new QQCustomDialog(paramContext, 2131755829);
    paramContext.setContentView(2131559043);
    paramContext.setTitle(paramString1);
    paramContext.setMessage(paramCharSequence);
    paramContext.setNegativeButton(paramString2, paramOnClickListener2);
    paramContext.setPositiveButton(paramString3, paramOnClickListener1);
    paramContext.setCanceledOnTouchOutside(false);
    return paramContext;
  }
  
  public static QQCustomDialog a(Context paramContext, int paramInt, String paramString1, CharSequence paramCharSequence, String paramString2, String paramString3, String paramString4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    return a(paramContext, paramInt, paramString1, paramCharSequence, paramString2, paramString3, paramString4, paramOnClickListener1, paramOnClickListener2, null);
  }
  
  public static QQCustomDialog a(Context paramContext, int paramInt, String paramString1, CharSequence paramCharSequence, String paramString2, String paramString3, String paramString4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnClickListener paramOnClickListener3)
  {
    QQCustomDialog localQQCustomDialog = new QQCustomDialog(paramContext, 2131755829);
    localQQCustomDialog.setContentView(2131559049);
    if (paramInt != 0) {
      localQQCustomDialog.setOperateImage(paramContext.getResources().getDrawable(paramInt));
    }
    for (;;)
    {
      localQQCustomDialog.setMessage(paramCharSequence);
      localQQCustomDialog.setNegativeButton(paramString2, paramOnClickListener1);
      localQQCustomDialog.setPositiveButton(paramString3, paramOnClickListener2);
      localQQCustomDialog.setCanceledOnTouchOutside(false);
      paramString1 = (TextView)localQQCustomDialog.findViewById(2131365623);
      paramContext = paramString4;
      if (paramString4 == null) {
        paramContext = anvx.a(2131702782);
      }
      paramString1.setText(paramContext);
      if (paramOnClickListener3 == null) {
        break;
      }
      paramString1.setOnClickListener(new bhdv(paramOnClickListener3, localQQCustomDialog));
      return localQQCustomDialog;
      localQQCustomDialog.setTitle(paramString1);
    }
    paramString1.setOnClickListener(new bhdw(localQQCustomDialog));
    return localQQCustomDialog;
  }
  
  public static QQCustomDialog a(Context paramContext, int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new QQCustomDialog(paramContext, 2131755829);
    paramContext.setContentView(2131559043);
    paramContext.setTitle(paramString1);
    paramContext.setMessage(paramString2);
    paramContext.setNegativeButton(paramInt2, paramOnClickListener2);
    paramContext.setPositiveButton(paramInt3, paramOnClickListener1);
    paramContext.setCanceledOnTouchOutside(false);
    return paramContext;
  }
  
  public static QQCustomDialog a(Context paramContext, int paramInt, String paramString1, String paramString2, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    return a(paramContext, paramInt, paramString1, paramString2, 2131690697, 2131694399, paramOnClickListener1, paramOnClickListener2);
  }
  
  public static QQCustomDialog a(Context paramContext, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt2, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new QQCustomDialog(paramContext, 2131755829);
    paramContext.setContentView(2131559043);
    paramContext.setTitle(paramString1);
    paramContext.setMessage(paramString2);
    paramContext.setNegativeButton(paramString3, paramOnClickListener2);
    paramContext.setPositiveButton(paramString4, paramInt2, paramOnClickListener1);
    paramContext.setCanceledOnTouchOutside(false);
    return paramContext;
  }
  
  public static QQCustomDialog a(Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new QQCustomDialog(paramContext, 2131755829);
    paramContext.setContentView(2131559043);
    paramContext.setTitle(paramString1);
    paramContext.setMessage(paramString2);
    paramContext.setNegativeButton(paramString3, paramOnClickListener2);
    paramContext.setPositiveButton(paramString4, paramOnClickListener1);
    paramContext.setCanceledOnTouchOutside(false);
    paramString1 = (TextView)paramContext.findViewById(2131365621);
    paramString1 = (TextView)paramContext.findViewById(2131365644);
    paramString2 = new LinearLayout.LayoutParams(-2, -2);
    paramString2.gravity = 17;
    paramString1.setLayoutParams(paramString2);
    return paramContext;
  }
  
  public static QQCustomDialog a(Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnClickListener paramOnClickListener3)
  {
    paramContext = new QQCustomDialog(paramContext, 2131755829);
    paramContext.setContentView(2131559027);
    paramContext.setTitle(paramString1);
    paramContext.setMessage(paramString2);
    paramContext.setNegativeButton(paramString4, paramOnClickListener3);
    paramContext.setPositiveButton(paramString5, paramOnClickListener2);
    paramContext.setCanceledOnTouchOutside(false);
    paramContext.setCheckBox(paramString3, paramOnClickListener1);
    return paramContext;
  }
  
  public static QQCustomDialog a(Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3, boolean paramBoolean, String paramString4, String paramString5, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnClickListener paramOnClickListener3)
  {
    paramContext = a(paramContext, paramInt, paramString1, paramString2, paramString4, paramString5, paramOnClickListener2, paramOnClickListener3);
    paramContext.setCheckBox(paramString3, paramBoolean, paramOnClickListener1);
    return paramContext;
  }
  
  public static QQCustomDialog a(Context paramContext, String paramString)
  {
    bhds localbhds = new bhds(paramContext);
    paramContext = a(paramContext, 230);
    paramContext.setTitle(anvx.a(2131709662));
    paramContext.setMessage(paramString);
    paramContext.setNegativeButton(anvx.a(2131702778), localbhds);
    paramContext.setPositiveButton(anvx.a(2131702762), localbhds);
    paramContext.show();
    return paramContext;
  }
  
  public static QQCustomDialog a(Context paramContext, String paramString1, CharSequence paramCharSequence, String paramString2, String paramString3, boolean paramBoolean, int paramInt, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2)
  {
    bhdk localbhdk = new bhdk(paramContext, 2131755829, paramInt, paramBoolean, paramString2);
    localbhdk.setContentView(2131559043);
    localbhdk.setCanceledOnTouchOutside(false);
    localbhdk.setTitle(paramString1);
    localbhdk.setMessage(paramCharSequence);
    localbhdk.title.setTypeface(Typeface.DEFAULT_BOLD);
    localbhdk.rBtn.setTypeface(Typeface.DEFAULT_BOLD);
    localbhdk.lBtn.setTypeface(Typeface.DEFAULT_BOLD);
    localbhdk.lBtn.setTextColor(paramContext.getResources().getColorStateList(2131165580));
    localbhdk.lBtn.setText(paramString2);
    localbhdk.lBtn.setVisibility(0);
    localbhdk.lBtn.setOnClickListener(paramOnClickListener1);
    localbhdk.rBtn.setVisibility(0);
    localbhdk.rBtn.setText(paramString3);
    localbhdk.rBtn.setOnClickListener(paramOnClickListener2);
    return localbhdk;
  }
  
  public static QQCustomDialog a(Context paramContext, String paramString1, String paramString2, DialogInterface.OnClickListener paramOnClickListener)
  {
    paramContext = new QQCustomDialog(paramContext, 2131755829);
    paramContext.setContentView(2131559040);
    paramContext.setTitle(paramString1);
    paramContext.setNegativeButton(paramString2, paramOnClickListener);
    paramContext.setCanceledOnTouchOutside(false);
    return paramContext;
  }
  
  public static QQCustomDialog a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = a(paramContext, 230, paramString1, paramString2, paramInt1, paramInt2, paramOnClickListener1, paramOnClickListener2);
    paramContext.setEditLint(paramString3);
    return paramContext;
  }
  
  public static QQCustomDialog a(Context paramContext, String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener1, String paramString4, DialogInterface.OnClickListener paramOnClickListener2, View.OnClickListener paramOnClickListener)
  {
    paramContext = new QQCustomDialog(paramContext, 2131755829);
    paramContext.setContentView(2131559021);
    TextView localTextView1 = (TextView)paramContext.findViewById(2131365648);
    TextView localTextView2 = (TextView)paramContext.findViewById(2131365644);
    ImageView localImageView = (ImageView)paramContext.findViewById(2131364699);
    localTextView1.setText(paramString1);
    localTextView2.setText(paramString2);
    paramContext.setNegativeButton(paramString3, paramOnClickListener1);
    paramContext.setPositiveButton(paramString4, paramOnClickListener2);
    localImageView.setOnClickListener(paramOnClickListener);
    paramContext.setCanceledOnTouchOutside(false);
    paramContext.setCancelable(false);
    return paramContext;
  }
  
  public static QQCustomDialog a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new QQCustomDialog(paramContext, 2131755829);
    paramContext.setContentView(2131559030);
    paramContext.setTitleWithEmo(new QQText(a(paramString1), 3));
    paramContext.setMessage(new QQText(a(paramString2), 3));
    paramContext.setNegativeButton(paramString3, paramOnClickListener2);
    paramContext.setPositiveButton(paramString4, paramOnClickListener1);
    if ((paramString5 != null) && (!"".equals(paramString5))) {
      paramContext.setCheckBox(paramString5, null);
    }
    paramContext.setCanceledOnTouchOutside(false);
    return paramContext;
  }
  
  public static QQCustomDialogThreeBtns a(Context paramContext, int paramInt)
  {
    return a(paramContext, paramInt, null, null, "", "", "", null, null, null);
  }
  
  public static QQCustomDialogThreeBtns a(Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnClickListener paramOnClickListener3)
  {
    paramContext = new QQCustomDialogThreeBtns(paramContext, 2131755829);
    paramContext.setContentView(2131559046);
    paramContext.setTitle(paramString1);
    paramContext.setMessage(paramString2);
    paramContext.setLeftButton(paramString4, paramOnClickListener1);
    paramContext.setMiddleButton(paramString5, paramOnClickListener2);
    paramContext.setMiddleButton(paramString4, paramOnClickListener3);
    paramContext.setCanceledOnTouchOutside(true);
    return paramContext;
  }
  
  public static QQCustomDialogWtihEmoticonInput a(Context paramContext, String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new QQCustomDialogWtihEmoticonInput(paramContext, 2131755829);
    paramContext.setContentView(2131559055);
    paramContext.setTitle(paramString1);
    paramContext.setMessage(paramString2);
    paramContext.setCanceledOnTouchOutside(false);
    paramContext.setCancelable(true);
    paramContext.setInitInputValue(paramString3);
    paramContext.setNegativeButton(2131690697, paramOnClickListener2);
    paramContext.setPositiveButton(2131690786, paramOnClickListener1);
    paramContext.show();
    return paramContext;
  }
  
  public static QQCustomDialogWtihEmoticonInput a(Context paramContext, String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, int paramInt)
  {
    return a(paramContext, paramString1, paramString2, paramString3, paramOnClickListener1, paramOnClickListener2, paramInt, false);
  }
  
  public static QQCustomDialogWtihEmoticonInput a(Context paramContext, String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, int paramInt, boolean paramBoolean)
  {
    paramContext = new QQCustomDialogWtihEmoticonInput(paramContext, 2131755829);
    paramContext.setEmoticonType(7);
    paramContext.setSingleLine(paramBoolean);
    paramContext.setContentView(2131559055);
    paramContext.setTitle(paramString1);
    if (paramInt != 0) {
      paramContext.setMaxLength(paramInt);
    }
    paramContext.setMessage(paramString2);
    paramContext.setCanceledOnTouchOutside(false);
    paramContext.setCancelable(true);
    paramContext.setInitInputValue(paramString3);
    paramContext.setNegativeButton(2131690697, paramOnClickListener2);
    paramContext.setPositiveButton(2131690786, paramOnClickListener1);
    paramContext.show();
    return paramContext;
  }
  
  public static QQCustomDialogWtihInput a(Context paramContext, int paramInt1, int paramInt2, String paramString, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new QQCustomDialogWtihInput(paramContext, 2131755829);
    paramContext.setContentView(2131559058);
    paramContext.setTitle(paramInt1);
    paramContext.setMessage(paramInt2);
    paramContext.setCanceledOnTouchOutside(false);
    paramContext.setCancelable(true);
    paramContext.setInitInputValue(paramString);
    paramContext.setNegativeButton(2131690697, paramOnClickListener2);
    paramContext.setPositiveButton(2131694399, paramOnClickListener1);
    paramContext.show();
    return paramContext;
  }
  
  public static QQCustomDialogWtihInput a(Context paramContext, int paramInt1, int paramInt2, String paramString, TextWatcher paramTextWatcher, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new QQCustomDialogWtihInput(paramContext, 2131755829);
    paramContext.setContentView(2131559058);
    paramContext.setTitle(paramInt1);
    paramContext.setMessage(paramInt2);
    paramContext.setCanceledOnTouchOutside(false);
    paramContext.setCancelable(true);
    paramContext.setTextWatcher(paramTextWatcher);
    paramContext.setInitInputValue(paramString);
    paramContext.setNegativeButton(2131690697, paramOnClickListener2);
    paramContext.setPositiveButton(2131694399, paramOnClickListener1);
    paramContext.show();
    return paramContext;
  }
  
  public static QQCustomDialogWtihInputAndChoose a(Context paramContext, String paramString1, String paramString2, String paramString3, ArrayList<String> paramArrayList, String paramString4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, int paramInt, boolean paramBoolean)
  {
    paramContext = new QQCustomDialogWtihInputAndChoose(paramContext, 2131755829);
    paramContext.setSingleLine(paramBoolean);
    paramContext.setContentView(2131559060);
    paramContext.setTitle(paramString1);
    if (paramInt != 0) {
      paramContext.setMaxLength(paramInt);
    }
    paramContext.setMessage(paramString2);
    paramContext.setMessageCount(paramString3);
    paramContext.setChooseList(paramArrayList);
    paramContext.setCanceledOnTouchOutside(false);
    paramContext.setCancelable(true);
    paramContext.setInputValue(paramString4);
    paramContext.setNegativeButton(2131690697, paramOnClickListener2);
    paramContext.setPositiveButton(2131690786, paramOnClickListener1);
    paramContext.show();
    return paramContext;
  }
  
  protected static String a(String paramString)
  {
    if (!android.text.TextUtils.isEmpty(paramString)) {
      return paramString.replace(anvx.a(2131702804), com.tencent.mobileqq.text.TextUtils.getSysEmotcationString(21)).replace(anvx.a(2131702763), com.tencent.mobileqq.text.TextUtils.getSysEmotcationString(18)).replace(anvx.a(2131702744), com.tencent.mobileqq.text.TextUtils.getSysEmotcationString(86)).replace(anvx.a(2131702773), com.tencent.mobileqq.text.TextUtils.getSysEmotcationString(55)).replace("\\U0001f60f", String.valueOf(Character.toChars(128527))).replace("\\U0001f60c", String.valueOf(Character.toChars(128524)));
    }
    return null;
  }
  
  public static String a(String... paramVarArgs)
  {
    String str2 = anvx.a(2131702783);
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
          str1 = anvx.a(2131702750);
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
            str1 = anvx.a(2131702765);
          } else if ("android.permission.ACCESS_COARSE_LOCATION".equals(str3)) {
            str1 = anvx.a(2131702754);
          } else if ("android.permission.ACCESS_FINE_LOCATION".equals(str3)) {
            str1 = anvx.a(2131702772);
          } else if ("android.permission.READ_CALENDAR".equals(str3)) {
            str1 = anvx.a(2131702784);
          } else if ("android.permission.WRITE_CALENDAR".equals(str3)) {
            str1 = anvx.a(2131702790);
          } else if ("android.permission.SEND_SMS".equals(str3)) {
            str1 = anvx.a(2131702748);
          } else if ("android.permission.READ_CONTACTS".equals(str3)) {
            str1 = anvx.a(2131702755);
          } else if ("android.permission.WRITE_CONTACTS".equals(str3)) {
            str1 = anvx.a(2131702793);
          } else if ("android.permission.WRITE_EXTERNAL_STORAGE".equals(str3)) {
            str1 = anvx.a(2131707400);
          } else if ("android.permission.READ_EXTERNAL_STORAGE".equals(str3)) {
            str1 = anvx.a(2131707398);
          }
        }
      }
      str1 = localStringBuilder.toString();
    }
    return String.format(str2, new Object[] { str1 });
  }
  
  public static QQCustomDialog b(Activity paramActivity, String paramString1, String paramString2)
  {
    bhdm localbhdm = new bhdm(paramActivity);
    return a(paramActivity, paramString1, paramString2, localbhdm, localbhdm, null);
  }
  
  public static QQCustomDialog b(Activity paramActivity, String paramString1, String paramString2, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    QQCustomDialog localQQCustomDialog = a(paramActivity, 230);
    String str;
    if (paramString1 != null)
    {
      str = paramString1;
      if (!paramString1.equals("")) {}
    }
    else
    {
      str = paramActivity.getResources().getString(2131695194);
    }
    localQQCustomDialog.setTitle(str);
    if (paramString2 != null)
    {
      paramString1 = paramString2;
      if (!paramString2.equals("")) {}
    }
    else
    {
      paramString1 = paramActivity.getResources().getString(2131695191);
    }
    localQQCustomDialog.setMessage(paramString1);
    localQQCustomDialog.setNegativeButton(paramActivity.getResources().getString(2131690697), paramOnClickListener1);
    localQQCustomDialog.setPositiveButton(paramActivity.getResources().getString(2131694399), paramOnClickListener2);
    localQQCustomDialog.setOnCancelListener(paramOnCancelListener);
    localQQCustomDialog.show();
    return localQQCustomDialog;
  }
  
  public static QQCustomDialog b(Context paramContext, int paramInt)
  {
    return b(paramContext, paramInt, null, null, 2131690697, 2131694399, null, null);
  }
  
  public static QQCustomDialog b(Context paramContext, int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new QQCustomDialog(paramContext, 2131755829);
    paramContext.setContentView(2131559043);
    paramContext.setTitle(paramString1);
    paramContext.setMessageWithUrl(paramString2);
    paramContext.setNegativeButton(paramInt2, paramOnClickListener2);
    paramContext.setPositiveButton(paramInt3, paramOnClickListener1);
    paramContext.setCanceledOnTouchOutside(true);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bhdj
 * JD-Core Version:    0.7.0.1
 */