package com.tencent.mobileqq.activity.aio.rebuild.input;

import android.util.SparseArray;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.input.IMsgSendListener;
import com.tencent.mobileqq.activity.aio.core.input.ISendMessageCallback;
import com.tencent.mobileqq.activity.aio.coreui.input.IClearInputCallback;
import com.tencent.mobileqq.activity.aio.coreui.input.IEditTextChangeCallback;
import com.tencent.mobileqq.activity.aio.coreui.input.IFunBtnEnabledCheck;
import com.tencent.mobileqq.activity.aio.coreui.input.IFunBtnLongClickCallback;
import com.tencent.mobileqq.activity.aio.coreui.input.IInputBarLayoutChangeCallback;
import com.tencent.mobileqq.activity.aio.coreui.input.IInputStateChangeCallback;
import com.tencent.mobileqq.activity.aio.coreui.input.IOnRightIconClickListener;
import com.tencent.mobileqq.activity.aio.coreui.input.IOnRightIconTouchListener;
import com.tencent.mobileqq.activity.aio.helper.TroopEffectHelper;
import com.tencent.mobileqq.activity.aio.rebuild.input.clearinput.FullScreenClearInputCallback;
import com.tencent.mobileqq.activity.aio.rebuild.input.clearinput.RichMediaClearInputCallback;
import com.tencent.mobileqq.activity.aio.rebuild.input.clearinput.RichTextClearInputCallback;
import com.tencent.mobileqq.activity.aio.rebuild.input.clearinput.TroopReplyClearInputCallback;
import com.tencent.mobileqq.activity.aio.rebuild.input.edittext.AtTextChangeCallback;
import com.tencent.mobileqq.activity.aio.rebuild.input.edittext.FilterModeTextChangeCallback;
import com.tencent.mobileqq.activity.aio.rebuild.input.edittext.FullScreenTextChangeCallback;
import com.tencent.mobileqq.activity.aio.rebuild.input.edittext.PATextChangeCallback;
import com.tencent.mobileqq.activity.aio.rebuild.input.edittext.QWalletTextChangeCallback;
import com.tencent.mobileqq.activity.aio.rebuild.input.edittext.QidianTextChangeCallback;
import com.tencent.mobileqq.activity.aio.rebuild.input.edittext.RobotTextChangeCallback;
import com.tencent.mobileqq.activity.aio.rebuild.input.edittext.SimpleUITextChangeCallback;
import com.tencent.mobileqq.activity.aio.rebuild.input.edittext.StickerTextChangeCallback;
import com.tencent.mobileqq.activity.aio.rebuild.input.edittext.ZhituTextChangeCallback;
import com.tencent.mobileqq.activity.aio.rebuild.input.funbtn.LocalCrashLongClickCallback;
import com.tencent.mobileqq.activity.aio.rebuild.input.funbtn.PhotoFunBtnEnabledCheck;
import com.tencent.mobileqq.activity.aio.rebuild.input.inputbarlayout.InputBarLayoutChangeCallback;
import com.tencent.mobileqq.activity.aio.rebuild.input.inputstate.ApollInputStateChangeCallback;
import com.tencent.mobileqq.activity.aio.rebuild.input.inputstate.FullScreenStateChangeCallback;
import com.tencent.mobileqq.activity.aio.rebuild.input.inputstate.GagInputStateChangeCallback;
import com.tencent.mobileqq.activity.aio.rebuild.input.inputstate.PanelInputStateChangeCallback;
import com.tencent.mobileqq.activity.aio.rebuild.input.inputstate.RightInputStateChangeCallback;
import com.tencent.mobileqq.activity.aio.rebuild.input.inputstate.ShortcutBarStateChangeCallback;
import com.tencent.mobileqq.activity.aio.rebuild.input.inputstate.SimpleUIInputStateChangeCallback;
import com.tencent.mobileqq.activity.aio.rebuild.input.righticon.ComplexScriptOnclickListener;
import com.tencent.mobileqq.activity.aio.rebuild.input.righticon.DoutuRightIconClickListener;
import com.tencent.mobileqq.activity.aio.rebuild.input.righticon.EmotionRightIconClickListener;
import com.tencent.mobileqq.activity.aio.rebuild.input.righticon.HiBoomRightIconClickListener;
import com.tencent.mobileqq.activity.aio.rebuild.input.righticon.SpriteRightIconClickListener;
import com.tencent.mobileqq.activity.aio.rebuild.input.righticon.StickerRightIconTouchListener;
import com.tencent.mobileqq.activity.aio.rebuild.input.righticon.ZhituRightIconClickListener;
import com.tencent.mobileqq.activity.aio.rebuild.input.send.ArkMsgSendListener;
import com.tencent.mobileqq.activity.aio.rebuild.input.send.DBFixMsgSendCallback;
import com.tencent.mobileqq.activity.aio.rebuild.input.send.DatongReportSendButtonClick;
import com.tencent.mobileqq.activity.aio.rebuild.input.send.DebugFilterSendMessageCallback;
import com.tencent.mobileqq.activity.aio.rebuild.input.send.EmotionMsgSendCallback;
import com.tencent.mobileqq.activity.aio.rebuild.input.send.EssenceMsgSendCallback;
import com.tencent.mobileqq.activity.aio.rebuild.input.send.GrayTipSendMessageCallback;
import com.tencent.mobileqq.activity.aio.rebuild.input.send.HiddenMsgSendCallback;
import com.tencent.mobileqq.activity.aio.rebuild.input.send.LogcatSendMessageCallback;
import com.tencent.mobileqq.activity.aio.rebuild.input.send.MaxLengthSendMsgCallback;
import com.tencent.mobileqq.activity.aio.rebuild.input.send.MixedMsgSendCallback;
import com.tencent.mobileqq.activity.aio.rebuild.input.send.NotEmptySendMessageCallback;
import com.tencent.mobileqq.activity.aio.rebuild.input.send.PasteMsgSendCallback;
import com.tencent.mobileqq.activity.aio.rebuild.input.send.PhotoListMsgCallback;
import com.tencent.mobileqq.activity.aio.rebuild.input.send.PreDownMsgSendCallback;
import com.tencent.mobileqq.activity.aio.rebuild.input.send.QWalletMsgSendCallback;
import com.tencent.mobileqq.activity.aio.rebuild.input.send.ReplySendMessageCallback;
import com.tencent.mobileqq.activity.aio.rebuild.input.send.SimpleMsgSendListener;
import com.tencent.mobileqq.activity.aio.rebuild.input.send.TroopGIftSendMessageCallback;
import com.tencent.mobileqq.activity.aio.rebuild.input.send.TroopGagMsgSendListener;
import com.tencent.mobileqq.activity.aio.rebuild.input.send.TroopRobot2MsgSendListener;
import com.tencent.mobileqq.activity.aio.rebuild.input.send.TroopRobotMsgSendListener;
import com.tencent.mobileqq.emoticonview.AniStickerSendMessageCallBack;
import com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.ArrayList;
import java.util.List;

public class InputCallbackRegister
{
  private final AIOContext a;
  private List<IInputBarLayoutChangeCallback> b;
  private List<IFunBtnLongClickCallback> c;
  private List<IEditTextChangeCallback> d;
  private List<ISendMessageCallback> e;
  private SparseArray<IMsgSendListener> f;
  private List<IClearInputCallback> g;
  private List<IInputStateChangeCallback> h;
  private List<IFunBtnEnabledCheck> i;
  private List<IOnRightIconClickListener> j;
  private List<IOnRightIconTouchListener> k;
  
  public InputCallbackRegister(AIOContext paramAIOContext)
  {
    this.a = paramAIOContext;
  }
  
  private void k()
  {
    this.b = new ArrayList();
    if (((IGuildFeatureAdapterApi)QRoute.api(IGuildFeatureAdapterApi.class)).judgeIsGuildChatContext(this.a))
    {
      this.b.add((IInputBarLayoutChangeCallback)((IGuildFeatureAdapterApi)QRoute.api(IGuildFeatureAdapterApi.class)).getNewGuildInputBarLayoutChangeCallback());
      return;
    }
    this.b.add(new InputBarLayoutChangeCallback());
  }
  
  private void l()
  {
    this.c = new ArrayList();
    this.c.add(new LocalCrashLongClickCallback());
  }
  
  private void m()
  {
    int m = this.a.O().a;
    this.d = new ArrayList();
    this.d.add(new FilterModeTextChangeCallback());
    this.d.add(new AtTextChangeCallback());
    this.d.add(new FullScreenTextChangeCallback());
    this.d.add(new QWalletTextChangeCallback());
    this.d.add(new SimpleUITextChangeCallback());
    this.d.add(new ZhituTextChangeCallback());
    if (!a()) {
      this.d.add(new StickerTextChangeCallback());
    }
    if ((m == 1043) || (m == 1)) {
      this.d.add(new RobotTextChangeCallback());
    }
    if (m == 1008) {
      this.d.add(new PATextChangeCallback());
    }
    if (m == 1024) {
      this.d.add(new QidianTextChangeCallback());
    }
    if (m == 10014) {
      this.d.add((IEditTextChangeCallback)((IGuildFeatureAdapterApi)QRoute.api(IGuildFeatureAdapterApi.class)).getNewGuildTextChangeCallback());
    }
  }
  
  private void n()
  {
    this.j = new ArrayList();
    this.j.add(new ZhituRightIconClickListener());
    this.j.add(new ComplexScriptOnclickListener());
    this.j.add(new HiBoomRightIconClickListener());
    this.j.add(new EmotionRightIconClickListener());
    this.j.add(new DoutuRightIconClickListener());
    this.j.add(new SpriteRightIconClickListener());
  }
  
  private void o()
  {
    this.k = new ArrayList();
    this.k.add(new StickerRightIconTouchListener());
  }
  
  private void p()
  {
    int m = this.a.O().a;
    this.e = new ArrayList();
    this.e.add(new DatongReportSendButtonClick());
    this.e.add(new ReplySendMessageCallback());
    this.e.add(new MixedMsgSendCallback());
    if ((m == 1) || (m == 3000)) {
      this.e.add(new TroopGIftSendMessageCallback());
    }
    if (m == 10014) {
      this.e.add((ISendMessageCallback)((IGuildFeatureAdapterApi)QRoute.api(IGuildFeatureAdapterApi.class)).getNewGuildMsgSendCallback());
    }
    this.e.add(new AniStickerSendMessageCallBack());
    this.e.add(new PhotoListMsgCallback());
    this.e.add(new NotEmptySendMessageCallback());
    this.e.add(new DebugFilterSendMessageCallback());
    this.e.add(new GrayTipSendMessageCallback());
    this.e.add(new LogcatSendMessageCallback());
    this.e.add(new PreDownMsgSendCallback());
    this.e.add(new MaxLengthSendMsgCallback());
    this.e.add(new EssenceMsgSendCallback());
    this.e.add(new PasteMsgSendCallback());
    this.e.add(new QWalletMsgSendCallback());
    this.e.add(new EmotionMsgSendCallback());
    this.e.add(new HiddenMsgSendCallback());
    this.e.add(new DBFixMsgSendCallback());
  }
  
  private void q()
  {
    this.i = new ArrayList();
    this.i.add(new PhotoFunBtnEnabledCheck());
  }
  
  private void r()
  {
    this.h = new ArrayList();
    this.h.add(new FullScreenStateChangeCallback());
    this.h.add(new GagInputStateChangeCallback());
    this.h.add(new SimpleUIInputStateChangeCallback());
    this.h.add(new PanelInputStateChangeCallback());
    this.h.add(new RightInputStateChangeCallback());
    this.h.add(new ApollInputStateChangeCallback());
    this.h.add(new ShortcutBarStateChangeCallback());
  }
  
  private void s()
  {
    this.g = new ArrayList();
    this.g.add(new TroopReplyClearInputCallback());
    this.g.add(new RichMediaClearInputCallback());
    this.g.add(new RichTextClearInputCallback());
    this.g.add(new FullScreenClearInputCallback());
  }
  
  private void t()
  {
    this.f = new SparseArray();
    this.f.append(1, new ArkMsgSendListener());
    this.f.append(2, new SimpleMsgSendListener());
    this.f.append(3, new TroopRobotMsgSendListener());
    this.f.append(4, new TroopGagMsgSendListener());
    TroopEffectHelper localTroopEffectHelper = (TroopEffectHelper)this.a.a(134);
    this.f.append(5, localTroopEffectHelper);
    this.f.append(6, new TroopRobot2MsgSendListener());
    this.f.append(7, (IMsgSendListener)((IGuildFeatureAdapterApi)QRoute.api(IGuildFeatureAdapterApi.class)).getNewGuildMsgSendListener());
  }
  
  public IMsgSendListener a(int paramInt)
  {
    if (this.f == null) {
      t();
    }
    return (IMsgSendListener)this.f.get(paramInt);
  }
  
  protected boolean a()
  {
    return false;
  }
  
  public List<IOnRightIconClickListener> b()
  {
    if (this.j == null) {
      n();
    }
    return this.j;
  }
  
  public List<IOnRightIconTouchListener> c()
  {
    if (this.k == null) {
      o();
    }
    return this.k;
  }
  
  public List<ISendMessageCallback> d()
  {
    if (this.e == null) {
      p();
    }
    return this.e;
  }
  
  public List<IFunBtnEnabledCheck> e()
  {
    if (this.i == null) {
      q();
    }
    return this.i;
  }
  
  public List<IInputStateChangeCallback> f()
  {
    if (this.h == null) {
      r();
    }
    return this.h;
  }
  
  public List<IClearInputCallback> g()
  {
    if (this.g == null) {
      s();
    }
    return this.g;
  }
  
  public List<IInputBarLayoutChangeCallback> h()
  {
    if (this.b == null) {
      k();
    }
    return this.b;
  }
  
  public List<IFunBtnLongClickCallback> i()
  {
    if (this.c == null) {
      l();
    }
    return this.c;
  }
  
  public List<IEditTextChangeCallback> j()
  {
    if (this.d == null) {
      m();
    }
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.input.InputCallbackRegister
 * JD-Core Version:    0.7.0.1
 */