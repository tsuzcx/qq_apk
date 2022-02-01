package com.tencent.biz.pubaccount.readinjoy.biu;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyConstants;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJAppSetting;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.push.RIJKanDianFolderStatus;
import com.tencent.biz.pubaccount.readinjoy.dt.RIJDtReportHelper;
import com.tencent.biz.pubaccount.readinjoy.struct.MultiBiuSameContent;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import org.json.JSONObject;

public class ReadInjoyFriendsBiuComponentFragment
  extends PublicBaseFragment
{
  FragmentActivity jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new ReadInjoyFriendsBiuComponentFragment.1(this);
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  AdapterView.OnItemClickListener jdField_a_of_type_ComTencentWidgetAdapterView$OnItemClickListener = new ReadInjoyFriendsBiuComponentFragment.2(this);
  ListView jdField_a_of_type_ComTencentWidgetListView;
  private String jdField_a_of_type_JavaLangString;
  ArrayList<MultiBiuSameContent> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private String b;
  private String c;
  private String d;
  private String e;
  private String f;
  
  private String a(long paramLong)
  {
    return ReadInJoyConstants.k + Base64Util.encodeToString(String.valueOf(paramLong).getBytes(), 2);
  }
  
  private String a(long paramLong1, int paramInt, long paramLong2)
  {
    String str2 = ReadInJoyConstants.e.replace("uin=", "uin=" + Base64Util.encodeToString(String.valueOf(paramLong1).getBytes(), 0).replace('\n', ' ').trim());
    String str1 = str2;
    if (str2.contains("&feedstype=")) {
      str1 = str2.replace("&feedstype=", "&feedstype=" + paramInt);
    }
    str1 = str1 + paramLong2;
    return str1 + "&jumptype=" + 4;
  }
  
  private void a(long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("algorithmId", this.c);
      localJSONObject.put("folder_status", RIJKanDianFolderStatus.a);
      localJSONObject.put("feedsSource", this.d);
      localJSONObject.put("feeds_type", paramInt + "");
      localJSONObject.put("kandian_mode", "" + RIJAppSetting.a());
      localJSONObject.put("tab_source", "" + RIJTransMergeKanDianReport.a());
      localJSONObject.put("rowkey", this.e);
      localJSONObject.put("channel_id", this.f);
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, String.valueOf(paramLong1), paramString, paramString, 0, 0, String.valueOf(paramLong2), "0", this.b, localJSONObject.toString(), false);
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      ReadInJoyUtils.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, paramString);
      if (QLog.isColorLevel()) {
        QLog.d("ReadInjoyFriendsBiuComponentFragment", 2, "jumpUrl url:" + paramString);
      }
    }
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = getActivity();
    paramBundle = getArguments();
    if (paramBundle != null)
    {
      ArrayList localArrayList = paramBundle.getParcelableArrayList("friends_biu_list");
      this.jdField_a_of_type_JavaUtilArrayList.addAll(localArrayList);
      this.jdField_a_of_type_JavaLangString = paramBundle.getString("articleID");
      this.b = paramBundle.getString("stategyID");
      this.c = paramBundle.getString("algorithmId");
      this.e = paramBundle.getString("rowkey");
      this.f = paramBundle.getString("channel_id");
      this.d = paramBundle.getString("feedsSource");
      if (QLog.isColorLevel()) {
        QLog.d("ReadInjoyFriendsBiuComponentFragment", 2, "onCreate mContents:" + this.jdField_a_of_type_JavaUtilArrayList.size());
      }
    }
    for (;;)
    {
      RIJDtReportHelper.a.a(getActivity());
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ReadInjoyFriendsBiuComponentFragment", 2, "onCreate mContents is null or empty");
      }
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131560321, paramViewGroup, false);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131367618));
    this.jdField_a_of_type_ComTencentWidgetListView = ((ListView)paramLayoutInflater.findViewById(2131367534));
    this.jdField_a_of_type_ComTencentWidgetListView.setSelector(2131167305);
    this.jdField_a_of_type_ComTencentWidgetListView.setOverScrollMode(0);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramLayoutInflater.findViewById(2131364815));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    paramLayoutInflater.findViewById(2131363410).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    paramViewGroup = (LinearLayout)paramLayoutInflater.findViewById(2131362729);
    paramBundle = new ReadInjoyFriendsBiuComponentFragment.FriensBiuAdapter(this, getActivity(), this.jdField_a_of_type_JavaUtilArrayList);
    this.jdField_a_of_type_ComTencentWidgetListView.setAdapter(paramBundle);
    this.jdField_a_of_type_ComTencentWidgetListView.setOnItemClickListener(this.jdField_a_of_type_ComTencentWidgetAdapterView$OnItemClickListener);
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText("Biu列表");
    }
    paramViewGroup.startAnimation(AnimationUtils.loadAnimation(getActivity(), 2130771981));
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onFinish()
  {
    if (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity != null) {
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.overridePendingTransition(0, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.biu.ReadInjoyFriendsBiuComponentFragment
 * JD-Core Version:    0.7.0.1
 */