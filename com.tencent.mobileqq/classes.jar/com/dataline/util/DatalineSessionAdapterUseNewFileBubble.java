package com.dataline.util;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.dataline.activities.LiteActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.ChatBackground;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;
import com.tencent.mobileqq.data.DataLineMsgSetList;
import com.tencent.mobileqq.drawable.ChatBackgroundDrawable;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.troop.widget.EllipsizingTextView;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.mobileqq.widget.CircleFileStateView;
import com.tencent.util.VersionUtils;
import com.tencent.widget.XPanelContainer;

public class DatalineSessionAdapterUseNewFileBubble
  extends DatalineSessionAdapter
{
  private View.OnClickListener b = new DatalineSessionAdapterUseNewFileBubble.1(this);
  private View.OnClickListener c = new DatalineSessionAdapterUseNewFileBubble.2(this);
  
  public DatalineSessionAdapterUseNewFileBubble(Context paramContext, DataLineMsgSetList paramDataLineMsgSetList, LiteActivity paramLiteActivity, QQAppInterface paramQQAppInterface)
  {
    super(paramContext, paramDataLineMsgSetList, paramLiteActivity, paramQQAppInterface);
  }
  
  private void a(View paramView, ItemHolder paramItemHolder)
  {
    paramView = (RelativeLayout)paramView.findViewById(2131372789);
    ImageView localImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    localImageView.setImageResource(2130838392);
    localImageView.setId(2131364653);
    paramItemHolder.a().jdField_a_of_type_AndroidWidgetImageView = localImageView;
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(13);
    paramView.addView(localImageView, localLayoutParams);
    localImageView.setVisibility(8);
    localImageView.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getString(2131692335));
    localImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    localImageView.setImageResource(2130838387);
    localImageView.setId(2131364640);
    paramItemHolder.a().jdField_b_of_type_AndroidWidgetImageView = localImageView;
    paramItemHolder = new RelativeLayout.LayoutParams(-2, -2);
    paramItemHolder.addRule(13);
    paramView.addView(localImageView, paramItemHolder);
    localImageView.setVisibility(8);
    localImageView.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getString(2131692776));
  }
  
  private void a(DataLineMsgRecord paramDataLineMsgRecord, ItemHolder paramItemHolder)
  {
    String str = "";
    if (paramDataLineMsgRecord.isSendFromLocal()) {
      if ((paramDataLineMsgRecord.progress == 1.0F) && (paramDataLineMsgRecord.issuc)) {
        str = " / " + this.jdField_a_of_type_AndroidContentContext.getString(2131692425);
      }
    }
    while (!TextUtils.isEmpty(str))
    {
      paramItemHolder.a().c.setVisibility(0);
      paramItemHolder.a().c.setText(str);
      return;
      if (paramDataLineMsgRecord.fileMsgStatus == 2L) {
        str = " / " + this.jdField_a_of_type_AndroidContentContext.getString(2131693800);
      } else if (paramDataLineMsgRecord.bIsTransfering) {
        str = "";
      } else if (!paramDataLineMsgRecord.issuc) {
        if ((paramDataLineMsgRecord.bIsSended) || (paramDataLineMsgRecord.nOpType == 1))
        {
          str = " / " + this.jdField_a_of_type_AndroidContentContext.getString(2131692423);
        }
        else
        {
          str = " / " + this.jdField_a_of_type_AndroidContentContext.getString(2131692424);
          continue;
          if ((paramDataLineMsgRecord.progress == 1.0F) && (paramDataLineMsgRecord.issuc)) {
            str = " / " + this.jdField_a_of_type_AndroidContentContext.getString(2131692417);
          } else if (paramDataLineMsgRecord.fileMsgStatus == 2L) {
            str = " / " + this.jdField_a_of_type_AndroidContentContext.getString(2131693800);
          } else if (paramDataLineMsgRecord.bIsTransfering) {
            str = "";
          } else if (!paramDataLineMsgRecord.issuc) {
            str = " / " + this.jdField_a_of_type_AndroidContentContext.getString(2131692423);
          }
        }
      }
    }
    paramItemHolder.a().c.setVisibility(8);
  }
  
  private void a(DataLineMsgSet paramDataLineMsgSet, ItemHolder paramItemHolder)
  {
    if (paramDataLineMsgSet.isSendFromLocal())
    {
      paramItemHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130850414);
      return;
    }
    paramItemHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130850238);
  }
  
  private boolean a(DataLineMsgRecord paramDataLineMsgRecord)
  {
    return (!TextUtils.isEmpty(paramDataLineMsgRecord.path)) && (FileUtil.a(paramDataLineMsgRecord.path));
  }
  
  private void b(View paramView, ItemHolder paramItemHolder)
  {
    paramView = (RelativeLayout)paramView.findViewById(2131372789);
    CircleFileStateView localCircleFileStateView = new CircleFileStateView(this.jdField_a_of_type_AndroidContentContext);
    localCircleFileStateView.setId(2131364638);
    localCircleFileStateView.setProgressRingWidth(0.0F);
    localCircleFileStateView.setCenterBgColor(-1);
    localCircleFileStateView.setState(2);
    paramItemHolder.a().jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView = localCircleFileStateView;
    int i = AIOUtils.a(24.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    paramView.addView(localCircleFileStateView, new RelativeLayout.LayoutParams(i, i));
    localCircleFileStateView.setVisibility(4);
    localCircleFileStateView.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getString(2131692418));
    localCircleFileStateView = new CircleFileStateView(this.jdField_a_of_type_AndroidContentContext);
    localCircleFileStateView.setId(2131364639);
    localCircleFileStateView.setProgressRingWidth(0.0F);
    localCircleFileStateView.setCenterBgColor(-1);
    localCircleFileStateView.setState(1);
    paramItemHolder.a().jdField_b_of_type_ComTencentMobileqqWidgetCircleFileStateView = localCircleFileStateView;
    paramView.addView(localCircleFileStateView, new RelativeLayout.LayoutParams(i, i));
    localCircleFileStateView.setVisibility(4);
    localCircleFileStateView.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getString(2131692621));
  }
  
  private void b(DataLineMsgRecord paramDataLineMsgRecord, ItemHolder paramItemHolder)
  {
    if ((paramDataLineMsgRecord.progress == 1.0F) || (!paramDataLineMsgRecord.issuc) || (paramDataLineMsgRecord.fileMsgStatus == 1L) || (paramDataLineMsgRecord.fileMsgStatus == 2L))
    {
      paramItemHolder.a().jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      i = AIOUtils.a(14.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      j = AIOUtils.a(18.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      if (paramDataLineMsgRecord.isSendFromLocal())
      {
        paramItemHolder.a().jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(i, i, j, i);
        return;
      }
      paramItemHolder.a().jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(j, i, i, i);
      return;
    }
    int i = (int)(paramDataLineMsgRecord.progress * 100.0F);
    paramItemHolder.a().jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    paramItemHolder.a().jdField_a_of_type_AndroidWidgetProgressBar.setProgress(i);
    paramItemHolder.a().jdField_a_of_type_AndroidWidgetProgressBar.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getString(2131692463) + i);
    i = AIOUtils.a(14.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    int j = AIOUtils.a(18.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    if (paramDataLineMsgRecord.isSendFromLocal())
    {
      paramItemHolder.a().jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(i, i, j, 0);
      return;
    }
    paramItemHolder.a().jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(j, i, i, 0);
  }
  
  private void c(ItemHolder paramItemHolder, DataLineMsgSet paramDataLineMsgSet)
  {
    if (paramItemHolder == null) {}
    do
    {
      do
      {
        return;
      } while (paramDataLineMsgSet == null);
      paramDataLineMsgSet = paramDataLineMsgSet.getFirstItem();
    } while (paramDataLineMsgSet == null);
    Object localObject = paramDataLineMsgSet.filename;
    long l = paramDataLineMsgSet.filesize;
    a(paramItemHolder.a().jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, paramDataLineMsgSet);
    paramItemHolder.a().jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
    paramItemHolder.a().jdField_b_of_type_AndroidWidgetTextView.setText(FileUtil.a(l, this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().densityDpi));
    b(paramDataLineMsgSet, paramItemHolder);
    a(paramDataLineMsgSet, paramItemHolder);
    if (paramDataLineMsgSet.isSendFromLocal())
    {
      localObject = paramItemHolder.a().jdField_a_of_type_AndroidWidgetImageView;
      if (localObject != null) {
        ((ImageView)localObject).setVisibility(8);
      }
      localObject = paramItemHolder.a().jdField_b_of_type_AndroidWidgetImageView;
      if (localObject != null) {
        ((ImageView)localObject).setVisibility(8);
      }
      localObject = paramItemHolder.a().jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView;
      if (localObject != null) {
        ((CircleFileStateView)localObject).setVisibility(8);
      }
      localObject = paramItemHolder.a().jdField_b_of_type_ComTencentMobileqqWidgetCircleFileStateView;
      if (localObject != null) {
        ((CircleFileStateView)localObject).setVisibility(8);
      }
      if ((paramDataLineMsgSet.bIsSended) || (paramDataLineMsgSet.nOpType == 1)) {
        d(paramDataLineMsgSet, paramItemHolder);
      }
    }
    for (;;)
    {
      e(paramDataLineMsgSet, paramItemHolder);
      return;
      c(paramDataLineMsgSet, paramItemHolder);
      continue;
      d(paramDataLineMsgSet, paramItemHolder);
    }
  }
  
  private void c(DataLineMsgRecord paramDataLineMsgRecord, ItemHolder paramItemHolder)
  {
    ImageView localImageView1 = paramItemHolder.a().jdField_a_of_type_AndroidWidgetImageView;
    ImageView localImageView2 = paramItemHolder.a().jdField_b_of_type_AndroidWidgetImageView;
    if ((localImageView1 == null) || (localImageView2 == null)) {
      return;
    }
    if ((paramDataLineMsgRecord.progress == 1.0F) && (paramDataLineMsgRecord.issuc))
    {
      localImageView1.setVisibility(8);
      localImageView2.setVisibility(8);
    }
    for (;;)
    {
      localImageView1.setTag(paramItemHolder);
      localImageView2.setTag(paramItemHolder);
      localImageView1.setOnClickListener(this.b);
      localImageView2.setOnClickListener(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.jdField_a_of_type_AndroidViewView$OnClickListener);
      return;
      if (paramDataLineMsgRecord.fileMsgStatus == 2L)
      {
        localImageView1.setVisibility(8);
        localImageView2.setVisibility(0);
      }
      else if (paramDataLineMsgRecord.bIsTransfering)
      {
        localImageView1.setVisibility(0);
        localImageView2.setVisibility(8);
      }
      else if (!paramDataLineMsgRecord.issuc)
      {
        localImageView1.setVisibility(8);
        localImageView2.setVisibility(0);
      }
      else
      {
        localImageView1.setVisibility(0);
        localImageView2.setVisibility(8);
      }
    }
  }
  
  private void d(DataLineMsgRecord paramDataLineMsgRecord, ItemHolder paramItemHolder)
  {
    CircleFileStateView localCircleFileStateView1 = paramItemHolder.a().jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView;
    CircleFileStateView localCircleFileStateView2 = paramItemHolder.a().jdField_b_of_type_ComTencentMobileqqWidgetCircleFileStateView;
    if ((localCircleFileStateView1 == null) || (localCircleFileStateView2 == null)) {
      return;
    }
    if ((paramDataLineMsgRecord.progress == 1.0F) && (paramDataLineMsgRecord.issuc))
    {
      localCircleFileStateView1.setVisibility(8);
      localCircleFileStateView2.setVisibility(8);
    }
    for (;;)
    {
      localCircleFileStateView1.setTag(paramItemHolder);
      localCircleFileStateView2.setTag(paramItemHolder);
      localCircleFileStateView1.setOnClickListener(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.b);
      localCircleFileStateView2.setOnClickListener(this.c);
      return;
      if (paramDataLineMsgRecord.fileMsgStatus == 2L)
      {
        localCircleFileStateView1.setVisibility(0);
        localCircleFileStateView1.setState(2);
        localCircleFileStateView2.setVisibility(8);
      }
      else if (paramDataLineMsgRecord.fileMsgStatus == 1L)
      {
        localCircleFileStateView1.setVisibility(0);
        localCircleFileStateView1.setState(2);
        localCircleFileStateView2.setVisibility(8);
      }
      else if (paramDataLineMsgRecord.bIsTransfering)
      {
        localCircleFileStateView1.setVisibility(8);
        localCircleFileStateView2.setVisibility(0);
      }
      else if (!paramDataLineMsgRecord.issuc)
      {
        localCircleFileStateView1.setVisibility(0);
        localCircleFileStateView1.setState(2);
        localCircleFileStateView2.setVisibility(8);
      }
      else
      {
        localCircleFileStateView1.setVisibility(8);
        localCircleFileStateView2.setVisibility(0);
      }
    }
  }
  
  private void e(DataLineMsgRecord paramDataLineMsgRecord, ItemHolder paramItemHolder)
  {
    if ((paramDataLineMsgRecord.progress == 1.0F) && (paramDataLineMsgRecord.issuc) && (!a(paramDataLineMsgRecord)))
    {
      CircleFileStateView localCircleFileStateView1 = paramItemHolder.a().jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView;
      CircleFileStateView localCircleFileStateView2 = paramItemHolder.a().jdField_b_of_type_ComTencentMobileqqWidgetCircleFileStateView;
      localCircleFileStateView1.setVisibility(0);
      localCircleFileStateView1.setState(2);
      localCircleFileStateView2.setVisibility(8);
      if (!paramDataLineMsgRecord.isSendFromLocal()) {
        paramItemHolder.a().c.setVisibility(8);
      }
      localCircleFileStateView1.setTag(paramItemHolder);
      localCircleFileStateView2.setTag(paramItemHolder);
      localCircleFileStateView1.setOnClickListener(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.b);
      localCircleFileStateView2.setOnClickListener(this.c);
    }
  }
  
  protected View a(int paramInt, ItemHolder paramItemHolder, DataLineMsgSet paramDataLineMsgSet)
  {
    Object localObject1;
    Object localObject3;
    Object localObject2;
    int i;
    if (paramInt == 17)
    {
      localObject1 = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559122, null);
      localObject3 = (ImageView)((View)localObject1).findViewById(2131368603);
      localObject2 = this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.getResources().getDrawable(2130844376);
      i = DataLineMsgRecord.getDevTypeBySet(paramDataLineMsgSet);
      if (i == 0)
      {
        paramDataLineMsgSet = this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.getResources().getDrawable(2130844376);
        ((ImageView)localObject3).setImageDrawable(paramDataLineMsgSet);
      }
    }
    for (paramDataLineMsgSet = (DataLineMsgSet)localObject1;; paramDataLineMsgSet = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559123, null))
    {
      paramItemHolder.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramDataLineMsgSet.findViewById(2131371935));
      paramItemHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(paramItemHolder);
      paramItemHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setClickable(true);
      paramItemHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setLongClickable(true);
      paramItemHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      paramItemHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnLongClickListener(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.jdField_a_of_type_AndroidViewView$OnLongClickListener);
      paramItemHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnTouchListener(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.jdField_a_of_type_AndroidViewView$OnTouchListener);
      paramItemHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setAddStatesFromChildren(true);
      paramItemHolder.a((TextView)paramDataLineMsgSet.findViewById(2131365578));
      i = AIOUtils.a(14.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      int j = AIOUtils.a(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      localObject1 = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      ((RelativeLayout)localObject1).setId(2131364634);
      localObject2 = this.jdField_a_of_type_AndroidContentContext.getResources();
      ((RelativeLayout)localObject1).setPadding(((Resources)localObject2).getDimensionPixelSize(2131296401), ((Resources)localObject2).getDimensionPixelSize(2131296403), ((Resources)localObject2).getDimensionPixelSize(2131296400), ((Resources)localObject2).getDimensionPixelSize(2131296402));
      localObject3 = new RelativeLayout.LayoutParams(BaseChatItemLayout.z, -2);
      int k = ((Resources)localObject2).getDimensionPixelSize(2131299067);
      ((RelativeLayout.LayoutParams)localObject3).setMargins(k, 0, k, 0);
      ((RelativeLayout.LayoutParams)localObject3).addRule(1, 2131368603);
      ((RelativeLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject3);
      localObject2 = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
      ((LinearLayout)localObject2).setMinimumHeight(AIOUtils.a(76.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      ((LinearLayout)localObject2).setOrientation(1);
      localObject3 = new RelativeLayout.LayoutParams(-1, -2);
      ((RelativeLayout.LayoutParams)localObject3).addRule(10, 2131364634);
      ((RelativeLayout)localObject1).addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
      localObject3 = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      ((RelativeLayout)localObject3).setId(2131366944);
      Object localObject4 = new LinearLayout.LayoutParams(-1, -2);
      ((RelativeLayout)localObject3).setPadding(i, i, i, 0);
      ((LinearLayout)localObject2).addView((View)localObject3, (ViewGroup.LayoutParams)localObject4);
      paramItemHolder.a().jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localObject3);
      k = AIOUtils.a(48.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      localObject4 = new AsyncImageView(this.jdField_a_of_type_AndroidContentContext);
      ((AsyncImageView)localObject4).setWidth(k);
      ((AsyncImageView)localObject4).setHeight(k);
      ((AsyncImageView)localObject4).setId(2131364601);
      ((AsyncImageView)localObject4).setScaleType(ImageView.ScaleType.CENTER_CROP);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(k, k);
      localLayoutParams.addRule(11);
      localLayoutParams.addRule(10);
      localLayoutParams.setMargins(i, 0, 0, 0);
      ((RelativeLayout)localObject3).addView((View)localObject4, localLayoutParams);
      paramItemHolder.a().jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)localObject4);
      localObject4 = new EllipsizingTextView(this.jdField_a_of_type_AndroidContentContext, null);
      ((TextView)localObject4).setId(2131364603);
      ((TextView)localObject4).setGravity(48);
      ((TextView)localObject4).setIncludeFontPadding(false);
      ((TextView)localObject4).setLineSpacing(0.0F, 1.0F);
      ((TextView)localObject4).setEllipsize(TextUtils.TruncateAt.MIDDLE);
      ((TextView)localObject4).setTextSize(1, 17.0F);
      ((TextView)localObject4).setMaxLines(2);
      ((TextView)localObject4).setTextColor(Color.parseColor("#03081a"));
      localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
      localLayoutParams.addRule(0, 2131364601);
      localLayoutParams.addRule(9);
      localLayoutParams.addRule(10);
      ((RelativeLayout)localObject3).addView((View)localObject4, localLayoutParams);
      paramItemHolder.a().jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject4);
      localObject4 = new TextView(this.jdField_a_of_type_AndroidContentContext);
      ((TextView)localObject4).setId(2131364600);
      ((TextView)localObject4).setSingleLine();
      if (VersionUtils.e()) {
        ((TextView)localObject4).setAlpha(0.75F);
      }
      ((TextView)localObject4).setGravity(17);
      ((TextView)localObject4).setTextColor(Color.parseColor("#777777"));
      ((TextView)localObject4).setTextSize(1, 12.0F);
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(9);
      localLayoutParams.addRule(3, 2131364603);
      localLayoutParams.setMargins(0, j, 0, 0);
      ((RelativeLayout)localObject3).addView((View)localObject4, localLayoutParams);
      paramItemHolder.a().jdField_b_of_type_AndroidWidgetTextView = ((TextView)localObject4);
      localObject4 = new TextView(this.jdField_a_of_type_AndroidContentContext);
      ((TextView)localObject4).setId(2131364605);
      ((TextView)localObject4).setSingleLine();
      if (VersionUtils.e()) {
        ((TextView)localObject4).setAlpha(0.75F);
      }
      ((TextView)localObject4).setGravity(17);
      ((TextView)localObject4).setTextColor(Color.parseColor("#777777"));
      ((TextView)localObject4).setTextSize(1, 12.0F);
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(1, 2131364600);
      localLayoutParams.addRule(8, 2131364600);
      localLayoutParams.setMargins(0, j, 0, 0);
      ((RelativeLayout)localObject3).addView((View)localObject4, localLayoutParams);
      paramItemHolder.a().c = ((TextView)localObject4);
      localObject3 = new ProgressBar(this.jdField_a_of_type_AndroidContentContext, null, 16842872);
      ((ProgressBar)localObject3).setId(2131364604);
      ((ProgressBar)localObject3).setMax(100);
      ((ProgressBar)localObject3).setProgressDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838138));
      localObject4 = new LinearLayout.LayoutParams(-1, AIOUtils.a(2.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      ((LinearLayout.LayoutParams)localObject4).setMargins(i, j, i, j);
      ((LinearLayout)localObject2).addView((View)localObject3, (ViewGroup.LayoutParams)localObject4);
      paramItemHolder.a().jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)localObject3);
      paramItemHolder.a().jdField_a_of_type_AndroidViewView = ((View)localObject1);
      paramItemHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.addView((View)localObject1);
      if (paramInt != 18) {
        break label1132;
      }
      a(paramDataLineMsgSet, paramItemHolder);
      b(paramDataLineMsgSet, paramItemHolder);
      return paramDataLineMsgSet;
      paramDataLineMsgSet = (DataLineMsgSet)localObject2;
      if (i != 1) {
        break;
      }
      paramDataLineMsgSet = this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.getResources().getDrawable(2130844371);
      break;
    }
    label1132:
    b(paramDataLineMsgSet, paramItemHolder);
    return paramDataLineMsgSet;
  }
  
  protected void a(int paramInt, ItemHolder paramItemHolder, DataLineMsgSet paramDataLineMsgSet)
  {
    c(paramItemHolder, paramDataLineMsgSet);
    a(paramDataLineMsgSet, paramItemHolder);
    if (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
    {
      Object localObject = this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.jdField_a_of_type_ComTencentWidgetXPanelContainer.getTag(2131361806);
      if ((localObject != null) && ((localObject instanceof ChatBackgroundDrawable)))
      {
        localObject = (ChatBackgroundDrawable)localObject;
        if (localObject != null)
        {
          paramInt = ChatBackground.a(((ChatBackgroundDrawable)localObject).getBitmap());
          paramItemHolder.a().setTextColor(ColorStateList.valueOf(paramInt));
        }
      }
    }
    if (a(paramDataLineMsgSet.getMsgId()))
    {
      paramDataLineMsgSet = TimeFormatterUtils.a(this.jdField_a_of_type_AndroidContentContext, 3, paramDataLineMsgSet.getTime() * 1000L);
      paramItemHolder.a().setVisibility(0);
      paramItemHolder.a().setText(paramDataLineMsgSet);
      return;
    }
    paramItemHolder.a().setVisibility(8);
  }
  
  protected void a(DataLineMsgRecord paramDataLineMsgRecord, View paramView, float paramFloat)
  {
    super.a(paramDataLineMsgRecord, paramView, paramFloat);
    if ((paramDataLineMsgRecord == null) || (paramView == null)) {}
    do
    {
      return;
      float f = paramFloat;
      if (paramFloat < paramDataLineMsgRecord.progress) {
        f = paramDataLineMsgRecord.progress;
      }
      ProgressBar localProgressBar = (ProgressBar)paramView.findViewById(2131364604);
      if (localProgressBar != null)
      {
        localProgressBar.setVisibility(0);
        localProgressBar.setProgress((int)(100.0F * f));
      }
      paramView = (RelativeLayout)paramView.findViewById(2131366944);
    } while (paramView == null);
    int i = AIOUtils.a(14.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    int j = AIOUtils.a(18.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    if (paramDataLineMsgRecord.isSendFromLocal())
    {
      paramView.setPadding(i, i, j, 0);
      return;
    }
    paramView.setPadding(j, i, i, 0);
  }
  
  void a(AsyncImageView paramAsyncImageView, DataLineMsgRecord paramDataLineMsgRecord)
  {
    String str = FileUtil.a(paramDataLineMsgRecord.filename);
    if (TextUtils.isEmpty(str)) {
      paramAsyncImageView.setImageResource(2130844531);
    }
    int i;
    do
    {
      return;
      paramAsyncImageView.setDefaultImage(FileManagerUtil.b(str));
      if (FileManagerUtil.a(str) == 0)
      {
        str = paramDataLineMsgRecord.filename;
        if (FileUtils.b(paramDataLineMsgRecord.thumbPath)) {
          str = paramDataLineMsgRecord.thumbPath;
        }
        for (;;)
        {
          paramAsyncImageView.setAsyncImage(str);
          return;
          if (FileUtils.b(paramDataLineMsgRecord.path)) {
            str = paramDataLineMsgRecord.path;
          }
        }
      }
      i = FileManagerUtil.b(str);
    } while (i == 0);
    paramAsyncImageView.setImageResource(i);
  }
  
  protected boolean a(int paramInt)
  {
    return (paramInt == 17) || (paramInt == 18);
  }
  
  public int getItemViewType(int paramInt)
  {
    int i = super.getItemViewType(paramInt);
    if (i == 10) {
      paramInt = 18;
    }
    do
    {
      return paramInt;
      paramInt = i;
    } while (i != 3);
    return 17;
  }
  
  public int getViewTypeCount()
  {
    return super.getViewTypeCount() + 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.dataline.util.DatalineSessionAdapterUseNewFileBubble
 * JD-Core Version:    0.7.0.1
 */