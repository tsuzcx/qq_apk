import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.nearby.now.SmallVideoFragment;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class avlt
  implements View.OnClickListener, avmf
{
  protected Context a;
  protected QQAppInterface a;
  protected NearbyPeopleCard a;
  protected Map<String, avnx> a;
  protected boolean a;
  protected Map<String, avnx> b = new HashMap();
  protected Map<String, avnx> c = new HashMap();
  
  public avlt(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private void g(avma paramavma)
  {
    avnx localavnx = paramavma.jdField_a_of_type_Avnx;
    bdcd.a(this.jdField_a_of_type_AndroidContentContext, 230).setTitle(alpo.a(2131701402)).setNegativeButton(2131690648, new avlz(this)).setPositiveButton(2131691561, new avlx(this, localavnx, paramavma)).show();
  }
  
  private void h(avma paramavma)
  {
    if (!bdee.g(this.jdField_a_of_type_AndroidContentContext))
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, alpo.a(2131701399), 0).a();
      return;
    }
    boolean bool = paramavma.jdField_a_of_type_Avnx.jdField_a_of_type_Boolean;
    String str = b(paramavma);
    Object localObject = (avms)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(263);
    if (!bool)
    {
      ((avms)localObject).a(str);
      auzx localauzx = new auzx().h("data_card");
      if (!bool) {
        break label157;
      }
      localObject = "feed_unlike";
      label89:
      localObject = localauzx.i((String)localObject).d("2").a(a(paramavma)).b(str).c(String.valueOf(a(paramavma)));
      if (!this.jdField_a_of_type_Boolean) {
        break label163;
      }
    }
    label157:
    label163:
    for (paramavma = "1";; paramavma = "2")
    {
      ((auzx)localObject).e(paramavma).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      return;
      ((avms)localObject).b(str);
      break;
      localObject = "feed_like";
      break label89;
    }
  }
  
  public abstract int a(avma paramavma);
  
  public abstract View a(ViewGroup paramViewGroup, avma paramavma);
  
  public View a(avnx paramavnx, Context paramContext, View paramView)
  {
    Object localObject = (LinearLayout)paramView;
    paramView = (View)localObject;
    avma localavma;
    if (localObject == null)
    {
      localObject = new LinearLayout(paramContext);
      ((LinearLayout)localObject).setLayoutParams(new AbsListView.LayoutParams(-1, -1));
      ((LinearLayout)localObject).setBackgroundColor(-1);
      ((LinearLayout)localObject).setOrientation(1);
      localavma = a();
      if (localavma == null) {
        paramavnx = null;
      }
    }
    do
    {
      return paramavnx;
      localavma.jdField_a_of_type_AndroidAppActivity = ((Activity)paramContext);
      localavma.jdField_a_of_type_AndroidViewView = ((View)localObject);
      paramView = LayoutInflater.from(paramContext).inflate(2131561079, (ViewGroup)localObject, false);
      LinearLayout.LayoutParams localLayoutParams1 = new LinearLayout.LayoutParams(-1, -2);
      localLayoutParams1.topMargin = xod.a(paramContext, 20.0F);
      localLayoutParams1.leftMargin = xod.a(paramContext, 16.0F);
      localLayoutParams1.bottomMargin = xod.a(paramContext, 0.0F);
      localLayoutParams1.rightMargin = xod.a(paramContext, 6.0F);
      localavma.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368781));
      localavma.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378839));
      localavma.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368823));
      View localView1 = LayoutInflater.from(paramContext).inflate(2131561075, (ViewGroup)localObject, false);
      LinearLayout.LayoutParams localLayoutParams2 = new LinearLayout.LayoutParams(-1, -2);
      localLayoutParams2.leftMargin = xod.a(paramContext, 66.0F);
      localLayoutParams2.rightMargin = xod.a(paramContext, 6.0F);
      localavma.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView1.findViewById(2131378820));
      localavma.jdField_c_of_type_AndroidWidgetTextView = ((TextView)localView1.findViewById(2131378731));
      localavma.jdField_c_of_type_AndroidViewView = localView1.findViewById(2131372202);
      localavma.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)localView1.findViewById(2131368847));
      localavma.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
      localavma.jdField_d_of_type_AndroidWidgetTextView = ((TextView)localView1.findViewById(2131378870));
      localavma.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)localView1.findViewById(2131368733));
      localavma.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(this);
      localavma.e = ((TextView)localView1.findViewById(2131378654));
      localavma.jdField_a_of_type_AndroidWidgetListView = ((ListView)localView1.findViewById(2131364598));
      localavma.jdField_a_of_type_Avmd = new avmd();
      localavma.jdField_a_of_type_Avmd.a(this);
      localavma.jdField_a_of_type_AndroidWidgetListView.setAdapter(localavma.jdField_a_of_type_Avmd);
      localavma.f = ((TextView)localView1.findViewById(2131380072));
      localavma.jdField_d_of_type_AndroidViewView = localView1.findViewById(2131364596);
      localavma.f.setOnClickListener(this);
      ((LinearLayout)localObject).addView(paramView, localLayoutParams1);
      View localView2 = a((ViewGroup)localObject, localavma);
      if (localView2 != null)
      {
        localLayoutParams1 = (LinearLayout.LayoutParams)localView2.getLayoutParams();
        paramView = localLayoutParams1;
        if (localLayoutParams1 == null) {
          paramView = new LinearLayout.LayoutParams(-1, -2);
        }
        paramView.leftMargin = xod.a(paramContext, 66.0F);
        paramView.rightMargin = xod.a(paramContext, 6.0F);
        paramView.topMargin = xod.a(paramContext, -14.0F);
        ((LinearLayout)localObject).addView(localView2);
        localView2.setId(2131373508);
        localavma.jdField_b_of_type_AndroidViewView = localView2;
        localView2.setOnClickListener(this);
      }
      ((LinearLayout)localObject).addView(localView1, localLayoutParams2);
      ((LinearLayout)localObject).setTag(localavma);
      localavma.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
      paramView = new View(this.jdField_a_of_type_AndroidContentContext);
      paramView.setLayoutParams(new LinearLayout.LayoutParams(-1, xod.a(this.jdField_a_of_type_AndroidContentContext, 10.0F)));
      paramView.setBackgroundColor(-460807);
      ((LinearLayout)localObject).addView(paramView);
      paramView = (View)localObject;
      localObject = (avma)paramView.getTag();
      ((avma)localObject).jdField_a_of_type_Avnx = paramavnx;
      a((avma)localObject);
      if ((!TextUtils.isEmpty(paramavnx.k)) && (!paramavnx.k.endsWith(alpo.a(2131701403)))) {
        break;
      }
      ((avma)localObject).jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(2130845055, 0, 0, 0);
      ((avma)localObject).jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(null);
      ((avma)localObject).jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#777777"));
      paramavnx = paramView;
    } while (this.jdField_a_of_type_JavaUtilMap.get(((avma)localObject).jdField_a_of_type_Avnx.c) != null);
    paramContext = new auzx().h("data_card").i("feed_exp").a(a((avma)localObject)).d("2").b(((avma)localObject).jdField_a_of_type_Avnx.c).c(String.valueOf(a((avma)localObject)));
    if (this.jdField_a_of_type_Boolean) {}
    for (paramavnx = "1";; paramavnx = "2")
    {
      paramContext.e(paramavnx).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_a_of_type_JavaUtilMap.put(((avma)localObject).jdField_a_of_type_Avnx.c, ((avma)localObject).jdField_a_of_type_Avnx);
      return paramView;
      ((avma)localObject).jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(2130845057, 0, 0, 0);
      ((avma)localObject).jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#576B95"));
      ((avma)localObject).jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(new avlu(this, paramContext, paramavnx, (avma)localObject));
      break;
    }
  }
  
  public abstract avma a();
  
  public String a(avma paramavma)
  {
    return "";
  }
  
  public void a(View paramView)
  {
    paramView = (avma)avnl.a(paramView, avma.class);
    if (paramView == null) {
      return;
    }
    c(paramView);
  }
  
  public void a(avma paramavma)
  {
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = xod.a(this.jdField_a_of_type_AndroidContentContext, 40.0F);
    ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = xod.a(this.jdField_a_of_type_AndroidContentContext, 40.0F);
    ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130840086);
    try
    {
      localObject = URLDrawable.getDrawable(paramavma.jdField_a_of_type_Avnx.d, (URLDrawable.URLDrawableOptions)localObject);
      ((URLDrawable)localObject).setTag(bcuq.a(xod.a(this.jdField_a_of_type_AndroidContentContext, 40.0F), xod.a(this.jdField_a_of_type_AndroidContentContext, 40.0F)));
      ((URLDrawable)localObject).setDecodeHandler(bcuq.a);
      paramavma.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null) {
        paramavma.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nickname);
      }
      paramavma.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
      f(paramavma);
      if (!TextUtils.isEmpty(paramavma.jdField_a_of_type_Avnx.jdField_g_of_type_JavaLangString))
      {
        paramavma.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        paramavma.jdField_b_of_type_AndroidWidgetTextView.setText(paramavma.jdField_a_of_type_Avnx.jdField_g_of_type_JavaLangString);
        localObject = new StringBuilder();
        if (!TextUtils.isEmpty(paramavma.jdField_a_of_type_Avnx.jdField_f_of_type_JavaLangString))
        {
          if (((StringBuilder)localObject).length() > 0) {
            ((StringBuilder)localObject).append(" · ");
          }
          ((StringBuilder)localObject).append(paramavma.jdField_a_of_type_Avnx.jdField_f_of_type_JavaLangString);
        }
        if (((StringBuilder)localObject).length() <= 0) {
          break label695;
        }
        paramavma.jdField_c_of_type_AndroidWidgetTextView.setText(((StringBuilder)localObject).toString());
        paramavma.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        if (!a(paramavma)) {
          break label730;
        }
        paramavma.jdField_c_of_type_AndroidViewView.setVisibility(0);
        if (!paramavma.jdField_a_of_type_Avnx.jdField_a_of_type_Boolean) {
          break label707;
        }
        paramavma.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130844998);
        paramavma.jdField_d_of_type_AndroidWidgetTextView.setTextColor(-52924);
        paramavma.jdField_d_of_type_AndroidWidgetTextView.setText(String.valueOf(paramavma.jdField_a_of_type_Avnx.jdField_f_of_type_Int));
        paramavma.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
        paramavma.e.setText(String.valueOf(paramavma.jdField_a_of_type_Avnx.jdField_g_of_type_Int));
        List localList = paramavma.jdField_a_of_type_Avnx.jdField_a_of_type_JavaUtilList;
        if ((localList == null) || (localList.size() <= 0)) {
          break label748;
        }
        paramavma.jdField_a_of_type_AndroidWidgetListView.setVisibility(0);
        paramavma.jdField_a_of_type_Avmd.a(localList);
        paramavma.jdField_a_of_type_Avmd.notifyDataSetChanged();
        if (this.b.get(paramavma.jdField_a_of_type_Avnx.c) == null)
        {
          auzx localauzx = new auzx().h("data_card").i("feed_com_exp").d("2").a(a(paramavma)).b(paramavma.jdField_a_of_type_Avnx.c).c(String.valueOf(a(paramavma)));
          if (!this.jdField_a_of_type_Boolean) {
            break label742;
          }
          localObject = "1";
          localauzx.e((String)localObject).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          this.b.put(paramavma.jdField_a_of_type_Avnx.c, paramavma.jdField_a_of_type_Avnx);
        }
        if ((localList == null) || (localList.size() <= 0) || (paramavma.jdField_a_of_type_Avnx.jdField_g_of_type_Int <= localList.size())) {
          break label760;
        }
        paramavma.f.setVisibility(0);
        if ((paramavma.jdField_a_of_type_AndroidWidgetListView.getVisibility() == 0) || (paramavma.f.getVisibility() == 0)) {
          break label772;
        }
        paramavma.jdField_d_of_type_AndroidViewView.setVisibility(8);
        paramavma.jdField_b_of_type_AndroidWidgetImageView.setClickable(true);
        paramavma.jdField_b_of_type_AndroidWidgetImageView.setAlpha(1.0F);
        paramavma.jdField_c_of_type_AndroidWidgetImageView.setClickable(true);
        paramavma.jdField_d_of_type_AndroidWidgetImageView.setClickable(true);
        paramavma.jdField_c_of_type_AndroidWidgetImageView.setAlpha(1.0F);
        paramavma.jdField_d_of_type_AndroidWidgetTextView.setAlpha(1.0F);
        paramavma.jdField_d_of_type_AndroidWidgetImageView.setAlpha(1.0F);
        paramavma.e.setAlpha(1.0F);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        paramavma.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130840086));
        QLog.i("BaseMomentItemBuilder", 1, "updateUI, holder.momentFeedInfo.headUrl=" + paramavma.jdField_a_of_type_Avnx.d);
        continue;
        paramavma.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        continue;
        label695:
        paramavma.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
        continue;
        label707:
        paramavma.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130845016);
        paramavma.jdField_d_of_type_AndroidWidgetTextView.setTextColor(-4473925);
        continue;
        label730:
        paramavma.jdField_c_of_type_AndroidViewView.setVisibility(8);
        continue;
        label742:
        String str = "2";
        continue;
        label748:
        paramavma.jdField_a_of_type_AndroidWidgetListView.setVisibility(8);
        continue;
        label760:
        paramavma.f.setVisibility(8);
        continue;
        label772:
        paramavma.jdField_d_of_type_AndroidViewView.setVisibility(0);
      }
    }
  }
  
  public void a(NearbyPeopleCard paramNearbyPeopleCard)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard = paramNearbyPeopleCard;
    if (TextUtils.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramNearbyPeopleCard.uin)) {
      this.jdField_a_of_type_Boolean = true;
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    try
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("raw_url", paramString);
      localIntent.putExtra("scroll_to_comment", paramBoolean);
      localIntent.putExtra("play_mode", "2");
      localIntent.putExtra("is_multi_progress_bar", true);
      localIntent.putExtra("_from", "3");
      localIntent.addFlags(268435456);
      localIntent.putExtra("public_fragment_window_feature", 1);
      PublicTransFragmentActivity.b(this.jdField_a_of_type_AndroidContentContext, localIntent, SmallVideoFragment.class);
      return;
    }
    catch (Exception paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.w("BaseMomentItemBuilder", 2, "onItemClick exp:" + paramString.toString());
    }
  }
  
  public boolean a(avma paramavma)
  {
    return true;
  }
  
  public String b(avma paramavma)
  {
    return paramavma.jdField_a_of_type_Avnx.c;
  }
  
  public void b(avma paramavma)
  {
    avnx localavnx = paramavma.jdField_a_of_type_Avnx;
    auzx localauzx = new auzx().h("data_card").i("feed_more_clk").d("2").a(a(paramavma)).b(localavnx.c).c(String.valueOf(a(paramavma)));
    if (this.jdField_a_of_type_Boolean) {}
    for (Object localObject = "1";; localObject = "2")
    {
      localauzx.e((String)localObject).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (!TextUtils.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), localavnx.e)) {
        break;
      }
      localObject = bhpy.a(this.jdField_a_of_type_AndroidContentContext);
      ((bhpy)localObject).a(2131691561, 1);
      ((bhpy)localObject).c(2131690648);
      ((bhpy)localObject).a(new avlv(this, paramavma, localavnx, (bhpy)localObject));
      ((bhpy)localObject).show();
      return;
    }
    localObject = bhpy.a(this.jdField_a_of_type_AndroidContentContext);
    ((bhpy)localObject).a(2131718435, 1);
    ((bhpy)localObject).c(2131690648);
    ((bhpy)localObject).a(new avlw(this, paramavma, localavnx, (bhpy)localObject));
    ((bhpy)localObject).show();
  }
  
  public void c(avma paramavma)
  {
    if (!bdee.g(this.jdField_a_of_type_AndroidContentContext))
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, alpo.a(2131701397), 0).a();
      return;
    }
    a(paramavma.jdField_a_of_type_Avnx.m, true);
  }
  
  public void d(avma paramavma)
  {
    String str = paramavma.jdField_a_of_type_Avnx.c;
    auzx localauzx = new auzx().h("data_card").i("feed_clk").d("2").a(a(paramavma)).b(str).c(String.valueOf(a(paramavma)));
    if (this.jdField_a_of_type_Boolean) {}
    for (str = "1";; str = "2")
    {
      localauzx.e(str).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (bdee.g(this.jdField_a_of_type_AndroidContentContext)) {
        break;
      }
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, alpo.a(2131701400), 0).a();
      return;
    }
    a(paramavma.jdField_a_of_type_Avnx.m, false);
  }
  
  public void e(avma paramavma)
  {
    avny localavny = (avny)paramavma.jdField_a_of_type_Avnx;
    Object localObject = localavny.a;
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localObject);
    localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("feedId", localavny.c);
      ((JSONObject)localObject).put("tinyId", "");
      ((JSONObject)localObject).put("uin", localavny.e);
      ((JSONObject)localObject).put("reason", alpo.a(2131701401));
      bcch.a(paramavma.jdField_a_of_type_AndroidAppActivity, 0, localArrayList, null, null, false, false, "5", 100, null, null, ((JSONObject)localObject).toString());
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  public abstract void f(avma paramavma);
  
  public void onClick(View paramView)
  {
    avma localavma = (avma)avnl.a(paramView, avma.class);
    if (localavma == null) {
      return;
    }
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131368733: 
      c(localavma);
      return;
    case 2131368823: 
      b(localavma);
      return;
    case 2131368847: 
      h(localavma);
      return;
    case 2131380072: 
      auzx localauzx = new auzx().h("data_card").i("feed_com_clk").d("2").a(a(localavma)).b(localavma.jdField_a_of_type_Avnx.c).c(String.valueOf(a(localavma)));
      if (this.jdField_a_of_type_Boolean) {}
      for (paramView = "1";; paramView = "2")
      {
        localauzx.e(paramView).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        break;
      }
    case 2131373508: 
      d(localavma);
      return;
    }
    e(localavma);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avlt
 * JD-Core Version:    0.7.0.1
 */