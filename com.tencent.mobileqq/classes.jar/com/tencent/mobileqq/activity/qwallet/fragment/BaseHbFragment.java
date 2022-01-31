package com.tencent.mobileqq.activity.qwallet.fragment;

import agmq;
import agnm;
import agwj;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import baip;
import bfol;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.qwallet.SendHbActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONObject;

public abstract class BaseHbFragment
  extends Fragment
{
  private static final String TAG = "BaseHbFragment";
  protected Bundle bundle;
  public int channel;
  protected boolean isUIVisible;
  protected boolean isViewCreated;
  public SendHbActivity mActivity;
  protected agnm mLogic;
  protected QQAppInterface mQApp;
  
  public static JSONObject getHbPannelConfig(int paramInt)
  {
    Object localObject1 = null;
    Object localObject3 = null;
    Object localObject2 = agwj.a();
    agmq localagmq1;
    if (localObject2 != null)
    {
      agmq localagmq2 = (agmq)((QQAppInterface)localObject2).getManager(245);
      JSONArray localJSONArray = localagmq2.a("redPackPanel", new String[] { "panelRedPkgList" });
      localagmq1 = localagmq2;
      localObject2 = localObject1;
      if (localJSONArray != null)
      {
        localagmq1 = localagmq2;
        localObject2 = localObject1;
        if (localJSONArray.length() > 0)
        {
          int i = 0;
          localObject1 = localObject3;
          localagmq1 = localagmq2;
          localObject2 = localObject1;
          if (i < localJSONArray.length())
          {
            localObject2 = localJSONArray.getJSONObject(i);
            if (localObject2 == null) {}
            for (;;)
            {
              i += 1;
              break;
              if (((JSONObject)localObject2).optInt("type", -1) == paramInt) {
                localObject1 = ((JSONObject)localObject2).optJSONObject("params");
              }
            }
          }
        }
      }
    }
    else
    {
      localagmq1 = null;
      localObject2 = localObject1;
    }
    if ((localObject2 == null) && (localagmq1 != null)) {
      localagmq1.b(0);
    }
    return localObject2;
  }
  
  private void lazyLoad()
  {
    if ((this.isViewCreated) && (this.isUIVisible)) {
      this.isViewCreated = false;
    }
    try
    {
      onLazyLoad();
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("BaseHbFragment", 1, localThrowable, new Object[0]);
    }
  }
  
  private void preInitParams()
  {
    this.bundle = getArguments();
    String str = this.bundle.getString("channel", String.valueOf(1));
    try
    {
      this.channel = Integer.valueOf(str).intValue();
      label33:
      QLog.i("BaseHbFragment", 2, "base params channel = " + str + " : " + this.channel);
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      break label33;
    }
  }
  
  public void addUploadData(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (this.mActivity != null) && (!this.mActivity.isFinishing())) {
      this.mActivity.a(paramString1, paramString2, 2);
    }
  }
  
  public boolean checkCount(String paramString)
  {
    if (baip.a(paramString)) {}
    do
    {
      return false;
      if ((paramString.indexOf('.') <= 0) || (paramString.indexOf('.') >= paramString.length() - 3)) {
        break;
      }
      paramString = getString(2131631357);
    } while (this.mActivity == null);
    this.mActivity.c(paramString);
    return false;
    return true;
  }
  
  protected void combineUploadData(bfol parambfol, int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    try
    {
      StringBuffer localStringBuffer = new StringBuffer();
      localStringBuffer.append("number#");
      localStringBuffer.append(paramInt2);
      localStringBuffer.append(",type#");
      if (("1".equals(parambfol.recv_type)) || ("7".equals(parambfol.recv_type)) || ("4".equals(parambfol.recv_type)) || ("5".equals(parambfol.recv_type))) {
        localStringBuffer.append("person");
      }
      for (;;)
      {
        localStringBuffer.append(",channel#");
        localStringBuffer.append(paramInt1);
        localStringBuffer.append(",money#");
        localStringBuffer.append(paramString1);
        addUploadData(paramString2, localStringBuffer.toString());
        return;
        if ("2".equals(parambfol.recv_type)) {
          localStringBuffer.append("crowd");
        } else {
          localStringBuffer.append("group");
        }
      }
      return;
    }
    catch (Throwable parambfol) {}
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    QLog.i("BaseHbFragment", 2, "onCreateView: " + getClass().getSimpleName());
    SendHbActivity localSendHbActivity = (SendHbActivity)getActivity();
    this.mActivity = localSendHbActivity;
    this.mLogic = new agnm(localSendHbActivity);
    this.mQApp = ((QQAppInterface)this.mActivity.getAppRuntime());
    this.mActivity.getWindow().setSoftInputMode(19);
    preInitParams();
    return super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
  }
  
  protected void onLazyLoad()
  {
    if (QLog.isColorLevel()) {
      QLog.i("BaseHbFragment", 2, "onLazyLoad: " + getClass().getSimpleName());
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.isViewCreated = true;
    lazyLoad();
  }
  
  public void openUrl(String paramString)
  {
    QLog.i("BaseHbFragment", 2, "openUrl = " + paramString);
    Intent localIntent = new Intent();
    localIntent.setClass(getActivity(), QQBrowserActivity.class);
    localIntent.putExtra("url", paramString);
    localIntent.putExtra("hide_operation_bar", true);
    localIntent.putExtra("hide_more_button", true);
    localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
    getActivity().startActivityForResult(localIntent, 16);
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    super.setUserVisibleHint(paramBoolean);
    if (QLog.isColorLevel()) {
      QLog.i("BaseHbFragment", 2, "setUserVisibleHint: " + paramBoolean + " " + getClass().getSimpleName());
    }
    this.isUIVisible = paramBoolean;
    lazyLoad();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.fragment.BaseHbFragment
 * JD-Core Version:    0.7.0.1
 */