package com.tencent.mobileqq.activity.qwallet.fragment;

import aiul;
import aiyl;
import aiyx;
import aiyy;
import aiyz;
import aiza;
import aizc;
import aizd;
import aizp;
import aizq;
import aizt;
import alud;
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
import android.widget.TextView;
import bdep;
import bdin;
import bdnn;
import bjcf;
import bjcm;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.qwallet.SendHbActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.widget.SearchFileFlowLayout;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class WordChainHbFragment
  extends BaseHbUIFragment
  implements View.OnClickListener
{
  private static long jdField_a_of_type_Long;
  private static SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("red_packet", 0);
  private static final CopyOnWriteArrayList<String> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  private aiul jdField_a_of_type_Aiul;
  private aizp jdField_a_of_type_Aizp;
  private SparseArray<String> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private WordChainHbFragment.IdiomHbBundleInfo jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentWordChainHbFragment$IdiomHbBundleInfo = new WordChainHbFragment.IdiomHbBundleInfo();
  private SearchFileFlowLayout jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSearchFileFlowLayout;
  private String jdField_a_of_type_JavaLangString;
  private ArrayList<aiza> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  public boolean a;
  private long jdField_b_of_type_Long;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private boolean jdField_b_of_type_Boolean = true;
  private TextView c;
  
  private aizp a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 0: 
      return new aizq();
    }
    return new aizt();
  }
  
  private String a(boolean paramBoolean)
  {
    try
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentWordChainHbFragment$IdiomHbBundleInfo != null) && (this.jdField_a_of_type_Aizp != null))
      {
        String str = this.jdField_a_of_type_Aizp.a(jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList, paramBoolean);
        return str;
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
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentWordChainHbFragment$IdiomHbBundleInfo != null) && (this.jdField_a_of_type_Aizp != null))
    {
      InputFilter[] arrayOfInputFilter = this.jdField_a_of_type_Aizp.a(paramInt);
      this.jdField_c_of_type_AndroidWidgetEditText.setFilters(arrayOfInputFilter);
    }
  }
  
  private void a(aiyz paramaiyz)
  {
    int i = 2;
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_Boolean) {
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("WordChainHbFragment", 2, "is getIdiomListFromSSO...");
        }
        this.jdField_a_of_type_Boolean = true;
        if (!bjcm.c.contains(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentWordChainHbFragment$IdiomHbBundleInfo.recv_type)) {
          break label112;
        }
        if ("2".equals(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentWordChainHbFragment$IdiomHbBundleInfo.recv_type))
        {
          if (this.jdField_a_of_type_Aiul == null) {
            break;
          }
          this.jdField_a_of_type_Aiul.a(new aiyy(this, paramaiyz), i, this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentWordChainHbFragment$IdiomHbBundleInfo.currSelectedSubChannel);
          return;
        }
      }
      catch (Throwable paramaiyz)
      {
        QLog.e("WordChainHbFragment", 1, paramaiyz, new Object[0]);
        return;
      }
      i = 1;
      continue;
      label112:
      i = 0;
    }
  }
  
  private void a(TextView paramTextView, aiza paramaiza)
  {
    paramTextView.setBackgroundDrawable(getResources().getDrawable(2130846829));
    paramTextView.setTextColor(-1);
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentWordChainHbFragment$IdiomHbBundleInfo != null) && ((paramTextView.getTag() instanceof aiza)))
    {
      aiza localaiza = (aiza)paramTextView.getTag();
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentWordChainHbFragment$IdiomHbBundleInfo.currSelectedSubChannel = localaiza.jdField_a_of_type_Int;
      this.jdField_a_of_type_Aizp = a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentWordChainHbFragment$IdiomHbBundleInfo.currSelectedSubChannel);
      this.jdField_b_of_type_AndroidWidgetTextView.setText("");
      this.jdField_b_of_type_AndroidWidgetTextView.setText(alud.a(2131711668) + paramTextView.getText().toString());
      this.jdField_a_of_type_AndroidWidgetTextView.setText("");
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidWidgetTextView.getText() + paramTextView.getText().toString());
      if (this.jdField_b_of_type_Boolean) {
        jdField_a_of_type_AndroidContentSharedPreferences.edit().putInt("sp_key_last_selete_label", this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentWordChainHbFragment$IdiomHbBundleInfo.currSelectedSubChannel).apply();
      }
      a(paramaiza.b);
      jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
      if (this.jdField_c_of_type_AndroidWidgetEditText != null) {
        this.jdField_c_of_type_AndroidWidgetEditText.setText((CharSequence)this.jdField_a_of_type_AndroidUtilSparseArray.get(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentWordChainHbFragment$IdiomHbBundleInfo.currSelectedSubChannel));
      }
    }
  }
  
  private void c()
  {
    if ((this.mActivity != null) && (this.mActivity.a() != null)) {
      this.jdField_a_of_type_JavaUtilArrayList = this.mActivity.a().a(this.channel, this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentWordChainHbFragment$IdiomHbBundleInfo);
    }
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.isEmpty()))
    {
      aiza localaiza = new aiza();
      localaiza.jdField_a_of_type_JavaLangString = alud.a(2131721458);
      localaiza.jdField_a_of_type_Int = 0;
      localaiza.b = 4;
      this.jdField_a_of_type_JavaUtilArrayList.add(localaiza);
    }
  }
  
  private void d()
  {
    if (this.jdField_c_of_type_AndroidWidgetTextView != null)
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setBackgroundDrawable(getResources().getDrawable(2130846828));
      this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#03081A"));
    }
  }
  
  private void e()
  {
    c();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSearchFileFlowLayout.post(new WordChainHbFragment.1(this));
  }
  
  private void f()
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
          aiza localaiza = (aiza)((TextView)localObject).getTag();
          if ((this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentWordChainHbFragment$IdiomHbBundleInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentWordChainHbFragment$IdiomHbBundleInfo.currSelectedSubChannel == localaiza.jdField_a_of_type_Int))
          {
            a((TextView)localObject, localaiza);
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
  
  private void g()
  {
    j = 0;
    i = j;
    if (!bdnn.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentWordChainHbFragment$IdiomHbBundleInfo.biz_params)) {}
    try
    {
      this.jdField_b_of_type_Boolean = false;
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
      localObject = aizd.a(this.channel, this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentWordChainHbFragment$IdiomHbBundleInfo, this.mActivity.a(), a());
      this.jdField_c_of_type_AndroidWidgetEditText.setHint((CharSequence)localObject);
    }
  }
  
  private void h()
  {
    long l = System.currentTimeMillis();
    if (this.jdField_b_of_type_Long + 1000L > l) {
      return;
    }
    this.jdField_b_of_type_Long = l;
    String str1 = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
    String str2 = this.jdField_b_of_type_AndroidWidgetEditText.getText().toString();
    Map localMap = this.mActivity.a();
    localMap.put("type", String.valueOf(1));
    localMap.put("wishing", this.jdField_a_of_type_JavaLangString);
    localMap.put("bus_type", "2");
    localMap.put("total_num", str1);
    localMap.put("total_amount", bjcf.a(str2));
    localMap.put("channel", "" + this.channel);
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentWordChainHbFragment$IdiomHbBundleInfo.skinId)) {
      localMap.put("skin_id", this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentWordChainHbFragment$IdiomHbBundleInfo.skinId);
    }
    localMap.put("subchannel", this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentWordChainHbFragment$IdiomHbBundleInfo.currSelectedSubChannel + "");
    this.mLogic.a(localMap);
  }
  
  public int a()
  {
    return 2131561719;
  }
  
  protected String a()
  {
    return alud.a(2131706102);
  }
  
  public void a()
  {
    this.jdField_c_of_type_AndroidWidgetEditText.addTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
    g();
    b();
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    bjcm.a(paramBundle, this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentWordChainHbFragment$IdiomHbBundleInfo);
    if (QLog.isColorLevel()) {
      QLog.i("WordChainHbFragment", 2, "bizParams:" + this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentWordChainHbFragment$IdiomHbBundleInfo.biz_params);
    }
    if (bjcm.b.contains(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentWordChainHbFragment$IdiomHbBundleInfo.recv_type))
    {
      this.jdField_a_of_type_AndroidWidgetEditText.setText("1");
      this.jdField_a_of_type_AndroidViewView.findViewById(2131378240).setVisibility(8);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidViewView.findViewById(2131368736).setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSearchFileFlowLayout = ((SearchFileFlowLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131366466));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378993));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378835));
      if (QLog.isColorLevel())
      {
        QLog.i("WordChainHbFragment", 2, "isFlyMe: " + bdep.d() + " isMeizu:" + bdep.e());
        QLog.i("WordChainHbFragment", 2, "biz_params: " + this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentWordChainHbFragment$IdiomHbBundleInfo.biz_params);
      }
      return;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentWordChainHbFragment$IdiomHbBundleInfo.people_num)) {
        this.jdField_a_of_type_AndroidWidgetEditText.setHint(alud.a(2131706106) + this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentWordChainHbFragment$IdiomHbBundleInfo.people_num + alud.a(2131706110));
      }
      this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
    }
  }
  
  public boolean a()
  {
    if (super.a())
    {
      this.jdField_a_of_type_JavaLangString = this.jdField_c_of_type_AndroidWidgetEditText.getText().toString().trim();
      if (this.jdField_a_of_type_Aizp != null) {
        this.jdField_a_of_type_AndroidWidgetButton.setEnabled(this.jdField_a_of_type_Aizp.a(this.jdField_a_of_type_JavaLangString));
      }
    }
    return this.jdField_a_of_type_AndroidWidgetButton.isEnabled();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    long l;
    do
    {
      return;
      this.mActivity.c("idiom.wrappacket.wrap");
      h();
      return;
      this.mActivity.c("idiom.wrappacket.random");
      l = System.currentTimeMillis();
    } while (this.jdField_b_of_type_Long + 100L > l);
    this.jdField_b_of_type_Long = l;
    paramView = a(false);
    if (TextUtils.isEmpty(paramView))
    {
      if (!bdin.g(this.mActivity))
      {
        paramView = a(true);
        this.jdField_c_of_type_AndroidWidgetEditText.setText(paramView);
        this.jdField_a_of_type_AndroidUtilSparseArray.put(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentWordChainHbFragment$IdiomHbBundleInfo.currSelectedSubChannel, paramView);
        this.jdField_c_of_type_AndroidWidgetEditText.setSelection(this.jdField_c_of_type_AndroidWidgetEditText.getText().length());
        return;
      }
      a(new aiyx(this));
      return;
    }
    this.jdField_c_of_type_AndroidWidgetEditText.setText(paramView);
    this.jdField_a_of_type_AndroidUtilSparseArray.put(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentWordChainHbFragment$IdiomHbBundleInfo.currSelectedSubChannel, paramView);
    this.jdField_c_of_type_AndroidWidgetEditText.setSelection(this.jdField_c_of_type_AndroidWidgetEditText.getText().length());
  }
  
  protected void onLazyLoad()
  {
    super.onLazyLoad();
    this.jdField_a_of_type_Aiul = ((aiul)this.mQApp.getManager(125));
    if ((jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.isEmpty()) || (System.currentTimeMillis() - jdField_a_of_type_Long > 86400000L)) {
      a(null);
    }
    e();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.fragment.WordChainHbFragment
 * JD-Core Version:    0.7.0.1
 */