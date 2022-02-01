package com.tencent.mobileqq.activity;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.photo.AIOFilePicData;
import com.tencent.mobileqq.activity.aio.photo.AIOFileVideoData;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryMsgRevokeMgr;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryMsgRevokeMgr.MsgRevokeListener;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryUtils;
import com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService;
import com.tencent.mobileqq.activity.aio.photo.AIORichMediaData;
import com.tencent.mobileqq.activity.aio.photo.AIORichMediaInfo;
import com.tencent.mobileqq.activity.chathistory.SeparateForward;
import com.tencent.mobileqq.activity.photo.SendPhotoActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.TencentDocData;
import com.tencent.mobileqq.emotionintegrate.EmotionPreviewData;
import com.tencent.mobileqq.filemanager.api.IFMConfig;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.recreate.FileModel;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.multimsg.save.FileSaveDialog;
import com.tencent.mobileqq.multimsg.save.FileSaveReq;
import com.tencent.mobileqq.multimsg.save.MultiRichMediaSaveManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.startup.step.CheckPermission;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.teamwork.TeamWorkUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.TabBarView;
import com.tencent.mobileqq.wifi.FreeWifiHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.util.MqqWeakReferenceHandler;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import cooperation.weiyun.ResponseHandler;
import cooperation.weiyun.WeiyunAIOUtils;
import cooperation.weiyun.WeiyunSaveTipsFactory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class ChatHistoryFileActivity
  extends IphoneTitleBarActivity
  implements Handler.Callback, View.OnClickListener, AIOGalleryMsgRevokeMgr.MsgRevokeListener
{
  int jdField_a_of_type_Int;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  ChatHistoryEmotionView jdField_a_of_type_ComTencentMobileqqActivityChatHistoryEmotionView;
  ChatHistoryFileView jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileView;
  ChatHistoryImageView jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView;
  ChatHistoryStructMsgView jdField_a_of_type_ComTencentMobileqqActivityChatHistoryStructMsgView;
  ChatHistoryViewBase jdField_a_of_type_ComTencentMobileqqActivityChatHistoryViewBase = null;
  private SeparateForward jdField_a_of_type_ComTencentMobileqqActivityChathistorySeparateForward;
  private FMObserver jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver = null;
  QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  String jdField_a_of_type_JavaLangString;
  List<ChatMessage> jdField_a_of_type_JavaUtilList;
  protected final MqqHandler a;
  boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  private QQCustomDialog jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  String jdField_b_of_type_JavaLangString;
  List<FileManagerEntity> jdField_b_of_type_JavaUtilList;
  private boolean jdField_b_of_type_Boolean = false;
  ImageView jdField_c_of_type_AndroidWidgetImageView;
  List<AIORichMediaInfo> jdField_c_of_type_JavaUtilList;
  ImageView jdField_d_of_type_AndroidWidgetImageView;
  List<TencentDocData> jdField_d_of_type_JavaUtilList;
  List<EmotionPreviewData> e;
  List<ChatMessage> f;
  
  public ChatHistoryFileActivity()
  {
    this.jdField_a_of_type_MqqOsMqqHandler = new MqqWeakReferenceHandler(Looper.getMainLooper(), this, true);
  }
  
  private ChatHistoryViewBase a(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
    case 3: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileView == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileView = new ChatHistoryFileView();
        this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileView.a(getIntent(), this.app, this);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileView.j_(paramInt);
      return this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileView;
    case 0: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView = new ChatHistoryImageView();
        this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView.a(getIntent(), this.app, this);
      }
      return this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView;
    case 2: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryStructMsgView == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryStructMsgView = new ChatHistoryStructMsgView();
        this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryStructMsgView.a(getIntent(), this.app, this);
      }
      return this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryStructMsgView;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryEmotionView == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryEmotionView = new ChatHistoryEmotionView();
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryEmotionView.a(getIntent(), this.app, this);
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryEmotionView;
  }
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4, ChatHistoryFileActivity.OnWyDialogClick paramOnWyDialogClick)
  {
    if ((this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing())) {
      this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
    }
    QQCustomDialog localQQCustomDialog = new QQCustomDialog(this, 2131755842);
    localQQCustomDialog.setContentView(2131559084);
    this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog = localQQCustomDialog;
    this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.setTitle(paramString1);
    this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessage(paramString2);
    paramString1 = paramString4;
    if (TextUtils.isEmpty(paramString4)) {
      paramString1 = getString(2131690800);
    }
    paramString2 = paramString3;
    if (TextUtils.isEmpty(paramString3)) {
      paramString2 = getString(2131691144);
    }
    this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.setNegativeButton(paramString1, new ChatHistoryFileActivity.8(this, paramOnWyDialogClick));
    this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPositiveButton(paramString2, new ChatHistoryFileActivity.9(this, paramOnWyDialogClick));
    this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.setCancelable(true);
    this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.setCanceledOnTouchOutside(false);
    this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
  }
  
  private void a(List<ChatMessage> paramList)
  {
    if (paramList.size() == 1) {
      WeiyunAIOUtils.b(this.app, this, getTitleBarHeight(), paramList, this.jdField_a_of_type_MqqOsMqqHandler);
    }
    for (;;)
    {
      ReportController.b(this.app, "dc00898", "", "", "0X8009DB9", "0X8009DB9", 0, 0, "", "", "", "");
      return;
      WeiyunAIOUtils.a(this.app, this, getTitleBarHeight(), paramList, this.jdField_a_of_type_MqqOsMqqHandler);
    }
  }
  
  private void a(List<AIORichMediaInfo> paramList, List<EmotionPreviewData> paramList1)
  {
    ArrayList localArrayList;
    Iterator localIterator;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView.a != null))
    {
      localArrayList = new ArrayList();
      if ((paramList != null) && (paramList.size() > 0)) {
        localIterator = paramList.iterator();
      }
    }
    label429:
    for (;;)
    {
      ChatMessage localChatMessage;
      if (localIterator.hasNext())
      {
        paramList = (AIORichMediaInfo)localIterator.next();
        localChatMessage = this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView.a.a(paramList.a.f);
        if ((localChatMessage instanceof MessageForPic)) {
          paramList = FileSaveReq.a((MessageForPic)localChatMessage);
        }
      }
      for (;;)
      {
        if (paramList == null) {
          break label429;
        }
        localArrayList.add(paramList);
        break;
        if ((localChatMessage instanceof MessageForShortVideo))
        {
          paramList = (MessageForShortVideo)localChatMessage;
          if (paramList.busiType == 0) {
            paramList = FileSaveReq.b(this.app, paramList);
          } else {
            paramList = FileSaveReq.a(this.app, paramList);
          }
        }
        else
        {
          if ((localChatMessage instanceof MessageForFile))
          {
            if (AIOFilePicData.class.isInstance(paramList.a))
            {
              paramList = FileSaveReq.a(this.app, localChatMessage);
              paramList.jdField_a_of_type_Int = 4;
              continue;
            }
            if (AIOFileVideoData.class.isInstance(paramList.a))
            {
              paramList = FileSaveReq.a(this.app, localChatMessage);
              paramList.jdField_a_of_type_Int = 5;
            }
          }
          else if ((localChatMessage instanceof MessageForTroopFile))
          {
            if (AIOFilePicData.class.isInstance(paramList.a))
            {
              paramList = FileSaveReq.a(this.app, localChatMessage);
              paramList.jdField_a_of_type_Int = 6;
              continue;
            }
            if (AIOFileVideoData.class.isInstance(paramList.a))
            {
              paramList = FileSaveReq.a(this.app, localChatMessage);
              paramList.jdField_a_of_type_Int = 7;
              continue;
              if ((paramList1 != null) && (!paramList1.isEmpty()))
              {
                paramList = paramList1.iterator();
                while (paramList.hasNext())
                {
                  paramList1 = (EmotionPreviewData)paramList.next();
                  if ((paramList1.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForPic)) {
                    localArrayList.add(FileSaveReq.a((MessageForPic)paramList1.jdField_a_of_type_ComTencentMobileqqDataMessageRecord));
                  }
                }
              }
              paramList = new FileSaveDialog(this);
              paramList1 = (MultiRichMediaSaveManager)this.app.getManager(QQManagerFactory.MULTI_CHOOSE_SAVE_MANAGER);
              paramList1.a(new ChatHistoryFileActivity.10(this, paramList, paramList1, localArrayList));
              paramList1.a(localArrayList, true);
              paramList1.a(localArrayList, 1, 5);
              return;
            }
          }
          paramList = null;
        }
      }
    }
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131367398));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131365992));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131377449));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131365621));
    StateListDrawable localStateListDrawable = new StateListDrawable();
    Drawable localDrawable = getResources().getDrawable(2130839621);
    localStateListDrawable.addState(new int[] { 16842919 }, localDrawable);
    localDrawable = getResources().getDrawable(2130839622);
    localStateListDrawable.addState(new int[] { 16842910 }, localDrawable);
    localDrawable = getResources().getDrawable(2130839621);
    localStateListDrawable.addState(new int[0], localDrawable);
    this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(localStateListDrawable);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setEnabled(true);
    this.jdField_b_of_type_AndroidWidgetImageView.setEnabled(true);
    this.jdField_c_of_type_AndroidWidgetImageView.setEnabled(true);
    this.jdField_d_of_type_AndroidWidgetImageView.setEnabled(true);
  }
  
  public void a()
  {
    boolean bool;
    if (!this.jdField_a_of_type_Boolean)
    {
      bool = true;
      this.jdField_a_of_type_Boolean = bool;
      if (!this.jdField_a_of_type_Boolean) {
        break label57;
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryViewBase.e();
      setRightButton(2131690800, this);
    }
    label57:
    do
    {
      return;
      bool = false;
      break;
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryViewBase.f();
      setRightButton(2131690022, this);
      this.jdField_d_of_type_JavaUtilList = null;
      this.jdField_c_of_type_JavaUtilList = null;
      this.jdField_a_of_type_JavaUtilList = null;
      this.jdField_b_of_type_JavaUtilList = null;
      this.f = null;
    } while ((this.e == null) || (this.e.isEmpty()));
    Iterator localIterator = this.e.iterator();
    while (localIterator.hasNext()) {
      ((EmotionPreviewData)localIterator.next()).jdField_a_of_type_Boolean = false;
    }
    this.e.clear();
  }
  
  public void a(long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryViewBase != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryViewBase.a(paramLong);
    }
  }
  
  public void a(AIORichMediaInfo paramAIORichMediaInfo)
  {
    if (this.jdField_c_of_type_JavaUtilList == null) {
      this.jdField_c_of_type_JavaUtilList = new ArrayList();
    }
    this.jdField_c_of_type_JavaUtilList.add(paramAIORichMediaInfo);
  }
  
  public void a(ChatMessage paramChatMessage)
  {
    if (this.f == null) {
      this.f = new ArrayList();
    }
    this.f.add(paramChatMessage);
    if (QLog.isColorLevel()) {
      QLog.d("ChatHistoryStruct", 2, "addweiyunselected, size: " + this.f.size());
    }
  }
  
  public void a(TencentDocData paramTencentDocData)
  {
    if (this.jdField_d_of_type_JavaUtilList == null) {
      this.jdField_d_of_type_JavaUtilList = new ArrayList();
    }
    this.jdField_d_of_type_JavaUtilList.add(paramTencentDocData);
  }
  
  public void a(EmotionPreviewData paramEmotionPreviewData)
  {
    if (this.e == null) {
      this.e = new ArrayList();
    }
    this.e.add(paramEmotionPreviewData);
  }
  
  public void a(FileManagerEntity paramFileManagerEntity)
  {
    if (this.jdField_b_of_type_JavaUtilList == null) {
      this.jdField_b_of_type_JavaUtilList = new ArrayList();
    }
    this.jdField_b_of_type_JavaUtilList.add(paramFileManagerEntity);
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this, 230);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setNegativeButton(2131719347, new ChatHistoryFileActivity.12(this));
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing()) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessage(paramString);
    }
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
        return;
      }
      catch (Throwable paramString) {}
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
    }
  }
  
  public boolean a()
  {
    boolean bool = false;
    if (this.jdField_a_of_type_JavaUtilList != null) {}
    for (int j = this.jdField_a_of_type_JavaUtilList.size() + 0;; j = 0)
    {
      int i = j;
      if (this.jdField_b_of_type_JavaUtilList != null) {
        i = j + this.jdField_b_of_type_JavaUtilList.size();
      }
      j = i;
      if (this.jdField_c_of_type_JavaUtilList != null) {
        j = i + this.jdField_c_of_type_JavaUtilList.size();
      }
      i = j;
      if (this.jdField_d_of_type_JavaUtilList != null) {
        i = j + this.jdField_d_of_type_JavaUtilList.size();
      }
      j = i;
      if (this.e != null) {
        j = i + this.e.size();
      }
      if (j >= 20) {
        bool = true;
      }
      if (bool)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ChatHistoryFIleActivity", 2, "isOverLimit");
        }
        FMToastUtil.a(2131692502);
      }
      return bool;
    }
  }
  
  boolean a(int paramInt, List<ChatMessage> paramList, List<FileManagerEntity> paramList1, List<AIORichMediaInfo> paramList2, List<TencentDocData> paramList3)
  {
    int n = 0;
    int i1 = 0;
    boolean bool2;
    int k;
    int m;
    if (TeamWorkUtils.a(paramList3))
    {
      bool2 = true;
      k = 0;
      m = 0;
      if ((paramList1 == null) || (paramList1.size() <= 0)) {
        break label2169;
      }
      m = 1;
      k = 0 + paramList1.size();
    }
    label187:
    label234:
    label2169:
    for (int i3 = 1;; i3 = 0)
    {
      int i = m;
      int j = k;
      if (bool2)
      {
        i = m + 1;
        j = k + paramList3.size();
      }
      int i4;
      if ((paramList != null) && (paramList.size() > 0))
      {
        k = paramList.size();
        i4 = 1;
        j += k;
        i += 1;
      }
      for (;;)
      {
        Object localObject1;
        boolean bool1;
        if ((this.e != null) && (!this.e.isEmpty())) {
          if (paramInt == 1)
          {
            localObject1 = this.e.iterator();
            while (((Iterator)localObject1).hasNext()) {
              if ((((EmotionPreviewData)((Iterator)localObject1).next()).jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForMarketFace))
              {
                bool1 = true;
                k = j + this.e.size();
                i += 1;
              }
            }
          }
        }
        for (;;)
        {
          int i2;
          if (paramList2 != null)
          {
            localObject1 = paramList2.iterator();
            j = i;
            i = 0;
            m = 0;
            n = 0;
            if (((Iterator)localObject1).hasNext())
            {
              int i5 = AIOGalleryUtils.a(((AIORichMediaInfo)((Iterator)localObject1).next()).a);
              if ((n == 0) && (i5 == 1))
              {
                n = 1;
                j += 1;
                i2 = j;
                i1 = m;
                if (m == 0)
                {
                  i2 = j;
                  i1 = m;
                  if (i5 == 2)
                  {
                    i1 = 1;
                    i2 = j + 1;
                  }
                }
                if ((i == 0) && (i5 == 3))
                {
                  i = i2 + 1;
                  j = 1;
                  if ((paramInt != 1) && (i >= 2))
                  {
                    m = i1;
                    i1 = paramList2.size();
                    i1 += k;
                    k = j;
                    j = i1;
                  }
                }
              }
            }
          }
          for (;;)
          {
            if (j == 0)
            {
              FMToastUtil.c(2131692499);
              return false;
              bool2 = false;
              break;
              bool1 = true;
              break label187;
              m = j;
              j = i;
              i = m;
              m = i1;
              break label234;
            }
            switch (paramInt)
            {
            default: 
              return true;
            case 0: 
              if (!NetworkUtil.d(BaseApplication.getContext()))
              {
                QQToast.a(this, 2131694510, 1).b(getResources().getDimensionPixelSize(2131299166));
                return false;
              }
              if (i > 1)
              {
                a(getString(2131692493));
                return false;
              }
              if (k != 0)
              {
                a(getString(2131692474));
                return false;
              }
              if ((m != 0) && (paramList2.size() > 1))
              {
                a(getString(2131692495));
                return false;
              }
              if (paramList1 != null)
              {
                if ((paramList1.size() == 1) && (((FileManagerEntity)paramList1.get(0)).sendCloudUnsuccessful()))
                {
                  FMToastUtil.a(2131692512);
                  return false;
                }
                localObject1 = paramList1.iterator();
                do
                {
                  if (!((Iterator)localObject1).hasNext()) {
                    break;
                  }
                } while (!FileModel.a((FileManagerEntity)((Iterator)localObject1).next()).a(false));
              }
              break;
            }
            for (paramInt = 1;; paramInt = 0)
            {
              if (paramInt != 0) {
                FMDialogUtil.a(this, 2131692609, 2131692614, new ChatHistoryFileActivity.3(this, paramList1));
              }
              while ((paramList2 != null) && (paramList2.size() > 0) && (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView != null))
              {
                this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView.i();
                return false;
                FileManagerUtil.a(paramList1, this);
              }
              paramList1 = new ArrayList();
              if (paramList != null) {
                paramList1.addAll(paramList);
              }
              if (bool2)
              {
                paramList1.addAll(TeamWorkUtils.a(paramList3, this.jdField_a_of_type_JavaLangString, null));
                FileManagerReporter.a("0X8009AA1");
              }
              if ((paramList1 != null) && (paramList1.size() == 1))
              {
                paramList2 = (MessageForStructing)paramList1.get(0);
                if (paramList2.structingMsg != null)
                {
                  paramList = new Bundle();
                  if ((paramList2.structingMsg.source_puin != null) && (!"".equals(paramList2.structingMsg.source_puin))) {
                    paramList.putString("source_puin", paramList2.structingMsg.source_puin);
                  }
                  paramList.putInt("forward_type", -3);
                  paramList2.structingMsg.mCommentText = null;
                  paramList.putInt("structmsg_service_id", paramList2.structingMsg.mMsgServiceID);
                  paramList.putByteArray("stuctmsg_bytes", paramList2.structingMsg.getBytes());
                  paramList.putLong("structmsg_uniseq", paramList2.uniseq);
                  paramList.putInt("accostType", paramList2.structingMsg.sourceAccoutType);
                  paramList.putBoolean("forwardDirect", true);
                  paramList2 = new Intent();
                  paramList2.putExtras(paramList);
                  paramList2.putExtra("forwardDirect", true);
                  ForwardBaseOption.a(this, paramList2, 3);
                }
              }
              if (((paramList1 == null) || (paramList1.size() <= 1)) && (!bool1)) {
                break;
              }
              paramList = new ArrayList();
              if (paramList1 != null) {
                paramList.addAll(paramList1);
              }
              if (bool1)
              {
                paramList1 = this.e.iterator();
                while (paramList1.hasNext()) {
                  paramList.add((ChatMessage)((EmotionPreviewData)paramList1.next()).jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
                }
              }
              this.jdField_b_of_type_Boolean = bool1;
              this.jdField_a_of_type_ComTencentMobileqqActivityChathistorySeparateForward.a(paramList);
              break;
              if (((n != 0) || (m != 0)) && (i3 != 0))
              {
                a(getString(2131692491));
                return false;
              }
              if ((i4 != 0) || (bool2) || (bool1))
              {
                a(getString(2131692492));
                return false;
              }
              if (!CheckPermission.isHasStoragePermission(this))
              {
                CheckPermission.requestStorePermission(this, null);
                return false;
              }
              long l;
              if (paramList1 != null)
              {
                l = 0L;
                if ((paramList1.size() == 1) && (((FileManagerEntity)paramList1.get(0)).sendCloudUnsuccessful()))
                {
                  FMToastUtil.a(2131692511);
                  return false;
                }
                paramList = paramList1.iterator();
                if (paramList.hasNext())
                {
                  paramList3 = (FileManagerEntity)paramList.next();
                  if (!FileModel.a(paramList3).a(true)) {
                    break label2096;
                  }
                  l = paramList3.fileSize + l;
                }
              }
              for (;;)
              {
                break label1164;
                paramList = this.app.getFileManagerEngine();
                if ((FileManagerUtil.a()) && (l > ((IFMConfig)QRoute.api(IFMConfig.class)).getFlowDialogSize())) {
                  FileManagerUtil.a(false, this, new ChatHistoryFileActivity.4(this, paramList1, paramList));
                }
                while (((paramList2 != null) && (paramList2.size() > 0)) || ((!bool1) && (this.e != null) && (!this.e.isEmpty())))
                {
                  a(paramList2, this.e);
                  return false;
                  paramList1 = paramList1.iterator();
                  while (paramList1.hasNext())
                  {
                    paramList3 = (FileManagerEntity)paramList1.next();
                    if (!paramList3.sendCloudUnsuccessful()) {
                      paramList.c(paramList3);
                    }
                  }
                }
                if (((paramList2 != null) && (this.f != null)) || ((paramList != null) && (paramList.size() > 0)) || ((paramList1 != null) && (paramList1.size() > 0))) {
                  b();
                }
                if ((paramList2 != null) && (this.f != null)) {
                  a(this.f);
                }
                if (paramList != null)
                {
                  a(paramList);
                  break;
                }
                if ((paramList1 == null) || (paramList1.size() <= 0)) {
                  break;
                }
                paramList = (FileManagerEntity)paramList1.get(0);
                paramList = this.app.getFileManagerEngine();
                if ((paramList1.size() == 1) && (((FileManagerEntity)paramList1.get(0)).sendCloudUnsuccessful()))
                {
                  FMToastUtil.a(2131692513);
                  return false;
                }
                paramList2 = paramList1.iterator();
                do
                {
                  if (!paramList2.hasNext()) {
                    break;
                  }
                } while (!FileModel.a((FileManagerEntity)paramList2.next()).a(false));
                for (paramInt = 1;; paramInt = 0)
                {
                  if (paramInt != 0)
                  {
                    if (!FreeWifiHelper.a(this, 5, new ChatHistoryFileActivity.5(this, paramList1, paramList))) {
                      break;
                    }
                    FMDialogUtil.a(this, 2131692609, 2131692612, new ChatHistoryFileActivity.6(this, paramList1, paramList));
                    break;
                  }
                  paramList1 = paramList1.iterator();
                  paramInt = 0;
                  while (paramList1.hasNext())
                  {
                    paramList2 = (FileManagerEntity)paramList1.next();
                    if (!paramList2.sendCloudUnsuccessful()) {
                      if (FileUtils.b(paramList2.getFilePath()))
                      {
                        paramList.a(paramList2.getFilePath(), "", this.app.getCurrentAccountUin(), 0, false);
                        paramInt = 1;
                      }
                      else
                      {
                        paramInt = 1;
                        paramList.a(paramList2, String.valueOf(paramList2.peerUin));
                      }
                    }
                  }
                  if (paramInt != 0)
                  {
                    FMToastUtil.d(getString(2131692733));
                    break;
                  }
                  FMToastUtil.a(2131692513);
                  if (this.jdField_a_of_type_MqqOsMqqHandler == null) {
                    break;
                  }
                  this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(102);
                  break;
                  localObject1 = new ArrayList();
                  Iterator localIterator;
                  Object localObject2;
                  if ((paramList1 != null) && (paramList1.size() > 0))
                  {
                    localIterator = paramList1.iterator();
                    while (localIterator.hasNext())
                    {
                      localObject2 = (FileManagerEntity)localIterator.next();
                      localObject2 = this.app.getMessageFacade().b(((FileManagerEntity)localObject2).peerUin, ((FileManagerEntity)localObject2).peerType, ((FileManagerEntity)localObject2).uniseq);
                      if (localObject2 != null) {
                        ((List)localObject1).add((ChatMessage)localObject2);
                      }
                    }
                  }
                  if ((paramList2 != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView != null))
                  {
                    paramList2 = this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView.a();
                    localIterator = paramList2.iterator();
                    while (localIterator.hasNext())
                    {
                      localObject2 = (ChatMessage)localIterator.next();
                      if (((ChatMessage)localObject2).msgtype == -2005)
                      {
                        localObject2 = this.app.getFileManagerDataCenter().a(((ChatMessage)localObject2).uniseq, ((ChatMessage)localObject2).frienduin, ((ChatMessage)localObject2).istroop);
                        if (localObject2 != null) {
                          this.app.getFileManagerEngine().b(((FileManagerEntity)localObject2).nSessionId);
                        }
                      }
                    }
                    ((List)localObject1).addAll(paramList2);
                  }
                  if ((paramList != null) && (paramList.size() > 0)) {
                    ((List)localObject1).addAll(paramList);
                  }
                  if ((this.e != null) && (!this.e.isEmpty()))
                  {
                    paramList = this.e.iterator();
                    while (paramList.hasNext()) {
                      ((List)localObject1).add((ChatMessage)((EmotionPreviewData)paramList.next()).jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
                    }
                  }
                  if (((((List)localObject1).size() == 0) && (paramList1 == null) && (!bool2)) || ((((List)localObject1).size() <= 0) && (!TeamWorkUtils.a(paramList1)) && (!bool2))) {
                    break;
                  }
                  ThreadManager.post(new ChatHistoryFileActivity.7(this, (List)localObject1, paramList1, bool2, paramList3), 8, null, true);
                  break;
                }
              }
            }
            j = i;
            i = i2;
            break label338;
            break label282;
            i1 = i;
            i = j;
            j = i1;
            break label353;
            j = k;
            m = 0;
            k = i1;
          }
          bool1 = false;
          break label187;
          bool1 = false;
          k = j;
        }
        i4 = 0;
      }
    }
  }
  
  public boolean a(ChatMessage paramChatMessage)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return false;
    }
    return this.jdField_a_of_type_JavaUtilList.contains(paramChatMessage);
  }
  
  public boolean a(TencentDocData paramTencentDocData)
  {
    return (this.jdField_d_of_type_JavaUtilList != null) && (this.jdField_d_of_type_JavaUtilList.contains(paramTencentDocData));
  }
  
  public boolean a(FileManagerEntity paramFileManagerEntity)
  {
    if (this.jdField_b_of_type_JavaUtilList == null) {
      return false;
    }
    return this.jdField_b_of_type_JavaUtilList.contains(paramFileManagerEntity);
  }
  
  void b()
  {
    if (this.jdField_a_of_type_AndroidAppDialog == null)
    {
      this.jdField_a_of_type_AndroidAppDialog = new ReportDialog(getActivity(), 2131755842);
      this.jdField_a_of_type_AndroidAppDialog.setCanceledOnTouchOutside(false);
      this.jdField_a_of_type_AndroidAppDialog.setContentView(2131559683);
    }
    TextView localTextView = (TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131373066);
    localTextView.setText(localTextView.getResources().getString(2131689968));
    if (!this.jdField_a_of_type_AndroidAppDialog.isShowing()) {}
    try
    {
      this.jdField_a_of_type_AndroidAppDialog.show();
      return;
    }
    catch (Exception localException) {}
  }
  
  public void b(AIORichMediaInfo paramAIORichMediaInfo)
  {
    if (this.jdField_c_of_type_JavaUtilList == null) {
      return;
    }
    this.jdField_c_of_type_JavaUtilList.remove(paramAIORichMediaInfo);
  }
  
  public void b(ChatMessage paramChatMessage)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    this.jdField_a_of_type_JavaUtilList.add(paramChatMessage);
    if (QLog.isColorLevel()) {
      QLog.d("ChatHistoryStruct", 2, "addselect, size: " + this.jdField_a_of_type_JavaUtilList.size());
    }
  }
  
  public void b(TencentDocData paramTencentDocData)
  {
    if (this.jdField_d_of_type_JavaUtilList == null) {
      return;
    }
    this.jdField_d_of_type_JavaUtilList.remove(paramTencentDocData);
  }
  
  public void b(EmotionPreviewData paramEmotionPreviewData)
  {
    if (this.e == null) {
      return;
    }
    this.e.remove(paramEmotionPreviewData);
  }
  
  public void b(FileManagerEntity paramFileManagerEntity)
  {
    if (this.jdField_b_of_type_JavaUtilList == null) {
      return;
    }
    this.jdField_b_of_type_JavaUtilList.remove(paramFileManagerEntity);
  }
  
  public void c(ChatMessage paramChatMessage)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {}
    do
    {
      return;
      this.jdField_a_of_type_JavaUtilList.remove(paramChatMessage);
    } while (!QLog.isColorLevel());
    QLog.d("ChatHistoryStruct", 2, "removeselect, size: " + this.jdField_a_of_type_JavaUtilList.size());
  }
  
  public void d(ChatMessage paramChatMessage)
  {
    if (this.f == null) {}
    do
    {
      return;
      this.f.remove(paramChatMessage);
    } while (!QLog.isColorLevel());
    QLog.d("ChatHistoryStruct", 2, "removeweiyunselect, size: " + this.f.size());
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == -1) {
      switch (paramInt1)
      {
      }
    }
    for (;;)
    {
      if (paramInt1 == 1) {
        a();
      }
      return;
      Intent localIntent = new Intent(this, SendPhotoActivity.class);
      paramIntent = new Bundle(paramIntent.getExtras());
      if (QLog.isColorLevel()) {
        QLog.d("forward", 2, "AIOListGallerysence startChatAndSendMsg IS_WAIT_DEST_RESULT=true");
      }
      paramIntent.putBoolean("PhotoConst.HANDLE_DEST_RESULT", true);
      paramIntent.putInt("PhotoConst.SEND_BUSINESS_TYPE", 1031);
      localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", SplashActivity.class.getName());
      localIntent = AIOUtils.a(localIntent, null);
      localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
      paramIntent.putBoolean("PicContants.NEED_COMPRESS", false);
      paramIntent.putBoolean("send_in_background", false);
      localIntent.putExtras(paramIntent);
      startActivity(localIntent);
      continue;
      a();
      continue;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView.a(paramIntent);
        continue;
        if (!this.jdField_b_of_type_Boolean) {
          this.jdField_a_of_type_ComTencentMobileqqActivityChathistorySeparateForward.a(paramIntent);
        }
      }
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    Object localObject = getIntent();
    this.jdField_a_of_type_JavaLangString = ((Intent)localObject).getStringExtra("uin");
    this.jdField_a_of_type_Int = ((Intent)localObject).getIntExtra("uintype", 0);
    this.jdField_b_of_type_JavaLangString = ((Intent)localObject).getStringExtra("uinname");
    setContentView(2131558894);
    setTitle(2131690862);
    if (((Intent)localObject).getStringExtra("leftViewText") == null) {
      setLeftViewName(2131690946);
    }
    for (;;)
    {
      paramBundle = (TabBarView)findViewById(2131378856);
      paramBundle.a(0, HardCodeUtil.a(2131701717));
      paramBundle.a(1, HardCodeUtil.a(2131701737));
      paramBundle.a(2, HardCodeUtil.a(2131701727));
      paramBundle.a(3, HardCodeUtil.a(2131701665));
      paramBundle.a(4, HardCodeUtil.a(2131701736));
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131377740));
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131379636));
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
      setRightButton(2131690022, this);
      c();
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131370993));
      paramBundle.setOnTabChangeListener(new ChatHistoryFileActivity.1(this));
      localObject = ((Intent)localObject).getStringExtra("com.tencent.mobileqq.ChatHistoryFileActivity.initial_tab");
      try
      {
        i = Integer.parseInt((String)localObject);
        paramBundle.setSelectedTab(i, true);
        this.jdField_a_of_type_ComTencentMobileqqActivityChathistorySeparateForward = new SeparateForward(this, 3);
        this.jdField_a_of_type_ComTencentMobileqqActivityChathistorySeparateForward.a();
        AIOGalleryMsgRevokeMgr.a().a(this);
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver == null) {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver = new ChatHistoryFileActivity.MyFMObserver(this, null);
        }
        this.app.getFileManagerNotifyCenter().addObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
        return true;
        setLeftViewName((Intent)localObject);
      }
      catch (NumberFormatException localNumberFormatException)
      {
        for (;;)
        {
          QLog.e("ChatHistoryFIleActivity", 1, "extra KEY_INITIAL_TAB " + (String)localObject + " is not number");
          int i = 0;
        }
      }
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    this.jdField_a_of_type_ComTencentMobileqqActivityChathistorySeparateForward.b();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView.d();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryEmotionView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryEmotionView.d();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver != null) {
      this.app.getFileManagerNotifyCenter().deleteObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
    }
    AIOGalleryMsgRevokeMgr.a().b(this);
  }
  
  public boolean doOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (this.jdField_a_of_type_Boolean))
    {
      a();
      return true;
    }
    return super.doOnKeyDown(paramInt, paramKeyEvent);
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryViewBase != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryViewBase.c();
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryViewBase != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryViewBase.j_(this.jdField_b_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryViewBase.b();
    }
  }
  
  public int getTitleBarHeight()
  {
    return getResources().getDimensionPixelSize(2131299166);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    int i;
    do
    {
      do
      {
        return true;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryStructMsgView != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryStructMsgView.a(this.jdField_a_of_type_JavaUtilList);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryEmotionView != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryEmotionView.g();
        }
        a();
        a(this.jdField_b_of_type_Int);
        return true;
      } while (this.jdField_a_of_type_AndroidAppDialog == null);
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
      return true;
      if (this.jdField_a_of_type_AndroidAppDialog != null) {
        this.jdField_a_of_type_AndroidAppDialog.dismiss();
      }
      WeiyunSaveTipsFactory.a(this.app, this, getTitleBarHeight());
      return true;
      if (this.jdField_a_of_type_AndroidAppDialog != null) {
        this.jdField_a_of_type_AndroidAppDialog.dismiss();
      }
      i = paramMessage.arg1;
    } while (!ResponseHandler.a(i));
    if (ResponseHandler.d(i))
    {
      getString(2131694689);
      paramMessage = "";
      if (ResponseHandler.b(i))
      {
        getString(2131694689);
        paramMessage = getString(2131692149);
      }
      for (;;)
      {
        ChatHistoryFileActivity.11 local11 = new ChatHistoryFileActivity.11(this);
        a(getString(2131698667), paramMessage, null, null, local11);
        return true;
        if (ResponseHandler.c(i))
        {
          getString(2131694689);
          paramMessage = getString(2131692147);
        }
      }
    }
    paramMessage = (String)paramMessage.obj;
    QQToast.a(this.app.getApp(), paramMessage, 1).b(getTitleBarHeight());
    return true;
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public boolean onBackEvent()
  {
    finish();
    if (getIntent().getBooleanExtra("extra.IS_FROM_CHAT_AIO_GALLERY", false)) {
      overridePendingTransition(0, 2130772353);
    }
    return false;
  }
  
  public void onClick(View paramView)
  {
    int j = 0;
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      a();
      if (this.jdField_a_of_type_Boolean)
      {
        ReportController.b(this.app, "dc00898", "", "", "0X8007125", "0X8007125", 0, 0, "", "", "", "");
        continue;
        if (a(0, this.jdField_a_of_type_JavaUtilList, this.jdField_b_of_type_JavaUtilList, this.jdField_c_of_type_JavaUtilList, this.jdField_d_of_type_JavaUtilList)) {
          a();
        }
        ReportController.b(this.app, "dc00898", "", "", "0X8007129", "0X8007129", 0, 0, "", "", "", "");
        continue;
        if (a(1, this.jdField_a_of_type_JavaUtilList, this.jdField_b_of_type_JavaUtilList, this.jdField_c_of_type_JavaUtilList, this.jdField_d_of_type_JavaUtilList)) {
          a();
        }
        ReportController.b(this.app, "dc00898", "", "", "0X800712A", "0X800712A", 0, 0, "", "", "", "");
        continue;
        if (a(2, this.jdField_a_of_type_JavaUtilList, this.jdField_b_of_type_JavaUtilList, this.jdField_c_of_type_JavaUtilList, this.jdField_d_of_type_JavaUtilList)) {
          a();
        }
        ReportController.b(this.app, "dc00898", "", "", "0X800712B", "0X800712B", 0, 0, "", "", "", "");
        continue;
        ReportController.b(this.app, "dc00898", "", "", "0X800712C", "0X800712C", 0, 0, "", "", "", "");
        if (this.jdField_a_of_type_JavaUtilList != null) {
          j = 0 + this.jdField_a_of_type_JavaUtilList.size();
        }
        int i = j;
        if (this.jdField_b_of_type_JavaUtilList != null) {
          i = j + this.jdField_b_of_type_JavaUtilList.size();
        }
        j = i;
        if (this.jdField_c_of_type_JavaUtilList != null) {
          j = i + this.jdField_c_of_type_JavaUtilList.size();
        }
        i = j;
        if (this.jdField_d_of_type_JavaUtilList != null) {
          i = j + this.jdField_d_of_type_JavaUtilList.size();
        }
        j = i;
        if (this.e != null) {
          j = i + this.e.size();
        }
        if (j == 0)
        {
          FMToastUtil.c(2131692499);
        }
        else
        {
          ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this, null);
          localActionSheet.setMainTitle(2131696078);
          localActionSheet.addButton(getString(2131692345), 3);
          localActionSheet.addCancelButton(2131690800);
          localActionSheet.setOnButtonClickListener(new ChatHistoryFileActivity.2(this, localActionSheet));
          localActionSheet.show();
        }
      }
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatHistoryFileActivity
 * JD-Core Version:    0.7.0.1
 */