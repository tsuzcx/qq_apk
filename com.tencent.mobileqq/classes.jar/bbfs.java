import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.TextView;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.contacts.base.HeaderScrollView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.search.HotWordRecommendPagerModel.12;
import com.tencent.mobileqq.search.KDSearchHistoryFlowLayout;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.adapter.HotWordSearchPagerAdapter;
import com.tencent.mobileqq.search.model.HotWordSearchEntryDataModel;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.widget.ThemeImageView;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.List;

public class bbfs<T extends View>
  implements ajhu
{
  protected int a;
  protected Context a;
  private ViewPager jdField_a_of_type_AndroidSupportV4ViewViewPager;
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private anur jdField_a_of_type_Anur;
  private bbgo jdField_a_of_type_Bbgo;
  bbis jdField_a_of_type_Bbis;
  private HeaderScrollView jdField_a_of_type_ComTencentMobileqqActivityContactsBaseHeaderScrollView;
  protected QQAppInterface a;
  private KDSearchHistoryFlowLayout jdField_a_of_type_ComTencentMobileqqSearchKDSearchHistoryFlowLayout;
  private HotWordSearchPagerAdapter jdField_a_of_type_ComTencentMobileqqSearchAdapterHotWordSearchPagerAdapter;
  private HotWordSearchEntryDataModel jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel;
  private ThemeImageView jdField_a_of_type_ComTencentWidgetThemeImageView;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  private boolean jdField_a_of_type_Boolean;
  private View jdField_b_of_type_AndroidViewView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  bbis jdField_b_of_type_Bbis;
  private HotWordSearchEntryDataModel jdField_b_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel;
  private ThemeImageView jdField_b_of_type_ComTencentWidgetThemeImageView;
  private XListView jdField_b_of_type_ComTencentWidgetXListView;
  private boolean jdField_b_of_type_Boolean;
  private View c;
  private View d;
  private View e;
  private View f;
  private View g;
  private View h;
  
  public bbfs(int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  private void a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    paramQQAppInterface = this.jdField_a_of_type_AndroidContentContext.getString(2131717055);
    String str1 = this.jdField_a_of_type_AndroidContentContext.getString(2131690582);
    String str2 = this.jdField_a_of_type_AndroidContentContext.getString(2131717054);
    bglp.a(this.jdField_a_of_type_AndroidContentContext, 230, paramQQAppInterface, "", str1, str2, Color.parseColor("#cf6253"), new bbfu(this), new bbfv(this)).show();
  }
  
  private void g()
  {
    this.h.setOnClickListener(new bbfx(this));
    this.d.setOnClickListener(new bbfy(this));
    this.e.setOnClickListener(new bbfz(this));
    this.f.setOnClickListener(new bbga(this));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(new bbgb(this));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new bbgc(this));
    this.jdField_a_of_type_ComTencentWidgetThemeImageView.setOnClickListener(new bbgd(this));
  }
  
  private void h()
  {
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setVisibility(8);
    this.jdField_a_of_type_AndroidViewView.findViewById(2131380897).setVisibility(0);
    this.jdField_a_of_type_ComTencentWidgetThemeImageView.setImageResource(2130846024);
    ((UniteSearchActivity)this.jdField_a_of_type_AndroidContentContext).a(false);
  }
  
  private void i()
  {
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setVisibility(0);
    this.jdField_a_of_type_AndroidViewView.findViewById(2131380897).setVisibility(8);
    this.jdField_a_of_type_ComTencentWidgetThemeImageView.setImageResource(2130846025);
    ((UniteSearchActivity)this.jdField_a_of_type_AndroidContentContext).a(true);
  }
  
  public View a()
  {
    if (this.jdField_a_of_type_AndroidSupportV4ViewViewPager.getCurrentItem() == 0) {
      return this.jdField_b_of_type_ComTencentWidgetXListView;
    }
    return this.jdField_a_of_type_ComTencentWidgetXListView;
  }
  
  public View a(Context paramContext, QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(paramContext).inflate(2131561493, paramViewGroup, false);
    paramBundle = LayoutInflater.from(paramContext).inflate(2131561486, paramViewGroup, false);
    paramViewGroup = LayoutInflater.from(paramContext).inflate(2131561486, paramViewGroup, false);
    ((TextView)paramViewGroup.findViewById(2131377042)).setText(2131717136);
    this.jdField_a_of_type_ComTencentMobileqqSearchKDSearchHistoryFlowLayout = ((KDSearchHistoryFlowLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131366855));
    this.d = this.jdField_a_of_type_AndroidViewView.findViewById(2131365329);
    this.e = this.jdField_a_of_type_AndroidViewView.findViewById(2131367975);
    this.f = this.jdField_a_of_type_AndroidViewView.findViewById(2131367976);
    this.jdField_b_of_type_ComTencentWidgetThemeImageView = ((ThemeImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131367978));
    this.h = this.jdField_a_of_type_AndroidViewView.findViewById(2131367972);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131377040));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131377059));
    this.g = this.jdField_a_of_type_AndroidViewView.findViewById(2131377643);
    this.jdField_a_of_type_ComTencentWidgetThemeImageView = ((ThemeImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368103));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseHeaderScrollView = ((HeaderScrollView)this.jdField_a_of_type_AndroidViewView.findViewById(2131367926));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseHeaderScrollView.setCurrentScrollableContainer(this);
    Object localObject = Aladdin.getConfig(313);
    if ((localObject != null) && (((AladdinConfig)localObject).getBooleanFromString("SearchPage_HideButton", false))) {
      this.jdField_a_of_type_ComTencentWidgetThemeImageView.setVisibility(8);
    }
    this.jdField_a_of_type_Anur = ((anur)paramQQAppInterface.getManager(299));
    if ((this.jdField_a_of_type_Anur.a() != null) && (this.jdField_a_of_type_Anur.a().size() > 0))
    {
      this.jdField_a_of_type_AndroidViewView.findViewById(2131371234).setVisibility(0);
      localObject = this.jdField_a_of_type_ComTencentMobileqqSearchKDSearchHistoryFlowLayout;
      localObject.getClass();
      this.jdField_a_of_type_Bbgo = new bbgo((KDSearchHistoryFlowLayout)localObject, this.jdField_a_of_type_Anur.a(), paramContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_a_of_type_Bbgo.a(new bbft(this));
      this.jdField_a_of_type_ComTencentMobileqqSearchKDSearchHistoryFlowLayout.setAdapter(this.jdField_a_of_type_Bbgo, true);
      this.jdField_a_of_type_Bbgo.notifyDataSetChanged();
      this.jdField_a_of_type_AndroidSupportV4ViewViewPager = ((ViewPager)this.jdField_a_of_type_AndroidViewView.findViewById(2131380895));
      this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setOnPageChangeListener(new bbfw(this));
      this.jdField_b_of_type_AndroidViewView = LayoutInflater.from(paramContext).inflate(2131561492, null, false);
      this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)this.jdField_b_of_type_AndroidViewView.findViewById(2131368111));
      this.jdField_a_of_type_ComTencentWidgetXListView.addFooterView(paramBundle);
      g();
      this.c = LayoutInflater.from(paramContext).inflate(2131561492, null, false);
      this.jdField_b_of_type_ComTencentWidgetXListView = ((XListView)this.c.findViewById(2131368111));
      this.jdField_b_of_type_ComTencentWidgetXListView.addFooterView(paramViewGroup);
      e();
      b();
      if (!PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext()).getBoolean(paramQQAppInterface.getCurrentAccountUin() + "QQ_SEARCH_HIDE_HOTLIST", false)) {
        break label584;
      }
      h();
    }
    for (;;)
    {
      a();
      return this.jdField_a_of_type_AndroidViewView;
      this.jdField_a_of_type_AndroidViewView.findViewById(2131371234).setVisibility(8);
      break;
      label584:
      i();
    }
  }
  
  public void a()
  {
    ArrayList localArrayList = ((anur)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(299)).a();
    if (!localArrayList.isEmpty())
    {
      StringBuilder localStringBuilder = new StringBuilder("");
      int i = 0;
      if (i < localArrayList.size())
      {
        if (i != localArrayList.size() - 1) {
          localStringBuilder.append((String)localArrayList.get(i)).append("::");
        }
        for (;;)
        {
          i += 1;
          break;
          localStringBuilder.append((String)localArrayList.get(i));
        }
      }
      bbrf.a(null, new ReportModelDC02528().module("search_his").action("exp_search_his").ver2("kandian").ver4(localStringBuilder.toString()).ver7("{experiment_id:" + bbrf.b + "}"));
      new anxu(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "exp_search_his", "search_his", "kandian", "", localStringBuilder.toString(), "{experiment_id:" + bbrf.b + "}");
    }
  }
  
  public void a(int paramInt)
  {
    Object localObject = (ViewGroup.MarginLayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
    localObject = (ViewGroup.MarginLayoutParams)this.jdField_b_of_type_AndroidWidgetTextView.getLayoutParams();
    if (paramInt == 1)
    {
      localObject = ObjectAnimator.ofFloat(this.g, "translationX", new float[] { 0.0F, Utils.dp2px(86.0D) });
      ((ObjectAnimator)localObject).setDuration(300L);
      ((ObjectAnimator)localObject).start();
      localObject = ObjectAnimator.ofFloat(this.g, "scaleX", new float[] { 1.0F, 0.75F });
      ((ObjectAnimator)localObject).setDuration(300L);
      ((ObjectAnimator)localObject).start();
      return;
    }
    localObject = ObjectAnimator.ofFloat(this.g, "translationX", new float[] { Utils.dp2px(86.0D), 0.0F });
    ((ObjectAnimator)localObject).setDuration(300L);
    ((ObjectAnimator)localObject).start();
    localObject = ObjectAnimator.ofFloat(this.g, "scaleX", new float[] { 0.75F, 1.0F });
    ((ObjectAnimator)localObject).setDuration(300L);
    ((ObjectAnimator)localObject).start();
  }
  
  public void a(String paramString)
  {
    bbrf.a(null, new ReportModelDC02528().module("searchpage_tab").action("clk_tab").ver2("kandian").ver3("" + this.jdField_a_of_type_AndroidSupportV4ViewViewPager.getCurrentItem()).ver4(paramString).session_id(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()));
    new anxu(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "clk_tab", "searchpage_tab", "kandian", "", paramString, "");
  }
  
  public void b()
  {
    if (bkpg.a()) {
      this.jdField_a_of_type_AndroidViewView.findViewById(2131365606).setBackgroundColor(Color.parseColor("#040E1C"));
    }
    for (;;)
    {
      d();
      return;
      if (ThemeUtil.isDefaultTheme()) {
        this.jdField_a_of_type_AndroidViewView.findViewById(2131365606).setBackgroundColor(Color.parseColor("#eeeeee"));
      }
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_Bbis.a();
    if (bkpg.a())
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#8f8f8f"));
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#242424"));
      return;
    }
    if (ThemeUtil.isDefaultTheme())
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#8f8f8f"));
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#242424"));
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167080));
    this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167077));
  }
  
  public void d()
  {
    if (bkpg.a())
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#8f8f8f"));
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#242424"));
      return;
    }
    if (ThemeUtil.isDefaultTheme())
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#242424"));
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#8f8f8f"));
      return;
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167080));
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167077));
  }
  
  public void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel = new HotWordSearchEntryDataModel(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, this.jdField_a_of_type_Int, this.jdField_a_of_type_Boolean);
    this.jdField_b_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel = new HotWordSearchEntryDataModel(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 7, this.jdField_a_of_type_Int, this.jdField_a_of_type_Boolean);
    ThreadManager.post(new HotWordRecommendPagerModel.12(this), 5, null, true);
  }
  
  public void f()
  {
    this.jdField_a_of_type_Bbis = new bbis(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.c);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Bbis);
    this.jdField_a_of_type_Bbis.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Bbis.a(this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel);
    this.jdField_b_of_type_Bbis = new bbis(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.c);
    this.jdField_b_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_b_of_type_Bbis);
    this.jdField_b_of_type_Bbis.a(this.jdField_b_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(this.c);
    localArrayList.add(this.jdField_b_of_type_AndroidViewView);
    if (this.jdField_a_of_type_ComTencentMobileqqSearchAdapterHotWordSearchPagerAdapter == null) {
      this.jdField_a_of_type_ComTencentMobileqqSearchAdapterHotWordSearchPagerAdapter = new HotWordSearchPagerAdapter(localArrayList);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setAdapter(this.jdField_a_of_type_ComTencentMobileqqSearchAdapterHotWordSearchPagerAdapter);
      return;
      this.jdField_a_of_type_ComTencentMobileqqSearchAdapterHotWordSearchPagerAdapter.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbfs
 * JD-Core Version:    0.7.0.1
 */