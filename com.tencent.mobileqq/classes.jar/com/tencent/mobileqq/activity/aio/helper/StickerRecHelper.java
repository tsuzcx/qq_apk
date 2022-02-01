package com.tencent.mobileqq.activity.aio.helper;

import android.content.Context;
import android.graphics.Color;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.Editable;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.helper.CoreHelperProvider;
import com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecBarAdapter;
import com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecBarAdapter.ImgUpdateListener;
import com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecManager;
import com.tencent.mobileqq.activity.aio.stickerrecommended.scenesrecommend.ScenesRecommendItem;
import com.tencent.mobileqq.activity.aio.stickerrecommended.scenesrecommend.ScenesRecommendManager;
import com.tencent.mobileqq.activity.aio.stickerrecommended.scenesrecommend.ScenesRecommendManager.IScenesRecEmoUIHelper;
import com.tencent.mobileqq.apollo.ChatPieApolloViewController;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.doutu.DoutuManager;
import com.tencent.mobileqq.emosm.AIOEmoticonUIHelper;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.emoticonview.EmotionKeywordAdapter;
import com.tencent.mobileqq.emoticonview.EmotionKeywordHorizonListView;
import com.tencent.mobileqq.emoticonview.EmotionKeywordLayout;
import com.tencent.mobileqq.theme.ThemeUtil;
import mqq.os.MqqHandler;

public class StickerRecHelper
  implements Handler.Callback, ILifeCycleHelper, ScenesRecommendManager.IScenesRecEmoUIHelper
{
  private long jdField_a_of_type_Long;
  private Context jdField_a_of_type_AndroidContentContext;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private StickerRecBarAdapter jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedStickerRecBarAdapter;
  private StickerRecManager jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedStickerRecManager;
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  private boolean jdField_a_of_type_Boolean = false;
  private long b;
  private long c;
  
  public StickerRecHelper(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramBaseChatPie.jdField_a_of_type_AndroidContentContext;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
    this.jdField_a_of_type_MqqOsMqqHandler = paramBaseChatPie.a();
    paramBaseChatPie.b().a().a(this);
  }
  
  private EmotionKeywordAdapter a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) {
      return null;
    }
    AIOEmoticonUIHelper localAIOEmoticonUIHelper = (AIOEmoticonUIHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(105);
    if (localAIOEmoticonUIHelper != null) {
      return localAIOEmoticonUIHelper.a();
    }
    return null;
  }
  
  private EmotionKeywordLayout a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) {
      return null;
    }
    AIOEmoticonUIHelper localAIOEmoticonUIHelper = (AIOEmoticonUIHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(105);
    if (localAIOEmoticonUIHelper != null) {
      return localAIOEmoticonUIHelper.a();
    }
    return null;
  }
  
  public EmotionKeywordHorizonListView a(EditText paramEditText)
  {
    EmotionKeywordLayout localEmotionKeywordLayout = a();
    if (localEmotionKeywordLayout == null) {
      return null;
    }
    localEmotionKeywordLayout.setEnableAnim(true);
    LinearLayout localLinearLayout = (LinearLayout)localEmotionKeywordLayout.findViewById(2131366261);
    EmotionKeywordHorizonListView localEmotionKeywordHorizonListView = (EmotionKeywordHorizonListView)localEmotionKeywordLayout.findViewById(2131366290);
    TextView localTextView = (TextView)localEmotionKeywordLayout.findViewById(2131366260);
    if (ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null))
    {
      localEmotionKeywordLayout.setBackgroundColor(Color.parseColor("#1F1F1F"));
      localEmotionKeywordHorizonListView.setBackgroundColor(Color.parseColor("#1F1F1F"));
      localLinearLayout.setBackgroundColor(Color.parseColor("#1F1F1F"));
      localTextView.setTextColor(Color.parseColor("#8D8D93"));
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedStickerRecBarAdapter = new StickerRecBarAdapter(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramEditText, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie, localEmotionKeywordHorizonListView);
    localEmotionKeywordHorizonListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedStickerRecBarAdapter);
    localEmotionKeywordHorizonListView.setPadding(0, 0, 0, 0);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedStickerRecManager == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedStickerRecManager = StickerRecManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedStickerRecManager.a(new StickerRecBarAdapter.ImgUpdateListener(this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedStickerRecBarAdapter));
    localEmotionKeywordLayout.setOnVisibilityListener(new StickerRecHelper.2(this));
    ScenesRecommendManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this);
    return localEmotionKeywordHorizonListView;
  }
  
  public void a()
  {
    this.b = System.currentTimeMillis();
  }
  
  public void a(Editable paramEditable)
  {
    if ((a() == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedStickerRecBarAdapter == null)) {
      return;
    }
    int i = StickerRecManager.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), 6);
    paramEditable = paramEditable.toString();
    String str = ((SpecWordEmotionThinkHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(41)).a();
    if (!TextUtils.isEmpty(str)) {
      paramEditable = str;
    }
    for (;;)
    {
      if (i >= paramEditable.length()) {
        this.jdField_a_of_type_Long = System.currentTimeMillis();
      }
      for (boolean bool = this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedStickerRecManager.a(paramEditable, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);; bool = false)
      {
        long l = System.currentTimeMillis() - this.b - 3000L;
        if (bool) {
          break;
        }
        if (l > 0L)
        {
          f();
          return;
        }
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(67, -l);
        return;
      }
    }
  }
  
  public void a(ScenesRecommendItem paramScenesRecommendItem)
  {
    QLog.i("ScenesRecommendManager", 0, "handleScenesRec  start");
    if (!b()) {
      QLog.i("ScenesRecommendManager", 0, "handleScenesRec  isEmotionRecSettingOpen = false");
    }
    while ((a() == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedStickerRecBarAdapter == null) || (paramScenesRecommendItem == null)) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedStickerRecManager == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedStickerRecManager = StickerRecManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedStickerRecManager.a(paramScenesRecommendItem, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
  }
  
  public boolean a()
  {
    return StickerRecManager.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), false);
  }
  
  public boolean a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) {
      return false;
    }
    String str = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    QLog.i("ScenesRecommendManager", 0, "checkUinIsCurrentChat  uin = " + paramString + " | curUin = " + str);
    return str.equalsIgnoreCase(paramString);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedStickerRecBarAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedStickerRecBarAdapter.b();
    }
    this.c = System.currentTimeMillis();
    this.jdField_a_of_type_Boolean = true;
    ((SpecWordEmotionThinkHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(41)).b();
  }
  
  public void b(Editable paramEditable)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedStickerRecManager == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedStickerRecManager = StickerRecManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    if (paramEditable.length() == 0) {
      f();
    }
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedStickerRecManager == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedStickerRecManager = StickerRecManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedStickerRecManager.b();
  }
  
  public void c()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  void d()
  {
    BaseChatPie localBaseChatPie = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
    EmotionKeywordLayout localEmotionKeywordLayout = a();
    EmotionKeywordAdapter localEmotionKeywordAdapter = a();
    if (localEmotionKeywordLayout != null)
    {
      localEmotionKeywordLayout.hide();
      if (localBaseChatPie != null) {
        localBaseChatPie.a().removeMessages(67);
      }
    }
    f();
    if (localEmotionKeywordAdapter != null) {
      localEmotionKeywordAdapter.reportExposeData();
    }
    b();
  }
  
  public void e()
  {
    EmotionKeywordLayout localEmotionKeywordLayout = a();
    EmotionKeywordAdapter localEmotionKeywordAdapter = a();
    boolean bool = a();
    if ((localEmotionKeywordLayout != null) && (localEmotionKeywordLayout.getVisibility() == 0) && (!bool))
    {
      localEmotionKeywordLayout.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().removeMessages(67);
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqApolloChatPieApolloViewController != null) && (!this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.y())) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqApolloChatPieApolloViewController.a(true);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.ar();
      if (localEmotionKeywordAdapter != null) {
        localEmotionKeywordAdapter.reportExposeData();
      }
    }
  }
  
  public void f()
  {
    AIOEmoticonUIHelper localAIOEmoticonUIHelper = (AIOEmoticonUIHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(105);
    if (localAIOEmoticonUIHelper != null)
    {
      localAIOEmoticonUIHelper.d();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().removeMessages(67);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqApolloChatPieApolloViewController != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqApolloChatPieApolloViewController.a(true);
    }
  }
  
  public String getTag()
  {
    return getClass().getName();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    EmotionKeywordLayout localEmotionKeywordLayout = a();
    BaseChatPie localBaseChatPie = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 67: 
      d();
      return true;
    case 92: 
      if ((localEmotionKeywordLayout != null) && (localEmotionKeywordLayout.getVisibility() == 0))
      {
        localEmotionKeywordLayout.hide();
        if (localBaseChatPie != null) {
          localBaseChatPie.a().removeMessages(67);
        }
        if (localBaseChatPie.jdField_a_of_type_ComTencentMobileqqApolloChatPieApolloViewController != null) {
          localBaseChatPie.jdField_a_of_type_ComTencentMobileqqApolloChatPieApolloViewController.a(true);
        }
        localBaseChatPie.ar();
      }
      return true;
    }
    String str = null;
    if ((paramMessage.obj instanceof String)) {
      str = (String)paramMessage.obj;
    }
    if (localBaseChatPie != null)
    {
      if (localEmotionKeywordLayout != null) {
        localEmotionKeywordLayout.show(str);
      }
      if (localBaseChatPie.jdField_a_of_type_ComTencentMobileqqApolloChatPieApolloViewController != null) {
        localBaseChatPie.jdField_a_of_type_ComTencentMobileqqApolloChatPieApolloViewController.a(false);
      }
      paramMessage = (DoutuManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.DOUTU_MAGAGER);
      if (paramMessage != null) {
        paramMessage.b(localBaseChatPie.a());
      }
      localBaseChatPie.as();
      EmojiStickerManager.a().c(localBaseChatPie);
      localBaseChatPie.a().removeMessages(67);
      localBaseChatPie.a().sendEmptyMessageDelayed(67, 6000L);
      a();
    }
    return true;
  }
  
  public int[] interestedIn()
  {
    return new int[] { 14, 8, 6 };
  }
  
  public void onMoveToState(int paramInt)
  {
    switch (paramInt)
    {
    }
    StickerRecManager localStickerRecManager;
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedStickerRecManager != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedStickerRecManager.a(null);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedStickerRecBarAdapter != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedStickerRecBarAdapter.b();
      }
      ScenesRecommendManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(null);
      return;
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedStickerRecManager != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedStickerRecBarAdapter != null)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedStickerRecManager.a(new StickerRecBarAdapter.ImgUpdateListener(this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerrecommendedStickerRecBarAdapter));
      }
      ScenesRecommendManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this);
      return;
      localStickerRecManager = StickerRecManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    } while ((localStickerRecManager.a()) || (!StickerRecManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), false)));
    ThreadManager.executeOnSubThread(new StickerRecHelper.1(this, localStickerRecManager));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.StickerRecHelper
 * JD-Core Version:    0.7.0.1
 */