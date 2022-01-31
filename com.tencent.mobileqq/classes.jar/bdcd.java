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
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.HashMap;

public class bdcd
{
  public static final HashMap<String, String> a = new HashMap();
  
  static
  {
    a.put("android.permission.READ_EXTERNAL_STORAGE", alpo.a(2131703657));
    a.put("android.permission.WRITE_EXTERNAL_STORAGE", alpo.a(2131703672));
    a.put("android.permission.READ_PHONE_STATE", "QQ使用电话权限确定本机号码和设备ID，以保证帐号登录的安全性。QQ不会拨打其他号码或终止通话。\n" + alpo.a(2131703643));
    a.put("android.permission.CAMERA", alpo.a(2131703684));
    a.put("android.permission.RECORD_AUDIO", alpo.a(2131703655));
    a.put("android.permission.ACCESS_COARSE_LOCATION", alpo.a(2131703650));
    a.put("android.permission.ACCESS_FINE_LOCATION", alpo.a(2131703656));
    a.put("android.permission.READ_CALENDAR", alpo.a(2131703700));
    a.put("android.permission.WRITE_CALENDAR", alpo.a(2131703698));
    a.put("android.permission.SEND_SMS", alpo.a(2131703686));
    a.put("android.permission.READ_CONTACTS", alpo.a(2131703675));
    a.put("android.permission.WRITE_CONTACTS", alpo.a(2131703693));
  }
  
  public static Dialog a(Activity paramActivity, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2)
  {
    paramActivity = bcwg.a(paramActivity, 2131698690, 2131698688, 2131698687, 2131698689, paramOnClickListener1, paramOnClickListener2);
    paramActivity.setCancelable(false);
    return paramActivity;
  }
  
  public static Dialog a(Context paramContext, int paramInt1, bdcp parambdcp, Object paramObject, int paramInt2, int paramInt3, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject1 = paramContext.getResources();
    String str2 = ((Resources)localObject1).getString(paramInt2);
    String str1 = ((Resources)localObject1).getString(paramInt3);
    paramContext = new Dialog(paramContext, 2131755801);
    paramContext.setContentView(2131558948);
    Object localObject2 = (TextView)paramContext.findViewById(2131365235);
    FrameLayout localFrameLayout = (FrameLayout)paramContext.findViewById(2131365236);
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
      localObject1 = (TextView)paramContext.findViewById(2131365220);
      if (localObject1 != null)
      {
        ((TextView)localObject1).setText(str2);
        ((TextView)localObject1).setContentDescription(str2);
        ((TextView)localObject1).setOnClickListener(paramOnClickListener1);
        if (paramBoolean1) {
          ((TextView)localObject1).getPaint().setFakeBoldText(true);
        }
      }
      paramOnClickListener1 = (TextView)paramContext.findViewById(2131365226);
      if (paramOnClickListener1 != null)
      {
        paramOnClickListener1.setText(str1);
        paramOnClickListener1.setContentDescription(str1);
        paramOnClickListener1.setOnClickListener(paramOnClickListener2);
        if (paramBoolean2) {
          paramOnClickListener1.getPaint().setFakeBoldText(true);
        }
      }
      localFrameLayout.addView(parambdcp.a(localFrameLayout.getContext(), paramObject));
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
    paramContext = new Dialog(paramContext, 2131755801);
    paramContext.setContentView(2131558920);
    Object localObject2 = (TextView)paramContext.findViewById(2131365235);
    TextView localTextView = (TextView)paramContext.findViewById(2131365231);
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
      paramString = (TextView)paramContext.findViewById(2131365220);
      if (paramString != null)
      {
        paramString.setText(str2);
        paramString.setContentDescription(str2);
        paramString.setOnClickListener(paramOnClickListener1);
        if (paramBoolean1) {
          paramString.getPaint().setFakeBoldText(true);
        }
      }
      paramString = (TextView)paramContext.findViewById(2131365226);
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
    paramContext = new Dialog(paramContext, 2131755801);
    paramContext.setContentView(2131558954);
    ImageView localImageView = (ImageView)paramContext.findViewById(2131367808);
    TextView localTextView1 = (TextView)paramContext.findViewById(2131377884);
    TextView localTextView2 = (TextView)paramContext.findViewById(2131364770);
    TextView localTextView3 = (TextView)paramContext.findViewById(2131363907);
    TextView localTextView4 = (TextView)paramContext.findViewById(2131364688);
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
    paramContext = new Dialog(paramContext, 2131755801);
    paramContext.setContentView(2131560671);
    ImageView localImageView = (ImageView)paramContext.findViewById(2131379238);
    TextView localTextView1 = (TextView)paramContext.findViewById(2131379239);
    TextView localTextView2 = (TextView)paramContext.findViewById(2131379240);
    TextView localTextView3 = (TextView)paramContext.findViewById(2131379234);
    TextView localTextView4 = (TextView)paramContext.findViewById(2131379235);
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
    paramContext = new Dialog(paramContext, 2131755801);
    paramContext.setContentView(2131558962);
    ImageView localImageView = (ImageView)paramContext.findViewById(2131379238);
    TextView localTextView1 = (TextView)paramContext.findViewById(2131365235);
    TextView localTextView2 = (TextView)paramContext.findViewById(2131379239);
    TextView localTextView3 = (TextView)paramContext.findViewById(2131379240);
    TextView localTextView4 = (TextView)paramContext.findViewById(2131379234);
    TextView localTextView5 = (TextView)paramContext.findViewById(2131379235);
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
    paramContext = new Dialog(paramContext, 2131755801);
    paramContext.getWindow().setWindowAnimations(2131755128);
    paramContext.setContentView(2131560888);
    ((TextView)paramContext.findViewById(2131365269)).setVisibility(8);
    TextView localTextView1 = (TextView)paramContext.findViewById(2131365258);
    TextView localTextView2 = (TextView)paramContext.findViewById(2131365256);
    TextView localTextView3 = (TextView)paramContext.findViewById(2131365262);
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
  
  public static Dialog a(Context paramContext, String paramString, CharSequence paramCharSequence, int paramInt1, int paramInt2, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, bejn parambejn)
  {
    paramContext = new Dialog(paramContext, 2131755801);
    paramContext.setContentView(2131560888);
    TextView localTextView3 = (TextView)paramContext.findViewById(2131365269);
    ClickableColorSpanTextView localClickableColorSpanTextView = (ClickableColorSpanTextView)paramContext.findViewById(2131365258);
    TextView localTextView1 = (TextView)paramContext.findViewById(2131365256);
    TextView localTextView2 = (TextView)paramContext.findViewById(2131365262);
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
      paramString = new bdce(paramOnClickListener1, paramContext, paramOnClickListener2);
      localTextView1.setOnClickListener(paramString);
      localTextView2.setOnClickListener(paramString);
      localClickableColorSpanTextView.setSpanClickListener(parambejn);
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
    return a(paramContext, paramContext.getResources().getDrawable(2130848983), paramInt);
  }
  
  public static ProgressDialog a(Context paramContext, Drawable paramDrawable, int paramInt)
  {
    return a(paramContext, paramDrawable, paramInt, 0);
  }
  
  public static ProgressDialog a(Context paramContext, Drawable paramDrawable, int paramInt1, int paramInt2)
  {
    int i = paramInt2;
    if (paramInt2 <= 0) {
      i = 2131755801;
    }
    paramContext = new ProgressDialog(paramContext, i);
    try
    {
      paramContext.show();
      label26:
      paramContext.getWindow().setContentView(2131558428);
      paramContext.setContentView(2131558428);
      ((TextView)paramContext.findViewById(2131365231)).setText(paramInt1);
      ((ProgressBar)paramContext.findViewById(2131366685)).setIndeterminateDrawable(paramDrawable);
      return paramContext;
    }
    catch (Exception localException)
    {
      break label26;
    }
  }
  
  public static bdef a(Activity paramActivity, String paramString1, long paramLong, String paramString2, CharSequence paramCharSequence)
  {
    paramActivity = new bdef(paramActivity);
    paramActivity.a(new baig(a(paramString1), 3)).b(new baig(a(paramString2), 3)).a(paramLong).c(paramCharSequence);
    paramActivity.setCanceledOnTouchOutside(false);
    paramActivity.setCancelable(true);
    return paramActivity;
  }
  
  public static bdfh a(Context paramContext, String paramString, Bundle paramBundle)
  {
    bdfh localbdfh = new bdfh(paramContext, 2131755801);
    localbdfh.a(paramContext, paramBundle);
    localbdfh.setTitle(paramString);
    localbdfh.setCanceledOnTouchOutside(false);
    localbdfh.setCancelable(true);
    return localbdfh;
  }
  
  public static bdfh a(Context paramContext, String paramString, Bundle paramBundle, int paramInt)
  {
    bdfh localbdfh = new bdfh(paramContext, 2131755801);
    localbdfh.a(paramContext, paramBundle);
    localbdfh.setTitle(paramString);
    localbdfh.setCanceledOnTouchOutside(false);
    localbdfh.setCancelable(true);
    if (paramInt > 0) {
      localbdfh.c(paramInt);
    }
    return localbdfh;
  }
  
  public static bdfl a(Context paramContext, String paramString, Bundle paramBundle)
  {
    bdfl localbdfl = new bdfl(paramContext, 2131755801);
    localbdfl.a(paramContext, paramBundle);
    localbdfl.setTitle(paramString);
    localbdfl.setCanceledOnTouchOutside(true);
    localbdfl.setCancelable(true);
    return localbdfl;
  }
  
  public static bdfp a(Context paramContext, bdkz parambdkz, DialogInterface.OnClickListener paramOnClickListener)
  {
    if ((parambdkz == null) || (parambdkz.a() <= 0)) {
      return null;
    }
    paramContext = new bdfp(paramContext, 2131755801);
    paramContext.setCanceledOnTouchOutside(true);
    paramContext.setContentView(2131558943);
    paramContext.a(parambdkz, paramOnClickListener);
    paramContext.a(2131558933);
    ((LinearLayout)paramContext.findViewById(2131363482)).setLayoutParams(new RelativeLayout.LayoutParams(-1, 0));
    parambdkz = (ListView)paramContext.findViewById(2131369501);
    paramOnClickListener = new RelativeLayout.LayoutParams(-1, -2);
    paramOnClickListener.addRule(3, 2131365235);
    parambdkz.setLayoutParams(paramOnClickListener);
    return paramContext;
  }
  
  public static bdfq a(Activity paramActivity)
  {
    bdfq localbdfq = a(paramActivity, 230);
    localbdfq.setTitle(alpo.a(2131703645));
    localbdfq.setMessage(2131694126);
    localbdfq.setNegativeButton(alpo.a(2131703676), new bdcg(localbdfq));
    localbdfq.setPositiveButton(alpo.a(2131715309), new bdch(paramActivity));
    localbdfq.setOnCancelListener(null);
    localbdfq.show();
    return localbdfq;
  }
  
  public static bdfq a(Activity paramActivity, int paramInt)
  {
    return a(paramActivity, paramActivity.getString(paramInt), 2131690648, 2131694951, null, null);
  }
  
  public static bdfq a(Activity paramActivity, azjq paramazjq)
  {
    paramazjq = new bdck(paramActivity, paramazjq);
    paramActivity = a(paramActivity, 230);
    paramActivity.setTitle(alpo.a(2131710586));
    paramActivity.setMessage(alpo.a(2131708322));
    paramActivity.setNegativeButton(alpo.a(2131703676), paramazjq);
    paramActivity.setPositiveButton(alpo.a(2131703660), paramazjq);
    paramActivity.show();
    return paramActivity;
  }
  
  public static bdfq a(Activity paramActivity, String paramString)
  {
    return a(paramActivity, paramString, 2131690648, 2131694951, null, null);
  }
  
  public static bdfq a(Activity paramActivity, String paramString, int paramInt1, int paramInt2, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramString = a(paramActivity, 230, null, paramString, paramInt1, paramInt2, paramOnClickListener1, paramOnClickListener2);
    if (paramString != null)
    {
      ((TextView)paramString.findViewById(2131365209)).setVisibility(8);
      ((TextView)paramString.findViewById(2131365231)).setMinHeight(bcwh.a(paramActivity, 35.0F));
    }
    return paramString;
  }
  
  public static bdfq a(Activity paramActivity, String paramString1, long paramLong, String paramString2, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    bdfq localbdfq = new bdfq(paramActivity, 2131755801);
    localbdfq.setContentView(2131558943);
    localbdfq.setTitle(paramString1);
    paramActivity = paramActivity.getLayoutInflater().inflate(2131558822, null);
    paramString1 = (TextView)paramActivity.findViewById(2131379148);
    String str = bdef.a((float)paramLong, true, 2);
    if (!TextUtils.isEmpty(str)) {
      paramString1.setText(alpo.a(2131703664) + str);
    }
    ((TextView)paramActivity.findViewById(2131365231)).setText(paramString2);
    localbdfq.addView(paramActivity);
    localbdfq.setNegativeButton(alpo.a(2131703640), paramOnClickListener1);
    localbdfq.setPositiveButton(alpo.a(2131703689), paramOnClickListener2);
    localbdfq.setCanceledOnTouchOutside(false);
    return localbdfq;
  }
  
  public static bdfq a(Activity paramActivity, String paramString1, String paramString2)
  {
    bdcn localbdcn = new bdcn(paramActivity);
    bdfq localbdfq = a(paramActivity, 230);
    if (paramString1 != null)
    {
      paramActivity = paramString1;
      if (!paramString1.equals("")) {}
    }
    else
    {
      paramActivity = alpo.a(2131703649);
    }
    localbdfq.setTitle(paramActivity);
    if (paramString2 != null)
    {
      paramActivity = paramString2;
      if (!paramString2.equals("")) {}
    }
    else
    {
      paramActivity = alpo.a(2131703701);
    }
    localbdfq.setMessage(paramActivity);
    localbdfq.setPositiveButton(alpo.a(2131703704), localbdcn);
    localbdfq.show();
    return localbdfq;
  }
  
  public static bdfq a(Activity paramActivity, String paramString1, String paramString2, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    bdfq localbdfq = a(paramActivity, 230);
    if (paramString1 != null)
    {
      paramActivity = paramString1;
      if (!paramString1.equals("")) {}
    }
    else
    {
      paramActivity = alpo.a(2131703645);
    }
    localbdfq.setTitle(paramActivity);
    if (paramString2 != null)
    {
      paramActivity = paramString2;
      if (!paramString2.equals("")) {}
    }
    else
    {
      paramActivity = alpo.a(2131703683);
    }
    localbdfq.setMessage(paramActivity);
    localbdfq.setNegativeButton(alpo.a(2131703676), paramOnClickListener1);
    localbdfq.setPositiveButton(alpo.a(2131703660), paramOnClickListener2);
    localbdfq.setOnCancelListener(paramOnCancelListener);
    localbdfq.show();
    return localbdfq;
  }
  
  public static bdfq a(Activity paramActivity, String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener)
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
  
  public static bdfq a(Activity paramActivity, String[] paramArrayOfString, int[] paramArrayOfInt)
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
  
  public static bdfq a(Context paramContext, int paramInt)
  {
    return a(paramContext, paramInt, null, null, 2131690648, 2131694951, null, null);
  }
  
  public static bdfq a(Context paramContext, int paramInt1, int paramInt2, String paramString, CharSequence paramCharSequence, int paramInt3, int paramInt4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new bdfq(paramContext, 2131755801);
    paramContext.setContentView(paramInt2);
    paramContext.setTitle(paramString);
    paramContext.setMessageWithoutAutoLink(paramCharSequence);
    paramContext.setNegativeButton(paramInt3, paramOnClickListener2);
    paramContext.setPositiveButton(paramInt4, paramOnClickListener1);
    paramContext.setCanceledOnTouchOutside(true);
    return paramContext;
  }
  
  public static bdfq a(Context paramContext, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new bdfq(paramContext, 2131755801);
    paramContext.setContentView(paramInt2);
    paramContext.setTitle(paramString1);
    paramContext.setMessage(paramString2);
    paramContext.setNegativeButton(paramString3, paramOnClickListener2);
    paramContext.setPositiveButton(paramString4, paramOnClickListener1);
    paramContext.setCanceledOnTouchOutside(false);
    return paramContext;
  }
  
  public static bdfq a(Context paramContext, int paramInt1, String paramString, CharSequence paramCharSequence, int paramInt2, int paramInt3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    return a(paramContext, paramInt1, 2131558943, paramString, paramCharSequence, paramInt2, paramInt3, paramOnClickListener1, paramOnClickListener2);
  }
  
  public static bdfq a(Context paramContext, int paramInt, String paramString1, CharSequence paramCharSequence, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new bdfq(paramContext, 2131755801);
    paramContext.setContentView(2131558943);
    paramContext.setTitle(paramString1);
    paramContext.setMessage(paramCharSequence);
    paramContext.setNegativeButton(paramString2, paramOnClickListener2);
    paramContext.setPositiveButton(paramString3, paramOnClickListener1);
    paramContext.setCanceledOnTouchOutside(false);
    return paramContext;
  }
  
  public static bdfq a(Context paramContext, int paramInt, String paramString1, CharSequence paramCharSequence, String paramString2, String paramString3, String paramString4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    return a(paramContext, paramInt, paramString1, paramCharSequence, paramString2, paramString3, paramString4, paramOnClickListener1, paramOnClickListener2, null);
  }
  
  public static bdfq a(Context paramContext, int paramInt, String paramString1, CharSequence paramCharSequence, String paramString2, String paramString3, String paramString4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnClickListener paramOnClickListener3)
  {
    bdfq localbdfq = new bdfq(paramContext, 2131755801);
    localbdfq.setContentView(2131558947);
    if (paramInt != 0) {
      localbdfq.setOperateImage(paramContext.getResources().getDrawable(paramInt));
    }
    for (;;)
    {
      localbdfq.setMessage(paramCharSequence);
      localbdfq.setNegativeButton(paramString2, paramOnClickListener1);
      localbdfq.setPositiveButton(paramString3, paramOnClickListener2);
      localbdfq.setCanceledOnTouchOutside(false);
      paramString1 = (TextView)localbdfq.findViewById(2131365211);
      paramContext = paramString4;
      if (paramString4 == null) {
        paramContext = alpo.a(2131703680);
      }
      paramString1.setText(paramContext);
      if (paramOnClickListener3 == null) {
        break;
      }
      paramString1.setOnClickListener(new bdcl(paramOnClickListener3, localbdfq));
      return localbdfq;
      localbdfq.setTitle(paramString1);
    }
    paramString1.setOnClickListener(new bdcm(localbdfq));
    return localbdfq;
  }
  
  public static bdfq a(Context paramContext, int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new bdfq(paramContext, 2131755801);
    paramContext.setContentView(2131558943);
    paramContext.setTitle(paramString1);
    paramContext.setMessage(paramString2);
    paramContext.setNegativeButton(paramInt2, paramOnClickListener2);
    paramContext.setPositiveButton(paramInt3, paramOnClickListener1);
    paramContext.setCanceledOnTouchOutside(false);
    return paramContext;
  }
  
  public static bdfq a(Context paramContext, int paramInt, String paramString1, String paramString2, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    return a(paramContext, paramInt, paramString1, paramString2, 2131690648, 2131694951, paramOnClickListener1, paramOnClickListener2);
  }
  
  public static bdfq a(Context paramContext, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt2, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new bdfq(paramContext, 2131755801);
    paramContext.setContentView(2131558943);
    paramContext.setTitle(paramString1);
    paramContext.setMessage(paramString2);
    paramContext.setNegativeButton(paramString3, paramOnClickListener2);
    paramContext.setPositiveButton(paramString4, paramInt2, paramOnClickListener1);
    paramContext.setCanceledOnTouchOutside(false);
    return paramContext;
  }
  
  public static bdfq a(Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new bdfq(paramContext, 2131755801);
    paramContext.setContentView(2131558943);
    paramContext.setTitle(paramString1);
    paramContext.setMessage(paramString2);
    paramContext.setNegativeButton(paramString3, paramOnClickListener2);
    paramContext.setPositiveButton(paramString4, paramOnClickListener1);
    paramContext.setCanceledOnTouchOutside(false);
    paramString1 = (TextView)paramContext.findViewById(2131365209);
    paramString1 = (TextView)paramContext.findViewById(2131365231);
    paramString2 = new LinearLayout.LayoutParams(-2, -2);
    paramString2.gravity = 17;
    paramString1.setLayoutParams(paramString2);
    return paramContext;
  }
  
  public static bdfq a(Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnClickListener paramOnClickListener3)
  {
    paramContext = new bdfq(paramContext, 2131755801);
    paramContext.setContentView(2131558927);
    paramContext.setTitle(paramString1);
    paramContext.setMessage(paramString2);
    paramContext.setNegativeButton(paramString4, paramOnClickListener3);
    paramContext.setPositiveButton(paramString5, paramOnClickListener2);
    paramContext.setCanceledOnTouchOutside(false);
    paramContext.setCheckBox(paramString3, paramOnClickListener1);
    return paramContext;
  }
  
  public static bdfq a(Context paramContext, String paramString1, String paramString2, DialogInterface.OnClickListener paramOnClickListener)
  {
    paramContext = new bdfq(paramContext, 2131755801);
    paramContext.setContentView(2131558940);
    paramContext.setTitle(paramString1);
    paramContext.setNegativeButton(paramString2, paramOnClickListener);
    paramContext.setCanceledOnTouchOutside(false);
    return paramContext;
  }
  
  public static bdfq a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = a(paramContext, 230, paramString1, paramString2, paramInt1, paramInt2, paramOnClickListener1, paramOnClickListener2);
    paramContext.setEditLint(paramString3);
    return paramContext;
  }
  
  public static bdfq a(Context paramContext, String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener1, String paramString4, DialogInterface.OnClickListener paramOnClickListener2, View.OnClickListener paramOnClickListener)
  {
    paramContext = new bdfq(paramContext, 2131755801);
    paramContext.setContentView(2131558922);
    TextView localTextView1 = (TextView)paramContext.findViewById(2131365235);
    TextView localTextView2 = (TextView)paramContext.findViewById(2131365231);
    ImageView localImageView = (ImageView)paramContext.findViewById(2131364325);
    localTextView1.setText(paramString1);
    localTextView2.setText(paramString2);
    paramContext.setNegativeButton(paramString3, paramOnClickListener1);
    paramContext.setPositiveButton(paramString4, paramOnClickListener2);
    localImageView.setOnClickListener(paramOnClickListener);
    paramContext.setCanceledOnTouchOutside(false);
    paramContext.setCancelable(false);
    return paramContext;
  }
  
  public static bdfq a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new bdfq(paramContext, 2131755801);
    paramContext.setContentView(2131558930);
    paramContext.setTitleWithEmo(new baig(a(paramString1), 3));
    paramContext.setMessage(new baig(a(paramString2), 3));
    paramContext.setNegativeButton(paramString3, paramOnClickListener2);
    paramContext.setPositiveButton(paramString4, paramOnClickListener1);
    if ((paramString5 != null) && (!"".equals(paramString5))) {
      paramContext.setCheckBox(paramString5, null);
    }
    paramContext.setCanceledOnTouchOutside(false);
    return paramContext;
  }
  
  public static bdge a(Context paramContext, int paramInt)
  {
    return a(paramContext, paramInt, null, null, "", "", "", null, null, null);
  }
  
  public static bdge a(Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnClickListener paramOnClickListener3)
  {
    paramContext = new bdge(paramContext, 2131755801);
    paramContext.setContentView(2131558946);
    paramContext.a(paramString1);
    paramContext.b(paramString2);
    paramContext.a(paramString4, paramOnClickListener1);
    paramContext.b(paramString5, paramOnClickListener2);
    paramContext.b(paramString4, paramOnClickListener3);
    paramContext.setCanceledOnTouchOutside(true);
    return paramContext;
  }
  
  public static bdgl a(Context paramContext, String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new bdgl(paramContext, 2131755801);
    paramContext.setContentView(2131558953);
    paramContext.setTitle(paramString1);
    paramContext.setMessage(paramString2);
    paramContext.setCanceledOnTouchOutside(false);
    paramContext.setCancelable(true);
    paramContext.b(paramString3);
    paramContext.setNegativeButton(2131690648, paramOnClickListener2);
    paramContext.setPositiveButton(2131690797, paramOnClickListener1);
    paramContext.show();
    return paramContext;
  }
  
  public static bdgl a(Context paramContext, String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, int paramInt)
  {
    return a(paramContext, paramString1, paramString2, paramString3, paramOnClickListener1, paramOnClickListener2, paramInt, false);
  }
  
  public static bdgl a(Context paramContext, String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, int paramInt, boolean paramBoolean)
  {
    paramContext = new bdgl(paramContext, 2131755801);
    paramContext.b(7);
    paramContext.a(paramBoolean);
    paramContext.setContentView(2131558953);
    paramContext.setTitle(paramString1);
    if (paramInt != 0) {
      paramContext.c(paramInt);
    }
    paramContext.setMessage(paramString2);
    paramContext.setCanceledOnTouchOutside(false);
    paramContext.setCancelable(true);
    paramContext.b(paramString3);
    paramContext.setNegativeButton(2131690648, paramOnClickListener2);
    paramContext.setPositiveButton(2131690797, paramOnClickListener1);
    paramContext.show();
    return paramContext;
  }
  
  public static bdha a(Context paramContext, int paramInt1, int paramInt2, String paramString, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new bdha(paramContext, 2131755801);
    paramContext.setContentView(2131558956);
    paramContext.setTitle(paramInt1);
    paramContext.setMessage(paramInt2);
    paramContext.setCanceledOnTouchOutside(false);
    paramContext.setCancelable(true);
    paramContext.a(paramString);
    paramContext.setNegativeButton(2131690648, paramOnClickListener2);
    paramContext.setPositiveButton(2131694951, paramOnClickListener1);
    paramContext.show();
    return paramContext;
  }
  
  public static bdha a(Context paramContext, int paramInt1, int paramInt2, String paramString, TextWatcher paramTextWatcher, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new bdha(paramContext, 2131755801);
    paramContext.setContentView(2131558956);
    paramContext.setTitle(paramInt1);
    paramContext.setMessage(paramInt2);
    paramContext.setCanceledOnTouchOutside(false);
    paramContext.setCancelable(true);
    paramContext.a(paramTextWatcher);
    paramContext.a(paramString);
    paramContext.setNegativeButton(2131690648, paramOnClickListener2);
    paramContext.setPositiveButton(2131694951, paramOnClickListener1);
    paramContext.show();
    return paramContext;
  }
  
  public static bdhc a(Context paramContext, String paramString1, String paramString2, String paramString3, ArrayList<String> paramArrayList, String paramString4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, int paramInt, boolean paramBoolean)
  {
    paramContext = new bdhc(paramContext, 2131755801);
    paramContext.a(paramBoolean);
    paramContext.setContentView(2131558958);
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
    paramContext.setNegativeButton(2131690648, paramOnClickListener2);
    paramContext.setPositiveButton(2131690797, paramOnClickListener1);
    paramContext.show();
    return paramContext;
  }
  
  public static bdhj a(Context paramContext, String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener1, String paramString4, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new bdhj(paramContext, 2131755801);
    paramContext.setContentView(2131558945);
    paramContext.a(paramString1.replace(alpo.a(2131703695), baiy.c(21)).replace(alpo.a(2131703639), baiy.c(18)).replace(alpo.a(2131703678), baiy.c(86)).replace(alpo.a(2131703697), baiy.c(55)).replace("\\U0001f60f", String.valueOf(Character.toChars(128527))).replace("\\U0001f60c", String.valueOf(Character.toChars(128524))));
    paramContext.a(paramString2.replace(alpo.a(2131703677), baiy.c(21)).replace(alpo.a(2131703666), baiy.c(18)).replace(alpo.a(2131703685), baiy.c(86)).replace(alpo.a(2131703692), baiy.c(55)).replace("\\U0001f60f", String.valueOf(Character.toChars(128527))).replace("\\U0001f60c", String.valueOf(Character.toChars(128524))), 2.0F);
    paramContext.a(2130839390, 2131690648, paramOnClickListener2);
    paramContext.a(paramString3.replace(alpo.a(2131703644), baiy.c(21)).replace(alpo.a(2131703696), baiy.c(18)).replace(alpo.a(2131703699), baiy.c(86)).replace(alpo.a(2131703641), baiy.c(55)).replace("\\U0001f60f", String.valueOf(Character.toChars(128527))).replace("\\U0001f60c", String.valueOf(Character.toChars(128524))), paramOnClickListener1);
    paramContext.setCanceledOnTouchOutside(false);
    return paramContext;
  }
  
  protected static String a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      return paramString.replace(alpo.a(2131703702), baiy.c(21)).replace(alpo.a(2131703661), baiy.c(18)).replace(alpo.a(2131703642), baiy.c(86)).replace(alpo.a(2131703671), baiy.c(55)).replace("\\U0001f60f", String.valueOf(Character.toChars(128527))).replace("\\U0001f60c", String.valueOf(Character.toChars(128524)));
    }
    return null;
  }
  
  public static String a(String... paramVarArgs)
  {
    String str2 = alpo.a(2131703681);
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
          str1 = alpo.a(2131703648);
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
            str1 = alpo.a(2131703663);
          } else if ("android.permission.ACCESS_COARSE_LOCATION".equals(str3)) {
            str1 = alpo.a(2131703652);
          } else if ("android.permission.ACCESS_FINE_LOCATION".equals(str3)) {
            str1 = alpo.a(2131703670);
          } else if ("android.permission.READ_CALENDAR".equals(str3)) {
            str1 = alpo.a(2131703682);
          } else if ("android.permission.WRITE_CALENDAR".equals(str3)) {
            str1 = alpo.a(2131703688);
          } else if ("android.permission.SEND_SMS".equals(str3)) {
            str1 = alpo.a(2131703646);
          } else if ("android.permission.READ_CONTACTS".equals(str3)) {
            str1 = alpo.a(2131703653);
          } else if ("android.permission.WRITE_CONTACTS".equals(str3)) {
            str1 = alpo.a(2131703691);
          } else if ("android.permission.WRITE_EXTERNAL_STORAGE".equals(str3)) {
            str1 = alpo.a(2131708323);
          } else if ("android.permission.READ_EXTERNAL_STORAGE".equals(str3)) {
            str1 = alpo.a(2131708321);
          }
        }
      }
      str1 = localStringBuilder.toString();
    }
    return String.format(str2, new Object[] { str1 });
  }
  
  public static bdfq b(Activity paramActivity)
  {
    bdci localbdci = new bdci(paramActivity);
    paramActivity = a(paramActivity, 230);
    paramActivity.setTitle(alpo.a(2131710586));
    paramActivity.setMessage(alpo.a(2131708322));
    paramActivity.setNegativeButton(alpo.a(2131703676), localbdci);
    paramActivity.setPositiveButton(alpo.a(2131703660), localbdci);
    paramActivity.show();
    return paramActivity;
  }
  
  public static bdfq b(Activity paramActivity, String paramString)
  {
    bdcj localbdcj = new bdcj(paramActivity);
    paramActivity = a(paramActivity, 230);
    paramActivity.setTitle(alpo.a(2131710586));
    paramActivity.setMessage(paramString);
    paramActivity.setNegativeButton(alpo.a(2131703676), localbdcj);
    paramActivity.setPositiveButton(alpo.a(2131703660), localbdcj);
    paramActivity.show();
    return paramActivity;
  }
  
  public static bdfq b(Activity paramActivity, String paramString1, String paramString2)
  {
    bdcf localbdcf = new bdcf(paramActivity);
    return a(paramActivity, paramString1, paramString2, localbdcf, localbdcf, null);
  }
  
  public static bdfq b(Activity paramActivity, String paramString1, String paramString2, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    bdfq localbdfq = a(paramActivity, 230);
    String str;
    if (paramString1 != null)
    {
      str = paramString1;
      if (!paramString1.equals("")) {}
    }
    else
    {
      str = paramActivity.getResources().getString(2131695918);
    }
    localbdfq.setTitle(str);
    if (paramString2 != null)
    {
      paramString1 = paramString2;
      if (!paramString2.equals("")) {}
    }
    else
    {
      paramString1 = paramActivity.getResources().getString(2131695915);
    }
    localbdfq.setMessage(paramString1);
    localbdfq.setNegativeButton(paramActivity.getResources().getString(2131690648), paramOnClickListener1);
    localbdfq.setPositiveButton(paramActivity.getResources().getString(2131694951), paramOnClickListener2);
    localbdfq.setOnCancelListener(paramOnCancelListener);
    localbdfq.show();
    return localbdfq;
  }
  
  public static bdfq b(Context paramContext, int paramInt)
  {
    return b(paramContext, paramInt, null, null, 2131690648, 2131694951, null, null);
  }
  
  public static bdfq b(Context paramContext, int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new bdfq(paramContext, 2131755801);
    paramContext.setContentView(2131558943);
    paramContext.setTitle(paramString1);
    paramContext.setMessageWithUrl(paramString2);
    paramContext.setNegativeButton(paramInt2, paramOnClickListener2);
    paramContext.setPositiveButton(paramInt3, paramOnClickListener1);
    paramContext.setCanceledOnTouchOutside(true);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bdcd
 * JD-Core Version:    0.7.0.1
 */