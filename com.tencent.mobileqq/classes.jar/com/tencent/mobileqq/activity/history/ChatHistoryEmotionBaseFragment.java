package com.tencent.mobileqq.activity.history;

import android.app.Dialog;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.MsgRevokeListener;
import com.tencent.mobileqq.activity.ChatHistoryEmotionView;
import com.tencent.mobileqq.activity.ChatHistoryEmotionView.OperateCallBack;
import com.tencent.mobileqq.activity.ChatHistoryFileActivity.OnWyDialogClick;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryMsgRevokeMgr;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryUtils;
import com.tencent.mobileqq.activity.chathistory.SeparateForward;
import com.tencent.mobileqq.activity.history.widget.ChatHistorySelectBottomBar;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.EmoticonObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.emosm.api.IEmoBatchAddedHandlerApi;
import com.tencent.mobileqq.emosm.api.IEmoticonManagerService;
import com.tencent.mobileqq.emosm.favroaming.IEmoBatchAddedCallback;
import com.tencent.mobileqq.emosm.favroaming.IEmoBatchAddedHandler;
import com.tencent.mobileqq.emoticon.EmoticonOperateReport;
import com.tencent.mobileqq.emoticon.IChatHistoryEmotionBaseFragment;
import com.tencent.mobileqq.emoticon.IEmojiListenerManager;
import com.tencent.mobileqq.emoticon.api.EmojiManagerServiceConstant;
import com.tencent.mobileqq.emoticon.api.IEmojiManagerService;
import com.tencent.mobileqq.emoticonview.IPicEmoticonInfo;
import com.tencent.mobileqq.emotionintegrate.ChatHistoryEmotionAdapter;
import com.tencent.mobileqq.emotionintegrate.EmotionDataManager;
import com.tencent.mobileqq.emotionintegrate.EmotionPreviewData;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.multimsg.save.FileSaveDialog;
import com.tencent.mobileqq.multimsg.save.FileSaveReq;
import com.tencent.mobileqq.multimsg.save.MultiRichMediaSaveManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.startup.step.CheckPermission;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.weiyun.api.IWeiyunResponseHandler;
import com.tencent.mobileqq.weiyun.api.IWeiyunSaveTipsHelper;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.util.MqqWeakReferenceHandler;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class ChatHistoryEmotionBaseFragment
  extends ChatHistoryBaseFragment
  implements Handler.Callback, MsgRevokeListener, ChatHistoryEmotionView.OperateCallBack, IChatHistoryEmotionBaseFragment
{
  ChatHistoryEmotionView jdField_a_of_type_ComTencentMobileqqActivityChatHistoryEmotionView;
  private SeparateForward jdField_a_of_type_ComTencentMobileqqActivityChathistorySeparateForward;
  private EmoticonObserver jdField_a_of_type_ComTencentMobileqqAppEmoticonObserver = new ChatHistoryEmotionBaseFragment.4(this);
  private IEmoBatchAddedHandler jdField_a_of_type_ComTencentMobileqqEmosmFavroamingIEmoBatchAddedHandler;
  private List<EmotionPreviewData> jdField_a_of_type_JavaUtilList;
  protected final MqqHandler a;
  private QQCustomDialog jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  private List<URLDrawable> jdField_b_of_type_JavaUtilList = new ArrayList();
  
  public ChatHistoryEmotionBaseFragment()
  {
    this.jdField_a_of_type_MqqOsMqqHandler = new MqqWeakReferenceHandler(Looper.getMainLooper(), this, true);
  }
  
  private static void a(IPicEmoticonInfo paramIPicEmoticonInfo, Emoticon paramEmoticon, QQAppInterface paramQQAppInterface, IEmoBatchAddedCallback paramIEmoBatchAddedCallback)
  {
    ChatHistoryEmotionBaseFragment.EmoticonDetailJsonDownloader localEmoticonDetailJsonDownloader = new ChatHistoryEmotionBaseFragment.EmoticonDetailJsonDownloader(null);
    if ((paramIPicEmoticonInfo != null) && (paramEmoticon != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmoBatchAdded", 1, "startDownloadEmoticonJson");
      }
      localEmoticonDetailJsonDownloader.a(paramQQAppInterface, paramIPicEmoticonInfo, paramIEmoBatchAddedCallback);
      paramIPicEmoticonInfo = (IEmojiManagerService)paramQQAppInterface.getRuntimeService(IEmojiManagerService.class);
      paramIPicEmoticonInfo.getEmojiListenerManager().addEmotionJsonDownloadListener(localEmoticonDetailJsonDownloader);
      paramIPicEmoticonInfo.startDownloadEmosmJson(paramEmoticon.epId, EmojiManagerServiceConstant.JSON_EMOSM_MALL);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("EmoBatchAdded", 1, "error in json downloading");
    }
  }
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4, ChatHistoryFileActivity.OnWyDialogClick paramOnWyDialogClick)
  {
    QQCustomDialog localQQCustomDialog = this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog;
    if ((localQQCustomDialog != null) && (localQQCustomDialog.isShowing())) {
      this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
    }
    localQQCustomDialog = new QQCustomDialog(getBaseActivity(), 2131756189);
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
    this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.setNegativeButton(paramString1, new ChatHistoryEmotionBaseFragment.6(this, paramOnWyDialogClick));
    this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPositiveButton(paramString2, new ChatHistoryEmotionBaseFragment.7(this, paramOnWyDialogClick));
    this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.setCancelable(true);
    this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.setCanceledOnTouchOutside(false);
    this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
  }
  
  private static void a(List<EmotionPreviewData> paramList, QQAppInterface paramQQAppInterface, List<URLDrawable> paramList1, IEmoBatchAddedHandler paramIEmoBatchAddedHandler)
  {
    ThreadManagerV2.executeOnSubThread(new ChatHistoryEmotionBaseFragment.3(paramList, paramIEmoBatchAddedHandler, paramQQAppInterface, paramList1));
  }
  
  private static void b(QQAppInterface paramQQAppInterface, IEmoBatchAddedHandler paramIEmoBatchAddedHandler, EmotionPreviewData paramEmotionPreviewData, int paramInt, IEmoBatchAddedCallback paramIEmoBatchAddedCallback)
  {
    paramEmotionPreviewData = EmotionDataManager.a((MessageForMarketFace)paramEmotionPreviewData.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
    if (paramEmotionPreviewData == null)
    {
      paramIEmoBatchAddedHandler.b(3);
      return;
    }
    Emoticon localEmoticon = paramEmotionPreviewData.getEmoticon();
    if (localEmoticon == null)
    {
      paramIEmoBatchAddedHandler.b(3);
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(localEmoticon.epId);
    ((StringBuilder)localObject).append(localEmoticon.eId);
    localObject = ((StringBuilder)localObject).toString();
    if (paramIEmoBatchAddedHandler.a((String)localObject))
    {
      paramIEmoBatchAddedHandler.b(2);
      return;
    }
    paramIEmoBatchAddedHandler.a((String)localObject, Integer.valueOf(paramInt));
    paramIEmoBatchAddedHandler = ((IEmoticonManagerService)paramQQAppInterface.getRuntimeService(IEmoticonManagerService.class)).syncFindEmoticonPackageById(localEmoticon.epId, 0);
    if ((paramIEmoBatchAddedHandler != null) && (paramIEmoBatchAddedHandler.name != null) && ((paramIEmoBatchAddedHandler.mobileFeetype != 0) || (paramIEmoBatchAddedHandler.downloadCount != 0)))
    {
      paramInt = paramQQAppInterface.getPreferences().getInt("emosm_json_last_download_timestamp", 0);
      int i = (int)(System.currentTimeMillis() / 1000L);
      if ((i - paramInt <= 86400) && (i >= paramInt)) {
        MarketFaceItemBuilder.a(paramQQAppInterface, paramIEmoBatchAddedHandler, paramEmotionPreviewData, paramIEmoBatchAddedCallback);
      } else {
        a(paramEmotionPreviewData, localEmoticon, paramQQAppInterface, paramIEmoBatchAddedCallback);
      }
    }
    else
    {
      a(paramEmotionPreviewData, localEmoticon, paramQQAppInterface, paramIEmoBatchAddedCallback);
    }
    EmoticonOperateReport.reportFavAddEmotionEvent(paramQQAppInterface, 2, null, localEmoticon.eId);
  }
  
  private static void b(QQAppInterface paramQQAppInterface, IEmoBatchAddedHandler paramIEmoBatchAddedHandler, EmotionPreviewData paramEmotionPreviewData, int paramInt, IEmoBatchAddedCallback paramIEmoBatchAddedCallback, List<URLDrawable> paramList)
  {
    Object localObject = URLDrawableHelper.getURL((MessageForPic)paramEmotionPreviewData.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, 1);
    if (paramIEmoBatchAddedHandler.a(((URL)localObject).toString()))
    {
      paramIEmoBatchAddedHandler.b(2);
      return;
    }
    paramIEmoBatchAddedHandler.a(((URL)localObject).toString(), Integer.valueOf(paramInt));
    localObject = URLDrawableHelper.getDrawable((URL)localObject, -1, -1, null, null, false);
    ((URLDrawable)localObject).setTag(paramEmotionPreviewData.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
    paramList.add(localObject);
    paramInt = paramIEmoBatchAddedHandler.a(Integer.valueOf(paramInt));
    paramInt = AIOGalleryUtils.a(paramQQAppInterface, (URLDrawable)localObject, ((MessageForPic)paramEmotionPreviewData.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).picExtraData, paramIEmoBatchAddedCallback, paramInt);
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2) {
          return;
        }
        paramIEmoBatchAddedHandler.b(2);
        return;
      }
      paramIEmoBatchAddedHandler.b(3);
      return;
    }
    paramIEmoBatchAddedHandler.b(4);
  }
  
  public void a()
  {
    ChatHistoryEmotionView localChatHistoryEmotionView = this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryEmotionView;
    if ((localChatHistoryEmotionView != null) && (localChatHistoryEmotionView.jdField_a_of_type_ComTencentMobileqqEmotionintegrateChatHistoryEmotionAdapter != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryEmotionView.jdField_a_of_type_ComTencentMobileqqEmotionintegrateChatHistoryEmotionAdapter.getCount() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.history.BaseFragment", 2, "onEmotionLoaded, mEmotionView.mAdapter is null");
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryBaseViewController.a(false);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryBaseViewController.a(true);
  }
  
  public void a(long paramLong)
  {
    ChatHistoryEmotionView localChatHistoryEmotionView = this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryEmotionView;
    if (localChatHistoryEmotionView != null) {
      localChatHistoryEmotionView.a(paramLong);
    }
  }
  
  public void a(EmotionPreviewData paramEmotionPreviewData)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    this.jdField_a_of_type_JavaUtilList.add(paramEmotionPreviewData);
  }
  
  public void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    if (this.jdField_a_of_type_Boolean)
    {
      ChatHistoryEmotionView localChatHistoryEmotionView = this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryEmotionView;
      if ((localChatHistoryEmotionView != null) && (localChatHistoryEmotionView.a())) {
        this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryEmotionView.a();
      }
    }
  }
  
  public boolean a()
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    boolean bool = false;
    int i;
    if (localList != null) {
      i = localList.size() + 0;
    } else {
      i = 0;
    }
    if (i >= 20) {
      bool = true;
    }
    if (bool)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.history.BaseFragment", 2, "isOverLimit");
      }
      FMToastUtil.a(2131692438);
    }
    return bool;
  }
  
  protected void b() {}
  
  public void b(EmotionPreviewData paramEmotionPreviewData)
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    if (localList == null) {
      return;
    }
    localList.remove(paramEmotionPreviewData);
  }
  
  void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      u();
      ReportController.b(null, "dc00898", "", "", "0X800B720", "0X800B720", 0, 0, "", "", "", "");
      t();
      return;
    }
    changeToUnSelected();
  }
  
  protected int c()
  {
    return 1602;
  }
  
  protected void c() {}
  
  public void changeToUnSelected()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryEmotionView;
    if (localObject != null) {
      ((ChatHistoryEmotionView)localObject).f();
    }
    localObject = this.jdField_a_of_type_JavaUtilList;
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      localObject = this.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((EmotionPreviewData)((Iterator)localObject).next()).jdField_a_of_type_Boolean = false;
      }
      this.jdField_a_of_type_JavaUtilList.clear();
    }
    h();
  }
  
  public int d()
  {
    return getResources().getDimensionPixelSize(2131299168);
  }
  
  protected void d()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(1));
    localArrayList.add(Integer.valueOf(2));
    localArrayList.add(Integer.valueOf(4));
    localArrayList.add(Integer.valueOf(5));
    this.jdField_a_of_type_ComTencentMobileqqActivityHistoryWidgetChatHistorySelectBottomBar.a(localArrayList);
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryBaseViewController == null) {
      return;
    }
    super.e();
    changeToUnSelected();
    ChatHistoryEmotionView localChatHistoryEmotionView = this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryEmotionView;
    if (localChatHistoryEmotionView != null) {
      localChatHistoryEmotionView.b();
    }
    localChatHistoryEmotionView = this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryEmotionView;
    if ((localChatHistoryEmotionView != null) && (localChatHistoryEmotionView.jdField_a_of_type_ComTencentMobileqqEmotionintegrateChatHistoryEmotionAdapter != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryEmotionView.jdField_a_of_type_ComTencentMobileqqEmotionintegrateChatHistoryEmotionAdapter.getCount() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.history.BaseFragment", 2, "doOnResume, mEmotionView.mAdapter is null");
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryBaseViewController.a(false);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryBaseViewController.a(true);
  }
  
  public void g()
  {
    super.g();
    AIOGalleryMsgRevokeMgr.a().b(this);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryEmotionView;
    if (localObject != null) {
      ((ChatHistoryEmotionView)localObject).d();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityChathistorySeparateForward;
    if (localObject != null) {
      ((SeparateForward)localObject).b();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppEmoticonObserver);
    if (!this.jdField_b_of_type_JavaUtilList.isEmpty())
    {
      localObject = this.jdField_b_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((URLDrawable)((Iterator)localObject).next()).setTag(null);
      }
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
        if (this.jdField_a_of_type_AndroidAppDialog != null) {
          this.jdField_a_of_type_AndroidAppDialog.dismiss();
        }
        changeToUnSelected();
        return true;
      case 101: 
        if (this.jdField_a_of_type_AndroidAppDialog != null) {
          this.jdField_a_of_type_AndroidAppDialog.dismiss();
        }
        changeToUnSelected();
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
          ChatHistoryEmotionBaseFragment.5 local5 = new ChatHistoryEmotionBaseFragment.5(this);
          a(getString(2131698736), paramMessage, null, null, local5);
          return true;
        }
        paramMessage = (String)paramMessage.obj;
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), paramMessage, 1).b(d());
        return true;
      case 100: 
        if (this.jdField_a_of_type_AndroidAppDialog != null) {
          this.jdField_a_of_type_AndroidAppDialog.dismiss();
        }
        ((IWeiyunSaveTipsHelper)QRoute.api(IWeiyunSaveTipsHelper.class)).showTopTips(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getBaseActivity(), d());
        changeToUnSelected();
        return true;
      }
    }
    else
    {
      paramMessage = this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryEmotionView;
      if (paramMessage != null) {
        paramMessage.g();
      }
      changeToUnSelected();
      q();
    }
    return true;
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
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = this.jdField_a_of_type_JavaUtilList;
    if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
    {
      localObject1 = this.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (EmotionPreviewData)((Iterator)localObject1).next();
        if ((((EmotionPreviewData)localObject2).jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForPic)) {
          localArrayList.add(FileSaveReq.a((MessageForPic)((EmotionPreviewData)localObject2).jdField_a_of_type_ComTencentMobileqqDataMessageRecord));
        }
      }
      ReportController.b(null, "dc00898", "", "", "0X800B722", "0X800B722", this.jdField_a_of_type_JavaUtilList.size(), 0, "", "", "", "");
      localObject1 = new FileSaveDialog(getBaseActivity());
      Object localObject2 = (MultiRichMediaSaveManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MULTI_CHOOSE_SAVE_MANAGER);
      ((MultiRichMediaSaveManager)localObject2).a(new ChatHistoryEmotionBaseFragment.1(this, (FileSaveDialog)localObject1, (MultiRichMediaSaveManager)localObject2, localArrayList));
      ((MultiRichMediaSaveManager)localObject2).a(localArrayList, true);
      ((MultiRichMediaSaveManager)localObject2).a(localArrayList, 1, 5);
      s();
      return;
    }
    FMToastUtil.c(2131692435);
  }
  
  protected void m()
  {
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      QQToast.a(getBaseActivity(), 2131694475, 1).b(getResources().getDimensionPixelSize(2131299168));
      return;
    }
    Object localObject = this.jdField_a_of_type_JavaUtilList;
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      ReportController.b(null, "dc00898", "", "", "0X800B721", "0X800B721", this.jdField_a_of_type_JavaUtilList.size(), 0, "", "", "", "");
      localObject = new ArrayList();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((List)localObject).add((ChatMessage)((EmotionPreviewData)localIterator.next()).jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityChathistorySeparateForward == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityChathistorySeparateForward = new SeparateForward(getBaseActivity(), 3);
        this.jdField_a_of_type_ComTencentMobileqqActivityChathistorySeparateForward.a();
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityChathistorySeparateForward.a((List)localObject);
      r();
      return;
    }
    FMToastUtil.c(2131692435);
  }
  
  protected void n()
  {
    Object localObject = this.jdField_a_of_type_JavaUtilList;
    int i;
    if (localObject != null) {
      i = 0 + ((List)localObject).size();
    } else {
      i = 0;
    }
    if (i == 0)
    {
      FMToastUtil.c(2131692435);
      return;
    }
    ReportController.b(null, "dc00898", "", "", "0X800B723", "0X800B723", i, 0, "", "", "", "");
    localObject = (ActionSheet)ActionSheetHelper.a(getBaseActivity(), null);
    ((ActionSheet)localObject).setMainTitle(2131696093);
    ((ActionSheet)localObject).addButton(getBaseActivity().getString(2131692273), 3);
    ((ActionSheet)localObject).addCancelButton(2131690728);
    ((ActionSheet)localObject).setOnButtonClickListener(new ChatHistoryEmotionBaseFragment.2(this, (ActionSheet)localObject));
    ((ActionSheet)localObject).show();
  }
  
  protected void o()
  {
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      QQToast.a(getBaseActivity(), 2131694475, 1).b(getResources().getDimensionPixelSize(2131299168));
      return;
    }
    a(this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_JavaUtilList, this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingIEmoBatchAddedHandler);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    AIOGalleryMsgRevokeMgr.a().a(this);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryEmotionView == null) && (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryEmotionView = new ChatHistoryEmotionView();
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryEmotionView.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryEmotionView.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryEmotionView$OperateCallBack = this;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppEmoticonObserver);
    }
    this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingIEmoBatchAddedHandler = ((IEmoBatchAddedHandlerApi)QRoute.api(IEmoBatchAddedHandlerApi.class)).createEmoBatchAddedHandler(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    paramLayoutInflater = this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryEmotionView.a();
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onPause()
  {
    super.onPause();
    ChatHistoryEmotionView localChatHistoryEmotionView = this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryEmotionView;
    if (localChatHistoryEmotionView != null) {
      localChatHistoryEmotionView.c();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    ChatHistoryEmotionView localChatHistoryEmotionView = this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryEmotionView;
    if (localChatHistoryEmotionView != null) {
      localChatHistoryEmotionView.b();
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqActivityHistoryWidgetChatHistorySelectBottomBar.a(2130839261);
  }
  
  void q() {}
  
  void r() {}
  
  void s() {}
  
  void t() {}
  
  protected void u()
  {
    ChatHistoryEmotionView localChatHistoryEmotionView = this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryEmotionView;
    if (localChatHistoryEmotionView != null) {
      localChatHistoryEmotionView.e();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryEmotionBaseFragment
 * JD-Core Version:    0.7.0.1
 */