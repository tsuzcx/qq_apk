package com.tencent.mobileqq.app.qim;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.qqstory.view.PressDarkImageView;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QIMNewFriendManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.data.QIMNotifyAddFriend;
import com.tencent.mobileqq.data.QIMNotifyAddFriend.VideoInfo;
import com.tencent.mobileqq.flashchat.FlashChatManager;
import com.tencent.mobileqq.flashchat.FlashChatManager.GlobalConfig;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.widget.ListView;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class QIMUndecideNotifyDialog
  extends ReportDialog
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener
{
  QBaseActivity a;
  List<QIMNotifyAddFriend> b = new ArrayList();
  List<QIMNotifyAddFriend> c = new LinkedList();
  QIMNewFriendManager d;
  FlashChatManager e;
  int f = 0;
  QIMUndecideNotifyDialog.MyListAdapter g;
  ListView h;
  public View i;
  
  public QIMUndecideNotifyDialog(@NonNull QBaseActivity paramQBaseActivity, @NonNull ArrayList<QIMNotifyAddFriend> paramArrayList)
  {
    super(paramQBaseActivity, 2131952034);
    if ((paramArrayList != null) && (paramArrayList.size() >= 1))
    {
      getWindow().setDimAmount(0.5F);
      this.a = paramQBaseActivity;
      this.d = ((QIMNewFriendManager)this.a.getAppRuntime().getManager(QQManagerFactory.QIM_NEW_FRIEND_MANAGER));
      this.e = ((FlashChatManager)this.a.getAppRuntime().getManager(QQManagerFactory.FLASH_CHAT_MANAGER));
      this.b.addAll(paramArrayList);
      this.c.addAll(this.b);
      if (this.b.size() == 1)
      {
        paramArrayList = c();
        ReportController.b(null, "dc00898", "", "", "0X8008A9E", "0X8008A9E", 0, 0, "", "", "", "");
        this.f = 1;
      }
      else
      {
        paramArrayList = b();
        ReportController.b(null, "dc00898", "", "", "0X8008AA1", "0X8008AA1", 0, 0, "", "", "", "");
        this.f = 2;
      }
      getWindow().getDecorView().setOnClickListener(this);
      setContentView(paramArrayList);
      paramQBaseActivity = ((FlashChatManager)paramQBaseActivity.getAppRuntime().getManager(QQManagerFactory.FLASH_CHAT_MANAGER)).c.e;
      if (!TextUtils.isEmpty(paramQBaseActivity))
      {
        paramArrayList = (ImageView)paramArrayList.findViewById(2131442054);
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mLoadingDrawable = new ColorDrawable(0);
        localURLDrawableOptions.mFailedDrawable = new ColorDrawable(0);
        paramQBaseActivity = URLDrawable.getDrawable(paramQBaseActivity, localURLDrawableOptions);
        if ((paramQBaseActivity.getStatus() != 2) && (paramQBaseActivity.getStatus() != 3)) {
          paramQBaseActivity.startDownload();
        } else {
          paramQBaseActivity.restartDownload();
        }
        paramArrayList.setImageDrawable(paramQBaseActivity);
      }
      if (this.b.size() != 1) {
        a();
      }
      return;
    }
    throw new RuntimeException("empty data");
  }
  
  private View b()
  {
    List localList = this.b;
    View localView = LayoutInflater.from(this.a).inflate(2131627187, null, false);
    localView.findViewById(2131436915).setOnClickListener(this);
    localView.findViewById(2131430806).setOnClickListener(this);
    Object localObject = (TextView)localView.findViewById(2131439270);
    String str = this.e.k();
    if (!TextUtils.isEmpty(str)) {
      ((TextView)localObject).setText(str);
    }
    this.h = ((XListView)localView.findViewById(2131437272));
    this.h.setSelector(new ColorDrawable(0));
    localObject = this.a;
    this.g = new QIMUndecideNotifyDialog.MyListAdapter(this, (Context)localObject, (QQAppInterface)((QBaseActivity)localObject).getAppRuntime());
    this.g.a(localList);
    this.h.setAdapter(this.g);
    ((Button)localView.findViewById(2131431218)).setOnClickListener(this);
    return localView;
  }
  
  private View c()
  {
    Object localObject1 = this.b;
    int j = 0;
    localObject1 = (QIMNotifyAddFriend)((List)localObject1).get(0);
    this.c.add(localObject1);
    RelativeLayout localRelativeLayout = (RelativeLayout)LayoutInflater.from(this.a).inflate(2131627208, null, false);
    localRelativeLayout.setOnClickListener(this);
    this.i = localRelativeLayout;
    Object localObject2 = localRelativeLayout.findViewById(2131431895);
    ((View)localObject2).setOnClickListener(this);
    Object localObject3 = (RelativeLayout.LayoutParams)((View)localObject2).getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject3).width = AIOUtils.b(286.0F, this.a.getResources());
    ((RelativeLayout.LayoutParams)localObject3).height = -2;
    ((RelativeLayout.LayoutParams)localObject3).addRule(13);
    localObject3 = new PressDarkImageView(this.a);
    ((PressDarkImageView)localObject3).setId(2131430806);
    ((PressDarkImageView)localObject3).setImageResource(2130848322);
    Object localObject4 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject4).addRule(3, 2131431895);
    ((RelativeLayout.LayoutParams)localObject4).addRule(14);
    ((RelativeLayout.LayoutParams)localObject4).topMargin = AIOUtils.b(28.0F, this.a.getResources());
    localRelativeLayout.addView((View)localObject3, (ViewGroup.LayoutParams)localObject4);
    ((PressDarkImageView)localObject3).setOnClickListener(this);
    localObject3 = (TextView)((View)localObject2).findViewById(2131431914);
    localObject4 = this.e.k();
    if (!TextUtils.isEmpty((CharSequence)localObject4)) {
      ((TextView)localObject3).setText((CharSequence)localObject4);
    }
    localObject4 = (ImageView)((View)localObject2).findViewById(2131432729);
    Object localObject5 = (TextView)((View)localObject2).findViewById(2131439303);
    localObject3 = (TextView)((View)localObject2).findViewById(2131431140);
    ((View)localObject2).findViewById(2131431218).setOnClickListener(this);
    Object localObject6 = (TextView)((View)localObject2).findViewById(2131444399);
    ((TextView)localObject6).setTag(Long.valueOf(((QIMNotifyAddFriend)localObject1).uin));
    Object localObject7 = this.d.a(((QIMNotifyAddFriend)localObject1).uin, ((QIMNotifyAddFriend)localObject1).qqUin);
    if (TextUtils.isEmpty((CharSequence)localObject7))
    {
      ((TextView)localObject6).setVisibility(8);
    }
    else
    {
      ((TextView)localObject6).setVisibility(0);
      ((TextView)localObject6).setText((CharSequence)localObject7);
    }
    ((ImageView)localObject4).setImageDrawable(FaceDrawable.getUserFaceDrawable((AppInterface)this.a.getAppRuntime(), String.valueOf(((QIMNotifyAddFriend)localObject1).uin), (byte)2));
    ((TextView)localObject5).setText(((QIMNotifyAddFriend)localObject1).nickName);
    localObject4 = ((QIMNotifyAddFriend)localObject1).wording;
    if (!TextUtils.isEmpty((CharSequence)localObject4)) {
      ((TextView)localObject3).setText((CharSequence)localObject4);
    } else {
      ((TextView)localObject3).setVisibility(8);
    }
    int k = ((QIMNotifyAddFriend)localObject1).videoInfos.size();
    if (k > 0)
    {
      localObject3 = (LinearLayout)((View)localObject2).findViewById(2131446403);
      ((LinearLayout)localObject3).setVisibility(0);
      int m;
      if (k == 1)
      {
        localObject2 = new ImageView(this.a);
        j = AIOUtils.b(128.0F, this.a.getResources());
        k = AIOUtils.b(188.0F, this.a.getResources());
        m = AIOUtils.b(4.0F, this.a.getResources());
        localObject4 = new LinearLayout.LayoutParams(j, k);
        ((LinearLayout.LayoutParams)localObject4).rightMargin = m;
        localObject5 = URLDrawable.URLDrawableOptions.obtain();
        localObject6 = this.a.getResources().getDrawable(2130839760);
        ((URLDrawable.URLDrawableOptions)localObject5).mFailedDrawable = ((Drawable)localObject6);
        ((URLDrawable.URLDrawableOptions)localObject5).mLoadingDrawable = ((Drawable)localObject6);
        localObject5 = URLDrawable.getDrawable(((QIMNotifyAddFriend.VideoInfo)((QIMNotifyAddFriend)localObject1).videoInfos.get(0)).coverUrl, (URLDrawable.URLDrawableOptions)localObject5);
        if ((((URLDrawable)localObject5).getStatus() != 2) && (((URLDrawable)localObject5).getStatus() != 3)) {
          ((URLDrawable)localObject5).startDownload();
        } else {
          ((URLDrawable)localObject5).restartDownload();
        }
        ((ImageView)localObject2).setImageDrawable((Drawable)localObject5);
        ((ImageView)localObject2).setOnClickListener(new QIMUndecideNotifyDialog.1(this, ((QIMNotifyAddFriend.VideoInfo)((QIMNotifyAddFriend)localObject1).videoInfos.get(0)).videoVid));
        ((LinearLayout)localObject3).addView((View)localObject2, (ViewGroup.LayoutParams)localObject4);
        return localRelativeLayout;
      }
      localObject2 = ((QIMNotifyAddFriend)localObject1).videoInfos;
      localObject1 = localObject2;
      if (((List)localObject2).size() > 3) {
        localObject1 = ((List)localObject2).subList(0, 3);
      }
      localObject2 = new ArrayList(3);
      while (j < ((List)localObject1).size())
      {
        localObject4 = (QIMNotifyAddFriend.VideoInfo)((List)localObject1).get(j);
        localObject5 = new URLImageView(this.a);
        k = AIOUtils.b(76.0F, this.a.getResources());
        m = AIOUtils.b(122.0F, this.a.getResources());
        int n = AIOUtils.b(4.0F, this.a.getResources());
        localObject6 = new LinearLayout.LayoutParams(k, m);
        ((LinearLayout.LayoutParams)localObject6).rightMargin = n;
        localObject7 = URLDrawable.URLDrawableOptions.obtain();
        Drawable localDrawable = this.a.getResources().getDrawable(2130839760);
        ((URLDrawable.URLDrawableOptions)localObject7).mFailedDrawable = localDrawable;
        ((URLDrawable.URLDrawableOptions)localObject7).mLoadingDrawable = localDrawable;
        localObject7 = URLDrawable.getDrawable(((QIMNotifyAddFriend.VideoInfo)localObject4).coverUrl, (URLDrawable.URLDrawableOptions)localObject7);
        if ((((URLDrawable)localObject7).getStatus() != 2) && (((URLDrawable)localObject7).getStatus() != 3)) {
          ((URLDrawable)localObject7).startDownload();
        } else {
          ((URLDrawable)localObject7).restartDownload();
        }
        ((URLImageView)localObject5).setImageDrawable((Drawable)localObject7);
        ((ArrayList)localObject2).add(((QIMNotifyAddFriend.VideoInfo)localObject4).videoVid);
        ((URLImageView)localObject5).setOnClickListener(new QIMUndecideNotifyDialog.2(this, (ArrayList)localObject2, (QIMNotifyAddFriend.VideoInfo)localObject4));
        ((LinearLayout)localObject3).addView((View)localObject5, (ViewGroup.LayoutParams)localObject6);
        j += 1;
      }
    }
    return localRelativeLayout;
  }
  
  public void a()
  {
    Button localButton = (Button)getWindow().findViewById(2131431218);
    localButton.setOnClickListener(this);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OK（");
    localStringBuilder.append(this.c.size());
    localStringBuilder.append("）");
    localButton.setText(localStringBuilder.toString());
    localButton.setEnabled(this.c.isEmpty() ^ true);
  }
  
  public boolean a(List<QIMNotifyAddFriend> paramList)
  {
    if (this.g != null)
    {
      this.b.addAll(0, paramList);
      this.c.addAll(paramList);
      this.g.a(this.b);
      a();
      return true;
    }
    return false;
  }
  
  public void dismiss()
  {
    super.dismiss();
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    Object localObject = paramCompoundButton.getTag();
    if ((localObject instanceof QIMNotifyAddFriend))
    {
      localObject = (QIMNotifyAddFriend)localObject;
      if (paramBoolean)
      {
        if (!this.c.contains(localObject)) {
          this.c.add(localObject);
        }
      }
      else if (this.c.contains(localObject)) {
        this.c.remove(localObject);
      }
    }
    a();
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
  
  public void onClick(View paramView)
  {
    int j = paramView.getId();
    if (j != 2131430806)
    {
      if (j != 2131431218)
      {
        if (j != 2131436915)
        {
          if ((this.i == paramView) || (paramView == getWindow().getDecorView())) {
            dismiss();
          }
        }
        else {
          dismiss();
        }
      }
      else
      {
        dismiss();
        ((FriendListHandler)((QQAppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null)).getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).addBatchQIMFriends(this.c);
        this.e.a(getContext(), null);
        this.d.a(this.c);
        j = this.f;
        if (j == 1) {
          ReportController.b(null, "dc00898", "", "", "0X8008A9F", "0X8008A9F", 0, 0, "", "", "", "");
        } else if (j == 2) {
          ReportController.b(null, "dc00898", "", "", "0X8008AA2", "0X8008AA2", 0, 0, "", "", "", "");
        }
      }
    }
    else
    {
      j = this.f;
      if (j == 1) {
        ReportController.b(null, "dc00898", "", "", "0X8008AA0", "0X8008AA0", 0, 0, "", "", "", "");
      } else if (j == 2) {
        ReportController.b(null, "dc00898", "", "", "0X8008AA3", "0X8008AA3", 0, 0, "", "", "", "");
      }
      dismiss();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.qim.QIMUndecideNotifyDialog
 * JD-Core Version:    0.7.0.1
 */