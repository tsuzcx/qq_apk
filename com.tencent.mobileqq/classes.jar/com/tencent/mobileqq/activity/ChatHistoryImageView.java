package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
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
import com.tencent.mobileqq.ocr.OCRManager;
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
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOPhotoListAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOPhotoListAdapter.a();
    }
  }
  
  public void a(int paramInt)
  {
    boolean bool2 = false;
    if (!this.jdField_c_of_type_Boolean) {}
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.g() <= paramInt);
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a(paramInt);
    } while (!AIORichMediaInfo.class.isInstance(localObject));
    Object localObject = (AIORichMediaInfo)localObject;
    if (((AIORichMediaInfo)localObject).getSelected() == 1) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      this.jdField_e_of_type_Boolean = bool1;
      bool1 = bool2;
      if (!this.jdField_e_of_type_Boolean) {
        bool1 = true;
      }
      if (a((AIORichMediaInfo)localObject, bool1))
      {
        this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.invalidateViews();
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOPhotoListAdapter.notifyDataSetChanged();
      }
      this.f = true;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ChatHistoryImageView", 2, "onSelectBegin beginIndex:" + paramInt);
      return;
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (!this.jdField_c_of_type_Boolean) {}
    while (!this.f) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ChatHistoryImageView", 2, "onSelectChanged beginIndex:" + paramInt1 + " selectIndex:" + paramInt2);
    }
    int j;
    int i;
    if (paramInt2 < paramInt1)
    {
      j = paramInt1;
      i = paramInt2;
      if (this.jdField_d_of_type_Int > paramInt2)
      {
        this.jdField_d_of_type_Int = paramInt2;
        i = paramInt2;
        j = paramInt1;
      }
    }
    for (;;)
    {
      paramInt1 = i;
      for (;;)
      {
        if (paramInt1 > j) {
          break label176;
        }
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a(paramInt1);
        if (AIORichMediaInfo.class.isInstance(localObject)) {
          break;
        }
        paramInt1 += 1;
      }
      if (this.jdField_c_of_type_Int < paramInt2) {
        this.jdField_c_of_type_Int = paramInt2;
      }
      j = paramInt2;
      i = paramInt1;
    }
    Object localObject = (AIORichMediaInfo)localObject;
    if (!this.jdField_e_of_type_Boolean) {}
    for (boolean bool = true;; bool = false)
    {
      a((AIORichMediaInfo)localObject, bool);
      break;
    }
    label176:
    paramInt1 = j + 1;
    if (paramInt1 <= this.jdField_c_of_type_Int)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a(paramInt1);
      if (!AIORichMediaInfo.class.isInstance(localObject)) {}
      for (;;)
      {
        paramInt1 += 1;
        break;
        a((AIORichMediaInfo)localObject, this.jdField_e_of_type_Boolean);
      }
    }
    paramInt1 = this.jdField_d_of_type_Int;
    if (paramInt1 < i)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a(paramInt1);
      if (!AIORichMediaInfo.class.isInstance(localObject)) {}
      for (;;)
      {
        paramInt1 += 1;
        break;
        a((AIORichMediaInfo)localObject, this.jdField_e_of_type_Boolean);
      }
    }
    this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.invalidateViews();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOPhotoListAdapter.notifyDataSetChanged();
  }
  
  void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatHistoryImageView", 2, "[showDialog] type = " + paramInt);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this.jdField_a_of_type_AndroidAppActivity, 230);
    ChatHistoryImageView.3 local3 = new ChatHistoryImageView.3(this);
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessage(paramString);
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
        return;
      }
      catch (Exception paramString) {}
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setNegativeButton(2131719347, local3);
      continue;
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setNegativeButton(2131690800, local3);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPositiveButton(2131719158, new ChatHistoryImageView.4(this));
      continue;
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setNegativeButton(2131690800, local3);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPositiveButton(2131719158, new ChatHistoryImageView.5(this));
      continue;
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setCancelable(false);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setNegativeButton(2131690800, new ChatHistoryImageView.6(this));
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPositiveButton(2131719158, new ChatHistoryImageView.7(this));
    }
  }
  
  public void a(long paramLong)
  {
    if ((this.h) || (this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler == null))
    {
      QLog.i("ChatHistoryImageView", 2, "onRevokeMsg, seq:" + paramLong + ", mDestroy:" + this.h);
      return;
    }
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.post(new ChatHistoryImageView.1(this, paramLong));
  }
  
  public void a(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2, boolean paramBoolean) {}
  
  public void a(long paramLong, int paramInt1, int paramInt2, int paramInt3, String arg6, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatHistoryImageView", 2, "[onImageDownload] id=" + paramLong + ",subId=" + paramInt1);
    }
    AIOImageListModel localAIOImageListModel = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel;
    if (paramInt3 == 1)
    {
      paramInt1 = localAIOImageListModel.a(paramLong, paramInt1, paramInt2, ???, true);
      if (paramInt2 != 2) {
        break label230;
      }
      if (paramInt1 >= 0)
      {
        ??? = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a(paramInt1);
        if (AIORichMediaInfo.class.isInstance(???)) {
          break label106;
        }
      }
    }
    label106:
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            ??? = "I:E";
            break;
            ??? = (AIORichMediaInfo)???;
            ???.jdField_a_of_type_Int = 0;
            ???.jdField_a_of_type_Boolean = false;
            paramInt2 = this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getFirstVisiblePosition();
            paramInt3 = this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getChildCount();
            if ((paramInt1 >= paramInt2) && (paramInt1 <= paramInt3 + paramInt2 - 1)) {
              this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOPhotoListAdapter.a(paramInt1, this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getChildAt(paramInt1 - paramInt2));
            }
          } while ((this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView$DownloadAndSaveTask == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView$DownloadAndSaveTask.a == null));
          synchronized (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView$DownloadAndSaveTask.a)
          {
            this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView$DownloadAndSaveTask.a.notifyAll();
            return;
          }
          if (paramInt2 != 1) {
            break label295;
          }
          paramInt2 = this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getFirstVisiblePosition();
          paramInt3 = this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getChildCount();
        } while ((paramInt1 < paramInt2) || (paramInt1 > paramInt3 + paramInt2 - 1));
        ??? = this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getChildAt(paramInt1 - paramInt2);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOPhotoListAdapter.a(paramInt1, ???);
        return;
      } while (paramInt2 != 16);
      paramInt2 = this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getFirstVisiblePosition();
      paramInt3 = this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getChildCount();
    } while ((paramInt1 < paramInt2) || (paramInt1 > paramInt3 + paramInt2 - 1));
    label230:
    ??? = this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getChildAt(paramInt1 - paramInt2);
    label295:
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOPhotoListAdapter.a(paramInt1, ???);
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
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(paramContext).inflate(2131560939, null);
    this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView = ((GestureSelectGridView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368061));
    this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setSelectMode(false);
    int i = this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131297499);
    int j = this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131297500);
    int k = this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131297501);
    this.jdField_a_of_type_Int = ((ViewUtils.a() - i * 2 - j * 3) / 4);
    this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setGravity(3);
    this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setScrollBarStyle(0);
    this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setNumColumns(4);
    this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setColumnWidth(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setHorizontalSpacing(j);
    this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setVerticalSpacing(k);
    this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setPadding(i, this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getPaddingTop(), i, this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getPaddingBottom());
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131366349);
    if (AppSetting.jdField_d_of_type_Boolean) {
      this.jdField_b_of_type_AndroidViewView.setContentDescription(this.jdField_a_of_type_AndroidAppActivity.getString(2131692473));
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
    int k = 0;
    int i = 0;
    if (i < this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.g())
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a(i);
      if (!AIORichMediaInfo.class.isInstance(localObject)) {}
      do
      {
        i += 1;
        break;
        localObject = (AIORichMediaInfo)localObject;
      } while ((((AIORichMediaInfo)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Long != paramAIORichMediaData.jdField_f_of_type_Long) || (((AIORichMediaInfo)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Int != paramAIORichMediaData.jdField_f_of_type_Int));
    }
    for (int j = 1;; j = 0)
    {
      if (j != 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ChatHistoryImageView", 2, "[setSelectionTo] index=" + i + ", fist=" + this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getFirstVisiblePosition() + ", last=" + this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getLastVisiblePosition());
        }
        if ((i < this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getFirstVisiblePosition()) || (i > this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getLastVisiblePosition())) {}
      }
      else
      {
        return;
      }
      if (paramBoolean)
      {
        this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setSelection(i);
        return;
      }
      i -= 12;
      if (i < 0) {
        i = k;
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setSelection(i);
        return;
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOPhotoListAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOPhotoListAdapter.a(paramBoolean);
    }
  }
  
  public void a(AIORichMediaData[] paramArrayOfAIORichMediaData, int paramInt)
  {
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.post(new ChatHistoryImageView.2(this, paramArrayOfAIORichMediaData, paramInt));
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOPhotoListAdapter != null) {
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOPhotoListAdapter.a();
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
      switch (paramGalleryImage.getSelected())
      {
      default: 
        paramView.setVisibility(4);
        ((ImageView)localObject).setVisibility(4);
      }
      for (;;)
      {
        return true;
        paramView.setVisibility(0);
        ((ImageView)localObject).setImageResource(2130845991);
        ((ImageView)localObject).setVisibility(0);
        continue;
        paramView.setVisibility(4);
        ((ImageView)localObject).setImageResource(2130845988);
        ((ImageView)localObject).setVisibility(0);
      }
    }
    return false;
  }
  
  boolean a(AIORichMediaInfo paramAIORichMediaInfo, boolean paramBoolean)
  {
    int i = paramAIORichMediaInfo.getSelected();
    if (((i == 1) && (paramBoolean)) || ((i == 2) && (!paramBoolean))) {}
    ChatMessage localChatMessage;
    do
    {
      return false;
      localChatMessage = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.a(paramAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Long);
      if (!paramBoolean) {
        break;
      }
    } while (((this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity.a())) || ((this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView$OperCallBack != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView$OperCallBack.a())) || ((this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView$OperCallBack != null) && (!this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView$OperCallBack.a(paramAIORichMediaInfo))));
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView$OperCallBack != null) && (localChatMessage != null)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView$OperCallBack.a(localChatMessage);
    }
    paramAIORichMediaInfo.setSelected(1);
    this.jdField_a_of_type_JavaUtilArrayList.add(paramAIORichMediaInfo);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity.a(paramAIORichMediaInfo);
      if (localChatMessage != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity.a(localChatMessage);
      }
    }
    for (;;)
    {
      return true;
      paramAIORichMediaInfo.setSelected(2);
      this.jdField_a_of_type_JavaUtilArrayList.remove(paramAIORichMediaInfo);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity.b(paramAIORichMediaInfo);
        if (localChatMessage != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity.d(localChatMessage);
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView$OperCallBack != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView$OperCallBack.a(paramAIORichMediaInfo);
        if (localChatMessage != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView$OperCallBack.b(localChatMessage);
        }
      }
    }
  }
  
  public void b()
  {
    this.g = true;
  }
  
  void b(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_AndroidAppDialog == null)
    {
      this.jdField_a_of_type_AndroidAppDialog = new ReportDialog(this.jdField_a_of_type_AndroidAppActivity, 2131755842);
      this.jdField_a_of_type_AndroidAppDialog.setCancelable(true);
      this.jdField_a_of_type_AndroidAppDialog.setContentView(2131559683);
      this.jdField_a_of_type_AndroidAppDialog.setOnCancelListener(this);
    }
    String str = paramInt2 + "%";
    TextView localTextView = (TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131373066);
    switch (paramInt1)
    {
    }
    for (;;)
    {
      localTextView.setText(str);
      if (!this.jdField_a_of_type_AndroidAppDialog.isShowing()) {}
      try
      {
        this.jdField_a_of_type_AndroidAppDialog.show();
        return;
      }
      catch (Exception localException) {}
      str = localTextView.getResources().getText(2131689970) + str;
      continue;
      str = localTextView.getResources().getText(2131689968) + str;
    }
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
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOPhotoListAdapter.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOPhotoListAdapter.notifyDataSetChanged();
      this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setSelectMode(true);
    }
  }
  
  public void f()
  {
    if (this.jdField_c_of_type_Boolean)
    {
      this.jdField_c_of_type_Boolean = false;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext()) {
        ((GalleryImage)localIterator.next()).setSelected(2);
      }
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOPhotoListAdapter.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOPhotoListAdapter.notifyDataSetChanged();
      this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setSelectMode(false);
    }
  }
  
  public void g()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService = AIOImageProviderService.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_Int, null, this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.a(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel = new AIOImageListModel(false);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOPhotoListAdapter = new AIOPhotoListAdapter(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService, this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOPhotoListAdapter.a(this.jdField_b_of_type_Int);
    this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOPhotoListAdapter);
    this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setOnItemClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOPhotoListAdapter.a(true);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOPhotoListAdapter.b(2);
    AIOImageProviderService localAIOImageProviderService = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService;
    if (this.jdField_a_of_type_Boolean) {}
    for (int i = 2;; i = 0)
    {
      localAIOImageProviderService.a(i);
      return;
    }
  }
  
  public void h()
  {
    if (!this.jdField_c_of_type_Boolean) {}
    while (!this.f) {
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
  
  public boolean handleMessage(Message paramMessage)
  {
    boolean bool = true;
    switch (paramMessage.what)
    {
    default: 
      bool = false;
    case 100: 
    case 101: 
      do
      {
        return bool;
        b(paramMessage.arg1, paramMessage.arg2);
        return true;
      } while (this.jdField_a_of_type_AndroidAppDialog == null);
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
      this.jdField_a_of_type_AndroidAppDialog = null;
      return true;
    }
    if ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing())) {
      this.jdField_a_of_type_AndroidAppDialog.cancel();
    }
    QQToast.a(BaseApplication.getContext(), 1, 2131692472, 0).a();
    return true;
  }
  
  public void i()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.isEmpty()) {}
    label254:
    do
    {
      Object localObject1;
      do
      {
        Object localObject2;
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
                  do
                  {
                    do
                    {
                      return;
                      localObject1 = (AIORichMediaInfo)this.jdField_a_of_type_JavaUtilArrayList.get(0);
                      if ((AIOImageData.class.isInstance(((AIORichMediaInfo)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)) || (AIOFilePicData.class.isInstance(((AIORichMediaInfo)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)))
                      {
                        j();
                        return;
                      }
                      if (!AIOShortVideoData.class.isInstance(((AIORichMediaInfo)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)) {
                        break;
                      }
                      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.a(((AIORichMediaInfo)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Long, ((AIORichMediaInfo)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Int, this.jdField_b_of_type_Int);
                    } while (localObject1 == null);
                    ForwardBaseOption.a(this.jdField_a_of_type_AndroidAppActivity, (Intent)localObject1);
                  } while (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity == null);
                  this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity.a();
                  return;
                } while (!AIOFileVideoData.class.isInstance(((AIORichMediaInfo)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData));
                localObject2 = (AIOFileVideoData)((AIORichMediaInfo)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
                localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.a(((AIOFileVideoData)localObject2).jdField_f_of_type_Long);
                if (!(localObject2 instanceof MessageForFile)) {
                  break label254;
                }
                if (!FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForFile)localObject2).sendCloudUnsuccessful()) {
                  break;
                }
                FMToastUtil.a(HardCodeUtil.a(2131701697));
              } while (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity == null);
              this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity.a();
              return;
              localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.a(((AIORichMediaInfo)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Long, ((AIORichMediaInfo)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Int, this.jdField_b_of_type_Int);
            } while (localObject1 == null);
            ForwardBaseOption.a(this.jdField_a_of_type_AndroidAppActivity, (Intent)localObject1);
          } while (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity == null);
          this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity.a();
          return;
        } while (!(localObject2 instanceof MessageForTroopFile));
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.a(((AIORichMediaInfo)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Long, ((AIORichMediaInfo)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Int, this.jdField_b_of_type_Int);
      } while (localObject1 == null);
      ForwardBaseOption.a(this.jdField_a_of_type_AndroidAppActivity, (Intent)localObject1);
    } while (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity == null);
    this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity.a();
  }
  
  public void j()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatHistoryImageView", 2, "[forward]");
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    int i = 0;
    AIORichMediaInfo localAIORichMediaInfo;
    if (localIterator.hasNext())
    {
      localAIORichMediaInfo = (AIORichMediaInfo)localIterator.next();
      if (AIOImageData.class.isInstance(localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)) {
        if (localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.g == 1)
        {
          if ((localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.a(4) != null) || (localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.a(2) != null) || (localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.a(1) != null)) {
            break label239;
          }
          i += 1;
        }
      }
    }
    label239:
    for (;;)
    {
      break;
      if (localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.a(2) == null)
      {
        i += 1;
        continue;
        if ((AIOFilePicData.class.isInstance(localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)) && (localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.a(20) == null) && (localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.a(18) == null) && (localAIORichMediaInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.a(16) == null))
        {
          i += 1;
          continue;
          if (i == 0)
          {
            k();
            return;
          }
          if (i != this.jdField_a_of_type_JavaUtilArrayList.size())
          {
            if (QLog.isColorLevel()) {
              QLog.d("ChatHistoryImageView", 2, "[forwardAllImage] hasForwardImg = false");
            }
            a(3, HardCodeUtil.a(2131701663));
            return;
          }
          FMToastUtil.a(HardCodeUtil.a(2131701693));
          return;
        }
      }
    }
  }
  
  void k()
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.get(0) != null))
    {
      localObject1 = (AIORichMediaInfo)this.jdField_a_of_type_JavaUtilArrayList.get(0);
      if (AIOImageData.class.isInstance(((AIORichMediaInfo)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))
      {
        localObject2 = (AIOImageData)((AIORichMediaInfo)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
        localObject1 = new Bundle();
        ((Bundle)localObject1).putInt("forward_type", 12);
        localObject3 = ((AIOImageData)localObject2).a(2);
        ((Bundle)localObject1).putString("forward_urldrawable_thumb_url", ((AIOImageData)localObject2).a(1));
        ((Bundle)localObject1).putString("forward_urldrawable_big_url", (String)localObject3);
        ((Bundle)localObject1).putBoolean("forward_urldrawable", true);
        if (this.jdField_a_of_type_JavaUtilArrayList.size() > 1) {
          ((Bundle)localObject1).putString("forward_text", this.jdField_a_of_type_JavaUtilArrayList.size() + HardCodeUtil.a(2131701728));
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
      }
    }
    while (!QLog.isColorLevel())
    {
      AIORichMediaInfo localAIORichMediaInfo;
      do
      {
        return;
      } while (!AIOFilePicData.class.isInstance(((AIORichMediaInfo)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData));
      Object localObject2 = (AIOFilePicData)((AIORichMediaInfo)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
      Object localObject1 = new Bundle();
      ((Bundle)localObject1).putInt("forward_type", 12);
      Object localObject3 = ((AIOFilePicData)localObject2).a(18);
      ((Bundle)localObject1).putString("forward_urldrawable_thumb_url", ((AIOFilePicData)localObject2).a(16));
      ((Bundle)localObject1).putString("forward_urldrawable_big_url", (String)localObject3);
      ((Bundle)localObject1).putBoolean("forward_urldrawable", true);
      if (this.jdField_a_of_type_JavaUtilArrayList.size() > 1) {
        ((Bundle)localObject1).putString("forward_text", this.jdField_a_of_type_JavaUtilArrayList.size() + HardCodeUtil.a(2131701712));
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
      return;
    }
    QLog.d("ChatHistoryImageView", 2, "callForwardRecentActivity error! mSelectedPhotoList ==null || mSelectedPhotoList.get(0) == null || !mSelectedPhotoList.get(0) instanceof AIOImageInfo");
  }
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(102);
    this.jdField_a_of_type_AndroidAppDialog = null;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView$DownloadAndSaveTask != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView$DownloadAndSaveTask.jdField_c_of_type_Boolean = false;
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a(paramInt);
    if (!AIORichMediaInfo.class.isInstance(paramAdapterView)) {}
    label80:
    label84:
    do
    {
      for (;;)
      {
        return;
        paramAdapterView = (AIORichMediaInfo)paramAdapterView;
        if (!this.jdField_c_of_type_Boolean) {
          break;
        }
        if (paramAdapterView.getSelected() == 1)
        {
          paramInt = 1;
          if (paramInt != 0) {
            break label80;
          }
        }
        for (boolean bool = true;; bool = false)
        {
          if ((!a(paramAdapterView, bool)) || (a(paramView, paramAdapterView))) {
            break label84;
          }
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOPhotoListAdapter.notifyDataSetChanged();
          return;
          paramInt = 0;
          break;
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.e(paramInt);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.b(this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getFirstVisiblePosition());
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.c(this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getLastVisiblePosition());
      if (AIOShortVideoData.class.isInstance(paramAdapterView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))
      {
        paramView = (AIOShortVideoData)paramAdapterView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
        if ((paramView.jdField_b_of_type_Int != 0) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.a(paramView.jdField_f_of_type_Long) == null) || (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isVideoChatting())) {
          break;
        }
        QQToast.a(BaseApplication.getContext(), 0, 2131719379, 0).b(this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131299166));
        return;
      }
      if (!AIOFileVideoData.class.isInstance(paramAdapterView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)) {
        break label611;
      }
      paramView = (AIOFileVideoData)paramAdapterView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.a(paramView.jdField_f_of_type_Long);
      if (!(paramView instanceof MessageForFile)) {
        break;
      }
      paramView = FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForFile)paramView);
    } while (paramView == null);
    label329:
    label357:
    Object localObject;
    if (FileUtil.b(paramView.getFilePath()))
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("PauseDebug", 1, "file existed! isLocalFile:" + paramView.nSessionId);
      }
      if ((paramAdapterView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData instanceof AIOFileVideoData)) {
        ((AIOFileVideoData)paramAdapterView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).c = paramView.getFilePath();
      }
      ShortVideoUtils.reportVideoPlay(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_JavaLangString, String.valueOf(0), this.jdField_b_of_type_Int, "3", "3");
      paramView = new Bundle();
      localObject = a();
      if (localObject != null) {
        paramView.putParcelable("KEY_THUMBNAL_BOUND", (Parcelable)localObject);
      }
      if (this.jdField_b_of_type_Int != 3000) {
        break label657;
      }
      paramView.putInt("extra.EXTRA_FORWARD_TO_QZONE_SRC", 2);
    }
    for (;;)
    {
      paramView.putInt("extra.MOBILE_QQ_PROCESS_ID", Process.myPid());
      paramView.putBoolean("extra.IS_FROM_CHAT_FILE_HISTORY", true);
      paramView.putString("uin", this.jdField_a_of_type_JavaLangString);
      paramView.putInt("forward_source_uin_type", this.jdField_b_of_type_Int);
      paramView.putBoolean("extra.OCR", OCRManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 7));
      if (this.jdField_b_of_type_Int == 1)
      {
        localObject = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).c(this.jdField_a_of_type_JavaLangString);
        if (localObject != null) {
          paramView.putString("extra.GROUP_UIN", ((TroopInfo)localObject).troopuin);
        }
      }
      paramView.putBoolean("extra.ENTER_NEW_GALLERY", true);
      PeakUtils.a(this.jdField_a_of_type_AndroidAppActivity, paramView, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService, paramAdapterView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData, 2, 3);
      if ((paramAdapterView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData == null) || (!(paramAdapterView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData instanceof AIOShortVideoData))) {
        break;
      }
      ShortVideoUtils.reportVideoPlay(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_JavaLangString, String.valueOf(((AIOShortVideoData)paramAdapterView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).jdField_a_of_type_Int * 1000), this.jdField_b_of_type_Int, "2", "3");
      return;
      if (!paramView.sendCloudUnsuccessful()) {
        break label329;
      }
      FMToastUtil.a(HardCodeUtil.a(2131701695));
      return;
      label611:
      if (!AIOLightVideoData.class.isInstance(paramAdapterView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)) {
        break label357;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ChatHistoryImageView", 2, "lightvideo could not be opened in chathistory");
      }
      QQToast.a(BaseApplication.getContext(), HardCodeUtil.a(2131701735), 0).a();
      return;
      label657:
      paramView.putInt("extra.EXTRA_FORWARD_TO_QZONE_SRC", 1);
    }
  }
  
  public void onNetChangeEvent(boolean paramBoolean)
  {
    if ((AppNetConnInfo.isMobileConn()) && (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView$DownloadAndSaveTask != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView$DownloadAndSaveTask.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView$DownloadAndSaveTask.jdField_d_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView$DownloadAndSaveTask.jdField_b_of_type_Boolean))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatHistoryImageView", 2, "[onNetChangeEvent] show dialog");
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView$DownloadAndSaveTask.a(true);
      a(4, this.jdField_a_of_type_AndroidAppActivity.getString(2131692471));
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
        if (QLog.isColorLevel()) {
          QLog.d("ChatHistoryImageView", 2, "[onScroll] loadMedias: mLastLoadingCount=" + this.jdField_e_of_type_Int);
        }
        this.jdField_e_of_type_Int = j;
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOPhotoListAdapter.a(true);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.a(0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatHistoryImageView
 * JD-Core Version:    0.7.0.1
 */