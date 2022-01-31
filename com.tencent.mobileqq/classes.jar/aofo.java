import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
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
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.extendfriend.wiget.FeedBannerItemGradientLinearLayout;
import com.tencent.mobileqq.extendfriend.wiget.TabLayout;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.mobileqq.widget.RoundCorneredRelativeLayout;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class aofo
  extends RecyclerView.ViewHolder
{
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private aojb jdField_a_of_type_Aojb;
  private aolh jdField_a_of_type_Aolh;
  
  public aofo(View paramView, aojb paramaojb)
  {
    super(paramView);
    this.jdField_a_of_type_Aojb = paramaojb;
  }
  
  private void a(Context paramContext, aofn paramaofn)
  {
    if ((paramaofn == null) || (paramContext == null)) {
      if (QLog.isColorLevel()) {
        QLog.e("FeedBannerViewHolder", 2, "jumpUrl bannerTabItem or context null ");
      }
    }
    label196:
    do
    {
      String str;
      do
      {
        int i;
        do
        {
          do
          {
            return;
            str = paramaofn.d;
            i = paramaofn.jdField_a_of_type_Int;
            if (QLog.isColorLevel()) {
              QLog.d("FeedBannerViewHolder", 2, "parse banner jumpUrl " + str + ", type =" + i);
            }
            if (i != 0) {
              break;
            }
          } while (this.jdField_a_of_type_Aojb == null);
          this.jdField_a_of_type_Aojb.d();
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
      paramaofn = new Intent(paramContext, QQBrowserActivity.class);
      paramaofn.putExtra("url", str);
      paramContext.startActivity(paramaofn);
      return;
    } while (!QLog.isColorLevel());
    QLog.e("FeedBannerViewHolder", 2, "jumpUrl is not support ");
  }
  
  private void a(View paramView, aofn paramaofn, int paramInt1, int paramInt2)
  {
    int i = bbll.a(5.0F);
    ((RoundCorneredRelativeLayout)paramView).setRadius(i, i, i, i);
    Object localObject2 = (ImageView)paramView.findViewById(2131367679);
    TextView localTextView1 = (TextView)paramView.findViewById(2131377350);
    TextView localTextView2 = (TextView)paramView.findViewById(2131376621);
    if (!TextUtils.isEmpty(paramaofn.jdField_a_of_type_JavaLangString)) {
      localTextView1.setText(paramaofn.jdField_a_of_type_JavaLangString);
    }
    if (!TextUtils.isEmpty(paramaofn.jdField_b_of_type_JavaLangString)) {
      localTextView2.setText(paramaofn.jdField_b_of_type_JavaLangString);
    }
    Object localObject1 = (FeedBannerItemGradientLinearLayout)paramView.findViewById(2131367133);
    if (paramInt2 == 1)
    {
      i = 24;
      ((FeedBannerItemGradientLinearLayout)localObject1).a(bbll.a(i), paramaofn.jdField_b_of_type_Int, paramaofn.jdField_c_of_type_Int);
      localObject1 = (FrameLayout)paramView.findViewById(2131367681);
      if (paramaofn.jdField_a_of_type_Int != 0) {
        break label338;
      }
      ((ImageView)localObject2).setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView = localTextView2;
      localObject2 = paramView.getContext().getResources().getDrawable(2130844289);
      ((Drawable)localObject2).setBounds(bbll.a(1.0F), 0, bbll.a(7.0F), bbll.a(6.0F));
      localTextView2.setCompoundDrawablePadding(bbll.a(3.0F));
      localTextView2.setCompoundDrawables((Drawable)localObject2, null, null, null);
      if (paramInt2 == 2) {
        ((ViewGroup.MarginLayoutParams)localTextView2.getLayoutParams()).rightMargin = (-bbll.a(20.0F));
      }
      a((FrameLayout)localObject1, paramInt2);
      a(paramaofn);
    }
    for (;;)
    {
      localObject2 = (ImageView)paramView.findViewById(2131364800);
      Object localObject3 = Drawable.createFromPath(aojm.a(paramInt2));
      if (localObject3 != null) {
        ((ImageView)localObject2).setImageDrawable((Drawable)localObject3);
      }
      paramView.setOnTouchListener(new aofq(this, paramView.findViewById(2131371896), (FrameLayout)localObject1, localTextView1, localTextView2, paramaofn, paramInt1));
      return;
      if (paramInt2 == 2)
      {
        i = 22;
        break;
      }
      i = 40;
      break;
      label338:
      if (paramaofn.jdField_c_of_type_JavaLangString != null)
      {
        try
        {
          localObject3 = new URL(paramaofn.jdField_c_of_type_JavaLangString);
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
    if (this.jdField_a_of_type_Aolh != null) {
      this.jdField_a_of_type_Aolh.d();
    }
    int i;
    FrameLayout.LayoutParams localLayoutParams;
    if (paramInt <= 2)
    {
      i = 2;
      this.jdField_a_of_type_Aolh = new aolh(i);
      if (this.jdField_a_of_type_Aolh.a() != null)
      {
        localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
        if (paramInt > 2) {
          break label99;
        }
      }
    }
    label99:
    for (paramInt = bbll.a(16.0F);; paramInt = bbll.a(22.0F))
    {
      localLayoutParams.bottomMargin = paramInt;
      localLayoutParams.topMargin = paramInt;
      paramFrameLayout.addView(this.jdField_a_of_type_Aolh.a(), localLayoutParams);
      return;
      i = 3;
      break;
    }
  }
  
  private void a(aofn paramaofn, int paramInt)
  {
    a(paramaofn, paramInt, "0X800A9B1");
    a(this.itemView.getContext(), paramaofn);
  }
  
  private void a(aofn paramaofn, int paramInt, String paramString)
  {
    if ((paramaofn != null) && (paramaofn.jdField_a_of_type_Int != 0))
    {
      String str1 = paramaofn.jdField_a_of_type_JavaLangString;
      String str2 = paramaofn.jdField_b_of_type_JavaLangString;
      long l = paramaofn.jdField_a_of_type_Long;
      axqy.b(null, "dc00898", "", "", "qq_kuolie", paramString, 0, 0, paramInt + "", "", l + ";" + str1, str2);
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Aolh != null) {
      this.jdField_a_of_type_Aolh.d();
    }
  }
  
  public void a(aofn paramaofn)
  {
    if ((this.jdField_a_of_type_AndroidWidgetTextView != null) && (paramaofn.jdField_b_of_type_JavaLangString != null)) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramaofn.jdField_b_of_type_JavaLangString);
    }
    if ((this.jdField_a_of_type_Aolh != null) && (paramaofn.jdField_a_of_type_JavaUtilArrayList != null)) {
      this.jdField_a_of_type_Aolh.a(paramaofn.jdField_a_of_type_JavaUtilArrayList);
    }
  }
  
  public void a(aogm paramaogm, int paramInt)
  {
    Object localObject;
    ViewGroup.LayoutParams localLayoutParams;
    int i;
    if (((paramaogm instanceof aofm)) && ((this.itemView instanceof TabLayout)))
    {
      localObject = (aofm)paramaogm;
      paramaogm = (TabLayout)this.itemView;
      paramaogm.setPadding(paramaogm.getPaddingLeft(), paramInt, paramaogm.getPaddingRight(), paramaogm.getPaddingBottom());
      localObject = ((aofm)localObject).jdField_a_of_type_JavaUtilArrayList;
      localLayoutParams = paramaogm.getLayoutParams();
      i = ((ArrayList)localObject).size();
      if (i != 1) {
        break label129;
      }
      i = 122;
    }
    for (;;)
    {
      i = bbll.a(i);
      if (localLayoutParams != null) {
        localLayoutParams.height = (i + paramInt);
      }
      paramaogm.a().setMinimumHeight(i);
      paramaogm.a(new aofp(this, (ArrayList)localObject, bbll.a(120.0F), bbll.a(4.0F)));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aofo
 * JD-Core Version:    0.7.0.1
 */