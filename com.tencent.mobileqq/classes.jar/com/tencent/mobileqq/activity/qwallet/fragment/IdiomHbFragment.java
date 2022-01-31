package com.tencent.mobileqq.activity.qwallet.fragment;

import agjk;
import agmz;
import agna;
import agnb;
import agnm;
import agnz;
import ajjy;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import azzu;
import badq;
import baip;
import bfod;
import bfok;
import com.tencent.mobileqq.activity.qwallet.SendHbActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class IdiomHbFragment
  extends BaseHbUIFragment
  implements View.OnClickListener
{
  private static long jdField_a_of_type_Long;
  private static final CopyOnWriteArrayList<String> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  private agjk jdField_a_of_type_Agjk;
  private IdiomHbFragment.IdiomHbBundleInfo jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentIdiomHbFragment$IdiomHbBundleInfo = new IdiomHbFragment.IdiomHbBundleInfo();
  private String jdField_a_of_type_JavaLangString;
  private List<String> jdField_a_of_type_JavaUtilList;
  public boolean a;
  private long b;
  
  private String a(boolean paramBoolean)
  {
    for (;;)
    {
      int i;
      try
      {
        i = jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() - 1;
        String str;
        if (i >= 0)
        {
          str = (String)jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(i);
          if ((TextUtils.isEmpty(str)) || (str.length() != 4)) {
            break label327;
          }
          return str;
        }
        if (paramBoolean)
        {
          if (this.jdField_a_of_type_JavaUtilList == null)
          {
            this.jdField_a_of_type_JavaUtilList = new ArrayList();
            this.jdField_a_of_type_JavaUtilList.add(ajjy.a(2131639923));
            this.jdField_a_of_type_JavaUtilList.add(ajjy.a(2131639928));
            this.jdField_a_of_type_JavaUtilList.add(ajjy.a(2131639924));
            this.jdField_a_of_type_JavaUtilList.add(ajjy.a(2131639929));
            this.jdField_a_of_type_JavaUtilList.add(ajjy.a(2131639925));
            this.jdField_a_of_type_JavaUtilList.add(ajjy.a(2131639927));
            this.jdField_a_of_type_JavaUtilList.add(ajjy.a(2131639921));
            this.jdField_a_of_type_JavaUtilList.add(ajjy.a(2131639934));
            this.jdField_a_of_type_JavaUtilList.add(ajjy.a(2131639931));
            this.jdField_a_of_type_JavaUtilList.add(ajjy.a(2131639933));
            this.jdField_a_of_type_JavaUtilList.add(ajjy.a(2131639932));
          }
          i = new Random().nextInt(this.jdField_a_of_type_JavaUtilList.size());
          if (QLog.isColorLevel()) {
            QLog.i("IdiomHbFragment", 2, "getRandomIdiom get backIdiom:" + i + " backIdiomListSize:" + this.jdField_a_of_type_JavaUtilList.size());
          }
          str = (String)this.jdField_a_of_type_JavaUtilList.get(i);
          return str;
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("IdiomHbFragment", 1, localThrowable, new Object[0]);
      }
      return "";
      label327:
      i -= 1;
    }
  }
  
  private void a(agnb paramagnb)
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
          QLog.d("IdiomHbFragment", 2, "is getIdiomListFromSSO...");
        }
        this.jdField_a_of_type_Boolean = true;
        if (!bfok.c.contains(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentIdiomHbFragment$IdiomHbBundleInfo.recv_type)) {
          break label105;
        }
        if ("2".equals(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentIdiomHbFragment$IdiomHbBundleInfo.recv_type))
        {
          if (this.jdField_a_of_type_Agjk == null) {
            break;
          }
          this.jdField_a_of_type_Agjk.a(new agna(this, paramagnb), i);
          return;
        }
      }
      catch (Throwable paramagnb)
      {
        QLog.e("IdiomHbFragment", 1, paramagnb, new Object[0]);
        return;
      }
      i = 1;
      continue;
      label105:
      i = 0;
    }
  }
  
  private void c()
  {
    j = 0;
    i = j;
    if (!baip.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentIdiomHbFragment$IdiomHbBundleInfo.biz_params)) {}
    try
    {
      String str = new JSONObject(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentIdiomHbFragment$IdiomHbBundleInfo.biz_params).optString("idiom", "");
      i = j;
      if (!TextUtils.isEmpty(str))
      {
        this.c.setText(str);
        i = 1;
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
        i = j;
      }
    }
    if (i == 0) {
      this.c.setHint(agnz.a(this.channel, this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentIdiomHbFragment$IdiomHbBundleInfo, this.mActivity.a(), a()));
    }
  }
  
  private void d()
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
    localMap.put("total_amount", bfod.a(str2));
    localMap.put("channel", "" + this.channel);
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentIdiomHbFragment$IdiomHbBundleInfo.skinId)) {
      localMap.put("skin_id", this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentIdiomHbFragment$IdiomHbBundleInfo.skinId);
    }
    this.mLogic.a(localMap);
  }
  
  public int a()
  {
    return 2131495919;
  }
  
  protected String a()
  {
    return ajjy.a(2131639922);
  }
  
  public void a()
  {
    this.c.addTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
    c();
    b();
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    bfok.a(paramBundle, this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentIdiomHbFragment$IdiomHbBundleInfo);
    if (QLog.isColorLevel()) {
      QLog.i("IdiomHbFragment", 2, "bizParams:" + this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentIdiomHbFragment$IdiomHbBundleInfo.biz_params);
    }
    if (bfok.b.contains(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentIdiomHbFragment$IdiomHbBundleInfo.recv_type))
    {
      this.jdField_a_of_type_AndroidWidgetEditText.setText("1");
      this.jdField_a_of_type_AndroidViewView.findViewById(2131311829).setVisibility(8);
      this.jdField_a_of_type_AndroidViewView.findViewById(2131302902).setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      if ((!azzu.d()) && (!azzu.e())) {
        break label307;
      }
    }
    label307:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        this.c.setFilters(new InputFilter[] { new InputFilter.LengthFilter(4) });
      }
      if (QLog.isColorLevel())
      {
        QLog.i("IdiomHbFragment", 2, "isFlyMe: " + azzu.d() + " isMeizu:" + azzu.e());
        QLog.i("IdiomHbFragment", 2, "biz_params: " + this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentIdiomHbFragment$IdiomHbBundleInfo.biz_params);
      }
      return;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentIdiomHbFragment$IdiomHbBundleInfo.people_num)) {
        this.jdField_a_of_type_AndroidWidgetEditText.setHint(ajjy.a(2131639926) + this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentIdiomHbFragment$IdiomHbBundleInfo.people_num + ajjy.a(2131639930));
      }
      this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
      break;
    }
  }
  
  public boolean a()
  {
    if (super.a()) {
      if (!TextUtils.isEmpty(this.c.getText()))
      {
        String str = this.c.getText().toString().trim();
        this.jdField_a_of_type_JavaLangString = str;
        if ((str.length() == 4) && (agnz.a(this.jdField_a_of_type_JavaLangString) >= 4)) {}
      }
      else
      {
        this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
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
      d();
      return;
      this.mActivity.c("idiom.wrappacket.random");
      l = System.currentTimeMillis();
    } while (this.jdField_b_of_type_Long + 100L > l);
    this.jdField_b_of_type_Long = l;
    paramView = a(false);
    if (TextUtils.isEmpty(paramView))
    {
      if (!badq.g(this.mActivity))
      {
        this.c.setText(a(true));
        this.c.setSelection(this.c.getText().length());
        return;
      }
      a(new agmz(this));
      return;
    }
    this.c.setText(paramView);
    this.c.setSelection(this.c.getText().length());
  }
  
  protected void onLazyLoad()
  {
    super.onLazyLoad();
    this.jdField_a_of_type_Agjk = ((agjk)this.mQApp.getManager(125));
    if ((jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.isEmpty()) || (System.currentTimeMillis() - jdField_a_of_type_Long > 86400000L)) {
      a(null);
    }
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    super.setUserVisibleHint(paramBoolean);
    if (paramBoolean)
    {
      QLog.i("IdiomHbFragment", 2, "idiom enter...");
      if (this.mActivity != null) {
        this.mActivity.c("idiom.wrappacket.show");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.fragment.IdiomHbFragment
 * JD-Core Version:    0.7.0.1
 */