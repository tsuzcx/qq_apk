import SummaryCard.PhotoInfo;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.profilecard.bussiness.qzone.ProfileQZoneComponent.1;
import com.tencent.mobileqq.profilecard.bussiness.qzone.ProfileQZoneComponent.2;
import com.tencent.mobileqq.profilecard.bussiness.qzone.ProfileQZoneComponent.5;
import com.tencent.mobileqq.profilecard.bussiness.qzone.ProfileQZoneComponent.6;
import com.tencent.mobileqq.profilecard.bussiness.qzone.ProfileQZoneComponent.7;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.mobileqq.widget.UnderlineTextView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QZoneClickReport;
import cooperation.qzone.QZoneClickReport.ReportInfo;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import cooperation.qzone.QzonePluginProxyActivity;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class ayxd
  extends ayrs
  implements Handler.Callback, View.OnClickListener
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private ColorDrawable jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
  private final aufm jdField_a_of_type_Aufm = new aufm("qzone_friendprofile", "com.tencent.mobileqq:qzone", QzonePluginProxyActivity.getQZonePluginName());
  private bjng jdField_a_of_type_Bjng;
  private boolean jdField_a_of_type_Boolean;
  private bjng b;
  
  public ayxd(aysx paramaysx, aymg paramaymg)
  {
    super(paramaysx, paramaymg);
  }
  
  private int a(Card paramCard)
  {
    if ((paramCard != null) && (paramCard.enlargeQzonePic == 1)) {
      return 3;
    }
    return 4;
  }
  
  private String a(QQAppInterface paramQQAppInterface, aymg paramaymg, Card paramCard, boolean paramBoolean, ViewGroup paramViewGroup)
  {
    Object localObject;
    if ((!paramBoolean) && (paramCard.isShowFeeds()) && (!TextUtils.isEmpty(paramCard.strQzoneFeedsDesc))) {
      localObject = azta.a(paramCard.strQzoneFeedsDesc, paramQQAppInterface);
    }
    String str;
    do
    {
      do
      {
        do
        {
          do
          {
            return localObject;
            if (!TextUtils.isEmpty(paramCard.strSpaceName)) {
              return paramCard.strSpaceName;
            }
            localObject = a(paramaymg);
            if (paramaymg.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) {
              localObject = amtj.a(2131707590);
            }
            str = String.format("%s%s", new Object[] { localObject, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131693100) });
            localObject = str;
          } while (paramaymg.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0);
          localObject = str;
        } while (!paramCard.showPublishButton);
        localObject = str;
      } while (paramViewGroup == null);
      localObject = str;
    } while ((LocalMultiProcConfig.getInt4Uin("qzone_feed_gray_mask", 1, paramQQAppInterface.getLongAccountUin()) & 0x4000) == 0);
    paramViewGroup.removeAllViews();
    paramViewGroup.setVisibility(0);
    a("no photo, show writeMoodContainer view.");
    paramQQAppInterface = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).inflate(2131561358, null);
    paramViewGroup.addView(paramQQAppInterface);
    paramQQAppInterface.setOnClickListener(new ayxf(this));
    LpReportInfo_pf00064.allReport(699, 7);
    return str;
  }
  
  private void a(int paramInt)
  {
    aymg localaymg = (aymg)this.jdField_b_of_type_JavaLangObject;
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (paramInt == 7)
    {
      this.jdField_b_of_type_Bjng.post(new ProfileQZoneComponent.7(this));
      return;
    }
    Object localObject2 = localQQAppInterface.getCurrentNickname();
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = localQQAppInterface.getCurrentNickname();
    }
    localObject2 = QZoneHelper.UserInfo.getInstance();
    ((QZoneHelper.UserInfo)localObject2).qzone_uin = localQQAppInterface.getCurrentAccountUin();
    ((QZoneHelper.UserInfo)localObject2).nickname = ((String)localObject1);
    localObject1 = localaymg.jdField_a_of_type_ComTencentMobileqqDataCard.vQzoneCoverInfo;
    if (localObject1 == null) {}
    for (paramInt = 0;; paramInt = localObject1.length)
    {
      a(String.format("qzGoQzoneUserHomeActivity vQzoneCoverInfo=%s length=%s", new Object[] { localObject1, Integer.valueOf(paramInt) }));
      QZoneHelper.forwardToUserHome(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (QZoneHelper.UserInfo)localObject2, localaymg.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, localaymg.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.g, -1, 5, this.jdField_a_of_type_Aufm, (byte[])localObject1, false);
      localObject1 = new QZoneClickReport.ReportInfo();
      ((QZoneClickReport.ReportInfo)localObject1).actionType = "1";
      ((QZoneClickReport.ReportInfo)localObject1).subactionType = "0";
      ((QZoneClickReport.ReportInfo)localObject1).tabletype = 4;
      ((QZoneClickReport.ReportInfo)localObject1).sourceType = "3";
      ((QZoneClickReport.ReportInfo)localObject1).sourceFrom = "userSummary";
      ((QZoneClickReport.ReportInfo)localObject1).sourceTo = "homePage";
      QZoneClickReport.startReportImediately(localQQAppInterface.getAccount(), (QZoneClickReport.ReportInfo)localObject1);
      localObject1 = new HashMap();
      ((HashMap)localObject1).put("source_type", "3");
      ((HashMap)localObject1).put("source_from", "userSummary");
      ((HashMap)localObject1).put("source_to", "homePage");
      StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance(localQQAppInterface.getAccount(), "actQZSourceDataReport", true, 0L, 0L, (HashMap)localObject1, null);
      return;
    }
  }
  
  private static void a(View paramView, boolean paramBoolean)
  {
    if (paramView != null) {
      if (!paramBoolean) {
        break label16;
      }
    }
    label16:
    for (int i = 0;; i = 8)
    {
      paramView.setVisibility(i);
      return;
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, aymg paramaymg, Card paramCard, ViewGroup paramViewGroup, List<PhotoInfo> paramList)
  {
    label10:
    int j;
    int i;
    int k;
    int m;
    if (paramList.isEmpty())
    {
      return;
    }
    else
    {
      Object localObject = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      Resources localResources = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources();
      j = localResources.getDimensionPixelSize(2131298337);
      i = localResources.getDimensionPixelSize(2131297537);
      k = ViewUtils.dpToPx(30.0F);
      k = (int)(this.jdField_a_of_type_Float - i - k);
      i = a(paramCard);
      m = (int)((k - (i - 1) * j) * 1.0F) / i;
      a(String.format(Locale.getDefault(), "makeOrRefreshQZone count:%s, photo:%s, margin:%s, max: %s", new Object[] { Integer.valueOf(paramList.size()), Integer.valueOf(m), Integer.valueOf(j), Integer.valueOf(k) }));
      if ((paramaymg.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) || ((LocalMultiProcConfig.getInt4Uin("qzone_feed_gray_mask", 1, paramQQAppInterface.getLongAccountUin()) & 0x4000) == 0)) {
        break label337;
      }
      paramaymg = ((LayoutInflater)localObject).inflate(2131561357, null);
      if (ThemeUtil.isInNightMode(paramQQAppInterface)) {
        paramaymg.setBackgroundColor(Color.parseColor("#77F5F6FA"));
      }
      paramViewGroup.addView(paramaymg);
      localObject = paramaymg.getLayoutParams();
      if ((localObject instanceof LinearLayout.LayoutParams))
      {
        localObject = (LinearLayout.LayoutParams)localObject;
        ((LinearLayout.LayoutParams)localObject).width = m;
        ((LinearLayout.LayoutParams)localObject).height = m;
        ((LinearLayout.LayoutParams)localObject).rightMargin = j;
        paramaymg.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      i = 0 + m;
      paramaymg.setOnClickListener(new ayxe(this));
      LpReportInfo_pf00064.allReport(699, 7);
    }
    for (;;)
    {
      paramaymg = paramList.iterator();
      if (!paramaymg.hasNext()) {
        break label10;
      }
      if (!a(paramQQAppInterface, paramCard, paramViewGroup, (PhotoInfo)paramaymg.next(), m, j, new int[] { i }, k)) {
        break;
      }
      return;
      label337:
      i = 0;
    }
  }
  
  private static void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileQZoneComponent", 2, paramString);
    }
  }
  
  private boolean a(QQAppInterface paramQQAppInterface, Card paramCard, ViewGroup paramViewGroup, PhotoInfo paramPhotoInfo, int paramInt1, int paramInt2, int[] paramArrayOfInt, int paramInt3)
  {
    String str3 = paramPhotoInfo.strPicUrl;
    View localView2 = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).inflate(2131561356, null);
    ImageView localImageView = (ImageView)localView2.findViewById(2131368708);
    View localView3 = localView2.findViewById(2131368710);
    View localView1 = localView2.findViewById(2131368707);
    View localView4 = localView2.findViewById(2131368709);
    TextView localTextView = (TextView)localView2.findViewById(2131368704);
    UnderlineTextView localUnderlineTextView = (UnderlineTextView)localView2.findViewById(2131368703);
    localUnderlineTextView.setEditableFactory(QQTextBuilder.EMOCTATION_FACORY);
    String str2 = "";
    String str1 = "";
    boolean bool = false;
    if (paramPhotoInfo.mapEx != null)
    {
      str2 = (String)paramPhotoInfo.mapEx.get("info_type");
      str1 = (String)paramPhotoInfo.mapEx.get("feeds_content");
      bool = "1".equals(paramPhotoInfo.mapEx.get("isVideo"));
    }
    int i;
    if ((TextUtils.equals(str2, "1")) && (!TextUtils.isEmpty(str1)))
    {
      localUnderlineTextView.setText(str1);
      localUnderlineTextView.setVisibility(0);
      localImageView.setVisibility(8);
      paramQQAppInterface = localUnderlineTextView.getLayoutParams();
      paramQQAppInterface.width = paramInt1;
      paramQQAppInterface.height = paramInt1;
      i = localUnderlineTextView.getLineHeight();
      if (i > 0) {
        localUnderlineTextView.setMaxLines(b(paramCard));
      }
      for (;;)
      {
        i = 1;
        if (i != 0) {
          break;
        }
        QLog.w("ProfileQZoneComponent", 1, "makeOrRefreshQZone: needUpdateUI=false,skip this one");
        return false;
        QLog.w("ProfileQZoneComponent", 1, "makeOrRefreshQZone: invalid lineHeight:" + i);
      }
    }
    if (!TextUtils.isEmpty(str3))
    {
      if (ThemeUtil.isInNightMode(paramQQAppInterface)) {
        localImageView.setColorFilter(1996488704);
      }
      if (this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable == null) {
        this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new ColorDrawable(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getColor(2131165720));
      }
    }
    for (;;)
    {
      try
      {
        paramQQAppInterface = URLDrawable.URLDrawableOptions.obtain();
        paramQQAppInterface.mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
        paramQQAppInterface.mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
        paramQQAppInterface.mRequestHeight = paramInt1;
        paramQQAppInterface.mRequestWidth = paramInt1;
        if ((str3.startsWith("http://")) || (str3.startsWith("https://")))
        {
          localImageView.setImageDrawable(URLDrawable.getDrawable(str3, paramQQAppInterface));
          if (str3.contains("video=1")) {
            break label805;
          }
          if (!bool) {
            break label551;
          }
          break label805;
          a(localView3, bool);
          if (paramPhotoInfo.IsOnlySelf != 1) {
            break label557;
          }
          bool = true;
          a(localView4, bool);
          i = 1;
          break;
        }
        if (!bool) {
          break label537;
        }
        paramQQAppInterface = ShortVideoUtils.getVideoThumbnail(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, str3, paramInt1, 0L);
        if (paramQQAppInterface != null)
        {
          localImageView.setImageBitmap(paramQQAppInterface);
          continue;
        }
      }
      catch (Exception paramQQAppInterface)
      {
        QLog.e("Q.profilecard.FrdProfileCard", 1, "makeOrRefreshQZone fail!", paramQQAppInterface);
        i = 1;
      }
      localImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable);
      continue;
      label537:
      localImageView.setImageDrawable(URLDrawable.getFileDrawable(str3, paramQQAppInterface));
      continue;
      label551:
      bool = false;
      continue;
      label557:
      bool = false;
      continue;
      paramViewGroup.addView(localView2);
      paramQQAppInterface = localView2.getLayoutParams();
      if ((paramQQAppInterface instanceof LinearLayout.LayoutParams))
      {
        paramQQAppInterface = (LinearLayout.LayoutParams)paramQQAppInterface;
        paramQQAppInterface.rightMargin = paramInt2;
        localView2.setLayoutParams(paramQQAppInterface);
      }
      paramQQAppInterface = localImageView.getLayoutParams();
      if (b())
      {
        paramQQAppInterface.width = -1;
        paramQQAppInterface.height = -1;
        localImageView.setLayoutParams(paramQQAppInterface);
        paramQQAppInterface = localView1.getLayoutParams();
        if (!b()) {
          break label768;
        }
        paramQQAppInterface.width = -1;
      }
      for (paramQQAppInterface.height = -1;; paramQQAppInterface.height = paramInt1)
      {
        localView1.setLayoutParams(paramQQAppInterface);
        if (paramArrayOfInt[0] > 0) {
          paramArrayOfInt[0] += paramInt2;
        }
        paramArrayOfInt[0] += paramInt1;
        if (paramArrayOfInt[0] + paramInt1 + paramInt2 <= paramInt3) {
          break label783;
        }
        a(String.format(Locale.getDefault(), "makeOrRefreshQZone cur:%s, photo:%s, margin:%s, max: %s", new Object[] { Integer.valueOf(paramArrayOfInt[0]), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) }));
        return true;
        paramQQAppInterface.width = paramInt1;
        paramQQAppInterface.height = paramInt1;
        break;
        label768:
        paramQQAppInterface.width = paramInt1;
      }
      label783:
      localView1.setVisibility(8);
      localTextView.setVisibility(8);
      return false;
      i = 0;
      break;
      label805:
      bool = true;
    }
  }
  
  private boolean a(Card paramCard)
  {
    aymg localaymg = (aymg)this.jdField_b_of_type_JavaLangObject;
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    Object localObject3 = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    if ((!ProfileActivity.AllInOne.g(localaymg.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) || (paramCard == null) || (this.jdField_a_of_type_Boolean))
    {
      if (this.jdField_a_of_type_JavaLangObject != null) {}
      for (bool1 = true;; bool1 = false)
      {
        this.jdField_a_of_type_JavaLangObject = null;
        return bool1;
      }
    }
    ThreadManager.post(new ProfileQZoneComponent.2(this, localaymg), 8, null, true);
    Object localObject1 = (View)this.jdField_a_of_type_JavaLangObject;
    if (b()) {
      localObject1 = null;
    }
    Object localObject2;
    if (localObject1 == null)
    {
      localObject2 = this.jdField_a_of_type_Ayyp.a("map_key_qzone");
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = ((LayoutInflater)localObject3).inflate(2131561355, null);
      }
      this.jdField_a_of_type_JavaLangObject = localObject1;
    }
    for (boolean bool1 = true;; bool1 = false)
    {
      ViewGroup localViewGroup1 = (ViewGroup)((View)localObject1).findViewById(2131368705);
      ViewGroup localViewGroup2 = (ViewGroup)((View)localObject1).findViewById(2131368706);
      TextView localTextView = (TextView)((View)localObject1).findViewById(2131378524);
      ImageView localImageView = (ImageView)((View)localObject1).findViewById(2131368384);
      localTextView.setSingleLine(true);
      localTextView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
      boolean bool2;
      if ((paramCard.ulShowControl & 0x80) != 0)
      {
        bool2 = true;
        a(String.format("makeOrRefreshQZone card.ulShowControl=%x hasLocked=%s", new Object[] { Integer.valueOf(paramCard.ulShowControl), Boolean.valueOf(bool2) }));
        if ((bool2) || ((!paramCard.isShowPhoto()) && (!paramCard.hasFakeData)) || (!paramCard.hasGotPhotoUrl())) {
          break label588;
        }
        localObject3 = paramCard.getQZonePhotoList();
        localObject2 = localObject3;
        if (localObject3 == null) {
          localObject2 = Collections.emptyList();
        }
        if (localaymg.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0)
        {
          if (((List)localObject2).size() < this.jdField_a_of_type_Int) {
            break label581;
          }
          this.jdField_a_of_type_Int = ((List)localObject2).size();
        }
        localViewGroup1.removeAllViews();
        localViewGroup1.setVisibility(0);
        if ((localViewGroup2 != null) && (localViewGroup2.getVisibility() != 8))
        {
          localViewGroup2.removeAllViews();
          localViewGroup2.setVisibility(8);
        }
        localTextView.setVisibility(8);
        a(localQQAppInterface, localaymg, paramCard, localViewGroup1, (List)localObject2);
        if (!TextUtils.isEmpty(paramCard.strQzoneHeader))
        {
          localTextView.setVisibility(0);
          localTextView.setText(String.format("%s%s", new Object[] { a(localaymg), this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131693100) }));
        }
        if (localaymg.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) {
          localTextView.setText(amtj.a(2131707551));
        }
        label469:
        if (localTextView.getText() != null) {
          break label621;
        }
      }
      label581:
      label588:
      label621:
      for (localObject2 = "";; localObject2 = localTextView.getText().toString())
      {
        ((View)localObject1).setOnClickListener(this);
        ((View)localObject1).setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131691102));
        a((View)localObject1, localTextView, null, localImageView);
        a(String.format("makeOrRefreshQZone, [h:%s, des: %s, space: %s, remark: %s, nick: %s, info: %s]", new Object[] { paramCard.strQzoneHeader, paramCard.strQzoneFeedsDesc, paramCard.strSpaceName, localaymg.jdField_a_of_type_ArrayOfJavaLangString[4], localaymg.jdField_a_of_type_ArrayOfJavaLangString[0], localObject2 }));
        return bool1;
        bool2 = false;
        break;
        paramCard.hasFakeData = false;
        return true;
        localViewGroup1.setVisibility(8);
        localTextView.setVisibility(0);
        localTextView.setText(a(localQQAppInterface, localaymg, paramCard, bool2, localViewGroup2));
        break label469;
      }
    }
  }
  
  private int b(Card paramCard)
  {
    if ((paramCard != null) && (paramCard.enlargeQzonePic == 1)) {
      return 4;
    }
    return 3;
  }
  
  private boolean b()
  {
    aymg localaymg = (aymg)this.jdField_b_of_type_JavaLangObject;
    if (localaymg != null) {
      return aymn.a(localaymg.jdField_a_of_type_Long);
    }
    return false;
  }
  
  private void i()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().putExtra("writeMoodFromProfileCard", true);
    QZoneHelper.forwardToWriteMood(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 1037);
    LpReportInfo_pf00064.allReport(699, 8);
    LpReportInfo_pf00064.allReport(586, 1, 6);
  }
  
  public int a()
  {
    return 1012;
  }
  
  public String a()
  {
    return "ProfileQZoneComponent";
  }
  
  public String a(aymg paramaymg)
  {
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity == null) {
      localObject = "他";
    }
    do
    {
      String str;
      do
      {
        return localObject;
        str = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131698768);
        localObject = str;
      } while (paramaymg == null);
      localObject = str;
    } while (paramaymg.jdField_a_of_type_ComTencentMobileqqDataCard == null);
    if (paramaymg.jdField_a_of_type_ComTencentMobileqqDataCard.shGender == 1) {
      return this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131698767);
    }
    return this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131698768);
  }
  
  public void a()
  {
    ThreadManager.post(new ProfileQZoneComponent.6(this), 8, null, true);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    ArrayList localArrayList;
    if ((paramInt1 == 1037) && (paramInt2 == -1) && (paramIntent != null) && (this.jdField_b_of_type_JavaLangObject != null) && (((aymg)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne != null) && (((aymg)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0))
    {
      localArrayList = paramIntent.getStringArrayListExtra("imageUrl");
      if ((localArrayList != null) && (localArrayList.size() > 0))
      {
        localObject = (amsw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
        if (localObject != null) {
          break label150;
        }
      }
    }
    label150:
    for (Object localObject = null;; localObject = ((amsw)localObject).b(((aymg)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))
    {
      if (localObject != null)
      {
        ((Card)localObject).addQzonePhotoList(localArrayList, paramIntent);
        ((Card)localObject).hasFakeData = true;
        ((aymg)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqDataCard = ((Card)localObject);
        a(((aymg)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqDataCard);
      }
      return;
    }
  }
  
  public void a(@NonNull BaseActivity paramBaseActivity, @Nullable Bundle paramBundle)
  {
    Intent localIntent = paramBaseActivity.getIntent();
    if (localIntent != null) {
      this.jdField_a_of_type_Boolean = localIntent.getBooleanExtra("key_from_ark_babyq", false);
    }
    super.a(paramBaseActivity, paramBundle);
    paramBaseActivity = paramBaseActivity.getResources().getDisplayMetrics();
    this.jdField_a_of_type_Float = Math.min(paramBaseActivity.widthPixels, paramBaseActivity.heightPixels);
    this.jdField_a_of_type_Bjng = new bjng(ThreadManager.getSubThreadLooper(), this);
    this.jdField_b_of_type_Bjng = new bjng(Looper.getMainLooper(), null);
    ThreadManager.post(new ProfileQZoneComponent.1(this, (aymg)this.jdField_b_of_type_JavaLangObject), 8, null, true);
  }
  
  public boolean a(aymg paramaymg)
  {
    boolean bool = super.a(paramaymg);
    return a(((aymg)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqDataCard) | bool;
  }
  
  public String a_()
  {
    return "map_key_qzone";
  }
  
  public void c()
  {
    super.c();
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (localQQAppInterface != null)
    {
      WebProcessManager localWebProcessManager = (WebProcessManager)localQQAppInterface.getManager(13);
      if (localWebProcessManager != null) {
        localWebProcessManager.a(-1, new ayxg(this.jdField_a_of_type_Aufm));
      }
      QZoneHelper.preloadInFriendProfileCard(localQQAppInterface, this.jdField_a_of_type_Aufm);
    }
  }
  
  public void f()
  {
    super.f();
    if (this.jdField_a_of_type_Bjng != null)
    {
      this.jdField_a_of_type_Bjng.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_Bjng.removeMessages(0);
      this.jdField_a_of_type_Bjng = null;
    }
    this.jdField_a_of_type_Aufm.d();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      localObject = ((QQAppInterface)localObject).getEntityManagerFactory().createEntityManager();
      ((EntityManager)localObject).update((Card)paramMessage.obj);
      ((EntityManager)localObject).close();
      continue;
      localObject = ((QQAppInterface)localObject).getEntityManagerFactory().createEntityManager();
      ((EntityManager)localObject).persist((Card)paramMessage.obj);
      ((EntityManager)localObject).close();
    }
  }
  
  public void onClick(View paramView)
  {
    aymg localaymg = (aymg)this.jdField_b_of_type_JavaLangObject;
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    a();
    ThreadManager.post(new ProfileQZoneComponent.5(this, localaymg), 8, null, true);
    bcef.b(localQQAppInterface, "CliOper", "", "", "P_prof", "Pp_clk_qzone", ProfileActivity.a(localaymg.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.h), 0, Integer.toString(ProfileActivity.a(localaymg.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
    if (localaymg.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) {
      bcef.b(localQQAppInterface, "CliOper", "", "", "0X8006A7C", "0X8006A7C", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      if (localaymg.b) {
        new bcek(localQQAppInterface).a("dc00899").b("Grp_mem_card").c("page").d("zone_clk").a(new String[] { localaymg.jdField_a_of_type_JavaLangString }).a();
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      bcef.b(localQQAppInterface, "CliOper", "", "", "0X8006A90", "0X8006A90", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayxd
 * JD-Core Version:    0.7.0.1
 */