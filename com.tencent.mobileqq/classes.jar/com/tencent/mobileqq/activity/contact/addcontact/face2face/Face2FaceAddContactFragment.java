package com.tencent.mobileqq.activity.contact.addcontact.face2face;

import agej;
import ajfh;
import ajfl;
import ajfm;
import ajfn;
import ajfo;
import ajfr;
import ajfw;
import ajfx;
import ajfy;
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
import anyw;
import bhnv;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import mvd;

public class Face2FaceAddContactFragment
  extends IphoneTitleBarFragment
  implements ajfy, View.OnClickListener
{
  private long jdField_a_of_type_Long;
  private ajfh jdField_a_of_type_Ajfh;
  private ajfr jdField_a_of_type_Ajfr;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  Handler jdField_a_of_type_AndroidOsHandler = new ajfl(this);
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new ajfm(this);
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
    case 2131365916: 
    case 2131366707: 
    case 2131367107: 
    case 2131371842: 
    case 2131372049: 
    case 2131377476: 
    case 2131377772: 
    case 2131378817: 
    case 2131380207: 
    case 2131381590: 
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
      if (!bhnv.d(getActivity()))
      {
        QQToast.a(getActivity(), 2131694008, 0).a();
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(500, 500L);
      }
    }
    else
    {
      return;
    }
    if (a(this.jdField_a_of_type_JavaLangStringBuffer.toString()))
    {
      QQToast.a(getActivity(), getString(2131718770), 0).a();
      ajfw.a("0X800AB5F", "", "", this.jdField_a_of_type_JavaLangStringBuffer.toString());
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(500, 500L);
      return;
    }
    this.r.setVisibility(0);
    this.r.setBackgroundDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).start();
    this.jdField_a_of_type_Ajfr.a(getActivity(), this.jdField_a_of_type_JavaLangStringBuffer.toString(), null);
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
      this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(agej.a(8.0F, getResources()));
      this.jdField_b_of_type_AndroidWidgetTextView.setTextSize(agej.a(8.0F, getResources()));
      this.jdField_c_of_type_AndroidWidgetTextView.setTextSize(agej.a(8.0F, getResources()));
      this.jdField_d_of_type_AndroidWidgetTextView.setTextSize(agej.a(8.0F, getResources()));
    }
    if (paramInt > 0)
    {
      String str = getString(2131691966, new Object[] { Integer.valueOf(paramInt) });
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
    this.f.setText(getString(2131691965));
  }
  
  private void k()
  {
    this.jdField_a_of_type_Ajfr = new ajfr(this);
    this.jdField_a_of_type_JavaLangStringBuffer = new StringBuffer();
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130839414);
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
    setTitle(getString(2131691959), getString(2131691959));
    this.rightViewText.setTextColor(-1);
    setRightButtonText(getString(2131718539), this);
    this.rightViewText.setContentDescription(getString(2131718539));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.mContentView.findViewById(2131365056));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.mContentView.findViewById(2131369208));
    this.r = ((TextView)this.mContentView.findViewById(2131373074));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.mContentView.findViewById(2131369195));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.mContentView.findViewById(2131369197));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)this.mContentView.findViewById(2131369196));
    this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)this.mContentView.findViewById(2131369194));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131379788));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131379790));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131379789));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131379787));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131378794));
    this.f = ((TextView)this.mContentView.findViewById(2131378796));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)this.mContentView.findViewById(2131367686));
    this.jdField_a_of_type_Ajfh = new ajfh(getActivity(), getActivity().app, this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 5));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Ajfh);
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.mContentView.findViewById(2131370117));
    this.jdField_c_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.mContentView.findViewById(2131370195));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.mContentView.findViewById(2131363805));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTableLayout = ((TableLayout)this.mContentView.findViewById(2131365559));
    this.g = ((TextView)this.mContentView.findViewById(2131372049));
    this.h = ((TextView)this.mContentView.findViewById(2131380207));
    this.i = ((TextView)this.mContentView.findViewById(2131378817));
    this.j = ((TextView)this.mContentView.findViewById(2131367107));
    this.k = ((TextView)this.mContentView.findViewById(2131366707));
    this.l = ((TextView)this.mContentView.findViewById(2131377772));
    this.m = ((TextView)this.mContentView.findViewById(2131377476));
    this.n = ((TextView)this.mContentView.findViewById(2131365916));
    this.o = ((TextView)this.mContentView.findViewById(2131371842));
    this.p = ((TextView)this.mContentView.findViewById(2131381590));
    this.q = ((TextView)this.mContentView.findViewById(2131365363));
    this.g.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.g.setOnTouchListener(mvd.a);
    this.h.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.h.setOnTouchListener(mvd.a);
    this.i.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.i.setOnTouchListener(mvd.a);
    this.j.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.j.setOnTouchListener(mvd.a);
    this.k.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.k.setOnTouchListener(mvd.a);
    this.l.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.l.setOnTouchListener(mvd.a);
    this.m.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.m.setOnTouchListener(mvd.a);
    this.n.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.n.setOnTouchListener(mvd.a);
    this.o.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.o.setOnTouchListener(mvd.a);
    this.p.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.p.setOnTouchListener(mvd.a);
    this.q.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.q.setOnTouchListener(mvd.a);
  }
  
  private void m()
  {
    if ((isDetached()) || (getActivity() == null)) {
      return;
    }
    if (getActivity().isResume())
    {
      p();
      QQToast.a(getActivity(), getString(2131691970), 0).a();
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
    this.jdField_a_of_type_Ajfh.notifyDataSetChanged();
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
      this.jdField_a_of_type_Ajfh.a();
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
    if ((this.jdField_a_of_type_Ajfr != null) && (this.jdField_a_of_type_Ajfh != null) && (getActivity() != null) && (!getActivity().isFinishing()))
    {
      if (QLog.isDebugVersion()) {
        QLog.d("Face2FaceAddContactFragment", 2, "sendFace2FaceHeartBeat isNetworkAvailable:" + bhnv.a());
      }
      if (bhnv.a())
      {
        Object localObject = this.jdField_a_of_type_Ajfh.a();
        ArrayList localArrayList = new ArrayList();
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          ajfx localajfx = (ajfx)((Iterator)localObject).next();
          if (localajfx != null) {
            localArrayList.add(localajfx.jdField_a_of_type_JavaLangString);
          }
        }
        this.jdField_a_of_type_Ajfr.a(localArrayList);
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
    if (i1 < this.jdField_a_of_type_Ajfh.a().size()) {
      if (!paramString.equals(((ajfx)this.jdField_a_of_type_Ajfh.a().get(i1)).jdField_a_of_type_JavaLangString)) {}
    }
    for (;;)
    {
      if (QLog.isDebugVersion()) {
        QLog.d("Face2FaceAddContactFragment", 2, "deleteFriend delIndex:" + i1);
      }
      if (i1 == -1) {
        break;
      }
      this.jdField_a_of_type_Ajfh.a().remove(i1);
      this.jdField_a_of_type_Ajfh.notifyItemRemoved(i1);
      e(this.jdField_a_of_type_Ajfh.a().size());
      return;
      i1 += 1;
      break label57;
      i1 = -1;
    }
  }
  
  public void a(String paramString, List<ajfx> paramList)
  {
    if ((isDetached()) || (getActivity() == null) || (paramList == null) || (paramList.size() <= 0) || (this.jdField_a_of_type_Ajfh.a() == null)) {
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
    int i1 = this.jdField_a_of_type_Ajfh.a().size();
    paramString = paramList.iterator();
    while (paramString.hasNext())
    {
      paramList = (ajfx)paramString.next();
      if (!this.jdField_a_of_type_Ajfh.a().contains(paramList)) {
        this.jdField_a_of_type_Ajfh.a().add(i1, paramList);
      }
    }
    int i2 = this.jdField_a_of_type_Ajfh.a().size();
    if (i1 != i2) {
      this.jdField_a_of_type_Ajfh.notifyItemRangeInserted(i1, i2 - i1);
    }
    e(i2);
  }
  
  public void a(List<String> paramList)
  {
    if ((isDetached()) || (getActivity() == null) || (paramList == null) || (getActivity().app == null)) {}
    ArrayList localArrayList;
    do
    {
      anyw localanyw;
      do
      {
        do
        {
          return;
          if (QLog.isColorLevel()) {
            QLog.d("Face2FaceAddContactFragment", 2, " onFace2FaceAddContactHeartBeat() missingList.size() = " + paramList.size());
          }
        } while (paramList.size() <= 0);
        localanyw = (anyw)getActivity().app.getManager(51);
      } while (localanyw == null);
      localArrayList = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject = (String)paramList.next();
        ajfx localajfx = new ajfx();
        localajfx.jdField_a_of_type_JavaLangString = ((String)localObject);
        localajfx.jdField_a_of_type_Int = 1;
        if (!this.jdField_a_of_type_Ajfh.a().contains(localajfx))
        {
          localObject = localanyw.a((String)localObject);
          if ((localObject != null) && (((Friends)localObject).isFriend()))
          {
            localajfx.b = ((Friends)localObject).getFriendNick();
            localArrayList.add(localajfx);
          }
        }
      }
    } while (localArrayList.size() <= 0);
    a(getActivity().app.c(), localArrayList);
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
    localIntent.putExtra("uin", getActivity().app.c());
    localIntent.putExtra("url", paramString);
    try
    {
      getActivity().startActivityForResult(localIntent, 1001);
      ajfw.a("0X800AB65", "", "", "");
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
    this.jdField_a_of_type_Ajfr.a(getActivity());
    j();
  }
  
  public void e()
  {
    if ((isDetached()) || (getActivity() == null)) {
      return;
    }
    p();
    QQToast.a(getActivity(), getString(2131718291), 0).a();
  }
  
  public void f()
  {
    if ((isDetached()) || (getActivity() == null)) {
      return;
    }
    p();
    QQToast.a(getActivity(), getString(2131691971), 0).a();
    ajfw.a("0X800AB64", "", "", "");
  }
  
  public void g()
  {
    if ((isDetached()) || (getActivity() == null)) {}
    do
    {
      return;
      p();
      QQToast.a(getActivity(), getString(2131718770), 0).a();
    } while (this.jdField_a_of_type_JavaLangStringBuffer == null);
    ajfw.a("0X800AB5F", "", "", this.jdField_a_of_type_JavaLangStringBuffer.toString());
  }
  
  public int getContentLayoutId()
  {
    return 2131559162;
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
    ajfw.a("0X800AB60", "", "", "");
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
    if (!ajfw.b(getActivity().app)) {
      return;
    }
    ajfw.b(getActivity().app);
    ReportDialog localReportDialog = new ReportDialog(getActivity(), 2131755824);
    localReportDialog.setContentView(2131558467);
    Button localButton1 = (Button)localReportDialog.findViewById(2131365483);
    Button localButton2 = (Button)localReportDialog.findViewById(2131365487);
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = getResources().getDrawable(2130838003);
    ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable;
    ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = agej.a(170.0F, getResources());
    localObject = URLDrawable.getDrawable("https://pub.idqqimg.com/pc/misc/files/20200114/bd76e3d896aa49cd91e73aa332b1ff22.png", (URLDrawable.URLDrawableOptions)localObject);
    localReportDialog.findViewById(2131365546).setBackgroundDrawable((Drawable)localObject);
    localButton1.setOnClickListener(new ajfn(this, localReportDialog));
    localButton2.setOnClickListener(new ajfo(this, localReportDialog));
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
            this.jdField_a_of_type_Ajfr.a(getActivity(), this.jdField_a_of_type_JavaLangStringBuffer.toString(), paramIntent);
          }
          if (QLog.isDebugVersion()) {
            QLog.d("Face2FaceAddContactFragment", 2, "onActivityResult VERIFY_REQUEST_CODE, verifySig:" + paramIntent);
          }
          ajfw.a("0X800AB66", "", "", "");
          return;
        }
      } while (paramInt2 != 0);
      p();
      QQToast.a(getActivity(), getString(2131691973), 0).a();
      return;
    } while (getActivity().checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0);
    r();
  }
  
  public boolean onBackEvent()
  {
    if (this.jdField_a_of_type_Ajfr != null) {
      this.jdField_a_of_type_Ajfr.b();
    }
    if (this.jdField_a_of_type_Ajfh != null) {
      ajfw.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_Ajfh.a());
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
    if (this.jdField_a_of_type_Ajfr != null) {
      this.jdField_a_of_type_Ajfr.a();
    }
    if (this.jdField_a_of_type_Ajfh != null) {
      this.jdField_a_of_type_Ajfh.b();
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
      QQToast.a(getActivity(), getString(2131691970), 0).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.face2face.Face2FaceAddContactFragment
 * JD-Core Version:    0.7.0.1
 */