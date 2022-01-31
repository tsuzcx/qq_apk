package com.tencent.mobileqq.activity;

import android.app.Dialog;
import android.content.Intent;
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
import com.tencent.mobileqq.adapter.FacePreloadBaseAdapter.ViewHolder;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.util.FaceDrawable;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.widget.IndexView;
import com.tencent.mobileqq.widget.IndexView.OnIndexChangedListener;
import com.tencent.mobileqq.widget.PinnedDividerListView;
import com.tencent.mobileqq.widget.PinnedDividerListView.OnLayoutListener;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import skt;
import sku;
import skv;
import skx;
import sky;
import skz;
import sla;
import slb;
import slc;
import sld;
import sle;
import slf;
import slg;

public class DiscussionMemberActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, View.OnTouchListener, IndexView.OnIndexChangedListener, PinnedDividerListView.OnLayoutListener, AdapterView.OnItemClickListener
{
  private final int jdField_a_of_type_Int = 1;
  public View a;
  public EditText a;
  private ImageButton jdField_a_of_type_AndroidWidgetImageButton;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private IndexView jdField_a_of_type_ComTencentMobileqqWidgetIndexView;
  public PinnedDividerListView a;
  public XListView a;
  private String jdField_a_of_type_JavaLangString;
  public List a;
  private sld jdField_a_of_type_Sld;
  public slf a;
  View jdField_b_of_type_AndroidViewView;
  private EditText jdField_b_of_type_AndroidWidgetEditText;
  private String jdField_b_of_type_JavaLangString;
  private List jdField_b_of_type_JavaUtilList = new ArrayList();
  private View c;
  private View d;
  private View e;
  
  public DiscussionMemberActivity()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  private void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView = ((PinnedDividerListView)findViewById(2131375040));
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView = ((IndexView)findViewById(2131363830));
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setSelector(2131492924);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setOnItemClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setOnLayoutListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setIndex(new String[] { "$", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "#" });
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setOnIndexChangedListener(this);
    this.c = findViewById(2131363244);
    this.jdField_a_of_type_AndroidViewView = ((View)this.c.getParent());
    this.jdField_b_of_type_AndroidViewView = findViewById(2131375035);
    this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130838214);
    setTitle("群聊成员");
    Object localObject = (RelativeLayout)getLayoutInflater().inflate(2130971517, this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView, false);
    ((RelativeLayout)localObject).setPadding(0, 0, 40, 0);
    this.jdField_b_of_type_AndroidWidgetEditText = ((EditText)((RelativeLayout)localObject).findViewById(2131368322));
    this.jdField_b_of_type_AndroidWidgetEditText.setFocusable(false);
    this.jdField_b_of_type_AndroidWidgetEditText.setOnTouchListener(this);
    ((Button)((RelativeLayout)localObject).findViewById(2131368321)).setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.addHeaderView((View)localObject);
    this.e = getLayoutInflater().inflate(2130968944, this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView, false);
    TroopMemberListActivity.ViewHolder localViewHolder = new TroopMemberListActivity.ViewHolder();
    localViewHolder.jdField_a_of_type_JavaLangString = this.app.getCurrentAccountUin();
    localViewHolder.c = ((ImageView)this.e.findViewById(2131364340));
    localViewHolder.c.setBackgroundDrawable(FaceDrawable.a(this.app, this.app.getCurrentAccountUin(), (byte)3));
    localViewHolder.b = ((TextView)this.e.findViewById(2131363549));
    localObject = this.app.getCurrentNickname();
    TextView localTextView = localViewHolder.b;
    if ((localObject != null) && (((String)localObject).trim().length() > 0)) {}
    for (;;)
    {
      localTextView.setText((CharSequence)localObject);
      this.e.setTag(localViewHolder);
      this.e.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.addHeaderView(this.e);
      return;
      localObject = this.app.getCurrentAccountUin();
    }
  }
  
  private void b()
  {
    FriendsManager localFriendsManager = (FriendsManager)this.app.getManager(50);
    Object localObject = (DiscussionManager)this.app.getManager(52);
    if (localFriendsManager != null)
    {
      localObject = ((DiscussionManager)localObject).a(this.jdField_a_of_type_JavaLangString);
      if (localObject != null)
      {
        this.jdField_a_of_type_JavaUtilList.clear();
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          DiscussionMemberInfo localDiscussionMemberInfo = (DiscussionMemberInfo)((Iterator)localObject).next();
          if (localDiscussionMemberInfo.memberUin.equals(this.app.getCurrentAccountUin()))
          {
            this.jdField_b_of_type_JavaLangString = ContactUtils.a(this.app, localDiscussionMemberInfo);
          }
          else
          {
            slc localslc = new slc(this, null);
            localslc.jdField_a_of_type_JavaLangString = localDiscussionMemberInfo.memberUin;
            localslc.jdField_b_of_type_JavaLangString = ContactUtils.a(localDiscussionMemberInfo, this.app);
            localFriendsManager.c(localslc.jdField_a_of_type_JavaLangString);
            localslc.d = ChnToSpell.a(localslc.jdField_b_of_type_JavaLangString, 1);
            localslc.c = ChnToSpell.a(localslc.jdField_b_of_type_JavaLangString, 2);
            this.jdField_a_of_type_JavaUtilList.add(localslc);
          }
        }
      }
    }
  }
  
  private void c()
  {
    Dialog localDialog = new Dialog(this);
    localDialog.setCanceledOnTouchOutside(true);
    localDialog.requestWindowFeature(1);
    localDialog.getWindow().setSoftInputMode(36);
    localDialog.setContentView(2130971524);
    Object localObject1 = localDialog.getWindow().getAttributes();
    ((WindowManager.LayoutParams)localObject1).x = 0;
    ((WindowManager.LayoutParams)localObject1).y = 0;
    ((WindowManager.LayoutParams)localObject1).width = -1;
    ((WindowManager.LayoutParams)localObject1).windowAnimations = 16973824;
    ((WindowManager.LayoutParams)localObject1).gravity = 51;
    localDialog.getWindow().setBackgroundDrawable(new ColorDrawable());
    int i = this.c.getHeight();
    Object localObject3 = new TranslateAnimation(0.0F, 0.0F, 0.0F, -i);
    ((TranslateAnimation)localObject3).setDuration(300L);
    ((TranslateAnimation)localObject3).setFillAfter(true);
    Object localObject2 = new TranslateAnimation(0.0F, 0.0F, -i, 0.0F);
    ((TranslateAnimation)localObject2).setDuration(300L);
    localObject1 = (InputMethodManager)getSystemService("input_method");
    skt localskt = new skt(this, (TranslateAnimation)localObject3, localDialog, (TranslateAnimation)localObject2, i);
    ((TranslateAnimation)localObject3).setAnimationListener(localskt);
    ((TranslateAnimation)localObject2).setAnimationListener(localskt);
    this.jdField_a_of_type_AndroidViewView.startAnimation((Animation)localObject3);
    localObject3 = new sku(this);
    addObserver((BusinessObserver)localObject3);
    localDialog.setOnDismissListener(new skv(this, i, (TranslateAnimation)localObject2, (InputMethodManager)localObject1, (FriendListObserver)localObject3));
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)localDialog.findViewById(2131368322));
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new slg(this, null));
    this.jdField_a_of_type_AndroidWidgetEditText.setSelection(0);
    this.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)localDialog.findViewById(2131368323));
    this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(new skx(this));
    localObject2 = (Button)localDialog.findViewById(2131368321);
    ((Button)localObject2).setVisibility(0);
    ((Button)localObject2).setOnClickListener(new sky(this, localDialog));
    this.d = localDialog.findViewById(2131363925);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localDialog.findViewById(2131363923));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new skz(this, localDialog));
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)localDialog.findViewById(2131365669));
    this.jdField_a_of_type_ComTencentWidgetXListView.setBackgroundDrawable(getResources().getDrawable(2130838214));
    this.jdField_a_of_type_ComTencentWidgetXListView.setDividerHeight(0);
    this.jdField_b_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_Slf = new slf(this, this.jdField_b_of_type_JavaUtilList);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Slf);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnTouchListener(new sla(this, (InputMethodManager)localObject1));
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnItemClickListener(new slb(this, localDialog));
  }
  
  public void a(View paramView)
  {
    paramView = (FacePreloadBaseAdapter.ViewHolder)paramView.getTag();
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
    if (((FriendsManager)this.app.getManager(50)).b(paramView))
    {
      localAllInOne = new ProfileActivity.AllInOne(paramView, 1);
      localAllInOne.h = ContactUtils.a(this.app, paramView, 0);
      localAllInOne.g = 5;
      ProfileActivity.a(this, localAllInOne, 1);
      return;
    }
    ProfileActivity.AllInOne localAllInOne = new ProfileActivity.AllInOne(paramView, 46);
    localAllInOne.h = ContactUtils.a(this.app, paramView, 0);
    localAllInOne.f = paramView;
    localAllInOne.jdField_e_of_type_Int = 3000;
    localAllInOne.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    localAllInOne.g = 5;
    ProfileActivity.a(this, localAllInOne, 1);
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getFirstVisiblePosition() > 0) || ((this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getFirstVisiblePosition() == 0) && (this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getChildCount() < this.jdField_a_of_type_Sld.getCount() + this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getHeaderViewsCount()))) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setVisibility(0);
    }
  }
  
  public void a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    a(paramView);
  }
  
  public void a(String paramString)
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
      this.jdField_a_of_type_Slf.notifyDataSetChanged();
      return;
      this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
      this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(0);
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      ArrayList localArrayList3 = new ArrayList();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        slc localslc = (slc)localIterator.next();
        if (localslc != null) {
          if ((localslc.jdField_b_of_type_JavaLangString.equals(paramString)) || (localslc.jdField_a_of_type_JavaLangString.equals(paramString)) || (localslc.d.equals(paramString.toLowerCase())) || (localslc.c.equals(paramString.toLowerCase()))) {
            localArrayList1.add(localslc);
          } else if ((localslc.jdField_b_of_type_JavaLangString.indexOf(paramString) == 0) || (localslc.jdField_a_of_type_JavaLangString.indexOf(paramString) == 0) || (localslc.c.indexOf(paramString.toLowerCase()) == 0) || (localslc.d.indexOf(paramString.toLowerCase()) == 0)) {
            localArrayList2.add(localslc);
          } else if ((localslc.jdField_b_of_type_JavaLangString.indexOf(paramString) > 0) || (localslc.jdField_a_of_type_JavaLangString.indexOf(paramString) > 0) || (localslc.c.indexOf(paramString.toLowerCase()) > 0) || (localslc.d.indexOf(paramString.toLowerCase()) > 0)) {
            localArrayList3.add(localslc);
          }
        }
      }
      Collections.sort(localArrayList2, new sle(this, null));
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
  
  public void b(String paramString)
  {
    if ("$".equals(paramString)) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setSelection(0);
    }
    int i;
    do
    {
      return;
      i = this.jdField_a_of_type_Sld.a(paramString);
    } while (i == -1);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setSelection(i + this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getHeaderViewsCount());
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((-1 == paramInt2) && (paramInt2 == 1)) {
      this.jdField_a_of_type_Sld.notifyDataSetChanged();
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2130971550);
    this.jdField_a_of_type_JavaLangString = getIntent().getStringExtra("uin");
    a();
    b();
    ((TroopMemberListActivity.ViewHolder)this.e.getTag()).b.setText(this.jdField_b_of_type_JavaLangString);
    this.jdField_a_of_type_Sld = new sld(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setAdapter(this.jdField_a_of_type_Sld);
    return true;
  }
  
  protected void doOnDestroy()
  {
    this.jdField_a_of_type_Sld.c();
    super.doOnDestroy();
  }
  
  protected void doOnStart()
  {
    super.doOnStart();
    getWindow().setSoftInputMode(48);
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.e) {
      a(paramView);
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 1) {
      c();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.DiscussionMemberActivity
 * JD-Core Version:    0.7.0.1
 */