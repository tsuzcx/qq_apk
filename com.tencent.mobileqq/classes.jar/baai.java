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
import qqcircle.QQCircleFeedBase.StPageRedPointInfo;
import qqcircle.QQCircleFeedBase.StQQProfilePointInfo;

public class baai
  extends azwo
{
  private static long jdField_a_of_type_Long;
  private static LruCache<String, baam> jdField_a_of_type_AndroidUtilLruCache;
  private float jdField_a_of_type_Float;
  private ColorDrawable jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
  private bkys jdField_a_of_type_Bkys;
  private String jdField_a_of_type_JavaLangString;
  private volatile List<FeedCloudMeta.StFeed> jdField_a_of_type_JavaUtilList;
  private final AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private volatile boolean jdField_a_of_type_Boolean = true;
  private String jdField_b_of_type_JavaLangString;
  private volatile boolean jdField_b_of_type_Boolean = true;
  
  public baai(azxt paramazxt, azrb paramazrb)
  {
    super(paramazxt, paramazrb);
    if (jdField_a_of_type_AndroidUtilLruCache == null) {
      jdField_a_of_type_AndroidUtilLruCache = new LruCache(5);
    }
  }
  
  private void a(int paramInt1, int paramInt2, String paramString, ImageView paramImageView, View paramView, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable == null) {
      this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new ColorDrawable(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getColor(2131165729));
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
  
  private void a(azrb paramazrb, LayoutInflater paramLayoutInflater, QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources();
    int m = ((Resources)localObject1).getDimensionPixelSize(2131298340);
    int i = ((Resources)localObject1).getDimensionPixelSize(2131297538);
    int j = ViewUtils.dpToPx(30.0F);
    int n = (int)(this.jdField_a_of_type_Float - i - j);
    int i1 = (int)((n - m * 4) * 1.0F) / 5;
    int i2 = ViewUtils.dpToPx(75.0F);
    c(String.format(Locale.getDefault(), "doMakeOrRefreshQQCircle count:%s, photo:%s, margin:%s, max: %s", new Object[] { Integer.valueOf(this.jdField_a_of_type_JavaUtilList.size()), Integer.valueOf(i1), Integer.valueOf(m), Integer.valueOf(n) }));
    if ((paramazrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a == 0) && ((LocalMultiProcConfig.getInt4Uin("qzone_feed_gray_mask", 1, paramQQAppInterface.getLongAccountUin()) & 0x4000) != 0))
    {
      paramazrb = paramLayoutInflater.inflate(2131561415, null);
      localObject1 = (LebaRoundLayout)paramazrb.findViewById(2131376984);
      ((LebaRoundLayout)localObject1).a = ViewUtils.dpToPx(4.0F);
      ((LebaRoundLayout)localObject1).setVisibility(0);
      if (ThemeUtil.isInNightMode(paramQQAppInterface)) {
        paramazrb.findViewById(2131363486).setBackgroundColor(Color.parseColor("#77F5F6FA"));
      }
      paramViewGroup.addView(paramazrb);
      localObject1 = paramazrb.getLayoutParams();
      if ((localObject1 instanceof LinearLayout.LayoutParams))
      {
        localObject1 = (LinearLayout.LayoutParams)localObject1;
        ((LinearLayout.LayoutParams)localObject1).width = i1;
        ((LinearLayout.LayoutParams)localObject1).height = i2;
        ((LinearLayout.LayoutParams)localObject1).rightMargin = m;
        paramazrb.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        paramazrb.setOnClickListener(new baak(this));
      }
      j = 0 + i1;
      i = j;
      if (this.jdField_a_of_type_Boolean)
      {
        QCircleLpReportDc05504.report("", 3, 2, 1);
        this.jdField_a_of_type_Boolean = false;
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
        Object localObject2 = paramLayoutInflater.inflate(2131561414, null);
        paramazrb = (LebaRoundLayout)((View)localObject2).findViewById(2131376984);
        paramazrb.a = ViewUtils.dpToPx(4.0F);
        paramazrb.setVisibility(0);
        ImageView localImageView = (ImageView)((View)localObject2).findViewById(2131368858);
        View localView = ((View)localObject2).findViewById(2131368860);
        paramazrb = ((View)localObject2).findViewById(2131368857);
        ((View)localObject2).findViewById(2131368859);
        localObject1 = (TextView)((View)localObject2).findViewById(2131368854);
        ((UnderlineTextView)((View)localObject2).findViewById(2131368853)).setEditableFactory(QQTextBuilder.EMOCTATION_FACORY);
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
        localObject2 = paramazrb.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject2).width = i1;
        ((ViewGroup.LayoutParams)localObject2).height = i2;
        paramazrb.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        k = i;
        if (i > 0) {
          k = i + m;
        }
        i = k + i1;
        if (i + i1 + m > n)
        {
          c(String.format(Locale.getDefault(), "doMakeOrRefreshQQCircle cur:%s, photo:%s, margin:%s, max: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(i1), Integer.valueOf(m), Integer.valueOf(n) }));
          return;
        }
        paramazrb.setVisibility(8);
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
    label189:
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
          a((QQCircleFeedBase.StPageRedPointInfo)localStMainPageBusiRspData.RedPointInfo.get());
          paramStGetMainPageRsp = new StringBuilder();
          if (l2 != 0L) {
            paramStGetMainPageRsp.append(String.format(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131699108), new Object[] { QCircleCommonUtil.fansNumberFormatTranfer(l2) }));
          }
          if (l1 != 0L)
          {
            if (l2 != 0L) {
              paramStGetMainPageRsp.append("  ");
            }
            paramStGetMainPageRsp.append(String.format(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131699109), new Object[] { QCircleCommonUtil.fansNumberFormatTranfer(l1) }));
          }
          this.jdField_b_of_type_JavaLangString = paramStGetMainPageRsp.toString();
          return;
        }
        catch (Exception paramStGetMainPageRsp)
        {
          break label189;
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
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true))
    {
      QLog.d("ProfileCircleComponent", 4, "makeOrRefreshQQCircle sendRequest");
      VSNetworkHelper.getInstance().sendRequest(paramString, new baal(this));
    }
  }
  
  private void a(QQCircleFeedBase.StPageRedPointInfo paramStPageRedPointInfo)
  {
    if ((this.jdField_b_of_type_JavaLangObject != null) && (((azrb)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqDataCard != null)) {}
    for (String str = ((azrb)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqDataCard.uin;; str = "")
    {
      if (paramStPageRedPointInfo != null) {}
      for (;;)
      {
        try
        {
          if (paramStPageRedPointInfo.redTotalNum.get() > 0)
          {
            if (!TextUtils.isEmpty(paramStPageRedPointInfo.qqProfileInfo.txt.get()))
            {
              this.jdField_a_of_type_JavaLangString = paramStPageRedPointInfo.qqProfileInfo.txt.get();
              if (this.jdField_b_of_type_Boolean)
              {
                if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
                  break label139;
                }
                QCircleLpReportDc05504.report(str, 3, 1, 3);
                this.jdField_b_of_type_Boolean = false;
              }
              return;
            }
            this.jdField_a_of_type_JavaLangString = "";
            continue;
          }
        }
        catch (Exception paramStPageRedPointInfo)
        {
          this.jdField_a_of_type_JavaLangString = "";
          continue;
        }
        this.jdField_a_of_type_JavaLangString = "";
        continue;
        label139:
        QCircleLpReportDc05504.report(str, 3, 1, 1);
      }
    }
  }
  
  private boolean a(String paramString)
  {
    return true;
  }
  
  private void b(String paramString)
  {
    if ((jdField_a_of_type_AndroidUtilLruCache.get(paramString) == null) || (((baam)jdField_a_of_type_AndroidUtilLruCache.get(paramString)).a() == null)) {
      a(paramString);
    }
    List localList;
    do
    {
      return;
      paramString = ((baam)jdField_a_of_type_AndroidUtilLruCache.get(paramString)).a();
      QLog.d("ProfileCircleComponent", 1, "Using cache update QCirlce ProfileCard");
      localList = paramString.vecFeed.get();
      a(paramString);
    } while ((localList == null) || (localList.size() <= 0));
    this.jdField_a_of_type_JavaUtilList = localList;
    a(((azrb)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqDataCard);
  }
  
  private static void c(String paramString)
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
  
  public String a(azrb paramazrb)
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
        str = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131699106);
        localObject = str;
      } while (paramazrb == null);
      localObject = str;
    } while (paramazrb.jdField_a_of_type_ComTencentMobileqqDataCard == null);
    if (paramazrb.jdField_a_of_type_ComTencentMobileqqDataCard.shGender == 1) {
      return this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131699105);
    }
    return this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131699106);
  }
  
  public void a(@NonNull BaseActivity paramBaseActivity, @Nullable Bundle paramBundle)
  {
    super.a(paramBaseActivity, paramBundle);
    this.jdField_a_of_type_Bkys = new bkys(Looper.getMainLooper(), null);
    paramBaseActivity = paramBaseActivity.getResources().getDisplayMetrics();
    this.jdField_a_of_type_Float = Math.min(paramBaseActivity.widthPixels, paramBaseActivity.heightPixels);
  }
  
  public boolean a(azrb paramazrb)
  {
    boolean bool = super.a(paramazrb);
    return a(((azrb)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqDataCard) | bool;
  }
  
  public boolean a(Card paramCard)
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
    azrb localazrb = (azrb)this.jdField_b_of_type_JavaLangObject;
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    LayoutInflater localLayoutInflater = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    Object localObject2 = (View)this.jdField_a_of_type_JavaLangObject;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = localLayoutInflater.inflate(2131561413, null);
      this.jdField_a_of_type_JavaLangObject = localObject1;
    }
    View localView = ((View)localObject1).findViewById(2131365012);
    ViewGroup localViewGroup1 = (ViewGroup)((View)localObject1).findViewById(2131368855);
    ViewGroup localViewGroup2 = (ViewGroup)((View)localObject1).findViewById(2131368856);
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.isEmpty()))
    {
      localView.setVisibility(8);
      localViewGroup1.setVisibility(8);
      localViewGroup2.setVisibility(8);
      return true;
    }
    TextView localTextView1 = (TextView)((View)localObject1).findViewById(2131378815);
    ImageView localImageView1 = (ImageView)((View)localObject1).findViewById(2131368602);
    ImageView localImageView2 = (ImageView)((View)localObject1).findViewById(2131368541);
    TextView localTextView2 = (TextView)((View)localObject1).findViewById(2131378723);
    FrameLayout localFrameLayout = (FrameLayout)((View)localObject1).findViewById(2131366883);
    localTextView1.setMaxWidth(2147483647);
    if (localazrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a != 0)
    {
      String str = a(localazrb);
      localObject2 = String.format(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131699107), new Object[] { str });
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
      {
        if ((ViewUtils.getTextWidth(localTextView1.getPaint(), (CharSequence)localObject2) <= ViewUtils.dpToPx(170.0F)) || (str.length() <= 7)) {
          break label731;
        }
        localObject2 = str.substring(0, 7) + "...";
        localObject2 = String.format(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131699107), new Object[] { localObject2 });
      }
    }
    label731:
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
        a(localazrb, localLayoutInflater, localQQAppInterface, localViewGroup1);
      }
      for (;;)
      {
        ((View)localObject1).setOnClickListener(new baaj(this, localazrb, paramCard, localQQAppInterface));
        ((View)localObject1).setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131699104));
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
      } while ((this.jdField_b_of_type_JavaLangObject == null) || (((azrb)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqDataCard == null));
      if (((azrb)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqDataCard.switch_qqcircle != 1) {}
      for (;;)
      {
        QLog.d("ProfileCircleComponent", 4, "card switch_qqcircle: " + bool);
        if ((!bool) || (!a(((azrb)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqDataCard.uin))) {
          break;
        }
        a(((azrb)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqDataCard.uin);
        return;
        bool = false;
      }
    } while (!bool);
    b(((azrb)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqDataCard.uin);
  }
  
  public void d()
  {
    super.d();
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
 * Qualified Name:     baai
 * JD-Core Version:    0.7.0.1
 */