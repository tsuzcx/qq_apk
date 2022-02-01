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

public abstract class axxm
  implements View.OnClickListener, axxy
{
  protected Context a;
  protected QQAppInterface a;
  protected NearbyPeopleCard a;
  protected Map<String, axzq> a;
  protected boolean a;
  protected Map<String, axzq> b = new HashMap();
  protected Map<String, axzq> c = new HashMap();
  
  public axxm(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private void g(axxt paramaxxt)
  {
    axzq localaxzq = paramaxxt.jdField_a_of_type_Axzq;
    bglp.a(this.jdField_a_of_type_AndroidContentContext, 230).setTitle(anni.a(2131699838)).setNegativeButton(2131690582, new axxs(this)).setPositiveButton(2131691320, new axxq(this, localaxzq, paramaxxt)).show();
  }
  
  private void h(axxt paramaxxt)
  {
    if (!bgnt.g(this.jdField_a_of_type_AndroidContentContext))
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, anni.a(2131699835), 0).a();
      return;
    }
    boolean bool = paramaxxt.jdField_a_of_type_Axzq.jdField_a_of_type_Boolean;
    String str = b(paramaxxt);
    Object localObject = (axyl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(263);
    if (!bool)
    {
      ((axyl)localObject).a(str);
      axlq localaxlq = new axlq().h("data_card");
      if (!bool) {
        break label157;
      }
      localObject = "feed_unlike";
      label89:
      localObject = localaxlq.i((String)localObject).d("2").a(a(paramaxxt)).b(str).c(String.valueOf(a(paramaxxt)));
      if (!this.jdField_a_of_type_Boolean) {
        break label163;
      }
    }
    label157:
    label163:
    for (paramaxxt = "1";; paramaxxt = "2")
    {
      ((axlq)localObject).e(paramaxxt).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      return;
      ((axyl)localObject).b(str);
      break;
      localObject = "feed_like";
      break label89;
    }
  }
  
  public abstract int a(axxt paramaxxt);
  
  public abstract View a(ViewGroup paramViewGroup, axxt paramaxxt);
  
  public View a(axzq paramaxzq, Context paramContext, View paramView)
  {
    Object localObject = (LinearLayout)paramView;
    paramView = (View)localObject;
    axxt localaxxt;
    if (localObject == null)
    {
      localObject = new LinearLayout(paramContext);
      ((LinearLayout)localObject).setLayoutParams(new AbsListView.LayoutParams(-1, -1));
      ((LinearLayout)localObject).setBackgroundColor(-1);
      ((LinearLayout)localObject).setOrientation(1);
      localaxxt = a();
      if (localaxxt == null) {
        paramaxzq = null;
      }
    }
    do
    {
      return paramaxzq;
      localaxxt.jdField_a_of_type_AndroidAppActivity = ((Activity)paramContext);
      localaxxt.jdField_a_of_type_AndroidViewView = ((View)localObject);
      paramView = LayoutInflater.from(paramContext).inflate(2131561308, (ViewGroup)localObject, false);
      LinearLayout.LayoutParams localLayoutParams1 = new LinearLayout.LayoutParams(-1, -2);
      localLayoutParams1.topMargin = zlx.a(paramContext, 20.0F);
      localLayoutParams1.leftMargin = zlx.a(paramContext, 16.0F);
      localLayoutParams1.bottomMargin = zlx.a(paramContext, 0.0F);
      localLayoutParams1.rightMargin = zlx.a(paramContext, 6.0F);
      localaxxt.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369142));
      localaxxt.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379779));
      localaxxt.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369189));
      View localView1 = LayoutInflater.from(paramContext).inflate(2131561304, (ViewGroup)localObject, false);
      LinearLayout.LayoutParams localLayoutParams2 = new LinearLayout.LayoutParams(-1, -2);
      localLayoutParams2.leftMargin = zlx.a(paramContext, 66.0F);
      localLayoutParams2.rightMargin = zlx.a(paramContext, 6.0F);
      localaxxt.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView1.findViewById(2131379757));
      localaxxt.jdField_c_of_type_AndroidWidgetTextView = ((TextView)localView1.findViewById(2131379654));
      localaxxt.jdField_c_of_type_AndroidViewView = localView1.findViewById(2131372813);
      localaxxt.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)localView1.findViewById(2131369227));
      localaxxt.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
      localaxxt.jdField_d_of_type_AndroidWidgetTextView = ((TextView)localView1.findViewById(2131379819));
      localaxxt.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)localView1.findViewById(2131369087));
      localaxxt.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(this);
      localaxxt.e = ((TextView)localView1.findViewById(2131379571));
      localaxxt.jdField_a_of_type_AndroidWidgetListView = ((ListView)localView1.findViewById(2131364818));
      localaxxt.jdField_a_of_type_Axxw = new axxw();
      localaxxt.jdField_a_of_type_Axxw.a(this);
      localaxxt.jdField_a_of_type_AndroidWidgetListView.setAdapter(localaxxt.jdField_a_of_type_Axxw);
      localaxxt.f = ((TextView)localView1.findViewById(2131381094));
      localaxxt.jdField_d_of_type_AndroidViewView = localView1.findViewById(2131364816);
      localaxxt.f.setOnClickListener(this);
      ((LinearLayout)localObject).addView(paramView, localLayoutParams1);
      View localView2 = a((ViewGroup)localObject, localaxxt);
      if (localView2 != null)
      {
        localLayoutParams1 = (LinearLayout.LayoutParams)localView2.getLayoutParams();
        paramView = localLayoutParams1;
        if (localLayoutParams1 == null) {
          paramView = new LinearLayout.LayoutParams(-1, -2);
        }
        paramView.leftMargin = zlx.a(paramContext, 66.0F);
        paramView.rightMargin = zlx.a(paramContext, 6.0F);
        paramView.topMargin = zlx.a(paramContext, -14.0F);
        ((LinearLayout)localObject).addView(localView2);
        localView2.setId(2131374265);
        localaxxt.jdField_b_of_type_AndroidViewView = localView2;
        localView2.setOnClickListener(this);
      }
      ((LinearLayout)localObject).addView(localView1, localLayoutParams2);
      ((LinearLayout)localObject).setTag(localaxxt);
      localaxxt.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
      paramView = new View(this.jdField_a_of_type_AndroidContentContext);
      paramView.setLayoutParams(new LinearLayout.LayoutParams(-1, zlx.a(this.jdField_a_of_type_AndroidContentContext, 10.0F)));
      paramView.setBackgroundColor(-460807);
      ((LinearLayout)localObject).addView(paramView);
      paramView = (View)localObject;
      localObject = (axxt)paramView.getTag();
      ((axxt)localObject).jdField_a_of_type_Axzq = paramaxzq;
      a((axxt)localObject);
      if ((!TextUtils.isEmpty(paramaxzq.k)) && (!paramaxzq.k.endsWith(anni.a(2131699839)))) {
        break;
      }
      ((axxt)localObject).jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(2130845523, 0, 0, 0);
      ((axxt)localObject).jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(null);
      ((axxt)localObject).jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#777777"));
      paramaxzq = paramView;
    } while (this.jdField_a_of_type_JavaUtilMap.get(((axxt)localObject).jdField_a_of_type_Axzq.c) != null);
    paramContext = new axlq().h("data_card").i("feed_exp").a(a((axxt)localObject)).d("2").b(((axxt)localObject).jdField_a_of_type_Axzq.c).c(String.valueOf(a((axxt)localObject)));
    if (this.jdField_a_of_type_Boolean) {}
    for (paramaxzq = "1";; paramaxzq = "2")
    {
      paramContext.e(paramaxzq).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_a_of_type_JavaUtilMap.put(((axxt)localObject).jdField_a_of_type_Axzq.c, ((axxt)localObject).jdField_a_of_type_Axzq);
      return paramView;
      ((axxt)localObject).jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(2130845525, 0, 0, 0);
      ((axxt)localObject).jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#576B95"));
      ((axxt)localObject).jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(new axxn(this, paramContext, paramaxzq, (axxt)localObject));
      break;
    }
  }
  
  public abstract axxt a();
  
  public String a(axxt paramaxxt)
  {
    return "";
  }
  
  public void a(View paramView)
  {
    paramView = (axxt)axze.a(paramView, axxt.class);
    if (paramView == null) {
      return;
    }
    c(paramView);
  }
  
  public void a(axxt paramaxxt)
  {
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = zlx.a(this.jdField_a_of_type_AndroidContentContext, 40.0F);
    ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = zlx.a(this.jdField_a_of_type_AndroidContentContext, 40.0F);
    ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130840266);
    try
    {
      localObject = URLDrawable.getDrawable(paramaxxt.jdField_a_of_type_Axzq.d, (URLDrawable.URLDrawableOptions)localObject);
      ((URLDrawable)localObject).setTag(bgey.a(zlx.a(this.jdField_a_of_type_AndroidContentContext, 40.0F), zlx.a(this.jdField_a_of_type_AndroidContentContext, 40.0F)));
      ((URLDrawable)localObject).setDecodeHandler(bgey.a);
      paramaxxt.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null) {
        paramaxxt.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nickname);
      }
      paramaxxt.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
      f(paramaxxt);
      if (!TextUtils.isEmpty(paramaxxt.jdField_a_of_type_Axzq.jdField_g_of_type_JavaLangString))
      {
        paramaxxt.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        paramaxxt.jdField_b_of_type_AndroidWidgetTextView.setText(paramaxxt.jdField_a_of_type_Axzq.jdField_g_of_type_JavaLangString);
        localObject = new StringBuilder();
        if (!TextUtils.isEmpty(paramaxxt.jdField_a_of_type_Axzq.jdField_f_of_type_JavaLangString))
        {
          if (((StringBuilder)localObject).length() > 0) {
            ((StringBuilder)localObject).append(" · ");
          }
          ((StringBuilder)localObject).append(paramaxxt.jdField_a_of_type_Axzq.jdField_f_of_type_JavaLangString);
        }
        if (((StringBuilder)localObject).length() <= 0) {
          break label695;
        }
        paramaxxt.jdField_c_of_type_AndroidWidgetTextView.setText(((StringBuilder)localObject).toString());
        paramaxxt.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        if (!a(paramaxxt)) {
          break label730;
        }
        paramaxxt.jdField_c_of_type_AndroidViewView.setVisibility(0);
        if (!paramaxxt.jdField_a_of_type_Axzq.jdField_a_of_type_Boolean) {
          break label707;
        }
        paramaxxt.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130845466);
        paramaxxt.jdField_d_of_type_AndroidWidgetTextView.setTextColor(-52924);
        paramaxxt.jdField_d_of_type_AndroidWidgetTextView.setText(String.valueOf(paramaxxt.jdField_a_of_type_Axzq.jdField_f_of_type_Int));
        paramaxxt.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
        paramaxxt.e.setText(String.valueOf(paramaxxt.jdField_a_of_type_Axzq.jdField_g_of_type_Int));
        List localList = paramaxxt.jdField_a_of_type_Axzq.jdField_a_of_type_JavaUtilList;
        if ((localList == null) || (localList.size() <= 0)) {
          break label748;
        }
        paramaxxt.jdField_a_of_type_AndroidWidgetListView.setVisibility(0);
        paramaxxt.jdField_a_of_type_Axxw.a(localList);
        paramaxxt.jdField_a_of_type_Axxw.notifyDataSetChanged();
        if (this.b.get(paramaxxt.jdField_a_of_type_Axzq.c) == null)
        {
          axlq localaxlq = new axlq().h("data_card").i("feed_com_exp").d("2").a(a(paramaxxt)).b(paramaxxt.jdField_a_of_type_Axzq.c).c(String.valueOf(a(paramaxxt)));
          if (!this.jdField_a_of_type_Boolean) {
            break label742;
          }
          localObject = "1";
          localaxlq.e((String)localObject).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          this.b.put(paramaxxt.jdField_a_of_type_Axzq.c, paramaxxt.jdField_a_of_type_Axzq);
        }
        if ((localList == null) || (localList.size() <= 0) || (paramaxxt.jdField_a_of_type_Axzq.jdField_g_of_type_Int <= localList.size())) {
          break label760;
        }
        paramaxxt.f.setVisibility(0);
        if ((paramaxxt.jdField_a_of_type_AndroidWidgetListView.getVisibility() == 0) || (paramaxxt.f.getVisibility() == 0)) {
          break label772;
        }
        paramaxxt.jdField_d_of_type_AndroidViewView.setVisibility(8);
        paramaxxt.jdField_b_of_type_AndroidWidgetImageView.setClickable(true);
        paramaxxt.jdField_b_of_type_AndroidWidgetImageView.setAlpha(1.0F);
        paramaxxt.jdField_c_of_type_AndroidWidgetImageView.setClickable(true);
        paramaxxt.jdField_d_of_type_AndroidWidgetImageView.setClickable(true);
        paramaxxt.jdField_c_of_type_AndroidWidgetImageView.setAlpha(1.0F);
        paramaxxt.jdField_d_of_type_AndroidWidgetTextView.setAlpha(1.0F);
        paramaxxt.jdField_d_of_type_AndroidWidgetImageView.setAlpha(1.0F);
        paramaxxt.e.setAlpha(1.0F);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        paramaxxt.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130840266));
        QLog.i("BaseMomentItemBuilder", 1, "updateUI, holder.momentFeedInfo.headUrl=" + paramaxxt.jdField_a_of_type_Axzq.d);
        continue;
        paramaxxt.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        continue;
        label695:
        paramaxxt.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
        continue;
        label707:
        paramaxxt.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130845484);
        paramaxxt.jdField_d_of_type_AndroidWidgetTextView.setTextColor(-4473925);
        continue;
        label730:
        paramaxxt.jdField_c_of_type_AndroidViewView.setVisibility(8);
        continue;
        label742:
        String str = "2";
        continue;
        label748:
        paramaxxt.jdField_a_of_type_AndroidWidgetListView.setVisibility(8);
        continue;
        label760:
        paramaxxt.f.setVisibility(8);
        continue;
        label772:
        paramaxxt.jdField_d_of_type_AndroidViewView.setVisibility(0);
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
  
  public boolean a(axxt paramaxxt)
  {
    return true;
  }
  
  public String b(axxt paramaxxt)
  {
    return paramaxxt.jdField_a_of_type_Axzq.c;
  }
  
  public void b(axxt paramaxxt)
  {
    axzq localaxzq = paramaxxt.jdField_a_of_type_Axzq;
    axlq localaxlq = new axlq().h("data_card").i("feed_more_clk").d("2").a(a(paramaxxt)).b(localaxzq.c).c(String.valueOf(a(paramaxxt)));
    if (this.jdField_a_of_type_Boolean) {}
    for (Object localObject = "1";; localObject = "2")
    {
      localaxlq.e((String)localObject).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (!TextUtils.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), localaxzq.e)) {
        break;
      }
      localObject = bkho.a(this.jdField_a_of_type_AndroidContentContext);
      ((bkho)localObject).a(2131691320, 1);
      ((bkho)localObject).c(2131690582);
      ((bkho)localObject).a(new axxo(this, paramaxxt, localaxzq, (bkho)localObject));
      ((bkho)localObject).show();
      return;
    }
    localObject = bkho.a(this.jdField_a_of_type_AndroidContentContext);
    ((bkho)localObject).a(2131716603, 1);
    ((bkho)localObject).c(2131690582);
    ((bkho)localObject).a(new axxp(this, paramaxxt, localaxzq, (bkho)localObject));
    ((bkho)localObject).show();
  }
  
  public void c(axxt paramaxxt)
  {
    if (!bgnt.g(this.jdField_a_of_type_AndroidContentContext))
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, anni.a(2131699833), 0).a();
      return;
    }
    a(paramaxxt.jdField_a_of_type_Axzq.m, true);
  }
  
  public void d(axxt paramaxxt)
  {
    String str = paramaxxt.jdField_a_of_type_Axzq.c;
    axlq localaxlq = new axlq().h("data_card").i("feed_clk").d("2").a(a(paramaxxt)).b(str).c(String.valueOf(a(paramaxxt)));
    if (this.jdField_a_of_type_Boolean) {}
    for (str = "1";; str = "2")
    {
      localaxlq.e(str).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (bgnt.g(this.jdField_a_of_type_AndroidContentContext)) {
        break;
      }
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, anni.a(2131699836), 0).a();
      return;
    }
    a(paramaxxt.jdField_a_of_type_Axzq.m, false);
  }
  
  public void e(axxt paramaxxt)
  {
    axzr localaxzr = (axzr)paramaxxt.jdField_a_of_type_Axzq;
    Object localObject = localaxzr.a;
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localObject);
    localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("feedId", localaxzr.c);
      ((JSONObject)localObject).put("tinyId", "");
      ((JSONObject)localObject).put("uin", localaxzr.e);
      ((JSONObject)localObject).put("reason", anni.a(2131699837));
      bfhe.a(paramaxxt.jdField_a_of_type_AndroidAppActivity, 0, localArrayList, null, null, false, false, "5", 100, null, null, ((JSONObject)localObject).toString());
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
  
  public abstract void f(axxt paramaxxt);
  
  public void onClick(View paramView)
  {
    axxt localaxxt = (axxt)axze.a(paramView, axxt.class);
    if (localaxxt == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      switch (paramView.getId())
      {
      default: 
        break;
      case 2131369087: 
        c(localaxxt);
        break;
      case 2131369189: 
        b(localaxxt);
        break;
      case 2131369227: 
        h(localaxxt);
        break;
      case 2131381094: 
        axlq localaxlq = new axlq().h("data_card").i("feed_com_clk").d("2").a(a(localaxxt)).b(localaxxt.jdField_a_of_type_Axzq.c).c(String.valueOf(a(localaxxt)));
        if (this.jdField_a_of_type_Boolean) {}
        for (String str = "1";; str = "2")
        {
          localaxlq.e(str).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          break;
        }
      case 2131374265: 
        d(localaxxt);
        break;
      case 2131369217: 
        e(localaxxt);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axxm
 * JD-Core Version:    0.7.0.1
 */