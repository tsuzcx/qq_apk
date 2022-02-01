package com.tencent.mobileqq.activity.qwallet.fragment;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.qwallet.SendHbActivity;
import com.tencent.mobileqq.activity.qwallet.redpacket.draw.ChooseItemView;
import com.tencent.mobileqq.activity.qwallet.utils.QWalletTools;
import com.tencent.mobileqq.activity.qwallet.utils.ReportUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qwallet.QwUtils;
import cooperation.qwallet.pluginshare.HbInfo;
import java.util.Collection;
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
  int jdField_a_of_type_Int;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  protected KuaKuaHbFragment.KuaKuaHbBundleInfo a;
  private ChooseItemView jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawChooseItemView;
  String jdField_a_of_type_JavaLangString;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private ChooseItemView jdField_b_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawChooseItemView;
  String jdField_b_of_type_JavaLangString;
  
  public KuaKuaHbFragment()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentKuaKuaHbFragment$KuaKuaHbBundleInfo = new KuaKuaHbFragment.KuaKuaHbBundleInfo();
  }
  
  private void a(LinkedHashSet<String> paramLinkedHashSet, JSONArray paramJSONArray)
  {
    if ((paramLinkedHashSet == null) || (paramJSONArray == null) || (paramJSONArray.length() < 0)) {}
    for (;;)
    {
      return;
      int i = 0;
      try
      {
        while (i < paramJSONArray.length())
        {
          String str = paramJSONArray.optString(i);
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
  
  private boolean a(String paramString1, String paramString2, JSONArray paramJSONArray)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (paramJSONArray == null) || (paramJSONArray.length() < 0)) {
      return false;
    }
    int i = 0;
    for (;;)
    {
      JSONObject localJSONObject;
      String str1;
      String str2;
      try
      {
        if (i < paramJSONArray.length())
        {
          localJSONObject = paramJSONArray.getJSONObject(i);
          if (localJSONObject == null) {
            break label230;
          }
          str1 = localJSONObject.optString("typeName");
          if ((TextUtils.isEmpty(str1)) || (!str1.trim().equals(paramString1))) {
            break label230;
          }
          localJSONArray = localJSONObject.optJSONArray("subjects");
          j = 0;
          if (j >= localJSONArray.length()) {
            break label159;
          }
          str2 = localJSONArray.getString(j);
          if (!paramString2.trim().equals(str2)) {
            break label150;
          }
          this.jdField_a_of_type_JavaLangString = str1;
          this.jdField_b_of_type_JavaLangString = localJSONObject.optString("typeId");
          return true;
        }
      }
      catch (Throwable paramString1)
      {
        paramString1.printStackTrace();
      }
      return false;
      label150:
      j += 1;
      continue;
      label159:
      JSONArray localJSONArray = localJSONObject.optJSONArray("recommend");
      int j = 0;
      while (j < localJSONArray.length())
      {
        str2 = localJSONArray.getString(j);
        if (paramString2.trim().equals(str2))
        {
          this.jdField_a_of_type_JavaLangString = str1;
          this.jdField_b_of_type_JavaLangString = localJSONObject.optString("typeId");
          return true;
        }
        j += 1;
      }
      label230:
      i += 1;
    }
  }
  
  private void d()
  {
    if (!b()) {}
    int i;
    Object localObject;
    String str;
    do
    {
      return;
      i = QwUtils.a(this.jdField_a_of_type_AndroidWidgetEditText.getText().toString(), 1);
      localObject = QwUtils.a(String.valueOf(QwUtils.a(this.jdField_b_of_type_AndroidWidgetEditText.getText().toString())));
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        QQToast.a(getActivity(), 2131693163, 0).a();
        return;
      }
      str = this.jdField_a_of_type_AndroidWidgetTextView.getText().toString().trim();
    } while (TextUtils.isEmpty(str));
    combineUploadData(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentKuaKuaHbFragment$KuaKuaHbBundleInfo, this.channel, i, (String)localObject, "hongbao.wrap.go");
    Map localMap = this.mActivity.getMapPacketExtra();
    localMap.put("channel", String.valueOf(this.channel));
    localMap.put("type", "1");
    localMap.put("wishing", str);
    localMap.put("bus_type", "2");
    localMap.put("total_num", i + "");
    localMap.put("total_amount", localObject);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentKuaKuaHbFragment$KuaKuaHbBundleInfo.skinId > 0) {
      localMap.put("skin_id", this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentKuaKuaHbFragment$KuaKuaHbBundleInfo.skinId + "");
    }
    try
    {
      this.jdField_a_of_type_AndroidWidgetTextView.getText().toString();
      localObject = new JSONObject();
      ((JSONObject)localObject).put("type_id", this.jdField_b_of_type_JavaLangString);
      localMap.put("client_extend", ((JSONObject)localObject).toString());
      this.mLogic.a(localMap);
      ReportUtils.a(this.mQApp, "redpack.paybtn.click", null, this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentKuaKuaHbFragment$KuaKuaHbBundleInfo.panel_name);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  public int a()
  {
    return 2131562079;
  }
  
  protected String a()
  {
    return HardCodeUtil.a(2131711252);
  }
  
  public LinkedList<String> a(JSONArray paramJSONArray)
  {
    localLinkedHashSet = new LinkedHashSet();
    int i = 0;
    try
    {
      while (i < paramJSONArray.length())
      {
        Object localObject = paramJSONArray.getJSONObject(i);
        if (localObject != null)
        {
          String str1 = ((JSONObject)localObject).optString("typeId");
          String str2 = ((JSONObject)localObject).optString("typeName");
          String str3 = ((JSONObject)localObject).optString("subjects");
          localObject = ((JSONObject)localObject).optString("recommend");
          if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)) && ((!TextUtils.isEmpty(str3)) || (!TextUtils.isEmpty((CharSequence)localObject)))) {
            localLinkedHashSet.add(str2);
          }
        }
        i += 1;
      }
      return new LinkedList(localLinkedHashSet);
    }
    catch (Throwable paramJSONArray)
    {
      paramJSONArray.printStackTrace();
    }
  }
  
  public List<String> a(JSONArray paramJSONArray, String paramString)
  {
    if ((paramJSONArray == null) || (paramJSONArray.length() < 0)) {}
    for (;;)
    {
      return null;
      if (TextUtils.isEmpty(paramString)) {
        continue;
      }
      int i = 0;
      try
      {
        while (i < paramJSONArray.length())
        {
          Object localObject = paramJSONArray.getJSONObject(i);
          String str = ((JSONObject)localObject).optString("typeName");
          if ((!TextUtils.isEmpty(str)) && (paramString.equals(str)))
          {
            this.jdField_b_of_type_JavaLangString = ((JSONObject)localObject).optString("typeId");
            paramJSONArray = ((JSONObject)localObject).optJSONArray("subjects");
            paramString = ((JSONObject)localObject).optJSONArray("recommend");
            localObject = new LinkedHashSet();
            a((LinkedHashSet)localObject, paramString);
            this.jdField_a_of_type_Int = ((LinkedHashSet)localObject).size();
            a((LinkedHashSet)localObject, paramJSONArray);
            paramJSONArray = new LinkedList((Collection)localObject);
            return paramJSONArray;
          }
          i += 1;
        }
        return null;
      }
      catch (Throwable paramJSONArray)
      {
        paramJSONArray.printStackTrace();
      }
    }
  }
  
  public void a()
  {
    c();
    Object localObject = a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentKuaKuaHbFragment$KuaKuaHbBundleInfo.subjectList);
    if (!c()) {
      this.jdField_a_of_type_JavaLangString = ((String)((List)localObject).get(0));
    }
    this.jdField_b_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawChooseItemView.a((List)localObject, false, new KuaKuaHbFragment.3(this), null, null);
    this.jdField_b_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawChooseItemView.setStyle(1);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_b_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawChooseItemView);
    localObject = (RelativeLayout.LayoutParams)this.jdField_b_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawChooseItemView.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).width = -1;
    ((RelativeLayout.LayoutParams)localObject).height = -2;
    this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangString);
    this.jdField_b_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawChooseItemView.a(this.jdField_a_of_type_JavaLangString, false);
    a(this.jdField_a_of_type_JavaLangString);
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131380654));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131380405));
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawChooseItemView = new ChooseItemView(this.mActivity);
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawChooseItemView.setMaxLines(8);
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawChooseItemView.setStyle(1);
    this.jdField_b_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawChooseItemView = new ChooseItemView(this.mActivity);
    this.jdField_b_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawChooseItemView.setMaxLines(8);
    this.jdField_b_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawChooseItemView.setStyle(1);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131370126));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131370127));
    HbInfo.a(paramBundle, this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentKuaKuaHbFragment$KuaKuaHbBundleInfo);
    if (QLog.isColorLevel()) {
      QLog.i("KuaKuaHbFragment", 2, "bizParams:" + this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentKuaKuaHbFragment$KuaKuaHbBundleInfo.biz_params);
    }
    if (HbInfo.b.contains(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentKuaKuaHbFragment$KuaKuaHbBundleInfo.recv_type))
    {
      this.jdField_a_of_type_AndroidWidgetEditText.setText("1");
      this.jdField_a_of_type_AndroidViewView.findViewById(2131379746).setVisibility(8);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetTextView.addTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new KuaKuaHbFragment.1(this));
      this.jdField_b_of_type_AndroidWidgetTextView.addTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
      QWalletTools.a(this.jdField_a_of_type_AndroidWidgetTextView, 0.6F);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawChooseItemView != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawChooseItemView.a();
      }
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(new KuaKuaHbFragment.2(this));
      return;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentKuaKuaHbFragment$KuaKuaHbBundleInfo.people_num)) {
        this.jdField_a_of_type_AndroidWidgetEditText.setHint(HardCodeUtil.a(2131705738) + this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentKuaKuaHbFragment$KuaKuaHbBundleInfo.people_num + HardCodeUtil.a(2131705742));
      }
      this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
    }
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeAllViews();
    paramString = a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentKuaKuaHbFragment$KuaKuaHbBundleInfo.subjectList, paramString);
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawChooseItemView.a(paramString, false, new KuaKuaHbFragment.4(this), null, new KuaKuaHbFragment.5(this));
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawChooseItemView.setRecommendCnt(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawChooseItemView.setStyle(1);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawChooseItemView);
    paramString = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawChooseItemView.getLayoutParams();
    paramString.width = -1;
    paramString.height = getChooseViewHeight();
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
      JSONObject localJSONObject = getHbPannelConfig(15);
      if (localJSONObject != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentKuaKuaHbFragment$KuaKuaHbBundleInfo.skinId = localJSONObject.optInt("skinId");
        this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentKuaKuaHbFragment$KuaKuaHbBundleInfo.subjectList = localJSONObject.optJSONArray("subjectList");
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public boolean c()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentKuaKuaHbFragment$KuaKuaHbBundleInfo == null) || (StringUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentKuaKuaHbFragment$KuaKuaHbBundleInfo.biz_params)) || (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentKuaKuaHbFragment$KuaKuaHbBundleInfo.subjectList == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentKuaKuaHbFragment$KuaKuaHbBundleInfo.subjectList.length() < 1)) {
      return false;
    }
    try
    {
      if (QLog.isColorLevel()) {
        QLog.i("KuaKuaHbFragment", 2, "bizParams:" + this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentKuaKuaHbFragment$KuaKuaHbBundleInfo.biz_params);
      }
      if (!StringUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentKuaKuaHbFragment$KuaKuaHbBundleInfo.biz_params))
      {
        Object localObject = new JSONObject(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentKuaKuaHbFragment$KuaKuaHbBundleInfo.biz_params);
        if (localObject != null)
        {
          String str = ((JSONObject)localObject).optString("subject");
          localObject = ((JSONObject)localObject).optString("subject_type");
          if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!TextUtils.isEmpty(str)) && (a((String)localObject, str, this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentKuaKuaHbFragment$KuaKuaHbBundleInfo.subjectList)))
          {
            this.jdField_a_of_type_AndroidWidgetTextView.setText(str);
            return true;
          }
        }
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
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
      d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.fragment.KuaKuaHbFragment
 * JD-Core Version:    0.7.0.1
 */