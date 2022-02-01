package com.tencent.biz.qqstory.settings;

import Override;
import amtj;
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
import bfvh;
import bhhw;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.FaceDecoder;
import com.tencent.mobileqq.app.face.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import vkm;
import vkz;
import vla;
import vlc;
import xbt;
import xbu;
import xqc;
import xwa;

public class QQStoryShieldListActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, FaceDecoder.DecodeTaskCompletionListener
{
  public int a;
  public DisplayMetrics a;
  View jdField_a_of_type_AndroidViewView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  public bhhw a;
  FaceDecoder jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder;
  XListView jdField_a_of_type_ComTencentWidgetXListView;
  private String jdField_a_of_type_JavaLangString;
  public vkz a;
  public vla a;
  vlc jdField_a_of_type_Vlc = new xbt(this);
  xbu jdField_a_of_type_Xbu;
  int jdField_b_of_type_Int;
  View jdField_b_of_type_AndroidViewView;
  
  public static void a(Activity paramActivity, ArrayList<String> paramArrayList, boolean paramBoolean)
  {
    Intent localIntent = new Intent(paramActivity, SelectMemberActivity.class);
    localIntent.putExtra("param_entrance", 24);
    localIntent.putExtra("param_only_friends", true);
    localIntent.putExtra("param_done_button_wording", paramActivity.getString(2131692310));
    localIntent.putExtra("param_uins_selected_default", paramArrayList);
    localIntent.putExtra("param_donot_need_contacts", true);
    localIntent.putExtra("param_donot_need_discussion", true);
    localIntent.putExtra("param_donot_need_troop", true);
    localIntent.putExtra("param_title", amtj.a(2131710136));
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
    this.jdField_a_of_type_Xbu.a(paramList);
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
      paramIntent.add(((ResultRecord)((Iterator)localObject).next()).uin);
    }
    localObject = this.jdField_a_of_type_Vkz;
    if (this.jdField_a_of_type_Int == 2) {}
    for (boolean bool = true;; bool = false)
    {
      ((vkz)localObject).a(paramIntent, bool, true);
      this.jdField_a_of_type_Bhhw.b(0, 2131717646, 0);
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
      paramBundle = amtj.a(2131710116) + vkm.b;
      super.setContentView(2131561724);
      super.setTitle(paramBundle);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131378669));
      if (this.jdField_a_of_type_Int != 2) {
        break label481;
      }
      paramBundle = amtj.a(2131710120) + vkm.b;
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramBundle);
      this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)super.findViewById(2131377333));
      this.jdField_a_of_type_Bhhw = new bhhw(this, 2131561385);
      this.jdField_a_of_type_Vla = ((vla)this.app.getManager(181));
      this.jdField_a_of_type_Vkz = ((vkz)this.app.getBusinessHandler(98));
      this.jdField_a_of_type_JavaLangString = String.valueOf(hashCode());
      paramBundle = this.jdField_a_of_type_Vla;
      if (this.jdField_a_of_type_Int != 2) {
        break label534;
      }
      bool = true;
      label204:
      paramBundle = new ArrayList(paramBundle.a(bool));
      if (NetworkUtil.isNetworkAvailable(this)) {
        break label539;
      }
      QQToast.a(this, 1, amtj.a(2131710140), 0).b(getTitleBarHeight());
      this.jdField_a_of_type_Xbu = new xbu(this, paramBundle);
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Xbu);
      this.jdField_a_of_type_AndroidViewView = super.findViewById(2131370020);
      this.jdField_b_of_type_AndroidViewView = super.findViewById(2131371831);
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
    for (paramBundle = "把好友添加到这里后\r\n该好友将不会看到我的" + vkm.b;; paramBundle = "把好友添加到这里后\r\n将不会看到该好友的" + vkm.b)
    {
      ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131371820)).setText(paramBundle);
      this.jdField_b_of_type_Int = ((int)bfvh.a(this, 20.0F));
      setLeftViewName(2131690424);
      this.rightViewText.setOnClickListener(this);
      this.rightViewText.setText(amtj.a(2131689550));
      this.rightViewText.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder = new FaceDecoder(this.app);
      this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.setDecodeTaskCompletionListener(this);
      this.jdField_a_of_type_AndroidUtilDisplayMetrics = getResources().getDisplayMetrics();
      return true;
      paramBundle = amtj.a(2131710145) + vkm.b;
      break;
      paramBundle = amtj.a(2131710137) + vkm.b + amtj.a(2131710149) + vkm.jdField_a_of_type_JavaLangString + amtj.a(2131710147);
      break label110;
      bool = false;
      break label204;
      this.app.addObserver(this.jdField_a_of_type_Vlc);
      vkz localvkz = this.jdField_a_of_type_Vkz;
      if (this.jdField_a_of_type_Int == 2) {}
      for (bool = true;; bool = false)
      {
        localvkz.a(null, 10, bool, this.jdField_a_of_type_JavaLangString);
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
    if (this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.destory();
    }
    this.jdField_a_of_type_Bhhw.b();
    this.app.removeObserver(this.jdField_a_of_type_Vlc);
    super.doOnDestroy();
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    xwa.a(14, this.currentActivityStayTime);
  }
  
  public void finish()
  {
    xqc.a(this.app);
    super.finish();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      if (paramView == this.rightViewText)
      {
        if (NetworkUtil.isNetworkAvailable(this)) {
          break label256;
        }
        QQToast.a(this, 1, amtj.a(2131710141), 0).b(getTitleBarHeight());
      }
      break;
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (!NetworkUtil.isNetworkAvailable(this))
      {
        QQToast.a(this, 1, amtj.a(2131710154), 0).b(getTitleBarHeight());
      }
      else
      {
        Object localObject = (QQStoryUserInfo)paramView.getTag();
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(((QQStoryUserInfo)localObject).uin);
        localObject = this.jdField_a_of_type_Vkz;
        if (this.jdField_a_of_type_Int == 2) {}
        for (boolean bool = true;; bool = false)
        {
          ((vkz)localObject).a(localArrayList, bool, false);
          this.jdField_a_of_type_Bhhw.b(0, 2131717646, 0);
          if (this.jdField_a_of_type_Int != 2) {
            break label214;
          }
          xwa.a("friend_story_settings", "move_notletsee", 0, 0, new String[] { "", "", "", "" });
          break;
        }
        label214:
        xwa.a("friend_story_settings", "move_notsee", 0, 0, new String[] { "", "", "", "" });
        break;
        label256:
        localArrayList = new ArrayList();
        localArrayList.add(this.app.getCurrentAccountUin());
        localObject = this.jdField_a_of_type_Vla;
        if (this.jdField_a_of_type_Int == 2) {}
        for (bool = true;; bool = false)
        {
          localObject = ((vla)localObject).a(bool);
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
          xwa.a("friend_story_settings", "add_notletsee", 0, 0, new String[] { "", "", "", "" });
          break;
        }
        label421:
        xwa.a("friend_story_settings", "add_notsee", 0, 0, new String[] { "", "", "", "" });
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
    this.jdField_a_of_type_Xbu.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.settings.QQStoryShieldListActivity
 * JD-Core Version:    0.7.0.1
 */