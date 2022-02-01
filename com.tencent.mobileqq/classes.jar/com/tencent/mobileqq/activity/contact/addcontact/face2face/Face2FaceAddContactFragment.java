package com.tencent.mobileqq.activity.contact.addcontact.face2face;

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
import com.tencent.av.utils.UITools;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.FriendsManager;
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

public class Face2FaceAddContactFragment
  extends IphoneTitleBarFragment
  implements View.OnClickListener, IFace2FaceAddContact
{
  private long jdField_a_of_type_Long;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  Handler jdField_a_of_type_AndroidOsHandler = new Face2FaceAddContactFragment.1(this);
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new Face2FaceAddContactFragment.2(this);
  private Button jdField_a_of_type_AndroidWidgetButton;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TableLayout jdField_a_of_type_AndroidWidgetTableLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private Face2FaceAddContactAdapter jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFace2faceFace2FaceAddContactAdapter;
  private Face2FaceAddContactPresenter jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFace2faceFace2FaceAddContactPresenter;
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
    case 2131366218: 
    case 2131367043: 
    case 2131367427: 
    case 2131372306: 
    case 2131372508: 
    case 2131377923: 
    case 2131378224: 
    case 2131379305: 
    case 2131380717: 
    case 2131382135: 
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
      if (!NetworkUtil.d(getActivity()))
      {
        QQToast.a(getActivity(), 2131694510, 0).a();
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(500, 500L);
      }
    }
    else
    {
      return;
    }
    if (a(this.jdField_a_of_type_JavaLangStringBuffer.toString()))
    {
      QQToast.a(getActivity(), getString(2131719987), 0).a();
      Face2FaceAddContactUtils.a("0X800AB5F", "", "", this.jdField_a_of_type_JavaLangStringBuffer.toString());
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(500, 500L);
      return;
    }
    this.r.setVisibility(0);
    this.r.setBackgroundDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).start();
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFace2faceFace2FaceAddContactPresenter.a(getActivity(), this.jdField_a_of_type_JavaLangStringBuffer.toString(), null);
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
      this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(AIOUtils.a(8.0F, getResources()));
      this.jdField_b_of_type_AndroidWidgetTextView.setTextSize(AIOUtils.a(8.0F, getResources()));
      this.jdField_c_of_type_AndroidWidgetTextView.setTextSize(AIOUtils.a(8.0F, getResources()));
      this.jdField_d_of_type_AndroidWidgetTextView.setTextSize(AIOUtils.a(8.0F, getResources()));
    }
    if (paramInt > 0)
    {
      String str = getString(2131692234, new Object[] { Integer.valueOf(paramInt) });
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
    this.f.setText(getString(2131692233));
  }
  
  private void k()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFace2faceFace2FaceAddContactPresenter = new Face2FaceAddContactPresenter(this);
    this.jdField_a_of_type_JavaLangStringBuffer = new StringBuffer();
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130839549);
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
    setTitle(getString(2131692227), getString(2131692227));
    this.rightViewText.setTextColor(-1);
    setRightButtonText(getString(2131719734), this);
    this.rightViewText.setContentDescription(getString(2131719734));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.mContentView.findViewById(2131365304));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.mContentView.findViewById(2131369651));
    this.r = ((TextView)this.mContentView.findViewById(2131373580));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.mContentView.findViewById(2131369639));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.mContentView.findViewById(2131369641));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)this.mContentView.findViewById(2131369640));
    this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)this.mContentView.findViewById(2131369638));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131380312));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131380314));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131380313));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131380311));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131379281));
    this.f = ((TextView)this.mContentView.findViewById(2131379283));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)this.mContentView.findViewById(2131368062));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFace2faceFace2FaceAddContactAdapter = new Face2FaceAddContactAdapter(getActivity(), getActivity().app, this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 5));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFace2faceFace2FaceAddContactAdapter);
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.mContentView.findViewById(2131370557));
    this.jdField_c_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.mContentView.findViewById(2131370620));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.mContentView.findViewById(2131364003));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTableLayout = ((TableLayout)this.mContentView.findViewById(2131365848));
    this.g = ((TextView)this.mContentView.findViewById(2131372508));
    this.h = ((TextView)this.mContentView.findViewById(2131380717));
    this.i = ((TextView)this.mContentView.findViewById(2131379305));
    this.j = ((TextView)this.mContentView.findViewById(2131367427));
    this.k = ((TextView)this.mContentView.findViewById(2131367043));
    this.l = ((TextView)this.mContentView.findViewById(2131378224));
    this.m = ((TextView)this.mContentView.findViewById(2131377923));
    this.n = ((TextView)this.mContentView.findViewById(2131366218));
    this.o = ((TextView)this.mContentView.findViewById(2131372306));
    this.p = ((TextView)this.mContentView.findViewById(2131382135));
    this.q = ((TextView)this.mContentView.findViewById(2131365650));
    this.g.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.g.setOnTouchListener(UITools.a);
    this.h.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.h.setOnTouchListener(UITools.a);
    this.i.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.i.setOnTouchListener(UITools.a);
    this.j.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.j.setOnTouchListener(UITools.a);
    this.k.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.k.setOnTouchListener(UITools.a);
    this.l.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.l.setOnTouchListener(UITools.a);
    this.m.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.m.setOnTouchListener(UITools.a);
    this.n.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.n.setOnTouchListener(UITools.a);
    this.o.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.o.setOnTouchListener(UITools.a);
    this.p.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.p.setOnTouchListener(UITools.a);
    this.q.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.q.setOnTouchListener(UITools.a);
  }
  
  private void m()
  {
    if ((isDetached()) || (getActivity() == null)) {
      return;
    }
    if (getActivity().isResume())
    {
      p();
      QQToast.a(getActivity(), getString(2131692238), 0).a();
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
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFace2faceFace2FaceAddContactAdapter.notifyDataSetChanged();
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
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFace2faceFace2FaceAddContactAdapter.a();
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
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFace2faceFace2FaceAddContactPresenter != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFace2faceFace2FaceAddContactAdapter != null) && (getActivity() != null) && (!getActivity().isFinishing()))
    {
      if (QLog.isDebugVersion()) {
        QLog.d("Face2FaceAddContactFragment", 2, "sendFace2FaceHeartBeat isNetworkAvailable:" + NetworkUtil.a());
      }
      if (NetworkUtil.a())
      {
        Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFace2faceFace2FaceAddContactAdapter.a();
        ArrayList localArrayList = new ArrayList();
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          Face2FaceFriendInfo localFace2FaceFriendInfo = (Face2FaceFriendInfo)((Iterator)localObject).next();
          if (localFace2FaceFriendInfo != null) {
            localArrayList.add(localFace2FaceFriendInfo.jdField_a_of_type_JavaLangString);
          }
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFace2faceFace2FaceAddContactPresenter.a(localArrayList);
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
    if (i1 < this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFace2faceFace2FaceAddContactAdapter.a().size()) {
      if (!paramString.equals(((Face2FaceFriendInfo)this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFace2faceFace2FaceAddContactAdapter.a().get(i1)).jdField_a_of_type_JavaLangString)) {}
    }
    for (;;)
    {
      if (QLog.isDebugVersion()) {
        QLog.d("Face2FaceAddContactFragment", 2, "deleteFriend delIndex:" + i1);
      }
      if (i1 == -1) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFace2faceFace2FaceAddContactAdapter.a().remove(i1);
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFace2faceFace2FaceAddContactAdapter.notifyItemRemoved(i1);
      e(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFace2faceFace2FaceAddContactAdapter.a().size());
      return;
      i1 += 1;
      break label57;
      i1 = -1;
    }
  }
  
  public void a(String paramString, List<Face2FaceFriendInfo> paramList)
  {
    if ((isDetached()) || (getActivity() == null) || (paramList == null) || (paramList.size() <= 0) || (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFace2faceFace2FaceAddContactAdapter.a() == null)) {
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
    int i1 = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFace2faceFace2FaceAddContactAdapter.a().size();
    paramString = paramList.iterator();
    while (paramString.hasNext())
    {
      paramList = (Face2FaceFriendInfo)paramString.next();
      if (!this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFace2faceFace2FaceAddContactAdapter.a().contains(paramList)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFace2faceFace2FaceAddContactAdapter.a().add(i1, paramList);
      }
    }
    int i2 = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFace2faceFace2FaceAddContactAdapter.a().size();
    if (i1 != i2) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFace2faceFace2FaceAddContactAdapter.notifyItemRangeInserted(i1, i2 - i1);
    }
    e(i2);
  }
  
  public void a(List<String> paramList)
  {
    if ((isDetached()) || (getActivity() == null) || (paramList == null) || (getActivity().app == null)) {}
    ArrayList localArrayList;
    do
    {
      FriendsManager localFriendsManager;
      do
      {
        do
        {
          return;
          if (QLog.isColorLevel()) {
            QLog.d("Face2FaceAddContactFragment", 2, " onFace2FaceAddContactHeartBeat() missingList.size() = " + paramList.size());
          }
        } while (paramList.size() <= 0);
        localFriendsManager = (FriendsManager)getActivity().app.getManager(QQManagerFactory.FRIENDS_MANAGER);
      } while (localFriendsManager == null);
      localArrayList = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject = (String)paramList.next();
        Face2FaceFriendInfo localFace2FaceFriendInfo = new Face2FaceFriendInfo();
        localFace2FaceFriendInfo.jdField_a_of_type_JavaLangString = ((String)localObject);
        localFace2FaceFriendInfo.jdField_a_of_type_Int = 1;
        if (!this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFace2faceFace2FaceAddContactAdapter.a().contains(localFace2FaceFriendInfo))
        {
          localObject = localFriendsManager.a((String)localObject);
          if ((localObject != null) && (((Friends)localObject).isFriend()))
          {
            localFace2FaceFriendInfo.b = ((Friends)localObject).getFriendNick();
            localArrayList.add(localFace2FaceFriendInfo);
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
      Face2FaceAddContactUtils.a("0X800AB65", "", "", "");
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
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFace2faceFace2FaceAddContactPresenter.a(getActivity());
    j();
  }
  
  public void e()
  {
    if ((isDetached()) || (getActivity() == null)) {
      return;
    }
    p();
    QQToast.a(getActivity(), getString(2131719446), 0).a();
  }
  
  public void f()
  {
    if ((isDetached()) || (getActivity() == null)) {
      return;
    }
    p();
    QQToast.a(getActivity(), getString(2131692239), 0).a();
    Face2FaceAddContactUtils.a("0X800AB64", "", "", "");
  }
  
  public void g()
  {
    if ((isDetached()) || (getActivity() == null)) {}
    do
    {
      return;
      p();
      QQToast.a(getActivity(), getString(2131719987), 0).a();
    } while (this.jdField_a_of_type_JavaLangStringBuffer == null);
    Face2FaceAddContactUtils.a("0X800AB5F", "", "", this.jdField_a_of_type_JavaLangStringBuffer.toString());
  }
  
  public int getContentLayoutId()
  {
    return 2131559232;
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
    Face2FaceAddContactUtils.a("0X800AB60", "", "", "");
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    super.initWindowStyleAndAnimation(paramActivity);
    paramActivity.overridePendingTransition(2130771981, 2130771982);
  }
  
  public boolean isTransparent()
  {
    return true;
  }
  
  public void j()
  {
    if (!Face2FaceAddContactUtils.b(getActivity().app)) {
      return;
    }
    Face2FaceAddContactUtils.b(getActivity().app);
    ReportDialog localReportDialog = new ReportDialog(getActivity(), 2131755842);
    localReportDialog.setContentView(2131558469);
    Button localButton1 = (Button)localReportDialog.findViewById(2131365768);
    Button localButton2 = (Button)localReportDialog.findViewById(2131365772);
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = getResources().getDrawable(2130838114);
    ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable;
    ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = AIOUtils.a(170.0F, getResources());
    localObject = URLDrawable.getDrawable("https://pub.idqqimg.com/pc/misc/files/20200114/bd76e3d896aa49cd91e73aa332b1ff22.png", (URLDrawable.URLDrawableOptions)localObject);
    localReportDialog.findViewById(2131365834).setBackgroundDrawable((Drawable)localObject);
    localButton1.setOnClickListener(new Face2FaceAddContactFragment.3(this, localReportDialog));
    localButton2.setOnClickListener(new Face2FaceAddContactFragment.4(this, localReportDialog));
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
            this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFace2faceFace2FaceAddContactPresenter.a(getActivity(), this.jdField_a_of_type_JavaLangStringBuffer.toString(), paramIntent);
          }
          if (QLog.isDebugVersion()) {
            QLog.d("Face2FaceAddContactFragment", 2, "onActivityResult VERIFY_REQUEST_CODE, verifySig:" + paramIntent);
          }
          Face2FaceAddContactUtils.a("0X800AB66", "", "", "");
          return;
        }
      } while (paramInt2 != 0);
      p();
      QQToast.a(getActivity(), getString(2131692241), 0).a();
      return;
    } while (getActivity().checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0);
    r();
  }
  
  public boolean onBackEvent()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFace2faceFace2FaceAddContactPresenter != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFace2faceFace2FaceAddContactPresenter.b();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFace2faceFace2FaceAddContactAdapter != null) {
      Face2FaceAddContactUtils.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFace2faceFace2FaceAddContactAdapter.a());
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
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFace2faceFace2FaceAddContactPresenter != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFace2faceFace2FaceAddContactPresenter.a();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFace2faceFace2FaceAddContactAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFace2faceFace2FaceAddContactAdapter.b();
    }
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
  }
  
  public void onFinish()
  {
    super.onFinish();
    if (getActivity() != null) {
      getActivity().overridePendingTransition(0, 2130771980);
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
      QQToast.a(getActivity(), getString(2131692238), 0).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.face2face.Face2FaceAddContactFragment
 * JD-Core Version:    0.7.0.1
 */