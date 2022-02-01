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
import android.text.Editable;
import android.text.SpannableStringBuilder;
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
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import bjon;
import com.tencent.biz.pubaccount.readinjoy.struct.ColumnInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TopicInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.UgcVideo;
import com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyTopicSelectionFragment;
import com.tencent.biz.pubaccount.readinjoy.ugc.coverselect.CoverSelectTabFragment;
import com.tencent.biz.pubaccount.readinjoy.view.text.TopicSpan;
import com.tencent.biz.pubaccount.readinjoy.widgets.LimitWordCountEditText;
import com.tencent.biz.pubaccount.readinjoy.widgets.RoundBackgroundTextView;
import com.tencent.biz.qqstory.takevideo.doodle.util.DisplayUtil;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.utils.NetworkUtil;
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
import mqq.os.MqqHandler;
import odq;
import okj;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pay;
import pbg;
import pim;
import pkp;
import rgo;
import rha;
import rjl;
import rjt;
import rlq;
import rlr;
import rls;
import rlt;
import rlu;
import rlv;
import rlw;
import rlx;
import rly;
import rma;
import rmb;
import rmy;
import rno;
import tgc;

public class EditVideoFragment
  extends PublicBaseFragment
  implements View.OnClickListener, rlq
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
  private LimitWordCountEditText jdField_a_of_type_ComTencentBizPubaccountReadinjoyWidgetsLimitWordCountEditText;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString = "";
  private ArrayList<ColumnInfo> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private rly jdField_a_of_type_Rly;
  private rmb jdField_a_of_type_Rmb = new rmb(new rma(pay.a()));
  private rmy jdField_a_of_type_Rmy = new rlr(this);
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
    String str = getResources().getString(2131717456);
    if (paramInt == UgcVideo.TYPE_PUBLIC) {
      str = rha.f(this.jdField_a_of_type_AndroidContentContext);
    }
    do
    {
      return str;
      if (paramInt == UgcVideo.TYPE_NO_PUBLIC) {
        return rha.h(this.jdField_a_of_type_AndroidContentContext);
      }
    } while (paramInt != UgcVideo.TYPE_PUBLIC_AND_REMIND);
    return rha.d(this.jdField_a_of_type_AndroidContentContext);
  }
  
  private String a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return getResources().getString(2131717228);
    }
    return getResources().getString(2131717397);
  }
  
  @NotNull
  private pbg a()
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
          break label281;
        }
        k = 0;
        i2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.publicType;
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.reprintDisable) {
          break label303;
        }
      }
      break;
    }
    label165:
    label303:
    for (int m = 1;; m = 0)
    {
      int i3 = a(this.jdField_a_of_type_Int);
      if (i3 == 4) {}
      for (;;)
      {
        pbg localpbg1 = new pbg();
        pbg localpbg2 = localpbg1.a("from", Integer.valueOf(i3)).a("user_type", Integer.valueOf(n)).a("video_flag", Integer.valueOf(1));
        if (this.jdField_b_of_type_Boolean)
        {
          n = 1;
          localpbg2 = localpbg2.a("cover_flag", Integer.valueOf(n)).a("cover_type", Integer.valueOf(i)).a("video_name_flag", Integer.valueOf(j)).a("column_flag", Integer.valueOf(k)).a("secret_flag", Integer.valueOf(i2)).a("reprint_flag", Integer.valueOf(m));
          if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructColumnInfo == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructColumnInfo.columnID == 0)) {
            break label292;
          }
        }
        for (i = i1;; i = 0)
        {
          localpbg2.a("with_column", Integer.valueOf(i));
          return localpbg1;
          i = 1;
          break;
          i = 2;
          break;
          i = 3;
          break;
          j = 1;
          break label56;
          k = 1;
          break label75;
          n = 0;
          break label165;
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
      QQToast.a(getActivity(), 2131717442, 0).a();
    }
    for (;;)
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setText(a(paramInt));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.publicType = paramInt;
      this.jdField_b_of_type_AndroidAppDialog.dismiss();
      return;
      label66:
      QQToast.a(getActivity(), 2131717461, 0).a();
    }
  }
  
  public static void a(Activity paramActivity, UgcVideo paramUgcVideo, int paramInt, Intent paramIntent)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("key_video_info", paramUgcVideo);
    localIntent.putExtras(paramIntent);
    PublicFragmentActivity.a(paramActivity, localIntent, EditVideoFragment.class, paramInt);
  }
  
  public static void a(Activity paramActivity, rgo paramrgo, int paramInt, Intent paramIntent)
  {
    UgcVideo localUgcVideo = new UgcVideo();
    localUgcVideo.filePath = paramrgo.jdField_b_of_type_JavaLangString;
    localUgcVideo.duration = ((int)(paramrgo.d / 1000L));
    localUgcVideo.fileSize = paramrgo.jdField_b_of_type_Long;
    localUgcVideo.coverPath = paramrgo.e;
    localUgcVideo.width = paramrgo.a();
    localUgcVideo.height = paramrgo.b();
    a(paramActivity, localUgcVideo, paramInt, paramIntent);
  }
  
  private void a(Intent paramIntent)
  {
    Object localObject = paramIntent.getStringExtra("ARG_SELECTED_COVER");
    this.jdField_b_of_type_Int = paramIntent.getIntExtra("ARG_SELECTED_ITEM", 0);
    this.jdField_a_of_type_Float = paramIntent.getFloatExtra("ARG_INITIAL_PROGRESS", 0.0F);
    this.jdField_b_of_type_JavaLangString = paramIntent.getStringExtra("ARG_PLACEHOLDER_URL");
    URLDrawable.URLDrawableOptions localURLDrawableOptions;
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (this.jdField_a_of_type_AndroidWidgetImageView != null))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.coverPath = ((String)localObject);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.coverUrl = "";
      localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      if ((this.jdField_a_of_type_AndroidWidgetImageView.getHeight() != 0) && (this.jdField_a_of_type_AndroidWidgetImageView.getWidth() != 0))
      {
        localURLDrawableOptions.mRequestHeight = this.jdField_a_of_type_AndroidWidgetImageView.getHeight();
        localURLDrawableOptions.mRequestWidth = this.jdField_a_of_type_AndroidWidgetImageView.getWidth();
      }
      paramIntent = new ColorDrawable(0);
      localURLDrawableOptions.mFailedDrawable = paramIntent;
      localURLDrawableOptions.mLoadingDrawable = paramIntent;
      paramIntent = null;
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
  
  private void a(@NotNull View paramView)
  {
    String str = rha.d(this.jdField_a_of_type_AndroidContentContext);
    ((TextView)paramView.findViewById(2131373126)).setText(str);
    str = rha.e(this.jdField_a_of_type_AndroidContentContext);
    ((TextView)paramView.findViewById(2131373123)).setText(str);
    str = rha.f(this.jdField_a_of_type_AndroidContentContext);
    ((TextView)paramView.findViewById(2131373132)).setText(str);
    str = rha.g(this.jdField_a_of_type_AndroidContentContext);
    ((TextView)paramView.findViewById(2131373127)).setText(str);
    str = rha.h(this.jdField_a_of_type_AndroidContentContext);
    ((TextView)paramView.findViewById(2131371840)).setText(str);
    str = rha.i(this.jdField_a_of_type_AndroidContentContext);
    ((TextView)paramView.findViewById(2131371837)).setText(str);
  }
  
  private void a(boolean paramBoolean)
  {
    boolean bool = false;
    if ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing()))
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(a(paramBoolean));
      if (!paramBoolean) {
        QQToast.a(getActivity(), 2131717399, 0).a();
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
    ((LinearLayout.LayoutParams)((ViewGroup)this.jdField_a_of_type_AndroidViewView.findViewById(2131378734)).getLayoutParams()).setMargins(0, ImmersiveUtils.getStatusBarHeight(getActivity()), 0, 0);
    ((PressEffectImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131364627)).setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131373162));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131365196));
    Object localObject = this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).height = (DisplayUtil.getWindowScreenWidth(getActivity()) * 9 / 16);
    this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    ((RoundBackgroundTextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131377023)).setOnClickListener(this);
    c();
    d();
    e();
    localObject = (LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131370118);
    View localView = this.jdField_a_of_type_AndroidViewView.findViewById(2131365670);
    ((LinearLayout)localObject).setOnClickListener(this);
    if (rjt.b())
    {
      ((LinearLayout)localObject).setVisibility(0);
      localView.setVisibility(0);
      odq.a("0X800B24A", "");
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131378976);
      this.d = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378983));
      this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131362197);
      this.jdField_a_of_type_AndroidViewView.findViewById(2131362198).setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetListView = ((ListView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378981));
      if (rha.k())
      {
        this.jdField_a_of_type_Rly = new rly(this);
        this.jdField_a_of_type_AndroidWidgetListView.setAdapter(this.jdField_a_of_type_Rly);
        this.jdField_a_of_type_AndroidWidgetListView.setOnItemClickListener(new rls(this));
      }
      return;
      ((LinearLayout)localObject).setVisibility(8);
      localView.setVisibility(8);
    }
  }
  
  private void b(Intent paramIntent)
  {
    paramIntent = (TopicInfo)paramIntent.getParcelableExtra("EXTRA_SELECTED_TOPIC");
    if ((this.jdField_a_of_type_AndroidWidgetEditText == null) || (paramIntent == null)) {}
    Editable localEditable;
    do
    {
      return;
      j = this.jdField_a_of_type_AndroidWidgetEditText.getSelectionStart();
      localEditable = this.jdField_a_of_type_AndroidWidgetEditText.getEditableText();
    } while (localEditable == null);
    int i = j;
    if (!TextUtils.isEmpty(localEditable.toString()))
    {
      i = j;
      if (j > 0)
      {
        i = j;
        if (localEditable.toString().substring(j - 1, j).equals("#"))
        {
          localEditable.delete(j - 1, j);
          i = j - 1;
          this.jdField_a_of_type_AndroidWidgetEditText.setSelection(i);
        }
      }
    }
    TopicSpan localTopicSpan = new TopicSpan(-12541697, paramIntent, new rlu(this));
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(paramIntent.a() + " ");
    localSpannableStringBuilder.setSpan(localTopicSpan, 0, localSpannableStringBuilder.length(), 33);
    if (localEditable.length() + localSpannableStringBuilder.length() > this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyWidgetsLimitWordCountEditText.a())
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131717730, 1).b(getResources().getDimensionPixelSize(2131299076));
      return;
    }
    localEditable.insert(i, localSpannableStringBuilder);
    int j = localSpannableStringBuilder.length();
    this.jdField_a_of_type_AndroidWidgetEditText.setSelection(i + j);
    odq.a("0X800B24C", new pbg().a("topic_id", Long.valueOf(paramIntent.a())).a());
  }
  
  private void b(@NotNull View paramView)
  {
    ((RelativeLayout)paramView.findViewById(2131373124)).setOnClickListener(this);
    ((RelativeLayout)paramView.findViewById(2131373128)).setOnClickListener(this);
    ((RelativeLayout)paramView.findViewById(2131371838)).setOnClickListener(this);
    ((TextView)paramView.findViewById(2131364191)).setOnClickListener(new rlx(this));
  }
  
  private void c()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyWidgetsLimitWordCountEditText = ((LimitWordCountEditText)this.jdField_a_of_type_AndroidViewView.findViewById(2131378762));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyWidgetsLimitWordCountEditText.setCountLimit(rha.f());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyWidgetsLimitWordCountEditText.setDisableManualEnter(true);
    this.jdField_a_of_type_AndroidWidgetEditText = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyWidgetsLimitWordCountEditText.a();
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new rlt(this));
  }
  
  private void c(@NotNull View paramView)
  {
    ImageView localImageView1 = (ImageView)paramView.findViewById(2131373125);
    ImageView localImageView2 = (ImageView)paramView.findViewById(2131373130);
    paramView = (ImageView)paramView.findViewById(2131371839);
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
    View localView = this.jdField_a_of_type_AndroidViewView.findViewById(2131370108);
    int i = rjt.a();
    localView.setVisibility(i);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379414));
    if (i == 0)
    {
      boolean bool = rjt.a();
      this.jdField_b_of_type_AndroidWidgetTextView.setText(a(bool));
      localView.setOnClickListener(this);
    }
  }
  
  private void e()
  {
    View localView = this.jdField_a_of_type_AndroidViewView.findViewById(2131370113);
    int i = rha.g();
    localView.setVisibility(i);
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379433));
    if (i == 0)
    {
      i = rha.h();
      this.jdField_c_of_type_AndroidWidgetTextView.setText(a(i));
      localView.setOnClickListener(this);
    }
  }
  
  private void f()
  {
    Object localObject3 = getArguments();
    this.jdField_a_of_type_Rmb.a(this);
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
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.seqId = (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.filePath.hashCode() + "_" + System.currentTimeMillis() + "_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
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
      if (rha.c())
      {
        i = 0;
        if (localObject3 == null) {
          break label403;
        }
        i = ((ColumnInfo)localObject3).columnID;
        if (localObject3 == null) {
          break label406;
        }
        localObject1 = ((ColumnInfo)localObject3).title;
        if (!rha.k()) {
          break label526;
        }
        this.jdField_a_of_type_Boolean = TextUtils.isEmpty((CharSequence)localObject1);
        if (!this.jdField_a_of_type_Boolean) {
          break label412;
        }
        this.jdField_b_of_type_AndroidViewView.setVisibility(8);
        this.jdField_c_of_type_AndroidViewView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetListView.setVisibility(0);
        this.jdField_a_of_type_Rmb.b();
        m();
        l();
      }
    }
    catch (MalformedURLException localMalformedURLException)
    {
      for (;;)
      {
        QLog.e("RIJUGC.EditVideoFragment", 1, "initData -> setVideoCoverFailed e:" + localMalformedURLException.toString());
        Object localObject2 = null;
        continue;
        int i = -1;
        continue;
        label403:
        continue;
        label406:
        localObject2 = "";
        continue;
        label412:
        this.jdField_b_of_type_AndroidViewView.setVisibility(0);
        this.jdField_c_of_type_AndroidViewView.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetListView.setVisibility(8);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.columnId = i;
        localObject2 = getResources().getDrawable(2130843060);
        ((Drawable)localObject2).setBounds(0, 0, UIUtils.dip2px(this.jdField_a_of_type_AndroidContentContext, 15.0F), UIUtils.dip2px(this.jdField_a_of_type_AndroidContentContext, 15.0F));
        this.d.setText(((ColumnInfo)localObject3).title);
        this.d.setCompoundDrawablePadding(UIUtils.dip2px(this.jdField_a_of_type_AndroidContentContext, 5.0F));
        this.d.setCompoundDrawables((Drawable)localObject2, null, null, null);
        continue;
        label526:
        this.jdField_b_of_type_AndroidViewView.setVisibility(8);
        this.jdField_c_of_type_AndroidViewView.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetListView.setVisibility(8);
      }
    }
  }
  
  private void g()
  {
    UgcVideo localUgcVideo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo;
    if (!rjt.a()) {}
    for (boolean bool = true;; bool = false)
    {
      localUgcVideo.reprintDisable = bool;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.publicType = rha.h();
      return;
    }
  }
  
  private void h()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.columnId != 0L)
    {
      getActivity().finish();
      if (rha.j() == 2)
      {
        localObject = rha.a() + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.columnId;
        tgc.a(getActivity(), "", (String)localObject, new Bundle(), false);
      }
      return;
    }
    Object localObject = new Intent();
    ((Intent)localObject).putExtra("key_column_id", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.columnId);
    ((Intent)localObject).putExtra("arg_callback", this.jdField_a_of_type_JavaLangString);
    getActivity().setResult(3, (Intent)localObject);
    getActivity().finish();
  }
  
  private void i()
  {
    int i = rha.b();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.columnId != 0L)
    {
      getActivity().finish();
      if (rha.j() == 2)
      {
        String str = rha.a() + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.columnId;
        tgc.a(getActivity(), "", str, new Bundle(), false);
      }
      return;
    }
    if (i == 2)
    {
      QLog.d("RIJUGC.EditVideoFragment", 2, "closeView | publish video without column ");
      ThreadManager.getUIHandler().postDelayed(new EditVideoFragment.5(this), 500L);
      return;
    }
    getActivity().finish();
    okj.a((QQAppInterface)pay.a(), getActivity(), 0, 0, null);
  }
  
  private void j()
  {
    rno.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo);
  }
  
  private void k()
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_AndroidWidgetEditText.getText().toString())) {}
    for (int i = 1; i != 0; i = 0)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setAlpha(1.0F);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setAlpha(0.5F);
  }
  
  private void l()
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
  
  private void m()
  {
    if (NetworkUtil.isMobileNetWork(getActivity()))
    {
      rha.a(getActivity(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.fileSize, new rlv(this), null);
      return;
    }
    rno.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo, true);
  }
  
  private void n()
  {
    odq.a("0X800B24B", "");
    Intent localIntent = new Intent();
    localIntent.putExtra("searchTopicFrom", 1);
    PublicFragmentActivity.a(this, localIntent, ReadInJoyTopicSelectionFragment.class, 20001);
  }
  
  private void o()
  {
    odq.a("0X800AC5E", a().a());
    getActivity().finish();
    j();
  }
  
  private void p()
  {
    odq.a("0X800AC60", a().a("source", Integer.valueOf(2)).a());
    rha.a(getActivity(), 3);
  }
  
  private void q()
  {
    odq.a("0X800AC5F", a().a());
    if (TextUtils.isEmpty(this.jdField_a_of_type_AndroidWidgetEditText.getText().toString()))
    {
      QQToast.a(getActivity(), 2131717370, 0).a();
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.title = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.url))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.startUserWaitingTime = System.currentTimeMillis();
      if (this.jdField_a_of_type_Int != 4) {
        break label157;
      }
    }
    label157:
    for (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.uploadType = 1;; this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.uploadType = 0)
    {
      ArrayList localArrayList = new ArrayList();
      rjl.a(this.jdField_a_of_type_AndroidWidgetEditText, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), false, localArrayList);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.multiTitleStruct = localArrayList;
      this.jdField_a_of_type_Rmb.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo);
      return;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.userWaitingTotalCostTime = 0L;
      break;
    }
  }
  
  private void r()
  {
    CoverSelectTabFragment.a(getActivity(), 10001, this.jdField_b_of_type_Int, this.jdField_a_of_type_Float, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo);
  }
  
  private void s()
  {
    View localView = LayoutInflater.from(getActivity()).inflate(2131560173, null);
    ((RelativeLayout)localView.findViewById(2131362651)).setOnClickListener(this);
    ((RelativeLayout)localView.findViewById(2131367062)).setOnClickListener(this);
    ((TextView)localView.findViewById(2131364191)).setOnClickListener(new rlw(this));
    ImageView localImageView1 = (ImageView)localView.findViewById(2131362653);
    ImageView localImageView2 = (ImageView)localView.findViewById(2131367064);
    if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.reprintDisable)
    {
      localImageView1.setVisibility(0);
      localImageView2.setVisibility(8);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidAppDialog = bjon.a(getActivity(), localView);
      this.jdField_a_of_type_AndroidAppDialog.show();
      return;
      localImageView1.setVisibility(8);
      localImageView2.setVisibility(0);
    }
  }
  
  private void t()
  {
    View localView = LayoutInflater.from(getActivity()).inflate(2131560172, null);
    a(localView);
    b(localView);
    c(localView);
    this.jdField_b_of_type_AndroidAppDialog = bjon.a(getActivity(), localView);
    this.jdField_b_of_type_AndroidAppDialog.show();
  }
  
  public void a()
  {
    pkp.a().f();
    if (getActivity() == null)
    {
      QLog.d("RIJUGC.EditVideoFragment", 2, "closeView | activity is null");
      return;
    }
    if (this.jdField_a_of_type_Int == 1)
    {
      i();
      return;
    }
    h();
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
    if ((paramInt2 != -1) || (paramIntent == null)) {}
    do
    {
      return;
      if (paramInt1 == 10001)
      {
        a(paramIntent);
        return;
      }
    } while (paramInt1 != 20001);
    b(paramIntent);
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    pkp.a().a(this.jdField_a_of_type_Rmy);
  }
  
  public boolean onBackEvent()
  {
    j();
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
      q();
      continue;
      o();
      continue;
      r();
      continue;
      s();
      continue;
      t();
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
      p();
      continue;
      if (rjt.b()) {
        n();
      }
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(2131560171, paramViewGroup, false);
    if (getActivity() == null) {}
    for (paramLayoutInflater = null;; paramLayoutInflater = this.jdField_a_of_type_AndroidViewView)
    {
      V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
      return paramLayoutInflater;
      b();
      f();
      pim.a.a(getActivity());
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    pkp.a().b(this.jdField_a_of_type_Rmy);
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    this.jdField_a_of_type_Rmb.a();
  }
  
  public void onResume()
  {
    super.onResume();
    if ((this.jdField_a_of_type_Rmb != null) && (this.jdField_a_of_type_Boolean)) {
      this.jdField_a_of_type_Rmb.b();
    }
    pay.a(getActivity());
  }
  
  public void setCenterEmpty() {}
  
  public void setCenterError(int paramInt, String paramString) {}
  
  public void setCenterHide() {}
  
  public void setCenterLoading() {}
  
  public void setFooterError(int paramInt, String paramString) {}
  
  public void setFooterHasMore()
  {
    this.jdField_a_of_type_Rmb.c();
  }
  
  public void setFooterHide() {}
  
  public void setFooterLoading() {}
  
  public void setFooterNoMore() {}
  
  public void setHeaderError(int paramInt, String paramString)
  {
    QQToast.a(getActivity(), getString(2131717479), 0).a();
  }
  
  public void setHeaderLoading() {}
  
  public void setHeaderSuccess() {}
  
  public void setListData(List<ColumnInfo> paramList, boolean paramBoolean)
  {
    if ((!paramList.isEmpty()) && (!paramBoolean) && (rha.c()))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructColumnInfo = ((ColumnInfo)paramList.get(0));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.columnId = ((ColumnInfo)paramList.get(0)).columnID;
    }
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
    if ((this.jdField_a_of_type_JavaUtilArrayList.size() > 0) && (rha.c())) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructColumnInfo = ((ColumnInfo)this.jdField_a_of_type_JavaUtilArrayList.get(0));
    }
    this.jdField_a_of_type_Rly.notifyDataSetChanged();
    k();
  }
  
  public void setTotal(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.editvideo.EditVideoFragment
 * JD-Core Version:    0.7.0.1
 */