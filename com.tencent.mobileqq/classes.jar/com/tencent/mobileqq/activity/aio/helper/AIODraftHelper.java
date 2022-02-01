package com.tencent.mobileqq.activity.aio.helper;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.text.Editable;
import android.text.Spanned;
import android.text.TextUtils;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.BaseTroopChatPie;
import com.tencent.mobileqq.activity.aio.core.DiscussChatPie;
import com.tencent.mobileqq.activity.aio.core.FriendChatPie;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.activity.aio.core.input.AIOInput;
import com.tencent.mobileqq.activity.aio.coreui.input.EditTextUI;
import com.tencent.mobileqq.activity.aio.coreui.input.InputUIContainer;
import com.tencent.mobileqq.activity.aio.rebuild.ConfessChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.GameRoomChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.GetTextDraftJob;
import com.tencent.mobileqq.activity.aio.rebuild.HotChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.SaveTextDraftJob;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.DraftTextInfo;
import com.tencent.mobileqq.data.MessageForReplyText.SourceMsgInfo;
import com.tencent.mobileqq.flashchat.RichTextChatManager;
import com.tencent.mobileqq.richstatus.topic.TopicReplyUtil;
import com.tencent.mobileqq.troop.text.AtTroopMemberSpan;
import com.tencent.mobileqq.troop.text.ReplyClickMovementMethod;
import com.tencent.mobileqq.troop.text.ReplyedMessageSpan;
import com.tencent.mobileqq.vas.ColorNickManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XEditTextEx;
import java.util.ArrayList;
import mqq.os.MqqHandler;

public class AIODraftHelper
  implements ILifeCycleHelper
{
  public View.OnClickListener a;
  private AIOContext jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public String a;
  protected boolean a;
  public boolean b = false;
  
  public AIODraftHelper(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new AIODraftHelper.2(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext = paramBaseChatPie.b();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a();
  }
  
  protected void a()
  {
    BaseChatPie localBaseChatPie = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
    if (((localBaseChatPie instanceof FriendChatPie)) || ((localBaseChatPie instanceof DiscussChatPie)) || ((localBaseChatPie instanceof TroopChatPie))) {
      ((AIOInputRightHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(117)).a();
    }
  }
  
  protected void a(BaseSessionInfo paramBaseSessionInfo, Spanned paramSpanned, QQAppInterface paramQQAppInterface, String paramString1, MessageForReplyText.SourceMsgInfo paramSourceMsgInfo, String paramString2)
  {
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a().a();
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
    if (((localObject1 instanceof HotChatPie)) && (!((HotChatPie)localObject1).a.b(paramBaseSessionInfo.jdField_a_of_type_JavaLangString))) {
      return;
    }
    Object localObject3;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie instanceof BaseTroopChatPie))
    {
      localObject3 = new ArrayList();
      if (paramBaseSessionInfo.jdField_a_of_type_Int == 1) {
        paramSpanned = AtTroopMemberSpan.a(((EditTextUI)localObject2).b(), (ArrayList)localObject3);
      }
      localObject1 = paramSpanned;
      if (((ArrayList)localObject3).size() > 0)
      {
        paramString2 = AtTroopMemberSpan.a((ArrayList)localObject3);
        break label116;
      }
    }
    else
    {
      localObject1 = paramSpanned;
    }
    paramSpanned = (Spanned)localObject1;
    label116:
    localObject1 = paramSpanned;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie instanceof DiscussChatPie))
    {
      localObject1 = paramSpanned;
      if (paramBaseSessionInfo.jdField_a_of_type_Int == 3000)
      {
        paramSpanned = new ArrayList();
        localObject1 = AtTroopMemberSpan.a(((EditTextUI)localObject2).b(), paramSpanned);
      }
    }
    if (localObject2 != null)
    {
      localObject3 = (FullScreenInputHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(24);
      paramSpanned = ((FullScreenInputHelper)localObject3).a((Spanned)localObject1);
      localObject1 = ((FullScreenInputHelper)localObject3).a((CharSequence)localObject1);
      localObject2 = ((EditTextUI)localObject2).a(2131373876);
      ThreadManager.post(new SaveTextDraftJob(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie, new SessionInfo(paramBaseSessionInfo), paramSpanned, (CharSequence)localObject1, paramQQAppInterface, paramString1, paramSourceMsgInfo, localObject2, paramString2), 8, null, false);
    }
  }
  
  public void a(DraftTextInfo paramDraftTextInfo)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
    if ((localObject1 instanceof ConfessChatPie)) {
      return;
    }
    XEditTextEx localXEditTextEx = ((BaseChatPie)localObject1).jdField_a_of_type_ComTencentWidgetXEditTextEx;
    String str = "";
    if (paramDraftTextInfo != null) {
      localObject1 = paramDraftTextInfo.text;
    } else {
      localObject1 = "";
    }
    this.jdField_a_of_type_JavaLangString = ((String)localObject1);
    localObject1 = (QWalletAIOLifeCycleHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(27);
    if (((localObject1 != null) && (((QWalletAIOLifeCycleHelper)localObject1).a())) || (localXEditTextEx == null))
    {
      if (QLog.isColorLevel()) {
        QLog.i("AIODraftHelper", 2, "skip set text draft");
      }
      return;
    }
    ReplyHelper localReplyHelper = (ReplyHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(119);
    Object localObject2;
    int i;
    if ((paramDraftTextInfo != null) && (paramDraftTextInfo.sourceMsgSeq != 0L))
    {
      localObject2 = localReplyHelper.a(paramDraftTextInfo);
      i = localXEditTextEx.getWidth();
      int j = localXEditTextEx.getPaddingLeft();
      int k = localXEditTextEx.getPaddingRight();
      if (TextUtils.isEmpty(((MessageForReplyText.SourceMsgInfo)localObject2).mSourceMsgTroopName)) {
        localObject1 = this.jdField_a_of_type_AndroidViewView$OnClickListener;
      } else {
        localObject1 = null;
      }
      localObject1 = ReplyedMessageSpan.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (MessageForReplyText.SourceMsgInfo)localObject2, i - j - k, localXEditTextEx.getPaint(), (View.OnClickListener)localObject1);
      if (localObject1 != null)
      {
        localXEditTextEx.setCompoundDrawables(null, ((ReplyedMessageSpan)localObject1).getDrawable(), null, null);
        localXEditTextEx.setTag(2131373876, localObject1);
        localXEditTextEx.setMovementMethod(ReplyClickMovementMethod.a());
      }
    }
    boolean bool;
    if (this.jdField_a_of_type_JavaLangString != null) {
      bool = true;
    } else {
      bool = false;
    }
    this.b = bool;
    if ((paramDraftTextInfo != null) && (paramDraftTextInfo.mixedMsgInfoHtml != null))
    {
      ((FullScreenInputHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(24)).a(paramDraftTextInfo.mixedMsgInfoHtml);
    }
    else
    {
      localObject2 = localXEditTextEx.getEditableText();
      i = localXEditTextEx.getText().length();
      localObject1 = this.jdField_a_of_type_JavaLangString;
      if (localObject1 == null) {
        localObject1 = str;
      }
      ((Editable)localObject2).insert(i, (CharSequence)localObject1);
    }
    ColorNickManager.a(paramDraftTextInfo, localXEditTextEx, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().jdField_a_of_type_JavaLangString);
    paramDraftTextInfo = localReplyHelper.a();
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (paramDraftTextInfo == null) && (!(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie instanceof GameRoomChatPie)) && (RichTextChatManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().postDelayed(new AIODraftHelper.1(this, localXEditTextEx), 100L);
    }
    localXEditTextEx.setSelection(localXEditTextEx.getText().toString().length());
    this.jdField_a_of_type_Boolean = false;
  }
  
  protected void b()
  {
    ((ReplyHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(119)).a(null);
    this.jdField_a_of_type_Boolean = true;
    ThreadManager.post(new GetTextDraftJob(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie), 8, null, true);
  }
  
  @NonNull
  public String getTag()
  {
    return "AIODraftHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 4, 12, 6 };
  }
  
  public void onMoveToState(int paramInt)
  {
    Object localObject;
    if (paramInt == 12)
    {
      localObject = null;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx != null) {
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText();
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx != null) && (!this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().l))
      {
        MessageForReplyText.SourceMsgInfo localSourceMsgInfo = ((ReplyHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(119)).a();
        a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(), (Spanned)localObject, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, localSourceMsgInfo, null);
      }
    }
    else if (paramInt == 4)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent();
      if ((localObject != null) && (((Intent)localObject).getStringExtra("input_text") == null) && (!TopicReplyUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie, (Intent)localObject))) {
        b();
      }
    }
    else if (paramInt == 6)
    {
      this.jdField_a_of_type_Boolean = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.AIODraftHelper
 * JD-Core Version:    0.7.0.1
 */