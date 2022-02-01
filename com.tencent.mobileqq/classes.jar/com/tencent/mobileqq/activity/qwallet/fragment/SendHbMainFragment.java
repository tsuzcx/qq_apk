package com.tencent.mobileqq.activity.qwallet.fragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.qwallet.SendHbActivity;
import com.tencent.mobileqq.activity.qwallet.config.QWalletConfigManager;
import com.tencent.mobileqq.activity.qwallet.emoj.EmojiFragment;
import com.tencent.mobileqq.activity.qwallet.fragment.busylogic.HbBusiUtils;
import com.tencent.mobileqq.activity.qwallet.redpacket.PanelData;
import com.tencent.mobileqq.activity.qwallet.redpacket.RedPacketManager;
import com.tencent.mobileqq.activity.qwallet.redpacket.draw.DrawHbFragment;
import com.tencent.mobileqq.activity.qwallet.redpacket.widget.ViewPagerTabLayout;
import com.tencent.mobileqq.activity.qwallet.utils.QWalletTools;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.banner.TipsBar;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qwallet.QwUtils;
import cooperation.qwallet.pluginshare.HbInfo;
import cooperation.qwallet.pluginshare.HbInfo.BundleInfo;
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
  private ViewPagerTabLayout jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketWidgetViewPagerTabLayout;
  private HbInfo.BundleInfo jdField_a_of_type_CooperationQwalletPluginshareHbInfo$BundleInfo = new HbInfo.BundleInfo();
  private List<SendHbMainFragment.HbHolder> jdField_a_of_type_JavaUtilList = new ArrayList();
  private String b;
  
  static
  {
    jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131713773);
  }
  
  private BaseHbFragment a(PanelData paramPanelData, Bundle paramBundle, boolean paramBoolean)
  {
    Object localObject = null;
    JSONArray localJSONArray = null;
    Bundle localBundle = new Bundle(paramBundle);
    int i = paramPanelData.jdField_a_of_type_Int;
    localBundle.putString("panel_name", paramPanelData.b);
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
          if (!HbInfo.d.contains(this.b)) {}
        }
        else
        {
          paramBundle = new UsualHbFragment();
          localBundle.putString("bus_type", "2");
          continue;
          if (!paramBoolean)
          {
            paramBundle = (Bundle)localObject;
            if (HbInfo.f.contains(this.b)) {}
          }
          else
          {
            paramBundle = new LingHbFragment();
            continue;
            localObject = new KSongFragment();
            paramBundle = (Bundle)localObject;
            if (paramPanelData.jdField_a_of_type_OrgJsonJSONObject != null)
            {
              localBundle.putString("pick_entry", paramPanelData.jdField_a_of_type_OrgJsonJSONObject.optString("pick_entry", "https://h5.qianbao.qq.com/ktvredpacket"));
              paramBundle = (Bundle)localObject;
              continue;
              if (!paramBoolean)
              {
                paramBundle = (Bundle)localObject;
                if (!RedPacketManager.verifyEmojiHbParams(paramPanelData)) {}
              }
              else
              {
                localObject = new EmojiFragment();
                localBundle.putString("prefix", paramPanelData.jdField_a_of_type_OrgJsonJSONObject.optString("prefix"));
                localJSONArray = paramPanelData.jdField_a_of_type_OrgJsonJSONObject.optJSONArray("heartList");
                paramBundle = (Bundle)localObject;
                if (localJSONArray != null)
                {
                  localBundle.putString("heartList", localJSONArray.toString());
                  paramBundle = (Bundle)localObject;
                  continue;
                  localObject = new WordChainHbFragment();
                  paramBundle = (Bundle)localObject;
                  if (paramPanelData.jdField_a_of_type_OrgJsonJSONObject != null)
                  {
                    localBundle.putString("skinId", paramPanelData.jdField_a_of_type_OrgJsonJSONObject.optString("skinId"));
                    paramBundle = (Bundle)localObject;
                    continue;
                    if (!paramBoolean)
                    {
                      paramBundle = (Bundle)localObject;
                      if (!RedPacketManager.verifyDrawHbParams(paramPanelData)) {}
                    }
                    else
                    {
                      paramBundle = new DrawHbFragment();
                      localBundle.putString("skinId", paramPanelData.jdField_a_of_type_OrgJsonJSONObject.optString("skinId"));
                      localBundle.putString("drawParam", paramPanelData.jdField_a_of_type_OrgJsonJSONObject.optString("subjects"));
                      localBundle.putString("recommend", paramPanelData.jdField_a_of_type_OrgJsonJSONObject.optString("recommend"));
                      localBundle.putString("modelList", paramPanelData.jdField_a_of_type_OrgJsonJSONObject.optString("modelList"));
                      continue;
                      if (!paramBoolean)
                      {
                        paramBundle = (Bundle)localObject;
                        if (!HbInfo.e.contains(this.b)) {}
                      }
                      else
                      {
                        paramBundle = new ExclusiveHbFragment();
                        continue;
                        if (!paramBoolean)
                        {
                          paramBundle = (Bundle)localObject;
                          if (!RedPacketManager.verifyKuaKuaHbParams(paramPanelData)) {}
                        }
                        else
                        {
                          paramBundle = new KuaKuaHbFragment();
                        }
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
    QLog.i("SendHbMainFragment", 2, "buildHbFragment...fragment is null,panelData:" + paramPanelData.toString());
    return paramBundle;
  }
  
  private String a(PanelData paramPanelData)
  {
    String str2 = "";
    String str1 = str2;
    int i;
    if (paramPanelData != null)
    {
      str1 = str2;
      if (!TextUtils.isEmpty(paramPanelData.b))
      {
        i = paramPanelData.b.indexOf(jdField_a_of_type_JavaLangString);
        if (i == -1) {
          break label65;
        }
      }
    }
    label65:
    for (str1 = paramPanelData.b.substring(0, i);; str1 = paramPanelData.b)
    {
      paramPanelData = str1;
      if (TextUtils.isEmpty(str1)) {
        paramPanelData = jdField_a_of_type_JavaLangString;
      }
      return paramPanelData;
    }
  }
  
  private void a(View paramView)
  {
    paramView = (TipsBar)paramView.findViewById(2131368261);
    paramView.setVisibility(8);
    Object localObject1;
    String str1;
    try
    {
      localObject1 = QWalletTools.a();
      if (localObject1 == null) {
        return;
      }
      localObject1 = (QWalletConfigManager)((QQAppInterface)localObject1).getManager(QQManagerFactory.QWALLET_CONFIG_MANAGER);
      if ((localObject1 == null) || (((QWalletConfigManager)localObject1).a("common") == null)) {
        return;
      }
      localObject1 = ((QWalletConfigManager)localObject1).a("common").getJSONObject("make_hb_bulletin");
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
      paramView.setTipsIcon(getResources().getDrawable(2130839417));
      if (paramView.b() != null) {
        paramView.b().setVisibility(0);
      }
      paramView.setVisibility(0);
      paramView.setTipsText(str1);
      paramView.setEnabled(true);
      paramView.setOnClickListener(new SendHbMainFragment.1(this, (JSONObject)localObject1));
      paramView.setCloseListener(new SendHbMainFragment.2(this, paramView, (SharedPreferences)localObject2, i));
    }
  }
  
  private void a(View paramView, Bundle paramBundle)
  {
    HbInfo.a(paramBundle, this.jdField_a_of_type_CooperationQwalletPluginshareHbInfo$BundleInfo);
    this.b = this.jdField_a_of_type_CooperationQwalletPluginshareHbInfo$BundleInfo.recv_type;
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369674));
    b(paramView);
    a(paramView, paramBundle.getString("hbTitle", getString(2131696747)));
    if (!a(paramBundle))
    {
      QLog.i("SendHbMainFragment", 1, "initHbData failed...");
      QQToast.a(this.mActivity, HardCodeUtil.a(2131713770), 0).a();
      this.mActivity.finish();
      return;
    }
    paramBundle = (ViewPager)paramView.findViewById(2131381113);
    paramBundle.setOffscreenPageLimit(1);
    paramBundle.setAdapter(new SendHbMainFragment.3(this, getChildFragmentManager()));
    paramBundle.setCurrentItem(a(b()), false);
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketWidgetViewPagerTabLayout = ((ViewPagerTabLayout)paramView.findViewById(2131378847));
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketWidgetViewPagerTabLayout.setBoldStyle(1);
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketWidgetViewPagerTabLayout.setScrollOnTabClick(false);
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketWidgetViewPagerTabLayout.setViewPager(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketWidgetViewPagerTabLayout.post(new SendHbMainFragment.4(this));
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
        localObject1 = new SendHbMainFragment.HbHolder(1, HardCodeUtil.a(2131713771), (BaseHbFragment)localObject2);
        this.jdField_a_of_type_JavaUtilList.add(localObject1);
      }
      if ((i & 0x1) == 1)
      {
        paramBundle = new Bundle(paramBundle);
        paramBundle.putString("bus_type", "1");
        localObject1 = new UsualHbFragment();
        ((UsualHbFragment)localObject1).setArguments(paramBundle);
        paramBundle = new SendHbMainFragment.HbHolder(0, HardCodeUtil.a(2131713772), (BaseHbFragment)localObject1);
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
        localObject2 = (PanelData)((Iterator)localObject1).next();
        if (localObject2 != null) {
          try
          {
            if (!TextUtils.isEmpty(((PanelData)localObject2).b))
            {
              BaseHbFragment localBaseHbFragment = a((PanelData)localObject2, paramBundle, bool1);
              if (localBaseHbFragment != null) {
                this.jdField_a_of_type_JavaUtilList.add(new SendHbMainFragment.HbHolder(((PanelData)localObject2).jdField_a_of_type_Int, a((PanelData)localObject2), localBaseHbFragment));
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
    return HbBusiUtils.a(this.channel, QwUtils.a(this.bundle.getString("bus_type"), 2));
  }
  
  private void b(View paramView)
  {
    try
    {
      int i = ImmersiveUtils.isSupporImmersive();
      int j = ImmersiveUtils.getStatusBarHeight(this.mActivity);
      if (i == 1)
      {
        paramView = paramView.findViewById(2131381120);
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
      int i = ((SendHbMainFragment.HbHolder)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketWidgetViewPagerTabLayout.a())).jdField_a_of_type_Int;
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
    SendHbMainFragment.HbHolder localHbHolder;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localHbHolder = (SendHbMainFragment.HbHolder)localIterator.next();
    } while (localHbHolder.jdField_a_of_type_Int != paramInt);
    for (int i = this.jdField_a_of_type_JavaUtilList.indexOf(localHbHolder);; i = 0)
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
      BaseHbFragment localBaseHbFragment = ((SendHbMainFragment.HbHolder)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketWidgetViewPagerTabLayout.a())).jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentBaseHbFragment;
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
      this.mActivity.addHbUploadData("idiom.wrappacket.back");
      continue;
      this.mActivity.addHbUploadData("ksong.wrappacket.back");
      continue;
      this.mActivity.addHbUploadData("draw.wrappacket.back");
      continue;
      this.mActivity.addHbUploadData("phiz.wrappacket.back");
      continue;
      this.mActivity.addHbUploadData("only.wrappacket.back");
    }
  }
  
  public void a(View paramView, String paramString)
  {
    paramView.findViewById(2131369518).setVisibility(4);
    ((TextView)paramView.findViewById(2131369534)).setText(paramString);
    paramView.findViewById(2131369487).setOnClickListener(this);
    paramView.findViewById(2131377159).setBackgroundColor(this.mActivity.getResources().getColor(2131166233));
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
    if (paramView.getId() == 2131369487)
    {
      a();
      this.mActivity.cancelCallBack();
      this.mActivity.finish();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    paramLayoutInflater = paramLayoutInflater.inflate(2131562081, null);
    a(paramLayoutInflater, getArguments());
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.fragment.SendHbMainFragment
 * JD-Core Version:    0.7.0.1
 */