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

public class avfr
  implements View.OnClickListener, ViewTreeObserver.OnPreDrawListener, avfv, avga, fr
{
  static int[] jdField_a_of_type_ArrayOfInt;
  Context jdField_a_of_type_AndroidContentContext;
  View jdField_a_of_type_AndroidViewView;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  baoi jdField_a_of_type_Baoi;
  bapn jdField_a_of_type_Bapn;
  private bapt jdField_a_of_type_Bapt = new avfs(this);
  public ETTextView a;
  AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  public RichStatus a;
  BoxShadowLayout jdField_a_of_type_ComTencentMobileqqRichstatusSignBoxShadowLayout;
  VasResDrawable jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasResDrawable;
  SingleLineTextView jdField_a_of_type_ComTencentWidgetSingleLineTextView;
  Runnable jdField_a_of_type_JavaLangRunnable = new BaseSignViewHolder.3(this);
  public Observer a;
  WeakReference<avfw> jdField_a_of_type_MqqUtilWeakReference;
  boolean jdField_a_of_type_Boolean;
  long jdField_b_of_type_Long;
  View jdField_b_of_type_AndroidViewView;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  SingleLineTextView jdField_b_of_type_ComTencentWidgetSingleLineTextView;
  WeakReference<avga> jdField_b_of_type_MqqUtilWeakReference;
  boolean jdField_b_of_type_Boolean = false;
  View jdField_c_of_type_AndroidViewView;
  public String c;
  boolean jdField_c_of_type_Boolean;
  View d;
  public boolean d;
  int e;
  public int f;
  int g;
  
  public avfr(Context paramContext, AppInterface paramAppInterface, View paramView, String paramString)
  {
    this.jdField_a_of_type_JavaUtilObserver = new avft(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqRichstatusSignBoxShadowLayout = ((BoxShadowLayout)paramView);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_c_of_type_JavaLangString = paramString;
    m();
    a();
    avep.a().addObserver(this.jdField_a_of_type_JavaUtilObserver);
  }
  
  private void m()
  {
    if (jdField_a_of_type_ArrayOfInt == null)
    {
      jdField_a_of_type_ArrayOfInt = new int[16];
      jdField_a_of_type_ArrayOfInt[0] = this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131100728);
      jdField_a_of_type_ArrayOfInt[1] = this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131100729);
      jdField_a_of_type_ArrayOfInt[2] = this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131100730);
      jdField_a_of_type_ArrayOfInt[3] = this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131100732);
      jdField_a_of_type_ArrayOfInt[4] = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131167167);
      jdField_a_of_type_ArrayOfInt[5] = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131167166);
      jdField_a_of_type_ArrayOfInt[6] = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131167168);
      jdField_a_of_type_ArrayOfInt[7] = aciy.a(16.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      jdField_a_of_type_ArrayOfInt[8] = aciy.a(17.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      jdField_a_of_type_ArrayOfInt[9] = aciy.a(20.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      jdField_a_of_type_ArrayOfInt[10] = aciy.a(8.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      jdField_a_of_type_ArrayOfInt[11] = aciy.a(12.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      jdField_a_of_type_ArrayOfInt[12] = this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131100731);
      jdField_a_of_type_ArrayOfInt[13] = this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131100728);
      jdField_a_of_type_ArrayOfInt[14] = this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131101549);
      jdField_a_of_type_ArrayOfInt[15] = this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131101537);
    }
  }
  
  private void n()
  {
    int m = 0;
    boolean bool1 = b();
    boolean bool2 = c();
    boolean bool3 = d();
    boolean bool4 = e();
    Object localObject;
    if (bool1)
    {
      localObject = baiu.c(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.time * 1000L);
      this.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText((CharSequence)localObject);
    }
    label123:
    int j;
    for (int i = 1;; j = 0)
    {
      localObject = this.jdField_a_of_type_ComTencentWidgetSingleLineTextView;
      int k;
      if (bool1)
      {
        k = 0;
        ((SingleLineTextView)localObject).setVisibility(k);
        if (!bool2) {
          break label267;
        }
        if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.locationText)) {
          break label246;
        }
        this.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setText(this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.locationText);
        this.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setVisibility(0);
        i = 1;
        localObject = this.jdField_a_of_type_AndroidViewView;
        if ((i == 0) || (!bool4)) {
          break label279;
        }
        k = 0;
        label140:
        ((View)localObject).setVisibility(k);
        localObject = this.jdField_b_of_type_AndroidWidgetImageView;
        if (!bool3) {
          break label285;
        }
        k = 0;
        label159:
        ((ImageView)localObject).setVisibility(k);
        localObject = this.jdField_a_of_type_AndroidWidgetImageView;
        if (!bool3) {
          break label291;
        }
        k = 0;
        label178:
        ((ImageView)localObject).setVisibility(k);
        j();
        localObject = (ViewGroup.MarginLayoutParams)this.jdField_c_of_type_AndroidViewView.getLayoutParams();
        if (!bool3) {
          break label297;
        }
        k = jdField_a_of_type_ArrayOfInt[6];
        label212:
        ((ViewGroup.MarginLayoutParams)localObject).rightMargin = k;
        localObject = this.jdField_b_of_type_AndroidViewView;
        if ((i | bool3) == 0) {
          break label302;
        }
      }
      label267:
      label279:
      label285:
      label291:
      label297:
      label302:
      for (i = m;; j = 8)
      {
        ((View)localObject).setVisibility(i);
        return;
        k = 8;
        break;
        label246:
        this.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setText("");
        this.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setVisibility(8);
        break label123;
        this.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setVisibility(8);
        break label123;
        k = 8;
        break label140;
        k = 8;
        break label159;
        k = 8;
        break label178;
        k = 0;
        break label212;
      }
    }
  }
  
  private void o()
  {
    int i;
    label24:
    Object localObject2;
    if (this.jdField_a_of_type_Baoi.jdField_a_of_type_Baok != null)
    {
      i = 1;
      if (i == 0) {
        break label206;
      }
      localObject1 = this.jdField_a_of_type_Baoi.n;
      if (!this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getText().equals(localObject1)) {
        this.jdField_b_of_type_Long = System.currentTimeMillis();
      }
      localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        if ((this.jdField_a_of_type_Baoi.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) || (TextUtils.isEmpty(this.jdField_a_of_type_Baoi.n))) {
          break label223;
        }
      }
    }
    label206:
    label223:
    for (Object localObject1 = this.jdField_a_of_type_Baoi.n;; localObject1 = "")
    {
      if (this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.plainText == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.plainText = new ArrayList(2);
        this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.plainText.add("");
        this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.plainText.add("");
      }
      localObject2 = localObject1;
      if (this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.tplId != 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.plainText.set(0, ((CharSequence)localObject1).toString());
        localObject2 = localObject1;
      }
      this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextMsg(new axkd(localObject2, 1, 20));
      this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getViewTreeObserver().addOnPreDrawListener(this);
      return;
      i = 0;
      break;
      localObject1 = a(this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus, this, this.g);
      break label24;
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
    this.jdField_a_of_type_Baoi = a();
    paramRichStatus.signType = this.jdField_a_of_type_Baoi.g;
    boolean bool;
    if (this.jdField_a_of_type_Baoi.jdField_a_of_type_Baok != null)
    {
      bool = true;
      this.jdField_a_of_type_Boolean = bool;
      this.jdField_b_of_type_Boolean = this.jdField_a_of_type_Baoi.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
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
  
  protected baoi a()
  {
    return avep.a().a(this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.tplId);
  }
  
  protected CharSequence a(RichStatus paramRichStatus, avga paramavga, int paramInt)
  {
    if (!(this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface)) {
      return "";
    }
    if (paramRichStatus == null) {
      return new SpannableString("");
    }
    avev localavev = (avev)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(15);
    Resources localResources = this.jdField_a_of_type_AndroidContentContext.getResources();
    SpannableString localSpannableString = new SpannableString(paramRichStatus.toSpannableStringWithoutAction(paramavga));
    if ((paramRichStatus != null) && (localResources != null) && (!TextUtils.isEmpty(paramRichStatus.actionText)))
    {
      Object localObject = paramRichStatus.actionText;
      paramavga = (avga)localObject;
      if (!TextUtils.isEmpty(paramRichStatus.dataText)) {
        paramavga = (String)localObject + paramRichStatus.dataText;
      }
      Drawable localDrawable = localResources.getDrawable(2130848308);
      localObject = new SpannableStringBuilder(localSpannableString);
      ((SpannableStringBuilder)localObject).insert(0, "[S] ");
      int i;
      if (localavev != null)
      {
        paramRichStatus = localavev.a(paramRichStatus.actionId, 200);
        paramRichStatus = new bboi(localResources, paramRichStatus, false, false);
        paramRichStatus.setBounds(0, 0, paramInt, paramInt);
        i = Color.parseColor("#ffa8a8a8");
        if ((Build.VERSION.SDK_INT < 4) || (Build.VERSION.SDK_INT == 20)) {
          break label273;
        }
      }
      label273:
      for (paramRichStatus = new avdg(paramRichStatus, 1, paramavga, i, localDrawable, paramInt);; paramRichStatus = new avdg(paramRichStatus, 0, paramavga, i, localDrawable, paramInt))
      {
        ((SpannableStringBuilder)localObject).setSpan(paramRichStatus, 0, "[S]".length(), 17);
        return new axkd((CharSequence)localObject, 1);
        paramRichStatus = azvq.a(localResources, 2130848301);
        break;
      }
    }
    return new axkd(localSpannableString, 1);
  }
  
  protected void a()
  {
    int i = b();
    int j = jdField_a_of_type_ArrayOfInt[7];
    this.g = jdField_a_of_type_ArrayOfInt[8];
    int k = jdField_a_of_type_ArrayOfInt[10];
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131495521, null, false));
    this.jdField_a_of_type_ComTencentMobileqqRichstatusSignBoxShadowLayout.a(this.jdField_a_of_type_AndroidWidgetLinearLayout, i, j, jdField_a_of_type_ArrayOfInt[3]);
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqRichstatusSignBoxShadowLayout.findViewById(2131309634);
    this.jdField_d_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqRichstatusSignBoxShadowLayout.findViewById(2131303700);
    this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqRichstatusSignBoxShadowLayout.findViewById(2131303784);
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqRichstatusSignBoxShadowLayout.findViewById(2131299701);
    this.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)this.jdField_a_of_type_ComTencentMobileqqRichstatusSignBoxShadowLayout.findViewById(2131312550));
    this.jdField_b_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)this.jdField_a_of_type_ComTencentMobileqqRichstatusSignBoxShadowLayout.findViewById(2131312420));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_ComTencentMobileqqRichstatusSignBoxShadowLayout.findViewById(2131302913));
    vms.a(this.jdField_b_of_type_AndroidWidgetImageView, k, k, k, k);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_ComTencentMobileqqRichstatusSignBoxShadowLayout.findViewById(2131303097));
    vms.a(this.jdField_a_of_type_AndroidWidgetImageView, k, k, k, k);
    this.jdField_a_of_type_ComEtrumpMixlayoutETTextView = ((ETTextView)this.jdField_a_of_type_ComTencentMobileqqRichstatusSignBoxShadowLayout.findViewById(2131312524));
    this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setOnTextOrFontChangeListener(this);
    this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setMovementMethod(avgb.a());
    this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setGravity(19);
    this.jdField_b_of_type_AndroidWidgetImageView.setOnTouchListener(mjg.a);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnTouchListener(mjg.a);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnTouchListener(mjg.a);
    this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
  }
  
  public void a(avfw paramavfw)
  {
    if (paramavfw != null)
    {
      this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramavfw);
      return;
    }
    this.jdField_a_of_type_MqqUtilWeakReference = null;
  }
  
  public void a(avfz paramavfz, View paramView)
  {
    QLog.d("BaseSignViewHolder", 1, new Object[] { "onClick topic=", paramavfz });
    if (this.jdField_b_of_type_MqqUtilWeakReference != null) {}
    for (avga localavga = (avga)this.jdField_b_of_type_MqqUtilWeakReference.get();; localavga = null)
    {
      if (localavga != null) {
        localavga.a(paramavfz, paramView);
      }
      return;
    }
  }
  
  public void a(avga paramavga)
  {
    if (paramavga != null)
    {
      this.jdField_b_of_type_MqqUtilWeakReference = new WeakReference(paramavga);
      return;
    }
    this.jdField_b_of_type_MqqUtilWeakReference = null;
  }
  
  public void a(ETTextView paramETTextView)
  {
    avgf.a(paramETTextView, paramETTextView.getText(), 1);
  }
  
  public void a(ETTextView paramETTextView, CharSequence paramCharSequence)
  {
    avgf.a(paramETTextView, paramCharSequence, 0);
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
    return jdField_a_of_type_ArrayOfInt[9];
  }
  
  public View b()
  {
    return this.jdField_d_of_type_AndroidViewView;
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
    int i = jdField_a_of_type_ArrayOfInt[0];
    int j = jdField_a_of_type_ArrayOfInt[1];
    int k = jdField_a_of_type_ArrayOfInt[2];
    int m = jdField_a_of_type_ArrayOfInt[3];
    this.jdField_a_of_type_ComTencentMobileqqRichstatusSignBoxShadowLayout.setShadowColor(m);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundResource(2130845183);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setTag(2131310412, Integer.valueOf(-1));
    e();
    this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextColor(i);
    this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setHintTextColor(j);
    this.jdField_a_of_type_AndroidViewView.setBackgroundColor(k);
    this.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setTextColor(k);
    this.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor(k);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130848375);
    this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130845181);
    a(true);
  }
  
  protected boolean d()
  {
    return true;
  }
  
  protected void e()
  {
    int i = jdField_a_of_type_ArrayOfInt[4];
    int j = jdField_a_of_type_ArrayOfInt[5];
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setPadding(j, i, j, i);
  }
  
  protected boolean e()
  {
    return true;
  }
  
  protected void f()
  {
    boolean bool = true;
    if (this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.tplId == 1)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundResource(2130845183);
      return;
    }
    baqe localbaqe;
    if (this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasResDrawable == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasResDrawable = new VasResDrawable(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.tplId);
      localbaqe = new baqe(this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasResDrawable, this.jdField_a_of_type_ComTencentCommonAppAppInterface);
      this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasResDrawable.a(localbaqe);
      if (a() != -1) {
        break label185;
      }
    }
    for (;;)
    {
      localbaqe.a(bool);
      this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasResDrawable.a(this.jdField_a_of_type_Bapt);
      this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasResDrawable.a(jdField_a_of_type_ArrayOfInt[7]);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasResDrawable);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setTag(2131310412, Integer.valueOf(this.jdField_a_of_type_Baoi.f));
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setTag(2131310415, Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.tplId));
      this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasResDrawable.b(this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.tplId);
      e();
      return;
      label185:
      bool = false;
    }
  }
  
  protected void g()
  {
    boolean bool = true;
    int i = this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.fontId;
    int j = this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.fontType;
    if (i == 0)
    {
      this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setFont(i, 0L);
      return;
    }
    if (this.jdField_a_of_type_Bapn == null)
    {
      this.jdField_a_of_type_Bapn = new bapn(this.jdField_a_of_type_ComTencentCommonAppAppInterface, i);
      localbaqg = new baqg(this.jdField_a_of_type_Bapn, this.jdField_a_of_type_ComTencentCommonAppAppInterface, j);
      localETTextView = this.jdField_a_of_type_ComEtrumpMixlayoutETTextView;
      f1 = this.g;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.toSpannableStringWithoutAction())) {}
      for (bool = true;; bool = false)
      {
        localbaqg.a(localETTextView, f1, bool);
        this.jdField_a_of_type_Bapn.a(localbaqg);
        localbaqg.a(a());
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setTag(2131310413, Integer.valueOf(i));
        return;
      }
    }
    baqg localbaqg = (baqg)this.jdField_a_of_type_Bapn.a();
    ETTextView localETTextView = this.jdField_a_of_type_ComEtrumpMixlayoutETTextView;
    float f1 = this.g;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.toSpannableStringWithoutAction())) {}
    for (;;)
    {
      localbaqg.a(localETTextView, f1, bool);
      ((baqg)this.jdField_a_of_type_Bapn.a()).a(i, j);
      break;
      bool = false;
    }
  }
  
  protected void h()
  {
    int i = jdField_a_of_type_ArrayOfInt[0];
    int j = jdField_a_of_type_ArrayOfInt[1];
    int k = jdField_a_of_type_ArrayOfInt[2];
    int m = jdField_a_of_type_ArrayOfInt[3];
    this.jdField_a_of_type_ComTencentMobileqqRichstatusSignBoxShadowLayout.setShadowColor(m);
    if (!TextUtils.isEmpty(this.jdField_a_of_type_Baoi.e)) {
      i = Color.parseColor(this.jdField_a_of_type_Baoi.e);
    }
    boolean bool = a(i);
    this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextColor(i);
    this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setHintTextColor(j);
    if (bool)
    {
      this.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setTextColor(k);
      this.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor(k);
      this.jdField_a_of_type_AndroidViewView.setBackgroundColor(k);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130848375);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130845181);
    }
    for (;;)
    {
      a(bool);
      return;
      this.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setTextColor(-1711276033);
      this.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor(-1711276033);
      this.jdField_a_of_type_AndroidViewView.setBackgroundColor(-1711276033);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130848376);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130845182);
    }
  }
  
  protected void i()
  {
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.actionText)) || (this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.actionId != 0) || (this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.fontId != 0)) {}
    for (;;)
    {
      return;
      int i = this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getLineCount();
      int j = this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getGravity();
      boolean bool;
      if ((i <= 1) && ((j & 0x3) == 3))
      {
        this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setGravity(17);
        bool = true;
      }
      while (QLog.isColorLevel())
      {
        QLog.i("BaseSignViewHolder", 2, String.format("resolveLineCountGravity line=%d set=%b", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool) }));
        return;
        if ((i > 1) && ((j & 0x3) != 3))
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
    for (localObject = this.jdField_a_of_type_AndroidContentContext.getString(2131654941);; localObject = this.jdField_a_of_type_AndroidContentContext.getString(2131654940))
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
    if ((this.jdField_a_of_type_Bapn != null) && (this.jdField_a_of_type_Bapn.a() != null)) {
      this.jdField_a_of_type_Bapn.a().b();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasResDrawable != null) {
      this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasResDrawable.a();
    }
    avep.a().deleteObserver(this.jdField_a_of_type_JavaUtilObserver);
  }
  
  protected void l()
  {
    if ((QLog.isColorLevel()) && (this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus != null)) {
      QLog.i("BaseSignViewHolder", 2, String.format("logRichStatus [tplId=%d fontId=%d fontType=%d] action[%d,%s] data[%d,%s] plainText=%s", new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.tplId), Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.fontId), Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.fontType), Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.actionId), this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.actionText, Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.dataId), this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.dataText, this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.getPlainText() }));
    }
  }
  
  public void onClick(View paramView)
  {
    avfw localavfw;
    int i;
    if (this.jdField_a_of_type_MqqUtilWeakReference != null)
    {
      localavfw = (avfw)this.jdField_a_of_type_MqqUtilWeakReference.get();
      switch (paramView.getId())
      {
      default: 
        i = 0;
      }
    }
    for (;;)
    {
      QLog.d("BaseSignViewHolder", 1, new Object[] { "onClick viewType=", Integer.valueOf(i) });
      if ((i > 0) && (localavfw != null)) {
        localavfw.a(paramView, i, this);
      }
      return;
      localavfw = null;
      break;
      i = 1;
      continue;
      i = 2;
      continue;
      i = 4;
      continue;
      i = 3;
    }
  }
  
  public boolean onPreDraw()
  {
    i();
    this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getViewTreeObserver().removeOnPreDrawListener(this);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     avfr
 * JD-Core Version:    0.7.0.1
 */