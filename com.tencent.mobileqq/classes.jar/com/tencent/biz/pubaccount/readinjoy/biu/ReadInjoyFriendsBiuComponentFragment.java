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
import bbca;
import bfpc;
import com.tencent.biz.pubaccount.readinjoy.struct.MultiBiuSameContent;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import noo;
import oea;
import oeb;
import oec;
import omm;
import onk;
import org.json.JSONObject;

public class ReadInjoyFriendsBiuComponentFragment
  extends PublicBaseFragment
{
  public FragmentActivity a;
  public View.OnClickListener a;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  bfpc jdField_a_of_type_Bfpc = new oeb(this);
  ListView jdField_a_of_type_ComTencentWidgetListView;
  private String jdField_a_of_type_JavaLangString;
  public ArrayList<MultiBiuSameContent> a;
  private String b;
  private String c;
  private String d;
  private String e;
  private String f;
  
  public ReadInjoyFriendsBiuComponentFragment()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new oea(this);
  }
  
  private String a(long paramLong)
  {
    return omm.k + bbca.encodeToString(String.valueOf(paramLong).getBytes(), 2);
  }
  
  private String a(long paramLong1, int paramInt, long paramLong2)
  {
    String str2 = omm.e.replace("uin=", "uin=" + bbca.encodeToString(String.valueOf(paramLong1).getBytes(), 0).replace('\n', ' ').trim());
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
      localJSONObject.put("algorithm_id", this.c);
      localJSONObject.put("folder_status", onk.d);
      localJSONObject.put("feeds_source", this.d);
      localJSONObject.put("feeds_type", paramInt + "");
      localJSONObject.put("kandian_mode", "" + onk.e());
      localJSONObject.put("tab_source", "" + onk.d());
      localJSONObject.put("rowkey", this.e);
      localJSONObject.put("channel_id", this.f);
      noo.a(null, String.valueOf(paramLong1), paramString, paramString, 0, 0, String.valueOf(paramLong2), "0", this.b, localJSONObject.toString(), false);
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
      onk.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, paramString);
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
      localArrayList = paramBundle.getParcelableArrayList("friends_biu_list");
      this.jdField_a_of_type_JavaUtilArrayList.addAll(localArrayList);
      this.jdField_a_of_type_JavaLangString = paramBundle.getString("articleID");
      this.b = paramBundle.getString("stategyID");
      this.c = paramBundle.getString("algorithm_id");
      this.e = paramBundle.getString("rowkey");
      this.f = paramBundle.getString("channel_id");
      this.d = paramBundle.getString("feeds_source");
      if (QLog.isColorLevel()) {
        QLog.d("ReadInjoyFriendsBiuComponentFragment", 2, "onCreate mContents:" + this.jdField_a_of_type_JavaUtilArrayList.size());
      }
    }
    while (!QLog.isColorLevel())
    {
      ArrayList localArrayList;
      return;
    }
    QLog.d("ReadInjoyFriendsBiuComponentFragment", 2, "onCreate mContents is null or empty");
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131559940, paramViewGroup, false);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131366838));
    this.jdField_a_of_type_ComTencentWidgetListView = ((ListView)paramLayoutInflater.findViewById(2131366765));
    this.jdField_a_of_type_ComTencentWidgetListView.setSelector(2131167087);
    this.jdField_a_of_type_ComTencentWidgetListView.setOverScrollMode(0);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramLayoutInflater.findViewById(2131364259));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    paramLayoutInflater.findViewById(2131362991).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    paramViewGroup = (LinearLayout)paramLayoutInflater.findViewById(2131362538);
    paramBundle = new oec(this, getActivity(), this.jdField_a_of_type_JavaUtilArrayList);
    this.jdField_a_of_type_ComTencentWidgetListView.setAdapter(paramBundle);
    this.jdField_a_of_type_ComTencentWidgetListView.setOnItemClickListener(this.jdField_a_of_type_Bfpc);
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText("Biu列表");
    }
    paramViewGroup.startAnimation(AnimationUtils.loadAnimation(getActivity(), 2130771979));
    return paramLayoutInflater;
  }
  
  public void onFinish()
  {
    if (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity != null) {
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.overridePendingTransition(0, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.biu.ReadInjoyFriendsBiuComponentFragment
 * JD-Core Version:    0.7.0.1
 */