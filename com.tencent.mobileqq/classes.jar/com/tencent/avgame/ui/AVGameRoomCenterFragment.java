package com.tencent.avgame.ui;

import ampt;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import apub;
import bcef;
import com.dataline.util.widget.AsyncImageView;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.FaceDecoder;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import mxn;
import mxx;
import mya;
import myv;
import myw;
import myx;
import mza;
import mzb;
import mzd;
import mze;
import mzf;
import mzi;
import nig;
import nih;
import nii;
import nij;
import nik;
import nji;

public class AVGameRoomCenterFragment
  extends PublicBaseFragment
{
  public static final String a;
  private FragmentActivity jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private mya jdField_a_of_type_Mya = new nii(this);
  private myw jdField_a_of_type_Myw;
  private mzd jdField_a_of_type_Mzd;
  private mzf jdField_a_of_type_Mzf;
  private mzi jdField_a_of_type_Mzi = new nij(this);
  private boolean jdField_a_of_type_Boolean;
  private mzi b = new nik(this);
  
  static
  {
    jdField_a_of_type_JavaLangString = AVGameRoomCenterFragment.class.getName();
  }
  
  private void e()
  {
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.addObserver(this.jdField_a_of_type_Mya);
    ((mxx)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getBusinessHandler(178)).b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getLongAccountUin());
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "initData start");
    }
  }
  
  private void f()
  {
    this.jdField_a_of_type_Myw = new myw();
    this.jdField_a_of_type_Myw.a();
    mze localmze = new mze();
    this.jdField_a_of_type_Mzf = new mzf(this.jdField_a_of_type_Mzd);
    this.jdField_a_of_type_Mzf.a(this.jdField_a_of_type_Myw);
    this.jdField_a_of_type_Mzf.a(localmze);
    this.jdField_a_of_type_Mzf.a(myv.jdField_a_of_type_JavaLangString, 2131558730, mza.class);
    this.jdField_a_of_type_Mzf.a(2131558730, this.jdField_a_of_type_Mzi);
    this.jdField_a_of_type_Mzf.a(myx.jdField_a_of_type_JavaLangString, 2131558731, mzb.class);
    this.jdField_a_of_type_Mzf.a(2131558731, this.b);
  }
  
  public void a()
  {
    bcef.b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app, "dc00898", "", "", "0X800B013", "0X800B013", 0, 0, "", "", "", "");
    mxn localmxn = (mxn)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getManager(373);
    if ((localmxn != null) && (!TextUtils.isEmpty(localmxn.a())))
    {
      localmxn.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 4, localmxn.a(), null);
      return;
    }
    QQToast.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 2, 2131690396, 0).a();
  }
  
  public void b()
  {
    bcef.b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app, "dc00898", "", "", "0X800B011", "0X800B011", 0, 0, "", "", "", "");
    mxn localmxn = (mxn)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getManager(373);
    if (localmxn != null)
    {
      localmxn.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 8, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getCurrentAccountUin(), 0);
      return;
    }
    QQToast.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 2, 2131690395, 0).a();
  }
  
  public void c()
  {
    bcef.b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app, "dc00898", "", "", "0X800B012", "0X800B012", 0, 0, "", "", "", "");
    mxn localmxn = (mxn)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getManager(373);
    if ((localmxn != null) && (localmxn.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity))) {
      return;
    }
    AVGameJoinRoomFragment.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, null);
  }
  
  public void d()
  {
    mxn localmxn = (mxn)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getManager(373);
    if (localmxn != null) {
      if (!localmxn.a()) {
        break label71;
      }
    }
    label71:
    for (int i = 1;; i = 2)
    {
      bcef.b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app, "dc00898", "", "", "0X800B493", "0X800B493", i, 0, "", "", "", "");
      localmxn.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 9);
      return;
    }
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public boolean needStatusTrans()
  {
    return true;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = getActivity();
    this.jdField_a_of_type_Mzd = new mzd();
    this.jdField_a_of_type_Mzd.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app);
    this.jdField_a_of_type_Mzd.a(new FaceDecoder(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app));
    paramBundle = (nji)apub.a().a(642);
    this.jdField_a_of_type_Boolean = paramBundle.b();
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "avGameConfBean:" + paramBundle.toString() + "  avGameConfBean.isStrangerMatchShow：" + paramBundle.b());
    }
    myx.a(this.jdField_a_of_type_Boolean);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    e();
    f();
    paramViewGroup = paramLayoutInflater.inflate(2131558717, paramViewGroup, false);
    if (ImmersiveUtils.c()) {
      ImmersiveUtils.a(false, getActivity().getWindow());
    }
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      paramBundle = (RelativeLayout)paramViewGroup.findViewById(2131363200);
      ((RelativeLayout.LayoutParams)paramBundle.getLayoutParams()).height = (ImmersiveUtils.getStatusBarHeight(paramLayoutInflater.getContext()) + AIOUtils.dp2px(44.0F, getResources()));
      paramBundle.setPadding(0, ImmersiveUtils.getStatusBarHeight(paramLayoutInflater.getContext()), 0, 0);
    }
    paramLayoutInflater = (RecyclerView)paramViewGroup.findViewById(2131363199);
    paramLayoutInflater.setLayoutManager(new LinearLayoutManager(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity));
    paramLayoutInflater.setAdapter(this.jdField_a_of_type_Mzf);
    this.jdField_a_of_type_Mzf.notifyDataSetChanged();
    paramLayoutInflater = (AsyncImageView)paramViewGroup.findViewById(2131363189);
    paramLayoutInflater.setDefaultColorDrawable(0);
    paramLayoutInflater.setAsyncImage("https://static-res.qq.com/static-res/avgames/strangerMatch/avgame_lobby_bg2.png");
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131363188));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new nig(this));
    float f = getActivity().getResources().getDisplayMetrics().density;
    AIOUtils.expandViewTouchDelegate(this.jdField_a_of_type_AndroidWidgetTextView, (int)(5.0F * f + 0.5F), (int)(5.0F * f + 0.5F), (int)(5.0F * f + 0.5F), (int)(f * 5.0F + 0.5F));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131363187));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new nih(this));
    mxn.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app);
    bcef.b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app, "dc00898", "", "", "0X800B49D", "0X800B49D", 0, 0, "", "", "", "");
    if (this.jdField_a_of_type_Boolean) {
      bcef.b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app, "dc00898", "", "", "0X800B49E", "0X800B49E", 0, 0, "", "", "", "");
    }
    ((ampt)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getBusinessHandler(4)).c();
    V4FragmentCollector.onV4FragmentViewCreated(this, paramViewGroup);
    return paramViewGroup;
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity != null) {
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.removeObserver(this.jdField_a_of_type_Mya);
    }
    if (this.jdField_a_of_type_Mzd != null) {
      this.jdField_a_of_type_Mzd.a();
    }
    super.onDestroy();
  }
  
  public void onPause()
  {
    super.onPause();
    ApngImage.pauseAll();
  }
  
  public void onResume()
  {
    super.onResume();
    ApngImage.resumeAll();
    mxn localmxn = (mxn)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getManager(373);
    if ((localmxn != null) && (localmxn.a()))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.ui.AVGameRoomCenterFragment
 * JD-Core Version:    0.7.0.1
 */