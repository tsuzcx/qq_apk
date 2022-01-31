package com.tencent.mobileqq.activity.qwallet.fragment;

import aitw;
import aixa;
import ajaf;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import bdje;
import bixy;
import biyf;
import com.tencent.mobileqq.activity.qwallet.SendHbActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class KSongFragment
  extends BaseHbUIFragment
  implements View.OnClickListener
{
  private long jdField_a_of_type_Long;
  private aixa jdField_a_of_type_Aixa;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private KSongFragment.KsongBundleInfo jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentKSongFragment$KsongBundleInfo = new KSongFragment.KsongBundleInfo();
  
  private void c()
  {
    try
    {
      if (!bdje.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentKSongFragment$KsongBundleInfo.biz_params))
      {
        JSONObject localJSONObject = new JSONObject(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentKSongFragment$KsongBundleInfo.biz_params);
        this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentKSongFragment$KsongBundleInfo.song_id = localJSONObject.optString("song_id");
        this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentKSongFragment$KsongBundleInfo.song_name = localJSONObject.optString("song_name");
        this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentKSongFragment$KsongBundleInfo.song_singer = localJSONObject.optString("song_singer");
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentKSongFragment$KsongBundleInfo.song_id))
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(String.format("%s %s", new Object[] { this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentKSongFragment$KsongBundleInfo.song_name, this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentKSongFragment$KsongBundleInfo.song_singer }));
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
        a();
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentKSongFragment$KsongBundleInfo.biz_params = null;
      return;
    }
    catch (Exception localException)
    {
      QLog.e("KSongFragment", 2, "setSongInfoOnControl throw an exception: " + localException);
    }
  }
  
  private void d()
  {
    long l = System.currentTimeMillis();
    if (this.jdField_a_of_type_Long + 1000L > l) {
      return;
    }
    this.jdField_a_of_type_Long = l;
    String str1 = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
    String str2 = this.b.getText().toString();
    Map localMap = this.mActivity.a();
    localMap.put("type", String.valueOf(1));
    localMap.put("wishing", this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentKSongFragment$KsongBundleInfo.song_name + "-" + this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentKSongFragment$KsongBundleInfo.song_singer);
    localMap.put("feedsid", this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentKSongFragment$KsongBundleInfo.song_id);
    localMap.put("bus_type", "2");
    localMap.put("total_num", str1);
    localMap.put("total_amount", bixy.a(str2));
    localMap.put("channel", "" + this.channel);
    this.mLogic.a(localMap);
  }
  
  public int a()
  {
    return 2131561711;
  }
  
  protected String a()
  {
    return "";
  }
  
  public void a()
  {
    b();
    this.jdField_a_of_type_Aixa = ((aixa)this.mQApp.getManager(273));
    this.jdField_a_of_type_Aixa.b("3001");
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    biyf.a(paramBundle, this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentKSongFragment$KsongBundleInfo);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131364271));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    ajaf.a(this.jdField_a_of_type_AndroidWidgetTextView, 0.6F);
    c();
    if (QLog.isColorLevel()) {
      QLog.i("KSongFragment", 2, "biz_params: " + this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentKSongFragment$KsongBundleInfo.biz_params);
    }
  }
  
  public boolean a()
  {
    if ((super.a()) && (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentKSongFragment$KsongBundleInfo.song_id == null)) {
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
    }
    return this.jdField_a_of_type_AndroidWidgetButton.isEnabled();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 16) && (paramInt2 == -1))
    {
      paramIntent = paramIntent.getStringExtra("h5arg");
      QLog.i("KSongFragment", 2, "h5call = " + paramIntent);
    }
    try
    {
      paramIntent = new JSONObject(paramIntent);
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentKSongFragment$KsongBundleInfo.song_id = paramIntent.optString("musicID");
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentKSongFragment$KsongBundleInfo.song_singer = paramIntent.optString("singer");
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentKSongFragment$KsongBundleInfo.song_name = paramIntent.optString("musicName");
      c();
      return;
    }
    catch (JSONException paramIntent)
    {
      paramIntent.printStackTrace();
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_Aixa.a("3001");
        this.mActivity.c("ksong.wrappacket.choosesong");
        if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentKSongFragment$KsongBundleInfo.pick_entry))
        {
          QLog.i("KSongFragment", 2, "error, url is null...");
          paramView = getHbPannelConfig(7);
          if (paramView == null) {
            break;
          }
          this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentKSongFragment$KsongBundleInfo.pick_entry = paramView.optString("pick_entry", "http://h5.qianbao.qq.com/ktvredpacket");
        }
        StringBuilder localStringBuilder = new StringBuilder().append("%s");
        if (!this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentKSongFragment$KsongBundleInfo.pick_entry.contains("?")) {
          break label249;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentKSongFragment$KsongBundleInfo.pick_entry.endsWith("?"))
        {
          paramView = "";
          paramView = paramView + "musicID=%s";
          if (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentKSongFragment$KsongBundleInfo.song_id != null) {
            break label202;
          }
          paramView = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentKSongFragment$KsongBundleInfo.pick_entry;
          openUrl(paramView);
          return;
        }
      }
      catch (Exception paramView)
      {
        paramView.printStackTrace();
        return;
      }
      paramView = "&";
      continue;
      label202:
      paramView = String.format(paramView, new Object[] { this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentKSongFragment$KsongBundleInfo.pick_entry, this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentKSongFragment$KsongBundleInfo.song_id });
      continue;
      this.mActivity.c("ksong.wrappacket.wrap");
      d();
      return;
      label249:
      paramView = "?";
    }
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    super.setUserVisibleHint(paramBoolean);
    if (paramBoolean)
    {
      QLog.i("KSongFragment", 2, "ksong enter...");
      if (this.mActivity != null) {
        this.mActivity.c("ksong.wrappacket.show");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.fragment.KSongFragment
 * JD-Core Version:    0.7.0.1
 */