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
import anvx;
import bhdz;
import biso;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.face.FaceDecoder;
import com.tencent.mobileqq.app.face.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import vzh;
import vzu;
import vzv;
import vzx;
import xqo;
import xqp;
import yex;
import ykv;

public class QQStoryShieldListActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, FaceDecoder.DecodeTaskCompletionListener
{
  public int a;
  public DisplayMetrics a;
  View jdField_a_of_type_AndroidViewView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  public biso a;
  FaceDecoder jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder;
  XListView jdField_a_of_type_ComTencentWidgetXListView;
  private String jdField_a_of_type_JavaLangString;
  public vzu a;
  public vzv a;
  vzx jdField_a_of_type_Vzx = new xqo(this);
  xqp jdField_a_of_type_Xqp;
  int jdField_b_of_type_Int;
  View jdField_b_of_type_AndroidViewView;
  
  public static void a(Activity paramActivity, ArrayList<String> paramArrayList, boolean paramBoolean)
  {
    Intent localIntent = new Intent(paramActivity, SelectMemberActivity.class);
    localIntent.putExtra("param_entrance", 24);
    localIntent.putExtra("param_only_friends", true);
    localIntent.putExtra("param_done_button_wording", paramActivity.getString(2131692403));
    localIntent.putExtra("param_uins_selected_default", paramArrayList);
    localIntent.putExtra("param_donot_need_contacts", true);
    localIntent.putExtra("param_donot_need_discussion", true);
    localIntent.putExtra("param_donot_need_troop", true);
    localIntent.putExtra("param_title", anvx.a(2131710483));
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
    this.jdField_a_of_type_Xqp.a(paramList);
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
    localObject = this.jdField_a_of_type_Vzu;
    if (this.jdField_a_of_type_Int == 2) {}
    for (boolean bool = true;; bool = false)
    {
      ((vzu)localObject).a(paramIntent, bool, true);
      this.jdField_a_of_type_Biso.b(0, 2131718013, 0);
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
      paramBundle = anvx.a(2131710463) + vzh.b;
      super.setContentView(2131561792);
      super.setTitle(paramBundle);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131378963));
      if (this.jdField_a_of_type_Int != 2) {
        break label482;
      }
      paramBundle = anvx.a(2131710467) + vzh.b;
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramBundle);
      this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)super.findViewById(2131377606));
      this.jdField_a_of_type_Biso = new biso(this, 2131561447);
      this.jdField_a_of_type_Vzv = ((vzv)this.app.getManager(QQManagerFactory.QQSTORY_MANAGER));
      this.jdField_a_of_type_Vzu = ((vzu)this.app.getBusinessHandler(BusinessHandlerFactory.QQSTORY_HANDLER));
      this.jdField_a_of_type_JavaLangString = String.valueOf(hashCode());
      paramBundle = this.jdField_a_of_type_Vzv;
      if (this.jdField_a_of_type_Int != 2) {
        break label535;
      }
      bool = true;
      label205:
      paramBundle = new ArrayList(paramBundle.a(bool));
      if (NetworkUtil.isNetworkAvailable(this)) {
        break label540;
      }
      QQToast.a(this, 1, anvx.a(2131710487), 0).b(getTitleBarHeight());
      this.jdField_a_of_type_Xqp = new xqp(this, paramBundle);
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Xqp);
      this.jdField_a_of_type_AndroidViewView = super.findViewById(2131370191);
      this.jdField_b_of_type_AndroidViewView = super.findViewById(2131372021);
      if ((paramBundle != null) && (paramBundle.size() != 0)) {
        break label591;
      }
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      label321:
      if (this.jdField_a_of_type_Int != 2) {
        break label611;
      }
    }
    label482:
    label611:
    for (paramBundle = "把好友添加到这里后\r\n该好友将不会看到我的" + vzh.b;; paramBundle = "把好友添加到这里后\r\n将不会看到该好友的" + vzh.b)
    {
      ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131372010)).setText(paramBundle);
      this.jdField_b_of_type_Int = ((int)bhdz.a(this, 20.0F));
      setLeftViewName(2131690499);
      this.rightViewText.setOnClickListener(this);
      this.rightViewText.setText(anvx.a(2131689550));
      this.rightViewText.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder = new FaceDecoder(this.app);
      this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.setDecodeTaskCompletionListener(this);
      this.jdField_a_of_type_AndroidUtilDisplayMetrics = getResources().getDisplayMetrics();
      return true;
      paramBundle = anvx.a(2131710492) + vzh.b;
      break;
      paramBundle = anvx.a(2131710484) + vzh.b + anvx.a(2131710496) + vzh.jdField_a_of_type_JavaLangString + anvx.a(2131710494);
      break label110;
      bool = false;
      break label205;
      this.app.addObserver(this.jdField_a_of_type_Vzx);
      vzu localvzu = this.jdField_a_of_type_Vzu;
      if (this.jdField_a_of_type_Int == 2) {}
      for (bool = true;; bool = false)
      {
        localvzu.a(null, 10, bool, this.jdField_a_of_type_JavaLangString);
        super.startTitleProgress();
        break;
      }
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      break label321;
    }
  }
  
  public void doOnDestroy()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.destory();
    }
    this.jdField_a_of_type_Biso.b();
    this.app.removeObserver(this.jdField_a_of_type_Vzx);
    super.doOnDestroy();
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    ykv.a(14, this.currentActivityStayTime);
  }
  
  public void finish()
  {
    yex.a(this.app);
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
        QQToast.a(this, 1, anvx.a(2131710488), 0).b(getTitleBarHeight());
      }
      break;
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (!NetworkUtil.isNetworkAvailable(this))
      {
        QQToast.a(this, 1, anvx.a(2131710501), 0).b(getTitleBarHeight());
      }
      else
      {
        Object localObject = (QQStoryUserInfo)paramView.getTag();
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(((QQStoryUserInfo)localObject).uin);
        localObject = this.jdField_a_of_type_Vzu;
        if (this.jdField_a_of_type_Int == 2) {}
        for (boolean bool = true;; bool = false)
        {
          ((vzu)localObject).a(localArrayList, bool, false);
          this.jdField_a_of_type_Biso.b(0, 2131718013, 0);
          if (this.jdField_a_of_type_Int != 2) {
            break label214;
          }
          ykv.a("friend_story_settings", "move_notletsee", 0, 0, new String[] { "", "", "", "" });
          break;
        }
        label214:
        ykv.a("friend_story_settings", "move_notsee", 0, 0, new String[] { "", "", "", "" });
        break;
        label256:
        localArrayList = new ArrayList();
        localArrayList.add(this.app.getCurrentAccountUin());
        localObject = this.jdField_a_of_type_Vzv;
        if (this.jdField_a_of_type_Int == 2) {}
        for (bool = true;; bool = false)
        {
          localObject = ((vzv)localObject).a(bool);
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
          ykv.a("friend_story_settings", "add_notletsee", 0, 0, new String[] { "", "", "", "" });
          break;
        }
        label421:
        ykv.a("friend_story_settings", "add_notsee", 0, 0, new String[] { "", "", "", "" });
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
    this.jdField_a_of_type_Xqp.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.settings.QQStoryShieldListActivity
 * JD-Core Version:    0.7.0.1
 */