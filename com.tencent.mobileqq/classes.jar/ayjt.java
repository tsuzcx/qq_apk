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
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.nearby.now.SmallVideoFragment;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
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

public abstract class ayjt
  implements View.OnClickListener, aykf
{
  protected Context a;
  protected QQAppInterface a;
  protected NearbyPeopleCard a;
  protected Map<String, aylx> a;
  protected boolean a;
  protected Map<String, aylx> b = new HashMap();
  protected Map<String, aylx> c = new HashMap();
  
  public ayjt(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private void g(ayka paramayka)
  {
    aylx localaylx = paramayka.jdField_a_of_type_Aylx;
    bhdj.a(this.jdField_a_of_type_AndroidContentContext, 230).setTitle(anvx.a(2131700531)).setNegativeButton(2131690697, new ayjz(this)).setPositiveButton(2131691448, new ayjx(this, localaylx, paramayka)).show();
  }
  
  private void h(ayka paramayka)
  {
    if (!NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_AndroidContentContext))
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, anvx.a(2131700528), 0).a();
      return;
    }
    boolean bool = paramayka.jdField_a_of_type_Aylx.jdField_a_of_type_Boolean;
    String str = b(paramayka);
    Object localObject = (ayks)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.NEARBY_MOMENT_MANAGER);
    if (!bool)
    {
      ((ayks)localObject).a(str);
      axxu localaxxu = new axxu().h("data_card");
      if (!bool) {
        break label157;
      }
      localObject = "feed_unlike";
      label89:
      localObject = localaxxu.i((String)localObject).d("2").a(a(paramayka)).b(str).c(String.valueOf(a(paramayka)));
      if (!this.jdField_a_of_type_Boolean) {
        break label163;
      }
    }
    label157:
    label163:
    for (paramayka = "1";; paramayka = "2")
    {
      ((axxu)localObject).e(paramayka).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      return;
      ((ayks)localObject).b(str);
      break;
      localObject = "feed_like";
      break label89;
    }
  }
  
  public abstract int a(ayka paramayka);
  
  public abstract View a(ViewGroup paramViewGroup, ayka paramayka);
  
  public View a(aylx paramaylx, Context paramContext, View paramView)
  {
    Object localObject = (LinearLayout)paramView;
    paramView = (View)localObject;
    ayka localayka;
    if (localObject == null)
    {
      localObject = new LinearLayout(paramContext);
      ((LinearLayout)localObject).setLayoutParams(new AbsListView.LayoutParams(-1, -1));
      ((LinearLayout)localObject).setBackgroundColor(-1);
      ((LinearLayout)localObject).setOrientation(1);
      localayka = a();
      if (localayka == null) {
        paramaylx = null;
      }
    }
    do
    {
      return paramaylx;
      localayka.jdField_a_of_type_AndroidAppActivity = ((Activity)paramContext);
      localayka.jdField_a_of_type_AndroidViewView = ((View)localObject);
      paramView = LayoutInflater.from(paramContext).inflate(2131561282, (ViewGroup)localObject, false);
      LinearLayout.LayoutParams localLayoutParams1 = new LinearLayout.LayoutParams(-1, -2);
      localLayoutParams1.topMargin = UIUtils.dip2px(paramContext, 20.0F);
      localLayoutParams1.leftMargin = UIUtils.dip2px(paramContext, 16.0F);
      localLayoutParams1.bottomMargin = UIUtils.dip2px(paramContext, 0.0F);
      localLayoutParams1.rightMargin = UIUtils.dip2px(paramContext, 6.0F);
      localayka.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369416));
      localayka.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380038));
      localayka.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369463));
      View localView1 = LayoutInflater.from(paramContext).inflate(2131561278, (ViewGroup)localObject, false);
      LinearLayout.LayoutParams localLayoutParams2 = new LinearLayout.LayoutParams(-1, -2);
      localLayoutParams2.leftMargin = UIUtils.dip2px(paramContext, 66.0F);
      localLayoutParams2.rightMargin = UIUtils.dip2px(paramContext, 6.0F);
      localayka.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView1.findViewById(2131380019));
      localayka.jdField_c_of_type_AndroidWidgetTextView = ((TextView)localView1.findViewById(2131379920));
      localayka.jdField_c_of_type_AndroidViewView = localView1.findViewById(2131373103);
      localayka.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)localView1.findViewById(2131369495));
      localayka.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
      localayka.jdField_d_of_type_AndroidWidgetTextView = ((TextView)localView1.findViewById(2131380082));
      localayka.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)localView1.findViewById(2131369363));
      localayka.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(this);
      localayka.e = ((TextView)localView1.findViewById(2131379839));
      localayka.jdField_a_of_type_AndroidWidgetListView = ((ListView)localView1.findViewById(2131364980));
      localayka.jdField_a_of_type_Aykd = new aykd();
      localayka.jdField_a_of_type_Aykd.a(this);
      localayka.jdField_a_of_type_AndroidWidgetListView.setAdapter(localayka.jdField_a_of_type_Aykd);
      localayka.f = ((TextView)localView1.findViewById(2131381338));
      localayka.jdField_d_of_type_AndroidViewView = localView1.findViewById(2131364978);
      localayka.f.setOnClickListener(this);
      ((LinearLayout)localObject).addView(paramView, localLayoutParams1);
      View localView2 = a((ViewGroup)localObject, localayka);
      if (localView2 != null)
      {
        localLayoutParams1 = (LinearLayout.LayoutParams)localView2.getLayoutParams();
        paramView = localLayoutParams1;
        if (localLayoutParams1 == null) {
          paramView = new LinearLayout.LayoutParams(-1, -2);
        }
        paramView.leftMargin = UIUtils.dip2px(paramContext, 66.0F);
        paramView.rightMargin = UIUtils.dip2px(paramContext, 6.0F);
        paramView.topMargin = UIUtils.dip2px(paramContext, -14.0F);
        ((LinearLayout)localObject).addView(localView2);
        localView2.setId(2131374405);
        localayka.jdField_b_of_type_AndroidViewView = localView2;
        localView2.setOnClickListener(this);
      }
      ((LinearLayout)localObject).addView(localView1, localLayoutParams2);
      ((LinearLayout)localObject).setTag(localayka);
      localayka.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
      paramView = new View(this.jdField_a_of_type_AndroidContentContext);
      paramView.setLayoutParams(new LinearLayout.LayoutParams(-1, UIUtils.dip2px(this.jdField_a_of_type_AndroidContentContext, 10.0F)));
      paramView.setBackgroundColor(-460807);
      ((LinearLayout)localObject).addView(paramView);
      paramView = (View)localObject;
      localObject = (ayka)paramView.getTag();
      ((ayka)localObject).jdField_a_of_type_Aylx = paramaylx;
      a((ayka)localObject);
      if ((!TextUtils.isEmpty(paramaylx.k)) && (!paramaylx.k.endsWith(anvx.a(2131700532)))) {
        break;
      }
      ((ayka)localObject).jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(2130845502, 0, 0, 0);
      ((ayka)localObject).jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(null);
      ((ayka)localObject).jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#777777"));
      paramaylx = paramView;
    } while (this.jdField_a_of_type_JavaUtilMap.get(((ayka)localObject).jdField_a_of_type_Aylx.c) != null);
    paramContext = new axxu().h("data_card").i("feed_exp").a(a((ayka)localObject)).d("2").b(((ayka)localObject).jdField_a_of_type_Aylx.c).c(String.valueOf(a((ayka)localObject)));
    if (this.jdField_a_of_type_Boolean) {}
    for (paramaylx = "1";; paramaylx = "2")
    {
      paramContext.e(paramaylx).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_a_of_type_JavaUtilMap.put(((ayka)localObject).jdField_a_of_type_Aylx.c, ((ayka)localObject).jdField_a_of_type_Aylx);
      return paramView;
      ((ayka)localObject).jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(2130845504, 0, 0, 0);
      ((ayka)localObject).jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#576B95"));
      ((ayka)localObject).jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(new ayju(this, paramContext, paramaylx, (ayka)localObject));
      break;
    }
  }
  
  public abstract ayka a();
  
  public String a(ayka paramayka)
  {
    return "";
  }
  
  public void a(View paramView)
  {
    paramView = (ayka)ayll.a(paramView, ayka.class);
    if (paramView == null) {
      return;
    }
    c(paramView);
  }
  
  public void a(ayka paramayka)
  {
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = UIUtils.dip2px(this.jdField_a_of_type_AndroidContentContext, 40.0F);
    ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = UIUtils.dip2px(this.jdField_a_of_type_AndroidContentContext, 40.0F);
    ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130840350);
    try
    {
      localObject = URLDrawable.getDrawable(paramayka.jdField_a_of_type_Aylx.d, (URLDrawable.URLDrawableOptions)localObject);
      ((URLDrawable)localObject).setTag(bgxc.a(UIUtils.dip2px(this.jdField_a_of_type_AndroidContentContext, 40.0F), UIUtils.dip2px(this.jdField_a_of_type_AndroidContentContext, 40.0F)));
      ((URLDrawable)localObject).setDecodeHandler(bgxc.a);
      paramayka.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null) {
        paramayka.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nickname);
      }
      paramayka.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
      f(paramayka);
      if (!TextUtils.isEmpty(paramayka.jdField_a_of_type_Aylx.jdField_g_of_type_JavaLangString))
      {
        paramayka.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        paramayka.jdField_b_of_type_AndroidWidgetTextView.setText(paramayka.jdField_a_of_type_Aylx.jdField_g_of_type_JavaLangString);
        localObject = new StringBuilder();
        if (!TextUtils.isEmpty(paramayka.jdField_a_of_type_Aylx.jdField_f_of_type_JavaLangString))
        {
          if (((StringBuilder)localObject).length() > 0) {
            ((StringBuilder)localObject).append(" · ");
          }
          ((StringBuilder)localObject).append(paramayka.jdField_a_of_type_Aylx.jdField_f_of_type_JavaLangString);
        }
        if (((StringBuilder)localObject).length() <= 0) {
          break label695;
        }
        paramayka.jdField_c_of_type_AndroidWidgetTextView.setText(((StringBuilder)localObject).toString());
        paramayka.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        if (!a(paramayka)) {
          break label730;
        }
        paramayka.jdField_c_of_type_AndroidViewView.setVisibility(0);
        if (!paramayka.jdField_a_of_type_Aylx.jdField_a_of_type_Boolean) {
          break label707;
        }
        paramayka.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130845445);
        paramayka.jdField_d_of_type_AndroidWidgetTextView.setTextColor(-52924);
        paramayka.jdField_d_of_type_AndroidWidgetTextView.setText(String.valueOf(paramayka.jdField_a_of_type_Aylx.jdField_f_of_type_Int));
        paramayka.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
        paramayka.e.setText(String.valueOf(paramayka.jdField_a_of_type_Aylx.jdField_g_of_type_Int));
        List localList = paramayka.jdField_a_of_type_Aylx.jdField_a_of_type_JavaUtilList;
        if ((localList == null) || (localList.size() <= 0)) {
          break label748;
        }
        paramayka.jdField_a_of_type_AndroidWidgetListView.setVisibility(0);
        paramayka.jdField_a_of_type_Aykd.a(localList);
        paramayka.jdField_a_of_type_Aykd.notifyDataSetChanged();
        if (this.b.get(paramayka.jdField_a_of_type_Aylx.c) == null)
        {
          axxu localaxxu = new axxu().h("data_card").i("feed_com_exp").d("2").a(a(paramayka)).b(paramayka.jdField_a_of_type_Aylx.c).c(String.valueOf(a(paramayka)));
          if (!this.jdField_a_of_type_Boolean) {
            break label742;
          }
          localObject = "1";
          localaxxu.e((String)localObject).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          this.b.put(paramayka.jdField_a_of_type_Aylx.c, paramayka.jdField_a_of_type_Aylx);
        }
        if ((localList == null) || (localList.size() <= 0) || (paramayka.jdField_a_of_type_Aylx.jdField_g_of_type_Int <= localList.size())) {
          break label760;
        }
        paramayka.f.setVisibility(0);
        if ((paramayka.jdField_a_of_type_AndroidWidgetListView.getVisibility() == 0) || (paramayka.f.getVisibility() == 0)) {
          break label772;
        }
        paramayka.jdField_d_of_type_AndroidViewView.setVisibility(8);
        paramayka.jdField_b_of_type_AndroidWidgetImageView.setClickable(true);
        paramayka.jdField_b_of_type_AndroidWidgetImageView.setAlpha(1.0F);
        paramayka.jdField_c_of_type_AndroidWidgetImageView.setClickable(true);
        paramayka.jdField_d_of_type_AndroidWidgetImageView.setClickable(true);
        paramayka.jdField_c_of_type_AndroidWidgetImageView.setAlpha(1.0F);
        paramayka.jdField_d_of_type_AndroidWidgetTextView.setAlpha(1.0F);
        paramayka.jdField_d_of_type_AndroidWidgetImageView.setAlpha(1.0F);
        paramayka.e.setAlpha(1.0F);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        paramayka.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130840350));
        QLog.i("BaseMomentItemBuilder", 1, "updateUI, holder.momentFeedInfo.headUrl=" + paramayka.jdField_a_of_type_Aylx.d);
        continue;
        paramayka.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        continue;
        label695:
        paramayka.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
        continue;
        label707:
        paramayka.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130845463);
        paramayka.jdField_d_of_type_AndroidWidgetTextView.setTextColor(-4473925);
        continue;
        label730:
        paramayka.jdField_c_of_type_AndroidViewView.setVisibility(8);
        continue;
        label742:
        String str = "2";
        continue;
        label748:
        paramayka.jdField_a_of_type_AndroidWidgetListView.setVisibility(8);
        continue;
        label760:
        paramayka.f.setVisibility(8);
        continue;
        label772:
        paramayka.jdField_d_of_type_AndroidViewView.setVisibility(0);
      }
    }
  }
  
  public void a(NearbyPeopleCard paramNearbyPeopleCard)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard = paramNearbyPeopleCard;
    this.jdField_a_of_type_Boolean = paramNearbyPeopleCard.isHostSelf;
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
  
  public boolean a(ayka paramayka)
  {
    return true;
  }
  
  public String b(ayka paramayka)
  {
    return paramayka.jdField_a_of_type_Aylx.c;
  }
  
  public void b(ayka paramayka)
  {
    aylx localaylx = paramayka.jdField_a_of_type_Aylx;
    axxu localaxxu = new axxu().h("data_card").i("feed_more_clk").d("2").a(a(paramayka)).b(localaylx.c).c(String.valueOf(a(paramayka)));
    if (this.jdField_a_of_type_Boolean) {}
    for (Object localObject = "1";; localObject = "2")
    {
      localaxxu.e((String)localObject).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (!TextUtils.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), localaylx.e)) {
        break;
      }
      localObject = bkzi.a(this.jdField_a_of_type_AndroidContentContext);
      ((bkzi)localObject).a(2131691448, 1);
      ((bkzi)localObject).c(2131690697);
      ((bkzi)localObject).a(new ayjv(this, paramayka, localaylx, (bkzi)localObject));
      ((bkzi)localObject).show();
      return;
    }
    localObject = bkzi.a(this.jdField_a_of_type_AndroidContentContext);
    ((bkzi)localObject).a(2131717316, 1);
    ((bkzi)localObject).c(2131690697);
    ((bkzi)localObject).a(new ayjw(this, paramayka, localaylx, (bkzi)localObject));
    ((bkzi)localObject).show();
  }
  
  public void c(ayka paramayka)
  {
    if (!NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_AndroidContentContext))
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, anvx.a(2131700526), 0).a();
      return;
    }
    a(paramayka.jdField_a_of_type_Aylx.m, true);
  }
  
  public void d(ayka paramayka)
  {
    String str = paramayka.jdField_a_of_type_Aylx.c;
    axxu localaxxu = new axxu().h("data_card").i("feed_clk").d("2").a(a(paramayka)).b(str).c(String.valueOf(a(paramayka)));
    if (this.jdField_a_of_type_Boolean) {}
    for (str = "1";; str = "2")
    {
      localaxxu.e(str).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_AndroidContentContext)) {
        break;
      }
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, anvx.a(2131700529), 0).a();
      return;
    }
    a(paramayka.jdField_a_of_type_Aylx.m, false);
  }
  
  public void e(ayka paramayka)
  {
    ayly localayly = (ayly)paramayka.jdField_a_of_type_Aylx;
    Object localObject = localayly.a;
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localObject);
    localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("feedId", localayly.c);
      ((JSONObject)localObject).put("tinyId", "");
      ((JSONObject)localObject).put("uin", localayly.e);
      ((JSONObject)localObject).put("reason", anvx.a(2131700530));
      bfxp.a(paramayka.jdField_a_of_type_AndroidAppActivity, 0, localArrayList, null, null, false, false, "5", 100, null, null, ((JSONObject)localObject).toString());
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
  
  public abstract void f(ayka paramayka);
  
  public void onClick(View paramView)
  {
    ayka localayka = (ayka)ayll.a(paramView, ayka.class);
    if (localayka == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      switch (paramView.getId())
      {
      default: 
        break;
      case 2131369363: 
        c(localayka);
        break;
      case 2131369463: 
        b(localayka);
        break;
      case 2131369495: 
        h(localayka);
        break;
      case 2131381338: 
        axxu localaxxu = new axxu().h("data_card").i("feed_com_clk").d("2").a(a(localayka)).b(localayka.jdField_a_of_type_Aylx.c).c(String.valueOf(a(localayka)));
        if (this.jdField_a_of_type_Boolean) {}
        for (String str = "1";; str = "2")
        {
          localaxxu.e(str).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          break;
        }
      case 2131374405: 
        d(localayka);
        break;
      case 2131369488: 
        e(localayka);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayjt
 * JD-Core Version:    0.7.0.1
 */