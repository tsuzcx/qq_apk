package com.tencent.mobileqq.activity.qwallet.fragment;

import aixs;
import aiyn;
import aiyo;
import aiyp;
import aiyq;
import aizd;
import ajbs;
import ajeu;
import alud;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import bjcf;
import bjcm;
import bjcn;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.qwallet.SendHbActivity;
import com.tencent.mobileqq.activity.qwallet.emoj.EmojiFragment;
import com.tencent.mobileqq.activity.qwallet.redpacket.RedPacketManager;
import com.tencent.mobileqq.activity.qwallet.redpacket.draw.DrawHbFragment;
import com.tencent.mobileqq.activity.qwallet.redpacket.widget.ViewPagerTabLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.TipsBar;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class SendHbMainFragment
  extends BaseHbFragment
  implements View.OnClickListener
{
  public static final String a;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private bjcn jdField_a_of_type_Bjcn = new bjcn();
  private ViewPagerTabLayout jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketWidgetViewPagerTabLayout;
  private List<aiyq> jdField_a_of_type_JavaUtilList = new ArrayList();
  private String b;
  
  static
  {
    jdField_a_of_type_JavaLangString = alud.a(2131714217);
  }
  
  private BaseHbFragment a(ajbs paramajbs, Bundle paramBundle, boolean paramBoolean)
  {
    Object localObject = null;
    JSONArray localJSONArray = null;
    Bundle localBundle = new Bundle(paramBundle);
    int i = paramajbs.jdField_a_of_type_Int;
    if (RedPacketManager.TYPEHBINFOMAP.get(Integer.valueOf(i)) == null) {
      localObject = localJSONArray;
    }
    do
    {
      return localObject;
      localBundle.putString("channel", String.valueOf(RedPacketManager.TYPEHBINFOMAP.get(Integer.valueOf(i))));
      paramBundle = (Bundle)localObject;
      switch (i)
      {
      default: 
        paramBundle = (Bundle)localObject;
      }
      while (paramBundle != null)
      {
        paramBundle.setArguments(localBundle);
        return paramBundle;
        paramBundle = new UsualHbFragment();
        localBundle.putString("bus_type", "1");
        continue;
        if (!paramBoolean)
        {
          paramBundle = (Bundle)localObject;
          if (!bjcm.d.contains(this.b)) {}
        }
        else
        {
          paramBundle = new UsualHbFragment();
          localBundle.putString("bus_type", "2");
          continue;
          if (!paramBoolean)
          {
            paramBundle = (Bundle)localObject;
            if (bjcm.f.contains(this.b)) {}
          }
          else
          {
            paramBundle = new LingHbFragment();
            continue;
            localObject = new KSongFragment();
            paramBundle = (Bundle)localObject;
            if (paramajbs.jdField_a_of_type_OrgJsonJSONObject != null)
            {
              localBundle.putString("pick_entry", paramajbs.jdField_a_of_type_OrgJsonJSONObject.optString("pick_entry", "http://h5.qianbao.qq.com/ktvredpacket"));
              paramBundle = (Bundle)localObject;
              continue;
              if (!paramBoolean)
              {
                paramBundle = (Bundle)localObject;
                if (!RedPacketManager.verifyEmojiHbParams(paramajbs)) {}
              }
              else
              {
                localObject = new EmojiFragment();
                localBundle.putString("prefix", paramajbs.jdField_a_of_type_OrgJsonJSONObject.optString("prefix"));
                localJSONArray = paramajbs.jdField_a_of_type_OrgJsonJSONObject.optJSONArray("heartList");
                paramBundle = (Bundle)localObject;
                if (localJSONArray != null)
                {
                  localBundle.putString("heartList", localJSONArray.toString());
                  paramBundle = (Bundle)localObject;
                  continue;
                  localObject = new WordChainHbFragment();
                  paramBundle = (Bundle)localObject;
                  if (paramajbs.jdField_a_of_type_OrgJsonJSONObject != null)
                  {
                    localBundle.putString("skinId", paramajbs.jdField_a_of_type_OrgJsonJSONObject.optString("skinId"));
                    paramBundle = (Bundle)localObject;
                    continue;
                    if (!paramBoolean)
                    {
                      paramBundle = (Bundle)localObject;
                      if (!RedPacketManager.verifyDrawHbParams(paramajbs)) {}
                    }
                    else
                    {
                      paramBundle = new DrawHbFragment();
                      localBundle.putString("skinId", paramajbs.jdField_a_of_type_OrgJsonJSONObject.optString("skinId"));
                      localBundle.putString("drawParam", paramajbs.jdField_a_of_type_OrgJsonJSONObject.optString("subjects"));
                      continue;
                      if (!paramBoolean)
                      {
                        paramBundle = (Bundle)localObject;
                        if (!bjcm.e.contains(this.b)) {}
                      }
                      else
                      {
                        paramBundle = new ExclusiveHbFragment();
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
      localObject = paramBundle;
    } while (!QLog.isColorLevel());
    QLog.i("SendHbMainFragment", 2, "buildHbFragment...fragment is null,panelData:" + paramajbs.toString());
    return paramBundle;
  }
  
  private String a(ajbs paramajbs)
  {
    String str2 = "";
    String str1 = str2;
    int i;
    if (paramajbs != null)
    {
      str1 = str2;
      if (!TextUtils.isEmpty(paramajbs.b))
      {
        i = paramajbs.b.indexOf(jdField_a_of_type_JavaLangString);
        if (i == -1) {
          break label65;
        }
      }
    }
    label65:
    for (str1 = paramajbs.b.substring(0, i);; str1 = paramajbs.b)
    {
      paramajbs = str1;
      if (TextUtils.isEmpty(str1)) {
        paramajbs = jdField_a_of_type_JavaLangString;
      }
      return paramajbs;
    }
  }
  
  private void a(View paramView)
  {
    paramView = (TipsBar)paramView.findViewById(2131367496);
    paramView.setVisibility(8);
    Object localObject1;
    String str1;
    try
    {
      localObject1 = ajeu.a();
      if (localObject1 == null) {
        return;
      }
      localObject1 = (aixs)((QQAppInterface)localObject1).getManager(245);
      if ((localObject1 == null) || (((aixs)localObject1).a("common") == null)) {
        return;
      }
      localObject1 = ((aixs)localObject1).a("common").getJSONObject("make_hb_bulletin");
      if (localObject1 == null) {
        return;
      }
      str1 = ((JSONObject)localObject1).optString("content_text");
      localObject2 = ((JSONObject)localObject1).optString("begintime");
      String str2 = ((JSONObject)localObject1).optString("endtime");
      if (TextUtils.isEmpty(str1.trim())) {
        return;
      }
      if (!RedPacketManager.isBulletinValidDate((String)localObject2, str2))
      {
        if (!QLog.isColorLevel()) {
          return;
        }
        QLog.w("SendHbMainFragment", 2, "isBulletinValidDate:false,start_time:" + (String)localObject2 + " end_time:" + str2);
        return;
      }
    }
    catch (Throwable paramView)
    {
      QLog.e("SendHbMainFragment", 1, paramView, new Object[0]);
      return;
    }
    Object localObject2 = BaseApplicationImpl.getApplication().getSharedPreferences("red_packet", 0);
    int i = ((JSONObject)localObject1).optInt("bulletin_id");
    if (i != ((SharedPreferences)localObject2).getInt("red_packet_bulletin", -1))
    {
      paramView.setBarType(2);
      paramView.setTipsIcon(getResources().getDrawable(2130839101));
      if (paramView.b() != null) {
        paramView.b().setVisibility(0);
      }
      paramView.setVisibility(0);
      paramView.setTipsText(str1);
      paramView.setEnabled(true);
      paramView.setOnClickListener(new aiyn(this, (JSONObject)localObject1));
      paramView.setCloseListener(new aiyo(this, paramView, (SharedPreferences)localObject2, i));
    }
  }
  
  private void a(View paramView, Bundle paramBundle)
  {
    bjcm.a(paramBundle, this.jdField_a_of_type_Bjcn);
    this.b = this.jdField_a_of_type_Bjcn.recv_type;
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368794));
    b(paramView);
    a(paramView, paramBundle.getString("hbTitle", getString(2131697228)));
    if (!a(paramBundle))
    {
      QLog.i("SendHbMainFragment", 1, "initHbData failed...");
      QQToast.a(this.mActivity, alud.a(2131714214), 0).a();
      this.mActivity.finish();
      return;
    }
    paramBundle = (ViewPager)paramView.findViewById(2131379490);
    paramBundle.setOffscreenPageLimit(1);
    paramBundle.setAdapter(new aiyp(this, getChildFragmentManager()));
    paramBundle.setCurrentItem(a(b()), false);
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketWidgetViewPagerTabLayout = ((ViewPagerTabLayout)paramView.findViewById(2131377381));
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketWidgetViewPagerTabLayout.setBoldStyle(1);
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketWidgetViewPagerTabLayout.setScrollOnTabClick(false);
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketWidgetViewPagerTabLayout.setViewPager(paramBundle);
    ThreadManagerV2.getUIHandlerV2().post(new SendHbMainFragment.4(this));
    a(paramView);
  }
  
  private boolean a(Bundle paramBundle)
  {
    boolean bool2 = false;
    int i = paramBundle.getInt("tabMask", 0);
    boolean bool1 = paramBundle.getBoolean("isFromPanel");
    this.jdField_a_of_type_JavaUtilList.clear();
    if (QLog.isColorLevel()) {
      QLog.i("SendHbMainFragment", 2, "initHbData... isFromPanel:" + bool1 + " tabMask:" + i);
    }
    Object localObject2;
    if (i != 0)
    {
      if ((i & 0x2) == 2)
      {
        localObject1 = new Bundle(paramBundle);
        ((Bundle)localObject1).putString("bus_type", "2");
        localObject2 = new UsualHbFragment();
        ((UsualHbFragment)localObject2).setArguments((Bundle)localObject1);
        localObject1 = new aiyq(1, alud.a(2131714215), (BaseHbFragment)localObject2);
        this.jdField_a_of_type_JavaUtilList.add(localObject1);
      }
      if ((i & 0x1) == 1)
      {
        paramBundle = new Bundle(paramBundle);
        paramBundle.putString("bus_type", "1");
        localObject1 = new UsualHbFragment();
        ((UsualHbFragment)localObject1).setArguments(paramBundle);
        paramBundle = new aiyq(0, alud.a(2131714216), (BaseHbFragment)localObject1);
        this.jdField_a_of_type_JavaUtilList.add(paramBundle);
      }
      bool1 = bool2;
      if (!this.jdField_a_of_type_JavaUtilList.isEmpty()) {
        bool1 = true;
      }
      return bool1;
    }
    Object localObject1 = new ArrayList();
    if (bool1) {
      if ((RedPacketManager.CURRENT_PANEL_DATA != null) && (RedPacketManager.CURRENT_PANEL_DATA.size() != 0)) {
        ((List)localObject1).addAll(RedPacketManager.CURRENT_PANEL_DATA);
      }
    }
    for (;;)
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ajbs)((Iterator)localObject1).next();
        if (localObject2 != null) {
          try
          {
            if (!TextUtils.isEmpty(((ajbs)localObject2).b))
            {
              BaseHbFragment localBaseHbFragment = a((ajbs)localObject2, paramBundle, bool1);
              if (localBaseHbFragment != null) {
                this.jdField_a_of_type_JavaUtilList.add(new aiyq(((ajbs)localObject2).jdField_a_of_type_Int, a((ajbs)localObject2), localBaseHbFragment));
              }
            }
          }
          catch (Throwable localThrowable)
          {
            QLog.e("SendHbMainFragment", 1, localThrowable, new Object[0]);
          }
        }
      }
      break;
      QLog.e("SendHbMainFragment", 1, "isFromPanel but cacheData isEmpty");
      ((List)localObject1).addAll(((RedPacketManager)RedPacketManager.getInstance()).getPanelList(null));
      bool1 = false;
      continue;
      ((List)localObject1).addAll(((RedPacketManager)RedPacketManager.getInstance()).getPanelList(null));
    }
  }
  
  private int b()
  {
    return aizd.a(this.channel, bjcf.a(this.bundle.getString("bus_type"), 2));
  }
  
  private void b(View paramView)
  {
    try
    {
      int i = ImmersiveUtils.isSupporImmersive();
      int j = ImmersiveUtils.getStatusBarHeight(this.mActivity);
      if (i == 1)
      {
        paramView = paramView.findViewById(2131379497);
        paramView.getLayoutParams().height = j;
        paramView.requestLayout();
        if (QLog.isColorLevel()) {
          QLog.i("SendHbMainFragment", 2, "initImmersive:" + i + " barHeight: " + j);
        }
      }
      return;
    }
    catch (Throwable paramView)
    {
      QLog.e("SendHbMainFragment", 1, paramView, new Object[0]);
    }
  }
  
  public int a()
  {
    try
    {
      int i = ((aiyq)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketWidgetViewPagerTabLayout.a())).jdField_a_of_type_Int;
      return i;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("SendHbMainFragment", 1, localThrowable, new Object[0]);
    }
    return 1;
  }
  
  public int a(int paramInt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    aiyq localaiyq;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localaiyq = (aiyq)localIterator.next();
    } while (localaiyq.jdField_a_of_type_Int != paramInt);
    for (int i = this.jdField_a_of_type_JavaUtilList.indexOf(localaiyq);; i = 0)
    {
      if (QLog.isColorLevel()) {
        QLog.i("SendHbMainFragment", 2, "findPositionByType, type:" + paramInt + " pos:" + i);
      }
      return i;
    }
  }
  
  public BaseHbFragment a()
  {
    try
    {
      BaseHbFragment localBaseHbFragment = ((aiyq)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketWidgetViewPagerTabLayout.a())).jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentBaseHbFragment;
      return localBaseHbFragment;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("SendHbMainFragment", 1, localThrowable, new Object[0]);
    }
    return null;
  }
  
  public void a()
  {
    int i = a();
    switch (i)
    {
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("SendHbMainFragment", 2, "reportHbBack,curType:" + i);
      }
      return;
      this.mActivity.c("idiom.wrappacket.back");
      continue;
      this.mActivity.c("ksong.wrappacket.back");
      continue;
      this.mActivity.c("draw.wrappacket.back");
      continue;
      this.mActivity.c("phiz.wrappacket.back");
      continue;
      this.mActivity.c("only.wrappacket.back");
    }
  }
  
  public void a(View paramView, String paramString)
  {
    paramView.findViewById(2131368655).setVisibility(4);
    ((TextView)paramView.findViewById(2131368670)).setText(paramString);
    paramView.findViewById(2131368624).setOnClickListener(this);
    paramView.findViewById(2131375863).setBackgroundColor(this.mActivity.getResources().getColor(2131166143));
    paramView = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[] { Color.parseColor("#FF6D6D"), Color.parseColor("#FF2151") });
    this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(paramView);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    BaseHbFragment localBaseHbFragment = a();
    if (localBaseHbFragment != null) {
      localBaseHbFragment.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
    if (QLog.isColorLevel()) {
      QLog.i("SendHbMainFragment", 2, "onActivityResult, requestCode:" + paramInt1 + " resultCode:" + paramInt2 + " curFragment:" + localBaseHbFragment);
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131368624)
    {
      a();
      this.mActivity.a();
      this.mActivity.finish();
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    paramLayoutInflater = paramLayoutInflater.inflate(2131561722, null);
    a(paramLayoutInflater, getArguments());
    return paramLayoutInflater;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.fragment.SendHbMainFragment
 * JD-Core Version:    0.7.0.1
 */