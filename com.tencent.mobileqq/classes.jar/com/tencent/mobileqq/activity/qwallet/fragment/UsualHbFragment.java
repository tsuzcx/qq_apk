package com.tencent.mobileqq.activity.qwallet.fragment;

import aiyl;
import aiyv;
import aize;
import aizh;
import alud;
import alvg;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import bdnn;
import bjcf;
import bjcn;
import com.tencent.mobileqq.activity.qwallet.SendHbActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Map;

public class UsualHbFragment
  extends BaseHbUIFragment
  implements View.OnClickListener
{
  private static final List<Integer> jdField_a_of_type_JavaUtilList = new UsualHbFragment.1();
  private aizh jdField_a_of_type_Aizh;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  
  private void c()
  {
    if (!b()) {
      return;
    }
    int i = bjcf.a(this.jdField_a_of_type_AndroidWidgetEditText.getText().toString(), 1);
    String str = bjcf.a(String.valueOf(a()));
    if (TextUtils.isEmpty(str))
    {
      QQToast.a(getActivity(), 2131693361, 0).a();
      return;
    }
    combineUploadData(this.jdField_a_of_type_Bjcn, b(), i, str, "hongbao.wrap.go");
    Object localObject2 = this.c.getText().toString();
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      if (TextUtils.isEmpty(this.c.getHint())) {
        localObject1 = getResources().getString(2131697275);
      }
    }
    else
    {
      int j = b();
      localObject2 = this.mActivity.a();
      ((Map)localObject2).put("channel", String.valueOf(j));
      ((Map)localObject2).put("type", "1");
      ((Map)localObject2).put("wishing", localObject1);
      ((Map)localObject2).put("bus_type", this.bundle.getString("bus_type"));
      ((Map)localObject2).put("total_num", i + "");
      ((Map)localObject2).put("total_amount", str);
      if (512 == j) {
        ((Map)localObject2).put("feeds_sid", this.bundle.getString("feedsid"));
      }
      if (!this.jdField_a_of_type_Aizh.a()) {
        break label325;
      }
      ((Map)localObject2).put("skin_id", "" + aize.c);
    }
    for (;;)
    {
      this.mLogic.a((Map)localObject2);
      return;
      localObject1 = this.c.getHint().toString();
      break;
      label325:
      ((Map)localObject2).put("skin_id", "" + this.jdField_a_of_type_Aizh.a());
    }
  }
  
  protected float a()
  {
    float f2 = bjcf.a(this.b.getText().toString());
    float f1 = f2;
    if (bjcf.a(this.jdField_a_of_type_Bjcn.bus_type, 1) == 1) {
      f1 = f2 * bjcf.a(this.jdField_a_of_type_AndroidWidgetEditText.getText().toString(), 0);
    }
    return f1;
  }
  
  public int a()
  {
    return 2131561726;
  }
  
  protected String a()
  {
    return alud.a(2131716370);
  }
  
  public void a()
  {
    super.a();
    Object localObject;
    if (jdField_a_of_type_JavaUtilList.contains(Integer.valueOf(this.channel)))
    {
      localObject = this.bundle.getString("skin_id", "");
      if (!bdnn.a((String)localObject)) {
        break label162;
      }
    }
    label162:
    for (int i = this.bundle.getInt("skin_id", -1);; i = bjcf.a(localObject, -1))
    {
      QLog.i("UsualHbFragment", 2, "init data skin id: " + i);
      localObject = this.jdField_a_of_type_Aizh;
      LinearLayout localLinearLayout = (LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131367443);
      this.jdField_a_of_type_AndroidWidgetLinearLayout = localLinearLayout;
      ((aizh)localObject).a(localLinearLayout);
      ((ViewGroup)this.jdField_a_of_type_AndroidWidgetLinearLayout.getParent()).setVisibility(0);
      if (-1 != i) {
        this.jdField_a_of_type_Aizh.a(i);
      }
      this.jdField_a_of_type_Aizh.a(new aiyv(this));
      this.jdField_a_of_type_Aizh.a(this.bundle);
      return;
    }
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    QLog.i("UsualHbFragment", 2, "init view...");
    this.jdField_a_of_type_Aizh = this.mActivity.a();
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131363087));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    paramBundle = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378832);
    if (String.valueOf(2).equals(this.jdField_a_of_type_Bjcn.bus_type))
    {
      paramBundle.setText(2131697232);
      return;
    }
    paramBundle.setText(2131697233);
  }
  
  public int b()
  {
    if ((jdField_a_of_type_JavaUtilList.contains(Integer.valueOf(this.channel))) && (this.jdField_a_of_type_Aizh.a() == -2)) {
      return 8;
    }
    return this.channel;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131364689: 
      c();
      return;
    }
    addUploadData("hongbao.wrap.vip", "");
    if (512 == this.channel)
    {
      openUrl("https://h5.qzone.qq.com/redpacket/skin/index?_proxy=1&_wv=16777219&feedsid=" + this.bundle.getString("feedsid"));
      return;
    }
    openUrl(alvg.a(3, (QQAppInterface)this.mActivity.getAppRuntime()));
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    if (jdField_a_of_type_JavaUtilList.contains(Integer.valueOf(this.channel))) {
      this.jdField_a_of_type_Aizh.a(this.jdField_a_of_type_AndroidWidgetLinearLayout);
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (jdField_a_of_type_JavaUtilList.contains(Integer.valueOf(this.channel))) {
      this.jdField_a_of_type_Aizh.c();
    }
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    super.setUserVisibleHint(paramBoolean);
    if (paramBoolean)
    {
      if (String.valueOf(2).equals(this.jdField_a_of_type_Bjcn.bus_type)) {
        addUploadData("hongbao.wrap.random", "");
      }
    }
    else {
      return;
    }
    addUploadData("hongbao.wrap.identical", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.fragment.UsualHbFragment
 * JD-Core Version:    0.7.0.1
 */