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
import com.tencent.mobileqq.app.BaseActivity;
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
    case 2131366108: 
    case 2131366893: 
    case 2131367209: 
    case 2131371891: 
    case 2131372092: 
    case 2131377346: 
    case 2131377639: 
    case 2131378657: 
    case 2131379985: 
    case 2131381339: 
      this.jdField_a_of_type_JavaLangStringBuffer.append(((TextView)paramView).getText());
      return;
    }
    if ((paramInt > 0) && (paramInt < 4)) {
      this.jdField_a_of_type_JavaLangStringBuffer.deleteCharAt(paramInt - 1);
    }
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt != 4) {
            return;
          }
          this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(0);
          this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(4);
          this.jdField_d_of_type_AndroidWidgetTextView.setText("");
          return;
        }
        this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(4);
        this.jdField_c_of_type_AndroidWidgetTextView.setText("");
        return;
      }
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
      this.jdField_b_of_type_AndroidWidgetTextView.setText("");
      return;
    }
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetTextView.setText("");
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
      if (!NetworkUtil.isNetSupport(getBaseActivity()))
      {
        QQToast.a(getBaseActivity(), 2131694475, 0).a();
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(500, 500L);
        return;
      }
      if (a(this.jdField_a_of_type_JavaLangStringBuffer.toString()))
      {
        QQToast.a(getBaseActivity(), getString(2131719719), 0).a();
        Face2FaceAddContactUtils.a("0X800AB5F", "", "", this.jdField_a_of_type_JavaLangStringBuffer.toString());
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(500, 500L);
        return;
      }
      this.r.setVisibility(0);
      this.r.setBackgroundDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).start();
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFace2faceFace2FaceAddContactPresenter.a(getBaseActivity(), this.jdField_a_of_type_JavaLangStringBuffer.toString(), null);
    }
  }
  
  private void d(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt != 4) {
            return;
          }
          this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(4);
          this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
          this.jdField_d_of_type_AndroidWidgetTextView.setText(String.valueOf(this.jdField_a_of_type_JavaLangStringBuffer.charAt(paramInt - 1)));
          return;
        }
        this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(4);
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_c_of_type_AndroidWidgetTextView.setText(String.valueOf(this.jdField_a_of_type_JavaLangStringBuffer.charAt(paramInt - 1)));
        return;
      }
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(4);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(String.valueOf(this.jdField_a_of_type_JavaLangStringBuffer.charAt(paramInt - 1)));
      return;
    }
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(String.valueOf(this.jdField_a_of_type_JavaLangStringBuffer.charAt(paramInt - 1)));
  }
  
  private void e(int paramInt)
  {
    if (this.f != null)
    {
      if (isDetached()) {
        return;
      }
      if (this.f.getVisibility() != 0)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
        this.f.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(AIOUtils.b(8.0F, getResources()));
        this.jdField_b_of_type_AndroidWidgetTextView.setTextSize(AIOUtils.b(8.0F, getResources()));
        this.jdField_c_of_type_AndroidWidgetTextView.setTextSize(AIOUtils.b(8.0F, getResources()));
        this.jdField_d_of_type_AndroidWidgetTextView.setTextSize(AIOUtils.b(8.0F, getResources()));
      }
      if (paramInt > 0)
      {
        String str = getString(2131692160, new Object[] { Integer.valueOf(paramInt) });
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
      this.f.setText(getString(2131692159));
    }
  }
  
  private void k()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFace2faceFace2FaceAddContactPresenter = new Face2FaceAddContactPresenter(this);
    this.jdField_a_of_type_JavaLangStringBuffer = new StringBuffer();
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130839406);
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  private void l()
  {
    SystemBarCompact localSystemBarCompact = ((PublicFragmentActivity)getBaseActivity()).mSystemBarComp;
    if (localSystemBarCompact != null) {
      localSystemBarCompact.setStatusBarColor(-16777216);
    }
    getTitleBarView().setBackgroundResource(0);
    getTitleBarView().setBackgroundColor(-16777216);
    this.leftView.setVisibility(8);
    this.centerView.setTextColor(-1);
    setTitle(getString(2131692153), getString(2131692153));
    this.rightViewText.setTextColor(-1);
    setRightButtonText(getString(2131719458), this);
    this.rightViewText.setContentDescription(getString(2131719458));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.mContentView.findViewById(2131365179));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.mContentView.findViewById(2131369351));
    this.r = ((TextView)this.mContentView.findViewById(2131373160));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.mContentView.findViewById(2131369340));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.mContentView.findViewById(2131369342));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)this.mContentView.findViewById(2131369341));
    this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)this.mContentView.findViewById(2131369339));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131379623));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131379625));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131379624));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131379622));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131378641));
    this.f = ((TextView)this.mContentView.findViewById(2131378643));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)this.mContentView.findViewById(2131367814));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFace2faceFace2FaceAddContactAdapter = new Face2FaceAddContactAdapter(getBaseActivity(), getBaseActivity().app, this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(new GridLayoutManager(getBaseActivity(), 5));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFace2faceFace2FaceAddContactAdapter);
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.mContentView.findViewById(2131370215));
    this.jdField_c_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.mContentView.findViewById(2131370273));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.mContentView.findViewById(2131363930));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTableLayout = ((TableLayout)this.mContentView.findViewById(2131365684));
    this.g = ((TextView)this.mContentView.findViewById(2131372092));
    this.h = ((TextView)this.mContentView.findViewById(2131379985));
    this.i = ((TextView)this.mContentView.findViewById(2131378657));
    this.j = ((TextView)this.mContentView.findViewById(2131367209));
    this.k = ((TextView)this.mContentView.findViewById(2131366893));
    this.l = ((TextView)this.mContentView.findViewById(2131377639));
    this.m = ((TextView)this.mContentView.findViewById(2131377346));
    this.n = ((TextView)this.mContentView.findViewById(2131366108));
    this.o = ((TextView)this.mContentView.findViewById(2131371891));
    this.p = ((TextView)this.mContentView.findViewById(2131381339));
    this.q = ((TextView)this.mContentView.findViewById(2131365494));
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
    if (!isDetached())
    {
      if (getBaseActivity() == null) {
        return;
      }
      if (getBaseActivity().isResume())
      {
        p();
        QQToast.a(getBaseActivity(), getString(2131692164), 0).a();
        return;
      }
      this.jdField_a_of_type_Boolean = true;
    }
  }
  
  private void n()
  {
    if (!isDetached())
    {
      if (getBaseActivity() == null) {
        return;
      }
      Intent localIntent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
      localIntent.setData(Uri.fromParts("package", getBaseActivity().getPackageName(), null));
      getBaseActivity().startActivityForResult(localIntent, 1002);
    }
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
    if (isDetached()) {
      return;
    }
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
    Handler localHandler = this.jdField_a_of_type_AndroidOsHandler;
    if (localHandler != null)
    {
      localHandler.removeMessages(301);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(401);
    }
  }
  
  private void q()
  {
    StringBuffer localStringBuffer = this.jdField_a_of_type_JavaLangStringBuffer;
    localStringBuffer.delete(0, localStringBuffer.length());
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
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFace2faceFace2FaceAddContactPresenter != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFace2faceFace2FaceAddContactAdapter != null) && (getBaseActivity() != null) && (!getBaseActivity().isFinishing()))
    {
      Object localObject1;
      if (QLog.isDebugVersion())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("sendFace2FaceHeartBeat isNetworkAvailable:");
        ((StringBuilder)localObject1).append(NetworkUtil.isNetworkAvailable());
        QLog.d("Face2FaceAddContactFragment", 2, ((StringBuilder)localObject1).toString());
      }
      if (NetworkUtil.isNetworkAvailable())
      {
        Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFace2faceFace2FaceAddContactAdapter.a();
        localObject1 = new ArrayList();
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          Face2FaceFriendInfo localFace2FaceFriendInfo = (Face2FaceFriendInfo)((Iterator)localObject2).next();
          if (localFace2FaceFriendInfo != null) {
            ((List)localObject1).add(localFace2FaceFriendInfo.jdField_a_of_type_JavaLangString);
          }
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFace2faceFace2FaceAddContactPresenter.a((List)localObject1);
        return;
      }
      b(20000);
    }
  }
  
  public void a()
  {
    if (!isDetached())
    {
      if (getBaseActivity() == null) {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Face2FaceAddContactFragment", 2, "onExitFace2FaceAddContact()");
      }
      p();
    }
  }
  
  public void a(int paramInt)
  {
    if (!isDetached())
    {
      if (getBaseActivity() == null) {
        return;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onEnterFace2FaceAddContactSuccess() expireTimeMs:");
        localStringBuilder.append(paramInt);
        QLog.d("Face2FaceAddContactFragment", 2, localStringBuilder.toString());
      }
      this.jdField_a_of_type_Long = SystemClock.elapsedRealtime();
      o();
      if ((this.jdField_a_of_type_AndroidOsHandler != null) && (getBaseActivity() != null) && (!getBaseActivity().isFinishing()))
      {
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(401);
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(401, paramInt);
      }
    }
  }
  
  public void a(String paramString)
  {
    if (QLog.isDebugVersion())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("deleteFriend delFriendUin:");
      localStringBuilder.append(paramString);
      QLog.d("Face2FaceAddContactFragment", 2, localStringBuilder.toString());
    }
    if ((!isDetached()) && (getBaseActivity() != null))
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      int i1 = 0;
      while (i1 < this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFace2faceFace2FaceAddContactAdapter.a().size())
      {
        if (paramString.equals(((Face2FaceFriendInfo)this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFace2faceFace2FaceAddContactAdapter.a().get(i1)).jdField_a_of_type_JavaLangString)) {
          break label117;
        }
        i1 += 1;
      }
      i1 = -1;
      label117:
      if (QLog.isDebugVersion())
      {
        paramString = new StringBuilder();
        paramString.append("deleteFriend delIndex:");
        paramString.append(i1);
        QLog.d("Face2FaceAddContactFragment", 2, paramString.toString());
      }
      if (i1 != -1)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFace2faceFace2FaceAddContactAdapter.a().remove(i1);
        this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFace2faceFace2FaceAddContactAdapter.notifyItemRemoved(i1);
        e(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFace2faceFace2FaceAddContactAdapter.a().size());
      }
    }
  }
  
  public void a(String paramString, List<Face2FaceFriendInfo> paramList)
  {
    if ((!isDetached()) && (getBaseActivity() != null) && (paramList != null) && (paramList.size() > 0))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFace2faceFace2FaceAddContactAdapter.a() == null) {
        return;
      }
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append(" onFace2FaceAddContactPush() faceFriends.size() = ");
        paramString.append(paramList.size());
        QLog.d("Face2FaceAddContactFragment", 2, paramString.toString());
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
  }
  
  public void a(List<String> paramList)
  {
    if ((!isDetached()) && (getBaseActivity() != null) && (paramList != null))
    {
      if (getBaseActivity().app == null) {
        return;
      }
      Object localObject1;
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(" onFace2FaceAddContactHeartBeat() missingList.size() = ");
        ((StringBuilder)localObject1).append(paramList.size());
        QLog.d("Face2FaceAddContactFragment", 2, ((StringBuilder)localObject1).toString());
      }
      if (paramList.size() > 0)
      {
        localObject1 = (FriendsManager)getBaseActivity().app.getManager(QQManagerFactory.FRIENDS_MANAGER);
        if (localObject1 != null)
        {
          ArrayList localArrayList = new ArrayList();
          paramList = paramList.iterator();
          while (paramList.hasNext())
          {
            Object localObject2 = (String)paramList.next();
            Face2FaceFriendInfo localFace2FaceFriendInfo = new Face2FaceFriendInfo();
            localFace2FaceFriendInfo.jdField_a_of_type_JavaLangString = ((String)localObject2);
            localFace2FaceFriendInfo.jdField_a_of_type_Int = 1;
            if (!this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFace2faceFace2FaceAddContactAdapter.a().contains(localFace2FaceFriendInfo))
            {
              localObject2 = ((FriendsManager)localObject1).a((String)localObject2);
              if ((localObject2 != null) && (((Friends)localObject2).isFriend()))
              {
                localFace2FaceFriendInfo.b = ((Friends)localObject2).getFriendNick();
                localArrayList.add(localFace2FaceFriendInfo);
              }
            }
          }
          if (localArrayList.size() > 0) {
            a(getBaseActivity().app.getCurrentUin(), localArrayList);
          }
        }
      }
    }
  }
  
  public void b()
  {
    if (!isDetached())
    {
      if (getBaseActivity() == null) {
        return;
      }
      Handler localHandler = this.jdField_a_of_type_AndroidOsHandler;
      if (localHandler != null) {
        localHandler.sendEmptyMessage(6);
      }
    }
  }
  
  public void b(int paramInt)
  {
    if (QLog.isDebugVersion())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("startFace2FaceAddContactHeartBeat delayTimeMs:");
      localStringBuilder.append(paramInt);
      QLog.d("Face2FaceAddContactFragment", 2, localStringBuilder.toString());
    }
    if ((this.jdField_a_of_type_AndroidOsHandler != null) && (getBaseActivity() != null) && (!getBaseActivity().isFinishing())) {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(301, paramInt);
    }
  }
  
  public void b(String paramString)
  {
    Intent localIntent;
    if (!isDetached())
    {
      if (getBaseActivity() == null) {
        return;
      }
      localIntent = new Intent(getBaseActivity(), QQBrowserActivity.class);
      localIntent.putExtra("uin", getBaseActivity().app.getCurrentUin());
      localIntent.putExtra("url", paramString);
    }
    try
    {
      getBaseActivity().startActivityForResult(localIntent, 1001);
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
  
  protected void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    k();
    l();
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFace2faceFace2FaceAddContactPresenter.a(getBaseActivity());
    j();
  }
  
  public void e()
  {
    if (!isDetached())
    {
      if (getBaseActivity() == null) {
        return;
      }
      p();
      QQToast.a(getBaseActivity(), getString(2131719164), 0).a();
    }
  }
  
  public void f()
  {
    if (!isDetached())
    {
      if (getBaseActivity() == null) {
        return;
      }
      p();
      QQToast.a(getBaseActivity(), getString(2131692165), 0).a();
      Face2FaceAddContactUtils.a("0X800AB64", "", "", "");
    }
  }
  
  public void g()
  {
    if (!isDetached())
    {
      if (getBaseActivity() == null) {
        return;
      }
      p();
      QQToast.a(getBaseActivity(), getString(2131719719), 0).a();
      StringBuffer localStringBuffer = this.jdField_a_of_type_JavaLangStringBuffer;
      if (localStringBuffer != null) {
        Face2FaceAddContactUtils.a("0X800AB5F", "", "", localStringBuffer.toString());
      }
    }
  }
  
  protected int getContentLayoutId()
  {
    return 2131559109;
  }
  
  public void h()
  {
    if (!isDetached())
    {
      if (getBaseActivity() == null) {
        return;
      }
      Handler localHandler = this.jdField_a_of_type_AndroidOsHandler;
      if (localHandler != null) {
        localHandler.sendEmptyMessage(5);
      }
    }
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
    paramActivity.overridePendingTransition(2130771993, 2130771994);
  }
  
  protected boolean isTransparent()
  {
    return true;
  }
  
  public void j()
  {
    if (!Face2FaceAddContactUtils.b(getBaseActivity().app)) {
      return;
    }
    Face2FaceAddContactUtils.b(getBaseActivity().app);
    ReportDialog localReportDialog = new ReportDialog(getBaseActivity(), 2131756189);
    localReportDialog.setContentView(2131558498);
    Button localButton1 = (Button)localReportDialog.findViewById(2131365605);
    Button localButton2 = (Button)localReportDialog.findViewById(2131365609);
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = getResources().getDrawable(2130846439);
    ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable;
    ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = AIOUtils.b(170.0F, getResources());
    localObject = URLDrawable.getDrawable("https://pub.idqqimg.com/pc/misc/files/20200114/bd76e3d896aa49cd91e73aa332b1ff22.png", (URLDrawable.URLDrawableOptions)localObject);
    localReportDialog.findViewById(2131365671).setBackgroundDrawable((Drawable)localObject);
    localButton1.setOnClickListener(new Face2FaceAddContactFragment.3(this, localReportDialog));
    localButton2.setOnClickListener(new Face2FaceAddContactFragment.4(this, localReportDialog));
    localReportDialog.show();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    StringBuilder localStringBuilder;
    if (QLog.isDebugVersion())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onActivityResult resultCode:");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(" requestCode:");
      localStringBuilder.append(paramInt1);
      QLog.d("Face2FaceAddContactFragment", 2, localStringBuilder.toString());
    }
    if (paramInt1 != 1001)
    {
      if (paramInt1 != 1002) {
        return;
      }
      if (getBaseActivity().checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0) {
        r();
      }
    }
    else
    {
      if ((paramIntent != null) && (paramInt2 == -1))
      {
        paramIntent = paramIntent.getStringExtra("ticket");
        if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangStringBuffer.toString())) && (this.jdField_a_of_type_JavaLangStringBuffer.length() == 4)) {
          this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFace2faceFace2FaceAddContactPresenter.a(getBaseActivity(), this.jdField_a_of_type_JavaLangStringBuffer.toString(), paramIntent);
        }
        if (QLog.isDebugVersion())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("onActivityResult VERIFY_REQUEST_CODE, verifySig:");
          localStringBuilder.append(paramIntent);
          QLog.d("Face2FaceAddContactFragment", 2, localStringBuilder.toString());
        }
        Face2FaceAddContactUtils.a("0X800AB66", "", "", "");
        return;
      }
      if (paramInt2 == 0)
      {
        p();
        QQToast.a(getBaseActivity(), getString(2131692167), 0).a();
      }
    }
  }
  
  public boolean onBackEvent()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFace2faceFace2FaceAddContactPresenter;
    if (localObject != null) {
      ((Face2FaceAddContactPresenter)localObject).b();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFace2faceFace2FaceAddContactAdapter;
    if (localObject != null) {
      Face2FaceAddContactUtils.a(this.jdField_a_of_type_Long, ((Face2FaceAddContactAdapter)localObject).a());
    }
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    if (i1 != 2131363930)
    {
      if (i1 == 2131369233) {
        onBackEvent();
      }
    }
    else {
      n();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFace2faceFace2FaceAddContactPresenter;
    if (localObject != null) {
      ((Face2FaceAddContactPresenter)localObject).a();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFace2faceFace2FaceAddContactAdapter;
    if (localObject != null) {
      ((Face2FaceAddContactAdapter)localObject).b();
    }
    localObject = this.jdField_a_of_type_AndroidOsHandler;
    if (localObject != null) {
      ((Handler)localObject).removeCallbacksAndMessages(null);
    }
  }
  
  public void onFinish()
  {
    super.onFinish();
    if (getBaseActivity() != null) {
      getBaseActivity().overridePendingTransition(0, 2130771992);
    }
  }
  
  public void onResume()
  {
    super.onResume();
    BaseActivity localBaseActivity = getBaseActivity();
    if ((localBaseActivity != null) && ((localBaseActivity instanceof PublicFragmentActivity)))
    {
      SystemBarCompact localSystemBarCompact = ((PublicFragmentActivity)localBaseActivity).mSystemBarComp;
      if (localSystemBarCompact != null) {
        localSystemBarCompact.setStatusBarColor(-16777216);
      }
    }
    if ((localBaseActivity != null) && (this.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_Boolean = false;
      p();
      QQToast.a(getBaseActivity(), getString(2131692164), 0).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.face2face.Face2FaceAddContactFragment
 * JD-Core Version:    0.7.0.1
 */