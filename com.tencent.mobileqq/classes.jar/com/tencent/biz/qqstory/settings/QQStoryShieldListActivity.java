package com.tencent.biz.qqstory.settings;

import alud;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import bdbb;
import bdbc;
import bdgz;
import bdin;
import beub;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import ulg;
import ult;
import ulu;
import ulw;
import wdc;
import wdd;
import wrl;
import wxj;

public class QQStoryShieldListActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, bdbc
{
  public int a;
  public DisplayMetrics a;
  View jdField_a_of_type_AndroidViewView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  bdbb jdField_a_of_type_Bdbb;
  public beub a;
  XListView jdField_a_of_type_ComTencentWidgetXListView;
  private String jdField_a_of_type_JavaLangString;
  public ult a;
  public ulu a;
  ulw jdField_a_of_type_Ulw = new wdc(this);
  wdd jdField_a_of_type_Wdd;
  int jdField_b_of_type_Int;
  View jdField_b_of_type_AndroidViewView;
  
  public static void a(Activity paramActivity, ArrayList<String> paramArrayList, boolean paramBoolean)
  {
    Intent localIntent = new Intent(paramActivity, SelectMemberActivity.class);
    localIntent.putExtra("param_entrance", 24);
    localIntent.putExtra("param_only_friends", true);
    localIntent.putExtra("param_done_button_wording", paramActivity.getString(2131692682));
    localIntent.putExtra("param_uins_selected_default", paramArrayList);
    localIntent.putExtra("param_donot_need_contacts", true);
    localIntent.putExtra("param_donot_need_discussion", true);
    localIntent.putExtra("param_donot_need_troop", true);
    localIntent.putExtra("param_title", alud.a(2131711419));
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
    this.jdField_a_of_type_Wdd.a(paramList);
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
    localObject = this.jdField_a_of_type_Ult;
    if (this.jdField_a_of_type_Int == 2) {}
    for (boolean bool = true;; bool = false)
    {
      ((ult)localObject).a(paramIntent, bool, true);
      this.jdField_a_of_type_Beub.b(0, 2131719164, 0);
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
      paramBundle = alud.a(2131711399) + ulg.b;
      super.setContentView(2131561570);
      super.setTitle(paramBundle);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131377898));
      if (this.jdField_a_of_type_Int != 2) {
        break label481;
      }
      paramBundle = alud.a(2131711403) + ulg.b;
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramBundle);
      this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)super.findViewById(2131376621));
      this.jdField_a_of_type_Beub = new beub(this, 2131561236);
      this.jdField_a_of_type_Ulu = ((ulu)this.app.getManager(181));
      this.jdField_a_of_type_Ult = ((ult)this.app.a(98));
      this.jdField_a_of_type_JavaLangString = String.valueOf(hashCode());
      paramBundle = this.jdField_a_of_type_Ulu;
      if (this.jdField_a_of_type_Int != 2) {
        break label534;
      }
      bool = true;
      label204:
      paramBundle = new ArrayList(paramBundle.a(bool));
      if (bdin.g(this)) {
        break label539;
      }
      QQToast.a(this, 1, alud.a(2131711423), 0).b(getTitleBarHeight());
      this.jdField_a_of_type_Wdd = new wdd(this, paramBundle);
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Wdd);
      this.jdField_a_of_type_AndroidViewView = super.findViewById(2131369530);
      this.jdField_b_of_type_AndroidViewView = super.findViewById(2131371198);
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
    for (paramBundle = "把好友添加到这里后\r\n该好友将不会看到我的" + ulg.b;; paramBundle = "把好友添加到这里后\r\n将不会看到该好友的" + ulg.b)
    {
      ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131371187)).setText(paramBundle);
      this.jdField_b_of_type_Int = ((int)bdgz.a(this, 20.0F));
      setLeftViewName(2131690382);
      this.rightViewText.setOnClickListener(this);
      this.rightViewText.setText(alud.a(2131689628));
      this.rightViewText.setVisibility(0);
      this.jdField_a_of_type_Bdbb = new bdbb(this.app);
      this.jdField_a_of_type_Bdbb.a(this);
      this.jdField_a_of_type_AndroidUtilDisplayMetrics = getResources().getDisplayMetrics();
      return true;
      paramBundle = alud.a(2131711428) + ulg.b;
      break;
      paramBundle = alud.a(2131711420) + ulg.b + alud.a(2131711432) + ulg.jdField_a_of_type_JavaLangString + alud.a(2131711430);
      break label110;
      bool = false;
      break label204;
      this.app.addObserver(this.jdField_a_of_type_Ulw);
      ult localult = this.jdField_a_of_type_Ult;
      if (this.jdField_a_of_type_Int == 2) {}
      for (bool = true;; bool = false)
      {
        localult.a(null, 10, bool, this.jdField_a_of_type_JavaLangString);
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
    if (this.jdField_a_of_type_Bdbb != null) {
      this.jdField_a_of_type_Bdbb.d();
    }
    this.jdField_a_of_type_Beub.b();
    this.app.removeObserver(this.jdField_a_of_type_Ulw);
    super.doOnDestroy();
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    wxj.a(14, this.currentActivityStayTime);
  }
  
  public void finish()
  {
    wrl.a(this.app);
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
        if (bdin.g(this)) {
          break;
        }
        QQToast.a(this, 1, alud.a(2131711424), 0).b(getTitleBarHeight());
      }
      return;
      if (!bdin.g(this))
      {
        QQToast.a(this, 1, alud.a(2131711437), 0).b(getTitleBarHeight());
        return;
      }
      Object localObject2 = (QQStoryUserInfo)paramView.getTag();
      localObject1 = new ArrayList();
      ((ArrayList)localObject1).add(((QQStoryUserInfo)localObject2).uin);
      localObject2 = this.jdField_a_of_type_Ult;
      if (this.jdField_a_of_type_Int == 2) {}
      for (bool = true;; bool = false)
      {
        ((ult)localObject2).a((ArrayList)localObject1, bool, false);
        this.jdField_a_of_type_Beub.b(0, 2131719164, 0);
        if (this.jdField_a_of_type_Int != 2) {
          break label205;
        }
        wxj.a("friend_story_settings", "move_notletsee", 0, 0, new String[] { "", "", "", "" });
        break;
      }
      label205:
      wxj.a("friend_story_settings", "move_notsee", 0, 0, new String[] { "", "", "", "" });
    }
    paramView = new ArrayList();
    paramView.add(this.app.getCurrentAccountUin());
    Object localObject1 = this.jdField_a_of_type_Ulu;
    if (this.jdField_a_of_type_Int == 2) {}
    for (boolean bool = true;; bool = false)
    {
      localObject1 = ((ulu)localObject1).a(bool);
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
      wxj.a("friend_story_settings", "add_notletsee", 0, 0, new String[] { "", "", "", "" });
      return;
    }
    wxj.a("friend_story_settings", "add_notsee", 0, 0, new String[] { "", "", "", "" });
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    this.jdField_a_of_type_Wdd.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.settings.QQStoryShieldListActivity
 * JD-Core Version:    0.7.0.1
 */