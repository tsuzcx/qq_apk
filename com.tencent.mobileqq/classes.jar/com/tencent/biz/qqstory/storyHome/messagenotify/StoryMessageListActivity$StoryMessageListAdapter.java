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
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.SwipRightMenuBuilder.SwipItemBaseHolder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class StoryMessageListActivity$StoryMessageListAdapter
  extends BaseAdapter
  implements View.OnClickListener
{
  LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(BaseApplication.getContext());
  StoryMessageListActivity.StoryMessageListItemBuilder jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity$StoryMessageListItemBuilder = new StoryMessageListActivity.StoryMessageListItemBuilder();
  int[] jdField_a_of_type_ArrayOfInt = URLDrawableDecodeHandler.b(UIUtils.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.getApplicationContext(), 50.0F), UIUtils.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.getApplicationContext(), 70.0F), UIUtils.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.getApplicationContext(), 3.0F));
  
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
    Object localObject2;
    label109:
    boolean bool;
    label227:
    label239:
    int i;
    if (a(paramInt))
    {
      MessageData localMessageData;
      if (paramView == null)
      {
        localObject1 = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561859, paramViewGroup, false);
        localObject2 = new StoryMessageListActivity.ItemViewHolder(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity, (View)localObject1);
        localObject1 = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity$StoryMessageListItemBuilder.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity, (View)localObject1, (SwipRightMenuBuilder.SwipItemBaseHolder)localObject2, -1);
        ((View)localObject1).setTag(localObject2);
        localMessageData = a(paramInt);
        if (localMessageData != null) {
          break label109;
        }
      }
      for (;;)
      {
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return localObject1;
        localObject2 = (StoryMessageListActivity.ItemViewHolder)paramView.getTag();
        localObject1 = paramView;
        break;
        Object localObject3 = localMessageData.jdField_a_of_type_JavaLangString;
        Object localObject4;
        if ((localObject3 != null) && (!((String)localObject3).equals(((StoryMessageListActivity.ItemViewHolder)localObject2).jdField_a_of_type_JavaLangString)))
        {
          localObject4 = ((UserManager)SuperManager.a(2)).b((String)localObject3);
          if (localObject4 != null)
          {
            ((StoryMessageListActivity.ItemViewHolder)localObject2).jdField_a_of_type_JavaLangString = ((String)localObject3);
            if (((localMessageData.jdField_a_of_type_Int == 14) || (localMessageData.jdField_a_of_type_Int == 13) || (localMessageData.jdField_a_of_type_Int == 16) || (localMessageData.jdField_a_of_type_Int == 17)) && (QQUserUIItem.isNotDovUser(String.valueOf(localMessageData.b)))) {
              ((QQUserUIItem)localObject4).qq = String.valueOf(localMessageData.b);
            }
            if (localMessageData.jdField_f_of_type_Int != 4) {
              break label676;
            }
            bool = true;
            Resources localResources = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.getResources();
            ImageView localImageView = ((StoryMessageListActivity.ItemViewHolder)localObject2).jdField_a_of_type_AndroidWidgetImageView;
            float f1 = 50;
            TextView localTextView = ((StoryMessageListActivity.ItemViewHolder)localObject2).jdField_a_of_type_AndroidWidgetTextView;
            float f2 = 13;
            float f3 = 5;
            if (!bool) {
              break label682;
            }
            localObject3 = String.valueOf(localMessageData.b);
            label291:
            PlayModeUtils.a(localResources, (QQUserUIItem)localObject4, localImageView, f1, localTextView, f2, f3, bool, (String)localObject3);
          }
        }
        else
        {
          if (localMessageData.jdField_a_of_type_Int != 1) {
            break label688;
          }
          ((StoryMessageListActivity.ItemViewHolder)localObject2).jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
          ((StoryMessageListActivity.ItemViewHolder)localObject2).c.setVisibility(8);
          ((StoryMessageListActivity.ItemViewHolder)localObject2).jdField_a_of_type_AndroidViewView.setVisibility(0);
          label350:
          ((StoryMessageListActivity.ItemViewHolder)localObject2).d.setText(localMessageData.a());
          if (localMessageData.jdField_f_of_type_Int != 4) {
            break label1995;
          }
          localObject3 = ContactUtils.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.app, String.valueOf(localMessageData.b), true);
          ((StoryMessageListActivity.ItemViewHolder)localObject2).e.setText((CharSequence)localObject3);
          ((StoryMessageListActivity.ItemViewHolder)localObject2).e.setVisibility(0);
          ((StoryMessageListActivity.ItemViewHolder)localObject2).f.setVisibility(8);
          label422:
          if ((!TextUtils.isEmpty(localMessageData.b())) && (!localMessageData.b().equals(((StoryMessageListActivity.ItemViewHolder)localObject2).jdField_b_of_type_JavaLangString)))
          {
            ((StoryMessageListActivity.ItemViewHolder)localObject2).jdField_b_of_type_JavaLangString = localMessageData.b();
            localObject3 = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.getResources().getDrawable(2130847249);
          }
        }
        try
        {
          localObject4 = URLDrawable.URLDrawableOptions.obtain();
          ((URLDrawable.URLDrawableOptions)localObject4).mLoadingDrawable = ((Drawable)localObject3);
          ((URLDrawable.URLDrawableOptions)localObject4).mFailedDrawable = ((Drawable)localObject3);
          ((URLDrawable.URLDrawableOptions)localObject4).mMemoryCacheKeySuffix = "story_message";
          localObject4 = URLDrawable.getDrawable(localMessageData.b(), (URLDrawable.URLDrawableOptions)localObject4);
          ((URLDrawable)localObject4).setTag(this.jdField_a_of_type_ArrayOfInt);
          ((URLDrawable)localObject4).setDecodeHandler(URLDrawableDecodeHandler.j);
          ((StoryMessageListActivity.ItemViewHolder)localObject2).jdField_a_of_type_ComTencentBizQqstoryWidgetStoryCoverView.setImageDrawable((Drawable)localObject4);
          if (localMessageData.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem$PollLayout != null) {
            ((StoryMessageListActivity.ItemViewHolder)localObject2).jdField_a_of_type_ComTencentBizQqstoryWidgetStoryCoverView.setPollLayout(localMessageData.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem$PollLayout, -1, null);
          }
          if (localMessageData.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem$InteractPasterLayout != null) {
            ((StoryMessageListActivity.ItemViewHolder)localObject2).jdField_a_of_type_ComTencentBizQqstoryWidgetStoryCoverView.setRateLayout(localMessageData.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem$InteractPasterLayout, -1, -1L, -1);
          }
          localObject3 = ((StoryMessageListActivity.ItemViewHolder)localObject2).jdField_b_of_type_AndroidViewView;
          if (paramInt == this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.a.size() - 1) {
            if (getCount() == this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.a.size())
            {
              i = 0;
              ((View)localObject3).setVisibility(i);
              this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity$StoryMessageListItemBuilder.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity, (View)localObject1, paramInt, localMessageData, (SwipRightMenuBuilder.SwipItemBaseHolder)localObject2, this);
              ((StoryMessageListActivity.ItemViewHolder)localObject2).a(paramInt);
              continue;
              ((StoryMessageListActivity.ItemViewHolder)localObject2).jdField_a_of_type_JavaLangString = null;
              break label227;
              label676:
              bool = false;
              break label239;
              label682:
              localObject3 = null;
              break label291;
              label688:
              if ((localMessageData.jdField_a_of_type_Int == 2) || (localMessageData.jdField_a_of_type_Int == 3))
              {
                if (localMessageData.jdField_a_of_type_Boolean)
                {
                  ((StoryMessageListActivity.ItemViewHolder)localObject2).jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
                  ((StoryMessageListActivity.ItemViewHolder)localObject2).c.setVisibility(0);
                  ((StoryMessageListActivity.ItemViewHolder)localObject2).c.setText(HardCodeUtil.a(2131714404));
                  ((StoryMessageListActivity.ItemViewHolder)localObject2).jdField_a_of_type_AndroidViewView.setVisibility(8);
                  break label350;
                }
                ((StoryMessageListActivity.ItemViewHolder)localObject2).jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.a(localMessageData));
                ((StoryMessageListActivity.ItemViewHolder)localObject2).jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
                ((StoryMessageListActivity.ItemViewHolder)localObject2).c.setVisibility(8);
                ((StoryMessageListActivity.ItemViewHolder)localObject2).jdField_a_of_type_AndroidViewView.setVisibility(8);
                break label350;
              }
              if (localMessageData.jdField_a_of_type_Int == 4)
              {
                ((StoryMessageListActivity.ItemViewHolder)localObject2).jdField_b_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131714396));
                ((StoryMessageListActivity.ItemViewHolder)localObject2).jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
                if (localMessageData.jdField_a_of_type_Boolean)
                {
                  ((StoryMessageListActivity.ItemViewHolder)localObject2).c.setVisibility(0);
                  ((StoryMessageListActivity.ItemViewHolder)localObject2).c.setText(HardCodeUtil.a(2131714382));
                }
                for (;;)
                {
                  ((StoryMessageListActivity.ItemViewHolder)localObject2).jdField_a_of_type_AndroidViewView.setVisibility(8);
                  break;
                  ((StoryMessageListActivity.ItemViewHolder)localObject2).c.setVisibility(8);
                }
              }
              if (localMessageData.jdField_a_of_type_Int == 12)
              {
                ((StoryMessageListActivity.ItemViewHolder)localObject2).jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.c(localMessageData));
                ((StoryMessageListActivity.ItemViewHolder)localObject2).jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
                if (localMessageData.jdField_a_of_type_Boolean)
                {
                  ((StoryMessageListActivity.ItemViewHolder)localObject2).c.setVisibility(0);
                  ((StoryMessageListActivity.ItemViewHolder)localObject2).c.setText(HardCodeUtil.a(2131714383));
                }
                for (;;)
                {
                  ((StoryMessageListActivity.ItemViewHolder)localObject2).jdField_a_of_type_AndroidViewView.setVisibility(8);
                  break;
                  ((StoryMessageListActivity.ItemViewHolder)localObject2).c.setVisibility(8);
                }
              }
              if ((localMessageData.jdField_a_of_type_Int == 14) || (localMessageData.jdField_a_of_type_Int == 13))
              {
                ((StoryMessageListActivity.ItemViewHolder)localObject2).jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.d(localMessageData));
                ((StoryMessageListActivity.ItemViewHolder)localObject2).jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
                if (localMessageData.jdField_a_of_type_Boolean)
                {
                  ((StoryMessageListActivity.ItemViewHolder)localObject2).c.setVisibility(0);
                  ((StoryMessageListActivity.ItemViewHolder)localObject2).c.setText(HardCodeUtil.a(2131714384));
                }
                for (;;)
                {
                  ((StoryMessageListActivity.ItemViewHolder)localObject2).jdField_a_of_type_AndroidViewView.setVisibility(8);
                  break;
                  ((StoryMessageListActivity.ItemViewHolder)localObject2).c.setVisibility(8);
                }
              }
              if (localMessageData.jdField_a_of_type_Int == 15)
              {
                ((StoryMessageListActivity.ItemViewHolder)localObject2).jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.e(localMessageData));
                ((StoryMessageListActivity.ItemViewHolder)localObject2).jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
                if (localMessageData.jdField_a_of_type_Boolean)
                {
                  ((StoryMessageListActivity.ItemViewHolder)localObject2).c.setVisibility(0);
                  ((StoryMessageListActivity.ItemViewHolder)localObject2).c.setText(HardCodeUtil.a(2131714405));
                }
                for (;;)
                {
                  ((StoryMessageListActivity.ItemViewHolder)localObject2).jdField_a_of_type_AndroidViewView.setVisibility(8);
                  break;
                  ((StoryMessageListActivity.ItemViewHolder)localObject2).c.setVisibility(8);
                }
              }
              if ((localMessageData.jdField_a_of_type_Int == 16) || (localMessageData.jdField_a_of_type_Int == 17))
              {
                ((StoryMessageListActivity.ItemViewHolder)localObject2).jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.f(localMessageData));
                ((StoryMessageListActivity.ItemViewHolder)localObject2).jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
                if (localMessageData.jdField_a_of_type_Boolean)
                {
                  ((StoryMessageListActivity.ItemViewHolder)localObject2).c.setVisibility(0);
                  ((StoryMessageListActivity.ItemViewHolder)localObject2).c.setText(HardCodeUtil.a(2131714402));
                }
                for (;;)
                {
                  ((StoryMessageListActivity.ItemViewHolder)localObject2).jdField_a_of_type_AndroidViewView.setVisibility(8);
                  break;
                  ((StoryMessageListActivity.ItemViewHolder)localObject2).c.setVisibility(8);
                }
              }
              if (localMessageData.jdField_a_of_type_Int == 5)
              {
                ((StoryMessageListActivity.ItemViewHolder)localObject2).jdField_b_of_type_AndroidWidgetTextView.setText(localMessageData.j);
                ((StoryMessageListActivity.ItemViewHolder)localObject2).jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
                ((StoryMessageListActivity.ItemViewHolder)localObject2).c.setVisibility(8);
                ((StoryMessageListActivity.ItemViewHolder)localObject2).jdField_a_of_type_AndroidViewView.setVisibility(8);
                break label350;
              }
              if (localMessageData.jdField_a_of_type_Int == 6)
              {
                ((StoryMessageListActivity.ItemViewHolder)localObject2).jdField_b_of_type_AndroidWidgetTextView.setText(localMessageData.jdField_e_of_type_JavaLangString);
                ((StoryMessageListActivity.ItemViewHolder)localObject2).jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
                ((StoryMessageListActivity.ItemViewHolder)localObject2).c.setVisibility(8);
                ((StoryMessageListActivity.ItemViewHolder)localObject2).jdField_a_of_type_AndroidViewView.setVisibility(8);
                break label350;
              }
              if (localMessageData.jdField_a_of_type_Int == 7)
              {
                ((StoryMessageListActivity.ItemViewHolder)localObject2).jdField_b_of_type_AndroidWidgetTextView.setText(localMessageData.jdField_e_of_type_JavaLangString);
                ((StoryMessageListActivity.ItemViewHolder)localObject2).jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
                ((StoryMessageListActivity.ItemViewHolder)localObject2).c.setVisibility(8);
                ((StoryMessageListActivity.ItemViewHolder)localObject2).jdField_a_of_type_AndroidViewView.setVisibility(8);
                break label350;
              }
              if (localMessageData.jdField_a_of_type_Int == 8)
              {
                ((StoryMessageListActivity.ItemViewHolder)localObject2).jdField_b_of_type_AndroidWidgetTextView.setText(2131699789);
                ((StoryMessageListActivity.ItemViewHolder)localObject2).jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
                ((StoryMessageListActivity.ItemViewHolder)localObject2).c.setVisibility(8);
                ((StoryMessageListActivity.ItemViewHolder)localObject2).jdField_a_of_type_AndroidViewView.setVisibility(8);
                break label350;
              }
              if (localMessageData.jdField_a_of_type_Int == 9)
              {
                ((StoryMessageListActivity.ItemViewHolder)localObject2).jdField_b_of_type_AndroidWidgetTextView.setText(localMessageData.jdField_e_of_type_JavaLangString);
                ((StoryMessageListActivity.ItemViewHolder)localObject2).jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
                ((StoryMessageListActivity.ItemViewHolder)localObject2).c.setVisibility(8);
                ((StoryMessageListActivity.ItemViewHolder)localObject2).jdField_a_of_type_AndroidViewView.setVisibility(8);
                break label350;
              }
              if (localMessageData.jdField_a_of_type_Int == 10)
              {
                ((StoryMessageListActivity.ItemViewHolder)localObject2).jdField_b_of_type_AndroidWidgetTextView.setText(localMessageData.jdField_e_of_type_JavaLangString);
                ((StoryMessageListActivity.ItemViewHolder)localObject2).jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
                ((StoryMessageListActivity.ItemViewHolder)localObject2).c.setVisibility(8);
                ((StoryMessageListActivity.ItemViewHolder)localObject2).jdField_a_of_type_AndroidViewView.setVisibility(8);
                break label350;
              }
              if (localMessageData.jdField_a_of_type_Int == 11)
              {
                ((StoryMessageListActivity.ItemViewHolder)localObject2).jdField_b_of_type_AndroidWidgetTextView.setText(localMessageData.jdField_e_of_type_JavaLangString);
                ((StoryMessageListActivity.ItemViewHolder)localObject2).jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
                ((StoryMessageListActivity.ItemViewHolder)localObject2).c.setVisibility(8);
                ((StoryMessageListActivity.ItemViewHolder)localObject2).jdField_a_of_type_AndroidViewView.setVisibility(8);
                break label350;
              }
              if (localMessageData.jdField_a_of_type_Int == 18)
              {
                i = localMessageData.jdField_e_of_type_Int;
                localObject3 = null;
                if (i > 0) {
                  localObject3 = new SimpleDateFormat("HH:mm").format(Long.valueOf(i * 1000L));
                }
                if (TextUtils.isEmpty((CharSequence)localObject3)) {}
                for (localObject3 = HardCodeUtil.a(2131714401);; localObject3 = "@" + (String)localObject3 + HardCodeUtil.a(2131714398))
                {
                  ((StoryMessageListActivity.ItemViewHolder)localObject2).jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject3);
                  ((StoryMessageListActivity.ItemViewHolder)localObject2).jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
                  ((StoryMessageListActivity.ItemViewHolder)localObject2).c.setVisibility(8);
                  ((StoryMessageListActivity.ItemViewHolder)localObject2).jdField_a_of_type_AndroidViewView.setVisibility(8);
                  break;
                }
              }
              if (localMessageData.jdField_a_of_type_Int == 19)
              {
                if (localMessageData.g)
                {
                  ((StoryMessageListActivity.ItemViewHolder)localObject2).jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
                  ((StoryMessageListActivity.ItemViewHolder)localObject2).c.setVisibility(0);
                  ((StoryMessageListActivity.ItemViewHolder)localObject2).c.setText(HardCodeUtil.a(2131714397));
                }
                for (;;)
                {
                  ((StoryMessageListActivity.ItemViewHolder)localObject2).jdField_a_of_type_AndroidViewView.setVisibility(8);
                  break;
                  if (localMessageData.jdField_f_of_type_Boolean)
                  {
                    ((StoryMessageListActivity.ItemViewHolder)localObject2).jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
                    ((StoryMessageListActivity.ItemViewHolder)localObject2).c.setVisibility(0);
                    ((StoryMessageListActivity.ItemViewHolder)localObject2).c.setText(HardCodeUtil.a(2131714389));
                  }
                  else
                  {
                    ((StoryMessageListActivity.ItemViewHolder)localObject2).jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.b(localMessageData));
                    ((StoryMessageListActivity.ItemViewHolder)localObject2).jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
                    ((StoryMessageListActivity.ItemViewHolder)localObject2).c.setVisibility(8);
                  }
                }
              }
              ((StoryMessageListActivity.ItemViewHolder)localObject2).jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
              ((StoryMessageListActivity.ItemViewHolder)localObject2).c.setVisibility(8);
              ((StoryMessageListActivity.ItemViewHolder)localObject2).jdField_a_of_type_AndroidViewView.setVisibility(8);
              break label350;
              label1995:
              if (((localMessageData.jdField_f_of_type_Int == 99) || (localMessageData.jdField_f_of_type_Int == 104)) && (localMessageData.jdField_a_of_type_Int != 6) && (localMessageData.jdField_a_of_type_Int != 9))
              {
                ((StoryMessageListActivity.ItemViewHolder)localObject2).e.setText(localMessageData.k);
                ((StoryMessageListActivity.ItemViewHolder)localObject2).e.setVisibility(0);
                ((StoryMessageListActivity.ItemViewHolder)localObject2).f.setVisibility(8);
                break label422;
              }
              if (((localMessageData.jdField_a_of_type_Int == 13) || (localMessageData.jdField_a_of_type_Int == 14) || (localMessageData.jdField_a_of_type_Int == 16) || (localMessageData.jdField_a_of_type_Int == 17)) && (!TextUtils.isEmpty(localMessageData.p)))
              {
                if ("QQ好友".equals(localMessageData.p)) {
                  ((StoryMessageListActivity.ItemViewHolder)localObject2).e.setVisibility(8);
                }
                for (;;)
                {
                  ((StoryMessageListActivity.ItemViewHolder)localObject2).f.setVisibility(8);
                  break;
                  ((StoryMessageListActivity.ItemViewHolder)localObject2).e.setText(localMessageData.p);
                  ((StoryMessageListActivity.ItemViewHolder)localObject2).e.setVisibility(0);
                }
              }
              ((StoryMessageListActivity.ItemViewHolder)localObject2).e.setVisibility(8);
              ((StoryMessageListActivity.ItemViewHolder)localObject2).f.setVisibility(8);
            }
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ((StoryMessageListActivity.ItemViewHolder)localObject2).jdField_a_of_type_ComTencentBizQqstoryWidgetStoryCoverView.setImageDrawable((Drawable)localObject3);
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
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561860, paramViewGroup, false);
      localObject1 = new StoryMessageListActivity.FooterViewHolder(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity, paramView);
      paramView.setTag(localObject1);
      label2271:
      switch (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.jdField_b_of_type_Int)
      {
      }
    }
    for (;;)
    {
      ((StoryMessageListActivity.FooterViewHolder)localObject1).a(paramInt);
      localObject1 = paramView;
      break;
      localObject1 = (StoryMessageListActivity.FooterViewHolder)paramView.getTag();
      break label2271;
      if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.jdField_b_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.jdField_b_of_type_Boolean = false;
        ((StoryMessageListActivity.FooterViewHolder)localObject1).jdField_b_of_type_AndroidViewView.setVisibility(8);
        ((StoryMessageListActivity.FooterViewHolder)localObject1).jdField_a_of_type_AndroidViewView.setVisibility(0);
        ((StoryMessageListActivity.FooterViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        ((StoryMessageListActivity.FooterViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText(2131699774);
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqstory.msgList", 2, "list - load more");
        }
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.a();
      }
      else
      {
        ((StoryMessageListActivity.FooterViewHolder)localObject1).jdField_a_of_type_AndroidViewView.setVisibility(8);
        ((StoryMessageListActivity.FooterViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        ((StoryMessageListActivity.FooterViewHolder)localObject1).jdField_b_of_type_AndroidViewView.setVisibility(0);
        QQStoryContext.a();
        bool = ThemeUtil.isInNightMode(QQStoryContext.a());
        localObject2 = ((StoryMessageListActivity.FooterViewHolder)localObject1).jdField_a_of_type_AndroidWidgetImageView;
        if (bool) {}
        for (i = 2130846861;; i = 2130846860)
        {
          ((ImageView)localObject2).setImageResource(i);
          break;
        }
        ((StoryMessageListActivity.FooterViewHolder)localObject1).jdField_a_of_type_AndroidViewView.setVisibility(0);
        ((StoryMessageListActivity.FooterViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText(2131699774);
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqstory.msgList", 2, "pull to load more");
        }
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.a();
        continue;
        if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.jdField_b_of_type_Boolean)
        {
          this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.jdField_b_of_type_Boolean = false;
          ((StoryMessageListActivity.FooterViewHolder)localObject1).jdField_a_of_type_AndroidViewView.setVisibility(0);
          ((StoryMessageListActivity.FooterViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText(2131699774);
          this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.a();
        }
        else
        {
          ((StoryMessageListActivity.FooterViewHolder)localObject1).jdField_a_of_type_AndroidViewView.setVisibility(8);
          ((StoryMessageListActivity.FooterViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131714385));
          continue;
          ((StoryMessageListActivity.FooterViewHolder)localObject1).jdField_a_of_type_AndroidViewView.setVisibility(0);
          ((StoryMessageListActivity.FooterViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText(2131699774);
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
    try
    {
      i = Integer.parseInt(String.valueOf(paramView.getTag(-1)));
      if (i == -1)
      {
        EventCollector.getInstance().onViewClicked(paramView);
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
        int i = -1;
        continue;
        switch (paramView.getId())
        {
        default: 
          break;
        case 2131371177: 
          this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.a(i);
          StoryReportor.a("play_video", "del_notice", 0, 0, new String[] { "", "", "", "" });
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.messagenotify.StoryMessageListActivity.StoryMessageListAdapter
 * JD-Core Version:    0.7.0.1
 */