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
  private int jdField_a_of_type_Int = 0;
  protected EditText a;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  protected ListView a;
  VideoAppInterface jdField_a_of_type_ComTencentAvAppVideoAppInterface;
  private ChatRoomAdapter jdField_a_of_type_ComTencentAvUiChatroomChatRoomAdapter;
  private EmotionInputDetector jdField_a_of_type_ComTencentAvUiChatroomEmotionInputDetector;
  private SystemAndEmojiEmoticonPanelWithActionBar jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanelWithActionBar;
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int = 0;
  private LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  private LinearLayout c;
  
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
    View localView = LayoutInflater.from(paramContext).inflate(2131559692, this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView.findViewById(2131369736));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView.findViewById(2131365187));
    this.jdField_a_of_type_ComTencentAvUiChatroomChatRoomAdapter = new ChatRoomAdapter(paramContext);
    this.jdField_a_of_type_AndroidWidgetListView = ((ListView)this.jdField_b_of_type_AndroidWidgetLinearLayout.findViewById(16908298));
    this.jdField_a_of_type_AndroidWidgetListView.setAdapter(this.jdField_a_of_type_ComTencentAvUiChatroomChatRoomAdapter);
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_b_of_type_AndroidWidgetLinearLayout.findViewById(2131368877));
    this.jdField_a_of_type_AndroidWidgetEditText.setFilters(new InputFilter[] { new InputFilter.LengthFilter(40) });
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidWidgetLinearLayout.findViewById(2131366181));
    this.c = ((LinearLayout)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131366188));
    setFitsSystemWindows(true);
  }
  
  private void c(Context paramContext)
  {
    this.jdField_a_of_type_ComTencentAvUiChatroomEmotionInputDetector = EmotionInputDetector.a((Activity)paramContext).a(this).a((VideoChatRoomListView)this.jdField_a_of_type_AndroidWidgetListView).a(this.jdField_a_of_type_AndroidWidgetEditText).a(this.jdField_a_of_type_AndroidWidgetImageView).a();
    paramContext = new LinearLayout.LayoutParams(-1, -1);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanelWithActionBar = new SystemAndEmojiEmoticonPanelWithActionBar(getContext(), this.jdField_a_of_type_ComTencentAvUiChatroomEmotionInputDetector);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanelWithActionBar.setBackgroundColor(-1);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanelWithActionBar.setId(2131373362);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanelWithActionBar.setVisibility(0);
    this.c.addView(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanelWithActionBar, paramContext);
    this.jdField_a_of_type_ComTencentAvUiChatroomEmotionInputDetector.a(this.c);
  }
  
  public int a()
  {
    boolean bool = this.jdField_a_of_type_ComTencentAvUiChatroomEmotionInputDetector.b();
    int i = 0;
    if (bool) {
      return this.c.getHeight();
    }
    if (this.jdField_a_of_type_ComTencentAvUiChatroomEmotionInputDetector.c())
    {
      if (this.jdField_a_of_type_ComTencentAvUiChatroomEmotionInputDetector.jdField_a_of_type_Boolean) {
        return 0;
      }
      i = ChatRoomUtil.jdField_a_of_type_Int;
    }
    return i;
  }
  
  public void a(int paramInt)
  {
    boolean bool1 = this.jdField_a_of_type_ComTencentAvUiChatroomEmotionInputDetector.a();
    boolean bool3 = this.jdField_a_of_type_Boolean;
    boolean bool2 = true;
    int n = 0;
    if (bool3 != bool1) {
      i = 1;
    } else {
      i = 0;
    }
    this.jdField_a_of_type_Boolean = bool1;
    int j;
    if (this.jdField_a_of_type_Int != paramInt) {
      j = 1;
    } else {
      j = 0;
    }
    this.jdField_a_of_type_Int = paramInt;
    AVActivity localAVActivity = null;
    Context localContext = getContext();
    int k;
    int m;
    if ((localContext instanceof AVActivity))
    {
      localAVActivity = (AVActivity)localContext;
      k = localAVActivity.c();
      if (this.jdField_b_of_type_Int != k) {
        paramInt = 1;
      } else {
        paramInt = 0;
      }
      this.jdField_b_of_type_Int = k;
      m = paramInt;
    }
    else
    {
      k = 1;
      m = 0;
    }
    bool1 = bool2;
    if (i == 0)
    {
      bool1 = bool2;
      if (j == 0) {
        if (m != 0) {
          bool1 = bool2;
        } else {
          bool1 = false;
        }
      }
    }
    paramInt = this.jdField_a_of_type_Int;
    int i = this.jdField_a_of_type_ComTencentAvUiChatroomEmotionInputDetector.a();
    if ((i != 0) && (i != 7))
    {
      paramInt = n;
      if (this.jdField_a_of_type_ComTencentAvUiChatroomEmotionInputDetector.jdField_a_of_type_Boolean) {
        if (i == 4) {
          paramInt = n;
        } else {
          paramInt = this.jdField_a_of_type_Int;
        }
      }
    }
    a(paramInt, bool1);
    if ((localAVActivity != null) && (m != 0)) {
      a(localAVActivity.jdField_a_of_type_ComTencentAvUiVideoLayerUI, k);
    }
    if ((bool1) && (localAVActivity != null) && (localAVActivity.jdField_a_of_type_ComTencentAvUiVideoControlUI != null)) {
      localAVActivity.jdField_a_of_type_ComTencentAvUiVideoControlUI.R();
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    a(this.jdField_a_of_type_Int);
  }
  
  public void a(int paramInt, long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentAvUiChatroomEmotionInputDetector == null) {
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
      a(this.jdField_a_of_type_Int, false);
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
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(paramInt), paramObject });
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    Object localObject = (ViewGroup.MarginLayoutParams)this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
    if (((ViewGroup.MarginLayoutParams)localObject).bottomMargin != paramInt) {
      ((ViewGroup.MarginLayoutParams)localObject).bottomMargin = paramInt;
    }
    if (paramBoolean) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
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
      if ((((AVActivity)localObject).jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) && (((AVActivity)localObject).jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_AndroidViewGestureDetector != null))
      {
        ((AVActivity)localObject).jdField_a_of_type_ComTencentAvUiVideoLayerUI.t = -1;
        ((AVActivity)localObject).jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_AndroidViewGestureDetector.onTouchEvent(paramMotionEvent);
      }
    }
  }
  
  public void a(VideoAppInterface paramVideoAppInterface)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
  }
  
  public void a(VideoLayerUI paramVideoLayerUI, int paramInt)
  {
    int k = 1;
    int m = 0;
    if ((paramInt == 1) && (!b()))
    {
      if ((paramVideoLayerUI != null) && (paramVideoLayerUI.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView.length > 1) && (paramVideoLayerUI.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[1] != null))
      {
        if (paramVideoLayerUI.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[1].a() == 0) {
          i = 1;
        } else {
          i = 0;
        }
        paramInt = paramVideoLayerUI.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[1].b();
      }
      else
      {
        i = 0;
        paramInt = 0;
      }
      if (i != 0)
      {
        i = paramVideoLayerUI.h();
        if ((i != 1) && (i != 2)) {
          if (i != 3)
          {
            if (i == 4)
            {
              i = 0;
              j = paramInt;
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
    int j = 0;
    int i = paramInt;
    label129:
    paramVideoLayerUI = (ViewGroup.MarginLayoutParams)this.jdField_b_of_type_AndroidWidgetLinearLayout.getLayoutParams();
    paramInt = m;
    if (paramVideoLayerUI.leftMargin != j)
    {
      paramVideoLayerUI.leftMargin = j;
      paramInt = 1;
    }
    if (paramVideoLayerUI.rightMargin != i)
    {
      paramVideoLayerUI.rightMargin = i;
      paramInt = k;
    }
    if ((paramInt != 0) && (getVisibility() == 0)) {
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setLayoutParams(paramVideoLayerUI);
    }
  }
  
  public void a(String paramString)
  {
    Object localObject = VideoChatMessage.a();
    ((VideoChatMessage)localObject).a(1);
    ((VideoChatMessage)localObject).a(paramString);
    ((VideoChatMessage)localObject).b(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
    this.jdField_a_of_type_ComTencentAvUiChatroomChatRoomAdapter.a((VideoChatMessage)localObject);
    this.jdField_a_of_type_AndroidWidgetListView.setSelection(this.jdField_a_of_type_ComTencentAvUiChatroomChatRoomAdapter.getCount() - 1);
    localObject = getContext();
    if ((localObject instanceof AVActivity))
    {
      localObject = (AVActivity)localObject;
      if (((AVActivity)localObject).jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomUIContoller != null) {
        ((AVActivity)localObject).jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomUIContoller.a(paramString);
      }
    }
  }
  
  public void a(List<VideoChatMessage> paramList, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentAvUiChatroomChatRoomAdapter.a(paramList, paramBoolean);
    this.jdField_a_of_type_AndroidWidgetListView.setSelection(this.jdField_a_of_type_ComTencentAvUiChatroomChatRoomAdapter.getCount() - 1);
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_ComTencentAvUiChatroomEmotionInputDetector.b())
    {
      this.jdField_a_of_type_ComTencentAvUiChatroomEmotionInputDetector.b();
      return true;
    }
    if (this.jdField_a_of_type_ComTencentAvUiChatroomEmotionInputDetector.c())
    {
      this.jdField_a_of_type_ComTencentAvUiChatroomEmotionInputDetector.c();
      return true;
    }
    return false;
  }
  
  public void b(int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    if ((paramInt2 == 2) && (paramInt3 == 7)) {
      a(this.jdField_a_of_type_Int);
    }
  }
  
  public boolean b()
  {
    return false;
  }
  
  public boolean c()
  {
    EmotionInputDetector localEmotionInputDetector = this.jdField_a_of_type_ComTencentAvUiChatroomEmotionInputDetector;
    return (localEmotionInputDetector != null) && (localEmotionInputDetector.c());
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    View localView = ((AVActivity)getContext()).findViewById(2131373377);
    boolean bool1 = false;
    int i;
    if (localView != null) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      this.jdField_a_of_type_ComTencentAvUiChatroomEmotionInputDetector.a();
      if (QLog.isColorLevel()) {
        QLog.w("ChatRoomUtil", 2, "doodle hase show, so not accept dispatchEvent");
      }
    }
    else if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a().w)
    {
      this.jdField_a_of_type_ComTencentAvUiChatroomEmotionInputDetector.a();
      a(119, Integer.valueOf(2));
    }
    else
    {
      if (!VideoController.a().a().az) {
        break label123;
      }
      TipsUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1022, 2131695752);
    }
    return false;
    label123:
    boolean bool2 = super.dispatchTouchEvent(paramMotionEvent);
    if ((!bool2) && (this.jdField_a_of_type_ComTencentAvUiChatroomEmotionInputDetector.c()))
    {
      paramMotionEvent = (InputMethodManager)getContext().getSystemService("input_method");
      if (paramMotionEvent != null) {
        bool1 = paramMotionEvent.isActive();
      }
      this.jdField_a_of_type_ComTencentAvUiChatroomEmotionInputDetector.c();
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
    else if ((!bool2) && (this.jdField_a_of_type_ComTencentAvUiChatroomEmotionInputDetector.b()))
    {
      this.jdField_a_of_type_ComTencentAvUiChatroomEmotionInputDetector.b();
    }
    return bool2;
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
      EmotionInputDetector localEmotionInputDetector = this.jdField_a_of_type_ComTencentAvUiChatroomEmotionInputDetector;
      if (localEmotionInputDetector != null)
      {
        if (localEmotionInputDetector.b())
        {
          this.jdField_a_of_type_ComTencentAvUiChatroomEmotionInputDetector.b();
          return;
        }
        this.jdField_a_of_type_ComTencentAvUiChatroomEmotionInputDetector.c();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.chatroom.VideoChatRoomContainer
 * JD-Core Version:    0.7.0.1
 */