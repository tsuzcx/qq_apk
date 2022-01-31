package com.tencent.mobileqq.activity.qwallet.fragment;

import agnm;
import agnw;
import agoa;
import agod;
import ajjy;
import ajkz;
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
import baip;
import bbmy;
import bfod;
import bfol;
import com.tencent.mobileqq.activity.qwallet.SendHbActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Map;

public class UsualHbFragment
  extends BaseHbUIFragment
  implements View.OnClickListener
{
  private static final List<Integer> jdField_a_of_type_JavaUtilList = new UsualHbFragment.1();
  private agod jdField_a_of_type_Agod;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  
  private void c()
  {
    if (!b()) {
      return;
    }
    int i = bfod.a(this.jdField_a_of_type_AndroidWidgetEditText.getText().toString(), 1);
    String str = bfod.a(String.valueOf(a()));
    if (TextUtils.isEmpty(str))
    {
      bbmy.a(getActivity(), 2131627617, 0).a();
      return;
    }
    combineUploadData(this.jdField_a_of_type_Bfol, b(), i, str, "hongbao.wrap.go");
    Object localObject2 = this.c.getText().toString();
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      if (TextUtils.isEmpty(this.c.getHint())) {
        localObject1 = getResources().getString(2131631385);
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
      if (!this.jdField_a_of_type_Agod.a()) {
        break label325;
      }
      ((Map)localObject2).put("skin_id", "" + agoa.c);
    }
    for (;;)
    {
      this.mLogic.a((Map)localObject2);
      return;
      localObject1 = this.c.getHint().toString();
      break;
      label325:
      ((Map)localObject2).put("skin_id", "" + this.jdField_a_of_type_Agod.a());
    }
  }
  
  protected float a()
  {
    float f2 = bfod.a(this.b.getText().toString());
    float f1 = f2;
    if (bfod.a(this.jdField_a_of_type_Bfol.bus_type, 1) == 1) {
      f1 = f2 * bfod.a(this.jdField_a_of_type_AndroidWidgetEditText.getText().toString(), 0);
    }
    return f1;
  }
  
  public int a()
  {
    return 2131495926;
  }
  
  protected String a()
  {
    return ajjy.a(2131650184);
  }
  
  public void a()
  {
    super.a();
    Object localObject;
    if (jdField_a_of_type_JavaUtilList.contains(Integer.valueOf(this.channel)))
    {
      localObject = this.bundle.getString("skin_id", "");
      if (!baip.a((String)localObject)) {
        break label162;
      }
    }
    label162:
    for (int i = this.bundle.getInt("skin_id", -1);; i = bfod.a(localObject, -1))
    {
      QLog.i("UsualHbFragment", 2, "init data skin id: " + i);
      localObject = this.jdField_a_of_type_Agod;
      LinearLayout localLinearLayout = (LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131301691);
      this.jdField_a_of_type_AndroidWidgetLinearLayout = localLinearLayout;
      ((agod)localObject).a(localLinearLayout);
      ((ViewGroup)this.jdField_a_of_type_AndroidWidgetLinearLayout.getParent()).setVisibility(0);
      if (-1 != i) {
        this.jdField_a_of_type_Agod.a(i);
      }
      this.jdField_a_of_type_Agod.a(new agnw(this));
      this.jdField_a_of_type_Agod.a(this.bundle);
      return;
    }
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    QLog.i("UsualHbFragment", 2, "init view...");
    this.jdField_a_of_type_Agod = this.mActivity.a();
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131297511));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    paramBundle = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131312381);
    if (String.valueOf(2).equals(this.jdField_a_of_type_Bfol.bus_type))
    {
      paramBundle.setText(2131631342);
      return;
    }
    paramBundle.setText(2131631343);
  }
  
  public int b()
  {
    if ((jdField_a_of_type_JavaUtilList.contains(Integer.valueOf(this.channel))) && (this.jdField_a_of_type_Agod.a() == -2)) {
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
    case 2131299051: 
      c();
      return;
    }
    addUploadData("hongbao.wrap.vip", "");
    if (512 == this.channel)
    {
      openUrl("https://h5.qzone.qq.com/redpacket/skin/index?_proxy=1&_wv=16777219&feedsid=" + this.bundle.getString("feedsid"));
      return;
    }
    openUrl(ajkz.a(3, (QQAppInterface)this.mActivity.getAppRuntime()));
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    if (jdField_a_of_type_JavaUtilList.contains(Integer.valueOf(this.channel))) {
      this.jdField_a_of_type_Agod.a(this.jdField_a_of_type_AndroidWidgetLinearLayout);
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (jdField_a_of_type_JavaUtilList.contains(Integer.valueOf(this.channel))) {
      this.jdField_a_of_type_Agod.c();
    }
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    super.setUserVisibleHint(paramBoolean);
    if (paramBoolean)
    {
      if (String.valueOf(2).equals(this.jdField_a_of_type_Bfol.bus_type)) {
        addUploadData("hongbao.wrap.random", "");
      }
    }
    else {
      return;
    }
    addUploadData("hongbao.wrap.identical", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.fragment.UsualHbFragment
 * JD-Core Version:    0.7.0.1
 */