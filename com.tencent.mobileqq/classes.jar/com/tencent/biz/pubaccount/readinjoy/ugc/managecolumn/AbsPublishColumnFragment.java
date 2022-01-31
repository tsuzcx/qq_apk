package com.tencent.biz.pubaccount.readinjoy.ugc.managecolumn;

import alof;
import android.app.Activity;
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
import android.widget.TextView;
import bdep;
import bdfa;
import bety;
import bhtb;
import bidh;
import com.tencent.biz.pubaccount.readinjoy.struct.ColumnInfo;
import com.tencent.biz.pubaccount.readinjoy.widgets.LimitWordCountEditText;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import java.io.File;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import nrt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ors;
import orz;
import qok;
import qtj;
import qtk;
import qtl;
import qtm;
import qtv;
import qtw;
import qty;
import qua;
import qxd;
import qxg;

public abstract class AbsPublishColumnFragment
  extends PublicBaseFragment
  implements View.OnClickListener, qtw
{
  protected ImageView a;
  protected TextView a;
  protected bety a;
  public LimitWordCountEditText a;
  protected ImmersiveTitleBar2 a;
  protected String a;
  protected Map<String, String> a;
  public final qtv a;
  protected qxd a;
  protected ImageView b;
  protected TextView b;
  protected bety b;
  protected LimitWordCountEditText b;
  protected String b;
  protected TextView c;
  protected TextView d;
  
  public AbsPublishColumnFragment()
  {
    this.jdField_a_of_type_Qtv = new qua(new qty(ors.a()));
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
  }
  
  @NotNull
  private orz a()
  {
    int n = 1;
    orz localorz1 = new orz();
    boolean bool1 = qok.d();
    boolean bool2 = qok.a();
    int k;
    int j;
    label55:
    label76:
    int m;
    label84:
    orz localorz2;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      k = 1;
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyWidgetsLimitWordCountEditText.a().getText().toString())) {
        break label185;
      }
      j = 1;
      if (TextUtils.isEmpty(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyWidgetsLimitWordCountEditText.a().getText().toString())) {
        break label190;
      }
      i = 1;
      if (!bool1) {
        break label195;
      }
      m = 1;
      localorz2 = localorz1.a("ugc_video_flag", Integer.valueOf(m));
      if (!bool2) {
        break label201;
      }
      m = 1;
      label106:
      localorz2 = localorz2.a("ugc_column_flag", Integer.valueOf(m));
      if (k == 0) {
        break label207;
      }
      k = 1;
      label126:
      localorz2 = localorz2.a("cover_flag", Integer.valueOf(k));
      if (j == 0) {
        break label212;
      }
      j = 1;
      label145:
      localorz2 = localorz2.a("column_name_flag", Integer.valueOf(j));
      if (i == 0) {
        break label217;
      }
    }
    label185:
    label190:
    label195:
    label201:
    label207:
    label212:
    label217:
    for (int i = n;; i = 0)
    {
      localorz2.a("introduction_flag", Integer.valueOf(i));
      return localorz1;
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
    }
  }
  
  private void l()
  {
    if ((bhtb.k()) && (!bdep.b()) && (!bdep.d()))
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
    String str = alof.aX + localFragmentActivity.app.getCurrentAccountUin() + "/" + "nearby_people_photo/";
    localIntent.putExtra("PhotoConst.TARGET_PATH", str + System.currentTimeMillis() + ".jpg");
    localIntent.putExtra("PhotoConst.CLIP_WIDTH", 640);
    localIntent.putExtra("PhotoConst.CLIP_HEIGHT", 640);
    localIntent.putExtra("PhotoConst.TARGET_WIDTH", 640);
    localIntent.putExtra("PhotoConst.TARGET_HEIGHT", 640);
    localFragmentActivity.startActivity(localIntent);
    bdfa.anim(localFragmentActivity, false, true);
  }
  
  private void o()
  {
    this.d.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    this.c.setVisibility(0);
  }
  
  private void p()
  {
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    this.c.setVisibility(8);
    this.d.setVisibility(0);
  }
  
  public qtm a()
  {
    return new qtm(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyWidgetsLimitWordCountEditText.a(), this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyWidgetsLimitWordCountEditText.a());
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Bety == null)
    {
      this.jdField_a_of_type_Bety = new bety(getActivity());
      this.jdField_a_of_type_Bety.c(2131718779);
    }
    if (this.jdField_a_of_type_Bety.isShowing())
    {
      QLog.i("RIJUGC.PublishTopicFragment", 1, "showUploadLoadingProgress, but dialog is showing");
      return;
    }
    this.jdField_a_of_type_Bety.show();
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
    this.jdField_a_of_type_JavaLangString = paramString1;
    k();
    g();
  }
  
  public void a(boolean paramBoolean)
  {
    orz localorz = a();
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localorz.a("click_area", Integer.valueOf(i));
      nrt.a("0X800AD2E", localorz.a());
      return;
    }
  }
  
  protected abstract boolean a();
  
  public void b()
  {
    if ((this.jdField_a_of_type_Bety != null) && (this.jdField_a_of_type_Bety.isShowing())) {
      this.jdField_a_of_type_Bety.dismiss();
    }
  }
  
  public void b(@Nullable ColumnInfo paramColumnInfo)
  {
    if (paramColumnInfo != null)
    {
      this.jdField_a_of_type_JavaLangString = paramColumnInfo.coverUrl;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyWidgetsLimitWordCountEditText.setContent(paramColumnInfo.title);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyWidgetsLimitWordCountEditText.setSelectionEnd();
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyWidgetsLimitWordCountEditText.setContent(paramColumnInfo.intro);
    }
    k();
    g();
  }
  
  public void b(@NotNull ColumnInfo paramColumnInfo, boolean paramBoolean) {}
  
  protected abstract boolean b();
  
  public void c()
  {
    if (this.jdField_b_of_type_Bety == null) {
      this.jdField_b_of_type_Bety = new bety(getActivity());
    }
    if (this.jdField_b_of_type_Bety.isShowing())
    {
      QLog.i("RIJUGC.PublishTopicFragment", 1, "showPublishLoadingProgress, but dialog is showing");
      return;
    }
    this.jdField_b_of_type_Bety.show();
  }
  
  public void d()
  {
    if ((this.jdField_b_of_type_Bety != null) && (this.jdField_b_of_type_Bety.isShowing())) {
      this.jdField_b_of_type_Bety.dismiss();
    }
  }
  
  public void e()
  {
    nrt.a("0X800AD2D", a().a());
  }
  
  public void f()
  {
    nrt.a("0X800AC5B", a().a());
  }
  
  public void g()
  {
    if (b())
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setClickable(true);
      this.jdField_b_of_type_AndroidWidgetTextView.setAlpha(1.0F);
      return;
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setClickable(false);
    this.jdField_b_of_type_AndroidWidgetTextView.setAlpha(0.5F);
  }
  
  public void h()
  {
    nrt.a("0X800AC5A", a().a());
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
    nrt.a("0X800AC5C", a().a());
    if (getActivity().checkSelfPermission("android.permission.CAMERA") == 0)
    {
      n();
      return;
    }
    getActivity().requestPermissions(new qtk(this), 1, new String[] { "android.permission.CAMERA" });
  }
  
  public void k()
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      Object localObject1 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth = this.jdField_a_of_type_AndroidWidgetImageView.getWidth();
      ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight = this.jdField_a_of_type_AndroidWidgetImageView.getHeight();
      ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = new ColorDrawable(-657415);
      ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = new ColorDrawable(-657415);
      String str = (String)this.jdField_a_of_type_JavaUtilMap.get(this.jdField_a_of_type_JavaLangString);
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
        Object localObject2 = URLDrawable.getDrawable(this.jdField_a_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject2);
        continue;
        label190:
        ((URLDrawable)localObject2).setURLDrawableListener(new qtl(this));
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
      return;
    case 2131368946: 
      h();
      return;
    case 2131379048: 
      f();
      return;
    }
    j();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_b_of_type_JavaLangString = getActivity().getIntent().getStringExtra("arg_callback");
    getActivity().getWindow().setSoftInputMode(16);
    bidh.a(getActivity());
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_Qtv.a(this);
    paramLayoutInflater = paramLayoutInflater.inflate(2131559983, null);
    this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2 = ((ImmersiveTitleBar2)paramLayoutInflater.findViewById(2131378030));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131379043));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131379048));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramLayoutInflater.findViewById(2131368753));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramLayoutInflater.findViewById(2131368726));
    this.c = ((TextView)paramLayoutInflater.findViewById(2131378649));
    this.d = ((TextView)paramLayoutInflater.findViewById(2131378693));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyWidgetsLimitWordCountEditText = ((LimitWordCountEditText)paramLayoutInflater.findViewById(2131365835));
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyWidgetsLimitWordCountEditText = ((LimitWordCountEditText)paramLayoutInflater.findViewById(2131365834));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyWidgetsLimitWordCountEditText.setCountLimit(this.jdField_a_of_type_Qtv.a());
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyWidgetsLimitWordCountEditText.setCountLimit(this.jdField_a_of_type_Qtv.b());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyWidgetsLimitWordCountEditText.setTitleTypeFace(Typeface.defaultFromStyle(1));
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyWidgetsLimitWordCountEditText.setTitleTypeFace(Typeface.defaultFromStyle(1));
    paramLayoutInflater.findViewById(2131368946).setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyWidgetsLimitWordCountEditText.setCountChangeListener(new qtj(this));
    l();
    g();
    m();
    return paramLayoutInflater;
  }
  
  public void onDestroyView()
  {
    this.jdField_a_of_type_Qtv.a();
    if (this.jdField_a_of_type_Qxd != null) {
      this.jdField_a_of_type_Qxd.b();
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
        if (this.jdField_a_of_type_Qxd != null) {
          this.jdField_a_of_type_Qxd.b();
        }
        this.jdField_a_of_type_Qxd = new qxg(getActivity(), getActivity().app, paramIntent);
        this.jdField_a_of_type_Qtv.a(this.jdField_a_of_type_Qxd, paramIntent);
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