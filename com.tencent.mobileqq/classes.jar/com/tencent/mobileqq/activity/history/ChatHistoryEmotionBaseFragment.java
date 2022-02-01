package com.tencent.mobileqq.activity.history;

import android.app.Dialog;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.ChatHistoryEmotionView;
import com.tencent.mobileqq.activity.ChatHistoryEmotionView.OperateCallBack;
import com.tencent.mobileqq.activity.ChatHistoryFileActivity.OnWyDialogClick;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryMsgRevokeMgr;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryMsgRevokeMgr.MsgRevokeListener;
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
import com.tencent.mobileqq.emosm.favroaming.EmoBatchAddedCallback;
import com.tencent.mobileqq.emosm.favroaming.EmoBatchAddedHandler;
import com.tencent.mobileqq.emoticon.EmojiListenerManager;
import com.tencent.mobileqq.emoticon.EmojiManager;
import com.tencent.mobileqq.emoticonview.EmoticonUtils;
import com.tencent.mobileqq.emoticonview.PicEmoticonInfo;
import com.tencent.mobileqq.emotionintegrate.ChatHistoryEmotionAdapter;
import com.tencent.mobileqq.emotionintegrate.EmotionDataManager;
import com.tencent.mobileqq.emotionintegrate.EmotionPreviewData;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.multimsg.save.FileSaveDialog;
import com.tencent.mobileqq.multimsg.save.FileSaveReq;
import com.tencent.mobileqq.multimsg.save.MultiRichMediaSaveManager;
import com.tencent.mobileqq.startup.step.CheckPermission;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.util.MqqWeakReferenceHandler;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import cooperation.weiyun.ResponseHandler;
import cooperation.weiyun.WeiyunSaveTipsFactory;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class ChatHistoryEmotionBaseFragment
  extends ChatHistoryBaseFragment
  implements Handler.Callback, ChatHistoryEmotionView.OperateCallBack, AIOGalleryMsgRevokeMgr.MsgRevokeListener
{
  ChatHistoryEmotionView jdField_a_of_type_ComTencentMobileqqActivityChatHistoryEmotionView;
  private SeparateForward jdField_a_of_type_ComTencentMobileqqActivityChathistorySeparateForward;
  private EmoticonObserver jdField_a_of_type_ComTencentMobileqqAppEmoticonObserver = new ChatHistoryEmotionBaseFragment.4(this);
  private EmoBatchAddedHandler jdField_a_of_type_ComTencentMobileqqEmosmFavroamingEmoBatchAddedHandler;
  private List<EmotionPreviewData> jdField_a_of_type_JavaUtilList;
  protected final MqqHandler a;
  private QQCustomDialog jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  private List<URLDrawable> jdField_b_of_type_JavaUtilList = new ArrayList();
  
  public ChatHistoryEmotionBaseFragment()
  {
    this.jdField_a_of_type_MqqOsMqqHandler = new MqqWeakReferenceHandler(Looper.getMainLooper(), this, true);
  }
  
  private static void a(PicEmoticonInfo paramPicEmoticonInfo, Emoticon paramEmoticon, QQAppInterface paramQQAppInterface, EmoBatchAddedCallback paramEmoBatchAddedCallback)
  {
    ChatHistoryEmotionBaseFragment.EmoticonDetailJsonDownloader localEmoticonDetailJsonDownloader = new ChatHistoryEmotionBaseFragment.EmoticonDetailJsonDownloader(null);
    if ((paramPicEmoticonInfo == null) || (paramEmoticon == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmoBatchAdded", 1, "error in json downloading");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("EmoBatchAdded", 1, "startDownloadEmoticonJson");
    }
    localEmoticonDetailJsonDownloader.a(paramQQAppInterface, paramPicEmoticonInfo, paramEmoBatchAddedCallback);
    EmojiListenerManager.a().a(localEmoticonDetailJsonDownloader);
    ((EmojiManager)paramQQAppInterface.getManager(QQManagerFactory.CHAT_EMOTION_MANAGER)).a(paramEmoticon.epId, EmojiManager.c);
  }
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4, ChatHistoryFileActivity.OnWyDialogClick paramOnWyDialogClick)
  {
    if ((this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing())) {
      this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
    }
    QQCustomDialog localQQCustomDialog = new QQCustomDialog(getActivity(), 2131755842);
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
    this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.setNegativeButton(paramString1, new ChatHistoryEmotionBaseFragment.6(this, paramOnWyDialogClick));
    this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPositiveButton(paramString2, new ChatHistoryEmotionBaseFragment.7(this, paramOnWyDialogClick));
    this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.setCancelable(true);
    this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.setCanceledOnTouchOutside(false);
    this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
  }
  
  private static void a(List<EmotionPreviewData> paramList, QQAppInterface paramQQAppInterface, List<URLDrawable> paramList1, EmoBatchAddedHandler paramEmoBatchAddedHandler)
  {
    ThreadManagerV2.executeOnSubThread(new ChatHistoryEmotionBaseFragment.3(paramList, paramEmoBatchAddedHandler, paramQQAppInterface, paramList1));
  }
  
  private static void b(QQAppInterface paramQQAppInterface, EmoBatchAddedHandler paramEmoBatchAddedHandler, EmotionPreviewData paramEmotionPreviewData, int paramInt, EmoBatchAddedCallback paramEmoBatchAddedCallback)
  {
    paramEmotionPreviewData = EmotionDataManager.a((MessageForMarketFace)paramEmotionPreviewData.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
    if (paramEmotionPreviewData == null)
    {
      paramEmoBatchAddedHandler.b(3);
      return;
    }
    Emoticon localEmoticon = paramEmotionPreviewData.emoticon;
    if (localEmoticon == null)
    {
      paramEmoBatchAddedHandler.b(3);
      return;
    }
    String str = localEmoticon.epId + localEmoticon.eId;
    if (paramEmoBatchAddedHandler.a(str))
    {
      paramEmoBatchAddedHandler.b(2);
      return;
    }
    paramEmoBatchAddedHandler.a(str, Integer.valueOf(paramInt));
    paramEmoBatchAddedHandler = ((EmoticonManager)paramQQAppInterface.getManager(QQManagerFactory.EMOTICON_MANAGER)).a(localEmoticon.epId, 0);
    if ((paramEmoBatchAddedHandler != null) && (paramEmoBatchAddedHandler.name != null) && ((paramEmoBatchAddedHandler.mobileFeetype != 0) || (paramEmoBatchAddedHandler.downloadCount != 0)))
    {
      paramInt = paramQQAppInterface.getPreferences().getInt("emosm_json_last_download_timestamp", 0);
      int i = (int)(System.currentTimeMillis() / 1000L);
      if ((i - paramInt > 86400) || (i < paramInt)) {
        a(paramEmotionPreviewData, localEmoticon, paramQQAppInterface, paramEmoBatchAddedCallback);
      }
    }
    for (;;)
    {
      EmoticonUtils.reportFavAddEmotionEvent(paramQQAppInterface, 2, null, localEmoticon.eId);
      return;
      MarketFaceItemBuilder.a(paramQQAppInterface, paramEmoBatchAddedHandler, paramEmotionPreviewData, paramEmoBatchAddedCallback);
      continue;
      a(paramEmotionPreviewData, localEmoticon, paramQQAppInterface, paramEmoBatchAddedCallback);
    }
  }
  
  private static void b(QQAppInterface paramQQAppInterface, EmoBatchAddedHandler paramEmoBatchAddedHandler, EmotionPreviewData paramEmotionPreviewData, int paramInt, EmoBatchAddedCallback paramEmoBatchAddedCallback, List<URLDrawable> paramList)
  {
    Object localObject = URLDrawableHelper.getURL((MessageForPic)paramEmotionPreviewData.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, 1);
    if (paramEmoBatchAddedHandler.a(((URL)localObject).toString()))
    {
      paramEmoBatchAddedHandler.b(2);
      return;
    }
    paramEmoBatchAddedHandler.a(((URL)localObject).toString(), Integer.valueOf(paramInt));
    localObject = URLDrawableHelper.getDrawable((URL)localObject, -1, -1, null, null, false);
    ((URLDrawable)localObject).setTag(paramEmotionPreviewData.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
    paramList.add(localObject);
    paramInt = paramEmoBatchAddedHandler.a(Integer.valueOf(paramInt));
    switch (AIOGalleryUtils.a(paramQQAppInterface, (URLDrawable)localObject, ((MessageForPic)paramEmotionPreviewData.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).picExtraData, paramEmoBatchAddedCallback, paramInt))
    {
    default: 
      return;
    case 0: 
      paramEmoBatchAddedHandler.b(4);
      return;
    case 2: 
      paramEmoBatchAddedHandler.b(2);
      return;
    }
    paramEmoBatchAddedHandler.b(3);
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryEmotionView != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryEmotionView.jdField_a_of_type_ComTencentMobileqqEmotionintegrateChatHistoryEmotionAdapter != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryEmotionView.jdField_a_of_type_ComTencentMobileqqEmotionintegrateChatHistoryEmotionAdapter.getCount() == 0))
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
    if (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryEmotionView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryEmotionView.a(paramLong);
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
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryEmotionView != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryEmotionView.a())) {
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryEmotionView.a();
    }
  }
  
  public boolean a()
  {
    boolean bool = false;
    if (this.jdField_a_of_type_JavaUtilList != null) {}
    for (int i = this.jdField_a_of_type_JavaUtilList.size() + 0;; i = 0)
    {
      if (i >= 20) {
        bool = true;
      }
      if (bool)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.history.BaseFragment", 2, "isOverLimit");
        }
        FMToastUtil.a(2131692502);
      }
      return bool;
    }
  }
  
  protected void b() {}
  
  public void b(EmotionPreviewData paramEmotionPreviewData)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilList.remove(paramEmotionPreviewData);
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
    v();
  }
  
  protected int c()
  {
    return 1602;
  }
  
  protected void c() {}
  
  public int d()
  {
    return getResources().getDimensionPixelSize(2131299166);
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
    v();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryEmotionView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryEmotionView.b();
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryEmotionView != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryEmotionView.jdField_a_of_type_ComTencentMobileqqEmotionintegrateChatHistoryEmotionAdapter != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryEmotionView.jdField_a_of_type_ComTencentMobileqqEmotionintegrateChatHistoryEmotionAdapter.getCount() == 0))
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
    if (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryEmotionView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryEmotionView.d();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityChathistorySeparateForward != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityChathistorySeparateForward.b();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppEmoticonObserver);
    if (!this.jdField_b_of_type_JavaUtilList.isEmpty())
    {
      Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((URLDrawable)localIterator.next()).setTag(null);
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    int i;
    do
    {
      return true;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryEmotionView != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryEmotionView.g();
      }
      v();
      q();
      return true;
      if (this.jdField_a_of_type_AndroidAppDialog != null) {
        this.jdField_a_of_type_AndroidAppDialog.dismiss();
      }
      v();
      return true;
      if (this.jdField_a_of_type_AndroidAppDialog != null) {
        this.jdField_a_of_type_AndroidAppDialog.dismiss();
      }
      WeiyunSaveTipsFactory.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getActivity(), d());
      v();
      return true;
      if (this.jdField_a_of_type_AndroidAppDialog != null) {
        this.jdField_a_of_type_AndroidAppDialog.dismiss();
      }
      v();
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
        ChatHistoryEmotionBaseFragment.5 local5 = new ChatHistoryEmotionBaseFragment.5(this);
        a(getString(2131698667), paramMessage, null, null, local5);
        return true;
        if (ResponseHandler.c(i))
        {
          getString(2131694689);
          paramMessage = getString(2131692147);
        }
      }
    }
    paramMessage = (String)paramMessage.obj;
    QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), paramMessage, 1).b(d());
    return true;
  }
  
  protected void k()
  {
    if (!CheckPermission.isHasStoragePermission(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity))
    {
      CheckPermission.requestStorePermission(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, null);
      return;
    }
    if (!NetworkUtil.d(BaseApplication.getContext()))
    {
      QQToast.a(getActivity(), 2131694510, 1).b(getResources().getDimensionPixelSize(2131299166));
      return;
    }
    ArrayList localArrayList = new ArrayList();
    if ((this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty()))
    {
      Object localObject1 = this.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (EmotionPreviewData)((Iterator)localObject1).next();
        if ((((EmotionPreviewData)localObject2).jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForPic)) {
          localArrayList.add(FileSaveReq.a((MessageForPic)((EmotionPreviewData)localObject2).jdField_a_of_type_ComTencentMobileqqDataMessageRecord));
        }
      }
      ReportController.b(null, "dc00898", "", "", "0X800B722", "0X800B722", this.jdField_a_of_type_JavaUtilList.size(), 0, "", "", "", "");
      localObject1 = new FileSaveDialog(getActivity());
      Object localObject2 = (MultiRichMediaSaveManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MULTI_CHOOSE_SAVE_MANAGER);
      ((MultiRichMediaSaveManager)localObject2).a(new ChatHistoryEmotionBaseFragment.1(this, (FileSaveDialog)localObject1, (MultiRichMediaSaveManager)localObject2, localArrayList));
      ((MultiRichMediaSaveManager)localObject2).a(localArrayList, true);
      ((MultiRichMediaSaveManager)localObject2).a(localArrayList, 1, 5);
      s();
      return;
    }
    FMToastUtil.c(2131692499);
  }
  
  protected void m()
  {
    if (!NetworkUtil.d(BaseApplication.getContext()))
    {
      QQToast.a(getActivity(), 2131694510, 1).b(getResources().getDimensionPixelSize(2131299166));
      return;
    }
    if ((this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty()))
    {
      ReportController.b(null, "dc00898", "", "", "0X800B721", "0X800B721", this.jdField_a_of_type_JavaUtilList.size(), 0, "", "", "", "");
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add((ChatMessage)((EmotionPreviewData)localIterator.next()).jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityChathistorySeparateForward == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityChathistorySeparateForward = new SeparateForward(getActivity(), 3);
        this.jdField_a_of_type_ComTencentMobileqqActivityChathistorySeparateForward.a();
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityChathistorySeparateForward.a(localArrayList);
      r();
      return;
    }
    FMToastUtil.c(2131692499);
  }
  
  protected void n()
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {}
    for (int i = 0 + this.jdField_a_of_type_JavaUtilList.size();; i = 0)
    {
      if (i == 0)
      {
        FMToastUtil.c(2131692499);
        return;
      }
      ReportController.b(null, "dc00898", "", "", "0X800B723", "0X800B723", i, 0, "", "", "", "");
      ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(getActivity(), null);
      localActionSheet.setMainTitle(2131696078);
      localActionSheet.addButton(getActivity().getString(2131692345), 3);
      localActionSheet.addCancelButton(2131690800);
      localActionSheet.setOnButtonClickListener(new ChatHistoryEmotionBaseFragment.2(this, localActionSheet));
      localActionSheet.show();
      return;
    }
  }
  
  protected void o()
  {
    if (!NetworkUtil.d(BaseApplication.getContext()))
    {
      QQToast.a(getActivity(), 2131694510, 1).b(getResources().getDimensionPixelSize(2131299166));
      return;
    }
    a(this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_JavaUtilList, this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingEmoBatchAddedHandler);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    AIOGalleryMsgRevokeMgr.a().a(this);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryEmotionView == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryEmotionView = new ChatHistoryEmotionView();
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryEmotionView.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryEmotionView.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryEmotionView$OperateCallBack = this;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppEmoticonObserver);
    this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingEmoBatchAddedHandler = new EmoBatchAddedHandler(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    paramLayoutInflater = this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryEmotionView.a();
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryEmotionView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryEmotionView.c();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryEmotionView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryEmotionView.b();
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqActivityHistoryWidgetChatHistorySelectBottomBar.a(2130839405);
  }
  
  void q() {}
  
  void r() {}
  
  void s() {}
  
  void t() {}
  
  protected void u()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryEmotionView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryEmotionView.e();
    }
  }
  
  public void v()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryEmotionView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryEmotionView.f();
    }
    if ((this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty()))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((EmotionPreviewData)localIterator.next()).jdField_a_of_type_Boolean = false;
      }
      this.jdField_a_of_type_JavaUtilList.clear();
    }
    h();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryEmotionBaseFragment
 * JD-Core Version:    0.7.0.1
 */