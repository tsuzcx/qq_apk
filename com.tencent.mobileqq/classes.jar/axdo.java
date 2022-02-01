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

public abstract class axdo
  implements View.OnClickListener, axea
{
  protected Context a;
  protected QQAppInterface a;
  protected NearbyPeopleCard a;
  protected Map<String, axfs> a;
  protected boolean a;
  protected Map<String, axfs> b = new HashMap();
  protected Map<String, axfs> c = new HashMap();
  
  public axdo(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private void g(axdv paramaxdv)
  {
    axfs localaxfs = paramaxdv.jdField_a_of_type_Axfs;
    bfur.a(this.jdField_a_of_type_AndroidContentContext, 230).setTitle(amtj.a(2131700180)).setNegativeButton(2131690620, new axdu(this)).setPositiveButton(2131691363, new axds(this, localaxfs, paramaxdv)).show();
  }
  
  private void h(axdv paramaxdv)
  {
    if (!NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_AndroidContentContext))
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, amtj.a(2131700177), 0).a();
      return;
    }
    boolean bool = paramaxdv.jdField_a_of_type_Axfs.jdField_a_of_type_Boolean;
    String str = b(paramaxdv);
    Object localObject = (axen)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(263);
    if (!bool)
    {
      ((axen)localObject).a(str);
      awrs localawrs = new awrs().h("data_card");
      if (!bool) {
        break label157;
      }
      localObject = "feed_unlike";
      label89:
      localObject = localawrs.i((String)localObject).d("2").a(a(paramaxdv)).b(str).c(String.valueOf(a(paramaxdv)));
      if (!this.jdField_a_of_type_Boolean) {
        break label163;
      }
    }
    label157:
    label163:
    for (paramaxdv = "1";; paramaxdv = "2")
    {
      ((awrs)localObject).e(paramaxdv).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      return;
      ((axen)localObject).b(str);
      break;
      localObject = "feed_like";
      break label89;
    }
  }
  
  public abstract int a(axdv paramaxdv);
  
  public abstract View a(ViewGroup paramViewGroup, axdv paramaxdv);
  
  public View a(axfs paramaxfs, Context paramContext, View paramView)
  {
    Object localObject = (LinearLayout)paramView;
    paramView = (View)localObject;
    axdv localaxdv;
    if (localObject == null)
    {
      localObject = new LinearLayout(paramContext);
      ((LinearLayout)localObject).setLayoutParams(new AbsListView.LayoutParams(-1, -1));
      ((LinearLayout)localObject).setBackgroundColor(-1);
      ((LinearLayout)localObject).setOrientation(1);
      localaxdv = a();
      if (localaxdv == null) {
        paramaxfs = null;
      }
    }
    do
    {
      return paramaxfs;
      localaxdv.jdField_a_of_type_AndroidAppActivity = ((Activity)paramContext);
      localaxdv.jdField_a_of_type_AndroidViewView = ((View)localObject);
      paramView = LayoutInflater.from(paramContext).inflate(2131561221, (ViewGroup)localObject, false);
      LinearLayout.LayoutParams localLayoutParams1 = new LinearLayout.LayoutParams(-1, -2);
      localLayoutParams1.topMargin = UIUtils.dip2px(paramContext, 20.0F);
      localLayoutParams1.leftMargin = UIUtils.dip2px(paramContext, 16.0F);
      localLayoutParams1.bottomMargin = UIUtils.dip2px(paramContext, 0.0F);
      localLayoutParams1.rightMargin = UIUtils.dip2px(paramContext, 6.0F);
      localaxdv.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369250));
      localaxdv.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379724));
      localaxdv.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369296));
      View localView1 = LayoutInflater.from(paramContext).inflate(2131561217, (ViewGroup)localObject, false);
      LinearLayout.LayoutParams localLayoutParams2 = new LinearLayout.LayoutParams(-1, -2);
      localLayoutParams2.leftMargin = UIUtils.dip2px(paramContext, 66.0F);
      localLayoutParams2.rightMargin = UIUtils.dip2px(paramContext, 6.0F);
      localaxdv.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView1.findViewById(2131379705));
      localaxdv.jdField_c_of_type_AndroidWidgetTextView = ((TextView)localView1.findViewById(2131379608));
      localaxdv.jdField_c_of_type_AndroidViewView = localView1.findViewById(2131372893);
      localaxdv.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)localView1.findViewById(2131369328));
      localaxdv.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
      localaxdv.jdField_d_of_type_AndroidWidgetTextView = ((TextView)localView1.findViewById(2131379761));
      localaxdv.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)localView1.findViewById(2131369200));
      localaxdv.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(this);
      localaxdv.e = ((TextView)localView1.findViewById(2131379528));
      localaxdv.jdField_a_of_type_AndroidWidgetListView = ((ListView)localView1.findViewById(2131364892));
      localaxdv.jdField_a_of_type_Axdy = new axdy();
      localaxdv.jdField_a_of_type_Axdy.a(this);
      localaxdv.jdField_a_of_type_AndroidWidgetListView.setAdapter(localaxdv.jdField_a_of_type_Axdy);
      localaxdv.f = ((TextView)localView1.findViewById(2131380984));
      localaxdv.jdField_d_of_type_AndroidViewView = localView1.findViewById(2131364890);
      localaxdv.f.setOnClickListener(this);
      ((LinearLayout)localObject).addView(paramView, localLayoutParams1);
      View localView2 = a((ViewGroup)localObject, localaxdv);
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
        localView2.setId(2131374171);
        localaxdv.jdField_b_of_type_AndroidViewView = localView2;
        localView2.setOnClickListener(this);
      }
      ((LinearLayout)localObject).addView(localView1, localLayoutParams2);
      ((LinearLayout)localObject).setTag(localaxdv);
      localaxdv.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
      paramView = new View(this.jdField_a_of_type_AndroidContentContext);
      paramView.setLayoutParams(new LinearLayout.LayoutParams(-1, UIUtils.dip2px(this.jdField_a_of_type_AndroidContentContext, 10.0F)));
      paramView.setBackgroundColor(-460807);
      ((LinearLayout)localObject).addView(paramView);
      paramView = (View)localObject;
      localObject = (axdv)paramView.getTag();
      ((axdv)localObject).jdField_a_of_type_Axfs = paramaxfs;
      a((axdv)localObject);
      if ((!TextUtils.isEmpty(paramaxfs.k)) && (!paramaxfs.k.endsWith(amtj.a(2131700181)))) {
        break;
      }
      ((axdv)localObject).jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(2130845417, 0, 0, 0);
      ((axdv)localObject).jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(null);
      ((axdv)localObject).jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#777777"));
      paramaxfs = paramView;
    } while (this.jdField_a_of_type_JavaUtilMap.get(((axdv)localObject).jdField_a_of_type_Axfs.c) != null);
    paramContext = new awrs().h("data_card").i("feed_exp").a(a((axdv)localObject)).d("2").b(((axdv)localObject).jdField_a_of_type_Axfs.c).c(String.valueOf(a((axdv)localObject)));
    if (this.jdField_a_of_type_Boolean) {}
    for (paramaxfs = "1";; paramaxfs = "2")
    {
      paramContext.e(paramaxfs).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_a_of_type_JavaUtilMap.put(((axdv)localObject).jdField_a_of_type_Axfs.c, ((axdv)localObject).jdField_a_of_type_Axfs);
      return paramView;
      ((axdv)localObject).jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(2130845419, 0, 0, 0);
      ((axdv)localObject).jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#576B95"));
      ((axdv)localObject).jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(new axdp(this, paramContext, paramaxfs, (axdv)localObject));
      break;
    }
  }
  
  public abstract axdv a();
  
  public String a(axdv paramaxdv)
  {
    return "";
  }
  
  public void a(View paramView)
  {
    paramView = (axdv)axfg.a(paramView, axdv.class);
    if (paramView == null) {
      return;
    }
    c(paramView);
  }
  
  public void a(axdv paramaxdv)
  {
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = UIUtils.dip2px(this.jdField_a_of_type_AndroidContentContext, 40.0F);
    ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = UIUtils.dip2px(this.jdField_a_of_type_AndroidContentContext, 40.0F);
    ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130840314);
    try
    {
      localObject = URLDrawable.getDrawable(paramaxdv.jdField_a_of_type_Axfs.d, (URLDrawable.URLDrawableOptions)localObject);
      ((URLDrawable)localObject).setTag(bfol.a(UIUtils.dip2px(this.jdField_a_of_type_AndroidContentContext, 40.0F), UIUtils.dip2px(this.jdField_a_of_type_AndroidContentContext, 40.0F)));
      ((URLDrawable)localObject).setDecodeHandler(bfol.a);
      paramaxdv.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null) {
        paramaxdv.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nickname);
      }
      paramaxdv.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
      f(paramaxdv);
      if (!TextUtils.isEmpty(paramaxdv.jdField_a_of_type_Axfs.jdField_g_of_type_JavaLangString))
      {
        paramaxdv.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        paramaxdv.jdField_b_of_type_AndroidWidgetTextView.setText(paramaxdv.jdField_a_of_type_Axfs.jdField_g_of_type_JavaLangString);
        localObject = new StringBuilder();
        if (!TextUtils.isEmpty(paramaxdv.jdField_a_of_type_Axfs.jdField_f_of_type_JavaLangString))
        {
          if (((StringBuilder)localObject).length() > 0) {
            ((StringBuilder)localObject).append(" · ");
          }
          ((StringBuilder)localObject).append(paramaxdv.jdField_a_of_type_Axfs.jdField_f_of_type_JavaLangString);
        }
        if (((StringBuilder)localObject).length() <= 0) {
          break label695;
        }
        paramaxdv.jdField_c_of_type_AndroidWidgetTextView.setText(((StringBuilder)localObject).toString());
        paramaxdv.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        if (!a(paramaxdv)) {
          break label730;
        }
        paramaxdv.jdField_c_of_type_AndroidViewView.setVisibility(0);
        if (!paramaxdv.jdField_a_of_type_Axfs.jdField_a_of_type_Boolean) {
          break label707;
        }
        paramaxdv.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130845360);
        paramaxdv.jdField_d_of_type_AndroidWidgetTextView.setTextColor(-52924);
        paramaxdv.jdField_d_of_type_AndroidWidgetTextView.setText(String.valueOf(paramaxdv.jdField_a_of_type_Axfs.jdField_f_of_type_Int));
        paramaxdv.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
        paramaxdv.e.setText(String.valueOf(paramaxdv.jdField_a_of_type_Axfs.jdField_g_of_type_Int));
        List localList = paramaxdv.jdField_a_of_type_Axfs.jdField_a_of_type_JavaUtilList;
        if ((localList == null) || (localList.size() <= 0)) {
          break label748;
        }
        paramaxdv.jdField_a_of_type_AndroidWidgetListView.setVisibility(0);
        paramaxdv.jdField_a_of_type_Axdy.a(localList);
        paramaxdv.jdField_a_of_type_Axdy.notifyDataSetChanged();
        if (this.b.get(paramaxdv.jdField_a_of_type_Axfs.c) == null)
        {
          awrs localawrs = new awrs().h("data_card").i("feed_com_exp").d("2").a(a(paramaxdv)).b(paramaxdv.jdField_a_of_type_Axfs.c).c(String.valueOf(a(paramaxdv)));
          if (!this.jdField_a_of_type_Boolean) {
            break label742;
          }
          localObject = "1";
          localawrs.e((String)localObject).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          this.b.put(paramaxdv.jdField_a_of_type_Axfs.c, paramaxdv.jdField_a_of_type_Axfs);
        }
        if ((localList == null) || (localList.size() <= 0) || (paramaxdv.jdField_a_of_type_Axfs.jdField_g_of_type_Int <= localList.size())) {
          break label760;
        }
        paramaxdv.f.setVisibility(0);
        if ((paramaxdv.jdField_a_of_type_AndroidWidgetListView.getVisibility() == 0) || (paramaxdv.f.getVisibility() == 0)) {
          break label772;
        }
        paramaxdv.jdField_d_of_type_AndroidViewView.setVisibility(8);
        paramaxdv.jdField_b_of_type_AndroidWidgetImageView.setClickable(true);
        paramaxdv.jdField_b_of_type_AndroidWidgetImageView.setAlpha(1.0F);
        paramaxdv.jdField_c_of_type_AndroidWidgetImageView.setClickable(true);
        paramaxdv.jdField_d_of_type_AndroidWidgetImageView.setClickable(true);
        paramaxdv.jdField_c_of_type_AndroidWidgetImageView.setAlpha(1.0F);
        paramaxdv.jdField_d_of_type_AndroidWidgetTextView.setAlpha(1.0F);
        paramaxdv.jdField_d_of_type_AndroidWidgetImageView.setAlpha(1.0F);
        paramaxdv.e.setAlpha(1.0F);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        paramaxdv.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130840314));
        QLog.i("BaseMomentItemBuilder", 1, "updateUI, holder.momentFeedInfo.headUrl=" + paramaxdv.jdField_a_of_type_Axfs.d);
        continue;
        paramaxdv.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        continue;
        label695:
        paramaxdv.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
        continue;
        label707:
        paramaxdv.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130845378);
        paramaxdv.jdField_d_of_type_AndroidWidgetTextView.setTextColor(-4473925);
        continue;
        label730:
        paramaxdv.jdField_c_of_type_AndroidViewView.setVisibility(8);
        continue;
        label742:
        String str = "2";
        continue;
        label748:
        paramaxdv.jdField_a_of_type_AndroidWidgetListView.setVisibility(8);
        continue;
        label760:
        paramaxdv.f.setVisibility(8);
        continue;
        label772:
        paramaxdv.jdField_d_of_type_AndroidViewView.setVisibility(0);
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
  
  public boolean a(axdv paramaxdv)
  {
    return true;
  }
  
  public String b(axdv paramaxdv)
  {
    return paramaxdv.jdField_a_of_type_Axfs.c;
  }
  
  public void b(axdv paramaxdv)
  {
    axfs localaxfs = paramaxdv.jdField_a_of_type_Axfs;
    awrs localawrs = new awrs().h("data_card").i("feed_more_clk").d("2").a(a(paramaxdv)).b(localaxfs.c).c(String.valueOf(a(paramaxdv)));
    if (this.jdField_a_of_type_Boolean) {}
    for (Object localObject = "1";; localObject = "2")
    {
      localawrs.e((String)localObject).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (!TextUtils.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), localaxfs.e)) {
        break;
      }
      localObject = bjnw.a(this.jdField_a_of_type_AndroidContentContext);
      ((bjnw)localObject).a(2131691363, 1);
      ((bjnw)localObject).c(2131690620);
      ((bjnw)localObject).a(new axdq(this, paramaxdv, localaxfs, (bjnw)localObject));
      ((bjnw)localObject).show();
      return;
    }
    localObject = bjnw.a(this.jdField_a_of_type_AndroidContentContext);
    ((bjnw)localObject).a(2131716953, 1);
    ((bjnw)localObject).c(2131690620);
    ((bjnw)localObject).a(new axdr(this, paramaxdv, localaxfs, (bjnw)localObject));
    ((bjnw)localObject).show();
  }
  
  public void c(axdv paramaxdv)
  {
    if (!NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_AndroidContentContext))
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, amtj.a(2131700175), 0).a();
      return;
    }
    a(paramaxdv.jdField_a_of_type_Axfs.m, true);
  }
  
  public void d(axdv paramaxdv)
  {
    String str = paramaxdv.jdField_a_of_type_Axfs.c;
    awrs localawrs = new awrs().h("data_card").i("feed_clk").d("2").a(a(paramaxdv)).b(str).c(String.valueOf(a(paramaxdv)));
    if (this.jdField_a_of_type_Boolean) {}
    for (str = "1";; str = "2")
    {
      localawrs.e(str).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_AndroidContentContext)) {
        break;
      }
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, amtj.a(2131700178), 0).a();
      return;
    }
    a(paramaxdv.jdField_a_of_type_Axfs.m, false);
  }
  
  public void e(axdv paramaxdv)
  {
    axft localaxft = (axft)paramaxdv.jdField_a_of_type_Axfs;
    Object localObject = localaxft.a;
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localObject);
    localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("feedId", localaxft.c);
      ((JSONObject)localObject).put("tinyId", "");
      ((JSONObject)localObject).put("uin", localaxft.e);
      ((JSONObject)localObject).put("reason", amtj.a(2131700179));
      beqn.a(paramaxdv.jdField_a_of_type_AndroidAppActivity, 0, localArrayList, null, null, false, false, "5", 100, null, null, ((JSONObject)localObject).toString());
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
  
  public abstract void f(axdv paramaxdv);
  
  public void onClick(View paramView)
  {
    axdv localaxdv = (axdv)axfg.a(paramView, axdv.class);
    if (localaxdv == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      switch (paramView.getId())
      {
      default: 
        break;
      case 2131369200: 
        c(localaxdv);
        break;
      case 2131369296: 
        b(localaxdv);
        break;
      case 2131369328: 
        h(localaxdv);
        break;
      case 2131380984: 
        awrs localawrs = new awrs().h("data_card").i("feed_com_clk").d("2").a(a(localaxdv)).b(localaxdv.jdField_a_of_type_Axfs.c).c(String.valueOf(a(localaxdv)));
        if (this.jdField_a_of_type_Boolean) {}
        for (String str = "1";; str = "2")
        {
          localawrs.e(str).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          break;
        }
      case 2131374171: 
        d(localaxdv);
        break;
      case 2131369321: 
        e(localaxdv);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axdo
 * JD-Core Version:    0.7.0.1
 */