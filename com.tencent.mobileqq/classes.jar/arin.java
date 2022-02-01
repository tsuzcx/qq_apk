import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.extendfriend.wiget.FeedBannerItemGradientLinearLayout;
import com.tencent.mobileqq.extendfriend.wiget.TabLayout;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.RoundCorneredRelativeLayout;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class arin
  extends RecyclerView.ViewHolder
{
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ariq jdField_a_of_type_Ariq;
  private arqt jdField_a_of_type_Arqt;
  
  public arin(View paramView, ariq paramariq)
  {
    super(paramView);
    this.jdField_a_of_type_Ariq = paramariq;
  }
  
  private void a(Context paramContext, arim paramarim)
  {
    if ((paramarim == null) || (paramContext == null)) {
      if (QLog.isColorLevel()) {
        QLog.e("FeedBannerViewHolder", 2, "jumpUrl bannerTabItem or context null ");
      }
    }
    label196:
    do
    {
      do
      {
        String str;
        int i;
        do
        {
          do
          {
            do
            {
              return;
              str = paramarim.d;
              i = paramarim.jdField_a_of_type_Int;
              if (QLog.isColorLevel()) {
                QLog.d("FeedBannerViewHolder", 2, "parse banner jumpUrl " + str + ", type =" + i);
              }
              if (i != 0) {
                break;
              }
            } while (this.jdField_a_of_type_Ariq == null);
            this.jdField_a_of_type_Ariq.a();
            return;
            if (i != 1) {
              break;
            }
            if (MiniAppLauncher.isMiniAppUrl(str))
            {
              MiniAppLauncher.startMiniApp(this.itemView.getContext(), str, 2065, null);
              return;
            }
          } while (!QLog.isColorLevel());
          QLog.e("FeedBannerViewHolder", 2, "jumpUrl is not scheme ");
          return;
          if (i != 2) {
            break label196;
          }
          if (!TextUtils.isEmpty(str)) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.e("FeedBannerViewHolder", 2, "web jumpUrl is null ");
        return;
        paramarim = new Intent(paramContext, QQBrowserActivity.class);
        paramarim.putExtra("url", str);
        paramContext.startActivity(paramarim);
        return;
        if (i != 3) {
          break;
        }
        try
        {
          paramarim = new Intent(BaseApplicationImpl.getContext(), JumpActivity.class);
          paramarim.setData(Uri.parse(str));
          paramContext.startActivity(paramarim);
          paramContext = new Bundle();
          paramContext.putString("action", "click");
          paramContext.putString("page", "kuolie");
          paramContext.putString("module", "selfstudy");
          bcqg.a(paramContext);
          return;
        }
        catch (Exception paramContext) {}
      } while (!QLog.isColorLevel());
      QLog.e("FeedBannerViewHolder", 2, "click studyroom", paramContext);
      return;
    } while (!QLog.isColorLevel());
    QLog.e("FeedBannerViewHolder", 2, "jumpUrl is not support ");
  }
  
  private void a(View paramView, arim paramarim, int paramInt1, int paramInt2)
  {
    int i = ViewUtils.dip2px(5.0F);
    ((RoundCorneredRelativeLayout)paramView).setRadius(i, i, i, i);
    Object localObject2 = (ImageView)paramView.findViewById(2131368236);
    TextView localTextView1 = (TextView)paramView.findViewById(2131378707);
    TextView localTextView2 = (TextView)paramView.findViewById(2131377914);
    if (!TextUtils.isEmpty(paramarim.jdField_a_of_type_JavaLangString)) {
      localTextView1.setText(paramarim.jdField_a_of_type_JavaLangString);
    }
    if (!TextUtils.isEmpty(paramarim.jdField_b_of_type_JavaLangString)) {
      localTextView2.setText(paramarim.jdField_b_of_type_JavaLangString);
    }
    Object localObject1 = (FeedBannerItemGradientLinearLayout)paramView.findViewById(2131367671);
    if (paramInt2 == 1)
    {
      i = 24;
      ((FeedBannerItemGradientLinearLayout)localObject1).a(ViewUtils.dip2px(i), paramarim.jdField_b_of_type_Int, paramarim.jdField_c_of_type_Int);
      localObject1 = (FrameLayout)paramView.findViewById(2131368239);
      if (paramarim.jdField_a_of_type_Int != 0) {
        break label387;
      }
      ((ImageView)localObject2).setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView = localTextView2;
      localObject2 = paramView.getContext().getResources().getDrawable(2130845009);
      ((Drawable)localObject2).setBounds(ViewUtils.dip2px(1.0F), 0, ViewUtils.dip2px(7.0F), ViewUtils.dip2px(6.0F));
      localTextView2.setCompoundDrawablePadding(ViewUtils.dip2px(3.0F));
      localTextView2.setCompoundDrawables((Drawable)localObject2, null, null, null);
      if (paramInt2 != 2) {
        break label339;
      }
      ((ViewGroup.MarginLayoutParams)localTextView2.getLayoutParams()).rightMargin = ViewUtils.dip2px(80.0F);
      label244:
      a((FrameLayout)localObject1, paramInt2);
      a(paramarim);
    }
    for (;;)
    {
      localObject2 = (ImageView)paramView.findViewById(2131365189);
      Object localObject3 = Drawable.createFromPath(arnf.a(paramInt2));
      if (localObject3 != null) {
        ((ImageView)localObject2).setImageDrawable((Drawable)localObject3);
      }
      paramView.setOnTouchListener(new arip(this, paramView.findViewById(2131372907), (FrameLayout)localObject1, localTextView1, localTextView2, paramarim, paramInt1));
      return;
      if (paramInt2 == 2)
      {
        i = 22;
        break;
      }
      i = 40;
      break;
      label339:
      if (paramInt2 != 1) {
        break label244;
      }
      localTextView1.setTextSize(25.0F);
      localTextView2.setTextSize(12.0F);
      localTextView2.setPadding(0, ViewUtils.dip2px(2.0F), 0, 0);
      paramView.findViewById(2131362982).setVisibility(0);
      break label244;
      label387:
      if (paramarim.jdField_c_of_type_JavaLangString != null)
      {
        try
        {
          localObject3 = new URL(paramarim.jdField_c_of_type_JavaLangString);
          ColorDrawable localColorDrawable1 = new ColorDrawable(0);
          ColorDrawable localColorDrawable2 = new ColorDrawable(0);
          URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
          localURLDrawableOptions.mLoadingDrawable = localColorDrawable1;
          localURLDrawableOptions.mFailedDrawable = localColorDrawable2;
          localURLDrawableOptions.mUseApngImage = true;
          localURLDrawableOptions.mMemoryCacheKeySuffix = "useAPNG";
          ((ImageView)localObject2).setImageDrawable(URLDrawable.getDrawable((URL)localObject3, localURLDrawableOptions));
        }
        catch (MalformedURLException localMalformedURLException) {}
        if (QLog.isColorLevel()) {
          QLog.e("FeedBannerViewHolder", 2, "setImageUrl error " + localMalformedURLException.toString());
        }
      }
    }
  }
  
  private void a(FrameLayout paramFrameLayout, int paramInt)
  {
    int j = 3;
    if (this.jdField_a_of_type_Arqt != null) {
      this.jdField_a_of_type_Arqt.d();
    }
    int i;
    FrameLayout.LayoutParams localLayoutParams;
    if (paramInt == 1)
    {
      i = 4;
      this.jdField_a_of_type_Arqt = new arqt(i);
      if (this.jdField_a_of_type_Arqt.a() != null)
      {
        localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
        if (paramInt != 1) {
          break label129;
        }
        localLayoutParams.bottomMargin = ViewUtils.dip2px(20.0F);
        localLayoutParams.topMargin = ViewUtils.dip2px(16.0F);
        if (paramInt != 1) {
          break label166;
        }
      }
    }
    label129:
    label166:
    for (paramInt = j;; paramInt = 5)
    {
      localLayoutParams.gravity = paramInt;
      paramFrameLayout.addView(this.jdField_a_of_type_Arqt.a(), localLayoutParams);
      return;
      if (paramInt <= 2)
      {
        i = 2;
        break;
      }
      i = 3;
      break;
      if (paramInt <= 2) {}
      for (i = ViewUtils.dip2px(16.0F);; i = ViewUtils.dip2px(22.0F))
      {
        localLayoutParams.bottomMargin = i;
        localLayoutParams.topMargin = i;
        break;
      }
    }
  }
  
  private void a(arim paramarim, int paramInt)
  {
    a(paramarim, paramInt, "0X800A9B1");
    a(this.itemView.getContext(), paramarim);
  }
  
  private void a(arim paramarim, int paramInt, String paramString)
  {
    if ((paramarim != null) && (paramarim.jdField_a_of_type_Int != 0))
    {
      String str1 = paramarim.jdField_a_of_type_JavaLangString;
      String str2 = paramarim.jdField_b_of_type_JavaLangString;
      long l = paramarim.jdField_a_of_type_Long;
      bcef.b(null, "dc00898", "", "", "qq_kuolie", paramString, 0, 0, paramInt + "", "", l + ";" + str1, str2);
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Arqt != null) {
      this.jdField_a_of_type_Arqt.d();
    }
  }
  
  public void a(arim paramarim)
  {
    if ((this.jdField_a_of_type_AndroidWidgetTextView != null) && (paramarim.jdField_b_of_type_JavaLangString != null)) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramarim.jdField_b_of_type_JavaLangString);
    }
    if ((this.jdField_a_of_type_Arqt != null) && (paramarim.jdField_a_of_type_JavaUtilArrayList != null)) {
      this.jdField_a_of_type_Arqt.a(paramarim.jdField_a_of_type_JavaUtilArrayList);
    }
  }
  
  public void a(arjk paramarjk, int paramInt)
  {
    Object localObject;
    ViewGroup.LayoutParams localLayoutParams;
    int i;
    if (((paramarjk instanceof aril)) && ((this.itemView instanceof TabLayout)))
    {
      localObject = (aril)paramarjk;
      paramarjk = (TabLayout)this.itemView;
      paramarjk.setPadding(paramarjk.getPaddingLeft(), paramInt, paramarjk.getPaddingRight(), paramarjk.getPaddingBottom());
      localObject = ((aril)localObject).jdField_a_of_type_JavaUtilArrayList;
      localLayoutParams = paramarjk.getLayoutParams();
      i = ((ArrayList)localObject).size();
      if (i != 1) {
        break label129;
      }
      i = 122;
    }
    for (;;)
    {
      i = ViewUtils.dip2px(i);
      if (localLayoutParams != null) {
        localLayoutParams.height = (i + paramInt);
      }
      paramarjk.a().setMinimumHeight(i);
      paramarjk.a(new ario(this, (ArrayList)localObject, ViewUtils.dip2px(120.0F), ViewUtils.dip2px(4.0F)));
      return;
      label129:
      if (i == 2) {
        i = 108;
      } else {
        i = 168;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arin
 * JD-Core Version:    0.7.0.1
 */