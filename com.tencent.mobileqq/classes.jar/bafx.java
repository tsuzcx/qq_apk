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

public class bafx
  extends badd
{
  private float jdField_a_of_type_Float;
  private ColorDrawable jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
  private blhq jdField_a_of_type_Blhq;
  private volatile List<FeedCloudMeta.StFeed> jdField_a_of_type_JavaUtilList;
  private final AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private boolean jdField_a_of_type_Boolean;
  private volatile boolean b;
  private volatile boolean c = true;
  
  public bafx(baei parambaei, azxr paramazxr)
  {
    super(parambaei, paramazxr);
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
  
  private void a(azxr paramazxr, LayoutInflater paramLayoutInflater, QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources();
    int m = ((Resources)localObject1).getDimensionPixelSize(2131298272);
    int i = ((Resources)localObject1).getDimensionPixelSize(2131297482);
    int j = bhtq.b(30.0F);
    int n = (int)(this.jdField_a_of_type_Float - i - j);
    int i1 = (int)((n - m * 4) * 1.0F) / 5;
    int i2 = bhtq.b(75.0F);
    b(String.format(Locale.getDefault(), "doMakeOrRefreshQQCircle count:%s, photo:%s, margin:%s, max: %s", new Object[] { Integer.valueOf(this.jdField_a_of_type_JavaUtilList.size()), Integer.valueOf(i1), Integer.valueOf(m), Integer.valueOf(n) }));
    if ((paramazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a == 0) && ((LocalMultiProcConfig.getInt4Uin("qzone_feed_gray_mask", 1, paramQQAppInterface.getLongAccountUin()) & 0x4000) != 0))
    {
      paramazxr = paramLayoutInflater.inflate(2131561469, null);
      localObject1 = (LebaRoundLayout)paramazxr.findViewById(2131376962);
      ((LebaRoundLayout)localObject1).a = bhtq.b(4.0F);
      ((LebaRoundLayout)localObject1).setVisibility(0);
      if (ThemeUtil.isInNightMode(paramQQAppInterface)) {
        paramazxr.findViewById(2131363390).setBackgroundColor(Color.parseColor("#77F5F6FA"));
      }
      paramViewGroup.addView(paramazxr);
      localObject1 = paramazxr.getLayoutParams();
      if ((localObject1 instanceof LinearLayout.LayoutParams))
      {
        localObject1 = (LinearLayout.LayoutParams)localObject1;
        ((LinearLayout.LayoutParams)localObject1).width = i1;
        ((LinearLayout.LayoutParams)localObject1).height = i2;
        ((LinearLayout.LayoutParams)localObject1).rightMargin = m;
        paramazxr.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        paramazxr.setOnClickListener(new baga(this));
      }
      j = 0 + i1;
      i = j;
      if (this.jdField_b_of_type_Boolean)
      {
        vtq.a("", 3, 2, 1);
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
        Object localObject2 = paramLayoutInflater.inflate(2131561468, null);
        paramazxr = (LebaRoundLayout)((View)localObject2).findViewById(2131376962);
        paramazxr.a = bhtq.b(4.0F);
        paramazxr.setVisibility(0);
        ImageView localImageView = (ImageView)((View)localObject2).findViewById(2131368675);
        View localView = ((View)localObject2).findViewById(2131368677);
        paramazxr = ((View)localObject2).findViewById(2131368674);
        ((View)localObject2).findViewById(2131368676);
        localObject1 = (TextView)((View)localObject2).findViewById(2131368671);
        ((UnderlineTextView)((View)localObject2).findViewById(2131368670)).setEditableFactory(begz.a);
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
        localObject2 = paramazxr.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject2).width = i1;
        ((ViewGroup.LayoutParams)localObject2).height = i2;
        paramazxr.setLayoutParams((ViewGroup.LayoutParams)localObject2);
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
        paramazxr.setVisibility(8);
        ((TextView)localObject1).setVisibility(8);
      }
    }
  }
  
  private void a(String paramString)
  {
    paramString = new QCircleGetMainPageRequest(paramString, null, 3);
    paramString.setEnableCache(false);
    bafy localbafy = new bafy(this);
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true))
    {
      QLog.d("ProfileCircleComponent", 4, "makeOrRefreshQQCircle sendRequest");
      VSNetworkHelper.a().a(paramString, localbafy);
    }
  }
  
  private boolean a(Card paramCard)
  {
    if ((!QzoneConfig.isQQCircleShowProfileCardEntrance()) || (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity == null)) {
      return false;
    }
    QLog.d("ProfileCircleComponent", 4, "makeOrRefreshQQCircle start");
    long l = SystemClock.elapsedRealtime();
    boolean bool2 = false;
    if ((paramCard != null) && (paramCard.switch_qqcircle != 1))
    {
      bool1 = true;
      QLog.d("ProfileCircleComponent", 4, "makeOrRefreshQQCircle switch: " + bool1);
      if (bool1) {
        break label108;
      }
      if (this.jdField_a_of_type_JavaLangObject == null) {
        break label102;
      }
    }
    label102:
    for (boolean bool1 = true;; bool1 = false)
    {
      this.jdField_a_of_type_JavaLangObject = null;
      return bool1;
      bool1 = false;
      break;
    }
    label108:
    azxr localazxr = (azxr)this.jdField_b_of_type_JavaLangObject;
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    LayoutInflater localLayoutInflater = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    View localView2 = (View)this.jdField_a_of_type_JavaLangObject;
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = localLayoutInflater.inflate(2131561467, null);
      this.jdField_a_of_type_JavaLangObject = localView1;
    }
    localView2 = localView1.findViewById(2131364897);
    ViewGroup localViewGroup1 = (ViewGroup)localView1.findViewById(2131368672);
    ViewGroup localViewGroup2 = (ViewGroup)localView1.findViewById(2131368673);
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.isEmpty()))
    {
      localView2.setVisibility(8);
      localViewGroup1.setVisibility(8);
      localViewGroup2.setVisibility(8);
      a(paramCard.uin);
      return true;
    }
    TextView localTextView = (TextView)localView1.findViewById(2131378759);
    ImageView localImageView = (ImageView)localView1.findViewById(2131368360);
    if (localazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a != 0)
    {
      String str = ProfileCardMoreInfoView.a(localazxr);
      localTextView.setText(String.format(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131698536), new Object[] { str }));
    }
    localViewGroup1.removeAllViews();
    localViewGroup1.setVisibility(0);
    if ((localViewGroup2 != null) && (localViewGroup2.getVisibility() != 8))
    {
      localViewGroup2.removeAllViews();
      localViewGroup2.setVisibility(8);
    }
    bool1 = bool2;
    if (!this.jdField_a_of_type_JavaUtilList.isEmpty())
    {
      bool1 = true;
      a(localazxr, localLayoutInflater, localQQAppInterface, localViewGroup1);
    }
    localView1.setOnClickListener(new bafz(this, localazxr, paramCard, localQQAppInterface));
    localView1.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131698535));
    if (this.c)
    {
      vtq.a(paramCard.uin, 3, 1, 1);
      this.c = false;
    }
    a(localView1, localTextView, null, localImageView);
    localView2.setVisibility(0);
    localViewGroup1.setVisibility(0);
    localViewGroup2.setVisibility(0);
    QLog.d("ProfileCircleComponent", 4, "makeOrRefreshQQCircle end： " + (SystemClock.elapsedRealtime() - l));
    return bool1;
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
    this.jdField_a_of_type_Blhq = new blhq(Looper.getMainLooper(), null);
    paramBaseActivity = paramBaseActivity.getResources().getDisplayMetrics();
    this.jdField_a_of_type_Float = Math.min(paramBaseActivity.widthPixels, paramBaseActivity.heightPixels);
  }
  
  public boolean a(azxr paramazxr)
  {
    boolean bool = super.a(paramazxr);
    return a(((azxr)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqDataCard) | bool;
  }
  
  public String a_()
  {
    return "map_key_qqcircle";
  }
  
  public void c()
  {
    super.c();
    if (!this.jdField_a_of_type_Boolean)
    {
      if (QzoneConfig.isQQCircleShowProfileCardEntrance()) {
        break label27;
      }
      QLog.d("ProfileCircleComponent", 4, "qqcircle profile card entrance is close");
    }
    label27:
    while ((this.jdField_b_of_type_JavaLangObject == null) || (((azxr)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqDataCard == null)) {
      return;
    }
    if (((azxr)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqDataCard.switch_qqcircle != 1) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.d("ProfileCircleComponent", 4, "card switch_qqcircle: " + bool);
      if (!bool) {
        break;
      }
      a(((azxr)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqDataCard.uin);
      return;
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
 * Qualified Name:     bafx
 * JD-Core Version:    0.7.0.1
 */