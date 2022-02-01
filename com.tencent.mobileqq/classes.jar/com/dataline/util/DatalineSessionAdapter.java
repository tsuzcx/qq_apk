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
import com.tencent.mobileqq.app.SVIPHandler;
import com.tencent.mobileqq.app.message.DatalineMessageManager;
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
import com.tencent.mobileqq.filemanager.util.FilePathUtil;
import com.tencent.mobileqq.forward.ForwardFileOption;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
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
    this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296846);
    this.jdField_b_of_type_Int = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296845);
    b();
  }
  
  private Drawable a(DataLineMsgRecord paramDataLineMsgRecord)
  {
    boolean bool = paramDataLineMsgRecord.isSendFromLocal();
    int i;
    if ((paramDataLineMsgRecord.msgtype == -2005) || (paramDataLineMsgRecord.msgtype == -2009))
    {
      i = 1;
      if (i != 0) {
        break label40;
      }
      paramDataLineMsgRecord = null;
    }
    for (;;)
    {
      return paramDataLineMsgRecord;
      i = 0;
      break;
      label40:
      Drawable localDrawable;
      if ((this.jdField_b_of_type_AndroidGraphicsDrawableDrawable == null) || (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null))
      {
        paramDataLineMsgRecord = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources();
        localDrawable = paramDataLineMsgRecord.getDrawable(2130850414);
        paramDataLineMsgRecord = paramDataLineMsgRecord.getDrawable(2130850238);
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = localDrawable;
        this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = paramDataLineMsgRecord;
      }
      while (bool)
      {
        return localDrawable;
        localDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
        paramDataLineMsgRecord = this.jdField_b_of_type_AndroidGraphicsDrawableDrawable;
      }
    }
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
    paramView.setPadding(k + m, i + j, n + i1, i3 + i2);
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
        Bitmap localBitmap = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(this.jdField_a_of_type_AndroidContentContext.getResources(), 2130838186), paramInt1, paramInt2, false);
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
      if ((localObject != null) && (((Trans_entity)localObject).a().booleanValue()) && (!paramDataLineMsgRecord.isSendFromLocal()))
      {
        paramItemHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo = BubbleUtils.a(100001, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext.getResources(), this);
        if (paramItemHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo != null)
        {
          paramItemHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo.a(paramRelativeLayout, null);
          if (paramDataLineMsgRecord.msgtype == -1000) {
            break label334;
          }
        }
      }
    }
    label334:
    for (boolean bool = true;; bool = false)
    {
      int i = paramDataLineMsgRecord.vipBubbleDiyTextId;
      if (i <= 0) {
        SVIPHandler.b(paramDataLineMsgRecord.vipBubbleID);
      }
      paramItemHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramDataLineMsgRecord.isSendFromLocal(), true, bool, paramRelativeLayout, FontManager.a(paramDataLineMsgRecord), i);
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
      return;
      paramItemHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo = BubbleUtils.a(100000, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext.getResources(), this);
      break;
      paramItemHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo = BubbleUtils.a(((SVIPHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).a(paramDataLineMsgRecord), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext.getResources(), this);
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
      if ((localDataLineMsgRecord.strMoloSource == null) || (!localDataLineMsgRecord.strMoloSource.contains(this.jdField_a_of_type_AndroidContentContext.getString(2131693834)))) {
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
      paramItemHolder.a().jdField_d_of_type_AndroidWidgetTextView.setText(2131693800);
    }
    for (;;)
    {
      if (((paramDataLineMsgSet.hasSendingOrRecving()) || (paramDataLineMsgSet.hasWaiting())) && (!paramDataLineMsgSet.isFileComing())) {
        break label709;
      }
      paramItemHolder.a().jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
      return true;
      paramItemHolder.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setImageResource(2130844369);
      break;
      label492:
      paramItemHolder.a().jdField_b_of_type_ComDatalineUtilWidgetAsyncImageView.setImageResource(2130844369);
      break label128;
      label508:
      paramItemHolder.a().jdField_c_of_type_ComDatalineUtilWidgetAsyncImageView.setImageResource(2130844369);
      break label173;
      label524:
      paramItemHolder.a().jdField_d_of_type_ComDatalineUtilWidgetAsyncImageView.setImageResource(2130844369);
      break label218;
      label540:
      paramItemHolder.a().jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      paramItemHolder.a().jdField_b_of_type_AndroidWidgetTextView.setText(2131693735);
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
        paramItemHolder.a().jdField_d_of_type_AndroidWidgetTextView.setText(2131692426);
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
    int j = paramDataLineMsgSet.getCompletedCount();
    int i = paramDataLineMsgSet.getTotalCount();
    DataLineMsgRecord localDataLineMsgRecord = paramDataLineMsgSet.getFirstItem();
    if (localDataLineMsgRecord == null) {
      return false;
    }
    DatalineSessionAdapter.GridAdapter localGridAdapter;
    label149:
    label314:
    if (j == i)
    {
      paramItemHolder.a().jdField_a_of_type_AndroidWidgetTextView.setText("" + i);
      j = ((Integer)paramItemHolder.a().jdField_a_of_type_AndroidWidgetGridView.getTag()).intValue();
      localGridAdapter = (DatalineSessionAdapter.GridAdapter)paramItemHolder.a().jdField_a_of_type_AndroidWidgetGridView.getAdapter();
      if (localGridAdapter != null) {
        break label448;
      }
      localGridAdapter = new DatalineSessionAdapter.GridAdapter(this, paramItemHolder, paramDataLineMsgSet, j, null);
      paramItemHolder.a().jdField_a_of_type_AndroidWidgetGridView.setAdapter(localGridAdapter);
      paramItemHolder.a().jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      paramDataLineMsgSet.printlog();
      if (((paramDataLineMsgSet.hasSendingOrRecving()) || (paramDataLineMsgSet.hasWaiting())) && (!paramDataLineMsgSet.isFileComing())) {
        break label502;
      }
      paramItemHolder.a().jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
      if (!paramDataLineMsgSet.isCanceled()) {
        break label468;
      }
      paramItemHolder.a().jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      paramItemHolder.a().jdField_b_of_type_AndroidWidgetTextView.setText(2131693800);
      label228:
      if (!paramDataLineMsgSet.isSendFromLocal())
      {
        paramItemHolder.a().jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        if (localDataLineMsgRecord.strMoloKey != null)
        {
          if ((localDataLineMsgRecord.strMoloSource == null) || (localDataLineMsgRecord.strMoloSource.equals(""))) {
            break label535;
          }
          paramItemHolder.a().jdField_c_of_type_AndroidWidgetTextView.setText(localDataLineMsgRecord.strMoloSource);
          paramItemHolder.a().jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
          paramItemHolder.a().jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
          if ((localDataLineMsgRecord.strMoloSrcIconUrl == null) || (localDataLineMsgRecord.strMoloSrcIconUrl.equals(""))) {
            break label550;
          }
          paramItemHolder.a().jdField_a_of_type_ComTencentImageURLImageView.setImageURL(localDataLineMsgRecord.strMoloSrcIconUrl);
          paramItemHolder.a().jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
        }
      }
    }
    for (;;)
    {
      if (paramItemHolder.a().jdField_a_of_type_AndroidWidgetRelativeLayout != null)
      {
        paramDataLineMsgSet = String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131693783), new Object[] { Integer.valueOf(i) });
        paramItemHolder.a().jdField_a_of_type_AndroidWidgetRelativeLayout.setContentDescription(paramDataLineMsgSet);
      }
      return true;
      paramItemHolder.a().jdField_a_of_type_AndroidWidgetTextView.setText(j + "/" + i);
      break;
      label448:
      localGridAdapter.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet = paramDataLineMsgSet;
      localGridAdapter.jdField_a_of_type_ComDatalineUtilItemHolder = paramItemHolder;
      localGridAdapter.a();
      break label149;
      label468:
      if (!paramDataLineMsgSet.isFileComing()) {
        break label228;
      }
      paramItemHolder.a().jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      paramItemHolder.a().jdField_b_of_type_AndroidWidgetTextView.setText(2131692426);
      break label228;
      label502:
      paramItemHolder.a().jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      paramItemHolder.a().jdField_a_of_type_AndroidWidgetProgressBar.setProgress((int)(paramDataLineMsgSet.getTotalProcess() * 100.0F));
      break label228;
      label535:
      paramItemHolder.a().jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      break label314;
      label550:
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
    String str = FilePathUtil.c(localDataLineMsgRecord.path);
    paramItemHolder.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setAsyncClipSize(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
    paramItemHolder.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setDefaultImageByMargin();
    paramItemHolder.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setIsDrawRound(true);
    paramItemHolder.a().jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    paramItemHolder.a().jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    label317:
    if ((str != null) && (new VFSFile(str).exists()))
    {
      paramItemHolder.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setAsyncImage(str);
      label125:
      if ((localDataLineMsgRecord.progress != 1.0F) && (localDataLineMsgRecord.issuc) && (localDataLineMsgRecord.fileMsgStatus != 1L) && (localDataLineMsgRecord.fileMsgStatus != 2L)) {
        break label483;
      }
      paramItemHolder.a().jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setVisibility(8);
      paramItemHolder.a().jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      if ((localDataLineMsgRecord.fileMsgStatus != 1L) || (localDataLineMsgRecord.thumbPath != null)) {
        break label468;
      }
      paramItemHolder.a().jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      paramItemHolder.a().jdField_a_of_type_AndroidWidgetTextView.setText(2131693752);
      label231:
      if (!paramDataLineMsgSet.isSendFromLocal())
      {
        paramItemHolder.a().jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        if (localDataLineMsgRecord.strMoloKey != null)
        {
          if ((localDataLineMsgRecord.strMoloSource == null) || (localDataLineMsgRecord.strMoloSource.equals(""))) {
            break label541;
          }
          paramItemHolder.a().jdField_c_of_type_AndroidWidgetTextView.setText(localDataLineMsgRecord.strMoloSource);
          paramItemHolder.a().jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
          paramItemHolder.a().jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
          if ((localDataLineMsgRecord.strMoloSrcIconUrl == null) || (localDataLineMsgRecord.strMoloSrcIconUrl.equals(""))) {
            break label556;
          }
          paramItemHolder.a().jdField_a_of_type_ComTencentImageURLImageView.setImageURL(localDataLineMsgRecord.strMoloSrcIconUrl);
          paramItemHolder.a().jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
        }
      }
    }
    for (;;)
    {
      if (paramItemHolder.a().jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
        paramItemHolder.a().jdField_a_of_type_AndroidWidgetRelativeLayout.setContentDescription(HardCodeUtil.a(2131702791));
      }
      if (paramItemHolder.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView == null) {
        break;
      }
      paramItemHolder.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setContentDescription(HardCodeUtil.a(2131702783));
      return;
      if ((localDataLineMsgRecord.thumbPath != null) && (localDataLineMsgRecord.thumbPath.length() > 0))
      {
        paramItemHolder.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setAsyncImage(localDataLineMsgRecord.thumbPath);
        break label125;
      }
      paramItemHolder.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setImageDrawableDefault();
      break label125;
      label468:
      paramItemHolder.a().jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      break label231;
      label483:
      if (localDataLineMsgRecord.isSendFromLocal())
      {
        paramItemHolder.a().jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setVisibility(0);
        int i = (int)(localDataLineMsgRecord.progress * 100.0F);
        paramItemHolder.a().jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setProgress(i);
        break label231;
      }
      paramItemHolder.a().jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      break label231;
      label541:
      paramItemHolder.a().jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      break label317;
      label556:
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
    Object localObject = null;
    if (paramListView == null) {}
    int i;
    DataLineMsgSet localDataLineMsgSet;
    int j;
    label168:
    label379:
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
                break label379;
              }
              j = DataLineMsgRecord.getDevTypeBySeId(paramLong);
              localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(j).a(paramLong);
              if (localObject == null) {
                break;
              }
              if (!a(getItemViewType(i))) {
                break label168;
              }
              a((DataLineMsgRecord)localObject, paramListView, paramFloat);
              return;
              if (System.currentTimeMillis() - localDataLineMsgSet.mUpdateProcessTick < 1000L) {
                break;
              }
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
                break label272;
              }
              paramListView = (MessageProgressTextView)paramListView.findViewById(2131368746);
            }
          } while (paramListView == null);
          paramListView.setProgress((int)(f * 100.0F));
          return;
          localObject = (TextView)paramListView.findViewById(2131366962);
          paramListView = (ProgressBar)paramListView.findViewById(2131366931);
          if (paramListView != null)
          {
            paramListView.setVisibility(0);
            paramListView.setProgress((int)(f * 100.0F));
          }
        } while (localObject == null);
        ((TextView)localObject).setText((int)(f * 100.0F) + "%");
        return;
        paramListView = (MessageProgressTextView)paramListView.findViewById(2131368746);
      } while (paramListView == null);
      paramListView.setProgress((int)(f * 100.0F));
      return;
      paramListView = (ItemHolder)paramListView.getTag();
    } while (paramListView == null);
    label272:
    switch (localDataLineMsgSet.getGroupType())
    {
    default: 
      paramListView = null;
      label442:
      i = localDataLineMsgSet.getCompletedCount();
      j = localDataLineMsgSet.getTotalCount();
      if (localObject != null)
      {
        if (i != j) {
          break label542;
        }
        ((TextView)localObject).setText("" + j);
      }
      break;
    }
    while (paramListView != null)
    {
      if (i != j) {
        break label576;
      }
      paramListView.setVisibility(4);
      return;
      localObject = paramListView.a().jdField_d_of_type_AndroidWidgetTextView;
      paramListView = paramListView.a().jdField_a_of_type_AndroidWidgetProgressBar;
      break label442;
      paramListView = paramListView.a().jdField_a_of_type_AndroidWidgetProgressBar;
      break label442;
      label542:
      ((TextView)localObject).setText(i + "/" + j);
    }
    label576:
    paramListView.setVisibility(0);
    paramListView.setProgress((int)(localDataLineMsgSet.getTotalProcess() * 100.0F));
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
    if ((paramBubbleInfo.jdField_a_of_type_Int == 0) || (!paramBubbleInfo.a()))
    {
      paramBubbleInfo = paramView.getResources();
      if (paramDataLineMsgRecord.isSendFromLocal())
      {
        paramView = paramBubbleInfo.getColorStateList(2131167056);
        paramItemHolder.a().jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramView);
        if (!paramDataLineMsgRecord.isSendFromLocal()) {
          break label95;
        }
      }
      label95:
      for (paramView = paramBubbleInfo.getColorStateList(2131167055);; paramView = paramBubbleInfo.getColorStateList(2131167054))
      {
        paramItemHolder.a().jdField_a_of_type_AndroidWidgetTextView.setLinkTextColor(paramView);
        return;
        paramView = paramBubbleInfo.getColorStateList(2131167052);
        break;
      }
    }
    if (paramBubbleInfo.jdField_b_of_type_Int == 0) {
      paramItemHolder.a().jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
    }
    while (paramBubbleInfo.c == 0)
    {
      paramItemHolder.a().jdField_a_of_type_AndroidWidgetTextView.setLinkTextColor(paramView.getResources().getColorStateList(2131167054));
      return;
      paramItemHolder.a().jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramBubbleInfo.jdField_b_of_type_Int);
    }
    paramItemHolder.a().jdField_a_of_type_AndroidWidgetTextView.setLinkTextColor(paramBubbleInfo.c);
  }
  
  protected void a(ItemHolder paramItemHolder, DataLineMsgSet paramDataLineMsgSet)
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
        paramItemHolder.a().jdField_d_of_type_AndroidWidgetTextView.setText(2131693800);
      }
    }
    while ((paramDataLineMsgSet.progress == 1.0F) || (!paramDataLineMsgSet.issuc) || (paramDataLineMsgSet.fileMsgStatus == 1L) || (paramDataLineMsgSet.fileMsgStatus == 2L))
    {
      paramItemHolder.a().jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
      return;
      if ((paramDataLineMsgSet.progress == 1.0F) && (paramDataLineMsgSet.issuc))
      {
        paramItemHolder.a().jdField_d_of_type_AndroidWidgetTextView.setText(2131692425);
      }
      else if (!paramDataLineMsgSet.issuc)
      {
        if (paramDataLineMsgSet.nOpType == 1) {
          paramItemHolder.a().jdField_d_of_type_AndroidWidgetTextView.setText(2131692423);
        } else {
          paramItemHolder.a().jdField_d_of_type_AndroidWidgetTextView.setText(2131692424);
        }
      }
      else
      {
        paramItemHolder.a().jdField_d_of_type_AndroidWidgetTextView.setText(i + "%");
        continue;
        if (paramDataLineMsgSet.fileMsgStatus == 2L) {
          paramItemHolder.a().jdField_d_of_type_AndroidWidgetTextView.setText(2131693800);
        } else if (paramDataLineMsgSet.fileMsgStatus == 1L) {
          paramItemHolder.a().jdField_d_of_type_AndroidWidgetTextView.setText(2131692426);
        } else if ((paramDataLineMsgSet.progress == 1.0F) && (paramDataLineMsgSet.issuc)) {
          paramItemHolder.a().jdField_d_of_type_AndroidWidgetTextView.setText(2131692417);
        } else if (!paramDataLineMsgSet.issuc) {
          paramItemHolder.a().jdField_d_of_type_AndroidWidgetTextView.setText(2131692423);
        } else {
          paramItemHolder.a().jdField_d_of_type_AndroidWidgetTextView.setText(i + "%");
        }
      }
    }
    paramItemHolder.a().jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    paramItemHolder.a().jdField_a_of_type_AndroidWidgetProgressBar.setProgress(i);
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
  
  protected void b(ItemHolder paramItemHolder, DataLineMsgSet paramDataLineMsgSet)
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
      if ((paramDataLineMsgSet.strMoloSource == null) || (!paramDataLineMsgSet.strMoloSource.contains(this.jdField_a_of_type_AndroidContentContext.getString(2131693834)))) {
        break label333;
      }
      paramItemHolder.a().jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      paramItemHolder.a().jdField_a_of_type_AndroidWidgetTextView.setSingleLine(false);
      paramItemHolder.a().jdField_a_of_type_AndroidWidgetTextView.setMaxLines(2);
      label127:
      paramItemHolder.a().jdField_c_of_type_AndroidWidgetTextView.setText(FileUtil.a(paramDataLineMsgSet.filesize));
      if ((paramDataLineMsgSet.strMoloSource == null) || (paramDataLineMsgSet.strMoloSource.equals(""))) {
        break label371;
      }
      paramItemHolder.a().e.setText(paramDataLineMsgSet.strMoloSource);
      paramItemHolder.a().e.setVisibility(0);
      paramItemHolder.a().jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      label200:
      if ((paramDataLineMsgSet.strMoloSrcIconUrl == null) || (paramDataLineMsgSet.strMoloSrcIconUrl.equals(""))) {
        break label386;
      }
      paramItemHolder.a().jdField_a_of_type_ComTencentImageURLImageView.setImageURL(paramDataLineMsgSet.strMoloSrcIconUrl);
      paramItemHolder.a().jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
      label245:
      if (paramDataLineMsgSet.fileMsgStatus != 2L) {
        break label401;
      }
      paramItemHolder.a().jdField_d_of_type_AndroidWidgetTextView.setText(2131693800);
    }
    for (;;)
    {
      if ((paramDataLineMsgSet.progress != 1.0F) && (paramDataLineMsgSet.issuc) && (paramDataLineMsgSet.fileMsgStatus != 1L) && (paramDataLineMsgSet.fileMsgStatus != 2L)) {
        break label514;
      }
      paramItemHolder.a().jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
      return;
      paramItemHolder.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setImageResource(2130844369);
      break;
      label333:
      paramItemHolder.a().jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      paramItemHolder.a().jdField_b_of_type_AndroidWidgetTextView.setText(2131693735);
      paramItemHolder.a().jdField_a_of_type_AndroidWidgetTextView.setSingleLine(true);
      break label127;
      label371:
      paramItemHolder.a().jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      break label200;
      label386:
      paramItemHolder.a().jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
      break label245;
      label401:
      if (paramDataLineMsgSet.fileMsgStatus == 1L) {
        paramItemHolder.a().jdField_d_of_type_AndroidWidgetTextView.setText(2131692426);
      } else if ((paramDataLineMsgSet.progress == 1.0F) && (paramDataLineMsgSet.issuc)) {
        paramItemHolder.a().jdField_d_of_type_AndroidWidgetTextView.setText(2131692417);
      } else if (!paramDataLineMsgSet.issuc) {
        paramItemHolder.a().jdField_d_of_type_AndroidWidgetTextView.setText(2131692423);
      } else {
        paramItemHolder.a().jdField_d_of_type_AndroidWidgetTextView.setText(i + "%");
      }
    }
    label514:
    paramItemHolder.a().jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    paramItemHolder.a().jdField_a_of_type_AndroidWidgetProgressBar.setProgress(i);
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
    label137:
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
            break label137;
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
    return 15;
    return 16;
  }
  
  @TargetApi(8)
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject1;
    Object localObject2;
    Object localObject3;
    if (b()) {
      if (paramView == null)
      {
        localObject1 = new ItemHolder();
        paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559143, null);
        localObject2 = (TextView)paramView.findViewById(2131370519);
        localObject3 = (ImageView)paramView.findViewById(2131370518);
        if (this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.jdField_a_of_type_Int == 1)
        {
          ((TextView)localObject2).setText(2131691453);
          ((ImageView)localObject3).setImageResource(2130839693);
        }
        paramView.setTag(localObject1);
        paramView.setVisibility(4);
        this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.u();
        localObject1 = paramView;
      }
    }
    int i;
    DataLineMsgRecord localDataLineMsgRecord;
    label214:
    Object localObject4;
    int j;
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, (View)localObject1, paramViewGroup, getItemId(paramInt));
      return paramView;
      localObject1 = (ItemHolder)paramView.getTag();
      break;
      this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.u();
      localObject3 = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.get(paramInt);
      if (localObject3 == null)
      {
        localObject2 = null;
        localObject1 = paramView;
        paramView = (View)localObject2;
      }
      else
      {
        i = getItemViewType(paramInt);
        localDataLineMsgRecord = ((DataLineMsgSet)localObject3).getFirstItem();
        if (paramView == null)
        {
          localObject2 = new ItemHolder();
          if (a(i))
          {
            paramView = a(i, (ItemHolder)localObject2, (DataLineMsgSet)localObject3);
            paramView.setTag(localObject2);
          }
        }
        for (localObject1 = localObject2;; localObject1 = (ItemHolder)paramView.getTag())
        {
          ((ItemHolder)localObject1).a((DataLineMsgSet)localObject3);
          if (i != 12) {
            break label3101;
          }
          localObject2 = paramView;
          localObject1 = paramView;
          paramView = (View)localObject2;
          break;
          if (i == 12)
          {
            localObject1 = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559131, null);
            ((ItemHolder)localObject2).b((TextView)((View)localObject1).findViewById(2131365577));
            paramView = (View)localObject1;
            if (((ItemHolder)localObject2).b() == null) {
              break label214;
            }
            ((ItemHolder)localObject2).b().setText(2131693791);
            paramView = (View)localObject1;
            break label214;
          }
          Object localObject5;
          if (i == 14)
          {
            paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559117, null);
            localObject1 = ((ItemHolder)localObject2).a();
            ((ItemHolder.GrayTipItemHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131368045));
            localObject4 = HardCodeUtil.a(2131702802);
            localObject5 = HardCodeUtil.a(2131702779);
            ((ItemHolder.GrayTipItemHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView.setMaxLines(2);
            localObject5 = new SpannableString("还想把文件发到好友手机？快来用\n" + (String)localObject4 + (String)localObject5);
            ((SpannableString)localObject5).setSpan(new DatalineSessionAdapter.3(this), "还想把文件发到好友手机？快来用\n".length(), "还想把文件发到好友手机？快来用\n".length() + ((String)localObject4).length(), 33);
            ((ItemHolder.GrayTipItemHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView.setHighlightColor(0);
            ((ItemHolder.GrayTipItemHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject5);
            ((ItemHolder.GrayTipItemHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView.setMovementMethod(LinkMovementMethod.getInstance());
            ((ItemHolder.GrayTipItemHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
            break label214;
          }
          if (i == 15)
          {
            localObject1 = ((ItemHolder)localObject2).a();
            paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560973, null);
            ((ItemHolder.TipHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131368045));
            break label214;
          }
          if (i == 16)
          {
            localObject1 = ((ItemHolder)localObject2).a();
            paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558963, null);
            ((ItemHolder.TipHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131368045));
            ((ItemHolder.TipHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView.setMovementMethod(null);
            ((ItemHolder.TipHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramView.getResources().getColorStateList(2131165442));
            break label214;
          }
          if (!((DataLineMsgSet)localObject3).isSendFromLocal())
          {
            localObject1 = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559132, null);
            localObject4 = (ImageView)((View)localObject1).findViewById(2131368603);
            paramView = this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.getResources().getDrawable(2130844376);
            j = DataLineMsgRecord.getDevTypeBySet((DataLineMsgSet)localObject3);
            if (j == 0)
            {
              paramView = this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.getResources().getDrawable(2130844376);
              label686:
              ((ImageView)localObject4).setImageDrawable(paramView);
              paramView = (View)localObject1;
              label695:
              ((ItemHolder)localObject2).jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131371935));
              ((ItemHolder)localObject2).jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(localObject2);
              ((ItemHolder)localObject2).jdField_a_of_type_AndroidWidgetRelativeLayout.setClickable(true);
              ((ItemHolder)localObject2).jdField_a_of_type_AndroidWidgetRelativeLayout.setLongClickable(true);
              ((ItemHolder)localObject2).jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
              ((ItemHolder)localObject2).jdField_a_of_type_AndroidWidgetRelativeLayout.setOnLongClickListener(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.jdField_a_of_type_AndroidViewView$OnLongClickListener);
              ((ItemHolder)localObject2).jdField_a_of_type_AndroidWidgetRelativeLayout.setOnTouchListener(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.jdField_a_of_type_AndroidViewView$OnTouchListener);
              ((ItemHolder)localObject2).jdField_a_of_type_AndroidWidgetRelativeLayout.setAddStatesFromChildren(true);
              switch (i)
              {
              }
            }
          }
          for (;;)
          {
            ((ItemHolder)localObject2).a((ImageView)paramView.findViewById(2131366403));
            ((ItemHolder)localObject2).a((TextView)paramView.findViewById(2131365578));
            break;
            if (j != 1) {
              break label686;
            }
            paramView = this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.getResources().getDrawable(2130844371);
            break label686;
            paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559138, null);
            break label695;
            localObject1 = (RelativeLayout)this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559139, null);
            ((ItemHolder)localObject2).jdField_a_of_type_AndroidWidgetRelativeLayout.addView((View)localObject1);
            ((ItemHolder)localObject2).a().jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localObject1);
            ((ItemHolder)localObject2).a().jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379091));
            ((ItemHolder)localObject2).a().jdField_a_of_type_AndroidWidgetRelativeLayout.setAddStatesFromChildren(true);
            ((ItemHolder)localObject2).a().jdField_a_of_type_AndroidWidgetTextView.setTag(localObject2);
            ((ItemHolder)localObject2).a().jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
            ((ItemHolder)localObject2).a().jdField_a_of_type_AndroidWidgetTextView.setClickable(true);
            ((ItemHolder)localObject2).a().jdField_a_of_type_AndroidWidgetTextView.setOnLongClickListener(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.jdField_a_of_type_AndroidViewView$OnLongClickListener);
            ((ItemHolder)localObject2).a().jdField_a_of_type_AndroidWidgetTextView.setOnTouchListener(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.jdField_a_of_type_AndroidViewView$OnTouchListener);
            ((ItemHolder)localObject2).a().jdField_a_of_type_AndroidWidgetTextView.setLongClickable(true);
            ((ItemHolder)localObject2).a().jdField_a_of_type_AndroidWidgetTextView.setMovementMethod(LinkMovementMethod.getInstance());
            ((ItemHolder)localObject2).a().jdField_a_of_type_AndroidWidgetTextView.setSpannableFactory(QQText.SPANNABLE_FACTORY);
            if (((DataLineMsgSet)localObject3).isSendFromLocal()) {}
            for (localObject1 = this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131167056);; localObject1 = this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131167052))
            {
              ((ItemHolder)localObject2).a().jdField_a_of_type_AndroidWidgetTextView.setTextColor((ColorStateList)localObject1);
              ((ItemHolder)localObject2).a((ProgressBar)paramView.findViewById(2131377823));
              if (((ItemHolder)localObject2).a() == null) {
                break;
              }
              ((ItemHolder)localObject2).a().setVisibility(8);
              break;
            }
            localObject1 = (RelativeLayout)this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559119, null);
            ((ItemHolder)localObject2).jdField_a_of_type_AndroidWidgetRelativeLayout.addView((View)localObject1);
            ((ItemHolder)localObject2).jdField_a_of_type_AndroidWidgetRelativeLayout.setGravity(17);
            ((ItemHolder)localObject2).a().jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localObject1);
            ((ItemHolder)localObject2).a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView = ((AsyncImageView)paramView.findViewById(2131368729));
            ((ItemHolder)localObject2).a().jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView = ((MessageProgressTextView)paramView.findViewById(2131368746));
            ((ItemHolder)localObject2).a().jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramView.findViewById(2131376658));
            ((ItemHolder)localObject2).a().jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131378438));
            ((ItemHolder)localObject2).a().jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131364796));
            ((ItemHolder)localObject2).a().jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380787));
            if (!((DataLineMsgSet)localObject3).isSendFromLocal())
            {
              ((ItemHolder)localObject2).a().jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380786));
              ((ItemHolder)localObject2).a().jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131368645));
              ((ItemHolder)localObject2).a().jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131378316));
            }
            if (((DataLineMsgSet)localObject3).isSendFromLocal())
            {
              ((ItemHolder)localObject2).a().jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
              ((ItemHolder)localObject2).a().jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setVisibility(0);
              a((ItemHolder)localObject2, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
              label1454:
              ((ItemHolder)localObject2).a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setAsyncClipSize(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
              ((ItemHolder)localObject2).a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setDefaultImageByMargin();
              if (BaseBubbleBuilder.jdField_a_of_type_Boolean) {
                break label1579;
              }
              ((ItemHolder)localObject2).a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setAdjustViewBounds(true);
            }
            for (;;)
            {
              ((ItemHolder)localObject2).a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setIsDrawRound(true);
              ((ItemHolder)localObject2).a().jdField_a_of_type_AndroidWidgetRelativeLayout.setContentDescription(HardCodeUtil.a(2131702789));
              ((ItemHolder)localObject2).a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setContentDescription(HardCodeUtil.a(2131702797));
              break;
              ((ItemHolder)localObject2).a().jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
              ((ItemHolder)localObject2).a().jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setVisibility(8);
              break label1454;
              label1579:
              localObject1 = new AIOSendMask(2130706432, this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.a() * 12.0F);
              ((ItemHolder)localObject2).a().jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setBackgroundDrawable((Drawable)localObject1);
              j = (int)TypedValue.applyDimension(2, 15.0F, this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics());
              ((ItemHolder)localObject2).a().jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setDisplayInTextView(false, j, -1);
            }
            localObject1 = (RelativeLayout)this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559121, null);
            ((ItemHolder)localObject2).jdField_a_of_type_AndroidWidgetRelativeLayout.addView((View)localObject1);
            ((ItemHolder)localObject2).a().jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localObject1);
            ((ItemHolder)localObject2).a().jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131373145));
            ((ItemHolder)localObject2).a().jdField_a_of_type_AndroidWidgetGridView = ((GridView)paramView.findViewById(2131373118));
            ((ItemHolder)localObject2).a().jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramView.findViewById(2131366931));
            ((ItemHolder)localObject2).a().jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131378438));
            ((ItemHolder)localObject2).a().jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380787));
            if (!((DataLineMsgSet)localObject3).isSendFromLocal())
            {
              ((ItemHolder)localObject2).a().jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380786));
              ((ItemHolder)localObject2).a().jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131368645));
              ((ItemHolder)localObject2).a().jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131378316));
            }
            ((ItemHolder)localObject2).a().jdField_a_of_type_AndroidWidgetRelativeLayout.setAddStatesFromChildren(true);
            ((ItemHolder)localObject2).a().jdField_a_of_type_AndroidWidgetTextView.setTag(localObject2);
            ((ItemHolder)localObject2).a().jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
            ((ItemHolder)localObject2).a().jdField_a_of_type_AndroidWidgetTextView.setClickable(true);
            ((ItemHolder)localObject2).a().jdField_a_of_type_AndroidWidgetTextView.setOnLongClickListener(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.jdField_a_of_type_AndroidViewView$OnLongClickListener);
            ((ItemHolder)localObject2).a().jdField_a_of_type_AndroidWidgetTextView.setOnTouchListener(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.jdField_a_of_type_AndroidViewView$OnTouchListener);
            ((ItemHolder)localObject2).a().jdField_a_of_type_AndroidWidgetTextView.setLongClickable(true);
            a(((ItemHolder)localObject2).a().jdField_a_of_type_AndroidWidgetGridView);
            continue;
            localObject4 = (RelativeLayout)this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559113, null);
            ((ItemHolder)localObject2).jdField_a_of_type_AndroidWidgetRelativeLayout.addView((View)localObject4);
            if (FontSettingManager.getFontLevel() > 17.0F)
            {
              ((ItemHolder)localObject2).a().jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localObject4);
              j = AIOUtils.a(70.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
              localObject1 = (RelativeLayout)paramView.findViewById(2131366944);
              localObject5 = new RelativeLayout.LayoutParams(-1, j);
              ((RelativeLayout.LayoutParams)localObject5).addRule(10, 2131366947);
              ((RelativeLayout)localObject4).updateViewLayout((View)localObject1, (ViewGroup.LayoutParams)localObject5);
              localObject4 = (AsyncImageView)paramView.findViewById(2131366920);
              ((AsyncImageView)localObject4).setScaleType(ImageView.ScaleType.CENTER_CROP);
              localObject5 = new RelativeLayout.LayoutParams(j, j);
              ((RelativeLayout.LayoutParams)localObject5).addRule(9, 2131366944);
              ((RelativeLayout.LayoutParams)localObject5).addRule(15, 2131366944);
              ((RelativeLayout)localObject1).updateViewLayout((View)localObject4, (ViewGroup.LayoutParams)localObject5);
              ((ItemHolder)localObject2).a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView = ((AsyncImageView)localObject4);
              localObject4 = (TextView)paramView.findViewById(2131366957);
              ((TextView)localObject4).setGravity(16);
              localObject5 = new RelativeLayout.LayoutParams(-1, -2);
              ((RelativeLayout.LayoutParams)localObject5).addRule(1, 2131366920);
              ((RelativeLayout.LayoutParams)localObject5).addRule(11, 2131366944);
              ((RelativeLayout.LayoutParams)localObject5).addRule(10, 2131366944);
              ((RelativeLayout.LayoutParams)localObject5).setMargins(AIOUtils.a(10.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0, 0, 0);
              ((RelativeLayout)localObject1).updateViewLayout((View)localObject4, (ViewGroup.LayoutParams)localObject5);
              ((ItemHolder)localObject2).a().jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject4);
              localObject4 = (TextView)paramView.findViewById(2131366962);
              ((TextView)localObject4).setGravity(5);
              localObject5 = new RelativeLayout.LayoutParams(-2, -2);
              ((RelativeLayout.LayoutParams)localObject5).addRule(11, 2131366944);
              ((RelativeLayout.LayoutParams)localObject5).addRule(12, 2131366944);
              ((RelativeLayout)localObject1).updateViewLayout((View)localObject4, (ViewGroup.LayoutParams)localObject5);
              ((ItemHolder)localObject2).a().jdField_d_of_type_AndroidWidgetTextView = ((TextView)localObject4);
              localObject4 = (TextView)paramView.findViewById(2131366961);
              ((TextView)localObject4).setGravity(17);
              localObject5 = new RelativeLayout.LayoutParams(-2, -2);
              ((RelativeLayout.LayoutParams)localObject5).addRule(11, 2131366944);
              ((RelativeLayout.LayoutParams)localObject5).addRule(2, 2131366962);
              ((RelativeLayout)localObject1).updateViewLayout((View)localObject4, (ViewGroup.LayoutParams)localObject5);
              ((ItemHolder)localObject2).a().jdField_c_of_type_AndroidWidgetTextView = ((TextView)localObject4);
            }
            for (;;)
            {
              ((ItemHolder)localObject2).a().jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramView.findViewById(2131366931));
              ((ItemHolder)localObject2).a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setDefaultImage(2130851250);
              ((ItemHolder)localObject2).a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setIsDrawRound(false);
              break;
              ((ItemHolder)localObject2).a().jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localObject4);
              ((ItemHolder)localObject2).a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView = ((AsyncImageView)paramView.findViewById(2131366920));
              ((ItemHolder)localObject2).a().jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366957));
              ((ItemHolder)localObject2).a().jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366961));
              ((ItemHolder)localObject2).a().jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366962));
            }
            localObject1 = (RelativeLayout)this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559111, null);
            ((ItemHolder)localObject2).jdField_a_of_type_AndroidWidgetRelativeLayout.addView((View)localObject1);
            ((ItemHolder)localObject2).a().jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localObject1);
            ((ItemHolder)localObject2).a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView = ((AsyncImageView)paramView.findViewById(2131366920));
            ((ItemHolder)localObject2).a().jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366957));
            ((ItemHolder)localObject2).a().jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366934));
            ((ItemHolder)localObject2).a().jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366961));
            ((ItemHolder)localObject2).a().jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366962));
            ((ItemHolder)localObject2).a().jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramView.findViewById(2131366931));
            ((ItemHolder)localObject2).a().e = ((TextView)paramView.findViewById(2131380786));
            ((ItemHolder)localObject2).a().jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131368645));
            ((ItemHolder)localObject2).a().jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131378316));
            ((ItemHolder)localObject2).a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setDefaultImage(2130844368);
            ((ItemHolder)localObject2).a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setIsDrawRound(false);
            continue;
            localObject1 = (RelativeLayout)this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559120, null);
            ((ItemHolder)localObject2).jdField_a_of_type_AndroidWidgetRelativeLayout.addView((View)localObject1);
            ((ItemHolder)localObject2).a().jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localObject1);
            ((ItemHolder)localObject2).a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView = ((AsyncImageView)paramView.findViewById(2131366921));
            ((ItemHolder)localObject2).a().jdField_b_of_type_ComDatalineUtilWidgetAsyncImageView = ((AsyncImageView)paramView.findViewById(2131366922));
            ((ItemHolder)localObject2).a().jdField_c_of_type_ComDatalineUtilWidgetAsyncImageView = ((AsyncImageView)paramView.findViewById(2131366923));
            ((ItemHolder)localObject2).a().jdField_d_of_type_ComDatalineUtilWidgetAsyncImageView = ((AsyncImageView)paramView.findViewById(2131366924));
            ((ItemHolder)localObject2).a().jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366957));
            ((ItemHolder)localObject2).a().jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366934));
            ((ItemHolder)localObject2).a().jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366961));
            ((ItemHolder)localObject2).a().jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366962));
            ((ItemHolder)localObject2).a().jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramView.findViewById(2131366931));
            ((ItemHolder)localObject2).a().e = ((TextView)paramView.findViewById(2131380786));
            ((ItemHolder)localObject2).a().jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131368645));
            ((ItemHolder)localObject2).a().jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131378316));
            ((ItemHolder)localObject2).a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setDefaultImage(2130844369);
            ((ItemHolder)localObject2).a().jdField_b_of_type_ComDatalineUtilWidgetAsyncImageView.setDefaultImage(2130844369);
            ((ItemHolder)localObject2).a().jdField_c_of_type_ComDatalineUtilWidgetAsyncImageView.setDefaultImage(2130844369);
            ((ItemHolder)localObject2).a().jdField_d_of_type_ComDatalineUtilWidgetAsyncImageView.setDefaultImage(2130844369);
            ((ItemHolder)localObject2).a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setIsDrawRound(false);
            ((ItemHolder)localObject2).a().jdField_b_of_type_ComDatalineUtilWidgetAsyncImageView.setIsDrawRound(false);
            ((ItemHolder)localObject2).a().jdField_c_of_type_ComDatalineUtilWidgetAsyncImageView.setIsDrawRound(false);
            ((ItemHolder)localObject2).a().jdField_d_of_type_ComDatalineUtilWidgetAsyncImageView.setIsDrawRound(false);
          }
        }
        label3101:
        if (i == 14)
        {
          if (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
          {
            localObject2 = (ChatBackgroundDrawable)this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.jdField_a_of_type_ComTencentWidgetXPanelContainer.getTag(2131361806);
            if (localObject2 != null)
            {
              i = ChatBackground.a(((ChatBackgroundDrawable)localObject2).getBitmap());
              ((ItemHolder)localObject1).a().jdField_a_of_type_AndroidWidgetTextView.setTextColor(ColorStateList.valueOf(i));
            }
          }
          localObject2 = paramView;
          localObject1 = paramView;
          paramView = (View)localObject2;
        }
        else if (i == 15)
        {
          localObject1 = ((ItemHolder)localObject1).a();
          localObject2 = FileManagerUtil.a(localDataLineMsgRecord.getExtInfoFromExtStr("tim_aio_file_tips"), localDataLineMsgRecord.getExtInfoFromExtStr("tim_aio_file_link"), new DatalineSessionAdapter.4(this, localDataLineMsgRecord));
          ((ItemHolder.TipHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
          ((ItemHolder.TipHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView.setMovementMethod(LinkMovementMethod.getInstance());
          ((ItemHolder.TipHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView.setHighlightColor(17170445);
          localObject2 = paramView;
          localObject1 = paramView;
          paramView = (View)localObject2;
        }
        else
        {
          if (i != 16) {
            break label3393;
          }
          localObject2 = ((ItemHolder)localObject1).a();
          if ((localDataLineMsgRecord == null) || (TextUtils.isEmpty(localDataLineMsgRecord.msg)) || (((ItemHolder.TipHolder)localObject2).jdField_a_of_type_AndroidWidgetTextView == null) || (localDataLineMsgRecord.msg.indexOf(HardCodeUtil.a(2131702792)) < 0)) {
            break label3393;
          }
          localObject1 = FileManagerUtil.a(localDataLineMsgRecord.msg, HardCodeUtil.a(2131702780), new DatalineSessionAdapter.5(this, localDataLineMsgRecord));
          ((ItemHolder.TipHolder)localObject2).jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
          ((ItemHolder.TipHolder)localObject2).jdField_a_of_type_AndroidWidgetTextView.setMovementMethod(LinkMovementMethod.getInstance());
          ((ItemHolder.TipHolder)localObject2).jdField_a_of_type_AndroidWidgetTextView.setHighlightColor(17170445);
          localObject2 = paramView;
          localObject1 = paramView;
          paramView = (View)localObject2;
        }
      }
    }
    label3393:
    switch (i)
    {
    }
    for (;;)
    {
      if (!a(i)) {
        break label3691;
      }
      a(i, (ItemHolder)localObject1, (DataLineMsgSet)localObject3);
      localObject2 = paramView;
      localObject1 = paramView;
      paramView = (View)localObject2;
      break;
      ((ItemHolder)localObject1).a().jdField_a_of_type_JavaLangString = localDataLineMsgRecord.msg;
      ((ItemHolder)localObject1).a().jdField_a_of_type_Long = localDataLineMsgRecord.sessionid;
      localObject2 = ((ItemHolder)localObject1).a().jdField_a_of_type_AndroidWidgetTextView;
      localObject4 = AppConstants.DATALINE_PC_UIN;
      localObject4 = new QQText(localDataLineMsgRecord.msg, 13, 32, 6000);
      ((QQText)localObject4).setBizSrc("biz_src_jc_aio");
      ((TextView)localObject2).setText((CharSequence)localObject4);
      ((TextView)localObject2).setVisibility(0);
      if (((ItemHolder)localObject1).a() != null)
      {
        if ((!localDataLineMsgRecord.issuc) || (localDataLineMsgRecord.progress == 1.0F)) {
          break label3621;
        }
        ((ItemHolder)localObject1).a().setVisibility(0);
      }
      for (;;)
      {
        ((TextView)localObject2).setTextSize(0, ChatTextSizeSettingActivity.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext()));
        break;
        label3621:
        ((ItemHolder)localObject1).a().setVisibility(8);
      }
      c((ItemHolder)localObject1, (DataLineMsgSet)localObject3);
      continue;
      b((ItemHolder)localObject1, (DataLineMsgSet)localObject3);
      continue;
      a((ItemHolder)localObject1, (DataLineMsgSet)localObject3);
      continue;
      b((ItemHolder)localObject1, (DataLineMsgSet)localObject3);
      continue;
      a((ItemHolder)localObject1, (DataLineMsgSet)localObject3);
    }
    label3691:
    a(localDataLineMsgRecord, ((ItemHolder)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout, (ItemHolder)localObject1);
    int k;
    int m;
    if (ThemeUtil.isDefaultTheme())
    {
      i = ((ItemHolder)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.getPaddingLeft();
      j = ((ItemHolder)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.getPaddingRight();
      k = ((ItemHolder)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.getPaddingTop();
      m = ((ItemHolder)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.getPaddingBottom();
      if (!((DataLineMsgSet)localObject3).isSendFromLocal()) {
        ((ItemHolder)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(i + (int)(2.0F * this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.a()), k, j, m);
      }
    }
    else
    {
      label3785:
      if (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
      {
        localObject2 = (ChatBackgroundDrawable)this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.jdField_a_of_type_ComTencentWidgetXPanelContainer.getTag(2131361806);
        if (localObject2 != null)
        {
          i = ChatBackground.a(((ChatBackgroundDrawable)localObject2).getBitmap());
          ((ItemHolder)localObject1).a().setTextColor(ColorStateList.valueOf(i));
        }
      }
      if (!a(((DataLineMsgSet)localObject3).getMsgId())) {
        break label3941;
      }
      localObject2 = TimeFormatterUtils.a(this.jdField_a_of_type_AndroidContentContext, 3, ((DataLineMsgSet)localObject3).getTime() * 1000L);
      ((ItemHolder)localObject1).a().setVisibility(0);
      ((ItemHolder)localObject1).a().setText((CharSequence)localObject2);
    }
    for (;;)
    {
      d((ItemHolder)localObject1, (DataLineMsgSet)localObject3);
      localObject2 = paramView;
      localObject1 = paramView;
      paramView = (View)localObject2;
      break;
      ((ItemHolder)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(i, k, j + (int)(2.0F * this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.a()), m);
      break label3785;
      label3941:
      ((ItemHolder)localObject1).a().setVisibility(8);
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.dataline.util.DatalineSessionAdapter
 * JD-Core Version:    0.7.0.1
 */