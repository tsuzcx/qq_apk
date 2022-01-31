package com.tencent.mobileqq.activity.aio.rebuild;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.ApngImage;
import com.tencent.image.QQLiveImage;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.ChatTextSizeSettingActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.ChatBackground;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.item.PicItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.mobileqq.pic.DownCallBack;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.ScrollerRunnable;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.LayoutParams;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import vvm;
import vvo;
import vvp;
import vvq;
import vvr;
import vvs;
import vvv;

public class MultiForwardChatPie
  extends BaseChatPie
{
  public boolean O;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private AIOAnimationConatiner jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner;
  private Drawable[] jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable;
  private ChatAdapter1 jdField_b_of_type_ComTencentMobileqqActivityAioChatAdapter1;
  private ChatXListView jdField_b_of_type_ComTencentMobileqqBubbleChatXListView;
  ScrollerRunnable jdField_b_of_type_ComTencentMobileqqWidgetScrollerRunnable;
  public List b;
  public MqqHandler b;
  public Runnable c;
  private RelativeLayout e;
  private RelativeLayout f;
  public String f;
  public String g;
  public long h;
  private long i;
  private TextView j;
  private final int m;
  private int jdField_n_of_type_Int;
  private ImageView jdField_n_of_type_AndroidWidgetImageView;
  private int jdField_o_of_type_Int;
  View jdField_o_of_type_AndroidViewView;
  private View p;
  
  public MultiForwardChatPie(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, FragmentActivity paramFragmentActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramFragmentActivity, paramContext);
    this.jdField_m_of_type_Int = 300;
    this.jdField_b_of_type_MqqOsMqqHandler = new vvm(this);
  }
  
  public void A()
  {
    if (this.jdField_c_of_type_JavaLangRunnable != null)
    {
      this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.removeCallbacks(this.jdField_c_of_type_JavaLangRunnable);
      this.jdField_c_of_type_JavaLangRunnable = null;
    }
    if (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity != null) {
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.finish();
    }
  }
  
  protected void C() {}
  
  protected void D() {}
  
  protected void E() {}
  
  protected void G()
  {
    if (this.u)
    {
      this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.postDelayed(new vvp(this), 600L);
      this.u = false;
    }
    QQLiveImage.resumeAll();
  }
  
  public DownCallBack a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return new vvv(this, this.h);
    case 1: 
      return new vvv(this, this.h);
    }
    return new vvs(this);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 0)
    {
      URLDrawable.resume();
      AbstractGifImage.resumeAll();
      ApngImage.resumeAll();
      QQLiveImage.resumeAll();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.c();
      return;
    }
    URLDrawable.pause();
    if (!PicItemBuilder.f)
    {
      AbstractGifImage.pauseAll();
      ApngImage.pauseAll();
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.b();
    QQLiveImage.pauseAll();
  }
  
  protected boolean a(boolean paramBoolean)
  {
    this.u = true;
    this.O = BaseChatItemLayout.a;
    BaseChatItemLayout.a = false;
    this.E = ThemeUtil.isDefaultOrDIYTheme(false);
    Object localObject1 = (ViewGroup)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131363491);
    ((ViewGroup)localObject1).removeView(this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131362840));
    Object localObject2 = View.inflate(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 2130968651, null);
    ((View)localObject2).setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
    ((ViewGroup)localObject1).addView((View)localObject2, 0);
    this.jdField_n_of_type_Int = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getIntExtra("callback_type", 1);
    this.jdField_f_of_type_JavaLangString = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getStringExtra("multi_url");
    this.h = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getLongExtra("multi_uniseq", 0L);
    this.g = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131433649);
    if (QLog.isDevelopLevel()) {
      QLog.d("MultiMsg", 4, "MultiForwardActivity.doOnCreate ResID = " + this.jdField_f_of_type_JavaLangString + "  msg.uniseq = " + this.h + " downCallBackType" + this.jdField_n_of_type_Int);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO = ((NavBarAIO)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131363244));
    this.jdField_m_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131363996));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131363245));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131363474));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131364003));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131363994));
    this.jdField_a_of_type_Float = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources().getDisplayMetrics().density;
    AIOUtils.a(this.jdField_b_of_type_AndroidWidgetImageView, 0, 0, 0, (int)(50.0F * this.jdField_a_of_type_Float + 0.5F));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131363995));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131435275));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131363378));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131363999));
    this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131433698));
    b(false);
    this.jdField_e_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131363024));
    this.jdField_f_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131363027));
    this.jdField_n_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131363028));
    this.j = ((TextView)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131363029));
    this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView = ((ChatXListView)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131363025));
    this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.setStackFromBottom(false);
    this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.setTranscriptMode(0);
    this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.setLongClickable(true);
    this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.setDelAnimationDuration(300L);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner = ((AIOAnimationConatiner)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131363026));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.a = this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView;
    this.jdField_b_of_type_ComTencentMobileqqWidgetScrollerRunnable = new ScrollerRunnable(this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView);
    localObject1 = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getExtras();
    localObject2 = ((Bundle)localObject1).getString("uin");
    String str = ((Bundle)localObject1).getString("troop_code");
    int k = ((Bundle)localObject1).getInt("uintype");
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = new SessionInfo();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString = ((String)localObject2);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int = k;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString = str;
    MultiMsgManager.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((String)localObject2, k, this.h);
    if (localObject1 != null) {
      MultiMsgManager.a().a(((MessageRecord)localObject1).issend);
    }
    for (;;)
    {
      this.p = new View(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
      this.p.setLayoutParams(new AbsListView.LayoutParams(-1, (int)TypedValue.applyDimension(1, 10.0F, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getDisplayMetrics())));
      this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.addFooterView(this.p);
      this.jdField_b_of_type_ComTencentMobileqqWidgetScrollerRunnable = new ScrollerRunnable(this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView);
      this.jdField_b_of_type_ComTencentMobileqqActivityAioChatAdapter1 = new ChatAdapter1(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner, this);
      this.jdField_b_of_type_ComTencentMobileqqActivityAioChatAdapter1.a = Boolean.valueOf(false);
      if (this.jdField_o_of_type_AndroidViewView == null)
      {
        this.jdField_o_of_type_AndroidViewView = new View(this.jdField_a_of_type_AndroidContentContext);
        k = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131558448);
        this.jdField_o_of_type_AndroidViewView.setLayoutParams(new AbsListView.LayoutParams(-1, k));
        this.jdField_o_of_type_AndroidViewView.setId(2131361977);
        this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.addHeaderView(this.jdField_o_of_type_AndroidViewView, null, false);
        this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.setOverscrollHeaderTop(k);
      }
      this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.setAdapter(this.jdField_b_of_type_ComTencentMobileqqActivityAioChatAdapter1);
      localObject1 = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp()).inflate(2130968796, null);
      this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.setOverScrollHeader((View)localObject1);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground = new ChatBackground();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Int = ChatTextSizeSettingActivity.a(BaseApplicationImpl.getContext());
      if (ChatBackground.a(BaseApplicationImpl.getContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true, 7, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground)) {
        this.jdField_e_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      }
      ThreadManager.post(new vvo(this), 8, null, true);
      this.jdField_d_of_type_AndroidWidgetTextView.setText(this.g);
      if (this.E) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setBackgroundResource(2130845871);
      this.jdField_m_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      localObject1 = this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131494212);
      this.jdField_d_of_type_AndroidWidgetTextView.setTextColor((ColorStateList)localObject1);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      return true;
      MultiMsgManager.a().a(0);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setBackgroundResource(2130845872);
    this.jdField_m_of_type_AndroidWidgetImageView.setVisibility(0);
    if (!TextUtils.isEmpty(this.jdField_b_of_type_AndroidWidgetTextView.getText())) {
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    for (;;)
    {
      localObject1 = this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131494213);
      this.jdField_d_of_type_AndroidWidgetTextView.setTextColor((ColorStateList)localObject1);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      return true;
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
    }
  }
  
  public void aX()
  {
    Object localObject2 = MultiMsgManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.h);
    if ((localObject2 != null) && (((List)localObject2).size() > 0))
    {
      Object localObject1 = new ArrayList();
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((List)localObject1).add((ChatMessage)((Iterator)localObject2).next());
      }
      this.jdField_b_of_type_JavaUtilList = ((List)localObject1);
      localObject1 = ChatActivityUtils.a(this.jdField_b_of_type_JavaUtilList, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      localObject1 = ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplicationImpl.getContext(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (MessageRecord)localObject1);
      if (QLog.isColorLevel()) {
        QLog.d("MultiMsg", 2, "MultiForwardActivity.onDownload, requestReceiveMultiMsg uses " + (System.currentTimeMillis() - this.i));
      }
      MultiMsgManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_JavaUtilList, true);
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.runOnUiThread(new vvq(this, (CharSequence)localObject1));
      return;
    }
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.runOnUiThread(new vvr(this));
  }
  
  public boolean b(int paramInt)
  {
    if (this.jdField_c_of_type_JavaLangRunnable != null)
    {
      this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.removeCallbacks(this.jdField_c_of_type_JavaLangRunnable);
      this.jdField_c_of_type_JavaLangRunnable = null;
    }
    return false;
  }
  
  protected boolean e()
  {
    if (this.jdField_c_of_type_JavaLangRunnable != null)
    {
      this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.removeCallbacks(this.jdField_c_of_type_JavaLangRunnable);
      this.jdField_c_of_type_JavaLangRunnable = null;
    }
    BaseChatItemLayout.a = this.O;
    return false;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    A();
  }
  
  public boolean x()
  {
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null)
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getDrawable(2130838600);
      this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable = this.jdField_d_of_type_AndroidWidgetTextView.getCompoundDrawables();
      this.jdField_o_of_type_Int = this.jdField_d_of_type_AndroidWidgetTextView.getCompoundDrawablePadding();
      this.jdField_d_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(10);
      this.jdField_d_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[1], this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[2], this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[3]);
      ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).start();
      return true;
    }
    return false;
  }
  
  public boolean y()
  {
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
    {
      ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).stop();
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
      this.jdField_d_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(this.jdField_o_of_type_Int);
      this.jdField_d_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[0], this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[1], this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[2], this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[3]);
      return true;
    }
    return false;
  }
  
  protected void z()
  {
    this.jdField_b_of_type_ComTencentMobileqqActivityAioChatAdapter1.c();
    if (this.jdField_b_of_type_JavaUtilList != null) {
      this.jdField_b_of_type_JavaUtilList.clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.MultiForwardChatPie
 * JD-Core Version:    0.7.0.1
 */