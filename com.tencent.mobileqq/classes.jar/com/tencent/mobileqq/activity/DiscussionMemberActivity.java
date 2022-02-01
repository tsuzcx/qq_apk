package com.tencent.mobileqq.activity;

import Override;
import advi;
import advj;
import advk;
import advl;
import advm;
import advn;
import advo;
import advp;
import advq;
import advr;
import advs;
import advt;
import advu;
import afgr;
import amgz;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import antp;
import anvi;
import anvk;
import anvx;
import bipq;
import birc;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.widget.IndexView;
import com.tencent.mobileqq.widget.PinnedDividerListView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class DiscussionMemberActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, View.OnTouchListener, bipq, birc, AdapterView.OnItemClickListener
{
  private final int jdField_a_of_type_Int = 1;
  private advr jdField_a_of_type_Advr;
  public advt a;
  public View a;
  public EditText a;
  private ImageButton jdField_a_of_type_AndroidWidgetImageButton;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private IndexView jdField_a_of_type_ComTencentMobileqqWidgetIndexView;
  public PinnedDividerListView a;
  public XListView a;
  private String jdField_a_of_type_JavaLangString;
  public List<advq> a;
  View jdField_b_of_type_AndroidViewView;
  private EditText jdField_b_of_type_AndroidWidgetEditText;
  private String jdField_b_of_type_JavaLangString;
  private List<advq> jdField_b_of_type_JavaUtilList = new ArrayList();
  private View c;
  private View d;
  private View e;
  
  public DiscussionMemberActivity()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  private void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView = ((PinnedDividerListView)findViewById(2131364473));
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView = ((IndexView)findViewById(2131368807));
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setSelector(2131167296);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setOnItemClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setOnLayoutListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setIndex(new String[] { "$", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "#" });
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setOnIndexChangedListener(this);
    this.c = findViewById(2131376760);
    this.jdField_a_of_type_AndroidViewView = ((View)this.c.getParent());
    this.jdField_b_of_type_AndroidViewView = findViewById(2131377307);
    this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130838911);
    setTitle(anvx.a(2131702834));
    Object localObject = (RelativeLayout)getLayoutInflater().inflate(2131562804, this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView, false);
    ((RelativeLayout)localObject).setPadding(0, 0, 40, 0);
    this.jdField_b_of_type_AndroidWidgetEditText = ((EditText)((RelativeLayout)localObject).findViewById(2131366280));
    this.jdField_b_of_type_AndroidWidgetEditText.setFocusable(false);
    this.jdField_b_of_type_AndroidWidgetEditText.setOnTouchListener(this);
    ((Button)((RelativeLayout)localObject).findViewById(2131363845)).setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.addHeaderView((View)localObject);
    this.e = getLayoutInflater().inflate(2131559133, this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView, false);
    afgr localafgr = new afgr();
    localafgr.jdField_a_of_type_JavaLangString = this.app.getCurrentAccountUin();
    localafgr.c = ((ImageView)this.e.findViewById(2131369417));
    localafgr.c.setBackgroundDrawable(FaceDrawable.getUserFaceDrawable(this.app, this.app.getCurrentAccountUin(), (byte)3));
    localafgr.b = ((TextView)this.e.findViewById(2131380038));
    localObject = this.app.getCurrentNickname();
    TextView localTextView = localafgr.b;
    if ((localObject != null) && (((String)localObject).trim().length() > 0)) {}
    for (;;)
    {
      localTextView.setText((CharSequence)localObject);
      this.e.setTag(localafgr);
      this.e.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.addHeaderView(this.e);
      return;
      localObject = this.app.getCurrentAccountUin();
    }
  }
  
  private void b()
  {
    anvk localanvk = (anvk)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
    Object localObject = (antp)this.app.getManager(QQManagerFactory.DISCUSSION_MANAGER);
    if (localanvk != null)
    {
      localObject = ((antp)localObject).a(this.jdField_a_of_type_JavaLangString);
      if (localObject != null)
      {
        this.jdField_a_of_type_JavaUtilList.clear();
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          DiscussionMemberInfo localDiscussionMemberInfo = (DiscussionMemberInfo)((Iterator)localObject).next();
          if (localDiscussionMemberInfo.memberUin.equals(this.app.getCurrentAccountUin()))
          {
            this.jdField_b_of_type_JavaLangString = ContactUtils.getSelfDiscussionMemberName(this.app, localDiscussionMemberInfo);
          }
          else
          {
            advq localadvq = new advq(this, null);
            localadvq.jdField_a_of_type_JavaLangString = localDiscussionMemberInfo.memberUin;
            localadvq.jdField_b_of_type_JavaLangString = ContactUtils.getDiscussionMemberName(localDiscussionMemberInfo, this.app);
            localanvk.e(localadvq.jdField_a_of_type_JavaLangString);
            localadvq.d = ChnToSpell.a(localadvq.jdField_b_of_type_JavaLangString, 1);
            localadvq.c = ChnToSpell.a(localadvq.jdField_b_of_type_JavaLangString, 2);
            this.jdField_a_of_type_JavaUtilList.add(localadvq);
          }
        }
      }
    }
  }
  
  private void c()
  {
    ReportDialog localReportDialog = new ReportDialog(this);
    localReportDialog.setCanceledOnTouchOutside(true);
    localReportDialog.requestWindowFeature(1);
    localReportDialog.getWindow().setSoftInputMode(36);
    localReportDialog.setContentView(2131562813);
    Object localObject1 = localReportDialog.getWindow().getAttributes();
    ((WindowManager.LayoutParams)localObject1).x = 0;
    ((WindowManager.LayoutParams)localObject1).y = 0;
    ((WindowManager.LayoutParams)localObject1).width = -1;
    ((WindowManager.LayoutParams)localObject1).windowAnimations = 16973824;
    ((WindowManager.LayoutParams)localObject1).gravity = 51;
    localReportDialog.getWindow().setBackgroundDrawable(new ColorDrawable());
    int i = this.c.getHeight();
    Object localObject3 = new TranslateAnimation(0.0F, 0.0F, 0.0F, -i);
    ((TranslateAnimation)localObject3).setDuration(300L);
    ((TranslateAnimation)localObject3).setFillAfter(true);
    Object localObject2 = new TranslateAnimation(0.0F, 0.0F, -i, 0.0F);
    ((TranslateAnimation)localObject2).setDuration(300L);
    localObject1 = (InputMethodManager)getSystemService("input_method");
    advi localadvi = new advi(this, (TranslateAnimation)localObject3, localReportDialog, (TranslateAnimation)localObject2, i);
    ((TranslateAnimation)localObject3).setAnimationListener(localadvi);
    ((TranslateAnimation)localObject2).setAnimationListener(localadvi);
    this.jdField_a_of_type_AndroidViewView.startAnimation((Animation)localObject3);
    localObject3 = new advj(this);
    addObserver((BusinessObserver)localObject3);
    localReportDialog.setOnDismissListener(new advk(this, i, (TranslateAnimation)localObject2, (InputMethodManager)localObject1, (anvi)localObject3));
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)localReportDialog.findViewById(2131366280));
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new advu(this, null));
    this.jdField_a_of_type_AndroidWidgetEditText.setSelection(0);
    this.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)localReportDialog.findViewById(2131368378));
    this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(new advl(this));
    localObject2 = (Button)localReportDialog.findViewById(2131363845);
    ((Button)localObject2).setVisibility(0);
    ((Button)localObject2).setOnClickListener(new advm(this, localReportDialog));
    this.d = localReportDialog.findViewById(2131372032);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localReportDialog.findViewById(2131376602));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new advn(this, localReportDialog));
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)localReportDialog.findViewById(2131377153));
    this.jdField_a_of_type_ComTencentWidgetXListView.setBackgroundDrawable(getResources().getDrawable(2130838911));
    this.jdField_a_of_type_ComTencentWidgetXListView.setDividerHeight(0);
    this.jdField_b_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_Advt = new advt(this, this.jdField_b_of_type_JavaUtilList);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Advt);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnTouchListener(new advo(this, (InputMethodManager)localObject1));
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnItemClickListener(new advp(this, localReportDialog));
  }
  
  public void a(View paramView)
  {
    paramView = (amgz)paramView.getTag();
    if ((paramView != null) && (paramView.jdField_a_of_type_JavaLangString != null))
    {
      paramView = paramView.jdField_a_of_type_JavaLangString;
      if (paramView.equals(this.app.getCurrentAccountUin()))
      {
        paramView = new ProfileActivity.AllInOne(paramView, 0);
        paramView.g = 5;
        ProfileActivity.a(this, paramView, 1);
      }
    }
    else
    {
      return;
    }
    if (((anvk)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(paramView))
    {
      localAllInOne = new ProfileActivity.AllInOne(paramView, 1);
      localAllInOne.h = ContactUtils.getNick(this.app, paramView, 0);
      localAllInOne.g = 5;
      ProfileActivity.a(this, localAllInOne, 1);
      return;
    }
    ProfileActivity.AllInOne localAllInOne = new ProfileActivity.AllInOne(paramView, 46);
    localAllInOne.h = ContactUtils.getNick(this.app, paramView, 0);
    localAllInOne.f = paramView;
    localAllInOne.jdField_e_of_type_Int = 3000;
    localAllInOne.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    localAllInOne.g = 5;
    ProfileActivity.a(this, localAllInOne, 1);
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getFirstVisiblePosition() > 0) || ((this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getFirstVisiblePosition() == 0) && (this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getChildCount() < this.jdField_a_of_type_Advr.getCount() + this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getHeaderViewsCount()))) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setVisibility(0);
    }
  }
  
  public void a(String paramString)
  {
    if ("$".equals(paramString)) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setSelection(0);
    }
    int i;
    do
    {
      return;
      i = this.jdField_a_of_type_Advr.a(paramString);
    } while (i == -1);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setSelection(i + this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getHeaderViewsCount());
  }
  
  public void b(String paramString)
  {
    this.jdField_b_of_type_JavaUtilList.clear();
    if ((paramString.equals("")) || (paramString.trim().length() == 0))
    {
      this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(8);
      this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
      this.d.setVisibility(8);
    }
    for (;;)
    {
      this.jdField_a_of_type_Advt.notifyDataSetChanged();
      return;
      this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
      this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(0);
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      ArrayList localArrayList3 = new ArrayList();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        advq localadvq = (advq)localIterator.next();
        if (localadvq != null) {
          if ((localadvq.jdField_b_of_type_JavaLangString.equals(paramString)) || (localadvq.jdField_a_of_type_JavaLangString.equals(paramString)) || (localadvq.d.equals(paramString.toLowerCase())) || (localadvq.c.equals(paramString.toLowerCase()))) {
            localArrayList1.add(localadvq);
          } else if ((localadvq.jdField_b_of_type_JavaLangString.indexOf(paramString) == 0) || (localadvq.jdField_a_of_type_JavaLangString.indexOf(paramString) == 0) || (localadvq.c.indexOf(paramString.toLowerCase()) == 0) || (localadvq.d.indexOf(paramString.toLowerCase()) == 0)) {
            localArrayList2.add(localadvq);
          } else if ((localadvq.jdField_b_of_type_JavaLangString.indexOf(paramString) > 0) || (localadvq.jdField_a_of_type_JavaLangString.indexOf(paramString) > 0) || (localadvq.c.indexOf(paramString.toLowerCase()) > 0) || (localadvq.d.indexOf(paramString.toLowerCase()) > 0)) {
            localArrayList3.add(localadvq);
          }
        }
      }
      Collections.sort(localArrayList2, new advs(this, null));
      this.jdField_b_of_type_JavaUtilList.addAll(localArrayList1);
      this.jdField_b_of_type_JavaUtilList.addAll(localArrayList2);
      this.jdField_b_of_type_JavaUtilList.addAll(localArrayList3);
      if (this.jdField_b_of_type_JavaUtilList.isEmpty()) {
        this.d.setVisibility(0);
      } else {
        this.d.setVisibility(8);
      }
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((-1 == paramInt2) && (paramInt2 == 1)) {
      this.jdField_a_of_type_Advr.notifyDataSetChanged();
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131562841);
    this.jdField_a_of_type_JavaLangString = getIntent().getStringExtra("uin");
    a();
    b();
    ((afgr)this.e.getTag()).b.setText(this.jdField_b_of_type_JavaLangString);
    this.jdField_a_of_type_Advr = new advr(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setAdapter(this.jdField_a_of_type_Advr);
    return true;
  }
  
  public void doOnDestroy()
  {
    this.jdField_a_of_type_Advr.c();
    super.doOnDestroy();
  }
  
  public void doOnStart()
  {
    super.doOnStart();
    getWindow().setSoftInputMode(48);
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.e) {
      a(paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    a(paramView);
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 1) {
      c();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.DiscussionMemberActivity
 * JD-Core Version:    0.7.0.1
 */