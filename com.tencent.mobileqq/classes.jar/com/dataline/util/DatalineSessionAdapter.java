package com.dataline.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.util.TypedValue;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.dataline.activities.LiteActivity;
import com.dataline.util.file.FileUtil;
import com.dataline.util.widget.AsyncImageView;
import com.rookery.translate.model.TransDiskCache;
import com.rookery.translate.model.Trans_entity;
import com.rookery.translate.model.TranslateCache;
import com.rookery.translate.util.LocaleUtil;
import com.tencent.image.URLImageView;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mm.vfs.VFSFile;
import com.tencent.mobileqq.activity.ChatTextSizeSettingActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.ChatBackground;
import com.tencent.mobileqq.activity.aio.item.AIOSendMask;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.DatalineMessageManager;
import com.tencent.mobileqq.app.proxy.DataLineMsgProxy;
import com.tencent.mobileqq.bubble.BubbleInfo;
import com.tencent.mobileqq.bubble.BubbleUtils;
import com.tencent.mobileqq.customviews.MessageProgressTextView;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;
import com.tencent.mobileqq.data.DataLineMsgSetList;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;
import com.tencent.mobileqq.filemanager.fileviewer.TroopFileDetailBrowserActivity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FilePathUtil;
import com.tencent.mobileqq.forward.ForwardFileOption;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.mobileqq.vas.font.api.FontManagerConstants;
import com.tencent.mobileqq.vas.svip.api.ISVIPHandler;
import com.tencent.mobileqq.vas.svip.api.SVIPHandlerConstants;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vas.theme.chatbg.ChatBackgroundDrawable;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ListView;
import com.tencent.widget.XPanelContainer;

public class DatalineSessionAdapter
  extends TimeAdapter
{
  private int jdField_a_of_type_Int = 0;
  protected Context a;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
  protected LayoutInflater a;
  protected View.OnClickListener a;
  protected LiteActivity a;
  protected QQAppInterface a;
  private DataLineMsgSetList jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList;
  private boolean jdField_a_of_type_Boolean = true;
  private int jdField_b_of_type_Int = 0;
  private Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable = null;
  private int c = -1;
  
  public DatalineSessionAdapter(Context paramContext, DataLineMsgSetList paramDataLineMsgSetList, LiteActivity paramLiteActivity, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new DatalineSessionAdapter.2(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList = paramDataLineMsgSetList;
    this.jdField_a_of_type_ComDatalineActivitiesLiteActivity = paramLiteActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.c = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.size();
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296826);
    this.jdField_b_of_type_Int = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296825);
    b();
  }
  
  private Drawable a(DataLineMsgRecord paramDataLineMsgRecord)
  {
    boolean bool = paramDataLineMsgRecord.isSendFromLocal();
    int i;
    if ((paramDataLineMsgRecord.msgtype != -2005) && (paramDataLineMsgRecord.msgtype != -2009)) {
      i = 0;
    } else {
      i = 1;
    }
    if (i == 0) {
      return null;
    }
    Object localObject = this.jdField_b_of_type_AndroidGraphicsDrawableDrawable;
    if (localObject != null)
    {
      Drawable localDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      paramDataLineMsgRecord = localDrawable;
      if (localDrawable != null) {}
    }
    else
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources();
      paramDataLineMsgRecord = ((Resources)localObject).getDrawable(2130850341);
      localObject = ((Resources)localObject).getDrawable(2130850165);
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDataLineMsgRecord;
      this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = ((Drawable)localObject);
    }
    if (!bool) {
      return localObject;
    }
    return paramDataLineMsgRecord;
  }
  
  private void a(View paramView, Drawable paramDrawable)
  {
    if (paramView == null) {
      return;
    }
    if (paramDrawable == null)
    {
      paramView.setBackgroundDrawable(null);
      return;
    }
    Rect localRect = new Rect();
    paramDrawable.getPadding(localRect);
    int i = paramView.getPaddingTop();
    int j = localRect.top;
    int k = paramView.getPaddingLeft();
    int m = localRect.left;
    int n = paramView.getPaddingRight();
    int i1 = localRect.right;
    int i2 = paramView.getPaddingBottom();
    int i3 = localRect.bottom;
    paramView.setBackgroundDrawable(paramDrawable);
    paramView.setPadding(k + m, i + j, n + i1, i2 + i3);
  }
  
  private void a(GridView paramGridView)
  {
    int i = (this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.getWindowManager().getDefaultDisplay().getWidth() - AIOUtils.b(147.0F, this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.getResources()) - 2) / 3;
    paramGridView.setNumColumns(3);
    paramGridView.setColumnWidth(i);
    paramGridView.setHorizontalSpacing(1);
    paramGridView.setSelector(new ColorDrawable(0));
    paramGridView.setTag(Integer.valueOf(i));
    paramGridView.setClickable(true);
    paramGridView.setLongClickable(true);
    paramGridView.setAddStatesFromChildren(true);
  }
  
  private void a(ItemHolder paramItemHolder, int paramInt1, int paramInt2)
  {
    try
    {
      localBitmap = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(this.jdField_a_of_type_AndroidContentContext.getResources(), 2130838027), paramInt1, paramInt2, false);
      localObject1 = ImageUtil.a(localBitmap, AIOUtils.b(12.0F, this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.getResources()));
      localObject2 = localObject1;
      if (localBitmap == null) {}
    }
    catch (OutOfMemoryError localOutOfMemoryError1)
    {
      Bitmap localBitmap;
      Object localObject1;
      Object localObject2;
      label61:
      label64:
      label67:
      break label64;
    }
    try
    {
      localBitmap.recycle();
      localObject2 = localObject1;
    }
    catch (OutOfMemoryError localOutOfMemoryError2)
    {
      break label61;
    }
    break label67;
    localObject1 = null;
    localObject2 = localObject1;
    if (QLog.isColorLevel())
    {
      QLog.e("DatalineSessionAdapter", 2, "DataLineSessionAdapter OOM");
      localObject2 = localObject1;
    }
    if (localObject2 != null)
    {
      localObject1 = new ClipDrawable(new BitmapDrawable(localObject2), 48, 2);
      paramItemHolder.a().jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setBackgroundDrawable((Drawable)localObject1);
      return;
    }
    paramItemHolder.a().jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setBackgroundDrawable(null);
  }
  
  private void a(DataLineMsgRecord paramDataLineMsgRecord)
  {
    paramDataLineMsgRecord = ForwardFileOption.a(paramDataLineMsgRecord.trans2Entity());
    paramDataLineMsgRecord.b(10006);
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext.getApplicationContext(), TroopFileDetailBrowserActivity.class);
    localIntent.putExtra("fileinfo", paramDataLineMsgRecord);
    localIntent.putExtra("removemementity", true);
    localIntent.putExtra("forward_from_troop_file", true);
    localIntent.putExtra("not_forward", true);
    this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.startActivityForResult(localIntent, 102);
  }
  
  private void a(DataLineMsgRecord paramDataLineMsgRecord, RelativeLayout paramRelativeLayout, ItemHolder paramItemHolder)
  {
    Object localObject;
    if ((paramDataLineMsgRecord.vipBubbleID == 100000L) && (paramDataLineMsgRecord.msgtype == -1000))
    {
      localObject = LocaleUtil.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext());
      localObject = TranslateCache.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext()).a(paramDataLineMsgRecord.msg, paramDataLineMsgRecord.msgId, (String)localObject);
      if ((localObject != null) && (((Trans_entity)localObject).a().booleanValue()) && (!paramDataLineMsgRecord.isSendFromLocal())) {
        paramItemHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo = BubbleUtils.a(100001, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext.getResources(), this);
      } else {
        paramItemHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo = BubbleUtils.a(100000, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext.getResources(), this);
      }
    }
    else
    {
      paramItemHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo = BubbleUtils.a(((ISVIPHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).a(paramDataLineMsgRecord), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext.getResources(), this);
    }
    if (paramItemHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo != null)
    {
      paramItemHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo.a(paramRelativeLayout, null);
      boolean bool;
      if (paramDataLineMsgRecord.msgtype != -1000) {
        bool = true;
      } else {
        bool = false;
      }
      int i = paramDataLineMsgRecord.vipBubbleDiyTextId;
      if (i <= 0) {
        SVIPHandlerConstants.b(paramDataLineMsgRecord.vipBubbleID);
      }
      paramItemHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramDataLineMsgRecord.isSendFromLocal(), true, bool, paramRelativeLayout, FontManagerConstants.getSenderUin(paramDataLineMsgRecord), i);
    }
    if ((paramDataLineMsgRecord.msgtype == -2005) || (paramDataLineMsgRecord.msgtype == -2009) || (paramDataLineMsgRecord.msgtype == -2009))
    {
      localObject = a(paramDataLineMsgRecord);
      if (localObject != null) {
        a(paramRelativeLayout, (Drawable)localObject);
      }
    }
    if (paramDataLineMsgRecord.msgtype == -2000) {
      a(paramRelativeLayout, null);
    }
    if (paramDataLineMsgRecord.msgtype == -1000) {
      a(paramItemHolder, paramRelativeLayout, paramDataLineMsgRecord, paramItemHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo);
    }
    a(paramRelativeLayout, paramDataLineMsgRecord);
  }
  
  private boolean a(ItemHolder paramItemHolder, DataLineMsgSet paramDataLineMsgSet)
  {
    if (paramItemHolder == null) {
      return true;
    }
    if (paramItemHolder.a().jdField_d_of_type_ComDatalineUtilWidgetAsyncImageView == null) {
      return false;
    }
    if (paramDataLineMsgSet == null) {
      return true;
    }
    int i = paramDataLineMsgSet.getCompletedCount();
    int j = paramDataLineMsgSet.getTotalCount();
    Object localObject = paramDataLineMsgSet.getFirstItem();
    if (localObject == null) {
      return false;
    }
    if ((paramDataLineMsgSet.getAt(0) != null) && (paramDataLineMsgSet.getAt(0).strMoloIconUrl != null)) {
      paramItemHolder.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setAsyncImage(paramDataLineMsgSet.getAt(0).strMoloIconUrl);
    } else {
      paramItemHolder.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setImageResource(2130844275);
    }
    if ((paramDataLineMsgSet.getTotalCount() >= 2) && (paramDataLineMsgSet.getAt(1) != null) && (paramDataLineMsgSet.getAt(1).strMoloIconUrl != null)) {
      paramItemHolder.a().jdField_b_of_type_ComDatalineUtilWidgetAsyncImageView.setAsyncImage(paramDataLineMsgSet.getAt(1).strMoloIconUrl);
    } else {
      paramItemHolder.a().jdField_b_of_type_ComDatalineUtilWidgetAsyncImageView.setImageResource(2130844275);
    }
    if ((paramDataLineMsgSet.getTotalCount() >= 3) && (paramDataLineMsgSet.getAt(2) != null) && (paramDataLineMsgSet.getAt(2).strMoloIconUrl != null)) {
      paramItemHolder.a().jdField_c_of_type_ComDatalineUtilWidgetAsyncImageView.setAsyncImage(paramDataLineMsgSet.getAt(2).strMoloIconUrl);
    } else {
      paramItemHolder.a().jdField_c_of_type_ComDatalineUtilWidgetAsyncImageView.setImageResource(2130844275);
    }
    if ((paramDataLineMsgSet.getTotalCount() >= 4) && (paramDataLineMsgSet.getAt(3) != null) && (paramDataLineMsgSet.getAt(3).strMoloIconUrl != null)) {
      paramItemHolder.a().jdField_d_of_type_ComDatalineUtilWidgetAsyncImageView.setAsyncImage(paramDataLineMsgSet.getAt(3).strMoloIconUrl);
    } else {
      paramItemHolder.a().jdField_d_of_type_ComDatalineUtilWidgetAsyncImageView.setImageResource(2130844275);
    }
    paramItemHolder.a().jdField_a_of_type_AndroidWidgetTextView.setText(FileManagerUtil.c(paramDataLineMsgSet.getFileNames()));
    if ((((DataLineMsgRecord)localObject).strMoloSource != null) && (((DataLineMsgRecord)localObject).strMoloSource.contains(this.jdField_a_of_type_AndroidContentContext.getString(2131693787))))
    {
      paramItemHolder.a().jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      paramItemHolder.a().jdField_a_of_type_AndroidWidgetTextView.setSingleLine(false);
      paramItemHolder.a().jdField_a_of_type_AndroidWidgetTextView.setMaxLines(2);
    }
    else
    {
      paramItemHolder.a().jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      paramItemHolder.a().jdField_b_of_type_AndroidWidgetTextView.setText(2131693688);
      paramItemHolder.a().jdField_a_of_type_AndroidWidgetTextView.setSingleLine(true);
    }
    paramItemHolder.a().jdField_c_of_type_AndroidWidgetTextView.setText(FileUtil.a(paramDataLineMsgSet.getFileTotalSize()));
    if ((((DataLineMsgRecord)localObject).strMoloSource != null) && (!((DataLineMsgRecord)localObject).strMoloSource.equals("")))
    {
      paramItemHolder.a().e.setText(((DataLineMsgRecord)localObject).strMoloSource);
      paramItemHolder.a().e.setVisibility(0);
      paramItemHolder.a().jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    }
    else
    {
      paramItemHolder.a().jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
    if ((((DataLineMsgRecord)localObject).strMoloSrcIconUrl != null) && (!((DataLineMsgRecord)localObject).strMoloSrcIconUrl.equals("")))
    {
      paramItemHolder.a().jdField_a_of_type_ComTencentImageURLImageView.setImageURL(((DataLineMsgRecord)localObject).strMoloSrcIconUrl);
      paramItemHolder.a().jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
    }
    else
    {
      paramItemHolder.a().jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
    }
    if (paramDataLineMsgSet.isCanceled())
    {
      paramItemHolder.a().jdField_d_of_type_AndroidWidgetTextView.setText(2131693753);
    }
    else if (paramDataLineMsgSet.isFileComing())
    {
      paramItemHolder.a().jdField_d_of_type_AndroidWidgetTextView.setText(2131692358);
    }
    else
    {
      StringBuilder localStringBuilder;
      if (i == j)
      {
        localObject = paramItemHolder.a().jdField_d_of_type_AndroidWidgetTextView;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(j);
        ((TextView)localObject).setText(localStringBuilder.toString());
      }
      else
      {
        localObject = paramItemHolder.a().jdField_d_of_type_AndroidWidgetTextView;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(i);
        localStringBuilder.append("/");
        localStringBuilder.append(j);
        ((TextView)localObject).setText(localStringBuilder.toString());
      }
    }
    if (((!paramDataLineMsgSet.hasSendingOrRecving()) && (!paramDataLineMsgSet.hasWaiting())) || (paramDataLineMsgSet.isFileComing()))
    {
      paramItemHolder.a().jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
      return true;
    }
    paramItemHolder.a().jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    paramItemHolder.a().jdField_a_of_type_AndroidWidgetProgressBar.setProgress((int)(paramDataLineMsgSet.getTotalProcess() * 100.0F));
    return true;
  }
  
  private void b(DataLineMsgRecord paramDataLineMsgRecord)
  {
    paramDataLineMsgRecord = ForwardFileOption.a(paramDataLineMsgRecord.trans2Entity());
    paramDataLineMsgRecord.b(10002);
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext.getApplicationContext(), FileBrowserActivity.class);
    localIntent.putExtra("fileinfo", paramDataLineMsgRecord);
    localIntent.putExtra("removemementity", true);
    localIntent.putExtra("not_forward", true);
    this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.startActivityForResult(localIntent, 102);
  }
  
  private boolean b()
  {
    DataLineMsgSetList localDataLineMsgSetList = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList;
    return (localDataLineMsgSetList == null) || (localDataLineMsgSetList.size() == 0);
  }
  
  private boolean b(ItemHolder paramItemHolder, DataLineMsgSet paramDataLineMsgSet)
  {
    if (paramItemHolder == null) {
      return true;
    }
    if (paramItemHolder.a().jdField_a_of_type_AndroidWidgetTextView == null) {
      return false;
    }
    if (paramDataLineMsgSet == null) {
      return true;
    }
    int j = paramDataLineMsgSet.getCompletedCount();
    int i = paramDataLineMsgSet.getTotalCount();
    DataLineMsgRecord localDataLineMsgRecord = paramDataLineMsgSet.getFirstItem();
    if (localDataLineMsgRecord == null) {
      return false;
    }
    StringBuilder localStringBuilder;
    if (j == i)
    {
      localObject = paramItemHolder.a().jdField_a_of_type_AndroidWidgetTextView;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(i);
      ((TextView)localObject).setText(localStringBuilder.toString());
    }
    else
    {
      localObject = paramItemHolder.a().jdField_a_of_type_AndroidWidgetTextView;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(j);
      localStringBuilder.append("/");
      localStringBuilder.append(i);
      ((TextView)localObject).setText(localStringBuilder.toString());
    }
    j = ((Integer)paramItemHolder.a().jdField_a_of_type_AndroidWidgetGridView.getTag()).intValue();
    Object localObject = (DatalineSessionAdapter.GridAdapter)paramItemHolder.a().jdField_a_of_type_AndroidWidgetGridView.getAdapter();
    if (localObject == null)
    {
      localObject = new DatalineSessionAdapter.GridAdapter(this, paramItemHolder, paramDataLineMsgSet, j, null);
      paramItemHolder.a().jdField_a_of_type_AndroidWidgetGridView.setAdapter((ListAdapter)localObject);
    }
    else
    {
      ((DatalineSessionAdapter.GridAdapter)localObject).jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet = paramDataLineMsgSet;
      ((DatalineSessionAdapter.GridAdapter)localObject).jdField_a_of_type_ComDatalineUtilItemHolder = paramItemHolder;
      ((DatalineSessionAdapter.GridAdapter)localObject).a();
    }
    paramItemHolder.a().jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    paramDataLineMsgSet.printlog();
    if (((!paramDataLineMsgSet.hasSendingOrRecving()) && (!paramDataLineMsgSet.hasWaiting())) || (paramDataLineMsgSet.isFileComing()))
    {
      paramItemHolder.a().jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
      if (paramDataLineMsgSet.isCanceled())
      {
        paramItemHolder.a().jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        paramItemHolder.a().jdField_b_of_type_AndroidWidgetTextView.setText(2131693753);
      }
      else if (paramDataLineMsgSet.isFileComing())
      {
        paramItemHolder.a().jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        paramItemHolder.a().jdField_b_of_type_AndroidWidgetTextView.setText(2131692358);
      }
    }
    else
    {
      paramItemHolder.a().jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      paramItemHolder.a().jdField_a_of_type_AndroidWidgetProgressBar.setProgress((int)(paramDataLineMsgSet.getTotalProcess() * 100.0F));
    }
    if (!paramDataLineMsgSet.isSendFromLocal())
    {
      paramItemHolder.a().jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      if (localDataLineMsgRecord.strMoloKey != null)
      {
        if ((localDataLineMsgRecord.strMoloSource != null) && (!localDataLineMsgRecord.strMoloSource.equals("")))
        {
          paramItemHolder.a().jdField_c_of_type_AndroidWidgetTextView.setText(localDataLineMsgRecord.strMoloSource);
          paramItemHolder.a().jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
          paramItemHolder.a().jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        }
        else
        {
          paramItemHolder.a().jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        }
        if ((localDataLineMsgRecord.strMoloSrcIconUrl != null) && (!localDataLineMsgRecord.strMoloSrcIconUrl.equals("")))
        {
          paramItemHolder.a().jdField_a_of_type_ComTencentImageURLImageView.setImageURL(localDataLineMsgRecord.strMoloSrcIconUrl);
          paramItemHolder.a().jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
        }
        else
        {
          paramItemHolder.a().jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
        }
      }
    }
    if (paramItemHolder.a().jdField_a_of_type_AndroidWidgetRelativeLayout != null)
    {
      paramDataLineMsgSet = String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131693736), new Object[] { Integer.valueOf(i) });
      paramItemHolder.a().jdField_a_of_type_AndroidWidgetRelativeLayout.setContentDescription(paramDataLineMsgSet);
    }
    return true;
  }
  
  private void c(ItemHolder paramItemHolder, DataLineMsgSet paramDataLineMsgSet)
  {
    if (paramItemHolder == null) {
      return;
    }
    if (paramDataLineMsgSet == null) {
      return;
    }
    DataLineMsgRecord localDataLineMsgRecord = paramDataLineMsgSet.getFirstItem();
    if (localDataLineMsgRecord == null) {
      return;
    }
    String str = FilePathUtil.b(localDataLineMsgRecord.path);
    paramItemHolder.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setAsyncClipSize(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
    paramItemHolder.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setDefaultImageByMargin();
    paramItemHolder.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setIsDrawRound(true);
    paramItemHolder.a().jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    paramItemHolder.a().jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    if ((str != null) && (new VFSFile(str).exists())) {
      paramItemHolder.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setAsyncImage(str);
    } else if ((localDataLineMsgRecord.thumbPath != null) && (localDataLineMsgRecord.thumbPath.length() > 0)) {
      paramItemHolder.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setAsyncImage(localDataLineMsgRecord.thumbPath);
    } else {
      paramItemHolder.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setImageDrawableDefault();
    }
    if ((localDataLineMsgRecord.progress != 1.0F) && (localDataLineMsgRecord.issuc) && (localDataLineMsgRecord.fileMsgStatus != 1L) && (localDataLineMsgRecord.fileMsgStatus != 2L))
    {
      if (localDataLineMsgRecord.isSendFromLocal())
      {
        paramItemHolder.a().jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setVisibility(0);
        int i = (int)(localDataLineMsgRecord.progress * 100.0F);
        paramItemHolder.a().jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setProgress(i);
      }
      else
      {
        paramItemHolder.a().jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      }
    }
    else
    {
      paramItemHolder.a().jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setVisibility(8);
      paramItemHolder.a().jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      if ((localDataLineMsgRecord.fileMsgStatus == 1L) && (localDataLineMsgRecord.thumbPath == null))
      {
        paramItemHolder.a().jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        paramItemHolder.a().jdField_a_of_type_AndroidWidgetTextView.setText(2131693705);
      }
      else
      {
        paramItemHolder.a().jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      }
    }
    if (!paramDataLineMsgSet.isSendFromLocal())
    {
      paramItemHolder.a().jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      if (localDataLineMsgRecord.strMoloKey != null)
      {
        if ((localDataLineMsgRecord.strMoloSource != null) && (!localDataLineMsgRecord.strMoloSource.equals("")))
        {
          paramItemHolder.a().jdField_c_of_type_AndroidWidgetTextView.setText(localDataLineMsgRecord.strMoloSource);
          paramItemHolder.a().jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
          paramItemHolder.a().jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        }
        else
        {
          paramItemHolder.a().jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        }
        if ((localDataLineMsgRecord.strMoloSrcIconUrl != null) && (!localDataLineMsgRecord.strMoloSrcIconUrl.equals("")))
        {
          paramItemHolder.a().jdField_a_of_type_ComTencentImageURLImageView.setImageURL(localDataLineMsgRecord.strMoloSrcIconUrl);
          paramItemHolder.a().jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
        }
        else
        {
          paramItemHolder.a().jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
        }
      }
    }
    if (paramItemHolder.a().jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
      paramItemHolder.a().jdField_a_of_type_AndroidWidgetRelativeLayout.setContentDescription(HardCodeUtil.a(2131702923));
    }
    if (paramItemHolder.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView != null) {
      paramItemHolder.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setContentDescription(HardCodeUtil.a(2131702915));
    }
  }
  
  private void d(ItemHolder paramItemHolder, DataLineMsgSet paramDataLineMsgSet)
  {
    if (paramItemHolder == null) {
      return;
    }
    if (paramDataLineMsgSet == null) {
      return;
    }
    paramItemHolder.jdField_a_of_type_AndroidWidgetImageView.setTag(paramItemHolder);
    int i;
    if ((paramDataLineMsgSet.isSendFromLocal()) && (paramDataLineMsgSet.hasFailed()) && (!paramDataLineMsgSet.hasSendingOrRecving()) && (!paramDataLineMsgSet.hasWaiting())) {
      i = 1;
    } else {
      i = 0;
    }
    if (i == 0)
    {
      paramItemHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      return;
    }
    paramItemHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    if (paramDataLineMsgSet.getOpType() == 1)
    {
      paramItemHolder.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.b);
      return;
    }
    paramItemHolder.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.jdField_a_of_type_AndroidViewView$OnClickListener);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.size();
  }
  
  public long a(int paramInt)
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.get(paramInt).getTime();
  }
  
  protected View a(int paramInt, ItemHolder paramItemHolder, DataLineMsgSet paramDataLineMsgSet)
  {
    return null;
  }
  
  protected void a()
  {
    this.jdField_a_of_type_Boolean = false;
    new Handler().postDelayed(new DatalineSessionAdapter.1(this), 1500L);
  }
  
  protected void a(int paramInt, ItemHolder paramItemHolder, DataLineMsgSet paramDataLineMsgSet) {}
  
  public void a(long paramLong, ListView paramListView, float paramFloat)
  {
    if (paramListView == null) {
      return;
    }
    int i = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.getSetIndex(paramLong);
    if (i == -1) {
      return;
    }
    paramListView = paramListView.getChildAt(i - paramListView.getFirstVisiblePosition());
    if (paramListView == null) {
      return;
    }
    if (i >= this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.size()) {
      return;
    }
    DataLineMsgSet localDataLineMsgSet = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.get(i);
    if (localDataLineMsgSet.mUpdateProcessTick == 0L)
    {
      localDataLineMsgSet.mUpdateProcessTick = System.currentTimeMillis();
    }
    else
    {
      if (System.currentTimeMillis() - localDataLineMsgSet.mUpdateProcessTick < 1000L) {
        return;
      }
      localDataLineMsgSet.mUpdateProcessTick = System.currentTimeMillis();
    }
    int j;
    Object localObject;
    if (localDataLineMsgSet.isSingle())
    {
      j = DataLineMsgRecord.getDevTypeBySeId(paramLong);
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(j).a(paramLong);
      if (localObject == null) {
        return;
      }
      if (a(getItemViewType(i)))
      {
        a((DataLineMsgRecord)localObject, paramListView, paramFloat);
        return;
      }
      float f = paramFloat;
      if (paramFloat < ((DataLineMsgRecord)localObject).progress) {
        f = ((DataLineMsgRecord)localObject).progress;
      }
      i = ((DataLineMsgRecord)localObject).msgtype;
      if ((i != -2335) && (i != -2009) && (i != -2005))
      {
        if (i != -2000) {
          return;
        }
        paramListView = (MessageProgressTextView)paramListView.findViewById(2131368478);
        if (paramListView != null) {
          paramListView.setProgress((int)(f * 100.0F));
        }
      }
      else if (((DataLineMsgRecord)localObject).bIsMoloImage)
      {
        paramListView = (MessageProgressTextView)paramListView.findViewById(2131368478);
        if (paramListView != null) {
          paramListView.setProgress((int)(f * 100.0F));
        }
      }
      else
      {
        localObject = (TextView)paramListView.findViewById(2131366824);
        paramListView = (ProgressBar)paramListView.findViewById(2131366793);
        if (paramListView != null)
        {
          paramListView.setVisibility(0);
          paramListView.setProgress((int)(f * 100.0F));
        }
        if (localObject != null)
        {
          paramListView = new StringBuilder();
          paramListView.append((int)(f * 100.0F));
          paramListView.append("%");
          ((TextView)localObject).setText(paramListView.toString());
        }
      }
    }
    else
    {
      paramListView = (ItemHolder)paramListView.getTag();
      if (paramListView == null) {
        return;
      }
      i = localDataLineMsgSet.getGroupType();
      localObject = null;
      if ((i != -2335) && (i != -2009) && (i != -2005))
      {
        if (i != -2000) {
          paramListView = null;
        } else {
          paramListView = paramListView.a().jdField_a_of_type_AndroidWidgetProgressBar;
        }
      }
      else
      {
        localObject = paramListView.a().jdField_d_of_type_AndroidWidgetTextView;
        paramListView = paramListView.a().jdField_a_of_type_AndroidWidgetProgressBar;
      }
      i = localDataLineMsgSet.getCompletedCount();
      j = localDataLineMsgSet.getTotalCount();
      if (localObject != null)
      {
        StringBuilder localStringBuilder;
        if (i == j)
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("");
          localStringBuilder.append(j);
          ((TextView)localObject).setText(localStringBuilder.toString());
        }
        else
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(i);
          localStringBuilder.append("/");
          localStringBuilder.append(j);
          ((TextView)localObject).setText(localStringBuilder.toString());
        }
      }
      if (paramListView != null)
      {
        if (i == j)
        {
          paramListView.setVisibility(4);
          return;
        }
        paramListView.setVisibility(0);
        paramListView.setProgress((int)(localDataLineMsgSet.getTotalProcess() * 100.0F));
      }
    }
  }
  
  protected void a(View paramView, DataLineMsgRecord paramDataLineMsgRecord)
  {
    if (paramDataLineMsgRecord.isSendFromLocal())
    {
      paramView.setPadding(BaseChatItemLayout.k, BaseChatItemLayout.h, BaseChatItemLayout.j, BaseChatItemLayout.i);
      return;
    }
    paramView.setPadding(BaseChatItemLayout.j, BaseChatItemLayout.h, BaseChatItemLayout.k, BaseChatItemLayout.i);
  }
  
  protected void a(ItemHolder paramItemHolder, View paramView, DataLineMsgRecord paramDataLineMsgRecord, BubbleInfo paramBubbleInfo)
  {
    if (paramBubbleInfo == null) {
      return;
    }
    if ((paramBubbleInfo.jdField_a_of_type_Int != 0) && (paramBubbleInfo.a()))
    {
      if (paramBubbleInfo.jdField_b_of_type_Int == 0) {
        paramItemHolder.a().jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
      } else {
        paramItemHolder.a().jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramBubbleInfo.jdField_b_of_type_Int);
      }
      if (paramBubbleInfo.c == 0)
      {
        paramItemHolder.a().jdField_a_of_type_AndroidWidgetTextView.setLinkTextColor(paramView.getResources().getColorStateList(2131167077));
        return;
      }
      paramItemHolder.a().jdField_a_of_type_AndroidWidgetTextView.setLinkTextColor(paramBubbleInfo.c);
      return;
    }
    paramView = paramView.getResources();
    int i;
    if (paramDataLineMsgRecord.isSendFromLocal()) {
      i = 2131167079;
    } else {
      i = 2131167075;
    }
    paramBubbleInfo = paramView.getColorStateList(i);
    paramItemHolder.a().jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramBubbleInfo);
    if (paramDataLineMsgRecord.isSendFromLocal()) {
      paramView = paramView.getColorStateList(2131167078);
    } else {
      paramView = paramView.getColorStateList(2131167077);
    }
    paramItemHolder.a().jdField_a_of_type_AndroidWidgetTextView.setLinkTextColor(paramView);
  }
  
  protected void a(ItemHolder paramItemHolder, DataLineMsgSet paramDataLineMsgSet)
  {
    if (paramItemHolder == null) {
      return;
    }
    if (paramDataLineMsgSet == null) {
      return;
    }
    paramDataLineMsgSet = paramDataLineMsgSet.getFirstItem();
    if (paramDataLineMsgSet == null) {
      return;
    }
    int i = (int)(paramDataLineMsgSet.progress * 100.0F);
    paramItemHolder.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setIsDrawRound(false);
    FileManagerUtil.a(paramItemHolder.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView, paramDataLineMsgSet);
    paramItemHolder.a().jdField_a_of_type_AndroidWidgetTextView.setText(FileManagerUtil.c(paramDataLineMsgSet.filename));
    paramItemHolder.a().jdField_c_of_type_AndroidWidgetTextView.setText(FileUtil.a(paramDataLineMsgSet.filesize));
    TextView localTextView;
    StringBuilder localStringBuilder;
    if (paramDataLineMsgSet.isSendFromLocal())
    {
      if (paramDataLineMsgSet.fileMsgStatus == 2L)
      {
        paramItemHolder.a().jdField_d_of_type_AndroidWidgetTextView.setText(2131693753);
      }
      else if ((paramDataLineMsgSet.progress == 1.0F) && (paramDataLineMsgSet.issuc))
      {
        paramItemHolder.a().jdField_d_of_type_AndroidWidgetTextView.setText(2131692357);
      }
      else if (!paramDataLineMsgSet.issuc)
      {
        if (paramDataLineMsgSet.nOpType == 1) {
          paramItemHolder.a().jdField_d_of_type_AndroidWidgetTextView.setText(2131692355);
        } else {
          paramItemHolder.a().jdField_d_of_type_AndroidWidgetTextView.setText(2131692356);
        }
      }
      else
      {
        localTextView = paramItemHolder.a().jdField_d_of_type_AndroidWidgetTextView;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(i);
        localStringBuilder.append("%");
        localTextView.setText(localStringBuilder.toString());
      }
    }
    else if (paramDataLineMsgSet.fileMsgStatus == 2L)
    {
      paramItemHolder.a().jdField_d_of_type_AndroidWidgetTextView.setText(2131693753);
    }
    else if (paramDataLineMsgSet.fileMsgStatus == 1L)
    {
      paramItemHolder.a().jdField_d_of_type_AndroidWidgetTextView.setText(2131692358);
    }
    else if ((paramDataLineMsgSet.progress == 1.0F) && (paramDataLineMsgSet.issuc))
    {
      paramItemHolder.a().jdField_d_of_type_AndroidWidgetTextView.setText(2131692349);
    }
    else if (!paramDataLineMsgSet.issuc)
    {
      paramItemHolder.a().jdField_d_of_type_AndroidWidgetTextView.setText(2131692355);
    }
    else
    {
      localTextView = paramItemHolder.a().jdField_d_of_type_AndroidWidgetTextView;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(i);
      localStringBuilder.append("%");
      localTextView.setText(localStringBuilder.toString());
    }
    if ((paramDataLineMsgSet.progress != 1.0F) && (paramDataLineMsgSet.issuc) && (paramDataLineMsgSet.fileMsgStatus != 1L) && (paramDataLineMsgSet.fileMsgStatus != 2L))
    {
      paramItemHolder.a().jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      paramItemHolder.a().jdField_a_of_type_AndroidWidgetProgressBar.setProgress(i);
      return;
    }
    paramItemHolder.a().jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
  }
  
  protected void a(DataLineMsgRecord paramDataLineMsgRecord, View paramView, float paramFloat) {}
  
  public void a(DataLineMsgSetList paramDataLineMsgSetList)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList = paramDataLineMsgSetList;
  }
  
  protected boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  protected boolean a(int paramInt)
  {
    return false;
  }
  
  public boolean a(long paramLong, ListView paramListView)
  {
    int i = DataLineMsgRecord.getDevTypeBySeId(paramLong);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getDataLineMsgProxy(i).b(paramLong);
    if (b()) {
      return false;
    }
    if (paramListView == null) {
      return true;
    }
    i = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.getSetIndex(paramLong);
    if (i == -1) {
      return false;
    }
    View localView = paramListView.getChildAt(i - paramListView.getFirstVisiblePosition());
    if (localView == null) {
      return false;
    }
    if (i >= this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.size()) {
      return false;
    }
    paramListView = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.get(i);
    if ((localObject != null) && (((DataLineMsgRecord)localObject).fileMsgStatus == 1L)) {
      if (paramListView.mUpdateMutiViewTick == 0L)
      {
        paramListView.mUpdateMutiViewTick = System.currentTimeMillis();
      }
      else
      {
        if (System.currentTimeMillis() - paramListView.mUpdateMutiViewTick < 1000L) {
          return true;
        }
        paramListView.mUpdateMutiViewTick = System.currentTimeMillis();
      }
    }
    if (paramListView.isSingle()) {
      return true;
    }
    localObject = (ItemHolder)localView.getTag();
    if (localObject == null) {
      return false;
    }
    i = paramListView.getGroupType();
    if (i != -2335)
    {
      if ((i == -2000) && (!b((ItemHolder)localObject, paramListView))) {
        return false;
      }
    }
    else if (paramListView.getFirstItem().bIsMoloImage)
    {
      if (!b((ItemHolder)localObject, paramListView)) {
        return false;
      }
    }
    else if (!a((ItemHolder)localObject, paramListView)) {
      return false;
    }
    d((ItemHolder)localObject, paramListView);
    return true;
  }
  
  public long b(int paramInt)
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.get(paramInt).getMsgId();
  }
  
  protected void b(ItemHolder paramItemHolder, DataLineMsgSet paramDataLineMsgSet)
  {
    if (paramItemHolder == null) {
      return;
    }
    if (paramDataLineMsgSet == null) {
      return;
    }
    paramDataLineMsgSet = paramDataLineMsgSet.getFirstItem();
    if (paramDataLineMsgSet == null) {
      return;
    }
    int i = (int)(paramDataLineMsgSet.progress * 100.0F);
    if (paramDataLineMsgSet.strMoloIconUrl != null) {
      paramItemHolder.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setAsyncImage(paramDataLineMsgSet.strMoloIconUrl);
    } else {
      paramItemHolder.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setImageResource(2130844275);
    }
    paramItemHolder.a().jdField_a_of_type_AndroidWidgetTextView.setText(FileManagerUtil.c(paramDataLineMsgSet.filename));
    if ((paramDataLineMsgSet.strMoloSource != null) && (paramDataLineMsgSet.strMoloSource.contains(this.jdField_a_of_type_AndroidContentContext.getString(2131693787))))
    {
      paramItemHolder.a().jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      paramItemHolder.a().jdField_a_of_type_AndroidWidgetTextView.setSingleLine(false);
      paramItemHolder.a().jdField_a_of_type_AndroidWidgetTextView.setMaxLines(2);
    }
    else
    {
      paramItemHolder.a().jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      paramItemHolder.a().jdField_b_of_type_AndroidWidgetTextView.setText(2131693688);
      paramItemHolder.a().jdField_a_of_type_AndroidWidgetTextView.setSingleLine(true);
    }
    paramItemHolder.a().jdField_c_of_type_AndroidWidgetTextView.setText(FileUtil.a(paramDataLineMsgSet.filesize));
    if ((paramDataLineMsgSet.strMoloSource != null) && (!paramDataLineMsgSet.strMoloSource.equals("")))
    {
      paramItemHolder.a().e.setText(paramDataLineMsgSet.strMoloSource);
      paramItemHolder.a().e.setVisibility(0);
      paramItemHolder.a().jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    }
    else
    {
      paramItemHolder.a().jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
    if ((paramDataLineMsgSet.strMoloSrcIconUrl != null) && (!paramDataLineMsgSet.strMoloSrcIconUrl.equals("")))
    {
      paramItemHolder.a().jdField_a_of_type_ComTencentImageURLImageView.setImageURL(paramDataLineMsgSet.strMoloSrcIconUrl);
      paramItemHolder.a().jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
    }
    else
    {
      paramItemHolder.a().jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
    }
    if (paramDataLineMsgSet.fileMsgStatus == 2L)
    {
      paramItemHolder.a().jdField_d_of_type_AndroidWidgetTextView.setText(2131693753);
    }
    else if (paramDataLineMsgSet.fileMsgStatus == 1L)
    {
      paramItemHolder.a().jdField_d_of_type_AndroidWidgetTextView.setText(2131692358);
    }
    else if ((paramDataLineMsgSet.progress == 1.0F) && (paramDataLineMsgSet.issuc))
    {
      paramItemHolder.a().jdField_d_of_type_AndroidWidgetTextView.setText(2131692349);
    }
    else if (!paramDataLineMsgSet.issuc)
    {
      paramItemHolder.a().jdField_d_of_type_AndroidWidgetTextView.setText(2131692355);
    }
    else
    {
      TextView localTextView = paramItemHolder.a().jdField_d_of_type_AndroidWidgetTextView;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(i);
      localStringBuilder.append("%");
      localTextView.setText(localStringBuilder.toString());
    }
    if ((paramDataLineMsgSet.progress != 1.0F) && (paramDataLineMsgSet.issuc) && (paramDataLineMsgSet.fileMsgStatus != 1L) && (paramDataLineMsgSet.fileMsgStatus != 2L))
    {
      paramItemHolder.a().jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      paramItemHolder.a().jdField_a_of_type_AndroidWidgetProgressBar.setProgress(i);
      return;
    }
    paramItemHolder.a().jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
  }
  
  public int getCount()
  {
    if (b()) {
      return 1;
    }
    return this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.size();
  }
  
  public Object getItem(int paramInt)
  {
    if (b()) {
      return null;
    }
    return this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (b()) {
      return 13;
    }
    DataLineMsgSet localDataLineMsgSet = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.get(paramInt);
    boolean bool = localDataLineMsgSet.isSendFromLocal();
    int j = localDataLineMsgSet.getGroupType();
    if (j != -5041)
    {
      if (j != -5000)
      {
        paramInt = 1;
        int i = 2;
        if (j != -2335)
        {
          if (j != -2073)
          {
            if ((j != -2009) && (j != -2005))
            {
              if (j != -2000)
              {
                if (j != -1000) {
                  return 12;
                }
                if (bool) {
                  return 7;
                }
                return 0;
              }
              if (localDataLineMsgSet.isSingle())
              {
                if (bool) {
                  paramInt = 8;
                }
                return paramInt;
              }
              paramInt = i;
              if (bool) {
                paramInt = 9;
              }
              return paramInt;
            }
            if (localDataLineMsgSet.isSingle())
            {
              if (bool) {
                return 10;
              }
              return 3;
            }
            if (bool) {
              return 11;
            }
            return 4;
          }
          return 16;
        }
        DataLineMsgRecord localDataLineMsgRecord = localDataLineMsgSet.getFirstItem();
        if (localDataLineMsgSet.isSingle())
        {
          if (localDataLineMsgRecord.bIsMoloImage) {
            return 1;
          }
          return 5;
        }
        if (localDataLineMsgRecord.bIsMoloImage) {
          return 2;
        }
        return 6;
      }
      return 14;
    }
    return 15;
  }
  
  @TargetApi(8)
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    boolean bool = b();
    Object localObject2 = null;
    Object localObject1;
    Object localObject3;
    if (bool)
    {
      if (paramView == null)
      {
        localObject1 = new ItemHolder();
        paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559037, null);
        localObject2 = (TextView)paramView.findViewById(2131370179);
        localObject3 = (ImageView)paramView.findViewById(2131370178);
        if (this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.jdField_a_of_type_Int == 1)
        {
          ((TextView)localObject2).setText(2131691375);
          ((ImageView)localObject3).setImageResource(2130839551);
        }
        paramView.setTag(localObject1);
      }
      else
      {
        localObject1 = (ItemHolder)paramView.getTag();
      }
      paramView.setVisibility(4);
      this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.u();
    }
    label3897:
    for (;;)
    {
      localObject1 = paramView;
      break;
      this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.u();
      localObject3 = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.get(paramInt);
      if (localObject3 == null)
      {
        localObject1 = paramView;
        paramView = (View)localObject2;
        break;
      }
      int i = getItemViewType(paramInt);
      DataLineMsgRecord localDataLineMsgRecord = ((DataLineMsgSet)localObject3).getFirstItem();
      Object localObject4;
      int j;
      if (paramView == null)
      {
        localObject2 = new ItemHolder();
        if (a(i))
        {
          paramView = a(i, (ItemHolder)localObject2, (DataLineMsgSet)localObject3);
        }
        else if (i == 12)
        {
          localObject1 = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559025, null);
          ((ItemHolder)localObject2).b((TextView)((View)localObject1).findViewById(2131365420));
          paramView = (View)localObject1;
          if (((ItemHolder)localObject2).b() != null)
          {
            ((ItemHolder)localObject2).b().setText(2131693744);
            paramView = (View)localObject1;
          }
        }
        else
        {
          Object localObject5;
          if (i == 14)
          {
            paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559011, null);
            localObject1 = ((ItemHolder)localObject2).a();
            ((ItemHolder.GrayTipItemHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131367798));
            localObject4 = HardCodeUtil.a(2131702934);
            localObject5 = HardCodeUtil.a(2131702911);
            ((ItemHolder.GrayTipItemHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView.setMaxLines(2);
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("还想把文件发到好友手机？快来用\n");
            localStringBuilder.append((String)localObject4);
            localStringBuilder.append((String)localObject5);
            localObject5 = new SpannableString(localStringBuilder.toString());
            ((SpannableString)localObject5).setSpan(new DatalineSessionAdapter.3(this), 16, ((String)localObject4).length() + 16, 33);
            ((ItemHolder.GrayTipItemHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView.setHighlightColor(0);
            ((ItemHolder.GrayTipItemHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject5);
            ((ItemHolder.GrayTipItemHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView.setMovementMethod(LinkMovementMethod.getInstance());
            ((ItemHolder.GrayTipItemHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
          }
          else if (i == 15)
          {
            localObject1 = ((ItemHolder)localObject2).a();
            paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560848, null);
            ((ItemHolder.TipHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131367798));
          }
          else
          {
            if (i == 16)
            {
              localObject1 = ((ItemHolder)localObject2).a();
              paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558861, null);
              ((ItemHolder.TipHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131367798));
              ((ItemHolder.TipHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView.setMovementMethod(null);
              ((ItemHolder.TipHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramView.getResources().getColorStateList(2131165418));
            }
            for (;;)
            {
              break;
              if (!((DataLineMsgSet)localObject3).isSendFromLocal())
              {
                localObject1 = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559026, null);
                localObject4 = (ImageView)((View)localObject1).findViewById(2131368343);
                paramView = this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.getResources().getDrawable(2130844282);
                j = DataLineMsgRecord.getDevTypeBySet((DataLineMsgSet)localObject3);
                if (j == 0) {
                  paramView = this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.getResources().getDrawable(2130844282);
                } else if (j == 1) {
                  paramView = this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.getResources().getDrawable(2130844277);
                }
                ((ImageView)localObject4).setImageDrawable(paramView);
                paramView = (View)localObject1;
              }
              else
              {
                paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559032, null);
              }
              ((ItemHolder)localObject2).jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131371546));
              ((ItemHolder)localObject2).jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(localObject2);
              ((ItemHolder)localObject2).jdField_a_of_type_AndroidWidgetRelativeLayout.setClickable(true);
              ((ItemHolder)localObject2).jdField_a_of_type_AndroidWidgetRelativeLayout.setLongClickable(true);
              ((ItemHolder)localObject2).jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
              ((ItemHolder)localObject2).jdField_a_of_type_AndroidWidgetRelativeLayout.setOnLongClickListener(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.jdField_a_of_type_AndroidViewView$OnLongClickListener);
              ((ItemHolder)localObject2).jdField_a_of_type_AndroidWidgetRelativeLayout.setOnTouchListener(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.jdField_a_of_type_AndroidViewView$OnTouchListener);
              ((ItemHolder)localObject2).jdField_a_of_type_AndroidWidgetRelativeLayout.setAddStatesFromChildren(true);
              switch (i)
              {
              case 4: 
              default: 
                break;
              case 6: 
                localObject1 = (RelativeLayout)this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559014, null);
                ((ItemHolder)localObject2).jdField_a_of_type_AndroidWidgetRelativeLayout.addView((View)localObject1);
                ((ItemHolder)localObject2).a().jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localObject1);
                ((ItemHolder)localObject2).a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView = ((AsyncImageView)paramView.findViewById(2131366783));
                ((ItemHolder)localObject2).a().jdField_b_of_type_ComDatalineUtilWidgetAsyncImageView = ((AsyncImageView)paramView.findViewById(2131366784));
                ((ItemHolder)localObject2).a().jdField_c_of_type_ComDatalineUtilWidgetAsyncImageView = ((AsyncImageView)paramView.findViewById(2131366785));
                ((ItemHolder)localObject2).a().jdField_d_of_type_ComDatalineUtilWidgetAsyncImageView = ((AsyncImageView)paramView.findViewById(2131366786));
                ((ItemHolder)localObject2).a().jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366819));
                ((ItemHolder)localObject2).a().jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366796));
                ((ItemHolder)localObject2).a().jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366823));
                ((ItemHolder)localObject2).a().jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366824));
                ((ItemHolder)localObject2).a().jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramView.findViewById(2131366793));
                ((ItemHolder)localObject2).a().e = ((TextView)paramView.findViewById(2131380049));
                ((ItemHolder)localObject2).a().jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131368381));
                ((ItemHolder)localObject2).a().jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131377724));
                ((ItemHolder)localObject2).a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setDefaultImage(2130844275);
                ((ItemHolder)localObject2).a().jdField_b_of_type_ComDatalineUtilWidgetAsyncImageView.setDefaultImage(2130844275);
                ((ItemHolder)localObject2).a().jdField_c_of_type_ComDatalineUtilWidgetAsyncImageView.setDefaultImage(2130844275);
                ((ItemHolder)localObject2).a().jdField_d_of_type_ComDatalineUtilWidgetAsyncImageView.setDefaultImage(2130844275);
                ((ItemHolder)localObject2).a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setIsDrawRound(false);
                ((ItemHolder)localObject2).a().jdField_b_of_type_ComDatalineUtilWidgetAsyncImageView.setIsDrawRound(false);
                ((ItemHolder)localObject2).a().jdField_c_of_type_ComDatalineUtilWidgetAsyncImageView.setIsDrawRound(false);
                ((ItemHolder)localObject2).a().jdField_d_of_type_ComDatalineUtilWidgetAsyncImageView.setIsDrawRound(false);
                break;
              case 5: 
                localObject1 = (RelativeLayout)this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559005, null);
                ((ItemHolder)localObject2).jdField_a_of_type_AndroidWidgetRelativeLayout.addView((View)localObject1);
                ((ItemHolder)localObject2).a().jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localObject1);
                ((ItemHolder)localObject2).a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView = ((AsyncImageView)paramView.findViewById(2131366782));
                ((ItemHolder)localObject2).a().jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366819));
                ((ItemHolder)localObject2).a().jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366796));
                ((ItemHolder)localObject2).a().jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366823));
                ((ItemHolder)localObject2).a().jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366824));
                ((ItemHolder)localObject2).a().jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramView.findViewById(2131366793));
                ((ItemHolder)localObject2).a().e = ((TextView)paramView.findViewById(2131380049));
                ((ItemHolder)localObject2).a().jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131368381));
                ((ItemHolder)localObject2).a().jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131377724));
                ((ItemHolder)localObject2).a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setDefaultImage(2130844274);
                ((ItemHolder)localObject2).a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setIsDrawRound(false);
                break;
              case 3: 
              case 10: 
                localObject4 = (RelativeLayout)this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559007, null);
                ((ItemHolder)localObject2).jdField_a_of_type_AndroidWidgetRelativeLayout.addView((View)localObject4);
                if (FontSettingManager.getFontLevel() > 17.0F)
                {
                  ((ItemHolder)localObject2).a().jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localObject4);
                  j = AIOUtils.b(70.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
                  localObject1 = (RelativeLayout)paramView.findViewById(2131366806);
                  localObject5 = new RelativeLayout.LayoutParams(-1, j);
                  ((RelativeLayout.LayoutParams)localObject5).addRule(10, 2131366809);
                  ((RelativeLayout)localObject4).updateViewLayout((View)localObject1, (ViewGroup.LayoutParams)localObject5);
                  localObject4 = (AsyncImageView)paramView.findViewById(2131366782);
                  ((AsyncImageView)localObject4).setScaleType(ImageView.ScaleType.CENTER_CROP);
                  localObject5 = new RelativeLayout.LayoutParams(j, j);
                  ((RelativeLayout.LayoutParams)localObject5).addRule(9, 2131366806);
                  ((RelativeLayout.LayoutParams)localObject5).addRule(15, 2131366806);
                  ((RelativeLayout)localObject1).updateViewLayout((View)localObject4, (ViewGroup.LayoutParams)localObject5);
                  ((ItemHolder)localObject2).a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView = ((AsyncImageView)localObject4);
                  localObject4 = (TextView)paramView.findViewById(2131366819);
                  ((TextView)localObject4).setGravity(16);
                  localObject5 = new RelativeLayout.LayoutParams(-1, -2);
                  ((RelativeLayout.LayoutParams)localObject5).addRule(1, 2131366782);
                  ((RelativeLayout.LayoutParams)localObject5).addRule(11, 2131366806);
                  ((RelativeLayout.LayoutParams)localObject5).addRule(10, 2131366806);
                  ((RelativeLayout.LayoutParams)localObject5).setMargins(AIOUtils.b(10.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0, 0, 0);
                  ((RelativeLayout)localObject1).updateViewLayout((View)localObject4, (ViewGroup.LayoutParams)localObject5);
                  ((ItemHolder)localObject2).a().jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject4);
                  localObject4 = (TextView)paramView.findViewById(2131366824);
                  ((TextView)localObject4).setGravity(5);
                  localObject5 = new RelativeLayout.LayoutParams(-2, -2);
                  ((RelativeLayout.LayoutParams)localObject5).addRule(11, 2131366806);
                  ((RelativeLayout.LayoutParams)localObject5).addRule(12, 2131366806);
                  ((RelativeLayout)localObject1).updateViewLayout((View)localObject4, (ViewGroup.LayoutParams)localObject5);
                  ((ItemHolder)localObject2).a().jdField_d_of_type_AndroidWidgetTextView = ((TextView)localObject4);
                  localObject4 = (TextView)paramView.findViewById(2131366823);
                  ((TextView)localObject4).setGravity(17);
                  localObject5 = new RelativeLayout.LayoutParams(-2, -2);
                  ((RelativeLayout.LayoutParams)localObject5).addRule(11, 2131366806);
                  ((RelativeLayout.LayoutParams)localObject5).addRule(2, 2131366824);
                  ((RelativeLayout)localObject1).updateViewLayout((View)localObject4, (ViewGroup.LayoutParams)localObject5);
                  ((ItemHolder)localObject2).a().jdField_c_of_type_AndroidWidgetTextView = ((TextView)localObject4);
                }
                else
                {
                  ((ItemHolder)localObject2).a().jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localObject4);
                  ((ItemHolder)localObject2).a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView = ((AsyncImageView)paramView.findViewById(2131366782));
                  ((ItemHolder)localObject2).a().jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366819));
                  ((ItemHolder)localObject2).a().jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366823));
                  ((ItemHolder)localObject2).a().jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366824));
                }
                ((ItemHolder)localObject2).a().jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramView.findViewById(2131366793));
                ((ItemHolder)localObject2).a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setDefaultImage(2130851161);
                ((ItemHolder)localObject2).a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setIsDrawRound(false);
                break;
              case 2: 
              case 9: 
                localObject1 = (RelativeLayout)this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559015, null);
                ((ItemHolder)localObject2).jdField_a_of_type_AndroidWidgetRelativeLayout.addView((View)localObject1);
                ((ItemHolder)localObject2).a().jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localObject1);
                ((ItemHolder)localObject2).a().jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131372724));
                ((ItemHolder)localObject2).a().jdField_a_of_type_AndroidWidgetGridView = ((GridView)paramView.findViewById(2131372697));
                ((ItemHolder)localObject2).a().jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramView.findViewById(2131366793));
                ((ItemHolder)localObject2).a().jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131377852));
                ((ItemHolder)localObject2).a().jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380050));
                if (!((DataLineMsgSet)localObject3).isSendFromLocal())
                {
                  ((ItemHolder)localObject2).a().jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380049));
                  ((ItemHolder)localObject2).a().jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131368381));
                  ((ItemHolder)localObject2).a().jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131377724));
                }
                ((ItemHolder)localObject2).a().jdField_a_of_type_AndroidWidgetRelativeLayout.setAddStatesFromChildren(true);
                ((ItemHolder)localObject2).a().jdField_a_of_type_AndroidWidgetTextView.setTag(localObject2);
                ((ItemHolder)localObject2).a().jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
                ((ItemHolder)localObject2).a().jdField_a_of_type_AndroidWidgetTextView.setClickable(true);
                ((ItemHolder)localObject2).a().jdField_a_of_type_AndroidWidgetTextView.setOnLongClickListener(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.jdField_a_of_type_AndroidViewView$OnLongClickListener);
                ((ItemHolder)localObject2).a().jdField_a_of_type_AndroidWidgetTextView.setOnTouchListener(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.jdField_a_of_type_AndroidViewView$OnTouchListener);
                ((ItemHolder)localObject2).a().jdField_a_of_type_AndroidWidgetTextView.setLongClickable(true);
                a(((ItemHolder)localObject2).a().jdField_a_of_type_AndroidWidgetGridView);
                break;
              case 1: 
              case 8: 
                localObject1 = (RelativeLayout)this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559013, null);
                ((ItemHolder)localObject2).jdField_a_of_type_AndroidWidgetRelativeLayout.addView((View)localObject1);
                ((ItemHolder)localObject2).jdField_a_of_type_AndroidWidgetRelativeLayout.setGravity(17);
                ((ItemHolder)localObject2).a().jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localObject1);
                ((ItemHolder)localObject2).a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView = ((AsyncImageView)paramView.findViewById(2131368461));
                ((ItemHolder)localObject2).a().jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView = ((MessageProgressTextView)paramView.findViewById(2131368478));
                ((ItemHolder)localObject2).a().jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramView.findViewById(2131376162));
                ((ItemHolder)localObject2).a().jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131377852));
                ((ItemHolder)localObject2).a().jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131364684));
                ((ItemHolder)localObject2).a().jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380050));
                if (!((DataLineMsgSet)localObject3).isSendFromLocal())
                {
                  ((ItemHolder)localObject2).a().jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380049));
                  ((ItemHolder)localObject2).a().jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131368381));
                  ((ItemHolder)localObject2).a().jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131377724));
                }
                if (((DataLineMsgSet)localObject3).isSendFromLocal())
                {
                  ((ItemHolder)localObject2).a().jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
                  ((ItemHolder)localObject2).a().jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setVisibility(0);
                  a((ItemHolder)localObject2, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
                }
                else
                {
                  ((ItemHolder)localObject2).a().jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
                  ((ItemHolder)localObject2).a().jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setVisibility(8);
                }
                ((ItemHolder)localObject2).a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setAsyncClipSize(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
                ((ItemHolder)localObject2).a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setDefaultImageByMargin();
                if (!BaseBubbleBuilder.jdField_a_of_type_Boolean)
                {
                  ((ItemHolder)localObject2).a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setAdjustViewBounds(true);
                }
                else
                {
                  localObject1 = new AIOSendMask(2130706432, this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.a() * 12.0F);
                  ((ItemHolder)localObject2).a().jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setBackgroundDrawable((Drawable)localObject1);
                  j = (int)TypedValue.applyDimension(2, 15.0F, this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics());
                  ((ItemHolder)localObject2).a().jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setDisplayInTextView(false, j, -1);
                }
                ((ItemHolder)localObject2).a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setIsDrawRound(true);
                ((ItemHolder)localObject2).a().jdField_a_of_type_AndroidWidgetRelativeLayout.setContentDescription(HardCodeUtil.a(2131702921));
                ((ItemHolder)localObject2).a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setContentDescription(HardCodeUtil.a(2131702929));
                break;
              case 0: 
              case 7: 
                localObject1 = (RelativeLayout)this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559033, null);
                ((ItemHolder)localObject2).jdField_a_of_type_AndroidWidgetRelativeLayout.addView((View)localObject1);
                ((ItemHolder)localObject2).a().jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localObject1);
                ((ItemHolder)localObject2).a().jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378460));
                ((ItemHolder)localObject2).a().jdField_a_of_type_AndroidWidgetRelativeLayout.setAddStatesFromChildren(true);
                ((ItemHolder)localObject2).a().jdField_a_of_type_AndroidWidgetTextView.setTag(localObject2);
                ((ItemHolder)localObject2).a().jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
                ((ItemHolder)localObject2).a().jdField_a_of_type_AndroidWidgetTextView.setClickable(true);
                ((ItemHolder)localObject2).a().jdField_a_of_type_AndroidWidgetTextView.setOnLongClickListener(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.jdField_a_of_type_AndroidViewView$OnLongClickListener);
                ((ItemHolder)localObject2).a().jdField_a_of_type_AndroidWidgetTextView.setOnTouchListener(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.jdField_a_of_type_AndroidViewView$OnTouchListener);
                ((ItemHolder)localObject2).a().jdField_a_of_type_AndroidWidgetTextView.setLongClickable(true);
                ((ItemHolder)localObject2).a().jdField_a_of_type_AndroidWidgetTextView.setMovementMethod(LinkMovementMethod.getInstance());
                ((ItemHolder)localObject2).a().jdField_a_of_type_AndroidWidgetTextView.setSpannableFactory(QQText.SPANNABLE_FACTORY);
                if (((DataLineMsgSet)localObject3).isSendFromLocal()) {
                  localObject1 = this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131167079);
                } else {
                  localObject1 = this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131167075);
                }
                ((ItemHolder)localObject2).a().jdField_a_of_type_AndroidWidgetTextView.setTextColor((ColorStateList)localObject1);
                ((ItemHolder)localObject2).a((ProgressBar)paramView.findViewById(2131377251));
                if (((ItemHolder)localObject2).a() != null) {
                  ((ItemHolder)localObject2).a().setVisibility(8);
                }
                break;
              }
              ((ItemHolder)localObject2).a((ImageView)paramView.findViewById(2131366284));
              ((ItemHolder)localObject2).a((TextView)paramView.findViewById(2131365421));
            }
          }
        }
        paramView.setTag(localObject2);
        localObject1 = localObject2;
      }
      else
      {
        localObject1 = (ItemHolder)paramView.getTag();
      }
      ((ItemHolder)localObject1).a((DataLineMsgSet)localObject3);
      if (i != 12) {
        if (i == 14)
        {
          if (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
          {
            localObject2 = (ChatBackgroundDrawable)this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.jdField_a_of_type_ComTencentWidgetXPanelContainer.getTag(2131361812);
            if (localObject2 != null)
            {
              i = ChatBackground.a(((ChatBackgroundDrawable)localObject2).getBitmap());
              ((ItemHolder)localObject1).a().jdField_a_of_type_AndroidWidgetTextView.setTextColor(ColorStateList.valueOf(i));
            }
          }
        }
        else if (i == 15)
        {
          localObject1 = ((ItemHolder)localObject1).a();
          localObject2 = FileManagerUtil.a(localDataLineMsgRecord.getExtInfoFromExtStr("tim_aio_file_tips"), localDataLineMsgRecord.getExtInfoFromExtStr("tim_aio_file_link"), new DatalineSessionAdapter.4(this, localDataLineMsgRecord));
          ((ItemHolder.TipHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
          ((ItemHolder.TipHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView.setMovementMethod(LinkMovementMethod.getInstance());
          ((ItemHolder.TipHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView.setHighlightColor(17170445);
        }
        else
        {
          if (i == 16)
          {
            localObject2 = ((ItemHolder)localObject1).a();
            if ((localDataLineMsgRecord != null) && (!TextUtils.isEmpty(localDataLineMsgRecord.msg)) && (((ItemHolder.TipHolder)localObject2).jdField_a_of_type_AndroidWidgetTextView != null) && (localDataLineMsgRecord.msg.indexOf(HardCodeUtil.a(2131702924)) >= 0))
            {
              localObject1 = FileManagerUtil.a(localDataLineMsgRecord.msg, HardCodeUtil.a(2131702912), new DatalineSessionAdapter.5(this, localDataLineMsgRecord));
              ((ItemHolder.TipHolder)localObject2).jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
              ((ItemHolder.TipHolder)localObject2).jdField_a_of_type_AndroidWidgetTextView.setMovementMethod(LinkMovementMethod.getInstance());
              ((ItemHolder.TipHolder)localObject2).jdField_a_of_type_AndroidWidgetTextView.setHighlightColor(17170445);
              break label3897;
            }
          }
          switch (i)
          {
          case 4: 
          default: 
            break;
          case 6: 
            a((ItemHolder)localObject1, (DataLineMsgSet)localObject3);
            break;
          case 5: 
            b((ItemHolder)localObject1, (DataLineMsgSet)localObject3);
            break;
          case 3: 
          case 10: 
            a((ItemHolder)localObject1, (DataLineMsgSet)localObject3);
            break;
          case 2: 
          case 9: 
            b((ItemHolder)localObject1, (DataLineMsgSet)localObject3);
            break;
          case 1: 
          case 8: 
            c((ItemHolder)localObject1, (DataLineMsgSet)localObject3);
            break;
          case 0: 
          case 7: 
            ((ItemHolder)localObject1).a().jdField_a_of_type_JavaLangString = localDataLineMsgRecord.msg;
            ((ItemHolder)localObject1).a().jdField_a_of_type_Long = localDataLineMsgRecord.sessionid;
            localObject2 = ((ItemHolder)localObject1).a().jdField_a_of_type_AndroidWidgetTextView;
            localObject4 = AppConstants.DATALINE_PC_UIN;
            localObject4 = new QQText(localDataLineMsgRecord.msg, 13, 32, 6000);
            ((QQText)localObject4).setBizSrc("biz_src_jc_aio");
            ((TextView)localObject2).setText((CharSequence)localObject4);
            ((TextView)localObject2).setVisibility(0);
            if (((ItemHolder)localObject1).a() != null) {
              if ((localDataLineMsgRecord.issuc) && (localDataLineMsgRecord.progress != 1.0F)) {
                ((ItemHolder)localObject1).a().setVisibility(0);
              } else {
                ((ItemHolder)localObject1).a().setVisibility(8);
              }
            }
            ((TextView)localObject2).setTextSize(0, ChatTextSizeSettingActivity.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext()));
          }
          if (a(i))
          {
            a(i, (ItemHolder)localObject1, (DataLineMsgSet)localObject3);
          }
          else
          {
            a(localDataLineMsgRecord, ((ItemHolder)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout, (ItemHolder)localObject1);
            if (ThemeUtil.isDefaultTheme())
            {
              i = ((ItemHolder)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.getPaddingLeft();
              j = ((ItemHolder)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.getPaddingRight();
              int k = ((ItemHolder)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.getPaddingTop();
              int m = ((ItemHolder)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.getPaddingBottom();
              if (!((DataLineMsgSet)localObject3).isSendFromLocal()) {
                ((ItemHolder)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(i + (int)(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.a() * 2.0F), k, j, m);
              } else {
                ((ItemHolder)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(i, k, j + (int)(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.a() * 2.0F), m);
              }
            }
            if (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
            {
              localObject2 = (ChatBackgroundDrawable)this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.jdField_a_of_type_ComTencentWidgetXPanelContainer.getTag(2131361812);
              if (localObject2 != null)
              {
                i = ChatBackground.a(((ChatBackgroundDrawable)localObject2).getBitmap());
                ((ItemHolder)localObject1).a().setTextColor(ColorStateList.valueOf(i));
              }
            }
            if (a(((DataLineMsgSet)localObject3).getMsgId()))
            {
              localObject2 = TimeFormatterUtils.a(this.jdField_a_of_type_AndroidContentContext, 3, ((DataLineMsgSet)localObject3).getTime() * 1000L);
              ((ItemHolder)localObject1).a().setVisibility(0);
              ((ItemHolder)localObject1).a().setText((CharSequence)localObject2);
            }
            else
            {
              ((ItemHolder)localObject1).a().setVisibility(8);
            }
            d((ItemHolder)localObject1, (DataLineMsgSet)localObject3);
          }
        }
      }
    }
    EventCollector.getInstance().onListGetView(paramInt, (View)localObject1, paramViewGroup, getItemId(paramInt));
    return paramView;
  }
  
  public int getViewTypeCount()
  {
    return 17;
  }
  
  public void notifyDataSetChanged()
  {
    super.notifyDataSetChanged();
    c();
    if (QLog.isColorLevel()) {
      QLog.d("DatalineSessionAdapter", 2, " notifyDataSetChanged ---------->");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.dataline.util.DatalineSessionAdapter
 * JD-Core Version:    0.7.0.1
 */