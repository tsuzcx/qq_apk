package com.tencent.avgame.ui;

import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build;
import android.os.Build.VERSION;
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
import ansg;
import aqxe;
import bdla;
import bhdj;
import bisl;
import com.dataline.util.widget.AsyncImageView;
import com.tencent.common.config.AppSetting;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import ncz;
import ndj;
import ndm;
import neh;
import nei;
import nej;
import nek;
import neo;
import ner;
import net;
import neu;
import nev;
import ney;
import nob;
import noz;
import npa;
import npb;
import npc;
import npe;
import npf;
import npg;
import nqg;

public class AVGameRoomCenterFragment
  extends PublicBaseFragment
{
  public static final String a;
  private FragmentActivity jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bisl jdField_a_of_type_Bisl;
  private ndm jdField_a_of_type_Ndm = new npc(this);
  private nei jdField_a_of_type_Nei;
  private neu jdField_a_of_type_Neu;
  private nev jdField_a_of_type_Nev;
  private ney jdField_a_of_type_Ney = new npe(this);
  private boolean jdField_a_of_type_Boolean;
  private ney jdField_b_of_type_Ney = new npf(this);
  private boolean jdField_b_of_type_Boolean;
  private ney c = new npg(this);
  
  static
  {
    jdField_a_of_type_JavaLangString = AVGameRoomCenterFragment.class.getName();
  }
  
  private String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramString);
    localStringBuilder.append("&manufacture=").append(Build.MANUFACTURER);
    paramString = Build.MODEL;
    if (paramString != null) {}
    for (paramString = paramString.replaceAll(" ", "_");; paramString = "")
    {
      localStringBuilder.append("&model=").append(paramString);
      localStringBuilder.append("&version=").append(Build.VERSION.SDK_INT);
      localStringBuilder.append("&appid=").append(AppSetting.a());
      paramString = localStringBuilder.toString();
      if (QLog.isColorLevel()) {
        QLog.i(jdField_a_of_type_JavaLangString, 2, "feedback jumpUrl=" + paramString);
      }
      return paramString;
    }
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    ((ndj)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getBusinessHandler(BusinessHandlerFactory.AV_GAME_HANDLER)).a(paramInt, paramBoolean);
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "reservePKGame start");
    }
  }
  
  private void a(String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener1, String paramString4, DialogInterface.OnClickListener paramOnClickListener2)
  {
    QQCustomDialog localQQCustomDialog = bhdj.a(getActivity(), 230);
    localQQCustomDialog.setTitle(paramString1);
    localQQCustomDialog.setMessage(paramString2);
    localQQCustomDialog.setCancelable(false);
    localQQCustomDialog.setNegativeButton(paramString3, paramOnClickListener1);
    localQQCustomDialog.setPositiveButton(paramString4, paramOnClickListener2);
    localQQCustomDialog.show();
  }
  
  private void e()
  {
    bdla.b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app, "dc00898", "", "", "0X800B694", "0X800B694", 0, 0, "", "", "", "");
    Intent localIntent = new Intent(getActivity(), QQBrowserActivity.class);
    localIntent.putExtra("url", a("https://ti.qq.com/tucao/index.html?productId=280793&_wv=1"));
    getActivity().startActivity(localIntent);
  }
  
  private void f()
  {
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.addObserver(this.jdField_a_of_type_Ndm);
    ((ndj)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getBusinessHandler(BusinessHandlerFactory.AV_GAME_HANDLER)).b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getLongAccountUin());
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "initData start");
    }
  }
  
  private void g()
  {
    this.jdField_a_of_type_Nei = new nei();
    this.jdField_a_of_type_Nei.a();
    this.jdField_a_of_type_Nev = new nev(this.jdField_a_of_type_Neu);
    this.jdField_a_of_type_Nev.a(this.jdField_a_of_type_Nei);
    this.jdField_a_of_type_Nev.a(neh.jdField_a_of_type_JavaLangString, 2131558744, new neo());
    this.jdField_a_of_type_Nev.a(2131558744, this.jdField_a_of_type_Ney);
    this.jdField_a_of_type_Nev.a(nej.jdField_a_of_type_JavaLangString, 2131558745, new ner());
    this.jdField_a_of_type_Nev.a(2131558745, this.jdField_b_of_type_Ney);
    this.jdField_a_of_type_Nev.a(nek.jdField_a_of_type_JavaLangString, 2131558746, new net());
    this.jdField_a_of_type_Nev.a(2131558746, this.c);
  }
  
  private void h()
  {
    if (this.jdField_a_of_type_Bisl == null) {
      this.jdField_a_of_type_Bisl = new bisl(getActivity());
    }
    this.jdField_a_of_type_Bisl.c(2131690410);
    if (this.jdField_a_of_type_Bisl.isShowing()) {
      this.jdField_a_of_type_Bisl.dismiss();
    }
    this.jdField_a_of_type_Bisl.show();
  }
  
  public void a()
  {
    bdla.b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app, "dc00898", "", "", "0X800B013", "0X800B013", 0, 0, "", "", "", "");
    ncz localncz = (ncz)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getManager(QQManagerFactory.AV_GAME_MANAGER);
    if ((localncz != null) && (!TextUtils.isEmpty(localncz.a())))
    {
      localncz.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 4, localncz.a(), null);
      return;
    }
    if (localncz.b())
    {
      AvGameLoadingActivity.a(false, getActivity(), null, null, null, "", false, true, null);
      return;
    }
    QQToast.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 2, 2131690468, 0).a();
  }
  
  public void a(int paramInt)
  {
    bdla.b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app, "dc00898", "", "", "0X800B691", "0X800B691", 0, 0, "", "", "", "");
    ncz localncz = (ncz)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getManager(QQManagerFactory.AV_GAME_MANAGER);
    if (localncz != null) {
      localncz.b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, paramInt);
    }
  }
  
  public void b()
  {
    bdla.b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app, "dc00898", "", "", "0X800B011", "0X800B011", 0, 0, "", "", "", "");
    ncz localncz = (ncz)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getManager(QQManagerFactory.AV_GAME_MANAGER);
    if (localncz != null)
    {
      localncz.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 8, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getCurrentAccountUin(), 0);
      return;
    }
    QQToast.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 2, 2131690467, 0).a();
  }
  
  public void c()
  {
    bdla.b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app, "dc00898", "", "", "0X800B012", "0X800B012", 0, 0, "", "", "", "");
    ncz localncz = (ncz)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getManager(QQManagerFactory.AV_GAME_MANAGER);
    if ((localncz != null) && (localncz.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity))) {
      return;
    }
    AVGameJoinRoomFragment.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, null);
  }
  
  public void d()
  {
    ncz localncz = (ncz)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getManager(QQManagerFactory.AV_GAME_MANAGER);
    if (localncz != null) {
      if (!localncz.a()) {
        break label73;
      }
    }
    label73:
    for (int i = 1;; i = 2)
    {
      bdla.b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app, "dc00898", "", "", "0X800B493", "0X800B493", i, 0, "", "", "", "");
      localncz.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 9);
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
    this.jdField_a_of_type_Neu = new neu();
    this.jdField_a_of_type_Neu.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app);
    paramBundle = (nqg)aqxe.a().a(642);
    this.jdField_a_of_type_Boolean = paramBundle.b();
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "avGameConfBean:" + paramBundle.toString() + "  avGameConfBean.isStrangerMatchShow：" + paramBundle.b());
    }
    nej.a(this.jdField_a_of_type_Boolean);
    nob.a();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    f();
    g();
    paramViewGroup = paramLayoutInflater.inflate(2131558729, paramViewGroup, false);
    if (ImmersiveUtils.c()) {
      ImmersiveUtils.a(false, getActivity().getWindow());
    }
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      paramBundle = (RelativeLayout)paramViewGroup.findViewById(2131363231);
      ((RelativeLayout.LayoutParams)paramBundle.getLayoutParams()).height = (ImmersiveUtils.getStatusBarHeight(paramLayoutInflater.getContext()) + AIOUtils.dp2px(44.0F, getResources()));
      paramBundle.setPadding(0, ImmersiveUtils.getStatusBarHeight(paramLayoutInflater.getContext()), 0, 0);
    }
    paramLayoutInflater = (RecyclerView)paramViewGroup.findViewById(2131363218);
    paramLayoutInflater.setLayoutManager(new LinearLayoutManager(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity));
    paramLayoutInflater.setAdapter(this.jdField_a_of_type_Nev);
    this.jdField_a_of_type_Nev.notifyDataSetChanged();
    paramLayoutInflater = (AsyncImageView)paramViewGroup.findViewById(2131363208);
    paramLayoutInflater.setDefaultColorDrawable(0);
    paramLayoutInflater.setAsyncImage("https://static-res.qq.com/static-res/avgames/strangerMatch/avgame_lobby_bg2.png");
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131363207));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new noz(this));
    float f = getActivity().getResources().getDisplayMetrics().density;
    AIOUtils.expandViewTouchDelegate(this.jdField_a_of_type_AndroidWidgetTextView, (int)(5.0F * f + 0.5F), (int)(5.0F * f + 0.5F), (int)(5.0F * f + 0.5F), (int)(f * 5.0F + 0.5F));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131363206));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new npa(this));
    paramViewGroup.findViewById(2131366705).setOnClickListener(new npb(this));
    ncz.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app);
    bdla.b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app, "dc00898", "", "", "0X800B49D", "0X800B49D", 0, 0, "", "", "", "");
    if (this.jdField_a_of_type_Boolean) {
      bdla.b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app, "dc00898", "", "", "0X800B49E", "0X800B49E", 0, 0, "", "", "", "");
    }
    ((ansg)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getBusinessHandler(BusinessHandlerFactory.CONFIG_HANDLER)).c();
    V4FragmentCollector.onV4FragmentViewCreated(this, paramViewGroup);
    return paramViewGroup;
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity != null) {
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.removeObserver(this.jdField_a_of_type_Ndm);
    }
    if (this.jdField_a_of_type_Nev != null) {
      this.jdField_a_of_type_Nev.a();
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
    ncz localncz = (ncz)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getManager(QQManagerFactory.AV_GAME_MANAGER);
    if ((localncz != null) && (localncz.a()))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      if (!this.jdField_b_of_type_Boolean) {
        break label72;
      }
      h();
      this.jdField_b_of_type_Boolean = false;
    }
    label72:
    while ((this.jdField_a_of_type_Bisl == null) || (!this.jdField_a_of_type_Bisl.isShowing()))
    {
      return;
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      break;
    }
    this.jdField_a_of_type_Bisl.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.ui.AVGameRoomCenterFragment
 * JD-Core Version:    0.7.0.1
 */