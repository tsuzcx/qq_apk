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

public class bbdj
{
  public static final HashMap<String, String> a = new HashMap();
  
  static
  {
    a.put("android.permission.READ_EXTERNAL_STORAGE", ajya.a(2131703285));
    a.put("android.permission.WRITE_EXTERNAL_STORAGE", ajya.a(2131703300));
    a.put("android.permission.READ_PHONE_STATE", "QQ使用电话权限确定本机号码和设备ID，以保证帐号登录的安全性。QQ不会拨打其他号码或终止通话。\n" + ajya.a(2131703271));
    a.put("android.permission.CAMERA", ajya.a(2131703312));
    a.put("android.permission.RECORD_AUDIO", ajya.a(2131703283));
    a.put("android.permission.ACCESS_COARSE_LOCATION", ajya.a(2131703278));
    a.put("android.permission.ACCESS_FINE_LOCATION", ajya.a(2131703284));
    a.put("android.permission.READ_CALENDAR", ajya.a(2131703328));
    a.put("android.permission.WRITE_CALENDAR", ajya.a(2131703326));
    a.put("android.permission.SEND_SMS", ajya.a(2131703314));
    a.put("android.permission.READ_CONTACTS", ajya.a(2131703303));
    a.put("android.permission.WRITE_CONTACTS", ajya.a(2131703321));
  }
  
  public static Dialog a(Activity paramActivity, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2)
  {
    paramActivity = baxm.a(paramActivity, 2131698400, 2131698398, 2131698397, 2131698399, paramOnClickListener1, paramOnClickListener2);
    paramActivity.setCancelable(false);
    return paramActivity;
  }
  
  public static Dialog a(Context paramContext, int paramInt1, bbdu parambbdu, Object paramObject, int paramInt2, int paramInt3, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject1 = paramContext.getResources();
    String str2 = ((Resources)localObject1).getString(paramInt2);
    String str1 = ((Resources)localObject1).getString(paramInt3);
    paramContext = new Dialog(paramContext, 2131755791);
    paramContext.setContentView(2131558911);
    Object localObject2 = (TextView)paramContext.findViewById(2131365150);
    FrameLayout localFrameLayout = (FrameLayout)paramContext.findViewById(2131365151);
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
      localObject1 = (TextView)paramContext.findViewById(2131365135);
      if (localObject1 != null)
      {
        ((TextView)localObject1).setText(str2);
        ((TextView)localObject1).setContentDescription(str2);
        ((TextView)localObject1).setOnClickListener(paramOnClickListener1);
        if (paramBoolean1) {
          ((TextView)localObject1).getPaint().setFakeBoldText(true);
        }
      }
      paramOnClickListener1 = (TextView)paramContext.findViewById(2131365141);
      if (paramOnClickListener1 != null)
      {
        paramOnClickListener1.setText(str1);
        paramOnClickListener1.setContentDescription(str1);
        paramOnClickListener1.setOnClickListener(paramOnClickListener2);
        if (paramBoolean2) {
          paramOnClickListener1.getPaint().setFakeBoldText(true);
        }
      }
      localFrameLayout.addView(parambbdu.a(localFrameLayout.getContext(), paramObject));
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
    Object localObject2 = (TextView)paramContext.findViewById(2131365150);
    TextView localTextView = (TextView)paramContext.findViewById(2131365146);
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
      paramString = (TextView)paramContext.findViewById(2131365135);
      if (paramString != null)
      {
        paramString.setText(str2);
        paramString.setContentDescription(str2);
        paramString.setOnClickListener(paramOnClickListener1);
        if (paramBoolean1) {
          paramString.getPaint().setFakeBoldText(true);
        }
      }
      paramString = (TextView)paramContext.findViewById(2131365141);
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
    TextView localTextView2 = (TextView)paramContext.findViewById(2131364691);
    TextView localTextView3 = (TextView)paramContext.findViewById(2131363851);
    TextView localTextView4 = (TextView)paramContext.findViewById(2131364610);
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
    paramContext.setContentView(2131560495);
    ImageView localImageView = (ImageView)paramContext.findViewById(2131378621);
    TextView localTextView1 = (TextView)paramContext.findViewById(2131378622);
    TextView localTextView2 = (TextView)paramContext.findViewById(2131378623);
    TextView localTextView3 = (TextView)paramContext.findViewById(2131378617);
    TextView localTextView4 = (TextView)paramContext.findViewById(2131378618);
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
    ImageView localImageView = (ImageView)paramContext.findViewById(2131378621);
    TextView localTextView1 = (TextView)paramContext.findViewById(2131365150);
    TextView localTextView2 = (TextView)paramContext.findViewById(2131378622);
    TextView localTextView3 = (TextView)paramContext.findViewById(2131378623);
    TextView localTextView4 = (TextView)paramContext.findViewById(2131378617);
    TextView localTextView5 = (TextView)paramContext.findViewById(2131378618);
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
    paramContext.setContentView(2131560712);
    ((TextView)paramContext.findViewById(2131365184)).setVisibility(8);
    TextView localTextView1 = (TextView)paramContext.findViewById(2131365173);
    TextView localTextView2 = (TextView)paramContext.findViewById(2131365171);
    TextView localTextView3 = (TextView)paramContext.findViewById(2131365177);
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
  
  public static Dialog a(Context paramContext, String paramString, CharSequence paramCharSequence, int paramInt1, int paramInt2, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, bckm parambckm)
  {
    paramContext = new Dialog(paramContext, 2131755791);
    paramContext.setContentView(2131560712);
    TextView localTextView3 = (TextView)paramContext.findViewById(2131365184);
    ClickableColorSpanTextView localClickableColorSpanTextView = (ClickableColorSpanTextView)paramContext.findViewById(2131365173);
    TextView localTextView1 = (TextView)paramContext.findViewById(2131365171);
    TextView localTextView2 = (TextView)paramContext.findViewById(2131365177);
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
      paramString = new bbdk(paramOnClickListener1, paramContext, paramOnClickListener2);
      localTextView1.setOnClickListener(paramString);
      localTextView2.setOnClickListener(paramString);
      localClickableColorSpanTextView.setSpanClickListener(parambckm);
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
    return a(paramContext, paramContext.getResources().getDrawable(2130848555), paramInt);
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
      ((TextView)paramContext.findViewById(2131365146)).setText(paramInt1);
      ((ProgressBar)paramContext.findViewById(2131366570)).setIndeterminateDrawable(paramDrawable);
      return paramContext;
    }
    catch (Exception localException)
    {
      break label26;
    }
  }
  
  public static bbfk a(Activity paramActivity, String paramString1, long paramLong, String paramString2, CharSequence paramCharSequence)
  {
    paramActivity = new bbfk(paramActivity);
    paramActivity.a(new aykk(a(paramString1), 3)).b(new aykk(a(paramString2), 3)).a(paramLong).c(paramCharSequence);
    paramActivity.setCanceledOnTouchOutside(false);
    paramActivity.setCancelable(true);
    return paramActivity;
  }
  
  public static bbgl a(Context paramContext, String paramString, Bundle paramBundle)
  {
    bbgl localbbgl = new bbgl(paramContext, 2131755791);
    localbbgl.a(paramContext, paramBundle);
    localbbgl.setTitle(paramString);
    localbbgl.setCanceledOnTouchOutside(false);
    localbbgl.setCancelable(true);
    return localbbgl;
  }
  
  public static bbgl a(Context paramContext, String paramString, Bundle paramBundle, int paramInt)
  {
    bbgl localbbgl = new bbgl(paramContext, 2131755791);
    localbbgl.a(paramContext, paramBundle);
    localbbgl.setTitle(paramString);
    localbbgl.setCanceledOnTouchOutside(false);
    localbbgl.setCancelable(true);
    if (paramInt > 0) {
      localbbgl.c(paramInt);
    }
    return localbbgl;
  }
  
  public static bbgp a(Context paramContext, String paramString, Bundle paramBundle)
  {
    bbgp localbbgp = new bbgp(paramContext, 2131755791);
    localbbgp.a(paramContext, paramBundle);
    localbbgp.setTitle(paramString);
    localbbgp.setCanceledOnTouchOutside(true);
    localbbgp.setCancelable(true);
    return localbbgp;
  }
  
  public static bbgt a(Context paramContext, bbmf parambbmf, DialogInterface.OnClickListener paramOnClickListener)
  {
    if ((parambbmf == null) || (parambbmf.a() <= 0)) {
      return null;
    }
    paramContext = new bbgt(paramContext, 2131755791);
    paramContext.setCanceledOnTouchOutside(true);
    paramContext.setContentView(2131558906);
    paramContext.a(parambbmf, paramOnClickListener);
    paramContext.a(2131558896);
    ((LinearLayout)paramContext.findViewById(2131363442)).setLayoutParams(new RelativeLayout.LayoutParams(-1, 0));
    parambbmf = (ListView)paramContext.findViewById(2131369266);
    paramOnClickListener = new RelativeLayout.LayoutParams(-1, -2);
    paramOnClickListener.addRule(3, 2131365150);
    parambbmf.setLayoutParams(paramOnClickListener);
    return paramContext;
  }
  
  public static bbgu a(Activity paramActivity)
  {
    bbgu localbbgu = a(paramActivity, 230);
    localbbgu.setTitle(ajya.a(2131703273));
    localbbgu.setMessage(2131694010);
    localbbgu.setNegativeButton(ajya.a(2131703304), new bbdm(localbbgu));
    localbbgu.setPositiveButton(ajya.a(2131714937), new bbdn(paramActivity));
    localbbgu.setOnCancelListener(null);
    localbbgu.show();
    return localbbgu;
  }
  
  public static bbgu a(Activity paramActivity, int paramInt)
  {
    return a(paramActivity, paramActivity.getString(paramInt), 2131690596, 2131694794, null, null);
  }
  
  public static bbgu a(Activity paramActivity, axof paramaxof)
  {
    paramaxof = new bbdp(paramActivity, paramaxof);
    paramActivity = a(paramActivity, 230);
    paramActivity.setTitle(ajya.a(2131710214));
    paramActivity.setMessage(ajya.a(2131707950));
    paramActivity.setNegativeButton(ajya.a(2131703304), paramaxof);
    paramActivity.setPositiveButton(ajya.a(2131703288), paramaxof);
    paramActivity.show();
    return paramActivity;
  }
  
  public static bbgu a(Activity paramActivity, String paramString)
  {
    return a(paramActivity, paramString, 2131690596, 2131694794, null, null);
  }
  
  public static bbgu a(Activity paramActivity, String paramString, int paramInt1, int paramInt2, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramString = a(paramActivity, 230, null, paramString, paramInt1, paramInt2, paramOnClickListener1, paramOnClickListener2);
    if (paramString != null)
    {
      ((TextView)paramString.findViewById(2131365124)).setVisibility(8);
      ((TextView)paramString.findViewById(2131365146)).setMinHeight(baxn.a(paramActivity, 35.0F));
    }
    return paramString;
  }
  
  public static bbgu a(Activity paramActivity, String paramString1, long paramLong, String paramString2, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    bbgu localbbgu = new bbgu(paramActivity, 2131755791);
    localbbgu.setContentView(2131558906);
    localbbgu.setTitle(paramString1);
    paramActivity = paramActivity.getLayoutInflater().inflate(2131558786, null);
    paramString1 = (TextView)paramActivity.findViewById(2131378536);
    String str = bbfk.a((float)paramLong, true, 2);
    if (!TextUtils.isEmpty(str)) {
      paramString1.setText(ajya.a(2131703292) + str);
    }
    ((TextView)paramActivity.findViewById(2131365146)).setText(paramString2);
    localbbgu.addView(paramActivity);
    localbbgu.setNegativeButton(ajya.a(2131703268), paramOnClickListener1);
    localbbgu.setPositiveButton(ajya.a(2131703317), paramOnClickListener2);
    localbbgu.setCanceledOnTouchOutside(false);
    return localbbgu;
  }
  
  public static bbgu a(Activity paramActivity, String paramString1, String paramString2)
  {
    bbds localbbds = new bbds(paramActivity);
    bbgu localbbgu = a(paramActivity, 230);
    if (paramString1 != null)
    {
      paramActivity = paramString1;
      if (!paramString1.equals("")) {}
    }
    else
    {
      paramActivity = ajya.a(2131703277);
    }
    localbbgu.setTitle(paramActivity);
    if (paramString2 != null)
    {
      paramActivity = paramString2;
      if (!paramString2.equals("")) {}
    }
    else
    {
      paramActivity = ajya.a(2131703329);
    }
    localbbgu.setMessage(paramActivity);
    localbbgu.setPositiveButton(ajya.a(2131703332), localbbds);
    localbbgu.show();
    return localbbgu;
  }
  
  public static bbgu a(Activity paramActivity, String paramString1, String paramString2, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    bbgu localbbgu = a(paramActivity, 230);
    if (paramString1 != null)
    {
      paramActivity = paramString1;
      if (!paramString1.equals("")) {}
    }
    else
    {
      paramActivity = ajya.a(2131703273);
    }
    localbbgu.setTitle(paramActivity);
    if (paramString2 != null)
    {
      paramActivity = paramString2;
      if (!paramString2.equals("")) {}
    }
    else
    {
      paramActivity = ajya.a(2131703311);
    }
    localbbgu.setMessage(paramActivity);
    localbbgu.setNegativeButton(ajya.a(2131703304), paramOnClickListener1);
    localbbgu.setPositiveButton(ajya.a(2131703288), paramOnClickListener2);
    localbbgu.setOnCancelListener(paramOnCancelListener);
    localbbgu.show();
    return localbbgu;
  }
  
  public static bbgu a(Activity paramActivity, String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener)
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
  
  public static bbgu a(Activity paramActivity, String[] paramArrayOfString, int[] paramArrayOfInt)
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
  
  public static bbgu a(Context paramContext, int paramInt)
  {
    return a(paramContext, paramInt, null, null, 2131690596, 2131694794, null, null);
  }
  
  public static bbgu a(Context paramContext, int paramInt1, int paramInt2, String paramString, CharSequence paramCharSequence, int paramInt3, int paramInt4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new bbgu(paramContext, 2131755791);
    paramContext.setContentView(paramInt2);
    paramContext.setTitle(paramString);
    paramContext.setMessageWithoutAutoLink(paramCharSequence);
    paramContext.setNegativeButton(paramInt3, paramOnClickListener2);
    paramContext.setPositiveButton(paramInt4, paramOnClickListener1);
    paramContext.setCanceledOnTouchOutside(true);
    return paramContext;
  }
  
  public static bbgu a(Context paramContext, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new bbgu(paramContext, 2131755791);
    paramContext.setContentView(paramInt2);
    paramContext.setTitle(paramString1);
    paramContext.setMessage(paramString2);
    paramContext.setNegativeButton(paramString3, paramOnClickListener2);
    paramContext.setPositiveButton(paramString4, paramOnClickListener1);
    paramContext.setCanceledOnTouchOutside(false);
    return paramContext;
  }
  
  public static bbgu a(Context paramContext, int paramInt1, String paramString, CharSequence paramCharSequence, int paramInt2, int paramInt3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    return a(paramContext, paramInt1, 2131558906, paramString, paramCharSequence, paramInt2, paramInt3, paramOnClickListener1, paramOnClickListener2);
  }
  
  public static bbgu a(Context paramContext, int paramInt, String paramString1, CharSequence paramCharSequence, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new bbgu(paramContext, 2131755791);
    paramContext.setContentView(2131558906);
    paramContext.setTitle(paramString1);
    paramContext.setMessage(paramCharSequence);
    paramContext.setNegativeButton(paramString2, paramOnClickListener2);
    paramContext.setPositiveButton(paramString3, paramOnClickListener1);
    paramContext.setCanceledOnTouchOutside(false);
    return paramContext;
  }
  
  public static bbgu a(Context paramContext, int paramInt, String paramString1, CharSequence paramCharSequence, String paramString2, String paramString3, String paramString4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    return a(paramContext, paramInt, paramString1, paramCharSequence, paramString2, paramString3, paramString4, paramOnClickListener1, paramOnClickListener2, null);
  }
  
  public static bbgu a(Context paramContext, int paramInt, String paramString1, CharSequence paramCharSequence, String paramString2, String paramString3, String paramString4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnClickListener paramOnClickListener3)
  {
    bbgu localbbgu = new bbgu(paramContext, 2131755791);
    localbbgu.setContentView(2131558910);
    if (paramInt != 0) {
      localbbgu.setOperateImage(paramContext.getResources().getDrawable(paramInt));
    }
    for (;;)
    {
      localbbgu.setMessage(paramCharSequence);
      localbbgu.setNegativeButton(paramString2, paramOnClickListener1);
      localbbgu.setPositiveButton(paramString3, paramOnClickListener2);
      localbbgu.setCanceledOnTouchOutside(false);
      paramString1 = (TextView)localbbgu.findViewById(2131365126);
      paramContext = paramString4;
      if (paramString4 == null) {
        paramContext = ajya.a(2131703308);
      }
      paramString1.setText(paramContext);
      if (paramOnClickListener3 == null) {
        break;
      }
      paramString1.setOnClickListener(new bbdq(paramOnClickListener3, localbbgu));
      return localbbgu;
      localbbgu.setTitle(paramString1);
    }
    paramString1.setOnClickListener(new bbdr(localbbgu));
    return localbbgu;
  }
  
  public static bbgu a(Context paramContext, int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new bbgu(paramContext, 2131755791);
    paramContext.setContentView(2131558906);
    paramContext.setTitle(paramString1);
    paramContext.setMessage(paramString2);
    paramContext.setNegativeButton(paramInt2, paramOnClickListener2);
    paramContext.setPositiveButton(paramInt3, paramOnClickListener1);
    paramContext.setCanceledOnTouchOutside(false);
    return paramContext;
  }
  
  public static bbgu a(Context paramContext, int paramInt, String paramString1, String paramString2, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    return a(paramContext, paramInt, paramString1, paramString2, 2131690596, 2131694794, paramOnClickListener1, paramOnClickListener2);
  }
  
  public static bbgu a(Context paramContext, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt2, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new bbgu(paramContext, 2131755791);
    paramContext.setContentView(2131558906);
    paramContext.setTitle(paramString1);
    paramContext.setMessage(paramString2);
    paramContext.setNegativeButton(paramString3, paramOnClickListener2);
    paramContext.setPositiveButton(paramString4, paramInt2, paramOnClickListener1);
    paramContext.setCanceledOnTouchOutside(false);
    return paramContext;
  }
  
  public static bbgu a(Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new bbgu(paramContext, 2131755791);
    paramContext.setContentView(2131558906);
    paramContext.setTitle(paramString1);
    paramContext.setMessage(paramString2);
    paramContext.setNegativeButton(paramString3, paramOnClickListener2);
    paramContext.setPositiveButton(paramString4, paramOnClickListener1);
    paramContext.setCanceledOnTouchOutside(false);
    paramString1 = (TextView)paramContext.findViewById(2131365124);
    paramString1 = (TextView)paramContext.findViewById(2131365146);
    paramString2 = new LinearLayout.LayoutParams(-2, -2);
    paramString2.gravity = 17;
    paramString1.setLayoutParams(paramString2);
    return paramContext;
  }
  
  public static bbgu a(Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnClickListener paramOnClickListener3)
  {
    paramContext = new bbgu(paramContext, 2131755791);
    paramContext.setContentView(2131558890);
    paramContext.setTitle(paramString1);
    paramContext.setMessage(paramString2);
    paramContext.setNegativeButton(paramString4, paramOnClickListener3);
    paramContext.setPositiveButton(paramString5, paramOnClickListener2);
    paramContext.setCanceledOnTouchOutside(false);
    paramContext.setCheckBox(paramString3, paramOnClickListener1);
    return paramContext;
  }
  
  public static bbgu a(Context paramContext, String paramString1, String paramString2, DialogInterface.OnClickListener paramOnClickListener)
  {
    paramContext = new bbgu(paramContext, 2131755791);
    paramContext.setContentView(2131558903);
    paramContext.setTitle(paramString1);
    paramContext.setNegativeButton(paramString2, paramOnClickListener);
    paramContext.setCanceledOnTouchOutside(false);
    return paramContext;
  }
  
  public static bbgu a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = a(paramContext, 230, paramString1, paramString2, paramInt1, paramInt2, paramOnClickListener1, paramOnClickListener2);
    paramContext.setEditLint(paramString3);
    return paramContext;
  }
  
  public static bbgu a(Context paramContext, String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener1, String paramString4, DialogInterface.OnClickListener paramOnClickListener2, View.OnClickListener paramOnClickListener)
  {
    paramContext = new bbgu(paramContext, 2131755791);
    paramContext.setContentView(2131558885);
    TextView localTextView1 = (TextView)paramContext.findViewById(2131365150);
    TextView localTextView2 = (TextView)paramContext.findViewById(2131365146);
    ImageView localImageView = (ImageView)paramContext.findViewById(2131364258);
    localTextView1.setText(paramString1);
    localTextView2.setText(paramString2);
    paramContext.setNegativeButton(paramString3, paramOnClickListener1);
    paramContext.setPositiveButton(paramString4, paramOnClickListener2);
    localImageView.setOnClickListener(paramOnClickListener);
    paramContext.setCanceledOnTouchOutside(false);
    paramContext.setCancelable(false);
    return paramContext;
  }
  
  public static bbgu a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new bbgu(paramContext, 2131755791);
    paramContext.setContentView(2131558893);
    paramContext.setTitleWithEmo(new aykk(a(paramString1), 3));
    paramContext.setMessage(new aykk(a(paramString2), 3));
    paramContext.setNegativeButton(paramString3, paramOnClickListener2);
    paramContext.setPositiveButton(paramString4, paramOnClickListener1);
    if ((paramString5 != null) && (!"".equals(paramString5))) {
      paramContext.setCheckBox(paramString5, null);
    }
    paramContext.setCanceledOnTouchOutside(false);
    return paramContext;
  }
  
  public static bbhi a(Context paramContext, int paramInt)
  {
    return a(paramContext, paramInt, null, null, "", "", "", null, null, null);
  }
  
  public static bbhi a(Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnClickListener paramOnClickListener3)
  {
    paramContext = new bbhi(paramContext, 2131755791);
    paramContext.setContentView(2131558909);
    paramContext.a(paramString1);
    paramContext.b(paramString2);
    paramContext.a(paramString4, paramOnClickListener1);
    paramContext.b(paramString5, paramOnClickListener2);
    paramContext.b(paramString4, paramOnClickListener3);
    paramContext.setCanceledOnTouchOutside(true);
    return paramContext;
  }
  
  public static bbhp a(Context paramContext, String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new bbhp(paramContext, 2131755791);
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
  
  public static bbhp a(Context paramContext, String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, int paramInt)
  {
    return a(paramContext, paramString1, paramString2, paramString3, paramOnClickListener1, paramOnClickListener2, paramInt, false);
  }
  
  public static bbhp a(Context paramContext, String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, int paramInt, boolean paramBoolean)
  {
    paramContext = new bbhp(paramContext, 2131755791);
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
  
  public static bbie a(Context paramContext, int paramInt1, int paramInt2, String paramString, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new bbie(paramContext, 2131755791);
    paramContext.setContentView(2131558919);
    paramContext.setTitle(paramInt1);
    paramContext.setMessage(paramInt2);
    paramContext.setCanceledOnTouchOutside(false);
    paramContext.setCancelable(true);
    paramContext.a(paramString);
    paramContext.setNegativeButton(2131690596, paramOnClickListener2);
    paramContext.setPositiveButton(2131694794, paramOnClickListener1);
    paramContext.show();
    return paramContext;
  }
  
  public static bbie a(Context paramContext, int paramInt1, int paramInt2, String paramString, TextWatcher paramTextWatcher, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new bbie(paramContext, 2131755791);
    paramContext.setContentView(2131558919);
    paramContext.setTitle(paramInt1);
    paramContext.setMessage(paramInt2);
    paramContext.setCanceledOnTouchOutside(false);
    paramContext.setCancelable(true);
    paramContext.a(paramTextWatcher);
    paramContext.a(paramString);
    paramContext.setNegativeButton(2131690596, paramOnClickListener2);
    paramContext.setPositiveButton(2131694794, paramOnClickListener1);
    paramContext.show();
    return paramContext;
  }
  
  public static bbig a(Context paramContext, String paramString1, String paramString2, String paramString3, ArrayList<String> paramArrayList, String paramString4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, int paramInt, boolean paramBoolean)
  {
    paramContext = new bbig(paramContext, 2131755791);
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
  
  public static bbin a(Context paramContext, String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener1, String paramString4, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new bbin(paramContext, 2131755791);
    paramContext.setContentView(2131558908);
    paramContext.a(paramString1.replace(ajya.a(2131703323), aylc.c(21)).replace(ajya.a(2131703267), aylc.c(18)).replace(ajya.a(2131703306), aylc.c(86)).replace(ajya.a(2131703325), aylc.c(55)).replace("\\U0001f60f", String.valueOf(Character.toChars(128527))).replace("\\U0001f60c", String.valueOf(Character.toChars(128524))));
    paramContext.a(paramString2.replace(ajya.a(2131703305), aylc.c(21)).replace(ajya.a(2131703294), aylc.c(18)).replace(ajya.a(2131703313), aylc.c(86)).replace(ajya.a(2131703320), aylc.c(55)).replace("\\U0001f60f", String.valueOf(Character.toChars(128527))).replace("\\U0001f60c", String.valueOf(Character.toChars(128524))), 2.0F);
    paramContext.a(2130839301, 2131690596, paramOnClickListener2);
    paramContext.a(paramString3.replace(ajya.a(2131703272), aylc.c(21)).replace(ajya.a(2131703324), aylc.c(18)).replace(ajya.a(2131703327), aylc.c(86)).replace(ajya.a(2131703269), aylc.c(55)).replace("\\U0001f60f", String.valueOf(Character.toChars(128527))).replace("\\U0001f60c", String.valueOf(Character.toChars(128524))), paramOnClickListener1);
    paramContext.setCanceledOnTouchOutside(false);
    return paramContext;
  }
  
  protected static String a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      return paramString.replace(ajya.a(2131703330), aylc.c(21)).replace(ajya.a(2131703289), aylc.c(18)).replace(ajya.a(2131703270), aylc.c(86)).replace(ajya.a(2131703299), aylc.c(55)).replace("\\U0001f60f", String.valueOf(Character.toChars(128527))).replace("\\U0001f60c", String.valueOf(Character.toChars(128524)));
    }
    return null;
  }
  
  public static String a(String... paramVarArgs)
  {
    String str2 = ajya.a(2131703309);
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
          str1 = ajya.a(2131703276);
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
            str1 = ajya.a(2131703291);
          } else if ("android.permission.ACCESS_COARSE_LOCATION".equals(str3)) {
            str1 = ajya.a(2131703280);
          } else if ("android.permission.ACCESS_FINE_LOCATION".equals(str3)) {
            str1 = ajya.a(2131703298);
          } else if ("android.permission.READ_CALENDAR".equals(str3)) {
            str1 = ajya.a(2131703310);
          } else if ("android.permission.WRITE_CALENDAR".equals(str3)) {
            str1 = ajya.a(2131703316);
          } else if ("android.permission.SEND_SMS".equals(str3)) {
            str1 = ajya.a(2131703274);
          } else if ("android.permission.READ_CONTACTS".equals(str3)) {
            str1 = ajya.a(2131703281);
          } else if ("android.permission.WRITE_CONTACTS".equals(str3)) {
            str1 = ajya.a(2131703319);
          } else if ("android.permission.WRITE_EXTERNAL_STORAGE".equals(str3)) {
            str1 = ajya.a(2131707951);
          } else if ("android.permission.READ_EXTERNAL_STORAGE".equals(str3)) {
            str1 = ajya.a(2131707949);
          }
        }
      }
      str1 = localStringBuilder.toString();
    }
    return String.format(str2, new Object[] { str1 });
  }
  
  public static bbgu b(Activity paramActivity)
  {
    bbdo localbbdo = new bbdo(paramActivity);
    paramActivity = a(paramActivity, 230);
    paramActivity.setTitle(ajya.a(2131710214));
    paramActivity.setMessage(ajya.a(2131707950));
    paramActivity.setNegativeButton(ajya.a(2131703304), localbbdo);
    paramActivity.setPositiveButton(ajya.a(2131703288), localbbdo);
    paramActivity.show();
    return paramActivity;
  }
  
  public static bbgu b(Activity paramActivity, String paramString1, String paramString2)
  {
    bbdl localbbdl = new bbdl(paramActivity);
    return a(paramActivity, paramString1, paramString2, localbbdl, localbbdl, null);
  }
  
  public static bbgu b(Activity paramActivity, String paramString1, String paramString2, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    bbgu localbbgu = a(paramActivity, 230);
    String str;
    if (paramString1 != null)
    {
      str = paramString1;
      if (!paramString1.equals("")) {}
    }
    else
    {
      str = paramActivity.getResources().getString(2131695758);
    }
    localbbgu.setTitle(str);
    if (paramString2 != null)
    {
      paramString1 = paramString2;
      if (!paramString2.equals("")) {}
    }
    else
    {
      paramString1 = paramActivity.getResources().getString(2131695755);
    }
    localbbgu.setMessage(paramString1);
    localbbgu.setNegativeButton(paramActivity.getResources().getString(2131690596), paramOnClickListener1);
    localbbgu.setPositiveButton(paramActivity.getResources().getString(2131694794), paramOnClickListener2);
    localbbgu.setOnCancelListener(paramOnCancelListener);
    localbbgu.show();
    return localbbgu;
  }
  
  public static bbgu b(Context paramContext, int paramInt)
  {
    return b(paramContext, paramInt, null, null, 2131690596, 2131694794, null, null);
  }
  
  public static bbgu b(Context paramContext, int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new bbgu(paramContext, 2131755791);
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
 * Qualified Name:     bbdj
 * JD-Core Version:    0.7.0.1
 */