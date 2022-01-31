import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.search.HotWordSearchSpecialEntryModel.2;
import com.tencent.mobileqq.search.fragment.SearchEntryFragment;
import com.tencent.mobileqq.search.model.HotWordSearchSpecialDataModel;
import com.tencent.mobileqq.search.model.HotWordSearchSpecialDataModel.SpecialTopic;
import com.tencent.mobileqq.search.model.HotWordSearchSpecialDataModel.TopicImage;
import com.tencent.mobileqq.search.model.HotWordSearchSpecialDataModel.TopicItem;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.SquareImageView;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class awic
  extends awhg
  implements View.OnClickListener, AdapterView.OnItemClickListener
{
  protected static int b;
  protected Context a;
  protected View a;
  protected GridView a;
  protected LinearLayout a;
  protected RelativeLayout a;
  protected TextView a;
  protected awie a;
  protected URLImageView a;
  protected QQAppInterface a;
  protected HotWordSearchSpecialDataModel a;
  private boolean a;
  protected View b;
  protected TextView b;
  protected URLImageView b;
  
  static
  {
    jdField_b_of_type_Int = -1;
  }
  
  public awic(int paramInt, boolean paramBoolean)
  {
    super(paramInt);
    this.jdField_a_of_type_Boolean = paramBoolean;
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
    QLog.d("Q.uniteSearch.HotWordSearchSpecialEntryModel", 2, "getValidColor " + paramString1);
    return paramString2;
  }
  
  private void a(boolean paramBoolean, String paramString)
  {
    int i;
    String str5;
    if (this.jdField_a_of_type_Int == 3)
    {
      i = 21;
      str5 = awso.a(i);
      if ((this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchSpecialDataModel == null) || (this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchSpecialDataModel.a == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchSpecialDataModel.a.title))) {
        break label339;
      }
    }
    label339:
    for (String str1 = this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchSpecialDataModel.a.title;; str1 = "")
    {
      if (!TextUtils.isEmpty(paramString)) {}
      for (String str2 = "hotword";; str2 = "title")
      {
        String str3;
        label83:
        JSONObject localJSONObject;
        String str4;
        if (!TextUtils.isEmpty(paramString))
        {
          str3 = paramString;
          localJSONObject = new JSONObject();
          str4 = "";
          paramString = str4;
        }
        for (;;)
        {
          try
          {
            if (this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchSpecialDataModel != null)
            {
              paramString = str4;
              if (this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchSpecialDataModel.a != null)
              {
                if (this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchSpecialDataModel.a.showType != 0) {
                  continue;
                }
                paramString = "word";
              }
            }
            localJSONObject.put("template", paramString);
          }
          catch (JSONException paramString)
          {
            QLog.e("Q.uniteSearch.HotWordSearchSpecialEntryModel", 2, "e = " + paramString);
            continue;
          }
          awvy.a("hot_list", "clk_hot_event_list", new String[] { str5, str1, str3, str2 });
          paramString = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
          awso.a(null, new ReportModelDC02528().module("hot_list").action("clk_hot_event_list").ver2(str5).ver3(str1).ver4(str3).ver5(str2).ver7(localJSONObject.toString()).session_id(paramString.getCurrentAccountUin() + this.jdField_a_of_type_Long));
          return;
          i = this.jdField_a_of_type_Int;
          break;
          str3 = str1;
          break label83;
          if (this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchSpecialDataModel.a.showType == 1) {
            paramString = "pic";
          } else {
            paramString = "word";
          }
        }
      }
    }
  }
  
  public View a(Context paramContext, QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    paramBundle = paramQQAppInterface;
    if (paramQQAppInterface == null) {
      if (!(paramContext instanceof BaseActivity)) {
        break label297;
      }
    }
    label297:
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
      this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(paramContext).inflate(2131560585, null);
      this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131368899);
      this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131367398));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131367420));
      this.jdField_b_of_type_ComTencentImageURLImageView = ((URLImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369113));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370438));
      boolean bool = ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime());
      this.jdField_a_of_type_AndroidWidgetGridView = ((GridView)this.jdField_a_of_type_AndroidViewView.findViewById(2131367291));
      this.jdField_a_of_type_Awie = new awie(this, paramContext, LayoutInflater.from(paramContext));
      this.jdField_a_of_type_AndroidWidgetGridView.setAdapter(this.jdField_a_of_type_Awie);
      this.jdField_a_of_type_AndroidWidgetGridView.setOnItemClickListener(this);
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131371647));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131369631));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
      if (bool)
      {
        this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2131166783);
        this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2131166782);
      }
      return this.jdField_a_of_type_AndroidViewView;
    }
  }
  
  public void a()
  {
    ThreadManager.post(new HotWordSearchSpecialEntryModel.2(this, new HotWordSearchSpecialDataModel(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 5, this.jdField_a_of_type_Int, this.jdField_a_of_type_Boolean)), 5, null, true);
  }
  
  public void a(GridView paramGridView)
  {
    Object localObject = paramGridView.getAdapter();
    if (localObject == null) {
      return;
    }
    int i = 0;
    int j = 0;
    while (i < ((ListAdapter)localObject).getCount())
    {
      View localView = ((ListAdapter)localObject).getView(i, null, paramGridView);
      localView.measure(0, 0);
      j += localView.getMeasuredHeight();
      i += 2;
    }
    localObject = paramGridView.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).height = (actn.a(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources()) + j);
    paramGridView.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
  
  public void a(awpn paramawpn)
  {
    b(paramawpn);
  }
  
  public void a(String paramString1, String paramString2)
  {
    String str = paramString1;
    if (TextUtils.isEmpty(paramString1))
    {
      if (this.jdField_a_of_type_Int == 10) {
        str = awvv.a(paramString2, 5, "kandian_hotword");
      }
    }
    else
    {
      if (TextUtils.isEmpty(str)) {
        break label154;
      }
      paramString1 = bbej.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, str);
      if (paramString1 == null) {
        break label72;
      }
      paramString1.c();
      awiu.jdField_a_of_type_Boolean = true;
    }
    label72:
    while (!QLog.isColorLevel())
    {
      do
      {
        return;
        str = awvv.a(paramString2, 5, "hotword");
        break;
        if ((str.startsWith("http://")) || (str.startsWith("https://")))
        {
          paramString1 = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
          paramString1.putExtra("url", str);
          paramString1.putExtra("search_title", paramString2);
          this.jdField_a_of_type_AndroidContentContext.startActivity(paramString1);
          awiu.jdField_a_of_type_Boolean = true;
          return;
        }
      } while (!QLog.isColorLevel());
      QLog.d("Q.uniteSearch.HotWordSearchSpecialEntryModel", 2, "jumpAction jumpUrl is illegal");
      return;
    }
    label154:
    QLog.d("Q.uniteSearch.HotWordSearchSpecialEntryModel", 2, "jumpAction jumpUrl is empty");
  }
  
  public void b()
  {
    super.b();
  }
  
  public void b(awpn paramawpn)
  {
    HotWordSearchSpecialDataModel localHotWordSearchSpecialDataModel = (HotWordSearchSpecialDataModel)paramawpn;
    if ((localHotWordSearchSpecialDataModel == null) || (localHotWordSearchSpecialDataModel.a == null) || (TextUtils.isEmpty(localHotWordSearchSpecialDataModel.a.title)))
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchSpecialDataModel = localHotWordSearchSpecialDataModel;
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    if ((localHotWordSearchSpecialDataModel.a.topicItems != null) && (localHotWordSearchSpecialDataModel.a.topicItems.size() > 0))
    {
      this.jdField_a_of_type_AndroidWidgetGridView.setVisibility(0);
      this.jdField_a_of_type_Awie.a(localHotWordSearchSpecialDataModel.a.topicItems);
      a(this.jdField_a_of_type_AndroidWidgetGridView);
      this.jdField_a_of_type_Awie.notifyDataSetChanged();
      if (TextUtils.isEmpty(localHotWordSearchSpecialDataModel.a.title)) {
        break label589;
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setText(localHotWordSearchSpecialDataModel.a.title);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      label159:
      paramawpn = new ColorDrawable();
      if (!ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime())) {
        break label601;
      }
      paramawpn.setColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167111));
      label196:
      if (TextUtils.isEmpty(localHotWordSearchSpecialDataModel.a.leftIconUrl)) {
        break label621;
      }
      localObject1 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = paramawpn;
      ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = paramawpn;
      localObject1 = URLDrawable.getDrawable(localHotWordSearchSpecialDataModel.a.leftIconUrl, (URLDrawable.URLDrawableOptions)localObject1);
      this.jdField_b_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject1);
      this.jdField_b_of_type_ComTencentImageURLImageView.setVisibility(0);
      label259:
      if (TextUtils.isEmpty(localHotWordSearchSpecialDataModel.a.moreText)) {
        break label633;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText(localHotWordSearchSpecialDataModel.a.moreText);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    int k;
    int i;
    int j;
    Object localObject3;
    Object localObject2;
    for (;;)
    {
      if ((localHotWordSearchSpecialDataModel.a.topicImages == null) || (localHotWordSearchSpecialDataModel.a.topicImages.size() <= 0)) {
        break label670;
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      k = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
      i = 0;
      for (;;)
      {
        j = i;
        if (i >= localHotWordSearchSpecialDataModel.a.topicImages.size()) {
          break;
        }
        j = i;
        if (i >= k) {
          break;
        }
        localObject1 = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i);
        ((View)localObject1).setVisibility(0);
        localObject3 = (SquareImageView)((View)localObject1).findViewById(2131367872);
        TextView localTextView = (TextView)((View)localObject1).findViewById(2131365018);
        j = (vzo.a(this.jdField_a_of_type_AndroidContentContext) - vzo.a(this.jdField_a_of_type_AndroidContentContext, 59.0F)) / 4;
        int m = j * 60 / 79;
        localObject2 = (HotWordSearchSpecialDataModel.TopicImage)localHotWordSearchSpecialDataModel.a.topicImages.get(i);
        String str = ((HotWordSearchSpecialDataModel.TopicImage)localObject2).imageUrl;
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mLoadingDrawable = paramawpn;
        localURLDrawableOptions.mFailedDrawable = paramawpn;
        localURLDrawableOptions.mRequestWidth = j;
        localURLDrawableOptions.mRequestHeight = m;
        localURLDrawableOptions.mPlayGifImage = true;
        ((SquareImageView)localObject3).setImageDrawable(URLDrawable.getDrawable(str, localURLDrawableOptions));
        localTextView.setText(((HotWordSearchSpecialDataModel.TopicImage)localObject2).imageText);
        localObject3 = (LinearLayout.LayoutParams)((View)localObject1).getLayoutParams();
        ((LinearLayout.LayoutParams)localObject3).height = m;
        ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject3);
        ((View)localObject1).setVisibility(0);
        ((View)localObject1).setOnClickListener(new awid(this, (HotWordSearchSpecialDataModel.TopicImage)localObject2));
        i += 1;
      }
      this.jdField_a_of_type_AndroidWidgetGridView.setVisibility(8);
      break;
      label589:
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      break label159;
      label601:
      paramawpn.setColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167110));
      break label196;
      label621:
      this.jdField_b_of_type_ComTencentImageURLImageView.setVisibility(8);
      break label259;
      label633:
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    while (j < k)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(j).setVisibility(4);
      j += 1;
      continue;
      label670:
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
    Object localObject1 = a(localHotWordSearchSpecialDataModel.a.titleColor, "#000000");
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null)) {
        this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#6991B8"));
      }
    }
    else
    {
      label731:
      if (TextUtils.isEmpty(localHotWordSearchSpecialDataModel.a.iconUrl)) {
        break label953;
      }
      localObject1 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = paramawpn;
      ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = paramawpn;
      paramawpn = URLDrawable.getDrawable(localHotWordSearchSpecialDataModel.a.iconUrl, (URLDrawable.URLDrawableOptions)localObject1);
      this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(paramawpn);
      this.jdField_a_of_type_ComTencentImageURLImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    }
    for (;;)
    {
      try
      {
        paramawpn = (Boolean)SearchEntryFragment.a.get(Integer.valueOf(5));
        if ((paramawpn != null) && (paramawpn.booleanValue())) {
          break;
        }
        if (this.jdField_a_of_type_Int == 3)
        {
          i = 21;
          localObject1 = awso.a(i);
          localObject2 = new StringBuilder("");
          if ((localHotWordSearchSpecialDataModel.a.topicItems == null) || (localHotWordSearchSpecialDataModel.a.topicItems.size() <= 0)) {
            continue;
          }
          j = localHotWordSearchSpecialDataModel.a.topicItems.size();
          i = 0;
          if (i >= j - 1) {
            continue;
          }
          ((StringBuilder)localObject2).append(((HotWordSearchSpecialDataModel.TopicItem)localHotWordSearchSpecialDataModel.a.topicItems.get(i)).title).append("::");
          i += 1;
          continue;
          this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor((String)localObject1));
          break label731;
          label953:
          this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
          continue;
        }
        i = this.jdField_a_of_type_Int;
        continue;
        ((StringBuilder)localObject2).append(((HotWordSearchSpecialDataModel.TopicItem)localHotWordSearchSpecialDataModel.a.topicItems.get(j - 1)).title);
        if ((localHotWordSearchSpecialDataModel.a.topicImages != null) && (localHotWordSearchSpecialDataModel.a.topicImages.size() > 0))
        {
          j = localHotWordSearchSpecialDataModel.a.topicImages.size();
          i = 0;
          if (i < j - 1)
          {
            ((StringBuilder)localObject2).append(((HotWordSearchSpecialDataModel.TopicImage)localHotWordSearchSpecialDataModel.a.topicImages.get(i)).imageText).append("::");
            i += 1;
            continue;
          }
          ((StringBuilder)localObject2).append(((HotWordSearchSpecialDataModel.TopicImage)localHotWordSearchSpecialDataModel.a.topicImages.get(j - 1)).imageText);
        }
        awvy.a("hot_list", "exp_hot_event_list", new String[] { localObject1, localHotWordSearchSpecialDataModel.a.title, ((StringBuilder)localObject2).toString() });
        SearchEntryFragment.a.put(Integer.valueOf(5), Boolean.valueOf(true));
        localObject3 = new JSONObject();
      }
      catch (Exception paramawpn) {}
      try
      {
        if (localHotWordSearchSpecialDataModel.a.showType != 0) {
          break label1312;
        }
        paramawpn = "word";
        ((JSONObject)localObject3).put("template", paramawpn);
      }
      catch (JSONException paramawpn)
      {
        QLog.e("Q.uniteSearch.HotWordSearchSpecialEntryModel", 2, "e = " + paramawpn);
        continue;
      }
      paramawpn = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      awso.a(null, new ReportModelDC02528().module("hot_list").action("exp_hot_event_list").ver2((String)localObject1).ver3(localHotWordSearchSpecialDataModel.a.title).ver4(((StringBuilder)localObject2).toString()).ver7(((JSONObject)localObject3).toString()).session_id(paramawpn.getCurrentAccountUin() + this.jdField_a_of_type_Long));
      return;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("Q.uniteSearch.HotWordSearchSpecialEntryModel", 2, "updateData Exception");
      return;
      label1312:
      if (localHotWordSearchSpecialDataModel.a.showType == 1) {
        paramawpn = "pic";
      } else {
        paramawpn = "word";
      }
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      return;
    } while ((this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchSpecialDataModel == null) || (this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchSpecialDataModel.a == null));
    a(this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchSpecialDataModel.a.jumpUrl, this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchSpecialDataModel.a.title);
    a(true, "");
    ((akgd)((QQAppInterface)onk.a()).getManager(299)).a(this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchSpecialDataModel.a.title);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (paramInt < this.jdField_a_of_type_Awie.a().size())
    {
      paramAdapterView = (HotWordSearchSpecialDataModel.TopicItem)this.jdField_a_of_type_Awie.a().get(paramInt);
      if (!TextUtils.isEmpty(paramAdapterView.title))
      {
        a(paramAdapterView.jumpUrl, paramAdapterView.title);
        a(false, paramAdapterView.title);
        ((akgd)((QQAppInterface)onk.a()).getManager(299)).a(paramAdapterView.title);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awic
 * JD-Core Version:    0.7.0.1
 */