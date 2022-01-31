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

public abstract class avqc
  implements View.OnClickListener, avqo
{
  protected Context a;
  protected QQAppInterface a;
  protected NearbyPeopleCard a;
  protected Map<String, avsg> a;
  protected boolean a;
  protected Map<String, avsg> b = new HashMap();
  protected Map<String, avsg> c = new HashMap();
  
  public avqc(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private void g(avqj paramavqj)
  {
    avsg localavsg = paramavqj.jdField_a_of_type_Avsg;
    bdgm.a(this.jdField_a_of_type_AndroidContentContext, 230).setTitle(alud.a(2131701414)).setNegativeButton(2131690648, new avqi(this)).setPositiveButton(2131691562, new avqg(this, localavsg, paramavqj)).show();
  }
  
  private void h(avqj paramavqj)
  {
    if (!bdin.g(this.jdField_a_of_type_AndroidContentContext))
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, alud.a(2131701411), 0).a();
      return;
    }
    boolean bool = paramavqj.jdField_a_of_type_Avsg.jdField_a_of_type_Boolean;
    String str = b(paramavqj);
    Object localObject = (avrb)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(263);
    if (!bool)
    {
      ((avrb)localObject).a(str);
      aveg localaveg = new aveg().h("data_card");
      if (!bool) {
        break label157;
      }
      localObject = "feed_unlike";
      label89:
      localObject = localaveg.i((String)localObject).d("2").a(a(paramavqj)).b(str).c(String.valueOf(a(paramavqj)));
      if (!this.jdField_a_of_type_Boolean) {
        break label163;
      }
    }
    label157:
    label163:
    for (paramavqj = "1";; paramavqj = "2")
    {
      ((aveg)localObject).e(paramavqj).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      return;
      ((avrb)localObject).b(str);
      break;
      localObject = "feed_like";
      break label89;
    }
  }
  
  public abstract int a(avqj paramavqj);
  
  public abstract View a(ViewGroup paramViewGroup, avqj paramavqj);
  
  public View a(avsg paramavsg, Context paramContext, View paramView)
  {
    Object localObject = (LinearLayout)paramView;
    paramView = (View)localObject;
    avqj localavqj;
    if (localObject == null)
    {
      localObject = new LinearLayout(paramContext);
      ((LinearLayout)localObject).setLayoutParams(new AbsListView.LayoutParams(-1, -1));
      ((LinearLayout)localObject).setBackgroundColor(-1);
      ((LinearLayout)localObject).setOrientation(1);
      localavqj = a();
      if (localavqj == null) {
        paramavsg = null;
      }
    }
    do
    {
      return paramavsg;
      localavqj.jdField_a_of_type_AndroidAppActivity = ((Activity)paramContext);
      localavqj.jdField_a_of_type_AndroidViewView = ((View)localObject);
      paramView = LayoutInflater.from(paramContext).inflate(2131561097, (ViewGroup)localObject, false);
      LinearLayout.LayoutParams localLayoutParams1 = new LinearLayout.LayoutParams(-1, -2);
      localLayoutParams1.topMargin = xsm.a(paramContext, 20.0F);
      localLayoutParams1.leftMargin = xsm.a(paramContext, 16.0F);
      localLayoutParams1.bottomMargin = xsm.a(paramContext, 0.0F);
      localLayoutParams1.rightMargin = xsm.a(paramContext, 6.0F);
      localavqj.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368795));
      localavqj.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378896));
      localavqj.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368838));
      View localView1 = LayoutInflater.from(paramContext).inflate(2131561093, (ViewGroup)localObject, false);
      LinearLayout.LayoutParams localLayoutParams2 = new LinearLayout.LayoutParams(-1, -2);
      localLayoutParams2.leftMargin = xsm.a(paramContext, 66.0F);
      localLayoutParams2.rightMargin = xsm.a(paramContext, 6.0F);
      localavqj.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView1.findViewById(2131378875));
      localavqj.jdField_c_of_type_AndroidWidgetTextView = ((TextView)localView1.findViewById(2131378785));
      localavqj.jdField_c_of_type_AndroidViewView = localView1.findViewById(2131372222);
      localavqj.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)localView1.findViewById(2131368862));
      localavqj.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
      localavqj.jdField_d_of_type_AndroidWidgetTextView = ((TextView)localView1.findViewById(2131378927));
      localavqj.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)localView1.findViewById(2131368747));
      localavqj.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(this);
      localavqj.e = ((TextView)localView1.findViewById(2131378708));
      localavqj.jdField_a_of_type_AndroidWidgetListView = ((ListView)localView1.findViewById(2131364600));
      localavqj.jdField_a_of_type_Avqm = new avqm();
      localavqj.jdField_a_of_type_Avqm.a(this);
      localavqj.jdField_a_of_type_AndroidWidgetListView.setAdapter(localavqj.jdField_a_of_type_Avqm);
      localavqj.f = ((TextView)localView1.findViewById(2131380130));
      localavqj.jdField_d_of_type_AndroidViewView = localView1.findViewById(2131364598);
      localavqj.f.setOnClickListener(this);
      ((LinearLayout)localObject).addView(paramView, localLayoutParams1);
      View localView2 = a((ViewGroup)localObject, localavqj);
      if (localView2 != null)
      {
        localLayoutParams1 = (LinearLayout.LayoutParams)localView2.getLayoutParams();
        paramView = localLayoutParams1;
        if (localLayoutParams1 == null) {
          paramView = new LinearLayout.LayoutParams(-1, -2);
        }
        paramView.leftMargin = xsm.a(paramContext, 66.0F);
        paramView.rightMargin = xsm.a(paramContext, 6.0F);
        paramView.topMargin = xsm.a(paramContext, -14.0F);
        ((LinearLayout)localObject).addView(localView2);
        localView2.setId(2131373560);
        localavqj.jdField_b_of_type_AndroidViewView = localView2;
        localView2.setOnClickListener(this);
      }
      ((LinearLayout)localObject).addView(localView1, localLayoutParams2);
      ((LinearLayout)localObject).setTag(localavqj);
      localavqj.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
      paramView = new View(this.jdField_a_of_type_AndroidContentContext);
      paramView.setLayoutParams(new LinearLayout.LayoutParams(-1, xsm.a(this.jdField_a_of_type_AndroidContentContext, 10.0F)));
      paramView.setBackgroundColor(-460807);
      ((LinearLayout)localObject).addView(paramView);
      paramView = (View)localObject;
      localObject = (avqj)paramView.getTag();
      ((avqj)localObject).jdField_a_of_type_Avsg = paramavsg;
      a((avqj)localObject);
      if ((!TextUtils.isEmpty(paramavsg.k)) && (!paramavsg.k.endsWith(alud.a(2131701415)))) {
        break;
      }
      ((avqj)localObject).jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(2130845127, 0, 0, 0);
      ((avqj)localObject).jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(null);
      ((avqj)localObject).jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#777777"));
      paramavsg = paramView;
    } while (this.jdField_a_of_type_JavaUtilMap.get(((avqj)localObject).jdField_a_of_type_Avsg.c) != null);
    paramContext = new aveg().h("data_card").i("feed_exp").a(a((avqj)localObject)).d("2").b(((avqj)localObject).jdField_a_of_type_Avsg.c).c(String.valueOf(a((avqj)localObject)));
    if (this.jdField_a_of_type_Boolean) {}
    for (paramavsg = "1";; paramavsg = "2")
    {
      paramContext.e(paramavsg).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_a_of_type_JavaUtilMap.put(((avqj)localObject).jdField_a_of_type_Avsg.c, ((avqj)localObject).jdField_a_of_type_Avsg);
      return paramView;
      ((avqj)localObject).jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(2130845129, 0, 0, 0);
      ((avqj)localObject).jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#576B95"));
      ((avqj)localObject).jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(new avqd(this, paramContext, paramavsg, (avqj)localObject));
      break;
    }
  }
  
  public abstract avqj a();
  
  public String a(avqj paramavqj)
  {
    return "";
  }
  
  public void a(View paramView)
  {
    paramView = (avqj)avru.a(paramView, avqj.class);
    if (paramView == null) {
      return;
    }
    c(paramView);
  }
  
  public void a(avqj paramavqj)
  {
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = xsm.a(this.jdField_a_of_type_AndroidContentContext, 40.0F);
    ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = xsm.a(this.jdField_a_of_type_AndroidContentContext, 40.0F);
    ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130840087);
    try
    {
      localObject = URLDrawable.getDrawable(paramavqj.jdField_a_of_type_Avsg.d, (URLDrawable.URLDrawableOptions)localObject);
      ((URLDrawable)localObject).setTag(bcyz.a(xsm.a(this.jdField_a_of_type_AndroidContentContext, 40.0F), xsm.a(this.jdField_a_of_type_AndroidContentContext, 40.0F)));
      ((URLDrawable)localObject).setDecodeHandler(bcyz.a);
      paramavqj.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null) {
        paramavqj.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nickname);
      }
      paramavqj.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
      f(paramavqj);
      if (!TextUtils.isEmpty(paramavqj.jdField_a_of_type_Avsg.jdField_g_of_type_JavaLangString))
      {
        paramavqj.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        paramavqj.jdField_b_of_type_AndroidWidgetTextView.setText(paramavqj.jdField_a_of_type_Avsg.jdField_g_of_type_JavaLangString);
        localObject = new StringBuilder();
        if (!TextUtils.isEmpty(paramavqj.jdField_a_of_type_Avsg.jdField_f_of_type_JavaLangString))
        {
          if (((StringBuilder)localObject).length() > 0) {
            ((StringBuilder)localObject).append(" · ");
          }
          ((StringBuilder)localObject).append(paramavqj.jdField_a_of_type_Avsg.jdField_f_of_type_JavaLangString);
        }
        if (((StringBuilder)localObject).length() <= 0) {
          break label695;
        }
        paramavqj.jdField_c_of_type_AndroidWidgetTextView.setText(((StringBuilder)localObject).toString());
        paramavqj.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        if (!a(paramavqj)) {
          break label730;
        }
        paramavqj.jdField_c_of_type_AndroidViewView.setVisibility(0);
        if (!paramavqj.jdField_a_of_type_Avsg.jdField_a_of_type_Boolean) {
          break label707;
        }
        paramavqj.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130845070);
        paramavqj.jdField_d_of_type_AndroidWidgetTextView.setTextColor(-52924);
        paramavqj.jdField_d_of_type_AndroidWidgetTextView.setText(String.valueOf(paramavqj.jdField_a_of_type_Avsg.jdField_f_of_type_Int));
        paramavqj.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
        paramavqj.e.setText(String.valueOf(paramavqj.jdField_a_of_type_Avsg.jdField_g_of_type_Int));
        List localList = paramavqj.jdField_a_of_type_Avsg.jdField_a_of_type_JavaUtilList;
        if ((localList == null) || (localList.size() <= 0)) {
          break label748;
        }
        paramavqj.jdField_a_of_type_AndroidWidgetListView.setVisibility(0);
        paramavqj.jdField_a_of_type_Avqm.a(localList);
        paramavqj.jdField_a_of_type_Avqm.notifyDataSetChanged();
        if (this.b.get(paramavqj.jdField_a_of_type_Avsg.c) == null)
        {
          aveg localaveg = new aveg().h("data_card").i("feed_com_exp").d("2").a(a(paramavqj)).b(paramavqj.jdField_a_of_type_Avsg.c).c(String.valueOf(a(paramavqj)));
          if (!this.jdField_a_of_type_Boolean) {
            break label742;
          }
          localObject = "1";
          localaveg.e((String)localObject).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          this.b.put(paramavqj.jdField_a_of_type_Avsg.c, paramavqj.jdField_a_of_type_Avsg);
        }
        if ((localList == null) || (localList.size() <= 0) || (paramavqj.jdField_a_of_type_Avsg.jdField_g_of_type_Int <= localList.size())) {
          break label760;
        }
        paramavqj.f.setVisibility(0);
        if ((paramavqj.jdField_a_of_type_AndroidWidgetListView.getVisibility() == 0) || (paramavqj.f.getVisibility() == 0)) {
          break label772;
        }
        paramavqj.jdField_d_of_type_AndroidViewView.setVisibility(8);
        paramavqj.jdField_b_of_type_AndroidWidgetImageView.setClickable(true);
        paramavqj.jdField_b_of_type_AndroidWidgetImageView.setAlpha(1.0F);
        paramavqj.jdField_c_of_type_AndroidWidgetImageView.setClickable(true);
        paramavqj.jdField_d_of_type_AndroidWidgetImageView.setClickable(true);
        paramavqj.jdField_c_of_type_AndroidWidgetImageView.setAlpha(1.0F);
        paramavqj.jdField_d_of_type_AndroidWidgetTextView.setAlpha(1.0F);
        paramavqj.jdField_d_of_type_AndroidWidgetImageView.setAlpha(1.0F);
        paramavqj.e.setAlpha(1.0F);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        paramavqj.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130840087));
        QLog.i("BaseMomentItemBuilder", 1, "updateUI, holder.momentFeedInfo.headUrl=" + paramavqj.jdField_a_of_type_Avsg.d);
        continue;
        paramavqj.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        continue;
        label695:
        paramavqj.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
        continue;
        label707:
        paramavqj.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130845088);
        paramavqj.jdField_d_of_type_AndroidWidgetTextView.setTextColor(-4473925);
        continue;
        label730:
        paramavqj.jdField_c_of_type_AndroidViewView.setVisibility(8);
        continue;
        label742:
        String str = "2";
        continue;
        label748:
        paramavqj.jdField_a_of_type_AndroidWidgetListView.setVisibility(8);
        continue;
        label760:
        paramavqj.f.setVisibility(8);
        continue;
        label772:
        paramavqj.jdField_d_of_type_AndroidViewView.setVisibility(0);
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
  
  public boolean a(avqj paramavqj)
  {
    return true;
  }
  
  public String b(avqj paramavqj)
  {
    return paramavqj.jdField_a_of_type_Avsg.c;
  }
  
  public void b(avqj paramavqj)
  {
    avsg localavsg = paramavqj.jdField_a_of_type_Avsg;
    aveg localaveg = new aveg().h("data_card").i("feed_more_clk").d("2").a(a(paramavqj)).b(localavsg.c).c(String.valueOf(a(paramavqj)));
    if (this.jdField_a_of_type_Boolean) {}
    for (Object localObject = "1";; localObject = "2")
    {
      localaveg.e((String)localObject).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (!TextUtils.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), localavsg.e)) {
        break;
      }
      localObject = bhuf.a(this.jdField_a_of_type_AndroidContentContext);
      ((bhuf)localObject).a(2131691562, 1);
      ((bhuf)localObject).c(2131690648);
      ((bhuf)localObject).a(new avqe(this, paramavqj, localavsg, (bhuf)localObject));
      ((bhuf)localObject).show();
      return;
    }
    localObject = bhuf.a(this.jdField_a_of_type_AndroidContentContext);
    ((bhuf)localObject).a(2131718447, 1);
    ((bhuf)localObject).c(2131690648);
    ((bhuf)localObject).a(new avqf(this, paramavqj, localavsg, (bhuf)localObject));
    ((bhuf)localObject).show();
  }
  
  public void c(avqj paramavqj)
  {
    if (!bdin.g(this.jdField_a_of_type_AndroidContentContext))
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, alud.a(2131701409), 0).a();
      return;
    }
    a(paramavqj.jdField_a_of_type_Avsg.m, true);
  }
  
  public void d(avqj paramavqj)
  {
    String str = paramavqj.jdField_a_of_type_Avsg.c;
    aveg localaveg = new aveg().h("data_card").i("feed_clk").d("2").a(a(paramavqj)).b(str).c(String.valueOf(a(paramavqj)));
    if (this.jdField_a_of_type_Boolean) {}
    for (str = "1";; str = "2")
    {
      localaveg.e(str).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (bdin.g(this.jdField_a_of_type_AndroidContentContext)) {
        break;
      }
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, alud.a(2131701412), 0).a();
      return;
    }
    a(paramavqj.jdField_a_of_type_Avsg.m, false);
  }
  
  public void e(avqj paramavqj)
  {
    avsh localavsh = (avsh)paramavqj.jdField_a_of_type_Avsg;
    Object localObject = localavsh.a;
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localObject);
    localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("feedId", localavsh.c);
      ((JSONObject)localObject).put("tinyId", "");
      ((JSONObject)localObject).put("uin", localavsh.e);
      ((JSONObject)localObject).put("reason", alud.a(2131701413));
      bcgq.a(paramavqj.jdField_a_of_type_AndroidAppActivity, 0, localArrayList, null, null, false, false, "5", 100, null, null, ((JSONObject)localObject).toString());
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
  
  public abstract void f(avqj paramavqj);
  
  public void onClick(View paramView)
  {
    avqj localavqj = (avqj)avru.a(paramView, avqj.class);
    if (localavqj == null) {
      return;
    }
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131368747: 
      c(localavqj);
      return;
    case 2131368838: 
      b(localavqj);
      return;
    case 2131368862: 
      h(localavqj);
      return;
    case 2131380130: 
      aveg localaveg = new aveg().h("data_card").i("feed_com_clk").d("2").a(a(localavqj)).b(localavqj.jdField_a_of_type_Avsg.c).c(String.valueOf(a(localavqj)));
      if (this.jdField_a_of_type_Boolean) {}
      for (paramView = "1";; paramView = "2")
      {
        localaveg.e(paramView).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        break;
      }
    case 2131373560: 
      d(localavqj);
      return;
    }
    e(localavqj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avqc
 * JD-Core Version:    0.7.0.1
 */