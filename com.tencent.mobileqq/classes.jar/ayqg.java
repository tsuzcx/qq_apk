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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView.LayoutParams;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class ayqg
  implements View.OnClickListener, ayqs
{
  protected Context a;
  protected QQAppInterface a;
  protected NearbyPeopleCard a;
  protected Map<String, aysk> a;
  protected boolean a;
  protected Map<String, aysk> b = new HashMap();
  protected Map<String, aysk> c = new HashMap();
  
  public ayqg(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private void g(ayqn paramayqn)
  {
    aysk localaysk = paramayqn.jdField_a_of_type_Aysk;
    bhlq.a(this.jdField_a_of_type_AndroidContentContext, 230).setTitle(anzj.a(2131699945)).setNegativeButton(2131690580, new ayqm(this)).setPositiveButton(2131691323, new ayqk(this, localaysk, paramayqn)).show();
  }
  
  private void h(ayqn paramayqn)
  {
    if (!bhnv.g(this.jdField_a_of_type_AndroidContentContext))
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, anzj.a(2131699942), 0).a();
      return;
    }
    boolean bool = paramayqn.jdField_a_of_type_Aysk.jdField_a_of_type_Boolean;
    String str = b(paramayqn);
    Object localObject = (ayrf)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(263);
    if (!bool)
    {
      ((ayrf)localObject).a(str);
      ayek localayek = new ayek().h("data_card");
      if (!bool) {
        break label157;
      }
      localObject = "feed_unlike";
      label89:
      localObject = localayek.i((String)localObject).d("2").a(a(paramayqn)).b(str).c(String.valueOf(a(paramayqn)));
      if (!this.jdField_a_of_type_Boolean) {
        break label163;
      }
    }
    label157:
    label163:
    for (paramayqn = "1";; paramayqn = "2")
    {
      ((ayek)localObject).e(paramayqn).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      return;
      ((ayrf)localObject).b(str);
      break;
      localObject = "feed_like";
      break label89;
    }
  }
  
  public abstract int a(ayqn paramayqn);
  
  public abstract View a(ViewGroup paramViewGroup, ayqn paramayqn);
  
  public View a(aysk paramaysk, Context paramContext, View paramView)
  {
    Object localObject = (LinearLayout)paramView;
    paramView = (View)localObject;
    ayqn localayqn;
    if (localObject == null)
    {
      localObject = new LinearLayout(paramContext);
      ((LinearLayout)localObject).setLayoutParams(new AbsListView.LayoutParams(-1, -1));
      ((LinearLayout)localObject).setBackgroundColor(-1);
      ((LinearLayout)localObject).setOrientation(1);
      localayqn = a();
      if (localayqn == null) {
        paramaysk = null;
      }
    }
    do
    {
      return paramaysk;
      localayqn.jdField_a_of_type_AndroidAppActivity = ((Activity)paramContext);
      localayqn.jdField_a_of_type_AndroidViewView = ((View)localObject);
      paramView = LayoutInflater.from(paramContext).inflate(2131561346, (ViewGroup)localObject, false);
      LinearLayout.LayoutParams localLayoutParams1 = new LinearLayout.LayoutParams(-1, -2);
      localLayoutParams1.topMargin = zps.a(paramContext, 20.0F);
      localLayoutParams1.leftMargin = zps.a(paramContext, 16.0F);
      localLayoutParams1.bottomMargin = zps.a(paramContext, 0.0F);
      localLayoutParams1.rightMargin = zps.a(paramContext, 6.0F);
      localayqn.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369233));
      localayqn.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379958));
      localayqn.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369280));
      View localView1 = LayoutInflater.from(paramContext).inflate(2131561342, (ViewGroup)localObject, false);
      LinearLayout.LayoutParams localLayoutParams2 = new LinearLayout.LayoutParams(-1, -2);
      localLayoutParams2.leftMargin = zps.a(paramContext, 66.0F);
      localLayoutParams2.rightMargin = zps.a(paramContext, 6.0F);
      localayqn.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView1.findViewById(2131379935));
      localayqn.jdField_c_of_type_AndroidWidgetTextView = ((TextView)localView1.findViewById(2131379829));
      localayqn.jdField_c_of_type_AndroidViewView = localView1.findViewById(2131372925);
      localayqn.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)localView1.findViewById(2131369318));
      localayqn.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
      localayqn.jdField_d_of_type_AndroidWidgetTextView = ((TextView)localView1.findViewById(2131379999));
      localayqn.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)localView1.findViewById(2131369177));
      localayqn.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(this);
      localayqn.e = ((TextView)localView1.findViewById(2131379744));
      localayqn.jdField_a_of_type_AndroidWidgetListView = ((ListView)localView1.findViewById(2131364865));
      localayqn.jdField_a_of_type_Ayqq = new ayqq();
      localayqn.jdField_a_of_type_Ayqq.a(this);
      localayqn.jdField_a_of_type_AndroidWidgetListView.setAdapter(localayqn.jdField_a_of_type_Ayqq);
      localayqn.f = ((TextView)localView1.findViewById(2131381266));
      localayqn.jdField_d_of_type_AndroidViewView = localView1.findViewById(2131364863);
      localayqn.f.setOnClickListener(this);
      ((LinearLayout)localObject).addView(paramView, localLayoutParams1);
      View localView2 = a((ViewGroup)localObject, localayqn);
      if (localView2 != null)
      {
        localLayoutParams1 = (LinearLayout.LayoutParams)localView2.getLayoutParams();
        paramView = localLayoutParams1;
        if (localLayoutParams1 == null) {
          paramView = new LinearLayout.LayoutParams(-1, -2);
        }
        paramView.leftMargin = zps.a(paramContext, 66.0F);
        paramView.rightMargin = zps.a(paramContext, 6.0F);
        paramView.topMargin = zps.a(paramContext, -14.0F);
        ((LinearLayout)localObject).addView(localView2);
        localView2.setId(2131374403);
        localayqn.jdField_b_of_type_AndroidViewView = localView2;
        localView2.setOnClickListener(this);
      }
      ((LinearLayout)localObject).addView(localView1, localLayoutParams2);
      ((LinearLayout)localObject).setTag(localayqn);
      localayqn.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
      paramView = new View(this.jdField_a_of_type_AndroidContentContext);
      paramView.setLayoutParams(new LinearLayout.LayoutParams(-1, zps.a(this.jdField_a_of_type_AndroidContentContext, 10.0F)));
      paramView.setBackgroundColor(-460807);
      ((LinearLayout)localObject).addView(paramView);
      paramView = (View)localObject;
      localObject = (ayqn)paramView.getTag();
      ((ayqn)localObject).jdField_a_of_type_Aysk = paramaysk;
      a((ayqn)localObject);
      if ((!TextUtils.isEmpty(paramaysk.k)) && (!paramaysk.k.endsWith(anzj.a(2131699946)))) {
        break;
      }
      ((ayqn)localObject).jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(2130845538, 0, 0, 0);
      ((ayqn)localObject).jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(null);
      ((ayqn)localObject).jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#777777"));
      paramaysk = paramView;
    } while (this.jdField_a_of_type_JavaUtilMap.get(((ayqn)localObject).jdField_a_of_type_Aysk.c) != null);
    paramContext = new ayek().h("data_card").i("feed_exp").a(a((ayqn)localObject)).d("2").b(((ayqn)localObject).jdField_a_of_type_Aysk.c).c(String.valueOf(a((ayqn)localObject)));
    if (this.jdField_a_of_type_Boolean) {}
    for (paramaysk = "1";; paramaysk = "2")
    {
      paramContext.e(paramaysk).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_a_of_type_JavaUtilMap.put(((ayqn)localObject).jdField_a_of_type_Aysk.c, ((ayqn)localObject).jdField_a_of_type_Aysk);
      return paramView;
      ((ayqn)localObject).jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(2130845540, 0, 0, 0);
      ((ayqn)localObject).jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#576B95"));
      ((ayqn)localObject).jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(new ayqh(this, paramContext, paramaysk, (ayqn)localObject));
      break;
    }
  }
  
  public abstract ayqn a();
  
  public String a(ayqn paramayqn)
  {
    return "";
  }
  
  public void a(View paramView)
  {
    paramView = (ayqn)ayry.a(paramView, ayqn.class);
    if (paramView == null) {
      return;
    }
    c(paramView);
  }
  
  public void a(ayqn paramayqn)
  {
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = zps.a(this.jdField_a_of_type_AndroidContentContext, 40.0F);
    ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = zps.a(this.jdField_a_of_type_AndroidContentContext, 40.0F);
    ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130840276);
    try
    {
      localObject = URLDrawable.getDrawable(paramayqn.jdField_a_of_type_Aysk.d, (URLDrawable.URLDrawableOptions)localObject);
      ((URLDrawable)localObject).setTag(bhez.a(zps.a(this.jdField_a_of_type_AndroidContentContext, 40.0F), zps.a(this.jdField_a_of_type_AndroidContentContext, 40.0F)));
      ((URLDrawable)localObject).setDecodeHandler(bhez.a);
      paramayqn.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null) {
        paramayqn.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nickname);
      }
      paramayqn.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
      f(paramayqn);
      if (!TextUtils.isEmpty(paramayqn.jdField_a_of_type_Aysk.jdField_g_of_type_JavaLangString))
      {
        paramayqn.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        paramayqn.jdField_b_of_type_AndroidWidgetTextView.setText(paramayqn.jdField_a_of_type_Aysk.jdField_g_of_type_JavaLangString);
        localObject = new StringBuilder();
        if (!TextUtils.isEmpty(paramayqn.jdField_a_of_type_Aysk.jdField_f_of_type_JavaLangString))
        {
          if (((StringBuilder)localObject).length() > 0) {
            ((StringBuilder)localObject).append(" · ");
          }
          ((StringBuilder)localObject).append(paramayqn.jdField_a_of_type_Aysk.jdField_f_of_type_JavaLangString);
        }
        if (((StringBuilder)localObject).length() <= 0) {
          break label695;
        }
        paramayqn.jdField_c_of_type_AndroidWidgetTextView.setText(((StringBuilder)localObject).toString());
        paramayqn.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        if (!a(paramayqn)) {
          break label730;
        }
        paramayqn.jdField_c_of_type_AndroidViewView.setVisibility(0);
        if (!paramayqn.jdField_a_of_type_Aysk.jdField_a_of_type_Boolean) {
          break label707;
        }
        paramayqn.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130845481);
        paramayqn.jdField_d_of_type_AndroidWidgetTextView.setTextColor(-52924);
        paramayqn.jdField_d_of_type_AndroidWidgetTextView.setText(String.valueOf(paramayqn.jdField_a_of_type_Aysk.jdField_f_of_type_Int));
        paramayqn.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
        paramayqn.e.setText(String.valueOf(paramayqn.jdField_a_of_type_Aysk.jdField_g_of_type_Int));
        List localList = paramayqn.jdField_a_of_type_Aysk.jdField_a_of_type_JavaUtilList;
        if ((localList == null) || (localList.size() <= 0)) {
          break label748;
        }
        paramayqn.jdField_a_of_type_AndroidWidgetListView.setVisibility(0);
        paramayqn.jdField_a_of_type_Ayqq.a(localList);
        paramayqn.jdField_a_of_type_Ayqq.notifyDataSetChanged();
        if (this.b.get(paramayqn.jdField_a_of_type_Aysk.c) == null)
        {
          ayek localayek = new ayek().h("data_card").i("feed_com_exp").d("2").a(a(paramayqn)).b(paramayqn.jdField_a_of_type_Aysk.c).c(String.valueOf(a(paramayqn)));
          if (!this.jdField_a_of_type_Boolean) {
            break label742;
          }
          localObject = "1";
          localayek.e((String)localObject).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          this.b.put(paramayqn.jdField_a_of_type_Aysk.c, paramayqn.jdField_a_of_type_Aysk);
        }
        if ((localList == null) || (localList.size() <= 0) || (paramayqn.jdField_a_of_type_Aysk.jdField_g_of_type_Int <= localList.size())) {
          break label760;
        }
        paramayqn.f.setVisibility(0);
        if ((paramayqn.jdField_a_of_type_AndroidWidgetListView.getVisibility() == 0) || (paramayqn.f.getVisibility() == 0)) {
          break label772;
        }
        paramayqn.jdField_d_of_type_AndroidViewView.setVisibility(8);
        paramayqn.jdField_b_of_type_AndroidWidgetImageView.setClickable(true);
        paramayqn.jdField_b_of_type_AndroidWidgetImageView.setAlpha(1.0F);
        paramayqn.jdField_c_of_type_AndroidWidgetImageView.setClickable(true);
        paramayqn.jdField_d_of_type_AndroidWidgetImageView.setClickable(true);
        paramayqn.jdField_c_of_type_AndroidWidgetImageView.setAlpha(1.0F);
        paramayqn.jdField_d_of_type_AndroidWidgetTextView.setAlpha(1.0F);
        paramayqn.jdField_d_of_type_AndroidWidgetImageView.setAlpha(1.0F);
        paramayqn.e.setAlpha(1.0F);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        paramayqn.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130840276));
        QLog.i("BaseMomentItemBuilder", 1, "updateUI, holder.momentFeedInfo.headUrl=" + paramayqn.jdField_a_of_type_Aysk.d);
        continue;
        paramayqn.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        continue;
        label695:
        paramayqn.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
        continue;
        label707:
        paramayqn.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130845499);
        paramayqn.jdField_d_of_type_AndroidWidgetTextView.setTextColor(-4473925);
        continue;
        label730:
        paramayqn.jdField_c_of_type_AndroidViewView.setVisibility(8);
        continue;
        label742:
        String str = "2";
        continue;
        label748:
        paramayqn.jdField_a_of_type_AndroidWidgetListView.setVisibility(8);
        continue;
        label760:
        paramayqn.f.setVisibility(8);
        continue;
        label772:
        paramayqn.jdField_d_of_type_AndroidViewView.setVisibility(0);
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
  
  public boolean a(ayqn paramayqn)
  {
    return true;
  }
  
  public String b(ayqn paramayqn)
  {
    return paramayqn.jdField_a_of_type_Aysk.c;
  }
  
  public void b(ayqn paramayqn)
  {
    aysk localaysk = paramayqn.jdField_a_of_type_Aysk;
    ayek localayek = new ayek().h("data_card").i("feed_more_clk").d("2").a(a(paramayqn)).b(localaysk.c).c(String.valueOf(a(paramayqn)));
    if (this.jdField_a_of_type_Boolean) {}
    for (Object localObject = "1";; localObject = "2")
    {
      localayek.e((String)localObject).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (!TextUtils.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), localaysk.e)) {
        break;
      }
      localObject = blir.a(this.jdField_a_of_type_AndroidContentContext);
      ((blir)localObject).a(2131691323, 1);
      ((blir)localObject).c(2131690580);
      ((blir)localObject).a(new ayqi(this, paramayqn, localaysk, (blir)localObject));
      ((blir)localObject).show();
      return;
    }
    localObject = blir.a(this.jdField_a_of_type_AndroidContentContext);
    ((blir)localObject).a(2131716719, 1);
    ((blir)localObject).c(2131690580);
    ((blir)localObject).a(new ayqj(this, paramayqn, localaysk, (blir)localObject));
    ((blir)localObject).show();
  }
  
  public void c(ayqn paramayqn)
  {
    if (!bhnv.g(this.jdField_a_of_type_AndroidContentContext))
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, anzj.a(2131699940), 0).a();
      return;
    }
    a(paramayqn.jdField_a_of_type_Aysk.m, true);
  }
  
  public void d(ayqn paramayqn)
  {
    String str = paramayqn.jdField_a_of_type_Aysk.c;
    ayek localayek = new ayek().h("data_card").i("feed_clk").d("2").a(a(paramayqn)).b(str).c(String.valueOf(a(paramayqn)));
    if (this.jdField_a_of_type_Boolean) {}
    for (str = "1";; str = "2")
    {
      localayek.e(str).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (bhnv.g(this.jdField_a_of_type_AndroidContentContext)) {
        break;
      }
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, anzj.a(2131699943), 0).a();
      return;
    }
    a(paramayqn.jdField_a_of_type_Aysk.m, false);
  }
  
  public void e(ayqn paramayqn)
  {
    aysl localaysl = (aysl)paramayqn.jdField_a_of_type_Aysk;
    Object localObject = localaysl.a;
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localObject);
    localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("feedId", localaysl.c);
      ((JSONObject)localObject).put("tinyId", "");
      ((JSONObject)localObject).put("uin", localaysl.e);
      ((JSONObject)localObject).put("reason", anzj.a(2131699944));
      bghf.a(paramayqn.jdField_a_of_type_AndroidAppActivity, 0, localArrayList, null, null, false, false, "5", 100, null, null, ((JSONObject)localObject).toString());
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
  
  public abstract void f(ayqn paramayqn);
  
  public void onClick(View paramView)
  {
    ayqn localayqn = (ayqn)ayry.a(paramView, ayqn.class);
    if (localayqn == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      switch (paramView.getId())
      {
      default: 
        break;
      case 2131369177: 
        c(localayqn);
        break;
      case 2131369280: 
        b(localayqn);
        break;
      case 2131369318: 
        h(localayqn);
        break;
      case 2131381266: 
        ayek localayek = new ayek().h("data_card").i("feed_com_clk").d("2").a(a(localayqn)).b(localayqn.jdField_a_of_type_Aysk.c).c(String.valueOf(a(localayqn)));
        if (this.jdField_a_of_type_Boolean) {}
        for (String str = "1";; str = "2")
        {
          localayek.e(str).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          break;
        }
      case 2131374403: 
        d(localayqn);
        break;
      case 2131369308: 
        e(localayqn);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayqg
 * JD-Core Version:    0.7.0.1
 */