package com.tencent.mobileqq.activity.qwallet;

import aiqu;
import aiqv;
import aiqw;
import ajaf;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import bdcd;
import bdfq;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.QWalletHelper;

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
    localObject2 = ajaf.a((String)localObject1, getActivity(), new aiqu(this));
    if ((TextUtils.isEmpty((CharSequence)localObject2)) || (TextUtils.isEmpty(str2)) || (TextUtils.isEmpty((CharSequence)localObject1)) || (TextUtils.isEmpty(str1)))
    {
      a();
      return;
    }
    localObject1 = bdcd.a(getActivity(), 230, 2131561863, str2, (CharSequence)localObject2, 2131717931, 2131717930, new aiqv(this), new aiqw(this));
    ((bdfq)localObject1).setCancelable(false);
    ((bdfq)localObject1).setCanceledOnTouchOutside(false);
    ((bdfq)localObject1).show();
    paramView = (RelativeLayout)paramView.findViewById(2131374167);
    localObject1 = new ColorDrawable(-1);
    localObject2 = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = ((Drawable)localObject1);
    ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = ((Drawable)localObject1);
    paramView.setBackgroundDrawable(URLDrawable.getDrawable(str1, (URLDrawable.URLDrawableOptions)localObject2));
  }
  
  public void a()
  {
    QWalletHelper.launchQWalletAct(getActivity(), getActivity().app, false, false);
    getActivity().finish();
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2131561862, paramViewGroup, false);
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
      a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.QWalletPrivacyFragment
 * JD-Core Version:    0.7.0.1
 */