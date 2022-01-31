package com.tencent.mobileqq.activity;

import aazc;
import aazd;
import aaze;
import aazf;
import aazg;
import aazh;
import aazi;
import aazj;
import aazk;
import aazl;
import aazm;
import aazn;
import aazo;
import acld;
import aimt;
import ajte;
import ajvi;
import ajxj;
import ajxl;
import ajya;
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
import bayh;
import bbcz;
import bcnf;
import bcot;
import bfpt;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.widget.IndexView;
import com.tencent.mobileqq.widget.PinnedDividerListView;
import com.tencent.widget.AdapterView;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class DiscussionMemberActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, View.OnTouchListener, bcnf, bcot, bfpt
{
  private final int jdField_a_of_type_Int = 1;
  private aazl jdField_a_of_type_Aazl;
  public aazn a;
  public View a;
  public EditText a;
  private ImageButton jdField_a_of_type_AndroidWidgetImageButton;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private IndexView jdField_a_of_type_ComTencentMobileqqWidgetIndexView;
  public PinnedDividerListView a;
  public XListView a;
  private String jdField_a_of_type_JavaLangString;
  public List<aazk> a;
  View jdField_b_of_type_AndroidViewView;
  private EditText jdField_b_of_type_AndroidWidgetEditText;
  private String jdField_b_of_type_JavaLangString;
  private List<aazk> jdField_b_of_type_JavaUtilList = new ArrayList();
  private View c;
  private View d;
  private View e;
  
  public DiscussionMemberActivity()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  private void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView = ((PinnedDividerListView)findViewById(2131364058));
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView = ((IndexView)findViewById(2131368074));
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setSelector(2131167087);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setOnItemClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setOnLayoutListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setIndex(new String[] { "$", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "#" });
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setOnIndexChangedListener(this);
    this.c = findViewById(2131375329);
    this.jdField_a_of_type_AndroidViewView = ((View)this.c.getParent());
    this.jdField_b_of_type_AndroidViewView = findViewById(2131375805);
    this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130838514);
    setTitle(ajya.a(2131703360));
    Object localObject = (RelativeLayout)getLayoutInflater().inflate(2131562360, this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView, false);
    ((RelativeLayout)localObject).setPadding(0, 0, 40, 0);
    this.jdField_b_of_type_AndroidWidgetEditText = ((EditText)((RelativeLayout)localObject).findViewById(2131365763));
    this.jdField_b_of_type_AndroidWidgetEditText.setFocusable(false);
    this.jdField_b_of_type_AndroidWidgetEditText.setOnTouchListener(this);
    ((Button)((RelativeLayout)localObject).findViewById(2131363479)).setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.addHeaderView((View)localObject);
    this.e = getLayoutInflater().inflate(2131558991, this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView, false);
    acld localacld = new acld();
    localacld.jdField_a_of_type_JavaLangString = this.app.getCurrentAccountUin();
    localacld.c = ((ImageView)this.e.findViewById(2131368583));
    localacld.c.setBackgroundDrawable(bayh.a(this.app, this.app.getCurrentAccountUin(), (byte)3));
    localacld.b = ((TextView)this.e.findViewById(2131378265));
    localObject = this.app.getCurrentNickname();
    TextView localTextView = localacld.b;
    if ((localObject != null) && (((String)localObject).trim().length() > 0)) {}
    for (;;)
    {
      localTextView.setText((CharSequence)localObject);
      this.e.setTag(localacld);
      this.e.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.addHeaderView(this.e);
      return;
      localObject = this.app.getCurrentAccountUin();
    }
  }
  
  private void b()
  {
    ajxl localajxl = (ajxl)this.app.getManager(51);
    Object localObject = (ajvi)this.app.getManager(53);
    if (localajxl != null)
    {
      localObject = ((ajvi)localObject).a(this.jdField_a_of_type_JavaLangString);
      if (localObject != null)
      {
        this.jdField_a_of_type_JavaUtilList.clear();
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          DiscussionMemberInfo localDiscussionMemberInfo = (DiscussionMemberInfo)((Iterator)localObject).next();
          if (localDiscussionMemberInfo.memberUin.equals(this.app.getCurrentAccountUin()))
          {
            this.jdField_b_of_type_JavaLangString = bbcz.a(this.app, localDiscussionMemberInfo);
          }
          else
          {
            aazk localaazk = new aazk(this, null);
            localaazk.jdField_a_of_type_JavaLangString = localDiscussionMemberInfo.memberUin;
            localaazk.jdField_b_of_type_JavaLangString = bbcz.a(localDiscussionMemberInfo, this.app);
            localajxl.e(localaazk.jdField_a_of_type_JavaLangString);
            localaazk.d = ChnToSpell.a(localaazk.jdField_b_of_type_JavaLangString, 1);
            localaazk.c = ChnToSpell.a(localaazk.jdField_b_of_type_JavaLangString, 2);
            this.jdField_a_of_type_JavaUtilList.add(localaazk);
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
    localDialog.setContentView(2131562369);
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
    aazc localaazc = new aazc(this, (TranslateAnimation)localObject3, localDialog, (TranslateAnimation)localObject2, i);
    ((TranslateAnimation)localObject3).setAnimationListener(localaazc);
    ((TranslateAnimation)localObject2).setAnimationListener(localaazc);
    this.jdField_a_of_type_AndroidViewView.startAnimation((Animation)localObject3);
    localObject3 = new aazd(this);
    addObserver((ajte)localObject3);
    localDialog.setOnDismissListener(new aaze(this, i, (TranslateAnimation)localObject2, (InputMethodManager)localObject1, (ajxj)localObject3));
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)localDialog.findViewById(2131365763));
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new aazo(this, null));
    this.jdField_a_of_type_AndroidWidgetEditText.setSelection(0);
    this.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)localDialog.findViewById(2131367678));
    this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(new aazf(this));
    localObject2 = (Button)localDialog.findViewById(2131363479);
    ((Button)localObject2).setVisibility(0);
    ((Button)localObject2).setOnClickListener(new aazg(this, localDialog));
    this.d = localDialog.findViewById(2131370876);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localDialog.findViewById(2131375189));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new aazh(this, localDialog));
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)localDialog.findViewById(2131375673));
    this.jdField_a_of_type_ComTencentWidgetXListView.setBackgroundDrawable(getResources().getDrawable(2130838514));
    this.jdField_a_of_type_ComTencentWidgetXListView.setDividerHeight(0);
    this.jdField_b_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_Aazn = new aazn(this, this.jdField_b_of_type_JavaUtilList);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Aazn);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnTouchListener(new aazi(this, (InputMethodManager)localObject1));
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnItemClickListener(new aazj(this, localDialog));
  }
  
  public void a(View paramView)
  {
    paramView = (aimt)paramView.getTag();
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
    if (((ajxl)this.app.getManager(51)).b(paramView))
    {
      localAllInOne = new ProfileActivity.AllInOne(paramView, 1);
      localAllInOne.h = bbcz.a(this.app, paramView, 0);
      localAllInOne.g = 5;
      ProfileActivity.a(this, localAllInOne, 1);
      return;
    }
    ProfileActivity.AllInOne localAllInOne = new ProfileActivity.AllInOne(paramView, 46);
    localAllInOne.h = bbcz.a(this.app, paramView, 0);
    localAllInOne.f = paramView;
    localAllInOne.jdField_e_of_type_Int = 3000;
    localAllInOne.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    localAllInOne.g = 5;
    ProfileActivity.a(this, localAllInOne, 1);
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getFirstVisiblePosition() > 0) || ((this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getFirstVisiblePosition() == 0) && (this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getChildCount() < this.jdField_a_of_type_Aazl.getCount() + this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getHeaderViewsCount()))) {
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
      i = this.jdField_a_of_type_Aazl.a(paramString);
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
      this.jdField_a_of_type_Aazn.notifyDataSetChanged();
      return;
      this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
      this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(0);
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      ArrayList localArrayList3 = new ArrayList();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        aazk localaazk = (aazk)localIterator.next();
        if (localaazk != null) {
          if ((localaazk.jdField_b_of_type_JavaLangString.equals(paramString)) || (localaazk.jdField_a_of_type_JavaLangString.equals(paramString)) || (localaazk.d.equals(paramString.toLowerCase())) || (localaazk.c.equals(paramString.toLowerCase()))) {
            localArrayList1.add(localaazk);
          } else if ((localaazk.jdField_b_of_type_JavaLangString.indexOf(paramString) == 0) || (localaazk.jdField_a_of_type_JavaLangString.indexOf(paramString) == 0) || (localaazk.c.indexOf(paramString.toLowerCase()) == 0) || (localaazk.d.indexOf(paramString.toLowerCase()) == 0)) {
            localArrayList2.add(localaazk);
          } else if ((localaazk.jdField_b_of_type_JavaLangString.indexOf(paramString) > 0) || (localaazk.jdField_a_of_type_JavaLangString.indexOf(paramString) > 0) || (localaazk.c.indexOf(paramString.toLowerCase()) > 0) || (localaazk.d.indexOf(paramString.toLowerCase()) > 0)) {
            localArrayList3.add(localaazk);
          }
        }
      }
      Collections.sort(localArrayList2, new aazm(this, null));
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
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((-1 == paramInt2) && (paramInt2 == 1)) {
      this.jdField_a_of_type_Aazl.notifyDataSetChanged();
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131562397);
    this.jdField_a_of_type_JavaLangString = getIntent().getStringExtra("uin");
    a();
    b();
    ((acld)this.e.getTag()).b.setText(this.jdField_b_of_type_JavaLangString);
    this.jdField_a_of_type_Aazl = new aazl(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setAdapter(this.jdField_a_of_type_Aazl);
    return true;
  }
  
  public void doOnDestroy()
  {
    this.jdField_a_of_type_Aazl.c();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.DiscussionMemberActivity
 * JD-Core Version:    0.7.0.1
 */