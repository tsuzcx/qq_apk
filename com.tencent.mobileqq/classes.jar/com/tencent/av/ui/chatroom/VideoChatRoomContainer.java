package com.tencent.av.ui.chatroom;

import android.app.Activity;
import android.content.Context;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.RelativeLayout;
import com.tencent.av.AVLog;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.chatroom.ChatRoomUtil;
import com.tencent.av.tips.TipsUtil;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.GLVideoView;
import com.tencent.av.ui.VideoControlUI;
import com.tencent.av.ui.VideoLayerUI;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonPanelWithActionBar;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class VideoChatRoomContainer
  extends RelativeLayout
  implements EmotionInputDetector.EventListener
{
  VideoAppInterface a;
  protected EditText b;
  protected ListView c;
  private LinearLayout d;
  private LinearLayout e;
  private ImageView f;
  private LinearLayout g;
  private SystemAndEmojiEmoticonPanelWithActionBar h;
  private ChatRoomAdapter i;
  private int j = 0;
  private boolean k = false;
  private int l = 0;
  private EmotionInputDetector m;
  
  public VideoChatRoomContainer(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public VideoChatRoomContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public VideoChatRoomContainer(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    b(paramContext);
    c(paramContext);
  }
  
  private void b(Context paramContext)
  {
    View localView = LayoutInflater.from(paramContext).inflate(2131625727, this);
    this.d = ((LinearLayout)localView.findViewById(2131436854));
    this.e = ((LinearLayout)localView.findViewById(2131431349));
    this.i = new ChatRoomAdapter(paramContext);
    this.c = ((ListView)this.e.findViewById(16908298));
    this.c.setAdapter(this.i);
    this.b = ((EditText)this.e.findViewById(2131435813));
    this.b.setFilters(new InputFilter[] { new InputFilter.LengthFilter(40) });
    this.f = ((ImageView)this.e.findViewById(2131432468));
    this.g = ((LinearLayout)this.d.findViewById(2131432476));
    setFitsSystemWindows(true);
  }
  
  private void c(Context paramContext)
  {
    this.m = EmotionInputDetector.a((Activity)paramContext).a(this).a((VideoChatRoomListView)this.c).a(this.b).a(this.f).a();
    paramContext = new LinearLayout.LayoutParams(-1, -1);
    this.h = new SystemAndEmojiEmoticonPanelWithActionBar(getContext(), this.m);
    this.h.setBackgroundColor(-1);
    this.h.setId(2131441035);
    this.h.setVisibility(0);
    this.g.addView(this.h, paramContext);
    this.m.a(this.g);
  }
  
  public void a(int paramInt)
  {
    boolean bool1 = this.m.e();
    boolean bool3 = this.k;
    boolean bool2 = true;
    int i4 = 0;
    if (bool3 != bool1) {
      n = 1;
    } else {
      n = 0;
    }
    this.k = bool1;
    int i1;
    if (this.j != paramInt) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    this.j = paramInt;
    AVActivity localAVActivity = null;
    Context localContext = getContext();
    int i2;
    int i3;
    if ((localContext instanceof AVActivity))
    {
      localAVActivity = (AVActivity)localContext;
      i2 = localAVActivity.u();
      if (this.l != i2) {
        paramInt = 1;
      } else {
        paramInt = 0;
      }
      this.l = i2;
      i3 = paramInt;
    }
    else
    {
      i2 = 1;
      i3 = 0;
    }
    bool1 = bool2;
    if (n == 0)
    {
      bool1 = bool2;
      if (i1 == 0) {
        if (i3 != 0) {
          bool1 = bool2;
        } else {
          bool1 = false;
        }
      }
    }
    paramInt = this.j;
    int n = this.m.d();
    if ((n != 0) && (n != 7))
    {
      paramInt = i4;
      if (this.m.a) {
        if (n == 4) {
          paramInt = i4;
        } else {
          paramInt = this.j;
        }
      }
    }
    a(paramInt, bool1);
    if ((localAVActivity != null) && (i3 != 0)) {
      a(localAVActivity.L, i2);
    }
    if ((bool1) && (localAVActivity != null) && (localAVActivity.K != null)) {
      localAVActivity.K.ao();
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    a(this.j);
  }
  
  public void a(int paramInt, long paramLong)
  {
    if (this.m == null) {
      return;
    }
    switch (paramInt)
    {
    default: 
      break;
    case 1: 
    case 2: 
    case 4: 
      a(0, false);
      break;
    case 0: 
    case 7: 
      a(this.j, false);
    }
    post(new VideoChatRoomContainer.1(this, paramInt, paramLong));
  }
  
  protected void a(int paramInt, Object paramObject)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("notifyEvent :");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("|");
    localStringBuilder.append(paramObject);
    AVLog.printColorLog("VideoChatRoomContainer", localStringBuilder.toString());
    this.a.a(new Object[] { Integer.valueOf(paramInt), paramObject });
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    Object localObject = (ViewGroup.MarginLayoutParams)this.d.getLayoutParams();
    if (((ViewGroup.MarginLayoutParams)localObject).bottomMargin != paramInt) {
      ((ViewGroup.MarginLayoutParams)localObject).bottomMargin = paramInt;
    }
    if (paramBoolean) {
      this.d.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateContextViewLayoutBottomMargin, bottomMargin[");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append("], forceRequestLayout[");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append("]");
      QLog.i("ChatRoomUtil", 4, ((StringBuilder)localObject).toString());
    }
  }
  
  public void a(MotionEvent paramMotionEvent)
  {
    Object localObject = getContext();
    if ((localObject instanceof AVActivity))
    {
      localObject = (AVActivity)localObject;
      if ((((AVActivity)localObject).L != null) && (((AVActivity)localObject).L.I != null))
      {
        ((AVActivity)localObject).L.ah = -1;
        ((AVActivity)localObject).L.I.onTouchEvent(paramMotionEvent);
      }
    }
  }
  
  public void a(VideoAppInterface paramVideoAppInterface)
  {
    this.a = paramVideoAppInterface;
  }
  
  public void a(VideoLayerUI paramVideoLayerUI, int paramInt)
  {
    int i2 = 1;
    int i3 = 0;
    if ((paramInt == 1) && (!b()))
    {
      if ((paramVideoLayerUI != null) && (paramVideoLayerUI.ae.length > 1) && (paramVideoLayerUI.ae[1] != null))
      {
        if (paramVideoLayerUI.ae[1].b() == 0) {
          n = 1;
        } else {
          n = 0;
        }
        paramInt = paramVideoLayerUI.ae[1].g();
      }
      else
      {
        n = 0;
        paramInt = 0;
      }
      if (n != 0)
      {
        n = paramVideoLayerUI.ac();
        if ((n != 1) && (n != 2)) {
          if (n != 3)
          {
            if (n == 4)
            {
              n = 0;
              i1 = paramInt;
              break label129;
            }
          }
          else {
            break label124;
          }
        }
      }
    }
    paramInt = 0;
    label124:
    int i1 = 0;
    int n = paramInt;
    label129:
    paramVideoLayerUI = (ViewGroup.MarginLayoutParams)this.e.getLayoutParams();
    paramInt = i3;
    if (paramVideoLayerUI.leftMargin != i1)
    {
      paramVideoLayerUI.leftMargin = i1;
      paramInt = 1;
    }
    if (paramVideoLayerUI.rightMargin != n)
    {
      paramVideoLayerUI.rightMargin = n;
      paramInt = i2;
    }
    if ((paramInt != 0) && (getVisibility() == 0)) {
      this.e.setLayoutParams(paramVideoLayerUI);
    }
  }
  
  public void a(String paramString)
  {
    Object localObject = VideoChatMessage.e();
    ((VideoChatMessage)localObject).a(1);
    ((VideoChatMessage)localObject).a(paramString);
    ((VideoChatMessage)localObject).b(this.a.getCurrentAccountUin());
    this.i.a((VideoChatMessage)localObject);
    this.c.setSelection(this.i.getCount() - 1);
    localObject = getContext();
    if ((localObject instanceof AVActivity))
    {
      localObject = (AVActivity)localObject;
      if (((AVActivity)localObject).ai != null) {
        ((AVActivity)localObject).ai.a(paramString);
      }
    }
  }
  
  public void a(List<VideoChatMessage> paramList, boolean paramBoolean)
  {
    this.i.a(paramList, paramBoolean);
    this.c.setSelection(this.i.getCount() - 1);
  }
  
  public boolean a()
  {
    if (this.m.f())
    {
      this.m.c();
      return true;
    }
    if (this.m.g())
    {
      this.m.h();
      return true;
    }
    return false;
  }
  
  public void b(int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    if ((paramInt2 == 2) && (paramInt3 == 7)) {
      a(this.j);
    }
  }
  
  public boolean b()
  {
    return false;
  }
  
  public boolean c()
  {
    EmotionInputDetector localEmotionInputDetector = this.m;
    return (localEmotionInputDetector != null) && (localEmotionInputDetector.g());
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    View localView = ((AVActivity)getContext()).findViewById(2131441050);
    boolean bool1 = false;
    int n;
    if (localView != null) {
      n = 1;
    } else {
      n = 0;
    }
    if (n != 0)
    {
      this.m.b();
      if (QLog.isColorLevel()) {
        QLog.w("ChatRoomUtil", 2, "doodle hase show, so not accept dispatchEvent");
      }
    }
    else if (this.a.b().k().af)
    {
      this.m.b();
      a(119, Integer.valueOf(2));
    }
    else
    {
      if (!VideoController.f().k().cB) {
        break label123;
      }
      TipsUtil.a(this.a, 1022, 2131893511);
    }
    return false;
    label123:
    boolean bool2 = super.dispatchTouchEvent(paramMotionEvent);
    if ((!bool2) && (this.m.g()))
    {
      paramMotionEvent = (InputMethodManager)getContext().getSystemService("input_method");
      if (paramMotionEvent != null) {
        bool1 = paramMotionEvent.isActive();
      }
      this.m.h();
      if (QLog.isColorLevel())
      {
        paramMotionEvent = new StringBuilder();
        paramMotionEvent.append("dispatchTouchEvent, 拦截了touch消息, isSoftInputActive[");
        paramMotionEvent.append(bool1);
        paramMotionEvent.append("]");
        QLog.w("ChatRoomUtil", 2, paramMotionEvent.toString());
        return bool2;
      }
    }
    else if ((!bool2) && (this.m.f()))
    {
      this.m.c();
    }
    return bool2;
  }
  
  public int getCurrentPanelHeight()
  {
    boolean bool = this.m.f();
    int n = 0;
    if (bool) {
      return this.g.getHeight();
    }
    if (this.m.g())
    {
      if (this.m.a) {
        return 0;
      }
      n = ChatRoomUtil.a;
    }
    return n;
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    if (getVisibility() == 8)
    {
      EmotionInputDetector localEmotionInputDetector = this.m;
      if (localEmotionInputDetector != null)
      {
        if (localEmotionInputDetector.f())
        {
          this.m.c();
          return;
        }
        this.m.h();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.chatroom.VideoChatRoomContainer
 * JD-Core Version:    0.7.0.1
 */