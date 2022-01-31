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

public class bbcv
{
  public static final HashMap<String, String> a = new HashMap();
  
  static
  {
    a.put("android.permission.READ_EXTERNAL_STORAGE", ajyc.a(2131703274));
    a.put("android.permission.WRITE_EXTERNAL_STORAGE", ajyc.a(2131703289));
    a.put("android.permission.READ_PHONE_STATE", "QQ使用电话权限确定本机号码和设备ID，以保证帐号登录的安全性。QQ不会拨打其他号码或终止通话。\n" + ajyc.a(2131703260));
    a.put("android.permission.CAMERA", ajyc.a(2131703301));
    a.put("android.permission.RECORD_AUDIO", ajyc.a(2131703272));
    a.put("android.permission.ACCESS_COARSE_LOCATION", ajyc.a(2131703267));
    a.put("android.permission.ACCESS_FINE_LOCATION", ajyc.a(2131703273));
    a.put("android.permission.READ_CALENDAR", ajyc.a(2131703317));
    a.put("android.permission.WRITE_CALENDAR", ajyc.a(2131703315));
    a.put("android.permission.SEND_SMS", ajyc.a(2131703303));
    a.put("android.permission.READ_CONTACTS", ajyc.a(2131703292));
    a.put("android.permission.WRITE_CONTACTS", ajyc.a(2131703310));
  }
  
  public static Dialog a(Activity paramActivity, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2)
  {
    paramActivity = bawy.a(paramActivity, 2131698390, 2131698388, 2131698387, 2131698389, paramOnClickListener1, paramOnClickListener2);
    paramActivity.setCancelable(false);
    return paramActivity;
  }
  
  public static Dialog a(Context paramContext, int paramInt1, bbdg parambbdg, Object paramObject, int paramInt2, int paramInt3, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject1 = paramContext.getResources();
    String str2 = ((Resources)localObject1).getString(paramInt2);
    String str1 = ((Resources)localObject1).getString(paramInt3);
    paramContext = new Dialog(paramContext, 2131755791);
    paramContext.setContentView(2131558911);
    Object localObject2 = (TextView)paramContext.findViewById(2131365151);
    FrameLayout localFrameLayout = (FrameLayout)paramContext.findViewById(2131365152);
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
      localObject1 = (TextView)paramContext.findViewById(2131365136);
      if (localObject1 != null)
      {
        ((TextView)localObject1).setText(str2);
        ((TextView)localObject1).setContentDescription(str2);
        ((TextView)localObject1).setOnClickListener(paramOnClickListener1);
        if (paramBoolean1) {
          ((TextView)localObject1).getPaint().setFakeBoldText(true);
        }
      }
      paramOnClickListener1 = (TextView)paramContext.findViewById(2131365142);
      if (paramOnClickListener1 != null)
      {
        paramOnClickListener1.setText(str1);
        paramOnClickListener1.setContentDescription(str1);
        paramOnClickListener1.setOnClickListener(paramOnClickListener2);
        if (paramBoolean2) {
          paramOnClickListener1.getPaint().setFakeBoldText(true);
        }
      }
      localFrameLayout.addView(parambbdg.a(localFrameLayout.getContext(), paramObject));
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
    paramContext = new Dialog(paramContext, 2131755791);
    paramContext.setContentView(2131558883);
    Object localObject2 = (TextView)paramContext.findViewById(2131365151);
    TextView localTextView = (TextView)paramContext.findViewById(2131365147);
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
      paramString = (TextView)paramContext.findViewById(2131365136);
      if (paramString != null)
      {
        paramString.setText(str2);
        paramString.setContentDescription(str2);
        paramString.setOnClickListener(paramOnClickListener1);
        if (paramBoolean1) {
          paramString.getPaint().setFakeBoldText(true);
        }
      }
      paramString = (TextView)paramContext.findViewById(2131365142);
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
    paramContext = new Dialog(paramContext, 2131755791);
    paramContext.setContentView(2131558917);
    ImageView localImageView = (ImageView)paramContext.findViewById(2131367679);
    TextView localTextView1 = (TextView)paramContext.findViewById(2131377350);
    TextView localTextView2 = (TextView)paramContext.findViewById(2131364692);
    TextView localTextView3 = (TextView)paramContext.findViewById(2131363852);
    TextView localTextView4 = (TextView)paramContext.findViewById(2131364611);
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
    paramContext = new Dialog(paramContext, 2131755791);
    paramContext.setContentView(2131560496);
    ImageView localImageView = (ImageView)paramContext.findViewById(2131378616);
    TextView localTextView1 = (TextView)paramContext.findViewById(2131378617);
    TextView localTextView2 = (TextView)paramContext.findViewById(2131378618);
    TextView localTextView3 = (TextView)paramContext.findViewById(2131378612);
    TextView localTextView4 = (TextView)paramContext.findViewById(2131378613);
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
    paramContext = new Dialog(paramContext, 2131755791);
    paramContext.setContentView(2131558925);
    ImageView localImageView = (ImageView)paramContext.findViewById(2131378616);
    TextView localTextView1 = (TextView)paramContext.findViewById(2131365151);
    TextView localTextView2 = (TextView)paramContext.findViewById(2131378617);
    TextView localTextView3 = (TextView)paramContext.findViewById(2131378618);
    TextView localTextView4 = (TextView)paramContext.findViewById(2131378612);
    TextView localTextView5 = (TextView)paramContext.findViewById(2131378613);
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
    paramContext = new Dialog(paramContext, 2131755791);
    paramContext.getWindow().setWindowAnimations(2131755124);
    paramContext.setContentView(2131560713);
    ((TextView)paramContext.findViewById(2131365185)).setVisibility(8);
    TextView localTextView1 = (TextView)paramContext.findViewById(2131365174);
    TextView localTextView2 = (TextView)paramContext.findViewById(2131365172);
    TextView localTextView3 = (TextView)paramContext.findViewById(2131365178);
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
  
  public static Dialog a(Context paramContext, String paramString, CharSequence paramCharSequence, int paramInt1, int paramInt2, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, bcjx parambcjx)
  {
    paramContext = new Dialog(paramContext, 2131755791);
    paramContext.setContentView(2131560713);
    TextView localTextView3 = (TextView)paramContext.findViewById(2131365185);
    ClickableColorSpanTextView localClickableColorSpanTextView = (ClickableColorSpanTextView)paramContext.findViewById(2131365174);
    TextView localTextView1 = (TextView)paramContext.findViewById(2131365172);
    TextView localTextView2 = (TextView)paramContext.findViewById(2131365178);
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
      paramString = new bbcw(paramOnClickListener1, paramContext, paramOnClickListener2);
      localTextView1.setOnClickListener(paramString);
      localTextView2.setOnClickListener(paramString);
      localClickableColorSpanTextView.setSpanClickListener(parambcjx);
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
    return a(paramContext, paramContext.getResources().getDrawable(2130848549), paramInt);
  }
  
  public static ProgressDialog a(Context paramContext, Drawable paramDrawable, int paramInt)
  {
    return a(paramContext, paramDrawable, paramInt, 0);
  }
  
  public static ProgressDialog a(Context paramContext, Drawable paramDrawable, int paramInt1, int paramInt2)
  {
    int i = paramInt2;
    if (paramInt2 <= 0) {
      i = 2131755791;
    }
    paramContext = new ProgressDialog(paramContext, i);
    try
    {
      paramContext.show();
      label26:
      paramContext.getWindow().setContentView(2131558428);
      paramContext.setContentView(2131558428);
      ((TextView)paramContext.findViewById(2131365147)).setText(paramInt1);
      ((ProgressBar)paramContext.findViewById(2131366570)).setIndeterminateDrawable(paramDrawable);
      return paramContext;
    }
    catch (Exception localException)
    {
      break label26;
    }
  }
  
  public static bbew a(Activity paramActivity, String paramString1, long paramLong, String paramString2, CharSequence paramCharSequence)
  {
    paramActivity = new bbew(paramActivity);
    paramActivity.a(new ayki(a(paramString1), 3)).b(new ayki(a(paramString2), 3)).a(paramLong).c(paramCharSequence);
    paramActivity.setCanceledOnTouchOutside(false);
    paramActivity.setCancelable(true);
    return paramActivity;
  }
  
  public static bbfx a(Context paramContext, String paramString, Bundle paramBundle)
  {
    bbfx localbbfx = new bbfx(paramContext, 2131755791);
    localbbfx.a(paramContext, paramBundle);
    localbbfx.setTitle(paramString);
    localbbfx.setCanceledOnTouchOutside(false);
    localbbfx.setCancelable(true);
    return localbbfx;
  }
  
  public static bbfx a(Context paramContext, String paramString, Bundle paramBundle, int paramInt)
  {
    bbfx localbbfx = new bbfx(paramContext, 2131755791);
    localbbfx.a(paramContext, paramBundle);
    localbbfx.setTitle(paramString);
    localbbfx.setCanceledOnTouchOutside(false);
    localbbfx.setCancelable(true);
    if (paramInt > 0) {
      localbbfx.c(paramInt);
    }
    return localbbfx;
  }
  
  public static bbgb a(Context paramContext, String paramString, Bundle paramBundle)
  {
    bbgb localbbgb = new bbgb(paramContext, 2131755791);
    localbbgb.a(paramContext, paramBundle);
    localbbgb.setTitle(paramString);
    localbbgb.setCanceledOnTouchOutside(true);
    localbbgb.setCancelable(true);
    return localbbgb;
  }
  
  public static bbgf a(Context paramContext, bblr parambblr, DialogInterface.OnClickListener paramOnClickListener)
  {
    if ((parambblr == null) || (parambblr.a() <= 0)) {
      return null;
    }
    paramContext = new bbgf(paramContext, 2131755791);
    paramContext.setCanceledOnTouchOutside(true);
    paramContext.setContentView(2131558906);
    paramContext.a(parambblr, paramOnClickListener);
    paramContext.a(2131558896);
    ((LinearLayout)paramContext.findViewById(2131363443)).setLayoutParams(new RelativeLayout.LayoutParams(-1, 0));
    parambblr = (ListView)paramContext.findViewById(2131369266);
    paramOnClickListener = new RelativeLayout.LayoutParams(-1, -2);
    paramOnClickListener.addRule(3, 2131365151);
    parambblr.setLayoutParams(paramOnClickListener);
    return paramContext;
  }
  
  public static bbgg a(Activity paramActivity)
  {
    bbgg localbbgg = a(paramActivity, 230);
    localbbgg.setTitle(ajyc.a(2131703262));
    localbbgg.setMessage(2131694009);
    localbbgg.setNegativeButton(ajyc.a(2131703293), new bbcy(localbbgg));
    localbbgg.setPositiveButton(ajyc.a(2131714926), new bbcz(paramActivity));
    localbbgg.setOnCancelListener(null);
    localbbgg.show();
    return localbbgg;
  }
  
  public static bbgg a(Activity paramActivity, int paramInt)
  {
    return a(paramActivity, paramActivity.getString(paramInt), 2131690596, 2131694793, null, null);
  }
  
  public static bbgg a(Activity paramActivity, axod paramaxod)
  {
    paramaxod = new bbdb(paramActivity, paramaxod);
    paramActivity = a(paramActivity, 230);
    paramActivity.setTitle(ajyc.a(2131710203));
    paramActivity.setMessage(ajyc.a(2131707939));
    paramActivity.setNegativeButton(ajyc.a(2131703293), paramaxod);
    paramActivity.setPositiveButton(ajyc.a(2131703277), paramaxod);
    paramActivity.show();
    return paramActivity;
  }
  
  public static bbgg a(Activity paramActivity, String paramString)
  {
    return a(paramActivity, paramString, 2131690596, 2131694793, null, null);
  }
  
  public static bbgg a(Activity paramActivity, String paramString, int paramInt1, int paramInt2, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramString = a(paramActivity, 230, null, paramString, paramInt1, paramInt2, paramOnClickListener1, paramOnClickListener2);
    if (paramString != null)
    {
      ((TextView)paramString.findViewById(2131365125)).setVisibility(8);
      ((TextView)paramString.findViewById(2131365147)).setMinHeight(bawz.a(paramActivity, 35.0F));
    }
    return paramString;
  }
  
  public static bbgg a(Activity paramActivity, String paramString1, long paramLong, String paramString2, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    bbgg localbbgg = new bbgg(paramActivity, 2131755791);
    localbbgg.setContentView(2131558906);
    localbbgg.setTitle(paramString1);
    paramActivity = paramActivity.getLayoutInflater().inflate(2131558786, null);
    paramString1 = (TextView)paramActivity.findViewById(2131378531);
    String str = bbew.a((float)paramLong, true, 2);
    if (!TextUtils.isEmpty(str)) {
      paramString1.setText(ajyc.a(2131703281) + str);
    }
    ((TextView)paramActivity.findViewById(2131365147)).setText(paramString2);
    localbbgg.addView(paramActivity);
    localbbgg.setNegativeButton(ajyc.a(2131703257), paramOnClickListener1);
    localbbgg.setPositiveButton(ajyc.a(2131703306), paramOnClickListener2);
    localbbgg.setCanceledOnTouchOutside(false);
    return localbbgg;
  }
  
  public static bbgg a(Activity paramActivity, String paramString1, String paramString2)
  {
    bbde localbbde = new bbde(paramActivity);
    bbgg localbbgg = a(paramActivity, 230);
    if (paramString1 != null)
    {
      paramActivity = paramString1;
      if (!paramString1.equals("")) {}
    }
    else
    {
      paramActivity = ajyc.a(2131703266);
    }
    localbbgg.setTitle(paramActivity);
    if (paramString2 != null)
    {
      paramActivity = paramString2;
      if (!paramString2.equals("")) {}
    }
    else
    {
      paramActivity = ajyc.a(2131703318);
    }
    localbbgg.setMessage(paramActivity);
    localbbgg.setPositiveButton(ajyc.a(2131703321), localbbde);
    localbbgg.show();
    return localbbgg;
  }
  
  public static bbgg a(Activity paramActivity, String paramString1, String paramString2, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    bbgg localbbgg = a(paramActivity, 230);
    if (paramString1 != null)
    {
      paramActivity = paramString1;
      if (!paramString1.equals("")) {}
    }
    else
    {
      paramActivity = ajyc.a(2131703262);
    }
    localbbgg.setTitle(paramActivity);
    if (paramString2 != null)
    {
      paramActivity = paramString2;
      if (!paramString2.equals("")) {}
    }
    else
    {
      paramActivity = ajyc.a(2131703300);
    }
    localbbgg.setMessage(paramActivity);
    localbbgg.setNegativeButton(ajyc.a(2131703293), paramOnClickListener1);
    localbbgg.setPositiveButton(ajyc.a(2131703277), paramOnClickListener2);
    localbbgg.setOnCancelListener(paramOnCancelListener);
    localbbgg.show();
    return localbbgg;
  }
  
  public static bbgg a(Activity paramActivity, String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener)
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
  
  public static bbgg a(Activity paramActivity, String[] paramArrayOfString, int[] paramArrayOfInt)
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
  
  public static bbgg a(Context paramContext, int paramInt)
  {
    return a(paramContext, paramInt, null, null, 2131690596, 2131694793, null, null);
  }
  
  public static bbgg a(Context paramContext, int paramInt1, int paramInt2, String paramString, CharSequence paramCharSequence, int paramInt3, int paramInt4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new bbgg(paramContext, 2131755791);
    paramContext.setContentView(paramInt2);
    paramContext.setTitle(paramString);
    paramContext.setMessageWithoutAutoLink(paramCharSequence);
    paramContext.setNegativeButton(paramInt3, paramOnClickListener2);
    paramContext.setPositiveButton(paramInt4, paramOnClickListener1);
    paramContext.setCanceledOnTouchOutside(true);
    return paramContext;
  }
  
  public static bbgg a(Context paramContext, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new bbgg(paramContext, 2131755791);
    paramContext.setContentView(paramInt2);
    paramContext.setTitle(paramString1);
    paramContext.setMessage(paramString2);
    paramContext.setNegativeButton(paramString3, paramOnClickListener2);
    paramContext.setPositiveButton(paramString4, paramOnClickListener1);
    paramContext.setCanceledOnTouchOutside(false);
    return paramContext;
  }
  
  public static bbgg a(Context paramContext, int paramInt1, String paramString, CharSequence paramCharSequence, int paramInt2, int paramInt3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    return a(paramContext, paramInt1, 2131558906, paramString, paramCharSequence, paramInt2, paramInt3, paramOnClickListener1, paramOnClickListener2);
  }
  
  public static bbgg a(Context paramContext, int paramInt, String paramString1, CharSequence paramCharSequence, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new bbgg(paramContext, 2131755791);
    paramContext.setContentView(2131558906);
    paramContext.setTitle(paramString1);
    paramContext.setMessage(paramCharSequence);
    paramContext.setNegativeButton(paramString2, paramOnClickListener2);
    paramContext.setPositiveButton(paramString3, paramOnClickListener1);
    paramContext.setCanceledOnTouchOutside(false);
    return paramContext;
  }
  
  public static bbgg a(Context paramContext, int paramInt, String paramString1, CharSequence paramCharSequence, String paramString2, String paramString3, String paramString4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    return a(paramContext, paramInt, paramString1, paramCharSequence, paramString2, paramString3, paramString4, paramOnClickListener1, paramOnClickListener2, null);
  }
  
  public static bbgg a(Context paramContext, int paramInt, String paramString1, CharSequence paramCharSequence, String paramString2, String paramString3, String paramString4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnClickListener paramOnClickListener3)
  {
    bbgg localbbgg = new bbgg(paramContext, 2131755791);
    localbbgg.setContentView(2131558910);
    if (paramInt != 0) {
      localbbgg.setOperateImage(paramContext.getResources().getDrawable(paramInt));
    }
    for (;;)
    {
      localbbgg.setMessage(paramCharSequence);
      localbbgg.setNegativeButton(paramString2, paramOnClickListener1);
      localbbgg.setPositiveButton(paramString3, paramOnClickListener2);
      localbbgg.setCanceledOnTouchOutside(false);
      paramString1 = (TextView)localbbgg.findViewById(2131365127);
      paramContext = paramString4;
      if (paramString4 == null) {
        paramContext = ajyc.a(2131703297);
      }
      paramString1.setText(paramContext);
      if (paramOnClickListener3 == null) {
        break;
      }
      paramString1.setOnClickListener(new bbdc(paramOnClickListener3, localbbgg));
      return localbbgg;
      localbbgg.setTitle(paramString1);
    }
    paramString1.setOnClickListener(new bbdd(localbbgg));
    return localbbgg;
  }
  
  public static bbgg a(Context paramContext, int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new bbgg(paramContext, 2131755791);
    paramContext.setContentView(2131558906);
    paramContext.setTitle(paramString1);
    paramContext.setMessage(paramString2);
    paramContext.setNegativeButton(paramInt2, paramOnClickListener2);
    paramContext.setPositiveButton(paramInt3, paramOnClickListener1);
    paramContext.setCanceledOnTouchOutside(false);
    return paramContext;
  }
  
  public static bbgg a(Context paramContext, int paramInt, String paramString1, String paramString2, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    return a(paramContext, paramInt, paramString1, paramString2, 2131690596, 2131694793, paramOnClickListener1, paramOnClickListener2);
  }
  
  public static bbgg a(Context paramContext, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt2, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new bbgg(paramContext, 2131755791);
    paramContext.setContentView(2131558906);
    paramContext.setTitle(paramString1);
    paramContext.setMessage(paramString2);
    paramContext.setNegativeButton(paramString3, paramOnClickListener2);
    paramContext.setPositiveButton(paramString4, paramInt2, paramOnClickListener1);
    paramContext.setCanceledOnTouchOutside(false);
    return paramContext;
  }
  
  public static bbgg a(Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new bbgg(paramContext, 2131755791);
    paramContext.setContentView(2131558906);
    paramContext.setTitle(paramString1);
    paramContext.setMessage(paramString2);
    paramContext.setNegativeButton(paramString3, paramOnClickListener2);
    paramContext.setPositiveButton(paramString4, paramOnClickListener1);
    paramContext.setCanceledOnTouchOutside(false);
    paramString1 = (TextView)paramContext.findViewById(2131365125);
    paramString1 = (TextView)paramContext.findViewById(2131365147);
    paramString2 = new LinearLayout.LayoutParams(-2, -2);
    paramString2.gravity = 17;
    paramString1.setLayoutParams(paramString2);
    return paramContext;
  }
  
  public static bbgg a(Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnClickListener paramOnClickListener3)
  {
    paramContext = new bbgg(paramContext, 2131755791);
    paramContext.setContentView(2131558890);
    paramContext.setTitle(paramString1);
    paramContext.setMessage(paramString2);
    paramContext.setNegativeButton(paramString4, paramOnClickListener3);
    paramContext.setPositiveButton(paramString5, paramOnClickListener2);
    paramContext.setCanceledOnTouchOutside(false);
    paramContext.setCheckBox(paramString3, paramOnClickListener1);
    return paramContext;
  }
  
  public static bbgg a(Context paramContext, String paramString1, String paramString2, DialogInterface.OnClickListener paramOnClickListener)
  {
    paramContext = new bbgg(paramContext, 2131755791);
    paramContext.setContentView(2131558903);
    paramContext.setTitle(paramString1);
    paramContext.setNegativeButton(paramString2, paramOnClickListener);
    paramContext.setCanceledOnTouchOutside(false);
    return paramContext;
  }
  
  public static bbgg a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = a(paramContext, 230, paramString1, paramString2, paramInt1, paramInt2, paramOnClickListener1, paramOnClickListener2);
    paramContext.setEditLint(paramString3);
    return paramContext;
  }
  
  public static bbgg a(Context paramContext, String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener1, String paramString4, DialogInterface.OnClickListener paramOnClickListener2, View.OnClickListener paramOnClickListener)
  {
    paramContext = new bbgg(paramContext, 2131755791);
    paramContext.setContentView(2131558885);
    TextView localTextView1 = (TextView)paramContext.findViewById(2131365151);
    TextView localTextView2 = (TextView)paramContext.findViewById(2131365147);
    ImageView localImageView = (ImageView)paramContext.findViewById(2131364259);
    localTextView1.setText(paramString1);
    localTextView2.setText(paramString2);
    paramContext.setNegativeButton(paramString3, paramOnClickListener1);
    paramContext.setPositiveButton(paramString4, paramOnClickListener2);
    localImageView.setOnClickListener(paramOnClickListener);
    paramContext.setCanceledOnTouchOutside(false);
    paramContext.setCancelable(false);
    return paramContext;
  }
  
  public static bbgg a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new bbgg(paramContext, 2131755791);
    paramContext.setContentView(2131558893);
    paramContext.setTitleWithEmo(new ayki(a(paramString1), 3));
    paramContext.setMessage(new ayki(a(paramString2), 3));
    paramContext.setNegativeButton(paramString3, paramOnClickListener2);
    paramContext.setPositiveButton(paramString4, paramOnClickListener1);
    if ((paramString5 != null) && (!"".equals(paramString5))) {
      paramContext.setCheckBox(paramString5, null);
    }
    paramContext.setCanceledOnTouchOutside(false);
    return paramContext;
  }
  
  public static bbgu a(Context paramContext, int paramInt)
  {
    return a(paramContext, paramInt, null, null, "", "", "", null, null, null);
  }
  
  public static bbgu a(Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnClickListener paramOnClickListener3)
  {
    paramContext = new bbgu(paramContext, 2131755791);
    paramContext.setContentView(2131558909);
    paramContext.a(paramString1);
    paramContext.b(paramString2);
    paramContext.a(paramString4, paramOnClickListener1);
    paramContext.b(paramString5, paramOnClickListener2);
    paramContext.b(paramString4, paramOnClickListener3);
    paramContext.setCanceledOnTouchOutside(true);
    return paramContext;
  }
  
  public static bbhb a(Context paramContext, String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new bbhb(paramContext, 2131755791);
    paramContext.setContentView(2131558916);
    paramContext.setTitle(paramString1);
    paramContext.setMessage(paramString2);
    paramContext.setCanceledOnTouchOutside(false);
    paramContext.setCancelable(true);
    paramContext.b(paramString3);
    paramContext.setNegativeButton(2131690596, paramOnClickListener2);
    paramContext.setPositiveButton(2131690745, paramOnClickListener1);
    paramContext.show();
    return paramContext;
  }
  
  public static bbhb a(Context paramContext, String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, int paramInt)
  {
    return a(paramContext, paramString1, paramString2, paramString3, paramOnClickListener1, paramOnClickListener2, paramInt, false);
  }
  
  public static bbhb a(Context paramContext, String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, int paramInt, boolean paramBoolean)
  {
    paramContext = new bbhb(paramContext, 2131755791);
    paramContext.b(7);
    paramContext.a(paramBoolean);
    paramContext.setContentView(2131558916);
    paramContext.setTitle(paramString1);
    if (paramInt != 0) {
      paramContext.c(paramInt);
    }
    paramContext.setMessage(paramString2);
    paramContext.setCanceledOnTouchOutside(false);
    paramContext.setCancelable(true);
    paramContext.b(paramString3);
    paramContext.setNegativeButton(2131690596, paramOnClickListener2);
    paramContext.setPositiveButton(2131690745, paramOnClickListener1);
    paramContext.show();
    return paramContext;
  }
  
  public static bbhq a(Context paramContext, int paramInt1, int paramInt2, String paramString, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new bbhq(paramContext, 2131755791);
    paramContext.setContentView(2131558919);
    paramContext.setTitle(paramInt1);
    paramContext.setMessage(paramInt2);
    paramContext.setCanceledOnTouchOutside(false);
    paramContext.setCancelable(true);
    paramContext.a(paramString);
    paramContext.setNegativeButton(2131690596, paramOnClickListener2);
    paramContext.setPositiveButton(2131694793, paramOnClickListener1);
    paramContext.show();
    return paramContext;
  }
  
  public static bbhq a(Context paramContext, int paramInt1, int paramInt2, String paramString, TextWatcher paramTextWatcher, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new bbhq(paramContext, 2131755791);
    paramContext.setContentView(2131558919);
    paramContext.setTitle(paramInt1);
    paramContext.setMessage(paramInt2);
    paramContext.setCanceledOnTouchOutside(false);
    paramContext.setCancelable(true);
    paramContext.a(paramTextWatcher);
    paramContext.a(paramString);
    paramContext.setNegativeButton(2131690596, paramOnClickListener2);
    paramContext.setPositiveButton(2131694793, paramOnClickListener1);
    paramContext.show();
    return paramContext;
  }
  
  public static bbhs a(Context paramContext, String paramString1, String paramString2, String paramString3, ArrayList<String> paramArrayList, String paramString4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, int paramInt, boolean paramBoolean)
  {
    paramContext = new bbhs(paramContext, 2131755791);
    paramContext.a(paramBoolean);
    paramContext.setContentView(2131558921);
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
    paramContext.setNegativeButton(2131690596, paramOnClickListener2);
    paramContext.setPositiveButton(2131690745, paramOnClickListener1);
    paramContext.show();
    return paramContext;
  }
  
  public static bbhz a(Context paramContext, String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener1, String paramString4, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new bbhz(paramContext, 2131755791);
    paramContext.setContentView(2131558908);
    paramContext.a(paramString1.replace(ajyc.a(2131703312), ayla.c(21)).replace(ajyc.a(2131703256), ayla.c(18)).replace(ajyc.a(2131703295), ayla.c(86)).replace(ajyc.a(2131703314), ayla.c(55)).replace("\\U0001f60f", String.valueOf(Character.toChars(128527))).replace("\\U0001f60c", String.valueOf(Character.toChars(128524))));
    paramContext.a(paramString2.replace(ajyc.a(2131703294), ayla.c(21)).replace(ajyc.a(2131703283), ayla.c(18)).replace(ajyc.a(2131703302), ayla.c(86)).replace(ajyc.a(2131703309), ayla.c(55)).replace("\\U0001f60f", String.valueOf(Character.toChars(128527))).replace("\\U0001f60c", String.valueOf(Character.toChars(128524))), 2.0F);
    paramContext.a(2130839301, 2131690596, paramOnClickListener2);
    paramContext.a(paramString3.replace(ajyc.a(2131703261), ayla.c(21)).replace(ajyc.a(2131703313), ayla.c(18)).replace(ajyc.a(2131703316), ayla.c(86)).replace(ajyc.a(2131703258), ayla.c(55)).replace("\\U0001f60f", String.valueOf(Character.toChars(128527))).replace("\\U0001f60c", String.valueOf(Character.toChars(128524))), paramOnClickListener1);
    paramContext.setCanceledOnTouchOutside(false);
    return paramContext;
  }
  
  protected static String a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      return paramString.replace(ajyc.a(2131703319), ayla.c(21)).replace(ajyc.a(2131703278), ayla.c(18)).replace(ajyc.a(2131703259), ayla.c(86)).replace(ajyc.a(2131703288), ayla.c(55)).replace("\\U0001f60f", String.valueOf(Character.toChars(128527))).replace("\\U0001f60c", String.valueOf(Character.toChars(128524)));
    }
    return null;
  }
  
  public static String a(String... paramVarArgs)
  {
    String str2 = ajyc.a(2131703298);
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
          str1 = ajyc.a(2131703265);
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
            str1 = ajyc.a(2131703280);
          } else if ("android.permission.ACCESS_COARSE_LOCATION".equals(str3)) {
            str1 = ajyc.a(2131703269);
          } else if ("android.permission.ACCESS_FINE_LOCATION".equals(str3)) {
            str1 = ajyc.a(2131703287);
          } else if ("android.permission.READ_CALENDAR".equals(str3)) {
            str1 = ajyc.a(2131703299);
          } else if ("android.permission.WRITE_CALENDAR".equals(str3)) {
            str1 = ajyc.a(2131703305);
          } else if ("android.permission.SEND_SMS".equals(str3)) {
            str1 = ajyc.a(2131703263);
          } else if ("android.permission.READ_CONTACTS".equals(str3)) {
            str1 = ajyc.a(2131703270);
          } else if ("android.permission.WRITE_CONTACTS".equals(str3)) {
            str1 = ajyc.a(2131703308);
          } else if ("android.permission.WRITE_EXTERNAL_STORAGE".equals(str3)) {
            str1 = ajyc.a(2131707940);
          } else if ("android.permission.READ_EXTERNAL_STORAGE".equals(str3)) {
            str1 = ajyc.a(2131707938);
          }
        }
      }
      str1 = localStringBuilder.toString();
    }
    return String.format(str2, new Object[] { str1 });
  }
  
  public static bbgg b(Activity paramActivity)
  {
    bbda localbbda = new bbda(paramActivity);
    paramActivity = a(paramActivity, 230);
    paramActivity.setTitle(ajyc.a(2131710203));
    paramActivity.setMessage(ajyc.a(2131707939));
    paramActivity.setNegativeButton(ajyc.a(2131703293), localbbda);
    paramActivity.setPositiveButton(ajyc.a(2131703277), localbbda);
    paramActivity.show();
    return paramActivity;
  }
  
  public static bbgg b(Activity paramActivity, String paramString1, String paramString2)
  {
    bbcx localbbcx = new bbcx(paramActivity);
    return a(paramActivity, paramString1, paramString2, localbbcx, localbbcx, null);
  }
  
  public static bbgg b(Activity paramActivity, String paramString1, String paramString2, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    bbgg localbbgg = a(paramActivity, 230);
    String str;
    if (paramString1 != null)
    {
      str = paramString1;
      if (!paramString1.equals("")) {}
    }
    else
    {
      str = paramActivity.getResources().getString(2131695757);
    }
    localbbgg.setTitle(str);
    if (paramString2 != null)
    {
      paramString1 = paramString2;
      if (!paramString2.equals("")) {}
    }
    else
    {
      paramString1 = paramActivity.getResources().getString(2131695754);
    }
    localbbgg.setMessage(paramString1);
    localbbgg.setNegativeButton(paramActivity.getResources().getString(2131690596), paramOnClickListener1);
    localbbgg.setPositiveButton(paramActivity.getResources().getString(2131694793), paramOnClickListener2);
    localbbgg.setOnCancelListener(paramOnCancelListener);
    localbbgg.show();
    return localbbgg;
  }
  
  public static bbgg b(Context paramContext, int paramInt)
  {
    return b(paramContext, paramInt, null, null, 2131690596, 2131694793, null, null);
  }
  
  public static bbgg b(Context paramContext, int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new bbgg(paramContext, 2131755791);
    paramContext.setContentView(2131558906);
    paramContext.setTitle(paramString1);
    paramContext.setMessageWithUrl(paramString2);
    paramContext.setNegativeButton(paramInt2, paramOnClickListener2);
    paramContext.setPositiveButton(paramInt3, paramOnClickListener1);
    paramContext.setCanceledOnTouchOutside(true);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbcv
 * JD-Core Version:    0.7.0.1
 */