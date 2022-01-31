import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.etrump.mixlayout.ETTextView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.sign.BaseSignViewHolder.3;
import com.tencent.mobileqq.richstatus.sign.BoxShadowLayout;
import com.tencent.mobileqq.vas.VasResEngine.VasResDrawable;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.SingleLineTextView;
import java.util.ArrayList;
import java.util.Observer;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.util.WeakReference;

public class ayey
  implements View.OnClickListener, ViewTreeObserver.OnPreDrawListener, ayfc, ayfh, ft
{
  static int[] jdField_a_of_type_ArrayOfInt;
  Context jdField_a_of_type_AndroidContentContext;
  View jdField_a_of_type_AndroidViewView;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  bdtv jdField_a_of_type_Bdtv;
  bdvb jdField_a_of_type_Bdvb;
  private bdvh jdField_a_of_type_Bdvh = new ayez(this);
  public ETTextView a;
  AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  public RichStatus a;
  BoxShadowLayout jdField_a_of_type_ComTencentMobileqqRichstatusSignBoxShadowLayout;
  VasResDrawable jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasResDrawable;
  SingleLineTextView jdField_a_of_type_ComTencentWidgetSingleLineTextView;
  Runnable jdField_a_of_type_JavaLangRunnable = new BaseSignViewHolder.3(this);
  public Observer a;
  WeakReference<ayfd> jdField_a_of_type_MqqUtilWeakReference;
  boolean jdField_a_of_type_Boolean;
  long jdField_b_of_type_Long;
  View jdField_b_of_type_AndroidViewView;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  SingleLineTextView jdField_b_of_type_ComTencentWidgetSingleLineTextView;
  WeakReference<ayfh> jdField_b_of_type_MqqUtilWeakReference;
  boolean jdField_b_of_type_Boolean = false;
  View jdField_c_of_type_AndroidViewView;
  public String c;
  boolean jdField_c_of_type_Boolean;
  View d;
  public boolean d;
  int jdField_e_of_type_Int;
  View jdField_e_of_type_AndroidViewView;
  public int f;
  int g;
  protected int h;
  protected int i;
  
  public ayey(Context paramContext, AppInterface paramAppInterface, View paramView, String paramString)
  {
    this.jdField_a_of_type_JavaUtilObserver = new ayfa(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqRichstatusSignBoxShadowLayout = ((BoxShadowLayout)paramView);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_c_of_type_JavaLangString = paramString;
    this.h = aepi.a(12.0F, paramContext.getResources());
    this.i = 2130845711;
    m();
    a();
    aydw.a().addObserver(this.jdField_a_of_type_JavaUtilObserver);
  }
  
  private void m()
  {
    if (jdField_a_of_type_ArrayOfInt == null)
    {
      jdField_a_of_type_ArrayOfInt = new int[17];
      jdField_a_of_type_ArrayOfInt[0] = this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166369);
      jdField_a_of_type_ArrayOfInt[1] = this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166370);
      jdField_a_of_type_ArrayOfInt[2] = this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166371);
      jdField_a_of_type_ArrayOfInt[3] = this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166373);
      jdField_a_of_type_ArrayOfInt[4] = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298285);
      jdField_a_of_type_ArrayOfInt[5] = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298283);
      jdField_a_of_type_ArrayOfInt[6] = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298284);
      jdField_a_of_type_ArrayOfInt[7] = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298286);
      jdField_a_of_type_ArrayOfInt[8] = aepi.a(12.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      jdField_a_of_type_ArrayOfInt[9] = aepi.a(17.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      jdField_a_of_type_ArrayOfInt[10] = aepi.a(20.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      jdField_a_of_type_ArrayOfInt[11] = aepi.a(8.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      jdField_a_of_type_ArrayOfInt[12] = aepi.a(12.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      jdField_a_of_type_ArrayOfInt[13] = this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166372);
      jdField_a_of_type_ArrayOfInt[14] = this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166369);
      jdField_a_of_type_ArrayOfInt[15] = this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167206);
      jdField_a_of_type_ArrayOfInt[16] = this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167194);
    }
  }
  
  private void n()
  {
    int n = 0;
    boolean bool1 = b();
    boolean bool2 = c();
    boolean bool3 = d();
    boolean bool4 = e();
    Object localObject;
    if (bool1)
    {
      localObject = bdns.c(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.time * 1000L);
      this.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText((CharSequence)localObject);
    }
    label123:
    int k;
    for (int j = 1;; k = 0)
    {
      localObject = this.jdField_a_of_type_ComTencentWidgetSingleLineTextView;
      int m;
      if (bool1)
      {
        m = 0;
        ((SingleLineTextView)localObject).setVisibility(m);
        if (!bool2) {
          break label267;
        }
        if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.locationText)) {
          break label246;
        }
        this.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setText(this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.locationText);
        this.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setVisibility(0);
        j = 1;
        localObject = this.jdField_a_of_type_AndroidViewView;
        if ((j == 0) || (!bool4)) {
          break label279;
        }
        m = 0;
        label140:
        ((View)localObject).setVisibility(m);
        localObject = this.jdField_b_of_type_AndroidWidgetImageView;
        if (!bool3) {
          break label285;
        }
        m = 0;
        label159:
        ((ImageView)localObject).setVisibility(m);
        localObject = this.jdField_a_of_type_AndroidWidgetImageView;
        if (!bool3) {
          break label291;
        }
        m = 0;
        label178:
        ((ImageView)localObject).setVisibility(m);
        j();
        localObject = (ViewGroup.MarginLayoutParams)this.jdField_d_of_type_AndroidViewView.getLayoutParams();
        if (!bool3) {
          break label297;
        }
        m = jdField_a_of_type_ArrayOfInt[7];
        label212:
        ((ViewGroup.MarginLayoutParams)localObject).rightMargin = m;
        localObject = this.jdField_b_of_type_AndroidViewView;
        if ((j | bool3) == 0) {
          break label302;
        }
      }
      label267:
      label279:
      label285:
      label291:
      label297:
      label302:
      for (j = n;; k = 8)
      {
        ((View)localObject).setVisibility(j);
        return;
        m = 8;
        break;
        label246:
        this.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setText("");
        this.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setVisibility(8);
        break label123;
        this.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setVisibility(8);
        break label123;
        m = 8;
        break label140;
        m = 8;
        break label159;
        m = 8;
        break label178;
        m = 0;
        break label212;
      }
    }
  }
  
  private void o()
  {
    int j;
    Object localObject;
    if (this.jdField_a_of_type_Bdtv.jdField_a_of_type_Bdtx != null)
    {
      j = 1;
      if (j == 0) {
        break label229;
      }
      localObject = this.jdField_a_of_type_Bdtv.n;
      label24:
      if (!this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getText().equals(localObject)) {
        this.jdField_b_of_type_Long = System.currentTimeMillis();
      }
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        break label252;
      }
      if ((this.jdField_a_of_type_Bdtv.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) || (TextUtils.isEmpty(this.jdField_a_of_type_Bdtv.n))) {
        break label246;
      }
      localObject = this.jdField_a_of_type_Bdtv.n;
      label86:
      if (this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.plainText == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.plainText = new ArrayList(2);
        this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.plainText.add("");
        this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.plainText.add("");
      }
      if (this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.tplId != 0) {
        this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.plainText.set(0, ((CharSequence)localObject).toString());
      }
      this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setHint(2131699761);
      this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setHintTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166370));
    }
    for (;;)
    {
      this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextMsg(new bamp((CharSequence)localObject, 1, 20));
      this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getViewTreeObserver().addOnPreDrawListener(this);
      return;
      j = 0;
      break;
      label229:
      localObject = a(this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus, this, this.g);
      break label24;
      label246:
      localObject = "";
      break label86;
      label252:
      this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setHint(null);
    }
  }
  
  protected int a()
  {
    return -1;
  }
  
  public View a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqRichstatusSignBoxShadowLayout;
  }
  
  public View a(RichStatus paramRichStatus)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus = paramRichStatus;
    if (paramRichStatus == null) {
      return this.jdField_a_of_type_ComTencentMobileqqRichstatusSignBoxShadowLayout;
    }
    this.jdField_a_of_type_Bdtv = a();
    paramRichStatus.signType = this.jdField_a_of_type_Bdtv.g;
    boolean bool;
    if (this.jdField_a_of_type_Bdtv.jdField_a_of_type_Bdtx != null)
    {
      bool = true;
      this.jdField_a_of_type_Boolean = bool;
      this.jdField_b_of_type_Boolean = this.jdField_a_of_type_Bdtv.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
      if ((a()) && (!this.jdField_b_of_type_Boolean) && (!this.jdField_a_of_type_Boolean)) {
        break label103;
      }
      d();
    }
    for (;;)
    {
      c();
      return this.jdField_a_of_type_ComTencentMobileqqRichstatusSignBoxShadowLayout;
      bool = false;
      break;
      label103:
      b();
    }
  }
  
  protected bdtv a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus == null) {
      return null;
    }
    return aydw.a().a(this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.tplId);
  }
  
  protected CharSequence a(RichStatus paramRichStatus, ayfh paramayfh, int paramInt)
  {
    if (!(this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface)) {
      return "";
    }
    if (paramRichStatus == null) {
      return new SpannableString("");
    }
    ayec localayec = (ayec)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(15);
    Resources localResources = this.jdField_a_of_type_AndroidContentContext.getResources();
    SpannableString localSpannableString = new SpannableString(paramRichStatus.toSpannableStringWithoutAction(paramayfh));
    if ((paramRichStatus != null) && (localResources != null) && (!TextUtils.isEmpty(paramRichStatus.actionText)))
    {
      Object localObject = paramRichStatus.actionText;
      paramayfh = (ayfh)localObject;
      if (!TextUtils.isEmpty(paramRichStatus.dataText)) {
        paramayfh = (String)localObject + paramRichStatus.dataText;
      }
      Drawable localDrawable = localResources.getDrawable(2130849047);
      localObject = new SpannableStringBuilder(localSpannableString);
      ((SpannableStringBuilder)localObject).insert(0, "[S] ");
      int j;
      if (localayec != null)
      {
        paramRichStatus = localayec.a(paramRichStatus.actionId, 200);
        paramRichStatus = new bevq(localResources, paramRichStatus, false, false);
        paramRichStatus.setBounds(0, 0, paramInt, paramInt);
        j = Color.parseColor("#ffa8a8a8");
        if ((Build.VERSION.SDK_INT < 4) || (Build.VERSION.SDK_INT == 20)) {
          break label273;
        }
      }
      label273:
      for (paramRichStatus = new aycn(paramRichStatus, 1, paramayfh, j, localDrawable, paramInt);; paramRichStatus = new aycn(paramRichStatus, 0, paramayfh, j, localDrawable, paramInt))
      {
        ((SpannableStringBuilder)localObject).setSpan(paramRichStatus, 0, "[S]".length(), 17);
        return new bamp((CharSequence)localObject, 1);
        paramRichStatus = bdal.a(localResources, 2130849040);
        break;
      }
    }
    return new bamp(localSpannableString, 1);
  }
  
  protected void a()
  {
    int j = b();
    int k = this.h;
    this.g = jdField_a_of_type_ArrayOfInt[9];
    int m = jdField_a_of_type_ArrayOfInt[11];
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561313, null, false));
    this.jdField_a_of_type_ComTencentMobileqqRichstatusSignBoxShadowLayout.a(this.jdField_a_of_type_AndroidWidgetLinearLayout, j, k, jdField_a_of_type_ArrayOfInt[3]);
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqRichstatusSignBoxShadowLayout.findViewById(2131375925);
    this.e = this.jdField_a_of_type_ComTencentMobileqqRichstatusSignBoxShadowLayout.findViewById(2131369631);
    this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqRichstatusSignBoxShadowLayout.findViewById(2131369734);
    this.jdField_d_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqRichstatusSignBoxShadowLayout.findViewById(2131369735);
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqRichstatusSignBoxShadowLayout.findViewById(2131365355);
    this.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)this.jdField_a_of_type_ComTencentMobileqqRichstatusSignBoxShadowLayout.findViewById(2131379038));
    this.jdField_b_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)this.jdField_a_of_type_ComTencentMobileqqRichstatusSignBoxShadowLayout.findViewById(2131378874));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_ComTencentMobileqqRichstatusSignBoxShadowLayout.findViewById(2131368747));
    xsm.a(this.jdField_b_of_type_AndroidWidgetImageView, m, m, m, m);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_ComTencentMobileqqRichstatusSignBoxShadowLayout.findViewById(2131368972));
    xsm.a(this.jdField_a_of_type_AndroidWidgetImageView, m, m, m, m);
    this.jdField_a_of_type_ComEtrumpMixlayoutETTextView = ((ETTextView)this.jdField_a_of_type_ComTencentMobileqqRichstatusSignBoxShadowLayout.findViewById(2131379004));
    this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setOnTextOrFontChangeListener(this);
    this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setMovementMethod(ayfi.a());
    this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setGravity(19);
    this.jdField_b_of_type_AndroidWidgetImageView.setOnTouchListener(mww.a);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnTouchListener(mww.a);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnTouchListener(mww.a);
    this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
  }
  
  public void a(ayfd paramayfd)
  {
    if (paramayfd != null)
    {
      this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramayfd);
      return;
    }
    this.jdField_a_of_type_MqqUtilWeakReference = null;
  }
  
  public void a(ayfg paramayfg, View paramView)
  {
    QLog.d("BaseSignViewHolder", 1, new Object[] { "onClick topic=", paramayfg });
    if (this.jdField_b_of_type_MqqUtilWeakReference != null) {}
    for (ayfh localayfh = (ayfh)this.jdField_b_of_type_MqqUtilWeakReference.get();; localayfh = null)
    {
      if (localayfh != null) {
        localayfh.a(paramayfg, paramView);
      }
      return;
    }
  }
  
  public void a(ayfh paramayfh)
  {
    if (paramayfh != null)
    {
      this.jdField_b_of_type_MqqUtilWeakReference = new WeakReference(paramayfh);
      return;
    }
    this.jdField_b_of_type_MqqUtilWeakReference = null;
  }
  
  public void a(ETTextView paramETTextView)
  {
    ayfm.a(paramETTextView, paramETTextView.getText(), 1);
  }
  
  public void a(ETTextView paramETTextView, CharSequence paramCharSequence)
  {
    ayfm.a(paramETTextView, paramCharSequence, 0);
  }
  
  protected void a(boolean paramBoolean) {}
  
  protected boolean a()
  {
    return true;
  }
  
  public boolean a(int paramInt)
  {
    return 1.0D - (0.299D * Color.red(paramInt) + 0.587D * Color.green(paramInt) + 0.114D * Color.blue(paramInt)) / 255.0D >= 0.5D;
  }
  
  protected int b()
  {
    return jdField_a_of_type_ArrayOfInt[10];
  }
  
  public View b()
  {
    return this.e;
  }
  
  protected void b()
  {
    f();
    g();
    h();
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
    if (this.jdField_a_of_type_ComTencentMobileqqRichstatusSignBoxShadowLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichstatusSignBoxShadowLayout.setScrolling(paramBoolean);
    }
    if ((this.jdField_a_of_type_AndroidWidgetLinearLayout.getBackground() != null) && ((this.jdField_a_of_type_AndroidWidgetLinearLayout.getBackground() instanceof VasResDrawable))) {
      ((VasResDrawable)this.jdField_a_of_type_AndroidWidgetLinearLayout.getBackground()).a(paramBoolean);
    }
  }
  
  protected boolean b()
  {
    return true;
  }
  
  public View c()
  {
    return this.jdField_a_of_type_AndroidWidgetLinearLayout;
  }
  
  protected void c()
  {
    o();
    n();
  }
  
  protected boolean c()
  {
    return true;
  }
  
  protected void d()
  {
    int j = jdField_a_of_type_ArrayOfInt[0];
    int k = jdField_a_of_type_ArrayOfInt[1];
    int m = jdField_a_of_type_ArrayOfInt[2];
    int n = jdField_a_of_type_ArrayOfInt[3];
    this.jdField_a_of_type_ComTencentMobileqqRichstatusSignBoxShadowLayout.setShadowColor(n);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundResource(2130845711);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setTag(2131376762, Integer.valueOf(-1));
    e();
    this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextColor(j);
    this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setHintTextColor(k);
    this.jdField_a_of_type_AndroidViewView.setBackgroundColor(m);
    this.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setTextColor(m);
    this.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor(m);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130849116);
    this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130845708);
    a(true);
  }
  
  protected boolean d()
  {
    return true;
  }
  
  protected void e()
  {
    int j = jdField_a_of_type_ArrayOfInt[4];
    int k = jdField_a_of_type_ArrayOfInt[5];
    int m = jdField_a_of_type_ArrayOfInt[6];
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setPadding(m, j, m, k);
  }
  
  protected boolean e()
  {
    return false;
  }
  
  protected void f()
  {
    boolean bool = true;
    if (this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.tplId == 1)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundResource(this.i);
      return;
    }
    bdvs localbdvs;
    if (this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasResDrawable == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasResDrawable = new VasResDrawable(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.tplId);
      localbdvs = new bdvs(this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasResDrawable, this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.i);
      this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasResDrawable.a(localbdvs);
      if (a() != -1) {
        break label190;
      }
    }
    for (;;)
    {
      localbdvs.a(bool);
      this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasResDrawable.a(this.jdField_a_of_type_Bdvh);
      this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasResDrawable.a(jdField_a_of_type_ArrayOfInt[8]);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasResDrawable);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setTag(2131376762, Integer.valueOf(this.jdField_a_of_type_Bdtv.f));
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setTag(2131376765, Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.tplId));
      this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasResDrawable.b(this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.tplId);
      e();
      return;
      label190:
      bool = false;
    }
  }
  
  protected void g()
  {
    boolean bool = true;
    int j = this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.fontId;
    int k = this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.fontType;
    if (j == 0)
    {
      this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setFont(j, 0L);
      return;
    }
    if (this.jdField_a_of_type_Bdvb == null)
    {
      this.jdField_a_of_type_Bdvb = new bdvb(this.jdField_a_of_type_ComTencentCommonAppAppInterface, j);
      localbdvv = new bdvv(this.jdField_a_of_type_Bdvb, this.jdField_a_of_type_ComTencentCommonAppAppInterface, k);
      localETTextView = this.jdField_a_of_type_ComEtrumpMixlayoutETTextView;
      f1 = this.g;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.toSpannableStringWithoutAction())) {}
      for (bool = true;; bool = false)
      {
        localbdvv.a(localETTextView, f1, bool);
        this.jdField_a_of_type_Bdvb.a(localbdvv);
        localbdvv.a(a());
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setTag(2131376763, Integer.valueOf(j));
        return;
      }
    }
    bdvv localbdvv = (bdvv)this.jdField_a_of_type_Bdvb.a();
    ETTextView localETTextView = this.jdField_a_of_type_ComEtrumpMixlayoutETTextView;
    float f1 = this.g;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.toSpannableStringWithoutAction())) {}
    for (;;)
    {
      localbdvv.a(localETTextView, f1, bool);
      ((bdvv)this.jdField_a_of_type_Bdvb.a()).a(j, k);
      break;
      bool = false;
    }
  }
  
  protected void h()
  {
    int j = jdField_a_of_type_ArrayOfInt[0];
    int k = jdField_a_of_type_ArrayOfInt[1];
    int m = jdField_a_of_type_ArrayOfInt[2];
    int n = jdField_a_of_type_ArrayOfInt[3];
    this.jdField_a_of_type_ComTencentMobileqqRichstatusSignBoxShadowLayout.setShadowColor(n);
    if (!TextUtils.isEmpty(this.jdField_a_of_type_Bdtv.e)) {
      j = Color.parseColor(this.jdField_a_of_type_Bdtv.e);
    }
    boolean bool = a(j);
    this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextColor(j);
    this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setHintTextColor(k);
    if (bool)
    {
      this.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setTextColor(m);
      this.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor(m);
      this.jdField_a_of_type_AndroidViewView.setBackgroundColor(m);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130849116);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130845708);
    }
    for (;;)
    {
      a(bool);
      return;
      this.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setTextColor(-1711276033);
      this.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor(-1711276033);
      this.jdField_a_of_type_AndroidViewView.setBackgroundColor(-1711276033);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130849117);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130845709);
    }
  }
  
  protected void i()
  {
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.actionText)) || (this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.actionId != 0) || (this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.fontId != 0)) {}
    for (;;)
    {
      return;
      int j = this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getLineCount();
      int k = this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getGravity();
      boolean bool;
      if ((j <= 1) && ((k & 0x3) == 3))
      {
        this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setGravity(17);
        bool = true;
      }
      while (QLog.isColorLevel())
      {
        QLog.i("BaseSignViewHolder", 2, String.format("resolveLineCountGravity line=%d set=%b", new Object[] { Integer.valueOf(j), Boolean.valueOf(bool) }));
        return;
        if ((j > 1) && ((k & 0x3) != 3))
        {
          this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setGravity(19);
          bool = true;
        }
        else
        {
          bool = false;
        }
      }
    }
  }
  
  public void j()
  {
    Object localObject = this.jdField_a_of_type_AndroidWidgetImageView;
    boolean bool;
    ImageView localImageView;
    if (this.f != 0)
    {
      bool = true;
      ((ImageView)localObject).setSelected(bool);
      if (AppSetting.jdField_c_of_type_Boolean)
      {
        localImageView = this.jdField_a_of_type_AndroidWidgetImageView;
        if (this.f == 0) {
          break label59;
        }
      }
    }
    label59:
    for (localObject = this.jdField_a_of_type_AndroidContentContext.getString(2131721408);; localObject = this.jdField_a_of_type_AndroidContentContext.getString(2131721407))
    {
      localImageView.setContentDescription((CharSequence)localObject);
      return;
      bool = false;
      break;
    }
  }
  
  public void k()
  {
    if (QLog.isColorLevel()) {
      QLog.i("BaseSignViewHolder", 2, "destroy");
    }
    this.jdField_d_of_type_Boolean = true;
    ThreadManager.getUIHandlerV2().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    if ((this.jdField_a_of_type_Bdvb != null) && (this.jdField_a_of_type_Bdvb.a() != null)) {
      this.jdField_a_of_type_Bdvb.a().c();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasResDrawable != null) {
      this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasResDrawable.a();
    }
    aydw.a().deleteObserver(this.jdField_a_of_type_JavaUtilObserver);
  }
  
  protected void l()
  {
    if ((QLog.isColorLevel()) && (this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus != null)) {
      QLog.i("BaseSignViewHolder", 2, String.format("logRichStatus [tplId=%d fontId=%d fontType=%d] action[%d,%s] data[%d,%s] plainText=%s", new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.tplId), Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.fontId), Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.fontType), Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.actionId), this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.actionText, Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.dataId), this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.dataText, this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.getPlainText() }));
    }
  }
  
  public void onClick(View paramView)
  {
    ayfd localayfd;
    int j;
    if (this.jdField_a_of_type_MqqUtilWeakReference != null)
    {
      localayfd = (ayfd)this.jdField_a_of_type_MqqUtilWeakReference.get();
      switch (paramView.getId())
      {
      default: 
        j = 0;
      }
    }
    for (;;)
    {
      QLog.d("BaseSignViewHolder", 1, new Object[] { "onClick viewType=", Integer.valueOf(j) });
      if ((j > 0) && (localayfd != null)) {
        localayfd.a(paramView, j, this);
      }
      return;
      localayfd = null;
      break;
      j = 1;
      continue;
      j = 2;
      continue;
      j = 4;
      continue;
      j = 3;
    }
  }
  
  public boolean onPreDraw()
  {
    i();
    this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getViewTreeObserver().removeOnPreDrawListener(this);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayey
 * JD-Core Version:    0.7.0.1
 */