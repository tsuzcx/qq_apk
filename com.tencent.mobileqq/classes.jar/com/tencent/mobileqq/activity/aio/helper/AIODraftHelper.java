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
import com.tencent.mobileqq.activity.aio.panel.PanelManager;
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
import com.tencent.widget.XPanelContainer;
import java.util.ArrayList;
import mqq.os.MqqHandler;

public class AIODraftHelper
  implements ILifeCycleHelper
{
  protected QQAppInterface a;
  protected AIOContext b;
  protected BaseChatPie c;
  protected boolean d = false;
  public String e;
  public boolean f = false;
  public View.OnClickListener g = new AIODraftHelper.2(this);
  
  public AIODraftHelper(BaseChatPie paramBaseChatPie)
  {
    this.c = paramBaseChatPie;
    this.b = paramBaseChatPie.bv();
    this.a = this.b.a();
  }
  
  protected void a()
  {
    PanelManager localPanelManager = this.b.q();
    if ((localPanelManager != null) && (this.f))
    {
      XPanelContainer localXPanelContainer = localPanelManager.d();
      if (localXPanelContainer != null)
      {
        localXPanelContainer.setReadyToShow(true);
        localPanelManager.a(1, false);
      }
    }
  }
  
  protected void a(BaseSessionInfo paramBaseSessionInfo, Spanned paramSpanned, QQAppInterface paramQQAppInterface, String paramString1, MessageForReplyText.SourceMsgInfo paramSourceMsgInfo, String paramString2)
  {
    Object localObject2 = this.b.p().d().f();
    Object localObject1 = this.c;
    if (((localObject1 instanceof HotChatPie)) && (!((HotChatPie)localObject1).bQ.b(paramBaseSessionInfo.b))) {
      return;
    }
    Object localObject3;
    if ((this.c instanceof BaseTroopChatPie))
    {
      localObject3 = new ArrayList();
      if (paramBaseSessionInfo.a == 1) {
        paramSpanned = AtTroopMemberSpan.b(((EditTextUI)localObject2).c(), (ArrayList)localObject3);
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
    if ((this.c instanceof DiscussChatPie))
    {
      localObject1 = paramSpanned;
      if (paramBaseSessionInfo.a == 3000)
      {
        paramSpanned = new ArrayList();
        localObject1 = AtTroopMemberSpan.b(((EditTextUI)localObject2).c(), paramSpanned);
      }
    }
    if (localObject2 != null)
    {
      localObject3 = (FullScreenInputHelper)this.b.a(24);
      paramSpanned = ((FullScreenInputHelper)localObject3).a((Spanned)localObject1);
      localObject1 = ((FullScreenInputHelper)localObject3).b((CharSequence)localObject1);
      localObject2 = ((EditTextUI)localObject2).c(2131441550);
      ThreadManager.post(new SaveTextDraftJob(this.c, new SessionInfo(paramBaseSessionInfo), paramSpanned, (CharSequence)localObject1, paramQQAppInterface, paramString1, paramSourceMsgInfo, localObject2, paramString2), 8, null, false);
    }
  }
  
  public void a(DraftTextInfo paramDraftTextInfo)
  {
    Object localObject1 = this.c;
    if ((localObject1 instanceof ConfessChatPie)) {
      return;
    }
    XEditTextEx localXEditTextEx = ((BaseChatPie)localObject1).Y;
    String str = "";
    if (paramDraftTextInfo != null) {
      localObject1 = paramDraftTextInfo.text;
    } else {
      localObject1 = "";
    }
    this.e = ((String)localObject1);
    localObject1 = (QWalletAIOLifeCycleHelper)this.b.a(27);
    if (((localObject1 != null) && (((QWalletAIOLifeCycleHelper)localObject1).c())) || (localXEditTextEx == null))
    {
      if (QLog.isColorLevel()) {
        QLog.i("AIODraftHelper", 2, "skip set text draft");
      }
      return;
    }
    ReplyHelper localReplyHelper = (ReplyHelper)this.b.a(119);
    Object localObject2;
    int i;
    if ((paramDraftTextInfo != null) && (paramDraftTextInfo.sourceMsgSeq != 0L))
    {
      localObject2 = localReplyHelper.a(paramDraftTextInfo);
      i = localXEditTextEx.getWidth();
      int j = localXEditTextEx.getPaddingLeft();
      int k = localXEditTextEx.getPaddingRight();
      if (TextUtils.isEmpty(((MessageForReplyText.SourceMsgInfo)localObject2).mSourceMsgTroopName)) {
        localObject1 = this.g;
      } else {
        localObject1 = null;
      }
      localObject1 = ReplyedMessageSpan.a(this.a, this.c.f, (MessageForReplyText.SourceMsgInfo)localObject2, i - j - k, localXEditTextEx.getPaint(), (View.OnClickListener)localObject1);
      if (localObject1 != null)
      {
        localXEditTextEx.setCompoundDrawables(null, ((ReplyedMessageSpan)localObject1).getDrawable(), null, null);
        localXEditTextEx.setTag(2131441550, localObject1);
        localXEditTextEx.setMovementMethod(ReplyClickMovementMethod.a());
      }
    }
    boolean bool;
    if (this.e != null) {
      bool = true;
    } else {
      bool = false;
    }
    this.f = bool;
    if ((paramDraftTextInfo != null) && (paramDraftTextInfo.mixedMsgInfoHtml != null))
    {
      ((FullScreenInputHelper)this.b.a(24)).a(paramDraftTextInfo.mixedMsgInfoHtml);
    }
    else
    {
      localObject2 = localXEditTextEx.getEditableText();
      i = localXEditTextEx.getText().length();
      localObject1 = this.e;
      if (localObject1 == null) {
        localObject1 = str;
      }
      ((Editable)localObject2).insert(i, (CharSequence)localObject1);
    }
    ColorNickManager.a(paramDraftTextInfo, localXEditTextEx, this.e, this.a, this.c.aX(), this.b.O().b);
    paramDraftTextInfo = localReplyHelper.a();
    if ((!TextUtils.isEmpty(this.e)) && (paramDraftTextInfo == null) && (!(this.c instanceof GameRoomChatPie)) && (RichTextChatManager.a(this.a).c(this.a))) {
      this.c.j().postDelayed(new AIODraftHelper.1(this, localXEditTextEx), 100L);
    }
    localXEditTextEx.setSelection(localXEditTextEx.getText().toString().length());
    this.d = false;
  }
  
  protected void b()
  {
    BaseChatPie localBaseChatPie = this.c;
    if (((localBaseChatPie instanceof FriendChatPie)) || ((localBaseChatPie instanceof DiscussChatPie)) || ((localBaseChatPie instanceof TroopChatPie))) {
      ((AIOInputRightHelper)this.b.a(117)).a();
    }
  }
  
  protected void c()
  {
    ((ReplyHelper)this.b.a(119)).a(null);
    this.d = true;
    ThreadManager.post(new GetTextDraftJob(this.b.g(), this.b.O(), this.a, this.c), 8, null, true);
  }
  
  @NonNull
  public String getTag()
  {
    return "AIODraftHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 4, 12, 6, 8 };
  }
  
  public void onMoveToState(int paramInt)
  {
    Object localObject;
    if (paramInt == 12)
    {
      localObject = null;
      if (this.c.Y != null) {
        localObject = this.c.Y.getText();
      }
      if ((this.c.Y != null) && (!this.b.O().z))
      {
        MessageForReplyText.SourceMsgInfo localSourceMsgInfo = ((ReplyHelper)this.b.a(119)).a();
        a(this.b.O(), (Spanned)localObject, this.a, this.e, localSourceMsgInfo, null);
      }
    }
    else if (paramInt == 4)
    {
      localObject = this.c.f.getIntent();
      if ((localObject != null) && (((Intent)localObject).getStringExtra("input_text") == null) && (!TopicReplyUtil.a(this.c, (Intent)localObject))) {
        c();
      }
    }
    else
    {
      if (paramInt == 6)
      {
        this.d = false;
        return;
      }
      if (paramInt == 8) {
        a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.AIODraftHelper
 * JD-Core Version:    0.7.0.1
 */