import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.qqcircle.requests.QCircleGetMainPageRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.leba.widget.LebaRoundLayout;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.ProfileCardMoreInfoView;
import com.tencent.mobileqq.widget.UnderlineTextView;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.LocalMultiProcConfig;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StImage;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;

public class aznl
  extends azkr
{
  private float jdField_a_of_type_Float;
  private ColorDrawable jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
  private bkgm jdField_a_of_type_Bkgm;
  private volatile List<FeedCloudMeta.StFeed> jdField_a_of_type_JavaUtilList;
  private final AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private boolean jdField_a_of_type_Boolean;
  private volatile boolean b;
  private volatile boolean c = true;
  
  public aznl(azlw paramazlw, azfe paramazfe)
  {
    super(paramazlw, paramazfe);
    this.jdField_b_of_type_Boolean = true;
  }
  
  private void a(int paramInt1, int paramInt2, String paramString, ImageView paramImageView, View paramView, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable == null) {
      this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new ColorDrawable(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getColor(2131165712));
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
        localObject = ShortVideoUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramString, paramInt1, 0L);
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
  
  private void a(azfe paramazfe, LayoutInflater paramLayoutInflater, QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources();
    int m = ((Resources)localObject1).getDimensionPixelSize(2131298259);
    int i = ((Resources)localObject1).getDimensionPixelSize(2131297470);
    int j = bgtn.b(30.0F);
    int n = (int)(this.jdField_a_of_type_Float - i - j);
    int i1 = (int)((n - m * 4) * 1.0F) / 5;
    int i2 = bgtn.b(75.0F);
    b(String.format(Locale.getDefault(), "doMakeOrRefreshQQCircle count:%s, photo:%s, margin:%s, max: %s", new Object[] { Integer.valueOf(this.jdField_a_of_type_JavaUtilList.size()), Integer.valueOf(i1), Integer.valueOf(m), Integer.valueOf(n) }));
    if ((paramazfe.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a == 0) && ((LocalMultiProcConfig.getInt4Uin("qzone_feed_gray_mask", 1, paramQQAppInterface.getLongAccountUin()) & 0x4000) != 0))
    {
      paramazfe = paramLayoutInflater.inflate(2131561428, null);
      localObject1 = (LebaRoundLayout)paramazfe.findViewById(2131376825);
      ((LebaRoundLayout)localObject1).a = bgtn.b(4.0F);
      ((LebaRoundLayout)localObject1).setVisibility(0);
      if (ThemeUtil.isInNightMode(paramQQAppInterface)) {
        paramazfe.findViewById(2131363367).setBackgroundColor(Color.parseColor("#77F5F6FA"));
      }
      paramViewGroup.addView(paramazfe);
      localObject1 = paramazfe.getLayoutParams();
      if ((localObject1 instanceof LinearLayout.LayoutParams))
      {
        localObject1 = (LinearLayout.LayoutParams)localObject1;
        ((LinearLayout.LayoutParams)localObject1).width = i1;
        ((LinearLayout.LayoutParams)localObject1).height = i2;
        ((LinearLayout.LayoutParams)localObject1).rightMargin = m;
        paramazfe.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        paramazfe.setOnClickListener(new azno(this));
      }
      j = 0 + i1;
      i = j;
      if (this.jdField_b_of_type_Boolean)
      {
        vrf.a("", 3, 2, 1);
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
        Object localObject2 = paramLayoutInflater.inflate(2131561427, null);
        paramazfe = (LebaRoundLayout)((View)localObject2).findViewById(2131376825);
        paramazfe.a = bgtn.b(4.0F);
        paramazfe.setVisibility(0);
        ImageView localImageView = (ImageView)((View)localObject2).findViewById(2131368602);
        View localView = ((View)localObject2).findViewById(2131368604);
        paramazfe = ((View)localObject2).findViewById(2131368601);
        ((View)localObject2).findViewById(2131368603);
        localObject1 = (TextView)((View)localObject2).findViewById(2131368598);
        ((UnderlineTextView)((View)localObject2).findViewById(2131368597)).setEditableFactory(bdod.a);
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
        localObject2 = paramazfe.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject2).width = i1;
        ((ViewGroup.LayoutParams)localObject2).height = i2;
        paramazfe.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        k = i;
        if (i > 0) {
          k = i + m;
        }
        i = k + i1;
        if (i + i1 + m > n)
        {
          b(String.format(Locale.getDefault(), "doMakeOrRefreshQQCircle cur:%s, photo:%s, margin:%s, max: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(i1), Integer.valueOf(m), Integer.valueOf(n) }));
          return;
        }
        paramazfe.setVisibility(8);
        ((TextView)localObject1).setVisibility(8);
      }
    }
  }
  
  private void a(String paramString)
  {
    paramString = new QCircleGetMainPageRequest(paramString, null, 3);
    paramString.setEnableCache(false);
    aznm localaznm = new aznm(this);
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true))
    {
      QLog.d("ProfileCircleComponent", 4, "makeOrRefreshQQCircle sendRequest");
      VSNetworkHelper.a().a(paramString, localaznm);
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
    azfe localazfe = (azfe)this.jdField_b_of_type_JavaLangObject;
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    LayoutInflater localLayoutInflater = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.isEmpty()))
    {
      if (this.jdField_a_of_type_JavaLangObject != null) {}
      for (bool = true;; bool = false)
      {
        this.jdField_a_of_type_JavaLangObject = null;
        a(paramCard.uin);
        return bool;
      }
    }
    Object localObject2 = (View)this.jdField_a_of_type_JavaLangObject;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = localLayoutInflater.inflate(2131561426, null);
      this.jdField_a_of_type_JavaLangObject = localObject1;
    }
    localObject2 = (ViewGroup)((View)localObject1).findViewById(2131368599);
    ViewGroup localViewGroup = (ViewGroup)((View)localObject1).findViewById(2131368600);
    TextView localTextView = (TextView)((View)localObject1).findViewById(2131378600);
    ImageView localImageView = (ImageView)((View)localObject1).findViewById(2131368286);
    if (localazfe.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a != 0)
    {
      String str = ProfileCardMoreInfoView.a(localazfe);
      localTextView.setText(String.format(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131698432), new Object[] { str }));
    }
    ((ViewGroup)localObject2).removeAllViews();
    ((ViewGroup)localObject2).setVisibility(0);
    if ((localViewGroup != null) && (localViewGroup.getVisibility() != 8))
    {
      localViewGroup.removeAllViews();
      localViewGroup.setVisibility(8);
    }
    if (!this.jdField_a_of_type_JavaUtilList.isEmpty()) {
      a(localazfe, localLayoutInflater, localQQAppInterface, (ViewGroup)localObject2);
    }
    for (bool = true;; bool = false)
    {
      ((View)localObject1).setOnClickListener(new aznn(this, localazfe, paramCard, localQQAppInterface));
      ((View)localObject1).setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131698431));
      if (this.c)
      {
        vrf.a(paramCard.uin, 3, 1, 1);
        this.c = false;
      }
      a((View)localObject1, localTextView, null, localImageView);
      QLog.d("ProfileCircleComponent", 4, "makeOrRefreshQQCircle end： " + (SystemClock.elapsedRealtime() - l));
      return bool;
    }
  }
  
  private static void b(String paramString)
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
  
  public void a(@NonNull BaseActivity paramBaseActivity, @Nullable Bundle paramBundle)
  {
    super.a(paramBaseActivity, paramBundle);
    this.jdField_a_of_type_Bkgm = new bkgm(Looper.getMainLooper(), null);
    paramBaseActivity = paramBaseActivity.getResources().getDisplayMetrics();
    this.jdField_a_of_type_Float = Math.min(paramBaseActivity.widthPixels, paramBaseActivity.heightPixels);
  }
  
  public boolean a(azfe paramazfe)
  {
    boolean bool = super.a(paramazfe);
    return a(((azfe)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqDataCard) | bool;
  }
  
  public String a_()
  {
    return "map_key_qqcircle";
  }
  
  public void c()
  {
    super.c();
    if ((!this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_JavaLangObject != null) && (((azfe)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqDataCard != null)) {
      a(((azfe)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqDataCard.uin);
    }
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
 * Qualified Name:     aznl
 * JD-Core Version:    0.7.0.1
 */