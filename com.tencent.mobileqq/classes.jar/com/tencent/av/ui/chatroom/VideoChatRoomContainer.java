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
import android.view.ViewGroup.MarginLayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.RelativeLayout;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.VideoControlUI;
import com.tencent.av.ui.VideoLayerUI;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonPanelWithActionBar;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import lcg;
import lga;
import lhr;
import lks;
import mao;
import mdz;
import mma;
import mmb;
import mmh;
import mmi;
import mmk;

public class VideoChatRoomContainer
  extends RelativeLayout
  implements mmh
{
  private int jdField_a_of_type_Int;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  protected ListView a;
  VideoAppInterface jdField_a_of_type_ComTencentAvAppVideoAppInterface;
  private SystemAndEmojiEmoticonPanelWithActionBar jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanelWithActionBar;
  private mma jdField_a_of_type_Mma;
  private mmb jdField_a_of_type_Mmb;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
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
    View localView = LayoutInflater.from(paramContext).inflate(2131559508, this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView.findViewById(2131368899));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView.findViewById(2131364708));
    this.jdField_a_of_type_Mma = new mma(paramContext);
    this.jdField_a_of_type_AndroidWidgetListView = ((ListView)this.jdField_b_of_type_AndroidWidgetLinearLayout.findViewById(16908298));
    this.jdField_a_of_type_AndroidWidgetListView.setAdapter(this.jdField_a_of_type_Mma);
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_b_of_type_AndroidWidgetLinearLayout.findViewById(2131368189));
    this.jdField_a_of_type_AndroidWidgetEditText.setFilters(new InputFilter[] { new InputFilter.LengthFilter(40) });
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidWidgetLinearLayout.findViewById(2131365623));
    this.c = ((LinearLayout)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131365629));
    setFitsSystemWindows(true);
  }
  
  private void c(Context paramContext)
  {
    this.jdField_a_of_type_Mmb = mmb.a((Activity)paramContext).a(this).a((VideoChatRoomListView)this.jdField_a_of_type_AndroidWidgetListView).a(this.jdField_a_of_type_AndroidWidgetEditText).a(this.jdField_a_of_type_AndroidWidgetImageView).a();
    paramContext = new LinearLayout.LayoutParams(-1, -1);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanelWithActionBar = new SystemAndEmojiEmoticonPanelWithActionBar(getContext(), this.jdField_a_of_type_Mmb);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanelWithActionBar.setBackgroundColor(-1);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanelWithActionBar.setId(2131372226);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanelWithActionBar.setVisibility(0);
    this.c.addView(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanelWithActionBar, paramContext);
    this.jdField_a_of_type_Mmb.a(this.c);
  }
  
  public int a()
  {
    int j = 0;
    int i;
    if (this.jdField_a_of_type_Mmb.b()) {
      i = this.c.getHeight();
    }
    do
    {
      do
      {
        return i;
        i = j;
      } while (!this.jdField_a_of_type_Mmb.c());
      i = j;
    } while (this.jdField_a_of_type_Mmb.jdField_a_of_type_Boolean);
    return lks.jdField_a_of_type_Int;
  }
  
  public void a(int paramInt)
  {
    boolean bool2 = true;
    int n = 0;
    boolean bool1 = this.jdField_a_of_type_Mmb.a();
    int i;
    int j;
    label42:
    AVActivity localAVActivity;
    int k;
    if (this.jdField_a_of_type_Boolean != bool1)
    {
      i = 1;
      this.jdField_a_of_type_Boolean = bool1;
      if (this.jdField_a_of_type_Int == paramInt) {
        break label227;
      }
      j = 1;
      this.jdField_a_of_type_Int = paramInt;
      localAVActivity = null;
      Context localContext = getContext();
      if (!(localContext instanceof AVActivity)) {
        break label254;
      }
      localAVActivity = (AVActivity)localContext;
      k = localAVActivity.c();
      if (this.jdField_b_of_type_Int == k) {
        break label232;
      }
      paramInt = 1;
      label89:
      this.jdField_b_of_type_Int = k;
    }
    for (int m = paramInt;; m = 0)
    {
      bool1 = bool2;
      if (i == 0)
      {
        bool1 = bool2;
        if (j == 0)
        {
          if (m == 0) {
            break label237;
          }
          bool1 = bool2;
        }
      }
      label123:
      paramInt = this.jdField_a_of_type_Int;
      i = this.jdField_a_of_type_Mmb.a();
      if ((i != 0) && (i != 7))
      {
        paramInt = n;
        if (this.jdField_a_of_type_Mmb.jdField_a_of_type_Boolean)
        {
          if (i != 4) {
            break label243;
          }
          paramInt = n;
        }
      }
      for (;;)
      {
        a(paramInt, bool1);
        if ((localAVActivity != null) && (m != 0)) {
          a(localAVActivity.jdField_a_of_type_ComTencentAvUiVideoLayerUI, k);
        }
        if ((bool1) && (localAVActivity != null) && (localAVActivity.jdField_a_of_type_ComTencentAvUiVideoControlUI != null)) {
          localAVActivity.jdField_a_of_type_ComTencentAvUiVideoControlUI.O();
        }
        return;
        i = 0;
        break;
        label227:
        j = 0;
        break label42;
        label232:
        paramInt = 0;
        break label89;
        label237:
        bool1 = false;
        break label123;
        label243:
        paramInt = this.jdField_a_of_type_Int;
      }
      label254:
      k = 1;
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    a(this.jdField_a_of_type_Int);
  }
  
  public void a(int paramInt, long paramLong)
  {
    if (this.jdField_a_of_type_Mmb == null) {
      return;
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      post(new VideoChatRoomContainer.1(this, paramInt, paramLong));
      return;
      a(0, false);
      continue;
      a(this.jdField_a_of_type_Int, false);
    }
  }
  
  protected void a(int paramInt, Object paramObject)
  {
    lcg.c("VideoChatRoomContainer", "notifyEvent :" + paramInt + "|" + paramObject);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(paramInt), paramObject });
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
    if (localMarginLayoutParams.bottomMargin != paramInt) {
      localMarginLayoutParams.bottomMargin = paramInt;
    }
    if (paramBoolean) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams(localMarginLayoutParams);
    }
    if (QLog.isDevelopLevel()) {
      QLog.i("ChatRoomUtil", 4, "updateContextViewLayoutBottomMargin, bottomMargin[" + paramInt + "], forceRequestLayout[" + paramBoolean + "]");
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
        ((AVActivity)localObject).jdField_a_of_type_ComTencentAvUiVideoLayerUI.q = -1;
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
    int j = 0;
    int i;
    label65:
    label121:
    int m;
    if (paramInt == 1)
    {
      if (b())
      {
        paramInt = 0;
        i = 0;
        paramVideoLayerUI = (ViewGroup.MarginLayoutParams)this.jdField_b_of_type_AndroidWidgetLinearLayout.getLayoutParams();
        if (paramVideoLayerUI.leftMargin != i)
        {
          paramVideoLayerUI.leftMargin = i;
          j = 1;
        }
        if (paramVideoLayerUI.rightMargin == paramInt) {
          break label243;
        }
        paramVideoLayerUI.rightMargin = paramInt;
        paramInt = k;
        if ((paramInt != 0) && (getVisibility() == 0)) {
          this.jdField_b_of_type_AndroidWidgetLinearLayout.setLayoutParams(paramVideoLayerUI);
        }
        return;
      }
      if ((paramVideoLayerUI == null) || (paramVideoLayerUI.jdField_a_of_type_ArrayOfMdz.length <= 1) || (paramVideoLayerUI.jdField_a_of_type_ArrayOfMdz[1] == null)) {
        break label249;
      }
      if (paramVideoLayerUI.jdField_a_of_type_ArrayOfMdz[1].a() == 0)
      {
        paramInt = 1;
        m = paramVideoLayerUI.jdField_a_of_type_ArrayOfMdz[1].b();
        i = paramInt;
      }
    }
    for (paramInt = m;; paramInt = 0)
    {
      if (i != 0) {}
      switch (paramVideoLayerUI.g())
      {
      default: 
        paramInt = 0;
        i = 0;
      }
      for (;;)
      {
        break;
        paramInt = 0;
        break label121;
        paramInt = 0;
        i = 0;
        continue;
        i = paramInt;
        paramInt = 0;
        continue;
        i = 0;
      }
      if (paramInt == 3)
      {
        paramInt = 0;
        i = 0;
        break;
      }
      if (paramInt == 4)
      {
        paramInt = 0;
        i = 0;
        break;
      }
      if (paramInt == 2) {}
      paramInt = 0;
      i = 0;
      break;
      label243:
      paramInt = j;
      break label65;
      label249:
      i = 0;
    }
  }
  
  public void a(String paramString)
  {
    Object localObject = mmi.a();
    ((mmi)localObject).a(1);
    ((mmi)localObject).a(paramString);
    ((mmi)localObject).b(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
    this.jdField_a_of_type_Mma.a((mmi)localObject);
    this.jdField_a_of_type_AndroidWidgetListView.setSelection(this.jdField_a_of_type_Mma.getCount() - 1);
    localObject = getContext();
    if ((localObject instanceof AVActivity))
    {
      localObject = (AVActivity)localObject;
      if (((AVActivity)localObject).jdField_a_of_type_Mmk != null) {
        ((AVActivity)localObject).jdField_a_of_type_Mmk.a(paramString);
      }
    }
  }
  
  public void a(List<mmi> paramList, boolean paramBoolean)
  {
    this.jdField_a_of_type_Mma.a(paramList, paramBoolean);
    this.jdField_a_of_type_AndroidWidgetListView.setSelection(this.jdField_a_of_type_Mma.getCount() - 1);
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_Mmb.b())
    {
      this.jdField_a_of_type_Mmb.e();
      return true;
    }
    if (this.jdField_a_of_type_Mmb.c())
    {
      this.jdField_a_of_type_Mmb.f();
      return true;
    }
    return false;
  }
  
  public boolean b()
  {
    return (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(3)) && (((lhr)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(3)).a() != null);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (((AVActivity)getContext()).findViewById(2131372242) != null) {}
    for (int i = 1; i != 0; i = 0)
    {
      this.jdField_a_of_type_Mmb.a();
      if (QLog.isColorLevel()) {
        QLog.w("ChatRoomUtil", 2, "doodle hase show, so not accept dispatchEvent");
      }
      return false;
    }
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a().w)
    {
      this.jdField_a_of_type_Mmb.a();
      a(119, Integer.valueOf(2));
      return false;
    }
    if (VideoController.a().a().A)
    {
      mao.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1022, 2131696054);
      return false;
    }
    boolean bool2 = super.dispatchTouchEvent(paramMotionEvent);
    if ((!bool2) && (this.jdField_a_of_type_Mmb.c()))
    {
      paramMotionEvent = (InputMethodManager)getContext().getSystemService("input_method");
      if (paramMotionEvent == null) {
        break label234;
      }
    }
    label234:
    for (boolean bool1 = paramMotionEvent.isActive();; bool1 = false)
    {
      this.jdField_a_of_type_Mmb.f();
      if (QLog.isColorLevel()) {
        QLog.w("ChatRoomUtil", 2, "dispatchTouchEvent, 拦截了touch消息, isSoftInputActive[" + bool1 + "]");
      }
      return bool2;
      if ((!bool2) && (this.jdField_a_of_type_Mmb.b())) {
        this.jdField_a_of_type_Mmb.e();
      }
      return bool2;
    }
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
    if ((getVisibility() == 8) && (this.jdField_a_of_type_Mmb != null))
    {
      if (this.jdField_a_of_type_Mmb.b()) {
        this.jdField_a_of_type_Mmb.e();
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_Mmb.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.ui.chatroom.VideoChatRoomContainer
 * JD-Core Version:    0.7.0.1
 */