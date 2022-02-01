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
  int[] a = URLDrawableDecodeHandler.b(UIUtils.a(this.d.getApplicationContext(), 50.0F), UIUtils.a(this.d.getApplicationContext(), 70.0F), UIUtils.a(this.d.getApplicationContext(), 3.0F));
  LayoutInflater b = LayoutInflater.from(BaseApplication.getContext());
  StoryMessageListActivity.StoryMessageListItemBuilder c = new StoryMessageListActivity.StoryMessageListItemBuilder();
  
  protected StoryMessageListActivity$StoryMessageListAdapter(StoryMessageListActivity paramStoryMessageListActivity) {}
  
  public boolean a(int paramInt)
  {
    return paramInt < this.d.a.size();
  }
  
  public MessageData b(int paramInt)
  {
    if (a(paramInt)) {
      return (MessageData)this.d.a.get(paramInt);
    }
    return null;
  }
  
  public int getCount()
  {
    int j = this.d.a.size();
    if ((this.d.l != 1) && (this.d.l != 3))
    {
      if (((this.d.l == 0) || (this.d.l == 2)) && (((j == 0) && (this.d.i != 2)) || ((!this.d.q) && (this.d.i == 2)))) {
        return j;
      }
    }
    else
    {
      i = j;
      if (j == 0) {
        return i;
      }
      if (this.d.i == 2) {
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
        localObject1 = this.b.inflate(2131628089, paramViewGroup, false);
        localObject2 = new StoryMessageListActivity.ItemViewHolder(this.d, (View)localObject1);
        localObject1 = this.c.createView(this.d, (View)localObject1, (SwipRightMenuBuilder.SwipItemBaseHolder)localObject2, -1);
        ((View)localObject1).setTag(localObject2);
      }
      else
      {
        localObject2 = (StoryMessageListActivity.ItemViewHolder)paramView.getTag();
        localObject1 = paramView;
      }
      localMessageData = b(paramInt);
      if (localMessageData != null)
      {
        localObject3 = localMessageData.c;
        if ((localObject3 != null) && (!((String)localObject3).equals(((StoryMessageListActivity.ItemViewHolder)localObject2).a)))
        {
          localObject4 = ((UserManager)SuperManager.a(2)).b((String)localObject3);
          if (localObject4 != null)
          {
            ((StoryMessageListActivity.ItemViewHolder)localObject2).a = ((String)localObject3);
            if (((localMessageData.d == 14) || (localMessageData.d == 13) || (localMessageData.d == 16) || (localMessageData.d == 17)) && (QQUserUIItem.isNotDovUser(String.valueOf(localMessageData.u)))) {
              ((QQUserUIItem)localObject4).qq = String.valueOf(localMessageData.u);
            }
          }
          else
          {
            ((StoryMessageListActivity.ItemViewHolder)localObject2).a = null;
          }
          if (localMessageData.t == 4) {
            bool = true;
          } else {
            bool = false;
          }
          Resources localResources = this.d.getResources();
          ImageView localImageView = ((StoryMessageListActivity.ItemViewHolder)localObject2).b;
          float f1 = 50;
          TextView localTextView = ((StoryMessageListActivity.ItemViewHolder)localObject2).e;
          float f2 = 13;
          float f3 = 5;
          if (bool) {
            localObject3 = String.valueOf(localMessageData.u);
          } else {
            localObject3 = null;
          }
          PlayModeUtils.a(localResources, (QQUserUIItem)localObject4, localImageView, f1, localTextView, f2, f3, bool, (String)localObject3);
        }
        if (localMessageData.d == 1)
        {
          ((StoryMessageListActivity.ItemViewHolder)localObject2).f.setVisibility(8);
          ((StoryMessageListActivity.ItemViewHolder)localObject2).g.setVisibility(8);
          ((StoryMessageListActivity.ItemViewHolder)localObject2).h.setVisibility(0);
        }
        else if ((localMessageData.d != 2) && (localMessageData.d != 3))
        {
          if (localMessageData.d == 4)
          {
            ((StoryMessageListActivity.ItemViewHolder)localObject2).f.setText(HardCodeUtil.a(2131911831));
            ((StoryMessageListActivity.ItemViewHolder)localObject2).f.setVisibility(0);
            if (localMessageData.e)
            {
              ((StoryMessageListActivity.ItemViewHolder)localObject2).g.setVisibility(0);
              ((StoryMessageListActivity.ItemViewHolder)localObject2).g.setText(HardCodeUtil.a(2131911817));
            }
            else
            {
              ((StoryMessageListActivity.ItemViewHolder)localObject2).g.setVisibility(8);
            }
            ((StoryMessageListActivity.ItemViewHolder)localObject2).h.setVisibility(8);
          }
          else if (localMessageData.d == 12)
          {
            ((StoryMessageListActivity.ItemViewHolder)localObject2).f.setText(this.d.c(localMessageData));
            ((StoryMessageListActivity.ItemViewHolder)localObject2).f.setVisibility(0);
            if (localMessageData.e)
            {
              ((StoryMessageListActivity.ItemViewHolder)localObject2).g.setVisibility(0);
              ((StoryMessageListActivity.ItemViewHolder)localObject2).g.setText(HardCodeUtil.a(2131911818));
            }
            else
            {
              ((StoryMessageListActivity.ItemViewHolder)localObject2).g.setVisibility(8);
            }
            ((StoryMessageListActivity.ItemViewHolder)localObject2).h.setVisibility(8);
          }
          else if ((localMessageData.d != 14) && (localMessageData.d != 13))
          {
            if (localMessageData.d == 15)
            {
              ((StoryMessageListActivity.ItemViewHolder)localObject2).f.setText(this.d.e(localMessageData));
              ((StoryMessageListActivity.ItemViewHolder)localObject2).f.setVisibility(0);
              if (localMessageData.e)
              {
                ((StoryMessageListActivity.ItemViewHolder)localObject2).g.setVisibility(0);
                ((StoryMessageListActivity.ItemViewHolder)localObject2).g.setText(HardCodeUtil.a(2131911840));
              }
              else
              {
                ((StoryMessageListActivity.ItemViewHolder)localObject2).g.setVisibility(8);
              }
              ((StoryMessageListActivity.ItemViewHolder)localObject2).h.setVisibility(8);
            }
            else if ((localMessageData.d != 16) && (localMessageData.d != 17))
            {
              if (localMessageData.d == 5)
              {
                ((StoryMessageListActivity.ItemViewHolder)localObject2).f.setText(localMessageData.z);
                ((StoryMessageListActivity.ItemViewHolder)localObject2).f.setVisibility(0);
                ((StoryMessageListActivity.ItemViewHolder)localObject2).g.setVisibility(8);
                ((StoryMessageListActivity.ItemViewHolder)localObject2).h.setVisibility(8);
              }
              else if (localMessageData.d == 6)
              {
                ((StoryMessageListActivity.ItemViewHolder)localObject2).f.setText(localMessageData.n);
                ((StoryMessageListActivity.ItemViewHolder)localObject2).f.setVisibility(0);
                ((StoryMessageListActivity.ItemViewHolder)localObject2).g.setVisibility(8);
                ((StoryMessageListActivity.ItemViewHolder)localObject2).h.setVisibility(8);
              }
              else if (localMessageData.d == 7)
              {
                ((StoryMessageListActivity.ItemViewHolder)localObject2).f.setText(localMessageData.n);
                ((StoryMessageListActivity.ItemViewHolder)localObject2).f.setVisibility(0);
                ((StoryMessageListActivity.ItemViewHolder)localObject2).g.setVisibility(8);
                ((StoryMessageListActivity.ItemViewHolder)localObject2).h.setVisibility(8);
              }
              else if (localMessageData.d == 8)
              {
                ((StoryMessageListActivity.ItemViewHolder)localObject2).f.setText(2131897983);
                ((StoryMessageListActivity.ItemViewHolder)localObject2).f.setVisibility(0);
                ((StoryMessageListActivity.ItemViewHolder)localObject2).g.setVisibility(8);
                ((StoryMessageListActivity.ItemViewHolder)localObject2).h.setVisibility(8);
              }
              else if (localMessageData.d == 9)
              {
                ((StoryMessageListActivity.ItemViewHolder)localObject2).f.setText(localMessageData.n);
                ((StoryMessageListActivity.ItemViewHolder)localObject2).f.setVisibility(0);
                ((StoryMessageListActivity.ItemViewHolder)localObject2).g.setVisibility(8);
                ((StoryMessageListActivity.ItemViewHolder)localObject2).h.setVisibility(8);
              }
              else if (localMessageData.d == 10)
              {
                ((StoryMessageListActivity.ItemViewHolder)localObject2).f.setText(localMessageData.n);
                ((StoryMessageListActivity.ItemViewHolder)localObject2).f.setVisibility(0);
                ((StoryMessageListActivity.ItemViewHolder)localObject2).g.setVisibility(8);
                ((StoryMessageListActivity.ItemViewHolder)localObject2).h.setVisibility(8);
              }
              else if (localMessageData.d == 11)
              {
                ((StoryMessageListActivity.ItemViewHolder)localObject2).f.setText(localMessageData.n);
                ((StoryMessageListActivity.ItemViewHolder)localObject2).f.setVisibility(0);
                ((StoryMessageListActivity.ItemViewHolder)localObject2).g.setVisibility(8);
                ((StoryMessageListActivity.ItemViewHolder)localObject2).h.setVisibility(8);
              }
              else if (localMessageData.d == 18)
              {
                i = localMessageData.s;
                if (i > 0) {
                  localObject3 = new SimpleDateFormat("HH:mm").format(Long.valueOf(i * 1000L));
                } else {
                  localObject3 = null;
                }
                if (TextUtils.isEmpty((CharSequence)localObject3))
                {
                  localObject3 = HardCodeUtil.a(2131911836);
                }
                else
                {
                  localObject4 = new StringBuilder();
                  ((StringBuilder)localObject4).append("@");
                  ((StringBuilder)localObject4).append((String)localObject3);
                  ((StringBuilder)localObject4).append(HardCodeUtil.a(2131911833));
                  localObject3 = ((StringBuilder)localObject4).toString();
                }
                ((StoryMessageListActivity.ItemViewHolder)localObject2).f.setText((CharSequence)localObject3);
                ((StoryMessageListActivity.ItemViewHolder)localObject2).f.setVisibility(0);
                ((StoryMessageListActivity.ItemViewHolder)localObject2).g.setVisibility(8);
                ((StoryMessageListActivity.ItemViewHolder)localObject2).h.setVisibility(8);
              }
              else if (localMessageData.d == 19)
              {
                if (localMessageData.N)
                {
                  ((StoryMessageListActivity.ItemViewHolder)localObject2).f.setVisibility(8);
                  ((StoryMessageListActivity.ItemViewHolder)localObject2).g.setVisibility(0);
                  ((StoryMessageListActivity.ItemViewHolder)localObject2).g.setText(HardCodeUtil.a(2131911832));
                }
                else if (localMessageData.M)
                {
                  ((StoryMessageListActivity.ItemViewHolder)localObject2).f.setVisibility(8);
                  ((StoryMessageListActivity.ItemViewHolder)localObject2).g.setVisibility(0);
                  ((StoryMessageListActivity.ItemViewHolder)localObject2).g.setText(HardCodeUtil.a(2131911824));
                }
                else
                {
                  ((StoryMessageListActivity.ItemViewHolder)localObject2).f.setText(this.d.b(localMessageData));
                  ((StoryMessageListActivity.ItemViewHolder)localObject2).f.setVisibility(0);
                  ((StoryMessageListActivity.ItemViewHolder)localObject2).g.setVisibility(8);
                }
                ((StoryMessageListActivity.ItemViewHolder)localObject2).h.setVisibility(8);
              }
              else
              {
                ((StoryMessageListActivity.ItemViewHolder)localObject2).f.setVisibility(8);
                ((StoryMessageListActivity.ItemViewHolder)localObject2).g.setVisibility(8);
                ((StoryMessageListActivity.ItemViewHolder)localObject2).h.setVisibility(8);
              }
            }
            else
            {
              ((StoryMessageListActivity.ItemViewHolder)localObject2).f.setText(this.d.f(localMessageData));
              ((StoryMessageListActivity.ItemViewHolder)localObject2).f.setVisibility(0);
              if (localMessageData.e)
              {
                ((StoryMessageListActivity.ItemViewHolder)localObject2).g.setVisibility(0);
                ((StoryMessageListActivity.ItemViewHolder)localObject2).g.setText(HardCodeUtil.a(2131911837));
              }
              else
              {
                ((StoryMessageListActivity.ItemViewHolder)localObject2).g.setVisibility(8);
              }
              ((StoryMessageListActivity.ItemViewHolder)localObject2).h.setVisibility(8);
            }
          }
          else
          {
            ((StoryMessageListActivity.ItemViewHolder)localObject2).f.setText(this.d.d(localMessageData));
            ((StoryMessageListActivity.ItemViewHolder)localObject2).f.setVisibility(0);
            if (localMessageData.e)
            {
              ((StoryMessageListActivity.ItemViewHolder)localObject2).g.setVisibility(0);
              ((StoryMessageListActivity.ItemViewHolder)localObject2).g.setText(HardCodeUtil.a(2131911819));
            }
            else
            {
              ((StoryMessageListActivity.ItemViewHolder)localObject2).g.setVisibility(8);
            }
            ((StoryMessageListActivity.ItemViewHolder)localObject2).h.setVisibility(8);
          }
        }
        else if (localMessageData.e)
        {
          ((StoryMessageListActivity.ItemViewHolder)localObject2).f.setVisibility(8);
          ((StoryMessageListActivity.ItemViewHolder)localObject2).g.setVisibility(0);
          ((StoryMessageListActivity.ItemViewHolder)localObject2).g.setText(HardCodeUtil.a(2131911839));
          ((StoryMessageListActivity.ItemViewHolder)localObject2).h.setVisibility(8);
        }
        else
        {
          ((StoryMessageListActivity.ItemViewHolder)localObject2).f.setText(this.d.a(localMessageData));
          ((StoryMessageListActivity.ItemViewHolder)localObject2).f.setVisibility(0);
          ((StoryMessageListActivity.ItemViewHolder)localObject2).g.setVisibility(8);
          ((StoryMessageListActivity.ItemViewHolder)localObject2).h.setVisibility(8);
        }
        ((StoryMessageListActivity.ItemViewHolder)localObject2).i.setText(localMessageData.a());
        if (localMessageData.t == 4)
        {
          localObject3 = ContactUtils.a(this.d.app, String.valueOf(localMessageData.u), true);
          ((StoryMessageListActivity.ItemViewHolder)localObject2).j.setText((CharSequence)localObject3);
          ((StoryMessageListActivity.ItemViewHolder)localObject2).j.setVisibility(0);
          ((StoryMessageListActivity.ItemViewHolder)localObject2).k.setVisibility(8);
        }
        else if (((localMessageData.t == 99) || (localMessageData.t == 104)) && (localMessageData.d != 6) && (localMessageData.d != 9))
        {
          ((StoryMessageListActivity.ItemViewHolder)localObject2).j.setText(localMessageData.A);
          ((StoryMessageListActivity.ItemViewHolder)localObject2).j.setVisibility(0);
          ((StoryMessageListActivity.ItemViewHolder)localObject2).k.setVisibility(8);
        }
        else if (((localMessageData.d == 13) || (localMessageData.d == 14) || (localMessageData.d == 16) || (localMessageData.d == 17)) && (!TextUtils.isEmpty(localMessageData.G)))
        {
          if ("QQ好友".equals(localMessageData.G))
          {
            ((StoryMessageListActivity.ItemViewHolder)localObject2).j.setVisibility(8);
          }
          else
          {
            ((StoryMessageListActivity.ItemViewHolder)localObject2).j.setText(localMessageData.G);
            ((StoryMessageListActivity.ItemViewHolder)localObject2).j.setVisibility(0);
          }
          ((StoryMessageListActivity.ItemViewHolder)localObject2).k.setVisibility(8);
        }
        else
        {
          ((StoryMessageListActivity.ItemViewHolder)localObject2).j.setVisibility(8);
          ((StoryMessageListActivity.ItemViewHolder)localObject2).k.setVisibility(8);
        }
        if ((!TextUtils.isEmpty(localMessageData.b())) && (!localMessageData.b().equals(((StoryMessageListActivity.ItemViewHolder)localObject2).c)))
        {
          ((StoryMessageListActivity.ItemViewHolder)localObject2).c = localMessageData.b();
          localObject3 = this.d.getResources().getDrawable(2130848669);
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
      ((URLDrawable)localObject4).setTag(this.a);
      ((URLDrawable)localObject4).setDecodeHandler(URLDrawableDecodeHandler.j);
      ((StoryMessageListActivity.ItemViewHolder)localObject2).d.setImageDrawable((Drawable)localObject4);
    }
    catch (Exception localException)
    {
      label2087:
      break label2087;
    }
    ((StoryMessageListActivity.ItemViewHolder)localObject2).d.setImageDrawable((Drawable)localObject3);
    if (localMessageData.a != null) {
      ((StoryMessageListActivity.ItemViewHolder)localObject2).d.setPollLayout(localMessageData.a, -1, null);
    }
    if (localMessageData.b != null) {
      ((StoryMessageListActivity.ItemViewHolder)localObject2).d.setRateLayout(localMessageData.b, -1, -1L, -1);
    }
    Object localObject3 = ((StoryMessageListActivity.ItemViewHolder)localObject2).l;
    if ((paramInt == this.d.a.size() - 1) && (getCount() != this.d.a.size())) {
      i = 8;
    } else {
      i = 0;
    }
    ((View)localObject3).setVisibility(i);
    this.c.updateRightMenuView(this.d, (View)localObject1, paramInt, localMessageData, (SwipRightMenuBuilder.SwipItemBaseHolder)localObject2, this);
    ((StoryMessageListActivity.ItemViewHolder)localObject2).a(paramInt);
    break label2629;
    if (paramView == null)
    {
      paramView = this.b.inflate(2131628090, paramViewGroup, false);
      localObject1 = new StoryMessageListActivity.FooterViewHolder(this.d, paramView);
      paramView.setTag(localObject1);
    }
    else
    {
      localObject1 = (StoryMessageListActivity.FooterViewHolder)paramView.getTag();
    }
    int i = this.d.i;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i == 4)
          {
            ((StoryMessageListActivity.FooterViewHolder)localObject1).a.setVisibility(0);
            ((StoryMessageListActivity.FooterViewHolder)localObject1).b.setText(2131897968);
            if (QLog.isColorLevel()) {
              QLog.d("Q.qqstory.msgList", 2, "pull to load more");
            }
            this.d.a();
          }
        }
        else if (this.d.m)
        {
          this.d.m = false;
          ((StoryMessageListActivity.FooterViewHolder)localObject1).a.setVisibility(0);
          ((StoryMessageListActivity.FooterViewHolder)localObject1).b.setText(2131897968);
          this.d.a();
        }
        else
        {
          ((StoryMessageListActivity.FooterViewHolder)localObject1).a.setVisibility(8);
          ((StoryMessageListActivity.FooterViewHolder)localObject1).b.setText(HardCodeUtil.a(2131911820));
        }
      }
      else if (this.d.m)
      {
        this.d.m = false;
        ((StoryMessageListActivity.FooterViewHolder)localObject1).c.setVisibility(8);
        ((StoryMessageListActivity.FooterViewHolder)localObject1).a.setVisibility(0);
        ((StoryMessageListActivity.FooterViewHolder)localObject1).b.setVisibility(0);
        ((StoryMessageListActivity.FooterViewHolder)localObject1).b.setText(2131897968);
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqstory.msgList", 2, "list - load more");
        }
        this.d.a();
      }
      else
      {
        ((StoryMessageListActivity.FooterViewHolder)localObject1).a.setVisibility(8);
        ((StoryMessageListActivity.FooterViewHolder)localObject1).b.setVisibility(8);
        ((StoryMessageListActivity.FooterViewHolder)localObject1).c.setVisibility(0);
        QQStoryContext.a();
        bool = ThemeUtil.isInNightMode(QQStoryContext.k());
        localObject2 = ((StoryMessageListActivity.FooterViewHolder)localObject1).d;
        if (bool) {
          i = 2130848293;
        } else {
          i = 2130848292;
        }
        ((ImageView)localObject2).setImageResource(i);
      }
    }
    else
    {
      ((StoryMessageListActivity.FooterViewHolder)localObject1).a.setVisibility(0);
      ((StoryMessageListActivity.FooterViewHolder)localObject1).b.setText(2131897968);
    }
    ((StoryMessageListActivity.FooterViewHolder)localObject1).a(paramInt);
    Object localObject1 = paramView;
    label2629:
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
    if ((i != -1) && (paramView.getId() == 2131438111))
    {
      this.d.a(i);
      StoryReportor.a("play_video", "del_notice", 0, 0, new String[] { "", "", "", "" });
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.messagenotify.StoryMessageListActivity.StoryMessageListAdapter
 * JD-Core Version:    0.7.0.1
 */