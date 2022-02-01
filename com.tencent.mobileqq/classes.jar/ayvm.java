import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.LruCache;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.qcircleshadow.local.requests.QCircleGetMainPageRequest;
import com.tencent.biz.qcircleshadow.local.requests.QCircleGetSimpleCountInfoRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.leba.widget.LebaRoundLayout;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.UnderlineTextView;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import cooperation.qqcircle.utils.QCircleCommonUtil;
import cooperation.qzone.LocalMultiProcConfig;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StImage;
import feedcloud.FeedCloudRead.StGetMainPageRsp;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;
import qqcircle.QQCircleFeedBase.StMainPageBusiRspData;

public class ayvm
  extends ayrs
{
  private static long jdField_a_of_type_Long;
  private static LruCache<String, ayvr> jdField_a_of_type_AndroidUtilLruCache;
  private float jdField_a_of_type_Float;
  private ColorDrawable jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
  private bjng jdField_a_of_type_Bjng;
  private String jdField_a_of_type_JavaLangString;
  private volatile List<FeedCloudMeta.StFeed> jdField_a_of_type_JavaUtilList;
  private final AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private boolean jdField_a_of_type_Boolean;
  private String jdField_b_of_type_JavaLangString;
  private final AtomicBoolean jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private volatile boolean jdField_b_of_type_Boolean = true;
  private volatile boolean c = true;
  
  public ayvm(aysx paramaysx, aymg paramaymg)
  {
    super(paramaysx, paramaymg);
    if (jdField_a_of_type_AndroidUtilLruCache == null) {
      jdField_a_of_type_AndroidUtilLruCache = new LruCache(5);
    }
  }
  
  private void a(int paramInt1, int paramInt2, String paramString, ImageView paramImageView, View paramView, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable == null) {
      this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new ColorDrawable(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getColor(2131165720));
    }
    for (;;)
    {
      Object localObject;
      try
      {
        localObject = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
        ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
        ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = paramInt2;
        ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = paramInt1;
        if ((paramString.startsWith("http://")) || (paramString.startsWith("https://")))
        {
          paramImageView.setImageDrawable(URLDrawable.getDrawable(paramString, (URLDrawable.URLDrawableOptions)localObject));
          if ((!paramString.contains("video=1")) && (!paramBoolean)) {
            break;
          }
          paramView.setVisibility(0);
          return;
        }
        if (!paramBoolean) {
          break label170;
        }
        localObject = ShortVideoUtils.getVideoThumbnail(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramString, paramInt1, 0L);
        if (localObject != null)
        {
          paramImageView.setImageBitmap((Bitmap)localObject);
          continue;
        }
        paramImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable);
      }
      catch (Exception paramString)
      {
        QLog.e("ProfileCircleComponent", 2, "makeOrRefreshQZone fail!", paramString);
        return;
      }
      continue;
      label170:
      paramImageView.setImageDrawable(URLDrawable.getFileDrawable(paramString, (URLDrawable.URLDrawableOptions)localObject));
    }
    paramView.setVisibility(8);
  }
  
  private void a(aymg paramaymg, LayoutInflater paramLayoutInflater, QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources();
    int m = ((Resources)localObject1).getDimensionPixelSize(2131298337);
    int i = ((Resources)localObject1).getDimensionPixelSize(2131297537);
    int j = ViewUtils.dpToPx(30.0F);
    int n = (int)(this.jdField_a_of_type_Float - i - j);
    int i1 = (int)((n - m * 4) * 1.0F) / 5;
    int i2 = ViewUtils.dpToPx(75.0F);
    d(String.format(Locale.getDefault(), "doMakeOrRefreshQQCircle count:%s, photo:%s, margin:%s, max: %s", new Object[] { Integer.valueOf(this.jdField_a_of_type_JavaUtilList.size()), Integer.valueOf(i1), Integer.valueOf(m), Integer.valueOf(n) }));
    if ((paramaymg.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a == 0) && ((LocalMultiProcConfig.getInt4Uin("qzone_feed_gray_mask", 1, paramQQAppInterface.getLongAccountUin()) & 0x4000) != 0))
    {
      paramaymg = paramLayoutInflater.inflate(2131561353, null);
      localObject1 = (LebaRoundLayout)paramaymg.findViewById(2131376716);
      ((LebaRoundLayout)localObject1).a = ViewUtils.dpToPx(4.0F);
      ((LebaRoundLayout)localObject1).setVisibility(0);
      if (ThemeUtil.isInNightMode(paramQQAppInterface)) {
        paramaymg.findViewById(2131363417).setBackgroundColor(Color.parseColor("#77F5F6FA"));
      }
      paramViewGroup.addView(paramaymg);
      localObject1 = paramaymg.getLayoutParams();
      if ((localObject1 instanceof LinearLayout.LayoutParams))
      {
        localObject1 = (LinearLayout.LayoutParams)localObject1;
        ((LinearLayout.LayoutParams)localObject1).width = i1;
        ((LinearLayout.LayoutParams)localObject1).height = i2;
        ((LinearLayout.LayoutParams)localObject1).rightMargin = m;
        paramaymg.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        paramaymg.setOnClickListener(new ayvq(this));
      }
      j = 0 + i1;
      i = j;
      if (this.jdField_b_of_type_Boolean)
      {
        QCircleLpReportDc05504.report("", 3, 2, 1);
        this.jdField_b_of_type_Boolean = false;
      }
    }
    for (i = j;; i = 0)
    {
      int i3 = this.jdField_a_of_type_JavaUtilList.size();
      j = 0;
      Object localObject3;
      if (j < i3)
      {
        localObject3 = (FeedCloudMeta.StFeed)((FeedCloudMeta.StFeed)this.jdField_a_of_type_JavaUtilList.get(j)).get();
        if (localObject3 != null) {}
      }
      for (;;)
      {
        j += 1;
        break;
        String str = ((FeedCloudMeta.StFeed)localObject3).cover.picUrl.get();
        Object localObject2 = paramLayoutInflater.inflate(2131561352, null);
        paramaymg = (LebaRoundLayout)((View)localObject2).findViewById(2131376716);
        paramaymg.a = ViewUtils.dpToPx(4.0F);
        paramaymg.setVisibility(0);
        ImageView localImageView = (ImageView)((View)localObject2).findViewById(2131368699);
        View localView = ((View)localObject2).findViewById(2131368701);
        paramaymg = ((View)localObject2).findViewById(2131368698);
        ((View)localObject2).findViewById(2131368700);
        localObject1 = (TextView)((View)localObject2).findViewById(2131368695);
        ((UnderlineTextView)((View)localObject2).findViewById(2131368694)).setEditableFactory(QQTextBuilder.EMOCTATION_FACORY);
        int k = 0;
        if (((FeedCloudMeta.StFeed)localObject3).feedType.get() == 3) {}
        for (boolean bool = true;; bool = false)
        {
          if (!TextUtils.isEmpty(str))
          {
            k = 1;
            if (ThemeUtil.isInNightMode(paramQQAppInterface)) {
              localImageView.setColorFilter(1996488704);
            }
            a(i1, i2, str, localImageView, localView, bool);
          }
          if (k != 0) {
            break label568;
          }
          QLog.w("ProfileCircleComponent", 1, "doMakeOrRefreshQQCircle: needUpdateUI=false,skip this one");
          break;
        }
        label568:
        paramViewGroup.addView((View)localObject2);
        localObject3 = ((View)localObject2).getLayoutParams();
        if ((localObject3 instanceof LinearLayout.LayoutParams))
        {
          localObject3 = (LinearLayout.LayoutParams)localObject3;
          ((LinearLayout.LayoutParams)localObject3).rightMargin = m;
          ((View)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
        }
        localObject2 = localImageView.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject2).width = i1;
        ((ViewGroup.LayoutParams)localObject2).height = i2;
        localImageView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        localObject2 = paramaymg.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject2).width = i1;
        ((ViewGroup.LayoutParams)localObject2).height = i2;
        paramaymg.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        k = i;
        if (i > 0) {
          k = i + m;
        }
        i = k + i1;
        if (i + i1 + m > n)
        {
          d(String.format(Locale.getDefault(), "doMakeOrRefreshQQCircle cur:%s, photo:%s, margin:%s, max: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(i1), Integer.valueOf(m), Integer.valueOf(n) }));
          return;
        }
        paramaymg.setVisibility(8);
        ((TextView)localObject1).setVisibility(8);
      }
    }
  }
  
  private void a(FeedCloudRead.StGetMainPageRsp paramStGetMainPageRsp)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity == null) {
      return;
    }
    long l2 = paramStGetMainPageRsp.fansCount.get();
    label174:
    for (;;)
    {
      try
      {
        QQCircleFeedBase.StMainPageBusiRspData localStMainPageBusiRspData = new QQCircleFeedBase.StMainPageBusiRspData();
        localStMainPageBusiRspData.mergeFrom(paramStGetMainPageRsp.busiRspData.get().toByteArray());
        int i = localStMainPageBusiRspData.fuelValue.get();
        long l1 = i;
        paramStGetMainPageRsp.printStackTrace();
      }
      catch (Exception paramStGetMainPageRsp)
      {
        try
        {
          jdField_a_of_type_Long = localStMainPageBusiRspData.timeInterval.get();
          paramStGetMainPageRsp = new StringBuilder();
          if (l2 != 0L) {
            paramStGetMainPageRsp.append(String.format(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131698770), new Object[] { QCircleCommonUtil.fansNumberFormatTranfer(l2) }));
          }
          if (l1 != 0L)
          {
            if (l2 != 0L) {
              paramStGetMainPageRsp.append("  ");
            }
            paramStGetMainPageRsp.append(String.format(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131698771), new Object[] { QCircleCommonUtil.fansNumberFormatTranfer(l1) }));
          }
          this.jdField_b_of_type_JavaLangString = paramStGetMainPageRsp.toString();
          return;
        }
        catch (Exception paramStGetMainPageRsp)
        {
          break label174;
        }
        paramStGetMainPageRsp = paramStGetMainPageRsp;
        l1 = 0L;
      }
    }
  }
  
  private void a(String paramString)
  {
    paramString = new QCircleGetMainPageRequest(paramString, null, 3);
    paramString.setEnableCache(false);
    ayvn localayvn = new ayvn(this);
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true))
    {
      QLog.d("ProfileCircleComponent", 4, "makeOrRefreshQQCircle sendRequest");
      VSNetworkHelper.getInstance().sendRequest(paramString, localayvn);
    }
  }
  
  private boolean a(Card paramCard)
  {
    if ((!QzoneConfig.isQQCircleShowProfileCardEntrance()) || (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity == null)) {
      return false;
    }
    QLog.d("ProfileCircleComponent", 4, "makeOrRefreshQQCircle start");
    long l = SystemClock.elapsedRealtime();
    if ((paramCard != null) && (paramCard.switch_qqcircle != 1))
    {
      bool = true;
      QLog.d("ProfileCircleComponent", 4, "makeOrRefreshQQCircle switch: " + bool);
      if (bool) {
        break label105;
      }
      if (this.jdField_a_of_type_JavaLangObject == null) {
        break label99;
      }
    }
    label99:
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_JavaLangObject = null;
      return bool;
      bool = false;
      break;
    }
    label105:
    aymg localaymg = (aymg)this.jdField_b_of_type_JavaLangObject;
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    LayoutInflater localLayoutInflater = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    Object localObject2 = (View)this.jdField_a_of_type_JavaLangObject;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = localLayoutInflater.inflate(2131561351, null);
      this.jdField_a_of_type_JavaLangObject = localObject1;
    }
    View localView = ((View)localObject1).findViewById(2131364924);
    ViewGroup localViewGroup1 = (ViewGroup)((View)localObject1).findViewById(2131368696);
    ViewGroup localViewGroup2 = (ViewGroup)((View)localObject1).findViewById(2131368697);
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.isEmpty()))
    {
      localView.setVisibility(8);
      localViewGroup1.setVisibility(8);
      localViewGroup2.setVisibility(8);
      a(paramCard.uin);
      c(paramCard.uin);
      return true;
    }
    TextView localTextView1 = (TextView)((View)localObject1).findViewById(2131378524);
    ImageView localImageView1 = (ImageView)((View)localObject1).findViewById(2131368445);
    ImageView localImageView2 = (ImageView)((View)localObject1).findViewById(2131368384);
    TextView localTextView2 = (TextView)((View)localObject1).findViewById(2131378432);
    FrameLayout localFrameLayout = (FrameLayout)((View)localObject1).findViewById(2131366767);
    localTextView1.setMaxWidth(2147483647);
    if (localaymg.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a != 0)
    {
      String str = a(localaymg);
      localObject2 = String.format(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131698769), new Object[] { str });
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
      {
        if ((ViewUtils.getTextWidth(localTextView1.getPaint(), (CharSequence)localObject2) <= ViewUtils.dpToPx(170.0F)) || (str.length() <= 7)) {
          break label747;
        }
        localObject2 = str.substring(0, 7) + "...";
        localObject2 = String.format(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131698769), new Object[] { localObject2 });
      }
    }
    label747:
    for (;;)
    {
      localTextView1.setText((String)localObject2 + this.jdField_a_of_type_JavaLangString);
      localImageView1.setVisibility(0);
      localFrameLayout.setVisibility(8);
      localViewGroup1.removeAllViews();
      localViewGroup1.setVisibility(0);
      if ((localViewGroup2 != null) && (localViewGroup2.getVisibility() != 8))
      {
        localViewGroup2.removeAllViews();
        localViewGroup2.setVisibility(8);
      }
      if (!this.jdField_a_of_type_JavaUtilList.isEmpty())
      {
        bool = true;
        a(localaymg, localLayoutInflater, localQQAppInterface, localViewGroup1);
      }
      for (;;)
      {
        ((View)localObject1).setOnClickListener(new ayvp(this, localaymg, paramCard, localQQAppInterface));
        ((View)localObject1).setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131698766));
        a((View)localObject1, localTextView1, null, localImageView2);
        localView.setVisibility(0);
        localViewGroup1.setVisibility(0);
        localViewGroup2.setVisibility(0);
        QLog.d("ProfileCircleComponent", 4, "makeOrRefreshQQCircle end： " + (SystemClock.elapsedRealtime() - l));
        return bool;
        localImageView1.setVisibility(8);
        localTextView1.setText((CharSequence)localObject2);
        if (this.jdField_b_of_type_JavaLangString == null) {
          break;
        }
        localTextView1.setMaxWidth(ViewUtils.dip2px(140.0F));
        localTextView2.setText(this.jdField_b_of_type_JavaLangString);
        localFrameLayout.setVisibility(0);
        break;
        if (this.jdField_b_of_type_JavaLangString == null) {
          break;
        }
        localTextView2.setText(this.jdField_b_of_type_JavaLangString);
        localFrameLayout.setVisibility(0);
        break;
        bool = false;
      }
    }
  }
  
  private boolean a(String paramString)
  {
    paramString = (ayvr)jdField_a_of_type_AndroidUtilLruCache.get(paramString);
    if ((paramString == null) || (paramString.a() == null)) {
      return true;
    }
    return System.currentTimeMillis() - paramString.a() > jdField_a_of_type_Long * 1000L;
  }
  
  private void b(String paramString)
  {
    FeedCloudRead.StGetMainPageRsp localStGetMainPageRsp = ((ayvr)jdField_a_of_type_AndroidUtilLruCache.get(paramString)).a();
    if (localStGetMainPageRsp == null) {
      a(paramString);
    }
    do
    {
      return;
      QLog.d("ProfileCircleComponent", 1, "Using cache update QCirlce ProfileCard");
      paramString = localStGetMainPageRsp.vecFeed.get();
      a(localStGetMainPageRsp);
    } while ((paramString == null) || (paramString.size() <= 0));
    this.jdField_a_of_type_JavaUtilList = paramString;
    a(((aymg)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqDataCard);
  }
  
  private void c(String paramString)
  {
    QCircleGetSimpleCountInfoRequest localQCircleGetSimpleCountInfoRequest = new QCircleGetSimpleCountInfoRequest(paramString);
    localQCircleGetSimpleCountInfoRequest.setEnableCache(false);
    paramString = new ayvo(this, paramString);
    if (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true))
    {
      QLog.d("ProfileCircleComponent", 4, "refreshRedPoint sendRequest");
      VSNetworkHelper.getInstance().sendRequest(localQCircleGetSimpleCountInfoRequest, paramString);
    }
  }
  
  private static void d(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCircleComponent", 2, paramString);
    }
  }
  
  public int a()
  {
    return 1015;
  }
  
  public String a()
  {
    return "ProfileCircleComponent";
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
  
  public void a(@NonNull BaseActivity paramBaseActivity, @Nullable Bundle paramBundle)
  {
    super.a(paramBaseActivity, paramBundle);
    this.jdField_a_of_type_Bjng = new bjng(Looper.getMainLooper(), null);
    paramBaseActivity = paramBaseActivity.getResources().getDisplayMetrics();
    this.jdField_a_of_type_Float = Math.min(paramBaseActivity.widthPixels, paramBaseActivity.heightPixels);
  }
  
  public boolean a(aymg paramaymg)
  {
    boolean bool = super.a(paramaymg);
    return a(((aymg)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqDataCard) | bool;
  }
  
  public String a_()
  {
    return "map_key_qqcircle";
  }
  
  public void c()
  {
    boolean bool = true;
    super.c();
    if (!QzoneConfig.isQQCircleShowProfileCardEntrance()) {
      QLog.d("ProfileCircleComponent", 4, "qqcircle profile card entrance is close");
    }
    do
    {
      do
      {
        return;
        if ((this.jdField_b_of_type_JavaLangObject != null) && (((aymg)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqDataCard != null)) {
          c(((aymg)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqDataCard.uin);
        }
      } while ((this.jdField_a_of_type_Boolean) || (this.jdField_b_of_type_JavaLangObject == null) || (((aymg)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqDataCard == null));
      if (((aymg)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqDataCard.switch_qqcircle != 1) {}
      for (;;)
      {
        QLog.d("ProfileCircleComponent", 4, "card switch_qqcircle: " + bool);
        if ((!bool) || (!a(((aymg)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqDataCard.uin))) {
          break;
        }
        a(((aymg)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqDataCard.uin);
        return;
        bool = false;
      }
    } while (!bool);
    b(((aymg)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqDataCard.uin);
  }
  
  public void d()
  {
    super.d();
    this.c = true;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void f()
  {
    super.f();
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilList = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayvm
 * JD-Core Version:    0.7.0.1
 */