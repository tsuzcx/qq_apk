package com.tencent.biz.qqstory.storyHome.messagenotify;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.UserManager;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.qqstory.widget.StoryCoverView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import nye;

public class StoryMessageListActivity$StoryMessageListAdapter
  extends BaseAdapter
  implements View.OnClickListener
{
  LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(BaseApplication.getContext());
  nye jdField_a_of_type_Nye = new nye();
  int[] jdField_a_of_type_ArrayOfInt = URLDrawableDecodeHandler.a(UIUtils.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.getApplicationContext(), 50.0F), UIUtils.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.getApplicationContext(), 70.0F), UIUtils.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.getApplicationContext(), 3.0F));
  
  protected StoryMessageListActivity$StoryMessageListAdapter(StoryMessageListActivity paramStoryMessageListActivity) {}
  
  public MessageData a(int paramInt)
  {
    if (a(paramInt)) {
      return (MessageData)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.a.get(paramInt);
    }
    return null;
  }
  
  public boolean a(int paramInt)
  {
    return paramInt < this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.a.size();
  }
  
  public int getCount()
  {
    int i = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.a.size();
    if ((this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.jdField_c_of_type_Int == 1) || (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.jdField_c_of_type_Int == 3))
    {
      if ((i != 0) && (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.jdField_b_of_type_Int != 2)) {}
    }
    else {
      while (((this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.jdField_c_of_type_Int == 0) || (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.jdField_c_of_type_Int == 2)) && (((i == 0) && (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.jdField_b_of_type_Int != 2)) || ((!this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.jdField_b_of_type_Int == 2)))) {
        return i;
      }
    }
    return i + 1;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (a(paramInt)) {
      return 0;
    }
    return 1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject1;
    boolean bool;
    label210:
    int i;
    if (a(paramInt))
    {
      if (paramView == null)
      {
        paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130970778, paramViewGroup, false);
        paramViewGroup = new StoryMessageListActivity.ItemViewHolder(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity, paramView);
        paramView = this.jdField_a_of_type_Nye.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity, paramView, paramViewGroup, -1);
        paramView.setTag(paramViewGroup);
      }
      MessageData localMessageData;
      for (;;)
      {
        localMessageData = a(paramInt);
        if (localMessageData != null) {
          break;
        }
        return paramView;
        paramViewGroup = (StoryMessageListActivity.ItemViewHolder)paramView.getTag();
      }
      localObject1 = localMessageData.jdField_a_of_type_JavaLangString;
      Object localObject2;
      if ((localObject1 != null) && (!((String)localObject1).equals(paramViewGroup.jdField_a_of_type_JavaLangString)))
      {
        localObject2 = ((UserManager)SuperManager.a(2)).b((String)localObject1);
        if (localObject2 == null) {
          break label607;
        }
        paramViewGroup.jdField_a_of_type_JavaLangString = ((String)localObject1);
        if (((localMessageData.jdField_a_of_type_Int == 14) || (localMessageData.jdField_a_of_type_Int == 13) || (localMessageData.jdField_a_of_type_Int == 16) || (localMessageData.jdField_a_of_type_Int == 17)) && (QQUserUIItem.isNotDovUser(String.valueOf(localMessageData.b)))) {
          ((QQUserUIItem)localObject2).qq = String.valueOf(localMessageData.b);
        }
      }
      for (;;)
      {
        if (localMessageData.jdField_e_of_type_Int == 4)
        {
          bool = true;
          Resources localResources = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.getResources();
          ImageView localImageView = paramViewGroup.jdField_a_of_type_AndroidWidgetImageView;
          float f1 = 50;
          TextView localTextView = paramViewGroup.jdField_a_of_type_AndroidWidgetTextView;
          float f2 = 13;
          float f3 = 5;
          if (!bool) {
            break label621;
          }
          localObject1 = String.valueOf(localMessageData.b);
          label260:
          PlayModeUtils.a(localResources, (QQUserUIItem)localObject2, localImageView, f1, localTextView, f2, f3, bool, (String)localObject1);
          if (localMessageData.jdField_a_of_type_Int != 1) {
            break label627;
          }
          paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
          paramViewGroup.c.setVisibility(8);
          paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(0);
          label316:
          paramViewGroup.d.setText(localMessageData.a());
          if (localMessageData.jdField_e_of_type_Int != 4) {
            break label1554;
          }
          localObject1 = ContactUtils.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.app, String.valueOf(localMessageData.b), true);
          paramViewGroup.e.setText((CharSequence)localObject1);
          paramViewGroup.e.setVisibility(0);
          paramViewGroup.f.setVisibility(8);
          label384:
          if (!localMessageData.b().equals(paramViewGroup.jdField_b_of_type_JavaLangString))
          {
            paramViewGroup.jdField_b_of_type_JavaLangString = localMessageData.b();
            localObject1 = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.getResources().getDrawable(2130843797);
          }
        }
        try
        {
          localObject2 = URLDrawable.URLDrawableOptions.obtain();
          ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = ((Drawable)localObject1);
          ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = ((Drawable)localObject1);
          ((URLDrawable.URLDrawableOptions)localObject2).mMemoryCacheKeySuffix = "story_message";
          localObject2 = URLDrawable.getDrawable(localMessageData.b(), (URLDrawable.URLDrawableOptions)localObject2);
          ((URLDrawable)localObject2).setTag(this.jdField_a_of_type_ArrayOfInt);
          ((URLDrawable)localObject2).setDecodeHandler(URLDrawableDecodeHandler.g);
          paramViewGroup.jdField_a_of_type_ComTencentBizQqstoryWidgetStoryCoverView.setImageDrawable((Drawable)localObject2);
          if (localMessageData.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem$PollLayout != null) {
            paramViewGroup.jdField_a_of_type_ComTencentBizQqstoryWidgetStoryCoverView.setPollLayout(localMessageData.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem$PollLayout, -1, null);
          }
          if (localMessageData.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem$InteractPasterLayout != null) {
            paramViewGroup.jdField_a_of_type_ComTencentBizQqstoryWidgetStoryCoverView.setRateLayout(localMessageData.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem$InteractPasterLayout, -1, -1L, -1);
          }
          localObject1 = paramViewGroup.jdField_b_of_type_AndroidViewView;
          if (paramInt == this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.a.size() - 1) {
            if (getCount() == this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.a.size())
            {
              i = 0;
              ((View)localObject1).setVisibility(i);
              this.jdField_a_of_type_Nye.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity, paramView, paramInt, localMessageData, paramViewGroup, this);
              paramViewGroup.a(paramInt);
              return paramView;
              label607:
              paramViewGroup.jdField_a_of_type_JavaLangString = null;
              continue;
              bool = false;
              break label210;
              label621:
              localObject1 = null;
              break label260;
              label627:
              if ((localMessageData.jdField_a_of_type_Int == 2) || (localMessageData.jdField_a_of_type_Int == 3))
              {
                if (localMessageData.jdField_a_of_type_Boolean)
                {
                  paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
                  paramViewGroup.c.setVisibility(0);
                  paramViewGroup.c.setText("该评论已被删除");
                  paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(8);
                  break label316;
                }
                paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.a(localMessageData));
                paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
                paramViewGroup.c.setVisibility(8);
                paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(8);
                break label316;
              }
              if (localMessageData.jdField_a_of_type_Int == 4)
              {
                paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText("更新了小视频");
                paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
                if (localMessageData.jdField_a_of_type_Boolean)
                {
                  paramViewGroup.c.setVisibility(0);
                  paramViewGroup.c.setText("该视频已被删除");
                }
                for (;;)
                {
                  paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(8);
                  break;
                  paramViewGroup.c.setVisibility(8);
                }
              }
              if (localMessageData.jdField_a_of_type_Int == 12)
              {
                paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.b(localMessageData));
                paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
                if (localMessageData.jdField_a_of_type_Boolean)
                {
                  paramViewGroup.c.setVisibility(0);
                  paramViewGroup.c.setText("该视频已被删除");
                }
                for (;;)
                {
                  paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(8);
                  break;
                  paramViewGroup.c.setVisibility(8);
                }
              }
              if ((localMessageData.jdField_a_of_type_Int == 14) || (localMessageData.jdField_a_of_type_Int == 13))
              {
                paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.c(localMessageData));
                paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
                if (localMessageData.jdField_a_of_type_Boolean)
                {
                  paramViewGroup.c.setVisibility(0);
                  paramViewGroup.c.setText("该视频已被删除");
                }
                for (;;)
                {
                  paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(8);
                  break;
                  paramViewGroup.c.setVisibility(8);
                }
              }
              if (localMessageData.jdField_a_of_type_Int == 15)
              {
                paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.d(localMessageData));
                paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
                if (localMessageData.jdField_a_of_type_Boolean)
                {
                  paramViewGroup.c.setVisibility(0);
                  paramViewGroup.c.setText("该视频已被删除");
                }
                for (;;)
                {
                  paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(8);
                  break;
                  paramViewGroup.c.setVisibility(8);
                }
              }
              if ((localMessageData.jdField_a_of_type_Int == 16) || (localMessageData.jdField_a_of_type_Int == 17))
              {
                paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.e(localMessageData));
                paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
                if (localMessageData.jdField_a_of_type_Boolean)
                {
                  paramViewGroup.c.setVisibility(0);
                  paramViewGroup.c.setText("该视频已被删除");
                }
                for (;;)
                {
                  paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(8);
                  break;
                  paramViewGroup.c.setVisibility(8);
                }
              }
              if (localMessageData.jdField_a_of_type_Int == 5)
              {
                paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText(localMessageData.j);
                paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
                paramViewGroup.c.setVisibility(8);
                paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(8);
                break label316;
              }
              if (localMessageData.jdField_a_of_type_Int == 6)
              {
                paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText(localMessageData.jdField_e_of_type_JavaLangString);
                paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
                paramViewGroup.c.setVisibility(8);
                paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(8);
                break label316;
              }
              if (localMessageData.jdField_a_of_type_Int == 7)
              {
                paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText(localMessageData.jdField_e_of_type_JavaLangString);
                paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
                paramViewGroup.c.setVisibility(8);
                paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(8);
                break label316;
              }
              if (localMessageData.jdField_a_of_type_Int == 8)
              {
                paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText(2131432109);
                paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
                paramViewGroup.c.setVisibility(8);
                paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(8);
                break label316;
              }
              if (localMessageData.jdField_a_of_type_Int == 9)
              {
                paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText(localMessageData.jdField_e_of_type_JavaLangString);
                paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
                paramViewGroup.c.setVisibility(8);
                paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(8);
                break label316;
              }
              if (localMessageData.jdField_a_of_type_Int == 10)
              {
                paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText(localMessageData.jdField_e_of_type_JavaLangString);
                paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
                paramViewGroup.c.setVisibility(8);
                paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(8);
                break label316;
              }
              if (localMessageData.jdField_a_of_type_Int == 11)
              {
                paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText(localMessageData.jdField_e_of_type_JavaLangString);
                paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
                paramViewGroup.c.setVisibility(8);
                paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(8);
                break label316;
              }
              paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
              paramViewGroup.c.setVisibility(8);
              paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(8);
              break label316;
              label1554:
              if (((localMessageData.jdField_e_of_type_Int == 99) || (localMessageData.jdField_e_of_type_Int == 104)) && (localMessageData.jdField_a_of_type_Int != 6) && (localMessageData.jdField_a_of_type_Int != 9))
              {
                paramViewGroup.e.setText(localMessageData.k);
                paramViewGroup.e.setVisibility(0);
                paramViewGroup.f.setVisibility(8);
                break label384;
              }
              if (((localMessageData.jdField_a_of_type_Int == 13) || (localMessageData.jdField_a_of_type_Int == 14) || (localMessageData.jdField_a_of_type_Int == 16) || (localMessageData.jdField_a_of_type_Int == 17)) && (!TextUtils.isEmpty(localMessageData.p)))
              {
                if ("QQ好友".equals(localMessageData.p)) {
                  paramViewGroup.e.setVisibility(8);
                }
                for (;;)
                {
                  paramViewGroup.f.setVisibility(8);
                  break;
                  paramViewGroup.e.setText(localMessageData.p);
                  paramViewGroup.e.setVisibility(0);
                }
              }
              paramViewGroup.e.setVisibility(8);
              paramViewGroup.f.setVisibility(8);
            }
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            paramViewGroup.jdField_a_of_type_ComTencentBizQqstoryWidgetStoryCoverView.setImageDrawable((Drawable)localObject1);
            continue;
            i = 8;
            continue;
            i = 0;
          }
        }
      }
    }
    if (paramView == null)
    {
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130970779, paramViewGroup, false);
      paramViewGroup = new StoryMessageListActivity.FooterViewHolder(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity, paramView);
      paramView.setTag(paramViewGroup);
      switch (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.jdField_b_of_type_Int)
      {
      }
    }
    for (;;)
    {
      paramViewGroup.a(paramInt);
      return paramView;
      paramViewGroup = (StoryMessageListActivity.FooterViewHolder)paramView.getTag();
      break;
      if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.jdField_b_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.jdField_b_of_type_Boolean = false;
        paramViewGroup.jdField_b_of_type_AndroidViewView.setVisibility(8);
        paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(0);
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(2131432120);
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqstory.msgList", 2, "list - load more");
        }
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.a();
      }
      else
      {
        paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(8);
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        paramViewGroup.jdField_b_of_type_AndroidViewView.setVisibility(0);
        QQStoryContext.a();
        bool = ThemeUtil.isInNightMode(QQStoryContext.a());
        localObject1 = paramViewGroup.jdField_a_of_type_AndroidWidgetImageView;
        if (bool) {}
        for (i = 2130843465;; i = 2130843464)
        {
          ((ImageView)localObject1).setImageResource(i);
          break;
        }
        paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(0);
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(2131432120);
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqstory.msgList", 2, "pull to load more");
        }
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.a();
        continue;
        if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.jdField_b_of_type_Boolean)
        {
          this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.jdField_b_of_type_Boolean = false;
          paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(0);
          paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(2131432120);
          this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.a();
        }
        else
        {
          paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(8);
          paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText("加载失败，点击重试");
          continue;
          paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(0);
          paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(2131432120);
        }
      }
    }
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
  
  public void onClick(View paramView)
  {
    int i;
    try
    {
      i = Integer.parseInt(String.valueOf(paramView.getTag(-1)));
      if (i == -1) {
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.qqstory.msgList", 2, localException, new Object[0]);
        }
        i = -1;
      }
      switch (paramView.getId())
      {
      default: 
        return;
      }
    }
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.a(i);
    StoryReportor.a("play_video", "del_notice", 0, 0, new String[] { "", "", "", "" });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.messagenotify.StoryMessageListActivity.StoryMessageListAdapter
 * JD-Core Version:    0.7.0.1
 */