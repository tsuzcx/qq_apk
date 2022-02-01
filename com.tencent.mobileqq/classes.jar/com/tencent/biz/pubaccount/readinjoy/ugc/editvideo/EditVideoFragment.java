package com.tencent.biz.pubaccount.readinjoy.ugc.editvideo;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
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
import bgnt;
import bkif;
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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import oat;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pha;
import phi;
import pmk;
import riw;
import rjh;
import rnv;
import rnw;
import rnx;
import rny;
import rnz;
import roa;
import rob;
import roc;
import roe;
import rof;
import rpc;
import rps;
import tlg;
import zby;
import zlx;

public class EditVideoFragment
  extends PublicBaseFragment
  implements View.OnClickListener, rnv
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private Context jdField_a_of_type_AndroidContentContext = BaseApplicationImpl.getContext();
  private View jdField_a_of_type_AndroidViewView;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private ListView jdField_a_of_type_AndroidWidgetListView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  @Nullable
  private ColumnInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructColumnInfo;
  private UgcVideo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo = new UgcVideo();
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString = "";
  private ArrayList<ColumnInfo> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private roc jdField_a_of_type_Roc;
  private rof jdField_a_of_type_Rof = new rof(new roe(pha.a()));
  private rpc jdField_a_of_type_Rpc = new rnw(this);
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = 2;
  private Dialog jdField_b_of_type_AndroidAppDialog;
  private View jdField_b_of_type_AndroidViewView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private View jdField_c_of_type_AndroidViewView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private TextView d;
  
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
  
  private String a(int paramInt)
  {
    String str = getResources().getString(2131717106);
    if (paramInt == UgcVideo.TYPE_PUBLIC) {
      str = rjh.e(this.jdField_a_of_type_AndroidContentContext);
    }
    do
    {
      return str;
      if (paramInt == UgcVideo.TYPE_NO_PUBLIC) {
        return rjh.g(this.jdField_a_of_type_AndroidContentContext);
      }
    } while (paramInt != UgcVideo.TYPE_PUBLIC_AND_REMIND);
    return rjh.c(this.jdField_a_of_type_AndroidContentContext);
  }
  
  private String a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return getResources().getString(2131716877);
    }
    return getResources().getString(2131717043);
  }
  
  @NotNull
  private phi a()
  {
    int n = 2;
    int i1 = 1;
    int i;
    int j;
    label56:
    int k;
    label75:
    int i2;
    switch (this.jdField_b_of_type_Int)
    {
    default: 
      i = -1;
      if (TextUtils.isEmpty(this.jdField_a_of_type_AndroidWidgetEditText.getText().toString()))
      {
        j = 0;
        if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructColumnInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructColumnInfo.columnID != 0)) {
          break label249;
        }
        k = 0;
        i2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.publicType;
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.reprintDisable) {
          break label266;
        }
      }
      break;
    }
    label266:
    for (int m = 1;; m = 0)
    {
      int i3 = a(this.jdField_a_of_type_Int);
      if (i3 == 4) {}
      for (;;)
      {
        phi localphi1 = new phi();
        phi localphi2 = localphi1.a("from", Integer.valueOf(i3)).a("user_type", Integer.valueOf(n)).a("video_flag", Integer.valueOf(1));
        if (this.jdField_b_of_type_Boolean) {}
        for (n = i1;; n = 0)
        {
          localphi2.a("cover_flag", Integer.valueOf(n)).a("cover_type", Integer.valueOf(i)).a("video_name_flag", Integer.valueOf(j)).a("column_flag", Integer.valueOf(k)).a("secret_flag", Integer.valueOf(i2)).a("reprint_flag", Integer.valueOf(m));
          return localphi1;
          i = 1;
          break;
          i = 2;
          break;
          i = 3;
          break;
          j = 1;
          break label56;
          label249:
          k = 1;
          break label75;
        }
        n = 1;
      }
    }
  }
  
  private void a(int paramInt)
  {
    if ((this.jdField_b_of_type_AndroidAppDialog != null) && (this.jdField_b_of_type_AndroidAppDialog.isShowing()))
    {
      if (paramInt != UgcVideo.TYPE_NO_PUBLIC) {
        break label66;
      }
      QQToast.a(getActivity(), 2131717092, 0).a();
    }
    for (;;)
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setText(a(paramInt));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.publicType = paramInt;
      this.jdField_b_of_type_AndroidAppDialog.dismiss();
      return;
      label66:
      QQToast.a(getActivity(), 2131717111, 0).a();
    }
  }
  
  public static void a(Activity paramActivity, UgcVideo paramUgcVideo, int paramInt, Intent paramIntent)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("key_video_info", paramUgcVideo);
    localIntent.putExtras(paramIntent);
    PublicFragmentActivity.a(paramActivity, localIntent, EditVideoFragment.class, paramInt);
  }
  
  public static void a(Activity paramActivity, riw paramriw, int paramInt, Intent paramIntent)
  {
    UgcVideo localUgcVideo = new UgcVideo();
    localUgcVideo.filePath = paramriw.jdField_b_of_type_JavaLangString;
    localUgcVideo.duration = ((int)(paramriw.d / 1000L));
    localUgcVideo.fileSize = paramriw.jdField_b_of_type_Long;
    localUgcVideo.coverPath = paramriw.e;
    localUgcVideo.width = paramriw.a();
    localUgcVideo.height = paramriw.b();
    a(paramActivity, localUgcVideo, paramInt, paramIntent);
  }
  
  private void a(@NotNull View paramView)
  {
    String str = rjh.c(this.jdField_a_of_type_AndroidContentContext);
    ((TextView)paramView.findViewById(2131373043)).setText(str);
    str = rjh.d(this.jdField_a_of_type_AndroidContentContext);
    ((TextView)paramView.findViewById(2131373040)).setText(str);
    str = rjh.e(this.jdField_a_of_type_AndroidContentContext);
    ((TextView)paramView.findViewById(2131373049)).setText(str);
    str = rjh.f(this.jdField_a_of_type_AndroidContentContext);
    ((TextView)paramView.findViewById(2131373044)).setText(str);
    str = rjh.g(this.jdField_a_of_type_AndroidContentContext);
    ((TextView)paramView.findViewById(2131371767)).setText(str);
    str = rjh.h(this.jdField_a_of_type_AndroidContentContext);
    ((TextView)paramView.findViewById(2131371764)).setText(str);
  }
  
  private void a(boolean paramBoolean)
  {
    boolean bool = false;
    if ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing()))
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(a(paramBoolean));
      if (!paramBoolean) {
        QQToast.a(getActivity(), 2131717045, 0).a();
      }
      UgcVideo localUgcVideo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo;
      if (!paramBoolean) {
        bool = true;
      }
      localUgcVideo.reprintDisable = bool;
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
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
  
  private void b()
  {
    ((LinearLayout.LayoutParams)((ViewGroup)this.jdField_a_of_type_AndroidViewView.findViewById(2131378804)).getLayoutParams()).setMargins(0, ImmersiveUtils.getStatusBarHeight(getActivity()), 0, 0);
    ((PressEffectImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131364551)).setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131373083));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131365125));
    ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
    localLayoutParams.height = (zby.a(getActivity()) * 9 / 16);
    this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    ((RoundBackgroundTextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131377133)).setOnClickListener(this);
    c();
    d();
    e();
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131379043);
    this.d = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379050));
    this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131362188);
    this.jdField_a_of_type_AndroidViewView.findViewById(2131362189).setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetListView = ((ListView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379048));
    this.jdField_a_of_type_Roc = new roc(this);
    this.jdField_a_of_type_AndroidWidgetListView.setAdapter(this.jdField_a_of_type_Roc);
    this.jdField_a_of_type_AndroidWidgetListView.setOnItemClickListener(new rnx(this));
  }
  
  private void b(@NotNull View paramView)
  {
    ((RelativeLayout)paramView.findViewById(2131373041)).setOnClickListener(this);
    ((RelativeLayout)paramView.findViewById(2131373045)).setOnClickListener(this);
    ((RelativeLayout)paramView.findViewById(2131371765)).setOnClickListener(this);
    ((TextView)paramView.findViewById(2131364128)).setOnClickListener(new rob(this));
  }
  
  private void c()
  {
    LimitWordCountEditText localLimitWordCountEditText = (LimitWordCountEditText)this.jdField_a_of_type_AndroidViewView.findViewById(2131378831);
    localLimitWordCountEditText.setCountLimit(rjh.d());
    localLimitWordCountEditText.setDisableManualEnter(true);
    this.jdField_a_of_type_AndroidWidgetEditText = localLimitWordCountEditText.a();
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new rny(this));
  }
  
  private void c(@NotNull View paramView)
  {
    ImageView localImageView1 = (ImageView)paramView.findViewById(2131373042);
    ImageView localImageView2 = (ImageView)paramView.findViewById(2131373047);
    paramView = (ImageView)paramView.findViewById(2131371766);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.publicType == UgcVideo.TYPE_PUBLIC_AND_REMIND)
    {
      localImageView1.setVisibility(0);
      localImageView2.setVisibility(8);
      paramView.setVisibility(8);
      return;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.publicType == UgcVideo.TYPE_NO_PUBLIC)
    {
      localImageView1.setVisibility(8);
      localImageView2.setVisibility(8);
      paramView.setVisibility(0);
      return;
    }
    localImageView1.setVisibility(8);
    localImageView2.setVisibility(0);
    paramView.setVisibility(8);
  }
  
  private void d()
  {
    View localView = this.jdField_a_of_type_AndroidViewView.findViewById(2131370011);
    int i = rjh.e();
    localView.setVisibility(i);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379465));
    if (i == 0)
    {
      boolean bool = rjh.h();
      this.jdField_b_of_type_AndroidWidgetTextView.setText(a(bool));
      localView.setOnClickListener(this);
    }
  }
  
  private void e()
  {
    View localView = this.jdField_a_of_type_AndroidViewView.findViewById(2131370016);
    int i = rjh.f();
    localView.setVisibility(i);
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379483));
    if (i == 0)
    {
      i = rjh.g();
      this.jdField_c_of_type_AndroidWidgetTextView.setText(a(i));
      localView.setOnClickListener(this);
    }
  }
  
  private void f()
  {
    boolean bool2 = true;
    Object localObject3 = getArguments();
    this.jdField_a_of_type_Rof.a(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
    if (localObject3 == null) {
      QLog.e("RIJUGC.EditVideoFragment", 1, "getArgument() is null.");
    }
    Object localObject1;
    do
    {
      return;
      this.jdField_a_of_type_Int = ((Bundle)localObject3).getInt("key_from", 0);
      this.jdField_a_of_type_JavaLangString = ((Bundle)localObject3).getString("arg_callback");
      localObject1 = (UgcVideo)((Bundle)localObject3).getParcelable("key_video_info");
      if (localObject1 != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("RIJUGC.EditVideoFragment", 2, "video param is null!");
    return;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo = ((UgcVideo)localObject1);
    g();
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
          break label428;
        }
        localObject1 = ((ColumnInfo)localObject3).title;
        bool1 = bool2;
        if (i != 0)
        {
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            break label435;
          }
          bool1 = bool2;
        }
        this.jdField_a_of_type_Boolean = bool1;
        if (!this.jdField_a_of_type_Boolean) {
          break label440;
        }
        this.jdField_b_of_type_AndroidViewView.setVisibility(8);
        this.jdField_c_of_type_AndroidViewView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetListView.setVisibility(0);
        this.jdField_a_of_type_Rof.b();
        k();
        j();
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
        label428:
        localObject2 = "";
        continue;
        label435:
        boolean bool1 = false;
        continue;
        label440:
        this.jdField_b_of_type_AndroidViewView.setVisibility(0);
        this.jdField_c_of_type_AndroidViewView.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetListView.setVisibility(8);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.columnId = i;
        localObject2 = getResources().getDrawable(2130842987);
        ((Drawable)localObject2).setBounds(0, 0, zlx.a(this.jdField_a_of_type_AndroidContentContext, 15.0F), zlx.a(this.jdField_a_of_type_AndroidContentContext, 15.0F));
        this.d.setText(((ColumnInfo)localObject3).title);
        this.d.setCompoundDrawablePadding(zlx.a(this.jdField_a_of_type_AndroidContentContext, 5.0F));
        this.d.setCompoundDrawables((Drawable)localObject2, null, null, null);
      }
    }
  }
  
  private void g()
  {
    UgcVideo localUgcVideo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo;
    if (!rjh.h()) {}
    for (boolean bool = true;; bool = false)
    {
      localUgcVideo.reprintDisable = bool;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.publicType = rjh.g();
      return;
    }
  }
  
  private void h()
  {
    rps.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo);
  }
  
  private void i()
  {
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_AndroidWidgetEditText.getText().toString())) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.columnId != 0L)) {}
    for (int i = 1; i != 0; i = 0)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setAlpha(1.0F);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setAlpha(0.5F);
  }
  
  private void j()
  {
    TextView localTextView = this.jdField_b_of_type_AndroidWidgetTextView;
    if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.reprintDisable) {}
    for (boolean bool = true;; bool = false)
    {
      localTextView.setText(a(bool));
      this.jdField_c_of_type_AndroidWidgetTextView.setText(a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.publicType));
      return;
    }
  }
  
  private void k()
  {
    if (bgnt.b(getActivity()))
    {
      rjh.a(getActivity(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.fileSize, new rnz(this), null);
      return;
    }
    rps.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo, true);
  }
  
  private void l()
  {
    oat.a("0X800AC5E", a().a());
    getActivity().finish();
    h();
  }
  
  private void m()
  {
    oat.a("0X800AC60", a().a("source", Integer.valueOf(2)).a());
    rjh.a(getActivity(), 3);
  }
  
  private void n()
  {
    oat.a("0X800AC5F", a().a());
    if (TextUtils.isEmpty(this.jdField_a_of_type_AndroidWidgetEditText.getText().toString()))
    {
      QQToast.a(getActivity(), 2131717017, 0).a();
      return;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.columnId == 0L)
    {
      QQToast.a(getActivity(), 2131716905, 0).a();
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.title = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.url))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.startUserWaitingTime = System.currentTimeMillis();
      if (this.jdField_a_of_type_Int != 4) {
        break label152;
      }
    }
    label152:
    for (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.uploadType = 1;; this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.uploadType = 0)
    {
      this.jdField_a_of_type_Rof.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo);
      return;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.userWaitingTotalCostTime = 0L;
      break;
    }
  }
  
  private void o()
  {
    CoverSelectTabFragment.a(getActivity(), 10001, this.jdField_b_of_type_Int, this.jdField_a_of_type_Float, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo);
  }
  
  private void p()
  {
    View localView = LayoutInflater.from(getActivity()).inflate(2131560154, null);
    ((RelativeLayout)localView.findViewById(2131362632)).setOnClickListener(this);
    ((RelativeLayout)localView.findViewById(2131366994)).setOnClickListener(this);
    ((TextView)localView.findViewById(2131364128)).setOnClickListener(new roa(this));
    ImageView localImageView1 = (ImageView)localView.findViewById(2131362634);
    ImageView localImageView2 = (ImageView)localView.findViewById(2131366996);
    if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.reprintDisable)
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
  
  private void q()
  {
    View localView = LayoutInflater.from(getActivity()).inflate(2131560153, null);
    a(localView);
    b(localView);
    c(localView);
    this.jdField_b_of_type_AndroidAppDialog = bkif.a(getActivity(), localView);
    this.jdField_b_of_type_AndroidAppDialog.show();
  }
  
  public void a()
  {
    pmk.a().f();
    if (this.jdField_a_of_type_Int == 1)
    {
      getActivity().finish();
      if (rjh.i() == 2)
      {
        localObject = rjh.a() + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.columnId;
        tlg.a(getActivity(), "", (String)localObject, null, false);
      }
      return;
    }
    Object localObject = new Intent();
    ((Intent)localObject).putExtra("key_column_id", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.columnId);
    ((Intent)localObject).putExtra("arg_callback", this.jdField_a_of_type_JavaLangString);
    getActivity().setResult(3, (Intent)localObject);
    getActivity().finish();
  }
  
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
      this.jdField_b_of_type_JavaLangString = paramIntent.getStringExtra("ARG_PLACEHOLDER_URL");
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
    pmk.a().a(this.jdField_a_of_type_Rpc);
  }
  
  public boolean onBackEvent()
  {
    h();
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      n();
      continue;
      l();
      continue;
      o();
      continue;
      p();
      continue;
      q();
      continue;
      a(true);
      continue;
      a(false);
      continue;
      a(UgcVideo.TYPE_PUBLIC_AND_REMIND);
      continue;
      a(UgcVideo.TYPE_PUBLIC);
      continue;
      a(UgcVideo.TYPE_NO_PUBLIC);
      continue;
      m();
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(2131560152, paramViewGroup, false);
    if (getActivity() == null) {}
    for (paramLayoutInflater = null;; paramLayoutInflater = this.jdField_a_of_type_AndroidViewView)
    {
      V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
      return paramLayoutInflater;
      b();
      f();
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    pmk.a().b(this.jdField_a_of_type_Rpc);
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    this.jdField_a_of_type_Rof.a();
  }
  
  public void onResume()
  {
    super.onResume();
    if ((this.jdField_a_of_type_Rof != null) && (this.jdField_a_of_type_Boolean)) {
      this.jdField_a_of_type_Rof.b();
    }
    pha.a(getActivity());
  }
  
  public void setCenterEmpty() {}
  
  public void setCenterError(int paramInt, String paramString) {}
  
  public void setCenterHide() {}
  
  public void setCenterLoading() {}
  
  public void setFooterError(int paramInt, String paramString) {}
  
  public void setFooterHasMore()
  {
    this.jdField_a_of_type_Rof.c();
  }
  
  public void setFooterHide() {}
  
  public void setFooterLoading() {}
  
  public void setFooterNoMore() {}
  
  public void setHeaderError(int paramInt, String paramString)
  {
    QQToast.a(getActivity(), getString(2131717129), 0).a();
  }
  
  public void setHeaderLoading() {}
  
  public void setHeaderSuccess() {}
  
  public void setListData(List<ColumnInfo> paramList, boolean paramBoolean)
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
    this.jdField_a_of_type_Roc.notifyDataSetChanged();
    i();
  }
  
  public void setTotal(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.editvideo.EditVideoFragment
 * JD-Core Version:    0.7.0.1
 */