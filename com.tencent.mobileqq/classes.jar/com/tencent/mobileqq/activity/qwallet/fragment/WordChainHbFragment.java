package com.tencent.mobileqq.activity.qwallet.fragment;

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
import com.tencent.biz.SoftKeyboardObserver;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.qwallet.PasswdRedBagManager;
import com.tencent.mobileqq.activity.qwallet.SendHbActivity;
import com.tencent.mobileqq.activity.qwallet.fragment.busylogic.ConfigLogic;
import com.tencent.mobileqq.activity.qwallet.fragment.busylogic.ContinueChainBizImpl;
import com.tencent.mobileqq.activity.qwallet.fragment.busylogic.HbBusiUtils;
import com.tencent.mobileqq.activity.qwallet.fragment.busylogic.IWordChainBiz;
import com.tencent.mobileqq.activity.qwallet.fragment.busylogic.IdiomWordChainBizImpl;
import com.tencent.mobileqq.activity.qwallet.fragment.busylogic.KeyWordChainBizImpl;
import com.tencent.mobileqq.activity.qwallet.fragment.busylogic.WordChainBizImpl;
import com.tencent.mobileqq.activity.qwallet.utils.ReportUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.filemanager.widget.SearchFileFlowLayout;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.InputMethodUtil;
import cooperation.qwallet.QwUtils;
import cooperation.qwallet.pluginshare.HbInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class WordChainHbFragment
  extends BaseHbUIFragment
  implements View.OnClickListener
{
  private static SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("red_packet", 0);
  private static final Map<Integer, WordChainHbFragment.IdiomRecommendInfo> jdField_a_of_type_JavaUtilMap = new HashMap();
  private static final Set<Integer> jdField_a_of_type_JavaUtilSet = new HashSet();
  private long jdField_a_of_type_Long = 0L;
  private SparseArray<String> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private PasswdRedBagManager jdField_a_of_type_ComTencentMobileqqActivityQwalletPasswdRedBagManager;
  private WordChainHbFragment.IdiomHbBundleInfo jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentWordChainHbFragment$IdiomHbBundleInfo = new WordChainHbFragment.IdiomHbBundleInfo();
  private IWordChainBiz jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentBusylogicIWordChainBiz;
  private SearchFileFlowLayout jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSearchFileFlowLayout;
  private String jdField_a_of_type_JavaLangString;
  private ArrayList<WordChainHbFragment.WordChainTypeLabel> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private List<String> jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
  private boolean jdField_a_of_type_Boolean = true;
  private View jdField_b_of_type_AndroidViewView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private View jdField_c_of_type_AndroidViewView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  
  private IWordChainBiz a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 0: 
      return new IdiomWordChainBizImpl();
    case 1: 
      return new WordChainBizImpl();
    case 2: 
      return new KeyWordChainBizImpl();
    }
    return new ContinueChainBizImpl(this);
  }
  
  private String a(boolean paramBoolean)
  {
    try
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentWordChainHbFragment$IdiomHbBundleInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentBusylogicIWordChainBiz != null))
      {
        Object localObject = a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentWordChainHbFragment$IdiomHbBundleInfo.currSelectedSubChannel);
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentBusylogicIWordChainBiz.a((List)localObject, paramBoolean);
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
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentWordChainHbFragment$IdiomHbBundleInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentBusylogicIWordChainBiz != null))
    {
      InputFilter[] arrayOfInputFilter = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentBusylogicIWordChainBiz.a(paramInt);
      this.jdField_c_of_type_AndroidWidgetEditText.setFilters(arrayOfInputFilter);
    }
  }
  
  private void a(TextView paramTextView, WordChainHbFragment.WordChainTypeLabel paramWordChainTypeLabel)
  {
    paramTextView.setBackgroundDrawable(getResources().getDrawable(2130847659));
    paramTextView.setTextColor(-1);
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentWordChainHbFragment$IdiomHbBundleInfo != null) && ((paramTextView.getTag() instanceof WordChainHbFragment.WordChainTypeLabel)))
    {
      WordChainHbFragment.WordChainTypeLabel localWordChainTypeLabel = (WordChainHbFragment.WordChainTypeLabel)paramTextView.getTag();
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentWordChainHbFragment$IdiomHbBundleInfo.currSelectedSubChannel = localWordChainTypeLabel.jdField_a_of_type_Int;
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentBusylogicIWordChainBiz = a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentWordChainHbFragment$IdiomHbBundleInfo.currSelectedSubChannel);
      this.jdField_a_of_type_AndroidWidgetTextView.setText("");
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidWidgetTextView.getText() + paramTextView.getText().toString());
      if (this.jdField_a_of_type_Boolean) {
        jdField_a_of_type_AndroidContentSharedPreferences.edit().putInt("sp_key_last_selete_label", this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentWordChainHbFragment$IdiomHbBundleInfo.currSelectedSubChannel).apply();
      }
      a(paramWordChainTypeLabel.jdField_b_of_type_Int);
      c();
      if (this.jdField_c_of_type_AndroidWidgetEditText != null)
      {
        this.jdField_c_of_type_AndroidWidgetEditText.setText((CharSequence)this.jdField_a_of_type_AndroidUtilSparseArray.get(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentWordChainHbFragment$IdiomHbBundleInfo.currSelectedSubChannel));
        if (!TextUtils.isEmpty(paramWordChainTypeLabel.jdField_b_of_type_JavaLangString)) {
          this.jdField_c_of_type_AndroidWidgetEditText.setHint(paramWordChainTypeLabel.jdField_b_of_type_JavaLangString);
        }
      }
    }
  }
  
  private void a(WordChainHbFragment.GetIdiomListener paramGetIdiomListener)
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
        if (!HbInfo.c.contains(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentWordChainHbFragment$IdiomHbBundleInfo.recv_type)) {
          break label145;
        }
        if ("2".equals(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentWordChainHbFragment$IdiomHbBundleInfo.recv_type))
        {
          if (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPasswdRedBagManager == null) {
            break;
          }
          int j = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentWordChainHbFragment$IdiomHbBundleInfo.currSelectedSubChannel;
          this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPasswdRedBagManager.a(new WordChainHbFragment.3(this, j, paramGetIdiomListener), i, j);
          return;
        }
      }
      catch (Throwable paramGetIdiomListener)
      {
        QLog.e("WordChainHbFragment", 1, paramGetIdiomListener, new Object[0]);
        return;
      }
      i = 1;
      continue;
      label145:
      i = 0;
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
      InputMethodUtil.a(getActivity());
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  private void c()
  {
    WordChainHbFragment.IdiomRecommendInfo localIdiomRecommendInfo = (WordChainHbFragment.IdiomRecommendInfo)jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentWordChainHbFragment$IdiomHbBundleInfo.currSelectedSubChannel));
    if ((localIdiomRecommendInfo == null) || (localIdiomRecommendInfo.jdField_a_of_type_JavaUtilList.isEmpty()) || (Math.abs(NetConnInfoCenter.getServerTimeMillis() - localIdiomRecommendInfo.jdField_a_of_type_Long) > 86400000L)) {
      a(null);
    }
  }
  
  private void d()
  {
    if ((this.mActivity != null) && (this.mActivity.getConfigLogic() != null)) {
      this.jdField_a_of_type_JavaUtilArrayList = this.mActivity.getConfigLogic().a(this.channel, this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentWordChainHbFragment$IdiomHbBundleInfo);
    }
    if (this.jdField_a_of_type_JavaUtilArrayList.isEmpty())
    {
      WordChainHbFragment.WordChainTypeLabel localWordChainTypeLabel = new WordChainHbFragment.WordChainTypeLabel();
      localWordChainTypeLabel.jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131720676);
      localWordChainTypeLabel.jdField_a_of_type_Int = 0;
      localWordChainTypeLabel.jdField_b_of_type_Int = 4;
      this.jdField_a_of_type_JavaUtilArrayList.add(localWordChainTypeLabel);
    }
  }
  
  private void e()
  {
    if (this.jdField_c_of_type_AndroidWidgetTextView != null)
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setBackgroundDrawable(getResources().getDrawable(2130847658));
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
          WordChainHbFragment.WordChainTypeLabel localWordChainTypeLabel = (WordChainHbFragment.WordChainTypeLabel)((TextView)localObject).getTag();
          if ((this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentWordChainHbFragment$IdiomHbBundleInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentWordChainHbFragment$IdiomHbBundleInfo.currSelectedSubChannel == localWordChainTypeLabel.jdField_a_of_type_Int))
          {
            a((TextView)localObject, localWordChainTypeLabel);
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
    if (!StringUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentWordChainHbFragment$IdiomHbBundleInfo.biz_params)) {}
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
      localObject = HbBusiUtils.a(this.channel, this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentWordChainHbFragment$IdiomHbBundleInfo, this.mActivity.getConfigLogic(), a());
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
    Map localMap = this.mActivity.getMapPacketExtra();
    localMap.put("type", String.valueOf(1));
    localMap.put("wishing", this.jdField_a_of_type_JavaLangString);
    localMap.put("bus_type", "2");
    localMap.put("total_num", str1);
    localMap.put("total_amount", QwUtils.a(str2));
    localMap.put("channel", "" + this.channel);
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentWordChainHbFragment$IdiomHbBundleInfo.skinId)) {
      localMap.put("skin_id", this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentWordChainHbFragment$IdiomHbBundleInfo.skinId);
    }
    localMap.put("subchannel", this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentWordChainHbFragment$IdiomHbBundleInfo.currSelectedSubChannel + "");
    this.mLogic.a(localMap);
    ReportUtils.a(this.mQApp, "redpack.paybtn.click", null, this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentWordChainHbFragment$IdiomHbBundleInfo.panel_name);
  }
  
  public int a()
  {
    return 2131562077;
  }
  
  protected String a()
  {
    return HardCodeUtil.a(2131705734);
  }
  
  public List<String> a(int paramInt)
  {
    WordChainHbFragment.IdiomRecommendInfo localIdiomRecommendInfo = (WordChainHbFragment.IdiomRecommendInfo)jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt));
    if (localIdiomRecommendInfo != null) {
      return localIdiomRecommendInfo.jdField_a_of_type_JavaUtilList;
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
    HbInfo.a(paramBundle, this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentWordChainHbFragment$IdiomHbBundleInfo);
    if (QLog.isColorLevel()) {
      QLog.i("WordChainHbFragment", 2, "bizParams:" + this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentWordChainHbFragment$IdiomHbBundleInfo.biz_params);
    }
    if (HbInfo.b.contains(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentWordChainHbFragment$IdiomHbBundleInfo.recv_type))
    {
      this.jdField_a_of_type_AndroidWidgetEditText.setText("1");
      this.jdField_a_of_type_AndroidViewView.findViewById(2131379746).setVisibility(8);
    }
    for (;;)
    {
      this.jdField_c_of_type_AndroidWidgetEditText.setFocusable(true);
      this.jdField_c_of_type_AndroidWidgetEditText.setOnFocusChangeListener(new WordChainHbFragment.2(this));
      this.jdField_a_of_type_AndroidViewView.setClickable(true);
      this.jdField_a_of_type_AndroidViewView.findViewById(2131369603).setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSearchFileFlowLayout = ((SearchFileFlowLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131367114));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131381972));
      this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131363766);
      this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131369029);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131380590));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131380407));
      if (QLog.isColorLevel())
      {
        QLog.i("WordChainHbFragment", 2, "isFlyMe: " + SystemUtil.d() + " isMeizu:" + SystemUtil.e());
        QLog.i("WordChainHbFragment", 2, "biz_params: " + this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentWordChainHbFragment$IdiomHbBundleInfo.biz_params);
      }
      return;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentWordChainHbFragment$IdiomHbBundleInfo.people_num)) {
        this.jdField_a_of_type_AndroidWidgetEditText.setHint(HardCodeUtil.a(2131705738) + this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentWordChainHbFragment$IdiomHbBundleInfo.people_num + HardCodeUtil.a(2131705742));
      }
      this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
    }
  }
  
  public void a(String paramString)
  {
    this.mActivity.showToast(paramString);
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentBusylogicIWordChainBiz != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentBusylogicIWordChainBiz.a(this.jdField_c_of_type_AndroidWidgetEditText.getText().toString().trim());
    }
    if (super.a())
    {
      this.jdField_a_of_type_JavaLangString = this.jdField_c_of_type_AndroidWidgetEditText.getText().toString().trim();
      if (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentBusylogicIWordChainBiz != null) {
        this.jdField_a_of_type_AndroidWidgetButton.setEnabled(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentBusylogicIWordChainBiz.a(this.jdField_a_of_type_JavaLangString));
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
      this.mActivity.addHbUploadData("idiom.wrappacket.wrap");
      i();
      continue;
      this.mActivity.addHbUploadData("idiom.wrappacket.random");
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
    if (this.jdField_a_of_type_ComTencentBizSoftKeyboardObserver != null) {
      this.jdField_a_of_type_ComTencentBizSoftKeyboardObserver.a();
    }
  }
  
  protected void onLazyLoad()
  {
    super.onLazyLoad();
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPasswdRedBagManager = ((PasswdRedBagManager)this.mQApp.getManager(QQManagerFactory.PASSWD_RED_BAG_MANAGER));
    f();
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    super.setUserVisibleHint(paramBoolean);
    if (paramBoolean)
    {
      QLog.i("WordChainHbFragment", 2, "idiom enter...");
      if (this.mActivity != null) {
        this.mActivity.addHbUploadData("idiom.wrappacket.show");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.fragment.WordChainHbFragment
 * JD-Core Version:    0.7.0.1
 */