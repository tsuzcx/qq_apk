package com.tencent.mobileqq.activity.contact.addcontact.face2face;

import aiup;
import aiut;
import aiuu;
import aiuv;
import aiuw;
import aiuz;
import aive;
import aivf;
import aivg;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;
import anvk;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import mvk;

public class Face2FaceAddContactFragment
  extends IphoneTitleBarFragment
  implements aivg, View.OnClickListener
{
  private long jdField_a_of_type_Long;
  private aiup jdField_a_of_type_Aiup;
  private aiuz jdField_a_of_type_Aiuz;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  Handler jdField_a_of_type_AndroidOsHandler = new aiut(this);
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new aiuu(this);
  private Button jdField_a_of_type_AndroidWidgetButton;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TableLayout jdField_a_of_type_AndroidWidgetTableLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private StringBuffer jdField_a_of_type_JavaLangStringBuffer;
  private boolean jdField_a_of_type_Boolean;
  private String[] jdField_a_of_type_ArrayOfJavaLangString = { "1234", "0000", "1111", "2222", "3333" };
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_c_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private ImageView jdField_d_of_type_AndroidWidgetImageView;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private ImageView jdField_e_of_type_AndroidWidgetImageView;
  private TextView jdField_e_of_type_AndroidWidgetTextView;
  private TextView f;
  private TextView g;
  private TextView h;
  private TextView i;
  private TextView j;
  private TextView k;
  private TextView l;
  private TextView m;
  private TextView n;
  private TextView o;
  private TextView p;
  private TextView q;
  private TextView r;
  
  public static void a(Context paramContext, Intent paramIntent)
  {
    PublicFragmentActivity.a(paramContext, paramIntent, Face2FaceAddContactFragment.class);
  }
  
  private void a(View paramView, int paramInt)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131366047: 
    case 2131366853: 
    case 2131367242: 
    case 2131371998: 
    case 2131372206: 
    case 2131377512: 
    case 2131377812: 
    case 2131378874: 
    case 2131380274: 
    case 2131381670: 
      this.jdField_a_of_type_JavaLangStringBuffer.append(((TextView)paramView).getText());
      return;
    }
    if ((paramInt > 0) && (paramInt < 4)) {
      this.jdField_a_of_type_JavaLangStringBuffer.deleteCharAt(paramInt - 1);
    }
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetTextView.setText("");
      return;
    case 2: 
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
      this.jdField_b_of_type_AndroidWidgetTextView.setText("");
      return;
    case 3: 
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(4);
      this.jdField_c_of_type_AndroidWidgetTextView.setText("");
      return;
    }
    this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(4);
    this.jdField_d_of_type_AndroidWidgetTextView.setText("");
  }
  
  private void a(boolean paramBoolean)
  {
    this.g.setEnabled(paramBoolean);
    this.h.setEnabled(paramBoolean);
    this.i.setEnabled(paramBoolean);
    this.j.setEnabled(paramBoolean);
    this.k.setEnabled(paramBoolean);
    this.l.setEnabled(paramBoolean);
    this.m.setEnabled(paramBoolean);
    this.n.setEnabled(paramBoolean);
    this.o.setEnabled(paramBoolean);
    this.p.setEnabled(paramBoolean);
    this.q.setEnabled(paramBoolean);
  }
  
  private boolean a(String paramString)
  {
    return Arrays.asList(this.jdField_a_of_type_ArrayOfJavaLangString).contains(paramString);
  }
  
  private void c(int paramInt)
  {
    if (paramInt == 4)
    {
      a(false);
      if (!NetworkUtil.isNetSupport(getActivity()))
      {
        QQToast.a(getActivity(), 2131694305, 0).a();
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(500, 500L);
      }
    }
    else
    {
      return;
    }
    if (a(this.jdField_a_of_type_JavaLangStringBuffer.toString()))
    {
      QQToast.a(getActivity(), getString(2131719424), 0).a();
      aive.a("0X800AB5F", "", "", this.jdField_a_of_type_JavaLangStringBuffer.toString());
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(500, 500L);
      return;
    }
    this.r.setVisibility(0);
    this.r.setBackgroundDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).start();
    this.jdField_a_of_type_Aiuz.a(getActivity(), this.jdField_a_of_type_JavaLangStringBuffer.toString(), null);
  }
  
  private void d(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(String.valueOf(this.jdField_a_of_type_JavaLangStringBuffer.charAt(paramInt - 1)));
      return;
    case 2: 
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(4);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(String.valueOf(this.jdField_a_of_type_JavaLangStringBuffer.charAt(paramInt - 1)));
      return;
    case 3: 
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(4);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetTextView.setText(String.valueOf(this.jdField_a_of_type_JavaLangStringBuffer.charAt(paramInt - 1)));
      return;
    }
    this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(4);
    this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_d_of_type_AndroidWidgetTextView.setText(String.valueOf(this.jdField_a_of_type_JavaLangStringBuffer.charAt(paramInt - 1)));
  }
  
  private void e(int paramInt)
  {
    if ((this.f == null) || (isDetached())) {
      return;
    }
    if (this.f.getVisibility() != 0)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
      this.f.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(AIOUtils.dp2px(8.0F, getResources()));
      this.jdField_b_of_type_AndroidWidgetTextView.setTextSize(AIOUtils.dp2px(8.0F, getResources()));
      this.jdField_c_of_type_AndroidWidgetTextView.setTextSize(AIOUtils.dp2px(8.0F, getResources()));
      this.jdField_d_of_type_AndroidWidgetTextView.setTextSize(AIOUtils.dp2px(8.0F, getResources()));
    }
    if (paramInt > 0)
    {
      String str = getString(2131692102, new Object[] { Integer.valueOf(paramInt) });
      int i1 = str.indexOf(String.valueOf(paramInt));
      if (i1 < 0)
      {
        this.f.setText(str);
        return;
      }
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
      localSpannableStringBuilder.append(str);
      localSpannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#00CAFC")), i1, String.valueOf(paramInt).length() + i1, 33);
      this.f.setText(localSpannableStringBuilder);
      return;
    }
    this.f.setText(getString(2131692101));
  }
  
  private void k()
  {
    this.jdField_a_of_type_Aiuz = new aiuz(this);
    this.jdField_a_of_type_JavaLangStringBuffer = new StringBuffer();
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130839470);
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  private void l()
  {
    SystemBarCompact localSystemBarCompact = ((PublicFragmentActivity)getActivity()).mSystemBarComp;
    if (localSystemBarCompact != null) {
      localSystemBarCompact.setStatusBarColor(-16777216);
    }
    getTitleBarView().setBackgroundResource(0);
    getTitleBarView().setBackgroundColor(-16777216);
    this.leftView.setVisibility(8);
    this.centerView.setTextColor(-1);
    setTitle(getString(2131692095), getString(2131692095));
    this.rightViewText.setTextColor(-1);
    setRightButtonText(getString(2131719177), this);
    this.rightViewText.setContentDescription(getString(2131719177));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.mContentView.findViewById(2131365167));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.mContentView.findViewById(2131369393));
    this.r = ((TextView)this.mContentView.findViewById(2131373254));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.mContentView.findViewById(2131369381));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.mContentView.findViewById(2131369383));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)this.mContentView.findViewById(2131369382));
    this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)this.mContentView.findViewById(2131369380));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131379882));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131379884));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131379883));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131379881));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131378849));
    this.f = ((TextView)this.mContentView.findViewById(2131378851));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)this.mContentView.findViewById(2131367854));
    this.jdField_a_of_type_Aiup = new aiup(getActivity(), getActivity().app, this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 5));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Aiup);
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.mContentView.findViewById(2131370286));
    this.jdField_c_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.mContentView.findViewById(2131370350));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.mContentView.findViewById(2131363905));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTableLayout = ((TableLayout)this.mContentView.findViewById(2131365685));
    this.g = ((TextView)this.mContentView.findViewById(2131372206));
    this.h = ((TextView)this.mContentView.findViewById(2131380274));
    this.i = ((TextView)this.mContentView.findViewById(2131378874));
    this.j = ((TextView)this.mContentView.findViewById(2131367242));
    this.k = ((TextView)this.mContentView.findViewById(2131366853));
    this.l = ((TextView)this.mContentView.findViewById(2131377812));
    this.m = ((TextView)this.mContentView.findViewById(2131377512));
    this.n = ((TextView)this.mContentView.findViewById(2131366047));
    this.o = ((TextView)this.mContentView.findViewById(2131371998));
    this.p = ((TextView)this.mContentView.findViewById(2131381670));
    this.q = ((TextView)this.mContentView.findViewById(2131365489));
    this.g.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.g.setOnTouchListener(mvk.a);
    this.h.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.h.setOnTouchListener(mvk.a);
    this.i.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.i.setOnTouchListener(mvk.a);
    this.j.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.j.setOnTouchListener(mvk.a);
    this.k.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.k.setOnTouchListener(mvk.a);
    this.l.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.l.setOnTouchListener(mvk.a);
    this.m.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.m.setOnTouchListener(mvk.a);
    this.n.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.n.setOnTouchListener(mvk.a);
    this.o.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.o.setOnTouchListener(mvk.a);
    this.p.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.p.setOnTouchListener(mvk.a);
    this.q.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.q.setOnTouchListener(mvk.a);
  }
  
  private void m()
  {
    if ((isDetached()) || (getActivity() == null)) {
      return;
    }
    if (getActivity().isResume())
    {
      p();
      QQToast.a(getActivity(), getString(2131692106), 0).a();
      return;
    }
    this.jdField_a_of_type_Boolean = true;
  }
  
  private void n()
  {
    if ((isDetached()) || (getActivity() == null)) {
      return;
    }
    Intent localIntent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
    localIntent.setData(Uri.fromParts("package", getActivity().getPackageName(), null));
    getActivity().startActivityForResult(localIntent, 1002);
  }
  
  private void o()
  {
    ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).stop();
    this.r.setVisibility(8);
    this.r.setBackgroundDrawable(null);
    e(0);
    this.jdField_a_of_type_AndroidWidgetTableLayout.setVisibility(8);
    this.jdField_a_of_type_Aiup.notifyDataSetChanged();
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setVisibility(0);
  }
  
  private void p()
  {
    if (isDetached()) {}
    do
    {
      return;
      ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).stop();
      this.r.setVisibility(8);
      this.r.setBackgroundDrawable(null);
      this.jdField_a_of_type_Aiup.a();
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
      this.f.setVisibility(8);
      q();
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTableLayout.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    } while (this.jdField_a_of_type_AndroidOsHandler == null);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(301);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(401);
  }
  
  private void q()
  {
    this.jdField_a_of_type_JavaLangStringBuffer.delete(0, this.jdField_a_of_type_JavaLangStringBuffer.length());
    this.jdField_a_of_type_AndroidWidgetTextView.setText("");
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetTextView.setText("");
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_c_of_type_AndroidWidgetTextView.setText("");
    this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_d_of_type_AndroidWidgetTextView.setText("");
    this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(0);
    a(true);
  }
  
  private void r()
  {
    this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    p();
  }
  
  private void s()
  {
    if ((this.jdField_a_of_type_Aiuz != null) && (this.jdField_a_of_type_Aiup != null) && (getActivity() != null) && (!getActivity().isFinishing()))
    {
      if (QLog.isDebugVersion()) {
        QLog.d("Face2FaceAddContactFragment", 2, "sendFace2FaceHeartBeat isNetworkAvailable:" + NetworkUtil.isNetworkAvailable());
      }
      if (NetworkUtil.isNetworkAvailable())
      {
        Object localObject = this.jdField_a_of_type_Aiup.a();
        ArrayList localArrayList = new ArrayList();
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          aivf localaivf = (aivf)((Iterator)localObject).next();
          if (localaivf != null) {
            localArrayList.add(localaivf.jdField_a_of_type_JavaLangString);
          }
        }
        this.jdField_a_of_type_Aiuz.a(localArrayList);
      }
    }
    else
    {
      return;
    }
    b(20000);
  }
  
  public void a()
  {
    if ((isDetached()) || (getActivity() == null)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Face2FaceAddContactFragment", 2, "onExitFace2FaceAddContact()");
    }
    p();
  }
  
  public void a(int paramInt)
  {
    if ((isDetached()) || (getActivity() == null)) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("Face2FaceAddContactFragment", 2, "onEnterFace2FaceAddContactSuccess() expireTimeMs:" + paramInt);
      }
      this.jdField_a_of_type_Long = SystemClock.elapsedRealtime();
      o();
    } while ((this.jdField_a_of_type_AndroidOsHandler == null) || (getActivity() == null) || (getActivity().isFinishing()));
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(401);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(401, paramInt);
  }
  
  public void a(String paramString)
  {
    if (QLog.isDebugVersion()) {
      QLog.d("Face2FaceAddContactFragment", 2, "deleteFriend delFriendUin:" + paramString);
    }
    if ((isDetached()) || (getActivity() == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    int i1 = 0;
    label57:
    if (i1 < this.jdField_a_of_type_Aiup.a().size()) {
      if (!paramString.equals(((aivf)this.jdField_a_of_type_Aiup.a().get(i1)).jdField_a_of_type_JavaLangString)) {}
    }
    for (;;)
    {
      if (QLog.isDebugVersion()) {
        QLog.d("Face2FaceAddContactFragment", 2, "deleteFriend delIndex:" + i1);
      }
      if (i1 == -1) {
        break;
      }
      this.jdField_a_of_type_Aiup.a().remove(i1);
      this.jdField_a_of_type_Aiup.notifyItemRemoved(i1);
      e(this.jdField_a_of_type_Aiup.a().size());
      return;
      i1 += 1;
      break label57;
      i1 = -1;
    }
  }
  
  public void a(String paramString, List<aivf> paramList)
  {
    if ((isDetached()) || (getActivity() == null) || (paramList == null) || (paramList.size() <= 0) || (this.jdField_a_of_type_Aiup.a() == null)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Face2FaceAddContactFragment", 2, " onFace2FaceAddContactPush() faceFriends.size() = " + paramList.size());
    }
    if (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getVisibility() != 0)
    {
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
    int i1 = this.jdField_a_of_type_Aiup.a().size();
    paramString = paramList.iterator();
    while (paramString.hasNext())
    {
      paramList = (aivf)paramString.next();
      if (!this.jdField_a_of_type_Aiup.a().contains(paramList)) {
        this.jdField_a_of_type_Aiup.a().add(i1, paramList);
      }
    }
    int i2 = this.jdField_a_of_type_Aiup.a().size();
    if (i1 != i2) {
      this.jdField_a_of_type_Aiup.notifyItemRangeInserted(i1, i2 - i1);
    }
    e(i2);
  }
  
  public void a(List<String> paramList)
  {
    if ((isDetached()) || (getActivity() == null) || (paramList == null) || (getActivity().app == null)) {}
    ArrayList localArrayList;
    do
    {
      anvk localanvk;
      do
      {
        do
        {
          return;
          if (QLog.isColorLevel()) {
            QLog.d("Face2FaceAddContactFragment", 2, " onFace2FaceAddContactHeartBeat() missingList.size() = " + paramList.size());
          }
        } while (paramList.size() <= 0);
        localanvk = (anvk)getActivity().app.getManager(QQManagerFactory.FRIENDS_MANAGER);
      } while (localanvk == null);
      localArrayList = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject = (String)paramList.next();
        aivf localaivf = new aivf();
        localaivf.jdField_a_of_type_JavaLangString = ((String)localObject);
        localaivf.jdField_a_of_type_Int = 1;
        if (!this.jdField_a_of_type_Aiup.a().contains(localaivf))
        {
          localObject = localanvk.a((String)localObject);
          if ((localObject != null) && (((Friends)localObject).isFriend()))
          {
            localaivf.b = ((Friends)localObject).getFriendNick();
            localArrayList.add(localaivf);
          }
        }
      }
    } while (localArrayList.size() <= 0);
    a(getActivity().app.getCurrentUin(), localArrayList);
  }
  
  public void b()
  {
    if ((isDetached()) || (getActivity() == null)) {}
    while (this.jdField_a_of_type_AndroidOsHandler == null) {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(6);
  }
  
  public void b(int paramInt)
  {
    if (QLog.isDebugVersion()) {
      QLog.d("Face2FaceAddContactFragment", 2, "startFace2FaceAddContactHeartBeat delayTimeMs:" + paramInt);
    }
    if ((this.jdField_a_of_type_AndroidOsHandler != null) && (getActivity() != null) && (!getActivity().isFinishing())) {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(301, paramInt);
    }
  }
  
  public void b(String paramString)
  {
    if ((isDetached()) || (getActivity() == null)) {
      return;
    }
    Intent localIntent = new Intent(getActivity(), QQBrowserActivity.class);
    localIntent.putExtra("uin", getActivity().app.getCurrentUin());
    localIntent.putExtra("url", paramString);
    try
    {
      getActivity().startActivityForResult(localIntent, 1001);
      aive.a("0X800AB65", "", "", "");
      return;
    }
    catch (SecurityException paramString) {}
  }
  
  public void c()
  {
    m();
  }
  
  public void d()
  {
    m();
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    k();
    l();
    this.jdField_a_of_type_Aiuz.a(getActivity());
    j();
  }
  
  public void e()
  {
    if ((isDetached()) || (getActivity() == null)) {
      return;
    }
    p();
    QQToast.a(getActivity(), getString(2131718919), 0).a();
  }
  
  public void f()
  {
    if ((isDetached()) || (getActivity() == null)) {
      return;
    }
    p();
    QQToast.a(getActivity(), getString(2131692107), 0).a();
    aive.a("0X800AB64", "", "", "");
  }
  
  public void g()
  {
    if ((isDetached()) || (getActivity() == null)) {}
    do
    {
      return;
      p();
      QQToast.a(getActivity(), getString(2131719424), 0).a();
    } while (this.jdField_a_of_type_JavaLangStringBuffer == null);
    aive.a("0X800AB5F", "", "", this.jdField_a_of_type_JavaLangStringBuffer.toString());
  }
  
  public int getContentLayoutId()
  {
    return 2131559198;
  }
  
  public void h()
  {
    if ((isDetached()) || (getActivity() == null)) {}
    while (this.jdField_a_of_type_AndroidOsHandler == null) {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(5);
  }
  
  public void i()
  {
    this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTableLayout.setVisibility(8);
    aive.a("0X800AB60", "", "", "");
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    super.initWindowStyleAndAnimation(paramActivity);
    paramActivity.overridePendingTransition(2130771979, 2130771980);
  }
  
  public boolean isTransparent()
  {
    return true;
  }
  
  public void j()
  {
    if (!aive.b(getActivity().app)) {
      return;
    }
    aive.b(getActivity().app);
    ReportDialog localReportDialog = new ReportDialog(getActivity(), 2131755829);
    localReportDialog.setContentView(2131558468);
    Button localButton1 = (Button)localReportDialog.findViewById(2131365607);
    Button localButton2 = (Button)localReportDialog.findViewById(2131365611);
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = getResources().getDrawable(2130838042);
    ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable;
    ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = AIOUtils.dp2px(170.0F, getResources());
    localObject = URLDrawable.getDrawable("https://pub.idqqimg.com/pc/misc/files/20200114/bd76e3d896aa49cd91e73aa332b1ff22.png", (URLDrawable.URLDrawableOptions)localObject);
    localReportDialog.findViewById(2131365671).setBackgroundDrawable((Drawable)localObject);
    localButton1.setOnClickListener(new aiuv(this, localReportDialog));
    localButton2.setOnClickListener(new aiuw(this, localReportDialog));
    localReportDialog.show();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (QLog.isDebugVersion()) {
      QLog.d("Face2FaceAddContactFragment", 2, "onActivityResult resultCode:" + paramInt2 + " requestCode:" + paramInt1);
    }
    switch (paramInt1)
    {
    }
    do
    {
      do
      {
        return;
        if ((paramIntent != null) && (paramInt2 == -1))
        {
          paramIntent = paramIntent.getStringExtra("ticket");
          if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangStringBuffer.toString())) && (this.jdField_a_of_type_JavaLangStringBuffer.length() == 4)) {
            this.jdField_a_of_type_Aiuz.a(getActivity(), this.jdField_a_of_type_JavaLangStringBuffer.toString(), paramIntent);
          }
          if (QLog.isDebugVersion()) {
            QLog.d("Face2FaceAddContactFragment", 2, "onActivityResult VERIFY_REQUEST_CODE, verifySig:" + paramIntent);
          }
          aive.a("0X800AB66", "", "", "");
          return;
        }
      } while (paramInt2 != 0);
      p();
      QQToast.a(getActivity(), getString(2131692109), 0).a();
      return;
    } while (getActivity().checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0);
    r();
  }
  
  public boolean onBackEvent()
  {
    if (this.jdField_a_of_type_Aiuz != null) {
      this.jdField_a_of_type_Aiuz.b();
    }
    if (this.jdField_a_of_type_Aiup != null) {
      aive.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_Aiup.a());
    }
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
      onBackEvent();
      continue;
      n();
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_Aiuz != null) {
      this.jdField_a_of_type_Aiuz.a();
    }
    if (this.jdField_a_of_type_Aiup != null) {
      this.jdField_a_of_type_Aiup.b();
    }
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
  }
  
  public void onFinish()
  {
    super.onFinish();
    if (getActivity() != null) {
      getActivity().overridePendingTransition(0, 2130771978);
    }
  }
  
  public void onResume()
  {
    super.onResume();
    FragmentActivity localFragmentActivity = getActivity();
    if ((localFragmentActivity != null) && ((localFragmentActivity instanceof PublicFragmentActivity)))
    {
      SystemBarCompact localSystemBarCompact = ((PublicFragmentActivity)localFragmentActivity).mSystemBarComp;
      if (localSystemBarCompact != null) {
        localSystemBarCompact.setStatusBarColor(-16777216);
      }
    }
    if ((localFragmentActivity != null) && (this.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_Boolean = false;
      p();
      QQToast.a(getActivity(), getString(2131692106), 0).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.face2face.Face2FaceAddContactFragment
 * JD-Core Version:    0.7.0.1
 */