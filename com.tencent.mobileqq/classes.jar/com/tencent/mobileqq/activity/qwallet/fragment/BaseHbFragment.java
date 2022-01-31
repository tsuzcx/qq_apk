package com.tencent.mobileqq.activity.qwallet.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.tencent.mobileqq.activity.qwallet.SendHbActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

public abstract class BaseHbFragment
  extends Fragment
{
  public SendHbActivity a;
  protected BaseHbFragment.HBConfig a;
  public SendHbLogic a;
  protected QQAppInterface a;
  
  public static Map a(Map paramMap, JSONObject paramJSONObject)
  {
    Object localObject = paramMap;
    if (paramMap == null) {
      localObject = new HashMap();
    }
    if (paramJSONObject != null)
    {
      paramMap = paramJSONObject.keys();
      while (paramMap.hasNext())
      {
        String str = (String)paramMap.next();
        ((Map)localObject).put(str, paramJSONObject.optString(str));
      }
    }
    return localObject;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    SendHbActivity localSendHbActivity = (SendHbActivity)getActivity();
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletSendHbActivity = localSendHbActivity;
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentSendHbLogic = new SendHbLogic(localSendHbActivity);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.jdField_a_of_type_ComTencentMobileqqActivityQwalletSendHbActivity.getAppRuntime());
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletSendHbActivity.getWindow().setSoftInputMode(19);
    return super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.fragment.BaseHbFragment
 * JD-Core Version:    0.7.0.1
 */