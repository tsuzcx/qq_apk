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
import java.util.ArrayList;
import java.util.List;

public class InputCallbackRegister
{
  private SparseArray<IMsgSendListener> jdField_a_of_type_AndroidUtilSparseArray;
  private final AIOContext jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext;
  private List<IInputBarLayoutChangeCallback> jdField_a_of_type_JavaUtilList;
  private List<IFunBtnLongClickCallback> b;
  private List<IEditTextChangeCallback> c;
  private List<ISendMessageCallback> d;
  private List<IClearInputCallback> e;
  private List<IInputStateChangeCallback> f;
  private List<IFunBtnEnabledCheck> g;
  private List<IOnRightIconClickListener> h;
  private List<IOnRightIconTouchListener> i;
  
  public InputCallbackRegister(AIOContext paramAIOContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext = paramAIOContext;
  }
  
  private void a()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilList.add(new InputBarLayoutChangeCallback());
  }
  
  private void b()
  {
    this.b = new ArrayList();
    this.b.add(new LocalCrashLongClickCallback());
  }
  
  private void c()
  {
    int j = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a;
    this.c = new ArrayList();
    this.c.add(new FilterModeTextChangeCallback());
    this.c.add(new AtTextChangeCallback());
    this.c.add(new FullScreenTextChangeCallback());
    this.c.add(new QWalletTextChangeCallback());
    this.c.add(new SimpleUITextChangeCallback());
    this.c.add(new ZhituTextChangeCallback());
    this.c.add(new StickerTextChangeCallback());
    if ((j == 1043) || (j == 1)) {
      this.c.add(new RobotTextChangeCallback());
    }
    if (j == 1008) {
      this.c.add(new PATextChangeCallback());
    }
    if (j == 1024) {
      this.c.add(new QidianTextChangeCallback());
    }
  }
  
  private void d()
  {
    this.h = new ArrayList();
    this.h.add(new ZhituRightIconClickListener());
    this.h.add(new ComplexScriptOnclickListener());
    this.h.add(new HiBoomRightIconClickListener());
    this.h.add(new EmotionRightIconClickListener());
    this.h.add(new DoutuRightIconClickListener());
    this.h.add(new SpriteRightIconClickListener());
  }
  
  private void e()
  {
    this.i = new ArrayList();
    this.i.add(new StickerRightIconTouchListener());
  }
  
  private void f()
  {
    int j = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a;
    this.d = new ArrayList();
    this.d.add(new DatongReportSendButtonClick());
    this.d.add(new ReplySendMessageCallback());
    this.d.add(new MixedMsgSendCallback());
    if ((j == 1) || (j == 3000)) {
      this.d.add(new TroopGIftSendMessageCallback());
    }
    this.d.add(new PhotoListMsgCallback());
    this.d.add(new NotEmptySendMessageCallback());
    this.d.add(new DebugFilterSendMessageCallback());
    this.d.add(new GrayTipSendMessageCallback());
    this.d.add(new LogcatSendMessageCallback());
    this.d.add(new PreDownMsgSendCallback());
    this.d.add(new MaxLengthSendMsgCallback());
    this.d.add(new EssenceMsgSendCallback());
    this.d.add(new PasteMsgSendCallback());
    this.d.add(new QWalletMsgSendCallback());
    this.d.add(new EmotionMsgSendCallback());
    this.d.add(new HiddenMsgSendCallback());
    this.d.add(new DBFixMsgSendCallback());
  }
  
  private void g()
  {
    this.g = new ArrayList();
    this.g.add(new PhotoFunBtnEnabledCheck());
  }
  
  private void h()
  {
    this.f = new ArrayList();
    this.f.add(new FullScreenStateChangeCallback());
    this.f.add(new GagInputStateChangeCallback());
    this.f.add(new SimpleUIInputStateChangeCallback());
    this.f.add(new PanelInputStateChangeCallback());
    this.f.add(new RightInputStateChangeCallback());
    this.f.add(new ApollInputStateChangeCallback());
    this.f.add(new ShortcutBarStateChangeCallback());
  }
  
  private void i()
  {
    this.e = new ArrayList();
    this.e.add(new TroopReplyClearInputCallback());
    this.e.add(new RichMediaClearInputCallback());
    this.e.add(new RichTextClearInputCallback());
    this.e.add(new FullScreenClearInputCallback());
  }
  
  private void j()
  {
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    this.jdField_a_of_type_AndroidUtilSparseArray.append(1, new ArkMsgSendListener());
    this.jdField_a_of_type_AndroidUtilSparseArray.append(2, new SimpleMsgSendListener());
    this.jdField_a_of_type_AndroidUtilSparseArray.append(3, new TroopRobotMsgSendListener());
    this.jdField_a_of_type_AndroidUtilSparseArray.append(4, new TroopGagMsgSendListener());
    TroopEffectHelper localTroopEffectHelper = (TroopEffectHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(134);
    this.jdField_a_of_type_AndroidUtilSparseArray.append(5, localTroopEffectHelper);
    this.jdField_a_of_type_AndroidUtilSparseArray.append(6, new TroopRobot2MsgSendListener());
  }
  
  public IMsgSendListener a(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidUtilSparseArray == null) {
      j();
    }
    return (IMsgSendListener)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
  }
  
  public List<IOnRightIconClickListener> a()
  {
    if (this.h == null) {
      d();
    }
    return this.h;
  }
  
  public List<IOnRightIconTouchListener> b()
  {
    if (this.i == null) {
      e();
    }
    return this.i;
  }
  
  public List<ISendMessageCallback> c()
  {
    if (this.d == null) {
      f();
    }
    return this.d;
  }
  
  public List<IFunBtnEnabledCheck> d()
  {
    if (this.g == null) {
      g();
    }
    return this.g;
  }
  
  public List<IInputStateChangeCallback> e()
  {
    if (this.f == null) {
      h();
    }
    return this.f;
  }
  
  public List<IClearInputCallback> f()
  {
    if (this.e == null) {
      i();
    }
    return this.e;
  }
  
  public List<IInputBarLayoutChangeCallback> g()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      a();
    }
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public List<IFunBtnLongClickCallback> h()
  {
    if (this.b == null) {
      b();
    }
    return this.b;
  }
  
  public List<IEditTextChangeCallback> i()
  {
    if (this.c == null) {
      c();
    }
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.input.InputCallbackRegister
 * JD-Core Version:    0.7.0.1
 */