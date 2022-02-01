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
import androidx.annotation.VisibleForTesting;
import androidx.core.content.ContextCompat;
import anvx;
import bkzz;
import com.tencent.biz.pubaccount.readinjoy.biu.AtFriendsSpan;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule;
import com.tencent.biz.pubaccount.readinjoy.struct.ColumnInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadInJoyUserInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TopicInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.UgcVideo;
import com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyTopicSelectionFragment;
import com.tencent.biz.pubaccount.readinjoy.ugc.coverselect.CoverSelectTabFragment;
import com.tencent.biz.pubaccount.readinjoy.ugc.selectmember.ReadInJoySelectMemberFragment;
import com.tencent.biz.pubaccount.readinjoy.ugc.selectmember.ResultRecord;
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
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.OnLocationListener;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.troop.activity.TroopBarPublishLocationSelectActivity;
import com.tencent.mobileqq.troop.data.TroopBarPOI;
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
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import olh;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import osg;
import pkh;
import pnn;
import pqg;
import pqu;
import ptj;
import pvm;
import rsv;
import rth;
import rvy;
import rwg;
import ryd;
import rye;
import ryf;
import ryg;
import ryh;
import ryi;
import ryj;
import ryk;
import ryl;
import rym;
import ryn;
import ryp;
import ryq;
import rzn;
import sad;
import tto;

public class EditVideoFragment
  extends PublicBaseFragment
  implements View.OnClickListener, ryd
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
  protected SosoInterface.OnLocationListener a;
  protected TroopBarPOI a;
  private String jdField_a_of_type_JavaLangString = "";
  private ArrayList<ColumnInfo> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private JSONObject jdField_a_of_type_OrgJsonJSONObject = new JSONObject();
  private ryn jdField_a_of_type_Ryn;
  private ryq jdField_a_of_type_Ryq = new ryq(new ryp(pnn.a()));
  private rzn jdField_a_of_type_Rzn = new rye(this);
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = 2;
  private Dialog jdField_b_of_type_AndroidAppDialog;
  private View jdField_b_of_type_AndroidViewView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private View jdField_c_of_type_AndroidViewView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private final String jdField_c_of_type_JavaLangString = "latitude";
  private View jdField_d_of_type_AndroidViewView;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private final String jdField_d_of_type_JavaLangString = "longitude";
  private TextView jdField_e_of_type_AndroidWidgetTextView;
  private final String jdField_e_of_type_JavaLangString = "is_user_selected";
  
  private int a(int paramInt)
  {
    if (paramInt == 1) {
      return 2;
    }
    if (paramInt == 2) {
      return 1;
    }
    return 0;
  }
  
  private String a(int paramInt)
  {
    String str = getResources().getString(2131717822);
    if (paramInt == UgcVideo.TYPE_PUBLIC) {
      str = rth.f(this.jdField_a_of_type_AndroidContentContext);
    }
    do
    {
      return str;
      if (paramInt == UgcVideo.TYPE_NO_PUBLIC) {
        return rth.h(this.jdField_a_of_type_AndroidContentContext);
      }
    } while (paramInt != UgcVideo.TYPE_PUBLIC_AND_REMIND);
    return rth.d(this.jdField_a_of_type_AndroidContentContext);
  }
  
  private String a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return getResources().getString(2131717592);
    }
    return getResources().getString(2131717763);
  }
  
  @NotNull
  private pqg a()
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
      int i3 = b(this.jdField_a_of_type_Int);
      if (i3 == 4) {}
      for (;;)
      {
        pqg localpqg1 = new pqg();
        pqg localpqg2 = localpqg1.a("from", Integer.valueOf(i3)).a("user_type", Integer.valueOf(n)).a("video_flag", Integer.valueOf(1));
        if (this.jdField_b_of_type_Boolean)
        {
          n = 1;
          localpqg2 = localpqg2.a("cover_flag", Integer.valueOf(n)).a("cover_type", Integer.valueOf(i)).a("video_name_flag", Integer.valueOf(j)).a("column_flag", Integer.valueOf(k)).a("secret_flag", Integer.valueOf(i2)).a("reprint_flag", Integer.valueOf(m));
          if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructColumnInfo == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructColumnInfo.columnID == 0)) {
            break label292;
          }
        }
        for (i = i1;; i = 0)
        {
          localpqg2.a("with_column", Integer.valueOf(i));
          return localpqg1;
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
      QQToast.a(getActivity(), 2131717808, 0).a();
    }
    for (;;)
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setText(a(paramInt));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.publicType = paramInt;
      this.jdField_b_of_type_AndroidAppDialog.dismiss();
      return;
      label66:
      QQToast.a(getActivity(), 2131717827, 0).a();
    }
  }
  
  public static void a(Activity paramActivity, UgcVideo paramUgcVideo, int paramInt, Intent paramIntent)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("key_video_info", paramUgcVideo);
    localIntent.putExtras(paramIntent);
    PublicFragmentActivity.a(paramActivity, localIntent, EditVideoFragment.class, paramInt);
  }
  
  public static void a(Activity paramActivity, rsv paramrsv, int paramInt, Intent paramIntent)
  {
    UgcVideo localUgcVideo = new UgcVideo();
    localUgcVideo.filePath = paramrsv.jdField_b_of_type_JavaLangString;
    localUgcVideo.duration = ((int)(paramrsv.d / 1000L));
    localUgcVideo.fileSize = paramrsv.jdField_b_of_type_Long;
    localUgcVideo.coverPath = paramrsv.jdField_e_of_type_JavaLangString;
    localUgcVideo.width = paramrsv.a();
    localUgcVideo.height = paramrsv.b();
    a(paramActivity, localUgcVideo, paramInt, paramIntent);
  }
  
  private void a(@NotNull View paramView)
  {
    String str = rth.d(this.jdField_a_of_type_AndroidContentContext);
    ((TextView)paramView.findViewById(2131373337)).setText(str);
    str = rth.e(this.jdField_a_of_type_AndroidContentContext);
    ((TextView)paramView.findViewById(2131373334)).setText(str);
    str = rth.f(this.jdField_a_of_type_AndroidContentContext);
    ((TextView)paramView.findViewById(2131373343)).setText(str);
    str = rth.g(this.jdField_a_of_type_AndroidContentContext);
    ((TextView)paramView.findViewById(2131373338)).setText(str);
    str = rth.h(this.jdField_a_of_type_AndroidContentContext);
    ((TextView)paramView.findViewById(2131372030)).setText(str);
    str = rth.i(this.jdField_a_of_type_AndroidContentContext);
    ((TextView)paramView.findViewById(2131372027)).setText(str);
  }
  
  private void a(boolean paramBoolean)
  {
    boolean bool = false;
    if ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing()))
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(a(paramBoolean));
      if (!paramBoolean) {
        QQToast.a(getActivity(), 2131717765, 0).a();
      }
      UgcVideo localUgcVideo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo;
      if (!paramBoolean) {
        bool = true;
      }
      localUgcVideo.reprintDisable = bool;
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
  }
  
  private boolean a()
  {
    if (ContextCompat.checkSelfPermission(getActivity(), "android.permission.ACCESS_FINE_LOCATION") == -1) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        getActivity().requestPermissions(new ryi(this), 40001, new String[] { "android.permission.ACCESS_FINE_LOCATION" });
      }
      if (ContextCompat.checkSelfPermission(getActivity(), "android.permission.ACCESS_FINE_LOCATION") == -1) {
        break;
      }
      return true;
    }
    return false;
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
  
  private int b(int paramInt)
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
  
  private void b(@NotNull View paramView)
  {
    ((RelativeLayout)paramView.findViewById(2131373335)).setOnClickListener(this);
    ((RelativeLayout)paramView.findViewById(2131373339)).setOnClickListener(this);
    ((RelativeLayout)paramView.findViewById(2131372028)).setOnClickListener(this);
    ((TextView)paramView.findViewById(2131364268)).setOnClickListener(new ryf(this));
  }
  
  private void c(Intent paramIntent)
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
  
  private void c(@NotNull View paramView)
  {
    ImageView localImageView1 = (ImageView)paramView.findViewById(2131373336);
    ImageView localImageView2 = (ImageView)paramView.findViewById(2131373341);
    paramView = (ImageView)paramView.findViewById(2131372029);
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
  
  private void d(Intent paramIntent)
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
    TopicSpan localTopicSpan = new TopicSpan(-12541697, paramIntent, new ryk(this));
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(paramIntent.a() + " ");
    localSpannableStringBuilder.setSpan(localTopicSpan, 0, localSpannableStringBuilder.length(), 33);
    if (localEditable.length() + localSpannableStringBuilder.length() > this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyWidgetsLimitWordCountEditText.a())
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131718111, 1).b(getResources().getDimensionPixelSize(2131299080));
      return;
    }
    localEditable.insert(i, localSpannableStringBuilder);
    int j = localSpannableStringBuilder.length();
    this.jdField_a_of_type_AndroidWidgetEditText.setSelection(i + j);
    olh.a("0X800B24C", new pqg().a("topic_id", Long.valueOf(paramIntent.a())).a());
  }
  
  private void e()
  {
    ((LinearLayout.LayoutParams)((ViewGroup)this.jdField_a_of_type_AndroidViewView.findViewById(2131379027)).getLayoutParams()).setMargins(0, ImmersiveUtils.getStatusBarHeight(getActivity()), 0, 0);
    ((PressEffectImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131364711)).setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131373373));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131365287));
    Object localObject = this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).height = (DisplayUtil.getWindowScreenWidth(getActivity()) * 9 / 16);
    this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    ((RoundBackgroundTextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131377296)).setOnClickListener(this);
    h();
    i();
    j();
    localObject = (LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131370291);
    this.jdField_d_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131365764);
    ((LinearLayout)localObject).setOnClickListener(this);
    if (rwg.b())
    {
      ((LinearLayout)localObject).setVisibility(0);
      this.jdField_d_of_type_AndroidViewView.setVisibility(0);
      olh.a("0X800B24A", "");
    }
    for (;;)
    {
      g();
      f();
      this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131379270);
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379277));
      this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131362200);
      this.jdField_a_of_type_AndroidViewView.findViewById(2131362201).setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetListView = ((ListView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379275));
      if (rth.k())
      {
        this.jdField_a_of_type_Ryn = new ryn(this);
        this.jdField_a_of_type_AndroidWidgetListView.setAdapter(this.jdField_a_of_type_Ryn);
        this.jdField_a_of_type_AndroidWidgetListView.setOnItemClickListener(new ryg(this));
      }
      return;
      ((LinearLayout)localObject).setVisibility(8);
      this.jdField_d_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  private void f()
  {
    LinearLayout localLinearLayout = (LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131370293);
    localLinearLayout.setOnClickListener(this);
    if (rwg.c())
    {
      localLinearLayout.setVisibility(0);
      this.jdField_d_of_type_AndroidViewView.setVisibility(0);
      olh.a("0X800B4D2", "");
      return;
    }
    localLinearLayout.setVisibility(8);
    this.jdField_d_of_type_AndroidViewView.setVisibility(8);
  }
  
  private void g()
  {
    LinearLayout localLinearLayout = (LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131370289);
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362218));
    localLinearLayout.setOnClickListener(this);
    if (rwg.d())
    {
      localLinearLayout.setVisibility(0);
      this.jdField_d_of_type_AndroidViewView.setVisibility(0);
      olh.a("0X800B4C6", "");
    }
    for (;;)
    {
      b();
      return;
      localLinearLayout.setVisibility(8);
      this.jdField_d_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  private void h()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyWidgetsLimitWordCountEditText = ((LimitWordCountEditText)this.jdField_a_of_type_AndroidViewView.findViewById(2131379056));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyWidgetsLimitWordCountEditText.setCountLimit(rth.f());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyWidgetsLimitWordCountEditText.setDisableManualEnter(true);
    this.jdField_a_of_type_AndroidWidgetEditText = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyWidgetsLimitWordCountEditText.a();
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new ryj(this));
  }
  
  private void i()
  {
    View localView = this.jdField_a_of_type_AndroidViewView.findViewById(2131370280);
    int i = rwg.a();
    localView.setVisibility(i);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379719));
    if (i == 0)
    {
      boolean bool = rwg.a();
      this.jdField_b_of_type_AndroidWidgetTextView.setText(a(bool));
      localView.setOnClickListener(this);
    }
  }
  
  private void j()
  {
    View localView = this.jdField_a_of_type_AndroidViewView.findViewById(2131370285);
    int i = rth.g();
    localView.setVisibility(i);
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379738));
    if (i == 0)
    {
      i = rth.h();
      this.jdField_c_of_type_AndroidWidgetTextView.setText(a(i));
      localView.setOnClickListener(this);
    }
  }
  
  private void k()
  {
    Object localObject3 = getArguments();
    this.jdField_a_of_type_Ryq.a(this);
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
    l();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.fromForReport = b(this.jdField_a_of_type_Int);
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
      if (rth.c())
      {
        i = 0;
        if (localObject3 == null) {
          break label404;
        }
        i = ((ColumnInfo)localObject3).columnID;
        if (localObject3 == null) {
          break label407;
        }
        localObject1 = ((ColumnInfo)localObject3).title;
        if (!rth.k()) {
          break label527;
        }
        this.jdField_a_of_type_Boolean = TextUtils.isEmpty((CharSequence)localObject1);
        if (!this.jdField_a_of_type_Boolean) {
          break label413;
        }
        this.jdField_b_of_type_AndroidViewView.setVisibility(8);
        this.jdField_c_of_type_AndroidViewView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetListView.setVisibility(0);
        this.jdField_a_of_type_Ryq.b();
        r();
        q();
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
        label404:
        continue;
        label407:
        localObject2 = "";
        continue;
        label413:
        this.jdField_b_of_type_AndroidViewView.setVisibility(0);
        this.jdField_c_of_type_AndroidViewView.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetListView.setVisibility(8);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.columnId = i;
        localObject2 = getResources().getDrawable(2130843095);
        ((Drawable)localObject2).setBounds(0, 0, UIUtils.dip2px(this.jdField_a_of_type_AndroidContentContext, 15.0F), UIUtils.dip2px(this.jdField_a_of_type_AndroidContentContext, 15.0F));
        this.jdField_d_of_type_AndroidWidgetTextView.setText(((ColumnInfo)localObject3).title);
        this.jdField_d_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(UIUtils.dip2px(this.jdField_a_of_type_AndroidContentContext, 5.0F));
        this.jdField_d_of_type_AndroidWidgetTextView.setCompoundDrawables((Drawable)localObject2, null, null, null);
        continue;
        label527:
        this.jdField_b_of_type_AndroidViewView.setVisibility(8);
        this.jdField_c_of_type_AndroidViewView.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetListView.setVisibility(8);
      }
    }
  }
  
  private void l()
  {
    UgcVideo localUgcVideo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo;
    if (!rwg.a()) {}
    for (boolean bool = true;; bool = false)
    {
      localUgcVideo.reprintDisable = bool;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.publicType = rth.h();
      return;
    }
  }
  
  private void m()
  {
    int k = 1;
    int i;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.columnId != 0L)
    {
      i = 1;
      j = k;
      if (this.jdField_a_of_type_Int != 3) {
        if (this.jdField_a_of_type_Int != 4) {
          break label111;
        }
      }
    }
    label111:
    for (int j = k;; j = 0)
    {
      if ((i == 0) || (j != 0)) {
        break label116;
      }
      getActivity().finish();
      if (rth.j() == 2)
      {
        localObject = rth.a() + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.columnId;
        tto.a(getActivity(), "", (String)localObject, new Bundle(), false);
      }
      return;
      i = 0;
      break;
    }
    label116:
    Object localObject = new Intent();
    ((Intent)localObject).putExtra("key_column_id", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.columnId);
    ((Intent)localObject).putExtra("arg_callback", this.jdField_a_of_type_JavaLangString);
    getActivity().setResult(3, (Intent)localObject);
    getActivity().finish();
  }
  
  private void n()
  {
    int i = rth.b();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.columnId != 0L)
    {
      getActivity().finish();
      if (rth.j() == 2)
      {
        String str = rth.a() + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.columnId;
        tto.a(getActivity(), "", str, new Bundle(), false);
      }
      return;
    }
    if (i == 2)
    {
      QLog.d("RIJUGC.EditVideoFragment", 2, "closeView | publish video without column ");
      ThreadManager.getUIHandler().postDelayed(new EditVideoFragment.7(this), 500L);
      return;
    }
    getActivity().finish();
    osg.a((QQAppInterface)pkh.a(), getActivity(), 0, 0, null);
  }
  
  private void o()
  {
    sad.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo);
  }
  
  private void p()
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_AndroidWidgetEditText.getText().toString())) {}
    for (int i = 1; i != 0; i = 0)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setAlpha(1.0F);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setAlpha(0.5F);
  }
  
  private void q()
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
  
  private void r()
  {
    if (NetworkUtil.isMobileNetWork(getActivity()))
    {
      rth.a(getActivity(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.fileSize, new ryl(this), null);
      return;
    }
    sad.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo, true);
  }
  
  private void s()
  {
    olh.a("0X800B24B", "");
    Intent localIntent = new Intent();
    localIntent.putExtra("searchTopicFrom", 1);
    PublicFragmentActivity.a(this, localIntent, ReadInJoyTopicSelectionFragment.class, 20001);
  }
  
  private void t()
  {
    olh.a("0X800AC5E", a().a());
    getActivity().finish();
    o();
  }
  
  private void u()
  {
    olh.a("0X800AC60", a().a("source", Integer.valueOf(2)).a());
    rth.a(getActivity(), 3);
  }
  
  private void v()
  {
    olh.a("0X800AC5F", a().a());
    Object localObject = this.jdField_a_of_type_AndroidWidgetEditText.getText();
    String str = localObject.toString();
    if (TextUtils.isEmpty(localObject.toString()))
    {
      QQToast.a(getActivity(), 2131717736, 0).a();
      return;
    }
    if (a((Editable)localObject))
    {
      QQToast.a(getActivity(), 2131718101, 0).a();
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.title = str;
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.url))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.startUserWaitingTime = System.currentTimeMillis();
      if (this.jdField_a_of_type_Int != 4) {
        break label187;
      }
    }
    label187:
    for (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.uploadType = 1;; this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.uploadType = 0)
    {
      localObject = new ArrayList();
      rvy.a(this.jdField_a_of_type_AndroidWidgetEditText, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), false, (List)localObject);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.setMultiTitleStruct((List)localObject);
      a(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI);
      this.jdField_a_of_type_Ryq.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo);
      return;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.userWaitingTotalCostTime = 0L;
      break;
    }
  }
  
  private void w()
  {
    CoverSelectTabFragment.a(getActivity(), 10001, this.jdField_b_of_type_Int, this.jdField_a_of_type_Float, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo);
  }
  
  private void x()
  {
    View localView = LayoutInflater.from(getActivity()).inflate(2131560219, null);
    ((RelativeLayout)localView.findViewById(2131362665)).setOnClickListener(this);
    ((RelativeLayout)localView.findViewById(2131367181)).setOnClickListener(this);
    ((TextView)localView.findViewById(2131364268)).setOnClickListener(new rym(this));
    ImageView localImageView1 = (ImageView)localView.findViewById(2131362667);
    ImageView localImageView2 = (ImageView)localView.findViewById(2131367183);
    if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.reprintDisable)
    {
      localImageView1.setVisibility(0);
      localImageView2.setVisibility(8);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidAppDialog = bkzz.a(getActivity(), localView);
      this.jdField_a_of_type_AndroidAppDialog.show();
      return;
      localImageView1.setVisibility(8);
      localImageView2.setVisibility(0);
    }
  }
  
  private void y()
  {
    View localView = LayoutInflater.from(getActivity()).inflate(2131560218, null);
    a(localView);
    b(localView);
    c(localView);
    this.jdField_b_of_type_AndroidAppDialog = bkzz.a(getActivity(), localView);
    this.jdField_b_of_type_AndroidAppDialog.show();
  }
  
  public void a()
  {
    pvm.a().f();
    if (getActivity() == null)
    {
      QLog.d("RIJUGC.EditVideoFragment", 2, "closeView | activity is null");
      return;
    }
    if (this.jdField_a_of_type_Int == 1)
    {
      n();
      return;
    }
    m();
  }
  
  @VisibleForTesting
  void a(Intent paramIntent)
  {
    if (paramIntent == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI = ((TroopBarPOI)paramIntent.getParcelableExtra("key_selected_poi"));
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI != null)
    {
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.jdField_c_of_type_JavaLangString)) {}
      for (paramIntent = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.jdField_d_of_type_JavaLangString;; paramIntent = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.jdField_c_of_type_JavaLangString)
      {
        a(paramIntent);
        olh.a("0X800B4CA", "");
        return;
      }
    }
    a(anvx.a(2131718107));
    olh.a("0X800B4CC", "");
  }
  
  @VisibleForTesting
  void a(TroopBarPOI paramTroopBarPOI)
  {
    if (paramTroopBarPOI != null)
    {
      JSONObject localJSONObject = new JSONObject();
      for (;;)
      {
        try
        {
          localJSONObject.put("latitude", paramTroopBarPOI.jdField_b_of_type_Int);
          localJSONObject.put("longitude", paramTroopBarPOI.jdField_a_of_type_Int);
          localJSONObject.put("is_user_selected", 1);
          if (!TextUtils.isEmpty(paramTroopBarPOI.jdField_c_of_type_JavaLangString)) {
            continue;
          }
          str = paramTroopBarPOI.jdField_d_of_type_JavaLangString;
          localJSONObject.put("location_name", str);
          localJSONObject.put("area_id", paramTroopBarPOI.jdField_a_of_type_JavaLangString);
        }
        catch (Exception paramTroopBarPOI)
        {
          String str;
          QLog.e("RIJUGC.EditVideoFragment", 1, "setUgcVideoAddress error in e :" + paramTroopBarPOI.getMessage());
          continue;
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.address = localJSONObject.toString();
        return;
        str = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.jdField_c_of_type_JavaLangString;
      }
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.address = this.jdField_a_of_type_OrgJsonJSONObject.toString();
  }
  
  protected void a(@NotNull String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (this.jdField_e_of_type_AndroidWidgetTextView != null)) {
      this.jdField_e_of_type_AndroidWidgetTextView.setText(paramString);
    }
  }
  
  @VisibleForTesting
  boolean a(Editable paramEditable)
  {
    int i = 0;
    AtFriendsSpan[] arrayOfAtFriendsSpan = (AtFriendsSpan[])paramEditable.getSpans(0, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyWidgetsLimitWordCountEditText.a(), AtFriendsSpan.class);
    String str = paramEditable.toString();
    int j = arrayOfAtFriendsSpan.length;
    while (i < j)
    {
      AtFriendsSpan localAtFriendsSpan = arrayOfAtFriendsSpan[i];
      str = str.replace(paramEditable.subSequence(paramEditable.getSpanStart(localAtFriendsSpan), paramEditable.getSpanEnd(localAtFriendsSpan)), "");
      i += 1;
    }
    return TextUtils.isEmpty(str.trim());
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$OnLocationListener = new ryh(this, 0, true, true, 0L, false, false, "QLifeCommentActivity");
    SosoInterface.startLocation(this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$OnLocationListener);
  }
  
  protected void b(Intent paramIntent)
  {
    if (paramIntent == null) {}
    int j;
    Editable localEditable;
    do
    {
      do
      {
        return;
        paramIntent = paramIntent.getParcelableArrayListExtra("result_set");
      } while ((this.jdField_a_of_type_AndroidWidgetEditText == null) || (paramIntent == null));
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
        if (localEditable.toString().substring(j - 1, j).equals("@"))
        {
          localEditable.delete(j - 1, j);
          i = j - 1;
          this.jdField_a_of_type_AndroidWidgetEditText.setSelection(i);
        }
      }
    }
    Iterator localIterator = paramIntent.iterator();
    while (localIterator.hasNext())
    {
      ResultRecord localResultRecord = (ResultRecord)localIterator.next();
      try
      {
        l = Long.parseLong(localResultRecord.a());
        if (l != 0L)
        {
          paramIntent = ReadInJoyUserInfoModule.a(l, null);
          if (paramIntent != null)
          {
            paramIntent = paramIntent.nick;
            paramIntent = new SpannableStringBuilder("@" + paramIntent + " ");
            paramIntent.setSpan(new AtFriendsSpan(localResultRecord.a(), localResultRecord.a(), paramIntent, -12541697), 0, paramIntent.length(), 33);
            if (localEditable.length() + paramIntent.length() <= this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyWidgetsLimitWordCountEditText.a()) {
              break label313;
            }
            QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131718112, 1).b(getResources().getDimensionPixelSize(2131299080));
          }
        }
      }
      catch (NumberFormatException paramIntent)
      {
        for (;;)
        {
          QLog.d("RIJUGC.EditVideoFragment", 2, paramIntent.getMessage());
          long l = 0L;
          continue;
          paramIntent = ReadInJoyUserInfoModule.a();
        }
        label313:
        localEditable.insert(i, paramIntent);
        j = paramIntent.length();
        olh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "", "0X800B4D6", "0X800B4D6", 0, 0, String.valueOf(a(localResultRecord.a())), "", "", new pqg().a(), false);
        i += j;
      }
    }
    this.jdField_a_of_type_AndroidWidgetEditText.setSelection(i);
  }
  
  protected void c()
  {
    olh.a("0X800B4C8", "");
    if (a())
    {
      Intent localIntent = new Intent(getActivity(), TroopBarPublishLocationSelectActivity.class);
      localIntent.putExtra("key_selected_poi", this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI);
      startActivityForResult(localIntent, 1002);
      getActivity().overridePendingTransition(2130771992, 2130771993);
    }
  }
  
  public void d()
  {
    olh.a("0X800B4D4", "");
    Intent localIntent = new Intent();
    localIntent.putExtra("param_only_friends", true);
    localIntent.putExtra("param_min", 1);
    localIntent.putExtra("param_max", 10);
    PublicFragmentActivity.a(this, localIntent, ReadInJoySelectMemberFragment.class, 30001);
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
        c(paramIntent);
        return;
      }
      if (paramInt1 == 20001)
      {
        d(paramIntent);
        return;
      }
      if (paramInt1 == 30001)
      {
        b(paramIntent);
        return;
      }
    } while (paramInt1 != 1002);
    a(paramIntent);
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    pvm.a().a(this.jdField_a_of_type_Rzn);
  }
  
  public boolean onBackEvent()
  {
    o();
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
      v();
      continue;
      t();
      continue;
      w();
      continue;
      x();
      continue;
      y();
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
      u();
      continue;
      if (rwg.b())
      {
        s();
        continue;
        c();
        continue;
        d();
      }
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(2131560217, paramViewGroup, false);
    if (getActivity() == null) {}
    for (paramLayoutInflater = null;; paramLayoutInflater = this.jdField_a_of_type_AndroidViewView)
    {
      V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
      return paramLayoutInflater;
      e();
      k();
      ptj.a.a(getActivity());
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    pvm.a().b(this.jdField_a_of_type_Rzn);
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    this.jdField_a_of_type_Ryq.a();
  }
  
  public void onResume()
  {
    super.onResume();
    if ((this.jdField_a_of_type_Ryq != null) && (this.jdField_a_of_type_Boolean)) {
      this.jdField_a_of_type_Ryq.b();
    }
    pqu.a(getActivity());
  }
  
  public void setCenterEmpty() {}
  
  public void setCenterError(int paramInt, String paramString) {}
  
  public void setCenterHide() {}
  
  public void setCenterLoading() {}
  
  public void setFooterError(int paramInt, String paramString) {}
  
  public void setFooterHasMore()
  {
    this.jdField_a_of_type_Ryq.c();
  }
  
  public void setFooterHide() {}
  
  public void setFooterLoading() {}
  
  public void setFooterNoMore() {}
  
  public void setHeaderError(int paramInt, String paramString)
  {
    QQToast.a(getActivity(), getString(2131717845), 0).a();
  }
  
  public void setHeaderLoading() {}
  
  public void setHeaderSuccess() {}
  
  public void setListData(List<ColumnInfo> paramList, boolean paramBoolean)
  {
    if ((!paramList.isEmpty()) && (!paramBoolean) && (rth.c()))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructColumnInfo = ((ColumnInfo)paramList.get(0));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUgcVideo.columnId = ((ColumnInfo)paramList.get(0)).columnID;
    }
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
    if ((this.jdField_a_of_type_JavaUtilArrayList.size() > 0) && (rth.c())) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructColumnInfo = ((ColumnInfo)this.jdField_a_of_type_JavaUtilArrayList.get(0));
    }
    this.jdField_a_of_type_Ryn.notifyDataSetChanged();
    p();
  }
  
  public void setTotal(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.editvideo.EditVideoFragment
 * JD-Core Version:    0.7.0.1
 */