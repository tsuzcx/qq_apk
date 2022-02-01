package com.tencent.biz.pubaccount.readinjoy.ugc.managecolumn;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import antf;
import bhjr;
import bhkd;
import bjbs;
import blji;
import blrw;
import com.tencent.biz.pubaccount.readinjoy.struct.ColumnInfo;
import com.tencent.biz.pubaccount.readinjoy.widgets.LimitWordCountEditText;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.util.VersionUtils;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import java.io.File;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import ocd;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ozs;
import paa;
import rab;
import rfh;
import rfi;
import rfj;
import rfk;
import rfl;
import rfw;
import rfx;
import rfz;
import rgb;
import rjy;
import rkb;

public abstract class AbsPublishColumnFragment
  extends PublicBaseFragment
  implements View.OnClickListener, rfx
{
  int jdField_a_of_type_Int = 0;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private Context jdField_a_of_type_AndroidContentContext = BaseApplicationImpl.getContext();
  protected ImageView a;
  protected TextView a;
  protected bjbs a;
  public LimitWordCountEditText a;
  protected ImmersiveTitleBar2 a;
  protected String a;
  protected Map<String, String> a;
  public final rfw a;
  protected rjy a;
  protected ImageView b;
  protected TextView b;
  protected bjbs b;
  protected LimitWordCountEditText b;
  protected String b;
  protected TextView c;
  protected TextView d;
  protected TextView e;
  
  public AbsPublishColumnFragment()
  {
    this.jdField_a_of_type_Rfw = new rgb(new rfz(ozs.a()));
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
  }
  
  @NotNull
  private paa a()
  {
    int n = 0;
    paa localpaa1 = new paa();
    boolean bool1 = rab.o();
    boolean bool2 = rab.h();
    int k;
    int j;
    label55:
    label76:
    int m;
    label84:
    paa localpaa2;
    if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
    {
      k = 1;
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyWidgetsLimitWordCountEditText.a().getText().toString())) {
        break label207;
      }
      j = 1;
      if (TextUtils.isEmpty(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyWidgetsLimitWordCountEditText.a().getText().toString())) {
        break label212;
      }
      i = 1;
      if (!bool1) {
        break label217;
      }
      m = 1;
      localpaa2 = localpaa1.a("ugc_video_flag", Integer.valueOf(m));
      if (!bool2) {
        break label223;
      }
      m = 1;
      label106:
      localpaa2 = localpaa2.a("ugc_column_flag", Integer.valueOf(m));
      if (k == 0) {
        break label229;
      }
      k = 1;
      label126:
      localpaa2 = localpaa2.a("cover_flag", Integer.valueOf(k));
      if (j == 0) {
        break label234;
      }
      j = 1;
      label145:
      localpaa2 = localpaa2.a("column_name_flag", Integer.valueOf(j));
      if (i == 0) {
        break label239;
      }
      i = 1;
      label164:
      localpaa2 = localpaa2.a("introduction_flag", Integer.valueOf(i));
      if (this.jdField_a_of_type_Int != 0) {
        break label244;
      }
    }
    label207:
    label212:
    label217:
    label223:
    label229:
    label234:
    label239:
    label244:
    for (int i = n;; i = 1)
    {
      localpaa2.a("collaborator_flag", Integer.valueOf(i));
      return localpaa1;
      k = 0;
      break;
      j = 0;
      break label55;
      i = 0;
      break label76;
      m = 0;
      break label84;
      m = 0;
      break label106;
      k = 0;
      break label126;
      j = 0;
      break label145;
      i = 0;
      break label164;
    }
  }
  
  private void b(int paramInt)
  {
    if ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing()))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(rab.a(paramInt, this.jdField_a_of_type_AndroidContentContext));
      this.jdField_a_of_type_Int = paramInt;
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
    g();
  }
  
  private void l()
  {
    if ((VersionUtils.isM()) && (!bhjr.b()) && (!bhjr.d()))
    {
      getActivity().getWindow().getDecorView().setSystemUiVisibility(9216);
      this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.setBackgroundColor(-1);
    }
  }
  
  private void m()
  {
    getActivity().getWindow().getDecorView().setBackgroundColor(-1);
  }
  
  private void n()
  {
    FragmentActivity localFragmentActivity = getActivity();
    Intent localIntent = new Intent(localFragmentActivity, NewPhotoListActivity.class);
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", localFragmentActivity.getClass().getName());
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    localIntent.putExtra("PhotoConst.IS_RECODE_LAST_ALBUMPATH", false);
    localIntent.putExtra("PhotoConst.IS_SINGLE_MODE", true);
    localIntent.putExtra("PhotoConst.IS_SINGLE_NEED_EDIT", true);
    localIntent.putExtra("PhotoConst.IS_FINISH_RESTART_INIT_ACTIVITY", true);
    localIntent.putExtra("PhotoConst.PHOTO_LIST_SHOW_PREVIEW", true);
    String str = antf.ba + localFragmentActivity.app.getCurrentAccountUin() + "/" + "nearby_people_photo/";
    localIntent.putExtra("PhotoConst.TARGET_PATH", str + System.currentTimeMillis() + ".jpg");
    localIntent.putExtra("PhotoConst.CLIP_WIDTH", 640);
    localIntent.putExtra("PhotoConst.CLIP_HEIGHT", 640);
    localIntent.putExtra("PhotoConst.TARGET_WIDTH", 640);
    localIntent.putExtra("PhotoConst.TARGET_HEIGHT", 640);
    localFragmentActivity.startActivity(localIntent);
    bhkd.anim(localFragmentActivity, false, true);
  }
  
  private void o()
  {
    this.e.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    this.d.setVisibility(0);
  }
  
  private void p()
  {
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    this.d.setVisibility(8);
    this.e.setVisibility(0);
  }
  
  private void q()
  {
    View localView = LayoutInflater.from(getActivity()).inflate(2131560216, null);
    ((RelativeLayout)localView.findViewById(2131367050)).setOnClickListener(this);
    ((RelativeLayout)localView.findViewById(2131362654)).setOnClickListener(this);
    ((TextView)localView.findViewById(2131364169)).setOnClickListener(new rfk(this));
    ((TextView)localView.findViewById(2131367052)).setText(rab.a(0, this.jdField_a_of_type_AndroidContentContext));
    ((TextView)localView.findViewById(2131367049)).setText(rab.b(0, this.jdField_a_of_type_AndroidContentContext));
    ((TextView)localView.findViewById(2131362656)).setText(rab.a(1, this.jdField_a_of_type_AndroidContentContext));
    ((TextView)localView.findViewById(2131362653)).setText(rab.b(1, this.jdField_a_of_type_AndroidContentContext));
    ImageView localImageView1 = (ImageView)localView.findViewById(2131367051);
    ImageView localImageView2 = (ImageView)localView.findViewById(2131362655);
    if (this.jdField_a_of_type_Int == 0)
    {
      localImageView1.setVisibility(0);
      localImageView2.setVisibility(8);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidAppDialog = blji.a(getActivity(), localView);
      this.jdField_a_of_type_AndroidAppDialog.show();
      return;
      localImageView1.setVisibility(8);
      localImageView2.setVisibility(0);
    }
  }
  
  public rfl a()
  {
    return new rfl(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyWidgetsLimitWordCountEditText.a(), this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyWidgetsLimitWordCountEditText.a(), this.jdField_a_of_type_Int);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Bjbs == null)
    {
      this.jdField_a_of_type_Bjbs = new bjbs(getActivity());
      this.jdField_a_of_type_Bjbs.c(2131717035);
    }
    if (this.jdField_a_of_type_Bjbs.isShowing())
    {
      QLog.i("RIJUGC.PublishTopicFragment", 1, "showUploadLoadingProgress, but dialog is showing");
      return;
    }
    this.jdField_a_of_type_Bjbs.show();
  }
  
  public void a(int paramInt)
  {
    a(getResources().getString(paramInt));
  }
  
  public void a(ColumnInfo paramColumnInfo)
  {
    b(paramColumnInfo);
  }
  
  public void a(@NotNull ColumnInfo paramColumnInfo, boolean paramBoolean) {}
  
  public void a(@NotNull String paramString)
  {
    QQToast.a(getActivity(), 0, paramString, 0).a();
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaUtilMap.put(paramString1, paramString2);
    this.jdField_b_of_type_JavaLangString = paramString1;
    k();
    g();
  }
  
  public void a(boolean paramBoolean)
  {
    paa localpaa = a();
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localpaa.a("click_area", Integer.valueOf(i));
      ocd.a("0X800AD2E", localpaa.a());
      return;
    }
  }
  
  protected abstract boolean a();
  
  public void b()
  {
    if ((this.jdField_a_of_type_Bjbs != null) && (this.jdField_a_of_type_Bjbs.isShowing())) {
      this.jdField_a_of_type_Bjbs.dismiss();
    }
  }
  
  public void b(@Nullable ColumnInfo paramColumnInfo)
  {
    if (paramColumnInfo != null)
    {
      this.jdField_b_of_type_JavaLangString = paramColumnInfo.coverUrl;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyWidgetsLimitWordCountEditText.setContent(paramColumnInfo.title);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyWidgetsLimitWordCountEditText.setSelectionEnd();
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyWidgetsLimitWordCountEditText.setContent(paramColumnInfo.intro);
      this.jdField_a_of_type_Int = paramColumnInfo.submitPermission;
    }
    k();
    g();
    this.jdField_a_of_type_AndroidWidgetTextView.setText(rab.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_AndroidContentContext));
  }
  
  public void b(@NotNull ColumnInfo paramColumnInfo, boolean paramBoolean) {}
  
  protected abstract boolean b();
  
  public void c()
  {
    if (this.jdField_b_of_type_Bjbs == null) {
      this.jdField_b_of_type_Bjbs = new bjbs(getActivity());
    }
    if (this.jdField_b_of_type_Bjbs.isShowing())
    {
      QLog.i("RIJUGC.PublishTopicFragment", 1, "showPublishLoadingProgress, but dialog is showing");
      return;
    }
    this.jdField_b_of_type_Bjbs.show();
  }
  
  public void d()
  {
    if ((this.jdField_b_of_type_Bjbs != null) && (this.jdField_b_of_type_Bjbs.isShowing())) {
      this.jdField_b_of_type_Bjbs.dismiss();
    }
  }
  
  public void e()
  {
    ocd.a("0X800AD2D", a().a());
  }
  
  public void f()
  {
    ocd.a("0X800AC5B", a().a());
  }
  
  public void g()
  {
    if (b())
    {
      this.c.setClickable(true);
      this.c.setAlpha(1.0F);
      return;
    }
    this.c.setClickable(false);
    this.c.setAlpha(0.5F);
  }
  
  public void h()
  {
    ocd.a("0X800AC5A", a().a());
    if (a())
    {
      e();
      return;
    }
    i();
  }
  
  public void i()
  {
    FragmentActivity localFragmentActivity = getActivity();
    if (localFragmentActivity != null) {
      localFragmentActivity.finish();
    }
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void j()
  {
    ocd.a("0X800AC5C", a().a());
    if (getActivity().checkSelfPermission("android.permission.CAMERA") == 0)
    {
      n();
      return;
    }
    getActivity().requestPermissions(new rfi(this), 1, new String[] { "android.permission.CAMERA" });
  }
  
  public void k()
  {
    if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
    {
      Object localObject1 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth = this.jdField_a_of_type_AndroidWidgetImageView.getWidth();
      ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight = this.jdField_a_of_type_AndroidWidgetImageView.getHeight();
      ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = new ColorDrawable(-657415);
      ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = new ColorDrawable(-657415);
      String str = (String)this.jdField_a_of_type_JavaUtilMap.get(this.jdField_b_of_type_JavaLangString);
      if (!TextUtils.isEmpty(str)) {}
      for (;;)
      {
        try
        {
          localObject1 = URLDrawable.getDrawable(new File(str).toURI().toURL(), (URLDrawable.URLDrawableOptions)localObject1);
          if (localObject1 != null)
          {
            if (((URLDrawable)localObject1).getStatus() != 1) {
              break label190;
            }
            p();
            this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
          }
          return;
        }
        catch (Exception localException)
        {
          QLog.e("RIJUGC.PublishTopicFragment", 1, "updateCoverLayout exception, e=" + localException.getMessage() + ",localPath=" + str);
          localObject2 = null;
          continue;
        }
        Object localObject2 = URLDrawable.getDrawable(this.jdField_b_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject2);
        continue;
        label190:
        ((URLDrawable)localObject2).setURLDrawableListener(new rfj(this));
      }
    }
    o();
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public boolean onBackEvent()
  {
    if (a())
    {
      e();
      return true;
    }
    return false;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      QLog.e("RIJUGC.PublishTopicFragment", 1, "onClick, no handler, view = " + paramView.getClass().getSimpleName());
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      h();
      continue;
      f();
      continue;
      j();
      continue;
      q();
      continue;
      b(0);
      continue;
      b(1);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_JavaLangString = getActivity().getIntent().getStringExtra("arg_callback");
    getActivity().getWindow().setSoftInputMode(16);
    blrw.a(getActivity());
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_Rfw.a(this);
    paramLayoutInflater = paramLayoutInflater.inflate(2131560142, null);
    this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2 = ((ImmersiveTitleBar2)paramLayoutInflater.findViewById(2131379037));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131380141));
    this.c = ((TextView)paramLayoutInflater.findViewById(2131380147));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramLayoutInflater.findViewById(2131369184));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramLayoutInflater.findViewById(2131369153));
    this.d = ((TextView)paramLayoutInflater.findViewById(2131379674));
    this.e = ((TextView)paramLayoutInflater.findViewById(2131379727));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyWidgetsLimitWordCountEditText = ((LimitWordCountEditText)paramLayoutInflater.findViewById(2131366132));
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyWidgetsLimitWordCountEditText = ((LimitWordCountEditText)paramLayoutInflater.findViewById(2131366131));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131380105));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    if (rab.a() != 0)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(rab.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_AndroidContentContext));
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyWidgetsLimitWordCountEditText.setCountLimit(this.jdField_a_of_type_Rfw.a());
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyWidgetsLimitWordCountEditText.setCountLimit(this.jdField_a_of_type_Rfw.b());
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyWidgetsLimitWordCountEditText.setTitleTypeFace(Typeface.defaultFromStyle(1));
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyWidgetsLimitWordCountEditText.setTitleTypeFace(Typeface.defaultFromStyle(1));
      paramLayoutInflater.findViewById(2131369412).setOnClickListener(this);
      this.c.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyWidgetsLimitWordCountEditText.setCountChangeListener(new rfh(this));
      l();
      g();
      m();
      V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
      return paramLayoutInflater;
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
  
  public void onDestroyView()
  {
    this.jdField_a_of_type_Rfw.a();
    if (this.jdField_a_of_type_Rjy != null) {
      this.jdField_a_of_type_Rjy.b();
    }
    super.onDestroyView();
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    paramIntent = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
    if ((paramIntent != null) && (!paramIntent.isEmpty()))
    {
      paramIntent = (String)paramIntent.get(0);
      QLog.i("RIJUGC.PublishTopicFragment", 1, "onSelectPhoto, path=" + paramIntent);
      if (!TextUtils.isEmpty(paramIntent))
      {
        if (this.jdField_a_of_type_Rjy != null) {
          this.jdField_a_of_type_Rjy.b();
        }
        this.jdField_a_of_type_Rjy = new rkb(getActivity(), getActivity().app, paramIntent);
        this.jdField_a_of_type_Rfw.a(this.jdField_a_of_type_Rjy, paramIntent);
      }
    }
  }
  
  public void onPause()
  {
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.managecolumn.AbsPublishColumnFragment
 * JD-Core Version:    0.7.0.1
 */