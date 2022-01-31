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

public class aofj
  extends RecyclerView.ViewHolder
{
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private aoiw jdField_a_of_type_Aoiw;
  private aolc jdField_a_of_type_Aolc;
  
  public aofj(View paramView, aoiw paramaoiw)
  {
    super(paramView);
    this.jdField_a_of_type_Aoiw = paramaoiw;
  }
  
  private void a(Context paramContext, aofi paramaofi)
  {
    if ((paramaofi == null) || (paramContext == null)) {
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
            str = paramaofi.d;
            i = paramaofi.jdField_a_of_type_Int;
            if (QLog.isColorLevel()) {
              QLog.d("FeedBannerViewHolder", 2, "parse banner jumpUrl " + str + ", type =" + i);
            }
            if (i != 0) {
              break;
            }
          } while (this.jdField_a_of_type_Aoiw == null);
          this.jdField_a_of_type_Aoiw.d();
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
      paramaofi = new Intent(paramContext, QQBrowserActivity.class);
      paramaofi.putExtra("url", str);
      paramContext.startActivity(paramaofi);
      return;
    } while (!QLog.isColorLevel());
    QLog.e("FeedBannerViewHolder", 2, "jumpUrl is not support ");
  }
  
  private void a(View paramView, aofi paramaofi, int paramInt1, int paramInt2)
  {
    int i = bbkx.a(5.0F);
    ((RoundCorneredRelativeLayout)paramView).setRadius(i, i, i, i);
    Object localObject2 = (ImageView)paramView.findViewById(2131367679);
    TextView localTextView1 = (TextView)paramView.findViewById(2131377350);
    TextView localTextView2 = (TextView)paramView.findViewById(2131376619);
    if (!TextUtils.isEmpty(paramaofi.jdField_a_of_type_JavaLangString)) {
      localTextView1.setText(paramaofi.jdField_a_of_type_JavaLangString);
    }
    if (!TextUtils.isEmpty(paramaofi.jdField_b_of_type_JavaLangString)) {
      localTextView2.setText(paramaofi.jdField_b_of_type_JavaLangString);
    }
    Object localObject1 = (FeedBannerItemGradientLinearLayout)paramView.findViewById(2131367133);
    if (paramInt2 == 1)
    {
      i = 24;
      ((FeedBannerItemGradientLinearLayout)localObject1).a(bbkx.a(i), paramaofi.jdField_b_of_type_Int, paramaofi.jdField_c_of_type_Int);
      localObject1 = (FrameLayout)paramView.findViewById(2131367681);
      if (paramaofi.jdField_a_of_type_Int != 0) {
        break label338;
      }
      ((ImageView)localObject2).setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView = localTextView2;
      localObject2 = paramView.getContext().getResources().getDrawable(2130844288);
      ((Drawable)localObject2).setBounds(bbkx.a(1.0F), 0, bbkx.a(7.0F), bbkx.a(6.0F));
      localTextView2.setCompoundDrawablePadding(bbkx.a(3.0F));
      localTextView2.setCompoundDrawables((Drawable)localObject2, null, null, null);
      if (paramInt2 == 2) {
        ((ViewGroup.MarginLayoutParams)localTextView2.getLayoutParams()).rightMargin = (-bbkx.a(20.0F));
      }
      a((FrameLayout)localObject1, paramInt2);
      a(paramaofi);
    }
    for (;;)
    {
      localObject2 = (ImageView)paramView.findViewById(2131364801);
      Object localObject3 = Drawable.createFromPath(aojh.a(paramInt2));
      if (localObject3 != null) {
        ((ImageView)localObject2).setImageDrawable((Drawable)localObject3);
      }
      paramView.setOnTouchListener(new aofl(this, paramView.findViewById(2131371896), (FrameLayout)localObject1, localTextView1, localTextView2, paramaofi, paramInt1));
      return;
      if (paramInt2 == 2)
      {
        i = 22;
        break;
      }
      i = 40;
      break;
      label338:
      if (paramaofi.jdField_c_of_type_JavaLangString != null)
      {
        try
        {
          localObject3 = new URL(paramaofi.jdField_c_of_type_JavaLangString);
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
    if (this.jdField_a_of_type_Aolc != null) {
      this.jdField_a_of_type_Aolc.d();
    }
    int i;
    FrameLayout.LayoutParams localLayoutParams;
    if (paramInt <= 2)
    {
      i = 2;
      this.jdField_a_of_type_Aolc = new aolc(i);
      if (this.jdField_a_of_type_Aolc.a() != null)
      {
        localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
        if (paramInt > 2) {
          break label99;
        }
      }
    }
    label99:
    for (paramInt = bbkx.a(16.0F);; paramInt = bbkx.a(22.0F))
    {
      localLayoutParams.bottomMargin = paramInt;
      localLayoutParams.topMargin = paramInt;
      paramFrameLayout.addView(this.jdField_a_of_type_Aolc.a(), localLayoutParams);
      return;
      i = 3;
      break;
    }
  }
  
  private void a(aofi paramaofi, int paramInt)
  {
    a(paramaofi, paramInt, "0X800A9B1");
    a(this.itemView.getContext(), paramaofi);
  }
  
  private void a(aofi paramaofi, int paramInt, String paramString)
  {
    if ((paramaofi != null) && (paramaofi.jdField_a_of_type_Int != 0))
    {
      String str1 = paramaofi.jdField_a_of_type_JavaLangString;
      String str2 = paramaofi.jdField_b_of_type_JavaLangString;
      long l = paramaofi.jdField_a_of_type_Long;
      axqw.b(null, "dc00898", "", "", "qq_kuolie", paramString, 0, 0, paramInt + "", "", l + ";" + str1, str2);
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Aolc != null) {
      this.jdField_a_of_type_Aolc.d();
    }
  }
  
  public void a(aofi paramaofi)
  {
    if ((this.jdField_a_of_type_AndroidWidgetTextView != null) && (paramaofi.jdField_b_of_type_JavaLangString != null)) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramaofi.jdField_b_of_type_JavaLangString);
    }
    if ((this.jdField_a_of_type_Aolc != null) && (paramaofi.jdField_a_of_type_JavaUtilArrayList != null)) {
      this.jdField_a_of_type_Aolc.a(paramaofi.jdField_a_of_type_JavaUtilArrayList);
    }
  }
  
  public void a(aogh paramaogh, int paramInt)
  {
    Object localObject;
    ViewGroup.LayoutParams localLayoutParams;
    int i;
    if (((paramaogh instanceof aofh)) && ((this.itemView instanceof TabLayout)))
    {
      localObject = (aofh)paramaogh;
      paramaogh = (TabLayout)this.itemView;
      paramaogh.setPadding(paramaogh.getPaddingLeft(), paramInt, paramaogh.getPaddingRight(), paramaogh.getPaddingBottom());
      localObject = ((aofh)localObject).jdField_a_of_type_JavaUtilArrayList;
      localLayoutParams = paramaogh.getLayoutParams();
      i = ((ArrayList)localObject).size();
      if (i != 1) {
        break label129;
      }
      i = 122;
    }
    for (;;)
    {
      i = bbkx.a(i);
      if (localLayoutParams != null) {
        localLayoutParams.height = (i + paramInt);
      }
      paramaogh.a().setMinimumHeight(i);
      paramaogh.a(new aofk(this, (ArrayList)localObject, bbkx.a(120.0F), bbkx.a(4.0F)));
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
 * Qualified Name:     aofj
 * JD-Core Version:    0.7.0.1
 */