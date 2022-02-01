package com.tencent.mobileqq.activity.qwallet.redpacket.draw;

import akqa;
import akrk;
import akuu;
import akuv;
import akuw;
import akux;
import akuy;
import akww;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
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
import com.tencent.mobileqq.activity.qwallet.fragment.BaseHbFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class DrawHbFragment
  extends BaseHbFragment
  implements View.OnClickListener
{
  private long jdField_a_of_type_Long;
  protected TextWatcher a;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  public ChooseItemView a;
  DrawHbFragment.DrawHbBundleInfo jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawDrawHbFragment$DrawHbBundleInfo = new DrawHbFragment.DrawHbBundleInfo();
  private String jdField_a_of_type_JavaLangString;
  private EditText b;
  
  public DrawHbFragment()
  {
    this.jdField_a_of_type_AndroidTextTextWatcher = new akuy(this);
  }
  
  private int a()
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawDrawHbFragment$DrawHbBundleInfo.recommend)) {
      return 0;
    }
    try
    {
      int i = new JSONArray(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawDrawHbFragment$DrawHbBundleInfo.recommend).length();
      return i;
    }
    catch (Throwable localThrowable) {}
    return 0;
  }
  
  private String a(String paramString)
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawDrawHbFragment$DrawHbBundleInfo.modelList)) {
      try
      {
        JSONArray localJSONArray1 = new JSONArray(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawDrawHbFragment$DrawHbBundleInfo.modelList);
        int i = 0;
        while (i < localJSONArray1.length())
        {
          JSONObject localJSONObject = localJSONArray1.optJSONObject(i);
          if (localJSONObject != null)
          {
            JSONArray localJSONArray2 = localJSONObject.optJSONArray("subjects");
            if (localJSONArray2 != null)
            {
              int j = 0;
              while (j < localJSONArray2.length())
              {
                String str = localJSONArray2.optString(j);
                if ((!TextUtils.isEmpty(str)) && (str.trim().equals(paramString)))
                {
                  str = localJSONObject.optString("id");
                  boolean bool = TextUtils.isEmpty(str);
                  if (!bool) {
                    return str;
                  }
                }
                j += 1;
              }
            }
          }
          i += 1;
        }
        return null;
      }
      catch (Throwable paramString)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  public static List<String> a(String paramString1, String paramString2, String paramString3)
  {
    LinkedHashSet localLinkedHashSet = new LinkedHashSet();
    a(localLinkedHashSet, paramString1);
    if (!TextUtils.isEmpty(paramString3)) {
      try
      {
        paramString1 = new JSONArray(paramString3);
        int i = 0;
        while (i < paramString1.length())
        {
          paramString3 = paramString1.optJSONObject(i);
          if (paramString3 != null) {
            a(localLinkedHashSet, paramString3.optString("subjects"));
          }
          i += 1;
        }
        a(localLinkedHashSet, paramString2);
      }
      catch (Throwable paramString1)
      {
        paramString1.printStackTrace();
      }
    }
    return new LinkedList(localLinkedHashSet);
  }
  
  private void a()
  {
    String str1 = this.jdField_a_of_type_AndroidWidgetTextView.getText().toString().trim();
    this.jdField_a_of_type_JavaLangString = str1;
    if (TextUtils.isEmpty(str1))
    {
      a(false);
      return;
    }
    str1 = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
    String str2 = this.b.getText().toString();
    if ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2)))
    {
      a(false);
      return;
    }
    if ((blqo.a(str1) <= 0.0F) || (blqo.a(str2) <= 0.0F))
    {
      a(false);
      return;
    }
    a(true);
    str1 = getString(2131696069) + str2 + anni.a(2131702321);
    this.jdField_a_of_type_AndroidWidgetButton.setText(str1);
  }
  
  private void a(View paramView, Bundle paramBundle)
  {
    blqv.a(paramBundle, this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawDrawHbFragment$DrawHbBundleInfo);
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)paramView.findViewById(2131371879));
    this.b = ((EditText)paramView.findViewById(2131362652));
    this.b.addTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
    this.b.addTextChangedListener(new akrk(this.b));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131363812));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379960));
    try
    {
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawDrawHbFragment$DrawHbBundleInfo.drawParam))
      {
        paramBundle = getHbPannelConfig(10);
        if (paramBundle != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawDrawHbFragment$DrawHbBundleInfo.skinId = paramBundle.optString("skinId");
          this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawDrawHbFragment$DrawHbBundleInfo.drawParam = paramBundle.optString("subjects");
          this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawDrawHbFragment$DrawHbBundleInfo.recommend = paramBundle.optString("recommend");
          this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawDrawHbFragment$DrawHbBundleInfo.modelList = paramBundle.optString("modelList");
        }
      }
      paramBundle = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawDrawHbFragment$DrawHbBundleInfo.biz_params;
      if (QLog.isColorLevel()) {
        QLog.i("DrawHbFragment", 2, "bizParams:" + paramBundle);
      }
      if (!bgsp.a(paramBundle))
      {
        paramBundle = new JSONObject(paramBundle).optString("subject", "");
        if ((!TextUtils.isEmpty(paramBundle)) && (b(paramBundle))) {
          this.jdField_a_of_type_AndroidWidgetTextView.setText(paramBundle);
        }
      }
    }
    catch (Throwable paramBundle)
    {
      for (;;)
      {
        paramBundle.printStackTrace();
        continue;
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawDrawHbFragment$DrawHbBundleInfo.people_num)) {
          this.jdField_a_of_type_AndroidWidgetEditText.setHint(anni.a(2131702322) + this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawDrawHbFragment$DrawHbBundleInfo.people_num + anni.a(2131702323));
        }
        this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
      }
    }
    if (blqv.b.contains(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawDrawHbFragment$DrawHbBundleInfo.recv_type))
    {
      this.jdField_a_of_type_AndroidWidgetEditText.setText("1");
      paramView.findViewById(2131379093).setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetTextView.addTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new akuv(this));
      akww.a(this.jdField_a_of_type_AndroidWidgetTextView, 0.6F);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131369604));
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawChooseItemView = new ChooseItemView(getActivity());
      paramBundle = a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawDrawHbFragment$DrawHbBundleInfo.recommend, this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawDrawHbFragment$DrawHbBundleInfo.drawParam, this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawDrawHbFragment$DrawHbBundleInfo.modelList);
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawChooseItemView.a(paramBundle, false, new akuw(this), null, new akux(this, paramView));
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawChooseItemView.setRecommendCnt(a());
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawChooseItemView.setStyle(1);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawChooseItemView);
      paramView = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawChooseItemView.getLayoutParams();
      paramView.width = -1;
      paramView.height = bggq.a(getActivity(), 280.0F);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawChooseItemView != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawChooseItemView.a();
      }
      return;
    }
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
  
  private void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(paramBoolean);
    if (!paramBoolean) {
      this.jdField_a_of_type_AndroidWidgetButton.setText(getString(2131696069));
    }
  }
  
  private boolean a(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawDrawHbFragment$DrawHbBundleInfo.drawParam)) {}
    try
    {
      JSONArray localJSONArray = new JSONArray(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawDrawHbFragment$DrawHbBundleInfo.drawParam);
      bool1 = bool2;
      int i;
      if (localJSONArray != null) {
        i = 0;
      }
      for (;;)
      {
        bool1 = bool2;
        if (i < localJSONArray.length())
        {
          String str = localJSONArray.optString(i);
          if (!TextUtils.isEmpty(str))
          {
            bool1 = str.trim().equals(paramString);
            if (bool1) {
              bool1 = true;
            }
          }
        }
        else
        {
          return bool1;
        }
        i += 1;
      }
      return false;
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private void b()
  {
    long l = System.currentTimeMillis();
    if (this.jdField_a_of_type_Long + 1000L > l) {
      return;
    }
    this.jdField_a_of_type_Long = l;
    String str1 = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
    String str2 = this.b.getText().toString();
    Map localMap = this.mActivity.a();
    localMap.put("type", "1");
    localMap.put("wishing", this.jdField_a_of_type_JavaLangString);
    localMap.put("bus_type", "2");
    localMap.put("total_num", str1);
    localMap.put("total_amount", blqo.a(str2));
    localMap.put("channel", "" + this.channel);
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawDrawHbFragment$DrawHbBundleInfo.skinId)) {
      localMap.put("skin_id", this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawDrawHbFragment$DrawHbBundleInfo.skinId);
    }
    if (!a(this.jdField_a_of_type_JavaLangString))
    {
      localMap.put("feedsid", a(this.jdField_a_of_type_JavaLangString));
      localMap.put("subchannel", "1");
    }
    this.mLogic.a(localMap);
  }
  
  private boolean b(String paramString)
  {
    return (a(paramString)) || (!TextUtils.isEmpty(a(paramString)));
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
      this.mActivity.c("draw.wrappacket.wrap");
      b();
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    paramLayoutInflater = paramLayoutInflater.inflate(2131561999, null);
    paramLayoutInflater.setOnClickListener(new akuu(this));
    a(paramLayoutInflater, getArguments());
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    super.setUserVisibleHint(paramBoolean);
    if (paramBoolean)
    {
      QLog.i("DrawHbFragment", 2, "DrawHb enter...");
      if (this.mActivity != null) {
        this.mActivity.c("draw.wrappacket.show");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.redpacket.draw.DrawHbFragment
 * JD-Core Version:    0.7.0.1
 */