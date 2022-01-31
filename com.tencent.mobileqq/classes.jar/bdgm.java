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

public class bdgm
{
  public static final HashMap<String, String> a = new HashMap();
  
  static
  {
    a.put("android.permission.READ_EXTERNAL_STORAGE", alud.a(2131703669));
    a.put("android.permission.WRITE_EXTERNAL_STORAGE", alud.a(2131703684));
    a.put("android.permission.READ_PHONE_STATE", "QQ使用电话权限确定本机号码和设备ID，以保证帐号登录的安全性。QQ不会拨打其他号码或终止通话。\n" + alud.a(2131703655));
    a.put("android.permission.CAMERA", alud.a(2131703696));
    a.put("android.permission.RECORD_AUDIO", alud.a(2131703667));
    a.put("android.permission.ACCESS_COARSE_LOCATION", alud.a(2131703662));
    a.put("android.permission.ACCESS_FINE_LOCATION", alud.a(2131703668));
    a.put("android.permission.READ_CALENDAR", alud.a(2131703712));
    a.put("android.permission.WRITE_CALENDAR", alud.a(2131703710));
    a.put("android.permission.SEND_SMS", alud.a(2131703698));
    a.put("android.permission.READ_CONTACTS", alud.a(2131703687));
    a.put("android.permission.WRITE_CONTACTS", alud.a(2131703705));
  }
  
  public static Dialog a(Activity paramActivity, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2)
  {
    paramActivity = bdap.a(paramActivity, 2131698702, 2131698700, 2131698699, 2131698701, paramOnClickListener1, paramOnClickListener2);
    paramActivity.setCancelable(false);
    return paramActivity;
  }
  
  public static Dialog a(Context paramContext, int paramInt1, bdgy parambdgy, Object paramObject, int paramInt2, int paramInt3, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject1 = paramContext.getResources();
    String str2 = ((Resources)localObject1).getString(paramInt2);
    String str1 = ((Resources)localObject1).getString(paramInt3);
    paramContext = new Dialog(paramContext, 2131755801);
    paramContext.setContentView(2131558947);
    Object localObject2 = (TextView)paramContext.findViewById(2131365237);
    FrameLayout localFrameLayout = (FrameLayout)paramContext.findViewById(2131365238);
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
      localObject1 = (TextView)paramContext.findViewById(2131365222);
      if (localObject1 != null)
      {
        ((TextView)localObject1).setText(str2);
        ((TextView)localObject1).setContentDescription(str2);
        ((TextView)localObject1).setOnClickListener(paramOnClickListener1);
        if (paramBoolean1) {
          ((TextView)localObject1).getPaint().setFakeBoldText(true);
        }
      }
      paramOnClickListener1 = (TextView)paramContext.findViewById(2131365228);
      if (paramOnClickListener1 != null)
      {
        paramOnClickListener1.setText(str1);
        paramOnClickListener1.setContentDescription(str1);
        paramOnClickListener1.setOnClickListener(paramOnClickListener2);
        if (paramBoolean2) {
          paramOnClickListener1.getPaint().setFakeBoldText(true);
        }
      }
      localFrameLayout.addView(parambdgy.a(localFrameLayout.getContext(), paramObject));
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
    paramContext.setContentView(2131558919);
    Object localObject2 = (TextView)paramContext.findViewById(2131365237);
    TextView localTextView = (TextView)paramContext.findViewById(2131365233);
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
      paramString = (TextView)paramContext.findViewById(2131365222);
      if (paramString != null)
      {
        paramString.setText(str2);
        paramString.setContentDescription(str2);
        paramString.setOnClickListener(paramOnClickListener1);
        if (paramBoolean1) {
          paramString.getPaint().setFakeBoldText(true);
        }
      }
      paramString = (TextView)paramContext.findViewById(2131365228);
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
    paramContext.setContentView(2131558953);
    ImageView localImageView = (ImageView)paramContext.findViewById(2131367819);
    TextView localTextView1 = (TextView)paramContext.findViewById(2131377938);
    TextView localTextView2 = (TextView)paramContext.findViewById(2131364771);
    TextView localTextView3 = (TextView)paramContext.findViewById(2131363909);
    TextView localTextView4 = (TextView)paramContext.findViewById(2131364689);
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
    paramContext.setContentView(2131560689);
    ImageView localImageView = (ImageView)paramContext.findViewById(2131379296);
    TextView localTextView1 = (TextView)paramContext.findViewById(2131379297);
    TextView localTextView2 = (TextView)paramContext.findViewById(2131379298);
    TextView localTextView3 = (TextView)paramContext.findViewById(2131379292);
    TextView localTextView4 = (TextView)paramContext.findViewById(2131379293);
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
    paramContext.setContentView(2131558961);
    ImageView localImageView = (ImageView)paramContext.findViewById(2131379296);
    TextView localTextView1 = (TextView)paramContext.findViewById(2131365237);
    TextView localTextView2 = (TextView)paramContext.findViewById(2131379297);
    TextView localTextView3 = (TextView)paramContext.findViewById(2131379298);
    TextView localTextView4 = (TextView)paramContext.findViewById(2131379292);
    TextView localTextView5 = (TextView)paramContext.findViewById(2131379293);
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
    paramContext.setContentView(2131560906);
    ((TextView)paramContext.findViewById(2131365271)).setVisibility(8);
    TextView localTextView1 = (TextView)paramContext.findViewById(2131365260);
    TextView localTextView2 = (TextView)paramContext.findViewById(2131365258);
    TextView localTextView3 = (TextView)paramContext.findViewById(2131365264);
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
  
  public static Dialog a(Context paramContext, String paramString, CharSequence paramCharSequence, int paramInt1, int paramInt2, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, benw parambenw)
  {
    paramContext = new Dialog(paramContext, 2131755801);
    paramContext.setContentView(2131560906);
    TextView localTextView3 = (TextView)paramContext.findViewById(2131365271);
    ClickableColorSpanTextView localClickableColorSpanTextView = (ClickableColorSpanTextView)paramContext.findViewById(2131365260);
    TextView localTextView1 = (TextView)paramContext.findViewById(2131365258);
    TextView localTextView2 = (TextView)paramContext.findViewById(2131365264);
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
      paramString = new bdgn(paramOnClickListener1, paramContext, paramOnClickListener2);
      localTextView1.setOnClickListener(paramString);
      localTextView2.setOnClickListener(paramString);
      localClickableColorSpanTextView.setSpanClickListener(parambenw);
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
    return a(paramContext, paramContext.getResources().getDrawable(2130849056), paramInt);
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
      ((TextView)paramContext.findViewById(2131365233)).setText(paramInt1);
      ((ProgressBar)paramContext.findViewById(2131366695)).setIndeterminateDrawable(paramDrawable);
      return paramContext;
    }
    catch (Exception localException)
    {
      break label26;
    }
  }
  
  public static bdio a(Activity paramActivity, String paramString1, long paramLong, String paramString2, CharSequence paramCharSequence)
  {
    paramActivity = new bdio(paramActivity);
    paramActivity.a(new bamp(a(paramString1), 3)).b(new bamp(a(paramString2), 3)).a(paramLong).c(paramCharSequence);
    paramActivity.setCanceledOnTouchOutside(false);
    paramActivity.setCancelable(true);
    return paramActivity;
  }
  
  public static bdjq a(Context paramContext, String paramString, Bundle paramBundle)
  {
    bdjq localbdjq = new bdjq(paramContext, 2131755801);
    localbdjq.a(paramContext, paramBundle);
    localbdjq.setTitle(paramString);
    localbdjq.setCanceledOnTouchOutside(false);
    localbdjq.setCancelable(true);
    return localbdjq;
  }
  
  public static bdjq a(Context paramContext, String paramString, Bundle paramBundle, int paramInt)
  {
    bdjq localbdjq = new bdjq(paramContext, 2131755801);
    localbdjq.a(paramContext, paramBundle);
    localbdjq.setTitle(paramString);
    localbdjq.setCanceledOnTouchOutside(false);
    localbdjq.setCancelable(true);
    if (paramInt > 0) {
      localbdjq.c(paramInt);
    }
    return localbdjq;
  }
  
  public static bdju a(Context paramContext, String paramString, Bundle paramBundle)
  {
    bdju localbdju = new bdju(paramContext, 2131755801);
    localbdju.a(paramContext, paramBundle);
    localbdju.setTitle(paramString);
    localbdju.setCanceledOnTouchOutside(true);
    localbdju.setCancelable(true);
    return localbdju;
  }
  
  public static bdjy a(Context paramContext, bdpi parambdpi, DialogInterface.OnClickListener paramOnClickListener)
  {
    if ((parambdpi == null) || (parambdpi.a() <= 0)) {
      return null;
    }
    paramContext = new bdjy(paramContext, 2131755801);
    paramContext.setCanceledOnTouchOutside(true);
    paramContext.setContentView(2131558942);
    paramContext.a(parambdpi, paramOnClickListener);
    paramContext.a(2131558932);
    ((LinearLayout)paramContext.findViewById(2131363484)).setLayoutParams(new RelativeLayout.LayoutParams(-1, 0));
    parambdpi = (ListView)paramContext.findViewById(2131369519);
    paramOnClickListener = new RelativeLayout.LayoutParams(-1, -2);
    paramOnClickListener.addRule(3, 2131365237);
    parambdpi.setLayoutParams(paramOnClickListener);
    return paramContext;
  }
  
  public static bdjz a(Activity paramActivity)
  {
    bdjz localbdjz = a(paramActivity, 230);
    localbdjz.setTitle(alud.a(2131703657));
    localbdjz.setMessage(2131694128);
    localbdjz.setNegativeButton(alud.a(2131703688), new bdgp(localbdjz));
    localbdjz.setPositiveButton(alud.a(2131715321), new bdgq(paramActivity));
    localbdjz.setOnCancelListener(null);
    localbdjz.show();
    return localbdjz;
  }
  
  public static bdjz a(Activity paramActivity, int paramInt)
  {
    return a(paramActivity, paramActivity.getString(paramInt), 2131690648, 2131694953, null, null);
  }
  
  public static bdjz a(Activity paramActivity, aznz paramaznz)
  {
    paramaznz = new bdgt(paramActivity, paramaznz);
    paramActivity = a(paramActivity, 230);
    paramActivity.setTitle(alud.a(2131710598));
    paramActivity.setMessage(alud.a(2131708334));
    paramActivity.setNegativeButton(alud.a(2131703688), paramaznz);
    paramActivity.setPositiveButton(alud.a(2131703672), paramaznz);
    paramActivity.show();
    return paramActivity;
  }
  
  public static bdjz a(Activity paramActivity, String paramString)
  {
    return a(paramActivity, paramString, 2131690648, 2131694953, null, null);
  }
  
  public static bdjz a(Activity paramActivity, String paramString, int paramInt1, int paramInt2, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramString = a(paramActivity, 230, null, paramString, paramInt1, paramInt2, paramOnClickListener1, paramOnClickListener2);
    if (paramString != null)
    {
      ((TextView)paramString.findViewById(2131365211)).setVisibility(8);
      ((TextView)paramString.findViewById(2131365233)).setMinHeight(bdaq.a(paramActivity, 35.0F));
    }
    return paramString;
  }
  
  public static bdjz a(Activity paramActivity, String paramString1, long paramLong, String paramString2, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    bdjz localbdjz = new bdjz(paramActivity, 2131755801);
    localbdjz.setContentView(2131558942);
    localbdjz.setTitle(paramString1);
    paramActivity = paramActivity.getLayoutInflater().inflate(2131558821, null);
    paramString1 = (TextView)paramActivity.findViewById(2131379206);
    String str = bdio.a((float)paramLong, true, 2);
    if (!TextUtils.isEmpty(str)) {
      paramString1.setText(alud.a(2131703676) + str);
    }
    ((TextView)paramActivity.findViewById(2131365233)).setText(paramString2);
    localbdjz.addView(paramActivity);
    localbdjz.setNegativeButton(alud.a(2131703652), paramOnClickListener1);
    localbdjz.setPositiveButton(alud.a(2131703701), paramOnClickListener2);
    localbdjz.setCanceledOnTouchOutside(false);
    return localbdjz;
  }
  
  public static bdjz a(Activity paramActivity, String paramString1, String paramString2)
  {
    bdgw localbdgw = new bdgw(paramActivity);
    bdjz localbdjz = a(paramActivity, 230);
    if (paramString1 != null)
    {
      paramActivity = paramString1;
      if (!paramString1.equals("")) {}
    }
    else
    {
      paramActivity = alud.a(2131703661);
    }
    localbdjz.setTitle(paramActivity);
    if (paramString2 != null)
    {
      paramActivity = paramString2;
      if (!paramString2.equals("")) {}
    }
    else
    {
      paramActivity = alud.a(2131703713);
    }
    localbdjz.setMessage(paramActivity);
    localbdjz.setPositiveButton(alud.a(2131703716), localbdgw);
    localbdjz.show();
    return localbdjz;
  }
  
  public static bdjz a(Activity paramActivity, String paramString1, String paramString2, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    bdjz localbdjz = a(paramActivity, 230);
    if (paramString1 != null)
    {
      paramActivity = paramString1;
      if (!paramString1.equals("")) {}
    }
    else
    {
      paramActivity = alud.a(2131703657);
    }
    localbdjz.setTitle(paramActivity);
    if (paramString2 != null)
    {
      paramActivity = paramString2;
      if (!paramString2.equals("")) {}
    }
    else
    {
      paramActivity = alud.a(2131703695);
    }
    localbdjz.setMessage(paramActivity);
    localbdjz.setNegativeButton(alud.a(2131703688), paramOnClickListener1);
    localbdjz.setPositiveButton(alud.a(2131703672), paramOnClickListener2);
    localbdjz.setOnCancelListener(paramOnCancelListener);
    localbdjz.show();
    return localbdjz;
  }
  
  public static bdjz a(Activity paramActivity, String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener)
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
  
  public static bdjz a(Activity paramActivity, String[] paramArrayOfString, int[] paramArrayOfInt)
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
  
  public static bdjz a(Context paramContext, int paramInt)
  {
    return a(paramContext, paramInt, null, null, 2131690648, 2131694953, null, null);
  }
  
  public static bdjz a(Context paramContext, int paramInt1, int paramInt2, String paramString, CharSequence paramCharSequence, int paramInt3, int paramInt4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new bdjz(paramContext, 2131755801);
    paramContext.setContentView(paramInt2);
    paramContext.setTitle(paramString);
    paramContext.setMessageWithoutAutoLink(paramCharSequence);
    paramContext.setNegativeButton(paramInt3, paramOnClickListener2);
    paramContext.setPositiveButton(paramInt4, paramOnClickListener1);
    paramContext.setCanceledOnTouchOutside(true);
    return paramContext;
  }
  
  public static bdjz a(Context paramContext, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new bdjz(paramContext, 2131755801);
    paramContext.setContentView(paramInt2);
    paramContext.setTitle(paramString1);
    paramContext.setMessage(paramString2);
    paramContext.setNegativeButton(paramString3, paramOnClickListener2);
    paramContext.setPositiveButton(paramString4, paramOnClickListener1);
    paramContext.setCanceledOnTouchOutside(false);
    return paramContext;
  }
  
  public static bdjz a(Context paramContext, int paramInt1, String paramString, CharSequence paramCharSequence, int paramInt2, int paramInt3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    return a(paramContext, paramInt1, 2131558942, paramString, paramCharSequence, paramInt2, paramInt3, paramOnClickListener1, paramOnClickListener2);
  }
  
  public static bdjz a(Context paramContext, int paramInt, String paramString1, CharSequence paramCharSequence, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new bdjz(paramContext, 2131755801);
    paramContext.setContentView(2131558942);
    paramContext.setTitle(paramString1);
    paramContext.setMessage(paramCharSequence);
    paramContext.setNegativeButton(paramString2, paramOnClickListener2);
    paramContext.setPositiveButton(paramString3, paramOnClickListener1);
    paramContext.setCanceledOnTouchOutside(false);
    return paramContext;
  }
  
  public static bdjz a(Context paramContext, int paramInt, String paramString1, CharSequence paramCharSequence, String paramString2, String paramString3, String paramString4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    return a(paramContext, paramInt, paramString1, paramCharSequence, paramString2, paramString3, paramString4, paramOnClickListener1, paramOnClickListener2, null);
  }
  
  public static bdjz a(Context paramContext, int paramInt, String paramString1, CharSequence paramCharSequence, String paramString2, String paramString3, String paramString4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnClickListener paramOnClickListener3)
  {
    bdjz localbdjz = new bdjz(paramContext, 2131755801);
    localbdjz.setContentView(2131558946);
    if (paramInt != 0) {
      localbdjz.setOperateImage(paramContext.getResources().getDrawable(paramInt));
    }
    for (;;)
    {
      localbdjz.setMessage(paramCharSequence);
      localbdjz.setNegativeButton(paramString2, paramOnClickListener1);
      localbdjz.setPositiveButton(paramString3, paramOnClickListener2);
      localbdjz.setCanceledOnTouchOutside(false);
      paramString1 = (TextView)localbdjz.findViewById(2131365213);
      paramContext = paramString4;
      if (paramString4 == null) {
        paramContext = alud.a(2131703692);
      }
      paramString1.setText(paramContext);
      if (paramOnClickListener3 == null) {
        break;
      }
      paramString1.setOnClickListener(new bdgu(paramOnClickListener3, localbdjz));
      return localbdjz;
      localbdjz.setTitle(paramString1);
    }
    paramString1.setOnClickListener(new bdgv(localbdjz));
    return localbdjz;
  }
  
  public static bdjz a(Context paramContext, int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new bdjz(paramContext, 2131755801);
    paramContext.setContentView(2131558942);
    paramContext.setTitle(paramString1);
    paramContext.setMessage(paramString2);
    paramContext.setNegativeButton(paramInt2, paramOnClickListener2);
    paramContext.setPositiveButton(paramInt3, paramOnClickListener1);
    paramContext.setCanceledOnTouchOutside(false);
    return paramContext;
  }
  
  public static bdjz a(Context paramContext, int paramInt, String paramString1, String paramString2, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    return a(paramContext, paramInt, paramString1, paramString2, 2131690648, 2131694953, paramOnClickListener1, paramOnClickListener2);
  }
  
  public static bdjz a(Context paramContext, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt2, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new bdjz(paramContext, 2131755801);
    paramContext.setContentView(2131558942);
    paramContext.setTitle(paramString1);
    paramContext.setMessage(paramString2);
    paramContext.setNegativeButton(paramString3, paramOnClickListener2);
    paramContext.setPositiveButton(paramString4, paramInt2, paramOnClickListener1);
    paramContext.setCanceledOnTouchOutside(false);
    return paramContext;
  }
  
  public static bdjz a(Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new bdjz(paramContext, 2131755801);
    paramContext.setContentView(2131558942);
    paramContext.setTitle(paramString1);
    paramContext.setMessage(paramString2);
    paramContext.setNegativeButton(paramString3, paramOnClickListener2);
    paramContext.setPositiveButton(paramString4, paramOnClickListener1);
    paramContext.setCanceledOnTouchOutside(false);
    paramString1 = (TextView)paramContext.findViewById(2131365211);
    paramString1 = (TextView)paramContext.findViewById(2131365233);
    paramString2 = new LinearLayout.LayoutParams(-2, -2);
    paramString2.gravity = 17;
    paramString1.setLayoutParams(paramString2);
    return paramContext;
  }
  
  public static bdjz a(Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnClickListener paramOnClickListener3)
  {
    paramContext = new bdjz(paramContext, 2131755801);
    paramContext.setContentView(2131558926);
    paramContext.setTitle(paramString1);
    paramContext.setMessage(paramString2);
    paramContext.setNegativeButton(paramString4, paramOnClickListener3);
    paramContext.setPositiveButton(paramString5, paramOnClickListener2);
    paramContext.setCanceledOnTouchOutside(false);
    paramContext.setCheckBox(paramString3, paramOnClickListener1);
    return paramContext;
  }
  
  public static bdjz a(Context paramContext, String paramString1, String paramString2, DialogInterface.OnClickListener paramOnClickListener)
  {
    paramContext = new bdjz(paramContext, 2131755801);
    paramContext.setContentView(2131558939);
    paramContext.setTitle(paramString1);
    paramContext.setNegativeButton(paramString2, paramOnClickListener);
    paramContext.setCanceledOnTouchOutside(false);
    return paramContext;
  }
  
  public static bdjz a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = a(paramContext, 230, paramString1, paramString2, paramInt1, paramInt2, paramOnClickListener1, paramOnClickListener2);
    paramContext.setEditLint(paramString3);
    return paramContext;
  }
  
  public static bdjz a(Context paramContext, String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener1, String paramString4, DialogInterface.OnClickListener paramOnClickListener2, View.OnClickListener paramOnClickListener)
  {
    paramContext = new bdjz(paramContext, 2131755801);
    paramContext.setContentView(2131558921);
    TextView localTextView1 = (TextView)paramContext.findViewById(2131365237);
    TextView localTextView2 = (TextView)paramContext.findViewById(2131365233);
    ImageView localImageView = (ImageView)paramContext.findViewById(2131364327);
    localTextView1.setText(paramString1);
    localTextView2.setText(paramString2);
    paramContext.setNegativeButton(paramString3, paramOnClickListener1);
    paramContext.setPositiveButton(paramString4, paramOnClickListener2);
    localImageView.setOnClickListener(paramOnClickListener);
    paramContext.setCanceledOnTouchOutside(false);
    paramContext.setCancelable(false);
    return paramContext;
  }
  
  public static bdjz a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new bdjz(paramContext, 2131755801);
    paramContext.setContentView(2131558929);
    paramContext.setTitleWithEmo(new bamp(a(paramString1), 3));
    paramContext.setMessage(new bamp(a(paramString2), 3));
    paramContext.setNegativeButton(paramString3, paramOnClickListener2);
    paramContext.setPositiveButton(paramString4, paramOnClickListener1);
    if ((paramString5 != null) && (!"".equals(paramString5))) {
      paramContext.setCheckBox(paramString5, null);
    }
    paramContext.setCanceledOnTouchOutside(false);
    return paramContext;
  }
  
  public static bdkn a(Context paramContext, int paramInt)
  {
    return a(paramContext, paramInt, null, null, "", "", "", null, null, null);
  }
  
  public static bdkn a(Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnClickListener paramOnClickListener3)
  {
    paramContext = new bdkn(paramContext, 2131755801);
    paramContext.setContentView(2131558945);
    paramContext.a(paramString1);
    paramContext.b(paramString2);
    paramContext.a(paramString4, paramOnClickListener1);
    paramContext.b(paramString5, paramOnClickListener2);
    paramContext.b(paramString4, paramOnClickListener3);
    paramContext.setCanceledOnTouchOutside(true);
    return paramContext;
  }
  
  public static bdku a(Context paramContext, String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new bdku(paramContext, 2131755801);
    paramContext.setContentView(2131558952);
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
  
  public static bdku a(Context paramContext, String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, int paramInt)
  {
    return a(paramContext, paramString1, paramString2, paramString3, paramOnClickListener1, paramOnClickListener2, paramInt, false);
  }
  
  public static bdku a(Context paramContext, String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, int paramInt, boolean paramBoolean)
  {
    paramContext = new bdku(paramContext, 2131755801);
    paramContext.b(7);
    paramContext.a(paramBoolean);
    paramContext.setContentView(2131558952);
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
  
  public static bdlj a(Context paramContext, int paramInt1, int paramInt2, String paramString, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new bdlj(paramContext, 2131755801);
    paramContext.setContentView(2131558955);
    paramContext.setTitle(paramInt1);
    paramContext.setMessage(paramInt2);
    paramContext.setCanceledOnTouchOutside(false);
    paramContext.setCancelable(true);
    paramContext.a(paramString);
    paramContext.setNegativeButton(2131690648, paramOnClickListener2);
    paramContext.setPositiveButton(2131694953, paramOnClickListener1);
    paramContext.show();
    return paramContext;
  }
  
  public static bdlj a(Context paramContext, int paramInt1, int paramInt2, String paramString, TextWatcher paramTextWatcher, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new bdlj(paramContext, 2131755801);
    paramContext.setContentView(2131558955);
    paramContext.setTitle(paramInt1);
    paramContext.setMessage(paramInt2);
    paramContext.setCanceledOnTouchOutside(false);
    paramContext.setCancelable(true);
    paramContext.a(paramTextWatcher);
    paramContext.a(paramString);
    paramContext.setNegativeButton(2131690648, paramOnClickListener2);
    paramContext.setPositiveButton(2131694953, paramOnClickListener1);
    paramContext.show();
    return paramContext;
  }
  
  public static bdll a(Context paramContext, String paramString1, String paramString2, String paramString3, ArrayList<String> paramArrayList, String paramString4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, int paramInt, boolean paramBoolean)
  {
    paramContext = new bdll(paramContext, 2131755801);
    paramContext.a(paramBoolean);
    paramContext.setContentView(2131558957);
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
  
  public static bdls a(Context paramContext, String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener1, String paramString4, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new bdls(paramContext, 2131755801);
    paramContext.setContentView(2131558944);
    paramContext.a(paramString1.replace(alud.a(2131703707), banh.c(21)).replace(alud.a(2131703651), banh.c(18)).replace(alud.a(2131703690), banh.c(86)).replace(alud.a(2131703709), banh.c(55)).replace("\\U0001f60f", String.valueOf(Character.toChars(128527))).replace("\\U0001f60c", String.valueOf(Character.toChars(128524))));
    paramContext.a(paramString2.replace(alud.a(2131703689), banh.c(21)).replace(alud.a(2131703678), banh.c(18)).replace(alud.a(2131703697), banh.c(86)).replace(alud.a(2131703704), banh.c(55)).replace("\\U0001f60f", String.valueOf(Character.toChars(128527))).replace("\\U0001f60c", String.valueOf(Character.toChars(128524))), 2.0F);
    paramContext.a(2130839391, 2131690648, paramOnClickListener2);
    paramContext.a(paramString3.replace(alud.a(2131703656), banh.c(21)).replace(alud.a(2131703708), banh.c(18)).replace(alud.a(2131703711), banh.c(86)).replace(alud.a(2131703653), banh.c(55)).replace("\\U0001f60f", String.valueOf(Character.toChars(128527))).replace("\\U0001f60c", String.valueOf(Character.toChars(128524))), paramOnClickListener1);
    paramContext.setCanceledOnTouchOutside(false);
    return paramContext;
  }
  
  protected static String a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      return paramString.replace(alud.a(2131703714), banh.c(21)).replace(alud.a(2131703673), banh.c(18)).replace(alud.a(2131703654), banh.c(86)).replace(alud.a(2131703683), banh.c(55)).replace("\\U0001f60f", String.valueOf(Character.toChars(128527))).replace("\\U0001f60c", String.valueOf(Character.toChars(128524)));
    }
    return null;
  }
  
  public static String a(String... paramVarArgs)
  {
    String str2 = alud.a(2131703693);
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
          str1 = alud.a(2131703660);
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
            str1 = alud.a(2131703675);
          } else if ("android.permission.ACCESS_COARSE_LOCATION".equals(str3)) {
            str1 = alud.a(2131703664);
          } else if ("android.permission.ACCESS_FINE_LOCATION".equals(str3)) {
            str1 = alud.a(2131703682);
          } else if ("android.permission.READ_CALENDAR".equals(str3)) {
            str1 = alud.a(2131703694);
          } else if ("android.permission.WRITE_CALENDAR".equals(str3)) {
            str1 = alud.a(2131703700);
          } else if ("android.permission.SEND_SMS".equals(str3)) {
            str1 = alud.a(2131703658);
          } else if ("android.permission.READ_CONTACTS".equals(str3)) {
            str1 = alud.a(2131703665);
          } else if ("android.permission.WRITE_CONTACTS".equals(str3)) {
            str1 = alud.a(2131703703);
          } else if ("android.permission.WRITE_EXTERNAL_STORAGE".equals(str3)) {
            str1 = alud.a(2131708335);
          } else if ("android.permission.READ_EXTERNAL_STORAGE".equals(str3)) {
            str1 = alud.a(2131708333);
          }
        }
      }
      str1 = localStringBuilder.toString();
    }
    return String.format(str2, new Object[] { str1 });
  }
  
  public static bdjz b(Activity paramActivity)
  {
    bdgr localbdgr = new bdgr(paramActivity);
    paramActivity = a(paramActivity, 230);
    paramActivity.setTitle(alud.a(2131710598));
    paramActivity.setMessage(alud.a(2131708334));
    paramActivity.setNegativeButton(alud.a(2131703688), localbdgr);
    paramActivity.setPositiveButton(alud.a(2131703672), localbdgr);
    paramActivity.show();
    return paramActivity;
  }
  
  public static bdjz b(Activity paramActivity, String paramString)
  {
    bdgs localbdgs = new bdgs(paramActivity);
    paramActivity = a(paramActivity, 230);
    paramActivity.setTitle(alud.a(2131710598));
    paramActivity.setMessage(paramString);
    paramActivity.setNegativeButton(alud.a(2131703688), localbdgs);
    paramActivity.setPositiveButton(alud.a(2131703672), localbdgs);
    paramActivity.show();
    return paramActivity;
  }
  
  public static bdjz b(Activity paramActivity, String paramString1, String paramString2)
  {
    bdgo localbdgo = new bdgo(paramActivity);
    return a(paramActivity, paramString1, paramString2, localbdgo, localbdgo, null);
  }
  
  public static bdjz b(Activity paramActivity, String paramString1, String paramString2, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    bdjz localbdjz = a(paramActivity, 230);
    String str;
    if (paramString1 != null)
    {
      str = paramString1;
      if (!paramString1.equals("")) {}
    }
    else
    {
      str = paramActivity.getResources().getString(2131695920);
    }
    localbdjz.setTitle(str);
    if (paramString2 != null)
    {
      paramString1 = paramString2;
      if (!paramString2.equals("")) {}
    }
    else
    {
      paramString1 = paramActivity.getResources().getString(2131695917);
    }
    localbdjz.setMessage(paramString1);
    localbdjz.setNegativeButton(paramActivity.getResources().getString(2131690648), paramOnClickListener1);
    localbdjz.setPositiveButton(paramActivity.getResources().getString(2131694953), paramOnClickListener2);
    localbdjz.setOnCancelListener(paramOnCancelListener);
    localbdjz.show();
    return localbdjz;
  }
  
  public static bdjz b(Context paramContext, int paramInt)
  {
    return b(paramContext, paramInt, null, null, 2131690648, 2131694953, null, null);
  }
  
  public static bdjz b(Context paramContext, int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new bdjz(paramContext, 2131755801);
    paramContext.setContentView(2131558942);
    paramContext.setTitle(paramString1);
    paramContext.setMessageWithUrl(paramString2);
    paramContext.setNegativeButton(paramInt2, paramOnClickListener2);
    paramContext.setPositiveButton(paramInt3, paramOnClickListener1);
    paramContext.setCanceledOnTouchOutside(true);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bdgm
 * JD-Core Version:    0.7.0.1
 */