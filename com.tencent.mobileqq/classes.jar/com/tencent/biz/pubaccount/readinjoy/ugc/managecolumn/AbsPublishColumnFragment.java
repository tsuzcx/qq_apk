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
import anhk;
import bgjq;
import bgkc;
import biau;
import bkif;
import bkqt;
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
import oat;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pha;
import phi;
import rjh;
import rol;
import rom;
import ron;
import roo;
import rop;
import rpa;
import rpb;
import rpd;
import rpf;
import rtc;
import rtf;

public abstract class AbsPublishColumnFragment
  extends PublicBaseFragment
  implements View.OnClickListener, rpb
{
  int jdField_a_of_type_Int = 0;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private Context jdField_a_of_type_AndroidContentContext = BaseApplicationImpl.getContext();
  protected ImageView a;
  protected TextView a;
  protected biau a;
  public LimitWordCountEditText a;
  protected ImmersiveTitleBar2 a;
  protected String a;
  protected Map<String, String> a;
  public final rpa a;
  protected rtc a;
  protected ImageView b;
  protected TextView b;
  protected biau b;
  protected LimitWordCountEditText b;
  protected String b;
  protected TextView c;
  protected TextView d;
  protected TextView e;
  
  public AbsPublishColumnFragment()
  {
    this.jdField_a_of_type_Rpa = new rpf(new rpd(pha.a()));
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
  }
  
  @NotNull
  private phi a()
  {
    int n = 0;
    phi localphi1 = new phi();
    boolean bool1 = rjh.g();
    boolean bool2 = rjh.c();
    int k;
    int j;
    label55:
    label76:
    int m;
    label84:
    phi localphi2;
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
      localphi2 = localphi1.a("ugc_video_flag", Integer.valueOf(m));
      if (!bool2) {
        break label223;
      }
      m = 1;
      label106:
      localphi2 = localphi2.a("ugc_column_flag", Integer.valueOf(m));
      if (k == 0) {
        break label229;
      }
      k = 1;
      label126:
      localphi2 = localphi2.a("cover_flag", Integer.valueOf(k));
      if (j == 0) {
        break label234;
      }
      j = 1;
      label145:
      localphi2 = localphi2.a("column_name_flag", Integer.valueOf(j));
      if (i == 0) {
        break label239;
      }
      i = 1;
      label164:
      localphi2 = localphi2.a("introduction_flag", Integer.valueOf(i));
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
      localphi2.a("collaborator_flag", Integer.valueOf(i));
      return localphi1;
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
      this.jdField_a_of_type_AndroidWidgetTextView.setText(rjh.a(paramInt, this.jdField_a_of_type_AndroidContentContext));
      this.jdField_a_of_type_Int = paramInt;
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
    g();
  }
  
  private void l()
  {
    if ((VersionUtils.isM()) && (!bgjq.b()) && (!bgjq.d()))
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
    String str = anhk.ba + localFragmentActivity.app.getCurrentAccountUin() + "/" + "nearby_people_photo/";
    localIntent.putExtra("PhotoConst.TARGET_PATH", str + System.currentTimeMillis() + ".jpg");
    localIntent.putExtra("PhotoConst.CLIP_WIDTH", 640);
    localIntent.putExtra("PhotoConst.CLIP_HEIGHT", 640);
    localIntent.putExtra("PhotoConst.TARGET_WIDTH", 640);
    localIntent.putExtra("PhotoConst.TARGET_HEIGHT", 640);
    localFragmentActivity.startActivity(localIntent);
    bgkc.anim(localFragmentActivity, false, true);
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
    View localView = LayoutInflater.from(getActivity()).inflate(2131560204, null);
    ((RelativeLayout)localView.findViewById(2131366999)).setOnClickListener(this);
    ((RelativeLayout)localView.findViewById(2131362639)).setOnClickListener(this);
    ((TextView)localView.findViewById(2131364128)).setOnClickListener(new roo(this));
    ((TextView)localView.findViewById(2131367001)).setText(rjh.a(0, this.jdField_a_of_type_AndroidContentContext));
    ((TextView)localView.findViewById(2131366998)).setText(rjh.b(0, this.jdField_a_of_type_AndroidContentContext));
    ((TextView)localView.findViewById(2131362641)).setText(rjh.a(1, this.jdField_a_of_type_AndroidContentContext));
    ((TextView)localView.findViewById(2131362638)).setText(rjh.b(1, this.jdField_a_of_type_AndroidContentContext));
    ImageView localImageView1 = (ImageView)localView.findViewById(2131367000);
    ImageView localImageView2 = (ImageView)localView.findViewById(2131362640);
    if (this.jdField_a_of_type_Int == 0)
    {
      localImageView1.setVisibility(0);
      localImageView2.setVisibility(8);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidAppDialog = bkif.a(getActivity(), localView);
      this.jdField_a_of_type_AndroidAppDialog.show();
      return;
      localImageView1.setVisibility(8);
      localImageView2.setVisibility(0);
    }
  }
  
  public rop a()
  {
    return new rop(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyWidgetsLimitWordCountEditText.a(), this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyWidgetsLimitWordCountEditText.a(), this.jdField_a_of_type_Int);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Biau == null)
    {
      this.jdField_a_of_type_Biau = new biau(getActivity());
      this.jdField_a_of_type_Biau.c(2131716919);
    }
    if (this.jdField_a_of_type_Biau.isShowing())
    {
      QLog.i("RIJUGC.PublishTopicFragment", 1, "showUploadLoadingProgress, but dialog is showing");
      return;
    }
    this.jdField_a_of_type_Biau.show();
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
    phi localphi = a();
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localphi.a("click_area", Integer.valueOf(i));
      oat.a("0X800AD2E", localphi.a());
      return;
    }
  }
  
  protected abstract boolean a();
  
  public void b()
  {
    if ((this.jdField_a_of_type_Biau != null) && (this.jdField_a_of_type_Biau.isShowing())) {
      this.jdField_a_of_type_Biau.dismiss();
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
    this.jdField_a_of_type_AndroidWidgetTextView.setText(rjh.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_AndroidContentContext));
  }
  
  public void b(@NotNull ColumnInfo paramColumnInfo, boolean paramBoolean) {}
  
  protected abstract boolean b();
  
  public void c()
  {
    if (this.jdField_b_of_type_Biau == null) {
      this.jdField_b_of_type_Biau = new biau(getActivity());
    }
    if (this.jdField_b_of_type_Biau.isShowing())
    {
      QLog.i("RIJUGC.PublishTopicFragment", 1, "showPublishLoadingProgress, but dialog is showing");
      return;
    }
    this.jdField_b_of_type_Biau.show();
  }
  
  public void d()
  {
    if ((this.jdField_b_of_type_Biau != null) && (this.jdField_b_of_type_Biau.isShowing())) {
      this.jdField_b_of_type_Biau.dismiss();
    }
  }
  
  public void e()
  {
    oat.a("0X800AD2D", a().a());
  }
  
  public void f()
  {
    oat.a("0X800AC5B", a().a());
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
    oat.a("0X800AC5A", a().a());
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
    oat.a("0X800AC5C", a().a());
    if (getActivity().checkSelfPermission("android.permission.CAMERA") == 0)
    {
      n();
      return;
    }
    getActivity().requestPermissions(new rom(this), 1, new String[] { "android.permission.CAMERA" });
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
        ((URLDrawable)localObject2).setURLDrawableListener(new ron(this));
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
    bkqt.a(getActivity());
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_Rpa.a(this);
    paramLayoutInflater = paramLayoutInflater.inflate(2131560130, null);
    this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2 = ((ImmersiveTitleBar2)paramLayoutInflater.findViewById(2131378874));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131379957));
    this.c = ((TextView)paramLayoutInflater.findViewById(2131379963));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramLayoutInflater.findViewById(2131369094));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramLayoutInflater.findViewById(2131369063));
    this.d = ((TextView)paramLayoutInflater.findViewById(2131379505));
    this.e = ((TextView)paramLayoutInflater.findViewById(2131379555));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyWidgetsLimitWordCountEditText = ((LimitWordCountEditText)paramLayoutInflater.findViewById(2131366084));
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyWidgetsLimitWordCountEditText = ((LimitWordCountEditText)paramLayoutInflater.findViewById(2131366083));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131379922));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    if (rjh.a() != 0)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(rjh.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_AndroidContentContext));
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyWidgetsLimitWordCountEditText.setCountLimit(this.jdField_a_of_type_Rpa.a());
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyWidgetsLimitWordCountEditText.setCountLimit(this.jdField_a_of_type_Rpa.b());
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyWidgetsLimitWordCountEditText.setTitleTypeFace(Typeface.defaultFromStyle(1));
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyWidgetsLimitWordCountEditText.setTitleTypeFace(Typeface.defaultFromStyle(1));
      paramLayoutInflater.findViewById(2131369323).setOnClickListener(this);
      this.c.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyWidgetsLimitWordCountEditText.setCountChangeListener(new rol(this));
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
    this.jdField_a_of_type_Rpa.a();
    if (this.jdField_a_of_type_Rtc != null) {
      this.jdField_a_of_type_Rtc.b();
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
        if (this.jdField_a_of_type_Rtc != null) {
          this.jdField_a_of_type_Rtc.b();
        }
        this.jdField_a_of_type_Rtc = new rtf(getActivity(), getActivity().app, paramIntent);
        this.jdField_a_of_type_Rpa.a(this.jdField_a_of_type_Rtc, paramIntent);
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