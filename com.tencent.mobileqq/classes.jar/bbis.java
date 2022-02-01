import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.model.HotWordSearchEntryDataModel;
import com.tencent.mobileqq.search.model.HotWordSearchEntryDataModel.GIFInfo;
import com.tencent.mobileqq.search.model.HotWordSearchEntryDataModel.HotSearchItem;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.NotNull;

public class bbis
  extends BaseAdapter
{
  protected Context a;
  protected View a;
  protected anur a;
  protected QQAppInterface a;
  protected HotWordSearchEntryDataModel a;
  public List<HotWordSearchEntryDataModel.HotSearchItem> a;
  public Map<Integer, Boolean> a;
  public boolean a;
  
  public bbis(Context paramContext, QQAppInterface paramQQAppInterface, View paramView)
  {
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_Anur = ((anur)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(299));
  }
  
  @NotNull
  private View a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    b(paramInt);
    TextView localTextView;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561491, paramViewGroup, false);
      paramViewGroup = new bbit(this);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131368110));
      paramViewGroup.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131365606);
      paramViewGroup.jdField_a_of_type_AndroidViewView = paramView;
      paramView.setTag(paramViewGroup);
      paramViewGroup.jdField_a_of_type_Int = paramInt;
      if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > paramInt))
      {
        localObject = (HotWordSearchEntryDataModel.HotSearchItem)this.jdField_a_of_type_JavaUtilList.get(paramInt);
        localTextView = (TextView)paramView.findViewById(2131368109);
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(((HotWordSearchEntryDataModel.HotSearchItem)this.jdField_a_of_type_JavaUtilList.get(paramInt)).title);
        if ((((HotWordSearchEntryDataModel.HotSearchItem)localObject).tagInfo == null) || (((HotWordSearchEntryDataModel.HotSearchItem)localObject).tagInfo.isEmpty())) {
          break label386;
        }
        localTextView.setVisibility(0);
        ((GradientDrawable)localTextView.getBackground()).setColor(Color.parseColor(a(((HotWordSearchEntryDataModel.HotSearchItem)localObject).tagBGColor, "#00000000")));
        localTextView.setText(((HotWordSearchEntryDataModel.HotSearchItem)localObject).tagInfo);
        localTextView.setTextColor(Color.parseColor(a(((HotWordSearchEntryDataModel.HotSearchItem)localObject).tagColor, "#00000000")));
      }
      label219:
      Object localObject = (URLImageView)paramView.findViewById(2131363374);
      ((URLImageView)localObject).setVisibility(8);
      if ((UniteSearchActivity.a != null) && (TextUtils.equals(UniteSearchActivity.a.title, ((HotWordSearchEntryDataModel.HotSearchItem)this.jdField_a_of_type_JavaUtilList.get(paramInt)).title)) && (paramInt == 0) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel.a.hotWordGifUrl))) {
        bbge.a(this.jdField_a_of_type_AndroidContentContext, (URLImageView)localObject, this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel.a.hotWordGifUrl, this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel.a.hotWordGifUrlNight, null);
      }
      if (!ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null)) {
        break label396;
      }
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#ffa6a6a6"));
      paramViewGroup.jdField_b_of_type_AndroidViewView.setBackgroundColor(Color.parseColor("#040E1C"));
      paramViewGroup.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130839386);
    }
    for (;;)
    {
      paramView.setOnClickListener(paramViewGroup);
      return paramView;
      paramViewGroup = (bbit)paramView.getTag();
      break;
      label386:
      localTextView.setVisibility(8);
      break label219;
      label396:
      if (ThemeUtil.isDefaultTheme())
      {
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#242424"));
        paramViewGroup.jdField_b_of_type_AndroidViewView.setBackgroundColor(Color.parseColor("#E6E6E6"));
        paramViewGroup.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130839385);
      }
    }
  }
  
  private String a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {}
    do
    {
      return paramString2;
      try
      {
        Color.parseColor(paramString1);
        return paramString1;
      }
      catch (Exception paramString1) {}
    } while (!QLog.isColorLevel());
    QLog.d("Q.uniteSearch.HotWordAdapter", 2, "getValidColor " + paramString1);
    return paramString2;
  }
  
  @NotNull
  private View b(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    a(paramInt);
    Object localObject;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561487, paramViewGroup, false);
      paramViewGroup = new bbit(this);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378820));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setMaxWidth(bgtn.a() - bgtn.b(157.0F));
      paramViewGroup.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131365606);
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131377027));
      paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131368546));
      paramViewGroup.jdField_b_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131376543));
      paramViewGroup.jdField_a_of_type_AndroidViewView = paramView;
      paramView.setTag(paramViewGroup);
      paramViewGroup.jdField_a_of_type_Int = paramInt;
      if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > paramInt))
      {
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(((HotWordSearchEntryDataModel.HotSearchItem)this.jdField_a_of_type_JavaUtilList.get(paramInt)).title);
        paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText(((HotWordSearchEntryDataModel.HotSearchItem)this.jdField_a_of_type_JavaUtilList.get(paramInt)).countText);
        localObject = URLDrawable.getDrawable("https://search.imtt.qq.com/zhida/icon/hot_rank_index_" + (paramInt + 1) + ".png", URLDrawable.URLDrawableOptions.obtain());
        if (((URLDrawable)localObject).getStatus() != 1) {
          ((URLDrawable)localObject).startDownload();
        }
        paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
        if (TextUtils.isEmpty(((HotWordSearchEntryDataModel.HotSearchItem)this.jdField_a_of_type_JavaUtilList.get(paramInt)).badgeUrl)) {
          break label568;
        }
        localObject = new ColorDrawable();
        if (!ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime())) {
          break label547;
        }
        ((ColorDrawable)localObject).setColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167254));
        label318:
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject);
        localObject = URLDrawable.getDrawable(((HotWordSearchEntryDataModel.HotSearchItem)this.jdField_a_of_type_JavaUtilList.get(paramInt)).badgeUrl, localURLDrawableOptions);
        if (((URLDrawable)localObject).getStatus() != 1) {
          ((URLDrawable)localObject).startDownload();
        }
        paramViewGroup.jdField_b_of_type_ComTencentImageURLImageView.setVisibility(0);
        paramViewGroup.jdField_b_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
        label384:
        localObject = (URLImageView)paramView.findViewById(2131363374);
        ((URLImageView)localObject).setVisibility(8);
        if ((UniteSearchActivity.a != null) && (TextUtils.equals(UniteSearchActivity.a.title, ((HotWordSearchEntryDataModel.HotSearchItem)this.jdField_a_of_type_JavaUtilList.get(paramInt)).title)) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel.a.hotWordGifUrl))) {
          bbge.a(this.jdField_a_of_type_AndroidContentContext, (URLImageView)localObject, this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel.a.hotWordGifUrl, this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel.a.hotWordGifUrlNight, null);
        }
      }
      if (!ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null)) {
        break label580;
      }
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#ffa6a6a6"));
      paramViewGroup.jdField_b_of_type_AndroidViewView.setBackgroundColor(Color.parseColor("#040E1C"));
      paramViewGroup.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130839386);
    }
    for (;;)
    {
      paramView.setOnClickListener(paramViewGroup);
      return paramView;
      paramViewGroup = (bbit)paramView.getTag();
      break;
      label547:
      ((ColorDrawable)localObject).setColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167253));
      break label318;
      label568:
      paramViewGroup.jdField_b_of_type_ComTencentImageURLImageView.setVisibility(8);
      break label384;
      label580:
      if (ThemeUtil.isDefaultTheme())
      {
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#242424"));
        paramViewGroup.jdField_b_of_type_AndroidViewView.setBackgroundColor(Color.parseColor("#EEEEEE"));
        paramViewGroup.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130839385);
      }
    }
  }
  
  public HotWordSearchEntryDataModel.HotSearchItem a(int paramInt)
  {
    return (HotWordSearchEntryDataModel.HotSearchItem)this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public void a()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = true;
      a(this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel);
    }
  }
  
  public void a(int paramInt)
  {
    Object localObject = (Boolean)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt));
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > paramInt) && (this.jdField_a_of_type_Boolean) && ((localObject == null) || (!((Boolean)localObject).booleanValue())))
    {
      localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      anxu localanxu = new anxu((QQAppInterface)localObject);
      bbrf.a(null, new ReportModelDC02528().module("hot_list").action("exp_hot_list").ver2("kandian").ver4(((HotWordSearchEntryDataModel.HotSearchItem)this.jdField_a_of_type_JavaUtilList.get(paramInt)).title));
      localanxu.b((QQAppInterface)localObject, "exp_hot_list", "hot_list", "kandian", ((HotWordSearchEntryDataModel.HotSearchItem)this.jdField_a_of_type_JavaUtilList.get(paramInt)).sAppend, ((HotWordSearchEntryDataModel.HotSearchItem)this.jdField_a_of_type_JavaUtilList.get(paramInt)).title, "");
      this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(paramInt), Boolean.valueOf(true));
    }
  }
  
  public void a(HotWordSearchEntryDataModel paramHotWordSearchEntryDataModel)
  {
    this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel = paramHotWordSearchEntryDataModel;
    if ((paramHotWordSearchEntryDataModel == null) || (paramHotWordSearchEntryDataModel.b() == null) || (paramHotWordSearchEntryDataModel.b().size() == 0)) {
      return;
    }
    this.jdField_a_of_type_JavaUtilList = paramHotWordSearchEntryDataModel.b();
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    notifyDataSetChanged();
  }
  
  public void b(int paramInt)
  {
    Object localObject = (Boolean)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt));
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > paramInt) && ((localObject == null) || (!((Boolean)localObject).booleanValue())))
    {
      localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      anxu localanxu = new anxu((QQAppInterface)localObject);
      bbrf.a(null, new ReportModelDC02528().module("recom_list").action("exp_recom_list").ver2("kandian").ver4(((HotWordSearchEntryDataModel.HotSearchItem)this.jdField_a_of_type_JavaUtilList.get(paramInt)).title));
      localanxu.b((QQAppInterface)localObject, "exp_recom_list", "recom_list", "kandian", ((HotWordSearchEntryDataModel.HotSearchItem)this.jdField_a_of_type_JavaUtilList.get(paramInt)).sAppend, ((HotWordSearchEntryDataModel.HotSearchItem)this.jdField_a_of_type_JavaUtilList.get(paramInt)).title, "");
      this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(paramInt), Boolean.valueOf(true));
    }
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    switch (((HotWordSearchEntryDataModel.HotSearchItem)this.jdField_a_of_type_JavaUtilList.get(paramInt)).type)
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
      paramView = b(paramInt, paramView, paramViewGroup);
      continue;
      paramView = a(paramInt, paramView, paramViewGroup);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbis
 * JD-Core Version:    0.7.0.1
 */