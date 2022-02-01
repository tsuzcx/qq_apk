package com.tencent.mobileqq.activity.qwallet.fragment;

import akwu;
import albl;
import albx;
import albz;
import alca;
import alcb;
import alcc;
import alce;
import alcf;
import alcg;
import alcs;
import alct;
import alcu;
import alcx;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import anzj;
import bhjr;
import bhsr;
import blgx;
import bmrq;
import bmrx;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.qwallet.SendHbActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.widget.SearchFileFlowLayout;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import nkr;
import org.json.JSONException;
import org.json.JSONObject;

public class WordChainHbFragment
  extends BaseHbUIFragment
  implements View.OnClickListener
{
  private static SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("red_packet", 0);
  private static final Map<Integer, alcb> jdField_a_of_type_JavaUtilMap = new HashMap();
  private static final Set<Integer> jdField_a_of_type_JavaUtilSet = new HashSet();
  private long jdField_a_of_type_Long;
  private akwu jdField_a_of_type_Akwu;
  private alcs jdField_a_of_type_Alcs;
  private SparseArray<String> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private WordChainHbFragment.IdiomHbBundleInfo jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentWordChainHbFragment$IdiomHbBundleInfo = new WordChainHbFragment.IdiomHbBundleInfo();
  private SearchFileFlowLayout jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSearchFileFlowLayout;
  private String jdField_a_of_type_JavaLangString;
  private ArrayList<alcc> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private List<String> jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
  private boolean jdField_a_of_type_Boolean = true;
  private View jdField_b_of_type_AndroidViewView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private View jdField_c_of_type_AndroidViewView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  
  private alcs a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 0: 
      return new alct();
    case 1: 
      return new alcx();
    case 2: 
      return new alcu();
    }
    return new alcf(this);
  }
  
  private String a(boolean paramBoolean)
  {
    try
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentWordChainHbFragment$IdiomHbBundleInfo != null) && (this.jdField_a_of_type_Alcs != null))
      {
        Object localObject = a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentWordChainHbFragment$IdiomHbBundleInfo.currSelectedSubChannel);
        localObject = this.jdField_a_of_type_Alcs.a((List)localObject, paramBoolean);
        return localObject;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("WordChainHbFragment", 1, localThrowable, new Object[0]);
    }
    return "";
  }
  
  private void a(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentWordChainHbFragment$IdiomHbBundleInfo != null) && (this.jdField_a_of_type_Alcs != null))
    {
      InputFilter[] arrayOfInputFilter = this.jdField_a_of_type_Alcs.a(paramInt);
      this.jdField_c_of_type_AndroidWidgetEditText.setFilters(arrayOfInputFilter);
    }
  }
  
  private void a(alca paramalca)
  {
    int i = 2;
    for (;;)
    {
      try
      {
        if (jdField_a_of_type_JavaUtilSet.contains(Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentWordChainHbFragment$IdiomHbBundleInfo.currSelectedSubChannel))) {
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("WordChainHbFragment", 2, "is getIdiomListFromSSO...");
        }
        jdField_a_of_type_JavaUtilSet.add(Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentWordChainHbFragment$IdiomHbBundleInfo.currSelectedSubChannel));
        if (!bmrx.c.contains(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentWordChainHbFragment$IdiomHbBundleInfo.recv_type)) {
          break label143;
        }
        if ("2".equals(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentWordChainHbFragment$IdiomHbBundleInfo.recv_type))
        {
          if (this.jdField_a_of_type_Akwu == null) {
            break;
          }
          int j = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentWordChainHbFragment$IdiomHbBundleInfo.currSelectedSubChannel;
          this.jdField_a_of_type_Akwu.a(new albz(this, j, paramalca), i, j);
          return;
        }
      }
      catch (Throwable paramalca)
      {
        QLog.e("WordChainHbFragment", 1, paramalca, new Object[0]);
        return;
      }
      i = 1;
      continue;
      label143:
      i = 0;
    }
  }
  
  private void a(TextView paramTextView, alcc paramalcc)
  {
    paramTextView.setBackgroundDrawable(getResources().getDrawable(2130847296));
    paramTextView.setTextColor(-1);
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentWordChainHbFragment$IdiomHbBundleInfo != null) && ((paramTextView.getTag() instanceof alcc)))
    {
      alcc localalcc = (alcc)paramTextView.getTag();
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentWordChainHbFragment$IdiomHbBundleInfo.currSelectedSubChannel = localalcc.jdField_a_of_type_Int;
      this.jdField_a_of_type_Alcs = a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentWordChainHbFragment$IdiomHbBundleInfo.currSelectedSubChannel);
      this.jdField_a_of_type_AndroidWidgetTextView.setText("");
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidWidgetTextView.getText() + paramTextView.getText().toString());
      if (this.jdField_a_of_type_Boolean) {
        jdField_a_of_type_AndroidContentSharedPreferences.edit().putInt("sp_key_last_selete_label", this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentWordChainHbFragment$IdiomHbBundleInfo.currSelectedSubChannel).apply();
      }
      a(paramalcc.jdField_b_of_type_Int);
      c();
      if (this.jdField_c_of_type_AndroidWidgetEditText != null)
      {
        this.jdField_c_of_type_AndroidWidgetEditText.setText((CharSequence)this.jdField_a_of_type_AndroidUtilSparseArray.get(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentWordChainHbFragment$IdiomHbBundleInfo.currSelectedSubChannel));
        if (!TextUtils.isEmpty(paramalcc.jdField_b_of_type_JavaLangString)) {
          this.jdField_c_of_type_AndroidWidgetEditText.setHint(paramalcc.jdField_b_of_type_JavaLangString);
        }
      }
    }
  }
  
  private void b(int paramInt)
  {
    this.jdField_c_of_type_AndroidViewView.setVisibility(paramInt);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(paramInt);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSearchFileFlowLayout.setVisibility(paramInt);
    this.jdField_b_of_type_AndroidViewView.setVisibility(paramInt);
    if (paramInt == 0) {}
    try
    {
      blgx.a(getActivity());
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  private void c()
  {
    alcb localalcb = (alcb)jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentWordChainHbFragment$IdiomHbBundleInfo.currSelectedSubChannel));
    if ((localalcb == null) || (localalcb.jdField_a_of_type_JavaUtilList.isEmpty()) || (Math.abs(NetConnInfoCenter.getServerTimeMillis() - localalcb.jdField_a_of_type_Long) > 86400000L)) {
      a(null);
    }
  }
  
  private void d()
  {
    if ((this.mActivity != null) && (this.mActivity.a() != null)) {
      this.jdField_a_of_type_JavaUtilArrayList = this.mActivity.a().a(this.channel, this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentWordChainHbFragment$IdiomHbBundleInfo);
    }
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.isEmpty()))
    {
      alcc localalcc = new alcc();
      localalcc.jdField_a_of_type_JavaLangString = anzj.a(2131719328);
      localalcc.jdField_a_of_type_Int = 0;
      localalcc.jdField_b_of_type_Int = 4;
      this.jdField_a_of_type_JavaUtilArrayList.add(localalcc);
    }
  }
  
  private void e()
  {
    if (this.jdField_c_of_type_AndroidWidgetTextView != null)
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setBackgroundDrawable(getResources().getDrawable(2130847295));
      this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#03081A"));
    }
  }
  
  private void f()
  {
    d();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSearchFileFlowLayout.post(new WordChainHbFragment.1(this));
  }
  
  private void g()
  {
    int j;
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSearchFileFlowLayout != null)
    {
      j = this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSearchFileFlowLayout.getChildCount();
      if (j > 0) {
        i = 0;
      }
    }
    for (;;)
    {
      if (i < j)
      {
        Object localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSearchFileFlowLayout.getChildAt(i);
        if ((localObject instanceof TextView))
        {
          localObject = (TextView)localObject;
          alcc localalcc = (alcc)((TextView)localObject).getTag();
          if ((this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentWordChainHbFragment$IdiomHbBundleInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentWordChainHbFragment$IdiomHbBundleInfo.currSelectedSubChannel == localalcc.jdField_a_of_type_Int))
          {
            a((TextView)localObject, localalcc);
            this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)localObject);
          }
        }
      }
      else
      {
        return;
      }
      i += 1;
    }
  }
  
  private void h()
  {
    j = 0;
    i = j;
    if (!bhsr.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentWordChainHbFragment$IdiomHbBundleInfo.biz_params)) {}
    try
    {
      this.jdField_a_of_type_Boolean = false;
      localObject = new JSONObject(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentWordChainHbFragment$IdiomHbBundleInfo.biz_params);
      String str = ((JSONObject)localObject).optString("idiom", "");
      int k = ((JSONObject)localObject).optInt("sub_channel", 0);
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentWordChainHbFragment$IdiomHbBundleInfo.currSelectedSubChannel = k;
      i = j;
      if (!TextUtils.isEmpty(str))
      {
        this.jdField_c_of_type_AndroidWidgetEditText.setText(str);
        this.jdField_a_of_type_AndroidUtilSparseArray.put(k, str);
        i = 1;
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        Object localObject;
        localJSONException.printStackTrace();
        i = j;
      }
    }
    if (i == 0)
    {
      localObject = alcg.a(this.channel, this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentWordChainHbFragment$IdiomHbBundleInfo, this.mActivity.a(), a());
      this.jdField_c_of_type_AndroidWidgetEditText.setHint((CharSequence)localObject);
    }
  }
  
  private void i()
  {
    long l = System.currentTimeMillis();
    if (this.jdField_a_of_type_Long + 1000L > l) {
      return;
    }
    this.jdField_a_of_type_Long = l;
    String str1 = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
    String str2 = this.jdField_b_of_type_AndroidWidgetEditText.getText().toString();
    Map localMap = this.mActivity.a();
    localMap.put("type", String.valueOf(1));
    localMap.put("wishing", this.jdField_a_of_type_JavaLangString);
    localMap.put("bus_type", "2");
    localMap.put("total_num", str1);
    localMap.put("total_amount", bmrq.a(str2));
    localMap.put("channel", "" + this.channel);
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentWordChainHbFragment$IdiomHbBundleInfo.skinId)) {
      localMap.put("skin_id", this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentWordChainHbFragment$IdiomHbBundleInfo.skinId);
    }
    localMap.put("subchannel", this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentWordChainHbFragment$IdiomHbBundleInfo.currSelectedSubChannel + "");
    this.mLogic.a(localMap);
  }
  
  public int a()
  {
    return 2131561996;
  }
  
  protected String a()
  {
    return anzj.a(2131704610);
  }
  
  public List<String> a(int paramInt)
  {
    alcb localalcb = (alcb)jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt));
    if (localalcb != null) {
      return localalcb.jdField_a_of_type_JavaUtilList;
    }
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a()
  {
    this.jdField_c_of_type_AndroidWidgetEditText.addTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
    h();
    b();
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    bmrx.a(paramBundle, this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentWordChainHbFragment$IdiomHbBundleInfo);
    if (QLog.isColorLevel()) {
      QLog.i("WordChainHbFragment", 2, "bizParams:" + this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentWordChainHbFragment$IdiomHbBundleInfo.biz_params);
    }
    if (bmrx.b.contains(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentWordChainHbFragment$IdiomHbBundleInfo.recv_type))
    {
      this.jdField_a_of_type_AndroidWidgetEditText.setText("1");
      this.jdField_a_of_type_AndroidViewView.findViewById(2131379257).setVisibility(8);
    }
    for (;;)
    {
      this.jdField_c_of_type_AndroidWidgetEditText.setFocusable(true);
      this.jdField_c_of_type_AndroidWidgetEditText.setOnFocusChangeListener(new albx(this));
      this.jdField_a_of_type_AndroidViewView.setClickable(true);
      this.jdField_a_of_type_AndroidViewView.findViewById(2131369163).setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSearchFileFlowLayout = ((SearchFileFlowLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131366782));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131381432));
      this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131363575);
      this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131368613);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131380076));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379890));
      if (QLog.isColorLevel())
      {
        QLog.i("WordChainHbFragment", 2, "isFlyMe: " + bhjr.d() + " isMeizu:" + bhjr.e());
        QLog.i("WordChainHbFragment", 2, "biz_params: " + this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentWordChainHbFragment$IdiomHbBundleInfo.biz_params);
      }
      return;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentWordChainHbFragment$IdiomHbBundleInfo.people_num)) {
        this.jdField_a_of_type_AndroidWidgetEditText.setHint(anzj.a(2131704614) + this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentWordChainHbFragment$IdiomHbBundleInfo.people_num + anzj.a(2131704618));
      }
      this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
    }
  }
  
  public void a(String paramString)
  {
    this.mActivity.a(paramString);
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_Alcs != null) {
      this.jdField_a_of_type_Alcs.a(this.jdField_c_of_type_AndroidWidgetEditText.getText().toString().trim());
    }
    if (super.a())
    {
      this.jdField_a_of_type_JavaLangString = this.jdField_c_of_type_AndroidWidgetEditText.getText().toString().trim();
      if (this.jdField_a_of_type_Alcs != null) {
        this.jdField_a_of_type_AndroidWidgetButton.setEnabled(this.jdField_a_of_type_Alcs.a(this.jdField_a_of_type_JavaLangString));
      }
    }
    return this.jdField_a_of_type_AndroidWidgetButton.isEnabled();
  }
  
  public int b()
  {
    String str = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
    if (TextUtils.isEmpty(str)) {
      return 0;
    }
    try
    {
      int i = Integer.parseInt(str);
      return i;
    }
    catch (NumberFormatException localNumberFormatException) {}
    return 0;
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
      this.mActivity.c("idiom.wrappacket.wrap");
      i();
      continue;
      this.mActivity.c("idiom.wrappacket.random");
      long l = System.currentTimeMillis();
      if (this.jdField_a_of_type_Long + 100L <= l)
      {
        this.jdField_a_of_type_Long = l;
        String str = a(true);
        this.jdField_c_of_type_AndroidWidgetEditText.setText(str);
        this.jdField_a_of_type_AndroidUtilSparseArray.put(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentWordChainHbFragment$IdiomHbBundleInfo.currSelectedSubChannel, str);
        this.jdField_c_of_type_AndroidWidgetEditText.setSelection(this.jdField_c_of_type_AndroidWidgetEditText.getText().length());
        c();
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_Nkr != null) {
      this.jdField_a_of_type_Nkr.a();
    }
  }
  
  protected void onLazyLoad()
  {
    super.onLazyLoad();
    this.jdField_a_of_type_Akwu = ((akwu)this.mQApp.getManager(125));
    f();
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    super.setUserVisibleHint(paramBoolean);
    if (paramBoolean)
    {
      QLog.i("WordChainHbFragment", 2, "idiom enter...");
      if (this.mActivity != null) {
        this.mActivity.c("idiom.wrappacket.show");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.fragment.WordChainHbFragment
 * JD-Core Version:    0.7.0.1
 */