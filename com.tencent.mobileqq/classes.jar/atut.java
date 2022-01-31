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

public abstract class atut
  implements View.OnClickListener, atvf
{
  protected Context a;
  protected QQAppInterface a;
  protected NearbyPeopleCard a;
  protected Map<String, atwx> a;
  protected boolean a;
  protected Map<String, atwx> b = new HashMap();
  protected Map<String, atwx> c = new HashMap();
  
  public atut(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private void g(atva paramatva)
  {
    atwx localatwx = paramatva.jdField_a_of_type_Atwx;
    bbdj.a(this.jdField_a_of_type_AndroidContentContext, 230).setTitle(ajya.a(2131701033)).setNegativeButton(2131690596, new atuz(this)).setPositiveButton(2131691507, new atux(this, localatwx, paramatva)).show();
  }
  
  private void h(atva paramatva)
  {
    if (!bbfj.g(this.jdField_a_of_type_AndroidContentContext))
    {
      bcql.a(this.jdField_a_of_type_AndroidContentContext, 1, ajya.a(2131701030), 0).a();
      return;
    }
    boolean bool = paramatva.jdField_a_of_type_Atwx.jdField_a_of_type_Boolean;
    String str = b(paramatva);
    Object localObject = (atvs)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(263);
    if (!bool)
    {
      ((atvs)localObject).a(str);
      atix localatix = new atix().h("data_card");
      if (!bool) {
        break label157;
      }
      localObject = "feed_unlike";
      label89:
      localObject = localatix.i((String)localObject).d("2").a(a(paramatva)).b(str).c(String.valueOf(a(paramatva)));
      if (!this.jdField_a_of_type_Boolean) {
        break label163;
      }
    }
    label157:
    label163:
    for (paramatva = "1";; paramatva = "2")
    {
      ((atix)localObject).e(paramatva).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      return;
      ((atvs)localObject).b(str);
      break;
      localObject = "feed_like";
      break label89;
    }
  }
  
  public abstract int a(atva paramatva);
  
  public abstract View a(ViewGroup paramViewGroup, atva paramatva);
  
  public View a(atwx paramatwx, Context paramContext, View paramView)
  {
    Object localObject = (LinearLayout)paramView;
    paramView = (View)localObject;
    atva localatva;
    if (localObject == null)
    {
      localObject = new LinearLayout(paramContext);
      ((LinearLayout)localObject).setLayoutParams(new AbsListView.LayoutParams(-1, -1));
      ((LinearLayout)localObject).setBackgroundColor(-1);
      ((LinearLayout)localObject).setOrientation(1);
      localatva = a();
      if (localatva == null) {
        paramatwx = null;
      }
    }
    do
    {
      return paramatwx;
      localatva.jdField_a_of_type_AndroidAppActivity = ((Activity)paramContext);
      localatva.jdField_a_of_type_AndroidViewView = ((View)localObject);
      paramView = LayoutInflater.from(paramContext).inflate(2131560896, (ViewGroup)localObject, false);
      LinearLayout.LayoutParams localLayoutParams1 = new LinearLayout.LayoutParams(-1, -2);
      localLayoutParams1.topMargin = vzl.a(paramContext, 20.0F);
      localLayoutParams1.leftMargin = vzl.a(paramContext, 16.0F);
      localLayoutParams1.bottomMargin = vzl.a(paramContext, 0.0F);
      localLayoutParams1.rightMargin = vzl.a(paramContext, 6.0F);
      localatva.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368582));
      localatva.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378265));
      localatva.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368623));
      View localView1 = LayoutInflater.from(paramContext).inflate(2131560892, (ViewGroup)localObject, false);
      LinearLayout.LayoutParams localLayoutParams2 = new LinearLayout.LayoutParams(-1, -2);
      localLayoutParams2.leftMargin = vzl.a(paramContext, 66.0F);
      localLayoutParams2.rightMargin = vzl.a(paramContext, 6.0F);
      localatva.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView1.findViewById(2131378251));
      localatva.jdField_c_of_type_AndroidWidgetTextView = ((TextView)localView1.findViewById(2131378169));
      localatva.jdField_c_of_type_AndroidViewView = localView1.findViewById(2131371884);
      localatva.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)localView1.findViewById(2131368642));
      localatva.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
      localatva.jdField_d_of_type_AndroidWidgetTextView = ((TextView)localView1.findViewById(2131378290));
      localatva.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)localView1.findViewById(2131368537));
      localatva.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(this);
      localatva.e = ((TextView)localView1.findViewById(2131378099));
      localatva.jdField_a_of_type_AndroidWidgetListView = ((ListView)localView1.findViewById(2131364524));
      localatva.jdField_a_of_type_Atvd = new atvd();
      localatva.jdField_a_of_type_Atvd.a(this);
      localatva.jdField_a_of_type_AndroidWidgetListView.setAdapter(localatva.jdField_a_of_type_Atvd);
      localatva.f = ((TextView)localView1.findViewById(2131379358));
      localatva.jdField_d_of_type_AndroidViewView = localView1.findViewById(2131364522);
      localatva.f.setOnClickListener(this);
      ((LinearLayout)localObject).addView(paramView, localLayoutParams1);
      View localView2 = a((ViewGroup)localObject, localatva);
      if (localView2 != null)
      {
        localLayoutParams1 = (LinearLayout.LayoutParams)localView2.getLayoutParams();
        paramView = localLayoutParams1;
        if (localLayoutParams1 == null) {
          paramView = new LinearLayout.LayoutParams(-1, -2);
        }
        paramView.leftMargin = vzl.a(paramContext, 66.0F);
        paramView.rightMargin = vzl.a(paramContext, 6.0F);
        paramView.topMargin = vzl.a(paramContext, -14.0F);
        ((LinearLayout)localObject).addView(localView2);
        localView2.setId(2131373072);
        localatva.jdField_b_of_type_AndroidViewView = localView2;
        localView2.setOnClickListener(this);
      }
      ((LinearLayout)localObject).addView(localView1, localLayoutParams2);
      ((LinearLayout)localObject).setTag(localatva);
      localatva.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
      paramView = new View(this.jdField_a_of_type_AndroidContentContext);
      paramView.setLayoutParams(new LinearLayout.LayoutParams(-1, vzl.a(this.jdField_a_of_type_AndroidContentContext, 10.0F)));
      paramView.setBackgroundColor(-460807);
      ((LinearLayout)localObject).addView(paramView);
      paramView = (View)localObject;
      localObject = (atva)paramView.getTag();
      ((atva)localObject).jdField_a_of_type_Atwx = paramatwx;
      a((atva)localObject);
      if ((!TextUtils.isEmpty(paramatwx.k)) && (!paramatwx.k.endsWith(ajya.a(2131701034)))) {
        break;
      }
      ((atva)localObject).jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(2130844691, 0, 0, 0);
      ((atva)localObject).jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(null);
      ((atva)localObject).jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#777777"));
      paramatwx = paramView;
    } while (this.jdField_a_of_type_JavaUtilMap.get(((atva)localObject).jdField_a_of_type_Atwx.c) != null);
    paramContext = new atix().h("data_card").i("feed_exp").a(a((atva)localObject)).d("2").b(((atva)localObject).jdField_a_of_type_Atwx.c).c(String.valueOf(a((atva)localObject)));
    if (this.jdField_a_of_type_Boolean) {}
    for (paramatwx = "1";; paramatwx = "2")
    {
      paramContext.e(paramatwx).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_a_of_type_JavaUtilMap.put(((atva)localObject).jdField_a_of_type_Atwx.c, ((atva)localObject).jdField_a_of_type_Atwx);
      return paramView;
      ((atva)localObject).jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(2130844693, 0, 0, 0);
      ((atva)localObject).jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#576B95"));
      ((atva)localObject).jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(new atuu(this, paramContext, paramatwx, (atva)localObject));
      break;
    }
  }
  
  public abstract atva a();
  
  public String a(atva paramatva)
  {
    return "";
  }
  
  public void a(View paramView)
  {
    paramView = (atva)atwl.a(paramView, atva.class);
    if (paramView == null) {
      return;
    }
    c(paramView);
  }
  
  public void a(atva paramatva)
  {
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = vzl.a(this.jdField_a_of_type_AndroidContentContext, 40.0F);
    ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = vzl.a(this.jdField_a_of_type_AndroidContentContext, 40.0F);
    ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130839738);
    try
    {
      localObject = URLDrawable.getDrawable(paramatva.jdField_a_of_type_Atwx.d, (URLDrawable.URLDrawableOptions)localObject);
      ((URLDrawable)localObject).setTag(bavw.a(vzl.a(this.jdField_a_of_type_AndroidContentContext, 40.0F), vzl.a(this.jdField_a_of_type_AndroidContentContext, 40.0F)));
      ((URLDrawable)localObject).setDecodeHandler(bavw.a);
      paramatva.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null) {
        paramatva.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nickname);
      }
      paramatva.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
      f(paramatva);
      if (!TextUtils.isEmpty(paramatva.jdField_a_of_type_Atwx.jdField_g_of_type_JavaLangString))
      {
        paramatva.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        paramatva.jdField_b_of_type_AndroidWidgetTextView.setText(paramatva.jdField_a_of_type_Atwx.jdField_g_of_type_JavaLangString);
        localObject = new StringBuilder();
        if (!TextUtils.isEmpty(paramatva.jdField_a_of_type_Atwx.jdField_f_of_type_JavaLangString))
        {
          if (((StringBuilder)localObject).length() > 0) {
            ((StringBuilder)localObject).append(" · ");
          }
          ((StringBuilder)localObject).append(paramatva.jdField_a_of_type_Atwx.jdField_f_of_type_JavaLangString);
        }
        if (((StringBuilder)localObject).length() <= 0) {
          break label695;
        }
        paramatva.jdField_c_of_type_AndroidWidgetTextView.setText(((StringBuilder)localObject).toString());
        paramatva.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        if (!a(paramatva)) {
          break label730;
        }
        paramatva.jdField_c_of_type_AndroidViewView.setVisibility(0);
        if (!paramatva.jdField_a_of_type_Atwx.jdField_a_of_type_Boolean) {
          break label707;
        }
        paramatva.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130844634);
        paramatva.jdField_d_of_type_AndroidWidgetTextView.setTextColor(-52924);
        paramatva.jdField_d_of_type_AndroidWidgetTextView.setText(String.valueOf(paramatva.jdField_a_of_type_Atwx.jdField_f_of_type_Int));
        paramatva.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
        paramatva.e.setText(String.valueOf(paramatva.jdField_a_of_type_Atwx.jdField_g_of_type_Int));
        List localList = paramatva.jdField_a_of_type_Atwx.jdField_a_of_type_JavaUtilList;
        if ((localList == null) || (localList.size() <= 0)) {
          break label748;
        }
        paramatva.jdField_a_of_type_AndroidWidgetListView.setVisibility(0);
        paramatva.jdField_a_of_type_Atvd.a(localList);
        paramatva.jdField_a_of_type_Atvd.notifyDataSetChanged();
        if (this.b.get(paramatva.jdField_a_of_type_Atwx.c) == null)
        {
          atix localatix = new atix().h("data_card").i("feed_com_exp").d("2").a(a(paramatva)).b(paramatva.jdField_a_of_type_Atwx.c).c(String.valueOf(a(paramatva)));
          if (!this.jdField_a_of_type_Boolean) {
            break label742;
          }
          localObject = "1";
          localatix.e((String)localObject).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          this.b.put(paramatva.jdField_a_of_type_Atwx.c, paramatva.jdField_a_of_type_Atwx);
        }
        if ((localList == null) || (localList.size() <= 0) || (paramatva.jdField_a_of_type_Atwx.jdField_g_of_type_Int <= localList.size())) {
          break label760;
        }
        paramatva.f.setVisibility(0);
        if ((paramatva.jdField_a_of_type_AndroidWidgetListView.getVisibility() == 0) || (paramatva.f.getVisibility() == 0)) {
          break label772;
        }
        paramatva.jdField_d_of_type_AndroidViewView.setVisibility(8);
        paramatva.jdField_b_of_type_AndroidWidgetImageView.setClickable(true);
        paramatva.jdField_b_of_type_AndroidWidgetImageView.setAlpha(1.0F);
        paramatva.jdField_c_of_type_AndroidWidgetImageView.setClickable(true);
        paramatva.jdField_d_of_type_AndroidWidgetImageView.setClickable(true);
        paramatva.jdField_c_of_type_AndroidWidgetImageView.setAlpha(1.0F);
        paramatva.jdField_d_of_type_AndroidWidgetTextView.setAlpha(1.0F);
        paramatva.jdField_d_of_type_AndroidWidgetImageView.setAlpha(1.0F);
        paramatva.e.setAlpha(1.0F);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        paramatva.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130839738));
        QLog.i("BaseMomentItemBuilder", 1, "updateUI, holder.momentFeedInfo.headUrl=" + paramatva.jdField_a_of_type_Atwx.d);
        continue;
        paramatva.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        continue;
        label695:
        paramatva.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
        continue;
        label707:
        paramatva.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130844652);
        paramatva.jdField_d_of_type_AndroidWidgetTextView.setTextColor(-4473925);
        continue;
        label730:
        paramatva.jdField_c_of_type_AndroidViewView.setVisibility(8);
        continue;
        label742:
        String str = "2";
        continue;
        label748:
        paramatva.jdField_a_of_type_AndroidWidgetListView.setVisibility(8);
        continue;
        label760:
        paramatva.f.setVisibility(8);
        continue;
        label772:
        paramatva.jdField_d_of_type_AndroidViewView.setVisibility(0);
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
  
  public boolean a(atva paramatva)
  {
    return true;
  }
  
  public String b(atva paramatva)
  {
    return paramatva.jdField_a_of_type_Atwx.c;
  }
  
  public void b(atva paramatva)
  {
    atwx localatwx = paramatva.jdField_a_of_type_Atwx;
    atix localatix = new atix().h("data_card").i("feed_more_clk").d("2").a(a(paramatva)).b(localatwx.c).c(String.valueOf(a(paramatva)));
    if (this.jdField_a_of_type_Boolean) {}
    for (Object localObject = "1";; localObject = "2")
    {
      localatix.e((String)localObject).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (!TextUtils.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), localatwx.e)) {
        break;
      }
      localObject = bfpc.a(this.jdField_a_of_type_AndroidContentContext);
      ((bfpc)localObject).a(2131691507, 1);
      ((bfpc)localObject).c(2131690596);
      ((bfpc)localObject).a(new atuv(this, paramatva, localatwx, (bfpc)localObject));
      ((bfpc)localObject).show();
      return;
    }
    localObject = bfpc.a(this.jdField_a_of_type_AndroidContentContext);
    ((bfpc)localObject).a(2131718060, 1);
    ((bfpc)localObject).c(2131690596);
    ((bfpc)localObject).a(new atuw(this, paramatva, localatwx, (bfpc)localObject));
    ((bfpc)localObject).show();
  }
  
  public void c(atva paramatva)
  {
    if (!bbfj.g(this.jdField_a_of_type_AndroidContentContext))
    {
      bcql.a(this.jdField_a_of_type_AndroidContentContext, 1, ajya.a(2131701028), 0).a();
      return;
    }
    a(paramatva.jdField_a_of_type_Atwx.m, true);
  }
  
  public void d(atva paramatva)
  {
    String str = paramatva.jdField_a_of_type_Atwx.c;
    atix localatix = new atix().h("data_card").i("feed_clk").d("2").a(a(paramatva)).b(str).c(String.valueOf(a(paramatva)));
    if (this.jdField_a_of_type_Boolean) {}
    for (str = "1";; str = "2")
    {
      localatix.e(str).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (bbfj.g(this.jdField_a_of_type_AndroidContentContext)) {
        break;
      }
      bcql.a(this.jdField_a_of_type_AndroidContentContext, 1, ajya.a(2131701031), 0).a();
      return;
    }
    a(paramatva.jdField_a_of_type_Atwx.m, false);
  }
  
  public void e(atva paramatva)
  {
    atwy localatwy = (atwy)paramatva.jdField_a_of_type_Atwx;
    Object localObject = localatwy.a;
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localObject);
    localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("feedId", localatwy.c);
      ((JSONObject)localObject).put("tinyId", "");
      ((JSONObject)localObject).put("uin", localatwy.e);
      ((JSONObject)localObject).put("reason", ajya.a(2131701032));
      badv.a(paramatva.jdField_a_of_type_AndroidAppActivity, 0, localArrayList, null, null, false, false, "5", 100, null, null, ((JSONObject)localObject).toString());
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
  
  public abstract void f(atva paramatva);
  
  public void onClick(View paramView)
  {
    atva localatva = (atva)atwl.a(paramView, atva.class);
    if (localatva == null) {
      return;
    }
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131368537: 
      c(localatva);
      return;
    case 2131368623: 
      b(localatva);
      return;
    case 2131368642: 
      h(localatva);
      return;
    case 2131379358: 
      atix localatix = new atix().h("data_card").i("feed_com_clk").d("2").a(a(localatva)).b(localatva.jdField_a_of_type_Atwx.c).c(String.valueOf(a(localatva)));
      if (this.jdField_a_of_type_Boolean) {}
      for (paramView = "1";; paramView = "2")
      {
        localatix.e(paramView).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        break;
      }
    case 2131373072: 
      d(localatva);
      return;
    }
    e(localatva);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atut
 * JD-Core Version:    0.7.0.1
 */