package com.dataline.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.util.TypedValue;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.dataline.activities.LiteActivity;
import com.dataline.util.file.FileUtil;
import com.dataline.util.widget.AsyncImageView;
import com.etrump.mixlayout.FontManager;
import com.rookery.translate.model.TransDiskCache;
import com.rookery.translate.model.Trans_entity;
import com.rookery.translate.model.TranslateCache;
import com.rookery.translate.util.LocaleUtil;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.ChatTextSizeSettingActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.ChatBackground;
import com.tencent.mobileqq.activity.aio.item.AIOSendMask;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SVIPHandler;
import com.tencent.mobileqq.app.message.DatalineMessageManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.proxy.DataLineMsgProxy;
import com.tencent.mobileqq.bubble.BubbleInfo;
import com.tencent.mobileqq.bubble.BubbleUtils;
import com.tencent.mobileqq.customviews.MessageProgressTextView;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;
import com.tencent.mobileqq.data.DataLineMsgSetList;
import com.tencent.mobileqq.drawable.ChatBackgroundDrawable;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;
import com.tencent.mobileqq.filemanager.fileviewer.TroopFileDetailBrowserActivity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.forward.ForwardFileOption;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import com.tencent.widget.XPanelContainer;
import da;
import db;
import dc;
import dd;
import java.io.File;

public class DatalineSessionAdapter
  extends TimeAdapter
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new db(this);
  private LiteActivity jdField_a_of_type_ComDatalineActivitiesLiteActivity;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private DataLineMsgSetList jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList;
  private boolean jdField_a_of_type_Boolean = true;
  private int b;
  private int c = -1;
  
  public DatalineSessionAdapter(Context paramContext, DataLineMsgSetList paramDataLineMsgSetList, LiteActivity paramLiteActivity, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList = paramDataLineMsgSetList;
    this.jdField_a_of_type_ComDatalineActivitiesLiteActivity = paramLiteActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.c = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.size();
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131558429);
    this.b = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131558430);
    b();
  }
  
  private void a(GridView paramGridView)
  {
    int i = (this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.getWindowManager().getDefaultDisplay().getWidth() - AIOUtils.a(147.0F, this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.getResources()) - 2) / 3;
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
    for (;;)
    {
      try
      {
        Bitmap localBitmap = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(this.jdField_a_of_type_AndroidContentContext.getResources(), 2130837620), paramInt1, paramInt2, false);
        Object localObject1 = ImageUtil.a(localBitmap, AIOUtils.a(12.0F, this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.getResources()));
        localObject3 = localObject1;
        if (localBitmap != null) {}
        localObject3 = localObject2;
      }
      catch (OutOfMemoryError localOutOfMemoryError1)
      {
        try
        {
          localBitmap.recycle();
          localObject3 = localObject1;
          if (localObject3 == null) {
            break;
          }
          localObject1 = new ClipDrawable(new BitmapDrawable(localObject3), 48, 2);
          paramItemHolder.a().jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setBackgroundDrawable((Drawable)localObject1);
          return;
        }
        catch (OutOfMemoryError localOutOfMemoryError2)
        {
          Object localObject3;
          Object localObject2;
          break label102;
        }
        localOutOfMemoryError1 = localOutOfMemoryError1;
        localObject2 = null;
      }
      label102:
      if (QLog.isColorLevel())
      {
        QLog.e("DatalineSessionAdapter", 2, "DataLineSessionAdapter OOM");
        localObject3 = localObject2;
      }
    }
    paramItemHolder.a().jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setBackgroundDrawable(null);
  }
  
  private void a(ItemHolder paramItemHolder, DataLineMsgSet paramDataLineMsgSet)
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
    int i = (int)(paramDataLineMsgSet.progress * 100.0F);
    paramItemHolder.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setIsDrawRound(false);
    FileManagerUtil.a(paramItemHolder.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView, paramDataLineMsgSet);
    paramItemHolder.a().jdField_a_of_type_AndroidWidgetTextView.setText(FileManagerUtil.d(paramDataLineMsgSet.filename));
    paramItemHolder.a().jdField_c_of_type_AndroidWidgetTextView.setText(FileUtil.a(paramDataLineMsgSet.filesize));
    if (paramDataLineMsgSet.isSendFromLocal()) {
      if (paramDataLineMsgSet.fileMsgStatus == 2L) {
        paramItemHolder.a().jdField_d_of_type_AndroidWidgetTextView.setText(2131427589);
      }
    }
    while ((paramDataLineMsgSet.progress == 1.0F) || (!paramDataLineMsgSet.issuc) || (paramDataLineMsgSet.fileMsgStatus == 1L) || (paramDataLineMsgSet.fileMsgStatus == 2L))
    {
      paramItemHolder.a().jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
      return;
      if ((paramDataLineMsgSet.progress == 1.0F) && (paramDataLineMsgSet.issuc))
      {
        paramItemHolder.a().jdField_d_of_type_AndroidWidgetTextView.setText(2131428253);
      }
      else if (!paramDataLineMsgSet.issuc)
      {
        if (paramDataLineMsgSet.nOpType == 1) {
          paramItemHolder.a().jdField_d_of_type_AndroidWidgetTextView.setText(2131428258);
        } else {
          paramItemHolder.a().jdField_d_of_type_AndroidWidgetTextView.setText(2131428257);
        }
      }
      else
      {
        paramItemHolder.a().jdField_d_of_type_AndroidWidgetTextView.setText(i + "%");
        continue;
        if (paramDataLineMsgSet.fileMsgStatus == 2L) {
          paramItemHolder.a().jdField_d_of_type_AndroidWidgetTextView.setText(2131427589);
        } else if (paramDataLineMsgSet.fileMsgStatus == 1L) {
          paramItemHolder.a().jdField_d_of_type_AndroidWidgetTextView.setText(2131428254);
        } else if ((paramDataLineMsgSet.progress == 1.0F) && (paramDataLineMsgSet.issuc)) {
          paramItemHolder.a().jdField_d_of_type_AndroidWidgetTextView.setText(2131428251);
        } else if (!paramDataLineMsgSet.issuc) {
          paramItemHolder.a().jdField_d_of_type_AndroidWidgetTextView.setText(2131428258);
        } else {
          paramItemHolder.a().jdField_d_of_type_AndroidWidgetTextView.setText(i + "%");
        }
      }
    }
    paramItemHolder.a().jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    paramItemHolder.a().jdField_a_of_type_AndroidWidgetProgressBar.setProgress(i);
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
    if ((paramDataLineMsgRecord.vipBubbleID == 100000L) && (paramDataLineMsgRecord.msgtype == -1000))
    {
      Object localObject = LocaleUtil.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext());
      localObject = TranslateCache.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext()).a(paramDataLineMsgRecord.msg, paramDataLineMsgRecord.msgId, (String)localObject);
      if ((localObject != null) && (((Trans_entity)localObject).a().booleanValue()) && (!paramDataLineMsgRecord.isSendFromLocal()))
      {
        paramItemHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo = BubbleUtils.a(100001, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext.getResources(), this);
        if (paramItemHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo != null)
        {
          paramItemHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo.a(paramRelativeLayout, null);
          if (paramDataLineMsgRecord.msgtype == -1000) {
            break label268;
          }
        }
      }
    }
    label268:
    for (boolean bool = true;; bool = false)
    {
      int i = paramDataLineMsgRecord.vipBubbleDiyTextId;
      if (i <= 0) {
        SVIPHandler.b(paramDataLineMsgRecord.vipBubbleID);
      }
      paramItemHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramDataLineMsgRecord.isSendFromLocal(), true, bool, paramRelativeLayout, FontManager.a(paramDataLineMsgRecord), i);
      if (paramDataLineMsgRecord.msgtype == -1000) {
        a(paramItemHolder, paramRelativeLayout, paramDataLineMsgRecord, paramItemHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo);
      }
      a(paramRelativeLayout, paramDataLineMsgRecord);
      return;
      paramItemHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo = BubbleUtils.a(100000, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext.getResources(), this);
      break;
      paramItemHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo = BubbleUtils.a(((SVIPHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(13)).a(paramDataLineMsgRecord), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext.getResources(), this);
      break;
    }
  }
  
  private boolean a(ItemHolder paramItemHolder, DataLineMsgSet paramDataLineMsgSet)
  {
    if (paramItemHolder == null) {}
    do
    {
      return true;
      if (paramItemHolder.a().jdField_d_of_type_ComDatalineUtilWidgetAsyncImageView == null) {
        return false;
      }
    } while (paramDataLineMsgSet == null);
    int i = paramDataLineMsgSet.getCompletedCount();
    int j = paramDataLineMsgSet.getTotalCount();
    DataLineMsgRecord localDataLineMsgRecord = paramDataLineMsgSet.getFirstItem();
    if (localDataLineMsgRecord == null) {
      return false;
    }
    if ((paramDataLineMsgSet.getAt(0) != null) && (paramDataLineMsgSet.getAt(0).strMoloIconUrl != null))
    {
      paramItemHolder.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setAsyncImage(paramDataLineMsgSet.getAt(0).strMoloIconUrl);
      if ((paramDataLineMsgSet.getTotalCount() < 2) || (paramDataLineMsgSet.getAt(1) == null) || (paramDataLineMsgSet.getAt(1).strMoloIconUrl == null)) {
        break label492;
      }
      paramItemHolder.a().jdField_b_of_type_ComDatalineUtilWidgetAsyncImageView.setAsyncImage(paramDataLineMsgSet.getAt(1).strMoloIconUrl);
      label128:
      if ((paramDataLineMsgSet.getTotalCount() < 3) || (paramDataLineMsgSet.getAt(2) == null) || (paramDataLineMsgSet.getAt(2).strMoloIconUrl == null)) {
        break label508;
      }
      paramItemHolder.a().jdField_c_of_type_ComDatalineUtilWidgetAsyncImageView.setAsyncImage(paramDataLineMsgSet.getAt(2).strMoloIconUrl);
      label173:
      if ((paramDataLineMsgSet.getTotalCount() < 4) || (paramDataLineMsgSet.getAt(3) == null) || (paramDataLineMsgSet.getAt(3).strMoloIconUrl == null)) {
        break label524;
      }
      paramItemHolder.a().jdField_d_of_type_ComDatalineUtilWidgetAsyncImageView.setAsyncImage(paramDataLineMsgSet.getAt(3).strMoloIconUrl);
      label218:
      paramItemHolder.a().jdField_a_of_type_AndroidWidgetTextView.setText(FileManagerUtil.d(paramDataLineMsgSet.getFileNames()));
      if ((localDataLineMsgRecord.strMoloSource == null) || (!localDataLineMsgRecord.strMoloSource.contains(this.jdField_a_of_type_AndroidContentContext.getString(2131427590)))) {
        break label540;
      }
      paramItemHolder.a().jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      paramItemHolder.a().jdField_a_of_type_AndroidWidgetTextView.setSingleLine(false);
      paramItemHolder.a().jdField_a_of_type_AndroidWidgetTextView.setMaxLines(2);
      label298:
      paramItemHolder.a().jdField_c_of_type_AndroidWidgetTextView.setText(FileUtil.a(paramDataLineMsgSet.getFileTotalSize()));
      if ((localDataLineMsgRecord.strMoloSource == null) || (localDataLineMsgRecord.strMoloSource.equals(""))) {
        break label578;
      }
      paramItemHolder.a().e.setText(localDataLineMsgRecord.strMoloSource);
      paramItemHolder.a().e.setVisibility(0);
      paramItemHolder.a().jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      label374:
      if ((localDataLineMsgRecord.strMoloSrcIconUrl == null) || (localDataLineMsgRecord.strMoloSrcIconUrl.equals(""))) {
        break label593;
      }
      paramItemHolder.a().jdField_a_of_type_ComTencentImageURLImageView.setImageURL(localDataLineMsgRecord.strMoloSrcIconUrl);
      paramItemHolder.a().jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
      label422:
      if (!paramDataLineMsgSet.isCanceled()) {
        break label608;
      }
      paramItemHolder.a().jdField_d_of_type_AndroidWidgetTextView.setText(2131427589);
    }
    for (;;)
    {
      if (((paramDataLineMsgSet.hasSendingOrRecving()) || (paramDataLineMsgSet.hasWaiting())) && (!paramDataLineMsgSet.isFileComing())) {
        break label709;
      }
      paramItemHolder.a().jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
      return true;
      paramItemHolder.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setImageResource(2130841612);
      break;
      label492:
      paramItemHolder.a().jdField_b_of_type_ComDatalineUtilWidgetAsyncImageView.setImageResource(2130841612);
      break label128;
      label508:
      paramItemHolder.a().jdField_c_of_type_ComDatalineUtilWidgetAsyncImageView.setImageResource(2130841612);
      break label173;
      label524:
      paramItemHolder.a().jdField_d_of_type_ComDatalineUtilWidgetAsyncImageView.setImageResource(2130841612);
      break label218;
      label540:
      paramItemHolder.a().jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      paramItemHolder.a().jdField_b_of_type_AndroidWidgetTextView.setText(2131427580);
      paramItemHolder.a().jdField_a_of_type_AndroidWidgetTextView.setSingleLine(true);
      break label298;
      label578:
      paramItemHolder.a().jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      break label374;
      label593:
      paramItemHolder.a().jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
      break label422;
      label608:
      if (paramDataLineMsgSet.isFileComing()) {
        paramItemHolder.a().jdField_d_of_type_AndroidWidgetTextView.setText(2131428254);
      } else if (i == j) {
        paramItemHolder.a().jdField_d_of_type_AndroidWidgetTextView.setText("" + j);
      } else {
        paramItemHolder.a().jdField_d_of_type_AndroidWidgetTextView.setText(i + "/" + j);
      }
    }
    label709:
    paramItemHolder.a().jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    paramItemHolder.a().jdField_a_of_type_AndroidWidgetProgressBar.setProgress((int)(paramDataLineMsgSet.getTotalProcess() * 100.0F));
    return true;
  }
  
  private void b(ItemHolder paramItemHolder, DataLineMsgSet paramDataLineMsgSet)
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
    int i = (int)(paramDataLineMsgSet.progress * 100.0F);
    if (paramDataLineMsgSet.strMoloIconUrl != null)
    {
      paramItemHolder.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setAsyncImage(paramDataLineMsgSet.strMoloIconUrl);
      paramItemHolder.a().jdField_a_of_type_AndroidWidgetTextView.setText(FileManagerUtil.d(paramDataLineMsgSet.filename));
      if ((paramDataLineMsgSet.strMoloSource == null) || (!paramDataLineMsgSet.strMoloSource.contains(this.jdField_a_of_type_AndroidContentContext.getString(2131427590)))) {
        break label332;
      }
      paramItemHolder.a().jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      paramItemHolder.a().jdField_a_of_type_AndroidWidgetTextView.setSingleLine(false);
      paramItemHolder.a().jdField_a_of_type_AndroidWidgetTextView.setMaxLines(2);
      label126:
      paramItemHolder.a().jdField_c_of_type_AndroidWidgetTextView.setText(FileUtil.a(paramDataLineMsgSet.filesize));
      if ((paramDataLineMsgSet.strMoloSource == null) || (paramDataLineMsgSet.strMoloSource.equals(""))) {
        break label370;
      }
      paramItemHolder.a().e.setText(paramDataLineMsgSet.strMoloSource);
      paramItemHolder.a().e.setVisibility(0);
      paramItemHolder.a().jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      label199:
      if ((paramDataLineMsgSet.strMoloSrcIconUrl == null) || (paramDataLineMsgSet.strMoloSrcIconUrl.equals(""))) {
        break label385;
      }
      paramItemHolder.a().jdField_a_of_type_ComTencentImageURLImageView.setImageURL(paramDataLineMsgSet.strMoloSrcIconUrl);
      paramItemHolder.a().jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
      label244:
      if (paramDataLineMsgSet.fileMsgStatus != 2L) {
        break label400;
      }
      paramItemHolder.a().jdField_d_of_type_AndroidWidgetTextView.setText(2131427589);
    }
    for (;;)
    {
      if ((paramDataLineMsgSet.progress != 1.0F) && (paramDataLineMsgSet.issuc) && (paramDataLineMsgSet.fileMsgStatus != 1L) && (paramDataLineMsgSet.fileMsgStatus != 2L)) {
        break label513;
      }
      paramItemHolder.a().jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
      return;
      paramItemHolder.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setImageResource(2130841612);
      break;
      label332:
      paramItemHolder.a().jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      paramItemHolder.a().jdField_b_of_type_AndroidWidgetTextView.setText(2131427580);
      paramItemHolder.a().jdField_a_of_type_AndroidWidgetTextView.setSingleLine(true);
      break label126;
      label370:
      paramItemHolder.a().jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      break label199;
      label385:
      paramItemHolder.a().jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
      break label244;
      label400:
      if (paramDataLineMsgSet.fileMsgStatus == 1L) {
        paramItemHolder.a().jdField_d_of_type_AndroidWidgetTextView.setText(2131428254);
      } else if ((paramDataLineMsgSet.progress == 1.0F) && (paramDataLineMsgSet.issuc)) {
        paramItemHolder.a().jdField_d_of_type_AndroidWidgetTextView.setText(2131428251);
      } else if (!paramDataLineMsgSet.issuc) {
        paramItemHolder.a().jdField_d_of_type_AndroidWidgetTextView.setText(2131428258);
      } else {
        paramItemHolder.a().jdField_d_of_type_AndroidWidgetTextView.setText(i + "%");
      }
    }
    label513:
    paramItemHolder.a().jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    paramItemHolder.a().jdField_a_of_type_AndroidWidgetProgressBar.setProgress(i);
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
    return (this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList == null) || (this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.size() == 0);
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
    int i = paramDataLineMsgSet.getCompletedCount();
    int j = paramDataLineMsgSet.getTotalCount();
    DataLineMsgRecord localDataLineMsgRecord = paramDataLineMsgSet.getFirstItem();
    if (localDataLineMsgRecord == null) {
      return false;
    }
    dd localdd;
    label148:
    label313:
    if (i == j)
    {
      paramItemHolder.a().jdField_a_of_type_AndroidWidgetTextView.setText("" + j);
      i = ((Integer)paramItemHolder.a().jdField_a_of_type_AndroidWidgetGridView.getTag()).intValue();
      localdd = (dd)paramItemHolder.a().jdField_a_of_type_AndroidWidgetGridView.getAdapter();
      if (localdd != null) {
        break label401;
      }
      localdd = new dd(this, paramItemHolder, paramDataLineMsgSet, i, null);
      paramItemHolder.a().jdField_a_of_type_AndroidWidgetGridView.setAdapter(localdd);
      paramItemHolder.a().jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      paramDataLineMsgSet.printlog();
      if (((paramDataLineMsgSet.hasSendingOrRecving()) || (paramDataLineMsgSet.hasWaiting())) && (!paramDataLineMsgSet.isFileComing())) {
        break label455;
      }
      paramItemHolder.a().jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
      if (!paramDataLineMsgSet.isCanceled()) {
        break label421;
      }
      paramItemHolder.a().jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      paramItemHolder.a().jdField_b_of_type_AndroidWidgetTextView.setText(2131427589);
      label227:
      if (!paramDataLineMsgSet.isSendFromLocal())
      {
        paramItemHolder.a().jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        if (localDataLineMsgRecord.strMoloKey != null)
        {
          if ((localDataLineMsgRecord.strMoloSource == null) || (localDataLineMsgRecord.strMoloSource.equals(""))) {
            break label487;
          }
          paramItemHolder.a().jdField_c_of_type_AndroidWidgetTextView.setText(localDataLineMsgRecord.strMoloSource);
          paramItemHolder.a().jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
          paramItemHolder.a().jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
          if ((localDataLineMsgRecord.strMoloSrcIconUrl == null) || (localDataLineMsgRecord.strMoloSrcIconUrl.equals(""))) {
            break label502;
          }
          paramItemHolder.a().jdField_a_of_type_ComTencentImageURLImageView.setImageURL(localDataLineMsgRecord.strMoloSrcIconUrl);
          paramItemHolder.a().jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
        }
      }
    }
    for (;;)
    {
      return true;
      paramItemHolder.a().jdField_a_of_type_AndroidWidgetTextView.setText(i + "/" + j);
      break;
      label401:
      localdd.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet = paramDataLineMsgSet;
      localdd.jdField_a_of_type_ComDatalineUtilItemHolder = paramItemHolder;
      localdd.a();
      break label148;
      label421:
      if (!paramDataLineMsgSet.isFileComing()) {
        break label227;
      }
      paramItemHolder.a().jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      paramItemHolder.a().jdField_b_of_type_AndroidWidgetTextView.setText(2131428254);
      break label227;
      label455:
      paramItemHolder.a().jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      paramItemHolder.a().jdField_a_of_type_AndroidWidgetProgressBar.setProgress((int)(paramDataLineMsgSet.getTotalProcess() * 100.0F));
      break label227;
      label487:
      paramItemHolder.a().jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      break label313;
      label502:
      paramItemHolder.a().jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
    }
  }
  
  private void c(ItemHolder paramItemHolder, DataLineMsgSet paramDataLineMsgSet)
  {
    if (paramItemHolder == null) {}
    DataLineMsgRecord localDataLineMsgRecord;
    do
    {
      do
      {
        return;
      } while (paramDataLineMsgSet == null);
      localDataLineMsgRecord = paramDataLineMsgSet.getFirstItem();
    } while (localDataLineMsgRecord == null);
    paramItemHolder.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setAsyncClipSize(this.jdField_a_of_type_Int, this.b);
    paramItemHolder.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setDefaultImageByMargin();
    paramItemHolder.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setIsDrawRound(true);
    paramItemHolder.a().jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    paramItemHolder.a().jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    label316:
    if ((localDataLineMsgRecord.path != null) && (new File(localDataLineMsgRecord.path).exists()))
    {
      paramItemHolder.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setAsyncImage(localDataLineMsgRecord.path);
      label124:
      if ((localDataLineMsgRecord.progress != 1.0F) && (localDataLineMsgRecord.issuc) && (localDataLineMsgRecord.fileMsgStatus != 1L) && (localDataLineMsgRecord.fileMsgStatus != 2L)) {
        break label476;
      }
      paramItemHolder.a().jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setVisibility(8);
      paramItemHolder.a().jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      if ((localDataLineMsgRecord.fileMsgStatus != 1L) || (localDataLineMsgRecord.thumbPath != null)) {
        break label461;
      }
      paramItemHolder.a().jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      paramItemHolder.a().jdField_a_of_type_AndroidWidgetTextView.setText(2131427555);
      label230:
      if (!paramDataLineMsgSet.isSendFromLocal())
      {
        paramItemHolder.a().jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        if (localDataLineMsgRecord.strMoloKey != null)
        {
          if ((localDataLineMsgRecord.strMoloSource == null) || (localDataLineMsgRecord.strMoloSource.equals(""))) {
            break label533;
          }
          paramItemHolder.a().jdField_c_of_type_AndroidWidgetTextView.setText(localDataLineMsgRecord.strMoloSource);
          paramItemHolder.a().jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
          paramItemHolder.a().jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
          if ((localDataLineMsgRecord.strMoloSrcIconUrl == null) || (localDataLineMsgRecord.strMoloSrcIconUrl.equals(""))) {
            break label548;
          }
          paramItemHolder.a().jdField_a_of_type_ComTencentImageURLImageView.setImageURL(localDataLineMsgRecord.strMoloSrcIconUrl);
          paramItemHolder.a().jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
        }
      }
    }
    for (;;)
    {
      if (paramItemHolder.a().jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
        paramItemHolder.a().jdField_a_of_type_AndroidWidgetRelativeLayout.setContentDescription("图片");
      }
      if (paramItemHolder.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView == null) {
        break;
      }
      paramItemHolder.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setContentDescription("图片");
      return;
      if ((localDataLineMsgRecord.thumbPath != null) && (localDataLineMsgRecord.thumbPath.length() > 0))
      {
        paramItemHolder.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setAsyncImage(localDataLineMsgRecord.thumbPath);
        break label124;
      }
      paramItemHolder.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setImageDrawableDefault();
      break label124;
      label461:
      paramItemHolder.a().jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      break label230;
      label476:
      if (localDataLineMsgRecord.isSendFromLocal())
      {
        paramItemHolder.a().jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setVisibility(0);
        int i = (int)(localDataLineMsgRecord.progress * 100.0F);
        paramItemHolder.a().jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setProgress(i);
        break label230;
      }
      paramItemHolder.a().jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      break label230;
      label533:
      paramItemHolder.a().jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      break label316;
      label548:
      paramItemHolder.a().jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
    }
  }
  
  private void d(ItemHolder paramItemHolder, DataLineMsgSet paramDataLineMsgSet)
  {
    if (paramItemHolder == null) {}
    while (paramDataLineMsgSet == null) {
      return;
    }
    paramItemHolder.jdField_a_of_type_AndroidWidgetImageView.setTag(paramItemHolder);
    if ((paramDataLineMsgSet.isSendFromLocal()) && (paramDataLineMsgSet.hasFailed()) && (!paramDataLineMsgSet.hasSendingOrRecving()) && (!paramDataLineMsgSet.hasWaiting())) {}
    for (int i = 1; i == 0; i = 0)
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
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = false;
    new Handler().postDelayed(new da(this), 1500L);
  }
  
  public void a(long paramLong, ListView paramListView, float paramFloat)
  {
    Object localObject = null;
    if (paramListView == null) {}
    label7:
    int i;
    DataLineMsgSet localDataLineMsgSet;
    label250:
    do
    {
      float f;
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              i = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.getSetIndex(paramLong);
            } while (i == -1);
            paramListView = paramListView.getChildAt(i - paramListView.getFirstVisiblePosition());
          } while ((paramListView == null) || (i >= this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.size()));
          localDataLineMsgSet = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.get(i);
          if (localDataLineMsgSet.mUpdateProcessTick == 0L) {}
          for (localDataLineMsgSet.mUpdateProcessTick = System.currentTimeMillis();; localDataLineMsgSet.mUpdateProcessTick = System.currentTimeMillis())
          {
            if (!localDataLineMsgSet.isSingle()) {
              break label354;
            }
            i = DataLineMsgRecord.getDevTypeBySeId(paramLong);
            localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(i).a(paramLong);
            if (localObject == null) {
              break;
            }
            f = paramFloat;
            if (paramFloat < ((DataLineMsgRecord)localObject).progress) {
              f = ((DataLineMsgRecord)localObject).progress;
            }
            switch (((DataLineMsgRecord)localObject).msgtype)
            {
            default: 
              return;
            case -2335: 
            case -2009: 
            case -2005: 
              if (!((DataLineMsgRecord)localObject).bIsMoloImage) {
                break label250;
              }
              paramListView = (MessageProgressTextView)paramListView.findViewById(2131364159);
              if (paramListView == null) {
                break label7;
              }
              paramListView.setProgress((int)(f * 100.0F));
              return;
              if (System.currentTimeMillis() - localDataLineMsgSet.mUpdateProcessTick < 1000L) {
                break label7;
              }
            }
          }
          localObject = (TextView)paramListView.findViewById(2131364141);
          paramListView = (ProgressBar)paramListView.findViewById(2131364142);
          if (paramListView != null)
          {
            paramListView.setVisibility(0);
            paramListView.setProgress((int)(f * 100.0F));
          }
        } while (localObject == null);
        ((TextView)localObject).setText((int)(f * 100.0F) + "%");
        return;
        paramListView = (MessageProgressTextView)paramListView.findViewById(2131364159);
      } while (paramListView == null);
      paramListView.setProgress((int)(f * 100.0F));
      return;
      paramListView = (ItemHolder)paramListView.getTag();
    } while (paramListView == null);
    label354:
    int j;
    switch (localDataLineMsgSet.getGroupType())
    {
    default: 
      paramListView = null;
      label414:
      i = localDataLineMsgSet.getCompletedCount();
      j = localDataLineMsgSet.getTotalCount();
      if (localObject != null)
      {
        if (i != j) {
          break label514;
        }
        ((TextView)localObject).setText("" + j);
      }
      break;
    }
    while (paramListView != null)
    {
      if (i != j) {
        break label548;
      }
      paramListView.setVisibility(4);
      return;
      localObject = paramListView.a().jdField_d_of_type_AndroidWidgetTextView;
      paramListView = paramListView.a().jdField_a_of_type_AndroidWidgetProgressBar;
      break label414;
      paramListView = paramListView.a().jdField_a_of_type_AndroidWidgetProgressBar;
      break label414;
      label514:
      ((TextView)localObject).setText(i + "/" + j);
    }
    label548:
    paramListView.setVisibility(0);
    paramListView.setProgress((int)(localDataLineMsgSet.getTotalProcess() * 100.0F));
  }
  
  protected void a(View paramView, DataLineMsgRecord paramDataLineMsgRecord)
  {
    if (paramDataLineMsgRecord.isSendFromLocal())
    {
      paramView.setPadding(BaseChatItemLayout.j, BaseChatItemLayout.g, BaseChatItemLayout.i, BaseChatItemLayout.h);
      return;
    }
    paramView.setPadding(BaseChatItemLayout.i, BaseChatItemLayout.g, BaseChatItemLayout.j, BaseChatItemLayout.h);
  }
  
  protected void a(ItemHolder paramItemHolder, View paramView, DataLineMsgRecord paramDataLineMsgRecord, BubbleInfo paramBubbleInfo)
  {
    if (paramBubbleInfo == null) {
      return;
    }
    if ((paramBubbleInfo.jdField_a_of_type_Int == 0) || (!paramBubbleInfo.a()))
    {
      paramBubbleInfo = paramView.getResources();
      if (paramDataLineMsgRecord.isSendFromLocal())
      {
        paramView = paramBubbleInfo.getColorStateList(2131494236);
        paramItemHolder.a().jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramView);
        if (!paramDataLineMsgRecord.isSendFromLocal()) {
          break label95;
        }
      }
      label95:
      for (paramView = paramBubbleInfo.getColorStateList(2131494235);; paramView = paramBubbleInfo.getColorStateList(2131494234))
      {
        paramItemHolder.a().jdField_a_of_type_AndroidWidgetTextView.setLinkTextColor(paramView);
        return;
        paramView = paramBubbleInfo.getColorStateList(2131494233);
        break;
      }
    }
    if (paramBubbleInfo.b == 0) {
      paramItemHolder.a().jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
    }
    while (paramBubbleInfo.c == 0)
    {
      paramItemHolder.a().jdField_a_of_type_AndroidWidgetTextView.setLinkTextColor(paramView.getResources().getColorStateList(2131494234));
      return;
      paramItemHolder.a().jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramBubbleInfo.b);
    }
    paramItemHolder.a().jdField_a_of_type_AndroidWidgetTextView.setLinkTextColor(paramBubbleInfo.c);
  }
  
  public void a(DataLineMsgSetList paramDataLineMsgSetList)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList = paramDataLineMsgSetList;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean a(long paramLong, ListView paramListView)
  {
    int i = DataLineMsgRecord.getDevTypeBySeId(paramLong);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(i).b(paramLong);
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
      if (paramListView.mUpdateMutiViewTick != 0L) {
        break label138;
      }
    }
    for (paramListView.mUpdateMutiViewTick = System.currentTimeMillis(); paramListView.isSingle(); paramListView.mUpdateMutiViewTick = System.currentTimeMillis())
    {
      return true;
      label138:
      if (System.currentTimeMillis() - paramListView.mUpdateMutiViewTick < 1000L) {
        return true;
      }
    }
    localObject = (ItemHolder)localView.getTag();
    if (localObject == null) {
      return false;
    }
    switch (paramListView.getGroupType())
    {
    }
    do
    {
      do
      {
        do
        {
          d((ItemHolder)localObject, paramListView);
          return true;
          if (!paramListView.getFirstItem().bIsMoloImage) {
            break;
          }
        } while (b((ItemHolder)localObject, paramListView));
        return false;
      } while (a((ItemHolder)localObject, paramListView));
      return false;
    } while (b((ItemHolder)localObject, paramListView));
    return false;
  }
  
  public long b(int paramInt)
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.get(paramInt).getMsgId();
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
    int i = 1;
    if (b()) {
      paramInt = 13;
    }
    label121:
    DataLineMsgRecord localDataLineMsgRecord;
    do
    {
      DataLineMsgSet localDataLineMsgSet;
      boolean bool;
      do
      {
        return paramInt;
        localDataLineMsgSet = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.get(paramInt);
        bool = localDataLineMsgSet.isSendFromLocal();
        switch (localDataLineMsgSet.getGroupType())
        {
        default: 
          return 12;
        case -1000: 
          if (bool) {
            return 7;
          }
          return 0;
        case -2000: 
          if (!localDataLineMsgSet.isSingle()) {
            break label121;
          }
          paramInt = i;
        }
      } while (!bool);
      return 8;
      if (bool) {
        return 9;
      }
      return 2;
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
      localDataLineMsgRecord = localDataLineMsgSet.getFirstItem();
      if (!localDataLineMsgSet.isSingle()) {
        break;
      }
      paramInt = i;
    } while (localDataLineMsgRecord.bIsMoloImage);
    return 5;
    if (localDataLineMsgRecord.bIsMoloImage) {
      return 2;
    }
    return 6;
    return 14;
  }
  
  @TargetApi(8)
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject1;
    if (b())
    {
      if (paramView == null)
      {
        paramViewGroup = new ItemHolder();
        paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130968905, null);
        localObject1 = (TextView)paramView.findViewById(2131364224);
        localObject2 = (ImageView)paramView.findViewById(2131364223);
        if (this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.jdField_a_of_type_Int == 1)
        {
          ((TextView)localObject1).setText(2131427535);
          ((ImageView)localObject2).setImageResource(2130838726);
        }
        paramView.setTag(paramViewGroup);
      }
      for (;;)
      {
        paramView.setVisibility(4);
        this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.s();
        localObject1 = paramView;
        return localObject1;
        paramViewGroup = (ItemHolder)paramView.getTag();
      }
    }
    this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.s();
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.get(paramInt);
    if (localObject2 == null) {
      return null;
    }
    paramInt = getItemViewType(paramInt);
    DataLineMsgRecord localDataLineMsgRecord = ((DataLineMsgSet)localObject2).getFirstItem();
    if (paramView == null)
    {
      localObject1 = new ItemHolder();
      if (paramInt == 12)
      {
        paramViewGroup = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130968893, null);
        ((ItemHolder)localObject1).b((TextView)paramViewGroup.findViewById(2131364199));
        paramView = paramViewGroup;
        if (((ItemHolder)localObject1).b() != null)
        {
          ((ItemHolder)localObject1).b().setText(2131427521);
          paramView = paramViewGroup;
        }
        label222:
        paramView.setTag(localObject1);
      }
    }
    Object localObject3;
    int i;
    for (paramViewGroup = (ViewGroup)localObject1;; paramViewGroup = (ItemHolder)paramView.getTag())
    {
      paramViewGroup.a((DataLineMsgSet)localObject2);
      localObject1 = paramView;
      if (paramInt == 12) {
        break;
      }
      if (paramInt != 14) {
        break label2924;
      }
      localObject1 = paramView;
      if (!ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
        break;
      }
      localObject2 = (ChatBackgroundDrawable)this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.jdField_a_of_type_ComTencentWidgetXPanelContainer.getTag(2131362037);
      localObject1 = paramView;
      if (localObject2 == null) {
        break;
      }
      paramInt = ChatBackground.a(((ChatBackgroundDrawable)localObject2).getBitmap());
      paramViewGroup.a().jdField_a_of_type_AndroidWidgetTextView.setTextColor(ColorStateList.valueOf(paramInt));
      return paramView;
      if (paramInt == 14)
      {
        paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130968882, null);
        paramViewGroup = ((ItemHolder)localObject1).a();
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131363813));
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setMaxLines(2);
        localObject3 = new SpannableString("还想把文件发到好友手机？快来用\n" + "面对面快传" + "！无需网络，免流量！");
        ((SpannableString)localObject3).setSpan(new dc(this), "还想把文件发到好友手机？快来用\n".length(), "还想把文件发到好友手机？快来用\n".length() + "面对面快传".length(), 33);
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setHighlightColor(0);
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject3);
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setMovementMethod(LinkMovementMethod.getInstance());
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        break label222;
      }
      if (!((DataLineMsgSet)localObject2).isSendFromLocal())
      {
        paramViewGroup = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130968894, null);
        localObject3 = (ImageView)paramViewGroup.findViewById(2131362724);
        paramView = this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.getResources().getDrawable(2130841615);
        i = DataLineMsgRecord.getDevTypeBySet((DataLineMsgSet)localObject2);
        if (i == 0)
        {
          paramView = this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.getResources().getDrawable(2130841615);
          label544:
          ((ImageView)localObject3).setImageDrawable(paramView);
          paramView = paramViewGroup;
          label552:
          ((ItemHolder)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131364178));
          ((ItemHolder)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(localObject1);
          ((ItemHolder)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.setClickable(true);
          ((ItemHolder)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.setLongClickable(true);
          ((ItemHolder)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
          ((ItemHolder)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.setOnLongClickListener(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.jdField_a_of_type_AndroidViewView$OnLongClickListener);
          ((ItemHolder)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.setOnTouchListener(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.jdField_a_of_type_AndroidViewView$OnTouchListener);
          ((ItemHolder)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.setAddStatesFromChildren(true);
          switch (paramInt)
          {
          }
        }
      }
      for (;;)
      {
        ((ItemHolder)localObject1).a((ImageView)paramView.findViewById(2131364156));
        ((ItemHolder)localObject1).a((TextView)paramView.findViewById(2131363547));
        break;
        if (i != 1) {
          break label544;
        }
        paramView = this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.getResources().getDrawable(2130841613);
        break label544;
        paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130968900, null);
        break label552;
        paramViewGroup = (RelativeLayout)this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130968901, null);
        ((ItemHolder)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.addView(paramViewGroup);
        ((ItemHolder)localObject1).a().jdField_a_of_type_AndroidWidgetRelativeLayout = paramViewGroup;
        ((ItemHolder)localObject1).a().jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131363651));
        ((ItemHolder)localObject1).a().jdField_a_of_type_AndroidWidgetRelativeLayout.setAddStatesFromChildren(true);
        ((ItemHolder)localObject1).a().jdField_a_of_type_AndroidWidgetTextView.setTag(localObject1);
        ((ItemHolder)localObject1).a().jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        ((ItemHolder)localObject1).a().jdField_a_of_type_AndroidWidgetTextView.setClickable(true);
        ((ItemHolder)localObject1).a().jdField_a_of_type_AndroidWidgetTextView.setOnLongClickListener(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.jdField_a_of_type_AndroidViewView$OnLongClickListener);
        ((ItemHolder)localObject1).a().jdField_a_of_type_AndroidWidgetTextView.setOnTouchListener(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.jdField_a_of_type_AndroidViewView$OnTouchListener);
        ((ItemHolder)localObject1).a().jdField_a_of_type_AndroidWidgetTextView.setLongClickable(true);
        ((ItemHolder)localObject1).a().jdField_a_of_type_AndroidWidgetTextView.setMovementMethod(LinkMovementMethod.getInstance());
        ((ItemHolder)localObject1).a().jdField_a_of_type_AndroidWidgetTextView.setSpannableFactory(QQText.a);
        if (((DataLineMsgSet)localObject2).isSendFromLocal()) {}
        for (paramViewGroup = this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131494236);; paramViewGroup = this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131494233))
        {
          ((ItemHolder)localObject1).a().jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramViewGroup);
          ((ItemHolder)localObject1).a((ProgressBar)paramView.findViewById(2131364219));
          if (((ItemHolder)localObject1).a() == null) {
            break;
          }
          ((ItemHolder)localObject1).a().setVisibility(8);
          break;
        }
        paramViewGroup = (RelativeLayout)this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130968883, null);
        ((ItemHolder)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.addView(paramViewGroup);
        ((ItemHolder)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.setGravity(17);
        ((ItemHolder)localObject1).a().jdField_a_of_type_AndroidWidgetRelativeLayout = paramViewGroup;
        ((ItemHolder)localObject1).a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView = ((AsyncImageView)paramView.findViewById(2131361846));
        ((ItemHolder)localObject1).a().jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView = ((MessageProgressTextView)paramView.findViewById(2131364159));
        ((ItemHolder)localObject1).a().jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramView.findViewById(2131364160));
        ((ItemHolder)localObject1).a().jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131364203));
        ((ItemHolder)localObject1).a().jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131364161));
        ((ItemHolder)localObject1).a().jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131364204));
        if (!((DataLineMsgSet)localObject2).isSendFromLocal())
        {
          ((ItemHolder)localObject1).a().jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131364202));
          ((ItemHolder)localObject1).a().jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131364201));
          ((ItemHolder)localObject1).a().jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131364200));
        }
        if (((DataLineMsgSet)localObject2).isSendFromLocal())
        {
          ((ItemHolder)localObject1).a().jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
          ((ItemHolder)localObject1).a().jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setVisibility(0);
          a((ItemHolder)localObject1, this.jdField_a_of_type_Int, this.b);
          label1301:
          ((ItemHolder)localObject1).a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setAsyncClipSize(this.jdField_a_of_type_Int, this.b);
          ((ItemHolder)localObject1).a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setDefaultImageByMargin();
          if (BaseBubbleBuilder.jdField_a_of_type_Boolean) {
            break label1420;
          }
          ((ItemHolder)localObject1).a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setAdjustViewBounds(true);
        }
        for (;;)
        {
          ((ItemHolder)localObject1).a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setIsDrawRound(true);
          ((ItemHolder)localObject1).a().jdField_a_of_type_AndroidWidgetRelativeLayout.setContentDescription("图片");
          ((ItemHolder)localObject1).a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setContentDescription("图片");
          break;
          ((ItemHolder)localObject1).a().jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
          ((ItemHolder)localObject1).a().jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setVisibility(8);
          break label1301;
          label1420:
          paramViewGroup = new AIOSendMask(2130706432, this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.a() * 12.0F);
          ((ItemHolder)localObject1).a().jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setBackgroundDrawable(paramViewGroup);
          i = (int)TypedValue.applyDimension(2, 15.0F, this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics());
          ((ItemHolder)localObject1).a().jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setDisplayInTextView(false, i, -1);
        }
        paramViewGroup = (RelativeLayout)this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130968885, null);
        ((ItemHolder)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.addView(paramViewGroup);
        ((ItemHolder)localObject1).a().jdField_a_of_type_AndroidWidgetRelativeLayout = paramViewGroup;
        ((ItemHolder)localObject1).a().jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131364170));
        ((ItemHolder)localObject1).a().jdField_a_of_type_AndroidWidgetGridView = ((GridView)paramView.findViewById(2131364169));
        ((ItemHolder)localObject1).a().jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramView.findViewById(2131364142));
        ((ItemHolder)localObject1).a().jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131364203));
        ((ItemHolder)localObject1).a().jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131364204));
        if (!((DataLineMsgSet)localObject2).isSendFromLocal())
        {
          ((ItemHolder)localObject1).a().jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131364202));
          ((ItemHolder)localObject1).a().jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131364201));
          ((ItemHolder)localObject1).a().jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131364200));
        }
        ((ItemHolder)localObject1).a().jdField_a_of_type_AndroidWidgetRelativeLayout.setAddStatesFromChildren(true);
        ((ItemHolder)localObject1).a().jdField_a_of_type_AndroidWidgetTextView.setTag(localObject1);
        ((ItemHolder)localObject1).a().jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        ((ItemHolder)localObject1).a().jdField_a_of_type_AndroidWidgetTextView.setClickable(true);
        ((ItemHolder)localObject1).a().jdField_a_of_type_AndroidWidgetTextView.setOnLongClickListener(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.jdField_a_of_type_AndroidViewView$OnLongClickListener);
        ((ItemHolder)localObject1).a().jdField_a_of_type_AndroidWidgetTextView.setOnTouchListener(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.jdField_a_of_type_AndroidViewView$OnTouchListener);
        ((ItemHolder)localObject1).a().jdField_a_of_type_AndroidWidgetTextView.setLongClickable(true);
        a(((ItemHolder)localObject1).a().jdField_a_of_type_AndroidWidgetGridView);
        continue;
        localObject3 = (RelativeLayout)this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130968878, null);
        ((ItemHolder)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.addView((View)localObject3);
        if (FontSettingManager.a() > 17.0F)
        {
          ((ItemHolder)localObject1).a().jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localObject3);
          i = AIOUtils.a(70.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
          paramViewGroup = (RelativeLayout)paramView.findViewById(2131361959);
          RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, i);
          localLayoutParams.addRule(10, 2131364136);
          ((RelativeLayout)localObject3).updateViewLayout(paramViewGroup, localLayoutParams);
          localObject3 = (AsyncImageView)paramView.findViewById(2131364137);
          ((AsyncImageView)localObject3).setScaleType(ImageView.ScaleType.CENTER_CROP);
          localLayoutParams = new RelativeLayout.LayoutParams(i, i);
          localLayoutParams.addRule(9, 2131361959);
          localLayoutParams.addRule(15, 2131361959);
          paramViewGroup.updateViewLayout((View)localObject3, localLayoutParams);
          ((ItemHolder)localObject1).a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView = ((AsyncImageView)localObject3);
          localObject3 = (TextView)paramView.findViewById(2131364138);
          ((TextView)localObject3).setGravity(16);
          localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
          localLayoutParams.addRule(1, 2131364137);
          localLayoutParams.addRule(11, 2131361959);
          localLayoutParams.addRule(10, 2131361959);
          localLayoutParams.setMargins(AIOUtils.a(10.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0, 0, 0);
          paramViewGroup.updateViewLayout((View)localObject3, localLayoutParams);
          ((ItemHolder)localObject1).a().jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject3);
          localObject3 = (TextView)paramView.findViewById(2131364141);
          ((TextView)localObject3).setGravity(5);
          localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
          localLayoutParams.addRule(11, 2131361959);
          localLayoutParams.addRule(12, 2131361959);
          paramViewGroup.updateViewLayout((View)localObject3, localLayoutParams);
          ((ItemHolder)localObject1).a().jdField_d_of_type_AndroidWidgetTextView = ((TextView)localObject3);
          localObject3 = (TextView)paramView.findViewById(2131364140);
          ((TextView)localObject3).setGravity(17);
          localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
          localLayoutParams.addRule(11, 2131361959);
          localLayoutParams.addRule(2, 2131364141);
          paramViewGroup.updateViewLayout((View)localObject3, localLayoutParams);
          ((ItemHolder)localObject1).a().jdField_c_of_type_AndroidWidgetTextView = ((TextView)localObject3);
        }
        for (;;)
        {
          ((ItemHolder)localObject1).a().jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramView.findViewById(2131364142));
          ((ItemHolder)localObject1).a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setDefaultImage(2130846412);
          ((ItemHolder)localObject1).a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setIsDrawRound(false);
          break;
          ((ItemHolder)localObject1).a().jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localObject3);
          ((ItemHolder)localObject1).a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView = ((AsyncImageView)paramView.findViewById(2131364137));
          ((ItemHolder)localObject1).a().jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131364138));
          ((ItemHolder)localObject1).a().jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131364140));
          ((ItemHolder)localObject1).a().jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131364141));
        }
        paramViewGroup = (RelativeLayout)this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130968876, null);
        ((ItemHolder)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.addView(paramViewGroup);
        ((ItemHolder)localObject1).a().jdField_a_of_type_AndroidWidgetRelativeLayout = paramViewGroup;
        ((ItemHolder)localObject1).a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView = ((AsyncImageView)paramView.findViewById(2131364137));
        ((ItemHolder)localObject1).a().jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131364138));
        ((ItemHolder)localObject1).a().jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131364139));
        ((ItemHolder)localObject1).a().jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131364140));
        ((ItemHolder)localObject1).a().jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131364141));
        ((ItemHolder)localObject1).a().jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramView.findViewById(2131364142));
        ((ItemHolder)localObject1).a().e = ((TextView)paramView.findViewById(2131364202));
        ((ItemHolder)localObject1).a().jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131364201));
        ((ItemHolder)localObject1).a().jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131364200));
        ((ItemHolder)localObject1).a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setDefaultImage(2130841611);
        ((ItemHolder)localObject1).a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setIsDrawRound(false);
        continue;
        paramViewGroup = (RelativeLayout)this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130968884, null);
        ((ItemHolder)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.addView(paramViewGroup);
        ((ItemHolder)localObject1).a().jdField_a_of_type_AndroidWidgetRelativeLayout = paramViewGroup;
        ((ItemHolder)localObject1).a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView = ((AsyncImageView)paramView.findViewById(2131364163));
        ((ItemHolder)localObject1).a().jdField_b_of_type_ComDatalineUtilWidgetAsyncImageView = ((AsyncImageView)paramView.findViewById(2131364164));
        ((ItemHolder)localObject1).a().jdField_c_of_type_ComDatalineUtilWidgetAsyncImageView = ((AsyncImageView)paramView.findViewById(2131364165));
        ((ItemHolder)localObject1).a().jdField_d_of_type_ComDatalineUtilWidgetAsyncImageView = ((AsyncImageView)paramView.findViewById(2131364166));
        ((ItemHolder)localObject1).a().jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131364138));
        ((ItemHolder)localObject1).a().jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131364139));
        ((ItemHolder)localObject1).a().jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131364140));
        ((ItemHolder)localObject1).a().jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131364141));
        ((ItemHolder)localObject1).a().jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramView.findViewById(2131364142));
        ((ItemHolder)localObject1).a().e = ((TextView)paramView.findViewById(2131364202));
        ((ItemHolder)localObject1).a().jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131364201));
        ((ItemHolder)localObject1).a().jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131364200));
        ((ItemHolder)localObject1).a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setDefaultImage(2130841612);
        ((ItemHolder)localObject1).a().jdField_b_of_type_ComDatalineUtilWidgetAsyncImageView.setDefaultImage(2130841612);
        ((ItemHolder)localObject1).a().jdField_c_of_type_ComDatalineUtilWidgetAsyncImageView.setDefaultImage(2130841612);
        ((ItemHolder)localObject1).a().jdField_d_of_type_ComDatalineUtilWidgetAsyncImageView.setDefaultImage(2130841612);
        ((ItemHolder)localObject1).a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setIsDrawRound(false);
        ((ItemHolder)localObject1).a().jdField_b_of_type_ComDatalineUtilWidgetAsyncImageView.setIsDrawRound(false);
        ((ItemHolder)localObject1).a().jdField_c_of_type_ComDatalineUtilWidgetAsyncImageView.setIsDrawRound(false);
        ((ItemHolder)localObject1).a().jdField_d_of_type_ComDatalineUtilWidgetAsyncImageView.setIsDrawRound(false);
      }
    }
    label2924:
    int j;
    int k;
    switch (paramInt)
    {
    case 4: 
    default: 
      a(localDataLineMsgRecord, paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout, paramViewGroup);
      if (ThemeUtil.isDefaultTheme())
      {
        paramInt = paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.getPaddingLeft();
        i = paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.getPaddingRight();
        j = paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.getPaddingTop();
        k = paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.getPaddingBottom();
        if (!((DataLineMsgSet)localObject2).isSendFromLocal()) {
          paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(paramInt + (int)(2.0F * this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.a()), j, i, k);
        }
      }
      else
      {
        label3069:
        if (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
        {
          localObject1 = (ChatBackgroundDrawable)this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.jdField_a_of_type_ComTencentWidgetXPanelContainer.getTag(2131362037);
          if (localObject1 != null)
          {
            paramInt = ChatBackground.a(((ChatBackgroundDrawable)localObject1).getBitmap());
            paramViewGroup.a().setTextColor(ColorStateList.valueOf(paramInt));
          }
        }
        if (!a(((DataLineMsgSet)localObject2).getMsgId())) {
          break label3392;
        }
        localObject1 = TimeFormatterUtils.a(this.jdField_a_of_type_AndroidContentContext, 3, ((DataLineMsgSet)localObject2).getTime() * 1000L);
        paramViewGroup.a().setVisibility(0);
        paramViewGroup.a().setText((CharSequence)localObject1);
      }
      break;
    }
    for (;;)
    {
      d(paramViewGroup, (DataLineMsgSet)localObject2);
      return paramView;
      paramViewGroup.a().jdField_a_of_type_JavaLangString = localDataLineMsgRecord.msg;
      paramViewGroup.a().jdField_a_of_type_Long = localDataLineMsgRecord.sessionid;
      localObject1 = paramViewGroup.a().jdField_a_of_type_AndroidWidgetTextView;
      localObject3 = AppConstants.y;
      ((TextView)localObject1).setText(new QQText(localDataLineMsgRecord.msg, 13, 32, 6000));
      ((TextView)localObject1).setVisibility(0);
      if (paramViewGroup.a() != null)
      {
        if ((!localDataLineMsgRecord.issuc) || (localDataLineMsgRecord.progress == 1.0F)) {
          break label3300;
        }
        paramViewGroup.a().setVisibility(0);
      }
      for (;;)
      {
        ((TextView)localObject1).setTextSize(0, ChatTextSizeSettingActivity.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext()));
        break;
        label3300:
        paramViewGroup.a().setVisibility(8);
      }
      c(paramViewGroup, (DataLineMsgSet)localObject2);
      break;
      b(paramViewGroup, (DataLineMsgSet)localObject2);
      break;
      a(paramViewGroup, (DataLineMsgSet)localObject2);
      break;
      b(paramViewGroup, (DataLineMsgSet)localObject2);
      break;
      a(paramViewGroup, (DataLineMsgSet)localObject2);
      break;
      paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(paramInt, j, i + (int)(2.0F * this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.a()), k);
      break label3069;
      label3392:
      paramViewGroup.a().setVisibility(8);
    }
  }
  
  public int getViewTypeCount()
  {
    return 15;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.dataline.util.DatalineSessionAdapter
 * JD-Core Version:    0.7.0.1
 */