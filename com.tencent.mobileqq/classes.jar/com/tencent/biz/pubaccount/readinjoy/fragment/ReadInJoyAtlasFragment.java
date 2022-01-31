package com.tencent.biz.pubaccount.readinjoy.fragment;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.nineoldandroids.animation.ValueAnimator;
import com.nineoldandroids.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.common.GalleryReportedUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyAtlasViewPagerAdapter;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyAtlasViewPagerAdapter.OnChildGalleryEventListener;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyConstants;
import com.tencent.biz.pubaccount.readinjoy.logic.ReadInJoyAtlasManager;
import com.tencent.biz.pubaccount.readinjoy.logic.ReadInJoyAtlasManager.AtlasCallback;
import com.tencent.biz.pubaccount.readinjoy.model.AtlasModel;
import com.tencent.biz.pubaccount.readinjoy.model.AtlasModelImage;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyAllInOneBar;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyAllInOneBar.OnAllInOnEventListener;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyAtlasViewPager;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyAtlasViewPager.PageItemScrollListener;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoySwipeView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoySwipeView.OnSlidingFinishListener;
import com.tencent.biz.pubaccount.readinjoy.view.VariableSizeTextView;
import com.tencent.biz.pubaccount.readinjoy.view.VariableSizeTextView.OnSizeChangedListener;
import com.tencent.biz.pubaccount.util.GalleryShareHelper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.util.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.immersive.SystemBarCompact;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import lnc;
import lnd;
import lne;
import lnf;
import lng;
import lnh;
import lni;
import lnj;
import lnk;
import lnl;
import lnm;
import lnn;
import lno;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.gallery.gallery.GalleryInfo;
import tencent.im.oidb.gallery.gallery.PictureInfo;
import tencent.im.oidb.gallery.gallery_report.OnePicReported;

public class ReadInJoyAtlasFragment
  extends PublicBaseFragment
  implements View.OnClickListener, FaceDecoder.DecodeTaskCompletionListener
{
  public static final String a;
  protected static final List a;
  public int a;
  private long jdField_a_of_type_Long;
  protected final AnimatorSet a;
  private FragmentActivity jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
  ViewPager.OnPageChangeListener jdField_a_of_type_AndroidSupportV4ViewViewPager$OnPageChangeListener = new lnm(this);
  public View a;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  public TextView a;
  ValueAnimator.AnimatorUpdateListener jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator$AnimatorUpdateListener = new lnl(this);
  ReadInJoyAtlasViewPagerAdapter.OnChildGalleryEventListener jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonReadInJoyAtlasViewPagerAdapter$OnChildGalleryEventListener = new lno(this);
  public ReadInJoyAtlasViewPagerAdapter a;
  private ReadInJoyAtlasFragment.ReportEventListener jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyAtlasFragment$ReportEventListener = new lng(this);
  public ReadInJoyAtlasManager.AtlasCallback a;
  ReadInJoyAllInOneBar.OnAllInOnEventListener jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyAllInOneBar$OnAllInOnEventListener = new lnc(this);
  public ReadInJoyAllInOneBar a;
  ReadInJoyAtlasViewPager.PageItemScrollListener jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyAtlasViewPager$PageItemScrollListener = new lnd(this);
  public ReadInJoyAtlasViewPager a;
  ReadInJoySwipeView.OnSlidingFinishListener jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySwipeView$OnSlidingFinishListener = new lnn(this);
  ReadInJoySwipeView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySwipeView;
  private VariableSizeTextView.OnSizeChangedListener jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVariableSizeTextView$OnSizeChangedListener = new lnf(this);
  public VariableSizeTextView a;
  public URLImageView a;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private FaceDecoder jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder;
  private gallery.GalleryInfo jdField_a_of_type_TencentImOidbGalleryGallery$GalleryInfo;
  public boolean a;
  private int jdField_b_of_type_Int = 1;
  private long jdField_b_of_type_Long;
  public View b;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  private String jdField_b_of_type_JavaLangString;
  private List jdField_b_of_type_JavaUtilList;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private long jdField_c_of_type_Long;
  protected View c;
  private String jdField_c_of_type_JavaLangString = "";
  private List jdField_c_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_c_of_type_Boolean = true;
  private int jdField_d_of_type_Int;
  private long jdField_d_of_type_Long;
  protected View d;
  private String jdField_d_of_type_JavaLangString;
  private List jdField_d_of_type_JavaUtilList = new ArrayList();
  private int jdField_e_of_type_Int = 99;
  protected View e;
  private String jdField_e_of_type_JavaLangString;
  private int jdField_f_of_type_Int;
  View jdField_f_of_type_AndroidViewView;
  private String jdField_f_of_type_JavaLangString;
  private int jdField_g_of_type_Int;
  private String jdField_g_of_type_JavaLangString;
  private String h;
  
  static
  {
    jdField_a_of_type_JavaLangString = "Q.readinjoy.atlas.." + ReadInJoyAtlasFragment.class.getSimpleName();
    jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public ReadInJoyAtlasFragment()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicReadInJoyAtlasManager$AtlasCallback = new lnh(this);
    this.jdField_a_of_type_AndroidAnimationAnimatorSet = new AnimatorSet();
  }
  
  private CharSequence a(AtlasModel paramAtlasModel)
  {
    if ((paramAtlasModel instanceof AtlasModelImage)) {
      return new SpannableString(((AtlasModelImage)paramAtlasModel).pictureInfo.bytes_pic_desc.get().toStringUtf8());
    }
    return "";
  }
  
  private String a()
  {
    if ((this.jdField_d_of_type_JavaUtilList == null) || (this.jdField_d_of_type_JavaUtilList.size() == 0)) {
      return "";
    }
    JSONArray localJSONArray = new JSONArray();
    int i = 0;
    for (;;)
    {
      if (i < this.jdField_d_of_type_JavaUtilList.size())
      {
        AtlasModel localAtlasModel = (AtlasModel)this.jdField_d_of_type_JavaUtilList.get(i);
        JSONObject localJSONObject = new JSONObject();
        try
        {
          localJSONObject.put("index", localAtlasModel.position + "");
          localJSONObject.put("come_in_time", localAtlasModel.modelEnterTime + "");
          localJSONObject.put("load_completed_time", localAtlasModel.modelImageShowTime + "");
          localJSONObject.put("go_away_time", localAtlasModel.modelExitTime + "");
          localJSONObject.put("pic_type", localAtlasModel.picType + "");
          localJSONArray.put(localJSONObject);
          i += 1;
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.d(jdField_a_of_type_JavaLangString, 2, "addReadRecord:" + localJSONException.toString());
            }
          }
        }
      }
    }
    return localJSONArray.toString();
  }
  
  private String a(List paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131438672);
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = ((AtlasModelImage)paramList.next()).pictureInfo.bytes_pic_desc.get().toStringUtf8();
      if (!TextUtils.isEmpty(str)) {
        return str;
      }
    }
    return "点击查看图集";
  }
  
  public static void a(Context paramContext, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("rowkey", paramString);
    localIntent.putExtra("start_index", paramInt1);
    localIntent.putExtra("bundle_key_source", paramInt2);
    localIntent.putExtra("public_fragment_window_feature", 1);
    PublicTransFragmentActivity.b(paramContext, localIntent, ReadInJoyAtlasFragment.class);
  }
  
  public static void a(Context paramContext, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong, int paramInt5)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("rowkey", paramString);
    localIntent.putExtra("start_index", paramInt1);
    localIntent.putExtra("bundle_key_activity_exit_type", paramInt2);
    localIntent.putExtra("bundle_key_source", paramInt3);
    localIntent.putExtra("bundle_key_position", paramInt4);
    localIntent.putExtra("BUNDLE_KEY_STRATEGY_ID", paramLong);
    localIntent.putExtra("BUNDLE_KEY_HAS_READED", paramInt5);
    localIntent.putExtra("public_fragment_window_feature", 1);
    PublicTransFragmentActivity.b(paramContext, localIntent, ReadInJoyAtlasFragment.class);
  }
  
  public static void a(Context paramContext, String paramString, int paramInt1, int paramInt2, int paramInt3, long paramLong, int paramInt4)
  {
    a(paramContext, paramString, paramInt1, 0, paramInt2, paramInt3, paramLong, paramInt4);
  }
  
  public static void a(Context paramContext, String paramString, int paramInt1, int paramInt2, long paramLong, int paramInt3)
  {
    a(paramContext, paramString, 0, 0, paramInt1, paramInt2, paramLong, paramInt3);
  }
  
  private void a(AtlasModel paramAtlasModel)
  {
    if (paramAtlasModel == null) {
      return;
    }
    this.jdField_d_of_type_JavaUtilList.add(paramAtlasModel);
    gallery_report.OnePicReported localOnePicReported = new gallery_report.OnePicReported();
    localOnePicReported.index.set(paramAtlasModel.position);
    localOnePicReported.come_in_time.set(paramAtlasModel.modelEnterTime);
    localOnePicReported.load_completed_time.set(paramAtlasModel.modelImageShowTime);
    localOnePicReported.go_away_time.set(paramAtlasModel.modelExitTime);
    localOnePicReported.pic_type.set(paramAtlasModel.picType);
    this.jdField_c_of_type_JavaUtilList.add(localOnePicReported);
  }
  
  private void a(String paramString)
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, null);
    localActionSheet.a(2131435854, 1);
    localActionSheet.a(2131435860, 1);
    localActionSheet.c(2131432998);
    localActionSheet.a(new lne(this, localActionSheet, paramString));
    localActionSheet.show();
  }
  
  private void h()
  {
    this.jdField_d_of_type_JavaUtilList.clear();
    this.jdField_c_of_type_JavaUtilList.clear();
  }
  
  public void a(int paramInt)
  {
    a(paramInt, null);
  }
  
  public void a(int paramInt, String paramString)
  {
    this.jdField_b_of_type_Int = paramInt;
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      c();
      a(false, paramString);
      b(1);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVariableSizeTextView.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyAllInOneBar.setVisibility(0);
      return;
    case 2: 
      a(false, paramString);
      b(1);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVariableSizeTextView.setVisibility(8);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyAllInOneBar.setVisibility(0);
      b();
      return;
    }
    c();
    a(true, paramString);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVariableSizeTextView.setVisibility(8);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyAllInOneBar.setVisibility(0);
    b(1);
  }
  
  public void a(Activity paramActivity)
  {
    paramActivity.getWindow().addFlags(1024);
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (paramBoolean)
    {
      if (!TextUtils.isEmpty(paramString)) {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(paramString);
      }
      for (;;)
      {
        this.jdField_f_of_type_AndroidViewView.setVisibility(0);
        return;
        this.jdField_b_of_type_AndroidWidgetTextView.setText("系统开了个小差，请点击重新加载.");
      }
    }
    this.jdField_f_of_type_AndroidViewView.setVisibility(8);
  }
  
  public void b()
  {
    Object localObject = this.jdField_a_of_type_AndroidWidgetImageView.getDrawable();
    if ((localObject instanceof Animatable))
    {
      localObject = (Animatable)localObject;
      if (!((Animatable)localObject).isRunning())
      {
        ((Animatable)localObject).start();
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      }
    }
  }
  
  public void b(int paramInt)
  {
    if (paramInt == 1)
    {
      if (this.jdField_a_of_type_AndroidViewView.getVisibility() != 0) {
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      }
      if (this.jdField_b_of_type_AndroidViewView.getVisibility() != 8) {
        this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      }
    }
    do
    {
      do
      {
        do
        {
          return;
          if (paramInt != 2) {
            break;
          }
          if (this.jdField_a_of_type_AndroidViewView.getVisibility() != 8) {
            this.jdField_a_of_type_AndroidViewView.setVisibility(8);
          }
        } while (this.jdField_b_of_type_AndroidViewView.getVisibility() == 0);
        this.jdField_b_of_type_AndroidViewView.setVisibility(0);
        return;
      } while (paramInt != 0);
      if (this.jdField_a_of_type_AndroidViewView.getVisibility() != 8) {
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      }
    } while (this.jdField_b_of_type_AndroidViewView.getVisibility() == 8);
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
  }
  
  public void c()
  {
    Object localObject = this.jdField_a_of_type_AndroidWidgetImageView.getDrawable();
    if ((localObject instanceof Animatable))
    {
      localObject = (Animatable)localObject;
      if (((Animatable)localObject).isRunning()) {
        ((Animatable)localObject).stop();
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
  }
  
  public boolean c()
  {
    return false;
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyAtlasViewPager.getChildCount() > 0)
    {
      ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.2F, 1.0F });
      View localView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyAtlasViewPager.getChildAt(0);
      localValueAnimator.addUpdateListener(new lni(this, localView));
      localValueAnimator.setDuration(300L);
      localValueAnimator.setTarget(localView);
      localValueAnimator.start();
    }
  }
  
  public boolean d()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyAtlasViewPager != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyAtlasViewPager.getCurrentItem() == 0))
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("exitType", 3);
      localBundle.putSerializable("lastShowImageModel", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonReadInJoyAtlasViewPagerAdapter.a());
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyAtlasFragment$ReportEventListener.a(-2, localBundle);
    }
    return false;
  }
  
  public void e()
  {
    Object localObject1 = jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (WeakReference)((Iterator)localObject1).next();
      if (((((WeakReference)localObject2).get() instanceof ReadInJoyAtlasFragment)) && (((ReadInJoyAtlasFragment)((WeakReference)localObject2).get()).jdField_a_of_type_AndroidSupportV4AppFragmentActivity != null))
      {
        if (((WeakReference)localObject2).get() != this) {
          ((ReadInJoyAtlasFragment)((WeakReference)localObject2).get()).jdField_a_of_type_AndroidSupportV4AppFragmentActivity.finish();
        }
      }
      else {
        ((Iterator)localObject1).remove();
      }
    }
    localObject1 = ObjectAnimator.ofFloat(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySwipeView, "scaleX", new float[] { 0.0F });
    Object localObject2 = ObjectAnimator.ofFloat(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySwipeView, "scaleY", new float[] { 0.0F });
    ((ObjectAnimator)localObject1).setDuration(400L);
    ((ObjectAnimator)localObject2).setDuration(400L);
    this.jdField_a_of_type_AndroidAnimationAnimatorSet.cancel();
    this.jdField_a_of_type_AndroidAnimationAnimatorSet.play((Animator)localObject1).with((Animator)localObject2);
    ((ObjectAnimator)localObject1).addUpdateListener(new lnk(this));
    this.jdField_a_of_type_AndroidAnimationAnimatorSet.setTarget(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySwipeView);
    this.jdField_a_of_type_AndroidAnimationAnimatorSet.start();
  }
  
  public void f()
  {
    this.jdField_a_of_type_Boolean = true;
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.99F, 0.0F });
    localValueAnimator.setDuration(500L);
    localValueAnimator.addUpdateListener(this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator$AnimatorUpdateListener);
    localValueAnimator.start();
  }
  
  public void g()
  {
    this.jdField_a_of_type_Boolean = false;
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.01F, 1.0F });
    localValueAnimator.setDuration(500L);
    localValueAnimator.addUpdateListener(this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator$AnimatorUpdateListener);
    localValueAnimator.start();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 == -1) {
      if (paramInt1 == 1)
      {
        localIntent = AIOUtils.a(new Intent(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, SplashActivity.class), null);
        if (paramIntent != null)
        {
          localIntent.putExtras(new Bundle(paramIntent.getExtras()));
          this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.startActivity(localIntent);
        }
      }
    }
    while ((paramInt2 != 0) || (paramInt1 != 6001))
    {
      do
      {
        Intent localIntent;
        do
        {
          return;
        } while (paramInt1 == 6002);
        if (paramInt1 == 6001)
        {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyAllInOneBar.a(paramInt2, paramIntent, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), this.jdField_a_of_type_Long, this.jdField_b_of_type_JavaLangString, this.jdField_d_of_type_Int);
          return;
        }
      } while (paramInt1 != 6003);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyAllInOneBar.a();
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyAllInOneBar.a(paramInt2, paramIntent, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), this.jdField_a_of_type_Long, this.jdField_b_of_type_JavaLangString, this.jdField_d_of_type_Int);
  }
  
  public void onClick(View paramView)
  {
    Object localObject;
    switch (paramView.getId())
    {
    default: 
    case 2131366877: 
    case 2131363985: 
    case 2131363986: 
      do
      {
        do
        {
          return;
        } while (this.jdField_b_of_type_Int == 4);
        a(2);
        if (NetworkUtil.g(getActivity()))
        {
          ReadInJoyAtlasManager.a().a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicReadInJoyAtlasManager$AtlasCallback);
          return;
        }
        ThreadManager.getUIHandler().postDelayed(new lnj(this), 400L);
        return;
      } while (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString));
      localObject = new Intent(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, QQBrowserActivity.class);
      ((Intent)localObject).putExtra("url", ReadInJoyConstants.i + Base64Util.encodeToString(this.jdField_c_of_type_JavaLangString.getBytes(), 2));
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.startActivity((Intent)localObject);
      i = 0;
      if (paramView.getId() == 2131363986) {
        i = 1;
      }
      paramView = GalleryReportedUtils.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), this.jdField_d_of_type_Int, this.jdField_a_of_type_Long, this.jdField_b_of_type_JavaLangString, i);
      PublicAccountReportUtils.a(null, "", "0X8008E31", "0X8008E31", 0, 0, "", this.jdField_a_of_type_Long + "", this.jdField_c_of_type_Long + "", paramView, false);
      return;
    case 2131363983: 
      paramView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonReadInJoyAtlasViewPagerAdapter.a();
      if (paramView != null)
      {
        paramView.modelExitTime = System.currentTimeMillis();
        localObject = new Bundle();
        ((Bundle)localObject).putInt("exitType", 0);
        ((Bundle)localObject).putSerializable("lastShowImageModel", paramView);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyAtlasFragment$ReportEventListener.a(-2, (Bundle)localObject);
      }
    case 2131363989: 
      e();
      return;
    }
    if (this.jdField_f_of_type_Int < this.jdField_b_of_type_Long - 1L) {}
    for (int i = 2;; i = 1)
    {
      new GalleryShareHelper(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity).a(this.jdField_a_of_type_TencentImOidbGalleryGallery$GalleryInfo, this.jdField_g_of_type_JavaLangString, this.jdField_c_of_type_Long, this.jdField_e_of_type_Int, i, this.h, this.jdField_d_of_type_Int, a(this.jdField_b_of_type_JavaUtilList), "mqqapi://readinjoy/openatlas?src_type=internal&version=1&rowkey=" + this.jdField_b_of_type_JavaLangString, this.jdField_f_of_type_JavaLangString, ReadInJoyConstants.i + Base64.encodeToString(this.jdField_c_of_type_JavaLangString.getBytes(), 0), "http://s.p.qq.com/pub/get_face_https?img_type=3&uin=" + this.jdField_c_of_type_JavaLangString);
      PublicAccountReportUtils.a(null, "", "0X8008E33", "0X8008E33", 0, 0, "", "", "", GalleryReportedUtils.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), this.jdField_d_of_type_Int, this.jdField_a_of_type_Long, this.jdField_b_of_type_JavaLangString), false);
      return;
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = getActivity();
    jdField_a_of_type_JavaUtilList.add(new WeakReference(this));
    paramLayoutInflater = paramLayoutInflater.inflate(2130969545, paramViewGroup, false);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = new FaceDecoder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(this);
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getWindow().getDecorView().setBackgroundDrawable(new ColorDrawable(0));
    if (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.mSystemBarComp == null)
    {
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.setImmersiveStatus(0);
      this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getStringExtra("rowkey");
      this.jdField_c_of_type_Int = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getIntExtra("start_index", 0);
      this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getIntExtra("bundle_key_activity_exit_type", 0);
      this.jdField_d_of_type_Int = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getIntExtra("bundle_key_source", 0);
      this.jdField_e_of_type_Int = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getIntExtra("bundle_key_position", 99);
      this.jdField_c_of_type_Long = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getLongExtra("BUNDLE_KEY_STRATEGY_ID", 0L);
      this.jdField_g_of_type_Int = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getIntExtra("BUNDLE_KEY_HAS_READED", 0);
      this.jdField_d_of_type_Long = System.currentTimeMillis();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySwipeView = ((ReadInJoySwipeView)paramLayoutInflater.findViewById(2131362693));
      this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.findViewById(2131366881);
      this.jdField_b_of_type_AndroidViewView = paramLayoutInflater.findViewById(2131366882);
      b(0);
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramLayoutInflater.findViewById(2131361845));
      this.jdField_f_of_type_AndroidViewView = paramLayoutInflater.findViewById(2131366877);
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131366878));
      this.jdField_f_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_c_of_type_AndroidViewView = paramLayoutInflater.findViewById(2131363983);
      this.jdField_d_of_type_AndroidViewView = paramLayoutInflater.findViewById(2131363989);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131363986));
      this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramLayoutInflater.findViewById(2131363985));
      this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(ImageUtil.b());
      this.jdField_e_of_type_AndroidViewView = paramLayoutInflater.findViewById(2131363988);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyAllInOneBar = ((ReadInJoyAllInOneBar)paramLayoutInflater.findViewById(2131366879));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyAllInOneBar.setVisibility(4);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyAllInOneBar.setOnAllInOneEventListener(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyAllInOneBar$OnAllInOnEventListener);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVariableSizeTextView = ((VariableSizeTextView)paramLayoutInflater.findViewById(2131366880));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVariableSizeTextView.setVisibility(4);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVariableSizeTextView.setOnSizeChangedListener(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVariableSizeTextView$OnSizeChangedListener);
      this.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_d_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentImageURLImageView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_e_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyAtlasViewPager = ((ReadInJoyAtlasViewPager)paramLayoutInflater.findViewById(2131363096));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyAtlasViewPager.setmDirectionMask(11);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyAtlasViewPager.setOffscreenPageLimit(2);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyAtlasViewPager.setOnPageChangeListener(this.jdField_a_of_type_AndroidSupportV4ViewViewPager$OnPageChangeListener);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySwipeView.setOnSlidingFinishListener(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySwipeView$OnSlidingFinishListener);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonReadInJoyAtlasViewPagerAdapter = new ReadInJoyAtlasViewPagerAdapter(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyAtlasViewPager.setAdapter(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonReadInJoyAtlasViewPagerAdapter);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonReadInJoyAtlasViewPagerAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonReadInJoyAtlasViewPagerAdapter$OnChildGalleryEventListener);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyAtlasViewPager.getBackground().setAlpha(255);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyAtlasViewPager.setOnPageItemScrollListener(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyAtlasViewPager$PageItemScrollListener);
      if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
        break label763;
      }
      a(4, "阿嘞，内容被外星人带走啦~");
    }
    for (;;)
    {
      if ((this.jdField_d_of_type_Int == 7) || (this.jdField_d_of_type_Int == 8) || (this.jdField_d_of_type_Int == 9) || (this.jdField_d_of_type_Int == 10)) {
        PublicAccountReportUtils.a(null, "", "0X8008E2F", "0X8008E2F", 0, 0, "", "", "", GalleryReportedUtils.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_d_of_type_Int, 0L, 0, this.jdField_b_of_type_JavaLangString, "", 0, 0), false);
      }
      return paramLayoutInflater;
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.mSystemBarComp.setStatusBarDrawable(null);
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.mSystemBarComp.setStatusBarColor(0);
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.mSystemBarComp.setStatusColor(0);
      break;
      label763:
      a(2);
      if (NetworkUtil.g(getActivity())) {
        ReadInJoyAtlasManager.a().a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicReadInJoyAtlasManager$AtlasCallback);
      } else {
        a(3, "当前网络不可用，请价差你的网络设置\n点击屏幕刷新");
      }
    }
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onDecodeTaskCompleted() uin=" + paramString + " time=" + System.currentTimeMillis());
    }
    Object localObject = this.jdField_a_of_type_ComTencentImageURLImageView.getTag();
    if ((localObject instanceof Long))
    {
      long l = ((Long)localObject).longValue();
      if ((paramString != null) && (paramString.equals(l + ""))) {
        this.jdField_a_of_type_ComTencentImageURLImageView.setImageBitmap(paramBitmap);
      }
    }
  }
  
  public void onDetach()
  {
    super.onDetach();
    if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.d();
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = null;
    }
  }
  
  public void u_()
  {
    super.u_();
    if (this.jdField_b_of_type_Boolean) {
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.overridePendingTransition(0, 0);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidAnimationAnimatorSet.cancel();
      this.jdField_a_of_type_AndroidAnimationAnimatorSet.setTarget(null);
      if (this.jdField_a_of_type_AndroidAnimationAnimatorSet.getChildAnimations() == null) {
        break;
      }
      int i = 0;
      while (i < this.jdField_a_of_type_AndroidAnimationAnimatorSet.getChildAnimations().size())
      {
        ((Animator)this.jdField_a_of_type_AndroidAnimationAnimatorSet.getChildAnimations().get(i)).cancel();
        ((Animator)this.jdField_a_of_type_AndroidAnimationAnimatorSet.getChildAnimations().get(i)).setTarget(null);
        i += 1;
      }
      if (this.jdField_a_of_type_Int == 1) {
        this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.overridePendingTransition(0, 2131034286);
      } else {
        this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.overridePendingTransition(0, 2131034285);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyAtlasFragment
 * JD-Core Version:    0.7.0.1
 */