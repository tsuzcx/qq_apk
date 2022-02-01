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
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
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
    int j = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.a.size();
    if ((this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.jdField_c_of_type_Int != 1) && (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.jdField_c_of_type_Int != 3))
    {
      if (((this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.jdField_c_of_type_Int == 0) || (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.jdField_c_of_type_Int == 2)) && (((j == 0) && (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.jdField_b_of_type_Int != 2)) || ((!this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.jdField_b_of_type_Int == 2)))) {
        return j;
      }
    }
    else
    {
      i = j;
      if (j == 0) {
        return i;
      }
      if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.jdField_b_of_type_Int == 2) {
        return j;
      }
    }
    int i = j + 1;
    return i;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    return a(paramInt) ^ true;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject2;
    MessageData localMessageData;
    Object localObject4;
    boolean bool;
    if (a(paramInt))
    {
      if (paramView == null)
      {
        localObject1 = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561710, paramViewGroup, false);
        localObject2 = new StoryMessageListActivity.ItemViewHolder(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity, (View)localObject1);
        localObject1 = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity$StoryMessageListItemBuilder.createView(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity, (View)localObject1, (SwipRightMenuBuilder.SwipItemBaseHolder)localObject2, -1);
        ((View)localObject1).setTag(localObject2);
      }
      else
      {
        localObject2 = (StoryMessageListActivity.ItemViewHolder)paramView.getTag();
        localObject1 = paramView;
      }
      localMessageData = a(paramInt);
      if (localMessageData != null)
      {
        localObject3 = localMessageData.jdField_a_of_type_JavaLangString;
        if ((localObject3 != null) && (!((String)localObject3).equals(((StoryMessageListActivity.ItemViewHolder)localObject2).jdField_a_of_type_JavaLangString)))
        {
          localObject4 = ((UserManager)SuperManager.a(2)).b((String)localObject3);
          if (localObject4 != null)
          {
            ((StoryMessageListActivity.ItemViewHolder)localObject2).jdField_a_of_type_JavaLangString = ((String)localObject3);
            if (((localMessageData.jdField_a_of_type_Int == 14) || (localMessageData.jdField_a_of_type_Int == 13) || (localMessageData.jdField_a_of_type_Int == 16) || (localMessageData.jdField_a_of_type_Int == 17)) && (QQUserUIItem.isNotDovUser(String.valueOf(localMessageData.b)))) {
              ((QQUserUIItem)localObject4).qq = String.valueOf(localMessageData.b);
            }
          }
          else
          {
            ((StoryMessageListActivity.ItemViewHolder)localObject2).jdField_a_of_type_JavaLangString = null;
          }
          if (localMessageData.jdField_f_of_type_Int == 4) {
            bool = true;
          } else {
            bool = false;
          }
          Resources localResources = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.getResources();
          ImageView localImageView = ((StoryMessageListActivity.ItemViewHolder)localObject2).jdField_a_of_type_AndroidWidgetImageView;
          float f1 = 50;
          TextView localTextView = ((StoryMessageListActivity.ItemViewHolder)localObject2).jdField_a_of_type_AndroidWidgetTextView;
          float f2 = 13;
          float f3 = 5;
          if (bool) {
            localObject3 = String.valueOf(localMessageData.b);
          } else {
            localObject3 = null;
          }
          PlayModeUtils.a(localResources, (QQUserUIItem)localObject4, localImageView, f1, localTextView, f2, f3, bool, (String)localObject3);
        }
        if (localMessageData.jdField_a_of_type_Int == 1)
        {
          ((StoryMessageListActivity.ItemViewHolder)localObject2).jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
          ((StoryMessageListActivity.ItemViewHolder)localObject2).c.setVisibility(8);
          ((StoryMessageListActivity.ItemViewHolder)localObject2).jdField_a_of_type_AndroidViewView.setVisibility(0);
        }
        else if ((localMessageData.jdField_a_of_type_Int != 2) && (localMessageData.jdField_a_of_type_Int != 3))
        {
          if (localMessageData.jdField_a_of_type_Int == 4)
          {
            ((StoryMessageListActivity.ItemViewHolder)localObject2).jdField_b_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131714317));
            ((StoryMessageListActivity.ItemViewHolder)localObject2).jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
            if (localMessageData.jdField_a_of_type_Boolean)
            {
              ((StoryMessageListActivity.ItemViewHolder)localObject2).c.setVisibility(0);
              ((StoryMessageListActivity.ItemViewHolder)localObject2).c.setText(HardCodeUtil.a(2131714303));
            }
            else
            {
              ((StoryMessageListActivity.ItemViewHolder)localObject2).c.setVisibility(8);
            }
            ((StoryMessageListActivity.ItemViewHolder)localObject2).jdField_a_of_type_AndroidViewView.setVisibility(8);
          }
          else if (localMessageData.jdField_a_of_type_Int == 12)
          {
            ((StoryMessageListActivity.ItemViewHolder)localObject2).jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.c(localMessageData));
            ((StoryMessageListActivity.ItemViewHolder)localObject2).jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
            if (localMessageData.jdField_a_of_type_Boolean)
            {
              ((StoryMessageListActivity.ItemViewHolder)localObject2).c.setVisibility(0);
              ((StoryMessageListActivity.ItemViewHolder)localObject2).c.setText(HardCodeUtil.a(2131714304));
            }
            else
            {
              ((StoryMessageListActivity.ItemViewHolder)localObject2).c.setVisibility(8);
            }
            ((StoryMessageListActivity.ItemViewHolder)localObject2).jdField_a_of_type_AndroidViewView.setVisibility(8);
          }
          else if ((localMessageData.jdField_a_of_type_Int != 14) && (localMessageData.jdField_a_of_type_Int != 13))
          {
            if (localMessageData.jdField_a_of_type_Int == 15)
            {
              ((StoryMessageListActivity.ItemViewHolder)localObject2).jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.e(localMessageData));
              ((StoryMessageListActivity.ItemViewHolder)localObject2).jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
              if (localMessageData.jdField_a_of_type_Boolean)
              {
                ((StoryMessageListActivity.ItemViewHolder)localObject2).c.setVisibility(0);
                ((StoryMessageListActivity.ItemViewHolder)localObject2).c.setText(HardCodeUtil.a(2131714326));
              }
              else
              {
                ((StoryMessageListActivity.ItemViewHolder)localObject2).c.setVisibility(8);
              }
              ((StoryMessageListActivity.ItemViewHolder)localObject2).jdField_a_of_type_AndroidViewView.setVisibility(8);
            }
            else if ((localMessageData.jdField_a_of_type_Int != 16) && (localMessageData.jdField_a_of_type_Int != 17))
            {
              if (localMessageData.jdField_a_of_type_Int == 5)
              {
                ((StoryMessageListActivity.ItemViewHolder)localObject2).jdField_b_of_type_AndroidWidgetTextView.setText(localMessageData.j);
                ((StoryMessageListActivity.ItemViewHolder)localObject2).jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
                ((StoryMessageListActivity.ItemViewHolder)localObject2).c.setVisibility(8);
                ((StoryMessageListActivity.ItemViewHolder)localObject2).jdField_a_of_type_AndroidViewView.setVisibility(8);
              }
              else if (localMessageData.jdField_a_of_type_Int == 6)
              {
                ((StoryMessageListActivity.ItemViewHolder)localObject2).jdField_b_of_type_AndroidWidgetTextView.setText(localMessageData.jdField_e_of_type_JavaLangString);
                ((StoryMessageListActivity.ItemViewHolder)localObject2).jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
                ((StoryMessageListActivity.ItemViewHolder)localObject2).c.setVisibility(8);
                ((StoryMessageListActivity.ItemViewHolder)localObject2).jdField_a_of_type_AndroidViewView.setVisibility(8);
              }
              else if (localMessageData.jdField_a_of_type_Int == 7)
              {
                ((StoryMessageListActivity.ItemViewHolder)localObject2).jdField_b_of_type_AndroidWidgetTextView.setText(localMessageData.jdField_e_of_type_JavaLangString);
                ((StoryMessageListActivity.ItemViewHolder)localObject2).jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
                ((StoryMessageListActivity.ItemViewHolder)localObject2).c.setVisibility(8);
                ((StoryMessageListActivity.ItemViewHolder)localObject2).jdField_a_of_type_AndroidViewView.setVisibility(8);
              }
              else if (localMessageData.jdField_a_of_type_Int == 8)
              {
                ((StoryMessageListActivity.ItemViewHolder)localObject2).jdField_b_of_type_AndroidWidgetTextView.setText(2131699930);
                ((StoryMessageListActivity.ItemViewHolder)localObject2).jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
                ((StoryMessageListActivity.ItemViewHolder)localObject2).c.setVisibility(8);
                ((StoryMessageListActivity.ItemViewHolder)localObject2).jdField_a_of_type_AndroidViewView.setVisibility(8);
              }
              else if (localMessageData.jdField_a_of_type_Int == 9)
              {
                ((StoryMessageListActivity.ItemViewHolder)localObject2).jdField_b_of_type_AndroidWidgetTextView.setText(localMessageData.jdField_e_of_type_JavaLangString);
                ((StoryMessageListActivity.ItemViewHolder)localObject2).jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
                ((StoryMessageListActivity.ItemViewHolder)localObject2).c.setVisibility(8);
                ((StoryMessageListActivity.ItemViewHolder)localObject2).jdField_a_of_type_AndroidViewView.setVisibility(8);
              }
              else if (localMessageData.jdField_a_of_type_Int == 10)
              {
                ((StoryMessageListActivity.ItemViewHolder)localObject2).jdField_b_of_type_AndroidWidgetTextView.setText(localMessageData.jdField_e_of_type_JavaLangString);
                ((StoryMessageListActivity.ItemViewHolder)localObject2).jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
                ((StoryMessageListActivity.ItemViewHolder)localObject2).c.setVisibility(8);
                ((StoryMessageListActivity.ItemViewHolder)localObject2).jdField_a_of_type_AndroidViewView.setVisibility(8);
              }
              else if (localMessageData.jdField_a_of_type_Int == 11)
              {
                ((StoryMessageListActivity.ItemViewHolder)localObject2).jdField_b_of_type_AndroidWidgetTextView.setText(localMessageData.jdField_e_of_type_JavaLangString);
                ((StoryMessageListActivity.ItemViewHolder)localObject2).jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
                ((StoryMessageListActivity.ItemViewHolder)localObject2).c.setVisibility(8);
                ((StoryMessageListActivity.ItemViewHolder)localObject2).jdField_a_of_type_AndroidViewView.setVisibility(8);
              }
              else if (localMessageData.jdField_a_of_type_Int == 18)
              {
                i = localMessageData.jdField_e_of_type_Int;
                if (i > 0) {
                  localObject3 = new SimpleDateFormat("HH:mm").format(Long.valueOf(i * 1000L));
                } else {
                  localObject3 = null;
                }
                if (TextUtils.isEmpty((CharSequence)localObject3))
                {
                  localObject3 = HardCodeUtil.a(2131714322);
                }
                else
                {
                  localObject4 = new StringBuilder();
                  ((StringBuilder)localObject4).append("@");
                  ((StringBuilder)localObject4).append((String)localObject3);
                  ((StringBuilder)localObject4).append(HardCodeUtil.a(2131714319));
                  localObject3 = ((StringBuilder)localObject4).toString();
                }
                ((StoryMessageListActivity.ItemViewHolder)localObject2).jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject3);
                ((StoryMessageListActivity.ItemViewHolder)localObject2).jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
                ((StoryMessageListActivity.ItemViewHolder)localObject2).c.setVisibility(8);
                ((StoryMessageListActivity.ItemViewHolder)localObject2).jdField_a_of_type_AndroidViewView.setVisibility(8);
              }
              else if (localMessageData.jdField_a_of_type_Int == 19)
              {
                if (localMessageData.g)
                {
                  ((StoryMessageListActivity.ItemViewHolder)localObject2).jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
                  ((StoryMessageListActivity.ItemViewHolder)localObject2).c.setVisibility(0);
                  ((StoryMessageListActivity.ItemViewHolder)localObject2).c.setText(HardCodeUtil.a(2131714318));
                }
                else if (localMessageData.jdField_f_of_type_Boolean)
                {
                  ((StoryMessageListActivity.ItemViewHolder)localObject2).jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
                  ((StoryMessageListActivity.ItemViewHolder)localObject2).c.setVisibility(0);
                  ((StoryMessageListActivity.ItemViewHolder)localObject2).c.setText(HardCodeUtil.a(2131714310));
                }
                else
                {
                  ((StoryMessageListActivity.ItemViewHolder)localObject2).jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.b(localMessageData));
                  ((StoryMessageListActivity.ItemViewHolder)localObject2).jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
                  ((StoryMessageListActivity.ItemViewHolder)localObject2).c.setVisibility(8);
                }
                ((StoryMessageListActivity.ItemViewHolder)localObject2).jdField_a_of_type_AndroidViewView.setVisibility(8);
              }
              else
              {
                ((StoryMessageListActivity.ItemViewHolder)localObject2).jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
                ((StoryMessageListActivity.ItemViewHolder)localObject2).c.setVisibility(8);
                ((StoryMessageListActivity.ItemViewHolder)localObject2).jdField_a_of_type_AndroidViewView.setVisibility(8);
              }
            }
            else
            {
              ((StoryMessageListActivity.ItemViewHolder)localObject2).jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.f(localMessageData));
              ((StoryMessageListActivity.ItemViewHolder)localObject2).jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
              if (localMessageData.jdField_a_of_type_Boolean)
              {
                ((StoryMessageListActivity.ItemViewHolder)localObject2).c.setVisibility(0);
                ((StoryMessageListActivity.ItemViewHolder)localObject2).c.setText(HardCodeUtil.a(2131714323));
              }
              else
              {
                ((StoryMessageListActivity.ItemViewHolder)localObject2).c.setVisibility(8);
              }
              ((StoryMessageListActivity.ItemViewHolder)localObject2).jdField_a_of_type_AndroidViewView.setVisibility(8);
            }
          }
          else
          {
            ((StoryMessageListActivity.ItemViewHolder)localObject2).jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.d(localMessageData));
            ((StoryMessageListActivity.ItemViewHolder)localObject2).jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
            if (localMessageData.jdField_a_of_type_Boolean)
            {
              ((StoryMessageListActivity.ItemViewHolder)localObject2).c.setVisibility(0);
              ((StoryMessageListActivity.ItemViewHolder)localObject2).c.setText(HardCodeUtil.a(2131714305));
            }
            else
            {
              ((StoryMessageListActivity.ItemViewHolder)localObject2).c.setVisibility(8);
            }
            ((StoryMessageListActivity.ItemViewHolder)localObject2).jdField_a_of_type_AndroidViewView.setVisibility(8);
          }
        }
        else if (localMessageData.jdField_a_of_type_Boolean)
        {
          ((StoryMessageListActivity.ItemViewHolder)localObject2).jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
          ((StoryMessageListActivity.ItemViewHolder)localObject2).c.setVisibility(0);
          ((StoryMessageListActivity.ItemViewHolder)localObject2).c.setText(HardCodeUtil.a(2131714325));
          ((StoryMessageListActivity.ItemViewHolder)localObject2).jdField_a_of_type_AndroidViewView.setVisibility(8);
        }
        else
        {
          ((StoryMessageListActivity.ItemViewHolder)localObject2).jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.a(localMessageData));
          ((StoryMessageListActivity.ItemViewHolder)localObject2).jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
          ((StoryMessageListActivity.ItemViewHolder)localObject2).c.setVisibility(8);
          ((StoryMessageListActivity.ItemViewHolder)localObject2).jdField_a_of_type_AndroidViewView.setVisibility(8);
        }
        ((StoryMessageListActivity.ItemViewHolder)localObject2).d.setText(localMessageData.a());
        if (localMessageData.jdField_f_of_type_Int == 4)
        {
          localObject3 = ContactUtils.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.app, String.valueOf(localMessageData.b), true);
          ((StoryMessageListActivity.ItemViewHolder)localObject2).e.setText((CharSequence)localObject3);
          ((StoryMessageListActivity.ItemViewHolder)localObject2).e.setVisibility(0);
          ((StoryMessageListActivity.ItemViewHolder)localObject2).f.setVisibility(8);
        }
        else if (((localMessageData.jdField_f_of_type_Int == 99) || (localMessageData.jdField_f_of_type_Int == 104)) && (localMessageData.jdField_a_of_type_Int != 6) && (localMessageData.jdField_a_of_type_Int != 9))
        {
          ((StoryMessageListActivity.ItemViewHolder)localObject2).e.setText(localMessageData.k);
          ((StoryMessageListActivity.ItemViewHolder)localObject2).e.setVisibility(0);
          ((StoryMessageListActivity.ItemViewHolder)localObject2).f.setVisibility(8);
        }
        else if (((localMessageData.jdField_a_of_type_Int == 13) || (localMessageData.jdField_a_of_type_Int == 14) || (localMessageData.jdField_a_of_type_Int == 16) || (localMessageData.jdField_a_of_type_Int == 17)) && (!TextUtils.isEmpty(localMessageData.p)))
        {
          if ("QQ好友".equals(localMessageData.p))
          {
            ((StoryMessageListActivity.ItemViewHolder)localObject2).e.setVisibility(8);
          }
          else
          {
            ((StoryMessageListActivity.ItemViewHolder)localObject2).e.setText(localMessageData.p);
            ((StoryMessageListActivity.ItemViewHolder)localObject2).e.setVisibility(0);
          }
          ((StoryMessageListActivity.ItemViewHolder)localObject2).f.setVisibility(8);
        }
        else
        {
          ((StoryMessageListActivity.ItemViewHolder)localObject2).e.setVisibility(8);
          ((StoryMessageListActivity.ItemViewHolder)localObject2).f.setVisibility(8);
        }
        if ((!TextUtils.isEmpty(localMessageData.b())) && (!localMessageData.b().equals(((StoryMessageListActivity.ItemViewHolder)localObject2).jdField_b_of_type_JavaLangString)))
        {
          ((StoryMessageListActivity.ItemViewHolder)localObject2).jdField_b_of_type_JavaLangString = localMessageData.b();
          localObject3 = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.getResources().getDrawable(2130847117);
        }
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
      ((URLDrawable)localObject4).setDecodeHandler(URLDrawableDecodeHandler.i);
      ((StoryMessageListActivity.ItemViewHolder)localObject2).jdField_a_of_type_ComTencentBizQqstoryWidgetStoryCoverView.setImageDrawable((Drawable)localObject4);
    }
    catch (Exception localException)
    {
      label2085:
      break label2085;
    }
    ((StoryMessageListActivity.ItemViewHolder)localObject2).jdField_a_of_type_ComTencentBizQqstoryWidgetStoryCoverView.setImageDrawable((Drawable)localObject3);
    if (localMessageData.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem$PollLayout != null) {
      ((StoryMessageListActivity.ItemViewHolder)localObject2).jdField_a_of_type_ComTencentBizQqstoryWidgetStoryCoverView.setPollLayout(localMessageData.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem$PollLayout, -1, null);
    }
    if (localMessageData.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem$InteractPasterLayout != null) {
      ((StoryMessageListActivity.ItemViewHolder)localObject2).jdField_a_of_type_ComTencentBizQqstoryWidgetStoryCoverView.setRateLayout(localMessageData.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem$InteractPasterLayout, -1, -1L, -1);
    }
    Object localObject3 = ((StoryMessageListActivity.ItemViewHolder)localObject2).jdField_b_of_type_AndroidViewView;
    if ((paramInt == this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.a.size() - 1) && (getCount() != this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.a.size())) {
      i = 8;
    } else {
      i = 0;
    }
    ((View)localObject3).setVisibility(i);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity$StoryMessageListItemBuilder.updateRightMenuView(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity, (View)localObject1, paramInt, localMessageData, (SwipRightMenuBuilder.SwipItemBaseHolder)localObject2, this);
    ((StoryMessageListActivity.ItemViewHolder)localObject2).a(paramInt);
    break label2627;
    if (paramView == null)
    {
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561711, paramViewGroup, false);
      localObject1 = new StoryMessageListActivity.FooterViewHolder(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity, paramView);
      paramView.setTag(localObject1);
    }
    else
    {
      localObject1 = (StoryMessageListActivity.FooterViewHolder)paramView.getTag();
    }
    int i = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.jdField_b_of_type_Int;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i == 4)
          {
            ((StoryMessageListActivity.FooterViewHolder)localObject1).jdField_a_of_type_AndroidViewView.setVisibility(0);
            ((StoryMessageListActivity.FooterViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText(2131699915);
            if (QLog.isColorLevel()) {
              QLog.d("Q.qqstory.msgList", 2, "pull to load more");
            }
            this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.a();
          }
        }
        else if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.jdField_b_of_type_Boolean)
        {
          this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.jdField_b_of_type_Boolean = false;
          ((StoryMessageListActivity.FooterViewHolder)localObject1).jdField_a_of_type_AndroidViewView.setVisibility(0);
          ((StoryMessageListActivity.FooterViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText(2131699915);
          this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.a();
        }
        else
        {
          ((StoryMessageListActivity.FooterViewHolder)localObject1).jdField_a_of_type_AndroidViewView.setVisibility(8);
          ((StoryMessageListActivity.FooterViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131714306));
        }
      }
      else if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.jdField_b_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.jdField_b_of_type_Boolean = false;
        ((StoryMessageListActivity.FooterViewHolder)localObject1).jdField_b_of_type_AndroidViewView.setVisibility(8);
        ((StoryMessageListActivity.FooterViewHolder)localObject1).jdField_a_of_type_AndroidViewView.setVisibility(0);
        ((StoryMessageListActivity.FooterViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        ((StoryMessageListActivity.FooterViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText(2131699915);
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
        if (bool) {
          i = 2130846741;
        } else {
          i = 2130846740;
        }
        ((ImageView)localObject2).setImageResource(i);
      }
    }
    else
    {
      ((StoryMessageListActivity.FooterViewHolder)localObject1).jdField_a_of_type_AndroidViewView.setVisibility(0);
      ((StoryMessageListActivity.FooterViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText(2131699915);
    }
    ((StoryMessageListActivity.FooterViewHolder)localObject1).a(paramInt);
    Object localObject1 = paramView;
    label2627:
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return localObject1;
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
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.qqstory.msgList", 2, localException, new Object[0]);
      }
      i = -1;
    }
    if ((i != -1) && (paramView.getId() == 2131370801))
    {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.a(i);
      StoryReportor.a("play_video", "del_notice", 0, 0, new String[] { "", "", "", "" });
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.messagenotify.StoryMessageListActivity.StoryMessageListAdapter
 * JD-Core Version:    0.7.0.1
 */