package com.tencent.biz.pubaccount.readinjoy.activity;

import amtj;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.manager.TicketManager;
import ond;
import onf;
import pay;
import pim;
import rrm;
import rrn;

public class ReadInJoyUploadAvatarFragment
  extends IphoneTitleBarFragment
{
  public static String a;
  protected ProgressDialog a;
  protected Handler a;
  rrm a;
  
  static
  {
    jdField_a_of_type_JavaLangString = "ReadInJoyUploadAvatarFragment";
  }
  
  public ReadInJoyUploadAvatarFragment()
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    this.jdField_a_of_type_Rrm = new onf(this);
  }
  
  private void a(String paramString)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)pay.a();
    new rrn(BaseApplicationImpl.getContext(), localQQAppInterface, this.jdField_a_of_type_Rrm).a(paramString, true, 2);
  }
  
  private void a(String paramString, Handler paramHandler, int paramInt)
  {
    Bundle localBundle = new Bundle();
    Object localObject1 = getActivity();
    if ((localObject1 == null) || (((FragmentActivity)localObject1).app == null)) {
      return;
    }
    Object localObject2 = ((FragmentActivity)localObject1).app;
    TicketManager localTicketManager = (TicketManager)((QQAppInterface)localObject2).getManager(2);
    localObject1 = ((QQAppInterface)localObject2).getCurrentAccountUin();
    localObject2 = localTicketManager.getSkey(((QQAppInterface)localObject2).getCurrentAccountUin());
    localBundle.putString("Cookie", "uin=o" + (String)localObject1 + ";skey=" + (String)localObject2);
    localBundle.putString("bkn", "" + TroopUtils.getBknBySkey((String)localObject2));
    localBundle.putString("dataType", "base64");
    localBundle.putString("type", "" + paramInt);
    ThreadManager.executeOnSubThread(new ReadInJoyUploadAvatarFragment.3(this, paramString, localBundle, paramHandler));
  }
  
  protected void a(int paramInt1, String paramString, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      a(paramString, new ond(this, Looper.getMainLooper()), paramInt2);
    }
    for (;;)
    {
      QLog.d(jdField_a_of_type_JavaLangString, 1, "uploadFile: from:" + paramInt1 + " paths:" + paramString);
      return;
      a(paramString);
    }
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    setTitle(amtj.a(2131711998), amtj.a(2131711998));
    setLeftViewName(2131694413);
    paramLayoutInflater = getActivity();
    if (paramLayoutInflater == null) {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "doOnCreateView activity = null");
    }
    int i;
    int j;
    do
    {
      return;
      pim.a.a(getActivity());
      this.jdField_a_of_type_AndroidOsHandler.post(new ReadInJoyUploadAvatarFragment.1(this, paramLayoutInflater));
      paramViewGroup = paramLayoutInflater.getIntent();
      paramBundle = paramViewGroup.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
      i = paramViewGroup.getIntExtra("from", 0);
      if ((paramBundle == null) || (paramBundle.isEmpty()))
      {
        Intent localIntent = paramLayoutInflater.getIntent();
        Bundle localBundle = new Bundle();
        localBundle.putInt("retCode", 2);
        localBundle.putString("msg", amtj.a(2131711979));
        localIntent.putExtra("Bundle", localBundle);
        paramLayoutInflater.setResult(-1, localIntent);
        paramLayoutInflater.finish();
      }
      j = paramViewGroup.getIntExtra("type", 1);
    } while ((paramBundle == null) || (paramBundle.size() <= 0));
    a(i, (String)paramBundle.get(0), j);
  }
  
  public int getContentLayoutId()
  {
    return 2131560307;
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    super.initWindowStyleAndAnimation(paramActivity);
    paramActivity.overridePendingTransition(0, 0);
  }
  
  public boolean isTransparent()
  {
    return true;
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    if (this.jdField_a_of_type_AndroidAppProgressDialog != null) {
      this.jdField_a_of_type_AndroidAppProgressDialog.dismiss();
    }
  }
  
  public void onFinish()
  {
    super.onFinish();
    FragmentActivity localFragmentActivity = getActivity();
    if (localFragmentActivity != null) {
      localFragmentActivity.overridePendingTransition(0, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyUploadAvatarFragment
 * JD-Core Version:    0.7.0.1
 */