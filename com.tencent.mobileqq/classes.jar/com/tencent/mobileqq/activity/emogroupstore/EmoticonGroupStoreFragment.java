package com.tencent.mobileqq.activity.emogroupstore;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryScene;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryUtils;
import com.tencent.mobileqq.activity.aio.photo.AIORichMediaInfo;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.photo.SendPhotoActivity;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.SVIPObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.data.EmoticonFromGroupEntity;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.emosm.api.IEmoticonFromGroupDBManagerService;
import com.tencent.mobileqq.emosm.api.IFavroamingDBManagerService;
import com.tencent.mobileqq.emosm.api.IFavroamingManagerService;
import com.tencent.mobileqq.emosm.favroaming.IEmoticonFromGroupManager;
import com.tencent.mobileqq.emoticon.EmoticonOperateReport;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.vas.VasExtensionManager;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class EmoticonGroupStoreFragment
  extends IphoneTitleBarFragment
  implements View.OnClickListener
{
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private SpannableString jdField_a_of_type_AndroidTextSpannableString;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new EmoticonGroupStoreFragment.10(this);
  private View jdField_a_of_type_AndroidViewView;
  private AlphaAnimation jdField_a_of_type_AndroidViewAnimationAlphaAnimation;
  private TranslateAnimation jdField_a_of_type_AndroidViewAnimationTranslateAnimation;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private ListView jdField_a_of_type_AndroidWidgetListView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ViewPager jdField_a_of_type_AndroidxViewpagerWidgetViewPager;
  private FilterAdapter jdField_a_of_type_ComTencentMobileqqActivityEmogroupstoreFilterAdapter;
  private PicSelectAdapter jdField_a_of_type_ComTencentMobileqqActivityEmogroupstorePicSelectAdapter;
  TopGestureLayout jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout;
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  SVIPObserver jdField_a_of_type_ComTencentMobileqqAppSVIPObserver = new EmoticonGroupStoreFragment.1(this);
  private IEmoticonFromGroupManager jdField_a_of_type_ComTencentMobileqqEmosmFavroamingIEmoticonFromGroupManager;
  private StringBuilder jdField_a_of_type_JavaLangStringBuilder = new StringBuilder("    ");
  public List<EmoticonFromGroupEntity> a;
  private Map<String, List<EmoticonFromGroupEntity>> jdField_a_of_type_JavaUtilMap;
  private volatile boolean jdField_a_of_type_Boolean = false;
  private View jdField_b_of_type_AndroidViewView;
  private AlphaAnimation jdField_b_of_type_AndroidViewAnimationAlphaAnimation;
  private TranslateAnimation jdField_b_of_type_AndroidViewAnimationTranslateAnimation;
  private Button jdField_b_of_type_AndroidWidgetButton;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private List<EmoticonFromGroupEntity> jdField_b_of_type_JavaUtilList = new CopyOnWriteArrayList();
  private Map<String, FilterAdapter.FilterItemContent> jdField_b_of_type_JavaUtilMap;
  private volatile boolean jdField_b_of_type_Boolean = false;
  private View jdField_c_of_type_AndroidViewView;
  private Button jdField_c_of_type_AndroidWidgetButton;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private List<EmoticonFromGroupEntity> jdField_c_of_type_JavaUtilList = new CopyOnWriteArrayList();
  private View jdField_d_of_type_AndroidViewView;
  private Button jdField_d_of_type_AndroidWidgetButton;
  private List<FilterAdapter.FilterItemContent> jdField_d_of_type_JavaUtilList;
  private View jdField_e_of_type_AndroidViewView;
  private Button jdField_e_of_type_AndroidWidgetButton;
  private List<String> jdField_e_of_type_JavaUtilList = new ArrayList();
  private View jdField_f_of_type_AndroidViewView;
  private Button jdField_f_of_type_AndroidWidgetButton;
  private List<String> jdField_f_of_type_JavaUtilList = new ArrayList();
  private View jdField_g_of_type_AndroidViewView;
  private Button jdField_g_of_type_AndroidWidgetButton;
  private View h;
  private View i;
  
  public EmoticonGroupStoreFragment()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  private void a(List<EmoticonFromGroupEntity> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      EmoticonFromGroupEntity localEmoticonFromGroupEntity = (EmoticonFromGroupEntity)paramList.next();
      if (localEmoticonFromGroupEntity != null) {
        if (localEmoticonFromGroupEntity.msg == null)
        {
          MessageForPic localMessageForPic = (MessageForPic)this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingIEmoticonFromGroupManager.a(localEmoticonFromGroupEntity);
          if (localMessageForPic != null)
          {
            localEmoticonFromGroupEntity.msg = localMessageForPic;
            this.jdField_b_of_type_JavaUtilList.add(localEmoticonFromGroupEntity);
          }
          else
          {
            this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingIEmoticonFromGroupManager.b(localEmoticonFromGroupEntity);
            this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingIEmoticonFromGroupManager.a(localEmoticonFromGroupEntity);
          }
        }
        else
        {
          this.jdField_b_of_type_JavaUtilList.add(localEmoticonFromGroupEntity);
        }
      }
    }
  }
  
  private void b(List<EmoticonFromGroupEntity> paramList)
  {
    Object localObject1 = (IFavroamingDBManagerService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IFavroamingDBManagerService.class);
    if (QLog.isColorLevel()) {
      QLog.i("EmoticonFromGroup_Fragment", 2, "call getEmoticonDataList from EmoticonGroupStoreFragment.filterFavEmo");
    }
    Object localObject2 = ((IFavroamingDBManagerService)localObject1).getEmoticonDataList();
    localObject1 = new ArrayList();
    if ((localObject2 != null) && (!((List)localObject2).isEmpty()))
    {
      int j = 0;
      while (j < ((List)localObject2).size())
      {
        if ((TextUtils.isEmpty(((CustomEmotionData)((List)localObject2).get(j)).RomaingType)) || (!"needDel".equals(((CustomEmotionData)((List)localObject2).get(j)).RomaingType))) {
          ((List)localObject1).add(((List)localObject2).get(j));
        }
        j += 1;
      }
    }
    localObject2 = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      EmoticonFromGroupEntity localEmoticonFromGroupEntity = (EmoticonFromGroupEntity)paramList.next();
      if (this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingIEmoticonFromGroupManager.a((List)localObject1, localEmoticonFromGroupEntity.bigURL))
      {
        localEmoticonFromGroupEntity.status = 0;
        ((List)localObject2).add(localEmoticonFromGroupEntity);
      }
    }
    this.jdField_c_of_type_JavaUtilList.addAll((Collection)localObject2);
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131380033));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)this.mContentView.findViewById(2131372735));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.mContentView.findViewById(2131363923));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.mContentView.findViewById(2131367838));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)this.mContentView.findViewById(2131363948));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this.titleRoot.getContext()).inflate(2131561906, this.titleRoot, false);
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131366131);
    this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131366132);
    this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager = ((ViewPager)this.jdField_a_of_type_AndroidViewView.findViewById(2131366133));
    this.jdField_d_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131363921);
    this.jdField_e_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131363922);
    this.jdField_c_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131363950));
    this.jdField_d_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131363949));
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_d_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_e_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_d_of_type_AndroidWidgetButton.setOnClickListener(this);
    Object localObject = new LinearLayoutManager(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 1, false);
    ((LinearLayoutManager)localObject).setRecycleChildrenOnDetach(true);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager((RecyclerView.LayoutManager)localObject);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131380024));
    this.jdField_f_of_type_AndroidViewView = new View(this.titleRoot.getContext());
    localObject = new RelativeLayout.LayoutParams(-1, -1);
    this.jdField_f_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.jdField_f_of_type_AndroidViewView.setBackgroundColor(Color.parseColor(getString(2131165338)));
    try
    {
      this.jdField_g_of_type_AndroidViewView = LayoutInflater.from(this.titleRoot.getContext()).inflate(2131561901, this.titleRoot, false);
      this.h = this.jdField_g_of_type_AndroidViewView.findViewById(2131366845);
      this.h.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetListView = ((ListView)this.jdField_g_of_type_AndroidViewView.findViewById(2131370508));
      this.jdField_a_of_type_AndroidWidgetListView.setOnItemClickListener(new EmoticonGroupStoreFragment.2(this));
      this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstoreFilterAdapter = new FilterAdapter(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      this.jdField_a_of_type_AndroidWidgetListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstoreFilterAdapter);
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_g_of_type_AndroidViewView.findViewById(2131380031));
      this.jdField_e_of_type_AndroidWidgetButton = ((Button)this.jdField_g_of_type_AndroidViewView.findViewById(2131363934));
      this.jdField_f_of_type_AndroidWidgetButton = ((Button)this.jdField_g_of_type_AndroidViewView.findViewById(2131363933));
      this.jdField_e_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_f_of_type_AndroidWidgetButton.setOnClickListener(this);
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      label552:
      break label552;
    }
    QLog.e("EmoticonFromGroup_Fragment", 2, "oom error occur!");
    this.i = this.mContentView.findViewById(2131367839);
    ((URLImageView)this.i.findViewById(2131368652)).setImageDrawable(URLDrawable.getDrawable("https://imgcache.gtimg.cn/ACT/svip_act/act_img/public/201802/m1517913373_empty_img_1.png"));
    this.jdField_g_of_type_AndroidWidgetButton = new Button(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    this.jdField_g_of_type_AndroidWidgetButton.setId(2131378146);
    localObject = new RelativeLayout.LayoutParams(ScreenUtil.dip2px(21.0F), ScreenUtil.dip2px(20.0F));
    ((RelativeLayout.LayoutParams)localObject).addRule(11, -1);
    ((RelativeLayout.LayoutParams)localObject).addRule(15, -1);
    ((RelativeLayout.LayoutParams)localObject).rightMargin = 8;
    this.jdField_g_of_type_AndroidWidgetButton.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.vg.addView(this.jdField_g_of_type_AndroidWidgetButton);
  }
  
  private void c(List<EmoticonFromGroupEntity> paramList)
  {
    int k;
    if (paramList == null) {
      k = 0;
    } else {
      k = paramList.size();
    }
    if ((getBaseActivity() != null) && (k != 0))
    {
      ArrayList localArrayList = new ArrayList();
      String str = String.format(getString(2131693062), new Object[] { Integer.valueOf(k) });
      int j = 3;
      if (k < 3) {
        j = paramList.size();
      }
      k = 0;
      while (k < j)
      {
        URLDrawable localURLDrawable = (URLDrawable)this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingIEmoticonFromGroupManager.a((EmoticonFromGroupEntity)paramList.get(k), 65537, ScreenUtil.dip2px(11.0F), null);
        int m = k + 1;
        k = m;
        if (localURLDrawable != null)
        {
          localArrayList.add(localURLDrawable);
          this.jdField_a_of_type_JavaLangStringBuilder.append(" ");
          k = m;
          if (1 != localURLDrawable.getStatus())
          {
            localURLDrawable.startDownload();
            localURLDrawable.setURLDrawableListener(new EmoticonGroupStoreFragment.9(this));
            k = m;
          }
        }
      }
      paramList = new StringBuilder();
      paramList.append(this.jdField_a_of_type_JavaLangStringBuilder);
      paramList.append(str);
      this.jdField_a_of_type_AndroidTextSpannableString = new SpannableString(paramList.toString());
      paramList = new OverlapDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      paramList.a(localArrayList, ScreenUtil.dip2px(11.0F));
      paramList.setBounds(0, 0, ScreenUtil.dip2px(33.0F), ScreenUtil.dip2px(22.0F));
      this.jdField_a_of_type_AndroidTextSpannableString.setSpan(new ImageSpan(paramList, 0), 0, this.jdField_a_of_type_JavaLangStringBuilder.length() - 4, 17);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(14.0F);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#FF777777"));
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidTextSpannableString);
    }
  }
  
  private void d()
  {
    this.leftView.setVisibility(0);
    this.leftView.setText(2131693063);
    this.leftView.setTextColor(getResources().getColor(2131165327));
    this.leftView.setBackgroundDrawable(getResources().getDrawable(2130840342));
    this.centerView.setTextColor(getResources().getColor(2131165327));
    this.jdField_g_of_type_AndroidWidgetButton.setBackgroundResource(2130840300);
    this.jdField_g_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.setFillAfter(true);
    this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.setDuration(500L);
    this.jdField_b_of_type_AndroidViewAnimationAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    this.jdField_b_of_type_AndroidViewAnimationAlphaAnimation.setFillAfter(true);
    this.jdField_b_of_type_AndroidViewAnimationAlphaAnimation.setDuration(500L);
    this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation = new TranslateAnimation(2, 1.0F, 2, 0.0F, 2, 0.0F, 2, 0.0F);
    this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setFillAfter(true);
    this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setDuration(500L);
    this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation = new TranslateAnimation(2, 0.0F, 2, 1.0F, 2, 0.0F, 2, 0.0F);
    this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation.setAnimationListener(new EmoticonGroupStoreFragment.3(this));
    this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation.setFillAfter(true);
    this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation.setDuration(500L);
    e();
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.i.setVisibility(8);
  }
  
  private void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstorePicSelectAdapter = new PicSelectAdapter(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingIEmoticonFromGroupManager.a(), this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager, this.jdField_b_of_type_AndroidWidgetButton);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstorePicSelectAdapter);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setOnScrollListener(new EmoticonGroupStoreFragment.4(this));
  }
  
  private void f()
  {
    ThreadManager.post(new EmoticonGroupStoreFragment.5(this), 5, null, true);
  }
  
  private void g()
  {
    ThreadManager.getUIHandler().post(new EmoticonGroupStoreFragment.6(this));
  }
  
  private void h()
  {
    ThreadManager.getUIHandler().post(new EmoticonGroupStoreFragment.7(this));
  }
  
  private void i()
  {
    ThreadManager.getUIHandler().post(new EmoticonGroupStoreFragment.8(this));
  }
  
  private void j()
  {
    ConcurrentHashMap localConcurrentHashMap1 = new ConcurrentHashMap();
    CopyOnWriteArrayList localCopyOnWriteArrayList = new CopyOnWriteArrayList();
    ConcurrentHashMap localConcurrentHashMap2 = new ConcurrentHashMap();
    Object localObject1 = this.jdField_b_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (EmoticonFromGroupEntity)((Iterator)localObject1).next();
      if (localConcurrentHashMap1.containsKey(((EmoticonFromGroupEntity)localObject2).troopUin))
      {
        ((List)localConcurrentHashMap1.get(((EmoticonFromGroupEntity)localObject2).troopUin)).add(localObject2);
      }
      else
      {
        localObject3 = new ArrayList();
        ((List)localObject3).add(localObject2);
        localConcurrentHashMap1.put(((EmoticonFromGroupEntity)localObject2).troopUin, localObject3);
      }
    }
    Object localObject3 = localConcurrentHashMap1.entrySet().iterator();
    while (((Iterator)localObject3).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject3).next();
      FilterAdapter.FilterItemContent localFilterItemContent = new FilterAdapter.FilterItemContent();
      EmoticonFromGroupEntity localEmoticonFromGroupEntity = (EmoticonFromGroupEntity)((List)localEntry.getValue()).get(0);
      int j = localEmoticonFromGroupEntity.fromType;
      localObject2 = null;
      if (1 == j)
      {
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFaceBitmap(4, localEmoticonFromGroupEntity.troopUin, (byte)2, false, (byte)1, 0);
        localObject1 = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localEmoticonFromGroupEntity.troopUin, true);
      }
      else if (3000 == localEmoticonFromGroupEntity.fromType)
      {
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFaceBitmap(101, localEmoticonFromGroupEntity.troopUin, (byte)3, false, (byte)1, 0);
        localObject1 = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, localEmoticonFromGroupEntity.troopUin);
      }
      else
      {
        localObject1 = null;
      }
      localFilterItemContent.jdField_a_of_type_JavaLangString = localEmoticonFromGroupEntity.troopUin;
      localFilterItemContent.jdField_a_of_type_AndroidGraphicsBitmap = ((Bitmap)localObject2);
      localFilterItemContent.jdField_a_of_type_Boolean = false;
      localFilterItemContent.b = ((String)localObject1);
      localFilterItemContent.jdField_a_of_type_Int = ((List)localEntry.getValue()).size();
      localCopyOnWriteArrayList.add(localFilterItemContent);
      localConcurrentHashMap2.put(localFilterItemContent.jdField_a_of_type_JavaLangString, localFilterItemContent);
    }
    this.jdField_a_of_type_JavaUtilMap = localConcurrentHashMap1;
    this.jdField_d_of_type_JavaUtilList = localCopyOnWriteArrayList;
    this.jdField_b_of_type_JavaUtilMap = localConcurrentHashMap2;
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      ThreadManager.getUIHandler().post(new EmoticonGroupStoreFragment.11(this));
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstoreFilterAdapter.a(this.jdField_d_of_type_JavaUtilList);
    this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstoreFilterAdapter.notifyDataSetChanged();
    localObject1 = this.jdField_c_of_type_AndroidWidgetTextView;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(HardCodeUtil.a(2131704171));
    ((StringBuilder)localObject2).append(this.jdField_b_of_type_JavaUtilList.size());
    ((StringBuilder)localObject2).append(HardCodeUtil.a(2131704183));
    ((TextView)localObject1).setText(((StringBuilder)localObject2).toString());
  }
  
  private void k()
  {
    if ((this.jdField_g_of_type_AndroidViewView != null) && (this.titleRoot == this.jdField_g_of_type_AndroidViewView.getParent()) && (this.titleRoot == this.jdField_g_of_type_AndroidViewView.getParent()))
    {
      this.jdField_f_of_type_AndroidViewView.startAnimation(this.jdField_b_of_type_AndroidViewAnimationAlphaAnimation);
      this.jdField_g_of_type_AndroidViewView.startAnimation(this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation);
    }
  }
  
  private void l()
  {
    Iterator localIterator = this.jdField_d_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((FilterAdapter.FilterItemContent)localIterator.next()).jdField_a_of_type_Boolean = false;
    }
    if (!this.jdField_e_of_type_JavaUtilList.isEmpty()) {
      this.jdField_e_of_type_JavaUtilList.clear();
    }
  }
  
  private void m()
  {
    this.jdField_g_of_type_AndroidWidgetButton.setBackgroundResource(2130840300);
    this.jdField_g_of_type_AndroidWidgetButton.setEnabled(true);
  }
  
  private void n()
  {
    this.jdField_g_of_type_AndroidWidgetButton.setBackgroundResource(2130840301);
    this.jdField_g_of_type_AndroidWidgetButton.setEnabled(false);
  }
  
  void a()
  {
    if (getTitleBarView() != null)
    {
      getTitleBarView().setBackgroundResource(0);
      getTitleBarView().setBackgroundColor(-1);
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
    if ((localObject != null) && ((localObject instanceof PublicFragmentActivity)))
    {
      localObject = ((PublicFragmentActivity)localObject).mSystemBarComp;
      if ((localObject != null) && (needImmersive()) && (needStatusTrans()) && (ImmersiveUtils.isSupporImmersive() == 1))
      {
        if (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getAppRuntime()))
        {
          if ((!SystemUtil.b()) && (!SystemUtil.d()))
          {
            ((SystemBarCompact)localObject).setStatusBarColor(-7829368);
            return;
          }
          ((SystemBarCompact)localObject).setStatusBarColor(-7829368);
          ((SystemBarCompact)localObject).setStatusBarDarkMode(true);
          return;
        }
        if ((Build.VERSION.SDK_INT >= 23) && (!SystemUtil.b()) && (!SystemUtil.d()))
        {
          this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getWindow().getDecorView().setSystemUiVisibility(9216);
          ((SystemBarCompact)localObject).setStatusBarColor(-1);
          return;
        }
        if (!SystemUtil.d())
        {
          ((SystemBarCompact)localObject).setStatusBarColor(-2368549);
          return;
        }
        ((SystemBarCompact)localObject).setStatusBarColor(-1);
        ((SystemBarCompact)localObject).setStatusBarDarkMode(true);
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout == null)
    {
      ViewGroup localViewGroup = (ViewGroup)getBaseActivity().getWindow().getDecorView();
      localObject = null;
      int j = 0;
      while (j < localViewGroup.getChildCount())
      {
        View localView = localViewGroup.getChildAt(j);
        localObject = localView;
        if ((localView instanceof DragFrameLayout)) {
          localObject = ((DragFrameLayout)localView).getChildAt(0);
        }
        if ((localObject instanceof TopGestureLayout)) {
          break;
        }
        j += 1;
      }
      if ((localObject != null) && ((localObject instanceof TopGestureLayout))) {
        this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout = ((TopGestureLayout)localObject);
      }
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout;
    if (localObject != null) {
      ((TopGestureLayout)localObject).setInterceptTouchFlag(paramBoolean);
    }
  }
  
  protected void b()
  {
    BaseActivity localBaseActivity = getBaseActivity();
    if (localBaseActivity != null) {
      localBaseActivity.finish();
    }
  }
  
  protected int getContentLayoutId()
  {
    return 2131561904;
  }
  
  protected void init(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonFromGroup_Fragment", 2, "emoticonFromGroupFragment init start.");
    }
    super.init(paramBundle);
    super.setTitle(HardCodeUtil.a(2131704172));
    paramBundle = getBaseActivity();
    if (paramBundle != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBundle;
    }
    else
    {
      QLog.e("EmoticonFromGroup_Fragment", 1, "activity is null");
      b();
    }
    paramBundle = MobileQQ.sMobileQQ.waitAppRuntime(null);
    if ((paramBundle instanceof QQAppInterface))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)paramBundle);
    }
    else
    {
      QLog.e("EmoticonFromGroup_Fragment", 1, "app is null");
      b();
    }
    this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingIEmoticonFromGroupManager = ((VasExtensionManager)paramBundle.getManager(QQManagerFactory.VAS_EXTENSION_MANAGER)).jdField_a_of_type_ComTencentMobileqqEmosmFavroamingIEmoticonFromGroupManager;
    paramBundle = (IFavroamingManagerService)paramBundle.getRuntimeService(IFavroamingManagerService.class, "");
    if (paramBundle != null) {
      paramBundle.syncRoaming();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppSVIPObserver);
    c();
    d();
    f();
    VasWebviewUtil.a("", "QLbq", "PageView", "0", 1, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonFromGroup_Fragment", 2, "emoticonFromGroupFragment init end.");
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt2 == -1) && (paramInt1 == 0))
    {
      Intent localIntent = AIOUtils.a(new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, SplashActivity.class), null);
      paramIntent = new Bundle(paramIntent.getExtras());
      paramIntent.putBoolean("PhotoConst.HANDLE_DEST_RESULT", true);
      paramIntent.putBoolean("PhotoConst.IS_FORWARD", true);
      paramIntent.putInt("PhotoConst.SEND_BUSINESS_TYPE", 1031);
      localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", SplashActivity.class.getName());
      localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
      localIntent.putExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME", SendPhotoActivity.class.getName());
      localIntent.putExtra("PhotoConst.DEST_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
      localIntent.putExtra("extra_image_sender_tag", "sessionInfo.aioAlbum");
      paramIntent.putBoolean("PicContants.NEED_COMPRESS", false);
      localIntent.putExtras(paramIntent);
      String str = paramIntent.getString("GALLERY.FORWORD_LOCAL_PATH");
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(str);
      paramInt1 = paramIntent.getInt("PhotoConst.SEND_SIZE_SPEC", 0);
      PhotoUtils.sendPhoto(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, localIntent, localArrayList, paramInt1, true);
    }
  }
  
  public boolean onBackEvent()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstorePicSelectAdapter;
    if ((localObject != null) && (((PicSelectAdapter)localObject).jdField_a_of_type_Boolean))
    {
      localObject = this.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((EmoticonFromGroupEntity)((Iterator)localObject).next()).status = -1;
      }
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstorePicSelectAdapter;
      ((PicSelectAdapter)localObject).jdField_a_of_type_Boolean = false;
      ((PicSelectAdapter)localObject).a(false);
      this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstorePicSelectAdapter.notifyDataSetChanged();
      m();
      a(true);
      resetLeftButton();
      return true;
    }
    if (this.titleRoot == this.jdField_a_of_type_AndroidViewView.getParent())
    {
      this.titleRoot.removeView(this.jdField_a_of_type_AndroidViewView);
      a(true);
      return true;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      l();
      k();
      VasWebviewUtil.a("", "QLbq", "ClickFilterReturn", "0", 1, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
      return true;
    }
    b();
    return false;
  }
  
  public void onClick(View paramView)
  {
    Object localObject1;
    Object localObject2;
    switch (paramView.getId())
    {
    default: 
      break;
    case 2131378146: 
      if (this.jdField_g_of_type_AndroidViewView == null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("EmoticonFromGroup_Fragment", 2, "click right img useless, filterView is null.");
        }
      }
      else
      {
        a(false);
        this.jdField_a_of_type_Boolean = true;
        if (this.titleRoot != this.jdField_f_of_type_AndroidViewView.getParent()) {
          this.titleRoot.addView(this.jdField_f_of_type_AndroidViewView);
        }
        if (this.titleRoot != this.jdField_g_of_type_AndroidViewView.getParent()) {
          this.titleRoot.addView(this.jdField_g_of_type_AndroidViewView);
        }
        this.jdField_f_of_type_AndroidViewView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation);
        this.jdField_g_of_type_AndroidViewView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation);
        localObject1 = this.jdField_f_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (String)((Iterator)localObject1).next();
          this.jdField_e_of_type_JavaUtilList.add(localObject2);
          ((FilterAdapter.FilterItemContent)this.jdField_b_of_type_JavaUtilMap.get(localObject2)).jdField_a_of_type_Boolean = true;
        }
        if (!this.jdField_b_of_type_Boolean)
        {
          this.jdField_b_of_type_Boolean = true;
          j();
        }
        VasWebviewUtil.a("", "QLbq", "ClickFilter", "0", 1, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
      }
      break;
    case 2131366845: 
      l();
      k();
      VasWebviewUtil.a("", "QLbq", "ClickFilterReturn", "0", 1, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
      break;
    case 2131366131: 
      if (this.titleRoot == this.jdField_a_of_type_AndroidViewView.getParent())
      {
        AbstractGifImage.pauseAll();
        this.titleRoot.removeView(this.jdField_a_of_type_AndroidViewView);
        a(true);
      }
      break;
    case 2131363950: 
      localObject1 = ((ImgPreviewAdapter)this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager.getAdapter()).a(this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager.getCurrentItem());
      if ((localObject1 != null) && (((EmoticonFromGroupEntity)localObject1).msg != null)) {
        AIOGalleryScene.b(new AIORichMediaInfo(AIOGalleryUtils.a(((EmoticonFromGroupEntity)localObject1).msg)), this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 0);
      } else {
        QLog.e("EmoticonFromGroup_Fragment.msgnull", 1, "preview send msg is null.");
      }
      VasWebviewUtil.a("", "QLbq", "SendFriend", "0", 1, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
      break;
    case 2131363949: 
      localObject1 = ((ImgPreviewAdapter)this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager.getAdapter()).a(this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager.getCurrentItem());
      if (this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingIEmoticonFromGroupManager.a((EmoticonFromGroupEntity)localObject1))
      {
        this.jdField_c_of_type_JavaUtilList.add(localObject1);
        this.jdField_d_of_type_AndroidWidgetButton.setText(HardCodeUtil.a(2131704163));
        this.jdField_d_of_type_AndroidWidgetButton.setTextColor(Color.parseColor("#FFBBBBBB"));
        this.jdField_d_of_type_AndroidWidgetButton.setBackgroundDrawable(getResources().getDrawable(2130844470));
        this.jdField_d_of_type_AndroidWidgetButton.setEnabled(false);
        this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstorePicSelectAdapter.notifyDataSetChanged();
      }
      if (localObject1 != null) {
        EmoticonOperateReport.reportFavAddEmotionEvent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 4, ((EmoticonFromGroupEntity)localObject1).md5, null);
      }
      VasWebviewUtil.a("", "QLbq", "Addbq", "0", 1, 0, 0, "", "", "1", "", "", "", "", 0, 0, 0, 0);
      break;
    case 2131363948: 
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstorePicSelectAdapter.a(false);
      this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstorePicSelectAdapter.jdField_a_of_type_Boolean = false;
      this.jdField_c_of_type_JavaUtilList.addAll(this.jdField_a_of_type_JavaUtilList);
      this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingIEmoticonFromGroupManager.d(new ArrayList(this.jdField_a_of_type_JavaUtilList));
      localObject1 = this.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((EmoticonFromGroupEntity)((Iterator)localObject1).next()).status = 0;
      }
      localObject1 = (IEmoticonFromGroupDBManagerService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IEmoticonFromGroupDBManagerService.class);
      ((IEmoticonFromGroupDBManagerService)localObject1).setCountOfSpare(((IEmoticonFromGroupDBManagerService)localObject1).getCountOfSpare() - this.jdField_a_of_type_JavaUtilList.size());
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstorePicSelectAdapter.notifyDataSetChanged();
      m();
      a(true);
      resetLeftButton();
      VasWebviewUtil.a("", "QLbq", "AddMutibq", "0", 1, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
      break;
    case 2131363934: 
      l();
      this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstoreFilterAdapter.notifyDataSetChanged();
      VasWebviewUtil.a("", "QLbq", "ClickFilterReset", "0", 1, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
      break;
    case 2131363933: 
      if (!this.jdField_f_of_type_JavaUtilList.isEmpty()) {
        this.jdField_f_of_type_JavaUtilList.clear();
      }
      int j = this.jdField_e_of_type_JavaUtilList.size();
      if (j == 0)
      {
        localObject1 = new ArrayList(this.jdField_b_of_type_JavaUtilList);
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingIEmoticonFromGroupManager.a((List)localObject1);
        if (localObject2 != null)
        {
          c((List)localObject1);
          this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstorePicSelectAdapter.a((Map)localObject2, (List)localObject1);
        }
      }
      else
      {
        localObject1 = new ArrayList();
        localObject2 = this.jdField_e_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          String str = (String)((Iterator)localObject2).next();
          this.jdField_f_of_type_JavaUtilList.add(str);
          ((List)localObject1).addAll((Collection)this.jdField_a_of_type_JavaUtilMap.get(str));
        }
        Collections.sort((List)localObject1);
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingIEmoticonFromGroupManager.a((List)localObject1);
        if (localObject2 != null)
        {
          c((List)localObject1);
          this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstorePicSelectAdapter.a((Map)localObject2, (List)localObject1);
        }
      }
      l();
      k();
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("");
      ((StringBuilder)localObject1).append(j);
      VasWebviewUtil.a("", "QLbq", "ClickFilterConfirm", "0", 1, 0, 0, "", "", ((StringBuilder)localObject1).toString(), "", "", "", "", 0, 0, 0, 0);
      break;
    case 2131363923: 
      if (this.jdField_b_of_type_AndroidWidgetTextView.getVisibility() == 0) {
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      n();
      a(false);
      setLeftButton(HardCodeUtil.a(2131704203), this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.leftViewNotBack.setTextColor(getResources().getColor(2131165327));
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetButton.setTextColor(Color.parseColor("#FFBFBFBF"));
      this.jdField_b_of_type_AndroidWidgetButton.setBackgroundDrawable(getResources().getDrawable(2130844470));
      this.jdField_b_of_type_AndroidWidgetButton.setEnabled(false);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstorePicSelectAdapter.a(true);
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstorePicSelectAdapter;
      ((PicSelectAdapter)localObject1).jdField_a_of_type_Boolean = true;
      ((PicSelectAdapter)localObject1).notifyDataSetChanged();
      VasWebviewUtil.a("", "QLbq", "ClickMutiSel", "0", 1, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
      break;
    case 2131363922: 
      this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager.arrowScroll(66);
      VasWebviewUtil.a("", "QLbq", "SwitchPreview", "0", 1, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
      break;
    case 2131363921: 
      this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager.arrowScroll(17);
      VasWebviewUtil.a("", "QLbq", "SwitchPreview", "0", 1, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingIEmoticonFromGroupManager.b(this.jdField_c_of_type_JavaUtilList);
    this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingIEmoticonFromGroupManager.c(this.jdField_c_of_type_JavaUtilList);
    MqqHandler localMqqHandler = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(ChatActivity.class);
    if (localMqqHandler != null) {
      localMqqHandler.obtainMessage(10).sendToTarget();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppSVIPObserver);
  }
  
  public void onPause()
  {
    super.onPause();
    AbstractGifImage.pauseAll();
  }
  
  public void onResume()
  {
    super.onResume();
    a();
    AbstractGifImage.resumeAll();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstorePicSelectAdapter;
    if (localObject != null) {
      ((PicSelectAdapter)localObject).notifyDataSetChanged();
    }
    if (this.jdField_d_of_type_AndroidWidgetButton != null)
    {
      localObject = this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager;
      if (localObject != null)
      {
        localObject = ((ImgPreviewAdapter)((ViewPager)localObject).getAdapter()).a(this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager.getCurrentItem());
        if (localObject != null)
        {
          if (((EmoticonFromGroupEntity)localObject).status == 0)
          {
            this.jdField_d_of_type_AndroidWidgetButton.setText(HardCodeUtil.a(2131704205));
            this.jdField_d_of_type_AndroidWidgetButton.setTextColor(Color.parseColor("#FFBBBBBB"));
            this.jdField_d_of_type_AndroidWidgetButton.setBackgroundDrawable(getResources().getDrawable(2130844470));
            this.jdField_d_of_type_AndroidWidgetButton.setEnabled(false);
            return;
          }
          this.jdField_d_of_type_AndroidWidgetButton.setText(HardCodeUtil.a(2131704167));
          this.jdField_d_of_type_AndroidWidgetButton.setTextColor(Color.parseColor("#FFFFFFFF"));
          this.jdField_d_of_type_AndroidWidgetButton.setBackgroundDrawable(getResources().getDrawable(2130844469));
          this.jdField_d_of_type_AndroidWidgetButton.setEnabled(true);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.emogroupstore.EmoticonGroupStoreFragment
 * JD-Core Version:    0.7.0.1
 */