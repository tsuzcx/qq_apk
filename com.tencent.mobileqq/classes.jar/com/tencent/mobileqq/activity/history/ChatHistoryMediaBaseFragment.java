package com.tencent.mobileqq.activity.history;

import android.app.Dialog;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.MsgRevokeListener;
import com.tencent.mobileqq.activity.ChatHistoryFileActivity.OnWyDialogClick;
import com.tencent.mobileqq.activity.ChatHistoryImageView;
import com.tencent.mobileqq.activity.ChatHistoryImageView.OperCallBack;
import com.tencent.mobileqq.activity.aio.photo.AIOFilePicData;
import com.tencent.mobileqq.activity.aio.photo.AIOFileVideoData;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryMsgRevokeMgr;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryUtils;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService;
import com.tencent.mobileqq.activity.aio.photo.AIOPhotoListAdapter;
import com.tencent.mobileqq.activity.aio.photo.AIORichMediaData;
import com.tencent.mobileqq.activity.aio.photo.AIORichMediaInfo;
import com.tencent.mobileqq.activity.aio.photo.AIOShortVideoData;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.multimsg.save.FileSaveDialog;
import com.tencent.mobileqq.multimsg.save.FileSaveReq;
import com.tencent.mobileqq.multimsg.save.MultiRichMediaSaveManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.startup.step.CheckPermission;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.weiyun.api.IWeiyunResponseHandler;
import com.tencent.mobileqq.weiyun.api.IWeiyunSaveTipsHelper;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.util.MqqWeakReferenceHandler;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import cooperation.weiyun.WeiyunAIOUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.List<Lcom.tencent.mobileqq.activity.aio.photo.AIORichMediaInfo;>;
import mqq.os.MqqHandler;

public class ChatHistoryMediaBaseFragment
  extends ChatHistoryBaseFragment
  implements Handler.Callback, View.OnClickListener, MsgRevokeListener, ChatHistoryImageView.OperCallBack
{
  private Button jdField_a_of_type_AndroidWidgetButton;
  ChatHistoryImageView jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView;
  private FMObserver jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver = null;
  public ArrayList<AIORichMediaInfo> a;
  List<ChatMessage> jdField_a_of_type_JavaUtilList;
  protected final MqqHandler a;
  private View jdField_b_of_type_AndroidViewView;
  QQCustomDialog jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  private Dialog c;
  protected QQCustomDialog c;
  
  public ChatHistoryMediaBaseFragment()
  {
    this.jdField_a_of_type_MqqOsMqqHandler = new MqqWeakReferenceHandler(Looper.getMainLooper(), this, true);
  }
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4, ChatHistoryFileActivity.OnWyDialogClick paramOnWyDialogClick)
  {
    QQCustomDialog localQQCustomDialog = this.jdField_c_of_type_ComTencentMobileqqUtilsQQCustomDialog;
    if ((localQQCustomDialog != null) && (localQQCustomDialog.isShowing())) {
      this.jdField_c_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
    }
    localQQCustomDialog = new QQCustomDialog(getBaseActivity(), 2131756189);
    localQQCustomDialog.setContentView(2131558978);
    this.jdField_c_of_type_ComTencentMobileqqUtilsQQCustomDialog = localQQCustomDialog;
    this.jdField_c_of_type_ComTencentMobileqqUtilsQQCustomDialog.setTitle(paramString1);
    this.jdField_c_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessage(paramString2);
    paramString1 = paramString4;
    if (TextUtils.isEmpty(paramString4)) {
      paramString1 = getString(2131690728);
    }
    paramString2 = paramString3;
    if (TextUtils.isEmpty(paramString3)) {
      paramString2 = getString(2131691064);
    }
    this.jdField_c_of_type_ComTencentMobileqqUtilsQQCustomDialog.setNegativeButton(paramString1, new ChatHistoryMediaBaseFragment.5(this, paramOnWyDialogClick));
    this.jdField_c_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPositiveButton(paramString2, new ChatHistoryMediaBaseFragment.6(this, paramOnWyDialogClick));
    this.jdField_c_of_type_ComTencentMobileqqUtilsQQCustomDialog.setCancelable(true);
    this.jdField_c_of_type_ComTencentMobileqqUtilsQQCustomDialog.setCanceledOnTouchOutside(false);
    this.jdField_c_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
  }
  
  private void a(List<AIORichMediaInfo> paramList)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView;
    if ((localObject != null) && (((ChatHistoryImageView)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService != null))
    {
      ArrayList localArrayList = new ArrayList();
      if ((paramList != null) && (paramList.size() > 0))
      {
        Iterator localIterator = paramList.iterator();
        while (localIterator.hasNext())
        {
          AIORichMediaInfo localAIORichMediaInfo = (AIORichMediaInfo)localIterator.next();
          localObject = null;
          ChatMessage localChatMessage = this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.a(localAIORichMediaInfo.a.f);
          if ((localChatMessage instanceof MessageForPic))
          {
            paramList = FileSaveReq.a((MessageForPic)localChatMessage);
          }
          else if ((localChatMessage instanceof MessageForShortVideo))
          {
            paramList = (MessageForShortVideo)localChatMessage;
            if (paramList.busiType == 0) {
              paramList = FileSaveReq.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramList);
            } else {
              paramList = FileSaveReq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramList);
            }
          }
          else if ((localChatMessage instanceof MessageForFile))
          {
            if (AIOFilePicData.class.isInstance(localAIORichMediaInfo.a))
            {
              paramList = FileSaveReq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localChatMessage);
              paramList.a = 4;
            }
            else
            {
              paramList = (List<AIORichMediaInfo>)localObject;
              if (AIOFileVideoData.class.isInstance(localAIORichMediaInfo.a))
              {
                paramList = FileSaveReq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localChatMessage);
                paramList.a = 5;
              }
            }
          }
          else
          {
            paramList = (List<AIORichMediaInfo>)localObject;
            if ((localChatMessage instanceof MessageForTroopFile))
            {
              int i = FileManagerUtil.a(((MessageForTroopFile)localChatMessage).fileName);
              if (i == 0)
              {
                paramList = FileSaveReq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localChatMessage);
                paramList.a = 6;
              }
              else
              {
                paramList = (List<AIORichMediaInfo>)localObject;
                if (i == 2)
                {
                  paramList = FileSaveReq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localChatMessage);
                  paramList.a = 7;
                }
              }
            }
          }
          if (paramList != null) {
            localArrayList.add(paramList);
          }
        }
      }
      paramList = new FileSaveDialog(getBaseActivity());
      localObject = (MultiRichMediaSaveManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MULTI_CHOOSE_SAVE_MANAGER);
      ((MultiRichMediaSaveManager)localObject).a(new ChatHistoryMediaBaseFragment.3(this, paramList, (MultiRichMediaSaveManager)localObject, localArrayList));
      ((MultiRichMediaSaveManager)localObject).a(localArrayList, true);
      ((MultiRichMediaSaveManager)localObject).a(localArrayList, 1, 5);
    }
  }
  
  private void b(List<ChatMessage> paramList)
  {
    if (paramList.size() == 1) {
      WeiyunAIOUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getBaseActivity(), e(), paramList, this.jdField_a_of_type_MqqOsMqqHandler);
    } else {
      WeiyunAIOUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getBaseActivity(), e(), paramList, this.jdField_a_of_type_MqqOsMqqHandler);
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009DB9", "0X8009DB9", 0, 0, "", "", "", "");
  }
  
  private boolean b()
  {
    return ((getBaseActivity() instanceof ChatHistoryActivity)) && (((ChatHistoryActivity)getBaseActivity()).c);
  }
  
  public void a()
  {
    ChatHistoryImageView localChatHistoryImageView = this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView;
    if ((localChatHistoryImageView != null) && (localChatHistoryImageView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOPhotoListAdapter != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOPhotoListAdapter.getCount() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatHistoryMediaBaseFragment", 2, "onMediaLoaded, mImageView.mAdapter is null");
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryBaseViewController.a(false);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryBaseViewController.a(true);
  }
  
  public void a(long paramLong)
  {
    ChatHistoryImageView localChatHistoryImageView = this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView;
    if (localChatHistoryImageView != null) {
      localChatHistoryImageView.a(paramLong);
    }
  }
  
  public void a(AIORichMediaInfo paramAIORichMediaInfo)
  {
    ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    if (localArrayList == null) {
      return;
    }
    localArrayList.remove(paramAIORichMediaInfo);
  }
  
  public void a(ChatMessage paramChatMessage)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    this.jdField_a_of_type_JavaUtilList.add(paramChatMessage);
    if (QLog.isColorLevel())
    {
      paramChatMessage = new StringBuilder();
      paramChatMessage.append("addweiyunselected, size: ");
      paramChatMessage.append(this.jdField_a_of_type_JavaUtilList.size());
      QLog.d("ChatHistoryStruct", 2, paramChatMessage.toString());
    }
  }
  
  void a(ArrayList<AIORichMediaInfo> paramArrayList) {}
  
  public void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    if (this.jdField_a_of_type_Boolean)
    {
      ChatHistoryImageView localChatHistoryImageView = this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView;
      if ((localChatHistoryImageView != null) && (localChatHistoryImageView.a())) {
        this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView.a();
      }
    }
  }
  
  public boolean a()
  {
    ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    boolean bool = false;
    int i;
    if (localArrayList != null) {
      i = localArrayList.size() + 0;
    } else {
      i = 0;
    }
    if (i >= 20) {
      bool = true;
    }
    if (bool)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatHistoryMediaBaseFragment", 2, "isOverLimit");
      }
      FMToastUtil.a(2131692438);
    }
    return bool;
  }
  
  public boolean a(AIORichMediaInfo paramAIORichMediaInfo)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    }
    if (b())
    {
      int i = AIOGalleryUtils.a(paramAIORichMediaInfo.a);
      if ((i != 2) && (i != 3))
      {
        if (AIOImageData.class.isInstance(paramAIORichMediaInfo.a))
        {
          AIOImageData localAIOImageData = (AIOImageData)paramAIORichMediaInfo.a;
          if ((localAIOImageData.e == null) || (localAIOImageData.e.length() == 0))
          {
            b(getString(2131692455));
            return false;
          }
        }
      }
      else
      {
        b(getString(2131692456));
        return false;
      }
    }
    this.jdField_a_of_type_JavaUtilArrayList.add(paramAIORichMediaInfo);
    return true;
  }
  
  protected void b() {}
  
  public void b(ChatMessage paramChatMessage)
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    if (localList == null) {
      return;
    }
    localList.remove(paramChatMessage);
    if (QLog.isColorLevel())
    {
      paramChatMessage = new StringBuilder();
      paramChatMessage.append("removeweiyunselect, size: ");
      paramChatMessage.append(this.jdField_a_of_type_JavaUtilList.size());
      QLog.d("ChatHistoryStruct", 2, paramChatMessage.toString());
    }
  }
  
  public void b(String paramString)
  {
    if (this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog == null)
    {
      this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(getBaseActivity(), 230);
      this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.setNegativeButton(2131719065, new ChatHistoryMediaBaseFragment.2(this));
    }
    if (!this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing()) {
      this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessage(paramString);
    } else {
      this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
    }
    try
    {
      this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
      return;
    }
    catch (Throwable paramString) {}
  }
  
  void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      v();
      t();
      return;
    }
    w();
  }
  
  protected int c()
  {
    return 1602;
  }
  
  protected void c() {}
  
  public int d()
  {
    Object localObject = this.jdField_a_of_type_JavaUtilArrayList;
    if (localObject != null)
    {
      if (((ArrayList)localObject).isEmpty()) {
        return 0;
      }
      localObject = ((AIORichMediaInfo)this.jdField_a_of_type_JavaUtilArrayList.get(0)).a;
      if ((!AIOImageData.class.isInstance(localObject)) && (!AIOFilePicData.class.isInstance(localObject)))
      {
        if (AIOShortVideoData.class.isInstance(localObject)) {
          return 2;
        }
        return 0;
      }
      return 1;
    }
    return 0;
  }
  
  public int e()
  {
    return getResources().getDimensionPixelSize(2131299168);
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryBaseViewController == null) {
      return;
    }
    super.e();
    ChatHistoryImageView localChatHistoryImageView = this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView;
    if (localChatHistoryImageView == null) {
      return;
    }
    if ((localChatHistoryImageView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService == null) || (!AIOImageProviderService.a.containsValue(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService))) {
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView.g();
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView.b();
    w();
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOPhotoListAdapter != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOPhotoListAdapter.getCount() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatHistoryMediaBaseFragment", 2, "doOnResume, mImageView.mAdapter is null");
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryBaseViewController.a(false);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryBaseViewController.a(true);
  }
  
  public void f()
  {
    super.f();
    ChatHistoryImageView localChatHistoryImageView = this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView;
    if (localChatHistoryImageView != null) {
      localChatHistoryImageView.c();
    }
  }
  
  public void g()
  {
    super.g();
    AIOGalleryMsgRevokeMgr.a().b(this);
    ChatHistoryImageView localChatHistoryImageView = this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView;
    if (localChatHistoryImageView != null) {
      localChatHistoryImageView.d();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().deleteObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
    }
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
        paramMessage = this.jdField_c_of_type_AndroidAppDialog;
        if (paramMessage != null) {
          paramMessage.dismiss();
        }
        w();
        return true;
      case 101: 
        Object localObject = this.jdField_c_of_type_AndroidAppDialog;
        if (localObject != null) {
          ((Dialog)localObject).dismiss();
        }
        w();
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
          localObject = new ChatHistoryMediaBaseFragment.4(this);
          a(getString(2131698736), paramMessage, null, null, (ChatHistoryFileActivity.OnWyDialogClick)localObject);
          return true;
        }
        paramMessage = (String)paramMessage.obj;
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), paramMessage, 1).b(e());
        return true;
      case 100: 
        paramMessage = this.jdField_c_of_type_AndroidAppDialog;
        if (paramMessage != null) {
          paramMessage.dismiss();
        }
        ((IWeiyunSaveTipsHelper)QRoute.api(IWeiyunSaveTipsHelper.class)).showTopTips(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getBaseActivity(), e());
        w();
        return true;
      }
    }
    else
    {
      w();
      r();
    }
    return true;
  }
  
  public void i()
  {
    if (this.jdField_c_of_type_AndroidAppDialog == null)
    {
      this.jdField_c_of_type_AndroidAppDialog = new ReportDialog(getBaseActivity(), 2131756189);
      this.jdField_c_of_type_AndroidAppDialog.setCanceledOnTouchOutside(false);
      this.jdField_c_of_type_AndroidAppDialog.setContentView(2131559561);
    }
    TextView localTextView = (TextView)this.jdField_c_of_type_AndroidAppDialog.findViewById(2131372646);
    localTextView.setText(localTextView.getResources().getString(2131689883));
    if (!this.jdField_c_of_type_AndroidAppDialog.isShowing()) {}
    try
    {
      this.jdField_c_of_type_AndroidAppDialog.show();
      return;
    }
    catch (Exception localException) {}
  }
  
  protected void k()
  {
    if (!CheckPermission.isHasStoragePermission(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity))
    {
      CheckPermission.requestStorePermission(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, null);
      return;
    }
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      QQToast.a(getBaseActivity(), 2131694475, 1).b(getResources().getDimensionPixelSize(2131299168));
      return;
    }
    ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      a(this.jdField_a_of_type_JavaUtilArrayList);
      s();
      return;
    }
    FMToastUtil.c(2131692435);
  }
  
  protected void l()
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    if ((localList != null) && (localList.size() > 0))
    {
      i();
      b(this.jdField_a_of_type_JavaUtilList);
      u();
      return;
    }
    FMToastUtil.c(2131692435);
  }
  
  protected void m()
  {
    Object localObject = this.jdField_a_of_type_JavaUtilArrayList;
    int m = 0;
    int i;
    int j;
    int k;
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      i = 0;
      int i3 = 0;
      j = 0;
      k = 0;
      while (((Iterator)localObject).hasNext())
      {
        int i4 = AIOGalleryUtils.a(((AIORichMediaInfo)((Iterator)localObject).next()).a);
        m = i;
        int i1 = i3;
        if (i3 == 0)
        {
          m = i;
          i1 = i3;
          if (i4 == 1)
          {
            m = i + 1;
            i1 = 1;
          }
        }
        int n = m;
        int i2 = k;
        if (k == 0)
        {
          n = m;
          i2 = k;
          if (i4 == 2)
          {
            n = m + 1;
            i2 = 1;
          }
        }
        i = n;
        i3 = i1;
        k = i2;
        if (j == 0)
        {
          i = n;
          i3 = i1;
          k = i2;
          if (i4 == 3)
          {
            i = n + 1;
            j = 1;
            i3 = i1;
            k = i2;
          }
        }
      }
      m = 0 + this.jdField_a_of_type_JavaUtilArrayList.size();
    }
    else
    {
      i = 0;
      j = 0;
      k = 0;
    }
    if (m == 0)
    {
      FMToastUtil.c(2131692435);
      return;
    }
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      QQToast.a(getBaseActivity(), 2131694475, 1).b(getResources().getDimensionPixelSize(2131299168));
      return;
    }
    if (i > 1)
    {
      b(getString(2131692429));
      return;
    }
    if (j != 0)
    {
      b(getString(2131692410));
      return;
    }
    if ((k != 0) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 1))
    {
      b(getString(2131692431));
      return;
    }
    q();
  }
  
  protected void n()
  {
    Object localObject = this.jdField_a_of_type_JavaUtilArrayList;
    int i = 0;
    if (localObject != null) {
      i = 0 + ((ArrayList)localObject).size();
    }
    if (i == 0)
    {
      FMToastUtil.c(2131692435);
      return;
    }
    localObject = (ActionSheet)ActionSheetHelper.a(getBaseActivity(), null);
    ((ActionSheet)localObject).setMainTitle(2131696093);
    ((ActionSheet)localObject).addButton(getBaseActivity().getString(2131692273), 3);
    ((ActionSheet)localObject).addCancelButton(2131690728);
    ((ActionSheet)localObject).setOnButtonClickListener(new ChatHistoryMediaBaseFragment.1(this, (ActionSheet)localObject));
    ((ActionSheet)localObject).show();
  }
  
  public void onClick(View paramView)
  {
    if ((paramView != null) && (paramView.getId() == 2131380266))
    {
      ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
      if ((localArrayList != null) && (localArrayList.size() != 0))
      {
        localArrayList = (ArrayList)this.jdField_a_of_type_JavaUtilArrayList.clone();
        int j = 0;
        Iterator localIterator = localArrayList.iterator();
        do
        {
          i = j;
          if (!localIterator.hasNext()) {
            break;
          }
          i = AIOGalleryUtils.a(((AIORichMediaInfo)localIterator.next()).a);
        } while ((i != 2) && (i != 3));
        int i = 1;
        if (i != 0) {
          b(getString(2131692456));
        } else {
          a(localArrayList);
        }
        getBaseActivity().finish();
      }
      else
      {
        FMToastUtil.c(2131692435);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    AIOGalleryMsgRevokeMgr.a().a(this);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView = new ChatHistoryImageView();
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView.a(getBaseActivity().getIntent(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getBaseActivity());
        this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView.a(true);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView$OperCallBack = this;
    }
    if ((b()) && ((this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView.a() instanceof RelativeLayout)))
    {
      paramViewGroup = (RelativeLayout)this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView.a();
      this.jdField_b_of_type_AndroidViewView = paramLayoutInflater.inflate(2131558791, null);
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_b_of_type_AndroidViewView.findViewById(2131380266));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
      paramLayoutInflater = new RelativeLayout.LayoutParams(-1, -2);
      paramLayoutInflater.addRule(12, -1);
      paramLayoutInflater.addRule(14, -1);
      paramViewGroup.addView(this.jdField_b_of_type_AndroidViewView, paramLayoutInflater);
      paramLayoutInflater = paramViewGroup;
    }
    else
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver == null) {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver = new ChatHistoryMediaBaseFragment.MyFMObserver(this, null);
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().addObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
      }
      paramLayoutInflater = this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView.a();
    }
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  protected void q() {}
  
  void r() {}
  
  void s() {}
  
  void t() {}
  
  void u() {}
  
  protected void v()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView;
    if (localObject != null) {
      ((ChatHistoryImageView)localObject).e();
    }
    localObject = this.jdField_a_of_type_AndroidWidgetButton;
    if (localObject != null) {
      ((Button)localObject).setEnabled(true);
    }
  }
  
  protected void w()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView;
    if (localObject != null) {
      ((ChatHistoryImageView)localObject).f();
    }
    localObject = this.jdField_a_of_type_JavaUtilArrayList;
    if (localObject != null)
    {
      ((ArrayList)localObject).clear();
      this.jdField_a_of_type_JavaUtilArrayList = null;
    }
    localObject = this.jdField_a_of_type_JavaUtilList;
    if (localObject != null)
    {
      ((List)localObject).clear();
      this.jdField_a_of_type_JavaUtilList = null;
    }
    localObject = this.jdField_a_of_type_AndroidWidgetButton;
    if (localObject != null) {
      ((Button)localObject).setEnabled(false);
    }
    h();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryMediaBaseFragment
 * JD-Core Version:    0.7.0.1
 */