package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.Parcelable;
import android.os.Process;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.common.galleryactivity.GalleryImage;
import com.tencent.mobileqq.activity.aio.photo.AIOFilePicData;
import com.tencent.mobileqq.activity.aio.photo.AIOFileVideoData;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import com.tencent.mobileqq.activity.aio.photo.AIOImageListModel;
import com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService;
import com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService.AIOImageProviderListener;
import com.tencent.mobileqq.activity.aio.photo.AIOLightVideoData;
import com.tencent.mobileqq.activity.aio.photo.AIOPhotoListAdapter;
import com.tencent.mobileqq.activity.aio.photo.AIOPhotoListAdapter.ContentHolder;
import com.tencent.mobileqq.activity.aio.photo.AIORichMediaData;
import com.tencent.mobileqq.activity.aio.photo.AIORichMediaInfo;
import com.tencent.mobileqq.activity.aio.photo.AIOShortVideoData;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.filemanager.api.IFMConfig;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import com.tencent.mobileqq.ocr.api.IOCRService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.util.WeakReferenceHandler;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.GestureSelectGridView;
import com.tencent.widget.GestureSelectGridView.OnSelectListener;
import cooperation.peak.PeakUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ChatHistoryImageView
  extends ChatHistoryViewBase
  implements DialogInterface.OnCancelListener, Handler.Callback, AIOImageProviderService.AIOImageProviderListener, INetEventHandler, AbsListView.OnScrollListener, AdapterView.OnItemClickListener, GestureSelectGridView.OnSelectListener
{
  int jdField_a_of_type_Int;
  Activity jdField_a_of_type_AndroidAppActivity;
  Dialog jdField_a_of_type_AndroidAppDialog;
  View jdField_a_of_type_AndroidViewView;
  ChatHistoryImageView.DownloadAndSaveTask jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView$DownloadAndSaveTask;
  public ChatHistoryImageView.OperCallBack a;
  AIOImageListModel jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel;
  public AIOImageProviderService a;
  public AIOPhotoListAdapter a;
  AIORichMediaData jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  WeakReferenceHandler jdField_a_of_type_ComTencentUtilWeakReferenceHandler;
  GestureSelectGridView jdField_a_of_type_ComTencentWidgetGestureSelectGridView;
  String jdField_a_of_type_JavaLangString;
  public ArrayList<AIORichMediaInfo> a;
  boolean jdField_a_of_type_Boolean;
  int jdField_b_of_type_Int;
  View jdField_b_of_type_AndroidViewView;
  boolean jdField_b_of_type_Boolean = false;
  int jdField_c_of_type_Int = -2147483648;
  boolean jdField_c_of_type_Boolean = false;
  int jdField_d_of_type_Int = 2147483647;
  boolean jdField_d_of_type_Boolean = false;
  private int jdField_e_of_type_Int = 0;
  boolean jdField_e_of_type_Boolean = false;
  boolean f;
  boolean g = false;
  boolean h = false;
  
  public ChatHistoryImageView()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public Rect a()
  {
    int i = this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getFirstVisiblePosition();
    int j = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.f();
    View localView = this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getChildAt(j - i);
    if (localView != null)
    {
      Rect localRect = new Rect(localView.getPaddingLeft(), localView.getPaddingTop(), localView.getWidth() - localView.getPaddingRight(), localView.getHeight() - localView.getPaddingBottom());
      i = localView.getWidth();
      j = localView.getHeight();
      ViewGroup localViewGroup = (ViewGroup)localView.getParent();
      Point localPoint = new Point();
      if ((i > 0) && (j > 0))
      {
        localPoint.set(-localView.getScrollX(), -localView.getScrollY());
        if (localViewGroup != null) {
          localViewGroup.getChildVisibleRect(localView, localRect, localPoint);
        }
      }
      return localRect;
    }
    return null;
  }
  
  public View a()
  {
    AccessibilityUtil.a(this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView, false);
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public List<ChatMessage> a()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      AIORichMediaInfo localAIORichMediaInfo = (AIORichMediaInfo)localIterator.next();
      ChatMessage localChatMessage = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.a(localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Long, localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Int);
      if (localChatMessage != null) {
        localArrayList.add(localChatMessage);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.b(localAIORichMediaInfo);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOPhotoListAdapter.notifyDataSetChanged();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a() == 0) {
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    }
    return localArrayList;
  }
  
  public void a()
  {
    AIOPhotoListAdapter localAIOPhotoListAdapter = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOPhotoListAdapter;
    if (localAIOPhotoListAdapter != null) {
      localAIOPhotoListAdapter.a();
    }
  }
  
  void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_AndroidAppDialog == null)
    {
      this.jdField_a_of_type_AndroidAppDialog = new ReportDialog(this.jdField_a_of_type_AndroidAppActivity, 2131756189);
      this.jdField_a_of_type_AndroidAppDialog.setCancelable(true);
      this.jdField_a_of_type_AndroidAppDialog.setContentView(2131559561);
      this.jdField_a_of_type_AndroidAppDialog.setOnCancelListener(this);
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramInt2);
    ((StringBuilder)localObject).append("%");
    localObject = ((StringBuilder)localObject).toString();
    TextView localTextView = (TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131372646);
    StringBuilder localStringBuilder;
    if (paramInt1 != 1)
    {
      if (paramInt1 == 2)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(localTextView.getResources().getText(2131689883));
        localStringBuilder.append((String)localObject);
        localObject = localStringBuilder.toString();
      }
    }
    else
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(localTextView.getResources().getText(2131689885));
      localStringBuilder.append((String)localObject);
      localObject = localStringBuilder.toString();
    }
    localTextView.setText((CharSequence)localObject);
    if (!this.jdField_a_of_type_AndroidAppDialog.isShowing()) {}
    try
    {
      this.jdField_a_of_type_AndroidAppDialog.show();
      return;
    }
    catch (Exception localException) {}
  }
  
  void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[showDialog] type = ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("ChatHistoryImageView", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
    if ((localObject != null) && (((QQCustomDialog)localObject).isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this.jdField_a_of_type_AndroidAppActivity, 230);
    localObject = new ChatHistoryImageView.3(this);
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt == 4)
          {
            this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setCancelable(false);
            this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setNegativeButton(2131690728, new ChatHistoryImageView.6(this));
            this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPositiveButton(2131718876, new ChatHistoryImageView.7(this));
          }
        }
        else
        {
          this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setNegativeButton(2131690728, (DialogInterface.OnClickListener)localObject);
          this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPositiveButton(2131718876, new ChatHistoryImageView.5(this));
        }
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setNegativeButton(2131690728, (DialogInterface.OnClickListener)localObject);
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPositiveButton(2131718876, new ChatHistoryImageView.4(this));
      }
    }
    else {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setNegativeButton(2131719065, (DialogInterface.OnClickListener)localObject);
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessage(paramString);
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
      return;
    }
    catch (Exception paramString) {}
  }
  
  public void a(long paramLong)
  {
    if (!this.h)
    {
      localObject = this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler;
      if (localObject != null)
      {
        ((WeakReferenceHandler)localObject).post(new ChatHistoryImageView.1(this, paramLong));
        return;
      }
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onRevokeMsg, seq:");
    ((StringBuilder)localObject).append(paramLong);
    ((StringBuilder)localObject).append(", mDestroy:");
    ((StringBuilder)localObject).append(this.h);
    QLog.i("ChatHistoryImageView", 2, ((StringBuilder)localObject).toString());
  }
  
  public void a(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2, boolean paramBoolean) {}
  
  public void a(long paramLong, int paramInt1, int paramInt2, int paramInt3, String arg6, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("[onImageDownload] id=");
      ((StringBuilder)localObject1).append(paramLong);
      ((StringBuilder)localObject1).append(",subId=");
      ((StringBuilder)localObject1).append(paramInt1);
      QLog.d("ChatHistoryImageView", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel;
    if (paramInt3 != 1) {
      ??? = "I:E";
    }
    paramInt1 = ((AIOImageListModel)localObject1).a(paramLong, paramInt1, paramInt2, ???, true);
    if (paramInt2 == 2)
    {
      if (paramInt1 >= 0)
      {
        ??? = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a(paramInt1);
        if (!AIORichMediaInfo.class.isInstance(???)) {
          return;
        }
        ??? = (AIORichMediaInfo)???;
        ???.jdField_a_of_type_Int = 0;
        ???.jdField_a_of_type_Boolean = false;
        paramInt2 = this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getFirstVisiblePosition();
        paramInt3 = this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getChildCount();
        if ((paramInt1 >= paramInt2) && (paramInt1 <= paramInt3 + paramInt2 - 1)) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOPhotoListAdapter.a(paramInt1, this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getChildAt(paramInt1 - paramInt2));
        }
        ??? = this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView$DownloadAndSaveTask;
        if ((??? != null) && (???.a != null)) {
          synchronized (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView$DownloadAndSaveTask.a)
          {
            this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView$DownloadAndSaveTask.a.notifyAll();
            return;
          }
        }
      }
    }
    else if (paramInt2 == 1)
    {
      paramInt2 = this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getFirstVisiblePosition();
      paramInt3 = this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getChildCount();
      if ((paramInt1 >= paramInt2) && (paramInt1 <= paramInt3 + paramInt2 - 1))
      {
        ??? = this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getChildAt(paramInt1 - paramInt2);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOPhotoListAdapter.a(paramInt1, ???);
      }
    }
    else if (paramInt2 == 16)
    {
      paramInt2 = this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getFirstVisiblePosition();
      paramInt3 = this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getChildCount();
      if ((paramInt1 >= paramInt2) && (paramInt1 <= paramInt3 + paramInt2 - 1))
      {
        ??? = this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getChildAt(paramInt1 - paramInt2);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOPhotoListAdapter.a(paramInt1, ???);
      }
    }
  }
  
  public void a(Intent paramIntent)
  {
    if ((paramIntent != null) && ((paramIntent.getParcelableExtra("extra.EXTRA_CURRENT_IMAGE") instanceof AIORichMediaData))) {
      a((AIORichMediaData)paramIntent.getParcelableExtra("extra.EXTRA_CURRENT_IMAGE"), true);
    }
    if (!((IFMConfig)QRoute.api(IFMConfig.class)).preDownloadThumb()) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOPhotoListAdapter.notifyDataSetChanged();
    }
  }
  
  public void a(Intent paramIntent, QQAppInterface paramQQAppInterface, Context paramContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidAppActivity = ((Activity)paramContext);
    this.jdField_a_of_type_Boolean = paramIntent.getBooleanExtra("extra.IS_FROM_CHAT_AIO_GALLERY", false);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData = ((AIORichMediaData)paramIntent.getParcelableExtra("extra.EXTRA_CURRENT_IMAGE"));
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(this);
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(paramContext).inflate(2131560814, null);
    this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView = ((GestureSelectGridView)this.jdField_a_of_type_AndroidViewView.findViewById(2131367813));
    this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setSelectMode(false);
    int i = this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131297488);
    int j = this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131297489);
    int k = this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131297490);
    this.jdField_a_of_type_Int = ((ViewUtils.a() - i * 2 - j * 3) / 4);
    this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setGravity(3);
    this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setScrollBarStyle(0);
    this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setNumColumns(4);
    this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setColumnWidth(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setHorizontalSpacing(j);
    this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setVerticalSpacing(k);
    paramQQAppInterface = this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView;
    paramQQAppInterface.setPadding(i, paramQQAppInterface.getPaddingTop(), i, this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getPaddingBottom());
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131366237);
    if (AppSetting.jdField_d_of_type_Boolean) {
      this.jdField_b_of_type_AndroidViewView.setContentDescription(this.jdField_a_of_type_AndroidAppActivity.getString(2131692409));
    }
    this.jdField_b_of_type_Int = paramIntent.getIntExtra("uintype", -1);
    this.jdField_a_of_type_JavaLangString = paramIntent.getStringExtra("uin");
    g();
    this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setOnScrollListener(this);
    this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setOnIndexChangedListener(this);
    AccessibilityUtil.a(this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView, false);
  }
  
  void a(AIORichMediaData paramAIORichMediaData, boolean paramBoolean)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.g())
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a(i);
      if (AIORichMediaInfo.class.isInstance(localObject))
      {
        localObject = (AIORichMediaInfo)localObject;
        if ((((AIORichMediaInfo)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Long == paramAIORichMediaData.jdField_f_of_type_Long) && (((AIORichMediaInfo)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Int == paramAIORichMediaData.jdField_f_of_type_Int))
        {
          j = 1;
          break label90;
        }
      }
      i += 1;
    }
    int j = 0;
    label90:
    if (j != 0)
    {
      if (QLog.isColorLevel())
      {
        paramAIORichMediaData = new StringBuilder();
        paramAIORichMediaData.append("[setSelectionTo] index=");
        paramAIORichMediaData.append(i);
        paramAIORichMediaData.append(", fist=");
        paramAIORichMediaData.append(this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getFirstVisiblePosition());
        paramAIORichMediaData.append(", last=");
        paramAIORichMediaData.append(this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getLastVisiblePosition());
        QLog.d("ChatHistoryImageView", 2, paramAIORichMediaData.toString());
      }
      if ((i >= this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getFirstVisiblePosition()) && (i <= this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getLastVisiblePosition())) {
        return;
      }
      if (paramBoolean)
      {
        this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setSelection(i);
        return;
      }
      j = i - 12;
      i = j;
      if (j < 0) {
        i = 0;
      }
      this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setSelection(i);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    AIOPhotoListAdapter localAIOPhotoListAdapter = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOPhotoListAdapter;
    if (localAIOPhotoListAdapter != null) {
      localAIOPhotoListAdapter.a(paramBoolean);
    }
  }
  
  public void a(AIORichMediaData[] paramArrayOfAIORichMediaData, int paramInt)
  {
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.post(new ChatHistoryImageView.2(this, paramArrayOfAIORichMediaData, paramInt));
  }
  
  public boolean a()
  {
    AIOPhotoListAdapter localAIOPhotoListAdapter = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOPhotoListAdapter;
    if (localAIOPhotoListAdapter != null) {
      return localAIOPhotoListAdapter.a();
    }
    return false;
  }
  
  boolean a(View paramView, GalleryImage paramGalleryImage)
  {
    Object localObject = (AIOPhotoListAdapter.ContentHolder)paramView.getTag();
    if (localObject != null)
    {
      paramView = ((AIOPhotoListAdapter.ContentHolder)localObject).a;
      localObject = ((AIOPhotoListAdapter.ContentHolder)localObject).b;
      int i = paramGalleryImage.getSelected();
      if (i != 1)
      {
        if (i != 2)
        {
          paramView.setVisibility(4);
          ((ImageView)localObject).setVisibility(4);
          return true;
        }
        paramView.setVisibility(4);
        ((ImageView)localObject).setImageResource(2130845863);
        ((ImageView)localObject).setVisibility(0);
        return true;
      }
      paramView.setVisibility(0);
      ((ImageView)localObject).setImageResource(2130845866);
      ((ImageView)localObject).setVisibility(0);
      return true;
    }
    return false;
  }
  
  boolean a(AIORichMediaInfo paramAIORichMediaInfo, boolean paramBoolean)
  {
    int i = paramAIORichMediaInfo.getSelected();
    if (((i == 1) && (paramBoolean)) || ((i == 2) && (!paramBoolean))) {
      return false;
    }
    ChatMessage localChatMessage = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.a(paramAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Long);
    ChatHistoryImageView.OperCallBack localOperCallBack;
    if (paramBoolean)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity.a())) {
        return false;
      }
      localOperCallBack = this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView$OperCallBack;
      if ((localOperCallBack != null) && (localOperCallBack.a())) {
        return false;
      }
      localOperCallBack = this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView$OperCallBack;
      if ((localOperCallBack != null) && (!localOperCallBack.a(paramAIORichMediaInfo))) {
        return false;
      }
      localOperCallBack = this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView$OperCallBack;
      if ((localOperCallBack != null) && (localChatMessage != null)) {
        localOperCallBack.a(localChatMessage);
      }
      paramAIORichMediaInfo.setSelected(1);
      this.jdField_a_of_type_JavaUtilArrayList.add(paramAIORichMediaInfo);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity.a(paramAIORichMediaInfo);
        if (localChatMessage != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity.a(localChatMessage);
          return true;
        }
      }
    }
    else
    {
      paramAIORichMediaInfo.setSelected(2);
      this.jdField_a_of_type_JavaUtilArrayList.remove(paramAIORichMediaInfo);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity.b(paramAIORichMediaInfo);
        if (localChatMessage != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity.d(localChatMessage);
        }
      }
      localOperCallBack = this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView$OperCallBack;
      if (localOperCallBack != null)
      {
        localOperCallBack.a(paramAIORichMediaInfo);
        if (localChatMessage != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView$OperCallBack.b(localChatMessage);
        }
      }
    }
    return true;
  }
  
  public void b()
  {
    this.g = true;
  }
  
  public boolean b()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public void c()
  {
    this.g = false;
  }
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.a();
    if (this.jdField_d_of_type_Boolean) {
      AppNetConnInfo.unregisterNetEventHandler(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView$OperCallBack = null;
    this.h = true;
  }
  
  public void e()
  {
    if (!this.jdField_c_of_type_Boolean)
    {
      this.jdField_c_of_type_Boolean = true;
      AIOPhotoListAdapter localAIOPhotoListAdapter = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOPhotoListAdapter;
      localAIOPhotoListAdapter.jdField_a_of_type_Boolean = true;
      localAIOPhotoListAdapter.notifyDataSetChanged();
      this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setSelectMode(true);
    }
  }
  
  public void f()
  {
    if (this.jdField_c_of_type_Boolean)
    {
      this.jdField_c_of_type_Boolean = false;
      Object localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((GalleryImage)((Iterator)localObject).next()).setSelected(2);
      }
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOPhotoListAdapter;
      ((AIOPhotoListAdapter)localObject).jdField_a_of_type_Boolean = false;
      ((AIOPhotoListAdapter)localObject).notifyDataSetChanged();
      this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setSelectMode(false);
    }
  }
  
  public void g()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService = AIOImageProviderService.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_Int, null, this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.a(this);
    int i = 0;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel = new AIOImageListModel(false);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOPhotoListAdapter = new AIOPhotoListAdapter(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService, this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOPhotoListAdapter.a(this.jdField_b_of_type_Int);
    this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOPhotoListAdapter);
    this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setOnItemClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOPhotoListAdapter.a(true);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOPhotoListAdapter.b(2);
    AIOImageProviderService localAIOImageProviderService = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService;
    if (this.jdField_a_of_type_Boolean) {
      i = 2;
    }
    localAIOImageProviderService.a(i);
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.isEmpty()) {
      return;
    }
    Object localObject1 = (AIORichMediaInfo)this.jdField_a_of_type_JavaUtilArrayList.get(0);
    if ((!AIOImageData.class.isInstance(((AIORichMediaInfo)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)) && (!AIOFilePicData.class.isInstance(((AIORichMediaInfo)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)))
    {
      if (AIOShortVideoData.class.isInstance(((AIORichMediaInfo)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.a(((AIORichMediaInfo)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Long, ((AIORichMediaInfo)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Int, this.jdField_b_of_type_Int);
        if (localObject1 != null)
        {
          ForwardBaseOption.a(this.jdField_a_of_type_AndroidAppActivity, (Intent)localObject1);
          if (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity != null) {
            this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity.a();
          }
        }
      }
      else if (AIOFileVideoData.class.isInstance(((AIORichMediaInfo)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))
      {
        Object localObject2 = (AIOFileVideoData)((AIORichMediaInfo)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.a(((AIOFileVideoData)localObject2).jdField_f_of_type_Long);
        if ((localObject2 instanceof MessageForFile))
        {
          if (FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForFile)localObject2).sendCloudUnsuccessful())
          {
            FMToastUtil.a(HardCodeUtil.a(2131701837));
            if (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity != null) {
              this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity.a();
            }
            return;
          }
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.a(((AIORichMediaInfo)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Long, ((AIORichMediaInfo)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Int, this.jdField_b_of_type_Int);
          if (localObject1 != null)
          {
            ForwardBaseOption.a(this.jdField_a_of_type_AndroidAppActivity, (Intent)localObject1);
            if (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity != null) {
              this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity.a();
            }
          }
        }
        else if ((localObject2 instanceof MessageForTroopFile))
        {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.a(((AIORichMediaInfo)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Long, ((AIORichMediaInfo)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Int, this.jdField_b_of_type_Int);
          if (localObject1 != null)
          {
            ForwardBaseOption.a(this.jdField_a_of_type_AndroidAppActivity, (Intent)localObject1);
            if (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity != null) {
              this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity.a();
            }
          }
        }
      }
    }
    else {
      i();
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 102: 
      paramMessage = this.jdField_a_of_type_AndroidAppDialog;
      if ((paramMessage != null) && (paramMessage.isShowing())) {
        this.jdField_a_of_type_AndroidAppDialog.cancel();
      }
      QQToast.a(BaseApplication.getContext(), 1, 2131692408, 0).a();
      return true;
    case 101: 
      paramMessage = this.jdField_a_of_type_AndroidAppDialog;
      if (paramMessage != null)
      {
        paramMessage.dismiss();
        this.jdField_a_of_type_AndroidAppDialog = null;
      }
      return true;
    }
    a(paramMessage.arg1, paramMessage.arg2);
    return true;
  }
  
  public void i()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatHistoryImageView", 2, "[forward]");
    }
    int i = 0;
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      AIORichMediaInfo localAIORichMediaInfo = (AIORichMediaInfo)localIterator.next();
      if (AIOImageData.class.isInstance(localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)) {
        if (localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.g == 1 ? (localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.a(4) != null) || (localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.a(2) != null) || (localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.a(1) != null) : localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.a(2) != null) {
          break;
        }
      } else {
        for (;;)
        {
          i += 1;
          break;
          if ((!AIOFilePicData.class.isInstance(localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)) || (localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.a(20) != null) || (localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.a(18) != null) || (localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.a(16) != null)) {
            break;
          }
        }
      }
    }
    if (i == 0)
    {
      j();
      return;
    }
    if (i != this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatHistoryImageView", 2, "[forwardAllImage] hasForwardImg = false");
      }
      a(3, HardCodeUtil.a(2131701803));
      return;
    }
    FMToastUtil.a(HardCodeUtil.a(2131701833));
  }
  
  void j()
  {
    Object localObject1 = this.jdField_a_of_type_JavaUtilArrayList;
    if ((localObject1 != null) && (((ArrayList)localObject1).get(0) != null))
    {
      localObject1 = (AIORichMediaInfo)this.jdField_a_of_type_JavaUtilArrayList.get(0);
      Object localObject2;
      Object localObject3;
      AIORichMediaInfo localAIORichMediaInfo;
      if (AIOImageData.class.isInstance(((AIORichMediaInfo)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))
      {
        localObject2 = (AIOImageData)((AIORichMediaInfo)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
        localObject1 = new Bundle();
        ((Bundle)localObject1).putInt("forward_type", 12);
        localObject3 = ((AIOImageData)localObject2).a(2);
        ((Bundle)localObject1).putString("forward_urldrawable_thumb_url", ((AIOImageData)localObject2).a(1));
        ((Bundle)localObject1).putString("forward_urldrawable_big_url", (String)localObject3);
        ((Bundle)localObject1).putBoolean("forward_urldrawable", true);
        if (this.jdField_a_of_type_JavaUtilArrayList.size() > 1)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(this.jdField_a_of_type_JavaUtilArrayList.size());
          ((StringBuilder)localObject2).append(HardCodeUtil.a(2131701868));
          ((Bundle)localObject1).putString("forward_text", ((StringBuilder)localObject2).toString());
        }
        ((Bundle)localObject1).putBoolean("sendMultiple", true);
        ((Bundle)localObject1).putBoolean("key_allow_forward_photo_preview_edit", true);
        localObject2 = new ArrayList();
        localObject3 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localAIORichMediaInfo = (AIORichMediaInfo)((Iterator)localObject3).next();
          if (AIOImageData.class.isInstance(localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))
          {
            if (localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.g == 1)
            {
              if (localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.a(4) != null) {
                ((ArrayList)localObject2).add(((AIOImageData)localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).c);
              } else if (localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.a(2) != null) {
                ((ArrayList)localObject2).add(((AIOImageData)localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).b);
              } else if (localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.a(1) != null) {
                ((ArrayList)localObject2).add(((AIOImageData)localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).jdField_a_of_type_JavaLangString);
              }
            }
            else {
              ((ArrayList)localObject2).add(((AIOImageData)localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).b);
            }
          }
          else if (AIOFilePicData.class.isInstance(localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)) {
            if (localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.a(20) != null) {
              ((ArrayList)localObject2).add(((AIOFilePicData)localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).d);
            } else if (localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.a(18) != null) {
              ((ArrayList)localObject2).add(((AIOFilePicData)localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).c);
            } else if (localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.a(16) != null) {
              ((ArrayList)localObject2).add(((AIOFilePicData)localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).b);
            }
          }
        }
        ((Bundle)localObject1).putStringArrayList("PhotoConst.PHOTO_PATHS", (ArrayList)localObject2);
        localObject2 = new Intent();
        ((Intent)localObject2).putExtras((Bundle)localObject1);
        ForwardBaseOption.a(this.jdField_a_of_type_AndroidAppActivity, (Intent)localObject2, 1);
        return;
      }
      if (AIOFilePicData.class.isInstance(((AIORichMediaInfo)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))
      {
        localObject2 = (AIOFilePicData)((AIORichMediaInfo)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
        localObject1 = new Bundle();
        ((Bundle)localObject1).putInt("forward_type", 12);
        localObject3 = ((AIOFilePicData)localObject2).a(18);
        ((Bundle)localObject1).putString("forward_urldrawable_thumb_url", ((AIOFilePicData)localObject2).a(16));
        ((Bundle)localObject1).putString("forward_urldrawable_big_url", (String)localObject3);
        ((Bundle)localObject1).putBoolean("forward_urldrawable", true);
        if (this.jdField_a_of_type_JavaUtilArrayList.size() > 1)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(this.jdField_a_of_type_JavaUtilArrayList.size());
          ((StringBuilder)localObject2).append(HardCodeUtil.a(2131701852));
          ((Bundle)localObject1).putString("forward_text", ((StringBuilder)localObject2).toString());
        }
        ((Bundle)localObject1).putBoolean("sendMultiple", true);
        localObject2 = new ArrayList();
        localObject3 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localAIORichMediaInfo = (AIORichMediaInfo)((Iterator)localObject3).next();
          if (AIOImageData.class.isInstance(localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)) {
            ((ArrayList)localObject2).add(((AIOImageData)localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).b);
          } else if (AIOFilePicData.class.isInstance(localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)) {
            if (localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.a(20) != null) {
              ((ArrayList)localObject2).add(((AIOFilePicData)localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).d);
            } else if (localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.a(18) != null) {
              ((ArrayList)localObject2).add(((AIOFilePicData)localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).c);
            } else if (localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.a(16) != null) {
              ((ArrayList)localObject2).add(((AIOFilePicData)localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).b);
            }
          }
        }
        ((Bundle)localObject1).putStringArrayList("PhotoConst.PHOTO_PATHS", (ArrayList)localObject2);
        localObject2 = new Intent();
        ((Intent)localObject2).putExtras((Bundle)localObject1);
        ForwardBaseOption.a(this.jdField_a_of_type_AndroidAppActivity, (Intent)localObject2, 1);
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.d("ChatHistoryImageView", 2, "callForwardRecentActivity error! mSelectedPhotoList ==null || mSelectedPhotoList.get(0) == null || !mSelectedPhotoList.get(0) instanceof AIOImageInfo");
    }
  }
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(102);
    this.jdField_a_of_type_AndroidAppDialog = null;
    paramDialogInterface = this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView$DownloadAndSaveTask;
    if (paramDialogInterface != null) {
      paramDialogInterface.jdField_c_of_type_Boolean = false;
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a(paramInt);
    if (!AIORichMediaInfo.class.isInstance(paramAdapterView)) {
      return;
    }
    paramAdapterView = (AIORichMediaInfo)paramAdapterView;
    boolean bool = this.jdField_c_of_type_Boolean;
    int i = 0;
    if (bool)
    {
      paramInt = i;
      if (paramAdapterView.getSelected() == 1) {
        paramInt = 1;
      }
      if ((a(paramAdapterView, paramInt ^ 0x1)) && (!a(paramView, paramAdapterView))) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOPhotoListAdapter.notifyDataSetChanged();
      }
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.e(paramInt);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.b(this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getFirstVisiblePosition());
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.c(this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getLastVisiblePosition());
      if (AIOShortVideoData.class.isInstance(paramAdapterView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))
      {
        paramView = (AIOShortVideoData)paramAdapterView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
        if ((paramView.jdField_b_of_type_Int == 0) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.a(paramView.jdField_f_of_type_Long) != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isVideoChatting())) {
          QQToast.a(BaseApplication.getContext(), 0, 2131719097, 0).b(this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131299168));
        }
      }
      else if (AIOFileVideoData.class.isInstance(paramAdapterView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))
      {
        paramView = (AIOFileVideoData)paramAdapterView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
        paramView = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.a(paramView.jdField_f_of_type_Long);
        if ((paramView instanceof MessageForFile))
        {
          paramView = FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForFile)paramView);
          if (paramView == null) {
            return;
          }
          if (FileUtil.a(paramView.getFilePath()))
          {
            if (QLog.isDevelopLevel())
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("file existed! isLocalFile:");
              ((StringBuilder)localObject).append(paramView.nSessionId);
              QLog.i("PauseDebug", 1, ((StringBuilder)localObject).toString());
            }
            if ((paramAdapterView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData instanceof AIOFileVideoData)) {
              ((AIOFileVideoData)paramAdapterView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).c = paramView.getFilePath();
            }
          }
          else if (paramView.sendCloudUnsuccessful())
          {
            FMToastUtil.a(HardCodeUtil.a(2131701835));
            return;
          }
          ShortVideoUtils.reportVideoPlay(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_JavaLangString, String.valueOf(0), this.jdField_b_of_type_Int, "3", "3");
        }
      }
      else if (AIOLightVideoData.class.isInstance(paramAdapterView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ChatHistoryImageView", 2, "lightvideo could not be opened in chathistory");
        }
        QQToast.a(BaseApplication.getContext(), HardCodeUtil.a(2131701875), 0).a();
        return;
      }
      paramView = new Bundle();
      Object localObject = a();
      if (localObject != null) {
        paramView.putParcelable("KEY_THUMBNAL_BOUND", (Parcelable)localObject);
      }
      if (this.jdField_b_of_type_Int == 3000) {
        paramView.putInt("extra.EXTRA_FORWARD_TO_QZONE_SRC", 2);
      } else {
        paramView.putInt("extra.EXTRA_FORWARD_TO_QZONE_SRC", 1);
      }
      paramView.putInt("extra.MOBILE_QQ_PROCESS_ID", Process.myPid());
      paramView.putBoolean("extra.IS_FROM_CHAT_FILE_HISTORY", true);
      paramView.putString("uin", this.jdField_a_of_type_JavaLangString);
      paramView.putInt("forward_source_uin_type", this.jdField_b_of_type_Int);
      paramView.putBoolean("extra.OCR", ((IOCRService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IOCRService.class, "")).isSupportOcr(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 7));
      if (this.jdField_b_of_type_Int == 1)
      {
        localObject = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).c(this.jdField_a_of_type_JavaLangString);
        if (localObject != null) {
          paramView.putString("extra.GROUP_UIN", ((TroopInfo)localObject).troopuin);
        }
      }
      paramView.putBoolean("extra.ENTER_NEW_GALLERY", true);
      PeakUtils.a(this.jdField_a_of_type_AndroidAppActivity, paramView, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService, paramAdapterView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData, 2, 3);
      if ((paramAdapterView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData != null) && ((paramAdapterView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData instanceof AIOShortVideoData))) {
        ShortVideoUtils.reportVideoPlay(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_JavaLangString, String.valueOf(((AIOShortVideoData)paramAdapterView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).jdField_a_of_type_Int * 1000), this.jdField_b_of_type_Int, "2", "3");
      }
    }
  }
  
  public void onNetChangeEvent(boolean paramBoolean)
  {
    if (AppNetConnInfo.isMobileConn())
    {
      ChatHistoryImageView.DownloadAndSaveTask localDownloadAndSaveTask = this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView$DownloadAndSaveTask;
      if ((localDownloadAndSaveTask != null) && (localDownloadAndSaveTask.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView$DownloadAndSaveTask.jdField_d_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView$DownloadAndSaveTask.jdField_b_of_type_Boolean))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ChatHistoryImageView", 2, "[onNetChangeEvent] show dialog");
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView$DownloadAndSaveTask.a(true);
        a(4, this.jdField_a_of_type_AndroidAppActivity.getString(2131692407));
      }
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 0)
    {
      paramInt = this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getLastVisiblePosition();
      int i = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.g();
      int j = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.h();
      if (((paramInt >= i - 28) || (paramInt == i)) && (this.jdField_e_of_type_Int != j))
      {
        if (QLog.isColorLevel())
        {
          paramAbsListView = new StringBuilder();
          paramAbsListView.append("[onScroll] loadMedias: mLastLoadingCount=");
          paramAbsListView.append(this.jdField_e_of_type_Int);
          QLog.d("ChatHistoryImageView", 2, paramAbsListView.toString());
        }
        this.jdField_e_of_type_Int = j;
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOPhotoListAdapter.a(true);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.a(0);
      }
    }
  }
  
  public void onSelectBegin(int paramInt)
  {
    if (!this.jdField_c_of_type_Boolean) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.g() <= paramInt) {
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a(paramInt);
    if (!AIORichMediaInfo.class.isInstance(localObject)) {
      return;
    }
    localObject = (AIORichMediaInfo)localObject;
    boolean bool;
    if (((AIORichMediaInfo)localObject).getSelected() == 1) {
      bool = true;
    } else {
      bool = false;
    }
    this.jdField_e_of_type_Boolean = bool;
    if (a((AIORichMediaInfo)localObject, this.jdField_e_of_type_Boolean ^ true))
    {
      this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.invalidateViews();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOPhotoListAdapter.notifyDataSetChanged();
    }
    this.f = true;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onSelectBegin beginIndex:");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("ChatHistoryImageView", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void onSelectChanged(int paramInt1, int paramInt2)
  {
    if (!this.jdField_c_of_type_Boolean) {
      return;
    }
    if (!this.f) {
      return;
    }
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onSelectChanged beginIndex:");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(" selectIndex:");
      ((StringBuilder)localObject).append(paramInt2);
      QLog.d("ChatHistoryImageView", 2, ((StringBuilder)localObject).toString());
    }
    int i;
    int j;
    if (paramInt2 < paramInt1)
    {
      if (this.jdField_d_of_type_Int > paramInt2) {
        this.jdField_d_of_type_Int = paramInt2;
      }
      i = paramInt2;
      j = paramInt1;
    }
    else
    {
      i = paramInt1;
      j = paramInt2;
      if (this.jdField_c_of_type_Int < paramInt2)
      {
        this.jdField_c_of_type_Int = paramInt2;
        j = paramInt2;
        i = paramInt1;
      }
    }
    paramInt1 = i;
    for (;;)
    {
      paramInt2 = j;
      if (paramInt1 > j) {
        break;
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a(paramInt1);
      if (AIORichMediaInfo.class.isInstance(localObject)) {
        a((AIORichMediaInfo)localObject, this.jdField_e_of_type_Boolean ^ true);
      }
      paramInt1 += 1;
    }
    for (;;)
    {
      paramInt2 += 1;
      if (paramInt2 > this.jdField_c_of_type_Int) {
        break;
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a(paramInt2);
      if (AIORichMediaInfo.class.isInstance(localObject)) {
        a((AIORichMediaInfo)localObject, this.jdField_e_of_type_Boolean);
      }
    }
    paramInt1 = this.jdField_d_of_type_Int;
    while (paramInt1 < i)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a(paramInt1);
      if (AIORichMediaInfo.class.isInstance(localObject)) {
        a((AIORichMediaInfo)localObject, this.jdField_e_of_type_Boolean);
      }
      paramInt1 += 1;
    }
    this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.invalidateViews();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOPhotoListAdapter.notifyDataSetChanged();
  }
  
  public void onSelectEnd()
  {
    if (!this.jdField_c_of_type_Boolean) {
      return;
    }
    if (!this.f) {
      return;
    }
    this.f = false;
    if (QLog.isColorLevel()) {
      QLog.d("ChatHistoryImageView", 2, "onSelectEnd");
    }
    this.jdField_e_of_type_Boolean = false;
    this.jdField_c_of_type_Int = -2147483648;
    this.jdField_d_of_type_Int = 2147483647;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatHistoryImageView
 * JD-Core Version:    0.7.0.1
 */