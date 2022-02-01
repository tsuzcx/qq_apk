package com.tencent.mobileqq.activity.emogroupstore;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
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
import com.tencent.common.app.AppInterface;
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
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.SVIPObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.data.EmoticonFromGroupEntity;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.emosm.favroaming.EmoticonFromGroupDBManager;
import com.tencent.mobileqq.emosm.favroaming.EmoticonFromGroupManager;
import com.tencent.mobileqq.emosm.favroaming.FavroamingDBManager;
import com.tencent.mobileqq.emosm.favroaming.FavroamingManager;
import com.tencent.mobileqq.emoticonview.EmoticonUtils;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.vas.VasExtensionManager;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
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
import mqq.os.MqqHandler;

public class EmoticonGroupStoreFragment
  extends IphoneTitleBarFragment
  implements View.OnClickListener
{
  private FragmentActivity jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
  private ViewPager jdField_a_of_type_AndroidSupportV4ViewViewPager;
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
  private FilterAdapter jdField_a_of_type_ComTencentMobileqqActivityEmogroupstoreFilterAdapter;
  private PicSelectAdapter jdField_a_of_type_ComTencentMobileqqActivityEmogroupstorePicSelectAdapter;
  TopGestureLayout jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  SVIPObserver jdField_a_of_type_ComTencentMobileqqAppSVIPObserver = new EmoticonGroupStoreFragment.1(this);
  private EmoticonFromGroupManager jdField_a_of_type_ComTencentMobileqqEmosmFavroamingEmoticonFromGroupManager;
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
          MessageForPic localMessageForPic = this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingEmoticonFromGroupManager.a(localEmoticonFromGroupEntity);
          if (localMessageForPic != null)
          {
            localEmoticonFromGroupEntity.msg = localMessageForPic;
            this.jdField_b_of_type_JavaUtilList.add(localEmoticonFromGroupEntity);
          }
          else
          {
            this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingEmoticonFromGroupManager.b(localEmoticonFromGroupEntity);
            this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingEmoticonFromGroupManager.a(localEmoticonFromGroupEntity);
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
    Object localObject1 = (FavroamingDBManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FAVROAMING_DB_MANAGER);
    if (QLog.isColorLevel()) {
      QLog.i("EmoticonFromGroup_Fragment", 2, "call getEmoticonDataList from EmoticonGroupStoreFragment.filterFavEmo");
    }
    Object localObject2 = ((FavroamingDBManager)localObject1).a();
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
      if (this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingEmoticonFromGroupManager.a((List)localObject1, localEmoticonFromGroupEntity.bigURL))
      {
        localEmoticonFromGroupEntity.status = 0;
        ((List)localObject2).add(localEmoticonFromGroupEntity);
      }
    }
    this.jdField_c_of_type_JavaUtilList.addAll((Collection)localObject2);
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131380768));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)this.mContentView.findViewById(2131373157));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.mContentView.findViewById(2131363996));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.mContentView.findViewById(2131368085));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)this.mContentView.findViewById(2131364021));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this.titleRoot.getContext()).inflate(2131562071, this.titleRoot, false);
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131366242);
    this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131366243);
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager = ((ViewPager)this.jdField_a_of_type_AndroidViewView.findViewById(2131366244));
    this.jdField_d_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131363994);
    this.jdField_e_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131363995);
    this.jdField_c_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131364023));
    this.jdField_d_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131364022));
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_d_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_e_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_d_of_type_AndroidWidgetButton.setOnClickListener(this);
    Object localObject = new LinearLayoutManager(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 1, false);
    ((LinearLayoutManager)localObject).setRecycleChildrenOnDetach(true);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager((RecyclerView.LayoutManager)localObject);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131380759));
    this.jdField_f_of_type_AndroidViewView = new View(this.titleRoot.getContext());
    localObject = new RelativeLayout.LayoutParams(-1, -1);
    this.jdField_f_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.jdField_f_of_type_AndroidViewView.setBackgroundColor(Color.parseColor(getString(2131165370)));
    try
    {
      this.jdField_g_of_type_AndroidViewView = LayoutInflater.from(this.titleRoot.getContext()).inflate(2131562066, this.titleRoot, false);
      this.h = this.jdField_g_of_type_AndroidViewView.findViewById(2131366987);
      this.h.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetListView = ((ListView)this.jdField_g_of_type_AndroidViewView.findViewById(2131370875));
      this.jdField_a_of_type_AndroidWidgetListView.setOnItemClickListener(new EmoticonGroupStoreFragment.2(this));
      this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstoreFilterAdapter = new FilterAdapter(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
      this.jdField_a_of_type_AndroidWidgetListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstoreFilterAdapter);
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_g_of_type_AndroidViewView.findViewById(2131380766));
      this.jdField_e_of_type_AndroidWidgetButton = ((Button)this.jdField_g_of_type_AndroidViewView.findViewById(2131364007));
      this.jdField_f_of_type_AndroidWidgetButton = ((Button)this.jdField_g_of_type_AndroidViewView.findViewById(2131364006));
      this.jdField_e_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_f_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.i = this.mContentView.findViewById(2131368086);
      ((URLImageView)this.i.findViewById(2131368931)).setImageDrawable(URLDrawable.getDrawable("https://imgcache.gtimg.cn/ACT/svip_act/act_img/public/201802/m1517913373_empty_img_1.png"));
      this.jdField_g_of_type_AndroidWidgetButton = new Button(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
      this.jdField_g_of_type_AndroidWidgetButton.setId(2131378751);
      localObject = new RelativeLayout.LayoutParams(ScreenUtil.dip2px(21.0F), ScreenUtil.dip2px(20.0F));
      ((RelativeLayout.LayoutParams)localObject).addRule(11, -1);
      ((RelativeLayout.LayoutParams)localObject).addRule(15, -1);
      ((RelativeLayout.LayoutParams)localObject).rightMargin = 8;
      this.jdField_g_of_type_AndroidWidgetButton.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.vg.addView(this.jdField_g_of_type_AndroidWidgetButton);
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        QLog.e("EmoticonFromGroup_Fragment", 2, "oom error occur!");
      }
    }
  }
  
  private void c(List<EmoticonFromGroupEntity> paramList)
  {
    int j = 3;
    int k;
    if (paramList == null) {
      k = 0;
    }
    while ((getActivity() != null) && (k != 0))
    {
      ArrayList localArrayList = new ArrayList();
      String str = String.format(getString(2131693102), new Object[] { Integer.valueOf(k) });
      if (k < 3) {
        j = paramList.size();
      }
      k = 0;
      for (;;)
      {
        if (k < j)
        {
          URLDrawable localURLDrawable = (URLDrawable)this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingEmoticonFromGroupManager.a((EmoticonFromGroupEntity)paramList.get(k), 65537, ScreenUtil.dip2px(11.0F), null);
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
              continue;
              k = paramList.size();
              break;
            }
          }
        }
      }
      this.jdField_a_of_type_AndroidTextSpannableString = new SpannableString(this.jdField_a_of_type_JavaLangStringBuilder + str);
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
    this.leftView.setText(2131693103);
    this.leftView.setTextColor(getResources().getColor(2131165357));
    this.leftView.setBackgroundDrawable(getResources().getDrawable(2130840473));
    this.centerView.setTextColor(getResources().getColor(2131165357));
    this.jdField_g_of_type_AndroidWidgetButton.setBackgroundResource(2130840431);
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
    this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstorePicSelectAdapter = new PicSelectAdapter(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingEmoticonFromGroupManager.a(), this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_AndroidSupportV4ViewViewPager, this.jdField_b_of_type_AndroidWidgetButton);
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
    Object localObject2;
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
    Map.Entry localEntry;
    FilterAdapter.FilterItemContent localFilterItemContent;
    EmoticonFromGroupEntity localEmoticonFromGroupEntity;
    if (((Iterator)localObject3).hasNext())
    {
      localEntry = (Map.Entry)((Iterator)localObject3).next();
      localFilterItemContent = new FilterAdapter.FilterItemContent();
      localEmoticonFromGroupEntity = (EmoticonFromGroupEntity)((List)localEntry.getValue()).get(0);
      if (1 == localEmoticonFromGroupEntity.fromType)
      {
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFaceBitmap(4, localEmoticonFromGroupEntity.troopUin, (byte)2, false, (byte)1, 0);
        localObject1 = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localEmoticonFromGroupEntity.troopUin, true);
      }
    }
    for (;;)
    {
      localFilterItemContent.jdField_a_of_type_JavaLangString = localEmoticonFromGroupEntity.troopUin;
      localFilterItemContent.jdField_a_of_type_AndroidGraphicsBitmap = ((Bitmap)localObject2);
      localFilterItemContent.jdField_a_of_type_Boolean = false;
      localFilterItemContent.b = ((String)localObject1);
      localFilterItemContent.jdField_a_of_type_Int = ((List)localEntry.getValue()).size();
      localCopyOnWriteArrayList.add(localFilterItemContent);
      localConcurrentHashMap2.put(localFilterItemContent.jdField_a_of_type_JavaLangString, localFilterItemContent);
      break;
      if (3000 == localEmoticonFromGroupEntity.fromType)
      {
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFaceBitmap(101, localEmoticonFromGroupEntity.troopUin, (byte)3, false, (byte)1, 0);
        localObject1 = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, localEmoticonFromGroupEntity.troopUin);
        continue;
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
        this.jdField_c_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131704082) + this.jdField_b_of_type_JavaUtilList.size() + HardCodeUtil.a(2131704094));
      }
      else
      {
        localObject1 = null;
        localObject2 = null;
      }
    }
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
    this.jdField_g_of_type_AndroidWidgetButton.setBackgroundResource(2130840431);
    this.jdField_g_of_type_AndroidWidgetButton.setEnabled(true);
  }
  
  private void n()
  {
    this.jdField_g_of_type_AndroidWidgetButton.setBackgroundResource(2130840432);
    this.jdField_g_of_type_AndroidWidgetButton.setEnabled(false);
  }
  
  void a()
  {
    if (getTitleBarView() != null)
    {
      getTitleBarView().setBackgroundResource(0);
      getTitleBarView().setBackgroundColor(-1);
    }
    SystemBarCompact localSystemBarCompact;
    if ((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity != null) && ((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity instanceof PublicFragmentActivity)))
    {
      localSystemBarCompact = ((PublicFragmentActivity)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity).mSystemBarComp;
      if ((localSystemBarCompact != null) && (needImmersive()) && (needStatusTrans()) && (ImmersiveUtils.isSupporImmersive() == 1))
      {
        if (!ThemeUtil.isInNightMode(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getAppRuntime())) {
          break label122;
        }
        if ((SystemUtil.b()) || (SystemUtil.d())) {
          break label109;
        }
        localSystemBarCompact.setStatusBarColor(-7829368);
      }
    }
    return;
    label109:
    localSystemBarCompact.setStatusBarColor(-7829368);
    localSystemBarCompact.setStatusBarDarkMode(true);
    return;
    label122:
    if ((Build.VERSION.SDK_INT >= 23) && (!SystemUtil.b()) && (!SystemUtil.d()))
    {
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getWindow().getDecorView().setSystemUiVisibility(9216);
      localSystemBarCompact.setStatusBarColor(-1);
      return;
    }
    if (!SystemUtil.d())
    {
      localSystemBarCompact.setStatusBarColor(-2368549);
      return;
    }
    localSystemBarCompact.setStatusBarColor(-1);
    localSystemBarCompact.setStatusBarDarkMode(true);
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject;
    int j;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout == null)
    {
      ViewGroup localViewGroup = (ViewGroup)getActivity().getWindow().getDecorView();
      localObject = null;
      j = 0;
      if (j >= localViewGroup.getChildCount()) {
        break label113;
      }
      View localView = localViewGroup.getChildAt(j);
      localObject = localView;
      if ((localView instanceof DragFrameLayout)) {
        localObject = ((DragFrameLayout)localView).getChildAt(0);
      }
      if (!(localObject instanceof TopGestureLayout)) {
        break label106;
      }
    }
    label106:
    label113:
    for (;;)
    {
      if ((localObject != null) && ((localObject instanceof TopGestureLayout))) {
        this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout = ((TopGestureLayout)localObject);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.setInterceptTouchFlag(paramBoolean);
      }
      return;
      j += 1;
      break;
    }
  }
  
  protected void b()
  {
    FragmentActivity localFragmentActivity = getActivity();
    if (localFragmentActivity != null) {
      localFragmentActivity.finish();
    }
  }
  
  public int getContentLayoutId()
  {
    return 2131562069;
  }
  
  public void init(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonFromGroup_Fragment", 2, "emoticonFromGroupFragment init start.");
    }
    super.init(paramBundle);
    super.setTitle(HardCodeUtil.a(2131704083));
    paramBundle = getActivity();
    if (paramBundle != null)
    {
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = paramBundle;
      paramBundle = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getAppInterface();
      if (!(paramBundle instanceof QQAppInterface)) {
        break label204;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)paramBundle);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingEmoticonFromGroupManager = ((VasExtensionManager)paramBundle.getManager(QQManagerFactory.VAS_EXTENSION_MANAGER)).jdField_a_of_type_ComTencentMobileqqEmosmFavroamingEmoticonFromGroupManager;
      paramBundle = (FavroamingManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FAV_ROAMING_MANAGER);
      if (paramBundle != null) {
        paramBundle.b();
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppSVIPObserver);
      c();
      d();
      f();
      VasWebviewUtil.reportCommercialDrainage("", "QLbq", "PageView", "0", 1, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonFromGroup_Fragment", 2, "emoticonFromGroupFragment init end.");
      }
      return;
      QLog.e("EmoticonFromGroup_Fragment", 1, "activity is null");
      b();
      break;
      label204:
      QLog.e("EmoticonFromGroup_Fragment", 1, "app is null");
      b();
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt2 == -1) && (paramInt1 == 0))
    {
      Intent localIntent = AIOUtils.a(new Intent(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, SplashActivity.class), null);
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
      PhotoUtils.sendPhoto(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, localIntent, localArrayList, paramInt1, true);
    }
  }
  
  public boolean onBackEvent()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstorePicSelectAdapter != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstorePicSelectAdapter.jdField_a_of_type_Boolean))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((EmoticonFromGroupEntity)localIterator.next()).status = -1;
      }
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstorePicSelectAdapter.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstorePicSelectAdapter.a(false);
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
      VasWebviewUtil.reportCommercialDrainage("", "QLbq", "ClickFilterReturn", "0", 1, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
      return true;
    }
    b();
    return false;
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
      if (this.jdField_b_of_type_AndroidWidgetTextView.getVisibility() == 0) {
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      n();
      a(false);
      setLeftButton(HardCodeUtil.a(2131704115), this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.leftViewNotBack.setTextColor(getResources().getColor(2131165357));
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetButton.setTextColor(Color.parseColor("#FFBFBFBF"));
      this.jdField_b_of_type_AndroidWidgetButton.setBackgroundDrawable(getResources().getDrawable(2130844564));
      this.jdField_b_of_type_AndroidWidgetButton.setEnabled(false);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstorePicSelectAdapter.a(true);
      this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstorePicSelectAdapter.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstorePicSelectAdapter.notifyDataSetChanged();
      VasWebviewUtil.reportCommercialDrainage("", "QLbq", "ClickMutiSel", "0", 1, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
      continue;
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstorePicSelectAdapter.a(false);
      this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstorePicSelectAdapter.jdField_a_of_type_Boolean = false;
      this.jdField_c_of_type_JavaUtilList.addAll(this.jdField_a_of_type_JavaUtilList);
      this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingEmoticonFromGroupManager.d(new ArrayList(this.jdField_a_of_type_JavaUtilList));
      Object localObject1 = this.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((EmoticonFromGroupEntity)((Iterator)localObject1).next()).status = 0;
      }
      localObject1 = (EmoticonFromGroupDBManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EMOFROMGROUP_DB_MANAGER);
      ((EmoticonFromGroupDBManager)localObject1).b -= this.jdField_a_of_type_JavaUtilList.size();
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstorePicSelectAdapter.notifyDataSetChanged();
      m();
      a(true);
      resetLeftButton();
      VasWebviewUtil.reportCommercialDrainage("", "QLbq", "AddMutibq", "0", 1, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
      continue;
      if (this.titleRoot == this.jdField_a_of_type_AndroidViewView.getParent())
      {
        AbstractGifImage.pauseAll();
        this.titleRoot.removeView(this.jdField_a_of_type_AndroidViewView);
        a(true);
        continue;
        this.jdField_a_of_type_AndroidSupportV4ViewViewPager.arrowScroll(17);
        VasWebviewUtil.reportCommercialDrainage("", "QLbq", "SwitchPreview", "0", 1, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
        continue;
        this.jdField_a_of_type_AndroidSupportV4ViewViewPager.arrowScroll(66);
        VasWebviewUtil.reportCommercialDrainage("", "QLbq", "SwitchPreview", "0", 1, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
        continue;
        localObject1 = ((ImgPreviewAdapter)this.jdField_a_of_type_AndroidSupportV4ViewViewPager.getAdapter()).a(this.jdField_a_of_type_AndroidSupportV4ViewViewPager.getCurrentItem());
        if ((localObject1 != null) && (((EmoticonFromGroupEntity)localObject1).msg != null)) {
          AIOGalleryScene.b(new AIORichMediaInfo(AIOGalleryUtils.a(((EmoticonFromGroupEntity)localObject1).msg)), this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 0);
        }
        for (;;)
        {
          VasWebviewUtil.reportCommercialDrainage("", "QLbq", "SendFriend", "0", 1, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
          break;
          QLog.e("EmoticonFromGroup_Fragment.msgnull", 1, "preview send msg is null.");
        }
        localObject1 = ((ImgPreviewAdapter)this.jdField_a_of_type_AndroidSupportV4ViewViewPager.getAdapter()).a(this.jdField_a_of_type_AndroidSupportV4ViewViewPager.getCurrentItem());
        if (this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingEmoticonFromGroupManager.a((EmoticonFromGroupEntity)localObject1))
        {
          this.jdField_c_of_type_JavaUtilList.add(localObject1);
          this.jdField_d_of_type_AndroidWidgetButton.setText(HardCodeUtil.a(2131704074));
          this.jdField_d_of_type_AndroidWidgetButton.setTextColor(Color.parseColor("#FFBBBBBB"));
          this.jdField_d_of_type_AndroidWidgetButton.setBackgroundDrawable(getResources().getDrawable(2130844564));
          this.jdField_d_of_type_AndroidWidgetButton.setEnabled(false);
          this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstorePicSelectAdapter.notifyDataSetChanged();
        }
        if (localObject1 != null) {
          EmoticonUtils.reportFavAddEmotionEvent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 4, ((EmoticonFromGroupEntity)localObject1).md5, null);
        }
        VasWebviewUtil.reportCommercialDrainage("", "QLbq", "Addbq", "0", 1, 0, 0, "", "", "1", "", "", "", "", 0, 0, 0, 0);
        continue;
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
          Object localObject2;
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
          VasWebviewUtil.reportCommercialDrainage("", "QLbq", "ClickFilter", "0", 1, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
          continue;
          l();
          k();
          VasWebviewUtil.reportCommercialDrainage("", "QLbq", "ClickFilterReturn", "0", 1, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
          continue;
          if (!this.jdField_f_of_type_JavaUtilList.isEmpty()) {
            this.jdField_f_of_type_JavaUtilList.clear();
          }
          int j = this.jdField_e_of_type_JavaUtilList.size();
          if (j == 0)
          {
            localObject1 = new ArrayList(this.jdField_b_of_type_JavaUtilList);
            localObject2 = this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingEmoticonFromGroupManager.a((List)localObject1);
            if (localObject2 != null)
            {
              c((List)localObject1);
              this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstorePicSelectAdapter.a((Map)localObject2, (List)localObject1);
            }
          }
          for (;;)
          {
            l();
            k();
            VasWebviewUtil.reportCommercialDrainage("", "QLbq", "ClickFilterConfirm", "0", 1, 0, 0, "", "", "" + j, "", "", "", "", 0, 0, 0, 0);
            break;
            localObject1 = new ArrayList();
            localObject2 = this.jdField_e_of_type_JavaUtilList.iterator();
            while (((Iterator)localObject2).hasNext())
            {
              String str = (String)((Iterator)localObject2).next();
              this.jdField_f_of_type_JavaUtilList.add(str);
              ((List)localObject1).addAll((Collection)this.jdField_a_of_type_JavaUtilMap.get(str));
            }
            Collections.sort((List)localObject1);
            localObject2 = this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingEmoticonFromGroupManager.a((List)localObject1);
            if (localObject2 != null)
            {
              c((List)localObject1);
              this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstorePicSelectAdapter.a((Map)localObject2, (List)localObject1);
            }
          }
          l();
          this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstoreFilterAdapter.notifyDataSetChanged();
          VasWebviewUtil.reportCommercialDrainage("", "QLbq", "ClickFilterReset", "0", 1, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
        }
      }
    }
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingEmoticonFromGroupManager.b(this.jdField_c_of_type_JavaUtilList);
    this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingEmoticonFromGroupManager.c(this.jdField_c_of_type_JavaUtilList);
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
    if (this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstorePicSelectAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstorePicSelectAdapter.notifyDataSetChanged();
    }
    if ((this.jdField_d_of_type_AndroidWidgetButton != null) && (this.jdField_a_of_type_AndroidSupportV4ViewViewPager != null))
    {
      EmoticonFromGroupEntity localEmoticonFromGroupEntity = ((ImgPreviewAdapter)this.jdField_a_of_type_AndroidSupportV4ViewViewPager.getAdapter()).a(this.jdField_a_of_type_AndroidSupportV4ViewViewPager.getCurrentItem());
      if (localEmoticonFromGroupEntity != null)
      {
        if (localEmoticonFromGroupEntity.status != 0) {
          break label123;
        }
        this.jdField_d_of_type_AndroidWidgetButton.setText(HardCodeUtil.a(2131704117));
        this.jdField_d_of_type_AndroidWidgetButton.setTextColor(Color.parseColor("#FFBBBBBB"));
        this.jdField_d_of_type_AndroidWidgetButton.setBackgroundDrawable(getResources().getDrawable(2130844564));
        this.jdField_d_of_type_AndroidWidgetButton.setEnabled(false);
      }
    }
    return;
    label123:
    this.jdField_d_of_type_AndroidWidgetButton.setText(HardCodeUtil.a(2131704078));
    this.jdField_d_of_type_AndroidWidgetButton.setTextColor(Color.parseColor("#FFFFFFFF"));
    this.jdField_d_of_type_AndroidWidgetButton.setBackgroundDrawable(getResources().getDrawable(2130844563));
    this.jdField_d_of_type_AndroidWidgetButton.setEnabled(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.emogroupstore.EmoticonGroupStoreFragment
 * JD-Core Version:    0.7.0.1
 */