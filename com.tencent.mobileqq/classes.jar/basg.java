import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.widgets.HotWordTipsContainer;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener2;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.search.HotWordSearchEntryModel.4;
import com.tencent.mobileqq.search.HotWordSearchEntryModel.5;
import com.tencent.mobileqq.search.HotWordSearchEntryModel.7;
import com.tencent.mobileqq.search.fragment.SearchEntryFragment;
import com.tencent.mobileqq.search.model.HotWordSearchEntryDataModel;
import com.tencent.mobileqq.search.model.HotWordSearchEntryDataModel.GIFInfo;
import com.tencent.mobileqq.search.model.HotWordSearchEntryDataModel.HotSearchItem;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class basg
  extends barr
  implements View.OnClickListener
{
  protected static int b;
  aadx a;
  public Context a;
  public View a;
  protected RelativeLayout a;
  protected TextView a;
  protected HotWordTipsContainer a;
  public URLImageView a;
  protected QQAppInterface a;
  protected HotWordSearchEntryDataModel a;
  protected List<HotWordSearchEntryDataModel.HotSearchItem> a;
  protected View b;
  protected TextView b;
  protected URLImageView b;
  private boolean b;
  private int jdField_c_of_type_Int;
  protected View c;
  protected TextView c;
  private boolean jdField_c_of_type_Boolean;
  
  static
  {
    jdField_b_of_type_Int = -1;
  }
  
  public basg(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    super(paramInt2);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Aadx = new bash(this);
    this.jdField_c_of_type_Int = paramInt1;
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public static void a(Context paramContext, URLImageView paramURLImageView, String paramString1, String paramString2, basm parambasm)
  {
    if ((paramContext == null) || (paramURLImageView == null) || (TextUtils.isEmpty(paramString1))) {}
    for (;;)
    {
      return;
      paramURLImageView = new SoftReference(paramURLImageView);
      ColorDrawable localColorDrawable = new ColorDrawable();
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mLoadingDrawable = localColorDrawable;
      localURLDrawableOptions.mFailedDrawable = localColorDrawable;
      localURLDrawableOptions.mPlayGifImage = true;
      localURLDrawableOptions.mUseMemoryCache = false;
      if (ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime()))
      {
        if (!TextUtils.isEmpty(paramString2)) {
          localColorDrawable.setColor(paramContext.getResources().getColor(2131167308));
        }
      }
      else {
        for (paramContext = URLDrawable.getDrawable(paramString2, localURLDrawableOptions); paramContext != null; paramContext = URLDrawable.getDrawable(paramString1, localURLDrawableOptions))
        {
          paramURLImageView = new bask(paramURLImageView, paramContext, parambasm);
          paramContext.setURLDrawableListener(paramURLImageView);
          if (paramContext.getStatus() != 1) {
            break label166;
          }
          paramURLImageView.onLoadSuccessed(paramContext);
          return;
          localColorDrawable.setColor(paramContext.getResources().getColor(2131167307));
        }
      }
    }
    label166:
    ThreadManager.getFileThreadHandler().post(new HotWordSearchEntryModel.7(paramContext));
  }
  
  private void a(HotWordSearchEntryDataModel.GIFInfo paramGIFInfo)
  {
    if (paramGIFInfo == null) {
      return;
    }
    basj localbasj = new basj(this, paramGIFInfo);
    this.jdField_a_of_type_AndroidViewView.post(new HotWordSearchEntryModel.4(this, paramGIFInfo, localbasj));
    this.jdField_b_of_type_Boolean = true;
  }
  
  private void a(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      localbfvp = bfwg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramString1);
      if (localbfvp != null)
      {
        localbfvp.a();
        batb.jdField_a_of_type_Boolean = true;
      }
    }
    while (!QLog.isColorLevel())
    {
      do
      {
        bfvp localbfvp;
        return;
        if ((paramString1.startsWith("http://")) || (paramString1.startsWith("https://")))
        {
          bbgk.a(this.jdField_a_of_type_AndroidContentContext, paramString2, paramString1);
          batb.jdField_a_of_type_Boolean = true;
          return;
        }
      } while (!QLog.isColorLevel());
      QLog.d("Q.uniteSearch.HotWordSearchEntryModel", 2, "OnTipClickListener jumpUrl is illegal");
      return;
    }
    QLog.d("Q.uniteSearch.HotWordSearchEntryModel", 2, "OnTipClickListener jumpUrl is empty");
  }
  
  public static boolean a(HotWordSearchEntryDataModel.GIFInfo paramGIFInfo)
  {
    if ((paramGIFInfo == null) || (TextUtils.isEmpty(paramGIFInfo.hotSearchGifID)) || (TextUtils.isEmpty(paramGIFInfo.hotSearchGifUrl))) {}
    Object localObject;
    int i;
    do
    {
      do
      {
        return false;
        localObject = PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext());
      } while (TextUtils.equals(((SharedPreferences)localObject).getString("HotWordSearchEntryModel.psk_hot_search_last_show_id", ""), paramGIFInfo.hotSearchGifID));
      i = ((SharedPreferences)localObject).getInt("HotWordSearchEntryModel.psk_hot_search_try_time", 0);
      localObject = ((SharedPreferences)localObject).getString("HotWordSearchEntryModel.psk_hot_search_try_id", "");
    } while ((TextUtils.equals(paramGIFInfo.hotSearchGifID, (CharSequence)localObject)) && (i >= 2));
    return true;
  }
  
  public View a(Context paramContext, QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    paramBundle = paramQQAppInterface;
    if (paramQQAppInterface == null) {
      if (!(paramContext instanceof BaseActivity)) {
        break label283;
      }
    }
    label283:
    for (paramViewGroup = ((BaseActivity)paramContext).getAppRuntime();; paramViewGroup = null)
    {
      paramBundle = paramQQAppInterface;
      if ((paramViewGroup instanceof QQAppInterface)) {
        paramBundle = (QQAppInterface)paramViewGroup;
      }
      if (paramBundle == null) {
        return new View(paramContext);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBundle;
      this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(paramContext).inflate(2131560883, null);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131378714));
      this.jdField_b_of_type_ComTencentImageURLImageView = ((URLImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378756));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378800));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131371396));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131374143));
      this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentBizWidgetsHotWordTipsContainer = ((HotWordTipsContainer)this.jdField_a_of_type_AndroidViewView.findViewById(2131378669));
      this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131365676);
      this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131365677);
      this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368185));
      if (!this.jdField_a_of_type_Boolean) {
        this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentBizWidgetsHotWordTipsContainer.setOnTipsClickListener(this.jdField_a_of_type_Aadx);
        return this.jdField_a_of_type_AndroidViewView;
        this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      }
    }
  }
  
  public void a()
  {
    if (this.jdField_c_of_type_Int == 7) {}
    for (HotWordSearchEntryDataModel localHotWordSearchEntryDataModel = new HotWordSearchEntryDataModel(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 7, this.jdField_a_of_type_Int, this.jdField_c_of_type_Boolean);; localHotWordSearchEntryDataModel = new HotWordSearchEntryDataModel(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, this.jdField_a_of_type_Int, this.jdField_c_of_type_Boolean))
    {
      ThreadManager.post(new HotWordSearchEntryModel.5(this, localHotWordSearchEntryDataModel), 5, null, true);
      return;
    }
  }
  
  public void a(bayo parambayo)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel.jdField_c_of_type_Int == 1)
    {
      Object localObject = new ColorDrawable();
      if (ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime()))
      {
        ((ColorDrawable)localObject).setColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167308));
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject);
        localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject);
        localObject = "https://res.imtt.qq.com/res_mtt/KDhotword/xiaohuomiao.png";
        if (!TextUtils.isEmpty(parambayo.b)) {
          localObject = parambayo.b;
        }
        localObject = URLDrawable.getDrawable((String)localObject, localURLDrawableOptions);
        this.jdField_b_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
        if (TextUtils.isEmpty(parambayo.jdField_a_of_type_JavaLangString)) {
          break label216;
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setText(parambayo.jdField_a_of_type_JavaLangString);
        label115:
        if (TextUtils.isEmpty(parambayo.c)) {
          break label232;
        }
        this.jdField_b_of_type_AndroidWidgetTextView.setText(parambayo.c);
        label136:
        if ((parambayo.jdField_a_of_type_Int != 1) || (TextUtils.isEmpty(parambayo.e))) {
          break label244;
        }
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new basi(this, parambayo));
        this.jdField_c_of_type_AndroidViewView.setVisibility(8);
        return;
        ((ColorDrawable)localObject).setColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167307));
        break;
        label216:
        this.jdField_a_of_type_AndroidWidgetTextView.setText(amtj.a(2131704756));
        break label115;
        label232:
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        break label136;
        label244:
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      }
    }
    this.jdField_b_of_type_ComTencentImageURLImageView.setVisibility(8);
    if (!TextUtils.isEmpty(parambayo.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(parambayo.jdField_a_of_type_JavaLangString);
    }
    for (;;)
    {
      parambayo = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
      parambayo.leftMargin = 0;
      this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(parambayo);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      return;
      this.jdField_a_of_type_AndroidWidgetTextView.setText(pay.g(2131717485));
    }
  }
  
  public void a(bbaa parambbaa)
  {
    b(parambbaa);
  }
  
  public void b()
  {
    super.b();
  }
  
  public void b(bbaa parambbaa)
  {
    int i = 21;
    Object localObject1 = (HotWordSearchEntryDataModel)parambbaa;
    if ((localObject1 == null) || (((HotWordSearchEntryDataModel)localObject1).jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList == null) || (((HotWordSearchEntryDataModel)localObject1).jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() == 0))
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel = ((HotWordSearchEntryDataModel)localObject1);
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(((HotWordSearchEntryDataModel)localObject1).jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList);
    this.jdField_a_of_type_ComTencentBizWidgetsHotWordTipsContainer.a((HotWordSearchEntryDataModel)localObject1, this.jdField_a_of_type_Int);
    if (((HotWordSearchEntryDataModel)localObject1).jdField_a_of_type_Bayo == null) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    }
    Object localObject2;
    int k;
    for (;;)
    {
      if ((!this.jdField_b_of_type_Boolean) && (a(this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$GIFInfo)) && (this.jdField_a_of_type_Int == 10)) {
        a(this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$GIFInfo);
      }
      localObject2 = (Boolean)SearchEntryFragment.mIsModelsReported.get(Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel.jdField_c_of_type_Int));
      if ((localObject2 != null) && (((Boolean)localObject2).booleanValue())) {
        break;
      }
      localObject2 = new StringBuilder("");
      if ((((HotWordSearchEntryDataModel)localObject1).b() == null) || (((HotWordSearchEntryDataModel)localObject1).b().size() <= 0)) {
        break label323;
      }
      k = ((HotWordSearchEntryDataModel)localObject1).b().size();
      j = 0;
      while (j < k - 1)
      {
        ((StringBuilder)localObject2).append(((HotWordSearchEntryDataModel.HotSearchItem)((HotWordSearchEntryDataModel)localObject1).b().get(j)).title).append("::");
        j += 1;
      }
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      a(((HotWordSearchEntryDataModel)localObject1).jdField_a_of_type_Bayo);
    }
    ((StringBuilder)localObject2).append(((HotWordSearchEntryDataModel.HotSearchItem)((HotWordSearchEntryDataModel)localObject1).b().get(k - 1)).title);
    label323:
    bbgk.a("hot_list", "exp_hot_list", new String[] { ((StringBuilder)localObject2).toString(), String.valueOf(this.jdField_a_of_type_Int) });
    SearchEntryFragment.mIsModelsReported.put(Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel.jdField_c_of_type_Int), Boolean.valueOf(true));
    localObject1 = new StringBuilder();
    if (this.jdField_a_of_type_JavaUtilList.size() > 0)
    {
      j = 0;
      while (j < this.jdField_a_of_type_JavaUtilList.size() - 1)
      {
        ((StringBuilder)localObject1).append(((HotWordSearchEntryDataModel.HotSearchItem)this.jdField_a_of_type_JavaUtilList.get(j)).title).append("::");
        j += 1;
      }
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_JavaUtilList.size() - 1));
    }
    JSONObject localJSONObject = new JSONObject();
    QQAppInterface localQQAppInterface;
    andr localandr;
    String str;
    try
    {
      localJSONObject.put("project", bbda.a());
      localJSONObject.put("event_src", "client");
      localJSONObject.put("experiment_id", bbda.b);
      localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      localandr = new andr(localQQAppInterface);
      if (this.jdField_a_of_type_JavaUtilList.size() > 0)
      {
        localObject1 = ((HotWordSearchEntryDataModel.HotSearchItem)this.jdField_a_of_type_JavaUtilList.get(0)).sAppend;
        if (parambbaa.jdField_c_of_type_Int != 7) {
          break label782;
        }
        parambbaa = new ReportModelDC02528().module("recom_list").action("exp_recom_list");
        if (this.jdField_a_of_type_Int != 3) {
          break label766;
        }
        j = 21;
        bbda.a(null, parambbaa.ver2(bbda.a(j)).ver4(((StringBuilder)localObject2).toString()).ver7(localJSONObject.toString()).session_id(localQQAppInterface.getCurrentAccountUin() + this.jdField_a_of_type_Long));
        if (this.jdField_a_of_type_Int != 3) {
          break label774;
        }
        localandr.b(localQQAppInterface, "exp_recom_list", "recom_list", bbda.a(i), (String)localObject1, ((StringBuilder)localObject2).toString(), localJSONObject.toString());
        bbda.a(localQQAppInterface, 0, SearchEntryFragment.a(this.jdField_a_of_type_Int), "0X8009D27", 0, 0, null, null);
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QLog.e("Q.uniteSearch.HotWordSearchEntryModel", 2, "e = " + localJSONException);
        continue;
        str = "";
        continue;
        label766:
        j = this.jdField_a_of_type_Int;
        continue;
        label774:
        i = this.jdField_a_of_type_Int;
      }
      label782:
      parambbaa = new ReportModelDC02528().module("hot_list").action("exp_hot_list");
      if (this.jdField_a_of_type_Int != 3) {
        break label909;
      }
    }
    int j = 21;
    label813:
    bbda.a(null, parambbaa.ver2(bbda.a(j)).ver4(((StringBuilder)localObject2).toString()).ver7(localJSONObject.toString()).session_id(localQQAppInterface.getCurrentAccountUin() + this.jdField_a_of_type_Long));
    if (this.jdField_a_of_type_Int == 3) {}
    for (;;)
    {
      localandr.b(localQQAppInterface, "exp_hot_list", "hot_list", bbda.a(i), str, ((StringBuilder)localObject2).toString(), localJSONObject.toString());
      break;
      label909:
      j = this.jdField_a_of_type_Int;
      break label813;
      i = this.jdField_a_of_type_Int;
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentImageURLImageView.getVisibility() != 8)
    {
      this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(null);
      this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label81:
      JSONObject localJSONObject;
      if ((this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel != null) && (this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel.jdField_a_of_type_Bayo != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel.jdField_a_of_type_Bayo.e)))
      {
        a(this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel.jdField_a_of_type_Bayo.e, "");
        localJSONObject = new JSONObject();
      }
      try
      {
        localJSONObject.put("project", bbda.a());
        localJSONObject.put("event_src", "client");
        bbgk.a("hot_list", "clk_qq_index", new String[] { "", String.valueOf(this.jdField_a_of_type_Int) });
        ReportModelDC02528 localReportModelDC02528 = new ReportModelDC02528().module("hot_list").action("clk_qq_index");
        if (this.jdField_a_of_type_Int == 3)
        {
          i = 21;
          bbda.a(null, localReportModelDC02528.ver2(bbda.a(i)).ver7(localJSONObject.toString()).session_id(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + this.jdField_a_of_type_Long));
          bbda.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0, SearchEntryFragment.a(this.jdField_a_of_type_Int), "0X8009D28", 0, 0, null, null);
          continue;
          if (!QLog.isColorLevel()) {
            break label81;
          }
          QLog.d("Q.uniteSearch.HotWordSearchEntryModel", 2, "qq_index_text jumpUrl is illegal");
        }
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          QLog.e("Q.uniteSearch.HotWordSearchEntryModel", 2, "e = " + localJSONException);
          continue;
          int i = this.jdField_a_of_type_Int;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     basg
 * JD-Core Version:    0.7.0.1
 */