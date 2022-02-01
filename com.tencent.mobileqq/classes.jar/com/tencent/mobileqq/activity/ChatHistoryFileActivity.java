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
import com.tencent.mobileqq.MsgRevokeListener;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.photo.AIOFilePicData;
import com.tencent.mobileqq.activity.aio.photo.AIOFileVideoData;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryMsgRevokeMgr;
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
import com.tencent.mobileqq.filemanager.recreate.IFModel;
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
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtils;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtilsTemp;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.weiyun.api.IWeiyunResponseHandler;
import com.tencent.mobileqq.weiyun.api.IWeiyunSaveTipsHelper;
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
import cooperation.weiyun.WeiyunAIOUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class ChatHistoryFileActivity
  extends IphoneTitleBarActivity
  implements Handler.Callback, View.OnClickListener, MsgRevokeListener
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
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if (paramInt != 4) {
              return null;
            }
            if (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryEmotionView == null)
            {
              this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryEmotionView = new ChatHistoryEmotionView();
              this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryEmotionView.a(getIntent(), this.app, this);
            }
            return this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryEmotionView;
          }
        }
        else
        {
          if (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryStructMsgView == null)
          {
            this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryStructMsgView = new ChatHistoryStructMsgView();
            this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryStructMsgView.a(getIntent(), this.app, this);
          }
          return this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryStructMsgView;
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileView == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileView = new ChatHistoryFileView();
        this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileView.a(getIntent(), this.app, this);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileView.a(paramInt);
      return this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileView;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView = new ChatHistoryImageView();
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView.a(getIntent(), this.app, this);
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView;
  }
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4, ChatHistoryFileActivity.OnWyDialogClick paramOnWyDialogClick)
  {
    QQCustomDialog localQQCustomDialog = this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog;
    if ((localQQCustomDialog != null) && (localQQCustomDialog.isShowing())) {
      this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
    }
    localQQCustomDialog = new QQCustomDialog(this, 2131756189);
    localQQCustomDialog.setContentView(2131558978);
    this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog = localQQCustomDialog;
    this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.setTitle(paramString1);
    this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessage(paramString2);
    paramString1 = paramString4;
    if (TextUtils.isEmpty(paramString4)) {
      paramString1 = getString(2131690728);
    }
    paramString2 = paramString3;
    if (TextUtils.isEmpty(paramString3)) {
      paramString2 = getString(2131691064);
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
    } else {
      WeiyunAIOUtils.a(this.app, this, getTitleBarHeight(), paramList, this.jdField_a_of_type_MqqOsMqqHandler);
    }
    ReportController.b(this.app, "dc00898", "", "", "0X8009DB9", "0X8009DB9", 0, 0, "", "", "", "");
  }
  
  private void a(List<AIORichMediaInfo> paramList, List<EmotionPreviewData> paramList1)
  {
    ChatHistoryImageView localChatHistoryImageView = this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView;
    if ((localChatHistoryImageView != null) && (localChatHistoryImageView.a != null))
    {
      ArrayList localArrayList = new ArrayList();
      if ((paramList != null) && (paramList.size() > 0))
      {
        Iterator localIterator = paramList.iterator();
        while (localIterator.hasNext())
        {
          AIORichMediaInfo localAIORichMediaInfo = (AIORichMediaInfo)localIterator.next();
          localChatHistoryImageView = null;
          ChatMessage localChatMessage = this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView.a.a(localAIORichMediaInfo.a.f);
          if ((localChatMessage instanceof MessageForPic))
          {
            paramList = FileSaveReq.a((MessageForPic)localChatMessage);
          }
          else if ((localChatMessage instanceof MessageForShortVideo))
          {
            paramList = (MessageForShortVideo)localChatMessage;
            if (paramList.busiType == 0) {
              paramList = FileSaveReq.b(this.app, paramList);
            } else {
              paramList = FileSaveReq.a(this.app, paramList);
            }
          }
          else if ((localChatMessage instanceof MessageForFile))
          {
            if (AIOFilePicData.class.isInstance(localAIORichMediaInfo.a))
            {
              paramList = FileSaveReq.a(this.app, localChatMessage);
              paramList.jdField_a_of_type_Int = 4;
            }
            else
            {
              paramList = localChatHistoryImageView;
              if (AIOFileVideoData.class.isInstance(localAIORichMediaInfo.a))
              {
                paramList = FileSaveReq.a(this.app, localChatMessage);
                paramList.jdField_a_of_type_Int = 5;
              }
            }
          }
          else
          {
            paramList = localChatHistoryImageView;
            if ((localChatMessage instanceof MessageForTroopFile)) {
              if (AIOFilePicData.class.isInstance(localAIORichMediaInfo.a))
              {
                paramList = FileSaveReq.a(this.app, localChatMessage);
                paramList.jdField_a_of_type_Int = 6;
              }
              else
              {
                paramList = localChatHistoryImageView;
                if (AIOFileVideoData.class.isInstance(localAIORichMediaInfo.a))
                {
                  paramList = FileSaveReq.a(this.app, localChatMessage);
                  paramList.jdField_a_of_type_Int = 7;
                }
              }
            }
          }
          if (paramList != null) {
            localArrayList.add(paramList);
          }
        }
      }
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
    }
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131367180));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131365828));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131376896));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131365465));
    StateListDrawable localStateListDrawable = new StateListDrawable();
    Drawable localDrawable = getResources().getDrawable(2130839479);
    localStateListDrawable.addState(new int[] { 16842919 }, localDrawable);
    localDrawable = getResources().getDrawable(2130839480);
    localStateListDrawable.addState(new int[] { 16842910 }, localDrawable);
    localDrawable = getResources().getDrawable(2130839479);
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
    this.jdField_a_of_type_Boolean ^= true;
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryViewBase.e();
      setRightButton(2131690728, this);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryViewBase.f();
    setRightButton(2131689937, this);
    this.jdField_d_of_type_JavaUtilList = null;
    this.jdField_c_of_type_JavaUtilList = null;
    this.jdField_a_of_type_JavaUtilList = null;
    this.jdField_b_of_type_JavaUtilList = null;
    this.f = null;
    Object localObject = this.e;
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      localObject = this.e.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((EmotionPreviewData)((Iterator)localObject).next()).jdField_a_of_type_Boolean = false;
      }
      this.e.clear();
    }
  }
  
  public void a(long paramLong)
  {
    ChatHistoryViewBase localChatHistoryViewBase = this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryViewBase;
    if (localChatHistoryViewBase != null) {
      localChatHistoryViewBase.a(paramLong);
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
    if (QLog.isColorLevel())
    {
      paramChatMessage = new StringBuilder();
      paramChatMessage.append("addweiyunselected, size: ");
      paramChatMessage.append(this.f.size());
      QLog.d("ChatHistoryStruct", 2, paramChatMessage.toString());
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
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setNegativeButton(2131719065, new ChatHistoryFileActivity.12(this));
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing()) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessage(paramString);
    } else {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
    }
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
      return;
    }
    catch (Throwable paramString) {}
  }
  
  public boolean a()
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    boolean bool = false;
    if (localList != null) {
      j = localList.size() + 0;
    } else {
      j = 0;
    }
    localList = this.jdField_b_of_type_JavaUtilList;
    int i = j;
    if (localList != null) {
      i = j + localList.size();
    }
    localList = this.jdField_c_of_type_JavaUtilList;
    int j = i;
    if (localList != null) {
      j = i + localList.size();
    }
    localList = this.jdField_d_of_type_JavaUtilList;
    i = j;
    if (localList != null) {
      i = j + localList.size();
    }
    localList = this.e;
    j = i;
    if (localList != null) {
      j = i + localList.size();
    }
    if (j >= 20) {
      bool = true;
    }
    if (bool)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatHistoryFIleActivity", 2, "isOverLimit");
      }
      FMToastUtil.a(2131692438);
    }
    return bool;
  }
  
  boolean a(int paramInt, List<ChatMessage> paramList, List<FileManagerEntity> paramList1, List<AIORichMediaInfo> paramList2, List<TencentDocData> paramList3)
  {
    boolean bool2 = ((ITeamWorkUtils)QRoute.api(ITeamWorkUtils.class)).isCollectionNotEmpty(paramList3);
    int j;
    int m;
    int i4;
    if ((paramList1 != null) && (paramList1.size() > 0))
    {
      j = paramList1.size() + 0;
      m = 1;
      i4 = 1;
    }
    else
    {
      m = 0;
      j = 0;
      i4 = 0;
    }
    int k = m;
    int i = j;
    if (bool2)
    {
      k = m + 1;
      i = j + paramList3.size();
    }
    int i5;
    if ((paramList != null) && (paramList.size() > 0))
    {
      j = k + 1;
      k = i + paramList.size();
      i5 = 1;
      i = j;
      j = k;
    }
    else
    {
      i5 = 0;
      j = i;
      i = k;
    }
    Object localObject1 = this.e;
    boolean bool1;
    if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
    {
      if (paramInt == 1)
      {
        localObject1 = this.e.iterator();
        while (((Iterator)localObject1).hasNext()) {
          if ((((EmotionPreviewData)((Iterator)localObject1).next()).jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForMarketFace)) {
            break label220;
          }
        }
        bool1 = false;
      }
      else
      {
        label220:
        bool1 = true;
      }
      i += 1;
      j += this.e.size();
    }
    else
    {
      bool1 = false;
    }
    int n;
    if (paramList2 != null)
    {
      localObject1 = paramList2.iterator();
      int i2 = 0;
      int i1 = 0;
      m = 0;
      while (((Iterator)localObject1).hasNext())
      {
        int i6 = AIOGalleryUtils.a(((AIORichMediaInfo)((Iterator)localObject1).next()).a);
        n = i2;
        int i3 = i;
        if (i2 == 0)
        {
          n = i2;
          i3 = i;
          if (i6 == 1)
          {
            i3 = i + 1;
            n = 1;
          }
        }
        i = i3;
        k = i1;
        if (i1 == 0)
        {
          i = i3;
          k = i1;
          if (i6 == 2)
          {
            i = i3 + 1;
            k = 1;
          }
        }
        if ((m == 0) && (i6 == 3))
        {
          i += 1;
          m = 1;
        }
        if ((paramInt != 1) && (i >= 2)) {
          break label428;
        }
        i2 = n;
        i1 = k;
      }
      n = i2;
      k = i1;
      label428:
      j += paramList2.size();
    }
    else
    {
      n = 0;
      k = 0;
      m = 0;
    }
    if (j == 0)
    {
      FMToastUtil.c(2131692435);
      return false;
    }
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3) {
            return true;
          }
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
          if (paramList2 != null)
          {
            paramList2 = this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView;
            if (paramList2 != null)
            {
              paramList2 = paramList2.a();
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
          }
          if ((paramList != null) && (paramList.size() > 0)) {
            ((List)localObject1).addAll(paramList);
          }
          paramList = this.e;
          if ((paramList != null) && (!paramList.isEmpty()))
          {
            paramList = this.e.iterator();
            while (paramList.hasNext()) {
              ((List)localObject1).add((ChatMessage)((EmotionPreviewData)paramList.next()).jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
            }
          }
          if ((((List)localObject1).size() == 0) && (paramList1 == null) && (!bool2)) {
            return true;
          }
          if ((((List)localObject1).size() > 0) || (((ITeamWorkUtils)QRoute.api(ITeamWorkUtils.class)).isCollectionNotEmpty(paramList1)) || (bool2))
          {
            ThreadManager.post(new ChatHistoryFileActivity.7(this, (List)localObject1, paramList1, bool2, paramList3), 8, null, true);
            return true;
          }
        }
        else
        {
          if (((paramList2 != null) && (this.f != null)) || ((paramList != null) && (paramList.size() > 0)) || ((paramList1 != null) && (paramList1.size() > 0))) {
            b();
          }
          if (paramList2 != null)
          {
            paramList2 = this.f;
            if (paramList2 != null) {
              a(paramList2);
            }
          }
          if (paramList != null)
          {
            a(paramList);
            return true;
          }
          if ((paramList1 != null) && (paramList1.size() > 0))
          {
            paramList = (FileManagerEntity)paramList1.get(0);
            paramList = this.app.getFileManagerEngine();
            if ((paramList1.size() == 1) && (((FileManagerEntity)paramList1.get(0)).sendCloudUnsuccessful()))
            {
              FMToastUtil.a(2131692451);
              return false;
            }
            paramList2 = paramList1.iterator();
            while (paramList2.hasNext()) {
              if (FileModel.a((FileManagerEntity)paramList2.next()).a(false))
              {
                paramInt = 1;
                break label1069;
              }
            }
            paramInt = 0;
            label1069:
            if (paramInt != 0)
            {
              if (FreeWifiHelper.a(this, 5, new ChatHistoryFileActivity.5(this, paramList1, paramList)))
              {
                FMDialogUtil.a(this, 2131692561, 2131692564, new ChatHistoryFileActivity.6(this, paramList1, paramList));
                return true;
              }
            }
            else
            {
              paramList1 = paramList1.iterator();
              paramInt = 0;
              while (paramList1.hasNext())
              {
                paramList2 = (FileManagerEntity)paramList1.next();
                if (!paramList2.sendCloudUnsuccessful())
                {
                  if (FileUtils.fileExistsAndNotEmpty(paramList2.getFilePath())) {
                    paramList.a(paramList2.getFilePath(), "", this.app.getCurrentAccountUin(), 0, false);
                  } else {
                    paramList.a(paramList2, String.valueOf(paramList2.peerUin));
                  }
                  paramInt = 1;
                }
              }
              if (paramInt != 0)
              {
                FMToastUtil.d(getString(2131692690));
                return true;
              }
              FMToastUtil.a(2131692451);
              paramList = this.jdField_a_of_type_MqqOsMqqHandler;
              if (paramList != null)
              {
                paramList.sendEmptyMessage(102);
                return true;
              }
            }
          }
        }
      }
      else
      {
        if (((n != 0) || (k != 0)) && (i4 != 0))
        {
          a(getString(2131692427));
          return false;
        }
        if ((i5 == 0) && (!bool2) && (!bool1))
        {
          if (!CheckPermission.isHasStoragePermission(this))
          {
            CheckPermission.requestStorePermission(this, null);
            return false;
          }
          if (paramList1 != null)
          {
            long l = 0L;
            if ((paramList1.size() == 1) && (((FileManagerEntity)paramList1.get(0)).sendCloudUnsuccessful()))
            {
              FMToastUtil.a(2131692449);
              return false;
            }
            paramList = paramList1.iterator();
            while (paramList.hasNext())
            {
              paramList3 = (FileManagerEntity)paramList.next();
              if (FileModel.a(paramList3).a(true)) {
                l += paramList3.fileSize;
              }
            }
            paramList = this.app.getFileManagerEngine();
            if ((FileManagerUtil.a()) && (l > ((IFMConfig)QRoute.api(IFMConfig.class)).getFlowDialogSize()))
            {
              FileManagerUtil.a(false, this, new ChatHistoryFileActivity.4(this, paramList1, paramList));
            }
            else
            {
              paramList1 = paramList1.iterator();
              while (paramList1.hasNext())
              {
                paramList3 = (FileManagerEntity)paramList1.next();
                if (!paramList3.sendCloudUnsuccessful()) {
                  paramList.c(paramList3);
                }
              }
            }
          }
          if ((paramList2 == null) || (paramList2.size() <= 0))
          {
            if (!bool1)
            {
              paramList = this.e;
              if ((paramList == null) || (paramList.isEmpty())) {}
            }
          }
          else
          {
            a(paramList2, this.e);
            return false;
          }
        }
        else
        {
          a(getString(2131692428));
          return false;
        }
      }
    }
    else
    {
      if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
      {
        QQToast.a(this, 2131694475, 1).b(getResources().getDimensionPixelSize(2131299168));
        return false;
      }
      if (i > 1)
      {
        a(getString(2131692429));
        return false;
      }
      if (m != 0)
      {
        a(getString(2131692410));
        return false;
      }
      if ((k != 0) && (paramList2.size() > 1))
      {
        a(getString(2131692431));
        return false;
      }
      if (paramList1 != null)
      {
        if ((paramList1.size() == 1) && (((FileManagerEntity)paramList1.get(0)).sendCloudUnsuccessful()))
        {
          FMToastUtil.a(2131692450);
          return false;
        }
        localObject1 = paramList1.iterator();
        while (((Iterator)localObject1).hasNext()) {
          if (FileModel.a((FileManagerEntity)((Iterator)localObject1).next()).a(false))
          {
            paramInt = 1;
            break label1752;
          }
        }
        paramInt = 0;
        label1752:
        if (paramInt != 0) {
          FMDialogUtil.a(this, 2131692561, 2131692566, new ChatHistoryFileActivity.3(this, paramList1));
        } else {
          FileManagerUtil.a(paramList1, this);
        }
      }
      if ((paramList2 != null) && (paramList2.size() > 0))
      {
        paramList1 = this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView;
        if (paramList1 != null)
        {
          paramList1.h();
          return false;
        }
      }
      paramList1 = new ArrayList();
      if (paramList != null) {
        paramList1.addAll(paramList);
      }
      if (bool2)
      {
        paramList1.addAll(((ITeamWorkUtilsTemp)QRoute.api(ITeamWorkUtilsTemp.class)).createChatMsgListFromTencentDocs(paramList3, this.jdField_a_of_type_JavaLangString, null));
        FileManagerReporter.a("0X8009AA1");
      }
      if (paramList1.size() == 1)
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
      if ((paramList1.size() > 1) || (bool1))
      {
        paramList = new ArrayList();
        paramList.addAll(paramList1);
        if (bool1)
        {
          paramList1 = this.e.iterator();
          while (paramList1.hasNext()) {
            paramList.add((ChatMessage)((EmotionPreviewData)paramList1.next()).jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
          }
        }
        this.jdField_b_of_type_Boolean = bool1;
        this.jdField_a_of_type_ComTencentMobileqqActivityChathistorySeparateForward.a(paramList);
      }
    }
    return true;
  }
  
  public boolean a(ChatMessage paramChatMessage)
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    if (localList == null) {
      return false;
    }
    return localList.contains(paramChatMessage);
  }
  
  public boolean a(TencentDocData paramTencentDocData)
  {
    List localList = this.jdField_d_of_type_JavaUtilList;
    return (localList != null) && (localList.contains(paramTencentDocData));
  }
  
  public boolean a(FileManagerEntity paramFileManagerEntity)
  {
    List localList = this.jdField_b_of_type_JavaUtilList;
    if (localList == null) {
      return false;
    }
    return localList.contains(paramFileManagerEntity);
  }
  
  void b()
  {
    if (this.jdField_a_of_type_AndroidAppDialog == null)
    {
      this.jdField_a_of_type_AndroidAppDialog = new ReportDialog(getActivity(), 2131756189);
      this.jdField_a_of_type_AndroidAppDialog.setCanceledOnTouchOutside(false);
      this.jdField_a_of_type_AndroidAppDialog.setContentView(2131559561);
    }
    TextView localTextView = (TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131372646);
    localTextView.setText(localTextView.getResources().getString(2131689883));
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
    List localList = this.jdField_c_of_type_JavaUtilList;
    if (localList == null) {
      return;
    }
    localList.remove(paramAIORichMediaInfo);
  }
  
  public void b(ChatMessage paramChatMessage)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    this.jdField_a_of_type_JavaUtilList.add(paramChatMessage);
    if (QLog.isColorLevel())
    {
      paramChatMessage = new StringBuilder();
      paramChatMessage.append("addselect, size: ");
      paramChatMessage.append(this.jdField_a_of_type_JavaUtilList.size());
      QLog.d("ChatHistoryStruct", 2, paramChatMessage.toString());
    }
  }
  
  public void b(TencentDocData paramTencentDocData)
  {
    List localList = this.jdField_d_of_type_JavaUtilList;
    if (localList == null) {
      return;
    }
    localList.remove(paramTencentDocData);
  }
  
  public void b(EmotionPreviewData paramEmotionPreviewData)
  {
    List localList = this.e;
    if (localList == null) {
      return;
    }
    localList.remove(paramEmotionPreviewData);
  }
  
  public void b(FileManagerEntity paramFileManagerEntity)
  {
    List localList = this.jdField_b_of_type_JavaUtilList;
    if (localList == null) {
      return;
    }
    localList.remove(paramFileManagerEntity);
  }
  
  public void c(ChatMessage paramChatMessage)
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    if (localList == null) {
      return;
    }
    localList.remove(paramChatMessage);
    if (QLog.isColorLevel())
    {
      paramChatMessage = new StringBuilder();
      paramChatMessage.append("removeselect, size: ");
      paramChatMessage.append(this.jdField_a_of_type_JavaUtilList.size());
      QLog.d("ChatHistoryStruct", 2, paramChatMessage.toString());
    }
  }
  
  public void d(ChatMessage paramChatMessage)
  {
    List localList = this.f;
    if (localList == null) {
      return;
    }
    localList.remove(paramChatMessage);
    if (QLog.isColorLevel())
    {
      paramChatMessage = new StringBuilder();
      paramChatMessage.append("removeweiyunselect, size: ");
      paramChatMessage.append(this.f.size());
      QLog.d("ChatHistoryStruct", 2, paramChatMessage.toString());
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == -1)
    {
      Object localObject;
      if (paramInt1 != 1)
      {
        if (paramInt1 != 2)
        {
          if (paramInt1 != 3)
          {
            if (paramInt1 == 98) {
              a();
            }
          }
          else if (!this.jdField_b_of_type_Boolean) {
            this.jdField_a_of_type_ComTencentMobileqqActivityChathistorySeparateForward.a(paramIntent);
          }
        }
        else
        {
          localObject = this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView;
          if (localObject != null) {
            ((ChatHistoryImageView)localObject).a(paramIntent);
          }
        }
      }
      else
      {
        localObject = new Intent(this, SendPhotoActivity.class);
        paramIntent = new Bundle(paramIntent.getExtras());
        if (QLog.isColorLevel()) {
          QLog.d("forward", 2, "AIOListGallerysence startChatAndSendMsg IS_WAIT_DEST_RESULT=true");
        }
        paramIntent.putBoolean("PhotoConst.HANDLE_DEST_RESULT", true);
        paramIntent.putInt("PhotoConst.SEND_BUSINESS_TYPE", 1031);
        ((Intent)localObject).putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", SplashActivity.class.getName());
        localObject = AIOUtils.a((Intent)localObject, null);
        ((Intent)localObject).putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
        paramIntent.putBoolean("PicContants.NEED_COMPRESS", false);
        paramIntent.putBoolean("send_in_background", false);
        ((Intent)localObject).putExtras(paramIntent);
        startActivity((Intent)localObject);
      }
    }
    if (paramInt1 == 1) {
      a();
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    Object localObject = getIntent();
    this.jdField_a_of_type_JavaLangString = ((Intent)localObject).getStringExtra("uin");
    int i = 0;
    this.jdField_a_of_type_Int = ((Intent)localObject).getIntExtra("uintype", 0);
    this.jdField_b_of_type_JavaLangString = ((Intent)localObject).getStringExtra("uinname");
    setContentView(2131558792);
    setTitle(2131690790);
    if (((Intent)localObject).getStringExtra("leftViewText") == null) {
      setLeftViewName(2131690874);
    } else {
      setLeftViewName((Intent)localObject);
    }
    paramBundle = (TabBarView)findViewById(2131378245);
    paramBundle.a(0, HardCodeUtil.a(2131701857));
    paramBundle.a(1, HardCodeUtil.a(2131701877));
    paramBundle.a(2, HardCodeUtil.a(2131701867));
    paramBundle.a(3, HardCodeUtil.a(2131701805));
    paramBundle.a(4, HardCodeUtil.a(2131701876));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131377167));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131378980));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
    setRightButton(2131689937, this);
    c();
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131370627));
    paramBundle.setOnTabChangeListener(new ChatHistoryFileActivity.1(this));
    localObject = ((Intent)localObject).getStringExtra("com.tencent.mobileqq.ChatHistoryFileActivity.initial_tab");
    try
    {
      int j = Integer.parseInt((String)localObject);
      i = j;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      label277:
      StringBuilder localStringBuilder;
      break label277;
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("extra KEY_INITIAL_TAB ");
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(" is not number");
    QLog.e("ChatHistoryFIleActivity", 1, localStringBuilder.toString());
    paramBundle.setSelectedTab(i, true);
    this.jdField_a_of_type_ComTencentMobileqqActivityChathistorySeparateForward = new SeparateForward(this, 3);
    this.jdField_a_of_type_ComTencentMobileqqActivityChathistorySeparateForward.a();
    AIOGalleryMsgRevokeMgr.a().a(this);
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver == null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver = new ChatHistoryFileActivity.MyFMObserver(this, null);
    }
    this.app.getFileManagerNotifyCenter().addObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    this.jdField_a_of_type_ComTencentMobileqqActivityChathistorySeparateForward.b();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView;
    if (localObject != null) {
      ((ChatHistoryImageView)localObject).d();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryEmotionView;
    if (localObject != null) {
      ((ChatHistoryEmotionView)localObject).d();
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
  
  protected void doOnPause()
  {
    super.doOnPause();
    ChatHistoryViewBase localChatHistoryViewBase = this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryViewBase;
    if (localChatHistoryViewBase != null) {
      localChatHistoryViewBase.c();
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    ChatHistoryViewBase localChatHistoryViewBase = this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryViewBase;
    if (localChatHistoryViewBase != null)
    {
      localChatHistoryViewBase.a(this.jdField_b_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryViewBase.b();
    }
  }
  
  public int getTitleBarHeight()
  {
    return getResources().getDimensionPixelSize(2131299168);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 2)
    {
      switch (i)
      {
      default: 
        return true;
      case 102: 
        paramMessage = this.jdField_a_of_type_AndroidAppDialog;
        if (paramMessage == null) {
          break;
        }
        paramMessage.dismiss();
        return true;
      case 101: 
        Object localObject = this.jdField_a_of_type_AndroidAppDialog;
        if (localObject != null) {
          ((Dialog)localObject).dismiss();
        }
        i = paramMessage.arg1;
        if (!((IWeiyunResponseHandler)QRoute.api(IWeiyunResponseHandler.class)).endSave2Weiyun(i)) {
          break;
        }
        if (((IWeiyunResponseHandler)QRoute.api(IWeiyunResponseHandler.class)).needShowGrayTips(i))
        {
          getString(2131694658);
          if (((IWeiyunResponseHandler)QRoute.api(IWeiyunResponseHandler.class)).isSpaceOverErrorCode(i))
          {
            getString(2131694658);
            paramMessage = getString(2131692068);
          }
          else if (((IWeiyunResponseHandler)QRoute.api(IWeiyunResponseHandler.class)).isFlowOverErrorCode(i))
          {
            getString(2131694658);
            paramMessage = getString(2131692066);
          }
          else
          {
            paramMessage = "";
          }
          localObject = new ChatHistoryFileActivity.11(this);
          a(getString(2131698736), paramMessage, null, null, (ChatHistoryFileActivity.OnWyDialogClick)localObject);
          return true;
        }
        paramMessage = (String)paramMessage.obj;
        QQToast.a(this.app.getApp(), paramMessage, 1).b(getTitleBarHeight());
        return true;
      case 100: 
        paramMessage = this.jdField_a_of_type_AndroidAppDialog;
        if (paramMessage != null) {
          paramMessage.dismiss();
        }
        ((IWeiyunSaveTipsHelper)QRoute.api(IWeiyunSaveTipsHelper.class)).showTopTips(this.app, this, getTitleBarHeight());
        return true;
      }
    }
    else
    {
      paramMessage = this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryStructMsgView;
      if (paramMessage != null) {
        paramMessage.a(this.jdField_a_of_type_JavaUtilList);
      }
      paramMessage = this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryEmotionView;
      if (paramMessage != null) {
        paramMessage.g();
      }
      a();
      a(this.jdField_b_of_type_Int);
    }
    return true;
  }
  
  protected boolean isWrapContent()
  {
    return false;
  }
  
  protected boolean onBackEvent()
  {
    finish();
    if (getIntent().getBooleanExtra("extra.IS_FROM_CHAT_AIO_GALLERY", false)) {
      overridePendingTransition(0, 2130772385);
    }
    return false;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      break;
    case 2131376896: 
      if (a(2, this.jdField_a_of_type_JavaUtilList, this.jdField_b_of_type_JavaUtilList, this.jdField_c_of_type_JavaUtilList, this.jdField_d_of_type_JavaUtilList)) {
        a();
      }
      ReportController.b(this.app, "dc00898", "", "", "0X800712B", "0X800712B", 0, 0, "", "", "", "");
      break;
    case 2131369233: 
      a();
      if (this.jdField_a_of_type_Boolean) {
        ReportController.b(this.app, "dc00898", "", "", "0X8007125", "0X8007125", 0, 0, "", "", "", "");
      }
      break;
    case 2131367180: 
      if (a(0, this.jdField_a_of_type_JavaUtilList, this.jdField_b_of_type_JavaUtilList, this.jdField_c_of_type_JavaUtilList, this.jdField_d_of_type_JavaUtilList)) {
        a();
      }
      ReportController.b(this.app, "dc00898", "", "", "0X8007129", "0X8007129", 0, 0, "", "", "", "");
      break;
    case 2131365828: 
      if (a(1, this.jdField_a_of_type_JavaUtilList, this.jdField_b_of_type_JavaUtilList, this.jdField_c_of_type_JavaUtilList, this.jdField_d_of_type_JavaUtilList)) {
        a();
      }
      ReportController.b(this.app, "dc00898", "", "", "0X800712A", "0X800712A", 0, 0, "", "", "", "");
      break;
    case 2131365465: 
      ReportController.b(this.app, "dc00898", "", "", "0X800712C", "0X800712C", 0, 0, "", "", "", "");
      int j = 0;
      Object localObject = this.jdField_a_of_type_JavaUtilList;
      if (localObject != null) {
        j = 0 + ((List)localObject).size();
      }
      localObject = this.jdField_b_of_type_JavaUtilList;
      int i = j;
      if (localObject != null) {
        i = j + ((List)localObject).size();
      }
      localObject = this.jdField_c_of_type_JavaUtilList;
      j = i;
      if (localObject != null) {
        j = i + ((List)localObject).size();
      }
      localObject = this.jdField_d_of_type_JavaUtilList;
      i = j;
      if (localObject != null) {
        i = j + ((List)localObject).size();
      }
      localObject = this.e;
      j = i;
      if (localObject != null) {
        j = i + ((List)localObject).size();
      }
      if (j == 0)
      {
        FMToastUtil.c(2131692435);
      }
      else
      {
        localObject = (ActionSheet)ActionSheetHelper.a(this, null);
        ((ActionSheet)localObject).setMainTitle(2131696093);
        ((ActionSheet)localObject).addButton(getString(2131692273), 3);
        ((ActionSheet)localObject).addCancelButton(2131690728);
        ((ActionSheet)localObject).setOnButtonClickListener(new ChatHistoryFileActivity.2(this, (ActionSheet)localObject));
        ((ActionSheet)localObject).show();
      }
      break;
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatHistoryFileActivity
 * JD-Core Version:    0.7.0.1
 */