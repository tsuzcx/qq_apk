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
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class atur
  implements View.OnClickListener, atvd
{
  protected Context a;
  protected QQAppInterface a;
  protected NearbyPeopleCard a;
  protected Map<String, atwv> a;
  protected boolean a;
  protected Map<String, atwv> b = new HashMap();
  protected Map<String, atwv> c = new HashMap();
  
  public atur(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private void g(atuy paramatuy)
  {
    atwv localatwv = paramatuy.jdField_a_of_type_Atwv;
    bbcv.a(this.jdField_a_of_type_AndroidContentContext, 230).setTitle(ajyc.a(2131701022)).setNegativeButton(2131690596, new atux(this)).setPositiveButton(2131691507, new atuv(this, localatwv, paramatuy)).show();
  }
  
  private void h(atuy paramatuy)
  {
    if (!bbev.g(this.jdField_a_of_type_AndroidContentContext))
    {
      bcpw.a(this.jdField_a_of_type_AndroidContentContext, 1, ajyc.a(2131701019), 0).a();
      return;
    }
    boolean bool = paramatuy.jdField_a_of_type_Atwv.jdField_a_of_type_Boolean;
    String str = b(paramatuy);
    Object localObject = (atvq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(263);
    if (!bool)
    {
      ((atvq)localObject).a(str);
      ativ localativ = new ativ().h("data_card");
      if (!bool) {
        break label157;
      }
      localObject = "feed_unlike";
      label89:
      localObject = localativ.i((String)localObject).d("2").a(a(paramatuy)).b(str).c(String.valueOf(a(paramatuy)));
      if (!this.jdField_a_of_type_Boolean) {
        break label163;
      }
    }
    label157:
    label163:
    for (paramatuy = "1";; paramatuy = "2")
    {
      ((ativ)localObject).e(paramatuy).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      return;
      ((atvq)localObject).b(str);
      break;
      localObject = "feed_like";
      break label89;
    }
  }
  
  public abstract int a(atuy paramatuy);
  
  public abstract View a(ViewGroup paramViewGroup, atuy paramatuy);
  
  public View a(atwv paramatwv, Context paramContext, View paramView)
  {
    Object localObject = (LinearLayout)paramView;
    paramView = (View)localObject;
    atuy localatuy;
    if (localObject == null)
    {
      localObject = new LinearLayout(paramContext);
      ((LinearLayout)localObject).setLayoutParams(new AbsListView.LayoutParams(-1, -1));
      ((LinearLayout)localObject).setBackgroundColor(-1);
      ((LinearLayout)localObject).setOrientation(1);
      localatuy = a();
      if (localatuy == null) {
        paramatwv = null;
      }
    }
    do
    {
      return paramatwv;
      localatuy.jdField_a_of_type_AndroidAppActivity = ((Activity)paramContext);
      localatuy.jdField_a_of_type_AndroidViewView = ((View)localObject);
      paramView = LayoutInflater.from(paramContext).inflate(2131560897, (ViewGroup)localObject, false);
      LinearLayout.LayoutParams localLayoutParams1 = new LinearLayout.LayoutParams(-1, -2);
      localLayoutParams1.topMargin = vzo.a(paramContext, 20.0F);
      localLayoutParams1.leftMargin = vzo.a(paramContext, 16.0F);
      localLayoutParams1.bottomMargin = vzo.a(paramContext, 0.0F);
      localLayoutParams1.rightMargin = vzo.a(paramContext, 6.0F);
      localatuy.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368583));
      localatuy.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378262));
      localatuy.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368624));
      View localView1 = LayoutInflater.from(paramContext).inflate(2131560893, (ViewGroup)localObject, false);
      LinearLayout.LayoutParams localLayoutParams2 = new LinearLayout.LayoutParams(-1, -2);
      localLayoutParams2.leftMargin = vzo.a(paramContext, 66.0F);
      localLayoutParams2.rightMargin = vzo.a(paramContext, 6.0F);
      localatuy.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView1.findViewById(2131378248));
      localatuy.jdField_c_of_type_AndroidWidgetTextView = ((TextView)localView1.findViewById(2131378166));
      localatuy.jdField_c_of_type_AndroidViewView = localView1.findViewById(2131371884);
      localatuy.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)localView1.findViewById(2131368643));
      localatuy.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
      localatuy.jdField_d_of_type_AndroidWidgetTextView = ((TextView)localView1.findViewById(2131378287));
      localatuy.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)localView1.findViewById(2131368538));
      localatuy.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(this);
      localatuy.e = ((TextView)localView1.findViewById(2131378096));
      localatuy.jdField_a_of_type_AndroidWidgetListView = ((ListView)localView1.findViewById(2131364525));
      localatuy.jdField_a_of_type_Atvb = new atvb();
      localatuy.jdField_a_of_type_Atvb.a(this);
      localatuy.jdField_a_of_type_AndroidWidgetListView.setAdapter(localatuy.jdField_a_of_type_Atvb);
      localatuy.f = ((TextView)localView1.findViewById(2131379353));
      localatuy.jdField_d_of_type_AndroidViewView = localView1.findViewById(2131364523);
      localatuy.f.setOnClickListener(this);
      ((LinearLayout)localObject).addView(paramView, localLayoutParams1);
      View localView2 = a((ViewGroup)localObject, localatuy);
      if (localView2 != null)
      {
        localLayoutParams1 = (LinearLayout.LayoutParams)localView2.getLayoutParams();
        paramView = localLayoutParams1;
        if (localLayoutParams1 == null) {
          paramView = new LinearLayout.LayoutParams(-1, -2);
        }
        paramView.leftMargin = vzo.a(paramContext, 66.0F);
        paramView.rightMargin = vzo.a(paramContext, 6.0F);
        paramView.topMargin = vzo.a(paramContext, -14.0F);
        ((LinearLayout)localObject).addView(localView2);
        localView2.setId(2131373070);
        localatuy.jdField_b_of_type_AndroidViewView = localView2;
        localView2.setOnClickListener(this);
      }
      ((LinearLayout)localObject).addView(localView1, localLayoutParams2);
      ((LinearLayout)localObject).setTag(localatuy);
      localatuy.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
      paramView = new View(this.jdField_a_of_type_AndroidContentContext);
      paramView.setLayoutParams(new LinearLayout.LayoutParams(-1, vzo.a(this.jdField_a_of_type_AndroidContentContext, 10.0F)));
      paramView.setBackgroundColor(-460807);
      ((LinearLayout)localObject).addView(paramView);
      paramView = (View)localObject;
      localObject = (atuy)paramView.getTag();
      ((atuy)localObject).jdField_a_of_type_Atwv = paramatwv;
      a((atuy)localObject);
      if ((!TextUtils.isEmpty(paramatwv.k)) && (!paramatwv.k.endsWith(ajyc.a(2131701023)))) {
        break;
      }
      ((atuy)localObject).jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(2130844690, 0, 0, 0);
      ((atuy)localObject).jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(null);
      ((atuy)localObject).jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#777777"));
      paramatwv = paramView;
    } while (this.jdField_a_of_type_JavaUtilMap.get(((atuy)localObject).jdField_a_of_type_Atwv.c) != null);
    paramContext = new ativ().h("data_card").i("feed_exp").a(a((atuy)localObject)).d("2").b(((atuy)localObject).jdField_a_of_type_Atwv.c).c(String.valueOf(a((atuy)localObject)));
    if (this.jdField_a_of_type_Boolean) {}
    for (paramatwv = "1";; paramatwv = "2")
    {
      paramContext.e(paramatwv).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_a_of_type_JavaUtilMap.put(((atuy)localObject).jdField_a_of_type_Atwv.c, ((atuy)localObject).jdField_a_of_type_Atwv);
      return paramView;
      ((atuy)localObject).jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(2130844692, 0, 0, 0);
      ((atuy)localObject).jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#576B95"));
      ((atuy)localObject).jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(new atus(this, paramContext, paramatwv, (atuy)localObject));
      break;
    }
  }
  
  public abstract atuy a();
  
  public String a(atuy paramatuy)
  {
    return "";
  }
  
  public void a(View paramView)
  {
    paramView = (atuy)atwj.a(paramView, atuy.class);
    if (paramView == null) {
      return;
    }
    c(paramView);
  }
  
  public void a(atuy paramatuy)
  {
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = vzo.a(this.jdField_a_of_type_AndroidContentContext, 40.0F);
    ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = vzo.a(this.jdField_a_of_type_AndroidContentContext, 40.0F);
    ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130839738);
    try
    {
      localObject = URLDrawable.getDrawable(paramatuy.jdField_a_of_type_Atwv.d, (URLDrawable.URLDrawableOptions)localObject);
      ((URLDrawable)localObject).setTag(bavi.a(vzo.a(this.jdField_a_of_type_AndroidContentContext, 40.0F), vzo.a(this.jdField_a_of_type_AndroidContentContext, 40.0F)));
      ((URLDrawable)localObject).setDecodeHandler(bavi.a);
      paramatuy.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null) {
        paramatuy.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nickname);
      }
      paramatuy.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
      f(paramatuy);
      if (!TextUtils.isEmpty(paramatuy.jdField_a_of_type_Atwv.jdField_g_of_type_JavaLangString))
      {
        paramatuy.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        paramatuy.jdField_b_of_type_AndroidWidgetTextView.setText(paramatuy.jdField_a_of_type_Atwv.jdField_g_of_type_JavaLangString);
        localObject = new StringBuilder();
        if (!TextUtils.isEmpty(paramatuy.jdField_a_of_type_Atwv.jdField_f_of_type_JavaLangString))
        {
          if (((StringBuilder)localObject).length() > 0) {
            ((StringBuilder)localObject).append(" · ");
          }
          ((StringBuilder)localObject).append(paramatuy.jdField_a_of_type_Atwv.jdField_f_of_type_JavaLangString);
        }
        if (((StringBuilder)localObject).length() <= 0) {
          break label695;
        }
        paramatuy.jdField_c_of_type_AndroidWidgetTextView.setText(((StringBuilder)localObject).toString());
        paramatuy.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        if (!a(paramatuy)) {
          break label730;
        }
        paramatuy.jdField_c_of_type_AndroidViewView.setVisibility(0);
        if (!paramatuy.jdField_a_of_type_Atwv.jdField_a_of_type_Boolean) {
          break label707;
        }
        paramatuy.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130844633);
        paramatuy.jdField_d_of_type_AndroidWidgetTextView.setTextColor(-52924);
        paramatuy.jdField_d_of_type_AndroidWidgetTextView.setText(String.valueOf(paramatuy.jdField_a_of_type_Atwv.jdField_f_of_type_Int));
        paramatuy.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
        paramatuy.e.setText(String.valueOf(paramatuy.jdField_a_of_type_Atwv.jdField_g_of_type_Int));
        List localList = paramatuy.jdField_a_of_type_Atwv.jdField_a_of_type_JavaUtilList;
        if ((localList == null) || (localList.size() <= 0)) {
          break label748;
        }
        paramatuy.jdField_a_of_type_AndroidWidgetListView.setVisibility(0);
        paramatuy.jdField_a_of_type_Atvb.a(localList);
        paramatuy.jdField_a_of_type_Atvb.notifyDataSetChanged();
        if (this.b.get(paramatuy.jdField_a_of_type_Atwv.c) == null)
        {
          ativ localativ = new ativ().h("data_card").i("feed_com_exp").d("2").a(a(paramatuy)).b(paramatuy.jdField_a_of_type_Atwv.c).c(String.valueOf(a(paramatuy)));
          if (!this.jdField_a_of_type_Boolean) {
            break label742;
          }
          localObject = "1";
          localativ.e((String)localObject).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          this.b.put(paramatuy.jdField_a_of_type_Atwv.c, paramatuy.jdField_a_of_type_Atwv);
        }
        if ((localList == null) || (localList.size() <= 0) || (paramatuy.jdField_a_of_type_Atwv.jdField_g_of_type_Int <= localList.size())) {
          break label760;
        }
        paramatuy.f.setVisibility(0);
        if ((paramatuy.jdField_a_of_type_AndroidWidgetListView.getVisibility() == 0) || (paramatuy.f.getVisibility() == 0)) {
          break label772;
        }
        paramatuy.jdField_d_of_type_AndroidViewView.setVisibility(8);
        paramatuy.jdField_b_of_type_AndroidWidgetImageView.setClickable(true);
        paramatuy.jdField_b_of_type_AndroidWidgetImageView.setAlpha(1.0F);
        paramatuy.jdField_c_of_type_AndroidWidgetImageView.setClickable(true);
        paramatuy.jdField_d_of_type_AndroidWidgetImageView.setClickable(true);
        paramatuy.jdField_c_of_type_AndroidWidgetImageView.setAlpha(1.0F);
        paramatuy.jdField_d_of_type_AndroidWidgetTextView.setAlpha(1.0F);
        paramatuy.jdField_d_of_type_AndroidWidgetImageView.setAlpha(1.0F);
        paramatuy.e.setAlpha(1.0F);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        paramatuy.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130839738));
        QLog.i("BaseMomentItemBuilder", 1, "updateUI, holder.momentFeedInfo.headUrl=" + paramatuy.jdField_a_of_type_Atwv.d);
        continue;
        paramatuy.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        continue;
        label695:
        paramatuy.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
        continue;
        label707:
        paramatuy.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130844651);
        paramatuy.jdField_d_of_type_AndroidWidgetTextView.setTextColor(-4473925);
        continue;
        label730:
        paramatuy.jdField_c_of_type_AndroidViewView.setVisibility(8);
        continue;
        label742:
        String str = "2";
        continue;
        label748:
        paramatuy.jdField_a_of_type_AndroidWidgetListView.setVisibility(8);
        continue;
        label760:
        paramatuy.f.setVisibility(8);
        continue;
        label772:
        paramatuy.jdField_d_of_type_AndroidViewView.setVisibility(0);
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
  
  public boolean a(atuy paramatuy)
  {
    return true;
  }
  
  public String b(atuy paramatuy)
  {
    return paramatuy.jdField_a_of_type_Atwv.c;
  }
  
  public void b(atuy paramatuy)
  {
    atwv localatwv = paramatuy.jdField_a_of_type_Atwv;
    ativ localativ = new ativ().h("data_card").i("feed_more_clk").d("2").a(a(paramatuy)).b(localatwv.c).c(String.valueOf(a(paramatuy)));
    if (this.jdField_a_of_type_Boolean) {}
    for (Object localObject = "1";; localObject = "2")
    {
      localativ.e((String)localObject).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (!TextUtils.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), localatwv.e)) {
        break;
      }
      localObject = bfol.a(this.jdField_a_of_type_AndroidContentContext);
      ((bfol)localObject).a(2131691507, 1);
      ((bfol)localObject).c(2131690596);
      ((bfol)localObject).a(new atut(this, paramatuy, localatwv, (bfol)localObject));
      ((bfol)localObject).show();
      return;
    }
    localObject = bfol.a(this.jdField_a_of_type_AndroidContentContext);
    ((bfol)localObject).a(2131718049, 1);
    ((bfol)localObject).c(2131690596);
    ((bfol)localObject).a(new atuu(this, paramatuy, localatwv, (bfol)localObject));
    ((bfol)localObject).show();
  }
  
  public void c(atuy paramatuy)
  {
    if (!bbev.g(this.jdField_a_of_type_AndroidContentContext))
    {
      bcpw.a(this.jdField_a_of_type_AndroidContentContext, 1, ajyc.a(2131701017), 0).a();
      return;
    }
    a(paramatuy.jdField_a_of_type_Atwv.m, true);
  }
  
  public void d(atuy paramatuy)
  {
    String str = paramatuy.jdField_a_of_type_Atwv.c;
    ativ localativ = new ativ().h("data_card").i("feed_clk").d("2").a(a(paramatuy)).b(str).c(String.valueOf(a(paramatuy)));
    if (this.jdField_a_of_type_Boolean) {}
    for (str = "1";; str = "2")
    {
      localativ.e(str).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (bbev.g(this.jdField_a_of_type_AndroidContentContext)) {
        break;
      }
      bcpw.a(this.jdField_a_of_type_AndroidContentContext, 1, ajyc.a(2131701020), 0).a();
      return;
    }
    a(paramatuy.jdField_a_of_type_Atwv.m, false);
  }
  
  public void e(atuy paramatuy)
  {
    atww localatww = (atww)paramatuy.jdField_a_of_type_Atwv;
    Object localObject = localatww.a;
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localObject);
    localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("feedId", localatww.c);
      ((JSONObject)localObject).put("tinyId", "");
      ((JSONObject)localObject).put("uin", localatww.e);
      ((JSONObject)localObject).put("reason", ajyc.a(2131701021));
      badh.a(paramatuy.jdField_a_of_type_AndroidAppActivity, 0, localArrayList, null, null, false, false, "5", 100, null, null, ((JSONObject)localObject).toString());
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
  
  public abstract void f(atuy paramatuy);
  
  public void onClick(View paramView)
  {
    atuy localatuy = (atuy)atwj.a(paramView, atuy.class);
    if (localatuy == null) {
      return;
    }
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131368538: 
      c(localatuy);
      return;
    case 2131368624: 
      b(localatuy);
      return;
    case 2131368643: 
      h(localatuy);
      return;
    case 2131379353: 
      ativ localativ = new ativ().h("data_card").i("feed_com_clk").d("2").a(a(localatuy)).b(localatuy.jdField_a_of_type_Atwv.c).c(String.valueOf(a(localatuy)));
      if (this.jdField_a_of_type_Boolean) {}
      for (paramView = "1";; paramView = "2")
      {
        localativ.e(paramView).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        break;
      }
    case 2131373070: 
      d(localatuy);
      return;
    }
    e(localatuy);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atur
 * JD-Core Version:    0.7.0.1
 */