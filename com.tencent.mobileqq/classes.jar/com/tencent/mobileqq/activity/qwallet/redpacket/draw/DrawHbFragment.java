package com.tencent.mobileqq.activity.qwallet.redpacket.draw;

import aitw;
import aiyj;
import aiyk;
import aiyl;
import aiym;
import aiyn;
import aiyo;
import ajaf;
import alpo;
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
import bdje;
import bixy;
import biyf;
import com.tencent.mobileqq.activity.qwallet.SendHbActivity;
import com.tencent.mobileqq.activity.qwallet.fragment.BaseHbFragment;
import com.tencent.qphone.base.util.QLog;
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
    this.jdField_a_of_type_AndroidTextTextWatcher = new aiyo(this);
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
    if ((bixy.a(str1) <= 0.0F) || (bixy.a(str2) <= 0.0F))
    {
      a(false);
      return;
    }
    a(true);
    str1 = getString(2131697238) + str2 + alpo.a(2131703912);
    this.jdField_a_of_type_AndroidWidgetButton.setText(str1);
  }
  
  private void a(View paramView, Bundle paramBundle)
  {
    biyf.a(paramBundle, this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawDrawHbFragment$DrawHbBundleInfo);
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)paramView.findViewById(2131371293));
    this.b = ((EditText)paramView.findViewById(2131362556));
    this.b.addTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131363610));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378987));
    try
    {
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawDrawHbFragment$DrawHbBundleInfo.drawParam))
      {
        paramBundle = getHbPannelConfig(10);
        if (paramBundle != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawDrawHbFragment$DrawHbBundleInfo.skinId = paramBundle.optString("skinId");
          this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawDrawHbFragment$DrawHbBundleInfo.drawParam = paramBundle.optString("subjects");
        }
      }
      paramBundle = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawDrawHbFragment$DrawHbBundleInfo.biz_params;
      if (QLog.isColorLevel()) {
        QLog.i("DrawHbFragment", 2, "bizParams:" + paramBundle);
      }
      if (!bdje.a(paramBundle))
      {
        paramBundle = new JSONObject(paramBundle).optString("subject", "");
        if ((!TextUtils.isEmpty(paramBundle)) && (a(paramBundle))) {
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
          this.jdField_a_of_type_AndroidWidgetEditText.setHint(alpo.a(2131703913) + this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawDrawHbFragment$DrawHbBundleInfo.people_num + alpo.a(2131703914));
        }
        this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
      }
    }
    if (biyf.b.contains(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawDrawHbFragment$DrawHbBundleInfo.recv_type))
    {
      this.jdField_a_of_type_AndroidWidgetEditText.setText("1");
      paramView.findViewById(2131378186).setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetTextView.addTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new aiyk(this));
      ajaf.a(this.jdField_a_of_type_AndroidWidgetTextView, 0.6F);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131369195));
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawChooseItemView = new ChooseItemView(getActivity());
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawChooseItemView.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawDrawHbFragment$DrawHbBundleInfo.drawParam, new aiyl(this), new aiym(this), new aiyn(this, paramView));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawChooseItemView);
      paramView = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawChooseItemView.getLayoutParams();
      paramView.width = -1;
      paramView.height = -2;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawChooseItemView != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawChooseItemView.a();
      }
      return;
    }
  }
  
  private void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(paramBoolean);
    if (!paramBoolean) {
      this.jdField_a_of_type_AndroidWidgetButton.setText(getString(2131697238));
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
            bool1 = str.equals(paramString);
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
    localMap.put("total_amount", bixy.a(str2));
    localMap.put("channel", "" + this.channel);
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawDrawHbFragment$DrawHbBundleInfo.skinId)) {
      localMap.put("skin_id", this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawDrawHbFragment$DrawHbBundleInfo.skinId);
    }
    this.mLogic.a(localMap);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    this.mActivity.c("draw.wrappacket.wrap");
    b();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    paramLayoutInflater = paramLayoutInflater.inflate(2131561742, null);
    paramLayoutInflater.setOnClickListener(new aiyj(this));
    a(paramLayoutInflater, getArguments());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.redpacket.draw.DrawHbFragment
 * JD-Core Version:    0.7.0.1
 */