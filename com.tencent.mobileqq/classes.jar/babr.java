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

public class babr
{
  public static final HashMap<String, String> a = new HashMap();
  
  static
  {
    a.put("android.permission.READ_EXTERNAL_STORAGE", ajjy.a(2131637489));
    a.put("android.permission.WRITE_EXTERNAL_STORAGE", ajjy.a(2131637504));
    a.put("android.permission.READ_PHONE_STATE", "QQ使用电话权限确定本机号码和设备ID，以保证帐号登录的安全性。QQ不会拨打其他号码或终止通话。\n" + ajjy.a(2131637475));
    a.put("android.permission.CAMERA", ajjy.a(2131637516));
    a.put("android.permission.RECORD_AUDIO", ajjy.a(2131637487));
    a.put("android.permission.ACCESS_COARSE_LOCATION", ajjy.a(2131637482));
    a.put("android.permission.ACCESS_FINE_LOCATION", ajjy.a(2131637488));
    a.put("android.permission.READ_CALENDAR", ajjy.a(2131637532));
    a.put("android.permission.WRITE_CALENDAR", ajjy.a(2131637530));
    a.put("android.permission.SEND_SMS", ajjy.a(2131637518));
    a.put("android.permission.READ_CONTACTS", ajjy.a(2131637507));
    a.put("android.permission.WRITE_CONTACTS", ajjy.a(2131637525));
  }
  
  public static Dialog a(Activity paramActivity, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2)
  {
    paramActivity = azvu.a(paramActivity, 2131632654, 2131632652, 2131632651, 2131632653, paramOnClickListener1, paramOnClickListener2);
    paramActivity.setCancelable(false);
    return paramActivity;
  }
  
  public static Dialog a(Context paramContext, int paramInt1, bacb parambacb, Object paramObject, int paramInt2, int paramInt3, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject1 = paramContext.getResources();
    String str2 = ((Resources)localObject1).getString(paramInt2);
    String str1 = ((Resources)localObject1).getString(paramInt3);
    paramContext = new Dialog(paramContext, 2131690181);
    paramContext.setContentView(2131493350);
    Object localObject2 = (TextView)paramContext.findViewById(2131299583);
    FrameLayout localFrameLayout = (FrameLayout)paramContext.findViewById(2131299584);
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
      localObject1 = (TextView)paramContext.findViewById(2131299568);
      if (localObject1 != null)
      {
        ((TextView)localObject1).setText(str2);
        ((TextView)localObject1).setContentDescription(str2);
        ((TextView)localObject1).setOnClickListener(paramOnClickListener1);
        if (paramBoolean1) {
          ((TextView)localObject1).getPaint().setFakeBoldText(true);
        }
      }
      paramOnClickListener1 = (TextView)paramContext.findViewById(2131299574);
      if (paramOnClickListener1 != null)
      {
        paramOnClickListener1.setText(str1);
        paramOnClickListener1.setContentDescription(str1);
        paramOnClickListener1.setOnClickListener(paramOnClickListener2);
        if (paramBoolean2) {
          paramOnClickListener1.getPaint().setFakeBoldText(true);
        }
      }
      localFrameLayout.addView(parambacb.a(localFrameLayout.getContext(), paramObject));
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
    paramContext = new Dialog(paramContext, 2131690181);
    paramContext.setContentView(2131493323);
    Object localObject2 = (TextView)paramContext.findViewById(2131299583);
    TextView localTextView = (TextView)paramContext.findViewById(2131299579);
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
      paramString = (TextView)paramContext.findViewById(2131299568);
      if (paramString != null)
      {
        paramString.setText(str2);
        paramString.setContentDescription(str2);
        paramString.setOnClickListener(paramOnClickListener1);
        if (paramBoolean1) {
          paramString.getPaint().setFakeBoldText(true);
        }
      }
      paramString = (TextView)paramContext.findViewById(2131299574);
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
    paramContext = new Dialog(paramContext, 2131690181);
    paramContext.setContentView(2131493356);
    ImageView localImageView = (ImageView)paramContext.findViewById(2131302061);
    TextView localTextView1 = (TextView)paramContext.findViewById(2131311534);
    TextView localTextView2 = (TextView)paramContext.findViewById(2131299132);
    TextView localTextView3 = (TextView)paramContext.findViewById(2131298297);
    TextView localTextView4 = (TextView)paramContext.findViewById(2131299051);
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
    paramContext = new Dialog(paramContext, 2131690181);
    paramContext.setContentView(2131494923);
    ImageView localImageView = (ImageView)paramContext.findViewById(2131312792);
    TextView localTextView1 = (TextView)paramContext.findViewById(2131312793);
    TextView localTextView2 = (TextView)paramContext.findViewById(2131312794);
    TextView localTextView3 = (TextView)paramContext.findViewById(2131312788);
    TextView localTextView4 = (TextView)paramContext.findViewById(2131312789);
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
    paramContext = new Dialog(paramContext, 2131690181);
    paramContext.setContentView(2131493364);
    ImageView localImageView = (ImageView)paramContext.findViewById(2131312792);
    TextView localTextView1 = (TextView)paramContext.findViewById(2131299583);
    TextView localTextView2 = (TextView)paramContext.findViewById(2131312793);
    TextView localTextView3 = (TextView)paramContext.findViewById(2131312794);
    TextView localTextView4 = (TextView)paramContext.findViewById(2131312788);
    TextView localTextView5 = (TextView)paramContext.findViewById(2131312789);
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
    paramContext = new Dialog(paramContext, 2131690181);
    paramContext.getWindow().setWindowAnimations(2131689588);
    paramContext.setContentView(2131495138);
    ((TextView)paramContext.findViewById(2131299617)).setVisibility(8);
    TextView localTextView1 = (TextView)paramContext.findViewById(2131299606);
    TextView localTextView2 = (TextView)paramContext.findViewById(2131299604);
    TextView localTextView3 = (TextView)paramContext.findViewById(2131299610);
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
  
  public static Dialog a(Context paramContext, String paramString, CharSequence paramCharSequence, int paramInt1, int paramInt2, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, bbgx parambbgx)
  {
    paramContext = new Dialog(paramContext, 2131690181);
    paramContext.setContentView(2131495138);
    TextView localTextView3 = (TextView)paramContext.findViewById(2131299617);
    ClickableColorSpanTextView localClickableColorSpanTextView = (ClickableColorSpanTextView)paramContext.findViewById(2131299606);
    TextView localTextView1 = (TextView)paramContext.findViewById(2131299604);
    TextView localTextView2 = (TextView)paramContext.findViewById(2131299610);
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
      paramString = new babs(paramOnClickListener1, paramContext, paramOnClickListener2);
      localTextView1.setOnClickListener(paramString);
      localTextView2.setOnClickListener(paramString);
      localClickableColorSpanTextView.setSpanClickListener(parambbgx);
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
    return a(paramContext, paramContext.getResources().getDrawable(2130848317), paramInt);
  }
  
  public static ProgressDialog a(Context paramContext, Drawable paramDrawable, int paramInt)
  {
    return a(paramContext, paramDrawable, paramInt, 0);
  }
  
  public static ProgressDialog a(Context paramContext, Drawable paramDrawable, int paramInt1, int paramInt2)
  {
    int i = paramInt2;
    if (paramInt2 <= 0) {
      i = 2131690181;
    }
    paramContext = new ProgressDialog(paramContext, i);
    try
    {
      paramContext.show();
      label26:
      paramContext.getWindow().setContentView(2131492892);
      paramContext.setContentView(2131492892);
      ((TextView)paramContext.findViewById(2131299579)).setText(paramInt1);
      ((ProgressBar)paramContext.findViewById(2131300960)).setIndeterminateDrawable(paramDrawable);
      return paramContext;
    }
    catch (Exception localException)
    {
      break label26;
    }
  }
  
  public static badr a(Activity paramActivity, String paramString1, long paramLong, String paramString2, CharSequence paramCharSequence)
  {
    paramActivity = new badr(paramActivity);
    paramActivity.a(new axkd(a(paramString1), 3)).b(new axkd(a(paramString2), 3)).a(paramLong).c(paramCharSequence);
    paramActivity.setCanceledOnTouchOutside(false);
    paramActivity.setCancelable(true);
    return paramActivity;
  }
  
  public static baes a(Context paramContext, String paramString, Bundle paramBundle)
  {
    baes localbaes = new baes(paramContext, 2131690181);
    localbaes.a(paramContext, paramBundle);
    localbaes.setTitle(paramString);
    localbaes.setCanceledOnTouchOutside(false);
    localbaes.setCancelable(true);
    return localbaes;
  }
  
  public static baes a(Context paramContext, String paramString, Bundle paramBundle, int paramInt)
  {
    baes localbaes = new baes(paramContext, 2131690181);
    localbaes.a(paramContext, paramBundle);
    localbaes.setTitle(paramString);
    localbaes.setCanceledOnTouchOutside(false);
    localbaes.setCancelable(true);
    if (paramInt > 0) {
      localbaes.c(paramInt);
    }
    return localbaes;
  }
  
  public static baew a(Context paramContext, String paramString, Bundle paramBundle)
  {
    baew localbaew = new baew(paramContext, 2131690181);
    localbaew.a(paramContext, paramBundle);
    localbaew.setTitle(paramString);
    localbaew.setCanceledOnTouchOutside(true);
    localbaew.setCancelable(true);
    return localbaew;
  }
  
  public static bafa a(Context paramContext, bakh parambakh, DialogInterface.OnClickListener paramOnClickListener)
  {
    if ((parambakh == null) || (parambakh.a() <= 0)) {
      return null;
    }
    paramContext = new bafa(paramContext, 2131690181);
    paramContext.setCanceledOnTouchOutside(true);
    paramContext.setContentView(2131493345);
    paramContext.a(parambakh, paramOnClickListener);
    paramContext.a(2131493335);
    ((LinearLayout)paramContext.findViewById(2131297897)).setLayoutParams(new RelativeLayout.LayoutParams(-1, 0));
    parambakh = (ListView)paramContext.findViewById(2131303596);
    paramOnClickListener = new RelativeLayout.LayoutParams(-1, -2);
    paramOnClickListener.addRule(3, 2131299583);
    parambakh.setLayoutParams(paramOnClickListener);
    return paramContext;
  }
  
  public static bafb a(Activity paramActivity)
  {
    bafb localbafb = a(paramActivity, 230);
    localbafb.setTitle(ajjy.a(2131637477));
    localbafb.setMessage(2131628368);
    localbafb.setNegativeButton(ajjy.a(2131637508), new babu(localbafb));
    localbafb.setPositiveButton(ajjy.a(2131649137), new babv(paramActivity));
    localbafb.setOnCancelListener(null);
    localbafb.show();
    return localbafb;
  }
  
  public static bafb a(Activity paramActivity, int paramInt)
  {
    return a(paramActivity, paramActivity.getString(paramInt), 2131625035, 2131629116, null, null);
  }
  
  public static bafb a(Activity paramActivity, String paramString)
  {
    return a(paramActivity, paramString, 2131625035, 2131629116, null, null);
  }
  
  public static bafb a(Activity paramActivity, String paramString, int paramInt1, int paramInt2, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramString = a(paramActivity, 230, null, paramString, paramInt1, paramInt2, paramOnClickListener1, paramOnClickListener2);
    if (paramString != null)
    {
      ((TextView)paramString.findViewById(2131299557)).setVisibility(8);
      ((TextView)paramString.findViewById(2131299579)).setMinHeight(azvv.a(paramActivity, 35.0F));
    }
    return paramString;
  }
  
  public static bafb a(Activity paramActivity, String paramString1, long paramLong, String paramString2, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    bafb localbafb = new bafb(paramActivity, 2131690181);
    localbafb.setContentView(2131493345);
    localbafb.setTitle(paramString1);
    paramActivity = paramActivity.getLayoutInflater().inflate(2131493230, null);
    paramString1 = (TextView)paramActivity.findViewById(2131312707);
    String str = badr.a((float)paramLong, true, 2);
    if (!TextUtils.isEmpty(str)) {
      paramString1.setText(ajjy.a(2131637496) + str);
    }
    ((TextView)paramActivity.findViewById(2131299579)).setText(paramString2);
    localbafb.addView(paramActivity);
    localbafb.setNegativeButton(ajjy.a(2131637472), paramOnClickListener1);
    localbafb.setPositiveButton(ajjy.a(2131637521), paramOnClickListener2);
    localbafb.setCanceledOnTouchOutside(false);
    return localbafb;
  }
  
  public static bafb a(Activity paramActivity, String paramString1, String paramString2)
  {
    babz localbabz = new babz(paramActivity);
    bafb localbafb = a(paramActivity, 230);
    if (paramString1 != null)
    {
      paramActivity = paramString1;
      if (!paramString1.equals("")) {}
    }
    else
    {
      paramActivity = ajjy.a(2131637481);
    }
    localbafb.setTitle(paramActivity);
    if (paramString2 != null)
    {
      paramActivity = paramString2;
      if (!paramString2.equals("")) {}
    }
    else
    {
      paramActivity = ajjy.a(2131637533);
    }
    localbafb.setMessage(paramActivity);
    localbafb.setPositiveButton(ajjy.a(2131637536), localbabz);
    localbafb.show();
    return localbafb;
  }
  
  public static bafb a(Activity paramActivity, String paramString1, String paramString2, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    bafb localbafb = a(paramActivity, 230);
    if (paramString1 != null)
    {
      paramActivity = paramString1;
      if (!paramString1.equals("")) {}
    }
    else
    {
      paramActivity = ajjy.a(2131637477);
    }
    localbafb.setTitle(paramActivity);
    if (paramString2 != null)
    {
      paramActivity = paramString2;
      if (!paramString2.equals("")) {}
    }
    else
    {
      paramActivity = ajjy.a(2131637515);
    }
    localbafb.setMessage(paramActivity);
    localbafb.setNegativeButton(ajjy.a(2131637508), paramOnClickListener1);
    localbafb.setPositiveButton(ajjy.a(2131637492), paramOnClickListener2);
    localbafb.setOnCancelListener(paramOnCancelListener);
    localbafb.show();
    return localbafb;
  }
  
  public static bafb a(Activity paramActivity, String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener)
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
  
  public static bafb a(Activity paramActivity, String[] paramArrayOfString, int[] paramArrayOfInt)
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
  
  public static bafb a(Context paramContext, int paramInt)
  {
    return a(paramContext, paramInt, null, null, 2131625035, 2131629116, null, null);
  }
  
  public static bafb a(Context paramContext, int paramInt1, int paramInt2, String paramString, CharSequence paramCharSequence, int paramInt3, int paramInt4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new bafb(paramContext, 2131690181);
    paramContext.setContentView(paramInt2);
    paramContext.setTitle(paramString);
    paramContext.setMessageWithoutAutoLink(paramCharSequence);
    paramContext.setNegativeButton(paramInt3, paramOnClickListener2);
    paramContext.setPositiveButton(paramInt4, paramOnClickListener1);
    paramContext.setCanceledOnTouchOutside(true);
    return paramContext;
  }
  
  public static bafb a(Context paramContext, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new bafb(paramContext, 2131690181);
    paramContext.setContentView(paramInt2);
    paramContext.setTitle(paramString1);
    paramContext.setMessage(paramString2);
    paramContext.setNegativeButton(paramString3, paramOnClickListener2);
    paramContext.setPositiveButton(paramString4, paramOnClickListener1);
    paramContext.setCanceledOnTouchOutside(false);
    return paramContext;
  }
  
  public static bafb a(Context paramContext, int paramInt1, String paramString, CharSequence paramCharSequence, int paramInt2, int paramInt3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    return a(paramContext, paramInt1, 2131493345, paramString, paramCharSequence, paramInt2, paramInt3, paramOnClickListener1, paramOnClickListener2);
  }
  
  public static bafb a(Context paramContext, int paramInt, String paramString1, CharSequence paramCharSequence, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new bafb(paramContext, 2131690181);
    paramContext.setContentView(2131493345);
    paramContext.setTitle(paramString1);
    paramContext.setMessage(paramCharSequence);
    paramContext.setNegativeButton(paramString2, paramOnClickListener2);
    paramContext.setPositiveButton(paramString3, paramOnClickListener1);
    paramContext.setCanceledOnTouchOutside(false);
    return paramContext;
  }
  
  public static bafb a(Context paramContext, int paramInt, String paramString1, CharSequence paramCharSequence, String paramString2, String paramString3, String paramString4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    return a(paramContext, paramInt, paramString1, paramCharSequence, paramString2, paramString3, paramString4, paramOnClickListener1, paramOnClickListener2, null);
  }
  
  public static bafb a(Context paramContext, int paramInt, String paramString1, CharSequence paramCharSequence, String paramString2, String paramString3, String paramString4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnClickListener paramOnClickListener3)
  {
    bafb localbafb = new bafb(paramContext, 2131690181);
    localbafb.setContentView(2131493349);
    if (paramInt != 0) {
      localbafb.setOperateImage(paramContext.getResources().getDrawable(paramInt));
    }
    for (;;)
    {
      localbafb.setMessage(paramCharSequence);
      localbafb.setNegativeButton(paramString2, paramOnClickListener1);
      localbafb.setPositiveButton(paramString3, paramOnClickListener2);
      localbafb.setCanceledOnTouchOutside(false);
      paramCharSequence = (TextView)localbafb.findViewById(2131299559);
      paramString1 = paramString4;
      if (paramString4 == null) {
        paramString1 = ajjy.a(2131637512);
      }
      paramCharSequence.setText(paramString1);
      paramCharSequence.setText(paramContext.getResources().getString(2131625035));
      if (paramOnClickListener3 == null) {
        break;
      }
      paramCharSequence.setOnClickListener(new babx(paramOnClickListener3, localbafb));
      return localbafb;
      localbafb.setTitle(paramString1);
    }
    paramCharSequence.setOnClickListener(new baby(localbafb));
    return localbafb;
  }
  
  public static bafb a(Context paramContext, int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new bafb(paramContext, 2131690181);
    paramContext.setContentView(2131493345);
    paramContext.setTitle(paramString1);
    paramContext.setMessage(paramString2);
    paramContext.setNegativeButton(paramInt2, paramOnClickListener2);
    paramContext.setPositiveButton(paramInt3, paramOnClickListener1);
    paramContext.setCanceledOnTouchOutside(false);
    return paramContext;
  }
  
  public static bafb a(Context paramContext, int paramInt, String paramString1, String paramString2, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    return a(paramContext, paramInt, paramString1, paramString2, 2131625035, 2131629116, paramOnClickListener1, paramOnClickListener2);
  }
  
  public static bafb a(Context paramContext, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt2, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new bafb(paramContext, 2131690181);
    paramContext.setContentView(2131493345);
    paramContext.setTitle(paramString1);
    paramContext.setMessage(paramString2);
    paramContext.setNegativeButton(paramString3, paramOnClickListener2);
    paramContext.setPositiveButton(paramString4, paramInt2, paramOnClickListener1);
    paramContext.setCanceledOnTouchOutside(false);
    return paramContext;
  }
  
  public static bafb a(Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new bafb(paramContext, 2131690181);
    paramContext.setContentView(2131493345);
    paramContext.setTitle(paramString1);
    paramContext.setMessage(paramString2);
    paramContext.setNegativeButton(paramString3, paramOnClickListener2);
    paramContext.setPositiveButton(paramString4, paramOnClickListener1);
    paramContext.setCanceledOnTouchOutside(false);
    paramString1 = (TextView)paramContext.findViewById(2131299557);
    paramString1 = (TextView)paramContext.findViewById(2131299579);
    paramString2 = new LinearLayout.LayoutParams(-2, -2);
    paramString2.gravity = 17;
    paramString1.setLayoutParams(paramString2);
    return paramContext;
  }
  
  public static bafb a(Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnClickListener paramOnClickListener3)
  {
    paramContext = new bafb(paramContext, 2131690181);
    paramContext.setContentView(2131493329);
    paramContext.setTitle(paramString1);
    paramContext.setMessage(paramString2);
    paramContext.setNegativeButton(paramString4, paramOnClickListener3);
    paramContext.setPositiveButton(paramString5, paramOnClickListener2);
    paramContext.setCanceledOnTouchOutside(false);
    paramContext.setCheckBox(paramString3, paramOnClickListener1);
    return paramContext;
  }
  
  public static bafb a(Context paramContext, String paramString1, String paramString2, DialogInterface.OnClickListener paramOnClickListener)
  {
    paramContext = new bafb(paramContext, 2131690181);
    paramContext.setContentView(2131493342);
    paramContext.setTitle(paramString1);
    paramContext.setNegativeButton(paramString2, paramOnClickListener);
    paramContext.setCanceledOnTouchOutside(false);
    return paramContext;
  }
  
  public static bafb a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = a(paramContext, 230, paramString1, paramString2, paramInt1, paramInt2, paramOnClickListener1, paramOnClickListener2);
    paramContext.setEditLint(paramString3);
    return paramContext;
  }
  
  public static bafb a(Context paramContext, String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener1, String paramString4, DialogInterface.OnClickListener paramOnClickListener2, View.OnClickListener paramOnClickListener)
  {
    paramContext = new bafb(paramContext, 2131690181);
    paramContext.setContentView(2131493325);
    TextView localTextView1 = (TextView)paramContext.findViewById(2131299583);
    TextView localTextView2 = (TextView)paramContext.findViewById(2131299579);
    ImageView localImageView = (ImageView)paramContext.findViewById(2131298701);
    localTextView1.setText(paramString1);
    localTextView2.setText(paramString2);
    paramContext.setNegativeButton(paramString3, paramOnClickListener1);
    paramContext.setPositiveButton(paramString4, paramOnClickListener2);
    localImageView.setOnClickListener(paramOnClickListener);
    paramContext.setCanceledOnTouchOutside(false);
    paramContext.setCancelable(false);
    return paramContext;
  }
  
  public static bafb a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new bafb(paramContext, 2131690181);
    paramContext.setContentView(2131493332);
    paramContext.setTitleWithEmo(new axkd(a(paramString1), 3));
    paramContext.setMessage(new axkd(a(paramString2), 3));
    paramContext.setNegativeButton(paramString3, paramOnClickListener2);
    paramContext.setPositiveButton(paramString4, paramOnClickListener1);
    if ((paramString5 != null) && (!"".equals(paramString5))) {
      paramContext.setCheckBox(paramString5, null);
    }
    paramContext.setCanceledOnTouchOutside(false);
    return paramContext;
  }
  
  public static bafp a(Context paramContext, int paramInt)
  {
    return a(paramContext, paramInt, null, null, "", "", "", null, null, null);
  }
  
  public static bafp a(Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnClickListener paramOnClickListener3)
  {
    paramContext = new bafp(paramContext, 2131690181);
    paramContext.setContentView(2131493348);
    paramContext.a(paramString1);
    paramContext.b(paramString2);
    paramContext.a(paramString4, paramOnClickListener1);
    paramContext.b(paramString5, paramOnClickListener2);
    paramContext.b(paramString4, paramOnClickListener3);
    paramContext.setCanceledOnTouchOutside(true);
    return paramContext;
  }
  
  public static bafw a(Context paramContext, String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new bafw(paramContext, 2131690181);
    paramContext.setContentView(2131493355);
    paramContext.setTitle(paramString1);
    paramContext.setMessage(paramString2);
    paramContext.setCanceledOnTouchOutside(false);
    paramContext.setCancelable(true);
    paramContext.b(paramString3);
    paramContext.setNegativeButton(2131625035, paramOnClickListener2);
    paramContext.setPositiveButton(2131625184, paramOnClickListener1);
    paramContext.show();
    return paramContext;
  }
  
  public static bafw a(Context paramContext, String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, int paramInt)
  {
    return a(paramContext, paramString1, paramString2, paramString3, paramOnClickListener1, paramOnClickListener2, paramInt, false);
  }
  
  public static bafw a(Context paramContext, String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, int paramInt, boolean paramBoolean)
  {
    paramContext = new bafw(paramContext, 2131690181);
    paramContext.b(7);
    paramContext.a(paramBoolean);
    paramContext.setContentView(2131493355);
    paramContext.setTitle(paramString1);
    if (paramInt != 0) {
      paramContext.c(paramInt);
    }
    paramContext.setMessage(paramString2);
    paramContext.setCanceledOnTouchOutside(false);
    paramContext.setCancelable(true);
    paramContext.b(paramString3);
    paramContext.setNegativeButton(2131625035, paramOnClickListener2);
    paramContext.setPositiveButton(2131625184, paramOnClickListener1);
    paramContext.show();
    return paramContext;
  }
  
  public static bagl a(Context paramContext, int paramInt1, int paramInt2, String paramString, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new bagl(paramContext, 2131690181);
    paramContext.setContentView(2131493358);
    paramContext.setTitle(paramInt1);
    paramContext.setMessage(paramInt2);
    paramContext.setCanceledOnTouchOutside(false);
    paramContext.setCancelable(true);
    paramContext.a(paramString);
    paramContext.setNegativeButton(2131625035, paramOnClickListener2);
    paramContext.setPositiveButton(2131629116, paramOnClickListener1);
    paramContext.show();
    return paramContext;
  }
  
  public static bagl a(Context paramContext, int paramInt1, int paramInt2, String paramString, TextWatcher paramTextWatcher, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new bagl(paramContext, 2131690181);
    paramContext.setContentView(2131493358);
    paramContext.setTitle(paramInt1);
    paramContext.setMessage(paramInt2);
    paramContext.setCanceledOnTouchOutside(false);
    paramContext.setCancelable(true);
    paramContext.a(paramTextWatcher);
    paramContext.a(paramString);
    paramContext.setNegativeButton(2131625035, paramOnClickListener2);
    paramContext.setPositiveButton(2131629116, paramOnClickListener1);
    paramContext.show();
    return paramContext;
  }
  
  public static bagn a(Context paramContext, String paramString1, String paramString2, String paramString3, ArrayList<String> paramArrayList, String paramString4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, int paramInt, boolean paramBoolean)
  {
    paramContext = new bagn(paramContext, 2131690181);
    paramContext.a(paramBoolean);
    paramContext.setContentView(2131493360);
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
    paramContext.setNegativeButton(2131625035, paramOnClickListener2);
    paramContext.setPositiveButton(2131625184, paramOnClickListener1);
    paramContext.show();
    return paramContext;
  }
  
  public static bagu a(Context paramContext, String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener1, String paramString4, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new bagu(paramContext, 2131690181);
    paramContext.setContentView(2131493347);
    paramContext.a(paramString1.replace(ajjy.a(2131637527), axku.c(21)).replace(ajjy.a(2131637471), axku.c(18)).replace(ajjy.a(2131637510), axku.c(86)).replace(ajjy.a(2131637529), axku.c(55)).replace("\\U0001f60f", String.valueOf(Character.toChars(128527))).replace("\\U0001f60c", String.valueOf(Character.toChars(128524))));
    paramContext.a(paramString2.replace(ajjy.a(2131637509), axku.c(21)).replace(ajjy.a(2131637498), axku.c(18)).replace(ajjy.a(2131637517), axku.c(86)).replace(ajjy.a(2131637524), axku.c(55)).replace("\\U0001f60f", String.valueOf(Character.toChars(128527))).replace("\\U0001f60c", String.valueOf(Character.toChars(128524))), 2.0F);
    paramContext.a(2130839277, 2131625035, paramOnClickListener2);
    paramContext.a(paramString3.replace(ajjy.a(2131637476), axku.c(21)).replace(ajjy.a(2131637528), axku.c(18)).replace(ajjy.a(2131637531), axku.c(86)).replace(ajjy.a(2131637473), axku.c(55)).replace("\\U0001f60f", String.valueOf(Character.toChars(128527))).replace("\\U0001f60c", String.valueOf(Character.toChars(128524))), paramOnClickListener1);
    paramContext.setCanceledOnTouchOutside(false);
    return paramContext;
  }
  
  protected static String a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      return paramString.replace(ajjy.a(2131637534), axku.c(21)).replace(ajjy.a(2131637493), axku.c(18)).replace(ajjy.a(2131637474), axku.c(86)).replace(ajjy.a(2131637503), axku.c(55)).replace("\\U0001f60f", String.valueOf(Character.toChars(128527))).replace("\\U0001f60c", String.valueOf(Character.toChars(128524)));
    }
    return null;
  }
  
  public static String a(String... paramVarArgs)
  {
    String str2 = ajjy.a(2131637513);
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
          str1 = ajjy.a(2131637480);
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
            str1 = ajjy.a(2131637495);
          } else if ("android.permission.ACCESS_COARSE_LOCATION".equals(str3)) {
            str1 = ajjy.a(2131637484);
          } else if ("android.permission.ACCESS_FINE_LOCATION".equals(str3)) {
            str1 = ajjy.a(2131637502);
          } else if ("android.permission.READ_CALENDAR".equals(str3)) {
            str1 = ajjy.a(2131637514);
          } else if ("android.permission.WRITE_CALENDAR".equals(str3)) {
            str1 = ajjy.a(2131637520);
          } else if ("android.permission.SEND_SMS".equals(str3)) {
            str1 = ajjy.a(2131637478);
          } else if ("android.permission.READ_CONTACTS".equals(str3)) {
            str1 = ajjy.a(2131637485);
          } else if ("android.permission.WRITE_CONTACTS".equals(str3)) {
            str1 = ajjy.a(2131637523);
          } else if ("android.permission.WRITE_EXTERNAL_STORAGE".equals(str3)) {
            str1 = ajjy.a(2131642155);
          } else if ("android.permission.READ_EXTERNAL_STORAGE".equals(str3)) {
            str1 = ajjy.a(2131642153);
          }
        }
      }
      str1 = localStringBuilder.toString();
    }
    return String.format(str2, new Object[] { str1 });
  }
  
  public static bafb b(Activity paramActivity)
  {
    babw localbabw = new babw(paramActivity);
    paramActivity = a(paramActivity, 230);
    paramActivity.setTitle(ajjy.a(2131644418));
    paramActivity.setMessage(ajjy.a(2131642154));
    paramActivity.setNegativeButton(ajjy.a(2131637508), localbabw);
    paramActivity.setPositiveButton(ajjy.a(2131637492), localbabw);
    paramActivity.show();
    return paramActivity;
  }
  
  public static bafb b(Activity paramActivity, String paramString1, String paramString2)
  {
    babt localbabt = new babt(paramActivity);
    return a(paramActivity, paramString1, paramString2, localbabt, localbabt, null);
  }
  
  public static bafb b(Activity paramActivity, String paramString1, String paramString2, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    bafb localbafb = a(paramActivity, 230);
    String str;
    if (paramString1 != null)
    {
      str = paramString1;
      if (!paramString1.equals("")) {}
    }
    else
    {
      str = paramActivity.getResources().getString(2131630070);
    }
    localbafb.setTitle(str);
    if (paramString2 != null)
    {
      paramString1 = paramString2;
      if (!paramString2.equals("")) {}
    }
    else
    {
      paramString1 = paramActivity.getResources().getString(2131630067);
    }
    localbafb.setMessage(paramString1);
    localbafb.setNegativeButton(paramActivity.getResources().getString(2131625035), paramOnClickListener1);
    localbafb.setPositiveButton(paramActivity.getResources().getString(2131629116), paramOnClickListener2);
    localbafb.setOnCancelListener(paramOnCancelListener);
    localbafb.show();
    return localbafb;
  }
  
  public static bafb b(Context paramContext, int paramInt)
  {
    return b(paramContext, paramInt, null, null, 2131625035, 2131629116, null, null);
  }
  
  public static bafb b(Context paramContext, int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new bafb(paramContext, 2131690181);
    paramContext.setContentView(2131493345);
    paramContext.setTitle(paramString1);
    paramContext.setMessageWithUrl(paramString2);
    paramContext.setNegativeButton(paramInt2, paramOnClickListener2);
    paramContext.setPositiveButton(paramInt3, paramOnClickListener1);
    paramContext.setCanceledOnTouchOutside(true);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     babr
 * JD-Core Version:    0.7.0.1
 */