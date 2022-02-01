import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayoutPromotion.1;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.widget.FixRatioPAHighLightImageView;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.QWalletPicHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class bdsf
  extends bdnv
{
  private String ac;
  private String ad;
  private String ae;
  private String af;
  private String ag;
  private String ah;
  private String ai;
  private String aj;
  private String ak;
  private String al;
  private int s;
  private int t;
  
  public bdsf()
  {
    this.jdField_s_of_type_Int = -1;
  }
  
  private View a(Context paramContext, RelativeLayout paramRelativeLayout, Bundle paramBundle)
  {
    Object localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      bdnu localbdnu = (bdnu)((Iterator)localObject).next();
      if ((localbdnu instanceof bdpx))
      {
        localObject = localbdnu.a(paramContext, null, paramBundle);
        ((View)localObject).setId(2131378129);
        paramContext = ((View)localObject).findViewById(2131368676);
        if ((paramContext instanceof FixRatioPAHighLightImageView)) {
          ((FixRatioPAHighLightImageView)paramContext).setRatio(1.8F);
        }
        int i;
        for (paramContext = new RelativeLayout.LayoutParams(-1, -2);; paramContext = new RelativeLayout.LayoutParams(-1, (int)(i / 1.8D)))
        {
          paramRelativeLayout.addView((View)localObject, paramContext);
          return localObject;
          i = BaseChatItemLayout.A;
          if (!paramBundle.getBoolean("hasHeadIcon", true)) {
            i = BaseChatItemLayout.B;
          }
        }
      }
    }
    return null;
  }
  
  private ImageView a(Context paramContext)
  {
    paramContext = new ImageView(paramContext);
    paramContext.setImageResource(2130847107);
    paramContext.setScaleType(ImageView.ScaleType.FIT_XY);
    if (this.jdField_s_of_type_Int == 1) {
      paramContext.setColorFilter(-1);
    }
    for (;;)
    {
      paramContext.setId(2131378130);
      return paramContext;
      paramContext.setColorFilter(-49602);
    }
  }
  
  private LinearLayout a(Context paramContext)
  {
    paramContext = new LinearLayout(paramContext);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    paramContext.setOrientation(1);
    paramContext.setLayoutParams(localLayoutParams);
    if (QLog.isColorLevel()) {
      QLog.i("StructMsgItemLayoutPromotion", 2, "getItemRootView");
    }
    return paramContext;
  }
  
  private TextView a(Context paramContext)
  {
    paramContext = new TextView(paramContext);
    paramContext.setText(this.af);
    paramContext.setTypeface(Typeface.DEFAULT_BOLD);
    paramContext.setTextSize(17.0F);
    paramContext.setId(2131378131);
    if (this.jdField_s_of_type_Int == 1)
    {
      paramContext.setTextColor(-1);
      return paramContext;
    }
    paramContext.setTextColor(-49602);
    return paramContext;
  }
  
  private TextView a(Context paramContext, LinearLayout paramLinearLayout)
  {
    TextView localTextView = new TextView(paramContext);
    localTextView.setText(this.ac);
    localTextView.setTextSize(18.0F);
    localTextView.setTypeface(Typeface.DEFAULT_BOLD);
    if (this.jdField_s_of_type_Int == 1) {
      localTextView.setTextColor(-16777216);
    }
    for (;;)
    {
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
      localLayoutParams.gravity = 16;
      localLayoutParams.topMargin = AIOUtils.dp2px(10.0F, paramContext.getResources());
      localLayoutParams.bottomMargin = AIOUtils.dp2px(10.0F, paramContext.getResources());
      paramLinearLayout.addView(localTextView, localLayoutParams);
      return localTextView;
      localTextView.setTextColor(-1);
    }
  }
  
  private void a(Context paramContext, LinearLayout paramLinearLayout)
  {
    View localView = new View(paramContext);
    GradientDrawable localGradientDrawable = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[] { -26554, -48849 });
    localView.setBackgroundDrawable(QWalletPicHelper.getNetDrawableForAIO(this.ag, localGradientDrawable));
    paramLinearLayout.addView(localView, new LinearLayout.LayoutParams(-2, AIOUtils.dp2px(40.0F, paramContext.getResources())));
  }
  
  private void a(Context paramContext, LinearLayout paramLinearLayout, Bundle paramBundle)
  {
    RelativeLayout localRelativeLayout = new RelativeLayout(paramContext);
    paramLinearLayout.addView(localRelativeLayout, new LinearLayout.LayoutParams(-1, -2));
    a(paramContext, localRelativeLayout);
    b(paramContext, localRelativeLayout);
    a(paramContext, localRelativeLayout, paramBundle);
    paramLinearLayout = new LinearLayout(paramContext);
    paramBundle = new RelativeLayout.LayoutParams(-1, -2);
    paramBundle.addRule(3, 2131378129);
    paramLinearLayout.setId(2131378128);
    paramLinearLayout.setOrientation(1);
    localRelativeLayout.addView(paramLinearLayout, paramBundle);
    b(paramContext, paramLinearLayout);
    c(paramContext, paramLinearLayout);
    d(paramContext, paramLinearLayout);
  }
  
  private void a(Context paramContext, LinearLayout paramLinearLayout, TextView paramTextView)
  {
    int i = AIOUtils.dp2px(5.0F, paramContext.getResources());
    int j = AIOUtils.dp2px(4.0F, paramContext.getResources());
    TextView localTextView = new TextView(paramContext);
    localTextView.setText(this.ae);
    localTextView.setTextSize(14.0F);
    localTextView.setTextColor(-1);
    localTextView.setGravity(17);
    a(localTextView, 6);
    float f = localTextView.getPaint().measureText(this.ae) + j + j;
    paramContext = new LinearLayout.LayoutParams((int)f, AIOUtils.dp2px(20.0F, paramContext.getResources()));
    paramContext.leftMargin = i;
    paramContext.gravity = 16;
    localTextView.setBackgroundDrawable(QWalletPicHelper.getNetDrawableForAIO(this.aj, URLDrawableHelper.TRANSPARENT));
    if (this.jdField_t_of_type_Int == 1) {
      paramLinearLayout.addView(localTextView, paramContext);
    }
    while (this.jdField_t_of_type_Int != 0) {
      return;
    }
    paramTextView.post(new StructMsgItemLayoutPromotion.1(this, paramLinearLayout, paramTextView, f, i, localTextView, paramContext));
  }
  
  private void a(Context paramContext, RelativeLayout paramRelativeLayout)
  {
    ImageView localImageView = new ImageView(paramContext);
    if (this.jdField_s_of_type_Int == 1) {}
    for (paramContext = URLDrawableHelper.TRANSPARENT;; paramContext = new GradientDrawable(GradientDrawable.Orientation.TL_BR, new int[] { -26554, -48849 }))
    {
      localImageView.setImageDrawable(QWalletPicHelper.getNetDrawableForAIO(this.ah, paramContext));
      paramContext = new RelativeLayout.LayoutParams(-1, -2);
      paramContext.addRule(6, 2131378128);
      paramContext.addRule(8, 2131378128);
      localImageView.setScaleType(ImageView.ScaleType.FIT_XY);
      paramRelativeLayout.addView(localImageView, paramContext);
      return;
    }
  }
  
  private void a(View paramView, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramView.setOutlineProvider(new bdsg(this, paramInt));
      paramView.setClipToOutline(true);
    }
  }
  
  private void b(Context paramContext, LinearLayout paramLinearLayout)
  {
    LinearLayout localLinearLayout = new LinearLayout(paramContext);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    localLayoutParams.leftMargin = AIOUtils.dp2px(12.0F, paramContext.getResources());
    localLayoutParams.rightMargin = AIOUtils.dp2px(12.0F, paramContext.getResources());
    localLayoutParams.topMargin = AIOUtils.dp2px(6.0F, paramContext.getResources());
    localLinearLayout.setOrientation(0);
    paramLinearLayout.addView(localLinearLayout, localLayoutParams);
    paramLinearLayout = a(paramContext, localLinearLayout);
    if (!TextUtils.isEmpty(this.ae)) {
      a(paramContext, localLinearLayout, paramLinearLayout);
    }
  }
  
  private void b(Context paramContext, RelativeLayout paramRelativeLayout)
  {
    paramContext = new ImageView(paramContext);
    paramContext.setImageDrawable(QWalletPicHelper.getNetDrawableForAIO(this.ai, URLDrawableHelper.TRANSPARENT));
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    localLayoutParams.addRule(6, 2131378129);
    localLayoutParams.addRule(8, 2131378128);
    paramContext.setScaleType(ImageView.ScaleType.FIT_END);
    paramRelativeLayout.addView(paramContext, localLayoutParams);
  }
  
  private void c(Context paramContext, LinearLayout paramLinearLayout)
  {
    if (TextUtils.isEmpty(this.ad)) {
      return;
    }
    TextView localTextView = new TextView(paramContext);
    localTextView.setText(this.ad);
    localTextView.setTextSize(14.0F);
    if (this.jdField_s_of_type_Int == 1) {
      localTextView.setTextColor(-16777216);
    }
    for (;;)
    {
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
      localLayoutParams.leftMargin = AIOUtils.dp2px(12.0F, paramContext.getResources());
      localLayoutParams.rightMargin = AIOUtils.dp2px(12.0F, paramContext.getResources());
      localLayoutParams.bottomMargin = AIOUtils.dp2px(10.0F, paramContext.getResources());
      paramLinearLayout.addView(localTextView, localLayoutParams);
      return;
      localTextView.setTextColor(-1);
    }
  }
  
  private void c(Context paramContext, RelativeLayout paramRelativeLayout)
  {
    ImageView localImageView = new ImageView(paramContext);
    localImageView.setImageDrawable(QWalletPicHelper.getNetDrawableForAIO(this.al, URLDrawableHelper.TRANSPARENT));
    paramContext = new RelativeLayout.LayoutParams(-1, AIOUtils.dp2px(60.0F, paramContext.getResources()));
    localImageView.setScaleType(ImageView.ScaleType.FIT_START);
    paramRelativeLayout.addView(localImageView, paramContext);
  }
  
  private void d(Context paramContext, LinearLayout paramLinearLayout)
  {
    RelativeLayout localRelativeLayout = new RelativeLayout(paramContext);
    paramLinearLayout.addView(localRelativeLayout, new LinearLayout.LayoutParams(-1, -2));
    d(paramContext, localRelativeLayout);
    if (this.jdField_s_of_type_Int == 1) {
      c(paramContext, localRelativeLayout);
    }
  }
  
  private void d(Context paramContext, RelativeLayout paramRelativeLayout)
  {
    RelativeLayout localRelativeLayout = new RelativeLayout(paramContext);
    Object localObject = new RelativeLayout.LayoutParams(-1, AIOUtils.dp2px(45.0F, paramContext.getResources()));
    if (this.jdField_s_of_type_Int == 1)
    {
      ((RelativeLayout.LayoutParams)localObject).topMargin = AIOUtils.dp2px(15.0F, paramContext.getResources());
      localRelativeLayout.setBackgroundDrawable(QWalletPicHelper.getNetDrawableForAIO(this.ak, new ColorDrawable(-43724)));
    }
    RelativeLayout.LayoutParams localLayoutParams1;
    RelativeLayout.LayoutParams localLayoutParams2;
    for (;;)
    {
      paramRelativeLayout.addView(localRelativeLayout, (ViewGroup.LayoutParams)localObject);
      localObject = a(paramContext);
      paramRelativeLayout = a(paramContext);
      localLayoutParams1 = new RelativeLayout.LayoutParams(-2, -2);
      int i = AIOUtils.dp2px(17.0F, paramContext.getResources());
      localLayoutParams2 = new RelativeLayout.LayoutParams(i, i);
      localLayoutParams2.addRule(15);
      localLayoutParams2.leftMargin = AIOUtils.dp2px(5.0F, paramContext.getResources());
      localLayoutParams2.rightMargin = AIOUtils.dp2px(12.0F, paramContext.getResources());
      if (this.jdField_s_of_type_Int != 1) {
        break;
      }
      localLayoutParams1.addRule(0, 2131378130);
      localLayoutParams1.addRule(15);
      localLayoutParams2.addRule(11);
      localRelativeLayout.addView((View)localObject, localLayoutParams1);
      localRelativeLayout.addView(paramRelativeLayout, localLayoutParams2);
      return;
      ((RelativeLayout.LayoutParams)localObject).leftMargin = AIOUtils.dp2px(12.0F, paramContext.getResources());
      ((RelativeLayout.LayoutParams)localObject).rightMargin = AIOUtils.dp2px(12.0F, paramContext.getResources());
      ((RelativeLayout.LayoutParams)localObject).bottomMargin = AIOUtils.dp2px(12.0F, paramContext.getResources());
      localRelativeLayout.setBackgroundDrawable(QWalletPicHelper.getNetDrawableForAIO(this.ak, new ColorDrawable(-1)));
      a(localRelativeLayout, 8);
    }
    paramContext = new RelativeLayout(paramContext);
    localLayoutParams2.addRule(1, 2131378131);
    paramContext.addView((View)localObject, localLayoutParams1);
    paramContext.addView(paramRelativeLayout, localLayoutParams2);
    localObject = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject).addRule(13);
    localRelativeLayout.addView(paramContext, (ViewGroup.LayoutParams)localObject);
    a(paramRelativeLayout);
  }
  
  public long a(View paramView)
  {
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(paramView, "translationX", new float[] { 0.0F, 20.0F, 0.0F });
    localObjectAnimator.setDuration(800L);
    localObjectAnimator.setRepeatCount(-1);
    localObjectAnimator.setRepeatMode(1);
    localObjectAnimator.start();
    paramView.addOnAttachStateChangeListener(new bdsh(this, localObjectAnimator));
    long l = localObjectAnimator.getDuration();
    return localObjectAnimator.getRepeatCount() * l;
  }
  
  public void a()
  {
    opa localopa;
    if ((TextUtils.isEmpty(this.ag)) && (TextUtils.isEmpty(this.ah)) && (TextUtils.isEmpty(this.ai)) && (TextUtils.isEmpty(this.aj)) && (TextUtils.isEmpty(this.ak)) && (TextUtils.isEmpty(this.al)))
    {
      localopa = opd.a();
      if (localopa != null) {}
    }
    else
    {
      return;
    }
    a(localopa.a);
  }
  
  public boolean a(bdnu parambdnu, opb paramopb)
  {
    if (!(parambdnu instanceof bdrr)) {}
    do
    {
      return false;
      parambdnu = (bdnv)parambdnu;
      this.jdField_a_of_type_JavaUtilArrayList = parambdnu.jdField_a_of_type_JavaUtilArrayList;
      this.b = parambdnu.b;
      this.jdField_c_of_type_JavaLangString = parambdnu.jdField_c_of_type_JavaLangString;
      this.jdField_d_of_type_JavaLangString = parambdnu.jdField_d_of_type_JavaLangString;
      this.jdField_e_of_type_JavaLangString = parambdnu.jdField_e_of_type_JavaLangString;
      this.jdField_f_of_type_JavaLangString = parambdnu.jdField_f_of_type_JavaLangString;
      this.jdField_g_of_type_JavaLangString = parambdnu.jdField_g_of_type_JavaLangString;
      this.jdField_h_of_type_JavaLangString = parambdnu.jdField_h_of_type_JavaLangString;
      this.jdField_i_of_type_JavaLangString = parambdnu.jdField_i_of_type_JavaLangString;
      this.jdField_j_of_type_JavaLangString = parambdnu.jdField_j_of_type_JavaLangString;
      this.jdField_k_of_type_JavaLangString = parambdnu.jdField_k_of_type_JavaLangString;
      this.jdField_l_of_type_JavaLangString = parambdnu.jdField_l_of_type_JavaLangString;
      this.jdField_m_of_type_JavaLangString = parambdnu.jdField_m_of_type_JavaLangString;
      this.jdField_n_of_type_JavaLangString = parambdnu.jdField_n_of_type_JavaLangString;
      this.o = parambdnu.o;
      this.p = parambdnu.p;
      this.q = parambdnu.q;
      this.jdField_c_of_type_Int = parambdnu.jdField_c_of_type_Int;
      this.r = parambdnu.r;
      this.jdField_s_of_type_JavaLangString = parambdnu.jdField_s_of_type_JavaLangString;
      this.jdField_t_of_type_JavaLangString = parambdnu.jdField_t_of_type_JavaLangString;
      this.u = parambdnu.u;
      this.v = parambdnu.v;
      this.jdField_d_of_type_Int = parambdnu.jdField_d_of_type_Int;
      this.w = parambdnu.w;
      this.x = parambdnu.x;
      this.y = parambdnu.y;
      this.z = parambdnu.z;
      this.A = parambdnu.A;
      this.jdField_e_of_type_Int = parambdnu.jdField_e_of_type_Int;
      this.B = parambdnu.B;
      this.C = parambdnu.C;
      this.D = parambdnu.D;
      this.E = parambdnu.E;
      this.F = parambdnu.F;
      this.G = parambdnu.G;
      this.H = parambdnu.H;
      this.I = parambdnu.I;
      this.J = parambdnu.J;
      this.jdField_f_of_type_Int = parambdnu.jdField_f_of_type_Int;
      this.K = parambdnu.K;
      this.L = parambdnu.L;
      this.M = parambdnu.M;
      this.N = parambdnu.N;
      this.O = parambdnu.O;
      this.jdField_g_of_type_Int = parambdnu.jdField_g_of_type_Int;
      this.jdField_h_of_type_Int = parambdnu.jdField_h_of_type_Int;
      this.P = parambdnu.P;
      this.Q = parambdnu.Q;
      this.R = parambdnu.R;
      this.jdField_i_of_type_Int = parambdnu.jdField_i_of_type_Int;
      this.jdField_j_of_type_Int = parambdnu.jdField_j_of_type_Int;
      this.jdField_k_of_type_Int = parambdnu.jdField_k_of_type_Int;
      this.jdField_l_of_type_Int = parambdnu.jdField_l_of_type_Int;
      this.S = parambdnu.S;
      this.T = parambdnu.T;
      this.U = parambdnu.U;
      this.V = parambdnu.V;
      this.W = parambdnu.W;
      this.X = parambdnu.X;
      this.Y = parambdnu.Y;
      this.jdField_m_of_type_Int = parambdnu.jdField_m_of_type_Int;
      this.Z = parambdnu.Z;
      this.aa = parambdnu.aa;
      this.jdField_a_of_type_Long = parambdnu.jdField_a_of_type_Long;
      this.ab = parambdnu.ab;
      this.jdField_n_of_type_Int = parambdnu.jdField_n_of_type_Int;
      this.jdField_a_of_type_JavaLangRefWeakReference = parambdnu.jdField_a_of_type_JavaLangRefWeakReference;
      this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg = parambdnu.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg;
    } while ((!b()) || (!a(paramopb)));
    return true;
  }
  
  public boolean a(opb paramopb)
  {
    if (this.jdField_s_of_type_Int == 1) {}
    for (paramopb = paramopb.a; paramopb.isEmpty(); paramopb = paramopb.b) {
      return false;
    }
    this.ag = ((String)paramopb.get("top_bg_url"));
    this.ah = ((String)paramopb.get("bottom_bg_url"));
    this.ai = ((String)paramopb.get("bottom_ani_url"));
    this.aj = ((String)paramopb.get("discount_bg_url"));
    this.ak = ((String)paramopb.get("detail_bg_url"));
    this.al = ((String)paramopb.get("detail_logo_url"));
    return true;
  }
  
  protected int b()
  {
    return 102632;
  }
  
  public View b(Context paramContext, View paramView, Bundle paramBundle)
  {
    if ((paramView instanceof LinearLayout))
    {
      paramView = (LinearLayout)paramView;
      paramView.removeAllViews();
    }
    for (;;)
    {
      b();
      a();
      if (this.jdField_s_of_type_Int == 2) {
        a(paramContext, paramView);
      }
      a(paramContext, paramView, paramBundle);
      a(paramView, 14);
      return paramView;
      paramView = a(paramContext);
    }
  }
  
  public String b()
  {
    return "LayoutPromotion";
  }
  
  public boolean b()
  {
    boolean bool = false;
    for (;;)
    {
      JSONObject localJSONObject;
      int i;
      int j;
      try
      {
        if (TextUtils.isEmpty(this.X)) {
          return false;
        }
        Object localObject = new JSONObject(this.X).optJSONObject("display_info");
        localJSONObject = ((JSONObject)localObject).optJSONObject("basic_info");
        this.ac = localJSONObject.optString("txt");
        this.ad = localJSONObject.optString("desc");
        localObject = ((JSONObject)localObject).optJSONArray("button_info");
        if (localObject == null) {
          break label191;
        }
        i = 0;
        if (i >= ((JSONArray)localObject).length()) {
          break label191;
        }
        localJSONObject = ((JSONArray)localObject).optJSONObject(i);
        if (localJSONObject == null) {
          break label216;
        }
        j = localJSONObject.optInt("pos");
        if (j == 1) {
          this.ae = localJSONObject.optString("txt");
        }
      }
      catch (Exception localException)
      {
        QLog.e("StructMsgItemLayoutPromotion", 1, localException, new Object[0]);
        return false;
      }
      if (j == 2)
      {
        this.af = localJSONObject.optString("txt");
        if (TextUtils.isEmpty(this.af))
        {
          this.af = "查看详情";
          break label216;
          label191:
          this.jdField_s_of_type_Int = onq.a(this.X);
          i = this.jdField_s_of_type_Int;
          if (i != -1) {
            bool = true;
          }
          return bool;
        }
      }
      label216:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdsf
 * JD-Core Version:    0.7.0.1
 */