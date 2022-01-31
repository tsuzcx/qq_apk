package com.tencent.mobileqq.activity.qwallet;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.qwallet.utils.QWalletTools;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.QWalletHelper;
import wxm;
import wxn;
import wxo;

public class QWalletPrivacyFragment
  extends PublicBaseFragment
{
  private void a(View paramView)
  {
    String str2 = getArguments().getString("title", "");
    Object localObject2 = getArguments().getString("content", "");
    String str1 = getArguments().getString("background", "");
    if (QLog.isColorLevel()) {
      QLog.i("QWalletPrivacyFragment", 2, "onCreate:" + str2 + "|" + (String)localObject2 + "|" + str1);
    }
    Object localObject1 = localObject2;
    if (!TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = ((String)localObject2).replace("\\n", "\n");
    }
    localObject2 = QWalletTools.a((String)localObject1, getActivity(), new wxm(this));
    if ((TextUtils.isEmpty((CharSequence)localObject2)) || (TextUtils.isEmpty(str2)) || (TextUtils.isEmpty((CharSequence)localObject1)) || (TextUtils.isEmpty(str1)))
    {
      b();
      return;
    }
    localObject1 = DialogUtil.a(getActivity(), 230, 2130971000, str2, (CharSequence)localObject2, 2131432329, 2131432328, new wxn(this), new wxo(this));
    ((QQCustomDialog)localObject1).setCancelable(false);
    ((QQCustomDialog)localObject1).setCanceledOnTouchOutside(false);
    ((QQCustomDialog)localObject1).show();
    paramView = (RelativeLayout)paramView.findViewById(2131372558);
    localObject1 = new ColorDrawable(-1);
    localObject2 = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = ((Drawable)localObject1);
    ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = ((Drawable)localObject1);
    paramView.setBackgroundDrawable(URLDrawable.getDrawable(str1, (URLDrawable.URLDrawableOptions)localObject2));
  }
  
  public void b()
  {
    QWalletHelper.launchQWalletAct(getActivity(), getActivity().app, false);
    getActivity().finish();
  }
  
  public boolean b()
  {
    return false;
  }
  
  public boolean c()
  {
    return false;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130970999, paramViewGroup, false);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    QWalletHelper.preloadQWallet(getActivity().app, 0, "qwallet_default");
    try
    {
      a(paramView);
      return;
    }
    catch (Throwable paramView)
    {
      paramView.printStackTrace();
      b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.QWalletPrivacyFragment
 * JD-Core Version:    0.7.0.1
 */