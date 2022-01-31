package com.tencent.mobileqq.activity.qwallet.fragment;

import aixs;
import aiyb;
import aiyc;
import aiyd;
import aiye;
import aiyf;
import aiyl;
import aizd;
import ajeu;
import alud;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import bjcf;
import com.tencent.mobileqq.activity.qwallet.SendHbActivity;
import com.tencent.mobileqq.activity.qwallet.redpacket.draw.ChooseItemView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class LingHbFragment
  extends BaseHbUIFragment
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int = 5;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private ChooseItemView jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawChooseItemView;
  private List<String> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  private void d()
  {
    if (!b()) {}
    int i;
    String str1;
    String str2;
    do
    {
      return;
      i = bjcf.a(this.jdField_a_of_type_AndroidWidgetEditText.getText().toString(), 1);
      str1 = bjcf.a(String.valueOf(bjcf.a(this.b.getText().toString())));
      if (TextUtils.isEmpty(str1))
      {
        QQToast.a(getActivity(), 2131693361, 0).a();
        return;
      }
      str2 = c();
    } while (TextUtils.isEmpty(str2));
    combineUploadData(this.jdField_a_of_type_Bjcn, this.channel, i, str1, "hongbao.wrap.go");
    Map localMap = this.mActivity.a();
    localMap.put("channel", String.valueOf(this.channel));
    localMap.put("type", "1");
    localMap.put("wishing", str2);
    localMap.put("total_num", i + "");
    localMap.put("total_amount", str1);
    this.mLogic.a(localMap);
  }
  
  public int a()
  {
    return 2131561721;
  }
  
  protected String a()
  {
    if (32 == this.channel) {
      return alud.a(2131706498);
    }
    return alud.a(2131706497);
  }
  
  public void a()
  {
    super.a();
    c();
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(new aiyb(this));
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawChooseItemView.a(this.jdField_a_of_type_JavaUtilList, new aiyc(this), new aiyd(this), new aiye(this));
    this.c.setFocusable(true);
    this.c.setOnFocusChangeListener(new aiyf(this));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawChooseItemView);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawChooseItemView.getLayoutParams();
    localLayoutParams.width = -1;
    localLayoutParams.height = -2;
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    QLog.i("LingHbFragment", 2, "init view...");
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawChooseItemView = new ChooseItemView(this.mActivity);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131369213));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.c.addTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
    if (this.channel == 65536) {
      ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378835)).setText(2131693365);
    }
  }
  
  public boolean a()
  {
    if ((super.a()) && (TextUtils.isEmpty(b()))) {
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
    }
    return this.jdField_a_of_type_AndroidWidgetButton.isEnabled();
  }
  
  public String b()
  {
    return this.c.getText().toString();
  }
  
  public String c()
  {
    String str1 = b();
    if (65536 == this.channel)
    {
      if (aizd.a(str1) < 4)
      {
        QQToast.a(getActivity(), 2131697592, 0).a();
        return null;
      }
      String str2 = aizd.a(str1);
      if (str2.length() > 0)
      {
        QQToast.a(getActivity(), String.format(getString(2131697590), new Object[] { Character.valueOf(str2.charAt(0)) }), 0).a();
        return null;
      }
    }
    return str1;
  }
  
  public void c()
  {
    Object localObject = ((aixs)getActivity().app.getManager(245)).a("hb_recommend");
    for (;;)
    {
      int i;
      try
      {
        localObject = new JSONObject((String)localObject);
        JSONObject localJSONObject = ((JSONObject)localObject).optJSONObject("control");
        if (localJSONObject != null)
        {
          this.jdField_a_of_type_Int = localJSONObject.optInt("num_per_page", 5);
          if (this.jdField_a_of_type_Int <= 0) {
            this.jdField_a_of_type_Int = 5;
          }
        }
        long l1 = NetConnInfoCenter.getServerTimeMillis();
        localObject = ((JSONObject)localObject).optJSONArray("recommends");
        if (localObject != null)
        {
          i = 0;
          if (i < ((JSONArray)localObject).length())
          {
            localJSONObject = ((JSONArray)localObject).optJSONObject(i);
            if (localJSONObject == null) {
              break label315;
            }
            long l2 = ajeu.a(localJSONObject.optString("begintime"), -1L);
            long l3 = ajeu.a(localJSONObject.optString("endtime"), 9223372036854775807L);
            if ((l1 < l2) || (l1 > l3)) {
              break label315;
            }
            String str = localJSONObject.optString("text");
            int j = localJSONObject.optInt("flag", 0);
            if ((TextUtils.isEmpty(str)) || (str.length() > 18)) {
              break label315;
            }
            if (this.channel == 32)
            {
              if ((j & 0x1) != 0)
              {
                QLog.i("LingHbFragment", 2, "ling txt = " + str);
                this.jdField_a_of_type_JavaUtilList.add(str);
              }
            }
            else if ((j & 0x2) != 0)
            {
              QLog.i("LingHbFragment", 2, "ling voice = " + str);
              this.jdField_a_of_type_JavaUtilList.add(str);
            }
          }
        }
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
      }
      return;
      label315:
      i += 1;
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    d();
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    super.setUserVisibleHint(paramBoolean);
    if (paramBoolean) {
      addUploadData("hongbao.wrap.hopngbaokey", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.fragment.LingHbFragment
 * JD-Core Version:    0.7.0.1
 */