import android.content.Context;
import android.content.Intent;
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
import android.widget.TextView;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
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
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class awhv
  extends awhg
  implements View.OnClickListener
{
  protected static int b;
  public Context a;
  public View a;
  protected RelativeLayout a;
  protected TextView a;
  protected HotWordTipsContainer a;
  public URLImageView a;
  protected QQAppInterface a;
  protected HotWordSearchEntryDataModel a;
  protected List<HotWordSearchEntryDataModel.HotSearchItem> a;
  xnl a;
  public boolean a;
  protected View b;
  protected TextView b;
  protected URLImageView b;
  private boolean b;
  protected View c;
  protected TextView c;
  private boolean c;
  
  static
  {
    jdField_b_of_type_Int = -1;
  }
  
  public awhv(int paramInt, boolean paramBoolean)
  {
    super(paramInt);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Xnl = new awhw(this);
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public static void a(Context paramContext, URLImageView paramURLImageView, String paramString1, String paramString2, awib paramawib)
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
      if (ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime())) {
        localColorDrawable.setColor(paramContext.getResources().getColor(2131167111));
      }
      for (paramContext = URLDrawable.getDrawable(paramString2, localURLDrawableOptions); paramContext != null; paramContext = URLDrawable.getDrawable(paramString1, localURLDrawableOptions))
      {
        paramURLImageView = new awhz(paramURLImageView, paramContext, paramawib);
        paramContext.setURLDrawableListener(paramURLImageView);
        if (paramContext.getStatus() != 1) {
          break label159;
        }
        paramURLImageView.onLoadSuccessed(paramContext);
        return;
        localColorDrawable.setColor(paramContext.getResources().getColor(2131167110));
      }
    }
    label159:
    ThreadManager.getFileThreadHandler().post(new HotWordSearchEntryModel.7(paramContext));
  }
  
  private void a(HotWordSearchEntryDataModel.GIFInfo paramGIFInfo)
  {
    if (paramGIFInfo == null) {
      return;
    }
    awhy localawhy = new awhy(this, paramGIFInfo);
    this.jdField_a_of_type_AndroidViewView.post(new HotWordSearchEntryModel.4(this, paramGIFInfo, localawhy));
    this.jdField_b_of_type_Boolean = true;
  }
  
  private void a(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      localObject = bbej.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramString1);
      if (localObject != null)
      {
        ((bbds)localObject).c();
        awiu.jdField_a_of_type_Boolean = true;
      }
    }
    while (!QLog.isColorLevel())
    {
      do
      {
        Object localObject;
        return;
        if ((paramString1.startsWith("http://")) || (paramString1.startsWith("https://")))
        {
          localObject = new Intent(this.jdField_a_of_type_AndroidContentContext, PublicAccountBrowser.class);
          ((Intent)localObject).putExtra("url", paramString1);
          ((Intent)localObject).putExtra("search_title", paramString2);
          this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject);
          awiu.jdField_a_of_type_Boolean = true;
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
      this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(paramContext).inflate(2131560586, null);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131377358));
      this.jdField_b_of_type_ComTencentImageURLImageView = ((URLImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131377394));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131377435));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370438));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131373042));
      this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentBizWidgetsHotWordTipsContainer = ((HotWordTipsContainer)this.jdField_a_of_type_AndroidViewView.findViewById(2131377315));
      this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131365277);
      this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131365278);
      this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131367631));
      if (!this.jdField_a_of_type_Boolean) {
        this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentBizWidgetsHotWordTipsContainer.setOnTipsClickListener(this.jdField_a_of_type_Xnl);
        return this.jdField_a_of_type_AndroidViewView;
        this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      }
    }
  }
  
  public void a()
  {
    ThreadManager.post(new HotWordSearchEntryModel.5(this, new HotWordSearchEntryDataModel(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, this.jdField_a_of_type_Int, this.jdField_c_of_type_Boolean)), 5, null, true);
  }
  
  public void a(awob paramawob)
  {
    Object localObject = new ColorDrawable();
    URLDrawable.URLDrawableOptions localURLDrawableOptions;
    if (ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime()))
    {
      ((ColorDrawable)localObject).setColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167111));
      localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject);
      localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject);
      localObject = "http://res.imtt.qq.com/res_mtt/KDhotword/xiaohuomiao.png";
      if (!TextUtils.isEmpty(paramawob.b)) {
        localObject = paramawob.b;
      }
      if (!ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime())) {
        break label208;
      }
      localObject = URLDrawable.getDrawable((String)localObject, localURLDrawableOptions);
      label87:
      this.jdField_b_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
      if (TextUtils.isEmpty(paramawob.jdField_a_of_type_JavaLangString)) {
        break label217;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramawob.jdField_a_of_type_JavaLangString);
      label116:
      if (TextUtils.isEmpty(paramawob.c)) {
        break label233;
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setText(paramawob.c);
      label137:
      if ((paramawob.jdField_a_of_type_Int != 1) || (TextUtils.isEmpty(paramawob.e))) {
        break label245;
      }
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new awhx(this, paramawob));
      return;
      ((ColorDrawable)localObject).setColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167110));
      break;
      label208:
      localObject = URLDrawable.getDrawable((String)localObject, localURLDrawableOptions);
      break label87;
      label217:
      this.jdField_a_of_type_AndroidWidgetTextView.setText(ajyc.a(2131705623));
      break label116;
      label233:
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      break label137;
      label245:
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
  
  public void a(awpn paramawpn)
  {
    b(paramawpn);
  }
  
  public void b()
  {
    super.b();
  }
  
  public void b(awpn paramawpn)
  {
    Object localObject = (HotWordSearchEntryDataModel)paramawpn;
    if ((localObject == null) || (((HotWordSearchEntryDataModel)localObject).jdField_a_of_type_JavaUtilList == null) || (((HotWordSearchEntryDataModel)localObject).jdField_a_of_type_JavaUtilList.size() == 0))
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel = ((HotWordSearchEntryDataModel)localObject);
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(((HotWordSearchEntryDataModel)localObject).jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_ComTencentBizWidgetsHotWordTipsContainer.a((HotWordSearchEntryDataModel)localObject, this.jdField_a_of_type_Int);
    if (((HotWordSearchEntryDataModel)localObject).jdField_a_of_type_Awob == null) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    }
    int j;
    int i;
    for (;;)
    {
      if ((!this.jdField_b_of_type_Boolean) && (a(this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$GIFInfo)) && (this.jdField_a_of_type_Int == 10)) {
        a(this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$GIFInfo);
      }
      paramawpn = (Boolean)SearchEntryFragment.a.get(Integer.valueOf(1));
      if ((paramawpn != null) && (paramawpn.booleanValue())) {
        break;
      }
      paramawpn = new StringBuilder("");
      if (((HotWordSearchEntryDataModel)localObject).jdField_a_of_type_JavaUtilList.size() <= 0) {
        break label300;
      }
      j = ((HotWordSearchEntryDataModel)localObject).jdField_a_of_type_JavaUtilList.size();
      i = 0;
      while (i < j - 1)
      {
        paramawpn.append(((HotWordSearchEntryDataModel.HotSearchItem)((HotWordSearchEntryDataModel)localObject).jdField_a_of_type_JavaUtilList.get(i)).title).append("::");
        i += 1;
      }
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      a(((HotWordSearchEntryDataModel)localObject).jdField_a_of_type_Awob);
    }
    paramawpn.append(((HotWordSearchEntryDataModel.HotSearchItem)((HotWordSearchEntryDataModel)localObject).jdField_a_of_type_JavaUtilList.get(j - 1)).title);
    label300:
    awvy.a("hot_list", "exp_hot_list", new String[] { paramawpn.toString(), String.valueOf(this.jdField_a_of_type_Int) });
    SearchEntryFragment.a.put(Integer.valueOf(1), Boolean.valueOf(true));
    localObject = new StringBuilder();
    if (this.jdField_a_of_type_JavaUtilList.size() > 0)
    {
      i = 0;
      while (i < this.jdField_a_of_type_JavaUtilList.size() - 1)
      {
        ((StringBuilder)localObject).append(((HotWordSearchEntryDataModel.HotSearchItem)this.jdField_a_of_type_JavaUtilList.get(i)).title).append("::");
        i += 1;
      }
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_JavaUtilList.size() - 1));
    }
    localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("project", awso.a());
      ((JSONObject)localObject).put("event_src", "client");
      ((JSONObject)localObject).put("experiment_id", awso.b);
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      ReportModelDC02528 localReportModelDC02528 = new ReportModelDC02528().module("hot_list").action("exp_hot_list");
      if (this.jdField_a_of_type_Int == 3)
      {
        i = 21;
        awso.a(null, localReportModelDC02528.ver2(awso.a(i)).ver4(paramawpn.toString()).ver7(((JSONObject)localObject).toString()).session_id(localQQAppInterface.getCurrentAccountUin() + this.jdField_a_of_type_Long));
        awso.a(localQQAppInterface, 0, SearchEntryFragment.a(this.jdField_a_of_type_Int), "0X8009D27", 0, 0, null, null);
        return;
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QLog.e("Q.uniteSearch.HotWordSearchEntryModel", 2, "e = " + localJSONException);
        continue;
        i = this.jdField_a_of_type_Int;
      }
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
    default: 
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel != null) && (this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel.jdField_a_of_type_Awob != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel.jdField_a_of_type_Awob.e))) {
      a(this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel.jdField_a_of_type_Awob.e, "");
    }
    for (;;)
    {
      paramView = new JSONObject();
      try
      {
        paramView.put("project", awso.a());
        paramView.put("event_src", "client");
        awvy.a("hot_list", "clk_qq_index", new String[] { "", String.valueOf(this.jdField_a_of_type_Int) });
        ReportModelDC02528 localReportModelDC02528 = new ReportModelDC02528().module("hot_list").action("clk_qq_index");
        if (this.jdField_a_of_type_Int == 3)
        {
          i = 21;
          awso.a(null, localReportModelDC02528.ver2(awso.a(i)).ver7(paramView.toString()).session_id(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + this.jdField_a_of_type_Long));
          awso.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0, SearchEntryFragment.a(this.jdField_a_of_type_Int), "0X8009D28", 0, 0, null, null);
          return;
          if (!QLog.isColorLevel()) {
            continue;
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
 * Qualified Name:     awhv
 * JD-Core Version:    0.7.0.1
 */