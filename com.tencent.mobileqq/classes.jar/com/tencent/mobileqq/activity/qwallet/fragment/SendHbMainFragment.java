package com.tencent.mobileqq.activity.qwallet.fragment;

import aitd;
import aity;
import aitz;
import aiua;
import aiub;
import aiuo;
import aixd;
import ajaf;
import alpo;
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
import bixy;
import biyf;
import biyg;
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
  private biyg jdField_a_of_type_Biyg = new biyg();
  private ViewPagerTabLayout jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketWidgetViewPagerTabLayout;
  private List<aiub> jdField_a_of_type_JavaUtilList = new ArrayList();
  private String b;
  
  static
  {
    jdField_a_of_type_JavaLangString = alpo.a(2131714205);
  }
  
  private BaseHbFragment a(aixd paramaixd, Bundle paramBundle, boolean paramBoolean)
  {
    Object localObject = null;
    JSONArray localJSONArray = null;
    Bundle localBundle = new Bundle(paramBundle);
    int i = paramaixd.jdField_a_of_type_Int;
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
          if (!biyf.d.contains(this.b)) {}
        }
        else
        {
          paramBundle = new UsualHbFragment();
          localBundle.putString("bus_type", "2");
          continue;
          if (!paramBoolean)
          {
            paramBundle = (Bundle)localObject;
            if (biyf.f.contains(this.b)) {}
          }
          else
          {
            paramBundle = new LingHbFragment();
            continue;
            localObject = new KSongFragment();
            paramBundle = (Bundle)localObject;
            if (paramaixd.jdField_a_of_type_OrgJsonJSONObject != null)
            {
              localBundle.putString("pick_entry", paramaixd.jdField_a_of_type_OrgJsonJSONObject.optString("pick_entry", "http://h5.qianbao.qq.com/ktvredpacket"));
              paramBundle = (Bundle)localObject;
              continue;
              if (!paramBoolean)
              {
                paramBundle = (Bundle)localObject;
                if (!RedPacketManager.verifyEmojiHbParams(paramaixd)) {}
              }
              else
              {
                localObject = new EmojiFragment();
                localBundle.putString("prefix", paramaixd.jdField_a_of_type_OrgJsonJSONObject.optString("prefix"));
                localJSONArray = paramaixd.jdField_a_of_type_OrgJsonJSONObject.optJSONArray("heartList");
                paramBundle = (Bundle)localObject;
                if (localJSONArray != null)
                {
                  localBundle.putString("heartList", localJSONArray.toString());
                  paramBundle = (Bundle)localObject;
                  continue;
                  localObject = new WordChainHbFragment();
                  paramBundle = (Bundle)localObject;
                  if (paramaixd.jdField_a_of_type_OrgJsonJSONObject != null)
                  {
                    localBundle.putString("skinId", paramaixd.jdField_a_of_type_OrgJsonJSONObject.optString("skinId"));
                    paramBundle = (Bundle)localObject;
                    continue;
                    if (!paramBoolean)
                    {
                      paramBundle = (Bundle)localObject;
                      if (!RedPacketManager.verifyDrawHbParams(paramaixd)) {}
                    }
                    else
                    {
                      paramBundle = new DrawHbFragment();
                      localBundle.putString("skinId", paramaixd.jdField_a_of_type_OrgJsonJSONObject.optString("skinId"));
                      localBundle.putString("drawParam", paramaixd.jdField_a_of_type_OrgJsonJSONObject.optString("subjects"));
                      continue;
                      if (!paramBoolean)
                      {
                        paramBundle = (Bundle)localObject;
                        if (!biyf.e.contains(this.b)) {}
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
    QLog.i("SendHbMainFragment", 2, "buildHbFragment...fragment is null,panelData:" + paramaixd.toString());
    return paramBundle;
  }
  
  private String a(aixd paramaixd)
  {
    String str2 = "";
    String str1 = str2;
    int i;
    if (paramaixd != null)
    {
      str1 = str2;
      if (!TextUtils.isEmpty(paramaixd.b))
      {
        i = paramaixd.b.indexOf(jdField_a_of_type_JavaLangString);
        if (i == -1) {
          break label65;
        }
      }
    }
    label65:
    for (str1 = paramaixd.b.substring(0, i);; str1 = paramaixd.b)
    {
      paramaixd = str1;
      if (TextUtils.isEmpty(str1)) {
        paramaixd = jdField_a_of_type_JavaLangString;
      }
      return paramaixd;
    }
  }
  
  private void a(View paramView)
  {
    paramView = (TipsBar)paramView.findViewById(2131367486);
    paramView.setVisibility(8);
    Object localObject1;
    String str1;
    try
    {
      localObject1 = ajaf.a();
      if (localObject1 == null) {
        return;
      }
      localObject1 = (aitd)((QQAppInterface)localObject1).getManager(245);
      if ((localObject1 == null) || (((aitd)localObject1).a("common") == null)) {
        return;
      }
      localObject1 = ((aitd)localObject1).a("common").getJSONObject("make_hb_bulletin");
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
      paramView.setTipsIcon(getResources().getDrawable(2130839100));
      if (paramView.b() != null) {
        paramView.b().setVisibility(0);
      }
      paramView.setVisibility(0);
      paramView.setTipsText(str1);
      paramView.setEnabled(true);
      paramView.setOnClickListener(new aity(this, (JSONObject)localObject1));
      paramView.setCloseListener(new aitz(this, paramView, (SharedPreferences)localObject2, i));
    }
  }
  
  private void a(View paramView, Bundle paramBundle)
  {
    biyf.a(paramBundle, this.jdField_a_of_type_Biyg);
    this.b = this.jdField_a_of_type_Biyg.recv_type;
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368780));
    b(paramView);
    a(paramView, paramBundle.getString("hbTitle", getString(2131697226)));
    if (!a(paramBundle))
    {
      QLog.i("SendHbMainFragment", 1, "initHbData failed...");
      QQToast.a(this.mActivity, alpo.a(2131714202), 0).a();
      this.mActivity.finish();
      return;
    }
    paramBundle = (ViewPager)paramView.findViewById(2131379432);
    paramBundle.setOffscreenPageLimit(1);
    paramBundle.setAdapter(new aiua(this, getChildFragmentManager()));
    paramBundle.setCurrentItem(a(b()), false);
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketWidgetViewPagerTabLayout = ((ViewPagerTabLayout)paramView.findViewById(2131377327));
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
        localObject1 = new aiub(1, alpo.a(2131714203), (BaseHbFragment)localObject2);
        this.jdField_a_of_type_JavaUtilList.add(localObject1);
      }
      if ((i & 0x1) == 1)
      {
        paramBundle = new Bundle(paramBundle);
        paramBundle.putString("bus_type", "1");
        localObject1 = new UsualHbFragment();
        ((UsualHbFragment)localObject1).setArguments(paramBundle);
        paramBundle = new aiub(0, alpo.a(2131714204), (BaseHbFragment)localObject1);
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
        localObject2 = (aixd)((Iterator)localObject1).next();
        if (localObject2 != null) {
          try
          {
            if (!TextUtils.isEmpty(((aixd)localObject2).b))
            {
              BaseHbFragment localBaseHbFragment = a((aixd)localObject2, paramBundle, bool1);
              if (localBaseHbFragment != null) {
                this.jdField_a_of_type_JavaUtilList.add(new aiub(((aixd)localObject2).jdField_a_of_type_Int, a((aixd)localObject2), localBaseHbFragment));
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
    return aiuo.a(this.channel, bixy.a(this.bundle.getString("bus_type"), 2));
  }
  
  private void b(View paramView)
  {
    try
    {
      int i = ImmersiveUtils.isSupporImmersive();
      int j = ImmersiveUtils.getStatusBarHeight(this.mActivity);
      if (i == 1)
      {
        paramView = paramView.findViewById(2131379439);
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
      int i = ((aiub)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketWidgetViewPagerTabLayout.a())).jdField_a_of_type_Int;
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
    aiub localaiub;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localaiub = (aiub)localIterator.next();
    } while (localaiub.jdField_a_of_type_Int != paramInt);
    for (int i = this.jdField_a_of_type_JavaUtilList.indexOf(localaiub);; i = 0)
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
      BaseHbFragment localBaseHbFragment = ((aiub)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketWidgetViewPagerTabLayout.a())).jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentBaseHbFragment;
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
    paramView.findViewById(2131368644).setVisibility(4);
    ((TextView)paramView.findViewById(2131368659)).setText(paramString);
    paramView.findViewById(2131368613).setOnClickListener(this);
    paramView.findViewById(2131375812).setBackgroundColor(this.mActivity.getResources().getColor(2131166143));
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
    if (paramView.getId() == 2131368613)
    {
      a();
      this.mActivity.a();
      this.mActivity.finish();
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    paramLayoutInflater = paramLayoutInflater.inflate(2131561704, null);
    a(paramLayoutInflater, getArguments());
    return paramLayoutInflater;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.fragment.SendHbMainFragment
 * JD-Core Version:    0.7.0.1
 */