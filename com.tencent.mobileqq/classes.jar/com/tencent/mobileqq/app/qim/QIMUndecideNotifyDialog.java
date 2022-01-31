package com.tencent.mobileqq.app.qim;

import android.app.Dialog;
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
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QIMNewFriendManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.QIMNotifyAddFriend;
import com.tencent.mobileqq.data.QIMNotifyAddFriend.VideoInfo;
import com.tencent.mobileqq.flashchat.FlashChatManager;
import com.tencent.mobileqq.flashchat.FlashChatManager.GlobalConfig;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.FaceDrawable;
import com.tencent.widget.ListView;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import mqq.app.MobileQQ;
import zso;
import zsp;
import zsq;

public class QIMUndecideNotifyDialog
  extends Dialog
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener
{
  int jdField_a_of_type_Int = 0;
  public View a;
  public BaseActivity a;
  public QIMNewFriendManager a;
  FlashChatManager jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatManager;
  ListView jdField_a_of_type_ComTencentWidgetListView;
  List jdField_a_of_type_JavaUtilList = new ArrayList();
  zsq jdField_a_of_type_Zsq;
  public List b = new LinkedList();
  
  public QIMUndecideNotifyDialog(@NonNull BaseActivity paramBaseActivity, @NonNull ArrayList paramArrayList)
  {
    super(paramBaseActivity, 2131624574);
    if ((paramArrayList == null) || (paramArrayList.size() < 1)) {
      throw new RuntimeException("empty data");
    }
    getWindow().setDimAmount(0.5F);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQIMNewFriendManager = ((QIMNewFriendManager)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getAppInterface().getManager(256));
    this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatManager = ((FlashChatManager)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getAppInterface().getManager(216));
    this.jdField_a_of_type_JavaUtilList.addAll(paramArrayList);
    this.b.addAll(this.jdField_a_of_type_JavaUtilList);
    if (this.jdField_a_of_type_JavaUtilList.size() == 1)
    {
      paramArrayList = b();
      ReportController.b(null, "dc00898", "", "", "0X8008A9E", "0X8008A9E", 0, 0, "", "", "", "");
      this.jdField_a_of_type_Int = 1;
      getWindow().getDecorView().setOnClickListener(this);
      setContentView(paramArrayList);
      paramBaseActivity = ((FlashChatManager)paramBaseActivity.app.getManager(216)).a.e;
      if (!TextUtils.isEmpty(paramBaseActivity))
      {
        paramArrayList = (ImageView)paramArrayList.findViewById(2131368868);
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mLoadingDrawable = new ColorDrawable(0);
        localURLDrawableOptions.mFailedDrawable = new ColorDrawable(0);
        paramBaseActivity = URLDrawable.getDrawable(paramBaseActivity, localURLDrawableOptions);
        if ((paramBaseActivity.getStatus() != 2) && (paramBaseActivity.getStatus() != 3)) {
          break label349;
        }
        paramBaseActivity.restartDownload();
      }
    }
    for (;;)
    {
      paramArrayList.setImageDrawable(paramBaseActivity);
      if (this.jdField_a_of_type_JavaUtilList.size() != 1) {
        a();
      }
      return;
      paramArrayList = a();
      ReportController.b(null, "dc00898", "", "", "0X8008AA1", "0X8008AA1", 0, 0, "", "", "", "");
      this.jdField_a_of_type_Int = 2;
      break;
      label349:
      paramBaseActivity.startDownload();
    }
  }
  
  private View a()
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    View localView = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).inflate(2130970061, null, false);
    localView.findViewById(2131368865).setOnClickListener(this);
    localView.findViewById(2131362850).setOnClickListener(this);
    TextView localTextView = (TextView)localView.findViewById(2131368867);
    String str = this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatManager.d();
    if (!TextUtils.isEmpty(str)) {
      localTextView.setText(str);
    }
    this.jdField_a_of_type_ComTencentWidgetListView = ((XListView)localView.findViewById(2131364021));
    this.jdField_a_of_type_ComTencentWidgetListView.setSelector(new ColorDrawable(0));
    this.jdField_a_of_type_Zsq = new zsq(this, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app);
    this.jdField_a_of_type_Zsq.a(localList);
    this.jdField_a_of_type_ComTencentWidgetListView.setAdapter(this.jdField_a_of_type_Zsq);
    ((Button)localView.findViewById(2131364058)).setOnClickListener(this);
    return localView;
  }
  
  private View b()
  {
    Object localObject1 = (QIMNotifyAddFriend)this.jdField_a_of_type_JavaUtilList.get(0);
    this.b.add(localObject1);
    RelativeLayout localRelativeLayout = (RelativeLayout)LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).inflate(2130970129, null, false);
    localRelativeLayout.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView = localRelativeLayout;
    Object localObject2 = localRelativeLayout.findViewById(2131369138);
    ((View)localObject2).setOnClickListener(this);
    Object localObject3 = (RelativeLayout.LayoutParams)((View)localObject2).getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject3).width = AIOUtils.a(286.0F, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources());
    ((RelativeLayout.LayoutParams)localObject3).height = -2;
    ((RelativeLayout.LayoutParams)localObject3).addRule(13);
    localObject3 = new PressDarkImageView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    ((PressDarkImageView)localObject3).setId(2131362850);
    ((PressDarkImageView)localObject3).setImageResource(2130843370);
    Object localObject4 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject4).addRule(3, 2131369138);
    ((RelativeLayout.LayoutParams)localObject4).addRule(14);
    ((RelativeLayout.LayoutParams)localObject4).topMargin = AIOUtils.a(28.0F, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources());
    localRelativeLayout.addView((View)localObject3, (ViewGroup.LayoutParams)localObject4);
    ((PressDarkImageView)localObject3).setOnClickListener(this);
    localObject3 = (TextView)((View)localObject2).findViewById(2131365315);
    localObject4 = this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatManager.d();
    if (!TextUtils.isEmpty((CharSequence)localObject4)) {
      ((TextView)localObject3).setText((CharSequence)localObject4);
    }
    localObject4 = (ImageView)((View)localObject2).findViewById(2131369139);
    Object localObject5 = (TextView)((View)localObject2).findViewById(2131369122);
    localObject3 = (TextView)((View)localObject2).findViewById(2131369142);
    ((View)localObject2).findViewById(2131364058).setOnClickListener(this);
    Object localObject6 = (TextView)((View)localObject2).findViewById(2131369140);
    ((TextView)localObject6).setTag(Long.valueOf(((QIMNotifyAddFriend)localObject1).uin));
    Object localObject7 = this.jdField_a_of_type_ComTencentMobileqqAppQIMNewFriendManager.a(((QIMNotifyAddFriend)localObject1).uin, ((QIMNotifyAddFriend)localObject1).qqUin);
    label409:
    int i;
    int j;
    int k;
    if (TextUtils.isEmpty((CharSequence)localObject7))
    {
      ((TextView)localObject6).setVisibility(8);
      ((ImageView)localObject4).setImageDrawable(FaceDrawable.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, String.valueOf(((QIMNotifyAddFriend)localObject1).uin), (byte)2));
      ((TextView)localObject5).setText(((QIMNotifyAddFriend)localObject1).nickName);
      localObject4 = ((QIMNotifyAddFriend)localObject1).wording;
      if (TextUtils.isEmpty((CharSequence)localObject4)) {
        break label666;
      }
      ((TextView)localObject3).setText((CharSequence)localObject4);
      i = ((QIMNotifyAddFriend)localObject1).videoInfos.size();
      if (i > 0)
      {
        localObject2 = (LinearLayout)((View)localObject2).findViewById(2131369141);
        ((LinearLayout)localObject2).setVisibility(0);
        if (i != 1) {
          break label684;
        }
        localObject3 = new ImageView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
        i = AIOUtils.a(128.0F, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources());
        j = AIOUtils.a(188.0F, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources());
        k = AIOUtils.a(4.0F, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources());
        localObject4 = new LinearLayout.LayoutParams(i, j);
        ((LinearLayout.LayoutParams)localObject4).rightMargin = k;
        localObject5 = URLDrawable.URLDrawableOptions.obtain();
        localObject6 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130838715);
        ((URLDrawable.URLDrawableOptions)localObject5).mFailedDrawable = ((Drawable)localObject6);
        ((URLDrawable.URLDrawableOptions)localObject5).mLoadingDrawable = ((Drawable)localObject6);
        localObject5 = URLDrawable.getDrawable(((QIMNotifyAddFriend.VideoInfo)((QIMNotifyAddFriend)localObject1).videoInfos.get(0)).coverUrl, (URLDrawable.URLDrawableOptions)localObject5);
        if ((((URLDrawable)localObject5).getStatus() != 2) && (((URLDrawable)localObject5).getStatus() != 3)) {
          break label676;
        }
        ((URLDrawable)localObject5).restartDownload();
      }
    }
    for (;;)
    {
      ((ImageView)localObject3).setImageDrawable((Drawable)localObject5);
      ((ImageView)localObject3).setOnClickListener(new zso(this, ((QIMNotifyAddFriend.VideoInfo)((QIMNotifyAddFriend)localObject1).videoInfos.get(0)).videoVid));
      ((LinearLayout)localObject2).addView((View)localObject3, (ViewGroup.LayoutParams)localObject4);
      return localRelativeLayout;
      ((TextView)localObject6).setVisibility(0);
      ((TextView)localObject6).setText((CharSequence)localObject7);
      break;
      label666:
      ((TextView)localObject3).setVisibility(8);
      break label409;
      label676:
      ((URLDrawable)localObject5).startDownload();
    }
    label684:
    localObject1 = ((QIMNotifyAddFriend)localObject1).videoInfos;
    if (((List)localObject1).size() > 3) {
      localObject1 = ((List)localObject1).subList(0, 3);
    }
    for (;;)
    {
      localObject3 = new ArrayList(3);
      i = 0;
      label725:
      if (i < ((List)localObject1).size())
      {
        localObject4 = (QIMNotifyAddFriend.VideoInfo)((List)localObject1).get(i);
        localObject5 = new URLImageView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
        j = AIOUtils.a(76.0F, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources());
        k = AIOUtils.a(122.0F, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources());
        int m = AIOUtils.a(4.0F, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources());
        localObject6 = new LinearLayout.LayoutParams(j, k);
        ((LinearLayout.LayoutParams)localObject6).rightMargin = m;
        localObject7 = URLDrawable.URLDrawableOptions.obtain();
        Drawable localDrawable = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130838715);
        ((URLDrawable.URLDrawableOptions)localObject7).mFailedDrawable = localDrawable;
        ((URLDrawable.URLDrawableOptions)localObject7).mLoadingDrawable = localDrawable;
        localObject7 = URLDrawable.getDrawable(((QIMNotifyAddFriend.VideoInfo)localObject4).coverUrl, (URLDrawable.URLDrawableOptions)localObject7);
        if ((((URLDrawable)localObject7).getStatus() != 2) && (((URLDrawable)localObject7).getStatus() != 3)) {
          break label942;
        }
        ((URLDrawable)localObject7).restartDownload();
      }
      for (;;)
      {
        ((URLImageView)localObject5).setImageDrawable((Drawable)localObject7);
        ((ArrayList)localObject3).add(((QIMNotifyAddFriend.VideoInfo)localObject4).videoVid);
        ((URLImageView)localObject5).setOnClickListener(new zsp(this, (ArrayList)localObject3, i));
        ((LinearLayout)localObject2).addView((View)localObject5, (ViewGroup.LayoutParams)localObject6);
        i += 1;
        break label725;
        break;
        label942:
        ((URLDrawable)localObject7).startDownload();
      }
    }
  }
  
  public void a()
  {
    Button localButton = (Button)getWindow().findViewById(2131364058);
    localButton.setOnClickListener(this);
    localButton.setText("OK（" + this.b.size() + "）");
    if (!this.b.isEmpty()) {}
    for (boolean bool = true;; bool = false)
    {
      localButton.setEnabled(bool);
      return;
    }
  }
  
  public boolean a(List paramList)
  {
    boolean bool = false;
    if (this.jdField_a_of_type_Zsq != null)
    {
      this.jdField_a_of_type_JavaUtilList.addAll(0, paramList);
      this.b.addAll(paramList);
      this.jdField_a_of_type_Zsq.a(this.jdField_a_of_type_JavaUtilList);
      a();
      bool = true;
    }
    return bool;
  }
  
  public void dismiss()
  {
    super.dismiss();
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    paramCompoundButton = paramCompoundButton.getTag();
    if ((paramCompoundButton instanceof QIMNotifyAddFriend))
    {
      paramCompoundButton = (QIMNotifyAddFriend)paramCompoundButton;
      if (!paramBoolean) {
        break label50;
      }
      if (!this.b.contains(paramCompoundButton)) {
        this.b.add(paramCompoundButton);
      }
    }
    for (;;)
    {
      a();
      return;
      label50:
      if (this.b.contains(paramCompoundButton)) {
        this.b.remove(paramCompoundButton);
      }
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      if ((this.jdField_a_of_type_AndroidViewView == paramView) || (paramView == getWindow().getDecorView())) {
        dismiss();
      }
    case 2131364058: 
      do
      {
        return;
        dismiss();
        ((FriendListHandler)((QQAppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null)).a(1)).a(this.b);
        this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatManager.a(getContext(), null);
        this.jdField_a_of_type_ComTencentMobileqqAppQIMNewFriendManager.a(this.b);
        if (this.jdField_a_of_type_Int == 1)
        {
          ReportController.b(null, "dc00898", "", "", "0X8008A9F", "0X8008A9F", 0, 0, "", "", "", "");
          return;
        }
      } while (this.jdField_a_of_type_Int != 2);
      ReportController.b(null, "dc00898", "", "", "0X8008AA2", "0X8008AA2", 0, 0, "", "", "", "");
      return;
    case 2131362850: 
      if (this.jdField_a_of_type_Int == 1) {
        ReportController.b(null, "dc00898", "", "", "0X8008AA0", "0X8008AA0", 0, 0, "", "", "", "");
      }
      for (;;)
      {
        dismiss();
        return;
        if (this.jdField_a_of_type_Int == 2) {
          ReportController.b(null, "dc00898", "", "", "0X8008AA3", "0X8008AA3", 0, 0, "", "", "", "");
        }
      }
    }
    dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.qim.QIMUndecideNotifyDialog
 * JD-Core Version:    0.7.0.1
 */