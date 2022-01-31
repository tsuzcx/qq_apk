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

public abstract class asyn
  implements View.OnClickListener, asyz
{
  protected Context a;
  protected QQAppInterface a;
  protected NearbyPeopleCard a;
  protected Map<String, atar> a;
  protected boolean a;
  protected Map<String, atar> b = new HashMap();
  protected Map<String, atar> c = new HashMap();
  
  public asyn(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private void g(asyu paramasyu)
  {
    atar localatar = paramasyu.jdField_a_of_type_Atar;
    babr.a(this.jdField_a_of_type_AndroidContentContext, 230).setTitle(ajjy.a(2131635238)).setNegativeButton(2131625035, new asyt(this)).setPositiveButton(2131625931, new asyr(this, localatar, paramasyu)).show();
  }
  
  private void h(asyu paramasyu)
  {
    if (!badq.g(this.jdField_a_of_type_AndroidContentContext))
    {
      bbmy.a(this.jdField_a_of_type_AndroidContentContext, 1, ajjy.a(2131635235), 0).a();
      return;
    }
    boolean bool = paramasyu.jdField_a_of_type_Atar.jdField_a_of_type_Boolean;
    String str = b(paramasyu);
    Object localObject = (aszm)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(263);
    if (!bool)
    {
      ((aszm)localObject).a(str);
      asmr localasmr = new asmr().h("data_card");
      if (!bool) {
        break label157;
      }
      localObject = "feed_unlike";
      label89:
      localObject = localasmr.i((String)localObject).d("2").a(a(paramasyu)).b(str).c(String.valueOf(a(paramasyu)));
      if (!this.jdField_a_of_type_Boolean) {
        break label163;
      }
    }
    label157:
    label163:
    for (paramasyu = "1";; paramasyu = "2")
    {
      ((asmr)localObject).e(paramasyu).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      return;
      ((aszm)localObject).b(str);
      break;
      localObject = "feed_like";
      break label89;
    }
  }
  
  public abstract int a(asyu paramasyu);
  
  public abstract View a(ViewGroup paramViewGroup, asyu paramasyu);
  
  public View a(atar paramatar, Context paramContext, View paramView)
  {
    Object localObject = (LinearLayout)paramView;
    paramView = (View)localObject;
    asyu localasyu;
    if (localObject == null)
    {
      localObject = new LinearLayout(paramContext);
      ((LinearLayout)localObject).setLayoutParams(new AbsListView.LayoutParams(-1, -1));
      ((LinearLayout)localObject).setBackgroundColor(-1);
      ((LinearLayout)localObject).setOrientation(1);
      localasyu = a();
      if (localasyu == null) {
        paramatar = null;
      }
    }
    do
    {
      return paramatar;
      localasyu.jdField_a_of_type_AndroidAppActivity = ((Activity)paramContext);
      localasyu.jdField_a_of_type_AndroidViewView = ((View)localObject);
      paramView = LayoutInflater.from(paramContext).inflate(2131495319, (ViewGroup)localObject, false);
      LinearLayout.LayoutParams localLayoutParams1 = new LinearLayout.LayoutParams(-1, -2);
      localLayoutParams1.topMargin = vms.a(paramContext, 20.0F);
      localLayoutParams1.leftMargin = vms.a(paramContext, 16.0F);
      localLayoutParams1.bottomMargin = vms.a(paramContext, 0.0F);
      localLayoutParams1.rightMargin = vms.a(paramContext, 6.0F);
      localasyu.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131302950));
      localasyu.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131312436));
      localasyu.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131302990));
      View localView1 = LayoutInflater.from(paramContext).inflate(2131495315, (ViewGroup)localObject, false);
      LinearLayout.LayoutParams localLayoutParams2 = new LinearLayout.LayoutParams(-1, -2);
      localLayoutParams2.leftMargin = vms.a(paramContext, 66.0F);
      localLayoutParams2.rightMargin = vms.a(paramContext, 6.0F);
      localasyu.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView1.findViewById(2131312421));
      localasyu.jdField_c_of_type_AndroidWidgetTextView = ((TextView)localView1.findViewById(2131312340));
      localasyu.jdField_c_of_type_AndroidViewView = localView1.findViewById(2131306187);
      localasyu.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)localView1.findViewById(2131303009));
      localasyu.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
      localasyu.jdField_d_of_type_AndroidWidgetTextView = ((TextView)localView1.findViewById(2131312460));
      localasyu.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)localView1.findViewById(2131302913));
      localasyu.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(this);
      localasyu.e = ((TextView)localView1.findViewById(2131312276));
      localasyu.jdField_a_of_type_AndroidWidgetListView = ((ListView)localView1.findViewById(2131298965));
      localasyu.jdField_a_of_type_Asyx = new asyx();
      localasyu.jdField_a_of_type_Asyx.a(this);
      localasyu.jdField_a_of_type_AndroidWidgetListView.setAdapter(localasyu.jdField_a_of_type_Asyx);
      localasyu.f = ((TextView)localView1.findViewById(2131313518));
      localasyu.jdField_d_of_type_AndroidViewView = localView1.findViewById(2131298963);
      localasyu.f.setOnClickListener(this);
      ((LinearLayout)localObject).addView(paramView, localLayoutParams1);
      View localView2 = a((ViewGroup)localObject, localasyu);
      if (localView2 != null)
      {
        localLayoutParams1 = (LinearLayout.LayoutParams)localView2.getLayoutParams();
        paramView = localLayoutParams1;
        if (localLayoutParams1 == null) {
          paramView = new LinearLayout.LayoutParams(-1, -2);
        }
        paramView.leftMargin = vms.a(paramContext, 66.0F);
        paramView.rightMargin = vms.a(paramContext, 6.0F);
        paramView.topMargin = vms.a(paramContext, -14.0F);
        ((LinearLayout)localObject).addView(localView2);
        localView2.setId(2131307360);
        localasyu.jdField_b_of_type_AndroidViewView = localView2;
        localView2.setOnClickListener(this);
      }
      ((LinearLayout)localObject).addView(localView1, localLayoutParams2);
      ((LinearLayout)localObject).setTag(localasyu);
      localasyu.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
      paramView = new View(this.jdField_a_of_type_AndroidContentContext);
      paramView.setLayoutParams(new LinearLayout.LayoutParams(-1, vms.a(this.jdField_a_of_type_AndroidContentContext, 10.0F)));
      paramView.setBackgroundColor(-460807);
      ((LinearLayout)localObject).addView(paramView);
      paramView = (View)localObject;
      localObject = (asyu)paramView.getTag();
      ((asyu)localObject).jdField_a_of_type_Atar = paramatar;
      a((asyu)localObject);
      if ((!TextUtils.isEmpty(paramatar.k)) && (!paramatar.k.endsWith(ajjy.a(2131635239)))) {
        break;
      }
      ((asyu)localObject).jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(2130844609, 0, 0, 0);
      ((asyu)localObject).jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(null);
      ((asyu)localObject).jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#777777"));
      paramatar = paramView;
    } while (this.jdField_a_of_type_JavaUtilMap.get(((asyu)localObject).jdField_a_of_type_Atar.c) != null);
    paramContext = new asmr().h("data_card").i("feed_exp").a(a((asyu)localObject)).d("2").b(((asyu)localObject).jdField_a_of_type_Atar.c).c(String.valueOf(a((asyu)localObject)));
    if (this.jdField_a_of_type_Boolean) {}
    for (paramatar = "1";; paramatar = "2")
    {
      paramContext.e(paramatar).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_a_of_type_JavaUtilMap.put(((asyu)localObject).jdField_a_of_type_Atar.c, ((asyu)localObject).jdField_a_of_type_Atar);
      return paramView;
      ((asyu)localObject).jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(2130844611, 0, 0, 0);
      ((asyu)localObject).jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#576B95"));
      ((asyu)localObject).jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(new asyo(this, paramContext, paramatar, (asyu)localObject));
      break;
    }
  }
  
  public abstract asyu a();
  
  public String a(asyu paramasyu)
  {
    return "";
  }
  
  public void a(View paramView)
  {
    paramView = (asyu)ataf.a(paramView, asyu.class);
    if (paramView == null) {
      return;
    }
    c(paramView);
  }
  
  public void a(asyu paramasyu)
  {
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = vms.a(this.jdField_a_of_type_AndroidContentContext, 40.0F);
    ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = vms.a(this.jdField_a_of_type_AndroidContentContext, 40.0F);
    ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130839689);
    try
    {
      localObject = URLDrawable.getDrawable(paramasyu.jdField_a_of_type_Atar.d, (URLDrawable.URLDrawableOptions)localObject);
      ((URLDrawable)localObject).setTag(azue.a(vms.a(this.jdField_a_of_type_AndroidContentContext, 40.0F), vms.a(this.jdField_a_of_type_AndroidContentContext, 40.0F)));
      ((URLDrawable)localObject).setDecodeHandler(azue.a);
      paramasyu.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null) {
        paramasyu.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nickname);
      }
      paramasyu.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
      f(paramasyu);
      if (!TextUtils.isEmpty(paramasyu.jdField_a_of_type_Atar.jdField_g_of_type_JavaLangString))
      {
        paramasyu.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        paramasyu.jdField_b_of_type_AndroidWidgetTextView.setText(paramasyu.jdField_a_of_type_Atar.jdField_g_of_type_JavaLangString);
        localObject = new StringBuilder();
        if (!TextUtils.isEmpty(paramasyu.jdField_a_of_type_Atar.jdField_f_of_type_JavaLangString))
        {
          if (((StringBuilder)localObject).length() > 0) {
            ((StringBuilder)localObject).append(" · ");
          }
          ((StringBuilder)localObject).append(paramasyu.jdField_a_of_type_Atar.jdField_f_of_type_JavaLangString);
        }
        if (((StringBuilder)localObject).length() <= 0) {
          break label695;
        }
        paramasyu.jdField_c_of_type_AndroidWidgetTextView.setText(((StringBuilder)localObject).toString());
        paramasyu.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        if (!a(paramasyu)) {
          break label730;
        }
        paramasyu.jdField_c_of_type_AndroidViewView.setVisibility(0);
        if (!paramasyu.jdField_a_of_type_Atar.jdField_a_of_type_Boolean) {
          break label707;
        }
        paramasyu.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130844552);
        paramasyu.jdField_d_of_type_AndroidWidgetTextView.setTextColor(-52924);
        paramasyu.jdField_d_of_type_AndroidWidgetTextView.setText(String.valueOf(paramasyu.jdField_a_of_type_Atar.jdField_f_of_type_Int));
        paramasyu.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
        paramasyu.e.setText(String.valueOf(paramasyu.jdField_a_of_type_Atar.jdField_g_of_type_Int));
        List localList = paramasyu.jdField_a_of_type_Atar.jdField_a_of_type_JavaUtilList;
        if ((localList == null) || (localList.size() <= 0)) {
          break label748;
        }
        paramasyu.jdField_a_of_type_AndroidWidgetListView.setVisibility(0);
        paramasyu.jdField_a_of_type_Asyx.a(localList);
        paramasyu.jdField_a_of_type_Asyx.notifyDataSetChanged();
        if (this.b.get(paramasyu.jdField_a_of_type_Atar.c) == null)
        {
          asmr localasmr = new asmr().h("data_card").i("feed_com_exp").d("2").a(a(paramasyu)).b(paramasyu.jdField_a_of_type_Atar.c).c(String.valueOf(a(paramasyu)));
          if (!this.jdField_a_of_type_Boolean) {
            break label742;
          }
          localObject = "1";
          localasmr.e((String)localObject).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          this.b.put(paramasyu.jdField_a_of_type_Atar.c, paramasyu.jdField_a_of_type_Atar);
        }
        if ((localList == null) || (localList.size() <= 0) || (paramasyu.jdField_a_of_type_Atar.jdField_g_of_type_Int <= localList.size())) {
          break label760;
        }
        paramasyu.f.setVisibility(0);
        if ((paramasyu.jdField_a_of_type_AndroidWidgetListView.getVisibility() == 0) || (paramasyu.f.getVisibility() == 0)) {
          break label772;
        }
        paramasyu.jdField_d_of_type_AndroidViewView.setVisibility(8);
        paramasyu.jdField_b_of_type_AndroidWidgetImageView.setClickable(true);
        paramasyu.jdField_b_of_type_AndroidWidgetImageView.setAlpha(1.0F);
        paramasyu.jdField_c_of_type_AndroidWidgetImageView.setClickable(true);
        paramasyu.jdField_d_of_type_AndroidWidgetImageView.setClickable(true);
        paramasyu.jdField_c_of_type_AndroidWidgetImageView.setAlpha(1.0F);
        paramasyu.jdField_d_of_type_AndroidWidgetTextView.setAlpha(1.0F);
        paramasyu.jdField_d_of_type_AndroidWidgetImageView.setAlpha(1.0F);
        paramasyu.e.setAlpha(1.0F);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        paramasyu.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130839689));
        QLog.i("BaseMomentItemBuilder", 1, "updateUI, holder.momentFeedInfo.headUrl=" + paramasyu.jdField_a_of_type_Atar.d);
        continue;
        paramasyu.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        continue;
        label695:
        paramasyu.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
        continue;
        label707:
        paramasyu.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130844570);
        paramasyu.jdField_d_of_type_AndroidWidgetTextView.setTextColor(-4473925);
        continue;
        label730:
        paramasyu.jdField_c_of_type_AndroidViewView.setVisibility(8);
        continue;
        label742:
        String str = "2";
        continue;
        label748:
        paramasyu.jdField_a_of_type_AndroidWidgetListView.setVisibility(8);
        continue;
        label760:
        paramasyu.f.setVisibility(8);
        continue;
        label772:
        paramasyu.jdField_d_of_type_AndroidViewView.setVisibility(0);
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
  
  public boolean a(asyu paramasyu)
  {
    return true;
  }
  
  public String b(asyu paramasyu)
  {
    return paramasyu.jdField_a_of_type_Atar.c;
  }
  
  public void b(asyu paramasyu)
  {
    atar localatar = paramasyu.jdField_a_of_type_Atar;
    asmr localasmr = new asmr().h("data_card").i("feed_more_clk").d("2").a(a(paramasyu)).b(localatar.c).c(String.valueOf(a(paramasyu)));
    if (this.jdField_a_of_type_Boolean) {}
    for (Object localObject = "1";; localObject = "2")
    {
      localasmr.e((String)localObject).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (!TextUtils.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), localatar.e)) {
        break;
      }
      localObject = begr.a(this.jdField_a_of_type_AndroidContentContext);
      ((begr)localObject).a(2131625931, 1);
      ((begr)localObject).c(2131625035);
      ((begr)localObject).a(new asyp(this, paramasyu, localatar, (begr)localObject));
      ((begr)localObject).show();
      return;
    }
    localObject = begr.a(this.jdField_a_of_type_AndroidContentContext);
    ((begr)localObject).a(2131652233, 1);
    ((begr)localObject).c(2131625035);
    ((begr)localObject).a(new asyq(this, paramasyu, localatar, (begr)localObject));
    ((begr)localObject).show();
  }
  
  public void c(asyu paramasyu)
  {
    if (!badq.g(this.jdField_a_of_type_AndroidContentContext))
    {
      bbmy.a(this.jdField_a_of_type_AndroidContentContext, 1, ajjy.a(2131635233), 0).a();
      return;
    }
    a(paramasyu.jdField_a_of_type_Atar.m, true);
  }
  
  public void d(asyu paramasyu)
  {
    String str = paramasyu.jdField_a_of_type_Atar.c;
    asmr localasmr = new asmr().h("data_card").i("feed_clk").d("2").a(a(paramasyu)).b(str).c(String.valueOf(a(paramasyu)));
    if (this.jdField_a_of_type_Boolean) {}
    for (str = "1";; str = "2")
    {
      localasmr.e(str).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (badq.g(this.jdField_a_of_type_AndroidContentContext)) {
        break;
      }
      bbmy.a(this.jdField_a_of_type_AndroidContentContext, 1, ajjy.a(2131635236), 0).a();
      return;
    }
    a(paramasyu.jdField_a_of_type_Atar.m, false);
  }
  
  public void e(asyu paramasyu)
  {
    atas localatas = (atas)paramasyu.jdField_a_of_type_Atar;
    Object localObject = localatas.a;
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localObject);
    localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("feedId", localatas.c);
      ((JSONObject)localObject).put("tinyId", "");
      ((JSONObject)localObject).put("uin", localatas.e);
      ((JSONObject)localObject).put("reason", ajjy.a(2131635237));
      azcm.a(paramasyu.jdField_a_of_type_AndroidAppActivity, 0, localArrayList, null, null, false, false, "5", 100, null, null, ((JSONObject)localObject).toString());
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
  
  public abstract void f(asyu paramasyu);
  
  public void onClick(View paramView)
  {
    asyu localasyu = (asyu)ataf.a(paramView, asyu.class);
    if (localasyu == null) {
      return;
    }
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131302913: 
      c(localasyu);
      return;
    case 2131302990: 
      b(localasyu);
      return;
    case 2131303009: 
      h(localasyu);
      return;
    case 2131313518: 
      asmr localasmr = new asmr().h("data_card").i("feed_com_clk").d("2").a(a(localasyu)).b(localasyu.jdField_a_of_type_Atar.c).c(String.valueOf(a(localasyu)));
      if (this.jdField_a_of_type_Boolean) {}
      for (paramView = "1";; paramView = "2")
      {
        localasmr.e(paramView).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        break;
      }
    case 2131307360: 
      d(localasyu);
      return;
    }
    e(localasyu);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     asyn
 * JD-Core Version:    0.7.0.1
 */