package com.tencent.mobileqq.activity.qwallet.fragment;

import akpm;
import akpn;
import akpo;
import akpp;
import akqa;
import akww;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anni;
import bggq;
import bgsp;
import blqo;
import blqv;
import com.tencent.mobileqq.activity.qwallet.SendHbActivity;
import com.tencent.mobileqq.activity.qwallet.redpacket.draw.ChooseItemView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class KuaKuaHbFragment
  extends BaseHbUIFragment
  implements View.OnClickListener
{
  int jdField_a_of_type_Int = -1;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  protected KuaKuaHbFragment.KuaKuaHbBundleInfo a;
  private ChooseItemView jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawChooseItemView;
  
  public KuaKuaHbFragment()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentKuaKuaHbFragment$KuaKuaHbBundleInfo = new KuaKuaHbFragment.KuaKuaHbBundleInfo();
  }
  
  public static List<String> a(String paramString1, String paramString2, String paramString3)
  {
    LinkedHashSet localLinkedHashSet = new LinkedHashSet();
    a(localLinkedHashSet, paramString1);
    a(localLinkedHashSet, paramString2, paramString3);
    return new LinkedList(localLinkedHashSet);
  }
  
  private static void a(LinkedHashSet<String> paramLinkedHashSet, String paramString)
  {
    if ((paramLinkedHashSet == null) || (TextUtils.isEmpty(paramString))) {}
    for (;;)
    {
      return;
      try
      {
        paramString = new JSONArray(paramString);
        int i = 0;
        while (i < paramString.length())
        {
          String str = paramString.optString(i);
          if (!TextUtils.isEmpty(str)) {
            paramLinkedHashSet.add(str);
          }
          i += 1;
        }
        return;
      }
      catch (Throwable paramLinkedHashSet)
      {
        paramLinkedHashSet.printStackTrace();
      }
    }
  }
  
  private static void a(LinkedHashSet<String> paramLinkedHashSet, String paramString1, String paramString2)
  {
    if ((paramLinkedHashSet == null) || ((TextUtils.isEmpty(paramString1)) && (TextUtils.isEmpty(paramString2)))) {}
    for (;;)
    {
      return;
      try
      {
        paramString1 = new JSONArray(paramString1);
        paramString2 = new JSONArray(paramString2);
        int j = Math.max(paramString1.length(), paramString2.length());
        int i = 0;
        while (i < j)
        {
          String str;
          if (i < paramString2.length())
          {
            str = paramString2.optString(i);
            if (!TextUtils.isEmpty(str)) {
              paramLinkedHashSet.add(str);
            }
          }
          if (i < paramString1.length())
          {
            str = paramString1.optString(i);
            if (!TextUtils.isEmpty(str)) {
              paramLinkedHashSet.add(str);
            }
          }
          i += 1;
        }
        return;
      }
      catch (Throwable paramLinkedHashSet)
      {
        paramLinkedHashSet.printStackTrace();
      }
    }
  }
  
  private boolean a(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {}
    for (;;)
    {
      return false;
      try
      {
        paramString2 = new JSONArray(paramString2);
        if (paramString2 == null) {
          continue;
        }
        int i = 0;
        while (i < paramString2.length())
        {
          String str = paramString2.optString(i);
          if (!TextUtils.isEmpty(str))
          {
            boolean bool = str.trim().equals(paramString1);
            if (bool) {
              return true;
            }
          }
          i += 1;
        }
        return false;
      }
      catch (Throwable paramString1)
      {
        paramString1.printStackTrace();
      }
    }
  }
  
  private int b()
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentKuaKuaHbFragment$KuaKuaHbBundleInfo.recommend)) {
      return 0;
    }
    try
    {
      int i = new JSONArray(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentKuaKuaHbFragment$KuaKuaHbBundleInfo.recommend).length();
      return i;
    }
    catch (Throwable localThrowable) {}
    return 0;
  }
  
  private void d()
  {
    if (!b()) {}
    int i;
    String str;
    Object localObject;
    do
    {
      return;
      i = blqo.a(this.jdField_a_of_type_AndroidWidgetEditText.getText().toString(), 1);
      str = blqo.a(String.valueOf(blqo.a(this.b.getText().toString())));
      if (TextUtils.isEmpty(str))
      {
        QQToast.a(getActivity(), 2131692852, 0).a();
        return;
      }
      localObject = this.jdField_a_of_type_AndroidWidgetTextView.getText().toString().trim();
    } while (TextUtils.isEmpty((CharSequence)localObject));
    combineUploadData(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentKuaKuaHbFragment$KuaKuaHbBundleInfo, this.channel, i, str, "hongbao.wrap.go");
    Map localMap = this.mActivity.a();
    localMap.put("channel", String.valueOf(this.channel));
    localMap.put("type", "1");
    localMap.put("wishing", localObject);
    localMap.put("bus_type", "2");
    localMap.put("total_num", i + "");
    localMap.put("total_amount", str);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentKuaKuaHbFragment$KuaKuaHbBundleInfo.skinId > 0) {
      localMap.put("skin_id", this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentKuaKuaHbFragment$KuaKuaHbBundleInfo.skinId + "");
    }
    for (;;)
    {
      try
      {
        str = this.jdField_a_of_type_AndroidWidgetTextView.getText().toString();
        localObject = new JSONObject();
        if (this.jdField_a_of_type_Int == -1)
        {
          if (!a(str, this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentKuaKuaHbFragment$KuaKuaHbBundleInfo.upSubjects)) {
            continue;
          }
          this.jdField_a_of_type_Int = 1;
        }
        ((JSONObject)localObject).put("kua_show", this.jdField_a_of_type_Int);
        localMap.put("client_extend", ((JSONObject)localObject).toString());
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        continue;
      }
      this.mLogic.a(localMap);
      return;
      this.jdField_a_of_type_Int = 0;
    }
  }
  
  public int a()
  {
    return 2131561958;
  }
  
  protected String a()
  {
    return anni.a(2131710049);
  }
  
  public void a()
  {
    c();
    Object localObject = a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentKuaKuaHbFragment$KuaKuaHbBundleInfo.recommend, this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentKuaKuaHbFragment$KuaKuaHbBundleInfo.upSubjects, this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentKuaKuaHbFragment$KuaKuaHbBundleInfo.downSubjects);
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawChooseItemView.a((List)localObject, false, new akpo(this), null, new akpp(this));
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawChooseItemView.setRecommendCnt(b());
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawChooseItemView.setStyle(1);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawChooseItemView);
    localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawChooseItemView.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).width = -1;
    ((RelativeLayout.LayoutParams)localObject).height = bggq.a(getActivity(), 280.0F);
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379960));
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawChooseItemView = new ChooseItemView(this.mActivity);
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawChooseItemView.setMaxLines(8);
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawChooseItemView.setStyle(1);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131369604));
    blqv.a(paramBundle, this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentKuaKuaHbFragment$KuaKuaHbBundleInfo);
    if (QLog.isColorLevel()) {
      QLog.i("KuaKuaHbFragment", 2, "bizParams:" + this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentKuaKuaHbFragment$KuaKuaHbBundleInfo.biz_params);
    }
    if (blqv.b.contains(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentKuaKuaHbFragment$KuaKuaHbBundleInfo.recv_type))
    {
      this.jdField_a_of_type_AndroidWidgetEditText.setText("1");
      this.jdField_a_of_type_AndroidViewView.findViewById(2131379093).setVisibility(8);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetTextView.addTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new akpm(this));
      akww.a(this.jdField_a_of_type_AndroidWidgetTextView, 0.6F);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawChooseItemView != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawChooseItemView.a();
      }
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(new akpn(this));
      return;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentKuaKuaHbFragment$KuaKuaHbBundleInfo.people_num)) {
        this.jdField_a_of_type_AndroidWidgetEditText.setHint(anni.a(2131704507) + this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentKuaKuaHbFragment$KuaKuaHbBundleInfo.people_num + anni.a(2131704511));
      }
      this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
    }
  }
  
  public boolean a()
  {
    if ((super.a()) && (TextUtils.isEmpty(this.jdField_a_of_type_AndroidWidgetTextView.getText().toString().trim()))) {
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
    }
    return this.jdField_a_of_type_AndroidWidgetButton.isEnabled();
  }
  
  public void c()
  {
    try
    {
      Object localObject = getHbPannelConfig(15);
      if (localObject != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentKuaKuaHbFragment$KuaKuaHbBundleInfo.recommend = ((JSONObject)localObject).optString("recommend");
        this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentKuaKuaHbFragment$KuaKuaHbBundleInfo.upSubjects = ((JSONObject)localObject).optString("upSubjects");
        this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentKuaKuaHbFragment$KuaKuaHbBundleInfo.downSubjects = ((JSONObject)localObject).optString("downSubjects");
        this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentKuaKuaHbFragment$KuaKuaHbBundleInfo.upHint = ((JSONObject)localObject).optString("upHint");
        this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentKuaKuaHbFragment$KuaKuaHbBundleInfo.downHint = ((JSONObject)localObject).optString("downHint");
        this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentKuaKuaHbFragment$KuaKuaHbBundleInfo.skinId = ((JSONObject)localObject).optInt("skinId");
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentKuaKuaHbFragment$KuaKuaHbBundleInfo.biz_params;
      if (QLog.isColorLevel()) {
        QLog.i("KuaKuaHbFragment", 2, "bizParams:" + (String)localObject);
      }
      if (!bgsp.a((String)localObject))
      {
        localObject = new JSONObject((String)localObject);
        if (localObject != null)
        {
          String str = ((JSONObject)localObject).optString("subject");
          if ((!TextUtils.isEmpty(str)) && ((a(str, this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentKuaKuaHbFragment$KuaKuaHbBundleInfo.downSubjects)) || (a(str, this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentKuaKuaHbFragment$KuaKuaHbBundleInfo.upSubjects)))) {
            this.jdField_a_of_type_AndroidWidgetTextView.setText(str);
          }
          this.jdField_a_of_type_Int = ((JSONObject)localObject).optInt("kua_show");
          if (this.jdField_a_of_type_Int < 0) {
            this.jdField_a_of_type_Int = 0;
          }
        }
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
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
      d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.fragment.KuaKuaHbFragment
 * JD-Core Version:    0.7.0.1
 */