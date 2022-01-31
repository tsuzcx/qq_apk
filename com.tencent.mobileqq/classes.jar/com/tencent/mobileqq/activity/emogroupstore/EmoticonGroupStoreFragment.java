package com.tencent.mobileqq.activity.emogroupstore;

import aciy;
import advv;
import adwz;
import adyb;
import afia;
import afib;
import afic;
import afid;
import afie;
import afif;
import afig;
import afii;
import afil;
import afim;
import ajjy;
import ajrp;
import anbu;
import anbw;
import ancg;
import anch;
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
import awmc;
import azzu;
import babh;
import baov;
import com.tencent.common.app.AppInterface;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.photo.SendPhotoActivity;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.data.EmoticonFromGroupEntity;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.qphone.base.util.QLog;
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
  private afig jdField_a_of_type_Afig;
  private afim jdField_a_of_type_Afim;
  ajrp jdField_a_of_type_Ajrp = new afia(this);
  private anbw jdField_a_of_type_Anbw;
  private FragmentActivity jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
  private ViewPager jdField_a_of_type_AndroidSupportV4ViewViewPager;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private SpannableString jdField_a_of_type_AndroidTextSpannableString;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new afib(this);
  private View jdField_a_of_type_AndroidViewView;
  private AlphaAnimation jdField_a_of_type_AndroidViewAnimationAlphaAnimation;
  private TranslateAnimation jdField_a_of_type_AndroidViewAnimationTranslateAnimation;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private ListView jdField_a_of_type_AndroidWidgetListView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  TopGestureLayout jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private StringBuilder jdField_a_of_type_JavaLangStringBuilder = new StringBuilder("    ");
  public List<EmoticonFromGroupEntity> a;
  private Map<String, List<EmoticonFromGroupEntity>> jdField_a_of_type_JavaUtilMap;
  private volatile boolean jdField_a_of_type_Boolean;
  private View jdField_b_of_type_AndroidViewView;
  private AlphaAnimation jdField_b_of_type_AndroidViewAnimationAlphaAnimation;
  private TranslateAnimation jdField_b_of_type_AndroidViewAnimationTranslateAnimation;
  private Button jdField_b_of_type_AndroidWidgetButton;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private List<EmoticonFromGroupEntity> jdField_b_of_type_JavaUtilList = new CopyOnWriteArrayList();
  private Map<String, afii> jdField_b_of_type_JavaUtilMap;
  private volatile boolean jdField_b_of_type_Boolean;
  private View jdField_c_of_type_AndroidViewView;
  private Button jdField_c_of_type_AndroidWidgetButton;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private List<EmoticonFromGroupEntity> jdField_c_of_type_JavaUtilList = new CopyOnWriteArrayList();
  private View jdField_d_of_type_AndroidViewView;
  private Button jdField_d_of_type_AndroidWidgetButton;
  private List<afii> jdField_d_of_type_JavaUtilList;
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
          MessageForPic localMessageForPic = this.jdField_a_of_type_Anbw.a(localEmoticonFromGroupEntity);
          if (localMessageForPic != null)
          {
            localEmoticonFromGroupEntity.msg = localMessageForPic;
            this.jdField_b_of_type_JavaUtilList.add(localEmoticonFromGroupEntity);
          }
          else
          {
            this.jdField_a_of_type_Anbw.b(localEmoticonFromGroupEntity);
            this.jdField_a_of_type_Anbw.a(localEmoticonFromGroupEntity);
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
    Object localObject1 = (ancg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(149);
    if (QLog.isColorLevel()) {
      QLog.i("EmoticonFromGroup_Fragment", 2, "call getEmoticonDataList from EmoticonGroupStoreFragment.filterFavEmo");
    }
    Object localObject2 = ((ancg)localObject1).a();
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
      if (this.jdField_a_of_type_Anbw.a((List)localObject1, localEmoticonFromGroupEntity.bigURL))
      {
        localEmoticonFromGroupEntity.status = 0;
        ((List)localObject2).add(localEmoticonFromGroupEntity);
      }
    }
    this.jdField_c_of_type_JavaUtilList.addAll((Collection)localObject2);
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131312648));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)this.mContentView.findViewById(2131305953));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.mContentView.findViewById(2131297983));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.mContentView.findViewById(2131301582));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)this.mContentView.findViewById(2131298007));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this.titleRoot.getContext()).inflate(2131495914, this.titleRoot, false);
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131299996);
    this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131299997);
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager = ((ViewPager)this.jdField_a_of_type_AndroidViewView.findViewById(2131299998));
    this.jdField_d_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131297981);
    this.jdField_e_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131297982);
    this.jdField_c_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131298009));
    this.jdField_d_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131298008));
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_d_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_e_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_d_of_type_AndroidWidgetButton.setOnClickListener(this);
    Object localObject = new LinearLayoutManager(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 1, false);
    ((LinearLayoutManager)localObject).setRecycleChildrenOnDetach(true);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager((RecyclerView.LayoutManager)localObject);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131312638));
    this.jdField_f_of_type_AndroidViewView = new View(this.titleRoot.getContext());
    localObject = new RelativeLayout.LayoutParams(-1, -1);
    this.jdField_f_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.jdField_f_of_type_AndroidViewView.setBackgroundColor(Color.parseColor(getString(2131099748)));
    try
    {
      this.jdField_g_of_type_AndroidViewView = LayoutInflater.from(this.titleRoot.getContext()).inflate(2131495909, this.titleRoot, false);
      this.h = this.jdField_g_of_type_AndroidViewView.findViewById(2131300665);
      this.h.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetListView = ((ListView)this.jdField_g_of_type_AndroidViewView.findViewById(2131303934));
      this.jdField_a_of_type_AndroidWidgetListView.setOnItemClickListener(new afic(this));
      this.jdField_a_of_type_Afig = new afig(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
      this.jdField_a_of_type_AndroidWidgetListView.setAdapter(this.jdField_a_of_type_Afig);
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_g_of_type_AndroidViewView.findViewById(2131312646));
      this.jdField_e_of_type_AndroidWidgetButton = ((Button)this.jdField_g_of_type_AndroidViewView.findViewById(2131297992));
      this.jdField_f_of_type_AndroidWidgetButton = ((Button)this.jdField_g_of_type_AndroidViewView.findViewById(2131297991));
      this.jdField_e_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_f_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.i = this.mContentView.findViewById(2131301583);
      ((URLImageView)this.i.findViewById(2131302350)).setImageDrawable(URLDrawable.getDrawable("http://imgcache.gtimg.cn/ACT/svip_act/act_img/public/201802/m1517913373_empty_img_1.png"));
      this.jdField_g_of_type_AndroidWidgetButton = new Button(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
      this.jdField_g_of_type_AndroidWidgetButton.setId(2131310924);
      localObject = new RelativeLayout.LayoutParams(awmc.a(21.0F), awmc.a(20.0F));
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
      String str = String.format(getString(2131627553), new Object[] { Integer.valueOf(k) });
      if (k < 3) {
        j = paramList.size();
      }
      k = 0;
      for (;;)
      {
        if (k < j)
        {
          URLDrawable localURLDrawable = (URLDrawable)this.jdField_a_of_type_Anbw.a((EmoticonFromGroupEntity)paramList.get(k), 65537, awmc.a(11.0F), null);
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
              localURLDrawable.setURLDrawableListener(new afif(this));
              k = m;
              continue;
              k = paramList.size();
              break;
            }
          }
        }
      }
      this.jdField_a_of_type_AndroidTextSpannableString = new SpannableString(this.jdField_a_of_type_JavaLangStringBuilder + str);
      paramList = new afil(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      paramList.a(localArrayList, awmc.a(11.0F));
      paramList.setBounds(0, 0, awmc.a(33.0F), awmc.a(22.0F));
      this.jdField_a_of_type_AndroidTextSpannableString.setSpan(new ImageSpan(paramList, 0), 0, this.jdField_a_of_type_JavaLangStringBuilder.length() - 4, 17);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(14.0F);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#FF777777"));
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidTextSpannableString);
    }
  }
  
  private void d()
  {
    this.leftView.setVisibility(0);
    this.leftView.setText(2131627554);
    this.leftView.setTextColor(getResources().getColor(2131099738));
    this.leftView.setBackgroundDrawable(getResources().getDrawable(2130839699));
    this.centerView.setTextColor(getResources().getColor(2131099738));
    this.jdField_g_of_type_AndroidWidgetButton.setBackgroundResource(2130839667);
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
    this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation.setAnimationListener(new afid(this));
    this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation.setFillAfter(true);
    this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation.setDuration(500L);
    e();
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.i.setVisibility(8);
  }
  
  private void e()
  {
    this.jdField_a_of_type_Afim = new afim(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, this.jdField_a_of_type_Anbw.a(), this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_AndroidSupportV4ViewViewPager, this.jdField_b_of_type_AndroidWidgetButton);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Afim);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setOnScrollListener(new afie(this));
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
    afii localafii;
    EmoticonFromGroupEntity localEmoticonFromGroupEntity;
    if (((Iterator)localObject3).hasNext())
    {
      localEntry = (Map.Entry)((Iterator)localObject3).next();
      localafii = new afii();
      localEmoticonFromGroupEntity = (EmoticonFromGroupEntity)((List)localEntry.getValue()).get(0);
      if (1 == localEmoticonFromGroupEntity.fromType)
      {
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(4, localEmoticonFromGroupEntity.troopUin, (byte)2, false, (byte)1, 0);
        localObject1 = babh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localEmoticonFromGroupEntity.troopUin, true);
      }
    }
    for (;;)
    {
      localafii.jdField_a_of_type_JavaLangString = localEmoticonFromGroupEntity.troopUin;
      localafii.jdField_a_of_type_AndroidGraphicsBitmap = ((Bitmap)localObject2);
      localafii.jdField_a_of_type_Boolean = false;
      localafii.b = ((String)localObject1);
      localafii.jdField_a_of_type_Int = ((List)localEntry.getValue()).size();
      localCopyOnWriteArrayList.add(localafii);
      localConcurrentHashMap2.put(localafii.jdField_a_of_type_JavaLangString, localafii);
      break;
      if (3000 == localEmoticonFromGroupEntity.fromType)
      {
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(101, localEmoticonFromGroupEntity.troopUin, (byte)3, false, (byte)1, 0);
        localObject1 = babh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, localEmoticonFromGroupEntity.troopUin);
        continue;
        this.jdField_a_of_type_JavaUtilMap = localConcurrentHashMap1;
        this.jdField_d_of_type_JavaUtilList = localCopyOnWriteArrayList;
        this.jdField_b_of_type_JavaUtilMap = localConcurrentHashMap2;
        if (Looper.myLooper() != Looper.getMainLooper())
        {
          ThreadManager.getUIHandler().post(new EmoticonGroupStoreFragment.11(this));
          return;
        }
        this.jdField_a_of_type_Afig.a(this.jdField_d_of_type_JavaUtilList);
        this.jdField_a_of_type_Afig.notifyDataSetChanged();
        this.jdField_c_of_type_AndroidWidgetTextView.setText(ajjy.a(2131638269) + this.jdField_b_of_type_JavaUtilList.size() + ajjy.a(2131638281));
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
      ((afii)localIterator.next()).jdField_a_of_type_Boolean = false;
    }
    if (!this.jdField_e_of_type_JavaUtilList.isEmpty()) {
      this.jdField_e_of_type_JavaUtilList.clear();
    }
  }
  
  private void m()
  {
    this.jdField_g_of_type_AndroidWidgetButton.setBackgroundResource(2130839667);
    this.jdField_g_of_type_AndroidWidgetButton.setEnabled(true);
  }
  
  private void n()
  {
    this.jdField_g_of_type_AndroidWidgetButton.setBackgroundResource(2130839668);
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
        if ((azzu.b()) || (azzu.d())) {
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
    if ((Build.VERSION.SDK_INT >= 23) && (!azzu.b()) && (!azzu.d()))
    {
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getWindow().getDecorView().setSystemUiVisibility(9216);
      localSystemBarCompact.setStatusBarColor(-1);
      return;
    }
    if (!azzu.d())
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
    return 2131495912;
  }
  
  public void init(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonFromGroup_Fragment", 2, "emoticonFromGroupFragment init start.");
    }
    super.init(paramBundle);
    super.setTitle(ajjy.a(2131638270));
    paramBundle = getActivity();
    if (paramBundle != null)
    {
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = paramBundle;
      paramBundle = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getAppInterface();
      if (!(paramBundle instanceof QQAppInterface)) {
        break label203;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)paramBundle);
    }
    for (;;)
    {
      this.jdField_a_of_type_Anbw = ((baov)paramBundle.getManager(235)).jdField_a_of_type_Anbw;
      paramBundle = (anch)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(103);
      if (paramBundle != null) {
        paramBundle.b();
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajrp);
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
      label203:
      QLog.e("EmoticonFromGroup_Fragment", 1, "app is null");
      b();
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt2 == -1) && (paramInt1 == 0))
    {
      Intent localIntent = aciy.a(new Intent(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, SplashActivity.class), null);
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
      PhotoUtils.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, localIntent, localArrayList, paramInt1, true);
    }
  }
  
  public boolean onBackEvent()
  {
    if ((this.jdField_a_of_type_Afim != null) && (this.jdField_a_of_type_Afim.jdField_a_of_type_Boolean))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((EmoticonFromGroupEntity)localIterator.next()).status = -1;
      }
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      this.jdField_a_of_type_Afim.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Afim.a(false);
      this.jdField_a_of_type_Afim.notifyDataSetChanged();
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
    Object localObject;
    switch (paramView.getId())
    {
    case 2131299997: 
    default: 
    case 2131297983: 
    case 2131298007: 
    case 2131299996: 
    case 2131297981: 
    case 2131297982: 
    case 2131298009: 
    case 2131298008: 
    case 2131310924: 
      do
      {
        do
        {
          return;
          if (this.jdField_b_of_type_AndroidWidgetTextView.getVisibility() == 0) {
            this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
          }
          n();
          a(false);
          setLeftButton(ajjy.a(2131638302), this.jdField_a_of_type_AndroidViewView$OnClickListener);
          this.leftViewNotBack.setTextColor(getResources().getColor(2131099738));
          this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
          this.jdField_b_of_type_AndroidWidgetButton.setTextColor(Color.parseColor("#FFBFBFBF"));
          this.jdField_b_of_type_AndroidWidgetButton.setBackgroundDrawable(getResources().getDrawable(2130843495));
          this.jdField_b_of_type_AndroidWidgetButton.setEnabled(false);
          this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
          this.jdField_a_of_type_Afim.a(true);
          this.jdField_a_of_type_Afim.jdField_a_of_type_Boolean = true;
          this.jdField_a_of_type_Afim.notifyDataSetChanged();
          VasWebviewUtil.reportCommercialDrainage("", "QLbq", "ClickMutiSel", "0", 1, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
          return;
          this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
          this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
          this.jdField_a_of_type_Afim.a(false);
          this.jdField_a_of_type_Afim.jdField_a_of_type_Boolean = false;
          this.jdField_c_of_type_JavaUtilList.addAll(this.jdField_a_of_type_JavaUtilList);
          this.jdField_a_of_type_Anbw.d(new ArrayList(this.jdField_a_of_type_JavaUtilList));
          paramView = this.jdField_a_of_type_JavaUtilList.iterator();
          while (paramView.hasNext()) {
            ((EmoticonFromGroupEntity)paramView.next()).status = 0;
          }
          paramView = (anbu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(259);
          paramView.b -= this.jdField_a_of_type_JavaUtilList.size();
          this.jdField_a_of_type_JavaUtilList.clear();
          this.jdField_a_of_type_Afim.notifyDataSetChanged();
          m();
          a(true);
          resetLeftButton();
          VasWebviewUtil.reportCommercialDrainage("", "QLbq", "AddMutibq", "0", 1, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
          return;
        } while (this.titleRoot != this.jdField_a_of_type_AndroidViewView.getParent());
        AbstractGifImage.pauseAll();
        this.titleRoot.removeView(this.jdField_a_of_type_AndroidViewView);
        a(true);
        return;
        this.jdField_a_of_type_AndroidSupportV4ViewViewPager.arrowScroll(17);
        VasWebviewUtil.reportCommercialDrainage("", "QLbq", "SwitchPreview", "0", 1, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
        return;
        this.jdField_a_of_type_AndroidSupportV4ViewViewPager.arrowScroll(66);
        VasWebviewUtil.reportCommercialDrainage("", "QLbq", "SwitchPreview", "0", 1, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
        return;
        paramView = ((ImgPreviewAdapter)this.jdField_a_of_type_AndroidSupportV4ViewViewPager.getAdapter()).a(this.jdField_a_of_type_AndroidSupportV4ViewViewPager.getCurrentItem());
        if ((paramView != null) && (paramView.msg != null)) {
          advv.b(new adyb(adwz.a(paramView.msg)), this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 0);
        }
        for (;;)
        {
          VasWebviewUtil.reportCommercialDrainage("", "QLbq", "SendFriend", "0", 1, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
          return;
          QLog.e("EmoticonFromGroup_Fragment.msgnull", 1, "preview send msg is null.");
        }
        paramView = ((ImgPreviewAdapter)this.jdField_a_of_type_AndroidSupportV4ViewViewPager.getAdapter()).a(this.jdField_a_of_type_AndroidSupportV4ViewViewPager.getCurrentItem());
        if (this.jdField_a_of_type_Anbw.a(paramView))
        {
          this.jdField_c_of_type_JavaUtilList.add(paramView);
          this.jdField_d_of_type_AndroidWidgetButton.setText(ajjy.a(2131638261));
          this.jdField_d_of_type_AndroidWidgetButton.setTextColor(Color.parseColor("#FFBBBBBB"));
          this.jdField_d_of_type_AndroidWidgetButton.setBackgroundDrawable(getResources().getDrawable(2130843495));
          this.jdField_d_of_type_AndroidWidgetButton.setEnabled(false);
          this.jdField_a_of_type_Afim.notifyDataSetChanged();
        }
        VasWebviewUtil.reportCommercialDrainage("", "QLbq", "Addbq", "0", 1, 0, 0, "", "", "1", "", "", "", "", 0, 0, 0, 0);
        return;
        if (this.jdField_g_of_type_AndroidViewView != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.i("EmoticonFromGroup_Fragment", 2, "click right img useless, filterView is null.");
      return;
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
      paramView = this.jdField_f_of_type_JavaUtilList.iterator();
      while (paramView.hasNext())
      {
        localObject = (String)paramView.next();
        this.jdField_e_of_type_JavaUtilList.add(localObject);
        ((afii)this.jdField_b_of_type_JavaUtilMap.get(localObject)).jdField_a_of_type_Boolean = true;
      }
      if (!this.jdField_b_of_type_Boolean)
      {
        this.jdField_b_of_type_Boolean = true;
        j();
      }
      VasWebviewUtil.reportCommercialDrainage("", "QLbq", "ClickFilter", "0", 1, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
      return;
    case 2131300665: 
      l();
      k();
      VasWebviewUtil.reportCommercialDrainage("", "QLbq", "ClickFilterReturn", "0", 1, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
      return;
    case 2131297991: 
      if (!this.jdField_f_of_type_JavaUtilList.isEmpty()) {
        this.jdField_f_of_type_JavaUtilList.clear();
      }
      int j = this.jdField_e_of_type_JavaUtilList.size();
      if (j == 0)
      {
        paramView = new ArrayList(this.jdField_b_of_type_JavaUtilList);
        localObject = this.jdField_a_of_type_Anbw.a(paramView);
        if (localObject != null)
        {
          c(paramView);
          this.jdField_a_of_type_Afim.a((Map)localObject, paramView);
        }
      }
      for (;;)
      {
        l();
        k();
        VasWebviewUtil.reportCommercialDrainage("", "QLbq", "ClickFilterConfirm", "0", 1, 0, 0, "", "", "" + j, "", "", "", "", 0, 0, 0, 0);
        return;
        paramView = new ArrayList();
        localObject = this.jdField_e_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          this.jdField_f_of_type_JavaUtilList.add(str);
          paramView.addAll((Collection)this.jdField_a_of_type_JavaUtilMap.get(str));
        }
        Collections.sort(paramView);
        localObject = this.jdField_a_of_type_Anbw.a(paramView);
        if (localObject != null)
        {
          c(paramView);
          this.jdField_a_of_type_Afim.a((Map)localObject, paramView);
        }
      }
    }
    l();
    this.jdField_a_of_type_Afig.notifyDataSetChanged();
    VasWebviewUtil.reportCommercialDrainage("", "QLbq", "ClickFilterReset", "0", 1, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_Anbw.b(this.jdField_c_of_type_JavaUtilList);
    this.jdField_a_of_type_Anbw.c(this.jdField_c_of_type_JavaUtilList);
    MqqHandler localMqqHandler = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(ChatActivity.class);
    if (localMqqHandler != null) {
      localMqqHandler.obtainMessage(10).sendToTarget();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajrp);
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
    if (this.jdField_a_of_type_Afim != null) {
      this.jdField_a_of_type_Afim.notifyDataSetChanged();
    }
    if ((this.jdField_d_of_type_AndroidWidgetButton != null) && (this.jdField_a_of_type_AndroidSupportV4ViewViewPager != null))
    {
      EmoticonFromGroupEntity localEmoticonFromGroupEntity = ((ImgPreviewAdapter)this.jdField_a_of_type_AndroidSupportV4ViewViewPager.getAdapter()).a(this.jdField_a_of_type_AndroidSupportV4ViewViewPager.getCurrentItem());
      if (localEmoticonFromGroupEntity != null)
      {
        if (localEmoticonFromGroupEntity.status != 0) {
          break label123;
        }
        this.jdField_d_of_type_AndroidWidgetButton.setText(ajjy.a(2131638304));
        this.jdField_d_of_type_AndroidWidgetButton.setTextColor(Color.parseColor("#FFBBBBBB"));
        this.jdField_d_of_type_AndroidWidgetButton.setBackgroundDrawable(getResources().getDrawable(2130843495));
        this.jdField_d_of_type_AndroidWidgetButton.setEnabled(false);
      }
    }
    return;
    label123:
    this.jdField_d_of_type_AndroidWidgetButton.setText(ajjy.a(2131638265));
    this.jdField_d_of_type_AndroidWidgetButton.setTextColor(Color.parseColor("#FFFFFFFF"));
    this.jdField_d_of_type_AndroidWidgetButton.setBackgroundDrawable(getResources().getDrawable(2130843494));
    this.jdField_d_of_type_AndroidWidgetButton.setEnabled(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.emogroupstore.EmoticonGroupStoreFragment
 * JD-Core Version:    0.7.0.1
 */