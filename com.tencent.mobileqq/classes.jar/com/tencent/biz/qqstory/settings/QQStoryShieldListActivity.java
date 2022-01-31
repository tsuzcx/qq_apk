package com.tencent.biz.qqstory.settings;

import ajya;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import baxy;
import baxz;
import bbdv;
import bbfj;
import bcqi;
import bcql;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import ssf;
import sss;
import sst;
import ssv;
import ukb;
import ukc;
import uyk;
import vei;

public class QQStoryShieldListActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, baxz
{
  public int a;
  public DisplayMetrics a;
  View jdField_a_of_type_AndroidViewView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  baxy jdField_a_of_type_Baxy;
  public bcqi a;
  XListView jdField_a_of_type_ComTencentWidgetXListView;
  private String jdField_a_of_type_JavaLangString;
  public sss a;
  public sst a;
  ssv jdField_a_of_type_Ssv = new ukb(this);
  ukc jdField_a_of_type_Ukc;
  int jdField_b_of_type_Int;
  View jdField_b_of_type_AndroidViewView;
  
  public static void a(Activity paramActivity, ArrayList<String> paramArrayList, boolean paramBoolean)
  {
    Intent localIntent = new Intent(paramActivity, SelectMemberActivity.class);
    localIntent.putExtra("param_entrance", 24);
    localIntent.putExtra("param_only_friends", true);
    localIntent.putExtra("param_done_button_wording", paramActivity.getString(2131692601));
    localIntent.putExtra("param_uins_selected_default", paramArrayList);
    localIntent.putExtra("param_donot_need_contacts", true);
    localIntent.putExtra("param_donot_need_discussion", true);
    localIntent.putExtra("param_donot_need_troop", true);
    localIntent.putExtra("param_title", ajya.a(2131711035));
    localIntent.putExtra("is_support_select_from_friend_groups", true);
    localIntent.putExtra("isExpandFirst", false);
    localIntent.putExtra("is_story_not_see", paramBoolean);
    paramActivity.startActivityForResult(localIntent, 1001);
  }
  
  public void a(List<QQStoryUserInfo> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0))
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_Ukc.a(paramList);
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt2 == -1) && (paramInt1 == 1001))
    {
      localObject = paramIntent.getParcelableArrayListExtra("friendsSelected");
      if ((localObject != null) && (((ArrayList)localObject).size() != 0)) {}
    }
    else
    {
      return;
    }
    paramIntent = new ArrayList();
    Object localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramIntent.add(((ResultRecord)((Iterator)localObject).next()).jdField_a_of_type_JavaLangString);
    }
    localObject = this.jdField_a_of_type_Sss;
    if (this.jdField_a_of_type_Int == 2) {}
    for (boolean bool = true;; bool = false)
    {
      ((sss)localObject).a(paramIntent, bool, true);
      this.jdField_a_of_type_Bcqi.b(0, 2131718679, 0);
      return;
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_Int = getIntent().getIntExtra("sheild_type", 1);
    label110:
    boolean bool;
    if (this.jdField_a_of_type_Int == 2)
    {
      paramBundle = ajya.a(2131711015) + ssf.b;
      super.setContentView(2131561362);
      super.setTitle(paramBundle);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131377315));
      if (this.jdField_a_of_type_Int != 2) {
        break label481;
      }
      paramBundle = ajya.a(2131711019) + ssf.b;
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramBundle);
      this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)super.findViewById(2131376068));
      this.jdField_a_of_type_Bcqi = new bcqi(this, 2131561032);
      this.jdField_a_of_type_Sst = ((sst)this.app.getManager(181));
      this.jdField_a_of_type_Sss = ((sss)this.app.a(98));
      this.jdField_a_of_type_JavaLangString = String.valueOf(hashCode());
      paramBundle = this.jdField_a_of_type_Sst;
      if (this.jdField_a_of_type_Int != 2) {
        break label534;
      }
      bool = true;
      label204:
      paramBundle = new ArrayList(paramBundle.a(bool));
      if (bbfj.g(this)) {
        break label539;
      }
      bcql.a(this, 1, ajya.a(2131711039), 0).b(getTitleBarHeight());
      this.jdField_a_of_type_Ukc = new ukc(this, paramBundle);
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Ukc);
      this.jdField_a_of_type_AndroidViewView = super.findViewById(2131369277);
      this.jdField_b_of_type_AndroidViewView = super.findViewById(2131370869);
      if ((paramBundle != null) && (paramBundle.size() != 0)) {
        break label590;
      }
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      label320:
      if (this.jdField_a_of_type_Int != 2) {
        break label610;
      }
    }
    label481:
    label610:
    for (paramBundle = "把好友添加到这里后\r\n该好友将不会看到我的" + ssf.b;; paramBundle = "把好友添加到这里后\r\n将不会看到该好友的" + ssf.b)
    {
      ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131370858)).setText(paramBundle);
      this.jdField_b_of_type_Int = ((int)bbdv.a(this, 20.0F));
      setLeftViewName(2131690331);
      this.rightViewText.setOnClickListener(this);
      this.rightViewText.setText(ajya.a(2131689628));
      this.rightViewText.setVisibility(0);
      this.jdField_a_of_type_Baxy = new baxy(this.app);
      this.jdField_a_of_type_Baxy.a(this);
      this.jdField_a_of_type_AndroidUtilDisplayMetrics = getResources().getDisplayMetrics();
      return true;
      paramBundle = ajya.a(2131711044) + ssf.b;
      break;
      paramBundle = ajya.a(2131711036) + ssf.b + ajya.a(2131711048) + ssf.jdField_a_of_type_JavaLangString + ajya.a(2131711046);
      break label110;
      bool = false;
      break label204;
      this.app.addObserver(this.jdField_a_of_type_Ssv);
      sss localsss = this.jdField_a_of_type_Sss;
      if (this.jdField_a_of_type_Int == 2) {}
      for (bool = true;; bool = false)
      {
        localsss.a(null, 10, bool, this.jdField_a_of_type_JavaLangString);
        super.startTitleProgress();
        break;
      }
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      break label320;
    }
  }
  
  public void doOnDestroy()
  {
    if (this.jdField_a_of_type_Baxy != null) {
      this.jdField_a_of_type_Baxy.d();
    }
    this.jdField_a_of_type_Bcqi.b();
    this.app.removeObserver(this.jdField_a_of_type_Ssv);
    super.doOnDestroy();
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    vei.a(14, this.currentActivityStayTime);
  }
  
  public void finish()
  {
    uyk.a(this.app);
    super.finish();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      if (paramView == this.rightViewText)
      {
        if (bbfj.g(this)) {
          break;
        }
        bcql.a(this, 1, ajya.a(2131711040), 0).b(getTitleBarHeight());
      }
      return;
      if (!bbfj.g(this))
      {
        bcql.a(this, 1, ajya.a(2131711053), 0).b(getTitleBarHeight());
        return;
      }
      Object localObject2 = (QQStoryUserInfo)paramView.getTag();
      localObject1 = new ArrayList();
      ((ArrayList)localObject1).add(((QQStoryUserInfo)localObject2).uin);
      localObject2 = this.jdField_a_of_type_Sss;
      if (this.jdField_a_of_type_Int == 2) {}
      for (bool = true;; bool = false)
      {
        ((sss)localObject2).a((ArrayList)localObject1, bool, false);
        this.jdField_a_of_type_Bcqi.b(0, 2131718679, 0);
        if (this.jdField_a_of_type_Int != 2) {
          break label205;
        }
        vei.a("friend_story_settings", "move_notletsee", 0, 0, new String[] { "", "", "", "" });
        break;
      }
      label205:
      vei.a("friend_story_settings", "move_notsee", 0, 0, new String[] { "", "", "", "" });
    }
    paramView = new ArrayList();
    paramView.add(this.app.getCurrentAccountUin());
    Object localObject1 = this.jdField_a_of_type_Sst;
    if (this.jdField_a_of_type_Int == 2) {}
    for (boolean bool = true;; bool = false)
    {
      localObject1 = ((sst)localObject1).a(bool);
      if (localObject1 == null) {
        break;
      }
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext()) {
        paramView.add(((QQStoryUserInfo)((Iterator)localObject1).next()).uin);
      }
    }
    if (this.jdField_a_of_type_Int == 1) {}
    for (bool = true;; bool = false)
    {
      a(this, paramView, bool);
      if (this.jdField_a_of_type_Int != 2) {
        break;
      }
      vei.a("friend_story_settings", "add_notletsee", 0, 0, new String[] { "", "", "", "" });
      return;
    }
    vei.a("friend_story_settings", "add_notsee", 0, 0, new String[] { "", "", "", "" });
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    this.jdField_a_of_type_Ukc.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.settings.QQStoryShieldListActivity
 * JD-Core Version:    0.7.0.1
 */