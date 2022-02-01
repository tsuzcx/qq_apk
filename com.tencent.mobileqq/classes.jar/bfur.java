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

public class bfur
{
  public static final HashMap<String, String> a = new HashMap();
  
  static
  {
    a.put("android.permission.READ_EXTERNAL_STORAGE", amtj.a(2131702408));
    a.put("android.permission.WRITE_EXTERNAL_STORAGE", amtj.a(2131702423));
    a.put("android.permission.READ_PHONE_STATE", "QQ使用电话权限确定本机号码和设备ID，以保证帐号登录的安全性。QQ不会拨打其他号码或终止通话。\n" + amtj.a(2131702394));
    a.put("android.permission.CAMERA", amtj.a(2131702435));
    a.put("android.permission.RECORD_AUDIO", amtj.a(2131702406));
    a.put("android.permission.ACCESS_COARSE_LOCATION", amtj.a(2131702401));
    a.put("android.permission.ACCESS_FINE_LOCATION", amtj.a(2131702407));
    a.put("android.permission.READ_CALENDAR", amtj.a(2131702451));
    a.put("android.permission.WRITE_CALENDAR", amtj.a(2131702449));
    a.put("android.permission.SEND_SMS", amtj.a(2131702437));
    a.put("android.permission.READ_CONTACTS", amtj.a(2131702426));
    a.put("android.permission.WRITE_CONTACTS", amtj.a(2131702444));
  }
  
  public static Dialog a(Activity paramActivity, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2)
  {
    paramActivity = bfqb.a(paramActivity, 2131697788, 2131697786, 2131697785, 2131697787, paramOnClickListener1, paramOnClickListener2);
    paramActivity.setCancelable(false);
    return paramActivity;
  }
  
  public static Dialog a(Context paramContext, int paramInt1, bfvg parambfvg, Object paramObject, int paramInt2, int paramInt3, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject1 = paramContext.getResources();
    String str2 = ((Resources)localObject1).getString(paramInt2);
    String str1 = ((Resources)localObject1).getString(paramInt3);
    paramContext = new ReportDialog(paramContext, 2131755826);
    paramContext.setContentView(2131559022);
    Object localObject2 = (TextView)paramContext.findViewById(2131365556);
    FrameLayout localFrameLayout = (FrameLayout)paramContext.findViewById(2131365557);
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
      localObject1 = (TextView)paramContext.findViewById(2131365541);
      if (localObject1 != null)
      {
        ((TextView)localObject1).setText(str2);
        ((TextView)localObject1).setContentDescription(str2);
        ((TextView)localObject1).setOnClickListener(paramOnClickListener1);
        if (paramBoolean1) {
          ((TextView)localObject1).getPaint().setFakeBoldText(true);
        }
      }
      paramOnClickListener1 = (TextView)paramContext.findViewById(2131365547);
      if (paramOnClickListener1 != null)
      {
        paramOnClickListener1.setText(str1);
        paramOnClickListener1.setContentDescription(str1);
        paramOnClickListener1.setOnClickListener(paramOnClickListener2);
        if (paramBoolean2) {
          paramOnClickListener1.getPaint().setFakeBoldText(true);
        }
      }
      localFrameLayout.addView(parambfvg.a(localFrameLayout.getContext(), paramObject));
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
    paramContext = new ReportDialog(paramContext, 2131755826);
    paramContext.setContentView(2131558992);
    Object localObject2 = (TextView)paramContext.findViewById(2131365556);
    TextView localTextView = (TextView)paramContext.findViewById(2131365552);
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
      paramString = (TextView)paramContext.findViewById(2131365541);
      if (paramString != null)
      {
        paramString.setText(str2);
        paramString.setContentDescription(str2);
        paramString.setOnClickListener(paramOnClickListener1);
        if (paramBoolean1) {
          paramString.getPaint().setFakeBoldText(true);
        }
      }
      paramString = (TextView)paramContext.findViewById(2131365547);
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
    paramContext = new ReportDialog(paramContext, 2131755826);
    paramContext.setContentView(2131559028);
    ImageView localImageView = (ImageView)paramContext.findViewById(2131368236);
    TextView localTextView1 = (TextView)paramContext.findViewById(2131378707);
    TextView localTextView2 = (TextView)paramContext.findViewById(2131365073);
    TextView localTextView3 = (TextView)paramContext.findViewById(2131364175);
    TextView localTextView4 = (TextView)paramContext.findViewById(2131364983);
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
    paramContext = new ReportDialog(paramContext, 2131755826);
    paramContext.setContentView(2131560805);
    ImageView localImageView = (ImageView)paramContext.findViewById(2131380133);
    TextView localTextView1 = (TextView)paramContext.findViewById(2131380134);
    TextView localTextView2 = (TextView)paramContext.findViewById(2131380135);
    TextView localTextView3 = (TextView)paramContext.findViewById(2131380129);
    TextView localTextView4 = (TextView)paramContext.findViewById(2131380130);
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
    paramContext = new ReportDialog(paramContext, 2131755826);
    paramContext.setContentView(2131559036);
    ImageView localImageView = (ImageView)paramContext.findViewById(2131380133);
    TextView localTextView1 = (TextView)paramContext.findViewById(2131365556);
    TextView localTextView2 = (TextView)paramContext.findViewById(2131380134);
    TextView localTextView3 = (TextView)paramContext.findViewById(2131380135);
    TextView localTextView4 = (TextView)paramContext.findViewById(2131380129);
    TextView localTextView5 = (TextView)paramContext.findViewById(2131380130);
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
    paramContext = new ReportDialog(paramContext, 2131755826);
    paramContext.getWindow().setWindowAnimations(2131755130);
    paramContext.setContentView(2131561021);
    ((TextView)paramContext.findViewById(2131365589)).setVisibility(8);
    TextView localTextView1 = (TextView)paramContext.findViewById(2131365577);
    TextView localTextView2 = (TextView)paramContext.findViewById(2131365575);
    TextView localTextView3 = (TextView)paramContext.findViewById(2131365581);
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
  
  public static Dialog a(Context paramContext, String paramString, CharSequence paramCharSequence, int paramInt1, int paramInt2, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, bhbx parambhbx)
  {
    paramContext = new ReportDialog(paramContext, 2131755826);
    paramContext.setContentView(2131561021);
    TextView localTextView3 = (TextView)paramContext.findViewById(2131365589);
    ClickableColorSpanTextView localClickableColorSpanTextView = (ClickableColorSpanTextView)paramContext.findViewById(2131365577);
    TextView localTextView1 = (TextView)paramContext.findViewById(2131365575);
    TextView localTextView2 = (TextView)paramContext.findViewById(2131365581);
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
      paramString = new bfvc(paramOnClickListener1, paramContext, paramOnClickListener2);
      localTextView1.setOnClickListener(paramString);
      localTextView2.setOnClickListener(paramString);
      localClickableColorSpanTextView.setSpanClickListener(parambhbx);
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
    return a(paramContext, paramContext.getResources().getDrawable(2130849518), paramInt);
  }
  
  public static ProgressDialog a(Context paramContext, Drawable paramDrawable, int paramInt)
  {
    return a(paramContext, paramDrawable, paramInt, 0);
  }
  
  public static ProgressDialog a(Context paramContext, Drawable paramDrawable, int paramInt1, int paramInt2)
  {
    int i = paramInt2;
    if (paramInt2 <= 0) {
      i = 2131755826;
    }
    paramContext = new ReportProgressDialog(paramContext, i);
    try
    {
      paramContext.show();
      label26:
      paramContext.getWindow().setContentView(2131558434);
      paramContext.setContentView(2131558434);
      ((TextView)paramContext.findViewById(2131365552)).setText(paramInt1);
      ((ProgressBar)paramContext.findViewById(2131367022)).setIndeterminateDrawable(paramDrawable);
      return paramContext;
    }
    catch (Exception localException)
    {
      break label26;
    }
  }
  
  public static bfmy a(Activity paramActivity, String paramString1, long paramLong, String paramString2, CharSequence paramCharSequence)
  {
    paramActivity = new bfmy(paramActivity);
    paramActivity.a(new QQText(a(paramString1), 3)).b(new QQText(a(paramString2), 3)).a(paramLong).c(paramCharSequence);
    paramActivity.setCanceledOnTouchOutside(false);
    paramActivity.setCancelable(true);
    return paramActivity;
  }
  
  public static bfxq a(Context paramContext, bgaz parambgaz, DialogInterface.OnClickListener paramOnClickListener)
  {
    if ((parambgaz == null) || (parambgaz.a() <= 0)) {
      return null;
    }
    paramContext = new bfxq(paramContext, 2131755826);
    paramContext.setCanceledOnTouchOutside(true);
    paramContext.setContentView(2131559016);
    paramContext.a(parambgaz, paramOnClickListener);
    paramContext.a(2131559006);
    ((LinearLayout)paramContext.findViewById(2131363734)).setLayoutParams(new RelativeLayout.LayoutParams(-1, 0));
    parambgaz = (ListView)paramContext.findViewById(2131370009);
    paramOnClickListener = new RelativeLayout.LayoutParams(-1, -2);
    paramOnClickListener.addRule(3, 2131365556);
    parambgaz.setLayoutParams(paramOnClickListener);
    return paramContext;
  }
  
  public static bfxr a(Context paramContext, String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener1, String paramString4, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new bfxr(paramContext, 2131755826);
    paramContext.setContentView(2131559018);
    paramContext.a(paramString1.replace(amtj.a(2131702446), com.tencent.mobileqq.text.TextUtils.getSysEmotcationString(21)).replace(amtj.a(2131702390), com.tencent.mobileqq.text.TextUtils.getSysEmotcationString(18)).replace(amtj.a(2131702429), com.tencent.mobileqq.text.TextUtils.getSysEmotcationString(86)).replace(amtj.a(2131702448), com.tencent.mobileqq.text.TextUtils.getSysEmotcationString(55)).replace("\\U0001f60f", String.valueOf(Character.toChars(128527))).replace("\\U0001f60c", String.valueOf(Character.toChars(128524))));
    paramContext.a(paramString2.replace(amtj.a(2131702428), com.tencent.mobileqq.text.TextUtils.getSysEmotcationString(21)).replace(amtj.a(2131702417), com.tencent.mobileqq.text.TextUtils.getSysEmotcationString(18)).replace(amtj.a(2131702436), com.tencent.mobileqq.text.TextUtils.getSysEmotcationString(86)).replace(amtj.a(2131702443), com.tencent.mobileqq.text.TextUtils.getSysEmotcationString(55)).replace("\\U0001f60f", String.valueOf(Character.toChars(128527))).replace("\\U0001f60c", String.valueOf(Character.toChars(128524))), 2.0F);
    paramContext.a(2130839614, 2131690620, paramOnClickListener2);
    paramContext.a(paramString3.replace(amtj.a(2131702395), com.tencent.mobileqq.text.TextUtils.getSysEmotcationString(21)).replace(amtj.a(2131702447), com.tencent.mobileqq.text.TextUtils.getSysEmotcationString(18)).replace(amtj.a(2131702450), com.tencent.mobileqq.text.TextUtils.getSysEmotcationString(86)).replace(amtj.a(2131702392), com.tencent.mobileqq.text.TextUtils.getSysEmotcationString(55)).replace("\\U0001f60f", String.valueOf(Character.toChars(128527))).replace("\\U0001f60c", String.valueOf(Character.toChars(128524))), paramOnClickListener1);
    paramContext.setCanceledOnTouchOutside(false);
    return paramContext;
  }
  
  public static QQCustomArkDialog a(Context paramContext, String paramString, Bundle paramBundle)
  {
    QQCustomArkDialog localQQCustomArkDialog = new QQCustomArkDialog(paramContext, 2131755826);
    localQQCustomArkDialog.initArkView(paramContext, paramBundle);
    localQQCustomArkDialog.setTitle(paramString);
    localQQCustomArkDialog.setCanceledOnTouchOutside(false);
    localQQCustomArkDialog.setCancelable(true);
    return localQQCustomArkDialog;
  }
  
  public static QQCustomArkDialog a(Context paramContext, String paramString, Bundle paramBundle, int paramInt)
  {
    QQCustomArkDialog localQQCustomArkDialog = new QQCustomArkDialog(paramContext, 2131755826);
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
    QQCustomArkDialogForAio localQQCustomArkDialogForAio = new QQCustomArkDialogForAio(paramContext, 2131755826);
    localQQCustomArkDialogForAio.initArkView(paramContext, paramBundle);
    localQQCustomArkDialogForAio.setTitle(paramString);
    localQQCustomArkDialogForAio.setCanceledOnTouchOutside(true);
    localQQCustomArkDialogForAio.setCancelable(true);
    return localQQCustomArkDialogForAio;
  }
  
  public static QQCustomDialog a(Activity paramActivity)
  {
    QQCustomDialog localQQCustomDialog = a(paramActivity, 230);
    localQQCustomDialog.setTitle(amtj.a(2131702396));
    localQQCustomDialog.setMessage(2131693523);
    localQQCustomDialog.setNegativeButton(amtj.a(2131702427), new bfuv(localQQCustomDialog));
    localQQCustomDialog.setPositiveButton(amtj.a(2131713961), new bfuw(paramActivity));
    localQQCustomDialog.setOnCancelListener(null);
    localQQCustomDialog.show();
    return localQQCustomDialog;
  }
  
  public static QQCustomDialog a(Activity paramActivity, int paramInt)
  {
    return a(paramActivity, paramActivity.getString(paramInt), 2131690620, 2131694201, null, null);
  }
  
  public static QQCustomDialog a(Activity paramActivity, int paramInt1, int paramInt2)
  {
    QQCustomDialog localQQCustomDialog = a(paramActivity, 230);
    localQQCustomDialog.setTitle(paramActivity.getString(paramInt2));
    localQQCustomDialog.setMessage(paramInt1);
    localQQCustomDialog.setNegativeButton(paramActivity.getString(2131690620), new bfux(localQQCustomDialog));
    localQQCustomDialog.setPositiveButton(paramActivity.getString(2131718205), new bfuy(paramActivity));
    localQQCustomDialog.setOnCancelListener(null);
    localQQCustomDialog.show();
    return localQQCustomDialog;
  }
  
  public static QQCustomDialog a(Activity paramActivity, bcan parambcan)
  {
    parambcan = new bfvb(paramActivity, parambcan);
    paramActivity = a(paramActivity, 230);
    paramActivity.setTitle(amtj.a(2131709315));
    paramActivity.setMessage(amtj.a(2131707052));
    paramActivity.setNegativeButton(amtj.a(2131702427), parambcan);
    paramActivity.setPositiveButton(amtj.a(2131702411), parambcan);
    paramActivity.show();
    return paramActivity;
  }
  
  public static QQCustomDialog a(Activity paramActivity, String paramString)
  {
    return a(paramActivity, paramString, 2131690620, 2131694201, null, null);
  }
  
  public static QQCustomDialog a(Activity paramActivity, String paramString, int paramInt1, int paramInt2, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramString = a(paramActivity, 230, null, paramString, paramInt1, paramInt2, paramOnClickListener1, paramOnClickListener2);
    if (paramString != null)
    {
      ((TextView)paramString.findViewById(2131365529)).setVisibility(8);
      ((TextView)paramString.findViewById(2131365552)).setMinHeight(DisplayUtil.dip2px(paramActivity, 35.0F));
    }
    return paramString;
  }
  
  public static QQCustomDialog a(Activity paramActivity, String paramString1, long paramLong, String paramString2, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    QQCustomDialog localQQCustomDialog = new QQCustomDialog(paramActivity, 2131755826);
    localQQCustomDialog.setContentView(2131559016);
    localQQCustomDialog.setTitle(paramString1);
    paramActivity = paramActivity.getLayoutInflater().inflate(2131558899, null);
    paramString1 = (TextView)paramActivity.findViewById(2131380042);
    String str = bfmy.a((float)paramLong, true, 2);
    if (!android.text.TextUtils.isEmpty(str)) {
      paramString1.setText(amtj.a(2131702415) + str);
    }
    ((TextView)paramActivity.findViewById(2131365552)).setText(paramString2);
    localQQCustomDialog.addView(paramActivity);
    localQQCustomDialog.setNegativeButton(amtj.a(2131702391), paramOnClickListener1);
    localQQCustomDialog.setPositiveButton(amtj.a(2131702440), paramOnClickListener2);
    localQQCustomDialog.setCanceledOnTouchOutside(false);
    return localQQCustomDialog;
  }
  
  public static QQCustomDialog a(Activity paramActivity, String paramString1, String paramString2)
  {
    bfut localbfut = new bfut(paramActivity);
    QQCustomDialog localQQCustomDialog = a(paramActivity, 230);
    if (paramString1 != null)
    {
      paramActivity = paramString1;
      if (!paramString1.equals("")) {}
    }
    else
    {
      paramActivity = amtj.a(2131702400);
    }
    localQQCustomDialog.setTitle(paramActivity);
    if (paramString2 != null)
    {
      paramActivity = paramString2;
      if (!paramString2.equals("")) {}
    }
    else
    {
      paramActivity = amtj.a(2131702452);
    }
    localQQCustomDialog.setMessage(paramActivity);
    localQQCustomDialog.setPositiveButton(amtj.a(2131702455), localbfut);
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
      paramActivity = amtj.a(2131702396);
    }
    localQQCustomDialog.setTitle(paramActivity);
    if (paramString2 != null)
    {
      paramActivity = paramString2;
      if (!paramString2.equals("")) {}
    }
    else
    {
      paramActivity = amtj.a(2131702434);
    }
    localQQCustomDialog.setMessage(paramActivity);
    localQQCustomDialog.setNegativeButton(amtj.a(2131702427), paramOnClickListener1);
    localQQCustomDialog.setPositiveButton(amtj.a(2131702411), paramOnClickListener2);
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
    bfuz localbfuz = new bfuz(paramContext);
    paramContext = a(paramContext, 230);
    paramContext.setTitle(amtj.a(2131709315));
    paramContext.setMessage(amtj.a(2131707052));
    paramContext.setNegativeButton(amtj.a(2131702427), localbfuz);
    paramContext.setPositiveButton(amtj.a(2131702411), localbfuz);
    paramContext.show();
    return paramContext;
  }
  
  public static QQCustomDialog a(Context paramContext, int paramInt)
  {
    return a(paramContext, paramInt, null, null, 2131690620, 2131694201, null, null);
  }
  
  public static QQCustomDialog a(Context paramContext, int paramInt1, int paramInt2, String paramString, CharSequence paramCharSequence, int paramInt3, int paramInt4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new QQCustomDialog(paramContext, 2131755826);
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
    paramContext = new QQCustomDialog(paramContext, 2131755826);
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
    return a(paramContext, paramInt1, 2131559016, paramString, paramCharSequence, paramInt2, paramInt3, paramOnClickListener1, paramOnClickListener2);
  }
  
  public static QQCustomDialog a(Context paramContext, int paramInt, String paramString1, CharSequence paramCharSequence, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new QQCustomDialog(paramContext, 2131755826);
    paramContext.setContentView(2131559016);
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
    QQCustomDialog localQQCustomDialog = new QQCustomDialog(paramContext, 2131755826);
    localQQCustomDialog.setContentView(2131559021);
    if (paramInt != 0) {
      localQQCustomDialog.setOperateImage(paramContext.getResources().getDrawable(paramInt));
    }
    for (;;)
    {
      localQQCustomDialog.setMessage(paramCharSequence);
      localQQCustomDialog.setNegativeButton(paramString2, paramOnClickListener1);
      localQQCustomDialog.setPositiveButton(paramString3, paramOnClickListener2);
      localQQCustomDialog.setCanceledOnTouchOutside(false);
      paramString1 = (TextView)localQQCustomDialog.findViewById(2131365531);
      paramContext = paramString4;
      if (paramString4 == null) {
        paramContext = amtj.a(2131702431);
      }
      paramString1.setText(paramContext);
      if (paramOnClickListener3 == null) {
        break;
      }
      paramString1.setOnClickListener(new bfvd(paramOnClickListener3, localQQCustomDialog));
      return localQQCustomDialog;
      localQQCustomDialog.setTitle(paramString1);
    }
    paramString1.setOnClickListener(new bfve(localQQCustomDialog));
    return localQQCustomDialog;
  }
  
  public static QQCustomDialog a(Context paramContext, int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new QQCustomDialog(paramContext, 2131755826);
    paramContext.setContentView(2131559016);
    paramContext.setTitle(paramString1);
    paramContext.setMessage(paramString2);
    paramContext.setNegativeButton(paramInt2, paramOnClickListener2);
    paramContext.setPositiveButton(paramInt3, paramOnClickListener1);
    paramContext.setCanceledOnTouchOutside(false);
    return paramContext;
  }
  
  public static QQCustomDialog a(Context paramContext, int paramInt, String paramString1, String paramString2, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    return a(paramContext, paramInt, paramString1, paramString2, 2131690620, 2131694201, paramOnClickListener1, paramOnClickListener2);
  }
  
  public static QQCustomDialog a(Context paramContext, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt2, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new QQCustomDialog(paramContext, 2131755826);
    paramContext.setContentView(2131559016);
    paramContext.setTitle(paramString1);
    paramContext.setMessage(paramString2);
    paramContext.setNegativeButton(paramString3, paramOnClickListener2);
    paramContext.setPositiveButton(paramString4, paramInt2, paramOnClickListener1);
    paramContext.setCanceledOnTouchOutside(false);
    return paramContext;
  }
  
  public static QQCustomDialog a(Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new QQCustomDialog(paramContext, 2131755826);
    paramContext.setContentView(2131559016);
    paramContext.setTitle(paramString1);
    paramContext.setMessage(paramString2);
    paramContext.setNegativeButton(paramString3, paramOnClickListener2);
    paramContext.setPositiveButton(paramString4, paramOnClickListener1);
    paramContext.setCanceledOnTouchOutside(false);
    paramString1 = (TextView)paramContext.findViewById(2131365529);
    paramString1 = (TextView)paramContext.findViewById(2131365552);
    paramString2 = new LinearLayout.LayoutParams(-2, -2);
    paramString2.gravity = 17;
    paramString1.setLayoutParams(paramString2);
    return paramContext;
  }
  
  public static QQCustomDialog a(Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnClickListener paramOnClickListener3)
  {
    paramContext = new QQCustomDialog(paramContext, 2131755826);
    paramContext.setContentView(2131559000);
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
    bfva localbfva = new bfva(paramContext);
    paramContext = a(paramContext, 230);
    paramContext.setTitle(amtj.a(2131709315));
    paramContext.setMessage(paramString);
    paramContext.setNegativeButton(amtj.a(2131702427), localbfva);
    paramContext.setPositiveButton(amtj.a(2131702411), localbfva);
    paramContext.show();
    return paramContext;
  }
  
  public static QQCustomDialog a(Context paramContext, String paramString1, CharSequence paramCharSequence, String paramString2, String paramString3, boolean paramBoolean, int paramInt, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2)
  {
    bfus localbfus = new bfus(paramContext, 2131755826, paramInt, paramBoolean, paramString2);
    localbfus.setContentView(2131559016);
    localbfus.setCanceledOnTouchOutside(false);
    localbfus.setTitle(paramString1);
    localbfus.setMessage(paramCharSequence);
    localbfus.title.setTypeface(Typeface.DEFAULT_BOLD);
    localbfus.rBtn.setTypeface(Typeface.DEFAULT_BOLD);
    localbfus.lBtn.setTypeface(Typeface.DEFAULT_BOLD);
    localbfus.lBtn.setTextColor(paramContext.getResources().getColorStateList(2131165574));
    localbfus.lBtn.setText(paramString2);
    localbfus.lBtn.setVisibility(0);
    localbfus.lBtn.setOnClickListener(paramOnClickListener1);
    localbfus.rBtn.setVisibility(0);
    localbfus.rBtn.setText(paramString3);
    localbfus.rBtn.setOnClickListener(paramOnClickListener2);
    return localbfus;
  }
  
  public static QQCustomDialog a(Context paramContext, String paramString1, String paramString2, DialogInterface.OnClickListener paramOnClickListener)
  {
    paramContext = new QQCustomDialog(paramContext, 2131755826);
    paramContext.setContentView(2131559013);
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
    paramContext = new QQCustomDialog(paramContext, 2131755826);
    paramContext.setContentView(2131558994);
    TextView localTextView1 = (TextView)paramContext.findViewById(2131365556);
    TextView localTextView2 = (TextView)paramContext.findViewById(2131365552);
    ImageView localImageView = (ImageView)paramContext.findViewById(2131364615);
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
    paramContext = new QQCustomDialog(paramContext, 2131755826);
    paramContext.setContentView(2131559003);
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
    paramContext = new QQCustomDialogThreeBtns(paramContext, 2131755826);
    paramContext.setContentView(2131559019);
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
    paramContext = new QQCustomDialogWtihEmoticonInput(paramContext, 2131755826);
    paramContext.setContentView(2131559027);
    paramContext.setTitle(paramString1);
    paramContext.setMessage(paramString2);
    paramContext.setCanceledOnTouchOutside(false);
    paramContext.setCancelable(true);
    paramContext.setInitInputValue(paramString3);
    paramContext.setNegativeButton(2131690620, paramOnClickListener2);
    paramContext.setPositiveButton(2131690709, paramOnClickListener1);
    paramContext.show();
    return paramContext;
  }
  
  public static QQCustomDialogWtihEmoticonInput a(Context paramContext, String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, int paramInt)
  {
    return a(paramContext, paramString1, paramString2, paramString3, paramOnClickListener1, paramOnClickListener2, paramInt, false);
  }
  
  public static QQCustomDialogWtihEmoticonInput a(Context paramContext, String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, int paramInt, boolean paramBoolean)
  {
    paramContext = new QQCustomDialogWtihEmoticonInput(paramContext, 2131755826);
    paramContext.setEmoticonType(7);
    paramContext.setSingleLine(paramBoolean);
    paramContext.setContentView(2131559027);
    paramContext.setTitle(paramString1);
    if (paramInt != 0) {
      paramContext.setMaxLength(paramInt);
    }
    paramContext.setMessage(paramString2);
    paramContext.setCanceledOnTouchOutside(false);
    paramContext.setCancelable(true);
    paramContext.setInitInputValue(paramString3);
    paramContext.setNegativeButton(2131690620, paramOnClickListener2);
    paramContext.setPositiveButton(2131690709, paramOnClickListener1);
    paramContext.show();
    return paramContext;
  }
  
  public static QQCustomDialogWtihInput a(Context paramContext, int paramInt1, int paramInt2, String paramString, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new QQCustomDialogWtihInput(paramContext, 2131755826);
    paramContext.setContentView(2131559030);
    paramContext.setTitle(paramInt1);
    paramContext.setMessage(paramInt2);
    paramContext.setCanceledOnTouchOutside(false);
    paramContext.setCancelable(true);
    paramContext.setInitInputValue(paramString);
    paramContext.setNegativeButton(2131690620, paramOnClickListener2);
    paramContext.setPositiveButton(2131694201, paramOnClickListener1);
    paramContext.show();
    return paramContext;
  }
  
  public static QQCustomDialogWtihInput a(Context paramContext, int paramInt1, int paramInt2, String paramString, TextWatcher paramTextWatcher, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new QQCustomDialogWtihInput(paramContext, 2131755826);
    paramContext.setContentView(2131559030);
    paramContext.setTitle(paramInt1);
    paramContext.setMessage(paramInt2);
    paramContext.setCanceledOnTouchOutside(false);
    paramContext.setCancelable(true);
    paramContext.setTextWatcher(paramTextWatcher);
    paramContext.setInitInputValue(paramString);
    paramContext.setNegativeButton(2131690620, paramOnClickListener2);
    paramContext.setPositiveButton(2131694201, paramOnClickListener1);
    paramContext.show();
    return paramContext;
  }
  
  public static QQCustomDialogWtihInputAndChoose a(Context paramContext, String paramString1, String paramString2, String paramString3, ArrayList<String> paramArrayList, String paramString4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, int paramInt, boolean paramBoolean)
  {
    paramContext = new QQCustomDialogWtihInputAndChoose(paramContext, 2131755826);
    paramContext.setSingleLine(paramBoolean);
    paramContext.setContentView(2131559032);
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
    paramContext.setNegativeButton(2131690620, paramOnClickListener2);
    paramContext.setPositiveButton(2131690709, paramOnClickListener1);
    paramContext.show();
    return paramContext;
  }
  
  protected static String a(String paramString)
  {
    if (!android.text.TextUtils.isEmpty(paramString)) {
      return paramString.replace(amtj.a(2131702453), com.tencent.mobileqq.text.TextUtils.getSysEmotcationString(21)).replace(amtj.a(2131702412), com.tencent.mobileqq.text.TextUtils.getSysEmotcationString(18)).replace(amtj.a(2131702393), com.tencent.mobileqq.text.TextUtils.getSysEmotcationString(86)).replace(amtj.a(2131702422), com.tencent.mobileqq.text.TextUtils.getSysEmotcationString(55)).replace("\\U0001f60f", String.valueOf(Character.toChars(128527))).replace("\\U0001f60c", String.valueOf(Character.toChars(128524)));
    }
    return null;
  }
  
  public static String a(String... paramVarArgs)
  {
    String str2 = amtj.a(2131702432);
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
          str1 = amtj.a(2131702399);
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
            str1 = amtj.a(2131702414);
          } else if ("android.permission.ACCESS_COARSE_LOCATION".equals(str3)) {
            str1 = amtj.a(2131702403);
          } else if ("android.permission.ACCESS_FINE_LOCATION".equals(str3)) {
            str1 = amtj.a(2131702421);
          } else if ("android.permission.READ_CALENDAR".equals(str3)) {
            str1 = amtj.a(2131702433);
          } else if ("android.permission.WRITE_CALENDAR".equals(str3)) {
            str1 = amtj.a(2131702439);
          } else if ("android.permission.SEND_SMS".equals(str3)) {
            str1 = amtj.a(2131702397);
          } else if ("android.permission.READ_CONTACTS".equals(str3)) {
            str1 = amtj.a(2131702404);
          } else if ("android.permission.WRITE_CONTACTS".equals(str3)) {
            str1 = amtj.a(2131702442);
          } else if ("android.permission.WRITE_EXTERNAL_STORAGE".equals(str3)) {
            str1 = amtj.a(2131707053);
          } else if ("android.permission.READ_EXTERNAL_STORAGE".equals(str3)) {
            str1 = amtj.a(2131707051);
          }
        }
      }
      str1 = localStringBuilder.toString();
    }
    return String.format(str2, new Object[] { str1 });
  }
  
  public static QQCustomDialog b(Activity paramActivity, String paramString1, String paramString2)
  {
    bfuu localbfuu = new bfuu(paramActivity);
    return a(paramActivity, paramString1, paramString2, localbfuu, localbfuu, null);
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
      str = paramActivity.getResources().getString(2131694978);
    }
    localQQCustomDialog.setTitle(str);
    if (paramString2 != null)
    {
      paramString1 = paramString2;
      if (!paramString2.equals("")) {}
    }
    else
    {
      paramString1 = paramActivity.getResources().getString(2131694975);
    }
    localQQCustomDialog.setMessage(paramString1);
    localQQCustomDialog.setNegativeButton(paramActivity.getResources().getString(2131690620), paramOnClickListener1);
    localQQCustomDialog.setPositiveButton(paramActivity.getResources().getString(2131694201), paramOnClickListener2);
    localQQCustomDialog.setOnCancelListener(paramOnCancelListener);
    localQQCustomDialog.show();
    return localQQCustomDialog;
  }
  
  public static QQCustomDialog b(Context paramContext, int paramInt)
  {
    return b(paramContext, paramInt, null, null, 2131690620, 2131694201, null, null);
  }
  
  public static QQCustomDialog b(Context paramContext, int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new QQCustomDialog(paramContext, 2131755826);
    paramContext.setContentView(2131559016);
    paramContext.setTitle(paramString1);
    paramContext.setMessageWithUrl(paramString2);
    paramContext.setNegativeButton(paramInt2, paramOnClickListener2);
    paramContext.setPositiveButton(paramInt3, paramOnClickListener1);
    paramContext.setCanceledOnTouchOutside(true);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bfur
 * JD-Core Version:    0.7.0.1
 */