import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.ad.tangram.util.AdExposureChecker;
import com.tencent.ad.tangram.util.AdExposureChecker.ExposureCallback;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.QWalletPicHelper;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import org.jetbrains.annotations.NotNull;

public class bdsb
  extends bdom
{
  public static AdExposureChecker.ExposureCallback a;
  public static ArrayList<AdExposureChecker> b = new ArrayList();
  private static final int s = Color.parseColor("#C7C7C7");
  private int t;
  private int u;
  
  @NotNull
  private GradientDrawable a()
  {
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setCornerRadius(bhtq.a(2.0F));
    localGradientDrawable.setStroke(bhtq.b(0.25F), s);
    return localGradientDrawable;
  }
  
  @NotNull
  private ImageView a(Context paramContext, RelativeLayout paramRelativeLayout)
  {
    ImageView localImageView = new ImageView(paramContext);
    localImageView.setId(2131374958);
    int i = bhtq.b(50.0F);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(i * 16 / 9, i);
    localLayoutParams.addRule(15);
    localImageView.setImageDrawable(paramContext.getResources().getDrawable(2130847361));
    localImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    paramRelativeLayout.addView(localImageView, localLayoutParams);
    return localImageView;
  }
  
  @NotNull
  private LinearLayout a(Context paramContext, RelativeLayout paramRelativeLayout)
  {
    paramContext = new LinearLayout(paramContext);
    paramContext.setId(2131374959);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(11);
    localLayoutParams.addRule(8, 2131374958);
    paramRelativeLayout.addView(paramContext, localLayoutParams);
    return paramContext;
  }
  
  private RelativeLayout a(Context paramContext)
  {
    paramContext = new RelativeLayout(paramContext);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, bhtq.b(74.0F));
    paramContext.setPadding(this.t, 0, this.u, 0);
    paramContext.setLayoutParams(localLayoutParams);
    if (QLog.isColorLevel()) {
      QLog.i("QWalletGdtAdManager_StructMsgItemLayout31", 2, "getItemRootView...left:" + this.t + ",right:" + this.u + ",top:" + 0 + ",bottom:" + 0);
    }
    return paramContext;
  }
  
  @NotNull
  private TextView a(Context paramContext, RelativeLayout paramRelativeLayout)
  {
    TextView localTextView = new TextView(paramContext);
    localTextView.setId(2131374956);
    localTextView.setText(paramContext.getResources().getText(2131716211));
    localTextView.setSingleLine(false);
    localTextView.setMaxLines(2);
    localTextView.setEllipsize(TextUtils.TruncateAt.END);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    localLayoutParams.addRule(1, 2131374958);
    localLayoutParams.addRule(0, 2131374959);
    localLayoutParams.addRule(15);
    localLayoutParams.setMargins(bhtq.a(12.0F), 0, bhtq.a(12.0F), 0);
    paramRelativeLayout.addView(localTextView, localLayoutParams);
    a(paramContext, localTextView);
    return localTextView;
  }
  
  @NotNull
  private TextView a(Context paramContext, CharSequence paramCharSequence)
  {
    paramContext = new TextView(paramContext);
    paramContext.setId(2131374960);
    paramContext.setText(paramCharSequence);
    paramContext.setTextColor(s);
    paramContext.setTextSize(1, 10.0F);
    paramContext.setBackgroundDrawable(a());
    paramContext.setPadding(bhtq.b(0.8F), 0, 0, bhtq.b(0.8F));
    return paramContext;
  }
  
  private void a(Context paramContext, LinearLayout paramLinearLayout, int paramInt)
  {
    if (paramInt == 12) {
      paramLinearLayout.addView(a(paramContext, paramContext.getResources().getText(2131716240)));
    }
    paramContext = a(paramContext, paramContext.getResources().getText(2131716239));
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams.leftMargin = bhtq.b(2.0F);
    paramLinearLayout.addView(paramContext, localLayoutParams);
  }
  
  private void a(Context paramContext, RelativeLayout paramRelativeLayout, ImageView paramImageView, LinearLayout paramLinearLayout, TextView paramTextView)
  {
    if ((paramContext instanceof BaseActivity)) {}
    for (akxs localakxs = (akxs)((BaseActivity)paramContext).app.getManager(341);; localakxs = null)
    {
      Object localObject = new AdExposureChecker(null, new WeakReference(paramRelativeLayout));
      if ((localakxs != null) && (localakxs.a() != null) && (localakxs.a().getImageData() != null))
      {
        GdtAd localGdtAd = localakxs.a();
        int i = localGdtAd.getProductType();
        acon localacon = localGdtAd.getImageData();
        ViewGroup.LayoutParams localLayoutParams = paramImageView.getLayoutParams();
        if ((localacon.jdField_a_of_type_Int != 0) && (localacon.b != 0)) {
          localLayoutParams.width = ((int)(Math.min(Math.max(localacon.jdField_a_of_type_Int * 1.0F / localacon.b, 1.0F), 1.777778F) * localLayoutParams.height));
        }
        localObject = paramContext.getResources().getDrawable(2130847361);
        if (localacon.jdField_a_of_type_Int == localacon.b) {
          localObject = paramContext.getResources().getDrawable(2130847360);
        }
        paramImageView.setImageDrawable(QWalletPicHelper.getNetDrawableForQWallet(localacon.jdField_a_of_type_JavaLangString, (Drawable)localObject, (Drawable)localObject));
        if (QLog.isColorLevel()) {
          QLog.i("QWalletGdtAdManager_StructMsgItemLayout31", 2, "adInfo:,text:" + localGdtAd.getText() + ",url:" + localacon.jdField_a_of_type_JavaLangString + ",width:" + localacon.jdField_a_of_type_Int + ",height:" + localacon.b + ",paramsWidth:" + localLayoutParams.width + ",paramsHeight:" + localLayoutParams.height + ",productType:" + i);
        }
        paramImageView.requestLayout();
        paramTextView.setText(localGdtAd.getText());
        a(paramContext, paramLinearLayout, i);
        paramImageView = new AdExposureChecker(localGdtAd, new WeakReference(paramRelativeLayout));
        if (a == null) {
          a = new bdsc(this, localakxs, paramContext, localGdtAd);
        }
        paramImageView.setCallback(new WeakReference(a));
        paramRelativeLayout.setOnClickListener(new bdsd(this, localGdtAd, paramContext, localakxs));
        if (QLog.isColorLevel()) {
          QLog.d("QWalletGdtAdManager_StructMsgItemLayout31", 2, "updateAdInfo....startCheck view:" + this);
        }
      }
      for (paramContext = paramImageView;; paramContext = (Context)localObject)
      {
        paramContext.startCheck();
        b.add(paramContext);
        if (QLog.isColorLevel()) {
          QLog.d("QWalletGdtAdManager_StructMsgItemLayout31", 2, "updateAdInfo....adExposureCheckers size:" + b.size());
        }
        return;
        paramRelativeLayout.setOnClickListener(new bdse(this, paramContext));
      }
    }
  }
  
  private void a(Context paramContext, TextView paramTextView)
  {
    TextPaint localTextPaint;
    if ((paramContext instanceof BaseActivity))
    {
      paramContext = (alao)((BaseActivity)paramContext).app.getManager(245);
      localTextPaint = paramTextView.getPaint();
      if (paramContext.a("common", 0, new String[] { "pub_ad_control", "gdt_content_bold" }) != 1) {
        break label143;
      }
    }
    for (boolean bool = true;; bool = false)
    {
      localTextPaint.setFakeBoldText(bool);
      paramTextView.setTextSize(1, Math.min(Math.max(paramContext.a("common", 24, new String[] { "pub_ad_control", "gdt_content_size" }), 24), 36) >> 1);
      try
      {
        paramTextView.setTextColor(Color.parseColor(paramContext.a("common", "#000000", new String[] { "pub_ad_control", "gdt_content_color" })));
        return;
      }
      catch (Throwable paramContext)
      {
        label143:
        QLog.e("QWalletGdtAdManager_StructMsgItemLayout31", 1, paramContext, new Object[0]);
        paramTextView.setTextColor(Color.parseColor("#000000"));
      }
    }
  }
  
  private void a(RelativeLayout paramRelativeLayout)
  {
    int i = paramRelativeLayout.getPaddingTop();
    int j = paramRelativeLayout.getPaddingBottom();
    paramRelativeLayout.setBackgroundResource(2130838311);
    paramRelativeLayout.setPadding(this.t, i, this.u, j);
  }
  
  protected int b()
  {
    return 31;
  }
  
  public View b(Context paramContext, View paramView, Bundle paramBundle)
  {
    if (paramBundle != null) {}
    for (;;)
    {
      try
      {
        if (!paramBundle.getBoolean("isShowQWalletPubAd")) {
          return new View(paramContext);
        }
        this.t = (paramContext.getResources().getDimensionPixelSize(2131298913) - bhtq.a(3.0F));
        this.u = (paramContext.getResources().getDimensionPixelSize(2131298914) - bhtq.a(3.0F));
        if ((paramView instanceof RelativeLayout))
        {
          paramView = (RelativeLayout)paramView;
          paramView.removeAllViews();
          a(paramView);
          a(paramContext, paramView, a(paramContext, paramView), a(paramContext, paramView), a(paramContext, paramView));
          return paramView;
        }
      }
      catch (Throwable paramContext)
      {
        QLog.e("QWalletGdtAdManager_StructMsgItemLayout31", 1, paramContext, new Object[0]);
        return null;
      }
      paramView = a(paramContext);
    }
  }
  
  public String b()
  {
    return "Layout31";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdsb
 * JD-Core Version:    0.7.0.1
 */