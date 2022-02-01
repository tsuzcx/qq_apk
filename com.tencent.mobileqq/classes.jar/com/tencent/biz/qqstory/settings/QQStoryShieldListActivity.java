package com.tencent.biz.qqstory.settings;

import Override;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import anzj;
import aoof;
import aoog;
import bhmg;
import bhnv;
import bjbv;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import win;
import wja;
import wjb;
import wjd;
import yai;
import yaj;
import yor;
import yup;

public class QQStoryShieldListActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, aoog
{
  public int a;
  public DisplayMetrics a;
  View jdField_a_of_type_AndroidViewView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  aoof jdField_a_of_type_Aoof;
  public bjbv a;
  XListView jdField_a_of_type_ComTencentWidgetXListView;
  private String jdField_a_of_type_JavaLangString;
  public wja a;
  public wjb a;
  wjd jdField_a_of_type_Wjd = new yai(this);
  yaj jdField_a_of_type_Yaj;
  int jdField_b_of_type_Int;
  View jdField_b_of_type_AndroidViewView;
  
  public static void a(Activity paramActivity, ArrayList<String> paramArrayList, boolean paramBoolean)
  {
    Intent localIntent = new Intent(paramActivity, SelectMemberActivity.class);
    localIntent.putExtra("param_entrance", 24);
    localIntent.putExtra("param_only_friends", true);
    localIntent.putExtra("param_done_button_wording", paramActivity.getString(2131692262));
    localIntent.putExtra("param_uins_selected_default", paramArrayList);
    localIntent.putExtra("param_donot_need_contacts", true);
    localIntent.putExtra("param_donot_need_discussion", true);
    localIntent.putExtra("param_donot_need_troop", true);
    localIntent.putExtra("param_title", anzj.a(2131709904));
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
    this.jdField_a_of_type_Yaj.a(paramList);
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool);
    return bool;
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
    localObject = this.jdField_a_of_type_Wja;
    if (this.jdField_a_of_type_Int == 2) {}
    for (boolean bool = true;; bool = false)
    {
      ((wja)localObject).a(paramIntent, bool, true);
      this.jdField_a_of_type_Bjbv.b(0, 2131717414, 0);
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
      paramBundle = anzj.a(2131709884) + win.b;
      super.setContentView(2131561846);
      super.setTitle(paramBundle);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131378898));
      if (this.jdField_a_of_type_Int != 2) {
        break label481;
      }
      paramBundle = anzj.a(2131709888) + win.b;
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramBundle);
      this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)super.findViewById(2131377565));
      this.jdField_a_of_type_Bjbv = new bjbv(this, 2131561501);
      this.jdField_a_of_type_Wjb = ((wjb)this.app.getManager(181));
      this.jdField_a_of_type_Wja = ((wja)this.app.a(98));
      this.jdField_a_of_type_JavaLangString = String.valueOf(hashCode());
      paramBundle = this.jdField_a_of_type_Wjb;
      if (this.jdField_a_of_type_Int != 2) {
        break label534;
      }
      bool = true;
      label204:
      paramBundle = new ArrayList(paramBundle.a(bool));
      if (bhnv.g(this)) {
        break label539;
      }
      QQToast.a(this, 1, anzj.a(2131709908), 0).b(getTitleBarHeight());
      this.jdField_a_of_type_Yaj = new yaj(this, paramBundle);
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Yaj);
      this.jdField_a_of_type_AndroidViewView = super.findViewById(2131370023);
      this.jdField_b_of_type_AndroidViewView = super.findViewById(2131371865);
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
    for (paramBundle = "把好友添加到这里后\r\n该好友将不会看到我的" + win.b;; paramBundle = "把好友添加到这里后\r\n将不会看到该好友的" + win.b)
    {
      ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131371854)).setText(paramBundle);
      this.jdField_b_of_type_Int = ((int)bhmg.a(this, 20.0F));
      setLeftViewName(2131690384);
      this.rightViewText.setOnClickListener(this);
      this.rightViewText.setText(anzj.a(2131689551));
      this.rightViewText.setVisibility(0);
      this.jdField_a_of_type_Aoof = new aoof(this.app);
      this.jdField_a_of_type_Aoof.a(this);
      this.jdField_a_of_type_AndroidUtilDisplayMetrics = getResources().getDisplayMetrics();
      return true;
      paramBundle = anzj.a(2131709913) + win.b;
      break;
      paramBundle = anzj.a(2131709905) + win.b + anzj.a(2131709917) + win.jdField_a_of_type_JavaLangString + anzj.a(2131709915);
      break label110;
      bool = false;
      break label204;
      this.app.addObserver(this.jdField_a_of_type_Wjd);
      wja localwja = this.jdField_a_of_type_Wja;
      if (this.jdField_a_of_type_Int == 2) {}
      for (bool = true;; bool = false)
      {
        localwja.a(null, 10, bool, this.jdField_a_of_type_JavaLangString);
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
    if (this.jdField_a_of_type_Aoof != null) {
      this.jdField_a_of_type_Aoof.d();
    }
    this.jdField_a_of_type_Bjbv.b();
    this.app.removeObserver(this.jdField_a_of_type_Wjd);
    super.doOnDestroy();
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    yup.a(14, this.currentActivityStayTime);
  }
  
  public void finish()
  {
    yor.a(this.app);
    super.finish();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      if (paramView == this.rightViewText)
      {
        if (bhnv.g(this)) {
          break label256;
        }
        QQToast.a(this, 1, anzj.a(2131709909), 0).b(getTitleBarHeight());
      }
      break;
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (!bhnv.g(this))
      {
        QQToast.a(this, 1, anzj.a(2131709922), 0).b(getTitleBarHeight());
      }
      else
      {
        Object localObject = (QQStoryUserInfo)paramView.getTag();
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(((QQStoryUserInfo)localObject).uin);
        localObject = this.jdField_a_of_type_Wja;
        if (this.jdField_a_of_type_Int == 2) {}
        for (boolean bool = true;; bool = false)
        {
          ((wja)localObject).a(localArrayList, bool, false);
          this.jdField_a_of_type_Bjbv.b(0, 2131717414, 0);
          if (this.jdField_a_of_type_Int != 2) {
            break label214;
          }
          yup.a("friend_story_settings", "move_notletsee", 0, 0, new String[] { "", "", "", "" });
          break;
        }
        label214:
        yup.a("friend_story_settings", "move_notsee", 0, 0, new String[] { "", "", "", "" });
        break;
        label256:
        localArrayList = new ArrayList();
        localArrayList.add(this.app.getCurrentAccountUin());
        localObject = this.jdField_a_of_type_Wjb;
        if (this.jdField_a_of_type_Int == 2) {}
        for (bool = true;; bool = false)
        {
          localObject = ((wjb)localObject).a(bool);
          if (localObject == null) {
            break;
          }
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext()) {
            localArrayList.add(((QQStoryUserInfo)((Iterator)localObject).next()).uin);
          }
        }
        if (this.jdField_a_of_type_Int == 1) {}
        for (bool = true;; bool = false)
        {
          a(this, localArrayList, bool);
          if (this.jdField_a_of_type_Int != 2) {
            break label421;
          }
          yup.a("friend_story_settings", "add_notletsee", 0, 0, new String[] { "", "", "", "" });
          break;
        }
        label421:
        yup.a("friend_story_settings", "add_notsee", 0, 0, new String[] { "", "", "", "" });
      }
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    this.jdField_a_of_type_Yaj.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.settings.QQStoryShieldListActivity
 * JD-Core Version:    0.7.0.1
 */