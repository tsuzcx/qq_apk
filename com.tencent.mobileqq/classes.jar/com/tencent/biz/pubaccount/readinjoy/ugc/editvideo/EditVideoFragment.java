package com.tencent.biz.pubaccount.readinjoy.ugc.editvideo;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import bdin;
import bhus;
import com.tencent.biz.pubaccount.readinjoy.struct.ColumnInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.UgcVideo;
import com.tencent.biz.pubaccount.readinjoy.ugc.coverselect.CoverSelectTabFragment;
import com.tencent.biz.pubaccount.readinjoy.widgets.LimitWordCountEditText;
import com.tencent.biz.pubaccount.readinjoy.widgets.RoundBackgroundTextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.presseffect.PressEffectImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.Switch;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import nrt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ors;
import orz;
import oxb;
import qnz;
import qok;
import qsr;
import qst;
import qsu;
import qsv;
import qsw;
import qsx;
import qsy;
import qsz;
import qtb;
import qtc;
import qtx;
import qun;
import smk;
import xin;
import xsm;

public class EditVideoFragment
  extends PublicBaseFragment
  implements View.OnClickListener, qsr
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private View jdField_a_of_type_AndroidViewView;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private ListView jdField_a_of_type_AndroidWidgetListView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  @Nullable
  private ColumnInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructColumnInfo;
  private UgcVideo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo = new UgcVideo();
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private Switch jdField_a_of_type_ComTencentWidgetSwitch;
  private String jdField_a_of_type_JavaLangString;
  private ArrayList<ColumnInfo> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private qsz jdField_a_of_type_Qsz;
  private qtc jdField_a_of_type_Qtc = new qtc(new qtb(ors.a()));
  private qtx jdField_a_of_type_Qtx = new qst(this);
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = 2;
  private View jdField_b_of_type_AndroidViewView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private boolean jdField_b_of_type_Boolean;
  private View jdField_c_of_type_AndroidViewView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  
  private int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return -1;
    case 1: 
      return 3;
    case 2: 
      return 2;
    }
    return 1;
  }
  
  @NotNull
  private orz a()
  {
    int j = 2;
    int i2 = 1;
    int i;
    int k;
    label56:
    int m;
    label76:
    int n;
    switch (this.jdField_b_of_type_Int)
    {
    default: 
      i = -1;
      if (TextUtils.isEmpty(this.jdField_a_of_type_AndroidWidgetEditText.getText().toString()))
      {
        k = 0;
        if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructColumnInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructColumnInfo.columnID != 0)) {
          break label263;
        }
        m = 0;
        if (!this.jdField_a_of_type_ComTencentWidgetSwitch.isChecked()) {
          break label269;
        }
        n = 1;
        label89:
        if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.reprintDisable)) {
          break label293;
        }
      }
      break;
    }
    label129:
    label263:
    label269:
    label288:
    label293:
    for (int i1 = 1;; i1 = 0)
    {
      int i3 = a(this.jdField_a_of_type_Int);
      orz localorz1;
      orz localorz2;
      if (this.jdField_a_of_type_Int == 3)
      {
        j = 1;
        localorz1 = new orz();
        localorz2 = localorz1.a("from", Integer.valueOf(i3)).a("user_type", Integer.valueOf(j)).a("video_flag", Integer.valueOf(1));
        if (!this.jdField_b_of_type_Boolean) {
          break label288;
        }
      }
      for (j = i2;; j = 0)
      {
        localorz2.a("cover_flag", Integer.valueOf(j)).a("cover_type", Integer.valueOf(i)).a("video_name_flag", Integer.valueOf(k)).a("column_flag", Integer.valueOf(m)).a("friend_flag", Integer.valueOf(n)).a("reprint_flag", Integer.valueOf(i1));
        return localorz1;
        i = 1;
        break;
        i = 2;
        break;
        i = 3;
        break;
        k = 1;
        break label56;
        m = 1;
        break label76;
        n = 0;
        break label89;
        if (this.jdField_a_of_type_Int == 4) {
          break label129;
        }
        j = 0;
        break label129;
      }
    }
  }
  
  public static void a(Activity paramActivity, UgcVideo paramUgcVideo, @Nullable ColumnInfo paramColumnInfo, int paramInt1, int paramInt2)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("key_video_info", paramUgcVideo);
    localIntent.putExtra("key_column_info", paramColumnInfo);
    localIntent.putExtra("key_from", paramInt1);
    PublicFragmentActivity.a(paramActivity, localIntent, EditVideoFragment.class, paramInt2);
  }
  
  public static void a(Activity paramActivity, qnz paramqnz, @Nullable ColumnInfo paramColumnInfo, int paramInt1, int paramInt2)
  {
    UgcVideo localUgcVideo = new UgcVideo();
    localUgcVideo.filePath = paramqnz.jdField_b_of_type_JavaLangString;
    localUgcVideo.duration = ((int)(paramqnz.d / 1000L));
    localUgcVideo.fileSize = paramqnz.jdField_b_of_type_Long;
    localUgcVideo.coverPath = paramqnz.e;
    localUgcVideo.width = paramqnz.a();
    localUgcVideo.height = paramqnz.b();
    a(paramActivity, localUgcVideo, paramColumnInfo, paramInt1, paramInt2);
  }
  
  private void a(boolean paramBoolean)
  {
    boolean bool = false;
    if ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing()))
    {
      if (!paramBoolean) {
        break label56;
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131718727);
    }
    for (;;)
    {
      UgcVideo localUgcVideo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo;
      if (!paramBoolean) {
        bool = true;
      }
      localUgcVideo.reprintDisable = bool;
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
      return;
      label56:
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131718917);
      QQToast.a(getActivity(), 2131718919, 0).a();
    }
  }
  
  private boolean a(View paramView, MotionEvent paramMotionEvent)
  {
    if ((paramView instanceof EditText))
    {
      int[] arrayOfInt = new int[2];
      int[] tmp14_12 = arrayOfInt;
      tmp14_12[0] = 0;
      int[] tmp18_14 = tmp14_12;
      tmp18_14[1] = 0;
      tmp18_14;
      paramView.getLocationInWindow(arrayOfInt);
      i = arrayOfInt[0];
      int j = arrayOfInt[1];
      int k = paramView.getHeight();
      int m = paramView.getWidth();
      if ((paramMotionEvent.getX() <= i - 80) || (paramMotionEvent.getX() >= m + i + 80) || (paramMotionEvent.getY() <= j - 25) || (paramMotionEvent.getY() >= k + j + 35)) {
        break label120;
      }
    }
    label120:
    for (int i = 1; i != 0; i = 0) {
      return false;
    }
    paramView.setFocusable(false);
    paramView.setFocusableInTouchMode(true);
    return true;
  }
  
  private void k()
  {
    ((LinearLayout.LayoutParams)((ViewGroup)this.jdField_a_of_type_AndroidViewView.findViewById(2131377964)).getLayoutParams()).setMargins(0, ImmersiveUtils.getStatusBarHeight(getActivity()), 0, 0);
    ((PressEffectImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131364340)).setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131372484));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131364891));
    ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
    localLayoutParams.height = (xin.a(getActivity()) * 9 / 16);
    this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    ((RoundBackgroundTextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131376346)).setOnClickListener(this);
    l();
    m();
    n();
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131378191);
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378198));
    this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131362128);
    this.jdField_a_of_type_AndroidViewView.findViewById(2131362129).setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetListView = ((ListView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378196));
    this.jdField_a_of_type_Qsz = new qsz(this);
    this.jdField_a_of_type_AndroidWidgetListView.setAdapter(this.jdField_a_of_type_Qsz);
    this.jdField_a_of_type_AndroidWidgetListView.setOnItemClickListener(new qsu(this));
  }
  
  private void l()
  {
    LimitWordCountEditText localLimitWordCountEditText = (LimitWordCountEditText)this.jdField_a_of_type_AndroidViewView.findViewById(2131377989);
    localLimitWordCountEditText.setCountLimit(qok.c());
    localLimitWordCountEditText.setDisableManualEnter(true);
    this.jdField_a_of_type_AndroidWidgetEditText = localLimitWordCountEditText.a();
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new qsv(this));
  }
  
  private void m()
  {
    View localView = this.jdField_a_of_type_AndroidViewView.findViewById(2131369605);
    localView.setOnClickListener(this);
    int i = qok.d();
    localView.setVisibility(i);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378614));
    if (i == 1)
    {
      if (qok.e())
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(2131718727);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.reprintDisable = false;
      }
    }
    else {
      return;
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setText(2131718917);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.reprintDisable = true;
  }
  
  private void n()
  {
    View localView = this.jdField_a_of_type_AndroidViewView.findViewById(2131369604);
    int i = qok.e();
    localView.setVisibility(i);
    this.jdField_a_of_type_ComTencentWidgetSwitch = ((Switch)this.jdField_a_of_type_AndroidViewView.findViewById(2131377303));
    if (i == 0)
    {
      boolean bool = qok.f();
      this.jdField_a_of_type_ComTencentWidgetSwitch.setChecked(bool);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.isRemindQQFriend = bool;
      this.jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(new qsw(this));
    }
  }
  
  private void o()
  {
    Object localObject3 = getArguments();
    this.jdField_a_of_type_Qtc.a(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
    if (localObject3 == null)
    {
      QLog.e("RIJUGC.EditVideoFragment", 1, "getArgument() is null.");
      return;
    }
    this.jdField_a_of_type_Int = ((Bundle)localObject3).getInt("key_from", 0);
    Object localObject1 = (UgcVideo)((Bundle)localObject3).getParcelable("key_video_info");
    if (localObject1 == null)
    {
      QLog.e("RIJUGC.EditVideoFragment", 2, "video param is null!");
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo = ((UgcVideo)localObject1);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.fromForReport = a(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.seqId = (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.filePath.hashCode() + "_" + System.currentTimeMillis() + "_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.insertTime = (System.currentTimeMillis() / 1000L);
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.coverPath))
    {
      localObject1 = URLDrawable.URLDrawableOptions.obtain();
      ColorDrawable localColorDrawable = new ColorDrawable(0);
      ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = localColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = localColorDrawable;
    }
    try
    {
      localObject1 = URLDrawable.getDrawable(new File(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.coverPath).toURI().toURL(), (URLDrawable.URLDrawableOptions)localObject1);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
      localObject3 = (ColumnInfo)((Bundle)localObject3).getParcelable("key_column_info");
      if (localObject3 != null)
      {
        i = ((ColumnInfo)localObject3).columnID;
        if (localObject3 == null) {
          break label450;
        }
        localObject1 = ((ColumnInfo)localObject3).title;
        this.jdField_a_of_type_Boolean = false;
        if ((i == 0) || (TextUtils.isEmpty((CharSequence)localObject1))) {
          this.jdField_a_of_type_Boolean = true;
        }
        if (!this.jdField_a_of_type_Boolean) {
          break label457;
        }
        this.jdField_b_of_type_AndroidViewView.setVisibility(8);
        this.jdField_c_of_type_AndroidViewView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetListView.setVisibility(0);
        this.jdField_a_of_type_Qtc.b();
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.filePath))
        {
          localObject1 = new File(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.filePath.trim());
          i = ((File)localObject1).getName().lastIndexOf('.');
          if ((i != -1) || (TextUtils.isEmpty(((File)localObject1).getName()))) {
            break label568;
          }
          this.jdField_a_of_type_AndroidWidgetEditText.setText(((File)localObject1).getName());
          q();
        }
        s();
        r();
      }
    }
    catch (MalformedURLException localMalformedURLException)
    {
      for (;;)
      {
        QLog.e("RIJUGC.EditVideoFragment", 1, "initData -> setVideoCoverFailed e:" + localMalformedURLException.toString());
        Object localObject2 = null;
        continue;
        int i = 0;
        continue;
        label450:
        localObject2 = "";
        continue;
        label457:
        this.jdField_b_of_type_AndroidViewView.setVisibility(0);
        this.jdField_c_of_type_AndroidViewView.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetListView.setVisibility(8);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.columnId = i;
        localObject2 = getResources().getDrawable(2130842649);
        ((Drawable)localObject2).setBounds(0, 0, xsm.a(BaseApplicationImpl.getContext(), 15.0F), xsm.a(BaseApplicationImpl.getContext(), 15.0F));
        this.jdField_c_of_type_AndroidWidgetTextView.setText(((ColumnInfo)localObject3).title);
        this.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(xsm.a(BaseApplicationImpl.getContext(), 5.0F));
        this.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawables((Drawable)localObject2, null, null, null);
        continue;
        label568:
        if (i > 0) {
          this.jdField_a_of_type_AndroidWidgetEditText.setText(((File)localObject2).getName().substring(0, i));
        }
      }
    }
  }
  
  private void p()
  {
    qun.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo);
  }
  
  private void q()
  {
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_AndroidWidgetEditText.getText().toString())) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.columnId != 0L)) {}
    for (int i = 1; i != 0; i = 0)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setAlpha(1.0F);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setAlpha(0.5F);
  }
  
  private void r()
  {
    if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.reprintDisable) {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(getResources().getString(2131718727));
    }
    while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.isRemindQQFriend)
    {
      this.jdField_a_of_type_ComTencentWidgetSwitch.setChecked(true);
      return;
      this.jdField_b_of_type_AndroidWidgetTextView.setText(getResources().getString(2131718917));
    }
    this.jdField_a_of_type_ComTencentWidgetSwitch.setChecked(false);
  }
  
  private void s()
  {
    if (bdin.b(getActivity()))
    {
      qok.a(getActivity(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.fileSize, new qsx(this), null);
      return;
    }
    qun.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo, true);
  }
  
  private void t()
  {
    nrt.a("0X800AC5E", a().a());
    getActivity().finish();
    p();
  }
  
  private void u()
  {
    nrt.a("0X800AC60", a().a());
    qok.a(getActivity(), 3);
  }
  
  private void v()
  {
    nrt.a("0X800AC5F", a().a());
    if (TextUtils.isEmpty(this.jdField_a_of_type_AndroidWidgetEditText.getText().toString()))
    {
      QQToast.a(getActivity(), 2131718889, 0).a();
      return;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.columnId == 0L)
    {
      QQToast.a(getActivity(), 2131718768, 0).a();
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.title = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.url)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.startUserWaitingTime = System.currentTimeMillis();
    }
    for (;;)
    {
      this.jdField_a_of_type_Qtc.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo);
      return;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.userWaitingTotalCostTime = 0L;
    }
  }
  
  private void w()
  {
    CoverSelectTabFragment.a(getActivity(), 10001, this.jdField_b_of_type_Int, this.jdField_a_of_type_Float, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo);
  }
  
  private void x()
  {
    View localView = LayoutInflater.from(getActivity()).inflate(2131560007, null);
    ((RelativeLayout)localView.findViewById(2131362542)).setOnClickListener(this);
    ((RelativeLayout)localView.findViewById(2131366733)).setOnClickListener(this);
    ((TextView)localView.findViewById(2131363925)).setOnClickListener(new qsy(this));
    ImageView localImageView1 = (ImageView)localView.findViewById(2131362544);
    ImageView localImageView2 = (ImageView)localView.findViewById(2131366735);
    if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.reprintDisable)
    {
      localImageView1.setVisibility(0);
      localImageView2.setVisibility(8);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidAppDialog = bhus.a(getActivity(), localView);
      this.jdField_a_of_type_AndroidAppDialog.show();
      return;
      localImageView1.setVisibility(8);
      localImageView2.setVisibility(0);
    }
  }
  
  public void a() {}
  
  public void a(int paramInt) {}
  
  public void a(int paramInt, String paramString)
  {
    QQToast.a(getActivity(), getString(2131719008), 0).a();
  }
  
  public void a(List<ColumnInfo> paramList, boolean paramBoolean)
  {
    if ((!paramList.isEmpty()) && (!paramBoolean))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructColumnInfo = ((ColumnInfo)paramList.get(0));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.columnId = ((ColumnInfo)paramList.get(0)).columnID;
    }
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructColumnInfo = ((ColumnInfo)this.jdField_a_of_type_JavaUtilArrayList.get(0));
    }
    this.jdField_a_of_type_Qsz.notifyDataSetChanged();
    q();
  }
  
  public void b() {}
  
  public void b(int paramInt, String paramString) {}
  
  public void c() {}
  
  public void c(int paramInt, String paramString) {}
  
  public void d() {}
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      View localView = getActivity().getCurrentFocus();
      if (a(localView, paramMotionEvent)) {
        ((InputMethodManager)getActivity().getSystemService("input_method")).hideSoftInputFromWindow(localView.getWindowToken(), 0);
      }
      return super.dispatchTouchEvent(paramMotionEvent);
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public void e() {}
  
  public void f() {}
  
  public void g() {}
  
  public void h()
  {
    this.jdField_a_of_type_Qtc.c();
  }
  
  public void i() {}
  
  public void j()
  {
    oxb.a().e();
    getActivity().finish();
    if ((this.jdField_a_of_type_Int == 1) && (qok.g() == 2))
    {
      String str = qok.a() + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.columnId;
      smk.a(getActivity(), "", str, null, false);
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Object localObject;
    URLDrawable.URLDrawableOptions localURLDrawableOptions;
    if ((paramInt1 == 10001) && (paramInt2 == -1) && (paramIntent != null))
    {
      localObject = paramIntent.getStringExtra("ARG_SELECTED_COVER");
      this.jdField_b_of_type_Int = paramIntent.getIntExtra("ARG_SELECTED_ITEM", 0);
      this.jdField_a_of_type_Float = paramIntent.getFloatExtra("ARG_INITIAL_PROGRESS", 0.0F);
      this.jdField_a_of_type_JavaLangString = paramIntent.getStringExtra("ARG_PLACEHOLDER_URL");
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.coverPath = ((String)localObject);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.coverUrl = "";
        localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        if ((this.jdField_a_of_type_AndroidWidgetImageView != null) && (this.jdField_a_of_type_AndroidWidgetImageView.getHeight() != 0) && (this.jdField_a_of_type_AndroidWidgetImageView.getWidth() != 0))
        {
          localURLDrawableOptions.mRequestHeight = this.jdField_a_of_type_AndroidWidgetImageView.getHeight();
          localURLDrawableOptions.mRequestWidth = this.jdField_a_of_type_AndroidWidgetImageView.getWidth();
        }
        paramIntent = new ColorDrawable(0);
        localURLDrawableOptions.mFailedDrawable = paramIntent;
        localURLDrawableOptions.mLoadingDrawable = paramIntent;
        paramIntent = null;
      }
    }
    try
    {
      localObject = URLDrawable.getDrawable(new File((String)localObject).toURI().toURL(), localURLDrawableOptions);
      paramIntent = (Intent)localObject;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      for (;;)
      {
        QLog.e("RIJUGC.EditVideoFragment", 1, "onActivityResult -> setVideoCoverFailed e:" + localMalformedURLException.toString());
      }
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramIntent);
    this.jdField_b_of_type_Boolean = true;
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    oxb.a().a(this.jdField_a_of_type_Qtx);
  }
  
  public boolean onBackEvent()
  {
    p();
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131372484: 
      v();
      return;
    case 2131364340: 
      t();
      return;
    case 2131364891: 
    case 2131376346: 
      w();
      return;
    case 2131369605: 
      x();
      return;
    case 2131362542: 
      a(true);
      return;
    case 2131366733: 
      a(false);
      return;
    }
    u();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(2131560006, paramViewGroup, false);
    if (getActivity() == null) {
      return null;
    }
    k();
    o();
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    oxb.a().b(this.jdField_a_of_type_Qtx);
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    this.jdField_a_of_type_Qtc.a();
  }
  
  public void onResume()
  {
    super.onResume();
    if ((this.jdField_a_of_type_Qtc != null) && (this.jdField_a_of_type_Boolean)) {
      this.jdField_a_of_type_Qtc.b();
    }
    ors.a(getActivity());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.editvideo.EditVideoFragment
 * JD-Core Version:    0.7.0.1
 */